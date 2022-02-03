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
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * X/Y position in pixels, specified as an Array with two members, for example: [30, 50]
 */
@BeanFactory.FrameworkClass
public class Point extends RefDataClass {

    public static Point getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof Point) {
            existingObj.setJsObj(jsObj);
            return (Point)existingObj;
        } else

        {
            return new Point(jsObj);
        }
    }
        


    public Point(){
        this.setJsObj(JSOHelper.createJavaScriptArray());
    }

    public Point(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************
    
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************



    public Point(int x, int y) {
        this();
        setX(x);
        setY(y);
    }

    public Point(double x, double y) {
        this();
        setX(x);
        setY(y);
    }

    /**
     * The x coordinate of this point.
     *
     * @param x x Default value is 0
     */
    private void setX(int x) {
        JSOHelper.setArrayValue(getJsObj(), 0, x);
    }

    /**
     * The x coordinate of this point.
     *
     * @param x x Default value is 0
     */
    private void setX(double x) {
        JSOHelper.setArrayValue(getJsObj(), 0, x);
    }

    /**
     * The x coordinate of this point.
     *
     *
     * @return int
     */
    public int getX()  {
        return JSOHelper.getIntArrayValue(getJsObj(), 0);
    }

    /**
     * The x coordinate of this point.
     *
     *
     * @return double
     */
    public double getXAsDouble()  {
        return JSOHelper.getdoubleArrayValue(getJsObj(), 0);
    }

    /**
     * The y coordinate of this point.
     *
     * @param y y Default value is 0
     */
    private void setY(int y) {
        JSOHelper.setArrayValue(getJsObj(), 1, y);
    }

    /**
     * The y coordinate of this point.
     *
     * @param y y Default value is 0
     */
    private void setY(double y) {
        JSOHelper.setArrayValue(getJsObj(), 1, y);
    }

    /**
     * The y coordinate of this point.
     *
     *
     * @return int
     */
    public int getY()  {
        return JSOHelper.getIntArrayValue(getJsObj(), 1);
    }

    /**
     * The y coordinate of this point.
     *
     *
     * @return double
     */
    public double getYAsDouble()  {
        return JSOHelper.getdoubleArrayValue(getJsObj(), 1);
    }

}
