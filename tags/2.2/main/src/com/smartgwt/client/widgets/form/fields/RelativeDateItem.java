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
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * A FormItem for entering a date relative to today or relative to some other date, or a specific date.  Typically used for
 * filtering data by date. <P> The RelativeDateItem consists of a {@link
 * com.smartgwt.client.widgets.form.fields.ComboBoxItem} where the user may directly choose  one of several {@link
 * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getPresetOptions preset options}, choose to enter a  {@link
 * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getQuantityField quantity} and  time unit  (eg "4 months ago"
 * or "3 years from now") or directly type in  an absolute date value (7/18/2009).
 */
public class RelativeDateItem extends CanvasItem {

    public static RelativeDateItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (RelativeDateItem) obj;
        } else {
            return new RelativeDateItem(jsObj);
        }
    }

    public RelativeDateItem(){
        setType("RelativeDateItem");
    }

    public RelativeDateItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public RelativeDateItem(String name) {
        setName(name);
        setType("RelativeDateItem");
    }

    public RelativeDateItem(String name, String title) {
        setName(name);
		setTitle(title);
        setType("RelativeDateItem");
    }

    // ********************* Properties / Attributes ***********************

    /**
     * Base date for calculating the relative date entered by the user. <P> The default is to use the current date.
     *
     * @param baseDate baseDate Default value is null
     */
    public void setBaseDate(java.util.Date baseDate) {
        setAttribute("baseDate", baseDate);
    }

    /**
     * Base date for calculating the relative date entered by the user. <P> The default is to use the current date.
     *
     *
     * @return java.util.Date
     */
    public java.util.Date getBaseDate()  {
        return getAttributeAsDate("baseDate");
    }

    /**
     * Only used if we're showing the date in a text field. When parsing a date, if the year is specified with only 2 digits
     * and is less than the centuryThreshold, then the year will be assumed to be 20xx; otherwise it will be interpreted
     * according to default browser behaviour, which will consider it to be 19xx.
     *
     * @param centuryThreshold centuryThreshold Default value is 25
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setCenturyThreshold(int centuryThreshold) {
        setAttribute("centuryThreshold", centuryThreshold);
    }

    /**
     * Only used if we're showing the date in a text field. When parsing a date, if the year is specified with only 2 digits
     * and is less than the centuryThreshold, then the year will be assumed to be 20xx; otherwise it will be interpreted
     * according to default browser behaviour, which will consider it to be 19xx.
     *
     *
     * @return int
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getCenturyThreshold()  {
        return getAttributeAsInt("centuryThreshold");
    }

    /**
     * The title to show for historical periods when the TimeUnit is "day".
     *
     * @param daysAgoTitle daysAgoTitle Default value is "N days ago"
     */
    public void setDaysAgoTitle(String daysAgoTitle) {
        setAttribute("daysAgoTitle", daysAgoTitle);
    }

    /**
     * The title to show for historical periods when the TimeUnit is "day".
     *
     *
     * @return String
     */
    public String getDaysAgoTitle()  {
        return getAttributeAsString("daysAgoTitle");
    }

    /**
     * The title to show for future periods when the TimeUnit is "day".
     *
     * @param daysFromNowTitle daysFromNowTitle Default value is "N days from now"
     */
    public void setDaysFromNowTitle(String daysFromNowTitle) {
        setAttribute("daysFromNowTitle", daysFromNowTitle);
    }

    /**
     * The title to show for future periods when the TimeUnit is "day".
     *
     *
     * @return String
     */
    public String getDaysFromNowTitle()  {
        return getAttributeAsString("daysFromNowTitle");
    }

    /**
     * Default quantity to show in the {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem#getQuantityField
     * quantityField}.
     *
     * @param defaultQuantity defaultQuantity Default value is 1
     */
    public void setDefaultQuantity(int defaultQuantity) {
        setAttribute("defaultQuantity", defaultQuantity);
    }

    /**
     * Default quantity to show in the {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem#getQuantityField
     * quantityField}.
     *
     *
     * @return int
     */
    public int getDefaultQuantity()  {
        return getAttributeAsInt("defaultQuantity");
    }

    /**
     * Maximum date the selectors will allow the user to pick. <P> See {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getStartDate startDate} for details on how this restriction works.
     *
     * @param endDate endDate Default value is 12/31/2015
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setEndDate(java.util.Date endDate) {
        setAttribute("endDate", endDate);
    }

    /**
     * Maximum date the selectors will allow the user to pick. <P> See {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getStartDate startDate} for details on how this restriction works.
     *
     *
     * @return java.util.Date
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public java.util.Date getEndDate()  {
        return getAttributeAsDate("endDate");
    }

    /**
     * The title to show for historical periods when the TimeUnit is "hour".
     *
     * @param hoursAgoTitle hoursAgoTitle Default value is "N hours ago"
     */
    public void setHoursAgoTitle(String hoursAgoTitle) {
        setAttribute("hoursAgoTitle", hoursAgoTitle);
    }

    /**
     * The title to show for historical periods when the TimeUnit is "hour".
     *
     *
     * @return String
     */
    public String getHoursAgoTitle()  {
        return getAttributeAsString("hoursAgoTitle");
    }

    /**
     * The title to show for future periods when the TimeUnit is "hour".
     *
     * @param hoursFromNowTitle hoursFromNowTitle Default value is "N hours from now"
     */
    public void setHoursFromNowTitle(String hoursFromNowTitle) {
        setAttribute("hoursFromNowTitle", hoursFromNowTitle);
    }

    /**
     * The title to show for future periods when the TimeUnit is "hour".
     *
     *
     * @return String
     */
    public String getHoursFromNowTitle()  {
        return getAttributeAsString("hoursFromNowTitle");
    }

    /**
     * Format for direct user input of date values. <P> If unset, the input format will be determined based on the specified
     * {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem#getDisplayFormat displayFormat} if possible, otherwise
     * picked up from the Date class (see  Date.setInputFormat).
     *
     * @param inputFormat inputFormat Default value is null
     */
    public void setInputFormat(String inputFormat) {
        setAttribute("inputFormat", inputFormat);
    }

    /**
     * Format for direct user input of date values. <P> If unset, the input format will be determined based on the specified
     * {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem#getDisplayFormat displayFormat} if possible, otherwise
     * picked up from the Date class (see  Date.setInputFormat).
     *
     *
     * @return If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is <code>true</code> this
     * method returns a standard {@link java.lang.String}, or parsing function, determining how values entered by the user are
     * to be converted to Javascript Date objects. <P> If an explicit {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat inputFormat} has been specified it will be returned. <P>
     * Otherwise, if an explicit {@link com.smartgwt.client.widgets.form.fields.DateItem#getDisplayFormat displayFormat} has
     * been specified as one of <code>toUSShortDate</code>, <code>toEuropeanShortDate</code> or <code>toJapanShortDate</code>
     * this method will return the appropriate DateInputFormat to parse strings entered in the specified displayFormat. <P> If
     * no inputFormat can be derived, the method will return null, meaning the standard input format for Date objects
     * (specified via  Date.setInputFormat) will be used.
     */
    public String getInputFormat()  {
        return getAttributeAsString("inputFormat");
    }

    /**
     * The title to show for historical periods when the TimeUnit is "millisecond".
     *
     * @param millisecondsAgoTitle millisecondsAgoTitle Default value is "N milliseconds ago"
     */
    public void setMillisecondsAgoTitle(String millisecondsAgoTitle) {
        setAttribute("millisecondsAgoTitle", millisecondsAgoTitle);
    }

    /**
     * The title to show for historical periods when the TimeUnit is "millisecond".
     *
     *
     * @return String
     */
    public String getMillisecondsAgoTitle()  {
        return getAttributeAsString("millisecondsAgoTitle");
    }

    /**
     * The title to show for future periods when the TimeUnit is "millisecond".
     *
     * @param millisecondsFromNowTitle millisecondsFromNowTitle Default value is "N milliseconds from now"
     */
    public void setMillisecondsFromNowTitle(String millisecondsFromNowTitle) {
        setAttribute("millisecondsFromNowTitle", millisecondsFromNowTitle);
    }

    /**
     * The title to show for future periods when the TimeUnit is "millisecond".
     *
     *
     * @return String
     */
    public String getMillisecondsFromNowTitle()  {
        return getAttributeAsString("millisecondsFromNowTitle");
    }

    /**
     * The title to show for historical periods when the TimeUnit is "minute".
     *
     * @param minutesAgoTitle minutesAgoTitle Default value is "N minutes ago"
     */
    public void setMinutesAgoTitle(String minutesAgoTitle) {
        setAttribute("minutesAgoTitle", minutesAgoTitle);
    }

    /**
     * The title to show for historical periods when the TimeUnit is "minute".
     *
     *
     * @return String
     */
    public String getMinutesAgoTitle()  {
        return getAttributeAsString("minutesAgoTitle");
    }

    /**
     * The title to show for future periods when the TimeUnit is "minute".
     *
     * @param minutesFromNowTitle minutesFromNowTitle Default value is "N minutes from now"
     */
    public void setMinutesFromNowTitle(String minutesFromNowTitle) {
        setAttribute("minutesFromNowTitle", minutesFromNowTitle);
    }

    /**
     * The title to show for future periods when the TimeUnit is "minute".
     *
     *
     * @return String
     */
    public String getMinutesFromNowTitle()  {
        return getAttributeAsString("minutesFromNowTitle");
    }

    /**
     * The title to show for historical periods when the TimeUnit is "month".
     *
     * @param monthsAgoTitle monthsAgoTitle Default value is "N months ago"
     */
    public void setMonthsAgoTitle(String monthsAgoTitle) {
        setAttribute("monthsAgoTitle", monthsAgoTitle);
    }

    /**
     * The title to show for historical periods when the TimeUnit is "month".
     *
     *
     * @return String
     */
    public String getMonthsAgoTitle()  {
        return getAttributeAsString("monthsAgoTitle");
    }

    /**
     * The title to show for future periods when the TimeUnit is "month".
     *
     * @param monthsFromNowTitle monthsFromNowTitle Default value is "N months from now"
     */
    public void setMonthsFromNowTitle(String monthsFromNowTitle) {
        setAttribute("monthsFromNowTitle", monthsFromNowTitle);
    }

    /**
     * The title to show for future periods when the TimeUnit is "month".
     *
     *
     * @return String
     */
    public String getMonthsFromNowTitle()  {
        return getAttributeAsString("monthsFromNowTitle");
    }

    /**
     * What operator to use when {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem#getCriterion
     * RelativeDateItem.getCriterion} is called.
     *
     * @param operator operator Default value is "greaterThan"
     */
    public void setOperator(OperatorId operator) {
        setAttribute("operator", operator.getValue());
    }

    /**
     * What operator to use when {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem#getCriterion
     * RelativeDateItem.getCriterion} is called.
     *
     *
     * @return OperatorId
     */
    public OperatorId getOperator()  {
        return EnumUtil.getEnum(OperatorId.values(), getAttribute("operator"));
    }

    /**
     * Smart GWT class for the {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem#getPicker dateChooser} autoChild
     * displayed to allow the user to directly select dates.
     *
     * @param pickerConstructor pickerConstructor Default value is "DateChooser"
     */
    public void setPickerConstructor(String pickerConstructor) {
        setAttribute("pickerConstructor", pickerConstructor);
    }

    /**
     * Smart GWT class for the {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem#getPicker dateChooser} autoChild
     * displayed to allow the user to directly select dates.
     *
     *
     * @return String
     */
    public String getPickerConstructor()  {
        return getAttributeAsString("pickerConstructor");
    }

    /**
     * Prompt to show when the user hovers the mouse over the picker icon for this  RelativeDateItem. May be overridden for
     * localization of your application.
     *
     * @param pickerIconPrompt pickerIconPrompt Default value is "Show Date Chooser"
     */
    public void setPickerIconPrompt(String pickerIconPrompt) {
        setAttribute("pickerIconPrompt", pickerIconPrompt);
    }

    /**
     * Prompt to show when the user hovers the mouse over the picker icon for this  RelativeDateItem. May be overridden for
     * localization of your application.
     *
     *
     * @return String
     */
    public String getPickerIconPrompt()  {
        return getAttributeAsString("pickerIconPrompt");
    }

    /**
     * The title to show for historical periods when the TimeUnit is "second".
     *
     * @param secondsAgoTitle secondsAgoTitle Default value is "N seconds ago"
     */
    public void setSecondsAgoTitle(String secondsAgoTitle) {
        setAttribute("secondsAgoTitle", secondsAgoTitle);
    }

    /**
     * The title to show for historical periods when the TimeUnit is "second".
     *
     *
     * @return String
     */
    public String getSecondsAgoTitle()  {
        return getAttributeAsString("secondsAgoTitle");
    }

    /**
     * The title to show for future periods when the TimeUnit is "second".
     *
     * @param secondsFromNowTitle secondsFromNowTitle Default value is "N seconds from now"
     */
    public void setSecondsFromNowTitle(String secondsFromNowTitle) {
        setAttribute("secondsFromNowTitle", secondsFromNowTitle);
    }

    /**
     * The title to show for future periods when the TimeUnit is "second".
     *
     *
     * @return String
     */
    public String getSecondsFromNowTitle()  {
        return getAttributeAsString("secondsFromNowTitle");
    }

    /**
     * Should the Calculated-Date be displayed to the right of the {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getPickerIcon pickerIcon}.
     *
     * @param showCalculatedDateField showCalculatedDateField Default value is true
     */
    public void setShowCalculatedDateField(Boolean showCalculatedDateField) {
        setAttribute("showCalculatedDateField", showCalculatedDateField);
    }

    /**
     * Should the Calculated-Date be displayed to the right of the {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getPickerIcon pickerIcon}.
     *
     *
     * @return Boolean
     */
    public Boolean getShowCalculatedDateField()  {
        return getAttributeAsBoolean("showCalculatedDateField");
    }

    /**
     * Should we show the icon that shells a date-chooser?
     *
     * @param showChooserIcon showChooserIcon Default value is true
     */
    public void setShowChooserIcon(Boolean showChooserIcon) {
        setAttribute("showChooserIcon", showChooserIcon);
    }

    /**
     * Should we show the icon that shells a date-chooser?
     *
     *
     * @return Boolean
     */
    public Boolean getShowChooserIcon()  {
        return getAttributeAsBoolean("showChooserIcon");
    }

    /**
     * Minimum date the selectors will allow the user to pick. <P> <b>NOTE:</b> by design, setting <code>startDate</code> and
     * <code>endDate</code> will not always prevent the user from picking invalid values.  In particular: <ul> <li> the set of
     * available days will only be restricted if the start and end dates fall within the same month <li> the set of available
     * months will only be restricted if the start and end dates fall within the same year </ul> <P> This is <b>by design</b>
     * as it allows the user to set the day, month and year in whatever order is convenient, rather than forcing them to pick
     * in a specific order. <P> For actual enforcement of a date being in correct range before data is submitted, a {@link
     * com.smartgwt.client.widgets.form.validator.Validator} of type "dateRange" should always be declared.
     *
     * @param startDate startDate Default value is 1/1/1995
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setStartDate(java.util.Date startDate) {
        setAttribute("startDate", startDate);
    }

    /**
     * Minimum date the selectors will allow the user to pick. <P> <b>NOTE:</b> by design, setting <code>startDate</code> and
     * <code>endDate</code> will not always prevent the user from picking invalid values.  In particular: <ul> <li> the set of
     * available days will only be restricted if the start and end dates fall within the same month <li> the set of available
     * months will only be restricted if the start and end dates fall within the same year </ul> <P> This is <b>by design</b>
     * as it allows the user to set the day, month and year in whatever order is convenient, rather than forcing them to pick
     * in a specific order. <P> For actual enforcement of a date being in correct range before data is submitted, a {@link
     * com.smartgwt.client.widgets.form.validator.Validator} of type "dateRange" should always be declared.
     *
     *
     * @return java.util.Date
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public java.util.Date getStartDate()  {
        return getAttributeAsDate("startDate");
    }

    /**
     * The title to show when the no {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem#getBaseDate baseDate} is
     * provided and the default becomes today.
     *
     * @param todayTitle todayTitle Default value is "Today"
     */
    public void setTodayTitle(String todayTitle) {
        setAttribute("todayTitle", todayTitle);
    }

    /**
     * The title to show when the no {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem#getBaseDate baseDate} is
     * provided and the default becomes today.
     *
     *
     * @return String
     */
    public String getTodayTitle()  {
        return getAttributeAsString("todayTitle");
    }

    /**
     * When set to true (the default), use a single shared date-picker across all widgets that use one.  When false, create a
     * new picker using the autoChild system.  See  {@link com.smartgwt.client.widgets.form.fields.DateItem#getPickerDefaults
     * picker} and  {@link com.smartgwt.client.widgets.form.fields.DateItem#getPickerProperties pickerProperties} for details
     * on setting up an unshared picker.
     *
     * @param useSharedPicker useSharedPicker Default value is true
     */
    public void setUseSharedPicker(Boolean useSharedPicker) {
        setAttribute("useSharedPicker", useSharedPicker);
    }

    /**
     * When set to true (the default), use a single shared date-picker across all widgets that use one.  When false, create a
     * new picker using the autoChild system.  See  {@link com.smartgwt.client.widgets.form.fields.DateItem#getPickerDefaults
     * picker} and  {@link com.smartgwt.client.widgets.form.fields.DateItem#getPickerProperties pickerProperties} for details
     * on setting up an unshared picker.
     *
     *
     * @return Boolean
     */
    public Boolean getUseSharedPicker()  {
        return getAttributeAsBoolean("useSharedPicker");
    }

    /**
     * The title to show for historical periods when the TimeUnit is "week".
     *
     * @param weeksAgoTitle weeksAgoTitle Default value is "N weeks ago"
     */
    public void setWeeksAgoTitle(String weeksAgoTitle) {
        setAttribute("weeksAgoTitle", weeksAgoTitle);
    }

    /**
     * The title to show for historical periods when the TimeUnit is "week".
     *
     *
     * @return String
     */
    public String getWeeksAgoTitle()  {
        return getAttributeAsString("weeksAgoTitle");
    }

    /**
     * The title to show for future periods when the TimeUnit is "week".
     *
     * @param weeksFromNowTitle weeksFromNowTitle Default value is "N weeks from now"
     */
    public void setWeeksFromNowTitle(String weeksFromNowTitle) {
        setAttribute("weeksFromNowTitle", weeksFromNowTitle);
    }

    /**
     * The title to show for future periods when the TimeUnit is "week".
     *
     *
     * @return String
     */
    public String getWeeksFromNowTitle()  {
        return getAttributeAsString("weeksFromNowTitle");
    }

    /**
     * The title to show for historical periods when the TimeUnit is "year".
     *
     * @param yearsAgoTitle yearsAgoTitle Default value is "N years ago"
     */
    public void setYearsAgoTitle(String yearsAgoTitle) {
        setAttribute("yearsAgoTitle", yearsAgoTitle);
    }

    /**
     * The title to show for historical periods when the TimeUnit is "year".
     *
     *
     * @return String
     */
    public String getYearsAgoTitle()  {
        return getAttributeAsString("yearsAgoTitle");
    }

    /**
     * The title to show for future periods when the TimeUnit is "year".
     *
     * @param yearsFromNowTitle yearsFromNowTitle Default value is "N years from now"
     */
    public void setYearsFromNowTitle(String yearsFromNowTitle) {
        setAttribute("yearsFromNowTitle", yearsFromNowTitle);
    }

    /**
     * The title to show for future periods when the TimeUnit is "year".
     *
     *
     * @return String
     */
    public String getYearsFromNowTitle()  {
        return getAttributeAsString("yearsFromNowTitle");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
        
    // ***********************************************************        


    /**
     * Returns the RelativeDate for the current value.
     *
     * @return the RelativeDate for the current value or null if not set
     */
    public native RelativeDate getRelativeDate() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var retVal = self.getRelativeDate();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.data.RelativeDate::new(Lcom/google/gwt/core/client/JavaScriptObject;)(retVal);
        }
    }-*/;
    
    /**
     * Converts a RelativeDate to a concrete Date.
     * @param relativeDate the relative date to convert
     *
     * @return resulting absolute date value
     */
    public static native Date getAbsoluteDate(RelativeDate relativeDate) /*-{
        var retVal =$wnd.isc.RelativeDateItem.getAbsoluteDate(relativeDate.@com.smartgwt.client.data.RelativeDate::getValue()());
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toDate(D)(retVal.getTime());
        }
    }-*/;

    /**
     * Converts a RelativeDate to a concrete Date.
     * @param relativeDate the relative date to convert
     * @param baseDate base value for conversion.  Defaults to today
     *
     * @return resulting absolute date value
     */
    public static native Date getAbsoluteDate(RelativeDate relativeDate, Date baseDate) /*-{
        var retVal =$wnd.isc.RelativeDateItem.getAbsoluteDate(relativeDate.@com.smartgwt.client.data.RelativeDate::getValue()(),
                                                              @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(baseDate));
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
                return @com.smartgwt.client.util.JSOHelper::toDate(D)(retVal.getTime());
        }
    }-*/;

}



