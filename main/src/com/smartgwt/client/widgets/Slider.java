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
 * The Slider class implements a GUI slider widget allowing the user to select a numeric   value from within a range by
 * dragging a visual indicator up and down a track. <p>  The slider will generate events as the user interacts with it and
 * changes its value.  If slider.sliderTarget is specified, moving the slider thumb generates a custom event named
 * 'sliderMove', sent to the sliderTarget.  If a <code>sliderMove</code> handler stringMethod is defined on the target, it
 * will be   fired when the slider is moved. The second parameter (available via the variable name  <code>eventInfo</code>
 * if the handler is a string) is a pointer back to the slider.  <p>  The slider will also fire a
 * <code>valueChanged()</code> method whenever its value is   changed.  This can be observed or overridden on the Slider
 * instance to perform some action.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("Slider")
public class Slider extends Canvas implements com.smartgwt.client.widgets.events.HasValueChangedHandlers {

    public static Slider getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new Slider(jsObj);
        } else {
            assert refInstance instanceof Slider;
            return (Slider)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(Slider.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.Slider.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(Slider.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.Slider.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public Slider(){
        scClassName = "Slider";
    }

    public Slider(JavaScriptObject jsObj){
        scClassName = "Slider";
        setJavaScriptObject(jsObj);
    }


    public Slider(String title) {
        setTitle(title);
                scClassName = "Slider";
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
     * Optional CSS style for the part of the track between it's minimum and current values. <P> Will have the suffix
     * "Disabled" added when the slider is disabled.
     *
     * @param activeTrackStyle New activeTrackStyle value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setActiveTrackStyle(String activeTrackStyle)  throws IllegalStateException {
        setAttribute("activeTrackStyle", activeTrackStyle, false);
    }

    /**
     * Optional CSS style for the part of the track between it's minimum and current values. <P> Will have the suffix
     * "Disabled" added when the slider is disabled.
     *
     * @return Current activeTrackStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getActiveTrackStyle()  {
        return getAttributeAsString("activeTrackStyle");
    }
    

    /**
     * Should the thumb be animated to its new position when the value is changed programmatically, or by clicking in the
     * slider track.
     *
     * @param animateThumb New animateThumb value. Default value is true
     */
    public void setAnimateThumb(Boolean animateThumb) {
        setAttribute("animateThumb", animateThumb, true);
    }

    /**
     * Should the thumb be animated to its new position when the value is changed programmatically, or by clicking in the
     * slider track.
     *
     * @return Current animateThumb value. Default value is true
     */
    public Boolean getAnimateThumb()  {
        Boolean result = getAttributeAsBoolean("animateThumb");
        return result == null ? true : result;
    }
    

    /**
     * If thumb animation is enabled, should the thumb be animated to its initial value?
     *
     * @param animateThumbInit New animateThumbInit value. Default value is false
     */
    public void setAnimateThumbInit(Boolean animateThumbInit) {
        setAttribute("animateThumbInit", animateThumbInit, true);
    }

    /**
     * If thumb animation is enabled, should the thumb be animated to its initial value?
     *
     * @return Current animateThumbInit value. Default value is false
     */
    public Boolean getAnimateThumbInit()  {
        Boolean result = getAttributeAsBoolean("animateThumbInit");
        return result == null ? false : result;
    }
    

    /**
     * Duration of thumb animation, in milliseconds.
     *
     * @param animateThumbTime New animateThumbTime value. Default value is 250
     */
    public void setAnimateThumbTime(int animateThumbTime) {
        setAttribute("animateThumbTime", animateThumbTime, true);
    }

    /**
     * Duration of thumb animation, in milliseconds.
     *
     * @return Current animateThumbTime value. Default value is 250
     */
    public int getAnimateThumbTime()  {
        return getAttributeAsInt("animateThumbTime");
    }
    

    /**
     * Indicates whether keyboard manipulation of the slider is allowed.
     *
     * @param canFocus New canFocus value. Default value is true
     */
    public void setCanFocus(Boolean canFocus) {
        setAttribute("canFocus", canFocus, true);
    }

    /**
     * Indicates whether keyboard manipulation of the slider is allowed.
     *
     * @return Current canFocus value. Default value is true
     */
    public Boolean getCanFocus()  {
        Boolean result = getAttributeAsBoolean("canFocus");
        return result == null ? true : result;
    }
    

    /**
     * Specifies whether the value range of the slider should be flipped so that values increase as the thumb is moved down
     * (for a vertical slider) or to the left (for a horizontal slider).
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.Slider#getFlipValues flipValues} property of the slider
     *
     * @param flipValues flip slider values?. Default value is false
     */
    public void setFlipValues(Boolean flipValues) {
        setAttribute("flipValues", flipValues, true);
    }

    /**
     * Specifies whether the value range of the slider should be flipped so that values increase as the thumb is moved down
     * (for a vertical slider) or to the left (for a horizontal slider).
     *
     * @return Current flipValues value. Default value is false
     */
    public Boolean getFlipValues()  {
        Boolean result = getAttributeAsBoolean("flipValues");
        return result == null ? false : result;
    }
    

    /**
     * Optional CSS style for the thumb for a horizontally oriented slider. <P> Will have the suffix "down" added when the
     * mouse is down on the thumb, and "Disabled" added when the slider is disabled.
     *
     * @param hThumbStyle New hThumbStyle value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setHThumbStyle(String hThumbStyle)  throws IllegalStateException {
        setAttribute("hThumbStyle", hThumbStyle, false);
    }

    /**
     * Optional CSS style for the thumb for a horizontally oriented slider. <P> Will have the suffix "down" added when the
     * mouse is down on the thumb, and "Disabled" added when the slider is disabled.
     *
     * @return Current hThumbStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getHThumbStyle()  {
        return getAttributeAsString("hThumbStyle");
    }
    

    /**
     * Optional CSS style for the track for a horizontally oriented slider. <P> Will have the suffix "Disabled" added when the
     * slider is disabled.
     *
     * @param hTrackStyle New hTrackStyle value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setHTrackStyle(String hTrackStyle)  throws IllegalStateException {
        setAttribute("hTrackStyle", hTrackStyle, false);
    }

    /**
     * Optional CSS style for the track for a horizontally oriented slider. <P> Will have the suffix "Disabled" added when the
     * slider is disabled.
     *
     * @return Current hTrackStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getHTrackStyle()  {
        return getAttributeAsString("hTrackStyle");
    }
    

    /**
     * The height of the labels used to display the minimum, maximum and current values of the slider.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.Slider#getLabelHeight labelHeight} property of the slider
     *
     * @param labelHeight new label height. Default value is 20
     */
    public void setLabelHeight(int labelHeight) {
        setAttribute("labelHeight", labelHeight, true);
    }

    /**
     * The height of the labels used to display the minimum, maximum and current values of the slider.
     *
     * @return Current labelHeight value. Default value is 20
     */
    public int getLabelHeight()  {
        return getAttributeAsInt("labelHeight");
    }
    

    /**
     * The space around the labels used to display the minimum, maximum and current values of the slider.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.Slider#getLabelSpacing labelSpacing} property of the slider
     *
     * @param labelSpacing new label spacing. Default value is 5
     */
    public void setLabelSpacing(int labelSpacing) {
        setAttribute("labelSpacing", labelSpacing, true);
    }

    /**
     * The space around the labels used to display the minimum, maximum and current values of the slider.
     *
     * @return Current labelSpacing value. Default value is 5
     */
    public int getLabelSpacing()  {
        return getAttributeAsInt("labelSpacing");
    }
    

    /**
     * The width of the labels used to display the minimum, maximum and current values of the slider.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.Slider#getLabelWidth labelWidth} property of the slider
     *
     * @param labelWidth new label width. Default value is 50
     */
    public void setLabelWidth(int labelWidth) {
        setAttribute("labelWidth", labelWidth, true);
    }

    /**
     * The width of the labels used to display the minimum, maximum and current values of the slider.
     *
     * @return Current labelWidth value. Default value is 50
     */
    public int getLabelWidth()  {
        return getAttributeAsInt("labelWidth");
    }
    

    /**
     * Used to set slider height if vertical, slider width if horizontal. Applied to the slider track, not necessarily the
     * entire widget. Overridden by an explicit width/height specification for the widget.
     *
     * @param length New length value. Default value is 200
     */
    public void setLength(int length) {
        setAttribute("length", length, true);
    }

    /**
     * Used to set slider height if vertical, slider width if horizontal. Applied to the slider track, not necessarily the
     * entire widget. Overridden by an explicit width/height specification for the widget.
     *
     * @return Current length value. Default value is 200
     */
    public int getLength()  {
        return getAttributeAsInt("length");
    }
    

    /**
     * The maximum slider value. The slider value is equal to maxValue when the thumb is at the top or right of the slider
     * (unless flipValues is true, in which case the maximum value is at the bottom/left of the slider)
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.Slider#getMaxValue maximum value} of the slider
     *
     * @param maxValue the new maximum value <b>Note:</b>Use Doubles rather Floats when manipulating decimal values.  See {@link
     * com.smartgwt.client.docs.GwtFloatVsDouble} for details. Default value is 100
     * @see com.smartgwt.client.widgets.Slider#setFlipValues
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#controls_category_slider" target="examples">Slider Example</a>
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public void setMaxValue(float maxValue) {
        setAttribute("maxValue", maxValue, true);
    }

    /**
     * The maximum slider value. The slider value is equal to maxValue when the thumb is at the top or right of the slider
     * (unless flipValues is true, in which case the maximum value is at the bottom/left of the slider)
     *
     * @return Current maxValue value. Default value is 100
     * @see com.smartgwt.client.widgets.Slider#getFlipValues
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#controls_category_slider" target="examples">Slider Example</a>
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public float getMaxValue()  {
        return getAttributeAsFloat("maxValue");
    }

    /**
     * The maximum slider value. The slider value is equal to maxValue when the thumb is at the top or right of the slider
     * (unless flipValues is true, in which case the maximum value is at the bottom/left of the slider)
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.Slider#getMaxValue maximum value} of the slider
     *
     * @param maxValue the new maximum value <b>Note:</b>Use Doubles rather Floats when manipulating decimal values.  See {@link
     * com.smartgwt.client.docs.GwtFloatVsDouble} for details. Default value is 100
     * @see com.smartgwt.client.widgets.Slider#setFlipValues
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#controls_category_slider" target="examples">Slider Example</a>
     */
    public void setMaxValue(double maxValue) {
        setAttribute("maxValue", maxValue, true);
    }

    /**
     * The maximum slider value. The slider value is equal to maxValue when the thumb is at the top or right of the slider
     * (unless flipValues is true, in which case the maximum value is at the bottom/left of the slider)
     *
     * @return Current maxValue value. Default value is 100
     * @see com.smartgwt.client.widgets.Slider#getFlipValues
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#controls_category_slider" target="examples">Slider Example</a>
     */
    public double getMaxValueAsDouble()  {
        return getAttributeAsDouble("maxValue");
    }
    

    /**
     * The text displayed in the label for the maximum value of the slider. If left as null, then slider.maxValue will be
     * displayed.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.Slider#getMaxValueLabel maxValueLabel} property of the slider
     *
     * @param maxValueLabel new label text. Default value is null
     * @see com.smartgwt.client.widgets.Slider#setShowRange
     * @see com.smartgwt.client.widgets.Slider#setMaxValue
     */
    public void setMaxValueLabel(String maxValueLabel) {
        setAttribute("maxValueLabel", maxValueLabel, true);
    }

    /**
     * The text displayed in the label for the maximum value of the slider. If left as null, then slider.maxValue will be
     * displayed.
     *
     * @return Current maxValueLabel value. Default value is null
     * @see com.smartgwt.client.widgets.Slider#getShowRange
     * @see com.smartgwt.client.widgets.Slider#getMaxValue
     */
    public String getMaxValueLabel()  {
        return getAttributeAsString("maxValueLabel");
    }
    

    /**
     * The minimum slider value. The slider value is equal to minValue when the thumb is at the bottom or left of the slider
     * (unless flipValues is true, in which case the minimum value is at the top/right of the slider)
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.Slider#getMinValue minimum value} of the slider
     *
     * @param minValue the new minimum value <b>Note:</b>Use Doubles rather Floats when manipulating decimal values.  See {@link
     * com.smartgwt.client.docs.GwtFloatVsDouble} for details. Default value is 1
     * @see com.smartgwt.client.widgets.Slider#setFlipValues
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#controls_category_slider" target="examples">Slider Example</a>
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public void setMinValue(float minValue) {
        setAttribute("minValue", minValue, true);
    }

    /**
     * The minimum slider value. The slider value is equal to minValue when the thumb is at the bottom or left of the slider
     * (unless flipValues is true, in which case the minimum value is at the top/right of the slider)
     *
     * @return Current minValue value. Default value is 1
     * @see com.smartgwt.client.widgets.Slider#getFlipValues
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#controls_category_slider" target="examples">Slider Example</a>
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public float getMinValue()  {
        return getAttributeAsFloat("minValue");
    }

    /**
     * The minimum slider value. The slider value is equal to minValue when the thumb is at the bottom or left of the slider
     * (unless flipValues is true, in which case the minimum value is at the top/right of the slider)
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.Slider#getMinValue minimum value} of the slider
     *
     * @param minValue the new minimum value <b>Note:</b>Use Doubles rather Floats when manipulating decimal values.  See {@link
     * com.smartgwt.client.docs.GwtFloatVsDouble} for details. Default value is 1
     * @see com.smartgwt.client.widgets.Slider#setFlipValues
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#controls_category_slider" target="examples">Slider Example</a>
     */
    public void setMinValue(double minValue) {
        setAttribute("minValue", minValue, true);
    }

    /**
     * The minimum slider value. The slider value is equal to minValue when the thumb is at the bottom or left of the slider
     * (unless flipValues is true, in which case the minimum value is at the top/right of the slider)
     *
     * @return Current minValue value. Default value is 1
     * @see com.smartgwt.client.widgets.Slider#getFlipValues
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#controls_category_slider" target="examples">Slider Example</a>
     */
    public double getMinValueAsDouble()  {
        return getAttributeAsDouble("minValue");
    }
    

    /**
     * The text displayed in the label for the minimum value of the slider. If left as null, then slider.minValue will be
     * displayed.
     *
     * @param minValueLabel New minValueLabel value. Default value is null
     * @see com.smartgwt.client.widgets.Slider#setShowRange
     * @see com.smartgwt.client.widgets.Slider#setMinValue
     */
    public void setMinValueLabel(String minValueLabel) {
        setAttribute("minValueLabel", minValueLabel, true);
    }

    /**
     * The text displayed in the label for the minimum value of the slider. If left as null, then slider.minValue will be
     * displayed.
     *
     * @return Current minValueLabel value. Default value is null
     * @see com.smartgwt.client.widgets.Slider#getShowRange
     * @see com.smartgwt.client.widgets.Slider#getMinValue
     */
    public String getMinValueLabel()  {
        return getAttributeAsString("minValueLabel");
    }
    

    /**
     * The number of discrete values represented by slider. If specified, the range of valid values (between
     * <code>minValue</code> and <code>maxValue</code>) will be divided into this many steps. As the thumb is moved along the
     * track it will only select these values and appear to jump between the steps.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.Slider#getNumValues number of values} for the slider
     *
     * @param numValues the new number of values <b>Note:</b>Use Doubles rather Floats when manipulating decimal values.  See {@link
     * com.smartgwt.client.docs.GwtFloatVsDouble} for details. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#controls_category_slider" target="examples">Slider Example</a>
     */
    public void setNumValues(Integer numValues) {
        setAttribute("numValues", numValues, true);
    }

    /**
     * The number of discrete values represented by slider. If specified, the range of valid values (between
     * <code>minValue</code> and <code>maxValue</code>) will be divided into this many steps. As the thumb is moved along the
     * track it will only select these values and appear to jump between the steps.
     *
     * @return Current numValues value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#controls_category_slider" target="examples">Slider Example</a>
     */
    public Integer getNumValues()  {
        return getAttributeAsInt("numValues");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.Slider#getRoundValues roundValues} is false, the slider value will be rounded to
     * this number of decimal places. If set to null the value will not be rounded
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.Slider#getRoundPrecision roundPrecision} property of the slider
     *
     * @param roundPrecision new round precision. Default value is 1
     */
    public void setRoundPrecision(int roundPrecision) {
        setAttribute("roundPrecision", roundPrecision, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.Slider#getRoundValues roundValues} is false, the slider value will be rounded to
     * this number of decimal places. If set to null the value will not be rounded
     *
     * @return Current roundPrecision value. Default value is 1
     */
    public int getRoundPrecision()  {
        return getAttributeAsInt("roundPrecision");
    }
    

    /**
     * Specifies whether the slider value should be rounded to the nearest integer.  If set to false, values will be rounded to
     * a fixed number of decimal places controlled by {@link com.smartgwt.client.widgets.Slider#getRoundPrecision
     * roundPrecision}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.Slider#getRoundValues roundValues} property of the slider
     *
     * @param roundValues round slider values?. Default value is true
     */
    public void setRoundValues(Boolean roundValues) {
        setAttribute("roundValues", roundValues, true);
    }

    /**
     * Specifies whether the slider value should be rounded to the nearest integer.  If set to false, values will be rounded to
     * a fixed number of decimal places controlled by {@link com.smartgwt.client.widgets.Slider#getRoundPrecision
     * roundPrecision}.
     *
     * @return Current roundValues value. Default value is true
     */
    public Boolean getRoundValues()  {
        Boolean result = getAttributeAsBoolean("roundValues");
        return result == null ? true : result;
    }
    

    /**
     * If true, applies a separate {@link com.smartgwt.client.widgets.Slider#getActiveTrackStyle CSS style} to the part of the
     * track between the minimum and current values.
     *
     * @param showActiveTrack New showActiveTrack value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#controls_category_slider" target="examples">Slider Example</a>
     */
    public void setShowActiveTrack(Boolean showActiveTrack) {
        setAttribute("showActiveTrack", showActiveTrack, true);
    }

    /**
     * If true, applies a separate {@link com.smartgwt.client.widgets.Slider#getActiveTrackStyle CSS style} to the part of the
     * track between the minimum and current values.
     *
     * @return Current showActiveTrack value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#controls_category_slider" target="examples">Slider Example</a>
     */
    public Boolean getShowActiveTrack()  {
        return getAttributeAsBoolean("showActiveTrack");
    }
    

    /**
     * Indicates whether labels for the min and max values of the slider should be displayed. The default positions for these
     * labels are below the start/end of a horizontal slider, or to the right of the start/end of a vertical slider.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.Slider#getShowRange showRange} property of the slider
     *
     * @param showRange show the slider range?. Default value is true
     * @see com.smartgwt.client.widgets.Slider#setMinValueLabel
     * @see com.smartgwt.client.widgets.Slider#setMaxValueLabel
     */
    public void setShowRange(Boolean showRange) {
        setAttribute("showRange", showRange, true);
    }

    /**
     * Indicates whether labels for the min and max values of the slider should be displayed. The default positions for these
     * labels are below the start/end of a horizontal slider, or to the right of the start/end of a vertical slider.
     *
     * @return Current showRange value. Default value is true
     * @see com.smartgwt.client.widgets.Slider#getMinValueLabel
     * @see com.smartgwt.client.widgets.Slider#getMaxValueLabel
     */
    public Boolean getShowRange()  {
        Boolean result = getAttributeAsBoolean("showRange");
        return result == null ? true : result;
    }
    

    /**
     * Indicates whether the slider's title should be displayed. The default position for this label is to the left of a
     * horizontal slider, or above a vertical slider.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.Slider#getShowTitle showTitle} property of the slider
     *
     * @param showTitle show the slider title?. Default value is true
     * @see com.smartgwt.client.widgets.Slider#setTitle
     */
    public void setShowTitle(Boolean showTitle) {
        setAttribute("showTitle", showTitle, true);
    }

    /**
     * Indicates whether the slider's title should be displayed. The default position for this label is to the left of a
     * horizontal slider, or above a vertical slider.
     *
     * @return Current showTitle value. Default value is true
     * @see com.smartgwt.client.widgets.Slider#getTitle
     */
    public Boolean getShowTitle()  {
        Boolean result = getAttributeAsBoolean("showTitle");
        return result == null ? true : result;
    }
    

    /**
     * Indicates whether a label for the value of the slider should be displayed. The default position for this label is to the
     * right of a vertical slider, or below a horizontal  slider.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.Slider#getShowValue showValue} property of the slider
     *
     * @param showValue show the slider value?. Default value is true
     * @see com.smartgwt.client.widgets.Slider#setValue
     */
    public void setShowValue(Boolean showValue) {
        setAttribute("showValue", showValue, true);
    }

    /**
     * Indicates whether a label for the value of the slider should be displayed. The default position for this label is to the
     * right of a vertical slider, or below a horizontal  slider.
     *
     * @return Current showValue value. Default value is true
     * @see com.smartgwt.client.widgets.Slider#getValue
     */
    public Boolean getShowValue()  {
        Boolean result = getAttributeAsBoolean("showValue");
        return result == null ? true : result;
    }
    
    

    /**
     * The percentage of the total slider that constitutes one discrete step. The slider will move one step when the
     * appropriate arrow key is pressed.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.Slider#getStepPercent stepPercent} property of the slider
     *
     * @param stepPercent new slider step percent. Default value is 5
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public void setStepPercent(float stepPercent) {
        setAttribute("stepPercent", stepPercent, true);
    }

    /**
     * The percentage of the total slider that constitutes one discrete step. The slider will move one step when the
     * appropriate arrow key is pressed.
     *
     * @return Current stepPercent value. Default value is 5
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public float getStepPercent()  {
        return getAttributeAsFloat("stepPercent");
    }

    /**
     * The percentage of the total slider that constitutes one discrete step. The slider will move one step when the
     * appropriate arrow key is pressed.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.Slider#getStepPercent stepPercent} property of the slider
     *
     * @param stepPercent new slider step percent. Default value is 5
     */
    public void setStepPercent(double stepPercent) {
        setAttribute("stepPercent", stepPercent, true);
    }

    /**
     * The percentage of the total slider that constitutes one discrete step. The slider will move one step when the
     * appropriate arrow key is pressed.
     *
     * @return Current stepPercent value. Default value is 5
     */
    public double getStepPercentAsDouble()  {
        return getAttributeAsDouble("stepPercent");
    }
    

    /**
     * The base filename for the slider thumb images. The filenames for the thumb icons are assembled from this base filename
     * and the state of the thumb, as follows:<br> Assume the thumbSrc is set to <code>{baseName}.{extension}</code><br> The
     * full set of images to be displayed is:<br> For horizontal sliders: <ul> <li><code>h{baseName}.{extension}</code>:
     * default enabled appearance. <li><code>h{baseName}_down.{extension}</code>:  appearance when the slider is enabled and
     * the     thumb is clicked. <li><code>h{baseName}_Disabled.{extension}</code>:  appearance when the slider is disabled.
     * </ul> For vertical sliders: <ul> <li><code>v{baseName}.{extension}</code>: default enabled appearance.
     * <li><code>v{baseName}_down.{extension}</code>:  appearance when the slider is enabled and the     thumb is clicked.
     * <li><code>v{baseName}_Disabled.{extension}</code>:  appearance when the slider is disabled. </ul>
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.Slider#getThumbSrc thumbSrc} property of the slider
     *
     * @param thumbSrc new thumbSrc. Default value is "thumb.gif"
     */
    public void setThumbSrc(String thumbSrc) {
        setAttribute("thumbSrc", thumbSrc, true);
    }

    /**
     * The base filename for the slider thumb images. The filenames for the thumb icons are assembled from this base filename
     * and the state of the thumb, as follows:<br> Assume the thumbSrc is set to <code>{baseName}.{extension}</code><br> The
     * full set of images to be displayed is:<br> For horizontal sliders: <ul> <li><code>h{baseName}.{extension}</code>:
     * default enabled appearance. <li><code>h{baseName}_down.{extension}</code>:  appearance when the slider is enabled and
     * the     thumb is clicked. <li><code>h{baseName}_Disabled.{extension}</code>:  appearance when the slider is disabled.
     * </ul> For vertical sliders: <ul> <li><code>v{baseName}.{extension}</code>: default enabled appearance.
     * <li><code>v{baseName}_down.{extension}</code>:  appearance when the slider is enabled and the     thumb is clicked.
     * <li><code>v{baseName}_Disabled.{extension}</code>:  appearance when the slider is disabled. </ul>
     *
     * @return Current thumbSrc value. Default value is "thumb.gif"
     */
    public String getThumbSrc()  {
        return getAttributeAsString("thumbSrc");
    }
    

    /**
     * The dimension of the thumb perpendicular to the slider track.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.Slider#getThumbThickWidth thumbThickWidth} property of the slider
     *
     * @param thumbThickWidth new thumbThickWidth. Default value is 23
     */
    public void setThumbThickWidth(int thumbThickWidth) {
        setAttribute("thumbThickWidth", thumbThickWidth, true);
    }

    /**
     * The dimension of the thumb perpendicular to the slider track.
     *
     * @return Current thumbThickWidth value. Default value is 23
     */
    public int getThumbThickWidth()  {
        return getAttributeAsInt("thumbThickWidth");
    }
    

    /**
     * The dimension of the thumb parallel to the slider track.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.Slider#getThumbThinWidth thumbThinWidth} property of the slider
     *
     * @param thumbThinWidth new thumbThinWidth. Default value is 17
     */
    public void setThumbThinWidth(int thumbThinWidth) {
        setAttribute("thumbThinWidth", thumbThinWidth, true);
    }

    /**
     * The dimension of the thumb parallel to the slider track.
     *
     * @return Current thumbThinWidth value. Default value is 17
     */
    public int getThumbThinWidth()  {
        return getAttributeAsInt("thumbThinWidth");
    }
    

    /**
     * Optional display title for the slider.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.Slider#getTitle title} of the slider
     *
     * @param title new title for the slider. Default value is "Set Value"
     * @see com.smartgwt.client.widgets.Slider#setShowTitle
     */
    public void setTitle(String title) {
        setAttribute("title", title, true);
    }

    /**
     * Optional display title for the slider.
     *
     * @return Current title value. Default value is "Set Value"
     * @see com.smartgwt.client.widgets.Slider#getShowTitle
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }
    

    /**
     * The space between the title and the track.
     *
     * @param titleSpacing New titleSpacing value. Default value is 5
     */
    public void setTitleSpacing(int titleSpacing) {
        setAttribute("titleSpacing", titleSpacing, true);
    }

    /**
     * The space between the title and the track.
     *
     * @return Current titleSpacing value. Default value is 5
     */
    public int getTitleSpacing()  {
        return getAttributeAsInt("titleSpacing");
    }
    

    /**
     * The height of vertical slider start and end images, or width of horizontal slider start and end images.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.Slider#getTrackCapSize trackCapSize} property of the slider
     *
     * @param trackCapSize new trackCapSize. Default value is 6
     */
    public void setTrackCapSize(int trackCapSize) {
        setAttribute("trackCapSize", trackCapSize, true);
    }

    /**
     * The height of vertical slider start and end images, or width of horizontal slider start and end images.
     *
     * @return Current trackCapSize value. Default value is 6
     */
    public int getTrackCapSize()  {
        return getAttributeAsInt("trackCapSize");
    }
    

    /**
     * The imageType setting for the slider track.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.Slider#getTrackImageType trackImageType} property of the slider
     *
     * @param trackImageType new trackImageType. Default value is "stretch"
     * @see com.smartgwt.client.types.ImageStyle
     * @see com.smartgwt.client.widgets.StretchImg#setImageType
     */
    public void setTrackImageType(ImageStyle trackImageType) {
        setAttribute("trackImageType", trackImageType == null ? null : trackImageType.getValue(), true);
    }

    /**
     * The imageType setting for the slider track.
     *
     * @return Current trackImageType value. Default value is "stretch"
     * @see com.smartgwt.client.types.ImageStyle
     * @see com.smartgwt.client.widgets.StretchImg#getImageType
     */
    public ImageStyle getTrackImageType()  {
        return EnumUtil.getEnum(ImageStyle.values(), getAttribute("trackImageType"));
    }
    

    /**
     * The base filename for the slider track images. The filenames for the track icons are assembled from this base filename
     * and the state of the slider, as follows:<br> Assume the trackSrc is set to <code>{baseName}.{extension}</code><br> The
     * full set of images to be displayed is:<br> For horizontal sliders: <ul> <li><code>h{baseName}_start.{extension}</code>:
     * start (left edge) of the track for a slider     that is enabled. <li><code>h{baseName}_stretch.{extension}</code>:  the
     * track for an enabled slider; this may     be centered, tiled, or stretched.
     * <li><code>h{baseName}_end.{extension}</code>:  end (right edge) of the track for a slider     that is enabled.
     * <li><code>h{baseName}_Disabled_start.{extension}</code>: start (left edge) of the track for a slider     that is
     * disabled. <li><code>h{baseName}_Disabled_stretch.{extension}</code>:  the track for a disabled slider; this     may be
     * centered, tiled, or stretched. <li><code>h{baseName}_Disabled_end.{extension}</code>:  end (right edge) of the track for
     * a slider     that is disabled. </ul> For vertical sliders: <ul> <li><code>v{baseName}_start.{extension}</code>: start
     * (bottom edge) of the track for a slider     that is enabled. <li><code>v{baseName}_stretch.{extension}</code>:  the
     * track for an enabled slider; this may     be centered, tiled, or stretched.
     * <li><code>v{baseName}_end.{extension}</code>:  end (top edge) of the track for a slider     that is enabled.
     * <li><code>v{baseName}_Disabled_start.{extension}</code>: start (bottom edge) of the track for a slider     that is
     * disabled. <li><code>v{baseName}_Disabled_stretch.{extension}</code>:  the track for a disabled slider; this     may be
     * centered, tiled, or stretched. <li><code>v{baseName}_end.{extension}</code>:  end (top edge) of the track for a slider  
     *   that is disabled. </ul>
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.Slider#getTrackSrc trackSrc} property of the slider
     *
     * @param trackSrc new trackSrc. Default value is "track.gif"
     * @see com.smartgwt.client.widgets.Slider#setTrackImageType
     */
    public void setTrackSrc(String trackSrc) {
        setAttribute("trackSrc", trackSrc, true);
    }

    /**
     * The base filename for the slider track images. The filenames for the track icons are assembled from this base filename
     * and the state of the slider, as follows:<br> Assume the trackSrc is set to <code>{baseName}.{extension}</code><br> The
     * full set of images to be displayed is:<br> For horizontal sliders: <ul> <li><code>h{baseName}_start.{extension}</code>:
     * start (left edge) of the track for a slider     that is enabled. <li><code>h{baseName}_stretch.{extension}</code>:  the
     * track for an enabled slider; this may     be centered, tiled, or stretched.
     * <li><code>h{baseName}_end.{extension}</code>:  end (right edge) of the track for a slider     that is enabled.
     * <li><code>h{baseName}_Disabled_start.{extension}</code>: start (left edge) of the track for a slider     that is
     * disabled. <li><code>h{baseName}_Disabled_stretch.{extension}</code>:  the track for a disabled slider; this     may be
     * centered, tiled, or stretched. <li><code>h{baseName}_Disabled_end.{extension}</code>:  end (right edge) of the track for
     * a slider     that is disabled. </ul> For vertical sliders: <ul> <li><code>v{baseName}_start.{extension}</code>: start
     * (bottom edge) of the track for a slider     that is enabled. <li><code>v{baseName}_stretch.{extension}</code>:  the
     * track for an enabled slider; this may     be centered, tiled, or stretched.
     * <li><code>v{baseName}_end.{extension}</code>:  end (top edge) of the track for a slider     that is enabled.
     * <li><code>v{baseName}_Disabled_start.{extension}</code>: start (bottom edge) of the track for a slider     that is
     * disabled. <li><code>v{baseName}_Disabled_stretch.{extension}</code>:  the track for a disabled slider; this     may be
     * centered, tiled, or stretched. <li><code>v{baseName}_end.{extension}</code>:  end (top edge) of the track for a slider  
     *   that is disabled. </ul>
     *
     * @return Current trackSrc value. Default value is "track.gif"
     * @see com.smartgwt.client.widgets.Slider#getTrackImageType
     */
    public String getTrackSrc()  {
        return getAttributeAsString("trackSrc");
    }
    

    /**
     * The thickness of the track. This is the width, for a vertical slider, or the height, for a horizontal slider.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.Slider#getTrackWidth trackWidth} property of the slider
     *
     * @param trackWidth new trackWidth. Default value is 7
     */
    public void setTrackWidth(int trackWidth) {
        setAttribute("trackWidth", trackWidth, true);
    }

    /**
     * The thickness of the track. This is the width, for a vertical slider, or the height, for a horizontal slider.
     *
     * @return Current trackWidth value. Default value is 7
     */
    public int getTrackWidth()  {
        return getAttributeAsInt("trackWidth");
    }
    

    /**
     * The slider value. This value should lie between the minValue and maxValue and increases as the thumb is moved up (for a
     * vertical slider) or right (for a horizontal slider) unless flipValues is set to true.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the slider value to newValue and moves the slider thumb to the appropriate position for this value. Sends the 'sliderMove' event to the sliderTarget.
     *
     * @param value the new value <b>Note:</b>Use Doubles rather Floats when manipulating decimal values.  See {@link
     * com.smartgwt.client.docs.GwtFloatVsDouble} for details. Default value is 1
     * @see com.smartgwt.client.widgets.Slider#setMinValue
     * @see com.smartgwt.client.widgets.Slider#setMaxValue
     * @see com.smartgwt.client.widgets.Slider#setFlipValues
     * @see com.smartgwt.client.widgets.Slider#setShowValue
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public void setValue(float value) {
        setAttribute("value", value, true);
    }

    /**
     * The slider value. This value should lie between the minValue and maxValue and increases as the thumb is moved up (for a
     * vertical slider) or right (for a horizontal slider) unless flipValues is set to true.
     *
     * @return Returns the current slider value. Default value is 1
     * @see com.smartgwt.client.widgets.Slider#getMinValue
     * @see com.smartgwt.client.widgets.Slider#getMaxValue
     * @see com.smartgwt.client.widgets.Slider#getFlipValues
     * @see com.smartgwt.client.widgets.Slider#getShowValue
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public float getValue()  {
        return getAttributeAsFloat("value");
    }

    /**
     * The slider value. This value should lie between the minValue and maxValue and increases as the thumb is moved up (for a
     * vertical slider) or right (for a horizontal slider) unless flipValues is set to true.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the slider value to newValue and moves the slider thumb to the appropriate position for this value. Sends the 'sliderMove' event to the sliderTarget.
     *
     * @param value the new value <b>Note:</b>Use Doubles rather Floats when manipulating decimal values.  See {@link
     * com.smartgwt.client.docs.GwtFloatVsDouble} for details. Default value is 1
     * @see com.smartgwt.client.widgets.Slider#setMinValue
     * @see com.smartgwt.client.widgets.Slider#setMaxValue
     * @see com.smartgwt.client.widgets.Slider#setFlipValues
     * @see com.smartgwt.client.widgets.Slider#setShowValue
     */
    public void setValue(double value) {
        setAttribute("value", value, true);
    }

    /**
     * The slider value. This value should lie between the minValue and maxValue and increases as the thumb is moved up (for a
     * vertical slider) or right (for a horizontal slider) unless flipValues is set to true.
     *
     * @return Returns the current slider value. Default value is 1
     * @see com.smartgwt.client.widgets.Slider#getMinValue
     * @see com.smartgwt.client.widgets.Slider#getMaxValue
     * @see com.smartgwt.client.widgets.Slider#getFlipValues
     * @see com.smartgwt.client.widgets.Slider#getShowValue
     */
    public double getValueAsDouble()  {
        return getAttributeAsDouble("value");
    }
    

    /**
     * Indicates whether this is a vertical or horizontal slider.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.Slider#getVertical vertical} property of the slider
     *
     * @param vertical is the slider vertical. Default value is true
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#controls_category_slider" target="examples">Slider Example</a>
     */
    public void setVertical(Boolean vertical) {
        setAttribute("vertical", vertical, true);
    }

    /**
     * Indicates whether this is a vertical or horizontal slider.
     *
     * @return Current vertical value. Default value is true
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#controls_category_slider" target="examples">Slider Example</a>
     */
    public Boolean getVertical()  {
        Boolean result = getAttributeAsBoolean("vertical");
        return result == null ? true : result;
    }
    

    /**
     * Optional CSS style for the thumb for a vertically oriented slider.  See {@link
     * com.smartgwt.client.widgets.Slider#getHThumbStyle hThumbStyle} for state suffixes.
     *
     * @param vThumbStyle New vThumbStyle value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setVThumbStyle(String vThumbStyle)  throws IllegalStateException {
        setAttribute("vThumbStyle", vThumbStyle, false);
    }

    /**
     * Optional CSS style for the thumb for a vertically oriented slider.  See {@link
     * com.smartgwt.client.widgets.Slider#getHThumbStyle hThumbStyle} for state suffixes.
     *
     * @return Current vThumbStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getVThumbStyle()  {
        return getAttributeAsString("vThumbStyle");
    }
    

    /**
     * Optional CSS style for the track for a vertically oriented slider. <P> Will have the suffix "Disabled" added when the
     * slider is disabled.
     *
     * @param vTrackStyle New vTrackStyle value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setVTrackStyle(String vTrackStyle)  throws IllegalStateException {
        setAttribute("vTrackStyle", vTrackStyle, false);
    }

    /**
     * Optional CSS style for the track for a vertically oriented slider. <P> Will have the suffix "Disabled" added when the
     * slider is disabled.
     *
     * @return Current vTrackStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getVTrackStyle()  {
        return getAttributeAsString("vTrackStyle");
    }
    

    // ********************* Methods ***********************
    /**
     * Add a valueChanged handler.
     * <p>
     * This method is called when the slider value changes. This occurs when the {@link
     * com.smartgwt.client.widgets.Slider#setValue setValue()} method is called, or when the slider is moved. Observe this
     * method to be notified when the slider value changes.
     *
     * @param handler the valueChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addValueChangedHandler(com.smartgwt.client.widgets.events.ValueChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.events.ValueChangedEvent.getType()) == 0) setupValueChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.events.ValueChangedEvent.getType());
    }

    private native void setupValueChangedEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var valueChanged = $entry(function(){
            var param = {"_this": this, "value" : arguments[0]};
            var event = @com.smartgwt.client.widgets.events.ValueChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.Slider::handleTearDownValueChangedEvent()();
            if (hasDefaultHandler) this.Super("valueChanged", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("valueChanged"));
            obj.addProperties({valueChanged:  valueChanged              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("valueChanged"));
            obj.valueChanged =  valueChanged             ;
        }
    }-*/;

    private void handleTearDownValueChangedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.events.ValueChangedEvent.getType()) == 0) tearDownValueChangedEvent();
    }

    private native void tearDownValueChangedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("valueChanged")) delete obj.valueChanged;
    }-*/;

	/**
     * Call this method in your {@link com.smartgwt.client.widgets.Slider#addValueChangedHandler Slider.valueChanged()} handler
     * to determine whether the value change is due to an ongoing drag interaction (true) or due to a thumb-release, mouse
     * click, keypress, or programmatic event (false). You may choose to execute temporary or partial updates while the slider
     * thumb is dragged, and final updates or persistence of the value in response to the other events.
     *
     * @return true if user is still dragging the slider thumb, false otherwise
     */
    public native Boolean valueIsChanging() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "valueIsChanging", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.valueIsChanging();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
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
     * @param sliderProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(Slider sliderProperties) /*-{
        if (sliderProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(Slider.@java.lang.Object::getClass()(), "setDefaultProperties", sliderProperties.@java.lang.Object::getClass()());
        }
        sliderProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = sliderProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.Slider.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(SliderLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.activeTrackStyle = getAttributeAsString("activeTrackStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.activeTrackStyle:" + t.getMessage() + "\n";
        }
        try {
            s.animateThumb = getAttributeAsString("animateThumb");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.animateThumb:" + t.getMessage() + "\n";
        }
        try {
            s.animateThumbInit = getAttributeAsString("animateThumbInit");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.animateThumbInit:" + t.getMessage() + "\n";
        }
        try {
            s.animateThumbTime = getAttributeAsString("animateThumbTime");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.animateThumbTime:" + t.getMessage() + "\n";
        }
        try {
            s.canFocus = getAttributeAsString("canFocus");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.canFocus:" + t.getMessage() + "\n";
        }
        try {
            s.flipValues = getAttributeAsString("flipValues");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.flipValues:" + t.getMessage() + "\n";
        }
        try {
            s.hThumbStyle = getAttributeAsString("hThumbStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.hThumbStyle:" + t.getMessage() + "\n";
        }
        try {
            s.hTrackStyle = getAttributeAsString("hTrackStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.hTrackStyle:" + t.getMessage() + "\n";
        }
        try {
            s.labelHeight = getAttributeAsString("labelHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.labelHeight:" + t.getMessage() + "\n";
        }
        try {
            s.labelSpacing = getAttributeAsString("labelSpacing");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.labelSpacing:" + t.getMessage() + "\n";
        }
        try {
            s.labelWidth = getAttributeAsString("labelWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.labelWidth:" + t.getMessage() + "\n";
        }
        try {
            s.length = getAttributeAsString("length");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.length:" + t.getMessage() + "\n";
        }
        try {
            s.maxValueLabel = getAttributeAsString("maxValueLabel");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.maxValueLabel:" + t.getMessage() + "\n";
        }
        try {
            s.minValueLabel = getAttributeAsString("minValueLabel");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.minValueLabel:" + t.getMessage() + "\n";
        }
        try {
            s.numValues = getAttributeAsString("numValues");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.numValues:" + t.getMessage() + "\n";
        }
        try {
            s.roundPrecision = getAttributeAsString("roundPrecision");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.roundPrecision:" + t.getMessage() + "\n";
        }
        try {
            s.roundValues = getAttributeAsString("roundValues");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.roundValues:" + t.getMessage() + "\n";
        }
        try {
            s.showActiveTrack = getAttributeAsString("showActiveTrack");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.showActiveTrack:" + t.getMessage() + "\n";
        }
        try {
            s.showRange = getAttributeAsString("showRange");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.showRange:" + t.getMessage() + "\n";
        }
        try {
            s.showTitle = getAttributeAsString("showTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.showTitle:" + t.getMessage() + "\n";
        }
        try {
            s.showValue = getAttributeAsString("showValue");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.showValue:" + t.getMessage() + "\n";
        }
        try {
            s.thumbSrc = getAttributeAsString("thumbSrc");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.thumbSrc:" + t.getMessage() + "\n";
        }
        try {
            s.thumbThickWidth = getAttributeAsString("thumbThickWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.thumbThickWidth:" + t.getMessage() + "\n";
        }
        try {
            s.thumbThinWidth = getAttributeAsString("thumbThinWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.thumbThinWidth:" + t.getMessage() + "\n";
        }
        try {
            s.title = getAttributeAsString("title");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.title:" + t.getMessage() + "\n";
        }
        try {
            s.titleSpacing = getAttributeAsString("titleSpacing");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.titleSpacing:" + t.getMessage() + "\n";
        }
        try {
            s.trackCapSize = getAttributeAsString("trackCapSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.trackCapSize:" + t.getMessage() + "\n";
        }
        try {
            s.trackImageType = getAttributeAsString("trackImageType");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.trackImageType:" + t.getMessage() + "\n";
        }
        try {
            s.trackSrc = getAttributeAsString("trackSrc");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.trackSrc:" + t.getMessage() + "\n";
        }
        try {
            s.trackWidth = getAttributeAsString("trackWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.trackWidth:" + t.getMessage() + "\n";
        }
        try {
            s.vertical = getAttributeAsString("vertical");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.vertical:" + t.getMessage() + "\n";
        }
        try {
            s.vThumbStyle = getAttributeAsString("vThumbStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.vThumbStyle:" + t.getMessage() + "\n";
        }
        try {
            s.vTrackStyle = getAttributeAsString("vTrackStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.vTrackStyle:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        SliderLogicalStructure s = new SliderLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
