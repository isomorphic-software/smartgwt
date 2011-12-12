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

import java.util.*;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * FormItem for managing a text field.
 */
public class TextItem extends FormItem {

    public static TextItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (TextItem) obj;
        } else {
            return new TextItem(jsObj);
        }
    }

    public TextItem(){
        setAttribute("editorType", "TextItem");
    }

    public TextItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public TextItem(String name) {
        setName(name);
        setAttribute("editorType", "TextItem");
    }

    public TextItem(String name, String title) {
        setName(name);
		setTitle(title);
        setAttribute("editorType", "TextItem");
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
     * Should entered characters be converted to upper or lowercase? Also applies to values applied with {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setValue FormItem.setValue}. <P> Note: character casing cannot be used
     * at the same time as a {@link com.smartgwt.client.widgets.form.fields.TextItem#getMask mask}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param characterCasing characterCasing Default value is TextItem.DEFAULT
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_keypress_filter" target="examples">KeyPress Filters Example</a>
     */
    public void setCharacterCasing(CharacterCasing characterCasing) {
        setAttribute("characterCasing", characterCasing.getValue());
    }

    /**
     * Should entered characters be converted to upper or lowercase? Also applies to values applied with {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setValue FormItem.setValue}. <P> Note: character casing cannot be used
     * at the same time as a {@link com.smartgwt.client.widgets.form.fields.TextItem#getMask mask}.
     *
     *
     * @return CharacterCasing
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_keypress_filter" target="examples">KeyPress Filters Example</a>
     */
    public CharacterCasing getCharacterCasing()  {
        return EnumUtil.getEnum(CharacterCasing.values(), getAttribute("characterCasing"));
    }

    /**
     * Should {@link com.smartgwt.client.widgets.form.fields.TextItem#getFormatEditorValue formatEditorValue} re-run whenever
     * this item recieves or loses focus? Setting this property allows developers to conditionally format the display value
     * based on item.hasFocus, typically to display a longer, more informative string while the item does not have focus, and
     * simplifying it down to an easier-to-edit string when the user puts focus into the item.
     *
     * @param formatOnFocusChange formatOnFocusChange Default value is false
     */
    public void setFormatOnFocusChange(Boolean formatOnFocusChange) {
        setAttribute("formatOnFocusChange", formatOnFocusChange);
    }

    /**
     * Should {@link com.smartgwt.client.widgets.form.fields.TextItem#getFormatEditorValue formatEditorValue} re-run whenever
     * this item recieves or loses focus? Setting this property allows developers to conditionally format the display value
     * based on item.hasFocus, typically to display a longer, more informative string while the item does not have focus, and
     * simplifying it down to an easier-to-edit string when the user puts focus into the item.
     *
     *
     * @return Boolean
     */
    public Boolean getFormatOnFocusChange()  {
        return getAttributeAsBoolean("formatOnFocusChange");
    }

    /**
     * Default height for text items.
     *
     * @param height height Default value is 19
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setHeight(int height) {
        setAttribute("height", height);
    }

    /**
     * Default height for text items.
     *
     *
     * @return int
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getHeight()  {
        return getAttributeAsInt("height");
    }

    /**
     * Sets a keypress filter regular expression to limit valid characters that can be entered by the user. If defined, keys
     * that match the regular expression are allowed; all others are suppressed. The filter is applied after character casing,
     * if defined. <P> Note: keypress filtering cannot be used at the same time as a {@link
     * com.smartgwt.client.widgets.form.fields.TextItem#getMask mask}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the keyPressFilter for this item
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param keyPressFilter new keyPress filter for the item. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.TextItem#setCharacterCasing
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_keypress_filter" target="examples">KeyPress Filters Example</a>
     */
    public void setKeyPressFilter(String keyPressFilter) {
        setAttribute("keyPressFilter", keyPressFilter);
    }

    /**
     * Sets a keypress filter regular expression to limit valid characters that can be entered by the user. If defined, keys
     * that match the regular expression are allowed; all others are suppressed. The filter is applied after character casing,
     * if defined. <P> Note: keypress filtering cannot be used at the same time as a {@link
     * com.smartgwt.client.widgets.form.fields.TextItem#getMask mask}.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.form.fields.TextItem#getCharacterCasing
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_keypress_filter" target="examples">KeyPress Filters Example</a>
     */
    public String getKeyPressFilter()  {
        return getAttributeAsString("keyPressFilter");
    }

    /**
     * if set, maximum number of characters for this field
     *
     * @param length length Default value is null
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public void setLength(Integer length) {
        setAttribute("length", length);
    }

    /**
     * if set, maximum number of characters for this field
     *
     *
     * @return Integer
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public Integer getLength()  {
        return getAttributeAsInt("length");
    }

    /**
     * Input mask used to filter text entry. <P> Sample masks: <UL> <LI>Phone number: (###) ###-####</LI> <LI>Social Security
     * number: ###-##-#### <LI>First name: &gt;?&lt;??????????</LI> <LI>Date: ##/##/####</LI> <LI>State: &gt;LL</LI> </UL>
     * Overview of available mask characters <P> <table class="normal"> <tr><th>Character</th><th>Description</th></tr>
     * <tr><td>0</td><td>Digit (0 through 9) or plus [+] or minus [-] signs</td></tr> <tr><td>9</td><td>Digit or
     * space</td></tr> <tr><td>#</td><td>Digit</td></tr> <tr><td>L</td><td>Letter (A through Z)</td></tr>
     * <tr><td>?</td><td>Letter (A through Z) or space</td></tr> <tr><td>A</td><td>Letter or digit</td></tr>
     * <tr><td>a</td><td>Letter or digit</td></tr> <tr><td>C</td><td>Any character or space</td></tr> <tr><td>&nbsp;</td></tr>
     * <tr><td>&lt;</td><td>Causes all characters that follow to be converted to lowercase</td></tr>
     * <tr><td>&gt;</td><td>Causes all characters that follow to be converted to uppercase</td></tr> </table> <P> Any character
     * not matching one of the above mask characters or that is escaped with a backslash (\) is considered to be a literal. <P>
     * Custom mask characters can be defined by standard regular expression character set or range. For example, a hexadecimal
     * color code mask could be: <UL> <LI>Color: \#>[0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F]</LI> </UL> <P> Note: input
     * mask cannot be used at the same time as a {@link com.smartgwt.client.widgets.form.fields.TextItem#getKeyPressFilter
     * keyPressFilter}. Also note that this property is not supported for {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem} or {@link com.smartgwt.client.widgets.form.fields.SpinnerItem}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the mask for this item. <P> Note that the current value of the field is cleared when changing the mask.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param mask mask to apply to text item. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.TextItem#setKeyPressFilter
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_masking" target="examples">Text - Masked Example</a>
     */
    public void setMask(String mask) {
        setAttribute("mask", mask);
    }

    /**
     * Input mask used to filter text entry. <P> Sample masks: <UL> <LI>Phone number: (###) ###-####</LI> <LI>Social Security
     * number: ###-##-#### <LI>First name: &gt;?&lt;??????????</LI> <LI>Date: ##/##/####</LI> <LI>State: &gt;LL</LI> </UL>
     * Overview of available mask characters <P> <table class="normal"> <tr><th>Character</th><th>Description</th></tr>
     * <tr><td>0</td><td>Digit (0 through 9) or plus [+] or minus [-] signs</td></tr> <tr><td>9</td><td>Digit or
     * space</td></tr> <tr><td>#</td><td>Digit</td></tr> <tr><td>L</td><td>Letter (A through Z)</td></tr>
     * <tr><td>?</td><td>Letter (A through Z) or space</td></tr> <tr><td>A</td><td>Letter or digit</td></tr>
     * <tr><td>a</td><td>Letter or digit</td></tr> <tr><td>C</td><td>Any character or space</td></tr> <tr><td>&nbsp;</td></tr>
     * <tr><td>&lt;</td><td>Causes all characters that follow to be converted to lowercase</td></tr>
     * <tr><td>&gt;</td><td>Causes all characters that follow to be converted to uppercase</td></tr> </table> <P> Any character
     * not matching one of the above mask characters or that is escaped with a backslash (\) is considered to be a literal. <P>
     * Custom mask characters can be defined by standard regular expression character set or range. For example, a hexadecimal
     * color code mask could be: <UL> <LI>Color: \#>[0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F]</LI> </UL> <P> Note: input
     * mask cannot be used at the same time as a {@link com.smartgwt.client.widgets.form.fields.TextItem#getKeyPressFilter
     * keyPressFilter}. Also note that this property is not supported for {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem} or {@link com.smartgwt.client.widgets.form.fields.SpinnerItem}.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.form.fields.TextItem#getKeyPressFilter
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_masking" target="examples">Text - Masked Example</a>
     */
    public String getMask()  {
        return getAttributeAsString("mask");
    }

    /**
     * During entry into masked field, should keystrokes overwrite current position value? By default new keystrokes are
     * inserted into the field.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param maskOverwriteMode maskOverwriteMode Default value is null
     */
    public void setMaskOverwriteMode(Boolean maskOverwriteMode) {
        setAttribute("maskOverwriteMode", maskOverwriteMode);
    }

    /**
     * During entry into masked field, should keystrokes overwrite current position value? By default new keystrokes are
     * inserted into the field.
     *
     *
     * @return Boolean
     */
    public Boolean getMaskOverwriteMode()  {
        return getAttributeAsBoolean("maskOverwriteMode");
    }

    /**
     * Character that is used to fill required empty mask positions to display text while control has no focus.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param maskPadChar maskPadChar Default value is " "
     */
    public void setMaskPadChar(String maskPadChar) {
        setAttribute("maskPadChar", maskPadChar);
    }

    /**
     * Character that is used to fill required empty mask positions to display text while control has no focus.
     *
     *
     * @return String
     */
    public String getMaskPadChar()  {
        return getAttributeAsString("maskPadChar");
    }

    /**
     * Character that is used to fill required empty mask positions to display text while control has focus.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param maskPromptChar maskPromptChar Default value is "_"
     */
    public void setMaskPromptChar(String maskPromptChar) {
        setAttribute("maskPromptChar", maskPromptChar);
    }

    /**
     * Character that is used to fill required empty mask positions to display text while control has focus.
     *
     *
     * @return String
     */
    public String getMaskPromptChar()  {
        return getAttributeAsString("maskPromptChar");
    }

    /**
     * Should entered mask value be saved with embedded literals?
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param maskSaveLiterals maskSaveLiterals Default value is null
     */
    public void setMaskSaveLiterals(Boolean maskSaveLiterals) {
        setAttribute("maskSaveLiterals", maskSaveLiterals);
    }

    /**
     * Should entered mask value be saved with embedded literals?
     *
     *
     * @return Boolean
     */
    public Boolean getMaskSaveLiterals()  {
        return getAttributeAsBoolean("maskSaveLiterals");
    }

    /**
     * When generating a print-view of the component containing this TextItem, should the form item expand to accommodate its
     * value? If set to false the text box will not expand to fit its content in the print view, instead showing exactly as it
     * does in the live form.
     *
     * @param printFullText printFullText Default value is false
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public void setPrintFullText(Boolean printFullText) {
        setAttribute("printFullText", printFullText);
    }

    /**
     * When generating a print-view of the component containing this TextItem, should the form item expand to accommodate its
     * value? If set to false the text box will not expand to fit its content in the print view, instead showing exactly as it
     * does in the live form.
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
     * com.smartgwt.client.widgets.form.fields.TextItem#getTextBoxStyle textBoxStyle} with the suffix "Hint" appended to it.
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
     * com.smartgwt.client.widgets.form.fields.TextItem#getTextBoxStyle textBoxStyle} with the suffix "Hint" appended to it.
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
     * Base CSS class name for this item's input element. NOTE: See the {@link CompoundFormItem_skinning} discussion for
     * special skinning considerations.
     *
     * @param textBoxStyle textBoxStyle Default value is "textItem"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setTextBoxStyle(String textBoxStyle) {
        setAttribute("textBoxStyle", textBoxStyle);
    }

    /**
     * Base CSS class name for this item's input element. NOTE: See the {@link CompoundFormItem_skinning} discussion for
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
     * Default width for fields.
     *
     * @param width width Default value is 150
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setWidth(int width) {
        setAttribute("width", width);
    }

    /**
     * Default width for fields.
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
     * <li>while the item has focus if {@link com.smartgwt.client.widgets.form.fields.TextItem#getChangeOnKeypress
     * changeOnKeypress} is false </li></ul>
     *
     * @return current entered value
     */
    public native String getEnteredValue() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        return self.getEnteredValue();
    }-*/;
            
    /**
     * Returns the hint text for this item. Default implementation returns {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getHint hint}, or  null if there is no hint to show.
     *
     * @return HTML to show as the hint for the item
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public native String getHint() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        return self.getHint();
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

}



