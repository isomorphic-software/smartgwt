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

import com.google.gwt.event.shared.*;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.smartgwt.client.util.workflow.Process; // required to override java.lang.Process


/**
 * A FormItem for entering a date relative to today or relative to some other date, or a specific date.  Typically used for
 * filtering data by date. <P> The RelativeDateItem consists of a {@link
 * com.smartgwt.client.widgets.form.fields.ComboBoxItem} where the user may directly choose  one of several {@link
 * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getPresetOptions preset options}, choose to enter a  {@link
 * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getQuantityField quantity} and {@link
 * com.smartgwt.client.types.TimeUnit time unit}  (eg "4 months ago" or "3 years from now") or directly type in  an
 * absolute date value (7/18/2009).
 */
@BeanFactory.FrameworkClass
public class RelativeDateItem extends CanvasItem {

    public static RelativeDateItem getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof RelativeDateItem) {
            existingObj.setJsObj(jsObj);
            return (RelativeDateItem)existingObj;
        } else

        {
            return new RelativeDateItem(jsObj);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(RelativeDateItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.RelativeDateItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(RelativeDateItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.RelativeDateItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public static native void changePickerIconDefaults(FormItemIcon defaults) /*-{
        $wnd.isc.RelativeDateItem.changeDefaults("pickerIconDefaults", defaults.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public RelativeDateItem(){
        setAttribute("editorType", "RelativeDateItem");
    }

    public RelativeDateItem(JavaScriptObject jsObj){
        super(jsObj);
    }


    public RelativeDateItem(String name) {
        setName(name);
                setAttribute("editorType", "RelativeDateItem");
    }


    public RelativeDateItem(String name, String title) {
        setName(name);
		setTitle(title);
                setAttribute("editorType", "RelativeDateItem");
    }


    // ********************* Properties / Attributes ***********************

    /**
     * When set to false, only relative dates can be entered - in this mode, the  {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getShowChooserIcon date chooser icon} is hidden and the {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getValueField value field} is switched from a {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem}, which allows text-entry, to a  {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem} which does not.
     *
     * @param allowAbsoluteDates New allowAbsoluteDates value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setAllowAbsoluteDates(Boolean allowAbsoluteDates) {
        return (RelativeDateItem)setAttribute("allowAbsoluteDates", allowAbsoluteDates);
    }

    /**
     * When set to false, only relative dates can be entered - in this mode, the  {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getShowChooserIcon date chooser icon} is hidden and the {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getValueField value field} is switched from a {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem}, which allows text-entry, to a  {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem} which does not.
     *
     * @return Current allowAbsoluteDates value. Default value is true
     */
    public Boolean getAllowAbsoluteDates()  {
        Boolean result = getAttributeAsBoolean("allowAbsoluteDates", true);
        return result == null ? true : result;
    }
    

    /**
     * Base date for calculating the relative date entered by the user. <P> The default is to use the current date.
     *
     * @param baseDate New baseDate value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setBaseDate(Date baseDate) {
        return (RelativeDateItem)setAttribute("baseDate", baseDate);
    }

    /**
     * Base date for calculating the relative date entered by the user. <P> The default is to use the current date.
     *
     * @return Current baseDate value. Default value is null
     */
    public Date getBaseDate()  {
        return getAttributeAsDate("baseDate");
    }
    

    /**
     * Field that shows the current calculated date by adding the user-entered relative date to the {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getBaseDate baseDate}.
     * <p>
     * This component is an AutoChild named "calculatedDateField".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current calculatedDateField value. Default value is null
     */
    public BlurbItem getCalculatedDateField()  {
        return BlurbItem.getOrCreateRef(getAttributeAsJavaScriptObject("calculatedDateField"));
    }
    

    /**
     * Only used if we're showing the date in a text field. When parsing a date, if the year is specified with 1 or 2 digits
     * and is less than the centuryThreshold, then the year will be assumed to be 20xx; otherwise it will be interpreted
     * according to default browser behaviour, which will consider it to be 19xx. <P> If you need to allow 1 and 2 digit years,
     * set this attribute to  <code>null</code> to have the control retain your year-value as entered.
     *
     * @param centuryThreshold New centuryThreshold value. Default value is 25
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public RelativeDateItem setCenturyThreshold(int centuryThreshold) {
        return (RelativeDateItem)setAttribute("centuryThreshold", centuryThreshold);
    }

    /**
     * Only used if we're showing the date in a text field. When parsing a date, if the year is specified with 1 or 2 digits
     * and is less than the centuryThreshold, then the year will be assumed to be 20xx; otherwise it will be interpreted
     * according to default browser behaviour, which will consider it to be 19xx. <P> If you need to allow 1 and 2 digit years,
     * set this attribute to  <code>null</code> to have the control retain your year-value as entered.
     *
     * @return Current centuryThreshold value. Default value is 25
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getCenturyThreshold()  {
        return getAttributeAsInt("centuryThreshold");
    }
    
    

    /**
     * The title to show for historical periods when the {@link com.smartgwt.client.types.TimeUnit} is "day".
     *
     * @param daysAgoTitle New daysAgoTitle value. Default value is "N days ago"
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setDaysAgoTitle(String daysAgoTitle) {
        return (RelativeDateItem)setAttribute("daysAgoTitle", daysAgoTitle);
    }

    /**
     * The title to show for historical periods when the {@link com.smartgwt.client.types.TimeUnit} is "day".
     *
     * @return Current daysAgoTitle value. Default value is "N days ago"
     */
    public String getDaysAgoTitle()  {
        return getAttributeAsString("daysAgoTitle");
    }
    

    /**
     * The title to show for future periods when the {@link com.smartgwt.client.types.TimeUnit} is "day".
     *
     * @param daysFromNowTitle New daysFromNowTitle value. Default value is "N days from now"
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setDaysFromNowTitle(String daysFromNowTitle) {
        return (RelativeDateItem)setAttribute("daysFromNowTitle", daysFromNowTitle);
    }

    /**
     * The title to show for future periods when the {@link com.smartgwt.client.types.TimeUnit} is "day".
     *
     * @return Current daysFromNowTitle value. Default value is "N days from now"
     */
    public String getDaysFromNowTitle()  {
        return getAttributeAsString("daysFromNowTitle");
    }
    

    /**
     * Default quantity to show in the {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem#getQuantityField
     * quantityField}.
     *
     * @param defaultQuantity New defaultQuantity value. Default value is 1
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setDefaultQuantity(int defaultQuantity) {
        return (RelativeDateItem)setAttribute("defaultQuantity", defaultQuantity);
    }

    /**
     * Default quantity to show in the {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem#getQuantityField
     * quantityField}.
     *
     * @return Current defaultQuantity value. Default value is 1
     */
    public int getDefaultQuantity()  {
        return getAttributeAsInt("defaultQuantity");
    }
    
    
    

    /**
     * Maximum date the selectors will allow the user to pick.  The default value is December  31st, 5 years after the current
     * year. <P> See {@link com.smartgwt.client.widgets.form.fields.DateItem#getStartDate DateItem.startDate} for details on
     * how this restriction works.
     *
     * @param endDate New endDate value. Default value is 12/31/2020
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public RelativeDateItem setEndDate(Date endDate) {
        return (RelativeDateItem)setAttribute("endDate", endDate);
    }

    /**
     * Maximum date the selectors will allow the user to pick.  The default value is December  31st, 5 years after the current
     * year. <P> See {@link com.smartgwt.client.widgets.form.fields.DateItem#getStartDate DateItem.startDate} for details on
     * how this restriction works.
     *
     * @return Current endDate value. Default value is 12/31/2020
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Date getEndDate()  {
        return getAttributeAsDate("endDate");
    }
    

    /**
     * The title to show for historical periods when the {@link com.smartgwt.client.types.TimeUnit} is "hour".
     *
     * @param hoursAgoTitle New hoursAgoTitle value. Default value is "N hours ago"
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setHoursAgoTitle(String hoursAgoTitle) {
        return (RelativeDateItem)setAttribute("hoursAgoTitle", hoursAgoTitle);
    }

    /**
     * The title to show for historical periods when the {@link com.smartgwt.client.types.TimeUnit} is "hour".
     *
     * @return Current hoursAgoTitle value. Default value is "N hours ago"
     */
    public String getHoursAgoTitle()  {
        return getAttributeAsString("hoursAgoTitle");
    }
    

    /**
     * The title to show for future periods when the {@link com.smartgwt.client.types.TimeUnit} is "hour".
     *
     * @param hoursFromNowTitle New hoursFromNowTitle value. Default value is "N hours from now"
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setHoursFromNowTitle(String hoursFromNowTitle) {
        return (RelativeDateItem)setAttribute("hoursFromNowTitle", hoursFromNowTitle);
    }

    /**
     * The title to show for future periods when the {@link com.smartgwt.client.types.TimeUnit} is "hour".
     *
     * @return Current hoursFromNowTitle value. Default value is "N hours from now"
     */
    public String getHoursFromNowTitle()  {
        return getAttributeAsString("hoursFromNowTitle");
    }
    

    /**
     * Format for direct user input of date values. <P> If unset, the input format will be determined based on the specified
     * {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem#getDisplayFormat displayFormat} if possible, otherwise
     * picked up from the Date class (see {@link com.smartgwt.client.util.DateUtil#setInputFormat DateUtil.setInputFormat()}).
     *
     * @param inputFormat New inputFormat value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.DateInputFormat DateInputFormat 
     */
    public RelativeDateItem setInputFormat(String inputFormat) {
        return (RelativeDateItem)setAttribute("inputFormat", inputFormat);
    }

    /**
     * Format for direct user input of date values. <P> If unset, the input format will be determined based on the specified
     * {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem#getDisplayFormat displayFormat} if possible, otherwise
     * picked up from the Date class (see {@link com.smartgwt.client.util.DateUtil#setInputFormat DateUtil.setInputFormat()}).
     *
     * @return If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField DateItem.useTextField} is <code>true</code>
     * this method returns a standard {@link com.smartgwt.client.docs.DateInputFormat}, determining how values entered by the
     * user are to be converted to Javascript Date objects. <P> If an explicit {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat DateItem.inputFormat} has been specified it will be
     * returned, otherwise, if a custom {@link com.smartgwt.client.widgets.form.fields.DateItem#getDateFormatter
     * DateItem.dateFormatter} or {@link com.smartgwt.client.widgets.form.fields.FormItem#getFormat FormItem.format} are
     * specified, the input format will be automatically derived from that property. <P> Otherwise, the global {@link
     * com.smartgwt.client.util.DateUtil#setInputFormat inputFormat} is used. <P> Note that the inputFormat will ignore any
     * separator characters and padding of values. However if necessary entirely custom date formatting and parsing may be
     * achieved via the  <code>setEditorValueFormatter()</code> and  <code>setEditorValueParser()</code> APIs. Default value is null
     * @see com.smartgwt.client.docs.DateInputFormat DateInputFormat 
     */
    public String getInputFormat()  {
        return getAttributeAsString("inputFormat");
    }
    

    /**
     * Maximum value to allow in the {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem#getQuantityField
     * quantityField}.  Increasing this value may result in date miscalculations for very large numbers, due to Javascript Date
     * limitations.
     *
     * @param maxQuantity New maxQuantity value. Default value is 999999
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setMaxQuantity(int maxQuantity) {
        return (RelativeDateItem)setAttribute("maxQuantity", maxQuantity);
    }

    /**
     * Maximum value to allow in the {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem#getQuantityField
     * quantityField}.  Increasing this value may result in date miscalculations for very large numbers, due to Javascript Date
     * limitations.
     *
     * @return Current maxQuantity value. Default value is 999999
     */
    public int getMaxQuantity()  {
        return getAttributeAsInt("maxQuantity");
    }
    

    /**
     * The title to show for historical periods when the {@link com.smartgwt.client.types.TimeUnit} is "millisecond".
     *
     * @param millisecondsAgoTitle New millisecondsAgoTitle value. Default value is "N milliseconds ago"
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setMillisecondsAgoTitle(String millisecondsAgoTitle) {
        return (RelativeDateItem)setAttribute("millisecondsAgoTitle", millisecondsAgoTitle);
    }

    /**
     * The title to show for historical periods when the {@link com.smartgwt.client.types.TimeUnit} is "millisecond".
     *
     * @return Current millisecondsAgoTitle value. Default value is "N milliseconds ago"
     */
    public String getMillisecondsAgoTitle()  {
        return getAttributeAsString("millisecondsAgoTitle");
    }
    

    /**
     * The title to show for future periods when the {@link com.smartgwt.client.types.TimeUnit} is "millisecond".
     *
     * @param millisecondsFromNowTitle New millisecondsFromNowTitle value. Default value is "N milliseconds from now"
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setMillisecondsFromNowTitle(String millisecondsFromNowTitle) {
        return (RelativeDateItem)setAttribute("millisecondsFromNowTitle", millisecondsFromNowTitle);
    }

    /**
     * The title to show for future periods when the {@link com.smartgwt.client.types.TimeUnit} is "millisecond".
     *
     * @return Current millisecondsFromNowTitle value. Default value is "N milliseconds from now"
     */
    public String getMillisecondsFromNowTitle()  {
        return getAttributeAsString("millisecondsFromNowTitle");
    }
    

    /**
     * Minimum value to allow in the {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem#getQuantityField
     * quantityField}.
     *
     * @param minQuantity New minQuantity value. Default value is 0
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setMinQuantity(int minQuantity) {
        return (RelativeDateItem)setAttribute("minQuantity", minQuantity);
    }

    /**
     * Minimum value to allow in the {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem#getQuantityField
     * quantityField}.
     *
     * @return Current minQuantity value. Default value is 0
     */
    public int getMinQuantity()  {
        return getAttributeAsInt("minQuantity");
    }
    

    /**
     * The title to show for historical periods when the {@link com.smartgwt.client.types.TimeUnit} is "minute".
     *
     * @param minutesAgoTitle New minutesAgoTitle value. Default value is "N minutes ago"
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setMinutesAgoTitle(String minutesAgoTitle) {
        return (RelativeDateItem)setAttribute("minutesAgoTitle", minutesAgoTitle);
    }

    /**
     * The title to show for historical periods when the {@link com.smartgwt.client.types.TimeUnit} is "minute".
     *
     * @return Current minutesAgoTitle value. Default value is "N minutes ago"
     */
    public String getMinutesAgoTitle()  {
        return getAttributeAsString("minutesAgoTitle");
    }
    

    /**
     * The title to show for future periods when the {@link com.smartgwt.client.types.TimeUnit} is "minute".
     *
     * @param minutesFromNowTitle New minutesFromNowTitle value. Default value is "N minutes from now"
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setMinutesFromNowTitle(String minutesFromNowTitle) {
        return (RelativeDateItem)setAttribute("minutesFromNowTitle", minutesFromNowTitle);
    }

    /**
     * The title to show for future periods when the {@link com.smartgwt.client.types.TimeUnit} is "minute".
     *
     * @return Current minutesFromNowTitle value. Default value is "N minutes from now"
     */
    public String getMinutesFromNowTitle()  {
        return getAttributeAsString("minutesFromNowTitle");
    }
    

    /**
     * The title to show for historical periods when the {@link com.smartgwt.client.types.TimeUnit} is "month".
     *
     * @param monthsAgoTitle New monthsAgoTitle value. Default value is "N months ago"
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setMonthsAgoTitle(String monthsAgoTitle) {
        return (RelativeDateItem)setAttribute("monthsAgoTitle", monthsAgoTitle);
    }

    /**
     * The title to show for historical periods when the {@link com.smartgwt.client.types.TimeUnit} is "month".
     *
     * @return Current monthsAgoTitle value. Default value is "N months ago"
     */
    public String getMonthsAgoTitle()  {
        return getAttributeAsString("monthsAgoTitle");
    }
    

    /**
     * The title to show for future periods when the {@link com.smartgwt.client.types.TimeUnit} is "month".
     *
     * @param monthsFromNowTitle New monthsFromNowTitle value. Default value is "N months from now"
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setMonthsFromNowTitle(String monthsFromNowTitle) {
        return (RelativeDateItem)setAttribute("monthsFromNowTitle", monthsFromNowTitle);
    }

    /**
     * The title to show for future periods when the {@link com.smartgwt.client.types.TimeUnit} is "month".
     *
     * @return Current monthsFromNowTitle value. Default value is "N months from now"
     */
    public String getMonthsFromNowTitle()  {
        return getAttributeAsString("monthsFromNowTitle");
    }
    

    /**
     * What operator to use when  the <code>FormItemCriterionGetter</code>'s <code>getCriterion()</code> method is called.
     *
     * @param operator New operator value. Default value is "greaterThan"
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setOperator(OperatorId operator) {
        return (RelativeDateItem)setAttribute("operator", operator == null ? null : operator.getValue());
    }

    /**
     * What operator to use when  the <code>FormItemCriterionGetter</code>'s <code>getCriterion()</code> method is called.
     *
     * @return Current operator value. Default value is "greaterThan"
     */
    public OperatorId getOperator()  {
        return EnumUtil.getEnum(OperatorId.values(), getAttribute("operator"));
    }
    

    /**
     * Smart GWT class for the {@link com.smartgwt.client.widgets.DateChooser dateChooser} autoChild displayed to allow the
     * user to directly select dates.
     *
     * @param pickerConstructor New pickerConstructor value. Default value is "DateChooser"
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setPickerConstructor(String pickerConstructor) {
        return (RelativeDateItem)setAttribute("pickerConstructor", pickerConstructor);
    }

    /**
     * Smart GWT class for the {@link com.smartgwt.client.widgets.DateChooser dateChooser} autoChild displayed to allow the
     * user to directly select dates.
     *
     * @return Current pickerConstructor value. Default value is "DateChooser"
     */
    public String getPickerConstructor()  {
        return getAttributeAsString("pickerConstructor");
    }
    

    /**
     * Icon that launches a {@link com.smartgwt.client.widgets.DateChooser} for choosing an absolute date.
     * <p>
     * This component is an AutoChild named "pickerIcon".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current pickerIcon value. Default value is null
     */
    public FormItemIcon getPickerIcon()  {
        return new FormItemIcon(getAttributeAsJavaScriptObject("pickerIcon"));
    }
    

    /**
     * Prompt to show when the user hovers the mouse over the picker icon for this  RelativeDateItem. May be overridden for
     * localization of your application.
     *
     * @param pickerIconPrompt New pickerIconPrompt value. Default value is "Show Date Chooser"
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public RelativeDateItem setPickerIconPrompt(String pickerIconPrompt) {
        return (RelativeDateItem)setAttribute("pickerIconPrompt", pickerIconPrompt);
    }

    /**
     * Prompt to show when the user hovers the mouse over the picker icon for this  RelativeDateItem. May be overridden for
     * localization of your application.
     *
     * @return Current pickerIconPrompt value. Default value is "Show Date Chooser"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getPickerIconPrompt()  {
        return getAttributeAsString("pickerIconPrompt");
    }
    

    /**
     * A set of properties to apply to the {@link com.smartgwt.client.widgets.form.fields.TimeItem} displayed in the picker
     * when {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem#getShowPickerTimeItem showPickerTimeItem} is true.
     * <P> Has no effect for fields of type <code>"date"</code>.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param pickerTimeItemProperties New pickerTimeItemProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setPickerTimeItemProperties(TimeItem pickerTimeItemProperties) {
        if (pickerTimeItemProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(RelativeDateItem.class, "setPickerTimeItemProperties", "TimeItem");
        }                                                                       
        pickerTimeItemProperties.setConfigOnly(true);
        return (RelativeDateItem)setAttribute("pickerTimeItemProperties", pickerTimeItemProperties == null ? null : pickerTimeItemProperties.getEditorTypeConfig());
    }

    /**
     * A set of properties to apply to the {@link com.smartgwt.client.widgets.form.fields.TimeItem} displayed in the picker
     * when {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem#getShowPickerTimeItem showPickerTimeItem} is true.
     * <P> Has no effect for fields of type <code>"date"</code>.
     *
     * @return Current pickerTimeItemProperties value. Default value is null
     */
    public TimeItem getPickerTimeItemProperties()  {
        return TimeItem.getOrCreateRef(getAttributeAsJavaScriptObject("pickerTimeItemProperties"));
    }
    
    

    /**
     * Field allowing user to pick units of time, eg, number of days.
     * <p>
     * This component is an AutoChild named "quantityField".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current quantityField value. Default value is null
     */
    public SpinnerItem getQuantityField()  {
        return SpinnerItem.getOrCreateRef(getAttributeAsJavaScriptObject("quantityField"));
    }
    

    /**
     * The title to show for historical periods when the {@link com.smartgwt.client.types.TimeUnit} is "quarter".
     *
     * @param quartersAgoTitle New quartersAgoTitle value. Default value is "N quarters ago"
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setQuartersAgoTitle(String quartersAgoTitle) {
        return (RelativeDateItem)setAttribute("quartersAgoTitle", quartersAgoTitle);
    }

    /**
     * The title to show for historical periods when the {@link com.smartgwt.client.types.TimeUnit} is "quarter".
     *
     * @return Current quartersAgoTitle value. Default value is "N quarters ago"
     */
    public String getQuartersAgoTitle()  {
        return getAttributeAsString("quartersAgoTitle");
    }
    

    /**
     * The title to show for future periods when the {@link com.smartgwt.client.types.TimeUnit} is "quarter".
     *
     * @param quartersFromNowTitle New quartersFromNowTitle value. Default value is "N quarters from now"
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setQuartersFromNowTitle(String quartersFromNowTitle) {
        return (RelativeDateItem)setAttribute("quartersFromNowTitle", quartersFromNowTitle);
    }

    /**
     * The title to show for future periods when the {@link com.smartgwt.client.types.TimeUnit} is "quarter".
     *
     * @return Current quartersFromNowTitle value. Default value is "N quarters from now"
     */
    public String getQuartersFromNowTitle()  {
        return getAttributeAsString("quartersFromNowTitle");
    }
    

    /**
     * Does this items relative date value refer to the start or end of the chosen date? Useful when using this item to
     * generate filter criteria, such as the from or to value for an inclusive range. <P> If unset "start" is assumed.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param rangePosition New rangePosition value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.RelativeDateItem#setOperator
     * @see com.smartgwt.client.widgets.form.fields.RelativeDateItem#setRangeRoundingGranularity
     */
    public RelativeDateItem setRangePosition(RelativeDateRangePosition rangePosition) {
        return (RelativeDateItem)setAttribute("rangePosition", rangePosition == null ? null : rangePosition.getValue());
    }

    /**
     * Does this items relative date value refer to the start or end of the chosen date? Useful when using this item to
     * generate filter criteria, such as the from or to value for an inclusive range. <P> If unset "start" is assumed.
     *
     * @return Current rangePosition value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.RelativeDateItem#getOperator
     * @see com.smartgwt.client.widgets.form.fields.RelativeDateItem#getRangeRoundingGranularity
     */
    public RelativeDateRangePosition getRangePosition()  {
        return EnumUtil.getEnum(RelativeDateRangePosition.values(), getAttribute("rangePosition"));
    }
    
    

    /**
     * The title to show for historical periods when the {@link com.smartgwt.client.types.TimeUnit} is "second".
     *
     * @param secondsAgoTitle New secondsAgoTitle value. Default value is "N seconds ago"
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setSecondsAgoTitle(String secondsAgoTitle) {
        return (RelativeDateItem)setAttribute("secondsAgoTitle", secondsAgoTitle);
    }

    /**
     * The title to show for historical periods when the {@link com.smartgwt.client.types.TimeUnit} is "second".
     *
     * @return Current secondsAgoTitle value. Default value is "N seconds ago"
     */
    public String getSecondsAgoTitle()  {
        return getAttributeAsString("secondsAgoTitle");
    }
    

    /**
     * The title to show for future periods when the {@link com.smartgwt.client.types.TimeUnit} is "second".
     *
     * @param secondsFromNowTitle New secondsFromNowTitle value. Default value is "N seconds from now"
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setSecondsFromNowTitle(String secondsFromNowTitle) {
        return (RelativeDateItem)setAttribute("secondsFromNowTitle", secondsFromNowTitle);
    }

    /**
     * The title to show for future periods when the {@link com.smartgwt.client.types.TimeUnit} is "second".
     *
     * @return Current secondsFromNowTitle value. Default value is "N seconds from now"
     */
    public String getSecondsFromNowTitle()  {
        return getAttributeAsString("secondsFromNowTitle");
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
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setShouldSaveValue(Boolean shouldSaveValue) {
        return (RelativeDateItem)setAttribute("shouldSaveValue", shouldSaveValue);
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
     * Should the Calculated-Date be displayed to the right of the {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getPickerIcon pickerIcon}.
     *
     * @param showCalculatedDateField New showCalculatedDateField value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setShowCalculatedDateField(Boolean showCalculatedDateField) {
        return (RelativeDateItem)setAttribute("showCalculatedDateField", showCalculatedDateField);
    }

    /**
     * Should the Calculated-Date be displayed to the right of the {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getPickerIcon pickerIcon}.
     *
     * @return Current showCalculatedDateField value. Default value is true
     */
    public Boolean getShowCalculatedDateField()  {
        Boolean result = getAttributeAsBoolean("showCalculatedDateField", true);
        return result == null ? true : result;
    }
    

    /**
     * When set to true, show a button that allows the calendar to be navigated by fiscal year.
     *
     * @param showChooserFiscalYearPicker New showChooserFiscalYearPicker value. Default value is false
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setShowChooserFiscalYearPicker(Boolean showChooserFiscalYearPicker) {
        return (RelativeDateItem)setAttribute("showChooserFiscalYearPicker", showChooserFiscalYearPicker);
    }

    /**
     * When set to true, show a button that allows the calendar to be navigated by fiscal year.
     *
     * @return Current showChooserFiscalYearPicker value. Default value is false
     */
    public Boolean getShowChooserFiscalYearPicker()  {
        Boolean result = getAttributeAsBoolean("showChooserFiscalYearPicker", true);
        return result == null ? false : result;
    }
    

    /**
     * Should we show the icon that displays a date-chooser?
     *
     * @param showChooserIcon New showChooserIcon value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setShowChooserIcon(Boolean showChooserIcon) {
        return (RelativeDateItem)setAttribute("showChooserIcon", showChooserIcon);
    }

    /**
     * Should we show the icon that displays a date-chooser?
     *
     * @return Current showChooserIcon value. Default value is true
     */
    public Boolean getShowChooserIcon()  {
        Boolean result = getAttributeAsBoolean("showChooserIcon", true);
        return result == null ? true : result;
    }
    

    /**
     * When set to true, show a button that allows the calendar to be navigated by week or fiscal week, depending on the value
     * of {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem#getShowChooserFiscalYearPicker
     * showChooserFiscalYearPicker}.
     *
     * @param showChooserWeekPicker New showChooserWeekPicker value. Default value is false
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setShowChooserWeekPicker(Boolean showChooserWeekPicker) {
        return (RelativeDateItem)setAttribute("showChooserWeekPicker", showChooserWeekPicker);
    }

    /**
     * When set to true, show a button that allows the calendar to be navigated by week or fiscal week, depending on the value
     * of {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem#getShowChooserFiscalYearPicker
     * showChooserFiscalYearPicker}.
     *
     * @return Current showChooserWeekPicker value. Default value is false
     */
    public Boolean getShowChooserWeekPicker()  {
        Boolean result = getAttributeAsBoolean("showChooserWeekPicker", true);
        return result == null ? false : result;
    }
    

    /**
     * Should we show time-unit options in the future? If set to false, for each  {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getTimeUnitOptions timeUnitOption} we will show only past
     * options [for example "N weeks ago"]. <P> Note: this does not change the {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getPresetOptions presetOptions}, which show up in  addition to
     * the time-unit options (<i>"N days from now"</i>, etc). The default preset options include both past and future presets
     * so developers may wish to modify the presets to ensure only future options are available.
     *
     * @param showFutureOptions New showFutureOptions value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setShowFutureOptions(Boolean showFutureOptions) {
        return (RelativeDateItem)setAttribute("showFutureOptions", showFutureOptions);
    }

    /**
     * Should we show time-unit options in the future? If set to false, for each  {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getTimeUnitOptions timeUnitOption} we will show only past
     * options [for example "N weeks ago"]. <P> Note: this does not change the {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getPresetOptions presetOptions}, which show up in  addition to
     * the time-unit options (<i>"N days from now"</i>, etc). The default preset options include both past and future presets
     * so developers may wish to modify the presets to ensure only future options are available.
     *
     * @return Current showFutureOptions value. Default value is true
     */
    public Boolean getShowFutureOptions()  {
        Boolean result = getAttributeAsBoolean("showFutureOptions", true);
        return result == null ? true : result;
    }
    

    /**
     * Should we show time-unit options in the past? If set to false, for each  {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getTimeUnitOptions timeUnitOption} we will show only future
     * options [for example "N weeks from now"]. <P> Note: this does not change the {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getPresetOptions presetOptions}, which show up in  addition to
     * the time-unit options (<i>"N days from now"</i>, etc). The default preset options include both past and future presets
     * so developers may wish to modify the presets to ensure only past options are available.
     *
     * @param showPastOptions New showPastOptions value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setShowPastOptions(Boolean showPastOptions) {
        return (RelativeDateItem)setAttribute("showPastOptions", showPastOptions);
    }

    /**
     * Should we show time-unit options in the past? If set to false, for each  {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getTimeUnitOptions timeUnitOption} we will show only future
     * options [for example "N weeks from now"]. <P> Note: this does not change the {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getPresetOptions presetOptions}, which show up in  addition to
     * the time-unit options (<i>"N days from now"</i>, etc). The default preset options include both past and future presets
     * so developers may wish to modify the presets to ensure only past options are available.
     *
     * @return Current showPastOptions value. Default value is true
     */
    public Boolean getShowPastOptions()  {
        Boolean result = getAttributeAsBoolean("showPastOptions", true);
        return result == null ? true : result;
    }
    

    /**
     * If this item is editing a field of type <code>"datetime"</code>, should the {@link
     * com.smartgwt.client.widgets.DateChooser} display the {@link com.smartgwt.client.widgets.DateChooser#getShowTimeItem time
     * field},  allowing the user to select a time? <P> One case where developers will wish to suppress this time-field from
     * being displayed is if a custom {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem#getDateFormatter
     * dateFormatter} has been specified which does not display the time portion of the selected date. In this case any value
     * selected from the  DateChooser's time field will be discarded when the picker is dismissed, making it a confusing UI for
     * the end user. <P> Has no effect if the field type is <code>"date"</code> - in this case the picker will never show the
     * time field.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showPickerTimeItem New showPickerTimeItem value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setShowPickerTimeItem(Boolean showPickerTimeItem) {
        return (RelativeDateItem)setAttribute("showPickerTimeItem", showPickerTimeItem);
    }

    /**
     * If this item is editing a field of type <code>"datetime"</code>, should the {@link
     * com.smartgwt.client.widgets.DateChooser} display the {@link com.smartgwt.client.widgets.DateChooser#getShowTimeItem time
     * field},  allowing the user to select a time? <P> One case where developers will wish to suppress this time-field from
     * being displayed is if a custom {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem#getDateFormatter
     * dateFormatter} has been specified which does not display the time portion of the selected date. In this case any value
     * selected from the  DateChooser's time field will be discarded when the picker is dismissed, making it a confusing UI for
     * the end user. <P> Has no effect if the field type is <code>"date"</code> - in this case the picker will never show the
     * time field.
     *
     * @return Current showPickerTimeItem value. Default value is true
     */
    public Boolean getShowPickerTimeItem()  {
        Boolean result = getAttributeAsBoolean("showPickerTimeItem", true);
        return result == null ? true : result;
    }
    

    /**
     * Minimum date the selectors will allow the user to pick.  The default value is January  1st, 10 years before the current
     * year. <P> <b>NOTE:</b> by design, setting <code>startDate</code> and <code>endDate</code> will not always prevent the
     * user from picking invalid values.  In particular: <ul> <li> the set of available days will only be restricted if the
     * start and end dates fall within the same month <li> the set of available months will only be restricted if the start and
     * end dates fall within the same year </ul> <P> This is <b>by design</b> as it allows the user to set the day, month and
     * year in whatever order is convenient, rather than forcing them to pick in a specific order. <P> For actual enforcement
     * of a date being in correct range before data is submitted, a {@link
     * com.smartgwt.client.widgets.form.validator.Validator} of type "dateRange" should always be declared.
     *
     * @param startDate New startDate value. Default value is 1/1/1995
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public RelativeDateItem setStartDate(Date startDate) {
        return (RelativeDateItem)setAttribute("startDate", startDate);
    }

    /**
     * Minimum date the selectors will allow the user to pick.  The default value is January  1st, 10 years before the current
     * year. <P> <b>NOTE:</b> by design, setting <code>startDate</code> and <code>endDate</code> will not always prevent the
     * user from picking invalid values.  In particular: <ul> <li> the set of available days will only be restricted if the
     * start and end dates fall within the same month <li> the set of available months will only be restricted if the start and
     * end dates fall within the same year </ul> <P> This is <b>by design</b> as it allows the user to set the day, month and
     * year in whatever order is convenient, rather than forcing them to pick in a specific order. <P> For actual enforcement
     * of a date being in correct range before data is submitted, a {@link
     * com.smartgwt.client.widgets.form.validator.Validator} of type "dateRange" should always be declared.
     *
     * @return Current startDate value. Default value is 1/1/1995
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Date getStartDate()  {
        return getAttributeAsDate("startDate");
    }
    

    /**
     * List of time units that will be offered for relative dates. <P> Each available time unit option will cause two options
     * to appear in the  {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem#getValueField valueField}.  For
     * example, if "day" is an available {@link com.smartgwt.client.types.TimeUnit time unit} option, there will be {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getDaysAgoTitle "N days ago"} and  {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getDaysFromNowTitle "N days from now"}.
     *
     * @param timeUnitOptions New timeUnitOptions value. Default value is ["day", "week", "month"]
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.RelativeDateItem#setShowPastOptions
     * @see com.smartgwt.client.widgets.form.fields.RelativeDateItem#setShowFutureOptions
     * @see com.smartgwt.client.widgets.form.fields.RelativeDateItem#setRangeRoundingGranularity
     */
    public RelativeDateItem setTimeUnitOptions(TimeUnit... timeUnitOptions) {
        return (RelativeDateItem)setAttribute("timeUnitOptions", timeUnitOptions);
    }

    /**
     * List of time units that will be offered for relative dates. <P> Each available time unit option will cause two options
     * to appear in the  {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem#getValueField valueField}.  For
     * example, if "day" is an available {@link com.smartgwt.client.types.TimeUnit time unit} option, there will be {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getDaysAgoTitle "N days ago"} and  {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getDaysFromNowTitle "N days from now"}.
     *
     * @return Current timeUnitOptions value. Default value is ["day", "week", "month"]
     * @see com.smartgwt.client.widgets.form.fields.RelativeDateItem#getShowPastOptions
     * @see com.smartgwt.client.widgets.form.fields.RelativeDateItem#getShowFutureOptions
     * @see com.smartgwt.client.widgets.form.fields.RelativeDateItem#getRangeRoundingGranularity
     */
    public TimeUnit[] getTimeUnitOptions()  {
        final String[] strings = getAttributeAsStringArray("timeUnitOptions");
        return EnumUtil.getEnums(TimeUnit.values(), strings, strings == null ? null : new TimeUnit[strings.length]);
    }
    

    /**
     * When showing the {@link com.smartgwt.client.widgets.DateChooser}, should the  {@link
     * com.smartgwt.client.widgets.DateChooser#getShowTimeItem time field} be set to use 24-hour time? Has no effect for fields
     * of type <code>"date"</code> rather than  <code>"datetime"</code>, or if {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getShowPickerTimeItem showPickerTimeItem} is
     * <code>false</code>. <P> Default is true.
     *
     * @param use24HourTime New use24HourTime value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setUse24HourTime(Boolean use24HourTime) {
        return (RelativeDateItem)setAttribute("use24HourTime", use24HourTime);
    }

    /**
     * When showing the {@link com.smartgwt.client.widgets.DateChooser}, should the  {@link
     * com.smartgwt.client.widgets.DateChooser#getShowTimeItem time field} be set to use 24-hour time? Has no effect for fields
     * of type <code>"date"</code> rather than  <code>"datetime"</code>, or if {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getShowPickerTimeItem showPickerTimeItem} is
     * <code>false</code>. <P> Default is true.
     *
     * @return Current use24HourTime value. Default value is true
     */
    public Boolean getUse24HourTime()  {
        Boolean result = getAttributeAsBoolean("use24HourTime", true);
        return result == null ? true : result;
    }
    

    /**
     * When set to true (the default), use a single shared date-picker across all widgets that use one.  When false, create a
     * new picker using the autoChild system.  See  {@link com.smartgwt.client.widgets.form.fields.DateItem#getPickerDefaults
     * picker} and  {@link com.smartgwt.client.widgets.form.fields.DateItem#getPickerProperties pickerProperties} for details
     * on setting up an unshared picker.
     *
     * @param useSharedPicker New useSharedPicker value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setUseSharedPicker(Boolean useSharedPicker) {
        return (RelativeDateItem)setAttribute("useSharedPicker", useSharedPicker);
    }

    /**
     * When set to true (the default), use a single shared date-picker across all widgets that use one.  When false, create a
     * new picker using the autoChild system.  See  {@link com.smartgwt.client.widgets.form.fields.DateItem#getPickerDefaults
     * picker} and  {@link com.smartgwt.client.widgets.form.fields.DateItem#getPickerProperties pickerProperties} for details
     * on setting up an unshared picker.
     *
     * @return Current useSharedPicker value. Default value is true
     */
    public Boolean getUseSharedPicker()  {
        Boolean result = getAttributeAsBoolean("useSharedPicker", true);
        return result == null ? true : result;
    }
    
    

    /**
     * The {@link com.smartgwt.client.widgets.form.fields.FormItem#getWidth width} for the {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getValueField valueField} in this item.  Defaults to the
     * current default value for the width attribute on the  {@link com.smartgwt.client.widgets.form.fields.DateTimeItem} class
     * - this is assumed to be just wide enough to show a full  datetime string, in the current global datetime format. <P>
     * Setting the width globally on the {@link com.smartgwt.client.widgets.form.fields.DateTimeItem DateTimeItem} class
     * results in all text-based datetime entry fields assuming the same default width - this caters for custom date-time
     * formatters that need differing amounts of space.
     *
     * @param valueFieldWidth New valueFieldWidth value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setValueFieldWidth(int valueFieldWidth) {
        return (RelativeDateItem)setAttribute("valueFieldWidth", valueFieldWidth);
    }

    /**
     * The {@link com.smartgwt.client.widgets.form.fields.FormItem#getWidth width} for the {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getValueField valueField} in this item.  Defaults to the
     * current default value for the width attribute on the  {@link com.smartgwt.client.widgets.form.fields.DateTimeItem} class
     * - this is assumed to be just wide enough to show a full  datetime string, in the current global datetime format. <P>
     * Setting the width globally on the {@link com.smartgwt.client.widgets.form.fields.DateTimeItem DateTimeItem} class
     * results in all text-based datetime entry fields assuming the same default width - this caters for custom date-time
     * formatters that need differing amounts of space.
     *
     * <p><b>Note :</b> This method will return -1 if the underlying SmartClient JavaScript
     * attribute value cannot be expressed as a(n) int.  In that case, other
     * getters,  similarly-named but ending in <code>AsString</code>, <code>AsCanvas</code>,
     * etc., may be provided.
     *
     * @return Current valueFieldWidth value. Default value is null
     */
    public int getValueFieldWidth()  {
        if (!(getAttributeAsObject("valueFieldWidth") instanceof Integer)) { return -1; }
        return getAttributeAsInt("valueFieldWidth");
    }

    /**
     * The {@link com.smartgwt.client.widgets.form.fields.FormItem#getWidth width} for the {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getValueField valueField} in this item.  Defaults to the
     * current default value for the width attribute on the  {@link com.smartgwt.client.widgets.form.fields.DateTimeItem} class
     * - this is assumed to be just wide enough to show a full  datetime string, in the current global datetime format. <P>
     * Setting the width globally on the {@link com.smartgwt.client.widgets.form.fields.DateTimeItem DateTimeItem} class
     * results in all text-based datetime entry fields assuming the same default width - this caters for custom date-time
     * formatters that need differing amounts of space.
     *
     * @param valueFieldWidth New valueFieldWidth value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setValueFieldWidth(String valueFieldWidth) {
        return (RelativeDateItem)setAttribute("valueFieldWidth", valueFieldWidth);
    }

    /**
     * The {@link com.smartgwt.client.widgets.form.fields.FormItem#getWidth width} for the {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getValueField valueField} in this item.  Defaults to the
     * current default value for the width attribute on the  {@link com.smartgwt.client.widgets.form.fields.DateTimeItem} class
     * - this is assumed to be just wide enough to show a full  datetime string, in the current global datetime format. <P>
     * Setting the width globally on the {@link com.smartgwt.client.widgets.form.fields.DateTimeItem DateTimeItem} class
     * results in all text-based datetime entry fields assuming the same default width - this caters for custom date-time
     * formatters that need differing amounts of space.
     *
     * @return Current valueFieldWidth value. Default value is null
     */
    public String getValueFieldWidthAsString()  {
        return getAttributeAsString("valueFieldWidth");
    }
    

    /**
     * The title to show for historical periods when the {@link com.smartgwt.client.types.TimeUnit} is "week".
     *
     * @param weeksAgoTitle New weeksAgoTitle value. Default value is "N weeks ago"
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setWeeksAgoTitle(String weeksAgoTitle) {
        return (RelativeDateItem)setAttribute("weeksAgoTitle", weeksAgoTitle);
    }

    /**
     * The title to show for historical periods when the {@link com.smartgwt.client.types.TimeUnit} is "week".
     *
     * @return Current weeksAgoTitle value. Default value is "N weeks ago"
     */
    public String getWeeksAgoTitle()  {
        return getAttributeAsString("weeksAgoTitle");
    }
    

    /**
     * The title to show for future periods when the {@link com.smartgwt.client.types.TimeUnit} is "week".
     *
     * @param weeksFromNowTitle New weeksFromNowTitle value. Default value is "N weeks from now"
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setWeeksFromNowTitle(String weeksFromNowTitle) {
        return (RelativeDateItem)setAttribute("weeksFromNowTitle", weeksFromNowTitle);
    }

    /**
     * The title to show for future periods when the {@link com.smartgwt.client.types.TimeUnit} is "week".
     *
     * @return Current weeksFromNowTitle value. Default value is "N weeks from now"
     */
    public String getWeeksFromNowTitle()  {
        return getAttributeAsString("weeksFromNowTitle");
    }
    

    /**
     * The title to show for historical periods when the {@link com.smartgwt.client.types.TimeUnit} is "year".
     *
     * @param yearsAgoTitle New yearsAgoTitle value. Default value is "N years ago"
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setYearsAgoTitle(String yearsAgoTitle) {
        return (RelativeDateItem)setAttribute("yearsAgoTitle", yearsAgoTitle);
    }

    /**
     * The title to show for historical periods when the {@link com.smartgwt.client.types.TimeUnit} is "year".
     *
     * @return Current yearsAgoTitle value. Default value is "N years ago"
     */
    public String getYearsAgoTitle()  {
        return getAttributeAsString("yearsAgoTitle");
    }
    

    /**
     * The title to show for future periods when the {@link com.smartgwt.client.types.TimeUnit} is "year".
     *
     * @param yearsFromNowTitle New yearsFromNowTitle value. Default value is "N years from now"
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem} instance, for chaining setter calls
     */
    public RelativeDateItem setYearsFromNowTitle(String yearsFromNowTitle) {
        return (RelativeDateItem)setAttribute("yearsFromNowTitle", yearsFromNowTitle);
    }

    /**
     * The title to show for future periods when the {@link com.smartgwt.client.types.TimeUnit} is "year".
     *
     * @return Current yearsFromNowTitle value. Default value is "N years from now"
     */
    public String getYearsFromNowTitle()  {
        return getAttributeAsString("yearsFromNowTitle");
    }
    

    // ********************* Methods ***********************
	/**
     * RelativeDateItems do not make use of the standard {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#formatEditorValue FormItem.formatEditorValue()} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#parseEditorValue FormItem.parseEditorValue()} methods. Developers can
     * customize the display values for these items in the following ways:<ul> <li>The {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getPresetOptions presetOptions} map allows standard preset
     * RelativeDateString      and RelativeDateShortcut values to be mapped to custom display values</li> <li>The text
     * displayed for each of the {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem#getTimeUnitOptions
     * timeUnitOptions} (e.g:"N days ago") may be     customized via the per-time unit title attributes ({@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getDaysFromNowTitle daysFromNowTitle},      {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getDaysAgoTitle daysAgoTitle}, etc)</li> <li>The {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getDateFormatter dateFormatter} and {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getInputFormat inputFormat} may be used modify how date values 
     * are displayed (both in the text entry box and in the    {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getShowCalculatedDateField calculatedDateField}</li> </ul>
     */
    public native void formatEditorValue() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.formatEditorValue();
    }-*/;

	/**
     * Returns the raw text value typed into this items value text field
     */
    public native void getEnteredValue() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.getEnteredValue();
    }-*/;

	/**
     * Returns the {@link com.smartgwt.client.widgets.FiscalCalendar} object that will be used by this item's DateChooser.
     *
     * @return the fiscal calendar for this chooser, if set, or the global            one otherwise
     */
    public native FiscalCalendar getFiscalCalendar() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.getFiscalCalendar();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.FiscalCalendar::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * RelativeDateItems do not make use of the standard {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#formatEditorValue FormItem.formatEditorValue()} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#parseEditorValue FormItem.parseEditorValue()} methods. Developers can
     * customize the display values for these items in the following ways:<ul> <li>The {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getPresetOptions presetOptions} map allows standard preset
     * RelativeDateString      and RelativeDateShortcut values to be mapped to custom display values</li> <li>The text
     * displayed for each of the {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem#getTimeUnitOptions
     * timeUnitOptions} (e.g:"N days ago") may be     customized via the per-time unit title attributes ({@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getDaysFromNowTitle daysFromNowTitle},      {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getDaysAgoTitle daysAgoTitle}, etc)</li> <li>The {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getDateFormatter dateFormatter} and {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getInputFormat inputFormat} may be used modify how date values 
     * are displayed (both in the text entry box and in the    {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getShowCalculatedDateField calculatedDateField}</li> </ul>
     */
    public native void parseEditorValue() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.parseEditorValue();
    }-*/;

	/**
     * Sets the {@link com.smartgwt.client.widgets.FiscalCalendar} object that will be used by this item's DateChooser.  If 
     * unset, the {@link com.smartgwt.client.util.DateUtil#getFiscalCalendar global fiscal calendar} is used.
     */
    public native void setFiscalCalendar() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.setFiscalCalendar();
    }-*/;

	/**
     * Sets the {@link com.smartgwt.client.widgets.FiscalCalendar} object that will be used by this item's DateChooser.  If 
     * unset, the {@link com.smartgwt.client.util.DateUtil#getFiscalCalendar global fiscal calendar} is used.
     * @param fiscalCalendar the fiscal calendar for this chooser, if set, or the global            one otherwise
     */
    public native void setFiscalCalendar(FiscalCalendar fiscalCalendar) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.setFiscalCalendar(fiscalCalendar == null ? null : fiscalCalendar.@com.smartgwt.client.core.DataClass::getJsObj()());
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
     * @param relativeDateItemProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(RelativeDateItem relativeDateItemProperties) /*-{
        if (relativeDateItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(RelativeDateItem.@java.lang.Object::getClass()(), "setDefaultProperties", relativeDateItemProperties.@java.lang.Object::getClass()());
        }
        relativeDateItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var properties = relativeDateItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::getConfig()();
        $wnd.isc.RelativeDateItem.addProperties(properties);
    }-*/;

    // ***********************************************************


    /**
     * Returns the RelativeDate for the current value.
     *
     * @return the RelativeDate for the current value or null if not set
     */
    public native RelativeDate getRelativeDate() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var retVal = self.getRelativeDate();
        if(retVal == null) {
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
        var retVal = $wnd.isc.RelativeDateItem.getAbsoluteDate(relativeDate.@com.smartgwt.client.data.RelativeDate::getJsObj()());
        if(retVal == null) {
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
        var retVal =$wnd.isc.RelativeDateItem.getAbsoluteDate(relativeDate.@com.smartgwt.client.data.RelativeDate::getJsObj()(),
                                                              @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(baseDate));
        if(retVal == null) {
            return null;
        } else {
                return @com.smartgwt.client.util.JSOHelper::toDate(D)(retVal.getTime());
        }
    }-*/;
    
    /**
     * Set up a set of standard relative dates such as "today" or "tomorrow" that the user can choose directly from
     * the valueField of this item.
     * <P>
     * This is similar to a standard {@link FormItem::setValueMap(), valueMap} - the parameter passed in should be
     * a HashMap mapping RelativeDate strings to display values.
     * 
     * The default set of preset options (expressed in JSON) are:
     * <pre>
     * {
     *  "$today" : "Today",
     *  "$yesterday" : "Yesterday",
     *  "$tomorrow" : "Tomorrow",
     *  "-1w" : "Current day of last week",
     *  "+1w" : "Current day of next week",
     *  "-1m" : "Current day of last month",
     *  "+1m" : "Current day of next month"
     *  }
     *  </pre>
     *  In addition to these presets, options are shown for each of the {@link #setTimeUnitOptions,time unit options}.
     *
     * @param 
     */
    public void setPresetOptions(java.util.LinkedHashMap valueMap) {
        setAttribute("presetOptions", valueMap);
        
    }
    
    /**
     * A map from a granularity of time specified by a user to the granularity of time used for 
     * rounding.
     * <P>
     * A relative date such as "n days from now" is normally shifted to the end of the day when 
     * used as a range endpoint, and the beginning of the day when used as the beginning of a range.
     * (The rounding direction on some item can be specified via 
     * +link{relativeDateItem.rangePosition}).
     * This causes the intuitive behavior that "from yesterday to today" is from the beginning of
     * yesterday to the end of today, and that "from today until 5 days from now" includes the 
     * entirety of Friday if today is Monday.
     * <P>
     * This same rule <i>can</i> be applied to any time granularity, such that "from now until 
     * 20 minutes from now" is up to 5:32 if it is now 5:11:34, and 
     * "from now until 2 months from now" means end of June if it is mid-April.
     * <P>
     * User intuitions about where this rounding is expected for any given time period tend to
     * vary based on what kind of event is being discussed and subtle phrasing differences 
     * (consider "up to one year from now", "until next year", "within the next couple of years"). 
     * The defaults behaviors are:
     * <ul>
     * <li> for days, weeks and months round to <b>day</b> end/beginning
     * <li> for hours, round to <b>minute</b> end/beginning
     * <li> for minutes and seconds, round to <b>second</b> end/beginning
     * </ul>
     * To customize this rounding behavior, this attribute may be set to a Map
     * mapping each timeUnit to the granularity for that timeUnit.<br>
     * For example the following config code would produce an item where the user could select
     * only day or week values, and the selected value would be rounded to the beginning of the day
     * if a day was selected, or the beginning of the week if a week was selected:
     * <pre>
     *  RelativeDateItem fromDate = new RelativeDateItem("from");
     *  fromDate.setRangePosition(RelativeDateRangePosition.START);
     *  fromDate.setTimeUnitOptions(TimeUnit.DAY, TimeUnit.WEEK);
     *    
     *  Map<TimeUnit,TimeUnit> roundingMap = new HashMap<TimeUnit,TimeUnit>();
     *  roundingMap.put(TimeUnit.DAY, TimeUnit.DAY);
     *  roundingMap.put(TimeUnit.WEEK, TimeUnit.WEEK);
     *  fromDate.setRangeRoundingGranularity(roundingMap);
     * </pre>
     * 
     * @param rangeRoundingGranularity
     */
     
    public void setRangeRoundingGranularity(java.util.Map rangeRoundingGranularity) {
        JavaScriptObject jsMap = com.smartgwt.client.util.JSOHelper.createObject();
        java.util.Iterator i = rangeRoundingGranularity.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry e = (Map.Entry) i.next();
            TimeUnit key = (TimeUnit) e.getKey();
            TimeUnit val = (TimeUnit) e.getValue();
            
            JSOHelper.setAttribute(jsMap,key.getValue(), val.getValue());
        }
        setAttribute("rangeRoundingGranularity", jsMap);
    }
    /**
     * Format for displaying dates in the {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem#getValueField
     * valueField} and {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem#getCalculatedDateField
     * calculatedDateField}.   Defaults to the system-wide default established by  Date.setShortDisplayFormat, or if this item
     * has its type specified as datetime,  Date.setShortDatetimeDisplayFormat.
     *
     * @param dateFormatter dateFormatter Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem}
     * instance, for chaining setter calls
     */
    public RelativeDateItem setDateFormatter(DateDisplayFormat dateFormatter) {
        return (RelativeDateItem)setAttribute("dateFormatter", dateFormatter.getValue());
    }
    
    
    /**
     * Formatter function for displaying dates in the 
     * {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem#getValueField
     * valueField} and {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem#getCalculatedDateField
     * calculatedDateField} in some custom format. Typically the {@link #setDateParser(DateParser)} method should
     * also be applied to ensure dates can be both formatted and edited date strings parsed back into actual
     * date values.
     * @param dateFormatter dateFormatter Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem RelativeDateItem}
     * instance, for chaining setter calls
     */
    public native RelativeDateItem setDateFormatter(DateDisplayFormatter formatter) /*-{
        var formatterFunc = function() {
            var date = this;
            var dateJ = date == null || date === undefined ? null : @com.smartgwt.client.util.JSOHelper::toDate(D)(date.getTime());
            return formatter.@com.smartgwt.client.util.DateDisplayFormatter::format(Ljava/util/Date;)(dateJ); 
        }
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.dateFormatter = formatterFunc;
        return this;
    }-*/;
    
    /**
     * Custom date parser function for direct user input of date values. Typically used in conjunction with 
     * {@link #setDateFormatter(DateDisplayFormatter)}.
     * <P> 
     * Note that {@link #setDateFormatter(DateDisplayFormat)} and 
     * {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem#setInputFormat(String)} already
     * provide a mechanism for customizing the display format for date values displayed in this item.
     *
     */
    public native void setDateParser(DateParser parser) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.inputFormat = function(dateStr) {
                var dateJ = parser.@com.smartgwt.client.util.DateParser::parse(Ljava/lang/String;)(dateStr);
                if(dateJ == null) return null;
                return @com.smartgwt.client.util.JSOHelper::toDateJS(Ljava/util/Date;)(dateJ);
        }
    }-*/;

    /**
     *  RelativeDateItems do not make use of the standard FormItem.setEditorValueFormatter() and
     *   FormItem.setEditorValueParser() methods. Developers can customize the display values for these items in
     *   the following ways:
     *   <UL>
     *   <LI>The RelativeDateItem.presetOptions map allows standard preset RelativeDateString 
     *      and RelativeDateShortcut values to be mapped to custom display values</LI>
     *   <LI>The text displayed for each of the RelativeDateItem.timeUnitOptions (e.g:"N days ago") 
     *       may be customized via the per-time unit title attributes (RelativeDateItem.daysFromNowTitle,
     *       RelativeDateItem.daysAgoTitle, etc)</LI>
     *   <LI>setDateFormatter and setInputFormat / setDateParser may be used modify how date values 
     *        are displayed (both in the text entry box and in the calculatedDateField)</LI>
     *   </UL>
     */
    public void setEditorValueParser(FormItemValueParser parser) {
        SC.logWarn("setEditorValueParser not supported for RelativeDateItems, please use setDateFormatter and setDateParser instead.");
    }
    
    /**
     *  RelativeDateItems do not make use of the standard FormItem.setEditorValueFormatter() and
     *   FormItem.setEditorValueParser() methods. Developers can customize the display values for these items in
     *   the following ways:
     *   <UL>
     *   <LI>The RelativeDateItem.presetOptions map allows standard preset RelativeDateString 
     *      and RelativeDateShortcut values to be mapped to custom display values</LI>
     *   <LI>The text displayed for each of the RelativeDateItem.timeUnitOptions (e.g:"N days ago") 
     *       may be customized via the per-time unit title attributes (RelativeDateItem.daysFromNowTitle,
     *       RelativeDateItem.daysAgoTitle, etc)</LI>
     *   <LI>setDateFormatter and setInputFormat / setDateParser may be used modify how date values 
     *        are displayed (both in the text entry box and in the calculatedDateField)</LI>
     *   </UL>
     */
    public void setEditorValueFormatter(FormItemValueFormatter formatter) {
        SC.logWarn("setEditorValueFormatter not supported for RelativeDateItems, please use setDateFormatter and setDateParser instead.");
    }

    /**
     * {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem} field where a user may choose among  {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getPresetOptions presets},  {@link
     * com.smartgwt.client.types.TimeUnit time unit} plus {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem#getQuantityField quantity}, or  direct entry of a date as text.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return ComboBoxItem
     */
    public ComboBoxItem getValueFieldComboBox()  {
        return ComboBoxItem.getOrCreateRef(getAttributeAsJavaScriptObject("valueField"));
    }

}
