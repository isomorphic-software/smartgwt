/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
 
package com.smartgwt.client.widgets.form.fields;



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
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.EnumUtil;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
   /**
    * FormItem that uses a {@link com.smartgwt.client.widgets.Slider} component to present an interface for picking&#010 from either a continuous range or a range with a small number of discrete values.

    */
public class SliderItem extends CanvasItem {

    public static SliderItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (SliderItem) obj;
        } else {
            return new SliderItem(jsObj);
        }
    }


    public SliderItem(){
        setType("SliderItem");
    }

    public SliderItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public SliderItem(String name) {
        setName(name);
        setType("SliderItem");
    }

    public SliderItem(String name, String title) {
        setName(name);
		setTitle(title);
        setType("SliderItem");
    }

    // ********************* Properties / Attributes ***********************

    /**
    * Indicates whether this is a vertical or horizontal slider.
    *
    * @param vertical vertical Default value is false
    */
    public void setVertical(Boolean vertical) {
        setAttribute("vertical", vertical);
    }
    /**
     * Indicates whether this is a vertical or horizontal slider.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getVertical()  {
        return getAttributeAsBoolean("vertical");
    }

    /**
    * The minimum slider value. The slider value is equal to minValue when the thumb is at the&#010 bottom or left of the slider (unless flipValues is true, in which case the minimum value&#010 is at the top/right of the slider)
    * Sets the {@link com.smartgwt.client.widgets.Slider#getMinValue 'minimum value'} of the slider &#010&#010
    *
    * @param minValue the new minimum value. Default value is 1
    */
    public void setMinValue(float minValue) {
        setAttribute("minValue", minValue);
    }
    /**
     * The minimum slider value. The slider value is equal to minValue when the thumb is at the&#010 bottom or left of the slider (unless flipValues is true, in which case the minimum value&#010 is at the top/right of the slider)
     *
     *
     * @return float
     *
     */
    public float getMinValue()  {
        return getAttributeAsFloat("minValue");
    }

    /**
    * The maximum slider value. The slider value is equal to maxValue when the thumb is at the&#010 top or right of the slider (unless flipValues is true, in which case the maximum value&#010 is at the bottom/left of the slider)
    * Sets the {@link com.smartgwt.client.widgets.Slider#getMaxValue 'maximum value'} of the slider &#010&#010
    *
    * @param maxValue the new maximum value. Default value is 100
    */
    public void setMaxValue(float maxValue) {
        setAttribute("maxValue", maxValue);
    }
    /**
     * The maximum slider value. The slider value is equal to maxValue when the thumb is at the&#010 top or right of the slider (unless flipValues is true, in which case the maximum value&#010 is at the bottom/left of the slider)
     *
     *
     * @return float
     *
     */
    public float getMaxValue()  {
        return getAttributeAsFloat("maxValue");
    }

    /**
    * The number of discrete values represented by slider. If specified, the range of valid&#010 values (between <code>minValue</code> and <code>maxValue</code>) will be divided into&#010 this many steps. As the thumb is moved along the track it will only select these values&#010 and appear to jump between the steps.
    * Sets the {@link com.smartgwt.client.widgets.Slider#getNumValues 'number of values'} for the slider &#010&#010
    *
    * @param numValues the new number of values. Default value is null
    */
    public void setNumValues(Integer numValues) {
        setAttribute("numValues", numValues);
    }
    /**
     * The number of discrete values represented by slider. If specified, the range of valid&#010 values (between <code>minValue</code> and <code>maxValue</code>) will be divided into&#010 this many steps. As the thumb is moved along the track it will only select these values&#010 and appear to jump between the steps.
     *
     *
     * @return Integer
     *
     */
    public Integer getNumValues()  {
        return getAttributeAsInt("numValues");
    }

    /**
    * Specifies whether the slider value should be rounded to the nearest integer.  If set to&#010 false, values will be rounded to a fixed number of decimal places controlled by&#010 {@link com.smartgwt.client.widgets.form.fields.SliderItem#getRoundPrecision roundPrecision}.
    *
    * @param roundValues roundValues Default value is true
    */
    public void setRoundValues(Boolean roundValues) {
        setAttribute("roundValues", roundValues);
    }
    /**
     * Specifies whether the slider value should be rounded to the nearest integer.  If set to&#010 false, values will be rounded to a fixed number of decimal places controlled by&#010 {@link com.smartgwt.client.widgets.form.fields.SliderItem#getRoundPrecision roundPrecision}.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getRoundValues()  {
        return getAttributeAsBoolean("roundValues");
    }

    /**
    * If {@link com.smartgwt.client.widgets.Slider#getRoundValues roundValues} is false, the slider value will be rounded to this number of&#010 decimal places. If set to null the value will not be rounded
    *
    * @param roundPrecision roundPrecision Default value is 1
    */
    public void setRoundPrecision(int roundPrecision) {
        setAttribute("roundPrecision", roundPrecision);
    }
    /**
     * If {@link com.smartgwt.client.widgets.Slider#getRoundValues roundValues} is false, the slider value will be rounded to this number of&#010 decimal places. If set to null the value will not be rounded
     *
     *
     * @return int
     *
     */
    public int getRoundPrecision()  {
        return getAttributeAsInt("roundPrecision");
    }

    /**
    * Default value for this sliderItems is 1.
    *
    * @param defaultValue defaultValue Default value is 1
    */
    public void setDefaultValue(int defaultValue) {
        setAttribute("defaultValue", defaultValue);
    }
    /**
     * Default value for this sliderItems is 1.
     *
     *
     * @return int
     *
     */
    public int getDefaultValue()  {
        return getAttributeAsInt("defaultValue");
    }

    // ********************* Methods ***********************




    // ********************* Static Methods ***********************

}



