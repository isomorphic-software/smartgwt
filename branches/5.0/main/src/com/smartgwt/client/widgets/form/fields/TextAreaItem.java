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
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
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
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Class for editable multi-line text areas (uses HTML <code>&lt;TEXTAREA&gt;</code> object)
 */
@BeanFactory.FrameworkClass
public class TextAreaItem extends FormItem {

    public static TextAreaItem getOrCreateRef(JavaScriptObject jsObj) {

        if(jsObj == null) return null;

        RefDataClass obj = RefDataClass.getRef(jsObj);

		if(obj != null && JSOHelper.getAttribute(jsObj,"__ref")==null) {
            return com.smartgwt.client.util.ObjectFactory.createFormItem("TextAreaItem",jsObj);

        } else
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (TextAreaItem) obj;
        } else {
            return new TextAreaItem(jsObj);
        }
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
        $wnd.isc.TextAreaItem.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
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
        $wnd.isc.TextAreaItem.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;
    /**
     * Changes the defaults for DrawItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults DrawItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, DrawItem defaults) /*-{
        $wnd.isc.TextAreaItem.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.drawing.DrawItem::getJsObj()());
    }-*/;

    public static native void changePickerIconDefaults(FormItemIcon defaults) /*-{
        $wnd.isc.TextAreaItem.changeDefaults("pickerIconDefaults", defaults.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public TextAreaItem(){
        setAttribute("editorType", "TextAreaItem");
    }

    public TextAreaItem(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    public TextAreaItem(String name) {
        setName(name);
                setAttribute("editorType", "TextAreaItem");
    }


    public TextAreaItem(String name, String title) {
        setName(name);
		setTitle(title);
                setAttribute("editorType", "TextAreaItem");
    }


    // ********************* Properties / Attributes ***********************

    /**
     * 
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param browserAutoCapitalize  Default value is null
     */
    public void setBrowserAutoCapitalize(Boolean browserAutoCapitalize) {
        setAttribute("browserAutoCapitalize", browserAutoCapitalize);
    }

    /**
     * 
     *
     * @return Boolean
     */
    public Boolean getBrowserAutoCapitalize()  {
        return getAttributeAsBoolean("browserAutoCapitalize", true);
    }
    

    /**
     * In Mobile Safari, should automatic correction be offered for text in the item's text box? If <code>null</code>, then
     * Mobile Safari determines automatically whether to enable autocorrect. <p> When enabled, Mobile Safari displays
     * "autocorrect bubbles" to suggest automatic corrections:<br> <img
     * src="data:image/png;base64,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"
     * width="150" height="45" alt="Screenshot of Mobile Safari suggesting &quot;On my way!&quot; to replace &quot;omw&quot;">
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param browserAutoCorrect  Default value is null
     */
    public void setBrowserAutoCorrect(Boolean browserAutoCorrect) {
        setAttribute("browserAutoCorrect", browserAutoCorrect);
    }

    /**
     * In Mobile Safari, should automatic correction be offered for text in the item's text box? If <code>null</code>, then
     * Mobile Safari determines automatically whether to enable autocorrect. <p> When enabled, Mobile Safari displays
     * "autocorrect bubbles" to suggest automatic corrections:<br> <img
     * src="data:image/png;base64,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"
     * width="150" height="45" alt="Screenshot of Mobile Safari suggesting &quot;On my way!&quot; to replace &quot;omw&quot;">
     *
     * @return Boolean
     */
    public Boolean getBrowserAutoCorrect()  {
        return getAttributeAsBoolean("browserAutoCorrect", true);
    }
    

    /**
     * Should this form item fire its {@link com.smartgwt.client.widgets.form.fields.FormItem#addChangeHandler change} handler
     * (and store its value in the form) on every keypress? Set to <code>false</code> to suppress the 'change' handler firing
     * (and the value stored) on every keypress. <p> Note: If <code>false</code>, the value returned by {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValue getValue} will not reflect the value displayed in the form
     * item element as long as focus is in the form item element.
     *
     * @param changeOnKeypress  Default value is true
     */
    public void setChangeOnKeypress(Boolean changeOnKeypress) {
        setAttribute("changeOnKeypress", changeOnKeypress);
    }

