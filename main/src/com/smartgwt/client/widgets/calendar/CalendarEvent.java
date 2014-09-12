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
 * A type of {@link com.smartgwt.client.data.Record} which represents an event to occur at a specific time, displayed
 * within the calendar.
 */
@BeanFactory.FrameworkClass
public class CalendarEvent extends Record {

    public static CalendarEvent getOrCreateRef(JavaScriptObject jsObj) {

        if(jsObj == null) return null;

        RefDataClass obj = RefDataClass.getRef(jsObj);


        if(obj != null && obj instanceof CalendarEvent) {
            obj.setJsObj(jsObj);
            return (CalendarEvent) obj;
        } else {
            return new CalendarEvent(jsObj);
        }
    }


    public CalendarEvent(){
        
    }

    public CalendarEvent(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    public CalendarEvent(int eventId, String name, String description, java.util.Date startDate, java.util.Date endDate     ) {
        setEventId(eventId);
		setName(name);
		setDescription(description);
		setStartDate(startDate);
		setEndDate     (endDate     );
                
    }


    public CalendarEvent(int eventId, String name, String description, java.util.Date startDate, java.util.Date endDate, boolean canEdit     ) {
        setEventId(eventId);
		setName(name);
		setDescription(description);
		setStartDate(startDate);
		setEndDate(endDate);
		setCanEdit     (canEdit     );
                
    }


    public CalendarEvent(int eventId, String name, String description, java.util.Date startDate, java.util.Date endDate, boolean canEdit, String eventWindowStyle     ) {
        setEventId(eventId);
		setName(name);
		setDescription(description);
		setStartDate(startDate);
		setEndDate(endDate);
		setCanEdit(canEdit);
		setEventWindowStyle     (eventWindowStyle     );
                
    }


    public CalendarEvent(int eventId, String name, String description, java.util.Date startDate, java.util.Date endDate, String lane     ) {
        setEventId(eventId);
		setName(name);
		setDescription(description);
		setStartDate(startDate);
		setEndDate(endDate);
		setLane     (lane     );
                
    }


    public CalendarEvent(int eventId, String name, String description, java.util.Date startDate, java.util.Date endDate, boolean canEdit, String eventWindowStyle, String lane     ) {
        setEventId(eventId);
		setName(name);
		setDescription(description);
		setStartDate(startDate);
		setEndDate(endDate);
		setCanEdit(canEdit);
		setEventWindowStyle(eventWindowStyle);
		setLane     (lane     );
                
    }


    public CalendarEvent(int eventId, String name, String description, java.util.Date startDate, java.util.Date endDate, boolean canEdit, String eventWindowStyle, String lane, String sublane     ) {
        setEventId(eventId);
		setName(name);
		setDescription(description);
		setStartDate(startDate);
		setEndDate(endDate);
		setCanEdit(canEdit);
		setEventWindowStyle(eventWindowStyle);
		setLane(lane);
		setSublane     (sublane     );
                
    }


    public CalendarEvent(int eventId, String name, String description, java.util.Date startDate, int duration, TimeUnit durationUnit     ) {
        setEventId(eventId);
		setName(name);
		setDescription(description);
		setStartDate(startDate);
		setDuration(duration);
		setDurationUnit     (durationUnit     );
                
    }


    public CalendarEvent(int eventId, String name, String description, java.util.Date startDate, int duration, TimeUnit durationUnit, String styleName     ) {
        setEventId(eventId);
		setName(name);
		setDescription(description);
		setStartDate(startDate);
		setDuration(duration);
		setDurationUnit(durationUnit);
		setStyleName     (styleName     );
                
    }


    public CalendarEvent(int eventId, String name, String description, java.util.Date startDate, int duration, TimeUnit durationUnit, String styleName, String lane     ) {
        setEventId(eventId);
		setName(name);
		setDescription(description);
		setStartDate(startDate);
		setDuration(duration);
		setDurationUnit(durationUnit);
		setStyleName(styleName);
		setLane     (lane     );
                
    }


    public CalendarEvent(int eventId, String name, String description, java.util.Date startDate, int duration, TimeUnit durationUnit, String styleName, String lane, String sublane     ) {
        setEventId(eventId);
		setName(name);
		setDescription(description);
		setStartDate(startDate);
		setDuration(duration);
		setDurationUnit(durationUnit);
		setStyleName(styleName);
		setLane(lane);
		setSublane     (sublane     );
                
    }


    // ********************* Properties / Attributes ***********************

    /**
     * An optional background color for this event's window.
     *
     * @param backgroundColor  Default value is null
     */
    public void setBackgroundColor(String backgroundColor) {
        setAttribute("backgroundColor", backgroundColor);
    }

    /**
     * An optional background color for this event's window.
     *
     * @return String
     */
    public String getBackgroundColor()  {
        return getAttributeAsString("backgroundColor");
    }
    

    /**
     * Optional boolean value controlling whether this event can be dragged with the mouse. The name of this field within the
     * CalendarEvent can be changed via {@link com.smartgwt.client.widgets.calendar.Calendar#getCanDragEventField
     * canDragEventField}.  Only has an effect when  {@link com.smartgwt.client.widgets.calendar.Calendar#getCanEditEvents
     * editing} is enabled. <P> You can separately disallow drag-resize via {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getCanResize canResize}.
     *
     * @param canDrag  Default value is null
     */
    public void setCanDrag(Boolean canDrag) {
        setAttribute("canDrag", canDrag);
    }

    /**
     * Optional boolean value controlling whether this event can be dragged with the mouse. The name of this field within the
     * CalendarEvent can be changed via {@link com.smartgwt.client.widgets.calendar.Calendar#getCanDragEventField
     * canDragEventField}.  Only has an effect when  {@link com.smartgwt.client.widgets.calendar.Calendar#getCanEditEvents
     * editing} is enabled. <P> You can separately disallow drag-resize via {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getCanResize canResize}.
     *
     * @return Boolean
     */
    public Boolean getCanDrag()  {
        return getAttributeAsBoolean("canDrag", true);
    }
    
    

    /**
     * Boolean indicating whether this event can be moved between lanes.  Can also be set at the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanEditLane calendar level}. <P> The name of this field within the
     * CalendarEvent can be changed via  {@link com.smartgwt.client.widgets.calendar.Calendar#getCanEditLaneField
     * canEditLaneField}.
     *
     * @param canEditLane  Default value is null
     */
    public void setCanEditLane(Boolean canEditLane) {
        setAttribute("canEditLane", canEditLane);
    }

    /**
     * Boolean indicating whether this event can be moved between lanes.  Can also be set at the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanEditLane calendar level}. <P> The name of this field within the
     * CalendarEvent can be changed via  {@link com.smartgwt.client.widgets.calendar.Calendar#getCanEditLaneField
     * canEditLaneField}.
     *
     * @return Boolean
     */
    public Boolean getCanEditLane()  {
        return getAttributeAsBoolean("canEditLane", true);
    }
    

    /**
     * Boolean indicating whether this event can be moved between lanes.  Can also be set at the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanEditSublane calendar level}. <P> The name of this field within the
     * CalendarEvent can be changed via  {@link com.smartgwt.client.widgets.calendar.Calendar#getCanEditSublaneField
     * canEditSublaneField}.
     *
     * @param canEditSublane  Default value is null
     */
    public void setCanEditSublane(Boolean canEditSublane) {
        setAttribute("canEditSublane", canEditSublane);
    }

    /**
     * Boolean indicating whether this event can be moved between lanes.  Can also be set at the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanEditSublane calendar level}. <P> The name of this field within the
     * CalendarEvent can be changed via  {@link com.smartgwt.client.widgets.calendar.Calendar#getCanEditSublaneField
     * canEditSublaneField}.
     *
     * @return Boolean
     */
    public Boolean getCanEditSublane()  {
        return getAttributeAsBoolean("canEditSublane", true);
    }
    

    /**
     * Optional boolean value controlling whether this event can be drag-resized with the mouse. The name of this field within
     * the CalendarEvent can be changed via {@link com.smartgwt.client.widgets.calendar.Calendar#getCanResizeEventField
     * canResizeEventField}. <P> Only has an effect if {@link com.smartgwt.client.widgets.calendar.Calendar#getCanEditEvents
     * editing} and  {@link com.smartgwt.client.widgets.calendar.Calendar#getCanDragEvents dragging} are also enabled.
     *
     * @param canResize  Default value is null
     */
    public void setCanResize(Boolean canResize) {
        setAttribute("canResize", canResize);
    }

    /**
     * Optional boolean value controlling whether this event can be drag-resized with the mouse. The name of this field within
     * the CalendarEvent can be changed via {@link com.smartgwt.client.widgets.calendar.Calendar#getCanResizeEventField
     * canResizeEventField}. <P> Only has an effect if {@link com.smartgwt.client.widgets.calendar.Calendar#getCanEditEvents
     * editing} and  {@link com.smartgwt.client.widgets.calendar.Calendar#getCanDragEvents dragging} are also enabled.
     *
     * @return Boolean
     */
    public Boolean getCanResize()  {
        return getAttributeAsBoolean("canResize", true);
    }
    

    /**
     * String which represents the description of a {@link com.smartgwt.client.widgets.calendar.CalendarEvent} The name of this
     * field within the CalendarEvent can be changed via {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDescriptionField descriptionField}
     *
     * @param description  Default value is null
     */
    public void setDescription(String description) {
        setAttribute("description", description);
    }

    /**
     * String which represents the description of a {@link com.smartgwt.client.widgets.calendar.CalendarEvent} The name of this
     * field within the CalendarEvent can be changed via {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDescriptionField descriptionField}
     *
     * @return String
     */
    public String getDescription()  {
        return getAttributeAsString("description");
    }
    

    /**
     * The duration of this event.  May be specified instead of an  {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getEndDate end date} and implies that this is a "Period" type event. 
     * If set to zero, implies an "Instant" type event - an event with a start date but no length.
     *
     * @param duration  Default value is null
     */
    public void setDuration(Integer duration) {
        setAttribute("duration", duration);
    }

    /**
     * The duration of this event.  May be specified instead of an  {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getEndDate end date} and implies that this is a "Period" type event. 
     * If set to zero, implies an "Instant" type event - an event with a start date but no length.
     *
     * @return Integer
     */
    public Integer getDuration()  {
        return getAttributeAsInt("duration");
    }
    

    /**
     * When a {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getDuration duration} is set for this event, this is
     * the unit of that duration.  The default is minutes.
     *
     * @param durationUnit  Default value is "minute"
     */
    public void setDurationUnit(TimeUnit durationUnit) {
        setAttribute("durationUnit", durationUnit == null ? null : durationUnit.getValue());
    }

    /**
     * When a {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getDuration duration} is set for this event, this is
     * the unit of that duration.  The default is minutes.
     *
     * @return TimeUnit
     */
    public TimeUnit getDurationUnit()  {
        return EnumUtil.getEnum(TimeUnit.values(), getAttribute("durationUnit"));
    }
    

    /**
     * Date object which represents the end date of a {@link com.smartgwt.client.widgets.calendar.CalendarEvent} The name of
     * this field within the CalendarEvent can be changed via {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEndDateField endDateField}
     *
     * @param endDate  Default value is null
     */
    public void setEndDate(Date endDate) {
        setAttribute("endDate", endDate);
    }

    /**
     * Date object which represents the end date of a {@link com.smartgwt.client.widgets.calendar.CalendarEvent} The name of
     * this field within the CalendarEvent can be changed via {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEndDateField endDateField}
     *
     * @return Date
     */
    public Date getEndDate()  {
        return getAttributeAsDate("endDate");
    }
    

    /**
     * CSS style series to use for the draggable event window that represents this event.  If specified, overrides {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventWindowStyle eventWindowStyle} for this specific event. <P> The
     * name of this field within the CalendarEvent can be changed via {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventWindowStyleField eventWindowStyleField}
     *
     * @param eventWindowStyle  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is null
     * @deprecated in favor of {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getStyleName styleName}
     */
    public void setEventWindowStyle(String eventWindowStyle) {
        setAttribute("eventWindowStyle", eventWindowStyle);
    }

    /**
     * CSS style series to use for the draggable event window that represents this event.  If specified, overrides {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventWindowStyle eventWindowStyle} for this specific event. <P> The
     * name of this field within the CalendarEvent can be changed via {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventWindowStyleField eventWindowStyleField}
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     * @deprecated in favor of {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getStyleName styleName}
     */
    public String getEventWindowStyle()  {
        return getAttributeAsString("eventWindowStyle");
    }
    

    /**
     * When in Timeline mode, or when {@link com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes showDayLanes} is
     * true, a string that  represents the name of the {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes lane} this
     * {@link com.smartgwt.client.widgets.calendar.CalendarEvent} should  sit in.  The name of this field within the
     * CalendarEvent can be changed via {@link com.smartgwt.client.widgets.calendar.Calendar#getLaneNameField laneNameField}.
     *
     * @param lane  Default value is null
     */
    public void setLane(String lane) {
        setAttribute("lane", lane);
    }

    /**
     * When in Timeline mode, or when {@link com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes showDayLanes} is
     * true, a string that  represents the name of the {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes lane} this
     * {@link com.smartgwt.client.widgets.calendar.CalendarEvent} should  sit in.  The name of this field within the
     * CalendarEvent can be changed via {@link com.smartgwt.client.widgets.calendar.Calendar#getLaneNameField laneNameField}.
     *
     * @return String
     */
    public String getLane()  {
        return getAttributeAsString("lane");
    }
    

    /**
     * String which represents the name of a {@link com.smartgwt.client.widgets.calendar.CalendarEvent} The name of this field
     * within the CalendarEvent can be changed via {@link com.smartgwt.client.widgets.calendar.Calendar#getNameField nameField}
     *
     * @param name  Default value is null
     */
    public void setName(String name) {
        setAttribute("name", name);
    }

    /**
     * String which represents the name of a {@link com.smartgwt.client.widgets.calendar.CalendarEvent} The name of this field
     * within the CalendarEvent can be changed via {@link com.smartgwt.client.widgets.calendar.Calendar#getNameField nameField}
     *
     * @return String
     */
    public String getName()  {
        return getAttributeAsString("name");
    }
    

    /**
     * Date object which represents the start date of a {@link com.smartgwt.client.widgets.calendar.CalendarEvent}. The name of
     * this field within the CalendarEvent can be changed via {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getStartDateField startDateField}
     *
     * @param startDate  Default value is null
     */
    public void setStartDate(Date startDate) {
        setAttribute("startDate", startDate);
    }

    /**
     * Date object which represents the start date of a {@link com.smartgwt.client.widgets.calendar.CalendarEvent}. The name of
     * this field within the CalendarEvent can be changed via {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getStartDateField startDateField}
     *
     * @return Date
     */
    public Date getStartDate()  {
        return getAttributeAsDate("startDate");
    }
    

    /**
     * CSS style series to use for the draggable {@link com.smartgwt.client.widgets.calendar.Calendar#getEventCanvas canvas}
     * that  represents this event.  If not specified, can be picked up from a value specified on the  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventStyleName calendar}, the {@link
     * com.smartgwt.client.widgets.calendar.CalendarView#getEventStyleName view} or individually on each {@link
     * com.smartgwt.client.widgets.calendar.Lane#getEventStyleName lane} or {@link
     * com.smartgwt.client.widgets.calendar.Lane#getSublanes sublane}. <P> The name of this field within the CalendarEvent can
     * be changed via {@link com.smartgwt.client.widgets.calendar.Calendar#getEventStyleNameField eventStyleNameField}
     *
     * @param styleName  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is null
     */
    public void setStyleName(String styleName) {
        setAttribute("styleName", styleName);
    }

    /**
     * CSS style series to use for the draggable {@link com.smartgwt.client.widgets.calendar.Calendar#getEventCanvas canvas}
     * that  represents this event.  If not specified, can be picked up from a value specified on the  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventStyleName calendar}, the {@link
     * com.smartgwt.client.widgets.calendar.CalendarView#getEventStyleName view} or individually on each {@link
     * com.smartgwt.client.widgets.calendar.Lane#getEventStyleName lane} or {@link
     * com.smartgwt.client.widgets.calendar.Lane#getSublanes sublane}. <P> The name of this field within the CalendarEvent can
     * be changed via {@link com.smartgwt.client.widgets.calendar.Calendar#getEventStyleNameField eventStyleNameField}
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     */
    public String getStyleName()  {
        return getAttributeAsString("styleName");
    }
    

    /**
     * When in Timeline mode, or when {@link com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes showDayLanes} is
     * true, a string that  represents the name of the {@link com.smartgwt.client.widgets.calendar.Lane#getSublanes sublane}
     * this {@link com.smartgwt.client.widgets.calendar.CalendarEvent} should  sit in.  The name of this field within the
     * CalendarEvent can be changed via {@link com.smartgwt.client.widgets.calendar.Calendar#getSublaneNameField
     * sublaneNameField}.
     *
     * @param sublane  Default value is null
     */
    public void setSublane(String sublane) {
        setAttribute("sublane", sublane);
    }

    /**
     * When in Timeline mode, or when {@link com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes showDayLanes} is
     * true, a string that  represents the name of the {@link com.smartgwt.client.widgets.calendar.Lane#getSublanes sublane}
     * this {@link com.smartgwt.client.widgets.calendar.CalendarEvent} should  sit in.  The name of this field within the
     * CalendarEvent can be changed via {@link com.smartgwt.client.widgets.calendar.Calendar#getSublaneNameField
     * sublaneNameField}.
     *
     * @return String
     */
    public String getSublane()  {
        return getAttributeAsString("sublane");
    }
    

    /**
     * An optional text color for this event's window.
     *
     * @param textColor  Default value is null
     */
    public void setTextColor(String textColor) {
        setAttribute("textColor", textColor);
    }

    /**
     * An optional text color for this event's window.
     *
     * @return String
     */
    public String getTextColor()  {
        return getAttributeAsString("textColor");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************


    public void setEventId(Integer eventId) {
        setAttribute("eventId", eventId);
    }

    public Integer getEventId() {
        return getAttributeAsInt("eventId");
    }

    /**
     * Optional boolean value controlling the editability of this particular calendarEvent.  The name of this field
     * within the CalendarEvent can be changed via   {@link com.smartgwt.client.widgets.calendar.Calendar#getCanEditField
     * canEditField}.
     *
     * @param canEdit canEdit Default value is null
     */
    public void setCanEdit(Boolean canEdit) {
        setAttribute("canEdit", canEdit);
    }

    /**
     * Optional boolean value controlling the editability of this particular calendarEvent.  The name of this field
     * within the CalendarEvent can be changed via   {@link com.smartgwt.client.widgets.calendar.Calendar#getCanEditField
     * canEditField}.
     *
     * @return String
     */
    public Boolean getCanEdit() {
        return getAttributeAsBoolean("canEdit");
    }

}


