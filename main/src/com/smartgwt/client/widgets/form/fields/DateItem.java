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
 * com.smartgwt.client.util.DateUtil#createLogicalDate logical-Date} values, where  times are ignored. <p> The item renders
 * with one of two appearances, depending on the value of {@link
 * com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField}  - when set to true, dates are edited
 * directly as text-values, and formatted  according to your locale and settings such as {@link
 * com.smartgwt.client.widgets.form.fields.DateItem#getDateFormatter dateFormatter}. <p> When set to false, the default
 * appearance, the item uses separate selectors for  {@link
 * com.smartgwt.client.widgets.form.fields.DateItem#getYearSelector year}, {@link
 * com.smartgwt.client.widgets.form.fields.DateItem#getMonthSelector month} and  {@link
 * com.smartgwt.client.widgets.form.fields.DateItem#getDaySelector day} values.  To control which selectors are visible and
 * in what  order, use {@link com.smartgwt.client.widgets.form.fields.DateItem#getSelectorFormat selectorFormat}.  In this
 * mode, the selectable dates may be  limited by the item's {@link
 * com.smartgwt.client.widgets.form.fields.DateItem#getStartDate start} and {@link
 * com.smartgwt.client.widgets.form.fields.DateItem#getEndDate end}  dates.  See those two settings for more information.
 * <P> In either mode, a {@link com.smartgwt.client.widgets.DateChooser popup picker} is provided assuming that the  {@link
 * com.smartgwt.client.widgets.form.fields.DateItem#getShowPickerIcon pickerIcon} is visible.  <p> As noted, this item is
 * for editing {@link com.smartgwt.client.util.DateUtil#createLogicalDate logical-Date values}. To edit {@link
 * com.smartgwt.client.util.DateUtil#createLogicalTime logical-Time values}, see {@link
 * com.smartgwt.client.widgets.form.fields.TimeItem}, and to edit {@link com.smartgwt.client.util.DateUtil#createDatetime
 * datetime values}, see {@link com.smartgwt.client.widgets.form.fields.DateTimeItem}. For {@link
 * com.smartgwt.client.docs.RelativeDateString relative-date features}, see {@link
 * com.smartgwt.client.widgets.form.fields.RelativeDateItem}. <P> For detailed information on working with dates, times and
 * datetimes, see the  {@link com.smartgwt.client.docs.DateFormatAndStorage Date and Time Format and Storage overview}.
 */
@BeanFactory.FrameworkClass
public class DateItem extends FormItem {

    public static DateItem getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof DateItem) {
            existingObj.setJsObj(jsObj);
            return (DateItem)existingObj;
        } else

        {
            return new DateItem(jsObj);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DateItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.DateItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DateItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.DateItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public static native void changePickerIconDefaults(FormItemIcon defaults) /*-{
        $wnd.isc.DateItem.changeDefaults("pickerIconDefaults", defaults.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public DateItem(){
        setType("date");
					setAttribute("editorType", "DateItem");
    }

    public DateItem(JavaScriptObject jsObj){
        super(jsObj);
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
     * When set to true, the default, and when {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField
     * useTextField} is  set to false, such that the item displays multiple separate pickers,  <code>useTextField</code> is
     * automatically switched on when the item is rendering in a non-interactive way, such as when printing, or when  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit canEdit} is false and the read-only display-mode is  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyDisplay static}.
     *
     * @param autoUseTextField New autoUseTextField value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.DateItem DateItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public DateItem setAutoUseTextField(Boolean autoUseTextField) {
        return (DateItem)setAttribute("autoUseTextField", autoUseTextField);
    }

    /**
     * When set to true, the default, and when {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField
     * useTextField} is  set to false, such that the item displays multiple separate pickers,  <code>useTextField</code> is
     * automatically switched on when the item is rendering in a non-interactive way, such as when printing, or when  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit canEdit} is false and the read-only display-mode is  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyDisplay static}.
     *
     * @return Current autoUseTextField value. Default value is true
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public Boolean getAutoUseTextField()  {
        Boolean result = getAttributeAsBoolean("autoUseTextField", true);
        return result == null ? true : result;
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is true and browserInputType is
     * set to "date", then a native <a href='http://www.w3.org/TR/html5/forms.html#date-state-(type=date)'
     * target='_blank'>HTML5 date input</a> is used in place of a text input. <p> The use of a native HTML5 date input causes
     * certain features to be disabled. Input masks, the picker icon, and a custom {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getDateFormatter dateFormatter} are not supported. {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getShowHintInField In-field hints} are currently supported, but future
     * browser changes might force this support to be removed. Therefore, it is safest to <em>not</em> use in-field hints (set
     * showHintInField to false) in conjunction with a native HTML5 date input. <p> <b>NOTE:</b> For optimal appearance this
     * feature requires specific CSS which may not be present in certain legacy skins.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param browserInputType New browserInputType value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.DateItem DateItem} instance, for chaining setter calls
     */
    public DateItem setBrowserInputType(String browserInputType) {
        return (DateItem)setAttribute("browserInputType", browserInputType);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is true and browserInputType is
     * set to "date", then a native <a href='http://www.w3.org/TR/html5/forms.html#date-state-(type=date)'
     * target='_blank'>HTML5 date input</a> is used in place of a text input. <p> The use of a native HTML5 date input causes
     * certain features to be disabled. Input masks, the picker icon, and a custom {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getDateFormatter dateFormatter} are not supported. {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getShowHintInField In-field hints} are currently supported, but future
     * browser changes might force this support to be removed. Therefore, it is safest to <em>not</em> use in-field hints (set
     * showHintInField to false) in conjunction with a native HTML5 date input. <p> <b>NOTE:</b> For optimal appearance this
     * feature requires specific CSS which may not be present in certain legacy skins.
     *
     * @return Current browserInputType value. Default value is null
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
     * @param centuryThreshold New centuryThreshold value. Default value is 25
     * @return {@link com.smartgwt.client.widgets.form.fields.DateItem DateItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public DateItem setCenturyThreshold(int centuryThreshold) {
        return (DateItem)setAttribute("centuryThreshold", centuryThreshold);
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
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is <code>true</code> this
     * property can be used to  customize the format in which dates are displayed for this item.<br> Should be set to a
     * standard {@link com.smartgwt.client.types.DateDisplayFormat}. <P> As with any formItem rendering out a date value, if no
     * explicit dateFormatter is supplied, dateFormatter will be derived from {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getDateFormatter DynamicForm.dateFormatter} or {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getDatetimeFormatter DynamicForm.datetimeFormatter},  depending on the
     * specified {@link com.smartgwt.client.widgets.form.fields.FormItem#getType FormItem.type} for this field, if set,
     * otherwise from the standard default  {@link com.smartgwt.client.util.DateUtil#setShortDisplayFormat
     * DateUtil.setShortDisplayFormat()} or {@link com.smartgwt.client.util.DateUtil#setShortDatetimeDisplayFormat
     * DateUtil.setShortDatetimeDisplayFormat()}. <P> NOTE: For entirely custom formats, developers may apply a custom  
     * <code>editorValueFormatter</code>. To ensure the DateItem is able to parse user-entered date strings back into Dates,
     * for most cases developers can specify an explicit {@link com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat
     * inputFormat}, or if necessary a custom <code>editorValueParser</code>  <p> This attribute does not have an effect if a
     * native HTML5 date or datetime input is being used. See {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getBrowserInputType browserInputType}.
     *
     * @param dateFormatter New dateFormatter value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.DateItem DateItem} instance, for chaining setter calls
     */
    public DateItem setDateFormatter(DateDisplayFormat dateFormatter) {
        return (DateItem)setAttribute("dateFormatter", dateFormatter == null ? null : dateFormatter.getValue());
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is <code>true</code> this
     * property can be used to  customize the format in which dates are displayed for this item.<br> Should be set to a
     * standard {@link com.smartgwt.client.types.DateDisplayFormat}. <P> As with any formItem rendering out a date value, if no
     * explicit dateFormatter is supplied, dateFormatter will be derived from {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getDateFormatter DynamicForm.dateFormatter} or {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getDatetimeFormatter DynamicForm.datetimeFormatter},  depending on the
     * specified {@link com.smartgwt.client.widgets.form.fields.FormItem#getType FormItem.type} for this field, if set,
     * otherwise from the standard default  {@link com.smartgwt.client.util.DateUtil#setShortDisplayFormat
     * DateUtil.setShortDisplayFormat()} or {@link com.smartgwt.client.util.DateUtil#setShortDatetimeDisplayFormat
     * DateUtil.setShortDatetimeDisplayFormat()}. <P> NOTE: For entirely custom formats, developers may apply a custom  
     * <code>editorValueFormatter</code>. To ensure the DateItem is able to parse user-entered date strings back into Dates,
     * for most cases developers can specify an explicit {@link com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat
     * inputFormat}, or if necessary a custom <code>editorValueParser</code>  <p> This attribute does not have an effect if a
     * native HTML5 date or datetime input is being used. See {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getBrowserInputType browserInputType}.
     *
     * @return Current dateFormatter value. Default value is null
     */
    public DateDisplayFormat getDateFormatter()  {
        return EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("dateFormatter"));
    }
    

    /**
     * {@link com.smartgwt.client.widgets.form.fields.SelectItem} for picking a day of the month. <P> To control which
     * selectors are visible and in what order, use {@link com.smartgwt.client.widgets.form.fields.DateItem#getSelectorFormat
     * selectorFormat}.
     * <p>
     * This component is an AutoChild named "daySelector".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current daySelector value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.DateItem#getSelectorFormat
     */
    public SelectItem getDaySelector()  {
        return SelectItem.getOrCreateRef(getAttributeAsJavaScriptObject("daySelector"));
    }
    

    /**
     * Custom properties to apply to this dateItem's generated {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getDaySelector daySelector}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param daySelectorProperties New daySelectorProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.DateItem DateItem} instance, for chaining setter calls
     */
    public DateItem setDaySelectorProperties(SelectItem daySelectorProperties) {
        if (daySelectorProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(DateItem.class, "setDaySelectorProperties", "SelectItem");
        }                                                                       
        daySelectorProperties.setConfigOnly(true);
        return (DateItem)setAttribute("daySelectorProperties", daySelectorProperties == null ? null : daySelectorProperties.getEditorTypeConfig());
    }

    /**
     * Custom properties to apply to this dateItem's generated {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getDaySelector daySelector}.
     *
     * @return Current daySelectorProperties value. Default value is null
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
     * @param defaultChooserDate New defaultChooserDate value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.DateItem DateItem} instance, for chaining setter calls
     */
    public DateItem setDefaultChooserDate(Date defaultChooserDate) {
        return (DateItem)setAttribute("defaultChooserDate", defaultChooserDate);
    }

    /**
     * Default date to show in the date chooser. If this items value is currently unset, this property may be specified to set
     * a default date to highlight in the dateChooser  for this item. If unset, the date chooser will highlight the current
     * date by default. Note that this has no effect if the item as a whole currently has a value - in that case the date
     * chooser will always highlight the current value for the item.
     *
     * @return Returns the default date to display in the date chooser if this form items value is currently unset. <P> Default
     * implementation returns {@link com.smartgwt.client.widgets.form.fields.DateItem#getDefaultChooserDate defaultChooserDate}. Default value is null
     */
    public Date getDefaultChooserDate()  {
        return getAttributeAsDate("defaultChooserDate");
    }
    
    

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @param editProxyConstructor New editProxyConstructor value. Default value is "DateItemEditProxy"
     * @return {@link com.smartgwt.client.widgets.form.fields.DateItem DateItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public DateItem setEditProxyConstructor(String editProxyConstructor) {
        return (DateItem)setAttribute("editProxyConstructor", editProxyConstructor);
    }

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @return Current editProxyConstructor value. Default value is "DateItemEditProxy"
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public String getEditProxyConstructor()  {
        return getAttributeAsString("editProxyConstructor");
    }
    

    /**
     * Maximum date the selectors will allow the user to pick.  The default value is December  31st, 5 years after the current
     * year. <P> See {@link com.smartgwt.client.widgets.form.fields.DateItem#getStartDate startDate} for details on how this
     * restriction works.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.form.fields.DateItem#getEndDate endDate}.<P> <b>Note:</b> A {@link com.smartgwt.client.util.DateUtil#createLogicalDate LogicalDate} is expected.
     *
     * @param endDate the new endDate. Default value is See below
     * @return {@link com.smartgwt.client.widgets.form.fields.DateItem DateItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public DateItem setEndDate(Date endDate) {
        return (DateItem)setAttribute("endDate", endDate);
    }

    /**
     * Maximum date the selectors will allow the user to pick.  The default value is December  31st, 5 years after the current
     * year. <P> See {@link com.smartgwt.client.widgets.form.fields.DateItem#getStartDate startDate} for details on how this
     * restriction works.
     *
     * @return Current endDate value. Default value is See below
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Date getEndDate()  {
        return getAttributeAsDate("endDate");
    }
    

    /**
     * Can this field be set to a non-date value [other than null]?
     *  <P>
     * When set to true, {@link com.smartgwt.client.widgets.form.fields.FormItem#setValue FormItem.setValue()} will return
     * false without setting the item value
     *  and log a warning if passed something other than a valid date value.
     * If the dateItem is showing a {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField free-form text
     * entry field},
     *  and a user enters a text value which cannot be parsed into a valid date, the item will
     * automatically redraw and display the {@link com.smartgwt.client.widgets.form.fields.DateItem#getInvalidDateStringMessage
     * invalidDateStringMessage} (though at this
     * point calling {@link com.smartgwt.client.widgets.form.fields.FormItem#getValue FormItem.getValue()} will return the
     * string entered by the user).
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
     * @param enforceDate New enforceDate value. Default value is false
     * @return {@link com.smartgwt.client.widgets.form.fields.DateItem DateItem} instance, for chaining setter calls
     */
    public DateItem setEnforceDate(Boolean enforceDate) {
        return (DateItem)setAttribute("enforceDate", enforceDate);
    }

    /**
     * Can this field be set to a non-date value [other than null]?
     *  <P>
     * When set to true, {@link com.smartgwt.client.widgets.form.fields.FormItem#setValue FormItem.setValue()} will return
     * false without setting the item value
     *  and log a warning if passed something other than a valid date value.
     * If the dateItem is showing a {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField free-form text
     * entry field},
     *  and a user enters a text value which cannot be parsed into a valid date, the item will
     * automatically redraw and display the {@link com.smartgwt.client.widgets.form.fields.DateItem#getInvalidDateStringMessage
     * invalidDateStringMessage} (though at this
     * point calling {@link com.smartgwt.client.widgets.form.fields.FormItem#getValue FormItem.getValue()} will return the
     * string entered by the user).
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
     * @return Current enforceDate value. Default value is false
     */
    public Boolean getEnforceDate()  {
        Boolean result = getAttributeAsBoolean("enforceDate", true);
        return result == null ? false : result;
    }
    

    /**
     * Dictates whether values applied to this item via {@link com.smartgwt.client.widgets.form.fields.DateItem#setValue
     * setValue()} or {@link com.smartgwt.client.widgets.form.DynamicForm#getValues form.values} will be accepted if they fall
     * outside the range  specified by the item's {@link com.smartgwt.client.widgets.form.fields.DateItem#getStartDate start}
     * and  {@link com.smartgwt.client.widgets.form.fields.DateItem#getEndDate end} dates. <P> When set to false, values
     * outside the valid range will be accepted, which may result in additional entries being added to the various pickers,
     * when  {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is false. <P> When set to
     * true, {@link com.smartgwt.client.widgets.form.fields.FormItem#setValue FormItem.setValue()} will return false for values
     * that fall  outside the range, the value will be rejected and the item defaulted to the start of  its defined range. 
     * When this happens,  {@link com.smartgwt.client.widgets.form.fields.FormItem#addChangeHandler change()} will not fire,
     * the item will not show the  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPending pending style}, and 
     * {@link com.smartgwt.client.widgets.form.DynamicForm#valuesHaveChanged valuesHaveChanged()} will return false, even 
     * though calling {@link com.smartgwt.client.widgets.form.DynamicForm#saveData saveData()} will result in a changed record,
     * if the {@link com.smartgwt.client.widgets.form.fields.FormItem#getForm parent form} is {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getDataSource data-bound}  and the current record came from the dataSource.
     * <P> This attribute does not have an effect if a native HTML5 date input is being used. See {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getBrowserInputType browserInputType}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param enforceValueRange New enforceValueRange value. Default value is false
     * @return {@link com.smartgwt.client.widgets.form.fields.DateItem DateItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.DateItem#setStartDate
     * @see com.smartgwt.client.widgets.form.fields.DateItem#setEndDate
     */
    public DateItem setEnforceValueRange(Boolean enforceValueRange) {
        return (DateItem)setAttribute("enforceValueRange", enforceValueRange);
    }

    /**
     * Dictates whether values applied to this item via {@link com.smartgwt.client.widgets.form.fields.DateItem#setValue
     * setValue()} or {@link com.smartgwt.client.widgets.form.DynamicForm#getValues form.values} will be accepted if they fall
     * outside the range  specified by the item's {@link com.smartgwt.client.widgets.form.fields.DateItem#getStartDate start}
     * and  {@link com.smartgwt.client.widgets.form.fields.DateItem#getEndDate end} dates. <P> When set to false, values
     * outside the valid range will be accepted, which may result in additional entries being added to the various pickers,
     * when  {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is false. <P> When set to
     * true, {@link com.smartgwt.client.widgets.form.fields.FormItem#setValue FormItem.setValue()} will return false for values
     * that fall  outside the range, the value will be rejected and the item defaulted to the start of  its defined range. 
     * When this happens,  {@link com.smartgwt.client.widgets.form.fields.FormItem#addChangeHandler change()} will not fire,
     * the item will not show the  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPending pending style}, and 
     * {@link com.smartgwt.client.widgets.form.DynamicForm#valuesHaveChanged valuesHaveChanged()} will return false, even 
     * though calling {@link com.smartgwt.client.widgets.form.DynamicForm#saveData saveData()} will result in a changed record,
     * if the {@link com.smartgwt.client.widgets.form.fields.FormItem#getForm parent form} is {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getDataSource data-bound}  and the current record came from the dataSource.
     * <P> This attribute does not have an effect if a native HTML5 date input is being used. See {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getBrowserInputType browserInputType}.
     *
     * @return Current enforceValueRange value. Default value is false
     * @see com.smartgwt.client.widgets.form.fields.DateItem#getStartDate
     * @see com.smartgwt.client.widgets.form.fields.DateItem#getEndDate
     */
    public Boolean getEnforceValueRange()  {
        Boolean result = getAttributeAsBoolean("enforceValueRange", true);
        return result == null ? false : result;
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is <code>true</code> this
     * property can be used to specify the input format for date strings.  If unset, the input format will be determined based
     * on the specified {@link com.smartgwt.client.widgets.form.fields.DateItem#getDateFormatter dateFormatter} if possible
     * (see {@link com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat getInputFormat()}), otherwise picked up from
     * the Date class (see {@link com.smartgwt.client.util.DateUtil#setInputFormat DateUtil.setInputFormat()}). <P> Should be
     * set to a standard {@link com.smartgwt.client.docs.DateInputFormat} <P> Note that the {@link
     * com.smartgwt.client.docs.DateInputFormat} property is sufficient to parse date or datetime strings specified in most
     * standard date formats. However should an entirely custom parsing function be required developers can   apply a custom
     * <code>editorValueParser</code> function. <p> This attribute does not have an effect if a native HTML5 date input is
     * being used. See {@link com.smartgwt.client.widgets.form.fields.DateItem#getBrowserInputType browserInputType}.
     *
     * @param inputFormat New inputFormat value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.DateItem DateItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.DateItem#setDisplayFormat
     * @see com.smartgwt.client.docs.DateInputFormat DateInputFormat 
     */
    public DateItem setInputFormat(String inputFormat) {
        return (DateItem)setAttribute("inputFormat", inputFormat);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is <code>true</code> this
     * property can be used to specify the input format for date strings.  If unset, the input format will be determined based
     * on the specified {@link com.smartgwt.client.widgets.form.fields.DateItem#getDateFormatter dateFormatter} if possible
     * (see {@link com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat getInputFormat()}), otherwise picked up from
     * the Date class (see {@link com.smartgwt.client.util.DateUtil#setInputFormat DateUtil.setInputFormat()}). <P> Should be
     * set to a standard {@link com.smartgwt.client.docs.DateInputFormat} <P> Note that the {@link
     * com.smartgwt.client.docs.DateInputFormat} property is sufficient to parse date or datetime strings specified in most
     * standard date formats. However should an entirely custom parsing function be required developers can   apply a custom
     * <code>editorValueParser</code> function. <p> This attribute does not have an effect if a native HTML5 date input is
     * being used. See {@link com.smartgwt.client.widgets.form.fields.DateItem#getBrowserInputType browserInputType}.
     *
     * @return If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is <code>true</code> this
     * method returns a standard {@link com.smartgwt.client.docs.DateInputFormat}, determining how values entered by the user
     * are to be converted to Javascript Date objects. <P> If an explicit {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat inputFormat} has been specified it will be returned,
     * otherwise, if a custom {@link com.smartgwt.client.widgets.form.fields.DateItem#getDateFormatter dateFormatter} or {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getFormat format} are specified, the input format will be automatically
     * derived from that property. <P> Otherwise, the global {@link com.smartgwt.client.util.DateUtil#setInputFormat
     * inputFormat} is used. <P> Note that the inputFormat will ignore any separator characters and padding of values. However
     * if necessary entirely custom date formatting and parsing may be achieved via the  <code>setEditorValueFormatter()</code>
     * and  <code>setEditorValueParser()</code> APIs. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.DateItem#getDisplayFormat
     * @see com.smartgwt.client.docs.DateInputFormat DateInputFormat 
     */
    public String getInputFormat()  {
        return getAttributeAsString("inputFormat");
    }
    

    /**
     * Validation error message to display if the user enters an invalid date
     *
     * @param invalidDateStringMessage New invalidDateStringMessage value. Default value is "Invalid date"
     * @return {@link com.smartgwt.client.widgets.form.fields.DateItem DateItem} instance, for chaining setter calls
     */
    public DateItem setInvalidDateStringMessage(String invalidDateStringMessage) {
        return (DateItem)setAttribute("invalidDateStringMessage", invalidDateStringMessage);
    }

    /**
     * Validation error message to display if the user enters an invalid date
     *
     * @return Current invalidDateStringMessage value. Default value is "Invalid date"
     */
    public String getInvalidDateStringMessage()  {
        return getAttributeAsString("invalidDateStringMessage");
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is false, the default
     * alignment of  titles for the {@link com.smartgwt.client.widgets.form.fields.DateItem#getDaySelector day}, {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getMonthSelector month}  and {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getYearSelector year} selectors, within their cells.
     *
     * @param itemTitleAlign New itemTitleAlign value. Default value is "center"
     * @return {@link com.smartgwt.client.widgets.form.fields.DateItem DateItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_form_titles" target="examples">Titles Example</a>
     */
    public DateItem setItemTitleAlign(Alignment itemTitleAlign) {
        return (DateItem)setAttribute("itemTitleAlign", itemTitleAlign == null ? null : itemTitleAlign.getValue());
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is false, the default
     * alignment of  titles for the {@link com.smartgwt.client.widgets.form.fields.DateItem#getDaySelector day}, {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getMonthSelector month}  and {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getYearSelector year} selectors, within their cells.
     *
     * @return Current itemTitleAlign value. Default value is "center"
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_form_titles" target="examples">Titles Example</a>
     */
    public Alignment getItemTitleAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("itemTitleAlign"));
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is false, the default
     * orientation of  titles for the {@link com.smartgwt.client.widgets.form.fields.DateItem#getDaySelector day}, {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getMonthSelector month}  and {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getYearSelector year} selectors. {@link
     * com.smartgwt.client.types.TitleOrientation} lists valid options. <P> Note that titles on the left or right take up a
     * cell in tabular {@link com.smartgwt.client.docs.FormLayout form layouts}, but titles on top do not.
     *
     * @param itemTitleOrientation New itemTitleOrientation value. Default value is "top"
     * @return {@link com.smartgwt.client.widgets.form.fields.DateItem DateItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_form_titles" target="examples">Titles Example</a>
     */
    public DateItem setItemTitleOrientation(TitleOrientation itemTitleOrientation) {
        return (DateItem)setAttribute("itemTitleOrientation", itemTitleOrientation == null ? null : itemTitleOrientation.getValue());
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is false, the default
     * orientation of  titles for the {@link com.smartgwt.client.widgets.form.fields.DateItem#getDaySelector day}, {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getMonthSelector month}  and {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getYearSelector year} selectors. {@link
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
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} and {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getUseMask useMask} are both <code>true</code> this value is the
     * separator between date components. If unset  {@link com.smartgwt.client.util.DateUtil#getDefaultDateSeparator
     * DateUtil.getDefaultDateSeparator()} will be used.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param maskDateSeparator New maskDateSeparator value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.DateItem DateItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public DateItem setMaskDateSeparator(String maskDateSeparator) {
        return (DateItem)setAttribute("maskDateSeparator", maskDateSeparator);
    }
    

    /**
     * {@link com.smartgwt.client.widgets.form.fields.SelectItem} for picking a month. <P> To control which selectors are
     * visible and in what order, use {@link com.smartgwt.client.widgets.form.fields.DateItem#getSelectorFormat
     * selectorFormat}.
     * <p>
     * This component is an AutoChild named "monthSelector".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current monthSelector value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.DateItem#getSelectorFormat
     */
    public SelectItem getMonthSelector()  {
        return SelectItem.getOrCreateRef(getAttributeAsJavaScriptObject("monthSelector"));
    }
    

    /**
     * Custom properties to apply to this dateItem's generated {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getMonthSelector monthSelector}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param monthSelectorProperties New monthSelectorProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.DateItem DateItem} instance, for chaining setter calls
     */
    public DateItem setMonthSelectorProperties(SelectItem monthSelectorProperties) {
        if (monthSelectorProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(DateItem.class, "setMonthSelectorProperties", "SelectItem");
        }                                                                       
        monthSelectorProperties.setConfigOnly(true);
        return (DateItem)setAttribute("monthSelectorProperties", monthSelectorProperties == null ? null : monthSelectorProperties.getEditorTypeConfig());
    }

    /**
     * Custom properties to apply to this dateItem's generated {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getMonthSelector monthSelector}.
     *
     * @return Current monthSelectorProperties value. Default value is null
     */
    public SelectItem getMonthSelectorProperties()  {
        return SelectItem.getOrCreateRef(getAttributeAsJavaScriptObject("monthSelectorProperties"));
    }
    
    

    /**
     * Defaults for the {@link com.smartgwt.client.widgets.DateChooser} created by this form item. The picker for a particular
     * item may be further customized via {@link com.smartgwt.client.widgets.form.fields.DateItem#getPickerProperties
     * pickerProperties}. <P> By default the following DateChooser properties are set: <ul><li>border:"1px solid black"</li>   
     * <li>showCancelButton:true</li>     <li>autoHide:true</li>     <li>closeOnEscapeKeypress:true</li> </ul> These may be
     * modified or overridden by the loaded skin. Note that as with any defaults block, modifications should be made using the
     * the   Class.changeDefaults() to apply changes on top of existing settings.
     *
     * @param pickerDefaults New pickerDefaults value. Default value is {...}
     * @return {@link com.smartgwt.client.widgets.form.fields.DateItem DateItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public DateItem setPickerDefaults(DateChooser pickerDefaults) {
        if (pickerDefaults != null) {
            if (pickerDefaults.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(DateItem.class, "setPickerDefaults", "DateChooser");
            }                                                                       
            pickerDefaults.setConfigOnly(true);
        }
        JavaScriptObject config = pickerDefaults == null ? null : pickerDefaults.getConfig();
        return (DateItem)setAttribute("pickerDefaults", JSOHelper.cleanProperties(config, true));
    }

    /**
     * Defaults for the {@link com.smartgwt.client.widgets.DateChooser} created by this form item. The picker for a particular
     * item may be further customized via {@link com.smartgwt.client.widgets.form.fields.DateItem#getPickerProperties
     * pickerProperties}. <P> By default the following DateChooser properties are set: <ul><li>border:"1px solid black"</li>   
     * <li>showCancelButton:true</li>     <li>autoHide:true</li>     <li>closeOnEscapeKeypress:true</li> </ul> These may be
     * modified or overridden by the loaded skin. Note that as with any defaults block, modifications should be made using the
     * the   Class.changeDefaults() to apply changes on top of existing settings.
     *
     * @return Current pickerDefaults value. Default value is {...}
     */
    public DateChooser getPickerDefaults()  {
        DateChooser properties = new DateChooser();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("pickerDefaults"));
        return properties;
    }
    

    /**
     * Prompt to show when the user hovers the mouse over the picker icon for this DateItem. May be overridden for localization
     * of your application.
     *
     * @param pickerIconPrompt New pickerIconPrompt value. Default value is "Show Date Chooser"
     * @return {@link com.smartgwt.client.widgets.form.fields.DateItem DateItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public DateItem setPickerIconPrompt(String pickerIconPrompt) {
        return (DateItem)setAttribute("pickerIconPrompt", pickerIconPrompt);
    }

    /**
     * Prompt to show when the user hovers the mouse over the picker icon for this DateItem. May be overridden for localization
     * of your application.
     *
     * @return Current pickerIconPrompt value. Default value is "Show Date Chooser"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getPickerIconPrompt()  {
        return getAttributeAsString("pickerIconPrompt");
    }
    

    /**
     * Properties for the {@link com.smartgwt.client.widgets.DateChooser} created by this form item. If specified these will be
     * applied on top of the {@link com.smartgwt.client.widgets.form.fields.DateItem#getPickerDefaults pickerDefaults}
     *
     * @param pickerProperties New pickerProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.DateItem DateItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public DateItem setPickerProperties(DateChooser pickerProperties) {
        if (pickerProperties != null) {
            if (pickerProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(DateItem.class, "setPickerProperties", "DateChooser");
            }                                                                       
            pickerProperties.setConfigOnly(true);
        }
        JavaScriptObject config = pickerProperties == null ? null : pickerProperties.getConfig();
        return (DateItem)setAttribute("pickerProperties", JSOHelper.cleanProperties(config, true));
    }

    /**
     * Properties for the {@link com.smartgwt.client.widgets.DateChooser} created by this form item. If specified these will be
     * applied on top of the {@link com.smartgwt.client.widgets.form.fields.DateItem#getPickerDefaults pickerDefaults}
     *
     * @return Current pickerProperties value. Default value is null
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
     * @param pickerTimeItemProperties New pickerTimeItemProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.DateItem DateItem} instance, for chaining setter calls
     */
    public DateItem setPickerTimeItemProperties(TimeItem pickerTimeItemProperties) {
        if (pickerTimeItemProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(DateItem.class, "setPickerTimeItemProperties", "TimeItem");
        }                                                                       
        pickerTimeItemProperties.setConfigOnly(true);
        return (DateItem)setAttribute("pickerTimeItemProperties", pickerTimeItemProperties == null ? null : pickerTimeItemProperties.getEditorTypeConfig());
    }

    /**
     * A set of properties to apply to the {@link com.smartgwt.client.widgets.form.fields.TimeItem} displayed in the picker
     * when {@link com.smartgwt.client.widgets.form.fields.DateItem#getShowPickerTimeItem showPickerTimeItem} is true. <P> Has
     * no effect for fields of type <code>"date"</code>.
     *
     * @return Current pickerTimeItemProperties value. Default value is null
     */
    public TimeItem getPickerTimeItemProperties()  {
        return TimeItem.getOrCreateRef(getAttributeAsJavaScriptObject("pickerTimeItemProperties"));
    }
    

    /**
     * If showing date selectors rather than the date text field (so when  <code>this.useTextField</code> is false), this
     * property allows customization of the  order of the day, month and year selector fields.  If unset, these fields will
     * match the specified {@link com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat inputFormat} for this item,
     * but note that the attribute default will likely be set by {@link com.smartgwt.client.docs.I18n localization} to a valid
     * {@link com.smartgwt.client.types.DateItemSelectorFormat}. <P> Note: selectors may be omitted entirely by setting
     * selectorFormat to (for example)  <code>"MD"</code>. In this case the value for the omitted selector will match the
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getDefaultValue defaultValue} specified for the item.  For
     * example, if the selector format is "MD" (month and day only), the year comes from the Date specified as the
     * defaultValue.
     *
     * @param selectorFormat New selectorFormat value. Default value is varies
     * @return {@link com.smartgwt.client.widgets.form.fields.DateItem DateItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.DateItem#setDaySelector
     * @see com.smartgwt.client.widgets.form.fields.DateItem#setMonthSelector
     * @see com.smartgwt.client.widgets.form.fields.DateItem#setYearSelector
     */
    public DateItem setSelectorFormat(DateItemSelectorFormat selectorFormat) {
        return (DateItem)setAttribute("selectorFormat", selectorFormat == null ? null : selectorFormat.getValue());
    }

    /**
     * If showing date selectors rather than the date text field (so when  <code>this.useTextField</code> is false), this
     * property allows customization of the  order of the day, month and year selector fields.  If unset, these fields will
     * match the specified {@link com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat inputFormat} for this item,
     * but note that the attribute default will likely be set by {@link com.smartgwt.client.docs.I18n localization} to a valid
     * {@link com.smartgwt.client.types.DateItemSelectorFormat}. <P> Note: selectors may be omitted entirely by setting
     * selectorFormat to (for example)  <code>"MD"</code>. In this case the value for the omitted selector will match the
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getDefaultValue defaultValue} specified for the item.  For
     * example, if the selector format is "MD" (month and day only), the year comes from the Date specified as the
     * defaultValue.
     *
     * @return Current selectorFormat value. Default value is varies
     * @see com.smartgwt.client.widgets.form.fields.DateItem#getDaySelector
     * @see com.smartgwt.client.widgets.form.fields.DateItem#getMonthSelector
     * @see com.smartgwt.client.widgets.form.fields.DateItem#getYearSelector
     */
    public DateItemSelectorFormat getSelectorFormat()  {
        return EnumUtil.getEnum(DateItemSelectorFormat.values(), getAttribute("selectorFormat"));
    }
    

    /**
     * When set to true, show a button that allows the calendar to be navigated by fiscal year.
     *
     * @param showChooserFiscalYearPicker New showChooserFiscalYearPicker value. Default value is false
     * @return {@link com.smartgwt.client.widgets.form.fields.DateItem DateItem} instance, for chaining setter calls
     */
    public DateItem setShowChooserFiscalYearPicker(Boolean showChooserFiscalYearPicker) {
        return (DateItem)setAttribute("showChooserFiscalYearPicker", showChooserFiscalYearPicker);
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
     * When set to true, show a button that allows the calendar to be navigated by week or fiscal week, depending on the value
     * of {@link com.smartgwt.client.widgets.form.fields.DateItem#getShowChooserFiscalYearPicker showChooserFiscalYearPicker}.
     *
     * @param showChooserWeekPicker New showChooserWeekPicker value. Default value is false
     * @return {@link com.smartgwt.client.widgets.form.fields.DateItem DateItem} instance, for chaining setter calls
     */
    public DateItem setShowChooserWeekPicker(Boolean showChooserWeekPicker) {
        return (DateItem)setAttribute("showChooserWeekPicker", showChooserWeekPicker);
    }

    /**
     * When set to true, show a button that allows the calendar to be navigated by week or fiscal week, depending on the value
     * of {@link com.smartgwt.client.widgets.form.fields.DateItem#getShowChooserFiscalYearPicker showChooserFiscalYearPicker}.
     *
     * @return Current showChooserWeekPicker value. Default value is false
     */
    public Boolean getShowChooserWeekPicker()  {
        Boolean result = getAttributeAsBoolean("showChooserWeekPicker", true);
        return result == null ? false : result;
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is true and a {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getHint hint} is set, should the hint be shown within the field? <p>
     * Note that when using a native HTML5 date input (see {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getBrowserInputType browserInputType}), in-field hints are currently
     * supported, but future browser changes might not allow in-field hints to be supported. Therefore, it is safest to
     * <em>not</em> use in-field hints in conjunction with a native HTML5 date input. <p> To change this attribute after being
     * drawn, it is necessary to call {@link com.smartgwt.client.widgets.form.fields.FormItem#redraw FormItem.redraw()} or
     * redraw the form.
     *
     * @param showHintInField New showHintInField value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.DateItem DateItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setHint
     * @see com.smartgwt.client.widgets.form.fields.DateItem#setUsePlaceholderForHint
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public DateItem setShowHintInField(Boolean showHintInField) {
        return (DateItem)setAttribute("showHintInField", showHintInField);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is true and a {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getHint hint} is set, should the hint be shown within the field? <p>
     * Note that when using a native HTML5 date input (see {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getBrowserInputType browserInputType}), in-field hints are currently
     * supported, but future browser changes might not allow in-field hints to be supported. Therefore, it is safest to
     * <em>not</em> use in-field hints in conjunction with a native HTML5 date input. <p> To change this attribute after being
     * drawn, it is necessary to call {@link com.smartgwt.client.widgets.form.fields.FormItem#redraw FormItem.redraw()} or
     * redraw the form.
     *
     * @return Current showHintInField value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getHint
     * @see com.smartgwt.client.widgets.form.fields.DateItem#getUsePlaceholderForHint
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowHintInField()  {
        return getAttributeAsBoolean("showHintInField", true);
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is false, whether titles
     * should be shown for for child-items in this DateItem.  By default, <code>showItemTitles</code> is false.
     *
     * @param showItemTitles New showItemTitles value. Default value is false
     * @return {@link com.smartgwt.client.widgets.form.fields.DateItem DateItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_form_titles" target="examples">Titles Example</a>
     */
    public DateItem setShowItemTitles(Boolean showItemTitles) {
        return (DateItem)setAttribute("showItemTitles", showItemTitles);
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is false, whether titles
     * should be shown for for child-items in this DateItem.  By default, <code>showItemTitles</code> is false.
     *
     * @return Current showItemTitles value. Default value is false
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_form_titles" target="examples">Titles Example</a>
     */
    public Boolean getShowItemTitles()  {
        Boolean result = getAttributeAsBoolean("showItemTitles", true);
        return result == null ? false : result;
    }
    

    /**
     * If this field is of type <code>"datetime"</code>, when showing the {@link com.smartgwt.client.widgets.DateChooser},
     * should the {@link com.smartgwt.client.widgets.DateChooser#getShowTimeItem time field} be displayed? <P> Has no effect
     * for fields of type <code>"date"</code>. <p> This attribute does not have an effect if a native HTML5 date input is being
     * used. See {@link com.smartgwt.client.widgets.form.fields.DateItem#getBrowserInputType browserInputType}.
     *
     * @param showPickerTimeItem New showPickerTimeItem value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.DateItem DateItem} instance, for chaining setter calls
     */
    public DateItem setShowPickerTimeItem(Boolean showPickerTimeItem) {
        return (DateItem)setAttribute("showPickerTimeItem", showPickerTimeItem);
    }

    /**
     * If this field is of type <code>"datetime"</code>, when showing the {@link com.smartgwt.client.widgets.DateChooser},
     * should the {@link com.smartgwt.client.widgets.DateChooser#getShowTimeItem time field} be displayed? <P> Has no effect
     * for fields of type <code>"date"</code>. <p> This attribute does not have an effect if a native HTML5 date input is being
     * used. See {@link com.smartgwt.client.widgets.form.fields.DateItem#getBrowserInputType browserInputType}.
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
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.form.fields.DateItem#getStartDate startDate}. <P> <b>Note:</b> A {@link com.smartgwt.client.util.DateUtil#createLogicalDate LogicalDate} is expected.
     *
     * @param startDate the new startDate. Default value is See below
     * @return {@link com.smartgwt.client.widgets.form.fields.DateItem DateItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public DateItem setStartDate(Date startDate) {
        return (DateItem)setAttribute("startDate", startDate);
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
     * @return Current startDate value. Default value is See below
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
     * @param textAlign New textAlign value. Default value is varies
     * @return {@link com.smartgwt.client.widgets.form.fields.DateItem DateItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public DateItem setTextAlign(Alignment textAlign) {
        return (DateItem)setAttribute("textAlign", textAlign == null ? null : textAlign.getValue());
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is <code>true</code> this
     * property governs the alignment of text within the text field. Defaults to <code>"right"</code> by default or
     * <code>"left"</code> if the page is in {@link com.smartgwt.client.util.Page#isRTL rtl mode}. <p> This attribute does not
     * have an effect if a native HTML5 date input is being used. See {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getBrowserInputType browserInputType}.
     *
     * @return Current textAlign value. Default value is varies
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Alignment getTextAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("textAlign"));
    }
    

    /**
     * Text field to hold the entire date in "type in" format, if  {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is true.
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
     * Custom properties to apply to this dateItem's generated {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getTextField textField}. Only applies if {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is true.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param textFieldProperties New textFieldProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.DateItem DateItem} instance, for chaining setter calls
     */
    public DateItem setTextFieldProperties(TextItem textFieldProperties) {
        if (textFieldProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(DateItem.class, "setTextFieldProperties", "TextItem");
        }                                                                       
        textFieldProperties.setConfigOnly(true);
        return (DateItem)setAttribute("textFieldProperties", textFieldProperties == null ? null : textFieldProperties.getEditorTypeConfig());
    }

    /**
     * Custom properties to apply to this dateItem's generated {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getTextField textField}. Only applies if {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is true.
     *
     * @return Current textFieldProperties value. Default value is null
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
     * @param use24HourTime New use24HourTime value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.DateItem DateItem} instance, for chaining setter calls
     */
    public DateItem setUse24HourTime(Boolean use24HourTime) {
        return (DateItem)setAttribute("use24HourTime", use24HourTime);
    }

    /**
     * When showing the {@link com.smartgwt.client.widgets.DateChooser} and the field is of type "datetime", whether the {@link
     * com.smartgwt.client.widgets.DateChooser#getShowTimeItem time field} should be set to use 24-hour time.  The  default is
     * true. <P> Has no effect if {@link com.smartgwt.client.widgets.form.fields.DateItem#getShowPickerTimeItem
     * showPickerTimeItem} is explicitly set to <code>false</code>.
     *
     * @return Current use24HourTime value. Default value is true
     */
    public Boolean getUse24HourTime()  {
        Boolean result = getAttributeAsBoolean("use24HourTime", true);
        return result == null ? true : result;
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
     * @param useMask New useMask value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.DateItem DateItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.DateItem#setMaskDateSeparator
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public DateItem setUseMask(Boolean useMask) {
        return (DateItem)setAttribute("useMask", useMask);
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getShowHintInField showing the hint in field} and if
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
     * @return {@link com.smartgwt.client.widgets.form.fields.DateItem DateItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setHint
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public DateItem setUsePlaceholderForHint(boolean usePlaceholderForHint) {
        return (DateItem)setAttribute("usePlaceholderForHint", usePlaceholderForHint);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getShowHintInField showing the hint in field} and if
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
     * When set to true (the default), use a single shared date-picker across all widgets that use one.  When false, create a
     * new picker using the autoChild system.  See  {@link com.smartgwt.client.widgets.form.fields.DateItem#getPickerDefaults
     * picker} and  {@link com.smartgwt.client.widgets.form.fields.DateItem#getPickerProperties pickerProperties} for details
     * on setting up an unshared picker.
     *
     * @param useSharedPicker New useSharedPicker value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.DateItem DateItem} instance, for chaining setter calls
     */
    public DateItem setUseSharedPicker(Boolean useSharedPicker) {
        return (DateItem)setAttribute("useSharedPicker", useSharedPicker);
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
     * When set to true, the item uses a {@link com.smartgwt.client.widgets.form.fields.DateItem#getTextField single text
     * field} for  working with the item's value. <P> When false or unset, the default, the item's value is represented by
     * separate  {@link com.smartgwt.client.widgets.form.fields.DateItem#getDaySelector day}, {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getMonthSelector month},  and/or {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getYearSelector year} selectors.  In this mode, null values are not
     * supported, and a default value of Today will be enforced if no  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDefaultValue defaultValue} is specified.  This means that a DateItem
     * with <code>useTextField</code> set to false is effectively a  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getRequired required} field.
     *
     * @param useTextField New useTextField value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.DateItem DateItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_datatypes_date" target="examples">Date Example</a>
     */
    public DateItem setUseTextField(Boolean useTextField) {
        return (DateItem)setAttribute("useTextField", useTextField);
    }

    /**
     * When set to true, the item uses a {@link com.smartgwt.client.widgets.form.fields.DateItem#getTextField single text
     * field} for  working with the item's value. <P> When false or unset, the default, the item's value is represented by
     * separate  {@link com.smartgwt.client.widgets.form.fields.DateItem#getDaySelector day}, {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getMonthSelector month},  and/or {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getYearSelector year} selectors.  In this mode, null values are not
     * supported, and a default value of Today will be enforced if no  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDefaultValue defaultValue} is specified.  This means that a DateItem
     * with <code>useTextField</code> set to false is effectively a  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getRequired required} field.
     *
     * @return Current useTextField value. Default value is null
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_datatypes_date" target="examples">Date Example</a>
     */
    public Boolean getUseTextField()  {
        return getAttributeAsBoolean("useTextField", true);
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
     * @return {@link com.smartgwt.client.widgets.form.fields.DateItem DateItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setMinHintWidth
     */
    public DateItem setWrapHintText(Boolean wrapHintText) {
        return (DateItem)setAttribute("wrapHintText", wrapHintText);
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
    

    /**
     * {@link com.smartgwt.client.widgets.form.fields.SelectItem} for picking a year. <P> To control which selectors are
     * visible and in what order, use {@link com.smartgwt.client.widgets.form.fields.DateItem#getSelectorFormat
     * selectorFormat}.
     * <p>
     * This component is an AutoChild named "yearSelector".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current yearSelector value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.DateItem#getSelectorFormat
     */
    public SelectItem getYearSelector()  {
        return SelectItem.getOrCreateRef(getAttributeAsJavaScriptObject("yearSelector"));
    }
    

    /**
     * Custom properties to apply to this dateItem's generated {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getYearSelector yearSelector}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param yearSelectorProperties New yearSelectorProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.DateItem DateItem} instance, for chaining setter calls
     */
    public DateItem setYearSelectorProperties(SelectItem yearSelectorProperties) {
        if (yearSelectorProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(DateItem.class, "setYearSelectorProperties", "SelectItem");
        }                                                                       
        yearSelectorProperties.setConfigOnly(true);
        return (DateItem)setAttribute("yearSelectorProperties", yearSelectorProperties == null ? null : yearSelectorProperties.getEditorTypeConfig());
    }

    /**
     * Custom properties to apply to this dateItem's generated {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getYearSelector yearSelector}.
     *
     * @return Current yearSelectorProperties value. Default value is null
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
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
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
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.getFiscalCalendar();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.FiscalCalendar::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Notification method called when {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPending showPending} is
     * enabled and this date item should either clear or show its pending visual state. <p> The default behavior is that the
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getTitleStyle titleStyle} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCellStyle cellStyle} are updated to include/exclude the "Pending"
     * suffix. In addition, when displayed in the pending state: <ul> <li>If {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is <code>true</code>, then the "Pending" 
     * suffix will be appended to the {@link com.smartgwt.client.widgets.form.fields.FormItem#getTextBoxStyle textBoxStyle}
     * applied to the     {@link com.smartgwt.client.widgets.form.fields.DateItem#getTextField textField}; otherwise
     * <li>(<code>useTextField</code> is <code>false</code>) the color of the     {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getDaySelector daySelector}, {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getMonthSelector monthSelector}     and/or {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getYearSelector yearSelector} will change when the day, month, or year 
     *    is different, respectively. </ul> Returning <code>false</code> will cancel this default behavior.
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
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(DateItem dateItemProperties) /*-{
        if (dateItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(DateItem.@java.lang.Object::getClass()(), "setDefaultProperties", dateItemProperties.@java.lang.Object::getClass()());
        }
        dateItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var properties = dateItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::getConfig()();
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
        return selection == null ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)(selection);
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
