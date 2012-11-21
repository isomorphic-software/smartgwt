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
 * FormItem for editing times in a text field.  
 *  <P>
 * {@link com.smartgwt.client.widgets.form.fields.TimeItem#getTimeFormatter timeFormatter} allows you to set the display
 * format for this field.  See also
 *  String for system-wide settings.
 *  <P>
 *  TimeItem automatically accepts both 12 and 24 hour time as well as partial times and a
 *  variety of possible time value separators.  Examples:
 *  <pre>
 *   11:34:45 AM => 11:34:45
 *   1:3:5 AM => 01:30:50
 *   1:3p  => 13:30:00
 *   11 34 am => 11:34:00
 *   11-34  => 11:34:00
 *   113445  => 11:34:45
 *   13445  => 01:34:45
 *   1134  => 11:34:00
 *   134   => 01:34:00
 *  </pre>
 *  <P>
 *  Values entered by the user are stored as JavaScript <code>Date</code> objects in local time.  The day,
 *  month and year values of this <code>Date</code> object are not relevant and should be ignored.
 */
public class TimeItem extends TextItem {

    public static TimeItem getOrCreateRef(JavaScriptObject jsObj) {
    
        if(jsObj == null) return null;

        RefDataClass obj = RefDataClass.getRef(jsObj);

 
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (TimeItem) obj;
        } else {
            return new TimeItem(jsObj);
        }
    }

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }


    public TimeItem(){
        setAttribute("editorType", "TimeItem");
    }

    public TimeItem(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }

    public TimeItem(String name) {
        setName(name);
        setAttribute("editorType", "TimeItem");
    }

    public TimeItem(String name, String title) {
        setName(name);
		setTitle(title);
        setAttribute("editorType", "TimeItem");
    }

    // ********************* Properties / Attributes ***********************

    /**
     * Internal-use only for a TimeItem.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * A custom mask cannot be defined for a time item.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param mask . See {@link com.smartgwt.client.docs.String String}. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.TimeItem#setUseMask
     */
    public void setMask(String mask) {
        setAttribute("mask", mask);
    }

    /**
     * Internal-use only for a TimeItem.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     * @see com.smartgwt.client.widgets.form.fields.TimeItem#getUseMask
     */
    public String getMask()  {
        return getAttributeAsString("mask");
    }

    /**
     * Internal-use only for a TimeItem.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param maskOverwriteMode maskOverwriteMode Default value is null
     * @see com.smartgwt.client.widgets.form.fields.TimeItem#setUseMask
     */
    public void setMaskOverwriteMode(Boolean maskOverwriteMode) {
        setAttribute("maskOverwriteMode", maskOverwriteMode);
    }

    /**
     * Internal-use only for a TimeItem.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.form.fields.TimeItem#getUseMask
     */
    public Boolean getMaskOverwriteMode()  {
        return getAttributeAsBoolean("maskOverwriteMode");
    }

    /**
     * Internal-use only for a TimeItem.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param maskSaveLiterals maskSaveLiterals Default value is null
     * @see com.smartgwt.client.widgets.form.fields.TimeItem#setUseMask
     */
    public void setMaskSaveLiterals(Boolean maskSaveLiterals) {
        setAttribute("maskSaveLiterals", maskSaveLiterals);
    }

    /**
     * Internal-use only for a TimeItem.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.form.fields.TimeItem#getUseMask
     */
    public Boolean getMaskSaveLiterals()  {
        return getAttributeAsBoolean("maskSaveLiterals");
    }

    /**
     * What format should this item's time string be presented in? If unset the format will be derived from {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getTimeFormatter timeFormatter} or the system-side
     *
     * @param timeFormatter timeFormatter Default value is "toShort24HourTime"
     */
    public void setTimeFormatter(TimeDisplayFormat timeFormatter) {
        setAttribute("timeFormatter", timeFormatter == null ? null : timeFormatter.getValue());
    }

    /**
     * What format should this item's time string be presented in? If unset the format will be derived from {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getTimeFormatter timeFormatter} or the system-side
     *
     *
     * @return TimeDisplayFormat
     */
    public TimeDisplayFormat getTimeFormatter()  {
        return EnumUtil.getEnum(TimeDisplayFormat.values(), getAttribute("timeFormatter"));
    }

    /**
     * If true, a data entry mask will be enabled in the field based on the {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getTimeFormatter timeFormatter}. <p> Note that if a non-padded {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getTimeFormatter timeFormatter} is specified, it will be changed to the
     * corresponding padded version (ex. "toShort24HourTime" will be changed to "toShortPadded24HourTime").
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param useMask useMask Default value is null
     */
    public void setUseMask(Boolean useMask) {
        setAttribute("useMask", useMask);
    }

    /**
     * If true, a data entry mask will be enabled in the field based on the {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getTimeFormatter timeFormatter}. <p> Note that if a non-padded {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getTimeFormatter timeFormatter} is specified, it will be changed to the
     * corresponding padded version (ex. "toShort24HourTime" will be changed to "toShortPadded24HourTime").
     *
     *
     * @return Boolean
     */
    public Boolean getUseMask()  {
        return getAttributeAsBoolean("useMask");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
        
    // ***********************************************************        


    /**
     * What format should this item's time string be presented in?
     * @deprecated Use {@link #setDisplayFormat(TimeDisplayFormat)} instead.
     *
     * @param timeFormatter displayFormat Default value is "toShort24HourTime"
     */
    public void setDisplayFormat(TimeFormatter timeFormatter) {
        setAttribute("displayFormat", timeFormatter.getValue());
    }

    /**
     * What format should this item's time string be presented in?
     *
     * @param TimeDisplayFormat displayFormat Default value is "toShort24HourTime"
     */
    public void setDisplayFormat(TimeDisplayFormat timeFormatter) {
        setAttribute("displayFormat", timeFormatter.getValue());
    }

    /**
     * What format should this item's time string be presented in?
     *
     * @return TimeDisplayFormat
     */
    public TimeDisplayFormat getDisplayFormat() {
        return EnumUtil.getEnum(TimeDisplayFormat.values(), getAttribute("displayFormat"));
    }

}







