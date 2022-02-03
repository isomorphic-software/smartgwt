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
 * Allows a user to select an absolute or relative range of dates via two {@link
 * com.smartgwt.client.widgets.form.fields.RelativeDateItem}s (if {@link
 * com.smartgwt.client.widgets.form.fields.DateRangeItem#getAllowRelativeDates allowRelativeDates} is true) or two {@link
 * com.smartgwt.client.widgets.form.fields.DateItem DateItems}. <P> The item's {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#getType data type} is expected to be one of "date" or "datetime" and
 * dictates whether the dates in the range include a time portion.  If unset and the item's  form is databound, the data
 * type is detected from the associated  {@link com.smartgwt.client.data.DataSourceField dataSource field}.  If there is no
 * such field, or the form is not  databound, the default data type value is "date". <P> DateRangeItem is just a
 * convenience relative to using two {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem} or {@link
 * com.smartgwt.client.widgets.form.fields.DateItem} controls in a form, then using {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#getOperator FormItem.operator} and {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#getCriteriaField FormItem.criteriaField} to cause them to produce a
 * date range.  If you need more control over layout, validation, event handling or any other aspect of appearance or
 * behavior, stop using DateRangeItem and use two DateItem/RelativeDateItem controls directly instead.
 */
@BeanFactory.FrameworkClass
public class DateRangeItem extends CanvasItem {

    public static DateRangeItem getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof DateRangeItem) {
            existingObj.setJsObj(jsObj);
            return (DateRangeItem)existingObj;
        } else

        {
            return new DateRangeItem(jsObj);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DateRangeItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.DateRangeItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DateRangeItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.DateRangeItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public static native void changePickerIconDefaults(FormItemIcon defaults) /*-{
        $wnd.isc.DateRangeItem.changeDefaults("pickerIconDefaults", defaults.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public DateRangeItem(){
        setAttribute("editorType", "DateRangeItem");
    }

    public DateRangeItem(JavaScriptObject jsObj){
        super(jsObj);
    }


    public DateRangeItem(String name) {
        setName(name);
                setAttribute("editorType", "DateRangeItem");
    }


    public DateRangeItem(String name, String title) {
        setName(name);
		setTitle(title);
                setAttribute("editorType", "DateRangeItem");
    }


    // ********************* Properties / Attributes ***********************

    /**
     * The {@link com.smartgwt.client.widgets.form.fields.FormItem} class to create when {@link
     * com.smartgwt.client.widgets.form.fields.DateRangeItem#getAllowRelativeDates allowRelativeDates} is false, and the {@link
     * com.smartgwt.client.widgets.form.fields.DateRangeItem}'s type is "datetime".
     *
     * @return Current absoluteDateTimeItemConstructor value. Default value is "DateTimeItem"
     * @see com.smartgwt.client.types.FieldType
     */
    public String getAbsoluteDateTimeItemConstructor()  {
        return getAttributeAsString("absoluteDateTimeItemConstructor");
    }
    

    /**
     * The {@link com.smartgwt.client.widgets.form.fields.FormItem} class to create when {@link
     * com.smartgwt.client.widgets.form.fields.DateRangeItem#getAllowRelativeDates allowRelativeDates} is false, but the {@link
     * com.smartgwt.client.widgets.form.fields.DateRangeItem} does not have type "datetime".
     *
     * @return Current absoluteItemConstructor value. Default value is "DateItem"
     * @see com.smartgwt.client.types.FieldType
     */
    public String getAbsoluteItemConstructor()  {
        return getAttributeAsString("absoluteItemConstructor");
    }
    

    /**
     * Whether to allow the user to specify relative dates (via {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem}s) or whether dates are absolute (via {@link
     * com.smartgwt.client.widgets.form.fields.DateItem}s).
     *
     * @param allowRelativeDates New allowRelativeDates value. Default value is false
     * @return {@link com.smartgwt.client.widgets.form.fields.DateRangeItem DateRangeItem} instance, for chaining setter calls
     */
    public DateRangeItem setAllowRelativeDates(Boolean allowRelativeDates) {
        return (DateRangeItem)setAttribute("allowRelativeDates", allowRelativeDates);
    }

    /**
     * Whether to allow the user to specify relative dates (via {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem}s) or whether dates are absolute (via {@link
     * com.smartgwt.client.widgets.form.fields.DateItem}s).
     *
     * @return Current allowRelativeDates value. Default value is false
     */
    public Boolean getAllowRelativeDates()  {
        Boolean result = getAttributeAsBoolean("allowRelativeDates", true);
        return result == null ? false : result;
    }
    
    
    

    /**
     * {@link com.smartgwt.client.widgets.form.DynamicForm} {@link com.smartgwt.client.types.AutoChild} automatically created
     * by the dateRangeItem and applied to the item as {@link com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvas
     * this.canvas}.<P> This DynamicForm contains the "from" and "to" fields the user will interact with to actually select a
     * date-range. Note that as a standard autoChild, developers may customize this form  by modifying
     * <code>dateRangeProperties</code>.
     * <p>
     * This component is an AutoChild named "dateRangeForm".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current dateRangeForm value. Default value is null
     */
    public DynamicForm getDateRangeForm()  {
        return (DynamicForm)DynamicForm.getByJSObject(getAttributeAsJavaScriptObject("dateRangeForm"));
    }
    

    /**
     * Controls the placement of the {@link com.smartgwt.client.widgets.form.fields.DateRangeItem#getToField toField} and
     * {@link com.smartgwt.client.widgets.form.fields.DateRangeItem#getFromField fromField} in the  {@link
     * com.smartgwt.client.widgets.form.fields.DateRangeItem#getDateRangeForm dateRangeForm}. <P> Note that we don't recommend
     * "horizontal" placement for mobile, and we also don't recommend  it for {@link
     * com.smartgwt.client.widgets.form.fields.DateRangeItem#getAllowRelativeDates allowRelativeDates} mode, since {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem} changes width  drastically during editing, which causes a lot
     * of unpleasant side-to-side shifting of  controls.
     *
     * @param fieldLayout New fieldLayout value. Default value is "vertical"
     * @return {@link com.smartgwt.client.widgets.form.fields.DateRangeItem DateRangeItem} instance, for chaining setter calls
     */
    public DateRangeItem setFieldLayout(DateFieldLayout fieldLayout) {
        return (DateRangeItem)setAttribute("fieldLayout", fieldLayout == null ? null : fieldLayout.getValue());
    }

    /**
     * Controls the placement of the {@link com.smartgwt.client.widgets.form.fields.DateRangeItem#getToField toField} and
     * {@link com.smartgwt.client.widgets.form.fields.DateRangeItem#getFromField fromField} in the  {@link
     * com.smartgwt.client.widgets.form.fields.DateRangeItem#getDateRangeForm dateRangeForm}. <P> Note that we don't recommend
     * "horizontal" placement for mobile, and we also don't recommend  it for {@link
     * com.smartgwt.client.widgets.form.fields.DateRangeItem#getAllowRelativeDates allowRelativeDates} mode, since {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem} changes width  drastically during editing, which causes a lot
     * of unpleasant side-to-side shifting of  controls.
     *
     * @return Current fieldLayout value. Default value is "vertical"
     */
    public DateFieldLayout getFieldLayout()  {
        return EnumUtil.getEnum(DateFieldLayout.values(), getAttribute("fieldLayout"));
    }
    

    /**
     * Not applicable to a DateRangeItem.
     *
     * @param formula New formula value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.DateRangeItem DateRangeItem} instance, for chaining setter calls
     */
    public DateRangeItem setFormula(UserFormula formula) {
        return (DateRangeItem)setAttribute("formula", formula == null ? null : formula.getJsObj());
    }

    /**
     * Not applicable to a DateRangeItem.
     *
     * @return Current formula value. Default value is null
     */
    public UserFormula getFormula()  {
        return new UserFormula(getAttributeAsJavaScriptObject("formula"));
    }
    
    

    /**
     * The field for the "from" date - a {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem} or {@link
     * com.smartgwt.client.widgets.form.fields.DateItem} according to {@link
     * com.smartgwt.client.widgets.form.fields.DateRangeItem#getAllowRelativeDates allowRelativeDates}.
     * <p>
     * This component is an AutoChild named "fromField".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current fromField value. Default value is null
     */
    public FormItem getFromField()  {
        return FormItem.getOrCreateRef(getAttributeAsJavaScriptObject("fromField"));
    }
    

    /**
     * The title for the {@link com.smartgwt.client.widgets.form.fields.DateRangeItem#getFromField from} part of the range.
     *
     * @param fromTitle New fromTitle value. Default value is "From"
     * @return {@link com.smartgwt.client.widgets.form.fields.DateRangeItem DateRangeItem} instance, for chaining setter calls
     */
    public DateRangeItem setFromTitle(String fromTitle) {
        return (DateRangeItem)setAttribute("fromTitle", fromTitle);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.form.fields.DateRangeItem#getFromField from} part of the range.
     *
     * @return Current fromTitle value. Default value is "From"
     */
    public String getFromTitle()  {
        return getAttributeAsString("fromTitle");
    }
    

    /**
     * The title orientation for the to / from sub-items. If unset this will be derived from {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTitleOrientation this.titleOrientation} or  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getTitleOrientation this.form.titleOrientation}.
     *
     * @param innerTitleOrientation New innerTitleOrientation value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.DateRangeItem DateRangeItem} instance, for chaining setter calls
     */
    public DateRangeItem setInnerTitleOrientation(TitleOrientation innerTitleOrientation) {
        return (DateRangeItem)setAttribute("innerTitleOrientation", innerTitleOrientation == null ? null : innerTitleOrientation.getValue());
    }

    /**
     * The title orientation for the to / from sub-items. If unset this will be derived from {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTitleOrientation this.titleOrientation} or  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getTitleOrientation this.form.titleOrientation}.
     *
     * @return Current innerTitleOrientation value. Default value is null
     */
    public TitleOrientation getInnerTitleOrientation()  {
        return EnumUtil.getEnum(TitleOrientation.values(), getAttribute("innerTitleOrientation"));
    }
    

    /**
     * For fields of type <code>"date"</code>, if this is an editable field such as a {@link
     * com.smartgwt.client.widgets.form.fields.TextItem}, this property  allows you to specify the {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat inputFormat} applied to the item.
     *
     * @param inputFormat New inputFormat value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.DateRangeItem DateRangeItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setDateFormatter
     * @see com.smartgwt.client.docs.DateInputFormat DateInputFormat 
     */
    public DateRangeItem setInputFormat(String inputFormat) {
        return (DateRangeItem)setAttribute("inputFormat", inputFormat);
    }

    /**
     * For fields of type <code>"date"</code>, if this is an editable field such as a {@link
     * com.smartgwt.client.widgets.form.fields.TextItem}, this property  allows you to specify the {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat inputFormat} applied to the item.
     *
     * @return Current inputFormat value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getDateFormatter
     * @see com.smartgwt.client.docs.DateInputFormat DateInputFormat 
     */
    public String getInputFormat()  {
        return getAttributeAsString("inputFormat");
    }
    

    /**
     * Error message to display if the user enters a date range where the "To" field value is earlier than the "From" field
     * value.
     *
     * @param invalidRangeErrorMessage New invalidRangeErrorMessage value. Default value is "'To' field value cannot be earlier than 'From' field value."
     * @return {@link com.smartgwt.client.widgets.form.fields.DateRangeItem DateRangeItem} instance, for chaining setter calls
     */
    public DateRangeItem setInvalidRangeErrorMessage(String invalidRangeErrorMessage) {
        return (DateRangeItem)setAttribute("invalidRangeErrorMessage", invalidRangeErrorMessage);
    }

    /**
     * Error message to display if the user enters a date range where the "To" field value is earlier than the "From" field
     * value.
     *
     * @return Current invalidRangeErrorMessage value. Default value is "'To' field value cannot be earlier than 'From' field value."
     */
    public String getInvalidRangeErrorMessage()  {
        return getAttributeAsString("invalidRangeErrorMessage");
    }
    

    /**
     * The {@link com.smartgwt.client.widgets.form.fields.FormItem} class to create when {@link
     * com.smartgwt.client.widgets.form.fields.DateRangeItem#getAllowRelativeDates allowRelativeDates} is true.
     *
     * @return Current relativeItemConstructor value. Default value is "RelativeDateItem"
     */
    public String getRelativeItemConstructor()  {
        return getAttributeAsString("relativeItemConstructor");
    }
    

    /**
     * Allow dateRangeItems' values to show up in the form's values array, or if  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria DynamicForm.getValuesAsCriteria()} is called, for the
     * criterion to be included in the returned AdvancedCriteria object
     *
     * @param shouldSaveValue New shouldSaveValue value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.DateRangeItem DateRangeItem} instance, for chaining setter calls
     */
    public DateRangeItem setShouldSaveValue(Boolean shouldSaveValue) {
        return (DateRangeItem)setAttribute("shouldSaveValue", shouldSaveValue);
    }

    /**
     * Allow dateRangeItems' values to show up in the form's values array, or if  {@link
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
     * Not applicable to a DateRangeItem.
     *
     * @param textFormula New textFormula value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.DateRangeItem DateRangeItem} instance, for chaining setter calls
     */
    public DateRangeItem setTextFormula(UserSummary textFormula) {
        return (DateRangeItem)setAttribute("textFormula", textFormula == null ? null : textFormula.getJsObj());
    }

    /**
     * Not applicable to a DateRangeItem.
     *
     * @return Current textFormula value. Default value is null
     */
    public UserSummary getTextFormula()  {
        return new UserSummary(getAttributeAsJavaScriptObject("textFormula"));
    }
    

    /**
     * Initial value for the "to" date.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.form.fields.DateRangeItem#getToDate toDate} for this DateRangeItem.
     *
     * @param toDate the date at which this item should end it's range. Default value is today
     * @return {@link com.smartgwt.client.widgets.form.fields.DateRangeItem DateRangeItem} instance, for chaining setter calls
     */
    public DateRangeItem setToDate(Date toDate) {
        return (DateRangeItem)setAttribute("toDate", toDate);
    }

    /**
     * Initial value for the "to" date.
     *
     * @return Current toDate value. Default value is today
     */
    public Date getToDate()  {
        return getAttributeAsDate("toDate");
    }

    /**
     * Initial value for the "to" date.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.form.fields.DateRangeItem#getToDate toDate} for this DateRangeItem.
     *
     * @param toDate the date at which this item should end it's range. Default value is today
     * @return {@link com.smartgwt.client.widgets.form.fields.DateRangeItem DateRangeItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.RelativeDateString RelativeDateString 
     */
    public DateRangeItem setToDate(String toDate) {
        return (DateRangeItem)setAttribute("toDate", toDate);
    }

    /**
     * Initial value for the "to" date.
     *
     * @return Current toDate value. Default value is today
     * @see com.smartgwt.client.docs.RelativeDateString RelativeDateString 
     */
    public String getToDateAsString()  {
        return getAttributeAsString("toDate");
    }

    /**
     * Initial value for the "to" date.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.form.fields.DateRangeItem#getToDate toDate} for this DateRangeItem.
     *
     * @param toDate the date at which this item should end it's range. Default value is today
     * @return {@link com.smartgwt.client.widgets.form.fields.DateRangeItem DateRangeItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.RelativeDateString RelativeDateString 
     */
    public DateRangeItem setToDate(TimeUnit toDate) {
        return (DateRangeItem)setAttribute("toDate", toDate == null ? null : toDate.getValue());
    }

    /**
     * Initial value for the "to" date.
     *
     * @return Current toDate value. Default value is today
     * @see com.smartgwt.client.docs.RelativeDateString RelativeDateString 
     */
    public TimeUnit getToDateAsTimeUnit()  {
        return EnumUtil.getEnum(TimeUnit.values(), getAttribute("toDate"));
    }
    

    /**
     * The field for the "to" date - a {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem} or {@link
     * com.smartgwt.client.widgets.form.fields.DateItem} according to {@link
     * com.smartgwt.client.widgets.form.fields.DateRangeItem#getAllowRelativeDates allowRelativeDates}.
     * <p>
     * This component is an AutoChild named "toField".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current toField value. Default value is null
     */
    public FormItem getToField()  {
        return FormItem.getOrCreateRef(getAttributeAsJavaScriptObject("toField"));
    }
    

    /**
     * The title for the {@link com.smartgwt.client.widgets.form.fields.DateRangeItem#getToField to} part of the range.
     *
     * @param toTitle New toTitle value. Default value is "To"
     * @return {@link com.smartgwt.client.widgets.form.fields.DateRangeItem DateRangeItem} instance, for chaining setter calls
     */
    public DateRangeItem setToTitle(String toTitle) {
        return (DateRangeItem)setAttribute("toTitle", toTitle);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.form.fields.DateRangeItem#getToField to} part of the range.
     *
     * @return Current toTitle value. Default value is "To"
     */
    public String getToTitle()  {
        return getAttributeAsString("toTitle");
    }
    

    /**
     * If this attribute is set to <code>true</code> when {@link com.smartgwt.client.widgets.form.fields.FormItem#getCriterion
     * getCriterion()} is called, the item will validate the <i>"to"</i> and <i>"from"</i> fields and return null if either
     * field fails validation. See {@link com.smartgwt.client.widgets.form.fields.DateRangeItem#validateRange validateRange()}
     *
     * @param validateCriteria New validateCriteria value. Default value is false
     * @return {@link com.smartgwt.client.widgets.form.fields.DateRangeItem DateRangeItem} instance, for chaining setter calls
     */
    public DateRangeItem setValidateCriteria(Boolean validateCriteria) {
        return (DateRangeItem)setAttribute("validateCriteria", validateCriteria);
    }

    /**
     * If this attribute is set to <code>true</code> when {@link com.smartgwt.client.widgets.form.fields.FormItem#getCriterion
     * getCriterion()} is called, the item will validate the <i>"to"</i> and <i>"from"</i> fields and return null if either
     * field fails validation. See {@link com.smartgwt.client.widgets.form.fields.DateRangeItem#validateRange validateRange()}
     *
     * @return Current validateCriteria value. Default value is false
     */
    public Boolean getValidateCriteria()  {
        Boolean result = getAttributeAsBoolean("validateCriteria", true);
        return result == null ? false : result;
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

	/**
     * Validate both <i>"to"</i> and <i>"from"</i> date-fields.
     *
     * @return false if either <i>to</i> or <i>from</i>   field contains an invalid date value.
     */
    public native Boolean validateRange() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.validateRange();
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
     * @param dateRangeItemProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(DateRangeItem dateRangeItemProperties) /*-{
        if (dateRangeItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(DateRangeItem.@java.lang.Object::getClass()(), "setDefaultProperties", dateRangeItemProperties.@java.lang.Object::getClass()());
        }
        dateRangeItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var properties = dateRangeItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::getConfig()();
        $wnd.isc.DateRangeItem.addProperties(properties);
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
                var start = null;
                if (startJS.logicalDate == true) {
                    start = @com.smartgwt.client.util.LogicalDate::new(D)(startJS.getTime());
                } else {
                    start = @com.smartgwt.client.util.JSOHelper::toDate(D)(startJS.getTime());
                }
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
                var end = null;
                if (endJS.logicalDate == true) {
                    end = @com.smartgwt.client.util.LogicalDate::new(D)(endJS.getTime());
                } else {
                    end = @com.smartgwt.client.util.JSOHelper::toDate(D)(endJS.getTime());
                }
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
     * The default <code>canEditCriterion()</code> predicate returns true if the specified criterion contains:
     * <ul><li>A single "lessOrEqual" or "greaterOrEqual" criterion on this
     * field</li>     <li>An "and" type criterion containing a "lessOrEqual" and a "greaterOrEqual" criterion         on this
     * field</li>     <li>A single "equals" criterion.  Internally, this will be converted into a range         by constructing
     * an "and" type criterion containing both a "lessOrEqual" and          a "greaterOrEqual" criterion on this field.  Note
     * that subsequent calls to the {@link com.smartgwt.client.widget.form.fields.DateRangeItem#setCriterionGetter FormItemCriterionGetter}'s
     * {@link com.smartgwt.client.widgets.form.FormItemCriterionGetter#getCriterion
     * getCriterion()} method will return this more complex          criterion.</li> </ul>
     * @param predicate the predicate to determine the form items that can edit the criterion in question
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setCanEditCriterionPredicate FormItem.setCanEditCriterionPredicate
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public void setCanEditCriterionPredicate(FormItemCanEditCriterionPredicate predicate) {
        super.setCanEditCriterionPredicate(predicate);
    }

    /**
     * The default <code>setCriterion()</code> implementation applies the specified criterion to this item for editing.
     * Applies any specified  "greaterOrEqual" operator criterion or
     * sub-criterion to our {@link com.smartgwt.client.widgets.form.fields.DateRangeItem#getFromField fromField} and any
     * specified "lessOrEqual" operator criterion or sub-criterion to our {@link
     * com.smartgwt.client.widgets.form.fields.DateRangeItem#getToField toField}. <P> Note that a single "equals" criterion can
     * also be passed.  See  {@link com.smartgwt.client.widgets.form.fields.DateRangeItem#setCanEditCriterionPredicate setCanEditCriterionPredicate()}
     * for more detail.
     * @param setter provides a method to update this field with the edited criterion
     */
    public void setCriterionSetter(FormItemCriterionSetter setter) {
        super.setCriterionSetter(setter);
    }

}
