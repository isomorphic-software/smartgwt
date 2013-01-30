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
 
package com.smartgwt.client.widgets;



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

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

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
public class Slider extends Canvas  implements com.smartgwt.client.widgets.events.HasValueChangedHandlers {

    public static Slider getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (Slider) obj;
        } else {
            return new Slider(jsObj);
        }
    }

    public Slider(){
        scClassName = "Slider";
    }

    public Slider(JavaScriptObject jsObj){
        super(jsObj);
    }

    public Slider(String title) {
        setTitle(title);
        scClassName = "Slider";
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
     * Should the thumb be animated to its new position when the value is changed programmatically, or by clicking in the
     * slider track.
     *
     * @param animateThumb animateThumb Default value is true
     */
    public void setAnimateThumb(Boolean animateThumb) {
        setAttribute("animateThumb", animateThumb, true);
    }

    /**
     * Should the thumb be animated to its new position when the value is changed programmatically, or by clicking in the
     * slider track.
     *
     *
     * @return Boolean
     */
    public Boolean getAnimateThumb()  {
        return getAttributeAsBoolean("animateThumb");
    }

    /**
     * If thumb animation is enabled, should the thumb be animated to its initial value?
     *
     * @param animateThumbInit animateThumbInit Default value is false
     */
    public void setAnimateThumbInit(Boolean animateThumbInit) {
        setAttribute("animateThumbInit", animateThumbInit, true);
    }

    /**
     * If thumb animation is enabled, should the thumb be animated to its initial value?
     *
     *
     * @return Boolean
     */
    public Boolean getAnimateThumbInit()  {
        return getAttributeAsBoolean("animateThumbInit");
    }

    /**
     * Duration of thumb animation, in milliseconds.
     *
     * @param animateThumbTime animateThumbTime Default value is 250
     */
    public void setAnimateThumbTime(int animateThumbTime) {
        setAttribute("animateThumbTime", animateThumbTime, true);
    }

    /**
     * Duration of thumb animation, in milliseconds.
     *
     *
     * @return int
     */
    public int getAnimateThumbTime()  {
        return getAttributeAsInt("animateThumbTime");
    }

    /**
     * Indicates whether keyboard manipulation of the slider is allowed.
     *
     * @param canFocus canFocus Default value is true
     */
    public void setCanFocus(Boolean canFocus) {
        setAttribute("canFocus", canFocus, true);
    }

    /**
     * Indicates whether keyboard manipulation of the slider is allowed.
     *
     *
     * @return Boolean
     */
    public Boolean getCanFocus()  {
        return getAttributeAsBoolean("canFocus");
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
     *
     * @return Boolean
     */
    public Boolean getFlipValues()  {
        return getAttributeAsBoolean("flipValues");
    }

    /**
     * Optional CSS style for the thumb for a horizontally oriented slider. <P> Will have the suffix "down" added when the
     * mouse is down on the thumb, and "Disabled" added when the slider is disabled.
     *
     * @param hThumbStyle hThumbStyle Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setHThumbStyle(String hThumbStyle)  throws IllegalStateException {
        setAttribute("hThumbStyle", hThumbStyle, false);
    }

    /**
     * Optional CSS style for the thumb for a horizontally oriented slider. <P> Will have the suffix "down" added when the
     * mouse is down on the thumb, and "Disabled" added when the slider is disabled.
     *
     *
     * @return String
     */
    public String getHThumbStyle()  {
        return getAttributeAsString("hThumbStyle");
    }

    /**
     * Optional CSS style for the track for a horizontally oriented slider. <P> Will have the suffix "Disabled" added when the
     * slider is disabled.
     *
     * @param hTrackStyle hTrackStyle Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setHTrackStyle(String hTrackStyle)  throws IllegalStateException {
        setAttribute("hTrackStyle", hTrackStyle, false);
    }

    /**
     * Optional CSS style for the track for a horizontally oriented slider. <P> Will have the suffix "Disabled" added when the
     * slider is disabled.
     *
     *
     * @return String
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
     *
     * @return int
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
     *
     * @return int
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
     *
     * @return int
     */
    public int getLabelWidth()  {
        return getAttributeAsInt("labelWidth");
    }

    /**
     * Used to set slider height if vertical, slider width if horizontal. Applied to the slider track, not necessarily the
     * entire widget. Overridden by an explicit width/height specification for the widget.
     *
     * @param length length Default value is 200
     */
    public void setLength(int length) {
        setAttribute("length", length, true);
    }

    /**
     * Used to set slider height if vertical, slider width if horizontal. Applied to the slider track, not necessarily the
     * entire widget. Overridden by an explicit width/height specification for the widget.
     *
     *
     * @return int
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
     * @param maxValue the new maximum value. Default value is 100
     * @see com.smartgwt.client.widgets.Slider#setFlipValues
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#controls_category_slider" target="examples">Slider Example</a>
     */
    public void setMaxValue(float maxValue) {
        setAttribute("maxValue", maxValue, true);
    }

    /**
     * The maximum slider value. The slider value is equal to maxValue when the thumb is at the top or right of the slider
     * (unless flipValues is true, in which case the maximum value is at the bottom/left of the slider)
     *
     *
     * @return float
     * @see com.smartgwt.client.widgets.Slider#getFlipValues
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#controls_category_slider" target="examples">Slider Example</a>
     */
    public float getMaxValue()  {
        return getAttributeAsFloat("maxValue");
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
     *
     * @return String
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
     * @param minValue the new minimum value. Default value is 1
     * @see com.smartgwt.client.widgets.Slider#setFlipValues
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#controls_category_slider" target="examples">Slider Example</a>
     */
    public void setMinValue(float minValue) {
        setAttribute("minValue", minValue, true);
    }

    /**
     * The minimum slider value. The slider value is equal to minValue when the thumb is at the bottom or left of the slider
     * (unless flipValues is true, in which case the minimum value is at the top/right of the slider)
     *
     *
     * @return float
     * @see com.smartgwt.client.widgets.Slider#getFlipValues
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#controls_category_slider" target="examples">Slider Example</a>
     */
    public float getMinValue()  {
        return getAttributeAsFloat("minValue");
    }

    /**
     * The text displayed in the label for the minimum value of the slider. If left as null, then slider.minValue will be
     * displayed.
     *
     * @param minValueLabel minValueLabel Default value is null
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
     *
     * @return String
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
     * @param numValues the new number of values. Default value is null
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
     *
     * @return Integer
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
     *
     * @return int
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
     *
     * @return Boolean
     */
    public Boolean getRoundValues()  {
        return getAttributeAsBoolean("roundValues");
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
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.Slider#getMinValueLabel
     * @see com.smartgwt.client.widgets.Slider#getMaxValueLabel
     */
    public Boolean getShowRange()  {
        return getAttributeAsBoolean("showRange");
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
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.Slider#getTitle
     */
    public Boolean getShowTitle()  {
        return getAttributeAsBoolean("showTitle");
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
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.Slider#getValue
     */
    public Boolean getShowValue()  {
        return getAttributeAsBoolean("showValue");
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
    public void setStepPercent(float stepPercent) {
        setAttribute("stepPercent", stepPercent, true);
    }

    /**
     * The percentage of the total slider that constitutes one discrete step. The slider will move one step when the
     * appropriate arrow key is pressed.
     *
     *
     * @return float
     */
    public float getStepPercent()  {
        return getAttributeAsFloat("stepPercent");
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
     *
     * @return String
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
     *
     * @return int
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
     *
     * @return int
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
     *
     * @return String
     * @see com.smartgwt.client.widgets.Slider#getShowTitle
     */
    public String getTitle()  {
        return getAttributeAsString("title");
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
     *
     * @return int
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
     *
     * @return ImageStyle
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
     *
     * @return String
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
     *
     * @return int
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
     * @param value the new value. Default value is 1
     * @see com.smartgwt.client.widgets.Slider#setMinValue
     * @see com.smartgwt.client.widgets.Slider#setMaxValue
     * @see com.smartgwt.client.widgets.Slider#setFlipValues
     * @see com.smartgwt.client.widgets.Slider#setShowValue
     */
    public void setValue(float value) {
        setAttribute("value", value, true);
    }

    /**
     * The slider value. This value should lie between the minValue and maxValue and increases as the thumb is moved up (for a
     * vertical slider) or right (for a horizontal slider) unless flipValues is set to true.
     *
     *
     * @return Returns the current slider value.
     * @see com.smartgwt.client.widgets.Slider#getMinValue
     * @see com.smartgwt.client.widgets.Slider#getMaxValue
     * @see com.smartgwt.client.widgets.Slider#getFlipValues
     * @see com.smartgwt.client.widgets.Slider#getShowValue
     */
    public float getValue()  {
        return getAttributeAsFloat("value");
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
     *
     * @return Boolean
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#controls_category_slider" target="examples">Slider Example</a>
     */
    public Boolean getVertical()  {
        return getAttributeAsBoolean("vertical");
    }

    /**
     * Optional CSS style for the thumb for a vertically oriented slider.  See {@link
     * com.smartgwt.client.widgets.Slider#getHThumbStyle hThumbStyle} for state suffixes.
     *
     * @param vThumbStyle vThumbStyle Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setVThumbStyle(String vThumbStyle)  throws IllegalStateException {
        setAttribute("vThumbStyle", vThumbStyle, false);
    }

    /**
     * Optional CSS style for the thumb for a vertically oriented slider.  See {@link
     * com.smartgwt.client.widgets.Slider#getHThumbStyle hThumbStyle} for state suffixes.
     *
     *
     * @return String
     */
    public String getVThumbStyle()  {
        return getAttributeAsString("vThumbStyle");
    }

    /**
     * Optional CSS style for the track for a vertically oriented slider. <P> Will have the suffix "Disabled" added when the
     * slider is disabled.
     *
     * @param vTrackStyle vTrackStyle Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setVTrackStyle(String vTrackStyle)  throws IllegalStateException {
        setAttribute("vTrackStyle", vTrackStyle, false);
    }

    /**
     * Optional CSS style for the track for a vertically oriented slider. <P> Will have the suffix "Disabled" added when the
     * slider is disabled.
     *
     *
     * @return String
     */
    public String getVTrackStyle()  {
        return getAttributeAsString("vTrackStyle");
    }

    // ********************* Methods ***********************
    /**
     * Add a valueChanged handler.
     * <p>
     * This method is called when the slider value changes. This occurs when the setValue method is called, or when the slider
     * is moved. Observe this method to be notified when the slider value changes.
     *
     * @param handler the valueChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addValueChangedHandler(com.smartgwt.client.widgets.events.ValueChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.events.ValueChangedEvent.getType()) == 0) setupValueChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.events.ValueChangedEvent.getType());
    }

    private native void setupValueChangedEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({valueChanged:$entry(function(){
                        var param = {"value" : arguments[0]};
                        var event = @com.smartgwt.client.widgets.events.ValueChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.valueChanged = $entry(function(){
                   var param = {"value" : arguments[0]};
                   var event = @com.smartgwt.client.widgets.events.ValueChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
               });
        }
   }-*/;
            
    /**
     * Call this method in your {@link com.smartgwt.client.widgets.Slider#addValueChangedHandler Slider.valueChanged} handler
     * to determine whether the value change is due to an ongoing drag interaction (true) or due to a thumb-release, mouse
     * click, keypress, or programmatic event (false). You may choose to execute temporary or partial updates while the slider
     * thumb is dragged, and final updates or persistence of the value in response to the other events.
     *
     * @return true if user is still dragging the slider thumb, false otherwise
     */
    public native Boolean valueIsChanging() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.valueIsChanging();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
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
     * @param sliderProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(Slider sliderProperties) /*-{
    	var properties = $wnd.isc.addProperties({},sliderProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.Slider.addProperties(properties);
    }-*/;
        
    // ***********************************************************        

}




