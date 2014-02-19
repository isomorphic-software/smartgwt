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
 
package com.smartgwt.client.widgets.drawing;



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
 * DrawItem subclass to render triangles
 */
public class DrawTriangle extends DrawItem {

    public static DrawTriangle getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (DrawTriangle) obj;
        } else {
            return new DrawTriangle(jsObj);
        }
    }

    public DrawTriangle(){
        scClassName = "DrawTriangle";
    }

    public DrawTriangle(JavaScriptObject jsObj){
        super(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
     * Style of drawing the corners of triangle.
     *
     * @param lineCap lineCap Default value is "butt"
     */
    public void setLineCap(LineCap lineCap) {
        setAttribute("lineCap", lineCap == null ? null : lineCap.getValue(), true);
    }

    /**
     * Style of drawing the corners of triangle.
     *
     *
     * @return LineCap
     */
    public LineCap getLineCap()  {
        return EnumUtil.getEnum(LineCap.values(), getAttribute("lineCap"));
    }

    /**
     * Array of Points for the triangle.
     *
     * @param points points Default value is [[0,0], [50,50], [100,0]]
     */
    public void setPoints(Point... points) {
        setAttribute("points", points, true);
    }

    /**
     * Array of Points for the triangle.
     *
     *
     * @return Point
     */
    public Point[] getPoints()  {
        return Point.convertToPointArray(getAttributeAsJavaScriptObject("points"));
    }

    // ********************* Methods ***********************
            
    /**
     * Executed when dragging first starts. Your widget can use this opportunity to set things up for the drag, such as setting
     * the drag tracker. Returning false from this event handler will cancel the drag action entirely. <p> A drag action is
     * considered to be begin when the mouse has moved {@link com.smartgwt.client.widgets.Canvas#getDragStartDistance
     * dragStartDistance} with the left mouse down.
     *
     * @return false to cancel drag action.
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_dd_pan" target="examples">Drag pan Example</a>
     */
    public native Boolean dragStart() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var retVal =self.dragStart();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    // ********************* Static Methods ***********************
        
    // ***********************************************************        

}



