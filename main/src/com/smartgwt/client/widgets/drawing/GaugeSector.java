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
import com.smartgwt.client.browser.window.*;
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
import com.smartgwt.client.widgets.tour.*;
import com.smartgwt.client.widgets.notify.*;
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
import com.smartgwt.client.widgets.notify.*;
import com.smartgwt.client.widgets.drawing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
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
import com.smartgwt.client.util.tour.*;


/**
 * Represents a sector on the gauge.
 */
@BeanFactory.FrameworkClass
public class GaugeSector extends RefDataClass {

    public static GaugeSector getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof GaugeSector) {
            existingObj.setJsObj(jsObj);
            return (GaugeSector)existingObj;
        } else

        {
            return new GaugeSector(jsObj);
        }
    }
        


    public GaugeSector(){
        
    }

    public GaugeSector(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }

    /**
     * @deprecated
     */
    public GaugeSector(float value) {
        setValue(value);
                
    }

    /**
     * @deprecated
     */
    public GaugeSector(float value, String fillColor) {
        setValue(value);
		setFillColor(fillColor);
                
    }


    public GaugeSector(double value) {
        setValue(value);
                
    }


    public GaugeSector(double value, String fillColor) {
        setValue(value);
		setFillColor(fillColor);
                
    }


    // ********************* Properties / Attributes ***********************

    /**
     * 
     *
     * @param endAngle New endAngle value. Default value is 0
     * @return {@link com.smartgwt.client.widgets.drawing.GaugeSector GaugeSector} instance, for chaining setter calls
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public GaugeSector setEndAngle(float endAngle) {
        return (GaugeSector)setAttribute("endAngle", endAngle);
    }

    /**
     * 
     *
     * @return Current endAngle value. Default value is 0
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public float getEndAngle()  {
        return getAttributeAsFloat("endAngle");
    }

    /**
     * 
     *
     * @param endAngle New endAngle value. Default value is 0
     * @return {@link com.smartgwt.client.widgets.drawing.GaugeSector GaugeSector} instance, for chaining setter calls
     */
    public GaugeSector setEndAngle(double endAngle) {
        return (GaugeSector)setAttribute("endAngle", endAngle);
    }

    /**
     * 
     *
     * @return Current endAngle value. Default value is 0
     */
    public double getEndAngleAsDouble()  {
        return getAttributeAsDouble("endAngle");
    }
    

    /**
     * 
     *
     * @param fillColor New fillColor value. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.GaugeSector GaugeSector} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public GaugeSector setFillColor(String fillColor) {
        return (GaugeSector)setAttribute("fillColor", fillColor);
    }

    /**
     * 
     *
     * @return Current fillColor value. Default value is null
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public String getFillColor()  {
        return getAttributeAsString("fillColor");
    }
    

    /**
     * 
     *
     * @param startAngle New startAngle value. Default value is 0
     * @return {@link com.smartgwt.client.widgets.drawing.GaugeSector GaugeSector} instance, for chaining setter calls
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public GaugeSector setStartAngle(float startAngle) {
        return (GaugeSector)setAttribute("startAngle", startAngle);
    }

    /**
     * 
     *
     * @return Current startAngle value. Default value is 0
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public float getStartAngle()  {
        return getAttributeAsFloat("startAngle");
    }

    /**
     * 
     *
     * @param startAngle New startAngle value. Default value is 0
     * @return {@link com.smartgwt.client.widgets.drawing.GaugeSector GaugeSector} instance, for chaining setter calls
     */
    public GaugeSector setStartAngle(double startAngle) {
        return (GaugeSector)setAttribute("startAngle", startAngle);
    }

    /**
     * 
     *
     * @return Current startAngle value. Default value is 0
     */
    public double getStartAngleAsDouble()  {
        return getAttributeAsDouble("startAngle");
    }
    

    /**
     * 
     *
     * @param value New value value. Default value is 0
     * @return {@link com.smartgwt.client.widgets.drawing.GaugeSector GaugeSector} instance, for chaining setter calls
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public GaugeSector setValue(float value) {
        return (GaugeSector)setAttribute("value", value);
    }

    /**
     * 
     *
     * @return Current value value. Default value is 0
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public float getValue()  {
        return getAttributeAsFloat("value");
    }

    /**
     * 
     *
     * @param value New value value. Default value is 0
     * @return {@link com.smartgwt.client.widgets.drawing.GaugeSector GaugeSector} instance, for chaining setter calls
     */
    public GaugeSector setValue(double value) {
        return (GaugeSector)setAttribute("value", value);
    }

    /**
     * 
     *
     * @return Current value value. Default value is 0
     */
    public double getValueAsDouble()  {
        return getAttributeAsDouble("value");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
