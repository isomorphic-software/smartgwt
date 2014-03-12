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
 * Definition of a linear gradient between two points, ({@link com.smartgwt.client.widgets.drawing.LinearGradient#getX1
 * x1}, {@link com.smartgwt.client.widgets.drawing.LinearGradient#getY1 y1}) and ({@link
 * com.smartgwt.client.widgets.drawing.LinearGradient#getX2 x2}, {@link
 * com.smartgwt.client.widgets.drawing.LinearGradient#getY2 y2}).
 */
@BeanFactory.FrameworkClass
public class LinearGradient extends Gradient {

    public static LinearGradient getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new LinearGradient(jsObj);
    }


    public LinearGradient(){
        
    }

    public LinearGradient(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    /**
     * X coordinate of the start point. This can be a number or a percentage of the width of the bounding box of the DrawItem
     * to which it is applied.
     *
     * @param x1  Default value is null
     */
    public void setX1(String x1) {
        setAttribute("x1", x1);
    }

    /**
     * X coordinate of the start point. This can be a number or a percentage of the width of the bounding box of the DrawItem
     * to which it is applied.
     *
     * @return String
     */
    public String getX1()  {
        return getAttributeAsString("x1");
    }

    /**
     * X coordinate of the end point. This can be a number or a percentage of the width of the bounding box of the DrawItem to
     * which it is applied.
     *
     * @param x2  Default value is null
     */
    public void setX2(String x2) {
        setAttribute("x2", x2);
    }

    /**
     * X coordinate of the end point. This can be a number or a percentage of the width of the bounding box of the DrawItem to
     * which it is applied.
     *
     * @return String
     */
    public String getX2()  {
        return getAttributeAsString("x2");
    }

    /**
     * Y coordinate of the start point. This can be a number or a percentage of the height of the bounding box of the DrawItem
     * to which it is applied.
     *
     * @param y1  Default value is null
     */
    public void setY1(String y1) {
        setAttribute("y1", y1);
    }

    /**
     * Y coordinate of the start point. This can be a number or a percentage of the height of the bounding box of the DrawItem
     * to which it is applied.
     *
     * @return String
     */
    public String getY1()  {
        return getAttributeAsString("y1");
    }

    /**
     * Y coordinate of the end point. This can be a number or a percentage of the height of the bounding box of the DrawItem to
     * which it is applied.
     *
     * @param y2  Default value is null
     */
    public void setY2(String y2) {
        setAttribute("y2", y2);
    }

    /**
     * Y coordinate of the end point. This can be a number or a percentage of the height of the bounding box of the DrawItem to
     * which it is applied.
     *
     * @return String
     */
    public String getY2()  {
        return getAttributeAsString("y2");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}


