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
 
package com.smartgwt.client.data;



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
 * Settings for use with {@link com.smartgwt.client.data.DataSource#recordsAsText DataSource.recordsAsText}.
 */
public class TextExportSettings extends TextSettings {

    public static TextExportSettings getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (TextExportSettings) obj;
        } else {
            return new TextExportSettings(jsObj);
        }
    }

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        id = JSOHelper.getAttribute(jsObj, "ID");
    }


    public TextExportSettings(){
        scClassName = "TextExportSettings";
    }

    public TextExportSettings(JavaScriptObject jsObj){
        scClassName = "TextExportSettings";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
     * Format to use when outputting date values.  Default is to use the format expected by Microsoft Excel (eg 1-2-2011),
     * which Excel will turn into a real date value (see {@link com.smartgwt.client.docs.ExcelPaste}).  The current
     * month-day-year order as set by  Date.setInputFormat will be used.
     *
     * @param dateFormat dateFormat Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setDateFormat(DateDisplayFormat dateFormat)  throws IllegalStateException {
        setAttribute("dateFormat", dateFormat == null ? null : dateFormat.getValue(), false);
    }

    /**
     * Format to use when outputting date values.  Default is to use the format expected by Microsoft Excel (eg 1-2-2011),
     * which Excel will turn into a real date value (see {@link com.smartgwt.client.docs.ExcelPaste}).  The current
     * month-day-year order as set by  Date.setInputFormat will be used.
     *
     *
     * @return DateDisplayFormat
     */
    public DateDisplayFormat getDateFormat()  {
        return EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("dateFormat"));
    }

    /**
     * Format to use when outputting datetime values.  Default is to combine the configured date and time formats with a space
     * (" ").
     *
     * @param dateTimeFormat dateTimeFormat Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setDateTimeFormat(DateDisplayFormat dateTimeFormat)  throws IllegalStateException {
        setAttribute("dateTimeFormat", dateTimeFormat == null ? null : dateTimeFormat.getValue(), false);
    }

    /**
     * Format to use when outputting datetime values.  Default is to combine the configured date and time formats with a space
     * (" ").
     *
     *
     * @return DateDisplayFormat
     */
    public DateDisplayFormat getDateTimeFormat()  {
        return EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("dateTimeFormat"));
    }

    /**
     * If set, all text fields will use the indicated {@link com.smartgwt.client.types.ForceTextApproach} unless they have a
     * specific setting for {@link com.smartgwt.client.data.DataSourceField#exportForceText DataSourceField.exportForceText}.
     *
     * @param forceText forceText Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setForceText(ForceTextApproach forceText)  throws IllegalStateException {
        setAttribute("forceText", forceText == null ? null : forceText.getValue(), false);
    }

    /**
     * If set, all text fields will use the indicated {@link com.smartgwt.client.types.ForceTextApproach} unless they have a
     * specific setting for {@link com.smartgwt.client.data.DataSourceField#exportForceText DataSourceField.exportForceText}.
     *
     *
     * @return ForceTextApproach
     */
    public ForceTextApproach getForceText()  {
        return EnumUtil.getEnum(ForceTextApproach.values(), getAttribute("forceText"));
    }

    /**
     * Separator between Records.  Default is a newline character ("\n").
     *
     * @param lineSeparator . See {@link com.smartgwt.client.docs.String String}. Default value is "\n"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setLineSeparator(String lineSeparator)  throws IllegalStateException {
        setAttribute("lineSeparator", lineSeparator, false);
    }

    /**
     * Separator between Records.  Default is a newline character ("\n").
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getLineSeparator()  {
        return getAttributeAsString("lineSeparator");
    }

    /**
     * Whether to surround each value with quotes ("").
     *
     * @param quoteValues quoteValues Default value is true
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setQuoteValues(Boolean quoteValues)  throws IllegalStateException {
        setAttribute("quoteValues", quoteValues, false);
    }

    /**
     * Whether to surround each value with quotes ("").
     *
     *
     * @return Boolean
     */
    public Boolean getQuoteValues()  {
        return getAttributeAsBoolean("quoteValues");
    }

    /**
     * Format to use when outputting time values.  Default is 24 hour time.
     *
     * @param timeFormat timeFormat Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setTimeFormat(TimeDisplayFormat timeFormat)  throws IllegalStateException {
        setAttribute("timeFormat", timeFormat == null ? null : timeFormat.getValue(), false);
    }

    /**
     * Format to use when outputting time values.  Default is 24 hour time.
     *
     *
     * @return TimeDisplayFormat
     */
    public TimeDisplayFormat getTimeFormat()  {
        return EnumUtil.getEnum(TimeDisplayFormat.values(), getAttribute("timeFormat"));
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
        
    // ***********************************************************        

}



