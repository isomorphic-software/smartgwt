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

import java.util.*;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * HTML5-based charting engine, implementing most  chartTypes of the
 *  Chart interface.
 *  <P>
 * Can be used directly, or specified as {@link com.smartgwt.client.widgets.grid.ListGrid#getChartConstructor
 * chartConstructor} or
 *  {@link com.smartgwt.client.widgets.cube.CubeGrid#getChartConstructor chartConstructor}.
 *  <P>
 * To create a FacetChart, set {@link com.smartgwt.client.widgets.chart.FacetChart#getFacets facets} to an Array of Facet
 * objects describing the
 * chart dimensions and {@link com.smartgwt.client.widgets.chart.FacetChart#getValueProperty valueProperty} to value field
 * name. For example:
 *  
 *  
 *  <code>
 *  <pre>
 *  // Creating data
 *  Record sprRec = new Record();
 *  sprRec.setAttribute("season", "Spring");
 *  sprRec.setAttribute("temp", "79");
 *  Record sumRec = new Record();
 *  sumRec.setAttribute("season", "Summer");
 *  sumRec.setAttribute("temp", "102");
 *  Record autRec = new Record();
 *  autRec.setAttribute("season", "Autumn");
 *  autRec.setAttribute("temp", "81");
 *  Record winRec = new Record();
 *  winRec.setAttribute("season", "Winter");
 *  winRec.setAttribute("temp", "59");
 *  
 *  // Creating chart
 *  FacetChart chart = new FacetChart();
 *  chart.setFacets(new Facet("season", "Season"));
 *  chart.setValueProperty("temp");
 *  chart.setData(new Record[]{sprRec, sumRec, autRec, winRec});
 *  chart.setTitle("Average temperature in Las Vegas");
 *  </pre>
 *  </code>
 *  
 *  "Inlined facet" is another method to provide data to the chart. <code>data</code> is a single CellRecord or
 *  Array of CellRecords where each record contains multiple data values.  In this case, one facet definition
 *  is considered "inlined", meaning that the facetValueIds from this facet appear as properties in each
 *  record, and each such property holds one data value. For example:
 *  
 *  
 *  <code>
 *  <pre>
 *  // Creating data
 *  CellRecord lvRec = new CellRecord();
 *  lvRec.setAttribute("spring", "79");
 *  lvRec.setAttribute("summer", "102");
 *  lvRec.setAttribute("autumn", "81");
 *  lvRec.setAttribute("winter", "59");
 *  
 *  // Creating inlined facet
 *  Facet inlinedFacet = new Facet();
 *  inlinedFacet.setInlinedValues(true);
 *  inlinedFacet.setValues(
 *          new FacetValue("spring", "Spring"),
 *          new FacetValue("summer", "Summer"),
 *          new FacetValue("autumn", "Autumn"),
 *          new FacetValue("winter", "Winter"));
 *  
 *  // Creating chart
 *  FacetChart chart = new FacetChart();
 *  chart.setFacets(inlinedFacet);
 *  chart.setData(new Record[]{lvRec});
 *  chart.setTitle("Average temperature in Las Vegas");
 *  </pre>
 *  </code>
 *  Example with two facets:
 *  <code>
 *  <pre>
 *  // Creating data
 *  CellRecord lvRec = new CellRecord();
 *  lvRec.setAttribute("city", "Las Vegas");
 *  lvRec.setAttribute("spring", "79");
 *  lvRec.setAttribute("summer", "102");
 *  lvRec.setAttribute("autumn", "81");
 *  lvRec.setAttribute("winter", "59");
 *  CellRecord nyRec = new CellRecord();
 *  nyRec.setAttribute("city", "New York");
 *  nyRec.setAttribute("spring", "60");
 *  nyRec.setAttribute("summer", "83");
 *  nyRec.setAttribute("autumn", "66");
 *  nyRec.setAttribute("winter", "40");
 *  
 *  // Creating inlined facet
 *  Facet inlinedFacet = new Facet();
 *  inlinedFacet.setInlinedValues(true);
 *  inlinedFacet.setValues(
 *          new FacetValue("spring", "Spring"),
 *          new FacetValue("summer", "Summer"),
 *          new FacetValue("autumn", "Autumn"),
 *          new FacetValue("winter", "Winter"));
 *  
 *  // Creating chart
 *  FacetChart chart = new FacetChart();
 *  chart.setFacets(inlinedFacet, new Facet("city", "City"));
 *  chart.setData(new Record[]{lvRec, nyRec});
 *  chart.setStacked(false);
 *  chart.setTitle("Average temperatures");
 *  </pre>
 *  </code>
 *  
 *  <P>
 *  In order to use this component, you must load the Drawing module (ISC_Drawing.js) before
 *  loading the Charts module (ISC_Charts.js).
 */
public class FacetChart extends Canvas {

    public static FacetChart getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (FacetChart) obj;
        } else {
            return new FacetChart(jsObj);
        }
    }

    public FacetChart(){
        scClassName = "FacetChart";
    }

    public FacetChart(JavaScriptObject jsObj){
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
     * Whether to automatically rotate labels if needed in order to make them legible and non-overlapping.
     *
     * @param autoRotateLabels autoRotateLabels Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAutoRotateLabels(Boolean autoRotateLabels)  throws IllegalStateException {
        setAttribute("autoRotateLabels", autoRotateLabels, false);
    }

    /**
     * Whether to automatically rotate labels if needed in order to make them legible and non-overlapping.
     *
     *
     * @return Boolean
     */
    public Boolean getAutoRotateLabels()  {
        return getAttributeAsBoolean("autoRotateLabels");
    }

    /**
     * Distance between bars.  May be reduced if bars would be smaller than {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinBarThickness minBarThickness}.
     *
     * @param barMargin barMargin Default value is 4
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setBarMargin(int barMargin)  throws IllegalStateException {
        setAttribute("barMargin", barMargin, false);
    }

    /**
     * Distance between bars.  May be reduced if bars would be smaller than {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinBarThickness minBarThickness}.
     *
     *
     * @return int
     */
    public int getBarMargin()  {
        return getAttributeAsInt("barMargin");
    }

    /**
     * Margin around the main chart rect: between title and chart, between chart and axis labels, and chart rect and right edge
     * of chart.
     *
     * @param chartRectMargin chartRectMargin Default value is 5
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setChartRectMargin(int chartRectMargin)  throws IllegalStateException {
        setAttribute("chartRectMargin", chartRectMargin, false);
    }

    /**
     * Margin around the main chart rect: between title and chart, between chart and axis labels, and chart rect and right edge
     * of chart.
     *
     *
     * @return int
     */
    public int getChartRectMargin()  {
        return getAttributeAsInt("chartRectMargin");
    }

    /**
     * See {@link com.smartgwt.client.types.ChartType} for a list of known types - Column, Bar, Line, Pie, Doughnut, Area, and
     * Radar charts are supported.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Method to change the current {@link com.smartgwt.client.widgets.chart.FacetChart#getChartType chartType}. Will redraw the chart if drawn.  Will use default settings for the new chart type for {@link com.smartgwt.client.widgets.chart.FacetChart#getStacked stacked}  and {@link com.smartgwt.client.widgets.chart.FacetChart#getFilled filled} if those values are null.
     *
     * @param chartType new chart type. Default value is "Column"
     */
    public void setChartType(ChartType chartType) {
        setAttribute("chartType", chartType.getValue(), true);
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
     * For clustered charts, ratio between margins between individual bars and margins between clusters.
     *
     * @param clusterMarginRatio clusterMarginRatio Default value is 4
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setClusterMarginRatio(float clusterMarginRatio)  throws IllegalStateException {
        setAttribute("clusterMarginRatio", clusterMarginRatio, false);
    }

    /**
     * For clustered charts, ratio between margins between individual bars and margins between clusters.
     *
     *
     * @return float
     */
    public float getClusterMarginRatio()  {
        return getAttributeAsFloat("clusterMarginRatio");
    }

    /**
     * An array of colors to use for a series of visual elements representing data (eg columns, bars, pie slices), any of which
     * may be adjacent to any other. <P> Colors must be in the format of a leading hash (#) plus 6 hexadecimal digits, for
     * example,  "#FFFFFF" is white, "#FF0000" is pure red.
     *
     * @param dataColors dataColors Default value is see below
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDataColors(String... dataColors)  throws IllegalStateException {
        setAttribute("dataColors", dataColors, false);
    }

    /**
     * An array of colors to use for a series of visual elements representing data (eg columns, bars, pie slices), any of which
     * may be adjacent to any other. <P> Colors must be in the format of a leading hash (#) plus 6 hexadecimal digits, for
     * example,  "#FFFFFF" is white, "#FF0000" is pure red.
     *
     *
     * @return String
     */
    public String[] getDataColors()  {
        return getAttributeAsStringArray("dataColors");
    }

    /**
     * For rectangular charts (bar, column, line), margin around the inside of the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getChartRect chartRect}, so that data elements are not flush to edge.
     *
     * @param dataMargin dataMargin Default value is 10
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDataMargin(int dataMargin)  throws IllegalStateException {
        setAttribute("dataMargin", dataMargin, false);
    }

    /**
     * For rectangular charts (bar, column, line), margin around the inside of the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getChartRect chartRect}, so that data elements are not flush to edge.
     *
     *
     * @return int
     */
    public int getDataMargin()  {
        return getAttributeAsInt("dataMargin");
    }

    /**
     * Size in pixels for data points drawn for line, area, radar and other chart types.
     *
     * @param dataPointSize dataPointSize Default value is 6
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDataPointSize(int dataPointSize)  throws IllegalStateException {
        setAttribute("dataPointSize", dataPointSize, false);
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
     * Default precision used when formatting float numbers for axis labels
     *
     * @param decimalPrecision decimalPrecision Default value is 2
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDecimalPrecision(int decimalPrecision)  throws IllegalStateException {
        setAttribute("decimalPrecision", decimalPrecision, false);
    }

    /**
     * Default precision used when formatting float numbers for axis labels
     *
     *
     * @return int
     */
    public int getDecimalPrecision()  {
        return getAttributeAsInt("decimalPrecision");
    }

    /**
     * If showing a doughnut hole (see {@link com.smartgwt.client.widgets.chart.FacetChart#getShowDoughnut showDoughnut}),
     * ratio of the size of the doughnut hole to the size of the overall pie chart, as a number between 0 to 1.
     *
     * @param doughnutRatio doughnutRatio Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDoughnutRatio(float doughnutRatio)  throws IllegalStateException {
        setAttribute("doughnutRatio", doughnutRatio, false);
    }

    /**
     * If showing a doughnut hole (see {@link com.smartgwt.client.widgets.chart.FacetChart#getShowDoughnut showDoughnut}),
     * ratio of the size of the doughnut hole to the size of the overall pie chart, as a number between 0 to 1.
     *
     *
     * @return float
     */
    public float getDoughnutRatio()  {
        return getAttributeAsFloat("doughnutRatio");
    }

    /**
     * Whether shapes are filled, for example, whether a multi-series line chart appears as a stack of filled regions as
     * opposed to just multiple lines. <P> If unset, fills will be automatically used when there are multiple facets and
     * stacking is active (so Line and Radar charts will show stacked regions).   <P> You can explicitly set filled:false to
     * create multi-facet Line or Radar charts where translucent regions overlap, or filled:true to fill in a single-facet Line
     * or Radar chart.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Nethod to change {@link com.smartgwt.client.widgets.chart.FacetChart#getFilled filled}. Use null to apply a default value for the current {@link com.smartgwt.client.widgets.chart.FacetChart#getChartType chartType}.
     *
     * @param filled new value. Default value is null
     */
    public void setFilled(Boolean filled) {
        setAttribute("filled", filled, true);
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
     * Padding between each swatch and label pair.
     *
     * @param legendItemPadding legendItemPadding Default value is 5
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setLegendItemPadding(int legendItemPadding)  throws IllegalStateException {
        setAttribute("legendItemPadding", legendItemPadding, false);
    }

    /**
     * Padding between each swatch and label pair.
     *
     *
     * @return int
     */
    public int getLegendItemPadding()  {
        return getAttributeAsInt("legendItemPadding");
    }

    /**
     * Space between the legend and the chart rect or axis labels (whatever the legend is adjacent to.
     *
     * @param legendMargin legendMargin Default value is 10
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setLegendMargin(int legendMargin)  throws IllegalStateException {
        setAttribute("legendMargin", legendMargin, false);
    }

    /**
     * Space between the legend and the chart rect or axis labels (whatever the legend is adjacent to.
     *
     *
     * @return int
     */
    public int getLegendMargin()  {
        return getAttributeAsInt("legendMargin");
    }

    /**
     * Padding around the legend as a whole.
     *
     * @param legendPadding legendPadding Default value is 5
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setLegendPadding(int legendPadding)  throws IllegalStateException {
        setAttribute("legendPadding", legendPadding, false);
    }

    /**
     * Padding around the legend as a whole.
     *
     *
     * @return int
     */
    public int getLegendPadding()  {
        return getAttributeAsInt("legendPadding");
    }

    /**
     * Size of individual color swatches in legend.
     *
     * @param legendSwatchSize legendSwatchSize Default value is 16
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setLegendSwatchSize(int legendSwatchSize)  throws IllegalStateException {
        setAttribute("legendSwatchSize", legendSwatchSize, false);
    }

    /**
     * Size of individual color swatches in legend.
     *
     *
     * @return int
     */
    public int getLegendSwatchSize()  {
        return getAttributeAsInt("legendSwatchSize");
    }

    /**
     * Padding between color swatch and its label.
     *
     * @param legendTextPadding legendTextPadding Default value is 5
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setLegendTextPadding(int legendTextPadding)  throws IllegalStateException {
        setAttribute("legendTextPadding", legendTextPadding, false);
    }

    /**
     * Padding between color swatch and its label.
     *
     *
     * @return int
     */
    public int getLegendTextPadding()  {
        return getAttributeAsInt("legendTextPadding");
    }

    /**
     * When {@link com.smartgwt.client.widgets.chart.FacetChart#getUseLogGradations useLogGradations}, base value for
     * logarithmic gradation lines.  Gradation lines will be shown at every power of this value plus intervening values
     * specified by {@link com.smartgwt.client.widgets.chart.FacetChart#getLogGradations logGradations}.
     *
     * @param logBase logBase Default value is 10
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setLogBase(int logBase)  throws IllegalStateException {
        setAttribute("logBase", logBase, false);
    }

    /**
     * When {@link com.smartgwt.client.widgets.chart.FacetChart#getUseLogGradations useLogGradations}, base value for
     * logarithmic gradation lines.  Gradation lines will be shown at every power of this value plus intervening values
     * specified by {@link com.smartgwt.client.widgets.chart.FacetChart#getLogGradations logGradations}.
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
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setLogScale(Boolean logScale)  throws IllegalStateException {
        setAttribute("logScale", logScale, false);
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
     * Bars will not be drawn over this thickness, instead, margins will be increased.
     *
     * @param maxBarThickness maxBarThickness Default value is 150
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setMaxBarThickness(int maxBarThickness)  throws IllegalStateException {
        setAttribute("maxBarThickness", maxBarThickness, false);
    }

    /**
     * Bars will not be drawn over this thickness, instead, margins will be increased.
     *
     *
     * @return int
     */
    public int getMaxBarThickness()  {
        return getAttributeAsInt("maxBarThickness");
    }

    /**
     * If bars would be smaller than this size, margins are reduced until bars overlap.
     *
     * @param minBarThickness minBarThickness Default value is 4
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setMinBarThickness(int minBarThickness)  throws IllegalStateException {
        setAttribute("minBarThickness", minBarThickness, false);
    }

    /**
     * If bars would be smaller than this size, margins are reduced until bars overlap.
     *
     *
     * @return int
     */
    public int getMinBarThickness()  {
        return getAttributeAsInt("minBarThickness");
    }

    /**
     * Angle where first label is placed in a Pie chart in stacked mode, in degrees.
     *
     * @param pieLabelAngleStart pieLabelAngleStart Default value is 20
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setPieLabelAngleStart(int pieLabelAngleStart)  throws IllegalStateException {
        setAttribute("pieLabelAngleStart", pieLabelAngleStart, false);
    }

    /**
     * Angle where first label is placed in a Pie chart in stacked mode, in degrees.
     *
     *
     * @return int
     */
    public int getPieLabelAngleStart()  {
        return getAttributeAsInt("pieLabelAngleStart");
    }

    /**
     * How far label lines stick out of the pie radius in a Pie chart in stacked mode.
     *
     * @param pieLabelLineExtent pieLabelLineExtent Default value is 7
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setPieLabelLineExtent(int pieLabelLineExtent)  throws IllegalStateException {
        setAttribute("pieLabelLineExtent", pieLabelLineExtent, false);
    }

    /**
     * How far label lines stick out of the pie radius in a Pie chart in stacked mode.
     *
     *
     * @return int
     */
    public int getPieLabelLineExtent()  {
        return getAttributeAsInt("pieLabelLineExtent");
    }

    /**
     * Distance in pixels that radial labels are offset from the outside of the circle.
     *
     * @param radialLabelOffset radialLabelOffset Default value is 5
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setRadialLabelOffset(int radialLabelOffset)  throws IllegalStateException {
        setAttribute("radialLabelOffset", radialLabelOffset, false);
    }

    /**
     * Distance in pixels that radial labels are offset from the outside of the circle.
     *
     *
     * @return int
     */
    public int getRadialLabelOffset()  {
        return getAttributeAsInt("radialLabelOffset");
    }

    /**
     * Whether to show a rectangular shape around the area of the chart where data is plotted.
     *
     * @param showChartRect showChartRect Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowChartRect(Boolean showChartRect)  throws IllegalStateException {
        setAttribute("showChartRect", showChartRect, false);
    }

    /**
     * Whether to show a rectangular shape around the area of the chart where data is plotted.
     *
     *
     * @return Boolean
     */
    public Boolean getShowChartRect()  {
        return getAttributeAsBoolean("showChartRect");
    }

    /**
     * For line charts, whether to show data points for each individual data value. <P> If shown, the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#pointClick FacetChart.pointClick} and {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getPointHoverHTML FacetChart.getPointHoverHTML} APIs can be used to create
     * interactivity.
     *
     * @param showDataPoints showDataPoints Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowDataPoints(Boolean showDataPoints)  throws IllegalStateException {
        setAttribute("showDataPoints", showDataPoints, false);
    }

    /**
     * For line charts, whether to show data points for each individual data value. <P> If shown, the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#pointClick FacetChart.pointClick} and {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getPointHoverHTML FacetChart.getPointHoverHTML} APIs can be used to create
     * interactivity.
     *
     *
     * @return Boolean
     */
    public Boolean getShowDataPoints()  {
        return getAttributeAsBoolean("showDataPoints");
    }

    /**
     * Whether to show a "doughnut hole" in the middle of pie charts.  Defaults to whether chartType is set to "Doughnut"
     * (shown) vs "Pie" (not shown) but can be forced on or off via <code>showDoughnut</code>.
     *
     * @param showDoughnut showDoughnut Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowDoughnut(Boolean showDoughnut)  throws IllegalStateException {
        setAttribute("showDoughnut", showDoughnut, false);
    }

    /**
     * Whether to show a "doughnut hole" in the middle of pie charts.  Defaults to whether chartType is set to "Doughnut"
     * (shown) vs "Pie" (not shown) but can be forced on or off via <code>showDoughnut</code>.
     *
     *
     * @return Boolean
     */
    public Boolean getShowDoughnut()  {
        return getAttributeAsBoolean("showDoughnut");
    }

    /**
     * The legend is automatically shown for charts that need it (generally, multi-series charts) but can be forced off by
     * setting showLegend to false.
     *
     * @param showLegend showLegend Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowLegend(Boolean showLegend)  throws IllegalStateException {
        setAttribute("showLegend", showLegend, false);
    }

    /**
     * The legend is automatically shown for charts that need it (generally, multi-series charts) but can be forced off by
     * setting showLegend to false.
     *
     *
     * @return Boolean
     */
    public Boolean getShowLegend()  {
        return getAttributeAsBoolean("showLegend");
    }

    /**
     * Whether to show gradation labels in radar charts.
     *
     * @param showRadarGradationLabels showRadarGradationLabels Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowRadarGradationLabels(Boolean showRadarGradationLabels)  throws IllegalStateException {
        setAttribute("showRadarGradationLabels", showRadarGradationLabels, false);
    }

    /**
     * Whether to show gradation labels in radar charts.
     *
     *
     * @return Boolean
     */
    public Boolean getShowRadarGradationLabels()  {
        return getAttributeAsBoolean("showRadarGradationLabels");
    }

    /**
     * Whether to automatically show shadows for various charts.
     *
     * @param showShadows showShadows Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowShadows(Boolean showShadows)  throws IllegalStateException {
        setAttribute("showShadows", showShadows, false);
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
     * Whether to show a title.
     *
     * @param showTitle showTitle Default value is true
     */
    public void setShowTitle(String showTitle) {
        setAttribute("showTitle", showTitle, true);
    }

    /**
     * Whether to show a title.
     *
     *
     * @return String
     */
    public String getShowTitle()  {
        return getAttributeAsString("showTitle");
    }

    /**
     * Whether to use stacking for charts where this makes sense (column, area, pie, line and radar charts).  If stacked is not
     * set and two facets are supplied, clustering is assumed. If null (the default), line charts will be unstacked, and others
     * will be stacked.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Method to change {@link com.smartgwt.client.widgets.chart.FacetChart#getStacked stacked}. Use null to apply a default value for the current {@link com.smartgwt.client.widgets.chart.FacetChart#getChartType chartType}.
     *
     * @param stacked new value. Default value is null
     */
    public void setStacked(Boolean stacked) {
        setAttribute("stacked", stacked, true);
    }

    /**
     * Whether to use stacking for charts where this makes sense (column, area, pie, line and radar charts).  If stacked is not
     * set and two facets are supplied, clustering is assumed. If null (the default), line charts will be unstacked, and others
     * will be stacked.
     *
     *
     * @return Boolean
     */
    public Boolean getStacked()  {
        return getAttributeAsBoolean("stacked");
    }

    /**
     * Default styleName for the chart.
     *
     * @param styleName styleName Default value is "scChart"
     */
    public void setStyleName(String styleName) {
        setAttribute("styleName", styleName, true);
    }

    /**
     * Default styleName for the chart.
     *
     *
     * @return String
     */
    public String getStyleName()  {
        return getAttributeAsString("styleName");
    }

    /**
     * Title for the chart as a whole.
     *
     * @param title title Default value is null
     */
    public void setTitle(String title) {
        setAttribute("title", title, true);
    }

    /**
     * Title for the chart as a whole.
     *
     *
     * @return String
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }

    /**
     * Causes the chart to use the colors specified in {@link com.smartgwt.client.widgets.chart.FacetChart#getDataColors
     * dataColors} but specify chart-specific  gradients based on the primary data color per chart type.
     *
     * @param useAutoGradients useAutoGradients Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setUseAutoGradients(Boolean useAutoGradients)  throws IllegalStateException {
        setAttribute("useAutoGradients", useAutoGradients, false);
    }

    /**
     * Causes the chart to use the colors specified in {@link com.smartgwt.client.widgets.chart.FacetChart#getDataColors
     * dataColors} but specify chart-specific  gradients based on the primary data color per chart type.
     *
     *
     * @return Boolean
     */
    public Boolean getUseAutoGradients()  {
        return getAttributeAsBoolean("useAutoGradients");
    }

    /**
     * Whether to use classic logarithmic gradations, where each order of magnitude is shown as a gradation as well as a few
     * intervening lines.   Gradations also begin and end on an order of magnitude.  For example, 1,2,4,6,8,10,20,40,60,80,100.
     * <P> Default gradations can be overridden via {@link com.smartgwt.client.widgets.chart.FacetChart#getLogBase logBase} and
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getLogGradations logGradations}.
     *
     * @param useLogGradations useLogGradations Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setUseLogGradations(Boolean useLogGradations)  throws IllegalStateException {
        setAttribute("useLogGradations", useLogGradations, false);
    }

    /**
     * Whether to use classic logarithmic gradations, where each order of magnitude is shown as a gradation as well as a few
     * intervening lines.   Gradations also begin and end on an order of magnitude.  For example, 1,2,4,6,8,10,20,40,60,80,100.
     * <P> Default gradations can be overridden via {@link com.smartgwt.client.widgets.chart.FacetChart#getLogBase logBase} and
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getLogGradations logGradations}.
     *
     *
     * @return Boolean
     */
    public Boolean getUseLogGradations()  {
        return getAttributeAsBoolean("useLogGradations");
    }

    /**
     * Property in each record that holds a data value. <P> Not used if there is an inline facet, see  data.
     *
     * @param valueProperty valueProperty Default value is "_value"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setValueProperty(String valueProperty)  throws IllegalStateException {
        setAttribute("valueProperty", valueProperty, false);
    }

    /**
     * Property in each record that holds a data value. <P> Not used if there is an inline facet, see  data.
     *
     *
     * @return String
     */
    public String getValueProperty()  {
        return getAttributeAsString("valueProperty");
    }

    /**
     * A label for the data values, such as "Sales in Thousands", typically used as the label for the value axis.
     *
     * @param valueTitle valueTitle Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setValueTitle(String valueTitle)  throws IllegalStateException {
        setAttribute("valueTitle", valueTitle, false);
    }

    /**
     * A label for the data values, such as "Sales in Thousands", typically used as the label for the value axis.
     *
     *
     * @return String
     */
    public String getValueTitle()  {
        return getAttributeAsString("valueTitle");
    }

    // ********************* Methods ***********************
            
    /**
     * Get a color from the {@link com.smartgwt.client.widgets.chart.FacetChart#getDataColors dataColors} Array <P> Override to
     * provide a dynamic color generation scheme.
     * @param index index of the visual element to be colored
     *
     * @return 
     */
    public native String getDataColor(int index) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getDataColor(index);
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
     * @param facetChartProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(FacetChart facetChartProperties) /*-{
    	var properties = $wnd.isc.addProperties({},facetChartProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.FacetChart.addProperties(properties);
    }-*/;
        
    // ***********************************************************        


	 /**
     * Dataset for this chart.&#010 <P>
     * Data should be specified as an array of Records where each record contains one data value.
     * Each record also contains a property named after each facetId&#010 whose value is a facetValueId 
     * from that facet.&#010 <p>&#010 For example, with
     * a facet with id "regions" and facetValues "west", "north" and "east", and&#010 with {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getValueProperty valueProperty} with it's default value
     *  "_value", the
     * <code>data</code> property&#010 could be:&#010 <pre>&#010    isc.Chart.create({&#010       facets:[{ id:"regions"
     * }],&#010       data : [&#010          {regions:"west", _value:4},&#010          {regions:"north", _value:2},&#010       
     * {regions:"east", _value:5}&#010       ]&#010    })</pre>&#010 If there were a second facet with id "product" and
     * facetValues "cars" and "trucks", a Chart&#010 with a complete set of values would be:&#010 <pre>&#010   
     * isc.Chart.create({&#010       facets:[{ id:"regions" }, { id:"product" }],&#010       data : [&#010         
     * {product:"cars", regions:"west", _value:4},&#010          {product:"cars", regions:"north", _value:2},&#010         
     * {product:"cars", regions:"east", _value:5},&#010          {product:"trucks", regions:"west", _value:1},&#010         
     * {product:"trucks", regions:"north", _value:9},&#010          {product:"trucks", regions:"east", _value:3}&#010      
     * ]&#010    })</pre>&#010 This 2 facet (or "2 dimensional") dataset, if rendered as a bar chart, would use stacked or&#010
     * clustered bars and a legend.&#010
     *
     * @param data data Default value is null
     */
    public void setData(Record[] records) {
        setAttribute("data", records, true);
    }
    public void setData(RecordList records) {
    	setAttribute("data", records == null ? null : records.getJsObj(), true);
    }
    
    public Record[] getRecords() {
    	 return convertToRecordArray(getAttributeAsJavaScriptObject("data"));
    }
    private static Record[] convertToRecordArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new Record[]{};
        }
        JavaScriptObject[] componentsj = JSOHelper.toArray(nativeArray);
        Record[] objects = new Record[componentsj.length];
        for (int i = 0; i < componentsj.length; i++) {
            JavaScriptObject componentJS = componentsj[i];
            Record obj = (Record) RefDataClass.getRef(componentJS);
            if (obj == null) obj = new Record(componentJS);
            objects[i] = obj;
        }
        return objects;
    }
    public RecordList getDataAsRecordList() {
        JavaScriptObject dataJS = getAttributeAsJavaScriptObject("data");
        if(dataJS == null) return null;
        return new RecordList(dataJS);
    }

    /**
     * Set the facets for this chart. These are exactly analgous to {@link com.smartgwt.client.widgets.cube.CubeGrid#setFacets,CubetGrid facets} except that:
     * <ul>
     * <li> the "inlinedValues" property can be set on a facet to change data representation as
     * described under +link{chart.data}.
     * <li> for a non-inlined facet, Charts support auto-derivation of facetValues from the data.
     * </ul>
     * @param facets 
     */
    public void setFacets(Facet... facets) {
        setAttribute("facets", facets, false);
    }
    
    /**
     * Display custom HTML when {@link com.smartgwt.client.widgets.chart.FacetChart#getShowDataPoints showDataPoints} is true and the mouse hovers
     * over a point.
     * @param hoverCustomizer 
     */
    public native void setPointHoverCustomizer(ChartPointHoverCustomizer hoverCustomizer) /*-{
    
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self =  this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
             self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        self.getPointHoverHTML = $debox($entry(function(value, record) {
            var recordJ = @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            var valueJ = @java.lang.Float::new(Ljava/lang/String;)("" + value);
           
            return hoverCustomizer.@com.smartgwt.client.widgets.chart.ChartPointHoverCustomizer::hoverHTML(Ljava/lang/Float;Lcom/smartgwt/client/data/Record;)(valueJ, recordJ);
        }));
     
    }-*/;
            
    /**
     * Apply a handler to fire when {@link com.smartgwt.client.widgets.chart.FacetChart#getShowDataPoints showDataPoints} is true, 
     * and the user clicks on a point.
     * @param handler
     */
    public native void setPointClickHandler(ChartPointClickHandler handler) /*-{
		var self;
	    if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
	        self =  this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
	    } else {
	         self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
	    }
	    self.pointClick = $debox($entry(function(value, record) {
	        var recordJ = @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
	        var valueJ = @java.lang.Float::new(Ljava/lang/String;)("" + value);
	        var eventJ = @com.smartgwt.client.widgets.chart.ChartPointClickEvent::new(Ljava/lang/Float;Lcom/smartgwt/client/data/Record;)(valueJ,recordJ);
	        handler.@com.smartgwt.client.widgets.chart.ChartPointClickHandler::onPointClick(Lcom/smartgwt/client/widgets/chart/ChartPointClickEvent;)(eventJ);
	    }));
	
	}-*/;
    
    
    /**
     * When {@link com.smartgwt.client.widgets.chart.FacetChart#getUseLogGradations useLogGradations} is set, gradation lines
     * to show in between powers,&#010 expressed as a series of integer or float values between 0 and {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getLogBase logBase}.&#010 <P>&#010 Some other common possibilities (for
     * base 10):&#010 <pre>&#010    [ 1, 2, 4, 8 ]&#010    [ 5 ]&#010    [ 2.5, 5, 7.5 ]&#010 </pre>&#010 Or base 2:&#010
     * <pre>&#010    [ 0.5, 1, 1.5 ]&#010    [ 1 ]&#010 </pre>
     *
     * @param logGradations logGradations Default value is [ 1,2,4,6,8 ]
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setLogGradations(Float... logGradations)  throws IllegalStateException {
        setAttribute("logGradations", logGradations, false);
    }

    /**
     * When {@link com.smartgwt.client.widgets.chart.FacetChart#getUseLogGradations useLogGradations} is set, gradation lines
     * to show in between powers,&#010 expressed as a series of integer or float values between 0 and {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getLogBase logBase}.&#010 <P>&#010 Some other common possibilities (for
     * base 10):&#010 <pre>&#010    [ 1, 2, 4, 8 ]&#010    [ 5 ]&#010    [ 2.5, 5, 7.5 ]&#010 </pre>&#010 Or base 2:&#010
     * <pre>&#010    [ 0.5, 1, 1.5 ]&#010    [ 1 ]&#010 </pre>
     *
     *
     * @return float
     */
    public Float[] getLogGradations()  {
        return getAttributeAsFloatArray("logGradations");
    }


    
    


}



