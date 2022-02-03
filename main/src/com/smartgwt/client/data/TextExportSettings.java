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
 
package com.smartgwt.client.data;


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
 * Settings for use with {@link com.smartgwt.client.data.DataSource#recordsAsText DataSource.recordsAsText()}.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("TextExportSettings")
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
     * which Excel will turn into a real date value (see {@link com.smartgwt.client.docs.ExcelPasting}).  The current
     * month-day-year order as set by {@link com.smartgwt.client.util.DateUtil#setInputFormat DateUtil.setInputFormat()} will
     * be used.
     *
     * @param dateFormat New dateFormat value. Default value is null
     * @return {@link com.smartgwt.client.data.TextExportSettings TextExportSettings} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public TextExportSettings setDateFormat(DateDisplayFormat dateFormat)  throws IllegalStateException {
        return (TextExportSettings)setAttribute("dateFormat", dateFormat == null ? null : dateFormat.getValue(), false);
    }

    /**
     * Format to use when outputting date values.  Default is to use the format expected by Microsoft Excel (eg 1-2-2011),
     * which Excel will turn into a real date value (see {@link com.smartgwt.client.docs.ExcelPasting}).  The current
     * month-day-year order as set by {@link com.smartgwt.client.util.DateUtil#setInputFormat DateUtil.setInputFormat()} will
     * be used.
     *
     * @return Current dateFormat value. Default value is null
     */
    public DateDisplayFormat getDateFormat()  {
        return EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("dateFormat"));
    }
    

    /**
     * Format to use when outputting datetime values.  Default is to combine the configured date and time formats with a space
     * (" ").
     *
     * @param dateTimeFormat New dateTimeFormat value. Default value is null
     * @return {@link com.smartgwt.client.data.TextExportSettings TextExportSettings} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public TextExportSettings setDateTimeFormat(DateDisplayFormat dateTimeFormat)  throws IllegalStateException {
        return (TextExportSettings)setAttribute("dateTimeFormat", dateTimeFormat == null ? null : dateTimeFormat.getValue(), false);
    }

    /**
     * Format to use when outputting datetime values.  Default is to combine the configured date and time formats with a space
     * (" ").
     *
     * @return Current dateTimeFormat value. Default value is null
     */
    public DateDisplayFormat getDateTimeFormat()  {
        return EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("dateTimeFormat"));
    }
    

    /**
     * If set, all text fields will use the indicated {@link com.smartgwt.client.types.ForceTextApproach} unless they have a
     * specific setting for {@link com.smartgwt.client.data.DataSourceField#getExportForceText
     * DataSourceField.exportForceText}.
     *
     * @param forceText New forceText value. Default value is null
     * @return {@link com.smartgwt.client.data.TextExportSettings TextExportSettings} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public TextExportSettings setForceText(ForceTextApproach forceText)  throws IllegalStateException {
        return (TextExportSettings)setAttribute("forceText", forceText == null ? null : forceText.getValue(), false);
    }

    /**
     * If set, all text fields will use the indicated {@link com.smartgwt.client.types.ForceTextApproach} unless they have a
     * specific setting for {@link com.smartgwt.client.data.DataSourceField#getExportForceText
     * DataSourceField.exportForceText}.
     *
     * @return Current forceText value. Default value is null
     */
    public ForceTextApproach getForceText()  {
        return EnumUtil.getEnum(ForceTextApproach.values(), getAttribute("forceText"));
    }
    

    /**
     * Separator between Records.  Default is a newline character ("\n").
     *
     * @param lineSeparator New lineSeparator value. Default value is "\n"
     * @return {@link com.smartgwt.client.data.TextExportSettings TextExportSettings} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public TextExportSettings setLineSeparator(String lineSeparator)  throws IllegalStateException {
        return (TextExportSettings)setAttribute("lineSeparator", lineSeparator, false);
    }

    /**
     * Separator between Records.  Default is a newline character ("\n").
     *
     * @return Current lineSeparator value. Default value is "\n"
     */
    public String getLineSeparator()  {
        return getAttributeAsString("lineSeparator");
    }
    

    /**
     * Text to export for a field with a null value.  If this property is null, then null fields will be assumed to have the
     * default value for their field type.
     *
     * @param nullValueText New nullValueText value. Default value is ""
     * @return {@link com.smartgwt.client.data.TextExportSettings TextExportSettings} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public TextExportSettings setNullValueText(String nullValueText)  throws IllegalStateException {
        return (TextExportSettings)setAttribute("nullValueText", nullValueText, false);
    }

    /**
     * Text to export for a field with a null value.  If this property is null, then null fields will be assumed to have the
     * default value for their field type.
     *
     * @return Current nullValueText value. Default value is ""
     */
    public String getNullValueText()  {
        return getAttributeAsString("nullValueText");
    }
    

    /**
     * Whether to surround each value with quotes ("").
     *
     * @param quoteValues New quoteValues value. Default value is true
     * @return {@link com.smartgwt.client.data.TextExportSettings TextExportSettings} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public TextExportSettings setQuoteValues(Boolean quoteValues)  throws IllegalStateException {
        return (TextExportSettings)setAttribute("quoteValues", quoteValues, false);
    }

    /**
     * Whether to surround each value with quotes ("").
     *
     * @return Current quoteValues value. Default value is true
     */
    public Boolean getQuoteValues()  {
        Boolean result = getAttributeAsBoolean("quoteValues");
        return result == null ? true : result;
    }
    

    /**
     * Format to use when outputting time values.  Default is 24 hour time.
     *
     * @param timeFormat New timeFormat value. Default value is null
     * @return {@link com.smartgwt.client.data.TextExportSettings TextExportSettings} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public TextExportSettings setTimeFormat(TimeDisplayFormat timeFormat)  throws IllegalStateException {
        return (TextExportSettings)setAttribute("timeFormat", timeFormat == null ? null : timeFormat.getValue(), false);
    }

    /**
     * Format to use when outputting time values.  Default is 24 hour time.
     *
     * @return Current timeFormat value. Default value is null
     */
    public TimeDisplayFormat getTimeFormat()  {
        return EnumUtil.getEnum(TimeDisplayFormat.values(), getAttribute("timeFormat"));
    }
    

    /**
     * Whether to convert each field's value to the corresponding display value for export.  Default of false will directly
     * export the field's value.
     *
     * @param useDisplayValue New useDisplayValue value. Default value is false
     * @return {@link com.smartgwt.client.data.TextExportSettings TextExportSettings} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public TextExportSettings setUseDisplayValue(Boolean useDisplayValue)  throws IllegalStateException {
        return (TextExportSettings)setAttribute("useDisplayValue", useDisplayValue, false);
    }

    /**
     * Whether to convert each field's value to the corresponding display value for export.  Default of false will directly
     * export the field's value.
     *
     * @return Current useDisplayValue value. Default value is false
     */
    public Boolean getUseDisplayValue()  {
        Boolean result = getAttributeAsBoolean("useDisplayValue");
        return result == null ? false : result;
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
