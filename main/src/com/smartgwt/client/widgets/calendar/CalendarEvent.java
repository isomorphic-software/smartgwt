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
 * A type of {@link com.smartgwt.client.data.Record} which represents an event to occur at a specific time, displayed
 * within the calendar.
 */
@BeanFactory.FrameworkClass
public class CalendarEvent extends Record {

    public static CalendarEvent getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof CalendarEvent) {
            existingObj.setJsObj(jsObj);
            return (CalendarEvent)existingObj;
        } else

        {
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
     * An optional background color for the body portion of {@link com.smartgwt.client.widgets.calendar.EventCanvas canvases}
     * representing this event in the various {@link com.smartgwt.client.widgets.calendar.CalendarView calendar views}. <P>
     * Note that the recommended approach for styling events is to set a {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getStyleName custom CSS style}, which allows more complete
     * customization of both header and body portions.
     *
     * @param backgroundColor New backgroundColor value. Default value is null
     */
    public void setBackgroundColor(String backgroundColor) {
        setAttribute("backgroundColor", backgroundColor);
    }

    /**
     * An optional background color for the body portion of {@link com.smartgwt.client.widgets.calendar.EventCanvas canvases}
     * representing this event in the various {@link com.smartgwt.client.widgets.calendar.CalendarView calendar views}. <P>
     * Note that the recommended approach for styling events is to set a {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getStyleName custom CSS style}, which allows more complete
     * customization of both header and body portions.
     *
     * @return Current backgroundColor value. Default value is null
     */
    public String getBackgroundColor()  {
        return getAttributeAsString("backgroundColor");
    }
    

    /**
     * An optional border color for the body portion of {@link com.smartgwt.client.widgets.calendar.EventCanvas canvases}
     * representing this event in the various {@link com.smartgwt.client.widgets.calendar.CalendarView calendar views}. <P>
     * Note that the recommended approach for styling events is to set a {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getStyleName custom CSS style}, which allows more complete
     * customization of both header and body portions.
     *
     * @param borderColor New borderColor value. Default value is null
     */
    public void setBorderColor(String borderColor) {
        setAttribute("borderColor", borderColor);
    }

    /**
     * An optional border color for the body portion of {@link com.smartgwt.client.widgets.calendar.EventCanvas canvases}
     * representing this event in the various {@link com.smartgwt.client.widgets.calendar.CalendarView calendar views}. <P>
     * Note that the recommended approach for styling events is to set a {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getStyleName custom CSS style}, which allows more complete
     * customization of both header and body portions.
     *
     * @return Current borderColor value. Default value is null
     */
    public String getBorderColor()  {
        return getAttributeAsString("borderColor");
    }
    

    /**
     * Optional boolean value controlling whether this event can be dragged with the mouse. The name of this field within the
     * CalendarEvent can be changed via {@link com.smartgwt.client.widgets.calendar.Calendar#getCanDragEventField
     * Calendar.canDragEventField}.  Only has an effect when  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanEditEvents editing} is enabled. <P> You can separately disallow
     * drag-resize via {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getCanResize canResize}.
     *
     * @param canDrag New canDrag value. Default value is null
     */
    public void setCanDrag(Boolean canDrag) {
        setAttribute("canDrag", canDrag);
    }

    /**
     * Optional boolean value controlling whether this event can be dragged with the mouse. The name of this field within the
     * CalendarEvent can be changed via {@link com.smartgwt.client.widgets.calendar.Calendar#getCanDragEventField
     * Calendar.canDragEventField}.  Only has an effect when  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanEditEvents editing} is enabled. <P> You can separately disallow
     * drag-resize via {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getCanResize canResize}.
     *
     * @return Current canDrag value. Default value is null
     */
    public Boolean getCanDrag()  {
        return getAttributeAsBoolean("canDrag", true);
    }
    
    

    /**
     * Boolean indicating whether this event can be moved between lanes.  Can also be set at the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanEditLane calendar level}. <P> The name of this field within the
     * CalendarEvent can be changed via  {@link com.smartgwt.client.widgets.calendar.Calendar#getCanEditLaneField
     * Calendar.canEditLaneField}.
     *
     * @param canEditLane New canEditLane value. Default value is null
     */
    public void setCanEditLane(Boolean canEditLane) {
        setAttribute("canEditLane", canEditLane);
    }

    /**
     * Boolean indicating whether this event can be moved between lanes.  Can also be set at the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanEditLane calendar level}. <P> The name of this field within the
     * CalendarEvent can be changed via  {@link com.smartgwt.client.widgets.calendar.Calendar#getCanEditLaneField
     * Calendar.canEditLaneField}.
     *
     * @return Current canEditLane value. Default value is null
     */
    public Boolean getCanEditLane()  {
        return getAttributeAsBoolean("canEditLane", true);
    }
    

    /**
     * Boolean indicating whether this event can be moved between lanes.  Can also be set at the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanEditSublane calendar level}. <P> The name of this field within the
     * CalendarEvent can be changed via  {@link com.smartgwt.client.widgets.calendar.Calendar#getCanEditSublaneField
     * Calendar.canEditSublaneField}.
     *
     * @param canEditSublane New canEditSublane value. Default value is null
     */
    public void setCanEditSublane(Boolean canEditSublane) {
        setAttribute("canEditSublane", canEditSublane);
    }

    /**
     * Boolean indicating whether this event can be moved between lanes.  Can also be set at the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanEditSublane calendar level}. <P> The name of this field within the
     * CalendarEvent can be changed via  {@link com.smartgwt.client.widgets.calendar.Calendar#getCanEditSublaneField
     * Calendar.canEditSublaneField}.
     *
     * @return Current canEditSublane value. Default value is null
     */
    public Boolean getCanEditSublane()  {
        return getAttributeAsBoolean("canEditSublane", true);
    }
    

    /**
     * Optional boolean value controlling whether this event can be drag-resized with the mouse. The name of this field within
     * the CalendarEvent can be changed via {@link com.smartgwt.client.widgets.calendar.Calendar#getCanResizeEventField
     * Calendar.canResizeEventField}. <P> Only has an effect if {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanEditEvents editing} and  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanDragEvents dragging} are also enabled.
     *
     * @param canResize New canResize value. Default value is null
     */
    public void setCanResize(Boolean canResize) {
        setAttribute("canResize", canResize);
    }

    /**
     * Optional boolean value controlling whether this event can be drag-resized with the mouse. The name of this field within
     * the CalendarEvent can be changed via {@link com.smartgwt.client.widgets.calendar.Calendar#getCanResizeEventField
     * Calendar.canResizeEventField}. <P> Only has an effect if {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanEditEvents editing} and  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanDragEvents dragging} are also enabled.
     *
     * @return Current canResize value. Default value is null
     */
    public Boolean getCanResize()  {
        return getAttributeAsBoolean("canResize", true);
    }
    

    /**
     * String which represents the description of a {@link com.smartgwt.client.widgets.calendar.CalendarEvent} The name of this
     * field within the CalendarEvent can be changed via {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDescriptionField Calendar.descriptionField}
     *
     * @param description New description value. Default value is null
     */
    public void setDescription(String description) {
        setAttribute("description", description);
    }

    /**
     * String which represents the description of a {@link com.smartgwt.client.widgets.calendar.CalendarEvent} The name of this
     * field within the CalendarEvent can be changed via {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDescriptionField Calendar.descriptionField}
     *
     * @return Current description value. Default value is null
     */
    public String getDescription()  {
        return getAttributeAsString("description");
    }
    

    /**
     * The duration of this event.  May be specified instead of an  {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getEndDate end date} and implies that this is a "Period" type event. 
     * If set to zero, implies an "Instant" type event - an event with a start date but no length.
     *
     * @param duration New duration value. Default value is null
     */
    public void setDuration(Integer duration) {
        setAttribute("duration", duration);
    }

    /**
     * The duration of this event.  May be specified instead of an  {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getEndDate end date} and implies that this is a "Period" type event. 
     * If set to zero, implies an "Instant" type event - an event with a start date but no length.
     *
     * @return Current duration value. Default value is null
     */
    public Integer getDuration()  {
        return getAttributeAsInt("duration");
    }
    

    /**
     * When a {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getDuration duration} is set for this event, this is
     * the unit of that duration.  The default is minutes.
     *
     * @param durationUnit New durationUnit value. Default value is "minute"
     */
    public void setDurationUnit(TimeUnit durationUnit) {
        setAttribute("durationUnit", durationUnit == null ? null : durationUnit.getValue());
    }

    /**
     * When a {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getDuration duration} is set for this event, this is
     * the unit of that duration.  The default is minutes.
     *
     * @return Current durationUnit value. Default value is "minute"
     */
    public TimeUnit getDurationUnit()  {
        return EnumUtil.getEnum(TimeUnit.values(), getAttribute("durationUnit"));
    }
    

    /**
     * Date object which represents the end date of a {@link com.smartgwt.client.widgets.calendar.CalendarEvent} The name of
     * this field within the CalendarEvent can be changed via {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEndDateField Calendar.endDateField}
     *
     * @param endDate New endDate value. Default value is null
     */
    public void setEndDate(Date endDate) {
        setAttribute("endDate", endDate);
    }

    /**
     * Date object which represents the end date of a {@link com.smartgwt.client.widgets.calendar.CalendarEvent} The name of
     * this field within the CalendarEvent can be changed via {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEndDateField Calendar.endDateField}
     *
     * @return Current endDate value. Default value is null
     */
    public Date getEndDate()  {
        return getAttributeAsDate("endDate");
    }
    

    /**
     * CSS style series to use for the draggable event window that represents this event.  If specified, overrides {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventWindowStyle Calendar.eventWindowStyle} for this specific event.
     * <P> The name of this field within the CalendarEvent can be changed via {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventWindowStyleField Calendar.eventWindowStyleField}
     *
     * @param eventWindowStyle New eventWindowStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @deprecated in favor of {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getStyleName styleName}
     */
    public void setEventWindowStyle(String eventWindowStyle) {
        setAttribute("eventWindowStyle", eventWindowStyle);
    }

    /**
     * CSS style series to use for the draggable event window that represents this event.  If specified, overrides {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventWindowStyle Calendar.eventWindowStyle} for this specific event.
     * <P> The name of this field within the CalendarEvent can be changed via {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventWindowStyleField Calendar.eventWindowStyleField}
     *
     * @return Current eventWindowStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @deprecated in favor of {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getStyleName styleName}
     */
    public String getEventWindowStyle()  {
        return getAttributeAsString("eventWindowStyle");
    }
    

    /**
     * An optional background color for the header portion of {@link com.smartgwt.client.widgets.calendar.EventCanvas canvases}
     * representing this event in the various {@link com.smartgwt.client.widgets.calendar.CalendarView calendar views}. <P>
     * Note that the recommended approach for styling events is to set a {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getStyleName custom CSS style}, which allows more complete
     * customization of both header and body portions.
     *
     * @param headerBackgroundColor New headerBackgroundColor value. Default value is null
     */
    public void setHeaderBackgroundColor(String headerBackgroundColor) {
        setAttribute("headerBackgroundColor", headerBackgroundColor);
    }

    /**
     * An optional background color for the header portion of {@link com.smartgwt.client.widgets.calendar.EventCanvas canvases}
     * representing this event in the various {@link com.smartgwt.client.widgets.calendar.CalendarView calendar views}. <P>
     * Note that the recommended approach for styling events is to set a {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getStyleName custom CSS style}, which allows more complete
     * customization of both header and body portions.
     *
     * @return Current headerBackgroundColor value. Default value is null
     */
    public String getHeaderBackgroundColor()  {
        return getAttributeAsString("headerBackgroundColor");
    }
    

    /**
     * An optional border color for the header portion of {@link com.smartgwt.client.widgets.calendar.EventCanvas canvases}
     * representing this event in the various {@link com.smartgwt.client.widgets.calendar.CalendarView calendar views}. <P>
     * Note that the recommended approach for styling events is to set a {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getStyleName custom CSS style}, which allows more complete
     * customization of both header and body portions.
     *
     * @param headerBorderColor New headerBorderColor value. Default value is null
     */
    public void setHeaderBorderColor(String headerBorderColor) {
        setAttribute("headerBorderColor", headerBorderColor);
    }

    /**
     * An optional border color for the header portion of {@link com.smartgwt.client.widgets.calendar.EventCanvas canvases}
     * representing this event in the various {@link com.smartgwt.client.widgets.calendar.CalendarView calendar views}. <P>
     * Note that the recommended approach for styling events is to set a {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getStyleName custom CSS style}, which allows more complete
     * customization of both header and body portions.
     *
     * @return Current headerBorderColor value. Default value is null
     */
    public String getHeaderBorderColor()  {
        return getAttributeAsString("headerBorderColor");
    }
    

    /**
     * An optional text color for the header portion of {@link com.smartgwt.client.widgets.calendar.EventCanvas canvases}
     * representing this event in the various {@link com.smartgwt.client.widgets.calendar.CalendarView calendar views}. <P>
     * Note that the recommended approach for styling events is to set a {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getStyleName custom CSS style}, which allows more complete
     * customization of both header and body portions.
     *
     * @param headerTextColor New headerTextColor value. Default value is null
     */
    public void setHeaderTextColor(String headerTextColor) {
        setAttribute("headerTextColor", headerTextColor);
    }

    /**
     * An optional text color for the header portion of {@link com.smartgwt.client.widgets.calendar.EventCanvas canvases}
     * representing this event in the various {@link com.smartgwt.client.widgets.calendar.CalendarView calendar views}. <P>
     * Note that the recommended approach for styling events is to set a {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getStyleName custom CSS style}, which allows more complete
     * customization of both header and body portions.
     *
     * @return Current headerTextColor value. Default value is null
     */
    public String getHeaderTextColor()  {
        return getAttributeAsString("headerTextColor");
    }
    

    /**
     * When in Timeline mode, or when {@link com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes
     * Calendar.showDayLanes} is true, a string that  represents the name of the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getLanes lane} this {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent} should  sit in.  The name of this field within the CalendarEvent can
     * be changed via {@link com.smartgwt.client.widgets.calendar.Calendar#getLaneNameField Calendar.laneNameField}.
     *
     * @param lane New lane value. Default value is null
     */
    public void setLane(String lane) {
        setAttribute("lane", lane);
    }

    /**
     * When in Timeline mode, or when {@link com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes
     * Calendar.showDayLanes} is true, a string that  represents the name of the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getLanes lane} this {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent} should  sit in.  The name of this field within the CalendarEvent can
     * be changed via {@link com.smartgwt.client.widgets.calendar.Calendar#getLaneNameField Calendar.laneNameField}.
     *
     * @return Current lane value. Default value is null
     */
    public String getLane()  {
        return getAttributeAsString("lane");
    }
    

    /**
     * String which represents the name of a {@link com.smartgwt.client.widgets.calendar.CalendarEvent} The name of this field
     * within the CalendarEvent can be changed via {@link com.smartgwt.client.widgets.calendar.Calendar#getNameField
     * Calendar.nameField}
     *
     * @param name New name value. Default value is null
     */
    public void setName(String name) {
        setAttribute("name", name);
    }

    /**
     * String which represents the name of a {@link com.smartgwt.client.widgets.calendar.CalendarEvent} The name of this field
     * within the CalendarEvent can be changed via {@link com.smartgwt.client.widgets.calendar.Calendar#getNameField
     * Calendar.nameField}
     *
     * @return Current name value. Default value is null
     */
    public String getName()  {
        return getAttributeAsString("name");
    }
    

    /**
     * Date object which represents the start date of a {@link com.smartgwt.client.widgets.calendar.CalendarEvent}. The name of
     * this field within the CalendarEvent can be changed via {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getStartDateField Calendar.startDateField}
     *
     * @param startDate New startDate value. Default value is null
     */
    public void setStartDate(Date startDate) {
        setAttribute("startDate", startDate);
    }

    /**
     * Date object which represents the start date of a {@link com.smartgwt.client.widgets.calendar.CalendarEvent}. The name of
     * this field within the CalendarEvent can be changed via {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getStartDateField Calendar.startDateField}
     *
     * @return Current startDate value. Default value is null
     */
    public Date getStartDate()  {
        return getAttributeAsDate("startDate");
    }
    

    /**
     * CSS style series to use for {@link com.smartgwt.client.widgets.calendar.Calendar#getEventCanvas canvas instances} that 
     * represent this event in the various {@link com.smartgwt.client.widgets.calendar.CalendarView calendar views}.  The basic
     * series should include three classes - the base style and others suffixed "Header" and "Body". <P> If not specified on
     * the event, the style can be specified on the  {@link com.smartgwt.client.widgets.calendar.Calendar#getEventStyleName
     * calendar}, the {@link com.smartgwt.client.widgets.calendar.CalendarView#getEventStyleName view} or individually on each
     * {@link com.smartgwt.client.widgets.calendar.Lane#getEventStyleName lane} or {@link
     * com.smartgwt.client.widgets.calendar.Lane#getSublanes sublane}. <P> The name of this field within the CalendarEvent can
     * be changed via {@link com.smartgwt.client.widgets.calendar.Calendar#getEventStyleNameField Calendar.eventStyleNameField}
     *
     * @param styleName New styleName value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setStyleName(String styleName) {
        setAttribute("styleName", styleName);
    }

    /**
     * CSS style series to use for {@link com.smartgwt.client.widgets.calendar.Calendar#getEventCanvas canvas instances} that 
     * represent this event in the various {@link com.smartgwt.client.widgets.calendar.CalendarView calendar views}.  The basic
     * series should include three classes - the base style and others suffixed "Header" and "Body". <P> If not specified on
     * the event, the style can be specified on the  {@link com.smartgwt.client.widgets.calendar.Calendar#getEventStyleName
     * calendar}, the {@link com.smartgwt.client.widgets.calendar.CalendarView#getEventStyleName view} or individually on each
     * {@link com.smartgwt.client.widgets.calendar.Lane#getEventStyleName lane} or {@link
     * com.smartgwt.client.widgets.calendar.Lane#getSublanes sublane}. <P> The name of this field within the CalendarEvent can
     * be changed via {@link com.smartgwt.client.widgets.calendar.Calendar#getEventStyleNameField Calendar.eventStyleNameField}
     *
     * @return Current styleName value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getStyleName()  {
        return getAttributeAsString("styleName");
    }
    

    /**
     * When in Timeline mode, or when {@link com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes
     * Calendar.showDayLanes} is true, a string that  represents the name of the {@link
     * com.smartgwt.client.widgets.calendar.Lane#getSublanes sublane} this {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent} should  sit in.  The name of this field within the CalendarEvent can
     * be changed via {@link com.smartgwt.client.widgets.calendar.Calendar#getSublaneNameField Calendar.sublaneNameField}.
     *
     * @param sublane New sublane value. Default value is null
     */
    public void setSublane(String sublane) {
        setAttribute("sublane", sublane);
    }

    /**
     * When in Timeline mode, or when {@link com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes
     * Calendar.showDayLanes} is true, a string that  represents the name of the {@link
     * com.smartgwt.client.widgets.calendar.Lane#getSublanes sublane} this {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent} should  sit in.  The name of this field within the CalendarEvent can
     * be changed via {@link com.smartgwt.client.widgets.calendar.Calendar#getSublaneNameField Calendar.sublaneNameField}.
     *
     * @return Current sublane value. Default value is null
     */
    public String getSublane()  {
        return getAttributeAsString("sublane");
    }
    

    /**
     * An optional text color for the body portion of {@link com.smartgwt.client.widgets.calendar.EventCanvas canvases}
     * representing this event in the various {@link com.smartgwt.client.widgets.calendar.CalendarView calendar views}. <P>
     * Note that the recommended approach for styling events is to set a {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getStyleName custom CSS style}, which allows more complete
     * customization of both header and body portions.
     *
     * @param textColor New textColor value. Default value is null
     */
    public void setTextColor(String textColor) {
        setAttribute("textColor", textColor);
    }

    /**
     * An optional text color for the body portion of {@link com.smartgwt.client.widgets.calendar.EventCanvas canvases}
     * representing this event in the various {@link com.smartgwt.client.widgets.calendar.CalendarView calendar views}. <P>
     * Note that the recommended approach for styling events is to set a {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getStyleName custom CSS style}, which allows more complete
     * customization of both header and body portions.
     *
     * @return Current textColor value. Default value is null
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
