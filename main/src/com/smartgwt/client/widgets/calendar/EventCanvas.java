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
 * The EventCanvas component is a lightweight {@link com.smartgwt.client.widgets.layout.VLayout layout} subclass for 
 * displaying a {@link com.smartgwt.client.widgets.calendar.CalendarEvent} in a {@link
 * com.smartgwt.client.widgets.calendar.CalendarView}. <P> Each instance can be {@link
 * com.smartgwt.client.widgets.calendar.CalendarEvent#getStyleName styled}, and can render a single area, or separate
 * {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowHeader header} and {@link
 * com.smartgwt.client.widgets.calendar.EventCanvas#getShowBody body} areas, for the look of a Window. <P> The component's
 * close and context buttons, and any necessary resizers, are shown on {@link
 * com.smartgwt.client.widgets.calendar.EventCanvas#getShowRolloverControls rollover}.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("EventCanvas")
public class EventCanvas extends VLayout {

    public static EventCanvas getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new EventCanvas(jsObj);
        } else {
            assert refInstance instanceof EventCanvas;
            return (EventCanvas)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(EventCanvas.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.EventCanvas.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(EventCanvas.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.EventCanvas.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public EventCanvas(){
        scClassName = "EventCanvas";
    }

    public EventCanvas(JavaScriptObject jsObj){
        scClassName = "EventCanvas";
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
     * CSS class for the {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowBody body area} of the EventCanvas. If
     * unset, defaults to the {@link com.smartgwt.client.widgets.calendar.EventCanvas#getStyleName base styleName} with the
     * suffix "Body".
     *
     * @param bodyStyle New bodyStyle value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.EventCanvas EventCanvas} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public EventCanvas setBodyStyle(String bodyStyle) {
        return (EventCanvas)setAttribute("bodyStyle", bodyStyle, true);
    }

    /**
     * CSS class for the {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowBody body area} of the EventCanvas. If
     * unset, defaults to the {@link com.smartgwt.client.widgets.calendar.EventCanvas#getStyleName base styleName} with the
     * suffix "Body".
     *
     * @return Current bodyStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getBodyStyle()  {
        return getAttributeAsString("bodyStyle");
    }
    

    /**
     * The {@link com.smartgwt.client.widgets.calendar.Calendar} in which this EventCanvas is being rendered.
     *
     * @param calendar New calendar value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.EventCanvas EventCanvas} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public EventCanvas setCalendar(Calendar calendar)  throws IllegalStateException {
        return (EventCanvas)setAttribute("calendar", calendar == null ? null : calendar.getOrCreateJsObj(), false);
    }

    /**
     * The {@link com.smartgwt.client.widgets.calendar.Calendar} in which this EventCanvas is being rendered.
     *
     * @return Current calendar value. Default value is null
     */
    public Calendar getCalendar()  {
        return (Calendar)Calendar.getByJSObject(getAttributeAsJavaScriptObject("calendar"));
    }
    

    /**
     * The {@link com.smartgwt.client.widgets.calendar.CalendarView} in which this EventCanvas is being rendered.
     *
     * @param calendarView New calendarView value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.EventCanvas EventCanvas} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public EventCanvas setCalendarView(CalendarView calendarView)  throws IllegalStateException {
        return (EventCanvas)setAttribute("calendarView", calendarView == null ? null : calendarView.getOrCreateJsObj(), false);
    }

    /**
     * The {@link com.smartgwt.client.widgets.calendar.CalendarView} in which this EventCanvas is being rendered.
     *
     * @return Current calendarView value. Default value is null
     */
    public CalendarView getCalendarView()  {
        return (CalendarView)CalendarView.getByJSObject(getAttributeAsJavaScriptObject("calendarView"));
    }
    

    /**
     * The {@link com.smartgwt.client.widgets.calendar.CalendarEvent event} associated with this EventCanvas.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Assigns a new {@link com.smartgwt.client.widgets.calendar.CalendarEvent event} to this EventCanvas, including updates to  drag, style and {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowRolloverControls rollover} properties.
     *
     * @param event the new event to apply to this EventCanvas. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.EventCanvas EventCanvas} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public EventCanvas setEvent(CalendarEvent event)  throws IllegalStateException {
        return (EventCanvas)setAttribute("event", event == null ? null : event.getJsObj(), false);
    }

    /**
     * The {@link com.smartgwt.client.widgets.calendar.CalendarEvent event} associated with this EventCanvas.
     *
     * @return Current event value. Default value is null
     */
    public CalendarEvent getEvent()  {
        return CalendarEvent.getOrCreateRef(getAttributeAsJavaScriptObject("event"));
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowGripper showGripper} is true, this is the component
     * that will be rendered adjacent to the canvas and allow the canvas to be moved with the mouse.
     * <p>
     * This component is an AutoChild named "gripper".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current gripper value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Img getGripper() throws IllegalStateException {
        errorIfNotCreated("gripper");
        return (Img)Img.getByJSObject(getAttributeAsJavaScriptObject("gripper"));
    }
    

    /**
     * The source for the icon displayed as the "gripper" that snaps to the top of an event  canvas and allows an event to be
     * dragged with the mouse.
     *
     * @param gripperIcon New gripperIcon value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.EventCanvas EventCanvas} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public EventCanvas setGripperIcon(String gripperIcon) {
        return (EventCanvas)setAttribute("gripperIcon", gripperIcon, true);
    }

    /**
     * The source for the icon displayed as the "gripper" that snaps to the top of an event  canvas and allows an event to be
     * dragged with the mouse.
     *
     * @return Current gripperIcon value. Default value is null
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getGripperIcon()  {
        return getAttributeAsString("gripperIcon");
    }
    

    /**
     * The height for the {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowHeader header area}, when  {@link
     * com.smartgwt.client.widgets.calendar.EventCanvas#getHeaderWrap headerWrap} is false and  {@link
     * com.smartgwt.client.widgets.calendar.EventCanvas#getShowBody showBody} is true.  If <code>showBody</code> is false, the
     * header area fills the canvas.
     *
     * @param headerHeight New headerHeight value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.EventCanvas EventCanvas} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public EventCanvas setHeaderHeight(Integer headerHeight) {
        return (EventCanvas)setAttribute("headerHeight", headerHeight, true);
    }

    /**
     * The height for the {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowHeader header area}, when  {@link
     * com.smartgwt.client.widgets.calendar.EventCanvas#getHeaderWrap headerWrap} is false and  {@link
     * com.smartgwt.client.widgets.calendar.EventCanvas#getShowBody showBody} is true.  If <code>showBody</code> is false, the
     * header area fills the canvas.
     *
     * @return Current headerHeight value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Integer getHeaderHeight()  {
        return getAttributeAsInt("headerHeight");
    }
    

    /**
     * CSS class for the {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowHeader header area} of the EventCanvas.
     * If unset, defaults to the {@link com.smartgwt.client.widgets.calendar.EventCanvas#getStyleName base styleName} with the
     * suffix "Header".
     *
     * @param headerStyle New headerStyle value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.EventCanvas EventCanvas} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public EventCanvas setHeaderStyle(String headerStyle) {
        return (EventCanvas)setAttribute("headerStyle", headerStyle, true);
    }

    /**
     * CSS class for the {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowHeader header area} of the EventCanvas.
     * If unset, defaults to the {@link com.smartgwt.client.widgets.calendar.EventCanvas#getStyleName base styleName} with the
     * suffix "Header".
     *
     * @return Current headerStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getHeaderStyle()  {
        return getAttributeAsString("headerStyle");
    }
    

    /**
     * Whether the {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowHeader header area} should autosize
     * vertically to  display all contents.  If true, the header will wrap to multiple lines.  If false, the header will be
     * sized according to the specified {@link com.smartgwt.client.widgets.calendar.EventCanvas#getHeaderHeight height}, or to
     * the full height of the canvas is {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowBody showBody} is false.
     *
     * @param headerWrap New headerWrap value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.EventCanvas EventCanvas} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public EventCanvas setHeaderWrap(Boolean headerWrap) {
        return (EventCanvas)setAttribute("headerWrap", headerWrap, true);
    }

    /**
     * Whether the {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowHeader header area} should autosize
     * vertically to  display all contents.  If true, the header will wrap to multiple lines.  If false, the header will be
     * sized according to the specified {@link com.smartgwt.client.widgets.calendar.EventCanvas#getHeaderHeight height}, or to
     * the full height of the canvas is {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowBody showBody} is false.
     *
     * @return Current headerWrap value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getHeaderWrap()  {
        return getAttributeAsBoolean("headerWrap");
    }
    

    /**
     * Readonly property dictating whether this is a special {@link com.smartgwt.client.widgets.calendar.IndicatorCanvas} 
     * subclass.
     * <p>
     * <b>Note :</b> This method should be called only after the widget has been rendered.
     *
     * @return Current isIndicatorCanvas value. Default value is false
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public boolean getIsIndicatorCanvas() throws IllegalStateException {
        errorIfNotCreated("isIndicatorCanvas");
        Boolean result = getAttributeAsBoolean("isIndicatorCanvas");
        return result == null ? false : result;
    }
    

    /**
     * Readonly property indicating whether this is a special {@link com.smartgwt.client.widgets.calendar.ZoneCanvas} subclass.
     * <p>
     * <b>Note :</b> This method should be called only after the widget has been rendered.
     *
     * @return Current isZoneCanvas value. Default value is false
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public boolean getIsZoneCanvas() throws IllegalStateException {
        errorIfNotCreated("isZoneCanvas");
        Boolean result = getAttributeAsBoolean("isZoneCanvas");
        return result == null ? false : result;
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowLabel showLabel} is true, this autoChild is  used to
     * display the {@link com.smartgwt.client.widgets.calendar.EventCanvas#getHeaderHTML header text}, adjacent to this
     * eventCanvas.
     * <p>
     * This component is an AutoChild named "label".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current label value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Label getLabel() throws IllegalStateException {
        errorIfNotCreated("label");
        return (Label)Label.getByJSObject(getAttributeAsJavaScriptObject("label"));
    }
    

    /**
     * Renders a body DIV that fills the main area of the canvas, or all of it if no  {@link
     * com.smartgwt.client.widgets.calendar.EventCanvas#getShowHeader header} is shown.  This area typically displays an  
     * {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getDescription event description}.  This area can be styled
     * via  {@link com.smartgwt.client.widgets.calendar.EventCanvas#getBodyStyle bodyStyle} and the HTML it shows is retrieved
     * from a call to {@link com.smartgwt.client.widgets.calendar.EventCanvas#getBodyHTML getBodyHTML()}.  The default is taken
     * from {@link com.smartgwt.client.widgets.calendar.Calendar#getShowEventDescriptions Calendar.showEventDescriptions}.
     *
     * @param showBody New showBody value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.EventCanvas EventCanvas} instance, for chaining setter calls
     */
    public EventCanvas setShowBody(Boolean showBody) {
        return (EventCanvas)setAttribute("showBody", showBody, true);
    }

    /**
     * Renders a body DIV that fills the main area of the canvas, or all of it if no  {@link
     * com.smartgwt.client.widgets.calendar.EventCanvas#getShowHeader header} is shown.  This area typically displays an  
     * {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getDescription event description}.  This area can be styled
     * via  {@link com.smartgwt.client.widgets.calendar.EventCanvas#getBodyStyle bodyStyle} and the HTML it shows is retrieved
     * from a call to {@link com.smartgwt.client.widgets.calendar.EventCanvas#getBodyHTML getBodyHTML()}.  The default is taken
     * from {@link com.smartgwt.client.widgets.calendar.Calendar#getShowEventDescriptions Calendar.showEventDescriptions}.
     *
     * @return Current showBody value. Default value is null
     */
    public Boolean getShowBody()  {
        return getAttributeAsBoolean("showBody");
    }
    

    /**
     * When set to true, shows the {@link com.smartgwt.client.widgets.calendar.EventCanvas#getGripper gripper} component, which
     * snaps, centered, to the top edge of the eventCanvas and can be used to move it with the mouse.
     *
     * @param showGripper New showGripper value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.EventCanvas EventCanvas} instance, for chaining setter calls
     */
    public EventCanvas setShowGripper(Boolean showGripper) {
        return (EventCanvas)setAttribute("showGripper", showGripper, true);
    }

    /**
     * When set to true, shows the {@link com.smartgwt.client.widgets.calendar.EventCanvas#getGripper gripper} component, which
     * snaps, centered, to the top edge of the eventCanvas and can be used to move it with the mouse.
     *
     * @return Current showGripper value. Default value is null
     */
    public Boolean getShowGripper()  {
        return getAttributeAsBoolean("showGripper");
    }
    

    /**
     * Renders a header DIV above the main body of the event, an area of limited height, styled to stand out from the main
     * {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowBody body} of the  event, and typically showing a {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getName name} or title - like a Window. This header area can be
     * styled via {@link com.smartgwt.client.widgets.calendar.EventCanvas#getHeaderStyle headerStyle} and the HTML it shows  is
     * retrieved from a call to {@link com.smartgwt.client.widgets.calendar.EventCanvas#getHeaderHTML getHeaderHTML()}.   The
     * default is taken from {@link com.smartgwt.client.widgets.calendar.Calendar#getShowEventHeaders
     * Calendar.showEventHeaders}.
     *
     * @param showHeader New showHeader value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.EventCanvas EventCanvas} instance, for chaining setter calls
     */
    public EventCanvas setShowHeader(Boolean showHeader) {
        return (EventCanvas)setAttribute("showHeader", showHeader, true);
    }

    /**
     * Renders a header DIV above the main body of the event, an area of limited height, styled to stand out from the main
     * {@link com.smartgwt.client.widgets.calendar.EventCanvas#getShowBody body} of the  event, and typically showing a {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getName name} or title - like a Window. This header area can be
     * styled via {@link com.smartgwt.client.widgets.calendar.EventCanvas#getHeaderStyle headerStyle} and the HTML it shows  is
     * retrieved from a call to {@link com.smartgwt.client.widgets.calendar.EventCanvas#getHeaderHTML getHeaderHTML()}.   The
     * default is taken from {@link com.smartgwt.client.widgets.calendar.Calendar#getShowEventHeaders
     * Calendar.showEventHeaders}.
     *
     * @return Current showHeader value. Default value is null
     */
    public Boolean getShowHeader()  {
        return getAttributeAsBoolean("showHeader");
    }
    

    /**
     * When set to true, the {@link com.smartgwt.client.widgets.calendar.EventCanvas#getHeaderHTML header text} for the
     * associated event is not rendered inside the eventCanvas itself. <P> Instead, it is rendered in it's own {@link
     * com.smartgwt.client.widgets.calendar.EventCanvas#getLabel label} and shown  as a peer of this eventCanvas, immediately
     * outside of it.
     *
     * @param showLabel New showLabel value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.EventCanvas EventCanvas} instance, for chaining setter calls
     */
    public EventCanvas setShowLabel(Boolean showLabel) {
        return (EventCanvas)setAttribute("showLabel", showLabel, true);
    }

    /**
     * When set to true, the {@link com.smartgwt.client.widgets.calendar.EventCanvas#getHeaderHTML header text} for the
     * associated event is not rendered inside the eventCanvas itself. <P> Instead, it is rendered in it's own {@link
     * com.smartgwt.client.widgets.calendar.EventCanvas#getLabel label} and shown  as a peer of this eventCanvas, immediately
     * outside of it.
     *
     * @return Current showLabel value. Default value is null
     */
    public Boolean getShowLabel()  {
        return getAttributeAsBoolean("showLabel");
    }
    

    /**
     * When set to the default value of true, this attribute causes a set of components to be shown when the mouse rolls over
     * this EventCanvas.  These components include the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventCanvasCloseButton close} and  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventCanvasContextButton context} buttons, the latter's  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventCanvasContextMenu context menu} and the images used for 
     * drag-resizing. <P> Using rollover controls is more efficient that showing static buttons in each  eventCanvas, so this
     * is the default behavior.  See  {@link com.smartgwt.client.widgets.calendar.Calendar#getUseEventCanvasRolloverControls
     * Calendar.useEventCanvasRolloverControls} for the alternative.
     *
     * @param showRolloverControls New showRolloverControls value. Default value is true
     * @return {@link com.smartgwt.client.widgets.calendar.EventCanvas EventCanvas} instance, for chaining setter calls
     */
    public EventCanvas setShowRolloverControls(Boolean showRolloverControls) {
        return (EventCanvas)setAttribute("showRolloverControls", showRolloverControls, true);
    }

    /**
     * When set to the default value of true, this attribute causes a set of components to be shown when the mouse rolls over
     * this EventCanvas.  These components include the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventCanvasCloseButton close} and  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventCanvasContextButton context} buttons, the latter's  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventCanvasContextMenu context menu} and the images used for 
     * drag-resizing. <P> Using rollover controls is more efficient that showing static buttons in each  eventCanvas, so this
     * is the default behavior.  See  {@link com.smartgwt.client.widgets.calendar.Calendar#getUseEventCanvasRolloverControls
     * Calendar.useEventCanvasRolloverControls} for the alternative.
     *
     * @return Current showRolloverControls value. Default value is true
     */
    public Boolean getShowRolloverControls()  {
        Boolean result = getAttributeAsBoolean("showRolloverControls");
        return result == null ? true : result;
    }
    

    /**
     * The CSS class for this EventCanvas.  Defaults to the style on  {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getStyleName eventCanvas.event}, if specified, or on the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventStyleName calendar} otherwise. <P> Also see {@link
     * com.smartgwt.client.widgets.calendar.EventCanvas#getHeaderStyle headerStyle} and {@link
     * com.smartgwt.client.widgets.calendar.EventCanvas#getBodyStyle bodyStyle}.
     *
     * @param styleName New styleName value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setStyleName(String styleName) {
        setAttribute("styleName", styleName, true);
    }

    /**
     * The CSS class for this EventCanvas.  Defaults to the style on  {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getStyleName eventCanvas.event}, if specified, or on the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventStyleName calendar} otherwise. <P> Also see {@link
     * com.smartgwt.client.widgets.calendar.EventCanvas#getHeaderStyle headerStyle} and {@link
     * com.smartgwt.client.widgets.calendar.EventCanvas#getBodyStyle bodyStyle}.
     *
     * @return Current styleName value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getStyleName()  {
        return getAttributeAsString("styleName");
    }
    

    /**
     * Indicates the orientation of the event in its containing view.  Affects drag and resize orientation and which edges of
     * the canvas are available for resizing.
     *
     * @param verticalResize New verticalResize value. Default value is null
     * @return {@link com.smartgwt.client.widgets.calendar.EventCanvas EventCanvas} instance, for chaining setter calls
     */
    public EventCanvas setVerticalResize(Boolean verticalResize) {
        return (EventCanvas)setAttribute("verticalResize", verticalResize, true);
    }

    /**
     * Indicates the orientation of the event in its containing view.  Affects drag and resize orientation and which edges of
     * the canvas are available for resizing.
     *
     * @return Current verticalResize value. Default value is null
     */
    public Boolean getVerticalResize()  {
        return getAttributeAsBoolean("verticalResize");
    }
    

    // ********************* Methods ***********************
	/**
     * Return the HTML to show in the body of this EventCanvas.  The default implementation  calls {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getEventBodyHTML Calendar.getEventBodyHTML()}, which returns the value of
     * the  {@link com.smartgwt.client.widgets.calendar.Calendar#getDescriptionField description field} for the current  {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent event}.
     *
     * @return HTML to display in the body of the canvas.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public native String getBodyHTML() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getBodyHTML", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getBodyHTML();
        return ret;
    }-*/;

	/**
     * Returns the HTML to show in the header of this EventCanvas.  The default implementation  returns the {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getNameField name} of the current  {@link
     * com.smartgwt.client.widgets.calendar.EventCanvas#getEvent event}.
     *
     * @return HTML to display in the header of the canvas.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public native String getHeaderHTML() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getHeaderHTML", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getHeaderHTML();
        return ret;
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
     * @param eventCanvasProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(EventCanvas eventCanvasProperties) /*-{
        if (eventCanvasProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(EventCanvas.@java.lang.Object::getClass()(), "setDefaultProperties", eventCanvasProperties.@java.lang.Object::getClass()());
        }
        eventCanvasProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = eventCanvasProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.EventCanvas.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(EventCanvasLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.bodyStyle = getAttributeAsString("bodyStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EventCanvas.bodyStyle:" + t.getMessage() + "\n";
        }
        try {
            s.calendar = getCalendar();
        } catch (Throwable t) {
            s.logicalStructureErrors += "EventCanvas.calendar:" + t.getMessage() + "\n";
        }
        try {
            s.calendarView = getCalendarView();
        } catch (Throwable t) {
            s.logicalStructureErrors += "EventCanvas.calendarView:" + t.getMessage() + "\n";
        }
        try {
            s.event = getEvent();
        } catch (Throwable t) {
            s.logicalStructureErrors += "EventCanvas.event:" + t.getMessage() + "\n";
        }
        try {
            s.gripperIcon = getAttributeAsString("gripperIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EventCanvas.gripperIcon:" + t.getMessage() + "\n";
        }
        try {
            s.headerHeight = getAttributeAsString("headerHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EventCanvas.headerHeight:" + t.getMessage() + "\n";
        }
        try {
            s.headerStyle = getAttributeAsString("headerStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EventCanvas.headerStyle:" + t.getMessage() + "\n";
        }
        try {
            s.headerWrap = getAttributeAsString("headerWrap");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EventCanvas.headerWrap:" + t.getMessage() + "\n";
        }
        try {
            s.isIndicatorCanvas = getAttributeAsString("isIndicatorCanvas");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EventCanvas.isIndicatorCanvas:" + t.getMessage() + "\n";
        }
        try {
            s.isZoneCanvas = getAttributeAsString("isZoneCanvas");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EventCanvas.isZoneCanvas:" + t.getMessage() + "\n";
        }
        try {
            s.showBody = getAttributeAsString("showBody");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EventCanvas.showBody:" + t.getMessage() + "\n";
        }
        try {
            s.showGripper = getAttributeAsString("showGripper");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EventCanvas.showGripper:" + t.getMessage() + "\n";
        }
        try {
            s.showHeader = getAttributeAsString("showHeader");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EventCanvas.showHeader:" + t.getMessage() + "\n";
        }
        try {
            s.showLabel = getAttributeAsString("showLabel");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EventCanvas.showLabel:" + t.getMessage() + "\n";
        }
        try {
            s.showRolloverControls = getAttributeAsString("showRolloverControls");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EventCanvas.showRolloverControls:" + t.getMessage() + "\n";
        }
        try {
            s.styleName = getAttributeAsString("styleName");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EventCanvas.styleName:" + t.getMessage() + "\n";
        }
        try {
            s.verticalResize = getAttributeAsString("verticalResize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EventCanvas.verticalResize:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        EventCanvasLogicalStructure s = new EventCanvasLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
