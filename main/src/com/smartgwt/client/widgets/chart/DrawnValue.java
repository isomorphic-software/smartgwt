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
import com.smartgwt.client.callbacks.*;
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
 * Returns information about how a data value is rendered in a chart.
 */
public class DrawnValue extends DataClass {

    public static DrawnValue getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new DrawnValue(jsObj);
    }

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }



    public DrawnValue(){
        
    }

    public DrawnValue(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
        
    }


    // ********************* Properties / Attributes ***********************


    /**
     * For bar and column charts, thickness of the bar representing this data value.
     *
     * @param barThickness barThickness Default value is null
     */
    public void setBarThickness(Integer barThickness) {
        setAttribute("barThickness", barThickness);
    }

    /**
     * For bar and column charts, thickness of the bar representing this data value.
     *
     * @return Integer
     */
    public Integer getBarThickness()  {
        return getAttributeAsInt("barThickness");
    }


    /**
     * For pie mode only, start angle of the segment for the data value.
     *
     * @param endAngle endAngle Default value is null
     */
    public void setEndAngle(Integer endAngle) {
        setAttribute("endAngle", endAngle);
    }

    /**
     * For pie mode only, start angle of the segment for the data value.
     *
     * @return Integer
     */
    public Integer getEndAngle()  {
        return getAttributeAsInt("endAngle");
    }


    /**
     * FacetValues for the data value.
     *
     * @param facetValues facetValues Default value is null
     */
    public void setFacetValues(FacetValueMap facetValues) {
        setAttribute("facetValues", facetValues.getJsObj());
    }

    /**
     * FacetValues for the data value.
     *
     * @return FacetValueMap
     */
    public FacetValueMap getFacetValues()  {
        return new FacetValueMap(getAttributeAsJavaScriptObject("facetValues"));
    }


    /**
     * The data record of the data point from which this <code>drawnValue</code> was created. <P> Note that a chart with an
     * {@link com.smartgwt.client.widgets.cube.Facet#getInlinedValues inlined facet} or a {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics multi-axis chart} may define multiple data points in
     * the same record, each of which will correspond to a different <code>drawnValue</code>. The way to uniquely identify the
     * data value of this particular <code>drawnValue</code> is to use the {@link
     * com.smartgwt.client.widgets.chart.DrawnValue#getFacetValues facetValues}.
     *
     * @param record record Default value is null
     */
    public void setRecord(Record record) {
        setAttribute("record", record.getJsObj());
    }

    /**
     * The data record of the data point from which this <code>drawnValue</code> was created. <P> Note that a chart with an
     * {@link com.smartgwt.client.widgets.cube.Facet#getInlinedValues inlined facet} or a {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics multi-axis chart} may define multiple data points in
     * the same record, each of which will correspond to a different <code>drawnValue</code>. The way to uniquely identify the
     * data value of this particular <code>drawnValue</code> is to use the {@link
     * com.smartgwt.client.widgets.chart.DrawnValue#getFacetValues facetValues}.
     *
     * @return Record
     */
    public Record getRecord()  {
        return Record.getOrCreateRef(getAttributeAsJavaScriptObject("record"));
    }


    /**
     * For pie mode only, start angle of the segment for the data value.
     *
     * @param startAngle startAngle Default value is null
     */
    public void setStartAngle(Integer startAngle) {
        setAttribute("startAngle", startAngle);
    }

    /**
     * For pie mode only, start angle of the segment for the data value.
     *
     * @return Integer
     */
    public Integer getStartAngle()  {
        return getAttributeAsInt("startAngle");
    }


    /**
     * Data value this <code>drawnValue</code> represents.
     *
     * @param value value Default value is null
     */
    public void setValue(Float value) {
        setAttribute("value", value);
    }

    /**
     * Data value this <code>drawnValue</code> represents.
     *
     * @return Float
     */
    public Float getValue()  {
        return getAttributeAsFloat("value");
    }


    /**
     * X coordinate where the data value is rendered.  In pie mode, returns the X coordinate of the center of the pie where the
     * data value appears.
     *
     * @param x x Default value is null
     */
    public void setX(Integer x) {
        setAttribute("x", x);
    }

    /**
     * X coordinate where the data value is rendered.  In pie mode, returns the X coordinate of the center of the pie where the
     * data value appears.
     *
     * @return Integer
     */
    public Integer getX()  {
        return getAttributeAsInt("x");
    }


    /**
     * Y coordinate where the data value is rendered.  In pie mode, returns the Y coordinate of the center of the pie where the
     * data value appears.
     *
     * @param y y Default value is null
     */
    public void setY(Integer y) {
        setAttribute("y", y);
    }

    /**
     * Y coordinate where the data value is rendered.  In pie mode, returns the Y coordinate of the center of the pie where the
     * data value appears.
     *
     * @return Integer
     */
    public Integer getY()  {
        return getAttributeAsInt("y");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}


