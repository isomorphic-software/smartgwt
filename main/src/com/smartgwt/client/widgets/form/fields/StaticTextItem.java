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
 * A FormItem that displays an uneditable value.
 */
public class StaticTextItem extends FormItem {

    public static StaticTextItem getOrCreateRef(JavaScriptObject jsObj) {

        if(jsObj == null) return null;

        RefDataClass obj = RefDataClass.getRef(jsObj);

		if(obj != null && JSOHelper.getAttribute(jsObj,"__ref")==null) {
            return com.smartgwt.client.util.ObjectFactory.createFormItem("StaticTextItem",jsObj);

        } else
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (StaticTextItem) obj;
        } else {
            return new StaticTextItem(jsObj);
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
        $wnd.isc["StaticTextItem"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
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
        $wnd.isc["StaticTextItem"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;

    public StaticTextItem(){
        setAttribute("editorType", "StaticTextItem");
    }

    public StaticTextItem(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
        
    }

    public StaticTextItem(String name) {
        setName(name);
        setAttribute("editorType", "StaticTextItem");
    }

    public StaticTextItem(String name, String title) {
        setName(name);
		setTitle(title);
        setAttribute("editorType", "StaticTextItem");
    }


    // ********************* Properties / Attributes ***********************


    /**
     * Should the user be able to select the text in this item?
     *
     * @param canSelectText canSelectText Default value is true
     */
    public void setCanSelectText(boolean canSelectText) {
        setAttribute("canSelectText", canSelectText);
    }

    /**
     * Should the user be able to select the text in this item?
     *
     * @return boolean
     */
    public boolean getCanSelectText()  {
        return getAttributeAsBoolean("canSelectText");
    }


    /**
     * If true, text that exceeds the specified size of the form item will be clipped.
     *
     * @param clipValue clipValue Default value is false
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setClipValue(Boolean clipValue) {
        setAttribute("clipValue", clipValue);
    }

    /**
     * If true, text that exceeds the specified size of the form item will be clipped.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getClipValue()  {
        return getAttributeAsBoolean("clipValue");
    }


    /**
     * Display format to use for date type values within this formItem. <P> Note that Fields of type <code>"date"</code>,
     * <code>"datetime"</code> or <code>"time"</code> will be edited using a {@link
     * com.smartgwt.client.widgets.form.fields.DateItem} or {@link com.smartgwt.client.widgets.form.fields.TimeItem} by
     * default, but  this can be overridden - for <code>canEdit:false</code> fields, a {@link
     * com.smartgwt.client.widgets.form.fields.StaticTextItem} is used by default, and the developer can always specify  a
     * custom {@link com.smartgwt.client.widgets.form.fields.FormItem#getEditorType editorType} as well as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getType data type}. <P> The {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTimeFormatter timeFormatter} may also be used to format underlying
     * Date values as times (ommitting the date part entirely). If both <code>dateFormatter</code> and
     * <code>timeFormatter</code> are specified on an item, for fields specified as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getType type "time"} the <code>timeFormatter</code> will be used,
     * otherwise the <code>dateFormatter</code> <P> If <code>item.dateFormatter</code> and <code>item.timeFormatter</code> is
     * unspecified, date display format may be defined at the component level via {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getDateFormatter dateFormatter}, or for fields of type
     * <code>"datetime"</code> {@link com.smartgwt.client.widgets.form.DynamicForm#getDatetimeFormatter datetimeFormatter}.
     * Otherwise for fields of type "date", default is to use the system-wide default short date format, configured via {@link
     * com.smartgwt.client.util.Date#setShortDisplayFormat Date.setShortDisplayFormat}. For fields of type "datetime" or for
     * Date values in fields whose type does not inherit from the logical "date" type, default is to use the system-wide normal
     * date format configured via {@link com.smartgwt.client.util.Date#setNormalDisplayFormat Date.setNormalDisplayFormat} 
     * (using "toNormalDate()" on logical <code>"date"</code> type fields is not desirable as this would display the time
     * component of the date object to the user).<br> Specify any valid {@link com.smartgwt.client.types.DateDisplayFormat} to 
     * change the format used by this item.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param dateFormatter dateFormatter Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setTimeFormatter
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setDateFormatter(DateDisplayFormat dateFormatter) {
        setAttribute("dateFormatter", dateFormatter == null ? null : dateFormatter.getValue());
    }

    /**
     * Display format to use for date type values within this formItem. <P> Note that Fields of type <code>"date"</code>,
     * <code>"datetime"</code> or <code>"time"</code> will be edited using a {@link
     * com.smartgwt.client.widgets.form.fields.DateItem} or {@link com.smartgwt.client.widgets.form.fields.TimeItem} by
     * default, but  this can be overridden - for <code>canEdit:false</code> fields, a {@link
     * com.smartgwt.client.widgets.form.fields.StaticTextItem} is used by default, and the developer can always specify  a
     * custom {@link com.smartgwt.client.widgets.form.fields.FormItem#getEditorType editorType} as well as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getType data type}. <P> The {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTimeFormatter timeFormatter} may also be used to format underlying
     * Date values as times (ommitting the date part entirely). If both <code>dateFormatter</code> and
     * <code>timeFormatter</code> are specified on an item, for fields specified as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getType type "time"} the <code>timeFormatter</code> will be used,
     * otherwise the <code>dateFormatter</code> <P> If <code>item.dateFormatter</code> and <code>item.timeFormatter</code> is
     * unspecified, date display format may be defined at the component level via {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getDateFormatter dateFormatter}, or for fields of type
     * <code>"datetime"</code> {@link com.smartgwt.client.widgets.form.DynamicForm#getDatetimeFormatter datetimeFormatter}.
     * Otherwise for fields of type "date", default is to use the system-wide default short date format, configured via {@link
     * com.smartgwt.client.util.Date#setShortDisplayFormat Date.setShortDisplayFormat}. For fields of type "datetime" or for
     * Date values in fields whose type does not inherit from the logical "date" type, default is to use the system-wide normal
     * date format configured via {@link com.smartgwt.client.util.Date#setNormalDisplayFormat Date.setNormalDisplayFormat} 
     * (using "toNormalDate()" on logical <code>"date"</code> type fields is not desirable as this would display the time
     * component of the date object to the user).<br> Specify any valid {@link com.smartgwt.client.types.DateDisplayFormat} to 
     * change the format used by this item.
     *
     * @return DateDisplayFormat
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getTimeFormatter
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public DateDisplayFormat getDateFormatter()  {
        return EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("dateFormatter"));
    }


    /**
     * By default HTML values in a staticTextItem will be interpreted by the browser. Setting this flag to true causes HTML
     * characters to be escaped, meaning the raw value of the field (for example <code>"&lt;b&gt;AAA&lt;/b&gt;"</code>) is
     * displayed to the user rather than the interpreted HTML (for example <code>"<b>AAA</b>"</code>)
     *
     * @param escapeHTML escapeHTML Default value is false
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setEscapeHTML(Boolean escapeHTML) {
        setAttribute("escapeHTML", escapeHTML);
    }

    /**
     * By default HTML values in a staticTextItem will be interpreted by the browser. Setting this flag to true causes HTML
     * characters to be escaped, meaning the raw value of the field (for example <code>"&lt;b&gt;AAA&lt;/b&gt;"</code>) is
     * displayed to the user rather than the interpreted HTML (for example <code>"<b>AAA</b>"</code>)
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getEscapeHTML()  {
        return getAttributeAsBoolean("escapeHTML");
    }



    /**
     * Base CSS class for this item
     *
     * @param textBoxStyle . See {@link com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle}. Default value is "staticTextItem"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setTextBoxStyle(String textBoxStyle) {
        setAttribute("textBoxStyle", textBoxStyle);
    }

    /**
     * Base CSS class for this item
     *
     * @return . See {@link com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle}
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getTextBoxStyle()  {
        return getAttributeAsString("textBoxStyle");
    }


    /**
     * If true, item contents can wrap. If false, all the contents should appear on a single line.
     *
     * @param wrap wrap Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setWrap(Boolean wrap) {
        setAttribute("wrap", wrap);
    }

    /**
     * If true, item contents can wrap. If false, all the contents should appear on a single line.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getWrap()  {
        return getAttributeAsBoolean("wrap");
    }

    // ********************* Methods ***********************

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
     * @param staticTextItemProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(StaticTextItem staticTextItemProperties) /*-{
    	var properties = $wnd.isc.addProperties({},staticTextItemProperties.@com.smartgwt.client.core.RefDataClass::getJsObj()());
    	delete properties.ID;
        $wnd.isc.StaticTextItem.addProperties(properties);
    }-*/;

    // ***********************************************************

}


