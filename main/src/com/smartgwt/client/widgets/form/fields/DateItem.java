/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
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
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.EnumUtil;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
   /**
    * Item for manipulating Dates.&#010 <p>&#010 Can be rendered as a text field, or as 3 selects for day, month, year.  Includes optional&#010 pop-up picker.

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
        setType("date");
    }

    public DateItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public DateItem(String name) {
        setName(name);
        setType("date");
    }

    public DateItem(String name, String title) {
        setName(name);
		setTitle(title);
        setType("date");
    }

    // ********************* Properties / Attributes ***********************

    /**
    * Should we show the date in a text field, or as 3 select boxes?
    *
    * @param useTextField useTextField Default value is false
    */
    public void setUseTextField(Boolean useTextField) {
        setAttribute("useTextField", useTextField);
    }
    /**
     * Should we show the date in a text field, or as 3 select boxes?
     *
     *
     * @return Boolean
     *
     */
    public Boolean getUseTextField()  {
        return getAttributeAsBoolean("useTextField");
    }
             
    /**
    * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is <code>true</code> this property governs the alignment&#010 of text within the text field.
    *
    * @param textAlign textAlign Default value is Canvas.RIGHT
    */
    public void setTextAlign(Alignment textAlign) {
        setAttribute("textAlign", textAlign.getValue());
    }
    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is <code>true</code> this property governs the alignment&#010 of text within the text field.
     *
     *
     * @return Alignment
     *
     */
    public Alignment getTextAlign()  {
        return (Alignment) EnumUtil.getEnum(Alignment.values(), getAttribute("textAlign"));
    }

    /**
    * Can this field be set to a non-date value [other than null]?&#010 <P>&#010 When set to true, {@link com.smartgwt.client.widgets.form.fields.FormItem#setValue} will return false without setting the item value&#010 and log a warning if passed something other than a valid date value.&#010 If a user enters a text value which cannot be parsed into a valid date, the item will&#010 automatically redraw and display the {@link com.smartgwt.client.widgets.form.fields.DateItem#getInvalidDateStringMessage invalidDateStringMessage} (though at this&#010 point calling {@link com.smartgwt.client.widgets.form.fields.FormItem#getValue} will return the string entered by the user).&#010 <P>&#010 When set to false, a user may enter value that is not a valid date (for example, "Not&#010 applicable") and the value will not immediately be flagged as an error.  However note&#010 that for the value to actually pass validation you would need to declare the field as&#010 not of "date" type, for example:&#010 <pre>&#010     {name:"startDate", type:"dateOrOther", editorType:"DateItem", useTextField:true },&#010 </pre>&#010 The type "dateOrOther" could be declared as a {@link com.smartgwt.client.data.SimpleType}, with validators that&#010 will accept either a valid date or certain special Strings (like "Not Available").&#010 <P>&#010 Only applies to dateItems where {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is true. Non-Date values&#010 are never supported in items where useTextField is false.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param enforceDate enforceDate Default value is false
    */
    public void setEnforceDate(Boolean enforceDate) {
        setAttribute("enforceDate", enforceDate);
    }
    /**
     * Can this field be set to a non-date value [other than null]?&#010 <P>&#010 When set to true, {@link com.smartgwt.client.widgets.form.fields.FormItem#setValue} will return false without setting the item value&#010 and log a warning if passed something other than a valid date value.&#010 If a user enters a text value which cannot be parsed into a valid date, the item will&#010 automatically redraw and display the {@link com.smartgwt.client.widgets.form.fields.DateItem#getInvalidDateStringMessage invalidDateStringMessage} (though at this&#010 point calling {@link com.smartgwt.client.widgets.form.fields.FormItem#getValue} will return the string entered by the user).&#010 <P>&#010 When set to false, a user may enter value that is not a valid date (for example, "Not&#010 applicable") and the value will not immediately be flagged as an error.  However note&#010 that for the value to actually pass validation you would need to declare the field as&#010 not of "date" type, for example:&#010 <pre>&#010     {name:"startDate", type:"dateOrOther", editorType:"DateItem", useTextField:true },&#010 </pre>&#010 The type "dateOrOther" could be declared as a {@link com.smartgwt.client.data.SimpleType}, with validators that&#010 will accept either a valid date or certain special Strings (like "Not Available").&#010 <P>&#010 Only applies to dateItems where {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is true. Non-Date values&#010 are never supported in items where useTextField is false.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getEnforceDate()  {
        return getAttributeAsBoolean("enforceDate");
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
     *
     */
    public String getInvalidDateStringMessage()  {
        return getAttributeAsString("invalidDateStringMessage");
    }

    /**
    * Prompt to show when the user hovers the mouse over the picker icon for this DateItem. May&#010 be overridden for localization of your application.
    *
    * @param pickerIconPrompt pickerIconPrompt Default value is "Show Date Chooser"
    */
    public void setPickerIconPrompt(String pickerIconPrompt) {
        setAttribute("pickerIconPrompt", pickerIconPrompt);
    }
    /**
     * Prompt to show when the user hovers the mouse over the picker icon for this DateItem. May&#010 be overridden for localization of your application.
     *
     *
     * @return String
     *
     */
    public String getPickerIconPrompt()  {
        return getAttributeAsString("pickerIconPrompt");
    }

    /**
    * Minimum date the selectors will allow the user to pick.
    *
    * @param startDate startDate Default value is 1/1/1995
    */
    public void setStartDate(java.util.Date startDate) {
        setAttribute("startDate", startDate);
    }
    /**
     * Minimum date the selectors will allow the user to pick.
     *
     *
     * @return java.util.Date
     *
     */
    public java.util.Date getStartDate()  {
        return getAttributeAsDate("startDate");
    }

    /**
    * Maximum date the selectors will allow the user to pick.
    *
    * @param endDate endDate Default value is 12/31/2015
    */
    public void setEndDate(java.util.Date endDate) {
        setAttribute("endDate", endDate);
    }
    /**
     * Maximum date the selectors will allow the user to pick.
     *
     *
     * @return java.util.Date
     *
     */
    public java.util.Date getEndDate()  {
        return getAttributeAsDate("endDate");
    }

    /**
    * Only used if we're showing the date in a text field. When parsing a date, if the year&#010 is specified with only 2 digits and is less than the centuryThreshold, then the year will&#010 be assumed to be 20xx; otherwise it will be interpreted according to default browser&#010 behaviour, which will consider it to be 19xx.
    *
    * @param centuryThreshold centuryThreshold Default value is 25
    */
    public void setCenturyThreshold(int centuryThreshold) {
        setAttribute("centuryThreshold", centuryThreshold);
    }
    /**
     * Only used if we're showing the date in a text field. When parsing a date, if the year&#010 is specified with only 2 digits and is less than the centuryThreshold, then the year will&#010 be assumed to be 20xx; otherwise it will be interpreted according to default browser&#010 behaviour, which will consider it to be 19xx.
     *
     *
     * @return int
     *
     */
    public int getCenturyThreshold()  {
        return getAttributeAsInt("centuryThreshold");
    }
             
    /**
    * If <code>dateFormatter</code> is set at init time, it will be used instead of&#010 {@link com.smartgwt.client.widgets.form.fields.DateItem#getDisplayFormat displayFormat} to govern how dates are displayed in this item.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param dateFormatter dateFormatter Default value is null
    */
    public void setDateFormatter(DateDisplayFormat dateFormatter) {
        setAttribute("dateFormatter", dateFormatter.getValue());
    }
             
    /**
    * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is <code>true</code> this property can be used to &#010 customize the format in which dates are displayed.<br>&#010 Should be set to a standard {@link com.smartgwt.client.types.DateDisplayFormat} or&#010 a function which will return a formatted date string.&#010 Default setting is <code>"toShortDate"</code> which ensures that if the standard&#010 shortDate format is modified via {@link com.smartgwt.client..Date#setShortDisplayFormat} this format&#010 will be picked up.&#010 <P>&#010 <B>NOTE: you may need to update the {@link com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat inputFormat} to ensure the&#010 DateItem is able to parse user-entered date strings back into Dates</B>
    *
    * @param displayFormat displayFormat Default value is "toShortDate"
    */
    public void setDisplayFormat(DateDisplayFormat displayFormat) {
        setAttribute("displayFormat", displayFormat.getValue());
    }
    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is <code>true</code> this property can be used to &#010 customize the format in which dates are displayed.<br>&#010 Should be set to a standard {@link com.smartgwt.client.types.DateDisplayFormat} or&#010 a function which will return a formatted date string.&#010 Default setting is <code>"toShortDate"</code> which ensures that if the standard&#010 shortDate format is modified via {@link com.smartgwt.client..Date#setShortDisplayFormat} this format&#010 will be picked up.&#010 <P>&#010 <B>NOTE: you may need to update the {@link com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat inputFormat} to ensure the&#010 DateItem is able to parse user-entered date strings back into Dates</B>
     *
     *
     * @return DateDisplayFormat
     *
     */
    public DateDisplayFormat getDisplayFormat()  {
        return (DateDisplayFormat) EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("displayFormat"));
    }

    /**
    * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is <code>true</code> this property can be used to specify&#010 the input format for date strings. &#010 If unset, the input format will be determined based on the specified&#010 {@link com.smartgwt.client.widgets.form.fields.DateItem#getDisplayFormat displayFormat} if possible (see {@link com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat}), otherwise&#010 picked up from the Date class (see {@link com.smartgwt.client..Date#setInputFormat}).&#010 <P>&#010 Should be set to a standard {@link com.smartgwt.client..DateInputFormat} or&#010 a function which will take a date string as a parameter and return a Javascript Date object.
    *
    * @param inputFormat inputFormat Default value is null
    */
    public void setInputFormat(String inputFormat) {
        setAttribute("inputFormat", inputFormat);
    }
    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is <code>true</code> this property can be used to specify&#010 the input format for date strings. &#010 If unset, the input format will be determined based on the specified&#010 {@link com.smartgwt.client.widgets.form.fields.DateItem#getDisplayFormat displayFormat} if possible (see {@link com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat}), otherwise&#010 picked up from the Date class (see {@link com.smartgwt.client..Date#setInputFormat}).&#010 <P>&#010 Should be set to a standard {@link com.smartgwt.client..DateInputFormat} or&#010 a function which will take a date string as a parameter and return a Javascript Date object.
     *
     *
     * @return If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is <code>true</code> this method returns a&#010 standard {@link com.smartgwt.client..DateInputFormat}, or parsing function, determining how values entered&#010 by the user are to be converted to Javascript Date objects.&#010 <P>&#010 If an explicit {@link com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat inputFormat} has been specified it will be returned.&#010 <P>&#010 Otherwise, if an explicit {@link com.smartgwt.client.widgets.form.fields.DateItem#getDisplayFormat displayFormat} has been specified as one of&#010 <code>toUSShortDate</code>, <code>toEuropeanShortDate</code> or <code>toJapanShortDate</code>&#010 this method will return the appropriate DateInputFormat to parse strings entered in the&#010 specified displayFormat.&#010 <P>&#010 If no inputFormat can be derived, the method will return null, meaning the standard input&#010 format for Date objects (specified via {@link com.smartgwt.client..Date#setInputFormat}) will be used.&#010
     *
     */
    public String getInputFormat()  {
        return getAttributeAsString("inputFormat");
    }

    /**
    * If showing date selectors rather than the date text field (so when &#010 <code>this.useTextField</code> is false), this property allows customization of the &#010 order of the day, month and year selector fields. If unset these fields will match the&#010 specified inputFormat for this item.
    *
    * @param selectorFormat selectorFormat Default value is null
    */
    public void setSelectorFormat(String selectorFormat) {
        setAttribute("selectorFormat", selectorFormat);
    }
    /**
     * If showing date selectors rather than the date text field (so when &#010 <code>this.useTextField</code> is false), this property allows customization of the &#010 order of the day, month and year selector fields. If unset these fields will match the&#010 specified inputFormat for this item.
     *
     *
     * @return String
     *
     */
    public String getSelectorFormat()  {
        return getAttributeAsString("selectorFormat");
    }

    // ********************* Methods ***********************


    // ********************* Static Methods ***********************

}




