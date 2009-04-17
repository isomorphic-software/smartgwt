/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
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
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.EnumUtil;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
   /**
    * The Calendar component provides several different ways for a user to view and edit a set of events. Note that the <b>ISC_Calendar.js</b> module must be loaded to make use of the Calendar class. <P> <b>CalendarEvents</b> <P> Events are represented as ordinary JavaScript Objects (see ${isc.DocUtils.linkForRef('object:CalendarEvent')}).  The Calendar expects to be able to read and write a basic set of properties on events: name, startDate, endDate, description, etc, which can be stored under configurable property names (see eg {@link com.smartgwt.client.widgets.calendar.Calendar#getStartDateField startDateField}. <P> Much like a {@link com.smartgwt.client.widgets.grid.ListGrid} manages it's ListGridRecords, the Calendar can either be passed a ordinary Array of CalendarEvents or can fetch data from a DataSource. <P> If the calendar is bound to a DataSource, event changes by user action or by calling methods will be saved to the DataSource. <P> <b>Navigation</b> <P> The calendar supports a {@link com.smartgwt.client.widgets.calendar.Calendar#getWeekView weekView}, {@link com.smartgwt.client.widgets.calendar.Calendar#getDayView dayView} and {@link com.smartgwt.client.widgets.calendar.Calendar#getMonthView monthView} by default.  The user can navigate using back and forward buttons or via an attached {@link com.smartgwt.client.widgets.calendar.Calendar#getDateChooser dateChooser}. <P> <b>Event Manipulation</b> <P> Events can be created via clicking on the day, week or month views, or via the "Add Event" button.  In the day and week views, the user may click and drag to create an event of a specific duration. <P> Creating an event via click or click and drag pops up the {@link com.smartgwt.client.widgets.calendar.Calendar#getEventDialog eventDialog}, which provides a simple form for quick event entry (only one field, the description, is required by default).   <P> A separate editor called the {@link com.smartgwt.client.widgets.calendar.Calendar#getEventEditor eventEditor} provides an interface for editing all possible properties of an event, including custom properties.  The EventEditor is used whenever a pre-existing event is being edited, and can also be invoked by the user wherever the simpler EventDialog appears. <P> Events can also be programmatically {@link com.smartgwt.client.widgets.calendar.Calendar#addEvent}, {@link com.smartgwt.client.widgets.calendar.Calendar#removeEvent}, or {@link com.smartgwt.client.widgets.calendar.Calendar#updateEvent}.

    */










public class Calendar extends Canvas  implements DataBoundComponent, com.smartgwt.client.widgets.calendar.events.HasDayBodyClickHandlers, com.smartgwt.client.widgets.calendar.events.HasDayHeaderClickHandlers, com.smartgwt.client.widgets.calendar.events.HasEventChangedHandlers, com.smartgwt.client.widgets.calendar.events.HasEventClickHandlers, com.smartgwt.client.widgets.calendar.events.HasEventRemoveClickHandlers, com.smartgwt.client.widgets.calendar.events.HasEventMovedHandlers, com.smartgwt.client.widgets.calendar.events.HasEventAddedHandlers, com.smartgwt.client.widgets.calendar.events.HasEventRemovedHandlers, com.smartgwt.client.widgets.calendar.events.HasEventResizedHandlers, com.smartgwt.client.widgets.calendar.events.HasDateChangedHandlers {

