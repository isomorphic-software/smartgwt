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
 * Subclass of DateItem for manipulating {@link com.smartgwt.client.types.FieldType datetimes}.
 */
public class DateTimeItem extends DateItem {

    public static DateTimeItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (DateTimeItem) obj;
        } else {
            return new DateTimeItem(jsObj);
        }
    }

    public DateTimeItem(){
        setAttribute("editorType", "DateTimeItem");
    }

    public DateTimeItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public DateTimeItem(String name) {
        setName(name);
        setAttribute("editorType", "DateTimeItem");
    }

    public DateTimeItem(String name, String title) {
        setName(name);
		setTitle(title);
        setAttribute("editorType", "DateTimeItem");
    }

    // ********************* Properties / Attributes ***********************

    /**
     * This property can be used to customize the format in which datetimes are displayed.<br> Should be set to a standard
     * {@link com.smartgwt.client.types.DateDisplayFormat} or a function which will return a formatted date time string. <P> If
     * unset, the standard shortDateTime format as set up in   Date.setShortDatetimeDisplayFormat will be used. <P> <B>NOTE:
     * you may need to update the {@link com.smartgwt.client.widgets.form.fields.DateTimeItem#getInputFormat inputFormat} to
     * ensure the DateItem is able to parse user-entered date strings back into Dates</B>
     *
     * @param displayFormat displayFormat Default value is null
     * @see com.smartgwt.client.widgets.form.fields.DateTimeItem#setInputFormat
     */
    public void setDisplayFormat(DateDisplayFormat displayFormat) {
        setAttribute("displayFormat", displayFormat.getValue());
    }

    /**
     * This property can be used to customize the format in which datetimes are displayed.<br> Should be set to a standard
     * {@link com.smartgwt.client.types.DateDisplayFormat} or a function which will return a formatted date time string. <P> If
     * unset, the standard shortDateTime format as set up in   Date.setShortDatetimeDisplayFormat will be used. <P> <B>NOTE:
     * you may need to update the {@link com.smartgwt.client.widgets.form.fields.DateTimeItem#getInputFormat inputFormat} to
     * ensure the DateItem is able to parse user-entered date strings back into Dates</B>
     *
     *
     * @return DateDisplayFormat
     * @see com.smartgwt.client.widgets.form.fields.DateTimeItem#getInputFormat
     */
    public DateDisplayFormat getDisplayFormat()  {
        return EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("displayFormat"));
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is <code>true</code> this
     * property can be used to specify the input format for date strings.  If unset, the input format will be determined based
     * on the specified {@link com.smartgwt.client.widgets.form.fields.DateItem#getDisplayFormat displayFormat} if possible
     * (see {@link com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat DateItem.getInputFormat}), otherwise picked
     * up from the Date class (see  Date.setInputFormat). <P> Should be set to a standard String or a function which will take
     * a date string as a parameter and return a Javascript Date object.
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
     * on the specified {@link com.smartgwt.client.widgets.form.fields.DateItem#getDisplayFormat displayFormat} if possible
     * (see {@link com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat DateItem.getInputFormat}), otherwise picked
     * up from the Date class (see  Date.setInputFormat). <P> Should be set to a standard String or a function which will take
     * a date string as a parameter and return a Javascript Date object.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.form.fields.DateItem#getDisplayFormat
     */
    public String getInputFormat()  {
        return getAttributeAsString("inputFormat");
    }

    /**
     * DateTimeItems show datetime values in a freeform text entry area.
     *
     * @param useTextField useTextField Default value is true
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public void setUseTextField(Boolean useTextField) {
        setAttribute("useTextField", useTextField);
    }

    /**
     * DateTimeItems show datetime values in a freeform text entry area.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public Boolean getUseTextField()  {
        return getAttributeAsBoolean("useTextField");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
        
    // ***********************************************************        

}



