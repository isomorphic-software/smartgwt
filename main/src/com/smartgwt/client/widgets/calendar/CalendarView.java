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
import com.smartgwt.client.browser.window.*;
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
import com.smartgwt.client.widgets.tour.*;
import com.smartgwt.client.widgets.notify.*;
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
import com.smartgwt.client.widgets.notify.*;
import com.smartgwt.client.widgets.drawing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
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
import com.smartgwt.client.util.tour.*;

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
import com.smartgwt.logicalstructure.widgets.tour.*;

/**
 * CalendarView is a base class, extended by the various views available in a  {@link
 * com.smartgwt.client.widgets.calendar.Calendar Calendar}.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("CalendarView")
public class CalendarView extends ListGrid {

    public static CalendarView getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new CalendarView(jsObj);
        } else {
            assert refInstance instanceof CalendarView;
            return (CalendarView)refInstance;
        }
    }

    private static final CalendarView TEST_INSTANCE = new CalendarView();
    static {
        TEST_INSTANCE.setID("isc_CalendarView_testInstance");
    }

    @Override
    protected CalendarView getTestInstance() {
        return TEST_INSTANCE;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(CalendarView.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.CalendarView.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(CalendarView.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.CalendarView.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public CalendarView(){
        scClassName = "CalendarView";
    }

    public CalendarView(JavaScriptObject jsObj){
        scClassName = "CalendarView";
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
     * The {@link com.smartgwt.client.widgets.calendar.Calendar calendar} this view is in.
     * <p>
     * <b>Note :</b> This method should be called only after the widget has been rendered.
     *
     * @return Current calendar value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Calendar getCalendar() throws IllegalStateException {
        errorIfNotCreated("calendar");
        return (Calendar)Calendar.getByJSObject(getAttributeAsJavaScriptObject("calendar"));
    }
    

    /**
     * {@link com.smartgwt.client.widgets.Canvas} displayed while dragging or resizing an event in this view and styled
     * according to {@link com.smartgwt.client.widgets.calendar.CalendarView#getEventDragCanvasStyleName
     * eventDragCanvasStyleName}.
     * <p>
     * This component is an AutoChild named "eventDragCanvas".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current eventDragCanvas value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Canvas getEventDragCanvas() throws IllegalStateException {
        errorIfNotCreated("eventDragCanvas");
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("eventDragCanvas"));
    }
    

    /**
     * CSS class applied to the {@link com.smartgwt.client.widgets.calendar.CalendarView#getEventDragCanvas eventDragCanvas}.
     *
     * @param eventDragCanvasStyleName New eventDragCanvasStyleName value. Default value is "eventDragCanvas"
     * @return {@link com.smartgwt.client.widgets.calendar.CalendarView CalendarView} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public CalendarView setEventDragCanvasStyleName(String eventDragCanvasStyleName)  throws IllegalStateException {
        return (CalendarView)setAttribute("eventDragCanvasStyleName", eventDragCanvasStyleName, false);
    }

    /**
     * CSS class applied to the {@link com.smartgwt.client.widgets.calendar.CalendarView#getEventDragCanvas eventDragCanvas}.
     *
     * @return Current eventDragCanvasStyleName value. Default value is "eventDragCanvas"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getEventDragCanvasStyleName()  {
        return getAttributeAsString("eventDragCanvasStyleName");
    }
    

    /**
     * If specified, overrides {@link com.smartgwt.client.widgets.calendar.Calendar#getEventStyleName Calendar.eventStyleName}
     * and dictates the CSS style to  use for events rendered in this view.  Has no effect on events that already have a 
     * {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getStyleName style specified}.
     *
     * @param eventStyleName New eventStyleName value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.CalendarView CalendarView} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public CalendarView setEventStyleName(String eventStyleName) {
        return (CalendarView)setAttribute("eventStyleName", eventStyleName, true);
    }

    /**
     * If specified, overrides {@link com.smartgwt.client.widgets.calendar.Calendar#getEventStyleName Calendar.eventStyleName}
     * and dictates the CSS style to  use for events rendered in this view.  Has no effect on events that already have a 
     * {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getStyleName style specified}.
     *
     * @return Current eventStyleName value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getEventStyleName()  {
        return getAttributeAsString("eventStyleName");
    }
    

    /**
     * Should {@link com.smartgwt.client.widgets.calendar.EventCanvas event canvas} instances be reused when visible events
     * change?
     *
     * @param useEventCanvasPool New useEventCanvasPool value. Default value is true
     * @return {@link com.smartgwt.client.widgets.calendar.CalendarView CalendarView} instance, for chaining setter calls
     */
    public CalendarView setUseEventCanvasPool(Boolean useEventCanvasPool) {
        return (CalendarView)setAttribute("useEventCanvasPool", useEventCanvasPool, true);
    }

    /**
     * Should {@link com.smartgwt.client.widgets.calendar.EventCanvas event canvas} instances be reused when visible events
     * change?
     *
     * @return Current useEventCanvasPool value. Default value is true
     */
    public Boolean getUseEventCanvasPool()  {
        Boolean result = getAttributeAsBoolean("useEventCanvasPool");
        return result == null ? true : result;
    }
    

    /**
     * The name of this view, used to identify it in the {@link com.smartgwt.client.widgets.calendar.CalendarView#getCalendar
     * calendar}.
     * <p>
     * <b>Note :</b> This method should be called only after the widget has been rendered.
     *
     * @return Current viewName value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public String getViewName() throws IllegalStateException {
        errorIfNotCreated("viewName");
        return getAttributeAsString("viewName");
    }
    

    // ********************* Methods ***********************
	/**
     * Returns true if this is the {@link com.smartgwt.client.widgets.calendar.Calendar#getDayView day view}, false otherwise.
     *
     * @return true if this is a Day view
     */
    public native boolean isDayView() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "isDayView", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.isDayView();
        return ret == null ? false : ret;
    }-*/;

	/**
     * Returns true if this is the {@link com.smartgwt.client.widgets.calendar.Calendar#getMonthView month view}, false
     * otherwise.
     *
     * @return true if this is a Month view
     */
    public native boolean isMonthView() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "isMonthView", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.isMonthView();
        return ret == null ? false : ret;
    }-*/;

	/**
     * Returns true if this view is the currently selected view in the parent calendar.
     *
     * @return true if the view is selected in the parent calendar, false otherwise
     */
    public native Boolean isSelectedView() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "isSelectedView", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.isSelectedView();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Returns true if this is the {@link com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timeline view}, false
     * otherwise.
     *
     * @return true if this is a Timeline view
     */
    public native boolean isTimelineView() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "isTimelineView", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.isTimelineView();
        return ret == null ? false : ret;
    }-*/;

	/**
     * Returns true if this is the {@link com.smartgwt.client.widgets.calendar.Calendar#getWeekView week view}, false
     * otherwise.
     *
     * @return true if this is a Week view
     */
    public native boolean isWeekView() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "isWeekView", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.isWeekView();
        return ret == null ? false : ret;
    }-*/;

	/**
     * Rebuild this CalendarView, including re-fetching its data as necessary.  To avoid  re-fetching the data, pass 'false' to
     * this method, or call  +link{calendarView.refreshEvents, refreshEvents()) instead.
     */
    public native void rebuild() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "rebuild", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.rebuild();
    }-*/;

	/**
     * Rebuild this CalendarView, including re-fetching its data as necessary.  To avoid  re-fetching the data, pass 'false' to
     * this method, or call  +link{calendarView.refreshEvents, refreshEvents()) instead.
     * @param refreshData If false, prevents data from bing refreshed.
     */
    public native void rebuild(Boolean refreshData) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "rebuild", "Boolean");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.rebuild(refreshData == null ? null : refreshData.@java.lang.Boolean::booleanValue()());
    }-*/;
	
	/**
     * Clear, recalculate and redraw the events for the current range, without causing a fetch.
     */
    public native void refreshEvents() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "refreshEvents", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.refreshEvents();
    }-*/;

	/**
     * Move the viewport of this CalendarView to the end of its scrollable range.
     */
    public native void scrollToEnd() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "scrollToEnd", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.scrollToEnd();
    }-*/;

	/**
     * Move the viewport of this CalendarView to the start of its scrollable range.
     */
    public native void scrollToStart() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "scrollToStart", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.scrollToStart();
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
     * @param calendarViewProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(CalendarView calendarViewProperties) /*-{
        if (calendarViewProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(CalendarView.@java.lang.Object::getClass()(), "setDefaultProperties", calendarViewProperties.@java.lang.Object::getClass()());
        }
        calendarViewProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = calendarViewProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.CalendarView.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(CalendarViewLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.calendar = getCalendar();
        } catch (Throwable t) {
            s.logicalStructureErrors += "CalendarView.calendar:" + t.getMessage() + "\n";
        }
        try {
            s.eventDragCanvasStyleName = getAttributeAsString("eventDragCanvasStyleName");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CalendarView.eventDragCanvasStyleName:" + t.getMessage() + "\n";
        }
        try {
            s.eventStyleName = getAttributeAsString("eventStyleName");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CalendarView.eventStyleName:" + t.getMessage() + "\n";
        }
        try {
            s.useEventCanvasPool = getAttributeAsString("useEventCanvasPool");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CalendarView.useEventCanvasPool:" + t.getMessage() + "\n";
        }
        try {
            s.viewName = getAttributeAsString("viewName");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CalendarView.viewName:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        CalendarViewLogicalStructure s = new CalendarViewLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
