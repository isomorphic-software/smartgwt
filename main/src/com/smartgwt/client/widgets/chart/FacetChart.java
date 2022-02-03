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
 * HTML5-based charting engine, implementing all  chartTypes of the
 *  Chart interface.
 *  <P>
 * Can be used directly, or specified as {@link com.smartgwt.client.widgets.grid.ListGrid#getChartConstructor
 * ListGrid.chartConstructor} or
 *  {@link com.smartgwt.client.widgets.cube.CubeGrid#getChartConstructor CubeGrid.chartConstructor}.
 *  <P>
 *  <b>NOTE:</b> you must load the Drawing and Charts
 *  {@link com.smartgwt.client.docs.LoadingOptionalModules Optional Modules} before you can use FacetChart.   Also, 
 *  the Charts Module is available in Pro Edition or better, please see 
 *  <a href='http://www.smartclient.com/product' target='_blank'>smartclient.com/product</a> for licensing 
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
 * <li>@see <a href="http://www.smartclient.com/smartgwtee/showcase/#simpleChart" target="examples">Simple Chart</a>
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
 *  would cause profit to be plotted as the second axis.  See the
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
 * set {@link com.smartgwt.client.widgets.chart.MetricSettings#getShowAxis MetricSettings.showAxis} false to avoid a second
 * axis appearing, and set
 * {@link com.smartgwt.client.widgets.chart.MetricSettings#getMatchGradations MetricSettings.matchGradations} to cause the
 * same gradations to be used for both
 *  plots.
 *  <p>
 * See the <a href="http://www.smartclient.com/smartgwtee/showcase/#mixedPlotsChart" target="examples">Mixed Plots</a> SDK
 * example.
 *  <p>
 *  <h3>Histogram Charts</h3>
 *  <p>
 * A "histogram" chart is similar to a {@link com.smartgwt.client.widgets.chart.FacetChart#getStacked stacked} "column"
 * chart, showing
 *  multiple facet values vertically for each position along the x-axis /
 * {@link com.smartgwt.client.widgets.chart.FacetChart#getDataLabelFacet data label facet}, but instead of each vertical
 * facet
 *  value being defined only by a length, a "histogram" chart defines a <i>segment</i> for each,
 * represented by both a start point (the {@link com.smartgwt.client.widgets.chart.FacetChart#getValueProperty "value
 * property"}) and
 *  an end point (the {@link com.smartgwt.client.widgets.chart.FacetChart#getEndValueMetric "endValue metric"}).
 *  <P>
 *  Segments may overlap, with the last segment drawn receiving the highest z-ordering.  To
 *  override this default behavior, values may be provided using an additional metric -
 * {@link com.smartgwt.client.widgets.chart.FacetChart#getZIndexMetric zIndexMetric} - whose value must be a non-negative
 * integer no greater than
 *  {@link com.smartgwt.client.widgets.chart.FacetChart#getMaxDataZIndex maxDataZIndex}.
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
 *  <h3>Bubble Charts</h3>
 *  <p>
 *  A "bubble" chart is a type of scatter chart where the <i>size</i> of each rendered data
 *  point represents an additional metric value, allowing 3 continuous data values to be
 *  visualized together.  When using <code>chartType:"Bubble"</code>, the additional metric 
 *  is configured via {@link com.smartgwt.client.widgets.chart.FacetChart#getPointSizeMetric pointSizeMetric}.  
 * Points will be sized between the {@link com.smartgwt.client.widgets.chart.FacetChart#getMinDataPointSize
 * minDataPointSize} and
 *  {@link com.smartgwt.client.widgets.chart.FacetChart#getMaxDataPointSize maxDataPointSize}, optionally with 
 * {@link com.smartgwt.client.widgets.chart.FacetChart#getLogScalePointSize logarithmic scaling}.  A legend will be
 * included showing 
 *  how point size represents data values, and a multi-facet Bubble chart can optionally use a 
 *  different shape for each <code>facetValue</code> via 
 *  {@link com.smartgwt.client.widgets.chart.FacetChart#getUseMultiplePointShapes useMultiplePointShapes}.
 *  <p>
 *  Variable-size points can also be used with other, non-scatter chart types (such as "Line"
 * or "Radar") when {@link com.smartgwt.client.widgets.chart.FacetChart#getShowDataPoints showDataPoints} is enabled, by
 * setting 
 * <code>pointSizeMetric</code> to the {@link com.smartgwt.client.widgets.cube.FacetValue#getId FacetValue.id} of a {@link
 * com.smartgwt.client.widgets.cube.Facet#getValues facetValue}
 *  of the metric facet.  In this case, a legend for point sizes is not shown by default, but can
 *  be enabled via {@link com.smartgwt.client.widgets.chart.FacetChart#getShowPointSizeLegend showPointSizeLegend}.
 *  <p>
 *  Whenever drawing variable size data points, by default, the largest data points are drawn 
 *  first so that smaller data points are less likely to be completely occluded by larger data 
 *  points, but this can be disabled by setting 
 * {@link com.smartgwt.client.widgets.chart.FacetChart#getAutoSortBubblePoints autoSortBubblePoints} to <code>false</code>.
 *  Visual
 *  appearance of data points can be further customized by setting the 
 *  {@link com.smartgwt.client.widgets.chart.FacetChart#getBubbleProperties bubbleProperties}.
 *  <p>
 * See the <a href="http://www.smartclient.com/smartgwtee/showcase/#bubbleChart" target="examples">Bubble Chart</a> SDK
 * example.
 *  <p>
 *  <h3>Color Scale Charts</h3>
 *  <p>
 *  FacetChart supports rendering an additional metric value as the <i>color</i> of each data
 * point.  This feature requires that {@link com.smartgwt.client.widgets.chart.FacetChart#getShowDataPoints showDataPoints}
 * be
 * enabled and is configured via {@link com.smartgwt.client.widgets.chart.FacetChart#getColorScaleMetric colorScaleMetric}.
 *  Instead
 *  of data points being drawn using a separate color for each <code>facetValue</code> of the
 *  legend facet, the data points will be drawn using a color interpolated between the
 *  {@link com.smartgwt.client.widgets.chart.FacetChart#getScaleStartColor scaleStartColor} and
 *  {@link com.smartgwt.client.widgets.chart.FacetChart#getScaleEndColor scaleEndColor}, optionally with
 * {@link com.smartgwt.client.widgets.chart.FacetChart#getLogScalePointColor logarithmic scaling}.  A legend is included by
 * default
 * via {@link com.smartgwt.client.widgets.chart.FacetChart#getShowColorScaleLegend showColorScaleLegend} that shows how the
 * data
 *  values are mapped to a color via a gradient over the range of colors used in the chart.
 *  Visual appearance of data points in color scale charts can be further customized by setting
 * the {@link com.smartgwt.client.widgets.chart.FacetChart#getBubbleProperties bubbleProperties}, just as with bubble
 * charts.
 *  <p>
 *  Note that when color is being used to show values of the <code>colorScaleMetric</code> then
 *  color cannot be used to distinguish between different <code>facetValues</code>.  Therefore
 *  color scale charts cannot have a (non-metric) legend facet.
 *  <p>
 * See the <a href="http://www.smartclient.com/smartgwtee/showcase/#colorScaleChart" target="examples">Color Scale
 * Chart</a> SDK example.
 *  <p>
 *  <h3>Notes on printing</h3>
 *  <P>
 *  FacetCharts support printing on all supported desktop browsers.  When using Pro Edition or 
 *  better with the Smart GWT Server Framework installed, charts can also be exported to PDF 
 * via {@link com.smartgwt.client.rpc.RPCManager#exportContent RPCManager.exportContent()} or to images via {@link
 * com.smartgwt.client.rpc.RPCManager#exportImage RPCManager.exportImage()}.
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
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(FacetChart.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.FacetChart.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(FacetChart.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.FacetChart.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
     * Setting this flag to <code>false</code> prevents the chart from drawing fill gradients into the bubbles of each data
     * point.  This flag is required to be set for IE8 and earlier in order to draw bubble charts displaying high volumes of
     * data.
     *
     * @param allowBubbleGradients New allowBubbleGradients value. Default value is !(isc.Browser.isIE &amp;&amp; isc.Browser.version &lt;= 8)
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setAllowBubbleGradients(boolean allowBubbleGradients)  throws IllegalStateException {
        return (FacetChart)setAttribute("allowBubbleGradients", allowBubbleGradients, false);
    }

    /**
     * Setting this flag to <code>false</code> prevents the chart from drawing fill gradients into the bubbles of each data
     * point.  This flag is required to be set for IE8 and earlier in order to draw bubble charts displaying high volumes of
     * data.
     *
     * @return Current allowBubbleGradients value. Default value is !(isc.Browser.isIE &amp;&amp; isc.Browser.version &lt;= 8)
     */
    public boolean getAllowBubbleGradients()  {
        Boolean result = getAttributeAsBoolean("allowBubbleGradients");
        return result == null ? false : result;
    }
    

    /**
     * Other {@link com.smartgwt.client.types.ChartType chart types} that the end user will be allowed to switch to, using the
     * built-in context menu. <P> The actual list of ChartTypes displayed in the context menu may be a subset of
     * <code>allowedChartTypes</code>, since the FacetChart will automatically disallow certain modes that are clearly invalid,
     * for example, not allowing switching to Pie mode if either {@link com.smartgwt.client.widgets.chart.FacetChart#getCanZoom
     * canZoom} is enabled, or if the chart is {@link com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics
     * multi-axis}.
     *
     * @param allowedChartTypes New allowedChartTypes value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     */
    public FacetChart setAllowedChartTypes(ChartType... allowedChartTypes) {
        return (FacetChart)setAttribute("allowedChartTypes", allowedChartTypes, true);
    }

    /**
     * Other {@link com.smartgwt.client.types.ChartType chart types} that the end user will be allowed to switch to, using the
     * built-in context menu. <P> The actual list of ChartTypes displayed in the context menu may be a subset of
     * <code>allowedChartTypes</code>, since the FacetChart will automatically disallow certain modes that are clearly invalid,
     * for example, not allowing switching to Pie mode if either {@link com.smartgwt.client.widgets.chart.FacetChart#getCanZoom
     * canZoom} is enabled, or if the chart is {@link com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics
     * multi-axis}.
     *
     * @return Current allowedChartTypes value. Default value is null
     */
    public ChartType[] getAllowedChartTypes()  {
        final String[] strings = getAttributeAsStringArray("allowedChartTypes");
        return EnumUtil.getEnums(ChartType.values(), strings, strings == null ? null : new ChartType[strings.length]);
    }
    

    /**
     * Whether to automatically rotate labels if needed in order to make them legible and non-overlapping.
     *
     * @param autoRotateLabels New autoRotateLabels value. Default value is true
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @deprecated As of Smart GWT 9.0 this property is replaced by the property {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getRotateLabels rotateLabels}.  Setting rotateLabels to "auto" is
     * equivalent to setting autoRotateLabels to <code>true</code>.  Setting rotateLabels to "never" is equivalent to setting
     * autoRotateLabels to <code>false</code>.
     */
    public FacetChart setAutoRotateLabels(Boolean autoRotateLabels)  throws IllegalStateException {
        return (FacetChart)setAttribute("autoRotateLabels", autoRotateLabels, false);
    }

    /**
     * Whether to automatically rotate labels if needed in order to make them legible and non-overlapping.
     *
     * @return Current autoRotateLabels value. Default value is true
     * @deprecated As of Smart GWT 9.0 this property is replaced by the property {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getRotateLabels rotateLabels}.  Setting rotateLabels to "auto" is
     * equivalent to setting autoRotateLabels to <code>true</code>.  Setting rotateLabels to "never" is equivalent to setting
     * autoRotateLabels to <code>false</code>.
     */
    public Boolean getAutoRotateLabels()  {
        Boolean result = getAttributeAsBoolean("autoRotateLabels");
        return result == null ? true : result;
    }
    

    /**
     * When set to true, introduces scrollbars when this widget is smaller than the specified  chart-content minimum {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinContentWidth width} or  {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinContentHeight height}.  These minimum sizes limit all chart-content,
     * including data and labels, titles and legends. <P> See {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getAutoScrollData autoScrollData} for a means to introduce scrolling
     * according to the data being displayed.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets {@link com.smartgwt.client.widgets.chart.FacetChart#getAutoScrollContent autoScrollContent} and updates the chart.
     *
     * @param autoScrollContent whether the chart should automatically show scrollbars      when it's size is smaller than the minimum content      
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getMinContentWidth width} or {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinContentHeight height}. Default value is false
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     */
    public FacetChart setAutoScrollContent(boolean autoScrollContent) {
        return (FacetChart)setAttribute("autoScrollContent", autoScrollContent, true);
    }

    /**
     * When set to true, introduces scrollbars when this widget is smaller than the specified  chart-content minimum {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinContentWidth width} or  {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinContentHeight height}.  These minimum sizes limit all chart-content,
     * including data and labels, titles and legends. <P> See {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getAutoScrollData autoScrollData} for a means to introduce scrolling
     * according to the data being displayed.
     *
     * @return Current autoScrollContent value. Default value is false
     */
    public boolean getAutoScrollContent()  {
        Boolean result = getAttributeAsBoolean("autoScrollContent");
        return result == null ? false : result;
    }
    

    /**
     * For some {@link com.smartgwt.client.widgets.chart.FacetChart#getChartType chart-types}, should the chart body be
     * automatically  expanded and scrollbars introduced according to data? <P> When true for a column, histogram, line, or
     * area chart that has {@link com.smartgwt.client.widgets.chart.FacetChart#getDataLabelFacet facet values displayed along
     * the x-axis}, the chart expands horizontally, showing a scroll  bar, if that's needed to make room for the facet value
     * labels or, for column and histogram  charts, to make space for the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinClusterSize minimum configured bar \n thicknesses} or the margins
     * between them. <P> When true for a Bar chart, expansion and scrollbar are vertical, and also make space for the  {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinClusterSize minimum configured bar thicknesses} or the margins
     * between them. <P> Note that this feature is incompatible with the following properties:<ul> <li>{@link
     * com.smartgwt.client.types.LabelCollapseMode} (other than the default of "none") <li>{@link
     * com.smartgwt.client.widgets.chart.FacetChart#getRotateLabels rotateLabels} (in "auto" mode) <li>{@link
     * com.smartgwt.client.widgets.drawing.DrawPane#getCanDragScroll canDragScroll} <li>{@link
     * com.smartgwt.client.widgets.chart.FacetChart#getCanZoom canZoom}</ul> If {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getRotateLabels rotateLabels} is set to "auto" it will be treated as
     * "never" if <code>autoScrollData</code> has been set.  If any of the other properties have non-default values, a warning
     * will be logged and <code>autoScrollData</code> will be disabled.  The factors used to drive expansion can be limited by
     * setting {@link com.smartgwt.client.types.AutoScrollDataApproach}.  You can also enforce a minimum size for the
     * chart-content, and scrollbars will be introduced if this widget shrinks below that size.  See  {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getAutoScrollContent autoScrollContent}, along with {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinContentWidth minContentWidth} and {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinContentHeight minContentHeight}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets {@link com.smartgwt.client.widgets.chart.FacetChart#getAutoScrollData autoScrollData} and updates the chart.
     *
     * @param autoScrollData whether chart should automatically expand                                   and show scrollbars to accommodate content. Default value is false
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.chart.FacetChart#setCanZoom
     * @see com.smartgwt.client.widgets.chart.FacetChart#setRotateLabels
     * @see com.smartgwt.client.types.LabelCollapseMode
     * @see com.smartgwt.client.widgets.chart.FacetChart#getMinClusterSize
     * @see com.smartgwt.client.widgets.drawing.DrawPane#setCanDragScroll
     */
    public FacetChart setAutoScrollData(boolean autoScrollData) {
        return (FacetChart)setAttribute("autoScrollData", autoScrollData, true);
    }

    /**
     * For some {@link com.smartgwt.client.widgets.chart.FacetChart#getChartType chart-types}, should the chart body be
     * automatically  expanded and scrollbars introduced according to data? <P> When true for a column, histogram, line, or
     * area chart that has {@link com.smartgwt.client.widgets.chart.FacetChart#getDataLabelFacet facet values displayed along
     * the x-axis}, the chart expands horizontally, showing a scroll  bar, if that's needed to make room for the facet value
     * labels or, for column and histogram  charts, to make space for the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinClusterSize minimum configured bar \n thicknesses} or the margins
     * between them. <P> When true for a Bar chart, expansion and scrollbar are vertical, and also make space for the  {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinClusterSize minimum configured bar thicknesses} or the margins
     * between them. <P> Note that this feature is incompatible with the following properties:<ul> <li>{@link
     * com.smartgwt.client.types.LabelCollapseMode} (other than the default of "none") <li>{@link
     * com.smartgwt.client.widgets.chart.FacetChart#getRotateLabels rotateLabels} (in "auto" mode) <li>{@link
     * com.smartgwt.client.widgets.drawing.DrawPane#getCanDragScroll canDragScroll} <li>{@link
     * com.smartgwt.client.widgets.chart.FacetChart#getCanZoom canZoom}</ul> If {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getRotateLabels rotateLabels} is set to "auto" it will be treated as
     * "never" if <code>autoScrollData</code> has been set.  If any of the other properties have non-default values, a warning
     * will be logged and <code>autoScrollData</code> will be disabled.  The factors used to drive expansion can be limited by
     * setting {@link com.smartgwt.client.types.AutoScrollDataApproach}.  You can also enforce a minimum size for the
     * chart-content, and scrollbars will be introduced if this widget shrinks below that size.  See  {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getAutoScrollContent autoScrollContent}, along with {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinContentWidth minContentWidth} and {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinContentHeight minContentHeight}.
     *
     * @return Current autoScrollData value. Default value is false
     * @see com.smartgwt.client.widgets.chart.FacetChart#getCanZoom
     * @see com.smartgwt.client.widgets.chart.FacetChart#getRotateLabels
     * @see com.smartgwt.client.types.LabelCollapseMode
     * @see com.smartgwt.client.widgets.chart.FacetChart#getMinClusterSize
     * @see com.smartgwt.client.widgets.drawing.DrawPane#getCanDragScroll
     */
    public boolean getAutoScrollData()  {
        Boolean result = getAttributeAsBoolean("autoScrollData");
        return result == null ? false : result;
    }
    

    /**
     * If set, overrides the default behavior of {@link com.smartgwt.client.widgets.chart.FacetChart#getAutoScrollData
     * autoScrollData}, potentially limiting what factors drive the automatic expansion of the chart.  (The "both" setting is
     * no different than the default of null.) <P> When labels are on the x-axis, and if you're sizing bars very tightly to
     * labels by  defining {@link com.smartgwt.client.widgets.chart.FacetChart#getMinClusterSize getMinClusterSize()}, you may
     * not want label-driven expansion, as the  default separation assigned between them is very generous, and is based on the
     * widest  labels.  (You may also set {@link com.smartgwt.client.widgets.chart.FacetChart#getMinLabelGap minLabelGap} to
     * gain more control over the separation.)
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets {@link com.smartgwt.client.types.AutoScrollDataApproach} and updates the chart.
     *
     * @param autoScrollDataApproach what should drive horizontal expansion                                                       of the chart?. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.chart.FacetChart#setAutoScrollData
     */
    public FacetChart setAutoScrollDataApproach(AutoScrollDataApproach autoScrollDataApproach) {
        return (FacetChart)setAttribute("autoScrollDataApproach", autoScrollDataApproach == null ? null : autoScrollDataApproach.getValue(), true);
    }

    /**
     * If set, overrides the default behavior of {@link com.smartgwt.client.widgets.chart.FacetChart#getAutoScrollData
     * autoScrollData}, potentially limiting what factors drive the automatic expansion of the chart.  (The "both" setting is
     * no different than the default of null.) <P> When labels are on the x-axis, and if you're sizing bars very tightly to
     * labels by  defining {@link com.smartgwt.client.widgets.chart.FacetChart#getMinClusterSize getMinClusterSize()}, you may
     * not want label-driven expansion, as the  default separation assigned between them is very generous, and is based on the
     * widest  labels.  (You may also set {@link com.smartgwt.client.widgets.chart.FacetChart#getMinLabelGap minLabelGap} to
     * gain more control over the separation.)
     *
     * @return Current autoScrollDataApproach value. Default value is null
     * @see com.smartgwt.client.widgets.chart.FacetChart#getAutoScrollData
     */
    public AutoScrollDataApproach getAutoScrollDataApproach()  {
        return EnumUtil.getEnum(AutoScrollDataApproach.values(), getAttribute("autoScrollDataApproach"));
    }
    

    /**
     * Whether to draw data points in order of descending {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getPointSizeMetric point size} so that small values are less likely to be
     * completely occluded by larger values.  Set this to <code>false</code> to draw the data points in the same order that
     * they appear in the data.
     *
     * @param autoSortBubblePoints New autoSortBubblePoints value. Default value is true
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#bubbleChart" target="examples">Bubble Chart Example</a>
     */
    public FacetChart setAutoSortBubblePoints(boolean autoSortBubblePoints)  throws IllegalStateException {
        return (FacetChart)setAttribute("autoSortBubblePoints", autoSortBubblePoints, false);
    }

    /**
     * Whether to draw data points in order of descending {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getPointSizeMetric point size} so that small values are less likely to be
     * completely occluded by larger values.  Set this to <code>false</code> to draw the data points in the same order that
     * they appear in the data.
     *
     * @return Current autoSortBubblePoints value. Default value is true
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#bubbleChart" target="examples">Bubble Chart Example</a>
     */
    public boolean getAutoSortBubblePoints()  {
        Boolean result = getAttributeAsBoolean("autoSortBubblePoints");
        return result == null ? true : result;
    }
    

    /**
     * End value for the primary axis of the chart. <p> If set to an explicit value, this will be respected. If unset, the axis
     * end value will default to a value large enough to the largest data point, rounded up to the nearest (next) gradation.
     * <p> For multi-axis charts, Bubble charts, and Scatter charts, the <code>facetChart.axisEndValue</code> affects only the
     * <b>first</b> axis of the chart. End values for other axes of multi-axis charts can be set on a per-axis basis via {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#getXAxisEndValue MetricSettings.xAxisEndValue}.  For Scatter charts,
     * the {@link com.smartgwt.client.widgets.chart.FacetChart#getXAxisEndValue xAxisEndValue} property must be used to set the
     * end value of the x-axis. <p> Note that if this chart's data includes points that fall above this value, they are
     * ommitted and effectively treated as null values. For charts showing a data line, developers may wish to set {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getDiscontinuousLines discontinuousLines} to true in this case.
     *
     * @param axisEndValue New axisEndValue value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setAxisEndValue(Double axisEndValue)  throws IllegalStateException {
        return (FacetChart)setAttribute("axisEndValue", axisEndValue, false);
    }

    /**
     * End value for the primary axis of the chart. <p> If set to an explicit value, this will be respected. If unset, the axis
     * end value will default to a value large enough to the largest data point, rounded up to the nearest (next) gradation.
     * <p> For multi-axis charts, Bubble charts, and Scatter charts, the <code>facetChart.axisEndValue</code> affects only the
     * <b>first</b> axis of the chart. End values for other axes of multi-axis charts can be set on a per-axis basis via {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#getXAxisEndValue MetricSettings.xAxisEndValue}.  For Scatter charts,
     * the {@link com.smartgwt.client.widgets.chart.FacetChart#getXAxisEndValue xAxisEndValue} property must be used to set the
     * end value of the x-axis. <p> Note that if this chart's data includes points that fall above this value, they are
     * ommitted and effectively treated as null values. For charts showing a data line, developers may wish to set {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getDiscontinuousLines discontinuousLines} to true in this case.
     *
     * @return Current axisEndValue value. Default value is null
     */
    public Double getAxisEndValue()  {
        return getAttributeAsDouble("axisEndValue");
    }
    

    /**
     * Start value for the primary axis of the chart. <p> If set to an explicit value, this will be respected. If unset, the
     * axis start value will default to 0, or to a value that makes good use of vertical space based on {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinDataSpreadPercent minDataSpreadPercent}. <P> For multi-axis charts,
     * Bubble charts, and Scatter charts, the <code>facetChart.axisStartValue</code> affects only the <b>first</b> axis of the
     * chart. Start values for other axes of multi-axis charts can be set on a per-axis basis via {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#getAxisStartValue MetricSettings.axisStartValue}.  For Scatter charts,
     * the {@link com.smartgwt.client.widgets.chart.FacetChart#getXAxisStartValue xAxisStartValue} property must be used to set
     * the start value of the x-axis. <p> Note that if this chart's data includes points that fall below this value, they are
     * ommitted and effectively treated as null values. For charts showing a data line, developers may wish to set {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getDiscontinuousLines discontinuousLines} to true in this case.
     *
     * @param axisStartValue New axisStartValue value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setAxisStartValue(Double axisStartValue)  throws IllegalStateException {
        return (FacetChart)setAttribute("axisStartValue", axisStartValue, false);
    }

    /**
     * Start value for the primary axis of the chart. <p> If set to an explicit value, this will be respected. If unset, the
     * axis start value will default to 0, or to a value that makes good use of vertical space based on {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinDataSpreadPercent minDataSpreadPercent}. <P> For multi-axis charts,
     * Bubble charts, and Scatter charts, the <code>facetChart.axisStartValue</code> affects only the <b>first</b> axis of the
     * chart. Start values for other axes of multi-axis charts can be set on a per-axis basis via {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#getAxisStartValue MetricSettings.axisStartValue}.  For Scatter charts,
     * the {@link com.smartgwt.client.widgets.chart.FacetChart#getXAxisStartValue xAxisStartValue} property must be used to set
     * the start value of the x-axis. <p> Note that if this chart's data includes points that fall below this value, they are
     * ommitted and effectively treated as null values. For charts showing a data line, developers may wish to set {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getDiscontinuousLines discontinuousLines} to true in this case.
     *
     * @return Current axisStartValue value. Default value is null
     */
    public Double getAxisStartValue()  {
        return getAttributeAsDouble("axisStartValue");
    }
    

    /**
     * Properties for background band
     *
     * @param backgroundBandProperties New backgroundBandProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public FacetChart setBackgroundBandProperties(DrawRect backgroundBandProperties)  throws IllegalStateException {
        if (backgroundBandProperties != null) {
            if (backgroundBandProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setBackgroundBandProperties", "DrawRect");
            }                                                                       
            backgroundBandProperties.setConfigOnly(true);
        }
        JavaScriptObject config = backgroundBandProperties == null ? null : backgroundBandProperties.getConfig();
        return (FacetChart)setAttribute("backgroundBandProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for background band
     *
     * @return Current backgroundBandProperties value. Default value is null
     */
    public DrawRect getBackgroundBandProperties()  {
        DrawRect properties = new DrawRect();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("backgroundBandProperties"));
        return properties;
    }
    

    /**
     * Whether to show alternating color bands in the background of chart.  See {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getBackgroundBandProperties backgroundBandProperties}.
     *
     * @param bandedBackground New bandedBackground value. Default value is true
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setBandedBackground(Boolean bandedBackground)  throws IllegalStateException {
        return (FacetChart)setAttribute("bandedBackground", bandedBackground, false);
    }

    /**
     * Whether to show alternating color bands in the background of chart.  See {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getBackgroundBandProperties backgroundBandProperties}.
     *
     * @return Current bandedBackground value. Default value is true
     */
    public Boolean getBandedBackground()  {
        Boolean result = getAttributeAsBoolean("bandedBackground");
        return result == null ? true : result;
    }
    

    /**
     * Whether to show color bands between the {@link com.smartgwt.client.widgets.chart.FacetChart#getStandardDeviations
     * standard deviation} lines. <p> Standard deviation bands are not available for pie or radar charts.
     *
     * @param bandedStandardDeviations New bandedStandardDeviations value. Default value is false
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.chart.FacetChart#setStandardDeviationBandProperties
     */
    public FacetChart setBandedStandardDeviations(Boolean bandedStandardDeviations)  throws IllegalStateException {
        return (FacetChart)setAttribute("bandedStandardDeviations", bandedStandardDeviations, false);
    }

    /**
     * Whether to show color bands between the {@link com.smartgwt.client.widgets.chart.FacetChart#getStandardDeviations
     * standard deviation} lines. <p> Standard deviation bands are not available for pie or radar charts.
     *
     * @return Current bandedStandardDeviations value. Default value is false
     * @see com.smartgwt.client.widgets.chart.FacetChart#getStandardDeviationBandProperties
     */
    public Boolean getBandedStandardDeviations()  {
        Boolean result = getAttributeAsBoolean("bandedStandardDeviations");
        return result == null ? false : result;
    }
    

    /**
     * Distance between bars.  May be reduced if bars would be smaller than {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinBarThickness minBarThickness}.
     *
     * @param barMargin New barMargin value. Default value is 4
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setBarMargin(int barMargin)  throws IllegalStateException {
        return (FacetChart)setAttribute("barMargin", barMargin, false);
    }

    /**
     * Distance between bars.  May be reduced if bars would be smaller than {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinBarThickness minBarThickness}.
     *
     * @return Current barMargin value. Default value is 4
     */
    public int getBarMargin()  {
        return getAttributeAsInt("barMargin");
    }
    

    /**
     * Properties for bar
     *
     * @param barProperties New barProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public FacetChart setBarProperties(DrawRect barProperties) {
        if (barProperties != null) {
            if (barProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setBarProperties", "DrawRect");
            }                                                                       
            barProperties.setConfigOnly(true);
        }
        JavaScriptObject config = barProperties == null ? null : barProperties.getConfig();
        return (FacetChart)setAttribute("barProperties", JSOHelper.cleanProperties(config, true), true);
    }

    /**
     * Properties for bar
     *
     * @return Current barProperties value. Default value is null
     */
    public DrawRect getBarProperties()  {
        DrawRect properties = new DrawRect();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("barProperties"));
        return properties;
    }
    

    /**
     * When hovering over a bar chart block, should the whole bar chart area be brightened Default behaviour is to just
     * brighten the line color around the bar chart area
     *
     * @param brightenAllOnHover New brightenAllOnHover value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     */
    public FacetChart setBrightenAllOnHover(Boolean brightenAllOnHover) {
        return (FacetChart)setAttribute("brightenAllOnHover", brightenAllOnHover, true);
    }

    /**
     * When hovering over a bar chart block, should the whole bar chart area be brightened Default behaviour is to just
     * brighten the line color around the bar chart area
     *
     * @return Current brightenAllOnHover value. Default value is null
     */
    public Boolean getBrightenAllOnHover()  {
        return getAttributeAsBoolean("brightenAllOnHover");
    }
    

    /**
     * Maximum distance from the *outer radius* of the nearest bubble when hover will be shown.
     *
     * @param bubbleHoverMaxDistance New bubbleHoverMaxDistance value. Default value is 50
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setBubbleHoverMaxDistance(int bubbleHoverMaxDistance)  throws IllegalStateException {
        return (FacetChart)setAttribute("bubbleHoverMaxDistance", bubbleHoverMaxDistance, false);
    }

    /**
     * Maximum distance from the *outer radius* of the nearest bubble when hover will be shown.
     *
     * @return Current bubbleHoverMaxDistance value. Default value is 50
     */
    public int getBubbleHoverMaxDistance()  {
        return getAttributeAsInt("bubbleHoverMaxDistance");
    }
    

    /**
     * Properties for the shapes displayed around the data points (for example, in a bubble chart). <p> When either the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getPointSizeMetric pointSizeMetric} or the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getColorScaleMetric colorScaleMetric} is active the default
     * <code>bubbleProperties</code> displays each data points with a linear gradient.
     *
     * @param bubbleProperties New bubbleProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#bubbleChart" target="examples">Bubble Chart Example</a>
     */
    public FacetChart setBubbleProperties(DrawItem bubbleProperties)  throws IllegalStateException {
        if (bubbleProperties != null) {
            if (bubbleProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setBubbleProperties", "DrawItem");
            }                                                                       
            bubbleProperties.setConfigOnly(true);
        }
        JavaScriptObject config = bubbleProperties == null ? null : bubbleProperties.getConfig();
        return (FacetChart)setAttribute("bubbleProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for the shapes displayed around the data points (for example, in a bubble chart). <p> When either the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getPointSizeMetric pointSizeMetric} or the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getColorScaleMetric colorScaleMetric} is active the default
     * <code>bubbleProperties</code> displays each data points with a linear gradient.
     *
     * @return Current bubbleProperties value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#bubbleChart" target="examples">Bubble Chart Example</a>
     */
    public DrawItem getBubbleProperties()  {
        DrawItem properties = new DrawItem();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("bubbleProperties"));
        return properties;
    }
    

    /**
     * Whether the positions of value axes can be changed.  The default is true for charts with three or more vertical, value
     * axes.
     *
     * @param canMoveAxes New canMoveAxes value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setCanMoveAxes(Boolean canMoveAxes)  throws IllegalStateException {
        return (FacetChart)setAttribute("canMoveAxes", canMoveAxes, false);
    }

    /**
     * Whether the positions of value axes can be changed.  The default is true for charts with three or more vertical, value
     * axes.
     *
     * @return Current canMoveAxes value. Default value is null
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
     * @param canZoom New canZoom value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setCanZoom(Boolean canZoom)  throws IllegalStateException {
        return (FacetChart)setAttribute("canZoom", canZoom, false);
    }

    /**
     * Enables "zooming" on the X axis, specifically, only a portion of the overall dataset is shown in the main chart, and a
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getZoomChart second smaller chart} appears with slider controls
     * allowing a range to be selected for display in the main chart. <P> A {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getLabelCollapseMode labelCollapseMode} is automatically enabled if unset
     * and is based on the type of the first non-null data value.
     *
     * @return Current canZoom value. Default value is null
     */
    public Boolean getCanZoom()  {
        return getAttributeAsBoolean("canZoom");
    }
    

    /**
     * Whether to place the {@link com.smartgwt.client.widgets.chart.FacetChart#getShowLegend chart legend} with respect to the
     * full,  scrollable width of the chart when {@link com.smartgwt.client.widgets.chart.FacetChart#getAutoScrollData
     * autoScrollData} is active.  The default of false  means that the legend will be placed in the visible, non-overflowed
     * region of the chart, for  greater visibility. <P> Note that alignment of the legend itself is governed by  {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getLegendAlign legendAlign}. <P> Note that this setting has no impact on
     * axis labeling, which always occurs with respect to the full, expanded width of the chart.
     *
     * @param centerLegend New centerLegend value. Default value is false
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.chart.FacetChart#setShowLegend
     * @see com.smartgwt.client.widgets.chart.FacetChart#setCenterTitle
     * @see com.smartgwt.client.widgets.chart.FacetChart#setAutoScrollData
     */
    public FacetChart setCenterLegend(Boolean centerLegend)  throws IllegalStateException {
        return (FacetChart)setAttribute("centerLegend", centerLegend, false);
    }

    /**
     * Whether to place the {@link com.smartgwt.client.widgets.chart.FacetChart#getShowLegend chart legend} with respect to the
     * full,  scrollable width of the chart when {@link com.smartgwt.client.widgets.chart.FacetChart#getAutoScrollData
     * autoScrollData} is active.  The default of false  means that the legend will be placed in the visible, non-overflowed
     * region of the chart, for  greater visibility. <P> Note that alignment of the legend itself is governed by  {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getLegendAlign legendAlign}. <P> Note that this setting has no impact on
     * axis labeling, which always occurs with respect to the full, expanded width of the chart.
     *
     * @return Current centerLegend value. Default value is false
     * @see com.smartgwt.client.widgets.chart.FacetChart#getShowLegend
     * @see com.smartgwt.client.widgets.chart.FacetChart#getCenterTitle
     * @see com.smartgwt.client.widgets.chart.FacetChart#getAutoScrollData
     */
    public Boolean getCenterLegend()  {
        Boolean result = getAttributeAsBoolean("centerLegend");
        return result == null ? false : result;
    }
    

    /**
     * Whether to place the {@link com.smartgwt.client.widgets.chart.FacetChart#getShowTitle chart title} with respect to the
     * full,  scrollable width of the chart when {@link com.smartgwt.client.widgets.chart.FacetChart#getAutoScrollData
     * autoScrollData} is active.  The default of false  means that the title will be placed in the visible, non-overflowed
     * region of the chart, for  greater visibility. <P> Note that alignment of the title itself is governed by  {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getTitleAlign titleAlign}.
     *
     * @param centerTitle New centerTitle value. Default value is false
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.chart.FacetChart#setTitle
     * @see com.smartgwt.client.widgets.chart.FacetChart#setShowTitle
     * @see com.smartgwt.client.widgets.chart.FacetChart#setCenterLegend
     * @see com.smartgwt.client.widgets.chart.FacetChart#setAutoScrollData
     */
    public FacetChart setCenterTitle(Boolean centerTitle)  throws IllegalStateException {
        return (FacetChart)setAttribute("centerTitle", centerTitle, false);
    }

    /**
     * Whether to place the {@link com.smartgwt.client.widgets.chart.FacetChart#getShowTitle chart title} with respect to the
     * full,  scrollable width of the chart when {@link com.smartgwt.client.widgets.chart.FacetChart#getAutoScrollData
     * autoScrollData} is active.  The default of false  means that the title will be placed in the visible, non-overflowed
     * region of the chart, for  greater visibility. <P> Note that alignment of the title itself is governed by  {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getTitleAlign titleAlign}.
     *
     * @return Current centerTitle value. Default value is false
     * @see com.smartgwt.client.widgets.chart.FacetChart#getTitle
     * @see com.smartgwt.client.widgets.chart.FacetChart#getShowTitle
     * @see com.smartgwt.client.widgets.chart.FacetChart#getCenterLegend
     * @see com.smartgwt.client.widgets.chart.FacetChart#getAutoScrollData
     */
    public Boolean getCenterTitle()  {
        Boolean result = getAttributeAsBoolean("centerTitle");
        return result == null ? false : result;
    }
    

    /**
     * Margin around the main chart rect: between title and chart, between chart and axis labels, and chart rect and right edge
     * of chart.
     *
     * @param chartRectMargin New chartRectMargin value. Default value is 5
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setChartRectMargin(int chartRectMargin)  throws IllegalStateException {
        return (FacetChart)setAttribute("chartRectMargin", chartRectMargin, false);
    }

    /**
     * Margin around the main chart rect: between title and chart, between chart and axis labels, and chart rect and right edge
     * of chart.
     *
     * @return Current chartRectMargin value. Default value is 5
     */
    public int getChartRectMargin()  {
        return getAttributeAsInt("chartRectMargin");
    }
    

    /**
     * Properties for chart rect.  By default, {@link com.smartgwt.client.widgets.drawing.DrawRect#getRounding rounding} of the
     * chart rect. causes the gradation lines to be automatically inset from the edge so that they do not run right along the
     * curve.  Set {@link com.smartgwt.client.widgets.chart.FacetChart#getPadChartRectByCornerRadius
     * padChartRectByCornerRadius} to <code>false</code> to change this default.
     *
     * @param chartRectProperties New chartRectProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public FacetChart setChartRectProperties(DrawRect chartRectProperties) {
        if (chartRectProperties != null) {
            if (chartRectProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setChartRectProperties", "DrawRect");
            }                                                                       
            chartRectProperties.setConfigOnly(true);
        }
        JavaScriptObject config = chartRectProperties == null ? null : chartRectProperties.getConfig();
        return (FacetChart)setAttribute("chartRectProperties", JSOHelper.cleanProperties(config, true), true);
    }

    /**
     * Properties for chart rect.  By default, {@link com.smartgwt.client.widgets.drawing.DrawRect#getRounding rounding} of the
     * chart rect. causes the gradation lines to be automatically inset from the edge so that they do not run right along the
     * curve.  Set {@link com.smartgwt.client.widgets.chart.FacetChart#getPadChartRectByCornerRadius
     * padChartRectByCornerRadius} to <code>false</code> to change this default.
     *
     * @return Current chartRectProperties value. Default value is null
     */
    public DrawRect getChartRectProperties()  {
        DrawRect properties = new DrawRect();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("chartRectProperties"));
        return properties;
    }
    

    /**
     * See {@link com.smartgwt.client.types.ChartType} for a list of known types - Column, Bar, Line, Pie, Doughnut, Area,
     * Radar, and Histogram charts are supported.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Method to change the current {@link com.smartgwt.client.types.ChartType chartType}. Will redraw the chart if drawn.  Will use default settings for the new chart type for {@link com.smartgwt.client.widgets.chart.FacetChart#getStacked stacked} and {@link com.smartgwt.client.widgets.chart.FacetChart#getFilled filled} if those values are null. <p> Note that for {@link com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics multi-axis} charts this method changes the <code>chartType</code> for the main value axis only.
     *
     * @param chartType new chart type. Default value is "Column"
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     */
    public FacetChart setChartType(ChartType chartType) {
        return (FacetChart)setAttribute("chartType", chartType == null ? null : chartType.getValue(), true);
    }

    /**
     * See {@link com.smartgwt.client.types.ChartType} for a list of known types - Column, Bar, Line, Pie, Doughnut, Area,
     * Radar, and Histogram charts are supported.
     *
     * @return Current chartType value. Default value is "Column"
     */
    public ChartType getChartType()  {
        return EnumUtil.getEnum(ChartType.values(), getAttribute("chartType"));
    }
    

    /**
     * For clustered charts, ratio between margins between individual bars and margins between clusters.
     *
     * @param clusterMarginRatio New clusterMarginRatio value. Default value is 4
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setClusterMarginRatio(float clusterMarginRatio)  throws IllegalStateException {
        return (FacetChart)setAttribute("clusterMarginRatio", clusterMarginRatio, false);
    }

    /**
     * For clustered charts, ratio between margins between individual bars and margins between clusters.
     *
     * @return Current clusterMarginRatio value. Default value is 4
     */
    public float getClusterMarginRatio()  {
        return getAttributeAsFloat("clusterMarginRatio");
    }
    

    /**
     * Should be set to a number between -100 and 100.  If set, all colors in the chart are "muted" by this percentage by
     * shifting them toward white (or for negative numbers, toward black).
     *
     * @param colorMutePercent New colorMutePercent value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setColorMutePercent(Float colorMutePercent)  throws IllegalStateException {
        return (FacetChart)setAttribute("colorMutePercent", colorMutePercent, false);
    }

    /**
     * Should be set to a number between -100 and 100.  If set, all colors in the chart are "muted" by this percentage by
     * shifting them toward white (or for negative numbers, toward black).
     *
     * @return Current colorMutePercent value. Default value is null
     */
    public Float getColorMutePercent()  {
        return getAttributeAsFloat("colorMutePercent");
    }
    

    /**
     * For charts where {@link com.smartgwt.client.widgets.chart.FacetChart#getShowDataPoints showDataPoints} is enabled, this
     * property specifies an additional metric (i.e. an "id" of a metric facet value) that causes the data points to be colored
     * from {@link com.smartgwt.client.widgets.chart.FacetChart#getScaleStartColor scaleStartColor} to {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getScaleEndColor scaleEndColor} based on a linear scale over the values of
     * this metric.  Log-scaling for color scale is also supported with {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getLogScalePointColor logScalePointColor}.
     *
     * @param colorScaleMetric New colorScaleMetric value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#colorScaleChart" target="examples">Color Scale Chart Example</a>
     */
    public FacetChart setColorScaleMetric(String colorScaleMetric)  throws IllegalStateException {
        return (FacetChart)setAttribute("colorScaleMetric", colorScaleMetric, false);
    }

    /**
     * For charts where {@link com.smartgwt.client.widgets.chart.FacetChart#getShowDataPoints showDataPoints} is enabled, this
     * property specifies an additional metric (i.e. an "id" of a metric facet value) that causes the data points to be colored
     * from {@link com.smartgwt.client.widgets.chart.FacetChart#getScaleStartColor scaleStartColor} to {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getScaleEndColor scaleEndColor} based on a linear scale over the values of
     * this metric.  Log-scaling for color scale is also supported with {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getLogScalePointColor logScalePointColor}.
     *
     * @return Current colorScaleMetric value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#colorScaleChart" target="examples">Color Scale Chart Example</a>
     */
    public String getColorScaleMetric()  {
        return getAttributeAsString("colorScaleMetric");
    }
    
    

    /**
     * Properties for labels of data axis.
     *
     * @param dataAxisLabelProperties New dataAxisLabelProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public FacetChart setDataAxisLabelProperties(DrawLabel dataAxisLabelProperties) {
        if (dataAxisLabelProperties != null) {
            if (dataAxisLabelProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setDataAxisLabelProperties", "DrawLabel");
            }                                                                       
            dataAxisLabelProperties.setConfigOnly(true);
        }
        JavaScriptObject config = dataAxisLabelProperties == null ? null : dataAxisLabelProperties.getConfig();
        return (FacetChart)setAttribute("dataAxisLabelProperties", JSOHelper.cleanProperties(config, true), true);
    }

    /**
     * Properties for labels of data axis.
     *
     * @return Current dataAxisLabelProperties value. Default value is null
     */
    public DrawLabel getDataAxisLabelProperties()  {
        DrawLabel properties = new DrawLabel();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("dataAxisLabelProperties"));
        return properties;
    }
    

    /**
     * An array of colors to use for a series of visual elements representing data (eg columns, bars, pie slices), any of which
     * may be adjacent to any other. <P> Colors must be in the format of a leading hash (#) plus 6 hexadecimal digits, for
     * example,  "#FFFFFF" is white, "#FF0000" is pure red.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.chart.FacetChart#getDataColors dataColors}.
     *
     * @param dataColors New set of data colors. Default value is see below
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public FacetChart setDataColors(String... dataColors) {
        return (FacetChart)setAttribute("dataColors", dataColors, true);
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
     * Properties for data label
     *
     * @param dataLabelProperties New dataLabelProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public FacetChart setDataLabelProperties(DrawLabel dataLabelProperties) {
        if (dataLabelProperties != null) {
            if (dataLabelProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setDataLabelProperties", "DrawLabel");
            }                                                                       
            dataLabelProperties.setConfigOnly(true);
        }
        JavaScriptObject config = dataLabelProperties == null ? null : dataLabelProperties.getConfig();
        return (FacetChart)setAttribute("dataLabelProperties", JSOHelper.cleanProperties(config, true), true);
    }

    /**
     * Properties for data label
     *
     * @return Current dataLabelProperties value. Default value is null
     */
    public DrawLabel getDataLabelProperties()  {
        DrawLabel properties = new DrawLabel();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("dataLabelProperties"));
        return properties;
    }
    

    /**
     * Properties for lines that show data (as opposed to gradations or borders around the data area).
     *
     * @param dataLineProperties New dataLineProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public FacetChart setDataLineProperties(DrawLine dataLineProperties)  throws IllegalStateException {
        if (dataLineProperties != null) {
            if (dataLineProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setDataLineProperties", "DrawLine");
            }                                                                       
            dataLineProperties.setConfigOnly(true);
        }
        JavaScriptObject config = dataLineProperties == null ? null : dataLineProperties.getConfig();
        return (FacetChart)setAttribute("dataLineProperties", JSOHelper.cleanProperties(config, true), false);
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
     * How to draw lines between adjacent data points in Line and Scatter charts. See {@link
     * com.smartgwt.client.types.DataLineType}. <p> Does not apply to boundary lines for shapes in Area or Radar plots.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Method to change the current {@link com.smartgwt.client.types.ChartType dataLineType}. Will redraw the chart if drawn.
     *
     * @param dataLineType ow to draw lines between adjacent data points in Line and Scatter charts. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     */
    public FacetChart setDataLineType(DataLineType dataLineType) {
        return (FacetChart)setAttribute("dataLineType", dataLineType == null ? null : dataLineType.getValue(), true);
    }

    /**
     * How to draw lines between adjacent data points in Line and Scatter charts. See {@link
     * com.smartgwt.client.types.DataLineType}. <p> Does not apply to boundary lines for shapes in Area or Radar plots.
     *
     * @return Current dataLineType value. Default value is null
     */
    public DataLineType getDataLineType()  {
        return EnumUtil.getEnum(DataLineType.values(), getAttribute("dataLineType"));
    }
    

    /**
     * For rectangular charts (bar, column, line), margin around the inside of the main chart area, so that data elements are
     * not flush to edge.
     *
     * @param dataMargin New dataMargin value. Default value is 10
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setDataMargin(int dataMargin)  throws IllegalStateException {
        return (FacetChart)setAttribute("dataMargin", dataMargin, false);
    }

    /**
     * For rectangular charts (bar, column, line), margin around the inside of the main chart area, so that data elements are
     * not flush to edge.
     *
     * @return Current dataMargin value. Default value is 10
     */
    public int getDataMargin()  {
        return getAttributeAsInt("dataMargin");
    }
    

    /**
     * Properties for lines that outline a data shape (in filled charts such as area or radar charts).
     *
     * @param dataOutlineProperties New dataOutlineProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public FacetChart setDataOutlineProperties(DrawItem dataOutlineProperties)  throws IllegalStateException {
        if (dataOutlineProperties != null) {
            if (dataOutlineProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setDataOutlineProperties", "DrawItem");
            }                                                                       
            dataOutlineProperties.setConfigOnly(true);
        }
        JavaScriptObject config = dataOutlineProperties == null ? null : dataOutlineProperties.getConfig();
        return (FacetChart)setAttribute("dataOutlineProperties", JSOHelper.cleanProperties(config, true), false);
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
     * com.smartgwt.client.widgets.chart.FacetChart#getShowDataPoints showDataPoints}).
     *
     * @param dataPointProperties New dataPointProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public FacetChart setDataPointProperties(DrawItem dataPointProperties)  throws IllegalStateException {
        if (dataPointProperties != null) {
            if (dataPointProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setDataPointProperties", "DrawItem");
            }                                                                       
            dataPointProperties.setConfigOnly(true);
        }
        JavaScriptObject config = dataPointProperties == null ? null : dataPointProperties.getConfig();
        return (FacetChart)setAttribute("dataPointProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Common properties to apply for all data points (see {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getShowDataPoints showDataPoints}).
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
     * @param dataPointSize New dataPointSize value. Default value is 5
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setDataPointSize(int dataPointSize)  throws IllegalStateException {
        return (FacetChart)setAttribute("dataPointSize", dataPointSize, false);
    }

    /**
     * Size in pixels for data points drawn for line, area, radar and other chart types.
     *
     * @return Current dataPointSize value. Default value is 5
     */
    public int getDataPointSize()  {
        return getAttributeAsInt("dataPointSize");
    }
    

    /**
     * Properties for data shapes (filled areas in area or radar charts).
     *
     * @param dataShapeProperties New dataShapeProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public FacetChart setDataShapeProperties(DrawPath dataShapeProperties)  throws IllegalStateException {
        if (dataShapeProperties != null) {
            if (dataShapeProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setDataShapeProperties", "DrawPath");
            }                                                                       
            dataShapeProperties.setConfigOnly(true);
        }
        JavaScriptObject config = dataShapeProperties == null ? null : dataShapeProperties.getConfig();
        return (FacetChart)setAttribute("dataShapeProperties", JSOHelper.cleanProperties(config, true), false);
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
     * Default precision used when formatting float numbers for axis labels
     *
     * @param decimalPrecision New decimalPrecision value. Default value is 2
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setDecimalPrecision(int decimalPrecision)  throws IllegalStateException {
        return (FacetChart)setAttribute("decimalPrecision", decimalPrecision, false);
    }

    /**
     * Default precision used when formatting float numbers for axis labels
     *
     * @return Current decimalPrecision value. Default value is 2
     */
    public int getDecimalPrecision()  {
        return getAttributeAsInt("decimalPrecision");
    }
    

    /**
     * Whether to treat non-numeric values in the dataset as indicating a break in the data line.  If set to <code>false</code>
     * then null values are ignored.  Defaults to <code>true</code> for {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getFilled filled} charts and to <code>false</code> for line charts.
     *
     * @param discontinuousLines New discontinuousLines value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     */
    public FacetChart setDiscontinuousLines(Boolean discontinuousLines) {
        return (FacetChart)setAttribute("discontinuousLines", discontinuousLines, true);
    }

    /**
     * Whether to treat non-numeric values in the dataset as indicating a break in the data line.  If set to <code>false</code>
     * then null values are ignored.  Defaults to <code>true</code> for {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getFilled filled} charts and to <code>false</code> for line charts.
     *
     * @return Current discontinuousLines value. Default value is null
     */
    public Boolean getDiscontinuousLines()  {
        return getAttributeAsBoolean("discontinuousLines");
    }
    

    /**
     * Properties for doughnut hole
     *
     * @param doughnutHoleProperties New doughnutHoleProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public FacetChart setDoughnutHoleProperties(DrawOval doughnutHoleProperties) {
        if (doughnutHoleProperties != null) {
            if (doughnutHoleProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setDoughnutHoleProperties", "DrawOval");
            }                                                                       
            doughnutHoleProperties.setConfigOnly(true);
        }
        JavaScriptObject config = doughnutHoleProperties == null ? null : doughnutHoleProperties.getConfig();
        return (FacetChart)setAttribute("doughnutHoleProperties", JSOHelper.cleanProperties(config, true), true);
    }

    /**
     * Properties for doughnut hole
     *
     * @return Current doughnutHoleProperties value. Default value is null
     */
    public DrawOval getDoughnutHoleProperties()  {
        DrawOval properties = new DrawOval();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("doughnutHoleProperties"));
        return properties;
    }
    

    /**
     * If showing a doughnut hole (see {@link com.smartgwt.client.widgets.chart.FacetChart#getShowDoughnut showDoughnut}),
     * ratio of the size of the doughnut hole to the size of the overall pie chart, as a number between 0 to 1.
     *
     * @param doughnutRatio New doughnutRatio value. Default value is 0.2
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setDoughnutRatio(float doughnutRatio)  throws IllegalStateException {
        return (FacetChart)setAttribute("doughnutRatio", doughnutRatio, false);
    }

    /**
     * If showing a doughnut hole (see {@link com.smartgwt.client.widgets.chart.FacetChart#getShowDoughnut showDoughnut}),
     * ratio of the size of the doughnut hole to the size of the overall pie chart, as a number between 0 to 1.
     *
     * @return Current doughnutRatio value. Default value is 0.2
     */
    public float getDoughnutRatio()  {
        return getAttributeAsFloat("doughnutRatio");
    }
    

    /**
     * Whether a boundary should be drawn above the Legend area for circumstances where the  chart area already has an outer
     * border. If the chart has no outer border, then the  {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getLegendRectProperties legendRectProperties} settings should be used
     * instead.
     *
     * @param drawLegendBoundary New drawLegendBoundary value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setDrawLegendBoundary(Boolean drawLegendBoundary)  throws IllegalStateException {
        return (FacetChart)setAttribute("drawLegendBoundary", drawLegendBoundary, false);
    }

    /**
     * Whether a boundary should be drawn above the Legend area for circumstances where the  chart area already has an outer
     * border. If the chart has no outer border, then the  {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getLegendRectProperties legendRectProperties} settings should be used
     * instead.
     *
     * @return Current drawLegendBoundary value. Default value is null
     */
    public Boolean getDrawLegendBoundary()  {
        return getAttributeAsBoolean("drawLegendBoundary");
    }
    

    /**
     * should a background color be set behind the Title. Use {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getTitleBackgroundProperties titleBackgroundProperties} to set these values
     * if this is true.
     *
     * @param drawTitleBackground New drawTitleBackground value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     */
    public FacetChart setDrawTitleBackground(Boolean drawTitleBackground) {
        return (FacetChart)setAttribute("drawTitleBackground", drawTitleBackground, true);
    }

    /**
     * should a background color be set behind the Title. Use {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getTitleBackgroundProperties titleBackgroundProperties} to set these values
     * if this is true.
     *
     * @return Current drawTitleBackground value. Default value is null
     */
    public Boolean getDrawTitleBackground()  {
        return getAttributeAsBoolean("drawTitleBackground");
    }
    

    /**
     * Whether a boundary should be drawn below the title area for circumstances where the  chart area already has an outer
     * border. If the chart has no outer border, then the  {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getTitleBackgroundProperties titleBackgroundProperties} settings should be
     * used instead.
     *
     * @param drawTitleBoundary New drawTitleBoundary value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     */
    public FacetChart setDrawTitleBoundary(Boolean drawTitleBoundary) {
        return (FacetChart)setAttribute("drawTitleBoundary", drawTitleBoundary, true);
    }

    /**
     * Whether a boundary should be drawn below the title area for circumstances where the  chart area already has an outer
     * border. If the chart has no outer border, then the  {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getTitleBackgroundProperties titleBackgroundProperties} settings should be
     * used instead.
     *
     * @return Current drawTitleBoundary value. Default value is null
     */
    public Boolean getDrawTitleBoundary()  {
        return getAttributeAsBoolean("drawTitleBoundary");
    }
    

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @param editProxyConstructor New editProxyConstructor value. Default value is "FacetChartEditProxy"
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public FacetChart setEditProxyConstructor(String editProxyConstructor)  throws IllegalStateException {
        return (FacetChart)setAttribute("editProxyConstructor", editProxyConstructor, false);
    }

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @return Current editProxyConstructor value. Default value is "FacetChartEditProxy"
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public String getEditProxyConstructor()  {
        return getAttributeAsString("editProxyConstructor");
    }
    

    /**
     * Specifies the attribute in the metric facet that will define the end point of segments in a histogram chart.  The start
     * point is set via the {@link com.smartgwt.client.widgets.chart.FacetChart#getValueProperty valueProperty}.
     *
     * @param endValueMetric New endValueMetric value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.chart.FacetChart#setMetricFacetId
     */
    public FacetChart setEndValueMetric(String endValueMetric)  throws IllegalStateException {
        return (FacetChart)setAttribute("endValueMetric", endValueMetric, false);
    }

    /**
     * Specifies the attribute in the metric facet that will define the end point of segments in a histogram chart.  The start
     * point is set via the {@link com.smartgwt.client.widgets.chart.FacetChart#getValueProperty valueProperty}.
     *
     * @return Current endValueMetric value. Default value is null
     * @see com.smartgwt.client.widgets.chart.FacetChart#getMetricFacetId
     */
    public String getEndValueMetric()  {
        return getAttributeAsString("endValueMetric");
    }
    

    /**
     * This property helps specify the color of the error bars and its value must be a number between -100 and 100.  Error bars
     * have the same color as the data line, but the colors are actually "muted" by this percentage by shifting them toward
     * white (or for negative numbers, toward black).  The default is to darken the data colors by 60% to get the error bar
     * colors.
     *
     * @param errorBarColorMutePercent New errorBarColorMutePercent value. Default value is -60
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setErrorBarColorMutePercent(float errorBarColorMutePercent)  throws IllegalStateException {
        return (FacetChart)setAttribute("errorBarColorMutePercent", errorBarColorMutePercent, false);
    }

    /**
     * This property helps specify the color of the error bars and its value must be a number between -100 and 100.  Error bars
     * have the same color as the data line, but the colors are actually "muted" by this percentage by shifting them toward
     * white (or for negative numbers, toward black).  The default is to darken the data colors by 60% to get the error bar
     * colors.
     *
     * @return Current errorBarColorMutePercent value. Default value is -60
     */
    public float getErrorBarColorMutePercent()  {
        return getAttributeAsFloat("errorBarColorMutePercent");
    }
    

    /**
     * Width of the horizontal line of the "T"-shape portion of the error bar).
     *
     * @param errorBarWidth New errorBarWidth value. Default value is 6
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setErrorBarWidth(int errorBarWidth)  throws IllegalStateException {
        return (FacetChart)setAttribute("errorBarWidth", errorBarWidth, false);
    }

    /**
     * Width of the horizontal line of the "T"-shape portion of the error bar).
     *
     * @return Current errorBarWidth value. Default value is 6
     */
    public int getErrorBarWidth()  {
        return getAttributeAsInt("errorBarWidth");
    }
    

    /**
     * Properties of the lines used to draw error bars (short, horizontal lines at the low and high metric values, and a
     * vertical connecting line). <p> Note that the {@link com.smartgwt.client.widgets.drawing.DrawItem#getLineColor lineColor}
     * property has no effect as the color of the error bars is derived from the color of the data line.
     *
     * @param errorLineProperties New errorLineProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.chart.FacetChart#setErrorBarColorMutePercent
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public FacetChart setErrorLineProperties(DrawLine errorLineProperties)  throws IllegalStateException {
        if (errorLineProperties != null) {
            if (errorLineProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setErrorLineProperties", "DrawLine");
            }                                                                       
            errorLineProperties.setConfigOnly(true);
        }
        JavaScriptObject config = errorLineProperties == null ? null : errorLineProperties.getConfig();
        return (FacetChart)setAttribute("errorLineProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties of the lines used to draw error bars (short, horizontal lines at the low and high metric values, and a
     * vertical connecting line). <p> Note that the {@link com.smartgwt.client.widgets.drawing.DrawItem#getLineColor lineColor}
     * property has no effect as the color of the error bars is derived from the color of the data line.
     *
     * @return Current errorLineProperties value. Default value is null
     * @see com.smartgwt.client.widgets.chart.FacetChart#getErrorBarColorMutePercent
     */
    public DrawLine getErrorLineProperties()  {
        DrawLine properties = new DrawLine();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("errorLineProperties"));
        return properties;
    }
    

    /**
     * Properties for the {@link com.smartgwt.client.widgets.chart.FacetChart#getShowExpectedValueLine line drawn at the mean
     * value}. <p> Note that for rectangular charts the properties are for a {@link
     * com.smartgwt.client.widgets.drawing.DrawLine}, and for radar charts the properties are for a {@link
     * com.smartgwt.client.widgets.drawing.DrawOval}.
     *
     * @param expectedValueLineProperties New expectedValueLineProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public FacetChart setExpectedValueLineProperties(DrawItem expectedValueLineProperties)  throws IllegalStateException {
        if (expectedValueLineProperties != null) {
            if (expectedValueLineProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setExpectedValueLineProperties", "DrawItem");
            }                                                                       
            expectedValueLineProperties.setConfigOnly(true);
        }
        JavaScriptObject config = expectedValueLineProperties == null ? null : expectedValueLineProperties.getConfig();
        return (FacetChart)setAttribute("expectedValueLineProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for the {@link com.smartgwt.client.widgets.chart.FacetChart#getShowExpectedValueLine line drawn at the mean
     * value}. <p> Note that for rectangular charts the properties are for a {@link
     * com.smartgwt.client.widgets.drawing.DrawLine}, and for radar charts the properties are for a {@link
     * com.smartgwt.client.widgets.drawing.DrawOval}.
     *
     * @return Current expectedValueLineProperties value. Default value is null
     */
    public DrawItem getExpectedValueLineProperties()  {
        DrawItem properties = new DrawItem();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("expectedValueLineProperties"));
        return properties;
    }
    

    /**
     * Horizontal alignment of labels shown in extra y-axes, shown to the right of the chart.
     *
     * @param extraAxisLabelAlign New extraAxisLabelAlign value. Default value is "left"
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     */
    public FacetChart setExtraAxisLabelAlign(Alignment extraAxisLabelAlign) {
        return (FacetChart)setAttribute("extraAxisLabelAlign", extraAxisLabelAlign == null ? null : extraAxisLabelAlign.getValue(), true);
    }

    /**
     * Horizontal alignment of labels shown in extra y-axes, shown to the right of the chart.
     *
     * @return Current extraAxisLabelAlign value. Default value is "left"
     */
    public Alignment getExtraAxisLabelAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("extraAxisLabelAlign"));
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
     * from the {@link com.smartgwt.client.widgets.cube.FacetValue#getTitle FacetValue.title} of each metric's FacetValue (or
     * the {@link com.smartgwt.client.widgets.chart.FacetChart#getValueTitle valueTitle} if the metric is the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getValueProperty valueProperty}). <p> The order of the metrics determines
     * the position of the corresponding axes on the chart as well as the z-ordering of the corresponding data lines. The first
     * and second extra value axes are placed to the right of the chart rectangle, and any remaining extra value axes are
     * placed to the left of the main value axis (and therefore to the left of the chart rectangle).
     *
     * @param extraAxisMetrics New extraAxisMetrics value. Default value is []
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setExtraAxisMetrics(String... extraAxisMetrics)  throws IllegalStateException {
        return (FacetChart)setAttribute("extraAxisMetrics", extraAxisMetrics, false);
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
     * from the {@link com.smartgwt.client.widgets.cube.FacetValue#getTitle FacetValue.title} of each metric's FacetValue (or
     * the {@link com.smartgwt.client.widgets.chart.FacetChart#getValueTitle valueTitle} if the metric is the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getValueProperty valueProperty}). <p> The order of the metrics determines
     * the position of the corresponding axes on the chart as well as the z-ordering of the corresponding data lines. The first
     * and second extra value axes are placed to the right of the chart rectangle, and any remaining extra value axes are
     * placed to the left of the main value axis (and therefore to the left of the chart rectangle).
     *
     * @return Current extraAxisMetrics value. Default value is []
     */
    public String[] getExtraAxisMetrics()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("extraAxisMetrics"));
    }
    

    /**
     * For charts will multiple vertical axes, optionally provides settings for how each {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics extra axis metric} is plotted.  See the main {@link
     * com.smartgwt.client.widgets.chart.FacetChart} docs for an overview of how multi-axis charts are used. <p> The chart of
     * each metric's values may be of any rectangular chart type that uses a vertical value axis ("Column", "Area", or "Line" -
     * "Histogram" is not supported). Because the charts will be superimposed over the same drawing area, there can only be one
     * "Column" chart and one "Area" chart.  The column chart is placed on the bottom followed by the area chart, and then the
     * line charts are drawn on top in the order of their metric in the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics extraAxisMetrics} array. If the {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#getChartType chartType}s are left unspecified then by default the first
     * metric will be drawn as columns and the remaining will be drawn as lines.
     *
     * @param extraAxisSettings New extraAxisSettings value. Default value is []
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setExtraAxisSettings(MetricSettings... extraAxisSettings)  throws IllegalStateException {
        return (FacetChart)setAttribute("extraAxisSettings", extraAxisSettings, false);
    }

    /**
     * For charts will multiple vertical axes, optionally provides settings for how each {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics extra axis metric} is plotted.  See the main {@link
     * com.smartgwt.client.widgets.chart.FacetChart} docs for an overview of how multi-axis charts are used. <p> The chart of
     * each metric's values may be of any rectangular chart type that uses a vertical value axis ("Column", "Area", or "Line" -
     * "Histogram" is not supported). Because the charts will be superimposed over the same drawing area, there can only be one
     * "Column" chart and one "Area" chart.  The column chart is placed on the bottom followed by the area chart, and then the
     * line charts are drawn on top in the order of their metric in the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics extraAxisMetrics} array. If the {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#getChartType chartType}s are left unspecified then by default the first
     * metric will be drawn as columns and the remaining will be drawn as lines.
     *
     * @return Current extraAxisSettings value. Default value is []
     */
    public MetricSettings[] getExtraAxisSettings()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfMetricSettings(getAttributeAsJavaScriptObject("extraAxisSettings"));
    }
    

    /**
     * An Array of facets, exactly analogous to {@link com.smartgwt.client.widgets.cube.CubeGrid#getFacets CubeGrid.facets},
     * except that: <ul> <li> the "inlinedValues" property can be set on a facet to change data representation as described
     * under  Chart.data. <li> for a non-inlined facet, Charts support auto-derivation of facetValues from the data. </ul> <p>
     * In all chart types except "Bubble" and "Scatter", the chart displays a value for each discrete value of one facet (i.e.
     * single-facet charts) or it displays a value for each combination of discrete values of two facets (multi-facet charts). 
     * The two discrete facets are the {@link com.smartgwt.client.widgets.chart.FacetChart#getDataLabelFacet data label facet}
     * and the {@link com.smartgwt.client.widgets.chart.FacetChart#getLegendFacet legend facet}.  They are named based on where
     * the {@link com.smartgwt.client.widgets.cube.Facet#getValues values} of the facet appear in the chart.  The facet whose
     * values are rendered as labels along the data axis or in the main chart area is the data label facet, and the facet whose
     * values are rendered in the legend is the legend facet. <p> For single-facet charts, most chart types have a data label
     * facet as the first facet but no legend facet.  Single-facet Pie charts have a legend facet as the first facet but no
     * data label facet.  Bubble and Scatter plots may have a legend facet as the second facet, after the metric facet. <p> In
     * all multi-facet charts, the data label facet is always first and the legend facet is second.  In most chart types the
     * data label facet and the legend facet may be swapped on the fly by the user clicking on the "Swap Facets" item of the
     * context menu.
     *
     * @param facets New facets value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setFacets(Facet... facets)  throws IllegalStateException {
        return (FacetChart)setAttribute("facets", facets, false);
    }

    /**
     * An Array of facets, exactly analogous to {@link com.smartgwt.client.widgets.cube.CubeGrid#getFacets CubeGrid.facets},
     * except that: <ul> <li> the "inlinedValues" property can be set on a facet to change data representation as described
     * under  Chart.data. <li> for a non-inlined facet, Charts support auto-derivation of facetValues from the data. </ul> <p>
     * In all chart types except "Bubble" and "Scatter", the chart displays a value for each discrete value of one facet (i.e.
     * single-facet charts) or it displays a value for each combination of discrete values of two facets (multi-facet charts). 
     * The two discrete facets are the {@link com.smartgwt.client.widgets.chart.FacetChart#getDataLabelFacet data label facet}
     * and the {@link com.smartgwt.client.widgets.chart.FacetChart#getLegendFacet legend facet}.  They are named based on where
     * the {@link com.smartgwt.client.widgets.cube.Facet#getValues values} of the facet appear in the chart.  The facet whose
     * values are rendered as labels along the data axis or in the main chart area is the data label facet, and the facet whose
     * values are rendered in the legend is the legend facet. <p> For single-facet charts, most chart types have a data label
     * facet as the first facet but no legend facet.  Single-facet Pie charts have a legend facet as the first facet but no
     * data label facet.  Bubble and Scatter plots may have a legend facet as the second facet, after the metric facet. <p> In
     * all multi-facet charts, the data label facet is always first and the legend facet is second.  In most chart types the
     * data label facet and the legend facet may be swapped on the fly by the user clicking on the "Swap Facets" item of the
     * context menu.
     *
     * @return Current facets value. Default value is null
     */
    public Facet[] getFacets()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfFacet(getAttributeAsJavaScriptObject("facets"));
    }

    /**
     * An Array of facets, exactly analogous to {@link com.smartgwt.client.widgets.cube.CubeGrid#getFacets CubeGrid.facets},
     * except that: <ul> <li> the "inlinedValues" property can be set on a facet to change data representation as described
     * under  Chart.data. <li> for a non-inlined facet, Charts support auto-derivation of facetValues from the data. </ul> <p>
     * In all chart types except "Bubble" and "Scatter", the chart displays a value for each discrete value of one facet (i.e.
     * single-facet charts) or it displays a value for each combination of discrete values of two facets (multi-facet charts). 
     * The two discrete facets are the {@link com.smartgwt.client.widgets.chart.FacetChart#getDataLabelFacet data label facet}
     * and the {@link com.smartgwt.client.widgets.chart.FacetChart#getLegendFacet legend facet}.  They are named based on where
     * the {@link com.smartgwt.client.widgets.cube.Facet#getValues values} of the facet appear in the chart.  The facet whose
     * values are rendered as labels along the data axis or in the main chart area is the data label facet, and the facet whose
     * values are rendered in the legend is the legend facet. <p> For single-facet charts, most chart types have a data label
     * facet as the first facet but no legend facet.  Single-facet Pie charts have a legend facet as the first facet but no
     * data label facet.  Bubble and Scatter plots may have a legend facet as the second facet, after the metric facet. <p> In
     * all multi-facet charts, the data label facet is always first and the legend facet is second.  In most chart types the
     * data label facet and the legend facet may be swapped on the fly by the user clicking on the "Swap Facets" item of the
     * context menu.
     *
     * @param facets New facets value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setFacets(Facet facets)  throws IllegalStateException {
        return (FacetChart)setAttribute("facets", facets == null ? null : facets.getJsObj(), false);
    }

    /**
     * An Array of facets, exactly analogous to {@link com.smartgwt.client.widgets.cube.CubeGrid#getFacets CubeGrid.facets},
     * except that: <ul> <li> the "inlinedValues" property can be set on a facet to change data representation as described
     * under  Chart.data. <li> for a non-inlined facet, Charts support auto-derivation of facetValues from the data. </ul> <p>
     * In all chart types except "Bubble" and "Scatter", the chart displays a value for each discrete value of one facet (i.e.
     * single-facet charts) or it displays a value for each combination of discrete values of two facets (multi-facet charts). 
     * The two discrete facets are the {@link com.smartgwt.client.widgets.chart.FacetChart#getDataLabelFacet data label facet}
     * and the {@link com.smartgwt.client.widgets.chart.FacetChart#getLegendFacet legend facet}.  They are named based on where
     * the {@link com.smartgwt.client.widgets.cube.Facet#getValues values} of the facet appear in the chart.  The facet whose
     * values are rendered as labels along the data axis or in the main chart area is the data label facet, and the facet whose
     * values are rendered in the legend is the legend facet. <p> For single-facet charts, most chart types have a data label
     * facet as the first facet but no legend facet.  Single-facet Pie charts have a legend facet as the first facet but no
     * data label facet.  Bubble and Scatter plots may have a legend facet as the second facet, after the metric facet. <p> In
     * all multi-facet charts, the data label facet is always first and the legend facet is second.  In most chart types the
     * data label facet and the legend facet may be swapped on the fly by the user clicking on the "Swap Facets" item of the
     * context menu.
     *
     * @return Current facets value. Default value is null
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
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Method to change {@link com.smartgwt.client.widgets.chart.FacetChart#getFilled filled}. Use null to apply a default value for the current {@link com.smartgwt.client.types.ChartType chartType}.
     *
     * @param filled new value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     */
    public FacetChart setFilled(Boolean filled) {
        return (FacetChart)setAttribute("filled", filled, true);
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
        return getAttributeAsBoolean("filled");
    }
    

    /**
     * Whether to call {@link com.smartgwt.client.widgets.chart.FacetChart#setXAxisValueFormatter setXAxisValueFormatter()} or
     * {@link com.smartgwt.client.widgets.chart.FacetChart#formatFacetValueId formatFacetValueId()} on a facet value id when
     * the id is a string.  Can be set false to allow the formatting function(s) to be written without having to handle the
     * string case.
     *
     * @param formatStringFacetValueIds New formatStringFacetValueIds value. Default value is true
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.chart.FacetChart#setXAxisValueFormatter
     * @see com.smartgwt.client.widgets.chart.FacetChart#formatFacetValueId
     */
    public FacetChart setFormatStringFacetValueIds(Boolean formatStringFacetValueIds) {
        return (FacetChart)setAttribute("formatStringFacetValueIds", formatStringFacetValueIds, true);
    }

    /**
     * Whether to call {@link com.smartgwt.client.widgets.chart.FacetChart#setXAxisValueFormatter setXAxisValueFormatter()} or
     * {@link com.smartgwt.client.widgets.chart.FacetChart#formatFacetValueId formatFacetValueId()} on a facet value id when
     * the id is a string.  Can be set false to allow the formatting function(s) to be written without having to handle the
     * string case.
     *
     * @return Current formatStringFacetValueIds value. Default value is true
     * @see com.smartgwt.client.widgets.chart.FacetChart#setXAxisValueFormatter
     * @see com.smartgwt.client.widgets.chart.FacetChart#formatFacetValueId
     */
    public Boolean getFormatStringFacetValueIds()  {
        Boolean result = getAttributeAsBoolean("formatStringFacetValueIds");
        return result == null ? true : result;
    }
    

    /**
     * Candidate gradation gaps to evaluate when trying to determine what gradations should be displayed on the primary axis,
     * which is typically the y (vertical) axis except for Bar charts. <P> Candidates are expressed as a series of numbers
     * between 1 and 10, representing boundaries within a given order of magnitude (power of 10). <P> For example, the setting
     * [1, 2.5, 5] means that, for a chart showing values that are only between 0 and 1, gradations of 0.1, 0.25 and 0.5 would
     * be evaluated to see which is a closer fit given the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getPixelsPerGradation pixelsPerGradation} setting and the chart's height. 
     * The same setting, with a chart showing values from 0 to 1,000,000 would imply that gradation gaps of 100,000, 250,000
     * and 500,000 would be evaluated.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.chart.FacetChart#getGradationGaps gradationGaps}.
     *
     * @param gradationGaps new {@link com.smartgwt.client.widgets.chart.FacetChart#getGradationGaps gradationGaps} value. Default value is [1, 2, 5]
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#customTicksChart" target="examples">Custom Date Ticks Example</a>
     */
    public FacetChart setGradationGaps(float... gradationGaps) {
        return (FacetChart)setAttribute("gradationGaps", gradationGaps, true);
    }

    /**
     * Candidate gradation gaps to evaluate when trying to determine what gradations should be displayed on the primary axis,
     * which is typically the y (vertical) axis except for Bar charts. <P> Candidates are expressed as a series of numbers
     * between 1 and 10, representing boundaries within a given order of magnitude (power of 10). <P> For example, the setting
     * [1, 2.5, 5] means that, for a chart showing values that are only between 0 and 1, gradations of 0.1, 0.25 and 0.5 would
     * be evaluated to see which is a closer fit given the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getPixelsPerGradation pixelsPerGradation} setting and the chart's height. 
     * The same setting, with a chart showing values from 0 to 1,000,000 would imply that gradation gaps of 100,000, 250,000
     * and 500,000 would be evaluated.
     *
     * @return Current gradationGaps value. Default value is [1, 2, 5]
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#customTicksChart" target="examples">Custom Date Ticks Example</a>
     */
    public float[] getGradationGaps()  {
        return com.smartgwt.client.util.ConvertTo.arrayOffloat(getAttributeAsJavaScriptObject("gradationGaps"));
    }
    

    /**
     * Padding from edge of Y the Axis Label.
     *
     * @param gradationLabelPadding New gradationLabelPadding value. Default value is 5
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setGradationLabelPadding(int gradationLabelPadding)  throws IllegalStateException {
        return (FacetChart)setAttribute("gradationLabelPadding", gradationLabelPadding, false);
    }

    /**
     * Padding from edge of Y the Axis Label.
     *
     * @return Current gradationLabelPadding value. Default value is 5
     */
    public int getGradationLabelPadding()  {
        return getAttributeAsInt("gradationLabelPadding");
    }
    

    /**
     * Properties for gradation labels
     *
     * @param gradationLabelProperties New gradationLabelProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public FacetChart setGradationLabelProperties(DrawLabel gradationLabelProperties)  throws IllegalStateException {
        if (gradationLabelProperties != null) {
            if (gradationLabelProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setGradationLabelProperties", "DrawLabel");
            }                                                                       
            gradationLabelProperties.setConfigOnly(true);
        }
        JavaScriptObject config = gradationLabelProperties == null ? null : gradationLabelProperties.getConfig();
        return (FacetChart)setAttribute("gradationLabelProperties", JSOHelper.cleanProperties(config, true), false);
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
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public FacetChart setGradationLineProperties(DrawLine gradationLineProperties)  throws IllegalStateException {
        if (gradationLineProperties != null) {
            if (gradationLineProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setGradationLineProperties", "DrawLine");
            }                                                                       
            gradationLineProperties.setConfigOnly(true);
        }
        JavaScriptObject config = gradationLineProperties == null ? null : gradationLineProperties.getConfig();
        return (FacetChart)setAttribute("gradationLineProperties", JSOHelper.cleanProperties(config, true), false);
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
     * 
     *
     * @param gradationTickMarkLength New gradationTickMarkLength value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.chart.FacetChart#setTickLength
     * @deprecated use {@link com.smartgwt.client.widgets.chart.FacetChart#getTickLength tickLength} instead
     */
    public FacetChart setGradationTickMarkLength(Integer gradationTickMarkLength)  throws IllegalStateException {
        return (FacetChart)setAttribute("gradationTickMarkLength", gradationTickMarkLength, false);
    }

    /**
     * 
     *
     * @return Current gradationTickMarkLength value. Default value is null
     * @see com.smartgwt.client.widgets.chart.FacetChart#getTickLength
     * @deprecated use {@link com.smartgwt.client.widgets.chart.FacetChart#getTickLength tickLength} instead
     */
    public Integer getGradationTickMarkLength()  {
        return getAttributeAsInt("gradationTickMarkLength");
    }
    

    /**
     * Properties for the gradation line drawn for zero (slightly thicker by default).
     *
     * @param gradationZeroLineProperties New gradationZeroLineProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public FacetChart setGradationZeroLineProperties(DrawLine gradationZeroLineProperties)  throws IllegalStateException {
        if (gradationZeroLineProperties != null) {
            if (gradationZeroLineProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setGradationZeroLineProperties", "DrawLine");
            }                                                                       
            gradationZeroLineProperties.setConfigOnly(true);
        }
        JavaScriptObject config = gradationZeroLineProperties == null ? null : gradationZeroLineProperties.getConfig();
        return (FacetChart)setAttribute("gradationZeroLineProperties", JSOHelper.cleanProperties(config, true), false);
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
     * See {@link com.smartgwt.client.widgets.chart.FacetChart#getLowErrorMetric lowErrorMetric}.
     *
     * @param highErrorMetric New highErrorMetric value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setHighErrorMetric(String highErrorMetric)  throws IllegalStateException {
        return (FacetChart)setAttribute("highErrorMetric", highErrorMetric, false);
    }

    /**
     * See {@link com.smartgwt.client.widgets.chart.FacetChart#getLowErrorMetric lowErrorMetric}.
     *
     * @return Current highErrorMetric value. Default value is null
     */
    public String getHighErrorMetric()  {
        return getAttributeAsString("highErrorMetric");
    }
    

    /**
     * An extra amount of padding to show around the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getHoverLabelProperties hoverLabel} when {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getShowValueOnHover showValueOnHover} is enabled.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param hoverLabelPadding New hoverLabelPadding value. Default value is 4
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setHoverLabelPadding(int hoverLabelPadding)  throws IllegalStateException {
        return (FacetChart)setAttribute("hoverLabelPadding", hoverLabelPadding, false);
    }

    /**
     * An extra amount of padding to show around the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getHoverLabelProperties hoverLabel} when {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getShowValueOnHover showValueOnHover} is enabled.
     *
     * @return Current hoverLabelPadding value. Default value is 4
     */
    public int getHoverLabelPadding()  {
        return getAttributeAsInt("hoverLabelPadding");
    }
    

    /**
     * Properties for text in a floating label that represents the data value shown whenever the mouse moves withing the main
     * chart area when {@link com.smartgwt.client.widgets.chart.FacetChart#getShowValueOnHover showValueOnHover} is enabled.
     *
     * @param hoverLabelProperties New hoverLabelProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.chart.FacetChart#setHoverLabelPadding
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public FacetChart setHoverLabelProperties(DrawLabel hoverLabelProperties)  throws IllegalStateException {
        if (hoverLabelProperties != null) {
            if (hoverLabelProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setHoverLabelProperties", "DrawLabel");
            }                                                                       
            hoverLabelProperties.setConfigOnly(true);
        }
        JavaScriptObject config = hoverLabelProperties == null ? null : hoverLabelProperties.getConfig();
        return (FacetChart)setAttribute("hoverLabelProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for text in a floating label that represents the data value shown whenever the mouse moves withing the main
     * chart area when {@link com.smartgwt.client.widgets.chart.FacetChart#getShowValueOnHover showValueOnHover} is enabled.
     *
     * @return Current hoverLabelProperties value. Default value is null
     * @see com.smartgwt.client.widgets.chart.FacetChart#getHoverLabelPadding
     */
    public DrawLabel getHoverLabelProperties()  {
        DrawLabel properties = new DrawLabel();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("hoverLabelProperties"));
        return properties;
    }
    

    /**
     * Properties for rectangle that draws behind of a floating hover label that represents the data value. See {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getShowValueOnHover showValueOnHover} for more details.
     *
     * @param hoverRectProperties New hoverRectProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public FacetChart setHoverRectProperties(DrawRect hoverRectProperties)  throws IllegalStateException {
        if (hoverRectProperties != null) {
            if (hoverRectProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setHoverRectProperties", "DrawRect");
            }                                                                       
            hoverRectProperties.setConfigOnly(true);
        }
        JavaScriptObject config = hoverRectProperties == null ? null : hoverRectProperties.getConfig();
        return (FacetChart)setAttribute("hoverRectProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for rectangle that draws behind of a floating hover label that represents the data value. See {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getShowValueOnHover showValueOnHover} for more details.
     *
     * @return Current hoverRectProperties value. Default value is null
     */
    public DrawRect getHoverRectProperties()  {
        DrawRect properties = new DrawRect();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("hoverRectProperties"));
        return properties;
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
     * In particular,  the {@link com.smartgwt.client.widgets.chart.ValueFormatter#format format} method for any setter applied
     * with  {@link com.smartgwt.client.widgets.chart.FacetChart#setXAxisValueFormatter setXAxisValueFormatter()} will not be
     * called on values for the x-axis.  However, FacetChart uses   the {@link
     * com.smartgwt.client.util.DateUtil#setShortMonthNames global array of abbreviated month names} for the time granularities
     * of quarters, months, and weeks, uses the  {@link com.smartgwt.client.util.DateUtil#setShortTimeDisplayFormatter default
     * short time format} to format labels for time granularities from minutes to hours, and uses the  {@link
     * com.smartgwt.client.util.DateUtil#setNormalTimeDisplayFormatter default time format} to format labels for the time
     * granularities of 15 seconds and 30 seconds.  The label format can be customized by changing these three formatters. 
     * Also note that for the time granularity of weeks the sequence of Dates will be the first day of each week, as specified
     * by  {@link com.smartgwt.client.util.DateUtil#setFirstDayOfWeek setFirstDayOfWeek()} .<P> Note that if the
     * labelCollapseMode is "time" or "numeric" then the {@link com.smartgwt.client.widgets.chart.FacetChart#getData data} must
     * be initially sorted with the {@link com.smartgwt.client.widgets.chart.FacetChart#getDataLabelFacet data label facet}'s
     * values in ascending order.
     *
     * @param labelCollapseMode New labelCollapseMode value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.chart.FacetChart#setXAxisValueFormatter
     */
    public FacetChart setLabelCollapseMode(LabelCollapseMode labelCollapseMode)  throws IllegalStateException {
        return (FacetChart)setAttribute("labelCollapseMode", labelCollapseMode == null ? null : labelCollapseMode.getValue(), false);
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
     * In particular,  the {@link com.smartgwt.client.widgets.chart.ValueFormatter#format format} method for any setter applied
     * with  {@link com.smartgwt.client.widgets.chart.FacetChart#setXAxisValueFormatter setXAxisValueFormatter()} will not be
     * called on values for the x-axis.  However, FacetChart uses   the {@link
     * com.smartgwt.client.util.DateUtil#setShortMonthNames global array of abbreviated month names} for the time granularities
     * of quarters, months, and weeks, uses the  {@link com.smartgwt.client.util.DateUtil#setShortTimeDisplayFormatter default
     * short time format} to format labels for time granularities from minutes to hours, and uses the  {@link
     * com.smartgwt.client.util.DateUtil#setNormalTimeDisplayFormatter default time format} to format labels for the time
     * granularities of 15 seconds and 30 seconds.  The label format can be customized by changing these three formatters. 
     * Also note that for the time granularity of weeks the sequence of Dates will be the first day of each week, as specified
     * by  {@link com.smartgwt.client.util.DateUtil#setFirstDayOfWeek setFirstDayOfWeek()} .<P> Note that if the
     * labelCollapseMode is "time" or "numeric" then the {@link com.smartgwt.client.widgets.chart.FacetChart#getData data} must
     * be initially sorted with the {@link com.smartgwt.client.widgets.chart.FacetChart#getDataLabelFacet data label facet}'s
     * values in ascending order.
     *
     * @return Current labelCollapseMode value. Default value is null
     * @see com.smartgwt.client.widgets.chart.FacetChart#setXAxisValueFormatter
     */
    public LabelCollapseMode getLabelCollapseMode()  {
        return EnumUtil.getEnum(LabelCollapseMode.values(), getAttribute("labelCollapseMode"));
    }
    

    /**
     * Horizontal alignment of the chart's {@link com.smartgwt.client.widgets.chart.FacetChart#getShowLegend legend widget}.
     *
     * @param legendAlign New legendAlign value. Default value is "center"
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     */
    public FacetChart setLegendAlign(LegendAlign legendAlign) {
        return (FacetChart)setAttribute("legendAlign", legendAlign == null ? null : legendAlign.getValue(), true);
    }

    /**
     * Horizontal alignment of the chart's {@link com.smartgwt.client.widgets.chart.FacetChart#getShowLegend legend widget}.
     *
     * @return Current legendAlign value. Default value is "center"
     */
    public LegendAlign getLegendAlign()  {
        return EnumUtil.getEnum(LegendAlign.values(), getAttribute("legendAlign"));
    }
    

    /**
     * Properties for top boundary of the legend are, when there is already an outer container around the whole chart. see
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getDrawLegendBoundary drawLegendBoundary}
     *
     * @param legendBoundaryProperties New legendBoundaryProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public FacetChart setLegendBoundaryProperties(DrawLine legendBoundaryProperties)  throws IllegalStateException {
        if (legendBoundaryProperties != null) {
            if (legendBoundaryProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setLegendBoundaryProperties", "DrawLine");
            }                                                                       
            legendBoundaryProperties.setConfigOnly(true);
        }
        JavaScriptObject config = legendBoundaryProperties == null ? null : legendBoundaryProperties.getConfig();
        return (FacetChart)setAttribute("legendBoundaryProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for top boundary of the legend are, when there is already an outer container around the whole chart. see
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getDrawLegendBoundary drawLegendBoundary}
     *
     * @return Current legendBoundaryProperties value. Default value is null
     */
    public DrawLine getLegendBoundaryProperties()  {
        DrawLine properties = new DrawLine();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("legendBoundaryProperties"));
        return properties;
    }
    

    /**
     * Padding between each swatch and label pair.
     *
     * @param legendItemPadding New legendItemPadding value. Default value is 5
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setLegendItemPadding(int legendItemPadding)  throws IllegalStateException {
        return (FacetChart)setAttribute("legendItemPadding", legendItemPadding, false);
    }

    /**
     * Padding between each swatch and label pair.
     *
     * @return Current legendItemPadding value. Default value is 5
     */
    public int getLegendItemPadding()  {
        return getAttributeAsInt("legendItemPadding");
    }
    

    /**
     * Properties for labels shown next to legend color swatches.
     *
     * @param legendLabelProperties New legendLabelProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public FacetChart setLegendLabelProperties(DrawLabel legendLabelProperties)  throws IllegalStateException {
        if (legendLabelProperties != null) {
            if (legendLabelProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setLegendLabelProperties", "DrawLabel");
            }                                                                       
            legendLabelProperties.setConfigOnly(true);
        }
        JavaScriptObject config = legendLabelProperties == null ? null : legendLabelProperties.getConfig();
        return (FacetChart)setAttribute("legendLabelProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for labels shown next to legend color swatches.
     *
     * @return Current legendLabelProperties value. Default value is null
     */
    public DrawLabel getLegendLabelProperties()  {
        DrawLabel properties = new DrawLabel();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("legendLabelProperties"));
        return properties;
    }
    

    /**
     * Space between the legend and the chart rect or axis labels (whatever the legend is adjacent to.
     *
     * @param legendMargin New legendMargin value. Default value is 10
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setLegendMargin(int legendMargin)  throws IllegalStateException {
        return (FacetChart)setAttribute("legendMargin", legendMargin, false);
    }

    /**
     * Space between the legend and the chart rect or axis labels (whatever the legend is adjacent to.
     *
     * @return Current legendMargin value. Default value is 10
     */
    public int getLegendMargin()  {
        return getAttributeAsInt("legendMargin");
    }
    

    /**
     * Padding around the legend as a whole.
     *
     * @param legendPadding New legendPadding value. Default value is 5
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setLegendPadding(int legendPadding)  throws IllegalStateException {
        return (FacetChart)setAttribute("legendPadding", legendPadding, false);
    }

    /**
     * Padding around the legend as a whole.
     *
     * @return Current legendPadding value. Default value is 5
     */
    public int getLegendPadding()  {
        return getAttributeAsInt("legendPadding");
    }
    

    /**
     * If drawing a border around the legend, the height of the drawn Rectangle.
     *
     * @param legendRectHeight New legendRectHeight value. Default value is 5
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setLegendRectHeight(int legendRectHeight)  throws IllegalStateException {
        return (FacetChart)setAttribute("legendRectHeight", legendRectHeight, false);
    }

    /**
     * If drawing a border around the legend, the height of the drawn Rectangle.
     *
     * @return Current legendRectHeight value. Default value is 5
     */
    public int getLegendRectHeight()  {
        return getAttributeAsInt("legendRectHeight");
    }
    

    /**
     * Properties for rectangle around the legend as a whole.
     *
     * @param legendRectProperties New legendRectProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public FacetChart setLegendRectProperties(DrawRect legendRectProperties)  throws IllegalStateException {
        if (legendRectProperties != null) {
            if (legendRectProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setLegendRectProperties", "DrawRect");
            }                                                                       
            legendRectProperties.setConfigOnly(true);
        }
        JavaScriptObject config = legendRectProperties == null ? null : legendRectProperties.getConfig();
        return (FacetChart)setAttribute("legendRectProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for rectangle around the legend as a whole.
     *
     * @return Current legendRectProperties value. Default value is null
     */
    public DrawRect getLegendRectProperties()  {
        DrawRect properties = new DrawRect();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("legendRectProperties"));
        return properties;
    }
    

    /**
     * Properties for the swatches of color shown in the legend.
     *
     * @param legendSwatchProperties New legendSwatchProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public FacetChart setLegendSwatchProperties(DrawRect legendSwatchProperties)  throws IllegalStateException {
        if (legendSwatchProperties != null) {
            if (legendSwatchProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setLegendSwatchProperties", "DrawRect");
            }                                                                       
            legendSwatchProperties.setConfigOnly(true);
        }
        JavaScriptObject config = legendSwatchProperties == null ? null : legendSwatchProperties.getConfig();
        return (FacetChart)setAttribute("legendSwatchProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for the swatches of color shown in the legend.
     *
     * @return Current legendSwatchProperties value. Default value is null
     */
    public DrawRect getLegendSwatchProperties()  {
        DrawRect properties = new DrawRect();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("legendSwatchProperties"));
        return properties;
    }
    

    /**
     * Size of individual color swatches in legend.
     *
     * @param legendSwatchSize New legendSwatchSize value. Default value is 16
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setLegendSwatchSize(int legendSwatchSize)  throws IllegalStateException {
        return (FacetChart)setAttribute("legendSwatchSize", legendSwatchSize, false);
    }

    /**
     * Size of individual color swatches in legend.
     *
     * @return Current legendSwatchSize value. Default value is 16
     */
    public int getLegendSwatchSize()  {
        return getAttributeAsInt("legendSwatchSize");
    }
    

    /**
     * Padding between color swatch and its label.
     *
     * @param legendTextPadding New legendTextPadding value. Default value is 5
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setLegendTextPadding(int legendTextPadding)  throws IllegalStateException {
        return (FacetChart)setAttribute("legendTextPadding", legendTextPadding, false);
    }

    /**
     * Padding between color swatch and its label.
     *
     * @return Current legendTextPadding value. Default value is 5
     */
    public int getLegendTextPadding()  {
        return getAttributeAsInt("legendTextPadding");
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.chart.FacetChart#getUseLogGradations useLogGradations}, base value for
     * logarithmic gradation lines.  Gradation lines will be shown at every power of this value plus intervening values
     * specified by {@link com.smartgwt.client.widgets.chart.FacetChart#getLogGradations logGradations}.
     *
     * @param logBase New logBase value. Default value is 10
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setLogBase(int logBase)  throws IllegalStateException {
        return (FacetChart)setAttribute("logBase", logBase, false);
    }

    /**
     * When {@link com.smartgwt.client.widgets.chart.FacetChart#getUseLogGradations useLogGradations}, base value for
     * logarithmic gradation lines.  Gradation lines will be shown at every power of this value plus intervening values
     * specified by {@link com.smartgwt.client.widgets.chart.FacetChart#getLogGradations logGradations}.
     *
     * @return Current logBase value. Default value is 10
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
     * @param logGradations New logGradations value. Default value is [ 1,2,4,6,8 ]
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setLogGradations(float... logGradations)  throws IllegalStateException {
        return (FacetChart)setAttribute("logGradations", logGradations, false);
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
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setLogScale(Boolean logScale)  throws IllegalStateException {
        return (FacetChart)setAttribute("logScale", logScale, false);
    }

    /**
     * Whether to use logarithmic scaling for values. <P> Logarithmic scale charts show an equivalent percentage increase as
     * equivalent distance on the chart.  That is, 10 and 100 are the same distance apart as 100 and 1000 (each being a 10
     * times or 1000% increase).
     *
     * @return Current logScale value. Default value is false
     */
    public Boolean getLogScale()  {
        Boolean result = getAttributeAsBoolean("logScale");
        return result == null ? false : result;
    }
    

    /**
     * Whether to use logarithmic scaling for the {@link com.smartgwt.client.widgets.chart.FacetChart#getColorScaleMetric color
     * scale} of the data points.  Defaults to the value of {@link com.smartgwt.client.widgets.chart.FacetChart#getLogScale
     * logScale}.
     *
     * @param logScalePointColor New logScalePointColor value. Default value is false
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.chart.FacetChart#setPointColorLogBase
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#colorScaleChart" target="examples">Color Scale Chart Example</a>
     */
    public FacetChart setLogScalePointColor(boolean logScalePointColor)  throws IllegalStateException {
        return (FacetChart)setAttribute("logScalePointColor", logScalePointColor, false);
    }

    /**
     * Whether to use logarithmic scaling for the {@link com.smartgwt.client.widgets.chart.FacetChart#getColorScaleMetric color
     * scale} of the data points.  Defaults to the value of {@link com.smartgwt.client.widgets.chart.FacetChart#getLogScale
     * logScale}.
     *
     * @return Current logScalePointColor value. Default value is false
     * @see com.smartgwt.client.widgets.chart.FacetChart#getPointColorLogBase
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#colorScaleChart" target="examples">Color Scale Chart Example</a>
     */
    public boolean getLogScalePointColor()  {
        Boolean result = getAttributeAsBoolean("logScalePointColor");
        return result == null ? false : result;
    }
    

    /**
     * Whether to use logarithmic scaling for the {@link com.smartgwt.client.widgets.chart.FacetChart#getPointSizeMetric data
     * point sizes}. Defaults to the value of {@link com.smartgwt.client.widgets.chart.FacetChart#getLogScale logScale}.
     *
     * @param logScalePointSize New logScalePointSize value. Default value is false
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.chart.FacetChart#setPointSizeLogBase
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#bubbleChart" target="examples">Bubble Chart Example</a>
     */
    public FacetChart setLogScalePointSize(boolean logScalePointSize)  throws IllegalStateException {
        return (FacetChart)setAttribute("logScalePointSize", logScalePointSize, false);
    }

    /**
     * Whether to use logarithmic scaling for the {@link com.smartgwt.client.widgets.chart.FacetChart#getPointSizeMetric data
     * point sizes}. Defaults to the value of {@link com.smartgwt.client.widgets.chart.FacetChart#getLogScale logScale}.
     *
     * @return Current logScalePointSize value. Default value is false
     * @see com.smartgwt.client.widgets.chart.FacetChart#getPointSizeLogBase
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#bubbleChart" target="examples">Bubble Chart Example</a>
     */
    public boolean getLogScalePointSize()  {
        Boolean result = getAttributeAsBoolean("logScalePointSize");
        return result == null ? false : result;
    }
    

    /**
     * <code>lowErrorMetric</code> and {@link com.smartgwt.client.widgets.chart.FacetChart#getHighErrorMetric highErrorMetric}
     * can be used to cause error bars to appear above and below the main data point. <p> <code>lowErrorMetric</code> and
     * <code>highErrorMetric</code> provide the name of an additional attributes that appears in each Record holding the low
     * error value and high error value respectively. <p> Error bars are supported for single-axis charts only.
     *
     * @param lowErrorMetric New lowErrorMetric value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.chart.FacetChart#setMetricFacetId
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#errorBars" target="examples">Error Bars Example</a>
     */
    public FacetChart setLowErrorMetric(String lowErrorMetric)  throws IllegalStateException {
        return (FacetChart)setAttribute("lowErrorMetric", lowErrorMetric, false);
    }

    /**
     * <code>lowErrorMetric</code> and {@link com.smartgwt.client.widgets.chart.FacetChart#getHighErrorMetric highErrorMetric}
     * can be used to cause error bars to appear above and below the main data point. <p> <code>lowErrorMetric</code> and
     * <code>highErrorMetric</code> provide the name of an additional attributes that appears in each Record holding the low
     * error value and high error value respectively. <p> Error bars are supported for single-axis charts only.
     *
     * @return Current lowErrorMetric value. Default value is null
     * @see com.smartgwt.client.widgets.chart.FacetChart#getMetricFacetId
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#errorBars" target="examples">Error Bars Example</a>
     */
    public String getLowErrorMetric()  {
        return getAttributeAsString("lowErrorMetric");
    }
    

    /**
     * List of tick marks that should be drawn as major ticks, expressed as a series of numbers between 1 and 10, representing
     * boundaries within a given order of magnitude (power of 10).  These numbers must be multiples of {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getGradationGaps gradationGaps}, or no ticks will end up as minor ticks.
     * <p> The default setting of [1] means that major ticks are used for powers of 10 only.  A setting of [1,5] would mean
     * that major ticks are also used at half-orders of magnitude, such as 0.5 or 50.  For example, if used with a {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getGradationGaps gradationGaps} setting of [1,2.5] for a chart showing
     * values between 0 and 1, this would result in major ticks at 0, 1 and 0.5, and minor ticks at 0.25 and 0.75. <P> See also
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getMajorTickTimeIntervals majorTickTimeIntervals} for controlling
     * major vs minor ticks for the X-axis of time/date-valued Scatter plots.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.chart.FacetChart#getMajorTickGradations majorTickGradations}.
     *
     * @param majorTickGradations new {@link com.smartgwt.client.widgets.chart.FacetChart#getMajorTickGradations majorTickGradations} value. Default value is [1]
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setMajorTickGradations(float... majorTickGradations)  throws IllegalStateException {
        return (FacetChart)setAttribute("majorTickGradations", majorTickGradations, false);
    }

    /**
     * List of tick marks that should be drawn as major ticks, expressed as a series of numbers between 1 and 10, representing
     * boundaries within a given order of magnitude (power of 10).  These numbers must be multiples of {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getGradationGaps gradationGaps}, or no ticks will end up as minor ticks.
     * <p> The default setting of [1] means that major ticks are used for powers of 10 only.  A setting of [1,5] would mean
     * that major ticks are also used at half-orders of magnitude, such as 0.5 or 50.  For example, if used with a {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getGradationGaps gradationGaps} setting of [1,2.5] for a chart showing
     * values between 0 and 1, this would result in major ticks at 0, 1 and 0.5, and minor ticks at 0.25 and 0.75. <P> See also
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getMajorTickTimeIntervals majorTickTimeIntervals} for controlling
     * major vs minor ticks for the X-axis of time/date-valued Scatter plots.
     *
     * @return Current majorTickGradations value. Default value is [1]
     */
    public float[] getMajorTickGradations()  {
        return com.smartgwt.client.util.ConvertTo.arrayOffloat(getAttributeAsJavaScriptObject("majorTickGradations"));
    }
    

    /**
     * When ticks are being {@link com.smartgwt.client.widgets.chart.FacetChart#getShowXTicks shown on the X axis} for a
     * Scatter plot where the X axis uses time/date values, controls the intervals which are shown as major ticks. <p> The
     * intervals are specified as Strings, in the same way as {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getOtherAxisGradationTimes otherAxisGradationTimes}. <p> For any given
     * interval, the first major tick is shown for the next greatest time unit. For example, for interval such as "2h" (2
     * hours), the first major tick starts on the day  boundary (whether that day boundary is visible in the chart or not). <p>
     * By default, all ticks are shown as major ticks.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.chart.FacetChart#getMajorTickTimeIntervals majorTickTimeIntervals}.
     *
     * @param majorTickTimeIntervals new {@link com.smartgwt.client.widgets.chart.FacetChart#getMajorTickTimeIntervals majorTickTimeIntervals} value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     */
    public FacetChart setMajorTickTimeIntervals(String... majorTickTimeIntervals) {
        return (FacetChart)setAttribute("majorTickTimeIntervals", majorTickTimeIntervals, true);
    }

    /**
     * When ticks are being {@link com.smartgwt.client.widgets.chart.FacetChart#getShowXTicks shown on the X axis} for a
     * Scatter plot where the X axis uses time/date values, controls the intervals which are shown as major ticks. <p> The
     * intervals are specified as Strings, in the same way as {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getOtherAxisGradationTimes otherAxisGradationTimes}. <p> For any given
     * interval, the first major tick is shown for the next greatest time unit. For example, for interval such as "2h" (2
     * hours), the first major tick starts on the day  boundary (whether that day boundary is visible in the chart or not). <p>
     * By default, all ticks are shown as major ticks.
     *
     * @return Current majorTickTimeIntervals value. Default value is null
     */
    public String[] getMajorTickTimeIntervals()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("majorTickTimeIntervals"));
    }
    

    /**
     * Setting to define whether the border around the bar chart area should be the same color as the main chart area.
     *
     * @param matchBarChartDataLineColor New matchBarChartDataLineColor value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     */
    public FacetChart setMatchBarChartDataLineColor(Boolean matchBarChartDataLineColor) {
        return (FacetChart)setAttribute("matchBarChartDataLineColor", matchBarChartDataLineColor, true);
    }

    /**
     * Setting to define whether the border around the bar chart area should be the same color as the main chart area.
     *
     * @return Current matchBarChartDataLineColor value. Default value is null
     */
    public Boolean getMatchBarChartDataLineColor()  {
        return getAttributeAsBoolean("matchBarChartDataLineColor");
    }
    

    /**
     * Bars will not be drawn over this thickness, instead, margins will be increased.
     *
     * @param maxBarThickness New maxBarThickness value. Default value is 150
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.chart.FacetChart#getMinClusterSize
     */
    public FacetChart setMaxBarThickness(int maxBarThickness)  throws IllegalStateException {
        return (FacetChart)setAttribute("maxBarThickness", maxBarThickness, false);
    }

    /**
     * Bars will not be drawn over this thickness, instead, margins will be increased.
     *
     * @return Current maxBarThickness value. Default value is 150
     * @see com.smartgwt.client.widgets.chart.FacetChart#getMinClusterSize
     */
    public int getMaxBarThickness()  {
        return getAttributeAsInt("maxBarThickness");
    }
    

    /**
     * The maximum allowed data point size when controlled by {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getPointSizeMetric pointSizeMetric}.
     *
     * @param maxDataPointSize New maxDataPointSize value. Default value is 14
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setMaxDataPointSize(double maxDataPointSize)  throws IllegalStateException {
        return (FacetChart)setAttribute("maxDataPointSize", maxDataPointSize, false);
    }

    /**
     * The maximum allowed data point size when controlled by {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getPointSizeMetric pointSizeMetric}.
     *
     * @return Current maxDataPointSize value. Default value is 14
     */
    public double getMaxDataPointSize()  {
        return getAttributeAsDouble("maxDataPointSize");
    }
    

    /**
     * Maximum allowed zIndex that can be specified through {@link com.smartgwt.client.widgets.chart.FacetChart#getZIndexMetric
     * zIndexMetric} in a histogram chart.  Any zIndex values exceeding this property will be internally clipped so as to not
     * exceed it.  While this property can be increased, note that very large values may hit limitations related to the
     * browser's implementation of the current  {@link com.smartgwt.client.widgets.drawing.DrawPane#getDrawingType
     * DrawPane.drawingType}.
     *
     * @param maxDataZIndex New maxDataZIndex value. Default value is 10000
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.types.ChartType
     * @see com.smartgwt.client.widgets.chart.FacetChart#setZIndexMetric
     */
    public FacetChart setMaxDataZIndex(Integer maxDataZIndex)  throws IllegalStateException {
        return (FacetChart)setAttribute("maxDataZIndex", maxDataZIndex, false);
    }

    /**
     * Maximum allowed zIndex that can be specified through {@link com.smartgwt.client.widgets.chart.FacetChart#getZIndexMetric
     * zIndexMetric} in a histogram chart.  Any zIndex values exceeding this property will be internally clipped so as to not
     * exceed it.  While this property can be increased, note that very large values may hit limitations related to the
     * browser's implementation of the current  {@link com.smartgwt.client.widgets.drawing.DrawPane#getDrawingType
     * DrawPane.drawingType}.
     *
     * @return Current maxDataZIndex value. Default value is 10000
     * @see com.smartgwt.client.types.ChartType
     * @see com.smartgwt.client.widgets.chart.FacetChart#getZIndexMetric
     */
    public Integer getMaxDataZIndex()  {
        return getAttributeAsInt("maxDataZIndex");
    }
    

    /**
     * Specifies the "id" of the default metric facet value.  The default metric is used with {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getLowErrorMetric lowErrorMetric} and {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getHighErrorMetric highErrorMetric} when showing error bars.
     *
     * @param metricFacetId New metricFacetId value. Default value is "metric"
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setMetricFacetId(String metricFacetId)  throws IllegalStateException {
        return (FacetChart)setAttribute("metricFacetId", metricFacetId, false);
    }

    /**
     * Specifies the "id" of the default metric facet value.  The default metric is used with {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getLowErrorMetric lowErrorMetric} and {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getHighErrorMetric highErrorMetric} when showing error bars.
     *
     * @return Current metricFacetId value. Default value is "metric"
     */
    public String getMetricFacetId()  {
        return getAttributeAsString("metricFacetId");
    }
    

    /**
     * If bars would be smaller than this size, margins are reduced until bars overlap.
     *
     * @param minBarThickness New minBarThickness value. Default value is 4
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.chart.FacetChart#getMinClusterSize
     */
    public FacetChart setMinBarThickness(int minBarThickness)  throws IllegalStateException {
        return (FacetChart)setAttribute("minBarThickness", minBarThickness, false);
    }

    /**
     * If bars would be smaller than this size, margins are reduced until bars overlap.
     *
     * @return Current minBarThickness value. Default value is 4
     * @see com.smartgwt.client.widgets.chart.FacetChart#getMinClusterSize
     */
    public int getMinBarThickness()  {
        return getAttributeAsInt("minBarThickness");
    }
    

    /**
     * Minimum height for this chart instance.
     *
     * @param minChartHeight New minChartHeight value. Default value is 1
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setMinChartHeight(Integer minChartHeight)  throws IllegalStateException {
        return (FacetChart)setAttribute("minChartHeight", minChartHeight, false);
    }

    /**
     * Minimum height for this chart instance.
     *
     * @return Returns the {@link com.smartgwt.client.widgets.chart.FacetChart#getMinChartHeight minimum height} for the chart body. Default value is 1
     */
    public Integer getMinChartHeight()  {
        return getAttributeAsInt("minChartHeight");
    }
    

    /**
     * Minimum width for this chart instance.
     *
     * @param minChartWidth New minChartWidth value. Default value is 1
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setMinChartWidth(Integer minChartWidth)  throws IllegalStateException {
        return (FacetChart)setAttribute("minChartWidth", minChartWidth, false);
    }

    /**
     * Minimum width for this chart instance.
     *
     * @return Returns the {@link com.smartgwt.client.widgets.chart.FacetChart#getMinChartWidth minimum width} for the chart body. Default value is 1
     */
    public Integer getMinChartWidth()  {
        return getAttributeAsInt("minChartWidth");
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.chart.FacetChart#getAutoScrollContent autoScrollContent} is true, limits the
     * minimum  height of the chart-content, including data, labels, title and legends.  If this widget is sized smaller than
     * this height, scrollbars are introduced to reach the hidden content.  See {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinContentWidth minContentWidth} to affect the minimum horizontal 
     * content-size.
     *
     * @param minContentHeight New minContentHeight value. Default value is 150
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     */
    public FacetChart setMinContentHeight(int minContentHeight) {
        return (FacetChart)setAttribute("minContentHeight", minContentHeight, true);
    }

    /**
     * When {@link com.smartgwt.client.widgets.chart.FacetChart#getAutoScrollContent autoScrollContent} is true, limits the
     * minimum  height of the chart-content, including data, labels, title and legends.  If this widget is sized smaller than
     * this height, scrollbars are introduced to reach the hidden content.  See {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinContentWidth minContentWidth} to affect the minimum horizontal 
     * content-size.
     *
     * @return Returns the {@link com.smartgwt.client.widgets.chart.FacetChart#getMinContentHeight minContentHeight} for this facet
     * chart when {@link com.smartgwt.client.widgets.chart.FacetChart#getAutoScrollContent autoScrollContent} is enabled. Default value is 150
     */
    public int getMinContentHeight()  {
        return getAttributeAsInt("minContentHeight");
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.chart.FacetChart#getAutoScrollContent autoScrollContent} is true, limits the
     * minimum  width of the chart-content, including data, labels, titles and legends.  If this widget is sized smaller than
     * this width, scrollbars are introduced to reach the hidden content.  See {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinContentHeight minContentHeight} to affect the minimum vertical 
     * content-size.
     *
     * @param minContentWidth New minContentWidth value. Default value is 150
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     */
    public FacetChart setMinContentWidth(int minContentWidth) {
        return (FacetChart)setAttribute("minContentWidth", minContentWidth, true);
    }

    /**
     * When {@link com.smartgwt.client.widgets.chart.FacetChart#getAutoScrollContent autoScrollContent} is true, limits the
     * minimum  width of the chart-content, including data, labels, titles and legends.  If this widget is sized smaller than
     * this width, scrollbars are introduced to reach the hidden content.  See {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinContentHeight minContentHeight} to affect the minimum vertical 
     * content-size.
     *
     * @return Returns the {@link com.smartgwt.client.widgets.chart.FacetChart#getMinContentWidth minContentWidth} for this facet chart
     * when {@link com.smartgwt.client.widgets.chart.FacetChart#getAutoScrollContent autoScrollContent} is enabled. Default value is 150
     */
    public int getMinContentWidth()  {
        return getAttributeAsInt("minContentWidth");
    }
    

    /**
     * The minimum allowed data point size when controlled by {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getPointSizeMetric pointSizeMetric}.
     *
     * @param minDataPointSize New minDataPointSize value. Default value is 3
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setMinDataPointSize(double minDataPointSize)  throws IllegalStateException {
        return (FacetChart)setAttribute("minDataPointSize", minDataPointSize, false);
    }

    /**
     * The minimum allowed data point size when controlled by {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getPointSizeMetric pointSizeMetric}.
     *
     * @return Current minDataPointSize value. Default value is 3
     */
    public double getMinDataPointSize()  {
        return getAttributeAsDouble("minDataPointSize");
    }
    

    /**
     * If all data values would be spread across less than {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinDataSpreadPercent minDataSpreadPercent} of the axis, the start values
     * of axes will be automatically adjusted to make better use of space. <p> For example, if a column chart has all data
     * values between 500,000 and 500,100, if the axis starts at 0, differences in column heights will be visually
     * indistinguishable. In this case, since all data values appear in well under 30% of the axis length, the default
     * <code>minDataSpreadPercent</code> setting would cause the axis to start at a value that would make the column heights
     * obviously different (for example, starting the axis as 500,000). <p> Setting an explicit {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getAxisStartValue axisStartValue} or {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getAxisEndValue axisEndValue}, disables this behavior, as does setting
     * <code>minDataSpreadPercent</code> to 0. <p> For multi-axis charts, use {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#getMinDataSpreadPercent MetricSettings.minDataSpreadPercent} for
     * per-axis settings. <p> For Bubble and Scatter charts, <code>minDataSpreadPercent</code> affects only the y-axis of the
     * chart.  The property {@link com.smartgwt.client.widgets.chart.FacetChart#getMinXDataSpreadPercent minXDataSpreadPercent}
     * must be used to enable the corresponding feature for the x-axis.
     *
     * @param minDataSpreadPercent New minDataSpreadPercent value. Default value is 30
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setMinDataSpreadPercent(int minDataSpreadPercent)  throws IllegalStateException {
        return (FacetChart)setAttribute("minDataSpreadPercent", minDataSpreadPercent, false);
    }

    /**
     * If all data values would be spread across less than {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinDataSpreadPercent minDataSpreadPercent} of the axis, the start values
     * of axes will be automatically adjusted to make better use of space. <p> For example, if a column chart has all data
     * values between 500,000 and 500,100, if the axis starts at 0, differences in column heights will be visually
     * indistinguishable. In this case, since all data values appear in well under 30% of the axis length, the default
     * <code>minDataSpreadPercent</code> setting would cause the axis to start at a value that would make the column heights
     * obviously different (for example, starting the axis as 500,000). <p> Setting an explicit {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getAxisStartValue axisStartValue} or {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getAxisEndValue axisEndValue}, disables this behavior, as does setting
     * <code>minDataSpreadPercent</code> to 0. <p> For multi-axis charts, use {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#getMinDataSpreadPercent MetricSettings.minDataSpreadPercent} for
     * per-axis settings. <p> For Bubble and Scatter charts, <code>minDataSpreadPercent</code> affects only the y-axis of the
     * chart.  The property {@link com.smartgwt.client.widgets.chart.FacetChart#getMinXDataSpreadPercent minXDataSpreadPercent}
     * must be used to enable the corresponding feature for the x-axis.
     *
     * @return Current minDataSpreadPercent value. Default value is 30
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
     * @param minLabelGap New minLabelGap value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setMinLabelGap(Integer minLabelGap)  throws IllegalStateException {
        return (FacetChart)setAttribute("minLabelGap", minLabelGap, false);
    }

    /**
     * Minimum gap between labels on the X axis before some labels are omitted or larger time granularity is shown (eg show
     * days instead of hours) based on the {@link com.smartgwt.client.widgets.chart.FacetChart#getLabelCollapseMode
     * labelCollapseMode}. <P> Default is based on label orientation.  If labels are vertical, the minimum gap is the height of
     * half a line of text.  If horizontal it's the width of 4 "X" letters.
     *
     * @return Current minLabelGap value. Default value is null
     */
    public Integer getMinLabelGap()  {
        return getAttributeAsInt("minLabelGap");
    }
    

    /**
     * Length of minor ticks marks shown along axis, if {@link com.smartgwt.client.widgets.chart.FacetChart#getShowMinorTicks
     * minor tick marks} are enabled.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.chart.FacetChart#getMinorTickLength minorTickLength}.
     *
     * @param minorTickLength new {@link com.smartgwt.client.widgets.chart.FacetChart#getMinorTickLength minorTickLength} value. Default value is 2
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.chart.FacetChart#setTickLength
     */
    public FacetChart setMinorTickLength(int minorTickLength) {
        return (FacetChart)setAttribute("minorTickLength", minorTickLength, true);
    }

    /**
     * Length of minor ticks marks shown along axis, if {@link com.smartgwt.client.widgets.chart.FacetChart#getShowMinorTicks
     * minor tick marks} are enabled.
     *
     * @return Current minorTickLength value. Default value is 2
     * @see com.smartgwt.client.widgets.chart.FacetChart#getTickLength
     */
    public int getMinorTickLength()  {
        return getAttributeAsInt("minorTickLength");
    }
    

    /**
     * For scatter charts only, if all data points would be spread across less than {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinXDataSpreadPercent minXDataSpreadPercent} of the x-axis, the start
     * value of x-axis will be automatically adjusted to make better use of space. <p> Setting an explicit {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getXAxisStartValue xAxisStartValue} disables this behavior, as does setting
     * <code>minXDataSpreadPercent</code> to 0.
     *
     * @param minXDataSpreadPercent New minXDataSpreadPercent value. Default value is 30
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.chart.FacetChart#setMinDataSpreadPercent
     */
    public FacetChart setMinXDataSpreadPercent(int minXDataSpreadPercent)  throws IllegalStateException {
        return (FacetChart)setAttribute("minXDataSpreadPercent", minXDataSpreadPercent, false);
    }

    /**
     * For scatter charts only, if all data points would be spread across less than {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinXDataSpreadPercent minXDataSpreadPercent} of the x-axis, the start
     * value of x-axis will be automatically adjusted to make better use of space. <p> Setting an explicit {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getXAxisStartValue xAxisStartValue} disables this behavior, as does setting
     * <code>minXDataSpreadPercent</code> to 0.
     *
     * @return Current minXDataSpreadPercent value. Default value is 30
     * @see com.smartgwt.client.widgets.chart.FacetChart#getMinDataSpreadPercent
     */
    public int getMinXDataSpreadPercent()  {
        return getAttributeAsInt("minXDataSpreadPercent");
    }
    

    /**
     * Like {@link com.smartgwt.client.widgets.chart.FacetChart#getGradationGaps gradationGaps}, except allows control of
     * gradations for the X (horizontal) axis, for Scatter charts only. <P> See also {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getOtherAxisGradationTimes otherAxisGradationTimes} for control of
     * gradations when the X axis is time-valued. <P> Defaults to the value of {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getPixelsPerGradation pixelsPerGradation} if unset.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.chart.FacetChart#getOtherAxisGradationGaps otherAxisGradationGaps}.
     *
     * @param otherAxisGradationGaps new {@link com.smartgwt.client.widgets.chart.FacetChart#getOtherAxisGradationGaps otherAxisGradationGaps} value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     */
    public FacetChart setOtherAxisGradationGaps(float... otherAxisGradationGaps) {
        return (FacetChart)setAttribute("otherAxisGradationGaps", otherAxisGradationGaps, true);
    }

    /**
     * Like {@link com.smartgwt.client.widgets.chart.FacetChart#getGradationGaps gradationGaps}, except allows control of
     * gradations for the X (horizontal) axis, for Scatter charts only. <P> See also {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getOtherAxisGradationTimes otherAxisGradationTimes} for control of
     * gradations when the X axis is time-valued. <P> Defaults to the value of {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getPixelsPerGradation pixelsPerGradation} if unset.
     *
     * @return Current otherAxisGradationGaps value. Default value is null
     */
    public float[] getOtherAxisGradationGaps()  {
        return com.smartgwt.client.util.ConvertTo.arrayOffloat(getAttributeAsJavaScriptObject("otherAxisGradationGaps"));
    }
    

    /**
     * For charts that have a date/time-valued X-axis, gradations can instead be specified as
     *  Strings, consisting of a number and trailing letter code, where the letter code indicates
     *  the unit of time.  Valid time units are "ms" (millisecond), "s" (second), "mn" (minute),
     *  "h" (hour), "d" (day), "w" (week), "m" (month), "q" (quarter, 3-months), "y" (year).
     *  <P>
     *  When time units are used, there is no way to scale the same unit to a much larger or
     *  smaller range of time (as there is with numeric gradations).  For example, a setting of
     *  "30mn" meaning "30 minutes" does not mean that 30 hours is a natural choice for chart
     *  with a longer timeline (days should obviously be chosen instead).  Therefore, when
     *  specifying time gradations, candidate gradations must be provided for the entire possible
     *  displayed range.  If insufficient gradations are specified, this can result in unreadable
     *  charts; for example, if the largest available gradation is "15mn" and the chart is
     *  showing a full week's data in around 500px, there will be more than one gradation per
     *  pixel, and labels will be drawn on top of each other.
     *  <P>
     *  To prevent this, be sure to specify enough gradations to cover the all time ranges your
     *  chart may need to display.  However, if gradations are not specified for granularities
     *  under 1 second or over 1 year, further gradations will be chosen based on using
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getOtherAxisGradationGaps otherAxisGradationGaps} to choose
     * fractions of seconds or multiples of years.
     *  <P>
     *  The default setting is effectively:
     *  <pre>
     *  ["1s", "15s", "30s", "1mn", "5mn", "15mn", "30mn", "1h", "1d", "1w", "1m", "1q", "1y"]
     *  </pre>
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.chart.FacetChart#getOtherAxisGradationTimes otherAxisGradationTimes}.
     *
     * @param otherAxisGradationTimes new {@link com.smartgwt.client.widgets.chart.FacetChart#getOtherAxisGradationTimes otherAxisGradationTimes} value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#customTicksChart" target="examples">Custom Date Ticks Example</a>
     */
    public FacetChart setOtherAxisGradationTimes(String... otherAxisGradationTimes) {
        return (FacetChart)setAttribute("otherAxisGradationTimes", otherAxisGradationTimes, true);
    }

    /**
     * For charts that have a date/time-valued X-axis, gradations can instead be specified as
     *  Strings, consisting of a number and trailing letter code, where the letter code indicates
     *  the unit of time.  Valid time units are "ms" (millisecond), "s" (second), "mn" (minute),
     *  "h" (hour), "d" (day), "w" (week), "m" (month), "q" (quarter, 3-months), "y" (year).
     *  <P>
     *  When time units are used, there is no way to scale the same unit to a much larger or
     *  smaller range of time (as there is with numeric gradations).  For example, a setting of
     *  "30mn" meaning "30 minutes" does not mean that 30 hours is a natural choice for chart
     *  with a longer timeline (days should obviously be chosen instead).  Therefore, when
     *  specifying time gradations, candidate gradations must be provided for the entire possible
     *  displayed range.  If insufficient gradations are specified, this can result in unreadable
     *  charts; for example, if the largest available gradation is "15mn" and the chart is
     *  showing a full week's data in around 500px, there will be more than one gradation per
     *  pixel, and labels will be drawn on top of each other.
     *  <P>
     *  To prevent this, be sure to specify enough gradations to cover the all time ranges your
     *  chart may need to display.  However, if gradations are not specified for granularities
     *  under 1 second or over 1 year, further gradations will be chosen based on using
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getOtherAxisGradationGaps otherAxisGradationGaps} to choose
     * fractions of seconds or multiples of years.
     *  <P>
     *  The default setting is effectively:
     *  <pre>
     *  ["1s", "15s", "30s", "1mn", "5mn", "15mn", "30mn", "1h", "1d", "1w", "1m", "1q", "1y"]
     *  </pre>
     *
     * @return Current otherAxisGradationTimes value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#customTicksChart" target="examples">Custom Date Ticks Example</a>
     */
    public String[] getOtherAxisGradationTimes()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("otherAxisGradationTimes"));
    }
    

    /**
     * Ideal number of pixels to leave between each gradation on the x (horizontal axis), for Scatter plots only. <p> Defaults
     * to the value of {@link com.smartgwt.client.widgets.chart.FacetChart#getPixelsPerGradation pixelsPerGradation} if unset.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.chart.FacetChart#getOtherAxisPixelsPerGradation otherAxisPixelsPerGradation}.
     *
     * @param otherAxisPixelsPerGradation new {@link com.smartgwt.client.widgets.chart.FacetChart#getOtherAxisPixelsPerGradation otherAxisPixelsPerGradation}
     * value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.chart.FacetChart#setPixelsPerGradation
     */
    public FacetChart setOtherAxisPixelsPerGradation(Integer otherAxisPixelsPerGradation) {
        return (FacetChart)setAttribute("otherAxisPixelsPerGradation", otherAxisPixelsPerGradation, true);
    }

    /**
     * Ideal number of pixels to leave between each gradation on the x (horizontal axis), for Scatter plots only. <p> Defaults
     * to the value of {@link com.smartgwt.client.widgets.chart.FacetChart#getPixelsPerGradation pixelsPerGradation} if unset.
     *
     * @return Current otherAxisPixelsPerGradation value. Default value is null
     * @see com.smartgwt.client.widgets.chart.FacetChart#getPixelsPerGradation
     */
    public Integer getOtherAxisPixelsPerGradation()  {
        return getAttributeAsInt("otherAxisPixelsPerGradation");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.chart.FacetChart#getShowChartRect showChartRect} is enabled and if {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getChartRectProperties chartRectProperties} specifies a nonzero {@link
     * com.smartgwt.client.widgets.drawing.DrawRect#getRounding rounding}, whether the padding around the inside of the chart
     * rect. should include at least the radius of the rounded corner.
     *
     * @param padChartRectByCornerRadius New padChartRectByCornerRadius value. Default value is true
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setPadChartRectByCornerRadius(boolean padChartRectByCornerRadius)  throws IllegalStateException {
        return (FacetChart)setAttribute("padChartRectByCornerRadius", padChartRectByCornerRadius, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.chart.FacetChart#getShowChartRect showChartRect} is enabled and if {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getChartRectProperties chartRectProperties} specifies a nonzero {@link
     * com.smartgwt.client.widgets.drawing.DrawRect#getRounding rounding}, whether the padding around the inside of the chart
     * rect. should include at least the radius of the rounded corner.
     *
     * @return Current padChartRectByCornerRadius value. Default value is true
     */
    public boolean getPadChartRectByCornerRadius()  {
        Boolean result = getAttributeAsBoolean("padChartRectByCornerRadius");
        return result == null ? true : result;
    }
    

    /**
     * Properties for the border around a pie chart.
     *
     * @param pieBorderProperties New pieBorderProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public FacetChart setPieBorderProperties(DrawOval pieBorderProperties)  throws IllegalStateException {
        if (pieBorderProperties != null) {
            if (pieBorderProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setPieBorderProperties", "DrawOval");
            }                                                                       
            pieBorderProperties.setConfigOnly(true);
        }
        JavaScriptObject config = pieBorderProperties == null ? null : pieBorderProperties.getConfig();
        return (FacetChart)setAttribute("pieBorderProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for the border around a pie chart.
     *
     * @return Current pieBorderProperties value. Default value is null
     */
    public DrawOval getPieBorderProperties()  {
        DrawOval properties = new DrawOval();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("pieBorderProperties"));
        return properties;
    }
    

    /**
     * Angle where first label is placed in a Pie chart in stacked mode, in degrees.
     *
     * @param pieLabelAngleStart New pieLabelAngleStart value. Default value is 20
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setPieLabelAngleStart(int pieLabelAngleStart)  throws IllegalStateException {
        return (FacetChart)setAttribute("pieLabelAngleStart", pieLabelAngleStart, false);
    }

    /**
     * Angle where first label is placed in a Pie chart in stacked mode, in degrees.
     *
     * @return Current pieLabelAngleStart value. Default value is 20
     */
    public int getPieLabelAngleStart()  {
        return getAttributeAsInt("pieLabelAngleStart");
    }
    

    /**
     * How far label lines stick out of the pie radius in a Pie chart in stacked mode.
     *
     * @param pieLabelLineExtent New pieLabelLineExtent value. Default value is 7
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setPieLabelLineExtent(int pieLabelLineExtent)  throws IllegalStateException {
        return (FacetChart)setAttribute("pieLabelLineExtent", pieLabelLineExtent, false);
    }

    /**
     * How far label lines stick out of the pie radius in a Pie chart in stacked mode.
     *
     * @return Current pieLabelLineExtent value. Default value is 7
     */
    public int getPieLabelLineExtent()  {
        return getAttributeAsInt("pieLabelLineExtent");
    }
    

    /**
     * Properties for pie label line
     *
     * @param pieLabelLineProperties New pieLabelLineProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public FacetChart setPieLabelLineProperties(DrawLine pieLabelLineProperties) {
        if (pieLabelLineProperties != null) {
            if (pieLabelLineProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setPieLabelLineProperties", "DrawLine");
            }                                                                       
            pieLabelLineProperties.setConfigOnly(true);
        }
        JavaScriptObject config = pieLabelLineProperties == null ? null : pieLabelLineProperties.getConfig();
        return (FacetChart)setAttribute("pieLabelLineProperties", JSOHelper.cleanProperties(config, true), true);
    }

    /**
     * Properties for pie label line
     *
     * @return Current pieLabelLineProperties value. Default value is null
     */
    public DrawLine getPieLabelLineProperties()  {
        DrawLine properties = new DrawLine();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("pieLabelLineProperties"));
        return properties;
    }
    

    /**
     * Properties for pie ring border
     *
     * @param pieRingBorderProperties New pieRingBorderProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public FacetChart setPieRingBorderProperties(DrawOval pieRingBorderProperties)  throws IllegalStateException {
        if (pieRingBorderProperties != null) {
            if (pieRingBorderProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setPieRingBorderProperties", "DrawOval");
            }                                                                       
            pieRingBorderProperties.setConfigOnly(true);
        }
        JavaScriptObject config = pieRingBorderProperties == null ? null : pieRingBorderProperties.getConfig();
        return (FacetChart)setAttribute("pieRingBorderProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for pie ring border
     *
     * @return Current pieRingBorderProperties value. Default value is null
     */
    public DrawOval getPieRingBorderProperties()  {
        DrawOval properties = new DrawOval();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("pieRingBorderProperties"));
        return properties;
    }
    

    /**
     * Properties for pie slices
     *
     * @param pieSliceProperties New pieSliceProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public FacetChart setPieSliceProperties(DrawSector pieSliceProperties)  throws IllegalStateException {
        if (pieSliceProperties != null) {
            if (pieSliceProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setPieSliceProperties", "DrawSector");
            }                                                                       
            pieSliceProperties.setConfigOnly(true);
        }
        JavaScriptObject config = pieSliceProperties == null ? null : pieSliceProperties.getConfig();
        return (FacetChart)setAttribute("pieSliceProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for pie slices
     *
     * @return Current pieSliceProperties value. Default value is null
     */
    public DrawSector getPieSliceProperties()  {
        DrawSector properties = new DrawSector();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("pieSliceProperties"));
        return properties;
    }
    

    /**
     * Default angle in degrees where pie charts start drawing sectors to represent data values. Default of 0 places the first
     * value starting from the "east" position.   Use 270 or -90 for north.
     *
     * @param pieStartAngle New pieStartAngle value. Default value is 0
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setPieStartAngle(Integer pieStartAngle)  throws IllegalStateException {
        return (FacetChart)setAttribute("pieStartAngle", pieStartAngle, false);
    }

    /**
     * Default angle in degrees where pie charts start drawing sectors to represent data values. Default of 0 places the first
     * value starting from the "east" position.   Use 270 or -90 for north.
     *
     * @return Current pieStartAngle value. Default value is 0
     */
    public Integer getPieStartAngle()  {
        return getAttributeAsInt("pieStartAngle");
    }
    

    /**
     * Ideal number of pixels to leave between each gradation on the primary axis, which is typically the y (vertical) axis
     * except for Bar charts. <P> The chart will detect the range of values being displayed and available pixels on the
     * vertical axis, and generate gradations that are spaced <i>approximately</i> <code>pixelsPerGradations</code> apart. 
     * Note that the Framework will attempt to approach the specified target gap from above - the chart will never be drawn
     * with gradations spaced closer than <code>pixelsPerGradation</code>.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.chart.FacetChart#getPixelsPerGradation pixelsPerGradation}.
     *
     * @param pixelsPerGradation new {@link com.smartgwt.client.widgets.chart.FacetChart#getPixelsPerGradation pixelsPerGradation} value. Default value is 28
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.chart.FacetChart#setOtherAxisPixelsPerGradation
     */
    public FacetChart setPixelsPerGradation(int pixelsPerGradation) {
        return (FacetChart)setAttribute("pixelsPerGradation", pixelsPerGradation, true);
    }

    /**
     * Ideal number of pixels to leave between each gradation on the primary axis, which is typically the y (vertical) axis
     * except for Bar charts. <P> The chart will detect the range of values being displayed and available pixels on the
     * vertical axis, and generate gradations that are spaced <i>approximately</i> <code>pixelsPerGradations</code> apart. 
     * Note that the Framework will attempt to approach the specified target gap from above - the chart will never be drawn
     * with gradations spaced closer than <code>pixelsPerGradation</code>.
     *
     * @return Current pixelsPerGradation value. Default value is 28
     * @see com.smartgwt.client.widgets.chart.FacetChart#getOtherAxisPixelsPerGradation
     */
    public int getPixelsPerGradation()  {
        return getAttributeAsInt("pixelsPerGradation");
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.chart.FacetChart#getLogScalePointColor logScalePointColor} is <code>true</code>,
     * this property specifies the base value for logarithmic {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getColorScaleMetric color scale metric} values.
     *
     * @param pointColorLogBase New pointColorLogBase value. Default value is 10
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setPointColorLogBase(Integer pointColorLogBase)  throws IllegalStateException {
        return (FacetChart)setAttribute("pointColorLogBase", pointColorLogBase, false);
    }

    /**
     * When {@link com.smartgwt.client.widgets.chart.FacetChart#getLogScalePointColor logScalePointColor} is <code>true</code>,
     * this property specifies the base value for logarithmic {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getColorScaleMetric color scale metric} values.
     *
     * @return Current pointColorLogBase value. Default value is 10
     */
    public Integer getPointColorLogBase()  {
        return getAttributeAsInt("pointColorLogBase");
    }
    

    /**
     * For charts where {@link com.smartgwt.client.widgets.chart.FacetChart#getShowDataPoints showDataPoints} is enabled, this
     * property specifies an array of geometric shapes to draw for the data points of each series.
     *
     * @param pointShapes New pointShapes value. Default value is ["Oval", "Square", "Diamond", "Triangle"]
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setPointShapes(PointShape... pointShapes)  throws IllegalStateException {
        return (FacetChart)setAttribute("pointShapes", pointShapes, false);
    }

    /**
     * For charts where {@link com.smartgwt.client.widgets.chart.FacetChart#getShowDataPoints showDataPoints} is enabled, this
     * property specifies an array of geometric shapes to draw for the data points of each series.
     *
     * @return Current pointShapes value. Default value is ["Oval", "Square", "Diamond", "Triangle"]
     */
    public PointShape[] getPointShapes()  {
        final String[] strings = getAttributeAsStringArray("pointShapes");
        return EnumUtil.getEnums(PointShape.values(), strings, strings == null ? null : new PointShape[strings.length]);
    }
    

    /**
     * When a {@link com.smartgwt.client.widgets.chart.FacetChart#getShowPointSizeLegend point size legend} is shown, this
     * property controls the number of gradations of the {@link com.smartgwt.client.widgets.chart.FacetChart#getPointSizeMetric
     * pointSizeMetric} that the chart tries to display. <p> Note that if {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getUsePointSizeLogGradations usePointSizeLogGradations} is set then the
     * number of gradations is not given by this property but rather by the entries of {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getPointSizeLogGradations pointSizeLogGradations}.
     *
     * @param pointSizeGradations New pointSizeGradations value. Default value is 5
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setPointSizeGradations(Integer pointSizeGradations)  throws IllegalStateException {
        return (FacetChart)setAttribute("pointSizeGradations", pointSizeGradations, false);
    }

    /**
     * When a {@link com.smartgwt.client.widgets.chart.FacetChart#getShowPointSizeLegend point size legend} is shown, this
     * property controls the number of gradations of the {@link com.smartgwt.client.widgets.chart.FacetChart#getPointSizeMetric
     * pointSizeMetric} that the chart tries to display. <p> Note that if {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getUsePointSizeLogGradations usePointSizeLogGradations} is set then the
     * number of gradations is not given by this property but rather by the entries of {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getPointSizeLogGradations pointSizeLogGradations}.
     *
     * @return Current pointSizeGradations value. Default value is 5
     */
    public Integer getPointSizeGradations()  {
        return getAttributeAsInt("pointSizeGradations");
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.chart.FacetChart#getLogScalePointSize logScalePointSize} is true, base value for
     * logarithmic point size metric values.
     *
     * @param pointSizeLogBase New pointSizeLogBase value. Default value is 10
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setPointSizeLogBase(Integer pointSizeLogBase)  throws IllegalStateException {
        return (FacetChart)setAttribute("pointSizeLogBase", pointSizeLogBase, false);
    }

    /**
     * When {@link com.smartgwt.client.widgets.chart.FacetChart#getLogScalePointSize logScalePointSize} is true, base value for
     * logarithmic point size metric values.
     *
     * @return Current pointSizeLogBase value. Default value is 10
     */
    public Integer getPointSizeLogBase()  {
        return getAttributeAsInt("pointSizeLogBase");
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.chart.FacetChart#getUsePointSizeLogGradations usePointSizeLogGradations} is set,
     * this property specifies the {@link com.smartgwt.client.widgets.chart.FacetChart#getPointSizeMetric pointSizeMetric}
     * value gradations to show in the {@link com.smartgwt.client.widgets.chart.FacetChart#getShowPointSizeLegend point size
     * legend} in between powers, expressed as a series of integer or float values between 1 and {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getPointSizeLogBase pointSizeLogBase}.
     *
     * @param pointSizeLogGradations New pointSizeLogGradations value. Default value is [1, 5]
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.chart.FacetChart#setLogGradations
     */
    public FacetChart setPointSizeLogGradations(float... pointSizeLogGradations)  throws IllegalStateException {
        return (FacetChart)setAttribute("pointSizeLogGradations", pointSizeLogGradations, false);
    }

    /**
     * When {@link com.smartgwt.client.widgets.chart.FacetChart#getUsePointSizeLogGradations usePointSizeLogGradations} is set,
     * this property specifies the {@link com.smartgwt.client.widgets.chart.FacetChart#getPointSizeMetric pointSizeMetric}
     * value gradations to show in the {@link com.smartgwt.client.widgets.chart.FacetChart#getShowPointSizeLegend point size
     * legend} in between powers, expressed as a series of integer or float values between 1 and {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getPointSizeLogBase pointSizeLogBase}.
     *
     * @return Current pointSizeLogGradations value. Default value is [1, 5]
     * @see com.smartgwt.client.widgets.chart.FacetChart#getLogGradations
     */
    public float[] getPointSizeLogGradations()  {
        return com.smartgwt.client.util.ConvertTo.arrayOffloat(getAttributeAsJavaScriptObject("pointSizeLogGradations"));
    }
    

    /**
     * For charts where {@link com.smartgwt.client.widgets.chart.FacetChart#getShowDataPoints showDataPoints} is enabled, this
     * property specifies an additional metric (i.e. an "id" of a metric facet value) that determines the size of the data
     * points drawn.  For example, when a circle is drawn to represent a data point then the size of the data point is the
     * diameter of the circle, in pixels. <p> The size is calculated by linearly scaling the value of the
     * <code>pointSizeMetric</code> of the point between the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinDataPointSize minDataPointSize} and {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMaxDataPointSize maxDataPointSize}.  The data point that has the lowest
     * value for the <code>pointSizeMetric</code> will be drawn as a shape <code>minDataPointSize</code> pixels in size, and
     * the data point that has the highest value for the <code>pointSizeMetric</code> will be drawn as a shape
     * <code>maxDataPointSize</code> pixels in size. <p> Using a log-scale to calulate the size of the data points is achieved
     * by enabling {@link com.smartgwt.client.widgets.chart.FacetChart#getLogScalePointSize logScalePointSize}. <p> If the
     * {@link com.smartgwt.client.types.ChartType} is <code>"Bubble"</code> then the default <code>pointSizeMetric</code> is
     * <code>"pointSize"</code>. <p> Note that setting <code>pointSizeMetric</code> to non-<code>null</code> implicitly enables
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getShowDataPoints showDataPoints}.
     *
     * @param pointSizeMetric New pointSizeMetric value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#bubbleChart" target="examples">Bubble Chart Example</a>
     */
    public FacetChart setPointSizeMetric(String pointSizeMetric)  throws IllegalStateException {
        return (FacetChart)setAttribute("pointSizeMetric", pointSizeMetric, false);
    }

    /**
     * For charts where {@link com.smartgwt.client.widgets.chart.FacetChart#getShowDataPoints showDataPoints} is enabled, this
     * property specifies an additional metric (i.e. an "id" of a metric facet value) that determines the size of the data
     * points drawn.  For example, when a circle is drawn to represent a data point then the size of the data point is the
     * diameter of the circle, in pixels. <p> The size is calculated by linearly scaling the value of the
     * <code>pointSizeMetric</code> of the point between the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinDataPointSize minDataPointSize} and {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMaxDataPointSize maxDataPointSize}.  The data point that has the lowest
     * value for the <code>pointSizeMetric</code> will be drawn as a shape <code>minDataPointSize</code> pixels in size, and
     * the data point that has the highest value for the <code>pointSizeMetric</code> will be drawn as a shape
     * <code>maxDataPointSize</code> pixels in size. <p> Using a log-scale to calulate the size of the data points is achieved
     * by enabling {@link com.smartgwt.client.widgets.chart.FacetChart#getLogScalePointSize logScalePointSize}. <p> If the
     * {@link com.smartgwt.client.types.ChartType} is <code>"Bubble"</code> then the default <code>pointSizeMetric</code> is
     * <code>"pointSize"</code>. <p> Note that setting <code>pointSizeMetric</code> to non-<code>null</code> implicitly enables
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getShowDataPoints showDataPoints}.
     *
     * @return Current pointSizeMetric value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#bubbleChart" target="examples">Bubble Chart Example</a>
     */
    public String getPointSizeMetric()  {
        return getAttributeAsString("pointSizeMetric");
    }
    

    /**
     * Should the {@link com.smartgwt.client.widgets.chart.FacetChart#getCanZoom zoom chart} be printed with this
     * <code>FacetChart</code>? If <code>true</code>, then the SVG string returned by {@link
     * com.smartgwt.client.widgets.drawing.DrawPane#getSvgString DrawPane.getSvgString()} will include the zoom chart's SVG as
     * well.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param printZoomChart New printZoomChart value. Default value is true
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public FacetChart setPrintZoomChart(boolean printZoomChart) {
        return (FacetChart)setAttribute("printZoomChart", printZoomChart, true);
    }

    /**
     * Should the {@link com.smartgwt.client.widgets.chart.FacetChart#getCanZoom zoom chart} be printed with this
     * <code>FacetChart</code>? If <code>true</code>, then the SVG string returned by {@link
     * com.smartgwt.client.widgets.drawing.DrawPane#getSvgString DrawPane.getSvgString()} will include the zoom chart's SVG as
     * well.
     *
     * @return Current printZoomChart value. Default value is true
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public boolean getPrintZoomChart()  {
        Boolean result = getAttributeAsBoolean("printZoomChart");
        return result == null ? true : result;
    }
    

    /**
     * The "id" of the metric facet value that assigns a probability to each combination of facets and their values.  Each
     * probability must be a non-negative number. These probabilities are used by all methods of FacetChart that calculate
     * statistical values (e.g. {@link com.smartgwt.client.widgets.chart.FacetChart#getMean getMean()} and {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getStdDev getStdDev()}).  The default value of this property is null which
     * causes the FacetChart to assign probabilities to the data records according to a uniform probability distribution. <p>
     * Note that the FacetChart handles cases where the sum total of all probabilities in the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getData data} is not exactly one by scaling the assigned probabilities.
     *
     * @param probabilityMetric New probabilityMetric value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.chart.FacetChart#getMean
     * @see com.smartgwt.client.widgets.chart.FacetChart#getMedian
     * @see com.smartgwt.client.widgets.chart.FacetChart#getStdDev
     * @see com.smartgwt.client.widgets.chart.FacetChart#getVariance
     */
    public FacetChart setProbabilityMetric(String probabilityMetric)  throws IllegalStateException {
        return (FacetChart)setAttribute("probabilityMetric", probabilityMetric, false);
    }

    /**
     * The "id" of the metric facet value that assigns a probability to each combination of facets and their values.  Each
     * probability must be a non-negative number. These probabilities are used by all methods of FacetChart that calculate
     * statistical values (e.g. {@link com.smartgwt.client.widgets.chart.FacetChart#getMean getMean()} and {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getStdDev getStdDev()}).  The default value of this property is null which
     * causes the FacetChart to assign probabilities to the data records according to a uniform probability distribution. <p>
     * Note that the FacetChart handles cases where the sum total of all probabilities in the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getData data} is not exactly one by scaling the assigned probabilities.
     *
     * @return Current probabilityMetric value. Default value is null
     * @see com.smartgwt.client.widgets.chart.FacetChart#getMean
     * @see com.smartgwt.client.widgets.chart.FacetChart#getMedian
     * @see com.smartgwt.client.widgets.chart.FacetChart#getStdDev
     * @see com.smartgwt.client.widgets.chart.FacetChart#getVariance
     */
    public String getProbabilityMetric()  {
        return getAttributeAsString("probabilityMetric");
    }
    

    /**
     * For multi-facet charts, render data values as a proportion of the sum of all data values that have the same label. <p>
     * Gradation labels will be switched to show percentage instead of absolute values. <p> This setting is valid only for
     * Column, Bar, Area and Radar chart types and only in {@link com.smartgwt.client.widgets.chart.FacetChart#getStacked
     * stacked} mode.  Stacked columns will be as tall as the chart rect and stacked bars will be as wide as the chart rect. 
     * Area and Radar charts will be completely filled except for facet values where all values are 0.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.chart.FacetChart#getProportional proportional}.
     *
     * @param proportional Whether the chart should now use proportional mode. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#multiSeriesChart" target="examples">Multi-Series Chart Example</a>
     */
    public FacetChart setProportional(Boolean proportional) {
        return (FacetChart)setAttribute("proportional", proportional, true);
    }

    /**
     * For multi-facet charts, render data values as a proportion of the sum of all data values that have the same label. <p>
     * Gradation labels will be switched to show percentage instead of absolute values. <p> This setting is valid only for
     * Column, Bar, Area and Radar chart types and only in {@link com.smartgwt.client.widgets.chart.FacetChart#getStacked
     * stacked} mode.  Stacked columns will be as tall as the chart rect and stacked bars will be as wide as the chart rect. 
     * Area and Radar charts will be completely filled except for facet values where all values are 0.
     *
     * @return Current proportional value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#multiSeriesChart" target="examples">Multi-Series Chart Example</a>
     */
    public Boolean getProportional()  {
        return getAttributeAsBoolean("proportional");
    }
    

    /**
     * Default title for the value axis label when the chart is in {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getProportional proportional rendering mode}.  This title will be used
     * unless the {@link com.smartgwt.client.widgets.chart.FacetChart#getLegendFacet legend facet} defines a {@link
     * com.smartgwt.client.widgets.cube.Facet#getProportionalTitle proportionalTitle}.
     *
     * @param proportionalAxisLabel New proportionalAxisLabel value. Default value is "Percent"
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setProportionalAxisLabel(String proportionalAxisLabel)  throws IllegalStateException {
        return (FacetChart)setAttribute("proportionalAxisLabel", proportionalAxisLabel, false);
    }

    /**
     * Default title for the value axis label when the chart is in {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getProportional proportional rendering mode}.  This title will be used
     * unless the {@link com.smartgwt.client.widgets.chart.FacetChart#getLegendFacet legend facet} defines a {@link
     * com.smartgwt.client.widgets.cube.Facet#getProportionalTitle proportionalTitle}.
     *
     * @return Current proportionalAxisLabel value. Default value is "Percent"
     */
    public String getProportionalAxisLabel()  {
        return getAttributeAsString("proportionalAxisLabel");
    }
    

    /**
     * Properties for radar background
     *
     * @param radarBackgroundProperties New radarBackgroundProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public FacetChart setRadarBackgroundProperties(DrawOval radarBackgroundProperties)  throws IllegalStateException {
        if (radarBackgroundProperties != null) {
            if (radarBackgroundProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setRadarBackgroundProperties", "DrawOval");
            }                                                                       
            radarBackgroundProperties.setConfigOnly(true);
        }
        JavaScriptObject config = radarBackgroundProperties == null ? null : radarBackgroundProperties.getConfig();
        return (FacetChart)setAttribute("radarBackgroundProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for radar background
     *
     * @return Current radarBackgroundProperties value. Default value is null
     */
    public DrawOval getRadarBackgroundProperties()  {
        DrawOval properties = new DrawOval();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("radarBackgroundProperties"));
        return properties;
    }
    

    /**
     * This property controls whether to rotate the labels on the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getDataLabelFacet data label facet} of radar or {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getStacked stacked} pie charts so that each label is parallel to its radial
     * gradation (these are the labels that appear around the perimeter).  For now, "auto" means the same thing as "always" -
     * but this may change in the future if heuristics are added to determine when the affected labels are likely to overlap
     * and not be legible.  If rotateLabels is "never" then the labels will not be rotated. <P>
     *
     * @param radarRotateLabels New radarRotateLabels value. Default value is "auto"
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.chart.FacetChart#setRotateLabels
     * @see com.smartgwt.client.widgets.chart.FacetChart#setRadialLabelOffset
     */
    public FacetChart setRadarRotateLabels(LabelRotationMode radarRotateLabels)  throws IllegalStateException {
        return (FacetChart)setAttribute("radarRotateLabels", radarRotateLabels == null ? null : radarRotateLabels.getValue(), false);
    }

    /**
     * This property controls whether to rotate the labels on the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getDataLabelFacet data label facet} of radar or {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getStacked stacked} pie charts so that each label is parallel to its radial
     * gradation (these are the labels that appear around the perimeter).  For now, "auto" means the same thing as "always" -
     * but this may change in the future if heuristics are added to determine when the affected labels are likely to overlap
     * and not be legible.  If rotateLabels is "never" then the labels will not be rotated. <P>
     *
     * @return Current radarRotateLabels value. Default value is "auto"
     * @see com.smartgwt.client.widgets.chart.FacetChart#getRotateLabels
     * @see com.smartgwt.client.widgets.chart.FacetChart#getRadialLabelOffset
     */
    public LabelRotationMode getRadarRotateLabels()  {
        return EnumUtil.getEnum(LabelRotationMode.values(), getAttribute("radarRotateLabels"));
    }
    

    /**
     * Distance in pixels that radial labels are offset from the outside of the circle. Default can vary depending upon {@link
     * com.smartgwt.client.types.ChartType} and {@link com.smartgwt.client.widgets.chart.FacetChart#getRadarRotateLabels
     * radarRotateLabels}.
     *
     * @param radialLabelOffset New radialLabelOffset value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setRadialLabelOffset(Integer radialLabelOffset)  throws IllegalStateException {
        return (FacetChart)setAttribute("radialLabelOffset", radialLabelOffset, false);
    }

    /**
     * Distance in pixels that radial labels are offset from the outside of the circle. Default can vary depending upon {@link
     * com.smartgwt.client.types.ChartType} and {@link com.smartgwt.client.widgets.chart.FacetChart#getRadarRotateLabels
     * radarRotateLabels}.
     *
     * @return Current radialLabelOffset value. Default value is null
     */
    public Integer getRadialLabelOffset()  {
        return getAttributeAsInt("radialLabelOffset");
    }
    

    /**
     * Properties for the {@link com.smartgwt.client.widgets.chart.FacetChart#getShowRegressionLine regression line}.
     *
     * @param regressionLineProperties New regressionLineProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public FacetChart setRegressionLineProperties(DrawLine regressionLineProperties)  throws IllegalStateException {
        if (regressionLineProperties != null) {
            if (regressionLineProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setRegressionLineProperties", "DrawLine");
            }                                                                       
            regressionLineProperties.setConfigOnly(true);
        }
        JavaScriptObject config = regressionLineProperties == null ? null : regressionLineProperties.getConfig();
        return (FacetChart)setAttribute("regressionLineProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for the {@link com.smartgwt.client.widgets.chart.FacetChart#getShowRegressionLine regression line}.
     *
     * @return Current regressionLineProperties value. Default value is null
     */
    public DrawLine getRegressionLineProperties()  {
        DrawLine properties = new DrawLine();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("regressionLineProperties"));
        return properties;
    }
    

    /**
     * Regression algorithm used for the {@link com.smartgwt.client.widgets.chart.FacetChart#getShowRegressionLine regression
     * line}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.types.RegressionLineType}.
     *
     * @param regressionLineType New value for this.regressionLineType. Default value is "line"
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     */
    public FacetChart setRegressionLineType(RegressionLineType regressionLineType) {
        return (FacetChart)setAttribute("regressionLineType", regressionLineType == null ? null : regressionLineType.getValue(), true);
    }

    /**
     * Regression algorithm used for the {@link com.smartgwt.client.widgets.chart.FacetChart#getShowRegressionLine regression
     * line}.
     *
     * @return Current regressionLineType value. Default value is "line"
     */
    public RegressionLineType getRegressionLineType()  {
        return EnumUtil.getEnum(RegressionLineType.values(), getAttribute("regressionLineType"));
    }
    

    /**
     * For scatter plots only, specify the degree of polynomial to use for any polynomial regression that is calculated.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.chart.FacetChart#getRegressionPolynomialDegree regressionPolynomialDegree}.
     *
     * @param regressionPolynomialDegree New value for this.regressionPolynomialDegree. Default value is 3
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     */
    public FacetChart setRegressionPolynomialDegree(int regressionPolynomialDegree) {
        return (FacetChart)setAttribute("regressionPolynomialDegree", regressionPolynomialDegree, true);
    }

    /**
     * For scatter plots only, specify the degree of polynomial to use for any polynomial regression that is calculated.
     *
     * @return Current regressionPolynomialDegree value. Default value is 3
     */
    public int getRegressionPolynomialDegree()  {
        return getAttributeAsInt("regressionPolynomialDegree");
    }
    

    /**
     * This property controls whether to rotate the labels shown for data-values in  {@link com.smartgwt.client.types.ChartType
     * Column-type charts}.  "auto" will rotate all data-values if any of them  are wider than their columns.  In all cases,
     * whether rotated or not, data-values are  hidden and instead shown in hovers if any of them exceed their bar's width.
     *
     * @param rotateDataValues New rotateDataValues value. Default value is "auto"
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.chart.FacetChart#setRotateLabels
     */
    public FacetChart setRotateDataValues(LabelRotationMode rotateDataValues) {
        return (FacetChart)setAttribute("rotateDataValues", rotateDataValues == null ? null : rotateDataValues.getValue(), true);
    }

    /**
     * This property controls whether to rotate the labels shown for data-values in  {@link com.smartgwt.client.types.ChartType
     * Column-type charts}.  "auto" will rotate all data-values if any of them  are wider than their columns.  In all cases,
     * whether rotated or not, data-values are  hidden and instead shown in hovers if any of them exceed their bar's width.
     *
     * @return Current rotateDataValues value. Default value is "auto"
     * @see com.smartgwt.client.widgets.chart.FacetChart#getRotateLabels
     */
    public LabelRotationMode getRotateDataValues()  {
        return EnumUtil.getEnum(LabelRotationMode.values(), getAttribute("rotateDataValues"));
    }
    

    /**
     * This property controls whether to rotate the labels on the X-axis.  If rotateLabels is "always" then all of the data
     * labels will be rotated by 90 degrees.  If rotateLabels is "auto" (the default) then the labels will only be rotated if
     * it is required in order for the labels to be legible and non-overlapping.  If rotateLabels is "never" then the labels
     * will not be rotated. <P> Note that automatic rotation is incompatible with setting  a cluster-size-minimum customizer
     * using {@link com.smartgwt.client.widgets.chart.FacetChart#setMinClusterSizeMapper 
     * FacetChart.setMinClusterSizeMapper()}, so that  {@link com.smartgwt.client.types.LabelRotationMode#AUTO} will be treated
     * as {@link com.smartgwt.client.types.LabelRotationMode#NEVER} if that method has been specified on a column, bar, or
     * histogram chart.
     *
     * @param rotateLabels New rotateLabels value. Default value is "auto"
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.chart.FacetChart#setRadarRotateLabels
     */
    public FacetChart setRotateLabels(LabelRotationMode rotateLabels)  throws IllegalStateException {
        return (FacetChart)setAttribute("rotateLabels", rotateLabels == null ? null : rotateLabels.getValue(), false);
    }

    /**
     * This property controls whether to rotate the labels on the X-axis.  If rotateLabels is "always" then all of the data
     * labels will be rotated by 90 degrees.  If rotateLabels is "auto" (the default) then the labels will only be rotated if
     * it is required in order for the labels to be legible and non-overlapping.  If rotateLabels is "never" then the labels
     * will not be rotated. <P> Note that automatic rotation is incompatible with setting  a cluster-size-minimum customizer
     * using {@link com.smartgwt.client.widgets.chart.FacetChart#setMinClusterSizeMapper 
     * FacetChart.setMinClusterSizeMapper()}, so that  {@link com.smartgwt.client.types.LabelRotationMode#AUTO} will be treated
     * as {@link com.smartgwt.client.types.LabelRotationMode#NEVER} if that method has been specified on a column, bar, or
     * histogram chart.
     *
     * @return Current rotateLabels value. Default value is "auto"
     * @see com.smartgwt.client.widgets.chart.FacetChart#getRadarRotateLabels
     */
    public LabelRotationMode getRotateLabels()  {
        return EnumUtil.getEnum(LabelRotationMode.values(), getAttribute("rotateLabels"));
    }
    

    /**
     * The ending color of the color scale when the data points are colored according to a {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getColorScaleMetric color scale metric}.  If neither this property nor the
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getScaleStartColor scaleStartColor} is set then the whole color
     * range is used by default. <p> Note that using CSS color shortcuts (e.g. "lightblue") is not allowed for this property.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.chart.FacetChart#getScaleEndColor scaleEndColor}.
     *
     * @param scaleEndColor The new end color for the color scale. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#colorScaleChart" target="examples">Color Scale Chart Example</a>
     */
    public FacetChart setScaleEndColor(String scaleEndColor) {
        return (FacetChart)setAttribute("scaleEndColor", scaleEndColor, true);
    }

    /**
     * The ending color of the color scale when the data points are colored according to a {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getColorScaleMetric color scale metric}.  If neither this property nor the
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getScaleStartColor scaleStartColor} is set then the whole color
     * range is used by default. <p> Note that using CSS color shortcuts (e.g. "lightblue") is not allowed for this property.
     *
     * @return Current scaleEndColor value. Default value is null
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#colorScaleChart" target="examples">Color Scale Chart Example</a>
     */
    public String getScaleEndColor()  {
        return getAttributeAsString("scaleEndColor");
    }
    

    /**
     * The starting color of the color scale when the data points are colored according to a {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getColorScaleMetric color scale metric}.  If neither this property nor the
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getScaleEndColor scaleEndColor} is set then the whole color range is
     * used by default. <p> Note that using CSS color shortcuts (e.g. "lightblue") is not allowed for this property.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.chart.FacetChart#getScaleStartColor scaleStartColor}.
     *
     * @param scaleStartColor The new start color for the color scale. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#colorScaleChart" target="examples">Color Scale Chart Example</a>
     */
    public FacetChart setScaleStartColor(String scaleStartColor) {
        return (FacetChart)setAttribute("scaleStartColor", scaleStartColor, true);
    }

    /**
     * The starting color of the color scale when the data points are colored according to a {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getColorScaleMetric color scale metric}.  If neither this property nor the
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getScaleEndColor scaleEndColor} is set then the whole color range is
     * used by default. <p> Note that using CSS color shortcuts (e.g. "lightblue") is not allowed for this property.
     *
     * @return Current scaleStartColor value. Default value is null
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#colorScaleChart" target="examples">Color Scale Chart Example</a>
     */
    public String getScaleStartColor()  {
        return getAttributeAsString("scaleStartColor");
    }
    

    /**
     * Properties for shadows.
     *
     * @param shadowProperties New shadowProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public FacetChart setShadowProperties(DrawOval shadowProperties)  throws IllegalStateException {
        if (shadowProperties != null) {
            if (shadowProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setShadowProperties", "DrawOval");
            }                                                                       
            shadowProperties.setConfigOnly(true);
        }
        JavaScriptObject config = shadowProperties == null ? null : shadowProperties.getConfig();
        return (FacetChart)setAttribute("shadowProperties", JSOHelper.cleanProperties(config, true), false);
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
     * Whether to draw multiple bubble legends horizontally stacked to the right of the chart, one per shape type. <p> Note
     * that this setting has no effect if {@link com.smartgwt.client.widgets.chart.FacetChart#getUseMultiplePointShapes
     * useMultiplePointShapes} is disabled.
     *
     * @param showBubbleLegendPerShape New showBubbleLegendPerShape value. Default value is false
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setShowBubbleLegendPerShape(boolean showBubbleLegendPerShape)  throws IllegalStateException {
        return (FacetChart)setAttribute("showBubbleLegendPerShape", showBubbleLegendPerShape, false);
    }

    /**
     * Whether to draw multiple bubble legends horizontally stacked to the right of the chart, one per shape type. <p> Note
     * that this setting has no effect if {@link com.smartgwt.client.widgets.chart.FacetChart#getUseMultiplePointShapes
     * useMultiplePointShapes} is disabled.
     *
     * @return Current showBubbleLegendPerShape value. Default value is false
     */
    public boolean getShowBubbleLegendPerShape()  {
        Boolean result = getAttributeAsBoolean("showBubbleLegendPerShape");
        return result == null ? false : result;
    }
    

    /**
     * Whether to show a rectangular shape around the area of the chart where data is plotted.
     *
     * @param showChartRect New showChartRect value. Default value is false
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setShowChartRect(Boolean showChartRect)  throws IllegalStateException {
        return (FacetChart)setAttribute("showChartRect", showChartRect, false);
    }

    /**
     * Whether to show a rectangular shape around the area of the chart where data is plotted.
     *
     * @return Current showChartRect value. Default value is false
     */
    public Boolean getShowChartRect()  {
        Boolean result = getAttributeAsBoolean("showChartRect");
        return result == null ? false : result;
    }
    

    /**
     * Whether to show an additional legend underneath the chart to indicate color values. The default is <code>true</code> if
     * a valid {@link com.smartgwt.client.widgets.chart.FacetChart#getColorScaleMetric colorScaleMetric} is specified.
     *
     * @param showColorScaleLegend New showColorScaleLegend value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.chart.FacetChart#setScaleStartColor
     * @see com.smartgwt.client.widgets.chart.FacetChart#setScaleEndColor
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#colorScaleChart" target="examples">Color Scale Chart Example</a>
     */
    public FacetChart setShowColorScaleLegend(Boolean showColorScaleLegend)  throws IllegalStateException {
        return (FacetChart)setAttribute("showColorScaleLegend", showColorScaleLegend, false);
    }

    /**
     * Whether to show an additional legend underneath the chart to indicate color values. The default is <code>true</code> if
     * a valid {@link com.smartgwt.client.widgets.chart.FacetChart#getColorScaleMetric colorScaleMetric} is specified.
     *
     * @return Current showColorScaleLegend value. Default value is null
     * @see com.smartgwt.client.widgets.chart.FacetChart#getScaleStartColor
     * @see com.smartgwt.client.widgets.chart.FacetChart#getScaleEndColor
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#colorScaleChart" target="examples">Color Scale Chart Example</a>
     */
    public Boolean getShowColorScaleLegend()  {
        return getAttributeAsBoolean("showColorScaleLegend");
    }
    

    /**
     * Whether to show a label for the data axis as a whole (the data axis is where labels for each data point appear).  If
     * true, {@link com.smartgwt.client.widgets.cube.Facet#getTitle Facet.title} for the data label facet will be shown as the
     * label. <P> Automatically disabled for non-rectangular charts (eg Pie, Radar).
     *
     * @param showDataAxisLabel New showDataAxisLabel value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setShowDataAxisLabel(Boolean showDataAxisLabel)  throws IllegalStateException {
        return (FacetChart)setAttribute("showDataAxisLabel", showDataAxisLabel, false);
    }

    /**
     * Whether to show a label for the data axis as a whole (the data axis is where labels for each data point appear).  If
     * true, {@link com.smartgwt.client.widgets.cube.Facet#getTitle Facet.title} for the data label facet will be shown as the
     * label. <P> Automatically disabled for non-rectangular charts (eg Pie, Radar).
     *
     * @return Current showDataAxisLabel value. Default value is null
     */
    public Boolean getShowDataAxisLabel()  {
        return getAttributeAsBoolean("showDataAxisLabel");
    }
    

    /**
     * If set to <code>false</code>, data labels for values are entirely omitted. <P> This property would generally only be set
     * to <code>false</code> if several small charts are shown together and the data labels are drawn elsewhere on the screen
     * (above an entire stack of charts, for instance) or are otherwise implicit.
     *
     * @param showDataLabels New showDataLabels value. Default value is true
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setShowDataLabels(boolean showDataLabels)  throws IllegalStateException {
        return (FacetChart)setAttribute("showDataLabels", showDataLabels, false);
    }

    /**
     * If set to <code>false</code>, data labels for values are entirely omitted. <P> This property would generally only be set
     * to <code>false</code> if several small charts are shown together and the data labels are drawn elsewhere on the screen
     * (above an entire stack of charts, for instance) or are otherwise implicit.
     *
     * @return Current showDataLabels value. Default value is true
     */
    public boolean getShowDataLabels()  {
        Boolean result = getAttributeAsBoolean("showDataLabels");
        return result == null ? true : result;
    }
    

    /**
     * For Line, Area, Radar, Scatter or Bubble charts, whether to show data points for each individual data value. <P> If
     * shown, the {@link com.smartgwt.client.widgets.chart.FacetChart#pointClick pointClick()} and {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getPointHoverHTML getPointHoverHTML()} APIs can be used to create
     * interactivity.
     *
     * @param showDataPoints New showDataPoints value. Default value is false
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setShowDataPoints(Boolean showDataPoints)  throws IllegalStateException {
        return (FacetChart)setAttribute("showDataPoints", showDataPoints, false);
    }

    /**
     * For Line, Area, Radar, Scatter or Bubble charts, whether to show data points for each individual data value. <P> If
     * shown, the {@link com.smartgwt.client.widgets.chart.FacetChart#pointClick pointClick()} and {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getPointHoverHTML getPointHoverHTML()} APIs can be used to create
     * interactivity.
     *
     * @return Current showDataPoints value. Default value is false
     */
    public Boolean getShowDataPoints()  {
        Boolean result = getAttributeAsBoolean("showDataPoints");
        return result == null ? false : result;
    }
    

    /**
     * Should data values be shown as text labels near the shape representing the value, for example, above columns of a column
     * chart, or adjacent to points in a line chart? <p> If set to false, then data values will not be shown. <p> If set to
     * true, data values will be shown unless the data density is high enough that labels will potentially overlap, in which
     * case, data values will not be shown and hovers will be shown instead, in the same way as {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getShowValueOnHover showValueOnHover} shows hovers.
     *
     * @param showDataValues New showDataValues value. Default value is false
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @deprecated in favor of {@link com.smartgwt.client.widgets.chart.FacetChart#getShowDataValuesMode showDataValuesMode}, which is an
     * enum of supported modes
     */
    public FacetChart setShowDataValues(boolean showDataValues)  throws IllegalStateException {
        return (FacetChart)setAttribute("showDataValues", showDataValues, false);
    }

    /**
     * Should data values be shown as text labels near the shape representing the value, for example, above columns of a column
     * chart, or adjacent to points in a line chart? <p> If set to false, then data values will not be shown. <p> If set to
     * true, data values will be shown unless the data density is high enough that labels will potentially overlap, in which
     * case, data values will not be shown and hovers will be shown instead, in the same way as {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getShowValueOnHover showValueOnHover} shows hovers.
     *
     * @return Current showDataValues value. Default value is false
     * @deprecated in favor of {@link com.smartgwt.client.widgets.chart.FacetChart#getShowDataValuesMode showDataValuesMode}, which is an
     * enum of supported modes
     */
    public boolean getShowDataValues()  {
        Boolean result = getAttributeAsBoolean("showDataValues");
        return result == null ? false : result;
    }
    

    /**
     * Strategy for determining whether and when to show data-values - either in the chart, near the shape representing a value
     * (above columns of a column chart for example, or  adjacent to points in a line chart), in hovers, or some combination of
     * both, including  {@link com.smartgwt.client.widgets.chart.FacetChart#getRotateDataLabels automatic rotation} where
     * supported.
     *
     * @param showDataValuesMode New showDataValuesMode value. Default value is "never"
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     */
    public FacetChart setShowDataValuesMode(ShowDataValuesMode showDataValuesMode) {
        return (FacetChart)setAttribute("showDataValuesMode", showDataValuesMode == null ? null : showDataValuesMode.getValue(), true);
    }

    /**
     * Strategy for determining whether and when to show data-values - either in the chart, near the shape representing a value
     * (above columns of a column chart for example, or  adjacent to points in a line chart), in hovers, or some combination of
     * both, including  {@link com.smartgwt.client.widgets.chart.FacetChart#getRotateDataLabels automatic rotation} where
     * supported.
     *
     * @return Current showDataValuesMode value. Default value is "never"
     */
    public ShowDataValuesMode getShowDataValuesMode()  {
        return EnumUtil.getEnum(ShowDataValuesMode.values(), getAttribute("showDataValuesMode"));
    }
    

    /**
     * Whether to show a "doughnut hole" in the middle of pie charts.  Defaults to whether chartType is set to "Doughnut"
     * (shown) vs "Pie" (not shown) but can be forced on or off via <code>showDoughnut</code>.
     *
     * @param showDoughnut New showDoughnut value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setShowDoughnut(Boolean showDoughnut)  throws IllegalStateException {
        return (FacetChart)setAttribute("showDoughnut", showDoughnut, false);
    }

    /**
     * Whether to show a "doughnut hole" in the middle of pie charts.  Defaults to whether chartType is set to "Doughnut"
     * (shown) vs "Pie" (not shown) but can be forced on or off via <code>showDoughnut</code>.
     *
     * @return Current showDoughnut value. Default value is null
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
     * @param showExpectedValueLine New showExpectedValueLine value. Default value is false
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setShowExpectedValueLine(Boolean showExpectedValueLine)  throws IllegalStateException {
        return (FacetChart)setAttribute("showExpectedValueLine", showExpectedValueLine, false);
    }

    /**
     * Display a line at the {@link com.smartgwt.client.widgets.chart.FacetChart#getMean mean value}. <P> Note that this
     * expected value is computed using all of the data points, pooled across all facets.  The computation relies only on the
     * values of the main value axis metric and the {@link com.smartgwt.client.widgets.chart.FacetChart#getProbabilityMetric
     * probability metric}. <P> See <a
     * href="http://en.wikipedia.org/wiki/Expected_value">http://en.wikipedia.org/wiki/Expected_value</a>.
     *
     * @return Current showExpectedValueLine value. Default value is false
     */
    public Boolean getShowExpectedValueLine()  {
        Boolean result = getAttributeAsBoolean("showExpectedValueLine");
        return result == null ? false : result;
    }
    

    /**
     * If set, gradation lines are drawn on top of data rather than underneath.
     *
     * @param showGradationsOverData New showGradationsOverData value. Default value is false
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setShowGradationsOverData(Boolean showGradationsOverData)  throws IllegalStateException {
        return (FacetChart)setAttribute("showGradationsOverData", showGradationsOverData, false);
    }

    /**
     * If set, gradation lines are drawn on top of data rather than underneath.
     *
     * @return Current showGradationsOverData value. Default value is false
     */
    public Boolean getShowGradationsOverData()  {
        Boolean result = getAttributeAsBoolean("showGradationsOverData");
        return result == null ? false : result;
    }
    

    /**
     * Causes labels for the X axis to be shown above the axis and to the right of the gradation line they label, making for a
     * vertically more compact chart at the risk of gradation labels being partially obscured by data values.  Also causes the
     * last label to be skipped (nowhere to place it).
     *
     * @param showInlineLabels New showInlineLabels value. Default value is false
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setShowInlineLabels(Boolean showInlineLabels)  throws IllegalStateException {
        return (FacetChart)setAttribute("showInlineLabels", showInlineLabels, false);
    }

    /**
     * Causes labels for the X axis to be shown above the axis and to the right of the gradation line they label, making for a
     * vertically more compact chart at the risk of gradation labels being partially obscured by data values.  Also causes the
     * last label to be skipped (nowhere to place it).
     *
     * @return Current showInlineLabels value. Default value is false
     */
    public Boolean getShowInlineLabels()  {
        Boolean result = getAttributeAsBoolean("showInlineLabels");
        return result == null ? false : result;
    }
    

    /**
     * The legend is automatically shown for charts that need it (generally, multi-series charts) but can be forced off by
     * setting showLegend to false.
     *
     * @param showLegend New showLegend value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setShowLegend(Boolean showLegend)  throws IllegalStateException {
        return (FacetChart)setAttribute("showLegend", showLegend, false);
    }

    /**
     * The legend is automatically shown for charts that need it (generally, multi-series charts) but can be forced off by
     * setting showLegend to false.
     *
     * @return Current showLegend value. Default value is null
     */
    public Boolean getShowLegend()  {
        return getAttributeAsBoolean("showLegend");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.chart.FacetChart#getShowYTicks ticks} are being shown, controls whether a
     * distinction is made between major and minor tick marks. <p> If minor ticks are used, by default, major ticks are used
     * for powers of 10 and minor ticks are used for other gradations. See {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMajorTickGradations majorTickGradations} for control over which ticks
     * are rendered as major vs minor ticks.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.chart.FacetChart#getShowMinorTicks showMinorTicks}.
     *
     * @param showMinorTicks new {@link com.smartgwt.client.widgets.chart.FacetChart#getShowMinorTicks showMinorTicks} value. Default value is true
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     */
    public FacetChart setShowMinorTicks(boolean showMinorTicks) {
        return (FacetChart)setAttribute("showMinorTicks", showMinorTicks, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.chart.FacetChart#getShowYTicks ticks} are being shown, controls whether a
     * distinction is made between major and minor tick marks. <p> If minor ticks are used, by default, major ticks are used
     * for powers of 10 and minor ticks are used for other gradations. See {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMajorTickGradations majorTickGradations} for control over which ticks
     * are rendered as major vs minor ticks.
     *
     * @return Current showMinorTicks value. Default value is true
     */
    public boolean getShowMinorTicks()  {
        Boolean result = getAttributeAsBoolean("showMinorTicks");
        return result == null ? true : result;
    }
    

    /**
     * Whether to show an additional legend to the right of the chart to indicate {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getPointSizeMetric point size}.  The default is <code>true</code> for
     * bubble charts and <code>false</code> for all other chart types.
     *
     * @param showPointSizeLegend New showPointSizeLegend value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.chart.FacetChart#setPointSizeGradations
     * @see com.smartgwt.client.widgets.chart.FacetChart#setUsePointSizeLogGradations
     * @see com.smartgwt.client.widgets.chart.FacetChart#setPointSizeLogGradations
     * @see com.smartgwt.client.widgets.chart.FacetChart#setShowBubbleLegendPerShape
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#bubbleChart" target="examples">Bubble Chart Example</a>
     */
    public FacetChart setShowPointSizeLegend(Boolean showPointSizeLegend)  throws IllegalStateException {
        return (FacetChart)setAttribute("showPointSizeLegend", showPointSizeLegend, false);
    }

    /**
     * Whether to show an additional legend to the right of the chart to indicate {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getPointSizeMetric point size}.  The default is <code>true</code> for
     * bubble charts and <code>false</code> for all other chart types.
     *
     * @return Current showPointSizeLegend value. Default value is null
     * @see com.smartgwt.client.widgets.chart.FacetChart#getPointSizeGradations
     * @see com.smartgwt.client.widgets.chart.FacetChart#getUsePointSizeLogGradations
     * @see com.smartgwt.client.widgets.chart.FacetChart#getPointSizeLogGradations
     * @see com.smartgwt.client.widgets.chart.FacetChart#getShowBubbleLegendPerShape
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#bubbleChart" target="examples">Bubble Chart Example</a>
     */
    public Boolean getShowPointSizeLegend()  {
        return getAttributeAsBoolean("showPointSizeLegend");
    }
    

    /**
     * Whether to show gradation labels in radar charts.
     *
     * @param showRadarGradationLabels New showRadarGradationLabels value. Default value is true
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setShowRadarGradationLabels(Boolean showRadarGradationLabels)  throws IllegalStateException {
        return (FacetChart)setAttribute("showRadarGradationLabels", showRadarGradationLabels, false);
    }

    /**
     * Whether to show gradation labels in radar charts.
     *
     * @return Current showRadarGradationLabels value. Default value is true
     */
    public Boolean getShowRadarGradationLabels()  {
        Boolean result = getAttributeAsBoolean("showRadarGradationLabels");
        return result == null ? true : result;
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
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.chart.FacetChart#getShowRegressionLine showRegressionLine}.
     *
     * @param showRegressionLine New value for this.showRegressionLine. Default value is false
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.chart.FacetChart#setXAxisMetric
     * @see com.smartgwt.client.widgets.chart.FacetChart#setYAxisMetric
     * @see com.smartgwt.client.widgets.chart.FacetChart#setRegressionLineProperties
     */
    public FacetChart setShowRegressionLine(Boolean showRegressionLine) {
        return (FacetChart)setAttribute("showRegressionLine", showRegressionLine, true);
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
     * @return Current showRegressionLine value. Default value is false
     * @see com.smartgwt.client.widgets.chart.FacetChart#getXAxisMetric
     * @see com.smartgwt.client.widgets.chart.FacetChart#getYAxisMetric
     * @see com.smartgwt.client.widgets.chart.FacetChart#getRegressionLineProperties
     */
    public Boolean getShowRegressionLine()  {
        Boolean result = getAttributeAsBoolean("showRegressionLine");
        return result == null ? false : result;
    }
    

    /**
     * Whether to draw lines between adjacent data points in "Scatter" plots.  See also {@link
     * com.smartgwt.client.types.DataLineType} for enabling smoothing.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Method to change the current {@link com.smartgwt.client.types.ChartType showScatterLines}. Will redraw the chart if drawn.
     *
     * @param showScatterLines whether to draw lines between adjacent data points in "Scatter" plots. Default value is false
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#scatterPlotCharting" target="examples">Scatter Plot Example</a>
     */
    public FacetChart setShowScatterLines(Boolean showScatterLines) {
        return (FacetChart)setAttribute("showScatterLines", showScatterLines, true);
    }

    /**
     * Whether to draw lines between adjacent data points in "Scatter" plots.  See also {@link
     * com.smartgwt.client.types.DataLineType} for enabling smoothing.
     *
     * @return Current showScatterLines value. Default value is false
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#scatterPlotCharting" target="examples">Scatter Plot Example</a>
     */
    public Boolean getShowScatterLines()  {
        Boolean result = getAttributeAsBoolean("showScatterLines");
        return result == null ? false : result;
    }
    

    /**
     * Whether to automatically show shadows for various charts.
     *
     * @param showShadows New showShadows value. Default value is true
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setShowShadows(Boolean showShadows)  throws IllegalStateException {
        return (FacetChart)setAttribute("showShadows", showShadows, false);
    }

    /**
     * Whether to automatically show shadows for various charts.
     *
     * @return Current showShadows value. Default value is true
     */
    public Boolean getShowShadows()  {
        Boolean result = getAttributeAsBoolean("showShadows");
        return result == null ? true : result;
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
     * @param showStandardDeviationLines New showStandardDeviationLines value. Default value is false
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setShowStandardDeviationLines(Boolean showStandardDeviationLines)  throws IllegalStateException {
        return (FacetChart)setAttribute("showStandardDeviationLines", showStandardDeviationLines, false);
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
     * @return Current showStandardDeviationLines value. Default value is false
     */
    public Boolean getShowStandardDeviationLines()  {
        Boolean result = getAttributeAsBoolean("showStandardDeviationLines");
        return result == null ? false : result;
    }
    

    /**
     * If set, the {@link com.smartgwt.client.widgets.chart.FacetChart#getShowExpectedValueLine mean line}, {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getShowStandardDeviationLines standard deviation lines}, {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getBandedStandardDeviations standard deviation bands}, and {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getShowRegressionLine regression curves} are drawn on top of the data
     * rather than underneath.
     *
     * @param showStatisticsOverData New showStatisticsOverData value. Default value is false
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setShowStatisticsOverData(Boolean showStatisticsOverData)  throws IllegalStateException {
        return (FacetChart)setAttribute("showStatisticsOverData", showStatisticsOverData, false);
    }

    /**
     * If set, the {@link com.smartgwt.client.widgets.chart.FacetChart#getShowExpectedValueLine mean line}, {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getShowStandardDeviationLines standard deviation lines}, {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getBandedStandardDeviations standard deviation bands}, and {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getShowRegressionLine regression curves} are drawn on top of the data
     * rather than underneath.
     *
     * @return Current showStatisticsOverData value. Default value is false
     */
    public Boolean getShowStatisticsOverData()  {
        Boolean result = getAttributeAsBoolean("showStatisticsOverData");
        return result == null ? false : result;
    }
    

    /**
     * Whether to show a title.
     *
     * @param showTitle New showTitle value. Default value is true
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     */
    public FacetChart setShowTitle(Boolean showTitle) {
        return (FacetChart)setAttribute("showTitle", showTitle, true);
    }

    /**
     * Whether to show a title.
     *
     * @return Current showTitle value. Default value is true
     */
    public Boolean getShowTitle()  {
        Boolean result = getAttributeAsBoolean("showTitle");
        return result == null ? true : result;
    }
    

    /**
     * Whether to show the {@link com.smartgwt.client.widgets.chart.FacetChart#getValueTitle valueTitle} (or, in the case of
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getProportional proportional rendering mode}, the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getProportionalAxisLabel proportionalAxisLabel}) as a label on the value
     * axis. <p> Automatically disabled for non-rectangular charts (eg Pie, Radar).
     *
     * @param showValueAxisLabel New showValueAxisLabel value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setShowValueAxisLabel(Boolean showValueAxisLabel)  throws IllegalStateException {
        return (FacetChart)setAttribute("showValueAxisLabel", showValueAxisLabel, false);
    }

    /**
     * Whether to show the {@link com.smartgwt.client.widgets.chart.FacetChart#getValueTitle valueTitle} (or, in the case of
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getProportional proportional rendering mode}, the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getProportionalAxisLabel proportionalAxisLabel}) as a label on the value
     * axis. <p> Automatically disabled for non-rectangular charts (eg Pie, Radar).
     *
     * @return Current showValueAxisLabel value. Default value is null
     */
    public Boolean getShowValueAxisLabel()  {
        return getAttributeAsBoolean("showValueAxisLabel");
    }
    

    /**
     * Shows the value of the nearest data value in a floating label whenever the mouse moves within the main chart area.  The
     * visual element representing the data value will also be emphasized by brightening or highlighting it (appearance differs
     * by chart type). <p> Calculates nearest value based on {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getNearestDrawnValue getNearestDrawnValue()}. <p> The data value will be
     * formatted using {@link com.smartgwt.client.widgets.chart.FacetChart#setDataValueFormatter setDataValueFormatter()}. The
     * label's appearance is controlled by {@link com.smartgwt.client.widgets.chart.FacetChart#getHoverLabelProperties
     * hoverLabelProperties}.
     *
     * @param showValueOnHover New showValueOnHover value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @deprecated See {@link com.smartgwt.client.widgets.chart.FacetChart#getShowDataValuesMode showDataValuesMode} for details
     */
    public FacetChart setShowValueOnHover(Boolean showValueOnHover)  throws IllegalStateException {
        return (FacetChart)setAttribute("showValueOnHover", showValueOnHover, false);
    }

    /**
     * Shows the value of the nearest data value in a floating label whenever the mouse moves within the main chart area.  The
     * visual element representing the data value will also be emphasized by brightening or highlighting it (appearance differs
     * by chart type). <p> Calculates nearest value based on {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getNearestDrawnValue getNearestDrawnValue()}. <p> The data value will be
     * formatted using {@link com.smartgwt.client.widgets.chart.FacetChart#setDataValueFormatter setDataValueFormatter()}. The
     * label's appearance is controlled by {@link com.smartgwt.client.widgets.chart.FacetChart#getHoverLabelProperties
     * hoverLabelProperties}.
     *
     * @return Current showValueOnHover value. Default value is null
     * @deprecated See {@link com.smartgwt.client.widgets.chart.FacetChart#getShowDataValuesMode showDataValuesMode} for details
     */
    public Boolean getShowValueOnHover()  {
        return getAttributeAsBoolean("showValueOnHover");
    }
    

    /**
     * When set, ticks are shown for the X (horizontal) axis for Scatter plots or Bar charts.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.chart.FacetChart#getShowXTicks showXTicks}.
     *
     * @param showXTicks new {@link com.smartgwt.client.widgets.chart.FacetChart#getShowXTicks showXTicks} value. Default value is false
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.chart.FacetChart#setShowYTicks
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#customTicksChart" target="examples">Custom Date Ticks Example</a>
     */
    public FacetChart setShowXTicks(boolean showXTicks) {
        return (FacetChart)setAttribute("showXTicks", showXTicks, true);
    }

    /**
     * When set, ticks are shown for the X (horizontal) axis for Scatter plots or Bar charts.
     *
     * @return Current showXTicks value. Default value is false
     * @see com.smartgwt.client.widgets.chart.FacetChart#getShowYTicks
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#customTicksChart" target="examples">Custom Date Ticks Example</a>
     */
    public boolean getShowXTicks()  {
        Boolean result = getAttributeAsBoolean("showXTicks");
        return result == null ? false : result;
    }
    

    /**
     * When set, ticks are shown for the Y (vertical) axis if it's a value axis. <p> Normally, ticks are not shown for the
     * primary axis, since  {@link com.smartgwt.client.widgets.chart.FacetChart#getGradations gradation lines} show value
     * demarcations.  Gradation  lines are always show for {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics extra value axes} in multi-axis charts (since there are
     * no gradation lines for the additional axes). <p> {@link com.smartgwt.client.widgets.chart.FacetChart#getShowXTicks
     * showXTicks} can be used to control whether ticks are shown for the horizontal axis, for certain chart types.  See also 
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getMajorTickGradations majorTickGradations} for control of which
     * ticks are shown as major vs minor ticks.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.chart.FacetChart#getShowYTicks showYTicks}.
     *
     * @param showYTicks new {@link com.smartgwt.client.widgets.chart.FacetChart#getShowYTicks showYTicks} value. Default value is false
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     */
    public FacetChart setShowYTicks(boolean showYTicks) {
        return (FacetChart)setAttribute("showYTicks", showYTicks, true);
    }

    /**
     * When set, ticks are shown for the Y (vertical) axis if it's a value axis. <p> Normally, ticks are not shown for the
     * primary axis, since  {@link com.smartgwt.client.widgets.chart.FacetChart#getGradations gradation lines} show value
     * demarcations.  Gradation  lines are always show for {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics extra value axes} in multi-axis charts (since there are
     * no gradation lines for the additional axes). <p> {@link com.smartgwt.client.widgets.chart.FacetChart#getShowXTicks
     * showXTicks} can be used to control whether ticks are shown for the horizontal axis, for certain chart types.  See also 
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getMajorTickGradations majorTickGradations} for control of which
     * ticks are shown as major vs minor ticks.
     *
     * @return Current showYTicks value. Default value is false
     */
    public boolean getShowYTicks()  {
        Boolean result = getAttributeAsBoolean("showYTicks");
        return result == null ? false : result;
    }
    

    /**
     * Whether to use stacking for charts where this makes sense (column, area, pie, line and radar charts).  If stacked is not
     * set and two facets are supplied, clustering is assumed. If null (the default), line charts will be unstacked, and others
     * will be stacked.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Method to change {@link com.smartgwt.client.widgets.chart.FacetChart#getStacked stacked}. Use null to apply a default value for the current {@link com.smartgwt.client.types.ChartType chartType}.
     *
     * @param stacked new value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     */
    public FacetChart setStacked(Boolean stacked) {
        return (FacetChart)setAttribute("stacked", stacked, true);
    }

    /**
     * Whether to use stacking for charts where this makes sense (column, area, pie, line and radar charts).  If stacked is not
     * set and two facets are supplied, clustering is assumed. If null (the default), line charts will be unstacked, and others
     * will be stacked.
     *
     * @return Current stacked value. Default value is null
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
     * @param standardDeviationBandProperties New standardDeviationBandProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public FacetChart setStandardDeviationBandProperties(DrawItem... standardDeviationBandProperties)  throws IllegalStateException {
        final JavaScriptObject configs;
        if (standardDeviationBandProperties == null) {
            configs = null;
        } else {
            configs = JSOHelper.createJavaScriptArray();
            for (int configJIndex = 0; configJIndex < standardDeviationBandProperties.length; ++configJIndex) {
                final DrawItem configJ = standardDeviationBandProperties[configJIndex];
                if (configJ != null && configJ.isCreated()) {
                    ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setStandardDeviationBandProperties", "DrawItem...");
                }
                configJ.setConfigOnly(true);
                final JavaScriptObject config = configJ == null ? null : configJ.getConfig();
                JSOHelper.setArrayValue(configs, configJIndex, JSOHelper.cleanProperties(config, true));
            }
        }
        return (FacetChart)setAttribute("standardDeviationBandProperties", configs, false);
    }
    

    /**
     * Properties for the {@link com.smartgwt.client.widgets.chart.FacetChart#getShowStandardDeviationLines standard deviation
     * lines}. <p> Note that for rectangular charts the properties are for a {@link
     * com.smartgwt.client.widgets.drawing.DrawLine}, and for radar charts the properties are for a {@link
     * com.smartgwt.client.widgets.drawing.DrawOval}.
     *
     * @param standardDeviationLineProperties New standardDeviationLineProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public FacetChart setStandardDeviationLineProperties(DrawItem standardDeviationLineProperties)  throws IllegalStateException {
        if (standardDeviationLineProperties != null) {
            if (standardDeviationLineProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setStandardDeviationLineProperties", "DrawItem");
            }                                                                       
            standardDeviationLineProperties.setConfigOnly(true);
        }
        JavaScriptObject config = standardDeviationLineProperties == null ? null : standardDeviationLineProperties.getConfig();
        return (FacetChart)setAttribute("standardDeviationLineProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for the {@link com.smartgwt.client.widgets.chart.FacetChart#getShowStandardDeviationLines standard deviation
     * lines}. <p> Note that for rectangular charts the properties are for a {@link
     * com.smartgwt.client.widgets.drawing.DrawLine}, and for radar charts the properties are for a {@link
     * com.smartgwt.client.widgets.drawing.DrawOval}.
     *
     * @return Current standardDeviationLineProperties value. Default value is null
     */
    public DrawItem getStandardDeviationLineProperties()  {
        DrawItem properties = new DrawItem();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("standardDeviationLineProperties"));
        return properties;
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
     * @param standardDeviations New standardDeviations value. Default value is [-1, 1]
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setStandardDeviations(float... standardDeviations)  throws IllegalStateException {
        return (FacetChart)setAttribute("standardDeviations", standardDeviations, false);
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
     * @return Current standardDeviations value. Default value is [-1, 1]
     */
    public float[] getStandardDeviations()  {
        return com.smartgwt.client.util.ConvertTo.arrayOffloat(getAttributeAsJavaScriptObject("standardDeviations"));
    }
    

    /**
     * Default styleName for the chart.
     *
     * @param styleName New styleName value. Default value is "scChart"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setStyleName(String styleName) {
        setAttribute("styleName", styleName, true);
    }

    /**
     * Default styleName for the chart.
     *
     * @return Current styleName value. Default value is "scChart"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getStyleName()  {
        return getAttributeAsString("styleName");
    }
    

    /**
     * Length of the tick marks used when either {@link com.smartgwt.client.widgets.chart.FacetChart#getShowXTicks showXTicks}
     * or  {@link com.smartgwt.client.widgets.chart.FacetChart#getShowYTicks showYTicks} is enabled, or when {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics extra value axes} are in use. <P> If minor tick marks
     * are also shown, their length is controlled by {@link com.smartgwt.client.widgets.chart.FacetChart#getMinorTickLength
     * minorTickLength}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.chart.FacetChart#getTickLength tickLength}.
     *
     * @param tickLength new {@link com.smartgwt.client.widgets.chart.FacetChart#getTickLength tickLength} value. Default value is 5
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     */
    public FacetChart setTickLength(int tickLength) {
        return (FacetChart)setAttribute("tickLength", tickLength, true);
    }

    /**
     * Length of the tick marks used when either {@link com.smartgwt.client.widgets.chart.FacetChart#getShowXTicks showXTicks}
     * or  {@link com.smartgwt.client.widgets.chart.FacetChart#getShowYTicks showYTicks} is enabled, or when {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics extra value axes} are in use. <P> If minor tick marks
     * are also shown, their length is controlled by {@link com.smartgwt.client.widgets.chart.FacetChart#getMinorTickLength
     * minorTickLength}.
     *
     * @return Current tickLength value. Default value is 5
     */
    public int getTickLength()  {
        return getAttributeAsInt("tickLength");
    }
    

    /**
     * Margin between the tick marks and the labels of the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics extra value axes}.
     *
     * @param tickMarkToValueAxisMargin New tickMarkToValueAxisMargin value. Default value is 7
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setTickMarkToValueAxisMargin(int tickMarkToValueAxisMargin)  throws IllegalStateException {
        return (FacetChart)setAttribute("tickMarkToValueAxisMargin", tickMarkToValueAxisMargin, false);
    }

    /**
     * Margin between the tick marks and the labels of the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics extra value axes}.
     *
     * @return Current tickMarkToValueAxisMargin value. Default value is 7
     */
    public int getTickMarkToValueAxisMargin()  {
        return getAttributeAsInt("tickMarkToValueAxisMargin");
    }
    

    /**
     * Title for the chart as a whole.
     *
     * @param title New title value. Default value is null
     */
    public void setTitle(String title) {
        setAttribute("title", title, true);
    }

    /**
     * Title for the chart as a whole.
     *
     * @return Current title value. Default value is null
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }
    

    /**
     * Horizontal alignment of the chart's {@link com.smartgwt.client.widgets.chart.FacetChart#getTitle title}.
     *
     * @param titleAlign New titleAlign value. Default value is "center"
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     */
    public FacetChart setTitleAlign(TitleAlign titleAlign) {
        return (FacetChart)setAttribute("titleAlign", titleAlign == null ? null : titleAlign.getValue(), true);
    }

    /**
     * Horizontal alignment of the chart's {@link com.smartgwt.client.widgets.chart.FacetChart#getTitle title}.
     *
     * @return Current titleAlign value. Default value is "center"
     */
    public TitleAlign getTitleAlign()  {
        return EnumUtil.getEnum(TitleAlign.values(), getAttribute("titleAlign"));
    }
    

    /**
     * Properties for title background (if being drawn).
     *
     * @param titleBackgroundProperties New titleBackgroundProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public FacetChart setTitleBackgroundProperties(DrawLabel titleBackgroundProperties) {
        if (titleBackgroundProperties != null) {
            if (titleBackgroundProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setTitleBackgroundProperties", "DrawLabel");
            }                                                                       
            titleBackgroundProperties.setConfigOnly(true);
        }
        JavaScriptObject config = titleBackgroundProperties == null ? null : titleBackgroundProperties.getConfig();
        return (FacetChart)setAttribute("titleBackgroundProperties", JSOHelper.cleanProperties(config, true), true);
    }

    /**
     * Properties for title background (if being drawn).
     *
     * @return Current titleBackgroundProperties value. Default value is null
     */
    public DrawLabel getTitleBackgroundProperties()  {
        DrawLabel properties = new DrawLabel();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("titleBackgroundProperties"));
        return properties;
    }
    

    /**
     * Properties for bottom boundary of the title area, when there is already an outer container around the whole chart. see
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getDrawTitleBoundary drawTitleBoundary}
     *
     * @param titleBoundaryProperties New titleBoundaryProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public FacetChart setTitleBoundaryProperties(DrawLine titleBoundaryProperties)  throws IllegalStateException {
        if (titleBoundaryProperties != null) {
            if (titleBoundaryProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setTitleBoundaryProperties", "DrawLine");
            }                                                                       
            titleBoundaryProperties.setConfigOnly(true);
        }
        JavaScriptObject config = titleBoundaryProperties == null ? null : titleBoundaryProperties.getConfig();
        return (FacetChart)setAttribute("titleBoundaryProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties for bottom boundary of the title area, when there is already an outer container around the whole chart. see
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getDrawTitleBoundary drawTitleBoundary}
     *
     * @return Current titleBoundaryProperties value. Default value is null
     */
    public DrawLine getTitleBoundaryProperties()  {
        DrawLine properties = new DrawLine();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("titleBoundaryProperties"));
        return properties;
    }
    

    /**
     * if aligning the title left or right, the amount of space before (for left aligned) or after (for right aligned) to pad
     * the title from the border edge
     *
     * @param titlePadding New titlePadding value. Default value is 0
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     */
    public FacetChart setTitlePadding(int titlePadding) {
        return (FacetChart)setAttribute("titlePadding", titlePadding, true);
    }

    /**
     * if aligning the title left or right, the amount of space before (for left aligned) or after (for right aligned) to pad
     * the title from the border edge
     *
     * @return Current titlePadding value. Default value is 0
     */
    public int getTitlePadding()  {
        return getAttributeAsInt("titlePadding");
    }
    

    /**
     * Properties for title label.
     *
     * @param titleProperties New titleProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public FacetChart setTitleProperties(DrawLabel titleProperties) {
        if (titleProperties != null) {
            if (titleProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setTitleProperties", "DrawLabel");
            }                                                                       
            titleProperties.setConfigOnly(true);
        }
        JavaScriptObject config = titleProperties == null ? null : titleProperties.getConfig();
        return (FacetChart)setAttribute("titleProperties", JSOHelper.cleanProperties(config, true), true);
    }

    /**
     * Properties for title label.
     *
     * @return Current titleProperties value. Default value is null
     */
    public DrawLabel getTitleProperties()  {
        DrawLabel properties = new DrawLabel();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("titleProperties"));
        return properties;
    }
    

    /**
     * The height of the bordered rect around the title - defaults to 0 (assuming no border)
     *
     * @param titleRectHeight New titleRectHeight value. Default value is 5
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     */
    public FacetChart setTitleRectHeight(int titleRectHeight) {
        return (FacetChart)setAttribute("titleRectHeight", titleRectHeight, true);
    }

    /**
     * The height of the bordered rect around the title - defaults to 0 (assuming no border)
     *
     * @return Current titleRectHeight value. Default value is 5
     */
    public int getTitleRectHeight()  {
        return getAttributeAsInt("titleRectHeight");
    }
    

    /**
     * Causes the chart to use the colors specified in {@link com.smartgwt.client.widgets.chart.FacetChart#getDataColors
     * dataColors} but specify chart-specific  gradients based on the primary data color per chart type.
     *
     * @param useAutoGradients New useAutoGradients value. Default value is true
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setUseAutoGradients(Boolean useAutoGradients)  throws IllegalStateException {
        return (FacetChart)setAttribute("useAutoGradients", useAutoGradients, false);
    }

    /**
     * Causes the chart to use the colors specified in {@link com.smartgwt.client.widgets.chart.FacetChart#getDataColors
     * dataColors} but specify chart-specific  gradients based on the primary data color per chart type.
     *
     * @return Current useAutoGradients value. Default value is true
     */
    public Boolean getUseAutoGradients()  {
        Boolean result = getAttributeAsBoolean("useAutoGradients");
        return result == null ? true : result;
    }
    

    /**
     * Whether to use classic logarithmic gradations, where each order of magnitude is shown as a gradation as well as a few
     * intervening lines.   Gradations also begin and end on an order of magnitude.  For example, 1,2,4,6,8,10,20,40,60,80,100.
     * <P> Default gradations can be overridden via {@link com.smartgwt.client.widgets.chart.FacetChart#getLogBase logBase} and
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getLogGradations logGradations}.
     *
     * @param useLogGradations New useLogGradations value. Default value is false
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setUseLogGradations(Boolean useLogGradations)  throws IllegalStateException {
        return (FacetChart)setAttribute("useLogGradations", useLogGradations, false);
    }

    /**
     * Whether to use classic logarithmic gradations, where each order of magnitude is shown as a gradation as well as a few
     * intervening lines.   Gradations also begin and end on an order of magnitude.  For example, 1,2,4,6,8,10,20,40,60,80,100.
     * <P> Default gradations can be overridden via {@link com.smartgwt.client.widgets.chart.FacetChart#getLogBase logBase} and
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getLogGradations logGradations}.
     *
     * @return Current useLogGradations value. Default value is false
     */
    public Boolean getUseLogGradations()  {
        Boolean result = getAttributeAsBoolean("useLogGradations");
        return result == null ? false : result;
    }
    

    /**
     * Whether the chart should use multiple shapes to show data points.  If set to <code>true</code> then the chart is allowed
     * to use all {@link com.smartgwt.client.widgets.chart.FacetChart#getPointShapes supported shapes}:  circles, squares,
     * diamonds, and triangles.  If set to <code>false</code> then just the first supported shape (circles, for example) will
     * be used.  The default is <code>false</code> for bubble charts and {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getColorScaleMetric color scale charts} and <code>true</code> for all other
     * chart types.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.chart.FacetChart#getUseMultiplePointShapes useMultiplePointShapes}.
     *
     * @param useMultiplePointShapes Whether the chart should now use multiple shapes to show data points. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#bubbleChart" target="examples">Bubble Chart Example</a>
     */
    public FacetChart setUseMultiplePointShapes(Boolean useMultiplePointShapes) {
        return (FacetChart)setAttribute("useMultiplePointShapes", useMultiplePointShapes, true);
    }

    /**
     * Whether the chart should use multiple shapes to show data points.  If set to <code>true</code> then the chart is allowed
     * to use all {@link com.smartgwt.client.widgets.chart.FacetChart#getPointShapes supported shapes}:  circles, squares,
     * diamonds, and triangles.  If set to <code>false</code> then just the first supported shape (circles, for example) will
     * be used.  The default is <code>false</code> for bubble charts and {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getColorScaleMetric color scale charts} and <code>true</code> for all other
     * chart types.
     *
     * @return Current useMultiplePointShapes value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#bubbleChart" target="examples">Bubble Chart Example</a>
     */
    public Boolean getUseMultiplePointShapes()  {
        return getAttributeAsBoolean("useMultiplePointShapes");
    }
    

    /**
     * Whether to use classic logarithmic gradations, where each order of magnitude is shown as a gradation as well as a few
     * intervening values, for the {@link com.smartgwt.client.widgets.chart.FacetChart#getPointSizeMetric pointSizeMetric}
     * values displayed in the {@link com.smartgwt.client.widgets.chart.FacetChart#getShowPointSizeLegend point size legend}. 
     * Gradations also begin and end on an order of magnitude.  For example, 1, 2, 4, 6, 8, 10, 20, 40, 60, 80, 100. <p>
     * Default gradations can be overridden via {@link com.smartgwt.client.widgets.chart.FacetChart#getPointSizeLogBase
     * pointSizeLogBase} and {@link com.smartgwt.client.widgets.chart.FacetChart#getPointSizeLogGradations
     * pointSizeLogGradations}.
     *
     * @param usePointSizeLogGradations New usePointSizeLogGradations value. Default value is false
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.chart.FacetChart#setUseLogGradations
     */
    public FacetChart setUsePointSizeLogGradations(Boolean usePointSizeLogGradations)  throws IllegalStateException {
        return (FacetChart)setAttribute("usePointSizeLogGradations", usePointSizeLogGradations, false);
    }

    /**
     * Whether to use classic logarithmic gradations, where each order of magnitude is shown as a gradation as well as a few
     * intervening values, for the {@link com.smartgwt.client.widgets.chart.FacetChart#getPointSizeMetric pointSizeMetric}
     * values displayed in the {@link com.smartgwt.client.widgets.chart.FacetChart#getShowPointSizeLegend point size legend}. 
     * Gradations also begin and end on an order of magnitude.  For example, 1, 2, 4, 6, 8, 10, 20, 40, 60, 80, 100. <p>
     * Default gradations can be overridden via {@link com.smartgwt.client.widgets.chart.FacetChart#getPointSizeLogBase
     * pointSizeLogBase} and {@link com.smartgwt.client.widgets.chart.FacetChart#getPointSizeLogGradations
     * pointSizeLogGradations}.
     *
     * @return Current usePointSizeLogGradations value. Default value is false
     * @see com.smartgwt.client.widgets.chart.FacetChart#getUseLogGradations
     */
    public Boolean getUsePointSizeLogGradations()  {
        Boolean result = getAttributeAsBoolean("usePointSizeLogGradations");
        return result == null ? false : result;
    }
    

    /**
     * Whether to display both the positive and negative of the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getStandardDeviations standard deviations}.
     *
     * @param useSymmetricStandardDeviations New useSymmetricStandardDeviations value. Default value is true
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setUseSymmetricStandardDeviations(Boolean useSymmetricStandardDeviations)  throws IllegalStateException {
        return (FacetChart)setAttribute("useSymmetricStandardDeviations", useSymmetricStandardDeviations, false);
    }

    /**
     * Whether to display both the positive and negative of the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getStandardDeviations standard deviations}.
     *
     * @return Current useSymmetricStandardDeviations value. Default value is true
     */
    public Boolean getUseSymmetricStandardDeviations()  {
        Boolean result = getAttributeAsBoolean("useSymmetricStandardDeviations");
        return result == null ? true : result;
    }
    

    /**
     * Properties for labels of value axis.
     *
     * @param valueAxisLabelProperties New valueAxisLabelProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public FacetChart setValueAxisLabelProperties(DrawLabel valueAxisLabelProperties) {
        if (valueAxisLabelProperties != null) {
            if (valueAxisLabelProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setValueAxisLabelProperties", "DrawLabel");
            }                                                                       
            valueAxisLabelProperties.setConfigOnly(true);
        }
        JavaScriptObject config = valueAxisLabelProperties == null ? null : valueAxisLabelProperties.getConfig();
        return (FacetChart)setAttribute("valueAxisLabelProperties", JSOHelper.cleanProperties(config, true), true);
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
     * Margin between {@link com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics multiple value axes}.
     *
     * @param valueAxisMargin New valueAxisMargin value. Default value is 10
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setValueAxisMargin(int valueAxisMargin)  throws IllegalStateException {
        return (FacetChart)setAttribute("valueAxisMargin", valueAxisMargin, false);
    }

    /**
     * Margin between {@link com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics multiple value axes}.
     *
     * @return Current valueAxisMargin value. Default value is 10
     */
    public int getValueAxisMargin()  {
        return getAttributeAsInt("valueAxisMargin");
    }
    

    /**
     * Properties for a "value line" - a line shows where a particular discrete value is placed, eg, vertical lines connecting
     * points of a line chart to the X axis, or radial lines in a Radar chart.
     *
     * @param valueLineProperties New valueLineProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public FacetChart setValueLineProperties(DrawLine valueLineProperties)  throws IllegalStateException {
        if (valueLineProperties != null) {
            if (valueLineProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setValueLineProperties", "DrawLine");
            }                                                                       
            valueLineProperties.setConfigOnly(true);
        }
        JavaScriptObject config = valueLineProperties == null ? null : valueLineProperties.getConfig();
        return (FacetChart)setAttribute("valueLineProperties", JSOHelper.cleanProperties(config, true), false);
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
     * Property in each record that holds a data value. <P> Not used if there is an inline facet, see  Chart.data.
     *
     * @param valueProperty New valueProperty value. Default value is "_value"
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setValueProperty(String valueProperty)  throws IllegalStateException {
        return (FacetChart)setAttribute("valueProperty", valueProperty, false);
    }

    /**
     * Property in each record that holds a data value. <P> Not used if there is an inline facet, see  Chart.data.
     *
     * @return Current valueProperty value. Default value is "_value"
     */
    public String getValueProperty()  {
        return getAttributeAsString("valueProperty");
    }
    

    /**
     * A label for the data values, such as "Sales in Thousands", typically used as the label for the value axis.
     *
     * @param valueTitle New valueTitle value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setValueTitle(String valueTitle)  throws IllegalStateException {
        return (FacetChart)setAttribute("valueTitle", valueTitle, false);
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
     * For Bubble and Scatter charts only, the end value for the x-axis. <p> If set to an explicit value, this will be
     * respected. If unset, the axis end value will default to a value large enough to show the largest data point. <P> If the
     * x-axis metric is date-valued, this value should be a date (typically applies to Scatter charts only).
     *
     * @param xAxisEndValue New xAxisEndValue value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.chart.FacetChart#setAxisEndValue
     */
    public FacetChart setXAxisEndValue(Double xAxisEndValue)  throws IllegalStateException {
        return (FacetChart)setAttribute("xAxisEndValue", xAxisEndValue, false);
    }

    /**
     * For Bubble and Scatter charts only, the end value for the x-axis. <p> If set to an explicit value, this will be
     * respected. If unset, the axis end value will default to a value large enough to show the largest data point. <P> If the
     * x-axis metric is date-valued, this value should be a date (typically applies to Scatter charts only).
     *
     * @return Current xAxisEndValue value. Default value is null
     * @see com.smartgwt.client.widgets.chart.FacetChart#getAxisEndValue
     */
    public Double getXAxisEndValue()  {
        return getAttributeAsDouble("xAxisEndValue");
    }

    /**
     * For Bubble and Scatter charts only, the end value for the x-axis. <p> If set to an explicit value, this will be
     * respected. If unset, the axis end value will default to a value large enough to show the largest data point. <P> If the
     * x-axis metric is date-valued, this value should be a date (typically applies to Scatter charts only).
     *
     * @param xAxisEndValue New xAxisEndValue value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.chart.FacetChart#setAxisEndValue
     */
    public FacetChart setXAxisEndValue(Date xAxisEndValue)  throws IllegalStateException {
        return (FacetChart)setAttribute("xAxisEndValue", xAxisEndValue, false);
    }

    /**
     * For Bubble and Scatter charts only, the end value for the x-axis. <p> If set to an explicit value, this will be
     * respected. If unset, the axis end value will default to a value large enough to show the largest data point. <P> If the
     * x-axis metric is date-valued, this value should be a date (typically applies to Scatter charts only).
     *
     * @return Current xAxisEndValue value. Default value is null
     * @see com.smartgwt.client.widgets.chart.FacetChart#getAxisEndValue
     */
    public Date getXAxisEndValueAsDate()  {
        return getAttributeAsDate("xAxisEndValue");
    }
    

    /**
     * For scatter charts only, the "id" of the metric facet value to use for the x-axis. <p> The default x-axis metric is the
     * second value of the metric facet.
     *
     * @param xAxisMetric New xAxisMetric value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setXAxisMetric(String xAxisMetric)  throws IllegalStateException {
        return (FacetChart)setAttribute("xAxisMetric", xAxisMetric, false);
    }

    /**
     * For scatter charts only, the "id" of the metric facet value to use for the x-axis. <p> The default x-axis metric is the
     * second value of the metric facet.
     *
     * @return Current xAxisMetric value. Default value is null
     */
    public String getXAxisMetric()  {
        return getAttributeAsString("xAxisMetric");
    }
    

    /**
     * For Bubble and Scatter charts only, the start value for the x-axis. <p> Defaults to 0, or to a value that makes good use
     * of horizontal space based on {@link com.smartgwt.client.widgets.chart.FacetChart#getMinXDataSpreadPercent
     * minXDataSpreadPercent}. <P> If the x-axis metric is date-valued, this value should be a date (typically applies to
     * Scatter charts only).
     *
     * @param xAxisStartValue New xAxisStartValue value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.chart.FacetChart#setAxisStartValue
     */
    public FacetChart setXAxisStartValue(Double xAxisStartValue)  throws IllegalStateException {
        return (FacetChart)setAttribute("xAxisStartValue", xAxisStartValue, false);
    }

    /**
     * For Bubble and Scatter charts only, the start value for the x-axis. <p> Defaults to 0, or to a value that makes good use
     * of horizontal space based on {@link com.smartgwt.client.widgets.chart.FacetChart#getMinXDataSpreadPercent
     * minXDataSpreadPercent}. <P> If the x-axis metric is date-valued, this value should be a date (typically applies to
     * Scatter charts only).
     *
     * @return Current xAxisStartValue value. Default value is null
     * @see com.smartgwt.client.widgets.chart.FacetChart#getAxisStartValue
     */
    public Double getXAxisStartValue()  {
        return getAttributeAsDouble("xAxisStartValue");
    }

    /**
     * For Bubble and Scatter charts only, the start value for the x-axis. <p> Defaults to 0, or to a value that makes good use
     * of horizontal space based on {@link com.smartgwt.client.widgets.chart.FacetChart#getMinXDataSpreadPercent
     * minXDataSpreadPercent}. <P> If the x-axis metric is date-valued, this value should be a date (typically applies to
     * Scatter charts only).
     *
     * @param xAxisStartValue New xAxisStartValue value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.chart.FacetChart#setAxisStartValue
     */
    public FacetChart setXAxisStartValue(Date xAxisStartValue)  throws IllegalStateException {
        return (FacetChart)setAttribute("xAxisStartValue", xAxisStartValue, false);
    }

    /**
     * For Bubble and Scatter charts only, the start value for the x-axis. <p> Defaults to 0, or to a value that makes good use
     * of horizontal space based on {@link com.smartgwt.client.widgets.chart.FacetChart#getMinXDataSpreadPercent
     * minXDataSpreadPercent}. <P> If the x-axis metric is date-valued, this value should be a date (typically applies to
     * Scatter charts only).
     *
     * @return Current xAxisStartValue value. Default value is null
     * @see com.smartgwt.client.widgets.chart.FacetChart#getAxisStartValue
     */
    public Date getXAxisStartValueAsDate()  {
        return getAttributeAsDate("xAxisStartValue");
    }
    

    /**
     * Horizontal alignment of y-axis labels, shown to the left of the chart.
     *
     * @param yAxisLabelAlign New yAxisLabelAlign value. Default value is "right"
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     */
    public FacetChart setYAxisLabelAlign(Alignment yAxisLabelAlign) {
        return (FacetChart)setAttribute("yAxisLabelAlign", yAxisLabelAlign == null ? null : yAxisLabelAlign.getValue(), true);
    }

    /**
     * Horizontal alignment of y-axis labels, shown to the left of the chart.
     *
     * @return Current yAxisLabelAlign value. Default value is "right"
     */
    public Alignment getYAxisLabelAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("yAxisLabelAlign"));
    }
    

    /**
     * Padding between each swatch and label pair.
     *
     * @param yAxisLabelPadding New yAxisLabelPadding value. Default value is 5
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setYAxisLabelPadding(int yAxisLabelPadding)  throws IllegalStateException {
        return (FacetChart)setAttribute("yAxisLabelPadding", yAxisLabelPadding, false);
    }

    /**
     * Padding between each swatch and label pair.
     *
     * @return Current yAxisLabelPadding value. Default value is 5
     */
    public int getYAxisLabelPadding()  {
        return getAttributeAsInt("yAxisLabelPadding");
    }
    

    /**
     * For scatter charts only, the "id" of the metric facet value to use for the y-axis. <p> The default y-axis metric is the
     * first value of the metric facet.
     *
     * @param yAxisMetric New yAxisMetric value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setYAxisMetric(String yAxisMetric)  throws IllegalStateException {
        return (FacetChart)setAttribute("yAxisMetric", yAxisMetric, false);
    }

    /**
     * For scatter charts only, the "id" of the metric facet value to use for the y-axis. <p> The default y-axis metric is the
     * first value of the metric facet.
     *
     * @return Current yAxisMetric value. Default value is null
     */
    public String getYAxisMetric()  {
        return getAttributeAsString("yAxisMetric");
    }
    

    /**
     * Specifies the attribute in the metric facet that will define the z-ordering of the segments in a histogram chart.  If
     * the z-ordering isn't specified, it will be assigned based on data order, with the last data point ordered above the
     * first.  Relative z-ordering is only important between segments within the same data label facet, since segments that
     * differ in their data label facet value should never overlap, <P> Note that zIndex values should be integers between 0
     * and {@link com.smartgwt.client.widgets.chart.FacetChart#getMaxDataZIndex maxDataZIndex}, inclusive, and don't directly
     * map to the {@link com.smartgwt.client.widgets.drawing.DrawItem#getZIndex DrawItem.zIndex} values of the underlying
     * {@link com.smartgwt.client.widgets.drawing.DrawRect}s.  This allows the Framework to use automatic z-ordering in the
     * chart logic without any additional sorting or overhead that would otherwise be required.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Method to change the current {@link com.smartgwt.client.widgets.chart.FacetChart#getZIndexMetric zIndexMetric} - see property for more details. Will redraw the chart if drawn.
     *
     * @param zIndexMetric name of zIndex metric. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.chart.FacetChart#setMetricFacetId
     * @see com.smartgwt.client.widgets.chart.FacetChart#setMaxDataZIndex
     * @see com.smartgwt.client.widgets.chart.FacetChart#getDataLabelFacet
     */
    public FacetChart setZIndexMetric(String zIndexMetric) {
        return (FacetChart)setAttribute("zIndexMetric", zIndexMetric, true);
    }

    /**
     * Specifies the attribute in the metric facet that will define the z-ordering of the segments in a histogram chart.  If
     * the z-ordering isn't specified, it will be assigned based on data order, with the last data point ordered above the
     * first.  Relative z-ordering is only important between segments within the same data label facet, since segments that
     * differ in their data label facet value should never overlap, <P> Note that zIndex values should be integers between 0
     * and {@link com.smartgwt.client.widgets.chart.FacetChart#getMaxDataZIndex maxDataZIndex}, inclusive, and don't directly
     * map to the {@link com.smartgwt.client.widgets.drawing.DrawItem#getZIndex DrawItem.zIndex} values of the underlying
     * {@link com.smartgwt.client.widgets.drawing.DrawRect}s.  This allows the Framework to use automatic z-ordering in the
     * chart logic without any additional sorting or overhead that would otherwise be required.
     *
     * @return Current zIndexMetric value. Default value is null
     * @see com.smartgwt.client.widgets.chart.FacetChart#getMetricFacetId
     * @see com.smartgwt.client.widgets.chart.FacetChart#getMaxDataZIndex
     * @see com.smartgwt.client.widgets.chart.FacetChart#getDataLabelFacet
     */
    public String getZIndexMetric()  {
        return getAttributeAsString("zIndexMetric");
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
     * This component is an AutoChild named "zoomChart".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current zoomChart value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public FacetChart getZoomChart() throws IllegalStateException {
        errorIfNotCreated("zoomChart");
        return (FacetChart)FacetChart.getByJSObject(getAttributeAsJavaScriptObject("zoomChart"));
    }
    

    /**
     * Height of the {@link com.smartgwt.client.widgets.chart.FacetChart#getZoomChart zoomChart}.  The zoomChart is always as
     * wide as the main chart.
     *
     * @param zoomChartHeight New zoomChartHeight value. Default value is 100
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setZoomChartHeight(double zoomChartHeight)  throws IllegalStateException {
        return (FacetChart)setAttribute("zoomChartHeight", zoomChartHeight, false);
    }

    /**
     * Height of the {@link com.smartgwt.client.widgets.chart.FacetChart#getZoomChart zoomChart}.  The zoomChart is always as
     * wide as the main chart.
     *
     * @return Current zoomChartHeight value. Default value is 100
     */
    public double getZoomChartHeight()  {
        return getAttributeAsDouble("zoomChartHeight");
    }
    

    /**
     * Properties to further configure the {@link com.smartgwt.client.widgets.chart.FacetChart#getZoomChart zoomChart}.
     *
     * @param zoomChartProperties New zoomChartProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public FacetChart setZoomChartProperties(FacetChart zoomChartProperties)  throws IllegalStateException {
        if (zoomChartProperties != null) {
            if (zoomChartProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setZoomChartProperties", "FacetChart");
            }                                                                       
            zoomChartProperties.setConfigOnly(true);
        }
        JavaScriptObject config = zoomChartProperties == null ? null : zoomChartProperties.getConfig();
        return (FacetChart)setAttribute("zoomChartProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties to further configure the {@link com.smartgwt.client.widgets.chart.FacetChart#getZoomChart zoomChart}.
     *
     * @return Current zoomChartProperties value. Default value is null
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
     * This component is an AutoChild named "zoomChartSlider".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current zoomChartSlider value. Default value is null
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
     * @param zoomLogScale New zoomLogScale value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setZoomLogScale(Boolean zoomLogScale)  throws IllegalStateException {
        return (FacetChart)setAttribute("zoomLogScale", zoomLogScale, false);
    }

    /**
     * By default when {@link com.smartgwt.client.widgets.chart.FacetChart#getCanZoom canZoom} is enabled, the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getZoomChart zoomChart} uses logarithmic scaling so that spikes in the data
     * don't result in a zoomed chart that is mostly a flat line. <P> Logarithmic scaling is automatically disabled if the
     * dataset spans zero (eg, has negative and positive values) as this can't be shown in a logarithmic scale. <P> Set
     * <code>zoomLogScale</code> to explicitly enable or disable logarithmic scaling.
     *
     * @return Current zoomLogScale value. Default value is null
     */
    public Boolean getZoomLogScale()  {
        return getAttributeAsBoolean("zoomLogScale");
    }
    

    /**
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getColorMutePercent colorMutePercent} to use for the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getZoomChart zoomChart}.
     *
     * @param zoomMutePercent New zoomMutePercent value. Default value is -35
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setZoomMutePercent(float zoomMutePercent)  throws IllegalStateException {
        return (FacetChart)setAttribute("zoomMutePercent", zoomMutePercent, false);
    }

    /**
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getColorMutePercent colorMutePercent} to use for the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getZoomChart zoomChart}.
     *
     * @return Current zoomMutePercent value. Default value is -35
     */
    public float getZoomMutePercent()  {
        return getAttributeAsFloat("zoomMutePercent");
    }
    

    /**
     * Mini-chart created when {@link com.smartgwt.client.widgets.chart.FacetChart#getCanZoom canZoom} is enabled.  This chart
     * represents the currently selected range of data shown in the main chart.
     * <p>
     * This component is an AutoChild named "zoomSelectionChart".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current zoomSelectionChart value. Default value is null
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
     * @param zoomSelectionChartProperties New zoomSelectionChartProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public FacetChart setZoomSelectionChartProperties(FacetChart zoomSelectionChartProperties)  throws IllegalStateException {
        if (zoomSelectionChartProperties != null) {
            if (zoomSelectionChartProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(FacetChart.class, "setZoomSelectionChartProperties", "FacetChart");
            }                                                                       
            zoomSelectionChartProperties.setConfigOnly(true);
        }
        JavaScriptObject config = zoomSelectionChartProperties == null ? null : zoomSelectionChartProperties.getConfig();
        return (FacetChart)setAttribute("zoomSelectionChartProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties to further configure the {@link com.smartgwt.client.widgets.chart.FacetChart#getZoomSelectionChart
     * zoomSelectionChart}.
     *
     * @return Current zoomSelectionChartProperties value. Default value is null
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
     * @param zoomShowSelection New zoomShowSelection value. Default value is true
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setZoomShowSelection(Boolean zoomShowSelection)  throws IllegalStateException {
        return (FacetChart)setAttribute("zoomShowSelection", zoomShowSelection, false);
    }

    /**
     * Whether the selected range should be shown in a different style, which can be configured via {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getZoomSelectionChartProperties zoomSelectionChartProperties}.  This has
     * performance consequences and makes the rendering of the mini-chart slightly slower.
     *
     * @return Current zoomShowSelection value. Default value is true
     */
    public Boolean getZoomShowSelection()  {
        Boolean result = getAttributeAsBoolean("zoomShowSelection");
        return result == null ? true : result;
    }
    

    /**
     * For a {@link com.smartgwt.client.widgets.chart.FacetChart#getCanZoom zoomed chart}, determines what portion of the
     * overall dataset should be initially shown in the main chart. <P> Default is to show the end of the dataset if the X axis
     * shows time and includes today's date, otherwise to show the start of the dataset. <P> Set this property to override this
     * default, or use {@link com.smartgwt.client.widgets.chart.FacetChart#getZoomStartValue zoomStartValue} and {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getZoomEndValue zoomEndValue} to start with a particular range.
     *
     * @param zoomStartPosition New zoomStartPosition value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.FacetChart FacetChart} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FacetChart setZoomStartPosition(ZoomStartPosition zoomStartPosition)  throws IllegalStateException {
        return (FacetChart)setAttribute("zoomStartPosition", zoomStartPosition == null ? null : zoomStartPosition.getValue(), false);
    }

    /**
     * For a {@link com.smartgwt.client.widgets.chart.FacetChart#getCanZoom zoomed chart}, determines what portion of the
     * overall dataset should be initially shown in the main chart. <P> Default is to show the end of the dataset if the X axis
     * shows time and includes today's date, otherwise to show the start of the dataset. <P> Set this property to override this
     * default, or use {@link com.smartgwt.client.widgets.chart.FacetChart#getZoomStartValue zoomStartValue} and {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getZoomEndValue zoomEndValue} to start with a particular range.
     *
     * @return Current zoomStartPosition value. Default value is null
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
     * com.smartgwt.client.widgets.chart.FacetChart#getChartLeft FacetChart.getChartLeft()}) may return bad values if called at
     * other times. <P> Additional DrawItems added in this method will appear underneath data elements such as bars or columns.
     * See {@link com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn()} for placing
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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var chartBackgroundDrawn = $entry(function(){
            var param = {"_this": this};
            var event = @com.smartgwt.client.widgets.chart.ChartBackgroundDrawnEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.chart.FacetChart::handleTearDownChartBackgroundDrawnEvent()();
            if (hasDefaultHandler) this.Super("chartBackgroundDrawn", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("chartBackgroundDrawn"));
            obj.addProperties({chartBackgroundDrawn:  chartBackgroundDrawn              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("chartBackgroundDrawn"));
            obj.chartBackgroundDrawn =  chartBackgroundDrawn             ;
        }
    }-*/;

    private void handleTearDownChartBackgroundDrawnEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.chart.ChartBackgroundDrawnEvent.getType()) == 0) tearDownChartBackgroundDrawnEvent();
    }

    private native void tearDownChartBackgroundDrawnEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("chartBackgroundDrawn")) delete obj.chartBackgroundDrawn;
    }-*/;

    /**
     * Add a chartDrawn handler.
     * <p>
     * Called when all elements of the chart (data lines / shapes, gradations, legend, labels etc) have completed drawing.  
     * <P> See {@link com.smartgwt.client.widgets.chart.FacetChart#addChartBackgroundDrawnHandler
     * FacetChart.chartBackgroundDrawn()} for usage information.
     *
     * @param handler the chartDrawn handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addChartDrawnHandler(com.smartgwt.client.widgets.chart.ChartDrawnHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.chart.ChartDrawnEvent.getType()) == 0) setupChartDrawnEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.chart.ChartDrawnEvent.getType());
    }

    private native void setupChartDrawnEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var chartDrawn = $entry(function(){
            var param = {"_this": this};
            var event = @com.smartgwt.client.widgets.chart.ChartDrawnEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.chart.FacetChart::handleTearDownChartDrawnEvent()();
            if (hasDefaultHandler) this.Super("chartDrawn", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("chartDrawn"));
            obj.addProperties({chartDrawn:  chartDrawn              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("chartDrawn"));
            obj.chartDrawn =  chartDrawn             ;
        }
    }-*/;

    private void handleTearDownChartDrawnEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.chart.ChartDrawnEvent.getType()) == 0) tearDownChartDrawnEvent();
    }

    private native void tearDownChartDrawnEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("chartDrawn")) delete obj.chartDrawn;
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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var dataLabelClick = $entry(function(){
            var param = {"_this": this, "facetValue" : arguments[0]};
            var event = @com.smartgwt.client.widgets.chart.DataLabelClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.chart.FacetChart::handleTearDownDataLabelClickEvent()();
            if (hasDefaultHandler) this.Super("dataLabelClick", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("dataLabelClick"));
            obj.addProperties({dataLabelClick:  dataLabelClick              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("dataLabelClick"));
            obj.dataLabelClick =  dataLabelClick             ;
        }
    }-*/;

    private void handleTearDownDataLabelClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.chart.DataLabelClickEvent.getType()) == 0) tearDownDataLabelClickEvent();
    }

    private native void tearDownDataLabelClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("dataLabelClick")) delete obj.dataLabelClick;
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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var dataLabelHover = $entry(function(){
            var param = {"_this": this, "facetValue" : arguments[0]};
            var event = @com.smartgwt.client.widgets.chart.DataLabelHoverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.chart.FacetChart::handleTearDownDataLabelHoverEvent()();
            if (hasDefaultHandler) this.Super("dataLabelHover", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("dataLabelHover"));
            obj.addProperties({dataLabelHover:  dataLabelHover              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("dataLabelHover"));
            obj.dataLabelHover =  dataLabelHover             ;
        }
    }-*/;

    private void handleTearDownDataLabelHoverEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.chart.DataLabelHoverEvent.getType()) == 0) tearDownDataLabelHoverEvent();
    }

    private native void tearDownDataLabelHoverEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("dataLabelHover")) delete obj.dataLabelHover;
    }-*/;

	/**
     * Returns whether a given {@link com.smartgwt.client.widgets.chart.DrawnValue} contains a point. The point's X and Y
     * coordinates may be passed into this method, or, if unspecified, the coordinates used are the current mouse event
     * coordinates. <p> For Area, Bubble, Line, Radar, and Scatter charts, a DrawnValue is considered to contain a point if the
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "drawnValueContainsPoint", "DrawnValue");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.drawnValueContainsPoint(drawnValue.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

    /**
     * @see FacetChart#drawnValueContainsPoint
     */
    public Boolean drawnValueContainsPoint(DrawnValue drawnValue, Integer x){
        return drawnValueContainsPoint(drawnValue, x, (Integer) null);
    }

	/**
     * Returns whether a given {@link com.smartgwt.client.widgets.chart.DrawnValue} contains a point. The point's X and Y
     * coordinates may be passed into this method, or, if unspecified, the coordinates used are the current mouse event
     * coordinates. <p> For Area, Bubble, Line, Radar, and Scatter charts, a DrawnValue is considered to contain a point if the
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "drawnValueContainsPoint", "DrawnValue,Integer,Integer");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.drawnValueContainsPoint(drawnValue.@com.smartgwt.client.core.DataClass::getJsObj()(), x == null ? null : x.@java.lang.Integer::intValue()(), y == null ? null : y.@java.lang.Integer::intValue()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;
	
	/**
     * Return the text string to display for facet value labels that appear in chart legends or as labels for {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getChartType chartType}s that have circumference or non-axis labels, such
     * as for example "Pie" or "Radar" charts.
     * @param value raw value of the metric
     * @param facet facet containing the value
     *
     * @return the text to display.
     * @see com.smartgwt.client.widgets.chart.FacetChart#setXAxisValueFormatter
     * @see com.smartgwt.client.widgets.chart.FacetChart#getFormatStringFacetValueIds
     */
    public native String formatFacetValueId(Object value, Facet facet) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "formatFacetValueId", "Object,Facet");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.formatFacetValueId(value, facet.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;

	/**
     * Defines the format of the label for a segment in a histogram chart.  By default, it simply returns a label of the form
     * "Y1 to Y2" describing the start and end values, applying {@link
     * com.smartgwt.client.widgets.chart.FacetChart#setDataValueFormatter setDataValueFormatter()} to format the values.       
     * <P> Note that this method has no impact on the facet value labels appearing on the horizontal axis of the histogram
     * chart.
     * @param startValue raw start value of the segment
     * @param endValue raw end value of the segment
     *
     * @return the text to display.
     */
    public native String formatSegmentLabel(Object startValue, Object endValue) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "formatSegmentLabel", "Object,Object");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.formatSegmentLabel(startValue, endValue);
        return ret;
    }-*/;

	/**
     * Returns the centerpoint for radar charts and pie charts. <P> Note that unstacked pie charts draw multiple pies, each
     * with their own centers. <P> This is only allowed to be called when {@link
     * com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn()} fires.
     *
     * @return the centerpoint for radar charts and pie charts.
     */
    public native Point getChartCenter() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getChartCenter", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getChartCenter();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.drawing.Point::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Get the height the central chart area, where data elements appear. <P>  This is only allowed to be called when {@link
     * com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn()} fires.
     * @param recalc if false then cached value will be returned,  otherwise will be recalculated.
     *
     * @return the width of the central chart area.
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public native float getChartHeight(boolean recalc) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getChartHeight", "boolean");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getChartHeight(recalc);
        return ret;
    }-*/;

	/**
     * Get the height the central chart area, where data elements appear. <P>  This is only allowed to be called when {@link
     * com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn()} fires.
     * @param recalc if false then cached value will be returned,  otherwise will be recalculated.
     *
     * @return the width of the central chart area.
     */
    public native double getChartHeightAsDouble(boolean recalc) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getChartHeightAsDouble", "boolean");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getChartHeight(recalc);
        return ret;
    }-*/;

	/**
     * Get the left margin of the central chart area, where data elements appear. <P>  This is only allowed to be called when
     * {@link com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn()} fires.
     *
     * @return left margin of the central chart area
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public native float getChartLeft() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getChartLeft", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getChartLeft();
        return ret;
    }-*/;

	/**
     * Get the left margin of the central chart area, where data elements appear. <P>  This is only allowed to be called when
     * {@link com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn()} fires.
     *
     * @return left margin of the central chart area
     */
    public native double getChartLeftAsDouble() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getChartLeftAsDouble", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getChartLeft();
        return ret;
    }-*/;

	/**
     * Returns the radius for radar charts and pie charts.  For stacked pie charts this is radius of the outermost pie. <P>
     * Note that unstacked pie charts draw multiple pies, each with their own radii. <P> This is only allowed to be called when
     * {@link com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn()} fires.
     *
     * @return the radius for radar charts and pie charts.
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public native float getChartRadius() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getChartRadius", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getChartRadius();
        return ret;
    }-*/;

	/**
     * Returns the radius for radar charts and pie charts.  For stacked pie charts this is radius of the outermost pie. <P>
     * Note that unstacked pie charts draw multiple pies, each with their own radii. <P> This is only allowed to be called when
     * {@link com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn()} fires.
     *
     * @return the radius for radar charts and pie charts.
     */
    public native double getChartRadiusAsDouble() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getChartRadiusAsDouble", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getChartRadius();
        return ret;
    }-*/;

	/**
     * Get the top coordinate of the central chart area, where data elements appear.  <P> This is only allowed to be called
     * when {@link com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn()} fires.
     *
     * @return The top coordinate of the central chart area
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public native float getChartTop() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getChartTop", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getChartTop();
        return ret;
    }-*/;

	/**
     * Get the top coordinate of the central chart area, where data elements appear.  <P> This is only allowed to be called
     * when {@link com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn()} fires.
     *
     * @return The top coordinate of the central chart area
     */
    public native double getChartTopAsDouble() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getChartTopAsDouble", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getChartTop();
        return ret;
    }-*/;

	/**
     * Get the width of the central chart area, where data elements appear. <P>  This is only allowed to be called when {@link
     * com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn()} fires.
     * @param recalc if false then cached value will be returned,  otherwise will be recalculated.
     *
     * @return the width of the central chart area.
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public native float getChartWidth(boolean recalc) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getChartWidth", "boolean");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getChartWidth(recalc);
        return ret;
    }-*/;

	/**
     * Get the width of the central chart area, where data elements appear. <P>  This is only allowed to be called when {@link
     * com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn()} fires.
     * @param recalc if false then cached value will be returned,  otherwise will be recalculated.
     *
     * @return the width of the central chart area.
     */
    public native double getChartWidthAsDouble(boolean recalc) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getChartWidthAsDouble", "boolean");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getChartWidth(recalc);
        return ret;
    }-*/;

	/**
     * Returns the {@link com.smartgwt.client.widgets.cube.Facet} in the list of {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getFacets facets} whose {@link
     * com.smartgwt.client.widgets.cube.Facet#getValues values} are rendered as labels along the data axis of the chart or in
     * the main chart area. <p> Most single-facet charts and all multi-facet charts have the data label facet as their first
     * facet.  The exceptions are that single-facet Pie/Doughnut charts and Bubble and Scatter charts do not have data label
     * facets. <p> Note that the user may swap the data label facet and the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getLegendFacet legend facet} in most chart types using the context menu.
     *
     * @return the data label facet, or <code>null</code> if there is no such facet
     * @see com.smartgwt.client.widgets.chart.FacetChart#getFacets
     */
    public native Facet getDataLabelFacet() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getDataLabelFacet", "");
        }
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
     * @return hover text to be shown.  Return null to avoid a hover being shown.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#drillCharting" target="examples">Drill Up/Down Example</a>
     */
    public native String getDataLabelHoverHTML(FacetValue facetValue) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getDataLabelHoverHTML", "FacetValue");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDataLabelHoverHTML(facetValue.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;

	/**
     * Returns rendering information for the data value specified by the passed facet values. <p> If called before {@link
     * com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn()}, logs a warning and returns
     * null.
     * @param facetValues facet values of desired data value
     *
     * @return the drawn value, or null for invalid arguments / incorrect timing                   of call
     */
    public native DrawnValue getDrawnValue(FacetValueMap facetValues) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getDrawnValue", "FacetValueMap");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDrawnValue(facetValues == null ? null : facetValues.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.chart.DrawnValue::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns a {@link com.smartgwt.client.widgets.chart.DrawnValue} object for the data value that is shown nearest to the
     * passed coordinates only if it's under the given coordinates, or under the current mouse event coordinates if no
     * coordinates are passed. This method is similar to {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getNearestDrawnValue getNearestDrawnValue()}, but the DrawnValue is only
     * returned if it's under the coordinates. <p> See {@link
     * com.smartgwt.client.widgets.chart.FacetChart#drawnValueContainsPoint drawnValueContainsPoint()} for the criteria that
     * determine whether a DrawnValue is under (contains) the coordinates.
     *
     * @return the nearest drawn value if under the given coordinates (or current mouse event coordinates) or null if not under the
     * coordinates, or for invalid arguments / incorrect timing of call.
     */
    public native DrawnValue getDrawnValueAtPoint() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getDrawnValueAtPoint", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDrawnValueAtPoint();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.chart.DrawnValue::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * @see FacetChart#getDrawnValueAtPoint
     */
    public DrawnValue getDrawnValueAtPoint(Integer x){
        return getDrawnValueAtPoint(x, (Integer) null, null);
    }

    /**
     * @see FacetChart#getDrawnValueAtPoint
     */
    public DrawnValue getDrawnValueAtPoint(Integer x, Integer y){
        return getDrawnValueAtPoint(x, y, null);
    }

	/**
     * Returns a {@link com.smartgwt.client.widgets.chart.DrawnValue} object for the data value that is shown nearest to the
     * passed coordinates only if it's under the given coordinates, or under the current mouse event coordinates if no
     * coordinates are passed. This method is similar to {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getNearestDrawnValue getNearestDrawnValue()}, but the DrawnValue is only
     * returned if it's under the coordinates. <p> See {@link
     * com.smartgwt.client.widgets.chart.FacetChart#drawnValueContainsPoint drawnValueContainsPoint()} for the criteria that
     * determine whether a DrawnValue is under (contains) the coordinates.
     * @param x X coordinate. If this parameter is specified, then <code>y</code> is a required parameter.
     * @param y Y coordinate
     * @param metric metric over which to determine the drawn value
     *
     * @return the nearest drawn value if under the given coordinates (or current mouse event coordinates) or null if not under the
     * coordinates, or for invalid arguments / incorrect timing of call.
     */
    public native DrawnValue getDrawnValueAtPoint(Integer x, Integer y, String metric) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getDrawnValueAtPoint", "Integer,Integer,String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDrawnValueAtPoint(x == null ? null : x.@java.lang.Integer::intValue()(), y == null ? null : y.@java.lang.Integer::intValue()(), metric);
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.chart.DrawnValue::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	
	/**
     * Returns rendering information for the data values specified by the passed facet values. <p> If called before {@link
     * com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn()}, logs a warning and returns
     * null.
     *
     * @return the DrawnValues, or null for invalid arguments / incorrect timing of call
     */
    public native DrawnValue[] getDrawnValues() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getDrawnValues", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDrawnValues();
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfDrawnValue(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns rendering information for the data values specified by the passed facet values. <p> If called before {@link
     * com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn()}, logs a warning and returns
     * null.
     * @param facetValues facet values of desired DrawnValues. If no FacetValueMap is provided, then all DrawnValues are returned.
     *
     * @return the DrawnValues, or null for invalid arguments / incorrect timing of call
     */
    public native DrawnValue[] getDrawnValues(FacetValueMap facetValues) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getDrawnValues", "FacetValueMap");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDrawnValues(facetValues == null ? null : facetValues.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfDrawnValue(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	
	/**
     * Returns an array of {@link com.smartgwt.client.widgets.chart.DrawnValue} objects for the data values of each metric that
     * are shown nearest to the passed coordinates, but only if they're under the given coordinates, or under the current mouse
     * event coordinates if no coordinates are passed. This method is similar to {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getNearestDrawnValues getNearestDrawnValues()}, but DrawnValues are only
     * included in the returned array if they're under the coordinates. <p> See {@link
     * com.smartgwt.client.widgets.chart.FacetChart#drawnValueContainsPoint drawnValueContainsPoint()} for the criteria that
     * determine whether a DrawnValue is under (contains) the coordinates.
     *
     * @return the nearest DrawnValues that are under the given coordinates (or current mouse event coordinates), or null for invalid
     * arguments / incorrect timing of call.
     */
    public native DrawnValue[] getDrawnValuesAtPoint() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getDrawnValuesAtPoint", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDrawnValuesAtPoint();
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfDrawnValue(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * @see FacetChart#getDrawnValuesAtPoint
     */
    public DrawnValue[] getDrawnValuesAtPoint(Integer x){
        return getDrawnValuesAtPoint(x, (Integer) null);
    }

	/**
     * Returns an array of {@link com.smartgwt.client.widgets.chart.DrawnValue} objects for the data values of each metric that
     * are shown nearest to the passed coordinates, but only if they're under the given coordinates, or under the current mouse
     * event coordinates if no coordinates are passed. This method is similar to {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getNearestDrawnValues getNearestDrawnValues()}, but DrawnValues are only
     * included in the returned array if they're under the coordinates. <p> See {@link
     * com.smartgwt.client.widgets.chart.FacetChart#drawnValueContainsPoint drawnValueContainsPoint()} for the criteria that
     * determine whether a DrawnValue is under (contains) the coordinates.
     * @param x X coordinate. If this parameter is specified, then <code>y</code> is a required parameter.
     * @param y Y coordinate
     *
     * @return the nearest DrawnValues that are under the given coordinates (or current mouse event coordinates), or null for invalid
     * arguments / incorrect timing of call.
     */
    public native DrawnValue[] getDrawnValuesAtPoint(Integer x, Integer y) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getDrawnValuesAtPoint", "Integer,Integer");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getFacet", "String");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getFacetValue", "String,String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getFacetValue(facetId, facetValueId);
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.cube.FacetValue::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Return an array of the gradation values used in the current chart.  Pass these values to {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getXCoord getXCoord()} / {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getYCoord getYCoord()} (depending on the orientation of the chart) to
     * discover the coordinates where gradations are drawn. <P> This is only allowed to be called when {@link
     * com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn()} fires.
     *
     * @return an array of gradation values used in the current chart.
     */
    public native float[] getGradations() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getGradations", "");
        }
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
     * first facet and Bubble and Scatter charts may optionally have a legend facet as the second facet, after the metric
     * facet. <p> In all multi-facet charts, the legend facet is the second facet. <p> Note that the user may swap the legend
     * facet and the {@link com.smartgwt.client.widgets.chart.FacetChart#getDataLabelFacet data label facet} in most chart
     * types using the context menu.
     *
     * @return the legend facet, or <code>null</code> if there is no such facet
     * @see com.smartgwt.client.widgets.chart.FacetChart#getFacets
     */
    public native Facet getLegendFacet() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getLegendFacet", "");
        }
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
     * @return hover text to be shown.  Return null to avoid a hover being shown.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#drillCharting" target="examples">Drill Up/Down Example</a>
     */
    public native String getLegendHoverHTML(FacetValue facetValue, FacetValue metricFacetValue) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getLegendHoverHTML", "FacetValue,FacetValue");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getLegendHoverHTML(facetValue.@com.smartgwt.client.core.DataClass::getJsObj()(), metricFacetValue.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;

	/**
     * Returns rendering information for the data value that is shown nearest to the passed coordinates, as a {@link
     * com.smartgwt.client.widgets.chart.DrawnValue} object. <p> Passed X and Y coordinates should be relative to the
     * FacetChart.  If neither an X or Y coordinate is passed, both X and Y will use the current {@link
     * com.smartgwt.client.widgets.Canvas#getOffsetX Canvas.getOffsetX()} and {@link
     * com.smartgwt.client.widgets.Canvas#getOffsetY Canvas.getOffsetY()}. <p> If called before {@link
     * com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn()}, logs a warning and returns
     * null.  For a chart with multiple vertical axes, returns the nearest point from the first metric only (see {@link
     * com.smartgwt.client.widgets.chart.FacetChart FacetChart overview}).  For scatter charts, returns a DrawnValue where the
     * {@link com.smartgwt.client.widgets.chart.DrawnValue#getValue value} is from the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getYAxisMetric y-axis metric}. <p> To get the nearest DrawnValue only if it
     * contains the given coordinates, you can either use the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getDrawnValueAtPoint getDrawnValueAtPoint()} API or call {@link
     * com.smartgwt.client.widgets.chart.FacetChart#drawnValueContainsPoint drawnValueContainsPoint()} on the return value. <p>
     * Behavior for different chart types is as follows: <p> <h4>Bar / Column</h4> <p> Returns the centerpoint of the end of
     * the nearest bar or column by considering the Y coordinate (bar) or X coordinate (column) only. <p> <h4>Line / Area</h4>
     * <p> Returns the nearest point based on which data label is nearest to the passed X coordinate. For multi-series charts,
     * if Y coordinate is not passed the data point returned is from the series that has the highest value at the data label.
     * <p> <h4>Radar</h4> <p> Returns the data point nearest the passed coordinates by straight line distance. Passing only one
     * coordinate will cause a warning to be logged and null to be returned; passing neither coordinate is allowed
     * (<code>getOffsetX/Y</code> will be used). <p> <h4>Pie</h4> <p> Returns the data point for the segment that would be hit
     * if a line were drawn from the passed coordinates to the center of the pie. <p> If there are multiple stacked pies, uses
     * the pie that contains the passed coordinates, otherwise the outermost pie. <p> If there are multiple non-stacked pies,
     * uses the pie that is nearest the passed coordinates by straight-line distance to the center of the pie. <p> Passing only
     * one coordinate will cause a warning to be logged and null to be returned; passing neither coordinate is allowed
     * (<code>getOffsetX/Y</code> will be used). <p> If the chart is a {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics multi-axis chart} then this method takes an optional
     * parameter, <code>metric</code>, which causes this method to return a <code>DrawnValue</code> from the specified metric. 
     * If a metric is not passed then the first metric of the metric facet will be used (or just the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getValueProperty valueProperty} if there is no metric facet).
     *
     * @return the nearest drawn value, or null for invalid arguments / incorrect timing                  of call
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#chartCustomHovers" target="examples">Custom Hovers Example</a>
     */
    public native DrawnValue getNearestDrawnValue() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getNearestDrawnValue", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getNearestDrawnValue();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.chart.DrawnValue::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * @see FacetChart#getNearestDrawnValue
     */
    public DrawnValue getNearestDrawnValue(Integer x){
        return getNearestDrawnValue(x, (Integer) null, null);
    }

    /**
     * @see FacetChart#getNearestDrawnValue
     */
    public DrawnValue getNearestDrawnValue(Integer x, Integer y){
        return getNearestDrawnValue(x, y, null);
    }

	/**
     * Returns rendering information for the data value that is shown nearest to the passed coordinates, as a {@link
     * com.smartgwt.client.widgets.chart.DrawnValue} object. <p> Passed X and Y coordinates should be relative to the
     * FacetChart.  If neither an X or Y coordinate is passed, both X and Y will use the current {@link
     * com.smartgwt.client.widgets.Canvas#getOffsetX Canvas.getOffsetX()} and {@link
     * com.smartgwt.client.widgets.Canvas#getOffsetY Canvas.getOffsetY()}. <p> If called before {@link
     * com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn()}, logs a warning and returns
     * null.  For a chart with multiple vertical axes, returns the nearest point from the first metric only (see {@link
     * com.smartgwt.client.widgets.chart.FacetChart FacetChart overview}).  For scatter charts, returns a DrawnValue where the
     * {@link com.smartgwt.client.widgets.chart.DrawnValue#getValue value} is from the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getYAxisMetric y-axis metric}. <p> To get the nearest DrawnValue only if it
     * contains the given coordinates, you can either use the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getDrawnValueAtPoint getDrawnValueAtPoint()} API or call {@link
     * com.smartgwt.client.widgets.chart.FacetChart#drawnValueContainsPoint drawnValueContainsPoint()} on the return value. <p>
     * Behavior for different chart types is as follows: <p> <h4>Bar / Column</h4> <p> Returns the centerpoint of the end of
     * the nearest bar or column by considering the Y coordinate (bar) or X coordinate (column) only. <p> <h4>Line / Area</h4>
     * <p> Returns the nearest point based on which data label is nearest to the passed X coordinate. For multi-series charts,
     * if Y coordinate is not passed the data point returned is from the series that has the highest value at the data label.
     * <p> <h4>Radar</h4> <p> Returns the data point nearest the passed coordinates by straight line distance. Passing only one
     * coordinate will cause a warning to be logged and null to be returned; passing neither coordinate is allowed
     * (<code>getOffsetX/Y</code> will be used). <p> <h4>Pie</h4> <p> Returns the data point for the segment that would be hit
     * if a line were drawn from the passed coordinates to the center of the pie. <p> If there are multiple stacked pies, uses
     * the pie that contains the passed coordinates, otherwise the outermost pie. <p> If there are multiple non-stacked pies,
     * uses the pie that is nearest the passed coordinates by straight-line distance to the center of the pie. <p> Passing only
     * one coordinate will cause a warning to be logged and null to be returned; passing neither coordinate is allowed
     * (<code>getOffsetX/Y</code> will be used). <p> If the chart is a {@link
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getNearestDrawnValue", "Integer,Integer,String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getNearestDrawnValue(x == null ? null : x.@java.lang.Integer::intValue()(), y == null ? null : y.@java.lang.Integer::intValue()(), metric);
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.chart.DrawnValue::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	
	/**
     * Returns an array of {@link com.smartgwt.client.widgets.chart.DrawnValue} objects containing rendering information for
     * the data values having each metric that are shown nearest to the passed coordinates. <P> Passed X and Y coordinates
     * should be relative to the FacetChart.  If neither an X or Y coordinate is passed, both X and Y will use the current
     * {@link com.smartgwt.client.widgets.Canvas#getOffsetX Canvas.getOffsetX()} and {@link
     * com.smartgwt.client.widgets.Canvas#getOffsetY Canvas.getOffsetY()}. <P> The behavior for different chart types is the
     * same as {@link com.smartgwt.client.widgets.chart.FacetChart#getNearestDrawnValue getNearestDrawnValue()}.  This method
     * also logs a warning and returns null if called before {@link
     * com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn()}. <p> To get the nearest
     * DrawnValues only if they contain the given coordinates, you can either use the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getDrawnValuesAtPoint getDrawnValuesAtPoint()} API or check whether each
     * DrawnValue in the returned array contains the point by calling {@link
     * com.smartgwt.client.widgets.chart.FacetChart#drawnValueContainsPoint drawnValueContainsPoint()}.
     *
     * @return the nearest drawn values for each metric, or null for invalid arguments / incorrect timing of call
     * @see com.smartgwt.client.widgets.chart.FacetChart#getDrawnValuesAtPoint
     */
    public native DrawnValue[] getNearestDrawnValues() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getNearestDrawnValues", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getNearestDrawnValues();
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfDrawnValue(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * @see FacetChart#getNearestDrawnValues
     */
    public DrawnValue[] getNearestDrawnValues(Integer x){
        return getNearestDrawnValues(x, (Integer) null);
    }

	/**
     * Returns an array of {@link com.smartgwt.client.widgets.chart.DrawnValue} objects containing rendering information for
     * the data values having each metric that are shown nearest to the passed coordinates. <P> Passed X and Y coordinates
     * should be relative to the FacetChart.  If neither an X or Y coordinate is passed, both X and Y will use the current
     * {@link com.smartgwt.client.widgets.Canvas#getOffsetX Canvas.getOffsetX()} and {@link
     * com.smartgwt.client.widgets.Canvas#getOffsetY Canvas.getOffsetY()}. <P> The behavior for different chart types is the
     * same as {@link com.smartgwt.client.widgets.chart.FacetChart#getNearestDrawnValue getNearestDrawnValue()}.  This method
     * also logs a warning and returns null if called before {@link
     * com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn()}. <p> To get the nearest
     * DrawnValues only if they contain the given coordinates, you can either use the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getDrawnValuesAtPoint getDrawnValuesAtPoint()} API or check whether each
     * DrawnValue in the returned array contains the point by calling {@link
     * com.smartgwt.client.widgets.chart.FacetChart#drawnValueContainsPoint drawnValueContainsPoint()}.
     * @param x X coordinate. If this parameter is specified, then <code>y</code> is a required parameter.
     * @param y Y coordinate
     *
     * @return the nearest drawn values for each metric, or null for invalid arguments / incorrect timing of call
     * @see com.smartgwt.client.widgets.chart.FacetChart#getDrawnValuesAtPoint
     */
    public native DrawnValue[] getNearestDrawnValues(Integer x, Integer y) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getNearestDrawnValues", "Integer,Integer");
        }
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
    public native Integer getNumDataPoints() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getNumDataPoints", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getNumDataPoints();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toInteger(I)(ret);
    }-*/;

	/**
     * Count the number of data points.
     * @param criteria a set of facetValues describing a slice of the data
     *
     * @return the number of data values
     */
    public native Integer getNumDataPoints(FacetValueMap criteria) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getNumDataPoints", "FacetValueMap");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getNumDataPoints(criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toInteger(I)(ret);
    }-*/;
	
	/**
     * For scatter plots only, get a Function from the specified independent variable X to the specified dependent variable Y
     * that defines the polynomial that best fits the data. See <a
     * href="http://en.wikipedia.org/wiki/Polynomial_regression">http://en.wikipedia.org/wiki/Polynomial_regression</a>.
     */
    public native void getPolynomialRegressionFunction() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getPolynomialRegressionFunction", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.getPolynomialRegressionFunction();
    }-*/;

    /**
     * @see FacetChart#getPolynomialRegressionFunction
     */
    public void getPolynomialRegressionFunction(Integer degree){
        getPolynomialRegressionFunction(degree, null, null);
    }

    /**
     * @see FacetChart#getPolynomialRegressionFunction
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getPolynomialRegressionFunction", "Integer,String,String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.getPolynomialRegressionFunction(degree == null ? null : degree.@java.lang.Integer::intValue()(), xMetric, yMetric);
    }-*/;
	
	/**
     * For scatter plots only, get a Function from the specified independent variable X to the specified dependent variable Y
     * that defines the line that best fits the data. See <a
     * href="http://en.wikipedia.org/wiki/Simple_linear_regression">http://en.wikipedia.org/wiki/Simple_linear_regression</a>.
     */
    public native void getSimpleLinearRegressionFunction() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSimpleLinearRegressionFunction", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.getSimpleLinearRegressionFunction();
    }-*/;

    /**
     * @see FacetChart#getSimpleLinearRegressionFunction
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSimpleLinearRegressionFunction", "String,String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.getSimpleLinearRegressionFunction(xMetric, yMetric);
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
    public native float getXCoord(double value) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getXCoord", "double");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
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
    public native float getXCoord(FacetValueMap value) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getXCoord", "FacetValueMap");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getXCoord(value == null ? null : value.@com.smartgwt.client.core.DataClass::getJsObj()());
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
    public native float getYCoord(double value) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getYCoord", "double");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
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
    public native float getYCoord(FacetValueMap value) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getYCoord", "FacetValueMap");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getYCoord(value == null ? null : value.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var legendClick = $entry(function(){
            var param = {"_this": this, "facetValue" : arguments[0], "metricFacetValue" : arguments[1]};
            var event = @com.smartgwt.client.widgets.chart.LegendClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.chart.FacetChart::handleTearDownLegendClickEvent()();
            if (hasDefaultHandler) this.Super("legendClick", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("legendClick"));
            obj.addProperties({legendClick:  legendClick              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("legendClick"));
            obj.legendClick =  legendClick             ;
        }
    }-*/;

    private void handleTearDownLegendClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.chart.LegendClickEvent.getType()) == 0) tearDownLegendClickEvent();
    }

    private native void tearDownLegendClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("legendClick")) delete obj.legendClick;
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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var legendHover = $entry(function(){
            var param = {"_this": this, "facetValue" : arguments[0], "metricFacetValue" : arguments[1]};
            var event = @com.smartgwt.client.widgets.chart.LegendHoverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.chart.FacetChart::handleTearDownLegendHoverEvent()();
            if (hasDefaultHandler) this.Super("legendHover", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("legendHover"));
            obj.addProperties({legendHover:  legendHover              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("legendHover"));
            obj.legendHover =  legendHover             ;
        }
    }-*/;

    private void handleTearDownLegendHoverEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.chart.LegendHoverEvent.getType()) == 0) tearDownLegendHoverEvent();
    }

    private native void tearDownLegendHoverEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("legendHover")) delete obj.legendHover;
    }-*/;

    /**
     * Add a valueClick handler.
     * <p>
     * Fires when a data value is clicked, and provides information about the data value that was clicked as a {@link
     * com.smartgwt.client.widgets.chart.DrawnValue} object. <p> Specifically, this fires for clicks on pie slices, bars or
     * columns, areas, lines or points (in a Bubble or Scatter plot). <p> If there are multiple data values at the clicked
     * position, you can use {@link com.smartgwt.client.widgets.chart.FacetChart#getNearestDrawnValues
     * FacetChart.getNearestDrawnValues()} to discover the full list of values at the current coordinate (pass in {@link
     * com.smartgwt.client.widgets.Canvas#getOffsetX getOffsetX/Y()} for the coordinates). <p> If you want to create behaviors
     * for clicking or moving <i>near</i> shapes without requiring a direct hit, implement a standard {@link
     * com.smartgwt.client.widgets.Canvas#addClickHandler Canvas.click()} handler on the FacetChart as a whole and use {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getNearestDrawnValue FacetChart.getNearestDrawnValue()} to discover the
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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var valueClick = $entry(function(){
            var param = {"_this": this, "drawnValue" : arguments[0]};
            var event = @com.smartgwt.client.widgets.chart.ValueClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.chart.FacetChart::handleTearDownValueClickEvent()();
            if (hasDefaultHandler) this.Super("valueClick", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("valueClick"));
            obj.addProperties({valueClick:  valueClick              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("valueClick"));
            obj.valueClick =  valueClick             ;
        }
    }-*/;

    private void handleTearDownValueClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.chart.ValueClickEvent.getType()) == 0) tearDownValueClickEvent();
    }

    private native void tearDownValueClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("valueClick")) delete obj.valueClick;
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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var zoomChanged = $entry(function(){
            var param = {"_this": this, "startValue" : arguments[0], "endValue" : arguments[1]};
            var event = @com.smartgwt.client.widgets.chart.ZoomChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.chart.FacetChart::handleTearDownZoomChangedEvent()();
            if (hasDefaultHandler) this.Super("zoomChanged", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("zoomChanged"));
            obj.addProperties({zoomChanged:  zoomChanged              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("zoomChanged"));
            obj.zoomChanged =  zoomChanged             ;
        }
    }-*/;

    private void handleTearDownZoomChangedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.chart.ZoomChangedEvent.getType()) == 0) tearDownZoomChangedEvent();
    }

    private native void tearDownZoomChangedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("zoomChanged")) delete obj.zoomChanged;
    }-*/;

	/**
     * For a {@link com.smartgwt.client.widgets.chart.FacetChart#getCanZoom zoomed chart}, simultaneously sets the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#setZoomStartValue zoomStartValue} and {@link
     * com.smartgwt.client.widgets.chart.FacetChart#setZoomEndValue zoomEndValue}.
     * @param startValue starting value for the data range shown in the main chart
     * @param endValue ending value for the data range shown in the main chart
     */
    public native void zoomTo(Object startValue, Object endValue) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "zoomTo", "Object,Object");
        }
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
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(FacetChart facetChartProperties) /*-{
        if (facetChartProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(FacetChart.@java.lang.Object::getClass()(), "setDefaultProperties", facetChartProperties.@java.lang.Object::getClass()());
        }
        facetChartProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = facetChartProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
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
     *  "_value", the <code>data</code> property could be:
     * <pre>
     *    FacetChart chart = new FacetChart();
     *    chart.setFacets(new Facet("regions"));
     *    Record[] records = new Record[3]; 
     *    records[0] = new Record();
     *    records[0].setAttribute("regions", "west");
     *    records[0].setAttribute("_value", 4);
     *    records[1] = new Record();
     *    records[1].setAttribute("regions", "north");
     *    records[1].setAttribute("_value", 2);
     *    records[2] = new Record();
     *    records[2].setAttribute("regions", "east");
     *    records[2].setAttribute("_value", 5);
     *    chart.setData(records);
     * </pre>
     * If there were a second facet with id "product" and facetValues "cars" and "trucks", a Chart
     * with a complete set of values would be:
     * <pre>
     *    FacetChart chart = new FacetChart();
     *    chart.setFacets(new Facet("regions"), new Facet("product"));
     *    Record[] records = new Record[6]; 
     *    records[0] = new Record();
     *    records[0].setAttribute("product", "cars");
     *    records[0].setAttribute("regions", "west");
     *    records[0].setAttribute("_value", 4);
     *    records[1] = new Record();
     *    records[1].setAttribute("product", "cars");
     *    records[1].setAttribute("regions", "north");
     *    records[1].setAttribute("_value", 2);
     *    records[2] = new Record();
     *    records[2].setAttribute("product", "cars");
     *    records[2].setAttribute("regions", "east");
     *    records[2].setAttribute("_value", 5);
     *    records[3] = new Record();
     *    records[3].setAttribute("product", "trucks");
     *    records[3].setAttribute("regions", "west");
     *    records[3].setAttribute("_value", 1);
     *    records[4] = new Record();
     *    records[4].setAttribute("product", "trucks");
     *    records[4].setAttribute("regions", "north");
     *    records[4].setAttribute("_value", 9);
     *    records[5] = new Record();
     *    records[5].setAttribute("product", "trucks");
     *    records[5].setAttribute("regions", "east");
     *    records[5].setAttribute("_value", 3);	    
     *    chart.setData(records);
     * </pre>
     * This 2 facet (or "2 dimensional") dataset, if rendered as a bar chart, would use stacked or&#010
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
        self.getPointHoverHTML = $debox($entry(function(value, record, metricId) {
            var recordJ = @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            var valueJ = @java.lang.Float::new(Ljava/lang/String;)("" + value);
            var metricIdJ = metricId;

            hoverCustomizer.@com.smartgwt.client.widgets.chart.ChartPointHoverCustomizer::setMetricId(Ljava/lang/String;)(metricIdJ);
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
     * The {@link com.smartgwt.client.widgets.cube.FacetValue FacetValue} that the user is hovering over is provided.
     * If the chart is a {@link com.smartgwt.client.widgets.chart.FacetChart#extraAxisMetrics multi-axis chart}, the
     * {@link com.smartgwt.client.widgets.cube.FacetValue FacetValue} for the hovered-over metric will also be provided.
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
	    self.pointClick = $debox($entry(function(value, record, metricId) {
	        var recordJ = @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
	        var valueJ = @java.lang.Float::new(Ljava/lang/String;)("" + value);
            var metricIdJ = metricId;

	        var eventJ = @com.smartgwt.client.widgets.chart.ChartPointClickEvent::new(Ljava/lang/Float;Lcom/smartgwt/client/data/Record;)(valueJ,recordJ);
            eventJ.@com.smartgwt.client.widgets.chart.ChartPointClickEvent::setMetricId(Ljava/lang/String;)(metricIdJ);

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

    private FacetChart setAttribute(String attribute, Object value, boolean allowPostCreate) {
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
        return this;
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
     * Formatter to apply to values displayed in the gradation labels on the x-axis.  Some 
     * documentation directing here may also relate to {@link #setYAxisValueFormatter
     * setYAxisValueFormatter()}.
     * <P>
     * Note that the installed formatter will only be called if the x-axis has gradation labels,
     * meaning labels drawn at regular intervals not associated with any particular facet value.
     * So, it will not be called if the labels on the x-axis are merely facet value ids.  In
     * that case, you may wish to build an array of 
     * {@link com.smartgwt.client.widgets.cube.FacetValue FacetValues} for the x-axis facet,
     * as a FacetValue constructor is available to set a separate facet id and title, and then
     * call {@link com.smartgwt.client.widgets.cube.Facet#setValues Facet.setValues()}.
     *
     * @param formatter Formatter to apply to values displayed in the gradation labels
     */
    public void setXAxisValueFormatter(ValueFormatter formatter) {
        xAxisValueFormatter = formatter;
        setFormatAxisValueFn();
    }

    /**
     * Formatter to apply to values displayed in the gradation labels on the y-axis.  See also
     * the similar setter {@link #setXAxisValueFormatter setXAxisValueFormatter()} for the other
     * axis.
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
    public native Float getMean(String criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(),
            mean = self.getMean(criteria);
        return (mean == null ? null : @com.smartgwt.client.util.JSOHelper::toFloat(F)(mean));
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
    public native Float getMean(FacetValueMap criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(),
            criteriaJS = (criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()()),
            mean = self.getMean(criteriaJS);
        return (mean == null ? null : @com.smartgwt.client.util.JSOHelper::toFloat(F)(mean));
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
    public native Float getMedian(String criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(),
            median = self.getMedian(criteria);
        return (median == null ? null : @com.smartgwt.client.util.JSOHelper::toFloat(F)(median));
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
    public native Float getMedian(FacetValueMap criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(),
            criteriaJS = (criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()()),
            median = self.getMedian(criteriaJS);
        return (median == null ? null : @com.smartgwt.client.util.JSOHelper::toFloat(F)(median));
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
    public native Float getPercentile(String criteria, float percentile) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(),
            ret = self.getPercentile(criteria, percentile);
        return (ret == null ? null : @com.smartgwt.client.util.JSOHelper::toFloat(F)(ret));
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
    public native Float getPercentile(FacetValueMap criteria, float percentile) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(),
            criteriaJS = (criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()()),
            ret = self.getPercentile(criteriaJS, percentile);
        return (ret == null ? null : @com.smartgwt.client.util.JSOHelper::toFloat(F)(ret));
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
    public native Float getRange(String criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(),
            range = self.getRange(criteria);
        return (range == null ? null : @com.smartgwt.client.util.JSOHelper::toFloat(F)(range));
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
    public native Float getRange(FacetValueMap criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(),
            criteriaJS = (criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()()),
            range = self.getRange(criteriaJS);
        return (range == null ? null : @com.smartgwt.client.util.JSOHelper::toFloat(F)(range));
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
    public native Float getStdDev(String criteria, boolean population) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(),
            sigma = self.getStdDev(criteria, population);
        return (sigma == null ? null : @com.smartgwt.client.util.JSOHelper::toFloat(F)(sigma));
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
    public native Float getStdDev(FacetValueMap criteria, boolean population) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(),
            criteriaJS = (criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()()),
            sigma = self.getStdDev(criteriaJS, population);
        return (sigma == null ? null : @com.smartgwt.client.util.JSOHelper::toFloat(F)(sigma));
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
    public native Float getVariance(String criteria, boolean population) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(),
            sigmaSq = self.getVariance(criteria, population);
        return (sigmaSq == null ? null : @com.smartgwt.client.util.JSOHelper::toFloat(F)(sigmaSq));
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
    public native Float getVariance(FacetValueMap criteria, boolean population) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(),
            criteriaJS = (criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()()),
            sigmaSq = self.getVariance(criteriaJS, population);
        return (sigmaSq == null ? null : @com.smartgwt.client.util.JSOHelper::toFloat(F)(sigmaSq));
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
    public native Float getMax(String criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(),
            max = self.getMax(criteria);
        return (max == null ? null : @com.smartgwt.client.util.JSOHelper::toFloat(F)(max));
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
    public native Float getMax(FacetValueMap criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(),
            criteriaJS = (criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()()),
            max = self.getMax(criteriaJS);
        return (max == null ? null : @com.smartgwt.client.util.JSOHelper::toFloat(F)(max));
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
    public native Float getMin(String criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(),
            min = self.getMin(criteria);
        return (min == null ? null : @com.smartgwt.client.util.JSOHelper::toFloat(F)(min));
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
    public native Float getMin(FacetValueMap criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(),
            criteriaJS = (criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()()),
            min = self.getMin(criteriaJS);
        return (min == null ? null : @com.smartgwt.client.util.JSOHelper::toFloat(F)(min));
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getDataColor", "int,Object,String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getDataColor(index, facetValueId, purpose);
    }-*/;

	/**
     * See {@link #getDataColor}
     */
    public native String getDataColor(int index, Integer facetValueId, String purpose) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getDataColor", "int,Object,String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getDataColor(index, facetValueId == null ? null : facetValueId.@java.lang.Integer::intValue()(), facetValueId, purpose);
    }-*/;

	/**
     * See {@link #getDataColor}
     */
    public native String getDataColor(int index, Double facetValueId, String purpose) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getDataColor", "int,Object,String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getDataColor(index, facetValueId == null ? null : facetValueId.@java.lang.Double::doubleValue()(), purpose);
    }-*/;

	/**
     * See {@link #getDataColor}
     */
    public native String getDataColor(int index, Date facetValueId, String purpose) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getDataColor", "int,Object,String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
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
     * default to using the data color - either {@link #getDataColor getDataColor()} or the
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


    // ****************************** Data Line Width Customizer ******************************

	/**
     * Sets a customizer to define what widths to use for data lines in the chart.  No default
     * implementation.  If not defined or null is returned, the line width will be determined
     * by the appropriate chart properties, such as 
     * {@link com.smartgwt.client.widgets.chart.setDataLineProperties dataLineProperties},
     * {@link com.smartgwt.client.widgets.chart.setBarProperties barProperties}, or
     * {@link com.smartgwt.client.widgets.chart.setBubbleProperties bubbleProperties}.
     *
     * @param lineWidthMapper the customizer defining what line widths are used for chart data
     * @see #setDataLineColorMapper
     */
    public native void setDataLineWidthMapper(LineWidthMapper lineWidthMapper) /*-{
        var isCreated = this.@com.smartgwt.client.widgets.BaseWidget::isCreated()(),
            self = isCreated ? this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()() :
                               this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        if (lineWidthMapper != null) {
            self.getDataLineWidth = $debox($entry(function (index, facetValueId, purpose) {
                var indexJ = $wnd.isc.isA.Number(index) ? index.valueOf() : 0,
                    facetValueIdJ = $wnd.SmartGWT.convertToJavaType(facetValueId);
                return lineWidthMapper.@com.smartgwt.client.widgets.chart.LineWidthMapper::getWidth(ILjava/lang/Object;Ljava/lang/String;)(indexJ, facetValueIdJ, purpose);
            }));
        } else if (!isCreated) {
            delete self.getDataLineWidth;
        } else {
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            self.getDataLineWidth = $wnd.isc[scClassName].getInstanceProperty("getDataLineWidth");
        }
    }-*/;


    // ******************************* Cluster Size Customizers *******************************

	/**
     * Sets a customizer to define the minimum cluster size (for clustered charts), or minimum
     * bar thickness (for  histogram or stacked charts) for the specified 
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getDataLabelFacet data label facet}
     * value.  Only applicable to a column, bar, or histogram chart.  There is no default
     * customizer in place - only the chart-wide {@link #getMinBarThickness minBarThickness}.
     * <P>
     * Both this minimum and {@link #getMinBarThickness minBarThickness} are used together to
     * determine the effective minimum of the cluster or bar stack.
     * <P> 
     * Per-facet-value minimum cluster sizes aren't supported for 
     * {@link com.smartgwt.client.widgets.chart.MetricSettings multi-axis} charts, in which
     * multiple chart types are overlaid onto the same chart.
     *
     * @param clusterSizeMapper customizer defining the minimum size for each cluster
     */
    public native void setMinClusterSizeMapper(ClusterSizeMapper clusterSizeMapper) /*-{
        var isCreated = this.@com.smartgwt.client.widgets.BaseWidget::isCreated()(),
            self = isCreated ? this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()() :
                               this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        if (clusterSizeMapper != null) {
            self.getMinClusterSize = $debox($entry(function (index, facetValueId) {
                var indexJ = $wnd.isc.isA.Number(index) ? index.valueOf() : 0,
                    facetValueIdJ = $wnd.SmartGWT.convertToJavaType(facetValueId);
                return clusterSizeMapper.@com.smartgwt.client.widgets.chart.ClusterSizeMapper::getClusterSize(ILjava/lang/Object;)(indexJ, facetValueIdJ);
            }));
        } else if (!isCreated) {
            delete self.getMinClusterSize;
        } else {
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            self.getMinClusterSize = $wnd.isc[scClassName].getInstanceProperty("getMinClusterSize");
        }
    }-*/;


    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(FacetChartLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.allowBubbleGradients = getAttributeAsString("allowBubbleGradients");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.allowBubbleGradients:" + t.getMessage() + "\n";
        }
        try {
            s.allowedChartTypes = getAttributeAsStringArray("allowedChartTypes");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.allowedChartTypesArray:" + t.getMessage() + "\n";
        }
        try {
            s.autoRotateLabels = getAttributeAsString("autoRotateLabels");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.autoRotateLabels:" + t.getMessage() + "\n";
        }
        try {
            s.autoScrollContent = getAttributeAsString("autoScrollContent");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.autoScrollContent:" + t.getMessage() + "\n";
        }
        try {
            s.autoScrollData = getAttributeAsString("autoScrollData");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.autoScrollData:" + t.getMessage() + "\n";
        }
        try {
            s.autoScrollDataApproach = getAttributeAsString("autoScrollDataApproach");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.autoScrollDataApproach:" + t.getMessage() + "\n";
        }
        try {
            s.autoSortBubblePoints = getAttributeAsString("autoSortBubblePoints");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.autoSortBubblePoints:" + t.getMessage() + "\n";
        }
        try {
            s.axisEndValue = getAttributeAsString("axisEndValue");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.axisEndValue:" + t.getMessage() + "\n";
        }
        try {
            s.axisStartValue = getAttributeAsString("axisStartValue");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.axisStartValue:" + t.getMessage() + "\n";
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
            s.brightenAllOnHover = getAttributeAsString("brightenAllOnHover");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.brightenAllOnHover:" + t.getMessage() + "\n";
        }
        try {
            s.bubbleHoverMaxDistance = getAttributeAsString("bubbleHoverMaxDistance");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.bubbleHoverMaxDistance:" + t.getMessage() + "\n";
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
            s.centerLegend = getAttributeAsString("centerLegend");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.centerLegend:" + t.getMessage() + "\n";
        }
        try {
            s.centerTitle = getAttributeAsString("centerTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.centerTitle:" + t.getMessage() + "\n";
        }
        try {
            s.chartRectMargin = getAttributeAsString("chartRectMargin");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.chartRectMargin:" + t.getMessage() + "\n";
        }
        try {
            s.chartType = getAttributeAsString("chartType");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.chartType:" + t.getMessage() + "\n";
        }
        try {
            s.colorScaleMetric = getAttributeAsString("colorScaleMetric");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.colorScaleMetric:" + t.getMessage() + "\n";
        }
        try {
            s.dataColors = getAttributeAsStringArray("dataColors");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.dataColorsArray:" + t.getMessage() + "\n";
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
            s.dataPointSize = getAttributeAsString("dataPointSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.dataPointSize:" + t.getMessage() + "\n";
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
            s.drawLegendBoundary = getAttributeAsString("drawLegendBoundary");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.drawLegendBoundary:" + t.getMessage() + "\n";
        }
        try {
            s.drawTitleBackground = getAttributeAsString("drawTitleBackground");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.drawTitleBackground:" + t.getMessage() + "\n";
        }
        try {
            s.drawTitleBoundary = getAttributeAsString("drawTitleBoundary");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.drawTitleBoundary:" + t.getMessage() + "\n";
        }
        try {
            s.editProxyConstructor = getAttributeAsString("editProxyConstructor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.editProxyConstructor:" + t.getMessage() + "\n";
        }
        try {
            s.endValueMetric = getAttributeAsString("endValueMetric");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.endValueMetric:" + t.getMessage() + "\n";
        }
        try {
            s.errorBarWidth = getAttributeAsString("errorBarWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.errorBarWidth:" + t.getMessage() + "\n";
        }
        try {
            s.extraAxisLabelAlign = getAttributeAsString("extraAxisLabelAlign");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.extraAxisLabelAlign:" + t.getMessage() + "\n";
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
            s.formatStringFacetValueIds = getAttributeAsString("formatStringFacetValueIds");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.formatStringFacetValueIds:" + t.getMessage() + "\n";
        }
        try {
            s.gradationGaps = getAttributeAsStringArray("gradationGaps");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.gradationGapsArray:" + t.getMessage() + "\n";
        }
        try {
            s.gradationLabelPadding = getAttributeAsString("gradationLabelPadding");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.gradationLabelPadding:" + t.getMessage() + "\n";
        }
        try {
            s.gradationTickMarkLength = getAttributeAsString("gradationTickMarkLength");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.gradationTickMarkLength:" + t.getMessage() + "\n";
        }
        try {
            s.highErrorMetric = getAttributeAsString("highErrorMetric");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.highErrorMetric:" + t.getMessage() + "\n";
        }
        try {
            s.hoverLabelPadding = getAttributeAsString("hoverLabelPadding");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.hoverLabelPadding:" + t.getMessage() + "\n";
        }
        try {
            s.labelCollapseMode = getAttributeAsString("labelCollapseMode");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.labelCollapseMode:" + t.getMessage() + "\n";
        }
        try {
            s.legendAlign = getAttributeAsString("legendAlign");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.legendAlign:" + t.getMessage() + "\n";
        }
        try {
            s.legendItemPadding = getAttributeAsString("legendItemPadding");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.legendItemPadding:" + t.getMessage() + "\n";
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
            s.legendRectHeight = getAttributeAsString("legendRectHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.legendRectHeight:" + t.getMessage() + "\n";
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
            s.logScalePointColor = getAttributeAsString("logScalePointColor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.logScalePointColor:" + t.getMessage() + "\n";
        }
        try {
            s.logScalePointSize = getAttributeAsString("logScalePointSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.logScalePointSize:" + t.getMessage() + "\n";
        }
        try {
            s.lowErrorMetric = getAttributeAsString("lowErrorMetric");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.lowErrorMetric:" + t.getMessage() + "\n";
        }
        try {
            s.majorTickGradations = getAttributeAsStringArray("majorTickGradations");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.majorTickGradationsArray:" + t.getMessage() + "\n";
        }
        try {
            s.majorTickTimeIntervals = getAttributeAsStringArray("majorTickTimeIntervals");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.majorTickTimeIntervalsArray:" + t.getMessage() + "\n";
        }
        try {
            s.matchBarChartDataLineColor = getAttributeAsString("matchBarChartDataLineColor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.matchBarChartDataLineColor:" + t.getMessage() + "\n";
        }
        try {
            s.maxBarThickness = getAttributeAsString("maxBarThickness");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.maxBarThickness:" + t.getMessage() + "\n";
        }
        try {
            s.maxDataPointSize = getAttributeAsString("maxDataPointSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.maxDataPointSize:" + t.getMessage() + "\n";
        }
        try {
            s.maxDataZIndex = getAttributeAsString("maxDataZIndex");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.maxDataZIndex:" + t.getMessage() + "\n";
        }
        try {
            s.metricFacetId = getAttributeAsString("metricFacetId");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.metricFacetId:" + t.getMessage() + "\n";
        }
        try {
            s.minBarThickness = getAttributeAsString("minBarThickness");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.minBarThickness:" + t.getMessage() + "\n";
        }
        try {
            s.minChartHeight = getAttributeAsString("minChartHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.minChartHeight:" + t.getMessage() + "\n";
        }
        try {
            s.minChartWidth = getAttributeAsString("minChartWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.minChartWidth:" + t.getMessage() + "\n";
        }
        try {
            s.minContentHeight = getAttributeAsString("minContentHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.minContentHeight:" + t.getMessage() + "\n";
        }
        try {
            s.minContentWidth = getAttributeAsString("minContentWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.minContentWidth:" + t.getMessage() + "\n";
        }
        try {
            s.minDataPointSize = getAttributeAsString("minDataPointSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.minDataPointSize:" + t.getMessage() + "\n";
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
            s.minorTickLength = getAttributeAsString("minorTickLength");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.minorTickLength:" + t.getMessage() + "\n";
        }
        try {
            s.minXDataSpreadPercent = getAttributeAsString("minXDataSpreadPercent");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.minXDataSpreadPercent:" + t.getMessage() + "\n";
        }
        try {
            s.otherAxisGradationGaps = getAttributeAsStringArray("otherAxisGradationGaps");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.otherAxisGradationGapsArray:" + t.getMessage() + "\n";
        }
        try {
            s.otherAxisGradationTimes = getAttributeAsStringArray("otherAxisGradationTimes");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.otherAxisGradationTimesArray:" + t.getMessage() + "\n";
        }
        try {
            s.otherAxisPixelsPerGradation = getAttributeAsString("otherAxisPixelsPerGradation");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.otherAxisPixelsPerGradation:" + t.getMessage() + "\n";
        }
        try {
            s.padChartRectByCornerRadius = getAttributeAsString("padChartRectByCornerRadius");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.padChartRectByCornerRadius:" + t.getMessage() + "\n";
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
            s.pieStartAngle = getAttributeAsString("pieStartAngle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.pieStartAngle:" + t.getMessage() + "\n";
        }
        try {
            s.pixelsPerGradation = getAttributeAsString("pixelsPerGradation");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.pixelsPerGradation:" + t.getMessage() + "\n";
        }
        try {
            s.pointColorLogBase = getAttributeAsString("pointColorLogBase");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.pointColorLogBase:" + t.getMessage() + "\n";
        }
        try {
            s.pointShapes = getAttributeAsStringArray("pointShapes");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.pointShapesArray:" + t.getMessage() + "\n";
        }
        try {
            s.pointSizeGradations = getAttributeAsString("pointSizeGradations");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.pointSizeGradations:" + t.getMessage() + "\n";
        }
        try {
            s.pointSizeLogBase = getAttributeAsString("pointSizeLogBase");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.pointSizeLogBase:" + t.getMessage() + "\n";
        }
        try {
            s.pointSizeLogGradations = getAttributeAsStringArray("pointSizeLogGradations");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.pointSizeLogGradationsArray:" + t.getMessage() + "\n";
        }
        try {
            s.pointSizeMetric = getAttributeAsString("pointSizeMetric");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.pointSizeMetric:" + t.getMessage() + "\n";
        }
        try {
            s.printZoomChart = getAttributeAsString("printZoomChart");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.printZoomChart:" + t.getMessage() + "\n";
        }
        try {
            s.probabilityMetric = getAttributeAsString("probabilityMetric");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.probabilityMetric:" + t.getMessage() + "\n";
        }
        try {
            s.proportional = getAttributeAsString("proportional");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.proportional:" + t.getMessage() + "\n";
        }
        try {
            s.proportionalAxisLabel = getAttributeAsString("proportionalAxisLabel");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.proportionalAxisLabel:" + t.getMessage() + "\n";
        }
        try {
            s.radarRotateLabels = getAttributeAsString("radarRotateLabels");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.radarRotateLabels:" + t.getMessage() + "\n";
        }
        try {
            s.radialLabelOffset = getAttributeAsString("radialLabelOffset");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.radialLabelOffset:" + t.getMessage() + "\n";
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
            s.rotateDataValues = getAttributeAsString("rotateDataValues");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.rotateDataValues:" + t.getMessage() + "\n";
        }
        try {
            s.rotateLabels = getAttributeAsString("rotateLabels");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.rotateLabels:" + t.getMessage() + "\n";
        }
        try {
            s.scaleEndColor = getAttributeAsString("scaleEndColor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.scaleEndColor:" + t.getMessage() + "\n";
        }
        try {
            s.scaleStartColor = getAttributeAsString("scaleStartColor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.scaleStartColor:" + t.getMessage() + "\n";
        }
        try {
            s.showBubbleLegendPerShape = getAttributeAsString("showBubbleLegendPerShape");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.showBubbleLegendPerShape:" + t.getMessage() + "\n";
        }
        try {
            s.showChartRect = getAttributeAsString("showChartRect");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.showChartRect:" + t.getMessage() + "\n";
        }
        try {
            s.showColorScaleLegend = getAttributeAsString("showColorScaleLegend");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.showColorScaleLegend:" + t.getMessage() + "\n";
        }
        try {
            s.showDataAxisLabel = getAttributeAsString("showDataAxisLabel");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.showDataAxisLabel:" + t.getMessage() + "\n";
        }
        try {
            s.showDataLabels = getAttributeAsString("showDataLabels");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.showDataLabels:" + t.getMessage() + "\n";
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
            s.showDataValuesMode = getAttributeAsString("showDataValuesMode");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.showDataValuesMode:" + t.getMessage() + "\n";
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
            s.showMinorTicks = getAttributeAsString("showMinorTicks");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.showMinorTicks:" + t.getMessage() + "\n";
        }
        try {
            s.showPointSizeLegend = getAttributeAsString("showPointSizeLegend");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.showPointSizeLegend:" + t.getMessage() + "\n";
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
            s.showXTicks = getAttributeAsString("showXTicks");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.showXTicks:" + t.getMessage() + "\n";
        }
        try {
            s.showYTicks = getAttributeAsString("showYTicks");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.showYTicks:" + t.getMessage() + "\n";
        }
        try {
            s.stacked = getAttributeAsString("stacked");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.stacked:" + t.getMessage() + "\n";
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
            s.tickLength = getAttributeAsString("tickLength");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.tickLength:" + t.getMessage() + "\n";
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
            s.titleAlign = getAttributeAsString("titleAlign");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.titleAlign:" + t.getMessage() + "\n";
        }
        try {
            s.titlePadding = getAttributeAsString("titlePadding");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.titlePadding:" + t.getMessage() + "\n";
        }
        try {
            s.titleRectHeight = getAttributeAsString("titleRectHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.titleRectHeight:" + t.getMessage() + "\n";
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
            s.useMultiplePointShapes = getAttributeAsString("useMultiplePointShapes");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.useMultiplePointShapes:" + t.getMessage() + "\n";
        }
        try {
            s.usePointSizeLogGradations = getAttributeAsString("usePointSizeLogGradations");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.usePointSizeLogGradations:" + t.getMessage() + "\n";
        }
        try {
            s.useSymmetricStandardDeviations = getAttributeAsString("useSymmetricStandardDeviations");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.useSymmetricStandardDeviations:" + t.getMessage() + "\n";
        }
        try {
            s.valueAxisMargin = getAttributeAsString("valueAxisMargin");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.valueAxisMargin:" + t.getMessage() + "\n";
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
            s.xAxisEndValueAsString = getAttributeAsString("xAxisEndValue");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.xAxisEndValueAsString:" + t.getMessage() + "\n";
        }
        try {
            s.xAxisMetric = getAttributeAsString("xAxisMetric");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.xAxisMetric:" + t.getMessage() + "\n";
        }
        try {
            s.xAxisStartValueAsString = getAttributeAsString("xAxisStartValue");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.xAxisStartValueAsString:" + t.getMessage() + "\n";
        }
        try {
            s.yAxisLabelAlign = getAttributeAsString("yAxisLabelAlign");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.yAxisLabelAlign:" + t.getMessage() + "\n";
        }
        try {
            s.yAxisLabelPadding = getAttributeAsString("yAxisLabelPadding");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.yAxisLabelPadding:" + t.getMessage() + "\n";
        }
        try {
            s.yAxisMetric = getAttributeAsString("yAxisMetric");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.yAxisMetric:" + t.getMessage() + "\n";
        }
        try {
            s.zIndexMetric = getAttributeAsString("zIndexMetric");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.zIndexMetric:" + t.getMessage() + "\n";
        }
        try {
            s.zoomChartHeight = getAttributeAsString("zoomChartHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FacetChart.zoomChartHeight:" + t.getMessage() + "\n";
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

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        FacetChartLogicalStructure s = new FacetChartLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
