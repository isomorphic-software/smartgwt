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
     * Direction vector in degrees
     *
     * @param direction  Default value is 0.0
     */
    public void setDirection(float direction) {
        setAttribute("direction", direction);
    }

    /**
     * Direction vector in degrees
     *
     * @return float
     */
    public float getDirection()  {
        return getAttributeAsFloat("direction");
    }
    

    /**
     * The end color of the gradient.
     *
     * @param endColor  See {@link com.smartgwt.client.docs.CSSColor CSSColor} . Default value is null
     */
    public void setEndColor(String endColor) {
        setAttribute("endColor", endColor);
    }

    /**
     * The end color of the gradient.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSColor CSSColor} 
     */
    public String getEndColor()  {
        return getAttributeAsString("endColor");
    }
    

    /**
     * The start color of the gradient.
     *
     * @param startColor  See {@link com.smartgwt.client.docs.CSSColor CSSColor} . Default value is null
     */
    public void setStartColor(String startColor) {
        setAttribute("startColor", startColor);
    }

    /**
     * The start color of the gradient.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSColor CSSColor} 
     */
    public String getStartColor()  {
        return getAttributeAsString("startColor");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}


