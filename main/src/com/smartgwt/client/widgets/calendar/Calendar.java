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
import com.smartgwt.client.data.Record;
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

import com.google.gwt.event.shared.*;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.smartgwt.client.util.workflow.Process; // required to override java.lang.Process

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
import com.smartgwt.logicalstructure.widgets.ace.*;
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
 * com.smartgwt.client.docs.LoadingOptionalModules Calendar module}  must be loaded to make use of the Calendar class. <P>
 * <b>CalendarEvents</b> <P> Events are represented as ordinary JavaScript Objects (see {@link
 * com.smartgwt.client.widgets.calendar.CalendarEvent}).   The Calendar expects to be able to read and write a basic set of
 * properties  on events: name, startDate, endDate, description, etc, which can be stored  under configurable property
 * names (see eg {@link com.smartgwt.client.widgets.calendar.Calendar#getStartDateField startDateField}). <P> Much like a
 * {@link com.smartgwt.client.widgets.grid.ListGrid} manages it's ListGridRecords, the Calendar can  either be passed an
 * ordinary Array of CalendarEvents or can fetch data from a  DataSource.  When this is the case, if the DataSource  does
 * not contain fields with the configured property names, an attempt is made to  auto-detect likely-looking fields from
 * those that are present.  To see logs indicating that  this has happened, switch default logging preferences to INFO
 * level in the Developer Console. <P> If the calendar is bound to a DataSource, event changes by user action or by 
 * calling methods will be saved to the DataSource. <P> <b>Navigation</b> <P> The calendar supports a number of views by
 * default: {@link com.smartgwt.client.widgets.calendar.Calendar#getDayView day}, {@link
 * com.smartgwt.client.widgets.calendar.Calendar#getWeekView week}, {@link
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
public class Calendar extends Canvas implements DataBoundComponent, com.smartgwt.client.widgets.calendar.events.HasBackgroundClickHandlers, com.smartgwt.client.widgets.calendar.events.HasBackgroundMouseDownHandlers, com.smartgwt.client.widgets.calendar.events.HasBackgroundMouseUpHandlers, com.smartgwt.client.widgets.calendar.events.HasCurrentViewChangedHandlers, com.smartgwt.client.widgets.calendar.events.HasDateChangedHandlers, com.smartgwt.client.widgets.calendar.events.HasDayBodyClickHandlers, com.smartgwt.client.widgets.calendar.events.HasDayHeaderClickHandlers, com.smartgwt.client.widgets.calendar.events.HasEventAddedHandlers, com.smartgwt.client.widgets.calendar.events.HasEventChangedHandlers, com.smartgwt.client.widgets.calendar.events.HasEventClickHandlers, com.smartgwt.client.widgets.calendar.events.HasEventRemoveClickHandlers, com.smartgwt.client.widgets.calendar.events.HasEventRemovedHandlers, com.smartgwt.client.widgets.calendar.events.HasEventRepositionMoveHandlers, com.smartgwt.client.widgets.calendar.events.HasEventRepositionStopHandlers, com.smartgwt.client.widgets.calendar.events.HasEventResizeMoveHandlers, com.smartgwt.client.widgets.calendar.events.HasEventResizeStopHandlers, com.smartgwt.client.widgets.calendar.events.HasIndicatorClickHandlers, com.smartgwt.client.widgets.calendar.events.HasZoneClickHandlers {

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
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(Calendar.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.Calendar.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    /**
     * Changes the defaults for FormItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults FormItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, FormItem defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(Calendar.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.Calendar.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
     * This component is an AutoChild named "addEventButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current addEventButton value. Default value is null
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
     * @param addEventButtonHoverText New addEventButtonHoverText value. Default value is "Add an event"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setAddEventButtonHoverText(String addEventButtonHoverText)  throws IllegalStateException {
        return (Calendar)setAttribute("addEventButtonHoverText", addEventButtonHoverText, false);
    }

    /**
     * The text to be displayed when a user hovers over the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getAddEventButton add event} toolbar button
     *
     * @return Current addEventButtonHoverText value. Default value is "Add an event"
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
     * @param allowDurationEvents New allowDurationEvents value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public Calendar setAllowDurationEvents(Boolean allowDurationEvents) {
        return (Calendar)setAttribute("allowDurationEvents", allowDurationEvents, true);
    }

    /**
     * When set to true, allows events to be managed by duration, as well as by end date.  Values can be set for {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getDuration duration} and  {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getDurationUnit duration unit} on each event, and are then
     * maintained, instead of the end date, when alterations are made to the event via editors or dragging  with the mouse.
     *
     * @return Current allowDurationEvents value. Default value is null
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
     * @param alternateLaneStyles New alternateLaneStyles value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     */
    public Calendar setAlternateLaneStyles(Boolean alternateLaneStyles) {
        return (Calendar)setAttribute("alternateLaneStyles", alternateLaneStyles, true);
    }

    /**
     * When showing a {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineView Timeline}, or a {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDayView day view} when  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes showDayLanes} is true, whether to make lane boundaries
     * more obvious by showing alternate lanes in a different color.
     *
     * @return Current alternateLaneStyles value. Default value is null
     */
    public Boolean getAlternateLaneStyles()  {
        return getAttributeAsBoolean("alternateLaneStyles");
    }
    

    /**
     * By default, EventCanvases show their content in hovers, and will only show a hover if the  content is clipped.  If you
     * have customized hover-content, or just want your events to  always show hovers, you can set this attribute to true.
     *
     * @param alwaysShowEventHovers New alwaysShowEventHovers value. Default value is false
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     */
    public Calendar setAlwaysShowEventHovers(Boolean alwaysShowEventHovers) {
        return (Calendar)setAttribute("alwaysShowEventHovers", alwaysShowEventHovers, true);
    }

    /**
     * By default, EventCanvases show their content in hovers, and will only show a hover if the  content is clipped.  If you
     * have customized hover-content, or just want your events to  always show hovers, you can set this attribute to true.
     *
     * @return Current alwaysShowEventHovers value. Default value is false
     */
    public Boolean getAlwaysShowEventHovers()  {
        Boolean result = getAttributeAsBoolean("alwaysShowEventHovers");
        return result == null ? false : result;
    }
    
    
    

    /**
     * The title of the {@link com.smartgwt.client.widgets.calendar.Calendar#getMonthButton month} on Handsets when the  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getMonthView month view} is the current visible view.   <P> When the month
     * view is not the current visible view, the title for the month button is set  according to the value of {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getMonthButtonTitle monthButtonTitle}.
     *
     * @param backButtonTitle New backButtonTitle value. Default value is "Back"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public Calendar setBackButtonTitle(String backButtonTitle)  throws IllegalStateException {
        return (Calendar)setAttribute("backButtonTitle", backButtonTitle, false);
    }

    /**
     * The title of the {@link com.smartgwt.client.widgets.calendar.Calendar#getMonthButton month} on Handsets when the  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getMonthView month view} is the current visible view.   <P> When the month
     * view is not the current visible view, the title for the month button is set  according to the value of {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getMonthButtonTitle monthButtonTitle}.
     *
     * @return Current backButtonTitle value. Default value is "Back"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getBackButtonTitle()  {
        return getAttributeAsString("backButtonTitle");
    }
    

    /**
     * The base name for the CSS class applied to the grid cells of the day and week views of the calendar. This style will
     * have "Dark", "Over", "Selected", or "Disabled" appended to it according to the state of the cell. <P> See {@link
     * com.smartgwt.client.docs.CellStyleSuffixes} for details on how stateful suffixes are combined with the base style to
     * generate stateful cell styles.
     *
     * @param baseStyle New baseStyle value. Default value is "calendar"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Calendar setBaseStyle(String baseStyle) {
        return (Calendar)setAttribute("baseStyle", baseStyle, true);
    }

    /**
     * The base name for the CSS class applied to the grid cells of the day and week views of the calendar. This style will
     * have "Dark", "Over", "Selected", or "Disabled" appended to it according to the state of the cell. <P> See {@link
     * com.smartgwt.client.docs.CellStyleSuffixes} for details on how stateful suffixes are combined with the base style to
     * generate stateful cell styles.
     *
     * @return Current baseStyle value. Default value is "calendar"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getBaseStyle()  {
        return getAttributeAsString("baseStyle");
    }
    

    /**
     * If set to true, clicking an event will bring it to the front of the zorder.
     *
     * @param bringEventsToFront New bringEventsToFront value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setBringEventsToFront(Boolean bringEventsToFront)  throws IllegalStateException {
        return (Calendar)setAttribute("bringEventsToFront", bringEventsToFront, false);
    }

    /**
     * If set to true, clicking an event will bring it to the front of the zorder.
     *
     * @return Current bringEventsToFront value. Default value is null
     */
    public Boolean getBringEventsToFront()  {
        return getAttributeAsBoolean("bringEventsToFront");
    }
    

    /**
     * The base name for the CSS class applied to the links rendered by {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDayBodyHTML getDayBodyHTML()}. <P> These links are rendered as plain
     * HTML links using A elements, and the CSS style in the  provided skins references the pseudo-classes :link, :visited,
     * :active, :hover.  <BR> Even though it goes against the general policy of not exposing the HTML structures SC writes out
     * and not relying on them for styling, applying style to these particular selectors is acceptable, as we're unlikely to
     * use any other kind of HTML structure than a link.
     *
     * @param calMonthEventLinkStyle New calMonthEventLinkStyle value. Default value is "calMonthEventLink"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Calendar setCalMonthEventLinkStyle(String calMonthEventLinkStyle) {
        return (Calendar)setAttribute("calMonthEventLinkStyle", calMonthEventLinkStyle, true);
    }

    /**
     * The base name for the CSS class applied to the links rendered by {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDayBodyHTML getDayBodyHTML()}. <P> These links are rendered as plain
     * HTML links using A elements, and the CSS style in the  provided skins references the pseudo-classes :link, :visited,
     * :active, :hover.  <BR> Even though it goes against the general policy of not exposing the HTML structures SC writes out
     * and not relying on them for styling, applying style to these particular selectors is acceptable, as we're unlikely to
     * use any other kind of HTML structure than a link.
     *
     * @return Current calMonthEventLinkStyle value. Default value is "calMonthEventLink"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getCalMonthEventLinkStyle()  {
        return getAttributeAsString("calMonthEventLinkStyle");
    }
    

    /**
     * An {@link com.smartgwt.client.types.AutoChild} of type {@link com.smartgwt.client.widgets.IButton}, used to cancel
     * editing of an event and close the  {@link com.smartgwt.client.widgets.calendar.Calendar#getEventEditor eventEditor}.
     * <p>
     * This component is an AutoChild named "cancelButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current cancelButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getCancelButton() throws IllegalStateException {
        errorIfNotCreated("cancelButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("cancelButton"));
    }
    

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getCancelButton Cancel button} in the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor event editor}.
     *
     * @param cancelButtonTitle New cancelButtonTitle value. Default value is "Cancel"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public Calendar setCancelButtonTitle(String cancelButtonTitle)  throws IllegalStateException {
        return (Calendar)setAttribute("cancelButtonTitle", cancelButtonTitle, false);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getCancelButton Cancel button} in the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor event editor}.
     *
     * @return Current cancelButtonTitle value. Default value is "Cancel"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getCancelButtonTitle()  {
        return getAttributeAsString("cancelButtonTitle");
    }
    

    /**
     * If true, users can create new events.
     *
     * @param canCreateEvents New canCreateEvents value. Default value is true
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setCanCreateEvents(Boolean canCreateEvents)  throws IllegalStateException {
        return (Calendar)setAttribute("canCreateEvents", canCreateEvents, false);
    }

    /**
     * If true, users can create new events.
     *
     * @return Current canCreateEvents value. Default value is true
     */
    public Boolean getCanCreateEvents()  {
        Boolean result = getAttributeAsBoolean("canCreateEvents");
        return result == null ? true : result;
    }
    

    /**
     * If true, users can delete existing events. Defaults to {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanEditEvents canEditEvents}.
     *
     * @param canDeleteEvents New canDeleteEvents value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @deprecated in favor of {@link com.smartgwt.client.widgets.calendar.Calendar#getCanRemoveEvents canRemoveEvents}
     */
    public Calendar setCanDeleteEvents(Boolean canDeleteEvents)  throws IllegalStateException {
        return (Calendar)setAttribute("canDeleteEvents", canDeleteEvents, false);
    }

    /**
     * If true, users can delete existing events. Defaults to {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanEditEvents canEditEvents}.
     *
     * @return Current canDeleteEvents value. Default value is null
     * @deprecated in favor of {@link com.smartgwt.client.widgets.calendar.Calendar#getCanRemoveEvents canRemoveEvents}
     */
    public Boolean getCanDeleteEvents()  {
        return getAttributeAsBoolean("canDeleteEvents");
    }
    

    /**
     * A boolean value controlling whether new events of varying length can be created by dragging the cursor.  By default,
     * this is false for Touch devices and true otherwise.
     *
     * @param canDragCreateEvents New canDragCreateEvents value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     */
    public Calendar setCanDragCreateEvents(Boolean canDragCreateEvents) {
        return (Calendar)setAttribute("canDragCreateEvents", canDragCreateEvents, true);
    }

    /**
     * A boolean value controlling whether new events of varying length can be created by dragging the cursor.  By default,
     * this is false for Touch devices and true otherwise.
     *
     * @return Current canDragCreateEvents value. Default value is null
     */
    public Boolean getCanDragCreateEvents()  {
        return getAttributeAsBoolean("canDragCreateEvents");
    }
    

    /**
     * Name of the field on each {@link com.smartgwt.client.widgets.calendar.CalendarEvent} that determines whether an {@link
     * com.smartgwt.client.widgets.calendar.EventCanvas} can be moved or resized by dragging with the mouse.  Note that  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanEditEvents canEditEvents} must be true for dragging to be allowed.
     *
     * @param canDragEventField New canDragEventField value. Default value is "canDrag"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public Calendar setCanDragEventField(String canDragEventField)  throws IllegalStateException {
        return (Calendar)setAttribute("canDragEventField", canDragEventField, false);
    }

    /**
     * Name of the field on each {@link com.smartgwt.client.widgets.calendar.CalendarEvent} that determines whether an {@link
     * com.smartgwt.client.widgets.calendar.EventCanvas} can be moved or resized by dragging with the mouse.  Note that  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanEditEvents canEditEvents} must be true for dragging to be allowed.
     *
     * @return Current canDragEventField value. Default value is "canDrag"
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public String getCanDragEventField()  {
        return getAttributeAsString("canDragEventField");
    }
    

    /**
     * A boolean value controlling whether users can drag-reposition events.  By default, this is  false for Touch devices,
     * where drag gestures scroll the view, and true otherwise. <P> Only has an effect when {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanEditEvents canEditEvents} is true.
     *
     * @param canDragEvents New canDragEvents value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setCanDragEvents(Boolean canDragEvents)  throws IllegalStateException {
        return (Calendar)setAttribute("canDragEvents", canDragEvents, false);
    }

    /**
     * A boolean value controlling whether users can drag-reposition events.  By default, this is  false for Touch devices,
     * where drag gestures scroll the view, and true otherwise. <P> Only has an effect when {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanEditEvents canEditEvents} is true.
     *
     * @return Current canDragEvents value. Default value is null
     */
    public Boolean getCanDragEvents()  {
        return getAttributeAsBoolean("canDragEvents");
    }
    

    /**
     * If true, users can edit existing events.
     *
     * @param canEditEvents New canEditEvents value. Default value is true
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setCanEditEvents(Boolean canEditEvents)  throws IllegalStateException {
        return (Calendar)setAttribute("canEditEvents", canEditEvents, false);
    }

    /**
     * If true, users can edit existing events.
     *
     * @return Current canEditEvents value. Default value is true
     */
    public Boolean getCanEditEvents()  {
        Boolean result = getAttributeAsBoolean("canEditEvents");
        return result == null ? true : result;
    }
    

    /**
     * Name of the field on each {@link com.smartgwt.client.widgets.calendar.CalendarEvent} that determines whether it can be
     * edited in the {@link com.smartgwt.client.widgets.calendar.Calendar#getEventEditor event editor}.  Note that an event
     * with <code>canEdit</code>  set to true can also have {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanDragEventField canDrag} or {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanResizeEventField canResize} set to false,  which would still allow
     * editing, but not via drag operations.
     *
     * @param canEditField New canEditField value. Default value is "canEdit"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public Calendar setCanEditField(String canEditField)  throws IllegalStateException {
        return (Calendar)setAttribute("canEditField", canEditField, false);
    }

    /**
     * Name of the field on each {@link com.smartgwt.client.widgets.calendar.CalendarEvent} that determines whether it can be
     * edited in the {@link com.smartgwt.client.widgets.calendar.Calendar#getEventEditor event editor}.  Note that an event
     * with <code>canEdit</code>  set to true can also have {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanDragEventField canDrag} or {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanResizeEventField canResize} set to false,  which would still allow
     * editing, but not via drag operations.
     *
     * @return Current canEditField value. Default value is "canEdit"
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public String getCanEditField()  {
        return getAttributeAsString("canEditField");
    }
    

    /**
     * Can events be moved between lanes?  If so, the event can be dragged to a different  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getLanes lane}, and the event {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventDialog quick dialog} and  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor editor} allow a lane to be selected with a drop-down
     * chooser. <P> In either case, the event's {@link com.smartgwt.client.widgets.calendar.Calendar#getLaneNameField
     * laneNameField} is updated automatically. <P> If set to false, cross-lane dragging is disallowed and drop-down
     * Lane-choosers are disabled when editing existng events.  When creating {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanCreateEvents new events},  the Lane-chooser remains enabled so an
     * initial Lane can be selected. <P> This setting can be overridden on each {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getCanEditLane event}.
     *
     * @param canEditLane New canEditLane value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setCanEditLane(Boolean canEditLane)  throws IllegalStateException {
        return (Calendar)setAttribute("canEditLane", canEditLane, false);
    }

    /**
     * Can events be moved between lanes?  If so, the event can be dragged to a different  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getLanes lane}, and the event {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventDialog quick dialog} and  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor editor} allow a lane to be selected with a drop-down
     * chooser. <P> In either case, the event's {@link com.smartgwt.client.widgets.calendar.Calendar#getLaneNameField
     * laneNameField} is updated automatically. <P> If set to false, cross-lane dragging is disallowed and drop-down
     * Lane-choosers are disabled when editing existng events.  When creating {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanCreateEvents new events},  the Lane-chooser remains enabled so an
     * initial Lane can be selected. <P> This setting can be overridden on each {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getCanEditLane event}.
     *
     * @return Current canEditLane value. Default value is null
     */
    public Boolean getCanEditLane()  {
        return getAttributeAsBoolean("canEditLane");
    }
    

    /**
     * Name of the field on each {@link com.smartgwt.client.widgets.calendar.CalendarEvent} that determines whether that event
     * can be  moved between lanes.
     *
     * @param canEditLaneField New canEditLaneField value. Default value is "canEditLane"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public Calendar setCanEditLaneField(String canEditLaneField)  throws IllegalStateException {
        return (Calendar)setAttribute("canEditLaneField", canEditLaneField, false);
    }

    /**
     * Name of the field on each {@link com.smartgwt.client.widgets.calendar.CalendarEvent} that determines whether that event
     * can be  moved between lanes.
     *
     * @return Current canEditLaneField value. Default value is "canEditLane"
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
     * @param canEditSublane New canEditSublane value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setCanEditSublane(Boolean canEditSublane)  throws IllegalStateException {
        return (Calendar)setAttribute("canEditSublane", canEditSublane, false);
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
     * @return Current canEditSublane value. Default value is null
     */
    public Boolean getCanEditSublane()  {
        return getAttributeAsBoolean("canEditSublane");
    }
    

    /**
     * Name of the field on each {@link com.smartgwt.client.widgets.calendar.CalendarEvent} that determines whether that event
     * can be  moved between individual {@link com.smartgwt.client.widgets.calendar.Lane#getSublanes sublanes} in a {@link
     * com.smartgwt.client.widgets.calendar.Lane}.
     *
     * @param canEditSublaneField New canEditSublaneField value. Default value is "canEditSublane"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public Calendar setCanEditSublaneField(String canEditSublaneField)  throws IllegalStateException {
        return (Calendar)setAttribute("canEditSublaneField", canEditSublaneField, false);
    }

    /**
     * Name of the field on each {@link com.smartgwt.client.widgets.calendar.CalendarEvent} that determines whether that event
     * can be  moved between individual {@link com.smartgwt.client.widgets.calendar.Lane#getSublanes sublanes} in a {@link
     * com.smartgwt.client.widgets.calendar.Lane}.
     *
     * @return Current canEditSublaneField value. Default value is "canEditSublane"
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
     * @param canGroupLanes New canGroupLanes value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     */
    public Calendar setCanGroupLanes(Boolean canGroupLanes) {
        return (Calendar)setAttribute("canGroupLanes", canGroupLanes, true);
    }

    /**
     * If true, allows the lanes in a Timeline to be grouped by providing a value for  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getLaneGroupByField laneGroupByField}.  The fields available for grouping
     * on  are those defined as {@link com.smartgwt.client.widgets.calendar.Calendar#getLaneFields lane fields}.  Since these
     * are definitions for {@link com.smartgwt.client.widgets.grid.ListGridField normal fields}, you can choose to {@link
     * com.smartgwt.client.widgets.grid.ListGridField#showIf hide} the field in the timeline, but still have it available for
     * grouping.
     *
     * @return Current canGroupLanes value. Default value is null
     */
    public Boolean getCanGroupLanes()  {
        return getAttributeAsBoolean("canGroupLanes");
    }
    

    /**
     * If true, users can remove existing events. Defaults to {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanEditEvents canEditEvents}.
     *
     * @param canRemoveEvents New canRemoveEvents value. Default value is true
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setCanRemoveEvents(Boolean canRemoveEvents)  throws IllegalStateException {
        return (Calendar)setAttribute("canRemoveEvents", canRemoveEvents, false);
    }

    /**
     * If true, users can remove existing events. Defaults to {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanEditEvents canEditEvents}.
     *
     * @return Current canRemoveEvents value. Default value is true
     */
    public Boolean getCanRemoveEvents()  {
        Boolean result = getAttributeAsBoolean("canRemoveEvents");
        return result == null ? true : result;
    }
    

    /**
     * Name of the field on each {@link com.smartgwt.client.widgets.calendar.CalendarEvent} that determines whether an event
     * shows a remove button.
     *
     * @param canRemoveField New canRemoveField value. Default value is "canRemove"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public Calendar setCanRemoveField(String canRemoveField)  throws IllegalStateException {
        return (Calendar)setAttribute("canRemoveField", canRemoveField, false);
    }

    /**
     * Name of the field on each {@link com.smartgwt.client.widgets.calendar.CalendarEvent} that determines whether an event
     * shows a remove button.
     *
     * @return Current canRemoveField value. Default value is "canRemove"
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public String getCanRemoveField()  {
        return getAttributeAsString("canRemoveField");
    }
    

    /**
     * If true, lanes can be reordered by dragging their {@link com.smartgwt.client.widgets.calendar.Calendar#getLaneFields
     * laneFields} with the mouse.
     *
     * @param canReorderLanes New canReorderLanes value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setCanReorderLanes(Boolean canReorderLanes)  throws IllegalStateException {
        return (Calendar)setAttribute("canReorderLanes", canReorderLanes, false);
    }

    /**
     * If true, lanes can be reordered by dragging their {@link com.smartgwt.client.widgets.calendar.Calendar#getLaneFields
     * laneFields} with the mouse.
     *
     * @return Current canReorderLanes value. Default value is null
     */
    public Boolean getCanReorderLanes()  {
        return getAttributeAsBoolean("canReorderLanes");
    }
    

    /**
     * Name of the field on each {@link com.smartgwt.client.widgets.calendar.CalendarEvent} that determines whether an event
     * can be  resized by dragging.
     *
     * @param canResizeEventField New canResizeEventField value. Default value is "canResize"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public Calendar setCanResizeEventField(String canResizeEventField)  throws IllegalStateException {
        return (Calendar)setAttribute("canResizeEventField", canResizeEventField, false);
    }

    /**
     * Name of the field on each {@link com.smartgwt.client.widgets.calendar.CalendarEvent} that determines whether an event
     * can be  resized by dragging.
     *
     * @return Current canResizeEventField value. Default value is "canResize"
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public String getCanResizeEventField()  {
        return getAttributeAsString("canResizeEventField");
    }
    

    /**
     * Can {@link com.smartgwt.client.widgets.calendar.CalendarEvent events} be resized by dragging appropriate edges of the 
     * {@link com.smartgwt.client.widgets.calendar.EventCanvas#getVerticalResize canvas}?  Only has an effect when both {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanEditEvents canEditEvents} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanDragEvents canDragEvents} are true.  Set this attribute to false to
     * disallow drag-resizing. <P> Always false when {@link com.smartgwt.client.widgets.calendar.Calendar#getShowColumnLayouts
     * showColumnLayouts} is true.
     *
     * @param canResizeEvents New canResizeEvents value. Default value is true
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setCanResizeEvents(Boolean canResizeEvents)  throws IllegalStateException {
        return (Calendar)setAttribute("canResizeEvents", canResizeEvents, false);
    }

    /**
     * Can {@link com.smartgwt.client.widgets.calendar.CalendarEvent events} be resized by dragging appropriate edges of the 
     * {@link com.smartgwt.client.widgets.calendar.EventCanvas#getVerticalResize canvas}?  Only has an effect when both {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanEditEvents canEditEvents} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCanDragEvents canDragEvents} are true.  Set this attribute to false to
     * disallow drag-resizing. <P> Always false when {@link com.smartgwt.client.widgets.calendar.Calendar#getShowColumnLayouts
     * showColumnLayouts} is true.
     *
     * @return Current canResizeEvents value. Default value is true
     */
    public Boolean getCanResizeEvents()  {
        Boolean result = getAttributeAsBoolean("canResizeEvents");
        return result == null ? true : result;
    }
    

    /**
     * Can {@link com.smartgwt.client.widgets.calendar.Timeline} events be stretched by their left and right edges?
     *
     * @param canResizeTimelineEvents New canResizeTimelineEvents value. Default value is false
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @deprecated in favor of {@link com.smartgwt.client.widgets.calendar.Calendar#getCanResizeEvents canResizeEvents};
     */
    public Calendar setCanResizeTimelineEvents(Boolean canResizeTimelineEvents)  throws IllegalStateException {
        return (Calendar)setAttribute("canResizeTimelineEvents", canResizeTimelineEvents, false);
    }

    /**
     * Can {@link com.smartgwt.client.widgets.calendar.Timeline} events be stretched by their left and right edges?
     *
     * @return Current canResizeTimelineEvents value. Default value is false
     * @deprecated in favor of {@link com.smartgwt.client.widgets.calendar.Calendar#getCanResizeEvents canResizeEvents};
     */
    public Boolean getCanResizeTimelineEvents()  {
        Boolean result = getAttributeAsBoolean("canResizeTimelineEvents");
        return result == null ? false : result;
    }
    

    /**
     * When set to true, makes individual {@link com.smartgwt.client.widgets.calendar.EventCanvas event canvases} selectable.
     * Events may be selected via a single click, as well as being included in the page's tab order. The current selected event
     * is shown in a special  style and pressing TAB or Shift-TAB will move the selection first among the events  in the same
     * lane, and then among those in the next or previous lane. <P> Pressing Enter while an editable event is selected  will
     * show either the event- {@link com.smartgwt.client.widgets.calendar.Calendar#getEventDialog dialog} or  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor editor}.  Pressing Delete will remove the event. <P> Note
     * that when this property is false, single clicking the event canvas for an editable event will bring up an editing
     * interface for that event.  When true this is no longer the case - a user can double click to bring up the editing
     * interface instead (a single click will simply select the event canvas).
     *
     * @param canSelectEvents New canSelectEvents value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setCanSelectEvents(Boolean canSelectEvents)  throws IllegalStateException {
        return (Calendar)setAttribute("canSelectEvents", canSelectEvents, false);
    }

    /**
     * When set to true, makes individual {@link com.smartgwt.client.widgets.calendar.EventCanvas event canvases} selectable.
     * Events may be selected via a single click, as well as being included in the page's tab order. The current selected event
     * is shown in a special  style and pressing TAB or Shift-TAB will move the selection first among the events  in the same
     * lane, and then among those in the next or previous lane. <P> Pressing Enter while an editable event is selected  will
     * show either the event- {@link com.smartgwt.client.widgets.calendar.Calendar#getEventDialog dialog} or  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor editor}.  Pressing Delete will remove the event. <P> Note
     * that when this property is false, single clicking the event canvas for an editable event will bring up an editing
     * interface for that event.  When true this is no longer the case - a user can double click to bring up the editing
     * interface instead (a single click will simply select the event canvas).
     *
     * @return Current canSelectEvents value. Default value is null
     */
    public Boolean getCanSelectEvents()  {
        return getAttributeAsBoolean("canSelectEvents");
    }
    

    /**
     * The date for which events are displayed in the day, week, and month tabs of  the calendar.  Default is today.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the current date for which the calendar will display events.
     *
     * @param chosenDate the new date to set as the current date. Default value is 'Today'
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     */
    public Calendar setChosenDate(Date chosenDate) {
        return (Calendar)setAttribute("chosenDate", chosenDate, true);
    }

    /**
     * The date for which events are displayed in the day, week, and month tabs of  the calendar.  Default is today.
     *
     * @return Current chosenDate value. Default value is 'Today'
     */
    public Date getChosenDate()  {
        return getAttributeAsDate("chosenDate");
    }
    

    /**
     * <b>Note :</b> This API is non-functional (always returns null) and exists only to make
     * you aware that this MultiAutoChild exists.  See {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}
     * for details.
     * <p>
     * When {@link com.smartgwt.client.widgets.calendar.Calendar#getShowColumnLayouts showColumnLayouts} is true, the layouts
     * added to each column to stack  events.
     *
     * @return null
     */
    public VLayout getColumnLayout()  {
        return null;
    }
    

    /**
     * When using the Next and Previous arrows to scroll a Timeline, this is the number of columns  of the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineGranularity timelineGranularity} to scroll by.  With the
     * default value of null, the Timeline will scroll by its current length.
     *
     * @param columnsPerPage New columnsPerPage value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setColumnsPerPage(Integer columnsPerPage)  throws IllegalStateException {
        return (Calendar)setAttribute("columnsPerPage", columnsPerPage, false);
    }

    /**
     * When using the Next and Previous arrows to scroll a Timeline, this is the number of columns  of the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineGranularity timelineGranularity} to scroll by.  With the
     * default value of null, the Timeline will scroll by its current length.
     *
     * @return Current columnsPerPage value. Default value is null
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
     * This component is an AutoChild named "controlsBar".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current controlsBar value. Default value is null
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
     * @param currentViewName The name of the view that should be made visible. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     */
    public Calendar setCurrentViewName(ViewName currentViewName) {
        return (Calendar)setAttribute("currentViewName", currentViewName == null ? null : currentViewName.getValue(), true);
    }

    /**
     * The name of the view that should be visible initially by default.
     *
     * @return Get the name of the visible view.   Returns one of 'day', 'week', 'month' or 'timeline'. Default value is null
     */
    public ViewName getCurrentViewName()  {
        return EnumUtil.getEnum(ViewName.values(), getAttribute("currentViewName"));
    }
    

    /**
     * A List of CalendarEvent objects, specifying the data to be used to populate the calendar.   <p> This property will
     * typically not be explicitly specified for databound Calendars, where the data is returned from the server via databound
     * component methods such as {@link com.smartgwt.client.widgets.calendar.Calendar#fetchData fetchData()}. In this case the
     * data objects will be set to a  {@link com.smartgwt.client.data.ResultSet resultSet} rather than a simple array.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Initialize the data object with the given array. Observes methods of the data object so that when the data changes, the calendar will redraw automatically.
     *
     * @param data data to show in the list. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public Calendar setData(CalendarEvent... data) {
        return (Calendar)setAttribute("data", data, true);
    }

    /**
     * A List of CalendarEvent objects, specifying the data to be used to populate the calendar.   <p> This property will
     * typically not be explicitly specified for databound Calendars, where the data is returned from the server via databound
     * component methods such as {@link com.smartgwt.client.widgets.calendar.Calendar#fetchData fetchData()}. In this case the
     * data objects will be set to a  {@link com.smartgwt.client.data.ResultSet resultSet} rather than a simple array.
     *
     * @return Current data value. Default value is null
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public CalendarEvent[] getData()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfCalendarEvent(getAttributeAsJavaScriptObject("data"));
    }
    

    /**
     * How to fetch and manage records retrieve from the server.  See {@link com.smartgwt.client.types.FetchMode}. <P> This
     * setting only applies to the {@link com.smartgwt.client.data.ResultSet} automatically created by calling {@link
     * com.smartgwt.client.widgets.grid.ListGrid#fetchData fetchData()}.  If a pre-existing ResultSet is passed to setData()
     * instead, it's existing setting for {@link com.smartgwt.client.data.ResultSet#getFetchMode ResultSet.fetchMode} applies.
     *
     * @param dataFetchMode New dataFetchMode value. Default value is "paged"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public Calendar setDataFetchMode(FetchMode dataFetchMode) {
        return (Calendar)setAttribute("dataFetchMode", dataFetchMode == null ? null : dataFetchMode.getValue(), true);
    }

    /**
     * How to fetch and manage records retrieve from the server.  See {@link com.smartgwt.client.types.FetchMode}. <P> This
     * setting only applies to the {@link com.smartgwt.client.data.ResultSet} automatically created by calling {@link
     * com.smartgwt.client.widgets.grid.ListGrid#fetchData fetchData()}.  If a pre-existing ResultSet is passed to setData()
     * instead, it's existing setting for {@link com.smartgwt.client.data.ResultSet#getFetchMode ResultSet.fetchMode} applies.
     *
     * @return Current dataFetchMode value. Default value is "paged"
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public FetchMode getDataFetchMode()  {
        return EnumUtil.getEnum(FetchMode.values(), getAttribute("dataFetchMode"));
    }
    

    /**
     * The DataSource that this component should bind to for default fields and for performing {@link
     * com.smartgwt.client.data.DSRequest DataSource requests}. <P> Can be specified as either a DataSource instance or the
     * String ID of a DataSource.
     *
     * @param dataSource New dataSource value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_databinding_ds_fields" target="examples">DataSource fields Example</a>
     */
    public Calendar setDataSource(DataSource dataSource) {
        return (Calendar)setAttribute("dataSource", dataSource == null ? null : dataSource.getOrCreateJsObj(), true);
    }

    /**
     * The DataSource that this component should bind to for default fields and for performing {@link
     * com.smartgwt.client.data.DSRequest DataSource requests}. <P> Can be specified as either a DataSource instance or the
     * String ID of a DataSource.
     *
     * @param dataSource New dataSource value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_databinding_ds_fields" target="examples">DataSource fields Example</a>
     */
    public Calendar setDataSource(String dataSource) {
        return (Calendar)setAttribute("dataSource", dataSource, true);
    }
    

    /**
     * {@link com.smartgwt.client.widgets.DateChooser} used to select the date for which events will be displayed.
     * <p>
     * This component is an AutoChild named "dateChooser".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current dateChooser value. Default value is null
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
     * @param dateEditingStyle New dateEditingStyle value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setDateEditingStyle(DateEditingStyle dateEditingStyle)  throws IllegalStateException {
        return (Calendar)setAttribute("dateEditingStyle", dateEditingStyle == null ? null : dateEditingStyle.getValue(), false);
    }

    /**
     * Indicates the type of controls to use in event-windows.  Valid values are those in the  {@link
     * com.smartgwt.client.types.DateEditingStyle DateEditingStyle} type. <P> If unset, the editing style will be set to the
     * field-type on the DataSource, if there is one. If there's no DataSource, it will be set to "date" if the  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineGranularity granularity} is "day" or larger and "time" if
     * granularity  is "minute" or smaller, otherwise "datetime".
     *
     * @return Current dateEditingStyle value. Default value is null
     */
    public DateEditingStyle getDateEditingStyle()  {
        return EnumUtil.getEnum(DateEditingStyle.values(), getAttribute("dateEditingStyle"));
    }
    

    /**
     * Date formatter for displaying events. Default is to use the system-wide default short date format, configured via {@link
     * com.smartgwt.client.util.DateUtil#setShortDisplayFormat DateUtil.setShortDisplayFormat()}.  Specify any valid {@link
     * com.smartgwt.client.types.DateDisplayFormat}.
     *
     * @param dateFormatter New dateFormatter value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     */
    public Calendar setDateFormatter(DateDisplayFormat dateFormatter) {
        return (Calendar)setAttribute("dateFormatter", dateFormatter == null ? null : dateFormatter.getValue(), true);
    }

    /**
     * Date formatter for displaying events. Default is to use the system-wide default short date format, configured via {@link
     * com.smartgwt.client.util.DateUtil#setShortDisplayFormat DateUtil.setShortDisplayFormat()}.  Specify any valid {@link
     * com.smartgwt.client.types.DateDisplayFormat}.
     *
     * @return Current dateFormatter value. Default value is null
     */
    public DateDisplayFormat getDateFormatter()  {
        return EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("dateFormatter"));
    }
    

    /**
     * The {@link com.smartgwt.client.types.AutoChild} {@link com.smartgwt.client.widgets.Label} used to display the current
     * date or range above the  selected calendar view.
     * <p>
     * This component is an AutoChild named "dateLabel".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current dateLabel value. Default value is null
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
     * This component is an AutoChild named "datePickerButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current datePickerButton value. Default value is null
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
     * @param datePickerHoverText New datePickerHoverText value. Default value is "Choose a date"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setDatePickerHoverText(String datePickerHoverText)  throws IllegalStateException {
        return (Calendar)setAttribute("datePickerHoverText", datePickerHoverText, false);
    }

    /**
     * The text to be displayed when a user hovers over the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDatePickerButton date picker} toolbar button
     *
     * @return Current datePickerHoverText value. Default value is "Choose a date"
     */
    public String getDatePickerHoverText()  {
        return getAttributeAsString("datePickerHoverText");
    }
    

    /**
     * The base name for the CSS class applied to the day body of the month view of the calendar. This style will have "Dark",
     * "Over", "Selected", or "Disabled" appended to it according to the state of the cell. <P> See {@link
     * com.smartgwt.client.docs.CellStyleSuffixes} for details on how stateful suffixes are combined with the base style to
     * generate stateful cell styles.
     *
     * @param dayBodyBaseStyle New dayBodyBaseStyle value. Default value is "calMonthDayBody"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Calendar setDayBodyBaseStyle(String dayBodyBaseStyle) {
        return (Calendar)setAttribute("dayBodyBaseStyle", dayBodyBaseStyle, true);
    }

    /**
     * The base name for the CSS class applied to the day body of the month view of the calendar. This style will have "Dark",
     * "Over", "Selected", or "Disabled" appended to it according to the state of the cell. <P> See {@link
     * com.smartgwt.client.docs.CellStyleSuffixes} for details on how stateful suffixes are combined with the base style to
     * generate stateful cell styles.
     *
     * @return Current dayBodyBaseStyle value. Default value is "calMonthDayBody"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getDayBodyBaseStyle()  {
        return getAttributeAsString("dayBodyBaseStyle");
    }
    

    /**
     * The base name for the CSS class applied to the day headers of the month view. This style will have "Dark", "Over",
     * "Selected", or "Disabled" appended to it according to the state of the cell. <P> See {@link
     * com.smartgwt.client.docs.CellStyleSuffixes} for details on how stateful suffixes are combined with the base style to
     * generate stateful cell styles.
     *
     * @param dayHeaderBaseStyle New dayHeaderBaseStyle value. Default value is "calMonthDayHeader"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Calendar setDayHeaderBaseStyle(String dayHeaderBaseStyle) {
        return (Calendar)setAttribute("dayHeaderBaseStyle", dayHeaderBaseStyle, true);
    }

    /**
     * The base name for the CSS class applied to the day headers of the month view. This style will have "Dark", "Over",
     * "Selected", or "Disabled" appended to it according to the state of the cell. <P> See {@link
     * com.smartgwt.client.docs.CellStyleSuffixes} for details on how stateful suffixes are combined with the base style to
     * generate stateful cell styles.
     *
     * @return Current dayHeaderBaseStyle value. Default value is "calMonthDayHeader"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getDayHeaderBaseStyle()  {
        return getAttributeAsString("dayHeaderBaseStyle");
    }
    

    /**
     * {@link com.smartgwt.client.widgets.calendar.CalendarView} used to display events that pertain to a given day.
     * <p>
     * This component is an AutoChild named "dayView".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current dayView value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public CalendarView getDayView() throws IllegalStateException {
        errorIfNotCreated("dayView");
        return (CalendarView)CalendarView.getByJSObject(getAttributeAsJavaScriptObject("dayView"));
    }
    

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getDayView day view}.
     *
     * @param dayViewTitle New dayViewTitle value. Default value is "Day"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setDayViewTitle(String dayViewTitle)  throws IllegalStateException {
        return (Calendar)setAttribute("dayViewTitle", dayViewTitle, false);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getDayView day view}.
     *
     * @return Current dayViewTitle value. Default value is "Day"
     */
    public String getDayViewTitle()  {
        return getAttributeAsString("dayViewTitle");
    }
    

    /**
     * The number of columns of the {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineGranularity
     * timelineGranularity} to give the timeline by default if no {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEndDate endDate} is provided.  The  default is 20.
     *
     * @param defaultTimelineColumnSpan New defaultTimelineColumnSpan value. Default value is 20
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setDefaultTimelineColumnSpan(int defaultTimelineColumnSpan)  throws IllegalStateException {
        return (Calendar)setAttribute("defaultTimelineColumnSpan", defaultTimelineColumnSpan, false);
    }

    /**
     * The number of columns of the {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineGranularity
     * timelineGranularity} to give the timeline by default if no {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEndDate endDate} is provided.  The  default is 20.
     *
     * @return Current defaultTimelineColumnSpan value. Default value is 20
     */
    public int getDefaultTimelineColumnSpan()  {
        return getAttributeAsInt("defaultTimelineColumnSpan");
    }
    

    /**
     * The name of the description field on a {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.
     *
     * @param descriptionField New descriptionField value. Default value is "description"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setDescriptionField(String descriptionField)  throws IllegalStateException {
        return (Calendar)setAttribute("descriptionField", descriptionField, false);
    }

    /**
     * The name of the description field on a {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.
     *
     * @return Current descriptionField value. Default value is "description"
     */
    public String getDescriptionField()  {
        return getAttributeAsString("descriptionField");
    }
    

    /**
     * The title for the edit button in the quick {@link com.smartgwt.client.widgets.calendar.Calendar#getEventDialog quick
     * event dialog}.
     *
     * @param detailsButtonTitle New detailsButtonTitle value. Default value is "Edit Details"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public Calendar setDetailsButtonTitle(String detailsButtonTitle)  throws IllegalStateException {
        return (Calendar)setAttribute("detailsButtonTitle", detailsButtonTitle, false);
    }

    /**
     * The title for the edit button in the quick {@link com.smartgwt.client.widgets.calendar.Calendar#getEventDialog quick
     * event dialog}.
     *
     * @return Current detailsButtonTitle value. Default value is "Edit Details"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getDetailsButtonTitle()  {
        return getAttributeAsString("detailsButtonTitle");
    }
    

    /**
     * If true, weekend days appear in a disabled style and events cannot be created on weekends. Which days are considered
     * weekends is controlled by {@link com.smartgwt.client.widgets.calendar.Calendar#getWeekendDays weekendDays}.
     *
     * @param disableWeekends New disableWeekends value. Default value is true
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public Calendar setDisableWeekends(Boolean disableWeekends) {
        return (Calendar)setAttribute("disableWeekends", disableWeekends, true);
    }

    /**
     * If true, weekend days appear in a disabled style and events cannot be created on weekends. Which days are considered
     * weekends is controlled by {@link com.smartgwt.client.widgets.calendar.Calendar#getWeekendDays weekendDays}.
     *
     * @return Current disableWeekends value. Default value is true
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public Boolean getDisableWeekends()  {
        Boolean result = getAttributeAsBoolean("disableWeekends");
        return result == null ? true : result;
    }
    

    /**
     * The name of the {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getDuration duration} field on a {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent}.
     *
     * @param durationField New durationField value. Default value is "duration"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public Calendar setDurationField(String durationField)  throws IllegalStateException {
        return (Calendar)setAttribute("durationField", durationField, false);
    }

    /**
     * The name of the {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getDuration duration} field on a {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent}.
     *
     * @return Current durationField value. Default value is "duration"
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public String getDurationField()  {
        return getAttributeAsString("durationField");
    }
    

    /**
     * The name of the {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getDurationUnit durationUnit} field on a 
     * {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.
     *
     * @param durationUnitField New durationUnitField value. Default value is "durationUnit"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public Calendar setDurationUnitField(String durationUnitField)  throws IllegalStateException {
        return (Calendar)setAttribute("durationUnitField", durationUnitField, false);
    }

    /**
     * The name of the {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getDurationUnit durationUnit} field on a 
     * {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.
     *
     * @return Current durationUnitField value. Default value is "durationUnit"
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public String getDurationUnitField()  {
        return getAttributeAsString("durationUnitField");
    }
    

    /**
     * The end date of the calendar timeline view.  Has no effect in other views. <P> To set different {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getStartDate start} and end dates after initial draw, see {@link
     * com.smartgwt.client.widgets.calendar.Calendar#setTimelineRange setTimelineRange}. <P> Note that the value you provide
     * may be automatically altered if showing  {@link com.smartgwt.client.widgets.calendar.Calendar#getHeaderLevels
     * header-levels}, to fit to header boundaries.
     *
     * @param endDate New endDate value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setEndDate(Date endDate)  throws IllegalStateException {
        return (Calendar)setAttribute("endDate", endDate, false);
    }

    /**
     * The end date of the calendar timeline view.  Has no effect in other views. <P> To set different {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getStartDate start} and end dates after initial draw, see {@link
     * com.smartgwt.client.widgets.calendar.Calendar#setTimelineRange setTimelineRange}. <P> Note that the value you provide
     * may be automatically altered if showing  {@link com.smartgwt.client.widgets.calendar.Calendar#getHeaderLevels
     * header-levels}, to fit to header boundaries.
     *
     * @return Current endDate value. Default value is null
     */
    public Date getEndDate()  {
        return getAttributeAsDate("endDate");
    }
    

    /**
     * The name of the end date field on a {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.
     *
     * @param endDateField New endDateField value. Default value is "endDate"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public Calendar setEndDateField(String endDateField)  throws IllegalStateException {
        return (Calendar)setAttribute("endDateField", endDateField, false);
    }

    /**
     * The name of the end date field on a {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.
     *
     * @return Current endDateField value. Default value is "endDate"
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public String getEndDateField()  {
        return getAttributeAsString("endDateField");
    }
    

    /**
     * If set to true, enables the auto-arrangement of events that share time in the calendar.  The default is true.
     *
     * @param eventAutoArrange New eventAutoArrange value. Default value is true
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setEventAutoArrange(Boolean eventAutoArrange)  throws IllegalStateException {
        return (Calendar)setAttribute("eventAutoArrange", eventAutoArrange, false);
    }

    /**
     * If set to true, enables the auto-arrangement of events that share time in the calendar.  The default is true.
     *
     * @return Current eventAutoArrange value. Default value is true
     */
    public Boolean getEventAutoArrange()  {
        Boolean result = getAttributeAsBoolean("eventAutoArrange");
        return result == null ? true : result;
    }
    

    /**
     * <b>Note :</b> This API is non-functional (always returns null) and exists only to make
     * you aware that this MultiAutoChild exists.  See {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}
     * for details.
     * <p>
     * To display events in {@link com.smartgwt.client.widgets.calendar.Calendar#getDayView day}, {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWeekView week} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timeline} views, the Calendar creates instances of  {@link
     * com.smartgwt.client.widgets.calendar.EventCanvas} for each event.  Use the {@link com.smartgwt.client.types.AutoChild}
     * system to customize  these canvases.
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
     * This component is an AutoChild named "eventCanvasButtonLayout".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current eventCanvasButtonLayout value. Default value is null
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
     * This component is an AutoChild named "eventCanvasCloseButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current eventCanvasCloseButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public ImgButton getEventCanvasCloseButton() throws IllegalStateException {
        errorIfNotCreated("eventCanvasCloseButton");
        return (ImgButton)ImgButton.getByJSObject(getAttributeAsJavaScriptObject("eventCanvasCloseButton"));
    }
    

    /**
     * <b>Note :</b> This API is non-functional (always returns null) and exists only to make
     * you aware that this MultiAutoChild exists.  See {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}
     * for details.
     * <p>
     * Multi-AutoChild component, created as a space-filling member in individual  {@link
     * com.smartgwt.client.widgets.calendar.EventCanvas event-canvases}, when {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowEventCanvasComponents showEventCanvasComponents} is true. <P>
     *
     * @return null
     * @see com.smartgwt.client.widgets.calendar.Calendar#getShowEventCanvasComponents
     * @see com.smartgwt.client.widgets.calendar.Calendar#createEventCanvasComponent
     * @see com.smartgwt.client.widgets.calendar.Calendar#updateEventCanvasComponent
     */
    public Canvas getEventCanvasComponent()  {
        return null;
    }
    

    /**
     * The context button that snaps to the top-right of an event canvas on rollover and shows a custom {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventCanvasMenuItems context menu} when clicked.
     * <p>
     * This component is an AutoChild named "eventCanvasContextButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current eventCanvasContextButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public ImgButton getEventCanvasContextButton() throws IllegalStateException {
        errorIfNotCreated("eventCanvasContextButton");
        return (ImgButton)ImgButton.getByJSObject(getAttributeAsJavaScriptObject("eventCanvasContextButton"));
    }
    

    /**
     * Context menu displayed when an {@link com.smartgwt.client.widgets.calendar.EventCanvas event canvas} is right-clicked,
     * or when the rollover {@link com.smartgwt.client.widgets.calendar.Calendar#getEventCanvasContextButton context button} is
     * clicked.  The  context button, and the menu itself, will only be displayed if  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventCanvasMenuItems getEventCanvasMenuItems} returns  an array of
     * appropriate items for the event.
     * <p>
     * This component is an AutoChild named "eventCanvasContextMenu".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current eventCanvasContextMenu value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Menu getEventCanvasContextMenu() throws IllegalStateException {
        errorIfNotCreated("eventCanvasContextMenu");
        return (Menu)Menu.getByJSObject(getAttributeAsJavaScriptObject("eventCanvasContextMenu"));
    }
    

    /**
     * <b>Note :</b> This API is non-functional (always returns null) and exists only to make
     * you aware that this MultiAutoChild exists.  See {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}
     * for details.
     * <p>
     * The "gripper" widget that snaps to the top of an event canvas and allows an event to be dragged with the mouse.
     *
     * @return null
     */
    public Img getEventCanvasGripper()  {
        return null;
    }
    
    

    /**
     * <b>Note :</b> This API is non-functional (always returns null) and exists only to make
     * you aware that this MultiAutoChild exists.  See {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}
     * for details.
     * <p>
     * The resizer image that snaps to the left and right edges of an editable event canvas in a {@link
     * com.smartgwt.client.widgets.calendar.Timeline}, allowing it to be resized horizontally by dragging with the mouse.
     *
     * @return null
     */
    public Img getEventCanvasHResizer()  {
        return null;
    }
    

    /**
     * <b>Note :</b> This API is non-functional (always returns null) and exists only to make
     * you aware that this MultiAutoChild exists.  See {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}
     * for details.
     * <p>
     * 
     *
     * @return null
     */
    public Label getEventCanvasLabel()  {
        return null;
    }
    

    /**
     * <b>Note :</b> This API is non-functional (always returns null) and exists only to make
     * you aware that this MultiAutoChild exists.  See {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}
     * for details.
     * <p>
     * The resizer image that snaps to the bottom of event canvases in {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDayView day} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWeekView week} views, allowing them to be resized vertically by
     * dragging  with the mouse.
     *
     * @return null
     */
    public Img getEventCanvasVResizer()  {
        return null;
    }
    

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getDescriptionField descriptionField} field in
     * the quick  {@link com.smartgwt.client.widgets.calendar.Calendar#getEventDialog event dialog} and the detailed  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor editor}.
     *
     * @param eventDescriptionFieldTitle New eventDescriptionFieldTitle value. Default value is "Description"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public Calendar setEventDescriptionFieldTitle(String eventDescriptionFieldTitle)  throws IllegalStateException {
        return (Calendar)setAttribute("eventDescriptionFieldTitle", eventDescriptionFieldTitle, false);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getDescriptionField descriptionField} field in
     * the quick  {@link com.smartgwt.client.widgets.calendar.Calendar#getEventDialog event dialog} and the detailed  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor editor}.
     *
     * @return Current eventDescriptionFieldTitle value. Default value is "Description"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getEventDescriptionFieldTitle()  {
        return getAttributeAsString("eventDescriptionFieldTitle");
    }
    

    /**
     * An {@link com.smartgwt.client.types.AutoChild} of type {@link com.smartgwt.client.widgets.Window} that displays a quick
     * event entry form in a  popup window.
     * <p>
     * This component is an AutoChild named "eventDialog".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current eventDialog value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Window getEventDialog() throws IllegalStateException {
        errorIfNotCreated("eventDialog");
        return (Window)Window.getByJSObject(getAttributeAsJavaScriptObject("eventDialog"));
    }
    
    

    /**
     * The number of pixels to leave to the right of events so overlapping events can still be  added using the mouse.
     *
     * @param eventDragGap New eventDragGap value. Default value is 10
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     */
    public Calendar setEventDragGap(Integer eventDragGap) {
        return (Calendar)setAttribute("eventDragGap", eventDragGap, true);
    }

    /**
     * The number of pixels to leave to the right of events so overlapping events can still be  added using the mouse.
     *
     * @return Current eventDragGap value. Default value is 10
     */
    public Integer getEventDragGap()  {
        return getAttributeAsInt("eventDragGap");
    }
    

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getDurationField duration field} in the quick
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getEventDialog event dialog} and the detailed  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor editor}.
     *
     * @param eventDurationFieldTitle New eventDurationFieldTitle value. Default value is "Duration"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public Calendar setEventDurationFieldTitle(String eventDurationFieldTitle)  throws IllegalStateException {
        return (Calendar)setAttribute("eventDurationFieldTitle", eventDurationFieldTitle, false);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getDurationField duration field} in the quick
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getEventDialog event dialog} and the detailed  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor editor}.
     *
     * @return Current eventDurationFieldTitle value. Default value is "Duration"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getEventDurationFieldTitle()  {
        return getAttributeAsString("eventDurationFieldTitle");
    }
    

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getDurationUnitField duration unit field} in the
     * quick {@link com.smartgwt.client.widgets.calendar.Calendar#getEventDialog event dialog} and the detailed  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor editor}.
     *
     * @param eventDurationUnitFieldTitle New eventDurationUnitFieldTitle value. Default value is "&amp;nbsp;"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public Calendar setEventDurationUnitFieldTitle(String eventDurationUnitFieldTitle)  throws IllegalStateException {
        return (Calendar)setAttribute("eventDurationUnitFieldTitle", eventDurationUnitFieldTitle, false);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getDurationUnitField duration unit field} in the
     * quick {@link com.smartgwt.client.widgets.calendar.Calendar#getEventDialog event dialog} and the detailed  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor editor}.
     *
     * @return Current eventDurationUnitFieldTitle value. Default value is "&amp;nbsp;"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getEventDurationUnitFieldTitle()  {
        return getAttributeAsString("eventDurationUnitFieldTitle");
    }
    

    /**
     * An {@link com.smartgwt.client.types.AutoChild} of type {@link com.smartgwt.client.widgets.form.DynamicForm} which
     * displays {@link com.smartgwt.client.widgets.calendar.CalendarEvent event data}.  This form is created within the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditorLayout event editor layout}
     * <p>
     * This component is an AutoChild named "eventEditor".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current eventEditor value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public DynamicForm getEventEditor() throws IllegalStateException {
        errorIfNotCreated("eventEditor");
        return (DynamicForm)DynamicForm.getByJSObject(getAttributeAsJavaScriptObject("eventEditor"));
    }
    

    /**
     * An {@link com.smartgwt.client.types.AutoChild} of type {@link com.smartgwt.client.widgets.layout.HLayout} which houses
     * the  {@link com.smartgwt.client.widgets.calendar.Calendar#getSaveButton Save}, {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getRemoveButton Remove} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCancelButton Cancel} buttons in the  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor eventEditor}.
     * <p>
     * This component is an AutoChild named "eventEditorButtonLayout".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current eventEditorButtonLayout value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public HLayout getEventEditorButtonLayout() throws IllegalStateException {
        errorIfNotCreated("eventEditorButtonLayout");
        return (HLayout)HLayout.getByJSObject(getAttributeAsJavaScriptObject("eventEditorButtonLayout"));
    }
    
    

    /**
     * An {@link com.smartgwt.client.types.AutoChild} of type {@link com.smartgwt.client.widgets.Window} that displays the full
     *  {@link com.smartgwt.client.widgets.calendar.Calendar#getEventEditor event editor}
     * <p>
     * This component is an AutoChild named "eventEditorLayout".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current eventEditorLayout value. Default value is null
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
     * @param eventEndDateFieldTitle New eventEndDateFieldTitle value. Default value is "To"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public Calendar setEventEndDateFieldTitle(String eventEndDateFieldTitle)  throws IllegalStateException {
        return (Calendar)setAttribute("eventEndDateFieldTitle", eventEndDateFieldTitle, false);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getEndDateField endDateField} in the quick {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventDialog event dialog} and the detailed  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor editor}.
     *
     * @return Current eventEndDateFieldTitle value. Default value is "To"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getEventEndDateFieldTitle()  {
        return getAttributeAsString("eventEndDateFieldTitle");
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.calendar.Calendar#getEventHeaderWrap eventHeaderWrap} is false and  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowEventDescriptions showEventDescriptions} is true, this is the fixed
     *  height for the {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowHeader header area} in event canvases.
     *
     * @param eventHeaderHeight New eventHeaderHeight value. Default value is 14
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setEventHeaderHeight(int eventHeaderHeight)  throws IllegalStateException {
        return (Calendar)setAttribute("eventHeaderHeight", eventHeaderHeight, false);
    }

    /**
     * When {@link com.smartgwt.client.widgets.calendar.Calendar#getEventHeaderWrap eventHeaderWrap} is false and  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowEventDescriptions showEventDescriptions} is true, this is the fixed
     *  height for the {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowHeader header area} in event canvases.
     *
     * @return Current eventHeaderHeight value. Default value is 14
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
     * @param eventHeaderWrap New eventHeaderWrap value. Default value is true
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setEventHeaderWrap(boolean eventHeaderWrap)  throws IllegalStateException {
        return (Calendar)setAttribute("eventHeaderWrap", eventHeaderWrap, false);
    }

    /**
     * When rendering the {@link com.smartgwt.client.widgets.calendar.Calendar#getEventCanvas canvas} for an event, whether to
     * allow the   content of the {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowHeader header area} to wrap to
     * multiple lines. <P> The default is true - if set to false, the header area is  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventHeaderHeight fixed}, unless {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowEventDescriptions showEventDescriptions} is false, in which case
     * the header area fills the canvas.
     *
     * @return Current eventHeaderWrap value. Default value is true
     */
    public boolean getEventHeaderWrap()  {
        Boolean result = getAttributeAsBoolean("eventHeaderWrap");
        return result == null ? true : result;
    }
    

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getLaneNameField laneNameField} in the quick 
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getEventDialog event dialog} and the detailed  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor editor}.
     *
     * @param eventLaneFieldTitle New eventLaneFieldTitle value. Default value is "Lane"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public Calendar setEventLaneFieldTitle(String eventLaneFieldTitle)  throws IllegalStateException {
        return (Calendar)setAttribute("eventLaneFieldTitle", eventLaneFieldTitle, false);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getLaneNameField laneNameField} in the quick 
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getEventDialog event dialog} and the detailed  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor editor}.
     *
     * @return Current eventLaneFieldTitle value. Default value is "Lane"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getEventLaneFieldTitle()  {
        return getAttributeAsString("eventLaneFieldTitle");
    }
    

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getNameField nameField} in the quick {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventDialog event dialog} and the detailed  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor editor}.
     *
     * @param eventNameFieldTitle New eventNameFieldTitle value. Default value is "Event Name"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public Calendar setEventNameFieldTitle(String eventNameFieldTitle)  throws IllegalStateException {
        return (Calendar)setAttribute("eventNameFieldTitle", eventNameFieldTitle, false);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getNameField nameField} in the quick {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventDialog event dialog} and the detailed  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor editor}.
     *
     * @return Current eventNameFieldTitle value. Default value is "Event Name"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getEventNameFieldTitle()  {
        return getAttributeAsString("eventNameFieldTitle");
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.calendar.Calendar#getEventAutoArrange eventAutoArrange} is true, setting
     * eventOverlap to true causes events that  share timeslots to overlap each other by a percentage of their width, specified
     * by  {@link com.smartgwt.client.widgets.calendar.Calendar#getEventOverlapPercent eventOverlapPercent}.  The default is
     * true for Calendars and false for  {@link com.smartgwt.client.widgets.calendar.Timeline Timelines}.
     *
     * @param eventOverlap New eventOverlap value. Default value is true
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setEventOverlap(Boolean eventOverlap)  throws IllegalStateException {
        return (Calendar)setAttribute("eventOverlap", eventOverlap, false);
    }

    /**
     * When {@link com.smartgwt.client.widgets.calendar.Calendar#getEventAutoArrange eventAutoArrange} is true, setting
     * eventOverlap to true causes events that  share timeslots to overlap each other by a percentage of their width, specified
     * by  {@link com.smartgwt.client.widgets.calendar.Calendar#getEventOverlapPercent eventOverlapPercent}.  The default is
     * true for Calendars and false for  {@link com.smartgwt.client.widgets.calendar.Timeline Timelines}.
     *
     * @return Current eventOverlap value. Default value is true
     */
    public Boolean getEventOverlap()  {
        Boolean result = getAttributeAsBoolean("eventOverlap");
        return result == null ? true : result;
    }
    

    /**
     * When set to true, events that start at the same time will not overlap each other to prevent  events having their close
     * button hidden.
     *
     * @param eventOverlapIdenticalStartTimes New eventOverlapIdenticalStartTimes value. Default value is false
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setEventOverlapIdenticalStartTimes(Boolean eventOverlapIdenticalStartTimes)  throws IllegalStateException {
        return (Calendar)setAttribute("eventOverlapIdenticalStartTimes", eventOverlapIdenticalStartTimes, false);
    }

    /**
     * When set to true, events that start at the same time will not overlap each other to prevent  events having their close
     * button hidden.
     *
     * @return Current eventOverlapIdenticalStartTimes value. Default value is false
     */
    public Boolean getEventOverlapIdenticalStartTimes()  {
        Boolean result = getAttributeAsBoolean("eventOverlapIdenticalStartTimes");
        return result == null ? false : result;
    }
    

    /**
     * The size of the overlap, presented as a percentage of the width of events sharing timeslots.
     *
     * @param eventOverlapPercent New eventOverlapPercent value. Default value is 10
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setEventOverlapPercent(int eventOverlapPercent)  throws IllegalStateException {
        return (Calendar)setAttribute("eventOverlapPercent", eventOverlapPercent, false);
    }

    /**
     * The size of the overlap, presented as a percentage of the width of events sharing timeslots.
     *
     * @return Current eventOverlapPercent value. Default value is 10
     */
    public int getEventOverlapPercent()  {
        return getAttributeAsInt("eventOverlapPercent");
    }
    

    /**
     * The number of minutes that determines the positions to which events will snap when rendered, and when moved or resized
     * with the mouse. <P> If unset (the default), all views will snap to each cell boundary; 30 minutes in a default vertical
     * view, or one {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineGranularity column} in a default Timeline.
     * <P> If set to zero, views will snap to one of a set of known "sensible" defaults: for a default  vertical, this will be
     * 5 minutes.  For timelines, the eventSnapGap is automatic depending on the current {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineGranularity timelineGranularity}.  If {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineUnitsPerColumn timelineUnitsPerColumn}  is greater than 1, the
     * snapGap is set to one unit of the current granularity.  So, a  cell-resolution of 15 minutes would snap to every minute,
     * assuming there are at least 15  pixels per column. Otherwise, the snapGap is either 15 minutes, 1 hour, one day or one 
     * month, depending on granularity. <P> If any other value is specified, it is used where possible. <P> If the specified or
     * calculated value is less than the time covered by a single pixel in the  current view, then it can't be represented.  In
     * this case, it is rounded up to the lowest of  a set of "sensible" time-spans that <i>can</i> be represented: one of  [1,
     * 5, 10, 15, 20, 30, 60, 120, 240, 360, 480, 720, 1440]. <P> For example - a Timeline showing "day" columns cannot support
     * an eventSnapGap of 1 minute, unless each column is at least 1440 pixels wide - if the columns were only 150px wide, then
     * each pixel would represent around 9.6 minutes, which would result in unpleasant and unexpected  time-offsets when
     * dragging events.  So, the calculated eventSnapGap will be rounded  up to the nearest "sensible" time-span - in this
     * case, 10 minutes.  If the columns were only  60px wide, it would be 30 minutes.
     *
     * @param eventSnapGap New eventSnapGap value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public Calendar setEventSnapGap(Integer eventSnapGap) {
        return (Calendar)setAttribute("eventSnapGap", eventSnapGap, true);
    }

    /**
     * The number of minutes that determines the positions to which events will snap when rendered, and when moved or resized
     * with the mouse. <P> If unset (the default), all views will snap to each cell boundary; 30 minutes in a default vertical
     * view, or one {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineGranularity column} in a default Timeline.
     * <P> If set to zero, views will snap to one of a set of known "sensible" defaults: for a default  vertical, this will be
     * 5 minutes.  For timelines, the eventSnapGap is automatic depending on the current {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineGranularity timelineGranularity}.  If {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineUnitsPerColumn timelineUnitsPerColumn}  is greater than 1, the
     * snapGap is set to one unit of the current granularity.  So, a  cell-resolution of 15 minutes would snap to every minute,
     * assuming there are at least 15  pixels per column. Otherwise, the snapGap is either 15 minutes, 1 hour, one day or one 
     * month, depending on granularity. <P> If any other value is specified, it is used where possible. <P> If the specified or
     * calculated value is less than the time covered by a single pixel in the  current view, then it can't be represented.  In
     * this case, it is rounded up to the lowest of  a set of "sensible" time-spans that <i>can</i> be represented: one of  [1,
     * 5, 10, 15, 20, 30, 60, 120, 240, 360, 480, 720, 1440]. <P> For example - a Timeline showing "day" columns cannot support
     * an eventSnapGap of 1 minute, unless each column is at least 1440 pixels wide - if the columns were only 150px wide, then
     * each pixel would represent around 9.6 minutes, which would result in unpleasant and unexpected  time-offsets when
     * dragging events.  So, the calculated eventSnapGap will be rounded  up to the nearest "sensible" time-span - in this
     * case, 10 minutes.  If the columns were only  60px wide, it would be 30 minutes.
     *
     * @return Current eventSnapGap value. Default value is null
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
     * @param eventStartDateFieldTitle New eventStartDateFieldTitle value. Default value is "From"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public Calendar setEventStartDateFieldTitle(String eventStartDateFieldTitle)  throws IllegalStateException {
        return (Calendar)setAttribute("eventStartDateFieldTitle", eventStartDateFieldTitle, false);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getStartDateField startDateField} in the quick
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getEventDialog event dialog} and the detailed  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor editor}.
     *
     * @return Current eventStartDateFieldTitle value. Default value is "From"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
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
     * @param eventStyleName New eventStyleName value. Default value is "eventWindow"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Calendar setEventStyleName(String eventStyleName) {
        return (Calendar)setAttribute("eventStyleName", eventStyleName, true);
    }

    /**
     * The base name for the CSS class applied to {@link com.smartgwt.client.widgets.calendar.Calendar#getEventCanvas events}
     * when they're rendered in calendar views. This style will have "Header" and "Body" appended to it, according to  which
     * part of the event window is being styled. For example, to style the header, define a CSS class called
     * 'eventWindowHeader'.
     *
     * @return Current eventStyleName value. Default value is "eventWindow"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getEventStyleName()  {
        return getAttributeAsString("eventStyleName");
    }
    

    /**
     * The name of the field used to override {@link com.smartgwt.client.widgets.calendar.Calendar#getEventStyleName
     * eventStyleName} for an individual {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getStyleName
     * CalendarEvent.styleName}.
     *
     * @param eventStyleNameField New eventStyleNameField value. Default value is "styleName"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Calendar setEventStyleNameField(String eventStyleNameField)  throws IllegalStateException {
        return (Calendar)setAttribute("eventStyleNameField", eventStyleNameField, false);
    }

    /**
     * The name of the field used to override {@link com.smartgwt.client.widgets.calendar.Calendar#getEventStyleName
     * eventStyleName} for an individual {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getStyleName
     * CalendarEvent.styleName}.
     *
     * @return Current eventStyleNameField value. Default value is "styleName"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getEventStyleNameField()  {
        return getAttributeAsString("eventStyleNameField");
    }
    

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getSublaneNameField sublaneNameField} in the
     * quick  {@link com.smartgwt.client.widgets.calendar.Calendar#getEventDialog event dialog} and the detailed  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor event editor}.
     *
     * @param eventSublaneFieldTitle New eventSublaneFieldTitle value. Default value is "Sublane"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public Calendar setEventSublaneFieldTitle(String eventSublaneFieldTitle)  throws IllegalStateException {
        return (Calendar)setAttribute("eventSublaneFieldTitle", eventSublaneFieldTitle, false);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getSublaneNameField sublaneNameField} in the
     * quick  {@link com.smartgwt.client.widgets.calendar.Calendar#getEventDialog event dialog} and the detailed  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor event editor}.
     *
     * @return Current eventSublaneFieldTitle value. Default value is "Sublane"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getEventSublaneFieldTitle()  {
        return getAttributeAsString("eventSublaneFieldTitle");
    }
    

    /**
     * <b>Note :</b> This API is non-functional (always returns null) and exists only to make
     * you aware that this MultiAutoChild exists.  See {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}
     * for details.
     * <p>
     * To display events in day and week views, the Calendar creates instance of {@link
     * com.smartgwt.client.widgets.calendar.EventWindow} for each event.  Use the {@link com.smartgwt.client.types.AutoChild}
     * system to customize these windows.
     *
     * @return null
     * @deprecated in favor of {@link com.smartgwt.client.widgets.calendar.Calendar#getEventCanvas eventCanvas}
     */
    public EventWindow getEventWindow()  {
        return null;
    }
    

    /**
     * The base name for the CSS class applied to event windows within calendars. This style will have "Header", "HeaderLabel",
     * and "Body" appended to it, according to  which part of the event window is being styled. For example, to style the
     * header, define a CSS class called 'eventWindowHeader'.
     *
     * @param eventWindowStyle New eventWindowStyle value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     * @deprecated in favor of {@link com.smartgwt.client.widgets.calendar.Calendar#getEventStyleName eventStyleName}
     */
    public Calendar setEventWindowStyle(String eventWindowStyle) {
        return (Calendar)setAttribute("eventWindowStyle", eventWindowStyle, true);
    }

    /**
     * The base name for the CSS class applied to event windows within calendars. This style will have "Header", "HeaderLabel",
     * and "Body" appended to it, according to  which part of the event window is being styled. For example, to style the
     * header, define a CSS class called 'eventWindowHeader'.
     *
     * @return Current eventWindowStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     * @deprecated in favor of {@link com.smartgwt.client.widgets.calendar.Calendar#getEventStyleName eventStyleName}
     */
    public String getEventWindowStyle()  {
        return getAttributeAsString("eventWindowStyle");
    }
    

    /**
     * The name of the field used to override {@link com.smartgwt.client.widgets.calendar.Calendar#getEventWindowStyle
     * eventWindowStyle} for an individual {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.  See {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getEventWindowStyle CalendarEvent.eventWindowStyle}.
     *
     * @param eventWindowStyleField New eventWindowStyleField value. Default value is "eventWindowStyle"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     * @deprecated in favor of {@link com.smartgwt.client.widgets.calendar.Calendar#getEventStyleNameField eventStyleNameField}
     */
    public Calendar setEventWindowStyleField(String eventWindowStyleField)  throws IllegalStateException {
        return (Calendar)setAttribute("eventWindowStyleField", eventWindowStyleField, false);
    }

    /**
     * The name of the field used to override {@link com.smartgwt.client.widgets.calendar.Calendar#getEventWindowStyle
     * eventWindowStyle} for an individual {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.  See {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getEventWindowStyle CalendarEvent.eventWindowStyle}.
     *
     * @return Current eventWindowStyleField value. Default value is "eventWindowStyle"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     * @deprecated in favor of {@link com.smartgwt.client.widgets.calendar.Calendar#getEventStyleNameField eventStyleNameField}
     */
    public String getEventWindowStyleField()  {
        return getAttributeAsString("eventWindowStyleField");
    }
    

    /**
     * The numeric day (0-6, Sunday-Saturday) which the calendar should consider as the first  day of the week in multi-day
     * views, and in the popup {@link com.smartgwt.client.widgets.calendar.Calendar#getDateChooser DateChooser}. <P> If unset,
     * the default is taken from the current locale.
     *
     * @param firstDayOfWeek New firstDayOfWeek value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     */
    public Calendar setFirstDayOfWeek(Integer firstDayOfWeek) {
        return (Calendar)setAttribute("firstDayOfWeek", firstDayOfWeek, true);
    }

    /**
     * The numeric day (0-6, Sunday-Saturday) which the calendar should consider as the first  day of the week in multi-day
     * views, and in the popup {@link com.smartgwt.client.widgets.calendar.Calendar#getDateChooser DateChooser}. <P> If unset,
     * the default is taken from the current locale.
     *
     * @return Current firstDayOfWeek value. Default value is null
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
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     */
    public Calendar setHeaderLevels(HeaderLevel... headerLevels) {
        return (Calendar)setAttribute("headerLevels", headerLevels, true);
    }

    /**
     * Configures the levels of {@link com.smartgwt.client.widgets.calendar.HeaderLevel headers} shown above the event area,
     * and  their time units. <P> Header levels are provided from the top down, so the first header level should be the largest
     *  time unit and the last one the smallest.  The smallest is then used for the actual  field-headers.
     *
     * @return Current headerLevels value. Default value is null
     */
    public HeaderLevel[] getHeaderLevels()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfHeaderLevel(getAttributeAsJavaScriptObject("headerLevels"));
    }
    

    /**
     * When set to true, hides any {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes lane} that doesn't have any
     * active events in the current dataset.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for updating {@link com.smartgwt.client.widgets.calendar.Calendar#getHideUnusedLanes hideUnusedLanes} after creation.
     *
     * @param hideUnusedLanes whether to hide unused lanes. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     */
    public Calendar setHideUnusedLanes(Boolean hideUnusedLanes) {
        return (Calendar)setAttribute("hideUnusedLanes", hideUnusedLanes, true);
    }

    /**
     * When set to true, hides any {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes lane} that doesn't have any
     * active events in the current dataset.
     *
     * @return Current hideUnusedLanes value. Default value is null
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
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     */
    public Calendar setIndicators(CalendarEvent... indicators) {
        return (Calendar)setAttribute("indicators", indicators, true);
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
     * @return Current indicators value. Default value is null
     */
    public CalendarEvent[] getIndicators()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfCalendarEvent(getAttributeAsJavaScriptObject("indicators"));
    }
    

    /**
     * CSS style to apply to the {@link com.smartgwt.client.widgets.calendar.Calendar#getIndicatorCanvas canvases} created for
     * each specified {@link com.smartgwt.client.widgets.calendar.Calendar#getIndicators indicator}.
     *
     * @param indicatorStyleName New indicatorStyleName value. Default value is "indicatorCanvas"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public Calendar setIndicatorStyleName(String indicatorStyleName) {
        return (Calendar)setAttribute("indicatorStyleName", indicatorStyleName, true);
    }

    /**
     * CSS style to apply to the {@link com.smartgwt.client.widgets.calendar.Calendar#getIndicatorCanvas canvases} created for
     * each specified {@link com.smartgwt.client.widgets.calendar.Calendar#getIndicators indicator}.
     *
     * @return Current indicatorStyleName value. Default value is "indicatorCanvas"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getIndicatorStyleName()  {
        return getAttributeAsString("indicatorStyleName");
    }
    
    

    /**
     * The message to display in the {@link com.smartgwt.client.widgets.calendar.Calendar#getEventEditor eventEditor} when the
     * 'To' date is greater than the 'From' date and a save is attempted.
     *
     * @param invalidDateMessage New invalidDateMessage value. Default value is "From must be before To"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setInvalidDateMessage(String invalidDateMessage)  throws IllegalStateException {
        return (Calendar)setAttribute("invalidDateMessage", invalidDateMessage, false);
    }

    /**
     * The message to display in the {@link com.smartgwt.client.widgets.calendar.Calendar#getEventEditor eventEditor} when the
     * 'To' date is greater than the 'From' date and a save is attempted.
     *
     * @return Current invalidDateMessage value. Default value is "From must be before To"
     */
    public String getInvalidDateMessage()  {
        return getAttributeAsString("invalidDateMessage");
    }
    

    /**
     * The pixel space to leave between events and the edges of the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getLanes lane} or  {@link
     * com.smartgwt.client.widgets.calendar.Lane#getSublanes sublane} they appear in.  Only applicable to  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timelines} and to {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDayView dayViews} showing {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes day lanes}.
     *
     * @param laneEventPadding New laneEventPadding value. Default value is 0
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     */
    public Calendar setLaneEventPadding(Integer laneEventPadding) {
        return (Calendar)setAttribute("laneEventPadding", laneEventPadding, true);
    }

    /**
     * The pixel space to leave between events and the edges of the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getLanes lane} or  {@link
     * com.smartgwt.client.widgets.calendar.Lane#getSublanes sublane} they appear in.  Only applicable to  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timelines} and to {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDayView dayViews} showing {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes day lanes}.
     *
     * @return Current laneEventPadding value. Default value is 0
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
     * @param laneFields New laneFields value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setLaneFields(ListGridField... laneFields)  throws IllegalStateException {
        return (Calendar)setAttribute("laneFields", laneFields, false);
    }

    /**
     * Field definitions for the frozen area of the {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineView
     * timelineView}, which shows data about the timeline {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes lanes}.
     * Each field shows one attribute of the objects provided as {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes
     * lanes}. <P> When {@link com.smartgwt.client.widgets.calendar.Calendar#getCanGroupLanes lane grouping} is enabled, only
     * fields that are specified as lane fields can be used as group fields.
     *
     * @return Current laneFields value. Default value is null
     */
    public ListGridField[] getLaneFields()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfListGridField(getAttributeAsJavaScriptObject("laneFields"));
    }
    

    /**
     * For timelines with {@link com.smartgwt.client.widgets.calendar.Calendar#getCanGroupLanes canGroupLanes} set to true,
     * this is a  field name or array of field names on which to group the lanes in a timeline.
     *
     * @param laneGroupByField New laneGroupByField value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     */
    public Calendar setLaneGroupByField(String laneGroupByField) {
        return (Calendar)setAttribute("laneGroupByField", laneGroupByField, true);
    }

    /**
     * For timelines with {@link com.smartgwt.client.widgets.calendar.Calendar#getCanGroupLanes canGroupLanes} set to true,
     * this is a  field name or array of field names on which to group the lanes in a timeline.
     *
     * @return Current laneGroupByField value. Default value is null
     */
    public String getLaneGroupByField()  {
        return getAttributeAsString("laneGroupByField");
    }

    /**
     * For timelines with {@link com.smartgwt.client.widgets.calendar.Calendar#getCanGroupLanes canGroupLanes} set to true,
     * this is a  field name or array of field names on which to group the lanes in a timeline.
     *
     * @param laneGroupByField New laneGroupByField value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     */
    public Calendar setLaneGroupByField(String... laneGroupByField) {
        return (Calendar)setAttribute("laneGroupByField", laneGroupByField, true);
    }

    /**
     * For timelines with {@link com.smartgwt.client.widgets.calendar.Calendar#getCanGroupLanes canGroupLanes} set to true,
     * this is a  field name or array of field names on which to group the lanes in a timeline.
     *
     * @return Current laneGroupByField value. Default value is null
     */
    public String[] getLaneGroupByFieldAsStringArray()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("laneGroupByField"));
    }
    
    

    /**
     * The name of the field which will determine the {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes lane} in
     * which this  event will be displayed in {@link com.smartgwt.client.widgets.calendar.Timeline}s and in the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDayView day view}, if  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes showDayLanes} is true.
     *
     * @param laneNameField New laneNameField value. Default value is "lane"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public Calendar setLaneNameField(String laneNameField)  throws IllegalStateException {
        return (Calendar)setAttribute("laneNameField", laneNameField, false);
    }

    /**
     * The name of the field which will determine the {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes lane} in
     * which this  event will be displayed in {@link com.smartgwt.client.widgets.calendar.Timeline}s and in the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDayView day view}, if  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes showDayLanes} is true.
     *
     * @return Current laneNameField value. Default value is "lane"
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
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     */
    public Calendar setLanes(Lane... lanes) {
        return (Calendar)setAttribute("lanes", lanes, true);
    }

    /**
     * An array of {@link com.smartgwt.client.widgets.calendar.Lane} definitions that represent the rows of the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timelineView}, or the columns of the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDayView dayView} if {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes showDayLanes} is true.
     *
     * @return Current lanes value. Default value is null
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
     * @param leadingDateField New leadingDateField value. Default value is "leadingDate"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public Calendar setLeadingDateField(String leadingDateField)  throws IllegalStateException {
        return (Calendar)setAttribute("leadingDateField", leadingDateField, false);
    }

    /**
     * The name of the leading date field for each event.  When this attribute and  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTrailingDateField trailingDateField} are present in the data, a line
     * extends out from the event showing the extent of the leading and trailing dates - useful for visualizing a pipeline of
     * events  where some can be moved a certain amount without affecting others.
     *
     * @return Current leadingDateField value. Default value is "leadingDate"
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
     * This component is an AutoChild named "mainView".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current mainView value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public TabSet getMainView() throws IllegalStateException {
        errorIfNotCreated("mainView");
        return (TabSet)TabSet.getByJSObject(getAttributeAsJavaScriptObject("mainView"));
    }
    

    /**
     * A boolean value controlling whether the Calendar shows tabs for available calendar views. By default, this is true for
     * handsets and false otherwise.
     *
     * @param minimalUI New minimalUI value. Default value is false
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     */
    public Calendar setMinimalUI(boolean minimalUI) {
        return (Calendar)setAttribute("minimalUI", minimalUI, true);
    }

    /**
     * A boolean value controlling whether the Calendar shows tabs for available calendar views. By default, this is true for
     * handsets and false otherwise.
     *
     * @return Current minimalUI value. Default value is false
     */
    public boolean getMinimalUI()  {
        Boolean result = getAttributeAsBoolean("minimalUI");
        return result == null ? false : result;
    }
    

    /**
     * In the {@link com.smartgwt.client.widgets.calendar.Calendar#getMonthView month view} when {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowDayHeaders showDayHeaders} is true, this is the minimum height
     * applied to a day cell and its header combined. <P> If <code>showDayHeaders</code> is false, this attribute has no effect
     * - the minimum height  of day cells is either an equal share of the available height, or the rendered height of the
     * cell's HTML content, whichever is greater.  If the latter, a vertical scrollbar is shown.
     *
     * @param minimumDayHeight New minimumDayHeight value. Default value is 80
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Calendar setMinimumDayHeight(Integer minimumDayHeight) {
        return (Calendar)setAttribute("minimumDayHeight", minimumDayHeight, true);
    }

    /**
     * In the {@link com.smartgwt.client.widgets.calendar.Calendar#getMonthView month view} when {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowDayHeaders showDayHeaders} is true, this is the minimum height
     * applied to a day cell and its header combined. <P> If <code>showDayHeaders</code> is false, this attribute has no effect
     * - the minimum height  of day cells is either an equal share of the available height, or the rendered height of the
     * cell's HTML content, whichever is greater.  If the latter, a vertical scrollbar is shown.
     *
     * @return Current minimumDayHeight value. Default value is 80
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
     * @param minLaneWidth New minLaneWidth value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setMinLaneWidth(Integer minLaneWidth)  throws IllegalStateException {
        return (Calendar)setAttribute("minLaneWidth", minLaneWidth, false);
    }

    /**
     * When showing {@link com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes vertical lanes} in the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDayView dayView}, this attribute sets  the minimum width of each column
     * or field.
     *
     * @return Current minLaneWidth value. Default value is null
     */
    public Integer getMinLaneWidth()  {
        return getAttributeAsInt("minLaneWidth");
    }
    

    /**
     * The number of minutes per row in {@link com.smartgwt.client.widgets.calendar.Calendar#getDayView day} and  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWeekView week} views.  The default of 30 minutes shows two rows per
     * hour. Note that this value must divide into 60.
     *
     * @param minutesPerRow New minutesPerRow value. Default value is 30
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setMinutesPerRow(Integer minutesPerRow)  throws IllegalStateException {
        return (Calendar)setAttribute("minutesPerRow", minutesPerRow, false);
    }

    /**
     * The number of minutes per row in {@link com.smartgwt.client.widgets.calendar.Calendar#getDayView day} and  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWeekView week} views.  The default of 30 minutes shows two rows per
     * hour. Note that this value must divide into 60.
     *
     * @return Current minutesPerRow value. Default value is 30
     */
    public Integer getMinutesPerRow()  {
        return getAttributeAsInt("minutesPerRow");
    }
    

    /**
     * A {@link com.smartgwt.client.widgets.NavigationButton} that appears to the left of other navigation controls in the 
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getControlsBar controls bar} on Handset devices. <P> Used to show
     * and hide the {@link com.smartgwt.client.widgets.calendar.Calendar#getMonthView month view} on devices with limited
     * space.
     * <p>
     * This component is an AutoChild named "monthButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current monthButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public NavigationButton getMonthButton() throws IllegalStateException {
        errorIfNotCreated("monthButton");
        return (NavigationButton)NavigationButton.getByJSObject(getAttributeAsJavaScriptObject("monthButton"));
    }
    

    /**
     * The title of the {@link com.smartgwt.client.widgets.calendar.Calendar#getMonthButton month button}, used for showing and
     * hiding the {@link com.smartgwt.client.widgets.calendar.Calendar#getMonthView month view} on Handsets. <P> This is a
     * dynamic string - text within <code>&#36;{...}</code> are dynamic variables and will be evaluated as JS code when the
     * message is displayed. <P> Only one dynamic variable, monthName, is available and represents the name of the month 
     * containing the currently selected date. <P> The default value is a left-facing arrow followed by the Month-name of the
     * selected date. <P> When the month view is already visible, the title for the month button is set according to the value
     * of {@link com.smartgwt.client.widgets.calendar.Calendar#getBackButtonTitle backButtonTitle}.
     *
     * @param monthButtonTitle New monthButtonTitle value. Default value is "&amp;lt; ${monthName}"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public Calendar setMonthButtonTitle(String monthButtonTitle)  throws IllegalStateException {
        return (Calendar)setAttribute("monthButtonTitle", monthButtonTitle, false);
    }

    /**
     * The title of the {@link com.smartgwt.client.widgets.calendar.Calendar#getMonthButton month button}, used for showing and
     * hiding the {@link com.smartgwt.client.widgets.calendar.Calendar#getMonthView month view} on Handsets. <P> This is a
     * dynamic string - text within <code>&#36;{...}</code> are dynamic variables and will be evaluated as JS code when the
     * message is displayed. <P> Only one dynamic variable, monthName, is available and represents the name of the month 
     * containing the currently selected date. <P> The default value is a left-facing arrow followed by the Month-name of the
     * selected date. <P> When the month view is already visible, the title for the month button is set according to the value
     * of {@link com.smartgwt.client.widgets.calendar.Calendar#getBackButtonTitle backButtonTitle}.
     *
     * @return Current monthButtonTitle value. Default value is "&amp;lt; ${monthName}"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getMonthButtonTitle()  {
        return getAttributeAsString("monthButtonTitle");
    }
    

    /**
     * The title of the link shown in a cell of a {@link com.smartgwt.client.widgets.calendar.Calendar#getMonthView month view}
     * when there are too many events to be displayed at once. <P> This is a dynamic string - text within
     * <code>&#36;{...}</code> are dynamic variables and will  be evaluated as JS code when the message is displayed. <P> Only
     * one dynamic variable, eventCount, is available and represents the number of events that are not currently displayed and
     * that will appear in the menu displayed when the More Events  link is clicked. <P> The default value is a string like "+
     * 3 more...".
     *
     * @param monthMoreEventsLinkTitle New monthMoreEventsLinkTitle value. Default value is "+ ${eventCount} more..."
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public Calendar setMonthMoreEventsLinkTitle(String monthMoreEventsLinkTitle)  throws IllegalStateException {
        return (Calendar)setAttribute("monthMoreEventsLinkTitle", monthMoreEventsLinkTitle, false);
    }

    /**
     * The title of the link shown in a cell of a {@link com.smartgwt.client.widgets.calendar.Calendar#getMonthView month view}
     * when there are too many events to be displayed at once. <P> This is a dynamic string - text within
     * <code>&#36;{...}</code> are dynamic variables and will  be evaluated as JS code when the message is displayed. <P> Only
     * one dynamic variable, eventCount, is available and represents the number of events that are not currently displayed and
     * that will appear in the menu displayed when the More Events  link is clicked. <P> The default value is a string like "+
     * 3 more...".
     *
     * @return Current monthMoreEventsLinkTitle value. Default value is "+ ${eventCount} more..."
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getMonthMoreEventsLinkTitle()  {
        return getAttributeAsString("monthMoreEventsLinkTitle");
    }
    

    /**
     * AutoChild Menu, shown when a user clicks the  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getMonthMoreEventsLinkTitle more events} link in a cell of the  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getMonthView monthView}.  Items in this menu represent additional events, 
     * not already displayed in the cell, and clicking them fires the   {@link
     * com.smartgwt.client.widgets.calendar.Calendar#addEventClickHandler eventClick} notification.
     * <p>
     * This component is an AutoChild named "monthMoreEventsMenu".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current monthMoreEventsMenu value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Menu getMonthMoreEventsMenu() throws IllegalStateException {
        errorIfNotCreated("monthMoreEventsMenu");
        return (Menu)Menu.getByJSObject(getAttributeAsJavaScriptObject("monthMoreEventsMenu"));
    }
    

    /**
     * {@link com.smartgwt.client.widgets.calendar.CalendarView} used to display events that pertain to a given month.
     * <p>
     * This component is an AutoChild named "monthView".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current monthView value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public CalendarView getMonthView() throws IllegalStateException {
        errorIfNotCreated("monthView");
        return (CalendarView)CalendarView.getByJSObject(getAttributeAsJavaScriptObject("monthView"));
    }
    

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getMonthView month view}.
     *
     * @param monthViewTitle New monthViewTitle value. Default value is "Month"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setMonthViewTitle(String monthViewTitle)  throws IllegalStateException {
        return (Calendar)setAttribute("monthViewTitle", monthViewTitle, false);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getMonthView month view}.
     *
     * @return Current monthViewTitle value. Default value is "Month"
     */
    public String getMonthViewTitle()  {
        return getAttributeAsString("monthViewTitle");
    }
    

    /**
     * The name of the name field on a {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.
     *
     * @param nameField New nameField value. Default value is "name"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public Calendar setNameField(String nameField)  throws IllegalStateException {
        return (Calendar)setAttribute("nameField", nameField, false);
    }

    /**
     * The name of the name field on a {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.
     *
     * @return Current nameField value. Default value is "name"
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public String getNameField()  {
        return getAttributeAsString("nameField");
    }
    

    /**
     * An {@link com.smartgwt.client.widgets.ImgButton} that appears above the week/day/month views of the calendar and allows
     * the user to move the calendar forwards in time.
     * <p>
     * This component is an AutoChild named "nextButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current nextButton value. Default value is null
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
     * @param nextButtonHoverText New nextButtonHoverText value. Default value is "Next"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setNextButtonHoverText(String nextButtonHoverText)  throws IllegalStateException {
        return (Calendar)setAttribute("nextButtonHoverText", nextButtonHoverText, false);
    }

    /**
     * The text to be displayed when a user hovers over the {@link com.smartgwt.client.widgets.calendar.Calendar#getNextButton
     * next}  toolbar button
     *
     * @return Current nextButtonHoverText value. Default value is "Next"
     */
    public String getNextButtonHoverText()  {
        return getAttributeAsString("nextButtonHoverText");
    }
    

    /**
     * The CSS style applied to both the header and body of days from other months in the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getMonthView month view}, when {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowOtherDays showOtherDays} is false.
     *
     * @param otherDayBlankStyle New otherDayBlankStyle value. Default value is "calMonthOtherDayBlank"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Calendar setOtherDayBlankStyle(String otherDayBlankStyle)  throws IllegalStateException {
        return (Calendar)setAttribute("otherDayBlankStyle", otherDayBlankStyle, false);
    }

    /**
     * The CSS style applied to both the header and body of days from other months in the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getMonthView month view}, when {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowOtherDays showOtherDays} is false.
     *
     * @return Current otherDayBlankStyle value. Default value is "calMonthOtherDayBlank"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getOtherDayBlankStyle()  {
        return getAttributeAsString("otherDayBlankStyle");
    }
    

    /**
     * The base name for the CSS class applied to the day body of the month view of the calendar. This style will have "Dark",
     * "Over", "Selected", or "Disabled" appended to it according to the state of the cell. <P> See {@link
     * com.smartgwt.client.docs.CellStyleSuffixes} for details on how stateful suffixes are combined with the base style to
     * generate stateful cell styles.
     *
     * @param otherDayBodyBaseStyle New otherDayBodyBaseStyle value. Default value is "calMonthOtherDayBody"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Calendar setOtherDayBodyBaseStyle(String otherDayBodyBaseStyle) {
        return (Calendar)setAttribute("otherDayBodyBaseStyle", otherDayBodyBaseStyle, true);
    }

    /**
     * The base name for the CSS class applied to the day body of the month view of the calendar. This style will have "Dark",
     * "Over", "Selected", or "Disabled" appended to it according to the state of the cell. <P> See {@link
     * com.smartgwt.client.docs.CellStyleSuffixes} for details on how stateful suffixes are combined with the base style to
     * generate stateful cell styles.
     *
     * @return Current otherDayBodyBaseStyle value. Default value is "calMonthOtherDayBody"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getOtherDayBodyBaseStyle()  {
        return getAttributeAsString("otherDayBodyBaseStyle");
    }
    

    /**
     * The base name for the CSS class applied to the day headers of the month view. This style will have "Dark", "Over",
     * "Selected", or "Disabled" appended to it according to the state of the cell. <P> See {@link
     * com.smartgwt.client.docs.CellStyleSuffixes} for details on how stateful suffixes are combined with the base style to
     * generate stateful cell styles.
     *
     * @param otherDayHeaderBaseStyle New otherDayHeaderBaseStyle value. Default value is "calMonthDayHeader"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Calendar setOtherDayHeaderBaseStyle(String otherDayHeaderBaseStyle) {
        return (Calendar)setAttribute("otherDayHeaderBaseStyle", otherDayHeaderBaseStyle, true);
    }

    /**
     * The base name for the CSS class applied to the day headers of the month view. This style will have "Dark", "Over",
     * "Selected", or "Disabled" appended to it according to the state of the cell. <P> See {@link
     * com.smartgwt.client.docs.CellStyleSuffixes} for details on how stateful suffixes are combined with the base style to
     * generate stateful cell styles.
     *
     * @return Current otherDayHeaderBaseStyle value. Default value is "calMonthDayHeader"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getOtherDayHeaderBaseStyle()  {
        return getAttributeAsString("otherDayHeaderBaseStyle");
    }
    

    /**
     * A set of {@link com.smartgwt.client.data.SortSpecifier sort-specifiers} for customizing the render order of events that
     * overlap. <P> In {@link com.smartgwt.client.widgets.calendar.Timeline timelines}, this dictates the vertical rendering
     * order of  overlapped events in each {@link com.smartgwt.client.widgets.calendar.Lane lane}. <P> In {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDayView day} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWeekView week} views, it dictates the horizontal rendering order of
     * overlapped events in each column or Lane. <P> By default, events that share space in a Lane or column are rendered from
     * top to bottom, or left to right according to their {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getStartDateField start-dates} - the earliest in a  given lane appears
     * top-most in that lane, or left-most in its column. <P> Providing <code>overlapSortSpecifiers</code> allows for the
     * events to be ordered by one or more of the fields stored on the events, or in the underlying {@link
     * com.smartgwt.client.data.DataSource data-source}, if the Calendar is databound.
     *
     * @param overlapSortSpecifiers New overlapSortSpecifiers value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     */
    public Calendar setOverlapSortSpecifiers(SortSpecifier... overlapSortSpecifiers) {
        return (Calendar)setAttribute("overlapSortSpecifiers", overlapSortSpecifiers, true);
    }

    /**
     * A set of {@link com.smartgwt.client.data.SortSpecifier sort-specifiers} for customizing the render order of events that
     * overlap. <P> In {@link com.smartgwt.client.widgets.calendar.Timeline timelines}, this dictates the vertical rendering
     * order of  overlapped events in each {@link com.smartgwt.client.widgets.calendar.Lane lane}. <P> In {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDayView day} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWeekView week} views, it dictates the horizontal rendering order of
     * overlapped events in each column or Lane. <P> By default, events that share space in a Lane or column are rendered from
     * top to bottom, or left to right according to their {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getStartDateField start-dates} - the earliest in a  given lane appears
     * top-most in that lane, or left-most in its column. <P> Providing <code>overlapSortSpecifiers</code> allows for the
     * events to be ordered by one or more of the fields stored on the events, or in the underlying {@link
     * com.smartgwt.client.data.DataSource data-source}, if the Calendar is databound.
     *
     * @return Current overlapSortSpecifiers value. Default value is null
     */
    public SortSpecifier[] getOverlapSortSpecifiers()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfSortSpecifier(getAttributeAsJavaScriptObject("overlapSortSpecifiers"));
    }
    

    /**
     * An {@link com.smartgwt.client.widgets.ImgButton} that appears above the week/day/month views of the calendar and allows
     * the user to move the calendar backwards in time.
     * <p>
     * This component is an AutoChild named "previousButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current previousButton value. Default value is null
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
     * @param previousButtonHoverText New previousButtonHoverText value. Default value is "Previous"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setPreviousButtonHoverText(String previousButtonHoverText)  throws IllegalStateException {
        return (Calendar)setAttribute("previousButtonHoverText", previousButtonHoverText, false);
    }

    /**
     * The text to be displayed when a user hovers over the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getPreviousButton previous} toolbar button.
     *
     * @return Current previousButtonHoverText value. Default value is "Previous"
     */
    public String getPreviousButtonHoverText()  {
        return getAttributeAsString("previousButtonHoverText");
    }
    

    /**
     * An {@link com.smartgwt.client.types.AutoChild} of type {@link com.smartgwt.client.widgets.IButton}, used to permanently
     * remove an event from the  {@link com.smartgwt.client.widgets.calendar.Calendar#getEventEditor eventEditor}.
     * <p>
     * This component is an AutoChild named "removeButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current removeButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getRemoveButton() throws IllegalStateException {
        errorIfNotCreated("removeButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("removeButton"));
    }
    

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getRemoveButton Remove button} in the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor event editor}.
     *
     * @param removeButtonTitle New removeButtonTitle value. Default value is "Remove Event"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public Calendar setRemoveButtonTitle(String removeButtonTitle)  throws IllegalStateException {
        return (Calendar)setAttribute("removeButtonTitle", removeButtonTitle, false);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getRemoveButton Remove button} in the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor event editor}.
     *
     * @return Current removeButtonTitle value. Default value is "Remove Event"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getRemoveButtonTitle()  {
        return getAttributeAsString("removeButtonTitle");
    }
    

    /**
     * When set to true, the default, each {@link com.smartgwt.client.widgets.calendar.EventCanvas event} is rendered as it 
     * appears in the viewport.  If set to false, all events are rendered up-front, whenever the  current range changes. <P>
     * Has no effect when {@link com.smartgwt.client.widgets.calendar.Calendar#getShowColumnLayouts showColumnLayouts} is true.
     *
     * @param renderEventsOnDemand New renderEventsOnDemand value. Default value is true
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setRenderEventsOnDemand(boolean renderEventsOnDemand)  throws IllegalStateException {
        return (Calendar)setAttribute("renderEventsOnDemand", renderEventsOnDemand, false);
    }

    /**
     * When set to true, the default, each {@link com.smartgwt.client.widgets.calendar.EventCanvas event} is rendered as it 
     * appears in the viewport.  If set to false, all events are rendered up-front, whenever the  current range changes. <P>
     * Has no effect when {@link com.smartgwt.client.widgets.calendar.Calendar#getShowColumnLayouts showColumnLayouts} is true.
     *
     * @return Current renderEventsOnDemand value. Default value is true
     */
    public boolean getRenderEventsOnDemand()  {
        Boolean result = getAttributeAsBoolean("renderEventsOnDemand");
        return result == null ? true : result;
    }
    

    /**
     * The height of time-slots in the calendar.
     *
     * @param rowHeight New rowHeight value. Default value is 20
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     */
    public Calendar setRowHeight(int rowHeight) {
        return (Calendar)setAttribute("rowHeight", rowHeight, true);
    }

    /**
     * The height of time-slots in the calendar.
     *
     * @return Current rowHeight value. Default value is 20
     */
    public int getRowHeight()  {
        return getAttributeAsInt("rowHeight");
    }
    

    /**
     * A minute value that indicates which rows should show times in vertical views, like  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDayView day} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWeekView week}.  The default of 60 minutes  shows titles on the first
     * row of each hour.  The value provided must be a multiple of  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getMinutesPerRow minutesPerRow} and be no larger than 60.
     *
     * @param rowTitleFrequency New rowTitleFrequency value. Default value is 60
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setRowTitleFrequency(Integer rowTitleFrequency)  throws IllegalStateException {
        return (Calendar)setAttribute("rowTitleFrequency", rowTitleFrequency, false);
    }

    /**
     * A minute value that indicates which rows should show times in vertical views, like  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDayView day} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWeekView week}.  The default of 60 minutes  shows titles on the first
     * row of each hour.  The value provided must be a multiple of  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getMinutesPerRow minutesPerRow} and be no larger than 60.
     *
     * @return Current rowTitleFrequency value. Default value is 60
     */
    public Integer getRowTitleFrequency()  {
        return getAttributeAsInt("rowTitleFrequency");
    }
    

    /**
     * An {@link com.smartgwt.client.types.AutoChild} of type {@link com.smartgwt.client.widgets.IButton}, used to save an
     * event from the  {@link com.smartgwt.client.widgets.calendar.Calendar#getEventEditor eventEditor}.
     * <p>
     * This component is an AutoChild named "saveButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current saveButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getSaveButton() throws IllegalStateException {
        errorIfNotCreated("saveButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("saveButton"));
    }
    

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getSaveButton Save button} in the  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventDialog quick event dialog} and the  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor event editor}.
     *
     * @param saveButtonTitle New saveButtonTitle value. Default value is "Save Event"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public Calendar setSaveButtonTitle(String saveButtonTitle)  throws IllegalStateException {
        return (Calendar)setAttribute("saveButtonTitle", saveButtonTitle, false);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getSaveButton Save button} in the  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventDialog quick event dialog} and the  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor event editor}.
     *
     * @return Current saveButtonTitle value. Default value is "Save Event"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getSaveButtonTitle()  {
        return getAttributeAsString("saveButtonTitle");
    }
    

    /**
     * If set, causes the {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart workday hours} to be sized to
     * fill the available space in the day view and week view, and automatically scrolls these views to the start of the
     * workday when the calendar is first displayed and whenever the user switches to a new day or week.
     *
     * @param scrollToWorkday New scrollToWorkday value. Default value is false
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setScrollToWorkday(Boolean scrollToWorkday)  throws IllegalStateException {
        return (Calendar)setAttribute("scrollToWorkday", scrollToWorkday, false);
    }

    /**
     * If set, causes the {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart workday hours} to be sized to
     * fill the available space in the day view and week view, and automatically scrolls these views to the start of the
     * workday when the calendar is first displayed and whenever the user switches to a new day or week.
     *
     * @return Current scrollToWorkday value. Default value is false
     */
    public Boolean getScrollToWorkday()  {
        Boolean result = getAttributeAsBoolean("scrollToWorkday");
        return result == null ? false : result;
    }
    

    /**
     * When true, shows the current {@link com.smartgwt.client.widgets.calendar.Calendar#getChosenDate chosenDate} in a
     * selected style in the {@link com.smartgwt.client.widgets.calendar.Calendar#getMonthView month view}  Has no effect in
     * other views.
     *
     * @param selectChosenDate New selectChosenDate value. Default value is true
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public Calendar setSelectChosenDate(Boolean selectChosenDate) {
        return (Calendar)setAttribute("selectChosenDate", selectChosenDate, true);
    }

    /**
     * When true, shows the current {@link com.smartgwt.client.widgets.calendar.Calendar#getChosenDate chosenDate} in a
     * selected style in the {@link com.smartgwt.client.widgets.calendar.Calendar#getMonthView month view}  Has no effect in
     * other views.
     *
     * @return Current selectChosenDate value. Default value is true
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public Boolean getSelectChosenDate()  {
        Boolean result = getAttributeAsBoolean("selectChosenDate");
        return result == null ? true : result;
    }
    

    /**
     * The base name for the CSS class applied to a cell that is selected via a mouse drag.
     *
     * @param selectedCellStyle New selectedCellStyle value. Default value is "calendarCellSelected"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Calendar setSelectedCellStyle(String selectedCellStyle) {
        return (Calendar)setAttribute("selectedCellStyle", selectedCellStyle, true);
    }

    /**
     * The base name for the CSS class applied to a cell that is selected via a mouse drag.
     *
     * @return Current selectedCellStyle value. Default value is "calendarCellSelected"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getSelectedCellStyle()  {
        return getAttributeAsString("selectedCellStyle");
    }
    
    

    /**
     * Set to false to hide the {@link com.smartgwt.client.widgets.calendar.Calendar#getAddEventButton Add Event} button.
     *
     * @param showAddEventButton New showAddEventButton value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     */
    public Calendar setShowAddEventButton(Boolean showAddEventButton) {
        return (Calendar)setAttribute("showAddEventButton", showAddEventButton, true);
    }

    /**
     * Set to false to hide the {@link com.smartgwt.client.widgets.calendar.Calendar#getAddEventButton Add Event} button.
     *
     * @return Current showAddEventButton value. Default value is null
     */
    public Boolean getShowAddEventButton()  {
        return getAttributeAsBoolean("showAddEventButton");
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.calendar.Calendar#getShowViewHovers showViewHovers} is true, dictates whether to
     * display hover prompts when the mouse rolls over the normal cells in the body of CalendarViews. <P> The content of the
     * hover is determined by a call to  {@link com.smartgwt.client.widgets.calendar.Calendar#getCellHoverHTML
     * getCellHoverHTML()}, which can be overridden to return custom results; by  default, it returns the cell's date as a
     * string.
     *
     * @param showCellHovers New showCellHovers value. Default value is false
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setShowCellHovers(Boolean showCellHovers)  throws IllegalStateException {
        return (Calendar)setAttribute("showCellHovers", showCellHovers, false);
    }

    /**
     * When {@link com.smartgwt.client.widgets.calendar.Calendar#getShowViewHovers showViewHovers} is true, dictates whether to
     * display hover prompts when the mouse rolls over the normal cells in the body of CalendarViews. <P> The content of the
     * hover is determined by a call to  {@link com.smartgwt.client.widgets.calendar.Calendar#getCellHoverHTML
     * getCellHoverHTML()}, which can be overridden to return custom results; by  default, it returns the cell's date as a
     * string.
     *
     * @return Current showCellHovers value. Default value is false
     */
    public Boolean getShowCellHovers()  {
        Boolean result = getAttributeAsBoolean("showCellHovers");
        return result == null ? false : result;
    }
    

    /**
     * When true, causes {@link com.smartgwt.client.widgets.calendar.Calendar#getColumnLayout layouts} to be added to each
     * column in  vertical views.  In this mode, eventCanvases are stacked in these layouts, filling width  and auto-sizing
     * vertically to content, rather than being placed, sized and overlapped  according to their times. <P> Because times are
     * ignored in this mode, various behaviors are switched off automatically; for example, the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowLabelColumn time-column} is hidden and event-canvases  cannot be
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getCanResizeEvents resized} or rendered {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getRenderEventsOnDemand on-demand}.
     *
     * @param showColumnLayouts New showColumnLayouts value. Default value is false
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Calendar setShowColumnLayouts(Boolean showColumnLayouts)  throws IllegalStateException {
        return (Calendar)setAttribute("showColumnLayouts", showColumnLayouts, false);
    }

    /**
     * When true, causes {@link com.smartgwt.client.widgets.calendar.Calendar#getColumnLayout layouts} to be added to each
     * column in  vertical views.  In this mode, eventCanvases are stacked in these layouts, filling width  and auto-sizing
     * vertically to content, rather than being placed, sized and overlapped  according to their times. <P> Because times are
     * ignored in this mode, various behaviors are switched off automatically; for example, the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowLabelColumn time-column} is hidden and event-canvases  cannot be
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getCanResizeEvents resized} or rendered {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getRenderEventsOnDemand on-demand}.
     *
     * @return Current showColumnLayouts value. Default value is false
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowColumnLayouts()  {
        Boolean result = getAttributeAsBoolean("showColumnLayouts");
        return result == null ? false : result;
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
     * @param showControlsBar New showControlsBar value. Default value is true
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setShowControlsBar(Boolean showControlsBar)  throws IllegalStateException {
        return (Calendar)setAttribute("showControlsBar", showControlsBar, false);
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
     * @return Current showControlsBar value. Default value is true
     */
    public Boolean getShowControlsBar()  {
        Boolean result = getAttributeAsBoolean("showControlsBar");
        return result == null ? true : result;
    }
    

    /**
     * Determines whether the {@link com.smartgwt.client.widgets.calendar.Calendar#getDateChooser dateChooser} is displayed.
     *
     * @param showDateChooser New showDateChooser value. Default value is true
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public Calendar setShowDateChooser(Boolean showDateChooser)  throws IllegalStateException {
        return (Calendar)setAttribute("showDateChooser", showDateChooser, false);
    }

    /**
     * Determines whether the {@link com.smartgwt.client.widgets.calendar.Calendar#getDateChooser dateChooser} is displayed.
     *
     * @return Current showDateChooser value. Default value is true
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public Boolean getShowDateChooser()  {
        Boolean result = getAttributeAsBoolean("showDateChooser");
        return result == null ? true : result;
    }
    

    /**
     * Set to false to hide the {@link com.smartgwt.client.widgets.calendar.Calendar#getDatePickerButton datePickerButton} that
     * allows selecting a new base date for  this Calendar.
     *
     * @param showDatePickerButton New showDatePickerButton value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     */
    public Calendar setShowDatePickerButton(Boolean showDatePickerButton) {
        return (Calendar)setAttribute("showDatePickerButton", showDatePickerButton, true);
    }

    /**
     * Set to false to hide the {@link com.smartgwt.client.widgets.calendar.Calendar#getDatePickerButton datePickerButton} that
     * allows selecting a new base date for  this Calendar.
     *
     * @return Current showDatePickerButton value. Default value is null
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
     * @param showDayHeaders New showDayHeaders value. Default value is true
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public Calendar setShowDayHeaders(Boolean showDayHeaders)  throws IllegalStateException {
        return (Calendar)setAttribute("showDayHeaders", showDayHeaders, false);
    }

    /**
     * If true, the default, show a header cell for each day cell in the  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getMonthView month view}, with both cells having a minimum combined height
     * of  {@link com.smartgwt.client.widgets.calendar.Calendar#getMinimumDayHeight minimumDayHeight}.  If false, the header
     * cells will not be shown, and the value  of {@link com.smartgwt.client.widgets.calendar.Calendar#getMinimumDayHeight
     * minimumDayHeight} is ignored.  This causes the available vertical space in month views to be shared equally between day
     * cells, such that no vertical scrollbar is required unless the HTML in the cells renders them taller than will fit.
     *
     * @return Current showDayHeaders value. Default value is true
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public Boolean getShowDayHeaders()  {
        Boolean result = getAttributeAsBoolean("showDayHeaders");
        return result == null ? true : result;
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
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setShowDayLanes(Boolean showDayLanes)  throws IllegalStateException {
        return (Calendar)setAttribute("showDayLanes", showDayLanes, false);
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
     * @return Current showDayLanes value. Default value is null
     */
    public Boolean getShowDayLanes()  {
        return getAttributeAsBoolean("showDayLanes");
    }
    

    /**
     * Whether to show the Day view.
     *
     * @param showDayView New showDayView value. Default value is true
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Calendar setShowDayView(Boolean showDayView)  throws IllegalStateException {
        return (Calendar)setAttribute("showDayView", showDayView, false);
    }

    /**
     * Whether to show the Day view.
     *
     * @return Current showDayView value. Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowDayView()  {
        Boolean result = getAttributeAsBoolean("showDayView");
        return result == null ? true : result;
    }
    

    /**
     * Whether to show fields marked <code>detail:true</code> when a DataBoundComponent is  given a DataSource but no
     * <code>component.fields</code>. <p> The <code>detail</code> property is used on DataSource fields to mark fields that 
     * shouldn't appear by default in a view that tries to show many records in a small space.
     *
     * @param showDetailFields New showDetailFields value. Default value is true
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public Calendar setShowDetailFields(Boolean showDetailFields)  throws IllegalStateException {
        return (Calendar)setAttribute("showDetailFields", showDetailFields, false);
    }

    /**
     * Whether to show fields marked <code>detail:true</code> when a DataBoundComponent is  given a DataSource but no
     * <code>component.fields</code>. <p> The <code>detail</code> property is used on DataSource fields to mark fields that 
     * shouldn't appear by default in a view that tries to show many records in a small space.
     *
     * @return Current showDetailFields value. Default value is true
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public Boolean getShowDetailFields()  {
        Boolean result = getAttributeAsBoolean("showDetailFields");
        return result == null ? true : result;
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.calendar.Calendar#getShowViewHovers showViewHovers} is true, dictates whether to
     * display hover prompts when an event is being dragged with the mouse. <P> The content of the hover is determined by a
     * call to  {@link com.smartgwt.client.widgets.calendar.Calendar#getDragHoverHTML getDragHoverHTML()}, which can be
     * overridden to return custom results; by  default, it returns the date range of the drag canvas as a string.
     *
     * @param showDragHovers New showDragHovers value. Default value is false
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     */
    public Calendar setShowDragHovers(Boolean showDragHovers) {
        return (Calendar)setAttribute("showDragHovers", showDragHovers, true);
    }

    /**
     * When {@link com.smartgwt.client.widgets.calendar.Calendar#getShowViewHovers showViewHovers} is true, dictates whether to
     * display hover prompts when an event is being dragged with the mouse. <P> The content of the hover is determined by a
     * call to  {@link com.smartgwt.client.widgets.calendar.Calendar#getDragHoverHTML getDragHoverHTML()}, which can be
     * overridden to return custom results; by  default, it returns the date range of the drag canvas as a string.
     *
     * @return Current showDragHovers value. Default value is false
     */
    public Boolean getShowDragHovers()  {
        Boolean result = getAttributeAsBoolean("showDragHovers");
        return result == null ? false : result;
    }
    

    /**
     * Whether {@link com.smartgwt.client.widgets.calendar.Calendar#getEventCanvas event-canvases} should show a custom widget
     * as content,  rather than the default {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowHeader header} and 
     * {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowBody body} HTML.
     *
     * @param showEventCanvasComponents New showEventCanvasComponents value. Default value is false
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.calendar.Calendar#createEventCanvasComponent
     * @see com.smartgwt.client.widgets.calendar.Calendar#updateEventCanvasComponent
     */
    public Calendar setShowEventCanvasComponents(boolean showEventCanvasComponents)  throws IllegalStateException {
        return (Calendar)setAttribute("showEventCanvasComponents", showEventCanvasComponents, false);
    }

    /**
     * Whether {@link com.smartgwt.client.widgets.calendar.Calendar#getEventCanvas event-canvases} should show a custom widget
     * as content,  rather than the default {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowHeader header} and 
     * {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowBody body} HTML.
     *
     * @return Current showEventCanvasComponents value. Default value is false
     * @see com.smartgwt.client.widgets.calendar.Calendar#createEventCanvasComponent
     * @see com.smartgwt.client.widgets.calendar.Calendar#updateEventCanvasComponent
     */
    public boolean getShowEventCanvasComponents()  {
        Boolean result = getAttributeAsBoolean("showEventCanvasComponents");
        return result == null ? false : result;
    }
    

    /**
     * When rendering the {@link com.smartgwt.client.widgets.calendar.Calendar#getEventCanvas canvas} for an event, whether to
     * show the  {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowBody body area}, typically containing brief
     * details of the event -  {@link com.smartgwt.client.widgets.calendar.Calendar#getEventBodyHTML by default},  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDescriptionField its description}. <P> The default is true - if set to
     * false, the event's {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowHeader header}  will fill the canvas.
     *
     * @param showEventDescriptions New showEventDescriptions value. Default value is true
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setShowEventDescriptions(boolean showEventDescriptions)  throws IllegalStateException {
        return (Calendar)setAttribute("showEventDescriptions", showEventDescriptions, false);
    }

    /**
     * When rendering the {@link com.smartgwt.client.widgets.calendar.Calendar#getEventCanvas canvas} for an event, whether to
     * show the  {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowBody body area}, typically containing brief
     * details of the event -  {@link com.smartgwt.client.widgets.calendar.Calendar#getEventBodyHTML by default},  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDescriptionField its description}. <P> The default is true - if set to
     * false, the event's {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowHeader header}  will fill the canvas.
     *
     * @return Current showEventDescriptions value. Default value is true
     */
    public boolean getShowEventDescriptions()  {
        Boolean result = getAttributeAsBoolean("showEventDescriptions");
        return result == null ? true : result;
    }
    

    /**
     * When rendering the {@link com.smartgwt.client.widgets.calendar.Calendar#getEventCanvas canvas} for an event, whether to
     * show the  {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowHeader header area}, typically containing
     * suitable title text -  {@link com.smartgwt.client.widgets.calendar.Calendar#getEventHeaderHTML by default}, the event's
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getNameField name}. <P> The default is true - if set to false, the
     * event's {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowBody body area}  will fill the canvas.
     *
     * @param showEventHeaders New showEventHeaders value. Default value is true
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setShowEventHeaders(boolean showEventHeaders)  throws IllegalStateException {
        return (Calendar)setAttribute("showEventHeaders", showEventHeaders, false);
    }

    /**
     * When rendering the {@link com.smartgwt.client.widgets.calendar.Calendar#getEventCanvas canvas} for an event, whether to
     * show the  {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowHeader header area}, typically containing
     * suitable title text -  {@link com.smartgwt.client.widgets.calendar.Calendar#getEventHeaderHTML by default}, the event's
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getNameField name}. <P> The default is true - if set to false, the
     * event's {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowBody body area}  will fill the canvas.
     *
     * @return Current showEventHeaders value. Default value is true
     */
    public boolean getShowEventHeaders()  {
        Boolean result = getAttributeAsBoolean("showEventHeaders");
        return result == null ? true : result;
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.calendar.Calendar#getShowViewHovers showViewHovers} is true, dictates whether to
     * display hover prompts when the mouse moves over an {@link com.smartgwt.client.widgets.calendar.EventCanvas event canvas}
     * in a  calendarView. <P> The content of the hover is determined by a call to  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCellHoverHTML getCellHoverHTML()}, which can be overridden to return
     * custom results.
     *
     * @param showEventHovers New showEventHovers value. Default value is true
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     */
    public Calendar setShowEventHovers(Boolean showEventHovers) {
        return (Calendar)setAttribute("showEventHovers", showEventHovers, true);
    }

    /**
     * When {@link com.smartgwt.client.widgets.calendar.Calendar#getShowViewHovers showViewHovers} is true, dictates whether to
     * display hover prompts when the mouse moves over an {@link com.smartgwt.client.widgets.calendar.EventCanvas event canvas}
     * in a  calendarView. <P> The content of the hover is determined by a call to  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCellHoverHTML getCellHoverHTML()}, which can be overridden to return
     * custom results.
     *
     * @return Current showEventHovers value. Default value is true
     */
    public Boolean getShowEventHovers()  {
        Boolean result = getAttributeAsBoolean("showEventHovers");
        return result == null ? true : result;
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.calendar.Calendar#getShowViewHovers showViewHovers} is true, dictates whether to
     * display hover prompts when the mouse rolls over the {@link com.smartgwt.client.widgets.calendar.Calendar#getHeaderLevels
     * header levels} in a {@link com.smartgwt.client.widgets.calendar.CalendarView}. <P> The content of the hover is
     * determined by a call to  {@link com.smartgwt.client.widgets.calendar.Calendar#getHeaderHoverHTML getHeaderHoverHTML()},
     * which can be overridden to return custom results;
     *
     * @param showHeaderHovers New showHeaderHovers value. Default value is false
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setShowHeaderHovers(Boolean showHeaderHovers)  throws IllegalStateException {
        return (Calendar)setAttribute("showHeaderHovers", showHeaderHovers, false);
    }

    /**
     * When {@link com.smartgwt.client.widgets.calendar.Calendar#getShowViewHovers showViewHovers} is true, dictates whether to
     * display hover prompts when the mouse rolls over the {@link com.smartgwt.client.widgets.calendar.Calendar#getHeaderLevels
     * header levels} in a {@link com.smartgwt.client.widgets.calendar.CalendarView}. <P> The content of the hover is
     * determined by a call to  {@link com.smartgwt.client.widgets.calendar.Calendar#getHeaderHoverHTML getHeaderHoverHTML()},
     * which can be overridden to return custom results;
     *
     * @return Current showHeaderHovers value. Default value is false
     */
    public Boolean getShowHeaderHovers()  {
        Boolean result = getAttributeAsBoolean("showHeaderHovers");
        return result == null ? false : result;
    }
    

    /**
     * Set to true to render any defined {@link com.smartgwt.client.widgets.calendar.Calendar#getIndicators indicators} into 
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timeline views}.
     *
     * @param showIndicators New showIndicators value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     */
    public Calendar setShowIndicators(Boolean showIndicators) {
        return (Calendar)setAttribute("showIndicators", showIndicators, true);
    }

    /**
     * Set to true to render any defined {@link com.smartgwt.client.widgets.calendar.Calendar#getIndicators indicators} into 
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timeline views}.
     *
     * @return Current showIndicators value. Default value is null
     */
    public Boolean getShowIndicators()  {
        return getAttributeAsBoolean("showIndicators");
    }
    

    /**
     * In {@link com.smartgwt.client.widgets.calendar.Calendar#getIndicators indicator lines} are showing, this attribute
     * affects where in  the z-order their canvases will be rendered:  either in front of, or behind normal calendar events.
     *
     * @param showIndicatorsInFront New showIndicatorsInFront value. Default value is true
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setShowIndicatorsInFront(boolean showIndicatorsInFront)  throws IllegalStateException {
        return (Calendar)setAttribute("showIndicatorsInFront", showIndicatorsInFront, false);
    }

    /**
     * In {@link com.smartgwt.client.widgets.calendar.Calendar#getIndicators indicator lines} are showing, this attribute
     * affects where in  the z-order their canvases will be rendered:  either in front of, or behind normal calendar events.
     *
     * @return Current showIndicatorsInFront value. Default value is true
     */
    public boolean getShowIndicatorsInFront()  {
        Boolean result = getAttributeAsBoolean("showIndicatorsInFront");
        return result == null ? true : result;
    }
    

    /**
     * When set to false, hides the frozen Label-Column in vertical {@link com.smartgwt.client.widgets.calendar.CalendarView}s.
     * <P> Always false when {@link com.smartgwt.client.widgets.calendar.Calendar#getShowColumnLayouts showColumnLayouts} is
     * true.
     *
     * @param showLabelColumn New showLabelColumn value. Default value is true
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setShowLabelColumn(boolean showLabelColumn)  throws IllegalStateException {
        return (Calendar)setAttribute("showLabelColumn", showLabelColumn, false);
    }

    /**
     * When set to false, hides the frozen Label-Column in vertical {@link com.smartgwt.client.widgets.calendar.CalendarView}s.
     * <P> Always false when {@link com.smartgwt.client.widgets.calendar.Calendar#getShowColumnLayouts showColumnLayouts} is
     * true.
     *
     * @return Current showLabelColumn value. Default value is true
     */
    public boolean getShowLabelColumn()  {
        Boolean result = getAttributeAsBoolean("showLabelColumn");
        return result == null ? true : result;
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.calendar.Calendar#getShowViewHovers showViewHovers} is true, dictates whether to
     * display hover prompts when the mouse moves over the cells in a  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getLaneFields laneField}. <P> The content of the hover is determined by a
     * call to  {@link com.smartgwt.client.widgets.calendar.Calendar#getCellHoverHTML getCellHoverHTML()}, which can be
     * overridden to return custom results.  Note  that getCellHoverHTML() is also called when the mouse moves over cells if
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getShowCellHovers showCellHovers} is true - when called for a
     * laneField, no "date" parameter is passed to that method.
     *
     * @param showLaneFieldHovers New showLaneFieldHovers value. Default value is false
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     */
    public Calendar setShowLaneFieldHovers(Boolean showLaneFieldHovers) {
        return (Calendar)setAttribute("showLaneFieldHovers", showLaneFieldHovers, true);
    }

    /**
     * When {@link com.smartgwt.client.widgets.calendar.Calendar#getShowViewHovers showViewHovers} is true, dictates whether to
     * display hover prompts when the mouse moves over the cells in a  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getLaneFields laneField}. <P> The content of the hover is determined by a
     * call to  {@link com.smartgwt.client.widgets.calendar.Calendar#getCellHoverHTML getCellHoverHTML()}, which can be
     * overridden to return custom results.  Note  that getCellHoverHTML() is also called when the mouse moves over cells if
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getShowCellHovers showCellHovers} is true - when called for a
     * laneField, no "date" parameter is passed to that method.
     *
     * @return Current showLaneFieldHovers value. Default value is false
     */
    public Boolean getShowLaneFieldHovers()  {
        Boolean result = getAttributeAsBoolean("showLaneFieldHovers");
        return result == null ? false : result;
    }
    

    /**
     * When set to true, causes {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineView Timelines}, and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDayView day views} with  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes showDayLanes} set, to highlight the Lane under the mouse
     * with the "Over" style.
     *
     * @param showLaneRollOver New showLaneRollOver value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     */
    public Calendar setShowLaneRollOver(Boolean showLaneRollOver) {
        return (Calendar)setAttribute("showLaneRollOver", showLaneRollOver, true);
    }

    /**
     * When set to true, causes {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineView Timelines}, and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDayView day views} with  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes showDayLanes} set, to highlight the Lane under the mouse
     * with the "Over" style.
     *
     * @return Current showLaneRollOver value. Default value is null
     */
    public Boolean getShowLaneRollOver()  {
        return getAttributeAsBoolean("showLaneRollOver");
    }
    

    /**
     * Set to false to prevent the {@link com.smartgwt.client.widgets.calendar.Calendar#getMonthButton Month} button from
     * displaying on Handset  devices.
     *
     * @param showMonthButton New showMonthButton value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     */
    public Calendar setShowMonthButton(Boolean showMonthButton) {
        return (Calendar)setAttribute("showMonthButton", showMonthButton, true);
    }

    /**
     * Set to false to prevent the {@link com.smartgwt.client.widgets.calendar.Calendar#getMonthButton Month} button from
     * displaying on Handset  devices.
     *
     * @return Current showMonthButton value. Default value is null
     */
    public Boolean getShowMonthButton()  {
        return getAttributeAsBoolean("showMonthButton");
    }
    

    /**
     * Whether to show the Month view.
     *
     * @param showMonthView New showMonthView value. Default value is true
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Calendar setShowMonthView(Boolean showMonthView)  throws IllegalStateException {
        return (Calendar)setAttribute("showMonthView", showMonthView, false);
    }

    /**
     * Whether to show the Month view.
     *
     * @return Current showMonthView value. Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowMonthView()  {
        Boolean result = getAttributeAsBoolean("showMonthView");
        return result == null ? true : result;
    }
    

    /**
     * Set to false to hide the {@link com.smartgwt.client.widgets.calendar.Calendar#getNextButton Next} button.
     *
     * @param showNextButton New showNextButton value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     */
    public Calendar setShowNextButton(Boolean showNextButton) {
        return (Calendar)setAttribute("showNextButton", showNextButton, true);
    }

    /**
     * Set to false to hide the {@link com.smartgwt.client.widgets.calendar.Calendar#getNextButton Next} button.
     *
     * @return Current showNextButton value. Default value is null
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
     * @param showOtherDays New showOtherDays value. Default value is true
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public Calendar setShowOtherDays(Boolean showOtherDays)  throws IllegalStateException {
        return (Calendar)setAttribute("showOtherDays", showOtherDays, false);
    }

    /**
     * If set to true, in the {@link com.smartgwt.client.widgets.calendar.Calendar#getMonthView month view}, days that fall in
     * an adjacent month are still shown with a header and body area, and are interactive.  Otherwise days from other  months
     * are rendered in the {@link com.smartgwt.client.widgets.calendar.Calendar#getOtherDayBlankStyle otherDayBlankStyle} and
     * are non-interactive.
     *
     * @return Current showOtherDays value. Default value is true
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public Boolean getShowOtherDays()  {
        Boolean result = getAttributeAsBoolean("showOtherDays");
        return result == null ? true : result;
    }
    

    /**
     * Set to false to hide the {@link com.smartgwt.client.widgets.calendar.Calendar#getPreviousButton Previous} button.
     *
     * @param showPreviousButton New showPreviousButton value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     */
    public Calendar setShowPreviousButton(Boolean showPreviousButton) {
        return (Calendar)setAttribute("showPreviousButton", showPreviousButton, true);
    }

    /**
     * Set to false to hide the {@link com.smartgwt.client.widgets.calendar.Calendar#getPreviousButton Previous} button.
     *
     * @return Current showPreviousButton value. Default value is null
     */
    public Boolean getShowPreviousButton()  {
        return getAttributeAsBoolean("showPreviousButton");
    }
    

    /**
     * Determines whether the quick event dialog is displayed when a time is clicked. If this is false, the full event editor
     * is displayed.
     *
     * @param showQuickEventDialog New showQuickEventDialog value. Default value is true
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public Calendar setShowQuickEventDialog(Boolean showQuickEventDialog)  throws IllegalStateException {
        return (Calendar)setAttribute("showQuickEventDialog", showQuickEventDialog, false);
    }

    /**
     * Determines whether the quick event dialog is displayed when a time is clicked. If this is false, the full event editor
     * is displayed.
     *
     * @return Current showQuickEventDialog value. Default value is true
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public Boolean getShowQuickEventDialog()  {
        Boolean result = getAttributeAsBoolean("showQuickEventDialog");
        return result == null ? true : result;
    }
    

    /**
     * If set to true, show the {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineView Timeline view}.
     *
     * @param showTimelineView New showTimelineView value. Default value is false
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     */
    public Calendar setShowTimelineView(Boolean showTimelineView) {
        return (Calendar)setAttribute("showTimelineView", showTimelineView, true);
    }

    /**
     * If set to true, show the {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineView Timeline view}.
     *
     * @return Current showTimelineView value. Default value is false
     */
    public Boolean getShowTimelineView()  {
        Boolean result = getAttributeAsBoolean("showTimelineView");
        return result == null ? false : result;
    }
    

    /**
     * When set to true, the default value, causes the Calendar to show customizable hovers when  the mouse moves over various
     * areas of a CalendarView. <P> See {@link com.smartgwt.client.widgets.calendar.Calendar#getShowEventHovers
     * showEventHovers},  {@link com.smartgwt.client.widgets.calendar.Calendar#getShowZoneHovers showZoneHovers}, {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowHeaderHovers showHeaderHovers}, {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowCellHovers showCellHovers}, {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowLaneFieldHovers showLaneFieldHovers}, {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowDragHovers showDragHovers} for further configuration options.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Switches the various levels of {@link com.smartgwt.client.widgets.calendar.Calendar#getShowViewHovers hovers} on or off at runtime.
     *
     * @param showViewHovers whether to allow CalendarViews to show hovers. Default value is true
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     */
    public Calendar setShowViewHovers(Boolean showViewHovers) {
        return (Calendar)setAttribute("showViewHovers", showViewHovers, true);
    }

    /**
     * When set to true, the default value, causes the Calendar to show customizable hovers when  the mouse moves over various
     * areas of a CalendarView. <P> See {@link com.smartgwt.client.widgets.calendar.Calendar#getShowEventHovers
     * showEventHovers},  {@link com.smartgwt.client.widgets.calendar.Calendar#getShowZoneHovers showZoneHovers}, {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowHeaderHovers showHeaderHovers}, {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowCellHovers showCellHovers}, {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowLaneFieldHovers showLaneFieldHovers}, {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowDragHovers showDragHovers} for further configuration options.
     *
     * @return Current showViewHovers value. Default value is true
     */
    public Boolean getShowViewHovers()  {
        Boolean result = getAttributeAsBoolean("showViewHovers");
        return result == null ? true : result;
    }
    

    /**
     * Suppresses the display of weekend days in the {@link com.smartgwt.client.widgets.calendar.Calendar#getWeekView week}, 
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getMonthView month} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timeline} views, and  disallows the creation of events on
     * weekends.  Which days are considered weekends is  controlled by {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWeekendDays weekendDays}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for updating {@link com.smartgwt.client.widgets.calendar.Calendar#getShowWeekends showWeekends} at runtime.
     *
     * @param showWeekends whether or not to show weekends. Default value is true
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public Calendar setShowWeekends(Boolean showWeekends) {
        return (Calendar)setAttribute("showWeekends", showWeekends, true);
    }

    /**
     * Suppresses the display of weekend days in the {@link com.smartgwt.client.widgets.calendar.Calendar#getWeekView week}, 
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getMonthView month} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timeline} views, and  disallows the creation of events on
     * weekends.  Which days are considered weekends is  controlled by {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWeekendDays weekendDays}.
     *
     * @return Current showWeekends value. Default value is true
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public Boolean getShowWeekends()  {
        Boolean result = getAttributeAsBoolean("showWeekends");
        return result == null ? true : result;
    }
    

    /**
     * Whether to show the Week view.
     *
     * @param showWeekView New showWeekView value. Default value is true
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Calendar setShowWeekView(Boolean showWeekView)  throws IllegalStateException {
        return (Calendar)setAttribute("showWeekView", showWeekView, false);
    }

    /**
     * Whether to show the Week view.
     *
     * @return Current showWeekView value. Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowWeekView()  {
        Boolean result = getAttributeAsBoolean("showWeekView");
        return result == null ? true : result;
    }
    

    /**
     * If set, causes the calendar to use {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayBaseStyle
     * workdayBaseStyle} for cells falling within the workday as defined by {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart workdayStart} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWorkdayEnd workdayEnd}, in both the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWeekView weekView} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDayView dayView}. <P> The hours of the workday can be customized for
     * particular dates by providing implementations of {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart
     * getWorkdayStart()} and {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayEnd getWorkdayEnd()}.
     *
     * @param showWorkday New showWorkday value. Default value is false
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setShowWorkday(Boolean showWorkday)  throws IllegalStateException {
        return (Calendar)setAttribute("showWorkday", showWorkday, false);
    }

    /**
     * If set, causes the calendar to use {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayBaseStyle
     * workdayBaseStyle} for cells falling within the workday as defined by {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart workdayStart} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWorkdayEnd workdayEnd}, in both the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWeekView weekView} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDayView dayView}. <P> The hours of the workday can be customized for
     * particular dates by providing implementations of {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart
     * getWorkdayStart()} and {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayEnd getWorkdayEnd()}.
     *
     * @return Current showWorkday value. Default value is false
     */
    public Boolean getShowWorkday()  {
        Boolean result = getAttributeAsBoolean("showWorkday");
        return result == null ? false : result;
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.calendar.Calendar#getShowViewHovers showViewHovers} is true, dictates whether to
     * display hover prompts when the mouse moves over a {@link com.smartgwt.client.widgets.calendar.Calendar#getZones zone} in
     * a calendarView. <P> When {@link com.smartgwt.client.widgets.calendar.Calendar#getShowCellHovers showCellHovers} is true,
     * this attribute is ignored and zone hovers are not displayed. <P> The content of the hover is determined by a call to 
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getZoneHoverHTML getZoneHoverHTML()}, which can be overridden to
     * return custom results.
     *
     * @param showZoneHovers New showZoneHovers value. Default value is true
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     */
    public Calendar setShowZoneHovers(Boolean showZoneHovers) {
        return (Calendar)setAttribute("showZoneHovers", showZoneHovers, true);
    }

    /**
     * When {@link com.smartgwt.client.widgets.calendar.Calendar#getShowViewHovers showViewHovers} is true, dictates whether to
     * display hover prompts when the mouse moves over a {@link com.smartgwt.client.widgets.calendar.Calendar#getZones zone} in
     * a calendarView. <P> When {@link com.smartgwt.client.widgets.calendar.Calendar#getShowCellHovers showCellHovers} is true,
     * this attribute is ignored and zone hovers are not displayed. <P> The content of the hover is determined by a call to 
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getZoneHoverHTML getZoneHoverHTML()}, which can be overridden to
     * return custom results.
     *
     * @return Current showZoneHovers value. Default value is true
     */
    public Boolean getShowZoneHovers()  {
        Boolean result = getAttributeAsBoolean("showZoneHovers");
        return result == null ? true : result;
    }
    

    /**
     * Set to true to render any defined {@link com.smartgwt.client.widgets.calendar.Calendar#getZones zones} into  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timeline views}.
     *
     * @param showZones New showZones value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     */
    public Calendar setShowZones(Boolean showZones) {
        return (Calendar)setAttribute("showZones", showZones, true);
    }

    /**
     * Set to true to render any defined {@link com.smartgwt.client.widgets.calendar.Calendar#getZones zones} into  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timeline views}.
     *
     * @return Current showZones value. Default value is null
     */
    public Boolean getShowZones()  {
        return getAttributeAsBoolean("showZones");
    }
    

    /**
     * If true, events will be sized to the grid, even if they start and/or end at times between grid cells.
     *
     * @param sizeEventsToGrid New sizeEventsToGrid value. Default value is true
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setSizeEventsToGrid(Boolean sizeEventsToGrid)  throws IllegalStateException {
        return (Calendar)setAttribute("sizeEventsToGrid", sizeEventsToGrid, false);
    }

    /**
     * If true, events will be sized to the grid, even if they start and/or end at times between grid cells.
     *
     * @return Current sizeEventsToGrid value. Default value is true
     */
    public Boolean getSizeEventsToGrid()  {
        Boolean result = getAttributeAsBoolean("sizeEventsToGrid");
        return result == null ? true : result;
    }
    

    /**
     * The start date of the calendar {@link com.smartgwt.client.widgets.calendar.Timeline timeline view}.  Has no effect in 
     * other views.  If not specified, defaults to a timeline starting from the beginning  of the current {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineGranularity timelineGranularity} and spanning {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDefaultTimelineColumnSpan a default of 20} columns of that granularity.
     * <P> To set different start and {@link com.smartgwt.client.widgets.calendar.Calendar#getEndDate end} dates after initial
     * draw, see {@link com.smartgwt.client.widgets.calendar.Calendar#setTimelineRange setTimelineRange}. <P> Note that the
     * value you provide may be automatically altered if showing  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getHeaderLevels header-levels}, to fit to header boundaries.
     *
     * @param startDate New startDate value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setStartDate(Date startDate)  throws IllegalStateException {
        return (Calendar)setAttribute("startDate", startDate, false);
    }

    /**
     * The start date of the calendar {@link com.smartgwt.client.widgets.calendar.Timeline timeline view}.  Has no effect in 
     * other views.  If not specified, defaults to a timeline starting from the beginning  of the current {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineGranularity timelineGranularity} and spanning {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDefaultTimelineColumnSpan a default of 20} columns of that granularity.
     * <P> To set different start and {@link com.smartgwt.client.widgets.calendar.Calendar#getEndDate end} dates after initial
     * draw, see {@link com.smartgwt.client.widgets.calendar.Calendar#setTimelineRange setTimelineRange}. <P> Note that the
     * value you provide may be automatically altered if showing  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getHeaderLevels header-levels}, to fit to header boundaries.
     *
     * @return Current startDate value. Default value is null
     */
    public Date getStartDate()  {
        return getAttributeAsDate("startDate");
    }
    

    /**
     * The name of the start date field on a {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.
     *
     * @param startDateField New startDateField value. Default value is "startDate"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public Calendar setStartDateField(String startDateField)  throws IllegalStateException {
        return (Calendar)setAttribute("startDateField", startDateField, false);
    }

    /**
     * The name of the start date field on a {@link com.smartgwt.client.widgets.calendar.CalendarEvent}.
     *
     * @return Current startDateField value. Default value is "startDate"
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
     * @param sublaneNameField New sublaneNameField value. Default value is "sublane"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setSublaneNameField(String sublaneNameField)  throws IllegalStateException {
        return (Calendar)setAttribute("sublaneNameField", sublaneNameField, false);
    }

    /**
     * The name of the field which will determine the {@link com.smartgwt.client.widgets.calendar.Lane#getSublanes sublane} in
     * which this  event will be displayed, within its parent Lane, in {@link com.smartgwt.client.widgets.calendar.Timeline}s
     * and in the  {@link com.smartgwt.client.widgets.calendar.Calendar#getDayView day view}, if {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes showDayLanes} is true.
     *
     * @return Current sublaneNameField value. Default value is "sublane"
     */
    public String getSublaneNameField()  {
        return getAttributeAsString("sublaneNameField");
    }
    
    

    /**
     * The granularity in which the {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timelineView} will
     * display events. Possible values are those available in the built-in {@link com.smartgwt.client.types.TimeUnit TimeUnit}
     * type.
     *
     * @param timelineGranularity New timelineGranularity value. Default value is "day"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setTimelineGranularity(TimeUnit timelineGranularity)  throws IllegalStateException {
        return (Calendar)setAttribute("timelineGranularity", timelineGranularity == null ? null : timelineGranularity.getValue(), false);
    }

    /**
     * The granularity in which the {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timelineView} will
     * display events. Possible values are those available in the built-in {@link com.smartgwt.client.types.TimeUnit TimeUnit}
     * type.
     *
     * @return Current timelineGranularity value. Default value is "day"
     */
    public TimeUnit getTimelineGranularity()  {
        return EnumUtil.getEnum(TimeUnit.values(), getAttribute("timelineGranularity"));
    }
    

    /**
     * How many units of {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineGranularity timelineGranularity} each
     * cell represents.
     *
     * @param timelineUnitsPerColumn New timelineUnitsPerColumn value. Default value is 1
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setTimelineUnitsPerColumn(int timelineUnitsPerColumn)  throws IllegalStateException {
        return (Calendar)setAttribute("timelineUnitsPerColumn", timelineUnitsPerColumn, false);
    }

    /**
     * How many units of {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineGranularity timelineGranularity} each
     * cell represents.
     *
     * @return Current timelineUnitsPerColumn value. Default value is 1
     */
    public int getTimelineUnitsPerColumn()  {
        return getAttributeAsInt("timelineUnitsPerColumn");
    }
    

    /**
     * {@link com.smartgwt.client.widgets.calendar.CalendarView} used to display events in lanes in a horizontal {@link
     * com.smartgwt.client.widgets.calendar.Timeline} view.
     * <p>
     * This component is an AutoChild named "timelineView".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current timelineView value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public CalendarView getTimelineView() throws IllegalStateException {
        errorIfNotCreated("timelineView");
        return (CalendarView)CalendarView.getByJSObject(getAttributeAsJavaScriptObject("timelineView"));
    }
    

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timeline view}.
     *
     * @param timelineViewTitle New timelineViewTitle value. Default value is "Timeline"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setTimelineViewTitle(String timelineViewTitle)  throws IllegalStateException {
        return (Calendar)setAttribute("timelineViewTitle", timelineViewTitle, false);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timeline view}.
     *
     * @return Current timelineViewTitle value. Default value is "Timeline"
     */
    public String getTimelineViewTitle()  {
        return getAttributeAsString("timelineViewTitle");
    }
    

    /**
     * The background color for cells that represent today in all {@link com.smartgwt.client.widgets.calendar.CalendarView}s.
     *
     * @param todayBackgroundColor New todayBackgroundColor value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setTodayBackgroundColor(String todayBackgroundColor)  throws IllegalStateException {
        return (Calendar)setAttribute("todayBackgroundColor", todayBackgroundColor, false);
    }

    /**
     * The background color for cells that represent today in all {@link com.smartgwt.client.widgets.calendar.CalendarView}s.
     *
     * @return Current todayBackgroundColor value. Default value is null
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
     * @param trailingDateField New trailingDateField value. Default value is "trailingDate"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public Calendar setTrailingDateField(String trailingDateField)  throws IllegalStateException {
        return (Calendar)setAttribute("trailingDateField", trailingDateField, false);
    }

    /**
     * The name of the trailing date field for each event.  When this attribute and  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getLeadingDateField leadingDateField} are present in the data, a line
     * extends out from the event showing  the extent of the leading and trailing dates - useful for visualizing a pipeline of
     * events  where some can be moved a certain amount without affecting others.
     *
     * @return Current trailingDateField value. Default value is "trailingDate"
     * @see com.smartgwt.client.widgets.calendar.CalendarEvent
     */
    public String getTrailingDateField()  {
        return getAttributeAsString("trailingDateField");
    }
    

    /**
     * Dictates whether times throughout the widget are formatted and edited as 24-hour values.  If unset, defaults to the
     * String.  If set, and no {@link com.smartgwt.client.widgets.calendar.Calendar#getTimeFormatter local formatter} is
     * installed, causes the  Calendar to choose an appropriate builtin formatter.
     *
     * @param twentyFourHourTime New twentyFourHourTime value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setTwentyFourHourTime(Boolean twentyFourHourTime)  throws IllegalStateException {
        return (Calendar)setAttribute("twentyFourHourTime", twentyFourHourTime, false);
    }

    /**
     * Dictates whether times throughout the widget are formatted and edited as 24-hour values.  If unset, defaults to the
     * String.  If set, and no {@link com.smartgwt.client.widgets.calendar.Calendar#getTimeFormatter local formatter} is
     * installed, causes the  Calendar to choose an appropriate builtin formatter.
     *
     * @return Current twentyFourHourTime value. Default value is null
     */
    public Boolean getTwentyFourHourTime()  {
        return getAttributeAsBoolean("twentyFourHourTime");
    }
    

    /**
     * By default, the {@link com.smartgwt.client.widgets.calendar.Calendar#getEventCanvasCloseButton close buttons} and the
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getEventCanvasHResizer horizontal} and  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventCanvasVResizer vertical} resizer widgets  for event canvases are
     * shown only when the mouse is over a given event.  Set this attribute to false to have event canvases show these widgets
     * permanently.
     *
     * @param useEventCanvasRolloverControls New useEventCanvasRolloverControls value. Default value is true
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setUseEventCanvasRolloverControls(boolean useEventCanvasRolloverControls)  throws IllegalStateException {
        return (Calendar)setAttribute("useEventCanvasRolloverControls", useEventCanvasRolloverControls, false);
    }

    /**
     * By default, the {@link com.smartgwt.client.widgets.calendar.Calendar#getEventCanvasCloseButton close buttons} and the
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getEventCanvasHResizer horizontal} and  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventCanvasVResizer vertical} resizer widgets  for event canvases are
     * shown only when the mouse is over a given event.  Set this attribute to false to have event canvases show these widgets
     * permanently.
     *
     * @return Current useEventCanvasRolloverControls value. Default value is true
     */
    public boolean getUseEventCanvasRolloverControls()  {
        Boolean result = getAttributeAsBoolean("useEventCanvasRolloverControls");
        return result == null ? true : result;
    }
    

    /**
     * When set to true, causes {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes lanes} to be sub-divided
     * according to their set of {@link com.smartgwt.client.widgets.calendar.Lane#getSublanes sublanes}.
     *
     * @param useSublanes New useSublanes value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setUseSublanes(Boolean useSublanes)  throws IllegalStateException {
        return (Calendar)setAttribute("useSublanes", useSublanes, false);
    }

    /**
     * When set to true, causes {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes lanes} to be sub-divided
     * according to their set of {@link com.smartgwt.client.widgets.calendar.Lane#getSublanes sublanes}.
     *
     * @return Current useSublanes value. Default value is null
     */
    public Boolean getUseSublanes()  {
        return getAttributeAsBoolean("useSublanes");
    }
    

    /**
     * An array of integer day-numbers that should be considered to be weekend days by this Calendar instance.  If unset,
     * defaults to the set of days indicated  {@link com.smartgwt.client.util.DateUtil#weekendDays globally}.
     *
     * @param weekendDays New weekendDays value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public Calendar setWeekendDays(int... weekendDays) {
        return (Calendar)setAttribute("weekendDays", weekendDays, true);
    }

    /**
     * An array of integer day-numbers that should be considered to be weekend days by this Calendar instance.  If unset,
     * defaults to the set of days indicated  {@link com.smartgwt.client.util.DateUtil#weekendDays globally}.
     *
     * @return Current weekendDays value. Default value is null
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public int[] getWeekendDays()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfint(getAttributeAsJavaScriptObject("weekendDays"));
    }
    

    /**
     * Augments the width of week event windows slightly to avoid duplicate adjacent borders between events.
     *
     * @param weekEventBorderOverlap New weekEventBorderOverlap value. Default value is false
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Calendar setWeekEventBorderOverlap(Boolean weekEventBorderOverlap)  throws IllegalStateException {
        return (Calendar)setAttribute("weekEventBorderOverlap", weekEventBorderOverlap, false);
    }

    /**
     * Augments the width of week event windows slightly to avoid duplicate adjacent borders between events.
     *
     * @return Current weekEventBorderOverlap value. Default value is false
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getWeekEventBorderOverlap()  {
        Boolean result = getAttributeAsBoolean("weekEventBorderOverlap");
        return result == null ? false : result;
    }
    

    /**
     * The text to appear before the week number in the title of {@link com.smartgwt.client.types.TimeUnit week-based}  {@link
     * com.smartgwt.client.widgets.calendar.HeaderLevel}s when this calendar is showing a timeline.
     *
     * @param weekPrefix New weekPrefix value. Default value is "Week"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public Calendar setWeekPrefix(String weekPrefix)  throws IllegalStateException {
        return (Calendar)setAttribute("weekPrefix", weekPrefix, false);
    }

    /**
     * The text to appear before the week number in the title of {@link com.smartgwt.client.types.TimeUnit week-based}  {@link
     * com.smartgwt.client.widgets.calendar.HeaderLevel}s when this calendar is showing a timeline.
     *
     * @return Current weekPrefix value. Default value is "Week"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getWeekPrefix()  {
        return getAttributeAsString("weekPrefix");
    }
    

    /**
     * {@link com.smartgwt.client.widgets.calendar.CalendarView} used to display events that pertain to a given week.
     * <p>
     * This component is an AutoChild named "weekView".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current weekView value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public CalendarView getWeekView() throws IllegalStateException {
        errorIfNotCreated("weekView");
        return (CalendarView)CalendarView.getByJSObject(getAttributeAsJavaScriptObject("weekView"));
    }
    

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getWeekView week view}.
     *
     * @param weekViewTitle New weekViewTitle value. Default value is "Week"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setWeekViewTitle(String weekViewTitle)  throws IllegalStateException {
        return (Calendar)setAttribute("weekViewTitle", weekViewTitle, false);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.calendar.Calendar#getWeekView week view}.
     *
     * @return Current weekViewTitle value. Default value is "Week"
     */
    public String getWeekViewTitle()  {
        return getAttributeAsString("weekViewTitle");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.calendar.Calendar#getShowWorkday showWorkday} is set, this is the style used for
     * cells that are within the workday,  as defined by {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart
     * workdayStart} and {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayEnd workdayEnd}, or by a date-specific
     * range  provided in {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart getWorkdayStart()} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWorkdayEnd getWorkdayEnd()} implementations.
     *
     * @param workdayBaseStyle New workdayBaseStyle value. Default value is "calendarWorkday"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Calendar setWorkdayBaseStyle(String workdayBaseStyle)  throws IllegalStateException {
        return (Calendar)setAttribute("workdayBaseStyle", workdayBaseStyle, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.calendar.Calendar#getShowWorkday showWorkday} is set, this is the style used for
     * cells that are within the workday,  as defined by {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart
     * workdayStart} and {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayEnd workdayEnd}, or by a date-specific
     * range  provided in {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart getWorkdayStart()} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWorkdayEnd getWorkdayEnd()} implementations.
     *
     * @return Current workdayBaseStyle value. Default value is "calendarWorkday"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getWorkdayBaseStyle()  {
        return getAttributeAsString("workdayBaseStyle");
    }
    

    /**
     * When using {@link com.smartgwt.client.widgets.calendar.Calendar#getShowWorkday showWorkday}:true,
     * <code>workdayStart</code> and <code>workdayEnd</code> specify the time of day when the workday starts and ends,
     * specified as a String acceptable to String. <P> Both start and end time must fall on a 30 minute increment (eg 9:30, but
     * not 9:45). <P> The hours of the workday can be customized for particular dates by providing implementations of {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart getWorkdayStart()} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWorkdayEnd getWorkdayEnd()}.
     *
     * @param workdayEnd New workdayEnd value. Default value is "5:00pm"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setWorkdayEnd(String workdayEnd)  throws IllegalStateException {
        return (Calendar)setAttribute("workdayEnd", workdayEnd, false);
    }
    
    

    /**
     * When using {@link com.smartgwt.client.widgets.calendar.Calendar#getShowWorkday showWorkday}:true,
     * <code>workdayStart</code> and <code>workdayEnd</code> specify the time of day when the workday starts and ends,
     * specified as a String acceptable to String. <P> Both start and end time must fall on a 30 minute increment (eg 9:30, but
     * not 9:45). <P> The hours of the workday can be customized for particular dates by providing implementations of {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart getWorkdayStart()} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWorkdayEnd getWorkdayEnd()}.
     *
     * @param workdayStart New workdayStart value. Default value is "9:00am"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setWorkdayStart(String workdayStart)  throws IllegalStateException {
        return (Calendar)setAttribute("workdayStart", workdayStart, false);
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
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     */
    public Calendar setZones(CalendarEvent... zones) {
        return (Calendar)setAttribute("zones", zones, true);
    }

    /**
     * An array of CalendarEvent instances representing pre-defined periods of time to be  highlighted in {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timeline views}.  Each zone renders out a {@link
     * com.smartgwt.client.widgets.calendar.ZoneCanvas zone canvas}, a special, non-interactive subclass of  {@link
     * com.smartgwt.client.widgets.calendar.EventCanvas}, which spans all lanes and draws behind any normal, interactive 
     * events in the zorder. <P> The default {@link com.smartgwt.client.widgets.calendar.Calendar#getZoneStyleName style} for
     * these components renders them  semi-transparent and with a bottom-aligned title label.
     *
     * @return Current zones value. Default value is null
     */
    public CalendarEvent[] getZones()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfCalendarEvent(getAttributeAsJavaScriptObject("zones"));
    }
    

    /**
     * CSS style to apply to the {@link com.smartgwt.client.widgets.calendar.Calendar#getZoneCanvas canvases} created for each
     * specified {@link com.smartgwt.client.widgets.calendar.Calendar#getZones zone}.
     *
     * @param zoneStyleName New zoneStyleName value. Default value is "zoneCanvas"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public Calendar setZoneStyleName(String zoneStyleName) {
        return (Calendar)setAttribute("zoneStyleName", zoneStyleName, true);
    }

    /**
     * CSS style to apply to the {@link com.smartgwt.client.widgets.calendar.Calendar#getZoneCanvas canvases} created for each
     * specified {@link com.smartgwt.client.widgets.calendar.Calendar#getZones zone}.
     *
     * @return Current zoneStyleName value. Default value is "zoneCanvas"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getZoneStyleName()  {
        return getAttributeAsString("zoneStyleName");
    }
    

    /**
     * The vertical alignment of the header-text in each {@link com.smartgwt.client.widgets.calendar.Calendar#getZones zone}.
     *
     * @param zoneTitleOrientation New zoneTitleOrientation value. Default value is "bottom"
     * @return {@link com.smartgwt.client.widgets.calendar.Calendar Calendar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Calendar setZoneTitleOrientation(VerticalAlignment zoneTitleOrientation)  throws IllegalStateException {
        return (Calendar)setAttribute("zoneTitleOrientation", zoneTitleOrientation == null ? null : zoneTitleOrientation.getValue(), false);
    }

    /**
     * The vertical alignment of the header-text in each {@link com.smartgwt.client.widgets.calendar.Calendar#getZones zone}.
     *
     * @return Current zoneTitleOrientation value. Default value is "bottom"
     */
    public VerticalAlignment getZoneTitleOrientation()  {
        return EnumUtil.getEnum(VerticalAlignment.values(), getAttribute("zoneTitleOrientation"));
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addCalendarEvent", "CalendarEvent");
        }
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
    public native void addCalendarEvent(CalendarEvent event, Map customValues) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addCalendarEvent", "CalendarEvent,Map");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addCalendarEvent(event.@com.smartgwt.client.core.DataClass::getJsObj()(), customValues == null ? null : @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(customValues));
    }-*/;
	
	/**
     * Adds a new {@link com.smartgwt.client.widgets.calendar.Calendar#getIndicators indicator} to the calendar.
     * @param indicator a new indicator to add to the calendar
     */
    public native void addIndicator(CalendarEvent indicator) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addIndicator", "CalendarEvent");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addLane", "Lane");
        }
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
     * @deprecated in favor of {@link com.smartgwt.client.widgets.calendar.Calendar#addCalendarEvent addCalendarEvent()}
     */
    public native void addLaneEvent(Lane laneName, Date startDate) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addLaneEvent", "Lane,Date");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addLaneEvent(laneName.@com.smartgwt.client.core.DataClass::getJsObj()(), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(startDate));
    }-*/;

    /**
     * @see Calendar#addLaneEvent
     */
    public void addLaneEvent(Lane laneName, Date startDate, Date endDate){
        addLaneEvent(laneName, startDate, endDate, null, null, null);
    }

    /**
     * @see Calendar#addLaneEvent
     */
    public void addLaneEvent(Lane laneName, Date startDate, Date endDate, String name){
        addLaneEvent(laneName, startDate, endDate, name, null, null);
    }

    /**
     * @see Calendar#addLaneEvent
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
     * @deprecated in favor of {@link com.smartgwt.client.widgets.calendar.Calendar#addCalendarEvent addCalendarEvent()}
     */
    public native void addLaneEvent(Lane laneName, Date startDate, Date endDate, String name, String description, Object otherFields) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addLaneEvent", "Lane,Date,Date,String,String,Object");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addLaneEvent(laneName.@com.smartgwt.client.core.DataClass::getJsObj()(), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(startDate), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(endDate), name, description, otherFields);
    }-*/;
	
	/**
     * Adds a new {@link com.smartgwt.client.widgets.calendar.Calendar#getZones zone} to the calendar.
     * @param zone a new zone to add to the calendar
     */
    public native void addZone(CalendarEvent zone) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addZone", "CalendarEvent");
        }
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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var backgroundClick = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.calendar.events.BackgroundClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.calendar.Calendar::handleTearDownBackgroundClickEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("backgroundClick"));
            obj.addProperties({backgroundClick: 
                function () {
                    var param = {"_this": this, "startDate" : arguments[0], "endDate" : arguments[1]};
                    var ret = backgroundClick(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("backgroundClick", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("backgroundClick"));
            obj.backgroundClick = 
                function () {
                    var param = {"_this": this, "startDate" : arguments[0], "endDate" : arguments[1]};
                    var ret = backgroundClick(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("backgroundClick", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownBackgroundClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.calendar.events.BackgroundClickEvent.getType()) == 0) tearDownBackgroundClickEvent();
    }

    private native void tearDownBackgroundClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("backgroundClick")) delete obj.backgroundClick;
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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var backgroundMouseDown = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.calendar.events.BackgroundMouseDownEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.calendar.Calendar::handleTearDownBackgroundMouseDownEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("backgroundMouseDown"));
            obj.addProperties({backgroundMouseDown: 
                function () {
                    var param = {"_this": this, "startDate" : arguments[0]};
                    var ret = backgroundMouseDown(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("backgroundMouseDown", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("backgroundMouseDown"));
            obj.backgroundMouseDown = 
                function () {
                    var param = {"_this": this, "startDate" : arguments[0]};
                    var ret = backgroundMouseDown(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("backgroundMouseDown", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownBackgroundMouseDownEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.calendar.events.BackgroundMouseDownEvent.getType()) == 0) tearDownBackgroundMouseDownEvent();
    }

    private native void tearDownBackgroundMouseDownEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("backgroundMouseDown")) delete obj.backgroundMouseDown;
    }-*/;

    /**
     * Add a backgroundMouseUp handler.
     * <p>
     * Notification method fired when the mouse button is released over a background-cell, ie,  one without an event.  Call
     * {@link com.smartgwt.client.widgets.calendar.events.BackgroundMouseUpEvent#cancel()} from within {@link
     * com.smartgwt.client.widgets.calendar.events.BackgroundMouseUpHandler#onBackgroundMouseUp} to cancel the default behavior
     * of showing a dialog to add a new event with the passed dates.
     *
     * @param handler the backgroundMouseUp handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addBackgroundMouseUpHandler(com.smartgwt.client.widgets.calendar.events.BackgroundMouseUpHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.calendar.events.BackgroundMouseUpEvent.getType()) == 0) setupBackgroundMouseUpEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.calendar.events.BackgroundMouseUpEvent.getType());
    }

    private native void setupBackgroundMouseUpEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var backgroundMouseUp = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.calendar.events.BackgroundMouseUpEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.calendar.Calendar::handleTearDownBackgroundMouseUpEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("backgroundMouseUp"));
            obj.addProperties({backgroundMouseUp: 
                function () {
                    var param = {"_this": this, "startDate" : arguments[0], "endDate" : arguments[1]};
                    var ret = backgroundMouseUp(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("backgroundMouseUp", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("backgroundMouseUp"));
            obj.backgroundMouseUp = 
                function () {
                    var param = {"_this": this, "startDate" : arguments[0], "endDate" : arguments[1]};
                    var ret = backgroundMouseUp(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("backgroundMouseUp", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownBackgroundMouseUpEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.calendar.events.BackgroundMouseUpEvent.getType()) == 0) tearDownBackgroundMouseUpEvent();
    }

    private native void tearDownBackgroundMouseUpEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("backgroundMouseUp")) delete obj.backgroundMouseUp;
    }-*/;

	/**
     * Cancels the current edit-session, closing the builtin event  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventDialog dialog} or {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor editor} and clearing any  visible edit-selection from the
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getSelectedView current CalendarView}.
     */
    public native void cancelEditing() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "cancelEditing", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.cancelEditing();
    }-*/;

	/**
     * Called from {@link com.smartgwt.client.widgets.calendar.EventCanvas#setEvent EventCanvas.setEvent()} when {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowEventCanvasComponents showEventCanvasComponents} is  true and an
     * eventCanvas needs a component.   The method is expected to create and return a  single component to apply as a
     * space-filling member of the passed {@link com.smartgwt.client.widgets.calendar.EventCanvas}  in the {@link
     * com.smartgwt.client.widgets.calendar.EventCanvas#getCalendarView view} in which it appears. <P> By default, this method
     * returns a {@link com.smartgwt.client.widgets.viewer.DetailViewer} showing values from the  associated event, according
     * to the fields in the Calendar's  {@link com.smartgwt.client.widgets.calendar.Calendar#getDataSource dataSource}, or the
     * default event-fields if no dataSource is  present. <P> However, the component can be any {@link
     * com.smartgwt.client.widgets.Canvas canvas-based} widget, including a Layout  containing an arrangement of other widgets.
     * When applied as a member of an  eventCanvas, the component fills its container and limits its own content to that size,
     * showing scrollbars as appropriate. <P> See {@link
     * com.smartgwt.client.widgets.calendar.Calendar#updateEventCanvasComponent updateEventCanvasComponent()} for details on
     * updating components that have already been created and applied.
     * @param canvas the eventCanvas to get the component for
     *
     * @return any Canvas
     * @see com.smartgwt.client.widgets.calendar.Calendar#updateEventCanvasComponent
     */
    public native Canvas createEventCanvasComponent(EventCanvas canvas) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "createEventCanvasComponent", "EventCanvas");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.createEventCanvasComponent(canvas == null ? null : canvas.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        return @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var currentViewChanged = $entry(function(){
            var param = {"_this": this, "viewName" : arguments[0]};
            var event = @com.smartgwt.client.widgets.calendar.events.CurrentViewChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.calendar.Calendar::handleTearDownCurrentViewChangedEvent()();
            if (hasDefaultHandler) this.Super("currentViewChanged", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("currentViewChanged"));
            obj.addProperties({currentViewChanged:  currentViewChanged              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("currentViewChanged"));
            obj.currentViewChanged =  currentViewChanged             ;
        }
    }-*/;

    private void handleTearDownCurrentViewChangedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.calendar.events.CurrentViewChangedEvent.getType()) == 0) tearDownCurrentViewChangedEvent();
    }

    private native void tearDownCurrentViewChangedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("currentViewChanged")) delete obj.currentViewChanged;
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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var dateChanged = $entry(function(){
            var param = {"_this": this};
            var event = @com.smartgwt.client.widgets.calendar.events.DateChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.calendar.Calendar::handleTearDownDateChangedEvent()();
            if (hasDefaultHandler) this.Super("dateChanged", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("dateChanged"));
            obj.addProperties({dateChanged:  dateChanged              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("dateChanged"));
            obj.dateChanged =  dateChanged             ;
        }
    }-*/;

    private void handleTearDownDateChangedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.calendar.events.DateChangedEvent.getType()) == 0) tearDownDateChangedEvent();
    }

    private native void tearDownDateChangedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("dateChanged")) delete obj.dateChanged;
    }-*/;

    /**
     * Add a dayBodyClick handler.
     * <p>
     * Called when the body area of a day in the month view is clicked on, outside of any links to a particular event. <P> By
     * default, if the user can add events, shows a dialog for adding a new event for that day.  Call {@link
     * com.smartgwt.client.widgets.calendar.events.DayBodyClickEvent#cancel()} from within {@link
     * com.smartgwt.client.widgets.calendar.events.DayBodyClickHandler#onDayBodyClick} to cancel this action. <P> Not called if
     * the day falls outside the current month and {@link com.smartgwt.client.widgets.calendar.Calendar#getShowOtherDays
     * Calendar.showOtherDays} is false.
     *
     * @param handler the dayBodyClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDayBodyClickHandler(com.smartgwt.client.widgets.calendar.events.DayBodyClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.calendar.events.DayBodyClickEvent.getType()) == 0) setupDayBodyClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.calendar.events.DayBodyClickEvent.getType());
    }

    private native void setupDayBodyClickEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var dayBodyClick = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.calendar.events.DayBodyClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.calendar.Calendar::handleTearDownDayBodyClickEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("dayBodyClick"));
            obj.addProperties({dayBodyClick: 
                function () {
                    var param = {"_this": this, "date" : arguments[0], "events" : arguments[1], "calendar" : arguments[2], "rowNum" : arguments[3], "colNum" : arguments[4]};
                    var ret = dayBodyClick(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("dayBodyClick", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("dayBodyClick"));
            obj.dayBodyClick = 
                function () {
                    var param = {"_this": this, "date" : arguments[0], "events" : arguments[1], "calendar" : arguments[2], "rowNum" : arguments[3], "colNum" : arguments[4]};
                    var ret = dayBodyClick(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("dayBodyClick", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownDayBodyClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.calendar.events.DayBodyClickEvent.getType()) == 0) tearDownDayBodyClickEvent();
    }

    private native void tearDownDayBodyClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("dayBodyClick")) delete obj.dayBodyClick;
    }-*/;

    /**
     * Add a dayHeaderClick handler.
     * <p>
     * Called when the header area of a day in the month view is clicked on. <P> By default, moves to the day tab and shows the
     * clicked days events. Call {@link com.smartgwt.client.widgets.calendar.events.DayHeaderClickEvent#cancel()} from within
     * {@link com.smartgwt.client.widgets.calendar.events.DayHeaderClickHandler#onDayHeaderClick} to cancel this action. <P>
     * Not called if the day falls outside the current month and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowOtherDays Calendar.showOtherDays} is false.
     *
     * @param handler the dayHeaderClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDayHeaderClickHandler(com.smartgwt.client.widgets.calendar.events.DayHeaderClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.calendar.events.DayHeaderClickEvent.getType()) == 0) setupDayHeaderClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.calendar.events.DayHeaderClickEvent.getType());
    }

    private native void setupDayHeaderClickEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var dayHeaderClick = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.calendar.events.DayHeaderClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.calendar.Calendar::handleTearDownDayHeaderClickEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("dayHeaderClick"));
            obj.addProperties({dayHeaderClick: 
                function () {
                    var param = {"_this": this, "date" : arguments[0], "events" : arguments[1], "calendar" : arguments[2], "rowNum" : arguments[3], "colNum" : arguments[4]};
                    var ret = dayHeaderClick(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("dayHeaderClick", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("dayHeaderClick"));
            obj.dayHeaderClick = 
                function () {
                    var param = {"_this": this, "date" : arguments[0], "events" : arguments[1], "calendar" : arguments[2], "rowNum" : arguments[3], "colNum" : arguments[4]};
                    var ret = dayHeaderClick(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("dayHeaderClick", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownDayHeaderClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.calendar.events.DayHeaderClickEvent.getType()) == 0) tearDownDayHeaderClickEvent();
    }

    private native void tearDownDayHeaderClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("dayHeaderClick")) delete obj.dayHeaderClick;
    }-*/;

	/**
     * Removes an event from the list of selected events in the current view, clearing its selected  style.
     * @param event the event to deselect
     *
     * @return true if the selection was changed, false otherwise
     */
    public native Boolean deselectEvent(CalendarEvent event) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "deselectEvent", "CalendarEvent");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.deselectEvent(event.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Removes one or more events from the list of selected events in the current view, clearing their selected styles.
     * @param events the events to deselect
     *
     * @return true if the selection was changed, false otherwise
     */
    public native Boolean deselectEvents(CalendarEvent... events) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "deselectEvents", "CalendarEvent...");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.deselectEvents(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(events));
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var eventAdded = $entry(function(){
            var param = {"_this": this, "event" : arguments[0]};
            var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventAdded::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.calendar.Calendar::handleTearDownEventAddedEvent()();
            if (hasDefaultHandler) this.Super("eventAdded", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("eventAdded"));
            obj.addProperties({eventAdded:  eventAdded              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("eventAdded"));
            obj.eventAdded =  eventAdded             ;
        }
    }-*/;

    private void handleTearDownEventAddedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.calendar.events.CalendarEventAdded.getType()) == 0) tearDownEventAddedEvent();
    }

    private native void tearDownEventAddedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("eventAdded")) delete obj.eventAdded;
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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var eventChanged = $entry(function(){
            var param = {"_this": this, "event" : arguments[0]};
            var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.calendar.Calendar::handleTearDownEventChangedEvent()();
            if (hasDefaultHandler) this.Super("eventChanged", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("eventChanged"));
            obj.addProperties({eventChanged:  eventChanged              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("eventChanged"));
            obj.eventChanged =  eventChanged             ;
        }
    }-*/;

    private void handleTearDownEventChangedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.calendar.events.CalendarEventChangedEvent.getType()) == 0) tearDownEventChangedEvent();
    }

    private native void tearDownEventChangedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("eventChanged")) delete obj.eventChanged;
    }-*/;

    /**
     * Add a eventClick handler.
     * <p>
     * Called whenever an event is clicked on in the day, week or month views. <P> By default, a dialog appears showing details
     * for the event, and offering the ability to edit events that can be edited.  Call {@link
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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var eventClick = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventClick::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.calendar.Calendar::handleTearDownEventClickEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("eventClick"));
            obj.addProperties({eventClick: 
                function () {
                    var param = {"_this": this, "event" : arguments[0], "viewName" : arguments[1]};
                    var ret = eventClick(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("eventClick", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("eventClick"));
            obj.eventClick = 
                function () {
                    var param = {"_this": this, "event" : arguments[0], "viewName" : arguments[1]};
                    var ret = eventClick(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("eventClick", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownEventClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.calendar.events.CalendarEventClick.getType()) == 0) tearDownEventClickEvent();
    }

    private native void tearDownEventClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("eventClick")) delete obj.eventClick;
    }-*/;

	/**
     * Called when an event is moved via dragging by a user.  Return false to disallow the move.
     * @param newDate new start date and time that the event is being moved to
     * @param event the event as it will be after this movement
     * @param newLane the name of the lane into which the event was moved
     *
     * @return return false to disallow the move.
     * @deprecated in favor of {@link com.smartgwt.client.widgets.calendar.Calendar#addEventRepositionStopHandler
     * Calendar.eventRepositionStop()}
     */
    public native boolean eventMoved(Date newDate, CalendarEvent event, String newLane) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "eventMoved", "Date,CalendarEvent,String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.eventMoved(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(newDate), event.@com.smartgwt.client.core.DataClass::getJsObj()(), newLane);
        return ret == null ? false : ret;
    }-*/;

    /**
     * Add a eventRemoveClick handler.
     * <p>
     * Called whenever the close icon of an {@link com.smartgwt.client.widgets.calendar.EventCanvas event canvas} is clicked in
     * the  {@link com.smartgwt.client.widgets.calendar.Calendar#getDayView day}, {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWeekView week} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timeline} views, or when the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getRemoveButton remove button} is pressed in the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventEditor event editor}. <P> Implement this method to intercept the
     * automatic removal of data.  You can Call {@link
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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var eventRemoveClick = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventRemoveClick::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.calendar.Calendar::handleTearDownEventRemoveClickEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("eventRemoveClick"));
            obj.addProperties({eventRemoveClick: 
                function () {
                    var param = {"_this": this, "event" : arguments[0], "viewName" : arguments[1]};
                    var ret = eventRemoveClick(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("eventRemoveClick", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("eventRemoveClick"));
            obj.eventRemoveClick = 
                function () {
                    var param = {"_this": this, "event" : arguments[0], "viewName" : arguments[1]};
                    var ret = eventRemoveClick(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("eventRemoveClick", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownEventRemoveClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.calendar.events.CalendarEventRemoveClick.getType()) == 0) tearDownEventRemoveClickEvent();
    }

    private native void tearDownEventRemoveClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("eventRemoveClick")) delete obj.eventRemoveClick;
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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var eventRemoved = $entry(function(){
            var param = {"_this": this, "event" : arguments[0]};
            var event = @com.smartgwt.client.widgets.calendar.events.CalendarEventRemoved::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.calendar.Calendar::handleTearDownEventRemovedEvent()();
            if (hasDefaultHandler) this.Super("eventRemoved", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("eventRemoved"));
            obj.addProperties({eventRemoved:  eventRemoved              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("eventRemoved"));
            obj.eventRemoved =  eventRemoved             ;
        }
    }-*/;

    private void handleTearDownEventRemovedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.calendar.events.CalendarEventRemoved.getType()) == 0) tearDownEventRemovedEvent();
    }

    private native void tearDownEventRemovedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("eventRemoved")) delete obj.eventRemoved;
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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var eventRepositionMove = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.calendar.events.EventRepositionMove::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.calendar.Calendar::handleTearDownEventRepositionMoveEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("eventRepositionMove"));
            obj.addProperties({eventRepositionMove: 
                function () {
                    var param = {"_this": this, "event" : arguments[0], "newEvent" : arguments[1]};
                    var ret = eventRepositionMove(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("eventRepositionMove", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("eventRepositionMove"));
            obj.eventRepositionMove = 
                function () {
                    var param = {"_this": this, "event" : arguments[0], "newEvent" : arguments[1]};
                    var ret = eventRepositionMove(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("eventRepositionMove", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownEventRepositionMoveEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.calendar.events.EventRepositionMove.getType()) == 0) tearDownEventRepositionMoveEvent();
    }

    private native void tearDownEventRepositionMoveEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("eventRepositionMove")) delete obj.eventRepositionMove;
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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var eventRepositionStop = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.calendar.events.EventRepositionStop::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.calendar.Calendar::handleTearDownEventRepositionStopEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("eventRepositionStop"));
            obj.addProperties({eventRepositionStop: 
                function () {
                    var param = {"_this": this, "event" : arguments[0], "newEvent" : arguments[1], "customValues" : arguments[2]};
                    var ret = eventRepositionStop(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("eventRepositionStop", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("eventRepositionStop"));
            obj.eventRepositionStop = 
                function () {
                    var param = {"_this": this, "event" : arguments[0], "newEvent" : arguments[1], "customValues" : arguments[2]};
                    var ret = eventRepositionStop(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("eventRepositionStop", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownEventRepositionStopEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.calendar.events.EventRepositionStop.getType()) == 0) tearDownEventRepositionStopEvent();
    }

    private native void tearDownEventRepositionStopEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("eventRepositionStop")) delete obj.eventRepositionStop;
    }-*/;

	/**
     * Called when an event is resized with the mouse.  The passed date value is the new *end* date for the event, since
     * resizing can only be performed on the bottom edge of an event in normal calendar views.
     * @param newDate new end date and time that event is being resized to
     * @param event the event as it will be after this resize
     *
     * @return return false to disallow the resize
     * @deprecated in favor of {@link com.smartgwt.client.widgets.calendar.Calendar#addEventResizeStopHandler Calendar.eventResizeStop()}
     */
    public native boolean eventResized(Date newDate, CalendarEvent event) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "eventResized", "Date,CalendarEvent");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.eventResized(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(newDate), event.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret == null ? false : ret;
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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var eventResizeMove = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.calendar.events.EventResizeMove::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.calendar.Calendar::handleTearDownEventResizeMoveEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("eventResizeMove"));
            obj.addProperties({eventResizeMove: 
                function () {
                    var param = {"_this": this, "event" : arguments[0], "newEvent" : arguments[1]};
                    var ret = eventResizeMove(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("eventResizeMove", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("eventResizeMove"));
            obj.eventResizeMove = 
                function () {
                    var param = {"_this": this, "event" : arguments[0], "newEvent" : arguments[1]};
                    var ret = eventResizeMove(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("eventResizeMove", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownEventResizeMoveEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.calendar.events.EventResizeMove.getType()) == 0) tearDownEventResizeMoveEvent();
    }

    private native void tearDownEventResizeMoveEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("eventResizeMove")) delete obj.eventResizeMove;
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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var eventResizeStop = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.calendar.events.EventResizeStop::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.calendar.Calendar::handleTearDownEventResizeStopEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("eventResizeStop"));
            obj.addProperties({eventResizeStop: 
                function () {
                    var param = {"_this": this, "event" : arguments[0], "newEvent" : arguments[1], "customValues" : arguments[2]};
                    var ret = eventResizeStop(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("eventResizeStop", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("eventResizeStop"));
            obj.eventResizeStop = 
                function () {
                    var param = {"_this": this, "event" : arguments[0], "newEvent" : arguments[1], "customValues" : arguments[2]};
                    var ret = eventResizeStop(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("eventResizeStop", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownEventResizeStopEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.calendar.events.EventResizeStop.getType()) == 0) tearDownEventResizeStopEvent();
    }

    private native void tearDownEventResizeStopEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("eventResizeStop")) delete obj.eventResizeStop;
    }-*/;

	/**
     * A notification method fired when the events in the current view have been refreshed.
     */
    public native void eventsRendered() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "eventsRendered", "");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getActiveDay", "");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getActiveTime", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getActiveTime();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;

	/**
     * Return the Date instance associated with the passed co-ordinates in the passed or selected view.  If the cell at the
     * passed co-ordinates is not a date-cell, returns null.  If rowNum  and colNum are both unset, returns the date from the
     * cell under the mouse. <P> To determine the date at a more specific point within a cell, see {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDateFromPoint getDateFromPoint()}.
     *
     * @return the date, if any, associated with the passed co-ords in the appropriate view
     */
    public native Date getCellDate() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getCellDate", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getCellDate();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;

    /**
     * @see Calendar#getCellDate
     */
    public Date getCellDate(Integer rowNum){
        return getCellDate(rowNum, (Integer) null, null);
    }

    /**
     * @see Calendar#getCellDate
     */
    public Date getCellDate(Integer rowNum, Integer colNum){
        return getCellDate(rowNum, colNum, null);
    }

	/**
     * Return the Date instance associated with the passed co-ordinates in the passed or selected view.  If the cell at the
     * passed co-ordinates is not a date-cell, returns null.  If rowNum  and colNum are both unset, returns the date from the
     * cell under the mouse. <P> To determine the date at a more specific point within a cell, see {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDateFromPoint getDateFromPoint()}.
     * @param rowNum the row number to get the date for
     * @param colNum the column number to get the date for
     * @param view the view to use - uses the selected view if not passed
     *
     * @return the date, if any, associated with the passed co-ords in the appropriate view
     */
    public native Date getCellDate(Integer rowNum, Integer colNum, CalendarView view) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getCellDate", "Integer,Integer,CalendarView");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getCellDate(rowNum == null ? null : rowNum.@java.lang.Integer::intValue()(), colNum == null ? null : colNum.@java.lang.Integer::intValue()(), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;
	
	/**
     * Returns the hover HTML for the cell at the passed co-ordinates in the passed view.  By  default, the hover text is  the
     * snap date closest to the mouse, if the cell being hovered is  a normal date cell - otherwise, it is the title of the
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getLaneFields laneField} being hovered over. <P> Override here to
     * return custom HTML for the passed cell.
     * @param view the CalendarView the mouse is hovered over
     * @param record The record containing the cell being hovered
     * @param rowNum The rowNum of the cell being hovered
     * @param colNum the colNum of the cell being hovered
     * @param date the snap-date at the mouse, which may be different from the result of a                     call to {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getCellDate getCellDate}
     * @param defaultValue the default hover text for the passed values
     *
     * @return the HTML to show in the hover.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     */
    public native String getCellHoverHTML(CalendarView view, Record record, Integer rowNum, Integer colNum, Date date, String defaultValue) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getCellHoverHTML", "CalendarView,Record,Integer,Integer,Date,String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getCellHoverHTML(view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), record.@com.smartgwt.client.core.DataClass::getJsObj()(), rowNum == null ? null : rowNum.@java.lang.Integer::intValue()(), colNum == null ? null : colNum.@java.lang.Integer::intValue()(), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date), defaultValue);
        return ret;
    }-*/;

	/**
     * When {@link com.smartgwt.client.widgets.calendar.Calendar#getDateHTML getDateHTML} returns a value, this method returns
     * the horizontal alignment for that value in its cell, in the passed view.
     * @param date the date to get the cell-alignment for
     * @param rowNum the row number containing the date to get the cell-alignment for
     * @param colNum the column number containing the date to get the cell-alignment for
     * @param view the relevant CalendarView
     *
     * @return cell-alignment for content in the cell with the passed date and rowNum/colNum.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     * @see com.smartgwt.client.widgets.calendar.Calendar#getDateHTML
     * @see com.smartgwt.client.widgets.calendar.Calendar#getDateCellVAlign
     * @see com.smartgwt.client.widgets.calendar.Calendar#getDateStyle
     * @see com.smartgwt.client.widgets.calendar.Calendar#getDateCSSText
     */
    public native String getDateCellAlign(Date date, Integer rowNum, Integer colNum, CalendarView view) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getDateCellAlign", "Date,Integer,Integer,CalendarView");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDateCellAlign(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date), rowNum == null ? null : rowNum.@java.lang.Integer::intValue()(), colNum == null ? null : colNum.@java.lang.Integer::intValue()(), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        return ret;
    }-*/;

	/**
     * When {@link com.smartgwt.client.widgets.calendar.Calendar#getDateHTML getDateHTML} returns a value, this method returns
     * the vertical alignment for that value in its cell, in the passed view.
     * @param date the date to get the cell-alignment for
     * @param rowNum the row number containing the date to get the cell-alignment for
     * @param colNum the column number containing the date to get the cell-alignment for
     * @param view the relevant CalendarView
     *
     * @return vertical-alignment for content in the cell with the passed date and rowNum/colNum.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     * @see com.smartgwt.client.widgets.calendar.Calendar#getDateHTML
     * @see com.smartgwt.client.widgets.calendar.Calendar#getDateCellAlign
     * @see com.smartgwt.client.widgets.calendar.Calendar#getDateStyle
     * @see com.smartgwt.client.widgets.calendar.Calendar#getDateCSSText
     */
    public native String getDateCellVAlign(Date date, Integer rowNum, Integer colNum, CalendarView view) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getDateCellVAlign", "Date,Integer,Integer,CalendarView");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDateCellVAlign(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date), rowNum == null ? null : rowNum.@java.lang.Integer::intValue()(), colNum == null ? null : colNum.@java.lang.Integer::intValue()(), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        return ret;
    }-*/;

	/**
     * Return CSS text for styling the cell associated with the passed date and/or rowNum & colNum, which will be applied in
     * addition to the CSS class for the cell, as overrides. <p> "CSS text" means semicolon-separated style settings, suitable
     * for inclusion in a CSS stylesheet or in a STYLE attribute of an HTML element.
     * @param date the date to return CSS text for
     * @param rowNum the row number containing the date to get the CSS for
     * @param colNum the column number containing the date to get the CSS for
     * @param view the relevant CalendarView
     *
     * @return CSS text for the cell with the passed date and rowNum/colNum
     * @see com.smartgwt.client.widgets.calendar.Calendar#getDateHTML
     * @see com.smartgwt.client.widgets.calendar.Calendar#getDateStyle
     */
    public native String getDateCSSText(Date date, Integer rowNum, Integer colNum, CalendarView view) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getDateCSSText", "Date,Integer,Integer,CalendarView");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDateCSSText(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date), rowNum == null ? null : rowNum.@java.lang.Integer::intValue()(), colNum == null ? null : colNum.@java.lang.Integer::intValue()(), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
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
     * functionally equivalent to  {@link com.smartgwt.client.widgets.calendar.Calendar#getCellDate getCellDate()}, which
     * determines the date associated with a cell, without the additional  offset precision offered here.
     *
     * @return the date, if any, associated with the passed co-ords in the current view
     */
    public native Date getDateFromPoint() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getDateFromPoint", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDateFromPoint();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;

    /**
     * @see Calendar#getDateFromPoint
     */
    public Date getDateFromPoint(Integer x){
        return getDateFromPoint(x, (Integer) null, null, null);
    }

    /**
     * @see Calendar#getDateFromPoint
     */
    public Date getDateFromPoint(Integer x, Integer y){
        return getDateFromPoint(x, y, null, null);
    }

    /**
     * @see Calendar#getDateFromPoint
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
     * functionally equivalent to  {@link com.smartgwt.client.widgets.calendar.Calendar#getCellDate getCellDate()}, which
     * determines the date associated with a cell, without the additional  offset precision offered here.
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getDateFromPoint", "Integer,Integer,Boolean,CalendarView");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDateFromPoint(x == null ? null : x.@java.lang.Integer::intValue()(), y == null ? null : y.@java.lang.Integer::intValue()(), snapOffsets == null ? null : snapOffsets.@java.lang.Boolean::booleanValue()(), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;
	
	/**
     * Return the title text to display in the header-button of the ListGridField showing the  passed date, in the passed view.
     * @param date the date to return the header-title for - note that the                     {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getMonthView month view} does not pass this parameter                   
     * because a single column represents multiple dates
     * @param dayOfWeek the week-day number of the passed date, except for the                           {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getMonthView month view}, where no date is passed,                        
     *  because the week-day number represents multiple dates.
     * @param defaultValue the default header-title for the passed date and view
     * @param view the relevant CalendarView
     *
     * @return the text to show in the header-button for the passed date/field
     */
    public native String getDateHeaderTitle(Date date, int dayOfWeek, String defaultValue, CalendarView view) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getDateHeaderTitle", "Date,int,String,CalendarView");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDateHeaderTitle(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date), dayOfWeek, defaultValue, view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        return ret;
    }-*/;

	/**
     * Return the HTML to be displayed in the associated date-cell in the passed view. Note that the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getMonthView month view} has default cell HTML, controlled via {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getDayBodyHTML getDayBodyHTML()}.
     * @param date the date to get the HTML for
     * @param rowNum the row number containing the date to get the HTML for
     * @param colNum the column number containing the date to get the HTML for
     * @param view the relevant CalendarView
     *
     * @return HTML to display in the cell with the passed date and rowNum/colNum.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     * @see com.smartgwt.client.widgets.calendar.Calendar#getDateCellAlign
     * @see com.smartgwt.client.widgets.calendar.Calendar#getDateCellVAlign
     * @see com.smartgwt.client.widgets.calendar.Calendar#getDateStyle
     * @see com.smartgwt.client.widgets.calendar.Calendar#getDateCSSText
     * @see com.smartgwt.client.widgets.calendar.Calendar#getDayBodyHTML
     */
    public native String getDateHTML(Date date, Integer rowNum, Integer colNum, CalendarView view) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getDateHTML", "Date,Integer,Integer,CalendarView");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDateHTML(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date), rowNum == null ? null : rowNum.@java.lang.Integer::intValue()(), colNum == null ? null : colNum.@java.lang.Integer::intValue()(), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        return ret;
    }-*/;

	/**
     * Return the CSS styleName for the associated date-cell in the passed view.
     * @param date the date to return the CSS styleName for
     * @param rowNum the row number containing the date to get the CSS styleName for
     * @param colNum the column number containing the date to get the CSS styleName for
     * @param view the relevant CalendarView
     *
     * @return CSS style for the cell with the passed date and rowNum/colNum.
     * See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName}
     * @see com.smartgwt.client.widgets.calendar.Calendar#getDateHTML
     * @see com.smartgwt.client.widgets.calendar.Calendar#getDateCSSText
     */
    public native String getDateStyle(Date date, Integer rowNum, Integer colNum, CalendarView view) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getDateStyle", "Date,Integer,Integer,CalendarView");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDateStyle(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date), rowNum == null ? null : rowNum.@java.lang.Integer::intValue()(), colNum == null ? null : colNum.@java.lang.Integer::intValue()(), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        return ret;
    }-*/;

	/**
     * Returns the HTML to show in a hover when an existing event is dragged, or when a new event is being created by dragging
     * with the mouse.
     * @param view the CalendarView the mouse is hovered over
     * @param event the CalendarEvent attached to the EventCanvas being dragged
     * @param defaultValue the default text for the passed values
     *
     * @return the HTML to show in the hover.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     */
    public native String getDragHoverHTML(CalendarView view, CalendarEvent event, String defaultValue) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getDragHoverHTML", "CalendarView,CalendarEvent,String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDragHoverHTML(view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), event.@com.smartgwt.client.core.DataClass::getJsObj()(), defaultValue);
        return ret;
    }-*/;

	/**
     * Returns the description text for the passed event, for display in the body area of an event  canvas.  The default
     * implementation returns the event's {@link com.smartgwt.client.widgets.calendar.Calendar#getDescriptionField description
     * field}.
     * @param event the event to get the description text for
     *
     * @return the HTML to display in the body of the passed event's EventCanvas.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     */
    public native String getEventBodyHTML(CalendarEvent event) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getEventBodyHTML", "CalendarEvent");
        }
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
     * @return the HTML to display in the body of the passed event's EventCanvas.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     */
    public native String getEventBodyHTML(CalendarEvent event, CalendarView view) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getEventBodyHTML", "CalendarEvent,CalendarView");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getEventCanvasMenuItems", "EventCanvas");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEventCanvasMenuItems(canvas == null ? null : canvas.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfMenuItem(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns the {@link com.smartgwt.client.docs.CSSStyleName styleName} to use for the passed  {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent event}, in the passed {@link
     * com.smartgwt.client.widgets.calendar.CalendarView view}.  By default, returns the style {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventStyleNameField on the event}, if one is specified - otherwise,  in
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes lane-based} views, it returns the style specified on the 
     * {@link com.smartgwt.client.widgets.calendar.Lane#getEventStyleName lane or sublane}, or the style specified on the 
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getEventStyleName calendar}.
     * @param event the event to get the CSS style for
     *
     * @return the CSS style to apply to the passed event in the passed view.
     * See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName}
     */
    public native String getEventCanvasStyle(CalendarEvent event) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getEventCanvasStyle", "CalendarEvent");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEventCanvasStyle(event.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;

	/**
     * Returns the {@link com.smartgwt.client.docs.CSSStyleName styleName} to use for the passed  {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent event}, in the passed {@link
     * com.smartgwt.client.widgets.calendar.CalendarView view}.  By default, returns the style {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventStyleNameField on the event}, if one is specified - otherwise,  in
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getLanes lane-based} views, it returns the style specified on the 
     * {@link com.smartgwt.client.widgets.calendar.Lane#getEventStyleName lane or sublane}, or the style specified on the 
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getEventStyleName calendar}.
     * @param event the event to get the CSS style for
     * @param view the CalendarView that contains the canvas being styled
     *
     * @return the CSS style to apply to the passed event in the passed view.
     * See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName}
     */
    public native String getEventCanvasStyle(CalendarEvent event, CalendarView view) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getEventCanvasStyle", "CalendarEvent,CalendarView");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getEventEndDate", "CalendarEvent");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEventEndDate(event.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;

	/**
     * Returns the title text for the passed event, which is displayed in the header area of an  eventCanvas rendered in a
     * vertical or horizontal view, or as a clickable link in a cell in a  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowMonthView Month view}. <P> The default implementation returns the
     * event's {@link com.smartgwt.client.widgets.calendar.Calendar#getNameField name field} for timelines, and that same value
     * pre-pended with the event's {@link com.smartgwt.client.widgets.calendar.Calendar#getStartDateField start} for day, week
     * and month views.
     * @param event the event to get the description text for
     *
     * @return the HTML to display in the header of an event canvas.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     */
    public native String getEventHeaderHTML(CalendarEvent event) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getEventHeaderHTML", "CalendarEvent");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEventHeaderHTML(event.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;

	/**
     * Returns the title text for the passed event, which is displayed in the header area of an  eventCanvas rendered in a
     * vertical or horizontal view, or as a clickable link in a cell in a  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowMonthView Month view}. <P> The default implementation returns the
     * event's {@link com.smartgwt.client.widgets.calendar.Calendar#getNameField name field} for timelines, and that same value
     * pre-pended with the event's {@link com.smartgwt.client.widgets.calendar.Calendar#getStartDateField start} for day, week
     * and month views.
     * @param event the event to get the description text for
     * @param view the view in which the event is being rendered
     *
     * @return the HTML to display in the header of an event canvas.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     */
    public native String getEventHeaderHTML(CalendarEvent event, CalendarView view) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getEventHeaderHTML", "CalendarEvent,CalendarView");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEventHeaderHTML(event.@com.smartgwt.client.core.DataClass::getJsObj()(), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        return ret;
    }-*/;
	
	/**
     * Gets the hover HTML for an event being hovered over. Override here to return custom  HTML based upon the parameter event
     * object.
     * @param event The event being hovered
     * @param eventCanvas the event canvas being hovered over
     * @param view the CalendarView in which the eventCanvas lives
     *
     * @return the HTML to show in the hover.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     */
    public native String getEventHoverHTML(CalendarEvent event, EventCanvas eventCanvas, CalendarView view) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getEventHoverHTML", "CalendarEvent,EventCanvas,CalendarView");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEventHoverHTML(event.@com.smartgwt.client.core.DataClass::getJsObj()(), eventCanvas == null ? null : eventCanvas.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        return ret;
    }-*/;

	/**
     * Gets the hover HTML for an event being hovered over. Override here to return custom  HTML based upon the parameter event
     * object.
     * @param event The event being hovered
     * @param eventCanvas the event canvas being hovered over
     * @param view the CalendarView in which the eventCanvas lives
     * @param defaultValue the default HTML to show when hovering over the passed event
     *
     * @return the HTML to show in the hover.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     */
    public native String getEventHoverHTML(CalendarEvent event, EventCanvas eventCanvas, CalendarView view, String defaultValue) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getEventHoverHTML", "CalendarEvent,EventCanvas,CalendarView,String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEventHoverHTML(event.@com.smartgwt.client.core.DataClass::getJsObj()(), eventCanvas == null ? null : eventCanvas.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), defaultValue);
        return ret;
    }-*/;
	
	/**
     * Returns the {@link com.smartgwt.client.widgets.calendar.Lane lane} associated with the passed event, in the passed view
     * @param event the event to get the lane for
     *
     * @return the lane associated with the passed event
     */
    public native Lane getEventLane(CalendarEvent event) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getEventLane", "CalendarEvent");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getEventLane", "CalendarEvent,CalendarView");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getEventLength", "CalendarEvent");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getEventLength", "CalendarEvent,TimeUnit");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getEventStartDate", "CalendarEvent");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getEventSublane", "CalendarEvent");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getEventSublane", "CalendarEvent,CalendarView");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEventSublane(event.@com.smartgwt.client.core.DataClass::getJsObj()(), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.calendar.Lane::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	
	/**
     * Returns the hover HTML to show in a hover when the mouse moves over the header area.
     * @param view the CalendarView the mouse is hovered over
     * @param headerLevel the header level hovered over
     * @param startDate the start date of the span being hovered over
     * @param endDate the end date of the span being hovered over
     * @param defaultValue the default text for the passed header level and date range
     *
     * @return the HTML to show in the hover.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     */
    public native String getHeaderHoverHTML(CalendarView view, HeaderLevel headerLevel, Date startDate, Date endDate, String defaultValue) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getHeaderHoverHTML", "CalendarView,HeaderLevel,Date,Date,String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getHeaderHoverHTML(view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), headerLevel.@com.smartgwt.client.core.DataClass::getJsObj()(), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(startDate), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(endDate), defaultValue);
        return ret;
    }-*/;

	/**
     * Returns the {@link com.smartgwt.client.docs.CSSStyleName styleName} to use for the passed  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getIndicators indicator}, in the passed {@link
     * com.smartgwt.client.widgets.calendar.CalendarView view}.  By default,  returns the style {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventStyleNameField on the indicator}, if one is specified, or the
     * style specified on the {@link com.smartgwt.client.widgets.calendar.Calendar#getIndicatorStyleName calendar} otherwise.
     * @param indicator the indicator to get the CSS style for
     *
     * @return 
     * See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName}
     */
    public native String getIndicatorCanvasStyle(CalendarEvent indicator) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getIndicatorCanvasStyle", "CalendarEvent");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getIndicatorCanvasStyle(indicator.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;

	/**
     * Returns the {@link com.smartgwt.client.docs.CSSStyleName styleName} to use for the passed  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getIndicators indicator}, in the passed {@link
     * com.smartgwt.client.widgets.calendar.CalendarView view}.  By default,  returns the style {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventStyleNameField on the indicator}, if one is specified, or the
     * style specified on the {@link com.smartgwt.client.widgets.calendar.Calendar#getIndicatorStyleName calendar} otherwise.
     * @param indicator the indicator to get the CSS style for
     * @param view the CalendarView that contains the canvas being styled
     *
     * @return 
     * See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName}
     */
    public native String getIndicatorCanvasStyle(CalendarEvent indicator, CalendarView view) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getIndicatorCanvasStyle", "CalendarEvent,CalendarView");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getIndicatorCanvasStyle(indicator.@com.smartgwt.client.core.DataClass::getJsObj()(), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        return ret;
    }-*/;
	
	/**
     * Gets the hover HTML for an {@link com.smartgwt.client.widgets.calendar.Calendar#getIndicators indicator} being hovered
     * over.  Override here to return custom HTML based upon the parameter indicator object.
     * @param indicator The indicator being hovered over
     * @param indicatorCanvas the indicator canvas being hovered over
     * @param view the CalendarView in which the indicatorCanvas is displayed
     * @param defaultValue the default HTML to show when hovering over the passed Indicator
     *
     * @return the HTML to show in the hover.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     */
    public native String getIndicatorHoverHTML(CalendarEvent indicator, IndicatorCanvas indicatorCanvas, CalendarView view, String defaultValue) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getIndicatorHoverHTML", "CalendarEvent,IndicatorCanvas,CalendarView,String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getIndicatorHoverHTML(indicator.@com.smartgwt.client.core.DataClass::getJsObj()(), indicatorCanvas == null ? null : indicatorCanvas.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), defaultValue);
        return ret;
    }-*/;

	/**
     * Returns the {@link com.smartgwt.client.widgets.calendar.Lane lane} with the passed name, in the passed view
     * @param lane the name of the lane to return
     *
     * @return the lane with the passed name, or null if not found
     */
    public native Lane getLane(String lane) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getLane", "String");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getLane", "String,CalendarView");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getLaneEvents", "Lane");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getLaneEvents", "String");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getLaneEvents", "Lane,CalendarView");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getLaneEvents(lane.@com.smartgwt.client.core.DataClass::getJsObj()(), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfCalendarEvent(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	
	/**
     * Returns the {@link com.smartgwt.client.widgets.calendar.Lane} at the passed co-ordinates.  To get the lane under the
     * mouse, pass null for both x and y.
     *
     * @return the Lane at the passed co-ords in the passed or selected view
     */
    public native Lane getLaneFromPoint() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getLaneFromPoint", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getLaneFromPoint();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.calendar.Lane::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * @see Calendar#getLaneFromPoint
     */
    public Lane getLaneFromPoint(Integer x){
        return getLaneFromPoint(x, (Integer) null, null);
    }

    /**
     * @see Calendar#getLaneFromPoint
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
     * @return the Lane at the passed co-ords in the passed or selected view
     */
    public native Lane getLaneFromPoint(Integer x, Integer y, CalendarView view) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getLaneFromPoint", "Integer,Integer,CalendarView");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getLanePadding", "");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getLanePadding", "CalendarView");
        }
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
     * @return HTML string to display.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     */
    public native String getMonthViewHoverHTML(Date date, CalendarEvent... events) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getMonthViewHoverHTML", "Date,CalendarEvent...");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getMonthViewHoverHTML(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(events));
        return ret;
    }-*/;

	/**
     * Returns the end of the period selected in the passed, or current, calendar view.   For the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getMonthView month view}, and for the  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWeekView week view} when not showing weekends, this will often be a 
     * different date than that returned by {@link com.smartgwt.client.widgets.calendar.Calendar#getVisibleEndDate
     * getVisibleEndDate()}.
     *
     * @return period end date
     */
    public native Date getPeriodEndDate() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getPeriodEndDate", "");
        }
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
     * getVisibleEndDate()}.
     * @param view the view to get the periodEndDate for, or current view if null
     *
     * @return period end date
     */
    public native Date getPeriodEndDate(CalendarView view) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getPeriodEndDate", "CalendarView");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getPeriodEndDate(view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;
	
	/**
     * Returns the start of the selected week or month depending on the current calendar view.   For the month view, and for
     * the week view when not showing weekends, this will often be a  different date than that returned by {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getVisibleStartDate getVisibleStartDate()}.
     *
     * @return period start date
     */
    public native Date getPeriodStartDate() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getPeriodStartDate", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getPeriodStartDate();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;

	/**
     * Returns the start of the selected week or month depending on the current calendar view.   For the month view, and for
     * the week view when not showing weekends, this will often be a  different date than that returned by {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getVisibleStartDate getVisibleStartDate()}.
     * @param view the view to get the periodStartDate for, or current view if null
     *
     * @return period start date
     */
    public native Date getPeriodStartDate(CalendarView view) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getPeriodStartDate", "CalendarView");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getPeriodStartDate(view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;
	
	/**
     * Returns the currently selected {@link com.smartgwt.client.widgets.calendar.CalendarEvent event}, or the first one if
     * more  than one is selected.
     *
     * @return the selected event
     */
    public native CalendarEvent getSelectedEvent() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSelectedEvent", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSelectedEvent();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.calendar.CalendarEvent::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns the currently selected list of {@link com.smartgwt.client.widgets.calendar.CalendarEvent events}.
     *
     * @return the list of selected events
     */
    public native CalendarEvent[] getSelectedEvents() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSelectedEvents", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSelectedEvents();
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfCalendarEvent(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns the currently selected {@link com.smartgwt.client.widgets.calendar.CalendarView view}.
     *
     * @return the currently selected view
     */
    public native CalendarView getSelectedView() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSelectedView", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSelectedView();
        return @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSublane", "String,String");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSublane", "String,String,CalendarView");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSublaneEvents", "Lane,Lane");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSublaneEvents", "Lane,Lane,CalendarView");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSublaneFromPoint", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSublaneFromPoint();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.calendar.Lane::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * @see Calendar#getSublaneFromPoint
     */
    public Lane getSublaneFromPoint(Integer x){
        return getSublaneFromPoint(x, (Integer) null, null);
    }

    /**
     * @see Calendar#getSublaneFromPoint
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSublaneFromPoint", "Integer,Integer,CalendarView");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getView", "ViewName");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getView(viewName.@com.smartgwt.client.types.ViewName::getValue()());
        return @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns the last visible date in the passed, or currently selected, calendar view.
     *
     * @return last visible date
     */
    public native Date getVisibleEndDate() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getVisibleEndDate", "");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getVisibleEndDate", "CalendarView");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getVisibleStartDate", "");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getVisibleStartDate", "CalendarView");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getVisibleStartDate(view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;
	
	/**
     * Returns the {@link com.smartgwt.client.docs.CSSStyleName styleName} to use for the passed  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getZones zone}, in the passed {@link
     * com.smartgwt.client.widgets.calendar.CalendarView view}.  By default,  returns the style {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventStyleNameField on the zone}, if one is specified, or the style
     * specified on the {@link com.smartgwt.client.widgets.calendar.Calendar#getZoneStyleName calendar} otherwise.
     * @param zone the zone to get the CSS style for
     *
     * @return 
     * See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName}
     */
    public native String getZoneCanvasStyle(CalendarEvent zone) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getZoneCanvasStyle", "CalendarEvent");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getZoneCanvasStyle(zone.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;

	/**
     * Returns the {@link com.smartgwt.client.docs.CSSStyleName styleName} to use for the passed  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getZones zone}, in the passed {@link
     * com.smartgwt.client.widgets.calendar.CalendarView view}.  By default,  returns the style {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventStyleNameField on the zone}, if one is specified, or the style
     * specified on the {@link com.smartgwt.client.widgets.calendar.Calendar#getZoneStyleName calendar} otherwise.
     * @param zone the zone to get the CSS style for
     * @param view the CalendarView that contains the canvas being styled
     *
     * @return 
     * See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName}
     */
    public native String getZoneCanvasStyle(CalendarEvent zone, CalendarView view) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getZoneCanvasStyle", "CalendarEvent,CalendarView");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getZoneCanvasStyle(zone.@com.smartgwt.client.core.DataClass::getJsObj()(), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        return ret;
    }-*/;
	
	/**
     * Gets the hover HTML for a {@link com.smartgwt.client.widgets.calendar.Calendar#getZones zone} being hovered over.
     * Override here to  return custom HTML based upon the parameter zone object.
     * @param zone The zone being hovered over
     * @param zoneCanvas the zone canvas being hovered over
     * @param view the CalendarView in which the zoneCanvas is displayed
     * @param defaultValue the default HTML to show when hovering over the passed Zone
     *
     * @return the HTML to show in the hover.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     */
    public native String getZoneHoverHTML(CalendarEvent zone, ZoneCanvas zoneCanvas, CalendarView view, String defaultValue) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getZoneHoverHTML", "CalendarEvent,ZoneCanvas,CalendarView,String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getZoneHoverHTML(zone.@com.smartgwt.client.core.DataClass::getJsObj()(), zoneCanvas == null ? null : zoneCanvas.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), defaultValue);
        return ret;
    }-*/;

	/**
     * When {@link com.smartgwt.client.widgets.calendar.Calendar#getCanGroupLanes canGroupLanes} is true, this method allows
     * the grouping in {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timeline}s to be altered at
     * runtime.
     * @param groupFieldName one or more field names to group by
     */
    public native void groupLanesBy(String groupFieldName) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "groupLanesBy", "String");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "groupLanesBy", "String...");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.groupLanesBy(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(groupFieldName));
    }-*/;

    /**
     * Add a indicatorClick handler.
     * <p>
     * Called whenever an {@link com.smartgwt.client.widgets.calendar.IndicatorCanvas} is clicked in the  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timelineView}.  There is no default implementation.
     *
     * @param handler the indicatorClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addIndicatorClickHandler(com.smartgwt.client.widgets.calendar.events.IndicatorClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.calendar.events.IndicatorClick.getType()) == 0) setupIndicatorClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.calendar.events.IndicatorClick.getType());
    }

    private native void setupIndicatorClickEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var indicatorClick = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.calendar.events.IndicatorClick::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.calendar.Calendar::handleTearDownIndicatorClickEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("indicatorClick"));
            obj.addProperties({indicatorClick: 
                function () {
                    var param = {"_this": this, "indicatorEvent" : arguments[0], "viewName" : arguments[1]};
                    var ret = indicatorClick(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("indicatorClick", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("indicatorClick"));
            obj.indicatorClick = 
                function () {
                    var param = {"_this": this, "indicatorEvent" : arguments[0], "viewName" : arguments[1]};
                    var ret = indicatorClick(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("indicatorClick", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownIndicatorClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.calendar.events.IndicatorClick.getType()) == 0) tearDownIndicatorClickEvent();
    }

    private native void tearDownIndicatorClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("indicatorClick")) delete obj.indicatorClick;
    }-*/;

	/**
     * Resets the current visible range of a calendar view so that it shows the date on which the passed event occurs.
     * @param event the event to move the calendar view to
     * @deprecated in favor of {@link com.smartgwt.client.widgets.calendar.Calendar#scrollToEvent scrollToEvent()}.
     */
    public native void moveToEvent(CalendarEvent event) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "moveToEvent", "CalendarEvent");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.moveToEvent(event.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * Move to the next day, week, or month, depending on which tab is selected.
     */
    public native void next() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "next", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.next();
    }-*/;

	/**
     * Move to the previous day, week, month, or timeline range depending on which tab is selected.
     */
    public native void previous() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "previous", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.previous();
    }-*/;

	/**
     * Refreshes the passed event in the current view.
     * @param event The event object to refresh in the current view
     */
    public native void refreshEvent(CalendarEvent event) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "refreshEvent", "CalendarEvent");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.refreshEvent(event.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * Removes a {@link com.smartgwt.client.widgets.calendar.Calendar#getIndicators indicator} from the calendar. <P> Accepts
     * either a {@link com.smartgwt.client.widgets.calendar.CalendarEvent indicator object} or a string that represents the 
     * {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getName name} of anindicator.
     * @param indicator either the actual CalendarEvent representing the                   indicator, or the name of the indicator to remove
     */
    public native void removeIndicator(CalendarEvent indicator) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "removeIndicator", "CalendarEvent");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "removeIndicator", "String");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "removeZone", "CalendarEvent");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "removeZone", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeZone(zone);
    }-*/;

	/**
     * Move the viewport of a CalendarView to the end of its scrollable range.
     */
    public native void scrollToEnd() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "scrollToEnd", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.scrollToEnd();
    }-*/;

	/**
     * Move the viewport of a CalendarView to the end of its scrollable range.
     * @param view the view to affect, the current view if not specified
     */
    public native void scrollToEnd(CalendarView view) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "scrollToEnd", "CalendarView");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.scrollToEnd(view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;
	
	/**
     * Scrolls the {@link com.smartgwt.client.widgets.calendar.Calendar#getCurrentViewName current view} so the passed event is
     * visible.  If the event is outside of the view's current date-range, the default behavior is to automatically reload the
     * view with a date-range starting at the event's  {@link com.smartgwt.client.widgets.calendar.Calendar#getStartDateField
     * startDate} and then scroll to the event vertically as  necessary.  Pass false as the <code>canReload</code> param to
     * prevent that default behavior.
     * @param event the event to move the calendar view to
     */
    public native void scrollToEvent(CalendarEvent event) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "scrollToEvent", "CalendarEvent");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.scrollToEvent(event.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * Scrolls the {@link com.smartgwt.client.widgets.calendar.Calendar#getCurrentViewName current view} so the passed event is
     * visible.  If the event is outside of the view's current date-range, the default behavior is to automatically reload the
     * view with a date-range starting at the event's  {@link com.smartgwt.client.widgets.calendar.Calendar#getStartDateField
     * startDate} and then scroll to the event vertically as  necessary.  Pass false as the <code>canReload</code> param to
     * prevent that default behavior.
     * @param event the event to move the calendar view to
     * @param canReload set to false to prevent a view from automatically reloading                               with a new range if the passed
     * event is not in its current                               scrollable range
     */
    public native void scrollToEvent(CalendarEvent event, boolean canReload) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "scrollToEvent", "CalendarEvent,boolean");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.scrollToEvent(event.@com.smartgwt.client.core.DataClass::getJsObj()(), canReload);
    }-*/;
	
	/**
     * Move the viewport of a CalendarView to the start of it's scrollable range.
     */
    public native void scrollToStart() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "scrollToStart", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.scrollToStart();
    }-*/;

	/**
     * Move the viewport of a CalendarView to the start of it's scrollable range.
     * @param view the view to affect, the current view if not specified
     */
    public native void scrollToStart(CalendarView view) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "scrollToStart", "CalendarView");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.scrollToStart(view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;
	
	/**
     * Scrolls Calendar {@link com.smartgwt.client.widgets.calendar.Calendar#getDayView day} or {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWeekView week} views to the time represented by the time parameter. 
     * This string parameter is expected to be an  arbitrary logical time value in any parsable time format - no date portion
     * is expected, but  time formats like "13:31" or "1:20am" are supported. <P> Has no effect in {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timelines}, where an arbitrary time-value is inapplicable
     * to any range or resolution greater than a day.
     * @param time any parsable time-string
     */
    public native void scrollToTime(String time) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "scrollToTime", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.scrollToTime(time);
    }-*/;

	/**
     * Adds an event to the list of selected events in the current view, showing it in a selected  style.
     * @param event the event to add to the selection
     *
     * @return true if the selection was changed, false otherwise
     */
    public native Boolean selectEvent(CalendarEvent event) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "selectEvent", "CalendarEvent");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.selectEvent(event.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Adds one or more events to the list of selected events in the current view, showing them in  a selected style.
     * @param events the events to add to the selection
     *
     * @return true if the selection was changed, false otherwise
     */
    public native Boolean selectEvents(CalendarEvent... events) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "selectEvents", "CalendarEvent...");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.selectEvents(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(events));
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Selects a single event in the current view, showing it in a selected style and deselecting  any other selected events.
     * @param event the event to select
     *
     * @return true if the selection was changed, false otherwise
     */
    public native Boolean selectSingleEvent(CalendarEvent event) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "selectSingleEvent", "CalendarEvent");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.selectSingleEvent(event.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Selects the calendar view in the passed tab number.
     * @param tabnum the index of the tab to select
     */
    public native void selectTab(int tabnum) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "selectTab", "int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectTab(tabnum);
    }-*/;

	/**
     * Update the styleName for the passed event.  Refreshes the event's canvas in the current view.
     * @param event The event object to refresh in the current view
     * @param styleName The new CSS style to apply to the canvases showing this event.
     * See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName}
     */
    public native void setEventStyle(CalendarEvent event, String styleName) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setEventStyle", "CalendarEvent,String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setEventStyle(event.@com.smartgwt.client.core.DataClass::getJsObj()(), styleName);
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setResolution", "HeaderLevel[],TimeUnit,Integer");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setResolution", "HeaderLevel[],TimeUnit,Integer,Integer");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setTimelineRange", "Date");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setTimelineRange", "Date,Date");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setTimelineRange(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(start), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(end));
    }-*/;
	
	/**
     * Returns true if the passed date should be considered disabled.  Disabled dates don't allow  events to be created by
     * clicking on them, and drag operations that would start or end on such dates are also disallowed. <P> The default
     * implementation returns false only for dates that fall on a  {@link com.smartgwt.client.util.DateUtil#getWeekendDays
     * weekend}.
     * @param date a Date instance
     *
     * @return true if this date should be considered disabled
     */
    public native boolean shouldDisableDate(Date date) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "shouldDisableDate", "Date");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.shouldDisableDate(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date));
        return ret == null ? false : ret;
    }-*/;

	/**
     * Returns true if the passed date should be considered disabled.  Disabled dates don't allow  events to be created by
     * clicking on them, and drag operations that would start or end on such dates are also disallowed. <P> The default
     * implementation returns false only for dates that fall on a  {@link com.smartgwt.client.util.DateUtil#getWeekendDays
     * weekend}.
     * @param date a Date instance
     * @param view the view the date appears in
     *
     * @return true if this date should be considered disabled
     */
    public native boolean shouldDisableDate(Date date, CalendarView view) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "shouldDisableDate", "Date,CalendarView");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.shouldDisableDate(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        return ret == null ? false : ret;
    }-*/;
	
	/**
     * Indicates whether the passed date should be visible in the passed {@link
     * com.smartgwt.client.widgets.calendar.CalendarView}. <P> The default implementation returns true, unless the date falls
     * on a  {@link com.smartgwt.client.util.DateUtil#getWeekendDays weekend} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowWeekends showWeekends} is  false.
     * @param date a Date instance
     *
     * @return true if this date should be considered disabled
     */
    public native boolean shouldShowDate(Date date) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "shouldShowDate", "Date");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.shouldShowDate(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date));
        return ret == null ? false : ret;
    }-*/;

	/**
     * Indicates whether the passed date should be visible in the passed {@link
     * com.smartgwt.client.widgets.calendar.CalendarView}. <P> The default implementation returns true, unless the date falls
     * on a  {@link com.smartgwt.client.util.DateUtil#getWeekendDays weekend} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowWeekends showWeekends} is  false.
     * @param date a Date instance
     * @param view the view the date appears in
     *
     * @return true if this date should be considered disabled
     */
    public native boolean shouldShowDate(Date date, CalendarView view) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "shouldShowDate", "Date,CalendarView");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.shouldShowDate(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        return ret == null ? false : ret;
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "shouldShowEvent", "CalendarEvent");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.shouldShowEvent(event.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret == null ? false : ret;
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "shouldShowEvent", "CalendarEvent,CalendarView");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.shouldShowEvent(event.@com.smartgwt.client.core.DataClass::getJsObj()(), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        return ret == null ? false : ret;
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "shouldShowLane", "Lane");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.shouldShowLane(lane.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret == null ? false : ret;
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "shouldShowLane", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.shouldShowLane(lane);
        return ret == null ? false : ret;
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "shouldShowLane", "Lane,CalendarView");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.shouldShowLane(lane.@com.smartgwt.client.core.DataClass::getJsObj()(), view == null ? null : view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        return ret == null ? false : ret;
    }-*/;
	
	/**
     * Should a component be applied to the passed {@link com.smartgwt.client.widgets.calendar.EventCanvas canvas} in the  
     * {@link com.smartgwt.client.widgets.calendar.EventCanvas#getCalendarView view} in which it appears?  Return false from
     * this method to  override the global value of  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowEventCanvasComponents showEventCanvasComponents} for this canvas.
     * @param canvas should this eventCanvas get a component component?
     *
     * @return boolean
     * @see com.smartgwt.client.widgets.calendar.Calendar#createEventCanvasComponent
     * @see com.smartgwt.client.widgets.calendar.Calendar#updateEventCanvasComponent
     */
    public native boolean showEventCanvasComponent(EventCanvas canvas) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "showEventCanvasComponent", "EventCanvas");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.showEventCanvasComponent(canvas == null ? null : canvas.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        return ret == null ? false : ret;
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "showEventDialog", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showEventDialog();
    }-*/;

    /**
     * @see Calendar#showEventDialog
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "showEventDialog", "CalendarEvent,Boolean");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "showEventEditor", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showEventEditor();
    }-*/;

    /**
     * @see Calendar#showEventEditor
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "showEventEditor", "CalendarEvent,Boolean");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "showNewEventDialog", "");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "showNewEventDialog", "CalendarEvent");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showNewEventDialog(event == null ? null : event.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	
	/**
     * Show an Event Editor for a new event.  If an {@link com.smartgwt.client.widgets.calendar.CalendarEvent event} is passed
     * as the  parameter, it is used as defaults for the new event.
     */
    public native void showNewEventEditor() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "showNewEventEditor", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showNewEventEditor();
    }-*/;

	/**
     * Show an Event Editor for a new event.  If an {@link com.smartgwt.client.widgets.calendar.CalendarEvent event} is passed
     * as the  parameter, it is used as defaults for the new event.
     * @param event defaults for the new event to show in the Editor
     */
    public native void showNewEventEditor(CalendarEvent event) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "showNewEventEditor", "CalendarEvent");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showNewEventEditor(event == null ? null : event.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	
	/**
     * Called when a Timeline event is moved via dragging by a user.  Return false to disallow the  move.
     * @param event the event that was moved
     * @param startDate new start date of the passed event
     * @param endDate new end date of the passed event
     * @param lane the Lane in which this event has been dropped
     *
     * @return return false to disallow the move.
     * @deprecated in favor of {@link com.smartgwt.client.widgets.calendar.Calendar#addEventRepositionStopHandler
     * Calendar.eventRepositionStop()}
     */
    public native Boolean timelineEventMoved(CalendarEvent event, Date startDate, Date endDate, Lane lane) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "timelineEventMoved", "CalendarEvent,Date,Date,Lane");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.timelineEventMoved(event.@com.smartgwt.client.core.DataClass::getJsObj()(), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(startDate), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(endDate), lane.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Called when a Timeline event is resized via dragging by a user.  Return false to disallow  the resize.
     * @param event the event that was resized
     * @param startDate new start date of the passed event, after the resize
     * @param endDate new end date of the passed event, after the resize
     *
     * @return return false to disallow the resize
     * @deprecated in favor of {@link com.smartgwt.client.widgets.calendar.Calendar#addEventResizeStopHandler Calendar.eventResizeStop()}
     */
    public native Boolean timelineEventResized(CalendarEvent event, Date startDate, Date endDate) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "timelineEventResized", "CalendarEvent,Date,Date");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.timelineEventResized(event.@com.smartgwt.client.core.DataClass::getJsObj()(), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(startDate), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(endDate));
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Update an event in this calendar.
     * @param event The event object that will be updated
     * @param newEvent The new attributes for the event
     * @param otherFields new values of additional fields to be updated
     */
    public native void updateCalendarEvent(CalendarEvent event, CalendarEvent newEvent, Map otherFields) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "updateCalendarEvent", "CalendarEvent,CalendarEvent,Map");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.updateCalendarEvent(event.@com.smartgwt.client.core.DataClass::getJsObj()(), newEvent.@com.smartgwt.client.core.DataClass::getJsObj()(), otherFields == null ? null : @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(otherFields));
    }-*/;

	/**
     * Called from {@link com.smartgwt.client.widgets.calendar.EventCanvas#setEvent EventCanvas.setEvent()} when {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getShowEventCanvasComponents showEventCanvasComponents} is  true and the
     * eventCanvas already has a  {@link com.smartgwt.client.widgets.calendar.Calendar#createEventCanvasComponent component}. 
     * This method is expected to update  the passed <code>component</code> as necessary, based on the  {@link
     * com.smartgwt.client.widgets.calendar.EventCanvas#getEvent current event}. <P> By default, if the passed
     * <code>component</code> has methods called  <code>setEvent</code> or <code>setData</code>, those methods are called
     * automatically.
     * @param canvas the eventCanvas to update the component for
     * @param component the component to be updated the canvas in question
     * @see com.smartgwt.client.widgets.calendar.Calendar#createEventCanvasComponent
     */
    public native void updateEventCanvasComponent(EventCanvas canvas, Canvas component) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "updateEventCanvasComponent", "EventCanvas,Canvas");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.updateEventCanvasComponent(canvas == null ? null : canvas.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), component == null ? null : component.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;

    /**
     * Add a zoneClick handler.
     * <p>
     * Called whenever a {@link com.smartgwt.client.widgets.calendar.ZoneCanvas} is clicked in the  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timelineView}.  There is no default implementation.
     *
     * @param handler the zoneClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addZoneClickHandler(com.smartgwt.client.widgets.calendar.events.ZoneClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.calendar.events.ZoneClick.getType()) == 0) setupZoneClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.calendar.events.ZoneClick.getType());
    }

    private native void setupZoneClickEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var zoneClick = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.calendar.events.ZoneClick::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.calendar.Calendar::handleTearDownZoneClickEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("zoneClick"));
            obj.addProperties({zoneClick: 
                function () {
                    var param = {"_this": this, "zoneEvent" : arguments[0], "viewName" : arguments[1]};
                    var ret = zoneClick(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("zoneClick", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("zoneClick"));
            obj.zoneClick = 
                function () {
                    var param = {"_this": this, "zoneEvent" : arguments[0], "viewName" : arguments[1]};
                    var ret = zoneClick(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("zoneClick", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownZoneClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.calendar.events.ZoneClick.getType()) == 0) tearDownZoneClickEvent();
    }

    private native void tearDownZoneClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("zoneClick")) delete obj.zoneClick;
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
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(Calendar calendarProperties) /*-{
        if (calendarProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(Calendar.@java.lang.Object::getClass()(), "setDefaultProperties", calendarProperties.@java.lang.Object::getClass()());
        }
        calendarProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = calendarProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
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
            if (jObj == null) return this._getDayBodyHTML(date, events, calendar, rowNum, colNum);
            var dateJ = @com.smartgwt.client.util.JSOHelper::toDate(D)(date.getTime());
            var eventsJ = events == null ? null : @com.smartgwt.client.util.ConvertTo::arrayOfCalendarEvent(Lcom/google/gwt/core/client/JavaScriptObject;)(events);
            var calendarJ = @com.smartgwt.client.widgets.calendar.Calendar::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(calendar);
            return jObj.@com.smartgwt.client.widgets.calendar.Calendar::getDayBodyHTML(Ljava/util/Date;[Lcom/smartgwt/client/widgets/calendar/CalendarEvent;Lcom/smartgwt/client/widgets/calendar/Calendar;II)(dateJ, eventsJ, calendarJ, rowNum, colNum);
        }));
        
        self.__getDateLabelText = self.getDateLabelText;
        self.getDateLabelText = $debox($entry(function(viewName, startDate, endDate) {
        	var jObj = this.__ref;
            if(jObj == null) return this.__getDateLabelText(viewName, startDate, endDate);
            var startDateJava = startDate == null ? null : @com.smartgwt.client.util.JSOHelper::toDate(D)(startDate.getTime());
            var endDateJava = endDate == null ? null :  @com.smartgwt.client.util.JSOHelper::toDate(D)(endDate.getTime());
            return jObj.@com.smartgwt.client.widgets.calendar.Calendar::getDateLabelText(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)(viewName, startDateJava, endDateJava);
        }));        
        
        self.__getWorkdayStart = self.getWorkdayStart;
        self.getWorkdayStart = $debox($entry(function(date, laneName) {
        	var jObj = this.__ref;
            if(jObj == null) return this.__getWorkdayStart(date, laneName);
            var dateJava = date == null ? null : @com.smartgwt.client.util.JSOHelper::toDate(D)(date.getTime());
            return jObj.@com.smartgwt.client.widgets.calendar.Calendar::getWorkdayStart(Ljava/util/Date;Ljava/lang/String;)(dateJava,laneName);
        }));

        self.__getWorkdayEnd = self.getWorkdayEnd;
        self.getWorkdayEnd = $debox($entry(function(date, laneName) {
        	var jObj = this.__ref;
            if(jObj == null) return this.__getWorkdayEnd(date, laneName);
            var dateJava = date == null ? null : @com.smartgwt.client.util.JSOHelper::toDate(D)(date.getTime());
            return jObj.@com.smartgwt.client.widgets.calendar.Calendar::getWorkdayEnd(Ljava/util/Date;Ljava/lang/String;)(dateJava,laneName);
        }));

        self.__dateIsWorkday = self.dateIsWorkday;
        self.dateIsWorkday = $debox($entry(function(date, laneName) {
        	var jObj = this.__ref;
            if(jObj == null) return this.__dateIsWorkday(date, laneName);
            var dateJava = date == null ? null : @com.smartgwt.client.util.JSOHelper::toDate(D)(date.getTime());
            var result = jObj.@com.smartgwt.client.widgets.calendar.Calendar::dateIsWorkday(Ljava/util/Date;Ljava/lang/String;)(dateJava,laneName);
            return result == null ? false : result;
        }));

        }-*/;
    
    /**
     * When using 
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getShowWorkday showWorkday}:true,
     * <code>workdayStart</code> and <code>workdayEnd</code> specify the time of day when the
     * workday starts and ends, specified as a String acceptable to String.
     * <P> 
     * Both start and end time must fall on a 30 minute increment (eg 9:30, but not 9:45).
     * <P>
     * The hours of the workday can be customized for particular dates by providing 
     * implementations of 
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart getWorkdayStart()}
     * and {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayEnd getWorkdayEnd()}.
     * <P><B>Note: This is an override point</B>
     *
     * @param date  the date to get the workday start for
     * @param laneName  the name of the lane if 
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes showDayLanes} is
     * true, or null otherwise
     *
     * @return Returns the start of the working day on the passed date.  By default, this method
     * returns the value of 
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart workdayStart}.
     * Default value is "9:00am"
     */
    public native String getWorkdayStart(Date date, String laneName)  /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getWorkdayStart", "Date,String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
	    var dateJS = date == null ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date);
        return self.__getWorkdayStart(dateJS, laneName);
    }-*/;

    /**
     * See {@link #getWorkdayStart(Date,String)}.
     */
    public String getWorkdayStart(Date date) {
        return getWorkdayStart(date, null);
    }

    /**
     * When using {@link com.smartgwt.client.widgets.calendar.Calendar#getShowWorkday showWorkday}:true,
     * <code>workdayStart</code> and <code>workdayEnd</code> specify the time of day when the
     * workday starts and ends, specified as a String acceptable to String.
     * <P> 
     * Both start and end time must fall on a 30 minute increment (eg 9:30, but not 9:45).
     * <P>
     * The hours of the workday can be customized for particular dates by providing
     * implementations of 
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayStart getWorkdayStart()}
     * and {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayEnd getWorkdayEnd()}.
     * <P><B>Note: This is an override point</B>
     *
     * @param date  the date to get the workday end for
     * @param laneName  the name of the lane if
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes showDayLanes} is
     * true, or null otherwise
     *
     * @return Returns the end of the working day on the passed date.  By default, this method
     * returns the value of
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdayEnd workdayEnd}.
     * Default value is "5:00pm"
     */
    public native String getWorkdayEnd(Date date, String laneName)  /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getWorkdayEnd", "Date,String");
        }
    	var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
	    var dateJS = date == null ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date);
    	return self.__getWorkdayEnd(dateJS, laneName);
	}-*/;

    /**
     * See {@link #getWorkdayEnd(Date,String)}.
     */
    public String getWorkdayEnd(Date date) {
        return getWorkdayEnd(date, null);
    }    

	/**
     * Should the parameter date be considered a workday? By default this method tries to find
     * the parameter date day in 
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getWorkdays workdays}, and returns
     * true if found. Override this method to provide custom logic for determining workday, for
     * example returning false on holidays. <P> Note that, when showing
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes vertical lanes} in
     * the {@link com.smartgwt.client.widgets.calendar.Calendar#getDayView day view}, this
     * method is also passed the name of the associated lane.
     * <P><B>Note: This is an override point</B>
     *
     * @param date date to check for being a workday
     * @param laneName the name of the lane if 
     * {@link com.smartgwt.client.widgets.calendar.Calendar#getShowDayLanes showDayLanes} is
     * true, or null otherwise
     *
     * @return true if date is a workday, false otherwise
     */
    public native boolean dateIsWorkday(Date date, String laneName)  /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "dateIsWorkday", "Date,String");
        }
    	var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
	    var dateJS = date == null ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date);
    	return self.__dateIsWorkday(dateJS, laneName);
	}-*/;

    /**
     * See {@link #dateIsWorkday(Date,String)}.
     */
    public boolean dateIsWorkday(Date date) {
        return dateIsWorkday(date, null);
    }

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
    protected native String getDayBodyHTML(Date date, CalendarEvent[] events, Calendar calendar, int rowNum, int colNum) /*-{
        var dateJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date);
        var eventsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(events);
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var calendarJS = calendar.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self._getDayBodyHTML(dateJS, eventsJS, calendarJS,rowNum, colNum);
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
            customizer.@com.smartgwt.client.widgets.calendar.EventEditorCustomizer::setCalendar(Lcom/smartgwt/client/widgets/calendar/Calendar;)(calendarJ);

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
        	var calendarView = @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(jCalendarView);

            return customizer.@com.smartgwt.client.widgets.calendar.EventHeaderHTMLCustomizer::getEventHeaderHTML(Lcom/smartgwt/client/widgets/calendar/CalendarEvent;Lcom/smartgwt/client/widgets/calendar/CalendarView;)(calendarEvent,calendarView);
        }));
    }-*/;

    /**
     * This method installs a customizer that returns the HTML to be used as the body/description for the passed event.
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
        	var calendarView = @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(jCalendarView);

            return customizer.@com.smartgwt.client.widgets.calendar.EventBodyHTMLCustomizer::getEventBodyHTML(Lcom/smartgwt/client/widgets/calendar/CalendarEvent;Lcom/smartgwt/client/widgets/calendar/CalendarView;)(calendarEvent,calendarView);
        }));
    }-*/;

    /**
     * This method installs a customizer that returns the CSS class name for the passed date-cell when rendered in the passed view
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
        	var calendarViewJ = @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(calendarView);

            var result = customizer.@com.smartgwt.client.widgets.calendar.DateStyleCustomizer::getDateStyle(Ljava/util/Date;IILcom/smartgwt/client/widgets/calendar/CalendarView;)(dateJ, rowNum, colNum, calendarViewJ);
            if (result != null) return result;
            return null;
        }));
    }-*/;

    /**
     * This method installs a customizer to determine the HTML to be displayed in the header for a given date column in a CalendarView
     * 
     * @param customizer the customizer to execute.
     */
    public native void setDateHeaderCustomizer(DateHeaderCustomizer customizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }

        self.getDateHeaderTitle = $debox($entry(function(date, dayOfWeek, defaultValue, calendarView) {
            var dateJ = null;
            if (date != null) dateJ = @com.smartgwt.client.util.JSOHelper::toDate(D)(date.getTime());
        	var calendarViewJ = @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(calendarView);

            var result = customizer.@com.smartgwt.client.widgets.calendar.DateHeaderCustomizer::getHeaderTitle(Ljava/util/Date;ILjava/lang/String;Lcom/smartgwt/client/widgets/calendar/CalendarView;)(dateJ, dayOfWeek, defaultValue, calendarViewJ);
            if (result != null) return result;
            return null;
        }));
    }-*/;

    /**
     * This method installs a customizer that returns the HTML to display in the passed date-cell when rendered in the passed view
     * 
     * @param customizer the customizer to execute.
     */
    public native void setDateHTMLCustomizer(DateHTMLCustomizer customizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }

        self.getDateHTML = $debox($entry(function(date, rowNum, colNum, calendarView) {
            var dateJ   = @com.smartgwt.client.util.JSOHelper::toDate(D)(date.getTime());
        	var calendarViewJ = @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(calendarView);

            var result = customizer.@com.smartgwt.client.widgets.calendar.DateHTMLCustomizer::getDateHTML(Ljava/util/Date;IILcom/smartgwt/client/widgets/calendar/CalendarView;)(dateJ, rowNum, colNum, calendarViewJ);
            if (result != null) return result;
            return null;
        }));
    }-*/;

    /**
     * This method installs a customizer that returns the horizontsal Alignment to display in the passed date-cell when rendered in the passed view
     * 
     * @param customizer the customizer to execute.
     */
    public native void setDateCellAlignCustomizer(DateCellAlignCustomizer customizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }

        self.getDateCellAlign = $debox($entry(function(date, rowNum, colNum, calendarView) {
            var dateJ   = @com.smartgwt.client.util.JSOHelper::toDate(D)(date.getTime());
        	var calendarViewJ = @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(calendarView);

            var result = customizer.@com.smartgwt.client.widgets.calendar.DateCellAlignCustomizer::getDateCellAlign(Ljava/util/Date;IILcom/smartgwt/client/widgets/calendar/CalendarView;)(dateJ, rowNum, colNum, calendarViewJ);
            if (result != null) return result;
            return null;
        }));
    }-*/;

    /**
     * This method installs a customizer that returns the VerticalAlignment to display in the passed date-cell when rendered in the passed view
     * 
     * @param customizer the customizer to execute.
     */
    public native void setDateCellVAlignCustomizer(DateCellVAlignCustomizer customizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }

        self.getDateCellVAlign = $debox($entry(function(date, rowNum, colNum, calendarView) {
            var dateJ   = @com.smartgwt.client.util.JSOHelper::toDate(D)(date.getTime());
        	var calendarViewJ = @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(calendarView);

            var result = customizer.@com.smartgwt.client.widgets.calendar.DateCellVAlignCustomizer::getDateCellVAlign(Ljava/util/Date;IILcom/smartgwt/client/widgets/calendar/CalendarView;)(dateJ, rowNum, colNum, calendarViewJ);
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
        	var calendarViewJ = @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(calendarView);

            return customizer.@com.smartgwt.client.widgets.calendar.DateCSSTextCustomizer::getDateCSSText(Ljava/util/Date;IILcom/smartgwt/client/widgets/calendar/CalendarView;)(dateJ, rowNum, colNum, calendarViewJ);
        }));
    }-*/;

    /**
     * Return true from the customizer to have the passed event considered disabled in the passed view
     * 
     * @param customizer the customizer to execute.
     */
    public native void setDisableDateCustomizer(DisableDateCustomizer customizer) /*-{
        var isCreated = this.@com.smartgwt.client.widgets.BaseWidget::isCreated()();
        var self;
        if(isCreated) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            // store the default implementation from the instance
            self._shouldDisableDate = self.shouldDisableDate;
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            // store the default implementation from the Class
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            self._shouldDisableDate = $wnd.isc[scClassName].getInstanceProperty("shouldDisableDate");
        }

        self.shouldDisableDate = $debox($entry(function(date, calendarView) {
            // if not yet created, the stored implementation came from the instancePrototype -
            // in this case, that method may make calls to other methods on "this" which have
            // not been installed on the config object - bail in this case
            if (this.ID == null || date == null) return false;
            var dateJ = @com.smartgwt.client.util.JSOHelper::toDate(D)(date.getTime());
        	var calendarViewJ = @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(calendarView);

            // store the Calendar on the customizer so it can be used by executeDefault()
            var calendarJ = @com.smartgwt.client.widgets.BaseWidget::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(this);
            customizer.@com.smartgwt.client.widgets.calendar.DisableDateCustomizer::setCalendar(Lcom/smartgwt/client/widgets/calendar/Calendar;)(calendarJ);
            // run the customizer
            var result = customizer.@com.smartgwt.client.widgets.calendar.DisableDateCustomizer::shouldDisableDate(Ljava/util/Date;Lcom/smartgwt/client/widgets/calendar/CalendarView;)(dateJ, calendarViewJ);

            if (result == null) return null;
            return result;
        }));
    }-*/;

    /**
     * This method is called during rendering for all events in the visible range - those which
     * would be rendered by default.  The customizer should return false to prevent the passed 
     * date from appearing in the passed view.
     * 
     * @param customizer the customizer to execute.
     */
    public native void setShowDateCustomizer(ShowDateCustomizer customizer) /*-{
        var self;
        var isCreated = this.@com.smartgwt.client.widgets.BaseWidget::isCreated()();
        if(isCreated) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            // store the default implementation from the instance
            self._shouldShowDate = self.shouldShowDate;
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            // store the default implementation from the Class
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            self._shouldShowDate = $wnd.isc[scClassName].getInstanceProperty("shouldShowDate");
        }

        self.shouldShowDate = $debox($entry(function(date, calendarView) {
            // if not yet created, the stored implementation came from the instancePrototype -
            // in this case, that method may make calls to other methods on "this" which have
            // not been installed on the config object - bail in this case
            if (this.ID == null || date == null) return false;
            var dateJ   = @com.smartgwt.client.util.JSOHelper::toDate(D)(date.getTime());
        	var calendarViewJ = @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(calendarView);

            // store the Calendar on the customizer so it can be used by executeDefault()
            var calendarJ = @com.smartgwt.client.widgets.BaseWidget::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(this);
            customizer.@com.smartgwt.client.widgets.calendar.ShowDateCustomizer::setCalendar(Lcom/smartgwt/client/widgets/calendar/Calendar;)(calendarJ);
            // run the customizer
            var result = customizer.@com.smartgwt.client.widgets.calendar.ShowDateCustomizer::shouldShowDate(Ljava/util/Date;Lcom/smartgwt/client/widgets/calendar/CalendarView;)(dateJ, calendarViewJ);

            if (result == null) return null;
            return result;
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
        var isCreated = this.@com.smartgwt.client.widgets.BaseWidget::isCreated()();
        if(isCreated) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            // store the default implementation from the instance
            self._shouldShowLane = self.shouldShowLane;
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            // store the default implementation from the Class
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            self._shouldShowLane = $wnd.isc[scClassName].getInstanceProperty("shouldShowLane");
        }

        self.shouldShowLane = $debox($entry(function(lane, calendarView) {
            // if not yet created, the stored implementation came from the instancePrototype -
            // in this case, that method may make calls to other methods on "this" which have
            // not been installed on the config object - bail in this case
            if (this.ID == null || lane == null) return false;
            var laneJ = @com.smartgwt.client.widgets.calendar.Lane::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(lane);
        	var calendarViewJ = @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(calendarView);

            // store the Calendar on the customizer so it can be used by executeDefault()
            var calendarJ = @com.smartgwt.client.widgets.BaseWidget::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(this);
            customizer.@com.smartgwt.client.widgets.calendar.ShowLaneCustomizer::setCalendar(Lcom/smartgwt/client/widgets/calendar/Calendar;)(calendarJ);
            // run the customizer
            var result = customizer.@com.smartgwt.client.widgets.calendar.ShowLaneCustomizer::shouldShowLane(Lcom/smartgwt/client/widgets/calendar/Lane;Lcom/smartgwt/client/widgets/calendar/CalendarView;)(laneJ, calendarViewJ);

            if (result == null) return null;
            return result;
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
        var isCreated = this.@com.smartgwt.client.widgets.BaseWidget::isCreated()();
        if(isCreated) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            // store the default implementation from the instance
            self._shouldShowEvent = self.shouldShowEvent;
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            // store the default implementation from the Class
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            self._shouldShowEvent = $wnd.isc[scClassName].getInstanceProperty("shouldShowEvent");
        }

        self.shouldShowEvent = $debox($entry(function(event, calendarView) {
            // if not yet created, the stored implementation came from the instancePrototype -
            // in this case, that method may make calls to other methods on "this" which have
            // not been installed on the config object - bail in this case
            if (this.ID == null || event == null) return false;
            var eventJ = @com.smartgwt.client.widgets.calendar.CalendarEvent::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
        	var calendarViewJ = @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(calendarView);

            // store the Calendar on the customizer so it can be used by executeDefault()
            var calendarJ = @com.smartgwt.client.widgets.BaseWidget::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(this);
            customizer.@com.smartgwt.client.widgets.calendar.ShowEventCustomizer::setCalendar(Lcom/smartgwt/client/widgets/calendar/Calendar;)(calendarJ);
            // run the customizer
            var result = customizer.@com.smartgwt.client.widgets.calendar.ShowEventCustomizer::shouldShowEvent(Lcom/smartgwt/client/widgets/calendar/CalendarEvent;Lcom/smartgwt/client/widgets/calendar/CalendarView;)(eventJ, calendarViewJ);
            if (result == null) return null;
            return result;
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
            var eventWindow = @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(jsEventWindow);
            return eventHoverHTMLCustomizer.@com.smartgwt.client.widgets.calendar.EventHoverHTMLCustomizer::getEventHoverHTML(Lcom/smartgwt/client/widgets/calendar/CalendarEvent;Lcom/smartgwt/client/widgets/calendar/EventWindow;)(calendarEvent,eventWindow);
        }));
    }-*/;

    /**
     * This method returns the hover HTML to be displayed when the user hovers over an eventCanvas
     * 
     * @param customizer the customizer to execute.
     */
    public native void setEventCanvasHoverHTMLCustomizer(EventCanvasHoverHTMLCustomizer customizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }

        self.getEventHoverHTML = $debox($entry(function(jsEvent, jsEventCanvas) {
        	
            var calendarJ = @com.smartgwt.client.widgets.BaseWidget::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(this);
            customizer.@com.smartgwt.client.widgets.calendar.EventCanvasHoverHTMLCustomizer::setCalendar(Lcom/smartgwt/client/widgets/calendar/Calendar;)(calendarJ);
        	var calendarEventJ = @com.smartgwt.client.widgets.calendar.CalendarEvent::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(jsEvent);
            // call the new eventCanvas method
            var eventCanvasJ = @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(jsEventCanvas);
            return customizer.@com.smartgwt.client.widgets.calendar.EventCanvasHoverHTMLCustomizer::getHoverHTML(Lcom/smartgwt/client/widgets/calendar/CalendarEvent;Lcom/smartgwt/client/widgets/calendar/EventCanvas;)(calendarEventJ,eventCanvasJ);
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
        	var canvasJ = @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(jsCanvas);
            
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
        	var canvasJ = @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(jsCanvas);
            
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
    
    /**
     * Customize the Hover text for a given span in a HeaderLevel.
     * @param customizer HeaderLevelHoverCustomizer the customizer
     */
    public native void setHeaderHoverCustomizer(HeaderLevelHoverCustomizer customizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        self.getHeaderHoverHTML = $debox($entry(function(calendarView, headerLevel, startDate, endDate, defaultValue) {
            var headerLevelJ = @com.smartgwt.client.widgets.calendar.HeaderLevel::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(headerLevel);
            var startDateJ = startDate == null ? null : @com.smartgwt.client.util.JSOHelper::toDate(D)(startDate.getTime());
            var endDateJ = endDate == null ? null : @com.smartgwt.client.util.JSOHelper::toDate(D)(endDate.getTime());
            var calendarViewJ = calendarView == null ? null : @com.smartgwt.client.widgets.calendar.CalendarView::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(calendarView);
            var calendarJ = calendarView == null ? null : @com.smartgwt.client.widgets.calendar.Calendar::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(calendarView.calendar);
            
            customizer.@com.smartgwt.client.widgets.calendar.HeaderLevelHoverCustomizer::setCalendar(Lcom/smartgwt/client/widgets/calendar/Calendar;)(calendarJ);

            var returnValue = customizer.@com.smartgwt.client.widgets.calendar.HeaderLevelHoverCustomizer::getHoverHTML(Lcom/smartgwt/client/widgets/calendar/HeaderLevel;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;Lcom/smartgwt/client/widgets/calendar/CalendarView;)(headerLevelJ,startDateJ,endDateJ,defaultValue,calendarViewJ);
            
            return returnValue == null ? null : returnValue;
        }));
    }-*/;

    /**
     * Customize the Hover text to display during a drag operation
     * @param customizer DragHoverCustomizer the customizer
     */
    public native void setDragHoverCustomizer(DragHoverCustomizer customizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        self.getDragHoverHTML = $debox($entry(function(calendarView, calendarEvent, defaultValue) {
            var calendarViewJ = calendarView == null ? null : @com.smartgwt.client.widgets.calendar.CalendarView::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(calendarView);
            var calendarEventJ = @com.smartgwt.client.widgets.calendar.CalendarEvent::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(calendarEvent);
            var calendarJ = calendarView == null ? null : @com.smartgwt.client.widgets.calendar.Calendar::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(calendarView.calendar);
            
            customizer.@com.smartgwt.client.widgets.calendar.DragHoverCustomizer::setCalendar(Lcom/smartgwt/client/widgets/calendar/Calendar;)(calendarJ);

            var returnValue = customizer.@com.smartgwt.client.widgets.calendar.DragHoverCustomizer::getHoverHTML(Lcom/smartgwt/client/widgets/calendar/CalendarEvent;Ljava/lang/String;Lcom/smartgwt/client/widgets/calendar/CalendarView;)(calendarEventJ, defaultValue, calendarViewJ);
            
            return returnValue == null ? null : returnValue;
        }));
    }-*/;

    /**
     * Customize the Hover text to display when the mouse hovers over cells in a CalendarView
     * @param customizer CellHoverCustomizer the customizer
     */
    public native void setCellHoverCustomizer(CellHoverCustomizer customizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        self.getCellHoverHTML = $debox($entry(function(calendarView, record, rowNum, colNum, date, defaultValue) {
            var calendarViewJ = calendarView == null ? null : @com.smartgwt.client.widgets.calendar.CalendarView::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(calendarView);
            var recordJ = @com.smartgwt.client.widgets.grid.ListGridRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            var dateJ = date == null ? null : @com.smartgwt.client.util.JSOHelper::toDate(D)(date.getTime());
            var calendarJ = calendarView == null ? null : @com.smartgwt.client.widgets.calendar.Calendar::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(calendarView.calendar);
            
            customizer.@com.smartgwt.client.widgets.calendar.CellHoverCustomizer::setCalendar(Lcom/smartgwt/client/widgets/calendar/Calendar;)(calendarJ);

            var returnValue = customizer.@com.smartgwt.client.widgets.calendar.CellHoverCustomizer::getHoverHTML(Lcom/smartgwt/client/widgets/grid/ListGridRecord;IILjava/util/Date;Ljava/lang/String;Lcom/smartgwt/client/widgets/calendar/CalendarView;)(recordJ,rowNum,colNum,dateJ,defaultValue,calendarViewJ);
            
            return returnValue == null ? null : returnValue;
        }));
    }-*/;
    
    /**
     * This method returns the SCImgURL for the icon to use as the gripper for a given EventCanvas
     * 
     * @param customizer the customizer to execute.
     */
    public native void setEventCanvasGripperIconCustomizer(EventCanvasGripperIconCustomizer customizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }

        self.getEventCanvasGripperIcon = $debox($entry(function(jsEventCanvas, jsView) {
            var eventCanvasJ = @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(jsEventCanvas);
            return customizer.@com.smartgwt.client.widgets.calendar.EventCanvasGripperIconCustomizer::getGripperIcon(Lcom/smartgwt/client/widgets/calendar/EventCanvas;)(eventCanvasJ);
        }));
    }-*/;


    /**
     * This method sets the customizer for EventCanvasComponent methods
     * 
     * @param customizer the customizer to execute.
     */
    public native void setEventCanvasComponentCustomizer(EventCanvasComponentCustomizer customizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }

        self.createEventCanvasComponent = $debox($entry(function(jsEventCanvas) {
            var eventCanvasJ = @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(jsEventCanvas);
            var componentJ = customizer.@com.smartgwt.client.widgets.calendar.EventCanvasComponentCustomizer::createEventCanvasComponent(Lcom/smartgwt/client/widgets/calendar/EventCanvas;)(eventCanvasJ);
            return componentJ == null ? null : componentJ.@com.smartgwt.client.widgets.Canvas::getOrCreateJsObj()();
        }));
        self.updateEventCanvasComponent = $debox($entry(function(jsEventCanvas, jsComponent) {
            var eventCanvasJ = @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(jsEventCanvas);
            var componentJ = @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(jsComponent);
            customizer.@com.smartgwt.client.widgets.calendar.EventCanvasComponentCustomizer::updateEventCanvasComponent(Lcom/smartgwt/client/widgets/calendar/EventCanvas;Lcom/smartgwt/client/widgets/Canvas;)(eventCanvasJ, componentJ);
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
    public void removeLane(Lane lane) {
        String laneName = lane.getName();
        removeLane(laneName);
    }

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

    /**
     * See {@link #getLaneGroupByFieldAsStringArray}.
     * @deprecated in favor of {@link #getLaneGroupByFieldAsStringArray}.
     */    
    public String[] getLaneGroupByFieldAsString()  {
        return getLaneGroupByFieldAsStringArray();
    }



    // ********************* DataBoundComponent Properties / Attributes ***********************

    public Calendar setDataPageSize(int dataPageSize) {
        return (Calendar)setAttribute("dataPageSize", dataPageSize, true);
    }

    public int getDataPageSize() {
        Integer dataPageSize = getAttributeAsInt("dataPageSize");
        return dataPageSize == null ? 0 : dataPageSize;
    }

    public Calendar setUseAllDataSourceFields(Boolean useAllDataSourceFields) {
        return (Calendar)setAttribute("useAllDataSourceFields", useAllDataSourceFields, true);
    }

    public Boolean getUseAllDataSourceFields() {
        return getAttributeAsBoolean("useAllDataSourceFields");
    }

    public Calendar setShowHiddenFields(Boolean showHiddenFields) {
        return (Calendar)setAttribute("showHiddenFields", showHiddenFields, true);
    }

    public Boolean getShowHiddenFields() {
        return getAttributeAsBoolean("showHiddenFields");
    }

    public Calendar setShowComplexFields(Boolean showComplexFields) {
        return (Calendar)setAttribute("showComplexFields", showComplexFields, true);
    }

    public Boolean getShowComplexFields() {
        return getAttributeAsBoolean("showComplexFields");
    }

    public Calendar setFetchOperation(String fetchOperation) {
        return (Calendar)setAttribute("fetchOperation", fetchOperation, true);
    }

    public String getFetchOperation() {
        return getAttributeAsString("fetchOperation");
    }

    public Calendar setUpdateOperation(String updateOperation) {
        return (Calendar)setAttribute("updateOperation", updateOperation, true);
    }

    public String getUpdateOperation() {
        return getAttributeAsString("updateOperation");
    }

    public Calendar setAddOperation(String addOperation) {
        return (Calendar)setAttribute("addOperation", addOperation, true);
    }

    public String getAddOperation() {
        return getAttributeAsString("addOperation");
    }

    public Calendar setRemoveOperation(String removeOperation) {
        return (Calendar)setAttribute("removeOperation", removeOperation, true);
    }

    public String getRemoveOperation() {
        return getAttributeAsString("removeOperation");
    }

    public Calendar setExportFields(String[] exportFields) {
        return (Calendar)setAttribute("exportFields", exportFields, true);
    }

    public String[] getExportFields() {
        return getAttributeAsStringArray("exportFields");
    }

    public Calendar setExportAll(Boolean exportAll) {
        return (Calendar)setAttribute("exportAll", exportAll, true);
    }

    public Boolean getExportAll() {
        return getAttributeAsBoolean("exportAll");
    }

    public Calendar setExportIncludeSummaries(Boolean exportIncludeSummaries) {
        return (Calendar)setAttribute("exportIncludeSummaries", exportIncludeSummaries, true);
    }

    public Boolean getExportIncludeSummaries() {
        return getAttributeAsBoolean("exportIncludeSummaries");
    }

    public Calendar setPreventDuplicates(Boolean preventDuplicates) throws IllegalStateException {
        return (Calendar)setAttribute("preventDuplicates", preventDuplicates, false);
    }

    public Boolean getPreventDuplicates() {
        return getAttributeAsBoolean("preventDuplicates");
    }

    public Calendar setDuplicateDragMessage(String duplicateDragMessage) throws IllegalStateException {
        return (Calendar)setAttribute("duplicateDragMessage", duplicateDragMessage, false);
    }

    public String getDuplicateDragMessage() {
        return getAttributeAsString("duplicateDragMessage");
    }

    public Calendar setAddDropValues(Boolean addDropValues) {
        return (Calendar)setAttribute("addDropValues", addDropValues, true);
    }

    public Boolean getAddDropValues() {
        return getAttributeAsBoolean("addDropValues");
    }

    public Calendar setDropValues(Map dropValues) {
        return (Calendar)setAttribute("dropValues", dropValues, true);
    }

    public Map getDropValues() {
        return getAttributeAsMap("dropValues");
    }

    /**
     * Indicates whether or not this component will load its data
     * {@link DataSource#setProgressiveLoading() progressively}
     * 
     * @see com.smartgwt.client.docs.ProgressiveLoading  
     * @see com.smartgwt.client.data.DataSource#setProgressiveLoading
     * @param progressiveLoading
     * @return {@link com.smartgwt.client.widgets.DataBoundComponent DataBoundComponent}
     * instance, for chaining setter calls
     */
    public Calendar setProgressiveLoading(Boolean progressiveLoading) {
        return (Calendar)setAttribute("progressiveLoading", progressiveLoading, false);
    }

    /**
     * Indicates whether or not this component will load its data {@link DataSource#getProgressiveLoading() progressively}
     * 
     * @see com.smartgwt.client.docs.ProgressiveLoading
     * @see com.smartgwt.client.data.DataSource#getProgressiveLoading
     * @return
     */
    public Boolean getProgressiveLoading() {
        return getAttributeAsBoolean("progressiveLoading");
    }

    public Calendar setUseFlatFields(Boolean useFlatFields) throws IllegalStateException {
        return (Calendar)setAttribute("useFlatFields", useFlatFields, false);
    }

    public Boolean getUseFlatFields() {
        return getAttributeAsBoolean("useFlatFields");
    }

    public Calendar setHiliteProperty(String hiliteProperty) {
        return (Calendar)setAttribute("hiliteProperty", hiliteProperty, true);
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

    public native void editHilites() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.editHilites();
    }-*/;

    public native String getHiliteState()  /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getHiliteState();
    }-*/;

    public native Calendar setHiliteState(String hiliteState)  /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setHiliteState(hiliteState);
        return this;
    }-*/;

    public native Calendar setHilites(Hilite[] hilites)/*-{
        var isCreated = this.@com.smartgwt.client.widgets.BaseWidget::isCreated()();
        var hilitesJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(hilites);
        if (isCreated) {
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.setHilites(hilitesJS);
        } else {
            var obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.hilites = hilitesJS;
        }
        return this;
    }-*/;

    public native Hilite[] getHilites()/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var hilitesJS = self.getHilites();
        return @com.smartgwt.client.util.ConvertTo::arrayOfHilite(Lcom/google/gwt/core/client/JavaScriptObject;)(hilitesJS);
    }-*/;

    public Calendar setDragDataAction(DragDataAction dragDataAction) {
        return (Calendar)setAttribute("dragDataAction", dragDataAction.getValue(), true);
    }

    public DragDataAction getDragDataAction() {
        return EnumUtil.getEnum(DragDataAction.values(), getAttribute("dragDataAction"));
    }

    public Calendar setDragTrackerStyle(String dragTrackerStyle) {
        return (Calendar)setAttribute("dragTrackerStyle", dragTrackerStyle, true);
    }

    public String getDragTrackerStyle() {
        return getAttributeAsString("dragTrackerStyle");
    }

    public Calendar setCanAddFormulaFields(Boolean canAddFormulaFields) {
        return (Calendar)setAttribute("canAddFormulaFields", canAddFormulaFields, true);
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

    public Calendar setAddFormulaFieldText(String addFormulaFieldText) {
        return (Calendar)setAttribute("addFormulaFieldText", addFormulaFieldText, true);
    }

    public String getAddFormulaFieldText() {
        return getAttributeAsString("addFormulaFieldText");
    }

    public Calendar setEditFormulaFieldText(String editFormulaFieldText) {
        return (Calendar)setAttribute("editFormulaFieldText", editFormulaFieldText, true);
    }

    public String getEditFormulaFieldText() {
        return getAttributeAsString("editFormulaFieldText");
    }

    public Calendar setCanAddSummaryFields(Boolean canAddSummaryFields) {
        return (Calendar)setAttribute("canAddSummaryFields", canAddSummaryFields, true);
    }

    public Boolean getCanAddSummaryFields() {
        return getAttributeAsBoolean("canAddSummaryFields");
    }

    public Calendar setAddSummaryFieldText(String addSummaryFieldText) {
        return (Calendar)setAttribute("addSummaryFieldText", addSummaryFieldText, true);
    }

    public String getAddSummaryFieldText() {
        return getAttributeAsString("addSummaryFieldText");
    }

    public Calendar setEditSummaryFieldText(String editSummaryFieldText) {
        return (Calendar)setAttribute("editSummaryFieldText", editSummaryFieldText, true);
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
    		var criteriaJ = adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
        return recordsJS == null ? null : @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
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
    		var criteriaJ = adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
        return recordJS == null ? null : @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(recordJS);
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
    		var criteriaJ = adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
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
    		var criteriaJ = adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
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
    		var criteriaJ = adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
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
         if(retVal == null) {
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

    public Calendar setTitleField(String titleField) {
        return (Calendar)setAttribute("titleField", titleField, true);
    }

    public String getTitleField() {
        return getAttributeAsString("titleField");
    }

    public native DataSource getDataSource() /*-{
        var dataSourceJS = this.@com.smartgwt.client.widgets.grid.ListGrid::getAttributeAsJavaScriptObject(Ljava/lang/String;)("dataSource");
        if ($wnd.isc.isA.String(dataSourceJS)) dataSourceJS = $wnd.isc.DataSource.get(dataSourceJS);
        return @com.smartgwt.client.data.DataSource::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(dataSourceJS);
    }-*/;

    public Calendar setAutoFetchData(Boolean autoFetchData) throws IllegalStateException {
        return (Calendar)setAttribute("autoFetchData", autoFetchData, false);
    }

    public Boolean getAutoFetchData() {
        return getAttributeAsBoolean("autoFetchData");
    }

    public Calendar setAutoFetchTextMatchStyle(TextMatchStyle autoFetchTextMatchStyle) throws IllegalStateException {
        return (Calendar)setAttribute("autoFetchTextMatchStyle", autoFetchTextMatchStyle.getValue(), false);
    }

    public TextMatchStyle getAutoFetchTextMatchStyle() {
        return TextMatchStyle.valueOf(getAttributeAsString("autoFetchTextMatchStyle"));
    }

    public Calendar setAutoFetchAsFilter(Boolean autoFetchAsFilter) throws IllegalStateException {
        return (Calendar)setAttribute("autoFetchAsFilter", autoFetchAsFilter, false);
    }

    public Boolean getAutoFetchAsFilter() {
        return getAttributeAsBoolean("autoFetchAsFilter");
    }

    public Calendar setInitialCriteria(Criteria initialCriteria) throws IllegalStateException {
        return (Calendar)setAttribute("initialCriteria", initialCriteria.getJsObj(), false);
    }

    public Criteria getInitialCriteria() {
        return new Criteria(getAttributeAsJavaScriptObject("initialCriteria"));
    }

    public Calendar setImplicitCriteria(Criteria implicitCriteria) {
        if (implicitCriteria instanceof Criterion) {
            implicitCriteria.setAttribute("_constructor", "AdvancedCriteria");
        }
        return (Calendar)setAttribute("implicitCriteria", implicitCriteria == null ?
                            null : implicitCriteria.getJsObj(), true);
    }

    public Criteria getImplicitCriteria()  {
        return new Criteria(getAttributeAsJavaScriptObject("implicitCriteria"));
    }
    
    public native void fetchData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.fetchData();
    }-*/;

    public native void fetchData(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(criteria)){
    		var criteriaJ = criteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
        self.fetchData(criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()());
    }-*/;

    public native void fetchData(Criteria criteria, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(criteria)){
    		var criteriaJ = criteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
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
    		var criteriaJ = criteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
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
    		var criteriaJ = criteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
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
    		var criteriaJ = criteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
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

    public void exportData() {
        exportData(null);
    }

    public native void exportData(DSRequest requestProperties) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "exportData", "DSRequest,RPCCallback");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.exportData(requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;


    public native void exportData(DSRequest requestProperties, RPCCallback callback) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "exportData", "DSRequest,RPCCallback");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.exportData(requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()(),
			$entry( function(response, rawData, request) {
				if(callback!=null) callback.@com.smartgwt.client.rpc.RPCCallback::execute(Lcom/smartgwt/client/rpc/RPCResponse;Ljava/lang/Object;Lcom/smartgwt/client/rpc/RPCRequest;)(
					@com.smartgwt.client.rpc.RPCResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(response), 
					rawData, 
					@com.smartgwt.client.rpc.RPCRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(request)
				);
			}));
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
                    var param = {"_this": this, "criteria" : arguments[0], "requestProperties" : arguments[1]};
                    var event = @com.smartgwt.client.widgets.events.FetchDataEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                }))
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.onFetchData = $debox($entry(function(){
                var param = {"_this": this, "criteria" : arguments[0], "requestProperties" : arguments[1]};
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
                    var param = {"_this": this, "transferredRecords" : arguments[0]};
                    var event = @com.smartgwt.client.widgets.events.DropCompleteEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                }))
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.dropComplete = $debox($entry(function(){
                var param = {"_this": this, "transferredRecords" : arguments[0]};
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
                    var param = {"_this": this};
                    var event = @com.smartgwt.client.widgets.events.DragCompleteEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                }))
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.dragComplete = $debox($entry(function(){
                var param = {"_this": this, "transferredRecords" : arguments[0]};
                var event = @com.smartgwt.client.widgets.events.DragCompleteEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            }));
        }
    }-*/;

    public native Alignment[] getFieldAlignments()/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var alignJS = self.getFieldAlignments();
        return @com.smartgwt.client.util.ConvertTo::arrayOfAlignment(Lcom/google/gwt/core/client/JavaScriptObject;)(alignJS);
    }-*/;

    public Boolean getDeepCloneOnEdit() {
        return getAttributeAsBoolean("deepCloneOnEdit");
    }

    public Calendar setDeepCloneOnEdit(Boolean deepCloneOnEdit) {
        return (Calendar)setAttribute("deepCloneOnEdit", deepCloneOnEdit, true);
    }

    public Calendar setFields(JavaScriptObject... fields) {
        if (fields != null) for(int i = 0; i < fields.length; i++) {
            fields[i] = duplicateFieldConfig(JSOHelper.cleanProperties(fields[i], false));
        }
        return (Calendar)setAttribute("fields", fields, true);
    }

    private native JavaScriptObject duplicateFieldConfig(JavaScriptObject config) /*-{
        return $wnd.isc.shallowClone(config);
    }-*/;

    public JavaScriptObject[] getFieldsAsJavaScriptObjects() {
        JavaScriptObject fieldsJsArray = getAttributeAsJavaScriptObject("fields");
        return JSOHelper.isArray(fieldsJsArray) ? JSOHelper.toArray(fieldsJsArray) : null;
    }

    public int getFieldCount() {
        JavaScriptObject[] fields = getFieldsAsJavaScriptObjects();
        return fields != null ? fields.length : 0;
    }
    
    public native void transferRecords(Record[] records, Record targetRecord, Integer index, Canvas sourceWidget, TransferRecordsCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        var targetRecordJS = targetRecord == null ? null : targetRecord.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        var indexJS = index == null ? null : index.@java.lang.Integer::intValue()();
        var sourceWidgetJS = sourceWidget == null ? null : sourceWidget.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.transferRecords(recordsJS, targetRecordJS, indexJS, sourceWidgetJS, $entry(function(records) {
            if(callback != null) {
	    		var convertedArray = [];
	    		for (var i = 0; i < records.length; i++) {
	    			convertedArray[i] =  @com.smartgwt.client.data.Record::new(Lcom/google/gwt/core/client/JavaScriptObject;)(records[i]);
	    		}
                var recordsJ = @com.smartgwt.client.util.JSOHelper::convertToJavaObjectArray(Lcom/google/gwt/core/client/JavaScriptObject;)(convertedArray);
                callback.@com.smartgwt.client.widgets.TransferRecordsCallback::execute([Lcom/smartgwt/client/data/Record;)(recordsJ);
            }
        }));
    }-*/;

	/**
     * During a drag-and-drop interaction, this method returns the set of records being dragged
     * out of the component.  In the default implementation, this is the list of currently
     * selected records.<p>
     * This method is consulted by
     * {@link com.smartgwt.client.widgets.grid.ListGrid#willAcceptDrop willAcceptDrop()}.
     * @param DragDataCustomizer customizer
     * @return {@link com.smartgwt.client.widgets.DataBoundComponent DataBoundComponent}
     * instance, for chaining setter calls
     */
    public native Calendar setDragDataCustomizer(DragDataCustomizer customizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        var componentJ = this;
        self.getDragData = $debox($entry(function() {
        	var returnJ = customizer.@com.smartgwt.client.widgets.DragDataCustomizer::getDragData(Lcom/smartgwt/client/widgets/DataBoundComponent;)(componentJ);
        	return @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(returnJ);
    	}));
        return this;
    }-*/;

    public native SortSpecifier[] getSort() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSort", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        if(self == null) return null
        var ret = self.getSort();
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfSortSpecifier(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
    
    public native Calendar setSort(SortSpecifier... sortSpecifiers) /*-{
        var sortSpecifiersJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(sortSpecifiers);
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setSort(sortSpecifiersJS);
        return this;
    }-*/;


    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
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
            s.alwaysShowEventHovers = getAttributeAsString("alwaysShowEventHovers");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.alwaysShowEventHovers:" + t.getMessage() + "\n";
        }
        try {
            s.backButtonTitle = getAttributeAsString("backButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.backButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.baseStyle = getAttributeAsString("baseStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.baseStyle:" + t.getMessage() + "\n";
        }
        try {
            s.bringEventsToFront = getAttributeAsString("bringEventsToFront");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.bringEventsToFront:" + t.getMessage() + "\n";
        }
        try {
            s.calMonthEventLinkStyle = getAttributeAsString("calMonthEventLinkStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.calMonthEventLinkStyle:" + t.getMessage() + "\n";
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
            s.canDragCreateEvents = getAttributeAsString("canDragCreateEvents");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.canDragCreateEvents:" + t.getMessage() + "\n";
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
            s.canSelectEvents = getAttributeAsString("canSelectEvents");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.canSelectEvents:" + t.getMessage() + "\n";
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
            s.data = getData();
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
            s.minimalUI = getAttributeAsString("minimalUI");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.minimalUI:" + t.getMessage() + "\n";
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
            s.minutesPerRow = getAttributeAsString("minutesPerRow");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.minutesPerRow:" + t.getMessage() + "\n";
        }
        try {
            s.monthButtonTitle = getAttributeAsString("monthButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.monthButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.monthMoreEventsLinkTitle = getAttributeAsString("monthMoreEventsLinkTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.monthMoreEventsLinkTitle:" + t.getMessage() + "\n";
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
            s.removeButtonTitle = getAttributeAsString("removeButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.removeButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.renderEventsOnDemand = getAttributeAsString("renderEventsOnDemand");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.renderEventsOnDemand:" + t.getMessage() + "\n";
        }
        try {
            s.rowHeight = getAttributeAsString("rowHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.rowHeight:" + t.getMessage() + "\n";
        }
        try {
            s.rowTitleFrequency = getAttributeAsString("rowTitleFrequency");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.rowTitleFrequency:" + t.getMessage() + "\n";
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
            s.selectChosenDate = getAttributeAsString("selectChosenDate");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.selectChosenDate:" + t.getMessage() + "\n";
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
            s.showCellHovers = getAttributeAsString("showCellHovers");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showCellHovers:" + t.getMessage() + "\n";
        }
        try {
            s.showColumnLayouts = getAttributeAsString("showColumnLayouts");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showColumnLayouts:" + t.getMessage() + "\n";
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
            s.showDayView = getAttributeAsString("showDayView");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showDayView:" + t.getMessage() + "\n";
        }
        try {
            s.showDetailFields = getAttributeAsString("showDetailFields");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showDetailFields:" + t.getMessage() + "\n";
        }
        try {
            s.showDragHovers = getAttributeAsString("showDragHovers");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showDragHovers:" + t.getMessage() + "\n";
        }
        try {
            s.showEventCanvasComponents = getAttributeAsString("showEventCanvasComponents");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showEventCanvasComponents:" + t.getMessage() + "\n";
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
            s.showEventHovers = getAttributeAsString("showEventHovers");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showEventHovers:" + t.getMessage() + "\n";
        }
        try {
            s.showHeaderHovers = getAttributeAsString("showHeaderHovers");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showHeaderHovers:" + t.getMessage() + "\n";
        }
        try {
            s.showIndicators = getAttributeAsString("showIndicators");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showIndicators:" + t.getMessage() + "\n";
        }
        try {
            s.showIndicatorsInFront = getAttributeAsString("showIndicatorsInFront");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showIndicatorsInFront:" + t.getMessage() + "\n";
        }
        try {
            s.showLabelColumn = getAttributeAsString("showLabelColumn");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showLabelColumn:" + t.getMessage() + "\n";
        }
        try {
            s.showLaneFieldHovers = getAttributeAsString("showLaneFieldHovers");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showLaneFieldHovers:" + t.getMessage() + "\n";
        }
        try {
            s.showLaneRollOver = getAttributeAsString("showLaneRollOver");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showLaneRollOver:" + t.getMessage() + "\n";
        }
        try {
            s.showMonthButton = getAttributeAsString("showMonthButton");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showMonthButton:" + t.getMessage() + "\n";
        }
        try {
            s.showMonthView = getAttributeAsString("showMonthView");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showMonthView:" + t.getMessage() + "\n";
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
            s.showViewHovers = getAttributeAsString("showViewHovers");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showViewHovers:" + t.getMessage() + "\n";
        }
        try {
            s.showWeekends = getAttributeAsString("showWeekends");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showWeekends:" + t.getMessage() + "\n";
        }
        try {
            s.showWeekView = getAttributeAsString("showWeekView");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showWeekView:" + t.getMessage() + "\n";
        }
        try {
            s.showWorkday = getAttributeAsString("showWorkday");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showWorkday:" + t.getMessage() + "\n";
        }
        try {
            s.showZoneHovers = getAttributeAsString("showZoneHovers");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.showZoneHovers:" + t.getMessage() + "\n";
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
            s.twentyFourHourTime = getAttributeAsString("twentyFourHourTime");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.twentyFourHourTime:" + t.getMessage() + "\n";
        }
        try {
            s.useEventCanvasRolloverControls = getAttributeAsString("useEventCanvasRolloverControls");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.useEventCanvasRolloverControls:" + t.getMessage() + "\n";
        }
        try {
            s.useSublanes = getAttributeAsString("useSublanes");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.useSublanes:" + t.getMessage() + "\n";
        }
        try {
            s.weekendDays = getAttributeAsStringArray("weekendDays");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.weekendDaysArray:" + t.getMessage() + "\n";
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
            s.workdays = getAttributeAsString("workdays");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.workdays:" + t.getMessage() + "\n";
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
        try {
            s.zoneTitleOrientation = getAttributeAsString("zoneTitleOrientation");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Calendar.zoneTitleOrientation:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        CalendarLogicalStructure s = new CalendarLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
