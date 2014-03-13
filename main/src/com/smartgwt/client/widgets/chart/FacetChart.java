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
 * HTML5-based charting engine, implementing all  chartTypes of the
 *  Chart interface.
 *  <P>
 * Can be used directly, or specified as {@link com.smartgwt.client.widgets.grid.ListGrid#getChartConstructor
 * chartConstructor} or
 *  {@link com.smartgwt.client.widgets.cube.CubeGrid#getChartConstructor chartConstructor}.
 *  <P>
 *  <b>NOTE:</b> you must load the Drawing and Charts
 *  {@link com.smartgwt.client.docs.LoadingOptionalModules Optional Modules} before you can use FacetChart.   Also, 
 *  the Charts Module is available in Pro Edition or better, please see 
 * <a href='http://www.smartclient.com/product' onclick="window.open('http://www.smartclient.com/product');return
 * false;">smartclient.com/product</a> for licensing 
 *  information.
 *  <P>
 * To create a FacetChart, set {@link com.smartgwt.client.widgets.chart.FacetChart#getFacets facets} to an Array of Facet
 * objects describing the
 * chart dimensions and {@link com.smartgwt.client.widgets.chart.FacetChart#getValueProperty valueProperty} to value field
 * name. For example:
 *  
 *  
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
 *  
 *  <p>
 *  The following SDK examples demonstrate charts with a single facet:
 *  <ul>
 * <li><a href="http://www.smartclient.com/smartgwtee/showcase/#logScalingChart" target="examples">Log Scaling</a>
 * example,</li>
 * <li><a href="http://www.smartclient.com/smartgwtee/showcase/#dataPointsChart" target="examples">Interactive Data
 * Points</a> example, and</li>
 * <li><a href="http://www.smartclient.com/smartgwtee/showcase/#addingNewElements" target="examples">Adding Element</a>
 * example.</li>
 *  </ul>
 *  See the following SDK examples for examples of charts with multiple facets:
 *  <ul>
 * <li><a href="http://www.smartclient.com/smartgwtee/showcase/#simpleChart" target="examples">Simple Chart</a>
 * example,</li>
 * <li><a href="http://www.smartclient.com/smartgwtee/showcase/#multiSeriesChart" target="examples">Multi-Series Chart</a>
 * example, and</li>
 * <li><a href="http://www.smartclient.com/smartgwtee/showcase/#dynamicDataCharting" target="examples">Dynamic Data</a>
 * example.</li>
 *  </ul>
 *  <p>
 *  <h3>the Inlined Facet</h3>
 *  <p>
 *  Having an "inlined facet" is another method to provide data to the chart.  In this case each CellRecord
 *  contains multiple data values; one facet definition is considered "inlined", meaning that
 *  the facetValueIds from this facet appear as properties in each Record, and each such
 *  property holds one data value.  In this case the singular <code>valueProperty</code> is ignored.
 *  For example:
 *  
 *  
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
 *          new FacetValue("winter", "Winter")
 *  );
 *  
 *  // Creating chart
 *  FacetChart chart = new FacetChart();
 *  chart.setFacets(inlinedFacet);
 *  chart.setData(new Record[]{lvRec});
 *  chart.setTitle("Average temperature in Las Vegas");
 *  </pre>
 *  Example with two facets:
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
 *          new FacetValue("winter", "Winter")
 *  );
 *  
 *  // Creating chart
 *  FacetChart chart = new FacetChart();
 *  chart.setFacets(inlinedFacet, new Facet("city", "City"));
 *  chart.setData(new Record[]{lvRec, nyRec});
 *  chart.setStacked(false);
 *  chart.setTitle("Average temperatures");
 *  </pre>
 *  
 *  <P>
 *  <h3>Dual axis or multi-axis charts</h3>
 *  <p>
 *  FacetChart supports drawing multiple vertical axes.  This is commonly used to show values
 *  with different units (for example: sales in dollars, total units shipped) and/or very different
 *  ranges (for example: gross revenue, profit) on the same chart.  Each set of values, referred
 *  to as a "metric", gets its own axis and gradation marks.
 *  <p>
 *  To use multiple axes, you add an additional facet called the "metric facet" that specifies
 *  each axis to be plotted as a facetValueId.  The metric facet is an inlined facet, so as with
 *  inlined facets in general, each CellRecord has a value for each facetValueId of the metric
 * facet.  You then set {@link com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics extraAxisMetrics} to the
 * list of
 *  metrics that should be plotted as additional axes.
 *  <p>
 *  For example, if you were plotting revenue and profit for each month of the year, you would
 *  have one facet named "metric" with facetValueIds "revenue" and "profit" and a second facet
 *  "month".  Each CellRecord would have the revenue and profit for one month, stored under the
 *  properties "revenue" and "profit".  Setting <code>extraAxisMetrics</code> to ["profit"]
 *  would cause plofit to be plotted as the second axis.  See the
 * <a href="http://www.smartclient.com/smartgwtee/showcase/#dualAxisChartMA" target="examples">Dual Axis</a> SDK sample for
 * an example.
 *  <p>
 *  You can have multiple extra axes and the additional axes and gradation tics will be drawn at
 *  increasing distances from the chart.  By default, the first metric is drawn as a column chart
 *  and subsequent metrics are drawn as lines; you can override this via
 *  {@link com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisSettings extraAxisSettings}.  See the
 * <a href="http://www.smartclient.com/smartgwtee/showcase/#threePlusChartMA" target="examples">3+ Axes</a> SDK sample for
 * an example of multiple extra axes.
 *  <p>
 *  Multi-axis, multi-facet charts are also allowed.  Extending the previous example, you might
 *  add a new facet "company", for a total of 3 facets.  Each CellRecord would have "revenue"
 *  and "profit" for one combination of "company" and "month".  The default appearance in this
 *  case would show revenue as clustered columns (one cluster per month, one column per company)
 *  and would show profit as multiple lines (one per company).  See the
 * <a href="http://www.smartclient.com/smartgwtee/showcase/#multiSeriesChartMA" target="examples">Multi-Series</a> SDK
 * sample for an example of a
 *  multi-axis, multi-facet chart.
 *  <p>
 *  <h3>Mixed plots</h3>
 *  In some cases you want to show some data series as one shape and other data series as
 *  another shape <i>but use the same axis</i>.  This is commonly used when one series is of a
 *  fundamentally different kind than the other series (for example, a projection or average)
 *  but still has the same scale.
 *  <p>
 *  To achieve a mixed plot like this, define it as a multi-axis chart as explained above, but
 * set {@link com.smartgwt.client.widgets.chart.MetricSettings#getShowAxis showAxis} false to avoid a second axis
 * appearing, and set
 * {@link com.smartgwt.client.widgets.chart.MetricSettings#getMatchGradations matchGradations} to cause the same gradations
 * to be used for both
 *  plots.
 *  <p>
 * See the <a href="http://www.smartclient.com/smartgwtee/showcase/#mixedPlotsChart" target="examples">Mixed Plots</a> SDK
 * example.
 *  <p>
 *  <h3>Scatter Charts</h3>
 *  <p>
 *  Scatter charts differ from other chart types in that both axes represent continuous numeric
 *  data rather than a discrete set of facet values (like months of the year).  For this reason
 *  Scatter charts use the same concept of a "metric" facet as is used by Dual-Axis charts,
 *  where the metric facet is expected to have exactly two metrics: the
 * {@link com.smartgwt.client.widgets.chart.FacetChart#getXAxisMetric xAxisMetric} and {@link
 * com.smartgwt.client.widgets.chart.FacetChart#getYAxisMetric yAxisMetric}.
 *  <p>
 *  Unlike all other chart types, a scatter plot may be specified with only the metric facet.
 *  However one additional facet can be defined, which allows multiple sets of x,y points to be
 *  drawn in different colors, analogous to the different colors of a multi-series line chart.
 *  <p>
 * See the <a href="http://www.smartclient.com/smartgwtee/showcase/#scatterPlotCharting" target="examples">Scatter Plot</a>
 * SDK example.
 *  <p>
 *  <b>Date values on the X axis</b>
 *  <p>
 *  FacetChart also supports scatter charts where the x-axis represents date- or time-valued
 *  data and the y-axis represents numeric data, as normal.  To enable this mode all records in
 *  the data must have values for the facetValueId of the
 * {@link com.smartgwt.client.widgets.chart.FacetChart#getXAxisMetric xAxisMetric} that are true Date objects, not Strings
 * or
 *  <code>null</code>s.  For these charts, vertical lines are drawn to represent a sequence of
 *  significant datetime values on the x-axis, such as the first day of the month or week.  The
 *  mechanism used to select these Dates and format them into the x-axis labels is the same
 * mechanism used by charts with {@link com.smartgwt.client.widgets.chart.FacetChart#getLabelCollapseMode
 * labelCollapseMode} set to
 *  "time".
 *  <p>
 *  <h3>Notes on printing</h3>
 *  <P>
 *  FacetCharts support printing on all supported desktop browsers.  When using Pro Edition or 
 *  better with the Smart GWT Server Framework installed, charts can also be exported to PDF 
 * via {@link com.smartgwt.client.rpc.RPCManager#exportContent RPCManager.exportContent} or to images via {@link
 * com.smartgwt.client.rpc.RPCManager#exportImage RPCManager.exportImage}.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("FacetChart")
public class FacetChart extends DrawPane implements com.smartgwt.client.widgets.chart.HasChartBackgroundDrawnHandlers, com.smartgwt.client.widgets.chart.HasChartDrawnHandlers, com.smartgwt.client.widgets.chart.HasDataLabelClickHandlers, com.smartgwt.client.widgets.chart.HasDataLabelHoverHandlers, com.smartgwt.client.widgets.chart.HasLegendClickHandlers, com.smartgwt.client.widgets.chart.HasLegendHoverHandlers, com.smartgwt.client.widgets.chart.HasValueClickHandlers, com.smartgwt.client.widgets.chart.HasZoomChangedHandlers {

    public static FacetChart getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new FacetChart(jsObj);
        } else {
            assert refInstance instanceof FacetChart;
            return (FacetChart)refInstance;
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
        $wnd.isc.FacetChart.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
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
        $wnd.isc.FacetChart.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;

    public FacetChart(){
        if("LGPL".equals(SC.getLicenseType())){
			throw new java.lang.IllegalStateException("FacetChart is a part the Charts Module which comes with Pro Edition or better. Please see smartclient.com/product for details on licensing.");
		} else if(SC.hasCharts()==false) {
			throw new java.lang.IllegalStateException("The Charts module must be loaded to use FacetChart.  See the LoadingOptionalModules overview in the \"docs\" package of JavaDoc for instructions.");
        }
        setFormatAxisValueFn();
        scClassName = "FacetChart";
    }

    public FacetChart(JavaScriptObject jsObj){
        scClassName = "FacetChart";
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
     * Whether to automatically rotate labels if needed in order to make them legible and non-overlapping.
     *
     * @param autoRotateLabels  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @deprecated As of Smart GWT 9.0 this property is replaced by the property {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getRotateLabels rotateLabels}.  Setting rotateLabels to "auto" is
     * equivalent to setting autoRotateLabels to <code>true</code>.  Setting rotateLabels to "never" is equivalent to setting
     * autoRotateLabels to <code>false</code>.
     */
    public void setAutoRotateLabels(Boolean autoRotateLabels)  throws IllegalStateException {
        setAttribute("autoRotateLabels", autoRotateLabels, false);
    }

    /**
     * Whether to automatically rotate labels if needed in order to make them legible and non-overlapping.
     *
     * @return Boolean
     * @deprecated As of Smart GWT 9.0 this property is replaced by the property {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getRotateLabels rotateLabels}.  Setting rotateLabels to "auto" is
     * equivalent to setting autoRotateLabels to <code>true</code>.  Setting rotateLabels to "never" is equivalent to setting
     * autoRotateLabels to <code>false</code>.
     */
    public Boolean getAutoRotateLabels()  {
        return getAttributeAsBoolean("autoRotateLabels");
    }

    /**
     * Start value for the primary axis of the chart. <p> Defaults to 0, or to a value that makes good use of vertical space
     * based on {@link com.smartgwt.client.widgets.chart.FacetChart#getMinDataSpreadPercent minDataSpreadPercent}. <p> For
     * multi-axis charts and Scatter charts, the <code>facetChart.axisStartValue</code> affects only the <b>first</b> axis of
     * the chart.  Start values for other axes of multi-axis charts can be set on a per-axis basis via {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#getAxisStartValue axisStartValue}.  For Scatter charts, the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getXAxisStartValue xAxisStartValue} property must be used to set the start
     * value of the x-axis.
     *
     * @param axisStartValue  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAxisStartValue(Double axisStartValue)  throws IllegalStateException {
        setAttribute("axisStartValue", axisStartValue, false);
    }

    /**
     * Start value for the primary axis of the chart. <p> Defaults to 0, or to a value that makes good use of vertical space
     * based on {@link com.smartgwt.client.widgets.chart.FacetChart#getMinDataSpreadPercent minDataSpreadPercent}. <p> For
     * multi-axis charts and Scatter charts, the <code>facetChart.axisStartValue</code> affects only the <b>first</b> axis of
     * the chart.  Start values for other axes of multi-axis charts can be set on a per-axis basis via {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#getAxisStartValue axisStartValue}.  For Scatter charts, the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getXAxisStartValue xAxisStartValue} property must be used to set the start
     * value of the x-axis.
     *
     * @return Double
     */
    public Double getAxisStartValue()  {
        return getAttributeAsDouble("axisStartValue");
    }

    /**
     * Properties for background band
     *
     * @param backgroundBandProperties  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setBackgroundBandProperties(DrawRect backgroundBandProperties)  throws IllegalStateException {
        JavaScriptObject config = backgroundBandProperties == null ? null : backgroundBandProperties.getConfig();
        setAttribute("backgroundBandProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for background band
     *
     * @return DrawRect
     */
    public DrawRect getBackgroundBandProperties()  {
        return DrawRect.getOrCreateRef(getAttributeAsJavaScriptObject("backgroundBandProperties"));
    }

    /**
     * Whether to show alternating color bands in the background of chart.  See {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getBackgroundBandProperties backgroundBandProperties}.
     *
     * @param bandedBackground  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setBandedBackground(Boolean bandedBackground)  throws IllegalStateException {
        setAttribute("bandedBackground", bandedBackground, false);
    }

    /**
     * Whether to show alternating color bands in the background of chart.  See {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getBackgroundBandProperties backgroundBandProperties}.
     *
     * @return Boolean
     */
    public Boolean getBandedBackground()  {
        return getAttributeAsBoolean("bandedBackground");
    }

    /**
     * Whether to show color bands between the {@link com.smartgwt.client.widgets.chart.FacetChart#getStandardDeviations
     * standard deviation} lines. <p> Standard deviation bands are not available for pie or radar charts.
     *
     * @param bandedStandardDeviations  Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.chart.FacetChart#setStandardDeviationBandProperties
     */
    public void setBandedStandardDeviations(Boolean bandedStandardDeviations)  throws IllegalStateException {
        setAttribute("bandedStandardDeviations", bandedStandardDeviations, false);
    }

    /**
     * Whether to show color bands between the {@link com.smartgwt.client.widgets.chart.FacetChart#getStandardDeviations
     * standard deviation} lines. <p> Standard deviation bands are not available for pie or radar charts.
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.chart.FacetChart#getStandardDeviationBandProperties
     */
    public Boolean getBandedStandardDeviations()  {
        return getAttributeAsBoolean("bandedStandardDeviations");
    }

    /**
     * Distance between bars.  May be reduced if bars would be smaller than {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinBarThickness minBarThickness}.
     *
     * @param barMargin  Default value is 4
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setBarMargin(int barMargin)  throws IllegalStateException {
        setAttribute("barMargin", barMargin, false);
    }

    /**
     * Distance between bars.  May be reduced if bars would be smaller than {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinBarThickness minBarThickness}.
     *
     * @return int
     */
    public int getBarMargin()  {
        return getAttributeAsInt("barMargin");
    }

    /**
     * Properties for bar
     *
     * @param barProperties  Default value is null
     */
    public void setBarProperties(DrawRect barProperties) {
        JavaScriptObject config = barProperties == null ? null : barProperties.getConfig();
        setAttribute("barProperties", JSOHelper.cleanProperties(config, true), true);
    }

    /**
     * Properties for bar
     *
     * @return DrawRect
     */
    public DrawRect getBarProperties()  {
        return DrawRect.getOrCreateRef(getAttributeAsJavaScriptObject("barProperties"));
    }

    /**
     * Whether the positions of value axes can be changed.  The default is true for charts with three or more vertical, value
     * axes.
     *
     * @param canMoveAxes  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCanMoveAxes(Boolean canMoveAxes)  throws IllegalStateException {
        setAttribute("canMoveAxes", canMoveAxes, false);
    }

    /**
     * Whether the positions of value axes can be changed.  The default is true for charts with three or more vertical, value
     * axes.
     *
     * @return Boolean
     */
    public Boolean getCanMoveAxes()  {
        return getAttributeAsBoolean("canMoveAxes");
    }

    /**
     * Enables "zooming" on the X axis, specifically, only a portion of the overall dataset is shown in the main chart, and a
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getZoomChart second smaller chart} appears with slider controls
     * allowing a range to be selected for display in the main chart. <P> A {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getLabelCollapseMode labelCollapseMode} is automatically enabled if unset
     * and is based on the type of the first non-null data value.
     *
     * @param canZoom  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCanZoom(Boolean canZoom)  throws IllegalStateException {
        setAttribute("canZoom", canZoom, false);
    }

    /**
     * Enables "zooming" on the X axis, specifically, only a portion of the overall dataset is shown in the main chart, and a
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getZoomChart second smaller chart} appears with slider controls
     * allowing a range to be selected for display in the main chart. <P> A {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getLabelCollapseMode labelCollapseMode} is automatically enabled if unset
     * and is based on the type of the first non-null data value.
     *
     * @return Boolean
     */
    public Boolean getCanZoom()  {
        return getAttributeAsBoolean("canZoom");
    }

    /**
     * Margin around the main chart rect: between title and chart, between chart and axis labels, and chart rect and right edge
     * of chart.
     *
     * @param chartRectMargin  Default value is 5
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setChartRectMargin(int chartRectMargin)  throws IllegalStateException {
        setAttribute("chartRectMargin", chartRectMargin, false);
    }

    /**
     * Margin around the main chart rect: between title and chart, between chart and axis labels, and chart rect and right edge
     * of chart.
     *
     * @return int
     */
    public int getChartRectMargin()  {
        return getAttributeAsInt("chartRectMargin");
    }

    /**
     * Properties for chart rect
     *
     * @param chartRectProperties  Default value is null
     */
    public void setChartRectProperties(DrawRect chartRectProperties) {
        JavaScriptObject config = chartRectProperties == null ? null : chartRectProperties.getConfig();
        setAttribute("chartRectProperties", JSOHelper.cleanProperties(config, true), true);
    }

    /**
     * Properties for chart rect
     *
     * @return DrawRect
     */
    public DrawRect getChartRectProperties()  {
        return DrawRect.getOrCreateRef(getAttributeAsJavaScriptObject("chartRectProperties"));
    }

    /**
     * See {@link com.smartgwt.client.types.ChartType} for a list of known types - Column, Bar, Line, Pie, Doughnut, Area, and
     * Radar charts are supported.
     *
     * <p>If this method is called after the component has been drawn/initialized:
     * Method to change the current {@link com.smartgwt.client.types.ChartType chartType}. Will redraw the chart if drawn.  Will use default settings for the new chart type for {@link com.smartgwt.client.widgets.chart.FacetChart#getStacked stacked} and {@link com.smartgwt.client.widgets.chart.FacetChart#getFilled filled} if those values are null. <p> Note that for {@link com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics multi-axis} charts this method changes the <code>chartType</code> for the main value axis only.
     *
     * @param chartType new chart type. Default value is "Column"
     */
    public void setChartType(ChartType chartType) {
        setAttribute("chartType", chartType == null ? null : chartType.getValue(), true);
    }

    /**
     * See {@link com.smartgwt.client.types.ChartType} for a list of known types - Column, Bar, Line, Pie, Doughnut, Area, and
     * Radar charts are supported.
     *
     * @return ChartType
     */
    public ChartType getChartType()  {
        return EnumUtil.getEnum(ChartType.values(), getAttribute("chartType"));
    }

    /**
     * For clustered charts, ratio between margins between individual bars and margins between clusters.
     *
     * @param clusterMarginRatio  Default value is 4
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setClusterMarginRatio(float clusterMarginRatio)  throws IllegalStateException {
        setAttribute("clusterMarginRatio", clusterMarginRatio, false);
    }

    /**
     * For clustered charts, ratio between margins between individual bars and margins between clusters.
     *
     * @return float
     */
    public float getClusterMarginRatio()  {
        return getAttributeAsFloat("clusterMarginRatio");
    }

    /**
     * Should be set to a number between -100 and 100.  If set, all colors in the chart are "muted" by this percentage by
     * shifting them toward white (or for negative numbers, toward black).
     *
     * @param colorMutePercent  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setColorMutePercent(Float colorMutePercent)  throws IllegalStateException {
        setAttribute("colorMutePercent", colorMutePercent, false);
    }

    /**
     * Should be set to a number between -100 and 100.  If set, all colors in the chart are "muted" by this percentage by
     * shifting them toward white (or for negative numbers, toward black).
     *
     * @return Float
     */
    public Float getColorMutePercent()  {
        return getAttributeAsFloat("colorMutePercent");
    }

    /**
     * Properties for labels of data axis.
     *
     * @param dataAxisLabelProperties  Default value is null
     */
    public void setDataAxisLabelProperties(DrawLabel dataAxisLabelProperties) {
        JavaScriptObject config = dataAxisLabelProperties == null ? null : dataAxisLabelProperties.getConfig();
        setAttribute("dataAxisLabelProperties", JSOHelper.cleanProperties(config, true), true);
    }

    /**
     * Properties for labels of data axis.
     *
     * @return DrawLabel
     */
    public DrawLabel getDataAxisLabelProperties()  {
        return DrawLabel.getOrCreateRef(getAttributeAsJavaScriptObject("dataAxisLabelProperties"));
    }

    /**
     * An array of colors to use for a series of visual elements representing data (eg columns, bars, pie slices), any of which
     * may be adjacent to any other. <P> Colors must be in the format of a leading hash (#) plus 6 hexadecimal digits, for
     * example,  "#FFFFFF" is white, "#FF0000" is pure red.
     *
     * @param dataColors  See {@link com.smartgwt.client.docs.CSSColor CSSColor} . Default value is see below
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
     * @return  See {@link com.smartgwt.client.docs.CSSColor CSSColor} 
     */
    public String[] getDataColors()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("dataColors"));
    }

    /**
     * Properties for data label
     *
     * @param dataLabelProperties  Default value is null
     */
    public void setDataLabelProperties(DrawLabel dataLabelProperties) {
        JavaScriptObject config = dataLabelProperties == null ? null : dataLabelProperties.getConfig();
        setAttribute("dataLabelProperties", JSOHelper.cleanProperties(config, true), true);
    }

    /**
     * Properties for data label
     *
     * @return DrawLabel
     */
    public DrawLabel getDataLabelProperties()  {
        return DrawLabel.getOrCreateRef(getAttributeAsJavaScriptObject("dataLabelProperties"));
    }

    /**
     * Properties for lines that show data (as opposed to gradations or borders around the data area).
     *
     * @param dataLineProperties  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDataLineProperties(DrawLine dataLineProperties)  throws IllegalStateException {
        JavaScriptObject config = dataLineProperties == null ? null : dataLineProperties.getConfig();
        setAttribute("dataLineProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for lines that show data (as opposed to gradations or borders around the data area).
     *
     * @return DrawLine
     */
    public DrawLine getDataLineProperties()  {
        return DrawLine.getOrCreateRef(getAttributeAsJavaScriptObject("dataLineProperties"));
    }

    /**
     * How to draw lines between adjacent data points in Line and Scatter charts. See {@link
     * com.smartgwt.client.types.DataLineType}. <p> Does not apply to boundary lines for shapes in Area or Radar plots.
     *
     * <p>If this method is called after the component has been drawn/initialized:
     * Method to change the current {@link com.smartgwt.client.types.ChartType dataLineType}. Will redraw the chart if drawn.
     *
     * @param dataLineType ow to draw lines between adjacent data points in Line and Scatter charts. Default value is null
     */
    public void setDataLineType(DataLineType dataLineType) {
        setAttribute("dataLineType", dataLineType == null ? null : dataLineType.getValue(), true);
    }

    /**
     * How to draw lines between adjacent data points in Line and Scatter charts. See {@link
     * com.smartgwt.client.types.DataLineType}. <p> Does not apply to boundary lines for shapes in Area or Radar plots.
     *
     * @return DataLineType
     */
    public DataLineType getDataLineType()  {
        return EnumUtil.getEnum(DataLineType.values(), getAttribute("dataLineType"));
    }

    /**
     * For rectangular charts (bar, column, line), margin around the inside of the main chart area, so that data elements are
     * not flush to edge.
     *
     * @param dataMargin  Default value is 10
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDataMargin(int dataMargin)  throws IllegalStateException {
        setAttribute("dataMargin", dataMargin, false);
    }

    /**
     * For rectangular charts (bar, column, line), margin around the inside of the main chart area, so that data elements are
     * not flush to edge.
     *
     * @return int
     */
    public int getDataMargin()  {
        return getAttributeAsInt("dataMargin");
    }

    /**
     * Properties for lines that outline a data shape (in filled charts such as area or radar charts).
     *
     * @param dataOutlineProperties  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDataOutlineProperties(DrawItem dataOutlineProperties)  throws IllegalStateException {
        JavaScriptObject config = dataOutlineProperties == null ? null : dataOutlineProperties.getConfig();
        setAttribute("dataOutlineProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for lines that outline a data shape (in filled charts such as area or radar charts).
     *
     * @return DrawItem
     */
    public DrawItem getDataOutlineProperties()  {
        return DrawItem.getOrCreateRef(getAttributeAsJavaScriptObject("dataOutlineProperties"));
    }

    /**
     * Common properties to apply for all data points (see {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getShowDataPoints showDataPoints}).
     *
     * @param dataPointProperties  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDataPointProperties(DrawItem dataPointProperties)  throws IllegalStateException {
        JavaScriptObject config = dataPointProperties == null ? null : dataPointProperties.getConfig();
        setAttribute("dataPointProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Common properties to apply for all data points (see {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getShowDataPoints showDataPoints}).
     *
     * @return DrawItem
     */
    public DrawItem getDataPointProperties()  {
        return DrawItem.getOrCreateRef(getAttributeAsJavaScriptObject("dataPointProperties"));
    }

    /**
     * Size in pixels for data points drawn for line, area, radar and other chart types.
     *
     * @param dataPointSize  Default value is 5
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDataPointSize(int dataPointSize)  throws IllegalStateException {
        setAttribute("dataPointSize", dataPointSize, false);
    }

    /**
     * Size in pixels for data points drawn for line, area, radar and other chart types.
     *
     * @return int
     */
    public int getDataPointSize()  {
        return getAttributeAsInt("dataPointSize");
    }

    /**
     * Properties for data shapes (filled areas in area or radar charts).
     *
     * @param dataShapeProperties  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDataShapeProperties(DrawPath dataShapeProperties)  throws IllegalStateException {
        JavaScriptObject config = dataShapeProperties == null ? null : dataShapeProperties.getConfig();
        setAttribute("dataShapeProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for data shapes (filled areas in area or radar charts).
     *
     * @return DrawPath
     */
    public DrawPath getDataShapeProperties()  {
        return DrawPath.getOrCreateRef(getAttributeAsJavaScriptObject("dataShapeProperties"));
    }

    /**
     * Default precision used when formatting float numbers for axis labels
     *
     * @param decimalPrecision  Default value is 2
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDecimalPrecision(int decimalPrecision)  throws IllegalStateException {
        setAttribute("decimalPrecision", decimalPrecision, false);
    }

    /**
     * Default precision used when formatting float numbers for axis labels
     *
     * @return int
     */
    public int getDecimalPrecision()  {
        return getAttributeAsInt("decimalPrecision");
    }

    /**
     * Whether to treat non-numeric values in the dataset as indicating a break in the data line.  If set to <code>false</code>
     * then null values are ignored.  Defaults to <code>true</code> for {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getFilled filled} charts and to <code>false</code> for line charts.
     *
     * @param discontinuousLines  Default value is null
     */
    public void setDiscontinuousLines(Boolean discontinuousLines) {
        setAttribute("discontinuousLines", discontinuousLines, true);
    }

    /**
     * Whether to treat non-numeric values in the dataset as indicating a break in the data line.  If set to <code>false</code>
     * then null values are ignored.  Defaults to <code>true</code> for {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getFilled filled} charts and to <code>false</code> for line charts.
     *
     * @return Boolean
     */
    public Boolean getDiscontinuousLines()  {
        return getAttributeAsBoolean("discontinuousLines");
    }

    /**
     * Properties for doughnut hole
     *
     * @param doughnutHoleProperties  Default value is null
     */
    public void setDoughnutHoleProperties(DrawOval doughnutHoleProperties) {
        JavaScriptObject config = doughnutHoleProperties == null ? null : doughnutHoleProperties.getConfig();
        setAttribute("doughnutHoleProperties", JSOHelper.cleanProperties(config, true), true);
    }

    /**
     * Properties for doughnut hole
     *
     * @return DrawOval
     */
    public DrawOval getDoughnutHoleProperties()  {
        return DrawOval.getOrCreateRef(getAttributeAsJavaScriptObject("doughnutHoleProperties"));
    }

    /**
     * If showing a doughnut hole (see {@link com.smartgwt.client.widgets.chart.FacetChart#getShowDoughnut showDoughnut}),
     * ratio of the size of the doughnut hole to the size of the overall pie chart, as a number between 0 to 1.
     *
     * @param doughnutRatio  Default value is 0.2
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDoughnutRatio(float doughnutRatio)  throws IllegalStateException {
        setAttribute("doughnutRatio", doughnutRatio, false);
    }

    /**
     * If showing a doughnut hole (see {@link com.smartgwt.client.widgets.chart.FacetChart#getShowDoughnut showDoughnut}),
     * ratio of the size of the doughnut hole to the size of the overall pie chart, as a number between 0 to 1.
     *
     * @return float
     */
    public float getDoughnutRatio()  {
        return getAttributeAsFloat("doughnutRatio");
    }

    /**
     * This property helps specify the color of the error bars and its value must be a number between -100 and 100.  Error bars
     * have the same color as the data line, but the colors are actually "muted" by this percentage by shifting them toward
     * white (or for negative numbers, toward black).  The default is to darken the data colors by 60% to get the error bar
     * colors.
     *
     * @param errorBarColorMutePercent  Default value is -60
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setErrorBarColorMutePercent(float errorBarColorMutePercent)  throws IllegalStateException {
        setAttribute("errorBarColorMutePercent", errorBarColorMutePercent, false);
    }

    /**
     * This property helps specify the color of the error bars and its value must be a number between -100 and 100.  Error bars
     * have the same color as the data line, but the colors are actually "muted" by this percentage by shifting them toward
     * white (or for negative numbers, toward black).  The default is to darken the data colors by 60% to get the error bar
     * colors.
     *
     * @return float
     */
    public float getErrorBarColorMutePercent()  {
        return getAttributeAsFloat("errorBarColorMutePercent");
    }

    /**
     * Width of the horizontal line of the "T"-shape portion of the error bar).
     *
     * @param errorBarWidth  Default value is 6
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setErrorBarWidth(int errorBarWidth)  throws IllegalStateException {
        setAttribute("errorBarWidth", errorBarWidth, false);
    }

    /**
     * Width of the horizontal line of the "T"-shape portion of the error bar).
     *
     * @return int
     */
    public int getErrorBarWidth()  {
        return getAttributeAsInt("errorBarWidth");
    }

    /**
     * Properties of the lines used to draw error bars (short, horizontal lines at the low and high metric values, and a
     * vertical connecting line). <p> Note that the {@link com.smartgwt.client.widgets.drawing.DrawItem#getLineColor lineColor}
     * property has no effect as the color of the error bars is derived from the color of the data line.
     *
     * @param errorLineProperties  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.chart.FacetChart#setErrorBarColorMutePercent
     */
    public void setErrorLineProperties(DrawLine errorLineProperties)  throws IllegalStateException {
        JavaScriptObject config = errorLineProperties == null ? null : errorLineProperties.getConfig();
        setAttribute("errorLineProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties of the lines used to draw error bars (short, horizontal lines at the low and high metric values, and a
     * vertical connecting line). <p> Note that the {@link com.smartgwt.client.widgets.drawing.DrawItem#getLineColor lineColor}
     * property has no effect as the color of the error bars is derived from the color of the data line.
     *
     * @return DrawLine
     * @see com.smartgwt.client.widgets.chart.FacetChart#getErrorBarColorMutePercent
     */
    public DrawLine getErrorLineProperties()  {
        return DrawLine.getOrCreateRef(getAttributeAsJavaScriptObject("errorLineProperties"));
    }

    /**
     * Properties for the {@link com.smartgwt.client.widgets.chart.FacetChart#getShowExpectedValueLine line drawn at the mean
     * value}. <p> Note that for rectangular charts the properties are for a {@link
     * com.smartgwt.client.widgets.drawing.DrawLine}, and for radar charts the properties are for a {@link
     * com.smartgwt.client.widgets.drawing.DrawOval}.
     *
     * @param expectedValueLineProperties  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setExpectedValueLineProperties(DrawItem expectedValueLineProperties)  throws IllegalStateException {
        JavaScriptObject config = expectedValueLineProperties == null ? null : expectedValueLineProperties.getConfig();
        setAttribute("expectedValueLineProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for the {@link com.smartgwt.client.widgets.chart.FacetChart#getShowExpectedValueLine line drawn at the mean
     * value}. <p> Note that for rectangular charts the properties are for a {@link
     * com.smartgwt.client.widgets.drawing.DrawLine}, and for radar charts the properties are for a {@link
     * com.smartgwt.client.widgets.drawing.DrawOval}.
     *
     * @return DrawItem
     */
    public DrawItem getExpectedValueLineProperties()  {
        return DrawItem.getOrCreateRef(getAttributeAsJavaScriptObject("expectedValueLineProperties"));
    }

    /**
     * Defines the set of metrics that will be plotted as additional vertical axes.  See the main {@link
     * com.smartgwt.client.widgets.chart.FacetChart} docs for an overview of how multi-axis charts are used. <p> Each metric
     * corresponds to different value property of the data records and superimposes its drawn data onto the chart rectangle.
     * The value properties are called metrics, and they can be either the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getValueProperty valueProperty} or the "id" of a {@link
     * com.smartgwt.client.widgets.cube.FacetValue} of the inlined {@link com.smartgwt.client.widgets.cube.Facet} (which is
     * then called the metric facet).  Each value axis has its own gradations that are shown as tick marks along the length of
     * the axis.  This property, extraAxisMetrics, specifies the metrics to use for additional value axes to the main value
     * axis. <p> The additional value axis may have their own gradations, chart type, log scale, data colors and gradients, and
     * other chart properties.  These properties are specified with the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisSettings extraAxisSettings} property. <p> Value axes, including
     * the main value axis, are labelled in the legend along with representations of the charted data.  The labels are taken
     * from the {@link com.smartgwt.client.widgets.cube.FacetValue#getTitle title} of each metric's FacetValue (or the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getValueTitle valueTitle} if the metric is the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getValueProperty valueProperty}). <p> The order of the metrics determines
     * the position of the corresponding axes on the chart as well as the z-ordering of the corresponding data lines. The first
     * and second extra value axes are placed to the right of the chart rectangle, and any remaining extra value axes are
     * placed to the left of the main value axis (and therefore to the left of the chart rectangle).
     *
     * @param extraAxisMetrics  Default value is []
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setExtraAxisMetrics(String... extraAxisMetrics)  throws IllegalStateException {
        setAttribute("extraAxisMetrics", extraAxisMetrics, false);
    }

    /**
     * Defines the set of metrics that will be plotted as additional vertical axes.  See the main {@link
     * com.smartgwt.client.widgets.chart.FacetChart} docs for an overview of how multi-axis charts are used. <p> Each metric
     * corresponds to different value property of the data records and superimposes its drawn data onto the chart rectangle.
     * The value properties are called metrics, and they can be either the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getValueProperty valueProperty} or the "id" of a {@link
     * com.smartgwt.client.widgets.cube.FacetValue} of the inlined {@link com.smartgwt.client.widgets.cube.Facet} (which is
     * then called the metric facet).  Each value axis has its own gradations that are shown as tick marks along the length of
     * the axis.  This property, extraAxisMetrics, specifies the metrics to use for additional value axes to the main value
     * axis. <p> The additional value axis may have their own gradations, chart type, log scale, data colors and gradients, and
     * other chart properties.  These properties are specified with the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisSettings extraAxisSettings} property. <p> Value axes, including
     * the main value axis, are labelled in the legend along with representations of the charted data.  The labels are taken
     * from the {@link com.smartgwt.client.widgets.cube.FacetValue#getTitle title} of each metric's FacetValue (or the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getValueTitle valueTitle} if the metric is the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getValueProperty valueProperty}). <p> The order of the metrics determines
     * the position of the corresponding axes on the chart as well as the z-ordering of the corresponding data lines. The first
     * and second extra value axes are placed to the right of the chart rectangle, and any remaining extra value axes are
     * placed to the left of the main value axis (and therefore to the left of the chart rectangle).
     *
     * @return String...
     */
    public String[] getExtraAxisMetrics()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("extraAxisMetrics"));
    }

    /**
     * For charts will multiple vertical axes, optionally provides settings for how each {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics extra axis metric} is plotted.  See the main {@link
     * com.smartgwt.client.widgets.chart.FacetChart} docs for an overview of how multi-axis charts are used. <p> The chart of
     * each metric's values may be of any rectangular chart type that uses a vertical value axis ("Column", "Area", and
     * "Line").  Because the charts will be superimposed over the same drawing area, there can only be one "Column" chart and
     * one "Area" chart.  The column chart is placed on the bottom followed by the area chart, and then the line charts are
     * drawn on top in the order of their metric in the {@link com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics
     * extraAxisMetrics} array. If the {@link com.smartgwt.client.widgets.chart.MetricSettings#getChartType chartType}s are
     * left unspecified then by default the first metric will be drawn as columns and the remaining will be drawn as lines.
     *
     * @param extraAxisSettings  Default value is []
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setExtraAxisSettings(MetricSettings... extraAxisSettings)  throws IllegalStateException {
        setAttribute("extraAxisSettings", extraAxisSettings, false);
    }

    /**
     * For charts will multiple vertical axes, optionally provides settings for how each {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics extra axis metric} is plotted.  See the main {@link
     * com.smartgwt.client.widgets.chart.FacetChart} docs for an overview of how multi-axis charts are used. <p> The chart of
     * each metric's values may be of any rectangular chart type that uses a vertical value axis ("Column", "Area", and
     * "Line").  Because the charts will be superimposed over the same drawing area, there can only be one "Column" chart and
     * one "Area" chart.  The column chart is placed on the bottom followed by the area chart, and then the line charts are
     * drawn on top in the order of their metric in the {@link com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics
     * extraAxisMetrics} array. If the {@link com.smartgwt.client.widgets.chart.MetricSettings#getChartType chartType}s are
     * left unspecified then by default the first metric will be drawn as columns and the remaining will be drawn as lines.
     *
     * @return MetricSettings...
     */
    public MetricSettings[] getExtraAxisSettings()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfMetricSettings(getAttributeAsJavaScriptObject("extraAxisSettings"));
    }

    /**
     * An Array of facets, exactly analogous to {@link com.smartgwt.client.widgets.cube.CubeGrid#getFacets facets}, except
     * that: <ul> <li> the "inlinedValues" property can be set on a facet to change data representation as described under 
     * data. <li> for a non-inlined facet, Charts support auto-derivation of facetValues from the data. </ul> <p> In all chart
     * types except "Scatter", the chart displays a value for each discrete value of one facet (i.e. single-facet charts) or it
     * displays a value for each combination of discrete values of two facets (multi-facet charts).  The two discrete facets
     * are the {@link com.smartgwt.client.widgets.chart.FacetChart#getDataLabelFacet data label facet} and the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getLegendFacet legend facet}.  They are named based on where the {@link
     * com.smartgwt.client.widgets.cube.Facet#getValues values} of the facet appear in the chart.  The facet whose values are
     * rendered as labels along the data axis or in the main chart area is the data label facet, and the facet whose values are
     * rendered in the legend is the legend facet. <p> For single-facet charts, most chart types have a data label facet as the
     * first facet but no legend facet.  Single-facet Pie charts have a legend facet as the first facet but no data label
     * facet.  Scatter plots may have a legend facet as the second facet, after the metric facet. <p> In all multi-facet
     * charts, the data label facet is always first and the legend facet is second.  In most chart types the data label facet
     * and the legend facet may be swapped on the fly by the user clicking on the "Swap Facets" item of the context menu.
     *
     * @param facets  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setFacets(Facet... facets)  throws IllegalStateException {
        setAttribute("facets", facets, false);
    }

    /**
     * An Array of facets, exactly analogous to {@link com.smartgwt.client.widgets.cube.CubeGrid#getFacets facets}, except
     * that: <ul> <li> the "inlinedValues" property can be set on a facet to change data representation as described under 
     * data. <li> for a non-inlined facet, Charts support auto-derivation of facetValues from the data. </ul> <p> In all chart
     * types except "Scatter", the chart displays a value for each discrete value of one facet (i.e. single-facet charts) or it
     * displays a value for each combination of discrete values of two facets (multi-facet charts).  The two discrete facets
     * are the {@link com.smartgwt.client.widgets.chart.FacetChart#getDataLabelFacet data label facet} and the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getLegendFacet legend facet}.  They are named based on where the {@link
     * com.smartgwt.client.widgets.cube.Facet#getValues values} of the facet appear in the chart.  The facet whose values are
     * rendered as labels along the data axis or in the main chart area is the data label facet, and the facet whose values are
     * rendered in the legend is the legend facet. <p> For single-facet charts, most chart types have a data label facet as the
     * first facet but no legend facet.  Single-facet Pie charts have a legend facet as the first facet but no data label
     * facet.  Scatter plots may have a legend facet as the second facet, after the metric facet. <p> In all multi-facet
     * charts, the data label facet is always first and the legend facet is second.  In most chart types the data label facet
     * and the legend facet may be swapped on the fly by the user clicking on the "Swap Facets" item of the context menu.
     *
     * @return Facet...
     */
    public Facet[] getFacets()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfFacet(getAttributeAsJavaScriptObject("facets"));
    }

    /**
     * An Array of facets, exactly analogous to {@link com.smartgwt.client.widgets.cube.CubeGrid#getFacets facets}, except
     * that: <ul> <li> the "inlinedValues" property can be set on a facet to change data representation as described under 
     * data. <li> for a non-inlined facet, Charts support auto-derivation of facetValues from the data. </ul> <p> In all chart
     * types except "Scatter", the chart displays a value for each discrete value of one facet (i.e. single-facet charts) or it
     * displays a value for each combination of discrete values of two facets (multi-facet charts).  The two discrete facets
     * are the {@link com.smartgwt.client.widgets.chart.FacetChart#getDataLabelFacet data label facet} and the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getLegendFacet legend facet}.  They are named based on where the {@link
     * com.smartgwt.client.widgets.cube.Facet#getValues values} of the facet appear in the chart.  The facet whose values are
     * rendered as labels along the data axis or in the main chart area is the data label facet, and the facet whose values are
     * rendered in the legend is the legend facet. <p> For single-facet charts, most chart types have a data label facet as the
     * first facet but no legend facet.  Single-facet Pie charts have a legend facet as the first facet but no data label
     * facet.  Scatter plots may have a legend facet as the second facet, after the metric facet. <p> In all multi-facet
     * charts, the data label facet is always first and the legend facet is second.  In most chart types the data label facet
     * and the legend facet may be swapped on the fly by the user clicking on the "Swap Facets" item of the context menu.
     *
     * @param facets  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setFacets(Facet facets)  throws IllegalStateException {
        setAttribute("facets", facets.getJsObj(), false);
    }

    /**
     * An Array of facets, exactly analogous to {@link com.smartgwt.client.widgets.cube.CubeGrid#getFacets facets}, except
     * that: <ul> <li> the "inlinedValues" property can be set on a facet to change data representation as described under 
     * data. <li> for a non-inlined facet, Charts support auto-derivation of facetValues from the data. </ul> <p> In all chart
     * types except "Scatter", the chart displays a value for each discrete value of one facet (i.e. single-facet charts) or it
     * displays a value for each combination of discrete values of two facets (multi-facet charts).  The two discrete facets
     * are the {@link com.smartgwt.client.widgets.chart.FacetChart#getDataLabelFacet data label facet} and the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getLegendFacet legend facet}.  They are named based on where the {@link
     * com.smartgwt.client.widgets.cube.Facet#getValues values} of the facet appear in the chart.  The facet whose values are
     * rendered as labels along the data axis or in the main chart area is the data label facet, and the facet whose values are
     * rendered in the legend is the legend facet. <p> For single-facet charts, most chart types have a data label facet as the
     * first facet but no legend facet.  Single-facet Pie charts have a legend facet as the first facet but no data label
     * facet.  Scatter plots may have a legend facet as the second facet, after the metric facet. <p> In all multi-facet
     * charts, the data label facet is always first and the legend facet is second.  In most chart types the data label facet
     * and the legend facet may be swapped on the fly by the user clicking on the "Swap Facets" item of the context menu.
     *
     * @return Facet
     */
    public Facet getFacetsAsFacet()  {
        return Facet.getOrCreateRef(getAttributeAsJavaScriptObject("facets"));
    }

    /**
     * Whether shapes are filled, for example, whether a multi-series line chart appears as a stack of filled regions as
     * opposed to just multiple lines. <P> If unset, fills will be automatically used when there are multiple facets and
     * stacking is active (so Line and Radar charts will show stacked regions).   <P> You can explicitly set filled:false to
     * create multi-facet Line or Radar charts where translucent regions overlap, or filled:true to fill in a single-facet Line
     * or Radar chart.
     *
     * <p>If this method is called after the component has been drawn/initialized:
     * Method to change {@link com.smartgwt.client.widgets.chart.FacetChart#getFilled filled}. Use null to apply a default value for the current {@link com.smartgwt.client.types.ChartType chartType}.
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
     * @return Boolean
     */
    public Boolean getFilled()  {
        return getAttributeAsBoolean("filled");
    }

    /**
     * Properties for gradation labels
     *
     * @param gradationLabelProperties  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setGradationLabelProperties(DrawLabel gradationLabelProperties)  throws IllegalStateException {
        JavaScriptObject config = gradationLabelProperties == null ? null : gradationLabelProperties.getConfig();
        setAttribute("gradationLabelProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for gradation labels
     *
     * @return DrawLabel
     */
    public DrawLabel getGradationLabelProperties()  {
        return DrawLabel.getOrCreateRef(getAttributeAsJavaScriptObject("gradationLabelProperties"));
    }

    /**
     * Properties for gradation lines
     *
     * @param gradationLineProperties  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setGradationLineProperties(DrawLine gradationLineProperties)  throws IllegalStateException {
        JavaScriptObject config = gradationLineProperties == null ? null : gradationLineProperties.getConfig();
        setAttribute("gradationLineProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for gradation lines
     *
     * @return DrawLine
     */
    public DrawLine getGradationLineProperties()  {
        return DrawLine.getOrCreateRef(getAttributeAsJavaScriptObject("gradationLineProperties"));
    }

    /**
     * Length of the tick marks used to denote the gradations of any {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics extra value axes}.
     *
     * @param gradationTickMarkLength  Default value is 5
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setGradationTickMarkLength(int gradationTickMarkLength)  throws IllegalStateException {
        setAttribute("gradationTickMarkLength", gradationTickMarkLength, false);
    }

    /**
     * Length of the tick marks used to denote the gradations of any {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics extra value axes}.
     *
     * @return int
     */
    public int getGradationTickMarkLength()  {
        return getAttributeAsInt("gradationTickMarkLength");
    }

    /**
     * Properties for the gradation line drawn for zero (slightly thicker by default).
     *
     * @param gradationZeroLineProperties  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setGradationZeroLineProperties(DrawLine gradationZeroLineProperties)  throws IllegalStateException {
        JavaScriptObject config = gradationZeroLineProperties == null ? null : gradationZeroLineProperties.getConfig();
        setAttribute("gradationZeroLineProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for the gradation line drawn for zero (slightly thicker by default).
     *
     * @return DrawLine
     */
    public DrawLine getGradationZeroLineProperties()  {
        return DrawLine.getOrCreateRef(getAttributeAsJavaScriptObject("gradationZeroLineProperties"));
    }

    /**
     * See {@link com.smartgwt.client.widgets.chart.FacetChart#getLowErrorMetric lowErrorMetric}.
     *
     * @param highErrorMetric  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setHighErrorMetric(String highErrorMetric)  throws IllegalStateException {
        setAttribute("highErrorMetric", highErrorMetric, false);
    }

    /**
     * See {@link com.smartgwt.client.widgets.chart.FacetChart#getLowErrorMetric lowErrorMetric}.
     *
     * @return String
     */
    public String getHighErrorMetric()  {
        return getAttributeAsString("highErrorMetric");
    }

    /**
     * Properties for text in a floating label that represents the data value shown whenever the mouse moves withing the main
     * chart area when {@link com.smartgwt.client.widgets.chart.FacetChart#getShowValueOnHover showValueOnHover} is enabled.
     *
     * @param hoverLabelProperties  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setHoverLabelProperties(DrawLabel hoverLabelProperties)  throws IllegalStateException {
        JavaScriptObject config = hoverLabelProperties == null ? null : hoverLabelProperties.getConfig();
        setAttribute("hoverLabelProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for text in a floating label that represents the data value shown whenever the mouse moves withing the main
     * chart area when {@link com.smartgwt.client.widgets.chart.FacetChart#getShowValueOnHover showValueOnHover} is enabled.
     *
     * @return DrawLabel
     */
    public DrawLabel getHoverLabelProperties()  {
        return DrawLabel.getOrCreateRef(getAttributeAsJavaScriptObject("hoverLabelProperties"));
    }

    /**
     * Properties for rectangle that draws behind of a floating hover label that represents the data value. See {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getShowValueOnHover showValueOnHover} for more details.
     *
     * @param hoverRectProperties  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setHoverRectProperties(DrawRect hoverRectProperties)  throws IllegalStateException {
        JavaScriptObject config = hoverRectProperties == null ? null : hoverRectProperties.getConfig();
        setAttribute("hoverRectProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for rectangle that draws behind of a floating hover label that represents the data value. See {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getShowValueOnHover showValueOnHover} for more details.
     *
     * @return DrawRect
     */
    public DrawRect getHoverRectProperties()  {
        return DrawRect.getOrCreateRef(getAttributeAsJavaScriptObject("hoverRectProperties"));
    }

    /**
     * What to do when there are too many data points to be able to show labels for every data point at the current chart size
     * - see {@link com.smartgwt.client.types.LabelCollapseMode}. <P> Each of the possible strategies is re-applied when the
     * user resizes the chart as a whole, so if labels are omitted the user can make them visible via resize or zoom. <P> If
     * the labelCollapseMode is "numeric" then vertical lines will be drawn at gradation values automatically chosen by the
     * chart. <P> If the labelCollapseMode is "time" then vertical lines are drawn to represent a sequence of significant
     * datetime values on the x-axis, such as the first day of the month or week.  The chart automatically chooses the sequence
     * of Dates such that the spacing between them expresses the smallest granularity of time possible while still allowing the
     * axis labels to make good use of the space.  If, for example, the Date values in the data span a few years in time then
     * the chart may select January 1 of the same year of the earliest data point and every January 1 thereafter (in range of
     * the data) as the sequence of Dates and label each Date by the four-digit year.  If the time span of the data values is
     * on the order of minutes then the chart may select multiples of 15 minutes as the seqeunce of Dates.  FacetChart
     * currently supports the following granularities of time:  years, quarters, months, weeks, days, hours, half-hours,
     * quarter-hours, 5 minutes, minutes, 30 seconds, and 15 seconds. <P> The format of the Date labels is fixed by FacetChart.
     * In particular, {@link com.smartgwt.client.widgets.chart.FacetChart#formatAxisValue FacetChart.formatAxisValue} will not
     * be called on values for the x-axis. However, FacetChart uses  the {@link
     * com.smartgwt.client.util.DateUtil#setShortMonthNames() global array of abbreviated month names} for the time
     * granularities of quarters, months, and weeks, uses the  {@link
     * com.smartgwt.client.util.DateUtil#setShortTimeDisplayFormatter() default short time format} to format labels for time
     * granularities from minutes to hours, and uses the  {@link
     * com.smartgwt.client.util.DateUtil#setNormalTimeDisplayFormatter() default time format} to format labels for the time
     * granularities of 15 seconds and 30 seconds.  The label format can be customized by changing these three formatters. 
     * Also note that for the time granularity of weeks the sequence of Dates will be the first day of each week, as specified
     * by  {@link com.smartgwt.client.util.DateUtil#setFirstDayOfWeek()}. <P> Note that if the labelCollapseMode is "time" or
     * "numeric" then the {@link com.smartgwt.client.widgets.chart.FacetChart#getData data} must be initially sorted with the
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getDataLabelFacet data label facet}'s values in ascending order.
     *
     * @param labelCollapseMode  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setLabelCollapseMode(LabelCollapseMode labelCollapseMode)  throws IllegalStateException {
        setAttribute("labelCollapseMode", labelCollapseMode == null ? null : labelCollapseMode.getValue(), false);
    }

    /**
     * What to do when there are too many data points to be able to show labels for every data point at the current chart size
     * - see {@link com.smartgwt.client.types.LabelCollapseMode}. <P> Each of the possible strategies is re-applied when the
     * user resizes the chart as a whole, so if labels are omitted the user can make them visible via resize or zoom. <P> If
     * the labelCollapseMode is "numeric" then vertical lines will be drawn at gradation values automatically chosen by the
     * chart. <P> If the labelCollapseMode is "time" then vertical lines are drawn to represent a sequence of significant
     * datetime values on the x-axis, such as the first day of the month or week.  The chart automatically chooses the sequence
     * of Dates such that the spacing between them expresses the smallest granularity of time possible while still allowing the
     * axis labels to make good use of the space.  If, for example, the Date values in the data span a few years in time then
     * the chart may select January 1 of the same year of the earliest data point and every January 1 thereafter (in range of
     * the data) as the sequence of Dates and label each Date by the four-digit year.  If the time span of the data values is
     * on the order of minutes then the chart may select multiples of 15 minutes as the seqeunce of Dates.  FacetChart
     * currently supports the following granularities of time:  years, quarters, months, weeks, days, hours, half-hours,
     * quarter-hours, 5 minutes, minutes, 30 seconds, and 15 seconds. <P> The format of the Date labels is fixed by FacetChart.
     * In particular, {@link com.smartgwt.client.widgets.chart.FacetChart#formatAxisValue FacetChart.formatAxisValue} will not
     * be called on values for the x-axis. However, FacetChart uses  the {@link
     * com.smartgwt.client.util.DateUtil#setShortMonthNames() global array of abbreviated month names} for the time
     * granularities of quarters, months, and weeks, uses the  {@link
     * com.smartgwt.client.util.DateUtil#setShortTimeDisplayFormatter() default short time format} to format labels for time
     * granularities from minutes to hours, and uses the  {@link
     * com.smartgwt.client.util.DateUtil#setNormalTimeDisplayFormatter() default time format} to format labels for the time
     * granularities of 15 seconds and 30 seconds.  The label format can be customized by changing these three formatters. 
     * Also note that for the time granularity of weeks the sequence of Dates will be the first day of each week, as specified
     * by  {@link com.smartgwt.client.util.DateUtil#setFirstDayOfWeek()}. <P> Note that if the labelCollapseMode is "time" or
     * "numeric" then the {@link com.smartgwt.client.widgets.chart.FacetChart#getData data} must be initially sorted with the
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getDataLabelFacet data label facet}'s values in ascending order.
     *
     * @return LabelCollapseMode
     */
    public LabelCollapseMode getLabelCollapseMode()  {
        return EnumUtil.getEnum(LabelCollapseMode.values(), getAttribute("labelCollapseMode"));
    }

    /**
     * Padding between each swatch and label pair.
     *
     * @param legendItemPadding  Default value is 5
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setLegendItemPadding(int legendItemPadding)  throws IllegalStateException {
        setAttribute("legendItemPadding", legendItemPadding, false);
    }

    /**
     * Padding between each swatch and label pair.
     *
     * @return int
     */
    public int getLegendItemPadding()  {
        return getAttributeAsInt("legendItemPadding");
    }

    /**
     * Properties for labels shown next to legend color swatches.
     *
     * @param legendLabelProperties  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setLegendLabelProperties(DrawLabel legendLabelProperties)  throws IllegalStateException {
        JavaScriptObject config = legendLabelProperties == null ? null : legendLabelProperties.getConfig();
        setAttribute("legendLabelProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for labels shown next to legend color swatches.
     *
     * @return DrawLabel
     */
    public DrawLabel getLegendLabelProperties()  {
        return DrawLabel.getOrCreateRef(getAttributeAsJavaScriptObject("legendLabelProperties"));
    }

    /**
     * Space between the legend and the chart rect or axis labels (whatever the legend is adjacent to.
     *
     * @param legendMargin  Default value is 10
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setLegendMargin(int legendMargin)  throws IllegalStateException {
        setAttribute("legendMargin", legendMargin, false);
    }

    /**
     * Space between the legend and the chart rect or axis labels (whatever the legend is adjacent to.
     *
     * @return int
     */
    public int getLegendMargin()  {
        return getAttributeAsInt("legendMargin");
    }

    /**
     * Padding around the legend as a whole.
     *
     * @param legendPadding  Default value is 5
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setLegendPadding(int legendPadding)  throws IllegalStateException {
        setAttribute("legendPadding", legendPadding, false);
    }

    /**
     * Padding around the legend as a whole.
     *
     * @return int
     */
    public int getLegendPadding()  {
        return getAttributeAsInt("legendPadding");
    }

    /**
     * Properties for rectangle around the legend as a whole.
     *
     * @param legendRectProperties  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setLegendRectProperties(DrawRect legendRectProperties)  throws IllegalStateException {
        JavaScriptObject config = legendRectProperties == null ? null : legendRectProperties.getConfig();
        setAttribute("legendRectProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for rectangle around the legend as a whole.
     *
     * @return DrawRect
     */
    public DrawRect getLegendRectProperties()  {
        return DrawRect.getOrCreateRef(getAttributeAsJavaScriptObject("legendRectProperties"));
    }

    /**
     * Properties for the swatches of color shown in the legend.
     *
     * @param legendSwatchProperties  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setLegendSwatchProperties(DrawRect legendSwatchProperties)  throws IllegalStateException {
        JavaScriptObject config = legendSwatchProperties == null ? null : legendSwatchProperties.getConfig();
        setAttribute("legendSwatchProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for the swatches of color shown in the legend.
     *
     * @return DrawRect
     */
    public DrawRect getLegendSwatchProperties()  {
        return DrawRect.getOrCreateRef(getAttributeAsJavaScriptObject("legendSwatchProperties"));
    }

    /**
     * Size of individual color swatches in legend.
     *
     * @param legendSwatchSize  Default value is 16
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setLegendSwatchSize(int legendSwatchSize)  throws IllegalStateException {
        setAttribute("legendSwatchSize", legendSwatchSize, false);
    }

    /**
     * Size of individual color swatches in legend.
     *
     * @return int
     */
    public int getLegendSwatchSize()  {
        return getAttributeAsInt("legendSwatchSize");
    }

    /**
     * Padding between color swatch and its label.
     *
     * @param legendTextPadding  Default value is 5
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setLegendTextPadding(int legendTextPadding)  throws IllegalStateException {
        setAttribute("legendTextPadding", legendTextPadding, false);
    }

    /**
     * Padding between color swatch and its label.
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
     * @param logBase  Default value is 10
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
     * @return int
     */
    public int getLogBase()  {
        return getAttributeAsInt("logBase");
    }

    /**
     * When {@link com.smartgwt.client.widgets.chart.FacetChart#getUseLogGradations useLogGradations} is set, gradation lines
     * to show in between powers,
     * expressed as a series of integer or float values between 1 and {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getLogBase logBase}.
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
     * @param logGradations  Default value is [ 1,2,4,6,8 ]
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setLogGradations(float... logGradations)  throws IllegalStateException {
        setAttribute("logGradations", logGradations, false);
    }

    /**
     * When {@link com.smartgwt.client.widgets.chart.FacetChart#getUseLogGradations useLogGradations} is set, gradation lines
     * to show in between powers,
     * expressed as a series of integer or float values between 1 and {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getLogBase logBase}.
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
     * @return float...
     */
    public float[] getLogGradations()  {
        return com.smartgwt.client.util.ConvertTo.arrayOffloat(getAttributeAsJavaScriptObject("logGradations"));
    }

    /**
     * Whether to use logarithmic scaling for values. <P> Logarithmic scale charts show an equivalent percentage increase as
     * equivalent distance on the chart.  That is, 10 and 100 are the same distance apart as 100 and 1000 (each being a 10
     * times or 1000% increase).
     *
     * @param logScale  Default value is false
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
     * @return Boolean
     */
    public Boolean getLogScale()  {
        return getAttributeAsBoolean("logScale");
    }

    /**
     * <code>lowErrorMetric</code> and {@link com.smartgwt.client.widgets.chart.FacetChart#getHighErrorMetric highErrorMetric}
     * can be used to cause error bars to appear above and below the main data point. <p> <code>lowErrorMetric</code> and
     * <code>highErrorMetric</code> provide the name of an additional attributes that appears in each Record holding the low
     * error value and high error value respectively. <p> Error bars are supported for single-axis charts only.
     *
     * @param lowErrorMetric  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#errorBars" target="examples">Error Bars Example</a>
     */
    public void setLowErrorMetric(String lowErrorMetric)  throws IllegalStateException {
        setAttribute("lowErrorMetric", lowErrorMetric, false);
    }

    /**
     * <code>lowErrorMetric</code> and {@link com.smartgwt.client.widgets.chart.FacetChart#getHighErrorMetric highErrorMetric}
     * can be used to cause error bars to appear above and below the main data point. <p> <code>lowErrorMetric</code> and
     * <code>highErrorMetric</code> provide the name of an additional attributes that appears in each Record holding the low
     * error value and high error value respectively. <p> Error bars are supported for single-axis charts only.
     *
     * @return String
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#errorBars" target="examples">Error Bars Example</a>
     */
    public String getLowErrorMetric()  {
        return getAttributeAsString("lowErrorMetric");
    }

    /**
     * Bars will not be drawn over this thickness, instead, margins will be increased.
     *
     * @param maxBarThickness  Default value is 150
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setMaxBarThickness(int maxBarThickness)  throws IllegalStateException {
        setAttribute("maxBarThickness", maxBarThickness, false);
    }

    /**
     * Bars will not be drawn over this thickness, instead, margins will be increased.
     *
     * @return int
     */
    public int getMaxBarThickness()  {
        return getAttributeAsInt("maxBarThickness");
    }

    /**
     * If bars would be smaller than this size, margins are reduced until bars overlap.
     *
     * @param minBarThickness  Default value is 4
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setMinBarThickness(int minBarThickness)  throws IllegalStateException {
        setAttribute("minBarThickness", minBarThickness, false);
    }

    /**
     * If bars would be smaller than this size, margins are reduced until bars overlap.
     *
     * @return int
     */
    public int getMinBarThickness()  {
        return getAttributeAsInt("minBarThickness");
    }

    /**
     * If all data values would be spread across less than {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinDataSpreadPercent minDataSpreadPercent} of the axis, the start values
     * of axes will be automatically adjusted to make better use of space. <p> For example, if a column chart has all data
     * values between 500,000 and 500,100, if the axis starts at 0, differences in column heights will be visually
     * indistinguishable. In this case, since all data values appear in well under 30% of the axis length, the default
     * <code>minDataSpreadPercent</code> setting would cause the axis to start at a value that would make the column heights
     * obviously different (for example, starting the axis as 500,000). <p> Setting an explicit {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getAxisStartValue axisStartValue} disables this behavior, as does setting
     * <code>minDataSpreadPercent</code> to 0. <p> For multi-axis charts, use {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#getMinDataSpreadPercent minDataSpreadPercent} for per-axis settings.
     * <p> For Scatter charts, <code>minDataSpreadPercent</code> affects only the y-axis of the chart.  The property {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinXDataSpreadPercent minXDataSpreadPercent} must be used to enable the
     * corresponding feature for the x-axis.
     *
     * @param minDataSpreadPercent  Default value is 30
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setMinDataSpreadPercent(int minDataSpreadPercent)  throws IllegalStateException {
        setAttribute("minDataSpreadPercent", minDataSpreadPercent, false);
    }

    /**
     * If all data values would be spread across less than {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinDataSpreadPercent minDataSpreadPercent} of the axis, the start values
     * of axes will be automatically adjusted to make better use of space. <p> For example, if a column chart has all data
     * values between 500,000 and 500,100, if the axis starts at 0, differences in column heights will be visually
     * indistinguishable. In this case, since all data values appear in well under 30% of the axis length, the default
     * <code>minDataSpreadPercent</code> setting would cause the axis to start at a value that would make the column heights
     * obviously different (for example, starting the axis as 500,000). <p> Setting an explicit {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getAxisStartValue axisStartValue} disables this behavior, as does setting
     * <code>minDataSpreadPercent</code> to 0. <p> For multi-axis charts, use {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#getMinDataSpreadPercent minDataSpreadPercent} for per-axis settings.
     * <p> For Scatter charts, <code>minDataSpreadPercent</code> affects only the y-axis of the chart.  The property {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinXDataSpreadPercent minXDataSpreadPercent} must be used to enable the
     * corresponding feature for the x-axis.
     *
     * @return int
     */
    public int getMinDataSpreadPercent()  {
        return getAttributeAsInt("minDataSpreadPercent");
    }

    /**
     * Minimum gap between labels on the X axis before some labels are omitted or larger time granularity is shown (eg show
     * days instead of hours) based on the {@link com.smartgwt.client.widgets.chart.FacetChart#getLabelCollapseMode
     * labelCollapseMode}. <P> Default is based on label orientation.  If labels are vertical, the minimum gap is the height of
     * half a line of text.  If horizontal it's the width of 4 "X" letters.
     *
     * @param minLabelGap  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setMinLabelGap(Integer minLabelGap)  throws IllegalStateException {
        setAttribute("minLabelGap", minLabelGap, false);
    }

    /**
     * Minimum gap between labels on the X axis before some labels are omitted or larger time granularity is shown (eg show
     * days instead of hours) based on the {@link com.smartgwt.client.widgets.chart.FacetChart#getLabelCollapseMode
     * labelCollapseMode}. <P> Default is based on label orientation.  If labels are vertical, the minimum gap is the height of
     * half a line of text.  If horizontal it's the width of 4 "X" letters.
     *
     * @return Integer
     */
    public Integer getMinLabelGap()  {
        return getAttributeAsInt("minLabelGap");
    }

    /**
     * For scatter charts only, if all data points would be spread across less than {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinXDataSpreadPercent minXDataSpreadPercent} of the x-axis, the start
     * value of x-axis will be automatically adjusted to make better use of space. <p> Setting an explicit {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getXAxisStartValue xAxisStartValue} disables this behavior, as does setting
     * <code>minXDataSpreadPercent</code> to 0.
     *
     * @param minXDataSpreadPercent  Default value is 30
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.chart.FacetChart#setMinDataSpreadPercent
     */
    public void setMinXDataSpreadPercent(int minXDataSpreadPercent)  throws IllegalStateException {
        setAttribute("minXDataSpreadPercent", minXDataSpreadPercent, false);
    }

    /**
     * For scatter charts only, if all data points would be spread across less than {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinXDataSpreadPercent minXDataSpreadPercent} of the x-axis, the start
     * value of x-axis will be automatically adjusted to make better use of space. <p> Setting an explicit {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getXAxisStartValue xAxisStartValue} disables this behavior, as does setting
     * <code>minXDataSpreadPercent</code> to 0.
     *
     * @return int
     * @see com.smartgwt.client.widgets.chart.FacetChart#getMinDataSpreadPercent
     */
    public int getMinXDataSpreadPercent()  {
        return getAttributeAsInt("minXDataSpreadPercent");
    }

    /**
     * Properties for the border around a pie chart.
     *
     * @param pieBorderProperties  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setPieBorderProperties(DrawOval pieBorderProperties)  throws IllegalStateException {
        JavaScriptObject config = pieBorderProperties == null ? null : pieBorderProperties.getConfig();
        setAttribute("pieBorderProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for the border around a pie chart.
     *
     * @return DrawOval
     */
    public DrawOval getPieBorderProperties()  {
        return DrawOval.getOrCreateRef(getAttributeAsJavaScriptObject("pieBorderProperties"));
    }

    /**
     * Angle where first label is placed in a Pie chart in stacked mode, in degrees.
     *
     * @param pieLabelAngleStart  Default value is 20
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setPieLabelAngleStart(int pieLabelAngleStart)  throws IllegalStateException {
        setAttribute("pieLabelAngleStart", pieLabelAngleStart, false);
    }

    /**
     * Angle where first label is placed in a Pie chart in stacked mode, in degrees.
     *
     * @return int
     */
    public int getPieLabelAngleStart()  {
        return getAttributeAsInt("pieLabelAngleStart");
    }

    /**
     * How far label lines stick out of the pie radius in a Pie chart in stacked mode.
     *
     * @param pieLabelLineExtent  Default value is 7
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setPieLabelLineExtent(int pieLabelLineExtent)  throws IllegalStateException {
        setAttribute("pieLabelLineExtent", pieLabelLineExtent, false);
    }

    /**
     * How far label lines stick out of the pie radius in a Pie chart in stacked mode.
     *
     * @return int
     */
    public int getPieLabelLineExtent()  {
        return getAttributeAsInt("pieLabelLineExtent");
    }

    /**
     * Properties for pie label line
     *
     * @param pieLabelLineProperties  Default value is null
     */
    public void setPieLabelLineProperties(DrawLine pieLabelLineProperties) {
        JavaScriptObject config = pieLabelLineProperties == null ? null : pieLabelLineProperties.getConfig();
        setAttribute("pieLabelLineProperties", JSOHelper.cleanProperties(config, true), true);
    }

    /**
     * Properties for pie label line
     *
     * @return DrawLine
     */
    public DrawLine getPieLabelLineProperties()  {
        return DrawLine.getOrCreateRef(getAttributeAsJavaScriptObject("pieLabelLineProperties"));
    }

    /**
     * Properties for pie ring border
     *
     * @param pieRingBorderProperties  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setPieRingBorderProperties(DrawOval pieRingBorderProperties)  throws IllegalStateException {
        JavaScriptObject config = pieRingBorderProperties == null ? null : pieRingBorderProperties.getConfig();
        setAttribute("pieRingBorderProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for pie ring border
     *
     * @return DrawOval
     */
    public DrawOval getPieRingBorderProperties()  {
        return DrawOval.getOrCreateRef(getAttributeAsJavaScriptObject("pieRingBorderProperties"));
    }

    /**
     * Properties for pie slices
     *
     * @param pieSliceProperties  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setPieSliceProperties(DrawSector pieSliceProperties)  throws IllegalStateException {
        JavaScriptObject config = pieSliceProperties == null ? null : pieSliceProperties.getConfig();
        setAttribute("pieSliceProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for pie slices
     *
     * @return DrawSector
     */
    public DrawSector getPieSliceProperties()  {
        return DrawSector.getOrCreateRef(getAttributeAsJavaScriptObject("pieSliceProperties"));
    }

    /**
     * Default angle in degrees where pie charts start drawing sectors to represent data values. Default of 0 places the first
     * value starting from the "east" position.   Use 270 or -90 for north.
     *
     * @param pieStartAngle  Default value is 0
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setPieStartAngle(Integer pieStartAngle)  throws IllegalStateException {
        setAttribute("pieStartAngle", pieStartAngle, false);
    }

    /**
     * Default angle in degrees where pie charts start drawing sectors to represent data values. Default of 0 places the first
     * value starting from the "east" position.   Use 270 or -90 for north.
     *
     * @return Integer
     */
    public Integer getPieStartAngle()  {
        return getAttributeAsInt("pieStartAngle");
    }

    /**
     * The "id" of the metric facet value that assigns a probability to each combination of facets and their values.  Each
     * probability must be a non-negative number. These probabilities are used by all methods of FacetChart that calculate
     * statistical values (e.g. {@link com.smartgwt.client.widgets.chart.FacetChart#getMean FacetChart.getMean} and {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getStdDev FacetChart.getStdDev}).  The default value of this property is
     * null which causes the FacetChart to assign probabilities to the data records according to a uniform probability
     * distribution. <p> Note that the FacetChart handles cases where the sum total of all probabilities in the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getData data} is not exactly one by scaling the assigned probabilities.
     *
     * @param probabilityMetric  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.chart.FacetChart#getMean
     * @see com.smartgwt.client.widgets.chart.FacetChart#getMedian
     * @see com.smartgwt.client.widgets.chart.FacetChart#getStdDev
     * @see com.smartgwt.client.widgets.chart.FacetChart#getVariance
     */
    public void setProbabilityMetric(String probabilityMetric)  throws IllegalStateException {
        setAttribute("probabilityMetric", probabilityMetric, false);
    }

    /**
     * The "id" of the metric facet value that assigns a probability to each combination of facets and their values.  Each
     * probability must be a non-negative number. These probabilities are used by all methods of FacetChart that calculate
     * statistical values (e.g. {@link com.smartgwt.client.widgets.chart.FacetChart#getMean FacetChart.getMean} and {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getStdDev FacetChart.getStdDev}).  The default value of this property is
     * null which causes the FacetChart to assign probabilities to the data records according to a uniform probability
     * distribution. <p> Note that the FacetChart handles cases where the sum total of all probabilities in the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getData data} is not exactly one by scaling the assigned probabilities.
     *
     * @return String
     * @see com.smartgwt.client.widgets.chart.FacetChart#getMean
     * @see com.smartgwt.client.widgets.chart.FacetChart#getMedian
     * @see com.smartgwt.client.widgets.chart.FacetChart#getStdDev
     * @see com.smartgwt.client.widgets.chart.FacetChart#getVariance
     */
    public String getProbabilityMetric()  {
        return getAttributeAsString("probabilityMetric");
    }

    /**
     * Properties for radar background
     *
     * @param radarBackgroundProperties  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setRadarBackgroundProperties(DrawOval radarBackgroundProperties)  throws IllegalStateException {
        JavaScriptObject config = radarBackgroundProperties == null ? null : radarBackgroundProperties.getConfig();
        setAttribute("radarBackgroundProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for radar background
     *
     * @return DrawOval
     */
    public DrawOval getRadarBackgroundProperties()  {
        return DrawOval.getOrCreateRef(getAttributeAsJavaScriptObject("radarBackgroundProperties"));
    }

    /**
     * Distance in pixels that radial labels are offset from the outside of the circle.
     *
     * @param radialLabelOffset  Default value is 5
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setRadialLabelOffset(int radialLabelOffset)  throws IllegalStateException {
        setAttribute("radialLabelOffset", radialLabelOffset, false);
    }

    /**
     * Distance in pixels that radial labels are offset from the outside of the circle.
     *
     * @return int
     */
    public int getRadialLabelOffset()  {
        return getAttributeAsInt("radialLabelOffset");
    }

    /**
     * Properties for the {@link com.smartgwt.client.widgets.chart.FacetChart#getShowRegressionLine regression line}.
     *
     * @param regressionLineProperties  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setRegressionLineProperties(DrawLine regressionLineProperties)  throws IllegalStateException {
        JavaScriptObject config = regressionLineProperties == null ? null : regressionLineProperties.getConfig();
        setAttribute("regressionLineProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for the {@link com.smartgwt.client.widgets.chart.FacetChart#getShowRegressionLine regression line}.
     *
     * @return DrawLine
     */
    public DrawLine getRegressionLineProperties()  {
        return DrawLine.getOrCreateRef(getAttributeAsJavaScriptObject("regressionLineProperties"));
    }

    /**
     * Regression algorithm used for the {@link com.smartgwt.client.widgets.chart.FacetChart#getShowRegressionLine regression
     * line}.
     *
     * <p>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.types.RegressionLineType}.
     *
     * @param regressionLineType New value for this.regressionLineType. Default value is "line"
     */
    public void setRegressionLineType(RegressionLineType regressionLineType) {
        setAttribute("regressionLineType", regressionLineType == null ? null : regressionLineType.getValue(), true);
    }

    /**
     * Regression algorithm used for the {@link com.smartgwt.client.widgets.chart.FacetChart#getShowRegressionLine regression
     * line}.
     *
     * @return RegressionLineType
     */
    public RegressionLineType getRegressionLineType()  {
        return EnumUtil.getEnum(RegressionLineType.values(), getAttribute("regressionLineType"));
    }

    /**
     * For scatter plots only, specify the degree of polynomial to use for any polynomial regression that is calculated.
     *
     * <p>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.chart.FacetChart#getRegressionPolynomialDegree regressionPolynomialDegree}.
     *
     * @param regressionPolynomialDegree New value for this.regressionPolynomialDegree.. Default value is 3
     */
    public void setRegressionPolynomialDegree(int regressionPolynomialDegree) {
        setAttribute("regressionPolynomialDegree", regressionPolynomialDegree, true);
    }

    /**
     * For scatter plots only, specify the degree of polynomial to use for any polynomial regression that is calculated.
     *
     * @return int
     */
    public int getRegressionPolynomialDegree()  {
        return getAttributeAsInt("regressionPolynomialDegree");
    }

    /**
     * This property controls whether to rotate the labels on the X-axis.  If rotateLabels is "always" then all of the data
     * labels will be rotated by 90 degrees.  If rotateLabels is "auto" (the default) then the labels will only be rotated if
     * it is required in order for the labels to be legible and non-overlapping.  If rotateLabels is "never" then the labels
     * will not be rotated.
     *
     * @param rotateLabels  Default value is "auto"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setRotateLabels(LabelRotationMode rotateLabels)  throws IllegalStateException {
        setAttribute("rotateLabels", rotateLabels == null ? null : rotateLabels.getValue(), false);
    }

    /**
     * This property controls whether to rotate the labels on the X-axis.  If rotateLabels is "always" then all of the data
     * labels will be rotated by 90 degrees.  If rotateLabels is "auto" (the default) then the labels will only be rotated if
     * it is required in order for the labels to be legible and non-overlapping.  If rotateLabels is "never" then the labels
     * will not be rotated.
     *
     * @return LabelRotationMode
     */
    public LabelRotationMode getRotateLabels()  {
        return EnumUtil.getEnum(LabelRotationMode.values(), getAttribute("rotateLabels"));
    }

    /**
     * Properties for shadows.
     *
     * @param shadowProperties  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShadowProperties(DrawOval shadowProperties)  throws IllegalStateException {
        JavaScriptObject config = shadowProperties == null ? null : shadowProperties.getConfig();
        setAttribute("shadowProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for shadows.
     *
     * @return DrawOval
     */
    public DrawOval getShadowProperties()  {
        return DrawOval.getOrCreateRef(getAttributeAsJavaScriptObject("shadowProperties"));
    }

    /**
     * Whether to show a rectangular shape around the area of the chart where data is plotted.
     *
     * @param showChartRect  Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowChartRect(Boolean showChartRect)  throws IllegalStateException {
        setAttribute("showChartRect", showChartRect, false);
    }

    /**
     * Whether to show a rectangular shape around the area of the chart where data is plotted.
     *
     * @return Boolean
     */
    public Boolean getShowChartRect()  {
        return getAttributeAsBoolean("showChartRect");
    }

    /**
     * Whether to show a label for the data axis as a whole (the data axis is where labels for each data point appear).  If
     * true, {@link com.smartgwt.client.widgets.cube.Facet#getTitle title} for the data label facet will be shown as the label.
     * <P> Automatically disabled for non-rectangular charts (eg Pie, Radar).
     *
     * @param showDataAxisLabel  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowDataAxisLabel(Boolean showDataAxisLabel)  throws IllegalStateException {
        setAttribute("showDataAxisLabel", showDataAxisLabel, false);
    }

    /**
     * Whether to show a label for the data axis as a whole (the data axis is where labels for each data point appear).  If
     * true, {@link com.smartgwt.client.widgets.cube.Facet#getTitle title} for the data label facet will be shown as the label.
     * <P> Automatically disabled for non-rectangular charts (eg Pie, Radar).
     *
     * @return Boolean
     */
    public Boolean getShowDataAxisLabel()  {
        return getAttributeAsBoolean("showDataAxisLabel");
    }

    /**
     * For line charts, whether to show data points for each individual data value. <P> If shown, the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#pointClick FacetChart.pointClick} and {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getPointHoverHTML FacetChart.getPointHoverHTML} APIs can be used to create
     * interactivity.
     *
     * @param showDataPoints  Default value is false
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
     * @return Boolean
     */
    public Boolean getShowDataPoints()  {
        return getAttributeAsBoolean("showDataPoints");
    }

    /**
     * Should data values be shown as text labels near the shape representing the value, for example, above columns of a column
     * chart, or adjacent to points in a line chart? <p> If set to false, then data values will not be shown. <p> If set to
     * true, data values will be shown unless the data density is high enough that labels will potentially overlap, in which
     * case, data values will not be shown and {@link com.smartgwt.client.widgets.chart.FacetChart#getShowValueOnHover
     * showValueOnHover} will be enabled instead.
     *
     * @param showDataValues  Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowDataValues(boolean showDataValues)  throws IllegalStateException {
        setAttribute("showDataValues", showDataValues, false);
    }

    /**
     * Should data values be shown as text labels near the shape representing the value, for example, above columns of a column
     * chart, or adjacent to points in a line chart? <p> If set to false, then data values will not be shown. <p> If set to
     * true, data values will be shown unless the data density is high enough that labels will potentially overlap, in which
     * case, data values will not be shown and {@link com.smartgwt.client.widgets.chart.FacetChart#getShowValueOnHover
     * showValueOnHover} will be enabled instead.
     *
     * @return boolean
     */
    public boolean getShowDataValues()  {
        return getAttributeAsBoolean("showDataValues");
    }

    /**
     * Whether to show a "doughnut hole" in the middle of pie charts.  Defaults to whether chartType is set to "Doughnut"
     * (shown) vs "Pie" (not shown) but can be forced on or off via <code>showDoughnut</code>.
     *
     * @param showDoughnut  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowDoughnut(Boolean showDoughnut)  throws IllegalStateException {
        setAttribute("showDoughnut", showDoughnut, false);
    }

    /**
     * Whether to show a "doughnut hole" in the middle of pie charts.  Defaults to whether chartType is set to "Doughnut"
     * (shown) vs "Pie" (not shown) but can be forced on or off via <code>showDoughnut</code>.
     *
     * @return Boolean
     */
    public Boolean getShowDoughnut()  {
        return getAttributeAsBoolean("showDoughnut");
    }

    /**
     * Display a line at the {@link com.smartgwt.client.widgets.chart.FacetChart#getMean mean value}. <P> Note that this
     * expected value is computed using all of the data points, pooled across all facets.  The computation relies only on the
     * values of the main value axis metric and the {@link com.smartgwt.client.widgets.chart.FacetChart#getProbabilityMetric
     * probability metric}. <P> See <a
     * href="http://en.wikipedia.org/wiki/Expected_value">http://en.wikipedia.org/wiki/Expected_value</a>.
     *
     * @param showExpectedValueLine  Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowExpectedValueLine(Boolean showExpectedValueLine)  throws IllegalStateException {
        setAttribute("showExpectedValueLine", showExpectedValueLine, false);
    }

    /**
     * Display a line at the {@link com.smartgwt.client.widgets.chart.FacetChart#getMean mean value}. <P> Note that this
     * expected value is computed using all of the data points, pooled across all facets.  The computation relies only on the
     * values of the main value axis metric and the {@link com.smartgwt.client.widgets.chart.FacetChart#getProbabilityMetric
     * probability metric}. <P> See <a
     * href="http://en.wikipedia.org/wiki/Expected_value">http://en.wikipedia.org/wiki/Expected_value</a>.
     *
     * @return Boolean
     */
    public Boolean getShowExpectedValueLine()  {
        return getAttributeAsBoolean("showExpectedValueLine");
    }

    /**
     * If set, gradation lines are drawn on top of data rather than underneath.
     *
     * @param showGradationsOverData  Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowGradationsOverData(Boolean showGradationsOverData)  throws IllegalStateException {
        setAttribute("showGradationsOverData", showGradationsOverData, false);
    }

    /**
     * If set, gradation lines are drawn on top of data rather than underneath.
     *
     * @return Boolean
     */
    public Boolean getShowGradationsOverData()  {
        return getAttributeAsBoolean("showGradationsOverData");
    }

    /**
     * Causes labels for the X axis to be shown above the axis and to the right of the gradation line they label, making for a
     * vertically more compact chart at the risk of gradation labels being partially obscured by data values.  Also causes the
     * last label to be skipped (no where to place it).
     *
     * @param showInlineLabels  Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowInlineLabels(Boolean showInlineLabels)  throws IllegalStateException {
        setAttribute("showInlineLabels", showInlineLabels, false);
    }

    /**
     * Causes labels for the X axis to be shown above the axis and to the right of the gradation line they label, making for a
     * vertically more compact chart at the risk of gradation labels being partially obscured by data values.  Also causes the
     * last label to be skipped (no where to place it).
     *
     * @return Boolean
     */
    public Boolean getShowInlineLabels()  {
        return getAttributeAsBoolean("showInlineLabels");
    }

    /**
     * The legend is automatically shown for charts that need it (generally, multi-series charts) but can be forced off by
     * setting showLegend to false.
     *
     * @param showLegend  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowLegend(Boolean showLegend)  throws IllegalStateException {
        setAttribute("showLegend", showLegend, false);
    }

    /**
     * The legend is automatically shown for charts that need it (generally, multi-series charts) but can be forced off by
     * setting showLegend to false.
     *
     * @return Boolean
     */
    public Boolean getShowLegend()  {
        return getAttributeAsBoolean("showLegend");
    }

    /**
     * Whether to show gradation labels in radar charts.
     *
     * @param showRadarGradationLabels  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowRadarGradationLabels(Boolean showRadarGradationLabels)  throws IllegalStateException {
        setAttribute("showRadarGradationLabels", showRadarGradationLabels, false);
    }

    /**
     * Whether to show gradation labels in radar charts.
     *
     * @return Boolean
     */
    public Boolean getShowRadarGradationLabels()  {
        return getAttributeAsBoolean("showRadarGradationLabels");
    }

    /**
     * For scatter plots only, whether to display a regression curve that best fits the data of the two metric facet values.
     * <P> The type of regression curve used depends on the {@link com.smartgwt.client.types.RegressionLineType} property,
     * which can be: <ul> <li><b>"line"</b> &ndash; to draw a linear regression curve, or</li> <li><b>"polynomial"</b> &ndash;
     * to draw a polynomial regression curve (of degree {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getRegressionPolynomialDegree regressionPolynomialDegree}).<li> </ul> <P>
     * Note that the regression is computed using all of the data points and it does not depend on the values of any non-metric
     * facets.  For example, adding a legend facet will not change the regression curve. <P> See <a
     * href="http://en.wikipedia.org/wiki/Simple_linear_regression">http://en.wikipedia.org/wiki/Simple_linear_regression</a>.
     * See <a href="http://en.wikipedia.org/wiki/Polynomial_regression">http://en.wikipedia.org/wiki/Polynomial_regression</a>.
     *
     * <p>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.chart.FacetChart#getShowRegressionLine showRegressionLine}.
     *
     * @param showRegressionLine New value for this.showRegressionLine.. Default value is false
     * @see com.smartgwt.client.widgets.chart.FacetChart#setXAxisMetric
     * @see com.smartgwt.client.widgets.chart.FacetChart#setYAxisMetric
     * @see com.smartgwt.client.widgets.chart.FacetChart#setRegressionLineProperties
     */
    public void setShowRegressionLine(Boolean showRegressionLine) {
        setAttribute("showRegressionLine", showRegressionLine, true);
    }

    /**
     * For scatter plots only, whether to display a regression curve that best fits the data of the two metric facet values.
     * <P> The type of regression curve used depends on the {@link com.smartgwt.client.types.RegressionLineType} property,
     * which can be: <ul> <li><b>"line"</b> &ndash; to draw a linear regression curve, or</li> <li><b>"polynomial"</b> &ndash;
     * to draw a polynomial regression curve (of degree {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getRegressionPolynomialDegree regressionPolynomialDegree}).<li> </ul> <P>
     * Note that the regression is computed using all of the data points and it does not depend on the values of any non-metric
     * facets.  For example, adding a legend facet will not change the regression curve. <P> See <a
     * href="http://en.wikipedia.org/wiki/Simple_linear_regression">http://en.wikipedia.org/wiki/Simple_linear_regression</a>.
     * See <a href="http://en.wikipedia.org/wiki/Polynomial_regression">http://en.wikipedia.org/wiki/Polynomial_regression</a>.
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.chart.FacetChart#getXAxisMetric
     * @see com.smartgwt.client.widgets.chart.FacetChart#getYAxisMetric
     * @see com.smartgwt.client.widgets.chart.FacetChart#getRegressionLineProperties
     */
    public Boolean getShowRegressionLine()  {
        return getAttributeAsBoolean("showRegressionLine");
    }

    /**
     * Whether to draw lines between adjacent data points in "Scatter" plots.  See also {@link
     * com.smartgwt.client.types.DataLineType} for enabling smoothing.
     *
     * <p>If this method is called after the component has been drawn/initialized:
     * Method to change the current {@link com.smartgwt.client.types.ChartType showScatterLines}. Will redraw the chart if drawn.
     *
     * @param showScatterLines whether to draw lines between adjacent data points in "Scatter" plots. Default value is false
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#scatterPlotCharting" target="examples">Scatter Plot Example</a>
     */
    public void setShowScatterLines(Boolean showScatterLines) {
        setAttribute("showScatterLines", showScatterLines, true);
    }

    /**
     * Whether to draw lines between adjacent data points in "Scatter" plots.  See also {@link
     * com.smartgwt.client.types.DataLineType} for enabling smoothing.
     *
     * @return Boolean
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#scatterPlotCharting" target="examples">Scatter Plot Example</a>
     */
    public Boolean getShowScatterLines()  {
        return getAttributeAsBoolean("showScatterLines");
    }

    /**
     * Whether to automatically show shadows for various charts.
     *
     * @param showShadows  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowShadows(Boolean showShadows)  throws IllegalStateException {
        setAttribute("showShadows", showShadows, false);
    }

    /**
     * Whether to automatically show shadows for various charts.
     *
     * @return Boolean
     */
    public Boolean getShowShadows()  {
        return getAttributeAsBoolean("showShadows");
    }

    /**
     * Display multiple {@link com.smartgwt.client.widgets.chart.FacetChart#getStdDev standard deviations} away from the mean
     * as lines. The exact deviations to display can be customized with {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getStandardDeviations standardDeviations}. <P> Note that these standard
     * deviations are computed using all of the data points, pooled across all facets.  The computation relies only on the
     * values of the main value axis metric and the {@link com.smartgwt.client.widgets.chart.FacetChart#getProbabilityMetric
     * probability metric}. <P> See <a
     * href="http://en.wikipedia.org/wiki/Standard_deviation">http://en.wikipedia.org/wiki/Standard_deviation</a>.
     *
     * @param showStandardDeviationLines  Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowStandardDeviationLines(Boolean showStandardDeviationLines)  throws IllegalStateException {
        setAttribute("showStandardDeviationLines", showStandardDeviationLines, false);
    }

    /**
     * Display multiple {@link com.smartgwt.client.widgets.chart.FacetChart#getStdDev standard deviations} away from the mean
     * as lines. The exact deviations to display can be customized with {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getStandardDeviations standardDeviations}. <P> Note that these standard
     * deviations are computed using all of the data points, pooled across all facets.  The computation relies only on the
     * values of the main value axis metric and the {@link com.smartgwt.client.widgets.chart.FacetChart#getProbabilityMetric
     * probability metric}. <P> See <a
     * href="http://en.wikipedia.org/wiki/Standard_deviation">http://en.wikipedia.org/wiki/Standard_deviation</a>.
     *
     * @return Boolean
     */
    public Boolean getShowStandardDeviationLines()  {
        return getAttributeAsBoolean("showStandardDeviationLines");
    }

    /**
     * If set, the {@link com.smartgwt.client.widgets.chart.FacetChart#getShowExpectedValueLine mean line}, {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getShowStandardDeviationLines standard deviation lines}, {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getBandedStandardDeviations standard deviation bands}, and {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getShowRegressionLine regression curves} are drawn on top of the data
     * rather than underneath.
     *
     * @param showStatisticsOverData  Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowStatisticsOverData(Boolean showStatisticsOverData)  throws IllegalStateException {
        setAttribute("showStatisticsOverData", showStatisticsOverData, false);
    }

    /**
     * If set, the {@link com.smartgwt.client.widgets.chart.FacetChart#getShowExpectedValueLine mean line}, {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getShowStandardDeviationLines standard deviation lines}, {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getBandedStandardDeviations standard deviation bands}, and {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getShowRegressionLine regression curves} are drawn on top of the data
     * rather than underneath.
     *
     * @return Boolean
     */
    public Boolean getShowStatisticsOverData()  {
        return getAttributeAsBoolean("showStatisticsOverData");
    }

    /**
     * Whether to show a title.
     *
     * @param showTitle  Default value is true
     */
    public void setShowTitle(Boolean showTitle) {
        setAttribute("showTitle", showTitle, true);
    }

    /**
     * Whether to show a title.
     *
     * @return Boolean
     */
    public Boolean getShowTitle()  {
        return getAttributeAsBoolean("showTitle");
    }

    /**
     * Whether to show the {@link com.smartgwt.client.widgets.chart.FacetChart#getValueTitle valueTitle} as a label on the
     * value axis. <p> Automatically disabled for non-rectangular charts (eg Pie, Radar).
     *
     * @param showValueAxisLabel  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowValueAxisLabel(Boolean showValueAxisLabel)  throws IllegalStateException {
        setAttribute("showValueAxisLabel", showValueAxisLabel, false);
    }

    /**
     * Whether to show the {@link com.smartgwt.client.widgets.chart.FacetChart#getValueTitle valueTitle} as a label on the
     * value axis. <p> Automatically disabled for non-rectangular charts (eg Pie, Radar).
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
     * com.smartgwt.client.widgets.chart.FacetChart#getNearestDrawnValue FacetChart.getNearestDrawnValue}. <p> The data value
     * will be formatted using {@link com.smartgwt.client.widgets.chart.FacetChart#formatDataValue FacetChart.formatDataValue}.
     * The label's appearance is controlled by {@link com.smartgwt.client.widgets.chart.FacetChart#getHoverLabelProperties
     * hoverLabelProperties}.
     *
     * @param showValueOnHover  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowValueOnHover(Boolean showValueOnHover)  throws IllegalStateException {
        setAttribute("showValueOnHover", showValueOnHover, false);
    }

    /**
     * Shows the value of the nearest data value in a floating label whenever the mouse moves within the main chart area.  The
     * visual element representing the data value will also be emphasized by brightening or highlighting it (appearance differs
     * by chart type). <p> Calculates nearest value based on {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getNearestDrawnValue FacetChart.getNearestDrawnValue}. <p> The data value
     * will be formatted using {@link com.smartgwt.client.widgets.chart.FacetChart#formatDataValue FacetChart.formatDataValue}.
     * The label's appearance is controlled by {@link com.smartgwt.client.widgets.chart.FacetChart#getHoverLabelProperties
     * hoverLabelProperties}.
     *
     * @return Boolean
     */
    public Boolean getShowValueOnHover()  {
        return getAttributeAsBoolean("showValueOnHover");
    }

    /**
     * Whether to use stacking for charts where this makes sense (column, area, pie, line and radar charts).  If stacked is not
     * set and two facets are supplied, clustering is assumed. If null (the default), line charts will be unstacked, and others
     * will be stacked.
     *
     * <p>If this method is called after the component has been drawn/initialized:
     * Method to change {@link com.smartgwt.client.widgets.chart.FacetChart#getStacked stacked}. Use null to apply a default value for the current {@link com.smartgwt.client.types.ChartType chartType}.
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
     * @return Boolean
     */
    public Boolean getStacked()  {
        return getAttributeAsBoolean("stacked");
    }

    /**
     * An Array of DrawRect properties to specify the bands between the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getShowStandardDeviationLines standard deviation lines}. The length of the
     * Array must be one less than the length of the {@link com.smartgwt.client.widgets.chart.FacetChart#getStandardDeviations
     * standardDeviations} Array. <p> Having no band between certain standard deviations from the mean can be specified by
     * having a null element at the corresponding index of this Array. <p> Note that if {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getUseSymmetricStandardDeviations useSymmetricStandardDeviations} is set
     * then for each standard deviation band that is drawn a corresponding band will also be drawn on the opposite side of the
     * mean line.
     *
     * @param standardDeviationBandProperties  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setStandardDeviationBandProperties(DrawItem... standardDeviationBandProperties)  throws IllegalStateException {
        final JavaScriptObject configs;
        if (standardDeviationBandProperties == null) {
            configs = null;
        } else {
            configs = JSOHelper.createJavaScriptArray();
            for (int configJIndex = 0; configJIndex < standardDeviationBandProperties.length; ++configJIndex) {
                final DrawItem configJ = standardDeviationBandProperties[configJIndex];
                final JavaScriptObject config = (configJ == null ? null : configJ.getConfig());
                JSOHelper.setArrayValue(configs, configJIndex, JSOHelper.cleanProperties(config, true));
            }
        }
        setAttribute("standardDeviationBandProperties", configs, false);
    }

    /**
     * An Array of DrawRect properties to specify the bands between the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getShowStandardDeviationLines standard deviation lines}. The length of the
     * Array must be one less than the length of the {@link com.smartgwt.client.widgets.chart.FacetChart#getStandardDeviations
     * standardDeviations} Array. <p> Having no band between certain standard deviations from the mean can be specified by
     * having a null element at the corresponding index of this Array. <p> Note that if {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getUseSymmetricStandardDeviations useSymmetricStandardDeviations} is set
     * then for each standard deviation band that is drawn a corresponding band will also be drawn on the opposite side of the
     * mean line.
     *
     * @return DrawItem...
     */
    public DrawItem[] getStandardDeviationBandProperties()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfDrawItem(getAttributeAsJavaScriptObject("standardDeviationBandProperties"));
    }

    /**
     * Properties for the {@link com.smartgwt.client.widgets.chart.FacetChart#getShowStandardDeviationLines standard deviation
     * lines}. <p> Note that for rectangular charts the properties are for a {@link
     * com.smartgwt.client.widgets.drawing.DrawLine}, and for radar charts the properties are for a {@link
     * com.smartgwt.client.widgets.drawing.DrawOval}.
     *
     * @param standardDeviationLineProperties  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setStandardDeviationLineProperties(DrawItem standardDeviationLineProperties)  throws IllegalStateException {
        JavaScriptObject config = standardDeviationLineProperties == null ? null : standardDeviationLineProperties.getConfig();
        setAttribute("standardDeviationLineProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for the {@link com.smartgwt.client.widgets.chart.FacetChart#getShowStandardDeviationLines standard deviation
     * lines}. <p> Note that for rectangular charts the properties are for a {@link
     * com.smartgwt.client.widgets.drawing.DrawLine}, and for radar charts the properties are for a {@link
     * com.smartgwt.client.widgets.drawing.DrawOval}.
     *
     * @return DrawItem
     */
    public DrawItem getStandardDeviationLineProperties()  {
        return DrawItem.getOrCreateRef(getAttributeAsJavaScriptObject("standardDeviationLineProperties"));
    }

    /**
     * When {@link com.smartgwt.client.widgets.chart.FacetChart#getShowStandardDeviationLines showStandardDeviationLines} is
     * set, the number of standard deviation lines drawn
     *  and their respective standard deviation away from the mean are specified by this property.
     *  The default is to display lines corresponding to the mean plus or minus one standard
     *  deviation.
     *  <p>
     *  Note that having zero in this list of standard deviations is identical to drawing
     *  a line at the mean.
     *  <p>
     *  For example assume that chart1 and chart2 both plot data with mean 1 and standard deviation 0.1.
     *  chart1 will draw a blue line at the value 1 and two red lines at the values 0.7 and 1.2.
     *  chart2 will draw three red lines at values 0.9, 1.0, and 1.1.
     *  <p>
     *  
     *  
     *  <pre>
     *  DrawLine blueLine = new DrawLine(),
     *      redLine = new DrawLine();
     *  blueLine.setLineColor("blue");
     *  redLine.setLineColor("red");
     * 
     *  FacetChart chart1 = new FacetChart();
     *  chart1.setID("chart1");
     *  chart1.setStandardDeviations(new Float[] { -3f, 2f });
     *  chart1.setShowExpectedValueLine(true);
     *  chart1.setShowStandardDeviationLines(true);
     *  chart1.setExpectedValueLineProperties(blueLine);
     *  chart1.setStandardDeviationLineProperties(redLine);
     *  chart1.setUseSymmetricStandardDeviations(false);
     *  // ...
     * 
     *  FacetChart chart2 = new FacetChart();
     *  chart2.setID("chart2");
     *  chart2.setStandardDeviations(new Float[] { -1f, 0f, 1f });
     *  chart2.setShowExpectedValueLine(false);
     *  chart2.setShowStandardDeviationLines(true);
     *  chart2.setExpectedValueLineProperties(blueLine);
     *  chart2.setStandardDeviationLineProperties(redLine);
     *  chart2.setUseSymmetricStandardDeviations(false);
     *  // ...
     * 
     *  chart1.draw();
     *  chart2.draw();
     *  </pre>
     * 
     *
     * @param standardDeviations  Default value is [-1, 1]
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setStandardDeviations(float... standardDeviations)  throws IllegalStateException {
        setAttribute("standardDeviations", standardDeviations, false);
    }

    /**
     * When {@link com.smartgwt.client.widgets.chart.FacetChart#getShowStandardDeviationLines showStandardDeviationLines} is
     * set, the number of standard deviation lines drawn
     *  and their respective standard deviation away from the mean are specified by this property.
     *  The default is to display lines corresponding to the mean plus or minus one standard
     *  deviation.
     *  <p>
     *  Note that having zero in this list of standard deviations is identical to drawing
     *  a line at the mean.
     *  <p>
     *  For example assume that chart1 and chart2 both plot data with mean 1 and standard deviation 0.1.
     *  chart1 will draw a blue line at the value 1 and two red lines at the values 0.7 and 1.2.
     *  chart2 will draw three red lines at values 0.9, 1.0, and 1.1.
     *  <p>
     *  
     *  
     *  <pre>
     *  DrawLine blueLine = new DrawLine(),
     *      redLine = new DrawLine();
     *  blueLine.setLineColor("blue");
     *  redLine.setLineColor("red");
     * 
     *  FacetChart chart1 = new FacetChart();
     *  chart1.setID("chart1");
     *  chart1.setStandardDeviations(new Float[] { -3f, 2f });
     *  chart1.setShowExpectedValueLine(true);
     *  chart1.setShowStandardDeviationLines(true);
     *  chart1.setExpectedValueLineProperties(blueLine);
     *  chart1.setStandardDeviationLineProperties(redLine);
     *  chart1.setUseSymmetricStandardDeviations(false);
     *  // ...
     * 
     *  FacetChart chart2 = new FacetChart();
     *  chart2.setID("chart2");
     *  chart2.setStandardDeviations(new Float[] { -1f, 0f, 1f });
     *  chart2.setShowExpectedValueLine(false);
     *  chart2.setShowStandardDeviationLines(true);
     *  chart2.setExpectedValueLineProperties(blueLine);
     *  chart2.setStandardDeviationLineProperties(redLine);
     *  chart2.setUseSymmetricStandardDeviations(false);
     *  // ...
     * 
     *  chart1.draw();
     *  chart2.draw();
     *  </pre>
     * 
     *
     * @return float...
     */
    public float[] getStandardDeviations()  {
        return com.smartgwt.client.util.ConvertTo.arrayOffloat(getAttributeAsJavaScriptObject("standardDeviations"));
    }

    /**
     * Default styleName for the chart.
     *
     * @param styleName  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is "scChart"
     */
    public void setStyleName(String styleName) {
        setAttribute("styleName", styleName, true);
    }

    /**
     * Default styleName for the chart.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     */
    public String getStyleName()  {
        return getAttributeAsString("styleName");
    }

    /**
     * Margin between the tick marks and the labels of the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics extra value axes}.
     *
     * @param tickMarkToValueAxisMargin  Default value is 7
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTickMarkToValueAxisMargin(int tickMarkToValueAxisMargin)  throws IllegalStateException {
        setAttribute("tickMarkToValueAxisMargin", tickMarkToValueAxisMargin, false);
    }

    /**
     * Margin between the tick marks and the labels of the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics extra value axes}.
     *
     * @return int
     */
    public int getTickMarkToValueAxisMargin()  {
        return getAttributeAsInt("tickMarkToValueAxisMargin");
    }

    /**
     * Title for the chart as a whole.
     *
     * @param title  Default value is null
     */
    public void setTitle(String title) {
        setAttribute("title", title, true);
    }

    /**
     * Title for the chart as a whole.
     *
     * @return String
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }

    /**
     * Properties for title label.
     *
     * @param titleProperties  Default value is null
     */
    public void setTitleProperties(DrawLabel titleProperties) {
        JavaScriptObject config = titleProperties == null ? null : titleProperties.getConfig();
        setAttribute("titleProperties", JSOHelper.cleanProperties(config, true), true);
    }

    /**
     * Properties for title label.
     *
     * @return DrawLabel
     */
    public DrawLabel getTitleProperties()  {
        return DrawLabel.getOrCreateRef(getAttributeAsJavaScriptObject("titleProperties"));
    }

    /**
     * Causes the chart to use the colors specified in {@link com.smartgwt.client.widgets.chart.FacetChart#getDataColors
     * dataColors} but specify chart-specific  gradients based on the primary data color per chart type.
     *
     * @param useAutoGradients  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setUseAutoGradients(Boolean useAutoGradients)  throws IllegalStateException {
        setAttribute("useAutoGradients", useAutoGradients, false);
    }

    /**
     * Causes the chart to use the colors specified in {@link com.smartgwt.client.widgets.chart.FacetChart#getDataColors
     * dataColors} but specify chart-specific  gradients based on the primary data color per chart type.
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
     * @param useLogGradations  Default value is false
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
     * @return Boolean
     */
    public Boolean getUseLogGradations()  {
        return getAttributeAsBoolean("useLogGradations");
    }

    /**
     * Whether to display both the positive and negative of the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getStandardDeviations standard deviations}.
     *
     * @param useSymmetricStandardDeviations  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setUseSymmetricStandardDeviations(Boolean useSymmetricStandardDeviations)  throws IllegalStateException {
        setAttribute("useSymmetricStandardDeviations", useSymmetricStandardDeviations, false);
    }

    /**
     * Whether to display both the positive and negative of the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getStandardDeviations standard deviations}.
     *
     * @return Boolean
     */
    public Boolean getUseSymmetricStandardDeviations()  {
        return getAttributeAsBoolean("useSymmetricStandardDeviations");
    }

    /**
     * Properties for labels of value axis.
     *
     * @param valueAxisLabelProperties  Default value is null
     */
    public void setValueAxisLabelProperties(DrawLabel valueAxisLabelProperties) {
        JavaScriptObject config = valueAxisLabelProperties == null ? null : valueAxisLabelProperties.getConfig();
        setAttribute("valueAxisLabelProperties", JSOHelper.cleanProperties(config, true), true);
    }

    /**
     * Properties for labels of value axis.
     *
     * @return DrawLabel
     */
    public DrawLabel getValueAxisLabelProperties()  {
        return DrawLabel.getOrCreateRef(getAttributeAsJavaScriptObject("valueAxisLabelProperties"));
    }

    /**
     * Margin between {@link com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics multiple value axes}.
     *
     * @param valueAxisMargin  Default value is 10
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setValueAxisMargin(int valueAxisMargin)  throws IllegalStateException {
        setAttribute("valueAxisMargin", valueAxisMargin, false);
    }

    /**
     * Margin between {@link com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics multiple value axes}.
     *
     * @return int
     */
    public int getValueAxisMargin()  {
        return getAttributeAsInt("valueAxisMargin");
    }

    /**
     * Properties for a "value line" - a line shows where a particular discrete value is placed, eg, vertical lines connecting
     * points of a line chart to the X axis, or radial lines in a Radar chart.
     *
     * @param valueLineProperties  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setValueLineProperties(DrawLine valueLineProperties)  throws IllegalStateException {
        JavaScriptObject config = valueLineProperties == null ? null : valueLineProperties.getConfig();
        setAttribute("valueLineProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for a "value line" - a line shows where a particular discrete value is placed, eg, vertical lines connecting
     * points of a line chart to the X axis, or radial lines in a Radar chart.
     *
     * @return DrawLine
     */
    public DrawLine getValueLineProperties()  {
        return DrawLine.getOrCreateRef(getAttributeAsJavaScriptObject("valueLineProperties"));
    }

    /**
     * Property in each record that holds a data value. <P> Not used if there is an inline facet, see  data.
     *
     * @param valueProperty  Default value is "_value"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setValueProperty(String valueProperty)  throws IllegalStateException {
        setAttribute("valueProperty", valueProperty, false);
    }

    /**
     * Property in each record that holds a data value. <P> Not used if there is an inline facet, see  data.
     *
     * @return String
     */
    public String getValueProperty()  {
        return getAttributeAsString("valueProperty");
    }

    /**
     * A label for the data values, such as "Sales in Thousands", typically used as the label for the value axis.
     *
     * @param valueTitle  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setValueTitle(String valueTitle)  throws IllegalStateException {
        setAttribute("valueTitle", valueTitle, false);
    }

    /**
     * A label for the data values, such as "Sales in Thousands", typically used as the label for the value axis.
     *
     * @return String
     */
    public String getValueTitle()  {
        return getAttributeAsString("valueTitle");
    }

    /**
     * For scatter charts only, the "id" of the metric facet value to use for the x-axis. <p> The default x-axis metric is the
     * second value of the metric facet.
     *
     * @param xAxisMetric  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setXAxisMetric(String xAxisMetric)  throws IllegalStateException {
        setAttribute("xAxisMetric", xAxisMetric, false);
    }

    /**
     * For scatter charts only, the "id" of the metric facet value to use for the x-axis. <p> The default x-axis metric is the
     * second value of the metric facet.
     *
     * @return String
     */
    public String getXAxisMetric()  {
        return getAttributeAsString("xAxisMetric");
    }

    /**
     * For scatter charts only, the start value for the x-axis. <p> Defaults to 0, or to a value that makes good use of
     * horizontal space based on {@link com.smartgwt.client.widgets.chart.FacetChart#getMinXDataSpreadPercent
     * minXDataSpreadPercent}.
     *
     * @param xAxisStartValue  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.chart.FacetChart#setAxisStartValue
     */
    public void setXAxisStartValue(Double xAxisStartValue)  throws IllegalStateException {
        setAttribute("xAxisStartValue", xAxisStartValue, false);
    }

    /**
     * For scatter charts only, the start value for the x-axis. <p> Defaults to 0, or to a value that makes good use of
     * horizontal space based on {@link com.smartgwt.client.widgets.chart.FacetChart#getMinXDataSpreadPercent
     * minXDataSpreadPercent}.
     *
     * @return Double
     * @see com.smartgwt.client.widgets.chart.FacetChart#getAxisStartValue
     */
    public Double getXAxisStartValue()  {
        return getAttributeAsDouble("xAxisStartValue");
    }

    /**
     * For scatter charts only, the "id" of the metric facet value to use for the y-axis. <p> The default y-axis metric is the
     * first value of the metric facet.
     *
     * @param yAxisMetric  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setYAxisMetric(String yAxisMetric)  throws IllegalStateException {
        setAttribute("yAxisMetric", yAxisMetric, false);
    }

    /**
     * For scatter charts only, the "id" of the metric facet value to use for the y-axis. <p> The default y-axis metric is the
     * first value of the metric facet.
     *
     * @return String
     */
    public String getYAxisMetric()  {
        return getAttributeAsString("yAxisMetric");
    }

    /**
     * Mini-chart created to allow zooming when {@link com.smartgwt.client.widgets.chart.FacetChart#getCanZoom canZoom} is
     * enabled. <P> This chart automatically has certain visual tweaks applied, including {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getShowInlineLabels showInlineLabels}, {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getZoomMutePercent muted colors} and {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getZoomLogScale logarithmic scaling}.  It can be further configured via
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getZoomChartProperties zoomChartProperties}. <P> The selected range
     * from this chart defaults to being shown with distinct styling as well (if {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getZoomShowSelection zoomShowSelection} is set), which can be controlled
     * via {@link com.smartgwt.client.widgets.chart.FacetChart#getZoomSelectionChartProperties zoomSelectionChartProperties}.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return FacetChart
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public FacetChart getZoomChart() throws IllegalStateException {
        errorIfNotCreated("zoomChart");
        return (FacetChart)FacetChart.getByJSObject(getAttributeAsJavaScriptObject("zoomChart"));
    }

    /**
     * Properties to further configure the {@link com.smartgwt.client.widgets.chart.FacetChart#getZoomChart zoomChart}.
     *
     * @param zoomChartProperties  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setZoomChartProperties(FacetChart zoomChartProperties)  throws IllegalStateException {
        JavaScriptObject config = zoomChartProperties == null ? null : zoomChartProperties.getConfig();
        setAttribute("zoomChartProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties to further configure the {@link com.smartgwt.client.widgets.chart.FacetChart#getZoomChart zoomChart}.
     *
     * @return FacetChart
     */
    public FacetChart getZoomChartProperties()  {
        FacetChart properties = new FacetChart();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("zoomChartProperties"));
        return properties;
    }

    /**
     * Slider controls shown on the mini-chart which is created when {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getCanZoom canZoom} is enabled.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return RangeSlider
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public RangeSlider getZoomChartSlider() throws IllegalStateException {
        errorIfNotCreated("zoomChartSlider");
        return (RangeSlider)RangeSlider.getByJSObject(getAttributeAsJavaScriptObject("zoomChartSlider"));
    }

    /**
     * By default when {@link com.smartgwt.client.widgets.chart.FacetChart#getCanZoom canZoom} is enabled, the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getZoomChart zoomChart} uses logarithmic scaling so that spikes in the data
     * don't result in a zoomed chart that is mostly a flat line. <P> Logarithmic scaling is automatically disabled if the
     * dataset spans zero (eg, has negative and positive values) as this can't be shown in a logarithmic scale. <P> Set
     * <code>zoomLogScale</code> to explicitly enable or disable logarithmic scaling.
     *
     * @param zoomLogScale  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setZoomLogScale(Boolean zoomLogScale)  throws IllegalStateException {
        setAttribute("zoomLogScale", zoomLogScale, false);
    }

    /**
     * By default when {@link com.smartgwt.client.widgets.chart.FacetChart#getCanZoom canZoom} is enabled, the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getZoomChart zoomChart} uses logarithmic scaling so that spikes in the data
     * don't result in a zoomed chart that is mostly a flat line. <P> Logarithmic scaling is automatically disabled if the
     * dataset spans zero (eg, has negative and positive values) as this can't be shown in a logarithmic scale. <P> Set
     * <code>zoomLogScale</code> to explicitly enable or disable logarithmic scaling.
     *
     * @return Boolean
     */
    public Boolean getZoomLogScale()  {
        return getAttributeAsBoolean("zoomLogScale");
    }

    /**
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getColorMutePercent colorMutePercent} to use for the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getZoomChart zoomChart}.
     *
     * @param zoomMutePercent  Default value is -35
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setZoomMutePercent(float zoomMutePercent)  throws IllegalStateException {
        setAttribute("zoomMutePercent", zoomMutePercent, false);
    }

    /**
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getColorMutePercent colorMutePercent} to use for the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getZoomChart zoomChart}.
     *
     * @return float
     */
    public float getZoomMutePercent()  {
        return getAttributeAsFloat("zoomMutePercent");
    }

    /**
     * Mini-chart created when {@link com.smartgwt.client.widgets.chart.FacetChart#getCanZoom canZoom} is enabled.  This chart
     * represents the currently selected range of data shown in the main chart.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return FacetChart
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public FacetChart getZoomSelectionChart() throws IllegalStateException {
        errorIfNotCreated("zoomSelectionChart");
        return (FacetChart)FacetChart.getByJSObject(getAttributeAsJavaScriptObject("zoomSelectionChart"));
    }

    /**
     * Properties to further configure the {@link com.smartgwt.client.widgets.chart.FacetChart#getZoomSelectionChart
     * zoomSelectionChart}.
     *
     * @param zoomSelectionChartProperties  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setZoomSelectionChartProperties(FacetChart zoomSelectionChartProperties)  throws IllegalStateException {
        JavaScriptObject config = zoomSelectionChartProperties == null ? null : zoomSelectionChartProperties.getConfig();
        setAttribute("zoomSelectionChartProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties to further configure the {@link com.smartgwt.client.widgets.chart.FacetChart#getZoomSelectionChart
     * zoomSelectionChart}.
     *
     * @return FacetChart
     */
    public FacetChart getZoomSelectionChartProperties()  {
        FacetChart properties = new FacetChart();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("zoomSelectionChartProperties"));
        return properties;
    }

    /**
     * Whether the selected range should be shown in a different style, which can be configured via {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getZoomSelectionChartProperties zoomSelectionChartProperties}.  This has
     * performance consequences and makes the rendering of the mini-chart slightly slower.
     *
     * @param zoomShowSelection  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setZoomShowSelection(Boolean zoomShowSelection)  throws IllegalStateException {
        setAttribute("zoomShowSelection", zoomShowSelection, false);
    }

    /**
     * Whether the selected range should be shown in a different style, which can be configured via {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getZoomSelectionChartProperties zoomSelectionChartProperties}.  This has
     * performance consequences and makes the rendering of the mini-chart slightly slower.
     *
     * @return Boolean
     */
    public Boolean getZoomShowSelection()  {
        return getAttributeAsBoolean("zoomShowSelection");
    }

    /**
     * For a {@link com.smartgwt.client.widgets.chart.FacetChart#getCanZoom zoomed chart}, determines what portion of the
     * overall dataset should be initially shown in the main chart. <P> Default is to show the end of the dataset if the X axis
     * shows time and includes today's date, otherwise to show the start of the dataset. <P> Set this property to override this
     * default, or use {@link com.smartgwt.client.widgets.chart.FacetChart#getZoomStartValue zoomStartValue} and {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getZoomEndValue zoomEndValue} to start with a particular range.
     *
     * @param zoomStartPosition  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setZoomStartPosition(ZoomStartPosition zoomStartPosition)  throws IllegalStateException {
        setAttribute("zoomStartPosition", zoomStartPosition == null ? null : zoomStartPosition.getValue(), false);
    }

    /**
     * For a {@link com.smartgwt.client.widgets.chart.FacetChart#getCanZoom zoomed chart}, determines what portion of the
     * overall dataset should be initially shown in the main chart. <P> Default is to show the end of the dataset if the X axis
     * shows time and includes today's date, otherwise to show the start of the dataset. <P> Set this property to override this
     * default, or use {@link com.smartgwt.client.widgets.chart.FacetChart#getZoomStartValue zoomStartValue} and {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getZoomEndValue zoomEndValue} to start with a particular range.
     *
     * @return ZoomStartPosition
     */
    public ZoomStartPosition getZoomStartPosition()  {
        return EnumUtil.getEnum(ZoomStartPosition.values(), getAttribute("zoomStartPosition"));
    }

    // ********************* Methods ***********************
    /**
     * Add a chartBackgroundDrawn handler.
     * <p>
     * Called when most elements of the chart <i>other than data</i> data have been drawn, including gradations and legend. <P>
     * This notification will be fired each time the chart is redrawn (due to resize, data change, etc).  If you want to draw
     * additional information on the chart using {@link com.smartgwt.client.widgets.drawing.DrawPane} (FacetChart's superclass)
     * and various {@link com.smartgwt.client.widgets.drawing.DrawItem}s, you should do in response to this notification.  Due
     * to auto-sizing, APIs that are typically used to position custom DrawItems (such as {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getChartLeft FacetChart.getChartLeft}) may return bad values if called at
     * other times. <P> Additional DrawItems added in this method will appear underneath data elements such as bars or columns.
     * See {@link com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn} for placing
     * DrawItems on top of data elements.
     *
     * @param handler the chartBackgroundDrawn handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addChartBackgroundDrawnHandler(com.smartgwt.client.widgets.chart.ChartBackgroundDrawnHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.chart.ChartBackgroundDrawnEvent.getType()) == 0) setupChartBackgroundDrawnEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.chart.ChartBackgroundDrawnEvent.getType());
    }

    private native void setupChartBackgroundDrawnEvent() /*-{
        var obj = null;
        var selfJ = this;
        var chartBackgroundDrawn = $entry(function(){
            var param = {};

                var event = @com.smartgwt.client.widgets.chart.ChartBackgroundDrawnEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({chartBackgroundDrawn:  chartBackgroundDrawn              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.chartBackgroundDrawn =  chartBackgroundDrawn             ;
        }
   }-*/;
    /**
     * Add a chartDrawn handler.
     * <p>
     * Called when all elements of the chart (data lines / shapes, gradations, legend, labels etc) have completed drawing.  
     * <P> See {@link com.smartgwt.client.widgets.chart.FacetChart#addChartBackgroundDrawnHandler
     * FacetChart.chartBackgroundDrawn} for usage information.
     *
     * @param handler the chartDrawn handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addChartDrawnHandler(com.smartgwt.client.widgets.chart.ChartDrawnHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.chart.ChartDrawnEvent.getType()) == 0) setupChartDrawnEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.chart.ChartDrawnEvent.getType());
    }

    private native void setupChartDrawnEvent() /*-{
        var obj = null;
        var selfJ = this;
        var chartDrawn = $entry(function(){
            var param = {};

                var event = @com.smartgwt.client.widgets.chart.ChartDrawnEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({chartDrawn:  chartDrawn              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.chartDrawn =  chartDrawn             ;
        }
   }-*/;
    /**
     * Add a dataLabelClick handler.
     * <p>
     * Fires when the user clicks on a data label, that is, a text label showing values from the first facet.  For example, the
     * labels underneath the X-axis of a column chart, labelling each column.
     *
     * @param handler the dataLabelClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDataLabelClickHandler(com.smartgwt.client.widgets.chart.DataLabelClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.chart.DataLabelClickEvent.getType()) == 0) setupDataLabelClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.chart.DataLabelClickEvent.getType());
    }

    private native void setupDataLabelClickEvent() /*-{
        var obj = null;
        var selfJ = this;
        var dataLabelClick = $entry(function(){
            var param = {"facetValue" : arguments[0]};

                var event = @com.smartgwt.client.widgets.chart.DataLabelClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({dataLabelClick:  dataLabelClick              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.dataLabelClick =  dataLabelClick             ;
        }
   }-*/;
    /**
     * Add a dataLabelHover handler.
     * <p>
     * Fires when the mouse hovers over a data label, that is, a text label showing values from the first facet.  For example,
     * the labels underneath the X-axis of a column chart, labelling each column.
     *
     * @param handler the dataLabelHover handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDataLabelHoverHandler(com.smartgwt.client.widgets.chart.DataLabelHoverHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.chart.DataLabelHoverEvent.getType()) == 0) setupDataLabelHoverEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.chart.DataLabelHoverEvent.getType());
    }

    private native void setupDataLabelHoverEvent() /*-{
        var obj = null;
        var selfJ = this;
        var dataLabelHover = $entry(function(){
            var param = {"facetValue" : arguments[0]};

                var event = @com.smartgwt.client.widgets.chart.DataLabelHoverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({dataLabelHover:  dataLabelHover              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.dataLabelHover =  dataLabelHover             ;
        }
   }-*/;

	/**
     * Returns whether a given {@link com.smartgwt.client.widgets.chart.DrawnValue} contains a point. The point's X and Y
     * coordinates may be passed into this method, or, if unspecified, the coordinates used are the current mouse event
     * coordinates. <p> For Scatter, Area, Line, and Radar charts, a DrawnValue is considered to contain a point if the
     * Euclidean distance from the DrawnValue's center ({@link com.smartgwt.client.widgets.chart.DrawnValue#getX x}, {@link
     * com.smartgwt.client.widgets.chart.DrawnValue#getY y}) to the point is less than {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getDataPointSize this.dataPointSize}. For Pie charts, the DrawnValue is
     * considered to contain a point if the point is within the pie slice. Similarly, for Doughnut charts, the DrawnValue is
     * considered to contain a point if the point is within the pie slice and not in the doughnut hole. For Bar and Column
     * charts, the DrawnValue is considered to contain a point if the point is within the bar or column, respectively. Note
     * that for stacked Bar and Column charts, the point must also be in the stacked portion as opposed to anywhere within the
     * bar or column.
     * @param drawnValue the DrawnValue to check. The DrawnValue must be a valid DrawnValue from this chart.
     *
     * @return true if the DrawnValue contains the point at the given X, Y coordinates (or current mouse event coordinates); false if
     * the DrawnValue does not contain the point; null for invalid parameters.
     */
    public native Boolean drawnValueContainsPoint(DrawnValue drawnValue) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.drawnValueContainsPoint(drawnValue.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

    /**
     * @see {@link FacetChart#drawnValueContainsPoint()}
     */
    public Boolean drawnValueContainsPoint(DrawnValue drawnValue, Integer x){
        return drawnValueContainsPoint(drawnValue, x, (Integer) null);
    }

	/**
     * Returns whether a given {@link com.smartgwt.client.widgets.chart.DrawnValue} contains a point. The point's X and Y
     * coordinates may be passed into this method, or, if unspecified, the coordinates used are the current mouse event
     * coordinates. <p> For Scatter, Area, Line, and Radar charts, a DrawnValue is considered to contain a point if the
     * Euclidean distance from the DrawnValue's center ({@link com.smartgwt.client.widgets.chart.DrawnValue#getX x}, {@link
     * com.smartgwt.client.widgets.chart.DrawnValue#getY y}) to the point is less than {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getDataPointSize this.dataPointSize}. For Pie charts, the DrawnValue is
     * considered to contain a point if the point is within the pie slice. Similarly, for Doughnut charts, the DrawnValue is
     * considered to contain a point if the point is within the pie slice and not in the doughnut hole. For Bar and Column
     * charts, the DrawnValue is considered to contain a point if the point is within the bar or column, respectively. Note
     * that for stacked Bar and Column charts, the point must also be in the stacked portion as opposed to anywhere within the
     * bar or column.
     * @param drawnValue the DrawnValue to check. The DrawnValue must be a valid DrawnValue from this chart.
     * @param x X coordinate of the point. If this parameter is specified, then <code>y</code> is a required parameter.
     * @param y Y coordinate of the point
     *
     * @return true if the DrawnValue contains the point at the given X, Y coordinates (or current mouse event coordinates); false if
     * the DrawnValue does not contain the point; null for invalid parameters.
     */
    public native Boolean drawnValueContainsPoint(DrawnValue drawnValue, Integer x, Integer y) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.drawnValueContainsPoint(drawnValue.@com.smartgwt.client.core.DataClass::getJsObj()(), x == null ? null : x.@java.lang.Integer::intValue()(), y == null ? null : y.@java.lang.Integer::intValue()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Returns the centerpoint for radar charts and pie charts. <P> Note that unstacked pie charts draw multiple pies, each
     * with their own centers. <P> This is only allowed to be called when {@link
     * com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn} fires.
     *
     * @return the centerpoint for radar charts and pie charts.
     */
    public native Point getChartCenter() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getChartCenter();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.drawing.Point::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


	/**
     * Get the height the central chart area, where data elements appear. <P>  This is only allowed to be called when {@link
     * com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn} fires.
     * @param recalc if false then cached value will be returned,  otherwise will be recalculated.
     *
     * @return the width of the central chart area.
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public native float getChartHeight(boolean recalc) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getChartHeight(recalc == null ? false : recalc);
        return ret;
    }-*/;

	/**
     * Get the height the central chart area, where data elements appear. <P>  This is only allowed to be called when {@link
     * com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn} fires.
     * @param recalc if false then cached value will be returned,  otherwise will be recalculated.
     *
     * @return the width of the central chart area.
     */
    public native double getChartHeightAsDouble(boolean recalc) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getChartHeight(recalc == null ? false : recalc);
        return ret;
    }-*/;


	/**
     * Get the left margin of the central chart area, where data elements appear. <P>  This is only allowed to be called when
     * {@link com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn} fires.
     *
     * @return left margin of the central chart area
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public native float getChartLeft() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getChartLeft();
        return ret;
    }-*/;

	/**
     * Get the left margin of the central chart area, where data elements appear. <P>  This is only allowed to be called when
     * {@link com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn} fires.
     *
     * @return left margin of the central chart area
     */
    public native double getChartLeftAsDouble() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getChartLeft();
        return ret;
    }-*/;


	/**
     * Returns the radius for radar charts and pie charts.  For stacked pie charts this is radius of the outermost pie. <P>
     * Note that unstacked pie charts draw multiple pies, each with their own radii. <P> This is only allowed to be called when
     * {@link com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn} fires.
     *
     * @return the radius for radar charts and pie charts.
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public native float getChartRadius() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getChartRadius();
        return ret;
    }-*/;

	/**
     * Returns the radius for radar charts and pie charts.  For stacked pie charts this is radius of the outermost pie. <P>
     * Note that unstacked pie charts draw multiple pies, each with their own radii. <P> This is only allowed to be called when
     * {@link com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn} fires.
     *
     * @return the radius for radar charts and pie charts.
     */
    public native double getChartRadiusAsDouble() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getChartRadius();
        return ret;
    }-*/;


	/**
     * Get the top coordinate of the central chart area, where data elements appear.  <P> This is only allowed to be called
     * when {@link com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn} fires.
     *
     * @return The top coordinate of the central chart area
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public native float getChartTop() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getChartTop();
        return ret;
    }-*/;

	/**
     * Get the top coordinate of the central chart area, where data elements appear.  <P> This is only allowed to be called
     * when {@link com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn} fires.
     *
     * @return The top coordinate of the central chart area
     */
    public native double getChartTopAsDouble() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getChartTop();
        return ret;
    }-*/;


	/**
     * Get the width of the central chart area, where data elements appear. <P>  This is only allowed to be called when {@link
     * com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn} fires.
     * @param recalc if false then cached value will be returned,  otherwise will be recalculated.
     *
     * @return the width of the central chart area.
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public native float getChartWidth(boolean recalc) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getChartWidth(recalc == null ? false : recalc);
        return ret;
    }-*/;

	/**
     * Get the width of the central chart area, where data elements appear. <P>  This is only allowed to be called when {@link
     * com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn} fires.
     * @param recalc if false then cached value will be returned,  otherwise will be recalculated.
     *
     * @return the width of the central chart area.
     */
    public native double getChartWidthAsDouble(boolean recalc) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getChartWidth(recalc == null ? false : recalc);
        return ret;
    }-*/;


	/**
     * Get a color from the {@link com.smartgwt.client.widgets.chart.FacetChart#getDataColors dataColors} Array <P> Override to
     * provide a dynamic color generation scheme.
     * @param index index of the visual element to be colored
     *
     * @return 
     */
    public native String getDataColor(int index) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDataColor(index);
        return ret;
    }-*/;

	/**
     * Returns the {@link com.smartgwt.client.widgets.cube.Facet} in the list of {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getFacets facets} whose {@link
     * com.smartgwt.client.widgets.cube.Facet#getValues values} are rendered as labels along the data axis of the chart or in
     * the main chart area. <p> Most single-facet charts and all multi-facet charts have the data label facet as their first
     * facet.  The exceptions are that single-facet Pie/Doughnut charts and Scatter charts do not have data label facets. <p>
     * Note that the user may swap the data label facet and the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getLegendFacet legend facet} in most chart types using the context menu.
     *
     * @return the data label facet, or <code>null</code> if there is no such facet
     * @see com.smartgwt.client.widgets.chart.FacetChart#getFacets
     */
    public native Facet getDataLabelFacet() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDataLabelFacet();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.cube.Facet::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


	/**
     * Called when the mouse hovers over a data label, that is, a text label showing values from the first facet.  For example,
     * the labels underneath the X-axis of a column chart, labelling each column.
     * @param facetValue facetValue that was hovered
     *
     * @return hover text to be shown.  Return null to avoid a hover being shown
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#drillCharting" target="examples">Drill Up/Down Example</a>
     */
    public native String getDataLabelHoverHTML(FacetValue facetValue) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDataLabelHoverHTML(facetValue.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;


	/**
     * Returns rendering information for the data value specified by the passed facet values. <p> If called before {@link
     * com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn}, logs a warning and returns
     * null.
     * @param facetValues facet values of desired data value
     *
     * @return the drawn value, or null for invalid arguments / incorrect timing                   of call
     */
    public native DrawnValue getDrawnValue(FacetValueMap facetValues) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDrawnValue(facetValues == null ? null : facetValues.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.chart.DrawnValue::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns a {@link com.smartgwt.client.widgets.chart.DrawnValue} object for the data value that is shown nearest to the
     * passed coordinates only if it's under the given coordinates, or under the current mouse event coordinates if no
     * coordinates are passed. This method is similar to {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getNearestDrawnValue FacetChart.getNearestDrawnValue}, but the DrawnValue
     * is only returned if it's under the coordinates. <p> See {@link
     * com.smartgwt.client.widgets.chart.FacetChart#drawnValueContainsPoint FacetChart.drawnValueContainsPoint} for the
     * criteria that determine whether a DrawnValue is under (contains) the coordinates.
     *
     * @return the nearest drawn value if under the given coordinates (or current mouse event coordinates) or null if not under the
     * coordinates, or for invalid arguments / incorrect timing of call.
     */
    public native DrawnValue getDrawnValueAtPoint() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDrawnValueAtPoint();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.chart.DrawnValue::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * @see {@link FacetChart#getDrawnValueAtPoint()}
     */
    public DrawnValue getDrawnValueAtPoint(Integer x){
        return getDrawnValueAtPoint(x, (Integer) null, null);
    }

    /**
     * @see {@link FacetChart#getDrawnValueAtPoint()}
     */
    public DrawnValue getDrawnValueAtPoint(Integer x, Integer y){
        return getDrawnValueAtPoint(x, y, null);
    }

	/**
     * Returns a {@link com.smartgwt.client.widgets.chart.DrawnValue} object for the data value that is shown nearest to the
     * passed coordinates only if it's under the given coordinates, or under the current mouse event coordinates if no
     * coordinates are passed. This method is similar to {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getNearestDrawnValue FacetChart.getNearestDrawnValue}, but the DrawnValue
     * is only returned if it's under the coordinates. <p> See {@link
     * com.smartgwt.client.widgets.chart.FacetChart#drawnValueContainsPoint FacetChart.drawnValueContainsPoint} for the
     * criteria that determine whether a DrawnValue is under (contains) the coordinates.
     * @param x X coordinate. If this parameter is specified, then <code>y</code> is a required parameter.
     * @param y Y coordinate
     * @param metric metric over which to determine the drawn value
     *
     * @return the nearest drawn value if under the given coordinates (or current mouse event coordinates) or null if not under the
     * coordinates, or for invalid arguments / incorrect timing of call.
     */
    public native DrawnValue getDrawnValueAtPoint(Integer x, Integer y, String metric) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDrawnValueAtPoint(x == null ? null : x.@java.lang.Integer::intValue()(), y == null ? null : y.@java.lang.Integer::intValue()(), metric);
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.chart.DrawnValue::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns rendering information for the data values specified by the passed facet values. <p> If called before {@link
     * com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn}, logs a warning and returns
     * null.
     *
     * @return the DrawnValues, or null for invalid arguments / incorrect timing of call
     */
    public native DrawnValue[] getDrawnValues() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDrawnValues();
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfDrawnValue(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns rendering information for the data values specified by the passed facet values. <p> If called before {@link
     * com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn}, logs a warning and returns
     * null.
     * @param facetValues facet values of desired DrawnValues. If no FacetValueMap is provided, then all DrawnValues are returned.
     *
     * @return the DrawnValues, or null for invalid arguments / incorrect timing of call
     */
    public native DrawnValue[] getDrawnValues(FacetValueMap facetValues) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDrawnValues(facetValues == null ? null : facetValues.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfDrawnValue(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns an array of {@link com.smartgwt.client.widgets.chart.DrawnValue} objects for the data values of each metric that
     * are shown nearest to the passed coordinates, but only if they're under the given coordinates, or under the current mouse
     * event coordinates if no coordinates are passed. This method is similar to {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getNearestDrawnValues FacetChart.getNearestDrawnValues}, but DrawnValues
     * are only included in the returned array if they're under the coordinates. <p> See {@link
     * com.smartgwt.client.widgets.chart.FacetChart#drawnValueContainsPoint FacetChart.drawnValueContainsPoint} for the
     * criteria that determine whether a DrawnValue is under (contains) the coordinates.
     *
     * @return the nearest DrawnValues that are under the given coordinates (or current mouse event coordinates), or null for invalid
     * arguments / incorrect timing of call.
     */
    public native DrawnValue[] getDrawnValuesAtPoint() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDrawnValuesAtPoint();
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfDrawnValue(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * @see {@link FacetChart#getDrawnValuesAtPoint()}
     */
    public DrawnValue[] getDrawnValuesAtPoint(Integer x){
        return getDrawnValuesAtPoint(x, (Integer) null);
    }

	/**
     * Returns an array of {@link com.smartgwt.client.widgets.chart.DrawnValue} objects for the data values of each metric that
     * are shown nearest to the passed coordinates, but only if they're under the given coordinates, or under the current mouse
     * event coordinates if no coordinates are passed. This method is similar to {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getNearestDrawnValues FacetChart.getNearestDrawnValues}, but DrawnValues
     * are only included in the returned array if they're under the coordinates. <p> See {@link
     * com.smartgwt.client.widgets.chart.FacetChart#drawnValueContainsPoint FacetChart.drawnValueContainsPoint} for the
     * criteria that determine whether a DrawnValue is under (contains) the coordinates.
     * @param x X coordinate. If this parameter is specified, then <code>y</code> is a required parameter.
     * @param y Y coordinate
     *
     * @return the nearest DrawnValues that are under the given coordinates (or current mouse event coordinates), or null for invalid
     * arguments / incorrect timing of call.
     */
    public native DrawnValue[] getDrawnValuesAtPoint(Integer x, Integer y) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDrawnValuesAtPoint(x == null ? null : x.@java.lang.Integer::intValue()(), y == null ? null : y.@java.lang.Integer::intValue()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfDrawnValue(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


	/**
     * Get a facet definition by facetId.
     * @param facetId the id of the facet to retrieve
     *
     * @return the Facet if found, or null
     * @see com.smartgwt.client.widgets.cube.Facet
     */
    public native Facet getFacet(String facetId) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getFacet(facetId);
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.cube.Facet::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


	/**
     * Get facet value definition by facetId and facetValueId.
     * @param facetId the id of the facet to retrieve
     * @param facetValueId the id of the facet value to retrieve
     *
     * @return the FacetValue if found, or null
     * @see com.smartgwt.client.widgets.cube.FacetValue
     */
    public native FacetValue getFacetValue(String facetId, String facetValueId) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getFacetValue(facetId, facetValueId);
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.cube.FacetValue::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Return an array of the gradation values used in the current chart.  Pass these values to {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getXCoord FacetChart.getXCoord} / {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getYCoord FacetChart.getYCoord} (depending on the orientation of the chart)
     * to discover the coordinates where gradations are drawn. <P> This is only allowed to be called when {@link
     * com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn} fires.
     *
     * @return an array of gradation values used in the current chart.
     */
    public native float[] getGradations() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getGradations();
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOffloat(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns the {@link com.smartgwt.client.widgets.cube.Facet} in the list of {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getFacets facets} whose {@link
     * com.smartgwt.client.widgets.cube.Facet#getValues values} are rendered in the chart's legend. <p> Most single-facet
     * charts do not have a legend facet.  The exceptions are that single-facet Pie/Doughnut charts have a legend facet as the
     * first facet and Scatter charts may optionally have a legend facet as the second facet, after the metric facet. <p> In
     * all multi-facet charts, the legend facet is the second facet. <p> Note that the user may swap the legend facet and the
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getDataLabelFacet data label facet} in most chart types using the
     * context menu.
     *
     * @return the legend facet, or <code>null</code> if there is no such facet
     * @see com.smartgwt.client.widgets.chart.FacetChart#getFacets
     */
    public native Facet getLegendFacet() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getLegendFacet();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.cube.Facet::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


	/**
     * Called when the mouse hovers over a color swatch or its label in the legend area of the chart. <p> The {@link
     * com.smartgwt.client.widgets.cube.FacetValue} that the user is hovering over is provided. If the chart is a {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics multi-axis chart}, the {@link
     * com.smartgwt.client.widgets.cube.FacetValue} for the hovered-over metric will also be provided.
     * @param facetValue facetValue that the mouse is over
     * @param metricFacetValue for a multi-axis chart, facetValue representing        the hovered-over metric.  Null if chart is not multi-axis
     *
     * @return hover text to be shown.  Return null to avoid a hover being shown
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#drillCharting" target="examples">Drill Up/Down Example</a>
     */
    public native String getLegendHoverHTML(FacetValue facetValue, FacetValue metricFacetValue) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getLegendHoverHTML(facetValue.@com.smartgwt.client.core.DataClass::getJsObj()(), metricFacetValue.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;

	/**
     * Returns rendering information for the data value that is shown nearest to the passed coordinates, as {@link
     * com.smartgwt.client.widgets.chart.DrawnValue} object. <p> Passed X and Y coordinates should be relative to the
     * FacetChart.  If neither an X or Y coordinate is passed, both X and Y will use the current {@link
     * com.smartgwt.client.widgets.Canvas#getOffsetX Canvas.getOffsetX} and {@link
     * com.smartgwt.client.widgets.Canvas#getOffsetY Canvas.getOffsetY}. <p> If called before {@link
     * com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn}, logs a warning and returns
     * null.  For a chart with multiple vertical axes, returns the nearest point from the first metric only (see {@link
     * com.smartgwt.client.widgets.chart.FacetChart FacetChart overview}). <p> To get the nearest DrawnValue only if it
     * contains the given coordinates, you can either use the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getDrawnValueAtPoint FacetChart.getDrawnValueAtPoint} API or call {@link
     * com.smartgwt.client.widgets.chart.FacetChart#drawnValueContainsPoint FacetChart.drawnValueContainsPoint} on the return
     * value. <p> Behavior for different chart types is as follows: <p> <h4>Bar / Column</h4> <p> Returns the centerpoint of
     * the end of the nearest bar or column by considering the Y coordinate (bar) or X coordinate (column) only. <p> <h4>Line /
     * Area</h4> <p> Returns the nearest point based on which data label is nearest to the passed X coordinate. For
     * multi-series charts, if Y coordinate is not passed the data point returned is from the series that has the highest value
     * at the data label. <p> <h4>Radar</h4> <p> Returns the data point nearest the passed coordinates by straight line
     * distance. Passing only one coordinate will cause a warning to be logged and null to be returned; passing neither
     * coordinate is allowed (<code>getOffsetX/Y</code> will be used). <p> <h4>Pie</h4> <p> Returns the data point for the
     * segment that would be hit if a line were drawn from the passed coordinates to the center of the pie. <p> If there are
     * multiple stacked pies, uses the pie that contains the passed coordinates, otherwise the outermost pie. <p> If there are
     * multiple non-stacked pies, uses the pie that is nearest the passed coordinates by straight-line distance to the center
     * of the pie. <p> Passing only one coordinate will cause a warning to be logged and null to be returned; passing neither
     * coordinate is allowed (<code>getOffsetX/Y</code> will be used). <p> If the chart is a {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics multi-axis chart} then this method takes an optional
     * parameter, <code>metric</code>, which causes this method to return a <code>DrawnValue</code> from the specified metric. 
     * If a metric is not passed then the first metric of the metric facet will be used (or just the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getValueProperty valueProperty} if there is no metric facet).
     *
     * @return the nearest drawn value, or null for invalid arguments / incorrect timing                  of call
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#chartCustomHovers" target="examples">Custom Hovers Example</a>
     */
    public native DrawnValue getNearestDrawnValue() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getNearestDrawnValue();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.chart.DrawnValue::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * @see {@link FacetChart#getNearestDrawnValue()}
     */
    public DrawnValue getNearestDrawnValue(Integer x){
        return getNearestDrawnValue(x, (Integer) null, null);
    }

    /**
     * @see {@link FacetChart#getNearestDrawnValue()}
     */
    public DrawnValue getNearestDrawnValue(Integer x, Integer y){
        return getNearestDrawnValue(x, y, null);
    }

	/**
     * Returns rendering information for the data value that is shown nearest to the passed coordinates, as {@link
     * com.smartgwt.client.widgets.chart.DrawnValue} object. <p> Passed X and Y coordinates should be relative to the
     * FacetChart.  If neither an X or Y coordinate is passed, both X and Y will use the current {@link
     * com.smartgwt.client.widgets.Canvas#getOffsetX Canvas.getOffsetX} and {@link
     * com.smartgwt.client.widgets.Canvas#getOffsetY Canvas.getOffsetY}. <p> If called before {@link
     * com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn}, logs a warning and returns
     * null.  For a chart with multiple vertical axes, returns the nearest point from the first metric only (see {@link
     * com.smartgwt.client.widgets.chart.FacetChart FacetChart overview}). <p> To get the nearest DrawnValue only if it
     * contains the given coordinates, you can either use the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getDrawnValueAtPoint FacetChart.getDrawnValueAtPoint} API or call {@link
     * com.smartgwt.client.widgets.chart.FacetChart#drawnValueContainsPoint FacetChart.drawnValueContainsPoint} on the return
     * value. <p> Behavior for different chart types is as follows: <p> <h4>Bar / Column</h4> <p> Returns the centerpoint of
     * the end of the nearest bar or column by considering the Y coordinate (bar) or X coordinate (column) only. <p> <h4>Line /
     * Area</h4> <p> Returns the nearest point based on which data label is nearest to the passed X coordinate. For
     * multi-series charts, if Y coordinate is not passed the data point returned is from the series that has the highest value
     * at the data label. <p> <h4>Radar</h4> <p> Returns the data point nearest the passed coordinates by straight line
     * distance. Passing only one coordinate will cause a warning to be logged and null to be returned; passing neither
     * coordinate is allowed (<code>getOffsetX/Y</code> will be used). <p> <h4>Pie</h4> <p> Returns the data point for the
     * segment that would be hit if a line were drawn from the passed coordinates to the center of the pie. <p> If there are
     * multiple stacked pies, uses the pie that contains the passed coordinates, otherwise the outermost pie. <p> If there are
     * multiple non-stacked pies, uses the pie that is nearest the passed coordinates by straight-line distance to the center
     * of the pie. <p> Passing only one coordinate will cause a warning to be logged and null to be returned; passing neither
     * coordinate is allowed (<code>getOffsetX/Y</code> will be used). <p> If the chart is a {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics multi-axis chart} then this method takes an optional
     * parameter, <code>metric</code>, which causes this method to return a <code>DrawnValue</code> from the specified metric. 
     * If a metric is not passed then the first metric of the metric facet will be used (or just the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getValueProperty valueProperty} if there is no metric facet).
     * @param x X coordinate. If this parameter is specified, then <code>y</code> is a required parameter.
     * @param y Y coordinate
     * @param metric metric over which to determine the drawn value
     *
     * @return the nearest drawn value, or null for invalid arguments / incorrect timing                  of call
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#chartCustomHovers" target="examples">Custom Hovers Example</a>
     */
    public native DrawnValue getNearestDrawnValue(Integer x, Integer y, String metric) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getNearestDrawnValue(x == null ? null : x.@java.lang.Integer::intValue()(), y == null ? null : y.@java.lang.Integer::intValue()(), metric);
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.chart.DrawnValue::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns an array of {@link com.smartgwt.client.widgets.chart.DrawnValue} objects containing rendering information for
     * the data values having each metric that are shown nearest to the passed coordinates. <P> Passed X and Y coordinates
     * should be relative to the FacetChart.  If neither an X or Y coordinate is passed, both X and Y will use the current
     * {@link com.smartgwt.client.widgets.Canvas#getOffsetX Canvas.getOffsetX} and {@link
     * com.smartgwt.client.widgets.Canvas#getOffsetY Canvas.getOffsetY}. <P> The behavior for different chart types is the same
     * as {@link com.smartgwt.client.widgets.chart.FacetChart#getNearestDrawnValue FacetChart.getNearestDrawnValue}.  This
     * method also logs a warning and returns null if called before {@link
     * com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn}. <p> To get the nearest
     * DrawnValues only if they contain the given coordinates, you can either use the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getDrawnValuesAtPoint FacetChart.getDrawnValuesAtPoint} API or check
     * whether each DrawnValue in the returned array contains the point by calling {@link
     * com.smartgwt.client.widgets.chart.FacetChart#drawnValueContainsPoint FacetChart.drawnValueContainsPoint}.
     *
     * @return the nearest drawn values for each metric, or null for invalid arguments / incorrect timing of call
     * @see com.smartgwt.client.widgets.chart.FacetChart#getDrawnValuesAtPoint
     */
    public native DrawnValue[] getNearestDrawnValues() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getNearestDrawnValues();
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfDrawnValue(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * @see {@link FacetChart#getNearestDrawnValues()}
     */
    public DrawnValue[] getNearestDrawnValues(Integer x){
        return getNearestDrawnValues(x, (Integer) null);
    }

	/**
     * Returns an array of {@link com.smartgwt.client.widgets.chart.DrawnValue} objects containing rendering information for
     * the data values having each metric that are shown nearest to the passed coordinates. <P> Passed X and Y coordinates
     * should be relative to the FacetChart.  If neither an X or Y coordinate is passed, both X and Y will use the current
     * {@link com.smartgwt.client.widgets.Canvas#getOffsetX Canvas.getOffsetX} and {@link
     * com.smartgwt.client.widgets.Canvas#getOffsetY Canvas.getOffsetY}. <P> The behavior for different chart types is the same
     * as {@link com.smartgwt.client.widgets.chart.FacetChart#getNearestDrawnValue FacetChart.getNearestDrawnValue}.  This
     * method also logs a warning and returns null if called before {@link
     * com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn}. <p> To get the nearest
     * DrawnValues only if they contain the given coordinates, you can either use the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getDrawnValuesAtPoint FacetChart.getDrawnValuesAtPoint} API or check
     * whether each DrawnValue in the returned array contains the point by calling {@link
     * com.smartgwt.client.widgets.chart.FacetChart#drawnValueContainsPoint FacetChart.drawnValueContainsPoint}.
     * @param x X coordinate. If this parameter is specified, then <code>y</code> is a required parameter.
     * @param y Y coordinate
     *
     * @return the nearest drawn values for each metric, or null for invalid arguments / incorrect timing of call
     * @see com.smartgwt.client.widgets.chart.FacetChart#getDrawnValuesAtPoint
     */
    public native DrawnValue[] getNearestDrawnValues(Integer x, Integer y) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getNearestDrawnValues(x == null ? null : x.@java.lang.Integer::intValue()(), y == null ? null : y.@java.lang.Integer::intValue()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfDrawnValue(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Count the number of data points.
     *
     * @return the number of data values
     */
    public native int getNumDataPoints() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getNumDataPoints();
        return ret;
    }-*/;

	/**
     * Count the number of data points.
     * @param criteria a set of facetValues describing a slice of the data
     *
     * @return the number of data values
     */
    public native int getNumDataPoints(FacetValueMap criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getNumDataPoints(criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;

	/**
     * For scatter plots only, get a Function from the specified independent variable X to the specified dependent variable Y
     * that defines the polynomial that best fits the data. See <a
     * href="http://en.wikipedia.org/wiki/Polynomial_regression">http://en.wikipedia.org/wiki/Polynomial_regression</a>.
     */
    public native void getPolynomialRegressionFunction() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.getPolynomialRegressionFunction();
    }-*/;

    /**
     * @see {@link FacetChart#getPolynomialRegressionFunction()}
     */
    public void getPolynomialRegressionFunction(Integer degree){
        getPolynomialRegressionFunction(degree, null, null);
    }

    /**
     * @see {@link FacetChart#getPolynomialRegressionFunction()}
     */
    public void getPolynomialRegressionFunction(Integer degree, String xMetric){
        getPolynomialRegressionFunction(degree, xMetric, null);
    }

	/**
     * For scatter plots only, get a Function from the specified independent variable X to the specified dependent variable Y
     * that defines the polynomial that best fits the data. See <a
     * href="http://en.wikipedia.org/wiki/Polynomial_regression">http://en.wikipedia.org/wiki/Polynomial_regression</a>.
     * @param degree the degree of the polynomial.  Defaults to {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getRegressionPolynomialDegree regressionPolynomialDegree}.
     * @param xMetric ID of an inlined facet value to use as the independent variable. Defaults to the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getXAxisMetric x-axis metric}.
     * @param yMetric ID of an inlined facet value to use as the dependent variable. Defaults to the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getYAxisMetric y-axis metric}.
     */
    public native void getPolynomialRegressionFunction(Integer degree, String xMetric, String yMetric) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.getPolynomialRegressionFunction(degree == null ? null : degree.@java.lang.Integer::intValue()(), xMetric, yMetric);
    }-*/;

	/**
     * For scatter plots only, get a Function from the specified independent variable X to the specified dependent variable Y
     * that defines the line that best fits the data. See <a
     * href="http://en.wikipedia.org/wiki/Simple_linear_regression">http://en.wikipedia.org/wiki/Simple_linear_regression</a>.
     */
    public native void getSimpleLinearRegressionFunction() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.getSimpleLinearRegressionFunction();
    }-*/;

    /**
     * @see {@link FacetChart#getSimpleLinearRegressionFunction()}
     */
    public void getSimpleLinearRegressionFunction(String xMetric){
        getSimpleLinearRegressionFunction(xMetric, null);
    }

	/**
     * For scatter plots only, get a Function from the specified independent variable X to the specified dependent variable Y
     * that defines the line that best fits the data. See <a
     * href="http://en.wikipedia.org/wiki/Simple_linear_regression">http://en.wikipedia.org/wiki/Simple_linear_regression</a>.
     * @param xMetric ID of an inlined facet value to use as the independent variable. Defaults to the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getXAxisMetric x-axis metric}.
     * @param yMetric ID of an inlined facet value to use as the dependent variable. Defaults to the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getYAxisMetric y-axis metric}.
     */
    public native void getSimpleLinearRegressionFunction(String xMetric, String yMetric) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.getSimpleLinearRegressionFunction(xMetric, yMetric);
    }-*/;

    /**
     * Add a legendClick handler.
     * <p>
     * Fires when the user clicks on the legend area of the chart. <p> If the user specifically clicks on a color swatch or
     * it's label, the {@link com.smartgwt.client.widgets.cube.FacetValue} clicked on will be provided. <p> If the chart is a
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics multi-axis chart}, the {@link
     * com.smartgwt.client.widgets.cube.FacetValue} for the clicked-on metric will also be provided.
     *
     * @param handler the legendClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addLegendClickHandler(com.smartgwt.client.widgets.chart.LegendClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.chart.LegendClickEvent.getType()) == 0) setupLegendClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.chart.LegendClickEvent.getType());
    }

    private native void setupLegendClickEvent() /*-{
        var obj = null;
        var selfJ = this;
        var legendClick = $entry(function(){
            var param = {"facetValue" : arguments[0], "metricFacetValue" : arguments[1]};

                var event = @com.smartgwt.client.widgets.chart.LegendClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({legendClick:  legendClick              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.legendClick =  legendClick             ;
        }
   }-*/;
    /**
     * Add a legendHover handler.
     * <p>
     * Fires when the mouse hovers over a color swatch or its label in the legend area of the chart. <p> The {@link
     * com.smartgwt.client.widgets.cube.FacetValue} that the user is hovering over is provided. If the chart is a {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics multi-axis chart}, the {@link
     * com.smartgwt.client.widgets.cube.FacetValue} for the hovered-over metric will also be provided.
     *
     * @param handler the legendHover handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addLegendHoverHandler(com.smartgwt.client.widgets.chart.LegendHoverHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.chart.LegendHoverEvent.getType()) == 0) setupLegendHoverEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.chart.LegendHoverEvent.getType());
    }

    private native void setupLegendHoverEvent() /*-{
        var obj = null;
        var selfJ = this;
        var legendHover = $entry(function(){
            var param = {"facetValue" : arguments[0], "metricFacetValue" : arguments[1]};

                var event = @com.smartgwt.client.widgets.chart.LegendHoverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({legendHover:  legendHover              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.legendHover =  legendHover             ;
        }
   }-*/;
    /**
     * Add a valueClick handler.
     * <p>
     * Fires when a data value is clicked, and provides information about the data value that was clicked as a {@link
     * com.smartgwt.client.widgets.chart.DrawnValue} object. <p> Specifically, this fires for clicks on pie slices, bars or
     * columns, areas, lines or points (in a Scatter plot). <p> If there are multiple data values at the clicked position, you
     * can use {@link com.smartgwt.client.widgets.chart.FacetChart#getNearestDrawnValues FacetChart.getNearestDrawnValues} to
     * discover the full list of values at the current coordinate (pass in {@link com.smartgwt.client.widgets.Canvas#getOffsetX
     * getOffsetX/Y()} for the coordinates). <p> If you want to create behaviors for clicking or moving <i>near</i> shapes
     * without requiring a direct hit, implement a standard {@link com.smartgwt.client.widgets.Canvas#addClickHandler
     * Canvas.click} handler on the FacetChart as a whole and use {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getNearestDrawnValue FacetChart.getNearestDrawnValue} to discover the
     * nearest data values.
     *
     * @param handler the valueClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addValueClickHandler(com.smartgwt.client.widgets.chart.ValueClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.chart.ValueClickEvent.getType()) == 0) setupValueClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.chart.ValueClickEvent.getType());
    }

    private native void setupValueClickEvent() /*-{
        var obj = null;
        var selfJ = this;
        var valueClick = $entry(function(){
            var param = {"drawnValue" : arguments[0]};

                var event = @com.smartgwt.client.widgets.chart.ValueClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({valueClick:  valueClick              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.valueClick =  valueClick             ;
        }
   }-*/;
    /**
     * Add a zoomChanged handler.
     * <p>
     * Fires when the end user changes the zoom position in a {@link com.smartgwt.client.widgets.chart.FacetChart#getCanZoom
     * zoomed chart}.
     *
     * @param handler the zoomChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addZoomChangedHandler(com.smartgwt.client.widgets.chart.ZoomChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.chart.ZoomChangedEvent.getType()) == 0) setupZoomChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.chart.ZoomChangedEvent.getType());
    }

    private native void setupZoomChangedEvent() /*-{
        var obj = null;
        var selfJ = this;
        var zoomChanged = $entry(function(){
            var param = {"startValue" : arguments[0], "endValue" : arguments[1]};

                var event = @com.smartgwt.client.widgets.chart.ZoomChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({zoomChanged:  zoomChanged              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.zoomChanged =  zoomChanged             ;
        }
   }-*/;

	/**
     * For a {@link com.smartgwt.client.widgets.chart.FacetChart#getCanZoom zoomed chart}, simultaneously sets the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#setZoomStartValue zoomStartValue} and {@link
     * com.smartgwt.client.widgets.chart.FacetChart#setZoomEndValue zoomEndValue}.
     * @param startValue starting value for the data range shown in the main chart
     * @param endValue ending value for the data range shown in the main chart
     */
    public native void zoomTo(Object startValue, Object endValue) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.zoomTo(startValue, endValue);
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
     * @param facetChartProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(FacetChart facetChartProperties) /*-{
    	var properties = $wnd.isc.addProperties({},facetChartProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
        $wnd.isc.FacetChart.addProperties(properties);
    }-*/;

    // ***********************************************************



    private ValueFormatter xAxisValueFormatter, yAxisValueFormatter;

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
    	 return com.smartgwt.client.util.ConvertTo.arrayOfRecord(getAttributeAsJavaScriptObject("data"));
    }

    public RecordList getDataAsRecordList() {
        JavaScriptObject dataJS = getAttributeAsJavaScriptObject("data");
        if(dataJS == null) return null;
        return new RecordList(dataJS);
    }
    
//    /**
//     * Return the chart's facets.
//     *
//     * @return the facets
//     */
//    public native Facet[] getFacets() /*-{
//        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
//        var facetsJS = self.getProperty('facets');
//        return @com.smartgwt.client.util.ConvertTo::arrayOfFacet(Lcom/google/gwt/core/client/JavaScriptObject;)(facetsJS);
//    }-*/;

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
     * Called when the mouse hovers over a data label, that is, a text label showing values from
     * the first facet.  For example, the labels underneath the X-axis of a column chart,
     * labelling each column.
     * 
     * @param dataLabelHoverHTMLCustomizer
     */
    public native void setDataLabelHoverHTMLCustomizer(DataLabelHoverCustomizer dataLabelHoverHTMLCustomizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self =  this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
             self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        self.getDataLabelHoverHTML = $debox($entry(function(value) {
            var facetValueJ = @com.smartgwt.client.widgets.cube.FacetValue::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(value);
            return dataLabelHoverHTMLCustomizer.@com.smartgwt.client.widgets.chart.DataLabelHoverCustomizer::hoverHTML(Lcom/smartgwt/client/widgets/cube/FacetValue;)(facetValueJ);
        }));
    }-*/;

    /**
     * Called when the mouse hovers over a color swatch or its label in the legend area of the
     * chart.
     * <p>
     * The +link{FacetValue} that the user is hovering over is provided.
     * If the chart is a +link{facetChart.extraAxisMetrics,multi-axis chart}, the
     * +link{FacetValue} for the hovered-over metric will also be provided.
     * 
     * @param facetValue (FacetValue) facetValue that the mouse is over
     * @param metricFacetValue (FacetValue) for a multi-axis chart, facetValue representing
     *        the hovered-over metric.  Null if chart is not multi-axis
     */
    public native void setLegendHoverCustomizer(LegendHoverCustomizer legendHoverHTMLCustomizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self =  this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
             self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        self.getLegendHoverHTML = $debox($entry(function(value, metricFacetValue) {
            var facetValueJ = @com.smartgwt.client.widgets.cube.FacetValue::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(value);
            var metricFacetValueJ = @com.smartgwt.client.widgets.cube.FacetValue::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(metricFacetValue);
            return legendHoverHTMLCustomizer.@com.smartgwt.client.widgets.chart.LegendHoverCustomizer::hoverHTML(Lcom/smartgwt/client/widgets/cube/FacetValue;Lcom/smartgwt/client/widgets/cube/FacetValue;)(facetValueJ,metricFacetValueJ);
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
     * To print a <code>FacetChart</code> for export on IE8 and earlier, it is 
     * {@link com.smartgwt.client.util.PrintProperties} with {@link com.smartgwt.client.util.PrintProperties#getPrintForExport
     * printForExport}:true:
     * <pre>
     * final PrintProperties pp = new PrintProperties();
     * pp.setPrintForExport(true);
     * final String exportHTML = chart.getPrintHTML(pp, null);
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

    private void error(String attribute, String value) throws IllegalStateException {
        assert id != null;
        error("Cannot change configuration property '" + attribute + "' to " + value + " now that component " + id + " has been created.");
    }

    private native Object getAttributeAsObject(String property) /*-{
        var ret;
        if (this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            ret = widget.getProperty(property);
        } else {
            var config = this.@com.smartgwt.client.widgets.BaseWidget::config;
            if (config[property] != undefined) {
                ret = config[property];
            } else {
                var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
                ret = $wnd.isc[scClassName].getInstanceProperty(property);
            }
        }
        return (ret == null || ret === undefined ? null : $wnd.SmartGWT.convertToJavaType(ret));
    }-*/;

    private void setAttribute(String attribute, Object value, boolean allowPostCreate) {
        if (!isCreated()) {
            JSOHelper.setAttribute(config, attribute, value);
        } else if (allowPostCreate) {
            // Similar to JSOHelper.setAttribute(JavaScriptObject, String, Object), except that
            // BaseWidget.setProperty() methods are used instead of simply setting the
            // attribute value.
            if (value == null) {
                setNullProperty(attribute);
            } else if (value instanceof String || value instanceof Character) {
                setProperty(attribute, value.toString());
            } else if (value instanceof Number) {
                if (value instanceof Integer) {
                    setProperty(attribute, ((Integer)value).intValue());
                } else if (value instanceof Float) {
                    setProperty(attribute, ((Float)value).floatValue());
                } else {
                    setProperty(attribute, ((Number)value).doubleValue());
                }
            } else if (value instanceof Date) {
                setProperty(attribute, JSOHelper.convertToJavaScriptDate((Date)value));
            } else if (value instanceof JavaScriptObject) {
                setProperty(attribute, (JavaScriptObject)value);
            } else if (value instanceof Boolean) {
                setProperty(attribute, ((Boolean)value).booleanValue());
            } else if (value instanceof RelativeDate) {
                setProperty(attribute, ((RelativeDate)value).getValue());
            } else if (value instanceof ValueEnum) {
                setProperty(attribute, ((ValueEnum)value).getValue());
            } else if (value.getClass().isArray()) {
                if (value instanceof Object[]) {
                    setProperty(attribute, JSOHelper.convertToJavaScriptArray((Object[])value));
                } else if (value instanceof int[]) {
                    setProperty(attribute, JSOHelper.convertToJavaScriptArray((int[])value));
                } else if (value instanceof double[]) {
                    setProperty(attribute, JSOHelper.convertToJavaScriptArray((double[])value));
                } else if (value instanceof float[]) {
                    setProperty(attribute, JSOHelper.convertToJavaScriptArray((float[])value));
                } else if (value instanceof boolean[]) {
                    setProperty(attribute, JSOHelper.convertToJavaScriptArray((boolean[])value));
                } else if (value instanceof char[]) {
                    setProperty(attribute, JSOHelper.convertToJavaScriptArray((char[])value));
                } else if (value instanceof byte[]) {
                    setProperty(attribute, JSOHelper.convertToJavaScriptArray((byte[])value));
                } else if (value instanceof short[]) {
                    setProperty(attribute, JSOHelper.convertToJavaScriptArray((short[])value));
                } else if (value instanceof long[]) {
                    setProperty(attribute, JSOHelper.convertToJavaScriptArray((long[])value));
                } else {
                    assert false : value.getClass() + " should not be an array class.";
                    setProperty(attribute, value);
                }
            } else if (value instanceof List) {
                setProperty(attribute, JSOHelper.convertToJavaScriptArray(((List<?>)value).toArray()));
            } else if (value instanceof Iterator) {
                List listVal = new ArrayList();
                for (Iterator it = (Iterator)value; it.hasNext(); ) {
                    listVal.add(it.next());
                }
                setProperty(attribute, JSOHelper.convertToJavaScriptArray(listVal.toArray()));
            } else if (value instanceof Set) {
                setProperty(attribute, JSOHelper.convertToJavaScriptArray(((Set<?>)value).toArray()));
            } else if (value instanceof Map) {
                setProperty(attribute, JSOHelper.convertMapToJavascriptObject((Map<?, ?>)value));
            } else {
                setProperty(attribute, value);
            }
        } else {
            error(attribute, String.valueOf(value));
        }
    }

    private native void setProperty(String property, Object value) /*-{
        var widget = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        widget.setProperty(property, value);
    }-*/;

    /**
     * For a {@link com.smartgwt.client.widgets.chart.FacetChart#getCanZoom zoomed chart}, start value of the data range shown
     * in the main chart.  If {@link com.smartgwt.client.widgets.chart.FacetChart#getZoomEndValue zoomEndValue} is not also
     * set, the range shown will be from <code>zoomStartValue</code> to the end of the dataset. <P> The value provided should
     * be a value in the range of the facet for the X axis, for example, for a time-based axis, a Date instance, for a numeric
     * axis, a Number, for an axis that just has text labels (such as city names), a String.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.chart.FacetChart#getZoomStartValue zoomStartValue}. <p> Note that the {@link com.smartgwt.client.widgets.chart.FacetChart#getZoomStartValue zoomStartValue} and {@link com.smartgwt.client.widgets.chart.FacetChart#getZoomEndValue zoomEndValue} may be set simultaneously using {@link com.smartgwt.client.widgets.chart.FacetChart#zoomTo FacetChart.zoomTo}.
     *
     * @param zoomStartValue New start value for the data range shown in the main chart. Default value is null
     */
    public void setZoomStartValue(Object zoomStartValue) {
        setAttribute("zoomStartValue", zoomStartValue, true);
    }

    /**
     * For a {@link com.smartgwt.client.widgets.chart.FacetChart#getCanZoom zoomed chart}, start value of the data range shown
     * in the main chart.  If {@link com.smartgwt.client.widgets.chart.FacetChart#getZoomEndValue zoomEndValue} is not also
     * set, the range shown will be from <code>zoomStartValue</code> to the end of the dataset. <P> The value provided should
     * be a value in the range of the facet for the X axis, for example, for a time-based axis, a Date instance, for a numeric
     * axis, a Number, for an axis that just has text labels (such as city names), a String.
     *
     * @return Object
     */
    public Object getZoomStartValue()  {
        return getAttributeAsObject("zoomStartValue");
    }

    /**
     * For a {@link com.smartgwt.client.widgets.chart.FacetChart#getCanZoom zoomed chart}, end value of the data range shown in
     * the main chart.  If {@link com.smartgwt.client.widgets.chart.FacetChart#getZoomStartValue zoomStartValue} is not also
     * set, the range shown will be from the beginning of the dataset up to <code>zoomEndValue</code> <P> The value provided
     * should be a value in the range of the facet for the X axis, for example, for a time-based axis, a Date instance, for a
     * numeric axis, a Number, for an axis that just has text labels (such as city names), a String.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.chart.FacetChart#getZoomEndValue zoomEndValue}. <p> Note that the {@link com.smartgwt.client.widgets.chart.FacetChart#getZoomStartValue zoomStartValue} and {@link com.smartgwt.client.widgets.chart.FacetChart#getZoomEndValue zoomEndValue} may be set simultaneously using {@link com.smartgwt.client.widgets.chart.FacetChart#zoomTo FacetChart.zoomTo}.
     *
     * @param zoomEndValue New end value for the data range shown in the main chart. Default value is null
     */
    public void setZoomEndValue(Object zoomEndValue) {
        setAttribute("zoomEndValue", zoomEndValue, true);
    }

    /**
     * For a {@link com.smartgwt.client.widgets.chart.FacetChart#getCanZoom zoomed chart}, end value of the data range shown in
     * the main chart.  If {@link com.smartgwt.client.widgets.chart.FacetChart#getZoomStartValue zoomStartValue} is not also
     * set, the range shown will be from the beginning of the dataset up to <code>zoomEndValue</code> <P> The value provided
     * should be a value in the range of the facet for the X axis, for example, for a time-based axis, a Date instance, for a
     * numeric axis, a Number, for an axis that just has text labels (such as city names), a String.
     *
     * @return Object
     */
    public Object getZoomEndValue()  {
        return getAttributeAsObject("zoomEndValue");
    }

    private native void setFormatAxisValueFn() /*-{
        var isCreated = this.@com.smartgwt.client.widgets.BaseWidget::isCreated()(),
            self;
        if (isCreated) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }

        var xFormatter = this.@com.smartgwt.client.widgets.chart.FacetChart::xAxisValueFormatter,
            yFormatter = this.@com.smartgwt.client.widgets.chart.FacetChart::yAxisValueFormatter;

        if (xFormatter != null && yFormatter != null) {
            self.formatAxisValue = $debox($entry(function (value, forHorizontalAxis) {
                var valueJ = $wnd.SmartGWT.convertToJavaType(value),
                    formatter = (forHorizontalAxis ? xFormatter : yFormatter);
                return formatter.@com.smartgwt.client.widgets.chart.ValueFormatter::format(Ljava/lang/Object;)(valueJ);
            }));
        } else if (xFormatter != null || yFormatter != null) {
            self.formatAxisValue = $debox($entry(function (value, forHorizontalAxis) {
                var valueJ = $wnd.SmartGWT.convertToJavaType(value),
                    horizontal = (xFormatter != null),
                    formatter = (horizontal ? xFormatter : yFormatter);

                if (horizontal == forHorizontalAxis) {
                    return formatter.@com.smartgwt.client.widgets.chart.ValueFormatter::format(Ljava/lang/Object;)(valueJ);
                } else {
                    return this.Super("formatAxisValue", arguments);
                }
            }));
        } else if (!isCreated) {
            delete self.formatAxisValue;
        } else {
            self.formatAxisValue = $wnd.isc[this.@com.smartgwt.client.widgets.BaseWidget::scClassName].getInstanceProperty("formatAxisValue");
        }
    }-*/;

    /**
     * Formatter to apply to values displayed in the gradation labels.
     * @param formatter Formatter to apply to values displayed in the gradation labels
     */
    public void setAxisValueFormatter(ValueFormatter formatter) {
        xAxisValueFormatter = formatter;
        yAxisValueFormatter = formatter;
        setFormatAxisValueFn();
    }

    /**
     * Formatter to apply to values displayed in the gradation labels on the x-axis.
     * @param formatter Formatter to apply to values displayed in the gradation labels
     */
    public void setXAxisValueFormatter(ValueFormatter formatter) {
        xAxisValueFormatter = formatter;
        setFormatAxisValueFn();
    }

    /**
     * Formatter to apply to values displayed in the gradation labels on the y-axis.
     * @param formatter Formatter to apply to values displayed in the gradation labels
     */
    public void setYAxisValueFormatter(ValueFormatter formatter) {
        yAxisValueFormatter = formatter;
        setFormatAxisValueFn();
    }

    /**
     * Formatter to apply to values displayed in the hover labels and other value labels
     * @param formatter Formatter to apply to values displayed in the hover labels and other value labels
     */
    public native void setDataValueFormatter(ValueFormatter formatter) /*-{
        var self;
        if (this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        self.formatDataValue = $debox($entry(function (value) {
            var valueJ = $wnd.SmartGWT.convertToJavaType(value);
            return formatter.@com.smartgwt.client.widgets.chart.ValueFormatter::format(Ljava/lang/Object;)(valueJ);
        }));
    }-*/;

    /**
     * Returns the X coordination where the passed data value would be drawn.   For example, this would be the X coordinate
     * where a bar would end in a bar chart. <P> This is only allowed to be called when {@link
     * com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn} fires.
     * <P>
     * Note that this method is only applicable to {@link ChartType#AREA area}, {@link ChartType#COLUMN column}, and
     * {@link ChartType#LINE line} charts.
     * @param criteria A complete mapping of the data facets to specify the unique data cell of the value to be drawn.
     *
     * @return the X coordinate where the passed data value would be drawn.
     */
    public native float getXCoord(FacetValueMap criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getXCoord(criteria == null ? null : criteria.@com.smartgwt.client.widgets.cube.FacetValueMap::getJsObj()());
    }-*/;

    /**
     * Returns the X coordination where the passed data value would be drawn.   For example, this would be the X coordinate
     * where a bar would end in a bar chart. <P> This is only allowed to be called when {@link
     * com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn} fires.
     * <P>
     * Note that this method is only applicable to {@link ChartType#BAR bar} and {@link ChartType#SCATTER scatter} charts.
     * @param value the value to be drawn.
     *
     * @return the X coordinate where the passed data value would be drawn.
     */
    public native float getXCoord(float value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getXCoord(value);
    }-*/;

    /**
     * Returns the Y coordination where the passed data value would be drawn.   For example, this would be the X coordinate
     * that a line would pass through on a line chart, or the top of a column on a column chart. <P> This is only allowed to be
     * called when {@link com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn} fires.
     * <P>
     * Note that this method is only applicable to {@link ChartType#BAR bar} charts.
     * @param criteria A complete mapping of the data facets to specify the unique data cell of the value to be drawn.
     *
     * @return the Y coordinate where the passed data value would be drawn.
     */
    public native float getYCoord(FacetValueMap criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getYCoord(value);
    }-*/;

    /**
     * Returns the Y coordination where the passed data value would be drawn.   For example, this would be the X coordinate
     * that a line would pass through on a line chart, or the top of a column on a column chart. <P> This is only allowed to be
     * called when {@link com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn} fires.
     * <P>
     * Note that this method is only applicable to {@link ChartType#AREA area}, {@link ChartType#COLUMN column},
     * {@link ChartType#LINE line}, and {@link ChartType#SCATTER} charts.
     * @param value the value to be drawn.
     *
     * @return the Y coordinate where the passed data value would be drawn.
     */
    public native float getYCoord(float value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getYCoord(value);
    }-*/;

    /**
     * Calculate the mean, or expected value, of the data over a single metric. See <a
     * href="http://en.wikipedia.org/wiki/Expected_value">http://en.wikipedia.org/wiki/Expected_value</a>. <p> The first
     * argument, criteria, determines which metric is used to calculate the mean. The criteria may be a String that is the "id"
     * of some {@link com.smartgwt.client.widgets.cube.FacetValue} of the metric facet, or a {@link
     * com.smartgwt.client.widgets.cube.FacetValueMap} that contains an entry for the metric facet, or null to use the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getValueProperty valueProperty}.  A FacetValueMap criteria may also be used
     * to restrict the calculation to a slice of the data.
     * @param criteria the "id" of a metric facet value, or a set of mappings describing the data over which to calculate, or null
     *
     * @return the mean of the data values
     */
    public native float getMean(String criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getMean(criteria);
    }-*/;

    /**
     * Calculate the mean, or expected value, of the data over a single metric. See <a
     * href="http://en.wikipedia.org/wiki/Expected_value">http://en.wikipedia.org/wiki/Expected_value</a>. <p> The first
     * argument, criteria, determines which metric is used to calculate the mean. The criteria may be a String that is the "id"
     * of some {@link com.smartgwt.client.widgets.cube.FacetValue} of the metric facet, or a {@link
     * com.smartgwt.client.widgets.cube.FacetValueMap} that contains an entry for the metric facet, or null to use the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getValueProperty valueProperty}.  A FacetValueMap criteria may also be used
     * to restrict the calculation to a slice of the data.
     * @param criteria the "id" of a metric facet value, or a set of mappings describing the data over which to calculate, or null
     *
     * @return the mean of the data values
     */
    public native float getMean(FacetValueMap criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getMean(criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    /**
     * Calculate the median of the data over a single metric. See <a
     * href="http://en.wikipedia.org/wiki/Median">http://en.wikipedia.org/wiki/Median</a>. <p> The first argument, criteria,
     * determines which metric is used to calculate the median. The criteria may be a String that is the "id" of some {@link
     * com.smartgwt.client.widgets.cube.FacetValue} of the metric facet, or a {@link
     * com.smartgwt.client.widgets.cube.FacetValueMap} that contains an entry for the metric facet, or null to use the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getValueProperty valueProperty}.  A FacetValueMap criteria may also be used
     * to restrict the calculation to a slice of the data.
     * @param criteria the "id" of a metric facet value, or a set of mappings describing the data over which to calculate, or null
     *
     * @return the median of the data values
     */
    public native float getMedian(String criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getMedian(criteria);
    }-*/;

    /**
     * Calculate the median of the data over a single metric. See <a
     * href="http://en.wikipedia.org/wiki/Median">http://en.wikipedia.org/wiki/Median</a>. <p> The first argument, criteria,
     * determines which metric is used to calculate the median. The criteria may be a String that is the "id" of some {@link
     * com.smartgwt.client.widgets.cube.FacetValue} of the metric facet, or a {@link
     * com.smartgwt.client.widgets.cube.FacetValueMap} that contains an entry for the metric facet, or null to use the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getValueProperty valueProperty}.  A FacetValueMap criteria may also be used
     * to restrict the calculation to a slice of the data.
     * @param criteria the "id" of a metric facet value, or a set of mappings describing the data over which to calculate, or null
     *
     * @return the median of the data values
     */
    public native float getMedian(FacetValueMap criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getMedian(criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    /**
     * Calculate a percentile of the data over a single metric. See <a
     * href="http://en.wikipedia.org/wiki/Percentile">http://en.wikipedia.org/wiki/Percentile</a>. <p> The first argument,
     * criteria, determines which metric is used to calculate a percentile. The criteria may be a String that is the "id" of
     * some {@link com.smartgwt.client.widgets.cube.FacetValue} of the metric facet, or a {@link
     * com.smartgwt.client.widgets.cube.FacetValueMap} that contains an entry for the metric facet, or null to use the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getValueProperty valueProperty}.  A FacetValueMap criteria may also be used
     * to restrict the calculation to a slice of the data. <p> The second argument is the percentile to calculate and it must
     * be a number from 0 to 100.
     * @param criteria the "id" of a metric facet value, or a set of mappings describing the data over which to calculate, or null
     * @param percentile the percentile to calculate
     *
     * @return a percentile of the data values
     */
    public native float getPercentile(String criteria, float percentile) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getPercentile(criteria, percentile);
    }-*/;

    /**
     * Calculate a percentile of the data over a single metric. See <a
     * href="http://en.wikipedia.org/wiki/Percentile">http://en.wikipedia.org/wiki/Percentile</a>. <p> The first argument,
     * criteria, determines which metric is used to calculate a percentile. The criteria may be a String that is the "id" of
     * some {@link com.smartgwt.client.widgets.cube.FacetValue} of the metric facet, or a {@link
     * com.smartgwt.client.widgets.cube.FacetValueMap} that contains an entry for the metric facet, or null to use the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getValueProperty valueProperty}.  A FacetValueMap criteria may also be used
     * to restrict the calculation to a slice of the data. <p> The second argument is the percentile to calculate and it must
     * be a number from 0 to 100.
     * @param criteria the "id" of a metric facet value, or a set of mappings describing the data over which to calculate, or null
     * @param percentile the percentile to calculate
     *
     * @return a percentile of the data values
     */
    public native float getPercentile(FacetValueMap criteria, float percentile) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getPercentile(criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()(), percentile);
    }-*/;

    /**
     * Calculate the range of the data from a single metric. <p> The first argument, criteria, determines which metric is used
     * to calculate the range. The criteria may be a String that is the "id" of some {@link
     * com.smartgwt.client.widgets.cube.FacetValue} of the metric facet, or a {@link
     * com.smartgwt.client.widgets.cube.FacetValueMap} that contains an entry for the metric facet, or null to use the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getValueProperty valueProperty}.  A FacetValueMap criteria may also be used
     * to restrict the calculation to a slice of the data.
     * @param criteria the "id" of a metric facet value, or a set of mappings describing the data over which to calculate, or null
     *
     * @return the range of the data values
     */
    public native float getRange(String criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getRange(criteria);
    }-*/;

    /**
     * Calculate the range of the data from a single metric. <p> The first argument, criteria, determines which metric is used
     * to calculate the range. The criteria may be a String that is the "id" of some {@link
     * com.smartgwt.client.widgets.cube.FacetValue} of the metric facet, or a {@link
     * com.smartgwt.client.widgets.cube.FacetValueMap} that contains an entry for the metric facet, or null to use the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getValueProperty valueProperty}.  A FacetValueMap criteria may also be used
     * to restrict the calculation to a slice of the data.
     * @param criteria the "id" of a metric facet value, or a set of mappings describing the data over which to calculate, or null
     *
     * @return the range of the data values
     */
    public native float getRange(FacetValueMap criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getRange(criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    /**
     * Calculate the standard deviation of the data from a single metric. See <a
     * href="http://en.wikipedia.org/wiki/Standard_deviation">http://en.wikipedia.org/wiki/Standard_deviation</a>. <p> The
     * first argument, criteria, determines which metric is used to calculate the standard deviation. The criteria may be a
     * String that is the "id" of some {@link com.smartgwt.client.widgets.cube.FacetValue} of the metric facet, or a {@link
     * com.smartgwt.client.widgets.cube.FacetValueMap} that contains an entry for the metric facet, or null to use the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getValueProperty valueProperty}.  A FacetValueMap criteria may also be used
     * to restrict the calculation to a slice of the data.
     * @param criteria the "id" of a metric facet value, or a set of mappings describing the data over which to calculate, or null
     * @param population false to calculate a sample standard deviation, true to calculate a population standard deviation
     *
     * @return the standard deviation of the data values
     */
    public native float getStdDev(String criteria, boolean population) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getStdDev(criteria, population);
    }-*/;

    /**
     * Calculate the standard deviation of the data from a single metric. See <a
     * href="http://en.wikipedia.org/wiki/Standard_deviation">http://en.wikipedia.org/wiki/Standard_deviation</a>. <p> The
     * first argument, criteria, determines which metric is used to calculate the standard deviation. The criteria may be a
     * String that is the "id" of some {@link com.smartgwt.client.widgets.cube.FacetValue} of the metric facet, or a {@link
     * com.smartgwt.client.widgets.cube.FacetValueMap} that contains an entry for the metric facet, or null to use the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getValueProperty valueProperty}.  A FacetValueMap criteria may also be used
     * to restrict the calculation to a slice of the data.
     * @param criteria the "id" of a metric facet value, or a set of mappings describing the data over which to calculate, or null
     * @param population false to calculate a sample standard deviation, true to calculate a population standard deviation
     *
     * @return the standard deviation of the data values
     */
    public native float getStdDev(FacetValueMap criteria, boolean population) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getStdDev(criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()(), population);
    }-*/;

    /**
     * Calculate the variance of the data from a single metric. See <a
     * href="http://en.wikipedia.org/wiki/Variance">http://en.wikipedia.org/wiki/Variance</a>. <p> The first argument,
     * criteria, determines which metric is used to calculate the variance. The criteria may be a String that is the "id" of
     * some {@link com.smartgwt.client.widgets.cube.FacetValue} of the metric facet, or a {@link
     * com.smartgwt.client.widgets.cube.FacetValueMap} that contains an entry for the metric facet, or null to use the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getValueProperty valueProperty}.  A FacetValueMap criteria may also be used
     * to restrict the calculation to a slice of the data.
     * @param criteria the "id" of a metric facet value, or a set of mappings describing the data over which to calculate, or null
     * @param population false to calculate a sample variance, true to calculate a population variance
     *
     * @return the variance of the data values
     */
    public native float getVariance(String criteria, boolean population) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getVariance(criteria, population);
    }-*/;

    /**
     * Calculate the variance of the data from a single metric. See <a
     * href="http://en.wikipedia.org/wiki/Variance">http://en.wikipedia.org/wiki/Variance</a>. <p> The first argument,
     * criteria, determines which metric is used to calculate the variance. The criteria may be a String that is the "id" of
     * some {@link com.smartgwt.client.widgets.cube.FacetValue} of the metric facet, or a {@link
     * com.smartgwt.client.widgets.cube.FacetValueMap} that contains an entry for the metric facet, or null to use the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getValueProperty valueProperty}.  A FacetValueMap criteria may also be used
     * to restrict the calculation to a slice of the data.
     * @param criteria the "id" of a metric facet value, or a set of mappings describing the data over which to calculate, or null
     * @param population false to calculate a sample variance, true to calculate a population variance
     *
     * @return the variance of the data values
     */
    public native float getVariance(FacetValueMap criteria, boolean population) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getVariance(criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()(), population);
    }-*/;

    /**
     * Calculate the maximum of the data from a single metric. <p> The first argument, criteria, determines which metric is
     * used to calculate the maximum. The criteria may be a String that is the "id" of some {@link
     * com.smartgwt.client.widgets.cube.FacetValue} of the metric facet, or a {@link
     * com.smartgwt.client.widgets.cube.FacetValueMap} that contains an entry for the metric facet, or null to use the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getValueProperty valueProperty}.  A FacetValueMap criteria may also be used
     * to restrict the calculation to a slice of the data.
     * @param criteria the "id" of a metric facet value, or a set of mappings describing the data over which to calculate, or null
     *
     * @return the maximum of the data values
     */
    public native float getMax(String criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getMax(criteria);
    }-*/;

    /**
     * Calculate the maximum of the data from a single metric. <p> The first argument, criteria, determines which metric is
     * used to calculate the maximum. The criteria may be a String that is the "id" of some {@link
     * com.smartgwt.client.widgets.cube.FacetValue} of the metric facet, or a {@link
     * com.smartgwt.client.widgets.cube.FacetValueMap} that contains an entry for the metric facet, or null to use the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getValueProperty valueProperty}.  A FacetValueMap criteria may also be used
     * to restrict the calculation to a slice of the data.
     * @param criteria the "id" of a metric facet value, or a set of mappings describing the data over which to calculate, or null
     *
     * @return the maximum of the data values
     */
    public native float getMax(FacetValueMap criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getMax(criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    /**
     * Calculate the minimum of the data from a single metric. <p> The first argument, criteria, determines which metric is
     * used to calculate the minimum. The criteria may be a String that is the "id" of some {@link
     * com.smartgwt.client.widgets.cube.FacetValue} of the metric facet, or a {@link
     * com.smartgwt.client.widgets.cube.FacetValueMap} that contains an entry for the metric facet, or null to use the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getValueProperty valueProperty}.  A FacetValueMap criteria may also be used
     * to restrict the calculation to a slice of the data.
     * @param criteria the "id" of a metric facet value, or a set of mappings describing the data over which to calculate, or null
     *
     * @return the minimum of the data values
     */
    public native float getMin(String criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getMin(criteria);
    }-*/;

    /**
     * Calculate the minimum of the data from a single metric. <p> The first argument, criteria, determines which metric is
     * used to calculate the minimum. The criteria may be a String that is the "id" of some {@link
     * com.smartgwt.client.widgets.cube.FacetValue} of the metric facet, or a {@link
     * com.smartgwt.client.widgets.cube.FacetValueMap} that contains an entry for the metric facet, or null to use the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getValueProperty valueProperty}.  A FacetValueMap criteria may also be used
     * to restrict the calculation to a slice of the data.
     * @param criteria the "id" of a metric facet value, or a set of mappings describing the data over which to calculate, or null
     *
     * @return the minimum of the data values
     */
    public native float getMin(FacetValueMap criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getMin(criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public LogicalStructureObject setLogicalStructure(FacetChartLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.autoRotateLabels = getAttributeAsString("autoRotateLabels");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.autoRotateLabels:" + t.getMessage() + "\n";
        }
        try {
            s.axisStartValue = getAttributeAsString("axisStartValue");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.axisStartValue:" + t.getMessage() + "\n";
        }
        try {
            s.backgroundBandProperties = getAttributeAsString("backgroundBandProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.backgroundBandProperties:" + t.getMessage() + "\n";
        }
        try {
            s.bandedBackground = getAttributeAsString("bandedBackground");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.bandedBackground:" + t.getMessage() + "\n";
        }
        try {
            s.bandedStandardDeviations = getAttributeAsString("bandedStandardDeviations");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.bandedStandardDeviations:" + t.getMessage() + "\n";
        }
        try {
            s.barMargin = getAttributeAsString("barMargin");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.barMargin:" + t.getMessage() + "\n";
        }
        try {
            s.barProperties = getAttributeAsString("barProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.barProperties:" + t.getMessage() + "\n";
        }
        try {
            s.canMoveAxes = getAttributeAsString("canMoveAxes");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.canMoveAxes:" + t.getMessage() + "\n";
        }
        try {
            s.canZoom = getAttributeAsString("canZoom");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.canZoom:" + t.getMessage() + "\n";
        }
        try {
            s.chartRectMargin = getAttributeAsString("chartRectMargin");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.chartRectMargin:" + t.getMessage() + "\n";
        }
        try {
            s.chartRectProperties = getAttributeAsString("chartRectProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.chartRectProperties:" + t.getMessage() + "\n";
        }
        try {
            s.chartType = getAttributeAsString("chartType");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.chartType:" + t.getMessage() + "\n";
        }
        try {
            s.dataAxisLabelProperties = getAttributeAsString("dataAxisLabelProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.dataAxisLabelProperties:" + t.getMessage() + "\n";
        }
        try {
            s.dataColors = getAttributeAsStringArray("dataColors");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.dataColorsArray:" + t.getMessage() + "\n";
        }
        try {
            s.dataLabelProperties = getAttributeAsString("dataLabelProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.dataLabelProperties:" + t.getMessage() + "\n";
        }
        try {
            s.dataLineProperties = getAttributeAsString("dataLineProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.dataLineProperties:" + t.getMessage() + "\n";
        }
        try {
            s.dataLineType = getAttributeAsString("dataLineType");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.dataLineType:" + t.getMessage() + "\n";
        }
        try {
            s.dataMargin = getAttributeAsString("dataMargin");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.dataMargin:" + t.getMessage() + "\n";
        }
        try {
            s.dataOutlineProperties = getAttributeAsString("dataOutlineProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.dataOutlineProperties:" + t.getMessage() + "\n";
        }
        try {
            s.dataPointProperties = getAttributeAsString("dataPointProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.dataPointProperties:" + t.getMessage() + "\n";
        }
        try {
            s.dataPointSize = getAttributeAsString("dataPointSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.dataPointSize:" + t.getMessage() + "\n";
        }
        try {
            s.dataShapeProperties = getAttributeAsString("dataShapeProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.dataShapeProperties:" + t.getMessage() + "\n";
        }
        try {
            s.decimalPrecision = getAttributeAsString("decimalPrecision");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.decimalPrecision:" + t.getMessage() + "\n";
        }
        try {
            s.discontinuousLines = getAttributeAsString("discontinuousLines");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.discontinuousLines:" + t.getMessage() + "\n";
        }
        try {
            s.doughnutHoleProperties = getAttributeAsString("doughnutHoleProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.doughnutHoleProperties:" + t.getMessage() + "\n";
        }
        try {
            s.errorBarWidth = getAttributeAsString("errorBarWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.errorBarWidth:" + t.getMessage() + "\n";
        }
        try {
            s.errorLineProperties = getAttributeAsString("errorLineProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.errorLineProperties:" + t.getMessage() + "\n";
        }
        try {
            s.expectedValueLineProperties = getAttributeAsString("expectedValueLineProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.expectedValueLineProperties:" + t.getMessage() + "\n";
        }
        try {
            s.extraAxisMetrics = getAttributeAsStringArray("extraAxisMetrics");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.extraAxisMetricsArray:" + t.getMessage() + "\n";
        }
        try {
            s.extraAxisSettings = getExtraAxisSettings();
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.extraAxisSettingsArray:" + t.getMessage() + "\n";
        }
        try {
            s.filled = getAttributeAsString("filled");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.filled:" + t.getMessage() + "\n";
        }
        try {
            s.gradationLabelProperties = getAttributeAsString("gradationLabelProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.gradationLabelProperties:" + t.getMessage() + "\n";
        }
        try {
            s.gradationLineProperties = getAttributeAsString("gradationLineProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.gradationLineProperties:" + t.getMessage() + "\n";
        }
        try {
            s.gradationTickMarkLength = getAttributeAsString("gradationTickMarkLength");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.gradationTickMarkLength:" + t.getMessage() + "\n";
        }
        try {
            s.gradationZeroLineProperties = getAttributeAsString("gradationZeroLineProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.gradationZeroLineProperties:" + t.getMessage() + "\n";
        }
        try {
            s.highErrorMetric = getAttributeAsString("highErrorMetric");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.highErrorMetric:" + t.getMessage() + "\n";
        }
        try {
            s.hoverLabelProperties = getAttributeAsString("hoverLabelProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.hoverLabelProperties:" + t.getMessage() + "\n";
        }
        try {
            s.hoverRectProperties = getAttributeAsString("hoverRectProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.hoverRectProperties:" + t.getMessage() + "\n";
        }
        try {
            s.labelCollapseMode = getAttributeAsString("labelCollapseMode");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.labelCollapseMode:" + t.getMessage() + "\n";
        }
        try {
            s.legendItemPadding = getAttributeAsString("legendItemPadding");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.legendItemPadding:" + t.getMessage() + "\n";
        }
        try {
            s.legendLabelProperties = getAttributeAsString("legendLabelProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.legendLabelProperties:" + t.getMessage() + "\n";
        }
        try {
            s.legendMargin = getAttributeAsString("legendMargin");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.legendMargin:" + t.getMessage() + "\n";
        }
        try {
            s.legendPadding = getAttributeAsString("legendPadding");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.legendPadding:" + t.getMessage() + "\n";
        }
        try {
            s.legendRectProperties = getAttributeAsString("legendRectProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.legendRectProperties:" + t.getMessage() + "\n";
        }
        try {
            s.legendSwatchProperties = getAttributeAsString("legendSwatchProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.legendSwatchProperties:" + t.getMessage() + "\n";
        }
        try {
            s.legendSwatchSize = getAttributeAsString("legendSwatchSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.legendSwatchSize:" + t.getMessage() + "\n";
        }
        try {
            s.legendTextPadding = getAttributeAsString("legendTextPadding");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.legendTextPadding:" + t.getMessage() + "\n";
        }
        try {
            s.logBase = getAttributeAsString("logBase");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.logBase:" + t.getMessage() + "\n";
        }
        try {
            s.logScale = getAttributeAsString("logScale");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.logScale:" + t.getMessage() + "\n";
        }
        try {
            s.lowErrorMetric = getAttributeAsString("lowErrorMetric");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.lowErrorMetric:" + t.getMessage() + "\n";
        }
        try {
            s.maxBarThickness = getAttributeAsString("maxBarThickness");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.maxBarThickness:" + t.getMessage() + "\n";
        }
        try {
            s.minBarThickness = getAttributeAsString("minBarThickness");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.minBarThickness:" + t.getMessage() + "\n";
        }
        try {
            s.minDataSpreadPercent = getAttributeAsString("minDataSpreadPercent");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.minDataSpreadPercent:" + t.getMessage() + "\n";
        }
        try {
            s.minLabelGap = getAttributeAsString("minLabelGap");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.minLabelGap:" + t.getMessage() + "\n";
        }
        try {
            s.minXDataSpreadPercent = getAttributeAsString("minXDataSpreadPercent");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.minXDataSpreadPercent:" + t.getMessage() + "\n";
        }
        try {
            s.pieBorderProperties = getAttributeAsString("pieBorderProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.pieBorderProperties:" + t.getMessage() + "\n";
        }
        try {
            s.pieLabelAngleStart = getAttributeAsString("pieLabelAngleStart");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.pieLabelAngleStart:" + t.getMessage() + "\n";
        }
        try {
            s.pieLabelLineExtent = getAttributeAsString("pieLabelLineExtent");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.pieLabelLineExtent:" + t.getMessage() + "\n";
        }
        try {
            s.pieLabelLineProperties = getAttributeAsString("pieLabelLineProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.pieLabelLineProperties:" + t.getMessage() + "\n";
        }
        try {
            s.pieRingBorderProperties = getAttributeAsString("pieRingBorderProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.pieRingBorderProperties:" + t.getMessage() + "\n";
        }
        try {
            s.pieSliceProperties = getAttributeAsString("pieSliceProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.pieSliceProperties:" + t.getMessage() + "\n";
        }
        try {
            s.pieStartAngle = getAttributeAsString("pieStartAngle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.pieStartAngle:" + t.getMessage() + "\n";
        }
        try {
            s.probabilityMetric = getAttributeAsString("probabilityMetric");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.probabilityMetric:" + t.getMessage() + "\n";
        }
        try {
            s.radarBackgroundProperties = getAttributeAsString("radarBackgroundProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.radarBackgroundProperties:" + t.getMessage() + "\n";
        }
        try {
            s.radialLabelOffset = getAttributeAsString("radialLabelOffset");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.radialLabelOffset:" + t.getMessage() + "\n";
        }
        try {
            s.regressionLineProperties = getAttributeAsString("regressionLineProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.regressionLineProperties:" + t.getMessage() + "\n";
        }
        try {
            s.regressionLineType = getAttributeAsString("regressionLineType");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.regressionLineType:" + t.getMessage() + "\n";
        }
        try {
            s.regressionPolynomialDegree = getAttributeAsString("regressionPolynomialDegree");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.regressionPolynomialDegree:" + t.getMessage() + "\n";
        }
        try {
            s.rotateLabels = getAttributeAsString("rotateLabels");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.rotateLabels:" + t.getMessage() + "\n";
        }
        try {
            s.shadowProperties = getAttributeAsString("shadowProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.shadowProperties:" + t.getMessage() + "\n";
        }
        try {
            s.showChartRect = getAttributeAsString("showChartRect");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.showChartRect:" + t.getMessage() + "\n";
        }
        try {
            s.showDataAxisLabel = getAttributeAsString("showDataAxisLabel");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.showDataAxisLabel:" + t.getMessage() + "\n";
        }
        try {
            s.showDataPoints = getAttributeAsString("showDataPoints");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.showDataPoints:" + t.getMessage() + "\n";
        }
        try {
            s.showDataValues = getAttributeAsString("showDataValues");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.showDataValues:" + t.getMessage() + "\n";
        }
        try {
            s.showDoughnut = getAttributeAsString("showDoughnut");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.showDoughnut:" + t.getMessage() + "\n";
        }
        try {
            s.showExpectedValueLine = getAttributeAsString("showExpectedValueLine");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.showExpectedValueLine:" + t.getMessage() + "\n";
        }
        try {
            s.showGradationsOverData = getAttributeAsString("showGradationsOverData");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.showGradationsOverData:" + t.getMessage() + "\n";
        }
        try {
            s.showInlineLabels = getAttributeAsString("showInlineLabels");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.showInlineLabels:" + t.getMessage() + "\n";
        }
        try {
            s.showLegend = getAttributeAsString("showLegend");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.showLegend:" + t.getMessage() + "\n";
        }
        try {
            s.showRadarGradationLabels = getAttributeAsString("showRadarGradationLabels");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.showRadarGradationLabels:" + t.getMessage() + "\n";
        }
        try {
            s.showRegressionLine = getAttributeAsString("showRegressionLine");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.showRegressionLine:" + t.getMessage() + "\n";
        }
        try {
            s.showScatterLines = getAttributeAsString("showScatterLines");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.showScatterLines:" + t.getMessage() + "\n";
        }
        try {
            s.showShadows = getAttributeAsString("showShadows");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.showShadows:" + t.getMessage() + "\n";
        }
        try {
            s.showStandardDeviationLines = getAttributeAsString("showStandardDeviationLines");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.showStandardDeviationLines:" + t.getMessage() + "\n";
        }
        try {
            s.showStatisticsOverData = getAttributeAsString("showStatisticsOverData");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.showStatisticsOverData:" + t.getMessage() + "\n";
        }
        try {
            s.showTitle = getAttributeAsString("showTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.showTitle:" + t.getMessage() + "\n";
        }
        try {
            s.showValueAxisLabel = getAttributeAsString("showValueAxisLabel");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.showValueAxisLabel:" + t.getMessage() + "\n";
        }
        try {
            s.showValueOnHover = getAttributeAsString("showValueOnHover");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.showValueOnHover:" + t.getMessage() + "\n";
        }
        try {
            s.stacked = getAttributeAsString("stacked");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.stacked:" + t.getMessage() + "\n";
        }
        try {
            s.standardDeviationBandProperties = getAttributeAsStringArray("standardDeviationBandProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.standardDeviationBandPropertiesArray:" + t.getMessage() + "\n";
        }
        try {
            s.standardDeviationLineProperties = getAttributeAsString("standardDeviationLineProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.standardDeviationLineProperties:" + t.getMessage() + "\n";
        }
        try {
            s.standardDeviations = getAttributeAsStringArray("standardDeviations");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.standardDeviationsArray:" + t.getMessage() + "\n";
        }
        try {
            s.styleName = getAttributeAsString("styleName");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.styleName:" + t.getMessage() + "\n";
        }
        try {
            s.tickMarkToValueAxisMargin = getAttributeAsString("tickMarkToValueAxisMargin");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.tickMarkToValueAxisMargin:" + t.getMessage() + "\n";
        }
        try {
            s.title = getAttributeAsString("title");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.title:" + t.getMessage() + "\n";
        }
        try {
            s.titleProperties = getAttributeAsString("titleProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.titleProperties:" + t.getMessage() + "\n";
        }
        try {
            s.useAutoGradients = getAttributeAsString("useAutoGradients");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.useAutoGradients:" + t.getMessage() + "\n";
        }
        try {
            s.useLogGradations = getAttributeAsString("useLogGradations");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.useLogGradations:" + t.getMessage() + "\n";
        }
        try {
            s.useSymmetricStandardDeviations = getAttributeAsString("useSymmetricStandardDeviations");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.useSymmetricStandardDeviations:" + t.getMessage() + "\n";
        }
        try {
            s.valueAxisLabelProperties = getAttributeAsString("valueAxisLabelProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.valueAxisLabelProperties:" + t.getMessage() + "\n";
        }
        try {
            s.valueAxisMargin = getAttributeAsString("valueAxisMargin");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.valueAxisMargin:" + t.getMessage() + "\n";
        }
        try {
            s.valueLineProperties = getAttributeAsString("valueLineProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.valueLineProperties:" + t.getMessage() + "\n";
        }
        try {
            s.valueProperty = getAttributeAsString("valueProperty");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.valueProperty:" + t.getMessage() + "\n";
        }
        try {
            s.valueTitle = getAttributeAsString("valueTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.valueTitle:" + t.getMessage() + "\n";
        }
        try {
            s.xAxisMetric = getAttributeAsString("xAxisMetric");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.xAxisMetric:" + t.getMessage() + "\n";
        }
        try {
            s.xAxisStartValue = getAttributeAsString("xAxisStartValue");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.xAxisStartValue:" + t.getMessage() + "\n";
        }
        try {
            s.yAxisMetric = getAttributeAsString("yAxisMetric");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.yAxisMetric:" + t.getMessage() + "\n";
        }
        try {
            s.zoomChartProperties = getAttributeAsString("zoomChartProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.zoomChartProperties:" + t.getMessage() + "\n";
        }
        try {
            s.zoomEndValue = getAttributeAsString("zoomEndValue");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.zoomEndValue:" + t.getMessage() + "\n";
        }
        try {
            s.zoomLogScale = getAttributeAsString("zoomLogScale");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.zoomLogScale:" + t.getMessage() + "\n";
        }
        try {
            s.zoomSelectionChartProperties = getAttributeAsString("zoomSelectionChartProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.zoomSelectionChartProperties:" + t.getMessage() + "\n";
        }
        try {
            s.zoomShowSelection = getAttributeAsString("zoomShowSelection");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.zoomShowSelection:" + t.getMessage() + "\n";
        }
        try {
            s.zoomStartPosition = getAttributeAsString("zoomStartPosition");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.zoomStartPosition:" + t.getMessage() + "\n";
        }
        try {
            s.zoomStartValue = getAttributeAsString("zoomStartValue");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.zoomStartValue:" + t.getMessage() + "\n";
        }
        return s;
    }

    public LogicalStructureObject getLogicalStructure() {
        FacetChartLogicalStructure s = new FacetChartLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

