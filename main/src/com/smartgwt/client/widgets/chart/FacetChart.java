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

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * HTML5-based charting engine, implementing most  chartTypes of the Chart interface. <P> Can be used directly, or
 * specified as {@link com.smartgwt.client.widgets.grid.ListGrid#getChartConstructor chartConstructor} or {@link
 * com.smartgwt.client.widgets.cube.CubeGrid#getChartConstructor chartConstructor}. <P> In order to use this component, you
 * must load the Drawing module (ISC_Drawing.js) before loading the Analytics mdoule (ISC_Analytics.js).
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
     * See {@link com.smartgwt.client.types.ChartType} for a list of known types - Column, Line, and Radar charts are
     * supported.
     *
     * @param chartType chartType Default value is "Column"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setChartType(ChartType chartType)  throws IllegalStateException {
        setAttribute("chartType", chartType.getValue(), false);
    }

    /**
     * See {@link com.smartgwt.client.types.ChartType} for a list of known types - Column, Line, and Radar charts are
     * supported.
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
     * Whether shapes are filled, for example, whether a multi-series line chart appears as a stack of filled regions. <P> If
     * unset, fills will be automatically used when there are multiple facets and stacking is active (so Line and Radar charts
     * will show stacked regions).   <P> You can explicitly set filled:false to create multi-facet Line or Radar charts where
     * translucent regions overlap, or filled:true to fill in a single-facet Line or Radar chart.
     *
     * @param filled filled Default value is null
     */
    public void setFilled(Boolean filled) {
        setAttribute("filled", filled, true);
    }

    /**
     * Whether shapes are filled, for example, whether a multi-series line chart appears as a stack of filled regions. <P> If
     * unset, fills will be automatically used when there are multiple facets and stacking is active (so Line and Radar charts
     * will show stacked regions).   <P> You can explicitly set filled:false to create multi-facet Line or Radar charts where
     * translucent regions overlap, or filled:true to fill in a single-facet Line or Radar chart.
     *
     *
     * @return Boolean
     */
    public Boolean getFilled()  {
        return getAttributeAsBoolean("filled");
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
     * Whether to show a title.
     *
     * @param showTitle showTitle Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowTitle(String showTitle)  throws IllegalStateException {
        setAttribute("showTitle", showTitle, false);
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
     * Whether to use stacking for charts where this makes sense (bar, column, line and radar charts).  If stacked is not set
     * and two facets are supplied, clustering is assumed.
     *
     * @param stacked stacked Default value is true
     */
    public void setStacked(Boolean stacked) {
        setAttribute("stacked", stacked, true);
    }

    /**
     * Whether to use stacking for charts where this makes sense (bar, column, line and radar charts).  If stacked is not set
     * and two facets are supplied, clustering is assumed.
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
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTitle(String title)  throws IllegalStateException {
        setAttribute("title", title, false);
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

    // ********************* Static Methods ***********************
    /**
     * Class level method to set the default properties of this class. If set, then all subsequent instances of this
     * class will automatically have the default properties that were set when this method was called. This is a powerful
     * feature that eliminates the need for users to create a separate hierarchy of subclasses that only alter the default
     * properties of this class. Can also be used for skinning / styling purposes. 
     *
     * @param facetChartProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(FacetChart facetChartProperties) /*-{
        $wnd.isc.FacetChart.addProperties(facetChartProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
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

    
    


}




