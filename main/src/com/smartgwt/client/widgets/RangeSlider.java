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
 
package com.smartgwt.client.widgets;


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
 * A "double slider" allowing the user to select a range via two draggable thumbs.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("RangeSlider")
public class RangeSlider extends Canvas implements com.smartgwt.client.widgets.events.HasRangeChangedEventHandlers {

    public static RangeSlider getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new RangeSlider(jsObj);
        } else {
            assert refInstance instanceof RangeSlider;
            return (RangeSlider)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(RangeSlider.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.RangeSlider.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(RangeSlider.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.RangeSlider.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public RangeSlider(){
        scClassName = "RangeSlider";
    }

    public RangeSlider(JavaScriptObject jsObj){
        scClassName = "RangeSlider";
        setJavaScriptObject(jsObj);
    }

    /**
     * @deprecated
     */
    public RangeSlider(float minValue, float maxValue, float startValue, float endValue) {
        setMinValue(minValue);
		setMaxValue(maxValue);
		setStartValue(startValue);
		setEndValue(endValue);
                scClassName = "RangeSlider";
    }


    public RangeSlider(double minValue, double maxValue, double startValue, double endValue) {
        setMinValue(minValue);
		setMaxValue(maxValue);
		setStartValue(startValue);
		setEndValue(endValue);
                scClassName = "RangeSlider";
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
     * Base style name for CSS styles applied to the background of the rangeSlider.  The following suffixes are applied for
     * different areas of the slider: <ul> <li> "Start": area of the slider before the startThumb <li> "Selected": area of the
     * slider between the thumbs (the selected range) <li> "End": area of the slider after the endThumb </ul> .. and the
     * following suffixes are applied in addition according to the slider's dynamic state: <ul> <li> "Over": if the mouse is
     * over the segment <li> "Down": if the mouse is down on the segment </ul> For example, if the mouse is down in the area
     * before the start thumb, that area will have the CSS style "rangeSliderStartDown".
     *
     * @param baseStyle New baseStyle value. Default value is "rangeSlider"
     * @return {@link com.smartgwt.client.widgets.RangeSlider RangeSlider} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public RangeSlider setBaseStyle(String baseStyle)  throws IllegalStateException {
        return (RangeSlider)setAttribute("baseStyle", baseStyle, false);
    }

    /**
     * Base style name for CSS styles applied to the background of the rangeSlider.  The following suffixes are applied for
     * different areas of the slider: <ul> <li> "Start": area of the slider before the startThumb <li> "Selected": area of the
     * slider between the thumbs (the selected range) <li> "End": area of the slider after the endThumb </ul> .. and the
     * following suffixes are applied in addition according to the slider's dynamic state: <ul> <li> "Over": if the mouse is
     * over the segment <li> "Down": if the mouse is down on the segment </ul> For example, if the mouse is down in the area
     * before the start thumb, that area will have the CSS style "rangeSliderStartDown".
     *
     * @return Current baseStyle value. Default value is "rangeSlider"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getBaseStyle()  {
        return getAttributeAsString("baseStyle");
    }
    

    /**
     * Thumb for the end of the range
     * <p>
     * This component is an AutoChild named "endThumb".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current endThumb value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Snapbar getEndThumb() throws IllegalStateException {
        errorIfNotCreated("endThumb");
        return (Snapbar)Snapbar.getByJSObject(getAttributeAsJavaScriptObject("endThumb"));
    }
    

    /**
     * The end of the selected range.
     *
     * @param endValue New endValue value. Default value is 0
     * @return {@link com.smartgwt.client.widgets.RangeSlider RangeSlider} instance, for chaining setter calls
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public RangeSlider setEndValue(float endValue) {
        return (RangeSlider)setAttribute("endValue", endValue, true);
    }

    /**
     * The end of the selected range.
     *
     * @return Current endValue value. Default value is 0
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public float getEndValue()  {
        return getAttributeAsFloat("endValue");
    }

    /**
     * The end of the selected range.
     *
     * @param endValue New endValue value. Default value is 0
     * @return {@link com.smartgwt.client.widgets.RangeSlider RangeSlider} instance, for chaining setter calls
     */
    public RangeSlider setEndValue(double endValue) {
        return (RangeSlider)setAttribute("endValue", endValue, true);
    }

    /**
     * The end of the selected range.
     *
     * @return Current endValue value. Default value is 0
     */
    public double getEndValueAsDouble()  {
        return getAttributeAsDouble("endValue");
    }
    

    /**
     * Set the maximum value (right/bottom of slider).
     *
     * @param maxValue New maxValue value. Default value is 0
     * @return {@link com.smartgwt.client.widgets.RangeSlider RangeSlider} instance, for chaining setter calls
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public RangeSlider setMaxValue(float maxValue) {
        return (RangeSlider)setAttribute("maxValue", maxValue, true);
    }

    /**
     * Set the maximum value (right/bottom of slider).
     *
     * @return Current maxValue value. Default value is 0
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public float getMaxValue()  {
        return getAttributeAsFloat("maxValue");
    }

    /**
     * Set the maximum value (right/bottom of slider).
     *
     * @param maxValue New maxValue value. Default value is 0
     * @return {@link com.smartgwt.client.widgets.RangeSlider RangeSlider} instance, for chaining setter calls
     */
    public RangeSlider setMaxValue(double maxValue) {
        return (RangeSlider)setAttribute("maxValue", maxValue, true);
    }

    /**
     * Set the maximum value (right/bottom of slider).
     *
     * @return Current maxValue value. Default value is 0
     */
    public double getMaxValueAsDouble()  {
        return getAttributeAsDouble("maxValue");
    }
    

    /**
     * Set the minimum value (left/top of slider).
     *
     * @param minValue New minValue value. Default value is 0
     * @return {@link com.smartgwt.client.widgets.RangeSlider RangeSlider} instance, for chaining setter calls
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public RangeSlider setMinValue(float minValue) {
        return (RangeSlider)setAttribute("minValue", minValue, true);
    }

    /**
     * Set the minimum value (left/top of slider).
     *
     * @return Current minValue value. Default value is 0
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public float getMinValue()  {
        return getAttributeAsFloat("minValue");
    }

    /**
     * Set the minimum value (left/top of slider).
     *
     * @param minValue New minValue value. Default value is 0
     * @return {@link com.smartgwt.client.widgets.RangeSlider RangeSlider} instance, for chaining setter calls
     */
    public RangeSlider setMinValue(double minValue) {
        return (RangeSlider)setAttribute("minValue", minValue, true);
    }

    /**
     * Set the minimum value (left/top of slider).
     *
     * @return Current minValue value. Default value is 0
     */
    public double getMinValueAsDouble()  {
        return getAttributeAsDouble("minValue");
    }
    

    /**
     * Optional Scrollbar shown as a second way of adjusting the range.
     * <p>
     * This component is an AutoChild named "scrollbar".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current scrollbar value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Scrollbar getScrollbar() throws IllegalStateException {
        errorIfNotCreated("scrollbar");
        return (Scrollbar)Scrollbar.getByJSObject(getAttributeAsJavaScriptObject("scrollbar"));
    }
    

    /**
     * Thumb for the start of the range.
     * <p>
     * This component is an AutoChild named "startThumb".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current startThumb value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Snapbar getStartThumb() throws IllegalStateException {
        errorIfNotCreated("startThumb");
        return (Snapbar)Snapbar.getByJSObject(getAttributeAsJavaScriptObject("startThumb"));
    }
    

    /**
     * The beginning of the selected range.
     *
     * @param startValue New startValue value. Default value is 0
     * @return {@link com.smartgwt.client.widgets.RangeSlider RangeSlider} instance, for chaining setter calls
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public RangeSlider setStartValue(float startValue) {
        return (RangeSlider)setAttribute("startValue", startValue, true);
    }

    /**
     * The beginning of the selected range.
     *
     * @return Current startValue value. Default value is 0
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public float getStartValue()  {
        return getAttributeAsFloat("startValue");
    }

    /**
     * The beginning of the selected range.
     *
     * @param startValue New startValue value. Default value is 0
     * @return {@link com.smartgwt.client.widgets.RangeSlider RangeSlider} instance, for chaining setter calls
     */
    public RangeSlider setStartValue(double startValue) {
        return (RangeSlider)setAttribute("startValue", startValue, true);
    }

    /**
     * The beginning of the selected range.
     *
     * @return Current startValue value. Default value is 0
     */
    public double getStartValueAsDouble()  {
        return getAttributeAsDouble("startValue");
    }
    

    /**
     * Optional track of the RangeSlider.  Set <code>showTrack</code> false to avoid showing a track so the RangeSlider can be
     * superimposed over something else.
     * <p>
     * This component is an AutoChild named "track".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current track value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Canvas getTrack() throws IllegalStateException {
        errorIfNotCreated("track");
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("track"));
    }
    

    /**
     * Whether the rangeSlider should be vertical or horizontal.  Default is horizontal.
     *
     * @param vertical New vertical value. Default value is false
     * @return {@link com.smartgwt.client.widgets.RangeSlider RangeSlider} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public RangeSlider setVertical(boolean vertical)  throws IllegalStateException {
        return (RangeSlider)setAttribute("vertical", vertical, false);
    }

    /**
     * Whether the rangeSlider should be vertical or horizontal.  Default is horizontal.
     *
     * @return Current vertical value. Default value is false
     */
    public boolean getVertical()  {
        Boolean result = getAttributeAsBoolean("vertical");
        return result == null ? false : result;
    }
    

    // ********************* Methods ***********************
    /**
     * Add a RangeChangedEvent handler.
     * <p>
     * Notification fired when the selected range is changed by the end user.
     *
     * @param handler the RangeChangedEvent handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addRangeChangedEventHandler(com.smartgwt.client.widgets.events.RangeChangedEventHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.events.ChangedEvent.getType()) == 0) setupRangeChangedEventEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.events.ChangedEvent.getType());
    }

    private native void setupRangeChangedEventEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var changed = $entry(function(){
            var param = {"_this": this, "startValue" : arguments[0], "endValue" : arguments[1], "isDragging" : arguments[2]};
            var event = @com.smartgwt.client.widgets.events.ChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.RangeSlider::handleTearDownRangeChangedEventEvent()();
            if (hasDefaultHandler) this.Super("changed", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("changed"));
            obj.addProperties({changed:  changed              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("changed"));
            obj.changed =  changed             ;
        }
    }-*/;

    private void handleTearDownRangeChangedEventEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.events.ChangedEvent.getType()) == 0) tearDownRangeChangedEventEvent();
    }

    private native void tearDownRangeChangedEventEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("changed")) delete obj.changed;
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
     * @param rangeSliderProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(RangeSlider rangeSliderProperties) /*-{
        if (rangeSliderProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(RangeSlider.@java.lang.Object::getClass()(), "setDefaultProperties", rangeSliderProperties.@java.lang.Object::getClass()());
        }
        rangeSliderProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = rangeSliderProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.RangeSlider.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(RangeSliderLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.baseStyle = getAttributeAsString("baseStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RangeSlider.baseStyle:" + t.getMessage() + "\n";
        }
        try {
            s.vertical = getAttributeAsString("vertical");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RangeSlider.vertical:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        RangeSliderLogicalStructure s = new RangeSliderLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
