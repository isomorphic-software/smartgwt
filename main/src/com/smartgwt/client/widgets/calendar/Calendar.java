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
import com.smartgwt.logicalstructure.widgets.rte.*;
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;
import com.smartgwt.logicalstructure.widgets.tools.*;

/**
 * The Calendar component provides several different ways for a user to view and edit a set of events. Note that the {@link
 * com.smartgwt.client.docs.OptionalModules Calendar module} must be  loaded to make use of the Calendar class. <P>
 * <b>CalendarEvents</b> <P> Events are represented as ordinary JavaScript Objects (see {@link
 * com.smartgwt.client.widgets.calendar.CalendarEvent}).   The Calendar expects to be able to read and write a basic set of
 * properties  on events: name, startDate, endDate, description, etc, which can be stored  under configurable property
 * names (see eg {@link com.smartgwt.client.widgets.calendar.Calendar#getStartDateField startDateField}). <P> Much like a
 * {@link com.smartgwt.client.widgets.grid.ListGrid} manages it's ListGridRecords, the Calendar can  either be passed an
 * ordinary Array of CalendarEvents or can fetch data from a  DataSource. <P> If the calendar is bound to a DataSource,
 * event changes by user action or by  calling methods will be saved to the DataSource. <P> <b>Navigation</b> <P> The
 * calendar supports a number of views by default: {@link com.smartgwt.client.widgets.calendar.Calendar#getDayView day},
 * {@link com.smartgwt.client.widgets.calendar.Calendar#getWeekView week}, {@link
 * com.smartgwt.client.widgets.calendar.Calendar#getMonthView month} and  {@link
 * com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timeline}.  The user can navigate using back and forward 
 * buttons or via an attached {@link com.smartgwt.client.widgets.calendar.Calendar#getDateChooser DateChooser}. <P>
 * <b>Event Manipulation</b> <P> Events can be created by clicking directly onto one of the views, or via the  {@link
 * com.smartgwt.client.widgets.calendar.Calendar#getAddEventButton Add Event} button.  In the day, week and timeline views,
 * the user may  click and drag to create an event of a specific duration. <P> Creating an event via click or click and
 * drag pops up the {@link com.smartgwt.client.widgets.calendar.Calendar#getEventDialog EventDialog}, which provides a
 * simple form for  quick event entry (for normal events, only the description is required by default - for  events that
 * are shown in a {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes lane}, that field is also required). <P> A
 * separate editor called the {@link com.smartgwt.client.widgets.calendar.Calendar#getEventEditor EventEditor} provides  an
 * interface for editing all possible properties of an event, including custom  properties.  The EventEditor is used
 * whenever a pre-existing event is being  edited, and can also be invoked by the user wherever the simpler EventDialog
 * appears. <P> Events can also be programmatically {@link com.smartgwt.client.widgets.calendar.Calendar#addCalendarEvent
 * added}, {@link com.smartgwt.client.widgets.calendar.Calendar#removeEvent removed}, or {@link
 * com.smartgwt.client.widgets.calendar.Calendar#updateCalendarEvent updated}.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("Calendar")
public class Calendar extends Canvas implements DataBoundComponent, com.smartgwt.client.widgets.calendar.events.HasBackgroundClickHandlers, com.smartgwt.client.widgets.calendar.events.HasBackgroundMouseDownHandlers, com.smartgwt.client.widgets.calendar.events.HasCurrentViewChangedHandlers, com.smartgwt.client.widgets.calendar.events.HasDateChangedHandlers, com.smartgwt.client.widgets.calendar.events.HasDayBodyClickHandlers, com.smartgwt.client.widgets.calendar.events.HasDayHeaderClickHandlers, com.smartgwt.client.widgets.calendar.events.HasEventAddedHandlers, com.smartgwt.client.widgets.calendar.events.HasEventChangedHandlers, com.smartgwt.client.widgets.calendar.events.HasEventClickHandlers, com.smartgwt.client.widgets.calendar.events.HasEventMovedHandlers, com.smartgwt.client.widgets.calendar.events.HasEventRemoveClickHandlers, com.smartgwt.client.widgets.calendar.events.HasEventRemovedHandlers, com.smartgwt.client.widgets.calendar.events.HasEventRepositionMoveHandlers, com.smartgwt.client.widgets.calendar.events.HasEventRepositionStopHandlers, com.smartgwt.client.widgets.calendar.events.HasEventResizedHandlers, com.smartgwt.client.widgets.calendar.events.HasEventResizeMoveHandlers, com.smartgwt.client.widgets.calendar.events.HasEventResizeStopHandlers, com.smartgwt.client.widgets.calendar.events.HasEventHoverHTMLHandlers, com.smartgwt.client.widgets.calendar.events.HasTimelineEventMovedHandlers, com.smartgwt.client.widgets.calendar.events.HasTimelineEventResizedHandlers {

    public static Calendar getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new Calendar(jsObj);
        } else {
            assert refInstance instanceof Calendar;
            return (Calendar)refInstance;
        }
    }


    /**
     * Changes the defaults for Canvas AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults Canvas defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        $wnd.isc.Calendar.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
    }-*/;

    /**
     * Changes the defaults for FormItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults FormItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, FormItem defaults) /*-{
        $wnd.isc.Calendar.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;

    public Calendar(){
        checkCalendarLoaded();
				scClassName = "Calendar";
    }

    public Calendar(JavaScriptObject jsObj){
        scClassName = "Calendar";
        setJavaScriptObject(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
        var widget = $wnd.isc[scClassName].create(config);
        if ($wnd.isc.keepGlobals) this.@com.smartgwt.client.widgets.BaseWidget::internalSetID(Lcom/google/gwt/core/client/JavaScriptObject;)(widget);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * An {@link com.smartgwt.client.widgets.ImgButton} that appears in a Calendar's week/day/month views and offers an 
     * alternative way to create a new {@link com.smartgwt.client.widgets.calendar.CalendarEvent event}.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return ImgButton
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public ImgButton getAddEventButton() throws IllegalStateException {
        errorIfNotCreated("addEventButton");
        return (ImgButton)ImgButton.getByJSObject(getAttributeAsJavaScriptObject("addEventButton"));
    }

    /**
     * The text to be displayed when a user hovers over the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getAddEventButton add event} toolbar button
     *
     * @param addEventButtonHoverText  Default value is "Add an event"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAddEventButtonHoverText(String addEventButtonHoverText)  throws IllegalStateException {
        setAttribute("addEventButtonHoverText", addEventButtonHoverText, false);
    }

    /**
     * The text to be displayed when a user hovers over the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getAddEventButton add event} toolbar button
     *
     * @return String
     */
    public String getAddEventButtonHoverText()  {
        return getAttributeAsString("addEventButtonHoverText");
    }

    /**
     * When set to true, allows events to be managed by duration, as well as by end date.  Values can be set for {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getDuration duration} and  {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getDurationUnit duration unit} on each event, and are then
     * maintained, instead of the end date, when alterations are made to the event via editors or dragging  with the mouse.
     *
     * @param allowDurationEvents  Default value is null
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public void setAllowDurationEvents(Boolean allowDurationEvents) {
        setAttribute("allowDurationEvents", allowDurationEvents, true);
    }

    /**
     * When set to true, allows events to be managed by duration, as well as by end date.  Values can be set for {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getDuration duration} and  {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getDurationUnit duration unit} on each event, and are then
     * maintained, instead of the end date, when alterations are made to the event via editors or dragging  with the mouse.
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public Boolean getAllowDurationEvents()  {
        return getAttributeAsBoolean("allowDurationEvents");
    }

    /**
     * When showing a {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineView Timeline}, or a {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDayView day view} when  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes showDayLanes} is true, whether to make lane boundaries
     * more obvious by showing alternate lanes in a different color.
     *
     * @param alternateLaneStyles  Default value is null
     */
    public void setAlternateLaneStyles(Boolean alternateLaneStyles) {
        setAttribute("alternateLaneStyles", alternateLaneStyles, true);
    }

    /**
     * When showing a {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineView Timeline}, or a {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDayView day view} when  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes showDayLanes} is true, whether to make lane boundaries
     * more obvious by showing alternate lanes in a different color.
     *
     * @return Boolean
     */
    public Boolean getAlternateLaneStyles()  {
        return getAttributeAsBoolean("alternateLaneStyles");
    }

    /**
     * The base name for the CSS class applied to the grid cells of the day and week views of the calendar. This style will
     * have "Dark", "Over", "Selected", or "Disabled" appended to it according to the state of the cell.
     *
     * @param baseStyle  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is "calendar"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setBaseStyle(String baseStyle) {
        setAttribute("baseStyle", baseStyle, true);
    }

    /**
     * The base name for the CSS class applied to the grid cells of the day and week views of the calendar. This style will
     * have "Dark", "Over", "Selected", or "Disabled" appended to it according to the state of the cell.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getBaseStyle()  {
        return getAttributeAsString("baseStyle");
    }

    /**
     * The title for the cancel button in the event editor
     *
     * @param cancelButtonTitle  Default value is "Cancel"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCancelButtonTitle(String cancelButtonTitle)  throws IllegalStateException {
        setAttribute("cancelButtonTitle", cancelButtonTitle, false);
    }

    /**
     * The title for the cancel button in the event editor
     *
     * @return String
     */
    public String getCancelButtonTitle()  {
        return getAttributeAsString("cancelButtonTitle");
    }

    /**
     * If true, users can create new events.
     *
     * @param canCreateEvents  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCanCreateEvents(Boolean canCreateEvents)  throws IllegalStateException {
        setAttribute("canCreateEvents", canCreateEvents, false);
    }

    /**
     * If true, users can create new events.
     *
     * @return Boolean
     */
    public Boolean getCanCreateEvents()  {
        return getAttributeAsBoolean("canCreateEvents");
    }

    /**
     * If true, users can delete existing events. Defaults to {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanEditEvents canEditEvents}.
     *
     * @param canDeleteEvents  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @deprecated in favor of {@link com.smartgwt.client.widgets.calendar.Calendar#getCanRemoveEvents canRemoveEvents}
     */
    public void setCanDeleteEvents(Boolean canDeleteEvents)  throws IllegalStateException {
        setAttribute("canDeleteEvents", canDeleteEvents, false);
    }

    /**
     * If true, users can delete existing events. Defaults to {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanEditEvents canEditEvents}.
     *
     * @return Boolean
     * @deprecated in favor of {@link com.smartgwt.client.widgets.calendar.Calendar#getCanRemoveEvents canRemoveEvents}
     */
    public Boolean getCanDeleteEvents()  {
        return getAttributeAsBoolean("canDeleteEvents");
    }

    /**
     * Name of the field on each {@link com.smartgwt.client.widgets.calendar.CalendarEvent} that determines whether an {@link
     * com.smartgwt.client.widgets.calendar.EventCanvas} can be moved or resized by dragging with the mouse.  Note that  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanEditEvents canEditEvents} must be true for dragging to be allowed.
     *
     * @param canDragEventField  Default value is "canDrag"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public void setCanDragEventField(String canDragEventField)  throws IllegalStateException {
        setAttribute("canDragEventField", canDragEventField, false);
    }

    /**
     * Name of the field on each {@link com.smartgwt.client.widgets.calendar.CalendarEvent} that determines whether an {@link
     * com.smartgwt.client.widgets.calendar.EventCanvas} can be moved or resized by dragging with the mouse.  Note that  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanEditEvents canEditEvents} must be true for dragging to be allowed.
     *
     * @return String
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public String getCanDragEventField()  {
        return getAttributeAsString("canDragEventField");
    }

    /**
     * If true, users can drag-reposition existing events.  Only has an effect when  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanEditEvents canEditEvents} is true.
     *
     * @param canDragEvents  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCanDragEvents(Boolean canDragEvents)  throws IllegalStateException {
        setAttribute("canDragEvents", canDragEvents, false);
    }

    /**
     * If true, users can drag-reposition existing events.  Only has an effect when  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanEditEvents canEditEvents} is true.
     *
     * @return Boolean
     */
    public Boolean getCanDragEvents()  {
        return getAttributeAsBoolean("canDragEvents");
    }

    /**
     * If true, users can edit existing events.
     *
     * @param canEditEvents  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCanEditEvents(Boolean canEditEvents)  throws IllegalStateException {
        setAttribute("canEditEvents", canEditEvents, false);
    }

    /**
     * If true, users can edit existing events.
     *
     * @return Boolean
     */
    public Boolean getCanEditEvents()  {
        return getAttributeAsBoolean("canEditEvents");
    }

    /**
     * Name of the field on each {@link com.smartgwt.client.widgets.calendar.CalendarEvent} that determines whether it can be
     * edited in the {@link com.smartgwt.client.widgets.calendar.Calendar#getEventEditor event editor}.  Note that an event
     * with <code>canEdit</code>  set to true can also have {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanDragEventField canDrag} or {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanResizeEventField canResize} set to false,  which would still allow
     * editing, but not via drag operations.
     *
     * @param canEditField  Default value is "canEdit"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public void setCanEditField(String canEditField)  throws IllegalStateException {
        setAttribute("canEditField", canEditField, false);
    }

    /**
     * Name of the field on each {@link com.smartgwt.client.widgets.calendar.CalendarEvent} that determines whether it can be
     * edited in the {@link com.smartgwt.client.widgets.calendar.Calendar#getEventEditor event editor}.  Note that an event
     * with <code>canEdit</code>  set to true can also have {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanDragEventField canDrag} or {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanResizeEventField canResize} set to false,  which would still allow
     * editing, but not via drag operations.
     *
     * @return String
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public String getCanEditField()  {
        return getAttributeAsString("canEditField");
    }

    /**
     * Can events be moved between lanes?  If so, the event can be dragged to a different  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getLanes lane} and, when it's editor is shown, an additional drop-down
     * widget is  provided allowing the user to select a different lane. <P> In either case, the event's {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getLaneNameField laneNameField} is updated automatically. <P> This setting
     * can be overridden on each {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getCanEditLane event}.
     *
     * @param canEditLane  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCanEditLane(Boolean canEditLane)  throws IllegalStateException {
        setAttribute("canEditLane", canEditLane, false);
    }

    /**
     * Can events be moved between lanes?  If so, the event can be dragged to a different  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getLanes lane} and, when it's editor is shown, an additional drop-down
     * widget is  provided allowing the user to select a different lane. <P> In either case, the event's {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getLaneNameField laneNameField} is updated automatically. <P> This setting
     * can be overridden on each {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getCanEditLane event}.
     *
     * @return Boolean
     */
    public Boolean getCanEditLane()  {
        return getAttributeAsBoolean("canEditLane");
    }

    /**
     * Name of the field on each {@link com.smartgwt.client.widgets.calendar.CalendarEvent} that determines whether that event
     * can be  moved between lanes.
     *
     * @param canEditLaneField  Default value is "canEditLane"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public void setCanEditLaneField(String canEditLaneField)  throws IllegalStateException {
        setAttribute("canEditLaneField", canEditLaneField, false);
    }

    /**
     * Name of the field on each {@link com.smartgwt.client.widgets.calendar.CalendarEvent} that determines whether that event
     * can be  moved between lanes.
     *
     * @return String
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public String getCanEditLaneField()  {
        return getAttributeAsString("canEditLaneField");
    }

    /**
     * Can events be moved between sublanes? <P> If so, the event can be dragged to a different {@link
     * com.smartgwt.client.widgets.calendar.Lane#getSublanes sublane} within the same parent Lane and, when it's editor is
     * shown, an additional drop-down widget is provided  allowing the sublane to be altered. <P> If the sublane is locked, but
     * the {@link com.smartgwt.client.widgets.calendar.Calendar#getCanEditLane parent lane} isn't, an update to the event's
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getLaneNameField lane name} will be allowed, assuming that the new
     * Lane has an existing sublane with the same name. <P> In either case, the event's {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getSublaneNameField sublane} is updated  automatically. <P> This setting
     * can be overridden on each {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getCanEditSublane event}.
     *
     * @param canEditSublane  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCanEditSublane(Boolean canEditSublane)  throws IllegalStateException {
        setAttribute("canEditSublane", canEditSublane, false);
    }

    /**
     * Can events be moved between sublanes? <P> If so, the event can be dragged to a different {@link
     * com.smartgwt.client.widgets.calendar.Lane#getSublanes sublane} within the same parent Lane and, when it's editor is
     * shown, an additional drop-down widget is provided  allowing the sublane to be altered. <P> If the sublane is locked, but
     * the {@link com.smartgwt.client.widgets.calendar.Calendar#getCanEditLane parent lane} isn't, an update to the event's
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getLaneNameField lane name} will be allowed, assuming that the new
     * Lane has an existing sublane with the same name. <P> In either case, the event's {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getSublaneNameField sublane} is updated  automatically. <P> This setting
     * can be overridden on each {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getCanEditSublane event}.
     *
     * @return Boolean
     */
    public Boolean getCanEditSublane()  {
        return getAttributeAsBoolean("canEditSublane");
    }

    /**
     * Name of the field on each {@link com.smartgwt.client.widgets.calendar.CalendarEvent} that determines whether that event
     * can be  moved between individual {@link com.smartgwt.client.widgets.calendar.Lane#getSublanes sublanes} in a {@link
     * com.smartgwt.client.widgets.calendar.Lane}.
     *
     * @param canEditSublaneField  Default value is "canEditSublane"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public void setCanEditSublaneField(String canEditSublaneField)  throws IllegalStateException {
        setAttribute("canEditSublaneField", canEditSublaneField, false);
    }

    /**
     * Name of the field on each {@link com.smartgwt.client.widgets.calendar.CalendarEvent} that determines whether that event
     * can be  moved between individual {@link com.smartgwt.client.widgets.calendar.Lane#getSublanes sublanes} in a {@link
     * com.smartgwt.client.widgets.calendar.Lane}.
     *
     * @return String
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public String getCanEditSublaneField()  {
        return getAttributeAsString("canEditSublaneField");
    }

    /**
     * If true, allows the lanes in a Timeline to be grouped by providing a value for  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getLaneGroupByField laneGroupByField}.  The fields available for grouping
     * on  are those defined as {@link com.smartgwt.client.widgets.calendar.Calendar#getLaneFields lane fields}.  Since these
     * are definitions for {@link com.smartgwt.client.widgets.grid.ListGridField normal fields}, you can choose to {@link
     * com.smartgwt.client.widgets.grid.ListGridField#showIf hide} the field in the timeline, but still have it available for
     * grouping.
     *
     * @param canGroupLanes  Default value is null
     */
    public void setCanGroupLanes(Boolean canGroupLanes) {
        setAttribute("canGroupLanes", canGroupLanes, true);
    }

    /**
     * If true, allows the lanes in a Timeline to be grouped by providing a value for  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getLaneGroupByField laneGroupByField}.  The fields available for grouping
     * on  are those defined as {@link com.smartgwt.client.widgets.calendar.Calendar#getLaneFields lane fields}.  Since these
     * are definitions for {@link com.smartgwt.client.widgets.grid.ListGridField normal fields}, you can choose to {@link
     * com.smartgwt.client.widgets.grid.ListGridField#showIf hide} the field in the timeline, but still have it available for
     * grouping.
     *
     * @return Boolean
     */
    public Boolean getCanGroupLanes()  {
        return getAttributeAsBoolean("canGroupLanes");
    }

    /**
     * If true, users can remove existing events. Defaults to {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanEditEvents canEditEvents}.
     *
     * @param canRemoveEvents  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCanRemoveEvents(Boolean canRemoveEvents)  throws IllegalStateException {
        setAttribute("canRemoveEvents", canRemoveEvents, false);
    }

    /**
     * If true, users can remove existing events. Defaults to {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanEditEvents canEditEvents}.
     *
     * @return Boolean
     */
    public Boolean getCanRemoveEvents()  {
        return getAttributeAsBoolean("canRemoveEvents");
    }

    /**
     * Name of the field on each {@link com.smartgwt.client.widgets.calendar.CalendarEvent} that determines whether an event
     * shows a remove button.
     *
     * @param canRemoveField  Default value is "canRemove"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public void setCanRemoveField(String canRemoveField)  throws IllegalStateException {
        setAttribute("canRemoveField", canRemoveField, false);
    }

    /**
     * Name of the field on each {@link com.smartgwt.client.widgets.calendar.CalendarEvent} that determines whether an event
     * shows a remove button.
     *
     * @return String
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public String getCanRemoveField()  {
        return getAttributeAsString("canRemoveField");
    }

    /**
     * If true, lanes can be reordered by dragging them with the mouse.
     *
     * @param canReorderLanes  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCanReorderLanes(Boolean canReorderLanes)  throws IllegalStateException {
        setAttribute("canReorderLanes", canReorderLanes, false);
    }

    /**
     * If true, lanes can be reordered by dragging them with the mouse.
     *
     * @return Boolean
     */
    public Boolean getCanReorderLanes()  {
        return getAttributeAsBoolean("canReorderLanes");
    }

    /**
     * Name of the field on each {@link com.smartgwt.client.widgets.calendar.CalendarEvent} that determines whether an event
     * can be  resized by dragging.
     *
     * @param canResizeEventField  Default value is "canResize"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public void setCanResizeEventField(String canResizeEventField)  throws IllegalStateException {
        setAttribute("canResizeEventField", canResizeEventField, false);
    }

    /**
     * Name of the field on each {@link com.smartgwt.client.widgets.calendar.CalendarEvent} that determines whether an event
     * can be  resized by dragging.
     *
     * @return String
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public String getCanResizeEventField()  {
        return getAttributeAsString("canResizeEventField");
    }

    /**
     * Can {@link com.smartgwt.client.widgets.calendar.CalendarEvent events} be resized by dragging appropriate edges of the 
     * {@link com.smartgwt.client.widgets.calendar.EventCanvas#getVertical canvas}?  Only has an effect when both {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanEditEvents canEditEvents} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanDragEvents canDragEvents} are true.  Set this attribute to false to
     * disallow drag-resizing.
     *
     * @param canResizeEvents  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCanResizeEvents(Boolean canResizeEvents)  throws IllegalStateException {
        setAttribute("canResizeEvents", canResizeEvents, false);
    }

    /**
     * Can {@link com.smartgwt.client.widgets.calendar.CalendarEvent events} be resized by dragging appropriate edges of the 
     * {@link com.smartgwt.client.widgets.calendar.EventCanvas#getVertical canvas}?  Only has an effect when both {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanEditEvents canEditEvents} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanDragEvents canDragEvents} are true.  Set this attribute to false to
     * disallow drag-resizing.
     *
     * @return Boolean
     */
    public Boolean getCanResizeEvents()  {
        return getAttributeAsBoolean("canResizeEvents");
    }

    /**
     * Can {@link com.smartgwt.client.widgets.calendar.Timeline} events be stretched by their left and right edges?
     *
     * @param canResizeTimelineEvents  Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @deprecated in favor of {@link com.smartgwt.client.widgets.calendar.Calendar#getCanResizeEvents canResizeEvents};
     */
    public void setCanResizeTimelineEvents(Boolean canResizeTimelineEvents)  throws IllegalStateException {
        setAttribute("canResizeTimelineEvents", canResizeTimelineEvents, false);
    }

    /**
     * Can {@link com.smartgwt.client.widgets.calendar.Timeline} events be stretched by their left and right edges?
     *
     * @return Boolean
     * @deprecated in favor of {@link com.smartgwt.client.widgets.calendar.Calendar#getCanResizeEvents canResizeEvents};
     */
    public Boolean getCanResizeTimelineEvents()  {
        return getAttributeAsBoolean("canResizeTimelineEvents");
    }

    /**
     * The date for which events are displayed in the day, week, and month tabs of  the calendar.  Default is today.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the current date for which the calendar will display events.
     *
     * @param chosenDate the new date to set as the current date. Default value is 'Today'
     */
    public void setChosenDate(Date chosenDate) {
        setAttribute("chosenDate", chosenDate, true);
    }

    /**
     * The date for which events are displayed in the day, week, and month tabs of  the calendar.  Default is today.
     *
     * @return Date
     */
    public Date getChosenDate()  {
        return getAttributeAsDate("chosenDate");
    }

    /**
     * When using the Next and Previous arrows to scroll a Timeline, this is the number of columns  of the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineGranularity timelineGranularity} to scroll by.  With the
     * default value of null, the Timeline will scroll by its current length.
     *
     * @param columnsPerPage  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setColumnsPerPage(Integer columnsPerPage)  throws IllegalStateException {
        setAttribute("columnsPerPage", columnsPerPage, false);
    }

    /**
     * When using the Next and Previous arrows to scroll a Timeline, this is the number of columns  of the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineGranularity timelineGranularity} to scroll by.  With the
     * default value of null, the Timeline will scroll by its current length.
     *
     * @return Integer
     */
    public Integer getColumnsPerPage()  {
        return getAttributeAsInt("columnsPerPage");
    }

    /**
     * An {@link com.smartgwt.client.widgets.layout.HLayout HLayout} shown above the Calendar views and displaying a set of
     * controls for interacting with the current view - namely, the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getNextButton next}, {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getPreviousButton previous} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getAddEventButton add} buttons,  the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDateLabel date label} and the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDatePickerButton date-picker} icon.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return HLayout
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public HLayout getControlsBar() throws IllegalStateException {
        errorIfNotCreated("controlsBar");
        return (HLayout)HLayout.getByJSObject(getAttributeAsJavaScriptObject("controlsBar"));
    }

    /**
     * The name of the view that should be visible initially by default.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the currently visible view.
     *
     * @param currentViewName The name of the view that should be made visible.. Default value is null
     */
    public void setCurrentViewName(ViewName currentViewName) {
        setAttribute("currentViewName", currentViewName == null ? null : currentViewName.getValue(), true);
    }

    /**
     * The name of the view that should be visible initially by default.
     *
     * @return Get the name of the visible view.   Returns one of 'day', 'week', 'month' or 'timeline'.
     */
    public ViewName getCurrentViewName()  {
        return EnumUtil.getEnum(ViewName.values(), getAttribute("currentViewName"));
    }

    /**
     * A List of CalendarEvent objects, specifying the data to be used to populate the calendar.   <p> This property will
     * typically not be explicitly specified for databound Calendars, where the data is returned from the server via databound
     * component methods such as {@link com.smartgwt.client.widgets.calendar.Calendar#fetchData Calendar.fetchData}. In this
     * case the data objects will be set to a  {@link com.smartgwt.client.data.ResultSet resultSet} rather than a simple array.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Initialize the data object with the given array. Observes methods of the data object so that when the data changes, the calendar will redraw automatically.
     *
     * @param data data to show in the list. Default value is null
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public void setData(CalendarEvent[] data) {
        setAttribute("data", data, true);
    }

    /**
     * A List of CalendarEvent objects, specifying the data to be used to populate the calendar.   <p> This property will
     * typically not be explicitly specified for databound Calendars, where the data is returned from the server via databound
     * component methods such as {@link com.smartgwt.client.widgets.calendar.Calendar#fetchData Calendar.fetchData}. In this
     * case the data objects will be set to a  {@link com.smartgwt.client.data.ResultSet resultSet} rather than a simple array.
     *
     * @return CalendarEvent[]
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public CalendarEvent[] getData()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfCalendarEvent(getAttributeAsJavaScriptObject("data"));
    }

    /**
     * How to fetch and manage records retrieve from the server.  See {@link com.smartgwt.client.types.FetchMode}. <P> This
     * setting only applies to the {@link com.smartgwt.client.data.ResultSet} automatically created by calling {@link
     * com.smartgwt.client.widgets.grid.ListGrid#fetchData fetchData()}.  If a pre-existing ResultSet is passed to setData()
     * instead, it's existing setting for {@link com.smartgwt.client.data.ResultSet#getFetchMode fetchMode} applies.
     *
     * @param dataFetchMode  Default value is "paged"
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public void setDataFetchMode(FetchMode dataFetchMode) {
        setAttribute("dataFetchMode", dataFetchMode == null ? null : dataFetchMode.getValue(), true);
    }

    /**
     * How to fetch and manage records retrieve from the server.  See {@link com.smartgwt.client.types.FetchMode}. <P> This
     * setting only applies to the {@link com.smartgwt.client.data.ResultSet} automatically created by calling {@link
     * com.smartgwt.client.widgets.grid.ListGrid#fetchData fetchData()}.  If a pre-existing ResultSet is passed to setData()
     * instead, it's existing setting for {@link com.smartgwt.client.data.ResultSet#getFetchMode fetchMode} applies.
     *
     * @return FetchMode
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public FetchMode getDataFetchMode()  {
        return EnumUtil.getEnum(FetchMode.values(), getAttribute("dataFetchMode"));
    }

    /**
     * {@link com.smartgwt.client.widgets.DateChooser} used to select the date for which events will be displayed.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return DateChooser
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public DateChooser getDateChooser() throws IllegalStateException {
        errorIfNotCreated("dateChooser");
        return (DateChooser)DateChooser.getByJSObject(getAttributeAsJavaScriptObject("dateChooser"));
    }

    /**
     * Indicates the type of controls to use in event-windows.  Valid values are those in the  {@link
     * com.smartgwt.client.types.DateEditingStyle DateEditingStyle} type. <P> If unset, the editing style will be set to the
     * field-type on the DataSource, if there is one. If there's no DataSource, it will be set to "date" if the  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineGranularity granularity} is "day" or larger and "time" if
     * granularity  is "minute" or smaller, otherwise "datetime".
     *
     * @param dateEditingStyle  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDateEditingStyle(DateEditingStyle dateEditingStyle)  throws IllegalStateException {
        setAttribute("dateEditingStyle", dateEditingStyle == null ? null : dateEditingStyle.getValue(), false);
    }

    /**
     * Indicates the type of controls to use in event-windows.  Valid values are those in the  {@link
     * com.smartgwt.client.types.DateEditingStyle DateEditingStyle} type. <P> If unset, the editing style will be set to the
     * field-type on the DataSource, if there is one. If there's no DataSource, it will be set to "date" if the  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineGranularity granularity} is "day" or larger and "time" if
     * granularity  is "minute" or smaller, otherwise "datetime".
     *
     * @return DateEditingStyle
     */
    public DateEditingStyle getDateEditingStyle()  {
        return EnumUtil.getEnum(DateEditingStyle.values(), getAttribute("dateEditingStyle"));
    }

    /**
     * Date formatter for displaying events. Default is to use the system-wide default short date format, configured via {@link
     * com.smartgwt.client.util.Date#setShortDisplayFormat Date.setShortDisplayFormat}.  Specify any valid {@link
     * com.smartgwt.client.types.DateDisplayFormat}.
     *
     * @param dateFormatter  Default value is null
     */
    public void setDateFormatter(DateDisplayFormat dateFormatter) {
        setAttribute("dateFormatter", dateFormatter == null ? null : dateFormatter.getValue(), true);
    }

    /**
     * Date formatter for displaying events. Default is to use the system-wide default short date format, configured via {@link
     * com.smartgwt.client.util.Date#setShortDisplayFormat Date.setShortDisplayFormat}.  Specify any valid {@link
     * com.smartgwt.client.types.DateDisplayFormat}.
     *
     * @return DateDisplayFormat
     */
    public DateDisplayFormat getDateFormatter()  {
        return EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("dateFormatter"));
    }

    /**
     * The AutoChild {@link com.smartgwt.client.widgets.Label} used to display the current date or range above the  selected
     * calendar view.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Label
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Label getDateLabel() throws IllegalStateException {
        errorIfNotCreated("dateLabel");
        return (Label)Label.getByJSObject(getAttributeAsJavaScriptObject("dateLabel"));
    }

    /**
     * An {@link com.smartgwt.client.widgets.ImgButton ImgButton} that appears above the various views of the calendar and
     * offers alternative access to a {@link com.smartgwt.client.widgets.DateChooser} to pick the current day.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return ImgButton
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public ImgButton getDatePickerButton() throws IllegalStateException {
        errorIfNotCreated("datePickerButton");
        return (ImgButton)ImgButton.getByJSObject(getAttributeAsJavaScriptObject("datePickerButton"));
    }

    /**
     * The text to be displayed when a user hovers over the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDatePickerButton date picker} toolbar button
     *
     * @param datePickerHoverText  Default value is "Choose a date"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDatePickerHoverText(String datePickerHoverText)  throws IllegalStateException {
        setAttribute("datePickerHoverText", datePickerHoverText, false);
    }

    /**
     * The text to be displayed when a user hovers over the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDatePickerButton date picker} toolbar button
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
     * @param dayBodyBaseStyle  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is "calMonthDayBody"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setDayBodyBaseStyle(String dayBodyBaseStyle) {
        setAttribute("dayBodyBaseStyle", dayBodyBaseStyle, true);
    }

    /**
     * The base name for the CSS class applied to the day body of the month view of the calendar. This style will have "Dark",
     * "Over", "Selected", or "Disabled" appended to it according to the state of the cell.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getDayBodyBaseStyle()  {
        return getAttributeAsString("dayBodyBaseStyle");
    }

    /**
     * The base name for the CSS class applied to the day headers of the month view. This style will have "Dark", "Over",
     * "Selected", or "Disabled" appended to it according to the state of the cell.
     *
     * @param dayHeaderBaseStyle  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is "calMonthDayHeader"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setDayHeaderBaseStyle(String dayHeaderBaseStyle) {
        setAttribute("dayHeaderBaseStyle", dayHeaderBaseStyle, true);
    }

    /**
     * The base name for the CSS class applied to the day headers of the month view. This style will have "Dark", "Over",
     * "Selected", or "Disabled" appended to it according to the state of the cell.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getDayHeaderBaseStyle()  {
        return getAttributeAsString("dayHeaderBaseStyle");
    }

    /**
     * {@link com.smartgwt.client.widgets.calendar.CalendarView} used to display events that pertain to a given day.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return CalendarView
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public CalendarView getDayView() throws IllegalStateException {
        errorIfNotCreated("dayView");
        return (CalendarView)CalendarView.getByJSObject(getAttributeAsJavaScriptObject("dayView"));
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getDayView day view}.
     *
     * @param dayViewTitle  Default value is "Day"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDayViewTitle(String dayViewTitle)  throws IllegalStateException {
        setAttribute("dayViewTitle", dayViewTitle, false);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getDayView day view}.
     *
     * @return String
     */
    public String getDayViewTitle()  {
        return getAttributeAsString("dayViewTitle");
    }

    /**
     * The number of columns of the {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineGranularity
     * timelineGranularity} to give the timeline by default if no {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEndDate endDate} is provided.  The  default is 20.
     *
     * @param defaultTimelineColumnSpan  Default value is 20
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDefaultTimelineColumnSpan(int defaultTimelineColumnSpan)  throws IllegalStateException {
        setAttribute("defaultTimelineColumnSpan", defaultTimelineColumnSpan, false);
    }

    /**
     * The number of columns of the {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineGranularity
     * timelineGranularity} to give the timeline by default if no {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEndDate endDate} is provided.  The  default is 20.
     *
     * @return int
     */
    public int getDefaultTimelineColumnSpan()  {
        return getAttributeAsInt("defaultTimelineColumnSpan");
    }

    /**
     * The name of the description field on a {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.
     *
     * @param descriptionField  Default value is "description"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDescriptionField(String descriptionField)  throws IllegalStateException {
        setAttribute("descriptionField", descriptionField, false);
    }

    /**
     * The name of the description field on a {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.
     *
     * @return String
     */
    public String getDescriptionField()  {
        return getAttributeAsString("descriptionField");
    }

    /**
     * The title for the edit button in the quick event dialog
     *
     * @param detailsButtonTitle  Default value is "Edit Details"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDetailsButtonTitle(String detailsButtonTitle)  throws IllegalStateException {
        setAttribute("detailsButtonTitle", detailsButtonTitle, false);
    }

    /**
     * The title for the edit button in the quick event dialog
     *
     * @return String
     */
    public String getDetailsButtonTitle()  {
        return getAttributeAsString("detailsButtonTitle");
    }

    /**
     * If set, weekend days appear in a disabled style and events cannot be created on weekends. Which days are considered
     * weekends is controlled by {@link com.smartgwt.client.util.Date#weekendDays weekendDays}.
     *
     * @param disableWeekends  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public void setDisableWeekends(Boolean disableWeekends)  throws IllegalStateException {
        setAttribute("disableWeekends", disableWeekends, false);
    }

    /**
     * If set, weekend days appear in a disabled style and events cannot be created on weekends. Which days are considered
     * weekends is controlled by {@link com.smartgwt.client.util.Date#weekendDays weekendDays}.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public Boolean getDisableWeekends()  {
        return getAttributeAsBoolean("disableWeekends");
    }

    /**
     * The name of the {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getDuration duration} field on a {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent}.
     *
     * @param durationField  Default value is "duration"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public void setDurationField(String durationField)  throws IllegalStateException {
        setAttribute("durationField", durationField, false);
    }

    /**
     * The name of the {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getDuration duration} field on a {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent}.
     *
     * @return String
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public String getDurationField()  {
        return getAttributeAsString("durationField");
    }

    /**
     * The name of the {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getDurationUnit durationUnit} field on a 
     * {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.
     *
     * @param durationUnitField  Default value is "durationUnit"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public void setDurationUnitField(String durationUnitField)  throws IllegalStateException {
        setAttribute("durationUnitField", durationUnitField, false);
    }

    /**
     * The name of the {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getDurationUnit durationUnit} field on a 
     * {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.
     *
     * @return String
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public String getDurationUnitField()  {
        return getAttributeAsString("durationUnitField");
    }

    /**
     * The end date of the calendar timeline view.  Has no effect in other views. <P> To set different {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getStartDate start} and end dates after initial draw, see {@link
     * com.smartgwt.client.widgets.calendar.Calendar#setTimelineRange setTimelineRange}. <P> Note that this attribute may be
     * automatically altered if showing  {@link com.smartgwt.client.widgets.calendar.Calendar#getHeaderLevels header-levels},
     * to fit to header boundaries.
     *
     * @param endDate  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEndDate(Date endDate)  throws IllegalStateException {
        setAttribute("endDate", endDate, false);
    }

    /**
     * The end date of the calendar timeline view.  Has no effect in other views. <P> To set different {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getStartDate start} and end dates after initial draw, see {@link
     * com.smartgwt.client.widgets.calendar.Calendar#setTimelineRange setTimelineRange}. <P> Note that this attribute may be
     * automatically altered if showing  {@link com.smartgwt.client.widgets.calendar.Calendar#getHeaderLevels header-levels},
     * to fit to header boundaries.
     *
     * @return Date
     */
    public Date getEndDate()  {
        return getAttributeAsDate("endDate");
    }

    /**
     * The name of the end date field on a {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.
     *
     * @param endDateField  Default value is "endDate"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public void setEndDateField(String endDateField)  throws IllegalStateException {
        setAttribute("endDateField", endDateField, false);
    }

    /**
     * The name of the end date field on a {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.
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
     * @param eventAutoArrange  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEventAutoArrange(Boolean eventAutoArrange)  throws IllegalStateException {
        setAttribute("eventAutoArrange", eventAutoArrange, false);
    }

    /**
     * If set to true, enables the auto-arrangement of events that share time in the calendar.  The default is true.
     *
     * @return Boolean
     */
    public Boolean getEventAutoArrange()  {
        return getAttributeAsBoolean("eventAutoArrange");
    }

    /**
     * <b>Note :</b> This API is non-functional (always returns null) and exists only to make
     * you aware that this MultiAutoChild exists.  See {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}
     * for details.
     * <p>
     * To display events in {@link com.smartgwt.client.widgets.calendar.Calendar#getDayView day}, {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWeekView week} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timeline} views, the Calendar creates instances of  {@link
     * com.smartgwt.client.widgets.calendar.EventCanvas} for each event.  Use the AutoChild system to customize  these
     * canvases.
     *
     * @return null
     */
    public EventCanvas getEventCanvas()  {
        return null;
    }

    /**
     * HLayout that snaps to the top-right of an event canvas on rollover and contains the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventCanvasCloseButton close} and/or  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventCanvasContextButton context} buttons.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return HLayout
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public HLayout getEventCanvasButtonLayout() throws IllegalStateException {
        errorIfNotCreated("eventCanvasButtonLayout");
        return (HLayout)HLayout.getByJSObject(getAttributeAsJavaScriptObject("eventCanvasButtonLayout"));
    }

    /**
     * The close button that snaps to the top-right of an event canvas on rollover and allows an event to be removed from a
     * {@link com.smartgwt.client.widgets.calendar.CalendarView}.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return ImgButton
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public ImgButton getEventCanvasCloseButton() throws IllegalStateException {
        errorIfNotCreated("eventCanvasCloseButton");
        return (ImgButton)ImgButton.getByJSObject(getAttributeAsJavaScriptObject("eventCanvasCloseButton"));
    }

    /**
     * The context button that snaps to the top-right of an event canvas on rollover and shows a custom {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventCanvasMenuItems context menu} when clicked.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return ImgButton
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public ImgButton getEventCanvasContextButton() throws IllegalStateException {
        errorIfNotCreated("eventCanvasContextButton");
        return (ImgButton)ImgButton.getByJSObject(getAttributeAsJavaScriptObject("eventCanvasContextButton"));
    }

    /**
     * Context menu displayed when the rollover  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventCanvasContextButton context button} is clicked.  The context
     * button is only displayed if {@link com.smartgwt.client.widgets.calendar.Calendar#getEventCanvasMenuItems
     * getEventCanvasMenuItems} returns  an array of items to display in the context menu.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Menu
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Menu getEventCanvasContextMenu() throws IllegalStateException {
        errorIfNotCreated("eventCanvasContextMenu");
        return (Menu)Menu.getByJSObject(getAttributeAsJavaScriptObject("eventCanvasContextMenu"));
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getDescriptionField descriptionField} field in
     * the quick  {@link com.smartgwt.client.widgets.calendar.Calendar#getEventDialog event dialog} and the detailed  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor editor}.
     *
     * @param eventDescriptionFieldTitle  Default value is "Description"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEventDescriptionFieldTitle(String eventDescriptionFieldTitle)  throws IllegalStateException {
        setAttribute("eventDescriptionFieldTitle", eventDescriptionFieldTitle, false);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getDescriptionField descriptionField} field in
     * the quick  {@link com.smartgwt.client.widgets.calendar.Calendar#getEventDialog event dialog} and the detailed  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor editor}.
     *
     * @return String
     */
    public String getEventDescriptionFieldTitle()  {
        return getAttributeAsString("eventDescriptionFieldTitle");
    }

    /**
     * An AutoChild of type {@link com.smartgwt.client.widgets.Window} that displays a quick event entry form in a  popup
     * window.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Window
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Window getEventDialog() throws IllegalStateException {
        errorIfNotCreated("eventDialog");
        return (Window)Window.getByJSObject(getAttributeAsJavaScriptObject("eventDialog"));
    }

    /**
     * The number of pixels to leave to the right of events so overlapping events can still be  added using the mouse.
     *
     * @param eventDragGap  Default value is 10
     */
    public void setEventDragGap(Integer eventDragGap) {
        setAttribute("eventDragGap", eventDragGap, true);
    }

    /**
     * The number of pixels to leave to the right of events so overlapping events can still be  added using the mouse.
     *
     * @return Integer
     */
    public Integer getEventDragGap()  {
        return getAttributeAsInt("eventDragGap");
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getDurationField duration field} in the quick
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getEventDialog event dialog} and the detailed  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor editor}.
     *
     * @param eventDurationFieldTitle  Default value is "Duration"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEventDurationFieldTitle(String eventDurationFieldTitle)  throws IllegalStateException {
        setAttribute("eventDurationFieldTitle", eventDurationFieldTitle, false);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getDurationField duration field} in the quick
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getEventDialog event dialog} and the detailed  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor editor}.
     *
     * @return String
     */
    public String getEventDurationFieldTitle()  {
        return getAttributeAsString("eventDurationFieldTitle");
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getDurationUnitField duration unit field} in the
     * quick {@link com.smartgwt.client.widgets.calendar.Calendar#getEventDialog event dialog} and the detailed  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor editor}.
     *
     * @param eventDurationUnitFieldTitle  Default value is "&nbsp"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEventDurationUnitFieldTitle(String eventDurationUnitFieldTitle)  throws IllegalStateException {
        setAttribute("eventDurationUnitFieldTitle", eventDurationUnitFieldTitle, false);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getDurationUnitField duration unit field} in the
     * quick {@link com.smartgwt.client.widgets.calendar.Calendar#getEventDialog event dialog} and the detailed  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor editor}.
     *
     * @return String
     */
    public String getEventDurationUnitFieldTitle()  {
        return getAttributeAsString("eventDurationUnitFieldTitle");
    }

    /**
     * An AutoChild of type {@link com.smartgwt.client.widgets.form.DynamicForm} which displays {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent event data}.  This form is created within the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditorLayout event editor layout}
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return DynamicForm
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public DynamicForm getEventEditor() throws IllegalStateException {
        errorIfNotCreated("eventEditor");
        return (DynamicForm)DynamicForm.getByJSObject(getAttributeAsJavaScriptObject("eventEditor"));
    }

    /**
     * An AutoChild of type {@link com.smartgwt.client.widgets.Window} that displays the full  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor event editor}
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Window
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Window getEventEditorLayout() throws IllegalStateException {
        errorIfNotCreated("eventEditorLayout");
        return (Window)Window.getByJSObject(getAttributeAsJavaScriptObject("eventEditorLayout"));
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getEndDateField endDateField} in the quick {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventDialog event dialog} and the detailed  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor editor}.
     *
     * @param eventEndDateFieldTitle  Default value is "To"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEventEndDateFieldTitle(String eventEndDateFieldTitle)  throws IllegalStateException {
        setAttribute("eventEndDateFieldTitle", eventEndDateFieldTitle, false);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getEndDateField endDateField} in the quick {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventDialog event dialog} and the detailed  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor editor}.
     *
     * @return String
     */
    public String getEventEndDateFieldTitle()  {
        return getAttributeAsString("eventEndDateFieldTitle");
    }

    /**
     * When {@link com.smartgwt.client.widgets.calendar.Calendar#getEventHeaderWrap eventHeaderWrap} is false and  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowEventDescriptions showEventDescriptions} is true, this is the the
     * fixed  height for the {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowHeader header area} in event
     * canvases.
     *
     * @param eventHeaderHeight  Default value is 12
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEventHeaderHeight(int eventHeaderHeight)  throws IllegalStateException {
        setAttribute("eventHeaderHeight", eventHeaderHeight, false);
    }

    /**
     * When {@link com.smartgwt.client.widgets.calendar.Calendar#getEventHeaderWrap eventHeaderWrap} is false and  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowEventDescriptions showEventDescriptions} is true, this is the the
     * fixed  height for the {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowHeader header area} in event
     * canvases.
     *
     * @return int
     */
    public int getEventHeaderHeight()  {
        return getAttributeAsInt("eventHeaderHeight");
    }

    /**
     * When rendering the {@link com.smartgwt.client.widgets.calendar.Calendar#getEventCanvas canvas} for an event, whether to
     * allow the   content of the {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowHeader header area} to wrap to
     * multiple lines. <P> The default is true - if set to false, the header area is  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventHeaderHeight fixed}, unless {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowEventDescriptions showEventDescriptions} is false, in which case
     * the header area fills the canvas.
     *
     * @param eventHeaderWrap  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEventHeaderWrap(boolean eventHeaderWrap)  throws IllegalStateException {
        setAttribute("eventHeaderWrap", eventHeaderWrap, false);
    }

    /**
     * When rendering the {@link com.smartgwt.client.widgets.calendar.Calendar#getEventCanvas canvas} for an event, whether to
     * allow the   content of the {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowHeader header area} to wrap to
     * multiple lines. <P> The default is true - if set to false, the header area is  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventHeaderHeight fixed}, unless {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowEventDescriptions showEventDescriptions} is false, in which case
     * the header area fills the canvas.
     *
     * @return boolean
     */
    public boolean getEventHeaderWrap()  {
        return getAttributeAsBoolean("eventHeaderWrap");
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getLaneField laneField} field in the quick 
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getEventDialog event dialog} and the detailed  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor editor}.
     *
     * @param eventLaneFieldTitle  Default value is "Lane"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEventLaneFieldTitle(String eventLaneFieldTitle)  throws IllegalStateException {
        setAttribute("eventLaneFieldTitle", eventLaneFieldTitle, false);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getLaneField laneField} field in the quick 
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getEventDialog event dialog} and the detailed  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor editor}.
     *
     * @return String
     */
    public String getEventLaneFieldTitle()  {
        return getAttributeAsString("eventLaneFieldTitle");
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getNameField nameField} in the quick {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventDialog event dialog} and the detailed  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor editor}.
     *
     * @param eventNameFieldTitle  Default value is "Event Name"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEventNameFieldTitle(String eventNameFieldTitle)  throws IllegalStateException {
        setAttribute("eventNameFieldTitle", eventNameFieldTitle, false);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getNameField nameField} in the quick {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventDialog event dialog} and the detailed  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor editor}.
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
     * @param eventOverlap  Default value is true
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
     * @return Boolean
     */
    public Boolean getEventOverlap()  {
        return getAttributeAsBoolean("eventOverlap");
    }

    /**
     * When set to true, events that start at the same time will not overlap each other to prevent  events having their close
     * button hidden.
     *
     * @param eventOverlapIdenticalStartTimes  Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEventOverlapIdenticalStartTimes(Boolean eventOverlapIdenticalStartTimes)  throws IllegalStateException {
        setAttribute("eventOverlapIdenticalStartTimes", eventOverlapIdenticalStartTimes, false);
    }

    /**
     * When set to true, events that start at the same time will not overlap each other to prevent  events having their close
     * button hidden.
     *
     * @return Boolean
     */
    public Boolean getEventOverlapIdenticalStartTimes()  {
        return getAttributeAsBoolean("eventOverlapIdenticalStartTimes");
    }

    /**
     * The size of the overlap, presented as a percentage of the width of events sharing timeslots.
     *
     * @param eventOverlapPercent  Default value is 10
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEventOverlapPercent(int eventOverlapPercent)  throws IllegalStateException {
        setAttribute("eventOverlapPercent", eventOverlapPercent, false);
    }

    /**
     * The size of the overlap, presented as a percentage of the width of events sharing timeslots.
     *
     * @return int
     */
    public int getEventOverlapPercent()  {
        return getAttributeAsInt("eventOverlapPercent");
    }

    /**
     * In {@link com.smartgwt.client.widgets.calendar.Calendar#getDayView day} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWeekView week} views, determines the number of vertical  pixels by
     * which an event can be moved or resized when dragging.  The default of 20px means  that snapping occurs to each row
     * border, since the default height of each  {@link com.smartgwt.client.widgets.calendar.Calendar#getRowHeight row} in
     * those views is also 20px. <P> For timelines, this attribute affects the number of horizontal pixels used for
     * drag-snapping. Since the default width for {@link com.smartgwt.client.widgets.calendar.Calendar#getHeaderLevels
     * headerLevels} is 60px, the default eventSnapGap of 20px means that each column is split into 20 minute sections,
     * assuming that the  {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineGranularity timelineGranularity} is
     * "hour".
     *
     * @param eventSnapGap  Default value is 20
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public void setEventSnapGap(Integer eventSnapGap)  throws IllegalStateException {
        setAttribute("eventSnapGap", eventSnapGap, false);
    }

    /**
     * In {@link com.smartgwt.client.widgets.calendar.Calendar#getDayView day} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWeekView week} views, determines the number of vertical  pixels by
     * which an event can be moved or resized when dragging.  The default of 20px means  that snapping occurs to each row
     * border, since the default height of each  {@link com.smartgwt.client.widgets.calendar.Calendar#getRowHeight row} in
     * those views is also 20px. <P> For timelines, this attribute affects the number of horizontal pixels used for
     * drag-snapping. Since the default width for {@link com.smartgwt.client.widgets.calendar.Calendar#getHeaderLevels
     * headerLevels} is 60px, the default eventSnapGap of 20px means that each column is split into 20 minute sections,
     * assuming that the  {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineGranularity timelineGranularity} is
     * "hour".
     *
     * @return Integer
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public Integer getEventSnapGap()  {
        return getAttributeAsInt("eventSnapGap");
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getStartDateField startDateField} in the quick
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getEventDialog event dialog} and the detailed  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor editor}.
     *
     * @param eventStartDateFieldTitle  Default value is "From"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEventStartDateFieldTitle(String eventStartDateFieldTitle)  throws IllegalStateException {
        setAttribute("eventStartDateFieldTitle", eventStartDateFieldTitle, false);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getStartDateField startDateField} in the quick
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getEventDialog event dialog} and the detailed  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor editor}.
     *
     * @return String
     */
    public String getEventStartDateFieldTitle()  {
        return getAttributeAsString("eventStartDateFieldTitle");
    }

    /**
     * The base name for the CSS class applied to {@link com.smartgwt.client.widgets.calendar.Calendar#getEventCanvas events}
     * when they're rendered in calendar views. This style will have "Header" and "Body" appended to it, according to  which
     * part of the event window is being styled. For example, to style the header, define a CSS class called
     * 'eventWindowHeader'.
     *
     * @param eventStyleName  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is "eventWindow"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setEventStyleName(String eventStyleName) {
        setAttribute("eventStyleName", eventStyleName, true);
    }

    /**
     * The base name for the CSS class applied to {@link com.smartgwt.client.widgets.calendar.Calendar#getEventCanvas events}
     * when they're rendered in calendar views. This style will have "Header" and "Body" appended to it, according to  which
     * part of the event window is being styled. For example, to style the header, define a CSS class called
     * 'eventWindowHeader'.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getEventStyleName()  {
        return getAttributeAsString("eventStyleName");
    }

    /**
     * The name of the field used to override {@link com.smartgwt.client.widgets.calendar.Calendar#getEventStyleName
     * eventStyleName} for an individual {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getStyleName styleName}.
     *
     * @param eventStyleNameField  Default value is "styleName"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setEventStyleNameField(String eventStyleNameField)  throws IllegalStateException {
        setAttribute("eventStyleNameField", eventStyleNameField, false);
    }

    /**
     * The name of the field used to override {@link com.smartgwt.client.widgets.calendar.Calendar#getEventStyleName
     * eventStyleName} for an individual {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getStyleName styleName}.
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getEventStyleNameField()  {
        return getAttributeAsString("eventStyleNameField");
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getSublaneField sublane field} in the quick
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getEventDialog event dialog} and the detailed  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor event editor}.
     *
     * @param eventSublaneFieldTitle  Default value is "Sublane"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEventSublaneFieldTitle(String eventSublaneFieldTitle)  throws IllegalStateException {
        setAttribute("eventSublaneFieldTitle", eventSublaneFieldTitle, false);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getSublaneField sublane field} in the quick
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getEventDialog event dialog} and the detailed  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor event editor}.
     *
     * @return String
     */
    public String getEventSublaneFieldTitle()  {
        return getAttributeAsString("eventSublaneFieldTitle");
    }

    /**
     * To display events in day and week views, the Calendar creates instance of {@link
     * com.smartgwt.client.widgets.calendar.EventWindow} for each event.  Use the AutoChild system to customize these windows.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return EventWindow
     * @throws IllegalStateException if this widget has not yet been rendered.
     * @deprecated in favor of {@link com.smartgwt.client.widgets.calendar.Calendar#getEventCanvas eventCanvas}
     */
    public EventWindow getEventWindow() throws IllegalStateException {
        errorIfNotCreated("eventWindow");
        return (EventWindow)EventWindow.getByJSObject(getAttributeAsJavaScriptObject("eventWindow"));
    }

    /**
     * The base name for the CSS class applied to event windows within calendars. This style will have "Header", "HeaderLabel",
     * and "Body" appended to it, according to  which part of the event window is being styled. For example, to style the
     * header, define a CSS class called 'eventWindowHeader'.
     *
     * @param eventWindowStyle  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     * @deprecated in favor of {@link com.smartgwt.client.widgets.calendar.Calendar#getEventStyleName eventStyleName}
     */
    public void setEventWindowStyle(String eventWindowStyle) {
        setAttribute("eventWindowStyle", eventWindowStyle, true);
    }

    /**
     * The base name for the CSS class applied to event windows within calendars. This style will have "Header", "HeaderLabel",
     * and "Body" appended to it, according to  which part of the event window is being styled. For example, to style the
     * header, define a CSS class called 'eventWindowHeader'.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     * @deprecated in favor of {@link com.smartgwt.client.widgets.calendar.Calendar#getEventStyleName eventStyleName}
     */
    public String getEventWindowStyle()  {
        return getAttributeAsString("eventWindowStyle");
    }

    /**
     * The name of the field used to override {@link com.smartgwt.client.widgets.calendar.Calendar#getEventWindowStyle
     * eventWindowStyle} for an individual {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.  See {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getEventWindowStyle eventWindowStyle}.
     *
     * @param eventWindowStyleField  Default value is "eventWindowStyle"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     * @deprecated in favor of {@link com.smartgwt.client.widgets.calendar.Calendar#getEventStyleNameField eventStyleNameField}
     */
    public void setEventWindowStyleField(String eventWindowStyleField)  throws IllegalStateException {
        setAttribute("eventWindowStyleField", eventWindowStyleField, false);
    }

    /**
     * The name of the field used to override {@link com.smartgwt.client.widgets.calendar.Calendar#getEventWindowStyle
     * eventWindowStyle} for an individual {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.  See {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getEventWindowStyle eventWindowStyle}.
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     * @deprecated in favor of {@link com.smartgwt.client.widgets.calendar.Calendar#getEventStyleNameField eventStyleNameField}
     */
    public String getEventWindowStyleField()  {
        return getAttributeAsString("eventWindowStyleField");
    }

    /**
     * The numeric day (0-6) which the calendar should consider as the first day of the week - if unset, the default is taken
     * from the current locale.
     *
     * @param firstDayOfWeek  Default value is null
     */
    public void setFirstDayOfWeek(Integer firstDayOfWeek) {
        setAttribute("firstDayOfWeek", firstDayOfWeek, true);
    }

    /**
     * The numeric day (0-6) which the calendar should consider as the first day of the week - if unset, the default is taken
     * from the current locale.
     *
     * @return Integer
     */
    public Integer getFirstDayOfWeek()  {
        return getAttributeAsInt("firstDayOfWeek");
    }

    /**
     * Configures the levels of {@link com.smartgwt.client.widgets.calendar.HeaderLevel headers} shown above the event area,
     * and  their time units. <P> Header levels are provided from the top down, so the first header level should be the largest
     *  time unit and the last one the smallest.  The smallest is then used for the actual  field-headers.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * For {@link com.smartgwt.client.widgets.calendar.Timeline}s, configures the levels of {@link com.smartgwt.client.widgets.calendar.HeaderLevel headers} shown above the  event area, and their time units, after initialization.
     *
     * @param headerLevels the array of HeaderLevels to set. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setHeaderLevels(HeaderLevel... headerLevels)  throws IllegalStateException {
        setAttribute("headerLevels", headerLevels, false);
    }

    /**
     * Configures the levels of {@link com.smartgwt.client.widgets.calendar.HeaderLevel headers} shown above the event area,
     * and  their time units. <P> Header levels are provided from the top down, so the first header level should be the largest
     *  time unit and the last one the smallest.  The smallest is then used for the actual  field-headers.
     *
     * @return HeaderLevel...
     */
    public HeaderLevel[] getHeaderLevels()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfHeaderLevel(getAttributeAsJavaScriptObject("headerLevels"));
    }

    /**
     * When set to true, hides any {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes lane} that doesn't have any
     * active events in the current dataset.
     *
     * @param hideUnusedLanes  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setHideUnusedLanes(Boolean hideUnusedLanes)  throws IllegalStateException {
        setAttribute("hideUnusedLanes", hideUnusedLanes, false);
    }

    /**
     * When set to true, hides any {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes lane} that doesn't have any
     * active events in the current dataset.
     *
     * @return Boolean
     */
    public Boolean getHideUnusedLanes()  {
        return getAttributeAsBoolean("hideUnusedLanes");
    }

    /**
     * <b>Note :</b> This API is non-functional (always returns null) and exists only to make
     * you aware that this MultiAutoChild exists.  See {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}
     * for details.
     * <p>
     * AutoChild component created for each {@link com.smartgwt.client.widgets.calendar.Calendar#getIndicators indicator}
     * entry.
     *
     * @return null
     */
    public IndicatorCanvas getIndicatorCanvas()  {
        return null;
    }

    /**
     * An array of CalendarEvent instances representing instants in time, to be  highlighted in {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timeline views}.  Each indicator renders out as  an {@link
     * com.smartgwt.client.widgets.calendar.IndicatorCanvas indicator canvas}, a special, non-interactive subclass of  {@link
     * com.smartgwt.client.widgets.calendar.EventCanvas}, which spans all lanes and draws behind any normal, interactive 
     * events in the zorder, but in front of any {@link com.smartgwt.client.widgets.calendar.Calendar#getZones zones}.  The
     * default  {@link com.smartgwt.client.widgets.calendar.Calendar#getIndicatorStyleName style} for these components renders
     * them as thin vertical lines that span all lanes and have a hover but no title.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.calendar.Calendar#getIndicators indicators} used to highlight instants in time.
     *
     * @param indicators array of indicators to display. Default value is null
     */
    public void setIndicators(CalendarEvent... indicators) {
        setAttribute("indicators", indicators, true);
    }

    /**
     * An array of CalendarEvent instances representing instants in time, to be  highlighted in {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timeline views}.  Each indicator renders out as  an {@link
     * com.smartgwt.client.widgets.calendar.IndicatorCanvas indicator canvas}, a special, non-interactive subclass of  {@link
     * com.smartgwt.client.widgets.calendar.EventCanvas}, which spans all lanes and draws behind any normal, interactive 
     * events in the zorder, but in front of any {@link com.smartgwt.client.widgets.calendar.Calendar#getZones zones}.  The
     * default  {@link com.smartgwt.client.widgets.calendar.Calendar#getIndicatorStyleName style} for these components renders
     * them as thin vertical lines that span all lanes and have a hover but no title.
     *
     * @return CalendarEvent...
     */
    public CalendarEvent[] getIndicators()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfCalendarEvent(getAttributeAsJavaScriptObject("indicators"));
    }

    /**
     * CSS style to apply to the {@link com.smartgwt.client.widgets.calendar.Calendar#getIndicatorCanvas canvases} created for
     * each specified {@link com.smartgwt.client.widgets.calendar.Calendar#getIndicators indicator}.
     *
     * @param indicatorStyleName  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is "indicatorCanvas"
     */
    public void setIndicatorStyleName(String indicatorStyleName) {
        setAttribute("indicatorStyleName", indicatorStyleName, true);
    }

    /**
     * CSS style to apply to the {@link com.smartgwt.client.widgets.calendar.Calendar#getIndicatorCanvas canvases} created for
     * each specified {@link com.smartgwt.client.widgets.calendar.Calendar#getIndicators indicator}.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     */
    public String getIndicatorStyleName()  {
        return getAttributeAsString("indicatorStyleName");
    }

    /**
     * The message to display in the {@link com.smartgwt.client.widgets.calendar.Calendar#getEventEditor eventEditor} when the
     * 'To' date is greater than the 'From' date and a save is attempted.
     *
     * @param invalidDateMessage  Default value is "From must be before To"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setInvalidDateMessage(Boolean invalidDateMessage)  throws IllegalStateException {
        setAttribute("invalidDateMessage", invalidDateMessage, false);
    }

    /**
     * The message to display in the {@link com.smartgwt.client.widgets.calendar.Calendar#getEventEditor eventEditor} when the
     * 'To' date is greater than the 'From' date and a save is attempted.
     *
     * @return Boolean
     */
    public Boolean getInvalidDateMessage()  {
        return getAttributeAsBoolean("invalidDateMessage");
    }

    /**
     * The pixel space to leave between events and the edges of the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getLanes lane} or  {@link
     * com.smartgwt.client.widgets.calendar.Lane#getSublanes sublane} they appear in.  Only applicable to  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timelines}, has no effect in other views.
     *
     * @param laneEventPadding  Default value is 0
     */
    public void setLaneEventPadding(Integer laneEventPadding) {
        setAttribute("laneEventPadding", laneEventPadding, true);
    }

    /**
     * The pixel space to leave between events and the edges of the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getLanes lane} or  {@link
     * com.smartgwt.client.widgets.calendar.Lane#getSublanes sublane} they appear in.  Only applicable to  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timelines}, has no effect in other views.
     *
     * @return Integer
     */
    public Integer getLaneEventPadding()  {
        return getAttributeAsInt("laneEventPadding");
    }

    /**
     * Field definitions for the frozen area of the {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineView
     * timelineView}, which shows data about the timeline {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes lanes}.
     * Each field shows one attribute of the objects provided as {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes
     * lanes}. <P> When {@link com.smartgwt.client.widgets.calendar.Calendar#getCanGroupLanes lane grouping} is enabled, only
     * fields that are specified as lane fields can be used as group fields.
     *
     * @param laneFields  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setLaneFields(ListGridField... laneFields)  throws IllegalStateException {
        setAttribute("laneFields", laneFields, false);
    }

    /**
     * Field definitions for the frozen area of the {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineView
     * timelineView}, which shows data about the timeline {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes lanes}.
     * Each field shows one attribute of the objects provided as {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes
     * lanes}. <P> When {@link com.smartgwt.client.widgets.calendar.Calendar#getCanGroupLanes lane grouping} is enabled, only
     * fields that are specified as lane fields can be used as group fields.
     *
     * @return ListGridField...
     */
    public ListGridField[] getLaneFields()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfListGridField(getAttributeAsJavaScriptObject("laneFields"));
    }

    /**
     * For timelines with {@link com.smartgwt.client.widgets.calendar.Calendar#getCanGroupLanes canGroupLanes} set to true,
     * this is a  field name or array of field names on which to group the lanes in a timeline.
     *
     * @param laneGroupByField  Default value is null
     */
    public void setLaneGroupByField(String laneGroupByField) {
        setAttribute("laneGroupByField", laneGroupByField, true);
    }

    /**
     * For timelines with {@link com.smartgwt.client.widgets.calendar.Calendar#getCanGroupLanes canGroupLanes} set to true,
     * this is a  field name or array of field names on which to group the lanes in a timeline.
     *
     * @return String
     */
    public String getLaneGroupByField()  {
        return getAttributeAsString("laneGroupByField");
    }

    /**
     * For timelines with {@link com.smartgwt.client.widgets.calendar.Calendar#getCanGroupLanes canGroupLanes} set to true,
     * this is a  field name or array of field names on which to group the lanes in a timeline.
     *
     * @param laneGroupByField  Default value is null
     */
    public void setLaneGroupByField(String... laneGroupByField) {
        setAttribute("laneGroupByField", laneGroupByField, true);
    }

    /**
     * For timelines with {@link com.smartgwt.client.widgets.calendar.Calendar#getCanGroupLanes canGroupLanes} set to true,
     * this is a  field name or array of field names on which to group the lanes in a timeline.
     *
     * @return String...
     */
    public String[] getLaneGroupByFieldAsString()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("laneGroupByField"));
    }

    /**
     * The name of the field which will determine the {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes lane} in
     * which this  event will be displayed in {@link com.smartgwt.client.widgets.calendar.Timeline}s and in the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDayView day view}, if  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes showDayLanes} is true.
     *
     * @param laneNameField  Default value is "lane"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public void setLaneNameField(String laneNameField)  throws IllegalStateException {
        setAttribute("laneNameField", laneNameField, false);
    }

    /**
     * The name of the field which will determine the {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes lane} in
     * which this  event will be displayed in {@link com.smartgwt.client.widgets.calendar.Timeline}s and in the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDayView day view}, if  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes showDayLanes} is true.
     *
     * @return String
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public String getLaneNameField()  {
        return getAttributeAsString("laneNameField");
    }

    /**
     * An array of {@link com.smartgwt.client.widgets.calendar.Lane} definitions that represent the rows of the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timelineView}, or the columns of the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDayView dayView} if {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes showDayLanes} is true.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes lanes} in the current calendar view.  Only has an effect in {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timeline views}, and in {@link com.smartgwt.client.widgets.calendar.Calendar#getDayView day views} when  {@link com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes showDayLanes} is true.
     *
     * @param lanes array of lanes to display. Default value is null
     */
    public void setLanes(Lane... lanes) {
        setAttribute("lanes", lanes, true);
    }

    /**
     * An array of {@link com.smartgwt.client.widgets.calendar.Lane} definitions that represent the rows of the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timelineView}, or the columns of the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDayView dayView} if {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes showDayLanes} is true.
     *
     * @return Lane...
     */
    public Lane[] getLanes()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfLane(getAttributeAsJavaScriptObject("lanes"));
    }

    /**
     * The name of the leading date field for each event.  When this attribute and  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTrailingDateField trailingDateField} are present in the data, a line
     * extends out from the event showing the extent of the leading and trailing dates - useful for visualizing a pipeline of
     * events  where some can be moved a certain amount without affecting others.
     *
     * @param leadingDateField  Default value is "leadingDate"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public void setLeadingDateField(String leadingDateField)  throws IllegalStateException {
        setAttribute("leadingDateField", leadingDateField, false);
    }

    /**
     * The name of the leading date field for each event.  When this attribute and  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTrailingDateField trailingDateField} are present in the data, a line
     * extends out from the event showing the extent of the leading and trailing dates - useful for visualizing a pipeline of
     * events  where some can be moved a certain amount without affecting others.
     *
     * @return String
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public String getLeadingDateField()  {
        return getAttributeAsString("leadingDateField");
    }

    /**
     * {@link com.smartgwt.client.widgets.tab.TabSet} for managing calendar views when multiple views are available (eg, {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDayView day} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getMonthView month}).
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return TabSet
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public TabSet getMainView() throws IllegalStateException {
        errorIfNotCreated("mainView");
        return (TabSet)TabSet.getByJSObject(getAttributeAsJavaScriptObject("mainView"));
    }

    /**
     * In the {@link com.smartgwt.client.widgets.calendar.Calendar#getMonthView month view} when {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowDayHeaders showDayHeaders} is true, this is the minimum height
     * applied to a day cell and its header combined. <P> If <code>showDayHeaders</code> is false, this attribute has no effect
     * - the minimum height  of day cells is either an equal share of the available height, or the rendered height of the
     * cell's HTML content, whichever is greater.  If the latter, a vertical scrollbar is shown.
     *
     * @param minimumDayHeight  Default value is 80
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setMinimumDayHeight(Integer minimumDayHeight) {
        setAttribute("minimumDayHeight", minimumDayHeight, true);
    }

    /**
     * In the {@link com.smartgwt.client.widgets.calendar.Calendar#getMonthView month view} when {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowDayHeaders showDayHeaders} is true, this is the minimum height
     * applied to a day cell and its header combined. <P> If <code>showDayHeaders</code> is false, this attribute has no effect
     * - the minimum height  of day cells is either an equal share of the available height, or the rendered height of the
     * cell's HTML content, whichever is greater.  If the latter, a vertical scrollbar is shown.
     *
     * @return Integer
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Integer getMinimumDayHeight()  {
        return getAttributeAsInt("minimumDayHeight");
    }

    /**
     * When showing {@link com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes vertical lanes} in the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDayView dayView}, this attribute sets  the minimum width of each column
     * or field.
     *
     * @param minLaneWidth  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setMinLaneWidth(Integer minLaneWidth)  throws IllegalStateException {
        setAttribute("minLaneWidth", minLaneWidth, false);
    }

    /**
     * When showing {@link com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes vertical lanes} in the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDayView dayView}, this attribute sets  the minimum width of each column
     * or field.
     *
     * @return Integer
     */
    public Integer getMinLaneWidth()  {
        return getAttributeAsInt("minLaneWidth");
    }

    /**
     * {@link com.smartgwt.client.widgets.calendar.CalendarView} used to display events that pertain to a given month.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return CalendarView
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public CalendarView getMonthView() throws IllegalStateException {
        errorIfNotCreated("monthView");
        return (CalendarView)CalendarView.getByJSObject(getAttributeAsJavaScriptObject("monthView"));
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getMonthView month view}.
     *
     * @param monthViewTitle  Default value is "Month"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setMonthViewTitle(String monthViewTitle)  throws IllegalStateException {
        setAttribute("monthViewTitle", monthViewTitle, false);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getMonthView month view}.
     *
     * @return String
     */
    public String getMonthViewTitle()  {
        return getAttributeAsString("monthViewTitle");
    }

    /**
     * The name of the name field on a {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.
     *
     * @param nameField  Default value is "name"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public void setNameField(String nameField)  throws IllegalStateException {
        setAttribute("nameField", nameField, false);
    }

    /**
     * The name of the name field on a {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.
     *
     * @return String
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public String getNameField()  {
        return getAttributeAsString("nameField");
    }

    /**
     * An {@link com.smartgwt.client.widgets.ImgButton} that appears above the week/day/month views of the calendar and allows
     * the user to move the calendar forwards in time.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return ImgButton
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public ImgButton getNextButton() throws IllegalStateException {
        errorIfNotCreated("nextButton");
        return (ImgButton)ImgButton.getByJSObject(getAttributeAsJavaScriptObject("nextButton"));
    }

    /**
     * The text to be displayed when a user hovers over the {@link com.smartgwt.client.widgets.calendar.Calendar#getNextButton
     * next}  toolbar button
     *
     * @param nextButtonHoverText  Default value is "Next"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setNextButtonHoverText(String nextButtonHoverText)  throws IllegalStateException {
        setAttribute("nextButtonHoverText", nextButtonHoverText, false);
    }

    /**
     * The text to be displayed when a user hovers over the {@link com.smartgwt.client.widgets.calendar.Calendar#getNextButton
     * next}  toolbar button
     *
     * @return String
     */
    public String getNextButtonHoverText()  {
        return getAttributeAsString("nextButtonHoverText");
    }

    /**
     * The CSS style applied to both the header and body of days from other months in the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getMonthView month view}, when {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowOtherDays showOtherDays} is false.
     *
     * @param otherDayBlankStyle  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is "calMonthOtherDayBlank"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setOtherDayBlankStyle(String otherDayBlankStyle)  throws IllegalStateException {
        setAttribute("otherDayBlankStyle", otherDayBlankStyle, false);
    }

    /**
     * The CSS style applied to both the header and body of days from other months in the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getMonthView month view}, when {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowOtherDays showOtherDays} is false.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getOtherDayBlankStyle()  {
        return getAttributeAsString("otherDayBlankStyle");
    }

    /**
     * The base name for the CSS class applied to the day body of the month view of the calendar. This style will have "Dark",
     * "Over", "Selected", or "Disabled" appended to it according to the state of the cell.
     *
     * @param otherDayBodyBaseStyle  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is "calMonthDayBody"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setOtherDayBodyBaseStyle(String otherDayBodyBaseStyle) {
        setAttribute("otherDayBodyBaseStyle", otherDayBodyBaseStyle, true);
    }

    /**
     * The base name for the CSS class applied to the day body of the month view of the calendar. This style will have "Dark",
     * "Over", "Selected", or "Disabled" appended to it according to the state of the cell.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getOtherDayBodyBaseStyle()  {
        return getAttributeAsString("otherDayBodyBaseStyle");
    }

    /**
     * The base name for the CSS class applied to the day headers of the month view. This style will have "Dark", "Over",
     * "Selected", or "Disabled" appended to it according to the state of the cell.
     *
     * @param otherDayHeaderBaseStyle  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is "calMonthDayHeader"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setOtherDayHeaderBaseStyle(String otherDayHeaderBaseStyle) {
        setAttribute("otherDayHeaderBaseStyle", otherDayHeaderBaseStyle, true);
    }

    /**
     * The base name for the CSS class applied to the day headers of the month view. This style will have "Dark", "Over",
     * "Selected", or "Disabled" appended to it according to the state of the cell.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getOtherDayHeaderBaseStyle()  {
        return getAttributeAsString("otherDayHeaderBaseStyle");
    }

    /**
     * For {@link com.smartgwt.client.widgets.calendar.Timeline timelines} that allow overlapping events, an array of  {@link
     * com.smartgwt.client.data.SortSpecifier sort-specifiers} that dictate the vertical rendering order of  overlapped events
     * in each {@link com.smartgwt.client.widgets.calendar.Lane lane}. <P> By default, events that share space in a Lane are
     * rendered from top to bottom according to  their {@link com.smartgwt.client.widgets.calendar.Calendar#getStartDateField
     * start-dates} - the earliest in a given lane appears top-most in  that lane. <P> Providing
     * <code>overlapSortSpecifiers</code> allows for the events to be ordered by one or more of the fields stored on the
     * events, or in the underlying {@link com.smartgwt.client.data.DataSource data-source}, if the timeline is databound.
     *
     * @param overlapSortSpecifiers  Default value is null
     */
    public void setOverlapSortSpecifiers(SortSpecifier... overlapSortSpecifiers) {
        setAttribute("overlapSortSpecifiers", overlapSortSpecifiers, true);
    }

    /**
     * For {@link com.smartgwt.client.widgets.calendar.Timeline timelines} that allow overlapping events, an array of  {@link
     * com.smartgwt.client.data.SortSpecifier sort-specifiers} that dictate the vertical rendering order of  overlapped events
     * in each {@link com.smartgwt.client.widgets.calendar.Lane lane}. <P> By default, events that share space in a Lane are
     * rendered from top to bottom according to  their {@link com.smartgwt.client.widgets.calendar.Calendar#getStartDateField
     * start-dates} - the earliest in a given lane appears top-most in  that lane. <P> Providing
     * <code>overlapSortSpecifiers</code> allows for the events to be ordered by one or more of the fields stored on the
     * events, or in the underlying {@link com.smartgwt.client.data.DataSource data-source}, if the timeline is databound.
     *
     * @return SortSpecifier...
     */
    public SortSpecifier[] getOverlapSortSpecifiers()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfSortSpecifier(getAttributeAsJavaScriptObject("overlapSortSpecifiers"));
    }

    /**
     * An {@link com.smartgwt.client.widgets.ImgButton} that appears above the week/day/month views of the calendar and allows
     * the user to move the calendar backwards in time.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return ImgButton
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public ImgButton getPreviousButton() throws IllegalStateException {
        errorIfNotCreated("previousButton");
        return (ImgButton)ImgButton.getByJSObject(getAttributeAsJavaScriptObject("previousButton"));
    }

    /**
     * The text to be displayed when a user hovers over the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getPreviousButton previous} toolbar button.
     *
     * @param previousButtonHoverText  Default value is "Previous"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setPreviousButtonHoverText(String previousButtonHoverText)  throws IllegalStateException {
        setAttribute("previousButtonHoverText", previousButtonHoverText, false);
    }

    /**
     * The text to be displayed when a user hovers over the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getPreviousButton previous} toolbar button.
     *
     * @return String
     */
    public String getPreviousButtonHoverText()  {
        return getAttributeAsString("previousButtonHoverText");
    }

    /**
     * The height of time-slots in the calendar.
     *
     * @param rowHeight  Default value is 20
     */
    public void setRowHeight(int rowHeight) {
        setAttribute("rowHeight", rowHeight, true);
    }

    /**
     * The height of time-slots in the calendar.
     *
     * @return int
     */
    public int getRowHeight()  {
        return getAttributeAsInt("rowHeight");
    }

    /**
     * The title for the save button in the quick event dialog and the event editor
     *
     * @param saveButtonTitle  Default value is "Save Event"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSaveButtonTitle(String saveButtonTitle)  throws IllegalStateException {
        setAttribute("saveButtonTitle", saveButtonTitle, false);
    }

    /**
     * The title for the save button in the quick event dialog and the event editor
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
     * @param scrollToWorkday  Default value is false
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
     * @return Boolean
     */
    public Boolean getScrollToWorkday()  {
        return getAttributeAsBoolean("scrollToWorkday");
    }

    /**
     * The base name for the CSS class applied to a cell that is selected via a mouse drag.
     *
     * @param selectedCellStyle  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is "calendarCellSelected"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setSelectedCellStyle(String selectedCellStyle) {
        setAttribute("selectedCellStyle", selectedCellStyle, true);
    }

    /**
     * The base name for the CSS class applied to a cell that is selected via a mouse drag.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getSelectedCellStyle()  {
        return getAttributeAsString("selectedCellStyle");
    }

    /**
     * Set to false to hide the {@link com.smartgwt.client.widgets.calendar.Calendar#getAddEventButton Add Event} button.
     *
     * @param showAddEventButton  Default value is null
     */
    public void setShowAddEventButton(Boolean showAddEventButton) {
        setAttribute("showAddEventButton", showAddEventButton, true);
    }

    /**
     * Set to false to hide the {@link com.smartgwt.client.widgets.calendar.Calendar#getAddEventButton Add Event} button.
     *
     * @return Boolean
     */
    public Boolean getShowAddEventButton()  {
        return getAttributeAsBoolean("showAddEventButton");
    }

    /**
     * If false the controls bar at the top of the calendar will not be displayed - this means  that the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getControlsBar controlsBar} will be hidden, so the autoChildren ({@link
     * com.smartgwt.client.widgets.calendar.Calendar#getPreviousButton previousButton},  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDateLabel dateLabel}, {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getNextButton nextButton}, {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getAddEventButton addEventButton}, and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDatePickerButton datePickerButton})  will not be created or shown.
     *
     * @param showControlsBar  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowControlsBar(Boolean showControlsBar)  throws IllegalStateException {
        setAttribute("showControlsBar", showControlsBar, false);
    }

    /**
     * If false the controls bar at the top of the calendar will not be displayed - this means  that the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getControlsBar controlsBar} will be hidden, so the autoChildren ({@link
     * com.smartgwt.client.widgets.calendar.Calendar#getPreviousButton previousButton},  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDateLabel dateLabel}, {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getNextButton nextButton}, {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getAddEventButton addEventButton}, and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDatePickerButton datePickerButton})  will not be created or shown.
     *
     * @return Boolean
     */
    public Boolean getShowControlsBar()  {
        return getAttributeAsBoolean("showControlsBar");
    }

    /**
     * Determines whether the {@link com.smartgwt.client.widgets.calendar.Calendar#getDateChooser dateChooser} is displayed.
     *
     * @param showDateChooser  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public void setShowDateChooser(Boolean showDateChooser)  throws IllegalStateException {
        setAttribute("showDateChooser", showDateChooser, false);
    }

    /**
     * Determines whether the {@link com.smartgwt.client.widgets.calendar.Calendar#getDateChooser dateChooser} is displayed.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public Boolean getShowDateChooser()  {
        return getAttributeAsBoolean("showDateChooser");
    }

    /**
     * Set to false to hide the {@link com.smartgwt.client.widgets.calendar.Calendar#getDatePickerButton datePickerButton} that
     * allows selecting a new base date for  this Calendar.
     *
     * @param showDatePickerButton  Default value is null
     */
    public void setShowDatePickerButton(Boolean showDatePickerButton) {
        setAttribute("showDatePickerButton", showDatePickerButton, true);
    }

    /**
     * Set to false to hide the {@link com.smartgwt.client.widgets.calendar.Calendar#getDatePickerButton datePickerButton} that
     * allows selecting a new base date for  this Calendar.
     *
     * @return Boolean
     */
    public Boolean getShowDatePickerButton()  {
        return getAttributeAsBoolean("showDatePickerButton");
    }

    /**
     * If true, the default, show a header cell for each day cell in the  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getMonthView month view}, with both cells having a minimum combined height
     * of  {@link com.smartgwt.client.widgets.calendar.Calendar#getMinimumDayHeight minimumDayHeight}.  If false, the header
     * cells will not be shown, and the value  of {@link com.smartgwt.client.widgets.calendar.Calendar#getMinimumDayHeight
     * minimumDayHeight} is ignored.  This causes the available vertical space in month views to be shared equally between day
     * cells, such that no vertical scrollbar is required unless the HTML in the cells renders them taller than will fit.
     *
     * @param showDayHeaders  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public void setShowDayHeaders(Boolean showDayHeaders)  throws IllegalStateException {
        setAttribute("showDayHeaders", showDayHeaders, false);
    }

    /**
     * If true, the default, show a header cell for each day cell in the  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getMonthView month view}, with both cells having a minimum combined height
     * of  {@link com.smartgwt.client.widgets.calendar.Calendar#getMinimumDayHeight minimumDayHeight}.  If false, the header
     * cells will not be shown, and the value  of {@link com.smartgwt.client.widgets.calendar.Calendar#getMinimumDayHeight
     * minimumDayHeight} is ignored.  This causes the available vertical space in month views to be shared equally between day
     * cells, such that no vertical scrollbar is required unless the HTML in the cells renders them taller than will fit.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public Boolean getShowDayHeaders()  {
        return getAttributeAsBoolean("showDayHeaders");
    }

    /**
     * If set to true, the {@link com.smartgwt.client.widgets.calendar.Calendar#getDayView day view} uses {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getLanes lanes} to render multiple vertical "lanes" within the day, very
     * much like a vertical {@link com.smartgwt.client.widgets.calendar.Timeline}. <P> Day lanes are useful for showing events
     * for various entities on the same day - agendas for  various staff members, for example, or delivery schedules for a
     * fleet of trucks. <P> Each day lane is self-contained, showing in a column with a header and individual events  are
     * placed in {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getLane appropriate lanes}, respecting padding and 
     * overlapping.  If {@link com.smartgwt.client.widgets.calendar.Calendar#getCanEditEvents canEditEvents} is true, events
     * can be drag-moved or drag-resized  from their top and bottom edges, within the containing lane.  To allow events to be
     * dragged  from one lane into another, see {@link com.smartgwt.client.widgets.calendar.Calendar#getCanEditLane
     * canEditLane}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Changes the {@link com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes view mode} of the day view at runtime - whether to show a normal day column for the {@link com.smartgwt.client.widgets.calendar.Calendar#getChosenDate chosenDate}, or the specified set of  {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes vertical lanes}.
     *
     * @param showDayLanes whether or not to show lanes in the day view. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowDayLanes(Boolean showDayLanes)  throws IllegalStateException {
        setAttribute("showDayLanes", showDayLanes, false);
    }

    /**
     * If set to true, the {@link com.smartgwt.client.widgets.calendar.Calendar#getDayView day view} uses {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getLanes lanes} to render multiple vertical "lanes" within the day, very
     * much like a vertical {@link com.smartgwt.client.widgets.calendar.Timeline}. <P> Day lanes are useful for showing events
     * for various entities on the same day - agendas for  various staff members, for example, or delivery schedules for a
     * fleet of trucks. <P> Each day lane is self-contained, showing in a column with a header and individual events  are
     * placed in {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getLane appropriate lanes}, respecting padding and 
     * overlapping.  If {@link com.smartgwt.client.widgets.calendar.Calendar#getCanEditEvents canEditEvents} is true, events
     * can be drag-moved or drag-resized  from their top and bottom edges, within the containing lane.  To allow events to be
     * dragged  from one lane into another, see {@link com.smartgwt.client.widgets.calendar.Calendar#getCanEditLane
     * canEditLane}.
     *
     * @return Boolean
     */
    public Boolean getShowDayLanes()  {
        return getAttributeAsBoolean("showDayLanes");
    }

    /**
     * Whether to show fields marked <code>detail:true</code> when a DataBoundComponent is  given a DataSource but no
     * <code>component.fields</code>. <p> The <code>detail</code> property is used on DataSource fields to mark fields that 
     * shouldn't appear by default in a view that tries to show many records in a small space.
     *
     * @param showDetailFields  Default value is true
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
     * @return Boolean
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public Boolean getShowDetailFields()  {
        return getAttributeAsBoolean("showDetailFields");
    }

    /**
     * When rendering the {@link com.smartgwt.client.widgets.calendar.Calendar#getEventCanvas canvas} for an event, whether to
     * show the  {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowBody body area}, typically containing brief
     * details of the event -  {@link com.smartgwt.client.widgets.calendar.Calendar#getEventBodyHTML by default},  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDescriptionField its description}. <P> The default is true - if set to
     * false, the event's {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowHeader header}  will fill the canvas.
     *
     * @param showEventDescriptions  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowEventDescriptions(boolean showEventDescriptions)  throws IllegalStateException {
        setAttribute("showEventDescriptions", showEventDescriptions, false);
    }

    /**
     * When rendering the {@link com.smartgwt.client.widgets.calendar.Calendar#getEventCanvas canvas} for an event, whether to
     * show the  {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowBody body area}, typically containing brief
     * details of the event -  {@link com.smartgwt.client.widgets.calendar.Calendar#getEventBodyHTML by default},  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDescriptionField its description}. <P> The default is true - if set to
     * false, the event's {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowHeader header}  will fill the canvas.
     *
     * @return boolean
     */
    public boolean getShowEventDescriptions()  {
        return getAttributeAsBoolean("showEventDescriptions");
    }

    /**
     * When rendering the {@link com.smartgwt.client.widgets.calendar.Calendar#getEventCanvas canvas} for an event, whether to
     * show the  {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowHeader header area}, typically containing
     * suitable title text -  {@link com.smartgwt.client.widgets.calendar.Calendar#getEventHeaderHTML by default}, the event's
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getNameField name}. <P> The default is true - if set to false, the
     * event's {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowBody body area}  will fill the canvas.
     *
     * @param showEventHeaders  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowEventHeaders(boolean showEventHeaders)  throws IllegalStateException {
        setAttribute("showEventHeaders", showEventHeaders, false);
    }

    /**
     * When rendering the {@link com.smartgwt.client.widgets.calendar.Calendar#getEventCanvas canvas} for an event, whether to
     * show the  {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowHeader header area}, typically containing
     * suitable title text -  {@link com.smartgwt.client.widgets.calendar.Calendar#getEventHeaderHTML by default}, the event's
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getNameField name}. <P> The default is true - if set to false, the
     * event's {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowBody body area}  will fill the canvas.
     *
     * @return boolean
     */
    public boolean getShowEventHeaders()  {
        return getAttributeAsBoolean("showEventHeaders");
    }

    /**
     * Set to true to render any defined {@link com.smartgwt.client.widgets.calendar.Calendar#getIndicators indicators} into 
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timeline views}.
     *
     * @param showIndicators  Default value is null
     */
    public void setShowIndicators(Boolean showIndicators) {
        setAttribute("showIndicators", showIndicators, true);
    }

    /**
     * Set to true to render any defined {@link com.smartgwt.client.widgets.calendar.Calendar#getIndicators indicators} into 
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timeline views}.
     *
     * @return Boolean
     */
    public Boolean getShowIndicators()  {
        return getAttributeAsBoolean("showIndicators");
    }

    /**
     * Set to false to hide the {@link com.smartgwt.client.widgets.calendar.Calendar#getNextButton Next} button.
     *
     * @param showNextButton  Default value is null
     */
    public void setShowNextButton(Boolean showNextButton) {
        setAttribute("showNextButton", showNextButton, true);
    }

    /**
     * Set to false to hide the {@link com.smartgwt.client.widgets.calendar.Calendar#getNextButton Next} button.
     *
     * @return Boolean
     */
    public Boolean getShowNextButton()  {
        return getAttributeAsBoolean("showNextButton");
    }

    /**
     * If set to true, in the {@link com.smartgwt.client.widgets.calendar.Calendar#getMonthView month view}, days that fall in
     * an adjacent month are still shown with a header and body area, and are interactive.  Otherwise days from other  months
     * are rendered in the {@link com.smartgwt.client.widgets.calendar.Calendar#getOtherDayBlankStyle otherDayBlankStyle} and
     * are non-interactive.
     *
     * @param showOtherDays  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public void setShowOtherDays(Boolean showOtherDays)  throws IllegalStateException {
        setAttribute("showOtherDays", showOtherDays, false);
    }

    /**
     * If set to true, in the {@link com.smartgwt.client.widgets.calendar.Calendar#getMonthView month view}, days that fall in
     * an adjacent month are still shown with a header and body area, and are interactive.  Otherwise days from other  months
     * are rendered in the {@link com.smartgwt.client.widgets.calendar.Calendar#getOtherDayBlankStyle otherDayBlankStyle} and
     * are non-interactive.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public Boolean getShowOtherDays()  {
        return getAttributeAsBoolean("showOtherDays");
    }

    /**
     * Set to false to hide the {@link com.smartgwt.client.widgets.calendar.Calendar#getPreviousButton Previous} button.
     *
     * @param showPreviousButton  Default value is null
     */
    public void setShowPreviousButton(Boolean showPreviousButton) {
        setAttribute("showPreviousButton", showPreviousButton, true);
    }

    /**
     * Set to false to hide the {@link com.smartgwt.client.widgets.calendar.Calendar#getPreviousButton Previous} button.
     *
     * @return Boolean
     */
    public Boolean getShowPreviousButton()  {
        return getAttributeAsBoolean("showPreviousButton");
    }

    /**
     * Determines whether the quick event dialog is displayed when a time is clicked. If this is false, the full event editor
     * is displayed.
     *
     * @param showQuickEventDialog  Default value is true
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
     * @return Boolean
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public Boolean getShowQuickEventDialog()  {
        return getAttributeAsBoolean("showQuickEventDialog");
    }

    /**
     * If set to true, show the {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineView Timeline view}.
     *
     * @param showTimelineView  Default value is false
     */
    public void setShowTimelineView(Boolean showTimelineView) {
        setAttribute("showTimelineView", showTimelineView, true);
    }

    /**
     * If set to true, show the {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineView Timeline view}.
     *
     * @return Boolean
     */
    public Boolean getShowTimelineView()  {
        return getAttributeAsBoolean("showTimelineView");
    }

    /**
     * Suppresses the display of weekend days in the week and month views, and disallows the creation of events on weekends. 
     * Which days are considered weekends is controlled by {@link com.smartgwt.client.util.Date#weekendDays weekendDays}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for updating {@link com.smartgwt.client.widgets.calendar.Calendar#getShowWeekends showWeekends} at runtime.
     *
     * @param showWeekends whether or not to show weekends. Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public void setShowWeekends(Boolean showWeekends)  throws IllegalStateException {
        setAttribute("showWeekends", showWeekends, false);
    }

    /**
     * Suppresses the display of weekend days in the week and month views, and disallows the creation of events on weekends. 
     * Which days are considered weekends is controlled by {@link com.smartgwt.client.util.Date#weekendDays weekendDays}.
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
     * com.smartgwt.client.widgets.calendar.Calendar#getDayView dayView}. <P> The hours of the workday can be customized for
     * particular dates by providing implementations of {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart
     * Calendar.getWorkdayStart} and {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayEnd
     * Calendar.getWorkdayEnd}.
     *
     * @param showWorkday  Default value is false
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
     * com.smartgwt.client.widgets.calendar.Calendar#getDayView dayView}. <P> The hours of the workday can be customized for
     * particular dates by providing implementations of {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart
     * Calendar.getWorkdayStart} and {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayEnd
     * Calendar.getWorkdayEnd}.
     *
     * @return Boolean
     */
    public Boolean getShowWorkday()  {
        return getAttributeAsBoolean("showWorkday");
    }

    /**
     * Set to true to render any defined {@link com.smartgwt.client.widgets.calendar.Calendar#getZones zones} into  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timeline views}.
     *
     * @param showZones  Default value is null
     */
    public void setShowZones(Boolean showZones) {
        setAttribute("showZones", showZones, true);
    }

    /**
     * Set to true to render any defined {@link com.smartgwt.client.widgets.calendar.Calendar#getZones zones} into  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timeline views}.
     *
     * @return Boolean
     */
    public Boolean getShowZones()  {
        return getAttributeAsBoolean("showZones");
    }

    /**
     * If true, events will be sized to the grid, even if they start and/or end at times between grid cells.
     *
     * @param sizeEventsToGrid  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSizeEventsToGrid(Boolean sizeEventsToGrid)  throws IllegalStateException {
        setAttribute("sizeEventsToGrid", sizeEventsToGrid, false);
    }

    /**
     * If true, events will be sized to the grid, even if they start and/or end at times between grid cells.
     *
     * @return Boolean
     */
    public Boolean getSizeEventsToGrid()  {
        return getAttributeAsBoolean("sizeEventsToGrid");
    }

    /**
     * The start date of the calendar {@link com.smartgwt.client.widgets.calendar.Timeline timeline view}.  Has no effect in 
     * other views.  If not specified, defaults to a timeline starting from the beginning  of the current {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineGranularity timelineGranularity} and spanning {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDefaultTimelineColumnSpan a default of 20} columns of that granularity.
     * <P> To set different start and {@link com.smartgwt.client.widgets.calendar.Calendar#getEndDate end} dates after initial
     * draw, see {@link com.smartgwt.client.widgets.calendar.Calendar#setTimelineRange setTimelineRange}. <P> Note that this
     * attribute may be automatically altered if showing  {@link com.smartgwt.client.widgets.calendar.Calendar#getHeaderLevels
     * header-levels}, to fit to header boundaries.
     *
     * @param startDate  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setStartDate(Date startDate)  throws IllegalStateException {
        setAttribute("startDate", startDate, false);
    }

    /**
     * The start date of the calendar {@link com.smartgwt.client.widgets.calendar.Timeline timeline view}.  Has no effect in 
     * other views.  If not specified, defaults to a timeline starting from the beginning  of the current {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineGranularity timelineGranularity} and spanning {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDefaultTimelineColumnSpan a default of 20} columns of that granularity.
     * <P> To set different start and {@link com.smartgwt.client.widgets.calendar.Calendar#getEndDate end} dates after initial
     * draw, see {@link com.smartgwt.client.widgets.calendar.Calendar#setTimelineRange setTimelineRange}. <P> Note that this
     * attribute may be automatically altered if showing  {@link com.smartgwt.client.widgets.calendar.Calendar#getHeaderLevels
     * header-levels}, to fit to header boundaries.
     *
     * @return Date
     */
    public Date getStartDate()  {
        return getAttributeAsDate("startDate");
    }

    /**
     * The name of the start date field on a {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.
     *
     * @param startDateField  Default value is "startDate"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public void setStartDateField(String startDateField)  throws IllegalStateException {
        setAttribute("startDateField", startDateField, false);
    }

    /**
     * The name of the start date field on a {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.
     *
     * @return String
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public String getStartDateField()  {
        return getAttributeAsString("startDateField");
    }

    /**
     * The name of the field which will determine the {@link com.smartgwt.client.widgets.calendar.Lane#getSublanes sublane} in
     * which this  event will be displayed, within its parent Lane, in {@link com.smartgwt.client.widgets.calendar.Timeline}s
     * and in the  {@link com.smartgwt.client.widgets.calendar.Calendar#getDayView day view}, if {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes showDayLanes} is true.
     *
     * @param sublaneNameField  Default value is "sublane"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSublaneNameField(String sublaneNameField)  throws IllegalStateException {
        setAttribute("sublaneNameField", sublaneNameField, false);
    }

    /**
     * The name of the field which will determine the {@link com.smartgwt.client.widgets.calendar.Lane#getSublanes sublane} in
     * which this  event will be displayed, within its parent Lane, in {@link com.smartgwt.client.widgets.calendar.Timeline}s
     * and in the  {@link com.smartgwt.client.widgets.calendar.Calendar#getDayView day view}, if {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes showDayLanes} is true.
     *
     * @return String
     */
    public String getSublaneNameField()  {
        return getAttributeAsString("sublaneNameField");
    }

    /**
     * The granularity with which the timelineView will display events.  Possible values are those available in the built-in
     * {@link com.smartgwt.client.types.TimeUnit TimeUnit} type.
     *
     * @param timelineGranularity  Default value is "day"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTimelineGranularity(TimeUnit timelineGranularity)  throws IllegalStateException {
        setAttribute("timelineGranularity", timelineGranularity == null ? null : timelineGranularity.getValue(), false);
    }

    /**
     * The granularity with which the timelineView will display events.  Possible values are those available in the built-in
     * {@link com.smartgwt.client.types.TimeUnit TimeUnit} type.
     *
     * @return TimeUnit
     */
    public TimeUnit getTimelineGranularity()  {
        return EnumUtil.getEnum(TimeUnit.values(), getAttribute("timelineGranularity"));
    }

    /**
     * How many units of {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineGranularity timelineGranularity} each
     * cell represents.
     *
     * @param timelineUnitsPerColumn  Default value is 1
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTimelineUnitsPerColumn(int timelineUnitsPerColumn)  throws IllegalStateException {
        setAttribute("timelineUnitsPerColumn", timelineUnitsPerColumn, false);
    }

    /**
     * How many units of {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineGranularity timelineGranularity} each
     * cell represents.
     *
     * @return int
     */
    public int getTimelineUnitsPerColumn()  {
        return getAttributeAsInt("timelineUnitsPerColumn");
    }

    /**
     * {@link com.smartgwt.client.widgets.calendar.CalendarView} used to display events in lanes in a horizontal {@link
     * com.smartgwt.client.widgets.calendar.Timeline} view.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return CalendarView
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public CalendarView getTimelineView() throws IllegalStateException {
        errorIfNotCreated("timelineView");
        return (CalendarView)CalendarView.getByJSObject(getAttributeAsJavaScriptObject("timelineView"));
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timeline view}.
     *
     * @param timelineViewTitle  Default value is "Timeline"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTimelineViewTitle(String timelineViewTitle)  throws IllegalStateException {
        setAttribute("timelineViewTitle", timelineViewTitle, false);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timeline view}.
     *
     * @return String
     */
    public String getTimelineViewTitle()  {
        return getAttributeAsString("timelineViewTitle");
    }

    /**
     * The background color for today in the Month view, or in the Timeline view when  +{timelineGranularity} is "day".
     *
     * @param todayBackgroundColor  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTodayBackgroundColor(String todayBackgroundColor)  throws IllegalStateException {
        setAttribute("todayBackgroundColor", todayBackgroundColor, false);
    }

    /**
     * The background color for today in the Month view, or in the Timeline view when  +{timelineGranularity} is "day".
     *
     * @return String
     */
    public String getTodayBackgroundColor()  {
        return getAttributeAsString("todayBackgroundColor");
    }

    /**
     * The name of the trailing date field for each event.  When this attribute and  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getLeadingDateField leadingDateField} are present in the data, a line
     * extends out from the event showing  the extent of the leading and trailing dates - useful for visualizing a pipeline of
     * events  where some can be moved a certain amount without affecting others.
     *
     * @param trailingDateField  Default value is "trailingDate"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public void setTrailingDateField(String trailingDateField)  throws IllegalStateException {
        setAttribute("trailingDateField", trailingDateField, false);
    }

    /**
     * The name of the trailing date field for each event.  When this attribute and  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getLeadingDateField leadingDateField} are present in the data, a line
     * extends out from the event showing  the extent of the leading and trailing dates - useful for visualizing a pipeline of
     * events  where some can be moved a certain amount without affecting others.
     *
     * @return String
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public String getTrailingDateField()  {
        return getAttributeAsString("trailingDateField");
    }

    /**
     * When set to true, causes {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes lanes} to be sub-divided
     * according to their set of {@link com.smartgwt.client.widgets.calendar.Lane#getSublanes sublanes}.
     *
     * @param useSublanes  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setUseSublanes(Boolean useSublanes)  throws IllegalStateException {
        setAttribute("useSublanes", useSublanes, false);
    }

    /**
     * When set to true, causes {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes lanes} to be sub-divided
     * according to their set of {@link com.smartgwt.client.widgets.calendar.Lane#getSublanes sublanes}.
     *
     * @return Boolean
     */
    public Boolean getUseSublanes()  {
        return getAttributeAsBoolean("useSublanes");
    }

    /**
     * Augments the width of week event windows slightly to avoid duplicate adjacent borders between events.
     *
     * @param weekEventBorderOverlap  Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setWeekEventBorderOverlap(Boolean weekEventBorderOverlap)  throws IllegalStateException {
        setAttribute("weekEventBorderOverlap", weekEventBorderOverlap, false);
    }

    /**
     * Augments the width of week event windows slightly to avoid duplicate adjacent borders between events.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getWeekEventBorderOverlap()  {
        return getAttributeAsBoolean("weekEventBorderOverlap");
    }

    /**
     * The text to appear before the week number in the title of {@link com.smartgwt.client.types.TimeUnit week-based}  {@link
     * com.smartgwt.client.widgets.calendar.HeaderLevel}s when this calendar is showing a timeline.
     *
     * @param weekPrefix  Default value is "Week"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setWeekPrefix(String weekPrefix)  throws IllegalStateException {
        setAttribute("weekPrefix", weekPrefix, false);
    }

    /**
     * The text to appear before the week number in the title of {@link com.smartgwt.client.types.TimeUnit week-based}  {@link
     * com.smartgwt.client.widgets.calendar.HeaderLevel}s when this calendar is showing a timeline.
     *
     * @return String
     */
    public String getWeekPrefix()  {
        return getAttributeAsString("weekPrefix");
    }

    /**
     * {@link com.smartgwt.client.widgets.calendar.CalendarView} used to display events that pertain to a given week.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return CalendarView
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public CalendarView getWeekView() throws IllegalStateException {
        errorIfNotCreated("weekView");
        return (CalendarView)CalendarView.getByJSObject(getAttributeAsJavaScriptObject("weekView"));
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getWeekView week view}.
     *
     * @param weekViewTitle  Default value is "Week"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setWeekViewTitle(String weekViewTitle)  throws IllegalStateException {
        setAttribute("weekViewTitle", weekViewTitle, false);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getWeekView week view}.
     *
     * @return String
     */
    public String getWeekViewTitle()  {
        return getAttributeAsString("weekViewTitle");
    }

    /**
     * If {@link com.smartgwt.client.widgets.calendar.Calendar#getShowWorkday showWorkday} is set, this is the style used for
     * cells that are within the workday,  as defined by {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart
     * workdayStart} and {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayEnd workdayEnd}, or by a date-specific
     * range  provided in {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart Calendar.getWorkdayStart} and
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayEnd Calendar.getWorkdayEnd} implementations.
     *
     * @param workdayBaseStyle  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is "calendarWorkday"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setWorkdayBaseStyle(String workdayBaseStyle)  throws IllegalStateException {
        setAttribute("workdayBaseStyle", workdayBaseStyle, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.calendar.Calendar#getShowWorkday showWorkday} is set, this is the style used for
     * cells that are within the workday,  as defined by {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart
     * workdayStart} and {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayEnd workdayEnd}, or by a date-specific
     * range  provided in {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart Calendar.getWorkdayStart} and
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayEnd Calendar.getWorkdayEnd} implementations.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getWorkdayBaseStyle()  {
        return getAttributeAsString("workdayBaseStyle");
    }

    /**
     * <b>Note :</b> This API is non-functional (always returns null) and exists only to make
     * you aware that this MultiAutoChild exists.  See {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}
     * for details.
     * <p>
     * AutoChild component created for each {@link com.smartgwt.client.widgets.calendar.Calendar#getZones zone} entry.
     *
     * @return null
     */
    public ZoneCanvas getZoneCanvas()  {
        return null;
    }

    /**
     * An array of CalendarEvent instances representing pre-defined periods of time to be  highlighted in {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timeline views}.  Each zone renders out a {@link
     * com.smartgwt.client.widgets.calendar.ZoneCanvas zone canvas}, a special, non-interactive subclass of  {@link
     * com.smartgwt.client.widgets.calendar.EventCanvas}, which spans all lanes and draws behind any normal, interactive 
     * events in the zorder. <P> The default {@link com.smartgwt.client.widgets.calendar.Calendar#getZoneStyleName style} for
     * these components renders them  semi-transparent and with a bottom-aligned title label.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.calendar.Calendar#getZones zones} used to highlight areas of this calendar.
     *
     * @param zones array of zones to display. Default value is null
     */
    public void setZones(CalendarEvent... zones) {
        setAttribute("zones", zones, true);
    }

    /**
     * An array of CalendarEvent instances representing pre-defined periods of time to be  highlighted in {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timeline views}.  Each zone renders out a {@link
     * com.smartgwt.client.widgets.calendar.ZoneCanvas zone canvas}, a special, non-interactive subclass of  {@link
     * com.smartgwt.client.widgets.calendar.EventCanvas}, which spans all lanes and draws behind any normal, interactive 
     * events in the zorder. <P> The default {@link com.smartgwt.client.widgets.calendar.Calendar#getZoneStyleName style} for
     * these components renders them  semi-transparent and with a bottom-aligned title label.
     *
     * @return CalendarEvent...
     */
    public CalendarEvent[] getZones()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfCalendarEvent(getAttributeAsJavaScriptObject("zones"));
    }

    /**
     * CSS style to apply to the {@link com.smartgwt.client.widgets.calendar.Calendar#getZoneCanvas canvases} created for each
     * specified {@link com.smartgwt.client.widgets.calendar.Calendar#getZones zone}.
     *
     * @param zoneStyleName  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is "zoneCanvas"
     */
    public void setZoneStyleName(String zoneStyleName) {
        setAttribute("zoneStyleName", zoneStyleName, true);
    }

    /**
     * CSS style to apply to the {@link com.smartgwt.client.widgets.calendar.Calendar#getZoneCanvas canvases} created for each
     * specified {@link com.smartgwt.client.widgets.calendar.Calendar#getZones zone}.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     */
    public String getZoneStyleName()  {
        return getAttributeAsString("zoneStyleName");
    }

    // ********************* Methods ***********************

	/**
     * Create a new event in this calendar. <P> In all cases, the {@link com.smartgwt.client.widgets.calendar.CalendarEvent
     * event} passed as the first parameter must have at  least a {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getStartDateField start date} set.  If the calendar is showing  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getLanes lanes}, the name of the {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getLane lane} and, if  applicable, the {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getSublane sublane}, must also be set.
     * @param event the new calendar event to add
     */
    public native void addCalendarEvent(CalendarEvent event) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addCalendarEvent(event.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * Create a new event in this calendar. <P> In all cases, the {@link com.smartgwt.client.widgets.calendar.CalendarEvent
     * event} passed as the first parameter must have at  least a {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getStartDateField start date} set.  If the calendar is showing  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getLanes lanes}, the name of the {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getLane lane} and, if  applicable, the {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getSublane sublane}, must also be set.
     * @param event the new calendar event to add
     * @param customValues additional, custom values to be saved with the event
     */
    public native void addCalendarEvent(CalendarEvent event, Object customValues) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addCalendarEvent(event.@com.smartgwt.client.core.DataClass::getJsObj()(), customValues);
    }-*/;


	/**
     * Adds a new {@link com.smartgwt.client.widgets.calendar.Calendar#getIndicators indicator} to the calendar.
     * @param indicator a new indicator to add to the calendar
     */
    public native void addIndicator(CalendarEvent indicator) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addIndicator(indicator.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;


	/**
     * Adds a new {@link com.smartgwt.client.widgets.calendar.Lane} to the calendar, for display in the  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timeline view}, and in the  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDayView day view} if {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes showDayLanes} is true.
     * @param lane a new Lane object to add to the calendar
     */
    public native void addLane(Lane lane) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addLane(lane.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;


	/**
     * For {@link com.smartgwt.client.widgets.calendar.Timeline}s, and for {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDayView dayView} with  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes showDayLanes} set, creates a new event and adds it to a 
     * particular {@link com.smartgwt.client.widgets.calendar.Lane}.
     * @param laneName the Lane in which to add this event
     * @param startDate start date of event, or CalendarEvent Object
     * @deprecated in favor of {@link com.smartgwt.client.widgets.calendar.Calendar#addCalendarEvent Calendar.addCalendarEvent}
     */
    public native void addLaneEvent(Lane laneName, Date startDate) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addLaneEvent(laneName.@com.smartgwt.client.core.DataClass::getJsObj()(), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(startDate));
    }-*/;

    /**
     * @see {@link Calendar#addLaneEvent()}
     */
    public void addLaneEvent(Lane laneName, Date startDate, Date endDate){
        addLaneEvent(laneName, startDate, endDate, null, null, null);
    }

    /**
     * @see {@link Calendar#addLaneEvent()}
     */
    public void addLaneEvent(Lane laneName, Date startDate, Date endDate, String name){
        addLaneEvent(laneName, startDate, endDate, name, null, null);
    }

    /**
     * @see {@link Calendar#addLaneEvent()}
     */
    public void addLaneEvent(Lane laneName, Date startDate, Date endDate, String name, String description){
        addLaneEvent(laneName, startDate, endDate, name, description, null);
    }

	/**
     * For {@link com.smartgwt.client.widgets.calendar.Timeline}s, and for {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDayView dayView} with  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes showDayLanes} set, creates a new event and adds it to a 
     * particular {@link com.smartgwt.client.widgets.calendar.Lane}.
     * @param laneName the Lane in which to add this event
     * @param startDate start date of event, or CalendarEvent Object
     * @param endDate end date of event
     * @param name name of event
     * @param description description of event
     * @param otherFields new values of additional fields to be updated
     * @deprecated in favor of {@link com.smartgwt.client.widgets.calendar.Calendar#addCalendarEvent Calendar.addCalendarEvent}
     */
    public native void addLaneEvent(Lane laneName, Date startDate, Date endDate, String name, String description, Object otherFields) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addLaneEvent(laneName.@com.smartgwt.client.core.DataClass::getJsObj()(), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(startDate), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(endDate), name, description, otherFields);
    }-*/;


	/**
     * Adds a new {@link com.smartgwt.client.widgets.calendar.Calendar#getZones zone} to the calendar.
     * @param zone a new zone to add to the calendar
     */
    public native void addZone(CalendarEvent zone) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addZone(zone.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

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
        var backgroundClick = $debox($entry(function(param){
                var event = @com.smartgwt.client.widgets.calendar.events.BackgroundClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({backgroundClick: 
                function () {
                    var param = {"startDate" : arguments[0], "endDate" : arguments[1]};
                    return backgroundClick(param) == true;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.backgroundClick = 
                function () {
                    var param = {"startDate" : arguments[0], "endDate" : arguments[1]};
                    return backgroundClick(param) == true;
                }
            ;
        }
   }-*/;
    /**
     * Add a backgroundMouseDown handler.
     * <p>
     * Callback fired when the mouse button is depressed over a background-cell, ie, one  without an event.  Call {@link
     * com.smartgwt.client.widgets.calendar.events.BackgroundMouseDownEvent#cancel()} from within {@link
     * com.smartgwt.client.widgets.calendar.events.BackgroundMouseDownHandler#onBackgroundMouseDown} to cancel the default
     * behavior of allowing sweep selection via dragging.
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
        var backgroundMouseDown = $debox($entry(function(param){
                var event = @com.smartgwt.client.widgets.calendar.events.BackgroundMouseDownEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({backgroundMouseDown: 
                function () {
                    var param = {"startDate" : arguments[0]};
                    return backgroundMouseDown(param) == true;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.backgroundMouseDown = 
                function () {
                    var param = {"startDate" : arguments[0]};
                    return backgroundMouseDown(param) == true;
                }
            ;
        }
   }-*/;

	/**
     * Notification method fired when the mouse button is released over a background-cell, ie,  one without an event.  Return
     * false to cancel the default behavior of showing a dialog to add a new event with the passed dates.
     * @param startDate the datetime of the slot where the mouse button was depressed
     * @param endDate the datetime of the slot where the mouse button was released
     *
     * @return return false to suppress default behavior of showing a dialog                      to add a new event with the passed
     * dates.
     */
    public native boolean backgroundMouseUp(Date startDate, Date endDate) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.backgroundMouseUp(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(startDate), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(endDate));
        return ret;
    }-*/;

    /**
     * Add a currentViewChanged handler.
     * <p>
     * Notification that fires whenever the current view changes via the  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getMainView mainView tabset}.
     *
     * @param handler the currentViewChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addCurrentViewChangedHandler(com.smartgwt.client.widgets.calendar.events.CurrentViewChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.calendar.events.CurrentViewChangedEvent.getType()) == 0) setupCurrentViewChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.calendar.events.CurrentViewChangedEvent.getType());
    }

    private native void setupCurrentViewChangedEvent() /*-{
        var obj = null;
        var selfJ = this;
        var currentViewChanged = $entry(function(){
            var param = {"viewName" : arguments[0]};

                var event = @com.smartgwt.client.widgets.calendar.events.CurrentViewChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({currentViewChanged:  currentViewChanged              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.currentViewChanged =  currentViewChanged             ;
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
        var dateChanged = $entry(function(){
            var param = {};

                var event = @com.smartgwt.client.widgets.calendar.events.DateChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({dateChanged:  dateChanged              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.dateChanged =  dateChanged             ;
        }
   }-*/;
    /**
     * Add a dayBodyClick handler.
     * <p>
     * Called when the body area of a day in the month view is clicked on, outside of any links to a particular event. <P> By
     * default, if the user can add events, shows a dialog for adding a new event for that day.  Call {@link
     * com.smartgwt.client.widgets.calendar.events.DayBodyClickEvent#cancel()} from within {@link
     * com.smartgwt.client.widgets.calendar.events.DayBodyClickHandler#onDayBodyClick} to cancel this action. <P> Not called if
     * the day falls outside the current month and {@link com.smartgwt.client.widgets.calendar.Calendar#getShowOtherDays
     * showOtherDays} is false.
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
        var dayBodyClick = $debox($entry(function(param){
                var event = @com.smartgwt.client.widgets.calendar.events.DayBodyClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({dayBodyClick: 
                function () {
                    var param = {"date" : arguments[0], "events" : arguments[1], "calendar" : arguments[2], "rowNum" : arguments[3], "colNum" : arguments[4]};
                    return dayBodyClick(param) == true;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.dayBodyClick = 
                function () {
                    var param = {"date" : arguments[0], "events" : arguments[1], "calendar" : arguments[2], "rowNum" : arguments[3], "colNum" : arguments[4]};
                    return dayBodyClick(param) == true;
                }
            ;
        }
   }-*/;
    /**
     * Add a dayHeaderClick handler.
     * <p>
     * Called when the header area of a day in the month view is clicked on. <P> By default, moves to the day tab and shows the
     * clicked days events. Call {@link com.smartgwt.client.widgets.calendar.events.DayHeaderClickEvent#cancel()} from within
     * {@link com.smartgwt.client.widgets.calendar.events.DayHeaderClickHandler#onDayHeaderClick} to cancel this action. <P>
     * Not called if the day falls outside the current month and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowOtherDays showOtherDays} is false.
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
        var dayHeaderClick = $debox($entry(function(param){
                var event = @com.smartgwt.client.widgets.calendar.events.DayHeaderClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({dayHeaderClick: 
                function () {
                    var param = {"date" : arguments[0], "events" : arguments[1], "calendar" : arguments[2], "rowNum" : arguments[3], "colNum" : arguments[4]};
                    return dayHeaderClick(param) == true;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.dayHeaderClick = 
                function () {
                    var param = {"date" : arguments[0], "events" : arguments[1], "calendar" : arguments[2], "rowNum" : arguments[3], "colNum" : arguments[4]};
                    return dayHeaderClick(param) == true;
                }
            ;
        }
   }-*/;
    /**
     * Add a eventAdded handler.
     * <p>
     * Notification fired whenever a user adds an event. <P> In a calendar with a DataSource, eventAdded() fires <b>after</b>
     * the event has been successfully added at the server
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
        var eventAdded = $entry(function(){
            var param = {"event" : arguments[0]};

                var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventAdded::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({eventAdded:  eventAdded              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.eventAdded =  eventAdded             ;
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
        var eventChanged = $entry(function(){
            var param = {"event" : arguments[0]};

                var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({eventChanged:  eventChanged              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.eventChanged =  eventChanged             ;
        }
   }-*/;
    /**
     * Add a eventClick handler.
     * <p>
     * Called whenever an event is clicked on in the day, week or month views. <P> By default a dialog appears showing details
     * for the event, and offering the ability to edit events which are editable.  Call {@link
     * com.smartgwt.client.widgets.calendar.events.CalendarEventClick#cancel()} from within {@link
     * com.smartgwt.client.widgets.calendar.events.EventClickHandler#onEventClick} to cancel the default action. This is a good
     * place to, for example, show a completely customized event dialog instead of the default one.
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
        var eventClick = $debox($entry(function(param){
                var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventClick::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({eventClick: 
                function () {
                    var param = {"event" : arguments[0], "viewName" : arguments[1]};
                    return eventClick(param) == true;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.eventClick = 
                function () {
                    var param = {"event" : arguments[0], "viewName" : arguments[1]};
                    return eventClick(param) == true;
                }
            ;
        }
   }-*/;
    /**
     * Add a eventMoved handler.
     * <p>
     * Called when an event is moved via dragging by a user.  Call {@link
     * com.smartgwt.client.widgets.calendar.events.CalendarEventMoved#cancel()} from within {@link
     * com.smartgwt.client.widgets.calendar.events.EventMovedHandler#onEventMoved} to disallow the move.
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
        var eventMoved = $debox($entry(function(param){
                var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventMoved::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({eventMoved: 
                function () {
                    var param = {"newDate" : arguments[0], "event" : arguments[1], "newLane" : arguments[2]};
                    return eventMoved(param) == true;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.eventMoved = 
                function () {
                    var param = {"newDate" : arguments[0], "event" : arguments[1], "newLane" : arguments[2]};
                    return eventMoved(param) == true;
                }
            ;
        }
   }-*/;
    /**
     * Add a eventRemoveClick handler.
     * <p>
     * Called whenever the close icon of an {@link com.smartgwt.client.widgets.calendar.EventCanvas event canvas} is clicked in
     * the  {@link com.smartgwt.client.widgets.calendar.Calendar#getDayView day}, {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWeekView week} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timeline} views.  <P> Implement this method to intercept
     * the automatic removal of data.  You can Call {@link
     * com.smartgwt.client.widgets.calendar.events.CalendarEventRemoveClick#cancel()} from within {@link
     * com.smartgwt.client.widgets.calendar.events.EventRemoveClickHandler#onEventRemoveClick} to  prevent the default action
     * (calling {@link com.smartgwt.client.widgets.calendar.Calendar#removeEvent removeEvent()}) and instead  take action of
     * your own.  For example, returning false from this method and then showing a  custom confirmation dialog - if the user
     * cancels, do nothing, otherwise make a call to {@link com.smartgwt.client.widgets.calendar.Calendar#removeEvent
     * removeEvent(event)}, passing the event.
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
        var eventRemoveClick = $debox($entry(function(param){
                var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventRemoveClick::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({eventRemoveClick: 
                function () {
                    var param = {"event" : arguments[0], "viewName" : arguments[1]};
                    return eventRemoveClick(param) == true;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.eventRemoveClick = 
                function () {
                    var param = {"event" : arguments[0], "viewName" : arguments[1]};
                    return eventRemoveClick(param) == true;
                }
            ;
        }
   }-*/;
    /**
     * Add a eventRemoved handler.
     * <p>
     * Notification fired whenever a user removes an event. <P> In a calendar with a DataSource, eventRemoved() fires
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
        var eventRemoved = $entry(function(){
            var param = {"event" : arguments[0]};

                var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventRemoved::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({eventRemoved:  eventRemoved              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.eventRemoved =  eventRemoved             ;
        }
   }-*/;
    /**
     * Add a eventRepositionMove handler.
     * <p>
     * Notification called whenever the drop position of an event being drag-moved changes. <P> The <code>newEvent</code>
     * parameter represents the event as it will be after the move,  including {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getStartDate start} and {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getEndDate end} dates and {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getLane lane} and {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getSublane sublane} where  applicable. <P> Call {@link
     * com.smartgwt.client.widgets.calendar.events.EventRepositionMove#cancel()} from within {@link
     * com.smartgwt.client.widgets.calendar.events.EventRepositionMoveHandler#onEventRepositionMove} to prevent the default
     * action, of positioning the drag canvas to the newEvent.
     *
     * @param handler the eventRepositionMove handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addEventRepositionMoveHandler(com.smartgwt.client.widgets.calendar.events.EventRepositionMoveHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.calendar.events.EventRepositionMove.getType()) == 0) setupEventRepositionMoveEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.calendar.events.EventRepositionMove.getType());
    }

    private native void setupEventRepositionMoveEvent() /*-{
        var obj = null;
        var selfJ = this;
        var eventRepositionMove = $debox($entry(function(param){
                var event = @com.smartgwt.client.widgets.calendar.events.EventRepositionMove::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({eventRepositionMove: 
                function () {
                    var param = {"event" : arguments[0], "newEvent" : arguments[1]};
                    return eventRepositionMove(param) == true;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.eventRepositionMove = 
                function () {
                    var param = {"event" : arguments[0], "newEvent" : arguments[1]};
                    return eventRepositionMove(param) == true;
                }
            ;
        }
   }-*/;
    /**
     * Add a eventRepositionStop handler.
     * <p>
     * Notification called when an event being drag-moved is dropped. <P> The <code>newEvent</code> parameter represents the
     * event as it will be after the move,  including {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getStartDate
     * start} and {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getEndDate end} dates and {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getLane lane} and {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getSublane sublane} where  applicable. <P> Call {@link
     * com.smartgwt.client.widgets.calendar.events.EventRepositionStop#cancel()} from within {@link
     * com.smartgwt.client.widgets.calendar.events.EventRepositionStopHandler#onEventRepositionStop} to prevent the default
     * action, of actually  {@link com.smartgwt.client.widgets.calendar.Calendar#updateCalendarEvent updating} the event.
     *
     * @param handler the eventRepositionStop handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addEventRepositionStopHandler(com.smartgwt.client.widgets.calendar.events.EventRepositionStopHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.calendar.events.EventRepositionStop.getType()) == 0) setupEventRepositionStopEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.calendar.events.EventRepositionStop.getType());
    }

    private native void setupEventRepositionStopEvent() /*-{
        var obj = null;
        var selfJ = this;
        var eventRepositionStop = $debox($entry(function(param){
                var event = @com.smartgwt.client.widgets.calendar.events.EventRepositionStop::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({eventRepositionStop: 
                function () {
                    var param = {"event" : arguments[0], "newEvent" : arguments[1], "customValues" : arguments[2]};
                    return eventRepositionStop(param) == true;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.eventRepositionStop = 
                function () {
                    var param = {"event" : arguments[0], "newEvent" : arguments[1], "customValues" : arguments[2]};
                    return eventRepositionStop(param) == true;
                }
            ;
        }
   }-*/;
    /**
     * Add a eventResized handler.
     * <p>
     * Called when an event is resized with the mouse.  The passed date value is the new *end* date for the event, since
     * resizing can only be performed on the bottom edge of an event in normal calendar views.
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
        var eventResized = $debox($entry(function(param){
                var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventResized::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({eventResized: 
                function () {
                    var param = {"newDate" : arguments[0], "event" : arguments[1]};
                    return eventResized(param) == true;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.eventResized = 
                function () {
                    var param = {"newDate" : arguments[0], "event" : arguments[1]};
                    return eventResized(param) == true;
                }
            ;
        }
   }-*/;
    /**
     * Add a eventResizeMove handler.
     * <p>
     * Notification called on each resize during an event drag-resize operation. <P> The <code>newEvent</code> parameter
     * represents the event as it will be after the resize. <P> Call {@link
     * com.smartgwt.client.widgets.calendar.events.EventResizeMove#cancel()} from within {@link
     * com.smartgwt.client.widgets.calendar.events.EventResizeMoveHandler#onEventResizeMove} to prevent the default action, of
     * resizing the drag canvas to the newEvent.
     *
     * @param handler the eventResizeMove handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addEventResizeMoveHandler(com.smartgwt.client.widgets.calendar.events.EventResizeMoveHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.calendar.events.EventResizeMove.getType()) == 0) setupEventResizeMoveEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.calendar.events.EventResizeMove.getType());
    }

    private native void setupEventResizeMoveEvent() /*-{
        var obj = null;
        var selfJ = this;
        var eventResizeMove = $debox($entry(function(param){
                var event = @com.smartgwt.client.widgets.calendar.events.EventResizeMove::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({eventResizeMove: 
                function () {
                    var param = {"event" : arguments[0], "newEvent" : arguments[1]};
                    return eventResizeMove(param) == true;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.eventResizeMove = 
                function () {
                    var param = {"event" : arguments[0], "newEvent" : arguments[1]};
                    return eventResizeMove(param) == true;
                }
            ;
        }
   }-*/;
    /**
     * Add a eventResizeStop handler.
     * <p>
     * Notification called when an event drag-resize operation completes. <P> The <code>newEvent</code> parameter represents
     * the event as it will be after the move. <P> Call {@link
     * com.smartgwt.client.widgets.calendar.events.EventResizeStop#cancel()} from within {@link
     * com.smartgwt.client.widgets.calendar.events.EventResizeStopHandler#onEventResizeStop} to prevent the default action, of
     * actually  {@link com.smartgwt.client.widgets.calendar.Calendar#updateCalendarEvent updating} the event.
     *
     * @param handler the eventResizeStop handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addEventResizeStopHandler(com.smartgwt.client.widgets.calendar.events.EventResizeStopHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.calendar.events.EventResizeStop.getType()) == 0) setupEventResizeStopEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.calendar.events.EventResizeStop.getType());
    }

    private native void setupEventResizeStopEvent() /*-{
        var obj = null;
        var selfJ = this;
        var eventResizeStop = $debox($entry(function(param){
                var event = @com.smartgwt.client.widgets.calendar.events.EventResizeStop::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({eventResizeStop: 
                function () {
                    var param = {"event" : arguments[0], "newEvent" : arguments[1], "customValues" : arguments[2]};
                    return eventResizeStop(param) == true;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.eventResizeStop = 
                function () {
                    var param = {"event" : arguments[0], "newEvent" : arguments[1], "customValues" : arguments[2]};
                    return eventResizeStop(param) == true;
                }
            ;
        }
   }-*/;
	/**
     * A notification method fired when the events in the current view have been refreshed.
     */
    public native void eventsRendered() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.eventsRendered();
    }-*/;

	/**
     * Gets the day of the week (0-6) that the mouse is currently over.
     *
     * @return the day that the mouse is currently over
     * @see com.smartgwt.client.widgets.calendar.Calendar#getActiveTime
     */
    public native Integer getActiveDay() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getActiveDay();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toInteger(I)(ret);
    }-*/;

	/**
     * Gets a date object representing the date over which the mouse is hovering for the current selected view. For month view,
     * the time will be set to midnight of the active day. For day and week views, the time will be the rounded to the closest
     * half hour relative to the mouse position.
     *
     * @return the date that the mouse is over
     */
    public native Date getActiveTime() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getActiveTime();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;

	/**
     * Return the Date instance associated with the passed co-ordinates in the passed or selected view.  If the cell at the
     * passed co-ordinates is not a date-cell, returns null.  If rowNum  and colNum are both unset, returns the date from the
     * cell under the mouse. <P> To determine the date at a more specific point within a cell, see {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDateFromPoint Calendar.getDateFromPoint}.
     *
     * @return the date, if any, associated with the passed co-ords in the appropriate view
     */
    public native Date getCellDate() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getCellDate();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;

    /**
     * @see {@link Calendar#getCellDate()}
     */
    public Date getCellDate(Integer rowNum){
        return getCellDate(rowNum, (Integer) null, null);
    }

    /**
     * @see {@link Calendar#getCellDate()}
     */
    public Date getCellDate(Integer rowNum, Integer colNum){
        return getCellDate(rowNum, colNum, null);
    }

	/**
     * Return the Date instance associated with the passed co-ordinates in the passed or selected view.  If the cell at the
     * passed co-ordinates is not a date-cell, returns null.  If rowNum  and colNum are both unset, returns the date from the
     * cell under the mouse. <P> To determine the date at a more specific point within a cell, see {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDateFromPoint Calendar.getDateFromPoint}.
     * @param rowNum the row number to get the date for
     * @param colNum the column number to get the date for
     * @param view the view to use - uses the selected view if not passed
     *
     * @return the date, if any, associated with the passed co-ords in the appropriate view
     */
    public native Date getCellDate(Integer rowNum, Integer colNum, CalendarView view) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getCellDate(rowNum == null ? null : rowNum.@java.lang.Integer::intValue()(), colNum == null ? null : colNum.@java.lang.Integer::intValue()(), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;


	/**
     * Return CSS text for styling the cell associated with the passed date and/or rowNum & colNum, which will be applied in
     * addition to the CSS class for the cell, as overrides. <p> "CSS text" means semicolon-separated style settings, suitable
     * for inclusion in a CSS stylesheet or in a STYLE attribute of an HTML element.
     * @param date the date to return CSS text for
     * @param rowNum the row number to get the CSS for
     * @param colNum the column number to get the date for
     * @param view the current CalendarView
     *
     * @return CSS text for the associated cell
     * @see com.smartgwt.client.widgets.calendar.Calendar#getDateStyle
     */
    public native String getDateCSSText(Date date, Integer rowNum, Integer colNum, CalendarView view) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDateCSSText(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date), rowNum == null ? null : rowNum.@java.lang.Integer::intValue()(), colNum == null ? null : colNum.@java.lang.Integer::intValue()(), view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        return ret;
    }-*/;

	/**
     * Returns a Date instance representing the point at the passed offsets into the body of the  current view. <P> If
     * snapOffsets is passed as false, returns the date representing the  exact position of the passed offsets.  If unset or
     * passed as true, returns the date at the  nearest eventSnapGap to the left, for {@link
     * com.smartgwt.client.widgets.calendar.Timeline}s, or above for {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDayView day}  and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWeekView week} views. <P> If neither x nor y offsets are passed,
     * assumes them from the last mouse event. <P> If the cell at the eventual offsets is not a date-cell, returns null. <P>
     * Note that, for the {@link com.smartgwt.client.widgets.calendar.Calendar#getMonthView month view}, this method is
     * functionally equivalent to  {@link com.smartgwt.client.widgets.calendar.Calendar#getCellDate Calendar.getCellDate},
     * which determines the date associated with a cell, without the additional  offset precision offered here.
     *
     * @return the date, if any, associated with the passed co-ords in the current view
     */
    public native Date getDateFromPoint() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDateFromPoint();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;

    /**
     * @see {@link Calendar#getDateFromPoint()}
     */
    public Date getDateFromPoint(Integer x){
        return getDateFromPoint(x, (Integer) null, null, null);
    }

    /**
     * @see {@link Calendar#getDateFromPoint()}
     */
    public Date getDateFromPoint(Integer x, Integer y){
        return getDateFromPoint(x, y, null, null);
    }

    /**
     * @see {@link Calendar#getDateFromPoint()}
     */
    public Date getDateFromPoint(Integer x, Integer y, Boolean snapOffsets){
        return getDateFromPoint(x, y, snapOffsets, null);
    }

	/**
     * Returns a Date instance representing the point at the passed offsets into the body of the  current view. <P> If
     * snapOffsets is passed as false, returns the date representing the  exact position of the passed offsets.  If unset or
     * passed as true, returns the date at the  nearest eventSnapGap to the left, for {@link
     * com.smartgwt.client.widgets.calendar.Timeline}s, or above for {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDayView day}  and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWeekView week} views. <P> If neither x nor y offsets are passed,
     * assumes them from the last mouse event. <P> If the cell at the eventual offsets is not a date-cell, returns null. <P>
     * Note that, for the {@link com.smartgwt.client.widgets.calendar.Calendar#getMonthView month view}, this method is
     * functionally equivalent to  {@link com.smartgwt.client.widgets.calendar.Calendar#getCellDate Calendar.getCellDate},
     * which determines the date associated with a cell, without the additional  offset precision offered here.
     * @param x the x offset into the body of the selected view - non-functional for                       the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDayView day view}.  If this param and "y" are both unset,              
     *         assumes both offsets from the last mouse event.
     * @param y the y offset into the body of the selected view - non-functional for the                            {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timeline view}.  If this param and "x" are                
     *             both unset, assumes both offsets from the last mouse event.
     * @param snapOffsets whether to snap the offsets to the nearest eventSnapGap - if                                 unset, the default is true
     * @param view the view to use - or the selected view if not passed
     *
     * @return the date, if any, associated with the passed co-ords in the current view
     */
    public native Date getDateFromPoint(Integer x, Integer y, Boolean snapOffsets, CalendarView view) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDateFromPoint(x == null ? null : x.@java.lang.Integer::intValue()(), y == null ? null : y.@java.lang.Integer::intValue()(), snapOffsets == null ? null : snapOffsets.@java.lang.Boolean::booleanValue()(), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;


	/**
     * Return the CSS styleName for the cell associated with the passed date and/or rowNum & colNum.
     * @param date the date to return CSS text for
     * @param rowNum the row number to get the CSS for
     * @param colNum the column number to get the date for
     * @param view the current CalendarView
     *
     * @return CSS style for the cell associated with the passed date
     * @see com.smartgwt.client.widgets.calendar.Calendar#getDateCSSText
     */
    public native String getDateStyle(Date date, Integer rowNum, Integer colNum, CalendarView view) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDateStyle(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date), rowNum == null ? null : rowNum.@java.lang.Integer::intValue()(), colNum == null ? null : colNum.@java.lang.Integer::intValue()(), view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        return ret;
    }-*/;


	/**
     * Return the HTML to be shown in the body of a day in the month view. <P> Default is to render a series of links that call
     * {@link com.smartgwt.client.widgets.calendar.Calendar#addEventClickHandler Calendar.eventClick} to provide details and/or
     * an editing interface for the events. <P> <code>getDayBodyHTML()</code> is not called for days outside of the current
     * month if {@link com.smartgwt.client.widgets.calendar.Calendar#getShowOtherDays showOtherDays} is false.
     * @param date JavaScript Date object representing this day
     * @param events events that fall on this day
     * @param calendar the calendar itself
     * @param rowNum the row number to which the parameter date belongs
     * @param colNum the column number to which the parameter date belongs
     *
     * @return HTML to display
     */
    public native String getDayBodyHTML(Date date, CalendarEvent[] events, Calendar calendar, int rowNum, int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDayBodyHTML(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(events), calendar.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), rowNum, colNum);
        return ret;
    }-*/;


	/**
     * Returns the description text for the passed event, for display in the body area of an event  canvas.  The default
     * implementation returns the event's {@link com.smartgwt.client.widgets.calendar.Calendar#getDescriptionField description
     * field}.
     * @param event the event to get the description text for
     *
     * @return the HTML to display in the body of the passed event's EventCanvas
     */
    public native String getEventBodyHTML(CalendarEvent event) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEventBodyHTML(event.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;

	/**
     * Returns the description text for the passed event, for display in the body area of an event  canvas.  The default
     * implementation returns the event's {@link com.smartgwt.client.widgets.calendar.Calendar#getDescriptionField description
     * field}.
     * @param event the event to get the description text for
     * @param view the view in which the event is being rendered
     *
     * @return the HTML to display in the body of the passed event's EventCanvas
     */
    public native String getEventBodyHTML(CalendarEvent event, CalendarView view) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEventBodyHTML(event.@com.smartgwt.client.core.DataClass::getJsObj()(), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        return ret;
    }-*/;


	/**
     * If this method returns a value, it is expected to return an array of  {@link com.smartgwt.client.widgets.menu.MenuItem
     * items} applicable to the passed canvas and its event.  If an array  with valid entries is returned, the rollover {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventCanvasContextButton context button} is shown for the passed
     * canvas.
     * @param canvas the canvas to get menu items for
     *
     * @return 
     */
    public native MenuItem[] getEventCanvasMenuItems(EventCanvas canvas) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEventCanvasMenuItems(canvas.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfMenuItem(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


	/**
     * Returns the  styleName to use for the passed  {@link com.smartgwt.client.widgets.calendar.CalendarEvent event}, in the
     * passed {@link com.smartgwt.client.widgets.calendar.CalendarView view}.  By default, returns the style {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventStyleNameField on the event}, if one is specified - otherwise,  in
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes lane-based} views, it returns the style specified on the 
     * {@link com.smartgwt.client.widgets.calendar.Lane#getEventStyleName lane or sublane}, or the style specified on the 
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getEventStyleName calendar}.
     * @param event the event to get the CSS style for
     *
     * @return the CSS style to apply to the passed event in the passed view
     */
    public native String getEventCanvasStyle(CalendarEvent event) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEventCanvasStyle(event.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;

	/**
     * Returns the  styleName to use for the passed  {@link com.smartgwt.client.widgets.calendar.CalendarEvent event}, in the
     * passed {@link com.smartgwt.client.widgets.calendar.CalendarView view}.  By default, returns the style {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventStyleNameField on the event}, if one is specified - otherwise,  in
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes lane-based} views, it returns the style specified on the 
     * {@link com.smartgwt.client.widgets.calendar.Lane#getEventStyleName lane or sublane}, or the style specified on the 
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getEventStyleName calendar}.
     * @param event the event to get the CSS style for
     * @param view the CalendarView that contains the canvas being styled
     *
     * @return the CSS style to apply to the passed event in the passed view
     */
    public native String getEventCanvasStyle(CalendarEvent event, CalendarView view) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEventCanvasStyle(event.@com.smartgwt.client.core.DataClass::getJsObj()(), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        return ret;
    }-*/;


	/**
     * Returns the {@link com.smartgwt.client.widgets.calendar.Calendar#getEndDateField end date} of the passed event.  If the
     * event is {@link com.smartgwt.client.widgets.calendar.Calendar#getAllowDurationEvents duration-based}, the result is
     * calculated from the  {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getStartDate start date} and the
     * specified  {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getDuration duration} and {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getDurationUnit unit}.
     * @param event the event to get the start date of
     *
     * @return the end date of the passed event
     */
    public native Date getEventEndDate(CalendarEvent event) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEventEndDate(event.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;


	/**
     * Returns the title text for the passed event, for display in the header area of an event  canvas.  The default
     * implementation returns the event's {@link com.smartgwt.client.widgets.calendar.Calendar#getNameField name field} for
     * timelines, and that same value pre-pended with the event's {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getStartDateField start} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEndDateField end}  dates for day and week views.
     * @param event the event to get the description text for
     *
     * @return the HTML to display in the header of an event canvas
     */
    public native String getEventHeaderHTML(CalendarEvent event) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEventHeaderHTML(event.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;

	/**
     * Returns the title text for the passed event, for display in the header area of an event  canvas.  The default
     * implementation returns the event's {@link com.smartgwt.client.widgets.calendar.Calendar#getNameField name field} for
     * timelines, and that same value pre-pended with the event's {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getStartDateField start} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEndDateField end}  dates for day and week views.
     * @param event the event to get the description text for
     * @param view the view in which the event is being rendered
     *
     * @return the HTML to display in the header of an event canvas
     */
    public native String getEventHeaderHTML(CalendarEvent event, CalendarView view) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEventHeaderHTML(event.@com.smartgwt.client.core.DataClass::getJsObj()(), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        return ret;
    }-*/;

    /**
     * Add a eventHoverHTML handler.
     * <p>
     * Gets the hover HTML for an event being hovered over. Override here to return custom  HTML based upon the parameter event
     * object.
     *
     * @param handler the eventHoverHTML handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addEventHoverHTMLHandler(com.smartgwt.client.widgets.calendar.events.EventHoverHTMLHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.calendar.events.EventHoverHTMLEvent.getType()) == 0) setupEventHoverHTMLEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.calendar.events.EventHoverHTMLEvent.getType());
    }

    private native void setupEventHoverHTMLEvent() /*-{
        var obj = null;
        var selfJ = this;
        var getEventHoverHTML = $entry(function(){
            var param = {"event" : arguments[0], "eventCanvas" : arguments[1], "view" : arguments[2]};

                var event = @com.smartgwt.client.widgets.calendar.events.EventHoverHTMLEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({getEventHoverHTML:  getEventHoverHTML              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.getEventHoverHTML =  getEventHoverHTML             ;
        }
   }-*/;

	/**
     * Returns the {@link com.smartgwt.client.widgets.calendar.Lane lane} associated with the passed event, in the passed view
     * @param event the event to get the lane for
     *
     * @return the lane associated with the passed event
     */
    public native Lane getEventLane(CalendarEvent event) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEventLane(event.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.calendar.Lane::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns the {@link com.smartgwt.client.widgets.calendar.Lane lane} associated with the passed event, in the passed view
     * @param event the event to get the lane for
     * @param view the view to get the lane object from
     *
     * @return the lane associated with the passed event
     */
    public native Lane getEventLane(CalendarEvent event, CalendarView view) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEventLane(event.@com.smartgwt.client.core.DataClass::getJsObj()(), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.calendar.Lane::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


	/**
     * Returns the length of the passed {@link com.smartgwt.client.widgets.calendar.CalendarEvent event} in the passed  {@link
     * com.smartgwt.client.types.TimeUnit unit}.  If <code>unit</code> isn't passed, returns the length of the event  in
     * milliseconds.
     * @param event the event to get the length of
     */
    public native void getEventLength(CalendarEvent event) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.getEventLength(event.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * Returns the length of the passed {@link com.smartgwt.client.widgets.calendar.CalendarEvent event} in the passed  {@link
     * com.smartgwt.client.types.TimeUnit unit}.  If <code>unit</code> isn't passed, returns the length of the event  in
     * milliseconds.
     * @param event the event to get the length of
     * @param unit the time unit to return the length in, milliseconds if not passed
     */
    public native void getEventLength(CalendarEvent event, TimeUnit unit) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.getEventLength(event.@com.smartgwt.client.core.DataClass::getJsObj()(), unit == null ? null : unit.@com.smartgwt.client.types.TimeUnit::getValue()());
    }-*/;


	/**
     * Returns the {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getStartDate start date} of the passed event.
     * @param event the event to get the start date of
     *
     * @return the start date of the passed event
     */
    public native Date getEventStartDate(CalendarEvent event) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEventStartDate(event.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;


	/**
     * Returns the {@link com.smartgwt.client.widgets.calendar.Lane#getSublanes sublane} associated with the passed event, in
     * the passed view
     * @param event the event to get the sublane for
     *
     * @return the sublane associated with the passed event
     */
    public native Lane getEventSublane(CalendarEvent event) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEventSublane(event.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.calendar.Lane::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns the {@link com.smartgwt.client.widgets.calendar.Lane#getSublanes sublane} associated with the passed event, in
     * the passed view
     * @param event the event to get the sublane for
     * @param view the view to get the sublane object from
     *
     * @return the sublane associated with the passed event
     */
    public native Lane getEventSublane(CalendarEvent event, CalendarView view) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEventSublane(event.@com.smartgwt.client.core.DataClass::getJsObj()(), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.calendar.Lane::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


	/**
     * Returns the  styleName to use for the passed  {@link com.smartgwt.client.widgets.calendar.Calendar#getIndicators
     * indicator}, in the passed {@link com.smartgwt.client.widgets.calendar.CalendarView view}.  By default,  returns the
     * style {@link com.smartgwt.client.widgets.calendar.Calendar#getEventStyleNameField on the indicator}, if one is
     * specified, or the style specified on the {@link com.smartgwt.client.widgets.calendar.Calendar#getIndicatorStyleName
     * calendar} otherwise.
     * @param indicator the indicator to get the CSS style for
     *
     * @return 
     */
    public native String getIndicatorCanvasStyle(CalendarEvent indicator) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getIndicatorCanvasStyle(indicator.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;

	/**
     * Returns the  styleName to use for the passed  {@link com.smartgwt.client.widgets.calendar.Calendar#getIndicators
     * indicator}, in the passed {@link com.smartgwt.client.widgets.calendar.CalendarView view}.  By default,  returns the
     * style {@link com.smartgwt.client.widgets.calendar.Calendar#getEventStyleNameField on the indicator}, if one is
     * specified, or the style specified on the {@link com.smartgwt.client.widgets.calendar.Calendar#getIndicatorStyleName
     * calendar} otherwise.
     * @param indicator the indicator to get the CSS style for
     * @param view the CalendarView that contains the canvas being styled
     *
     * @return 
     */
    public native String getIndicatorCanvasStyle(CalendarEvent indicator, CalendarView view) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getIndicatorCanvasStyle(indicator.@com.smartgwt.client.core.DataClass::getJsObj()(), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        return ret;
    }-*/;


	/**
     * Gets the hover HTML for an {@link com.smartgwt.client.widgets.calendar.Calendar#getIndicators indicator} being hovered
     * over.  Override here to return custom HTML based upon the parameter indicator object.
     * @param indicator The indicator being hovered over
     * @param indicatorCanvas the indicator canvas being hovered over
     *
     * @return the HTML to show in the hover
     */
    public native String getIndicatorHoverHTML(CalendarEvent indicator, IndicatorCanvas indicatorCanvas) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getIndicatorHoverHTML(indicator.@com.smartgwt.client.core.DataClass::getJsObj()(), indicatorCanvas.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        return ret;
    }-*/;

	/**
     * Gets the hover HTML for an {@link com.smartgwt.client.widgets.calendar.Calendar#getIndicators indicator} being hovered
     * over.  Override here to return custom HTML based upon the parameter indicator object.
     * @param indicator The indicator being hovered over
     * @param indicatorCanvas the indicator canvas being hovered over
     * @param view the CalendarView in which the indicatorCanvas is displayed
     *
     * @return the HTML to show in the hover
     */
    public native String getIndicatorHoverHTML(CalendarEvent indicator, IndicatorCanvas indicatorCanvas, CalendarView view) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getIndicatorHoverHTML(indicator.@com.smartgwt.client.core.DataClass::getJsObj()(), indicatorCanvas.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        return ret;
    }-*/;


	/**
     * Returns the {@link com.smartgwt.client.widgets.calendar.Lane lane} with the passed name, in the passed view
     * @param lane the name of the lane to return
     *
     * @return the lane with the passed name, or null if not found
     */
    public native Lane getLane(String lane) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getLane(lane);
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.calendar.Lane::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns the {@link com.smartgwt.client.widgets.calendar.Lane lane} with the passed name, in the passed view
     * @param lane the name of the lane to return
     * @param view the view to get the lane object from
     *
     * @return the lane with the passed name, or null if not found
     */
    public native Lane getLane(String lane, CalendarView view) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getLane(lane, view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.calendar.Lane::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


	/**
     * For views that support {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes lanes}, returns the array of events
     * in the current dataset that apply to the passed lane in the passed or current view.
     * @param lane lane object or name to get the events for
     *
     * @return the list of events that apply to the passed lane and view
     */
    public native CalendarEvent[] getLaneEvents(Lane lane) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getLaneEvents(lane.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfCalendarEvent(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * For views that support {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes lanes}, returns the array of events
     * in the current dataset that apply to the passed lane in the passed or current view.
     * @param lane lane object or name to get the events for
     *
     * @return the list of events that apply to the passed lane and view
     */
    public native CalendarEvent[] getLaneEvents(String lane) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getLaneEvents(lane);
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfCalendarEvent(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * For views that support {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes lanes}, returns the array of events
     * in the current dataset that apply to the passed lane in the passed or current view.
     * @param lane lane object or name to get the events for
     * @param view the view in which the passed lane lives - uses the selected                               view if unset
     *
     * @return the list of events that apply to the passed lane and view
     */
    public native CalendarEvent[] getLaneEvents(Lane lane, CalendarView view) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getLaneEvents(lane.@com.smartgwt.client.core.DataClass::getJsObj()(), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfCalendarEvent(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns the {@link com.smartgwt.client.widgets.calendar.Lane} at the passed co-ordinates.  To get the lane under the
     * mouse, pass null for both x and y.
     *
     * @return the Lane at the the passed co-ords in the passed or selected view
     */
    public native Lane getLaneFromPoint() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getLaneFromPoint();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.calendar.Lane::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * @see {@link Calendar#getLaneFromPoint()}
     */
    public Lane getLaneFromPoint(Integer x){
        return getLaneFromPoint(x, (Integer) null, null);
    }

    /**
     * @see {@link Calendar#getLaneFromPoint()}
     */
    public Lane getLaneFromPoint(Integer x, Integer y){
        return getLaneFromPoint(x, y, null);
    }

	/**
     * Returns the {@link com.smartgwt.client.widgets.calendar.Lane} at the passed co-ordinates.  To get the lane under the
     * mouse, pass null for both x and y.
     * @param x the x offset into the body of the selected view
     * @param y the y offset into the body of the selected view. If this param and "x" are                             both unset,
     * assumes both offsets from the last mouse event.
     * @param view the view to get the lane from - selected view if not passed
     *
     * @return the Lane at the the passed co-ords in the passed or selected view
     */
    public native Lane getLaneFromPoint(Integer x, Integer y, CalendarView view) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getLaneFromPoint(x == null ? null : x.@java.lang.Integer::intValue()(), y == null ? null : y.@java.lang.Integer::intValue()(), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.calendar.Lane::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * For views that support {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes lanes}, returns the padding to
     * apply to events rendered in lanes in the passed or current view.  By default, returns  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getLaneEventPadding laneEventPadding}.
     *
     * @return the padding to apply to events in lanes in the passed or current view
     */
    public native Integer getLanePadding() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getLanePadding();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toInteger(I)(ret);
    }-*/;

	/**
     * For views that support {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes lanes}, returns the padding to
     * apply to events rendered in lanes in the passed or current view.  By default, returns  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getLaneEventPadding laneEventPadding}.
     * @param view the view to get the lane padding for
     *
     * @return the padding to apply to events in lanes in the passed or current view
     */
    public native Integer getLanePadding(CalendarView view) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getLanePadding(view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toInteger(I)(ret);
    }-*/;


	/**
     * This method returns the hover HTML to be displayed when the user hovers over a cell displayed in the calendar month view
     * tab. <P> Default implementation will display a list of the events occurring on the date the user is hovering over.
     * Override for custom behavior. Note that returning null will suppress the hover altogether.
     * @param date Date the user is hovering over
     * @param events array of events occurring on the current date. May be empty.
     *
     * @return HTML string to display
     */
    public native String getMonthViewHoverHTML(Date date, CalendarEvent... events) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getMonthViewHoverHTML(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(events));
        return ret;
    }-*/;

	/**
     * Returns the end of the period selected in the passed, or current, calendar view.   For the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getMonthView month view}, and for the  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWeekView week view} when not showing weekends, this will often be a 
     * different date than that returned by {@link com.smartgwt.client.widgets.calendar.Calendar#getVisibleEndDate
     * Calendar.getVisibleEndDate}.
     *
     * @return period end date
     */
    public native Date getPeriodEndDate() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getPeriodEndDate();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;

	/**
     * Returns the end of the period selected in the passed, or current, calendar view.   For the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getMonthView month view}, and for the  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWeekView week view} when not showing weekends, this will often be a 
     * different date than that returned by {@link com.smartgwt.client.widgets.calendar.Calendar#getVisibleEndDate
     * Calendar.getVisibleEndDate}.
     * @param view the view to get the periodEndDate for, or current view if null
     *
     * @return period end date
     */
    public native Date getPeriodEndDate(CalendarView view) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getPeriodEndDate(view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;

	/**
     * Returns the start of the selected week or month depending on the current calendar view.   For the month view, and for
     * the week view when not showing weekends, this will often be a  different date than that returned by {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getVisibleStartDate Calendar.getVisibleStartDate}.
     *
     * @return period start date
     */
    public native Date getPeriodStartDate() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getPeriodStartDate();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;

	/**
     * Returns the start of the selected week or month depending on the current calendar view.   For the month view, and for
     * the week view when not showing weekends, this will often be a  different date than that returned by {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getVisibleStartDate Calendar.getVisibleStartDate}.
     * @param view the view to get the periodStartDate for, or current view if null
     *
     * @return period start date
     */
    public native Date getPeriodStartDate(CalendarView view) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getPeriodStartDate(view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;

	/**
     * Returns the currently selected {@link com.smartgwt.client.widgets.calendar.CalendarView view}.
     *
     * @return the currently selected view
     */
    public native CalendarView getSelectedView() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSelectedView();
        return @com.smartgwt.client.widgets.calendar.CalendarView::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


	/**
     * Returns the {@link com.smartgwt.client.widgets.calendar.Lane#getSublanes sublane} with the passed name, from the {@link
     * com.smartgwt.client.widgets.calendar.Lane lane} with the passed name, in the passed view.
     * @param lane the name of the lane containing the sublane to return
     * @param sublane the name of the sublane to return
     *
     * @return the sublane with the passed name, or null if not found
     */
    public native Lane getSublane(String lane, String sublane) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSublane(lane, sublane);
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.calendar.Lane::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns the {@link com.smartgwt.client.widgets.calendar.Lane#getSublanes sublane} with the passed name, from the {@link
     * com.smartgwt.client.widgets.calendar.Lane lane} with the passed name, in the passed view.
     * @param lane the name of the lane containing the sublane to return
     * @param sublane the name of the sublane to return
     * @param view the view to get the sublane object from
     *
     * @return the sublane with the passed name, or null if not found
     */
    public native Lane getSublane(String lane, String sublane, CalendarView view) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSublane(lane, sublane, view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.calendar.Lane::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


	/**
     * For views that support {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes lanes} and allow  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getUseSublanes sublanes}, returns the array of events in the current
     * dataset that apply to the passed lane and sublane in the passed or current view.
     * @param lane lane object or name to get the events for
     * @param sublane sublane object or name to get the events for
     *
     * @return the list of events that apply to the passed sublane and view
     */
    public native CalendarEvent[] getSublaneEvents(Lane lane, Lane sublane) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSublaneEvents(lane.@com.smartgwt.client.core.DataClass::getJsObj()(), sublane.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfCalendarEvent(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * For views that support {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes lanes} and allow  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getUseSublanes sublanes}, returns the array of events in the current
     * dataset that apply to the passed lane and sublane in the passed or current view.
     * @param lane lane object or name to get the events for
     * @param sublane sublane object or name to get the events for
     * @param view the view in which the passed sublane lives - uses the selected                               view if unset
     *
     * @return the list of events that apply to the passed sublane and view
     */
    public native CalendarEvent[] getSublaneEvents(Lane lane, Lane sublane, CalendarView view) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSublaneEvents(lane.@com.smartgwt.client.core.DataClass::getJsObj()(), sublane.@com.smartgwt.client.core.DataClass::getJsObj()(), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfCalendarEvent(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns the {@link com.smartgwt.client.widgets.calendar.Lane#getSublanes sublane} at the passed co-ordinates.  To get
     * the sublane under the mouse, pass null for both x and y.
     *
     * @return the sublane at the passed co-ords in the selected view
     */
    public native Lane getSublaneFromPoint() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSublaneFromPoint();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.calendar.Lane::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * @see {@link Calendar#getSublaneFromPoint()}
     */
    public Lane getSublaneFromPoint(Integer x){
        return getSublaneFromPoint(x, (Integer) null, null);
    }

    /**
     * @see {@link Calendar#getSublaneFromPoint()}
     */
    public Lane getSublaneFromPoint(Integer x, Integer y){
        return getSublaneFromPoint(x, y, null);
    }

	/**
     * Returns the {@link com.smartgwt.client.widgets.calendar.Lane#getSublanes sublane} at the passed co-ordinates.  To get
     * the sublane under the mouse, pass null for both x and y.
     * @param x optional x offset into the body of the selected view
     * @param y optional y offset into the body of the selected view. If this param and "x" are                             both unset,
     * assumes both offsets from the last mouse event.
     * @param view the view to get the sublane from - selected view if not passed
     *
     * @return the sublane at the passed co-ords in the selected view
     */
    public native Lane getSublaneFromPoint(Integer x, Integer y, CalendarView view) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSublaneFromPoint(x == null ? null : x.@java.lang.Integer::intValue()(), y == null ? null : y.@java.lang.Integer::intValue()(), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.calendar.Lane::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


	/**
     * Returns the {@link com.smartgwt.client.widgets.calendar.CalendarView view} with the passed {@link
     * com.smartgwt.client.types.ViewName name}.
     * @param viewName the name of the CalendarView to return
     *
     * @return the currently selected view
     */
    public native CalendarView getView(ViewName viewName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getView(viewName.@com.smartgwt.client.types.ViewName::getValue()());
        return @com.smartgwt.client.widgets.calendar.CalendarView::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns the last visible date in the passed, or currently selected, calendar view.
     *
     * @return last visible date
     */
    public native Date getVisibleEndDate() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getVisibleEndDate();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;

	/**
     * Returns the last visible date in the passed, or currently selected, calendar view.
     * @param view the view to get the endDate for, or current view if null
     *
     * @return last visible date
     */
    public native Date getVisibleEndDate(CalendarView view) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getVisibleEndDate(view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;

	/**
     * Returns the first visible date in the passed, or currently selected, calendar view.
     *
     * @return first visible date
     */
    public native Date getVisibleStartDate() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getVisibleStartDate();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;

	/**
     * Returns the first visible date in the passed, or currently selected, calendar view.
     * @param view the view to get the startDate for, or current view if
     *
     * @return first visible date
     */
    public native Date getVisibleStartDate(CalendarView view) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getVisibleStartDate(view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;


	/**
     * Returns the  styleName to use for the passed  {@link com.smartgwt.client.widgets.calendar.Calendar#getZones zone}, in
     * the passed {@link com.smartgwt.client.widgets.calendar.CalendarView view}.  By default,  returns the style {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventStyleNameField on the zone}, if one is specified, or the style
     * specified on the {@link com.smartgwt.client.widgets.calendar.Calendar#getZoneStyleName calendar} otherwise.
     * @param zone the zone to get the CSS style for
     *
     * @return 
     */
    public native String getZoneCanvasStyle(CalendarEvent zone) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getZoneCanvasStyle(zone.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;

	/**
     * Returns the  styleName to use for the passed  {@link com.smartgwt.client.widgets.calendar.Calendar#getZones zone}, in
     * the passed {@link com.smartgwt.client.widgets.calendar.CalendarView view}.  By default,  returns the style {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventStyleNameField on the zone}, if one is specified, or the style
     * specified on the {@link com.smartgwt.client.widgets.calendar.Calendar#getZoneStyleName calendar} otherwise.
     * @param zone the zone to get the CSS style for
     * @param view the CalendarView that contains the canvas being styled
     *
     * @return 
     */
    public native String getZoneCanvasStyle(CalendarEvent zone, CalendarView view) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getZoneCanvasStyle(zone.@com.smartgwt.client.core.DataClass::getJsObj()(), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        return ret;
    }-*/;


	/**
     * Gets the hover HTML for a {@link com.smartgwt.client.widgets.calendar.Calendar#getZones zone} being hovered over.
     * Override here to  return custom HTML based upon the parameter zone object.
     * @param zone The zone being hovered over
     * @param zoneCanvas the zone canvas being hovered over
     *
     * @return the HTML to show in the hover
     */
    public native String getZoneHoverHTML(CalendarEvent zone, ZoneCanvas zoneCanvas) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getZoneHoverHTML(zone.@com.smartgwt.client.core.DataClass::getJsObj()(), zoneCanvas.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        return ret;
    }-*/;

	/**
     * Gets the hover HTML for a {@link com.smartgwt.client.widgets.calendar.Calendar#getZones zone} being hovered over.
     * Override here to  return custom HTML based upon the parameter zone object.
     * @param zone The zone being hovered over
     * @param zoneCanvas the zone canvas being hovered over
     * @param view the CalendarView in which the zoneCanvas is displayed
     *
     * @return the HTML to show in the hover
     */
    public native String getZoneHoverHTML(CalendarEvent zone, ZoneCanvas zoneCanvas, CalendarView view) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getZoneHoverHTML(zone.@com.smartgwt.client.core.DataClass::getJsObj()(), zoneCanvas.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        return ret;
    }-*/;


	/**
     * When {@link com.smartgwt.client.widgets.calendar.Calendar#getCanGroupLanes canGroupLanes} is true, this method allows
     * the grouping in {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timeline}s to be altered at
     * runtime.
     * @param groupFieldName one or more field names to group by
     */
    public native void groupLanesBy(String groupFieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.groupLanesBy(groupFieldName);
    }-*/;

	/**
     * When {@link com.smartgwt.client.widgets.calendar.Calendar#getCanGroupLanes canGroupLanes} is true, this method allows
     * the grouping in {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timeline}s to be altered at
     * runtime.
     * @param groupFieldName one or more field names to group by
     */
    public native void groupLanesBy(String... groupFieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.groupLanesBy(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(groupFieldName));
    }-*/;


	/**
     * Rests the current visible range of a calendar view so that it shows the date on which the passed event occurs.
     * @param event the event to move the calendar view to
     */
    public native void moveToEvent(CalendarEvent event) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.moveToEvent(event.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * Move to the next day, week, or month, depending on which tab is selected.
     */
    public native void next() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.next();
    }-*/;

	/**
     * Move to the previous day, week, month, or timeline range depending on which tab is selected.
     */
    public native void previous() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.previous();
    }-*/;


	/**
     * Removes a {@link com.smartgwt.client.widgets.calendar.Calendar#getIndicators indicator} from the calendar. <P> Accepts
     * either a {@link com.smartgwt.client.widgets.calendar.CalendarEvent indicator object} or a string that represents the 
     * {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getName name} of anindicator.
     * @param indicator either the actual CalendarEvent representing the                   indicator, or the name of the indicator to remove
     */
    public native void removeIndicator(CalendarEvent indicator) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeIndicator(indicator.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * Removes a {@link com.smartgwt.client.widgets.calendar.Calendar#getIndicators indicator} from the calendar. <P> Accepts
     * either a {@link com.smartgwt.client.widgets.calendar.CalendarEvent indicator object} or a string that represents the 
     * {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getName name} of anindicator.
     * @param indicator either the actual CalendarEvent representing the                   indicator, or the name of the indicator to remove
     */
    public native void removeIndicator(String indicator) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeIndicator(indicator);
    }-*/;


	/**
     * Removes a {@link com.smartgwt.client.widgets.calendar.Calendar#getZones zone} from the calendar. <P> Accepts either a
     * {@link com.smartgwt.client.widgets.calendar.CalendarEvent zone object} or a string that represents the  {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getName name} of a zone.
     * @param zone either the actual CalendarEvent representing the zone,                  or the name of the zone to remove
     */
    public native void removeZone(CalendarEvent zone) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeZone(zone.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * Removes a {@link com.smartgwt.client.widgets.calendar.Calendar#getZones zone} from the calendar. <P> Accepts either a
     * {@link com.smartgwt.client.widgets.calendar.CalendarEvent zone object} or a string that represents the  {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getName name} of a zone.
     * @param zone either the actual CalendarEvent representing the zone,                  or the name of the zone to remove
     */
    public native void removeZone(String zone) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeZone(zone);
    }-*/;


	/**
     * Scroll the calendar Day or Week views to the specified time.
     * @param time any parsable time-string
     */
    public native void scrollToTime(String time) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.scrollToTime(time);
    }-*/;


	/**
     * Selects the calendar view in the passed tab number.
     * @param tabnum the index of the tab to select
     */
    public native void selectTab(int tabnum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectTab(tabnum);
    }-*/;


	/**
     * Reset the resolution, the header levels and scrollable range, of the timeline view. <P> <code>headerLevels</code>
     * specifies the array of {@link com.smartgwt.client.widgets.calendar.HeaderLevel headers} to show above  the timeline, and
     * the <code>unit</code> and <code>unitCount</code> parameters dictate the  scrollable range (eg, passing "week" and 6 will
     * create a timeline with a scrollable range of  six weeks, irrespective of the number of columns that requires, according
     * to the  {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineGranularity granularity}). <P> If the optional
     * <code>granularityPerColumn</code> parameter is passed, each column will span that number of units of the granularity,
     * which is determined from the unit of the innermost of the passed headerLevels.  For example, to show a span of 12 hours
     * with inner columns that  each span 15 minutes, you could pass "hour" and "minute" -based headerLevels, unit and 
     * unitCount values of "hour" and 12 respectively, and granularityPerColumn of 15.
     * @param headerLevels the header levels to show in the timeline
     * @param unit the time unit to use when calculating the range of the timeline
     * @param unitCount the count of the passed unit that the timeline should span
     */
    public native void setResolution(HeaderLevel[] headerLevels, TimeUnit unit, Integer unitCount) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setResolution(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(headerLevels), unit.@com.smartgwt.client.types.TimeUnit::getValue()(), unitCount == null ? null : unitCount.@java.lang.Integer::intValue()());
    }-*/;

	/**
     * Reset the resolution, the header levels and scrollable range, of the timeline view. <P> <code>headerLevels</code>
     * specifies the array of {@link com.smartgwt.client.widgets.calendar.HeaderLevel headers} to show above  the timeline, and
     * the <code>unit</code> and <code>unitCount</code> parameters dictate the  scrollable range (eg, passing "week" and 6 will
     * create a timeline with a scrollable range of  six weeks, irrespective of the number of columns that requires, according
     * to the  {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineGranularity granularity}). <P> If the optional
     * <code>granularityPerColumn</code> parameter is passed, each column will span that number of units of the granularity,
     * which is determined from the unit of the innermost of the passed headerLevels.  For example, to show a span of 12 hours
     * with inner columns that  each span 15 minutes, you could pass "hour" and "minute" -based headerLevels, unit and 
     * unitCount values of "hour" and 12 respectively, and granularityPerColumn of 15.
     * @param headerLevels the header levels to show in the timeline
     * @param unit the time unit to use when calculating the range of the timeline
     * @param unitCount the count of the passed unit that the timeline should span
     * @param granularityPerColumn how many units of the granularity (the unit of the            innermost headerLevel) should each column span?  The
     * default is 1.
     */
    public native void setResolution(HeaderLevel[] headerLevels, TimeUnit unit, Integer unitCount, Integer granularityPerColumn) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setResolution(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(headerLevels), unit.@com.smartgwt.client.types.TimeUnit::getValue()(), unitCount == null ? null : unitCount.@java.lang.Integer::intValue()(), granularityPerColumn == null ? null : granularityPerColumn.@java.lang.Integer::intValue()());
    }-*/;


	/**
     * Sets the range over which the timeline will display events. <P> If the <code>end</code> parameter is not passed, the end
     * date of the range will default to  {@link com.smartgwt.client.widgets.calendar.Calendar#getDefaultTimelineColumnSpan 20}
     * columns of the current  {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineGranularity granularity}
     * following the start date.
     * @param start start of range
     */
    public native void setTimelineRange(Date start) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setTimelineRange(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(start));
    }-*/;

	/**
     * Sets the range over which the timeline will display events. <P> If the <code>end</code> parameter is not passed, the end
     * date of the range will default to  {@link com.smartgwt.client.widgets.calendar.Calendar#getDefaultTimelineColumnSpan 20}
     * columns of the current  {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineGranularity granularity}
     * following the start date.
     * @param start start of range
     * @param end end of range
     */
    public native void setTimelineRange(Date start, Date end) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setTimelineRange(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(start), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(end));
    }-*/;


	/**
     * Returns true if the passed date should be considered disabled.  Disabled dates don't allow  events to be created by
     * clicking on them, and drag operations that would start or end on such dates are also disallowed. <P> The default
     * implementation returns false only for dates that fall on a  {@link com.smartgwt.client.util.Date#getWeekendDays
     * weekend}.
     * @param date a Date instance
     *
     * @return true if this date should be considered disabled
     */
    public native boolean shouldDisableDate(Date date) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.shouldDisableDate(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date));
        return ret;
    }-*/;

	/**
     * Returns true if the passed date should be considered disabled.  Disabled dates don't allow  events to be created by
     * clicking on them, and drag operations that would start or end on such dates are also disallowed. <P> The default
     * implementation returns false only for dates that fall on a  {@link com.smartgwt.client.util.Date#getWeekendDays
     * weekend}.
     * @param date a Date instance
     * @param view the view the date appears in
     *
     * @return true if this date should be considered disabled
     */
    public native boolean shouldDisableDate(Date date, CalendarView view) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.shouldDisableDate(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        return ret;
    }-*/;


	/**
     * Indicates whether the passed date should be visible in the passed {@link
     * com.smartgwt.client.widgets.calendar.CalendarView}. <P> The default implementation returns true, unless the date falls
     * on a  {@link com.smartgwt.client.util.Date#getWeekendDays weekend} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowWeekends showWeekends} is  false.
     * @param date a Date instance
     *
     * @return true if this date should be considered disabled
     */
    public native boolean shouldShowDate(Date date) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.shouldShowDate(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date));
        return ret;
    }-*/;

	/**
     * Indicates whether the passed date should be visible in the passed {@link
     * com.smartgwt.client.widgets.calendar.CalendarView}. <P> The default implementation returns true, unless the date falls
     * on a  {@link com.smartgwt.client.util.Date#getWeekendDays weekend} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowWeekends showWeekends} is  false.
     * @param date a Date instance
     * @param view the view the date appears in
     *
     * @return true if this date should be considered disabled
     */
    public native boolean shouldShowDate(Date date, CalendarView view) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.shouldShowDate(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        return ret;
    }-*/;


	/**
     * Indicates whether the passed {@link com.smartgwt.client.widgets.calendar.CalendarEvent event} should be visible in the 
     * passed {@link com.smartgwt.client.widgets.calendar.CalendarView}. <P> The default implementation returns true - note
     * that this method only runs for events that are  known to be in the accessible range and is a mechanism for extended
     * custom filtering.
     * @param event the event to check
     *
     * @return true if this event should be displayed in the passed view
     */
    public native boolean shouldShowEvent(CalendarEvent event) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.shouldShowEvent(event.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;

	/**
     * Indicates whether the passed {@link com.smartgwt.client.widgets.calendar.CalendarEvent event} should be visible in the 
     * passed {@link com.smartgwt.client.widgets.calendar.CalendarView}. <P> The default implementation returns true - note
     * that this method only runs for events that are  known to be in the accessible range and is a mechanism for extended
     * custom filtering.
     * @param event the event to check
     * @param view the view the event will be rendered in
     *
     * @return true if this event should be displayed in the passed view
     */
    public native boolean shouldShowEvent(CalendarEvent event, CalendarView view) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.shouldShowEvent(event.@com.smartgwt.client.core.DataClass::getJsObj()(), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        return ret;
    }-*/;


	/**
     * Indicates whether the passed {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes lane} should be visible in
     * the passed  {@link com.smartgwt.client.widgets.calendar.CalendarView}. <P> The default implementation returns true,
     * unless the lane has no events and  {@link com.smartgwt.client.widgets.calendar.Calendar#getHideUnusedLanes
     * hideUnusedLanes} is true.
     * @param lane the lane object or name
     *
     * @return true if this lane should be displayed in the passed view
     */
    public native boolean shouldShowLane(Lane lane) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.shouldShowLane(lane.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;

	/**
     * Indicates whether the passed {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes lane} should be visible in
     * the passed  {@link com.smartgwt.client.widgets.calendar.CalendarView}. <P> The default implementation returns true,
     * unless the lane has no events and  {@link com.smartgwt.client.widgets.calendar.Calendar#getHideUnusedLanes
     * hideUnusedLanes} is true.
     * @param lane the lane object or name
     *
     * @return true if this lane should be displayed in the passed view
     */
    public native boolean shouldShowLane(String lane) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.shouldShowLane(lane);
        return ret;
    }-*/;

	/**
     * Indicates whether the passed {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes lane} should be visible in
     * the passed  {@link com.smartgwt.client.widgets.calendar.CalendarView}. <P> The default implementation returns true,
     * unless the lane has no events and  {@link com.smartgwt.client.widgets.calendar.Calendar#getHideUnusedLanes
     * hideUnusedLanes} is true.
     * @param lane the lane object or name
     * @param view the view the lane appears in
     *
     * @return true if this lane should be displayed in the passed view
     */
    public native boolean shouldShowLane(Lane lane, CalendarView view) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.shouldShowLane(lane.@com.smartgwt.client.core.DataClass::getJsObj()(), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        return ret;
    }-*/;

	/**
     * Open the Quick Event dialog showing minimal information about an existing  {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent event}. <P> The {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getStartDateField startDate} field on the event is used to calculate the 
     * display location for the dialog. <P> If this method is called when the Event Dialog is already showing another event,
     * and if  changes have been made, a confirmation dialog is displayed and editing of the new event  is cancelled unless
     * confirmed. <P> You can override this method to prevent the default action, perhaps instead showing a custom  interface
     * that performs validations or gathers custom data before making a call to  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#addCalendarEvent addCalendarEvent} or  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#updateCalendarEvent updateCalendarEvent} when the new data is available.
     */
    public native void showEventDialog() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showEventDialog();
    }-*/;

    /**
     * @see {@link Calendar#showEventDialog()}
     */
    public void showEventDialog(CalendarEvent event){
        showEventDialog(event, null);
    }

	/**
     * Open the Quick Event dialog showing minimal information about an existing  {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent event}. <P> The {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getStartDateField startDate} field on the event is used to calculate the 
     * display location for the dialog. <P> If this method is called when the Event Dialog is already showing another event,
     * and if  changes have been made, a confirmation dialog is displayed and editing of the new event  is cancelled unless
     * confirmed. <P> You can override this method to prevent the default action, perhaps instead showing a custom  interface
     * that performs validations or gathers custom data before making a call to  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#addCalendarEvent addCalendarEvent} or  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#updateCalendarEvent updateCalendarEvent} when the new data is available.
     * @param event the event to show in the Editor
     * @param isNewEvent optional boolean indicating that this is a new event, event if                               an event is passed - used
     * to pass defaults for a new event
     */
    public native void showEventDialog(CalendarEvent event, Boolean isNewEvent) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showEventDialog(event == null ? null : event.@com.smartgwt.client.core.DataClass::getJsObj()(), isNewEvent == null ? null : isNewEvent.@java.lang.Boolean::booleanValue()());
    }-*/;

	/**
     * Show an Event Editor for the passed event.  Event Editor's fill the Calendar and allow  for editing of the built-in
     * Event fields, like {@link com.smartgwt.client.widgets.calendar.Calendar#getNameField name} and  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDescriptionField description}, as well as any  custom fields supplied
     * via {@link com.smartgwt.client.widgets.calendar.Calendar#getEventEditorFields eventEditorFields}. <P> If isNewEvent is
     * true, a new event is created - in this case, if an event is passed, it represents default values to apply to the new
     * event. <P> You can override this method to prevent the default action, perhaps instead showing a custom  interface that
     * performs validations or gathers custom data before making a call to  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#addCalendarEvent addCalendarEvent} or  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#updateCalendarEvent updateCalendarEvent} when the new data is available.
     */
    public native void showEventEditor() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showEventEditor();
    }-*/;

    /**
     * @see {@link Calendar#showEventEditor()}
     */
    public void showEventEditor(CalendarEvent event){
        showEventEditor(event, null);
    }

	/**
     * Show an Event Editor for the passed event.  Event Editor's fill the Calendar and allow  for editing of the built-in
     * Event fields, like {@link com.smartgwt.client.widgets.calendar.Calendar#getNameField name} and  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDescriptionField description}, as well as any  custom fields supplied
     * via {@link com.smartgwt.client.widgets.calendar.Calendar#getEventEditorFields eventEditorFields}. <P> If isNewEvent is
     * true, a new event is created - in this case, if an event is passed, it represents default values to apply to the new
     * event. <P> You can override this method to prevent the default action, perhaps instead showing a custom  interface that
     * performs validations or gathers custom data before making a call to  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#addCalendarEvent addCalendarEvent} or  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#updateCalendarEvent updateCalendarEvent} when the new data is available.
     * @param event an existing event to show in the Editor
     * @param isNewEvent optional boolean indicating that this is a new event, even if                               an event is passed - used to
     * pass defaults for a new event
     */
    public native void showEventEditor(CalendarEvent event, Boolean isNewEvent) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showEventEditor(event == null ? null : event.@com.smartgwt.client.core.DataClass::getJsObj()(), isNewEvent == null ? null : isNewEvent.@java.lang.Boolean::booleanValue()());
    }-*/;

	/**
     * Open the Quick Event dialog to begin editing a new {@link com.smartgwt.client.widgets.calendar.CalendarEvent event}. <P>
     * If passed, the event parameter is used as defaults for the new event - in addition, the  event's {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getStartDateField startDate}, and its  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getLaneNameField lane}, for timeline events, are used to calculate the 
     * display location for the dialog. <P> If this method is called when the Event Dialog is already showing another event,
     * and if  changes have been made, a confirmation dialog is displayed and editing of the new event  is cancelled unless
     * confirmed. <P> You can override this method to prevent the default action, perhaps instead showing a custom  interface
     * that performs validations or gathers custom data before making a call to {@link
     * com.smartgwt.client.widgets.calendar.Calendar#addCalendarEvent addCalendarEvent} or  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#updateCalendarEvent updateCalendarEvent} when the new data is available.
     */
    public native void showNewEventDialog() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showNewEventDialog();
    }-*/;

	/**
     * Open the Quick Event dialog to begin editing a new {@link com.smartgwt.client.widgets.calendar.CalendarEvent event}. <P>
     * If passed, the event parameter is used as defaults for the new event - in addition, the  event's {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getStartDateField startDate}, and its  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getLaneNameField lane}, for timeline events, are used to calculate the 
     * display location for the dialog. <P> If this method is called when the Event Dialog is already showing another event,
     * and if  changes have been made, a confirmation dialog is displayed and editing of the new event  is cancelled unless
     * confirmed. <P> You can override this method to prevent the default action, perhaps instead showing a custom  interface
     * that performs validations or gathers custom data before making a call to {@link
     * com.smartgwt.client.widgets.calendar.Calendar#addCalendarEvent addCalendarEvent} or  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#updateCalendarEvent updateCalendarEvent} when the new data is available.
     * @param event defaults for the new event
     */
    public native void showNewEventDialog(CalendarEvent event) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showNewEventDialog(event == null ? null : event.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * Show an Event Editor for a new event.  If an {@link com.smartgwt.client.widgets.calendar.CalendarEvent event} is passed
     * as the  parameter, it is used as defaults for the new event.
     */
    public native void showNewEventEditor() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showNewEventEditor();
    }-*/;

	/**
     * Show an Event Editor for a new event.  If an {@link com.smartgwt.client.widgets.calendar.CalendarEvent event} is passed
     * as the  parameter, it is used as defaults for the new event.
     * @param event defaults for the new event to show in the Editor
     */
    public native void showNewEventEditor(CalendarEvent event) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showNewEventEditor(event == null ? null : event.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    /**
     * Add a timelineEventMoved handler.
     * <p>
     * Called when a Timeline event is moved via dragging by a user.  Call {@link
     * com.smartgwt.client.widgets.calendar.events.TimelineEventMoved#cancel()} from within {@link
     * com.smartgwt.client.widgets.calendar.events.TimelineEventMovedHandler#onTimelineEventMoved} to disallow the  move.
     *
     * @param handler the timelineEventMoved handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addTimelineEventMovedHandler(com.smartgwt.client.widgets.calendar.events.TimelineEventMovedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.calendar.events.TimelineEventMoved.getType()) == 0) setupTimelineEventMovedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.calendar.events.TimelineEventMoved.getType());
    }

    private native void setupTimelineEventMovedEvent() /*-{
        var obj = null;
        var selfJ = this;
        var timelineEventMoved = $debox($entry(function(param){
                var event = @com.smartgwt.client.widgets.calendar.events.TimelineEventMoved::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({timelineEventMoved: 
                function () {
                    var param = {"event" : arguments[0], "startDate" : arguments[1], "endDate" : arguments[2], "lane" : arguments[3]};
                    return timelineEventMoved(param) == true;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.timelineEventMoved = 
                function () {
                    var param = {"event" : arguments[0], "startDate" : arguments[1], "endDate" : arguments[2], "lane" : arguments[3]};
                    return timelineEventMoved(param) == true;
                }
            ;
        }
   }-*/;
    /**
     * Add a timelineEventResized handler.
     * <p>
     * Called when a Timeline event is resized via dragging by a user.  Call {@link
     * com.smartgwt.client.widgets.calendar.events.TimelineEventResized#cancel()} from within {@link
     * com.smartgwt.client.widgets.calendar.events.TimelineEventResizedHandler#onTimelineEventResized} to disallow  the resize.
     *
     * @param handler the timelineEventResized handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addTimelineEventResizedHandler(com.smartgwt.client.widgets.calendar.events.TimelineEventResizedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.calendar.events.TimelineEventResized.getType()) == 0) setupTimelineEventResizedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.calendar.events.TimelineEventResized.getType());
    }

    private native void setupTimelineEventResizedEvent() /*-{
        var obj = null;
        var selfJ = this;
        var timelineEventResized = $debox($entry(function(param){
                var event = @com.smartgwt.client.widgets.calendar.events.TimelineEventResized::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({timelineEventResized: 
                function () {
                    var param = {"event" : arguments[0], "startDate" : arguments[1], "endDate" : arguments[2]};
                    return timelineEventResized(param) == true;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.timelineEventResized = 
                function () {
                    var param = {"event" : arguments[0], "startDate" : arguments[1], "endDate" : arguments[2]};
                    return timelineEventResized(param) == true;
                }
            ;
        }
   }-*/;

	/**
     * Update an event in this calendar.
     * @param event The event object that will be updated
     * @param newEvent The new attributes for the event
     * @param otherFields new values of additional fields to be updated
     */
    public native void updateCalendarEvent(CalendarEvent event, CalendarEvent newEvent, Object otherFields) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.updateCalendarEvent(event.@com.smartgwt.client.core.DataClass::getJsObj()(), newEvent.@com.smartgwt.client.core.DataClass::getJsObj()(), otherFields);
    }-*/;


    // ********************* Static Methods ***********************

    /** 
     * Class level method to set the default properties of this class.  If set, then all
     * existing and subsequently created instances of this class will automatically have
     * default properties corresponding to
     * the properties set on the SmartGWT class instance passed to this function before its
     * underlying SmartClient JS object was created.
     * This is a powerful feature that eliminates the need for users to create a separate
     * hierarchy of subclasses that only alter the default properties of this class. Can also
     * be used for skinning / styling purposes.  <P> <b>Note:</b> This method is intended for
     * setting default attributes only and will affect all instances of the underlying class
     * (including those automatically generated in JavaScript).  This method should not be used
     * to apply standard EventHandlers or override methods for a class - use a custom subclass
     * instead.  Calling this method after instances have been created can result in undefined
     * behavior, since it bypasses any setters and a class instance may have already examined 
     * a particular property and not be expecting any changes through this route.
     *
     * @param calendarProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(Calendar calendarProperties) /*-{
    	var properties = $wnd.isc.addProperties({},calendarProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
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
            var eventsJ = events == null ? null : @com.smartgwt.client.util.ConvertTo::arrayOfCalendarEvent(Lcom/google/gwt/core/client/JavaScriptObject;)(events);
            var calendarJ = @com.smartgwt.client.widgets.calendar.Calendar::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(calendar);
            return jObj.@com.smartgwt.client.widgets.calendar.Calendar::getDayBodyHTML(Ljava/util/Date;[Lcom/smartgwt/client/widgets/calendar/CalendarEvent;Lcom/smartgwt/client/widgets/calendar/Calendar;II)(dateJ, eventsJ, calendarJ, rowNum, colNum);
        }));
        
        self.__getDateLabelText = self.getDateLabelText;
        self.getDateLabelText = $debox($entry(function(viewName, startDate, endDate) {
        	var jObj = this.__ref;
            if(jObj == null || jObj === undefined) return this.__getDateLabelText(viewName, startDate, endDate);
            var startDateJava = startDate == null ? null : @com.smartgwt.client.util.JSOHelper::toDate(D)(startDate.getTime());
            var endDateJava = endDate == null ? null :  @com.smartgwt.client.util.JSOHelper::toDate(D)(endDate.getTime());
            return jObj.@com.smartgwt.client.widgets.calendar.Calendar::getDateLabelText(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)(viewName, startDateJava, endDateJava);
        }));        
        
        self.__getWorkdayStart = self.getWorkdayStart;
        self.getWorkdayStart = $debox($entry(function(date) {
        	var jObj = this.__ref;
            if(jObj == null || jObj === undefined) return this.__getWorkdayStart(date);
            var dateJava = date == null ? null : @com.smartgwt.client.util.JSOHelper::toDate(D)(date.getTime());
            return jObj.@com.smartgwt.client.widgets.calendar.Calendar::getWorkdayStart(Ljava/util/Date;)(dateJava);
        }));

        self.__getWorkdayEnd = self.getWorkdayEnd;
        self.getWorkdayEnd = $debox($entry(function(date) {
        	var jObj = this.__ref;
            if(jObj == null || jObj === undefined) return this.__getWorkdayEnd(date);
            var dateJava = date == null ? null : @com.smartgwt.client.util.JSOHelper::toDate(D)(date.getTime());
            return jObj.@com.smartgwt.client.widgets.calendar.Calendar::getWorkdayEnd(Ljava/util/Date;)(dateJava);
        }));

        self.__dateIsWorkday = self.dateIsWorkday;
        self.dateIsWorkday = $debox($entry(function(date) {
        	var jObj = this.__ref;
            if(jObj == null || jObj === undefined) return this.__dateIsWorkday(date);
            var dateJava = date == null ? null : @com.smartgwt.client.util.JSOHelper::toDate(D)(date.getTime());
            var result = jObj.@com.smartgwt.client.widgets.calendar.Calendar::dateIsWorkday(Ljava/util/Date;)(dateJava);
            return (result == null ? false : result);
        }));

    }-*/;

    /**
     * When using {@link com.smartgwt.client.widgets.calendar.Calendar#getShowWorkday showWorkday}:true,
     * <code>workdayStart</code> and <code>workdayEnd</code> specify the time of day when the workday starts and ends,
     * specified as a String acceptable to String. <P> Both start and end time must fall on a 30 minute increment (eg 9:30, but
     * not 9:45). <P> The hours of the workday can be customized for particular dates by providing implementations of {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart Calendar.getWorkdayStart} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWorkdayEnd Calendar.getWorkdayEnd}.
     *
     * @param workdayEnd  Default value is "5:00pm"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setWorkdayEnd(String workdayEnd)  throws IllegalStateException {
        setAttribute("workdayEnd", workdayEnd, false);
    }

    /**
     * When using {@link com.smartgwt.client.widgets.calendar.Calendar#getShowWorkday showWorkday}:true,
     * <code>workdayStart</code> and <code>workdayEnd</code> specify the time of day when the workday starts and ends,
     * specified as a String acceptable to String. <P> Both start and end time must fall on a 30 minute increment (eg 9:30, but
     * not 9:45). <P> The hours of the workday can be customized for particular dates by providing implementations of {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart Calendar.getWorkdayStart} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWorkdayEnd Calendar.getWorkdayEnd}.
     *
     * @param date  the date to get the workday end for
     * 
     * @return Returns the end of the working day on the passed date.  By default, this method returns the value of {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWorkdayEnd workdayEnd}.
     */
    public native String getWorkdayEnd(Date date)  /*-{
    	var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
	    var dateJS = date == null ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date);
    	return self.__getWorkdayEnd(dateJS);
	}-*/;

    /**
     * When using {@link com.smartgwt.client.widgets.calendar.Calendar#getShowWorkday showWorkday}:true,
     * <code>workdayStart</code> and <code>workdayEnd</code> specify the time of day when the workday starts and ends,
     * specified as a String acceptable to String. <P> Both start and end time must fall on a 30 minute increment (eg 9:30, but
     * not 9:45). <P> The hours of the workday can be customized for particular dates by providing implementations of {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart Calendar.getWorkdayStart} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWorkdayEnd Calendar.getWorkdayEnd}.
     *
     * @param workdayStart  Default value is "9:00am"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setWorkdayStart(String workdayStart)  throws IllegalStateException {
        setAttribute("workdayStart", workdayStart, false);
    }

    /**
     * When using {@link com.smartgwt.client.widgets.calendar.Calendar#getShowWorkday showWorkday}:true,
     * <code>workdayStart</code> and <code>workdayEnd</code> specify the time of day when the workday starts and ends,
     * specified as a String acceptable to String. <P> Both start and end time must fall on a 30 minute increment (eg 9:30, but
     * not 9:45). <P> The hours of the workday can be customized for particular dates by providing implementations of {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart Calendar.getWorkdayStart} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWorkdayEnd Calendar.getWorkdayEnd}.
     *
     * @param date  the date to get the workday start for
     * 
     * @return Returns the start of the working day on the passed date.  By default, this method returns the value of {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart workdayStart}.
     */
    
    public native String getWorkdayStart(Date date)  /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
	    var dateJS = date == null ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date);
        return self.__getWorkdayStart(dateJS);
    }-*/;
    
    /**
     * Should the parameter date be considered a workday? By default this method tries to find the
     * parameter date day in {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdays workdays}, 
     * and returns true if found. Override this method to provide custom logic for determining workday, 
     * for example returning false on holidays.
     *
     * @param date  the date being tested
     * 
     * @return Returns true if the date passed should be considered a workday
     */
    public native boolean dateIsWorkday(Date date)  /*-{
    	var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
	    var dateJS = date == null ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date);
    	return self.__dateIsWorkday(dateJS);
	}-*/;

    /**
     * Returns the text to display with the navigation buttons above the Calendar - indicates the  visible date range.
     * <P>
     * <b>Note: </b> This is an override point.
     * 
     * @param viewName one of "day", "week", "month" or "timeline"
     * @param startDate the start of the visible date range
     * @param endDate the optional end of the visible date range. May be null.
     * 
     * @return a formmatted date or date-range string appropriate to the passed view
     */
    public native String getDateLabelText(String viewName, Date startDate, Date endDate) /*-{
    	var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
    	 
	    var startDateJS = startDate == null ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(startDate);
	    var endDateJS = endDate == null ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(endDate);
	    var ret = self.__getDateLabelText(viewName, startDateJS, endDateJS);
	    return ret;
	}-*/;

    /**
     * Customizer called whenever the Calender needs to show an EventEditor, to edit or create a CalendarEvent
     * 
     * @param customizer the customizer to execute.
     */
    public native void setEventEditorCustomizer(EventEditorCustomizer customizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }

        // grab the original method - if the customizer returns true, we'll run the original method for default behavior
        self.__showEventEditor = $wnd.isc.Calendar.getInstanceProperty('showEventEditor');
        self.showEventEditor = $debox($entry(function(eventJS, isNewEventJS) {
            var eventJ = eventJS == null ? null : @com.smartgwt.client.widgets.calendar.CalendarEvent::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(eventJS);
            if (isNewEventJS == null) isNewEventJS = eventJS == null;
            var isNewEventJ = @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(isNewEventJS);
            
            // stick a reference to the calendar on the customizer
            var calendarJ = @com.smartgwt.client.widgets.BaseWidget::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(this);
            customizer.@com.smartgwt.client.widgets.calendar.EventDialogCustomizer::setCalendar(Lcom/smartgwt/client/widgets/calendar/Calendar;)(calendarJ);

            var result = customizer.@com.smartgwt.client.widgets.calendar.EventEditorCustomizer::showEventEditor(Lcom/smartgwt/client/widgets/calendar/CalendarEvent;Ljava/lang/Boolean;)(eventJ, isNewEventJ);
            // if the customizer returns true, that means go ahead with the default behavior -
            // so, in that case, run the original method to show the builtin editor
            if (result == true) return this.__showEventEditor(eventJS, isNewEventJS);
        }));
    }-*/;

    /**
     * Customizer called whenever the Calender needs to show an EventDialog, to edit or view a CalendarEvent
     * 
     * @param customizer the customizer to execute.
     */
    public native void setEventDialogCustomizer(EventDialogCustomizer customizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }

        // grab the original method - if the customizer returns true, we'll run the original method for default behavior
        self.__showEventDialog = $wnd.isc.Calendar.getInstanceProperty('showEventDialog');
        self.showEventDialog = $debox($entry(function(eventJS, isNewEventJS) {
            var eventJ = eventJS == null ? null : @com.smartgwt.client.widgets.calendar.CalendarEvent::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(eventJS);
            if (isNewEventJS == null) isNewEventJS = eventJS == null;
            var isNewEventJ = @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(isNewEventJS);

            // stick a reference to the calendar on the customizer
            var calendarJ = @com.smartgwt.client.widgets.BaseWidget::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(this);
            customizer.@com.smartgwt.client.widgets.calendar.EventDialogCustomizer::setCalendar(Lcom/smartgwt/client/widgets/calendar/Calendar;)(calendarJ);

            var result = customizer.@com.smartgwt.client.widgets.calendar.EventDialogCustomizer::showEventDialog(Lcom/smartgwt/client/widgets/calendar/CalendarEvent;Ljava/lang/Boolean;)(eventJ, isNewEventJ);
            // if the customizer returns true, that means go ahead with the default behavior -
            // so, in that case, run the original method to show the builtin dialog
            if (result == true) this.__showEventDialog(eventJS, isNewEventJS);
        }));
    }-*/;

    /**
     * This method returns the HTML to be used as the header/title for the passed event.
     * 
     * @param customizer the customizer to execute.
     */
    public native void setEventHeaderHTMLCustomizer(EventHeaderHTMLCustomizer customizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }

        self.getEventHeaderHTML = $debox($entry(function(jEvent, jCalendarView) {
        	var calendarEvent = @com.smartgwt.client.widgets.calendar.CalendarEvent::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(jEvent);
        	var calendarView = @com.smartgwt.client.widgets.calendar.CalendarView::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(jCalendarView);

            return customizer.@com.smartgwt.client.widgets.calendar.EventHeaderHTMLCustomizer::getEventHeaderHTML(Lcom/smartgwt/client/widgets/calendar/CalendarEvent;Lcom/smartgwt/client/widgets/calendar/CalendarView;)(calendarEvent,calendarView);
        }));
    }-*/;

    /**
     * This method returns the HTML to be used as the body/description for the passed event.
     * 
     * @param customizer the customizer to execute.
     */
    public native void setEventBodyHTMLCustomizer(EventBodyHTMLCustomizer customizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }

        self.getEventBodyHTML = $debox($entry(function(jEvent, jCalendarView) {
        	var calendarEvent = @com.smartgwt.client.widgets.calendar.CalendarEvent::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(jEvent);
        	var calendarView = @com.smartgwt.client.widgets.calendar.CalendarView::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(jCalendarView);

            return customizer.@com.smartgwt.client.widgets.calendar.EventBodyHTMLCustomizer::getEventBodyHTML(Lcom/smartgwt/client/widgets/calendar/CalendarEvent;Lcom/smartgwt/client/widgets/calendar/CalendarView;)(calendarEvent,calendarView);
        }));
    }-*/;

    /**
     * This method returns the CSS class name for the passed event when rendered in the passed view
     * 
     * @param customizer the customizer to execute.
     */
    public native void setDateStyleCustomizer(DateStyleCustomizer customizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }

        self.getDateStyle = $debox($entry(function(date, rowNum, colNum, calendarView) {
            var dateJ   = @com.smartgwt.client.util.JSOHelper::toDate(D)(date.getTime());
        	var calendarViewJ = @com.smartgwt.client.widgets.calendar.CalendarView::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(calendarView);

            var result = customizer.@com.smartgwt.client.widgets.calendar.DateStyleCustomizer::getDateStyle(Ljava/util/Date;IILcom/smartgwt/client/widgets/calendar/CalendarView;)(dateJ, rowNum, colNum, calendarViewJ);
            if (result != null) return result;
            return null;
        }));
    }-*/;

    /**
     * This method returns the CSS class name for the passed event when rendered in the passed view
     * 
     * @param customizer the customizer to execute.
     */
    public native void setDateCSSTextCustomizer(DateCSSTextCustomizer customizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }

        self.getDateCSSText = $debox($entry(function(date, rowNum, colNum, calendarView) {
            var dateJ   = @com.smartgwt.client.util.JSOHelper::toDate(D)(date.getTime());
        	var calendarViewJ = @com.smartgwt.client.widgets.calendar.CalendarView::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(calendarView);

            return customizer.@com.smartgwt.client.widgets.calendar.DateCSSTextCustomizer::getDateCSSText(Ljava/util/Date;IILcom/smartgwt/client/widgets/calendar/CalendarView;)(dateJ, rowNum, colNum, calendarViewJ);
        }));
    }-*/;

    /**
     * Return true from the customizer to have the passed event considered disabled in the passed view
     * 
     * @param customizer the customizer to execute.
     */
    public native void setDisableDateCustomizer(DisableDateCustomizer customizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }

        self.shouldDisableDate = $debox($entry(function(date, calendarView) {
            var dateJ = @com.smartgwt.client.util.JSOHelper::toDate(D)(date.getTime());
        	var calendarViewJ = @com.smartgwt.client.widgets.calendar.CalendarView::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(calendarView);

            return customizer.@com.smartgwt.client.widgets.calendar.DisableDateCustomizer::disableDate(Ljava/util/Date;Lcom/smartgwt/client/widgets/calendar/CalendarView;)(dateJ, calendarViewJ);
        }));
    }-*/;

    /**
     * This method is called during rendering for all events in the visible range - those which
     * would be rendered by default.  The customizer should return false to prevent the passed 
     * event from appearing in the passed view.
     * 
     * @param customizer the customizer to execute.
     */
    public native void setShowDateCustomizer(ShowDateCustomizer customizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }

        self.shouldShowDate = $debox($entry(function(date, calendarView) {
            var dateJ   = @com.smartgwt.client.util.JSOHelper::toDate(D)(date.getTime());
        	var calendarViewJ = @com.smartgwt.client.widgets.calendar.CalendarView::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(calendarView);

            return customizer.@com.smartgwt.client.widgets.calendar.ShowDateCustomizer::showDate(Ljava/util/Date;Lcom/smartgwt/client/widgets/calendar/CalendarView;)(dateJ, calendarViewJ);
        }));
    }-*/;

    /**
     * Return false from the customizer to prevent the passed Lane from being rendered in the 
     * passed view.
     * 
     * @param customizer the customizer to execute.
     */
    public native void setShowLaneCustomizer(ShowLaneCustomizer customizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }

        self.shouldShowLane = $debox($entry(function(lane, calendarView) {
            var laneJ = @com.smartgwt.client.widgets.calendar.Lane::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(lane);
        	var calendarViewJ = @com.smartgwt.client.widgets.calendar.CalendarView::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(calendarView);

            return customizer.@com.smartgwt.client.widgets.calendar.ShowLaneCustomizer::showLane(Lcom/smartgwt/client/widgets/calendar/Lane;Lcom/smartgwt/client/widgets/calendar/CalendarView;)(laneJ, calendarViewJ);
        }));
    }-*/;

    /**
     * Return false from the customizer to prevent the passed CalendarEvent from being rendered in the 
     * passed view.
     * 
     * @param customizer the customizer to execute.
     */
    public native void setShowEventCustomizer(ShowEventCustomizer customizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }

        self.shouldShowEvent = $debox($entry(function(event, calendarView) {
            var eventJ = @com.smartgwt.client.widgets.calendar.CalendarEvent::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
        	var calendarViewJ = @com.smartgwt.client.widgets.calendar.CalendarView::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(calendarView);

            return customizer.@com.smartgwt.client.widgets.calendar.ShowEventCustomizer::showEvent(Lcom/smartgwt/client/widgets/calendar/CalendarEvent;Lcom/smartgwt/client/widgets/calendar/CalendarView;)(eventJ, calendarViewJ);
        }));
    }-*/;

    /**
     * This method returns the hover HTML to be displayed when the user hovers over an event
     * 
     * @param eventHoverHTMLCustomizer the customizer to execute.
     */
    public native void setEventHoverHTMLCustomizer(EventHoverHTMLCustomizer eventHoverHTMLCustomizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }

        self.getEventHoverHTML = $debox($entry(function(jsEvent, jsEventWindow) {
        	
            var calendarJ = @com.smartgwt.client.widgets.BaseWidget::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(this);
            eventHoverHTMLCustomizer.@com.smartgwt.client.widgets.calendar.EventHoverHTMLCustomizer::setCalendar(Lcom/smartgwt/client/widgets/calendar/Calendar;)(calendarJ);
        	var calendarEvent = @com.smartgwt.client.widgets.calendar.CalendarEvent::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(jsEvent);
        	var eventWindow = null;
            // support calling one of two methods - the old EventWindow one and the new EventCanvas one
            //if ($wnd.isc.isAn.EventWindow(jsEventWindow)) {
                // call the old eventWindow method
                eventWindow = @com.smartgwt.client.widgets.calendar.EventWindow::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(jsEventWindow);
                return eventHoverHTMLCustomizer.@com.smartgwt.client.widgets.calendar.EventHoverHTMLCustomizer::getEventHoverHTML(Lcom/smartgwt/client/widgets/calendar/CalendarEvent;Lcom/smartgwt/client/widgets/calendar/EventWindow;)(calendarEvent,eventWindow);
            //} else {
            //    // call the new eventCanvas method
            //    eventWindow = @com.smartgwt.client.widgets.calendar.EventCanvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(jsEventWindow);
            //    return eventHoverHTMLCustomizer.@com.smartgwt.client.widgets.calendar.EventHoverHTMLCustomizer::getEventHoverHTML(Lcom/smartgwt/client/widgets/calendar/CalendarEvent;Lcom/smartgwt/client/widgets/calendar/EventCanvas;)(calendarEvent,eventWindow);
            //}
        }));
    }-*/;

    /**
     * This method returns the hover HTML to be displayed when the user hovers over an ZoneCanvas
     * 
     * @param zoneHoverHTMLCustomizer the customizer to execute.
     */
    public native void setZoneHoverHTMLCustomizer(ZoneHoverHTMLCustomizer zoneHoverHTMLCustomizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }

        self.getZoneHoverHTML = $debox($entry(function(jsEvent, jsCanvas) {
            var calendarJ = @com.smartgwt.client.widgets.BaseWidget::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(this);
            zoneHoverHTMLCustomizer.@com.smartgwt.client.widgets.calendar.ZoneHoverHTMLCustomizer::setCalendar(Lcom/smartgwt/client/widgets/calendar/Calendar;)(calendarJ);
        	var eventJ = @com.smartgwt.client.widgets.calendar.CalendarEvent::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(jsEvent);
        	var canvasJ = @com.smartgwt.client.widgets.calendar.ZoneCanvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(jsCanvas);
            
            return zoneHoverHTMLCustomizer.@com.smartgwt.client.widgets.calendar.ZoneHoverHTMLCustomizer::getZoneHoverHTML(Lcom/smartgwt/client/widgets/calendar/CalendarEvent;Lcom/smartgwt/client/widgets/calendar/ZoneCanvas;)(eventJ,canvasJ);
        }));
    }-*/;

    /**
     * This method returns the hover HTML to be displayed when the user hovers over an IndicatorCanvas
     * 
     * @param indicatorHoverHTMLCustomizer the customizer to execute.
     */
    public native void setIndicatorHoverHTMLCustomizer(IndicatorHoverHTMLCustomizer indicatorHoverHTMLCustomizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }

        self.getIndicatorHoverHTML = $debox($entry(function(jsEvent, jsCanvas) {
            var calendarJ = @com.smartgwt.client.widgets.BaseWidget::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(this);
            indicatorHoverHTMLCustomizer.@com.smartgwt.client.widgets.calendar.IndicatorHoverHTMLCustomizer::setCalendar(Lcom/smartgwt/client/widgets/calendar/Calendar;)(calendarJ);
        	var eventJ = @com.smartgwt.client.widgets.calendar.CalendarEvent::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(jsEvent);
        	var canvasJ = @com.smartgwt.client.widgets.calendar.IndicatorCanvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(jsCanvas);
            
            return indicatorHoverHTMLCustomizer.@com.smartgwt.client.widgets.calendar.IndicatorHoverHTMLCustomizer::getIndicatorHoverHTML(Lcom/smartgwt/client/widgets/calendar/CalendarEvent;Lcom/smartgwt/client/widgets/calendar/IndicatorCanvas;)(eventJ,canvasJ);
        }));
    }-*/;

    /**
     * This method returns the hover HTML to be displayed when the user hovers over a cell displayed in the calendar month view tab.
     * <P>
     * Default implementation will display a list of the events occurring on the date the user is hovering over. Override for custom 
     * behavior. Note that returning null will suppress the hover altogether.
     * 
     * @param monthViewHoverHTMLCustomizer the customizer to execute.
     */
    public native void setMonthViewHoverHTMLCustomizer(MonthViewHoverHTMLCustomizer monthViewHoverHTMLCustomizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        self.getMonthViewHoverHTML = $debox($entry(function(currentDate,events) {
        	
            var calendarEvents = @com.smartgwt.client.util.ConvertTo::arrayOfCalendarEvent(Lcom/google/gwt/core/client/JavaScriptObject;)(events);
            var calendarJ      = @com.smartgwt.client.widgets.BaseWidget::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(this);
            var currentDateJ   = @com.smartgwt.client.util.JSOHelper::toDate(D)(currentDate.getTime());

            monthViewHoverHTMLCustomizer.@com.smartgwt.client.widgets.calendar.MonthViewHoverHTMLCustomizer::setCalendar(Lcom/smartgwt/client/widgets/calendar/Calendar;)(calendarJ);
            
            return monthViewHoverHTMLCustomizer.@com.smartgwt.client.widgets.calendar.MonthViewHoverHTMLCustomizer::getMonthViewHoverHTML(Ljava/util/Date;[Lcom/smartgwt/client/widgets/calendar/CalendarEvent;)(currentDateJ,calendarEvents);
        }));
    }-*/;
    
    
    public void setLaneGroupStartOpen(GroupStartOpen group) {
        setAttribute("laneGroupStartOpen", group, true);
    }

    /**
     * @param groupValues Array of values that should be opened
     */
    public void setLaneGroupStartOpen(Object... groupValues) {
        setAttribute("laneGroupStartOpen", groupValues, true);
    }

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
     * Removes a lane from the calendar in {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timelineView}
     * mode.
     * @param lane the lane to remove
     */
    public native void removeLane(Lane lane) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeLane(lane);
    }-*/;

    /**
     * Removes a lane from the calendar in {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timelineView}
     * mode.
     * @param laneName the name of the lane to remove
     */
    public native void removeLane(String laneName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeLane(laneName);
    }-*/;

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

    private void checkCalendarLoaded () {
        if (!calendarLoaded()) {
            String errorMessage = "Attempt to create Calendar. This class requires the optional " +
                                    "Calendar module which is not present in this build.";
            SC.logWarn(errorMessage);
            throw new UnsupportedOperationException(errorMessage);
        }
    }

    /**
     * Static method indicating whether the optional Calendar module is loaded for the page.
     * The Calendar component requires this module.
     * @return true if the Calendar module is present
     */
    public static native boolean calendarLoaded() /*-{
        return ($wnd.isc.Calendar != null);
    }-*/;



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
     * Shows a FieldPicker interface allowing end-users to rearrange the order and visibiility
     * of the fields in the associated DataBoundComponent.
     */
    public native void editFields() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.editFields();
    }-*/;

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
        return @com.smartgwt.client.util.ConvertTo::arrayOfHilite(Lcom/google/gwt/core/client/JavaScriptObject;)(hilitesJS);
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
    /**
     * Filters all objects according to the AdvancedCriteria passed
     *
     * @param adCriteria AdvancedCriteria to use to filter results
     *
     * @return all matching Objects or null if none found
     */
    public native Record[] findAll(AdvancedCriteria adCriteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = self.findAll(adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(adCriteria)){
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(adCriteria,"_constructor","AdvancedCriteria");
	    }
        return recordsJS == null || recordsJS === undefined ? null : @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
    }-*/;
    
    /**
     * Filters all objects according to the AdvancedCriteria passed and returns the first matching object or null if not found
     *
     * @param adCriteria AdvancedCriteria to use to filter results
     *
     * @return first matching object or null if not found
     */
    public native Record find(AdvancedCriteria adCriteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = self.find(adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(adCriteria)){
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(adCriteria,"_constructor","AdvancedCriteria");
	    }
        return recordJS == null || recordJS === undefined ? null : @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(recordJS);
    }-*/;
    
    /**
     * Finds the index of the first Record that matches with the AdvacendCriteria passed.
     * @param adCriteria AdvancedCriteria to use to filter results
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findIndex(AdvancedCriteria adCriteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(adCriteria)){
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(adCriteria.@com.smartgwt.client.data.Criterion::getJsObj()(),"_constructor","AdvancedCriteria");
	    }
        return self.findIndex(adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
    
    /**
     * Like {@link RecordList#findIndex}, but considering the startIndex and endIndex parameters.
     * @param startIndex first index to consider
     * @param adCriteria AdvancedCriteria to use to filter results
     * @param endIndex last index to consider
     * 
     * @return index of the first matching Record or -1 if not found
     */
    public native int findNextIndex(int startIndex, AdvancedCriteria adCriteria, int endIndex) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(adCriteria)){
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(adCriteria,"_constructor","AdvancedCriteria");
	    }
        return self.findNextIndex(startIndex, adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()(), null, endIndex);
    }-*/;
    
    /**
     * Like {@link RecordList#findIndex}, but considering the startIndex parameter.
     * @param startIndex first index to consider
     * @param adCriteria AdvancedCriteria to use to filter results
     * 
     * @return index of the first matching Record or -1 if not found
     */
    public native int findNextIndex(int startIndex, AdvancedCriteria adCriteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(adCriteria)){
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(adCriteria.@com.smartgwt.client.data.Criterion::getJsObj()(),"_constructor","AdvancedCriteria");
	    }
        return self.findNextIndex(startIndex, adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

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
    	if(dataSource==null) {
    		throw new IllegalArgumentException("Invalid call to setDataSource() passing null.  If you're having trouble with loading DataSources, please see the following FAQ: http://forums.smartclient.com/showthread.php?t=8159#aDSLoad");
    	}
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

    public void setAutoFetchTextMatchStyle(TextMatchStyle autoFetchTextMatchStyle) throws IllegalStateException {
        setAttribute("autoFetchTextMatchStyle", autoFetchTextMatchStyle.getValue(), false);
    }

    public TextMatchStyle getAutoFetchTextMatchStyle() {
        return TextMatchStyle.valueOf(getAttributeAsString("autoFetchTextMatchStyle"));
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
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(criteria)){
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteria.@com.smartgwt.client.data.Criterion::getJsObj()(),"_constructor","AdvancedCriteria");
	    }
        self.fetchData(criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()());
    }-*/;

    public native void fetchData(Criteria criteria, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(criteria)){
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteria.@com.smartgwt.client.data.Criterion::getJsObj()(),"_constructor","AdvancedCriteria");
	    }
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
    	if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(criteria)){
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteria.@com.smartgwt.client.data.Criterion::getJsObj()(),"_constructor","AdvancedCriteria");
	    }
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
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(criteria)){
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteria.@com.smartgwt.client.data.Criterion::getJsObj()(),"_constructor","AdvancedCriteria");
	    }
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
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(criteria)){
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteria.@com.smartgwt.client.data.Criterion::getJsObj()(),"_constructor","AdvancedCriteria");
	    }
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
        return ResultSet.getOrCreateRef(dataJS);
    }

    public native RecordList getRecordList() /*-{
        var dataJS = this.@com.smartgwt.client.widgets.DataBoundComponent::getDataAsJSList()();
        if (dataJS == null) return null;
        if ($wnd.isc.isA.ResultSet(dataJS)) {
            return this.@com.smartgwt.client.widgets.DataBoundComponent::getResultSet()();
        } else if ($wnd.isc.isA.ResultTree(dataJS)) {
            return @com.smartgwt.client.widgets.tree.ResultTree::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(dataJS);
        } else if ($wnd.isc.isA.Tree(dataJS)) {
            return @com.smartgwt.client.widgets.tree.Tree::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(dataJS);
        }
        return @com.smartgwt.client.data.RecordList::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dataJS);
    }-*/;

    public native JavaScriptObject getDataAsJSList() /*-{
    	var self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
    	if (self == null) return null;
    	return self.getDataAsList();
    	
    }-*/;

    public native void exportData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.exportData();
    }-*/;

    public native void exportData(DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.exportData(requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
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

    /**
     * Add a {@link com.smartgwt.client.widgets.DropCompleteHandler}.  See that class's documentation for a definition of "drop complete",
     * and how it differs from "drag complete" ({@link com.smartgwt.client.widgets.DragCompleteHandler}).
     *
     * @param handler the DropCompleteHandler
     * @return {@link com.google.gwt.event.shared.HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDropCompleteHandler(DropCompleteHandler handler) {
        if(getHandlerCount(DropCompleteEvent.getType()) == 0) setupDropCompleteEvent();
        return doAddHandler(handler, DropCompleteEvent.getType());
    }

    private native void setupDropCompleteEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({dropComplete:$debox($entry(function(){
                    var param = {"transferredRecords" : arguments[0]};
                    var event = @com.smartgwt.client.widgets.events.DropCompleteEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                }))
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.dropComplete = $debox($entry(function(){
                var param = {"transferredRecords" : arguments[0]};
                var event = @com.smartgwt.client.widgets.events.DropCompleteEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            }));
        }
    }-*/;

    /**
     * Add a {@link com.smartgwt.client.widgets.DragCompleteHandler}.  See that class's documentation for a definition of "drag complete",
     * and how it differs from "drop complete" ({@link com.smartgwt.client.widgets.DropCompleteHandler}).
     *
     * @param handler the DropCompleteHandler
     * @return {@link com.google.gwt.event.shared.HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDragCompleteHandler(DragCompleteHandler handler) {
        if(getHandlerCount(DragCompleteEvent.getType()) == 0) setupDragCompleteEvent();
        return doAddHandler(handler, DragCompleteEvent.getType());
    }

    private native void setupDragCompleteEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({dragComplete:$debox($entry(function(){
                    var event = @com.smartgwt.client.widgets.events.DragCompleteEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)();
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                }))
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.dragComplete = $debox($entry(function(){
                var event = @com.smartgwt.client.widgets.events.DragCompleteEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)();
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            }));
        }
    }-*/;

    public LogicalStructureObject setLogicalStructure(CalendarLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.addEventButtonHoverText = getAttributeAsString("addEventButtonHoverText");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.addEventButtonHoverText:" + t.getMessage() + "\n";
        }
        try {
            s.allowDurationEvents = getAttributeAsString("allowDurationEvents");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.allowDurationEvents:" + t.getMessage() + "\n";
        }
        try {
            s.alternateLaneStyles = getAttributeAsString("alternateLaneStyles");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.alternateLaneStyles:" + t.getMessage() + "\n";
        }
        try {
            s.baseStyle = getAttributeAsString("baseStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.baseStyle:" + t.getMessage() + "\n";
        }
        try {
            s.cancelButtonTitle = getAttributeAsString("cancelButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.cancelButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.canCreateEvents = getAttributeAsString("canCreateEvents");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.canCreateEvents:" + t.getMessage() + "\n";
        }
        try {
            s.canDeleteEvents = getAttributeAsString("canDeleteEvents");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.canDeleteEvents:" + t.getMessage() + "\n";
        }
        try {
            s.canDragEventField = getAttributeAsString("canDragEventField");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.canDragEventField:" + t.getMessage() + "\n";
        }
        try {
            s.canDragEvents = getAttributeAsString("canDragEvents");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.canDragEvents:" + t.getMessage() + "\n";
        }
        try {
            s.canEditEvents = getAttributeAsString("canEditEvents");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.canEditEvents:" + t.getMessage() + "\n";
        }
        try {
            s.canEditField = getAttributeAsString("canEditField");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.canEditField:" + t.getMessage() + "\n";
        }
        try {
            s.canEditLane = getAttributeAsString("canEditLane");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.canEditLane:" + t.getMessage() + "\n";
        }
        try {
            s.canEditLaneField = getAttributeAsString("canEditLaneField");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.canEditLaneField:" + t.getMessage() + "\n";
        }
        try {
            s.canEditSublane = getAttributeAsString("canEditSublane");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.canEditSublane:" + t.getMessage() + "\n";
        }
        try {
            s.canEditSublaneField = getAttributeAsString("canEditSublaneField");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.canEditSublaneField:" + t.getMessage() + "\n";
        }
        try {
            s.canGroupLanes = getAttributeAsString("canGroupLanes");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.canGroupLanes:" + t.getMessage() + "\n";
        }
        try {
            s.canRemoveEvents = getAttributeAsString("canRemoveEvents");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.canRemoveEvents:" + t.getMessage() + "\n";
        }
        try {
            s.canRemoveField = getAttributeAsString("canRemoveField");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.canRemoveField:" + t.getMessage() + "\n";
        }
        try {
            s.canReorderLanes = getAttributeAsString("canReorderLanes");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.canReorderLanes:" + t.getMessage() + "\n";
        }
        try {
            s.canResizeEventField = getAttributeAsString("canResizeEventField");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.canResizeEventField:" + t.getMessage() + "\n";
        }
        try {
            s.canResizeEvents = getAttributeAsString("canResizeEvents");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.canResizeEvents:" + t.getMessage() + "\n";
        }
        try {
            s.canResizeTimelineEvents = getAttributeAsString("canResizeTimelineEvents");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.canResizeTimelineEvents:" + t.getMessage() + "\n";
        }
        try {
            s.chosenDate = getAttributeAsString("chosenDate");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.chosenDate:" + t.getMessage() + "\n";
        }
        try {
            s.columnsPerPage = getAttributeAsString("columnsPerPage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.columnsPerPage:" + t.getMessage() + "\n";
        }
        try {
            s.currentViewName = getAttributeAsString("currentViewName");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.currentViewName:" + t.getMessage() + "\n";
        }
        try {
            s.data = getAttributeAsStringArray("data");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.dataArray:" + t.getMessage() + "\n";
        }
        try {
            s.dataFetchMode = getAttributeAsString("dataFetchMode");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.dataFetchMode:" + t.getMessage() + "\n";
        }
        try {
            s.dateEditingStyle = getAttributeAsString("dateEditingStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.dateEditingStyle:" + t.getMessage() + "\n";
        }
        try {
            s.dateFormatter = getAttributeAsString("dateFormatter");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.dateFormatter:" + t.getMessage() + "\n";
        }
        try {
            s.datePickerHoverText = getAttributeAsString("datePickerHoverText");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.datePickerHoverText:" + t.getMessage() + "\n";
        }
        try {
            s.dayBodyBaseStyle = getAttributeAsString("dayBodyBaseStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.dayBodyBaseStyle:" + t.getMessage() + "\n";
        }
        try {
            s.dayHeaderBaseStyle = getAttributeAsString("dayHeaderBaseStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.dayHeaderBaseStyle:" + t.getMessage() + "\n";
        }
        try {
            s.dayViewTitle = getAttributeAsString("dayViewTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.dayViewTitle:" + t.getMessage() + "\n";
        }
        try {
            s.defaultTimelineColumnSpan = getAttributeAsString("defaultTimelineColumnSpan");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.defaultTimelineColumnSpan:" + t.getMessage() + "\n";
        }
        try {
            s.descriptionField = getAttributeAsString("descriptionField");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.descriptionField:" + t.getMessage() + "\n";
        }
        try {
            s.detailsButtonTitle = getAttributeAsString("detailsButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.detailsButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.disableWeekends = getAttributeAsString("disableWeekends");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.disableWeekends:" + t.getMessage() + "\n";
        }
        try {
            s.durationField = getAttributeAsString("durationField");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.durationField:" + t.getMessage() + "\n";
        }
        try {
            s.durationUnitField = getAttributeAsString("durationUnitField");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.durationUnitField:" + t.getMessage() + "\n";
        }
        try {
            s.endDate = getAttributeAsString("endDate");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.endDate:" + t.getMessage() + "\n";
        }
        try {
            s.endDateField = getAttributeAsString("endDateField");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.endDateField:" + t.getMessage() + "\n";
        }
        try {
            s.eventAutoArrange = getAttributeAsString("eventAutoArrange");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.eventAutoArrange:" + t.getMessage() + "\n";
        }
        try {
            s.eventDescriptionFieldTitle = getAttributeAsString("eventDescriptionFieldTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.eventDescriptionFieldTitle:" + t.getMessage() + "\n";
        }
        try {
            s.eventDragGap = getAttributeAsString("eventDragGap");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.eventDragGap:" + t.getMessage() + "\n";
        }
        try {
            s.eventDurationFieldTitle = getAttributeAsString("eventDurationFieldTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.eventDurationFieldTitle:" + t.getMessage() + "\n";
        }
        try {
            s.eventDurationUnitFieldTitle = getAttributeAsString("eventDurationUnitFieldTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.eventDurationUnitFieldTitle:" + t.getMessage() + "\n";
        }
        try {
            s.eventEndDateFieldTitle = getAttributeAsString("eventEndDateFieldTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.eventEndDateFieldTitle:" + t.getMessage() + "\n";
        }
        try {
            s.eventHeaderHeight = getAttributeAsString("eventHeaderHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.eventHeaderHeight:" + t.getMessage() + "\n";
        }
        try {
            s.eventHeaderWrap = getAttributeAsString("eventHeaderWrap");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.eventHeaderWrap:" + t.getMessage() + "\n";
        }
        try {
            s.eventLaneFieldTitle = getAttributeAsString("eventLaneFieldTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.eventLaneFieldTitle:" + t.getMessage() + "\n";
        }
        try {
            s.eventNameFieldTitle = getAttributeAsString("eventNameFieldTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.eventNameFieldTitle:" + t.getMessage() + "\n";
        }
        try {
            s.eventOverlap = getAttributeAsString("eventOverlap");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.eventOverlap:" + t.getMessage() + "\n";
        }
        try {
            s.eventOverlapIdenticalStartTimes = getAttributeAsString("eventOverlapIdenticalStartTimes");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.eventOverlapIdenticalStartTimes:" + t.getMessage() + "\n";
        }
        try {
            s.eventOverlapPercent = getAttributeAsString("eventOverlapPercent");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.eventOverlapPercent:" + t.getMessage() + "\n";
        }
        try {
            s.eventSnapGap = getAttributeAsString("eventSnapGap");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.eventSnapGap:" + t.getMessage() + "\n";
        }
        try {
            s.eventStartDateFieldTitle = getAttributeAsString("eventStartDateFieldTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.eventStartDateFieldTitle:" + t.getMessage() + "\n";
        }
        try {
            s.eventStyleName = getAttributeAsString("eventStyleName");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.eventStyleName:" + t.getMessage() + "\n";
        }
        try {
            s.eventStyleNameField = getAttributeAsString("eventStyleNameField");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.eventStyleNameField:" + t.getMessage() + "\n";
        }
        try {
            s.eventSublaneFieldTitle = getAttributeAsString("eventSublaneFieldTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.eventSublaneFieldTitle:" + t.getMessage() + "\n";
        }
        try {
            s.eventWindowStyle = getAttributeAsString("eventWindowStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.eventWindowStyle:" + t.getMessage() + "\n";
        }
        try {
            s.eventWindowStyleField = getAttributeAsString("eventWindowStyleField");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.eventWindowStyleField:" + t.getMessage() + "\n";
        }
        try {
            s.firstDayOfWeek = getAttributeAsString("firstDayOfWeek");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.firstDayOfWeek:" + t.getMessage() + "\n";
        }
        try {
            s.headerLevels = getHeaderLevels();
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.headerLevelsArray:" + t.getMessage() + "\n";
        }
        try {
            s.hideUnusedLanes = getAttributeAsString("hideUnusedLanes");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.hideUnusedLanes:" + t.getMessage() + "\n";
        }
        try {
            s.indicators = getIndicators();
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.indicatorsArray:" + t.getMessage() + "\n";
        }
        try {
            s.indicatorStyleName = getAttributeAsString("indicatorStyleName");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.indicatorStyleName:" + t.getMessage() + "\n";
        }
        try {
            s.invalidDateMessage = getAttributeAsString("invalidDateMessage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.invalidDateMessage:" + t.getMessage() + "\n";
        }
        try {
            s.laneEventPadding = getAttributeAsString("laneEventPadding");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.laneEventPadding:" + t.getMessage() + "\n";
        }
        try {
            s.laneFields = getLaneFields();
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.laneFieldsArray:" + t.getMessage() + "\n";
        }
        try {
            s.laneGroupByFieldAsString = getAttributeAsString("laneGroupByField");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.laneGroupByFieldAsString:" + t.getMessage() + "\n";
        }
        try {
            s.laneGroupStartOpenAsString = getAttributeAsString("laneGroupStartOpen");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.laneGroupStartOpenAsString:" + t.getMessage() + "\n";
        }
        try {
            s.laneNameField = getAttributeAsString("laneNameField");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.laneNameField:" + t.getMessage() + "\n";
        }
        try {
            s.lanes = getLanes();
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.lanesArray:" + t.getMessage() + "\n";
        }
        try {
            s.leadingDateField = getAttributeAsString("leadingDateField");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.leadingDateField:" + t.getMessage() + "\n";
        }
        try {
            s.minimumDayHeight = getAttributeAsString("minimumDayHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.minimumDayHeight:" + t.getMessage() + "\n";
        }
        try {
            s.minLaneWidth = getAttributeAsString("minLaneWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.minLaneWidth:" + t.getMessage() + "\n";
        }
        try {
            s.monthViewTitle = getAttributeAsString("monthViewTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.monthViewTitle:" + t.getMessage() + "\n";
        }
        try {
            s.nameField = getAttributeAsString("nameField");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.nameField:" + t.getMessage() + "\n";
        }
        try {
            s.nextButtonHoverText = getAttributeAsString("nextButtonHoverText");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.nextButtonHoverText:" + t.getMessage() + "\n";
        }
        try {
            s.otherDayBlankStyle = getAttributeAsString("otherDayBlankStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.otherDayBlankStyle:" + t.getMessage() + "\n";
        }
        try {
            s.otherDayBodyBaseStyle = getAttributeAsString("otherDayBodyBaseStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.otherDayBodyBaseStyle:" + t.getMessage() + "\n";
        }
        try {
            s.otherDayHeaderBaseStyle = getAttributeAsString("otherDayHeaderBaseStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.otherDayHeaderBaseStyle:" + t.getMessage() + "\n";
        }
        try {
            s.overlapSortSpecifiers = getOverlapSortSpecifiers();
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.overlapSortSpecifiersArray:" + t.getMessage() + "\n";
        }
        try {
            s.previousButtonHoverText = getAttributeAsString("previousButtonHoverText");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.previousButtonHoverText:" + t.getMessage() + "\n";
        }
        try {
            s.rowHeight = getAttributeAsString("rowHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.rowHeight:" + t.getMessage() + "\n";
        }
        try {
            s.saveButtonTitle = getAttributeAsString("saveButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.saveButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.scrollToWorkday = getAttributeAsString("scrollToWorkday");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.scrollToWorkday:" + t.getMessage() + "\n";
        }
        try {
            s.selectedCellStyle = getAttributeAsString("selectedCellStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.selectedCellStyle:" + t.getMessage() + "\n";
        }
        try {
            s.showAddEventButton = getAttributeAsString("showAddEventButton");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showAddEventButton:" + t.getMessage() + "\n";
        }
        try {
            s.showControlsBar = getAttributeAsString("showControlsBar");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showControlsBar:" + t.getMessage() + "\n";
        }
        try {
            s.showDateChooser = getAttributeAsString("showDateChooser");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showDateChooser:" + t.getMessage() + "\n";
        }
        try {
            s.showDatePickerButton = getAttributeAsString("showDatePickerButton");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showDatePickerButton:" + t.getMessage() + "\n";
        }
        try {
            s.showDayHeaders = getAttributeAsString("showDayHeaders");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showDayHeaders:" + t.getMessage() + "\n";
        }
        try {
            s.showDayLanes = getAttributeAsString("showDayLanes");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showDayLanes:" + t.getMessage() + "\n";
        }
        try {
            s.showDetailFields = getAttributeAsString("showDetailFields");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showDetailFields:" + t.getMessage() + "\n";
        }
        try {
            s.showEventDescriptions = getAttributeAsString("showEventDescriptions");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showEventDescriptions:" + t.getMessage() + "\n";
        }
        try {
            s.showEventHeaders = getAttributeAsString("showEventHeaders");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showEventHeaders:" + t.getMessage() + "\n";
        }
        try {
            s.showIndicators = getAttributeAsString("showIndicators");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showIndicators:" + t.getMessage() + "\n";
        }
        try {
            s.showNextButton = getAttributeAsString("showNextButton");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showNextButton:" + t.getMessage() + "\n";
        }
        try {
            s.showOtherDays = getAttributeAsString("showOtherDays");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showOtherDays:" + t.getMessage() + "\n";
        }
        try {
            s.showPreviousButton = getAttributeAsString("showPreviousButton");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showPreviousButton:" + t.getMessage() + "\n";
        }
        try {
            s.showQuickEventDialog = getAttributeAsString("showQuickEventDialog");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showQuickEventDialog:" + t.getMessage() + "\n";
        }
        try {
            s.showTimelineView = getAttributeAsString("showTimelineView");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showTimelineView:" + t.getMessage() + "\n";
        }
        try {
            s.showWeekends = getAttributeAsString("showWeekends");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showWeekends:" + t.getMessage() + "\n";
        }
        try {
            s.showWorkday = getAttributeAsString("showWorkday");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showWorkday:" + t.getMessage() + "\n";
        }
        try {
            s.showZones = getAttributeAsString("showZones");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showZones:" + t.getMessage() + "\n";
        }
        try {
            s.sizeEventsToGrid = getAttributeAsString("sizeEventsToGrid");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.sizeEventsToGrid:" + t.getMessage() + "\n";
        }
        try {
            s.startDate = getAttributeAsString("startDate");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.startDate:" + t.getMessage() + "\n";
        }
        try {
            s.startDateField = getAttributeAsString("startDateField");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.startDateField:" + t.getMessage() + "\n";
        }
        try {
            s.sublaneNameField = getAttributeAsString("sublaneNameField");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.sublaneNameField:" + t.getMessage() + "\n";
        }
        try {
            s.timeFormatter = getAttributeAsString("timeFormatter");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.timeFormatter:" + t.getMessage() + "\n";
        }
        try {
            s.timelineGranularity = getAttributeAsString("timelineGranularity");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.timelineGranularity:" + t.getMessage() + "\n";
        }
        try {
            s.timelineUnitsPerColumn = getAttributeAsString("timelineUnitsPerColumn");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.timelineUnitsPerColumn:" + t.getMessage() + "\n";
        }
        try {
            s.timelineViewTitle = getAttributeAsString("timelineViewTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.timelineViewTitle:" + t.getMessage() + "\n";
        }
        try {
            s.todayBackgroundColor = getAttributeAsString("todayBackgroundColor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.todayBackgroundColor:" + t.getMessage() + "\n";
        }
        try {
            s.trailingDateField = getAttributeAsString("trailingDateField");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.trailingDateField:" + t.getMessage() + "\n";
        }
        try {
            s.useSublanes = getAttributeAsString("useSublanes");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.useSublanes:" + t.getMessage() + "\n";
        }
        try {
            s.weekEventBorderOverlap = getAttributeAsString("weekEventBorderOverlap");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.weekEventBorderOverlap:" + t.getMessage() + "\n";
        }
        try {
            s.weekPrefix = getAttributeAsString("weekPrefix");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.weekPrefix:" + t.getMessage() + "\n";
        }
        try {
            s.weekViewTitle = getAttributeAsString("weekViewTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.weekViewTitle:" + t.getMessage() + "\n";
        }
        try {
            s.workdayBaseStyle = getAttributeAsString("workdayBaseStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.workdayBaseStyle:" + t.getMessage() + "\n";
        }
        try {
            s.workdayEnd = getAttributeAsString("workdayEnd");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.workdayEnd:" + t.getMessage() + "\n";
        }
        try {
            s.workdays = getAttributeAsString("workdays");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.workdays:" + t.getMessage() + "\n";
        }
        try {
            s.workdayStart = getAttributeAsString("workdayStart");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.workdayStart:" + t.getMessage() + "\n";
        }
        try {
            s.zones = getZones();
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.zonesArray:" + t.getMessage() + "\n";
        }
        try {
            s.zoneStyleName = getAttributeAsString("zoneStyleName");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.zoneStyleName:" + t.getMessage() + "\n";
        }
        return s;
    }

    public LogicalStructureObject getLogicalStructure() {
        CalendarLogicalStructure s = new CalendarLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

