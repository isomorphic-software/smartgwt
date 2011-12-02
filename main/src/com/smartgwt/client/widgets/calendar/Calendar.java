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

import java.util.*;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * The Calendar component provides several different ways for a user to view and edit a set of events. Note that the
 * <b>ISC_Calendar.js</b> module must be  loaded to make use of the Calendar class. <P> <b>CalendarEvents</b> <P> Events
 * are represented as ordinary JavaScript Objects (see {@link com.smartgwt.client.widgets.calendar.CalendarEvent}).   The
 * Calendar expects to be able to read and write a basic set of properties  on events: name, startDate, endDate,
 * description, etc, which can be stored  under configurable property names (see eg {@link
 * com.smartgwt.client.widgets.calendar.Calendar#getStartDateField startDateField}. <P> Much like a {@link
 * com.smartgwt.client.widgets.grid.ListGrid} manages it's ListGridRecords, the Calendar can  either be passed an ordinary
 * Array of CalendarEvents or can fetch data from a  DataSource. <P> If the calendar is bound to a DataSource, event
 * changes by user action or by  calling methods will be saved to the DataSource. <P> <b>Navigation</b> <P> The calendar
 * supports a {@link com.smartgwt.client.widgets.calendar.Calendar#getWeekView WeekView},  {@link
 * com.smartgwt.client.widgets.calendar.Calendar#getDayView DayView} and {@link
 * com.smartgwt.client.widgets.calendar.Calendar#getMonthView MonthView} by  default.  The user can navigate using back and
 * forward buttons or via an  attached {@link com.smartgwt.client.widgets.calendar.Calendar#getDateChooser DateChooser}.
 * <P> <b>Event Manipulation</b> <P> Events can be created via clicking on the day, week or month views, or via the  "Add
 * Event" button.  In the day and week views, the user may click and drag  to create an event of a specific duration. <P>
 * Creating an event via click or click and drag pops up the {@link
 * com.smartgwt.client.widgets.calendar.Calendar#getEventDialog EventDialog}, which provides a simple form for  quick event
 * entry (only one field, the description, is required by default).   <P> A separate editor called the {@link
 * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor EventEditor} provides  an interface for editing all
 * possible properties of an event, including custom  properties.  The EventEditor is used whenever a pre-existing event is
 * being  edited, and can also be invoked by the user wherever the simpler EventDialog appears. <P> Events can also be
 * programmatically {@link com.smartgwt.client.widgets.calendar.Calendar#addEvent added}, {@link
 * com.smartgwt.client.widgets.calendar.Calendar#removeEvent removed}, or {@link
 * com.smartgwt.client.widgets.calendar.Calendar#updateEvent updated}.
 */
public class Calendar extends Canvas  implements DataBoundComponent, com.smartgwt.client.widgets.calendar.events.HasDayBodyClickHandlers, com.smartgwt.client.widgets.calendar.events.HasDayHeaderClickHandlers, com.smartgwt.client.widgets.calendar.events.HasEventChangedHandlers, com.smartgwt.client.widgets.calendar.events.HasEventClickHandlers, com.smartgwt.client.widgets.calendar.events.HasEventRemoveClickHandlers, com.smartgwt.client.widgets.calendar.events.HasEventMovedHandlers, com.smartgwt.client.widgets.calendar.events.HasEventAddedHandlers, com.smartgwt.client.widgets.calendar.events.HasEventRemovedHandlers, com.smartgwt.client.widgets.calendar.events.HasEventResizedHandlers, com.smartgwt.client.widgets.calendar.events.HasDateChangedHandlers, com.smartgwt.client.widgets.calendar.events.HasBackgroundClickHandlers, com.smartgwt.client.widgets.calendar.events.HasBackgroundMouseDownHandlers {

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
        scClassName = "Calendar";
    }

    public Calendar(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
        var widget = $wnd.isc[scClassName].create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
     * The text to be displayed when a user hovers over the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getAddEventButton add event} toolbar button
     *
     * @param addEventButtonHoverText addEventButtonHoverText Default value is "Add an event"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAddEventButtonHoverText(String addEventButtonHoverText)  throws IllegalStateException {
        setAttribute("addEventButtonHoverText", addEventButtonHoverText, false);
    }

    /**
     * The text to be displayed when a user hovers over the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getAddEventButton add event} toolbar button
     *
     *
     * @return String
     */
    public String getAddEventButtonHoverText()  {
        return getAttributeAsString("addEventButtonHoverText");
    }

    /**
     * If {@link com.smartgwt.client.widgets.calendar.Calendar#getAutoFetchData autoFetchData} is <code>true</code>, this
     * attribute allows the developer to specify a textMatchStyle for the initial {@link
     * com.smartgwt.client.widgets.calendar.Calendar#fetchData Calendar.fetchData} call.
     *
     * @param autoFetchTextMatchStyle autoFetchTextMatchStyle Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public void setAutoFetchTextMatchStyle(TextMatchStyle autoFetchTextMatchStyle)  throws IllegalStateException {
        setAttribute("autoFetchTextMatchStyle", autoFetchTextMatchStyle.getValue(), false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.calendar.Calendar#getAutoFetchData autoFetchData} is <code>true</code>, this
     * attribute allows the developer to specify a textMatchStyle for the initial {@link
     * com.smartgwt.client.widgets.calendar.Calendar#fetchData Calendar.fetchData} call.
     *
     *
     * @return TextMatchStyle
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public TextMatchStyle getAutoFetchTextMatchStyle()  {
        return EnumUtil.getEnum(TextMatchStyle.values(), getAttribute("autoFetchTextMatchStyle"));
    }

    /**
     * The base name for the CSS class applied to the grid cells of the day and week views of the calendar. This style will
     * have "Dark", "Over", "Selected", or "Disabled" appended to it according to the state of the cell.
     *
     * @param baseStyle baseStyle Default value is "calendar"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setBaseStyle(String baseStyle) {
        setAttribute("baseStyle", baseStyle, true);
    }

    /**
     * The base name for the CSS class applied to the grid cells of the day and week views of the calendar. This style will
     * have "Dark", "Over", "Selected", or "Disabled" appended to it according to the state of the cell.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getBaseStyle()  {
        return getAttributeAsString("baseStyle");
    }

    /**
     * The title for the cancel button in the event editor
     *
     * @param cancelButtonTitle cancelButtonTitle Default value is "Cancel"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCancelButtonTitle(String cancelButtonTitle)  throws IllegalStateException {
        setAttribute("cancelButtonTitle", cancelButtonTitle, false);
    }

    /**
     * The title for the cancel button in the event editor
     *
     *
     * @return String
     */
    public String getCancelButtonTitle()  {
        return getAttributeAsString("cancelButtonTitle");
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
     */
    public Boolean getCanCreateEvents()  {
        return getAttributeAsBoolean("canCreateEvents");
    }

    /**
     * If true, users can delete existing events. Defaults to {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanEditEvents canEditEvents}
     *
     * @param canDeleteEvents canDeleteEvents Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCanDeleteEvents(Boolean canDeleteEvents)  throws IllegalStateException {
        setAttribute("canDeleteEvents", canDeleteEvents, false);
    }

    /**
     * If true, users can delete existing events. Defaults to {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanEditEvents canEditEvents}
     *
     *
     * @return Boolean
     */
    public Boolean getCanDeleteEvents()  {
        return getAttributeAsBoolean("canDeleteEvents");
    }

    /**
     * Name of the field on each {@link com.smartgwt.client.widgets.calendar.CalendarEvent} that determines dragability.
     *
     * @param canDragEventField canDragEventField Default value is "canEdit"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public void setCanDragEventField(String canDragEventField)  throws IllegalStateException {
        setAttribute("canDragEventField", canDragEventField, false);
    }

    /**
     * Name of the field on each {@link com.smartgwt.client.widgets.calendar.CalendarEvent} that determines dragability.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public String getCanDragEventField()  {
        return getAttributeAsString("canDragEventField");
    }

    /**
     * If true, users can drag-reposition existing events.
     *
     * @param canDragEvents canDragEvents Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCanDragEvents(Boolean canDragEvents)  throws IllegalStateException {
        setAttribute("canDragEvents", canDragEvents, false);
    }

    /**
     * If true, users can drag-reposition existing events.
     *
     *
     * @return Boolean
     */
    public Boolean getCanDragEvents()  {
        return getAttributeAsBoolean("canDragEvents");
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
     */
    public Boolean getCanEditEvents()  {
        return getAttributeAsBoolean("canEditEvents");
    }

    /**
     * Name of the field on each {@link com.smartgwt.client.widgets.calendar.CalendarEvent} that determines editability.
     *
     * @param canEditField canEditField Default value is "canEdit"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public void setCanEditField(String canEditField)  throws IllegalStateException {
        setAttribute("canEditField", canEditField, false);
    }

    /**
     * Name of the field on each {@link com.smartgwt.client.widgets.calendar.CalendarEvent} that determines editability.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public String getCanEditField()  {
        return getAttributeAsString("canEditField");
    }

    /**
     * The date for which events are displayed in the day, week, and month tabs of  the calendar.  Default is today.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the current date for which the calendar will display events.
     *
     * @param chosenDate the new date to set as the current date. Default value is 'Today'
     */
    public void setChosenDate(java.util.Date chosenDate) {
        setAttribute("chosenDate", chosenDate, true);
    }

    /**
     * The date for which events are displayed in the day, week, and month tabs of  the calendar.  Default is today.
     *
     *
     * @return java.util.Date
     */
    public java.util.Date getChosenDate()  {
        return getAttributeAsDate("chosenDate");
    }

    /**
     * The name of the view that should be visible initially by default.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the currently visible view
     *
     * @param currentViewName The name of the view that should be made visible.. Default value is null
     */
    public void setCurrentViewName(ViewName currentViewName) {
        setAttribute("currentViewName", currentViewName.getValue(), true);
    }

    /**
     * The name of the view that should be visible initially by default.
     *
     *
     * @return Get the name of the visible view. Either 'day', 'week', or 'month'.
     */
    public ViewName getCurrentViewName()  {
        return EnumUtil.getEnum(ViewName.values(), getAttribute("currentViewName"));
    }

    /**
     * How to fetch and manage records retrieve from the server.  See {@link com.smartgwt.client.types.FetchMode}. <P> This
     * setting only applies to the {@link com.smartgwt.client.data.ResultSet} automatically created by calling {@link
     * com.smartgwt.client.widgets.calendar.Calendar#fetchData Calendar.fetchData}.  If a pre-existing ResultSet is passed to
     * setData() instead, it's existing setting for {@link com.smartgwt.client.data.ResultSet#getFetchMode fetchMode} applies.
     *
     * @param dataFetchMode dataFetchMode Default value is "paged"
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public void setDataFetchMode(FetchMode dataFetchMode) {
        setAttribute("dataFetchMode", dataFetchMode.getValue(), true);
    }

    /**
     * How to fetch and manage records retrieve from the server.  See {@link com.smartgwt.client.types.FetchMode}. <P> This
     * setting only applies to the {@link com.smartgwt.client.data.ResultSet} automatically created by calling {@link
     * com.smartgwt.client.widgets.calendar.Calendar#fetchData Calendar.fetchData}.  If a pre-existing ResultSet is passed to
     * setData() instead, it's existing setting for {@link com.smartgwt.client.data.ResultSet#getFetchMode fetchMode} applies.
     *
     *
     * @return FetchMode
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public FetchMode getDataFetchMode()  {
        return EnumUtil.getEnum(FetchMode.values(), getAttribute("dataFetchMode"));
    }

    /**
     * Date formatter for displaying events. Default is to use the system-wide default short date format, configured via 
     * Date.setShortDisplayFormat.  Specify any valid {@link com.smartgwt.client.types.DateDisplayFormat}.
     *
     * @param dateFormatter dateFormatter Default value is null
     */
    public void setDateFormatter(DateDisplayFormat dateFormatter) {
        setAttribute("dateFormatter", dateFormatter.getValue(), true);
    }

    /**
     * Date formatter for displaying events. Default is to use the system-wide default short date format, configured via 
     * Date.setShortDisplayFormat.  Specify any valid {@link com.smartgwt.client.types.DateDisplayFormat}.
     *
     *
     * @return DateDisplayFormat
     */
    public DateDisplayFormat getDateFormatter()  {
        return EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("dateFormatter"));
    }

    /**
     * The text to be displayed when a user hovers over the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDatePickerButton date picker} toolbar button
     *
     * @param datePickerHoverText datePickerHoverText Default value is "Choose a date"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDatePickerHoverText(String datePickerHoverText)  throws IllegalStateException {
        setAttribute("datePickerHoverText", datePickerHoverText, false);
    }

    /**
     * The text to be displayed when a user hovers over the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDatePickerButton date picker} toolbar button
     *
     *
     * @return String
     */
    public String getDatePickerHoverText()  {
        return getAttributeAsString("datePickerHoverText");
    }

    /**
     * The base name for the CSS class applied to the day body of the month view of the calendar. This style will have "Dark",
     * "Over", "Selected", or "Disabled" appended to it according to the state of the cell.
     *
     * @param dayBodyBaseStyle dayBodyBaseStyle Default value is "calMonthDayBody"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setDayBodyBaseStyle(String dayBodyBaseStyle) {
        setAttribute("dayBodyBaseStyle", dayBodyBaseStyle, true);
    }

    /**
     * The base name for the CSS class applied to the day body of the month view of the calendar. This style will have "Dark",
     * "Over", "Selected", or "Disabled" appended to it according to the state of the cell.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getDayBodyBaseStyle()  {
        return getAttributeAsString("dayBodyBaseStyle");
    }

    /**
     * The base name for the CSS class applied to the day headers of the month view. This style will have "Dark", "Over",
     * "Selected", or "Disabled" appended to it according to the state of the cell.
     *
     * @param dayHeaderBaseStyle dayHeaderBaseStyle Default value is "calMonthDayHeader"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setDayHeaderBaseStyle(String dayHeaderBaseStyle) {
        setAttribute("dayHeaderBaseStyle", dayHeaderBaseStyle, true);
    }

    /**
     * The base name for the CSS class applied to the day headers of the month view. This style will have "Dark", "Over",
     * "Selected", or "Disabled" appended to it according to the state of the cell.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getDayHeaderBaseStyle()  {
        return getAttributeAsString("dayHeaderBaseStyle");
    }

    /**
     * The title for the day view
     *
     * @param dayViewTitle dayViewTitle Default value is "Day"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDayViewTitle(String dayViewTitle)  throws IllegalStateException {
        setAttribute("dayViewTitle", dayViewTitle, false);
    }

    /**
     * The title for the day view
     *
     *
     * @return String
     */
    public String getDayViewTitle()  {
        return getAttributeAsString("dayViewTitle");
    }

    /**
     * The name of the description field in a {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.
     *
     * @param descriptionField descriptionField Default value is "description"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDescriptionField(String descriptionField)  throws IllegalStateException {
        setAttribute("descriptionField", descriptionField, false);
    }

    /**
     * The name of the description field in a {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.
     *
     *
     * @return String
     */
    public String getDescriptionField()  {
        return getAttributeAsString("descriptionField");
    }

    /**
     * The title for the edit button in the quick event dialog
     *
     * @param detailsButtonTitle detailsButtonTitle Default value is "Edit Details"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDetailsButtonTitle(String detailsButtonTitle)  throws IllegalStateException {
        setAttribute("detailsButtonTitle", detailsButtonTitle, false);
    }

    /**
     * The title for the edit button in the quick event dialog
     *
     *
     * @return String
     */
    public String getDetailsButtonTitle()  {
        return getAttributeAsString("detailsButtonTitle");
    }

    /**
     * If set, weekend days appear in disabled style and events cannot be created on weekends. Which days are considered
     * weekends is controlled by  weekendDays.
     *
     * @param disableWeekends disableWeekends Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public void setDisableWeekends(Boolean disableWeekends)  throws IllegalStateException {
        setAttribute("disableWeekends", disableWeekends, false);
    }

    /**
     * If set, weekend days appear in disabled style and events cannot be created on weekends. Which days are considered
     * weekends is controlled by  weekendDays.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public Boolean getDisableWeekends()  {
        return getAttributeAsBoolean("disableWeekends");
    }

    /**
     * The name of the end date field in a {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.
     *
     * @param endDateField endDateField Default value is "endDate"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public void setEndDateField(String endDateField)  throws IllegalStateException {
        setAttribute("endDateField", endDateField, false);
    }

    /**
     * The name of the end date field in a {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public String getEndDateField()  {
        return getAttributeAsString("endDateField");
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
     */
    public Boolean getEventAutoArrange()  {
        return getAttributeAsBoolean("eventAutoArrange");
    }

    /**
     * The title for the event name field in the quick event dialog
     *
     * @param eventNameFieldTitle eventNameFieldTitle Default value is "Event Name"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEventNameFieldTitle(String eventNameFieldTitle)  throws IllegalStateException {
        setAttribute("eventNameFieldTitle", eventNameFieldTitle, false);
    }

    /**
     * The title for the event name field in the quick event dialog
     *
     *
     * @return String
     */
    public String getEventNameFieldTitle()  {
        return getAttributeAsString("eventNameFieldTitle");
    }

    /**
     * When {@link com.smartgwt.client.widgets.calendar.Calendar#getEventAutoArrange eventAutoArrange} is true, setting
     * eventOverlap to true causes events that  share timeslots to overlap each other by a percentage of their width, specified
     * by  {@link com.smartgwt.client.widgets.calendar.Calendar#getEventOverlapPercent eventOverlapPercent}.  The default is
     * true.
     *
     * @param eventOverlap eventOverlap Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEventOverlap(Boolean eventOverlap)  throws IllegalStateException {
        setAttribute("eventOverlap", eventOverlap, false);
    }

    /**
     * When {@link com.smartgwt.client.widgets.calendar.Calendar#getEventAutoArrange eventAutoArrange} is true, setting
     * eventOverlap to true causes events that  share timeslots to overlap each other by a percentage of their width, specified
     * by  {@link com.smartgwt.client.widgets.calendar.Calendar#getEventOverlapPercent eventOverlapPercent}.  The default is
     * true.
     *
     *
     * @return Boolean
     */
    public Boolean getEventOverlap()  {
        return getAttributeAsBoolean("eventOverlap");
    }

    /**
     * When set to true, events that start at the same time will not overlap each other to prevent  events having their close
     * button hidden
     *
     * @param eventOverlapIdenticalStartTimes eventOverlapIdenticalStartTimes Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEventOverlapIdenticalStartTimes(Boolean eventOverlapIdenticalStartTimes)  throws IllegalStateException {
        setAttribute("eventOverlapIdenticalStartTimes", eventOverlapIdenticalStartTimes, false);
    }

    /**
     * When set to true, events that start at the same time will not overlap each other to prevent  events having their close
     * button hidden
     *
     *
     * @return Boolean
     */
    public Boolean getEventOverlapIdenticalStartTimes()  {
        return getAttributeAsBoolean("eventOverlapIdenticalStartTimes");
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
     */
    public int getEventOverlapPercent()  {
        return getAttributeAsInt("eventOverlapPercent");
    }

    /**
     * Determines how many minutes an event can be moved or resized by.
     *
     * @param eventSnapGap eventSnapGap Default value is 30
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setEventSnapGap(int eventSnapGap)  throws IllegalStateException {
        setAttribute("eventSnapGap", eventSnapGap, false);
    }

    /**
     * Determines how many minutes an event can be moved or resized by.
     *
     *
     * @return int
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public int getEventSnapGap()  {
        return getAttributeAsInt("eventSnapGap");
    }

    /**
     * The name of the field which will determine the row in which this event will be displayed for the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timelineView}
     *
     * @param eventTypeField eventTypeField Default value is "eventType"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public void setEventTypeField(String eventTypeField)  throws IllegalStateException {
        setAttribute("eventTypeField", eventTypeField, false);
    }

    /**
     * The name of the field which will determine the row in which this event will be displayed for the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timelineView}
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public String getEventTypeField()  {
        return getAttributeAsString("eventTypeField");
    }

    /**
     * The base name for the CSS class applied to event windows within calendars. This style will have "Header", "HeaderLabel",
     * and "Body" appended to it, according to  which part of the event window is being styled. For example, to style the
     * header, define a css class called 'eventWindowHeader'.
     *
     * @param eventWindowStyle eventWindowStyle Default value is "eventWindow"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setEventWindowStyle(String eventWindowStyle) {
        setAttribute("eventWindowStyle", eventWindowStyle, true);
    }

    /**
     * The base name for the CSS class applied to event windows within calendars. This style will have "Header", "HeaderLabel",
     * and "Body" appended to it, according to  which part of the event window is being styled. For example, to style the
     * header, define a css class called 'eventWindowHeader'.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getEventWindowStyle()  {
        return getAttributeAsString("eventWindowStyle");
    }

    /**
     * The name of the field used to override {@link com.smartgwt.client.widgets.calendar.Calendar#getEventWindowStyle
     * eventWindowStyle} for an individual {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.  See {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getEventWindowStyle eventWindowStyle}.
     *
     * @param eventWindowStyleField eventWindowStyleField Default value is "eventWindowStyle"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setEventWindowStyleField(String eventWindowStyleField)  throws IllegalStateException {
        setAttribute("eventWindowStyleField", eventWindowStyleField, false);
    }

    /**
     * The name of the field used to override {@link com.smartgwt.client.widgets.calendar.Calendar#getEventWindowStyle
     * eventWindowStyle} for an individual {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.  See {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getEventWindowStyle eventWindowStyle}.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getEventWindowStyleField()  {
        return getAttributeAsString("eventWindowStyleField");
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
     */
    public int getFirstDayOfWeek()  {
        return getAttributeAsInt("firstDayOfWeek");
    }

    /**
     * The message to display in the {@link com.smartgwt.client.widgets.calendar.Calendar#getEventEditor eventEditor} when the
     * 'To' date is greater than the 'From' date and a save is attempted.
     *
     * @param invalidDateMessage invalidDateMessage Default value is "From must be before To"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setInvalidDateMessage(Boolean invalidDateMessage)  throws IllegalStateException {
        setAttribute("invalidDateMessage", invalidDateMessage, false);
    }

    /**
     * The message to display in the {@link com.smartgwt.client.widgets.calendar.Calendar#getEventEditor eventEditor} when the
     * 'To' date is greater than the 'From' date and a save is attempted.
     *
     *
     * @return Boolean
     */
    public Boolean getInvalidDateMessage()  {
        return getAttributeAsBoolean("invalidDateMessage");
    }

    /**
     * The name of the end date field in a {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.
     *
     * @param leadingDateField leadingDateField Default value is "leadingDate"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public void setLeadingDateField(String leadingDateField)  throws IllegalStateException {
        setAttribute("leadingDateField", leadingDateField, false);
    }

    /**
     * The name of the end date field in a {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public String getLeadingDateField()  {
        return getAttributeAsString("leadingDateField");
    }

    /**
     * The title for the month view
     *
     * @param monthViewTitle monthViewTitle Default value is "Month"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setMonthViewTitle(String monthViewTitle)  throws IllegalStateException {
        setAttribute("monthViewTitle", monthViewTitle, false);
    }

    /**
     * The title for the month view
     *
     *
     * @return String
     */
    public String getMonthViewTitle()  {
        return getAttributeAsString("monthViewTitle");
    }

    /**
     * The name of the name field in a {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.
     *
     * @param nameField nameField Default value is "name"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public void setNameField(String nameField)  throws IllegalStateException {
        setAttribute("nameField", nameField, false);
    }

    /**
     * The name of the name field in a {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public String getNameField()  {
        return getAttributeAsString("nameField");
    }

    /**
     * The text to be displayed when a user hovers over the {@link com.smartgwt.client.widgets.calendar.Calendar#getNextButton
     * next}  toolbar button
     *
     * @param nextButtonHoverText nextButtonHoverText Default value is "Next"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setNextButtonHoverText(String nextButtonHoverText)  throws IllegalStateException {
        setAttribute("nextButtonHoverText", nextButtonHoverText, false);
    }

    /**
     * The text to be displayed when a user hovers over the {@link com.smartgwt.client.widgets.calendar.Calendar#getNextButton
     * next}  toolbar button
     *
     *
     * @return String
     */
    public String getNextButtonHoverText()  {
        return getAttributeAsString("nextButtonHoverText");
    }

    /**
     * In the month CSS style applied to both the header and body of days from other months when {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowOtherDays showOtherDays} is false.
     *
     * @param otherDayBlankStyle otherDayBlankStyle Default value is "calMonthOtherDayBlank"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setOtherDayBlankStyle(String otherDayBlankStyle)  throws IllegalStateException {
        setAttribute("otherDayBlankStyle", otherDayBlankStyle, false);
    }

    /**
     * In the month CSS style applied to both the header and body of days from other months when {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowOtherDays showOtherDays} is false.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getOtherDayBlankStyle()  {
        return getAttributeAsString("otherDayBlankStyle");
    }

    /**
     * The base name for the CSS class applied to the day body of the month view of the calendar. This style will have "Dark",
     * "Over", "Selected", or "Disabled" appended to it according to the state of the cell.
     *
     * @param otherDayBodyBaseStyle otherDayBodyBaseStyle Default value is "calMonthDayBody"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setOtherDayBodyBaseStyle(String otherDayBodyBaseStyle) {
        setAttribute("otherDayBodyBaseStyle", otherDayBodyBaseStyle, true);
    }

    /**
     * The base name for the CSS class applied to the day body of the month view of the calendar. This style will have "Dark",
     * "Over", "Selected", or "Disabled" appended to it according to the state of the cell.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getOtherDayBodyBaseStyle()  {
        return getAttributeAsString("otherDayBodyBaseStyle");
    }

    /**
     * The base name for the CSS class applied to the day headers of the month view. This style will have "Dark", "Over",
     * "Selected", or "Disabled" appended to it according to the state of the cell.
     *
     * @param otherDayHeaderBaseStyle otherDayHeaderBaseStyle Default value is "calMonthDayHeader"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setOtherDayHeaderBaseStyle(String otherDayHeaderBaseStyle) {
        setAttribute("otherDayHeaderBaseStyle", otherDayHeaderBaseStyle, true);
    }

    /**
     * The base name for the CSS class applied to the day headers of the month view. This style will have "Dark", "Over",
     * "Selected", or "Disabled" appended to it according to the state of the cell.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getOtherDayHeaderBaseStyle()  {
        return getAttributeAsString("otherDayHeaderBaseStyle");
    }

    /**
     * The text to be displayed when a user hovers over the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getPreviousButton previous} toolbar button
     *
     * @param previousButtonHoverText previousButtonHoverText Default value is "Previous"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setPreviousButtonHoverText(String previousButtonHoverText)  throws IllegalStateException {
        setAttribute("previousButtonHoverText", previousButtonHoverText, false);
    }

    /**
     * The text to be displayed when a user hovers over the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getPreviousButton previous} toolbar button
     *
     *
     * @return String
     */
    public String getPreviousButtonHoverText()  {
        return getAttributeAsString("previousButtonHoverText");
    }

    /**
     * The height of time-slots in the calendar.
     *
     * @param rowHeight rowHeight Default value is 20
     */
    public void setRowHeight(int rowHeight) {
        setAttribute("rowHeight", rowHeight, true);
    }

    /**
     * The height of time-slots in the calendar.
     *
     *
     * @return int
     */
    public int getRowHeight()  {
        return getAttributeAsInt("rowHeight");
    }

    /**
     * The title for the save button in the quick event dialog and the event editor
     *
     * @param saveButtonTitle saveButtonTitle Default value is "Save Event"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSaveButtonTitle(String saveButtonTitle)  throws IllegalStateException {
        setAttribute("saveButtonTitle", saveButtonTitle, false);
    }

    /**
     * The title for the save button in the quick event dialog and the event editor
     *
     *
     * @return String
     */
    public String getSaveButtonTitle()  {
        return getAttributeAsString("saveButtonTitle");
    }

    /**
     * If set, causes the {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart workday hours} to be sized to
     * fill the available space in the day view and week view, and automatically scrolls these views to the start of the
     * workday when the calendar is first displayed and whenever the user switches to a new day or week.
     *
     * @param scrollToWorkday scrollToWorkday Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setScrollToWorkday(Boolean scrollToWorkday)  throws IllegalStateException {
        setAttribute("scrollToWorkday", scrollToWorkday, false);
    }

    /**
     * If set, causes the {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart workday hours} to be sized to
     * fill the available space in the day view and week view, and automatically scrolls these views to the start of the
     * workday when the calendar is first displayed and whenever the user switches to a new day or week.
     *
     *
     * @return Boolean
     */
    public Boolean getScrollToWorkday()  {
        return getAttributeAsBoolean("scrollToWorkday");
    }

    /**
     * The base name for the CSS class applied to a cell that is selected via a mouse drag.
     *
     * @param selectedCellStyle selectedCellStyle Default value is "calendarCellSelected"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setSelectedCellStyle(String selectedCellStyle) {
        setAttribute("selectedCellStyle", selectedCellStyle, true);
    }

    /**
     * The base name for the CSS class applied to a cell that is selected via a mouse drag.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getSelectedCellStyle()  {
        return getAttributeAsString("selectedCellStyle");
    }

    /**
     * If false the controls bar at the top of the calendar will not be displayed. This consists  of the autoChildren: {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getPreviousButton previousButton}, {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getNextButton nextButton}, {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getAddEventButton addEventButton}, {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDatePickerButton datePickerButton}
     *
     * @param showControlsBar showControlsBar Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowControlsBar(Boolean showControlsBar)  throws IllegalStateException {
        setAttribute("showControlsBar", showControlsBar, false);
    }

    /**
     * If false the controls bar at the top of the calendar will not be displayed. This consists  of the autoChildren: {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getPreviousButton previousButton}, {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getNextButton nextButton}, {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getAddEventButton addEventButton}, {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDatePickerButton datePickerButton}
     *
     *
     * @return Boolean
     */
    public Boolean getShowControlsBar()  {
        return getAttributeAsBoolean("showControlsBar");
    }

    /**
     * Determines whether the {@link com.smartgwt.client.widgets.calendar.Calendar#getDateChooser dateChooser} is displayed.
     *
     * @param showDateChooser showDateChooser Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public void setShowDateChooser(Boolean showDateChooser)  throws IllegalStateException {
        setAttribute("showDateChooser", showDateChooser, false);
    }

    /**
     * Determines whether the {@link com.smartgwt.client.widgets.calendar.Calendar#getDateChooser dateChooser} is displayed.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public Boolean getShowDateChooser()  {
        return getAttributeAsBoolean("showDateChooser");
    }

    /**
     * If false, the month view does not show day headers
     *
     * @param showDayHeaders showDayHeaders Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public void setShowDayHeaders(Boolean showDayHeaders)  throws IllegalStateException {
        setAttribute("showDayHeaders", showDayHeaders, false);
    }

    /**
     * If false, the month view does not show day headers
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public Boolean getShowDayHeaders()  {
        return getAttributeAsBoolean("showDayHeaders");
    }

    /**
     * Whether to show fields marked <code>detail:true</code> when a DataBoundComponent is  given a DataSource but no
     * <code>component.fields</code>. <p> The <code>detail</code> property is used on DataSource fields to mark fields that 
     * shouldn't appear by default in a view that tries to show many records in a small space.
     *
     * @param showDetailFields showDetailFields Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public void setShowDetailFields(Boolean showDetailFields)  throws IllegalStateException {
        setAttribute("showDetailFields", showDetailFields, false);
    }

    /**
     * Whether to show fields marked <code>detail:true</code> when a DataBoundComponent is  given a DataSource but no
     * <code>component.fields</code>. <p> The <code>detail</code> property is used on DataSource fields to mark fields that 
     * shouldn't appear by default in a view that tries to show many records in a small space.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public Boolean getShowDetailFields()  {
        return getAttributeAsBoolean("showDetailFields");
    }

    /**
     * If set to true, in the month view, days that fall in an adjacent month are still shown with a header and body area, and
     * are interactive.  Otherwise days from other months are rendered in the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getOtherDayBlankStyle otherDayBlankStyle} and are non-interactive.
     *
     * @param showOtherDays showOtherDays Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public void setShowOtherDays(Boolean showOtherDays)  throws IllegalStateException {
        setAttribute("showOtherDays", showOtherDays, false);
    }

    /**
     * If set to true, in the month view, days that fall in an adjacent month are still shown with a header and body area, and
     * are interactive.  Otherwise days from other months are rendered in the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getOtherDayBlankStyle otherDayBlankStyle} and are non-interactive.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public Boolean getShowOtherDays()  {
        return getAttributeAsBoolean("showOtherDays");
    }

    /**
     * Determines whether the quick event dialog is displayed when a time is clicked. If this is false, the full event editor
     * is displayed.
     *
     * @param showQuickEventDialog showQuickEventDialog Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setShowQuickEventDialog(Boolean showQuickEventDialog)  throws IllegalStateException {
        setAttribute("showQuickEventDialog", showQuickEventDialog, false);
    }

    /**
     * Determines whether the quick event dialog is displayed when a time is clicked. If this is false, the full event editor
     * is displayed.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public Boolean getShowQuickEventDialog()  {
        return getAttributeAsBoolean("showQuickEventDialog");
    }

    /**
     * Suppresses the display of weekend days in the week and month views, and disallows the creation of events on weekends. 
     * Which days are considered weekends is controlled by  weekendDays.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.calendar.Calendar#getShowWeekends showWeekends} to change this property at runtime.
     *
     * @param showWeekends showWeekends Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public void setShowWeekends(Boolean showWeekends)  throws IllegalStateException {
        setAttribute("showWeekends", showWeekends, false);
    }

    /**
     * Suppresses the display of weekend days in the week and month views, and disallows the creation of events on weekends. 
     * Which days are considered weekends is controlled by  weekendDays.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public Boolean getShowWeekends()  {
        return getAttributeAsBoolean("showWeekends");
    }

    /**
     * If set, causes the calendar to use {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayBaseStyle
     * workdayBaseStyle} for cells falling within the workday as defined by {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart workdayStart} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWorkdayEnd workdayEnd}, in both the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWeekView weekView} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDayView dayView}.
     *
     * @param showWorkday showWorkday Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowWorkday(Boolean showWorkday)  throws IllegalStateException {
        setAttribute("showWorkday", showWorkday, false);
    }

    /**
     * If set, causes the calendar to use {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayBaseStyle
     * workdayBaseStyle} for cells falling within the workday as defined by {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart workdayStart} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWorkdayEnd workdayEnd}, in both the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWeekView weekView} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDayView dayView}.
     *
     *
     * @return Boolean
     */
    public Boolean getShowWorkday()  {
        return getAttributeAsBoolean("showWorkday");
    }

    /**
     * The name of the start date field in a {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.
     *
     * @param startDateField startDateField Default value is "startDate"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public void setStartDateField(String startDateField)  throws IllegalStateException {
        setAttribute("startDateField", startDateField, false);
    }

    /**
     * The name of the start date field in a {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public String getStartDateField()  {
        return getAttributeAsString("startDateField");
    }

    /**
     * The title for the timeline view
     *
     * @param timelineViewTitle timelineViewTitle Default value is "Timeline"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTimelineViewTitle(String timelineViewTitle)  throws IllegalStateException {
        setAttribute("timelineViewTitle", timelineViewTitle, false);
    }

    /**
     * The title for the timeline view
     *
     *
     * @return String
     */
    public String getTimelineViewTitle()  {
        return getAttributeAsString("timelineViewTitle");
    }

    /**
     * The name of the end date field in a {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.
     *
     * @param trailingDateField trailingDateField Default value is "trailingDate"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public void setTrailingDateField(String trailingDateField)  throws IllegalStateException {
        setAttribute("trailingDateField", trailingDateField, false);
    }

    /**
     * The name of the end date field in a {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public String getTrailingDateField()  {
        return getAttributeAsString("trailingDateField");
    }

    /**
     * Augments the width of week event windows slightly to avoid duplicate adjacent borders between events.
     *
     * @param weekEventBorderOverlap weekEventBorderOverlap Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setWeekEventBorderOverlap(Boolean weekEventBorderOverlap)  throws IllegalStateException {
        setAttribute("weekEventBorderOverlap", weekEventBorderOverlap, false);
    }

    /**
     * Augments the width of week event windows slightly to avoid duplicate adjacent borders between events.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getWeekEventBorderOverlap()  {
        return getAttributeAsBoolean("weekEventBorderOverlap");
    }

    /**
     * The title for the week view
     *
     * @param weekViewTitle weekViewTitle Default value is "Week"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setWeekViewTitle(String weekViewTitle)  throws IllegalStateException {
        setAttribute("weekViewTitle", weekViewTitle, false);
    }

    /**
     * The title for the week view
     *
     *
     * @return String
     */
    public String getWeekViewTitle()  {
        return getAttributeAsString("weekViewTitle");
    }

    /**
     * If {@link com.smartgwt.client.widgets.calendar.Calendar#getShowWorkday showWorkday} is set, style used for cells that
     * are within the workday, as defined by {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart workdayStart}
     * and {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayEnd workdayEnd}.
     *
     * @param workdayBaseStyle workdayBaseStyle Default value is "calendarWorkday"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setWorkdayBaseStyle(String workdayBaseStyle)  throws IllegalStateException {
        setAttribute("workdayBaseStyle", workdayBaseStyle, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.calendar.Calendar#getShowWorkday showWorkday} is set, style used for cells that
     * are within the workday, as defined by {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart workdayStart}
     * and {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayEnd workdayEnd}.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getWorkdayBaseStyle()  {
        return getAttributeAsString("workdayBaseStyle");
    }

    /**
     * When using {@link com.smartgwt.client.widgets.calendar.Calendar#getShowWorkday showWorkday}:true,
     * <code>workdayStart</code> and <code>workdayEnd</code> specify the time of day when the workday starts and ends,
     * specified as a String acceptable to String. <P> Both start and end time must fall on a 30 minute increment (eg 9:30, but
     * not 9:45).
     *
     * @param workdayEnd workdayEnd Default value is "5:00pm"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setWorkdayEnd(String workdayEnd)  throws IllegalStateException {
        setAttribute("workdayEnd", workdayEnd, false);
    }

    /**
     * When using {@link com.smartgwt.client.widgets.calendar.Calendar#getShowWorkday showWorkday}:true,
     * <code>workdayStart</code> and <code>workdayEnd</code> specify the time of day when the workday starts and ends,
     * specified as a String acceptable to String. <P> Both start and end time must fall on a 30 minute increment (eg 9:30, but
     * not 9:45).
     *
     *
     * @return String
     */
    public String getWorkdayEnd()  {
        return getAttributeAsString("workdayEnd");
    }

    /**
     * When using {@link com.smartgwt.client.widgets.calendar.Calendar#getShowWorkday showWorkday}:true,
     * <code>workdayStart</code> and <code>workdayEnd</code> specify the time of day when the workday starts and ends,
     * specified as a String acceptable to String. <P> Both start and end time must fall on a 30 minute increment (eg 9:30, but
     * not 9:45).
     *
     * @param workdayStart workdayStart Default value is "9:00am"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setWorkdayStart(String workdayStart)  throws IllegalStateException {
        setAttribute("workdayStart", workdayStart, false);
    }

    /**
     * When using {@link com.smartgwt.client.widgets.calendar.Calendar#getShowWorkday showWorkday}:true,
     * <code>workdayStart</code> and <code>workdayEnd</code> specify the time of day when the workday starts and ends,
     * specified as a String acceptable to String. <P> Both start and end time must fall on a 30 minute increment (eg 9:30, but
     * not 9:45).
     *
     *
     * @return String
     */
    public String getWorkdayStart()  {
        return getAttributeAsString("workdayStart");
    }

    // ********************* Methods ***********************
    /**
     * Add a backgroundClick handler.
     * <p>
     * Callback fired when the mouse is clicked in a background-cell, ie, one without an  event.
     *
     * @param handler the backgroundClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addBackgroundClickHandler(com.smartgwt.client.widgets.calendar.events.BackgroundClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.calendar.events.BackgroundClickEvent.getType()) == 0) setupBackgroundClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.calendar.events.BackgroundClickEvent.getType());
    }

    private native void setupBackgroundClickEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({backgroundClick:$debox($entry(function(){
                        var param = {"startDate" : arguments[0], "endDate" : arguments[1]};
                        var event = @com.smartgwt.client.widgets.calendar.events.BackgroundClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.backgroundClick = $debox($entry(function(){
                   var param = {"startDate" : arguments[0], "endDate" : arguments[1]};
                   var event = @com.smartgwt.client.widgets.calendar.events.BackgroundClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                   var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                   return !ret;
               }));
        }
   }-*/;
    /**
     * Add a backgroundMouseDown handler.
     * <p>
     * Callback fired when the mouse button is depressed over a background-cell, ie, one  without an event.  Call {@link com.smartgwt.client.widgets.calendar.events.BackgroundMouseDownEvent#cancel()} from within {@link BackgroundMouseDownHandler#onBackgroundMouseDown} to
     * cancel the default behavior of allowing sweep selection via dragging.
     *
     * @param handler the backgroundMouseDown handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addBackgroundMouseDownHandler(com.smartgwt.client.widgets.calendar.events.BackgroundMouseDownHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.calendar.events.BackgroundMouseDownEvent.getType()) == 0) setupBackgroundMouseDownEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.calendar.events.BackgroundMouseDownEvent.getType());
    }

    private native void setupBackgroundMouseDownEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({backgroundMouseDown:$debox($entry(function(){
                        var param = {"startDate" : arguments[0]};
                        var event = @com.smartgwt.client.widgets.calendar.events.BackgroundMouseDownEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.backgroundMouseDown = $debox($entry(function(){
                   var param = {"startDate" : arguments[0]};
                   var event = @com.smartgwt.client.widgets.calendar.events.BackgroundMouseDownEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                   var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                   return !ret;
               }));
        }
   }-*/;
    /**
     * Add a dateChanged handler.
     * <p>
     * Fires whenever the user changes the current date, including picking a specific date or navigating to a new week or
     * month.
     *
     * @param handler the dateChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
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
            obj.addProperties({dateChanged:$entry(function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.calendar.events.DateChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.dateChanged = $entry(function(){
                   var param = {};
                   var event = @com.smartgwt.client.widgets.calendar.events.DateChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
               });
        }
   }-*/;
            
    /**
     * Should the parameter date be considered a workday? By default this method tries to find the parameter date day in {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWorkdays workdays}, and returns true if found. Override this method to 
     * provide custom logic for determining workday, for example returning false on holidays.
     * @param date date to check for being a workday
     *
     * @return true if date is a workday, false otherwise
     */
    public native Boolean dateIsWorkday(Date date) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.dateIsWorkday(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date));
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
    /**
     * Add a dayBodyClick handler.
     * <p>
     * Called when the body area of a day in the month view is clicked on, outside of any links to a particular event. <P> By
     * default, if the user can add events, shows a dialog for adding a new event for that day.  Call {@link com.smartgwt.client.widgets.calendar.events.DayBodyClickEvent#cancel()} from within {@link DayBodyClickHandler#onDayBodyClick} to cancel this
     * action. <P> Not called if the day falls outside the current month and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowOtherDays showOtherDays} is false.
     *
     * @param handler the dayBodyClick handler
     * @return {@link HandlerRegistration} used to remove this handler
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
            obj.addProperties({dayBodyClick:$debox($entry(function(){
                        var param = {"date" : arguments[0], "events" : arguments[1], "calendar" : arguments[2], "rowNum" : arguments[3], "colNum" : arguments[4]};
                        var event = @com.smartgwt.client.widgets.calendar.events.DayBodyClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.dayBodyClick = $debox($entry(function(){
                   var param = {"date" : arguments[0], "events" : arguments[1], "calendar" : arguments[2], "rowNum" : arguments[3], "colNum" : arguments[4]};
                   var event = @com.smartgwt.client.widgets.calendar.events.DayBodyClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                   var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                   return !ret;
               }));
        }
   }-*/;
    /**
     * Add a dayHeaderClick handler.
     * <p>
     * Called when the header area of a day in the month view is clicked on. <P> By default, moves to the day tab and shows the
     * clicked days events. Call {@link com.smartgwt.client.widgets.calendar.events.DayHeaderClickEvent#cancel()} from within {@link DayHeaderClickHandler#onDayHeaderClick} to cancel this action. <P> Not called if the day falls outside the current month and
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getShowOtherDays showOtherDays} is false.
     *
     * @param handler the dayHeaderClick handler
     * @return {@link HandlerRegistration} used to remove this handler
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
            obj.addProperties({dayHeaderClick:$debox($entry(function(){
                        var param = {"date" : arguments[0], "events" : arguments[1], "calendar" : arguments[2], "rowNum" : arguments[3], "colNum" : arguments[4]};
                        var event = @com.smartgwt.client.widgets.calendar.events.DayHeaderClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.dayHeaderClick = $debox($entry(function(){
                   var param = {"date" : arguments[0], "events" : arguments[1], "calendar" : arguments[2], "rowNum" : arguments[3], "colNum" : arguments[4]};
                   var event = @com.smartgwt.client.widgets.calendar.events.DayHeaderClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                   var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                   return !ret;
               }));
        }
   }-*/;
    /**
     * Add a eventAdded handler.
     * <p>
     * Notification fired whenever a user adds an event. <P> In a calendar with a DataSource, eventAdded() fires <b>after</b>
     * the event has been successfully added to the server
     *
     * @param handler the eventAdded handler
     * @return {@link HandlerRegistration} used to remove this handler
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
            obj.addProperties({eventAdded:$entry(function(){
                        var param = {"event" : arguments[0]};
                        var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventAdded::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.eventAdded = $entry(function(){
                   var param = {"event" : arguments[0]};
                   var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventAdded::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
               });
        }
   }-*/;
    /**
     * Add a eventChanged handler.
     * <p>
     * Notification fired whenever a user changes an event, whether by dragging the event or by editing it in a dialog. <P> In
     * a calendar with a DataSource, eventChanged() fires <b>after</b> the updated event has been successfully saved to the
     * server
     *
     * @param handler the eventChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
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
            obj.addProperties({eventChanged:$entry(function(){
                        var param = {"event" : arguments[0]};
                        var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.eventChanged = $entry(function(){
                   var param = {"event" : arguments[0]};
                   var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
               });
        }
   }-*/;
    /**
     * Add a eventClick handler.
     * <p>
     * Called whenever an event is clicked on in the day, week or month views. <P> By default a dialog appears showing details
     * for the event, and offering the ability to edit events which are editable.  Call {@link com.smartgwt.client.widgets.calendar.events.CalendarEventClick#cancel()} from within {@link EventClickHandler#onEventClick} to cancel the default action.
     * This is a good place to, for example, show a completely customized event dialog instead of the default one.
     *
     * @param handler the eventClick handler
     * @return {@link HandlerRegistration} used to remove this handler
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
            obj.addProperties({eventClick:$debox($entry(function(){
                        var param = {"event" : arguments[0], "viewName" : arguments[1]};
                        var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventClick::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.eventClick = $debox($entry(function(){
                   var param = {"event" : arguments[0], "viewName" : arguments[1]};
                   var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventClick::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                   var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                   return !ret;
               }));
        }
   }-*/;
    /**
     * Add a eventMoved handler.
     * <p>
     * Called when an event is moved via dragging by a user.  Call {@link com.smartgwt.client.widgets.calendar.events.CalendarEventMoved#cancel()} from within {@link EventMovedHandler#onEventMoved} to disallow the move.
     *
     * @param handler the eventMoved handler
     * @return {@link HandlerRegistration} used to remove this handler
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
            obj.addProperties({eventMoved:$debox($entry(function(){
                        var param = {"newDate" : arguments[0], "event" : arguments[1]};
                        var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventMoved::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.eventMoved = $debox($entry(function(){
                   var param = {"newDate" : arguments[0], "event" : arguments[1]};
                   var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventMoved::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                   var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                   return !ret;
               }));
        }
   }-*/;
    /**
     * Add a eventRemoveClick handler.
     * <p>
     * Called whenever the close icon of an event is clicked within the day or week view. Call {@link com.smartgwt.client.widgets.calendar.events.CalendarEventRemoveClick#cancel()} from within {@link EventRemoveClickHandler#onEventRemoveClick} to cancel the removal,
     * or . <P> Implement this method to do something like, for example, showing a confirmation dialog  before
     * an event is removed.
     *
     * @param handler the eventRemoveClick handler
     * @return {@link HandlerRegistration} used to remove this handler
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
            obj.addProperties({eventRemoveClick:$debox($entry(function(){
                        var param = {"event" : arguments[0], "viewName" : arguments[1]};
                        var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventRemoveClick::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.eventRemoveClick = $debox($entry(function(){
                   var param = {"event" : arguments[0], "viewName" : arguments[1]};
                   var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventRemoveClick::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                   var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                   return !ret;
               }));
        }
   }-*/;
    /**
     * Add a eventRemoved handler.
     * <p>
     * Notification fired whenever a user removes an event <P> In a calendar with a DataSource, eventRemoved() fires
     * <b>after</b> the event has been successfully removed from the server
     *
     * @param handler the eventRemoved handler
     * @return {@link HandlerRegistration} used to remove this handler
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
            obj.addProperties({eventRemoved:$entry(function(){
                        var param = {"event" : arguments[0]};
                        var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventRemoved::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.eventRemoved = $entry(function(){
                   var param = {"event" : arguments[0]};
                   var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventRemoved::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
               });
        }
   }-*/;
    /**
     * Add a eventResized handler.
     * <p>
     * Called when an event is resized via dragging by a user.  Call {@link com.smartgwt.client.widgets.calendar.events.CalendarEventResized#cancel()} from within {@link EventResizedHandler#onEventResized} to disallow the resize.
     *
     * @param handler the eventResized handler
     * @return {@link HandlerRegistration} used to remove this handler
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
            obj.addProperties({eventResized:$debox($entry(function(){
                        var param = {"newDate" : arguments[0], "event" : arguments[1]};
                        var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventResized::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.eventResized = $debox($entry(function(){
                   var param = {"newDate" : arguments[0], "event" : arguments[1]};
                   var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventResized::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                   var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                   return !ret;
               }));
        }
   }-*/;
            
    /**
     * Gets the day of the week (0-6) that the mouse is currently over.
     *
     * @return the day that the mouse is currently over
     * @see com.smartgwt.client.widgets.calendar.Calendar#getActiveTime
     */
    public native int getActiveDay() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getActiveDay();
    }-*/;
            
    /**
     * Gets a date object representing the date over which the mouse is hovering for the current selected view. For month view,
     * the time will be set to midnight of the active day. For dayview and week view, the time will be the rounded to the
     * closest half hour relative to the mouse position.
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
     * Fires whenever the user changes the current date, including picking a specific date or navigating to a new week or
     * month.
     * @param tabnum the index of the tab to select
     */
    public native void selectTab(int tabnum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectTab(tabnum);
    }-*/;
            
    /**
     * Sets the range over which the timeline will display events
     * @param start start of range
     * @param end end of range
     */
    public native void setTimelineRange(Date start, Date end) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setTimelineRange(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(start), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(end));
    }-*/;

    // ********************* Static Methods ***********************
    /**
     * Class level method to set the default properties of this class. If set, then all subsequent instances of this
     * class will automatically have the default properties that were set when this method was called. This is a powerful
     * feature that eliminates the need for users to create a separate hierarchy of subclasses that only alter the default
     * properties of this class. Can also be used for skinning / styling purposes.
     * <P>
     * <b>Note:</b> This method is intended for setting default attributes only and will effect all instances of the
     * underlying class (including those automatically generated in JavaScript). 
     * This method should not be used to apply standard EventHandlers or override methods for
     * a class - use a custom subclass instead.
     *
     * @param calendarProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(Calendar calendarProperties) /*-{
    	var properties = $wnd.isc.addProperties({},calendarProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.Calendar.addProperties(properties);
    }-*/;
        
    // ***********************************************************        


	protected void onInit() {
		super.onInit();
		onInit_Calendar();
	}
    protected native void onInit_Calendar() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self._getDayBodyHTML = self.getDayBodyHTML;

        self.getDayBodyHTML = $debox($entry(function(date, events, calendar, rowNum, colNum) {
            var jObj = this.__ref;
            var dateJ = @com.smartgwt.client.util.JSOHelper::toDate(D)(date.getTime());
            var eventsJ = events == null ? null : @com.smartgwt.client.widgets.calendar.CalendarEvent::convertToCalendarEventArray(Lcom/google/gwt/core/client/JavaScriptObject;)(events);
            var calendarJ = @com.smartgwt.client.widgets.calendar.Calendar::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(calendar);            
            return jObj.@com.smartgwt.client.widgets.calendar.Calendar::getDayBodyHTML(Ljava/util/Date;[Lcom/smartgwt/client/widgets/calendar/CalendarEvent;Lcom/smartgwt/client/widgets/calendar/Calendar;II)(dateJ, eventsJ, calendarJ, rowNum, colNum);
        }));
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
    /*
    public FormItem[] getEventEditorFields()  {
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
            JavaScriptObject config = formItem.getEditorTypeConfig();
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
    /*
    public FormItem[] getEventDialogFields()  {
        return getAttribute("eventDialogFields");
    } */

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
     * An array of Record objects, specifying the data to be used to populate the DataBoundComponent. Note that not
     * all DataBoundComponents observe the changes to the data to redraw themselves. Refer to the version of setData
     * that accepts component specific records.
     *
     * @param data array of Record objects.
     * @see #setData(CalendarEvent[])
     */
    public void setData(Record[] data) {
        setAttribute("data", data, true);
    }

    /**
     * An List of Record objects, specifying the data to be used to populate the DataBoundComponent. Note that not
     * all DataBoundComponents observe the changes to the data to redraw themselves. Refer to the version of setData
     * that accepts component specific records.
     *
     * @param data List of Records
     */
    public void setData(RecordList data) {
        setAttribute("data", data == null ? null : data.getOrCreateJsObj(), true);
    }

    /**
     * Display format to use for the time portion of events' date information.
     *
     * @param timeFormatter timeFormatter Default value is "toShortPaddedTime"
     * @deprecated use {@link #setTimeFormatter(TimeDisplayFormat)} instead.
     */
    public void setTimeFormatter(TimeFormatter timeFormatter) {
        setAttribute("timeFormatter", timeFormatter, true);
    }
    
    /**
     * Display format to use for the time portion of events' date information.
     *
     * @param timeFormatter timeFormatter Default value is "toShortPaddedTime"
     */
    public void setTimeFormatter(TimeDisplayFormat timeFormatter) {
        setAttribute("timeFormatter", timeFormatter, true);
    }

    /**
     * Display format to use for the time portion of events' date information.
     *
     *
     * @return TimeDisplayFormat
     */
    public TimeDisplayFormat getTimeFormatter()  {
        return EnumUtil.getEnum(TimeDisplayFormat.values(), getAttribute("timeFormatter"));
    }

    /**
     * A List of CalendarEvent objects, specifying the data to be used to populate the calendar.   <p> This property will typically not be explicitly specified for databound Calendars, where the data is returned from the server via databound component methods such as {@link com.smartgwt.client.widgets.calendar.Calendar#fetchData}. In this case the data objects will be set to a  {@link com.smartgwt.client.data.ResultSet} rather than a simple array.
     *
     * @return List of CalendarEvent
     */
    /*
    public CalendarEvent[] getData()  {
        return getAttribute("data");
    }*/

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
        self.addEvent(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(startDate),
                      @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(endDate),
                      name, description);
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
        self.addEvent(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(startDate),
                      @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(endDate),
                      name, description,
                      otherFieldsJS);
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
        self.updateEvent(event.@com.smartgwt.client.widgets.calendar.CalendarEvent::getJsObj()(),
                @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(startDate),
                @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(endDate), name, description);
    }-*/;

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
	
    /**
     * Array of days that are considered workdays when {@link com.smartgwt.client.widgets.calendar.Calendar#getShowWorkday
     * showWorkday} is true
     *
     * @param workdays workdays Default value is [1,2,3,4,5]
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setWorkdays(int[] workdays)  throws IllegalStateException {
        setAttribute("workdays", workdays, false);
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



    // ********************* DataBoundComponent Properties / Attributes ***********************

    public void setDataPageSize(int dataPageSize) {
        setAttribute("dataPageSize", dataPageSize, true);
    }

    public int getDataPageSize() {
        return getAttributeAsInt("dataPageSize");
    }

    public void setUseAllDataSourceFields(Boolean useAllDataSourceFields) {
        setAttribute("useAllDataSourceFields", useAllDataSourceFields, true);
    }

    public Boolean getUseAllDataSourceFields() {
        return getAttributeAsBoolean("useAllDataSourceFields");
    }

    public void setShowHiddenFields(Boolean showHiddenFields) {
        setAttribute("showHiddenFields", showHiddenFields, true);
    }

    public Boolean getShowHiddenFields() {
        return getAttributeAsBoolean("showHiddenFields");
    }

    public void setShowComplexFields(Boolean showComplexFields) {
        setAttribute("showComplexFields", showComplexFields, true);
    }

    public Boolean getShowComplexFields() {
        return getAttributeAsBoolean("showComplexFields");
    }

    public void setFetchOperation(String fetchOperation) {
        setAttribute("fetchOperation", fetchOperation, true);
    }

    public String getFetchOperation() {
        return getAttributeAsString("fetchOperation");
    }

    public void setUpdateOperation(String updateOperation) {
        setAttribute("updateOperation", updateOperation, true);
    }

    public String getUpdateOperation() {
        return getAttributeAsString("updateOperation");
    }

    public void setAddOperation(String addOperation) {
        setAttribute("addOperation", addOperation, true);
    }

    public String getAddOperation() {
        return getAttributeAsString("addOperation");
    }

    public void setRemoveOperation(String removeOperation) {
        setAttribute("removeOperation", removeOperation, true);
    }

    public String getRemoveOperation() {
        return getAttributeAsString("removeOperation");
    }

    public void setExportFields(String[] exportFields) {
        setAttribute("exportFields", exportFields, true);
    }

    public String[] getExportFields() {
        return getAttributeAsStringArray("exportFields");
    }

    public void setExportAll(Boolean exportAll) {
        setAttribute("exportAll", exportAll, true);
    }

    public Boolean getExportAll() {
        return getAttributeAsBoolean("exportAll");
    }

    public void setPreventDuplicates(Boolean preventDuplicates) throws IllegalStateException {
        setAttribute("preventDuplicates", preventDuplicates, false);
    }

    public Boolean getPreventDuplicates() {
        return getAttributeAsBoolean("preventDuplicates");
    }

    public void setDuplicateDragMessage(String duplicateDragMessage) throws IllegalStateException {
        setAttribute("duplicateDragMessage", duplicateDragMessage, false);
    }

    public String getDuplicateDragMessage() {
        return getAttributeAsString("duplicateDragMessage");
    }

    public void setAddDropValues(Boolean addDropValues) {
        setAttribute("addDropValues", addDropValues, true);
    }

    public Boolean getAddDropValues() {
        return getAttributeAsBoolean("addDropValues");
    }

    public void setDropValues(Map dropValues) {
        setAttribute("dropValues", dropValues, true);
    }

    public Map getDropValues() {
        return getAttributeAsMap("dropValues");
    }

    public void setUseFlatFields(Boolean useFlatFields) throws IllegalStateException {
        setAttribute("useFlatFields", useFlatFields, false);
    }

    public Boolean getUseFlatFields() {
        return getAttributeAsBoolean("useFlatFields");
    }

    public void setHiliteProperty(String hiliteProperty) {
        setAttribute("hiliteProperty", hiliteProperty, true);
    }

    public String getHiliteProperty() {
        return getAttributeAsString("hiliteProperty");
    }

    /**
     * Shows a HiliteEditor interface allowing end-users to edit the data-hilites currently in use by this DataBoundComponent.
     */
    public native void editHilites() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.editHilites();
    }-*/;

    /**
     * Get the current hilites encoded as a String, for saving.
     *
     * @return the hilite state
     */
    public native String getHiliteState()  /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getHiliteState();
    }-*/;

    /**
     * Set the current hilites based on a hiliteState String previously returned from getHilitesState.
     *  
     * @param hiliteState hilites state encoded as a String
     */
    public native void setHiliteState(String hiliteState)  /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.setHiliteState(hiliteState);
    }-*/;

    /**
     * Accepts an array of hilite objects and applies them to this DataBoundComponent. See also {@link #getHilites() getHilites} for a method of
     * retrieving the hilite array for storage, including hilites manually added by the user.
     *
     * @param hilites array of hilite objects
     */
    public native void setHilites(Hilite[] hilites)/*-{
        var isCreated = this.@com.smartgwt.client.widgets.BaseWidget::isCreated()();
        var hilitesJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(hilites);
        if (isCreated) {
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.setHilites(hilitesJS);
        } else {
            var obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.hilites = hilitesJS;
        }
    }-*/;

    /**
     * Return the set of hilite-objects currently applied to this DataBoundComponent. These can be saved for
     * storage and then restored to a component later via setHilites().
     *
     * @return array of hilite objects
     */
    public native Hilite[] getHilites()/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var hilitesJS = self.getHilites();
        return @com.smartgwt.client.data.Hilite::convertToHiliteArray(Lcom/google/gwt/core/client/JavaScriptObject;)(hilitesJS);
    }-*/;

    public void setDragDataAction(DragDataAction dragDataAction) {
        setAttribute("dragDataAction", dragDataAction.getValue(), true);
    }

    public DragDataAction getDragDataAction() {
        return EnumUtil.getEnum(DragDataAction.values(), getAttribute("dragDataAction"));
    }

    public void setDragTrackerStyle(String dragTrackerStyle) {
        setAttribute("dragTrackerStyle", dragTrackerStyle, true);
    }

    public String getDragTrackerStyle() {
        return getAttributeAsString("dragTrackerStyle");
    }

    public void setCanAddFormulaFields(Boolean canAddFormulaFields) {
        setAttribute("canAddFormulaFields", canAddFormulaFields, true);
    }

    public native void addSummaryField() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.addSummaryField();
     }-*/;

    public native void addFormulaField() /*-{
       var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
       self.addFormulaField();
    }-*/;

    public Boolean getCanAddFormulaFields() {
        return getAttributeAsBoolean("canAddFormulaFields");
    }

    public void setAddFormulaFieldText(String addFormulaFieldText) {
        setAttribute("addFormulaFieldText", addFormulaFieldText, true);
    }

    public String getAddFormulaFieldText() {
        return getAttributeAsString("addFormulaFieldText");
    }

    public void setEditFormulaFieldText(String editFormulaFieldText) {
        setAttribute("editFormulaFieldText", editFormulaFieldText, true);
    }

    public String getEditFormulaFieldText() {
        return getAttributeAsString("editFormulaFieldText");
    }

    public void setCanAddSummaryFields(Boolean canAddSummaryFields) {
        setAttribute("canAddSummaryFields", canAddSummaryFields, true);
    }

    public Boolean getCanAddSummaryFields() {
        return getAttributeAsBoolean("canAddSummaryFields");
    }

    public void setAddSummaryFieldText(String addSummaryFieldText) {
        setAttribute("addSummaryFieldText", addSummaryFieldText, true);
    }

    public String getAddSummaryFieldText() {
        return getAttributeAsString("addSummaryFieldText");
    }

    public void setEditSummaryFieldText(String editSummaryFieldText) {
        setAttribute("editSummaryFieldText", editSummaryFieldText, true);
    }

    public String getEditSummaryFieldText() {
        return getAttributeAsString("editSummaryFieldText");
    }

    // ********************* Methods ***********************


    public native void selectRecord(Record record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.selectRecord(recordJS);
     }-*/;

    public native void selectRecord(int record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectRecord(record);
     }-*/;

    public native void selectRecord(int record, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectRecord(record, newState);
     }-*/;

    public native void selectRecord(Record record, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.selectRecord(recordJS, newState);
     }-*/;

    public native void selectRecords(int[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(records);
        self.selectRecord(recordsJS);
     }-*/;

    public native void selectRecords(int[] records, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(records);
        self.selectRecords(recordsJS, newState);
     }-*/;

    public native void selectRecords(Record[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        self.selectRecords(recordsJS);
     }-*/;

    public native void selectRecords(Record[] records, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        self.selectRecords(recordsJS, newState);
     }-*/;

    public native void deselectRecord(Record record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.deselectRecord(recordJS);
     }-*/;

    public native void deselectRecord(int record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.deselectRecord(record);
     }-*/;

    public native void deselectRecords(int[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(records);
        self.deselectRecords(recordsJS);
     }-*/;

    public native void deselectRecords(Record[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        self.deselectRecords(recordsJS);
     }-*/;

    public native void selectAllRecords() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.selectAllRecords();
     }-*/;

    public native void deselectAllRecords() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.deselectAllRecords();
     }-*/;

    public native Boolean anySelected() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         var retVal =self.anySelected();
         if(retVal == null || retVal === undefined) {
             return null;
         } else {
             return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
         }
     }-*/;

    public native void enableHilite(String hiliteID) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.enableHilite(hiliteID);
     }-*/;

    public native void enableHilite(String hiliteID, boolean enable) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.enableHilite(hiliteID, enable);
     }-*/;

    public native void disableHilite(String hiliteID) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.disableHilite(hiliteID);
     }-*/;

    public native void enableHiliting() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.enableHiliting();
     }-*/;

    public native void enableHiliting(boolean enable) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.enableHiliting(enable);
     }-*/;

    public native void disableHiliting() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.disableHiliting();
     }-*/;

    public native Record[] getDragData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = self.getDragData();
        return @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
     }-*/;

    public native void transferSelectedData(DataBoundComponent source) /*-{
         var self = this.@com.smartgwt.client.widgets.DataBoundComponent::getOrCreateJsObj()();
         self.transferSelectedData(source.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
     }-*/;

    public native void transferSelectedData(DataBoundComponent source, int index) /*-{
         var self = this.@com.smartgwt.client.widgets.DataBoundComponent::getOrCreateJsObj()();
         self.transferSelectedData(source.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), index);
     }-*/;

    public native int getRecordIndex(Record record) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         return self.getRecordIndex(record.@com.smartgwt.client.core.DataClass::getJsObj()());
     }-*/;

    public native String getTitleFieldValue(Record record) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         return self.getTitleFieldValue(record);
     }-*/;

    public void setTitleField(String titleField) {
        setAttribute("titleField", titleField, true);
    }

    public String getTitleField() {
        return getAttributeAsString("titleField");
    }

    public void setDataSource(DataSource dataSource) {
        setAttribute("dataSource", dataSource.getOrCreateJsObj(), true);
    }

    public DataSource getDataSource() {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("dataSource"));
    }

    public void setAutoFetchData(Boolean autoFetchData) throws IllegalStateException {
        setAttribute("autoFetchData", autoFetchData, false);
    }

    public Boolean getAutoFetchData() {
        return getAttributeAsBoolean("autoFetchData");
    }

    public void setAutoFetchAsFilter(Boolean autoFetchAsFilter) throws IllegalStateException {
        setAttribute("autoFetchAsFilter", autoFetchAsFilter, false);
    }

    public Boolean getAutoFetchAsFilter() {
        return getAttributeAsBoolean("autoFetchAsFilter");
    }

    public void setInitialCriteria(Criteria initialCriteria) throws IllegalStateException {
        setAttribute("initialCriteria", initialCriteria.getJsObj(), false);
    }

    public Criteria getInitialCriteria() {
        return new Criteria(getAttributeAsJavaScriptObject("initialCriteria"));
    }

    public native void fetchData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.fetchData();
    }-*/;

    public native void fetchData(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.fetchData(criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()());
    }-*/;

    public native void fetchData(Criteria criteria, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        self.fetchData(critJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }));
    }-*/;

    public native void fetchData(Criteria criteria, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.fetchData(critJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }), requestPropertiesJS);
    }-*/;

    public native void filterData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.filterData();
    }-*/;

    public native void filterData(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.filterData(criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()());
    }-*/;

    public native void filterData(Criteria criteria, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        self.filterData(critJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }));
    }-*/;

    public native void filterData(Criteria criteria, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.filterData(critJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }), requestPropertiesJS);
    }-*/;

    public native void invalidateCache() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.invalidateCache();
    }-*/;

    public ResultSet getResultSet() {
        JavaScriptObject dataJS = getAttributeAsJavaScriptObject("data");
        if(dataJS == null) return null;
        if(!ResultSet.isResultSet(dataJS)) {
            SC.logWarn("getResultSet(): data is not a ResultSet; returning null " +
                "(if grouped, use getOriginalResultSet(); if unbound, use getRecordList(); " +
                "can only be called on DataBoundComponents after initial data has been fetched)");
            return null;
        }
        return new ResultSet(dataJS);
    }

    public RecordList getRecordList() {
        JavaScriptObject dataJS = getAttributeAsJavaScriptObject("data");
        if(dataJS == null) return null;

        if(ResultSet.isResultSet(dataJS)) {
            return getResultSet();
        }
        return new RecordList(dataJS);
    }

    /**
     * Uses a "fetch" operation on the current {@link com.smartgwt.client.widgets.DataBoundComponent#getDataSource DataSource}
     * to  retrieve data that matches the current filter and sort criteria for this component, then  exports the resulting data
     * to a file or window in the requested format. <P> A variety of DSRequest settings, such as  {@link
     * com.smartgwt.client.data.DSRequest#getExportAs exportAs} and {@link com.smartgwt.client.data.DSRequest#getExportFilename
     * exportFilename}, affect the  exporting process: see {@link com.smartgwt.client.data.DSRequest#getExportResults
     * exportResults} for further detail. <P> Note that data exported via this method does not include any client-side
     * formatting and relies on both the Smart GWT server and server-side DataSources.  To export client-data  with formatters
     * applied,  see {@link com.smartgwt.client.widgets.DataBoundComponent#exportClientData exportClientData}, which still
     * requires the Smart GWT server but does not rely on server-side DataSources. <P> For more information on exporting data,
     * see {@link com.smartgwt.client.data.DataSource#exportData DataSource.exportData}.
     */
    public native void exportData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.exportData();
    }-*/;

    /**
     * Uses a "fetch" operation on the current {@link com.smartgwt.client.widgets.DataBoundComponent#getDataSource DataSource}
     * to  retrieve data that matches the current filter and sort criteria for this component, then  exports the resulting data
     * to a file or window in the requested format. <P> A variety of DSRequest settings, such as  {@link
     * com.smartgwt.client.data.DSRequest#getExportAs exportAs} and {@link com.smartgwt.client.data.DSRequest#getExportFilename
     * exportFilename}, affect the  exporting process: see {@link com.smartgwt.client.data.DSRequest#getExportResults
     * exportResults} for further detail. <P> Note that data exported via this method does not include any client-side
     * formatting and relies on both the Smart GWT server and server-side DataSources.  To export client-data  with formatters
     * applied,  see {@link com.smartgwt.client.widgets.DataBoundComponent#exportClientData exportClientData}, which still
     * requires the Smart GWT server but does not rely on server-side DataSources. <P> For more information on exporting data,
     * see {@link com.smartgwt.client.data.DataSource#exportData DataSource.exportData}.
     * @param requestProperties additional properties to set on the DSRequest                                            that will be issued
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     */
    public native void exportData(DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.exportData(requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
    
   /**
    * Exports this component's data with client-side formatters applied, so is suitable for 
    * direct display to users.  This feature requires the SmartClient server, but does not 
    * rely on any server-side DataSources.
    * <P>To export unformatted data from this component's dataSource, see 
    * {@link com.smartgwt.client.widgets.DataBoundComponent#exportData exportData}
    * which does not include client-side formatters, 
    * but relies on both the SmartClient server and server-side DataSources.
    * @see com.smartgwt.client.data.DataSource#exportClientData
    */
    public native void exportClientData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.exportClientData();
    }-*/;

   /**
    * Exports this component's data with client-side formatters applied, so is suitable for 
    * direct display to users.  This feature requires the SmartClient server, but does not 
    * rely on any server-side DataSources.
    * <P>To export unformatted data from this component's dataSource, see
    * {@link com.smartgwt.client.widgets.DataBoundComponent#exportData exportData}
    * which does not include client-side formatters, 
    * but relies on both the SmartClient server and server-side DataSources.
    * @param requestProperties Request properties for the export
    * @see com.smartgwt.client.data.DataSource#exportClientData
    */
    public native void exportClientData(DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.exportClientData(requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    /**
     * Add a fetchData handler.
     * <p>
     * Notification function fired on fetchData() or filterData()
     *
     * @param handler the filterData handler
     * @return {@link com.google.gwt.event.shared.HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addFetchDataHandler(FetchDataHandler handler) {
        if(getHandlerCount(FetchDataEvent.getType()) == 0) setupFetchDataEvent();
        return doAddHandler(handler, FetchDataEvent.getType());
    }

    private native void setupFetchDataEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({onFetchData:$debox($entry(function(){
                    var param = {"criteria" : arguments[0], "requestProperties" : arguments[1]};
                    var event = @com.smartgwt.client.widgets.events.FetchDataEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                }))
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.onFetchData = $debox($entry(function(){
                var param = {"criteria" : arguments[0], "requestProperties" : arguments[1]};
                var event = @com.smartgwt.client.widgets.events.FetchDataEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            }));
        }
    }-*/;

}



