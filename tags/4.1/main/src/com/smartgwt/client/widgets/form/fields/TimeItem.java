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

/**
 * FormItem for editing times in a text field or via a set of selector components.  
 *  <P>
 * {@link com.smartgwt.client.widgets.form.fields.TimeItem#getTimeFormatter timeFormatter} allows you to set the display
 * format for this field.  See also
 *  String for system-wide settings.
 *  <P>
 *  TimeItem automatically accepts both 12 and 24 hour time as well as partial times and a
 *  variety of possible time value separators.  Examples:
 *  <pre>
 *   11:34:45 AM => 11:34:45
 *   1:3:5 AM => 01:30:50
 *   1:3p  => 13:30:00
 *   11 34 am => 11:34:00
 *   11-34  => 11:34:00
 *   113445  => 11:34:45
 *   13445  => 01:34:45
 *   1134  => 11:34:00
 *   134   => 01:34:00
 *  </pre>
 *  <P>
 *  Values entered by the user are stored as JavaScript <code>Date</code> objects in local time.  
 *  The day, month and year values of this <code>Date</code> object are not relevant and should 
 *  be ignored.
 *  <P>
 * By default, when used in a {@link com.smartgwt.client.widgets.form.SearchForm} or as a field in a {@link
 * com.smartgwt.client.widgets.grid.ListGrid}'s 
 * {@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor filter editor}, TimeItems will automatically
 * generate 
 *  AdvancedCriteria - for example, entering "11:00" into the item will generate a 
 *  {@link com.smartgwt.client.types.OperatorId betweenInclusive} Criterion that selects all times between 
 *  11:00:00 and 11:59:59.  If the form is databound and the DataSource is marked as being
 * {@link com.smartgwt.client.data.DataSource#getAllowAdvancedCriteria allowAdvancedCriteria}:false, the criteria generated
 *  will be simple, checking for data with logical time values equal to the displayed value.
 */
@BeanFactory.FrameworkClass
public class TimeItem extends TextItem {

    public static TimeItem getOrCreateRef(JavaScriptObject jsObj) {

        if(jsObj == null) return null;

        RefDataClass obj = RefDataClass.getRef(jsObj);

		if(obj != null && JSOHelper.getAttribute(jsObj,"__ref")==null) {
            return com.smartgwt.client.util.ObjectFactory.createFormItem("TimeItem",jsObj);

        } else
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (TimeItem) obj;
        } else {
            return new TimeItem(jsObj);
        }
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
        $wnd.isc.TimeItem.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
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
        $wnd.isc.TimeItem.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;

    public static native void changePickerIconDefaults(FormItemIcon defaults) /*-{
        $wnd.isc.TimeItem.changeDefaults("pickerIconDefaults", defaults.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public TimeItem(){
        setAttribute("editorType", "TimeItem");
    }

    public TimeItem(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    public TimeItem(String name) {
        setName(name);
                setAttribute("editorType", "TimeItem");
    }


    public TimeItem(String name, String title) {
        setName(name);
		setTitle(title);
                setAttribute("editorType", "TimeItem");
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Select item to hold the AM/PM value for the timeItem when  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return SelectItem
     */
    public SelectItem getAmpmItem()  {
        return SelectItem.getOrCreateRef(getAttributeAsJavaScriptObject("ampmItem"));
    }

    /**
     * Custom properties to apply to this timeItem's generated  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getAmpmItem AM/PM picker}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param ampmItemProperties  Default value is null
     */
    public void setAmpmItemProperties(SelectItem ampmItemProperties) {
        setAttribute("ampmItemProperties", ampmItemProperties.getJsObj());
    }

    /**
     * Custom properties to apply to this timeItem's generated  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getAmpmItem AM/PM picker}.
     *
     * @return SelectItem
     */
    public SelectItem getAmpmItemProperties()  {
        return SelectItem.getOrCreateRef(getAttributeAsJavaScriptObject("ampmItemProperties"));
    }

    /**
     * Title to show for the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getAmpmItem AM/PM picker}.
     *
     * @param ampmItemTitle  Default value is "AM/PM"
     */
    public void setAmpmItemTitle(String ampmItemTitle) {
        setAttribute("ampmItemTitle", ampmItemTitle);
    }

