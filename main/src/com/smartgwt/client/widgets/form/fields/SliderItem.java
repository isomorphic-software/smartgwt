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
 
package com.smartgwt.client.widgets.form.fields;


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


/**
 * FormItem that uses a {@link com.smartgwt.client.widgets.Slider} component to present an interface for picking from
 * either a continuous range or a range with a small number of discrete values.
 */
@BeanFactory.FrameworkClass
public class SliderItem extends CanvasItem {

    public static SliderItem getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof SliderItem) {
            existingObj.setJsObj(jsObj);
            return (SliderItem)existingObj;
        } else

        {
            return new SliderItem(jsObj);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(SliderItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.SliderItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(SliderItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.SliderItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public static native void changePickerIconDefaults(FormItemIcon defaults) /*-{
        $wnd.isc.SliderItem.changeDefaults("pickerIconDefaults", defaults.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public SliderItem(){
        setAttribute("editorType", "SliderItem");
    }

    public SliderItem(JavaScriptObject jsObj){
        super(jsObj);
    }


    public SliderItem(String name) {
        setName(name);
                setAttribute("editorType", "SliderItem");
    }


    public SliderItem(String name, String title) {
        setName(name);
		setTitle(title);
                setAttribute("editorType", "SliderItem");
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Should this sliderItem update its value and fire change handlers while the user is actively dragging the slider. Setting
     * this attribute value to <code>false</code> will suppress any change notifications from the user dragging the slider
     * thumb until the user releases the mouse at the final position. This can be useful to avoid repeatedly firing expensive
     * operations such as server fetches while the user drags through a range of values.
     *
     * @param changeOnDrag New changeOnDrag value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.SliderItem SliderItem} instance, for chaining setter calls
     */
    public SliderItem setChangeOnDrag(Boolean changeOnDrag) {
        return (SliderItem)setAttribute("changeOnDrag", changeOnDrag);
    }

    /**
     * Should this sliderItem update its value and fire change handlers while the user is actively dragging the slider. Setting
     * this attribute value to <code>false</code> will suppress any change notifications from the user dragging the slider
     * thumb until the user releases the mouse at the final position. This can be useful to avoid repeatedly firing expensive
     * operations such as server fetches while the user drags through a range of values.
     *
     * @return Current changeOnDrag value. Default value is true
     */
    public Boolean getChangeOnDrag()  {
        Boolean result = getAttributeAsBoolean("changeOnDrag", true);
        return result == null ? true : result;
    }
    

    /**
     * Default value for this sliderItems is 1.
     *
     * @param defaultValue New defaultValue value. Default value is 1
     * @return {@link com.smartgwt.client.widgets.form.fields.SliderItem SliderItem} instance, for chaining setter calls
     */
    public SliderItem setDefaultValue(double defaultValue) {
        return (SliderItem)setAttribute("defaultValue", defaultValue);
    }

    /**
     * Default value for this sliderItems is 1.
     *
     * @return Current defaultValue value. Default value is 1
     */
    public double getDefaultValue()  {
        return getAttributeAsDouble("defaultValue");
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
     * @return {@link com.smartgwt.client.widgets.form.fields.SliderItem SliderItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Slider#setFlipValues
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_controls_various" target="examples">Number - Slider Example</a>
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public SliderItem setMaxValue(float maxValue) {
        return (SliderItem)setAttribute("maxValue", maxValue);
    }

    /**
     * The maximum slider value. The slider value is equal to maxValue when the thumb is at the top or right of the slider
     * (unless flipValues is true, in which case the maximum value is at the bottom/left of the slider)
     *
     * @return Current maxValue value. Default value is 100
     * @see com.smartgwt.client.widgets.Slider#getFlipValues
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_controls_various" target="examples">Number - Slider Example</a>
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
     * @return {@link com.smartgwt.client.widgets.form.fields.SliderItem SliderItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Slider#setFlipValues
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_controls_various" target="examples">Number - Slider Example</a>
     */
    public SliderItem setMaxValue(double maxValue) {
        return (SliderItem)setAttribute("maxValue", maxValue);
    }

    /**
     * The maximum slider value. The slider value is equal to maxValue when the thumb is at the top or right of the slider
     * (unless flipValues is true, in which case the maximum value is at the bottom/left of the slider)
     *
     * @return Current maxValue value. Default value is 100
     * @see com.smartgwt.client.widgets.Slider#getFlipValues
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_controls_various" target="examples">Number - Slider Example</a>
     */
    public double getMaxValueAsDouble()  {
        return getAttributeAsDouble("maxValue");
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
     * @return {@link com.smartgwt.client.widgets.form.fields.SliderItem SliderItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Slider#setFlipValues
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_controls_various" target="examples">Number - Slider Example</a>
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public SliderItem setMinValue(float minValue) {
        return (SliderItem)setAttribute("minValue", minValue);
    }

    /**
     * The minimum slider value. The slider value is equal to minValue when the thumb is at the bottom or left of the slider
     * (unless flipValues is true, in which case the minimum value is at the top/right of the slider)
     *
     * @return Current minValue value. Default value is 1
     * @see com.smartgwt.client.widgets.Slider#getFlipValues
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_controls_various" target="examples">Number - Slider Example</a>
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
     * @return {@link com.smartgwt.client.widgets.form.fields.SliderItem SliderItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Slider#setFlipValues
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_controls_various" target="examples">Number - Slider Example</a>
     */
    public SliderItem setMinValue(double minValue) {
        return (SliderItem)setAttribute("minValue", minValue);
    }

    /**
     * The minimum slider value. The slider value is equal to minValue when the thumb is at the bottom or left of the slider
     * (unless flipValues is true, in which case the minimum value is at the top/right of the slider)
     *
     * @return Current minValue value. Default value is 1
     * @see com.smartgwt.client.widgets.Slider#getFlipValues
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_controls_various" target="examples">Number - Slider Example</a>
     */
    public double getMinValueAsDouble()  {
        return getAttributeAsDouble("minValue");
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
     * @return {@link com.smartgwt.client.widgets.form.fields.SliderItem SliderItem} instance, for chaining setter calls
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_controls_various" target="examples">Number - Slider Example</a>
     */
    public SliderItem setNumValues(Integer numValues) {
        return (SliderItem)setAttribute("numValues", numValues);
    }

    /**
     * The number of discrete values represented by slider. If specified, the range of valid values (between
     * <code>minValue</code> and <code>maxValue</code>) will be divided into this many steps. As the thumb is moved along the
     * track it will only select these values and appear to jump between the steps.
     *
     * @return Current numValues value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_controls_various" target="examples">Number - Slider Example</a>
     */
    public Integer getNumValues()  {
        return getAttributeAsInt("numValues");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.Slider#getRoundValues Slider.roundValues} is false, the slider value will be
     * rounded to this number of decimal places. If set to null the value will not be rounded
     *
     * @param roundPrecision New roundPrecision value. Default value is 1
     * @return {@link com.smartgwt.client.widgets.form.fields.SliderItem SliderItem} instance, for chaining setter calls
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_controls_various" target="examples">Number - Slider Example</a>
     */
    public SliderItem setRoundPrecision(int roundPrecision) {
        return (SliderItem)setAttribute("roundPrecision", roundPrecision);
    }

    /**
     * If {@link com.smartgwt.client.widgets.Slider#getRoundValues Slider.roundValues} is false, the slider value will be
     * rounded to this number of decimal places. If set to null the value will not be rounded
     *
     * @return Current roundPrecision value. Default value is 1
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_controls_various" target="examples">Number - Slider Example</a>
     */
    public int getRoundPrecision()  {
        return getAttributeAsInt("roundPrecision");
    }
    

    /**
     * Specifies whether the slider value should be rounded to the nearest integer.  If set to false, values will be rounded to
     * a fixed number of decimal places controlled by {@link
     * com.smartgwt.client.widgets.form.fields.SliderItem#getRoundPrecision roundPrecision}.
     *
     * @param roundValues New roundValues value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.SliderItem SliderItem} instance, for chaining setter calls
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_controls_various" target="examples">Number - Slider Example</a>
     */
    public SliderItem setRoundValues(Boolean roundValues) {
        return (SliderItem)setAttribute("roundValues", roundValues);
    }

    /**
     * Specifies whether the slider value should be rounded to the nearest integer.  If set to false, values will be rounded to
     * a fixed number of decimal places controlled by {@link
     * com.smartgwt.client.widgets.form.fields.SliderItem#getRoundPrecision roundPrecision}.
     *
     * @return Current roundValues value. Default value is true
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_controls_various" target="examples">Number - Slider Example</a>
     */
    public Boolean getRoundValues()  {
        Boolean result = getAttributeAsBoolean("roundValues", true);
        return result == null ? true : result;
    }
    

    /**
     * Should this item's value be saved in the form's values and hence returned from {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValues form.getValues()}? <p> <code>shouldSaveValue:false</code> is used
     * to mark formItems which do not correspond to the underlying data model and should not save a value into the form's
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getValues values}.  Example includes visual separators, password
     * re-type fields, or checkboxes used to show/hide other form items. <p> A <code>shouldSaveValue:false</code> item should
     * be given a value either via {@link com.smartgwt.client.widgets.form.fields.FormItem#getDefaultValue
     * FormItem.defaultValue} or by calling {@link com.smartgwt.client.widgets.form.DynamicForm#setValue form.setValue(item,
     * value)} or  {@link com.smartgwt.client.widgets.form.fields.FormItem#setValue formItem.setValue(value)}.  Providing a
     * value via {@link com.smartgwt.client.widgets.form.DynamicForm#getValues form.values} or {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setValues form.setValues()}  will automatically switch the item to
     * <code>shouldSaveValue:true</code>. <P> Note that <ul> <li>if an item is shouldSaveValue true, but has no name, a warning
     * is logged, and      shouldSaveValue will be set to false. </li></ul>
     *
     * @param shouldSaveValue New shouldSaveValue value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.SliderItem SliderItem} instance, for chaining setter calls
     */
    public SliderItem setShouldSaveValue(Boolean shouldSaveValue) {
        return (SliderItem)setAttribute("shouldSaveValue", shouldSaveValue);
    }

    /**
     * Should this item's value be saved in the form's values and hence returned from {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValues form.getValues()}? <p> <code>shouldSaveValue:false</code> is used
     * to mark formItems which do not correspond to the underlying data model and should not save a value into the form's
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getValues values}.  Example includes visual separators, password
     * re-type fields, or checkboxes used to show/hide other form items. <p> A <code>shouldSaveValue:false</code> item should
     * be given a value either via {@link com.smartgwt.client.widgets.form.fields.FormItem#getDefaultValue
     * FormItem.defaultValue} or by calling {@link com.smartgwt.client.widgets.form.DynamicForm#setValue form.setValue(item,
     * value)} or  {@link com.smartgwt.client.widgets.form.fields.FormItem#setValue formItem.setValue(value)}.  Providing a
     * value via {@link com.smartgwt.client.widgets.form.DynamicForm#getValues form.values} or {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setValues form.setValues()}  will automatically switch the item to
     * <code>shouldSaveValue:true</code>. <P> Note that <ul> <li>if an item is shouldSaveValue true, but has no name, a warning
     * is logged, and      shouldSaveValue will be set to false. </li></ul>
     *
     * @return Current shouldSaveValue value. Default value is true
     */
    public Boolean getShouldSaveValue()  {
        Boolean result = getAttributeAsBoolean("shouldSaveValue", true);
        return result == null ? true : result;
    }
    

    /**
     * This item is an autoChild generated {@link com.smartgwt.client.widgets.Canvas} displayed by the SliderItem and is an
     * instance of {@link com.smartgwt.client.widgets.Slider} by default. It is customizable  via the standard {@link
     * com.smartgwt.client.types.AutoChild} pattern, by customizing {@link
     * com.smartgwt.client.widgets.form.fields.SliderItem#getSliderProperties sliderProperties} and {@link
     * com.smartgwt.client.widgets.form.fields.SliderItem#getSliderConstructor sliderConstructor}.
     * <p>
     * This component is an AutoChild named "slider".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current slider value. Default value is null
     */
    public Canvas getSlider()  {
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("slider"));
    }
    
    
    

    /**
     * Indicates whether this is a vertical or horizontal slider.
     *
     * @param vertical New vertical value. Default value is false
     * @return {@link com.smartgwt.client.widgets.form.fields.SliderItem SliderItem} instance, for chaining setter calls
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#controls_category_slider" target="examples">Slider Example</a>
     */
    public SliderItem setVertical(Boolean vertical) {
        return (SliderItem)setAttribute("vertical", vertical);
    }

    /**
     * Indicates whether this is a vertical or horizontal slider.
     *
     * @return Current vertical value. Default value is false
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#controls_category_slider" target="examples">Slider Example</a>
     */
    public Boolean getVertical()  {
        Boolean result = getAttributeAsBoolean("vertical", true);
        return result == null ? false : result;
    }
    

    /**
     * Default width of this item.
     *
     * @param width New width value. Default value is 150
     * @return {@link com.smartgwt.client.widgets.form.fields.SliderItem SliderItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public SliderItem setWidth(int width) {
        return (SliderItem)setAttribute("width", width);
    }

    /**
     * Default width of this item.
     *
     * @return Current width value. Default value is 150
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getWidth()  {
        return getAttributeAsInt("width");
    }
    

    // ********************* Methods ***********************
	/**
     * Notification method called when {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPending showPending} is
     * enabled and this <code>SliderItem</code> should either clear or show its pending visual state. <p> The default behavior
     * is that the {@link com.smartgwt.client.widgets.form.fields.FormItem#getTitleStyle titleStyle} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCellStyle cellStyle} are updated to include/exclude the "Pending"
     * suffix. In addition, when displayed in the pending state the value label changes color. Returning <code>false</code>
     * will cancel this default behavior.
     * @param form the managing <code>DynamicForm</code> instance.
     * @param item the form item itself (also available as "this").
     * @param pendingStatus <code>true</code> if the item should show its pending visual state; <code>false</code> otherwise.
     * @param newValue the current form item value.
     * @param value the value that would be restored by a call to {@link com.smartgwt.client.widgets.form.DynamicForm#resetValues
     * DynamicForm.resetValues()}.
     *
     * @return <code>false</code> to cancel the default behavior.
     * 
     */
    public native boolean pendingStatusChanged(DynamicForm form, FormItem item, boolean pendingStatus, Object newValue, Object value) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.pendingStatusChanged(form == null ? null : form.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), item.@com.smartgwt.client.core.DataClass::getJsObj()(), pendingStatus, newValue, value);
        return ret == null ? false : ret;
    }-*/;


    // ********************* Static Methods ***********************

    /** 
     * Class level method to set the default properties of this class.  If set, then all
     * existing and subsequently created instances of this class will automatically have
     * default properties corresponding to
     * the properties of the class instance passed to this function.
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
     * @param sliderItemProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(SliderItem sliderItemProperties) /*-{
        if (sliderItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(SliderItem.@java.lang.Object::getClass()(), "setDefaultProperties", sliderItemProperties.@java.lang.Object::getClass()());
        }
        sliderItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var properties = sliderItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::getConfig()();
        $wnd.isc.SliderItem.addProperties(properties);
    }-*/;

    // ***********************************************************




}
