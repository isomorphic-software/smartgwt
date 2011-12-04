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
 
package com.smartgwt.client.widgets.calendar;



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
 * A type of {@link com.smartgwt.client.data.Record} which represents an event to occur at a specific time, displayed
 * within the calendar.
 */
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
        super(jsObj);
    }

    public CalendarEvent(int eventId, String name, String description, java.util.Date startDate, java.util.Date endDate
				) {
        setEventId(eventId);
		setName(name);
		setDescription(description);
		setStartDate(startDate);
		setEndDate
				(endDate
				);
        
    }

    public CalendarEvent(int eventId, String name, String description, java.util.Date startDate, java.util.Date endDate, boolean canEdit
				) {
        setEventId(eventId);
		setName(name);
		setDescription(description);
		setStartDate(startDate);
		setEndDate(endDate);
		setCanEdit
				(canEdit
				);
        
    }

    public CalendarEvent(int eventId, String name, String description, java.util.Date startDate, java.util.Date endDate, boolean canEdit, String eventWindowStyle
				) {
        setEventId(eventId);
		setName(name);
		setDescription(description);
		setStartDate(startDate);
		setEndDate(endDate);
		setCanEdit(canEdit);
		setEventWindowStyle
				(eventWindowStyle
				);
        
    }

    // ********************* Properties / Attributes ***********************

    /**
     * String which represents the description of a {@link com.smartgwt.client.widgets.calendar.CalendarEvent} The name of this
     * field within the CalendarEvent can be changed via  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDescriptionField descriptionField}
     *
     * @param description description Default value is null
     */
    public void setDescription(String description) {
        setAttribute("description", description);
    }

    /**
     * String which represents the description of a {@link com.smartgwt.client.widgets.calendar.CalendarEvent} The name of this
     * field within the CalendarEvent can be changed via  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDescriptionField descriptionField}
     *
     *
     * @return String
     */
    public String getDescription()  {
        return getAttributeAsString("description");
    }

    /**
     * Date object which represents the end date of a {@link com.smartgwt.client.widgets.calendar.CalendarEvent} The name of
     * this field within the CalendarEvent can be changed via  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEndDateField endDateField}
     *
     * @param endDate endDate Default value is null
     */
    public void setEndDate(java.util.Date endDate) {
        setAttribute("endDate", endDate);
    }

    /**
     * Date object which represents the end date of a {@link com.smartgwt.client.widgets.calendar.CalendarEvent} The name of
     * this field within the CalendarEvent can be changed via  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEndDateField endDateField}
     *
     *
     * @return java.util.Date
     */
    public java.util.Date getEndDate()  {
        return getAttributeAsDate("endDate");
    }

    /**
     * CSS style series to use for the draggable event window that represents this event.  If specified, overrides {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventWindowStyle eventWindowStyle} for this specific event. <P> The
     * name of this field within the CalendarEvent can be changed via  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventWindowStyleField eventWindowStyleField}
     *
     * @param eventWindowStyle eventWindowStyle Default value is null
     */
    public void setEventWindowStyle(String eventWindowStyle) {
        setAttribute("eventWindowStyle", eventWindowStyle);
    }

    /**
     * CSS style series to use for the draggable event window that represents this event.  If specified, overrides {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventWindowStyle eventWindowStyle} for this specific event. <P> The
     * name of this field within the CalendarEvent can be changed via  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventWindowStyleField eventWindowStyleField}
     *
     *
     * @return String
     */
    public String getEventWindowStyle()  {
        return getAttributeAsString("eventWindowStyle");
    }

    /**
     * String which represents the name of a {@link com.smartgwt.client.widgets.calendar.CalendarEvent} The name of this field
     * within the CalendarEvent can be changed via  {@link com.smartgwt.client.widgets.calendar.Calendar#getNameField
     * nameField}
     *
     * @param name name Default value is null
     */
    public void setName(String name) {
        setAttribute("name", name);
    }

    /**
     * String which represents the name of a {@link com.smartgwt.client.widgets.calendar.CalendarEvent} The name of this field
     * within the CalendarEvent can be changed via  {@link com.smartgwt.client.widgets.calendar.Calendar#getNameField
     * nameField}
     *
     *
     * @return String
     */
    public String getName()  {
        return getAttributeAsString("name");
    }

    /**
     * Date object which represents the start date of a {@link com.smartgwt.client.widgets.calendar.CalendarEvent}. The name of
     * this field within the CalendarEvent can be changed via  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getStartDateField startDateField}
     *
     * @param startDate startDate Default value is null
     */
    public void setStartDate(java.util.Date startDate) {
        setAttribute("startDate", startDate);
    }

    /**
     * Date object which represents the start date of a {@link com.smartgwt.client.widgets.calendar.CalendarEvent}. The name of
     * this field within the CalendarEvent can be changed via  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getStartDateField startDateField}
     *
     *
     * @return java.util.Date
     */
    public java.util.Date getStartDate()  {
        return getAttributeAsDate("startDate");
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

    private static CalendarEvent[] convertToCalendarEventArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new CalendarEvent[]{};
        }
        JavaScriptObject[] componentsj = JSOHelper.toArray(nativeArray);
        CalendarEvent[] objects = new CalendarEvent[componentsj.length];
        for (int i = 0; i < componentsj.length; i++) {
            JavaScriptObject componentJS = componentsj[i];
            CalendarEvent obj = (CalendarEvent) RefDataClass.getRef(componentJS);
            if (obj == null) obj = new CalendarEvent(componentJS);
            objects[i] = obj;
        }
        return objects;
    }

}