    /**
     * Title to show for the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getAmpmItem AM/PM picker}.
     *
     * @return String
     */
    public String getAmpmItemTitle()  {
        return getAttributeAsString("ampmItemTitle");
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is true and browserInputType is
     * set to "time", then a native <a href='http://www.w3.org/TR/html5/forms.html#time-state-(type=time)'
     * onclick="window.open('http://www.w3.org/TR/html5/forms.html#time-state-(type=time)');return false;">HTML5 time input</a>
     * is used in place of a text input. <p> The use of a native HTML5 time input causes certain features to be disabled. Input
     * masks and a custom {@link com.smartgwt.client.widgets.form.fields.TimeItem#getTimeFormatter timeFormatter} are not
     * supported. {@link com.smartgwt.client.widgets.form.fields.TimeItem#getShowHintInField In-field hints} are currently
     * supported, but future browser changes might force this support to be removed. Therefore, it is safest to <em>not</em>
     * use in-field hints (set showHintInField to false) in conjunction with a native HTML5 time input. <p> <b>NOTE:</b> This
     * feature requires specific CSS changes. Currently these changes have been made to the Enterprise, EnterpriseBlue, and
     * Graphite skins only.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param browserInputType  Default value is null
     */
    public void setBrowserInputType(String browserInputType) {
        setAttribute("browserInputType", browserInputType);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is true and browserInputType is
     * set to "time", then a native <a href='http://www.w3.org/TR/html5/forms.html#time-state-(type=time)'
     * onclick="window.open('http://www.w3.org/TR/html5/forms.html#time-state-(type=time)');return false;">HTML5 time input</a>
     * is used in place of a text input. <p> The use of a native HTML5 time input causes certain features to be disabled. Input
     * masks and a custom {@link com.smartgwt.client.widgets.form.fields.TimeItem#getTimeFormatter timeFormatter} are not
     * supported. {@link com.smartgwt.client.widgets.form.fields.TimeItem#getShowHintInField In-field hints} are currently
     * supported, but future browser changes might force this support to be removed. Therefore, it is safest to <em>not</em>
     * use in-field hints (set showHintInField to false) in conjunction with a native HTML5 time input. <p> <b>NOTE:</b> This
     * feature requires specific CSS changes. Currently these changes have been made to the Enterprise, EnterpriseBlue, and
     * Graphite skins only.
     *
     * @return String
     */
    public String getBrowserInputType()  {
        return getAttributeAsString("browserInputType");
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourValues hourValues} is unset, this attribute specifies the
     * increment to use when generating entries for the hour picker.  For example, if this attribute is set to 5, the hour
     * picker will contain only every fifth value between the  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourMinValue hourMinValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourMaxValue hourMaxValue}.
     *
     * @param hourIncrement  Default value is null
     */
    public void setHourIncrement(Integer hourIncrement) {
        setAttribute("hourIncrement", hourIncrement);
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourValues hourValues} is unset, this attribute specifies the
     * increment to use when generating entries for the hour picker.  For example, if this attribute is set to 5, the hour
     * picker will contain only every fifth value between the  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourMinValue hourMinValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourMaxValue hourMaxValue}.
     *
     * @return Integer
     */
    public Integer getHourIncrement()  {
        return getAttributeAsInt("hourIncrement");
    }

    /**
     * Select item to hold the hours portion of the time or  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getDuration duration} when {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField}  is false.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return SelectItem
     */
    public SelectItem getHourItem()  {
        return SelectItem.getOrCreateRef(getAttributeAsJavaScriptObject("hourItem"));
    }

    /**
     * The hover prompt to show for the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getHourItem hour picker}.
     *
     * @param hourItemPrompt  Default value is "Choose hours"
     */
    public void setHourItemPrompt(String hourItemPrompt) {
        setAttribute("hourItemPrompt", hourItemPrompt);
    }

    /**
     * The hover prompt to show for the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getHourItem hour picker}.
     *
     * @return String
     */
    public String getHourItemPrompt()  {
        return getAttributeAsString("hourItemPrompt");
    }

    /**
     * Custom properties to apply to this timeItem's generated  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourItem hour picker}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param hourItemProperties  Default value is null
     */
    public void setHourItemProperties(SelectItem hourItemProperties) {
        setAttribute("hourItemProperties", hourItemProperties.getJsObj());
    }

    /**
     * Custom properties to apply to this timeItem's generated  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourItem hour picker}.
     *
     * @return SelectItem
     */
    public SelectItem getHourItemProperties()  {
        return SelectItem.getOrCreateRef(getAttributeAsJavaScriptObject("hourItemProperties"));
    }

    /**
     * Title to show for the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getHourItem hour picker}.
     *
     * @param hourItemTitle  Default value is "Hour"
     */
    public void setHourItemTitle(String hourItemTitle) {
        setAttribute("hourItemTitle", hourItemTitle);
    }

    /**
     * Title to show for the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getHourItem hour picker}.
     *
     * @return String
     */
    public String getHourItemTitle()  {
        return getAttributeAsString("hourItemTitle");
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourValues hourValues} is unset, this attribute specifies the
     * maximum value present in the hour picker. <P>Used for specifying a limited set of valid Hour values, or when using the 
     * TimeItem to record duration, rather than time per-se.  The default is 11 or 23,  according to the value of {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getUse24HourTime use24HourTime} and {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getTimeFormatter timeFormatter}. <P> See also {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourMinValue hourMinValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourIncrement hourIncrement}.
     *
     * @param hourMaxValue  Default value is null
     */
    public void setHourMaxValue(Integer hourMaxValue) {
        setAttribute("hourMaxValue", hourMaxValue);
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourValues hourValues} is unset, this attribute specifies the
     * maximum value present in the hour picker. <P>Used for specifying a limited set of valid Hour values, or when using the 
     * TimeItem to record duration, rather than time per-se.  The default is 11 or 23,  according to the value of {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getUse24HourTime use24HourTime} and {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getTimeFormatter timeFormatter}. <P> See also {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourMinValue hourMinValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourIncrement hourIncrement}.
     *
     * @return Integer
     */
    public Integer getHourMaxValue()  {
        return getAttributeAsInt("hourMaxValue");
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourValues hourValues} is unset, this attribute specifies the
     * minimum value present in the hour picker. <P>Used for specifying a limited set of valid Hour values, or when using the 
     * TimeItem to record duration, rather than time per-se.  The default is zero in all cases. <P> See also {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourMaxValue hourMaxValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourIncrement hourIncrement}.
     *
     * @param hourMinValue  Default value is null
     */
    public void setHourMinValue(Integer hourMinValue) {
        setAttribute("hourMinValue", hourMinValue);
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourValues hourValues} is unset, this attribute specifies the
     * minimum value present in the hour picker. <P>Used for specifying a limited set of valid Hour values, or when using the 
     * TimeItem to record duration, rather than time per-se.  The default is zero in all cases. <P> See also {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourMaxValue hourMaxValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourIncrement hourIncrement}.
     *
     * @return Integer
     */
    public Integer getHourMinValue()  {
        return getAttributeAsInt("hourMinValue");
    }

    /**
     * An array of values to make available in the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getHourItem hour
     * picker} when {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false. <P>Used for
     * specifying a limited set of valid Hour values, or when using the  TimeItem to record duration, rather than time per-se.
     * <P> See {@link com.smartgwt.client.widgets.form.fields.TimeItem#getHourMinValue hourMinValue},  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourMaxValue hourMaxValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourIncrement hourIncrement} for another method of controlling the 
     * content in the hour picker.
     *
     * <p>If this method is called after the component has been drawn/initialized:
     * Sets the array of valid {@link com.smartgwt.client.widgets.form.fields.TimeItem#getHourValues hour values} to use when {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false. <P>Used for limiting available valid Hour values, or when using the TimeItem to record duration, rather than time per-se. <P> See {@link com.smartgwt.client.widgets.form.fields.TimeItem#getHourMinValue hourMinValue},  {@link com.smartgwt.client.widgets.form.fields.TimeItem#getHourMaxValue hourMaxValue} and  {@link com.smartgwt.client.widgets.form.fields.TimeItem#getHourIncrement hourIncrement} for another method of controlling the  content in the hour picker.
     *
     * @param hourValues array of available Hour values. Default value is null
     */
    public void setHourValues(int... hourValues) {
        setAttribute("hourValues", hourValues);
    }

    /**
     * An array of values to make available in the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getHourItem hour
     * picker} when {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false. <P>Used for
     * specifying a limited set of valid Hour values, or when using the  TimeItem to record duration, rather than time per-se.
     * <P> See {@link com.smartgwt.client.widgets.form.fields.TimeItem#getHourMinValue hourMinValue},  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourMaxValue hourMaxValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourIncrement hourIncrement} for another method of controlling the 
     * content in the hour picker.
     *
     * @return Returns an array of the current valid hour values, whether set directly as  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourValues hourValues} or generated according to  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourMinValue hourMinValue},  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourMaxValue hourMaxValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourIncrement hourIncrement}.
     */
    public int[] getHourValues()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfint(getAttributeAsJavaScriptObject("hourValues"));
    }

    /**
     * Validation error message to display if the user enters an invalid time string.
     *
     * @param invalidTimeStringMessage  Default value is "Invalid time"
     */
    public void setInvalidTimeStringMessage(String invalidTimeStringMessage) {
        setAttribute("invalidTimeStringMessage", invalidTimeStringMessage);
    }

    /**
     * Validation error message to display if the user enters an invalid time string.
     *
     * @return String
     */
    public String getInvalidTimeStringMessage()  {
        return getAttributeAsString("invalidTimeStringMessage");
    }

    /**
     * Internal-use only for a TimeItem.
     *
     * <p>If this method is called after the component has been drawn/initialized:
     * A custom mask cannot be defined for a time item.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param mask  Default value is null
     * @see com.smartgwt.client.widgets.form.fields.TimeItem#setUseMask
     */
    public void setMask(String mask) {
        setAttribute("mask", mask);
    }

    /**
     * Internal-use only for a TimeItem.
     *
     * @return String
     * @see com.smartgwt.client.widgets.form.fields.TimeItem#getUseMask
     */
    public String getMask()  {
        return getAttributeAsString("mask");
    }

    /**
     * Internal-use only for a TimeItem.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param maskOverwriteMode  Default value is null
     * @see com.smartgwt.client.widgets.form.fields.TimeItem#setUseMask
     */
    public void setMaskOverwriteMode(Boolean maskOverwriteMode) {
        setAttribute("maskOverwriteMode", maskOverwriteMode);
    }

    /**
     * Internal-use only for a TimeItem.
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.form.fields.TimeItem#getUseMask
     */
    public Boolean getMaskOverwriteMode()  {
        return getAttributeAsBoolean("maskOverwriteMode");
    }

    /**
     * Internal-use only for a TimeItem.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param maskSaveLiterals  Default value is null
     * @see com.smartgwt.client.widgets.form.fields.TimeItem#setUseMask
     */
    public void setMaskSaveLiterals(Boolean maskSaveLiterals) {
        setAttribute("maskSaveLiterals", maskSaveLiterals);
    }

    /**
     * Internal-use only for a TimeItem.
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.form.fields.TimeItem#getUseMask
     */
    public Boolean getMaskSaveLiterals()  {
        return getAttributeAsBoolean("maskSaveLiterals");
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondValues millisecondValues} is unset, this attribute
     * specifies  the increment to use when generating entries for the millisecond picker.  For example,  if this attribute is
     * set to 5, the millisecond picker will contain only every fifth  value between the {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondMinValue millisecondMinValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondMaxValue millisecondMaxValue}.
     *
     * @param millisecondIncrement  Default value is null
     */
    public void setMillisecondIncrement(Integer millisecondIncrement) {
        setAttribute("millisecondIncrement", millisecondIncrement);
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondValues millisecondValues} is unset, this attribute
     * specifies  the increment to use when generating entries for the millisecond picker.  For example,  if this attribute is
     * set to 5, the millisecond picker will contain only every fifth  value between the {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondMinValue millisecondMinValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondMaxValue millisecondMaxValue}.
     *
     * @return Integer
     */
    public Integer getMillisecondIncrement()  {
        return getAttributeAsInt("millisecondIncrement");
    }

    /**
     * Select item to hold the milliseconds portion of the time or  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getDuration duration} when {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField}  is false.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return SelectItem
     */
    public SelectItem getMillisecondItem()  {
        return SelectItem.getOrCreateRef(getAttributeAsJavaScriptObject("millisecondItem"));
    }

    /**
     * The hover prompt to show for the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondItem millisecond
     * picker}.
     *
     * @param millisecondItemPrompt  Default value is "Choose milliseconds"
     */
    public void setMillisecondItemPrompt(String millisecondItemPrompt) {
        setAttribute("millisecondItemPrompt", millisecondItemPrompt);
    }

    /**
     * The hover prompt to show for the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondItem millisecond
     * picker}.
     *
     * @return String
     */
    public String getMillisecondItemPrompt()  {
        return getAttributeAsString("millisecondItemPrompt");
    }

    /**
     * Custom properties to apply to this timeItem's generated  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondItem millisecond picker}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param millisecondItemProperties  Default value is null
     */
    public void setMillisecondItemProperties(SelectItem millisecondItemProperties) {
        setAttribute("millisecondItemProperties", millisecondItemProperties.getJsObj());
    }

    /**
     * Custom properties to apply to this timeItem's generated  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondItem millisecond picker}.
     *
     * @return SelectItem
     */
    public SelectItem getMillisecondItemProperties()  {
        return SelectItem.getOrCreateRef(getAttributeAsJavaScriptObject("millisecondItemProperties"));
    }

    /**
     * Title to show for the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondItem millisecond picker}.
     *
     * @param millisecondItemTitle  Default value is "Ms"
     */
    public void setMillisecondItemTitle(String millisecondItemTitle) {
        setAttribute("millisecondItemTitle", millisecondItemTitle);
    }

    /**
     * Title to show for the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondItem millisecond picker}.
     *
     * @return String
     */
    public String getMillisecondItemTitle()  {
        return getAttributeAsString("millisecondItemTitle");
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondValues millisecondValues} is unset, this attribute
     * specifies  the maximum value present in the millisecond picker. <P>Used for specifying a limited set of valid
     * Millisecond values, or when using the  TimeItem to record duration, rather than time per-se.  The default is 999. <P>
     * See also {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondMinValue millisecondMinValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondIncrement millisecondIncrement}.
     *
     * @param millisecondMaxValue  Default value is null
     */
    public void setMillisecondMaxValue(Integer millisecondMaxValue) {
        setAttribute("millisecondMaxValue", millisecondMaxValue);
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondValues millisecondValues} is unset, this attribute
     * specifies  the maximum value present in the millisecond picker. <P>Used for specifying a limited set of valid
     * Millisecond values, or when using the  TimeItem to record duration, rather than time per-se.  The default is 999. <P>
     * See also {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondMinValue millisecondMinValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondIncrement millisecondIncrement}.
     *
     * @return Integer
     */
    public Integer getMillisecondMaxValue()  {
        return getAttributeAsInt("millisecondMaxValue");
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondValues millisecondValues} is unset, this attribute
     * specifies  the minimum value present in the millisecond picker. <P>Used for specifying a limited set of valid
     * Millisecond values, or when using the  TimeItem to record duration, rather than time per-se.  The default is zero in all
     * cases. <P> See also {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondMaxValue millisecondMaxValue}
     * and  {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondIncrement millisecondIncrement}.
     *
     * @param millisecondMinValue  Default value is null
     */
    public void setMillisecondMinValue(Integer millisecondMinValue) {
        setAttribute("millisecondMinValue", millisecondMinValue);
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondValues millisecondValues} is unset, this attribute
     * specifies  the minimum value present in the millisecond picker. <P>Used for specifying a limited set of valid
     * Millisecond values, or when using the  TimeItem to record duration, rather than time per-se.  The default is zero in all
     * cases. <P> See also {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondMaxValue millisecondMaxValue}
     * and  {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondIncrement millisecondIncrement}.
     *
     * @return Integer
     */
    public Integer getMillisecondMinValue()  {
        return getAttributeAsInt("millisecondMinValue");
    }

    /**
     * An array of values to make available in the  {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondItem
     * millisecond picker} when {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false.
     * <P>Used for specifying a limited set of valid Millisecond values, or when using the  TimeItem to record duration, rather
     * than time per-se. <P> See {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondMinValue
     * millisecondMinValue},  {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondMaxValue
     * millisecondMaxValue} and  {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondIncrement
     * millisecondIncrement} for another method of  controlling the content in the millisecond picker.
     *
     * <p>If this method is called after the component has been drawn/initialized:
     * Sets the array of valid {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondValues millisecond values} to use when {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false. <P>Used for limiting available valid Millisecond values, or when using the TimeItem to record duration, rather than time per-se. <P> See {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondMinValue millisecondMinValue},  {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondMaxValue millisecondMaxValue} and  {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondIncrement millisecondIncrement} for another method of controlling the  content in the millisecond picker.
     *
     * @param millisecondValues array of available Millisecond values. Default value is null
     */
    public void setMillisecondValues(int... millisecondValues) {
        setAttribute("millisecondValues", millisecondValues);
    }

    /**
     * An array of values to make available in the  {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondItem
     * millisecond picker} when {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false.
     * <P>Used for specifying a limited set of valid Millisecond values, or when using the  TimeItem to record duration, rather
     * than time per-se. <P> See {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondMinValue
     * millisecondMinValue},  {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondMaxValue
     * millisecondMaxValue} and  {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondIncrement
     * millisecondIncrement} for another method of  controlling the content in the millisecond picker.
     *
     * @return Returns an array of the current valid millisecond values, whether set directly as  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondValues millisecondValues} or generated according to 
     * {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondMinValue millisecondMinValue},  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondMaxValue millisecondMaxValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondIncrement millisecondIncrement}.
     */
    public int[] getMillisecondValues()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfint(getAttributeAsJavaScriptObject("millisecondValues"));
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteValues minuteValues} is unset, this attribute specifies the
     * increment to use when generating entries for the minute picker.  For example, if this attribute is set to 5, the minute
     * picker will contain only every fifth value between the  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteMinValue minuteMinValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteMaxValue minuteMaxValue}.
     *
     * @param minuteIncrement  Default value is null
     */
    public void setMinuteIncrement(Integer minuteIncrement) {
        setAttribute("minuteIncrement", minuteIncrement);
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteValues minuteValues} is unset, this attribute specifies the
     * increment to use when generating entries for the minute picker.  For example, if this attribute is set to 5, the minute
     * picker will contain only every fifth value between the  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteMinValue minuteMinValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteMaxValue minuteMaxValue}.
     *
     * @return Integer
     */
    public Integer getMinuteIncrement()  {
        return getAttributeAsInt("minuteIncrement");
    }