    public static Calendar getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (Calendar) obj;
        } else {
            return new Calendar(jsObj);
        }
    }


    public Calendar(){
        
    }

    public Calendar(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var widget = $wnd.isc.Calendar.create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
    * The date for which events are displayed in the day, week, and month tabs of the calendar. Default is today.
    * Set the current date for which the calendar will display events.
    *
    * @param chosenDate the new date to set as the current date. Default value is 'Today'
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setChosenDate(java.util.Date chosenDate)  throws IllegalStateException {
        setAttribute("chosenDate", chosenDate, false);
    }
    /**
     * The date for which events are displayed in the day, week, and month tabs of the calendar. Default is today.
     *
     *
     * @return java.util.Date
     *
     */
    public java.util.Date getChosenDate()  {
        return getAttributeAsDate("chosenDate");
    }

    /**
    * The numeric day (0-6) which the calendar should consider as the first day of the week
    *
    * @param firstDayOfWeek firstDayOfWeek Default value is 0
    */
    public void setFirstDayOfWeek(int firstDayOfWeek) {
        setAttribute("firstDayOfWeek", firstDayOfWeek, true);
    }
    /**
     * The numeric day (0-6) which the calendar should consider as the first day of the week
     *
     *
     * @return int
     *
     */
    public int getFirstDayOfWeek()  {
        return getAttributeAsInt("firstDayOfWeek");
    }

    /**
    * The base name for the CSS class applied to the grid cells of the day and week views of the calendar. This style will have "Dark", "Over", "Selected", or "Disabled" appended to it according to the state of the cell.
    *
    * @param baseStyle baseStyle Default value is "calendar"
    */
    public void setBaseStyle(String baseStyle) {
        setAttribute("baseStyle", baseStyle, true);
    }
    /**
     * The base name for the CSS class applied to the grid cells of the day and week views of the calendar. This style will have "Dark", "Over", "Selected", or "Disabled" appended to it according to the state of the cell.
     *
     *
     * @return String
     *
     */
    public String getBaseStyle()  {
        return getAttributeAsString("baseStyle");
    }

    /**
    * The base name for the CSS class applied to the day headers of the month view. This style will have "Dark", "Over", "Selected", or "Disabled" appended to it according to the state of the cell.
    *
    * @param dayHeaderBaseStyle dayHeaderBaseStyle Default value is "calMonthDayHeader"
    */
    public void setDayHeaderBaseStyle(String dayHeaderBaseStyle) {
        setAttribute("dayHeaderBaseStyle", dayHeaderBaseStyle, true);
    }
    /**
     * The base name for the CSS class applied to the day headers of the month view. This style will have "Dark", "Over", "Selected", or "Disabled" appended to it according to the state of the cell.
     *
     *
     * @return String
     *
     */
    public String getDayHeaderBaseStyle()  {
        return getAttributeAsString("dayHeaderBaseStyle");
    }

    /**
    * The base name for the CSS class applied to the day body of the month view of the calendar. This style will have "Dark", "Over", "Selected", or "Disabled" appended to it according to the state of the cell.
    *
    * @param dayBodyBaseStyle dayBodyBaseStyle Default value is "calMonthDayBody"
    */
    public void setDayBodyBaseStyle(String dayBodyBaseStyle) {
        setAttribute("dayBodyBaseStyle", dayBodyBaseStyle, true);
    }
    /**
     * The base name for the CSS class applied to the day body of the month view of the calendar. This style will have "Dark", "Over", "Selected", or "Disabled" appended to it according to the state of the cell.
     *
     *
     * @return String
     *
     */
    public String getDayBodyBaseStyle()  {
        return getAttributeAsString("dayBodyBaseStyle");
    }

    /**
    * The base name for the CSS class applied to the day headers of the month view. This style will have "Dark", "Over", "Selected", or "Disabled" appended to it according to the state of the cell.
    *
    * @param otherDayHeaderBaseStyle otherDayHeaderBaseStyle Default value is "calMonthDayHeader"
    */
    public void setOtherDayHeaderBaseStyle(String otherDayHeaderBaseStyle) {
        setAttribute("otherDayHeaderBaseStyle", otherDayHeaderBaseStyle, true);
    }
    /**
     * The base name for the CSS class applied to the day headers of the month view. This style will have "Dark", "Over", "Selected", or "Disabled" appended to it according to the state of the cell.
     *
     *
     * @return String
     *
     */
    public String getOtherDayHeaderBaseStyle()  {
        return getAttributeAsString("otherDayHeaderBaseStyle");
    }

    /**
    * The base name for the CSS class applied to the day body of the month view of the calendar. This style will have "Dark", "Over", "Selected", or "Disabled" appended to it according to the state of the cell.
    *
    * @param otherDayBodyBaseStyle otherDayBodyBaseStyle Default value is "calMonthDayBody"
    */
    public void setOtherDayBodyBaseStyle(String otherDayBodyBaseStyle) {
        setAttribute("otherDayBodyBaseStyle", otherDayBodyBaseStyle, true);
    }
    /**
     * The base name for the CSS class applied to the day body of the month view of the calendar. This style will have "Dark", "Over", "Selected", or "Disabled" appended to it according to the state of the cell.
     *
     *
     * @return String
     *
     */
    public String getOtherDayBodyBaseStyle()  {
        return getAttributeAsString("otherDayBodyBaseStyle");
    }

    /**
    * In the month CSS style applied to both the header and body of days from other months when {@link com.smartgwt.client.widgets.calendar.Calendar#getShowOtherDays showOtherDays} is false.
    *
    * @param otherDayBlankStyle otherDayBlankStyle Default value is "calMonthOtherDayBlank"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setOtherDayBlankStyle(String otherDayBlankStyle)  throws IllegalStateException {
        setAttribute("otherDayBlankStyle", otherDayBlankStyle, false);
    }
    /**
     * In the month CSS style applied to both the header and body of days from other months when {@link com.smartgwt.client.widgets.calendar.Calendar#getShowOtherDays showOtherDays} is false.
     *
     *
     * @return String
     *
     */
    public String getOtherDayBlankStyle()  {
        return getAttributeAsString("otherDayBlankStyle");
    }

    /**
    * The base name for the CSS class applied to a cell that is selected via a mouse drag.
    *
    * @param selectedCellStyle selectedCellStyle Default value is "calendarCellSelected"
    */
    public void setSelectedCellStyle(String selectedCellStyle) {
        setAttribute("selectedCellStyle", selectedCellStyle, true);
    }
    /**
     * The base name for the CSS class applied to a cell that is selected via a mouse drag.
     *
     *
     * @return String
     *
     */
    public String getSelectedCellStyle()  {
        return getAttributeAsString("selectedCellStyle");
    }

    /**
    * The base name for the CSS class applied to event windows within calendars. This style will have "Header", "HeaderLabel", and "Body" appended to it, according to  which part of the event window is being styled. For example, to style the header, define a css class called 'eventWindowHeader'.
    *
    * @param eventWindowStyle eventWindowStyle Default value is "eventWindow"
    */
    public void setEventWindowStyle(String eventWindowStyle) {
        setAttribute("eventWindowStyle", eventWindowStyle, true);
    }
    /**
     * The base name for the CSS class applied to event windows within calendars. This style will have "Header", "HeaderLabel", and "Body" appended to it, according to  which part of the event window is being styled. For example, to style the header, define a css class called 'eventWindowHeader'.
     *
     *
     * @return String
     *
     */
    public String getEventWindowStyle()  {
        return getAttributeAsString("eventWindowStyle");
    }

    /**
    * If {@link com.smartgwt.client.widgets.calendar.Calendar#getShowWorkday showWorkday} is set, style used for cells that are within the workday, as defined by {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart workdayStart} and {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayEnd workdayEnd}.
    *
    * @param workdayBaseStyle workdayBaseStyle Default value is "calendarWorkday"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setWorkdayBaseStyle(String workdayBaseStyle)  throws IllegalStateException {
        setAttribute("workdayBaseStyle", workdayBaseStyle, false);
    }
    /**
     * If {@link com.smartgwt.client.widgets.calendar.Calendar#getShowWorkday showWorkday} is set, style used for cells that are within the workday, as defined by {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart workdayStart} and {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayEnd workdayEnd}.
     *
     *
     * @return String
     *
     */
    public String getWorkdayBaseStyle()  {
        return getAttributeAsString("workdayBaseStyle");
    }

    /**
    * When using {@link com.smartgwt.client.widgets.calendar.Calendar#getShowWorkday showWorkday}:true, <code>workdayStart</code> and <code>workdayEnd</code> specify the time of day when the workday starts and ends, specified as a String acceptable to {@link com.smartgwt.client..Time#parseInput}. <P> Both start and end time must fall on a 30 minute increment (eg 9:30, but not 9:45).
    *
    * @param workdayStart workdayStart Default value is "9:00am"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setWorkdayStart(String workdayStart)  throws IllegalStateException {
        setAttribute("workdayStart", workdayStart, false);
    }
    /**
     * When using {@link com.smartgwt.client.widgets.calendar.Calendar#getShowWorkday showWorkday}:true, <code>workdayStart</code> and <code>workdayEnd</code> specify the time of day when the workday starts and ends, specified as a String acceptable to {@link com.smartgwt.client..Time#parseInput}. <P> Both start and end time must fall on a 30 minute increment (eg 9:30, but not 9:45).
     *
     *
     * @return String
     *
     */
    public String getWorkdayStart()  {
        return getAttributeAsString("workdayStart");
    }

    /**
    * When using {@link com.smartgwt.client.widgets.calendar.Calendar#getShowWorkday showWorkday}:true, <code>workdayStart</code> and <code>workdayEnd</code> specify the time of day when the workday starts and ends, specified as a String acceptable to {@link com.smartgwt.client..Time#parseInput}. <P> Both start and end time must fall on a 30 minute increment (eg 9:30, but not 9:45).
    *
    * @param workdayEnd workdayEnd Default value is "5:00pm"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setWorkdayEnd(String workdayEnd)  throws IllegalStateException {
        setAttribute("workdayEnd", workdayEnd, false);
    }
    /**
     * When using {@link com.smartgwt.client.widgets.calendar.Calendar#getShowWorkday showWorkday}:true, <code>workdayStart</code> and <code>workdayEnd</code> specify the time of day when the workday starts and ends, specified as a String acceptable to {@link com.smartgwt.client..Time#parseInput}. <P> Both start and end time must fall on a 30 minute increment (eg 9:30, but not 9:45).
     *
     *
     * @return String
     *
     */
    public String getWorkdayEnd()  {
        return getAttributeAsString("workdayEnd");
    }

    /**
    * If set, causes the calendar to use {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayBaseStyle workdayBaseStyle} for cells falling within the workday as defined by {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart workdayStart} and {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayEnd workdayEnd}, in both the {@link com.smartgwt.client.widgets.calendar.Calendar#getWeekView weekView} and {@link com.smartgwt.client.widgets.calendar.Calendar#getDayView dayView}.
    *
    * @param showWorkday showWorkday Default value is false
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setShowWorkday(Boolean showWorkday)  throws IllegalStateException {
        setAttribute("showWorkday", showWorkday, false);
    }
    /**
     * If set, causes the calendar to use {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayBaseStyle workdayBaseStyle} for cells falling within the workday as defined by {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart workdayStart} and {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayEnd workdayEnd}, in both the {@link com.smartgwt.client.widgets.calendar.Calendar#getWeekView weekView} and {@link com.smartgwt.client.widgets.calendar.Calendar#getDayView dayView}.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowWorkday()  {
        return getAttributeAsBoolean("showWorkday");
    }

    /**
    * If set, causes the {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart workdayStart} to be sized to fill the available space in the day view and weeek view, and automatically scrolls these views to the start of the workday when the calendar is first displayed and whenever the user switches to a new day or week.
    *
    * @param scrollToWorkday scrollToWorkday Default value is false
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setScrollToWorkday(Boolean scrollToWorkday)  throws IllegalStateException {
        setAttribute("scrollToWorkday", scrollToWorkday, false);
    }
    /**
     * If set, causes the {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart workdayStart} to be sized to fill the available space in the day view and weeek view, and automatically scrolls these views to the start of the workday when the calendar is first displayed and whenever the user switches to a new day or week.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getScrollToWorkday()  {
        return getAttributeAsBoolean("scrollToWorkday");
    }

    /**
    * The name of the name field in a ${isc.DocUtils.linkForRef('object:CalendarEvent')}.
    *
    * @param nameField nameField Default value is "name"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setNameField(String nameField)  throws IllegalStateException {
        setAttribute("nameField", nameField, false);
    }
    /**
     * The name of the name field in a ${isc.DocUtils.linkForRef('object:CalendarEvent')}.
     *
     *
     * @return String
     *
     */
    public String getNameField()  {
        return getAttributeAsString("nameField");
    }

    /**
    * The name of the description field in a ${isc.DocUtils.linkForRef('object:CalendarEvent')}.
    *
    * @param descriptionField descriptionField Default value is "description"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setDescriptionField(String descriptionField)  throws IllegalStateException {
        setAttribute("descriptionField", descriptionField, false);
    }
    /**
     * The name of the description field in a ${isc.DocUtils.linkForRef('object:CalendarEvent')}.
     *
     *
     * @return String
     *
     */
    public String getDescriptionField()  {
        return getAttributeAsString("descriptionField");
    }

    /**
    * The name of the start date field in a ${isc.DocUtils.linkForRef('object:CalendarEvent')}.
    *
    * @param startDateField startDateField Default value is "startDate"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setStartDateField(String startDateField)  throws IllegalStateException {
        setAttribute("startDateField", startDateField, false);
    }
    /**
     * The name of the start date field in a ${isc.DocUtils.linkForRef('object:CalendarEvent')}.
     *
     *
     * @return String
     *
     */
    public String getStartDateField()  {
        return getAttributeAsString("startDateField");
    }

    /**
    * The name of the end date field in a ${isc.DocUtils.linkForRef('object:CalendarEvent')}.
    *
    * @param endDateField endDateField Default value is "endDate"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setEndDateField(String endDateField)  throws IllegalStateException {
        setAttribute("endDateField", endDateField, false);
    }
    /**
     * The name of the end date field in a ${isc.DocUtils.linkForRef('object:CalendarEvent')}.
     *
     *
     * @return String
     *
     */
    public String getEndDateField()  {
        return getAttributeAsString("endDateField");
    }

    /**
    * The name of the end date field in a ${isc.DocUtils.linkForRef('object:CalendarEvent')}.
    *
    * @param leadingDateField leadingDateField Default value is "leadingDate"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setLeadingDateField(String leadingDateField)  throws IllegalStateException {
        setAttribute("leadingDateField", leadingDateField, false);
    }
    /**
     * The name of the end date field in a ${isc.DocUtils.linkForRef('object:CalendarEvent')}.
     *
     *
     * @return String
     *
     */
    public String getLeadingDateField()  {
        return getAttributeAsString("leadingDateField");
    }

    /**
    * The name of the end date field in a ${isc.DocUtils.linkForRef('object:CalendarEvent')}.
    *
    * @param trailingDateField trailingDateField Default value is "trailingDate"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setTrailingDateField(String trailingDateField)  throws IllegalStateException {
        setAttribute("trailingDateField", trailingDateField, false);
    }
    /**
     * The name of the end date field in a ${isc.DocUtils.linkForRef('object:CalendarEvent')}.
     *
     *
     * @return String
     *
     */
    public String getTrailingDateField()  {
        return getAttributeAsString("trailingDateField");
    }

    /**
    * The name of the end date field in a ${isc.DocUtils.linkForRef('object:CalendarEvent')}.
    *
    * @param eventTypeField eventTypeField Default value is "eventType"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setEventTypeField(String eventTypeField)  throws IllegalStateException {
        setAttribute("eventTypeField", eventTypeField, false);
    }
    /**
     * The name of the end date field in a ${isc.DocUtils.linkForRef('object:CalendarEvent')}.
     *
     *
     * @return String
     *
     */
    public String getEventTypeField()  {
        return getAttributeAsString("eventTypeField");
    }

    /**
    * The name of the field used to override {@link com.smartgwt.client.widgets.calendar.Calendar#getEventWindowStyle eventWindowStyle} for an individual ${isc.DocUtils.linkForRef('object:CalendarEvent')}.  See {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getEventWindowStyle eventWindowStyle}.
    *
    * @param eventWindowStyleField eventWindowStyleField Default value is "eventWindowStyle"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setEventWindowStyleField(String eventWindowStyleField)  throws IllegalStateException {
        setAttribute("eventWindowStyleField", eventWindowStyleField, false);
    }
    /**
     * The name of the field used to override {@link com.smartgwt.client.widgets.calendar.Calendar#getEventWindowStyle eventWindowStyle} for an individual ${isc.DocUtils.linkForRef('object:CalendarEvent')}.  See {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getEventWindowStyle eventWindowStyle}.
     *
     *
     * @return String
     *
     */
    public String getEventWindowStyleField()  {
        return getAttributeAsString("eventWindowStyleField");
    }

    /**
    * Name of the field on each ${isc.DocUtils.linkForRef('object:CalendarEvent')} that determines editability.
    *
    * @param canEditField canEditField Default value is "canEdit"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setCanEditField(String canEditField)  throws IllegalStateException {
        setAttribute("canEditField", canEditField, false);
    }
    /**
     * Name of the field on each ${isc.DocUtils.linkForRef('object:CalendarEvent')} that determines editability.
     *
     *
     * @return String
     *
     */
    public String getCanEditField()  {
        return getAttributeAsString("canEditField");
    }

    /**
    * Augments the width of week event windows slightly to avoid duplicate adjacent borders between events.
    *
    * @param weekEventBorderOverlap weekEventBorderOverlap Default value is false
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setWeekEventBorderOverlap(Boolean weekEventBorderOverlap)  throws IllegalStateException {
        setAttribute("weekEventBorderOverlap", weekEventBorderOverlap, false);
    }
    /**
     * Augments the width of week event windows slightly to avoid duplicate adjacent borders between events.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getWeekEventBorderOverlap()  {
        return getAttributeAsBoolean("weekEventBorderOverlap");
    }

    /**
    * Determines how many minutes an event can be moved or resized by.
    *
    * @param eventSnapGap eventSnapGap Default value is 30
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setEventSnapGap(int eventSnapGap)  throws IllegalStateException {
        setAttribute("eventSnapGap", eventSnapGap, false);
    }
    /**
     * Determines how many minutes an event can be moved or resized by.
     *
     *
     * @return int
     *
     */
    public int getEventSnapGap()  {
        return getAttributeAsInt("eventSnapGap");
    }

    /**
    * Determines whether the quick event dialog is displayed when a time is clicked. If this is false, the full event editor is displayed.
    *
    * @param showQuickEventDialog showQuickEventDialog Default value is true
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setShowQuickEventDialog(Boolean showQuickEventDialog)  throws IllegalStateException {
        setAttribute("showQuickEventDialog", showQuickEventDialog, false);
    }
    /**
     * Determines whether the quick event dialog is displayed when a time is clicked. If this is false, the full event editor is displayed.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowQuickEventDialog()  {
        return getAttributeAsBoolean("showQuickEventDialog");
    }

    /**
    * If true, users can create new events
    *
    * @param canCreateEvents canCreateEvents Default value is true
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setCanCreateEvents(Boolean canCreateEvents)  throws IllegalStateException {
        setAttribute("canCreateEvents", canCreateEvents, false);
    }
    /**
     * If true, users can create new events
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanCreateEvents()  {
        return getAttributeAsBoolean("canCreateEvents");
    }

    /**
    * If true, users can edit existing events
    *
    * @param canEditEvents canEditEvents Default value is true
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setCanEditEvents(Boolean canEditEvents)  throws IllegalStateException {
        setAttribute("canEditEvents", canEditEvents, false);
    }
    /**
     * If true, users can edit existing events
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanEditEvents()  {
        return getAttributeAsBoolean("canEditEvents");
    }

    /**
    * If true, users can delete existing events. Defaults to {@link com.smartgwt.client.widgets.calendar.Calendar#getCanEditEvents canEditEvents}
    *
    * @param canDeleteEvents canDeleteEvents Default value is true
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setCanDeleteEvents(Boolean canDeleteEvents)  throws IllegalStateException {
        setAttribute("canDeleteEvents", canDeleteEvents, false);
    }
    /**
     * If true, users can delete existing events. Defaults to {@link com.smartgwt.client.widgets.calendar.Calendar#getCanEditEvents canEditEvents}
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanDeleteEvents()  {
        return getAttributeAsBoolean("canDeleteEvents");
    }

    /**
    * Determines whether the {@link com.smartgwt.client.widgets.calendar.Calendar#getDateChooser dateChooser} is displayed.
    *
    * @param showDateChooser showDateChooser Default value is true
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setShowDateChooser(Boolean showDateChooser)  throws IllegalStateException {
        setAttribute("showDateChooser", showDateChooser, false);
    }
    /**
     * Determines whether the {@link com.smartgwt.client.widgets.calendar.Calendar#getDateChooser dateChooser} is displayed.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowDateChooser()  {
        return getAttributeAsBoolean("showDateChooser");
    }

    /**
    * If set, weekend days appear in disabled style and events cannot be created on weekends. Which days are considered weekends is controlled by {@link com.smartgwt.client..Date#weekendDays}.
    *
    * @param disableWeekends disableWeekends Default value is true
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setDisableWeekends(Boolean disableWeekends)  throws IllegalStateException {
        setAttribute("disableWeekends", disableWeekends, false);
    }
    /**
     * If set, weekend days appear in disabled style and events cannot be created on weekends. Which days are considered weekends is controlled by {@link com.smartgwt.client..Date#weekendDays}.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getDisableWeekends()  {
        return getAttributeAsBoolean("disableWeekends");
    }

    /**
    * Suppresses the display of weekend days in the week and month views, and disallows the creation of events on weekends.  Which days are considered weekends is controlled by {@link com.smartgwt.client..Date#weekendDays}.
    * Setter for {@link com.smartgwt.client.widgets.calendar.Calendar#getShowWeekends showWeekends} to change this property at runtime.
    *
    * @param showWeekends showWeekends Default value is true
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setShowWeekends(Boolean showWeekends)  throws IllegalStateException {
        setAttribute("showWeekends", showWeekends, false);
    }
    /**
     * Suppresses the display of weekend days in the week and month views, and disallows the creation of events on weekends.  Which days are considered weekends is controlled by {@link com.smartgwt.client..Date#weekendDays}.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowWeekends()  {
        return getAttributeAsBoolean("showWeekends");
    }

    /**
    * If false, the month view does not show day headers
    *
    * @param showDayHeaders showDayHeaders Default value is true
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setShowDayHeaders(Boolean showDayHeaders)  throws IllegalStateException {
        setAttribute("showDayHeaders", showDayHeaders, false);
    }
    /**
     * If false, the month view does not show day headers
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowDayHeaders()  {
        return getAttributeAsBoolean("showDayHeaders");
    }

    /**
    * If set to true, in the month view, days that fall in an adjacent month are still shown with a header and body area, and are interactive.  Otherwise days from other months are rendered in the {@link com.smartgwt.client.widgets.calendar.Calendar#getOtherDayBlankStyle otherDayBlankStyle} and are non-interactive.
    *
    * @param showOtherDays showOtherDays Default value is true
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setShowOtherDays(Boolean showOtherDays)  throws IllegalStateException {
        setAttribute("showOtherDays", showOtherDays, false);
    }
    /**
     * If set to true, in the month view, days that fall in an adjacent month are still shown with a header and body area, and are interactive.  Otherwise days from other months are rendered in the {@link com.smartgwt.client.widgets.calendar.Calendar#getOtherDayBlankStyle otherDayBlankStyle} and are non-interactive.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowOtherDays()  {
        return getAttributeAsBoolean("showOtherDays");
    }

    /**
    * The message to display in the {@link com.smartgwt.client.widgets.calendar.Calendar#getEventEditor eventEditor} when the 'To' date is greater than the 'From' date and a save is attempted.
    *
    * @param invalidDateMessage invalidDateMessage Default value is "From must be before To"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setInvalidDateMessage(Boolean invalidDateMessage)  throws IllegalStateException {
        setAttribute("invalidDateMessage", invalidDateMessage, false);
    }
    /**
     * The message to display in the {@link com.smartgwt.client.widgets.calendar.Calendar#getEventEditor eventEditor} when the 'To' date is greater than the 'From' date and a save is attempted.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getInvalidDateMessage()  {
        return getAttributeAsBoolean("invalidDateMessage");
    }

    /**
    * If set to true, enables the auto-arrangement of events that share time in the calendar.  The default is true.
    *
    * @param eventAutoArrange eventAutoArrange Default value is true
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setEventAutoArrange(Boolean eventAutoArrange)  throws IllegalStateException {
        setAttribute("eventAutoArrange", eventAutoArrange, false);
    }
    /**
     * If set to true, enables the auto-arrangement of events that share time in the calendar.  The default is true.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getEventAutoArrange()  {
        return getAttributeAsBoolean("eventAutoArrange");
    }

    /**
    * When {@link com.smartgwt.client.widgets.calendar.Calendar#getEventAutoArrange eventAutoArrange} is true, setting eventOverlap to true causes events that  share timeslots to overlap each other by a percentage of their width, specified by  {@link com.smartgwt.client.widgets.calendar.Calendar#getEventOverlapPercent eventOverlapPercent}.  The default is true.
    *
    * @param eventOverlap eventOverlap Default value is true
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setEventOverlap(Boolean eventOverlap)  throws IllegalStateException {
        setAttribute("eventOverlap", eventOverlap, false);
    }
    /**
     * When {@link com.smartgwt.client.widgets.calendar.Calendar#getEventAutoArrange eventAutoArrange} is true, setting eventOverlap to true causes events that  share timeslots to overlap each other by a percentage of their width, specified by  {@link com.smartgwt.client.widgets.calendar.Calendar#getEventOverlapPercent eventOverlapPercent}.  The default is true.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getEventOverlap()  {
        return getAttributeAsBoolean("eventOverlap");
    }

    /**
    * The size of the overlap, presented as a percentage of the width of events sharing timeslots
    *
    * @param eventOverlapPercent eventOverlapPercent Default value is 10
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setEventOverlapPercent(int eventOverlapPercent)  throws IllegalStateException {
        setAttribute("eventOverlapPercent", eventOverlapPercent, false);
    }
    /**
     * The size of the overlap, presented as a percentage of the width of events sharing timeslots
     *
     *
     * @return int
     *
     */
    public int getEventOverlapPercent()  {
        return getAttributeAsInt("eventOverlapPercent");
    }

    /**
    * When set to true, events that start at the same time will not overlap each other to prevent  events having their close button hidden
    *
    * @param eventOverlapIdenticalStartTimes eventOverlapIdenticalStartTimes Default value is false
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setEventOverlapIdenticalStartTimes(Boolean eventOverlapIdenticalStartTimes)  throws IllegalStateException {
        setAttribute("eventOverlapIdenticalStartTimes", eventOverlapIdenticalStartTimes, false);
    }
    /**
     * When set to true, events that start at the same time will not overlap each other to prevent  events having their close button hidden
     *
     *
     * @return Boolean
     *
     */
    public Boolean getEventOverlapIdenticalStartTimes()  {
        return getAttributeAsBoolean("eventOverlapIdenticalStartTimes");
    }

    /**
    * If true, when this component is first drawn, automatically call <code>this.fetchData()</code> or <code>this.filterData()</code> depending on ${isc.DocUtils.linkForRef('autoFetchAsFilter')}. Criteria for this fetch may be picked up from {@link com.smartgwt.client.widgets.calendar.Calendar#getInitialCriteria initialCriteria}.
    *
    * @param autoFetchData autoFetchData Default value is false
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setAutoFetchData(Boolean autoFetchData)  throws IllegalStateException {
        setAttribute("autoFetchData", autoFetchData, false);
    }
    /**
     * If true, when this component is first drawn, automatically call <code>this.fetchData()</code> or <code>this.filterData()</code> depending on ${isc.DocUtils.linkForRef('autoFetchAsFilter')}. Criteria for this fetch may be picked up from {@link com.smartgwt.client.widgets.calendar.Calendar#getInitialCriteria initialCriteria}.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getAutoFetchData()  {
        return getAttributeAsBoolean("autoFetchData");
    }

    /**
    * if set to true, show the eventsByType view.
    *
    * @param showEventsByTypeView showEventsByTypeView Default value is false
    */
    public void setShowEventsByTypeView(Boolean showEventsByTypeView) {
        setAttribute("showEventsByTypeView", showEventsByTypeView, true);
    }
    /**
     * if set to true, show the eventsByType view.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowEventsByTypeView()  {
        return getAttributeAsBoolean("showEventsByTypeView");
    }

    // ********************* Methods ***********************









        /**
         * Move to the next day, week, or month, depending on which tab is selected.
         */
        public native void next() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.next();
        }-*/;

        /**
         * Move to the previous day, week, or month, depending on which tab is selected.
         */
        public native void previous() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.previous();
        }-*/;







        /**
         * Add a dayBodyClick handler.
         * <p>
         * Called when the body area of a day in the month view is clicked on, outside of any links to a particular event. <P> By default, if the user can add events, shows a dialog for adding a new event for that day.  Return false to cancel this action. <P> Not called if the day falls outside the current month and {@link com.smartgwt.client.widgets.calendar.Calendar#getShowOtherDays showOtherDays} is false.
         *
         * @param handler the dayBodyClick handler
         */
        public HandlerRegistration addDayBodyClickHandler(com.smartgwt.client.widgets.calendar.events.DayBodyClickHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.calendar.events.DayBodyClickEvent.getType()) == 0) setupDayBodyClickEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.calendar.events.DayBodyClickEvent.getType());
        }
        private native void setupDayBodyClickEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({dayBodyClick:function(){
                        var param = {"date" : arguments[0], "events" : arguments[1], "calendar" : arguments[2], "rowNum" : arguments[3], "colNum" : arguments[4]};
                        var event = @com.smartgwt.client.widgets.calendar.events.DayBodyClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.dayBodyClick = function(){
                    var param = {"date" : arguments[0], "events" : arguments[1], "calendar" : arguments[2], "rowNum" : arguments[3], "colNum" : arguments[4]};
                    var event = @com.smartgwt.client.widgets.calendar.events.DayBodyClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;






        /**
         * Add a dayHeaderClick handler.
         * <p>
         * Called when the header area of a day in the month view is clicked on. <P> By default, moves to the day tab and shows the clicked days events. Return false to cancel this action. <P> Not called if the day falls outside the current month and {@link com.smartgwt.client.widgets.calendar.Calendar#getShowOtherDays showOtherDays} is false.
         *
         * @param handler the dayHeaderClick handler
         */
        public HandlerRegistration addDayHeaderClickHandler(com.smartgwt.client.widgets.calendar.events.DayHeaderClickHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.calendar.events.DayHeaderClickEvent.getType()) == 0) setupDayHeaderClickEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.calendar.events.DayHeaderClickEvent.getType());
        }
        private native void setupDayHeaderClickEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({dayHeaderClick:function(){
                        var param = {"date" : arguments[0], "events" : arguments[1], "calendar" : arguments[2], "rowNum" : arguments[3], "colNum" : arguments[4]};
                        var event = @com.smartgwt.client.widgets.calendar.events.DayHeaderClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.dayHeaderClick = function(){
                    var param = {"date" : arguments[0], "events" : arguments[1], "calendar" : arguments[2], "rowNum" : arguments[3], "colNum" : arguments[4]};
                    var event = @com.smartgwt.client.widgets.calendar.events.DayHeaderClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;


        /**
         * Add a eventChanged handler.
         * <p>
         * Notification fired whenever a user changes an event, whether by dragging the event or by editing it in a dialog. <P> In a calendar with a DataSource, eventChanged() fires <b>after</b> the updated event has been successfully saved to the server
         *
         * @param handler the eventChanged handler
         */
        public HandlerRegistration addEventChangedHandler(com.smartgwt.client.widgets.calendar.events.EventChangedHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.calendar.events.CalendarEventChangedEvent.getType()) == 0) setupEventChangedEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.calendar.events.CalendarEventChangedEvent.getType());
        }
        private native void setupEventChangedEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({eventChanged:function(){
                        var param = {"event" : arguments[0]};
                        var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.eventChanged = function(){
                    var param = {"event" : arguments[0]};
                    var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;


        /**
         * Add a eventRemoved handler.
         * <p>
         * Notification fired whenever a user removes an event <P> In a calendar with a DataSource, eventRemoved() fires <b>after</b> the event has been successfully removed from the server
         *
         * @param handler the eventRemoved handler
         */
        public HandlerRegistration addEventRemovedHandler(com.smartgwt.client.widgets.calendar.events.EventRemovedHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.calendar.events.CalendarEventRemoved.getType()) == 0) setupEventRemovedEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.calendar.events.CalendarEventRemoved.getType());
        }
        private native void setupEventRemovedEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({eventRemoved:function(){
                        var param = {"event" : arguments[0]};
                        var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventRemoved::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.eventRemoved = function(){
                    var param = {"event" : arguments[0]};
                    var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventRemoved::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;


        /**
         * Add a eventAdded handler.
         * <p>
         * Notification fired whenever a user adds an event. <P> In a calendar with a DataSource, eventAdded() fires <b>after</b> the event has been successfully added to the server
         *
         * @param handler the eventAdded handler
         */
        public HandlerRegistration addEventAddedHandler(com.smartgwt.client.widgets.calendar.events.EventAddedHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.calendar.events.CalendarEventAdded.getType()) == 0) setupEventAddedEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.calendar.events.CalendarEventAdded.getType());
        }
        private native void setupEventAddedEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({eventAdded:function(){
                        var param = {"event" : arguments[0]};
                        var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventAdded::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.eventAdded = function(){
                    var param = {"event" : arguments[0]};
                    var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventAdded::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;



        /**
         * Add a eventClick handler.
         * <p>
         * Called whenever an event is clicked on in the day, week or month views. <P> By default a dialog appears showing details for the event, and offering the ability to edit events which are editable.  Return false to cancel the default action. This is a good place to, for example, show a completely customized event dialog instead of the default one.
         *
         * @param handler the eventClick handler
         */
        public HandlerRegistration addEventClickHandler(com.smartgwt.client.widgets.calendar.events.EventClickHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.calendar.events.CalendarEventClick.getType()) == 0) setupEventClickEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.calendar.events.CalendarEventClick.getType());
        }
        private native void setupEventClickEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({eventClick:function(){
                        var param = {"event" : arguments[0], "viewName" : arguments[1]};
                        var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventClick::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.eventClick = function(){
                    var param = {"event" : arguments[0], "viewName" : arguments[1]};
                    var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventClick::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;



        /**
         * Add a eventRemoveClick handler.
         * <p>
         * Called whenever the close icon of an event is clicked within the day or week view. Return false to cancel the removal, or true to allow it. <P> Implement this method to do something like, for example, showing a confirmation dialog  before an event is removed.
         *
         * @param handler the eventRemoveClick handler
         */
        public HandlerRegistration addEventRemoveClickHandler(com.smartgwt.client.widgets.calendar.events.EventRemoveClickHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.calendar.events.CalendarEventRemoveClick.getType()) == 0) setupEventRemoveClickEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.calendar.events.CalendarEventRemoveClick.getType());
        }
        private native void setupEventRemoveClickEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({eventRemoveClick:function(){
                        var param = {"event" : arguments[0], "viewName" : arguments[1]};
                        var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventRemoveClick::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.eventRemoveClick = function(){
                    var param = {"event" : arguments[0], "viewName" : arguments[1]};
                    var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventRemoveClick::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;



        /**
         * Add a eventMoved handler.
         * <p>
         * Called when an event is moved via dragging by a user.  Return false to disallow the move.
         *
         * @param handler the eventMoved handler
         */
        public HandlerRegistration addEventMovedHandler(com.smartgwt.client.widgets.calendar.events.EventMovedHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.calendar.events.CalendarEventMoved.getType()) == 0) setupEventMovedEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.calendar.events.CalendarEventMoved.getType());
        }
        private native void setupEventMovedEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({eventMoved:function(){
                        var param = {"newDate" : arguments[0], "event" : arguments[1]};
                        var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventMoved::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.eventMoved = function(){
                    var param = {"newDate" : arguments[0], "event" : arguments[1]};
                    var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventMoved::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;



        /**
         * Add a eventResized handler.
         * <p>
         * Called when an event is resized via dragging by a user.  Return false to disallow the resize.
         *
         * @param handler the eventResized handler
         */
        public HandlerRegistration addEventResizedHandler(com.smartgwt.client.widgets.calendar.events.EventResizedHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.calendar.events.CalendarEventResized.getType()) == 0) setupEventResizedEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.calendar.events.CalendarEventResized.getType());
        }
        private native void setupEventResizedEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({eventResized:function(){
                        var param = {"newDate" : arguments[0], "event" : arguments[1]};
                        var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventResized::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.eventResized = function(){
                    var param = {"newDate" : arguments[0], "event" : arguments[1]};
                    var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventResized::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;

        /**
         * Add a dateChanged handler.
         * <p>
         * Fires whenever the user changes the current date, including picking a specific date or navigating to a new week or month.
         *
         * @param handler the dateChanged handler
         */
        public HandlerRegistration addDateChangedHandler(com.smartgwt.client.widgets.calendar.events.DateChangedHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.calendar.events.DateChangedEvent.getType()) == 0) setupDateChangedEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.calendar.events.DateChangedEvent.getType());
        }
        private native void setupDateChangedEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({dateChanged:function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.calendar.events.DateChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.dateChanged = function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.calendar.events.DateChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;

        /**
         * Gets the day of the week (0-6) that the mouse is currently over.
         *
         * @return the day that the mouse is currently over
         */
        public native int getActiveDay() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getActiveDay();
        }-*/;

        /**
         * Gets a date object representing the date over which the mouse is hovering for the current selected view. For month view, the time will be set to midnight of the active day. For dayview and week view, the time will be the rounded to the closest half hour relative to the mouse position.
         *
         * @return the date that the mouse is over
         */
        public native Date getActiveTime() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.getActiveTime();
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toDate(D)(retVal.getTime());
            }
        }-*/;

    // ********************* Static Methods ***********************







    protected native void onInit() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self._getDayBodyHTML = self.getDayBodyHTML;

        self.getDayBodyHTML = function(date, events, calendar, rowNum, colNum) {
            var jObj = this.__ref;
            var dateJ = @com.smartgwt.client.util.JSOHelper::toDate(D)(date.getTime());
            var eventsJ = events == null ? null : @com.smartgwt.client.widgets.calendar.CalendarEvent::convertToCalendarEventArray(Lcom/google/gwt/core/client/JavaScriptObject;)(events);
            var calendarJ = @com.smartgwt.client.widgets.calendar.Calendar::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(calendar);            
            return jObj.@com.smartgwt.client.widgets.calendar.Calendar::getDayBodyHTML(Ljava/util/Date;[Lcom/smartgwt/client/widgets/calendar/CalendarEvent;Lcom/smartgwt/client/widgets/calendar/Calendar;II)(dateJ, eventsJ, calendarJ, rowNum, colNum);
        };
    }-*/;

    protected native String getDayBodyHTML(Date date, CalendarEvent[] events, Calendar calendar, int rowNum, int colNum) /*-{
        var dateJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date);
        var eventsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(events);
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var calendarJS = calendar.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self._getDayBodyHTML(dateJS, eventsJS, calendarJS,rowNum, colNum);
    }-*/;


    /**
     * The set of fields for the {@link com.smartgwt.client.widgets.calendar.Calendar#getEventEditor eventEditor}. <p>
     * The default set of fields are:  <pre>    {name: "startHours", title: "From", type: "select", width: 60},
     * {name: "startMinutes", showTitle: false, type: "select", width: 60},    {name: "startAMPM", showTitle: false,
     * type: "select", width: 60},    {name: "invalidDate", type: "blurb", colSpan: 4, visible: false}    {name:
     * "endHours", title: "To", type: "select", width: 60},    {name: "endMinutes", showTitle: false, type: "select",
     * width: 60},    {name: "endAMPM", showTitle: false, type: "select", width: 60},    {name: "name", title: "Name",
     * type: "text", colSpan: 4},    {name: "description", title: "Description", type: "textArea", colSpan: 4, height:
     * 50} </pre> See the Customized Binding example below for more information on altering default datasource  fields
     * within forms.
     *
     * @param eventEditorFields eventEditorFields Default value is see below
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEventEditorFields(FormItem... eventEditorFields) throws IllegalStateException {
        setAttribute("eventEditorFields", toJsArray(eventEditorFields), false);
    }
    /**
     * The set of fields for the {@link com.smartgwt.client.widgets.calendar.Calendar#getEventEditor eventEditor}. <p> The default set of fields are:  <pre>    {name: "startHours", title: "From", type: "select", width: 60},    {name: "startMinutes", showTitle: false, type: "select", width: 60},    {name: "startAMPM", showTitle: false, type: "select", width: 60},    {name: "invalidDate", type: "blurb", colSpan: 4, visible: false}    {name: "endHours", title: "To", type: "select", width: 60},    {name: "endMinutes", showTitle: false, type: "select", width: 60},    {name: "endAMPM", showTitle: false, type: "select", width: 60},    {name: "name", title: "Name", type: "text", colSpan: 4},    {name: "description", title: "Description", type: "textArea", colSpan: 4, height: 50} </pre> See the Customized Binding example below for more information on altering default datasource  fields within forms.
     *
     *
     * @return Array of FormItem
     *
     */
/*    public FormItem[] getEventEditorFields()  {
        return getAttribute("eventEditorFields");
    }*/

    /**
     * The set of fields for the {@link com.smartgwt.client.widgets.calendar.Calendar#getEventDialog eventDialog}.  <p>
     * The default set of fields are:  <pre>    {name: "name", title: "Event Name", type: nameType, width: 250 },
     * {name: "save", title: "Save Event", type: "SubmitItem", endRow: false},    {name: "details", title: "Edit
     * Details", type: "button", startRow: false} </pre> See the Customized Binding example below for more information
     * on altering default datasource  fields within forms.
     *
     * @param eventDialogFields eventDialogFields Default value is see below
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEventDialogFields(FormItem... eventDialogFields) throws IllegalStateException {
        setAttribute("eventDialogFields", toJsArray(eventDialogFields), false);
    }

    private static JavaScriptObject toJsArray(FormItem[] formItems) {
        JavaScriptObject jsArray = JSOHelper.createJavaScriptArray();
        int i = 0;
        for (FormItem formItem : formItems) {
            JavaScriptObject config = formItem.getConfig();
            JSOHelper.setAttribute(config, "name", formItem.getName());
            JSOHelper.setAttribute(config, "type", formItem.getType());
            JSOHelper.setArrayValue(jsArray, i, config);
            i++;
        }
        return jsArray;
    }
        
    /**
     * The set of fields for the {@link com.smartgwt.client.widgets.calendar.Calendar#getEventDialog eventDialog}.  <p> The default set of fields are:  <pre>    {name: "name", title: "Event Name", type: nameType, width: 250 },    {name: "save", title: "Save Event", type: "SubmitItem", endRow: false},    {name: "details", title: "Edit Details", type: "button", startRow: false} </pre> See the Customized Binding example below for more information on altering default datasource  fields within forms.
     *
     *
     * @return Array of FormItem
     *
     */
/*    public FormItem[] getEventDialogFields()  {
        return getAttribute("eventDialogFields");
    }   */

    /**
     * A List of CalendarEvent objects, specifying the data to be used to populate the calendar.   <p> This property
     * will typically not be explicitly specified for databound Calendars, where the data is returned from the server
     * via databound component methods such as {@link com.smartgwt.client.widgets.calendar.Calendar#fetchData}. In this
     * case the data objects will be set to a  {@link com.smartgwt.client.data.ResultSet} rather than a simple array.
     * Initialize the data object with the given array. Observes methods of the data object so that when the data
     * changes, the calendar will redraw automatically.
     *
     * @param data data to show in the list. Default value is null
     */
    public void setData(CalendarEvent[] data) {
        setAttribute("data", data, true);
    }
    /**
     * A List of CalendarEvent objects, specifying the data to be used to populate the calendar.   <p> This property will typically not be explicitly specified for databound Calendars, where the data is returned from the server via databound component methods such as {@link com.smartgwt.client.widgets.calendar.Calendar#fetchData}. In this case the data objects will be set to a  {@link com.smartgwt.client.data.ResultSet} rather than a simple array.
     *
     *
     * @return List of CalendarEvent
     *
     */
/*    public CalendarEvent[] getData()  {
        return getAttribute("data");
    }*/

    /**
     * Criteria to be used when {@link com.smartgwt.client.widgets.calendar.Calendar#getAutoFetchData autoFetchData} is
     * set.
     *
     * @param initialCriteria initialCriteria Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setInitialCriteria(Criteria initialCriteria) throws IllegalStateException {
        setAttribute("initialCriteria", initialCriteria, false);
    }

    /**
     * Create a new event in this calendar instance.
     *
     * @param startDate   start date of event
     * @param endDate     end date of event
     * @param name        name of event
     * @param description description of event
     */
    public native void addEvent(Date startDate, Date endDate, String name, String description) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addEvent(startDate, endDate, name, description);
    }-*/;

    /**
     * Create a new event in this calendar instance.
     *
     * @param startDate   start date of event
     * @param endDate     end date of event
     * @param name        name of event
     * @param description description of event
     * @param otherFields new values of additional fields to be updated
     */
    public native void addEvent(Date startDate, Date endDate, String name, String description, Map otherFields) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var otherFieldsJS = @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(otherFields);
        self.addEvent(startDate, endDate, name, description, otherFieldsJS);
    }-*/;

    /**
     * Remove an event from this calendar.
     *
     * @param event The event object to remove from the calendar
     */
    public native void removeEvent(CalendarEvent event) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.removeEvent(event.@com.smartgwt.client.widgets.calendar.CalendarEvent::getJsObj()());
        }-*/;

    /**
     * update an event in this calendar.
     *
     * @param event       The event object to remove from the calendar
     * @param startDate   start date of event
     * @param endDate     end date of event
     * @param name        name of event
     * @param description description of event
     */
    public native void updateEvent(CalendarEvent event, Date startDate, Date endDate, String name, String description) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.updateEvent(event.@com.smartgwt.client.widgets.calendar.CalendarEvent::getJsObj()(), startDate, endDate, name, description);
        }-*/;

    public void setDataSource(DataSource dataSource) {
        setAttribute("dataSource", dataSource.getOrCreateJsObj(), true);
    }

    /**
    * The DataSource that this component should bind to for default fields and for performing {@link com.smartgwt.client.data.DSRequest}. <P> Can be specified as either a DataSource instance or the String ID of a DataSource.
    *
    *
    * @return DataSource
    *
    */
    public DataSource getDataSource()  {
         return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("dataSource"));
    }

    public void setShowDayView(Boolean showDayView) throws IllegalStateException {
        setAttribute("showDayView", showDayView, false);
    }

    public void setShowWeekView(Boolean showWeekView) throws IllegalStateException {
        setAttribute("showWeekView", showWeekView, false);
    }

    public void setShowMonthView(Boolean showMonthView) throws IllegalStateException {
        setAttribute("showMonthView", showMonthView, false);
    }


    public void setShowDatePickerButton(Boolean showDatePickerButton) throws IllegalStateException {
        setAttribute("showDatePickerButton", showDatePickerButton, false);
    }

    public void setShowAddEventButton(Boolean showAddEventButton) throws IllegalStateException {
        setAttribute("showAddEventButton", showAddEventButton, false);
    }
	
    public CalendarEvent[] getData() {
        JavaScriptObject dataJS = getAttributeAsJavaScriptObject("data");
        CalendarEvent[] data = convertToCalendarEventArray(dataJS);
        return data;
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



