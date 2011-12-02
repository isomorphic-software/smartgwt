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

import java.util.*;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Allows a user to select an absolute or relative range of dates via two {@link
 * com.smartgwt.client.widgets.form.fields.RelativeDateItem}s (if {@link
 * com.smartgwt.client.widgets.form.fields.DateRangeItem#getAllowRelativeDates allowRelativeDates} is true) or two {@link
 * com.smartgwt.client.widgets.form.fields.DateRangeItem#getDateItems DateItems}. <P> DateRangeItem is just a convenience
 * relative to using two {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem} or {@link
 * com.smartgwt.client.widgets.form.fields.DateItem} controls in a form, using {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#getOperator operator} and {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#getCriteriaField criteriaField} to cause them to produce a date range. 
 * If you need more control over layout, validation, event handling or any other aspect of appearance or behavior, stop
 * using DateRangeItem and use two DateItem/RelativeDateItem controls directly instead.
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
     * Whether to allow the user to specify relative dates (via {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem}s) or whether dates are absolute (via {@link
     * com.smartgwt.client.widgets.form.fields.DateItem}s).
     *
     * @param allowRelativeDates allowRelativeDates Default value is false
     */
    public void setAllowRelativeDates(Boolean allowRelativeDates) {
        setAttribute("allowRelativeDates", allowRelativeDates);
    }

    /**
     * Whether to allow the user to specify relative dates (via {@link
     * com.smartgwt.client.widgets.form.fields.RelativeDateItem}s) or whether dates are absolute (via {@link
     * com.smartgwt.client.widgets.form.fields.DateItem}s).
     *
     *
     * @return Boolean
     */
    public Boolean getAllowRelativeDates()  {
        return getAttributeAsBoolean("allowRelativeDates");
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
     * The title orientation for the to / from sub-items. If unset this will be derived from {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTitleOrientation this.titleOrientation} or  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getTitleOrientation this.form.titleOrientation}.
     *
     * @param innerTitleOrientation innerTitleOrientation Default value is null
     */
    public void setInnerTitleOrientation(TitleOrientation innerTitleOrientation) {
        setAttribute("innerTitleOrientation", innerTitleOrientation.getValue());
    }

    /**
     * The title orientation for the to / from sub-items. If unset this will be derived from {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTitleOrientation this.titleOrientation} or  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getTitleOrientation this.form.titleOrientation}.
     *
     *
     * @return TitleOrientation
     */
    public TitleOrientation getInnerTitleOrientation()  {
        return EnumUtil.getEnum(TitleOrientation.values(), getAttribute("innerTitleOrientation"));
    }

    /**
     * For fields of type <code>"date"</code>, if this is an editable field such as a {@link
     * com.smartgwt.client.widgets.form.fields.TextItem}, this property  allows you to specify the {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat inputFormat} applied to the item.
     *
     * @param inputFormat inputFormat Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setDateFormatter
     */
    public void setInputFormat(String inputFormat) {
        setAttribute("inputFormat", inputFormat);
    }

    /**
     * For fields of type <code>"date"</code>, if this is an editable field such as a {@link
     * com.smartgwt.client.widgets.form.fields.TextItem}, this property  allows you to specify the {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat inputFormat} applied to the item.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getDateFormatter
     */
    public String getInputFormat()  {
        return getAttributeAsString("inputFormat");
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
     * Returns true if the specified criterion contains: <ul><li>A single "lessOrEqual" or "greaterOrEqual" criterion on this
     * field</li>     <li>An "and" type criterion containing a "lessOrEqual" and a "greaterOrEqual" criterion on         this
     * field</li>     <li>A single "equals" criterion.  Internally, this will be converted into a range         by constructing
     * an "and" type criterion containing both a "lessOrEqual" and          a "greaterOrEqual" criterion on this field.  Note
     * that subsequent calls to          {@link com.smartgwt.client.widgets.form.fields.DateRangeItem#getCriterion
     * getCriterion()} will return this more complex          criterion.</li> </ul>
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
     * Applies the specified criterion to this item for editing. Applies any specified "greaterOrEqual" operator criterion or
     * sub-criterion to our {@link com.smartgwt.client.widgets.form.fields.DateRangeItem#getFromField fromField} and any
     * specified "lessOrEqual" operator criterion or sub-criterion to our {@link
     * com.smartgwt.client.widgets.form.fields.DateRangeItem#getToField toField}. <P> Note that a single "equals" criterion can
     * also be passed.  See  {@link com.smartgwt.client.widgets.form.fields.DateRangeItem#canEditCriterion canEditCriterion()}
     * for more detail.
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



