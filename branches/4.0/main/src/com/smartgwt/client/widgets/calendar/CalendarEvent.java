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
import com.smartgwt.client.callbacks.*;
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

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }



    public CalendarEvent(){
        
    }

    public CalendarEvent(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
        
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

    public CalendarEvent(int eventId, String name, String description, java.util.Date startDate, java.util.Date endDate, String lane
				) {
        setEventId(eventId);
		setName(name);
		setDescription(description);
		setStartDate(startDate);
		setEndDate(endDate);
		setLane
				(lane
				);
        
    }

    public CalendarEvent(int eventId, String name, String description, java.util.Date startDate, java.util.Date endDate, boolean canEdit, String eventWindowStyle, String lane
				) {
        setEventId(eventId);
		setName(name);
		setDescription(description);
		setStartDate(startDate);
		setEndDate(endDate);
		setCanEdit(canEdit);
		setEventWindowStyle(eventWindowStyle);
		setLane
				(lane
				);
        
    }


    // ********************* Properties / Attributes ***********************


    /**
     * An optional background color for this event's window.
     *
     * @param backgroundColor . See {@link com.smartgwt.client.docs.String String}. Default value is null
     */
    public void setBackgroundColor(String backgroundColor) {
        setAttribute("backgroundColor", backgroundColor);
    }

    /**
     * An optional background color for this event's window.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getBackgroundColor()  {
        return getAttributeAsString("backgroundColor");
    }



    /**
     * String which represents the description of a {@link com.smartgwt.client.widgets.calendar.CalendarEvent} The name of this
     * field within the CalendarEvent can be changed via {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDescriptionField descriptionField}
     *
     * @param description . See {@link com.smartgwt.client.docs.String String}. Default value is null
     */
    public void setDescription(String description) {
        setAttribute("description", description);
    }

    /**
     * String which represents the description of a {@link com.smartgwt.client.widgets.calendar.CalendarEvent} The name of this
     * field within the CalendarEvent can be changed via {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDescriptionField descriptionField}
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getDescription()  {
        return getAttributeAsString("description");
    }


    /**
     * Date object which represents the end date of a {@link com.smartgwt.client.widgets.calendar.CalendarEvent} The name of
     * this field within the CalendarEvent can be changed via {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEndDateField endDateField}
     *
     * @param endDate endDate Default value is null
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
     * @param eventWindowStyle . See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName}. Default value is null
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
     * @return . See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName}
     */
    public String getEventWindowStyle()  {
        return getAttributeAsString("eventWindowStyle");
    }


    /**
     * When in Timeline mode, a string that represents the name of the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getLanes lane} this {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent} should sit in. The name of this field within the CalendarEvent can
     * be changed via {@link com.smartgwt.client.widgets.calendar.Calendar#getLaneNameField laneNameField}.
     *
     * @param lane . See {@link com.smartgwt.client.docs.String String}. Default value is null
     */
    public void setLane(String lane) {
        setAttribute("lane", lane);
    }

    /**
     * When in Timeline mode, a string that represents the name of the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getLanes lane} this {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent} should sit in. The name of this field within the CalendarEvent can
     * be changed via {@link com.smartgwt.client.widgets.calendar.Calendar#getLaneNameField laneNameField}.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getLane()  {
        return getAttributeAsString("lane");
    }


    /**
     * String which represents the name of a {@link com.smartgwt.client.widgets.calendar.CalendarEvent} The name of this field
     * within the CalendarEvent can be changed via {@link com.smartgwt.client.widgets.calendar.Calendar#getNameField nameField}
     *
     * @param name . See {@link com.smartgwt.client.docs.String String}. Default value is null
     */
    public void setName(String name) {
        setAttribute("name", name);
    }

    /**
     * String which represents the name of a {@link com.smartgwt.client.widgets.calendar.CalendarEvent} The name of this field
     * within the CalendarEvent can be changed via {@link com.smartgwt.client.widgets.calendar.Calendar#getNameField nameField}
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getName()  {
        return getAttributeAsString("name");
    }


    /**
     * Date object which represents the start date of a {@link com.smartgwt.client.widgets.calendar.CalendarEvent}. The name of
     * this field within the CalendarEvent can be changed via {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getStartDateField startDateField}
     *
     * @param startDate startDate Default value is null
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
     * An optional text color for this event's window.
     *
     * @param textColor . See {@link com.smartgwt.client.docs.String String}. Default value is null
     */
    public void setTextColor(String textColor) {
        setAttribute("textColor", textColor);
    }

    /**
     * An optional text color for this event's window.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
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



