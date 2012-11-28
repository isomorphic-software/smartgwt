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
 * DrawItem subclass to render a connector between two points. If the points are aligned  on one axis, this connector will
 * draw as a straight line. If the points are offset on  both axes and there is enough space, the connector will draw short
 * horizontal segments  from the start and end points, and a diagonal segment connecting the ends of these  'margin'
 * segments.
 */
public class DrawLinePath extends DrawPath {

    public static DrawLinePath getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (DrawLinePath) obj;
        } else {
            return new DrawLinePath(jsObj);
        }
    }

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        id = JSOHelper.getAttribute(jsObj, "ID");
    }


    public DrawLinePath(){
        scClassName = "DrawLinePath";
    }

    public DrawLinePath(JavaScriptObject jsObj){
        scClassName = "DrawLinePath";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
     * Style of arrowhead to draw at the end of the line or path.
     *
     * @param endArrow endArrow Default value is "open", IRW
     */
    public void setEndArrow(ArrowStyle endArrow) {
        setAttribute("endArrow", endArrow == null ? null : endArrow.getValue(), true);
    }

    /**
     * Style of arrowhead to draw at the end of the line or path.
     *
     *
     * @return ArrowStyle
     */
    public ArrowStyle getEndArrow()  {
        return EnumUtil.getEnum(ArrowStyle.values(), getAttribute("endArrow"));
    }

    /**
     * Ending left coordinate of the line.  Overrides left coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLinePath#getEndPoint endPoint} if both are set.
     *
     * @param endLeft endLeft Default value is 0 , IRW
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setEndLeft(int endLeft)  throws IllegalStateException {
        setAttribute("endLeft", endLeft, false);
    }

    /**
     * Ending left coordinate of the line.  Overrides left coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLinePath#getEndPoint endPoint} if both are set.
     *
     *
     * @return int
     */
    public int getEndLeft()  {
        return getAttributeAsInt("endLeft");
    }

    /**
     * End point of the line
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Update the endPoint
     *
     * @param endPoint left coordinate for end point, in pixels. Default value is [100,100]
     */
    public void setEndPoint(Point endPoint) {
        setAttribute("endPoint", endPoint.getJsObj(), true);
    }

    /**
     * End point of the line
     *
     *
     * @return Point
     */
    public Point getEndPoint()  {
        return new Point(getAttributeAsJavaScriptObject("endPoint"));
    }

    /**
     * Ending top coordinate of the line.  Overrides top coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLinePath#getEndPoint endPoint} if both are set.
     *
     * @param endTop endTop Default value is 0 , IRW
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setEndTop(int endTop)  throws IllegalStateException {
        setAttribute("endTop", endTop, false);
    }

    /**
     * Ending top coordinate of the line.  Overrides top coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLinePath#getEndPoint endPoint} if both are set.
     *
     *
     * @return int
     */
    public int getEndTop()  {
        return getAttributeAsInt("endTop");
    }

    /**
     * Starting left coordinate of the line.  Overrides left coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLinePath#getStartPoint startPoint} if both are set.
     *
     * @param startLeft startLeft Default value is 0 , IRW
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setStartLeft(int startLeft)  throws IllegalStateException {
        setAttribute("startLeft", startLeft, false);
    }

    /**
     * Starting left coordinate of the line.  Overrides left coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLinePath#getStartPoint startPoint} if both are set.
     *
     *
     * @return int
     */
    public int getStartLeft()  {
        return getAttributeAsInt("startLeft");
    }

    /**
     * Start point of the line
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Update the startPoint
     *
     * @param startPoint left coordinate for start point, in pixels. Default value is [0,0]
     */
    public void setStartPoint(Point startPoint) {
        setAttribute("startPoint", startPoint.getJsObj(), true);
    }

    /**
     * Start point of the line
     *
     *
     * @return Point
     */
    public Point getStartPoint()  {
        return new Point(getAttributeAsJavaScriptObject("startPoint"));
    }

    /**
     * Starting top coordinate of the line.  Overrides top coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLinePath#getStartPoint startPoint} if both are set.
     *
     * @param startTop startTop Default value is 0 , IRW
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setStartTop(int startTop)  throws IllegalStateException {
        setAttribute("startTop", startTop, false);
    }

    /**
     * Starting top coordinate of the line.  Overrides top coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLinePath#getStartPoint startPoint} if both are set.
     *
     *
     * @return int
     */
    public int getStartTop()  {
        return getAttributeAsInt("startTop");
    }

    /**
     * Length of the horizontal "tail" between the start and end points of this LinePath and the diagonal connecting segment
     *
     * @param tailSize tailSize Default value is 30
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setTailSize(int tailSize)  throws IllegalStateException {
        setAttribute("tailSize", tailSize, false);
    }

    /**
     * Length of the horizontal "tail" between the start and end points of this LinePath and the diagonal connecting segment
     *
     *
     * @return int
     */
    public int getTailSize()  {
        return getAttributeAsInt("tailSize");
    }

    // ********************* Methods ***********************

    /**
     * Move both the start and end points of the line by a relative amount.
     * @param left change to left coordinate in pixels
     * @param top change to top coordinate in pixels
     */
    public native void moveBy(int left, int top) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.moveBy(left, top);
    }-*/;

    // ********************* Static Methods ***********************
        
    // ***********************************************************        

}



