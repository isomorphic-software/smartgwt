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
 * Provides a compact interface for editing a date range, by providing a formatted, read-only display of the current
 * selected date range with an icon to launch a {@link com.smartgwt.client.widgets.DateRangeDialog}  to edit the range.
 */
@BeanFactory.FrameworkClass
public class MiniDateRangeItem extends StaticTextItem {

    public static MiniDateRangeItem getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof MiniDateRangeItem) {
            existingObj.setJsObj(jsObj);
            return (MiniDateRangeItem)existingObj;
        } else

        {
            return new MiniDateRangeItem(jsObj);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(MiniDateRangeItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.MiniDateRangeItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(MiniDateRangeItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.MiniDateRangeItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public static native void changePickerIconDefaults(FormItemIcon defaults) /*-{
        $wnd.isc.MiniDateRangeItem.changeDefaults("pickerIconDefaults", defaults.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public MiniDateRangeItem(){
        setAttribute("editorType", "MiniDateRangeItem");
    }

    public MiniDateRangeItem(JavaScriptObject jsObj){
        super(jsObj);
    }


    public MiniDateRangeItem(String name) {
        setName(name);
                setAttribute("editorType", "MiniDateRangeItem");
    }


    public MiniDateRangeItem(String name, String title) {
        setName(name);
		setTitle(title);
                setAttribute("editorType", "MiniDateRangeItem");
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Whether the {@link com.smartgwt.client.widgets.DateRangeDialog} opened when the  {@link
     * com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#getPickerIcon pickerIcon} is clicked should display  {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem}s or {@link com.smartgwt.client.widgets.form.fields.DateItem}s.
     *
     * @param allowRelativeDates New allowRelativeDates value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.MiniDateRangeItem MiniDateRangeItem} instance, for chaining setter calls
     */
    public MiniDateRangeItem setAllowRelativeDates(Boolean allowRelativeDates) {
        return (MiniDateRangeItem)setAttribute("allowRelativeDates", allowRelativeDates);
    }

    /**
     * Whether the {@link com.smartgwt.client.widgets.DateRangeDialog} opened when the  {@link
     * com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#getPickerIcon pickerIcon} is clicked should display  {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem}s or {@link com.smartgwt.client.widgets.form.fields.DateItem}s.
     *
     * @return Current allowRelativeDates value. Default value is true
     */
    public Boolean getAllowRelativeDates()  {
        Boolean result = getAttributeAsBoolean("allowRelativeDates", true);
        return result == null ? true : result;
    }
    

    /**
     * If this attribute is set to true, the pop up date range dialog will automatically validate the user-entered <i>"to"</i>
     * and <i>"from"</i> values on  <code>"OK"</code>-click, and refuse to dismiss if these items contain invalid values.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#getAutoValidate autoValidate}
     *
     * @param autoValidate New auto-validate setting. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.MiniDateRangeItem MiniDateRangeItem} instance, for chaining setter calls
     */
    public MiniDateRangeItem setAutoValidate(Boolean autoValidate) {
        return (MiniDateRangeItem)setAttribute("autoValidate", autoValidate);
    }

    /**
     * If this attribute is set to true, the pop up date range dialog will automatically validate the user-entered <i>"to"</i>
     * and <i>"from"</i> values on  <code>"OK"</code>-click, and refuse to dismiss if these items contain invalid values.
     *
     * @return Current autoValidate value. Default value is true
     */
    public Boolean getAutoValidate()  {
        Boolean result = getAttributeAsBoolean("autoValidate", true);
        return result == null ? true : result;
    }
    

    /**
     * MiniDateRangeItems are marked as canFocus:true, and set up with properties such that focus will always go to the icon to
     * launch the dateRange dialog. Set canFocus to false to  suppress this behavior.
     *
     * @param canFocus New canFocus value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.MiniDateRangeItem MiniDateRangeItem} instance, for chaining setter calls
     */
    public MiniDateRangeItem setCanFocus(Boolean canFocus) {
        return (MiniDateRangeItem)setAttribute("canFocus", canFocus);
    }

    /**
     * MiniDateRangeItems are marked as canFocus:true, and set up with properties such that focus will always go to the icon to
     * launch the dateRange dialog. Set canFocus to false to  suppress this behavior.
     *
     * @return Current canFocus value. Default value is true
     */
    public Boolean getCanFocus()  {
        Boolean result = getAttributeAsBoolean("canFocus", true);
        return result == null ? true : result;
    }
    

    /**
     * MiniDateRangeItems rely on their icon being able to receive focus for normal user interaction as they have no other
     * focusable element. <code>canTabToIcons</code> is overridden to achieve this even if the property has been set to
     * <code>false</code> at the {@link com.smartgwt.client.widgets.form.DynamicForm#getCanTabToIcons form level}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canTabToIcons New canTabToIcons value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.MiniDateRangeItem MiniDateRangeItem} instance, for chaining setter calls
     */
    public MiniDateRangeItem setCanTabToIcons(Boolean canTabToIcons) {
        return (MiniDateRangeItem)setAttribute("canTabToIcons", canTabToIcons);
    }

    /**
     * MiniDateRangeItems rely on their icon being able to receive focus for normal user interaction as they have no other
     * focusable element. <code>canTabToIcons</code> is overridden to achieve this even if the property has been set to
     * <code>false</code> at the {@link com.smartgwt.client.widgets.form.DynamicForm#getCanTabToIcons form level}.
     *
     * @return Current canTabToIcons value. Default value is true
     */
    public Boolean getCanTabToIcons()  {
        Boolean result = getAttributeAsBoolean("canTabToIcons", true);
        return result == null ? true : result;
    }
    

    /**
     * Format for displaying dates to the user.   <P> If this attribute is unset, the display value is formatted intelligently
     * according to the dates involved.  For example, if both dates appear in the same month, the value will be  formatted as 
     * <P><code>Month date1 - date2, Year</code>  <P>and, if in different months of the same year,  <P><code>Month1 date1 -
     * Month2 date2, Year</code>. <P>If either date-value is unset, the display-value is formatted according to  {@link
     * com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#getFromDateOnlyPrefix fromDateOnlyPrefix} and  {@link
     * com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#getToDateOnlyPrefix toDateOnlyPrefix}.
     *
     * @param dateDisplayFormat New dateDisplayFormat value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.MiniDateRangeItem MiniDateRangeItem} instance, for chaining setter calls
     */
    public MiniDateRangeItem setDateDisplayFormat(DateDisplayFormat dateDisplayFormat) {
        return (MiniDateRangeItem)setAttribute("dateDisplayFormat", dateDisplayFormat == null ? null : dateDisplayFormat.getValue());
    }

    /**
     * Format for displaying dates to the user.   <P> If this attribute is unset, the display value is formatted intelligently
     * according to the dates involved.  For example, if both dates appear in the same month, the value will be  formatted as 
     * <P><code>Month date1 - date2, Year</code>  <P>and, if in different months of the same year,  <P><code>Month1 date1 -
     * Month2 date2, Year</code>. <P>If either date-value is unset, the display-value is formatted according to  {@link
     * com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#getFromDateOnlyPrefix fromDateOnlyPrefix} and  {@link
     * com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#getToDateOnlyPrefix toDateOnlyPrefix}.
     *
     * @return Current dateDisplayFormat value. Default value is null
     */
    public DateDisplayFormat getDateDisplayFormat()  {
        return EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("dateDisplayFormat"));
    }
    
    

    /**
     * The text to prepend to the formatted date when only a {@link
     * com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#getFromDate fromDate} is supplied.
     *
     * @param fromDateOnlyPrefix New fromDateOnlyPrefix value. Default value is "Since"
     * @return {@link com.smartgwt.client.widgets.form.fields.MiniDateRangeItem MiniDateRangeItem} instance, for chaining setter calls
     */
    public MiniDateRangeItem setFromDateOnlyPrefix(String fromDateOnlyPrefix) {
        return (MiniDateRangeItem)setAttribute("fromDateOnlyPrefix", fromDateOnlyPrefix);
    }

    /**
     * The text to prepend to the formatted date when only a {@link
     * com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#getFromDate fromDate} is supplied.
     *
     * @return Current fromDateOnlyPrefix value. Default value is "Since"
     */
    public String getFromDateOnlyPrefix()  {
        return getAttributeAsString("fromDateOnlyPrefix");
    }
    

    /**
     * Icon that launches a {@link com.smartgwt.client.widgets.DateChooser} for choosing an absolute date.
     *
     * @param pickerIcon New pickerIcon value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.MiniDateRangeItem MiniDateRangeItem} instance, for chaining setter calls
     */
    public MiniDateRangeItem setPickerIcon(FormItemIcon pickerIcon) {
        return (MiniDateRangeItem)setAttribute("pickerIcon", pickerIcon == null ? null : pickerIcon.getJsObj());
    }

    /**
     * Icon that launches a {@link com.smartgwt.client.widgets.DateChooser} for choosing an absolute date.
     *
     * @return Current pickerIcon value. Default value is null
     */
    public FormItemIcon getPickerIcon()  {
        return new FormItemIcon(getAttributeAsJavaScriptObject("pickerIcon"));
    }
    

    /**
     * The prompt to show when the mouse is hovered over the {@link
     * com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#getPickerIcon pickerIcon}.
     *
     * @param pickerIconPrompt New pickerIconPrompt value. Default value is "Show Date Chooser"
     * @return {@link com.smartgwt.client.widgets.form.fields.MiniDateRangeItem MiniDateRangeItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public MiniDateRangeItem setPickerIconPrompt(String pickerIconPrompt) {
        return (MiniDateRangeItem)setAttribute("pickerIconPrompt", pickerIconPrompt);
    }

    /**
     * The prompt to show when the mouse is hovered over the {@link
     * com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#getPickerIcon pickerIcon}.
     *
     * @return Current pickerIconPrompt value. Default value is "Show Date Chooser"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getPickerIconPrompt()  {
        return getAttributeAsString("pickerIconPrompt");
    }
    

    /**
     * Pop-up {@link com.smartgwt.client.widgets.DateRangeDialog} for entering a date range.
     * <p>
     * This component is an AutoChild named "rangeDialog".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current rangeDialog value. Default value is null
     */
    public DateRangeDialog getRangeDialog()  {
        return (DateRangeDialog)DateRangeDialog.getByJSObject(getAttributeAsJavaScriptObject("rangeDialog"));
    }
    

    /**
     * Allow miniDateRangeItems' values to show up in the form's values array, or if  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria DynamicForm.getValuesAsCriteria()} is called, for the
     * criterion to be included in the returned AdvancedCriteria object
     *
     * @param shouldSaveValue New shouldSaveValue value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.MiniDateRangeItem MiniDateRangeItem} instance, for chaining setter calls
     */
    public MiniDateRangeItem setShouldSaveValue(Boolean shouldSaveValue) {
        return (MiniDateRangeItem)setAttribute("shouldSaveValue", shouldSaveValue);
    }

    /**
     * Allow miniDateRangeItems' values to show up in the form's values array, or if  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria DynamicForm.getValuesAsCriteria()} is called, for the
     * criterion to be included in the returned AdvancedCriteria object
     *
     * @return Current shouldSaveValue value. Default value is true
     */
    public Boolean getShouldSaveValue()  {
        Boolean result = getAttributeAsBoolean("shouldSaveValue", true);
        return result == null ? true : result;
    }
    

    /**
     * Base CSS class name for a form item's text box element. <p> See {@link com.smartgwt.client.docs.FormItemStyling} for an
     * overview of formItem styling, and  the {@link com.smartgwt.client.docs.CompoundFormItem_skinning} discussion for special
     * skinning considerations. <p> If the <code>textBoxStyle</code> is changed at runtime, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#updateState updateState()} must be called to update the visual state of
     * this item.
     *
     * @param textBoxStyle New textBoxStyle value. Default value is "textItem"
     * @return {@link com.smartgwt.client.widgets.form.fields.MiniDateRangeItem MiniDateRangeItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setCellStyle
     * @see com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle 
     * @see com.smartgwt.client.docs.FormItemStyling FormItemStyling overview and related methods
     */
    public MiniDateRangeItem setTextBoxStyle(String textBoxStyle) {
        return (MiniDateRangeItem)setAttribute("textBoxStyle", textBoxStyle);
    }

    /**
     * Base CSS class name for a form item's text box element. <p> See {@link com.smartgwt.client.docs.FormItemStyling} for an
     * overview of formItem styling, and  the {@link com.smartgwt.client.docs.CompoundFormItem_skinning} discussion for special
     * skinning considerations. <p> If the <code>textBoxStyle</code> is changed at runtime, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#updateState updateState()} must be called to update the visual state of
     * this item.
     *
     * @return Current textBoxStyle value. Default value is "textItem"
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getCellStyle
     * @see com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle 
     * @see com.smartgwt.client.docs.FormItemStyling FormItemStyling overview and related methods
     */
    public String getTextBoxStyle()  {
        return getAttributeAsString("textBoxStyle");
    }
    
    

    /**
     * The text to prepend to the formatted date when only a {@link
     * com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#getToDate toDate} is supplied.
     *
     * @param toDateOnlyPrefix New toDateOnlyPrefix value. Default value is "Before"
     * @return {@link com.smartgwt.client.widgets.form.fields.MiniDateRangeItem MiniDateRangeItem} instance, for chaining setter calls
     */
    public MiniDateRangeItem setToDateOnlyPrefix(String toDateOnlyPrefix) {
        return (MiniDateRangeItem)setAttribute("toDateOnlyPrefix", toDateOnlyPrefix);
    }

    /**
     * The text to prepend to the formatted date when only a {@link
     * com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#getToDate toDate} is supplied.
     *
     * @return Current toDateOnlyPrefix value. Default value is "Before"
     */
    public String getToDateOnlyPrefix()  {
        return getAttributeAsString("toDateOnlyPrefix");
    }
    

    // ********************* Methods ***********************
	/**
     * Overridden to return true: dateRangeItems always generate AdvancedCriteria.
     *
     * @return true
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public native Boolean hasAdvancedCriteria() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.hasAdvancedCriteria();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
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
     * @param miniDateRangeItemProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(MiniDateRangeItem miniDateRangeItemProperties) /*-{
        if (miniDateRangeItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(MiniDateRangeItem.@java.lang.Object::getClass()(), "setDefaultProperties", miniDateRangeItemProperties.@java.lang.Object::getClass()());
        }
        miniDateRangeItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var properties = miniDateRangeItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::getConfig()();
        $wnd.isc.MiniDateRangeItem.addProperties(properties);
    }-*/;

    // ***********************************************************


    /**
     * Initial value for the "from" date.
     * Sets the {@link DateRangeItem#getFromDate fromDate} for this DateRangeItem.
     *
     * @param fromDate the date from which this item should start it's range. Default value is today
     */
    public void setFromDate(java.util.Date fromDate) {
        setAttribute("fromDate", fromDate);
    }

    /**
     * Initial value for the "from" date.
     *
     *
     * @return java.util.Date
     */
    public java.util.Date getFromDate()  {
        if(!isCreated()) {
            return getAttributeAsDate("fromDate");
        } else {
            DateRange dateRange = getValue();
            return dateRange == null ? null : dateRange.getStartDate();
        }
    }

    /**
     * Initial value for the "to" date.
     * Sets the {@link DateRangeItem#getToDate toDate} for this DateRangeItem.
     *
     * @param toDate the date at which this item should end it's range. Default value is today
     */
    public void setToDate(java.util.Date toDate) {
        setAttribute("toDate", toDate);
    }

    /**
     * Initial value for the "to" date.
     *
     *
     * @return java.util.Date
     */
    public java.util.Date getToDate()  {
        if(!isCreated()) {
            return getAttributeAsDate("toDate");
        } else {
            DateRange dateRange = getValue();
            return dateRange == null ? null : dateRange.getEndDate();
        }
    }

    /**
     * Retrieves the current value of this dateRangeItem.  The return value is a
     * {@link com.smartgwt.client.data.DateRange} object that excludes start and end values if they aren't set.
     *
     * @return the current value of this item
     */
    public native DateRange getValue() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var valueJS = self.getValue();
        var dateRangeJ = @com.smartgwt.client.widgets.form.fields.DateRangeItem::convertToDateRange(Lcom/google/gwt/core/client/JavaScriptObject;)(valueJS);
        return dateRangeJ;
    }-*/;

    private static native DateRange convertToDateRange(JavaScriptObject valueJS)/*-{
        if(valueJS == null) return null;
        var startJS = valueJS.start;
        var endJS = valueJS.end;

        var dateRangeJ = @com.smartgwt.client.data.DateRange::new()();
        if(startJS == null) {
            //do nothing as null is the default
        } else {
            if($wnd.isc.isA.Date(startJS)) {
                var start = @com.smartgwt.client.util.JSOHelper::toDate(D)(startJS.getTime());
                dateRangeJ.@com.smartgwt.client.data.DateRange::setStartDate(Ljava/util/Date;)(start);
            } else if($wnd.isc.isA.String(startJS)) {
                var start = @com.smartgwt.client.data.RelativeDate::new(Ljava/lang/String;)(startJS);
                dateRangeJ.@com.smartgwt.client.data.DateRange::setRelativeStartDate(Lcom/smartgwt/client/data/RelativeDate;)(start);
            } else if(startJS.value) {
                var start = @com.smartgwt.client.data.RelativeDate::new(Lcom/google/gwt/core/client/JavaScriptObject;)(startJS);
                dateRangeJ.@com.smartgwt.client.data.DateRange::setRelativeStartDate(Lcom/smartgwt/client/data/RelativeDate;)(start);
            }
        }
        if(endJS == null) {
            //do nothing as null is the default
        } else {
            if($wnd.isc.isA.Date(endJS)) {
                var end = @com.smartgwt.client.util.JSOHelper::toDate(D)(endJS.getTime());
                dateRangeJ.@com.smartgwt.client.data.DateRange::setEndDate(Ljava/util/Date;)(end);
            } else if($wnd.isc.isA.String(endJS)) {
                var end = @com.smartgwt.client.data.RelativeDate::new(Ljava/lang/String;)(endJS);
                dateRangeJ.@com.smartgwt.client.data.DateRange::setRelativeEndDate(Lcom/smartgwt/client/data/RelativeDate;)(end);
            } else if(endJS.value) {
                var end = @com.smartgwt.client.data.RelativeDate::new(Lcom/google/gwt/core/client/JavaScriptObject;)(endJS);
                dateRangeJ.@com.smartgwt.client.data.DateRange::setRelativeEndDate(Lcom/smartgwt/client/data/RelativeDate;)(end);
            }
        }
        return dateRangeJ;
    }-*/;

    /**
     * Sets the value for this dateRangeItem.  The value parameter is a  {@link com.smartgwt.client.data.DateRange DateRange} object
     * that optionally includes both start and end values.
     *
     * @param value the new value for this item
     */
    public native void setValue(DateRange value) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var valueJS = value.@com.smartgwt.client.core.JsObject::getJsObj()();
        if(self.setValue) {
            self.setValue(valueJS);
        } else {
            self.defaultValue = valueJS;
        }
    }-*/;

    /**
     * The default <code>getCriterion()</code> implementation returns the Criterion entered in the fields shown in the  {@link
     * com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#getRangeDialog rangeDialog}. <P> If both dates are entered, a
     * Criterion with an "and" {@link com.smartgwt.client.types.OperatorId operator}  and both "greaterOrEqual" and
     * "lessOrEqual" sub-criteria will be returned.  If either date is omitted, only the "greaterOrEqual" (from date) or
     * "lessOrEqual" (to date)  Criterion is returned.
     * @param getter provides a method to get a criterion object based on this field's current edited value(s).
     *
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setCriterionGetter
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public void setCriterionGetter(FormItemCriterionGetter getter) {
        super.setCriterionGetter(getter);
    }

}
