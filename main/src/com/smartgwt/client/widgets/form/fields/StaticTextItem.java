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
 
package com.smartgwt.client.widgets.form.fields;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
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
import com.smartgwt.client.widgets.drawing.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * A FormItem that displays an uneditable value.
 */
@BeanFactory.FrameworkClass
public class StaticTextItem extends FormItem {

    public static StaticTextItem getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof StaticTextItem) {
            existingObj.setJsObj(jsObj);
            return (StaticTextItem)existingObj;
        } else

        {
            return new StaticTextItem(jsObj);
        }
    }
        


    /**
     * Changes the defaults for Canvas AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults Canvas defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(StaticTextItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.StaticTextItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    /**
     * Changes the defaults for FormItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults FormItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, FormItem defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(StaticTextItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.StaticTextItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public static native void changePickerIconDefaults(FormItemIcon defaults) /*-{
        $wnd.isc.StaticTextItem.changeDefaults("pickerIconDefaults", defaults.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public StaticTextItem(){
        setAttribute("editorType", "StaticTextItem");
    }

    public StaticTextItem(JavaScriptObject jsObj){
        super(jsObj);
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
     * If the {@link com.smartgwt.client.widgets.form.fields.FormItem#getTextAlign textAlign} is unset, should the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getAlign align} setting, if set, be used for this
     * <code>StaticTextItem</code>'s <code>textAlign</code>?
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param applyAlignToText New applyAlignToText value. Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setApplyAlignToText(boolean applyAlignToText) {
        setAttribute("applyAlignToText", applyAlignToText);
    }

    /**
     * If the {@link com.smartgwt.client.widgets.form.fields.FormItem#getTextAlign textAlign} is unset, should the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getAlign align} setting, if set, be used for this
     * <code>StaticTextItem</code>'s <code>textAlign</code>?
     *
     * @return Current applyAlignToText value. Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public boolean getApplyAlignToText()  {
        Boolean result = getAttributeAsBoolean("applyAlignToText", true);
        return result == null ? true : result;
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getHeight FormItem.height} is specified, should it be applied
     * to the item's text box element? <P> Overridden to be <code>false</code> for StaticTextItems by default. <P> See {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#shouldApplyHeightToTextBox shouldApplyHeightToTextBox()} for more
     * information.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param applyHeightToTextBox New applyHeightToTextBox value. Default value is false
     */
    public void setApplyHeightToTextBox(Boolean applyHeightToTextBox) {
        setAttribute("applyHeightToTextBox", applyHeightToTextBox);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getHeight FormItem.height} is specified, should it be applied
     * to the item's text box element? <P> Overridden to be <code>false</code> for StaticTextItems by default. <P> See {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#shouldApplyHeightToTextBox shouldApplyHeightToTextBox()} for more
     * information.
     *
     * @return Current applyHeightToTextBox value. Default value is false
     */
    public Boolean getApplyHeightToTextBox()  {
        Boolean result = getAttributeAsBoolean("applyHeightToTextBox", true);
        return result == null ? false : result;
    }
    

    /**
     * Should the user be able to select the text in this item?
     *
     * @param canSelectText New canSelectText value. Default value is true
     */
    public void setCanSelectText(boolean canSelectText) {
        setAttribute("canSelectText", canSelectText);
    }

    /**
     * Should the user be able to select the text in this item?
     *
     * @return Current canSelectText value. Default value is true
     */
    public boolean getCanSelectText()  {
        Boolean result = getAttributeAsBoolean("canSelectText", true);
        return result == null ? true : result;
    }
    

    /**
     * If true, text that exceeds the specified size of the form item will be clipped.
     *
     * @param clipValue New clipValue value. Default value is false
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setClipValue(Boolean clipValue) {
        setAttribute("clipValue", clipValue);
    }

    /**
     * If true, text that exceeds the specified size of the form item will be clipped.
     *
     * @return Current clipValue value. Default value is false
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getClipValue()  {
        Boolean result = getAttributeAsBoolean("clipValue", true);
        return result == null ? false : result;
    }
    

    /**
     * Display format to use for date type values within this formItem. <P> Note that Fields of type <code>"date"</code>,
     * <code>"datetime"</code> or <code>"time"</code> will be edited using a {@link
     * com.smartgwt.client.widgets.form.fields.DateItem} or {@link com.smartgwt.client.widgets.form.fields.TimeItem} by
     * default, but  this can be overridden - for <code>canEdit:false</code> fields, a {@link
     * com.smartgwt.client.widgets.form.fields.StaticTextItem} is used by default, and the developer can always specify  a
     * custom {@link com.smartgwt.client.widgets.form.fields.FormItem#getEditorType FormItem.editorType} as well as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getType data type}. <P> The {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTimeFormatter FormItem.timeFormatter} may also be used to format
     * underlying Date values as times (ommitting the date part entirely). If both <code>dateFormatter</code> and
     * <code>timeFormatter</code> are specified on an item, for fields specified as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getType type "time"} the <code>timeFormatter</code> will be used,
     * otherwise the <code>dateFormatter</code> <P> If <code>item.dateFormatter</code> and <code>item.timeFormatter</code> is
     * unspecified, date display format may be defined at the component level via {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getDateFormatter DynamicForm.dateFormatter}, or for fields of type
     * <code>"datetime"</code> {@link com.smartgwt.client.widgets.form.DynamicForm#getDatetimeFormatter
     * DynamicForm.datetimeFormatter}. Otherwise for fields of type "date", default is to use the system-wide default short
     * date format, configured via {@link com.smartgwt.client.util.DateUtil#setShortDisplayFormat
     * DateUtil.setShortDisplayFormat()}. For fields of type "datetime" or for Date values in fields whose type does not
     * inherit from the logical "date" type, default is to use the system-wide normal date format configured via {@link
     * com.smartgwt.client.util.DateUtil#setNormalDisplayFormat DateUtil.setNormalDisplayFormat()}  (using "toNormalDate()" on
     * logical <code>"date"</code> type fields is not desirable as this would display the time component of the date object to
     * the user).<br> Specify any valid {@link com.smartgwt.client.types.DateDisplayFormat} to  change the format used by this
     * item.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param dateFormatter New dateFormatter value. Default value is null
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
     * custom {@link com.smartgwt.client.widgets.form.fields.FormItem#getEditorType FormItem.editorType} as well as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getType data type}. <P> The {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTimeFormatter FormItem.timeFormatter} may also be used to format
     * underlying Date values as times (ommitting the date part entirely). If both <code>dateFormatter</code> and
     * <code>timeFormatter</code> are specified on an item, for fields specified as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getType type "time"} the <code>timeFormatter</code> will be used,
     * otherwise the <code>dateFormatter</code> <P> If <code>item.dateFormatter</code> and <code>item.timeFormatter</code> is
     * unspecified, date display format may be defined at the component level via {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getDateFormatter DynamicForm.dateFormatter}, or for fields of type
     * <code>"datetime"</code> {@link com.smartgwt.client.widgets.form.DynamicForm#getDatetimeFormatter
     * DynamicForm.datetimeFormatter}. Otherwise for fields of type "date", default is to use the system-wide default short
     * date format, configured via {@link com.smartgwt.client.util.DateUtil#setShortDisplayFormat
     * DateUtil.setShortDisplayFormat()}. For fields of type "datetime" or for Date values in fields whose type does not
     * inherit from the logical "date" type, default is to use the system-wide normal date format configured via {@link
     * com.smartgwt.client.util.DateUtil#setNormalDisplayFormat DateUtil.setNormalDisplayFormat()}  (using "toNormalDate()" on
     * logical <code>"date"</code> type fields is not desirable as this would display the time component of the date object to
     * the user).<br> Specify any valid {@link com.smartgwt.client.types.DateDisplayFormat} to  change the format used by this
     * item.
     *
     * @return Current dateFormatter value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getTimeFormatter
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public DateDisplayFormat getDateFormatter()  {
        return EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("dateFormatter"));
    }
    

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @param editProxyConstructor New editProxyConstructor value. Default value is "TextItemEditProxy"
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public void setEditProxyConstructor(String editProxyConstructor) {
        setAttribute("editProxyConstructor", editProxyConstructor);
    }

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @return Current editProxyConstructor value. Default value is "TextItemEditProxy"
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public String getEditProxyConstructor()  {
        return getAttributeAsString("editProxyConstructor");
    }
    

    /**
     * By default HTML values in a staticTextItem will be interpreted by the browser. Setting this flag to true causes HTML
     * characters to be escaped, meaning the raw value of the field (for example <code>"&lt;b&gt;AAA&lt;/b&gt;"</code>) is
     * displayed to the user rather than the interpreted HTML (for example <code>"<b>AAA</b>"</code>)
     *
     * @param escapeHTML New escapeHTML value. Default value is false
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
     * @return Current escapeHTML value. Default value is false
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getEscapeHTML()  {
        Boolean result = getAttributeAsBoolean("escapeHTML", true);
        return result == null ? false : result;
    }
    
    

    /**
     * Base CSS class for this item
     *
     * @param textBoxStyle New textBoxStyle value. Default value is "staticTextItem"
     * @see com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setTextBoxStyle(String textBoxStyle) {
        setAttribute("textBoxStyle", textBoxStyle);
    }

    /**
     * Base CSS class for this item
     *
     * @return Current textBoxStyle value. Default value is "staticTextItem"
     * @see com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getTextBoxStyle()  {
        return getAttributeAsString("textBoxStyle");
    }
    

    /**
     * If true, item contents can wrap. If false, all the contents should appear on a single line.
     *
     * @param wrap New wrap value. Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setWrap(Boolean wrap) {
        setAttribute("wrap", wrap);
    }

    /**
     * If true, item contents can wrap. If false, all the contents should appear on a single line.
     *
     * @return Current wrap value. Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getWrap()  {
        Boolean result = getAttributeAsBoolean("wrap", true);
        return result == null ? true : result;
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    /** 
     * Class level method to set the default properties of this class.  If set, then all
     * existing and subsequently created instances of this class will automatically have
     * default properties corresponding to
     * the properties of the class instance passed to this function.
     * This is a powerful feature that eliminates the need for users to create a separate
     * hierarchy of subclasses that only alter the default properties of this class. Can also
     * be used for skinning / styling purposes.  <P> <b>Note:</b> This method is intended for
     * setting default attributes only and will affect all instances of the underlying class
     * (including those automatically generated in JavaScript).  This method should not be used
     * to apply standard EventHandlers or override methods for a class - use a custom subclass
     * instead.  Calling this method after instances have been created can result in undefined
     * behavior, since it bypasses any setters and a class instance may have already examined 
     * a particular property and not be expecting any changes through this route.
     *
     * @param staticTextItemProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(StaticTextItem staticTextItemProperties) /*-{
        if (staticTextItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(StaticTextItem.@java.lang.Object::getClass()(), "setDefaultProperties", staticTextItemProperties.@java.lang.Object::getClass()());
        }
        staticTextItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var properties = staticTextItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::getConfig()();
        $wnd.isc.StaticTextItem.addProperties(properties);
    }-*/;

    // ***********************************************************

}