    /**
     * Should this form item fire its {@link com.smartgwt.client.widgets.form.fields.FormItem#addChangeHandler change} handler
     * (and store its value in the form) on every keypress? Set to <code>false</code> to suppress the 'change' handler firing
     * (and the value stored) on every keypress. <p> Note: If <code>false</code>, the value returned by {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValue getValue} will not reflect the value displayed in the form
     * item element as long as focus is in the form item element.
     *
     * @return Boolean
     */
    public Boolean getChangeOnKeypress()  {
        Boolean result = getAttributeAsBoolean("changeOnKeypress", true);
        return result == null ? true : result;
    }
    

    /**
     * Default class used to construct {@link com.smartgwt.client.tools.EditProxy} for this component when editMode is enabled.
     *
     * @param editProxyConstructor  See {@link com.smartgwt.client.docs.SCClassName SCClassName} . Default value is "TextAreaItemEditProxy"
     */
    public void setEditProxyConstructor(String editProxyConstructor) {
        setAttribute("editProxyConstructor", editProxyConstructor);
    }

    /**
     * Default class used to construct {@link com.smartgwt.client.tools.EditProxy} for this component when editMode is enabled.
     *
     * @return  See {@link com.smartgwt.client.docs.SCClassName SCClassName} 
     */
    public String getEditProxyConstructor()  {
        return getAttributeAsString("editProxyConstructor");
    }
    
    

    /**
     * If a {@link com.smartgwt.client.widgets.form.fields.TextAreaItem#getLength length} is specified for this item, should
     * user input be limited to the specified length? If set to true, user input and values passed to  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setValue setValue()} will be trimmed to the specified length. Otherwise
     * values exceeding the specified length will raise an error on validation. <P> Note that having this value set to true
     * limits user interactivity in some ways. For example users would be unable to paste a longer string into the field for
     * editing without seeing it be truncated. Given how text areas are typically used to edit longer values than non-wrapping
     * {@link com.smartgwt.client.widgets.form.fields.TextItem}s, this value is false by default for textAreaItems.
     *
     * @param enforceLength  Default value is false
     */
    public void setEnforceLength(boolean enforceLength) {
        setAttribute("enforceLength", enforceLength);
    }

    /**
     * If a {@link com.smartgwt.client.widgets.form.fields.TextAreaItem#getLength length} is specified for this item, should
     * user input be limited to the specified length? If set to true, user input and values passed to  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setValue setValue()} will be trimmed to the specified length. Otherwise
     * values exceeding the specified length will raise an error on validation. <P> Note that having this value set to true
     * limits user interactivity in some ways. For example users would be unable to paste a longer string into the field for
     * editing without seeing it be truncated. Given how text areas are typically used to edit longer values than non-wrapping
     * {@link com.smartgwt.client.widgets.form.fields.TextItem}s, this value is false by default for textAreaItems.
     *
     * @return boolean
     */
    public boolean getEnforceLength()  {
        Boolean result = getAttributeAsBoolean("enforceLength", true);
        return result == null ? false : result;
    }
    

    /**
     * With <code>formatOnBlur</code> enabled, this textAreaItem will format its value according to any specified static {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#formatValue static formatter} as long as the item does not have focus.
     * Once the user puts focus into the item the formatter will be removed. This provides a simply way for developers to show
     * a nicely formatted display value in a freeform text field, without the need for an explicit {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#formatEditorValue FormItem.formatEditorValue}  and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#parseEditorValue FormItem.parseEditorValue} pair.
     *
     * @param formatOnBlur  Default value is false
     */
    public void setFormatOnBlur(Boolean formatOnBlur) {
        setAttribute("formatOnBlur", formatOnBlur);
    }

    /**
     * With <code>formatOnBlur</code> enabled, this textAreaItem will format its value according to any specified static {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#formatValue static formatter} as long as the item does not have focus.
     * Once the user puts focus into the item the formatter will be removed. This provides a simply way for developers to show
     * a nicely formatted display value in a freeform text field, without the need for an explicit {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#formatEditorValue FormItem.formatEditorValue}  and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#parseEditorValue FormItem.parseEditorValue} pair.
     *
     * @return Boolean
     */
    public Boolean getFormatOnBlur()  {
        Boolean result = getAttributeAsBoolean("formatOnBlur", true);
        return result == null ? false : result;
    }
    

