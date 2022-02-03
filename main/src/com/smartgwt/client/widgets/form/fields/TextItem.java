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
 * FormItem for managing a text field.
 */
@BeanFactory.FrameworkClass
public class TextItem extends FormItem {

    public static TextItem getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof TextItem) {
            existingObj.setJsObj(jsObj);
            return (TextItem)existingObj;
        } else

        {
            return new TextItem(jsObj);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(TextItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.TextItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(TextItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.TextItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public static native void changePickerIconDefaults(FormItemIcon defaults) /*-{
        $wnd.isc.TextItem.changeDefaults("pickerIconDefaults", defaults.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

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
     * 
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param browserAutoCapitalize New browserAutoCapitalize value. Default value is null
     */
    public void setBrowserAutoCapitalize(Boolean browserAutoCapitalize) {
        setAttribute("browserAutoCapitalize", browserAutoCapitalize);
    }

    /**
     * 
     *
     * @return Current browserAutoCapitalize value. Default value is null
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
     * @param browserAutoCorrect New browserAutoCorrect value. Default value is null
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
     * @return Current browserAutoCorrect value. Default value is null
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
     * @param browserInputType New browserInputType value. Default value is null
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
     * @return Current browserInputType value. Default value is null
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
     * @param changeOnKeypress New changeOnKeypress value. Default value is true
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
     * @return Current changeOnKeypress value. Default value is true
     */
    public Boolean getChangeOnKeypress()  {
        Boolean result = getAttributeAsBoolean("changeOnKeypress", true);
        return result == null ? true : result;
    }
    

    /**
     * Should entered characters be converted to upper or lowercase? Also applies to values applied with {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setValue FormItem.setValue()}. <P> Note: character casing cannot be
     * used at the same time as a {@link com.smartgwt.client.widgets.form.fields.TextItem#getMask mask}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param characterCasing New characterCasing value. Default value is TextItem.DEFAULT
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_keypress_filter" target="examples">KeyPress Filters Example</a>
     */
    public void setCharacterCasing(CharacterCasing characterCasing) {
        setAttribute("characterCasing", characterCasing == null ? null : characterCasing.getValue());
    }

    /**
     * Should entered characters be converted to upper or lowercase? Also applies to values applied with {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setValue FormItem.setValue()}. <P> Note: character casing cannot be
     * used at the same time as a {@link com.smartgwt.client.widgets.form.fields.TextItem#getMask mask}.
     *
     * @return Current characterCasing value. Default value is TextItem.DEFAULT
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_keypress_filter" target="examples">KeyPress Filters Example</a>
     */
    public CharacterCasing getCharacterCasing()  {
        return EnumUtil.getEnum(CharacterCasing.values(), getAttribute("characterCasing"));
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
     * If a {@link com.smartgwt.client.widgets.form.fields.TextItem#getLength length} is specified for this item, should user
     * input be limited to the specified length? If set to true, user input and values passed to  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setValue setValue()} will be trimmed to the specified length. Otherwise
     * values exceeding the specified length will raise an error on validation. <P> Note that having this value set to true
     * limits user interactivity in some ways. For example users would be unable to paste a longer string into the field for
     * editing without seeing it be truncated.
     *
     * @param enforceLength New enforceLength value. Default value is true
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
     * @return Current enforceLength value. Default value is true
     */
    public boolean getEnforceLength()  {
        Boolean result = getAttributeAsBoolean("enforceLength", true);
        return result == null ? true : result;
    }
    

    /**
     * By default HTML characters will be escaped when {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit
     * canEdit} is false and  {@link com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyDisplay readOnlyDisplay} is
     * "static", so that the raw value of the field (for example <code>"&lt;b&gt;AAA&lt;/b&gt;"</code>) is displayed to the
     * user rather than the interpreted HTML (for example <code>"<b>AAA</b>"</code>).  Setting <code>escapeHTML</code> false
     * will instead force HTML values in a textItem to be interpreted by the browser in that situation.
     *
     * @param escapeHTML New escapeHTML value. Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setEscapeHTML(Boolean escapeHTML) {
        setAttribute("escapeHTML", escapeHTML);
    }

    /**
     * By default HTML characters will be escaped when {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit
     * canEdit} is false and  {@link com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyDisplay readOnlyDisplay} is
     * "static", so that the raw value of the field (for example <code>"&lt;b&gt;AAA&lt;/b&gt;"</code>) is displayed to the
     * user rather than the interpreted HTML (for example <code>"<b>AAA</b>"</code>).  Setting <code>escapeHTML</code> false
     * will instead force HTML values in a textItem to be interpreted by the browser in that situation.
     *
     * @return Current escapeHTML value. Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getEscapeHTML()  {
        Boolean result = getAttributeAsBoolean("escapeHTML", true);
        return result == null ? true : result;
    }
    

    /**
     * If this form item has a specified {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * FormItem.optionDataSource}, should the item ever perform a fetch against this dataSource to retrieve the related record.
     * <P> Note that for editable textItems, behavior differs slightly than for other item types as we will not issue fetches
     * unless {@link com.smartgwt.client.widgets.form.fields.FormItem#getAlwaysFetchMissingValues
     * FormItem.alwaysFetchMissingValues} has been set to true.  See {@link
     * com.smartgwt.client.widgets.form.fields.TextItem#shouldFetchMissingValue shouldFetchMissingValue()} for more details.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param fetchMissingValues New fetchMissingValues value. Default value is true
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setOptionDataSource
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getSelectedRecord
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setFilterLocally
     */
    public void setFetchMissingValues(Boolean fetchMissingValues) {
        setAttribute("fetchMissingValues", fetchMissingValues);
    }

    /**
     * If this form item has a specified {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * FormItem.optionDataSource}, should the item ever perform a fetch against this dataSource to retrieve the related record.
     * <P> Note that for editable textItems, behavior differs slightly than for other item types as we will not issue fetches
     * unless {@link com.smartgwt.client.widgets.form.fields.FormItem#getAlwaysFetchMissingValues
     * FormItem.alwaysFetchMissingValues} has been set to true.  See {@link
     * com.smartgwt.client.widgets.form.fields.TextItem#shouldFetchMissingValue shouldFetchMissingValue()} for more details.
     *
     * @return Current fetchMissingValues value. Default value is true
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getSelectedRecord
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getFilterLocally
     */
    public Boolean getFetchMissingValues()  {
        Boolean result = getAttributeAsBoolean("fetchMissingValues", true);
        return result == null ? true : result;
    }
    

    /**
     * With <code>formatOnBlur</code> enabled, this textItem will format its value according to the rules described in {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#mapValueToDisplay FormItem.mapValueToDisplay()} as long as the  item
     * does not have focus.  Once the user puts focus into the item the formatter will be removed. This provides a simple way
     * for developers to show a nicely formatted display value in a freeform text field, without the need for an explicit
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#formatEditorValue FormItem.formatEditorValue()}  and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#parseEditorValue FormItem.parseEditorValue()} pair.
     *
     * @param formatOnBlur New formatOnBlur value. Default value is false
     */
    public void setFormatOnBlur(Boolean formatOnBlur) {
        setAttribute("formatOnBlur", formatOnBlur);
    }

    /**
     * With <code>formatOnBlur</code> enabled, this textItem will format its value according to the rules described in {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#mapValueToDisplay FormItem.mapValueToDisplay()} as long as the  item
     * does not have focus.  Once the user puts focus into the item the formatter will be removed. This provides a simple way
     * for developers to show a nicely formatted display value in a freeform text field, without the need for an explicit
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#formatEditorValue FormItem.formatEditorValue()}  and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#parseEditorValue FormItem.parseEditorValue()} pair.
     *
     * @return Current formatOnBlur value. Default value is false
     */
    public Boolean getFormatOnBlur()  {
        Boolean result = getAttributeAsBoolean("formatOnBlur", true);
        return result == null ? false : result;
    }
    

    /**
     * Should {@link com.smartgwt.client.widgets.form.fields.FormItem#formatEditorValue FormItem.formatEditorValue()} re-run
     * whenever this item recieves or loses focus? Setting this property allows developers to conditionally format the display
     * value based on item.hasFocus, typically to display a longer, more informative string while the item does not have focus,
     * and simplifying it down to an easier-to-edit string when the user puts focus into the item.
     *
     * @param formatOnFocusChange New formatOnFocusChange value. Default value is false
     */
    public void setFormatOnFocusChange(Boolean formatOnFocusChange) {
        setAttribute("formatOnFocusChange", formatOnFocusChange);
    }

    /**
     * Should {@link com.smartgwt.client.widgets.form.fields.FormItem#formatEditorValue FormItem.formatEditorValue()} re-run
     * whenever this item recieves or loses focus? Setting this property allows developers to conditionally format the display
     * value based on item.hasFocus, typically to display a longer, more informative string while the item does not have focus,
     * and simplifying it down to an easier-to-edit string when the user puts focus into the item.
     *
     * @return Current formatOnFocusChange value. Default value is false
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
     * @return Current keyPressFilter value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.TextItem#getCharacterCasing
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_keypress_filter" target="examples">KeyPress Filters Example</a>
     */
    public String getKeyPressFilter()  {
        return getAttributeAsString("keyPressFilter");
    }
    

    /**
     * If set, the maximum number of characters for this field. If  {@link
     * com.smartgwt.client.widgets.form.fields.TextItem#getEnforceLength enforceLength} is set to true, user input will be
     * limited  to this value, and values exceeding this length passed to  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setValue setValue()} will be trimmed. Otherwise values exceeding the 
     * specified length will raise an error on validation. <P> If the item has a numeric type, like {@link
     * com.smartgwt.client.widgets.form.fields.IntegerItem integer} or  {@link
     * com.smartgwt.client.widgets.form.fields.FloatItem float}, length is applied to the raw number value, after any specified
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getDecimalPrecision decimalPrecision} and  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDecimalPad decimalPad} but before any formatters - this means the
     * string measured includes sign and decimal placeholder, and padded decimal places as required, but not thousands
     * separators or any custom formatting. <P> See also {@link com.smartgwt.client.data.DataSourceField#getLength
     * DataSourceField.length}.
     *
     * @param length New length value. Default value is null
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public void setLength(Integer length) {
        setAttribute("length", length);
    }

    /**
     * If set, the maximum number of characters for this field. If  {@link
     * com.smartgwt.client.widgets.form.fields.TextItem#getEnforceLength enforceLength} is set to true, user input will be
     * limited  to this value, and values exceeding this length passed to  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setValue setValue()} will be trimmed. Otherwise values exceeding the 
     * specified length will raise an error on validation. <P> If the item has a numeric type, like {@link
     * com.smartgwt.client.widgets.form.fields.IntegerItem integer} or  {@link
     * com.smartgwt.client.widgets.form.fields.FloatItem float}, length is applied to the raw number value, after any specified
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getDecimalPrecision decimalPrecision} and  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDecimalPad decimalPad} but before any formatters - this means the
     * string measured includes sign and decimal placeholder, and padded decimal places as required, but not thousands
     * separators or any custom formatting. <P> See also {@link com.smartgwt.client.data.DataSourceField#getLength
     * DataSourceField.length}.
     *
     * @return Current length value. Default value is null
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public Integer getLength()  {
        return getAttributeAsInt("length");
    }
    

    /**
     * Input mask used to restrict and format text within this item. <P> Overview of available mask characters <P> <table
     * class="normal"> <tr><th>Character</th><th>Description</th></tr> <tr><td>0</td><td>Digit (0 through 9) or plus [+] or
     * minus [-] signs</td></tr> <tr><td>9</td><td>Digit or space</td></tr> <tr><td>#</td><td>Digit</td></tr>
     * <tr><td>L</td><td>Letter (A through Z)</td></tr> <tr><td>?</td><td>Letter (A through Z) or space</td></tr>
     * <tr><td>A</td><td>Letter or digit</td></tr> <tr><td>a</td><td>Letter or digit</td></tr> <tr><td>C</td><td>Any character
     * or space</td></tr> <tr><td>&nbsp;</td></tr> <tr><td>&lt;</td><td>Causes all characters that follow to be converted to
     * lowercase</td></tr> <tr><td>&gt;</td><td>Causes all characters that follow to be converted to uppercase</td></tr>
     * <tr><td>&nbsp;</td></tr> <tr><td>[ ... ]</td><td>Square brakets denote the start and end of a custom       regular
     * expression character set or range.</td></tr> </table> <P> The mask can also contain literals - arbitrary non editable
     * characters  to be displayed as part of the formatted text. Any character not matching one of the above mask characters
     * will be considered a literal. To use one of the mask characters as a literal, it must be escaped with a pair of
     * backslashes (\\). By  default literals are formatting characters only and will not be saved as part of the  item's
     * value.  This behavior is controlled via {@link com.smartgwt.client.widgets.form.fields.TextItem#getMaskSaveLiterals
     * maskSaveLiterals}. <P> When a TextItem with a mask has focus, the formatted mask string will be displayed,  with the
     * {@link com.smartgwt.client.widgets.form.fields.TextItem#getMaskPromptChar maskPromptChar} displayed as a placeholder for
     * characters that have not yet been entered.<br> As the user types in the field, input will be restricted to the
     * appropriate character class for each character, with uppercase/lowercase conversion occurring automatically. When focus
     * is moved away from the field, the displayed value will be formatted to include any literals in the appropriate places.
     * <P> Sample masks: <UL> <LI>Phone number: (###) ###-####</LI> <LI>Social Security number: ###-##-#### <LI>First name:
     * &gt;?&lt;??????????</LI> <LI>Date: ##/##/####</LI> <LI>State: &gt;LL</LI> </UL> <P> Custom mask characters can be
     * defined by standard regular expression character set or range. For example, a hexadecimal color code mask could be: <UL>
     * <LI>Color: \\#&gt;[0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F]</LI> </UL> <P> Note: input mask cannot be used at the
     * same time as a {@link com.smartgwt.client.widgets.form.fields.TextItem#getKeyPressFilter keyPressFilter}. Also note that
     * this property is not supported for {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem} or {@link
     * com.smartgwt.client.widgets.form.fields.SpinnerItem}, or for items with {@link
     * com.smartgwt.client.widgets.form.fields.TextItem#getBrowserInputType browserInputType} set to "digits" or "number".
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the {@link com.smartgwt.client.widgets.form.fields.TextItem#getMask mask} for this item.  Pass null to clear an existing mask. <P> Note that the current value of the field is cleared when changing the mask.
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
     * Input mask used to restrict and format text within this item. <P> Overview of available mask characters <P> <table
     * class="normal"> <tr><th>Character</th><th>Description</th></tr> <tr><td>0</td><td>Digit (0 through 9) or plus [+] or
     * minus [-] signs</td></tr> <tr><td>9</td><td>Digit or space</td></tr> <tr><td>#</td><td>Digit</td></tr>
     * <tr><td>L</td><td>Letter (A through Z)</td></tr> <tr><td>?</td><td>Letter (A through Z) or space</td></tr>
     * <tr><td>A</td><td>Letter or digit</td></tr> <tr><td>a</td><td>Letter or digit</td></tr> <tr><td>C</td><td>Any character
     * or space</td></tr> <tr><td>&nbsp;</td></tr> <tr><td>&lt;</td><td>Causes all characters that follow to be converted to
     * lowercase</td></tr> <tr><td>&gt;</td><td>Causes all characters that follow to be converted to uppercase</td></tr>
     * <tr><td>&nbsp;</td></tr> <tr><td>[ ... ]</td><td>Square brakets denote the start and end of a custom       regular
     * expression character set or range.</td></tr> </table> <P> The mask can also contain literals - arbitrary non editable
     * characters  to be displayed as part of the formatted text. Any character not matching one of the above mask characters
     * will be considered a literal. To use one of the mask characters as a literal, it must be escaped with a pair of
     * backslashes (\\). By  default literals are formatting characters only and will not be saved as part of the  item's
     * value.  This behavior is controlled via {@link com.smartgwt.client.widgets.form.fields.TextItem#getMaskSaveLiterals
     * maskSaveLiterals}. <P> When a TextItem with a mask has focus, the formatted mask string will be displayed,  with the
     * {@link com.smartgwt.client.widgets.form.fields.TextItem#getMaskPromptChar maskPromptChar} displayed as a placeholder for
     * characters that have not yet been entered.<br> As the user types in the field, input will be restricted to the
     * appropriate character class for each character, with uppercase/lowercase conversion occurring automatically. When focus
     * is moved away from the field, the displayed value will be formatted to include any literals in the appropriate places.
     * <P> Sample masks: <UL> <LI>Phone number: (###) ###-####</LI> <LI>Social Security number: ###-##-#### <LI>First name:
     * &gt;?&lt;??????????</LI> <LI>Date: ##/##/####</LI> <LI>State: &gt;LL</LI> </UL> <P> Custom mask characters can be
     * defined by standard regular expression character set or range. For example, a hexadecimal color code mask could be: <UL>
     * <LI>Color: \\#&gt;[0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F]</LI> </UL> <P> Note: input mask cannot be used at the
     * same time as a {@link com.smartgwt.client.widgets.form.fields.TextItem#getKeyPressFilter keyPressFilter}. Also note that
     * this property is not supported for {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem} or {@link
     * com.smartgwt.client.widgets.form.fields.SpinnerItem}, or for items with {@link
     * com.smartgwt.client.widgets.form.fields.TextItem#getBrowserInputType browserInputType} set to "digits" or "number".
     *
     * @return Current mask value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.TextItem#getKeyPressFilter
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_masking" target="examples">Text - Masked Example</a>
     */
    public String getMask()  {
        return getAttributeAsString("mask");
    }
    

    /**
     * During entry into a {@link com.smartgwt.client.widgets.form.fields.TextItem#getMask masked field}, should keystrokes
     * overwrite current position value? By default new keystrokes are inserted into the field.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param maskOverwriteMode New maskOverwriteMode value. Default value is null
     */
    public void setMaskOverwriteMode(Boolean maskOverwriteMode) {
        setAttribute("maskOverwriteMode", maskOverwriteMode);
    }

    /**
     * During entry into a {@link com.smartgwt.client.widgets.form.fields.TextItem#getMask masked field}, should keystrokes
     * overwrite current position value? By default new keystrokes are inserted into the field.
     *
     * @return Current maskOverwriteMode value. Default value is null
     */
    public Boolean getMaskOverwriteMode()  {
        return getAttributeAsBoolean("maskOverwriteMode", true);
    }
    

    /**
     * Character that is used to fill required empty {@link com.smartgwt.client.widgets.form.fields.TextItem#getMask mask}
     * positions to display text while control has no focus.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param maskPadChar New maskPadChar value. Default value is " "
     */
    public void setMaskPadChar(String maskPadChar) {
        setAttribute("maskPadChar", maskPadChar);
    }

    /**
     * Character that is used to fill required empty {@link com.smartgwt.client.widgets.form.fields.TextItem#getMask mask}
     * positions to display text while control has no focus.
     *
     * @return Current maskPadChar value. Default value is " "
     */
    public String getMaskPadChar()  {
        return getAttributeAsString("maskPadChar");
    }
    

    /**
     * Character that is used to fill required empty {@link com.smartgwt.client.widgets.form.fields.TextItem#getMask mask}
     * positions to display text while control has focus.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param maskPromptChar New maskPromptChar value. Default value is "_"
     */
    public void setMaskPromptChar(String maskPromptChar) {
        setAttribute("maskPromptChar", maskPromptChar);
    }

    /**
     * Character that is used to fill required empty {@link com.smartgwt.client.widgets.form.fields.TextItem#getMask mask}
     * positions to display text while control has focus.
     *
     * @return Current maskPromptChar value. Default value is "_"
     */
    public String getMaskPromptChar()  {
        return getAttributeAsString("maskPromptChar");
    }
    

    /**
     * Should entered {@link com.smartgwt.client.widgets.form.fields.TextItem#getMask mask} value be saved with embedded
     * literals?
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param maskSaveLiterals New maskSaveLiterals value. Default value is null
     */
    public void setMaskSaveLiterals(Boolean maskSaveLiterals) {
        setAttribute("maskSaveLiterals", maskSaveLiterals);
    }

    /**
     * Should entered {@link com.smartgwt.client.widgets.form.fields.TextItem#getMask mask} value be saved with embedded
     * literals?
     *
     * @return Current maskSaveLiterals value. Default value is null
     */
    public Boolean getMaskSaveLiterals()  {
        return getAttributeAsBoolean("maskSaveLiterals", true);
    }
    

    /**
     * When generating a print-view of the component containing this TextItem, should the form item expand to accommodate its
     * value? If set to false the text box will not expand to fit its content in the print view, instead showing exactly as it
     * does in the live form.
     *
     * @param printFullText New printFullText value. Default value is false
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
     * @return Current printFullText value. Default value is false
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
     * @param saveOnEnter New saveOnEnter value. Default value is true
     */
    public void setSaveOnEnter(Boolean saveOnEnter) {
        setAttribute("saveOnEnter", saveOnEnter);
    }

    /**
     * Text items will submit their containing form on enter keypress  if {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getSaveOnEnter saveOnEnter} is true. Setting this property to
     * <code>false</code> will disable this behavior.
     *
     * @return Current saveOnEnter value. Default value is true
     */
    public Boolean getSaveOnEnter()  {
        Boolean result = getAttributeAsBoolean("saveOnEnter", true);
        return result == null ? true : result;
    }
    

    /**
     * Allows the {@link com.smartgwt.client.widgets.form.DynamicForm#getSelectOnClick selectOnClick} behavior to be configured
     * on a per-FormItem basis.  Normally all items in a form default to the value of {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getSelectOnClick DynamicForm.selectOnClick}.
     *
     * @param selectOnClick New selectOnClick value. Default value is null
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public void setSelectOnClick(Boolean selectOnClick) {
        setAttribute("selectOnClick", selectOnClick);
    }

    /**
     * Allows the {@link com.smartgwt.client.widgets.form.DynamicForm#getSelectOnClick selectOnClick} behavior to be configured
     * on a per-FormItem basis.  Normally all items in a form default to the value of {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getSelectOnClick DynamicForm.selectOnClick}.
     *
     * @return Current selectOnClick value. Default value is null
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public Boolean getSelectOnClick()  {
        return getAttributeAsBoolean("selectOnClick", true);
    }
    

    /**
     * Allows the {@link com.smartgwt.client.widgets.form.DynamicForm#getSelectOnFocus selectOnFocus} behavior to be configured
     * on a per-FormItem basis.  Normally all items in a form default to the value of {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getSelectOnFocus DynamicForm.selectOnFocus}.
     *
     * @param selectOnFocus New selectOnFocus value. Default value is null
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public void setSelectOnFocus(Boolean selectOnFocus) {
        setAttribute("selectOnFocus", selectOnFocus);
    }

    /**
     * Allows the {@link com.smartgwt.client.widgets.form.DynamicForm#getSelectOnFocus selectOnFocus} behavior to be configured
     * on a per-FormItem basis.  Normally all items in a form default to the value of {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getSelectOnFocus DynamicForm.selectOnFocus}.
     *
     * @return Current selectOnFocus value. Default value is null
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public Boolean getSelectOnFocus()  {
        return getAttributeAsBoolean("selectOnFocus", true);
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowHint showing a hint for this form item}, should the
     * hint be shown within the field?
     *  <P>
     * Unless the HTML5 <code>placeholder</code> attribute is used to display the hint (see {@link
     * com.smartgwt.client.widgets.form.fields.TextItem#getUsePlaceholderForHint usePlaceholderForHint}),
     * the value of the {@link com.smartgwt.client.widgets.form.fields.FormItem#getDataElement data element} will be set to the
     * hint
     *  whenever this item is not focused. Also, when displaying the hint, the CSS style of the
     * data element will be set to the {@link com.smartgwt.client.widgets.form.fields.TextItem#getTextBoxStyle textBoxStyle}
     * with the suffix
     *  "Hint" appended to it; or, if the item is disabled, the suffix "DisabledHint" will be used.
     * In {@link com.smartgwt.client.util.Page#isRTL RTL mode} when {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowRTL showRTL} is <code>true</code>,
     *  an additional "RTL" suffix will be appended; i.e. the CSS style of the data element when
     *  the hint is displayed will be the <code>textBoxStyle</code> plus "HintRTL" or "DisabledHintRTL".
     *  <P>
     * To change this attribute after being drawn, it is necessary to call {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#redraw FormItem.redraw()}
     *  or redraw the form.
     *  <P>
     *  <h3>Styling the in-field hint</h3>
     *  The in-field hint can be styled with CSS for the <code>textBoxStyle</code> + "Hint" /
     *  "HintRTL" / "DisabledHint" / "DisabledHintRTL" styles. For example, if this item's
     *  <code>textBoxStyle</code> is set to "mySpecialItem", then changing the hint color to
     *  blue can be accomplished with the following CSS:
     *  <pre>.mySpecialItemHint,
     * .mySpecialItemHintRTL,
     * .mySpecialItemDisabledHint,
     * .mySpecialItemDisabledHintRTL {
     *     color: blue;
     * }</pre>
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showHintInField New showHintInField value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setHint
     * @see com.smartgwt.client.widgets.form.fields.TextItem#setUsePlaceholderForHint
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setShowHintInField(Boolean showHintInField) {
        setAttribute("showHintInField", showHintInField);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowHint showing a hint for this form item}, should the
     * hint be shown within the field?
     *  <P>
     * Unless the HTML5 <code>placeholder</code> attribute is used to display the hint (see {@link
     * com.smartgwt.client.widgets.form.fields.TextItem#getUsePlaceholderForHint usePlaceholderForHint}),
     * the value of the {@link com.smartgwt.client.widgets.form.fields.FormItem#getDataElement data element} will be set to the
     * hint
     *  whenever this item is not focused. Also, when displaying the hint, the CSS style of the
     * data element will be set to the {@link com.smartgwt.client.widgets.form.fields.TextItem#getTextBoxStyle textBoxStyle}
     * with the suffix
     *  "Hint" appended to it; or, if the item is disabled, the suffix "DisabledHint" will be used.
     * In {@link com.smartgwt.client.util.Page#isRTL RTL mode} when {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowRTL showRTL} is <code>true</code>,
     *  an additional "RTL" suffix will be appended; i.e. the CSS style of the data element when
     *  the hint is displayed will be the <code>textBoxStyle</code> plus "HintRTL" or "DisabledHintRTL".
     *  <P>
     * To change this attribute after being drawn, it is necessary to call {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#redraw FormItem.redraw()}
     *  or redraw the form.
     *  <P>
     *  <h3>Styling the in-field hint</h3>
     *  The in-field hint can be styled with CSS for the <code>textBoxStyle</code> + "Hint" /
     *  "HintRTL" / "DisabledHint" / "DisabledHintRTL" styles. For example, if this item's
     *  <code>textBoxStyle</code> is set to "mySpecialItem", then changing the hint color to
     *  blue can be accomplished with the following CSS:
     *  <pre>.mySpecialItemHint,
     * .mySpecialItemHintRTL,
     * .mySpecialItemDisabledHint,
     * .mySpecialItemDisabledHintRTL {
     *     color: blue;
     * }</pre>
     *
     * @return Current showHintInField value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getHint
     * @see com.smartgwt.client.widgets.form.fields.TextItem#getUsePlaceholderForHint
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowHintInField()  {
        return getAttributeAsBoolean("showHintInField", true);
    }
    

    /**
     * When set to false, prevents this item's input element from being written into the DOM. If there are {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons} or a  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon picker icon}, these are displayed as normal, and the
     * item will auto-sizing to that content if its {@link com.smartgwt.client.widgets.form.fields.FormItem#getWidth width} is
     * set to null.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showInputElement New showInputElement value. Default value is true
     */
    public void setShowInputElement(boolean showInputElement) {
        setAttribute("showInputElement", showInputElement);
    }

    /**
     * When set to false, prevents this item's input element from being written into the DOM. If there are {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons} or a  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon picker icon}, these are displayed as normal, and the
     * item will auto-sizing to that content if its {@link com.smartgwt.client.widgets.form.fields.FormItem#getWidth width} is
     * set to null.
     *
     * @return Current showInputElement value. Default value is true
     */
    public boolean getShowInputElement()  {
        Boolean result = getAttributeAsBoolean("showInputElement", true);
        return result == null ? true : result;
    }
    

    /**
     * Does the current formItem support native cut and paste events? <P> This attribute only applies to freeform text entry
     * fields such as {@link com.smartgwt.client.widgets.form.fields.TextItem} and {@link
     * com.smartgwt.client.widgets.form.fields.TextAreaItem}, and only if {@link
     * com.smartgwt.client.widgets.form.fields.TextItem#getChangeOnKeypress changeOnKeypress} is true.  If true, developers can
     * detect the user editing the value  via cut or paste interactions (triggered from keyboard shortcuts or the native 
     * browser menu options) using the {@link com.smartgwt.client.widgets.form.fields.FormItem#isCutEvent
     * FormItem.isCutEvent()} and {@link com.smartgwt.client.widgets.form.fields.FormItem#isPasteEvent FormItem.isPasteEvent()}
     * methods. This allows custom cut/paste handling to be added to the various change notification flow methods including 
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#addChangeHandler FormItem.change()}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#handleChange FormItem.handleChange()} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setInputTransformer FormItem.transformInput()}.
     *
     * @param supportsCutPasteEvents New supportsCutPasteEvents value. Default value is true
     */
    public void setSupportsCutPasteEvents(boolean supportsCutPasteEvents) {
        setAttribute("supportsCutPasteEvents", supportsCutPasteEvents);
    }

    /**
     * Does the current formItem support native cut and paste events? <P> This attribute only applies to freeform text entry
     * fields such as {@link com.smartgwt.client.widgets.form.fields.TextItem} and {@link
     * com.smartgwt.client.widgets.form.fields.TextAreaItem}, and only if {@link
     * com.smartgwt.client.widgets.form.fields.TextItem#getChangeOnKeypress changeOnKeypress} is true.  If true, developers can
     * detect the user editing the value  via cut or paste interactions (triggered from keyboard shortcuts or the native 
     * browser menu options) using the {@link com.smartgwt.client.widgets.form.fields.FormItem#isCutEvent
     * FormItem.isCutEvent()} and {@link com.smartgwt.client.widgets.form.fields.FormItem#isPasteEvent FormItem.isPasteEvent()}
     * methods. This allows custom cut/paste handling to be added to the various change notification flow methods including 
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#addChangeHandler FormItem.change()}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#handleChange FormItem.handleChange()} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setInputTransformer FormItem.transformInput()}.
     *
     * @return Current supportsCutPasteEvents value. Default value is true
     */
    public boolean getSupportsCutPasteEvents()  {
        Boolean result = getAttributeAsBoolean("supportsCutPasteEvents", true);
        return result == null ? true : result;
    }
    

    /**
     * This attribute currently only has an effect in Internet Explorer. That browser will dynamically add a native "clear"
     * icon to <i>&lt;input type="text" &gt;</i> elements when the user enters a value. Setting
     * <code>suppressBrowserClearIcon</code> to <code>true</code> will write out HTML to suppress this icon. This can be
     * particularly useful for items which define their own clear icon as in  <a
     * href="http://www.smartclient.com/smartgwtee/showcase/#inlineFormIcons" target="examples">this sample</a>. <P> If this
     * property is not set at the item level, {@link com.smartgwt.client.widgets.form.DynamicForm#getSuppressBrowserClearIcons
     * DynamicForm.suppressBrowserClearIcons} will be used instead. <P> Note that as an alternative to using this feature, the
     * icon may also be suppressed  (or have other styling applied to it) directly via CSS, using the  <code>::-ms-clear</code>
     * css pseudo-element (proprietary Internet Explorer feature). <P> Implementation note: This feature makes use of the
     * automatically generated {@link com.smartgwt.client.widgets.form.fields.TextItem#suppressClearIconClassName
     * suppressClearIconClassName} css class.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for the {@link com.smartgwt.client.widgets.form.fields.TextItem#getSuppressBrowserClearIcon suppressBrowserClearIcon}
     *
     * @param suppressBrowserClearIcon new value for suppressBrowserClearIcon. Default value is null
     */
    public void setSuppressBrowserClearIcon(Boolean suppressBrowserClearIcon) {
        setAttribute("suppressBrowserClearIcon", suppressBrowserClearIcon);
    }

    /**
     * This attribute currently only has an effect in Internet Explorer. That browser will dynamically add a native "clear"
     * icon to <i>&lt;input type="text" &gt;</i> elements when the user enters a value. Setting
     * <code>suppressBrowserClearIcon</code> to <code>true</code> will write out HTML to suppress this icon. This can be
     * particularly useful for items which define their own clear icon as in  <a
     * href="http://www.smartclient.com/smartgwtee/showcase/#inlineFormIcons" target="examples">this sample</a>. <P> If this
     * property is not set at the item level, {@link com.smartgwt.client.widgets.form.DynamicForm#getSuppressBrowserClearIcons
     * DynamicForm.suppressBrowserClearIcons} will be used instead. <P> Note that as an alternative to using this feature, the
     * icon may also be suppressed  (or have other styling applied to it) directly via CSS, using the  <code>::-ms-clear</code>
     * css pseudo-element (proprietary Internet Explorer feature). <P> Implementation note: This feature makes use of the
     * automatically generated {@link com.smartgwt.client.widgets.form.fields.TextItem#suppressClearIconClassName
     * suppressClearIconClassName} css class.
     *
     * @return Current suppressBrowserClearIcon value. Default value is null
     */
    public Boolean getSuppressBrowserClearIcon()  {
        return getAttributeAsBoolean("suppressBrowserClearIcon", true);
    }
    

    /**
     * Base CSS class name for this item's input element. NOTE: See the {@link
     * com.smartgwt.client.docs.CompoundFormItem_skinning} discussion for special skinning considerations.  <p> For a rounded
     * text item, you can set <code>textBoxStyle</code> to "roundedTextItem". This style exists only in Enterprise,
     * EnterpriseBlue and Graphite skins.  There is no corresponding rounded style for SelectItem or ComboBoxItem as this
     * creates an awkward seam with the pop-up list (and a rounded pop-up list wouldn't help: data could not be flush to
     * corners).  For these reasons we recommend rounded inputs only in limited cases like single standalone fields.
     *
     * @param textBoxStyle New textBoxStyle value. Default value is "textItem"
     * @see com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setTextBoxStyle(String textBoxStyle) {
        setAttribute("textBoxStyle", textBoxStyle);
    }

    /**
     * Base CSS class name for this item's input element. NOTE: See the {@link
     * com.smartgwt.client.docs.CompoundFormItem_skinning} discussion for special skinning considerations.  <p> For a rounded
     * text item, you can set <code>textBoxStyle</code> to "roundedTextItem". This style exists only in Enterprise,
     * EnterpriseBlue and Graphite skins.  There is no corresponding rounded style for SelectItem or ComboBoxItem as this
     * creates an awkward seam with the pop-up list (and a rounded pop-up list wouldn't help: data could not be flush to
     * corners).  For these reasons we recommend rounded inputs only in limited cases like single standalone fields.
     *
     * @return Current textBoxStyle value. Default value is "textItem"
     * @see com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getTextBoxStyle()  {
        return getAttributeAsString("textBoxStyle");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.TextItem#getShowHintInField showing the hint in field} and if
     * supported by the browser, should the HTML5
     * <a href='http://www.whatwg.org/specs/web-apps/current-work/multipage/forms.html#attr-input-placeholder'
     * target='_blank'><code>placeholder</code> attribute</a>
     *  be used to display the hint within the field? If set to <code>false</code>, then use of
     *  the <code>placeholder</code> attribute is disabled and an alternative technique to display
     *  the hint in-field is used instead.
     *  <p>
     *  The HTML5 <code>placeholder</code> attribute is supported in the following major browsers:
     *  <ul>
     *  <li>Chrome 4+</li>
     *  <li>Firefox 4+</li>
     *  <li>Internet Explorer 10+</li>
     *  <li>Safari 5+</li>
     *  <li>Opera 11.50+</li>
     *  <li>Android 2.1+ <code>WebView</code> (used by the stock Browser app and when
     *      {@link com.smartgwt.client.docs.PhonegapIntegration packaging with PhoneGap})</li>
     *  <li>Mobile Safari for iOS 3.2+</li>
     *  </ul>
     *  <p>
     *  In browsers other than the above, in-field hints are implemented via a different technique.
     *  <p>
     *  Note that placeholder behavior is known to differ in Internet Explorer and certain old
     *  versions of the above browsers due to a recent change in the HTML5 specification regarding
     *  the <code>placeholder</code> attribute. Under the old rules, the placeholder is cleared
     *  when the element is focused. In the latest HTML5 spec as published by WHATWG, the placeholder
     *  is still displayed when the element is focused as long as the value is an empty string.
     *  <p>
     *  <h3>Styling the placeholder</h3>
     *  While there isn't a standard way to style the placeholder text, Chrome, Firefox,
     *  Internet Explorer, and Safari provide vendor-prefixed pseudo-classes and/or pseudo-elements
     *  that can be used in CSS selectors:
     *  <table border="1">
     *  <tr>
     *    <th>Browser</th>
     *    <th>Pseudo-class or pseudo-element</th>
     *  </tr>
     *  <tr>
     *    <td>Chrome, Safari</td>
     *    <td><code>::-webkit-input-placeholder</code></td>
     *  </tr>
     *  <tr>
     *    <td>Firefox 4 - 18</td>
     *    <td><code>:-moz-placeholder</code></td>
     *  </tr>
     *  <tr>
     *    <td>Firefox 19+</td>
     *    <td><code>::-moz-placeholder</code></td>
     *  </tr>
     *  <tr>
     *    <td>Internet Explorer</td>
     *    <td><code>:-ms-input-placeholder</code></td>
     *  </tr>
     *  </table>
     *  <p>
     *  Note that unlike other browsers, Firefox 19+ applies opacity:0.4 to the placeholder text.
     * See <a href='https://bugzilla.mozilla.org/show_bug.cgi?id=556145' target='_blank'>Bug 556145 - Placeholder text default
     * style should use opacity instead of GrayText</a>
     *  <p>
     *  Because browsers are required to ignore the entire rule if a selector is invalid,
     *  separate rules are needed for each browser. For example:
     *  <pre>::-webkit-input-placeholder {
     *     color: blue;
     *     opacity: 1;
     * &#125;
     * :-moz-placeholder {
     *     color: blue;
     *     opacity: 1;
     * &#125;
     * ::-moz-placeholder {
     *     color: blue;
     *     opacity: 1;
     * &#125;
     * :-ms-input-placeholder {
     *     color: blue;
     *     opacity: 1;
     * &#125;</pre>
     *  <p>
     *  If using <a href='http://sass-lang.com' target='_blank'>Sass</a>, it may be useful to utilize Sass'
     * <a href='http://sass-lang.com/documentation/file.SASS_REFERENCE.html#parent-selector' target='_blank'>parent selector
     * feature</a>.
     *  For example:
     *  <pre>.myCustomItem,
     * .myCustomItemRTL,
     * .myCustomItemDisabled,
     * .myCustomItemDisabledRTL,
     * .myCustomItemError,
     * .myCustomItemErrorRTL,
     * .myCustomItemFocused,
     * .myCustomItemFocusedRTL,
     * .myCustomItemHint,
     * .myCustomItemHintRTL,
     * .myCustomItemDisabledHint,
     * .myCustomItemDisabledHintRTL {
     *     // ...
     * 
     *     &amp;::-webkit-input-placeholder {
     *         color: blue;
     *         opacity: 1;
     *     }
     *     &amp;:-moz-placeholder {
     *         color: blue;
     *         opacity: 1;
     *     }
     *     &amp;::-moz-placeholder {
     *         color: blue;
     *         opacity: 1;
     *     }
     *     &amp;:-ms-input-placeholder {
     *         color: blue;
     *         opacity: 1;
     *     }
     * &#125;</pre>
     *  <p>
     *  If using <a href='http://compass-style.org' target='_blank'>Compass</a>, the
     * <a href='http://compass-style.org/reference/compass/css3/user_interface/#mixin-input-placeholder'
     * target='_blank'><code>input-placeholder</code> mixin</a>
     *  that was added in version 1.0 can further simplify the code to style the placeholder text
     *  For example:
     *  <pre>.myCustomItem,
     * .myCustomItemRTL,
     * .myCustomItemDisabled,
     * .myCustomItemDisabledRTL,
     * .myCustomItemError,
     * .myCustomItemErrorRTL,
     * .myCustomItemFocused,
     * .myCustomItemFocusedRTL,
     * .myCustomItemHint,
     * .myCustomItemHintRTL,
     * .myCustomItemDisabledHint,
     * .myCustomItemDisabledHintRTL {
     *     // ...
     * 
     *     &#64;include input-placeholder {
     *         color: blue;
     *         opacity: 1;
     *     }
     * &#125;</pre>
     *  <h3>Accessibility concerns</h3>
     *  The HTML5 specification notes that a placeholder should not be used as a replacement
     *  for a title. The placeholder is intended to be a <em>short</em> hint that assists the user
     *  who is entering a value into the empty field. The placeholder can be mistaken by some
     *  users for a pre-filled value, particularly in Internet Explorer because the same color
     *  is used, and the placeholder text color may provide insufficient contrast, particularly
     *  in Firefox 19+ because of the default 0.4 opacity. Furthermore, not having a title reduces
     *  the hit area available for setting focus on the item.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param usePlaceholderForHint New usePlaceholderForHint value. Default value is true
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setHint
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setUsePlaceholderForHint(boolean usePlaceholderForHint) {
        setAttribute("usePlaceholderForHint", usePlaceholderForHint);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.TextItem#getShowHintInField showing the hint in field} and if
     * supported by the browser, should the HTML5
     * <a href='http://www.whatwg.org/specs/web-apps/current-work/multipage/forms.html#attr-input-placeholder'
     * target='_blank'><code>placeholder</code> attribute</a>
     *  be used to display the hint within the field? If set to <code>false</code>, then use of
     *  the <code>placeholder</code> attribute is disabled and an alternative technique to display
     *  the hint in-field is used instead.
     *  <p>
     *  The HTML5 <code>placeholder</code> attribute is supported in the following major browsers:
     *  <ul>
     *  <li>Chrome 4+</li>
     *  <li>Firefox 4+</li>
     *  <li>Internet Explorer 10+</li>
     *  <li>Safari 5+</li>
     *  <li>Opera 11.50+</li>
     *  <li>Android 2.1+ <code>WebView</code> (used by the stock Browser app and when
     *      {@link com.smartgwt.client.docs.PhonegapIntegration packaging with PhoneGap})</li>
     *  <li>Mobile Safari for iOS 3.2+</li>
     *  </ul>
     *  <p>
     *  In browsers other than the above, in-field hints are implemented via a different technique.
     *  <p>
     *  Note that placeholder behavior is known to differ in Internet Explorer and certain old
     *  versions of the above browsers due to a recent change in the HTML5 specification regarding
     *  the <code>placeholder</code> attribute. Under the old rules, the placeholder is cleared
     *  when the element is focused. In the latest HTML5 spec as published by WHATWG, the placeholder
     *  is still displayed when the element is focused as long as the value is an empty string.
     *  <p>
     *  <h3>Styling the placeholder</h3>
     *  While there isn't a standard way to style the placeholder text, Chrome, Firefox,
     *  Internet Explorer, and Safari provide vendor-prefixed pseudo-classes and/or pseudo-elements
     *  that can be used in CSS selectors:
     *  <table border="1">
     *  <tr>
     *    <th>Browser</th>
     *    <th>Pseudo-class or pseudo-element</th>
     *  </tr>
     *  <tr>
     *    <td>Chrome, Safari</td>
     *    <td><code>::-webkit-input-placeholder</code></td>
     *  </tr>
     *  <tr>
     *    <td>Firefox 4 - 18</td>
     *    <td><code>:-moz-placeholder</code></td>
     *  </tr>
     *  <tr>
     *    <td>Firefox 19+</td>
     *    <td><code>::-moz-placeholder</code></td>
     *  </tr>
     *  <tr>
     *    <td>Internet Explorer</td>
     *    <td><code>:-ms-input-placeholder</code></td>
     *  </tr>
     *  </table>
     *  <p>
     *  Note that unlike other browsers, Firefox 19+ applies opacity:0.4 to the placeholder text.
     * See <a href='https://bugzilla.mozilla.org/show_bug.cgi?id=556145' target='_blank'>Bug 556145 - Placeholder text default
     * style should use opacity instead of GrayText</a>
     *  <p>
     *  Because browsers are required to ignore the entire rule if a selector is invalid,
     *  separate rules are needed for each browser. For example:
     *  <pre>::-webkit-input-placeholder {
     *     color: blue;
     *     opacity: 1;
     * &#125;
     * :-moz-placeholder {
     *     color: blue;
     *     opacity: 1;
     * &#125;
     * ::-moz-placeholder {
     *     color: blue;
     *     opacity: 1;
     * &#125;
     * :-ms-input-placeholder {
     *     color: blue;
     *     opacity: 1;
     * &#125;</pre>
     *  <p>
     *  If using <a href='http://sass-lang.com' target='_blank'>Sass</a>, it may be useful to utilize Sass'
     * <a href='http://sass-lang.com/documentation/file.SASS_REFERENCE.html#parent-selector' target='_blank'>parent selector
     * feature</a>.
     *  For example:
     *  <pre>.myCustomItem,
     * .myCustomItemRTL,
     * .myCustomItemDisabled,
     * .myCustomItemDisabledRTL,
     * .myCustomItemError,
     * .myCustomItemErrorRTL,
     * .myCustomItemFocused,
     * .myCustomItemFocusedRTL,
     * .myCustomItemHint,
     * .myCustomItemHintRTL,
     * .myCustomItemDisabledHint,
     * .myCustomItemDisabledHintRTL {
     *     // ...
     * 
     *     &amp;::-webkit-input-placeholder {
     *         color: blue;
     *         opacity: 1;
     *     }
     *     &amp;:-moz-placeholder {
     *         color: blue;
     *         opacity: 1;
     *     }
     *     &amp;::-moz-placeholder {
     *         color: blue;
     *         opacity: 1;
     *     }
     *     &amp;:-ms-input-placeholder {
     *         color: blue;
     *         opacity: 1;
     *     }
     * &#125;</pre>
     *  <p>
     *  If using <a href='http://compass-style.org' target='_blank'>Compass</a>, the
     * <a href='http://compass-style.org/reference/compass/css3/user_interface/#mixin-input-placeholder'
     * target='_blank'><code>input-placeholder</code> mixin</a>
     *  that was added in version 1.0 can further simplify the code to style the placeholder text
     *  For example:
     *  <pre>.myCustomItem,
     * .myCustomItemRTL,
     * .myCustomItemDisabled,
     * .myCustomItemDisabledRTL,
     * .myCustomItemError,
     * .myCustomItemErrorRTL,
     * .myCustomItemFocused,
     * .myCustomItemFocusedRTL,
     * .myCustomItemHint,
     * .myCustomItemHintRTL,
     * .myCustomItemDisabledHint,
     * .myCustomItemDisabledHintRTL {
     *     // ...
     * 
     *     &#64;include input-placeholder {
     *         color: blue;
     *         opacity: 1;
     *     }
     * &#125;</pre>
     *  <h3>Accessibility concerns</h3>
     *  The HTML5 specification notes that a placeholder should not be used as a replacement
     *  for a title. The placeholder is intended to be a <em>short</em> hint that assists the user
     *  who is entering a value into the empty field. The placeholder can be mistaken by some
     *  users for a pre-filled value, particularly in Internet Explorer because the same color
     *  is used, and the placeholder text color may provide insufficient contrast, particularly
     *  in Firefox 19+ because of the default 0.4 opacity. Furthermore, not having a title reduces
     *  the hit area available for setting focus on the item.
     *
     * @return Current usePlaceholderForHint value. Default value is true
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getHint
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public boolean getUsePlaceholderForHint()  {
        Boolean result = getAttributeAsBoolean("usePlaceholderForHint", true);
        return result == null ? true : result;
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
     * com.smartgwt.client.widgets.form.fields.FormItem#getValue FormItem.getValue()} in various cases - for example: <ul>
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
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.getEnteredValue();
        return ret;
    }-*/;

	/**
     * Returns the hint text for this item. Default implementation returns {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getHint FormItem.hint}, or  null if there is no hint to show.
     *
     * @return HTML to show as the hint for the item.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public native String getHint() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
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
     * href='http://www.w3.org/TR/html5/forms.html#concept-textarea-api-value' target='_blank'>as specified by the HTML5
     * standard</a>.</LI> </UL>
     *
     * @return 2 element array showing character index of the current or past selection's start and end points within this item's
     * {@link com.smartgwt.client.widgets.form.fields.TextItem#getEnteredValue entered value}. In IE 6-9, returns null if the
     * item does not have focus.
     */
    public native int[] getSelectionRange() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.getSelectionRange();
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfint(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Notification method called when {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPending showPending} is
     * enabled and this text item should either clear or show its pending visual state. <p> The default behavior is that the
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getTitleStyle titleStyle}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCellStyle cellStyle}, and {@link
     * com.smartgwt.client.widgets.form.fields.TextItem#getTextBoxStyle textBoxStyle} are updated to include/exclude the
     * "Pending" suffix. Returning <code>false</code> will cancel this default behavior.
     * @param form the managing <code>DynamicForm</code> instance.
     * @param item the form item itself (also available as "this").
     * @param pendingStatus <code>true</code> if the item should show its pending visual state; <code>false</code> otherwise.
     * @param newValue the current form item value.
     * @param value the value that would be restored by a call to {@link com.smartgwt.client.widgets.form.DynamicForm#resetValues
     * DynamicForm.resetValues()}.
     *
     * @return <code>false</code> to cancel the default behavior.
     * 
     */
    public native boolean pendingStatusChanged(DynamicForm form, FormItem item, boolean pendingStatus, Object newValue, Object value) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.pendingStatusChanged(form == null ? null : form.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), item.@com.smartgwt.client.core.DataClass::getJsObj()(), pendingStatus, newValue, value);
        return ret == null ? false : ret;
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

	/**
     * If this field has a specified {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * optionDataSource}, should we perform a fetch against that dataSource to find the record that matches this field's value?
     * <P> For textItems this method will return false if the item is {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit editable} unless {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getAlwaysFetchMissingValues FormItem.alwaysFetchMissingValues} is true,
     * even if there is a specified {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField}.  We
     * do this as, for a freeform text-entry field with a specified displayField, the correct behavior when the user enters an
     * unrecognized value is somewhat ambiguous. The user could have entered a complete display-field value, in which case it
     * might be appropriate to issue a fetch against the display-field of the optionDataSource,  and set the underlying item
     * value.<br> If a match was not found though, we necessarily treat the entered value as the new "dataValue" for the field.
     * Should we then issue a second fetch against the optionDataSource comparing the user-entered value with the value-field
     * of the dataSource? <P> There are still cases where it could make sense to issue the fetch against the dataSource, and
     * developers who want this behavior can set {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getAlwaysFetchMissingValues alwaysFetchMissingValues} to true. <P> See
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#shouldFetchMissingValue FormItem.shouldFetchMissingValue()} for
     * how this method behaves for other item types.
     * @param newValue The new data value of the item.
     *
     * @return should we fetch the record matching the new value from the   item's optionDataSource?
     */
    public native Boolean shouldFetchMissingValue(Object newValue) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.shouldFetchMissingValue(newValue);
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

    	
	/**
     * Notification fired in response to a clipboard "paste" event on freeform text items, giving developers an opportunity to
     * reformat the pasted text. The  <code>pastedValue</code> argument contains the text pasted from the clipboard. This
     * method should return the text value to actually insert into the input element.
     * @param PastedValueTransformer customizer
     */
    public native void setPastedValueTransformer(PastedValueTransformer customizer) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.transformPastedValue = $debox($entry(function(item, form, pastedValue) {
        	var returnValue = customizer.@com.smartgwt.client.widgets.form.fields.PastedValueTransformer::transformPastedValue(Lcom/smartgwt/client/widgets/form/fields/FormItem;Lcom/smartgwt/client/widgets/form/DynamicForm;Ljava/lang/String;)(
					@com.smartgwt.client.widgets.form.fields.FormItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(item), 
					@com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(form), 
					pastedValue);
        	return $wnd.SmartGWT.convertToPrimitiveType(returnValue);
    	}));
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
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(TextItem textItemProperties) /*-{
        if (textItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(TextItem.@java.lang.Object::getClass()(), "setDefaultProperties", textItemProperties.@java.lang.Object::getClass()());
        }
        textItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var properties = textItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::getConfig()();
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
        return ret == null ? null : ret.toString();
    }-*/;

}
