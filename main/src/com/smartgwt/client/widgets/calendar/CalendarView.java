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
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        $wnd.isc.CalendarView.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
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
        $wnd.isc.CalendarView.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
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
     * @return Calendar
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Calendar getCalendar() throws IllegalStateException {
        errorIfNotCreated("calendar");
        return (Calendar)Calendar.getByJSObject(getAttributeAsJavaScriptObject("calendar"));
    }
    

    /**
     * If specified, overrides {@link com.smartgwt.client.widgets.calendar.Calendar#getEventStyleName eventStyleName} and
     * dictates the CSS style to  use for events rendered in this view.  Has no effect on events that already have a  {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getStyleName style specified}.
     *
     * @param eventStyleName  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setEventStyleName(String eventStyleName) {
        setAttribute("eventStyleName", eventStyleName, true);
    }

    /**
     * If specified, overrides {@link com.smartgwt.client.widgets.calendar.Calendar#getEventStyleName eventStyleName} and
     * dictates the CSS style to  use for events rendered in this view.  Has no effect on events that already have a  {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getStyleName style specified}.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getEventStyleName()  {
        return getAttributeAsString("eventStyleName");
    }
    

    /**
     * Should {@link com.smartgwt.client.widgets.calendar.EventCanvas event canvas} instances be reused when visible events
     * change?
     *
     * @param useEventCanvasPool  Default value is true
     */
    public void setUseEventCanvasPool(Boolean useEventCanvasPool) {
        setAttribute("useEventCanvasPool", useEventCanvasPool, true);
    }

    /**
     * Should {@link com.smartgwt.client.widgets.calendar.EventCanvas event canvas} instances be reused when visible events
     * change?
     *
     * @return Boolean
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
     * @return String
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
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.isDayView();
        return ret;
    }-*/;

	/**
     * Returns true if this is the {@link com.smartgwt.client.widgets.calendar.Calendar#getMonthView month view}, false
     * otherwise.
     *
     * @return true if this is a Month view
     */
    public native boolean isMonthView() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.isMonthView();
        return ret;
    }-*/;

	/**
     * Returns true if this view is the currently selected view in the parent calendar.
     *
     * @return true if the view is selected in the parent calendar, false otherwise
     */
    public native Boolean isSelectedView() /*-{
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
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.isTimelineView();
        return ret;
    }-*/;

	/**
     * Returns true if this is the {@link com.smartgwt.client.widgets.calendar.Calendar#getWeekView week view}, false
     * otherwise.
     *
     * @return true if this is a Week view
     */
    public native boolean isWeekView() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.isWeekView();
        return ret;
    }-*/;

	/**
     * Rebuild this CalendarView, including a data refresh.
     */
    public native void rebuild() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.rebuild();
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
     */
    public static native void setDefaultProperties(CalendarView calendarViewProperties) /*-{
    	var properties = $wnd.isc.addProperties({},calendarViewProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
        $wnd.isc.CalendarView.addProperties(properties);
    }-*/;

    // ***********************************************************

    public LogicalStructureObject setLogicalStructure(CalendarViewLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.calendar = getCalendar();
        } catch (Throwable t) {
            s.logicalStructureErrors += "CalendarView.calendar:" + t.getMessage() + "\n";
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

    public LogicalStructureObject getLogicalStructure() {
        CalendarViewLogicalStructure s = new CalendarViewLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

