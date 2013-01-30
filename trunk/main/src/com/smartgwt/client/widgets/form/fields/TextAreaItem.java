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
 * Class for editable multi-line text areas (uses HTML <code>&lt;TEXTAREA&gt;</code> object)
 */
public class TextAreaItem extends FormItem {

    public static TextAreaItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (TextAreaItem) obj;
        } else {
            return new TextAreaItem(jsObj);
        }
    }

    public TextAreaItem(){
        setAttribute("editorType", "TextAreaItem");
    }

    public TextAreaItem(JavaScriptObject jsObj){
        super(jsObj);
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
     * @param changeOnKeypress changeOnKeypress Default value is true
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
     *
     * @return Boolean
     */
    public Boolean getChangeOnKeypress()  {
        return getAttributeAsBoolean("changeOnKeypress");
    }

    /**
     * default height of this item
     *
     * @param height height Default value is 100
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setHeight(int height) {
        setAttribute("height", height);
    }

    /**
     * default height of this item
     *
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
     * @param iconVAlign iconVAlign Default value is Canvas.TOP
     */
    public void setIconVAlign(VerticalAlignment iconVAlign) {
        setAttribute("iconVAlign", iconVAlign == null ? null : iconVAlign.getValue());
    }

    /**
     * Align icons with the top edge of text area icons by default.
     *
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
     * @param minHeight minHeight Default value is 16
     */
    public void setMinHeight(int minHeight) {
        setAttribute("minHeight", minHeight);
    }

    /**
     * Minimum valid height for this TextAreaItem in px. If the specified {@link
     * com.smartgwt.client.widgets.form.fields.TextAreaItem#getHeight height} is less than this value, the text area will still
     * render at this height.
     *
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
     * @param printFullText printFullText Default value is true
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
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public Boolean getPrintFullText()  {
        return getAttributeAsBoolean("printFullText");
    }

    /**
     * Allows the {@link com.smartgwt.client.widgets.form.DynamicForm#getSelectOnFocus selectOnFocus} behavior to be configured
     * on a per-FormItem basis.  Normally all items in a form default to the value of {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getSelectOnFocus selectOnFocus}.
     *
     * @param selectOnFocus selectOnFocus Default value is null
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
     * @param showHintInField showHintInField Default value is null
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
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getHint
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowHintInField()  {
        return getAttributeAsBoolean("showHintInField");
    }

    /**
     * Base CSS class to apply to this item's input element. NOTE: See the {@link CompoundFormItem_skinning} discussion for
     * special skinning considerations.
     *
     * @param textBoxStyle textBoxStyle Default value is "textItem"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setTextBoxStyle(String textBoxStyle) {
        setAttribute("textBoxStyle", textBoxStyle);
    }

    /**
     * Base CSS class to apply to this item's input element. NOTE: See the {@link CompoundFormItem_skinning} discussion for
     * special skinning considerations.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getTextBoxStyle()  {
        return getAttributeAsString("textBoxStyle");
    }

    /**
     * default width of this item
     *
     * @param width width Default value is 150
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setWidth(int width) {
        setAttribute("width", width);
    }

    /**
     * default width of this item
     *
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
    public native void deselectValue(boolean start) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.deselectValue(start);
    }-*/;
            
    /**
     * Returns the raw text value typed into this form field, which can differ from  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValue FormItem.getValue} in various cases - for example: <ul>
     * <li>for items that constrain the value range, such as a {@link com.smartgwt.client.widgets.form.fields.DateItem} with
     * {@link com.smartgwt.client.widgets.form.fields.DateItem#getEnforceDate enforceDate}:true, or a {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem} with {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAddUnknownValues addUnknownValues}:false</li> <li>for items with
     * a defined valueMap or edit value formatter and parser functions which converts display value to data value</li>
     * <li>while the item has focus if {@link com.smartgwt.client.widgets.form.fields.TextAreaItem#getChangeOnKeypress
     * changeOnKeypress} is false </li></ul>
     *
     * @return current entered value
     */
    public native String getEnteredValue() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        return self.getEnteredValue();
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
     * For text-based items, this method returns the indices of the start/end of the current selection. Returns null if the
     * item doesn't have focus.
     *
     * @return 2 element array showing character index of the current selection's  start and end point within this item's value. May be
     * null if the item doesn't have focus.
     */
    public native int[] getSelectionRange() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selection = self.getSelectionRange();
        return selection == null || selection === undefined ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)(selection);
    }-*/;

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
