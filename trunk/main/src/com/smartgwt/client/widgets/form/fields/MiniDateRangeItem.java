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
 * Provides a compact interface for editing a date range, by providing a read-only display of  the current selected date
 * range with an icon to launch a DateRangeDialog to edit the  range.
 */
public class MiniDateRangeItem extends StaticTextItem {

    public static MiniDateRangeItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (MiniDateRangeItem) obj;
        } else {
            return new MiniDateRangeItem(jsObj);
        }
    }

    public MiniDateRangeItem(){
        setType("MiniDateRangeItem");
    }

    public MiniDateRangeItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public MiniDateRangeItem(String name) {
        setName(name);
        setType("MiniDateRangeItem");
    }

    public MiniDateRangeItem(String name, String title) {
        setName(name);
		setTitle(title);
        setType("MiniDateRangeItem");
    }

    // ********************* Properties / Attributes ***********************

    /**
     * Format for displaying dates in to the user.   Defaults to the system-wide default established by 
     * setDefaultDisplayFormat. <P> If this attribute is unset, the display value is formatted intelligently according to the
     * dates involved.  For example, if both dates appear in the same month, the value will be  formatted as <code>Month date1
     * - date2, Year</code> and, if in different months of the same year, <code>Month1 date1 - Month2 date2, Year</code>.
     *
     * @param dateDisplayFormat dateDisplayFormat Default value is null
     */
    public void setDateDisplayFormat(DateDisplayFormat dateDisplayFormat) {
        setAttribute("dateDisplayFormat", dateDisplayFormat.getValue());
    }

    /**
     * Format for displaying dates in to the user.   Defaults to the system-wide default established by 
     * setDefaultDisplayFormat. <P> If this attribute is unset, the display value is formatted intelligently according to the
     * dates involved.  For example, if both dates appear in the same month, the value will be  formatted as <code>Month date1
     * - date2, Year</code> and, if in different months of the same year, <code>Month1 date1 - Month2 date2, Year</code>.
     *
     *
     * @return DateDisplayFormat
     */
    public DateDisplayFormat getDateDisplayFormat()  {
        return EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("dateDisplayFormat"));
    }

    /**
     * Icon that launches a {@link com.smartgwt.client.widgets.DateChooser} for choosing an absolute date.
     *
     * @param pickerIcon pickerIcon Default value is null
     */
    public void setPickerIcon(FormItemIcon pickerIcon) {
        setAttribute("pickerIcon", pickerIcon.getJsObj());
    }

    /**
     * Icon that launches a {@link com.smartgwt.client.widgets.DateChooser} for choosing an absolute date.
     *
     *
     * @return FormItemIcon
     */
    public FormItemIcon getPickerIcon()  {
        return new FormItemIcon(getAttributeAsJavaScriptObject("pickerIcon"));
    }

    /**
     * The prompt to show when the mouse is hovered over the {@link
     * com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#getPickerIcon pickerIcon}.
     *
     * @param pickerIconPrompt pickerIconPrompt Default value is "Show Date Chooser"
     */
    public void setPickerIconPrompt(String pickerIconPrompt) {
        setAttribute("pickerIconPrompt", pickerIconPrompt);
    }

    /**
     * The prompt to show when the mouse is hovered over the {@link
     * com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#getPickerIcon pickerIcon}.
     *
     *
     * @return String
     */
    public String getPickerIconPrompt()  {
        return getAttributeAsString("pickerIconPrompt");
    }

    /**
     * Allow miniDateRangeItems' values to show up in the form's values array, or if  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria DynamicForm.getValuesAsCriteria} is called, for the
     * criterion to be included in the returned AdvancedCriteria object
     *
     * @param shouldSaveValue shouldSaveValue Default value is true
     */
    public void setShouldSaveValue(Boolean shouldSaveValue) {
        setAttribute("shouldSaveValue", shouldSaveValue);
    }

    /**
     * Allow miniDateRangeItems' values to show up in the form's values array, or if  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria DynamicForm.getValuesAsCriteria} is called, for the
     * criterion to be included in the returned AdvancedCriteria object
     *
     *
     * @return Boolean
     */
    public Boolean getShouldSaveValue()  {
        return getAttributeAsBoolean("shouldSaveValue");
    }

    /**
     * Base CSS class name for a form item's text box element. <P> NOTE: See the {@link CompoundFormItem_skinning} discussion
     * for special skinning considerations.
     *
     * @param textBoxStyle textBoxStyle Default value is "textItem"
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setCellStyle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setTextBoxStyle(String textBoxStyle) {
        setAttribute("textBoxStyle", textBoxStyle);
    }

    /**
     * Base CSS class name for a form item's text box element. <P> NOTE: See the {@link CompoundFormItem_skinning} discussion
     * for special skinning considerations.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getCellStyle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getTextBoxStyle()  {
        return getAttributeAsString("textBoxStyle");
    }

    // ********************* Methods ***********************
            
    /**
     * Whether the DateRangeDialog opened when the  {@link
     * com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#getPickerIcon pickerIcon} is clicked should display  {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem}s or {@link com.smartgwt.client.widgets.form.fields.DateItem}s.
     *
     * @return true
     */
    public native Boolean allowRelativeDates() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var retVal =self.allowRelativeDates();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Returns true if the specified criterion contains: <ul><li>A single "lessOrEqual" or "greaterOrEqual" criterion on this
     * field</li>     <li>An "and" type criterion containing a "lessOrEqual" and a "greaterOrEqual" criterion on         this
     * field</li> </ul>
     * @param criterion criterion to test
     *
     * @return returns true if this criterion can be edited by this item
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public native Boolean canEditCriterion(Criterion criterion) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var retVal =self.canEditCriterion(criterion.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Returns the Criterion entered in the fields shown in the  {@link
     * com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#getRangeDialog rangeDialog}. <P> If both dates are entered, a
     * Criterion with an "and" {@link com.smartgwt.client.types.OperatorId operator} will be returned with both a
     * "greaterOrEqual" and "lessOrEqual" sub-criteria.  If either date is omitted, only the "greaterOrEqual" (from date) or
     * "lessOrEqual" (to date) Criterion is returned.
     *
     * @return 
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public native Criterion getCriterion() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getCriterion();
        if(ret == null || ret === undefined) return null;
        return @com.smartgwt.client.data.Criterion::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
            
    /**
     * Overridden to return true: dateRangeItems always generate AdvancedCriteria.
     *
     * @return true
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public native Boolean hasAdvancedCriteria() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var retVal =self.hasAdvancedCriteria();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Applies the specified criterion to this item for editing. Applies any specified "greaterOrEqual" operator criterion or
     * sub-criterion to our {@link com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#getFromField fromField} and any
     * specified "lessOrEqual" operator criterion or sub-criterion to our {@link
     * com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#getToField toField}.
     * @param criterion criterion to edit
     */
    public native void setCriterion(Criterion criterion) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.setCriterion(criterion.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    // ********************* Static Methods ***********************
        
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
        if(startJS == null || startJS === undefined) {
            //do nothing as null is the default
        } else {
            if($wnd.isc.isA.Date(startJS)) {
                var start = @com.smartgwt.client.util.JSOHelper::toDate(D)(startJS.getTime());
                dateRangeJ.@com.smartgwt.client.data.DateRange::setStartDate(Ljava/util/Date;)(start);
            } else if($wnd.isc.isA.String(startJS)) {
                var start = @com.smartgwt.client.data.RelativeDate::new(Ljava/lang/String;)(startJS);
                dateRangeJ.@com.smartgwt.client.data.DateRange::setRelativeStartDate(Lcom/smartgwt/client/data/RelativeDate;)(start);
            } else if(startJS.value) {
                var start = @com.smartgwt.client.data.RelativeDate::new(Ljava/lang/String;)(startJS.value);
                dateRangeJ.@com.smartgwt.client.data.DateRange::setRelativeStartDate(Lcom/smartgwt/client/data/RelativeDate;)(start);
            }
        }
        if(endJS == null || endJS === undefined) {
            //do nothing as null is the default
        } else {
            if($wnd.isc.isA.Date(endJS)) {
                var end = @com.smartgwt.client.util.JSOHelper::toDate(D)(endJS.getTime());
                dateRangeJ.@com.smartgwt.client.data.DateRange::setEndDate(Ljava/util/Date;)(end);
            } else if($wnd.isc.isA.String(startJS)) {
                var end = @com.smartgwt.client.data.RelativeDate::new(Ljava/lang/String;)(endJS);
                dateRangeJ.@com.smartgwt.client.data.DateRange::setRelativeEndDate(Lcom/smartgwt/client/data/RelativeDate;)(end);
            } else if(endJS.value) {
                var end = @com.smartgwt.client.data.RelativeDate::new(Ljava/lang/String;)(endJS.value);
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

}



