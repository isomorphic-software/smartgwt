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
 * FormItem for managing a text field.
 */
@BeanFactory.FrameworkClass
public class TextItem extends FormItem {

    public static TextItem getOrCreateRef(JavaScriptObject jsObj) {

        if(jsObj == null) return null;

        RefDataClass obj = RefDataClass.getRef(jsObj);

		if(obj != null && JSOHelper.getAttribute(jsObj,"__ref")==null) {
            return com.smartgwt.client.util.ObjectFactory.createFormItem("TextItem",jsObj);

        } else
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (TextItem) obj;
        } else {
            return new TextItem(jsObj);
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
        $wnd.isc.TextItem.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
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
        $wnd.isc.TextItem.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
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
        $wnd.isc.TextItem.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.drawing.DrawItem::getJsObj()());
    }-*/;

    public static native void changePickerIconDefaults(FormItemIcon defaults) /*-{
        $wnd.isc.TextItem.changeDefaults("pickerIconDefaults", defaults.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public TextItem(){
        setAttribute("editorType", "TextItem");
    }

    public TextItem(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
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
     * This property corresponds to the HTML5 "inputType" attribute applied to the &lt;input&gt; element for this TextItem. <p>
     * The only currently supported use of this attribute is hinting to touch-enabled mobile devices that a particular keyboard
     * layout should be used.  Even here, be careful; to take a random example, using type "number" on Android up to at least
     * 3.2 leads to a keyboard with no "-" key, so negative numbers cannot be entered. <p> <b>Valid values:</b> <table
     * class="normal" cellpadding="2">   <tbody>   <tr>     <td valign="top"><em>"text"</em></td>     <td>Normal text
     * keyboard</td>   </tr>   <tr>     <td valign="top"><em>"digits"</em></td>     <td>Makes the text field more suitable for
     * entering a string of digits 0 - 9. On iOS,         this causes the virtual keyboard to show a numeric keypad with only
     * "0", "1",         "2", ..., "9", and delete keys.</td>   </tr>   <tr>     <td valign="top"><em>"email"</em></td>    
     * <td>Makes the text field more suitable for entering an e-mail address. On iOS, this         causes the virtual keyboard
     * to show special "@" and "." keys on the alphabetic         keys screen.</td>   </tr>   <tr>     <td
     * valign="top"><em>"tel"</em></td>     <td>Makes the text field more suitable for entering a telephone number. On iOS,
     * this         causes the virtual keyboard to show a numeric keypad with a "+*#" key for         displaying punctuation
     * keys.</td>   </tr>   <tr>     <td valign="top"><em>"number"</em></td>     <td>Makes the text field more suitable for
     * entering a floating-point value. On iOS,         this causes the virtual keyboard to start on the number and punctuation
     * keys screen.         <p>         <b>NOTE:</b> This is not an appropriate text input type for credit card numbers,       
     * postal codes, ISBNs, and other formats that are not strictly parsable as floating-point         numbers. This is because
     * the browser is required to perform floating-point value         sanitization to ensure that the value is a <a
     * href="http://www.w3.org/TR/html5/infrastructure.html#valid-floating-point-number">valid floating-point number</a>.</td> 
     * </tr>   <tr>     <td valign="top"><em>"url"</em></td>     <td>Makes the text field more suitable for entering a URL. On
     * iOS, this causes the         virtual keyboard to show a special ".com" key.</td>   </tr>   <tr>     <td
     * valign="top">Any&nbsp;vendor-<br>specific value</td>     <td>If a browser supports another input type.</td>   </tr>  
     * </tbody> </table>
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param browserInputType  Default value is null
     */
    public void setBrowserInputType(String browserInputType) {
        setAttribute("browserInputType", browserInputType);
    }

    /**
     * This property corresponds to the HTML5 "inputType" attribute applied to the &lt;input&gt; element for this TextItem. <p>
     * The only currently supported use of this attribute is hinting to touch-enabled mobile devices that a particular keyboard
     * layout should be used.  Even here, be careful; to take a random example, using type "number" on Android up to at least
     * 3.2 leads to a keyboard with no "-" key, so negative numbers cannot be entered. <p> <b>Valid values:</b> <table
     * class="normal" cellpadding="2">   <tbody>   <tr>     <td valign="top"><em>"text"</em></td>     <td>Normal text
     * keyboard</td>   </tr>   <tr>     <td valign="top"><em>"digits"</em></td>     <td>Makes the text field more suitable for
     * entering a string of digits 0 - 9. On iOS,         this causes the virtual keyboard to show a numeric keypad with only
     * "0", "1",         "2", ..., "9", and delete keys.</td>   </tr>   <tr>     <td valign="top"><em>"email"</em></td>    
     * <td>Makes the text field more suitable for entering an e-mail address. On iOS, this         causes the virtual keyboard
     * to show special "@" and "." keys on the alphabetic         keys screen.</td>   </tr>   <tr>     <td
     * valign="top"><em>"tel"</em></td>     <td>Makes the text field more suitable for entering a telephone number. On iOS,
     * this         causes the virtual keyboard to show a numeric keypad with a "+*#" key for         displaying punctuation
     * keys.</td>   </tr>   <tr>     <td valign="top"><em>"number"</em></td>     <td>Makes the text field more suitable for
     * entering a floating-point value. On iOS,         this causes the virtual keyboard to start on the number and punctuation
     * keys screen.         <p>         <b>NOTE:</b> This is not an appropriate text input type for credit card numbers,       
     * postal codes, ISBNs, and other formats that are not strictly parsable as floating-point         numbers. This is because
     * the browser is required to perform floating-point value         sanitization to ensure that the value is a <a
     * href="http://www.w3.org/TR/html5/infrastructure.html#valid-floating-point-number">valid floating-point number</a>.</td> 
     * </tr>   <tr>     <td valign="top"><em>"url"</em></td>     <td>Makes the text field more suitable for entering a URL. On
     * iOS, this causes the         virtual keyboard to show a special ".com" key.</td>   </tr>   <tr>     <td
     * valign="top">Any&nbsp;vendor-<br>specific value</td>     <td>If a browser supports another input type.</td>   </tr>  
     * </tbody> </table>
     *
     * @return String
     */
    public String getBrowserInputType()  {
        return getAttributeAsString("browserInputType");
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
     * Should entered characters be converted to upper or lowercase? Also applies to values applied with {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setValue FormItem.setValue}. <P> Note: character casing cannot be used
     * at the same time as a {@link com.smartgwt.client.widgets.form.fields.TextItem#getMask mask}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param characterCasing  Default value is TextItem.DEFAULT
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_keypress_filter" target="examples">KeyPress Filters Example</a>
     */
    public void setCharacterCasing(CharacterCasing characterCasing) {
        setAttribute("characterCasing", characterCasing == null ? null : characterCasing.getValue());
    }

    /**
     * Should entered characters be converted to upper or lowercase? Also applies to values applied with {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setValue FormItem.setValue}. <P> Note: character casing cannot be used
     * at the same time as a {@link com.smartgwt.client.widgets.form.fields.TextItem#getMask mask}.
     *
     * @return CharacterCasing
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_keypress_filter" target="examples">KeyPress Filters Example</a>
     */
    public CharacterCasing getCharacterCasing()  {
        return EnumUtil.getEnum(CharacterCasing.values(), getAttribute("characterCasing"));
    }
    

    /**
     * Default class used to construct {@link com.smartgwt.client.tools.EditProxy} for this component when editMode is enabled.
     *
     * @param editProxyConstructor  See {@link com.smartgwt.client.docs.SCClassName SCClassName} . Default value is "TextItemEditProxy"
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
     * If a {@link com.smartgwt.client.widgets.form.fields.TextItem#getLength length} is specified for this item, should user
     * input be limited to the specified length? If set to true, user input and values passed to  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setValue setValue()} will be trimmed to the specified length. Otherwise
     * values exceeding the specified length will raise an error on validation. <P> Note that having this value set to true
     * limits user interactivity in some ways. For example users would be unable to paste a longer string into the field for
     * editing without seeing it be truncated.
     *
     * @param enforceLength  Default value is true
     */
    public void setEnforceLength(boolean enforceLength) {
        setAttribute("enforceLength", enforceLength);
    }

    /**
     * If a {@link com.smartgwt.client.widgets.form.fields.TextItem#getLength length} is specified for this item, should user
     * input be limited to the specified length? If set to true, user input and values passed to  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setValue setValue()} will be trimmed to the specified length. Otherwise
     * values exceeding the specified length will raise an error on validation. <P> Note that having this value set to true
     * limits user interactivity in some ways. For example users would be unable to paste a longer string into the field for
     * editing without seeing it be truncated.
     *
     * @return boolean
     */
    public boolean getEnforceLength()  {
        Boolean result = getAttributeAsBoolean("enforceLength", true);
        return result == null ? true : result;
    }
    

    /**
     * With <code>formatOnBlur</code> enabled, this textItem will format its value according to any specified static {@link
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
     * With <code>formatOnBlur</code> enabled, this textItem will format its value according to any specified static {@link
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
     * Should {@link com.smartgwt.client.widgets.form.fields.FormItem#formatEditorValue FormItem.formatEditorValue} re-run
     * whenever this item recieves or loses focus? Setting this property allows developers to conditionally format the display
     * value based on item.hasFocus, typically to display a longer, more informative string while the item does not have focus,
     * and simplifying it down to an easier-to-edit string when the user puts focus into the item.
     *
     * @param formatOnFocusChange  Default value is false
     */
    public void setFormatOnFocusChange(Boolean formatOnFocusChange) {
        setAttribute("formatOnFocusChange", formatOnFocusChange);
    }

    /**
     * Should {@link com.smartgwt.client.widgets.form.fields.FormItem#formatEditorValue FormItem.formatEditorValue} re-run
     * whenever this item recieves or loses focus? Setting this property allows developers to conditionally format the display
     * value based on item.hasFocus, typically to display a longer, more informative string while the item does not have focus,
     * and simplifying it down to an easier-to-edit string when the user puts focus into the item.
     *
     * @return Boolean
     */
    public Boolean getFormatOnFocusChange()  {
        Boolean result = getAttributeAsBoolean("formatOnFocusChange", true);
        return result == null ? false : result;
    }
    
    

    /**
     * Sets a keypress filter regular expression to limit valid characters that can be entered by the user. If defined, keys
     * that match the regular expression are allowed; all others are suppressed. The filter is applied after character casing,
     * if defined. <P> Note: keypress filtering cannot be used at the same time as a {@link
     * com.smartgwt.client.widgets.form.fields.TextItem#getMask mask}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the {@link com.smartgwt.client.widgets.form.fields.TextItem#getKeyPressFilter keyPressFilter} for this item
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
     * @return String
     * @see com.smartgwt.client.widgets.form.fields.TextItem#getCharacterCasing
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_keypress_filter" target="examples">KeyPress Filters Example</a>
     */
    public String getKeyPressFilter()  {
        return getAttributeAsString("keyPressFilter");
    }
    

    /**
     * If set, maximum number of characters for this field. If {@link
     * com.smartgwt.client.widgets.form.fields.TextItem#getEnforceLength enforceLength} is set to true, user input will be
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
     * com.smartgwt.client.widgets.form.fields.TextItem#getEnforceLength enforceLength} is set to true, user input will be
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
     * Set the mask for this item.  Pass null to clear an existing mask. <P> Note that the current value of the field is cleared when changing the mask.
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
     * @param maskOverwriteMode  Default value is null
     */
    public void setMaskOverwriteMode(Boolean maskOverwriteMode) {
        setAttribute("maskOverwriteMode", maskOverwriteMode);
    }

    /**
     * During entry into masked field, should keystrokes overwrite current position value? By default new keystrokes are
     * inserted into the field.
     *
     * @return Boolean
     */
    public Boolean getMaskOverwriteMode()  {
        return getAttributeAsBoolean("maskOverwriteMode", true);
    }
    

    /**
     * Character that is used to fill required empty mask positions to display text while control has no focus.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param maskPadChar  Default value is " "
     */
    public void setMaskPadChar(String maskPadChar) {
        setAttribute("maskPadChar", maskPadChar);
    }

    /**
     * Character that is used to fill required empty mask positions to display text while control has no focus.
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
     * @param maskPromptChar  Default value is "_"
     */
    public void setMaskPromptChar(String maskPromptChar) {
        setAttribute("maskPromptChar", maskPromptChar);
    }

    /**
     * Character that is used to fill required empty mask positions to display text while control has focus.
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
     * @param maskSaveLiterals  Default value is null
     */
    public void setMaskSaveLiterals(Boolean maskSaveLiterals) {
        setAttribute("maskSaveLiterals", maskSaveLiterals);
    }

    /**
     * Should entered mask value be saved with embedded literals?
     *
     * @return Boolean
     */
    public Boolean getMaskSaveLiterals()  {
        return getAttributeAsBoolean("maskSaveLiterals", true);
    }
    

    /**
     * When generating a print-view of the component containing this TextItem, should the form item expand to accommodate its
     * value? If set to false the text box will not expand to fit its content in the print view, instead showing exactly as it
     * does in the live form.
     *
     * @param printFullText  Default value is false
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
     * @return Boolean
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public Boolean getPrintFullText()  {
        Boolean result = getAttributeAsBoolean("printFullText", true);
        return result == null ? false : result;
    }
    

    /**
     * Text items will submit their containing form on enter keypress  if {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getSaveOnEnter saveOnEnter} is true. Setting this property to
     * <code>false</code> will disable this behavior.
     *
     * @param saveOnEnter  Default value is true
     */
    public void setSaveOnEnter(Boolean saveOnEnter) {
        setAttribute("saveOnEnter", saveOnEnter);
    }

    /**
     * Text items will submit their containing form on enter keypress  if {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getSaveOnEnter saveOnEnter} is true. Setting this property to
     * <code>false</code> will disable this behavior.
     *
     * @return Boolean
     */
    public Boolean getSaveOnEnter()  {
        Boolean result = getAttributeAsBoolean("saveOnEnter", true);
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
     * com.smartgwt.client.widgets.form.fields.TextItem#getTextBoxStyle textBoxStyle} with the suffix "Hint" appended to it. If
     * the item is disabled the suffix "DisabledHint" will be used. <P> To change this attribute after being drawn, it is
     * necessary to call {@link com.smartgwt.client.widgets.form.fields.FormItem#redraw FormItem.redraw} or redraw the form.
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
     * com.smartgwt.client.widgets.form.fields.TextItem#getTextBoxStyle textBoxStyle} with the suffix "Hint" appended to it. If
     * the item is disabled the suffix "DisabledHint" will be used. <P> To change this attribute after being drawn, it is
     * necessary to call {@link com.smartgwt.client.widgets.form.fields.FormItem#redraw FormItem.redraw} or redraw the form.
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getHint
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowHintInField()  {
        return getAttributeAsBoolean("showHintInField", true);
    }
    

    /**
     * Base CSS class name for this item's input element. NOTE: See the {@link
     * com.smartgwt.client.docs.CompoundFormItem_skinning} discussion for special skinning considerations.
     *
     * @param textBoxStyle  See {@link com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle} . Default value is "textItem"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setTextBoxStyle(String textBoxStyle) {
        setAttribute("textBoxStyle", textBoxStyle);
    }

    /**
     * Base CSS class name for this item's input element. NOTE: See the {@link
     * com.smartgwt.client.docs.CompoundFormItem_skinning} discussion for special skinning considerations.
     *
     * @return  See {@link com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle} 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getTextBoxStyle()  {
        return getAttributeAsString("textBoxStyle");
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
     * Returns the hint text for this item. Default implementation returns {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getHint hint}, or  null if there is no hint to show.
     *
     * @return HTML to show as the hint for the item
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public native String getHint() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getHint();
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
     * the {@link com.smartgwt.client.widgets.form.fields.TextItem#getEnteredValue entered value} invalidates the past
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
     * @param textItemProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(TextItem textItemProperties) /*-{
    	var properties = $wnd.isc.addProperties({},textItemProperties.@com.smartgwt.client.core.RefDataClass::getJsObj()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
        $wnd.isc.TextItem.addProperties(properties);
    }-*/;

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

}


