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
        return getAttributeAsBoolean("changeOnKeypress");
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
        return getAttributeAsBoolean("formatOnBlur");
    }

    /**
     * default height of this item
     *
     * @param height  Default value is 100
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setHeight(int height) {
        setAttribute("height", height);
    }

    /**
     * default height of this item
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
        return getAttributeAsBoolean("printFullText");
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
        return getAttributeAsBoolean("selectOnClick");
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
        return getAttributeAsBoolean("selectOnFocus");
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
        return getAttributeAsBoolean("showHintInField");
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
     * Set the length.
     *
     * @param length the length
     */
    public void setLength(Integer length) {
        setAttribute("length", length);
    }

    /**
     * Return the length.
     *
     * @return the length
     */
    public Integer getLength() {
        return getAttributeAsInt("length");
    }

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