    /**
     * Select item to hold the minutes portion of the time or  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getDuration duration} when {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField}  is false.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return SelectItem
     */
    public SelectItem getMinuteItem()  {
        return SelectItem.getOrCreateRef(getAttributeAsJavaScriptObject("minuteItem"));
    }

    /**
     * The hover prompt to show for the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteItem minute picker}.
     *
     * @param minuteItemPrompt  Default value is "Choose minutes"
     */
    public void setMinuteItemPrompt(String minuteItemPrompt) {
        setAttribute("minuteItemPrompt", minuteItemPrompt);
    }

    /**
     * The hover prompt to show for the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteItem minute picker}.
     *
     * @return String
     */
    public String getMinuteItemPrompt()  {
        return getAttributeAsString("minuteItemPrompt");
    }

    /**
     * Custom properties to apply to this timeItem's generated  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteItem minute picker}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param minuteItemProperties  Default value is null
     */
    public void setMinuteItemProperties(SelectItem minuteItemProperties) {
        setAttribute("minuteItemProperties", minuteItemProperties.getJsObj());
    }

    /**
     * Custom properties to apply to this timeItem's generated  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteItem minute picker}.
     *
     * @return SelectItem
     */
    public SelectItem getMinuteItemProperties()  {
        return SelectItem.getOrCreateRef(getAttributeAsJavaScriptObject("minuteItemProperties"));
    }

