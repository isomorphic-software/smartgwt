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
 * Item for manipulating Dates. <p> Can be rendered as a text field, or as 3 selects for day, month, year.  Includes
 * optional pop-up picker.
 */
@BeanFactory.FrameworkClass
public class DateItem extends FormItem {

    public static DateItem getOrCreateRef(JavaScriptObject jsObj) {

        if(jsObj == null) return null;

        RefDataClass obj = RefDataClass.getRef(jsObj);

		if(obj != null && JSOHelper.getAttribute(jsObj,"__ref")==null) {
            return com.smartgwt.client.util.ObjectFactory.createFormItem("DateItem",jsObj);

        } else
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (DateItem) obj;
        } else {
            return new DateItem(jsObj);
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
        $wnd.isc.DateItem.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
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
        $wnd.isc.DateItem.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;

    public static native void changePickerIconDefaults(FormItemIcon defaults) /*-{
        $wnd.isc.DateItem.changeDefaults("pickerIconDefaults", defaults.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public DateItem(){
        setType("date");
					setAttribute("editorType", "DateItem");
    }

    public DateItem(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    public DateItem(String name) {
        setName(name);
                setType("date");
					setAttribute("editorType", "DateItem");
    }


    public DateItem(String name, String title) {
        setName(name);
		setTitle(title);
                setType("date");
					setAttribute("editorType", "DateItem");
    }


    // ********************* Properties / Attributes ***********************

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is true and browserInputType is
     * set to "date", then a native <a href='http://www.w3.org/TR/html5/forms.html#date-state-(type=date)'
     * onclick="window.open('http://www.w3.org/TR/html5/forms.html#date-state-(type=date)');return false;">HTML5 date input</a>
     * is used in place of a text input. <p> The use of a native HTML5 date input causes certain features to be disabled. Input
     * masks, the picker icon, and a custom {@link com.smartgwt.client.widgets.form.fields.DateItem#getDateFormatter
     * dateFormatter} are not supported. {@link com.smartgwt.client.widgets.form.fields.DateItem#getShowHintInField In-field
     * hints} are currently supported, but future browser changes might force this support to be removed. Therefore, it is
     * safest to <em>not</em> use in-field hints (set showHintInField to false) in conjunction with a native HTML5 date input.
     * <p> <b>NOTE:</b> This feature requires specific CSS changes. Currently these changes have been made to the Enterprise,
     * EnterpriseBlue, and Graphite skins only.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param browserInputType  Default value is null
     */
    public void setBrowserInputType(String browserInputType) {
        setAttribute("browserInputType", browserInputType);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is true and browserInputType is
     * set to "date", then a native <a href='http://www.w3.org/TR/html5/forms.html#date-state-(type=date)'
     * onclick="window.open('http://www.w3.org/TR/html5/forms.html#date-state-(type=date)');return false;">HTML5 date input</a>
     * is used in place of a text input. <p> The use of a native HTML5 date input causes certain features to be disabled. Input
     * masks, the picker icon, and a custom {@link com.smartgwt.client.widgets.form.fields.DateItem#getDateFormatter
     * dateFormatter} are not supported. {@link com.smartgwt.client.widgets.form.fields.DateItem#getShowHintInField In-field
     * hints} are currently supported, but future browser changes might force this support to be removed. Therefore, it is
     * safest to <em>not</em> use in-field hints (set showHintInField to false) in conjunction with a native HTML5 date input.
     * <p> <b>NOTE:</b> This feature requires specific CSS changes. Currently these changes have been made to the Enterprise,
     * EnterpriseBlue, and Graphite skins only.
     *
     * @return String
     */
    public String getBrowserInputType()  {
        return getAttributeAsString("browserInputType");
    }

    /**
     * Only used if we're showing the date in a text field. When parsing a date, if the year is specified with 1 or 2 digits
     * and is less than the centuryThreshold, then the year will be assumed to be 20xx; otherwise it will be interpreted
     * according to default browser behaviour, which will consider it to be 19xx. <P> If you need to allow 1 and 2 digit years,
     * set this attribute to  <code>null</code> to have the control retain your year-value as entered.
     *
     * @param centuryThreshold  Default value is 25
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setCenturyThreshold(int centuryThreshold) {
        setAttribute("centuryThreshold", centuryThreshold);
    }

    /**
     * Only used if we're showing the date in a text field. When parsing a date, if the year is specified with 1 or 2 digits
     * and is less than the centuryThreshold, then the year will be assumed to be 20xx; otherwise it will be interpreted
     * according to default browser behaviour, which will consider it to be 19xx. <P> If you need to allow 1 and 2 digit years,
     * set this attribute to  <code>null</code> to have the control retain your year-value as entered.
     *
     * @return int
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getCenturyThreshold()  {
        return getAttributeAsInt("centuryThreshold");
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is <code>true</code> this
     * property can be used to  customize the format in which dates are displayed for this item.<br> Should be set to a
     * standard {@link com.smartgwt.client.types.DateDisplayFormat}. <P> As with any formItem rendering out a date value, if no
     * explicit dateFormatter is supplied, dateFormatter will be derived from {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getDateFormatter dateFormatter} or {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getDatetimeFormatter datetimeFormatter},  depending on the specified {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getType type} for this field, if set, otherwise from the standard
     * default {@link com.smartgwt.client.util.Date#setShortDisplayFormat Date.setShortDisplayFormat} or {@link
     * com.smartgwt.client.util.Date#setShortDatetimeDisplayFormat Date.setShortDatetimeDisplayFormat}. <P> NOTE: For entirely
     * custom formats, developers may apply a custom   <code>editorValueFormatter</code>. To ensure the DateItem is able to
     * parse user-entered date strings back into Dates, for most cases developers can specify an explicit {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat inputFormat}, or if necessary a custom
     * <code>editorValueParser</code>  <p> This attribute does not have an effect if a native HTML5 date or datetime input is
     * being used. See {@link com.smartgwt.client.widgets.form.fields.DateItem#getBrowserInputType browserInputType}.
     *
     * @param dateFormatter  Default value is null
     */
    public void setDateFormatter(DateDisplayFormat dateFormatter) {
        setAttribute("dateFormatter", dateFormatter == null ? null : dateFormatter.getValue());
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is <code>true</code> this
     * property can be used to  customize the format in which dates are displayed for this item.<br> Should be set to a
     * standard {@link com.smartgwt.client.types.DateDisplayFormat}. <P> As with any formItem rendering out a date value, if no
     * explicit dateFormatter is supplied, dateFormatter will be derived from {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getDateFormatter dateFormatter} or {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getDatetimeFormatter datetimeFormatter},  depending on the specified {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getType type} for this field, if set, otherwise from the standard
     * default {@link com.smartgwt.client.util.Date#setShortDisplayFormat Date.setShortDisplayFormat} or {@link
     * com.smartgwt.client.util.Date#setShortDatetimeDisplayFormat Date.setShortDatetimeDisplayFormat}. <P> NOTE: For entirely
     * custom formats, developers may apply a custom   <code>editorValueFormatter</code>. To ensure the DateItem is able to
     * parse user-entered date strings back into Dates, for most cases developers can specify an explicit {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat inputFormat}, or if necessary a custom
     * <code>editorValueParser</code>  <p> This attribute does not have an effect if a native HTML5 date or datetime input is
     * being used. See {@link com.smartgwt.client.widgets.form.fields.DateItem#getBrowserInputType browserInputType}.
     *
     * @return DateDisplayFormat
     */
    public DateDisplayFormat getDateFormatter()  {
        return EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("dateFormatter"));
    }

    /**
     * Select item to hold the day part of the date.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return SelectItem
     */
    public SelectItem getDaySelector()  {
        return SelectItem.getOrCreateRef(getAttributeAsJavaScriptObject("daySelector"));
    }

    /**
     * Custom properties to apply to this dateItem's generated {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getDaySelector daySelector}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param daySelectorProperties  Default value is null
     */
    public void setDaySelectorProperties(SelectItem daySelectorProperties) {
        setAttribute("daySelectorProperties", daySelectorProperties.getJsObj());
    }

    /**
     * Custom properties to apply to this dateItem's generated {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getDaySelector daySelector}.
     *
     * @return SelectItem
     */
    public SelectItem getDaySelectorProperties()  {
        return SelectItem.getOrCreateRef(getAttributeAsJavaScriptObject("daySelectorProperties"));
    }

    /**
     * Default date to show in the date chooser. If this items value is currently unset, this property may be specified to set
     * a default date to highlight in the dateChooser  for this item. If unset, the date chooser will highlight the current
     * date by default. Note that this has no effect if the item as a whole currently has a value - in that case the date
     * chooser will always highlight the current value for the item.
     *
     * @param defaultChooserDate  Default value is null
     */
    public void setDefaultChooserDate(Date defaultChooserDate) {
        setAttribute("defaultChooserDate", defaultChooserDate);
    }

    /**
     * Default date to show in the date chooser. If this items value is currently unset, this property may be specified to set
     * a default date to highlight in the dateChooser  for this item. If unset, the date chooser will highlight the current
     * date by default. Note that this has no effect if the item as a whole currently has a value - in that case the date
     * chooser will always highlight the current value for the item.
     *
     * @return Returns the default date to display in the date chooser if this form items value is currently unset. <P> Default
     * implementation returns {@link com.smartgwt.client.widgets.form.fields.DateItem#getDefaultChooserDate defaultChooserDate}
     */
    public Date getDefaultChooserDate()  {
        return getAttributeAsDate("defaultChooserDate");
    }

    /**
     * Maximum date the selectors will allow the user to pick. <P> See {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getStartDate startDate} for details on how this restriction works.
     *
     * <p>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.form.fields.DateItem#getEndDate endDate}.
     *
     * @param endDate the new endDate.. Default value is 12/31/2015
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setEndDate(Date endDate) {
        setAttribute("endDate", endDate);
    }

    /**
     * Maximum date the selectors will allow the user to pick. <P> See {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getStartDate startDate} for details on how this restriction works.
     *
     * @return Date
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Date getEndDate()  {
        return getAttributeAsDate("endDate");
    }

    /**
     * Can this field be set to a non-date value [other than null]?
     *  <P>
     * When set to true, {@link com.smartgwt.client.widgets.form.fields.FormItem#setValue FormItem.setValue} will return false
     * without setting the item value
     *  and log a warning if passed something other than a valid date value.
     * If the dateItem is showing a {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField free-form text
     * entry field},
     *  and a user enters a text value which cannot be parsed into a valid date, the item will
     * automatically redraw and display the {@link com.smartgwt.client.widgets.form.fields.DateItem#getInvalidDateStringMessage
     * invalidDateStringMessage} (though at this
     * point calling {@link com.smartgwt.client.widgets.form.fields.FormItem#getValue FormItem.getValue} will return the string
     * entered by the user).
     *  <P>
     *  When set to false, a user may enter a value that is not a valid date (for example, "Not
     *  applicable") and the value will not immediately be flagged as an error.  However note
     *  that for the value to actually pass validation you would need to declare the field as
     *  not of "date" type, for example:
     *  <pre>
     *      {name:"startDate", type:"dateOrOther", editorType:"DateItem", useTextField:true },
     *  </pre>
     *  The type "dateOrOther" could be declared as a {@link com.smartgwt.client.data.SimpleType}, with validators that
     *  will accept either a valid date or certain special Strings (like "Not Available").
     *  <P>
     * Only applies to dateItems where {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is
     * true. Non-Date values
     *  are never supported in items where useTextField is false.
     *  <p>
     *  This attribute does not have an effect if a native HTML5 date input is being used.
     *  See {@link com.smartgwt.client.widgets.form.fields.DateItem#getBrowserInputType browserInputType}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param enforceDate  Default value is false
     */
    public void setEnforceDate(Boolean enforceDate) {
        setAttribute("enforceDate", enforceDate);
    }

    /**
     * Can this field be set to a non-date value [other than null]?
     *  <P>
     * When set to true, {@link com.smartgwt.client.widgets.form.fields.FormItem#setValue FormItem.setValue} will return false
     * without setting the item value
     *  and log a warning if passed something other than a valid date value.
     * If the dateItem is showing a {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField free-form text
     * entry field},
     *  and a user enters a text value which cannot be parsed into a valid date, the item will
     * automatically redraw and display the {@link com.smartgwt.client.widgets.form.fields.DateItem#getInvalidDateStringMessage
     * invalidDateStringMessage} (though at this
     * point calling {@link com.smartgwt.client.widgets.form.fields.FormItem#getValue FormItem.getValue} will return the string
     * entered by the user).
     *  <P>
     *  When set to false, a user may enter a value that is not a valid date (for example, "Not
     *  applicable") and the value will not immediately be flagged as an error.  However note
     *  that for the value to actually pass validation you would need to declare the field as
     *  not of "date" type, for example:
     *  <pre>
     *      {name:"startDate", type:"dateOrOther", editorType:"DateItem", useTextField:true },
     *  </pre>
     *  The type "dateOrOther" could be declared as a {@link com.smartgwt.client.data.SimpleType}, with validators that
     *  will accept either a valid date or certain special Strings (like "Not Available").
     *  <P>
     * Only applies to dateItems where {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is
     * true. Non-Date values
     *  are never supported in items where useTextField is false.
     *  <p>
     *  This attribute does not have an effect if a native HTML5 date input is being used.
     *  See {@link com.smartgwt.client.widgets.form.fields.DateItem#getBrowserInputType browserInputType}.
     *
     * @return Boolean
     */
    public Boolean getEnforceDate()  {
        return getAttributeAsBoolean("enforceDate");
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is <code>true</code> this
     * property can be used to specify the input format for date strings.  If unset, the input format will be determined based
     * on the specified {@link com.smartgwt.client.widgets.form.fields.DateItem#getDateFormatter dateFormatter} if possible
     * (see {@link com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat DateItem.getInputFormat}), otherwise picked
     * up from the Date class (see {@link com.smartgwt.client.util.Date#setInputFormat Date.setInputFormat}). <P> Should be set
     * to a standard {@link com.smartgwt.client.docs.DateInputFormat} <P> Note that the {@link
     * com.smartgwt.client.docs.DateInputFormat} property is sufficient to parse date or datetime strings specified in most
     * standard date formats. However should an entirely custom parsing function be required developers can   apply a custom
     * <code>editorValueParser</code> function. <p> This attribute does not have an effect if a native HTML5 date input is
     * being used. See {@link com.smartgwt.client.widgets.form.fields.DateItem#getBrowserInputType browserInputType}.
     *
     * @param inputFormat  See {@link com.smartgwt.client.docs.DateInputFormat DateInputFormat} . Default value is null
     * @see com.smartgwt.client.widgets.form.fields.DateItem#setDisplayFormat
     */
    public void setInputFormat(String inputFormat) {
        setAttribute("inputFormat", inputFormat);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is <code>true</code> this
     * property can be used to specify the input format for date strings.  If unset, the input format will be determined based
     * on the specified {@link com.smartgwt.client.widgets.form.fields.DateItem#getDateFormatter dateFormatter} if possible
     * (see {@link com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat DateItem.getInputFormat}), otherwise picked
     * up from the Date class (see {@link com.smartgwt.client.util.Date#setInputFormat Date.setInputFormat}). <P> Should be set
     * to a standard {@link com.smartgwt.client.docs.DateInputFormat} <P> Note that the {@link
     * com.smartgwt.client.docs.DateInputFormat} property is sufficient to parse date or datetime strings specified in most
     * standard date formats. However should an entirely custom parsing function be required developers can   apply a custom
     * <code>editorValueParser</code> function. <p> This attribute does not have an effect if a native HTML5 date input is
     * being used. See {@link com.smartgwt.client.widgets.form.fields.DateItem#getBrowserInputType browserInputType}.
     *
     * @return If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is <code>true</code> this
     * method returns a standard {@link com.smartgwt.client.docs.DateInputFormat}, determining how values entered by the user
     * are to be converted to Javascript Date objects. <P> If an explicit {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat inputFormat} has been specified it will be returned,
     * otherwise, the input format will be automatically derived from the {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getDateFormatter dateFormatter} property. <P> Note that the inputFormat
     * will ignore any separator characters and padding of values. However if necessary entirely custom date formatting and
     * parsing may be achieved via the  <code>setEditorValueFormatter()</code> and  <code>setEditorValueParser()</code> APIs. See {@link com.smartgwt.client.docs.DateInputFormat DateInputFormat} 
     * @see com.smartgwt.client.widgets.form.fields.DateItem#getDisplayFormat
     */
    public String getInputFormat()  {
        return getAttributeAsString("inputFormat");
    }

    /**
     * Validation error message to display if the user enters an invalid date
     *
     * @param invalidDateStringMessage  Default value is "Invalid date"
     */
    public void setInvalidDateStringMessage(String invalidDateStringMessage) {
        setAttribute("invalidDateStringMessage", invalidDateStringMessage);
    }

    /**
     * Validation error message to display if the user enters an invalid date
     *
     * @return String
     */
    public String getInvalidDateStringMessage()  {
        return getAttributeAsString("invalidDateStringMessage");
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} and {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getUseMask useMask} are both <code>true</code> this value is the
     * separator between date components. If unset {@link com.smartgwt.client.util.Date#getDefaultDateSeparator
     * Date.getDefaultDateSeparator} will be used.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param maskDateSeparator  Default value is null
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public void setMaskDateSeparator(String maskDateSeparator) {
        setAttribute("maskDateSeparator", maskDateSeparator);
    }

    /**
     * Select item to hold the month part of the date.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return SelectItem
     */
    public SelectItem getMonthSelector()  {
        return SelectItem.getOrCreateRef(getAttributeAsJavaScriptObject("monthSelector"));
    }

    /**
     * Custom properties to apply to this dateItem's generated {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getMonthSelector monthSelector}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param monthSelectorProperties  Default value is null
     */
    public void setMonthSelectorProperties(SelectItem monthSelectorProperties) {
        setAttribute("monthSelectorProperties", monthSelectorProperties.getJsObj());
    }

    /**
     * Custom properties to apply to this dateItem's generated {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getMonthSelector monthSelector}.
     *
     * @return SelectItem
     */
    public SelectItem getMonthSelectorProperties()  {
        return SelectItem.getOrCreateRef(getAttributeAsJavaScriptObject("monthSelectorProperties"));
    }

    /**
     * Prompt to show when the user hovers the mouse over the picker icon for this DateItem. May be overridden for localization
     * of your application.
     *
     * @param pickerIconPrompt  Default value is "Show Date Chooser"
     */
    public void setPickerIconPrompt(String pickerIconPrompt) {
        setAttribute("pickerIconPrompt", pickerIconPrompt);
    }

    /**
     * Prompt to show when the user hovers the mouse over the picker icon for this DateItem. May be overridden for localization
     * of your application.
     *
     * @return String
     */
    public String getPickerIconPrompt()  {
        return getAttributeAsString("pickerIconPrompt");
    }

    /**
     * Properties for the {@link com.smartgwt.client.widgets.DateChooser} created by this form item.
     *
     * @param pickerProperties  Default value is see below
     */
    public void setPickerProperties(DateChooser pickerProperties) {
        JavaScriptObject config = pickerProperties == null ? null : pickerProperties.getConfig();
        setAttribute("pickerProperties", JSOHelper.cleanProperties(config, true));
    }

    /**
     * Properties for the {@link com.smartgwt.client.widgets.DateChooser} created by this form item.
     *
     * @return DateChooser
     */
    public DateChooser getPickerProperties()  {
        DateChooser properties = new DateChooser();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("pickerProperties"));
        return properties;
    }

    /**
     * A set of properties to apply to the {@link com.smartgwt.client.widgets.form.fields.TimeItem} displayed in the picker
     * when {@link com.smartgwt.client.widgets.form.fields.DateItem#getShowPickerTimeItem showPickerTimeItem} is true. <P> Has
     * no effect for fields of type <code>"date"</code>.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param pickerTimeItemProperties  Default value is null
     */
    public void setPickerTimeItemProperties(TimeItem pickerTimeItemProperties) {
        setAttribute("pickerTimeItemProperties", pickerTimeItemProperties.getJsObj());
    }

    /**
     * A set of properties to apply to the {@link com.smartgwt.client.widgets.form.fields.TimeItem} displayed in the picker
     * when {@link com.smartgwt.client.widgets.form.fields.DateItem#getShowPickerTimeItem showPickerTimeItem} is true. <P> Has
     * no effect for fields of type <code>"date"</code>.
     *
     * @return TimeItem
     */
    public TimeItem getPickerTimeItemProperties()  {
        return TimeItem.getOrCreateRef(getAttributeAsJavaScriptObject("pickerTimeItemProperties"));
    }

    /**
     * If showing date selectors rather than the date text field (so when  <code>this.useTextField</code> is false), this
     * property allows customization of the  order of the day, month and year selector fields.  If unset these fields will
     * match the specified inputFormat for this item. <P> Note: selectors may be ommitted entirely by setting selectorFormat to
     * (for example)  <code>"MD"</code>. In this case the value for the omitted selector will match the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDefaultValue defaultValue} specified for the item.  For example, if
     * the selector format is "MD" (month and day only), the year comes from the Date specified as the defaultValue.
     *
     * @param selectorFormat  Default value is null
     */
    public void setSelectorFormat(DateItemSelectorFormat selectorFormat) {
        setAttribute("selectorFormat", selectorFormat == null ? null : selectorFormat.getValue());
    }

    /**
     * If showing date selectors rather than the date text field (so when  <code>this.useTextField</code> is false), this
     * property allows customization of the  order of the day, month and year selector fields.  If unset these fields will
     * match the specified inputFormat for this item. <P> Note: selectors may be ommitted entirely by setting selectorFormat to
     * (for example)  <code>"MD"</code>. In this case the value for the omitted selector will match the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDefaultValue defaultValue} specified for the item.  For example, if
     * the selector format is "MD" (month and day only), the year comes from the Date specified as the defaultValue.
     *
     * @return DateItemSelectorFormat
     */
    public DateItemSelectorFormat getSelectorFormat()  {
        return EnumUtil.getEnum(DateItemSelectorFormat.values(), getAttribute("selectorFormat"));
    }

    /**
     * When set to true, show a button that allows the calendar to be navigated by fiscal year.
     *
     * @param showChooserFiscalYearPicker  Default value is false
     */
    public void setShowChooserFiscalYearPicker(Boolean showChooserFiscalYearPicker) {
        setAttribute("showChooserFiscalYearPicker", showChooserFiscalYearPicker);
    }

    /**
     * When set to true, show a button that allows the calendar to be navigated by fiscal year.
     *
     * @return Boolean
     */
    public Boolean getShowChooserFiscalYearPicker()  {
        return getAttributeAsBoolean("showChooserFiscalYearPicker");
    }

    /**
     * When set to true, show a button that allows the calendar to be navigated by week or fiscal week, depending on the value
     * of {@link com.smartgwt.client.widgets.form.fields.DateItem#getShowChooserFiscalYearPicker showChooserFiscalYearPicker}.
     *
     * @param showChooserWeekPicker  Default value is false
     */
    public void setShowChooserWeekPicker(Boolean showChooserWeekPicker) {
        setAttribute("showChooserWeekPicker", showChooserWeekPicker);
    }

    /**
     * When set to true, show a button that allows the calendar to be navigated by week or fiscal week, depending on the value
     * of {@link com.smartgwt.client.widgets.form.fields.DateItem#getShowChooserFiscalYearPicker showChooserFiscalYearPicker}.
     *
     * @return Boolean
     */
    public Boolean getShowChooserWeekPicker()  {
        return getAttributeAsBoolean("showChooserWeekPicker");
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is true and a {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getHint hint} is set, should the hint be shown within the field? <p>
     * Note that when using a native HTML5 date input (see {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getBrowserInputType browserInputType}), in-field hints are currently
     * supported, but future browser changes might not allow in-field hints to be supported. Therefore, it is safest to
     * <em>not</em> use in-field hints in conjunction with a native HTML5 date input. <p> To change this attribute after being
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
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is true and a {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getHint hint} is set, should the hint be shown within the field? <p>
     * Note that when using a native HTML5 date input (see {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getBrowserInputType browserInputType}), in-field hints are currently
     * supported, but future browser changes might not allow in-field hints to be supported. Therefore, it is safest to
     * <em>not</em> use in-field hints in conjunction with a native HTML5 date input. <p> To change this attribute after being
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
     * If this field is of type <code>"datetime"</code>, when showing the {@link com.smartgwt.client.widgets.DateChooser},
     * should the {@link com.smartgwt.client.widgets.DateChooser#getShowTimeItem time field} be displayed? <P> Has no effect
     * for fields of type <code>"date"</code>. <p> This attribute does not have an effect if a native HTML5 date input is being
     * used. See {@link com.smartgwt.client.widgets.form.fields.DateItem#getBrowserInputType browserInputType}.
     *
     * @param showPickerTimeItem  Default value is true
     */
    public void setShowPickerTimeItem(Boolean showPickerTimeItem) {
        setAttribute("showPickerTimeItem", showPickerTimeItem);
    }

    /**
     * If this field is of type <code>"datetime"</code>, when showing the {@link com.smartgwt.client.widgets.DateChooser},
     * should the {@link com.smartgwt.client.widgets.DateChooser#getShowTimeItem time field} be displayed? <P> Has no effect
     * for fields of type <code>"date"</code>. <p> This attribute does not have an effect if a native HTML5 date input is being
     * used. See {@link com.smartgwt.client.widgets.form.fields.DateItem#getBrowserInputType browserInputType}.
     *
     * @return Boolean
     */
    public Boolean getShowPickerTimeItem()  {
        return getAttributeAsBoolean("showPickerTimeItem");
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
     * <p>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.form.fields.DateItem#getStartDate startDate}.
     *
     * @param startDate the new startDate.. Default value is 1/1/1995
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setStartDate(Date startDate) {
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
     * @return Date
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Date getStartDate()  {
        return getAttributeAsDate("startDate");
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is <code>true</code> this
     * property governs the alignment of text within the text field. Defaults to <code>"right"</code> by default or
     * <code>"left"</code> if the page is in {@link com.smartgwt.client.util.Page#isRTL rtl mode}. <p> This attribute does not
     * have an effect if a native HTML5 date input is being used. See {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getBrowserInputType browserInputType}.
     *
     * @param textAlign  Default value is varies
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setTextAlign(Alignment textAlign) {
        setAttribute("textAlign", textAlign == null ? null : textAlign.getValue());
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is <code>true</code> this
     * property governs the alignment of text within the text field. Defaults to <code>"right"</code> by default or
     * <code>"left"</code> if the page is in {@link com.smartgwt.client.util.Page#isRTL rtl mode}. <p> This attribute does not
     * have an effect if a native HTML5 date input is being used. See {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getBrowserInputType browserInputType}.
     *
     * @return Alignment
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Alignment getTextAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("textAlign"));
    }

    /**
     * Text field to hold the entire date in "type in" format, if {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is true.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return TextItem
     */
    public TextItem getTextField()  {
        return TextItem.getOrCreateRef(getAttributeAsJavaScriptObject("textField"));
    }

    /**
     * Custom properties to apply to this dateItem's generated {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getTextField textField}. Only applies if {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is true.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param textFieldProperties  Default value is null
     */
    public void setTextFieldProperties(TextItem textFieldProperties) {
        setAttribute("textFieldProperties", textFieldProperties.getJsObj());
    }

    /**
     * Custom properties to apply to this dateItem's generated {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getTextField textField}. Only applies if {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is true.
     *
     * @return TextItem
     */
    public TextItem getTextFieldProperties()  {
        return TextItem.getOrCreateRef(getAttributeAsJavaScriptObject("textFieldProperties"));
    }

    /**
     * When showing the {@link com.smartgwt.client.widgets.DateChooser} and the field is of type "datetime", whether the {@link
     * com.smartgwt.client.widgets.DateChooser#getShowTimeItem time field} should be set to use 24-hour time.  The  default is
     * true. <P> Has no effect if {@link com.smartgwt.client.widgets.form.fields.DateItem#getShowPickerTimeItem
     * showPickerTimeItem} is explicitly set to <code>false</code>.
     *
     * @param use24HourTime  Default value is true
     */
    public void setUse24HourTime(Boolean use24HourTime) {
        setAttribute("use24HourTime", use24HourTime);
    }

    /**
     * When showing the {@link com.smartgwt.client.widgets.DateChooser} and the field is of type "datetime", whether the {@link
     * com.smartgwt.client.widgets.DateChooser#getShowTimeItem time field} should be set to use 24-hour time.  The  default is
     * true. <P> Has no effect if {@link com.smartgwt.client.widgets.form.fields.DateItem#getShowPickerTimeItem
     * showPickerTimeItem} is explicitly set to <code>false</code>.
     *
     * @return Boolean
     */
    public Boolean getUse24HourTime()  {
        return getAttributeAsBoolean("use24HourTime");
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is not <code>false</code> this
     * property determines if an input mask should be used. The format of the mask is determined by the  {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat inputFormat} or {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getDateFormatter dateFormatter} (in that order). <p> This attribute
     * does not have an effect if a native HTML5 date input is being used. See {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getBrowserInputType browserInputType}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param useMask  Default value is null
     * @see com.smartgwt.client.widgets.form.fields.DateItem#setMaskDateSeparator
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public void setUseMask(Boolean useMask) {
        setAttribute("useMask", useMask);
    }

    /**
     * When set to true (the default), use a single shared date-picker across all widgets that use one.  When false, create a
     * new picker using the autoChild system.  See  {@link com.smartgwt.client.widgets.form.fields.DateItem#getPickerDefaults
     * picker} and  {@link com.smartgwt.client.widgets.form.fields.DateItem#getPickerProperties pickerProperties} for details
     * on setting up an unshared picker.
     *
     * @param useSharedPicker  Default value is true
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
     * @return Boolean
     */
    public Boolean getUseSharedPicker()  {
        return getAttributeAsBoolean("useSharedPicker");
    }

    /**
     * Should we show the date in a text field, or as 3 select boxes?
     *
     * @param useTextField  Default value is null
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_datatypes_date" target="examples">Date Example</a>
     */
    public void setUseTextField(Boolean useTextField) {
        setAttribute("useTextField", useTextField);
    }

    /**
     * Should we show the date in a text field, or as 3 select boxes?
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_datatypes_date" target="examples">Date Example</a>
     */
    public Boolean getUseTextField()  {
        return getAttributeAsBoolean("useTextField");
    }

    /**
     * Select item to hold the year part of the date.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return SelectItem
     */
    public SelectItem getYearSelector()  {
        return SelectItem.getOrCreateRef(getAttributeAsJavaScriptObject("yearSelector"));
    }

    /**
     * Custom properties to apply to this dateItem's generated {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getYearSelector yearSelector}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param yearSelectorProperties  Default value is null
     */
    public void setYearSelectorProperties(SelectItem yearSelectorProperties) {
        setAttribute("yearSelectorProperties", yearSelectorProperties.getJsObj());
    }

    /**
     * Custom properties to apply to this dateItem's generated {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getYearSelector yearSelector}.
     *
     * @return SelectItem
     */
    public SelectItem getYearSelectorProperties()  {
        return SelectItem.getOrCreateRef(getAttributeAsJavaScriptObject("yearSelectorProperties"));
    }

    // ********************* Methods ***********************
	/**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is true, falls through to
     * standard {@link com.smartgwt.client.widgets.form.fields.TextItem#deselectValue deselectValue()} implementation on this
     * items freeform text entry field. Otherwise has no effect.
     */
    public native void deselectValue() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.deselectValue();
    }-*/;

	/**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is true, falls through to
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
     * Returns the raw text value typed into this items text field if {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField}  is true (otherwise returns the result of
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
     * Returns the {@link com.smartgwt.client.widgets.FiscalCalendar} object that will be used by this item's DateChooser.
     *
     * @return the fiscal calendar for this chooser, if set, or the global            one otherwise
     */
    public native FiscalCalendar getFiscalCalendar() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getFiscalCalendar();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.FiscalCalendar::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is true, falls through to
     * standard {@link com.smartgwt.client.widgets.form.fields.TextItem#selectValue selectValue()} implementation on this items
     * freeform text entry field. Otherwise has no effect.
     */
    public native void selectValue() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.selectValue();
    }-*/;

	/**
     * Sets the {@link com.smartgwt.client.widgets.FiscalCalendar} object that will be used by this item's DateChooser.  If 
     * unset, the _link{Date.getFiscalCalendar, global fiscal calendar} is used.
     */
    public native void setFiscalCalendar() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.setFiscalCalendar();
    }-*/;

	/**
     * Sets the {@link com.smartgwt.client.widgets.FiscalCalendar} object that will be used by this item's DateChooser.  If 
     * unset, the _link{Date.getFiscalCalendar, global fiscal calendar} is used.
     * @param fiscalCalendar the fiscal calendar for this chooser, if set, or the global            one otherwise
     */
    public native void setFiscalCalendar(FiscalCalendar fiscalCalendar) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.setFiscalCalendar(fiscalCalendar == null ? null : fiscalCalendar.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;


	/**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is true, falls through to
     * standard {@link com.smartgwt.client.widgets.form.fields.TextItem#setSelectionRange setSelectionRange()} implementation
     * on this items freeform text entry field. Otherwise has no effect.
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
     * @param dateItemProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(DateItem dateItemProperties) /*-{
    	var properties = $wnd.isc.addProperties({},dateItemProperties.@com.smartgwt.client.core.RefDataClass::getJsObj()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
        $wnd.isc.DateItem.addProperties(properties);
    }-*/;

    // ***********************************************************


    /**
     * Return the value tracked by this form item.
     *
     * @return value of this element
     */
    public native Date getValueAsDate() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret;
        if(self.setValue) {
             ret = self.getValue();
        } else {
            ret = self.value;
        }
        return ret == null ? null : @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is true, falls through to
     * standard {@link com.smartgwt.client.widgets.form.fields.FormItem#getSelectionRange} implementation on this items
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

    /**
     * An optional {@link com.smartgwt.client.widgets.form.FormItemValueFormatter} to map this item's current data 
     * value  to a display value. Only applies if {@link #setUseTextField} is true.
     * <P>
     * Notes
     * <ul><li>{@link #setDateFormatter()} already provides support for most standard "short date" formats, so
     *         a completely custom formatter method is often not required.</li>
     *     <li>System-wide custom date formatting and parsing may be achieved via methods on the 
     *         {@link DateUtil} class.</li>
     *     <li>When a custom formatter is specified, you may also need to modify the {@link #setInputFormat()} or
     *         supply a custom {@link #setEditorValueParser()}</li>
     * </ul>
     * <P>
     * When writing custom date formatting and parsing logic, developers may find the 
     * {@link com.google.gwt.i18n.client.DateTimeFormat} class helpful.
     * 
     * @param formatter the FormItemValueFormatter
     *
     */
    public void setEditorValueFormatter(FormItemValueFormatter formatter) {
        super.setEditorValueFormatter(formatter);
    }

    /**
     * An optional {@link com.smartgwt.client.widgets.form.FormItemValueParser} to map a user-entered display value to a data
     * value for storage. Only applies if {@link #setUseTextField()} is set to true.
     * <P>
     * A custom parser function will typically only be required if
     * a custom formatter is specified via {@link #setEditorValueFormatter(FormItemValueFormatter)}. Even then,
     * you may be able to simply specify an {@link #setInputFormat(String) inputFormat} that matches the custom display
     * format for this item.
     * <P>
     * System-wide custom date parsing and formatting may be achieved via methods on the {@link DateUtil} class.
     * <P>
     * When writing custom date formatting and parsing logic, developers may find the 
     * {@link com.google.gwt.i18n.client.DateTimeFormat} class helpful.
     * 
     * @param valueParser the FormItemValueParser
     */
    public void setEditorValueParser(FormItemValueParser valueParser) {
        super.setEditorValueParser(valueParser);
    }

}



