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
 
package com.smartgwt.client.tools;


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

/**
 * {@link com.smartgwt.client.tools.EditProxy} that handles {@link com.smartgwt.client.widgets.chart.FacetChart
 * FacetCharts} when editMode is enabled.
 * @see com.smartgwt.client.docs.DevTools DevTools overview and related methods
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("FacetChartEditProxy")
public class FacetChartEditProxy extends DrawPaneEditProxy {

    public static FacetChartEditProxy getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (FacetChartEditProxy) obj;
        } else {
            return new FacetChartEditProxy(jsObj);
        }
    }


    public FacetChartEditProxy(){
        scClassName = "FacetChartEditProxy";
    }

    public FacetChartEditProxy(JavaScriptObject jsObj){
        scClassName = "FacetChartEditProxy";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * If {@link com.smartgwt.client.types.InlineEditEvent inline editing} for this chart edits the
     *  {@link com.smartgwt.client.widgets.chart.FacetChart#getData data}, character that should be used as a separator for
     *  entering label vs value entries.
     *  <p>
     *  With the default of ":", the following input defines four values with titles:
     *  <pre>
     *       North:10, South:20, East:30, West:40
     *  </pre>
     *  <p>
     * The {@link com.smartgwt.client.tools.FacetChartEditProxy#getDataEscapeChar dataEscapeChar} can be used to enter literal
     * colon characters.
     *
     * @param dataDisplaySeparatorChar  Default value is ":"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setDataDisplaySeparatorChar(String dataDisplaySeparatorChar)  throws IllegalStateException {
        setAttribute("dataDisplaySeparatorChar", dataDisplaySeparatorChar, false);
    }

    /**
     * If {@link com.smartgwt.client.types.InlineEditEvent inline editing} for this chart edits the
     *  {@link com.smartgwt.client.widgets.chart.FacetChart#getData data}, character that should be used as a separator for
     *  entering label vs value entries.
     *  <p>
     *  With the default of ":", the following input defines four values with titles:
     *  <pre>
     *       North:10, South:20, East:30, West:40
     *  </pre>
     *  <p>
     * The {@link com.smartgwt.client.tools.FacetChartEditProxy#getDataEscapeChar dataEscapeChar} can be used to enter literal
     * colon characters.
     *
     * @return String
     */
    public String getDataDisplaySeparatorChar()  {
        return getAttributeAsString("dataDisplaySeparatorChar");
    }
    

    /**
     * If {@link com.smartgwt.client.types.InlineEditEvent inline editing} for this chart edits the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getData data}, character that can be used to enter literal separator chars
     * (such as the {@link com.smartgwt.client.tools.FacetChartEditProxy#getDataSeparatorChar dataSeparatorChar}). <p> Repeat
     * this character twice to enter it literally.  For example, with the default of "\", inputting "\\" would result in a
     * literal backslash in the value.
     *
     * @param dataEscapeChar  Default value is "\"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setDataEscapeChar(String dataEscapeChar)  throws IllegalStateException {
        setAttribute("dataEscapeChar", dataEscapeChar, false);
    }

    /**
     * If {@link com.smartgwt.client.types.InlineEditEvent inline editing} for this chart edits the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getData data}, character that can be used to enter literal separator chars
     * (such as the {@link com.smartgwt.client.tools.FacetChartEditProxy#getDataSeparatorChar dataSeparatorChar}). <p> Repeat
     * this character twice to enter it literally.  For example, with the default of "\", inputting "\\" would result in a
     * literal backslash in the value.
     *
     * @return String
     */
    public String getDataEscapeChar()  {
        return getAttributeAsString("dataEscapeChar");
    }
    

    /**
     * If {@link com.smartgwt.client.types.InlineEditEvent inline editing} for this chart edits the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getData data}, character that should be used as a separator between values,
     * or between pairs of label vs values. <p> The {@link com.smartgwt.client.tools.FacetChartEditProxy#getDataEscapeChar
     * dataEscapeChar} can be used to enter the separator char as part of a field name or value.
     *
     * @param dataSeparatorChar  Default value is ","
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setDataSeparatorChar(String dataSeparatorChar)  throws IllegalStateException {
        setAttribute("dataSeparatorChar", dataSeparatorChar, false);
    }

    /**
     * If {@link com.smartgwt.client.types.InlineEditEvent inline editing} for this chart edits the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getData data}, character that should be used as a separator between values,
     * or between pairs of label vs values. <p> The {@link com.smartgwt.client.tools.FacetChartEditProxy#getDataEscapeChar
     * dataEscapeChar} can be used to enter the separator char as part of a field name or value.
     *
     * @return String
     */
    public String getDataSeparatorChar()  {
        return getAttributeAsString("dataSeparatorChar");
    }
    

    // ********************* Methods ***********************
	/**
     * Returns the text based on the current component state to be edited inline. Called by the {@link
     * com.smartgwt.client.tools.EditProxy#getInlineEditForm inlineEditForm} to obtain the starting edit value.
     */
    public native void getInlineEditText() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.getInlineEditText();
    }-*/;



	/**
     * Save the new value into the component's state. Called by the {@link
     * com.smartgwt.client.tools.EditProxy#getInlineEditForm inlineEditForm} to commit the change. <p> Updates the component's
     * <code>facets</code> and <code>data</code>. <p> Lines starting with "--" or "==" are considered titles. A single title is
     * used as the chart title. Titles are matched to the next series of data. If titles are provided for each series, a legend
     * will be shown. <p> Series data can be entered as a list of values separated by commas (see {@link
     * com.smartgwt.client.tools.FacetChartEditProxy#getDataSeparatorChar dataSeparatorChar}) or as a valueMap-style list of
     * <code>label:value</code> pairs. The first data series defines the number of chart values and the titles, if provided.
     * @param newValue the new component data
     */
    public native void setInlineEditText(String newValue) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.setInlineEditText(newValue);
    }-*/;



    // ********************* Static Methods ***********************

    // ***********************************************************

}