    /**
     * Title to show for the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteItem minute picker}.
     *
     * @param minuteItemTitle  Default value is "Min"
     */
    public void setMinuteItemTitle(String minuteItemTitle) {
        setAttribute("minuteItemTitle", minuteItemTitle);
    }

    /**
     * Title to show for the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteItem minute picker}.
     *
     * @return String
     */
    public String getMinuteItemTitle()  {
        return getAttributeAsString("minuteItemTitle");
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteValues minuteValues} is unset, this attribute specifies the
     * maximum value present in the minute picker. <P>Used for specifying a limited set of valid Minute values, or when using
     * the  TimeItem to record duration, rather than time per-se.  The default 59. <P> See also {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteMinValue minuteMinValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteIncrement minuteIncrement}.
     *
     * @param minuteMaxValue  Default value is null
     */
    public void setMinuteMaxValue(Integer minuteMaxValue) {
        setAttribute("minuteMaxValue", minuteMaxValue);
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteValues minuteValues} is unset, this attribute specifies the
     * maximum value present in the minute picker. <P>Used for specifying a limited set of valid Minute values, or when using
     * the  TimeItem to record duration, rather than time per-se.  The default 59. <P> See also {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteMinValue minuteMinValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteIncrement minuteIncrement}.
     *
     * @return Integer
     */
    public Integer getMinuteMaxValue()  {
        return getAttributeAsInt("minuteMaxValue");
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteValues minuteValues} is unset, this attribute specifies the
     * minimum value present in the minute picker. <P>Used for specifying a limited set of valid Minute values, or when using
     * the  TimeItem to record duration, rather than time per-se.  The default is zero in all cases. <P> See also {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteMaxValue minuteMaxValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteIncrement minuteIncrement}.
     *
     * @param minuteMinValue  Default value is null
     */
    public void setMinuteMinValue(Integer minuteMinValue) {
        setAttribute("minuteMinValue", minuteMinValue);
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteValues minuteValues} is unset, this attribute specifies the
     * minimum value present in the minute picker. <P>Used for specifying a limited set of valid Minute values, or when using
     * the  TimeItem to record duration, rather than time per-se.  The default is zero in all cases. <P> See also {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteMaxValue minuteMaxValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteIncrement minuteIncrement}.
     *
     * @return Integer
     */
    public Integer getMinuteMinValue()  {
        return getAttributeAsInt("minuteMinValue");
    }