    /**
     * Default height of this item <p> Note that when item is rendered as read-only with <code>readOnlyDisplay</code> as
     * "static" the property {@link com.smartgwt.client.widgets.form.fields.FormItem#getStaticHeight staticHeight} is used
     * instead.
     *
     * @param height  Default value is 100
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setHeight(int height) {
        setAttribute("height", height);
    }

    /**
     * Default height of this item <p> Note that when item is rendered as read-only with <code>readOnlyDisplay</code> as
     * "static" the property {@link com.smartgwt.client.widgets.form.fields.FormItem#getStaticHeight staticHeight} is used
     * instead.
     *
     * @return int
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getHeight()  {
        return getAttributeAsInt("height");
    }
    

    /**
     * Align icons with the top edge of text area icons by default.
     *
     * @param iconVAlign  Default value is Canvas.TOP
     */
    public void setIconVAlign(VerticalAlignment iconVAlign) {
        setAttribute("iconVAlign", iconVAlign == null ? null : iconVAlign.getValue());
    }

    /**
     * Align icons with the top edge of text area icons by default.
     *
     * @return VerticalAlignment
     */
    public VerticalAlignment getIconVAlign()  {
        return EnumUtil.getEnum(VerticalAlignment.values(), getAttribute("iconVAlign"));
    }
    

    /**
     * If set, maximum number of characters for this field. If {@link
     * com.smartgwt.client.widgets.form.fields.TextAreaItem#getEnforceLength enforceLength} is set to true, user input will be
     * limited to this value, and values exceeding this length passed to {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setValue setValue()} will be trimmed. Otherwise values exceeding the
     * specified length will raise an error on validation. <P> See also {@link
     * com.smartgwt.client.data.DataSourceField#getLength length}.
     *
     * @param length  Default value is null
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public void setLength(Integer length) {
        setAttribute("length", length);
    }

    /**
     * If set, maximum number of characters for this field. If {@link
     * com.smartgwt.client.widgets.form.fields.TextAreaItem#getEnforceLength enforceLength} is set to true, user input will be
     * limited to this value, and values exceeding this length passed to {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setValue setValue()} will be trimmed. Otherwise values exceeding the
     * specified length will raise an error on validation. <P> See also {@link
     * com.smartgwt.client.data.DataSourceField#getLength length}.
     *
     * @return Integer
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public Integer getLength()  {
        return getAttributeAsInt("length");
    }
    

    /**
     * Minimum valid height for this TextAreaItem in px. If the specified {@link
     * com.smartgwt.client.widgets.form.fields.TextAreaItem#getHeight height} is less than this value, the text area will still
     * render at this height.
     *
     * @param minHeight  Default value is 16
     */
    public void setMinHeight(int minHeight) {
        setAttribute("minHeight", minHeight);
    }

    /**
     * Minimum valid height for this TextAreaItem in px. If the specified {@link
     * com.smartgwt.client.widgets.form.fields.TextAreaItem#getHeight height} is less than this value, the text area will still
     * render at this height.
     *
     * @return int
     */
    public int getMinHeight()  {
        return getAttributeAsInt("minHeight");
    }
    

