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
     * A styled canvas used to highlight the {@link com.smartgwt.client.widgets.Slider#getShowActiveTrack active} part of the
     * slider track.
     * <p>
     * This component is an AutoChild named "activeTrack".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current activeTrack value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public StatefulCanvas getActiveTrack() throws IllegalStateException {
        errorIfNotCreated("activeTrack");
        return (StatefulCanvas)StatefulCanvas.getByJSObject(getAttributeAsJavaScriptObject("activeTrack"));
    }
    

    /**
     * CSS style used to highlight the {@link com.smartgwt.client.widgets.Slider#getShowActiveTrack active} part of the slider
     * track. <P> Will have the suffix "Disabled" added when the slider is disabled.
     *
     * @param activeTrackStyle New activeTrackStyle value. Default value is "sliderTrackActive"
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public Slider setActiveTrackStyle(String activeTrackStyle)  throws IllegalStateException {
        return (Slider)setAttribute("activeTrackStyle", activeTrackStyle, false);
    }

    /**
     * CSS style used to highlight the {@link com.smartgwt.client.widgets.Slider#getShowActiveTrack active} part of the slider
     * track. <P> Will have the suffix "Disabled" added when the slider is disabled.
     *
     * @return Current activeTrackStyle value. Default value is "sliderTrackActive"
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
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     */
    public Slider setAnimateThumb(Boolean animateThumb) {
        return (Slider)setAttribute("animateThumb", animateThumb, true);
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
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     */
    public Slider setAnimateThumbInit(Boolean animateThumbInit) {
        return (Slider)setAttribute("animateThumbInit", animateThumbInit, true);
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
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     */
    public Slider setAnimateThumbTime(int animateThumbTime) {
        return (Slider)setAttribute("animateThumbTime", animateThumbTime, true);
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
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     */
    public Slider setCanFocus(Boolean canFocus) {
        return (Slider)setAttribute("canFocus", canFocus, true);
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
     * (for a {@link com.smartgwt.client.widgets.Slider#getVertical vertical} slider) or to the left  (for a horizontal
     * slider).
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.Slider#getFlipValues flipValues} property of the slider
     *
     * @param flipValues flip slider values?. Default value is false
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     */
    public Slider setFlipValues(Boolean flipValues) {
        return (Slider)setAttribute("flipValues", flipValues, true);
    }

    /**
     * Specifies whether the value range of the slider should be flipped so that values increase as the thumb is moved down
     * (for a {@link com.smartgwt.client.widgets.Slider#getVertical vertical} slider) or to the left  (for a horizontal
     * slider).
     *
     * @return Current flipValues value. Default value is false
     */
    public Boolean getFlipValues()  {
        Boolean result = getAttributeAsBoolean("flipValues");
        return result == null ? false : result;
    }
    

    /**
     * The space around the labels used to display the  {@link com.smartgwt.client.widgets.Slider#getRangeLabel minimum,
     * maximum} and {@link com.smartgwt.client.widgets.Slider#getValueLabel current} values  of the slider, when {@link
     * com.smartgwt.client.widgets.Slider#getVertical vertical} is false.  If unset, defaults to  {@link
     * com.smartgwt.client.widgets.Slider#getLabelSpacing labelSpacing}.
     *
     * @param hLabelSpacing New hLabelSpacing value. Default value is null
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     */
    public Slider setHLabelSpacing(Integer hLabelSpacing) {
        return (Slider)setAttribute("hLabelSpacing", hLabelSpacing, true);
    }

    /**
     * The space around the labels used to display the  {@link com.smartgwt.client.widgets.Slider#getRangeLabel minimum,
     * maximum} and {@link com.smartgwt.client.widgets.Slider#getValueLabel current} values  of the slider, when {@link
     * com.smartgwt.client.widgets.Slider#getVertical vertical} is false.  If unset, defaults to  {@link
     * com.smartgwt.client.widgets.Slider#getLabelSpacing labelSpacing}.
     *
     * @return Current hLabelSpacing value. Default value is null
     */
    public Integer getHLabelSpacing()  {
        return getAttributeAsInt("hLabelSpacing");
    }
    

    /**
     * Optional CSS style for the thumb for a {@link com.smartgwt.client.widgets.Slider#getVertical horizontally oriented}
     * slider. <P> Will have the suffix "down" added when the mouse is down on the thumb, and "Disabled" added when the slider
     * is disabled.
     *
     * @param hThumbStyle New hThumbStyle value. Default value is null
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public Slider setHThumbStyle(String hThumbStyle)  throws IllegalStateException {
        return (Slider)setAttribute("hThumbStyle", hThumbStyle, false);
    }

    /**
     * Optional CSS style for the thumb for a {@link com.smartgwt.client.widgets.Slider#getVertical horizontally oriented}
     * slider. <P> Will have the suffix "down" added when the mouse is down on the thumb, and "Disabled" added when the slider
     * is disabled.
     *
     * @return Current hThumbStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getHThumbStyle()  {
        return getAttributeAsString("hThumbStyle");
    }
    

    /**
     * Optional CSS style for the track for a {@link com.smartgwt.client.widgets.Slider#getVertical horizontally oriented} 
     * slider. <P> Will have the suffix "Disabled" added when the slider is disabled.
     *
     * @param hTrackStyle New hTrackStyle value. Default value is null
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public Slider setHTrackStyle(String hTrackStyle)  throws IllegalStateException {
        return (Slider)setAttribute("hTrackStyle", hTrackStyle, false);
    }

    /**
     * Optional CSS style for the track for a {@link com.smartgwt.client.widgets.Slider#getVertical horizontally oriented} 
     * slider. <P> Will have the suffix "Disabled" added when the slider is disabled.
     *
     * @return Current hTrackStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getHTrackStyle()  {
        return getAttributeAsString("hTrackStyle");
    }
    

    /**
     * Optional CSS style for the floating {@link com.smartgwt.client.widgets.Slider#getValueLabel valueLabel}, visible when
     * {@link com.smartgwt.client.widgets.Slider#getShowValue showValue} is true and {@link
     * com.smartgwt.client.widgets.Slider#getVertical vertical} is false.
     *
     * @param hValueStyle New hValueStyle value. Default value is null
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public Slider setHValueStyle(String hValueStyle)  throws IllegalStateException {
        return (Slider)setAttribute("hValueStyle", hValueStyle, false);
    }

    /**
     * Optional CSS style for the floating {@link com.smartgwt.client.widgets.Slider#getValueLabel valueLabel}, visible when
     * {@link com.smartgwt.client.widgets.Slider#getShowValue showValue} is true and {@link
     * com.smartgwt.client.widgets.Slider#getVertical vertical} is false.
     *
     * @return Current hValueStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getHValueStyle()  {
        return getAttributeAsString("hValueStyle");
    }
    

    /**
     * The height of the labels used to display the  {@link com.smartgwt.client.widgets.Slider#getRangeLabel minimum, maximum}
     * and {@link com.smartgwt.client.widgets.Slider#getValueLabel current} values  of the slider.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.Slider#getLabelHeight labelHeight} property of the slider
     *
     * @param labelHeight new label height. Default value is 20
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     */
    public Slider setLabelHeight(int labelHeight) {
        return (Slider)setAttribute("labelHeight", labelHeight, true);
    }

    /**
     * The height of the labels used to display the  {@link com.smartgwt.client.widgets.Slider#getRangeLabel minimum, maximum}
     * and {@link com.smartgwt.client.widgets.Slider#getValueLabel current} values  of the slider.
     *
     * @return Current labelHeight value. Default value is 20
     */
    public int getLabelHeight()  {
        return getAttributeAsInt("labelHeight");
    }
    

    /**
     * The space around the labels used to display the  {@link com.smartgwt.client.widgets.Slider#getRangeLabel minimum,
     * maximum} and {@link com.smartgwt.client.widgets.Slider#getValueLabel current} values  of the slider.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.Slider#getLabelSpacing labelSpacing} property of the slider
     *
     * @param labelSpacing new label spacing. Default value is 5
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     */
    public Slider setLabelSpacing(int labelSpacing) {
        return (Slider)setAttribute("labelSpacing", labelSpacing, true);
    }

    /**
     * The space around the labels used to display the  {@link com.smartgwt.client.widgets.Slider#getRangeLabel minimum,
     * maximum} and {@link com.smartgwt.client.widgets.Slider#getValueLabel current} values  of the slider.
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
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     */
    public Slider setLabelWidth(int labelWidth) {
        return (Slider)setAttribute("labelWidth", labelWidth, true);
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
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     */
    public Slider setLength(int length) {
        return (Slider)setAttribute("length", length, true);
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
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Slider#setFlipValues
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#controls_category_slider" target="examples">Slider Example</a>
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public Slider setMaxValue(float maxValue) {
        return (Slider)setAttribute("maxValue", maxValue, true);
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
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Slider#setFlipValues
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#controls_category_slider" target="examples">Slider Example</a>
     */
    public Slider setMaxValue(double maxValue) {
        return (Slider)setAttribute("maxValue", maxValue, true);
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
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Slider#setShowRange
     * @see com.smartgwt.client.widgets.Slider#setMaxValue
     */
    public Slider setMaxValueLabel(String maxValueLabel) {
        return (Slider)setAttribute("maxValueLabel", maxValueLabel, true);
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
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Slider#setFlipValues
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#controls_category_slider" target="examples">Slider Example</a>
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public Slider setMinValue(float minValue) {
        return (Slider)setAttribute("minValue", minValue, true);
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
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Slider#setFlipValues
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#controls_category_slider" target="examples">Slider Example</a>
     */
    public Slider setMinValue(double minValue) {
        return (Slider)setAttribute("minValue", minValue, true);
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
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Slider#setShowRange
     * @see com.smartgwt.client.widgets.Slider#setMinValue
     */
    public Slider setMinValueLabel(String minValueLabel) {
        return (Slider)setAttribute("minValueLabel", minValueLabel, true);
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
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#controls_category_slider" target="examples">Slider Example</a>
     */
    public Slider setNumValues(Integer numValues) {
        return (Slider)setAttribute("numValues", numValues, true);
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
     * {@link com.smartgwt.client.docs.FormatString} for numeric formatting of the range labels.  If unset, defaults to  {@link
     * com.smartgwt.client.widgets.Slider#getValueFormat valueFormat}
     *
     * @param rangeFormat New rangeFormat value. Default value is null
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.FormatString FormatString 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Slider setRangeFormat(String rangeFormat)  throws IllegalStateException {
        return (Slider)setAttribute("rangeFormat", rangeFormat, false);
    }

    /**
     * {@link com.smartgwt.client.docs.FormatString} for numeric formatting of the range labels.  If unset, defaults to  {@link
     * com.smartgwt.client.widgets.Slider#getValueFormat valueFormat}
     *
     * @return Current rangeFormat value. Default value is null
     * @see com.smartgwt.client.docs.FormatString FormatString 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getRangeFormat()  {
        return getAttributeAsString("rangeFormat");
    }
    

    /**
     * <b>Note :</b> This API is non-functional (always returns null) and exists only to make
     * you aware that this MultiAutoChild exists.  See {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}
     * for details.
     * <p>
     * Used to create both of the min and max range-labels, via the {@link com.smartgwt.client.types.AutoChild} pattern, hence
     * <code>rangeLabelConstructor</code>, <code>rangeLabelDefaults</code> and <code>rangeLabelProperties</code> are valid.
     *
     * @return null
     */
    public Label getRangeLabel()  {
        return null;
    }
    

    /**
     * CSS style for the {@link com.smartgwt.client.widgets.Slider#getRangeLabel min and max} range-labels, when  {@link
     * com.smartgwt.client.widgets.Slider#getShowRange showRange} is true.
     *
     * @param rangeStyle New rangeStyle value. Default value is "sliderRange"
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public Slider setRangeStyle(String rangeStyle)  throws IllegalStateException {
        return (Slider)setAttribute("rangeStyle", rangeStyle, false);
    }

    /**
     * CSS style for the {@link com.smartgwt.client.widgets.Slider#getRangeLabel min and max} range-labels, when  {@link
     * com.smartgwt.client.widgets.Slider#getShowRange showRange} is true.
     *
     * @return Current rangeStyle value. Default value is "sliderRange"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getRangeStyle()  {
        return getAttributeAsString("rangeStyle");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.Slider#getRoundValues roundValues} is false, the slider value will be rounded to
     * this number of decimal places. If set to null the value will not be rounded
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.Slider#getRoundPrecision roundPrecision} property of the slider
     *
     * @param roundPrecision new round precision. Default value is 1
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     */
    public Slider setRoundPrecision(int roundPrecision) {
        return (Slider)setAttribute("roundPrecision", roundPrecision, true);
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
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     */
    public Slider setRoundValues(Boolean roundValues) {
        return (Slider)setAttribute("roundValues", roundValues, true);
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
     * Whether to show the {@link com.smartgwt.client.widgets.Slider#getActiveTrack activeTrack}, which highlights the 'active'
     *  portion of a slider, from its minimum to its current {@link com.smartgwt.client.widgets.Slider#getValue value}.
     *
     * @param showActiveTrack New showActiveTrack value. Default value is false
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Slider setShowActiveTrack(Boolean showActiveTrack)  throws IllegalStateException {
        return (Slider)setAttribute("showActiveTrack", showActiveTrack, false);
    }

    /**
     * Whether to show the {@link com.smartgwt.client.widgets.Slider#getActiveTrack activeTrack}, which highlights the 'active'
     *  portion of a slider, from its minimum to its current {@link com.smartgwt.client.widgets.Slider#getValue value}.
     *
     * @return Current showActiveTrack value. Default value is false
     */
    public Boolean getShowActiveTrack()  {
        Boolean result = getAttributeAsBoolean("showActiveTrack");
        return result == null ? false : result;
    }
    

    /**
     * Indicates whether labels for the {@link com.smartgwt.client.widgets.Slider#getRangeLabel min and max values} of the 
     * slider should be displayed. The default positions for these labels are below the  start/end of a horizontal slider, or
     * to the right of the start/end of a  {@link com.smartgwt.client.widgets.Slider#getVertical vertical} slider.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.Slider#getShowRange showRange} property of the slider
     *
     * @param showRange show the slider range?. Default value is true
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Slider#setMinValueLabel
     * @see com.smartgwt.client.widgets.Slider#setMaxValueLabel
     */
    public Slider setShowRange(Boolean showRange) {
        return (Slider)setAttribute("showRange", showRange, true);
    }

    /**
     * Indicates whether labels for the {@link com.smartgwt.client.widgets.Slider#getRangeLabel min and max values} of the 
     * slider should be displayed. The default positions for these labels are below the  start/end of a horizontal slider, or
     * to the right of the start/end of a  {@link com.smartgwt.client.widgets.Slider#getVertical vertical} slider.
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
     * Indicates whether the slider's {@link com.smartgwt.client.widgets.Slider#getTitle title} should be displayed. The 
     * default position for the title-label is to the left of a horizontal slider, or above a  {@link
     * com.smartgwt.client.widgets.Slider#getVertical vertical} slider.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.Slider#getShowTitle showTitle} property of the slider
     *
     * @param showTitle show the slider title?. Default value is true
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Slider#setTitle
     */
    public Slider setShowTitle(Boolean showTitle) {
        return (Slider)setAttribute("showTitle", showTitle, true);
    }

    /**
     * Indicates whether the slider's {@link com.smartgwt.client.widgets.Slider#getTitle title} should be displayed. The 
     * default position for the title-label is to the left of a horizontal slider, or above a  {@link
     * com.smartgwt.client.widgets.Slider#getVertical vertical} slider.
     *
     * @return Current showTitle value. Default value is true
     * @see com.smartgwt.client.widgets.Slider#getTitle
     */
    public Boolean getShowTitle()  {
        Boolean result = getAttributeAsBoolean("showTitle");
        return result == null ? true : result;
    }
    

    /**
     * Indicates whether a {@link com.smartgwt.client.widgets.Slider#getValueLabel label} for the value of the slider should 
     * be displayed. The default position for this label is to the right of a  {@link
     * com.smartgwt.client.widgets.Slider#getVertical vertical} slider,  or below a horizontal slider.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.Slider#getShowValue showValue} property of the slider
     *
     * @param showValue show the slider value?. Default value is true
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Slider#setValue
     */
    public Slider setShowValue(Boolean showValue) {
        return (Slider)setAttribute("showValue", showValue, true);
    }

    /**
     * Indicates whether a {@link com.smartgwt.client.widgets.Slider#getValueLabel label} for the value of the slider should 
     * be displayed. The default position for this label is to the right of a  {@link
     * com.smartgwt.client.widgets.Slider#getVertical vertical} slider,  or below a horizontal slider.
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
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public Slider setStepPercent(float stepPercent) {
        return (Slider)setAttribute("stepPercent", stepPercent, true);
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
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     */
    public Slider setStepPercent(double stepPercent) {
        return (Slider)setAttribute("stepPercent", stepPercent, true);
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
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     */
    public Slider setThumbSrc(String thumbSrc) {
        return (Slider)setAttribute("thumbSrc", thumbSrc, true);
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
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     */
    public Slider setThumbThickWidth(int thumbThickWidth) {
        return (Slider)setAttribute("thumbThickWidth", thumbThickWidth, true);
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
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     */
    public Slider setThumbThinWidth(int thumbThinWidth) {
        return (Slider)setAttribute("thumbThinWidth", thumbThinWidth, true);
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
     * The space between the {@link com.smartgwt.client.widgets.Slider#getShowTitle title} and the track.
     *
     * @param titleSpacing New titleSpacing value. Default value is 5
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     */
    public Slider setTitleSpacing(int titleSpacing) {
        return (Slider)setAttribute("titleSpacing", titleSpacing, true);
    }

    /**
     * The space between the {@link com.smartgwt.client.widgets.Slider#getShowTitle title} and the track.
     *
     * @return Current titleSpacing value. Default value is 5
     */
    public int getTitleSpacing()  {
        return getAttributeAsInt("titleSpacing");
    }
    

    /**
     * CSS style for the {@link com.smartgwt.client.widgets.Slider#getTitle title-text}, when  {@link
     * com.smartgwt.client.widgets.Slider#getShowTitle showTitle} is true.
     *
     * @param titleStyle New titleStyle value. Default value is "sliderTitle"
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public Slider setTitleStyle(String titleStyle)  throws IllegalStateException {
        return (Slider)setAttribute("titleStyle", titleStyle, false);
    }

    /**
     * CSS style for the {@link com.smartgwt.client.widgets.Slider#getTitle title-text}, when  {@link
     * com.smartgwt.client.widgets.Slider#getShowTitle showTitle} is true.
     *
     * @return Current titleStyle value. Default value is "sliderTitle"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getTitleStyle()  {
        return getAttributeAsString("titleStyle");
    }
    

    /**
     * The height of {@link com.smartgwt.client.widgets.Slider#getVertical vertical} slider start and end images, or width of 
     * horizontal slider start and end images.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.Slider#getTrackCapSize trackCapSize} property of the slider
     *
     * @param trackCapSize new trackCapSize. Default value is 6
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     */
    public Slider setTrackCapSize(int trackCapSize) {
        return (Slider)setAttribute("trackCapSize", trackCapSize, true);
    }

    /**
     * The height of {@link com.smartgwt.client.widgets.Slider#getVertical vertical} slider start and end images, or width of 
     * horizontal slider start and end images.
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
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     * @see com.smartgwt.client.types.ImageStyle
     * @see com.smartgwt.client.widgets.StretchImg#setImageType
     */
    public Slider setTrackImageType(ImageStyle trackImageType) {
        return (Slider)setAttribute("trackImageType", trackImageType == null ? null : trackImageType.getValue(), true);
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
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Slider#setTrackImageType
     */
    public Slider setTrackSrc(String trackSrc) {
        return (Slider)setAttribute("trackSrc", trackSrc, true);
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
     * The thickness of the track. This is the width, for a {@link com.smartgwt.client.widgets.Slider#getVertical vertical} 
     * slider, or the height, for a horizontal slider.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.Slider#getTrackWidth trackWidth} property of the slider
     *
     * @param trackWidth new trackWidth. Default value is 7
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     */
    public Slider setTrackWidth(int trackWidth) {
        return (Slider)setAttribute("trackWidth", trackWidth, true);
    }

    /**
     * The thickness of the track. This is the width, for a {@link com.smartgwt.client.widgets.Slider#getVertical vertical} 
     * slider, or the height, for a horizontal slider.
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
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Slider#setMinValue
     * @see com.smartgwt.client.widgets.Slider#setMaxValue
     * @see com.smartgwt.client.widgets.Slider#setFlipValues
     * @see com.smartgwt.client.widgets.Slider#setShowValue
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public Slider setValue(float value) {
        return (Slider)setAttribute("value", value, true);
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
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Slider#setMinValue
     * @see com.smartgwt.client.widgets.Slider#setMaxValue
     * @see com.smartgwt.client.widgets.Slider#setFlipValues
     * @see com.smartgwt.client.widgets.Slider#setShowValue
     */
    public Slider setValue(double value) {
        return (Slider)setAttribute("value", value, true);
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
     * {@link com.smartgwt.client.docs.FormatString} for numeric formatting of the value and range labels.
     *
     * @param valueFormat New valueFormat value. Default value is null
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.FormatString FormatString 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Slider setValueFormat(String valueFormat)  throws IllegalStateException {
        return (Slider)setAttribute("valueFormat", valueFormat, false);
    }

    /**
     * {@link com.smartgwt.client.docs.FormatString} for numeric formatting of the value and range labels.
     *
     * @return Current valueFormat value. Default value is null
     * @see com.smartgwt.client.docs.FormatString FormatString 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getValueFormat()  {
        return getAttributeAsString("valueFormat");
    }
    

    /**
     * {@link com.smartgwt.client.types.AutoChild} displaying the current value as a floating label when  {@link
     * com.smartgwt.client.widgets.Slider#getShowValue showValue} is true.
     * <p>
     * This component is an AutoChild named "valueLabel".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current valueLabel value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Label getValueLabel() throws IllegalStateException {
        errorIfNotCreated("valueLabel");
        return (Label)Label.getByJSObject(getAttributeAsJavaScriptObject("valueLabel"));
    }
    

    /**
     * CSS style for the floating {@link com.smartgwt.client.widgets.Slider#getValueLabel valueLabel}, visible when {@link
     * com.smartgwt.client.widgets.Slider#getShowValue showValue} is true.
     *
     * @param valueStyle New valueStyle value. Default value is "sliderValue"
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public Slider setValueStyle(String valueStyle)  throws IllegalStateException {
        return (Slider)setAttribute("valueStyle", valueStyle, false);
    }

    /**
     * CSS style for the floating {@link com.smartgwt.client.widgets.Slider#getValueLabel valueLabel}, visible when {@link
     * com.smartgwt.client.widgets.Slider#getShowValue showValue} is true.
     *
     * @return Current valueStyle value. Default value is "sliderValue"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getValueStyle()  {
        return getAttributeAsString("valueStyle");
    }
    

    /**
     * CSS style for the text in the floating {@link com.smartgwt.client.widgets.Slider#getValueLabel valueLabel},  visible
     * when {@link com.smartgwt.client.widgets.Slider#getShowValue showValue} is true.
     *
     * @param valueTextStyle New valueTextStyle value. Default value is "sliderValueText"
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public Slider setValueTextStyle(String valueTextStyle)  throws IllegalStateException {
        return (Slider)setAttribute("valueTextStyle", valueTextStyle, false);
    }

    /**
     * CSS style for the text in the floating {@link com.smartgwt.client.widgets.Slider#getValueLabel valueLabel},  visible
     * when {@link com.smartgwt.client.widgets.Slider#getShowValue showValue} is true.
     *
     * @return Current valueTextStyle value. Default value is "sliderValueText"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getValueTextStyle()  {
        return getAttributeAsString("valueTextStyle");
    }
    

    /**
     * Indicates whether this is a vertical or horizontal slider.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.Slider#getVertical vertical} property of the slider
     *
     * @param vertical is the slider vertical. Default value is true
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#controls_category_slider" target="examples">Slider Example</a>
     */
    public Slider setVertical(Boolean vertical) {
        return (Slider)setAttribute("vertical", vertical, true);
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
     * The space around the labels used to display the  {@link com.smartgwt.client.widgets.Slider#getRangeLabel minimum,
     * maximum} and {@link com.smartgwt.client.widgets.Slider#getValueLabel current} values  of the slider, when {@link
     * com.smartgwt.client.widgets.Slider#getVertical vertical} is true.  If unset, defaults to  {@link
     * com.smartgwt.client.widgets.Slider#getLabelSpacing labelSpacing}.
     *
     * @param vLabelSpacing New vLabelSpacing value. Default value is null
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     */
    public Slider setVLabelSpacing(Integer vLabelSpacing) {
        return (Slider)setAttribute("vLabelSpacing", vLabelSpacing, true);
    }

    /**
     * The space around the labels used to display the  {@link com.smartgwt.client.widgets.Slider#getRangeLabel minimum,
     * maximum} and {@link com.smartgwt.client.widgets.Slider#getValueLabel current} values  of the slider, when {@link
     * com.smartgwt.client.widgets.Slider#getVertical vertical} is true.  If unset, defaults to  {@link
     * com.smartgwt.client.widgets.Slider#getLabelSpacing labelSpacing}.
     *
     * @return Current vLabelSpacing value. Default value is null
     */
    public Integer getVLabelSpacing()  {
        return getAttributeAsInt("vLabelSpacing");
    }
    

    /**
     * Optional CSS style for the thumb for a {@link com.smartgwt.client.widgets.Slider#getVertical vertically oriented} 
     * slider.  See {@link com.smartgwt.client.widgets.Slider#getHThumbStyle hThumbStyle} for state suffixes.
     *
     * @param vThumbStyle New vThumbStyle value. Default value is null
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public Slider setVThumbStyle(String vThumbStyle)  throws IllegalStateException {
        return (Slider)setAttribute("vThumbStyle", vThumbStyle, false);
    }

    /**
     * Optional CSS style for the thumb for a {@link com.smartgwt.client.widgets.Slider#getVertical vertically oriented} 
     * slider.  See {@link com.smartgwt.client.widgets.Slider#getHThumbStyle hThumbStyle} for state suffixes.
     *
     * @return Current vThumbStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getVThumbStyle()  {
        return getAttributeAsString("vThumbStyle");
    }
    

    /**
     * Optional CSS style for the track for a {@link com.smartgwt.client.widgets.Slider#getVertical vertically oriented} 
     * slider. <P> Will have the suffix "Disabled" added when the slider is disabled.
     *
     * @param vTrackStyle New vTrackStyle value. Default value is null
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public Slider setVTrackStyle(String vTrackStyle)  throws IllegalStateException {
        return (Slider)setAttribute("vTrackStyle", vTrackStyle, false);
    }

    /**
     * Optional CSS style for the track for a {@link com.smartgwt.client.widgets.Slider#getVertical vertically oriented} 
     * slider. <P> Will have the suffix "Disabled" added when the slider is disabled.
     *
     * @return Current vTrackStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getVTrackStyle()  {
        return getAttributeAsString("vTrackStyle");
    }
    

    /**
     * Optional CSS style for the floating {@link com.smartgwt.client.widgets.Slider#getValueLabel valueLabel}, visible when
     * {@link com.smartgwt.client.widgets.Slider#getShowValue showValue} is true and {@link
     * com.smartgwt.client.widgets.Slider#getVertical vertical} is true.
     *
     * @param vValueStyle New vValueStyle value. Default value is null
     * @return {@link com.smartgwt.client.widgets.Slider Slider} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public Slider setVValueStyle(String vValueStyle)  throws IllegalStateException {
        return (Slider)setAttribute("vValueStyle", vValueStyle, false);
    }

    /**
     * Optional CSS style for the floating {@link com.smartgwt.client.widgets.Slider#getValueLabel valueLabel}, visible when
     * {@link com.smartgwt.client.widgets.Slider#getShowValue showValue} is true and {@link
     * com.smartgwt.client.widgets.Slider#getVertical vertical} is true.
     *
     * @return Current vValueStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getVValueStyle()  {
        return getAttributeAsString("vValueStyle");
    }
    

    // ********************* Methods ***********************
    /**
     * Add a valueChanged handler.
     * <p>
     * This method is called when the slider value changes. This occurs when the {@link
     * com.smartgwt.client.widgets.Slider#setValue setValue()} method is called, or when the slider is moved. Add a
     * notification to be fired whenever the slider value changes.
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
            s.hLabelSpacing = getAttributeAsString("hLabelSpacing");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.hLabelSpacing:" + t.getMessage() + "\n";
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
            s.hValueStyle = getAttributeAsString("hValueStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.hValueStyle:" + t.getMessage() + "\n";
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
            s.rangeFormat = getAttributeAsString("rangeFormat");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.rangeFormat:" + t.getMessage() + "\n";
        }
        try {
            s.rangeStyle = getAttributeAsString("rangeStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.rangeStyle:" + t.getMessage() + "\n";
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
            s.titleStyle = getAttributeAsString("titleStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.titleStyle:" + t.getMessage() + "\n";
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
            s.valueFormat = getAttributeAsString("valueFormat");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.valueFormat:" + t.getMessage() + "\n";
        }
        try {
            s.valueStyle = getAttributeAsString("valueStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.valueStyle:" + t.getMessage() + "\n";
        }
        try {
            s.valueTextStyle = getAttributeAsString("valueTextStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.valueTextStyle:" + t.getMessage() + "\n";
        }
        try {
            s.vertical = getAttributeAsString("vertical");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.vertical:" + t.getMessage() + "\n";
        }
        try {
            s.vLabelSpacing = getAttributeAsString("vLabelSpacing");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.vLabelSpacing:" + t.getMessage() + "\n";
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
        try {
            s.vValueStyle = getAttributeAsString("vValueStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Slider.vValueStyle:" + t.getMessage() + "\n";
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
