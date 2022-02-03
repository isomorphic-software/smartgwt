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
 * A {@link com.smartgwt.client.widgets.form.fields.FormItem} for editing {@link
 * com.smartgwt.client.util.DateUtil#createLogicalTime logical-time} values, which
 *  are Date instances where only the time-portion is relevant.
 *  <P>
 *  The item renders with one of two appearances, depending on the value of 
 * {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} - when set to true, the default
 * appearance, times are edited 
 *  directly as text-values.  In this mode, values are formatted according to 
 * {@link com.smartgwt.client.widgets.form.fields.TimeItem#getTimeFormatter timeFormatter}, with defaults coming from
 * {@link com.smartgwt.client.widgets.form.fields.TimeItem#getTimeFormatter24Hour timeFormatter24Hour} 
 * and {@link com.smartgwt.client.widgets.form.fields.TimeItem#getTimeFormatter12Hour timeFormatter12Hour}, depending on
 * the value of 
 *  {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUse24HourTime use24HourTime}.
 *  See also String for system-wide settings.
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
 *  When <code>useTextField</code> is set to false, the item provides separate pickers for 
 * {@link com.smartgwt.client.widgets.form.fields.TimeItem#getHourItem hour}, {@link
 * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteItem minute} and 
 * {@link com.smartgwt.client.widgets.form.fields.TimeItem#getSecondItem second} values.  By default, the pickers edit
 * times in 
 * {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUse24HourTime 24-hour format}, meaning the
 * <code>hourItem</code> shows 
 * values from 0-23.  When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUse24HourTime use24HourTime} is set
 * to false, the 
 *  <code>hourItem</code> is limited to a range of 1-12, and the 
 *  {@link com.smartgwt.client.widgets.form.fields.TimeItem#getAmpmItem am/pm picker} is displayed.  Note that 
 * {@link com.smartgwt.client.widgets.form.fields.FormItem#getValue getValue()} always returns a Date instance that
 * represents a
 *  {@link com.smartgwt.client.util.DateUtil#createLogicalTime logical-time} in 24-hour format.
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
 *  <P>
 * To edit {@link com.smartgwt.client.util.DateUtil#createLogicalDate logical-Date values}, see {@link
 * com.smartgwt.client.widgets.form.fields.DateItem},
 * and to edit {@link com.smartgwt.client.util.DateUtil#createDatetime datetime values}, see {@link
 * com.smartgwt.client.widgets.form.fields.DateTimeItem}.
 * For {@link com.smartgwt.client.docs.RelativeDateString relative-date features}, see {@link
 * com.smartgwt.client.widgets.form.fields.RelativeDateItem}.
 *  <P>
 *  For detailed information on working with dates, times and datetimes, see the 
 *  {@link com.smartgwt.client.docs.DateFormatAndStorage Date and Time Format and Storage overview}.
 */
@BeanFactory.FrameworkClass
public class TimeItem extends FormItem {

    public static TimeItem getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof TimeItem) {
            existingObj.setJsObj(jsObj);
            return (TimeItem)existingObj;
        } else

        {
            return new TimeItem(jsObj);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(TimeItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.TimeItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(TimeItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.TimeItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public static native void changePickerIconDefaults(FormItemIcon defaults) /*-{
        $wnd.isc.TimeItem.changeDefaults("pickerIconDefaults", defaults.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public TimeItem(){
        setAttribute("editorType", "TimeItem");
    }

    public TimeItem(JavaScriptObject jsObj){
        super(jsObj);
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
     * This component is an AutoChild named "ampmItem".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current ampmItem value. Default value is null
     */
    public SelectItem getAmpmItem()  {
        return SelectItem.getOrCreateRef(getAttributeAsJavaScriptObject("ampmItem"));
    }
    

    /**
     * Custom properties to apply to this timeItem's generated  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getAmpmItem AM/PM picker}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param ampmItemProperties New ampmItemProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     */
    public TimeItem setAmpmItemProperties(SelectItem ampmItemProperties) {
        if (ampmItemProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(TimeItem.class, "setAmpmItemProperties", "SelectItem");
        }                                                                       
        ampmItemProperties.setConfigOnly(true);
        return (TimeItem)setAttribute("ampmItemProperties", ampmItemProperties == null ? null : ampmItemProperties.getEditorTypeConfig());
    }

    /**
     * Custom properties to apply to this timeItem's generated  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getAmpmItem AM/PM picker}.
     *
     * @return Current ampmItemProperties value. Default value is null
     */
    public SelectItem getAmpmItemProperties()  {
        return SelectItem.getOrCreateRef(getAttributeAsJavaScriptObject("ampmItemProperties"));
    }
    

    /**
     * Title to show for the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getAmpmItem AM/PM picker}.
     *
     * @param ampmItemTitle New ampmItemTitle value. Default value is "AM/PM"
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public TimeItem setAmpmItemTitle(String ampmItemTitle) {
        return (TimeItem)setAttribute("ampmItemTitle", ampmItemTitle);
    }

    /**
     * Title to show for the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getAmpmItem AM/PM picker}.
     *
     * @return Current ampmItemTitle value. Default value is "AM/PM"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getAmpmItemTitle()  {
        return getAttributeAsString("ampmItemTitle");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is true and browserInputType is
     * set to "time", then a native <a href='http://www.w3.org/TR/html5/forms.html#time-state-(type=time)'
     * target='_blank'>HTML5 time input</a> is used in place of a text input. <p> The use of a native HTML5 time input causes
     * certain features to be disabled. Input masks and a custom {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getTimeFormatter timeFormatter} are not supported. {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getShowHintInField In-field hints} are currently supported, but future
     * browser changes might force this support to be removed. Therefore, it is safest to <em>not</em> use in-field hints (set
     * showHintInField to false) in conjunction with a native HTML5 time input. <p> <b>NOTE:</b> This feature requires specific
     * CSS changes. Currently these changes have been made to the Enterprise, EnterpriseBlue, and Graphite skins only.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param browserInputType New browserInputType value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     */
    public TimeItem setBrowserInputType(String browserInputType) {
        return (TimeItem)setAttribute("browserInputType", browserInputType);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is true and browserInputType is
     * set to "time", then a native <a href='http://www.w3.org/TR/html5/forms.html#time-state-(type=time)'
     * target='_blank'>HTML5 time input</a> is used in place of a text input. <p> The use of a native HTML5 time input causes
     * certain features to be disabled. Input masks and a custom {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getTimeFormatter timeFormatter} are not supported. {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getShowHintInField In-field hints} are currently supported, but future
     * browser changes might force this support to be removed. Therefore, it is safest to <em>not</em> use in-field hints (set
     * showHintInField to false) in conjunction with a native HTML5 time input. <p> <b>NOTE:</b> This feature requires specific
     * CSS changes. Currently these changes have been made to the Enterprise, EnterpriseBlue, and Graphite skins only.
     *
     * @return Current browserInputType value. Default value is null
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
     * @param hourIncrement New hourIncrement value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     */
    public TimeItem setHourIncrement(Integer hourIncrement) {
        return (TimeItem)setAttribute("hourIncrement", hourIncrement);
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourValues hourValues} is unset, this attribute specifies the
     * increment to use when generating entries for the hour picker.  For example, if this attribute is set to 5, the hour
     * picker will contain only every fifth value between the  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourMinValue hourMinValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourMaxValue hourMaxValue}.
     *
     * @return Current hourIncrement value. Default value is null
     */
    public Integer getHourIncrement()  {
        return getAttributeAsInt("hourIncrement");
    }
    

    /**
     * Select item to hold the hours portion of the time or  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getDuration duration} when {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField}  is false.
     * <p>
     * This component is an AutoChild named "hourItem".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current hourItem value. Default value is null
     */
    public SelectItem getHourItem()  {
        return SelectItem.getOrCreateRef(getAttributeAsJavaScriptObject("hourItem"));
    }
    

    /**
     * The hover prompt to show for the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getHourItem hour picker}.
     *
     * @param hourItemPrompt New hourItemPrompt value. Default value is "Choose hours"
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public TimeItem setHourItemPrompt(String hourItemPrompt) {
        return (TimeItem)setAttribute("hourItemPrompt", hourItemPrompt);
    }

    /**
     * The hover prompt to show for the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getHourItem hour picker}.
     *
     * @return Current hourItemPrompt value. Default value is "Choose hours"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getHourItemPrompt()  {
        return getAttributeAsString("hourItemPrompt");
    }
    

    /**
     * Custom properties to apply to this timeItem's generated  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourItem hour picker}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param hourItemProperties New hourItemProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     */
    public TimeItem setHourItemProperties(SelectItem hourItemProperties) {
        if (hourItemProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(TimeItem.class, "setHourItemProperties", "SelectItem");
        }                                                                       
        hourItemProperties.setConfigOnly(true);
        return (TimeItem)setAttribute("hourItemProperties", hourItemProperties == null ? null : hourItemProperties.getEditorTypeConfig());
    }

    /**
     * Custom properties to apply to this timeItem's generated  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourItem hour picker}.
     *
     * @return Current hourItemProperties value. Default value is null
     */
    public SelectItem getHourItemProperties()  {
        return SelectItem.getOrCreateRef(getAttributeAsJavaScriptObject("hourItemProperties"));
    }
    

    /**
     * Title to show for the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getHourItem hour picker}.
     *
     * @param hourItemTitle New hourItemTitle value. Default value is "Hour"
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public TimeItem setHourItemTitle(String hourItemTitle) {
        return (TimeItem)setAttribute("hourItemTitle", hourItemTitle);
    }

    /**
     * Title to show for the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getHourItem hour picker}.
     *
     * @return Current hourItemTitle value. Default value is "Hour"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
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
     * @param hourMaxValue New hourMaxValue value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     */
    public TimeItem setHourMaxValue(Integer hourMaxValue) {
        return (TimeItem)setAttribute("hourMaxValue", hourMaxValue);
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
     * @return Current hourMaxValue value. Default value is null
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
     * @param hourMinValue New hourMinValue value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     */
    public TimeItem setHourMinValue(Integer hourMinValue) {
        return (TimeItem)setAttribute("hourMinValue", hourMinValue);
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourValues hourValues} is unset, this attribute specifies the
     * minimum value present in the hour picker. <P>Used for specifying a limited set of valid Hour values, or when using the 
     * TimeItem to record duration, rather than time per-se.  The default is zero in all cases. <P> See also {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourMaxValue hourMaxValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourIncrement hourIncrement}.
     *
     * @return Current hourMinValue value. Default value is null
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
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the array of valid {@link com.smartgwt.client.widgets.form.fields.TimeItem#getHourValues hour values} to use when {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false. <P>Used for limiting available valid Hour values, or when using the TimeItem to record duration, rather than time per-se. <P> See {@link com.smartgwt.client.widgets.form.fields.TimeItem#getHourMinValue hourMinValue},  {@link com.smartgwt.client.widgets.form.fields.TimeItem#getHourMaxValue hourMaxValue} and  {@link com.smartgwt.client.widgets.form.fields.TimeItem#getHourIncrement hourIncrement} for another method of controlling the  content in the hour picker.
     *
     * @param hourValues array of available Hour values. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     */
    public TimeItem setHourValues(int... hourValues) {
        return (TimeItem)setAttribute("hourValues", hourValues);
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
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourIncrement hourIncrement}. Default value is null
     */
    public int[] getHourValues()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfint(getAttributeAsJavaScriptObject("hourValues"));
    }
    

    /**
     * Validation error message to display if the user enters an invalid time string.
     *
     * @param invalidTimeStringMessage New invalidTimeStringMessage value. Default value is "Invalid time"
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public TimeItem setInvalidTimeStringMessage(String invalidTimeStringMessage) {
        return (TimeItem)setAttribute("invalidTimeStringMessage", invalidTimeStringMessage);
    }

    /**
     * Validation error message to display if the user enters an invalid time string.
     *
     * @return Current invalidTimeStringMessage value. Default value is "Invalid time"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getInvalidTimeStringMessage()  {
        return getAttributeAsString("invalidTimeStringMessage");
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false, the default
     * title-alignment of  child-items such as the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getHourItem hour}, 
     * {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteItem minute} and {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondItem second} pickers, within their cells.
     *
     * @param itemTitleAlign New itemTitleAlign value. Default value is "center"
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_form_titles" target="examples">Titles Example</a>
     */
    public TimeItem setItemTitleAlign(Alignment itemTitleAlign) {
        return (TimeItem)setAttribute("itemTitleAlign", itemTitleAlign == null ? null : itemTitleAlign.getValue());
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false, the default
     * title-alignment of  child-items such as the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getHourItem hour}, 
     * {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteItem minute} and {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondItem second} pickers, within their cells.
     *
     * @return Current itemTitleAlign value. Default value is "center"
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_form_titles" target="examples">Titles Example</a>
     */
    public Alignment getItemTitleAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("itemTitleAlign"));
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false, the default
     * orientation of  titles for child-items, such as the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getHourItem
     * hour},  {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteItem minute} and {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondItem second} pickers. {@link
     * com.smartgwt.client.types.TitleOrientation} lists valid options. <P> Note that titles on the left or right take up a
     * cell in tabular {@link com.smartgwt.client.docs.FormLayout form layouts}, but titles on top do not.
     *
     * @param itemTitleOrientation New itemTitleOrientation value. Default value is "top"
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_form_titles" target="examples">Titles Example</a>
     */
    public TimeItem setItemTitleOrientation(TitleOrientation itemTitleOrientation) {
        return (TimeItem)setAttribute("itemTitleOrientation", itemTitleOrientation == null ? null : itemTitleOrientation.getValue());
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false, the default
     * orientation of  titles for child-items, such as the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getHourItem
     * hour},  {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteItem minute} and {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondItem second} pickers. {@link
     * com.smartgwt.client.types.TitleOrientation} lists valid options. <P> Note that titles on the left or right take up a
     * cell in tabular {@link com.smartgwt.client.docs.FormLayout form layouts}, but titles on top do not.
     *
     * @return Current itemTitleOrientation value. Default value is "top"
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_form_titles" target="examples">Titles Example</a>
     */
    public TitleOrientation getItemTitleOrientation()  {
        return EnumUtil.getEnum(TitleOrientation.values(), getAttribute("itemTitleOrientation"));
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondValues millisecondValues} is unset, this attribute
     * specifies  the increment to use when generating entries for the millisecond picker.  For example,  if this attribute is
     * set to 5, the millisecond picker will contain only every fifth  value between the {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondMinValue millisecondMinValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondMaxValue millisecondMaxValue}.
     *
     * @param millisecondIncrement New millisecondIncrement value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     */
    public TimeItem setMillisecondIncrement(Integer millisecondIncrement) {
        return (TimeItem)setAttribute("millisecondIncrement", millisecondIncrement);
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondValues millisecondValues} is unset, this attribute
     * specifies  the increment to use when generating entries for the millisecond picker.  For example,  if this attribute is
     * set to 5, the millisecond picker will contain only every fifth  value between the {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondMinValue millisecondMinValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondMaxValue millisecondMaxValue}.
     *
     * @return Current millisecondIncrement value. Default value is null
     */
    public Integer getMillisecondIncrement()  {
        return getAttributeAsInt("millisecondIncrement");
    }
    

    /**
     * Select item to hold the milliseconds portion of the time or  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getDuration duration} when {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField}  is false.
     * <p>
     * This component is an AutoChild named "millisecondItem".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current millisecondItem value. Default value is null
     */
    public SelectItem getMillisecondItem()  {
        return SelectItem.getOrCreateRef(getAttributeAsJavaScriptObject("millisecondItem"));
    }
    

    /**
     * The hover prompt to show for the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondItem millisecond
     * picker}.
     *
     * @param millisecondItemPrompt New millisecondItemPrompt value. Default value is "Choose milliseconds"
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public TimeItem setMillisecondItemPrompt(String millisecondItemPrompt) {
        return (TimeItem)setAttribute("millisecondItemPrompt", millisecondItemPrompt);
    }

    /**
     * The hover prompt to show for the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondItem millisecond
     * picker}.
     *
     * @return Current millisecondItemPrompt value. Default value is "Choose milliseconds"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getMillisecondItemPrompt()  {
        return getAttributeAsString("millisecondItemPrompt");
    }
    

    /**
     * Custom properties to apply to this timeItem's generated  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondItem millisecond picker}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param millisecondItemProperties New millisecondItemProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     */
    public TimeItem setMillisecondItemProperties(SelectItem millisecondItemProperties) {
        if (millisecondItemProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(TimeItem.class, "setMillisecondItemProperties", "SelectItem");
        }                                                                       
        millisecondItemProperties.setConfigOnly(true);
        return (TimeItem)setAttribute("millisecondItemProperties", millisecondItemProperties == null ? null : millisecondItemProperties.getEditorTypeConfig());
    }

    /**
     * Custom properties to apply to this timeItem's generated  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondItem millisecond picker}.
     *
     * @return Current millisecondItemProperties value. Default value is null
     */
    public SelectItem getMillisecondItemProperties()  {
        return SelectItem.getOrCreateRef(getAttributeAsJavaScriptObject("millisecondItemProperties"));
    }
    

    /**
     * Title to show for the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondItem millisecond picker}.
     *
     * @param millisecondItemTitle New millisecondItemTitle value. Default value is "Ms"
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public TimeItem setMillisecondItemTitle(String millisecondItemTitle) {
        return (TimeItem)setAttribute("millisecondItemTitle", millisecondItemTitle);
    }

    /**
     * Title to show for the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondItem millisecond picker}.
     *
     * @return Current millisecondItemTitle value. Default value is "Ms"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
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
     * @param millisecondMaxValue New millisecondMaxValue value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     */
    public TimeItem setMillisecondMaxValue(Integer millisecondMaxValue) {
        return (TimeItem)setAttribute("millisecondMaxValue", millisecondMaxValue);
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondValues millisecondValues} is unset, this attribute
     * specifies  the maximum value present in the millisecond picker. <P>Used for specifying a limited set of valid
     * Millisecond values, or when using the  TimeItem to record duration, rather than time per-se.  The default is 999. <P>
     * See also {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondMinValue millisecondMinValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondIncrement millisecondIncrement}.
     *
     * @return Current millisecondMaxValue value. Default value is null
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
     * @param millisecondMinValue New millisecondMinValue value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     */
    public TimeItem setMillisecondMinValue(Integer millisecondMinValue) {
        return (TimeItem)setAttribute("millisecondMinValue", millisecondMinValue);
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondValues millisecondValues} is unset, this attribute
     * specifies  the minimum value present in the millisecond picker. <P>Used for specifying a limited set of valid
     * Millisecond values, or when using the  TimeItem to record duration, rather than time per-se.  The default is zero in all
     * cases. <P> See also {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondMaxValue millisecondMaxValue}
     * and  {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondIncrement millisecondIncrement}.
     *
     * @return Current millisecondMinValue value. Default value is null
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
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the array of valid {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondValues millisecond values} to use when {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false. <P>Used for limiting available valid Millisecond values, or when using the TimeItem to record duration, rather than time per-se. <P> See {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondMinValue millisecondMinValue},  {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondMaxValue millisecondMaxValue} and  {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondIncrement millisecondIncrement} for another method of controlling the  content in the millisecond picker.
     *
     * @param millisecondValues array of available Millisecond values. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     */
    public TimeItem setMillisecondValues(int... millisecondValues) {
        return (TimeItem)setAttribute("millisecondValues", millisecondValues);
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
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondIncrement millisecondIncrement}. Default value is null
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
     * @param minuteIncrement New minuteIncrement value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     */
    public TimeItem setMinuteIncrement(Integer minuteIncrement) {
        return (TimeItem)setAttribute("minuteIncrement", minuteIncrement);
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteValues minuteValues} is unset, this attribute specifies the
     * increment to use when generating entries for the minute picker.  For example, if this attribute is set to 5, the minute
     * picker will contain only every fifth value between the  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteMinValue minuteMinValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteMaxValue minuteMaxValue}.
     *
     * @return Current minuteIncrement value. Default value is null
     */
    public Integer getMinuteIncrement()  {
        return getAttributeAsInt("minuteIncrement");
    }
    

    /**
     * Select item to hold the minutes portion of the time or  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getDuration duration} when {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField}  is false.
     * <p>
     * This component is an AutoChild named "minuteItem".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current minuteItem value. Default value is null
     */
    public SelectItem getMinuteItem()  {
        return SelectItem.getOrCreateRef(getAttributeAsJavaScriptObject("minuteItem"));
    }
    

    /**
     * The hover prompt to show for the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteItem minute picker}.
     *
     * @param minuteItemPrompt New minuteItemPrompt value. Default value is "Choose minutes"
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public TimeItem setMinuteItemPrompt(String minuteItemPrompt) {
        return (TimeItem)setAttribute("minuteItemPrompt", minuteItemPrompt);
    }

    /**
     * The hover prompt to show for the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteItem minute picker}.
     *
     * @return Current minuteItemPrompt value. Default value is "Choose minutes"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getMinuteItemPrompt()  {
        return getAttributeAsString("minuteItemPrompt");
    }
    

    /**
     * Custom properties to apply to this timeItem's generated  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteItem minute picker}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param minuteItemProperties New minuteItemProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     */
    public TimeItem setMinuteItemProperties(SelectItem minuteItemProperties) {
        if (minuteItemProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(TimeItem.class, "setMinuteItemProperties", "SelectItem");
        }                                                                       
        minuteItemProperties.setConfigOnly(true);
        return (TimeItem)setAttribute("minuteItemProperties", minuteItemProperties == null ? null : minuteItemProperties.getEditorTypeConfig());
    }

    /**
     * Custom properties to apply to this timeItem's generated  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteItem minute picker}.
     *
     * @return Current minuteItemProperties value. Default value is null
     */
    public SelectItem getMinuteItemProperties()  {
        return SelectItem.getOrCreateRef(getAttributeAsJavaScriptObject("minuteItemProperties"));
    }
    

    /**
     * Title to show for the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteItem minute picker}.
     *
     * @param minuteItemTitle New minuteItemTitle value. Default value is "Min"
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public TimeItem setMinuteItemTitle(String minuteItemTitle) {
        return (TimeItem)setAttribute("minuteItemTitle", minuteItemTitle);
    }

    /**
     * Title to show for the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteItem minute picker}.
     *
     * @return Current minuteItemTitle value. Default value is "Min"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
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
     * @param minuteMaxValue New minuteMaxValue value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     */
    public TimeItem setMinuteMaxValue(Integer minuteMaxValue) {
        return (TimeItem)setAttribute("minuteMaxValue", minuteMaxValue);
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteValues minuteValues} is unset, this attribute specifies the
     * maximum value present in the minute picker. <P>Used for specifying a limited set of valid Minute values, or when using
     * the  TimeItem to record duration, rather than time per-se.  The default 59. <P> See also {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteMinValue minuteMinValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteIncrement minuteIncrement}.
     *
     * @return Current minuteMaxValue value. Default value is null
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
     * @param minuteMinValue New minuteMinValue value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     */
    public TimeItem setMinuteMinValue(Integer minuteMinValue) {
        return (TimeItem)setAttribute("minuteMinValue", minuteMinValue);
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteValues minuteValues} is unset, this attribute specifies the
     * minimum value present in the minute picker. <P>Used for specifying a limited set of valid Minute values, or when using
     * the  TimeItem to record duration, rather than time per-se.  The default is zero in all cases. <P> See also {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteMaxValue minuteMaxValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteIncrement minuteIncrement}.
     *
     * @return Current minuteMinValue value. Default value is null
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
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the array of valid {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteValues minute values} to use when {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false. <P>Used for limiting available valid Minute values, or when using the TimeItem to record duration, rather than time per-se. <P> See {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteMinValue minuteMinValue},  {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteMaxValue minuteMaxValue} and  {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteIncrement minuteIncrement} for another method of controlling the  content in the minute picker.
     *
     * @param minuteValues array of available Minute values. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     */
    public TimeItem setMinuteValues(int... minuteValues) {
        return (TimeItem)setAttribute("minuteValues", minuteValues);
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
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteIncrement minuteIncrement}. Default value is null
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
     * @param secondIncrement New secondIncrement value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     */
    public TimeItem setSecondIncrement(Integer secondIncrement) {
        return (TimeItem)setAttribute("secondIncrement", secondIncrement);
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondValues secondValues} is unset, this attribute specifies the
     * increment to use when generating entries for the second picker.  For example, if this attribute is set to 5, the second
     * picker will contain only every fifth value between the  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondMinValue secondMinValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondMaxValue secondMaxValue}.
     *
     * @return Current secondIncrement value. Default value is null
     */
    public Integer getSecondIncrement()  {
        return getAttributeAsInt("secondIncrement");
    }
    

    /**
     * Select item to hold the seconds portion of the time or  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getDuration duration} when {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField}  is false.
     * <p>
     * This component is an AutoChild named "secondItem".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current secondItem value. Default value is null
     */
    public SelectItem getSecondItem()  {
        return SelectItem.getOrCreateRef(getAttributeAsJavaScriptObject("secondItem"));
    }
    

    /**
     * The hover prompt to show for the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getSecondItem second picker}.
     *
     * @param secondItemPrompt New secondItemPrompt value. Default value is "Choose seconds"
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public TimeItem setSecondItemPrompt(String secondItemPrompt) {
        return (TimeItem)setAttribute("secondItemPrompt", secondItemPrompt);
    }

    /**
     * The hover prompt to show for the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getSecondItem second picker}.
     *
     * @return Current secondItemPrompt value. Default value is "Choose seconds"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getSecondItemPrompt()  {
        return getAttributeAsString("secondItemPrompt");
    }
    

    /**
     * Custom properties to apply to this timeItem's generated  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondItem seconds picker}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param secondItemProperties New secondItemProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     */
    public TimeItem setSecondItemProperties(SelectItem secondItemProperties) {
        if (secondItemProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(TimeItem.class, "setSecondItemProperties", "SelectItem");
        }                                                                       
        secondItemProperties.setConfigOnly(true);
        return (TimeItem)setAttribute("secondItemProperties", secondItemProperties == null ? null : secondItemProperties.getEditorTypeConfig());
    }

    /**
     * Custom properties to apply to this timeItem's generated  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondItem seconds picker}.
     *
     * @return Current secondItemProperties value. Default value is null
     */
    public SelectItem getSecondItemProperties()  {
        return SelectItem.getOrCreateRef(getAttributeAsJavaScriptObject("secondItemProperties"));
    }
    

    /**
     * Title to show for the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getSecondItem second picker}.
     *
     * @param secondItemTitle New secondItemTitle value. Default value is "Sec"
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public TimeItem setSecondItemTitle(String secondItemTitle) {
        return (TimeItem)setAttribute("secondItemTitle", secondItemTitle);
    }

    /**
     * Title to show for the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getSecondItem second picker}.
     *
     * @return Current secondItemTitle value. Default value is "Sec"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
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
     * @param secondMaxValue New secondMaxValue value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     */
    public TimeItem setSecondMaxValue(Integer secondMaxValue) {
        return (TimeItem)setAttribute("secondMaxValue", secondMaxValue);
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondValues secondValues} is unset, this attribute specifies the
     * maximum value present in the second picker. <P>Used for specifying a limited set of valid Second values, or when using
     * the  TimeItem to record duration, rather than time per-se.  The default is 59. <P> See also {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondMinValue secondMinValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondIncrement secondIncrement}.
     *
     * @return Current secondMaxValue value. Default value is null
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
     * @param secondMinValue New secondMinValue value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     */
    public TimeItem setSecondMinValue(Integer secondMinValue) {
        return (TimeItem)setAttribute("secondMinValue", secondMinValue);
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondValues secondValues} is unset, this attribute specifies the
     * minimum value present in the second picker. <P>Used for specifying a limited set of valid Second values, or when using
     * the  TimeItem to record duration, rather than time per-se.  The default is zero in all cases. <P> See also {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondMaxValue secondMaxValue} and  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondIncrement secondIncrement}.
     *
     * @return Current secondMinValue value. Default value is null
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
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the array of valid {@link com.smartgwt.client.widgets.form.fields.TimeItem#getSecondValues second values} to use when {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false. <P>Used for limiting available valid Second values, or when using the TimeItem to record duration, rather than time per-se. <P> See {@link com.smartgwt.client.widgets.form.fields.TimeItem#getSecondMinValue secondMinValue},  {@link com.smartgwt.client.widgets.form.fields.TimeItem#getSecondMaxValue secondMaxValue} and  {@link com.smartgwt.client.widgets.form.fields.TimeItem#getSecondIncrement secondIncrement} for another method of controlling the  content in the second picker.
     *
     * @param secondValues array of available Second values. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     */
    public TimeItem setSecondValues(int... secondValues) {
        return (TimeItem)setAttribute("secondValues", secondValues);
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
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondIncrement secondIncrement}. Default value is null
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
     * drawn, it is necessary to call {@link com.smartgwt.client.widgets.form.fields.FormItem#redraw FormItem.redraw()} or
     * redraw the form.
     *
     * @param showHintInField New showHintInField value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setHint
     * @see com.smartgwt.client.widgets.form.fields.TimeItem#setUsePlaceholderForHint
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public TimeItem setShowHintInField(Boolean showHintInField) {
        return (TimeItem)setAttribute("showHintInField", showHintInField);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is true and a {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getHint hint} is set, should the hint be shown within the field? <p>
     * Note that when using a native HTML5 time input (see {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getBrowserInputType browserInputType}), in-field hints are currently
     * supported, but future browser changes might not allow in-field hints to be supported. Therefore, it is safest to
     * <em>not</em> use in-field hints in conjunction with a native HTML5 time input. <p> To change this attribute after being
     * drawn, it is necessary to call {@link com.smartgwt.client.widgets.form.fields.FormItem#redraw FormItem.redraw()} or
     * redraw the form.
     *
     * @return Current showHintInField value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getHint
     * @see com.smartgwt.client.widgets.form.fields.TimeItem#getUsePlaceholderForHint
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowHintInField()  {
        return getAttributeAsBoolean("showHintInField", true);
    }
    

    /**
     * Controls whether to display the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getHourItem hourItem} when
     * {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false.
     *
     * @param showHourItem New showHourItem value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     */
    public TimeItem setShowHourItem(Boolean showHourItem) {
        return (TimeItem)setAttribute("showHourItem", showHourItem);
    }

    /**
     * Controls whether to display the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getHourItem hourItem} when
     * {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false.
     *
     * @return Current showHourItem value. Default value is true
     */
    public Boolean getShowHourItem()  {
        Boolean result = getAttributeAsBoolean("showHourItem", true);
        return result == null ? true : result;
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false, whether titles
     * should be shown for for child-items in this TimeItem.  By default, <code>showItemTitles</code> is true, and titles are
     * displayed {@link com.smartgwt.client.widgets.form.fields.FormItem#getTitleOrientation above the items}.
     *
     * @param showItemTitles New showItemTitles value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_form_titles" target="examples">Titles Example</a>
     */
    public TimeItem setShowItemTitles(Boolean showItemTitles) {
        return (TimeItem)setAttribute("showItemTitles", showItemTitles);
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false, whether titles
     * should be shown for for child-items in this TimeItem.  By default, <code>showItemTitles</code> is true, and titles are
     * displayed {@link com.smartgwt.client.widgets.form.fields.FormItem#getTitleOrientation above the items}.
     *
     * @return Current showItemTitles value. Default value is true
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_form_titles" target="examples">Titles Example</a>
     */
    public Boolean getShowItemTitles()  {
        Boolean result = getAttributeAsBoolean("showItemTitles", true);
        return result == null ? true : result;
    }
    

    /**
     * Controls whether to display the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondItem
     * millisecondItem} when {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false.
     *
     * @param showMillisecondItem New showMillisecondItem value. Default value is false
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     */
    public TimeItem setShowMillisecondItem(Boolean showMillisecondItem) {
        return (TimeItem)setAttribute("showMillisecondItem", showMillisecondItem);
    }

    /**
     * Controls whether to display the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondItem
     * millisecondItem} when {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false.
     *
     * @return Current showMillisecondItem value. Default value is false
     */
    public Boolean getShowMillisecondItem()  {
        Boolean result = getAttributeAsBoolean("showMillisecondItem", true);
        return result == null ? false : result;
    }
    

    /**
     * Controls whether to display the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteItem minuteItem} when
     * {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false.
     *
     * @param showMinuteItem New showMinuteItem value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     */
    public TimeItem setShowMinuteItem(Boolean showMinuteItem) {
        return (TimeItem)setAttribute("showMinuteItem", showMinuteItem);
    }

    /**
     * Controls whether to display the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteItem minuteItem} when
     * {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false.
     *
     * @return Current showMinuteItem value. Default value is true
     */
    public Boolean getShowMinuteItem()  {
        Boolean result = getAttributeAsBoolean("showMinuteItem", true);
        return result == null ? true : result;
    }
    

    /**
     * Controls whether to display the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getSecondItem secondItem} when
     * {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false.
     *
     * @param showSecondItem New showSecondItem value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     */
    public TimeItem setShowSecondItem(Boolean showSecondItem) {
        return (TimeItem)setAttribute("showSecondItem", showSecondItem);
    }

    /**
     * Controls whether to display the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getSecondItem secondItem} when
     * {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is false.
     *
     * @return Current showSecondItem value. Default value is true
     */
    public Boolean getShowSecondItem()  {
        Boolean result = getAttributeAsBoolean("showSecondItem", true);
        return result == null ? true : result;
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is <code>true</code>, this
     * property governs the alignment of text within the text field. Defaults to <code>"left"</code> by default or
     * <code>"right"</code> if the page is in {@link com.smartgwt.client.util.Page#isRTL rtl mode}. <p> This attribute does not
     * have an effect if a native HTML5 time input is being used. See {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getBrowserInputType browserInputType}.
     *
     * @param textAlign New textAlign value. Default value is varies
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     */
    public TimeItem setTextAlign(Alignment textAlign) {
        return (TimeItem)setAttribute("textAlign", textAlign == null ? null : textAlign.getValue());
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is <code>true</code>, this
     * property governs the alignment of text within the text field. Defaults to <code>"left"</code> by default or
     * <code>"right"</code> if the page is in {@link com.smartgwt.client.util.Page#isRTL rtl mode}. <p> This attribute does not
     * have an effect if a native HTML5 time input is being used. See {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getBrowserInputType browserInputType}.
     *
     * @return Current textAlign value. Default value is varies
     */
    public Alignment getTextAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("textAlign"));
    }
    

    /**
     * Base CSS class for this item's text box. If specified this style will be applied to the {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getTextField textField} if  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is set to <code>true</code>.
     *
     * @param textBoxStyle New textBoxStyle value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public TimeItem setTextBoxStyle(String textBoxStyle) {
        return (TimeItem)setAttribute("textBoxStyle", textBoxStyle);
    }

    /**
     * Base CSS class for this item's text box. If specified this style will be applied to the {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getTextField textField} if  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is set to <code>true</code>.
     *
     * @return Current textBoxStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getTextBoxStyle()  {
        return getAttributeAsString("textBoxStyle");
    }
    

    /**
     * Text field to hold the entire time in "type in" format, if  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is true.
     * <p>
     * This component is an AutoChild named "textField".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current textField value. Default value is null
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
     * @param textFieldProperties New textFieldProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     */
    public TimeItem setTextFieldProperties(TextItem textFieldProperties) {
        if (textFieldProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(TimeItem.class, "setTextFieldProperties", "TextItem");
        }                                                                       
        textFieldProperties.setConfigOnly(true);
        return (TimeItem)setAttribute("textFieldProperties", textFieldProperties == null ? null : textFieldProperties.getEditorTypeConfig());
    }

    /**
     * Custom properties to apply to the {@link com.smartgwt.client.widgets.form.fields.TimeItem#getTextField text field}
     * generated for  this timeItem when {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField}
     * is true.
     *
     * @return Current textFieldProperties value. Default value is null
     */
    public TextItem getTextFieldProperties()  {
        return TextItem.getOrCreateRef(getAttributeAsJavaScriptObject("textFieldProperties"));
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is true, what format should
     * this item's time string be  presented in? <P> If unset, the default formatter will be {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getTimeFormatter24Hour timeFormatter24Hour} or {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getTimeFormatter12Hour timeFormatter12Hour} depending on the value of
     * {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUse24HourTime use24HourTime}. If the property cannot be
     * derived in this way (none of these properties are set), we'll check {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getTimeFormatter DynamicForm.timeFormatter}, or finally back off to the
     * standard system-wide String will be applied. <p> This attribute does not have an effect if a native HTML5 time input is
     * being used. See {@link com.smartgwt.client.widgets.form.fields.TimeItem#getBrowserInputType browserInputType}.
     *
     * @param timeFormatter New timeFormatter value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     */
    public TimeItem setTimeFormatter(TimeDisplayFormat timeFormatter) {
        return (TimeItem)setAttribute("timeFormatter", timeFormatter == null ? null : timeFormatter.getValue());
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is true, what format should
     * this item's time string be  presented in? <P> If unset, the default formatter will be {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getTimeFormatter24Hour timeFormatter24Hour} or {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getTimeFormatter12Hour timeFormatter12Hour} depending on the value of
     * {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUse24HourTime use24HourTime}. If the property cannot be
     * derived in this way (none of these properties are set), we'll check {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getTimeFormatter DynamicForm.timeFormatter}, or finally back off to the
     * standard system-wide String will be applied. <p> This attribute does not have an effect if a native HTML5 time input is
     * being used. See {@link com.smartgwt.client.widgets.form.fields.TimeItem#getBrowserInputType browserInputType}.
     *
     * @return Current timeFormatter value. Default value is null
     */
    public TimeDisplayFormat getTimeFormatter()  {
        return EnumUtil.getEnum(TimeDisplayFormat.values(), getAttribute("timeFormatter"));
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is true, and {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getUse24HourTime use24HourTime} is false, what format should this
     * item's time string be presented in? <P> May be overridden via an explicitly specified {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getTimeFormatter timeFormatter}. <p> This attribute does not have an
     * effect if a native HTML5 time input is being used. See {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getBrowserInputType browserInputType}.
     *
     * @param timeFormatter12Hour New timeFormatter12Hour value. Default value is "toShortTime"
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     */
    public TimeItem setTimeFormatter12Hour(TimeDisplayFormat timeFormatter12Hour) {
        return (TimeItem)setAttribute("timeFormatter12Hour", timeFormatter12Hour == null ? null : timeFormatter12Hour.getValue());
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is true, and {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getUse24HourTime use24HourTime} is false, what format should this
     * item's time string be presented in? <P> May be overridden via an explicitly specified {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getTimeFormatter timeFormatter}. <p> This attribute does not have an
     * effect if a native HTML5 time input is being used. See {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getBrowserInputType browserInputType}.
     *
     * @return Current timeFormatter12Hour value. Default value is "toShortTime"
     */
    public TimeDisplayFormat getTimeFormatter12Hour()  {
        return EnumUtil.getEnum(TimeDisplayFormat.values(), getAttribute("timeFormatter12Hour"));
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is true, and {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getUse24HourTime use24HourTime} is true, what format should this item's
     * time string be presented in? <P> May be overridden via an explicitly specified {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getTimeFormatter timeFormatter}. <P> This attribute does not have an
     * effect if a native HTML5 time input is being used. See {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getBrowserInputType browserInputType}.
     *
     * @param timeFormatter24Hour New timeFormatter24Hour value. Default value is "toShort24HourTime"
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     */
    public TimeItem setTimeFormatter24Hour(TimeDisplayFormat timeFormatter24Hour) {
        return (TimeItem)setAttribute("timeFormatter24Hour", timeFormatter24Hour == null ? null : timeFormatter24Hour.getValue());
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is true, and {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getUse24HourTime use24HourTime} is true, what format should this item's
     * time string be presented in? <P> May be overridden via an explicitly specified {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getTimeFormatter timeFormatter}. <P> This attribute does not have an
     * effect if a native HTML5 time input is being used. See {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getBrowserInputType browserInputType}.
     *
     * @return Current timeFormatter24Hour value. Default value is "toShort24HourTime"
     */
    public TimeDisplayFormat getTimeFormatter24Hour()  {
        return EnumUtil.getEnum(TimeDisplayFormat.values(), getAttribute("timeFormatter24Hour"));
    }
    

    /**
     * Whether to enforce 24-hour time in the UI.  If unset, assumes to the  String.
     *
     * @param use24HourTime New use24HourTime value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     */
    public TimeItem setUse24HourTime(Boolean use24HourTime) {
        return (TimeItem)setAttribute("use24HourTime", use24HourTime);
    }

    /**
     * Whether to enforce 24-hour time in the UI.  If unset, assumes to the  String.
     *
     * @return Current use24HourTime value. Default value is null
     */
    public Boolean getUse24HourTime()  {
        return getAttributeAsBoolean("use24HourTime", true);
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
     * @param useMask New useMask value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     */
    public TimeItem setUseMask(Boolean useMask) {
        return (TimeItem)setAttribute("useMask", useMask);
    }

    /**
     * If true, a data entry mask will be enabled in the field based on the {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getTimeFormatter timeFormatter}. <p> Note that if a non-padded {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getTimeFormatter timeFormatter} is specified, it will be changed to the
     * corresponding padded version (ex. "toShort24HourTime" will be changed to "toShortPadded24HourTime"). <p> This attribute
     * does not have an effect if a native HTML5 time input is being used. See {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getBrowserInputType browserInputType}.
     *
     * @return Current useMask value. Default value is null
     */
    public Boolean getUseMask()  {
        return getAttributeAsBoolean("useMask", true);
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.TimeItem#getShowHintInField showing the hint in field} and if
     * supported by the browser, should the HTML5
     * <a href='http://www.whatwg.org/specs/web-apps/current-work/multipage/forms.html#attr-input-placeholder'
     * target='_blank'><code>placeholder</code> attribute</a>
     *  be used to display the hint within the field? If set to <code>false</code>, then use of
     *  the <code>placeholder</code> attribute is disabled and an alternative technique to display
     *  the hint in-field is used instead.
     *  <p>
     *  The HTML5 <code>placeholder</code> attribute is supported in the following major browsers:
     *  <ul>
     *  <li>Chrome 4+</li>
     *  <li>Firefox 4+</li>
     *  <li>Internet Explorer 10+</li>
     *  <li>Safari 5+</li>
     *  <li>Opera 11.50+</li>
     *  <li>Android 2.1+ <code>WebView</code> (used by the stock Browser app and when
     *      {@link com.smartgwt.client.docs.PhonegapIntegration packaging with PhoneGap})</li>
     *  <li>Mobile Safari for iOS 3.2+</li>
     *  </ul>
     *  <p>
     *  In browsers other than the above, in-field hints are implemented via a different technique.
     *  <p>
     *  Note that placeholder behavior is known to differ in Internet Explorer and certain old
     *  versions of the above browsers due to a recent change in the HTML5 specification regarding
     *  the <code>placeholder</code> attribute. Under the old rules, the placeholder is cleared
     *  when the element is focused. In the latest HTML5 spec as published by WHATWG, the placeholder
     *  is still displayed when the element is focused as long as the value is an empty string.
     *  <p>
     *  <h3>Styling the placeholder</h3>
     *  While there isn't a standard way to style the placeholder text, Chrome, Firefox,
     *  Internet Explorer, and Safari provide vendor-prefixed pseudo-classes and/or pseudo-elements
     *  that can be used in CSS selectors:
     *  <table border="1">
     *  <tr>
     *    <th>Browser</th>
     *    <th>Pseudo-class or pseudo-element</th>
     *  </tr>
     *  <tr>
     *    <td>Chrome, Safari</td>
     *    <td><code>::-webkit-input-placeholder</code></td>
     *  </tr>
     *  <tr>
     *    <td>Firefox 4 - 18</td>
     *    <td><code>:-moz-placeholder</code></td>
     *  </tr>
     *  <tr>
     *    <td>Firefox 19+</td>
     *    <td><code>::-moz-placeholder</code></td>
     *  </tr>
     *  <tr>
     *    <td>Internet Explorer</td>
     *    <td><code>:-ms-input-placeholder</code></td>
     *  </tr>
     *  </table>
     *  <p>
     *  Note that unlike other browsers, Firefox 19+ applies opacity:0.4 to the placeholder text.
     * See <a href='https://bugzilla.mozilla.org/show_bug.cgi?id=556145' target='_blank'>Bug 556145 - Placeholder text default
     * style should use opacity instead of GrayText</a>
     *  <p>
     *  Because browsers are required to ignore the entire rule if a selector is invalid,
     *  separate rules are needed for each browser. For example:
     *  <pre>::-webkit-input-placeholder {
     *     color: blue;
     *     opacity: 1;
     * &#125;
     * :-moz-placeholder {
     *     color: blue;
     *     opacity: 1;
     * &#125;
     * ::-moz-placeholder {
     *     color: blue;
     *     opacity: 1;
     * &#125;
     * :-ms-input-placeholder {
     *     color: blue;
     *     opacity: 1;
     * &#125;</pre>
     *  <p>
     *  If using <a href='http://sass-lang.com' target='_blank'>Sass</a>, it may be useful to utilize Sass'
     * <a href='http://sass-lang.com/documentation/file.SASS_REFERENCE.html#parent-selector' target='_blank'>parent selector
     * feature</a>.
     *  For example:
     *  <pre>.myCustomItem,
     * .myCustomItemRTL,
     * .myCustomItemDisabled,
     * .myCustomItemDisabledRTL,
     * .myCustomItemError,
     * .myCustomItemErrorRTL,
     * .myCustomItemFocused,
     * .myCustomItemFocusedRTL,
     * .myCustomItemHint,
     * .myCustomItemHintRTL,
     * .myCustomItemDisabledHint,
     * .myCustomItemDisabledHintRTL {
     *     // ...
     * 
     *     &amp;::-webkit-input-placeholder {
     *         color: blue;
     *         opacity: 1;
     *     }
     *     &amp;:-moz-placeholder {
     *         color: blue;
     *         opacity: 1;
     *     }
     *     &amp;::-moz-placeholder {
     *         color: blue;
     *         opacity: 1;
     *     }
     *     &amp;:-ms-input-placeholder {
     *         color: blue;
     *         opacity: 1;
     *     }
     * &#125;</pre>
     *  <p>
     *  If using <a href='http://compass-style.org' target='_blank'>Compass</a>, the
     * <a href='http://compass-style.org/reference/compass/css3/user_interface/#mixin-input-placeholder'
     * target='_blank'><code>input-placeholder</code> mixin</a>
     *  that was added in version 1.0 can further simplify the code to style the placeholder text
     *  For example:
     *  <pre>.myCustomItem,
     * .myCustomItemRTL,
     * .myCustomItemDisabled,
     * .myCustomItemDisabledRTL,
     * .myCustomItemError,
     * .myCustomItemErrorRTL,
     * .myCustomItemFocused,
     * .myCustomItemFocusedRTL,
     * .myCustomItemHint,
     * .myCustomItemHintRTL,
     * .myCustomItemDisabledHint,
     * .myCustomItemDisabledHintRTL {
     *     // ...
     * 
     *     &#64;include input-placeholder {
     *         color: blue;
     *         opacity: 1;
     *     }
     * &#125;</pre>
     *  <h3>Accessibility concerns</h3>
     *  The HTML5 specification notes that a placeholder should not be used as a replacement
     *  for a title. The placeholder is intended to be a <em>short</em> hint that assists the user
     *  who is entering a value into the empty field. The placeholder can be mistaken by some
     *  users for a pre-filled value, particularly in Internet Explorer because the same color
     *  is used, and the placeholder text color may provide insufficient contrast, particularly
     *  in Firefox 19+ because of the default 0.4 opacity. Furthermore, not having a title reduces
     *  the hit area available for setting focus on the item.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param usePlaceholderForHint New usePlaceholderForHint value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setHint
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public TimeItem setUsePlaceholderForHint(boolean usePlaceholderForHint) {
        return (TimeItem)setAttribute("usePlaceholderForHint", usePlaceholderForHint);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.TimeItem#getShowHintInField showing the hint in field} and if
     * supported by the browser, should the HTML5
     * <a href='http://www.whatwg.org/specs/web-apps/current-work/multipage/forms.html#attr-input-placeholder'
     * target='_blank'><code>placeholder</code> attribute</a>
     *  be used to display the hint within the field? If set to <code>false</code>, then use of
     *  the <code>placeholder</code> attribute is disabled and an alternative technique to display
     *  the hint in-field is used instead.
     *  <p>
     *  The HTML5 <code>placeholder</code> attribute is supported in the following major browsers:
     *  <ul>
     *  <li>Chrome 4+</li>
     *  <li>Firefox 4+</li>
     *  <li>Internet Explorer 10+</li>
     *  <li>Safari 5+</li>
     *  <li>Opera 11.50+</li>
     *  <li>Android 2.1+ <code>WebView</code> (used by the stock Browser app and when
     *      {@link com.smartgwt.client.docs.PhonegapIntegration packaging with PhoneGap})</li>
     *  <li>Mobile Safari for iOS 3.2+</li>
     *  </ul>
     *  <p>
     *  In browsers other than the above, in-field hints are implemented via a different technique.
     *  <p>
     *  Note that placeholder behavior is known to differ in Internet Explorer and certain old
     *  versions of the above browsers due to a recent change in the HTML5 specification regarding
     *  the <code>placeholder</code> attribute. Under the old rules, the placeholder is cleared
     *  when the element is focused. In the latest HTML5 spec as published by WHATWG, the placeholder
     *  is still displayed when the element is focused as long as the value is an empty string.
     *  <p>
     *  <h3>Styling the placeholder</h3>
     *  While there isn't a standard way to style the placeholder text, Chrome, Firefox,
     *  Internet Explorer, and Safari provide vendor-prefixed pseudo-classes and/or pseudo-elements
     *  that can be used in CSS selectors:
     *  <table border="1">
     *  <tr>
     *    <th>Browser</th>
     *    <th>Pseudo-class or pseudo-element</th>
     *  </tr>
     *  <tr>
     *    <td>Chrome, Safari</td>
     *    <td><code>::-webkit-input-placeholder</code></td>
     *  </tr>
     *  <tr>
     *    <td>Firefox 4 - 18</td>
     *    <td><code>:-moz-placeholder</code></td>
     *  </tr>
     *  <tr>
     *    <td>Firefox 19+</td>
     *    <td><code>::-moz-placeholder</code></td>
     *  </tr>
     *  <tr>
     *    <td>Internet Explorer</td>
     *    <td><code>:-ms-input-placeholder</code></td>
     *  </tr>
     *  </table>
     *  <p>
     *  Note that unlike other browsers, Firefox 19+ applies opacity:0.4 to the placeholder text.
     * See <a href='https://bugzilla.mozilla.org/show_bug.cgi?id=556145' target='_blank'>Bug 556145 - Placeholder text default
     * style should use opacity instead of GrayText</a>
     *  <p>
     *  Because browsers are required to ignore the entire rule if a selector is invalid,
     *  separate rules are needed for each browser. For example:
     *  <pre>::-webkit-input-placeholder {
     *     color: blue;
     *     opacity: 1;
     * &#125;
     * :-moz-placeholder {
     *     color: blue;
     *     opacity: 1;
     * &#125;
     * ::-moz-placeholder {
     *     color: blue;
     *     opacity: 1;
     * &#125;
     * :-ms-input-placeholder {
     *     color: blue;
     *     opacity: 1;
     * &#125;</pre>
     *  <p>
     *  If using <a href='http://sass-lang.com' target='_blank'>Sass</a>, it may be useful to utilize Sass'
     * <a href='http://sass-lang.com/documentation/file.SASS_REFERENCE.html#parent-selector' target='_blank'>parent selector
     * feature</a>.
     *  For example:
     *  <pre>.myCustomItem,
     * .myCustomItemRTL,
     * .myCustomItemDisabled,
     * .myCustomItemDisabledRTL,
     * .myCustomItemError,
     * .myCustomItemErrorRTL,
     * .myCustomItemFocused,
     * .myCustomItemFocusedRTL,
     * .myCustomItemHint,
     * .myCustomItemHintRTL,
     * .myCustomItemDisabledHint,
     * .myCustomItemDisabledHintRTL {
     *     // ...
     * 
     *     &amp;::-webkit-input-placeholder {
     *         color: blue;
     *         opacity: 1;
     *     }
     *     &amp;:-moz-placeholder {
     *         color: blue;
     *         opacity: 1;
     *     }
     *     &amp;::-moz-placeholder {
     *         color: blue;
     *         opacity: 1;
     *     }
     *     &amp;:-ms-input-placeholder {
     *         color: blue;
     *         opacity: 1;
     *     }
     * &#125;</pre>
     *  <p>
     *  If using <a href='http://compass-style.org' target='_blank'>Compass</a>, the
     * <a href='http://compass-style.org/reference/compass/css3/user_interface/#mixin-input-placeholder'
     * target='_blank'><code>input-placeholder</code> mixin</a>
     *  that was added in version 1.0 can further simplify the code to style the placeholder text
     *  For example:
     *  <pre>.myCustomItem,
     * .myCustomItemRTL,
     * .myCustomItemDisabled,
     * .myCustomItemDisabledRTL,
     * .myCustomItemError,
     * .myCustomItemErrorRTL,
     * .myCustomItemFocused,
     * .myCustomItemFocusedRTL,
     * .myCustomItemHint,
     * .myCustomItemHintRTL,
     * .myCustomItemDisabledHint,
     * .myCustomItemDisabledHintRTL {
     *     // ...
     * 
     *     &#64;include input-placeholder {
     *         color: blue;
     *         opacity: 1;
     *     }
     * &#125;</pre>
     *  <h3>Accessibility concerns</h3>
     *  The HTML5 specification notes that a placeholder should not be used as a replacement
     *  for a title. The placeholder is intended to be a <em>short</em> hint that assists the user
     *  who is entering a value into the empty field. The placeholder can be mistaken by some
     *  users for a pre-filled value, particularly in Internet Explorer because the same color
     *  is used, and the placeholder text color may provide insufficient contrast, particularly
     *  in Firefox 19+ because of the default 0.4 opacity. Furthermore, not having a title reduces
     *  the hit area available for setting focus on the item.
     *
     * @return Current usePlaceholderForHint value. Default value is true
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getHint
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public boolean getUsePlaceholderForHint()  {
        Boolean result = getAttributeAsBoolean("usePlaceholderForHint", true);
        return result == null ? true : result;
    }
    

    /**
     * Should we show the time in a text field, or as a number of SelectItems?
     *
     * @param useTextField New useTextField value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     */
    public TimeItem setUseTextField(Boolean useTextField) {
        return (TimeItem)setAttribute("useTextField", useTextField);
    }

    /**
     * Should we show the time in a text field, or as a number of SelectItems?
     *
     * @return Current useTextField value. Default value is true
     */
    public Boolean getUseTextField()  {
        Boolean result = getAttributeAsBoolean("useTextField", true);
        return result == null ? true : result;
    }
    

    /**
     * If this item is showing a {@link com.smartgwt.client.widgets.form.fields.FormItem#getHint FormItem.hint}, should the
     * hint text be allowed to wrap? Setting this property to <code>false</code> will render the hint on a single line without
     * wrapping, expanding the width required to render the item if necessary. <P> If unset this property will be picked up
     * from the {@link com.smartgwt.client.widgets.form.DynamicForm#getWrapHintText DynamicForm.wrapHintText} setting. <P> This
     * setting does not apply to hints that are {@link com.smartgwt.client.widgets.form.fields.TextItem#getShowHintInField
     * shown in field}.
     *
     * @param wrapHintText New wrapHintText value. Default value is false
     * @return {@link com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setMinHintWidth
     */
    public TimeItem setWrapHintText(Boolean wrapHintText) {
        return (TimeItem)setAttribute("wrapHintText", wrapHintText);
    }

    /**
     * If this item is showing a {@link com.smartgwt.client.widgets.form.fields.FormItem#getHint FormItem.hint}, should the
     * hint text be allowed to wrap? Setting this property to <code>false</code> will render the hint on a single line without
     * wrapping, expanding the width required to render the item if necessary. <P> If unset this property will be picked up
     * from the {@link com.smartgwt.client.widgets.form.DynamicForm#getWrapHintText DynamicForm.wrapHintText} setting. <P> This
     * setting does not apply to hints that are {@link com.smartgwt.client.widgets.form.fields.TextItem#getShowHintInField
     * shown in field}.
     *
     * @return Current wrapHintText value. Default value is false
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getMinHintWidth
     */
    public Boolean getWrapHintText()  {
        Boolean result = getAttributeAsBoolean("wrapHintText", true);
        return result == null ? false : result;
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
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.getEnteredValue();
        return ret;
    }-*/;

	/**
     * Notification method called when {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPending showPending} is
     * enabled and this time item should either clear or show its pending visual state. <p> The default behavior is that the
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getTitleStyle titleStyle} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCellStyle cellStyle} are updated to include/exclude the "Pending"
     * suffix. In addition, when displayed in the pending state: <ul> <li>If {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getUseTextField useTextField} is <code>true</code>, then the "Pending" 
     * suffix will be appended to the {@link com.smartgwt.client.widgets.form.fields.FormItem#getTextBoxStyle textBoxStyle}
     * applied to the     {@link com.smartgwt.client.widgets.form.fields.TimeItem#getTextField textField}; otherwise
     * <li>(<code>useTextField</code> is <code>false</code>) the color of the     {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getHourItem hourItem}, {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMinuteItem minuteItem},     {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getSecondItem secondItem}, {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getMillisecondItem millisecondItem},     and/or {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getAmpmItem ampmItem} will change when the hour, minute, second,    
     * millisecond, or whether the time is AM or PM is different, respectively. </ul> Returning <code>false</code> will cancel
     * this default behavior.
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
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(TimeItem timeItemProperties) /*-{
        if (timeItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(TimeItem.@java.lang.Object::getClass()(), "setDefaultProperties", timeItemProperties.@java.lang.Object::getClass()());
        }
        timeItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var properties = timeItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::getConfig()();
        $wnd.isc.TimeItem.addProperties(properties);
    }-*/;

    // ***********************************************************


    /**
     * Return the value tracked by this form item.
     *
     * @return value of this element
     */
    public native Date getValueAsDate() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (self == null) return null;

        var ret = self.setValue ? self.getValue() : self.value;
        return @com.smartgwt.client.util.JSOHelper::convertToJavaDate(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

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
        return selection == null ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)(selection);
    }-*/;
 

}
