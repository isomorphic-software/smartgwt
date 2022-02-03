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
import com.smartgwt.client.data.Record;
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

import com.google.gwt.event.shared.*;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.smartgwt.client.util.workflow.Process; // required to override java.lang.Process


/**
 * FormItem for showing a header within a DynamicForm. <p> Set the <code>defaultValue</code> of this item to the HTML you
 * want to embed in the form.
 */
@BeanFactory.FrameworkClass
public class HeaderItem extends FormItem {

    public static HeaderItem getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof HeaderItem) {
            existingObj.setJsObj(jsObj);
            return (HeaderItem)existingObj;
        } else

        {
            return new HeaderItem(jsObj);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(HeaderItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.HeaderItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(HeaderItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.HeaderItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public static native void changePickerIconDefaults(FormItemIcon defaults) /*-{
        $wnd.isc.HeaderItem.changeDefaults("pickerIconDefaults", defaults.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public HeaderItem(){
        setAttribute("editorType", "HeaderItem");
    }

    public HeaderItem(JavaScriptObject jsObj){
        super(jsObj);
    }


    public HeaderItem(String name) {
        setName(name);
                setAttribute("editorType", "HeaderItem");
    }


    public HeaderItem(String name, String title) {
        setName(name);
		setTitle(title);
                setAttribute("editorType", "HeaderItem");
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Alignment of this <code>HeaderItem</code> in its cell. <p> Note: Because a <code>HeaderItem</code> fills its cell by
     * default, if the {@link com.smartgwt.client.widgets.form.fields.HeaderItem#getApplyAlignToText applyAlignToText} setting
     * is changed to false, then the {@link com.smartgwt.client.widgets.form.fields.FormItem#getTextAlign textAlign} setting
     * (rather than the <code>align</code> setting) of this <code>HeaderItem</code> should be used to control the alignment of
     * the header text.
     *
     * @param align New align value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.HeaderItem HeaderItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setApplyAlignToText
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public HeaderItem setAlign(Alignment align) {
        return (HeaderItem)setAttribute("align", align == null ? null : align.getValue());
    }

    /**
     * Alignment of this <code>HeaderItem</code> in its cell. <p> Note: Because a <code>HeaderItem</code> fills its cell by
     * default, if the {@link com.smartgwt.client.widgets.form.fields.HeaderItem#getApplyAlignToText applyAlignToText} setting
     * is changed to false, then the {@link com.smartgwt.client.widgets.form.fields.FormItem#getTextAlign textAlign} setting
     * (rather than the <code>align</code> setting) of this <code>HeaderItem</code> should be used to control the alignment of
     * the header text.
     *
     * @return Current align value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getApplyAlignToText
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Alignment getAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("align"));
    }
    

    /**
     * If the {@link com.smartgwt.client.widgets.form.fields.FormItem#getTextAlign textAlign} is unset, should the {@link
     * com.smartgwt.client.widgets.form.fields.HeaderItem#getAlign align} setting, if set, be used for this
     * <code>HeaderItem</code>'s <code>textAlign</code>?
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param applyAlignToText New applyAlignToText value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.HeaderItem HeaderItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public HeaderItem setApplyAlignToText(boolean applyAlignToText) {
        return (HeaderItem)setAttribute("applyAlignToText", applyAlignToText);
    }

    /**
     * If the {@link com.smartgwt.client.widgets.form.fields.FormItem#getTextAlign textAlign} is unset, should the {@link
     * com.smartgwt.client.widgets.form.fields.HeaderItem#getAlign align} setting, if set, be used for this
     * <code>HeaderItem</code>'s <code>textAlign</code>?
     *
     * @return Current applyAlignToText value. Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public boolean getApplyAlignToText()  {
        Boolean result = getAttributeAsBoolean("applyAlignToText", true);
        return result == null ? true : result;
    }
    

    /**
     * Should the user be able to select the text in this item?
     *
     * @param canSelectText New canSelectText value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.HeaderItem HeaderItem} instance, for chaining setter calls
     */
    public HeaderItem setCanSelectText(boolean canSelectText) {
        return (HeaderItem)setAttribute("canSelectText", canSelectText);
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
     * by default, headers span all remaining columns
     *
     * @param colSpan New colSpan value. Default value is "*"
     * @return {@link com.smartgwt.client.widgets.form.fields.HeaderItem HeaderItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public HeaderItem setColSpan(int colSpan) {
        return (HeaderItem)setAttribute("colSpan", colSpan);
    }

    /**
     * by default, headers span all remaining columns
     *
     * <p><b>Note :</b> This method will return -1 if the underlying SmartClient JavaScript
     * attribute value cannot be expressed as a(n) int.  In that case, other
     * getters,  similarly-named but ending in <code>AsString</code>, <code>AsCanvas</code>,
     * etc., may be provided.
     *
     * @return Current colSpan value. Default value is "*"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getColSpan()  {
        if (!(getAttributeAsObject("colSpan") instanceof Integer)) { return -1; }
        return getAttributeAsInt("colSpan");
    }

    /**
     * by default, headers span all remaining columns
     *
     * @param colSpan New colSpan value. Default value is "*"
     * @return {@link com.smartgwt.client.widgets.form.fields.HeaderItem HeaderItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public HeaderItem setColSpan(String colSpan) {
        return (HeaderItem)setAttribute("colSpan", colSpan);
    }

    /**
     * by default, headers span all remaining columns
     *
     * @return Current colSpan value. Default value is "*"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getColSpanAsString()  {
        return getAttributeAsString("colSpan");
    }
    

    /**
     * Header text
     *
     * @param defaultValue New defaultValue value. Default value is "Header"
     * @return {@link com.smartgwt.client.widgets.form.fields.HeaderItem HeaderItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public HeaderItem setDefaultValue(String defaultValue) {
        return (HeaderItem)setAttribute("defaultValue", defaultValue);
    }

    /**
     * Header text
     *
     * @return Current defaultValue value. Default value is "Header"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getDefaultValue()  {
        return getAttributeAsString("defaultValue");
    }
    

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @param editProxyConstructor New editProxyConstructor value. Default value is "TextItemEditProxy"
     * @return {@link com.smartgwt.client.widgets.form.fields.HeaderItem HeaderItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public HeaderItem setEditProxyConstructor(String editProxyConstructor) {
        return (HeaderItem)setAttribute("editProxyConstructor", editProxyConstructor);
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
     * these items are in a row by themselves by default
     *
     * @param endRow New endRow value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.HeaderItem HeaderItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public HeaderItem setEndRow(Boolean endRow) {
        return (HeaderItem)setAttribute("endRow", endRow);
    }

    /**
     * these items are in a row by themselves by default
     *
     * @return Current endRow value. Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getEndRow()  {
        Boolean result = getAttributeAsBoolean("endRow", true);
        return result == null ? true : result;
    }
    

    /**
     * Don't show a separate title cell for headers
     *
     * @param showTitle New showTitle value. Default value is false
     * @return {@link com.smartgwt.client.widgets.form.fields.HeaderItem HeaderItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public HeaderItem setShowTitle(Boolean showTitle) {
        return (HeaderItem)setAttribute("showTitle", showTitle);
    }

    /**
     * Don't show a separate title cell for headers
     *
     * @return Current showTitle value. Default value is false
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowTitle()  {
        Boolean result = getAttributeAsBoolean("showTitle", true);
        return result == null ? false : result;
    }
    

    /**
     * these items are in a row by themselves by default
     *
     * @param startRow New startRow value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.HeaderItem HeaderItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public HeaderItem setStartRow(Boolean startRow) {
        return (HeaderItem)setAttribute("startRow", startRow);
    }

    /**
     * these items are in a row by themselves by default
     *
     * @return Current startRow value. Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getStartRow()  {
        Boolean result = getAttributeAsBoolean("startRow", true);
        return result == null ? true : result;
    }
    

    /**
     * Base CSS class for this item
     *
     * @param textBoxStyle New textBoxStyle value. Default value is "headerItem"
     * @return {@link com.smartgwt.client.widgets.form.fields.HeaderItem HeaderItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public HeaderItem setTextBoxStyle(String textBoxStyle) {
        return (HeaderItem)setAttribute("textBoxStyle", textBoxStyle);
    }

    /**
     * Base CSS class for this item
     *
     * @return Current textBoxStyle value. Default value is "headerItem"
     * @see com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getTextBoxStyle()  {
        return getAttributeAsString("textBoxStyle");
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
     * @param headerItemProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(HeaderItem headerItemProperties) /*-{
        if (headerItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(HeaderItem.@java.lang.Object::getClass()(), "setDefaultProperties", headerItemProperties.@java.lang.Object::getClass()());
        }
        headerItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var properties = headerItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::getConfig()();
        $wnd.isc.HeaderItem.addProperties(properties);
    }-*/;

    // ***********************************************************

}
