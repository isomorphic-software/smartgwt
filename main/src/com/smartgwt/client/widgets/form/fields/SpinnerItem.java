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
 
package com.smartgwt.client.widgets.form.fields;



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
 * Item for picking a number. Includes arrow buttons to increase / decrease the value
 */
public class SpinnerItem extends TextItem {

    public static SpinnerItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (SpinnerItem) obj;
        } else {
            return new SpinnerItem(jsObj);
        }
    }

    public SpinnerItem(){
        setType("SpinnerItem");
    }

    public SpinnerItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public SpinnerItem(String name) {
        setName(name);
        setType("SpinnerItem");
    }

    public SpinnerItem(String name, String title) {
        setName(name);
		setTitle(title);
        setType("SpinnerItem");
    }

    // ********************* Properties / Attributes ***********************






    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
        
    // ***********************************************************        


    /**
     * How much should the value be incremented / decremented when the user hits the icons  to increase / decrease the
     * value?
     *
     * @param step step Default value is 1
     */
    public void setStep(double step) {
        setAttribute("step", step);
    }

    public void setStep(int step) {
        setAttribute("step", step);
    }

    /**
     * How much should the value be incremented / decremented when the user hits the icons  to increase / decrease the
     * value?
     *
     * @return int
     */
    public double getStep() {
        return getAttributeAsFloat("step");
    }

    /**
     * Maximum valid value for this item
     *
     * @param max max Default value is null
     */
    public void setMax(Double max) {
        setAttribute("max", max);
    }

    public void setMax(Integer max) {
        setAttribute("max", max);
    }

    /**
     * Maximum valid value for this item
     *
     * @return Integer
     */
    public Double getMax() {
        return getAttributeAsDouble("max");
    }

    /**
     * Minimum valid value for this item
     *
     * @param min min Default value is null
     */
    public void setMin(Double min) {
        setAttribute("min", min);
    }

    public void setMin(Integer min) {
        setAttribute("min", min);
    }

    /**
     * Minimum valid value for this item
     *
     * @return Integer
     */
    public Double getMin() {
        return getAttributeAsDouble("min");
    }

    public void setDefaultValue(Double defaultValue) {
        setAttribute("defaultValue", defaultValue);
    }

    public void setDefaultValue(Integer defaultValue) {
        setAttribute("defaultValue", defaultValue);
    }       

}



