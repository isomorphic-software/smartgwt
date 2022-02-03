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
 * Defines a simple gradient vertical gradient between {@link com.smartgwt.client.widgets.drawing.Gradient#getStartColor
 * two} {@link com.smartgwt.client.widgets.drawing.Gradient#getEndColor colors}, or using {@link
 * com.smartgwt.client.widgets.drawing.Gradient#getColorStops colorStops}.  See {@link
 * com.smartgwt.client.widgets.drawing.SimpleGradient}, {@link com.smartgwt.client.widgets.drawing.LinearGradient} and
 * {@link com.smartgwt.client.widgets.drawing.RadialGradient} for further properties to define more advanced gradients.
 */
@BeanFactory.FrameworkClass
public class Gradient extends DataClass {

    public static Gradient getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new Gradient(jsObj);
    }
        


    public Gradient(){
        
    }

    public Gradient(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    /**
     * An array of color stops for this gradient.
     *
     * @param colorStops New colorStops value. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.Gradient Gradient} instance, for chaining setter calls
     */
    public Gradient setColorStops(ColorStop... colorStops) {
        return (Gradient)setAttribute("colorStops", colorStops);
    }

    /**
     * An array of color stops for this gradient.
     *
     * @return Current colorStops value. Default value is null
     */
    public ColorStop[] getColorStops()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfColorStop(getAttributeAsJavaScriptObject("colorStops"));
    }
    

    /**
     * An end color for the gradient. If both {@link com.smartgwt.client.widgets.drawing.Gradient#getStartColor startColor} and
     * endColor are set then {@link com.smartgwt.client.widgets.drawing.Gradient#getColorStops colorStops} is ignored.
     *
     * @param endColor New endColor value. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.Gradient Gradient} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public Gradient setEndColor(String endColor) {
        return (Gradient)setAttribute("endColor", endColor);
    }

    /**
     * An end color for the gradient. If both {@link com.smartgwt.client.widgets.drawing.Gradient#getStartColor startColor} and
     * endColor are set then {@link com.smartgwt.client.widgets.drawing.Gradient#getColorStops colorStops} is ignored.
     *
     * @return Current endColor value. Default value is null
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public String getEndColor()  {
        return getAttributeAsString("endColor");
    }
    

    /**
     * Identifier which can be used by one or more DrawItems when gradient is assigned to {@link
     * com.smartgwt.client.widgets.drawing.DrawPane#getGradients DrawPane.gradients}. The ID property is optional when gradient
     * is assigned directly to a DrawItem. <p> The ID must be unique within DrawPane.gradients if defined.
     *
     * @param id New id value. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.Gradient Gradient} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Identifier Identifier 
     */
    public Gradient setId(String id) {
        return (Gradient)setAttribute("id", id);
    }

    /**
     * Identifier which can be used by one or more DrawItems when gradient is assigned to {@link
     * com.smartgwt.client.widgets.drawing.DrawPane#getGradients DrawPane.gradients}. The ID property is optional when gradient
     * is assigned directly to a DrawItem. <p> The ID must be unique within DrawPane.gradients if defined.
     *
     * @return Current id value. Default value is null
     * @see com.smartgwt.client.docs.Identifier Identifier 
     */
    public String getId()  {
        return getAttributeAsString("id");
    }
    

    /**
     * A start color for the gradient. If both startColor and {@link com.smartgwt.client.widgets.drawing.Gradient#getEndColor
     * endColor} are set then {@link com.smartgwt.client.widgets.drawing.Gradient#getColorStops colorStops} is ignored.
     *
     * @param startColor New startColor value. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.Gradient Gradient} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public Gradient setStartColor(String startColor) {
        return (Gradient)setAttribute("startColor", startColor);
    }

    /**
     * A start color for the gradient. If both startColor and {@link com.smartgwt.client.widgets.drawing.Gradient#getEndColor
     * endColor} are set then {@link com.smartgwt.client.widgets.drawing.Gradient#getColorStops colorStops} is ignored.
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
