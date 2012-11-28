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
 * Returns information about how a data value is rendered in a chart.
 */
public class DrawnValue extends BaseWidget {

    public native static DrawnValue getOrCreateRef(JavaScriptObject jsObj) /*-{

    	if(jsObj == null) return null;
    	
    	var instance = jsObj["__ref"];
    	
    	if(instance==undefined) {
            return @com.smartgwt.client.util.ObjectFactory::createCanvas(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)("DrawnValue",jsObj);
        } else if(instance != null) {
            return instance;
        //} else {
        //    return @com.smartgwt.client.widgets.chart.DrawnValue::new(Lcom/google/gwt/core/client/JavaScriptObject;)(jsObj);
        }
    }-*/;

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        id = JSOHelper.getAttribute(jsObj, "ID");
    }


    public DrawnValue(){
        scClassName = "DrawnValue";
    }

    public DrawnValue(JavaScriptObject jsObj){
        scClassName = "DrawnValue";
        setJavaScriptObject(jsObj);
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
     * For bar and column charts, thickness of the bar representing this data value.
     *
     * @param barThickness barThickness Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setBarThickness(Integer barThickness)  throws IllegalStateException {
        setAttribute("barThickness", barThickness, false);
    }

    /**
     * For bar and column charts, thickness of the bar representing this data value.
     *
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
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEndAngle(Integer endAngle)  throws IllegalStateException {
        setAttribute("endAngle", endAngle, false);
    }

    /**
     * For pie mode only, start angle of the segment for the data value.
     *
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
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setFacetValues(FacetValueMap facetValues)  throws IllegalStateException {
        setAttribute("facetValues", facetValues.getJsObj(), false);
    }

    /**
     * FacetValues for the data value.
     *
     *
     * @return FacetValueMap
     */
    public FacetValueMap getFacetValues()  {
        return new FacetValueMap(getAttributeAsJavaScriptObject("facetValues"));
    }

    /**
     * For pie mode only, start angle of the segment for the data value.
     *
     * @param startAngle startAngle Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setStartAngle(Integer startAngle)  throws IllegalStateException {
        setAttribute("startAngle", startAngle, false);
    }

    /**
     * For pie mode only, start angle of the segment for the data value.
     *
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
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setValue(Float value)  throws IllegalStateException {
        setAttribute("value", value, false);
    }

    /**
     * Data value this <code>drawnValue</code> represents.
     *
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
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setX(Integer x)  throws IllegalStateException {
        setAttribute("x", x, false);
    }

    /**
     * X coordinate where the data value is rendered.  In pie mode, returns the X coordinate of the center of the pie where the
     * data value appears.
     *
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
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setY(Integer y)  throws IllegalStateException {
        setAttribute("y", y, false);
    }

    /**
     * Y coordinate where the data value is rendered.  In pie mode, returns the Y coordinate of the center of the pie where the
     * data value appears.
     *
     *
     * @return Integer
     */
    public Integer getY()  {
        return getAttributeAsInt("y");
    }

    // ********************* Methods ***********************

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
     * @param drawnValueProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(DrawnValue drawnValueProperties) /*-{
    	var properties = $wnd.isc.addProperties({},drawnValueProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.DrawnValue.addProperties(properties);
    }-*/;
        
    // ***********************************************************        

    public LogicalStructureObject setLogicalStructure(DrawnValueLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.barThickness = getAttributeAsString("barThickness");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawnValue.barThickness:" + t.getMessage() + "\n";
        }
        try {
            s.endAngle = getAttributeAsString("endAngle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawnValue.endAngle:" + t.getMessage() + "\n";
        }
        try {
            s.facetValues = getFacetValues();
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawnValue.facetValues:" + t.getMessage() + "\n";
        }
        try {
            s.startAngle = getAttributeAsString("startAngle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawnValue.startAngle:" + t.getMessage() + "\n";
        }
        try {
            s.value = getAttributeAsString("value");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawnValue.value:" + t.getMessage() + "\n";
        }
        try {
            s.x = getAttributeAsString("x");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawnValue.x:" + t.getMessage() + "\n";
        }
        try {
            s.y = getAttributeAsString("y");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawnValue.y:" + t.getMessage() + "\n";
        }
        return s;
    }
    
    public LogicalStructureObject getLogicalStructure() {
        DrawnValueLogicalStructure s = new DrawnValueLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

