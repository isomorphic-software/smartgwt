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
 * Allows a user to select an absolute or relative range of dates via two RelativeDateItems (if {@link
 * com.smartgwt.client.widgets.form.fields.DateRangeItem#getAllowRelativeDates allowRelativeDates} is true) or two {@link
 * com.smartgwt.client.widgets.form.fields.DateRangeItem#getDateItems DateItems}.
 */
public class DateRangeItem extends CanvasItem {

    public static DateRangeItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (DateRangeItem) obj;
        } else {
            return new DateRangeItem(jsObj);
        }
    }

    public DateRangeItem(){
        setType("DateRangeItem");
    }

    public DateRangeItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public DateRangeItem(String name) {
        setName(name);
        setType("DateRangeItem");
    }

    public DateRangeItem(String name, String title) {
        setName(name);
		setTitle(title);
        setType("DateRangeItem");
    }

    // ********************* Properties / Attributes ***********************

    /**
     * Whether to allow the user to specify relative dates (via RelativeDateItems) or whether dates are absolute (via {@link
     * com.smartgwt.client.widgets.form.fields.DateItem}s).
     *
     * @param allowRelativeDates allowRelativeDates Default value is false
     */
    public void setAllowRelativeDates(Boolean allowRelativeDates) {
        setAttribute("allowRelativeDates", allowRelativeDates);
    }

    /**
     * Whether to allow the user to specify relative dates (via RelativeDateItems) or whether dates are absolute (via {@link
     * com.smartgwt.client.widgets.form.fields.DateItem}s).
     *
     *
     * @return Boolean
     */
    public Boolean getAllowRelativeDates()  {
        return getAttributeAsBoolean("allowRelativeDates");
    }

    /**
     * Format for displaying dates in to the user.   Defaults to the system-wide default established by 
     * setDefaultDisplayFormat.
     *
     * @param dateDisplayFormat dateDisplayFormat Default value is null
     */
    public void setDateDisplayFormat(DateDisplayFormat dateDisplayFormat) {
        setAttribute("dateDisplayFormat", dateDisplayFormat.getValue());
    }

    /**
     * Format for displaying dates in to the user.   Defaults to the system-wide default established by 
     * setDefaultDisplayFormat.
     *
     *
     * @return DateDisplayFormat
     */
    public DateDisplayFormat getDateDisplayFormat()  {
        return EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("dateDisplayFormat"));
    }

    /**
     * Format for direct user input of date values. <P> If unset, the input format will be determined based on the specified
     * {@link com.smartgwt.client.types.DateDisplayFormat} if possible, otherwise picked up from the Date class (see 
     * Date.setInputFormat).
     *
     * @param dateInputFormat dateInputFormat Default value is null
     */
    public void setDateInputFormat(String dateInputFormat) {
        setAttribute("dateInputFormat", dateInputFormat);
    }

    /**
     * Format for direct user input of date values. <P> If unset, the input format will be determined based on the specified
     * {@link com.smartgwt.client.types.DateDisplayFormat} if possible, otherwise picked up from the Date class (see 
     * Date.setInputFormat).
     *
     *
     * @return String
     */
    public String getDateInputFormat()  {
        return getAttributeAsString("dateInputFormat");
    }

    /**
     * The title for the "from" part of the range.
     *
     * @param fromTitle fromTitle Default value is "From"
     */
    public void setFromTitle(String fromTitle) {
        setAttribute("fromTitle", fromTitle);
    }

    /**
     * The title for the "from" part of the range.
     *
     *
     * @return String
     */
    public String getFromTitle()  {
        return getAttributeAsString("fromTitle");
    }

    /**
     * Allow dateRangeItems' values to show up in the form's values array, or if  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria DynamicForm.getValuesAsCriteria} is called, for the
     * criterion to be included in the returned AdvancedCriteria object
     *
     * @param shouldSaveValue shouldSaveValue Default value is true
     */
    public void setShouldSaveValue(Boolean shouldSaveValue) {
        setAttribute("shouldSaveValue", shouldSaveValue);
    }

    /**
     * Allow dateRangeItems' values to show up in the form's values array, or if  {@link
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
     * The title for the "to" part of the range.
     *
     * @param toTitle toTitle Default value is "To"
     */
    public void setToTitle(String toTitle) {
        setAttribute("toTitle", toTitle);
    }

    /**
     * The title for the "to" part of the range.
     *
     *
     * @return String
     */
    public String getToTitle()  {
        return getAttributeAsString("toTitle");
    }

    // ********************* Methods ***********************
            
    /**
     * Returns true if the specified criterion contains: <ul><li>A single "lessThan" or "greaterThan" criterion on this
     * field</li>     <li>An "and" type criterion containing a "lessThan" and a "greaterThan" criterion on         this
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
     * Applies the specified criterion to this item for editing. Applies any specified "greaterThan" operator criterion or
     * sub-criterion to our {@link com.smartgwt.client.widgets.form.fields.DateRangeItem#getFromField fromField} and any
     * specified "lessThan" operator criterion or sub-criterion to our {@link
     * com.smartgwt.client.widgets.form.fields.DateRangeItem#getToField toField}.
     * @param criterion criterion to edit
     */
    public native void setCriterion(Criterion criterion) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.setCriterion(criterion.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    // ********************* Static Methods ***********************


    /**
     * Initial value for the "from" date.
     * Sets the {@link com.smartgwt.client.widgets.form.fields.DateRangeItem#getFromDate fromDate} for this DateRangeItem.
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
        return getAttributeAsDate("fromDate");
    }

    /**
     * Initial value for the "to" date.
     * Sets the {@link com.smartgwt.client.widgets.form.fields.DateRangeItem#getToDate toDate} for this DateRangeItem.
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
        return getAttributeAsDate("toDate");
    }

    /**
     * Retrieves the current value of this dateRangeItem.  The return value is a
     * ${isc.DocUtils.linkForRef('object:DateRange')} object that excludes start and end values if they aren't set.
     *
     * @return the current value of this item
     */
    public native DateRange getValue() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var valueJS = self.getValue();
        if(valueJS == null) return null;
        var startJS = valueJS.start;
        var endJS = valueJS.end;
        var start = startJS == null || startJS === undefined ? null : @com.smartgwt.client.util.JSOHelper::toDate(D)(startJS.getTime());
        var end = endJS == null || endJS === undefined ? null : @com.smartgwt.client.util.JSOHelper::toDate(D)(endJS.getTime());
        return @com.smartgwt.client.widgets.form.fields.DateRange::new(Ljava/util/Date;Ljava/util/Date;)(start, end);
    }-*/;

    /**
     * Sets the value for this dateRangeItem.  The value parameter is a  {@link com.smartgwt.client.widgets.form.fields.DateRange DateRange} object
     * that optionally includes both start and end values.
     *
     * @param value the new value for this item
     */
    public native void setValue(DateRange value) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var start = value.@com.smartgwt.client.widgets.form.fields.DateRange::getStart()();
        var end = value.@com.smartgwt.client.widgets.form.fields.DateRange::getEnd()();
        var startJS = start == null ? null : @com.smartgwt.client.util.JSOHelper::toDateJS(Ljava/util/Date;)(start);
        var endJS = end == null ? null : @com.smartgwt.client.util.JSOHelper::toDateJS(Ljava/util/Date;)(end);
        var valueJS = {start:startJS, end:endJS};
        self.setValue(valueJS);
    }-*/;

}




