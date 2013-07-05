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
import com.smartgwt.client.callbacks.*;
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
import com.smartgwt.client.widgets.drawing.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.logicalstructure.core.*;
import com.smartgwt.logicalstructure.widgets.*;
import com.smartgwt.logicalstructure.widgets.drawing.*;
import com.smartgwt.logicalstructure.widgets.plugins.*;
import com.smartgwt.logicalstructure.widgets.form.*;
import com.smartgwt.logicalstructure.widgets.tile.*;
import com.smartgwt.logicalstructure.widgets.grid.*;
import com.smartgwt.logicalstructure.widgets.chart.*;
import com.smartgwt.logicalstructure.widgets.layout.*;
import com.smartgwt.logicalstructure.widgets.menu.*;
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;

/**
 * Allows a user to select an absolute or relative range of dates via two {@link
 * com.smartgwt.client.widgets.form.fields.RelativeDateItem}s (if {@link
 * com.smartgwt.client.widgets.form.fields.DateRangeItem#getAllowRelativeDates allowRelativeDates} is true) or two {@link
 * com.smartgwt.client.widgets.form.fields.DateRangeItem#getDateItems DateItems}. <P> DateRangeItem is just a convenience
 * relative to using two {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem} or {@link
 * com.smartgwt.client.widgets.form.fields.DateItem} controls in a form, then using {@link
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

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
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
        $wnd.isc["DateRangeItem"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
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
        $wnd.isc["DateRangeItem"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;

    public DateRangeItem(){
        setAttribute("editorType", "DateRangeItem");
    }

    public DateRangeItem(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
        
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
     * @return Boolean
     */
    public Boolean getAllowRelativeDates()  {
        return getAttributeAsBoolean("allowRelativeDates");
    }






    /**
     * The field for the "from" date - a {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem} or {@link
     * com.smartgwt.client.widgets.form.fields.DateItem} according to {@link
     * com.smartgwt.client.widgets.form.fields.DateRangeItem#getAllowRelativeDates allowRelativeDates}.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return FormItem
     */
    public FormItem getFromField()  {
        return FormItem.getOrCreateRef(getAttributeAsJavaScriptObject("fromField"));
    }


    /**
     * The title for the {@link com.smartgwt.client.widgets.form.fields.DateRangeItem#getFromField from} part of the range.
     *
     * @param fromTitle . See {@link com.smartgwt.client.docs.String String}. Default value is "From"
     */
    public void setFromTitle(String fromTitle) {
        setAttribute("fromTitle", fromTitle);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.form.fields.DateRangeItem#getFromField from} part of the range.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
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
        setAttribute("innerTitleOrientation", innerTitleOrientation == null ? null : innerTitleOrientation.getValue());
    }

    /**
     * The title orientation for the to / from sub-items. If unset this will be derived from {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTitleOrientation this.titleOrientation} or  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getTitleOrientation this.form.titleOrientation}.
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
     * @param inputFormat . See {@link com.smartgwt.client.docs.DateInputFormat DateInputFormat}. Default value is null
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
     * @return . See {@link com.smartgwt.client.docs.DateInputFormat DateInputFormat}
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getDateFormatter
     */
    public String getInputFormat()  {
        return getAttributeAsString("inputFormat");
    }


    /**
     * Error message to display if the user enters a date range where the "To" field value is earlier than the "From" field
     * value.
     *
     * @param invalidRangeErrorMessage . See {@link com.smartgwt.client.docs.String String}. Default value is '"To" field value cannot be earlier than "From" field value.'
     */
    public void setInvalidRangeErrorMessage(String invalidRangeErrorMessage) {
        setAttribute("invalidRangeErrorMessage", invalidRangeErrorMessage);
    }

    /**
     * Error message to display if the user enters a date range where the "To" field value is earlier than the "From" field
     * value.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getInvalidRangeErrorMessage()  {
        return getAttributeAsString("invalidRangeErrorMessage");
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
     * @return Boolean
     */
    public Boolean getShouldSaveValue()  {
        return getAttributeAsBoolean("shouldSaveValue");
    }


    /**
     * Initial value for the "to" date.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.form.fields.DateRangeItem#getToDate toDate} for this DateRangeItem.
     *
     * @param toDate the date at which this item should end it's range. Default value is today
     */
    public void setToDate(Date toDate) {
        setAttribute("toDate", toDate);
    }

    /**
     * Initial value for the "to" date.
     *
     * @return Date
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
     * @param toDate the date at which this item should end it's range. See {@link com.smartgwt.client.docs.RelativeDateString RelativeDateString}. Default value is today
     */
    public void setToDate(String toDate) {
        setAttribute("toDate", toDate);
    }

    /**
     * Initial value for the "to" date.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.form.fields.DateRangeItem#getToDate toDate} for this DateRangeItem.
     *
     * @param toDate the date at which this item should end it's range. Default value is today
     */
    public void setToDate(TimeUnit toDate) {
        setAttribute("toDate", toDate == null ? null : toDate.getValue());
    }


    /**
     * The field for the "to" date - a {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem} or {@link
     * com.smartgwt.client.widgets.form.fields.DateItem} according to {@link
     * com.smartgwt.client.widgets.form.fields.DateRangeItem#getAllowRelativeDates allowRelativeDates}.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return FormItem
     */
    public FormItem getToField()  {
        return FormItem.getOrCreateRef(getAttributeAsJavaScriptObject("toField"));
    }


    /**
     * The title for the {@link com.smartgwt.client.widgets.form.fields.DateRangeItem#getToField to} part of the range.
     *
     * @param toTitle . See {@link com.smartgwt.client.docs.String String}. Default value is "To"
     */
    public void setToTitle(String toTitle) {
        setAttribute("toTitle", toTitle);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.form.fields.DateRangeItem#getToField to} part of the range.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getToTitle()  {
        return getAttributeAsString("toTitle");
    }


    /**
     * If this attribute is set to <code>true</code> when {@link
     * com.smartgwt.client.widgets.form.fields.DateRangeItem#getGetCriteria getCriteria} is called, the item will validate the
     * <i>"to"</i> and <i>"from"</i> fields and return null if either field fails validation. See {@link
     * com.smartgwt.client.widgets.form.fields.DateRangeItem#validateRange DateRangeItem.validateRange}
     *
     * @param validateCriteria validateCriteria Default value is false
     */
    public void setValidateCriteria(Boolean validateCriteria) {
        setAttribute("validateCriteria", validateCriteria);
    }

    /**
     * If this attribute is set to <code>true</code> when {@link
     * com.smartgwt.client.widgets.form.fields.DateRangeItem#getGetCriteria getCriteria} is called, the item will validate the
     * <i>"to"</i> and <i>"from"</i> fields and return null if either field fails validation. See {@link
     * com.smartgwt.client.widgets.form.fields.DateRangeItem#validateRange DateRangeItem.validateRange}
     *
     * @return Boolean
     */
    public Boolean getValidateCriteria()  {
        return getAttributeAsBoolean("validateCriteria");
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
        var ret = self.validateRange();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

    // ********************* Static Methods ***********************
    /**
     * Class level method to set the default properties of this class. If set, then all subsequent instances of this
     * class will automatically have the default properties that were set when this method was called. This is a powerful
     * feature that eliminates the need for users to create a separate hierarchy of subclasses that only alter the default
     * properties of this class. Can also be used for skinning / styling purposes.
     * <P>
     * <b>Note:</b> This method is intended for setting default attributes only and will effect all instances of the
     * underlying class (including those automatically generated in JavaScript).
     * This method should not be used to apply standard EventHandlers or override methods for
     * a class - use a custom subclass instead.
     *
     * @param dateRangeItemProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(DateRangeItem dateRangeItemProperties) /*-{
    	var properties = $wnd.isc.addProperties({},dateRangeItemProperties.@com.smartgwt.client.core.RefDataClass::getJsObj()());
    	delete properties.ID;
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
                var start = @com.smartgwt.client.data.RelativeDate::new(Lcom/google/gwt/core/client/JavaScriptObject;)(startJS);
                dateRangeJ.@com.smartgwt.client.data.DateRange::setRelativeStartDate(Lcom/smartgwt/client/data/RelativeDate;)(start);
            }
        }
        if(endJS == null || endJS === undefined) {
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


