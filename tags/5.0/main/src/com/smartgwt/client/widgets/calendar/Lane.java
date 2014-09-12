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
 
package com.smartgwt.client.widgets.calendar;


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
 * Lane shown in a {@link com.smartgwt.client.widgets.calendar.Timeline} view, or in a {@link
 * com.smartgwt.client.widgets.calendar.Calendar#getDayView day view} when  {@link
 * com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes showDayLanes} is true.  Each lane is a row or column, 
 * respectively, that can contain a set of {@link com.smartgwt.client.widgets.calendar.CalendarEvent}s.  CalendarEvents are
 * placed in lanes by matching the {@link com.smartgwt.client.widgets.calendar.Lane#getName name} property to the value of
 * the  {@link com.smartgwt.client.widgets.calendar.Calendar#getLaneNameField laneNameField} property on the CalendarEvent.
 * <P> Lanes are typically used to show tasks assigned to different people, broadcasts planned for different channels, and
 * similar displays.
 */
@BeanFactory.FrameworkClass
public class Lane extends RefDataClass {

    public static Lane getOrCreateRef(JavaScriptObject jsObj) {

        if(jsObj == null) return null;

        RefDataClass obj = RefDataClass.getRef(jsObj);


        if(obj != null) {
            obj.setJsObj(jsObj);
            return (Lane) obj;
        } else {
            return new Lane(jsObj);
        }
    }


    public Lane(){
        
    }

    public Lane(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    public Lane(String name, String title) {
        setName(name);
		setTitle(title);
                
    }


    // ********************* Properties / Attributes ***********************

    /**
     * The base name for the CSS class applied to {@link com.smartgwt.client.widgets.calendar.Calendar#getEventCanvas events}
     * when they're rendered in this lane.  See {@link com.smartgwt.client.widgets.calendar.Calendar#getEventStyleName
     * eventStyleName}. <P> If set directly on a {@link com.smartgwt.client.widgets.calendar.Lane#getSublanes sublane},
     * overrides the corresponding value on the the parent {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes lane}.
     * See  {@link com.smartgwt.client.widgets.calendar.Calendar#getEventCanvasStyle getEventCanvasStyle()} for more
     * information.
     *
     * @param eventStyleName  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setEventStyleName(String eventStyleName) {
        setAttribute("eventStyleName", eventStyleName);
    }

    /**
     * The base name for the CSS class applied to {@link com.smartgwt.client.widgets.calendar.Calendar#getEventCanvas events}
     * when they're rendered in this lane.  See {@link com.smartgwt.client.widgets.calendar.Calendar#getEventStyleName
     * eventStyleName}. <P> If set directly on a {@link com.smartgwt.client.widgets.calendar.Lane#getSublanes sublane},
     * overrides the corresponding value on the the parent {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes lane}.
     * See  {@link com.smartgwt.client.widgets.calendar.Calendar#getEventCanvasStyle getEventCanvasStyle()} for more
     * information.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getEventStyleName()  {
        return getAttributeAsString("eventStyleName");
    }
    

    /**
     * In {@link com.smartgwt.client.widgets.calendar.Timeline}s, the height of this Lane's row.  Has no effect when set on a
     * Lane  being displayed in a {@link com.smartgwt.client.widgets.calendar.Calendar#getDayView day view} as a result of 
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes showDayLanes} being true. <P> If set directly on a
     * {@link com.smartgwt.client.widgets.calendar.Lane#getSublanes sublane}, overrides the default behavior of  dividing the
     * height equally among the lane's sublanes.  Each sublane is still initially  assigned an equal slice of the parent
     * height, and the value for this sublane is  then updated.  So the overall height of the parent lane will change by the
     * delta between the  initial slice and the specified one.
     *
     * @param height  Default value is null
     */
    public void setHeight(Integer height) {
        setAttribute("height", height);
    }

    /**
     * In {@link com.smartgwt.client.widgets.calendar.Timeline}s, the height of this Lane's row.  Has no effect when set on a
     * Lane  being displayed in a {@link com.smartgwt.client.widgets.calendar.Calendar#getDayView day view} as a result of 
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes showDayLanes} being true. <P> If set directly on a
     * {@link com.smartgwt.client.widgets.calendar.Lane#getSublanes sublane}, overrides the default behavior of  dividing the
     * height equally among the lane's sublanes.  Each sublane is still initially  assigned an equal slice of the parent
     * height, and the value for this sublane is  then updated.  So the overall height of the parent lane will change by the
     * delta between the  initial slice and the specified one.
     *
     * @return Integer
     */
    public Integer getHeight()  {
        return getAttributeAsInt("height");
    }
    

    /**
     * To determine whether a CalendarEvent should be placed in this lane, the value of this  attribute is compared with the
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getLaneNameField laneNameField} property on the CalendarEvent.
     *
     * @param name  Default value is null
     */
    public void setName(String name) {
        setAttribute("name", name);
    }

    /**
     * To determine whether a CalendarEvent should be placed in this lane, the value of this  attribute is compared with the
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getLaneNameField laneNameField} property on the CalendarEvent.
     *
     * @return String
     */
    public String getName()  {
        return getAttributeAsString("name");
    }
    

    /**
     * Array of {@link com.smartgwt.client.widgets.calendar.Lane} objects that will share the available space in the parent
     * Lane, vertically in {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timelines} and horizontally in 
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getDayView day views}. <P> Only one level of sublanes is supported,
     * so this attribute only has an effect on {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes top-level lanes}.
     * <P> Note that this feature is mutually exclusive with the  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventAutoArrange auto arrangement} of events that share time.
     *
     * @param sublanes  Default value is null
     */
    public void setSublanes(Lane... sublanes) {
        setAttribute("sublanes", sublanes);
    }

    /**
     * Array of {@link com.smartgwt.client.widgets.calendar.Lane} objects that will share the available space in the parent
     * Lane, vertically in {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timelines} and horizontally in 
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getDayView day views}. <P> Only one level of sublanes is supported,
     * so this attribute only has an effect on {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes top-level lanes}.
     * <P> Note that this feature is mutually exclusive with the  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventAutoArrange auto arrangement} of events that share time.
     *
     * @return Lane...
     */
    public Lane[] getSublanes()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfLane(getAttributeAsJavaScriptObject("sublanes"));
    }
    

    /**
     * Title to show for this lane.  Has no effect if set directly on {@link
     * com.smartgwt.client.widgets.calendar.Lane#getSublanes sublanes}.
     *
     * @param title  See {@link com.smartgwt.client.docs.HTMLString HTMLString} . Default value is null
     */
    public void setTitle(String title) {
        setAttribute("title", title);
    }

    /**
     * Title to show for this lane.  Has no effect if set directly on {@link
     * com.smartgwt.client.widgets.calendar.Lane#getSublanes sublanes}.
     *
     * @return  See {@link com.smartgwt.client.docs.HTMLString HTMLString} 
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }
    

    /**
     * When set on a Lane being displayed in a {@link com.smartgwt.client.widgets.calendar.Calendar#getDayView day view} as a
     * result of  {@link com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes showDayLanes} being set, dictates the
     * width of the Lane's column.  Has no  effect in {@link com.smartgwt.client.widgets.calendar.Timeline}s. <P> If set
     * directly on a {@link com.smartgwt.client.widgets.calendar.Lane#getSublanes sublane}, overrides the default behavior of 
     * dividing the width equally among the lane's sublanes.  Each sublane is still initially  assigned an equal slice of the
     * original parent width, and the value for this sublane is then updated.  So the overall width of the parent lane will
     * change by the delta between the  initial slice and the specified one.
     *
     * @param width  Default value is null
     */
    public void setWidth(Integer width) {
        setAttribute("width", width);
    }

    /**
     * When set on a Lane being displayed in a {@link com.smartgwt.client.widgets.calendar.Calendar#getDayView day view} as a
     * result of  {@link com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes showDayLanes} being set, dictates the
     * width of the Lane's column.  Has no  effect in {@link com.smartgwt.client.widgets.calendar.Timeline}s. <P> If set
     * directly on a {@link com.smartgwt.client.widgets.calendar.Lane#getSublanes sublane}, overrides the default behavior of 
     * dividing the width equally among the lane's sublanes.  Each sublane is still initially  assigned an equal slice of the
     * original parent width, and the value for this sublane is then updated.  So the overall width of the parent lane will
     * change by the delta between the  initial slice and the specified one.
     *
     * @return Integer
     */
    public Integer getWidth()  {
        return getAttributeAsInt("width");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}


