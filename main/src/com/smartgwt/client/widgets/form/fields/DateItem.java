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
 * Item for manipulating Dates. <p> Can be rendered as a text field, or as 3 selects for day, month, year.  Includes
 * optional pop-up picker.
 */
public class DateItem extends FormItem {

    public static DateItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (DateItem) obj;
        } else {
            return new DateItem(jsObj);
        }
    }

    public DateItem(){
        setAttribute("editorType", "DateItem");
    }

    public DateItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public DateItem(String name) {
        setName(name);
        setAttribute("editorType", "DateItem");
    }

    public DateItem(String name, String title) {
        setName(name);
		setTitle(title);
        setAttribute("editorType", "DateItem");
    }

    // ********************* Properties / Attributes ***********************

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
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is <code>true</code> this
     * property can be used to  customize the format in which dates are displayed for this item.<br> Should be set to a
     * standard {@link com.smartgwt.client.types.DateDisplayFormat}. <P> As with any formItem rendering out a date value, if no
     * explicit dateFormatter is supplied, dateFormatter will be derived from {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getDateFormatter dateFormatter} or {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getDatetimeFormatter datetimeFormatter},  depending on the specified {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getType type} for this field, if set, otherwise from the standard
     * default  Date.setShortDisplayFormat or  Date.setShortDatetimeDisplayFormat. <P> NOTE: For entirely custom formats,
     * developers may apply a custom   <code>editorValueFormatter</code>. To ensure the DateItem is able to parse user-entered
     * date strings back into Dates, for most cases developers can specify an explicit {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat inputFormat}, or if necessary a custom
     * <code>editorValuePaser</code>
     *
     * @param dateFormatter dateFormatter Default value is null
     */
    public void setDateFormatter(DateDisplayFormat dateFormatter) {
        setAttribute("dateFormatter", dateFormatter.getValue());
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is <code>true</code> this
     * property can be used to  customize the format in which dates are displayed for this item.<br> Should be set to a
     * standard {@link com.smartgwt.client.types.DateDisplayFormat}. <P> As with any formItem rendering out a date value, if no
     * explicit dateFormatter is supplied, dateFormatter will be derived from {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getDateFormatter dateFormatter} or {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getDatetimeFormatter datetimeFormatter},  depending on the specified {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getType type} for this field, if set, otherwise from the standard
     * default  Date.setShortDisplayFormat or  Date.setShortDatetimeDisplayFormat. <P> NOTE: For entirely custom formats,
     * developers may apply a custom   <code>editorValueFormatter</code>. To ensure the DateItem is able to parse user-entered
     * date strings back into Dates, for most cases developers can specify an explicit {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat inputFormat}, or if necessary a custom
     * <code>editorValuePaser</code>
     *
     *
     * @return DateDisplayFormat
     */
    public DateDisplayFormat getDateFormatter()  {
        return EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("dateFormatter"));
    }

    /**
     * Custom properties to apply to this dateItem's generated {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getDaySelector daySelector}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param daySelectorProperties daySelectorProperties Default value is null
     */
    public void setDaySelectorProperties(SelectItem daySelectorProperties) {
        setAttribute("daySelectorProperties", daySelectorProperties.getJsObj());
    }

    /**
     * Custom properties to apply to this dateItem's generated {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getDaySelector daySelector}.
     *
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
     * @param defaultChooserDate defaultChooserDate Default value is null
     */
    public void setDefaultChooserDate(java.util.Date defaultChooserDate) {
        setAttribute("defaultChooserDate", defaultChooserDate);
    }

    /**
     * Default date to show in the date chooser. If this items value is currently unset, this property may be specified to set
     * a default date to highlight in the dateChooser  for this item. If unset, the date chooser will highlight the current
     * date by default. Note that this has no effect if the item as a whole currently has a value - in that case the date
     * chooser will always highlight the current value for the item.
     *
     *
     * @return Returns the default date to display in the date chooser if this form items value is currently unset. <P> Default
     * implementation returns {@link com.smartgwt.client.widgets.form.fields.DateItem#getDefaultChooserDate defaultChooserDate}
     */
    public java.util.Date getDefaultChooserDate()  {
        return getAttributeAsDate("defaultChooserDate");
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
     *  When set to false, a user may enter value that is not a valid date (for example, "Not
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
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param enforceDate enforceDate Default value is false
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
     *  When set to false, a user may enter value that is not a valid date (for example, "Not
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
     *
     *
     * @return Boolean
     */
    public Boolean getEnforceDate()  {
        return getAttributeAsBoolean("enforceDate");
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is <code>true</code> this
     * property can be used to specify the input format for date strings.  If unset, the input format will be determined based
     * on the specified {@link com.smartgwt.client.widgets.form.fields.DateItem#getDateFormtter dateFormtter} if possible (see
     * {@link com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat DateItem.getInputFormat}), otherwise picked up
     * from the Date class (see  Date.setInputFormat). <P> Should be set to a standard String <P> Note that the String property
     * is sufficient to parse date or datetime strings specified in most standard date formats. However should an entirely
     * custom parsing function be required developers can  <code class="smartclient">implement a custom {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#parseEditorValue DateItem.parseEditorValue} method.</var> <code
     * class="smartgwt">apply a custom <code>editorValueParser</code> function.</var>
     *
     * @param inputFormat inputFormat Default value is null
     * @see com.smartgwt.client.widgets.form.fields.DateItem#setDisplayFormat
     */
    public void setInputFormat(String inputFormat) {
        setAttribute("inputFormat", inputFormat);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is <code>true</code> this
     * property can be used to specify the input format for date strings.  If unset, the input format will be determined based
     * on the specified {@link com.smartgwt.client.widgets.form.fields.DateItem#getDateFormtter dateFormtter} if possible (see
     * {@link com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat DateItem.getInputFormat}), otherwise picked up
     * from the Date class (see  Date.setInputFormat). <P> Should be set to a standard String <P> Note that the String property
     * is sufficient to parse date or datetime strings specified in most standard date formats. However should an entirely
     * custom parsing function be required developers can  <code class="smartclient">implement a custom {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#parseEditorValue DateItem.parseEditorValue} method.</var> <code
     * class="smartgwt">apply a custom <code>editorValueParser</code> function.</var>
     *
     *
     * @return If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is <code>true</code> this
     * method returns a standard String, determining how values entered by the user are to be converted to Javascript Date
     * objects. <P> If an explicit {@link com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat inputFormat} has been
     * specified it will be returned, otherwise, the input format will be automatically derived from the {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getDateFormatter dateFormatter} property. <P> Note that the inputFormat
     * will ignore any separator characters and padding of values. However if necessary entirely custom date formatting and
     * parsing may be achieved via the  <code>setEditorValueFormatter()</code> and  <code>setEditorValueParser()</code> APIs.
     * @see com.smartgwt.client.widgets.form.fields.DateItem#getDisplayFormat
     */
    public String getInputFormat()  {
        return getAttributeAsString("inputFormat");
    }

    /**
     * Validation error message to display if the user enters an invalid date
     *
     * @param invalidDateStringMessage invalidDateStringMessage Default value is "Invalid date"
     */
    public void setInvalidDateStringMessage(String invalidDateStringMessage) {
        setAttribute("invalidDateStringMessage", invalidDateStringMessage);
    }

    /**
     * Validation error message to display if the user enters an invalid date
     *
     *
     * @return String
     */
    public String getInvalidDateStringMessage()  {
        return getAttributeAsString("invalidDateStringMessage");
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} and {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getUseMask useMask} are both <code>true</code> this value is the
     * separator between date components. If unset  getDefaultSeparator will be used.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param maskDateSeparator maskDateSeparator Default value is null
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public void setMaskDateSeparator(String maskDateSeparator) {
        setAttribute("maskDateSeparator", maskDateSeparator);
    }

    /**
     * Custom properties to apply to this dateItem's generated {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getMonthSelector monthSelector}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param monthSelectorProperties monthSelectorProperties Default value is null
     */
    public void setMonthSelectorProperties(SelectItem monthSelectorProperties) {
        setAttribute("monthSelectorProperties", monthSelectorProperties.getJsObj());
    }

    /**
     * Custom properties to apply to this dateItem's generated {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getMonthSelector monthSelector}.
     *
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
     * @param pickerIconPrompt pickerIconPrompt Default value is "Show Date Chooser"
     */
    public void setPickerIconPrompt(String pickerIconPrompt) {
        setAttribute("pickerIconPrompt", pickerIconPrompt);
    }

    /**
     * Prompt to show when the user hovers the mouse over the picker icon for this DateItem. May be overridden for localization
     * of your application.
     *
     *
     * @return String
     */
    public String getPickerIconPrompt()  {
        return getAttributeAsString("pickerIconPrompt");
    }

    /**
     * If showing date selectors rather than the date text field (so when  <code>this.useTextField</code> is false), this
     * property allows customization of the  order of the day, month and year selector fields.  If unset these fields will
     * match the specified inputFormat for this item. <P> Note: selectors may be ommitted entirely by setting selectorFormat to
     * (for example)  <code>"MD"</code>. In this case the value for the omitted selector will match the {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getDefaultValue defaultValue} specified for the item.  For example, if
     * the selector format is "MD" (month and day only), the year comes from the Date specified as the defaultValue.
     *
     * @param selectorFormat selectorFormat Default value is null
     */
    public void setSelectorFormat(DateItemSelectorFormat selectorFormat) {
        setAttribute("selectorFormat", selectorFormat.getValue());
    }

    /**
     * If showing date selectors rather than the date text field (so when  <code>this.useTextField</code> is false), this
     * property allows customization of the  order of the day, month and year selector fields.  If unset these fields will
     * match the specified inputFormat for this item. <P> Note: selectors may be ommitted entirely by setting selectorFormat to
     * (for example)  <code>"MD"</code>. In this case the value for the omitted selector will match the {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getDefaultValue defaultValue} specified for the item.  For example, if
     * the selector format is "MD" (month and day only), the year comes from the Date specified as the defaultValue.
     *
     *
     * @return DateItemSelectorFormat
     */
    public DateItemSelectorFormat getSelectorFormat()  {
        return EnumUtil.getEnum(DateItemSelectorFormat.values(), getAttribute("selectorFormat"));
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
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is <code>true</code> this
     * property governs the alignment of text within the text field.
     *
     * @param textAlign textAlign Default value is Canvas.RIGHT
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setTextAlign(Alignment textAlign) {
        setAttribute("textAlign", textAlign.getValue());
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is <code>true</code> this
     * property governs the alignment of text within the text field.
     *
     *
     * @return Alignment
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Alignment getTextAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("textAlign"));
    }

    /**
     * Custom properties to apply to this dateItem's generated {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getTextField textField}. Only applies if {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is true.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param textFieldProperties textFieldProperties Default value is null
     */
    public void setTextFieldProperties(TextItem textFieldProperties) {
        setAttribute("textFieldProperties", textFieldProperties.getJsObj());
    }

    /**
     * Custom properties to apply to this dateItem's generated {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getTextField textField}. Only applies if {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is true.
     *
     *
     * @return TextItem
     */
    public TextItem getTextFieldProperties()  {
        return TextItem.getOrCreateRef(getAttributeAsJavaScriptObject("textFieldProperties"));
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is not <code>false</code> this
     * property determines if an input mask should be used. The format of the mask is determined by the  {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat inputFormat} or {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getDateFormatter dateFormatter} (in that order).
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param useMask useMask Default value is null
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
     * Should we show the date in a text field, or as 3 select boxes?
     *
     * @param useTextField useTextField Default value is null
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_datatypes_date" target="examples">Date Example</a>
     */
    public void setUseTextField(Boolean useTextField) {
        setAttribute("useTextField", useTextField);
    }

    /**
     * Should we show the date in a text field, or as 3 select boxes?
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_datatypes_date" target="examples">Date Example</a>
     */
    public Boolean getUseTextField()  {
        return getAttributeAsBoolean("useTextField");
    }

    /**
     * Custom properties to apply to this dateItem's generated {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getYearSelector yearSelector}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param yearSelectorProperties yearSelectorProperties Default value is null
     */
    public void setYearSelectorProperties(SelectItem yearSelectorProperties) {
        setAttribute("yearSelectorProperties", yearSelectorProperties.getJsObj());
    }

    /**
     * Custom properties to apply to this dateItem's generated {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getYearSelector yearSelector}.
     *
     *
     * @return SelectItem
     */
    public SelectItem getYearSelectorProperties()  {
        return SelectItem.getOrCreateRef(getAttributeAsJavaScriptObject("yearSelectorProperties"));
    }

    // ********************* Methods ***********************
            
    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is true, falls through to
     * standard {@link com.smartgwt.client.widgets.form.fields.FormItem#deselectValue FormItem.deselectValue} implementation on
     * this items freeform text entry field. Otherwise has no effect.
     */
    public native void deselectValue() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.deselectValue();
    }-*/;

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is true, falls through to
     * standard {@link com.smartgwt.client.widgets.form.fields.FormItem#deselectValue FormItem.deselectValue} implementation on
     * this items freeform text entry field. Otherwise has no effect.
     * @param start If this parameter is passed, new cursor insertion position will be   moved to the start, rather than the end of this
     * item's value.
     */
    public native void deselectValue(boolean start) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.deselectValue(start);
    }-*/;
            
    /**
     * Returns the raw text value typed into this items text field if {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField}  is true (otherwise returns the result of
     * this.getValue()).
     */
    public native void getEnteredValue() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.getEnteredValue();
    }-*/;
            
    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is true, falls through to
     * standard {@link com.smartgwt.client.widgets.form.fields.FormItem#selectValue FormItem.selectValue} implementation on
     * this items freeform text entry field. Otherwise has no effect.
     */
    public native void selectValue() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.selectValue();
    }-*/;
            
    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is true, falls through to
     * standard {@link com.smartgwt.client.widgets.form.fields.FormItem#setSelectionRange FormItem.setSelectionRange}
     * implementation on this items freeform text entry field. Otherwise has no effect.
     * @param start character index for start of new selection
     * @param end character index for end of new selection
     */
    public native void setSelectionRange(int start, int end) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.setSelectionRange(start, end);
    }-*/;

    // ********************* Static Methods ***********************
        
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
     * you may be able to simply specify an {@link setInputFormat(),inputFormat} that matches the custom display
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




