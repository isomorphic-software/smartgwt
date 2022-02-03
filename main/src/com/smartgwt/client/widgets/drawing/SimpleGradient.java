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
 * Definition of a simple linear gradient defined by 2 colors and a {@link
 * com.smartgwt.client.widgets.drawing.SimpleGradient#getDirection direction}.
 */
@BeanFactory.FrameworkClass
public class SimpleGradient extends Gradient {

    public static SimpleGradient getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new SimpleGradient(jsObj);
    }
        


    public SimpleGradient(){
        
    }

    public SimpleGradient(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Angle of the direction vector in degrees.  The default of 0.0 causes the gradient to sweep from the start color on the
     * left to the end color on the right.  Positive direction angles correspond to clockwise rotations of the default
     * gradient.
     *
     * @param direction New direction value. Default value is 0.0
     * @return {@link com.smartgwt.client.widgets.drawing.SimpleGradient SimpleGradient} instance, for chaining setter calls
     */
    public SimpleGradient setDirection(float direction) {
        return (SimpleGradient)setAttribute("direction", direction);
    }

    /**
     * Angle of the direction vector in degrees.  The default of 0.0 causes the gradient to sweep from the start color on the
     * left to the end color on the right.  Positive direction angles correspond to clockwise rotations of the default
     * gradient.
     *
     * @return Current direction value. Default value is 0.0
     */
    public float getDirection()  {
        return getAttributeAsFloat("direction");
    }
    

    /**
     * The end color of the gradient.
     *
     * @param endColor New endColor value. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.SimpleGradient SimpleGradient} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public SimpleGradient setEndColor(String endColor) {
        return (SimpleGradient)setAttribute("endColor", endColor);
    }

    /**
     * The end color of the gradient.
     *
     * @return Current endColor value. Default value is null
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public String getEndColor()  {
        return getAttributeAsString("endColor");
    }
    

    /**
     * The start color of the gradient.
     *
     * @param startColor New startColor value. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.SimpleGradient SimpleGradient} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public SimpleGradient setStartColor(String startColor) {
        return (SimpleGradient)setAttribute("startColor", startColor);
    }

    /**
     * The start color of the gradient.
     *
     * @return Current startColor value. Default value is null
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public String getStartColor()  {
        return getAttributeAsString("startColor");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