    /**
     * When generating a print-view of the component containing this TextArea, should the form item expand to accommodate its
     * value? If set to false the text box not expand to fit its content in the print view, instead showing exactly as it does
     * in the live form, possibly with scrollbars.
     *
     * @param printFullText  Default value is true
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public void setPrintFullText(Boolean printFullText) {
        setAttribute("printFullText", printFullText);
    }

    /**
     * When generating a print-view of the component containing this TextArea, should the form item expand to accommodate its
     * value? If set to false the text box not expand to fit its content in the print view, instead showing exactly as it does
     * in the live form, possibly with scrollbars.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public Boolean getPrintFullText()  {
        Boolean result = getAttributeAsBoolean("printFullText", true);
        return result == null ? true : result;
    }
    

    /**
     * Allows the {@link com.smartgwt.client.widgets.form.DynamicForm#getSelectOnClick selectOnClick} behavior to be configured
     * on a per-FormItem basis.  Normally all items in a form default to the value of {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getSelectOnClick selectOnClick}.
     *
     * @param selectOnClick  Default value is null
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public void setSelectOnClick(Boolean selectOnClick) {
        setAttribute("selectOnClick", selectOnClick);
    }

    /**
     * Allows the {@link com.smartgwt.client.widgets.form.DynamicForm#getSelectOnClick selectOnClick} behavior to be configured
     * on a per-FormItem basis.  Normally all items in a form default to the value of {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getSelectOnClick selectOnClick}.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public Boolean getSelectOnClick()  {
        return getAttributeAsBoolean("selectOnClick", true);
    }
    

    /**
     * Allows the {@link com.smartgwt.client.widgets.form.DynamicForm#getSelectOnFocus selectOnFocus} behavior to be configured
     * on a per-FormItem basis.  Normally all items in a form default to the value of {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getSelectOnFocus selectOnFocus}.
     *
     * @param selectOnFocus  Default value is null
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public void setSelectOnFocus(Boolean selectOnFocus) {
        setAttribute("selectOnFocus", selectOnFocus);
    }

    /**
     * Allows the {@link com.smartgwt.client.widgets.form.DynamicForm#getSelectOnFocus selectOnFocus} behavior to be configured
     * on a per-FormItem basis.  Normally all items in a form default to the value of {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getSelectOnFocus selectOnFocus}.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public Boolean getSelectOnFocus()  {
        return getAttributeAsBoolean("selectOnFocus", true);
    }
    

    /**
     * If showing hint for this form item, should it be shown within the field? <P>CSS style for the hint is {@link
     * com.smartgwt.client.widgets.form.fields.TextAreaItem#getTextBoxStyle textBoxStyle} with the suffix "Hint" appended to
     * it.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showHintInField  Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setHint
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setShowHintInField(Boolean showHintInField) {
        setAttribute("showHintInField", showHintInField);
    }

    /**
     * If showing hint for this form item, should it be shown within the field? <P>CSS style for the hint is {@link
     * com.smartgwt.client.widgets.form.fields.TextAreaItem#getTextBoxStyle textBoxStyle} with the suffix "Hint" appended to
     * it.
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getHint
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowHintInField()  {
        return getAttributeAsBoolean("showHintInField", true);
    }
    

    /**
     * Height of the FormItem when <code>canEdit</code> is false and <code>readOnlyDisplay</code> is "static". The normal
     * {@link com.smartgwt.client.widgets.form.fields.TextAreaItem#getHeight height} is used if this property is not set.
     *
     * @param staticHeight  Default value is 1
     * @see com.smartgwt.client.widgets.form.fields.TextAreaItem#setHeight
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public void setStaticHeight(Integer staticHeight) {
        setAttribute("staticHeight", staticHeight);
    }

    /**
     * Height of the FormItem when <code>canEdit</code> is false and <code>readOnlyDisplay</code> is "static". The normal
     * {@link com.smartgwt.client.widgets.form.fields.TextAreaItem#getHeight height} is used if this property is not set.
     *
     * @return Integer
     * @see com.smartgwt.client.widgets.form.fields.TextAreaItem#getHeight
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public Integer getStaticHeight()  {
        return getAttributeAsInt("staticHeight");
    }
    

    /**
     * Base CSS class to apply to this item's input element. NOTE: See the {@link
     * com.smartgwt.client.docs.CompoundFormItem_skinning} discussion for special skinning considerations.
     *
     * @param textBoxStyle  See {@link com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle} . Default value is "textItem"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setTextBoxStyle(String textBoxStyle) {
        setAttribute("textBoxStyle", textBoxStyle);
    }

    /**
     * Base CSS class to apply to this item's input element. NOTE: See the {@link
     * com.smartgwt.client.docs.CompoundFormItem_skinning} discussion for special skinning considerations.
     *
     * @return  See {@link com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle} 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getTextBoxStyle()  {
        return getAttributeAsString("textBoxStyle");
    }
    

    /**
     * default width of this item
     *
     * @param width  Default value is 150
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setWidth(int width) {
        setAttribute("width", width);
    }

    /**
     * default width of this item
     *
     * @return int
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getWidth()  {
        return getAttributeAsInt("width");
    }
    
    

    // ********************* Methods ***********************
	/**
     * If this item currently has focus, clear the current selection. leaving focus in the item. Has no effect if the item is
     * undrawn or unfocused. Only applies to text-based items.
     */
    public native void deselectValue() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.deselectValue();
    }-*/;

	/**
     * If this item currently has focus, clear the current selection. leaving focus in the item. Has no effect if the item is
     * undrawn or unfocused. Only applies to text-based items.
     * @param start By default the text insertion cursor will be moved to the end of the   current value - pass in this parameter to move to
     * the start instead
     */
    public native void deselectValue(Boolean start) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.deselectValue(start == null ? null : start.@java.lang.Boolean::booleanValue()());
    }-*/;
	
	/**
     * Returns the raw text value that currently appears in the text field, which can differ from  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValue FormItem.getValue} in various cases - for example: <ul>
     * <li>for items that constrain the value range, such as a {@link com.smartgwt.client.widgets.form.fields.DateItem} with
     * {@link com.smartgwt.client.widgets.form.fields.DateItem#getEnforceDate enforceDate}:true, or a {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem} with {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAddUnknownValues addUnknownValues}:false</li> <li>for items with
     * a defined valueMap or edit value formatter and parser functions which converts display value to data value</li>
     * <li>while the item has focus if {@link com.smartgwt.client.widgets.form.fields.TextItem#getChangeOnKeypress
     * changeOnKeypress} is false </li></ul>
     *
     * @return current entered value
     */
    public native String getEnteredValue() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getEnteredValue();
        return ret;
    }-*/;

	/**
     * For text-based items, this method returns the indices of the start/end of the current selection if the item currently
     * has the focus. In browsers other than Internet Explorer 6-9, if this item does not have focus, then this method returns
     * the indices of the start/end of the selection the last time that this item had focus. In IE 6-9, returns null if the
     * item does not have focus. <P> In all browsers, clicking anywhere outside of the item causes the item to lose focus;
     * hence, in IE 6-9, this method will not work in other components' event handlers for certain events. For example, within
     * the {@link com.smartgwt.client.widgets.Canvas#addClickHandler click()} handler of a button, this item will have already
     * lost focus, so in IE 6-9, this method will return null if called within the button's click() handler. One cross-browser
     * solution to this issue is to save the selection range for later in a {@link
     * com.smartgwt.client.widgets.Canvas#addMouseDownHandler mouseDown()} or {@link
     * com.smartgwt.client.widgets.Canvas#addMouseOverHandler mouseOver()} handler. <P> Notes: <UL>   <LI>In browsers other
     * than IE 6-9, calling {@link com.smartgwt.client.widgets.form.fields.FormItem#setValue setValue()} or otherwise changing
     * the {@link com.smartgwt.client.widgets.form.fields.TextAreaItem#getEnteredValue entered value} invalidates the past
     * selection range.</LI>   <LI>The returned indices are indices within the entered value rather than the item's value as
     * returned by {@link com.smartgwt.client.widgets.form.fields.FormItem#getValue getValue()}. The distinction is
     * particularly important for {@link com.smartgwt.client.widgets.form.fields.TextAreaItem}s because browsers normalize the
     * line endings in the <code>&lt;textarea&gt;</code> element's value. Internet Explorer 6, 7, and 8 convert line endings to
     * "\r\n" while other browsers convert line endings to "\n" <a
     * href='http://www.w3.org/TR/html5/forms.html#concept-textarea-api-value'
     * onclick="window.open('http://www.w3.org/TR/html5/forms.html#concept-textarea-api-value');return false;">as specified by
     * the HTML5 standard</a>.</LI> </UL>
     *
     * @return 2 element array showing character index of the current or past selection's start and end points within this item's
     * {@link com.smartgwt.client.widgets.form.fields.TextItem#getEnteredValue entered value}. In IE 6-9, returns null if the
     * item does not have focus.
     */
    public native int[] getSelectionRange() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getSelectionRange();
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfint(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Put focus in this item and select the entire value. Only applies to text based items
     */
    public native void selectValue() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.selectValue();
    }-*/;



	/**
     * Puts focus into this form item and selects characters between the given indices. Only applies to drawn text based items.
     * @param start selection starting character index
     * @param end end of selection character index
     */
    public native void setSelectionRange(int start, int end) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.setSelectionRange(start, end);
    }-*/;



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
     * @param textAreaItemProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(TextAreaItem textAreaItemProperties) /*-{
    	var properties = $wnd.isc.addProperties({},textAreaItemProperties.@com.smartgwt.client.core.RefDataClass::getJsObj()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
        $wnd.isc.TextAreaItem.addProperties(properties);
    }-*/;

    // ***********************************************************



    /**
     * Text wrapping style.
     *
     * @param wrap wrap Default value is {@link TextAreaWrap#SOFT}
     */
    public void setWrap(TextAreaWrap wrap) {
        setAttribute("wrap", wrap.getValue());
    }

    /**
     * Text wrapping style.
     *
     * @return TextAreaWrap
     */
    public TextAreaWrap getWrap() {
        return EnumUtil.getEnum(TextAreaWrap.values(), getAttribute("wrap"));
    }

    /**
     * Return the value tracked by this form item.
     *
     * @return value of this element
     */
    public native String getValueAsString() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret;
        if(self.setValue) {
             ret = self.getValue();
        } else {
            ret = self.value;
        }
        return ret == null || ret === undefined ? null : ret.toString();
    }-*/;    

}