    /**
     * An array of values to make available in the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteItem minute
     * picker} when {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false. <P>Used for
     * specifying a limited set of valid Minute values, or when using the  TimeItem to record duration, rather than time
     * per-se. <P> See {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteMinValue minuteMinValue},  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteMaxValue minuteMaxValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteIncrement minuteIncrement} for another method of controlling
     * the  content in the minute picker.
     *
     * <p>If this method is called after the component has been drawn/initialized:
     * Sets the array of valid {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteValues minute values} to use when {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false. <P>Used for limiting available valid Minute values, or when using the TimeItem to record duration, rather than time per-se. <P> See {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteMinValue minuteMinValue},  {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteMaxValue minuteMaxValue} and  {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteIncrement minuteIncrement} for another method of controlling the  content in the minute picker.
     *
     * @param minuteValues array of available Minute values. Default value is null
     */
    public void setMinuteValues(int... minuteValues) {
        setAttribute("minuteValues", minuteValues);
    }

    /**
     * An array of values to make available in the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteItem minute
     * picker} when {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false. <P>Used for
     * specifying a limited set of valid Minute values, or when using the  TimeItem to record duration, rather than time
     * per-se. <P> See {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteMinValue minuteMinValue},  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteMaxValue minuteMaxValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteIncrement minuteIncrement} for another method of controlling
     * the  content in the minute picker.
     *
     * @return Returns an array of the current valid minute values, whether set directly as  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteValues minuteValues} or generated according to  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteMinValue minuteMinValue},  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteMaxValue minuteMaxValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteIncrement minuteIncrement}.
     */
    public int[] getMinuteValues()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfint(getAttributeAsJavaScriptObject("minuteValues"));
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondValues secondValues} is unset, this attribute specifies the
     * increment to use when generating entries for the second picker.  For example, if this attribute is set to 5, the second
     * picker will contain only every fifth value between the  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondMinValue secondMinValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondMaxValue secondMaxValue}.
     *
     * @param secondIncrement  Default value is null
     */
    public void setSecondIncrement(Integer secondIncrement) {
        setAttribute("secondIncrement", secondIncrement);
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondValues secondValues} is unset, this attribute specifies the
     * increment to use when generating entries for the second picker.  For example, if this attribute is set to 5, the second
     * picker will contain only every fifth value between the  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondMinValue secondMinValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondMaxValue secondMaxValue}.
     *
     * @return Integer
     */
    public Integer getSecondIncrement()  {
        return getAttributeAsInt("secondIncrement");
    }

    /**
     * Select item to hold the seconds portion of the time or  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getDuration duration} when {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField}  is false.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return SelectItem
     */
    public SelectItem getSecondItem()  {
        return SelectItem.getOrCreateRef(getAttributeAsJavaScriptObject("secondItem"));
    }

    /**
     * The hover prompt to show for the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getSecondItem second picker}.
     *
     * @param secondItemPrompt  Default value is "Choose seconds"
     */
    public void setSecondItemPrompt(String secondItemPrompt) {
        setAttribute("secondItemPrompt", secondItemPrompt);
    }

    /**
     * The hover prompt to show for the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getSecondItem second picker}.
     *
     * @return String
     */
    public String getSecondItemPrompt()  {
        return getAttributeAsString("secondItemPrompt");
    }

    /**
     * Custom properties to apply to this timeItem's generated  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondItem seconds picker}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param secondItemProperties  Default value is null
     */
    public void setSecondItemProperties(SelectItem secondItemProperties) {
        setAttribute("secondItemProperties", secondItemProperties.getJsObj());
    }

    /**
     * Custom properties to apply to this timeItem's generated  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondItem seconds picker}.
     *
     * @return SelectItem
     */
    public SelectItem getSecondItemProperties()  {
        return SelectItem.getOrCreateRef(getAttributeAsJavaScriptObject("secondItemProperties"));
    }

    /**
     * Title to show for the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getSecondItem second picker}.
     *
     * @param secondItemTitle  Default value is "Sec"
     */
    public void setSecondItemTitle(String secondItemTitle) {
        setAttribute("secondItemTitle", secondItemTitle);
    }

    /**
     * Title to show for the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getSecondItem second picker}.
     *
     * @return String
     */
    public String getSecondItemTitle()  {
        return getAttributeAsString("secondItemTitle");
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondValues secondValues} is unset, this attribute specifies the
     * maximum value present in the second picker. <P>Used for specifying a limited set of valid Second values, or when using
     * the  TimeItem to record duration, rather than time per-se.  The default is 59. <P> See also {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondMinValue secondMinValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondIncrement secondIncrement}.
     *
     * @param secondMaxValue  Default value is null
     */
    public void setSecondMaxValue(Integer secondMaxValue) {
        setAttribute("secondMaxValue", secondMaxValue);
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondValues secondValues} is unset, this attribute specifies the
     * maximum value present in the second picker. <P>Used for specifying a limited set of valid Second values, or when using
     * the  TimeItem to record duration, rather than time per-se.  The default is 59. <P> See also {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondMinValue secondMinValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondIncrement secondIncrement}.
     *
     * @return Integer
     */
    public Integer getSecondMaxValue()  {
        return getAttributeAsInt("secondMaxValue");
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondValues secondValues} is unset, this attribute specifies the
     * minimum value present in the second picker. <P>Used for specifying a limited set of valid Second values, or when using
     * the  TimeItem to record duration, rather than time per-se.  The default is zero in all cases. <P> See also {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondMaxValue secondMaxValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondIncrement secondIncrement}.
     *
     * @param secondMinValue  Default value is null
     */
    public void setSecondMinValue(Integer secondMinValue) {
        setAttribute("secondMinValue", secondMinValue);
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondValues secondValues} is unset, this attribute specifies the
     * minimum value present in the second picker. <P>Used for specifying a limited set of valid Second values, or when using
     * the  TimeItem to record duration, rather than time per-se.  The default is zero in all cases. <P> See also {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondMaxValue secondMaxValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondIncrement secondIncrement}.
     *
     * @return Integer
     */
    public Integer getSecondMinValue()  {
        return getAttributeAsInt("secondMinValue");
    }

    /**
     * An array of values to make available in the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getSecondItem second
     * picker} when {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false. <P>Used for
     * specifying a limited set of valid Second values, or when using the  TimeItem to record duration, rather than time
     * per-se. <P> See {@link com.smartgwt.client.widgets.form.fields.TimeItem#getSecondMinValue secondMinValue},  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondMaxValue secondMaxValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondIncrement secondIncrement} for another method of controlling
     * the  content in the second picker.
     *
     * <p>If this method is called after the component has been drawn/initialized:
     * Sets the array of valid {@link com.smartgwt.client.widgets.form.fields.TimeItem#getSecondValues second values} to use when {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false. <P>Used for limiting available valid Second values, or when using the TimeItem to record duration, rather than time per-se. <P> See {@link com.smartgwt.client.widgets.form.fields.TimeItem#getSecondMinValue secondMinValue},  {@link com.smartgwt.client.widgets.form.fields.TimeItem#getSecondMaxValue secondMaxValue} and  {@link com.smartgwt.client.widgets.form.fields.TimeItem#getSecondIncrement secondIncrement} for another method of controlling the  content in the second picker.
     *
     * @param secondValues array of available Second values. Default value is null
     */
    public void setSecondValues(int... secondValues) {
        setAttribute("secondValues", secondValues);
    }

    /**
     * An array of values to make available in the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getSecondItem second
     * picker} when {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false. <P>Used for
     * specifying a limited set of valid Second values, or when using the  TimeItem to record duration, rather than time
     * per-se. <P> See {@link com.smartgwt.client.widgets.form.fields.TimeItem#getSecondMinValue secondMinValue},  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondMaxValue secondMaxValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondIncrement secondIncrement} for another method of controlling
     * the  content in the second picker.
     *
     * @return Returns an array of the current valid second values, whether set directly as  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondValues secondValues} or generated according to  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondMinValue secondMinValue},  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondMaxValue secondMaxValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondIncrement secondIncrement}.
     */
    public int[] getSecondValues()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfint(getAttributeAsJavaScriptObject("secondValues"));
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is true and a {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getHint hint} is set, should the hint be shown within the field? <p>
     * Note that when using a native HTML5 time input (see {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getBrowserInputType browserInputType}), in-field hints are currently
     * supported, but future browser changes might not allow in-field hints to be supported. Therefore, it is safest to
     * <em>not</em> use in-field hints in conjunction with a native HTML5 time input. <p> To change this attribute after being
     * drawn, it is necessary to call {@link com.smartgwt.client.widgets.form.fields.FormItem#redraw FormItem.redraw} or redraw
     * the form.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showHintInField  Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setHint
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setShowHintInField(Boolean showHintInField) {
        setAttribute("showHintInField", showHintInField);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is true and a {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getHint hint} is set, should the hint be shown within the field? <p>
     * Note that when using a native HTML5 time input (see {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getBrowserInputType browserInputType}), in-field hints are currently
     * supported, but future browser changes might not allow in-field hints to be supported. Therefore, it is safest to
     * <em>not</em> use in-field hints in conjunction with a native HTML5 time input. <p> To change this attribute after being
     * drawn, it is necessary to call {@link com.smartgwt.client.widgets.form.fields.FormItem#redraw FormItem.redraw} or redraw
     * the form.
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getHint
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowHintInField()  {
        return getAttributeAsBoolean("showHintInField");
    }

    /**
     * Controls whether to display the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getHourItem hourItem} when
     * {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false.
     *
     * @param showHourItem  Default value is true
     */
    public void setShowHourItem(Boolean showHourItem) {
        setAttribute("showHourItem", showHourItem);
    }

    /**
     * Controls whether to display the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getHourItem hourItem} when
     * {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false.
     *
     * @return Boolean
     */
    public Boolean getShowHourItem()  {
        return getAttributeAsBoolean("showHourItem");
    }

    /**
     * Controls whether to display the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondItem
     * millisecondItem} when {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false.
     *
     * @param showMillisecondItem  Default value is false
     */
    public void setShowMillisecondItem(Boolean showMillisecondItem) {
        setAttribute("showMillisecondItem", showMillisecondItem);
    }

    /**
     * Controls whether to display the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondItem
     * millisecondItem} when {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false.
     *
     * @return Boolean
     */
    public Boolean getShowMillisecondItem()  {
        return getAttributeAsBoolean("showMillisecondItem");
    }

    /**
     * Controls whether to display the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteItem minuteItem} when
     * {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false.
     *
     * @param showMinuteItem  Default value is true
     */
    public void setShowMinuteItem(Boolean showMinuteItem) {
        setAttribute("showMinuteItem", showMinuteItem);
    }

    /**
     * Controls whether to display the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteItem minuteItem} when
     * {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false.
     *
     * @return Boolean
     */
    public Boolean getShowMinuteItem()  {
        return getAttributeAsBoolean("showMinuteItem");
    }

    /**
     * Controls whether to display the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getSecondItem secondItem} when
     * {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false.
     *
     * @param showSecondItem  Default value is true
     */
    public void setShowSecondItem(Boolean showSecondItem) {
        setAttribute("showSecondItem", showSecondItem);
    }

    /**
     * Controls whether to display the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getSecondItem secondItem} when
     * {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false.
     *
     * @return Boolean
     */
    public Boolean getShowSecondItem()  {
        return getAttributeAsBoolean("showSecondItem");
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is <code>true</code>, this
     * property governs the alignment of text within the text field. Defaults to <code>"left"</code> by default or
     * <code>"right"</code> if the page is in {@link com.smartgwt.client.util.Page#isRTL rtl mode}. <p> This attribute does not
     * have an effect if a native HTML5 time input is being used. See {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getBrowserInputType browserInputType}.
     *
     * @param textAlign  Default value is varies
     */
    public void setTextAlign(Alignment textAlign) {
        setAttribute("textAlign", textAlign == null ? null : textAlign.getValue());
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is <code>true</code>, this
     * property governs the alignment of text within the text field. Defaults to <code>"left"</code> by default or
     * <code>"right"</code> if the page is in {@link com.smartgwt.client.util.Page#isRTL rtl mode}. <p> This attribute does not
     * have an effect if a native HTML5 time input is being used. See {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getBrowserInputType browserInputType}.
     *
     * @return Alignment
     */
    public Alignment getTextAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("textAlign"));
    }

    /**
     * Base CSS class for this item's text box. If specified this style will be applied to the {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getTextField textField} if  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is set to <code>true</code>.
     *
     * @param textBoxStyle  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is null
     */
    public void setTextBoxStyle(String textBoxStyle) {
        setAttribute("textBoxStyle", textBoxStyle);
    }

    /**
     * Base CSS class for this item's text box. If specified this style will be applied to the {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getTextField textField} if  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is set to <code>true</code>.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     */
    public String getTextBoxStyle()  {
        return getAttributeAsString("textBoxStyle");
    }

    /**
     * Text field to hold the entire time in "type in" format, if  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is true.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return TextItem
     */
    public TextItem getTextField()  {
        return TextItem.getOrCreateRef(getAttributeAsJavaScriptObject("textField"));
    }

    /**
     * Custom properties to apply to the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getTextField text field}
     * generated for  this timeItem when {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField}
     * is true.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param textFieldProperties  Default value is null
     */
    public void setTextFieldProperties(TextItem textFieldProperties) {
        setAttribute("textFieldProperties", textFieldProperties.getJsObj());
    }

    /**
     * Custom properties to apply to the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getTextField text field}
     * generated for  this timeItem when {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField}
     * is true.
     *
     * @return TextItem
     */
    public TextItem getTextFieldProperties()  {
        return TextItem.getOrCreateRef(getAttributeAsJavaScriptObject("textFieldProperties"));
    }

    /**
     * What format should this item's time string be presented in? If unset the format will be derived from {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getTimeFormatter timeFormatter} or the system-side <p> This attribute does
     * not have an effect if a native HTML5 time input is being used. See {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getBrowserInputType browserInputType}.
     *
     * @param timeFormatter  Default value is "toShort24HourTime"
     */
    public void setTimeFormatter(TimeDisplayFormat timeFormatter) {
        setAttribute("timeFormatter", timeFormatter == null ? null : timeFormatter.getValue());
    }

    /**
     * What format should this item's time string be presented in? If unset the format will be derived from {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getTimeFormatter timeFormatter} or the system-side <p> This attribute does
     * not have an effect if a native HTML5 time input is being used. See {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getBrowserInputType browserInputType}.
     *
     * @return TimeDisplayFormat
     */
    public TimeDisplayFormat getTimeFormatter()  {
        return EnumUtil.getEnum(TimeDisplayFormat.values(), getAttribute("timeFormatter"));
    }

    /**
     * Whether to enforce 24-hour time in the UI.
     *
     * @param use24HourTime  Default value is null
     */
    public void setUse24HourTime(Boolean use24HourTime) {
        setAttribute("use24HourTime", use24HourTime);
    }

    /**
     * Whether to enforce 24-hour time in the UI.
     *
     * @return Boolean
     */
    public Boolean getUse24HourTime()  {
        return getAttributeAsBoolean("use24HourTime");
    }

    /**
     * If true, a data entry mask will be enabled in the field based on the {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getTimeFormatter timeFormatter}. <p> Note that if a non-padded {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getTimeFormatter timeFormatter} is specified, it will be changed to the
     * corresponding padded version (ex. "toShort24HourTime" will be changed to "toShortPadded24HourTime"). <p> This attribute
     * does not have an effect if a native HTML5 time input is being used. See {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getBrowserInputType browserInputType}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param useMask  Default value is null
     */
    public void setUseMask(Boolean useMask) {
        setAttribute("useMask", useMask);
    }

    /**
     * If true, a data entry mask will be enabled in the field based on the {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getTimeFormatter timeFormatter}. <p> Note that if a non-padded {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getTimeFormatter timeFormatter} is specified, it will be changed to the
     * corresponding padded version (ex. "toShort24HourTime" will be changed to "toShortPadded24HourTime"). <p> This attribute
     * does not have an effect if a native HTML5 time input is being used. See {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getBrowserInputType browserInputType}.
     *
     * @return Boolean
     */
    public Boolean getUseMask()  {
        return getAttributeAsBoolean("useMask");
    }

    /**
     * Should we show the time in a text field, or as a number of SelectItems?
     *
     * @param useTextField  Default value is true
     */
    public void setUseTextField(Boolean useTextField) {
        setAttribute("useTextField", useTextField);
    }

    /**
     * Should we show the time in a text field, or as a number of SelectItems?
     *
     * @return Boolean
     */
    public Boolean getUseTextField()  {
        return getAttributeAsBoolean("useTextField");
    }

    // ********************* Methods ***********************
	/**
     * If {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is true, falls through to
     * standard {@link com.smartgwt.client.widgets.form.fields.TextItem#deselectValue deselectValue()} implementation on this
     * items freeform text entry field. Otherwise has no effect.
     */
    public native void deselectValue() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.deselectValue();
    }-*/;

	/**
     * If {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is true, falls through to
     * standard {@link com.smartgwt.client.widgets.form.fields.TextItem#deselectValue deselectValue()} implementation on this
     * items freeform text entry field. Otherwise has no effect.
     * @param start If this parameter is passed, new cursor insertion position will be   moved to the start, rather than the end of this
     * item's value.
     */
    public native void deselectValue(Boolean start) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.deselectValue(start == null ? null : start.@java.lang.Boolean::booleanValue()());
    }-*/;

	/**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is set to false, this method 
     * returns the value of the time expressed as a duration in the {@link com.smartgwt.client.types.TimeUnit timeUnit}
     * provided.  If no timeUnit is passed, the default is the smallest unit for which a  picker is visible.
     *
     * @return the item's value, expressed as a duration in the TimeUnit passed
     */
    public native int getDuration() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getDuration();
        return ret;
    }-*/;

	/**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is set to false, this method 
     * returns the value of the time expressed as a duration in the {@link com.smartgwt.client.types.TimeUnit timeUnit}
     * provided.  If no timeUnit is passed, the default is the smallest unit for which a  picker is visible.
     * @param timeUnit the unit of the return value
     *
     * @return the item's value, expressed as a duration in the TimeUnit passed
     */
    public native int getDuration(TimeUnit timeUnit) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getDuration(timeUnit == null ? null : timeUnit.@com.smartgwt.client.types.TimeUnit::getValue()());
        return ret;
    }-*/;

	/**
     * Returns the raw text value typed into this items text field if {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField}  is true (otherwise returns the result of
     * this.getValue()).
     *
     * @return value the user entered
     */
    public native String getEnteredValue() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getEnteredValue();
        return ret;
    }-*/;

	/**
     * If {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is true, falls through to
     * standard {@link com.smartgwt.client.widgets.form.fields.TextItem#selectValue selectValue()} implementation on this items
     * freeform text entry field. Otherwise has no effect.
     */
    public native void selectValue() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.selectValue();
    }-*/;


	/**
     * Set the hour value of this TimeItem. If the item value has not been initialized with {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#setValue setValue()},  the minute will be established to current
     * minute. <P> You can use {@link com.smartgwt.client.widgets.form.fields.TimeItem#setValue setValue()} to set both hours
     * and minutes at the same time. <P>  setHours() cannot be called until the item has been added to a DynamicForm and the
     * form has been drawn.
     * @param hours new hours value for this TimeItem.
     */
    public native void setHours(int hours) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.setHours(hours);
    }-*/;


	/**
     * Set the milliseconds value of this TimeItem.
     * @param milliseconds new milliseconds value for this TimeItem.
     */
    public native void setMilliseconds(int milliseconds) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.setMilliseconds(milliseconds);
    }-*/;


	/**
     * Set the minute value of this TimeItem. If the item value has not been initialized with {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#setValue setValue()},  the hour will be established to current hour.
     * <P> You can use {@link com.smartgwt.client.widgets.form.fields.TimeItem#setValue setValue()} to set both hours and
     * minutes at the same time. <P>  setMinutes() cannot be called until the item has been added to a DynamicForm and the form
     * has been drawn.
     * @param minutes new minutes value for this TimeItem.
     */
    public native void setMinutes(int minutes) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.setMinutes(minutes);
    }-*/;


	/**
     * Set the seconds value of this TimeItem.
     * @param seconds new seconds value for this TimeItem.
     */
    public native void setSeconds(int seconds) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.setSeconds(seconds);
    }-*/;


	/**
     * If {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is true, falls through to
     * standard {@link com.smartgwt.client.widgets.form.fields.TextItem#setSelectionRange setSelectionRange} implementation on
     * this items freeform text entry field. Otherwise has no effect.
     * @param start character index for start of new selection
     * @param end character index for end of new selection
     */
    public native void setSelectionRange(int start, int end) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.setSelectionRange(start, end);
    }-*/;


	/**
     * Set the value of the form item to the value passed in <p> NOTE: for valueMap'd items, newValue should be data value not
     * displayed value
     * @param newValue value to set the element to
     */
    public native void setValue(Object newValue) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.setValue(newValue);
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
     * @param timeItemProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(TimeItem timeItemProperties) /*-{
    	var properties = $wnd.isc.addProperties({},timeItemProperties.@com.smartgwt.client.core.RefDataClass::getJsObj()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
        $wnd.isc.TimeItem.addProperties(properties);
    }-*/;

    // ***********************************************************


    /**
     * What format should this item's time string be presented in?
     * @deprecated Use {@link #setDisplayFormat(TimeDisplayFormat)} instead.
     *
     * @param timeFormatter displayFormat Default value is "toShort24HourTime"
     */
    public void setDisplayFormat(TimeFormatter timeFormatter) {
        setAttribute("displayFormat", timeFormatter.getValue());
    }

    /**
     * What format should this item's time string be presented in?
     *
     * @param TimeDisplayFormat displayFormat Default value is "toShort24HourTime"
     * @deprecated Use {@link #getTimeFormatter()} instead.
     */
    @Deprecated
    public void setDisplayFormat(TimeDisplayFormat timeFormatter) {
        setAttribute("displayFormat", timeFormatter.getValue());
    }

    /**
     * What format should this item's time string be presented in?
     *
     * @return TimeDisplayFormat
     * @deprecated Use {@link #setTimeFormatter(com.smartgwt.client.types.TimeDisplayFormat)} instead.
     */
    @Deprecated
    public TimeDisplayFormat getDisplayFormat() {
        return EnumUtil.getEnum(TimeDisplayFormat.values(), getAttribute("displayFormat"));
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is true, falls through to
     * standard {@link com.smartgwt.client.widgets.form.fields.FormItem#getSelectionRange} implementation on this item's
     * freeform text entry field. Otherwise has no effect.
     *
     * @return 2 element array indicating start/end character index of current selection  within our text entry field. Returns null if
     * this item is undrawn or doesn't have focus.
     */
    public native int[] getSelectionRange() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selection = self.getSelectionRange();
        return selection == null || selection === undefined ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)(selection);
    }-*/;
 

}




