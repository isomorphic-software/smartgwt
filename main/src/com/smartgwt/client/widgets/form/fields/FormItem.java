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
 * A UI component that can participate in a DynamicForm, allowing editing or display of one of the {@link
 * com.smartgwt.client.widgets.form.DynamicForm#getValues values tracked by the form}. <P>  FormItems do not render
 * themselves, instead, they are provided to a {@link com.smartgwt.client.widgets.form.DynamicForm} via {@link
 * com.smartgwt.client.widgets.form.DynamicForm#setItems DynamicForm.setItems()} <p> See the {@link
 * com.smartgwt.client.widgets.form.DynamicForm} documentation for details and sample code.
 */
@BeanFactory.FrameworkClass
public class FormItem extends RefDataClass implements com.smartgwt.client.widgets.form.fields.events.HasBlurHandlers, com.smartgwt.client.widgets.form.fields.events.HasChangeHandlers, com.smartgwt.client.widgets.form.fields.events.HasChangedHandlers, com.smartgwt.client.widgets.form.fields.events.HasClickHandlers, com.smartgwt.client.widgets.form.fields.events.HasDoubleClickHandlers, com.smartgwt.client.widgets.form.fields.events.HasEditorEnterHandlers, com.smartgwt.client.widgets.form.fields.events.HasEditorExitHandlers, com.smartgwt.client.widgets.form.fields.events.HasFocusHandlers, com.smartgwt.client.widgets.form.fields.events.HasIconClickHandlers, com.smartgwt.client.widgets.form.fields.events.HasIconKeyPressHandlers, com.smartgwt.client.widgets.form.fields.events.HasItemHoverHandlers, com.smartgwt.client.widgets.form.fields.events.HasKeyDownHandlers, com.smartgwt.client.widgets.form.fields.events.HasKeyPressHandlers, com.smartgwt.client.widgets.form.fields.events.HasKeyUpHandlers, com.smartgwt.client.widgets.form.fields.events.HasPendingStatusChangedHandlers, com.smartgwt.client.widgets.form.fields.events.HasPickerIconClickHandlers, com.smartgwt.client.widgets.form.fields.events.HasShowContextMenuHandlers, com.smartgwt.client.widgets.form.fields.events.HasTitleClickHandlers, com.smartgwt.client.widgets.form.fields.events.HasTitleDoubleClickHandlers, com.smartgwt.client.widgets.form.fields.events.HasTitleHoverHandlers, com.smartgwt.client.widgets.form.fields.events.HasValueHoverHandlers, com.smartgwt.client.widgets.form.fields.events.HasValueIconClickHandlers {

    public static FormItem getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof FormItem) {
            existingObj.setJsObj(jsObj);
            return (FormItem)existingObj;
        } else

        {
            return FormItemFactory.getFormItem(jsObj);
        }
    }
    /** 
     * This method returns a Map of config properties suitable for use as the "defaults" 
     * attribute of a {@link com.smartgwt.client.tools.PaletteNode}.  Use it when you need to
     * work with PaletteNodes indirectly, such when setting up 
     * {@link com.smartgwt.client.widgets.tile.TileRecord}s that will be used in a 
     * {@link com.smartgwt.client.tools.TilePalette}.  See 
     * {@link com.smartgwt.client.docs.DevTools the dev tools overview} for examples of how to
     * assemble and acquire a suitable defaults object when you are creating a PaletteNode 
     * indirectly
     */
    public Map getPaletteDefaults() {
        if (isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), "getPaletteDefaults", (String)null);
        }
        return JSOHelper.convertToMap(JSOHelper.cleanProperties(getConfig(), true));
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(FormItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.FormItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(FormItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.FormItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public static native void changePickerIconDefaults(FormItemIcon defaults) /*-{
        $wnd.isc.FormItem.changeDefaults("pickerIconDefaults", defaults.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public FormItem(){
        final String className = SC.getAUTOIDClass(getClass().getName());
        setAttribute("AUTOIDClass", className);
        setAttribute("name", SC.generateID(className));
        setAttribute("_autoAssignedName", true);
        setAttribute("editorType", "FormItem");
        linkToInstanceUponCreate();
    }

    public FormItem(JavaScriptObject jsObj){
        super(jsObj);
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    /**
     * If specified this governs the HTML accessKey for the item. <P> This should be set to a character - when a user hits the
     * html accessKey modifier for the browser, plus this character, focus will be given to the item. The accessKey modifier
     * can vary by browser and platform.  <P> The following list of default behavior is for reference only, developers should
     * also consult browser documentation for additional information. <ul> <li><b>Internet Explorer (all platforms)</b>:
     * <code>Alt</code> + <i>accessKey</i></li> <li><b>Mozilla Firefox (Windows, Unix)</b>: <code>Alt+Shift</code> +
     * <i>accessKey</i></li> <li><b>Mozilla Firefox (Mac)</b>: <code>Ctrl+Opt</code> + <i>accessKey</i></li> <li><b>Chrome and
     * Safari (Windows, Unix)</b>:  <code>Alt</code> + <i>accessKey</i></li> <li><b>Chrome and Safari (Mac)</b>: 
     * <code>Ctrl+Opt</code> + <i>accessKey</i></li> </ul>
     *
     * @param accessKey New accessKey value. Default value is null
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public void setAccessKey(String accessKey) {
        setAttribute("accessKey", accessKey);
    }

    /**
     * If specified this governs the HTML accessKey for the item. <P> This should be set to a character - when a user hits the
     * html accessKey modifier for the browser, plus this character, focus will be given to the item. The accessKey modifier
     * can vary by browser and platform.  <P> The following list of default behavior is for reference only, developers should
     * also consult browser documentation for additional information. <ul> <li><b>Internet Explorer (all platforms)</b>:
     * <code>Alt</code> + <i>accessKey</i></li> <li><b>Mozilla Firefox (Windows, Unix)</b>: <code>Alt+Shift</code> +
     * <i>accessKey</i></li> <li><b>Mozilla Firefox (Mac)</b>: <code>Ctrl+Opt</code> + <i>accessKey</i></li> <li><b>Chrome and
     * Safari (Windows, Unix)</b>:  <code>Alt</code> + <i>accessKey</i></li> <li><b>Chrome and Safari (Mac)</b>: 
     * <code>Ctrl+Opt</code> + <i>accessKey</i></li> </ul>
     *
     * @return Current accessKey value. Default value is null
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public String getAccessKey()  {
        return getAttributeAsString("accessKey");
    }
    

    /**
     * Alignment of this item in its cell. Note that the alignment of text / content within this item is controlled separately
     * via {@link com.smartgwt.client.widgets.form.fields.FormItem#getTextAlign textAlign} (typically <code>textAlign</code>
     * applies to items showing a "textBox", such as a {@link com.smartgwt.client.widgets.form.fields.TextItem} or {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem}, as well as text-only form item types such as {@link
     * com.smartgwt.client.widgets.form.fields.StaticTextItem} and {@link com.smartgwt.client.widgets.form.fields.HeaderItem}).
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getApplyAlignToText applyAlignToText} is true, then the
     * <code>textAlign</code> setting, if unset, will default to the <code>align</code> setting if set.
     *
     * @param align New align value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setApplyAlignToText
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setAlign(Alignment align) {
        setAttribute("align", align == null ? null : align.getValue());
    }

    /**
     * Alignment of this item in its cell. Note that the alignment of text / content within this item is controlled separately
     * via {@link com.smartgwt.client.widgets.form.fields.FormItem#getTextAlign textAlign} (typically <code>textAlign</code>
     * applies to items showing a "textBox", such as a {@link com.smartgwt.client.widgets.form.fields.TextItem} or {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem}, as well as text-only form item types such as {@link
     * com.smartgwt.client.widgets.form.fields.StaticTextItem} and {@link com.smartgwt.client.widgets.form.fields.HeaderItem}).
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getApplyAlignToText applyAlignToText} is true, then the
     * <code>textAlign</code> setting, if unset, will default to the <code>align</code> setting if set.
     *
     * @return Current align value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getApplyAlignToText
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Alignment getAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("align"));
    }
    

    /**
     * For a form that produces filter criteria (see {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria
     * form.getValuesAsCriteria()}), allows the user to type in simple expressions to cause filtering with that operator.  For
     * example, entering "&gt;5" means values greater than 5, and "&gt;0 and &lt;5" means values between 0 and 5. <P> The
     * following table lists character sequences that can be entered as a prefix to a value,  and the corresponding {@link
     * com.smartgwt.client.types.OperatorId operator} that will be used.  <P> <table style='font-size:14;'>
     * <tr><td><b>Prefix</b></td><td><b>Operator</b></td></tr> <tr><td>&lt;</td><td>lessThan</td></tr>
     * <tr><td>&gt;</td><td>greaterThan</td></tr> <tr><td>&lt;=</td><td>lessThanOrEqual</td></tr>
     * <tr><td>&gt;=</td><td>greaterThanOrEqual</td></tr> <tr><td>someValue...someValue</td><td>betweenInclusive</td></tr>
     * <tr><td>!</td><td>notEqual</td></tr> <tr><td>^</td><td>startsWith</td></tr> <tr><td>|</td><td>endsWith</td></tr>
     * <tr><td>!^</td><td>notStartsWith plus logical not</td></tr> <tr><td>!@</td><td>notEndsWith plus logical not</td></tr>
     * <tr><td>~</td><td>contains</td></tr> <tr><td>!~</td><td>notContains</td></tr> <tr><td>$</td><td>isBlank</td></tr>
     * <tr><td>!$</td><td>notBlank</td></tr> <tr><td>#</td><td>isNull</td></tr> <tr><td>!#</td><td>isNotNull</td></tr>
     * <tr><td>==</td><td>exact match (for fields where 'contains' is the default)</td></tr> </table> <P> Two further special
     * notations are allowed: <ul> <li> /<i>regex</i>/ means the value is taken as a regular expression and applied via the
     * "regexp" operator <li> =.<i>fieldName</i> means the value should match the value of another field.  Either the
     * user-visible title of the field (field.title) or the field's name (field.name) may be used. </ul> <P> In all cases, if
     * an operator is disallowed for the field (via {@link com.smartgwt.client.data.DataSourceField#getValidOperators
     * field.validOperators} at either the dataSource or field level), the operator character is ignored (treated as part of a
     * literal value). <P> By default, the case-insensitive version of the operator is used (eg, startsWith will actually use
     * "iStartsWith").  To avoid this, explicitly set item.operator (the default operator) to any case sensitive operator (eg
     * "equals" or "contains") and case sensitive operators will be used for user-entered expressions. <P> Compound expressions
     * (including "and" and "or") are allowed only for numeric or date/time types. <P> Note that if the user does not type a
     * prefix or use other special notation as described above, the operator specified via {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOperator operator} is used, or if <code>formItem.operator</code> is
     * unspecified, a default operator chosen as described under {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOperator operator}.   <p> Also note that whatever you enter will be
     * used literally, including any whitespace characters. For example if you input '== China ' then ' China ' will be the
     * value. <p> The <code>allowExpression</code> behavior can be enabled for every field in a form via {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getAllowExpressions DynamicForm.allowExpressions}. <P> Finally, note that,
     * like {@link com.smartgwt.client.widgets.form.fields.FormItem#getOperator operator}, enabling
     * <code>allowExpressions:true</code> causes {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria
     * form.getValuesAsCriteria()}) to return {@link com.smartgwt.client.data.AdvancedCriteria}.
     *
     * @param allowExpressions New allowExpressions value. Default value is null
     * @see com.smartgwt.client.docs.AdvancedFilter AdvancedFilter overview and related methods
     */
    public void setAllowExpressions(Boolean allowExpressions) {
        setAttribute("allowExpressions", allowExpressions);
    }

    /**
     * For a form that produces filter criteria (see {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria
     * form.getValuesAsCriteria()}), allows the user to type in simple expressions to cause filtering with that operator.  For
     * example, entering "&gt;5" means values greater than 5, and "&gt;0 and &lt;5" means values between 0 and 5. <P> The
     * following table lists character sequences that can be entered as a prefix to a value,  and the corresponding {@link
     * com.smartgwt.client.types.OperatorId operator} that will be used.  <P> <table style='font-size:14;'>
     * <tr><td><b>Prefix</b></td><td><b>Operator</b></td></tr> <tr><td>&lt;</td><td>lessThan</td></tr>
     * <tr><td>&gt;</td><td>greaterThan</td></tr> <tr><td>&lt;=</td><td>lessThanOrEqual</td></tr>
     * <tr><td>&gt;=</td><td>greaterThanOrEqual</td></tr> <tr><td>someValue...someValue</td><td>betweenInclusive</td></tr>
     * <tr><td>!</td><td>notEqual</td></tr> <tr><td>^</td><td>startsWith</td></tr> <tr><td>|</td><td>endsWith</td></tr>
     * <tr><td>!^</td><td>notStartsWith plus logical not</td></tr> <tr><td>!@</td><td>notEndsWith plus logical not</td></tr>
     * <tr><td>~</td><td>contains</td></tr> <tr><td>!~</td><td>notContains</td></tr> <tr><td>$</td><td>isBlank</td></tr>
     * <tr><td>!$</td><td>notBlank</td></tr> <tr><td>#</td><td>isNull</td></tr> <tr><td>!#</td><td>isNotNull</td></tr>
     * <tr><td>==</td><td>exact match (for fields where 'contains' is the default)</td></tr> </table> <P> Two further special
     * notations are allowed: <ul> <li> /<i>regex</i>/ means the value is taken as a regular expression and applied via the
     * "regexp" operator <li> =.<i>fieldName</i> means the value should match the value of another field.  Either the
     * user-visible title of the field (field.title) or the field's name (field.name) may be used. </ul> <P> In all cases, if
     * an operator is disallowed for the field (via {@link com.smartgwt.client.data.DataSourceField#getValidOperators
     * field.validOperators} at either the dataSource or field level), the operator character is ignored (treated as part of a
     * literal value). <P> By default, the case-insensitive version of the operator is used (eg, startsWith will actually use
     * "iStartsWith").  To avoid this, explicitly set item.operator (the default operator) to any case sensitive operator (eg
     * "equals" or "contains") and case sensitive operators will be used for user-entered expressions. <P> Compound expressions
     * (including "and" and "or") are allowed only for numeric or date/time types. <P> Note that if the user does not type a
     * prefix or use other special notation as described above, the operator specified via {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOperator operator} is used, or if <code>formItem.operator</code> is
     * unspecified, a default operator chosen as described under {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOperator operator}.   <p> Also note that whatever you enter will be
     * used literally, including any whitespace characters. For example if you input '== China ' then ' China ' will be the
     * value. <p> The <code>allowExpression</code> behavior can be enabled for every field in a form via {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getAllowExpressions DynamicForm.allowExpressions}. <P> Finally, note that,
     * like {@link com.smartgwt.client.widgets.form.fields.FormItem#getOperator operator}, enabling
     * <code>allowExpressions:true</code> causes {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria
     * form.getValuesAsCriteria()}) to return {@link com.smartgwt.client.data.AdvancedCriteria}.
     *
     * @return Current allowExpressions value. Default value is null
     * @see com.smartgwt.client.docs.AdvancedFilter AdvancedFilter overview and related methods
     */
    public Boolean getAllowExpressions()  {
        return getAttributeAsBoolean("allowExpressions", true);
    }
    

    /**
     * If this form item has a specified {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * optionDataSource} and  {@link com.smartgwt.client.widgets.form.fields.FormItem#getFetchMissingValues fetchMissingValues}
     * is true, when the item value changes, a fetch will be performed against the optionDataSource to retrieve the related
     * record  if {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} is specified and the
     * new item value is not present in any valueMap explicitly specified on the item. <P> Setting this property to true means
     * that a fetch will occur against the optionDataSource  to retrieve the related record even if {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} is unset, or the item has a valueMap
     * which explicitly contains this field's value. <P> An example of a use case where this might be set would be if {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#formatValue formatValue()} or {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#formatEditorValue formatEditorValue()} were written to display
     * properties from the {@link com.smartgwt.client.widgets.form.fields.FormItem#getSelectedRecord selected record}. <P> Note
     * - for efficiency we cache the associated record once a fetch has been performed, meaning if the value changes, then
     * reverts to a previously seen value, we do not kick off an additional fetch even if this property is true. If necessary
     * this cache may be explicitly invalidated via a call to {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#invalidateDisplayValueCache invalidateDisplayValueCache()}
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param alwaysFetchMissingValues New alwaysFetchMissingValues value. Default value is false
     */
    public void setAlwaysFetchMissingValues(Boolean alwaysFetchMissingValues) {
        setAttribute("alwaysFetchMissingValues", alwaysFetchMissingValues);
    }

    /**
     * If this form item has a specified {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * optionDataSource} and  {@link com.smartgwt.client.widgets.form.fields.FormItem#getFetchMissingValues fetchMissingValues}
     * is true, when the item value changes, a fetch will be performed against the optionDataSource to retrieve the related
     * record  if {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} is specified and the
     * new item value is not present in any valueMap explicitly specified on the item. <P> Setting this property to true means
     * that a fetch will occur against the optionDataSource  to retrieve the related record even if {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} is unset, or the item has a valueMap
     * which explicitly contains this field's value. <P> An example of a use case where this might be set would be if {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#formatValue formatValue()} or {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#formatEditorValue formatEditorValue()} were written to display
     * properties from the {@link com.smartgwt.client.widgets.form.fields.FormItem#getSelectedRecord selected record}. <P> Note
     * - for efficiency we cache the associated record once a fetch has been performed, meaning if the value changes, then
     * reverts to a previously seen value, we do not kick off an additional fetch even if this property is true. If necessary
     * this cache may be explicitly invalidated via a call to {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#invalidateDisplayValueCache invalidateDisplayValueCache()}
     *
     * @return Current alwaysFetchMissingValues value. Default value is false
     */
    public Boolean getAlwaysFetchMissingValues()  {
        Boolean result = getAttributeAsBoolean("alwaysFetchMissingValues", true);
        return result == null ? false : result;
    }
    

    /**
     * A formItem showing a {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon pickerIcon} will always
     * write out a "control box" around the text box and picker icon. This is an HTML element styled using the specified {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getControlStyle controlStyle}. <P> This attribute controls whether the
     * control box should be written out even if the picker icon is not being shown. If unset, default behavior will write out
     * a control table if {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon showPickerIcon} is true and
     * the icon is not suppressed via {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#showIf
     * FormItemIcon.showIf()}. This means the control table can be written out with no visible picker if {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIconOnFocus showPickerIconOnFocus} is true and the item
     * does not have focus. <P> This attribute is useful for developers who wish to rely on styling specified via the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getControlStyle controlStyle} even while the picker icon is not
     * visible. <P> See the {@link com.smartgwt.client.docs.FormItemStyling form item styling overview} for details of the
     * control table and other styling options.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param alwaysShowControlBox New alwaysShowControlBox value. Default value is null
     */
    public void setAlwaysShowControlBox(Boolean alwaysShowControlBox) {
        setAttribute("alwaysShowControlBox", alwaysShowControlBox);
    }

    /**
     * A formItem showing a {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon pickerIcon} will always
     * write out a "control box" around the text box and picker icon. This is an HTML element styled using the specified {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getControlStyle controlStyle}. <P> This attribute controls whether the
     * control box should be written out even if the picker icon is not being shown. If unset, default behavior will write out
     * a control table if {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon showPickerIcon} is true and
     * the icon is not suppressed via {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#showIf
     * FormItemIcon.showIf()}. This means the control table can be written out with no visible picker if {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIconOnFocus showPickerIconOnFocus} is true and the item
     * does not have focus. <P> This attribute is useful for developers who wish to rely on styling specified via the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getControlStyle controlStyle} even while the picker icon is not
     * visible. <P> See the {@link com.smartgwt.client.docs.FormItemStyling form item styling overview} for details of the
     * control table and other styling options.
     *
     * @return Current alwaysShowControlBox value. Default value is null
     */
    public Boolean getAlwaysShowControlBox()  {
        return getAttributeAsBoolean("alwaysShowControlBox", true);
    }
    

    /**
     * If the {@link com.smartgwt.client.widgets.form.fields.FormItem#getTextAlign textAlign} is unset, should the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getAlign align} setting, if set, be used for this item's
     * <code>textAlign</code>? <p> <code>applyAlignToText</code> defaults to false for most form item types. It defaults to
     * true for {@link com.smartgwt.client.widgets.form.fields.StaticTextItem} and {@link
     * com.smartgwt.client.widgets.form.fields.HeaderItem}, which are text-based form item types that do not have a natural
     * distinction between the item and its cell.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param applyAlignToText New applyAlignToText value. Default value is false
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setApplyAlignToText(boolean applyAlignToText) {
        setAttribute("applyAlignToText", applyAlignToText);
    }

    /**
     * If the {@link com.smartgwt.client.widgets.form.fields.FormItem#getTextAlign textAlign} is unset, should the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getAlign align} setting, if set, be used for this item's
     * <code>textAlign</code>? <p> <code>applyAlignToText</code> defaults to false for most form item types. It defaults to
     * true for {@link com.smartgwt.client.widgets.form.fields.StaticTextItem} and {@link
     * com.smartgwt.client.widgets.form.fields.HeaderItem}, which are text-based form item types that do not have a natural
     * distinction between the item and its cell.
     *
     * @return Current applyAlignToText value. Default value is false
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public boolean getApplyAlignToText()  {
        Boolean result = getAttributeAsBoolean("applyAlignToText", true);
        return result == null ? false : result;
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getHeight height} is specified, should it be applied to the
     * item's text box element? <P> If unset, behavior is determined as described in {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#shouldApplyHeightToTextBox shouldApplyHeightToTextBox()}
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param applyHeightToTextBox New applyHeightToTextBox value. Default value is null
     */
    public void setApplyHeightToTextBox(Boolean applyHeightToTextBox) {
        setAttribute("applyHeightToTextBox", applyHeightToTextBox);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getHeight height} is specified, should it be applied to the
     * item's text box element? <P> If unset, behavior is determined as described in {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#shouldApplyHeightToTextBox shouldApplyHeightToTextBox()}
     *
     * @return Current applyHeightToTextBox value. Default value is null
     */
    public Boolean getApplyHeightToTextBox()  {
        return getAttributeAsBoolean("applyHeightToTextBox", true);
    }
    

    /**
     * ARIA role of this formItem.  Usually does not need to be manually set - see {@link
     * com.smartgwt.client.docs.Accessibility}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param ariaRole New ariaRole value. Default value is null
     * @see com.smartgwt.client.docs.Accessibility Accessibility overview and related methods
     */
    public void setAriaRole(String ariaRole) {
        setAttribute("ariaRole", ariaRole);
    }

    /**
     * ARIA role of this formItem.  Usually does not need to be manually set - see {@link
     * com.smartgwt.client.docs.Accessibility}.
     *
     * @return Current ariaRole value. Default value is null
     * @see com.smartgwt.client.docs.Accessibility Accessibility overview and related methods
     */
    public String getAriaRole()  {
        return getAttributeAsString("ariaRole");
    }
    
    

    /**
     * Should this item allow browser auto-completion of its value?  Applies only to items based on native HTML form elements
     * ({@link com.smartgwt.client.widgets.form.fields.TextItem}, {@link com.smartgwt.client.widgets.form.fields.PasswordItem},
     * etc), and will only have a user-visible impact for browsers where native autoComplete behavior is actually supported and
     * enabled via user settings. <P> Alternatively, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getAutoCompleteKeywords autoCompleteKeywords} can be specified, in
     * which case  this setting is ignored.  If <code>autoCompleteKeywords</code> are not provided, and 
     * <code>autoComplete</code> is not set on this FormItem, the value of  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getAutoComplete DynamicForm.autoComplete} is used. <P> Note that even with
     * this value set to <code>"none"</code>, native browser  auto-completion may occur for log in forms (forms containing
     * username and  {@link com.smartgwt.client.widgets.form.fields.PasswordItem password} fields). This behavior varies by
     * browser, and is a result of an  <a href='https://www.google.com/search?q=password+ignores+autocomplete+off'
     * target='_blank'>intentional change by some browser developers</a> to disregard the HTML setting <i>autocomplete=off</i>
     * for password items or log-in forms. <P> In some browsers any form redraw (including a redraw from  a call to  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setValues DynamicForm.setValues()}) will re-populate the form with the
     * natively  remembered login credentials. This can make it very difficult to control the values displayed to the user, as
     * a call to 'setValues()' may appear to be ignored. While behavior varies by browser we have specifically observed this
     * behavior in Safari. Moreover in this browser, if the user  asks the browser to remember login credentials for a URL, any
     * form with a password  item and a text item may be auto-filled with the remembered login credentials,  even if the form's
     * configuration and field names differ from those on the login form. <P> If an application has both an initial log in
     * form, and a separate form within the application which makes contains a Password item (a use case might be an interface
     * for a user with manager privileges for modifying other users' passwords), this will cause the second form to autofill
     * with unexpected values. <P> Should this arise, developers can avoid this by making the initial log in  interface into a
     * separate log in page from the main application page. This is often good practice in any case for reasons outlined in the
     *  "Authentication" section of the Quick Start guide.
     *
     * @param autoComplete New autoComplete value. Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#setAutoComplete
     */
    public void setAutoComplete(AutoComplete autoComplete) {
        setAttribute("autoComplete", autoComplete == null ? null : autoComplete.getValue());
    }

    /**
     * Should this item allow browser auto-completion of its value?  Applies only to items based on native HTML form elements
     * ({@link com.smartgwt.client.widgets.form.fields.TextItem}, {@link com.smartgwt.client.widgets.form.fields.PasswordItem},
     * etc), and will only have a user-visible impact for browsers where native autoComplete behavior is actually supported and
     * enabled via user settings. <P> Alternatively, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getAutoCompleteKeywords autoCompleteKeywords} can be specified, in
     * which case  this setting is ignored.  If <code>autoCompleteKeywords</code> are not provided, and 
     * <code>autoComplete</code> is not set on this FormItem, the value of  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getAutoComplete DynamicForm.autoComplete} is used. <P> Note that even with
     * this value set to <code>"none"</code>, native browser  auto-completion may occur for log in forms (forms containing
     * username and  {@link com.smartgwt.client.widgets.form.fields.PasswordItem password} fields). This behavior varies by
     * browser, and is a result of an  <a href='https://www.google.com/search?q=password+ignores+autocomplete+off'
     * target='_blank'>intentional change by some browser developers</a> to disregard the HTML setting <i>autocomplete=off</i>
     * for password items or log-in forms. <P> In some browsers any form redraw (including a redraw from  a call to  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setValues DynamicForm.setValues()}) will re-populate the form with the
     * natively  remembered login credentials. This can make it very difficult to control the values displayed to the user, as
     * a call to 'setValues()' may appear to be ignored. While behavior varies by browser we have specifically observed this
     * behavior in Safari. Moreover in this browser, if the user  asks the browser to remember login credentials for a URL, any
     * form with a password  item and a text item may be auto-filled with the remembered login credentials,  even if the form's
     * configuration and field names differ from those on the login form. <P> If an application has both an initial log in
     * form, and a separate form within the application which makes contains a Password item (a use case might be an interface
     * for a user with manager privileges for modifying other users' passwords), this will cause the second form to autofill
     * with unexpected values. <P> Should this arise, developers can avoid this by making the initial log in  interface into a
     * separate log in page from the main application page. This is often good practice in any case for reasons outlined in the
     *  "Authentication" section of the Quick Start guide.
     *
     * @return Current autoComplete value. Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#getAutoComplete
     */
    public AutoComplete getAutoComplete()  {
        return EnumUtil.getEnum(AutoComplete.values(), getAttribute("autoComplete"));
    }
    

    /**
     * Set of autocompletion keywords to be used with the native "autocomplete" attribute,  in accordance with the  <a
     * href='https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#autofill' target='_blank'>HTML5 Autofill
     * specification</a>. <p> When autoCompleteKeywords are provided, the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getAutoComplete autoComplete} setting is ignored.
     *
     * @param autoCompleteKeywords New autoCompleteKeywords value. Default value is null
     */
    public void setAutoCompleteKeywords(String... autoCompleteKeywords) {
        setAttribute("autoCompleteKeywords", autoCompleteKeywords);
    }

    /**
     * Set of autocompletion keywords to be used with the native "autocomplete" attribute,  in accordance with the  <a
     * href='https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#autofill' target='_blank'>HTML5 Autofill
     * specification</a>. <p> When autoCompleteKeywords are provided, the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getAutoComplete autoComplete} setting is ignored.
     *
     * @return Current autoCompleteKeywords value. Default value is null
     */
    public String[] getAutoCompleteKeywords()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("autoCompleteKeywords"));
    }
    

    /**
     * Form item input type - governs which keyboard should be displayed for mobile devices (supported on iPhone / iPad)
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param browserInputType New browserInputType value. Default value is null
     */
    public void setBrowserInputType(String browserInputType) {
        setAttribute("browserInputType", browserInputType);
    }

    /**
     * Form item input type - governs which keyboard should be displayed for mobile devices (supported on iPhone / iPad)
     *
     * @return Current browserInputType value. Default value is null
     */
    public String getBrowserInputType()  {
        return getAttributeAsString("browserInputType");
    }
    

    /**
     * If this browser supports spell-checking of text editing elements, do we want this enabled for this item? If unset the
     * property will be inherited from the containing form. <P> Notes:<br> - this property only applies to text based items
     * such as TextItem and TextAreaItem.<br> - this property is not supported on all browsers.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param browserSpellCheck New browserSpellCheck value. Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#setBrowserSpellCheck
     */
    public void setBrowserSpellCheck(Boolean browserSpellCheck) {
        setAttribute("browserSpellCheck", browserSpellCheck);
    }

    /**
     * If this browser supports spell-checking of text editing elements, do we want this enabled for this item? If unset the
     * property will be inherited from the containing form. <P> Notes:<br> - this property only applies to text based items
     * such as TextItem and TextAreaItem.<br> - this property is not supported on all browsers.
     *
     * @return Current browserSpellCheck value. Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#getBrowserSpellCheck
     */
    public Boolean getBrowserSpellCheck()  {
        return getAttributeAsBoolean("browserSpellCheck", true);
    }
    

    /**
     * Is this form item editable (canEdit:true) or read-only (canEdit:false)? Setting the form item to non-editable causes it
     * to render as read-only. Can be updated at runtime via the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setCanEdit setCanEdit()} method. <P> Read-only appearance may be
     * specified via {@link com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyDisplay readOnlyDisplay}. The default
     * setting for this value (<code>"readOnly"</code>) differs from the disabled state in that the form item is not rendered
     * with disabled styling and most form items will allow copying of the contents while read-only but do not while disabled.
     * <P> Note that for forms bound to a {@link com.smartgwt.client.data.DataSource}, if this property is not explicitly set
     * at the item level, its default value will match the {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getCanEditFieldAttribute DynamicForm.canEditFieldAttribute} on the
     * associated dataSource field. <P> Developers should also be aware that the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyDisplay readOnlyDisplay} attribute is unrelated to the
     * {@link com.smartgwt.client.data.DataSourceField#getReadOnlyEditorType DataSourceField.readOnlyEditorType} attribute.
     * When a DynamicForm is first bound to a dataSource, for {@link com.smartgwt.client.data.DataSourceField#getCanEdit
     * canEdit:false} DataSourceFields, {@link com.smartgwt.client.data.DataSourceField#getReadOnlyEditorType
     * DataSourceField.readOnlyEditorType} will determine what {@link com.smartgwt.client.types.FormItemType} should be created
     * for the field. Once created, a FormItem's type can not be changed. Setting {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit canEdit} at runtime will simply change the appearance of the
     * item to allow or disallow editing of the item. <P>Note that this property may validly be <code>null</code> as a distinct
     * state from <code>false</code>.  See {@link com.smartgwt.client.widgets.form.DynamicForm#fieldIsEditable
     * DynamicForm.fieldIsEditable()} for an API that will always return <code>true</code> or <code>false</code> and give a
     * definitive answer as to whether editing is possible.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Is this form item editable (canEdit:true) or read-only (canEdit:false)? Setting the form item to non-editable causes it to render as read-only, using the appearance specified via {@link com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyDisplay readOnlyDisplay}. <P> The default appearance for canEdit:false items (<code>readOnlyDisplay:"readOnly"</code>) differs from the disabled state in that the form item is not rendered with disabled styling and most form items will allow copying of the contents while read-only but do not while disabled.
     *
     * @param canEdit Can this form item be edited?. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setCanEdit
     * @see com.smartgwt.client.widgets.form.DynamicForm#setCanEdit
     */
    public void setCanEdit(Boolean canEdit) {
        setAttribute("canEdit", canEdit);
    }

    /**
     * Is this form item editable (canEdit:true) or read-only (canEdit:false)? Setting the form item to non-editable causes it
     * to render as read-only. Can be updated at runtime via the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setCanEdit setCanEdit()} method. <P> Read-only appearance may be
     * specified via {@link com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyDisplay readOnlyDisplay}. The default
     * setting for this value (<code>"readOnly"</code>) differs from the disabled state in that the form item is not rendered
     * with disabled styling and most form items will allow copying of the contents while read-only but do not while disabled.
     * <P> Note that for forms bound to a {@link com.smartgwt.client.data.DataSource}, if this property is not explicitly set
     * at the item level, its default value will match the {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getCanEditFieldAttribute DynamicForm.canEditFieldAttribute} on the
     * associated dataSource field. <P> Developers should also be aware that the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyDisplay readOnlyDisplay} attribute is unrelated to the
     * {@link com.smartgwt.client.data.DataSourceField#getReadOnlyEditorType DataSourceField.readOnlyEditorType} attribute.
     * When a DynamicForm is first bound to a dataSource, for {@link com.smartgwt.client.data.DataSourceField#getCanEdit
     * canEdit:false} DataSourceFields, {@link com.smartgwt.client.data.DataSourceField#getReadOnlyEditorType
     * DataSourceField.readOnlyEditorType} will determine what {@link com.smartgwt.client.types.FormItemType} should be created
     * for the field. Once created, a FormItem's type can not be changed. Setting {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit canEdit} at runtime will simply change the appearance of the
     * item to allow or disallow editing of the item. <P>Note that this property may validly be <code>null</code> as a distinct
     * state from <code>false</code>.  See {@link com.smartgwt.client.widgets.form.DynamicForm#fieldIsEditable
     * DynamicForm.fieldIsEditable()} for an API that will always return <code>true</code> or <code>false</code> and give a
     * definitive answer as to whether editing is possible.
     *
     * @return Is this form item editable or read-only? <P> This setting differs from the enabled/disabled state in that most form
     * items will allow copying of the contents while read-only but do not while disabled. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setCanEdit
     * @see com.smartgwt.client.widgets.form.DynamicForm#setCanEdit
     */
    public Boolean getCanEdit()  {
        return getAttributeAsBoolean("canEdit", true);
    }
    

    /**
     * If true, indicates that this FormItem is capable of editing "opaque" values, ie,  objects that are more complex than
     * simple primitive types like numbers, strings and dates.  Ordinarily, you use the {@link
     * com.smartgwt.client.data.SimpleType SimpleType system} to  convert these opaque values into "atomic" values that can be
     * edited by the built-in  editors like {@link com.smartgwt.client.widgets.form.fields.TextItem}.  However, sometimes you
     * to create a custom editor that knows how to edit a particular opaque type in a domain-specific way - for example, a
     * composite custom FormItem that allows the user to edit both a number and a currency  code, both of which are needed to
     * make a proper monetary amount (for that particular  application). When this value is set, the FormItem will manage the
     * opaque value directly, rather than it being filtered through calls to  {@link
     * com.smartgwt.client.data.SimpleType#getAtomicValue getAtomicValue()} and  {@link
     * com.smartgwt.client.data.SimpleType#updateAtomicValue updateAtomicValue()}.  Note, if you set this flag on a FormItem
     * that does not have the ability to edit an opaque value (which is something that must be custom-coded) then you will get
     * garbage in your editor, if not an outright crash.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canEditOpaqueValues New canEditOpaqueValues value. Default value is null
     */
    public void setCanEditOpaqueValues(Boolean canEditOpaqueValues) {
        setAttribute("canEditOpaqueValues", canEditOpaqueValues);
    }

    /**
     * If true, indicates that this FormItem is capable of editing "opaque" values, ie,  objects that are more complex than
     * simple primitive types like numbers, strings and dates.  Ordinarily, you use the {@link
     * com.smartgwt.client.data.SimpleType SimpleType system} to  convert these opaque values into "atomic" values that can be
     * edited by the built-in  editors like {@link com.smartgwt.client.widgets.form.fields.TextItem}.  However, sometimes you
     * to create a custom editor that knows how to edit a particular opaque type in a domain-specific way - for example, a
     * composite custom FormItem that allows the user to edit both a number and a currency  code, both of which are needed to
     * make a proper monetary amount (for that particular  application). When this value is set, the FormItem will manage the
     * opaque value directly, rather than it being filtered through calls to  {@link
     * com.smartgwt.client.data.SimpleType#getAtomicValue getAtomicValue()} and  {@link
     * com.smartgwt.client.data.SimpleType#updateAtomicValue updateAtomicValue()}.  Note, if you set this flag on a FormItem
     * that does not have the ability to edit an opaque value (which is something that must be custom-coded) then you will get
     * garbage in your editor, if not an outright crash.
     *
     * @return Current canEditOpaqueValues value. Default value is null
     */
    public Boolean getCanEditOpaqueValues()  {
        return getAttributeAsBoolean("canEditOpaqueValues", true);
    }
    

    /**
     * Is this form item focusable? Setting this property to true on an otherwise non-focusable element such as a {@link
     * com.smartgwt.client.widgets.form.fields.StaticTextItem} will cause the item to be included in the page's tab order and
     * respond to keyboard events.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canFocus New canFocus value. Default value is null
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public void setCanFocus(Boolean canFocus) {
        setAttribute("canFocus", canFocus);
    }

    /**
     * Is this form item focusable? Setting this property to true on an otherwise non-focusable element such as a {@link
     * com.smartgwt.client.widgets.form.fields.StaticTextItem} will cause the item to be included in the page's tab order and
     * respond to keyboard events.
     *
     * @return Returns true for items that can accept keyboard focus such as data items  ({@link
     * com.smartgwt.client.widgets.form.fields.TextItem TextItems}, {@link com.smartgwt.client.widgets.form.fields.TextAreaItem
     * TextAreaItems}, etc),  {@link com.smartgwt.client.widgets.form.fields.CanvasItem CanvasItems} with a focusable canvas,
     * or items where {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanFocus canFocus} was explicitly set to true. Default value is null
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public Boolean getCanFocus()  {
        return getAttributeAsBoolean("canFocus", true);
    }
    

    /**
     * For items showing a text value, should the user be able to select the text in this item?  <P> For {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit canEdit:false} items, see {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyCanSelectText readOnlyCanSelectText}
     *
     * @param canSelectText New canSelectText value. Default value is true
     */
    public void setCanSelectText(boolean canSelectText) {
        setAttribute("canSelectText", canSelectText);
    }

    /**
     * For items showing a text value, should the user be able to select the text in this item?  <P> For {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit canEdit:false} items, see {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyCanSelectText readOnlyCanSelectText}
     *
     * @return Current canSelectText value. Default value is true
     */
    public boolean getCanSelectText()  {
        Boolean result = getAttributeAsBoolean("canSelectText", true);
        return result == null ? true : result;
    }
    

    /**
     * Should this item's {@link com.smartgwt.client.widgets.form.fields.FormItem#getIcons icons} and  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon picker icon} be included in  the page's tab order by
     * default? If not explicitly set, this property  will be derived from {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getCanTabToIcons DynamicForm.canTabToIcons}. <P> Developers may also
     * suppress tabbing to individual icons by  setting {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getTabIndex
     * FormItemIcon.tabIndex} to <code>-1</code>. <P> Note that if this form item has tabIndex -1, neither the form item nor
     * the icons will be included in the page's tab order.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canTabToIcons New canTabToIcons value. Default value is null
     */
    public void setCanTabToIcons(Boolean canTabToIcons) {
        setAttribute("canTabToIcons", canTabToIcons);
    }

    /**
     * Should this item's {@link com.smartgwt.client.widgets.form.fields.FormItem#getIcons icons} and  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon picker icon} be included in  the page's tab order by
     * default? If not explicitly set, this property  will be derived from {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getCanTabToIcons DynamicForm.canTabToIcons}. <P> Developers may also
     * suppress tabbing to individual icons by  setting {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getTabIndex
     * FormItemIcon.tabIndex} to <code>-1</code>. <P> Note that if this form item has tabIndex -1, neither the form item nor
     * the icons will be included in the page's tab order.
     *
     * @return Current canTabToIcons value. Default value is null
     */
    public Boolean getCanTabToIcons()  {
        return getAttributeAsBoolean("canTabToIcons", true);
    }
    
    

    /**
     * If specified, this property will govern the height of the cell in which this form item is rendered. Will not apply when
     * the containing DynamicForm sets <code>itemLayout:"absolute"</code>.
     *
     * @param cellHeight New cellHeight value. Default value is null
     */
    public void setCellHeight(Integer cellHeight) {
        setAttribute("cellHeight", cellHeight);
    }

    /**
     * If specified, this property will govern the height of the cell in which this form item is rendered. Will not apply when
     * the containing DynamicForm sets <code>itemLayout:"absolute"</code>.
     *
     * @return Current cellHeight value. Default value is null
     */
    public Integer getCellHeight()  {
        return getAttributeAsInt("cellHeight");
    }
    

    /**
     * CSS style applied to the form item as a whole, including the text element, any icons, and any hint text for the item.
     * Applied to the cell containing the form item. <P> See {@link com.smartgwt.client.docs.FormItemStyling} for an overview
     * of formItem styling, and  the {@link com.smartgwt.client.docs.CompoundFormItem_skinning} discussion for special skinning
     * considerations.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.form.fields.FormItem#getCellStyle cellStyle}.
     *
     * @param cellStyle the new <code>cellStyle</code> value. Default value is "formCell"
     * @see com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle 
     * @see com.smartgwt.client.docs.FormItemStyling FormItemStyling overview and related methods
     */
    public void setCellStyle(String cellStyle) {
        setAttribute("cellStyle", cellStyle);
    }

    /**
     * CSS style applied to the form item as a whole, including the text element, any icons, and any hint text for the item.
     * Applied to the cell containing the form item. <P> See {@link com.smartgwt.client.docs.FormItemStyling} for an overview
     * of formItem styling, and  the {@link com.smartgwt.client.docs.CompoundFormItem_skinning} discussion for special skinning
     * considerations.
     *
     * @return Current cellStyle value. Default value is "formCell"
     * @see com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle 
     * @see com.smartgwt.client.docs.FormItemStyling FormItemStyling overview and related methods
     */
    public String getCellStyle()  {
        return getAttributeAsString("cellStyle");
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
     * If this item is {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit read-only} and is using {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyDisplay readOnlyDisplay}  {@link
     * com.smartgwt.client.types.ReadOnlyDisplayAppearance#STATIC}, should the item value be clipped if it overflows the
     * specified size of the item? If set, overrides the form-level {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getClipStaticValue DynamicForm.clipStaticValue} default.
     *
     * @param clipStaticValue New clipStaticValue value. Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#setClipStaticValue
     */
    public void setClipStaticValue(Boolean clipStaticValue) {
        setAttribute("clipStaticValue", clipStaticValue);
    }

    /**
     * If this item is {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit read-only} and is using {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyDisplay readOnlyDisplay}  {@link
     * com.smartgwt.client.types.ReadOnlyDisplayAppearance#STATIC}, should the item value be clipped if it overflows the
     * specified size of the item? If set, overrides the form-level {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getClipStaticValue DynamicForm.clipStaticValue} default.
     *
     * @return Current clipStaticValue value. Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#getClipStaticValue
     */
    public Boolean getClipStaticValue()  {
        return getAttributeAsBoolean("clipStaticValue", true);
    }
    

    /**
     * If the title for this form item is showing, and is too large for the available space should the title be clipped? <p>
     * Null by default - if set to true or false, overrides {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getClipItemTitles DynamicForm.clipItemTitles}.
     *
     * @param clipTitle New clipTitle value. Default value is null
     */
    public void setClipTitle(Boolean clipTitle) {
        setAttribute("clipTitle", clipTitle);
    }

    /**
     * If the title for this form item is showing, and is too large for the available space should the title be clipped? <p>
     * Null by default - if set to true or false, overrides {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getClipItemTitles DynamicForm.clipItemTitles}.
     *
     * @return Current clipTitle value. Default value is null
     */
    public Boolean getClipTitle()  {
        return getAttributeAsBoolean("clipTitle", true);
    }
    
    

    /**
     * A Read-Only pointer to the Smart GWT canvas that holds this form item. In most cases this will be the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getForm DynamicForm} containing the item but in some cases editable
     * components handle writing out form items directly. An example of this is {@link com.smartgwt.client.docs.Editing Grid
     * Editing} - when a listGrid shows per-field editors, the <code>containerWidget</code> for each item will be the listGrid
     * body. <P> Note that even if the <code>containerWidget</code> is not a DynamicForm, a DynamicForm will still exist for
     * the item (available as {@link com.smartgwt.client.widgets.form.fields.FormItem#getForm form}), allowing access to
     * standard APIs such as {@link com.smartgwt.client.widgets.form.DynamicForm#getValues DynamicForm.getValues()}
     *
     * @return Current containerWidget value. Default value is null
     */
    public Canvas getContainerWidget()  {
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("containerWidget"));
    }
    

    /**
     * Base CSS class name for a form item's "control box". This is an HTML element which contains the text box and picker icon
     * for the item. <P> See {@link com.smartgwt.client.widgets.form.fields.FormItem#getAlwaysShowControlBox
     * alwaysShowControlBox} for details on when the control box is written out. <P> See {@link
     * com.smartgwt.client.docs.FormItemStyling} for an overview of formItem styling, and  the {@link
     * com.smartgwt.client.docs.CompoundFormItem_skinning} discussion for special skinning considerations.
     *
     * @param controlStyle New controlStyle value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setCellStyle
     * @see com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle 
     * @see com.smartgwt.client.docs.FormItemStyling FormItemStyling overview and related methods
     */
    public void setControlStyle(String controlStyle) {
        setAttribute("controlStyle", controlStyle);
    }

    /**
     * Base CSS class name for a form item's "control box". This is an HTML element which contains the text box and picker icon
     * for the item. <P> See {@link com.smartgwt.client.widgets.form.fields.FormItem#getAlwaysShowControlBox
     * alwaysShowControlBox} for details on when the control box is written out. <P> See {@link
     * com.smartgwt.client.docs.FormItemStyling} for an overview of formItem styling, and  the {@link
     * com.smartgwt.client.docs.CompoundFormItem_skinning} discussion for special skinning considerations.
     *
     * @return Current controlStyle value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getCellStyle
     * @see com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle 
     * @see com.smartgwt.client.docs.FormItemStyling FormItemStyling overview and related methods
     */
    public String getControlStyle()  {
        return getAttributeAsString("controlStyle");
    }
    

    /**
     * When using {@link com.smartgwt.client.widgets.form.fields.FormItem#getOperator operator}, the name of the DataSource
     * field for the {@link com.smartgwt.client.data.Criterion} this FormItem generates.  If not specified, defaults to {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getName name}. <P> Generally, because <code>criteriaField</code>
     * defaults to <code>item.name</code>, you don't need to specify it.  However, if more than one FormItem specifies criteria
     * for the same DataSource field, they will need unique values for {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getName name} but should set {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCriteriaField criteriaField} to the name of DataSource field they
     * both target. <P> For example, if two DateItems are used to provide a min and max date for a single field called
     * "joinDate", set {@link com.smartgwt.client.widgets.form.fields.FormItem#getCriteriaField criteriaField} to "joinDate" on
     * both fields but give the fields distinct names (eg "minDate" and "maxDate") and use those names for any programmatic
     * access, such as {@link com.smartgwt.client.widgets.form.DynamicForm#setValue DynamicForm.setValue()}.
     *
     * @param criteriaField New criteriaField value. Default value is null
     * @see com.smartgwt.client.docs.FieldName FieldName 
     */
    public void setCriteriaField(String criteriaField) {
        setAttribute("criteriaField", criteriaField);
    }

    /**
     * When using {@link com.smartgwt.client.widgets.form.fields.FormItem#getOperator operator}, the name of the DataSource
     * field for the {@link com.smartgwt.client.data.Criterion} this FormItem generates.  If not specified, defaults to {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getName name}. <P> Generally, because <code>criteriaField</code>
     * defaults to <code>item.name</code>, you don't need to specify it.  However, if more than one FormItem specifies criteria
     * for the same DataSource field, they will need unique values for {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getName name} but should set {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCriteriaField criteriaField} to the name of DataSource field they
     * both target. <P> For example, if two DateItems are used to provide a min and max date for a single field called
     * "joinDate", set {@link com.smartgwt.client.widgets.form.fields.FormItem#getCriteriaField criteriaField} to "joinDate" on
     * both fields but give the fields distinct names (eg "minDate" and "maxDate") and use those names for any programmatic
     * access, such as {@link com.smartgwt.client.widgets.form.DynamicForm#setValue DynamicForm.setValue()}.
     *
     * @return Current criteriaField value. Default value is null
     * @see com.smartgwt.client.docs.FieldName FieldName 
     */
    public String getCriteriaField()  {
        return getAttributeAsString("criteriaField");
    }
    

    /**
     * dataPath for this item. Allows the user to edit details nested data structures in a flat set of form fields <P> Note
     * that an item must have a valid dataPath or {@link com.smartgwt.client.widgets.form.fields.FormItem#getName name} in
     * order for its value to be validated and/or saved.
     *
     * @param dataPath New dataPath value. Default value is null
     * @see com.smartgwt.client.docs.DataPath DataPath 
     */
    public void setDataPath(String dataPath) {
        setAttribute("dataPath", dataPath);
    }

    /**
     * dataPath for this item. Allows the user to edit details nested data structures in a flat set of form fields <P> Note
     * that an item must have a valid dataPath or {@link com.smartgwt.client.widgets.form.fields.FormItem#getName name} in
     * order for its value to be validated and/or saved.
     *
     * @return Return the dataPath for the this formItem. Default value is null
     * @see com.smartgwt.client.docs.DataPath DataPath 
     */
    public String getDataPath()  {
        return getAttributeAsString("dataPath");
    }
    

    /**
     * Display format to use for date type values within this formItem. <P> Note that Fields of type <code>"date"</code>,
     * <code>"datetime"</code> or  <code>"time"</code> will be edited using a {@link
     * com.smartgwt.client.widgets.form.fields.DateItem} or {@link com.smartgwt.client.widgets.form.fields.TimeItem} by 
     * default, but this can be overridden - for <code>canEdit:false</code> fields, a {@link
     * com.smartgwt.client.widgets.form.fields.StaticTextItem} is used by default, and the developer can always specify  a
     * custom {@link com.smartgwt.client.widgets.form.fields.FormItem#getEditorType editorType} as well as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getType data type}. <P> The {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTimeFormatter timeFormatter} may also be used to format underlying
     * Date values as times (ommitting the date part entirely). If both <code>dateFormatter</code> and
     * <code>timeFormatter</code> are specified on an item, for fields specified as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getType type "time"} the <code>timeFormatter</code> will be used,
     * otherwise the <code>dateFormatter</code> <P> If <code>item.dateFormatter</code> and <code>item.timeFormatter</code> is
     * unspecified, date display format may be defined at the component level via {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getDateFormatter DynamicForm.dateFormatter}, or for fields of type
     * <code>"datetime"</code> {@link com.smartgwt.client.widgets.form.DynamicForm#getDatetimeFormatter
     * DynamicForm.datetimeFormatter}. Otherwise the default is to use the system-wide default short date format, configured
     * via {@link com.smartgwt.client.util.DateUtil#setShortDisplayFormat DateUtil.setShortDisplayFormat()}.  Specify any valid
     * {@link com.smartgwt.client.types.DateDisplayFormat} to change the format used by this item. <P> Note that if this is a
     * freeform editable field, such a {@link com.smartgwt.client.widgets.form.fields.TextItem}, with type specified as
     * <code>"date"</code> or <code>"datetime"</code> the system will automatically attempt to parse user entered values back
     * to a Date value, assuming the entered string matches the date format for the field. Developers may further customize
     * this via an explicit {@link com.smartgwt.client.widgets.form.fields.FormItem#getInputFormat inputFormat} or via entirely
     * custom   <code>setEditorValueFormatter</code> and <code>setEditorValueParser</code> methods.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param dateFormatter New dateFormatter value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setTimeFormatter
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setFormat
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setDateFormatter(DateDisplayFormat dateFormatter) {
        setAttribute("dateFormatter", dateFormatter == null ? null : dateFormatter.getValue());
    }

    /**
     * Display format to use for date type values within this formItem. <P> Note that Fields of type <code>"date"</code>,
     * <code>"datetime"</code> or  <code>"time"</code> will be edited using a {@link
     * com.smartgwt.client.widgets.form.fields.DateItem} or {@link com.smartgwt.client.widgets.form.fields.TimeItem} by 
     * default, but this can be overridden - for <code>canEdit:false</code> fields, a {@link
     * com.smartgwt.client.widgets.form.fields.StaticTextItem} is used by default, and the developer can always specify  a
     * custom {@link com.smartgwt.client.widgets.form.fields.FormItem#getEditorType editorType} as well as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getType data type}. <P> The {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTimeFormatter timeFormatter} may also be used to format underlying
     * Date values as times (ommitting the date part entirely). If both <code>dateFormatter</code> and
     * <code>timeFormatter</code> are specified on an item, for fields specified as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getType type "time"} the <code>timeFormatter</code> will be used,
     * otherwise the <code>dateFormatter</code> <P> If <code>item.dateFormatter</code> and <code>item.timeFormatter</code> is
     * unspecified, date display format may be defined at the component level via {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getDateFormatter DynamicForm.dateFormatter}, or for fields of type
     * <code>"datetime"</code> {@link com.smartgwt.client.widgets.form.DynamicForm#getDatetimeFormatter
     * DynamicForm.datetimeFormatter}. Otherwise the default is to use the system-wide default short date format, configured
     * via {@link com.smartgwt.client.util.DateUtil#setShortDisplayFormat DateUtil.setShortDisplayFormat()}.  Specify any valid
     * {@link com.smartgwt.client.types.DateDisplayFormat} to change the format used by this item. <P> Note that if this is a
     * freeform editable field, such a {@link com.smartgwt.client.widgets.form.fields.TextItem}, with type specified as
     * <code>"date"</code> or <code>"datetime"</code> the system will automatically attempt to parse user entered values back
     * to a Date value, assuming the entered string matches the date format for the field. Developers may further customize
     * this via an explicit {@link com.smartgwt.client.widgets.form.fields.FormItem#getInputFormat inputFormat} or via entirely
     * custom   <code>setEditorValueFormatter</code> and <code>setEditorValueParser</code> methods.
     *
     * @return Current dateFormatter value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getTimeFormatter
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getFormat
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public DateDisplayFormat getDateFormatter()  {
        return EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("dateFormatter"));
    }
    

    /**
     * Applies only to fields of type "float" and enforces a minimum number of digits shown after the decimal point. <P> For
     * example, a field value of 343.1, 343.104 and 343.09872677 would all be shown as 343.10 if decimalPad is 2. <P> The
     * original unpadded value is always shown when the value is edited.
     *
     * @param decimalPad New decimalPad value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setDecimalPad(Integer decimalPad) {
        setAttribute("decimalPad", decimalPad);
    }

    /**
     * Applies only to fields of type "float" and enforces a minimum number of digits shown after the decimal point. <P> For
     * example, a field value of 343.1, 343.104 and 343.09872677 would all be shown as 343.10 if decimalPad is 2. <P> The
     * original unpadded value is always shown when the value is edited.
     *
     * @return Current decimalPad value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Integer getDecimalPad()  {
        return getAttributeAsInt("decimalPad");
    }
    

    /**
     * Applies only to fields of type "float" and affects how many significant digits are shown. <P> For example, with
     * decimalPrecision 3, if the field value is 343.672677, 343.673 is shown. <P> If the value is 125.2, 125.2 is shown -
     * decimalPrecision will not cause extra zeros to be added.  Use {@link
     * com.smartgwt.client.data.DataSourceField#getDecimalPad DataSourceField.decimalPad} for this. <P> A number is always
     * shown with its original precision when edited.
     *
     * @param decimalPrecision New decimalPrecision value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setDecimalPrecision(Integer decimalPrecision) {
        setAttribute("decimalPrecision", decimalPrecision);
    }

    /**
     * Applies only to fields of type "float" and affects how many significant digits are shown. <P> For example, with
     * decimalPrecision 3, if the field value is 343.672677, 343.673 is shown. <P> If the value is 125.2, 125.2 is shown -
     * decimalPrecision will not cause extra zeros to be added.  Use {@link
     * com.smartgwt.client.data.DataSourceField#getDecimalPad DataSourceField.decimalPad} for this. <P> A number is always
     * shown with its original precision when edited.
     *
     * @return Current decimalPrecision value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Integer getDecimalPrecision()  {
        return getAttributeAsInt("decimalPrecision");
    }
    

    /**
     * Default icon image source.      Specify as the partial URL to an image, relative to the imgDir of this component. To
     * specify image source for a specific icon use the <code>icon.src</code> property.<br> If this item is drawn in the
     * disabled state, the url will be modified by adding  "_Disabled" to get a disabled state image for the icon. If
     * <code>icon.showOver</code> is true, this url will be modified by adding "_Over" to get an over state image for the icon.
     * <P> {@link com.smartgwt.client.docs.Skinning Spriting} can be used for this image, by setting this property to a {@link
     * com.smartgwt.client.docs.SCSpriteConfig} formatted string.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param defaultIconSrc New defaultIconSrc value. Default value is "[SKIN]/DynamicForm/default_formItem_icon.gif"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public void setDefaultIconSrc(String defaultIconSrc) {
        setAttribute("defaultIconSrc", defaultIconSrc);
    }

    /**
     * Default icon image source.      Specify as the partial URL to an image, relative to the imgDir of this component. To
     * specify image source for a specific icon use the <code>icon.src</code> property.<br> If this item is drawn in the
     * disabled state, the url will be modified by adding  "_Disabled" to get a disabled state image for the icon. If
     * <code>icon.showOver</code> is true, this url will be modified by adding "_Over" to get an over state image for the icon.
     * <P> {@link com.smartgwt.client.docs.Skinning Spriting} can be used for this image, by setting this property to a {@link
     * com.smartgwt.client.docs.SCSpriteConfig} formatted string.
     *
     * @return Current defaultIconSrc value. Default value is "[SKIN]/DynamicForm/default_formItem_icon.gif"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getDefaultIconSrc()  {
        return getAttributeAsString("defaultIconSrc");
    }
    

    /**
     * The default search-operator for this item when it or its form allow  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getAllowExpressions filter-expressions}.
     *
     * @param defaultOperator New defaultOperator value. Default value is null
     * @see com.smartgwt.client.docs.AdvancedFilter AdvancedFilter overview and related methods
     */
    public void setDefaultOperator(OperatorId defaultOperator) {
        setAttribute("defaultOperator", defaultOperator == null ? null : defaultOperator.getValue());
    }

    /**
     * The default search-operator for this item when it or its form allow  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getAllowExpressions filter-expressions}.
     *
     * @return Current defaultOperator value. Default value is null
     * @see com.smartgwt.client.docs.AdvancedFilter AdvancedFilter overview and related methods
     */
    public OperatorId getDefaultOperator()  {
        return EnumUtil.getEnum(OperatorId.values(), getAttribute("defaultOperator"));
    }
    
    

    /**
     * The destroyed attribute will be set to true if this item has been destroyed() Note that FormItem lifecycle is managed by
     * the DynamicForm itself.  FormItem instances are created and destroyed automatically when new fields are  added to the
     * form.
     *
     * @return Current destroyed value. Default value is null
     */
    public Boolean getDestroyed()  {
        return getAttributeAsBoolean("destroyed", true);
    }
    

    /**
     * Whether this item is disabled.  Can be updated at runtime via the <code>setDisabled()</code> method.  Note that if the
     * widget containing this formItem is disabled, the formItem will behave in a disabled manner regardless of the setting of
     * the item.disabled property. <p> Note that not all items can be disabled, and not all browsers show an obvious disabled
     * style for native form elements.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set this item to be enabled or disabled at runtime.
     *
     * @param disabled true if this item should be disabled. Default value is false
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setDisabled
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_dep_enable_disable" target="examples">Enable & Disable Example</a>
     */
    public void setDisabled(Boolean disabled) {
        setAttribute("disabled", disabled);
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit canEdit} is set to false, should {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getIcons icons} be disabled by default? <P> This may also be specified
     * at the icon level. See {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getDisableOnReadOnly
     * FormItemIcon.disableOnReadOnly}.
     *
     * @param disableIconsOnReadOnly New disableIconsOnReadOnly value. Default value is true
     */
    public void setDisableIconsOnReadOnly(Boolean disableIconsOnReadOnly) {
        setAttribute("disableIconsOnReadOnly", disableIconsOnReadOnly);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit canEdit} is set to false, should {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getIcons icons} be disabled by default? <P> This may also be specified
     * at the icon level. See {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getDisableOnReadOnly
     * FormItemIcon.disableOnReadOnly}.
     *
     * @return Current disableIconsOnReadOnly value. Default value is true
     */
    public Boolean getDisableIconsOnReadOnly()  {
        Boolean result = getAttributeAsBoolean("disableIconsOnReadOnly", true);
        return result == null ? true : result;
    }
    

    /**
     * If set, this item will display a value from another field to the user instead of showing the underlying data value for
     * the {@link com.smartgwt.client.widgets.form.fields.FormItem#getName field name}. <P> This property is used in two ways:
     * <P> The item will display the displayField value from the  {@link com.smartgwt.client.widgets.form.DynamicForm#getValues
     * record currently being edited} if  {@link com.smartgwt.client.widgets.form.fields.FormItem#getUseLocalDisplayFieldValue
     * useLocalDisplayFieldValue} is true, (or if unset and the conditions outlined in the documentation for that property are
     * met). <P> If this field has an {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * optionDataSource}, this property is used by default to identify which value to use as a display value in records from
     * this related dataSource. In this usage the specified displayField must be  explicitly defined in the optionDataSource to
     * be used - see  {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayFieldName getDisplayFieldName()} for
     * more on this behavior.<br> If not using {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getUseLocalDisplayFieldValue local display values}, the display value
     * for this item will be derived by performing a fetch against the  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource option dataSource}  to find a record where the
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueFieldName value field} matches  this item's value, and
     * use the <code>displayField</code> value from that record.<br> In addition to this, PickList-based form items that
     * provide a list of possible options such as the {@link com.smartgwt.client.widgets.form.fields.SelectItem} or {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem} will show the  <code>displayField</code> values to the user by
     * default, allowing them to choose a new data value (see {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueField valueField}) from a list of user-friendly display values.
     * <P> This essentially allows the specified <code>optionDataSource</code> to be used as a server based {@link valueMap}.
     * <P> If {@link com.smartgwt.client.widgets.form.fields.FormItem#getUseLocalDisplayFieldValue local display values} are
     * being used and {@link com.smartgwt.client.widgets.form.fields.FormItem#getStoreDisplayValues storeDisplayValues} is
     * true, selecting a new value will update both the value for this field and the associated display-field value on the
     * record being edited. <P> Note: Developers may specify the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getForeignDisplayField foreignDisplayField} property  in addition to
     * <code>displayField</code>. This is useful for cases where the display field name in the local dataSource differs from
     * the display field name in the optionDataSource. See the documentation for {@link
     * com.smartgwt.client.data.DataSourceField#getForeignDisplayField DataSourceField.foreignDisplayField} for more on this.
     * <P> Note that if <code>optionDataSource</code> is set and no valid display field is specified, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayFieldName getDisplayFieldName()} will return the dataSource
     * title  field by default. <P> If a displayField is specified for a freeform text based item (such as a  {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem}), any user-entered value will be treated as a display value. In
     * this scenario, items will derive the data value for the item from the first record where the displayField value matches
     * the user-entered value. To avoid ambiguity, developers may wish to avoid this usage if display values are not unique.
     *
     * @param displayField New displayField value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getDisplayFieldName
     * @see com.smartgwt.client.widgets.form.fields.FormItem#invalidateDisplayValueCache
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public void setDisplayField(String displayField) {
        setAttribute("displayField", displayField);
    }

    /**
     * If set, this item will display a value from another field to the user instead of showing the underlying data value for
     * the {@link com.smartgwt.client.widgets.form.fields.FormItem#getName field name}. <P> This property is used in two ways:
     * <P> The item will display the displayField value from the  {@link com.smartgwt.client.widgets.form.DynamicForm#getValues
     * record currently being edited} if  {@link com.smartgwt.client.widgets.form.fields.FormItem#getUseLocalDisplayFieldValue
     * useLocalDisplayFieldValue} is true, (or if unset and the conditions outlined in the documentation for that property are
     * met). <P> If this field has an {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * optionDataSource}, this property is used by default to identify which value to use as a display value in records from
     * this related dataSource. In this usage the specified displayField must be  explicitly defined in the optionDataSource to
     * be used - see  {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayFieldName getDisplayFieldName()} for
     * more on this behavior.<br> If not using {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getUseLocalDisplayFieldValue local display values}, the display value
     * for this item will be derived by performing a fetch against the  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource option dataSource}  to find a record where the
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueFieldName value field} matches  this item's value, and
     * use the <code>displayField</code> value from that record.<br> In addition to this, PickList-based form items that
     * provide a list of possible options such as the {@link com.smartgwt.client.widgets.form.fields.SelectItem} or {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem} will show the  <code>displayField</code> values to the user by
     * default, allowing them to choose a new data value (see {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueField valueField}) from a list of user-friendly display values.
     * <P> This essentially allows the specified <code>optionDataSource</code> to be used as a server based {@link valueMap}.
     * <P> If {@link com.smartgwt.client.widgets.form.fields.FormItem#getUseLocalDisplayFieldValue local display values} are
     * being used and {@link com.smartgwt.client.widgets.form.fields.FormItem#getStoreDisplayValues storeDisplayValues} is
     * true, selecting a new value will update both the value for this field and the associated display-field value on the
     * record being edited. <P> Note: Developers may specify the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getForeignDisplayField foreignDisplayField} property  in addition to
     * <code>displayField</code>. This is useful for cases where the display field name in the local dataSource differs from
     * the display field name in the optionDataSource. See the documentation for {@link
     * com.smartgwt.client.data.DataSourceField#getForeignDisplayField DataSourceField.foreignDisplayField} for more on this.
     * <P> Note that if <code>optionDataSource</code> is set and no valid display field is specified, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayFieldName getDisplayFieldName()} will return the dataSource
     * title  field by default. <P> If a displayField is specified for a freeform text based item (such as a  {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem}), any user-entered value will be treated as a display value. In
     * this scenario, items will derive the data value for the item from the first record where the displayField value matches
     * the user-entered value. To avoid ambiguity, developers may wish to avoid this usage if display values are not unique.
     *
     * @return Returns the <code>displayField</code> for this item. <P> Behavior varies based on the configuration of this item, as
     * follows: <ul><li>If this item has an {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * optionDataSource} and an explicit   {@link com.smartgwt.client.widgets.form.fields.FormItem#getForeignDisplayField
     * foreignDisplayField} is specified, this will be returned.</li> <li>Otherwise if an explicit {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} is specified it will be returned   by
     * default. If the <code>displayField</code> was specified on the underlying   dataSource field, and no matching field is
     * present in the {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource} for  the
     * item, we avoid returning the specified displayField value and instead return the  title field of the option DataSource.
     * We do this to  avoid confusion for the case where the displayField is intended as a display-field  value for showing
     * another field value within the same record in the underlying  dataSource only.</li> <li>If no explicit foreignDisplay or
     * displayField   specification was found, and the {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueField
     * valueField} for this item is hidden in the   {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * optionDataSource}, this method will return the title field for   the <code>optionDataSource</code>.</li></ul>. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getDisplayFieldName
     * @see com.smartgwt.client.widgets.form.fields.FormItem#invalidateDisplayValueCache
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public String getDisplayField()  {
        return getAttributeAsString("displayField");
    }
    
    
    

    /**
     * Custom CSS text to be applied to cells with pending edits that have not yet been submitted.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param editPendingCSSText New editPendingCSSText value. Default value is "color:#0066CC;"
     * @see com.smartgwt.client.docs.CSSText CSSText 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setEditPendingCSSText(String editPendingCSSText) {
        setAttribute("editPendingCSSText", editPendingCSSText);
    }

    /**
     * Custom CSS text to be applied to cells with pending edits that have not yet been submitted.
     *
     * @return Current editPendingCSSText value. Default value is "color:#0066CC;"
     * @see com.smartgwt.client.docs.CSSText CSSText 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getEditPendingCSSText()  {
        return getAttributeAsString("editPendingCSSText");
    }
    

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @param editProxyConstructor New editProxyConstructor value. Default value is "FormItemEditProxy"
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public void setEditProxyConstructor(String editProxyConstructor) {
        setAttribute("editProxyConstructor", editProxyConstructor);
    }

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @return Current editProxyConstructor value. Default value is "FormItemEditProxy"
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public String getEditProxyConstructor()  {
        return getAttributeAsString("editProxyConstructor");
    }
    

    /**
     * Text to display when this form item has a null or undefined value. <P> If the formItem has a databound pickList, and its
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} or {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueField valueField} (if the former isn't set) has an undefined
     * {@link com.smartgwt.client.widgets.grid.ListGridField#getEmptyCellValue emptyCellValue} setting, that field's
     * <code>emptyCellValue</code> will automatically be set to the <code>emptyDisplayValue</code>.
     *
     * @param emptyDisplayValue New emptyDisplayValue value. Default value is ""
     */
    public void setEmptyDisplayValue(String emptyDisplayValue) {
        setAttribute("emptyDisplayValue", emptyDisplayValue);
    }

    /**
     * Text to display when this form item has a null or undefined value. <P> If the formItem has a databound pickList, and its
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} or {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueField valueField} (if the former isn't set) has an undefined
     * {@link com.smartgwt.client.widgets.grid.ListGridField#getEmptyCellValue emptyCellValue} setting, that field's
     * <code>emptyCellValue</code> will automatically be set to the <code>emptyDisplayValue</code>.
     *
     * @return Current emptyDisplayValue value. Default value is ""
     */
    public String getEmptyDisplayValue()  {
        return getAttributeAsString("emptyDisplayValue");
    }
    

    /**
     * This property allows the developer to specify an icon to display when this item has no value. It is configured in the
     * same way as any other valueIcon  (see {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons})
     *
     * @param emptyValueIcon New emptyValueIcon value. Default value is null
     */
    public void setEmptyValueIcon(String emptyValueIcon) {
        setAttribute("emptyValueIcon", emptyValueIcon);
    }

    /**
     * This property allows the developer to specify an icon to display when this item has no value. It is configured in the
     * same way as any other valueIcon  (see {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons})
     *
     * @return Current emptyValueIcon value. Default value is null
     */
    public String getEmptyValueIcon()  {
        return getAttributeAsString("emptyValueIcon");
    }
    

    /**
     * Whether this item should end the row it's in in the form layout
     *
     * @param endRow New endRow value. Default value is false
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public void setEndRow(Boolean endRow) {
        setAttribute("endRow", endRow);
    }

    /**
     * Whether this item should end the row it's in in the form layout
     *
     * @return Current endRow value. Default value is false
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public Boolean getEndRow()  {
        Boolean result = getAttributeAsBoolean("endRow", true);
        return result == null ? false : result;
    }
    
    

    /**
     * Height of the error icon, if we're showing icons when validation errors occur.
     *
     * @param errorIconHeight New errorIconHeight value. Default value is 16
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setShowErrorIcon
     */
    public void setErrorIconHeight(int errorIconHeight) {
        setAttribute("errorIconHeight", errorIconHeight);
    }

    /**
     * Height of the error icon, if we're showing icons when validation errors occur.
     *
     * @return Current errorIconHeight value. Default value is 16
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getShowErrorIcon
     */
    public int getErrorIconHeight()  {
        return getAttributeAsInt("errorIconHeight");
    }
    

    /**
     * URL of the image to show as an error icon, if we're showing icons when validation errors occur.
     *
     * @param errorIconSrc New errorIconSrc value. Default value is "[SKIN]/DynamicForm/validation_error_icon.png"
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setShowErrorIcon
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public void setErrorIconSrc(String errorIconSrc) {
        setAttribute("errorIconSrc", errorIconSrc);
    }

    /**
     * URL of the image to show as an error icon, if we're showing icons when validation errors occur.
     *
     * @return Current errorIconSrc value. Default value is "[SKIN]/DynamicForm/validation_error_icon.png"
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getShowErrorIcon
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getErrorIconSrc()  {
        return getAttributeAsString("errorIconSrc");
    }
    

    /**
     * Height of the error icon, if we're showing icons when validation errors occur.
     *
     * @param errorIconWidth New errorIconWidth value. Default value is 16
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setShowErrorIcon
     */
    public void setErrorIconWidth(int errorIconWidth) {
        setAttribute("errorIconWidth", errorIconWidth);
    }

    /**
     * Height of the error icon, if we're showing icons when validation errors occur.
     *
     * @return Current errorIconWidth value. Default value is 16
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getShowErrorIcon
     */
    public int getErrorIconWidth()  {
        return getAttributeAsInt("errorIconWidth");
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.form.DynamicForm#getShowInlineErrors DynamicForm.showInlineErrors} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowErrorText showErrorText} are both true and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorOrientation errorOrientation} is "left" or "right",
     * errorMessageWidth is the amount to reduce the width of the editor to accommodate the error message and icon.
     *
     * @param errorMessageWidth New errorMessageWidth value. Default value is 80
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public void setErrorMessageWidth(int errorMessageWidth) {
        setAttribute("errorMessageWidth", errorMessageWidth);
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.DynamicForm#getShowInlineErrors DynamicForm.showInlineErrors} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowErrorText showErrorText} are both true and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorOrientation errorOrientation} is "left" or "right",
     * errorMessageWidth is the amount to reduce the width of the editor to accommodate the error message and icon.
     *
     * @return Current errorMessageWidth value. Default value is 80
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public int getErrorMessageWidth()  {
        return getAttributeAsInt("errorMessageWidth");
    }
    
    

    /**
     * {@link com.smartgwt.client.docs.FormatString} used during exports for numeric or date formatting.  See {@link
     * com.smartgwt.client.data.DataSourceField#getExportFormat DataSourceField.exportFormat}.
     *
     * @param exportFormat New exportFormat value. Default value is null
     * @see com.smartgwt.client.docs.FormatString FormatString 
     * @see com.smartgwt.client.docs.ExportFormatting ExportFormatting overview and related methods
     */
    public void setExportFormat(String exportFormat) {
        setAttribute("exportFormat", exportFormat);
    }

    /**
     * {@link com.smartgwt.client.docs.FormatString} used during exports for numeric or date formatting.  See {@link
     * com.smartgwt.client.data.DataSourceField#getExportFormat DataSourceField.exportFormat}.
     *
     * @return Current exportFormat value. Default value is null
     * @see com.smartgwt.client.docs.FormatString FormatString 
     * @see com.smartgwt.client.docs.ExportFormatting ExportFormatting overview and related methods
     */
    public String getExportFormat()  {
        return getAttributeAsString("exportFormat");
    }
    

    /**
     * If this form item has a specified {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * optionDataSource}, should the item ever perform a fetch against this dataSource to retrieve the related record. <P> The
     * fetch occurs if the item value is non null on initial draw of the form or whenever setValue() is called. Once the fetch
     * completes, the returned record  is available via the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getSelectedRecord getSelectedRecord()} api. <P> By default, a fetch
     * will only occur if {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} is specified,
     * and the item does not have an explicit {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueMap valueMap}
     * containing the data value as a key.<br> However you can also set {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getAlwaysFetchMissingValues alwaysFetchMissingValues} to have a fetch
     * occur even if no <code>displayField</code> is specified. This ensures  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getSelectedRecord getSelectedRecord()} will return a record if possible
     * - useful for custom formatter functions, etc. <P> Note - for efficiency we cache the associated record once a fetch has
     * been performed, meaning if the value changes, then reverts to a previously seen value, we do not kick off an additional
     * fetch to pick up the display value for the previously seen data value. If necessary this cache may be explicitly
     * invalidated via a call to  {@link com.smartgwt.client.widgets.form.fields.FormItem#invalidateDisplayValueCache
     * invalidateDisplayValueCache()}
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
     * optionDataSource}, should the item ever perform a fetch against this dataSource to retrieve the related record. <P> The
     * fetch occurs if the item value is non null on initial draw of the form or whenever setValue() is called. Once the fetch
     * completes, the returned record  is available via the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getSelectedRecord getSelectedRecord()} api. <P> By default, a fetch
     * will only occur if {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} is specified,
     * and the item does not have an explicit {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueMap valueMap}
     * containing the data value as a key.<br> However you can also set {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getAlwaysFetchMissingValues alwaysFetchMissingValues} to have a fetch
     * occur even if no <code>displayField</code> is specified. This ensures  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getSelectedRecord getSelectedRecord()} will return a record if possible
     * - useful for custom formatter functions, etc. <P> Note - for efficiency we cache the associated record once a fetch has
     * been performed, meaning if the value changes, then reverts to a previously seen value, we do not kick off an additional
     * fetch to pick up the display value for the previously seen data value. If necessary this cache may be explicitly
     * invalidated via a call to  {@link com.smartgwt.client.widgets.form.fields.FormItem#invalidateDisplayValueCache
     * invalidateDisplayValueCache()}
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
     * If this form item is mapping data values to a display value by fetching records from a  dataSource (see {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField}  and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getFetchMissingValues fetchMissingValues}), setting this property to
     * true ensures that when the form item value is set, entire data-set from the dataSource is loaded at once and  used as a
     * valueMap, rather than just loading the display value for the current value. This avoids the need to perform fetches each
     * time setValue() is called with a new value. <P> See also  PickList.filterLocally for behavior on form items such as
     * SelectItems that show pick-lists.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param filterLocally New filterLocally value. Default value is null
     */
    public void setFilterLocally(Boolean filterLocally) {
        setAttribute("filterLocally", filterLocally);
    }

    /**
     * If this form item is mapping data values to a display value by fetching records from a  dataSource (see {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField}  and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getFetchMissingValues fetchMissingValues}), setting this property to
     * true ensures that when the form item value is set, entire data-set from the dataSource is loaded at once and  used as a
     * valueMap, rather than just loading the display value for the current value. This avoids the need to perform fetches each
     * time setValue() is called with a new value. <P> See also  PickList.filterLocally for behavior on form items such as
     * SelectItems that show pick-lists.
     *
     * @return Current filterLocally value. Default value is null
     */
    public Boolean getFilterLocally()  {
        return getAttributeAsBoolean("filterLocally", true);
    }
    

    /**
     * For items with an {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource}, this
     * property specifies an explicit display field for records within the option dataSource. Typically this property will be
     * set in conjunction with {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} in the
     * case where the name of the displayField within the record being edited differs from the  displayField in the
     * optionDataSource. <P> See {@link com.smartgwt.client.data.DataSourceField#getForeignDisplayField
     * DataSourceField.foreignDisplayField} for additional details.
     *
     * @param foreignDisplayField New foreignDisplayField value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getDisplayFieldName
     */
    public void setForeignDisplayField(String foreignDisplayField) {
        setAttribute("foreignDisplayField", foreignDisplayField);
    }

    /**
     * For items with an {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource}, this
     * property specifies an explicit display field for records within the option dataSource. Typically this property will be
     * set in conjunction with {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} in the
     * case where the name of the displayField within the record being edited differs from the  displayField in the
     * optionDataSource. <P> See {@link com.smartgwt.client.data.DataSourceField#getForeignDisplayField
     * DataSourceField.foreignDisplayField} for additional details.
     *
     * @return Current foreignDisplayField value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getDisplayFieldName
     */
    public String getForeignDisplayField()  {
        return getAttributeAsString("foreignDisplayField");
    }
    
    

    /**
     * {@link com.smartgwt.client.docs.FormatString} for numeric or date formatting.  See {@link
     * com.smartgwt.client.data.DataSourceField#getFormat DataSourceField.format}.
     *
     * @param format New format value. Default value is null
     * @see com.smartgwt.client.docs.FormatString FormatString 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setFormat(String format) {
        setAttribute("format", format);
    }

    /**
     * {@link com.smartgwt.client.docs.FormatString} for numeric or date formatting.  See {@link
     * com.smartgwt.client.data.DataSourceField#getFormat DataSourceField.format}.
     *
     * @return Current format value. Default value is null
     * @see com.smartgwt.client.docs.FormatString FormatString 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getFormat()  {
        return getAttributeAsString("format");
    }
    

    /**
     * Formula to be used to calculate the numeric value of this FormItem.  For a field of type "text" (or subtypes) {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTextFormula textFormula} is used instead. <p>  Available fields for
     * use in the formula are the current {@link com.smartgwt.client.widgets.Canvas#getRuleScope rule context}. The formula is
     * re-evaluated every time the rule context changes. <p> Values calculated by the formula will always replace the current
     * value of a non-editable field.  For an editable field, the current value will be replaced if the end user has not
     * changed the value since the last time it was computed by the formula, or if the value of the field is invalid according
     * to declared {@link com.smartgwt.client.widgets.form.fields.FormItem#getValidators validators}. <p> Note: A FormItem
     * using a formula must have a {@link com.smartgwt.client.widgets.form.fields.FormItem#getName name} defined. {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShouldSaveValue shouldSaveValue} can be set to <code>false</code> to
     * prevent the formula field from storing the calculated value into the form's values.
     *
     * @param formula New formula value. Default value is null
     * @see com.smartgwt.client.docs.FormulaFields FormulaFields overview and related methods
     */
    public void setFormula(UserFormula formula) {
        setAttribute("formula", formula == null ? null : formula.getJsObj());
    }

    /**
     * Formula to be used to calculate the numeric value of this FormItem.  For a field of type "text" (or subtypes) {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTextFormula textFormula} is used instead. <p>  Available fields for
     * use in the formula are the current {@link com.smartgwt.client.widgets.Canvas#getRuleScope rule context}. The formula is
     * re-evaluated every time the rule context changes. <p> Values calculated by the formula will always replace the current
     * value of a non-editable field.  For an editable field, the current value will be replaced if the end user has not
     * changed the value since the last time it was computed by the formula, or if the value of the field is invalid according
     * to declared {@link com.smartgwt.client.widgets.form.fields.FormItem#getValidators validators}. <p> Note: A FormItem
     * using a formula must have a {@link com.smartgwt.client.widgets.form.fields.FormItem#getName name} defined. {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShouldSaveValue shouldSaveValue} can be set to <code>false</code> to
     * prevent the formula field from storing the calculated value into the form's values.
     *
     * @return Current formula value. Default value is null
     * @see com.smartgwt.client.docs.FormulaFields FormulaFields overview and related methods
     */
    public UserFormula getFormula()  {
        return new UserFormula(getAttributeAsJavaScriptObject("formula"));
    }
    

    /**
     * TabIndex for the form item within the page. Takes precedence over any local tab index specified as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTabIndex item.tabIndex}. <P> Use of this API is <b>extremely</b>
     * advanced and essentially implies taking over management of tab index assignment for all components on the page.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param globalTabIndex New globalTabIndex value. Default value is null
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public void setGlobalTabIndex(Integer globalTabIndex) {
        setAttribute("globalTabIndex", globalTabIndex);
    }

    /**
     * TabIndex for the form item within the page. Takes precedence over any local tab index specified as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTabIndex item.tabIndex}. <P> Use of this API is <b>extremely</b>
     * advanced and essentially implies taking over management of tab index assignment for all components on the page.
     *
     * @return Current globalTabIndex value. Default value is null
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public Integer getGlobalTabIndex()  {
        return getAttributeAsInt("globalTabIndex");
    }
    

    /**
     * Height of the FormItem.  Can be either a number indicating a fixed height in pixels, a percentage indicating a
     * percentage of the overall form's height, or "*" indicating take whatever remaining space is available. See the {@link
     * com.smartgwt.client.docs.FormLayout} overview for details. <p> If height is specified as a String, getHeight() will
     * return -1.  Use   getHeightAsString.() in this case.<p> For form items having a {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon picker icon} (e.g. {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem}, {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem}) and
     * {@link com.smartgwt.client.widgets.form.fields.SpinnerItem}s, if there is no explicit  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getPickerIconHeight pickerIconHeight}, the pickerIcon will be sized to
     * match the available space based on the specified item height.<br> Note that if spriting is being used, and the image to
     * be displayed in these icons is specified  using css properties such as <code>background-image</code>,
     * <code>background-size</code>, changing this value may result in an unexpected appearance as the image will not
     * scale.<br> Scaleable spriting can be achieved using the {@link com.smartgwt.client.docs.SCSpriteConfig} format. See the
     * section on spriting in the {@link com.smartgwt.client.docs.Skinning skinning overview} for  further information.<br>
     * Alternatively, the {@link com.smartgwt.client.widgets.form.fields.FormItem#getPickerIconStyle pickerIconStyle} could be
     * changed to a custom CSS style name, and in the case of {@link com.smartgwt.client.widgets.form.fields.SpinnerItem}s, 
     * the {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getBaseStyle baseStyle} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getSrc src} of the {@link
     * com.smartgwt.client.widgets.form.fields.SpinnerItem#getIncreaseIcon SpinnerItem.increaseIcon} and {@link
     * com.smartgwt.client.widgets.form.fields.SpinnerItem#getDecreaseIcon SpinnerItem.decreaseIcon} AutoChildren could be
     * customized. <p> Note that when FormItem is rendered as read-only with <code>readOnlyDisplay</code> as "static" the
     * property {@link com.smartgwt.client.widgets.form.fields.FormItem#getStaticHeight staticHeight} is used instead.
     *
     * @param height New height value. Default value is 20
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setWidth
     * @see com.smartgwt.client.widgets.form.DynamicForm#setItemLayout
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_form_filling" target="examples">Filling Example</a>
     */
    public void setHeight(int height) {
        setAttribute("height", height);
    }

    /**
     * Height of the FormItem.  Can be either a number indicating a fixed height in pixels, a percentage indicating a
     * percentage of the overall form's height, or "*" indicating take whatever remaining space is available. See the {@link
     * com.smartgwt.client.docs.FormLayout} overview for details. <p> If height is specified as a String, getHeight() will
     * return -1.  Use   getHeightAsString.() in this case.<p> For form items having a {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon picker icon} (e.g. {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem}, {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem}) and
     * {@link com.smartgwt.client.widgets.form.fields.SpinnerItem}s, if there is no explicit  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getPickerIconHeight pickerIconHeight}, the pickerIcon will be sized to
     * match the available space based on the specified item height.<br> Note that if spriting is being used, and the image to
     * be displayed in these icons is specified  using css properties such as <code>background-image</code>,
     * <code>background-size</code>, changing this value may result in an unexpected appearance as the image will not
     * scale.<br> Scaleable spriting can be achieved using the {@link com.smartgwt.client.docs.SCSpriteConfig} format. See the
     * section on spriting in the {@link com.smartgwt.client.docs.Skinning skinning overview} for  further information.<br>
     * Alternatively, the {@link com.smartgwt.client.widgets.form.fields.FormItem#getPickerIconStyle pickerIconStyle} could be
     * changed to a custom CSS style name, and in the case of {@link com.smartgwt.client.widgets.form.fields.SpinnerItem}s, 
     * the {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getBaseStyle baseStyle} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getSrc src} of the {@link
     * com.smartgwt.client.widgets.form.fields.SpinnerItem#getIncreaseIcon SpinnerItem.increaseIcon} and {@link
     * com.smartgwt.client.widgets.form.fields.SpinnerItem#getDecreaseIcon SpinnerItem.decreaseIcon} AutoChildren could be
     * customized. <p> Note that when FormItem is rendered as read-only with <code>readOnlyDisplay</code> as "static" the
     * property {@link com.smartgwt.client.widgets.form.fields.FormItem#getStaticHeight staticHeight} is used instead.
     *
     * <p><b>Note :</b> This method will return -1 if the underlying SmartClient JavaScript
     * attribute value cannot be expressed as a(n) int.  In that case, other
     * getters,  similarly-named but ending in <code>AsString</code>, <code>AsCanvas</code>,
     * etc., may be provided.
     *
     * @return Current height value. Default value is 20
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getWidth
     * @see com.smartgwt.client.widgets.form.DynamicForm#getItemLayout
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_form_filling" target="examples">Filling Example</a>
     */
    public int getHeight()  {
        if (!(getAttributeAsObject("height") instanceof Integer)) { return -1; }
        return getAttributeAsInt("height");
    }

    /**
     * Height of the FormItem.  Can be either a number indicating a fixed height in pixels, a percentage indicating a
     * percentage of the overall form's height, or "*" indicating take whatever remaining space is available. See the {@link
     * com.smartgwt.client.docs.FormLayout} overview for details. <p> If height is specified as a String, getHeight() will
     * return -1.  Use   getHeightAsString.() in this case.<p> For form items having a {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon picker icon} (e.g. {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem}, {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem}) and
     * {@link com.smartgwt.client.widgets.form.fields.SpinnerItem}s, if there is no explicit  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getPickerIconHeight pickerIconHeight}, the pickerIcon will be sized to
     * match the available space based on the specified item height.<br> Note that if spriting is being used, and the image to
     * be displayed in these icons is specified  using css properties such as <code>background-image</code>,
     * <code>background-size</code>, changing this value may result in an unexpected appearance as the image will not
     * scale.<br> Scaleable spriting can be achieved using the {@link com.smartgwt.client.docs.SCSpriteConfig} format. See the
     * section on spriting in the {@link com.smartgwt.client.docs.Skinning skinning overview} for  further information.<br>
     * Alternatively, the {@link com.smartgwt.client.widgets.form.fields.FormItem#getPickerIconStyle pickerIconStyle} could be
     * changed to a custom CSS style name, and in the case of {@link com.smartgwt.client.widgets.form.fields.SpinnerItem}s, 
     * the {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getBaseStyle baseStyle} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getSrc src} of the {@link
     * com.smartgwt.client.widgets.form.fields.SpinnerItem#getIncreaseIcon SpinnerItem.increaseIcon} and {@link
     * com.smartgwt.client.widgets.form.fields.SpinnerItem#getDecreaseIcon SpinnerItem.decreaseIcon} AutoChildren could be
     * customized. <p> Note that when FormItem is rendered as read-only with <code>readOnlyDisplay</code> as "static" the
     * property {@link com.smartgwt.client.widgets.form.fields.FormItem#getStaticHeight staticHeight} is used instead.
     *
     * @param height New height value. Default value is 20
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setWidth
     * @see com.smartgwt.client.widgets.form.DynamicForm#setItemLayout
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_form_filling" target="examples">Filling Example</a>
     */
    public void setHeight(String height) {
        setAttribute("height", height);
    }

    /**
     * Height of the FormItem.  Can be either a number indicating a fixed height in pixels, a percentage indicating a
     * percentage of the overall form's height, or "*" indicating take whatever remaining space is available. See the {@link
     * com.smartgwt.client.docs.FormLayout} overview for details. <p> If height is specified as a String, getHeight() will
     * return -1.  Use   getHeightAsString.() in this case.<p> For form items having a {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon picker icon} (e.g. {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem}, {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem}) and
     * {@link com.smartgwt.client.widgets.form.fields.SpinnerItem}s, if there is no explicit  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getPickerIconHeight pickerIconHeight}, the pickerIcon will be sized to
     * match the available space based on the specified item height.<br> Note that if spriting is being used, and the image to
     * be displayed in these icons is specified  using css properties such as <code>background-image</code>,
     * <code>background-size</code>, changing this value may result in an unexpected appearance as the image will not
     * scale.<br> Scaleable spriting can be achieved using the {@link com.smartgwt.client.docs.SCSpriteConfig} format. See the
     * section on spriting in the {@link com.smartgwt.client.docs.Skinning skinning overview} for  further information.<br>
     * Alternatively, the {@link com.smartgwt.client.widgets.form.fields.FormItem#getPickerIconStyle pickerIconStyle} could be
     * changed to a custom CSS style name, and in the case of {@link com.smartgwt.client.widgets.form.fields.SpinnerItem}s, 
     * the {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getBaseStyle baseStyle} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getSrc src} of the {@link
     * com.smartgwt.client.widgets.form.fields.SpinnerItem#getIncreaseIcon SpinnerItem.increaseIcon} and {@link
     * com.smartgwt.client.widgets.form.fields.SpinnerItem#getDecreaseIcon SpinnerItem.decreaseIcon} AutoChildren could be
     * customized. <p> Note that when FormItem is rendered as read-only with <code>readOnlyDisplay</code> as "static" the
     * property {@link com.smartgwt.client.widgets.form.fields.FormItem#getStaticHeight staticHeight} is used instead.
     *
     * @return Current height value. Default value is 20
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getWidth
     * @see com.smartgwt.client.widgets.form.DynamicForm#getItemLayout
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_form_filling" target="examples">Filling Example</a>
     */
    public String getHeightAsString()  {
        return getAttributeAsString("height");
    }
    

    /**
     * Should this form item be hidden? Setting this property to <code>true</code> on  an item configuration will have the same
     * effect as having a {@link com.smartgwt.client.widgets.form.fields.FormItem#showIf showIf()} implementation which returns
     * <code>false</code>. <P> Note this differs slightly from {@link com.smartgwt.client.data.DataSourceField#getHidden
     * DataSourceField.hidden}. That property  will cause the field in question to be omitted entirely from databound
     * components by default. A dataSourceField with <code>hidden</code> set to <code>true</code> can still be displayed in a
     * DynamicForm either by being explicitly included in the specified {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getItems items array}, or  by having {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getShowHiddenFields DataBoundComponent.showHiddenFields} set to true. In
     * this case, this property will not be inherited onto the FormItem instance, meaning the item will be visible in the form
     * even though the <code>hidden</code> property was set to true on the dataSourceField configuration object.
     *
     * @param hidden New hidden value. Default value is null
     */
    public void setHidden(Boolean hidden) {
        setAttribute("hidden", hidden);
    }

    /**
     * Should this form item be hidden? Setting this property to <code>true</code> on  an item configuration will have the same
     * effect as having a {@link com.smartgwt.client.widgets.form.fields.FormItem#showIf showIf()} implementation which returns
     * <code>false</code>. <P> Note this differs slightly from {@link com.smartgwt.client.data.DataSourceField#getHidden
     * DataSourceField.hidden}. That property  will cause the field in question to be omitted entirely from databound
     * components by default. A dataSourceField with <code>hidden</code> set to <code>true</code> can still be displayed in a
     * DynamicForm either by being explicitly included in the specified {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getItems items array}, or  by having {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getShowHiddenFields DataBoundComponent.showHiddenFields} set to true. In
     * this case, this property will not be inherited onto the FormItem instance, meaning the item will be visible in the form
     * even though the <code>hidden</code> property was set to true on the dataSourceField configuration object.
     *
     * @return Current hidden value. Default value is null
     */
    public Boolean getHidden()  {
        return getAttributeAsBoolean("hidden", true);
    }
    

    /**
     * Specifies "hint" string to show next to the form item to indicate something to the user. This string generally appears
     * to the right of the form item.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.form.fields.FormItem#getHint hint} for this item.
     *
     * @param hint new hint for the item. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setHintStyle
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_details_hints" target="examples">Hints Example</a>
     */
    public void setHint(String hint) {
        setAttribute("hint", hint);
    }

    /**
     * Specifies "hint" string to show next to the form item to indicate something to the user. This string generally appears
     * to the right of the form item.
     *
     * @return Current hint value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getHintStyle
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_details_hints" target="examples">Hints Example</a>
     */
    public String getHint()  {
        return getAttributeAsString("hint");
    }
    
    

    /**
     * CSS class for the "hint" string. For items that support {@link
     * com.smartgwt.client.widgets.form.fields.TextItem#getShowHintInField TextItem.showHintInField}, this only applies when
     * showHintInField is false.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the hintStyle for this item
     *
     * @param hintStyle new style for hint text. Default value is "formHint"
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setHint
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.FormItemStyling FormItemStyling overview and related methods
     */
    public void setHintStyle(String hintStyle) {
        setAttribute("hintStyle", hintStyle);
    }

    /**
     * CSS class for the "hint" string. For items that support {@link
     * com.smartgwt.client.widgets.form.fields.TextItem#getShowHintInField TextItem.showHintInField}, this only applies when
     * showHintInField is false.
     *
     * @return Current hintStyle value. Default value is "formHint"
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getHint
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.FormItemStyling FormItemStyling overview and related methods
     */
    public String getHintStyle()  {
        return getAttributeAsString("hintStyle");
    }
    

    /**
     * Text alignment  for text displayed in this item's hover canvas, if shown.
     *
     * @param hoverAlign New hoverAlign value. Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#setItemHoverAlign
     */
    public void setHoverAlign(Alignment hoverAlign) {
        setAttribute("hoverAlign", hoverAlign == null ? null : hoverAlign.getValue());
    }

    /**
     * Text alignment  for text displayed in this item's hover canvas, if shown.
     *
     * @return Current hoverAlign value. Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#getItemHoverAlign
     */
    public Alignment getHoverAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("hoverAlign"));
    }
    

    /**
     * If specified, this is the number of milliseconds to wait between the user rolling over  this form item, and triggering
     * any hover action for it.<br> If not specified <code>this.form.itemHoverDelay</code> will be used instead.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param hoverDelay New hoverDelay value. Default value is null
     */
    public void setHoverDelay(Integer hoverDelay) {
        setAttribute("hoverDelay", hoverDelay);
    }

    /**
     * If specified, this is the number of milliseconds to wait between the user rolling over  this form item, and triggering
     * any hover action for it.<br> If not specified <code>this.form.itemHoverDelay</code> will be used instead.
     *
     * @return Current hoverDelay value. Default value is null
     */
    public Integer getHoverDelay()  {
        return getAttributeAsInt("hoverDelay");
    }
    

    /**
     * Option to specify a height for any hover shown for this item.
     *
     * @param hoverHeight New hoverHeight value. Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#setItemHoverHeight
     */
    public void setHoverHeight(Integer hoverHeight) {
        setAttribute("hoverHeight", hoverHeight);
    }

    /**
     * Option to specify a height for any hover shown for this item.
     *
     * @return Current hoverHeight value. Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#getItemHoverHeight
     */
    public Integer getHoverHeight()  {
        return getAttributeAsInt("hoverHeight");
    }
    

    /**
     * Opacity for any hover shown for this item
     *
     * @param hoverOpacity New hoverOpacity value. Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#setItemHoverOpacity
     */
    public void setHoverOpacity(Integer hoverOpacity) {
        setAttribute("hoverOpacity", hoverOpacity);
    }

    /**
     * Opacity for any hover shown for this item
     *
     * @return Current hoverOpacity value. Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#getItemHoverOpacity
     */
    public Integer getHoverOpacity()  {
        return getAttributeAsInt("hoverOpacity");
    }
    

    /**
     * Explicit CSS Style for any hover shown for this item.
     *
     * @param hoverStyle New hoverStyle value. Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#setItemHoverStyle
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setHoverStyle(String hoverStyle) {
        setAttribute("hoverStyle", hoverStyle);
    }

    /**
     * Explicit CSS Style for any hover shown for this item.
     *
     * @return Current hoverStyle value. Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#getItemHoverStyle
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getHoverStyle()  {
        return getAttributeAsString("hoverStyle");
    }
    

    /**
     * Vertical text alignment  for text displayed in this item's hover canvas, if shown.
     *
     * @param hoverVAlign New hoverVAlign value. Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#setItemHoverVAlign
     */
    public void setHoverVAlign(VerticalAlignment hoverVAlign) {
        setAttribute("hoverVAlign", hoverVAlign == null ? null : hoverVAlign.getValue());
    }

    /**
     * Vertical text alignment  for text displayed in this item's hover canvas, if shown.
     *
     * @return Current hoverVAlign value. Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#getItemHoverVAlign
     */
    public VerticalAlignment getHoverVAlign()  {
        return EnumUtil.getEnum(VerticalAlignment.values(), getAttribute("hoverVAlign"));
    }
    

    /**
     * Option to specify a width for any hover shown for this item.
     *
     * @param hoverWidth New hoverWidth value. Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#setItemHoverWidth
     */
    public void setHoverWidth(Integer hoverWidth) {
        setAttribute("hoverWidth", hoverWidth);
    }

    /**
     * Option to specify a width for any hover shown for this item.
     *
     * @return Current hoverWidth value. Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#getItemHoverWidth
     */
    public Integer getHoverWidth()  {
        return getAttributeAsInt("hoverWidth");
    }
    

    /**
     * Default height for form item icons. May be overridden at the icon level by {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getHeight FormItemIcon.height}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param iconHeight New iconHeight value. Default value is 20
     */
    public void setIconHeight(int iconHeight) {
        setAttribute("iconHeight", iconHeight);
    }

    /**
     * Default height for form item icons. May be overridden at the icon level by {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getHeight FormItemIcon.height}.
     *
     * @return Takes an icon definition object, and returns the height for that icon in px. Default value is 20
     */
    public int getIconHeight()  {
        return getAttributeAsInt("iconHeight");
    }
    

    /**
     * Horizontal space (in px) to leave between form item icons. The space appears either on the left or right of each icon.
     * May be overridden at the icon level via {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getHspace
     * FormItemIcon.hspace}. Must be non-negative.
     *
     * @param iconHSpace New iconHSpace value. Default value is 3
     */
    public void setIconHSpace(int iconHSpace) {
        setAttribute("iconHSpace", iconHSpace);
    }

    /**
     * Horizontal space (in px) to leave between form item icons. The space appears either on the left or right of each icon.
     * May be overridden at the icon level via {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getHspace
     * FormItemIcon.hspace}. Must be non-negative.
     *
     * @return Current iconHSpace value. Default value is 3
     */
    public int getIconHSpace()  {
        return getAttributeAsInt("iconHSpace");
    }
    

    /**
     * Default prompt (and tooltip-text) for icons.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param iconPrompt New iconPrompt value. Default value is ""
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public void setIconPrompt(String iconPrompt) {
        setAttribute("iconPrompt", iconPrompt);
    }

    /**
     * Default prompt (and tooltip-text) for icons.
     *
     * @return Current iconPrompt value. Default value is ""
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getIconPrompt()  {
        return getAttributeAsString("iconPrompt");
    }
    

    /**
     * An array of descriptor objects for icons to display in a line after this form item.  These icons are clickable images,
     * often used to display some kind of helper for   populating a form item.
     *
     * @param icons New icons value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItemIcon
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_details_icons" target="examples">Icons Example</a>
     */
    public void setIcons(FormItemIcon... icons) {
        setAttribute("icons", icons);
    }

    /**
     * An array of descriptor objects for icons to display in a line after this form item.  These icons are clickable images,
     * often used to display some kind of helper for   populating a form item.
     *
     * @return Current icons value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItemIcon
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_details_icons" target="examples">Icons Example</a>
     */
    public FormItemIcon[] getIcons()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfFormItemIcon(getAttributeAsJavaScriptObject("icons"));
    }
    

    /**
     * How should icons be aligned vertically for this form item.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param iconVAlign New iconVAlign value. Default value is "bottom"
     */
    public void setIconVAlign(VerticalAlignment iconVAlign) {
        setAttribute("iconVAlign", iconVAlign == null ? null : iconVAlign.getValue());
    }

    /**
     * How should icons be aligned vertically for this form item.
     *
     * @return Current iconVAlign value. Default value is "bottom"
     */
    public VerticalAlignment getIconVAlign()  {
        return EnumUtil.getEnum(VerticalAlignment.values(), getAttribute("iconVAlign"));
    }
    

    /**
     * Default width for form item icons. May be overridden at the icon level by {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getWidth FormItemIcon.width}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param iconWidth New iconWidth value. Default value is 20
     */
    public void setIconWidth(int iconWidth) {
        setAttribute("iconWidth", iconWidth);
    }

    /**
     * Default width for form item icons. May be overridden at the icon level by {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getWidth FormItemIcon.width}.
     *
     * @return Takes an icon definition object, and returns the width for that icon in px. Default value is 20
     */
    public int getIconWidth()  {
        return getAttributeAsInt("iconWidth");
    }
    

    /**
     * Global identifier for referring to the formItem in JavaScript.  The ID property is optional if you do not need to refer
     * to the widget from JavaScript, or can refer to it indirectly (for example, via
     * <code>form.getItem("<i>itemName</i>")</code>). <P> An internal, unique ID will automatically be created upon
     * instantiation for any formItem where one is not provided.
     *
     * @param ID New ID value. Default value is null
     * @see com.smartgwt.client.docs.GlobalId GlobalId 
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public void setID(String ID) {
        setAttribute("ID", ID);
    }

    /**
     * Global identifier for referring to the formItem in JavaScript.  The ID property is optional if you do not need to refer
     * to the widget from JavaScript, or can refer to it indirectly (for example, via
     * <code>form.getItem("<i>itemName</i>")</code>). <P> An internal, unique ID will automatically be created upon
     * instantiation for any formItem where one is not provided.
     *
     * @return Current ID value. Default value is null
     * @see com.smartgwt.client.docs.GlobalId GlobalId 
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public String getID()  {
        return getAttributeAsString("ID");
    }
    

    /**
     * Prefix to apply to the beginning of any {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons
     * valueIcons} when determining the URL for the image. Will not be applied if the <code>valueIcon</code> URL is absolute.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param imageURLPrefix New imageURLPrefix value. Default value is null
     */
    public void setImageURLPrefix(String imageURLPrefix) {
        setAttribute("imageURLPrefix", imageURLPrefix);
    }

    /**
     * Prefix to apply to the beginning of any {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons
     * valueIcons} when determining the URL for the image. Will not be applied if the <code>valueIcon</code> URL is absolute.
     *
     * @return Current imageURLPrefix value. Default value is null
     */
    public String getImageURLPrefix()  {
        return getAttributeAsString("imageURLPrefix");
    }
    

    /**
     * Suffix to apply to the end of any {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons} when
     * determining the URL for the image. A common usage would be to specify a suffix of <code>".gif"</code> in which case the
     * <code>valueIcons</code> property would map values to the names of images without the <code>".gif"</code> extension.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param imageURLSuffix New imageURLSuffix value. Default value is null
     */
    public void setImageURLSuffix(String imageURLSuffix) {
        setAttribute("imageURLSuffix", imageURLSuffix);
    }

    /**
     * Suffix to apply to the end of any {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons} when
     * determining the URL for the image. A common usage would be to specify a suffix of <code>".gif"</code> in which case the
     * <code>valueIcons</code> property would map values to the names of images without the <code>".gif"</code> extension.
     *
     * @return Current imageURLSuffix value. Default value is null
     */
    public String getImageURLSuffix()  {
        return getAttributeAsString("imageURLSuffix");
    }
    

    /**
     * When true, indicates that changes to this item will cause an automatic save on a  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getImplicitSaveDelay delay}, as well as when the entire form is submitted. 
     * If implicitSaveOnBlur is set to true on either this  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getImplicitSaveOnBlur formItem} or it's   {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getImplicitSaveOnBlur form}, changes will also be automatically saved  
     * immediately on editorExit.
     *
     * @param implicitSave New implicitSave value. Default value is false
     */
    public void setImplicitSave(Boolean implicitSave) {
        setAttribute("implicitSave", implicitSave);
    }

    /**
     * When true, indicates that changes to this item will cause an automatic save on a  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getImplicitSaveDelay delay}, as well as when the entire form is submitted. 
     * If implicitSaveOnBlur is set to true on either this  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getImplicitSaveOnBlur formItem} or it's   {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getImplicitSaveOnBlur form}, changes will also be automatically saved  
     * immediately on editorExit.
     *
     * @return Current implicitSave value. Default value is false
     */
    public Boolean getImplicitSave()  {
        Boolean result = getAttributeAsBoolean("implicitSave", true);
        return result == null ? false : result;
    }
    

    /**
     * If set to true, this item's value will be saved immediately when its  "editorExit" handler is fired.  This attribute
     * works separately from  {@link com.smartgwt.client.widgets.form.fields.FormItem#getImplicitSave implicitSave}, which
     * causes saves during editing, after a  {@link com.smartgwt.client.widgets.form.DynamicForm#getImplicitSaveDelay short
     * delay}, and when the entire form is submitted.
     *
     * @param implicitSaveOnBlur New implicitSaveOnBlur value. Default value is false
     */
    public void setImplicitSaveOnBlur(Boolean implicitSaveOnBlur) {
        setAttribute("implicitSaveOnBlur", implicitSaveOnBlur);
    }

    /**
     * If set to true, this item's value will be saved immediately when its  "editorExit" handler is fired.  This attribute
     * works separately from  {@link com.smartgwt.client.widgets.form.fields.FormItem#getImplicitSave implicitSave}, which
     * causes saves during editing, after a  {@link com.smartgwt.client.widgets.form.DynamicForm#getImplicitSaveDelay short
     * delay}, and when the entire form is submitted.
     *
     * @return Current implicitSaveOnBlur value. Default value is false
     */
    public Boolean getImplicitSaveOnBlur()  {
        Boolean result = getAttributeAsBoolean("implicitSaveOnBlur", true);
        return result == null ? false : result;
    }
    

    /**
     * For fields of type <code>"date"</code>, if this is an editable field such as a {@link
     * com.smartgwt.client.widgets.form.fields.TextItem}, this property  allows you to specify the {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat inputFormat} applied to the item.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param inputFormat New inputFormat value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setDateFormatter
     * @see com.smartgwt.client.docs.DateInputFormat DateInputFormat 
     */
    public void setInputFormat(String inputFormat) {
        setAttribute("inputFormat", inputFormat);
    }

    /**
     * For fields of type <code>"date"</code>, if this is an editable field such as a {@link
     * com.smartgwt.client.widgets.form.fields.TextItem}, this property  allows you to specify the {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat inputFormat} applied to the item.
     *
     * @return Current inputFormat value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getDateFormatter
     * @see com.smartgwt.client.docs.DateInputFormat DateInputFormat 
     */
    public String getInputFormat()  {
        return getAttributeAsString("inputFormat");
    }
    

    /**
     * Left coordinate of this item in pixels.  Applies only when the containing DynamicForm sets
     * <code>itemLayout:"absolute"</code>.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * For a form with {@link com.smartgwt.client.widgets.form.DynamicForm#getItemLayout itemLayout}:"absolute" only, set the left coordinate of this form item. <P> Causes the form to redraw.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param left New left value. Default value is 0
     */
    public void setLeft(int left) {
        setAttribute("left", left);
    }

    /**
     * Left coordinate of this item in pixels.  Applies only when the containing DynamicForm sets
     * <code>itemLayout:"absolute"</code>.
     *
     * @return Returns the left coordinate of this form item in pixels. Note that this method is only reliable after the item has been
     * drawn. Default value is 0
     */
    public int getLeft()  {
        return getAttributeAsInt("left");
    }
    

    /**
     * Value shown in field when {@link com.smartgwt.client.widgets.form.fields.FormItem#getFetchMissingValues
     * fetchMissingValues} is active and a fetch is pending. The field is read-only while a fetch is pending. <P> Set to
     * <code>null</code> to show actual value until display value is loaded.
     *
     * @param loadingDisplayValue New loadingDisplayValue value. Default value is "Loading..."
     */
    public void setLoadingDisplayValue(String loadingDisplayValue) {
        setAttribute("loadingDisplayValue", loadingDisplayValue);
    }

    /**
     * Value shown in field when {@link com.smartgwt.client.widgets.form.fields.FormItem#getFetchMissingValues
     * fetchMissingValues} is active and a fetch is pending. The field is read-only while a fetch is pending. <P> Set to
     * <code>null</code> to show actual value until display value is loaded.
     *
     * @return Current loadingDisplayValue value. Default value is "Loading..."
     */
    public String getLoadingDisplayValue()  {
        return getAttributeAsString("loadingDisplayValue");
    }
    

    /**
     * When {@link com.smartgwt.client.util.AutoTest#getElement AutoTest.getElement()} is used to parse locator strings
     * generated by {@link com.smartgwt.client.util.AutoTest#getLocator AutoTest.getLocator()} for this form item, should the
     * item be identified? If the locator has a specified {@link com.smartgwt.client.widgets.form.fields.FormItem#getName
     * name}, it is considered to definitely locate the item and no fallback approach will be used. <P> Otherwise, the
     * following options are available: <ul> <li><code>"title"</code> use the title as an identifier within this form</li>
     * <li><code>"value"</code> use the value of the item to identify it (often used  for items with a static defaultValue such
     * as HeaderItems</li> <li><code>"index"</code> use the index within the form's items array. </ul><p> If unset, and the
     * locator has no specified name, default behavior is to identify by title (if available), then value (if available),
     * otherwise by index.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param locateItemBy New locateItemBy value. Default value is null
     * @see com.smartgwt.client.types.LocatorStrategy
     */
    public void setLocateItemBy(String locateItemBy) {
        setAttribute("locateItemBy", locateItemBy);
    }

    /**
     * When {@link com.smartgwt.client.util.AutoTest#getElement AutoTest.getElement()} is used to parse locator strings
     * generated by {@link com.smartgwt.client.util.AutoTest#getLocator AutoTest.getLocator()} for this form item, should the
     * item be identified? If the locator has a specified {@link com.smartgwt.client.widgets.form.fields.FormItem#getName
     * name}, it is considered to definitely locate the item and no fallback approach will be used. <P> Otherwise, the
     * following options are available: <ul> <li><code>"title"</code> use the title as an identifier within this form</li>
     * <li><code>"value"</code> use the value of the item to identify it (often used  for items with a static defaultValue such
     * as HeaderItems</li> <li><code>"index"</code> use the index within the form's items array. </ul><p> If unset, and the
     * locator has no specified name, default behavior is to identify by title (if available), then value (if available),
     * otherwise by index.
     *
     * @return Current locateItemBy value. Default value is null
     * @see com.smartgwt.client.types.LocatorStrategy
     */
    public String getLocateItemBy()  {
        return getAttributeAsString("locateItemBy");
    }
    

    /**
     * If this item is showing a {@link com.smartgwt.client.widgets.form.fields.FormItem#getHint hint}, this setting specifies
     * how much horizontal space is made available for rendering the hint text by default. Typically this reflects how much
     * space the hint text takes up before it wraps. <P> Note that the presence of a hint may cause a form item to expand
     * horizontally past its specified {@link com.smartgwt.client.widgets.form.fields.FormItem#getWidth width}. This property
     * value acts as a minimum - if the hint text can not wrap within this width (either due to {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getWrapHintText wrapHintText} being set to <code>false</code>, or due
     * to it containing long, un-wrappable content), it will further expand to take up the space it needs. <P> If unset this
     * property will be picked up from the {@link com.smartgwt.client.widgets.form.DynamicForm#getMinHintWidth
     * DynamicForm.minHintWidth} setting. <P> This setting does not apply to hints that are {@link
     * com.smartgwt.client.widgets.form.fields.TextItem#getShowHintInField shown in field}.
     *
     * @param minHintWidth New minHintWidth value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setWrapHintText
     */
    public void setMinHintWidth(Integer minHintWidth) {
        setAttribute("minHintWidth", minHintWidth);
    }

    /**
     * If this item is showing a {@link com.smartgwt.client.widgets.form.fields.FormItem#getHint hint}, this setting specifies
     * how much horizontal space is made available for rendering the hint text by default. Typically this reflects how much
     * space the hint text takes up before it wraps. <P> Note that the presence of a hint may cause a form item to expand
     * horizontally past its specified {@link com.smartgwt.client.widgets.form.fields.FormItem#getWidth width}. This property
     * value acts as a minimum - if the hint text can not wrap within this width (either due to {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getWrapHintText wrapHintText} being set to <code>false</code>, or due
     * to it containing long, un-wrappable content), it will further expand to take up the space it needs. <P> If unset this
     * property will be picked up from the {@link com.smartgwt.client.widgets.form.DynamicForm#getMinHintWidth
     * DynamicForm.minHintWidth} setting. <P> This setting does not apply to hints that are {@link
     * com.smartgwt.client.widgets.form.fields.TextItem#getShowHintInField shown in field}.
     *
     * @return Current minHintWidth value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getWrapHintText
     */
    public Integer getMinHintWidth()  {
        return getAttributeAsInt("minHintWidth");
    }
    

    /**
     * If true, multiple values may be selected. <P> Only certain FormItems that support both singular and multiple values
     * actually use this setting, such as {@link com.smartgwt.client.widgets.form.fields.SelectItem}. Other FormItems such as
     * {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem} are always effectively multiple:true, even if
     * multiple:true is not set.
     *
     * @param multiple New multiple value. Default value is false
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setMultiple(Boolean multiple) {
        setAttribute("multiple", multiple);
    }

    /**
     * If true, multiple values may be selected. <P> Only certain FormItems that support both singular and multiple values
     * actually use this setting, such as {@link com.smartgwt.client.widgets.form.fields.SelectItem}. Other FormItems such as
     * {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem} are always effectively multiple:true, even if
     * multiple:true is not set.
     *
     * @return Current multiple value. Default value is false
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getMultiple()  {
        Boolean result = getAttributeAsBoolean("multiple", true);
        return result == null ? false : result;
    }
    

    /**
     * If this item is displaying multiple values, this property will be the string that separates those values for display
     * purposes.
     *
     * @param multipleValueSeparator New multipleValueSeparator value. Default value is ', '
     */
    public void setMultipleValueSeparator(String multipleValueSeparator) {
        setAttribute("multipleValueSeparator", multipleValueSeparator);
    }

    /**
     * If this item is displaying multiple values, this property will be the string that separates those values for display
     * purposes.
     *
     * @return Current multipleValueSeparator value. Default value is ', '
     */
    public String getMultipleValueSeparator()  {
        return getAttributeAsString("multipleValueSeparator");
    }
    

    /**
     * Name for this form field. Must be unique within the form as well as a valid JavaScript identifier - see {@link
     * com.smartgwt.client.docs.FieldName} for details and how to check for validity. <P> The FormItem's name determines the
     * name of the property it edits within the form. <P> Note that an item must have a valid name or {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDataPath dataPath} in order for its value to be validated and/or
     * saved.
     *
     * @return Current name value. Default value is null
     * @see com.smartgwt.client.docs.FieldName FieldName 
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public String getName()  {
        return getAttributeAsString("name");
    }
    

    /**
     * Text shown as the value in the {@link com.smartgwt.client.widgets.form.fields.FormItem#getOriginalValueMessage
     * originalValueMessage} when  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowOldValueInHover
     * showOldValueInHover} is enabled, and when  the value has been modified but was originally unset.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param nullOriginalValueText New nullOriginalValueText value. Default value is "None"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public void setNullOriginalValueText(String nullOriginalValueText) {
        setAttribute("nullOriginalValueText", nullOriginalValueText);
    }

    /**
     * Text shown as the value in the {@link com.smartgwt.client.widgets.form.fields.FormItem#getOriginalValueMessage
     * originalValueMessage} when  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowOldValueInHover
     * showOldValueInHover} is enabled, and when  the value has been modified but was originally unset.
     *
     * @return Current nullOriginalValueText value. Default value is "None"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getNullOriginalValueText()  {
        return getAttributeAsString("nullOriginalValueText");
    }
    

    /**
     * {@link com.smartgwt.client.types.OperatorId} to be used when {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria DynamicForm.getValuesAsCriteria()} is called. <P>
     * <code>item.operator</code> can be used to create a form that offers search functions such as numeric range filtering,
     * without the more advanced user interface of the {@link com.smartgwt.client.widgets.form.FilterBuilder}.  For example,
     * two SpinnerItems could be created with <code>formItem.operator</code> set to "greaterThan" and "lessThan" respectively
     * to enable filtering by a numeric range. <P> When <code>item.operator</code> is set for any FormItem in a form,
     * <code>form.getValuesAsCriteria()</code> will return an {@link com.smartgwt.client.data.AdvancedCriteria} object instead
     * of a normal {@link com.smartgwt.client.data.Criteria} object.  Each FormItem will produce one {@link
     * com.smartgwt.client.data.Criterion} affecting the DataSource field specified by {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCriteriaField criteriaField}. The criteria produced by the FormItems
     * will be grouped under the logical operator provided by {@link com.smartgwt.client.widgets.form.DynamicForm#getOperator
     * DynamicForm.operator}. <P> If <code>operator</code> is set for some fields but not others, the default operator is
     * "equals" for fields with a valueMap or an optionDataSource, and for fields of type "enum" (or of a type that inherits
     * from "enum").  The default operator for all other fields is controlled by {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getDefaultSearchOperator DynamicForm.defaultSearchOperator}.  <P>
     * <b>Note:</b> <code>formItem.operator</code> is only supported for a form that has a  {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getDataSource dataSource}.  In a form with no DataSource,  setting
     * <code>formItem.operator</code> will have no effect.
     *
     * @param operator New operator value. Default value is null
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public void setOperator(OperatorId operator) {
        setAttribute("operator", operator == null ? null : operator.getValue());
    }

    /**
     * {@link com.smartgwt.client.types.OperatorId} to be used when {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria DynamicForm.getValuesAsCriteria()} is called. <P>
     * <code>item.operator</code> can be used to create a form that offers search functions such as numeric range filtering,
     * without the more advanced user interface of the {@link com.smartgwt.client.widgets.form.FilterBuilder}.  For example,
     * two SpinnerItems could be created with <code>formItem.operator</code> set to "greaterThan" and "lessThan" respectively
     * to enable filtering by a numeric range. <P> When <code>item.operator</code> is set for any FormItem in a form,
     * <code>form.getValuesAsCriteria()</code> will return an {@link com.smartgwt.client.data.AdvancedCriteria} object instead
     * of a normal {@link com.smartgwt.client.data.Criteria} object.  Each FormItem will produce one {@link
     * com.smartgwt.client.data.Criterion} affecting the DataSource field specified by {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCriteriaField criteriaField}. The criteria produced by the FormItems
     * will be grouped under the logical operator provided by {@link com.smartgwt.client.widgets.form.DynamicForm#getOperator
     * DynamicForm.operator}. <P> If <code>operator</code> is set for some fields but not others, the default operator is
     * "equals" for fields with a valueMap or an optionDataSource, and for fields of type "enum" (or of a type that inherits
     * from "enum").  The default operator for all other fields is controlled by {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getDefaultSearchOperator DynamicForm.defaultSearchOperator}.  <P>
     * <b>Note:</b> <code>formItem.operator</code> is only supported for a form that has a  {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getDataSource dataSource}.  In a form with no DataSource,  setting
     * <code>formItem.operator</code> will have no effect.
     *
     * @return Current operator value. Default value is null
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public OperatorId getOperator()  {
        return EnumUtil.getEnum(OperatorId.values(), getAttribute("operator"));
    }
    
    

    /**
     * If set, this FormItem will map stored values to display values as though a {@link com.smartgwt.client.types.ValueMap}
     * were specified, by fetching records from the  specified <code>optionDataSource</code> and extracting the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueField valueField} and  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} in loaded records, to derive one valueMap
     * entry per record loaded from the optionDataSource. <P> With the default setting of {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getFetchMissingValues fetchMissingValues}, fetches will be initiated
     * against the optionDataSource any time the FormItem has a non-null value and no corresponding display value is available.
     * This includes when the form is first initialized, as well as any subsequent calls to {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setValue setValue()}, such as may happen when {@link
     * com.smartgwt.client.widgets.form.DynamicForm#editRecord DynamicForm.editRecord()} is called.  Retrieved values are
     * automatically cached by the FormItem. <P> Note that if a normal, static {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueMap valueMap} is <b>also</b> specified for the field (either
     * directly in the form item or as part of the field definition in the dataSource), it will be preferred to the data
     * derived from the optionDataSource for whatever mappings are present. <P> In a databound form, if {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} is specified for a FormItem and 
     * <code>optionDataSource</code> is unset, <code>optionDataSource</code> will default to the form's current DataSource
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Method to set the {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource} at runtime
     *
     * @param optionDataSource new optionDatasource. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#invalidateDisplayValueCache
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_controls_various" target="examples">List - Combo Box Example</a>
     */
    public void setOptionDataSource(DataSource optionDataSource) {
        setAttribute("optionDataSource", optionDataSource == null ? null : optionDataSource.getOrCreateJsObj());
    }

    /**
     * If set, this FormItem will map stored values to display values as though a {@link com.smartgwt.client.types.ValueMap}
     * were specified, by fetching records from the  specified <code>optionDataSource</code> and extracting the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueField valueField} and  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} in loaded records, to derive one valueMap
     * entry per record loaded from the optionDataSource. <P> With the default setting of {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getFetchMissingValues fetchMissingValues}, fetches will be initiated
     * against the optionDataSource any time the FormItem has a non-null value and no corresponding display value is available.
     * This includes when the form is first initialized, as well as any subsequent calls to {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setValue setValue()}, such as may happen when {@link
     * com.smartgwt.client.widgets.form.DynamicForm#editRecord DynamicForm.editRecord()} is called.  Retrieved values are
     * automatically cached by the FormItem. <P> Note that if a normal, static {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueMap valueMap} is <b>also</b> specified for the field (either
     * directly in the form item or as part of the field definition in the dataSource), it will be preferred to the data
     * derived from the optionDataSource for whatever mappings are present. <P> In a databound form, if {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} is specified for a FormItem and 
     * <code>optionDataSource</code> is unset, <code>optionDataSource</code> will default to the form's current DataSource
     *
     * @return Returns the {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource} for this item.
     * <p> Always uses <code>item.optionDataSource</code> if specified.  Otherwise, if {@link
     * com.smartgwt.client.data.DataSourceField#getForeignKey DataSourceField.foreignKey} was specified, uses the target
     * DataSource.  Otherwise, uses the DataSource of this item's form (if one is configured). Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#invalidateDisplayValueCache
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_controls_various" target="examples">List - Combo Box Example</a>
     */
    public DataSource getOptionDataSource()  {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("optionDataSource"));
    }

    /**
     * If set, this FormItem will map stored values to display values as though a {@link com.smartgwt.client.types.ValueMap}
     * were specified, by fetching records from the  specified <code>optionDataSource</code> and extracting the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueField valueField} and  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} in loaded records, to derive one valueMap
     * entry per record loaded from the optionDataSource. <P> With the default setting of {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getFetchMissingValues fetchMissingValues}, fetches will be initiated
     * against the optionDataSource any time the FormItem has a non-null value and no corresponding display value is available.
     * This includes when the form is first initialized, as well as any subsequent calls to {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setValue setValue()}, such as may happen when {@link
     * com.smartgwt.client.widgets.form.DynamicForm#editRecord DynamicForm.editRecord()} is called.  Retrieved values are
     * automatically cached by the FormItem. <P> Note that if a normal, static {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueMap valueMap} is <b>also</b> specified for the field (either
     * directly in the form item or as part of the field definition in the dataSource), it will be preferred to the data
     * derived from the optionDataSource for whatever mappings are present. <P> In a databound form, if {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} is specified for a FormItem and 
     * <code>optionDataSource</code> is unset, <code>optionDataSource</code> will default to the form's current DataSource
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Method to set the {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource} at runtime
     *
     * @param optionDataSource new optionDatasource. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#invalidateDisplayValueCache
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_controls_various" target="examples">List - Combo Box Example</a>
     */
    public void setOptionDataSource(String optionDataSource) {
        setAttribute("optionDataSource", optionDataSource);
    }

    /**
     * If set, this FormItem will map stored values to display values as though a {@link com.smartgwt.client.types.ValueMap}
     * were specified, by fetching records from the  specified <code>optionDataSource</code> and extracting the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueField valueField} and  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} in loaded records, to derive one valueMap
     * entry per record loaded from the optionDataSource. <P> With the default setting of {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getFetchMissingValues fetchMissingValues}, fetches will be initiated
     * against the optionDataSource any time the FormItem has a non-null value and no corresponding display value is available.
     * This includes when the form is first initialized, as well as any subsequent calls to {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setValue setValue()}, such as may happen when {@link
     * com.smartgwt.client.widgets.form.DynamicForm#editRecord DynamicForm.editRecord()} is called.  Retrieved values are
     * automatically cached by the FormItem. <P> Note that if a normal, static {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueMap valueMap} is <b>also</b> specified for the field (either
     * directly in the form item or as part of the field definition in the dataSource), it will be preferred to the data
     * derived from the optionDataSource for whatever mappings are present. <P> In a databound form, if {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} is specified for a FormItem and 
     * <code>optionDataSource</code> is unset, <code>optionDataSource</code> will default to the form's current DataSource
     *
     * @return Returns the {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource} for this item.
     * <p> Always uses <code>item.optionDataSource</code> if specified.  Otherwise, if {@link
     * com.smartgwt.client.data.DataSourceField#getForeignKey DataSourceField.foreignKey} was specified, uses the target
     * DataSource.  Otherwise, uses the DataSource of this item's form (if one is configured). Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#invalidateDisplayValueCache
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_controls_various" target="examples">List - Combo Box Example</a>
     */
    public String getOptionDataSourceAsString()  {
        return getAttributeAsString("optionDataSource");
    }
    
    

    /**
     * If this item has a specified <code>optionDataSource</code>, this attribute may be set to specify an explicit {@link
     * com.smartgwt.client.data.DSRequest#getOperationId DSRequest.operationId} when performing a fetch against the option
     * dataSource to pick up display value mapping.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param optionOperationId New optionOperationId value. Default value is null
     */
    public void setOptionOperationId(String optionOperationId) {
        setAttribute("optionOperationId", optionOperationId);
    }

    /**
     * If this item has a specified <code>optionDataSource</code>, this attribute may be set to specify an explicit {@link
     * com.smartgwt.client.data.DSRequest#getOperationId DSRequest.operationId} when performing a fetch against the option
     * dataSource to pick up display value mapping.
     *
     * @return Current optionOperationId value. Default value is null
     */
    public String getOptionOperationId()  {
        return getAttributeAsString("optionOperationId");
    }
    

    /**
     * If this item has a specified <code>optionDataSource</code>, this property determines the textMatchStyle to use when
     * interpretating any {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionCriteria optionCriteria} during the
     * fetch to map valueField values to displayField values.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param optionTextMatchStyle New optionTextMatchStyle value. Default value is "exact"
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public void setOptionTextMatchStyle(TextMatchStyle optionTextMatchStyle) {
        setAttribute("optionTextMatchStyle", optionTextMatchStyle == null ? null : optionTextMatchStyle.getValue());
    }

    /**
     * If this item has a specified <code>optionDataSource</code>, this property determines the textMatchStyle to use when
     * interpretating any {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionCriteria optionCriteria} during the
     * fetch to map valueField values to displayField values.
     *
     * @return Current optionTextMatchStyle value. Default value is "exact"
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public TextMatchStyle getOptionTextMatchStyle()  {
        return EnumUtil.getEnum(TextMatchStyle.values(), getAttribute("optionTextMatchStyle"));
    }
    

    /**
     * Message shown when {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowOldValueInHover showOldValueInHover}
     * is enabled and the value has been modified. <p> If unset, defaults to the form's {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getOriginalValueMessage DynamicForm.originalValueMessage}. Otherwise,
     * overrides the form-default <code>originalValueMessage</code> for this item.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param originalValueMessage New originalValueMessage value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public void setOriginalValueMessage(String originalValueMessage) {
        setAttribute("originalValueMessage", originalValueMessage);
    }

    /**
     * Message shown when {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowOldValueInHover showOldValueInHover}
     * is enabled and the value has been modified. <p> If unset, defaults to the form's {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getOriginalValueMessage DynamicForm.originalValueMessage}. Otherwise,
     * overrides the form-default <code>originalValueMessage</code> for this item.
     *
     * @return Current originalValueMessage value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getOriginalValueMessage()  {
        return getAttributeAsString("originalValueMessage");
    }
    

    /**
     * The component that will be displayed when {@link com.smartgwt.client.widgets.form.fields.FormItem#showPicker
     * showPicker()} is called due to a click on the {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon
     * picker icon}. <P> Can be specified directly as a Canvas, or created automatically via the {@link
     * com.smartgwt.client.types.AutoChild} pattern. The default autoChild configuration for the picker is  a Canvas with
     * backgroundColor set and no other modifications. <P> Note that the picker is not automatically destroyed with the
     * FormItem that uses it, in order to allow recycling of picker components.  To destroy a single-use picker, override
     * {@link com.smartgwt.client.widgets.Canvas#destroy Canvas.destroy()}.
     * <p>
     * This component is an AutoChild named "picker".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current picker value. Default value is null
     */
    public Canvas getPicker()  {
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("picker"));
    }
    
    
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon showPickerIcon} is true for this item, this
     * property governs the size of the picker icon. If unset, the picker icon will be sized as a square to fit in the
     * available height for the icon. <p> Note that if spriting is being used, and the image to be displayed is specified 
     * using css properties such as <code>background-image</code>, <code>background-size</code>, changing this value may result
     * in an unexpected appearance as the image will not scale.<br> Scaleable spriting can be achieved using the {@link
     * com.smartgwt.client.docs.SCSpriteConfig} format. See the section on spriting in the {@link
     * com.smartgwt.client.docs.Skinning skinning overview} for  further information.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param pickerIconHeight New pickerIconHeight value. Default value is null
     */
    public void setPickerIconHeight(Integer pickerIconHeight) {
        setAttribute("pickerIconHeight", pickerIconHeight);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon showPickerIcon} is true for this item, this
     * property governs the size of the picker icon. If unset, the picker icon will be sized as a square to fit in the
     * available height for the icon. <p> Note that if spriting is being used, and the image to be displayed is specified 
     * using css properties such as <code>background-image</code>, <code>background-size</code>, changing this value may result
     * in an unexpected appearance as the image will not scale.<br> Scaleable spriting can be achieved using the {@link
     * com.smartgwt.client.docs.SCSpriteConfig} format. See the section on spriting in the {@link
     * com.smartgwt.client.docs.Skinning skinning overview} for  further information.
     *
     * @return Current pickerIconHeight value. Default value is null
     */
    public Integer getPickerIconHeight()  {
        return getAttributeAsInt("pickerIconHeight");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon showPickerIcon} is true, this attribute
     * specifies the {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getName FormItemIcon.name} applied to the
     * picker icon
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param pickerIconName New pickerIconName value. Default value is "picker"
     * @see com.smartgwt.client.docs.Identifier Identifier 
     */
    public void setPickerIconName(String pickerIconName) {
        setAttribute("pickerIconName", pickerIconName);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon showPickerIcon} is true, this attribute
     * specifies the {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getName FormItemIcon.name} applied to the
     * picker icon
     *
     * @return Current pickerIconName value. Default value is "picker"
     * @see com.smartgwt.client.docs.Identifier Identifier 
     */
    public String getPickerIconName()  {
        return getAttributeAsString("pickerIconName");
    }
    

    /**
     * Prompt to show when the user hovers the mouse over the picker icon.
     *
     * @param pickerIconPrompt New pickerIconPrompt value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public void setPickerIconPrompt(String pickerIconPrompt) {
        setAttribute("pickerIconPrompt", pickerIconPrompt);
    }

    /**
     * Prompt to show when the user hovers the mouse over the picker icon.
     *
     * @return Current pickerIconPrompt value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getPickerIconPrompt()  {
        return getAttributeAsString("pickerIconPrompt");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon showPickerIcon} is true for this item, this
     * block of properties will be applied to the pickerIcon. Allows for advanced customization of this icon.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param pickerIconProperties New pickerIconProperties value. Default value is null
     */
    public void setPickerIconProperties(FormItemIcon pickerIconProperties) {
        JavaScriptObject config = JSOHelper.createObject();
        if (pickerIconProperties != null) {
            JSOHelper.addProperties(config, pickerIconProperties.getJsObj());
        }
        setAttribute("pickerIconProperties", pickerIconProperties == null ? null : config);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon showPickerIcon} is true for this item, this
     * block of properties will be applied to the pickerIcon. Allows for advanced customization of this icon.
     *
     * @return Current pickerIconProperties value. Default value is null
     */
    public FormItemIcon getPickerIconProperties()  {
        return new FormItemIcon(getAttributeAsJavaScriptObject("pickerIconProperties"));
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon showPickerIcon} is true for this item, this
     * property governs the {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getSrc src} of the picker icon image to
     * be displayed. <P> {@link com.smartgwt.client.docs.Skinning Spriting} can be used for this image, by setting this
     * property to a {@link com.smartgwt.client.docs.SCSpriteConfig} formatted string.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param pickerIconSrc New pickerIconSrc value. Default value is ""
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public void setPickerIconSrc(String pickerIconSrc) {
        setAttribute("pickerIconSrc", pickerIconSrc);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon showPickerIcon} is true for this item, this
     * property governs the {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getSrc src} of the picker icon image to
     * be displayed. <P> {@link com.smartgwt.client.docs.Skinning Spriting} can be used for this image, by setting this
     * property to a {@link com.smartgwt.client.docs.SCSpriteConfig} formatted string.
     *
     * @return Current pickerIconSrc value. Default value is ""
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getPickerIconSrc()  {
        return getAttributeAsString("pickerIconSrc");
    }
    

    /**
     * Base CSS class name for a form item's picker icon cell. If unset, inherits from this item's {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getControlStyle controlStyle}.
     *
     * @param pickerIconStyle New pickerIconStyle value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setCellStyle
     * @see com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle 
     * @see com.smartgwt.client.docs.FormItemStyling FormItemStyling overview and related methods
     */
    public void setPickerIconStyle(String pickerIconStyle) {
        setAttribute("pickerIconStyle", pickerIconStyle);
    }

    /**
     * Base CSS class name for a form item's picker icon cell. If unset, inherits from this item's {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getControlStyle controlStyle}.
     *
     * @return Current pickerIconStyle value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getCellStyle
     * @see com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle 
     * @see com.smartgwt.client.docs.FormItemStyling FormItemStyling overview and related methods
     */
    public String getPickerIconStyle()  {
        return getAttributeAsString("pickerIconStyle");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon showPickerIcon} is true for this item, this
     * property governs the size of the picker icon. If unset, the picker icon will be sized as a square to fit in the
     * available height for the icon. <p> Note that if spriting is being used, and the image to be displayed is specified 
     * using css properties such as <code>background-image</code>, <code>background-size</code>, changing this value may result
     * in an unexpected appearance as the image will not scale.<br> Scaleable spriting can be achieved using the {@link
     * com.smartgwt.client.docs.SCSpriteConfig} format. See the section on spriting in the {@link
     * com.smartgwt.client.docs.Skinning skinning overview} for  further information.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param pickerIconWidth New pickerIconWidth value. Default value is null
     */
    public void setPickerIconWidth(Integer pickerIconWidth) {
        setAttribute("pickerIconWidth", pickerIconWidth);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon showPickerIcon} is true for this item, this
     * property governs the size of the picker icon. If unset, the picker icon will be sized as a square to fit in the
     * available height for the icon. <p> Note that if spriting is being used, and the image to be displayed is specified 
     * using css properties such as <code>background-image</code>, <code>background-size</code>, changing this value may result
     * in an unexpected appearance as the image will not scale.<br> Scaleable spriting can be achieved using the {@link
     * com.smartgwt.client.docs.SCSpriteConfig} format. See the section on spriting in the {@link
     * com.smartgwt.client.docs.Skinning skinning overview} for  further information.
     *
     * @return Current pickerIconWidth value. Default value is null
     */
    public Integer getPickerIconWidth()  {
        return getAttributeAsInt("pickerIconWidth");
    }
    
    

    /**
     * Base CSS class name for a form item's text box element when getting printable HTML for the form. If unset {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTextBoxStyle textBoxStyle} will be used instead. Note that focused
     * styling will never be displayed while printing, though error and disabled styling will.
     *
     * @param printTextBoxStyle New printTextBoxStyle value. Default value is null
     * @see com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle 
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public void setPrintTextBoxStyle(String printTextBoxStyle) {
        setAttribute("printTextBoxStyle", printTextBoxStyle);
    }

    /**
     * Base CSS class name for a form item's text box element when getting printable HTML for the form. If unset {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTextBoxStyle textBoxStyle} will be used instead. Note that focused
     * styling will never be displayed while printing, though error and disabled styling will.
     *
     * @return Current printTextBoxStyle value. Default value is null
     * @see com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle 
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public String getPrintTextBoxStyle()  {
        return getAttributeAsString("printTextBoxStyle");
    }
    

    /**
     * Base CSS stylename for a form item's title when generating print HTML for the item. If unset {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTitleStyle titleStyle} will be used instead.
     *
     * @param printTitleStyle New printTitleStyle value. Default value is null
     * @see com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle 
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public void setPrintTitleStyle(String printTitleStyle) {
        setAttribute("printTitleStyle", printTitleStyle);
    }

    /**
     * Base CSS stylename for a form item's title when generating print HTML for the item. If unset {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTitleStyle titleStyle} will be used instead.
     *
     * @return Current printTitleStyle value. Default value is null
     * @see com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle 
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public String getPrintTitleStyle()  {
        return getAttributeAsString("printTitleStyle");
    }
    

    /**
     * This text is shown as a tooltip prompt when the cursor hovers over this item. When item is {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setCanEdit read-only} a different hover can be shown with {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyHover readOnlyHover}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.form.fields.FormItem#getPrompt prompt} for this item.
     *
     * @param prompt new prompt for the item. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public void setPrompt(String prompt) {
        setAttribute("prompt", prompt);
    }

    /**
     * This text is shown as a tooltip prompt when the cursor hovers over this item. When item is {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setCanEdit read-only} a different hover can be shown with {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyHover readOnlyHover}.
     *
     * @return Current prompt value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public String getPrompt()  {
        return getAttributeAsString("prompt");
    }
    

    /**
     * For items showing a text value with {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit canEdit} set to
     * false,  should the user be able to select the text in the item? <P> Default behavior allows selection if {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyDisplay readOnlyDisplay} is  <code>"static"</code> or
     * <code>"readOnly"</code> [but not <code>"disabled"</code>]. Developers may add or remove ReadOnlyDisplayAppearance values
     * to change this behavior. <P> Note that this does not apply to {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisabled disabled items},  where text selection is never enabled
     *
     * @param readOnlyCanSelectText New readOnlyCanSelectText value. Default value is ["static", "readOnly"]
     */
    public void setReadOnlyCanSelectText(ReadOnlyDisplayAppearance... readOnlyCanSelectText) {
        setAttribute("readOnlyCanSelectText", readOnlyCanSelectText);
    }

    /**
     * For items showing a text value with {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit canEdit} set to
     * false,  should the user be able to select the text in the item? <P> Default behavior allows selection if {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyDisplay readOnlyDisplay} is  <code>"static"</code> or
     * <code>"readOnly"</code> [but not <code>"disabled"</code>]. Developers may add or remove ReadOnlyDisplayAppearance values
     * to change this behavior. <P> Note that this does not apply to {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisabled disabled items},  where text selection is never enabled
     *
     * @return Current readOnlyCanSelectText value. Default value is ["static", "readOnly"]
     */
    public ReadOnlyDisplayAppearance[] getReadOnlyCanSelectText()  {
        final String[] strings = getAttributeAsStringArray("readOnlyCanSelectText");
        return EnumUtil.getEnums(ReadOnlyDisplayAppearance.values(), strings, strings == null ? null : new ReadOnlyDisplayAppearance[strings.length]);
    }
    

    /**
     * If this item is {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit read-only}, how should this item be
     * displayed to the user? If set, overrides the form-level {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getReadOnlyDisplay DynamicForm.readOnlyDisplay} default.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyDisplay readOnlyDisplay}. <P> Note that calling this method for a {@link com.smartgwt.client.widgets.form.fields.ButtonItem} with {@link com.smartgwt.client.widgets.form.fields.ButtonItem#getEnableWhen ButtonItem.enableWhen} set is an error, since {@link com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyDisplay readOnlyDisplay} is then considered to always be "disabled".
     *
     * @param readOnlyDisplay new <code>readOnlyDisplay</code> value. Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#setReadOnlyDisplay
     */
    public void setReadOnlyDisplay(ReadOnlyDisplayAppearance readOnlyDisplay) {
        setAttribute("readOnlyDisplay", readOnlyDisplay == null ? null : readOnlyDisplay.getValue());
    }

    /**
     * If this item is {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit read-only}, how should this item be
     * displayed to the user? If set, overrides the form-level {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getReadOnlyDisplay DynamicForm.readOnlyDisplay} default.
     *
     * @return Current readOnlyDisplay value. Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#getReadOnlyDisplay
     */
    public ReadOnlyDisplayAppearance getReadOnlyDisplay()  {
        return EnumUtil.getEnum(ReadOnlyDisplayAppearance.values(), getAttribute("readOnlyDisplay"));
    }
    

    /**
     * This text is shown as a tooltip prompt when the cursor hovers over this item and the item is {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setCanEdit read-only}.
     *
     * @param readOnlyHover New readOnlyHover value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public void setReadOnlyHover(String readOnlyHover) {
        setAttribute("readOnlyHover", readOnlyHover);
    }

    /**
     * This text is shown as a tooltip prompt when the cursor hovers over this item and the item is {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setCanEdit read-only}.
     *
     * @return Current readOnlyHover value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getReadOnlyHover()  {
        return getAttributeAsString("readOnlyHover");
    }
    

    /**
     * Base text box style to apply when this item is {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit
     * read-only} and is using {@link com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyDisplay readOnlyDisplay} 
     * {@link com.smartgwt.client.types.ReadOnlyDisplayAppearance#STATIC}. If set, overrides the form-level {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getReadOnlyTextBoxStyle DynamicForm.readOnlyTextBoxStyle} default.
     *
     * @param readOnlyTextBoxStyle New readOnlyTextBoxStyle value. Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#setReadOnlyTextBoxStyle
     * @see com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle 
     */
    public void setReadOnlyTextBoxStyle(String readOnlyTextBoxStyle) {
        setAttribute("readOnlyTextBoxStyle", readOnlyTextBoxStyle);
    }

    /**
     * Base text box style to apply when this item is {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit
     * read-only} and is using {@link com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyDisplay readOnlyDisplay} 
     * {@link com.smartgwt.client.types.ReadOnlyDisplayAppearance#STATIC}. If set, overrides the form-level {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getReadOnlyTextBoxStyle DynamicForm.readOnlyTextBoxStyle} default.
     *
     * @return Current readOnlyTextBoxStyle value. Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#getReadOnlyTextBoxStyle
     * @see com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle 
     */
    public String getReadOnlyTextBoxStyle()  {
        return getAttributeAsString("readOnlyTextBoxStyle");
    }
    

    /**
     * Criteria to be evaluated to determine whether this FormItem should be made {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setCanEdit read-only}.  Appearance when read-only is determined by
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyDisplay readOnlyDisplay}. <p> Criteria are evaluated
     * against the {@link com.smartgwt.client.widgets.form.DynamicForm#getValues form's current values} as well as  the current
     * {@link com.smartgwt.client.widgets.Canvas#getRuleScope rule context}.  Criteria are re-evaluated every time form values
     * or the rule context changes, whether by end user action or by programmatic calls. <P> A basic criteria uses
     * textMatchStyle:"exact". When specified in {@link com.smartgwt.client.docs.ComponentXML Component XML} this property
     * allows {@link com.smartgwt.client.docs.XmlCriteriaShorthand shorthand formats} for defining criteria. <p> Note: A
     * FormItem using readOnlyWhen must have a {@link com.smartgwt.client.widgets.form.fields.FormItem#getName name} defined.
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getShouldSaveValue shouldSaveValue} can be set to
     * <code>false</code> to prevent the field from storing its value into the form's values.
     *
     * @param readOnlyWhen New readOnlyWhen value. Default value is null
     * @see com.smartgwt.client.docs.RuleCriteria RuleCriteria overview and related methods
     */
    public void setReadOnlyWhen(AdvancedCriteria readOnlyWhen) {
        if (readOnlyWhen instanceof Criterion) {
            readOnlyWhen.setAttribute("_constructor", "AdvancedCriteria");
        }
        setAttribute("readOnlyWhen", readOnlyWhen == null ? null : readOnlyWhen.getJsObj());
    }

    /**
     * Criteria to be evaluated to determine whether this FormItem should be made {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setCanEdit read-only}.  Appearance when read-only is determined by
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyDisplay readOnlyDisplay}. <p> Criteria are evaluated
     * against the {@link com.smartgwt.client.widgets.form.DynamicForm#getValues form's current values} as well as  the current
     * {@link com.smartgwt.client.widgets.Canvas#getRuleScope rule context}.  Criteria are re-evaluated every time form values
     * or the rule context changes, whether by end user action or by programmatic calls. <P> A basic criteria uses
     * textMatchStyle:"exact". When specified in {@link com.smartgwt.client.docs.ComponentXML Component XML} this property
     * allows {@link com.smartgwt.client.docs.XmlCriteriaShorthand shorthand formats} for defining criteria. <p> Note: A
     * FormItem using readOnlyWhen must have a {@link com.smartgwt.client.widgets.form.fields.FormItem#getName name} defined.
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getShouldSaveValue shouldSaveValue} can be set to
     * <code>false</code> to prevent the field from storing its value into the form's values.
     *
     * @return Current readOnlyWhen value. Default value is null
     * @see com.smartgwt.client.docs.RuleCriteria RuleCriteria overview and related methods
     */
    public AdvancedCriteria getReadOnlyWhen()  {
        return new AdvancedCriteria(getAttributeAsJavaScriptObject("readOnlyWhen"));
    }
    

    /**
     * If true, this item will cause the entire form to be redrawn when the item's "elementChanged" event is done firing
     *
     * @param redrawOnChange New redrawOnChange value. Default value is false
     */
    public void setRedrawOnChange(Boolean redrawOnChange) {
        setAttribute("redrawOnChange", redrawOnChange);
    }

    /**
     * If true, this item will cause the entire form to be redrawn when the item's "elementChanged" event is done firing
     *
     * @return Current redrawOnChange value. Default value is false
     */
    public Boolean getRedrawOnChange()  {
        Boolean result = getAttributeAsBoolean("redrawOnChange", true);
        return result == null ? false : result;
    }
    

    /**
     * If validateOnChange is true, and validation fails for this item on change, with no suggested value, should we revert to
     * the previous value, or continue to display the bad value entered by the user. May be set at the item or form level.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param rejectInvalidValueOnChange New rejectInvalidValueOnChange value. Default value is false
     */
    public void setRejectInvalidValueOnChange(Boolean rejectInvalidValueOnChange) {
        setAttribute("rejectInvalidValueOnChange", rejectInvalidValueOnChange);
    }

    /**
     * If validateOnChange is true, and validation fails for this item on change, with no suggested value, should we revert to
     * the previous value, or continue to display the bad value entered by the user. May be set at the item or form level.
     *
     * @return Current rejectInvalidValueOnChange value. Default value is false
     */
    public Boolean getRejectInvalidValueOnChange()  {
        Boolean result = getAttributeAsBoolean("rejectInvalidValueOnChange", true);
        return result == null ? false : result;
    }
    

    /**
     * Whether a non-empty value is required for this field to pass validation. <P> If the user does not fill in the required
     * field, the error message to be shown will be taken from these properties in the following order: {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getRequiredMessage requiredMessage}, {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getRequiredMessage DynamicForm.requiredMessage}, {@link
     * com.smartgwt.client.data.DataSource#getRequiredMessage DataSource.requiredMessage},  {@link
     * com.smartgwt.client.widgets.form.validator.Validator#requiredField requiredField}. <P> <b>Note:</b> if specified on a
     * FormItem, <code>required</code> is only enforced on the client.  <code>required</code> should generally be specified on
     * a {@link com.smartgwt.client.data.DataSourceField}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter to mark this formItem as {@link com.smartgwt.client.widgets.form.fields.FormItem#getRequired required}, or not required at runtime. Note that an alternative approach to updating the <code>required</code> flag directly would be to simply use a {@link com.smartgwt.client.types.ValidatorType requiredIf} type validator. <P> Note that this method will not re-validate this item by default or clear any  existing validation errors. If desired, this may be achieved by calling {@link com.smartgwt.client.widgets.form.fields.FormItem#validate validate()} or {@link com.smartgwt.client.widgets.form.DynamicForm#clearErrors DynamicForm.clearErrors()}.
     *
     * @param required new {@link com.smartgwt.client.widgets.form.fields.FormItem#getRequired required} value. Default value is false
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_dep_show_hide" target="examples">Show & Hide Example</a>
     */
    public void setRequired(Boolean required) {
        setAttribute("required", required);
    }

    /**
     * Whether a non-empty value is required for this field to pass validation. <P> If the user does not fill in the required
     * field, the error message to be shown will be taken from these properties in the following order: {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getRequiredMessage requiredMessage}, {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getRequiredMessage DynamicForm.requiredMessage}, {@link
     * com.smartgwt.client.data.DataSource#getRequiredMessage DataSource.requiredMessage},  {@link
     * com.smartgwt.client.widgets.form.validator.Validator#requiredField requiredField}. <P> <b>Note:</b> if specified on a
     * FormItem, <code>required</code> is only enforced on the client.  <code>required</code> should generally be specified on
     * a {@link com.smartgwt.client.data.DataSourceField}.
     *
     * @return Current required value. Default value is false
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_dep_show_hide" target="examples">Show & Hide Example</a>
     */
    public Boolean getRequired()  {
        Boolean result = getAttributeAsBoolean("required", true);
        return result == null ? false : result;
    }
    

    /**
     * The required message for required field errors.
     *
     * @param requiredMessage New requiredMessage value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public void setRequiredMessage(String requiredMessage) {
        setAttribute("requiredMessage", requiredMessage);
    }

    /**
     * The required message for required field errors.
     *
     * @return Current requiredMessage value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public String getRequiredMessage()  {
        return getAttributeAsString("requiredMessage");
    }
    

    /**
     * Criteria to be evaluated to determine whether this FormItem should be {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getRequired required}. <p> Criteria are evaluated against the {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValues form's current values} as well as  the current {@link
     * com.smartgwt.client.widgets.Canvas#getRuleScope rule context}.  Criteria are re-evaluated every time form values or the
     * rule context changes, whether by end user action or by programmatic calls. <P> A basic criteria uses
     * textMatchStyle:"exact". When specified in {@link com.smartgwt.client.docs.ComponentXML Component XML} this property
     * allows {@link com.smartgwt.client.docs.XmlCriteriaShorthand shorthand formats} for defining criteria. <p> Note: A
     * FormItem using requiredWhen must have a {@link com.smartgwt.client.widgets.form.fields.FormItem#getName name} defined.
     *
     * @param requiredWhen New requiredWhen value. Default value is null
     * @see com.smartgwt.client.docs.RuleCriteria RuleCriteria overview and related methods
     */
    public void setRequiredWhen(Criteria requiredWhen) {
        if (requiredWhen instanceof Criterion) {
            requiredWhen.setAttribute("_constructor", "AdvancedCriteria");
        }
        setAttribute("requiredWhen", requiredWhen == null ? null : requiredWhen.getJsObj());
    }

    /**
     * Criteria to be evaluated to determine whether this FormItem should be {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getRequired required}. <p> Criteria are evaluated against the {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValues form's current values} as well as  the current {@link
     * com.smartgwt.client.widgets.Canvas#getRuleScope rule context}.  Criteria are re-evaluated every time form values or the
     * rule context changes, whether by end user action or by programmatic calls. <P> A basic criteria uses
     * textMatchStyle:"exact". When specified in {@link com.smartgwt.client.docs.ComponentXML Component XML} this property
     * allows {@link com.smartgwt.client.docs.XmlCriteriaShorthand shorthand formats} for defining criteria. <p> Note: A
     * FormItem using requiredWhen must have a {@link com.smartgwt.client.widgets.form.fields.FormItem#getName name} defined.
     *
     * @return Current requiredWhen value. Default value is null
     * @see com.smartgwt.client.docs.RuleCriteria RuleCriteria overview and related methods
     */
    public Criteria getRequiredWhen()  {
        return new Criteria(getAttributeAsJavaScriptObject("requiredWhen"));
    }
    

    /**
     * Number of rows that this item spans
     *
     * @param rowSpan New rowSpan value. Default value is 1
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public void setRowSpan(int rowSpan) {
        setAttribute("rowSpan", rowSpan);
    }

    /**
     * Number of rows that this item spans
     *
     * @return Current rowSpan value. Default value is 1
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public int getRowSpan()  {
        return getAttributeAsInt("rowSpan");
    }
    

    /**
     * Set this to true to allow the parent form to save it's data when 'Enter' is pressed on  this formItem and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getSaveOnEnter saveOnEnter} is true on the parent form.
     *
     * @param saveOnEnter New saveOnEnter value. Default value is null
     */
    public void setSaveOnEnter(Boolean saveOnEnter) {
        setAttribute("saveOnEnter", saveOnEnter);
    }

    /**
     * Set this to true to allow the parent form to save it's data when 'Enter' is pressed on  this formItem and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getSaveOnEnter saveOnEnter} is true on the parent form.
     *
     * @return Current saveOnEnter value. Default value is null
     */
    public Boolean getSaveOnEnter()  {
        return getAttributeAsBoolean("saveOnEnter", true);
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
     * Should this item's value be saved in the form's values and hence returned from {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValues form.getValues()}? <p> <code>shouldSaveValue:false</code> is used
     * to mark formItems which do not correspond to the underlying data model and should not save a value into the form's
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getValues values}.  Example includes visual separators, password
     * re-type fields, or checkboxes used to show/hide other form items. <p> A <code>shouldSaveValue:false</code> item should
     * be given a value either via {@link com.smartgwt.client.widgets.form.fields.FormItem#getDefaultValue defaultValue} or by
     * calling {@link com.smartgwt.client.widgets.form.DynamicForm#setValue form.setValue(item, value)} or  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setValue formItem.setValue(value)}.  Providing a value via {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValues form.values} or {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setValues form.setValues()}  will automatically switch the item to
     * <code>shouldSaveValue:true</code>. <P> Note that <ul> <li>if an item is shouldSaveValue true, but has no name, a warning
     * is logged, and      shouldSaveValue will be set to false. </li></ul>
     *
     * @param shouldSaveValue New shouldSaveValue value. Default value is true
     */
    public void setShouldSaveValue(Boolean shouldSaveValue) {
        setAttribute("shouldSaveValue", shouldSaveValue);
    }

    /**
     * Should this item's value be saved in the form's values and hence returned from {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValues form.getValues()}? <p> <code>shouldSaveValue:false</code> is used
     * to mark formItems which do not correspond to the underlying data model and should not save a value into the form's
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getValues values}.  Example includes visual separators, password
     * re-type fields, or checkboxes used to show/hide other form items. <p> A <code>shouldSaveValue:false</code> item should
     * be given a value either via {@link com.smartgwt.client.widgets.form.fields.FormItem#getDefaultValue defaultValue} or by
     * calling {@link com.smartgwt.client.widgets.form.DynamicForm#setValue form.setValue(item, value)} or  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setValue formItem.setValue(value)}.  Providing a value via {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValues form.values} or {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setValues form.setValues()}  will automatically switch the item to
     * <code>shouldSaveValue:true</code>. <P> Note that <ul> <li>if an item is shouldSaveValue true, but has no name, a warning
     * is logged, and      shouldSaveValue will be set to false. </li></ul>
     *
     * @return Current shouldSaveValue value. Default value is true
     */
    public Boolean getShouldSaveValue()  {
        Boolean result = getAttributeAsBoolean("shouldSaveValue", true);
        return result == null ? true : result;
    }
    

    /**
     * If true and the title is clipped, then a hover containing the full title of this item is enabled. <p>  A
     * <code>TitleHoverEvent</code> is fired before the hover is displayed, allowing the hover to be canceled if desired. The
     * HTML shown in the hover can be customized by setting a <code>FormItemHoverFormatter</code> on either this
     * <code>FormItem</code> or the <code>DynamicForm</code>. See <code>setItemTitleHoverFormatter()</code>.
     *
     * @param showClippedTitleOnHover New showClippedTitleOnHover value. Default value is true
     */
    public void setShowClippedTitleOnHover(boolean showClippedTitleOnHover) {
        setAttribute("showClippedTitleOnHover", showClippedTitleOnHover);
    }

    /**
     * If true and the title is clipped, then a hover containing the full title of this item is enabled. <p>  A
     * <code>TitleHoverEvent</code> is fired before the hover is displayed, allowing the hover to be canceled if desired. The
     * HTML shown in the hover can be customized by setting a <code>FormItemHoverFormatter</code> on either this
     * <code>FormItem</code> or the <code>DynamicForm</code>. See <code>setItemTitleHoverFormatter()</code>.
     *
     * @return Current showClippedTitleOnHover value. Default value is true
     */
    public boolean getShowClippedTitleOnHover()  {
        Boolean result = getAttributeAsBoolean("showClippedTitleOnHover", true);
        return result == null ? true : result;
    }
    

    /**
     * If true and the value is clipped, then a hover containing the full value of this item is enabled. <p>  A
     * <code>ValueHoverEvent</code> is fired before the hover is displayed, allowing the hover to be canceled if desired. The
     * HTML shown in the hover can be customized by setting a <code>FormItemHoverFormatter</code> on either this
     * <code>FormItem</code> or the <code>DynamicForm</code>. See <code>setItemValueHoverFormatter()</code>.
     *
     * @param showClippedValueOnHover New showClippedValueOnHover value. Default value is true
     */
    public void setShowClippedValueOnHover(Boolean showClippedValueOnHover) {
        setAttribute("showClippedValueOnHover", showClippedValueOnHover);
    }

    /**
     * If true and the value is clipped, then a hover containing the full value of this item is enabled. <p>  A
     * <code>ValueHoverEvent</code> is fired before the hover is displayed, allowing the hover to be canceled if desired. The
     * HTML shown in the hover can be customized by setting a <code>FormItemHoverFormatter</code> on either this
     * <code>FormItem</code> or the <code>DynamicForm</code>. See <code>setItemValueHoverFormatter()</code>.
     *
     * @return Current showClippedValueOnHover value. Default value is true
     */
    public Boolean getShowClippedValueOnHover()  {
        Boolean result = getAttributeAsBoolean("showClippedValueOnHover", true);
        return result == null ? true : result;
    }
    

    /**
     * For items that support {@link com.smartgwt.client.widgets.form.fields.SelectItem#getMultiple multiple values}, this
     * causes distinct CSS styling to be applied to values that the user has unselected. <p> Only allowed when {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowPending showPending} is <code>true</code>. Defaults to the
     * form-level {@link com.smartgwt.client.widgets.form.DynamicForm#getShowDeletions DynamicForm.showDeletions} setting if
     * set; otherwise, to the value of <code>showPending</code>. <p> Only supported for {@link
     * com.smartgwt.client.widgets.form.fields.MultiComboBoxItem} and for {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem} when {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getMultiple multiple:true} is set. The specific default behaviors
     * are: <ul> <li>For <code>MultiComboBoxItem</code>, buttons corresponding to deleted values     (also called "deselected
     * buttons") will be disabled and have their {@link com.smartgwt.client.widgets.Button#getBaseStyle Button.baseStyle}    
     * set to {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getDeselectedButtonStyle
     * MultiComboBoxItem.deselectedButtonStyle}. <li>For a multiple <code>SelectItem</code>, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueDeselectedCSSText valueDeselectedCSSText} is     applied to any
     * deleted value in the text box. In addition, "Deselected" is appended     to the cells' {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle ListGrid.baseStyle} for cells in the pickList menu corresponding 
     * to deleted values. </ul> <p> <strong>NOTE:</strong> When a value is shown as deleted, this is not reflected to screen
     * readers, and screen readers are instructed to ignore the deleted value. Therefore, it is not advisable to design a UI
     * where it is necessary for the user to know whether a value is shown as deleted in order to work with the form.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showDeletions New showDeletions value. Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#setShowDeletions
     */
    public void setShowDeletions(Boolean showDeletions) {
        setAttribute("showDeletions", showDeletions);
    }

    /**
     * For items that support {@link com.smartgwt.client.widgets.form.fields.SelectItem#getMultiple multiple values}, this
     * causes distinct CSS styling to be applied to values that the user has unselected. <p> Only allowed when {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowPending showPending} is <code>true</code>. Defaults to the
     * form-level {@link com.smartgwt.client.widgets.form.DynamicForm#getShowDeletions DynamicForm.showDeletions} setting if
     * set; otherwise, to the value of <code>showPending</code>. <p> Only supported for {@link
     * com.smartgwt.client.widgets.form.fields.MultiComboBoxItem} and for {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem} when {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getMultiple multiple:true} is set. The specific default behaviors
     * are: <ul> <li>For <code>MultiComboBoxItem</code>, buttons corresponding to deleted values     (also called "deselected
     * buttons") will be disabled and have their {@link com.smartgwt.client.widgets.Button#getBaseStyle Button.baseStyle}    
     * set to {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getDeselectedButtonStyle
     * MultiComboBoxItem.deselectedButtonStyle}. <li>For a multiple <code>SelectItem</code>, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueDeselectedCSSText valueDeselectedCSSText} is     applied to any
     * deleted value in the text box. In addition, "Deselected" is appended     to the cells' {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle ListGrid.baseStyle} for cells in the pickList menu corresponding 
     * to deleted values. </ul> <p> <strong>NOTE:</strong> When a value is shown as deleted, this is not reflected to screen
     * readers, and screen readers are instructed to ignore the deleted value. Therefore, it is not advisable to design a UI
     * where it is necessary for the user to know whether a value is shown as deleted in order to work with the form.
     *
     * @return Current showDeletions value. Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#getShowDeletions
     */
    public Boolean getShowDeletions()  {
        return getAttributeAsBoolean("showDeletions", true);
    }
    

    /**
     * When this item is disabled, should it be re-styled to indicate its disabled state? <P> See {@link
     * com.smartgwt.client.docs.FormItemStyling} for more details on formItem styling.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter method for {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowDisabled showDisabled}
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showDisabled new showDisabled setting. Default value is true
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setCellStyle
     * @see com.smartgwt.client.docs.FormItemStyling FormItemStyling overview and related methods
     */
    public void setShowDisabled(Boolean showDisabled) {
        setAttribute("showDisabled", showDisabled);
    }

    /**
     * When this item is disabled, should it be re-styled to indicate its disabled state? <P> See {@link
     * com.smartgwt.client.docs.FormItemStyling} for more details on formItem styling.
     *
     * @return Current showDisabled value. Default value is true
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getCellStyle
     * @see com.smartgwt.client.docs.FormItemStyling FormItemStyling overview and related methods
     */
    public Boolean getShowDisabled()  {
        Boolean result = getAttributeAsBoolean("showDisabled", true);
        return result == null ? true : result;
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowIconsOnFocus showIconsOnFocus} is true, should icons
     * marked as disabled be shown on focus? <P> Default setting is <code>false</code> - it is not commonly desirable to 
     * present a user with a disabled icon on focus. <P> Can be overridden at the icon level by {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getShowDisabledOnFocus FormItemIcon.showDisabledOnFocus}
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showDisabledIconsOnFocus New showDisabledIconsOnFocus value. Default value is false
     */
    public void setShowDisabledIconsOnFocus(Boolean showDisabledIconsOnFocus) {
        setAttribute("showDisabledIconsOnFocus", showDisabledIconsOnFocus);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowIconsOnFocus showIconsOnFocus} is true, should icons
     * marked as disabled be shown on focus? <P> Default setting is <code>false</code> - it is not commonly desirable to 
     * present a user with a disabled icon on focus. <P> Can be overridden at the icon level by {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getShowDisabledOnFocus FormItemIcon.showDisabledOnFocus}
     *
     * @return Current showDisabledIconsOnFocus value. Default value is false
     */
    public Boolean getShowDisabledIconsOnFocus()  {
        Boolean result = getAttributeAsBoolean("showDisabledIconsOnFocus", true);
        return result == null ? false : result;
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIconOnFocus showPickerIconOnFocus} is true,
     * should the picker icon be shown on focus if it is disabled (as in a read-only item, for example?) <P> Default setting is
     * <code>false</code> - it is not commonly desirable to  present a user with a disabled icon on focus. <P> Can be
     * overridden at the icon level by {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getShowDisabledOnFocus
     * FormItemIcon.showDisabledOnFocus}
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showDisabledPickerIconOnFocus New showDisabledPickerIconOnFocus value. Default value is false
     */
    public void setShowDisabledPickerIconOnFocus(Boolean showDisabledPickerIconOnFocus) {
        setAttribute("showDisabledPickerIconOnFocus", showDisabledPickerIconOnFocus);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIconOnFocus showPickerIconOnFocus} is true,
     * should the picker icon be shown on focus if it is disabled (as in a read-only item, for example?) <P> Default setting is
     * <code>false</code> - it is not commonly desirable to  present a user with a disabled icon on focus. <P> Can be
     * overridden at the icon level by {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getShowDisabledOnFocus
     * FormItemIcon.showDisabledOnFocus}
     *
     * @return Current showDisabledPickerIconOnFocus value. Default value is false
     */
    public Boolean getShowDisabledPickerIconOnFocus()  {
        Boolean result = getAttributeAsBoolean("showDisabledPickerIconOnFocus", true);
        return result == null ? false : result;
    }
    

    /**
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorIcons showErrorIcons},  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}, and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorStyle showErrorStyle} control how validation errors are
     * displayed when they are displayed inline in the form (next to the form item where there is a validation error).  To
     * instead display all errors at the top of the form, set {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowInlineErrors showInlineErrors}:false. <P>
     * <code>showErrorIcons</code>, <code>showErrorText</code> and <code>showErrorStyle</code> are all boolean properties, and
     * can be set on a DynamicForm to control the behavior form-wide, or set on individual FormItems.   <P> The HTML displayed
     * next to a form item with errors is generated by  {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorHTML
     * getErrorHTML()}. The default implementation of that method respects <code>showErrorIcons</code> and
     * <code>showErrorText</code> as follows: <P> <code>showErrorIcons</code>, or <code>showErrorIcon</code> at the FormItem
     * level controls whether an error icon should appear next to fields which have validation errors.  The icon's appearance
     * is governed by {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconSrc errorIconSrc}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconWidth errorIconWidth} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconHeight errorIconHeight} <P> <code>showErrorText</code>
     * determines whether the text of the validation error should be displayed next to fields which have validation errors. The
     * attribute {@link com.smartgwt.client.widgets.form.DynamicForm#getShowTitlesWithErrorMessages
     * DynamicForm.showTitlesWithErrorMessages} may be set to prefix error messages with the  form item's title +
     * <code>":"</code> (may be desired if the item has  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle
     * showTitle} set to false). <P> {@link com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation
     * DynamicForm.errorOrientation} controls where the error HTML should appear relative  to form items. Therefore the
     * combination of {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowErrorText
     * showErrorText}<code>:false</code> and {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorOrientation
     * errorOrientation}<code>:"left"</code> creates a compact validation error display consisting of just an icon, to the left
     * of the item with the error message available via a hover (similar appearance to ListGrid validation error display).  
     * <P> In addition to this, <code>showErrorStyle</code> determines whether fields  with validation errors should have
     * special styling applied to them. Error styling is achieved by applying suffixes to existing styling applied to various
     * parts of the form item. See {@link com.smartgwt.client.docs.FormItemBaseStyle} for more on this.
     *
     * @param showErrorIcon New showErrorIcon value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setShowErrorIcon(Boolean showErrorIcon) {
        setAttribute("showErrorIcon", showErrorIcon);
    }

    /**
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorIcons showErrorIcons},  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}, and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorStyle showErrorStyle} control how validation errors are
     * displayed when they are displayed inline in the form (next to the form item where there is a validation error).  To
     * instead display all errors at the top of the form, set {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowInlineErrors showInlineErrors}:false. <P>
     * <code>showErrorIcons</code>, <code>showErrorText</code> and <code>showErrorStyle</code> are all boolean properties, and
     * can be set on a DynamicForm to control the behavior form-wide, or set on individual FormItems.   <P> The HTML displayed
     * next to a form item with errors is generated by  {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorHTML
     * getErrorHTML()}. The default implementation of that method respects <code>showErrorIcons</code> and
     * <code>showErrorText</code> as follows: <P> <code>showErrorIcons</code>, or <code>showErrorIcon</code> at the FormItem
     * level controls whether an error icon should appear next to fields which have validation errors.  The icon's appearance
     * is governed by {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconSrc errorIconSrc}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconWidth errorIconWidth} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconHeight errorIconHeight} <P> <code>showErrorText</code>
     * determines whether the text of the validation error should be displayed next to fields which have validation errors. The
     * attribute {@link com.smartgwt.client.widgets.form.DynamicForm#getShowTitlesWithErrorMessages
     * DynamicForm.showTitlesWithErrorMessages} may be set to prefix error messages with the  form item's title +
     * <code>":"</code> (may be desired if the item has  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle
     * showTitle} set to false). <P> {@link com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation
     * DynamicForm.errorOrientation} controls where the error HTML should appear relative  to form items. Therefore the
     * combination of {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowErrorText
     * showErrorText}<code>:false</code> and {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorOrientation
     * errorOrientation}<code>:"left"</code> creates a compact validation error display consisting of just an icon, to the left
     * of the item with the error message available via a hover (similar appearance to ListGrid validation error display).  
     * <P> In addition to this, <code>showErrorStyle</code> determines whether fields  with validation errors should have
     * special styling applied to them. Error styling is achieved by applying suffixes to existing styling applied to various
     * parts of the form item. See {@link com.smartgwt.client.docs.FormItemBaseStyle} for more on this.
     *
     * @return Current showErrorIcon value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowErrorIcon()  {
        return getAttributeAsBoolean("showErrorIcon", true);
    }
    

    /**
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorIcons showErrorIcons},  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}, and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorStyle showErrorStyle} control how validation errors are
     * displayed when they are displayed inline in the form (next to the form item where there is a validation error).  To
     * instead display all errors at the top of the form, set {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowInlineErrors showInlineErrors}:false. <P>
     * <code>showErrorIcons</code>, <code>showErrorText</code> and <code>showErrorStyle</code> are all boolean properties, and
     * can be set on a DynamicForm to control the behavior form-wide, or set on individual FormItems.   <P> The HTML displayed
     * next to a form item with errors is generated by  {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorHTML
     * getErrorHTML()}. The default implementation of that method respects <code>showErrorIcons</code> and
     * <code>showErrorText</code> as follows: <P> <code>showErrorIcons</code>, or <code>showErrorIcon</code> at the FormItem
     * level controls whether an error icon should appear next to fields which have validation errors.  The icon's appearance
     * is governed by {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconSrc errorIconSrc}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconWidth errorIconWidth} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconHeight errorIconHeight} <P> <code>showErrorText</code>
     * determines whether the text of the validation error should be displayed next to fields which have validation errors. The
     * attribute {@link com.smartgwt.client.widgets.form.DynamicForm#getShowTitlesWithErrorMessages
     * DynamicForm.showTitlesWithErrorMessages} may be set to prefix error messages with the  form item's title +
     * <code>":"</code> (may be desired if the item has  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle
     * showTitle} set to false). <P> {@link com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation
     * DynamicForm.errorOrientation} controls where the error HTML should appear relative  to form items. Therefore the
     * combination of {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowErrorText
     * showErrorText}<code>:false</code> and {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorOrientation
     * errorOrientation}<code>:"left"</code> creates a compact validation error display consisting of just an icon, to the left
     * of the item with the error message available via a hover (similar appearance to ListGrid validation error display).  
     * <P> In addition to this, <code>showErrorStyle</code> determines whether fields  with validation errors should have
     * special styling applied to them. Error styling is achieved by applying suffixes to existing styling applied to various
     * parts of the form item. See {@link com.smartgwt.client.docs.FormItemBaseStyle} for more on this.
     *
     * @param showErrorStyle New showErrorStyle value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setCellStyle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setShowErrorStyle(Boolean showErrorStyle) {
        setAttribute("showErrorStyle", showErrorStyle);
    }

    /**
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorIcons showErrorIcons},  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}, and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorStyle showErrorStyle} control how validation errors are
     * displayed when they are displayed inline in the form (next to the form item where there is a validation error).  To
     * instead display all errors at the top of the form, set {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowInlineErrors showInlineErrors}:false. <P>
     * <code>showErrorIcons</code>, <code>showErrorText</code> and <code>showErrorStyle</code> are all boolean properties, and
     * can be set on a DynamicForm to control the behavior form-wide, or set on individual FormItems.   <P> The HTML displayed
     * next to a form item with errors is generated by  {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorHTML
     * getErrorHTML()}. The default implementation of that method respects <code>showErrorIcons</code> and
     * <code>showErrorText</code> as follows: <P> <code>showErrorIcons</code>, or <code>showErrorIcon</code> at the FormItem
     * level controls whether an error icon should appear next to fields which have validation errors.  The icon's appearance
     * is governed by {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconSrc errorIconSrc}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconWidth errorIconWidth} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconHeight errorIconHeight} <P> <code>showErrorText</code>
     * determines whether the text of the validation error should be displayed next to fields which have validation errors. The
     * attribute {@link com.smartgwt.client.widgets.form.DynamicForm#getShowTitlesWithErrorMessages
     * DynamicForm.showTitlesWithErrorMessages} may be set to prefix error messages with the  form item's title +
     * <code>":"</code> (may be desired if the item has  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle
     * showTitle} set to false). <P> {@link com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation
     * DynamicForm.errorOrientation} controls where the error HTML should appear relative  to form items. Therefore the
     * combination of {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowErrorText
     * showErrorText}<code>:false</code> and {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorOrientation
     * errorOrientation}<code>:"left"</code> creates a compact validation error display consisting of just an icon, to the left
     * of the item with the error message available via a hover (similar appearance to ListGrid validation error display).  
     * <P> In addition to this, <code>showErrorStyle</code> determines whether fields  with validation errors should have
     * special styling applied to them. Error styling is achieved by applying suffixes to existing styling applied to various
     * parts of the form item. See {@link com.smartgwt.client.docs.FormItemBaseStyle} for more on this.
     *
     * @return Current showErrorStyle value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getCellStyle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowErrorStyle()  {
        return getAttributeAsBoolean("showErrorStyle", true);
    }
    

    /**
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorIcons showErrorIcons},  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}, and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorStyle showErrorStyle} control how validation errors are
     * displayed when they are displayed inline in the form (next to the form item where there is a validation error).  To
     * instead display all errors at the top of the form, set {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowInlineErrors showInlineErrors}:false. <P>
     * <code>showErrorIcons</code>, <code>showErrorText</code> and <code>showErrorStyle</code> are all boolean properties, and
     * can be set on a DynamicForm to control the behavior form-wide, or set on individual FormItems.   <P> The HTML displayed
     * next to a form item with errors is generated by  {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorHTML
     * getErrorHTML()}. The default implementation of that method respects <code>showErrorIcons</code> and
     * <code>showErrorText</code> as follows: <P> <code>showErrorIcons</code>, or <code>showErrorIcon</code> at the FormItem
     * level controls whether an error icon should appear next to fields which have validation errors.  The icon's appearance
     * is governed by {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconSrc errorIconSrc}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconWidth errorIconWidth} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconHeight errorIconHeight} <P> <code>showErrorText</code>
     * determines whether the text of the validation error should be displayed next to fields which have validation errors. The
     * attribute {@link com.smartgwt.client.widgets.form.DynamicForm#getShowTitlesWithErrorMessages
     * DynamicForm.showTitlesWithErrorMessages} may be set to prefix error messages with the  form item's title +
     * <code>":"</code> (may be desired if the item has  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle
     * showTitle} set to false). <P> {@link com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation
     * DynamicForm.errorOrientation} controls where the error HTML should appear relative  to form items. Therefore the
     * combination of {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowErrorText
     * showErrorText}<code>:false</code> and {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorOrientation
     * errorOrientation}<code>:"left"</code> creates a compact validation error display consisting of just an icon, to the left
     * of the item with the error message available via a hover (similar appearance to ListGrid validation error display).  
     * <P> In addition to this, <code>showErrorStyle</code> determines whether fields  with validation errors should have
     * special styling applied to them. Error styling is achieved by applying suffixes to existing styling applied to various
     * parts of the form item. See {@link com.smartgwt.client.docs.FormItemBaseStyle} for more on this.
     *
     * @param showErrorText New showErrorText value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setShowErrorText(Boolean showErrorText) {
        setAttribute("showErrorText", showErrorText);
    }

    /**
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorIcons showErrorIcons},  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}, and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorStyle showErrorStyle} control how validation errors are
     * displayed when they are displayed inline in the form (next to the form item where there is a validation error).  To
     * instead display all errors at the top of the form, set {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowInlineErrors showInlineErrors}:false. <P>
     * <code>showErrorIcons</code>, <code>showErrorText</code> and <code>showErrorStyle</code> are all boolean properties, and
     * can be set on a DynamicForm to control the behavior form-wide, or set on individual FormItems.   <P> The HTML displayed
     * next to a form item with errors is generated by  {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorHTML
     * getErrorHTML()}. The default implementation of that method respects <code>showErrorIcons</code> and
     * <code>showErrorText</code> as follows: <P> <code>showErrorIcons</code>, or <code>showErrorIcon</code> at the FormItem
     * level controls whether an error icon should appear next to fields which have validation errors.  The icon's appearance
     * is governed by {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconSrc errorIconSrc}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconWidth errorIconWidth} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconHeight errorIconHeight} <P> <code>showErrorText</code>
     * determines whether the text of the validation error should be displayed next to fields which have validation errors. The
     * attribute {@link com.smartgwt.client.widgets.form.DynamicForm#getShowTitlesWithErrorMessages
     * DynamicForm.showTitlesWithErrorMessages} may be set to prefix error messages with the  form item's title +
     * <code>":"</code> (may be desired if the item has  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle
     * showTitle} set to false). <P> {@link com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation
     * DynamicForm.errorOrientation} controls where the error HTML should appear relative  to form items. Therefore the
     * combination of {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowErrorText
     * showErrorText}<code>:false</code> and {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorOrientation
     * errorOrientation}<code>:"left"</code> creates a compact validation error display consisting of just an icon, to the left
     * of the item with the error message available via a hover (similar appearance to ListGrid validation error display).  
     * <P> In addition to this, <code>showErrorStyle</code> determines whether fields  with validation errors should have
     * special styling applied to them. Error styling is achieved by applying suffixes to existing styling applied to various
     * parts of the form item. See {@link com.smartgwt.client.docs.FormItemBaseStyle} for more on this.
     *
     * @return Current showErrorText value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowErrorText()  {
        return getAttributeAsBoolean("showErrorText", true);
    }
    

    /**
     * When this item receives focus, should it be re-styled to indicate it has focus? <P> See {@link
     * com.smartgwt.client.docs.FormItemStyling} for more details on formItem styling.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showFocused New showFocused value. Default value is false
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setCellStyle
     * @see com.smartgwt.client.docs.FormItemStyling FormItemStyling overview and related methods
     */
    public void setShowFocused(Boolean showFocused) {
        setAttribute("showFocused", showFocused);
    }

    /**
     * When this item receives focus, should it be re-styled to indicate it has focus? <P> See {@link
     * com.smartgwt.client.docs.FormItemStyling} for more details on formItem styling.
     *
     * @return Current showFocused value. Default value is false
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getCellStyle
     * @see com.smartgwt.client.docs.FormItemStyling FormItemStyling overview and related methods
     */
    public Boolean getShowFocused()  {
        Boolean result = getAttributeAsBoolean("showFocused", true);
        return result == null ? false : result;
    }
    

    /**
     * If set to true, when an item has errors and is focused, an "ErrorFocused" suffix  will appear on the stylename.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showFocusedErrorState New showFocusedErrorState value. Default value is false
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setCellStyle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setShowFocusedErrorState(Boolean showFocusedErrorState) {
        setAttribute("showFocusedErrorState", showFocusedErrorState);
    }

    /**
     * If set to true, when an item has errors and is focused, an "ErrorFocused" suffix  will appear on the stylename.
     *
     * @return Current showFocusedErrorState value. Default value is false
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getCellStyle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowFocusedErrorState()  {
        Boolean result = getAttributeAsBoolean("showFocusedErrorState", true);
        return result == null ? false : result;
    }
    

    /**
     * If we're showing icons, should we change their image source to the appropriate  <i>focused</i>  source when this item
     * has focus?  Can be overridden on a per  icon basis by the formItemIcon <code>showFocused</code> property.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showFocusedIcons New showFocusedIcons value. Default value is null
     */
    public void setShowFocusedIcons(Boolean showFocusedIcons) {
        setAttribute("showFocusedIcons", showFocusedIcons);
    }

    /**
     * If we're showing icons, should we change their image source to the appropriate  <i>focused</i>  source when this item
     * has focus?  Can be overridden on a per  icon basis by the formItemIcon <code>showFocused</code> property.
     *
     * @return Current showFocusedIcons value. Default value is null
     */
    public Boolean getShowFocusedIcons()  {
        return getAttributeAsBoolean("showFocusedIcons", true);
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon showPickerIcon} is true for this item,
     * should the picker icon show a focused image when the form item has focus?
     *
     * @param showFocusedPickerIcon New showFocusedPickerIcon value. Default value is false
     */
    public void setShowFocusedPickerIcon(Boolean showFocusedPickerIcon) {
        setAttribute("showFocusedPickerIcon", showFocusedPickerIcon);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon showPickerIcon} is true for this item,
     * should the picker icon show a focused image when the form item has focus?
     *
     * @return Current showFocusedPickerIcon value. Default value is false
     */
    public Boolean getShowFocusedPickerIcon()  {
        Boolean result = getAttributeAsBoolean("showFocusedPickerIcon", true);
        return result == null ? false : result;
    }
    

    /**
     * If a hint is defined for this form item, should it be shown?
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showHint New showHint value. Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setShowHint(Boolean showHint) {
        setAttribute("showHint", showHint);
    }

    /**
     * If a hint is defined for this form item, should it be shown?
     *
     * @return Current showHint value. Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowHint()  {
        Boolean result = getAttributeAsBoolean("showHint", true);
        return result == null ? true : result;
    }
    

    /**
     * Set to false to suppress writing out any {@link com.smartgwt.client.widgets.form.fields.FormItem#getIcons icons} for
     * this item.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showIcons New showIcons value. Default value is true
     */
    public void setShowIcons(Boolean showIcons) {
        setAttribute("showIcons", showIcons);
    }

    /**
     * Set to false to suppress writing out any {@link com.smartgwt.client.widgets.form.fields.FormItem#getIcons icons} for
     * this item.
     *
     * @return Current showIcons value. Default value is true
     */
    public Boolean getShowIcons()  {
        Boolean result = getAttributeAsBoolean("showIcons", true);
        return result == null ? true : result;
    }
    

    /**
     * Show the {@link com.smartgwt.client.widgets.form.fields.FormItem#getIcons icons} when the item gets focus, and hide them
     * when it loses focus. Can be overridden at the icon level by {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getShowOnFocus FormItemIcon.showOnFocus}. <P> Note that icons
     * marked as disabled will not be shown on focus even if this flag is true by default. This may be overridden by {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowDisabledIconsOnFocus showDisabledIconsOnFocus}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowIconsOnFocus showIconsOnFocus} and causes the visibility of all {@link com.smartgwt.client.widgets.form.fields.FormItem#getIcons icons} to be updated and the item redrawn as appropriate.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showIconsOnFocus new value of {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowIconsOnFocus showIconsOnFocus}. Default value is null
     */
    public void setShowIconsOnFocus(Boolean showIconsOnFocus) {
        setAttribute("showIconsOnFocus", showIconsOnFocus);
    }

    /**
     * Show the {@link com.smartgwt.client.widgets.form.fields.FormItem#getIcons icons} when the item gets focus, and hide them
     * when it loses focus. Can be overridden at the icon level by {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getShowOnFocus FormItemIcon.showOnFocus}. <P> Note that icons
     * marked as disabled will not be shown on focus even if this flag is true by default. This may be overridden by {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowDisabledIconsOnFocus showDisabledIconsOnFocus}.
     *
     * @return Current showIconsOnFocus value. Default value is null
     */
    public Boolean getShowIconsOnFocus()  {
        return getAttributeAsBoolean("showIconsOnFocus", true);
    }
    

    /**
     * Causes the original value to be shown to the end user when the user hovers over the FormItem as such (when the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#addItemHoverHandler FormItem.itemHover()} event would fire). <p> When
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowOldValueInHover showOldValueInHover} and the form's
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getShowOldValueInHover DynamicForm.showOldValueInHover} are both
     * unset, defaults to the value of {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPending showPending}. <p>
     * The message shown is controlled by {@link com.smartgwt.client.widgets.form.fields.FormItem#getOriginalValueMessage
     * originalValueMessage}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showOldValueInHover New showOldValueInHover value. Default value is null
     */
    public void setShowOldValueInHover(Boolean showOldValueInHover) {
        setAttribute("showOldValueInHover", showOldValueInHover);
    }

    /**
     * Causes the original value to be shown to the end user when the user hovers over the FormItem as such (when the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#addItemHoverHandler FormItem.itemHover()} event would fire). <p> When
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowOldValueInHover showOldValueInHover} and the form's
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getShowOldValueInHover DynamicForm.showOldValueInHover} are both
     * unset, defaults to the value of {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPending showPending}. <p>
     * The message shown is controlled by {@link com.smartgwt.client.widgets.form.fields.FormItem#getOriginalValueMessage
     * originalValueMessage}.
     *
     * @return Current showOldValueInHover value. Default value is null
     */
    public Boolean getShowOldValueInHover()  {
        return getAttributeAsBoolean("showOldValueInHover", true);
    }
    

    /**
     * When the user rolls over this item, should it be re-styled to indicate it has focus? <P> When enabled, the "Over"
     * styling is applied to the text box, control table (if present), and pickerIcon (if present), and any icons where {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getShowOver FormItemIcon.showOver} is true and {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getShowOverWhen FormItemIcon.showOverWhen} is set to "textBox".<br>
     * These behaviors can be disabled piecemeal via {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getUpdateTextBoxOnOver updateTextBoxOnOver},  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getUpdateControlOnOver updateControlOnOver} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getUpdatePickerIconOnOver updatePickerIconOnOver} properties. <P>
     * Developers may also show rollover styling for other icons (see  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowOverIcons showOverIcons} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getShowOverWhen FormItemIcon.showOverWhen}). <P> See {@link
     * com.smartgwt.client.docs.FormItemStyling} for more details on formItem styling.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showOver New showOver value. Default value is false
     * @see com.smartgwt.client.docs.FormItemStyling FormItemStyling overview and related methods
     */
    public void setShowOver(boolean showOver) {
        setAttribute("showOver", showOver);
    }

    /**
     * When the user rolls over this item, should it be re-styled to indicate it has focus? <P> When enabled, the "Over"
     * styling is applied to the text box, control table (if present), and pickerIcon (if present), and any icons where {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getShowOver FormItemIcon.showOver} is true and {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getShowOverWhen FormItemIcon.showOverWhen} is set to "textBox".<br>
     * These behaviors can be disabled piecemeal via {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getUpdateTextBoxOnOver updateTextBoxOnOver},  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getUpdateControlOnOver updateControlOnOver} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getUpdatePickerIconOnOver updatePickerIconOnOver} properties. <P>
     * Developers may also show rollover styling for other icons (see  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowOverIcons showOverIcons} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getShowOverWhen FormItemIcon.showOverWhen}). <P> See {@link
     * com.smartgwt.client.docs.FormItemStyling} for more details on formItem styling.
     *
     * @return Current showOver value. Default value is false
     * @see com.smartgwt.client.docs.FormItemStyling FormItemStyling overview and related methods
     */
    public boolean getShowOver()  {
        Boolean result = getAttributeAsBoolean("showOver", true);
        return result == null ? false : result;
    }
    

    /**
     * If we're showing icons, should we change their image source to the appropriate <i>over</i>  source when the user rolls
     * over (or puts focus onto) them?  Can be overridden on a per  icon basis by the formItemIcon <code>showOver</code>
     * property.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showOverIcons New showOverIcons value. Default value is null
     */
    public void setShowOverIcons(Boolean showOverIcons) {
        setAttribute("showOverIcons", showOverIcons);
    }

    /**
     * If we're showing icons, should we change their image source to the appropriate <i>over</i>  source when the user rolls
     * over (or puts focus onto) them?  Can be overridden on a per  icon basis by the formItemIcon <code>showOver</code>
     * property.
     *
     * @return Current showOverIcons value. Default value is null
     */
    public Boolean getShowOverIcons()  {
        return getAttributeAsBoolean("showOverIcons", true);
    }
    

    /**
     * When <code>true</code>, causes the "Pending" optional suffix to be added if the item's current value differs from the
     * value that would be restored by a call to {@link com.smartgwt.client.widgets.form.DynamicForm#resetValues
     * DynamicForm.resetValues()}. <p> {@link com.smartgwt.client.widgets.form.fields.FormItem#getShouldSaveValue
     * shouldSaveValue} must be <code>true</code> for this setting to have an effect. <p> Styling of the value is updated only
     * after the {@link com.smartgwt.client.widgets.form.fields.FormItem#addChangeHandler FormItem.change()} event is
     * processed, so depending on the value of {@link com.smartgwt.client.widgets.form.fields.FormItem#getChangeOnKeypress
     * changeOnKeypress}, styling may be updated immediately on keystroke or only when the user leaves the field. <p> Default
     * styling is provided for the Enterprise, EnterpriseBlue, and Graphite skins only. <code>showPending</code> should not be
     * enabled for an item when using a skin without default styling unless the default {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#addPendingStatusChangedHandler FormItem.pendingStatusChanged()}
     * behavior is canceled and a custom pending visual state is implemented by the item. <p> <strong>NOTE:</strong> Whether an
     * item is shown as pending is not reflected to screen readers. Therefore, it is not advisable to design a UI where it is
     * necessary for the user to know whether an item is shown as pending in order to work with the form.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showPending New showPending value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.events.PendingStatusChangedEvent
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_pending_values" target="examples">Pending Values Example</a>
     */
    public void setShowPending(Boolean showPending) {
        setAttribute("showPending", showPending);
    }

    /**
     * When <code>true</code>, causes the "Pending" optional suffix to be added if the item's current value differs from the
     * value that would be restored by a call to {@link com.smartgwt.client.widgets.form.DynamicForm#resetValues
     * DynamicForm.resetValues()}. <p> {@link com.smartgwt.client.widgets.form.fields.FormItem#getShouldSaveValue
     * shouldSaveValue} must be <code>true</code> for this setting to have an effect. <p> Styling of the value is updated only
     * after the {@link com.smartgwt.client.widgets.form.fields.FormItem#addChangeHandler FormItem.change()} event is
     * processed, so depending on the value of {@link com.smartgwt.client.widgets.form.fields.FormItem#getChangeOnKeypress
     * changeOnKeypress}, styling may be updated immediately on keystroke or only when the user leaves the field. <p> Default
     * styling is provided for the Enterprise, EnterpriseBlue, and Graphite skins only. <code>showPending</code> should not be
     * enabled for an item when using a skin without default styling unless the default {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#addPendingStatusChangedHandler FormItem.pendingStatusChanged()}
     * behavior is canceled and a custom pending visual state is implemented by the item. <p> <strong>NOTE:</strong> Whether an
     * item is shown as pending is not reflected to screen readers. Therefore, it is not advisable to design a UI where it is
     * necessary for the user to know whether an item is shown as pending in order to work with the form.
     *
     * @return Current showPending value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.events.PendingStatusChangedEvent
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_pending_values" target="examples">Pending Values Example</a>
     */
    public Boolean getShowPending()  {
        return getAttributeAsBoolean("showPending", true);
    }
    

    /**
     * Should we show a special 'picker' {@link com.smartgwt.client.widgets.form.fields.FormItemIcon icon} for this form item?
     * Picker icons are customizable via {@link com.smartgwt.client.widgets.form.fields.FormItem#getPickerIconProperties
     * pickerIconProperties}. By default they will be rendered inside the form item's {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getControlStyle "control box"} area. By default clicking the pickerIcon
     * will call {@link com.smartgwt.client.widgets.form.fields.FormItem#showPicker showPicker()}.
     *
     * @param showPickerIcon New showPickerIcon value. Default value is null
     */
    public void setShowPickerIcon(Boolean showPickerIcon) {
        setAttribute("showPickerIcon", showPickerIcon);
    }

    /**
     * Should we show a special 'picker' {@link com.smartgwt.client.widgets.form.fields.FormItemIcon icon} for this form item?
     * Picker icons are customizable via {@link com.smartgwt.client.widgets.form.fields.FormItem#getPickerIconProperties
     * pickerIconProperties}. By default they will be rendered inside the form item's {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getControlStyle "control box"} area. By default clicking the pickerIcon
     * will call {@link com.smartgwt.client.widgets.form.fields.FormItem#showPicker showPicker()}.
     *
     * @return Current showPickerIcon value. Default value is null
     */
    public Boolean getShowPickerIcon()  {
        return getAttributeAsBoolean("showPickerIcon", true);
    }
    

    /**
     * Show the picker icon when the item gets focus, and hide it when it loses focus.  Can be overridden at the icon level by
     * {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getShowOnFocus FormItemIcon.showOnFocus}. <P> Note that a
     * pickerIcon marked as disabled will not be shown on focus even if this flag is true by default. This may be overridden by
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowDisabledIconsOnFocus showDisabledIconsOnFocus}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIconOnFocus showPickerIconOnFocus} and causes the visibility of the picker icon to be updated and the item redrawn as appropriate.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showPickerIconOnFocus new value of {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIconOnFocus showPickerIconOnFocus}. Default value is null
     */
    public void setShowPickerIconOnFocus(Boolean showPickerIconOnFocus) {
        setAttribute("showPickerIconOnFocus", showPickerIconOnFocus);
    }

    /**
     * Show the picker icon when the item gets focus, and hide it when it loses focus.  Can be overridden at the icon level by
     * {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getShowOnFocus FormItemIcon.showOnFocus}. <P> Note that a
     * pickerIcon marked as disabled will not be shown on focus even if this flag is true by default. This may be overridden by
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowDisabledIconsOnFocus showDisabledIconsOnFocus}.
     *
     * @return Current showPickerIconOnFocus value. Default value is null
     */
    public Boolean getShowPickerIconOnFocus()  {
        return getAttributeAsBoolean("showPickerIconOnFocus", true);
    }
    

    /**
     * When this item is in RTL mode, should its style name include an "RTL" suffix?
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showRTL New showRTL value. Default value is false
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setCellStyle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setShowRTL(boolean showRTL) {
        setAttribute("showRTL", showRTL);
    }

    /**
     * When this item is in RTL mode, should its style name include an "RTL" suffix?
     *
     * @return Current showRTL value. Default value is false
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getCellStyle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public boolean getShowRTL()  {
        Boolean result = getAttributeAsBoolean("showRTL", true);
        return result == null ? false : result;
    }
    

    /**
     * Should we show a title cell for this formItem? <p> Note: the default value of this attribute is overridden by some
     * subclasses.
     *
     * @param showTitle New showTitle value. Default value is true
     */
    public void setShowTitle(Boolean showTitle) {
        setAttribute("showTitle", showTitle);
    }

    /**
     * Should we show a title cell for this formItem? <p> Note: the default value of this attribute is overridden by some
     * subclasses.
     *
     * @return Current showTitle value. Default value is true
     */
    public Boolean getShowTitle()  {
        Boolean result = getAttributeAsBoolean("showTitle", true);
        return result == null ? true : result;
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons} is set, this property may be set to
     * show the valueIcon only and prevent the standard form item element or text from displaying
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showValueIconOnly New showValueIconOnly value. Default value is null
     */
    public void setShowValueIconOnly(Boolean showValueIconOnly) {
        setAttribute("showValueIconOnly", showValueIconOnly);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons} is set, this property may be set to
     * show the valueIcon only and prevent the standard form item element or text from displaying
     *
     * @return Current showValueIconOnly value. Default value is null
     */
    public Boolean getShowValueIconOnly()  {
        return getAttributeAsBoolean("showValueIconOnly", true);
    }
    

    /**
     * Whether this item should always start a new row in the form layout.
     *
     * @param startRow New startRow value. Default value is false
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public void setStartRow(Boolean startRow) {
        setAttribute("startRow", startRow);
    }

    /**
     * Whether this item should always start a new row in the form layout.
     *
     * @return Current startRow value. Default value is false
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public Boolean getStartRow()  {
        Boolean result = getAttributeAsBoolean("startRow", true);
        return result == null ? false : result;
    }
    

    /**
     * Height of the FormItem when <code>canEdit</code> is false and <code>readOnlyDisplay</code> is "static". The normal
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getHeight height} is used if this property is not set.
     *
     * @param staticHeight New staticHeight value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setHeight
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public void setStaticHeight(Integer staticHeight) {
        setAttribute("staticHeight", staticHeight);
    }

    /**
     * Height of the FormItem when <code>canEdit</code> is false and <code>readOnlyDisplay</code> is "static". The normal
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getHeight height} is used if this property is not set.
     *
     * @return Current staticHeight value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getHeight
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public Integer getStaticHeight()  {
        return getAttributeAsInt("staticHeight");
    }
    

    /**
     * Indicates that if validation fails, the user should not be allowed to exit the field - focus will be forced back into
     * the field until the error is corrected. <p> This property defaults to {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getStopOnError DynamicForm.stopOnError} if unset. <p> Enabling this
     * property also implies {@link com.smartgwt.client.widgets.form.fields.FormItem#getValidateOnExit validateOnExit} is
     * automatically enabled. If there are server-based validators on this item, setting this property also implies that {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getSynchronousValidation synchronousValidation} is forced on.
     *
     * @param stopOnError New stopOnError value. Default value is null
     */
    public void setStopOnError(Boolean stopOnError) {
        setAttribute("stopOnError", stopOnError);
    }

    /**
     * Indicates that if validation fails, the user should not be allowed to exit the field - focus will be forced back into
     * the field until the error is corrected. <p> This property defaults to {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getStopOnError DynamicForm.stopOnError} if unset. <p> Enabling this
     * property also implies {@link com.smartgwt.client.widgets.form.fields.FormItem#getValidateOnExit validateOnExit} is
     * automatically enabled. If there are server-based validators on this item, setting this property also implies that {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getSynchronousValidation synchronousValidation} is forced on.
     *
     * @return Current stopOnError value. Default value is null
     */
    public Boolean getStopOnError()  {
        return getAttributeAsBoolean("stopOnError", true);
    }
    

    /**
     * If specified, this overrides the {@link com.smartgwt.client.widgets.form.DynamicForm#getStoreDisplayValues
     * DynamicForm.storeDisplayValues} property for this field.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param storeDisplayValues New storeDisplayValues value. Default value is null
     */
    public void setStoreDisplayValues(Boolean storeDisplayValues) {
        setAttribute("storeDisplayValues", storeDisplayValues);
    }

    /**
     * If specified, this overrides the {@link com.smartgwt.client.widgets.form.DynamicForm#getStoreDisplayValues
     * DynamicForm.storeDisplayValues} property for this field.
     *
     * @return Current storeDisplayValues value. Default value is null
     */
    public Boolean getStoreDisplayValues()  {
        return getAttributeAsBoolean("storeDisplayValues", true);
    }
    

    /**
     * Does the current formItem support native cut and paste events? <P> This attribute only applies to freeform text entry
     * fields such as {@link com.smartgwt.client.widgets.form.fields.TextItem} and {@link
     * com.smartgwt.client.widgets.form.fields.TextAreaItem}, and only if {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getChangeOnKeypress changeOnKeypress} is true.  If true, developers can
     * detect the user editing the value  via cut or paste interactions (triggered from keyboard shortcuts or the native 
     * browser menu options) using the {@link com.smartgwt.client.widgets.form.fields.FormItem#isCutEvent isCutEvent()} and
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#isPasteEvent isPasteEvent()} methods. This allows custom
     * cut/paste handling to be added to the various change notification flow methods including  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#addChangeHandler FormItem.change()}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#handleChange handleChange()} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setInputTransformer FormItem.transformInput()}.
     *
     * @param supportsCutPasteEvents New supportsCutPasteEvents value. Default value is false
     */
    public void setSupportsCutPasteEvents(boolean supportsCutPasteEvents) {
        setAttribute("supportsCutPasteEvents", supportsCutPasteEvents);
    }

    /**
     * Does the current formItem support native cut and paste events? <P> This attribute only applies to freeform text entry
     * fields such as {@link com.smartgwt.client.widgets.form.fields.TextItem} and {@link
     * com.smartgwt.client.widgets.form.fields.TextAreaItem}, and only if {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getChangeOnKeypress changeOnKeypress} is true.  If true, developers can
     * detect the user editing the value  via cut or paste interactions (triggered from keyboard shortcuts or the native 
     * browser menu options) using the {@link com.smartgwt.client.widgets.form.fields.FormItem#isCutEvent isCutEvent()} and
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#isPasteEvent isPasteEvent()} methods. This allows custom
     * cut/paste handling to be added to the various change notification flow methods including  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#addChangeHandler FormItem.change()}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#handleChange handleChange()} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setInputTransformer FormItem.transformInput()}.
     *
     * @return Current supportsCutPasteEvents value. Default value is false
     */
    public boolean getSupportsCutPasteEvents()  {
        Boolean result = getAttributeAsBoolean("supportsCutPasteEvents", true);
        return result == null ? false : result;
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons} is set, this property may be set to
     * prevent the value icons from showing up next to the form items value
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param suppressValueIcon New suppressValueIcon value. Default value is null
     */
    public void setSuppressValueIcon(Boolean suppressValueIcon) {
        setAttribute("suppressValueIcon", suppressValueIcon);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons} is set, this property may be set to
     * prevent the value icons from showing up next to the form items value
     *
     * @return Current suppressValueIcon value. Default value is null
     */
    public Boolean getSuppressValueIcon()  {
        return getAttributeAsBoolean("suppressValueIcon", true);
    }
    

    /**
     * If enabled, whenever validation is triggered and a request to the server is required, user interactivity will be blocked
     * until the request returns. Can be set for the entire form or individual FormItems. <p> If false, the form will try to
     * avoid blocking user interaction until it is strictly required. That is until the user attempts to use a FormItem whose
     * state could be affected by a server request that has not yet returned.
     *
     * @param synchronousValidation New synchronousValidation value. Default value is null
     */
    public void setSynchronousValidation(Boolean synchronousValidation) {
        setAttribute("synchronousValidation", synchronousValidation);
    }

    /**
     * If enabled, whenever validation is triggered and a request to the server is required, user interactivity will be blocked
     * until the request returns. Can be set for the entire form or individual FormItems. <p> If false, the form will try to
     * avoid blocking user interaction until it is strictly required. That is until the user attempts to use a FormItem whose
     * state could be affected by a server request that has not yet returned.
     *
     * @return Current synchronousValidation value. Default value is null
     */
    public Boolean getSynchronousValidation()  {
        return getAttributeAsBoolean("synchronousValidation", true);
    }
    

    /**
     * TabIndex for the form item within the form, which controls the order in which controls are visited when the user hits
     * the tab or shift-tab keys to navigate between items.  <P> tabIndex is automatically assigned as the order that items
     * appear in the {@link com.smartgwt.client.widgets.form.DynamicForm#getItems DynamicForm.items} list. <P> To specify the
     * tabindex of an item within the page as a whole (not just this form), use {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getGlobalTabIndex globalTabIndex} instead.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.form.fields.FormItem#getTabIndex tabIndex}.
     *
     * @param tabIndex new tabIndex for the item. Default value is null
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public void setTabIndex(Integer tabIndex) {
        setAttribute("tabIndex", tabIndex);
    }

    /**
     * TabIndex for the form item within the form, which controls the order in which controls are visited when the user hits
     * the tab or shift-tab keys to navigate between items.  <P> tabIndex is automatically assigned as the order that items
     * appear in the {@link com.smartgwt.client.widgets.form.DynamicForm#getItems DynamicForm.items} list. <P> To specify the
     * tabindex of an item within the page as a whole (not just this form), use {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getGlobalTabIndex globalTabIndex} instead.
     *
     * @return Current tabIndex value. Default value is null
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public Integer getTabIndex()  {
        return getAttributeAsInt("tabIndex");
    }
    

    /**
     * Alignment of the text / content within this form item. Note that {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getAlign align} may be used to control alignment of the entire form
     * item within its cell. <code>textAlign</code> does not apply to all form item types; typically it applies only to items
     * showing a "textBox", such as a {@link com.smartgwt.client.widgets.form.fields.TextItem} or {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem}, as well as text-only form item types such as {@link
     * com.smartgwt.client.widgets.form.fields.StaticTextItem} and {@link com.smartgwt.client.widgets.form.fields.HeaderItem}.
     * <p> If {@link com.smartgwt.client.widgets.form.fields.FormItem#getApplyAlignToText applyAlignToText} is true, then
     * <code>textAlign</code> will default to the <code>align</code> setting if set. Otherwise, if this item has {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getIcons icons}, then <code>textAlign</code> will default to  {@link
     * com.smartgwt.client.types.Alignment#LEFT}  ({@link com.smartgwt.client.types.Alignment#RIGHT} in {@link
     * com.smartgwt.client.util.Page#isRTL RTL mode}).
     *
     * @param textAlign New textAlign value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setApplyAlignToText
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setTextAlign(Alignment textAlign) {
        setAttribute("textAlign", textAlign == null ? null : textAlign.getValue());
    }

    /**
     * Alignment of the text / content within this form item. Note that {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getAlign align} may be used to control alignment of the entire form
     * item within its cell. <code>textAlign</code> does not apply to all form item types; typically it applies only to items
     * showing a "textBox", such as a {@link com.smartgwt.client.widgets.form.fields.TextItem} or {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem}, as well as text-only form item types such as {@link
     * com.smartgwt.client.widgets.form.fields.StaticTextItem} and {@link com.smartgwt.client.widgets.form.fields.HeaderItem}.
     * <p> If {@link com.smartgwt.client.widgets.form.fields.FormItem#getApplyAlignToText applyAlignToText} is true, then
     * <code>textAlign</code> will default to the <code>align</code> setting if set. Otherwise, if this item has {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getIcons icons}, then <code>textAlign</code> will default to  {@link
     * com.smartgwt.client.types.Alignment#LEFT}  ({@link com.smartgwt.client.types.Alignment#RIGHT} in {@link
     * com.smartgwt.client.util.Page#isRTL RTL mode}).
     *
     * @return Current textAlign value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getApplyAlignToText
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Alignment getTextAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("textAlign"));
    }
    

    /**
     * Base CSS class name for a form item's text box element. <p> See {@link com.smartgwt.client.docs.FormItemStyling} for an
     * overview of formItem styling, and  the {@link com.smartgwt.client.docs.CompoundFormItem_skinning} discussion for special
     * skinning considerations. <p> If the <code>textBoxStyle</code> is changed at runtime, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#updateState updateState()} must be called to update the visual state of
     * this item.
     *
     * @param textBoxStyle New textBoxStyle value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setCellStyle
     * @see com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle 
     * @see com.smartgwt.client.docs.FormItemStyling FormItemStyling overview and related methods
     */
    public void setTextBoxStyle(String textBoxStyle) {
        setAttribute("textBoxStyle", textBoxStyle);
    }

    /**
     * Base CSS class name for a form item's text box element. <p> See {@link com.smartgwt.client.docs.FormItemStyling} for an
     * overview of formItem styling, and  the {@link com.smartgwt.client.docs.CompoundFormItem_skinning} discussion for special
     * skinning considerations. <p> If the <code>textBoxStyle</code> is changed at runtime, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#updateState updateState()} must be called to update the visual state of
     * this item.
     *
     * @return Current textBoxStyle value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getCellStyle
     * @see com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle 
     * @see com.smartgwt.client.docs.FormItemStyling FormItemStyling overview and related methods
     */
    public String getTextBoxStyle()  {
        return getAttributeAsString("textBoxStyle");
    }
    

    /**
     * Formula to be used to calculate the text value of this FormItem. For a numeric field {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getFormula formula} is used instead. <p>  Available fields for use in
     * the formula are the current {@link com.smartgwt.client.widgets.Canvas#getRuleScope rule context}. The formula is
     * re-evaluated every time the rule context changes. <p> See {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getFormula formula} for details on available fields for the formula and
     * when the formula is calculated. <p> Note: A FormItem using a textFormula must have a {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getName name} defined. {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShouldSaveValue shouldSaveValue} can be set to <code>false</code> to
     * prevent the formula field from storing the calculated value into the form's values.
     *
     * @param textFormula New textFormula value. Default value is null
     * @see com.smartgwt.client.docs.FormulaFields FormulaFields overview and related methods
     */
    public void setTextFormula(UserSummary textFormula) {
        setAttribute("textFormula", textFormula == null ? null : textFormula.getJsObj());
    }

    /**
     * Formula to be used to calculate the text value of this FormItem. For a numeric field {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getFormula formula} is used instead. <p>  Available fields for use in
     * the formula are the current {@link com.smartgwt.client.widgets.Canvas#getRuleScope rule context}. The formula is
     * re-evaluated every time the rule context changes. <p> See {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getFormula formula} for details on available fields for the formula and
     * when the formula is calculated. <p> Note: A FormItem using a textFormula must have a {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getName name} defined. {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShouldSaveValue shouldSaveValue} can be set to <code>false</code> to
     * prevent the formula field from storing the calculated value into the form's values.
     *
     * @return Current textFormula value. Default value is null
     * @see com.smartgwt.client.docs.FormulaFields FormulaFields overview and related methods
     */
    public UserSummary getTextFormula()  {
        return new UserSummary(getAttributeAsJavaScriptObject("textFormula"));
    }
    

    /**
     * Time-format to apply to date type values within this formItem.  If specified, any dates displayed in this item will be
     * formatted as times using the appropriate format. This is most commonly only applied to fields specified as type
     * <code>"time"</code> though if no explicit {@link com.smartgwt.client.widgets.form.fields.FormItem#getDateFormatter
     * dateFormatter} is specified it will be respected for other  fields as well. <P> If unspecified, a timeFormatter may be
     * defined  {@link com.smartgwt.client.widgets.form.DynamicForm#getTimeFormatter at the component level} and will be
     * respected by fields of type <code>"time"</code>.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param timeFormatter New timeFormatter value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setFormat
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setTimeFormatter(TimeDisplayFormat timeFormatter) {
        setAttribute("timeFormatter", timeFormatter == null ? null : timeFormatter.getValue());
    }

    /**
     * Time-format to apply to date type values within this formItem.  If specified, any dates displayed in this item will be
     * formatted as times using the appropriate format. This is most commonly only applied to fields specified as type
     * <code>"time"</code> though if no explicit {@link com.smartgwt.client.widgets.form.fields.FormItem#getDateFormatter
     * dateFormatter} is specified it will be respected for other  fields as well. <P> If unspecified, a timeFormatter may be
     * defined  {@link com.smartgwt.client.widgets.form.DynamicForm#getTimeFormatter at the component level} and will be
     * respected by fields of type <code>"time"</code>.
     *
     * @return Current timeFormatter value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getFormat
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public TimeDisplayFormat getTimeFormatter()  {
        return EnumUtil.getEnum(TimeDisplayFormat.values(), getAttribute("timeFormatter"));
    }
    

    /**
     * User visible title for this form item.
     *
     * @param title New title value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public void setTitle(String title) {
        setAttribute("title", title);
    }

    /**
     * User visible title for this form item.
     *
     * @return Returns the title HTML for this item. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }
    

    /**
     * Alignment of this item's title in its cell. <p> If null, dynamically set according to text direction.
     *
     * @param titleAlign New titleAlign value. Default value is null
     */
    public void setTitleAlign(Alignment titleAlign) {
        setAttribute("titleAlign", titleAlign == null ? null : titleAlign.getValue());
    }

    /**
     * Alignment of this item's title in its cell. <p> If null, dynamically set according to text direction.
     *
     * @return Current titleAlign value. Default value is null
     */
    public Alignment getTitleAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("titleAlign"));
    }
    
    

    /**
     * Number of columns that this item's title spans.   <P> This setting only applies for items that are showing a title and
     * whose {@link com.smartgwt.client.types.TitleOrientation} is either "left" or "right".
     *
     * @param titleColSpan New titleColSpan value. Default value is 1
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public void setTitleColSpan(int titleColSpan) {
        setAttribute("titleColSpan", titleColSpan);
    }

    /**
     * Number of columns that this item's title spans.   <P> This setting only applies for items that are showing a title and
     * whose {@link com.smartgwt.client.types.TitleOrientation} is either "left" or "right".
     *
     * @return Current titleColSpan value. Default value is 1
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public int getTitleColSpan()  {
        return getAttributeAsInt("titleColSpan");
    }
    
    

    /**
     * On which side of this item should the title be placed.  {@link com.smartgwt.client.types.TitleOrientation} lists valid
     * options. <P> Note that titles on the left or right take up a cell in tabular {@link com.smartgwt.client.docs.FormLayout
     * form layouts}, but titles on top do not.
     *
     * @param titleOrientation New titleOrientation value. Default value is Canvas.LEFT
     * @see com.smartgwt.client.widgets.form.DynamicForm#setTitleOrientation
     */
    public void setTitleOrientation(TitleOrientation titleOrientation) {
        setAttribute("titleOrientation", titleOrientation == null ? null : titleOrientation.getValue());
    }

    /**
     * On which side of this item should the title be placed.  {@link com.smartgwt.client.types.TitleOrientation} lists valid
     * options. <P> Note that titles on the left or right take up a cell in tabular {@link com.smartgwt.client.docs.FormLayout
     * form layouts}, but titles on top do not.
     *
     * @return Current titleOrientation value. Default value is Canvas.LEFT
     * @see com.smartgwt.client.widgets.form.DynamicForm#getTitleOrientation
     */
    public TitleOrientation getTitleOrientation()  {
        return EnumUtil.getEnum(TitleOrientation.values(), getAttribute("titleOrientation"));
    }
    

    /**
     * Base CSS class name for a form item's title. Note that this is a {@link com.smartgwt.client.docs.FormItemBaseStyle} so
     * will pick up stateful suffixes on focus, disabled state change etc. by default. <p> Note the appearance of the title is
     * also affected by {@link com.smartgwt.client.widgets.form.DynamicForm#getTitlePrefix DynamicForm.titlePrefix}/{@link
     * com.smartgwt.client.widgets.form.DynamicForm#getTitleSuffix titleSuffix} and  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getRequiredTitlePrefix DynamicForm.requiredTitlePrefix}/{@link
     * com.smartgwt.client.widgets.form.DynamicForm#getRequiredTitleSuffix requiredTitleSuffix}.
     *
     * @param titleStyle New titleStyle value. Default value is "formTitle"
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setCellStyle
     * @see com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle 
     */
    public void setTitleStyle(String titleStyle) {
        setAttribute("titleStyle", titleStyle);
    }

    /**
     * Base CSS class name for a form item's title. Note that this is a {@link com.smartgwt.client.docs.FormItemBaseStyle} so
     * will pick up stateful suffixes on focus, disabled state change etc. by default. <p> Note the appearance of the title is
     * also affected by {@link com.smartgwt.client.widgets.form.DynamicForm#getTitlePrefix DynamicForm.titlePrefix}/{@link
     * com.smartgwt.client.widgets.form.DynamicForm#getTitleSuffix titleSuffix} and  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getRequiredTitlePrefix DynamicForm.requiredTitlePrefix}/{@link
     * com.smartgwt.client.widgets.form.DynamicForm#getRequiredTitleSuffix requiredTitleSuffix}.
     *
     * @return Current titleStyle value. Default value is "formTitle"
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getCellStyle
     * @see com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle 
     */
    public String getTitleStyle()  {
        return getAttributeAsString("titleStyle");
    }
    

    /**
     * Vertical alignment of this item's title in its cell. Only applies when {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTitleOrientation titleOrientation} is <code>"left"</code> or
     * <code>"right"</code>.
     *
     * @param titleVAlign New titleVAlign value. Default value is Canvas.CENTER
     */
    public void setTitleVAlign(VerticalAlignment titleVAlign) {
        setAttribute("titleVAlign", titleVAlign == null ? null : titleVAlign.getValue());
    }

    /**
     * Vertical alignment of this item's title in its cell. Only applies when {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTitleOrientation titleOrientation} is <code>"left"</code> or
     * <code>"right"</code>.
     *
     * @return Current titleVAlign value. Default value is Canvas.CENTER
     */
    public VerticalAlignment getTitleVAlign()  {
        return EnumUtil.getEnum(VerticalAlignment.values(), getAttribute("titleVAlign"));
    }
    

    /**
     * Top coordinate of this item in pixels.  Applies only when the containing DynamicForm sets
     * <code>itemLayout:"absolute"</code>.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * For a form with {@link com.smartgwt.client.widgets.form.DynamicForm#getItemLayout itemLayout}:"absolute" only, set the top coordinate of this form item. <P> Causes the form to redraw.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param top New top value. Default value is 0
     */
    public void setTop(int top) {
        setAttribute("top", top);
    }

    /**
     * Top coordinate of this item in pixels.  Applies only when the containing DynamicForm sets
     * <code>itemLayout:"absolute"</code>.
     *
     * @return Returns the top coordinate of the form item in pixels. Note that this method is only  reliable after the item has been
     * drawn out. Default value is 0
     */
    public int getTop()  {
        return getAttributeAsInt("top");
    }
    
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowOver showOver} is true, setting this property to false
     * will explicitly disable showing the "Over" state for the control table element of this item (if present).
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param updateControlOnOver New updateControlOnOver value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setShowOver
     * @see com.smartgwt.client.docs.FormItemStyling FormItemStyling overview and related methods
     */
    public void setUpdateControlOnOver(Boolean updateControlOnOver) {
        setAttribute("updateControlOnOver", updateControlOnOver);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowOver showOver} is true, setting this property to false
     * will explicitly disable showing the "Over" state for the control table element of this item (if present).
     *
     * @return Current updateControlOnOver value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getShowOver
     * @see com.smartgwt.client.docs.FormItemStyling FormItemStyling overview and related methods
     */
    public Boolean getUpdateControlOnOver()  {
        return getAttributeAsBoolean("updateControlOnOver", true);
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowOver showOver} is true, setting this property to false
     * will explicitly disable showing the "Over" state for the PickerIcon of this item (if present)
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param updatePickerIconOnOver New updatePickerIconOnOver value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setShowOver
     * @see com.smartgwt.client.docs.FormItemStyling FormItemStyling overview and related methods
     */
    public void setUpdatePickerIconOnOver(Boolean updatePickerIconOnOver) {
        setAttribute("updatePickerIconOnOver", updatePickerIconOnOver);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowOver showOver} is true, setting this property to false
     * will explicitly disable showing the "Over" state for the PickerIcon of this item (if present)
     *
     * @return Current updatePickerIconOnOver value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getShowOver
     * @see com.smartgwt.client.docs.FormItemStyling FormItemStyling overview and related methods
     */
    public Boolean getUpdatePickerIconOnOver()  {
        return getAttributeAsBoolean("updatePickerIconOnOver", true);
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowOver showOver} is true, setting this property to false
     * will explicitly disable showing the "Over" state for the TextBox element of this item.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param updateTextBoxOnOver New updateTextBoxOnOver value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setShowOver
     * @see com.smartgwt.client.docs.FormItemStyling FormItemStyling overview and related methods
     */
    public void setUpdateTextBoxOnOver(Boolean updateTextBoxOnOver) {
        setAttribute("updateTextBoxOnOver", updateTextBoxOnOver);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowOver showOver} is true, setting this property to false
     * will explicitly disable showing the "Over" state for the TextBox element of this item.
     *
     * @return Current updateTextBoxOnOver value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getShowOver
     * @see com.smartgwt.client.docs.FormItemStyling FormItemStyling overview and related methods
     */
    public Boolean getUpdateTextBoxOnOver()  {
        return getAttributeAsBoolean("updateTextBoxOnOver", true);
    }
    

    /**
     * Should this form item always produce an {@link com.smartgwt.client.data.AdvancedCriteria} sub criterion object? When set
     * to true, causes {@link com.smartgwt.client.widgets.form.fields.FormItem#hasAdvancedCriteria hasAdvancedCriteria} to 
     * return true.  Can also be set at the {@link com.smartgwt.client.widgets.grid.ListGrid#getUseAdvancedCriteria ListGrid}
     * level.
     *
     * @param useAdvancedCriteria New useAdvancedCriteria value. Default value is null
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public void setUseAdvancedCriteria(Boolean useAdvancedCriteria) {
        setAttribute("useAdvancedCriteria", useAdvancedCriteria);
    }

    /**
     * Should this form item always produce an {@link com.smartgwt.client.data.AdvancedCriteria} sub criterion object? When set
     * to true, causes {@link com.smartgwt.client.widgets.form.fields.FormItem#hasAdvancedCriteria hasAdvancedCriteria} to 
     * return true.  Can also be set at the {@link com.smartgwt.client.widgets.grid.ListGrid#getUseAdvancedCriteria ListGrid}
     * level.
     *
     * @return Current useAdvancedCriteria value. Default value is null
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public Boolean getUseAdvancedCriteria()  {
        return getAttributeAsBoolean("useAdvancedCriteria", true);
    }
    

    /**
     * By default, {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit read-only} fields use the same style name
     * as editable  fields for in-field hints, unless they are {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#isDisabled disabled} or  configured to use a disabled {@link
     * com.smartgwt.client.types.ReadOnlyDisplayAppearance}.  This is described  under {@link
     * com.smartgwt.client.widgets.form.fields.TextItem#getShowHintInField TextItem.showHintInField} <p>  If
     * <code>useDisabledHintStyleForReadOnly</code> is set, the "HintDisabled" style will be  used for read-only fields
     * regardless of their <code>ReadOnlyDisplayAppearance</code>.  This allows you to use a different in-field hint style for
     * read-only fields without having to  use a general disabled appearance for those fields
     *
     * @param useDisabledHintStyleForReadOnly New useDisabledHintStyleForReadOnly value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setUseDisabledHintStyleForReadOnly(Boolean useDisabledHintStyleForReadOnly) {
        setAttribute("useDisabledHintStyleForReadOnly", useDisabledHintStyleForReadOnly);
    }

    /**
     * By default, {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit read-only} fields use the same style name
     * as editable  fields for in-field hints, unless they are {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#isDisabled disabled} or  configured to use a disabled {@link
     * com.smartgwt.client.types.ReadOnlyDisplayAppearance}.  This is described  under {@link
     * com.smartgwt.client.widgets.form.fields.TextItem#getShowHintInField TextItem.showHintInField} <p>  If
     * <code>useDisabledHintStyleForReadOnly</code> is set, the "HintDisabled" style will be  used for read-only fields
     * regardless of their <code>ReadOnlyDisplayAppearance</code>.  This allows you to use a different in-field hint style for
     * read-only fields without having to  use a general disabled appearance for those fields
     *
     * @return Current useDisabledHintStyleForReadOnly value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getUseDisabledHintStyleForReadOnly()  {
        return getAttributeAsBoolean("useDisabledHintStyleForReadOnly", true);
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} is specified for a field,
     * should the display value for the field be picked up from the  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValues record currently being edited}? <P> This behavior is typically
     * valuable for dataBound components where the displayField is specified at the DataSourceField level. See {@link
     * com.smartgwt.client.data.DataSourceField#getDisplayField DataSourceField.displayField} for more on this. <P> Note that
     * for DataSources backed by the {@link com.smartgwt.client.docs.ServerDataIntegration Smart GWT server}, fields with a
     * specified {@link com.smartgwt.client.data.DataSourceField#getForeignKey DataSourceField.foreignKey} and {@link
     * com.smartgwt.client.data.DataSourceField#getDisplayField DataSourceField.displayField} will automatically have this
     * property set to true if not explicitly set to false in the dataSource configuration. <P> Otherwise, if not explicitly
     * set, local display value will be used unless: <ul>  <li>This item has an explicitly specified optionDataSource, rather
     * than      deriving its optionDataSource from a specified       {@link
     * com.smartgwt.client.data.DataSourceField#getForeignKey DataSourceField.foreignKey} specification</li>  <li>The {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getName name} differs from the       {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueFieldName valueField} for the item</li> </ul>
     *
     * @param useLocalDisplayFieldValue New useLocalDisplayFieldValue value. Default value is null
     */
    public void setUseLocalDisplayFieldValue(Boolean useLocalDisplayFieldValue) {
        setAttribute("useLocalDisplayFieldValue", useLocalDisplayFieldValue);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} is specified for a field,
     * should the display value for the field be picked up from the  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValues record currently being edited}? <P> This behavior is typically
     * valuable for dataBound components where the displayField is specified at the DataSourceField level. See {@link
     * com.smartgwt.client.data.DataSourceField#getDisplayField DataSourceField.displayField} for more on this. <P> Note that
     * for DataSources backed by the {@link com.smartgwt.client.docs.ServerDataIntegration Smart GWT server}, fields with a
     * specified {@link com.smartgwt.client.data.DataSourceField#getForeignKey DataSourceField.foreignKey} and {@link
     * com.smartgwt.client.data.DataSourceField#getDisplayField DataSourceField.displayField} will automatically have this
     * property set to true if not explicitly set to false in the dataSource configuration. <P> Otherwise, if not explicitly
     * set, local display value will be used unless: <ul>  <li>This item has an explicitly specified optionDataSource, rather
     * than      deriving its optionDataSource from a specified       {@link
     * com.smartgwt.client.data.DataSourceField#getForeignKey DataSourceField.foreignKey} specification</li>  <li>The {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getName name} differs from the       {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueFieldName valueField} for the item</li> </ul>
     *
     * @return Current useLocalDisplayFieldValue value. Default value is null
     */
    public Boolean getUseLocalDisplayFieldValue()  {
        return getAttributeAsBoolean("useLocalDisplayFieldValue", true);
    }
    

    /**
     * If true, form items will be validated when each item's "change" handler is fired as well as when the entire form is
     * submitted or validated. <p> Note that this property can also be set at the form level or on each validator; If true at
     * the form or field level, validators not explicitly set with <code>validateOnChange:false</code> will be fired on change
     * - displaying errors and rejecting the change on validation failure.
     *
     * @param validateOnChange New validateOnChange value. Default value is false
     * @see com.smartgwt.client.widgets.form.DynamicForm#setValidateOnChange
     */
    public void setValidateOnChange(Boolean validateOnChange) {
        setAttribute("validateOnChange", validateOnChange);
    }

    /**
     * If true, form items will be validated when each item's "change" handler is fired as well as when the entire form is
     * submitted or validated. <p> Note that this property can also be set at the form level or on each validator; If true at
     * the form or field level, validators not explicitly set with <code>validateOnChange:false</code> will be fired on change
     * - displaying errors and rejecting the change on validation failure.
     *
     * @return Current validateOnChange value. Default value is false
     * @see com.smartgwt.client.widgets.form.DynamicForm#getValidateOnChange
     */
    public Boolean getValidateOnChange()  {
        Boolean result = getAttributeAsBoolean("validateOnChange", true);
        return result == null ? false : result;
    }
    

    /**
     * If true, form items will be validated when each item's "editorExit" handler is fired as well as when the entire form is
     * submitted or validated. <p> Note that this property can also be set at the form level. If true at either level the
     * validator will be fired on editorExit.
     *
     * @param validateOnExit New validateOnExit value. Default value is false
     * @see com.smartgwt.client.widgets.form.DynamicForm#setValidateOnExit
     */
    public void setValidateOnExit(Boolean validateOnExit) {
        setAttribute("validateOnExit", validateOnExit);
    }

    /**
     * If true, form items will be validated when each item's "editorExit" handler is fired as well as when the entire form is
     * submitted or validated. <p> Note that this property can also be set at the form level. If true at either level the
     * validator will be fired on editorExit.
     *
     * @return Current validateOnExit value. Default value is false
     * @see com.smartgwt.client.widgets.form.DynamicForm#getValidateOnExit
     */
    public Boolean getValidateOnExit()  {
        Boolean result = getAttributeAsBoolean("validateOnExit", true);
        return result == null ? false : result;
    }
    

    /**
     * Validators for this form item.   <P> <b>Note:</b> these validators will only be run on the client; to do real
     * client-server validation, validators must be specified via {@link com.smartgwt.client.data.DataSourceField#getValidators
     * DataSourceField.validators}.
     *
     * @param validators New validators value. Default value is null
     */
    public void setValidators(Validator... validators) {
        setAttribute("validators", validators);
    }
    

    /**
     * Array of valid filtering operators (eg "greaterThan") that are legal for this FormItem. <P> Applies only to
     * form/formItem when {@link com.smartgwt.client.widgets.form.fields.FormItem#getAllowExpressions allowExpressions} is
     * true, allowing the user to input expressions.
     *
     * @param validOperators New validOperators value. Default value is null
     * @see com.smartgwt.client.docs.AdvancedFilter AdvancedFilter overview and related methods
     */
    public void setValidOperators(OperatorId... validOperators) {
        setAttribute("validOperators", validOperators);
    }

    /**
     * Array of valid filtering operators (eg "greaterThan") that are legal for this FormItem. <P> Applies only to
     * form/formItem when {@link com.smartgwt.client.widgets.form.fields.FormItem#getAllowExpressions allowExpressions} is
     * true, allowing the user to input expressions.
     *
     * @return Current validOperators value. Default value is null
     * @see com.smartgwt.client.docs.AdvancedFilter AdvancedFilter overview and related methods
     */
    public OperatorId[] getValidOperators()  {
        final String[] strings = getAttributeAsStringArray("validOperators");
        return EnumUtil.getEnums(OperatorId.values(), strings, strings == null ? null : new OperatorId[strings.length]);
    }
    

    /**
     * Vertical alignment of this item within its cell. This property governs the position of the item's text box within the
     * cell (not the content within the text box). If {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#shouldApplyHeightToTextBox shouldApplyHeightToTextBox()} is true, for
     * this to have a visible effect, the cell height must exceed the specified height of the item, either due to an explicit
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getCellHeight cellHeight} specification, or due to the row being
     * expanded by another taller item. <P> Has no effect if {@link com.smartgwt.client.widgets.form.DynamicForm#getItemLayout
     * DynamicForm.itemLayout} is set to <code>"absolute"</code> for the form.
     *
     * @param vAlign New vAlign value. Default value is Canvas.CENTER
     */
    public void setVAlign(VerticalAlignment vAlign) {
        setAttribute("vAlign", vAlign == null ? null : vAlign.getValue());
    }

    /**
     * Vertical alignment of this item within its cell. This property governs the position of the item's text box within the
     * cell (not the content within the text box). If {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#shouldApplyHeightToTextBox shouldApplyHeightToTextBox()} is true, for
     * this to have a visible effect, the cell height must exceed the specified height of the item, either due to an explicit
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getCellHeight cellHeight} specification, or due to the row being
     * expanded by another taller item. <P> Has no effect if {@link com.smartgwt.client.widgets.form.DynamicForm#getItemLayout
     * DynamicForm.itemLayout} is set to <code>"absolute"</code> for the form.
     *
     * @return Returns the vertical-alignment for this item within its cell.  By default, when {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTitleOrientation titleOrientation} is "top", this method will 
     * return "top", so that items of varying height are top-aligned, beneath their titles. Default value is Canvas.CENTER
     */
    public VerticalAlignment getVAlign()  {
        return EnumUtil.getEnum(VerticalAlignment.values(), getAttribute("vAlign"));
    }
    
    

    /**
     * Custom CSS text to be applied to values that have been deleted, when {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowDeletions showDeletions} is enabled.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param valueDeselectedCSSText New valueDeselectedCSSText value. Default value is "color:#A8A8A8;text-decoration:line-through;"
     * @see com.smartgwt.client.docs.CSSText CSSText 
     */
    public void setValueDeselectedCSSText(String valueDeselectedCSSText) {
        setAttribute("valueDeselectedCSSText", valueDeselectedCSSText);
    }

    /**
     * Custom CSS text to be applied to values that have been deleted, when {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowDeletions showDeletions} is enabled.
     *
     * @return Current valueDeselectedCSSText value. Default value is "color:#A8A8A8;text-decoration:line-through;"
     * @see com.smartgwt.client.docs.CSSText CSSText 
     */
    public String getValueDeselectedCSSText()  {
        return getAttributeAsString("valueDeselectedCSSText");
    }
    

    /**
     * If this form item maps data values to display values by retrieving the  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} values from an  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource}, this property  denotes the the
     * field to use as the underlying data value in records from the  optionDataSource.<br> If not explicitly supplied, the
     * valueField name will be derived as described in {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueFieldName getValueFieldName()}.
     *
     * @param valueField New valueField value. Default value is null
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public void setValueField(String valueField) {
        setAttribute("valueField", valueField);
    }

    /**
     * If this form item maps data values to display values by retrieving the  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} values from an  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource}, this property  denotes the the
     * field to use as the underlying data value in records from the  optionDataSource.<br> If not explicitly supplied, the
     * valueField name will be derived as described in {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueFieldName getValueFieldName()}.
     *
     * @return Getter method to retrieve the {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueField valueField} for this
     * item. For items with a specified {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * optionDataSource}, this determines which field in that dataSource corresponds to the value for this item. <P> If unset,
     * if a {@link com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey relationship} exists between this field
     * and the optionDataSource, this will be used, otherwise default behavior will return the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getName name} of this field. Default value is null
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public String getValueField()  {
        return getAttributeAsString("valueField");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons} is specified, use this property to
     * specify a height for the value icon written out.
     *
     * @param valueIconHeight New valueIconHeight value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setValueIconWidth
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setValueIconSize
     */
    public void setValueIconHeight(Integer valueIconHeight) {
        setAttribute("valueIconHeight", valueIconHeight);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons} is specified, use this property to
     * specify a height for the value icon written out.
     *
     * @return Current valueIconHeight value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getValueIconWidth
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getValueIconSize
     */
    public Integer getValueIconHeight()  {
        return getAttributeAsInt("valueIconHeight");
    }
    

    /**
     * If we're showing a value icon, this attribute governs the amount of space between the  icon and the start edge of the
     * form item cell. <p> <b>NOTE:</b> In RTL mode, the valueIconLeftPadding is applied to the <em>right</em> of the value
     * icon.
     *
     * @param valueIconLeftPadding New valueIconLeftPadding value. Default value is 0
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setValueIcons
     */
    public void setValueIconLeftPadding(int valueIconLeftPadding) {
        setAttribute("valueIconLeftPadding", valueIconLeftPadding);
    }

    /**
     * If we're showing a value icon, this attribute governs the amount of space between the  icon and the start edge of the
     * form item cell. <p> <b>NOTE:</b> In RTL mode, the valueIconLeftPadding is applied to the <em>right</em> of the value
     * icon.
     *
     * @return Current valueIconLeftPadding value. Default value is 0
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons
     */
    public int getValueIconLeftPadding()  {
        return getAttributeAsInt("valueIconLeftPadding");
    }
    

    /**
     * If we're showing a value icon, this attribute governs the amount of space between the  icon and the value text. <p>
     * <b>NOTE:</b> In RTL mode, the valueIconRightPadding is applied to the <em>left</em> of the value icon.
     *
     * @param valueIconRightPadding New valueIconRightPadding value. Default value is 3
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setValueIcons
     */
    public void setValueIconRightPadding(int valueIconRightPadding) {
        setAttribute("valueIconRightPadding", valueIconRightPadding);
    }

    /**
     * If we're showing a value icon, this attribute governs the amount of space between the  icon and the value text. <p>
     * <b>NOTE:</b> In RTL mode, the valueIconRightPadding is applied to the <em>left</em> of the value icon.
     *
     * @return Current valueIconRightPadding value. Default value is 3
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons
     */
    public int getValueIconRightPadding()  {
        return getAttributeAsInt("valueIconRightPadding");
    }
    
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons} is specified, this property may be
     * used to specify both the width and height of the icon written out. Note that {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueIconWidth valueIconWidth} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueIconHeight valueIconHeight} take precedence over this value, if
     * specified.
     *
     * @param valueIconSize New valueIconSize value. Default value is 16
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setValueIconWidth
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setValueIconHeight
     */
    public void setValueIconSize(int valueIconSize) {
        setAttribute("valueIconSize", valueIconSize);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons} is specified, this property may be
     * used to specify both the width and height of the icon written out. Note that {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueIconWidth valueIconWidth} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueIconHeight valueIconHeight} take precedence over this value, if
     * specified.
     *
     * @return Current valueIconSize value. Default value is 16
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getValueIconWidth
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getValueIconHeight
     */
    public int getValueIconSize()  {
        return getAttributeAsInt("valueIconSize");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons} is specified, use this property to
     * specify a width for the value icon written out.
     *
     * @param valueIconWidth New valueIconWidth value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setValueIconHeight
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setValueIconSize
     */
    public void setValueIconWidth(Integer valueIconWidth) {
        setAttribute("valueIconWidth", valueIconWidth);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons} is specified, use this property to
     * specify a width for the value icon written out.
     *
     * @return Current valueIconWidth value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getValueIconHeight
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getValueIconSize
     */
    public Integer getValueIconWidth()  {
        return getAttributeAsInt("valueIconWidth");
    }
    
    

    /**
     * Whether this item is currently visible. <P> <code>visible</code> can only be set on creation.  After creation, use
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#show show()} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#hide hide()} to manipulate visibility.
     *
     * @param visible New visible value. Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setVisible(Boolean visible) {
        setAttribute("visible", visible);
    }

    /**
     * Whether this item is currently visible. <P> <code>visible</code> can only be set on creation.  After creation, use
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#show show()} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#hide hide()} to manipulate visibility.
     *
     * @return Current visible value. Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getVisible()  {
        Boolean result = getAttributeAsBoolean("visible", true);
        return result == null ? true : result;
    }
    

    /**
     * Criteria to be evaluated to determine whether this FormItem should be visible. <p> Criteria are evaluated against the
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getValues form's current values} as well as  the current {@link
     * com.smartgwt.client.widgets.Canvas#getRuleScope rule context}.  Criteria are re-evaluated every time form values or the
     * rule context changes, whether by end user action or by programmatic calls. <p> If both {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#showIf showIf()} and <code>visibleWhen</code> are specified,
     * <code>visibleWhen</code> is ignored. <P> A basic criteria uses textMatchStyle:"exact". When specified in {@link
     * com.smartgwt.client.docs.ComponentXML Component XML} this property allows {@link
     * com.smartgwt.client.docs.XmlCriteriaShorthand shorthand formats} for defining criteria. <p> Note: A FormItem using
     * visibleWhen must have a {@link com.smartgwt.client.widgets.form.fields.FormItem#getName name} defined. {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShouldSaveValue shouldSaveValue} can be set to <code>false</code> to
     * prevent the field from storing its value into the form's values.
     *
     * @param visibleWhen New visibleWhen value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setVisibleWhen(AdvancedCriteria visibleWhen) {
        if (visibleWhen instanceof Criterion) {
            visibleWhen.setAttribute("_constructor", "AdvancedCriteria");
        }
        setAttribute("visibleWhen", visibleWhen == null ? null : visibleWhen.getJsObj());
    }

    /**
     * Criteria to be evaluated to determine whether this FormItem should be visible. <p> Criteria are evaluated against the
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getValues form's current values} as well as  the current {@link
     * com.smartgwt.client.widgets.Canvas#getRuleScope rule context}.  Criteria are re-evaluated every time form values or the
     * rule context changes, whether by end user action or by programmatic calls. <p> If both {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#showIf showIf()} and <code>visibleWhen</code> are specified,
     * <code>visibleWhen</code> is ignored. <P> A basic criteria uses textMatchStyle:"exact". When specified in {@link
     * com.smartgwt.client.docs.ComponentXML Component XML} this property allows {@link
     * com.smartgwt.client.docs.XmlCriteriaShorthand shorthand formats} for defining criteria. <p> Note: A FormItem using
     * visibleWhen must have a {@link com.smartgwt.client.widgets.form.fields.FormItem#getName name} defined. {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShouldSaveValue shouldSaveValue} can be set to <code>false</code> to
     * prevent the field from storing its value into the form's values.
     *
     * @return Current visibleWhen value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public AdvancedCriteria getVisibleWhen()  {
        return new AdvancedCriteria(getAttributeAsJavaScriptObject("visibleWhen"));
    }
    

    /**
     * Width of the FormItem.  Can be either a number indicating a fixed width in pixels, or "*" indicating the FormItem fills
     * the space allocated to it's column (or columns, for a {@link com.smartgwt.client.widgets.form.fields.FormItem#getColSpan
     * column spanning} item).  You may also use "100%" as a synonym for "*", but other percentages are not supported. <P> Note
     * that for "absolute" item layout rather than the default "table" layout, the rules for specifying the width are slightly
     * different.  All percent sizes are allowed, but not "*".  See {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getItemLayout DynamicForm.itemLayout} for further details. <P> If width is
     * specified as a String, getWidth() will return -1.  Use   getWidthAsString.() in this case.<p> See the {@link
     * com.smartgwt.client.docs.FormLayout} overview for details.
     *
     * @param width New width value. Default value is "*"
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setHeight
     * @see com.smartgwt.client.widgets.form.DynamicForm#setItemLayout
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_form_spanning" target="examples">Spanning Example</a>
     */
    public void setWidth(int width) {
        setAttribute("width", width);
    }

    /**
     * Width of the FormItem.  Can be either a number indicating a fixed width in pixels, or "*" indicating the FormItem fills
     * the space allocated to it's column (or columns, for a {@link com.smartgwt.client.widgets.form.fields.FormItem#getColSpan
     * column spanning} item).  You may also use "100%" as a synonym for "*", but other percentages are not supported. <P> Note
     * that for "absolute" item layout rather than the default "table" layout, the rules for specifying the width are slightly
     * different.  All percent sizes are allowed, but not "*".  See {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getItemLayout DynamicForm.itemLayout} for further details. <P> If width is
     * specified as a String, getWidth() will return -1.  Use   getWidthAsString.() in this case.<p> See the {@link
     * com.smartgwt.client.docs.FormLayout} overview for details.
     *
     * <p><b>Note :</b> This method will return -1 if the underlying SmartClient JavaScript
     * attribute value cannot be expressed as a(n) int.  In that case, other
     * getters,  similarly-named but ending in <code>AsString</code>, <code>AsCanvas</code>,
     * etc., may be provided.
     *
     * @return Output the width for this element. Note this returns the specified width for the   element, which may be "*" or a
     * percentage value. Use 'getVisibleWidth()' to get the  drawn width in pixels. Default value is "*"
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getHeight
     * @see com.smartgwt.client.widgets.form.DynamicForm#getItemLayout
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_form_spanning" target="examples">Spanning Example</a>
     */
    public int getWidth()  {
        if (!(getAttributeAsObject("width") instanceof Integer)) { return -1; }
        return getAttributeAsInt("width");
    }

    /**
     * Width of the FormItem.  Can be either a number indicating a fixed width in pixels, or "*" indicating the FormItem fills
     * the space allocated to it's column (or columns, for a {@link com.smartgwt.client.widgets.form.fields.FormItem#getColSpan
     * column spanning} item).  You may also use "100%" as a synonym for "*", but other percentages are not supported. <P> Note
     * that for "absolute" item layout rather than the default "table" layout, the rules for specifying the width are slightly
     * different.  All percent sizes are allowed, but not "*".  See {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getItemLayout DynamicForm.itemLayout} for further details. <P> If width is
     * specified as a String, getWidth() will return -1.  Use   getWidthAsString.() in this case.<p> See the {@link
     * com.smartgwt.client.docs.FormLayout} overview for details.
     *
     * @param width New width value. Default value is "*"
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setHeight
     * @see com.smartgwt.client.widgets.form.DynamicForm#setItemLayout
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_form_spanning" target="examples">Spanning Example</a>
     */
    public void setWidth(String width) {
        setAttribute("width", width);
    }

    /**
     * Width of the FormItem.  Can be either a number indicating a fixed width in pixels, or "*" indicating the FormItem fills
     * the space allocated to it's column (or columns, for a {@link com.smartgwt.client.widgets.form.fields.FormItem#getColSpan
     * column spanning} item).  You may also use "100%" as a synonym for "*", but other percentages are not supported. <P> Note
     * that for "absolute" item layout rather than the default "table" layout, the rules for specifying the width are slightly
     * different.  All percent sizes are allowed, but not "*".  See {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getItemLayout DynamicForm.itemLayout} for further details. <P> If width is
     * specified as a String, getWidth() will return -1.  Use   getWidthAsString.() in this case.<p> See the {@link
     * com.smartgwt.client.docs.FormLayout} overview for details.
     *
     * @return Output the width for this element. Note this returns the specified width for the   element, which may be "*" or a
     * percentage value. Use 'getVisibleWidth()' to get the  drawn width in pixels. Default value is "*"
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getHeight
     * @see com.smartgwt.client.widgets.form.DynamicForm#getItemLayout
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_form_spanning" target="examples">Spanning Example</a>
     */
    public String getWidthAsString()  {
        return getAttributeAsString("width");
    }
    

    /**
     * If this item is showing a {@link com.smartgwt.client.widgets.form.fields.FormItem#getHint hint}, should the hint text be
     * allowed to wrap? Setting this property to <code>false</code> will render the hint on a single line without wrapping,
     * expanding the width required to render the item if necessary. <P> If unset this property will be picked up from the
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getWrapHintText DynamicForm.wrapHintText} setting. <P> This setting
     * does not apply to hints that are {@link com.smartgwt.client.widgets.form.fields.TextItem#getShowHintInField shown in
     * field}.
     *
     * @param wrapHintText New wrapHintText value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setMinHintWidth
     */
    public void setWrapHintText(Boolean wrapHintText) {
        setAttribute("wrapHintText", wrapHintText);
    }

    /**
     * If this item is showing a {@link com.smartgwt.client.widgets.form.fields.FormItem#getHint hint}, should the hint text be
     * allowed to wrap? Setting this property to <code>false</code> will render the hint on a single line without wrapping,
     * expanding the width required to render the item if necessary. <P> If unset this property will be picked up from the
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getWrapHintText DynamicForm.wrapHintText} setting. <P> This setting
     * does not apply to hints that are {@link com.smartgwt.client.widgets.form.fields.TextItem#getShowHintInField shown in
     * field}.
     *
     * @return Current wrapHintText value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getMinHintWidth
     */
    public Boolean getWrapHintText()  {
        return getAttributeAsBoolean("wrapHintText", true);
    }
    

    /**
     * If specified determines whether this items title should wrap. Overrides {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getWrapItemTitles wrapItemTitles} at the DynamicForm level.
     *
     * @param wrapTitle New wrapTitle value. Default value is null
     */
    public void setWrapTitle(Boolean wrapTitle) {
        setAttribute("wrapTitle", wrapTitle);
    }

    /**
     * If specified determines whether this items title should wrap. Overrides {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getWrapItemTitles wrapItemTitles} at the DynamicForm level.
     *
     * @return Current wrapTitle value. Default value is null
     */
    public Boolean getWrapTitle()  {
        return getAttributeAsBoolean("wrapTitle", true);
    }
    

    // ********************* Methods ***********************
	/**
     * Adds a {@link com.smartgwt.client.widgets.form.fields.FormItemIcon} to this item.  If the optional index parameter is
     * not passed, the icon is added to the end of the existing {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getIcons icon list}. <P> If the passed icon already exists in the
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getIcons icon list}, by  {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getName name}, the original icon is moved to the new index and no
     * new  icon is added.
     * @param icon the icon to add
     *
     * @return the live form item icon
     */
    public native FormItemIcon addIcon(FormItemIcon icon) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.addIcon(icon.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.form.fields.FormItemIcon::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Adds a {@link com.smartgwt.client.widgets.form.fields.FormItemIcon} to this item.  If the optional index parameter is
     * not passed, the icon is added to the end of the existing {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getIcons icon list}. <P> If the passed icon already exists in the
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getIcons icon list}, by  {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getName name}, the original icon is moved to the new index and no
     * new  icon is added.
     * @param icon the icon to add
     * @param index the index to add the icon at - if omitted, add the icon to the end           of the current icon list
     *
     * @return the live form item icon
     */
    public native FormItemIcon addIcon(FormItemIcon icon, int index) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.addIcon(icon.@com.smartgwt.client.core.DataClass::getJsObj()(), index);
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.form.fields.FormItemIcon::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	
	/**
     * Manually sets this FormItem to the result of {@link com.smartgwt.client.widgets.form.fields.FormItem#getFormula formula}
     * or {@link com.smartgwt.client.widgets.form.fields.FormItem#getTextFormula textFormula}. Formulas are normally
     * automatically recomputed and the result automatically applied to the FormItem according to the rules described under
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getFormula formula}. <code>applyFormula()</code> exists to cover
     * any rare cases where these rules are not correct. <p> Calling <code>applyFormula()</code> has no effect if no {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getFormula formula} or  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTextFormula textFormula} is configured for this FormItem.
     */
    public native void applyFormula() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.applyFormula();
    }-*/;

    /**
     * Add a blur handler.
     * <p>
     * Called when this FormItem loses focus.
     *
     * @param handler the blur handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addBlurHandler(com.smartgwt.client.widgets.form.fields.events.BlurHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.BlurEvent.getType()) == 0) setupBlurEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.BlurEvent.getType());
    }

    private native void setupBlurEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var blur = $entry(function(){
            var param = {"_this": this, "form" : arguments[0], "item" : arguments[1]};
            var event = @com.smartgwt.client.widgets.form.fields.events.BlurEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.fields.FormItem::handleTearDownBlurEvent()();
            });
        obj.blur =  blur 
        ;
    }-*/;

    private void handleTearDownBlurEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.fields.events.BlurEvent.getType()) == 0) tearDownBlurEvent();
    }

    private native void tearDownBlurEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (obj && "blur" in obj) delete obj.blur;
    }-*/;

	/**
     * Takes focus from this form item's focusable element.
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public native void blurItem() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.blurItem();
    }-*/;

    /**
     * Add a change handler.
     * <p>
     * Called when a FormItem's value is about to change as the result of user interaction.  This method fires after the user
     * performed an action that would change the value of this field, but before the element itself is changed.   <P> Returning
     * false cancels the change.  Note that if what you want to do is <b>transform</b> the user's input, for example,
     * automatically change separator characters to a standard separator character, you should implement {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setInputTransformer transformInput} rather than using a combination of
     * change() and setValue() to accomplish the same thing.  Returning false from <code>change</code> is intended for
     * rejecting input entirely, such as typing invalid characters. <p> Note that if you ask the form for the current value in
     * this handler, you will get the old value because the change has not yet been committed.  The new value is available as a
     * parameter to this method.
     *
     * @param handler the change handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addChangeHandler(com.smartgwt.client.widgets.form.fields.events.ChangeHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.ChangeEvent.getType()) == 0) setupChangeEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.ChangeEvent.getType());
    }

    private native void setupChangeEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var change = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.form.fields.events.ChangeEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.fields.FormItem::handleTearDownChangeEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
            }));
        obj.change = 
            function () {
                var param = {"_this": this, "form" : arguments[0], "item" : arguments[1], "value" : arguments[2], "oldValue" : arguments[3]};
                return change(param) == true;
            }
        ;
    }-*/;

    private void handleTearDownChangeEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.fields.events.ChangeEvent.getType()) == 0) tearDownChangeEvent();
    }

    private native void tearDownChangeEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (obj && "change" in obj) delete obj.change;
    }-*/;

    /**
     * Add a changed handler.
     * <p>
     * Called when a FormItem's value has been changed as the result of user interaction.  This method fires after the newly
     * specified value has been stored.
     *
     * @param handler the changed handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addChangedHandler(com.smartgwt.client.widgets.form.fields.events.ChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.ChangedEvent.getType()) == 0) setupChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.ChangedEvent.getType());
    }

    private native void setupChangedEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var changed = $entry(function(){
            var param = {"_this": this, "form" : arguments[0], "item" : arguments[1], "value" : arguments[2]};
            var event = @com.smartgwt.client.widgets.form.fields.events.ChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.fields.FormItem::handleTearDownChangedEvent()();
            });
        obj.changed =  changed 
        ;
    }-*/;

    private void handleTearDownChangedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.fields.events.ChangedEvent.getType()) == 0) tearDownChangedEvent();
    }

    private native void tearDownChangedEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (obj && "changed" in obj) delete obj.changed;
    }-*/;

	/**
     * Clear all error messages for this item
     * @see com.smartgwt.client.docs.ErrorHandling ErrorHandling overview and related methods
     */
    public native void clearErrors() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.clearErrors();
    }-*/;

	/**
     * Clear the value for this form item. <P> Note that if a default value is specified, value will be set to that default
     * value, otherwise value will be cleared, (and removed from the containing form's values).
     */
    public native void clearValue() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.clearValue();
    }-*/;

    /**
     * Add a click handler.
     * <p>
     * Called when this FormItem is clicked on. <P> Note: <code>click()</code> is available on StaticTextItem, BlurbItems,
     * ButtonItem, and derivatives.  Other form items (such as HiddenItem) do not support <code>click()</code>.
     *
     * @param handler the click handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addClickHandler(com.smartgwt.client.widgets.form.fields.events.ClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.ClickEvent.getType()) == 0) setupClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.ClickEvent.getType());
    }

    private native void setupClickEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var click = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.form.fields.events.ClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.fields.FormItem::handleTearDownClickEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
            }));
        obj.click = 
            function () {
                var param = {"_this": this, "form" : arguments[0], "item" : arguments[1]};
                return click(param) == true;
            }
        ;
    }-*/;

    private void handleTearDownClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.fields.events.ClickEvent.getType()) == 0) tearDownClickEvent();
    }

    private native void tearDownClickEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (obj && "click" in obj) delete obj.click;
    }-*/;

	/**
     * Set this item to be disabled at runtime.
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getDisabled
     * @see com.smartgwt.client.docs.Enable Enable overview and related methods
     */
    public native void disable() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!$wnd.isc.isA.FormItem(self)) { self.disabled = true; return; }
        self.disable();
    }-*/;

	/**
     * This method will disable some icon in this item's {@link com.smartgwt.client.widgets.form.fields.FormItem#getIcons
     * icons} array, if it is  currently enabled.
     * @param icon {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getName name} of the icon to be disabled.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     * @see com.smartgwt.client.widgets.form.fields.FormItemIcon#getDisabled
     * @see com.smartgwt.client.docs.Identifier Identifier
     * @see com.smartgwt.client.docs.Enable Enable overview and related methods
     */
    public native void disableIcon(String icon) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.disableIcon(icon);
    }-*/;

    /**
     * Add a doubleClick handler.
     * <p>
     * Called when this FormItem is double-clicked.
     *
     * @param handler the doubleClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDoubleClickHandler(com.smartgwt.client.widgets.form.fields.events.DoubleClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.DoubleClickEvent.getType()) == 0) setupDoubleClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.DoubleClickEvent.getType());
    }

    private native void setupDoubleClickEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var doubleClick = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.form.fields.events.DoubleClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.fields.FormItem::handleTearDownDoubleClickEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
            }));
        obj.doubleClick = 
            function () {
                var param = {"_this": this, "form" : arguments[0], "item" : arguments[1]};
                return doubleClick(param) == true;
            }
        ;
    }-*/;

    private void handleTearDownDoubleClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.fields.events.DoubleClickEvent.getType()) == 0) tearDownDoubleClickEvent();
    }

    private native void tearDownDoubleClickEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (obj && "doubleClick" in obj) delete obj.doubleClick;
    }-*/;

    /**
     * Add a editorEnter handler.
     * <p>
     * Notification method fired when the user enters this formItem. Differs from {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#addFocusHandler FormItem.focus()} in that while <code>focus</code> and
     * <code>blur</code> may fire multiple as the user navigates sub elements of an item (such as interacting with a pick
     * list), <code>editorEnter</code> will typically fire once when the user  starts to edit this item as a whole, and once
     * when the user moves onto a different item or component
     *
     * @param handler the editorEnter handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addEditorEnterHandler(com.smartgwt.client.widgets.form.fields.events.EditorEnterHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.EditorEnterEvent.getType()) == 0) setupEditorEnterEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.EditorEnterEvent.getType());
    }

    private native void setupEditorEnterEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var editorEnter = $entry(function(){
            var param = {"_this": this, "form" : arguments[0], "item" : arguments[1], "value" : arguments[2]};
            var event = @com.smartgwt.client.widgets.form.fields.events.EditorEnterEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.fields.FormItem::handleTearDownEditorEnterEvent()();
            });
        obj.editorEnter =  editorEnter 
        ;
    }-*/;

    private void handleTearDownEditorEnterEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.fields.events.EditorEnterEvent.getType()) == 0) tearDownEditorEnterEvent();
    }

    private native void tearDownEditorEnterEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (obj && "editorEnter" in obj) delete obj.editorEnter;
    }-*/;

    /**
     * Add a editorExit handler.
     * <p>
     * Notification method fired when the user leaves this formItem. Differs from {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#addBlurHandler FormItem.blur()} in that while <code>focus</code> and
     * <code>blur</code> may fire multiple as the user navigates sub elements of an item (such as interacting with a pick
     * list), <code>editorEnter</code> will typically fire once when the user  starts to edit this item as a whole, and
     * <code>editorExit</code> fires once when the  user moves onto a different item or component
     *
     * @param handler the editorExit handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addEditorExitHandler(com.smartgwt.client.widgets.form.fields.events.EditorExitHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.EditorExitEvent.getType()) == 0) setupEditorExitEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.EditorExitEvent.getType());
    }

    private native void setupEditorExitEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var editorExit = $entry(function(){
            var param = {"_this": this, "form" : arguments[0], "item" : arguments[1], "value" : arguments[2]};
            var event = @com.smartgwt.client.widgets.form.fields.events.EditorExitEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.fields.FormItem::handleTearDownEditorExitEvent()();
            });
        obj.editorExit =  editorExit 
        ;
    }-*/;

    private void handleTearDownEditorExitEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.fields.events.EditorExitEvent.getType()) == 0) tearDownEditorExitEvent();
    }

    private native void tearDownEditorExitEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (obj && "editorExit" in obj) delete obj.editorExit;
    }-*/;

	/**
     * Set this item to be enabled at runtime.
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getDisabled
     * @see com.smartgwt.client.docs.Enable Enable overview and related methods
     */
    public native void enable() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!$wnd.isc.isA.FormItem(self)) { self.disabled = false; return; }
        self.enable();
    }-*/;

	/**
     * This method will enable some icon in this item's {@link com.smartgwt.client.widgets.form.fields.FormItem#getIcons icons}
     * array, if it is  currently disabled.
     * @param icon {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getName name} of the icon to be enabled.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     * @see com.smartgwt.client.widgets.form.fields.FormItemIcon#getDisabled
     * @see com.smartgwt.client.docs.Identifier Identifier
     * @see com.smartgwt.client.docs.Enable Enable overview and related methods
     */
    public native void enableIcon(String icon) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.enableIcon(icon);
    }-*/;

    /**
     * Add a focus handler.
     * <p>
     * Called when this FormItem receives focus.
     *
     * @param handler the focus handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addFocusHandler(com.smartgwt.client.widgets.form.fields.events.FocusHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.FocusEvent.getType()) == 0) setupFocusEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.FocusEvent.getType());
    }

    private native void setupFocusEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var focus = $entry(function(){
            var param = {"_this": this, "form" : arguments[0], "item" : arguments[1]};
            var event = @com.smartgwt.client.widgets.form.fields.events.FocusEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.fields.FormItem::handleTearDownFocusEvent()();
            });
        obj.focus =  focus 
        ;
    }-*/;

    private void handleTearDownFocusEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.fields.events.FocusEvent.getType()) == 0) tearDownFocusEvent();
    }

    private native void tearDownFocusEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (obj && "focus" in obj) delete obj.focus;
    }-*/;

	/**
     * Shifts focus to the next focusable element after this item, skipping any elements nested inside the tabbing group for
     * this item, such as sub-elements, nested canvases in a CanvasItem, or icons. <P> This method makes use of the {@link
     * com.smartgwt.client.widgets.TabIndexManager#shiftFocusAfterGroup TabIndexManager.shiftFocusAfterGroup()} method to
     * request focus be changed to the next registered entry. By default standard focusable  Smart GWT UI elements, including
     * Canvases, FormItems, FormItemIcons, etc are registered with the TabIndexManager in the appropriate order, and will
     * accept focus if {@link com.smartgwt.client.widgets.Canvas#getCanFocus focusable}, and not {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisabled disabled} or  {@link
     * com.smartgwt.client.widgets.Canvas#showClickMask masked}.  <P> Canvases support a similar method: {@link
     * com.smartgwt.client.widgets.Canvas#focusAfterGroup Canvas.focusAfterGroup()}. <P> <b>NOTE: </b>Focusable elements
     * created directly in the raw HTML bootstrap or  by application code will not be passed focus by this method unless they
     * have also been explicitly registered with the TabIndexManager. See the {@link com.smartgwt.client.docs.TabOrderOverview}
     * for more information.
     * @param forward direction to shift focus - true to move forward, false to move          backwards (as with a shift+tab interaction).
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public native void focusAfterItem(boolean forward) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.focusAfterItem(forward);
    }-*/;

	/**
     * Move the keyboard focus into this item's focusable element
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public native void focusInItem() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.focusInItem();
    }-*/;

	/**
     * For text-based items, this method returns the index of the start of the current selection if the item currently has the
     * focus (if no text is selected, this equates to the current position of the text editing cursor). See {@link
     * com.smartgwt.client.widgets.form.fields.TextItem#getSelectionRange TextItem.getSelectionRange()} for details of what is
     * returned if the item does not have the focus (note, it is  important to read this documentation, because the behavior
     * when the item does not have the focus varies by browser)
     *
     * @return Index of the current or past selection's start point
     */
    public native Integer getCursorPosition() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.getCursorPosition();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toInteger(I)(ret);
    }-*/;

	/**
     * Optional method to retrieve a custom state suffix to append to the style name that is  applied to some element of a
     * formItem - see {@link com.smartgwt.client.docs.FormItemBaseStyle} for more  information on how state-based FormItem
     * style names are derived.   <p> If this method exists on a formItem, the framework will call it, passing in the state
     * suffix it has derived.  Your <code>getCustomState()</code> implementation can make use  of this derived state or ignore
     * it.  For example, if you wanted two different types of focus styling depending on some factor unrelated to focus, you
     * would probably make use of the incoming "Focused" state and return something like "Focused1" or "Focused2".  On  the
     * other hand, if you want your custom state to just override whatever the system  derived, you would ignore the incoming
     * state.  Finally, if you do not wish to provide a custom style for this formItem element at this time - for example, you
     * are only  interested in providing a custom "textBox" style and this call is for a "cell" element   type - your
     * <code>getCustomStyle()</code> method should just return the state it was passed. <p> This method is an advanced API, and
     * you should only provide an implementation of it if  you have specialized styling requirements.  If you do implement it,
     * note that it will  be called very frequently, from rendering code: if your custom logic does significant  processing, it
     * could introduce a system-wide performance problem.
     * @param elementType The element type to return a custom state for
     * @param derivedState The state suffix the system derived
     *
     * @return custom state suffix to use for the parameter elementType for this                   FormItem
     * @see com.smartgwt.client.docs.FormItemBaseStyle
     */
    public native String getCustomState(FormItemElementType elementType, String derivedState) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.getCustomState(elementType.@com.smartgwt.client.types.FormItemElementType::getValue()(), derivedState);
        return ret;
    }-*/;

	/**
     * Returns the <code>displayField</code> for this item. <P> Behavior varies based on the configuration of this item, as
     * follows: <ul><li>If this item has an {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * optionDataSource} and an explicit   {@link com.smartgwt.client.widgets.form.fields.FormItem#getForeignDisplayField
     * foreignDisplayField} is specified, this will be returned.</li> <li>Otherwise if an explicit {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} is specified it will be returned   by
     * default. If the <code>displayField</code> was specified on the underlying   dataSource field, and no matching field is
     * present in the {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource} for  the
     * item, we avoid returning the specified displayField value and instead return the  title field of the option DataSource.
     * We do this to  avoid confusion for the case where the displayField is intended as a display-field  value for showing
     * another field value within the same record in the underlying  dataSource only.</li> <li>If no explicit foreignDisplay or
     * displayField   specification was found, and the {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueField
     * valueField} for this item is hidden in the   {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * optionDataSource}, this method will return the title field for   the <code>optionDataSource</code>.</li></ul>
     *
     * @return display field name, or null if there is no separate display field to                     use.
     * See {@link com.smartgwt.client.docs.FieldName FieldName}
     */
    public native String getDisplayFieldName() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.getDisplayFieldName();
        return ret;
    }-*/;

	/**
     * Return the name for the this formItem.
     *
     * @return name for this form item
     * @see com.smartgwt.client.docs.Drawing Drawing overview and related methods
     */
    public native String getFieldName() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.getFieldName();
        return ret;
    }-*/;

	/**
     * Return the fully-qualified dataPath for the this formItem (ie, the dataPath expressed  in absolute terms from the root
     * of the hierarchy, rather than relative to the item's  parent form).  Note that the item's name is substituted into the
     * full dataPath if the item does not specify an explicit dataPath.  For example, if we have a field called 
     * <code>name</code> that specifies no dataPath, on a form that specifies a dataPath of  <code>/order/items</code>, this
     * method will return <code>/order/items/name</code>
     *
     * @return Fully-qualified dataPath for this form item.
     * See {@link com.smartgwt.client.docs.DataPath DataPath}
     */
    public native String getFullDataPath() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.getFullDataPath();
        return ret;
    }-*/;

	/**
     * If this formItem is part of a {@link com.smartgwt.client.widgets.grid.ListGrid}'s  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanEdit inline edit form}, returns the number of the grid column this 
     * formItem is responsible for editing, but <b>only</b> if a row is currently being edited.  If the formItem is not part of
     * a ListGrid inline edit for any reason, this  method returns null.  Reasons for a formItem not being part of an inline
     * edit include<ul> <li>The item is part of an ordinary DynamicForm, not an inline edit form</li> <li>There is no row in
     * the grid currently being edited</li> <li>A row is being edited, but this formItem is not currently visible and is being 
     * excluded because of horizontal incremental rendering (where Smart GWT avoids drawing grid columns that would not be
     * visible without scrolling)</li> </ul>
     *
     * @return The grid column number being edited by this formItem, or null, as                    described above
     */
    public native Integer getGridColNum() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.getGridColNum();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toInteger(I)(ret);
    }-*/;

	/**
     * If this formItem is part of a {@link com.smartgwt.client.widgets.grid.ListGrid}'s  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanEdit inline edit form}, returns the number of the row currently being
     * edited.  If the formItem is not part of a ListGrid inline edit for any reason, this  method returns null.  Reasons for a
     * formItem not being part of an inline edit include<ul> <li>The item is part of an ordinary DynamicForm, not an inline
     * edit form</li> <li>There is no row in the grid currently being edited</li> <li>A row is being edited, but this formItem
     * is not currently visible and is being  excluded because of horizontal incremental rendering (where Smart GWT avoids
     * drawing grid columns that would not be visible without scrolling)</li> </ul>
     *
     * @return The grid row number being edited or null, as described above
     */
    public native Integer getGridRowNum() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.getGridRowNum();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toInteger(I)(ret);
    }-*/;

	/**
     * Given a {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getName FormItemIcon.name}, returns the
     * <code>FormItemIcon</code> object.
     * @param name specified {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getName FormItemIcon.name}.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     *
     * @return form item icon matching the specified name, or <code>null</code> if there is no such icon.
     * @see com.smartgwt.client.docs.Identifier Identifier
     */
    public native FormItemIcon getIcon(String name) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.getIcon(name);
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.form.fields.FormItemIcon::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns the desired tab-position of some icon with respect to other focusable sub-elements for this formItem. <P>
     * Default implementation returns the index of the icon in the icons array,  (plus one if a pickerIcon is showing) meaning
     * users can tab through icons in order. Has no effect for non-focusable icons.
     *
     * @return desired position in the tab-order within this item's sub-elements
     */
    public native Integer getIconTabPosition() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.getIconTabPosition();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toInteger(I)(ret);
    }-*/;

	/**
     * If this item is being used to edit cells in a ListGrid (see {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#isInGrid isInGrid()}),  this method returns the grid in question.
     *
     * @return For listGrid edit items, the listGrid containing the item. Will   return null for items that are edit items of a
     * listGrid.
     */
    public native ListGrid getListGrid() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.getListGrid();
        return @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns the drawn page-left coordinate of this form item in pixels.
     *
     * @return page-left coordinate in px
     * @see com.smartgwt.client.docs.Positioning Positioning overview and related methods
     */
    public native int getPageLeft() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getPageLeft();
        return ret;
    }-*/;

	/**
     * Returns the drawn page-top coordinate of this form item in pixels.
     *
     * @return page-top coordinate in px
     * @see com.smartgwt.client.docs.Positioning Positioning overview and related methods
     */
    public native int getPageTop() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getPageTop();
        return ret;
    }-*/;

	/**
     * Returns the desired tab-position of the picker icon with respect to other focusable sub-elements for this formItem. <P>
     * Default implementation returns zero, making the picker the first focusable element after the items text box.
     *
     * @return desired position in the tab-order within this item's sub-elements
     */
    public native Integer getPickerIconTabPosition() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.getPickerIconTabPosition();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toInteger(I)(ret);
    }-*/;

	/**
     * Returns the specified {@link com.smartgwt.client.widgets.form.fields.FormItem#getHeight height} of this formItem in
     * pixels.  For heights specified as a percentage value or <code>"*"</code>, the  pixel height may not be available prior
     * to the item being drawn. In cases where the height has not yet been resolved to a pixel value, this method will return
     * <code>-1</code>.
     *
     * @return Specified height resolved to a pixel value.
     */
    public native int getPixelHeight() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getPixelHeight();
        return ret;
    }-*/;

	/**
     * Returns the specified {@link com.smartgwt.client.widgets.form.fields.FormItem#getWidth width} of this formItem in
     * pixels.  For widths specified as a percentage value or <code>"*"</code>, the  pixel width may not be available prior to
     * the item being drawn. In cases where the width has not yet been resolved to a pixel value, this method will return
     * <code>-1</code>.
     *
     * @return Specified width resolved to a pixel value.
     */
    public native int getPixelWidth() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getPixelWidth();
        return ret;
    }-*/;

	/**
     * Get the record returned from the {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * optionDataSource} when {@link com.smartgwt.client.widgets.form.fields.FormItem#getFetchMissingValues fetchMissingValues}
     * is true, and the missing value is fetched. <P> {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getFetchMissingValues fetchMissingValues} kicks off the fetch when the
     * form item is initialized with a non null value or when setValue() is called on the item. Note that this method will
     * return null before the fetch completes, or if no record is found in the optionDataSource matching the underlying value.
     *
     * @return selected record
     */
    public native ListGridRecord getSelectedRecord() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.getSelectedRecord();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.grid.ListGridRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Getter method to retrieve the {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueField valueField} for this
     * item. For items with a specified {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * optionDataSource}, this determines which field in that dataSource corresponds to the value for this item. <P> If unset,
     * if a {@link com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey relationship} exists between this field
     * and the optionDataSource, this will be used, otherwise default behavior will return the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getName name} of this field.
     *
     * @return fieldName to use a "value field" in records from this items               {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource}
     */
    public native String getValueFieldName() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.getValueFieldName();
        return ret;
    }-*/;

	/**
     * Returns the visible width of this item's title in px.  If that is not applicable (for  example, the form item has no
     * title) or cannot be determined (for example, the form  is not drawn), returns 0.
     * @param labelOnly If true, returns the visible width of the title text                                  only; if false (the default)
     * returns the width of the                                   title cell
     *
     * @return width of the form item's title in px
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public native int getVisibleTitleWidth(Boolean labelOnly) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getVisibleTitleWidth(labelOnly == null ? null : labelOnly.@java.lang.Boolean::booleanValue()());
        return ret;
    }-*/;

	/**
     * Does this form item produce an {@link com.smartgwt.client.data.AdvancedCriteria} sub criterion object? If this method
     * returns true, {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria DynamicForm.getValuesAsCriteria()}
     * on the form containing this item will always return an {@link com.smartgwt.client.data.AdvancedCriteria} object, calling
     * <code>FormItemCriterionGetter.getCriterion()</code> on each item to retrieve the individual criteria. <P> Default
     * implementation will return <code>true</code> if {@link com.smartgwt.client.widgets.form.fields.FormItem#getOperator
     * operator} is explicitly specified.
     *
     * @return true if this item will return an AdvancedCriteria sub-criterion.
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public native Boolean hasAdvancedCriteria() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.hasAdvancedCriteria();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Return whether this item currently has any validation errors as   a result of a previous validation pass.
     *
     * @return true == item currently has validation errors.
     * @see com.smartgwt.client.docs.ErrorHandling ErrorHandling overview and related methods
     */
    public native boolean hasErrors() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.hasErrors();
        return ret == null ? false : ret;
    }-*/;

	/**
     * Hide this form item. <BR><BR> This will cause the form to redraw.  If this item had an item.showIf expression, it will
     * be destroyed.
     */
    public native void hide() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!$wnd.isc.isA.FormItem(self)) { self.visible = false; return; }
        self.hide();
    }-*/;

	/**
     * This method will hide some icon in this item's {@link com.smartgwt.client.widgets.form.fields.FormItem#getIcons icons}
     * array, if it is  currently visible. Note that once this method has been called, any previously specified {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#showIf FormItemIcon.showIf()} will be discarded.
     * @param icon {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getName name} of the icon to be hidden.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     * @see com.smartgwt.client.docs.Identifier Identifier
     */
    public native void hideIcon(String icon) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.hideIcon(icon);
    }-*/;

    /**
     * Add a iconClick handler.
     * <p>
     * Notification method called when the user clicks on a form item icon.  <p>  The icon's {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#addFormItemClickHandler FormItemIcon.formItemClick()} method if any
     * is called first. Then, if the clicked  icon is the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon picker icon}, the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#addPickerIconClickHandler FormItem.pickerIconClick()} method is 
     * called. Then, this method is called.  <P>  This event may be cancelled  to   suppress the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#addClickHandler FormItem.click()} handler from also firing in response
     * to the  user interaction.
     *
     * @param handler the iconClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addIconClickHandler(com.smartgwt.client.widgets.form.fields.events.IconClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.IconClickEvent.getType()) == 0) setupIconClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.IconClickEvent.getType());
    }

    private native void setupIconClickEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var iconClick = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.form.fields.events.IconClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.fields.FormItem::handleTearDownIconClickEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
            }));
        obj.iconClick = 
            function () {
                var param = {"_this": this, "form" : arguments[0], "item" : arguments[1], "icon" : arguments[2]};
                return iconClick(param) == true;
            }
        ;
    }-*/;

    private void handleTearDownIconClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.fields.events.IconClickEvent.getType()) == 0) tearDownIconClickEvent();
    }

    private native void tearDownIconClickEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (obj && "iconClick" in obj) delete obj.iconClick;
    }-*/;

    /**
     * Add a iconKeyPress handler.
     * <p>
     * StringMethod.      Default action to fire when an icon has keyboard focus and the user types a key.      May be
     * overridden by setting <code>keyPress</code> on the form item icon directly.
     *
     * @param handler the iconKeyPress handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addIconKeyPressHandler(com.smartgwt.client.widgets.form.fields.events.IconKeyPressHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.IconKeyPressEvent.getType()) == 0) setupIconKeyPressEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.IconKeyPressEvent.getType());
    }

    private native void setupIconKeyPressEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var iconKeyPress = $entry(function(){
            var param = {"_this": this, "keyName" : arguments[0], "character" : arguments[1], "form" : arguments[2], "item" : arguments[3], "icon" : arguments[4]};
            var event = @com.smartgwt.client.widgets.form.fields.events.IconKeyPressEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.fields.FormItem::handleTearDownIconKeyPressEvent()();
            });
        obj.iconKeyPress =  iconKeyPress 
        ;
    }-*/;

    private void handleTearDownIconKeyPressEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.fields.events.IconKeyPressEvent.getType()) == 0) tearDownIconKeyPressEvent();
    }

    private native void tearDownIconKeyPressEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (obj && "iconKeyPress" in obj) delete obj.iconKeyPress;
    }-*/;

	/**
     * If this item has a specified {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField}, the
     * value displayed to the user for this item may be derived from another field. <P> The display field can be either another
     * field value in the same record or a field that must be retrieved from a related {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource} if {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getFetchMissingValues fetchMissingValues} is true. In this latter case,
     * we perform a fetch against the option dataSource when the item value changes in order to determine the display value to
     * show (and we make the associated record available via {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getSelectedRecord getSelectedRecord()}). <P> We cache this data on the
     * form item, so if the item value changes to a new value, then reverts to a previously-seen value, the display value and
     * selected record are already available  without the need for an additional fetch. The cached values will also be kept in
     * synch with the dataSource data assuming it is modified via standard add, update or delete operations. <P> This method
     * explicitly invalidates this cache of optionDataSource data, and if the item value is non null and fetchMissingValues is
     * still true, re-fetches the data.
     */
    public native void invalidateDisplayValueCache() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.invalidateDisplayValueCache();
    }-*/;

	/**
     * Is the user performing a native "cut" event to modify the value of a freeform text field? This method may be invoked
     * during change notification flow methods including  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#addChangeHandler FormItem.change()}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#addChangedHandler FormItem.changed()} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setInputTransformer FormItem.transformInput()}. See {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getSupportsCutPasteEvents supportsCutPasteEvents}.
     *
     * @return true if this is a cut event.
     */
    public native boolean isCutEvent() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.isCutEvent();
        return ret == null ? false : ret;
    }-*/;

	/**
     * Returns true if this item has been written out into the DOM.
     *
     * @return whether this item is drawn
     * @see com.smartgwt.client.docs.Drawing Drawing overview and related methods
     */
    public native Boolean isDrawn() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.isDrawn();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Returns true if this formItem has the keyboard focus.  Note that in Internet Explorer
     * focus notifications can be asynchronous (see {@link com.smartgwt.client.util.EventHandler#synchronousFocusNotifications
     * synchronousFocusNotifications}).
     *  In this case, this method can correctly 
     *  return false when, intuitively, you would expect it to return true:
     *  <pre>
     *      someItem.focusInItem();
     *      if (someItem.isFocused()) {
     *          // In most browsers we would get here, but not in Internet Explorer with
     *          // EventHandler.synchronousFocusNotifications disabled
     *      }
     *  </pre>
     * 
     * 
     *
     * @return whether this formItem has the keyboard focus
     */
    public native Boolean isFocused() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.isFocused();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Returns true if this item's {@link com.smartgwt.client.widgets.form.fields.FormItem#getContainerWidget containerWidget}
     * is a  {@link com.smartgwt.client.widgets.grid.GridRenderer} or GridRenderer subclass
     *
     * @return whether the item's container is a GridRenderer (and thus ultimately                    a ListGrid)
     */
    public native Boolean isInGrid() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.isInGrid();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Is the user performing a native "paste" event to modify the value of a freeform text field? This method may be invoked
     * during change notification flow methods including  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#addChangeHandler FormItem.change()}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#addChangedHandler FormItem.changed()} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setInputTransformer FormItem.transformInput()}. See {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getSupportsCutPasteEvents supportsCutPasteEvents}.
     *
     * @return true if this is a cut event.
     */
    public native boolean isPasteEvent() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.isPasteEvent();
        return ret == null ? false : ret;
    }-*/;

	/**
     * Return true if the form item is currently visible. Note that like the similar {@link
     * com.smartgwt.client.widgets.Canvas#isVisible Canvas API}, it indicates visibility settings only and so will return true
     * for an item that is not drawn.
     *
     * @return true if the form item is visible
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public native Boolean isVisible() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.isVisible();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

    /**
     * Add a itemHover handler.
     * <p>
     * Optional stringMethod to fire when the user hovers over this item. Call {@link
     * com.smartgwt.client.widgets.form.fields.events.ItemHoverEvent#cancel()} from within {@link
     * com.smartgwt.client.widgets.form.fields.events.ItemHoverHandler#onItemHover} to suppress default behavior of showing a
     * hover canvas containing the HTML returned by <code>formItem.itemHoverHTML()</code> /  <code>form.itemHoverHTML()</code>.
     *
     * @param handler the itemHover handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addItemHoverHandler(com.smartgwt.client.widgets.form.fields.events.ItemHoverHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.ItemHoverEvent.getType()) == 0) setupItemHoverEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.ItemHoverEvent.getType());
    }

    private native void setupItemHoverEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var itemHover = $entry(function(){
            var param = {"_this": this, "item" : arguments[0], "form" : arguments[1]};
            var event = @com.smartgwt.client.widgets.form.fields.events.ItemHoverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.fields.FormItem::handleTearDownItemHoverEvent()();
            });
        obj.itemHover =  itemHover 
        ;
    }-*/;

    private void handleTearDownItemHoverEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.fields.events.ItemHoverEvent.getType()) == 0) tearDownItemHoverEvent();
    }

    private native void tearDownItemHoverEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (obj && "itemHover" in obj) delete obj.itemHover;
    }-*/;

    /**
     * Add a keyDown handler.
     * <p>
     * StringMethod fired in response to a keydown while focused in this form item.
     *
     * @param handler the keyDown handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addKeyDownHandler(com.smartgwt.client.widgets.form.fields.events.KeyDownHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.KeyDownEvent.getType()) == 0) setupKeyDownEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.KeyDownEvent.getType());
    }

    private native void setupKeyDownEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var keyDown = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.form.fields.events.KeyDownEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.fields.FormItem::handleTearDownKeyDownEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
            }));
        obj.keyDown = 
            function () {
                var param = {"_this": this, "item" : arguments[0], "form" : arguments[1], "keyName" : arguments[2]};
                return keyDown(param) == true;
            }
        ;
    }-*/;

    private void handleTearDownKeyDownEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.fields.events.KeyDownEvent.getType()) == 0) tearDownKeyDownEvent();
    }

    private native void tearDownKeyDownEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (obj && "keyDown" in obj) delete obj.keyDown;
    }-*/;

    /**
     * Add a keyPress handler.
     * <p>
     * StringMethod fired when the user presses a key while focused in this form item.
     *
     * @param handler the keyPress handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addKeyPressHandler(com.smartgwt.client.widgets.form.fields.events.KeyPressHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.KeyPressEvent.getType()) == 0) setupKeyPressEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.KeyPressEvent.getType());
    }

    private native void setupKeyPressEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var keyPress = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.form.fields.events.KeyPressEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.fields.FormItem::handleTearDownKeyPressEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
            }));
        obj.keyPress = 
            function () {
                var param = {"_this": this, "item" : arguments[0], "form" : arguments[1], "keyName" : arguments[2], "characterValue" : arguments[3]};
                return keyPress(param) == true;
            }
        ;
    }-*/;

    private void handleTearDownKeyPressEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.fields.events.KeyPressEvent.getType()) == 0) tearDownKeyPressEvent();
    }

    private native void tearDownKeyPressEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (obj && "keyPress" in obj) delete obj.keyPress;
    }-*/;

    /**
     * Add a keyUp handler.
     * <p>
     * StringMethod fired in response to a keyup while focused in this form item.
     *
     * @param handler the keyUp handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addKeyUpHandler(com.smartgwt.client.widgets.form.fields.events.KeyUpHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.KeyUpEvent.getType()) == 0) setupKeyUpEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.KeyUpEvent.getType());
    }

    private native void setupKeyUpEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var keyUp = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.form.fields.events.KeyUpEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.fields.FormItem::handleTearDownKeyUpEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
            }));
        obj.keyUp = 
            function () {
                var param = {"_this": this, "item" : arguments[0], "form" : arguments[1], "keyName" : arguments[2]};
                return keyUp(param) == true;
            }
        ;
    }-*/;

    private void handleTearDownKeyUpEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.fields.events.KeyUpEvent.getType()) == 0) tearDownKeyUpEvent();
    }

    private native void tearDownKeyUpEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (obj && "keyUp" in obj) delete obj.keyUp;
    }-*/;

    /**
     * Add a pendingStatusChanged handler.
     * <p>
     * Notification method called when {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPending showPending} is
     * enabled and this form item should either clear or show its "Pending" visual state. <p> The default behavior is that the
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getTitleStyle titleStyle} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCellStyle cellStyle} are updated to include/exclude the "Pending"
     * suffix. Standard form item types may implement additional default behavior (see any item-specific pendingStatusChanged()
     * documentation). Returning <code>false</code> will cancel the default behavior. <p> The pendingStatusChanged()
     * notification method is typically used by {@link com.smartgwt.client.widgets.form.fields.CanvasItem}-derived form items,
     * where a custom or supplemental pending visual state is desired.
     *
     * @param handler the pendingStatusChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addPendingStatusChangedHandler(com.smartgwt.client.widgets.form.fields.events.PendingStatusChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.PendingStatusChangedEvent.getType()) == 0) setupPendingStatusChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.PendingStatusChangedEvent.getType());
    }

    private native void setupPendingStatusChangedEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var pendingStatusChanged = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.form.fields.events.PendingStatusChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.fields.FormItem::handleTearDownPendingStatusChangedEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
            }));
        obj.pendingStatusChanged = 
            function () {
                var param = {"_this": this, "form" : arguments[0], "item" : arguments[1], "pendingStatus" : arguments[2], "newValue" : arguments[3], "value" : arguments[4]};
                return pendingStatusChanged(param) == true;
            }
        ;
    }-*/;

    private void handleTearDownPendingStatusChangedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.fields.events.PendingStatusChangedEvent.getType()) == 0) tearDownPendingStatusChangedEvent();
    }

    private native void tearDownPendingStatusChangedEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (obj && "pendingStatusChanged" in obj) delete obj.pendingStatusChanged;
    }-*/;

    /**
     * Add a pickerIconClick handler.
     * <p>
     * Notification method called when the {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon picker
     * icon} is clicked. This method will fire after the {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#addFormItemClickHandler FormItemIcon.formItemClick()} handler for
     * the {@link com.smartgwt.client.widgets.form.fields.FormItem#getPickerIconProperties pickerIcon}. If the event is not
     * cancelled,  the standard {@link com.smartgwt.client.widgets.form.fields.FormItem#addIconClickHandler
     * FormItem.iconClick()} will also fire. <P> The default implementation will call {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#showPicker FormItem.showPicker()}.
     *
     * @param handler the pickerIconClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addPickerIconClickHandler(com.smartgwt.client.widgets.form.fields.events.PickerIconClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.PickerIconClickEvent.getType()) == 0) setupPickerIconClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.PickerIconClickEvent.getType());
    }

    private native void setupPickerIconClickEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var pickerIconClick = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.form.fields.events.PickerIconClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.fields.FormItem::handleTearDownPickerIconClickEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
            }));
        obj.pickerIconClick = 
            function () {
                var param = {"_this": this, "form" : arguments[0], "item" : arguments[1], "pickerIcon" : arguments[2]};
                return pickerIconClick(param) == true;
            }
        ;
    }-*/;

    private void handleTearDownPickerIconClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.fields.events.PickerIconClickEvent.getType()) == 0) tearDownPickerIconClickEvent();
    }

    private native void tearDownPickerIconClickEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (obj && "pickerIconClick" in obj) delete obj.pickerIconClick;
    }-*/;

	/**
     * Redraw this form item. <p> Depending on the item and the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getContainerWidget containerWidget} it's embedded in, this may redraw
     * this particular item or require a redraw of all items in the form. <p> Do not call this method unless the documentation
     * directs you to do so.  Calling <code>redraw()</code> unnecessarily has significant performance consequences.
     */
    public native void redraw() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.redraw();
    }-*/;

	/**
     * Redraw this form item. <p> Depending on the item and the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getContainerWidget containerWidget} it's embedded in, this may redraw
     * this particular item or require a redraw of all items in the form. <p> Do not call this method unless the documentation
     * directs you to do so.  Calling <code>redraw()</code> unnecessarily has significant performance consequences.
     * @param reason optional reason for performing the redraw, which may appear in                          diagnostic logs if enabled
     */
    public native void redraw(String reason) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.redraw(reason);
    }-*/;
	
	/**
     * Given an icon's {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getName name}, remove it from this item.
     * @param icon the name of the icon to remove.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     *
     * @return true if an icon was removed, false otherwise
     * @see com.smartgwt.client.docs.Identifier Identifier
     */
    public native boolean removeIcon(String icon) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.removeIcon(icon);
        return ret == null ? false : ret;
    }-*/;

	/**
     * Set an icon as enabled or disabled at runtime.
     * @param icon {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getName name} of the icon to be disabled/enabled.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     * @param disabled true if icon should be disabled
     * @see com.smartgwt.client.widgets.form.fields.FormItemIcon#getDisabled
     * @see com.smartgwt.client.docs.Enable Enable overview and related methods
     */
    public native void setIconDisabled(String icon, boolean disabled) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.setIconDisabled(icon, disabled);
    }-*/;

	/**
     * Sets {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getShowOnFocus FormItemIcon.showOnFocus} for the
     * supplied icon, and causes that icon's visibility to be updated and the item redrawn as appropriate.
     * @param icon {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getName name} of the icon to update.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     * @param showOnFocus new value of {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getShowOnFocus FormItemIcon.showOnFocus}
     */
    public native void setIconShowOnFocus(String icon, Boolean showOnFocus) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.setIconShowOnFocus(icon, showOnFocus == null ? null : showOnFocus.@java.lang.Boolean::booleanValue()());
    }-*/;

	/**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getHeight height} is specified, should it be applied to the
     * item's text box element? If this method returns false, the text box will not have an explicit height applied, though the
     * containing cell will be sized to accomodiate any specified height. <P> This is used in cases where the text box does not
     * have distinctive styling (for example in standard {@link com.smartgwt.client.widgets.form.fields.StaticTextItem}s). As
     * the textBox has no explicit height, it fits the content. Since the text box is not visually distinct to  the user, this
     * makes {@link com.smartgwt.client.widgets.form.fields.FormItem#getVAlign vAlign} behave as expected with the  text value
     * of the item being vertically aligned within the cell. <P> Default implementation will return {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getApplyHeightToTextBox applyHeightToTextBox} if explicitly set
     * otherwise <code>false</code> if {@link com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyDisplay
     * readOnlyDisplay} is set to  <code>"static"</code> and the item is {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit not editable}, otherwise true.
     *
     * @return true if the height should be written into the items' text box.
     */
    public native boolean shouldApplyHeightToTextBox() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.shouldApplyHeightToTextBox();
        return ret == null ? false : ret;
    }-*/;

	/**
     * If this field has a specified {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * optionDataSource}, should we perform a fetch against that dataSource to find the record that matches this field's value?
     * <P> If the value is non-null, this method is called when the item is first rendered  or whenever the value is changed
     * via a call to {@link com.smartgwt.client.widgets.form.fields.FormItem#setValue setValue()}. If it returns  true, a fetch
     * will be dispatched against the optionDataSource to get the record matching the value <P> When the fetch completes, if a
     * record was found that matches the data value (and the form item value has not subsequently changed again),  the item
     * will be re-rendered to reflect any changes to the display value, and the record matching the value will be available via
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getSelectedRecord this.getSelectedRecord()}. <P> Default
     * behavior will return false if {@link com.smartgwt.client.widgets.form.fields.FormItem#getFetchMissingValues
     * this.fetchMissingValues} is  set to false. Otherwise it will return true if {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getAlwaysFetchMissingValues this.alwaysFetchMissingValues} is set to
     * true, or if a {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} is specified for
     * this item and the item  value is not already present in the item's valueMap.
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
     * Returns true if 'Enter' key presses in this formItem should allow a saveOnEnter: true parent form to save it's data. 
     * The default implementation returns the value of {@link com.smartgwt.client.widgets.form.fields.FormItem#getSaveOnEnter
     * saveOnEnter} or false if that property is unset.
     *
     * @return boolean indicating whether saving should be allowed to proceed
     */
    public native Boolean shouldSaveOnEnter() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.shouldSaveOnEnter();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Should some keypress event on this item be prevented from bubbling (such that the containing form and ancestors do not
     * receive the event). <P> This method is called after standard item keypress handlers when the user presses a key while
     * focused in this item. Returning true will suppress bubbling of the event to the containing form. This is useful to avoid
     * having the form react to key events which "have meaning" to the focused item. <P> Default implementation varies by item
     * type. In short character keys  are suppressed for all editable fields, as are keys which will modify the  current state
     * of the field ("Arrow" keys for moving around free form text editors, etc). <P>  Note that when this method returns true,
     * no {@link com.smartgwt.client.widgets.Canvas#addKeyPressHandler keyPress} event will fire on the form for the key
     * pressed. However developers will still receive the separate {@link
     * com.smartgwt.client.widgets.form.DynamicForm#addItemKeyPressHandler DynamicForm.itemKeyPress()} event.
     * @param keyName name of the key pressed.
     * See {@link com.smartgwt.client.docs.KeyName KeyName}
     * @param characterValue If this was a character key, this is the numeric value        for the character
     *
     * @return return true to prevent bubbling of the pressed key.
     */
    public native boolean shouldStopKeyPressBubbling(String keyName, int characterValue) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.shouldStopKeyPressBubbling(keyName, characterValue);
        return ret == null ? false : ret;
    }-*/;

	/**
     * Show this form item. <p> This will cause the form to redraw.  If this item had an item.showIf expression, it will be
     * destroyed.
     */
    public native void show() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!$wnd.isc.isA.FormItem(self)) { self.visible = true; return; }
        self.show();
    }-*/;

    /**
     * Add a showContextMenu handler.
     * <p>
     * Called when the mouse is right-clicked anywhere in this formItem.  If the implementation returns false, default browser
     * behavior is cancelled. <P>  Note that it can be bad practice to cancel this method if the mouse is over the data 
     * element for the item, because doing so would replace the builtin browser-default menus  that users may expect.  You can
     * use {@link com.smartgwt.client.widgets.form.DynamicForm#getEventItemInfo DynamicForm.getEventItemInfo()} to return an  
     * info object that can be used to determine which part of the  item is under the mouse.
     *
     * @param handler the showContextMenu handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addShowContextMenuHandler(com.smartgwt.client.widgets.form.fields.events.ShowContextMenuHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.ShowContextMenuEvent.getType()) == 0) setupShowContextMenuEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.ShowContextMenuEvent.getType());
    }

    private native void setupShowContextMenuEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var showContextMenu = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.form.fields.events.ShowContextMenuEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.fields.FormItem::handleTearDownShowContextMenuEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
            }));
        obj.showContextMenu = 
            function () {
                var param = {"_this": this, "form" : arguments[0], "item" : arguments[1]};
                return showContextMenu(param) == true;
            }
        ;
    }-*/;

    private void handleTearDownShowContextMenuEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.fields.events.ShowContextMenuEvent.getType()) == 0) tearDownShowContextMenuEvent();
    }

    private native void tearDownShowContextMenuEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (obj && "showContextMenu" in obj) delete obj.showContextMenu;
    }-*/;

	/**
     * This method will show some icon in this item's {@link com.smartgwt.client.widgets.form.fields.FormItem#getIcons icons}
     * array, if it is not already visible. Note that once this method has been called, any previously specified {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#showIf FormItemIcon.showIf()} will be discarded. <P> Note that if
     * the form item's showIcons property is set to false, no icons will be displayed for the item. In this case this method
     * will not cause the icon to be displayed.
     * @param icon {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getName name} of the icon to be shown.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     * @see com.smartgwt.client.docs.Identifier Identifier
     */
    public native void showIcon(String icon) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.showIcon(icon);
    }-*/;

	/**
     * Method to show a picker for this item. By default this method is called if the user clicks on a {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon pickerIcon}.  May also be called programmatically.
     * <P> Default implementation lazily creates and shows the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getPicker Picker Autochild}. <P> Developers wishing to show a custom
     * picker widget can either implement a  {@link com.smartgwt.client.widgets.form.fields.FormItem#addPickerIconClickHandler
     * FormItem.pickerIconClick()} handler with an entirely custom implementation (and bypass the call to
     * <code>showPicker()</code> altogether),   or use the {@link com.smartgwt.client.types.AutoChild AutoChild pattern} to
     * customize the automatically generated {@link com.smartgwt.client.widgets.form.fields.FormItem#getPicker picker
     * autoChild}.
     */
    public native void showPicker() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.showPicker();
    }-*/;

	/**
     * This method is fired when the user rolls off this item (or the title for this item) and will clear any hover canvas
     * shown by the item.
     */
    public native void stopHover() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.stopHover();
    }-*/;

	/**
     * Store (and optionally show) a value for this form item.  <p> This method will fire standard {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#addChangeHandler FormItem.change()} and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#addItemChangedHandler DynamicForm.itemChanged()} handlers, and store the
     * value passed in such that subsequent calls to {@link com.smartgwt.client.widgets.form.fields.FormItem#getValue
     * getValue()} or {@link com.smartgwt.client.widgets.form.DynamicForm#getValue DynamicForm.getValue()} will return the new
     * value for this item. <P> This method is intended to provide a way for custom formItems - most commonly  {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem canvasItems} - to provide a new interface to the user, allowing them
     * to manipulate the item's value, for example in an embedded {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvas CanvasItem.canvas}, or a pop-up dialog launched from an
     * {@link com.smartgwt.client.widgets.form.fields.FormItemIcon icon}, etc.  Developers should call this method when the
     * user interacts with this custom  interface in order to store the changed value. <P> {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem#getShouldSaveValue shouldSaveValue} for CanvasItems is false by
     * default. Custom CanvasItems will need to override shouldSaveValue to true if the values stored via this API should be
     * included in the form's {@link com.smartgwt.client.widgets.form.DynamicForm#getValues getValues()} and saved with the
     * form when {@link com.smartgwt.client.widgets.form.DynamicForm#saveData saveData()} is called. <P> If you cannot easily
     * detect interactions that should change the value as the  user performs them, a workaround is to call
     * <code>storeValue</code> right before the form saves. <P> Note that this method is not designed for customizing a value
     * which is already being saved by a standard user interaction. For example you should not call this method from a {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#addChangeHandler change handler}. Other APIs such as  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setInputTransformer FormItem.transformInput()} exist for this.
     * @param value value to save for this item
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_grid_item" target="examples">ListGrid Item Example</a>
     */
    public native void storeValue(Object value) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.storeValue(value);
    }-*/;

	/**
     * Store (and optionally show) a value for this form item.  <p> This method will fire standard {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#addChangeHandler FormItem.change()} and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#addItemChangedHandler DynamicForm.itemChanged()} handlers, and store the
     * value passed in such that subsequent calls to {@link com.smartgwt.client.widgets.form.fields.FormItem#getValue
     * getValue()} or {@link com.smartgwt.client.widgets.form.DynamicForm#getValue DynamicForm.getValue()} will return the new
     * value for this item. <P> This method is intended to provide a way for custom formItems - most commonly  {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem canvasItems} - to provide a new interface to the user, allowing them
     * to manipulate the item's value, for example in an embedded {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvas CanvasItem.canvas}, or a pop-up dialog launched from an
     * {@link com.smartgwt.client.widgets.form.fields.FormItemIcon icon}, etc.  Developers should call this method when the
     * user interacts with this custom  interface in order to store the changed value. <P> {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem#getShouldSaveValue shouldSaveValue} for CanvasItems is false by
     * default. Custom CanvasItems will need to override shouldSaveValue to true if the values stored via this API should be
     * included in the form's {@link com.smartgwt.client.widgets.form.DynamicForm#getValues getValues()} and saved with the
     * form when {@link com.smartgwt.client.widgets.form.DynamicForm#saveData saveData()} is called. <P> If you cannot easily
     * detect interactions that should change the value as the  user performs them, a workaround is to call
     * <code>storeValue</code> right before the form saves. <P> Note that this method is not designed for customizing a value
     * which is already being saved by a standard user interaction. For example you should not call this method from a {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#addChangeHandler change handler}. Other APIs such as  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setInputTransformer FormItem.transformInput()} exist for this.
     * @param value value to save for this item
     * @param showValue Should the formItem be updated to display the new value?
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_grid_item" target="examples">ListGrid Item Example</a>
     */
    public native void storeValue(Object value, Boolean showValue) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.storeValue(value, showValue == null ? null : showValue.@java.lang.Boolean::booleanValue()());
    }-*/;
	
    /**
     * Add a titleClick handler.
     * <p>
     * Notification method fired when the user clicks the title for this item
     *
     * @param handler the titleClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addTitleClickHandler(com.smartgwt.client.widgets.form.fields.events.TitleClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.TitleClickEvent.getType()) == 0) setupTitleClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.TitleClickEvent.getType());
    }

    private native void setupTitleClickEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var titleClick = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.form.fields.events.TitleClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.fields.FormItem::handleTearDownTitleClickEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
            }));
        obj.titleClick = 
            function () {
                var param = {"_this": this, "form" : arguments[0], "item" : arguments[1]};
                return titleClick(param) == true;
            }
        ;
    }-*/;

    private void handleTearDownTitleClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.fields.events.TitleClickEvent.getType()) == 0) tearDownTitleClickEvent();
    }

    private native void tearDownTitleClickEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (obj && "titleClick" in obj) delete obj.titleClick;
    }-*/;

    /**
     * Add a titleDoubleClick handler.
     * <p>
     * Notification method fired when the user double-clicks the title for this item
     *
     * @param handler the titleDoubleClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addTitleDoubleClickHandler(com.smartgwt.client.widgets.form.fields.events.TitleDoubleClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.TitleDoubleClickEvent.getType()) == 0) setupTitleDoubleClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.TitleDoubleClickEvent.getType());
    }

    private native void setupTitleDoubleClickEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var titleDoubleClick = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.form.fields.events.TitleDoubleClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.fields.FormItem::handleTearDownTitleDoubleClickEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
            }));
        obj.titleDoubleClick = 
            function () {
                var param = {"_this": this, "form" : arguments[0], "item" : arguments[1]};
                return titleDoubleClick(param) == true;
            }
        ;
    }-*/;

    private void handleTearDownTitleDoubleClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.fields.events.TitleDoubleClickEvent.getType()) == 0) tearDownTitleDoubleClickEvent();
    }

    private native void tearDownTitleDoubleClickEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (obj && "titleDoubleClick" in obj) delete obj.titleDoubleClick;
    }-*/;

    /**
     * Add a titleHover handler.
     * <p>
     * Optional stringMethod to fire when the user hovers over this item's title. Call {@link
     * com.smartgwt.client.widgets.form.fields.events.TitleHoverEvent#cancel()} from within {@link
     * com.smartgwt.client.widgets.form.fields.events.TitleHoverHandler#onTitleHover} to suppress default behavior of showing a
     * hover canvas containing the HTML returned by <code>formItem.titleHoverHTML()</code> / 
     * <code>form.titleHoverHTML()</code>.
     *
     * @param handler the titleHover handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addTitleHoverHandler(com.smartgwt.client.widgets.form.fields.events.TitleHoverHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.TitleHoverEvent.getType()) == 0) setupTitleHoverEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.TitleHoverEvent.getType());
    }

    private native void setupTitleHoverEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var titleHover = $entry(function(){
            var param = {"_this": this, "item" : arguments[0], "form" : arguments[1]};
            var event = @com.smartgwt.client.widgets.form.fields.events.TitleHoverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.fields.FormItem::handleTearDownTitleHoverEvent()();
            });
        obj.titleHover =  titleHover 
        ;
    }-*/;

    private void handleTearDownTitleHoverEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.fields.events.TitleHoverEvent.getType()) == 0) tearDownTitleHoverEvent();
    }

    private native void tearDownTitleHoverEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (obj && "titleHover" in obj) delete obj.titleHover;
    }-*/;

	/**
     * Update the visual state of a FormItem to reflect any changes in state or any changes in style settings (e.g. {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTextBoxStyle textBoxStyle}). <P> Calls to <code>updateState()</code>
     * normally occur automatically as a consequence of focus changes, items becoming disabled, etc.  This method is advanced
     * and intended only for use in workarounds.
     */
    public native void updateState() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.updateState();
    }-*/;

	/**
     * Validate this item.
     *
     * @return returns true if validation was successful (no errors encountered), false                   otherwise.
     */
    public native Boolean validate() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) return null;
        var ret = self.validate();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Is the value clipped? <p> The form item must have value clipping enabled. If a form item type supports the clipValue
     * attribute, then clipValue must be true. {@link com.smartgwt.client.widgets.form.fields.TextItem}s and derivatives (e.g.
     * {@link com.smartgwt.client.widgets.form.fields.SpinnerItem}) automatically clip their values.
     *
     * @return true if the value is clipped; false otherwise.
     */
    public native boolean valueClipped() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.valueClipped();
        return ret == null ? false : ret;
    }-*/;

    /**
     * Add a valueHover handler.
     * <p>
     * Optional stringMethod to fire when the user hovers over this item's value. Call {@link
     * com.smartgwt.client.widgets.form.fields.events.ValueHoverEvent#cancel()} from within {@link
     * com.smartgwt.client.widgets.form.fields.events.ValueHoverHandler#onValueHover} to suppress default behavior of showing a
     * hover canvas containing the HTML returned by {@link com.smartgwt.client.widgets.form.fields.FormItem#valueHoverHTML
     * FormItem.valueHoverHTML()} / {@link com.smartgwt.client.widgets.form.DynamicForm#valueHoverHTML
     * DynamicForm.valueHoverHTML()}.
     *
     * @param handler the valueHover handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addValueHoverHandler(com.smartgwt.client.widgets.form.fields.events.ValueHoverHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.ValueHoverEvent.getType()) == 0) setupValueHoverEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.ValueHoverEvent.getType());
    }

    private native void setupValueHoverEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var valueHover = $entry(function(){
            var param = {"_this": this, "item" : arguments[0], "form" : arguments[1]};
            var event = @com.smartgwt.client.widgets.form.fields.events.ValueHoverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.fields.FormItem::handleTearDownValueHoverEvent()();
            });
        obj.valueHover =  valueHover 
        ;
    }-*/;

    private void handleTearDownValueHoverEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.fields.events.ValueHoverEvent.getType()) == 0) tearDownValueHoverEvent();
    }

    private native void tearDownValueHoverEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (obj && "valueHover" in obj) delete obj.valueHover;
    }-*/;

    /**
     * Add a valueIconClick handler.
     * <p>
     * Notification method fires when the user clicks a {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons
     * value icon} for this item.
     *
     * @param handler the valueIconClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addValueIconClickHandler(com.smartgwt.client.widgets.form.fields.events.ValueIconClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.ValueIconClickEvent.getType()) == 0) setupValueIconClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.ValueIconClickEvent.getType());
    }

    private native void setupValueIconClickEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var valueIconClick = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.form.fields.events.ValueIconClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.fields.FormItem::handleTearDownValueIconClickEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
            }));
        obj.valueIconClick = 
            function () {
                var param = {"_this": this, "form" : arguments[0], "item" : arguments[1], "value" : arguments[2]};
                return valueIconClick(param) == true;
            }
        ;
    }-*/;

    private void handleTearDownValueIconClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.fields.events.ValueIconClickEvent.getType()) == 0) tearDownValueIconClickEvent();
    }

    private native void tearDownValueIconClickEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (obj && "valueIconClick" in obj) delete obj.valueIconClick;
    }-*/;


    // ********************* Static Methods ***********************


	/**
     * Returns a {@link com.smartgwt.client.widgets.form.fields.FormItemIcon} for a standard picker with skin-specific
     * settings.
     * @param pickerName Name of picker icon
     *
     * @return the icon for picker
     */
    public static native FormItemIcon getPickerIcon(PickerIconName pickerName) /*-{
        var ret = $wnd.isc.FormItem.getPickerIcon(pickerName.@com.smartgwt.client.types.PickerIconName::getValue()());
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.form.fields.FormItemIcon::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns a {@link com.smartgwt.client.widgets.form.fields.FormItemIcon} for a standard picker with skin-specific
     * settings.
     * @param pickerName Name of picker icon
     * @param properties Properties to apply to new picker icon
     *
     * @return the icon for picker
     */
    public static native FormItemIcon getPickerIcon(PickerIconName pickerName, FormItemIcon properties) /*-{
        var ret = $wnd.isc.FormItem.getPickerIcon(pickerName.@com.smartgwt.client.types.PickerIconName::getValue()(), properties == null ? null : properties.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.form.fields.FormItemIcon::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	

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
     * @param formItemProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(FormItem formItemProperties) /*-{
        if (formItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(FormItem.@java.lang.Object::getClass()(), "setDefaultProperties", formItemProperties.@java.lang.Object::getClass()());
        }
        formItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var properties = formItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::getConfig()();
        $wnd.isc.FormItem.addProperties(properties);
    }-*/;

    // ***********************************************************



    public FormItem(String name) {
        setName(name);
        setAttribute("editorType", "FormItem");
        linkToInstanceUponCreate();
    }
    protected String scClassName;

    private java.util.LinkedHashMap<String, Object> keyMap = null;

    /**
     * Get the name of the underlying SmartClient class
     *
     * @return the SmartClient class name
     */
    public String getScClassName() {
        return scClassName;
    }

    /**
     * Set the name of the underlying SmartClient class. This is an advanced setting.
     *
     * @param scClassName the SmartClient class
     */
    public void setScClassName(String scClassName) {
        this.scClassName = scClassName;
    }
    
    /**
     * Returns the existing SGWT FormItem, or creates and returns one if none exist,
     * associated with the supplied {@link com.google.gwt.core.client.JavaScriptObject}.  If
     * the supplied object is not a SmartClient FormItem, a warning will be logged and null
     * returned; otherwise the FormItem will be returned as the appropriate subtype of SGWT
     * FormItem.
     *
     * @param jsObj SmartClient FormItem whose wrapper is wanted
     *
     * @return wrapping SGWT FormItem, of an appropriate subtype, or null
     */
    public static native <T extends RefDataClass> T asSGWTComponent(JavaScriptObject jsObj) /*-{
       if ($wnd.isc.isA.FormItem(jsObj)) {
           var retVal = @com.smartgwt.client.core.RefDataClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(jsObj);
           if (retVal == null) {
               // note that SC.REF will be set automatically on the JS object by the constructors that take a JavaScriptObject; no need to do it here
               retVal = @com.smartgwt.client.util.ObjectFactory::createFormItem(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(jsObj.getScClassName(), jsObj);
           }
           return retVal;
       }
       var className = $wnd.isc.isAn.Instance(jsObj) ? jsObj.getScClassName() : "none";
       @com.smartgwt.client.util.SC::logWarn(Ljava/lang/String;)("FormItem.asSGWTComponent(): " +
           "The supplied JS object must be a FormItem - actual class is " + className + ".");
       return null;
    }-*/;

    /**
     * Returns the JavaScript class name.
     * @return
     */
    public native String getClassName()/*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        return self.getClassName();
    }-*/;
    
    /**
     * Specify a notification method to fire when this formItem is initialized in JavaScript. This allows developers
     * to set up form item state dynamically when the item is created.
     * @param initHandler
     */
    public native void setInitHandler(com.smartgwt.client.widgets.form.fields.events.FormItemInitHandler initHandler) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.onInit = $debox($entry(function() {
            var itemJ = @com.smartgwt.client.widgets.form.fields.FormItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(this);
            return initHandler.@com.smartgwt.client.widgets.form.fields.events.FormItemInitHandler::onInit(Lcom/smartgwt/client/widgets/form/fields/FormItem;)(itemJ);
        }));
    }-*/;
    public void setAttribute(String attribute, String value) {
        if (!isCreated()) {
            JSOHelper.setAttribute(jsObj, attribute, value);
        } else {
            setProperty(attribute, value);
        }
    }

    public void setAttribute(String attribute, Map value) {
        if (!isCreated()) {
            JSOHelper.setAttribute(jsObj, attribute, JSOHelper.convertMapToJavascriptObject(value));
        } else {
            setProperty(attribute, JSOHelper.convertMapToJavascriptObject(value));
        }
    }

    public void setAttribute(String attribute, BaseClass[] value) {
        if (!isCreated()) {
            JSOHelper.setAttribute(jsObj, attribute, JSOHelper.convertToJavaScriptArray(value));
        } else {
            setProperty(attribute, JSOHelper.convertToJavaScriptArray(value));
        }
    }

    public void setAttribute(String attribute, DataClass[] value) {
        if (!isCreated()) {
            JSOHelper.setAttribute(jsObj, attribute, JSOHelper.convertToJavaScriptArray(value));
        } else {
            setProperty(attribute, JSOHelper.convertToJavaScriptArray(value));
        }
    }

    public void setAttribute(String attribute, Date value) {
        if (!isCreated()) {
            JSOHelper.setAttribute(jsObj, attribute, value);
        } else {
            setProperty(attribute, JSOHelper.convertToJavaScriptDate(value));
        }
    }

    public void setAttribute(String attribute, ValueEnum[] value) {
        if (!isCreated()) {
            JSOHelper.setAttribute(jsObj, attribute, value);
        } else {
            setProperty(attribute, JSOHelper.convertToJavaScriptArray(value));
        }
    }

    public void setAttribute(String attribute, DataClass value) {
        if (!isCreated()) {
            JSOHelper.setAttribute(jsObj, attribute, value.getJsObj());
        } else {
            setProperty(attribute, value.getJsObj());
        }
    }

    public void setAttribute(String attribute, BaseClass value) {
        if (!isCreated()) {
            JSOHelper.setAttribute(jsObj, attribute, value == null ? null : value.getOrCreateJsObj());
        } else {
            setProperty(attribute, value == null ? null : value.getOrCreateJsObj());
        }
    }

    public void setAttribute(String attribute, JavaScriptObject value) {
        if (!isCreated()) {
            JSOHelper.setAttribute(jsObj, attribute, value);
        } else {
            setProperty(attribute, value);
        }
    }

    public void setAttribute(String attribute, String[] value) {
        if (!isCreated()) {
            JSOHelper.setAttribute(jsObj, attribute, JSOHelper.convertToJavaScriptArray(value));
        } else {
            setProperty(attribute, JSOHelper.convertToJavaScriptArray(value));
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    // The setAttribute signatures for primitive types must exactly override those specified in
    // DataClass.java to prevent Java from directly invoking a DataClass API due to autoboxing.

    public void setAttribute(String attribute, boolean value) {
        if (!isCreated()) {
            JSOHelper.setAttribute(jsObj, attribute, value);
        } else {
            setProperty(attribute, value);
        }
    }
    public void setAttribute(String attribute, Boolean value) {
        if (!isCreated()) {
            JSOHelper.setAttribute(jsObj, attribute, value);
        } else {
            if (value == null) setNullProperty(attribute);
            else setProperty(attribute, value.booleanValue());
        }
    }

    public void setAttribute(String attribute, int value) {
        if (!isCreated()) {
            JSOHelper.setAttribute(jsObj, attribute, value);
        } else {
            setProperty(attribute, value);
        }
    }
    public void setAttribute(String attribute, Integer value) {
        if (!isCreated()) {
            JSOHelper.setAttribute(jsObj, attribute, value);
        } else {
            if (value == null) setNullProperty(attribute);
            else setProperty(attribute, value.intValue());
        }
    }

    public void setAttribute(String attribute, long value) {
        if (!isCreated()) {
            JSOHelper.setAttribute(jsObj, attribute, value);
        } else {
            setProperty(attribute, value);
        }
    }

    public void setAttribute(String attribute, Float value) {
        if (!isCreated()) {
            JSOHelper.setAttribute(jsObj, attribute, value);
        } else {
            if (value == null) setNullProperty(attribute);
            else setProperty(attribute, value.floatValue());
        }
    }

    public void setAttribute(String attribute, double value) {
        if (!isCreated()) {
            JSOHelper.setAttribute(jsObj, attribute, value);
        } else {
            setProperty(attribute, value);
        }
    }
    public void setAttribute(String attribute, Double value) {
        if (!isCreated()) {
            JSOHelper.setAttribute(jsObj, attribute, value);
        } else {
            if (value == null) setNullProperty(attribute);
            else setProperty(attribute, value.doubleValue());
        }
    }

    public void setAttribute(String attribute, int[] value) {
        if (!isCreated()) {
            JSOHelper.setAttribute(jsObj, attribute, JSOHelper.convertToJavaScriptArray(value));
        } else {
            setProperty(attribute, JSOHelper.convertToJavaScriptArray(value));
        }
    }
    public void setAttribute(String attribute, Integer[] value) {
        if (!isCreated()) {
            JSOHelper.setAttribute(jsObj, attribute, JSOHelper.convertToJavaScriptArray(value));
        } else {
            setProperty(attribute, JSOHelper.convertToJavaScriptArray(value));
        }
    }

    public void setAttribute(String attribute, double[] value) {
        if (!isCreated()) {
            JSOHelper.setAttribute(jsObj, attribute, JSOHelper.convertToJavaScriptArray(value));
        } else {
            setProperty(attribute, JSOHelper.convertToJavaScriptArray(value));
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////

    public String getAttribute(String attribute) {
        return getAttributeAsString(attribute);
    }

    public String getAttributeAsString(String property) {
        return (String)getAttributeAsObject(property, null);
    }

    public native Date getAttributeAsDate(String property)/*-{
        return this.@com.smartgwt.client.widgets.form.fields.FormItem::getAttributeAsObject(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(property, @com.smartgwt.client.util.JSOHelper::convertToJavaDate(Lcom/google/gwt/core/client/JavaScriptObject;));
    }-*/;

    public native Double getAttributeAsDouble(String property)/*-{
        return this.@com.smartgwt.client.widgets.form.fields.FormItem::getAttributeAsObject(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(property, @com.smartgwt.client.util.JSOHelper::toDouble(D));
    }-*/;

    public JavaScriptObject getAttributeAsJavaScriptObject(String property) {
        return (JavaScriptObject)getAttributeAsObject(property, null);
    }

    public native Integer getAttributeAsInt(String property)/*-{
        return this.@com.smartgwt.client.widgets.form.fields.FormItem::getAttributeAsObject(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(property, @com.smartgwt.client.util.JSOHelper::toInteger(I));
    }-*/;

    public native Float getAttributeAsFloat(String property)/*-{
        return this.@com.smartgwt.client.widgets.form.fields.FormItem::getAttributeAsObject(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(property, @com.smartgwt.client.util.JSOHelper::toFloat(F));
    }-*/;

    public Boolean getAttributeAsBoolean(String property) {
        return getAttributeAsBoolean(property, false);
    }

    public Boolean getAttributeAsBoolean(String property, boolean allowNull) {
        Boolean value =  _getAttributeAsBoolean(property);
        return value == null && !allowNull ? Boolean.FALSE : value;
    }
    
    private native Boolean _getAttributeAsBoolean(String property)/*-{       
        return this.@com.smartgwt.client.widgets.form.fields.FormItem::getAttributeAsObject(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(property, @com.smartgwt.client.util.JSOHelper::toBoolean(Z));
    }-*/;

    public native Object getAttributeAsObject(String property, JavaScriptObject convertToObject)/*-{
        var undef, ret, self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if(this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            ret = self.getProperty(property);
        } else {
            if (self[property] !== undef) {
                ret = self[property];
            } else {
                var scClassName = self["editorType"];
            	if(this.@com.smartgwt.client.widgets.form.fields.FormItem::scClassName!=null){
            		scClassName = this.@com.smartgwt.client.widgets.form.fields.FormItem::scClassName;
            	}
                if (scClassName != null && $wnd.isc[scClassName] != null) {
                    ret = $wnd.isc[scClassName].getInstanceProperty(property);
                }
            }
        }
        if (ret == null || ret === undef) return null;
        return convertToObject ? convertToObject(ret) : ret;
    }-*/;

    private native String getPropertyAsString(String property)/*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getProperty(property);
        return ret === undefined ? null : ret;
    }-*/;

    private native Date getPropertyAsDate(String property)/*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getProperty(property);
        return ret == null ? null : @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;

    private native Integer getPropertyAsInt(String property)/*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getProperty(property);
        return ret == null ? null : @com.smartgwt.client.util.JSOHelper::toInteger(I)(ret);
    }-*/;

    private native Double getPropertyAsDouble(String property)/*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getProperty(property);
        return ret == null ? null : @com.smartgwt.client.util.JSOHelper::toDouble(D)(ret);
    }-*/;

    private native Element getPropertyAsElement(String property)/*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getProperty(property);
        return ret === undefined ? null : ret;
    }-*/;

    private native JavaScriptObject getPropertyAsJSO(String property)/*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getProperty(property);
        return ret === undefined ? null : ret;
    }-*/;

    private native Float getPropertyAsFloat(String property)/*-{
        var self = self.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = widget.getProperty(property);
        return ret == null ? null : @com.smartgwt.client.util.JSOHelper::toFloat(F)(ret);
    }-*/;

    private native Boolean getPropertyAsBoolean(String property)/*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getProperty(property);
        return ret == null ? null : @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

    public native void setNullProperty(String property)/*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.setProperty(property, null);
    }-*/;

    public native void setProperty(String property, String value)/*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.setProperty(property, value);
    }-*/;

    public native void setProperty(String property, boolean value)/*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.setProperty(property, value);
    }-*/;

    public native void setProperty(String property, int value)/*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.setProperty(property, value);
    }-*/;

    public native void setProperty(String property, double value)/*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.setProperty(property, value);
    }-*/;

    public native void setProperty(String property, JavaScriptObject value)/*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.setProperty(property, value);
    }-*/;

    @Override
    public final void setJavaScriptObject(JavaScriptObject jsObj) {
        // warn if the underlying SC item is being replaced
        FormItem oldItem = (FormItem) RefDataClass.getRef(getJsObj());
        if (oldItem != null && oldItem != this) {
            oldItem.handleWarnOnEditorTypeConversion(oldItem, this);
            warnOnEditorTypeConversion = oldItem.warnOnEditorTypeConversion;
        }
        super.setJavaScriptObject(jsObj);
        JSOHelper.setObjectAttribute(jsObj, SC.REF, this);
        JSOHelper.setObjectAttribute(jsObj, SC.MODULE, BeanFactory.getSGWTModule());
        // You should not normally be able to reach this point without a SC FormItem instance,
        // but for now support it by not warning, and installing hook to relink SGWT wrapper.
        if (!JSOHelper.isScClassInstance(jsObj)) linkToInstanceUponCreate();
    }

    @Override
    public final native boolean isCreated()/*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        return !!(self && self.setValue);
    }-*/;

    protected final void error(String attribute, String value) throws IllegalStateException {
        error("Cannot change configuration property '" + attribute + "' to " + value + " now that form item " + id + " has been created.");
    }

    protected final void errorIfNotCreated(String property) throws IllegalStateException {
        if (!isCreated()) {
            throw new IllegalStateException("Cannot access property " + property + " before the form item has been created.");
        }
    }

    protected final void error(String message) throws IllegalStateException {
        if (!com.google.gwt.core.client.GWT.isScript()) {
            com.google.gwt.user.client.Window.alert("Error :" + message);
            throw new IllegalStateException(message);
        } else {
            SC.logWarn(message);
        }
    }

    /**
     * Sets the SmartClient constructor for the AutoChild named <code>autoChildName</code>.
     *
     * @param autoChildName the name of the AutoChild
     * @param className the SmartClient class name to use when constructing the AutoChild.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public native void setAutoChildConstructor(String autoChildName, String className) /*-{
        var self = this.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()();
        self[autoChildName + "Constructor"] = className;
    }-*/;

    /**
     * Sets the properties for creating a <code>Canvas</code> AutoChild named <code>autoChildName</code>.
     *
     * <p><code>properties</code> must not have already been created
     * ({@link com.smartgwt.client.widgets.BaseWidget#isCreated() properties.isCreated()}
     * must be <code>false</code>).
     *
     * <p><b>NOTE:</b> Overrides at override points are not applied to AutoChildren created from
     * <code>properties</code>; that is, if the Java {@link java.lang.Class} of <code>properties</code>
     * overrides a Smart&nbsp;GWT override point, the custom method implementation will not be called.
     *
     * @throws IllegalStateException if <code>properties</code> has been created.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public void setAutoChildProperties(String autoChildName, Canvas properties) 
        throws IllegalStateException 
    {
        if (properties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), "setAutoChildProperties",
                                                    properties.getClass());
        }
        properties.setConfigOnly(true);
        setAttribute(autoChildName + "Properties", 
                     JSOHelper.cleanProperties(properties.getConfig(), true));
    }

    /**
     * Sets the properties for creating a <code>FormItem</code> AutoChild named <code>autoChildName</code>.
     *
     * <p><code>properties</code> must not have already been created 
     * ({@link com.smartgwt.client.widgets.form.fields.FormItem#isCreated() properties.isCreated()}
     * must be <code>false</code>).
     *
     * <p><b>NOTE:</b> Overrides at override points are not applied to AutoChildren created from
     * <code>properties</code>; that is, if the Java {@link java.lang.Class} of <code>properties</code>
     * overrides a Smart&nbsp;GWT override point, the custom method implementation will not be called.
     *
     * @throws IllegalStateException if <code>properties</code> has been created.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public void setAutoChildProperties(String autoChildName, FormItem properties) 
        throws IllegalStateException 
    {
        if (properties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), "setAutoChildProperties",
                                                    properties.getClass());
        }
        properties.setConfigOnly(true);
        setAttribute(autoChildName + "Properties", properties.getEditorTypeConfig());
    }

    /**
     * Sets the properties for creating an AutoChild named <code>autoChildName</code>.
     *
     * <p><code>properties</code> must not have already been created 
     * ({@link com.smartgwt.client.tools.EditProxy#isCreated() properties.isCreated()}
     * must be <code>false</code>).
     *
     * @throws IllegalStateException if <code>properties</code> has been created.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public void setAutoChildProperties(String autoChildName, EditProxy properties) 
        throws IllegalStateException 
    {
        if (properties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), "setAutoChildProperties",
                                                    properties.getClass());
        }
        properties.setConfigOnly(true);
        setAttribute(autoChildName + "Properties", 
                     JSOHelper.cleanProperties(properties.getConfig(), true));
    }

    /**
     * Sets whether to create and show the AutoChild named <code>autoChildName</code>.
     * <p>
     * <b>NOTE:</b> This API is not valid for all AutoChildren because some AutoChildren cannot
     * be hidden without destroying the main functions of the component.
     *
     * @param autoChildName name of an AutoChild
     * @param visible whether to show the AutoChild
     */
    public void setAutoChildVisibility(String autoChildName, boolean visible) {
        setProperty("show" + Character.toUpperCase(autoChildName.charAt(0)) + autoChildName.substring(1), visible);
    }

    /**
     * Returns the <code>Canvas</code> AutoChild named <code>autoChildName</code> if already created.
     *
     * @param autoChildName name of an AutoChild to return.
     * @throws RuntimeException if the AutoChild is not a &#83;martClient <code>Canvas</code> object.
     */
    public native final Canvas getCanvasAutoChild(String autoChildName) /*-{
        var self = this.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()();
        var autoChildJS = self[autoChildName];
        if (autoChildJS == null) return null;
        if (!$wnd.isc.isA.Canvas(autoChildJS)) throw @java.lang.RuntimeException::new(Ljava/lang/String;)("The '" + autoChildName + "' AutoChild is not a Canvas.");

        // getCanvasAutoChild() should return the same Object.
        if (autoChildJS.__ref !== undefined) return autoChildJS.__ref;
        return (autoChildJS.__ref = @com.smartgwt.client.util.ObjectFactory::createCanvas(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(autoChildJS.getClassName(), autoChildJS));
    }-*/;

    /**
     * Returns the <code>FormItem</code> AutoChild named <code>autoChildName</code> if already created.
     *
     * @param autoChildName name of an AutoChild to return.
     * @throws RuntimeException if the AutoChild is not a &#83;martClient <code>FormItem</code> object.
     */
    public native final FormItem getFormItemAutoChild(String autoChildName) /*-{
        var self = this.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()();
        var autoChildJS = self[autoChildName];
        if (autoChildJS == null) return null;
        if (!$wnd.isc.isA.FormItem(autoChildJS)) throw @java.lang.RuntimeException::new(Ljava/lang/String;)("The '" + autoChildName + "' AutoChild is not a FormItem.");

        // getFormItemAutoChild() should return the same Object.
        if (autoChildJS.__ref !== undefined) return autoChildJS.__ref;
        return (autoChildJS.__ref = @com.smartgwt.client.util.ObjectFactory::createFormItem(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(autoChildJS.getClassName(), autoChildJS));
    }-*/;

    /**
     * Name for this form field. Must be unique within the form as well as a valid JavaScript identifier - see {@link
     * com.smartgwt.client.docs.FieldName} for details and how to check for validity. <P> The FormItem's name determines the
     * name of the property it edits within the form. <P> Note that an item must have a valid name or {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDataPath dataPath} in order for its value to be validated and/or
     * saved.
     *
     * @param name New name value. Default value is null
     * @see com.smartgwt.client.docs.FieldName FieldName 
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public void setName(String name) {
        assert name.indexOf(" ") == -1 : "Invalid FormItem name. Cannot use spaces in FormItem name.";
        setAttribute("name",              name);
        setAttribute("_autoAssignedName", false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.DynamicForm#getShowInlineErrors showInlineErrors} is true, where
     * should the error icon and text appear relative to the form item itself. Valid options are <code>"top"</code>,
     * <code>"bottom"</code>, <code>"left"</code> or <code>"right"</code>.<br> If unset the orientation will be derived
     * from {@link com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation}.
     *
     * @param errorOrientation errorOrientation Default value is null
     */
    public void setErrorOrientation(FormErrorOrientation errorOrientation) {
        setAttribute("errorOrientation", errorOrientation);
    }

    /**
     * The DynamicForm picks a field renderer based on the type of the field (and sometimes other attributes of the
     * field).
     *
     * @param type type Default value is "text"
     */
    public void setType(String type) {
        setAttribute("type", type);
    }

    /**
     * Number of columns that this item spans.   <P> The <code>colSpan</code> setting does not include the title shown
     * for items with {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle showTitle}:true, so the
     * effective <code>colSpan</code> is one higher than this setting for items that are showing a title and whose
     * {@link com.smartgwt.client.types.TitleOrientation} is either "left" or "right".
     *
     * @param colSpan colSpan Default value is 1
     */
    public void setColSpan(String colSpan) {
        setAttribute("colSpan", colSpan);
    }

    /**
     * Number of columns that this item spans.   <P> The <code>colSpan</code> setting does not include the title shown
     * for items with {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle showTitle} set to true, so the
     * effective <code>colSpan</code> is one higher than this setting for items that are showing a title and whose
     * {@link com.smartgwt.client.types.TitleOrientation} is either "left" or "right".
     *
     * @param colSpan colSpan Default value is 1
     */
    public void setColSpan(int colSpan) {
        setAttribute("colSpan", colSpan);
    }

    /**
     * The DynamicForm picks a field renderer based on the type of the field (and sometimes other attributes of the
     * field).
     *
     * @return the type
     */
    public String getType() {
        return getAttribute("type");
    }

    /**
     * Value used when no value is provided for this item. Note that whenever this item's value is cleared by the user
     * or set to <code>null</code> programmatically, it will be reverted to the <code>defaultValue</code>. Developers
     * should use the {@link com.smartgwt.client.widgets.form.DynamicForm#getValues values}  object if their intention
     * is to provide an initial value for a field in a form rather  than a value to use in place of <code>null</code>.
     *
     * @param defaultValue defaultValue Default value is null
     */
    public void setDefaultValue(String defaultValue) {
        setAttribute("defaultValue", defaultValue);
    }

    /**
     * Value used when no value is provided for this item. Note that whenever this item's value is cleared by the user
     * or set to <code>null</code> programmatically, it will be reverted to the <code>defaultValue</code>. Developers
     * should use the {@link com.smartgwt.client.widgets.form.DynamicForm#getValues values}  object if their intention
     * is to provide an initial value for a field in a form rather  than a value to use in place of <code>null</code>.
     *
     * @param defaultValue defaultValue Default value is null
     */
    public void setDefaultValue(Integer defaultValue) {
        setAttribute("defaultValue", defaultValue);
    }

    /**
     * Value used when no value is provided for this item. Note that whenever this item's value is cleared by the user
     * or set to <code>null</code> programmatically, it will be reverted to the <code>defaultValue</code>. Developers
     * should use the {@link com.smartgwt.client.widgets.form.DynamicForm#getValues values}  object if their intention
     * is to provide an initial value for a field in a form rather  than a value to use in place of <code>null</code>.
     *
     * @param defaultValue defaultValue Default value is null
     */
    public void setDefaultValue(Date defaultValue) {
        setAttribute("defaultValue", defaultValue);
    }

    /**
     * Value used when no value is provided for this item. Note that whenever this item's value is cleared by the user
     * or set to <code>null</code> programmatically, it will be reverted to the <code>defaultValue</code>. Developers
     * should use the {@link com.smartgwt.client.widgets.form.DynamicForm#getValues values}  object if their intention
     * is to provide an initial value for a field in a form rather  than a value to use in place of <code>null</code>.
     *
     * @param defaultValue defaultValue Default value is null
     */
    public void setDefaultValue(Boolean defaultValue) {
        setAttribute("defaultValue", defaultValue);
    }

    /**
     * Value used when no value is provided for this item. Note that whenever this item's value is cleared by the user
     * or set to <code>null</code> programmatically, it will be reverted to the <code>defaultValue</code>. Developers
     * should use the {@link com.smartgwt.client.widgets.form.DynamicForm#getValues values}  object if their intention
     * is to provide an initial value for a field in a form rather  than a value to use in place of <code>null</code>.
     *
     * @param defaultValue defaultValue Default value is null
     */
    public void setDefaultValue(Float defaultValue) {
        setAttribute("defaultValue", defaultValue);
    }
    
    /**
     * Value used when no value is provided for this item. Note that whenever this item's value is cleared by the user
     * or set to <code>null</code> programmatically, it will be reverted to the <code>defaultValue</code>. Developers
     * should use the {@link com.smartgwt.client.widgets.form.DynamicForm#getValues values}  object if their intention
     * is to provide an initial value for a field in a form rather  than a value to use in place of <code>null</code>.
     *
     * @param defaultValue defaultValue Default value is null
     */
    public void setDefaultValue(Double defaultValue) {
        setAttribute("defaultValue", defaultValue);
    }
   
    public void setDefaultValue(Object value) {
        if (value == null) {
        	setAttribute("defaultValue", (String) null);
        } else if (value instanceof String) {
            // To avoid GWT Issue 4301, check for a `String' instance and handle that specially.
            // http://forums.smartclient.com/showthread.php?t=8159#aStringObject
        	setDefaultValue((String)value);
        } else if (value instanceof CharSequence || value instanceof Character) {
        	setDefaultValue(value.toString());
        } else if (value instanceof Number) {
        	setDefaultValue( (Double) JSOHelper.doubleValue((Number) value));
        } else if (value instanceof Boolean) {
        	setDefaultValue(((Boolean) value).booleanValue());
        } else if (value instanceof Date) {
        	setDefaultValue((Date) value);
        } else if (value instanceof RelativeDate) {
        	setAttribute("defaultValue", ((RelativeDate) value).getValue());
        } else if (value instanceof ValueEnum) {
        	setAttribute("defaultValue",((ValueEnum) value).getValue());
        } else if (value.getClass().isArray()) {
            final Object jsArray;
            if (value instanceof Object[]) {
                jsArray = JSOHelper.convertToJavaScriptArray((Object[])value, false);
            } else if (value instanceof int[]) {
                jsArray = JSOHelper.convertToJavaScriptArray((int[])value);
            } else if (value instanceof double[]) {
                jsArray = JSOHelper.convertToJavaScriptArray((double[])value);
            } else if (value instanceof float[]) {
                jsArray = JSOHelper.convertToJavaScriptArray((float[])value);
            } else if (value instanceof boolean[]) {
                jsArray = JSOHelper.convertToJavaScriptArray((boolean[])value);
            } else if (value instanceof char[]) {
                jsArray = JSOHelper.convertToJavaScriptArray((char[])value);
            } else if (value instanceof byte[]) {
                jsArray = JSOHelper.convertToJavaScriptArray((byte[])value);
            } else if (value instanceof short[]) {
                jsArray = JSOHelper.convertToJavaScriptArray((short[])value);
            } else if (value instanceof long[]) {
                jsArray = JSOHelper.convertToJavaScriptArray((long[])value);
            } else {
                assert false : value.getClass() + " should not be an array class.";
                jsArray = value;
            }
            doSetDefaultValue(jsArray);
        } else if (value instanceof List) {
        	doSetDefaultValue(JSOHelper.convertToJavaScriptArray(((List<?>)value).toArray(), false));
        } else if (value instanceof Map) {
        	doSetDefaultValue(JSOHelper.convertMapToJavascriptObject((Map<?, ?>) value, false));
        } else {
        	doSetDefaultValue(value);
        }
    }
    
    private native void doSetDefaultValue(Object value) /*-{
	    var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
	    if(self.setValue) {
	        self.setDefaultValue(value);
	    } else {
	        self.defaultValue = value;
	    }
	}-*/;
    /**
     * Set the valueMap for this item.
     *
     * @param valueMap the value map
     * @see #getValueMapAsArray()
     */
    public void setValueMap(String... valueMap) {
        keyMap = null;
        if (!isCreated()) {
            setAttribute("valueMap", valueMap);
        } else {
            setValueMapMethod(JSOHelper.convertToJavaScriptArray(valueMap));
        }
    }

    /**
     * Set the valueMap for this item.
     *
     * @param valueMap the value map
     * @see #getValueMap()
     */
    public void setValueMap(Map valueMap) {

        keyMap = new java.util.LinkedHashMap<String, Object>();
        java.util.LinkedHashMap newMap = new java.util.LinkedHashMap();
        for (Object key : valueMap.keySet()) {
            if (key == null) {
                SC.logWarn("FormItem::setValueMap: dropping null key in Map");
                continue;
            }
            keyMap.put(key.toString(), key);
            newMap.put(key.toString(), valueMap.get(key));
        }

        if (!isCreated()) {
            setAttribute("valueMap", newMap);
        } else {
            setValueMapMethod(JSOHelper.convertMapToJavascriptObject(newMap));
        }
    }

    private native void setValueMapMethod(JavaScriptObject value) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.setValueMap(value);
    }-*/;

    /**
     * Set the valueIcons for this item.
     *
     * @param valueIcons mapping of logical values for this item to icon src URLs
     */
    public void setValueIcons(Map valueIcons) {
        setAttribute("valueIcons", valueIcons);
    }

    /**
     * Set default properties to use when editing.
     * <p>
     * The type of FormItem to use for editing is normally derived automatically from 
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getType type}, which is the 
     * data type of the field, by the rules explained 
     * {@link com.smartgwt.client.types.FormItemType here}.
     * <p>
     * <b>Note</b>: When you supply a custom FormItem via setEditorProperties(), you're really providing properties which are then used to create
     * multiple FormItems (eg, in grids, forms and trees) and there's an underlying limitation here where event handlers have to be written to
     * dynamically receive the actual FormItem rather than relying on "this" (because there's more than one "this").
     * This means you need to follow the special rules indicated for 
     * {@link com.smartgwt.client.data.DataSourceField#setEditorProperties(FormItem)}. 
     * As an alternative, you can use {@link #setEditorType(String)} or
     * {@link #setEditorType(Class)} to avoid these limitations, if you register
     * the FormItem subclass with the {@link com.smartgwt.client.docs.Reflection reflection mechanism}.
     *
     * @param editorProperties FormItem with the properties you want to set as defaults.
     */
    public void setEditorProperties(FormItem editorProperties) {
        if (editorProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), "setFilterButtonProperties", "FormItem");
        }                                                                       
        editorProperties.setConfigOnly(true);
        // only set the editorType attribute if the passed editorType is a concrete subclass of FormItem
        if (editorProperties.getClass() != FormItem.class) {
            String fiEditorType = editorProperties.getAttribute("editorType");
            // fallback to type if editorType is not specified
            if (fiEditorType == null) fiEditorType = editorProperties.getType();
            if (fiEditorType != null) setAttribute("editorType", fiEditorType);
        }
        JavaScriptObject editorConfig = editorProperties.getConfig();
        setAttribute("editorProperties", editorConfig);
    }

    /**
     * Synonym for {@link #setEditorProperties(FormItem)}.
     * 
     * @param editorType FormItem with the properties you want to set as defaults
     * @deprecated Renamed to {@link #setEditorProperties(FormItem)}. You can also consider using 
     *             {@link #setEditorType(Class)} or {@link #setEditorType(String)} instead.
     */
    public void setEditorType(FormItem editorType) {
        setEditorProperties(editorType);
    }

    /**
     * Set the FormItem subclass to use when editing. 
     * <p>
     * The type of {@link com.smartgwt.client.widgets.form.fields.FormItem} 
     * to use for editing is normally derived automatically from the 
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getType() type}, 
     * which is the data type of the field, by the rules explained 
     * {@link com.smartgwt.client.types.FormItemType here}.  
     * <p>
     * <b>Note</b>: The editorType must be registered for use with the
     * {@link com.smartgwt.client.docs.Reflection reflection mechanism}. 
     * By doing so, you avoid the limitations of {@link #setEditorProperties(FormItem)}.
     *
     * @param editorType the fully-qualified class name of a {@link com.smartgwt.client.widgets.form.fields.FormItem} subclass. 
     * @throws IllegalArgumentException if the editorType class has not been registered for use with the 
     *                                  {@link com.smartgwt.client.docs.Reflection reflection mechanism},
     *                                  or if it does not inherit from 
     *                                  {@link com.smartgwt.client.widgets.form.fields.FormItem}.
     */
    public void setEditorType(String editorType) {
        BeanFactory factory = BeanFactory.getFactory(editorType);
        if (factory == null) {
            throw new IllegalArgumentException("No BeanFactory has been registered for: " + editorType);
        } else if (!com.smartgwt.client.bean.BeanValueType.isAssignableFrom(FormItem.class, factory.getBeanClass())) {
            throw new IllegalArgumentException("The editorType: " + editorType + " does not inherit from FormItem");
        }
        setAttribute("editorType", editorType);
    }

    /**
     * Set the FormItem subclass to use when editing. 
     * <p>
     * The type of {@link com.smartgwt.client.widgets.form.fields.FormItem}
     * to use for editing is normally derived automatically from the 
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getType() type}, 
     * which is the data type of the field, by the rules explained 
     * {@link com.smartgwt.client.types.FormItemType here}.  
     * <p>
     * <b>Note</b>: The editorType must be registered for use with the
     * {@link com.smartgwt.client.docs.Reflection reflection mechanism}. 
     * By doing so, you avoid the limitations of {@link #setEditorProperties(FormItem)}.
     *
     * @param editorType a {@link com.smartgwt.client.widgets.form.fields.FormItem} subclass. 
     * @throws IllegalArgumentException if the editorType class has not been registered for use with the 
     *                                  {@link com.smartgwt.client.docs.Reflection reflection mechanism},
     *                                  or if it does not inherit from 
     *                                  {@link com.smartgwt.client.widgets.form.fields.FormItem}.
     */
    public void setEditorType(Class<? extends FormItem> editorType) {
        setEditorType(editorType.getName());
    }

    /**
     * Set the value of the form item.
     *
     * @param value the form item value
     */
    public native void setValue(int value) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if(self.setValue) {
            self.setValue(value);
        } else {
            self.value = value;
        }
    }-*/;

    /**
     * Set the value of the form item.
     *
     * @param value the form item value
     */
    public native void setValue(double value) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if(self.setValue) {
            self.setValue(value);
        } else {
            self.value = value;
        }
    }-*/;

    /**
     * Set the value of the form item.
     *
     * @param value the form item value
     */
    public native void setValue(Date value) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var valueJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(value);
        if(self.setValue) {
            self.setValue(valueJS);
        } else {
            self.value = valueJS;
        }
    }-*/;

    /**
     * Set the value of the form item.
     *
     * @param value the form item value
     */
    public native void setValue(String value) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        // Whenever passing a Java `String' to SmartClient, need to make sure that it is a
        // non-wrapped string value rather than a JS `String' object.
        value = (value == null ? null : String(value));
        if(self.setValue) {
            self.setValue(value);
        } else {
            self.value = value;
        }
    }-*/;

    /**
     * Set the value of the form item.
     *
     * @param value the form item value
     */
    public native void setValue(boolean value) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if(self.setValue) {
            self.setValue(value);
        } else {
            self.value = value;
        }
    }-*/;

    /**
     * Set the value of the form item as an object. GWT objects set as FormItem values are typically used
     * with {@link com.smartgwt.client.widgets.form.FormItemValueParser} and {@link com.smartgwt.client.widgets.form.FormItemValueFormatter}
     * API's for custom value parsing and formatting.
     *
     * @param value the form item value
     */
    public void setValue(Object value) {
        if (value == null) {
            doSetValue(null);
        } else if (value instanceof String) {
            // To avoid GWT Issue 4301, check for a `String' instance and handle that specially.
            // http://forums.smartclient.com/showthread.php?t=8159#aStringObject
            setValue((String)value);
        } else if (value instanceof CharSequence || value instanceof Character) {
            setValue(value.toString());
        } else if (value instanceof Number) {
            setValue(JSOHelper.doubleValue((Number) value));
        } else if (value instanceof Boolean) {
            setValue(((Boolean) value).booleanValue());
        } else if (value instanceof Date) {
            setValue((Date) value);
        } else if (value instanceof RelativeDate) {
            setValue(((RelativeDate) value).getValue());
        } else if (value instanceof ValueEnum) {
            setValue(((ValueEnum) value).getValue());
        } else if (value.getClass().isArray()) {
            final Object jsArray;
            if (value instanceof Object[]) {
                jsArray = JSOHelper.convertToJavaScriptArray((Object[])value, false);
            } else if (value instanceof int[]) {
                jsArray = JSOHelper.convertToJavaScriptArray((int[])value);
            } else if (value instanceof double[]) {
                jsArray = JSOHelper.convertToJavaScriptArray((double[])value);
            } else if (value instanceof float[]) {
                jsArray = JSOHelper.convertToJavaScriptArray((float[])value);
            } else if (value instanceof boolean[]) {
                jsArray = JSOHelper.convertToJavaScriptArray((boolean[])value);
            } else if (value instanceof char[]) {
                jsArray = JSOHelper.convertToJavaScriptArray((char[])value);
            } else if (value instanceof byte[]) {
                jsArray = JSOHelper.convertToJavaScriptArray((byte[])value);
            } else if (value instanceof short[]) {
                jsArray = JSOHelper.convertToJavaScriptArray((short[])value);
            } else if (value instanceof long[]) {
                jsArray = JSOHelper.convertToJavaScriptArray((long[])value);
            } else {
                assert false : value.getClass() + " should not be an array class.";
                jsArray = value;
            }
            doSetValue(jsArray);
        } else if (value instanceof List) {
            doSetValue(JSOHelper.convertToJavaScriptArray(((List<?>)value).toArray(), false));
        } else if (value instanceof Map) {
            doSetValue(JSOHelper.convertMapToJavascriptObject((Map<?, ?>) value, false));
        } else {
            doSetValue(value);
        }
    }

    private native void doSetValue(Object value) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if(self.setValue) {
            self.setValue(value);
        } else {
            self.value = value;
        }
    }-*/;

    /**
     * Returns this item's value with any valueMap applied to it - the value as currently displayed to the user.
     *
     * @return value displayed to the user
     */
    public native String getDisplayValue() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if(self.setValue) {
            var val = self.getDisplayValue();
            return val == null ? null : val.toString();
        } else {
            return '';
        }
    }-*/;

    /**
     * Returns this item's value with any valueMap applied to it - the value as currently displayed to the user.
     *
     * @return value displayed to the user
     */
    public native String getDisplayValue(String value) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if(self.setValue) {
            return self.getDisplayValue(value);
        } else {
            return '';
        }
    }-*/;

    /**
     * Output the drawn height for this item in pixels. Note: this is only reliable after this item has been written out into the DOM.
     *
     * @return height of the form item. returns 0 if the parent form has not been rendered.
     */
    public native int getVisibleHeight() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if(self.setValue) {
            return self.getVisibleHeight();
        } else {
            return 0;
        }
    }-*/;

    /**
     * Output the drawn width for this item in pixels. Note: this is only reliable after this item has been written out into the DOM.
     *
     * @return height of the form item. returns 0 if the parent form has not been rendered.
     */
    public native int getVisibleWidth() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if(self.setValue) {
            return self.getVisibleWidth();
        } else {
            return 0;
        }
    }-*/;

    /**
     * Return the page-level coordinates of this object.
     *
     * @return the page-level coordinates of this object
     */
    public native Rectangle getPageRect() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if(self.setValue) {
            var rect = self.getPageRect();
            return @com.smartgwt.client.core.Rectangle::new(IIII)(rect[0], rect[1],rect[2],rect[3]);
        } else {
            return null;
        }
    }-*/;

    /**
     * Return the coordinates of this object.
     *
     * @return the coordinates of this object
     */
    public native Rectangle getRect() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if(self.setValue) {
            var rect = self.getRect();
            return @com.smartgwt.client.core.Rectangle::new(IIII)(rect[0], rect[1],rect[2],rect[3]);
        } else {
            return null;
        }
    }-*/;

    public native Rectangle getIconRect(FormItemIcon icon) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var iconJS = icon.@com.smartgwt.client.core.DataClass::getJsObj()();
        if(self.getIconRect) {
            var rectJS = self.getIconRect(iconJS);
            return @com.smartgwt.client.core.Rectangle::new(IIII)(rectJS[0], rectJS[1], rectJS[2], rectJS[3]);
        } else {
            return null;
        }
    }-*/;

    public native Rectangle getIconPageRect(FormItemIcon icon) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var iconJS = icon.@com.smartgwt.client.core.DataClass::getJsObj()();
        if(self.getIconPageRect) {
            var rectJS = self.getIconPageRect(iconJS);
            return @com.smartgwt.client.core.Rectangle::new(IIII)(rectJS[0], rectJS[1], rectJS[2], rectJS[3]);
        } else {
            return null;
        }
    }-*/;

    /**
     * Returns the FormItem's config object suitable for use in API's that set the editorType
     *
     * @return the config object
     */
    public native JavaScriptObject getConfig() /*-{
        var config = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(this.@com.smartgwt.client.core.DataClass::getJsObj()(), true);
        // clean FormItem-specific properties not removed by cleanProperties()
        delete config.name;
        delete config._autoAssignedName;
        delete config.type;
        delete config.editorType;
        return config;
    }-*/;


    // getConfig() omits the 'editorType' attribute from the returned object which is desirable
    // in most cases. This method picks up the editorType if this is a subclass of FormItem so
    // if the config is used in a properties block, a TextItem (or whatever) instance will
    // generate javascript items of the expected SmartClient class.
    public JavaScriptObject getEditorTypeConfig () {
        JavaScriptObject editorConfig = getConfig();
        // only set editorType if this is an instance of a concrete subclass of FormItem
        if(!getClass().getName().equals(FormItem.class.getName())) {
            String fiEditorType = getAttribute("editorType");
            // fallback to type if editorType is not specified
            if (fiEditorType == null) fiEditorType = getType();
            if (fiEditorType != null) JSOHelper.setAttribute(editorConfig, "editorType", fiEditorType);
        }
        return editorConfig;
    }


    /**
     * This text is shown as a tooltip prompt when the cursor hovers over this item. Alias for {@link #setPrompt}.
     *
     * @param tooltip tooltip Default value is null
     */
    public void setTooltip(String tooltip) {
        setPrompt(tooltip);
    }

    /**
     * This text is shown as a tooltip prompt when the cursor hovers over this item. Alias for {@link #getPrompt}
     *
     * @return String
     */
    public String getTooltip() {
        return getPrompt();
    }

    /**
    * If this item has a specified <code>optionDataSource</code>, and this property is&#010 not null, this will be passed to the datasource as {@link com.smartgwt.client.rpc.RPCRequest} properties when&#010 performing the fetch operation on the dataSource to obtain a data-value to display-value&#010 mapping
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param rpcRequestProperties optionFilterContext Default value is null
    */
    public void setOptionFilterContext(RPCRequest rpcRequestProperties) {
        setAttribute("optionFilterContext", rpcRequestProperties);
    }

    /**
     * If this item has a specified <code>optionDataSource</code>, and this property is&#010 not null, this will be passed to the datasource as {@link com.smartgwt.client.rpc.RPCRequest} properties when&#010 performing the fetch operation on the dataSource to obtain a data-value to display-value&#010 mapping
     *
     * @return RPCRequest Properties
     *
     */
    public RPCRequest getOptionFilterContext()  {
        JavaScriptObject jsObj = getAttributeAsJavaScriptObject("optionFilterContext");
        return jsObj == null ? null : new RPCRequest(jsObj);
    }

    /**
    * If this item has a specified <code>optionDataSource</code>, and this property may be used&#010 to specify criteria to pass to the datasource when&#010 performing the fetch operation on the dataSource to obtain a data-value to display-value&#010 mapping
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param optionCriteria optionCriteria Default value is null
    */
    public void setOptionCriteria(Criteria optionCriteria) {
        setAttribute("optionCriteria", optionCriteria);
    }

    /**
     * If this item has a specified <code>optionDataSource</code>, and this property may be used&#010 to specify criteria to pass to the datasource when&#010 performing the fetch operation on the dataSource to obtain a data-value to display-value&#010 mapping
     *
     *
     * @return the option criteria
     *
     */
    public Criteria getOptionCriteria()  {
        JavaScriptObject jsObj = getAttributeAsJavaScriptObject("optionCriteria");
        return jsObj == null ? null : new Criteria(jsObj);
    }

    /**
     * Expression that's evaluated to see if an item should be dynamically hidden.
     *
     * The showIf  FormItemIfFunction is is evaluated whenever the form draws or redraws.
     *
     * @param showIf the showIf handler
     * @see FormItem#setRedrawOnChange(boolean)
     */
    public native void setShowIfCondition(FormItemIfFunction showIf) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.showIf = $debox($entry(function(item, value, form, values) {
            var itemJ = @com.smartgwt.client.widgets.form.fields.FormItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
            var valueJ =  $wnd.SmartGWT.convertToJavaType(value);
            var formJ = @com.smartgwt.client.widgets.form.DynamicForm::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(form);
            return showIf.@com.smartgwt.client.widgets.form.FormItemIfFunction::execute(Lcom/smartgwt/client/widgets/form/fields/FormItem;Ljava/lang/Object;Lcom/smartgwt/client/widgets/form/DynamicForm;)(itemJ, valueJ, formJ);
        }));
    }-*/;

    /**
     * Register a custom error formatter for this FormItem.
     *
     * @param errorFormatter the error formatter.
     */
    public native void setErrorFormatter(FormItemErrorFormatter errorFormatter) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.getErrorHTML = $debox($entry(function(errors) {
            if(!$wnd.isc.isA.Array(errors)){
                errors = [errors];
            }
            var errorsJ = @com.smartgwt.client.util.ConvertTo::arrayOfString(Lcom/google/gwt/core/client/JavaScriptObject;)(errors);
            return errorFormatter.@com.smartgwt.client.widgets.form.FormItemErrorFormatter::getErrorHTML([Ljava/lang/String;)(errorsJ);
        }));
    }-*/;

    /**
     * The transformer is called when a FormItem's value is about to change as the result of user interaction. This method fires after the user performed an
     * action that would change the value of this field, and allows the developer to modify / reformat the value before it gets validated / saved.
     * Fires before the {@link FormItem#addChangeHandler(com.smartgwt.client.widgets.form.fields.events.ChangeHandler) change} event.
     *
     * @param inputTransformer the input transformer
     */
    public native void setInputTransformer(FormItemInputTransformer inputTransformer) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.transformInput = $entry(function(form, item, value, oldValue) {
            var formJ = @com.smartgwt.client.widgets.form.DynamicForm::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(form);
            var itemJ = @com.smartgwt.client.widgets.form.fields.FormItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
            var valueJ =  $wnd.SmartGWT.convertToJavaType(value);
            var oldValueJ =  $wnd.SmartGWT.convertToJavaType(oldValue);
            var val =  inputTransformer.@com.smartgwt.client.widgets.form.FormItemInputTransformer::transformInput(Lcom/smartgwt/client/widgets/form/DynamicForm;Lcom/smartgwt/client/widgets/form/fields/FormItem;Ljava/lang/Object;Ljava/lang/Object;)(formJ, itemJ, valueJ, oldValueJ);
            return $wnd.SmartGWT.convertToPrimitiveType(val);
        });
    }-*/;

   /**
    * The FormItemHoverFormatter should return the HTML to display in a hover canvas when the user holds the mousepointer over this item.
    * Return null to suppress the hover canvas altogether.
    *
    * @param hoverFormatter the hover formatter
    */
    public native void setItemHoverFormatter(FormItemHoverFormatter hoverFormatter) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.itemHoverHTML = $debox($entry(function(item, form) {
            var formJ = @com.smartgwt.client.widgets.form.DynamicForm::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(form);
            var itemJ = @com.smartgwt.client.widgets.form.fields.FormItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
            return hoverFormatter.@com.smartgwt.client.widgets.form.FormItemHoverFormatter::getHoverHTML(Lcom/smartgwt/client/widgets/form/fields/FormItem;Lcom/smartgwt/client/widgets/form/DynamicForm;)(itemJ, formJ);
        }));
    }-*/;

    /**
     * The <code>FormItemHoverFormatter</code> should return the HTML to display in a hover canvas
     * when the user holds the mouse pointer over this item's title and the title is clipped. Return
     * null to suppress the hover canvas altogether.
     *
     * @param hoverFormatter the hover formatter
     * @see com.smartgwt.client.widgets.form.DynamicForm#titleClipped(com.smartgwt.client.widgets.form.fields.FormItem)
     */
    public native void setItemTitleHoverFormatter(FormItemHoverFormatter hoverFormatter) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.titleHoverHTML = $debox($entry(function(item, form) {
            var formJ = @com.smartgwt.client.widgets.form.DynamicForm::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(form);
            var itemJ = @com.smartgwt.client.widgets.form.fields.FormItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
            return hoverFormatter.@com.smartgwt.client.widgets.form.FormItemHoverFormatter::getHoverHTML(Lcom/smartgwt/client/widgets/form/fields/FormItem;Lcom/smartgwt/client/widgets/form/DynamicForm;)(itemJ, formJ);
        }));
    }-*/;

    /**
     * Synonym for {@link #setItemTitleHoverFormatter(FormItemHoverFormatter)}.
     * @param hoverFormatter the hover formatter
     */
    public void setTitleHoverFormatter(FormItemHoverFormatter hoverFormatter) {
        setItemTitleHoverFormatter(hoverFormatter);
    }

    /**
     * The <code>FormItemHoverFormatter</code> should return the HTML to display in a hover canvas
     * when the user holds the mouse pointer over this item's value and the value is clipped. Return
     * null to suppress the hover canvas altogether.
     *
     * @param hoverFormatter the hover formatter
     * @see #valueClipped()
     */
    public native void setItemValueHoverFormatter(FormItemHoverFormatter hoverFormatter) /*-{
         var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
         self.valueHoverHTML = $debox($entry(function(item, form) {
             var formJ = @com.smartgwt.client.widgets.form.DynamicForm::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(form);
             var itemJ = @com.smartgwt.client.widgets.form.fields.FormItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
             return hoverFormatter.@com.smartgwt.client.widgets.form.FormItemHoverFormatter::getHoverHTML(Lcom/smartgwt/client/widgets/form/fields/FormItem;Lcom/smartgwt/client/widgets/form/DynamicForm;)(itemJ, formJ);
         }));
     }-*/;

    /**
     * Synonym for {@link #setItemValueHoverFormatter(FormItemHoverFormatter)}.
     * @param hoverFormatter the hover formatter
     */
    public void setValueHoverFormatter(FormItemHoverFormatter hoverFormatter) {
        setItemValueHoverFormatter(hoverFormatter);
    }

    /**
     * A reference to the FormItem's DynamicForm.
     * <p>
     * <b>Note that you must treat this as a read-only reference to the from</b>
     *
     * @return the form
     */
    public native DynamicForm getForm() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if(self.form) {
            return @com.smartgwt.client.widgets.form.DynamicForm::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(self.form);
        } else {
            return null;
        }
    }-*/;

    /**
     * Return the value tracked by this form item. If this item has multiple:true, then either
     * null or a {@link java.util.List} or {@link com.smartgwt.client.data.RecordList} instance
     * is returned.
     *
     * <P> Note that for FormItems that have a ValueMap or where a {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#formatValue formatter} has been defined, <code>getValue()</code>
     * returns the underlying value of the FormItem, not the displayed value.
     *
     * @return value of this element
     */
    public Object getValue() {
        Object value = _getValue();
        if (keyMap != null && keyMap.containsKey(value)) {
            value = keyMap.get(value);
        }
        return value;
    }

    // In some cases, we want getValue() to automatically return a RecordList instance. We do
    // this when the field has multiple:true and the value:
    //  1. Is already a RecordList instance.
    //  2. Is an array and the first element:
    //      a. Has a wrapper (__ref) that is an instance of Record; or
    //      b. Is a plain JS object with no wrapper and not a POJO.
    //  3. Is a single object and:
    //      a. Has a wrapper that is an instance of RecordList or Record; or
    //      b. Is a plain JS object with no wrapper and not a POJO.
    private static native boolean shouldMakeRecordList(Object obj) /*-{
        if ($wnd.isc.isAn.Object(obj)) {
            var objJ = obj[@com.smartgwt.client.util.SC::REF];
            if (@com.smartgwt.client.data.Record::isARecord(Ljava/lang/Object;)(objJ)) {
                return true;
            } else if (objJ == null && !$wnd.isc.isAn.Array(obj) && @com.smartgwt.client.util.JSOHelper::isJSO(Ljava/lang/Object;)(obj)) {
                return true;
            }
        }
        return false;
    }-*/;

    public native Object _getValue() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret;
        if (self.setValue) {
            ret = self.getValue();
        } else {
            ret = self.value;
        }
        // Pass an explicit null to $wnd.SmartGWT.convertToJavaType() to prevent conversion of
        // any JS array to Java because a previous comment claims that here it should "return
        // JS arrays identically."  The impact on the code below that checks isc.isAn.Array()
        // was likely mitigated by our previous isc.isAn.Array() implementation - the current
        // implementation returns false for all Java Arrays, yielding a change in behavior.
        ret = $wnd.SmartGWT.convertToJavaType(ret, null);

        // Check if we want to return a List or RecordList. The field must have multiple:true
        // and `ret' must not already be a RecordList instance.
        if (self.multiple && !@com.smartgwt.client.data.RecordList::isARecordList(Ljava/lang/Object;)(ret)) {
            var elem0;
            if ($wnd.isc.isAn.Array(ret)) {
                elem0 = (ret.length == 0 ? null : ret[0]);
                // if a Java array such as Object[] has been passed, convert it to a JSO Array
                if ($wnd.SmartGWT.isNativeJavaObject(ret) && @com.smartgwt.client.util.JSOHelper::isJavaArray(Ljava/lang/Object;)(ret)) {
                    ret = @com.smartgwt.client.util.JSOHelper::arrayConvert([Ljava/lang/Object;)(ret);
                }
                if (@com.smartgwt.client.widgets.form.fields.FormItem::shouldMakeRecordList(Ljava/lang/Object;)(elem0)) {
                    ret = @com.smartgwt.client.data.RecordList::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
                } else {
                    ret = @com.smartgwt.client.util.JSOHelper::convertToList(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
                }
            } else if (ret != null) {
                elem0 = ret;
                var elem0J = elem0[@com.smartgwt.client.util.SC::REF];
                if (@com.smartgwt.client.data.RecordList::isARecordList(Ljava/lang/Object;)(elem0J)) {
                    ret = elem0J;
                } else {
                    if (@com.smartgwt.client.widgets.form.fields.FormItem::shouldMakeRecordList(Ljava/lang/Object;)(elem0)) {
                        ret = @com.smartgwt.client.data.RecordList::new()();
                        var retJS = ret.@com.smartgwt.client.data.RecordList::getOrCreateJsObj()();
                        retJS.push(elem0);
                    } else {
                        // Bypass the overhead of calling JSOHelper.convertToList() on a newly-created
                        // JS array containing only `elem0'.
                        ret = @java.util.ArrayList::new(I)(1);
                        ret.@java.util.ArrayList::add(Ljava/lang/Object;)($wnd.SmartGWT.convertToJavaObject(elem0, false, false));
                    }
                }
            }
        }
        return ret;
    }-*/;

    public native RecordList getValueAsRecordList() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret;
        if (self.setValue) {
            ret = self.getValue();
        } else {
            ret = self.value;
        }
        // If it's already a JS array, don't call 'convertToJavaType' - we have a RecordList
        // constructor which can handle a JS array
        // Otherwise attempt a conversion in case this is something more exotic which will
        // result in an existing Java List, etc
        if (!$wnd.isc.isAn.Array(ret)) {
        	ret = $wnd.SmartGWT.convertToJavaType(ret);
        }
        if (ret == null) return null;
        if (@com.smartgwt.client.util.JSOHelper::isJavaList(Ljava/lang/Object;)(ret)) {
            return @com.smartgwt.client.data.RecordList::new(Ljava/util/List;)(ret);
        } else if ($wnd.isc.isAn.Array(ret)) {
            return @com.smartgwt.client.data.RecordList::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        }
        return ret;
    }-*/;

    /**
     * Optional {@link FormItemValueFormatter}, if provided, is evaluated to get the
     * display value to show for this form items underlying data value. If you are considering using this method, 
     * you should first consider using {@link com.smartgwt.client.widgets.form.fields.FormItem#setFormat FormItem.setFormat}, 
     * which provides for simple and flexible declarative 
     * formatting of dates, times and numbers, without the need to write formatting code.
     * <P> 
     * This provides a way to perform a more complex data
     * to display value manipulation  than a simple {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueMap
     * valueMap}. Note that by default this formatter will only be applied to static displays such
     * as {@link com.smartgwt.client.widgets.form.fields.StaticTextItem} or {@link com.smartgwt.client.widgets.form.fields.SelectItem}, 
     * and does not apply to values displayed in a freely editable text entry field (such as a
     * {@link com.smartgwt.client.widgets.form.fields.TextItem} or {@link com.smartgwt.client.widgets.form.fields.TextAreaItem}), unless 
     * {@link com.smartgwt.client.widgets.form.fields.TextItem#setFormatOnBlur(java.lang.Boolean)} is set to <code>true</code>, 
     * which causes this formatter to be applied while the item does not have focus, and then be cleared when the user moves focus to 
     * the text field.<P>
     * See also {@link com.smartgwt.client.widgets.form.fields.FormItem#setEditorValueFormatter(com.smartgwt.client.widgets.form.FormItemValueFormatter)} and 
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#setEditorValueParser(com.smartgwt.client.widgets.form.FormItemValueParser)}.
     *
     * @param formatter the FormItemValueFormatter
     */
    public native void setValueFormatter(FormItemValueFormatter formatter) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.formatValue = $debox($entry(function(value, record, form, item) {
            var valueJ =  $wnd.SmartGWT.convertToJavaType(value);
            var formJ = @com.smartgwt.client.widgets.form.DynamicForm::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(form);
            var itemJ = @com.smartgwt.client.widgets.form.fields.FormItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
            var recordJ = @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            return formatter.@com.smartgwt.client.widgets.form.FormItemValueFormatter::formatValue(Ljava/lang/Object;Lcom/smartgwt/client/data/Record;Lcom/smartgwt/client/widgets/form/DynamicForm;Lcom/smartgwt/client/widgets/form/fields/FormItem;)(valueJ, recordJ, formJ, itemJ);
        }));
    }-*/;

    /**
     * An optional {@link com.smartgwt.client.widgets.form.FormItemValueFormatter} to map this item's current data value  to a
     * display value. <P> Note that this only applies to items which show a free-form entry area, such as a {@link
     * com.smartgwt.client.widgets.form.fields.TextItem} or {@link com.smartgwt.client.widgets.form.fields.TextAreaItem}. For
     * display values which will not be directly  manipulated by the user, use {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setValueFormatter(com.smartgwt.client.widgets.form.FormItemValueFormatter)} instead. <P> See also {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setEditorValueParser(com.smartgwt.client.widgets.form.FormItemValueParser)}.
     *
     * @param formatter the FormItemValueFormatter
     *
     */
    public native void setEditorValueFormatter(FormItemValueFormatter formatter) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.formatEditorValue = $debox($entry(function(value, record, form, item) {
            var valueJ =  $wnd.SmartGWT.convertToJavaType(value);
            var formJ = @com.smartgwt.client.widgets.form.DynamicForm::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(form);
            var itemJ = @com.smartgwt.client.widgets.form.fields.FormItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
            var recordJ = @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            return formatter.@com.smartgwt.client.widgets.form.FormItemValueFormatter::formatValue(Ljava/lang/Object;Lcom/smartgwt/client/data/Record;Lcom/smartgwt/client/widgets/form/DynamicForm;Lcom/smartgwt/client/widgets/form/fields/FormItem;)(valueJ, recordJ, formJ, itemJ);
        }));
   }-*/;

    /**
     * An optional {@link com.smartgwt.client.widgets.form.FormItemValueParser} to map a user-entered display value to a data
     * value for storage.  This method only applies to form items which show a free-form text entry area, such at the {@link
     * com.smartgwt.client.widgets.form.fields.TextItem} or {@link com.smartgwt.client.widgets.form.fields.TextAreaItem}. <P>
     * See also {@link com.smartgwt.client.widgets.form.fields.FormItem#formatEditorValue}
     *
     * @param valueParser the FormItemValueParser
     */
    public native void setEditorValueParser(FormItemValueParser valueParser) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.parseEditorValue = $debox($entry(function(value, form, item) {
            var formJ = @com.smartgwt.client.widgets.form.DynamicForm::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(form);
            var itemJ = @com.smartgwt.client.widgets.form.fields.FormItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
            var val = valueParser.@com.smartgwt.client.widgets.form.FormItemValueParser::parseValue(Ljava/lang/String;Lcom/smartgwt/client/widgets/form/DynamicForm;Lcom/smartgwt/client/widgets/form/fields/FormItem;)(value, formJ, itemJ);
            return $wnd.SmartGWT.convertToPrimitiveType(val);
        }));
    }-*/;

    /**
     * Set the FormItem Value Icon mapper that allows the developer to specify the image source for an icon to be displayed for the current form item value.
     * Takes precedence over {@link com.smartgwt.client.widgets.form.fields.FormItem#setValueIcons(java.util.Map)}.
     *
     * @param valueIconMapper the valueIconMapper
     */
    public native void setValueIconMapper(ValueIconMapper valueIconMapper)/*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.getValueIcon = $debox($entry(function(value) {
            var valueJ =  $wnd.SmartGWT.convertToJavaType(value);
            return valueIconMapper.@com.smartgwt.client.widgets.form.ValueIconMapper::getValueIcon(Ljava/lang/Object;)(valueJ);
        }));
    }-*/;


    /**
     * Fields of type <code>"date"</code> or <code>"time"</code> will be edited using a {@link
     * com.smartgwt.client.widgets.form.fields.DateItem} or {@link com.smartgwt.client.widgets.form.fields.TimeItem} by
     * default. <P> However this can be overridden - for <code>canEdit:false</code> fields, a {@link
     * com.smartgwt.client.widgets.form.fields.StaticTextItem} is used by default, and the developer can always specify  a
     * custom {@link com.smartgwt.client.widgets.form.fields.FormItem#getEditorType editorType} as well as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getType data type}. <P> For fields of type <code>"date"</code>, set
     * this property to a valid {@link com.smartgwt.client.types.DateDisplayFormat} to specify how the date should be
     * formatted. <br> For fields of type <code>"time"</code>, set this property to a valid  {@link
     * com.smartgwt.client.types.timeFormatter timeFormatter} to specify how the time should be formatted. <br> Note that if
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getDateFormatter dateFormatter} or {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTimeFormatter timeFormatter} are specified they will take precedence
     * over this setting. <P> If this field is of type <code>"date"</code> and is editable, the  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getInputFormat inputFormat} may be used to specify how user-edited date
     * strings will be parsed.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param displayFormat displayFormat Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setInputFormat
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setDateFormatter
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setTimeFormatter
     */
    public void setDisplayFormat(DateDisplayFormat displayFormat) {
        setAttribute("displayFormat", displayFormat.getValue());
    }

    /**
     * Fields of type <code>"date"</code> or <code>"time"</code> will be edited using a {@link
     * com.smartgwt.client.widgets.form.fields.DateItem} or {@link com.smartgwt.client.widgets.form.fields.TimeItem} by
     * default. <P> However this can be overridden - for <code>canEdit:false</code> fields, a {@link
     * com.smartgwt.client.widgets.form.fields.StaticTextItem} is used by default, and the developer can always specify  a
     * custom {@link com.smartgwt.client.widgets.form.fields.FormItem#getEditorType editorType} as well as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getType data type}. <P> For fields of type <code>"date"</code>, set
     * this property to a valid {@link com.smartgwt.client.types.DateDisplayFormat} to specify how the date should be
     * formatted. <br> For fields of type <code>"time"</code>, set this property to a valid  {@link
     * com.smartgwt.client.types.timeFormatter timeFormatter} to specify how the time should be formatted. <br> Note that if
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getDateFormatter dateFormatter} or {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTimeFormatter timeFormatter} are specified they will take precedence
     * over this setting. <P> If this field is of type <code>"date"</code> and is editable, the  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getInputFormat inputFormat} may be used to specify how user-edited date
     * strings will be parsed.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param displayFormat displayFormat Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setInputFormat
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setDateFormatter
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setTimeFormatter
     */
    public void setDisplayFormat(TimeFormatter displayFormat) {
        setAttribute("displayFormat", displayFormat.getValue());
    }

    /**
     * When a dynamic form is editing an advanced criteria object via {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setValuesAsCriteria DynamicForm.setValuesAsCriteria}, this predicate is used
     * to determine which sub-criteria apply to which form item(s). <P> This method will be called on each item, and passed the
     * sub-criterion of the AdvancedCriteria object. It should return true if the item can edit the criterion, otherwise false.
     * If it returns true, setValuesAsCriteria() will call  {@link
     * com.smartgwt.client.widgets.form.FormItemCriterionSetter#setCriterion FormItemCriterionSetter.setCriterion} from
     * the registered {@link com.smartgwt.client.widgets.form.fields.FormItem#setCriterionSetter FormItemCriterionSetter}
     * to actually apply the criterion to
     * the form item, and {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria
     * DynamicForm.getValuesAsCriteria} can subsequently retrieve the edited criterion by calling {@link
     * com.smartgwt.client.widgets.form.FormItemCriterionGetter#getCriterion FormItemCriterionGetter.getCriterion} from
     * the registered {@link com.smartgwt.client.widgets.form.fields.FormItem#setCriterionGetter FormItemCriterionGetter}.
     * <P> Default implementation will
     * return true if the criterion <code>fieldName</code> and <code>operator</code> match the fieldName and operator (or
     * default operator) for this item.
     * @param predicate the predicate to determine the form items that can edit the criterion in question
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public native void setCanEditCriterionPredicate(FormItemCanEditCriterionPredicate predicate) /*-{
        var me = this,
            self = me.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.canEditCriterion = $entry(function (criterion) {
            var itemJS = this,
            	itemJ = @com.smartgwt.client.widgets.form.fields.FormItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(itemJS),
            	formJ = @com.smartgwt.client.widgets.form.DynamicForm::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(itemJS.form),
                criterionJ = (criterion == null ? null : @com.smartgwt.client.data.Criterion::new(Lcom/google/gwt/core/client/JavaScriptObject;)(criterion));
            return predicate.@com.smartgwt.client.widgets.form.FormItemCanEditCriterionPredicate::canEditCriterion(Lcom/smartgwt/client/widgets/form/DynamicForm;Lcom/smartgwt/client/widgets/form/fields/FormItem;Lcom/smartgwt/client/data/Criterion;)(formJ, itemJ, criterionJ);
        });
    }-*/;

    /**
     * Calls the {@link com.smartgwt.client.widgets.form.FormItemCanEditCriterionPredicate.canEditCriterion canEditCriterion()}
     * method of the {@link com.smartgwt.client.widgets.form.FormItemCanEditCriterionPredicate FormItemCanEditCriterionPredicate}
     * that is registered with this field.
     * @param criterion sub-criterion from an AdvancedCriteria object
     *
     * @return return true if this item can edit the criterion in question.
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public final native Boolean canEditCriterion(Criterion criterion) /*-{
        if (criterion == null) {
            return null;
        } else {
            var self = this.@com.smartgwt.client.core.DataClass::getJsObj()(),
                retVal = self.canEditCriterion(criterion.@com.smartgwt.client.core.DataClass::getJsObj()());
            return (retVal == null ? null : @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal));
        }
    }-*/;

    /**
     * Provides a specialized criterion from this formItem when creating an AdvancedCriteria
     * via {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria DynamicForm.getValuesAsCriteria}. <P> This
     * API is provided to allow you to specify a more complex criterion than the  "field-operator-value" criterions that are
     * built-in.  Note that the built-in behavior is generally quite flexible and powerful enough for most requirements.  An
     * example of a case where you might want to override this method is if you wanted to implement a date range  selection
     * (ie, date &gt; x AND date &lt; y) on a form that was combining its other criteria  fields with an "or" operator. <P>
     * Note that this method is part of the criteria editing subsystem: if overridden, it is likely that you will want to also
     * override {@link com.smartgwt.client.widgets.form.fields.FormItem#hasAdvancedCriteria FormItem.hasAdvancedCriteria} to
     * ensure this method is called by the form, and to support editing of existing advanced criteria you may also need to
     * set the {@link com.smartgwt.client.widgets.form.fields.FormItem#setCanEditCriterionPredicate FormItemCanEditCriterionPredicate}
     * and the {@link com.smartgwt.client.widgets.form.fields.FormItem#setCriterionSetter FormItemCriterionSetter}.
     * <P> The default implementation
     * will return a criterion including the form item value, fieldName and specified {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOperator operator}, or a default operator derived from the form item
     * data type if no explicit operator is specified.
     * @param getter provides a method to get a criterion object based on this field's current edited value(s).
     *
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public native void setCriterionGetter(FormItemCriterionGetter getter) /*-{
        var me = this,
            self = me.@com.smartgwt.client.core.DataClass::getJsObj()();
    	self.useAdvancedCriteria = true;
        self.getCriterion = $entry(function (textMatchStyle) {
            var itemJS = this,
             	itemJ = @com.smartgwt.client.widgets.form.fields.FormItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(itemJS),
             	formJ = @com.smartgwt.client.widgets.form.DynamicForm::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(itemJS.form),
                textMatchStyleJ = @com.smartgwt.client.widgets.form.fields.FormItem::getTextMatchStyleForValue(Ljava/lang/String;)(textMatchStyle),
                criterionJ;
            if (textMatchStyleJ != null) {
                criterionJ = getter.@com.smartgwt.client.widgets.form.FormItemCriterionGetter::getCriterion(Lcom/smartgwt/client/widgets/form/DynamicForm;Lcom/smartgwt/client/widgets/form/fields/FormItem;Lcom/smartgwt/client/types/TextMatchStyle;)(formJ, itemJ, textMatchStyleJ);
            } else {
                criterionJ = getter.@com.smartgwt.client.widgets.form.FormItemCriterionGetter::getCriterion(Lcom/smartgwt/client/widgets/form/DynamicForm;Lcom/smartgwt/client/widgets/form/fields/FormItem;)(formJ, itemJ);
            }
            return (criterionJ == null ? null : criterionJ.@com.smartgwt.client.core.DataClass::getJsObj()());
        });
    }-*/;

    /**
     * Calls the {@link com.smartgwt.client.widgets.form.FormItemCriterionGetter.getCriterion getCriterion()} method
     * of the {@link com.smartgwt.client.widgets.form.FormItemCriterionGetter FormItemCriterionGetter}
     * that is registered with this field.
     * @return criterion object based on this fields current edited value(s).
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public final native Criterion getCriterion() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getCriterion();
        if (ret == null) return null;
        var retVal = @com.smartgwt.client.core.RefDataClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        if (retVal == null) {
            retVal = @com.smartgwt.client.data.Criterion::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        }
        return retVal;
    }-*/;

    /**
     * Calls the {@link com.smartgwt.client.widgets.form.FormItemCriterionGetter.getCriterion getCriterion()} method
     * of the {@link com.smartgwt.client.widgets.form.FormItemCriterionGetter FormItemCriterionGetter}
     * that is registered with this field.
     * @param textMatchStyle If passed assume the textMatchStyle   will be used when performing a fetch operation with these criteria. This may
     * impact   the criterion's operator property.
     *
     * @return criterion object based on this fields current edited value(s).
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public final native Criterion getCriterion(TextMatchStyle textMatchStyle) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getCriterion(textMatchStyle == null ? null : textMatchStyle.@com.smartgwt.client.types.TextMatchStyle::getValue()());
        if (ret == null) return null;
        var retVal = @com.smartgwt.client.core.RefDataClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        if (retVal == null) {
            retVal = @com.smartgwt.client.data.Criterion::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        }
        return retVal;
    }-*/;

    private static TextMatchStyle getTextMatchStyleForValue(String value) {
        for (TextMatchStyle textMatchStyle : TextMatchStyle.values()) {
            if (textMatchStyle.getValue().equals(value)) {
                return textMatchStyle;
            }
        }
        return null;
    }

    /**
     * Set the method to update this form item to reflect a criterion object from within an AdvancedCriteria. Called by {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setValuesAsCriteria DynamicForm.setValuesAsCriteria} when the
     * registered {@link com.smartgwt.client.widgets.form.fields.FormItem#setCanEditCriterionPredicate FormItemCanEditCriterionPredicate}
     * returns true for this item.
     * <P> Default implementation simply calls {@link com.smartgwt.client.widgets.form.fields.FormItem#setValue
     * FormItem.setValue} with the <code>value</code> of the criterion passed in
     * @param setter provides a method to update this field with the edited criterion
     */
    public native void setCriterionSetter(FormItemCriterionSetter setter) /*-{
        var me = this,
            self = me.@com.smartgwt.client.core.DataClass::getJsObj()();
     	self.useAdvancedCriteria = true;
        self.setCriterion = $entry(function (criterion) {
        	var itemJS = this,
        		itemJ = @com.smartgwt.client.widgets.form.fields.FormItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(itemJS),
        		formJ = @com.smartgwt.client.widgets.form.DynamicForm::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(itemJS.form),
                criterionJ = (criterion == null ? null : @com.smartgwt.client.data.Criterion::new(Lcom/google/gwt/core/client/JavaScriptObject;)(criterion));
            setter.@com.smartgwt.client.widgets.form.FormItemCriterionSetter::setCriterion(Lcom/smartgwt/client/widgets/form/DynamicForm;Lcom/smartgwt/client/widgets/form/fields/FormItem;Lcom/smartgwt/client/data/Criterion;)(formJ, itemJ, criterionJ);
        });
    }-*/;

    /**
     * Calls the {@link com.smartgwt.client.widgets.form.FormItemCriterionSetter.setCriterion setCriterion()} method
     * of the {@link com.smartgwt.client.widgets.form.FormItemCriterionSetter FormItemCriterionSetter}
     * that is registered with this field.
     * @param criterion criterion to edit
     */
    public final native void setCriterion(Criterion criterion) /*-{
        if (criterion != null) {
            var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            self.setCriterion(criterion.@com.smartgwt.client.core.DataClass::getJsObj()());
        }
    }-*/;

    /**
     * Set a specific ARIA state mapping for this form item. Usually this does not need to be manually
     * set. See {@link com.smartgwt.docs.Accessibility}.
     * @param stateName
     * @param stateValue
     * @throws IllegalStateException ARIA state cannot be changed after the form item has been created.
     */
    public void setAriaState (String stateName, Object stateValue) throws IllegalStateException {
        JavaScriptObject ariaState = JSOHelper.getAttributeAsJavaScriptObject(getJsObj(), "ariaState");
        if (ariaState == null) ariaState = JSOHelper.createObject();
        if (isCreated()) {
            error("ariaState", String.valueOf(ariaState));
        } else {
            JSOHelper.setAttribute(ariaState, stateName, stateValue);
            setAttribute("ariaState", ariaState);
        }
    }
    
    /**
     * Returns any validation errors for this field.  If no errors are present, will return null.
     * @return error messages for the field.
     */
    public native String[] getErrors() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!$wnd.isc.isA.FormItem(self)) return null;
        var value = self.getErrors();
        if (value == null) return null;
        if (!@com.smartgwt.client.util.JSOHelper::isArray(Lcom/google/gwt/core/client/JavaScriptObject;)(value)) {
            value = [value];
        }
        return @com.smartgwt.client.util.JSOHelper::convertToJavaStringArray(Lcom/google/gwt/core/client/JavaScriptObject;)(value);
    }-*/;
    
    /**
     * Sets a validation error message for this field.
     */
    public native void setErrors(String error) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!$wnd.isc.isA.FormItem(self)) {
            $wnd.isc.logWarn("setErrors() must not be called on a FormItem before it is drawn");
            return;
        }
        self.setErrors(error);
    }-*/;
    
    /**
     * Sets multiple validation error messages for this field.
     */
    public native void setErrors(String[] errors) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!$wnd.isc.isA.FormItem(self)) {
            $wnd.isc.logWarn("setErrors() must not be called on a FormItem before it is drawn");
            return;
        }
        self.setErrors(errors);
    }-*/;
    
    /**
     * Is this item disabled?
     */
    public native Boolean isDisabled() /*-{
        var ret, 
            self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (this.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            ret = self.isDisabled();
        } else {
            ret = this.@com.smartgwt.client.widgets.form.fields.FormItem::getAttributeAsObject(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)("disabled", null);
        }
        if (ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

    /**
     * Is this item disabled?
     * @deprecated Do not use this API.  Instead, use {@link #isDisabled)}, which correctly inherits the disabled state from containers
     */
    public native Boolean getDisabled() /*-{
        var ret = this.@com.smartgwt.client.widgets.form.fields.FormItem::getAttributeAsObject(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)("disabled", null);
        if (ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;
    
    public static interface CustomStateGetter {
        /**
         * Implement this method to retrieve a custom state suffix to append to the style name that is applied to some element of a formItem.
         * See {@link com.smartgwt.client.docs.FormItemBaseStyle} for more information on how state-based FormItem style names are derived.
         * <p>
         * If a FormItem has a <code>CustomStateGetter</code>, the framework will call its <code>getCustomState()</code> method, passing in 
         * the state suffix it has derived. Your getCustomState() implementation can make use of this derived state or ignore it. For example, 
         * if you wanted two different types of focus styling depending on some factor unrelated to focus, you would probably make use of the 
         * incoming "Focused" state and return something like "Focused1" or "Focused2". On the other hand, if you want your custom state to 
         * just override whatever the system derived, you would ignore the incoming state. Finally, if you do not wish to provide a custom 
         * style for this formItem element at this time - for example, you are only interested in providing a custom "textBox" style and this 
         * call is for a "cell" element type - your getCustomStyle() method should just return the state it was passed.
        * <p>
        * CustomStatesGetters are advanced usage, and you should only use them if you have specialized styling requirements. If you do use a
        * CustomStateGetter, note that its getCustomState() method will be called very frequently, from rendering code: if your custom logic 
        * does significant processing, it could introduce a system-wide performance problem. 
        *
        * @param elementType  The element type to return a custom state for
        * @param derivedState The state suffix the system derived
        * @return             custom state suffix to use for the parameter elementType for this formItem
        * @deprecated Do not use CustomStateGetter; use {@link com.smartgwt.client.widgets.form.fields.FormItem.StateCustomizer} instead
        */
        public String getCustomState(FormItemElementType elementType, String derivedState);
    }
    

    /**
     * Specify a CustomStateGetter to use for this formItem.<p>
     * If defined, the CustomStateGetter's getCustomState() method will be called whenever the framework needs to determine which style to use 
     * for the formItem in its state at that time
     * @param getter the CustomStateGetter object
     * @deprecated Do not use CustomStateGetter; use  {@link com.smartgwt.client.widgets.form.fields.FormItem.setStateCustomizer} instead
     */
    @SuppressWarnings("deprecation")
    public native void setCustomStateGetter(CustomStateGetter getter) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.getCustomState = $debox($entry(function(elementType, derivedState) {
            var elementTypeJ = @com.smartgwt.client.util.EnumUtil::getEnum([Lcom/smartgwt/client/types/ValueEnum;Ljava/lang/String;)(@com.smartgwt.client.types.FormItemElementType::values()(), elementType);
            var derivedStateJ = $wnd.SmartGWT.convertToJavaType(derivedState);
            var val = getter.@com.smartgwt.client.widgets.form.fields.FormItem.CustomStateGetter::getCustomState(Lcom/smartgwt/client/types/FormItemElementType;Ljava/lang/String;)(elementTypeJ,derivedStateJ);
            var returnVal = $wnd.SmartGWT.convertToPrimitiveType(val);
            return returnVal;
        }));
    }-*/;
    
    public static interface StateCustomizer {
        /**
         * Implement this method to retrieve a custom state suffix to append to the style name that is applied to some element of a formItem.
         * See {@link com.smartgwt.client.docs.FormItemBaseStyle} for more information on how state-based FormItem style names are derived.
         * <p>
         * If a FormItem has a <code>StateCustomizer</code>, the framework will call its <code>getCustomState()</code> method, passing in 
         * the state suffix it has derived. Your getCustomState() implementation can make use of this derived state or ignore it. For example, 
         * if you wanted two different types of focus styling depending on some factor unrelated to focus, you would probably make use of the 
         * incoming "Focused" state and return something like "Focused1" or "Focused2". On the other hand, if you want your custom state to 
         * just override whatever the system derived, you would ignore the incoming state. Finally, if you do not wish to provide a custom 
         * style for this formItem element at this time - for example, you are only interested in providing a custom "textBox" style and this 
         * call is for a "cell" element type - your getCustomStyle() method should just return the state it was passed.
        * <p>
        * StateCustomizers are advanced usage, and you should only use them if you have specialized styling requirements. If you do use a
        * StateCustomizer, note that its getCustomState() method will be called very frequently, from rendering code: if your custom logic 
        * does significant processing, it could introduce a system-wide performance problem. 
        *
        * @param elementType  The element type to return a custom state for
        * @param derivedState The state suffix the system derived
        * @param formItem     The FormItem we are deriving state for
        * @return             custom state suffix to use for the parameter elementType for this formItem
        */
        public String getCustomState(FormItemElementType elementType, String derivedState, FormItem formItem);
    }

    /**
     * Specify a StateCustomizer to use for this formItem.  Note, StateCustomizer supersedes the deprecated <code>CustomStateGetter</code>;
     * the only difference between the two interfaces is that the <code>StateCustomizer</code>'s <code>getCustomState()</code> method is 
     * passed the applicable FormItem, so application code does not need to track this information. <p>
     * The StateCustomizer's getCustomState() method will be called whenever the framework needs to determine which style to use 
     * for the formItem in its state at that time
     * @param customizer the StateCustomizer object
     */
    public native void setStateCustomizer(StateCustomizer customizer) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.getCustomState = $debox($entry(function(elementType, derivedState, formItem) {
            var elementTypeJ = @com.smartgwt.client.util.EnumUtil::getEnum([Lcom/smartgwt/client/types/ValueEnum;Ljava/lang/String;)(@com.smartgwt.client.types.FormItemElementType::values()(), elementType);
            var derivedStateJ = $wnd.SmartGWT.convertToJavaType(derivedState);
            var formItemJ = @com.smartgwt.client.widgets.form.fields.FormItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(formItem);
            var val = customizer.@com.smartgwt.client.widgets.form.fields.FormItem.StateCustomizer::getCustomState(Lcom/smartgwt/client/types/FormItemElementType;Ljava/lang/String;Lcom/smartgwt/client/widgets/form/fields/FormItem;)(elementTypeJ,derivedStateJ,formItemJ);
            var returnVal = $wnd.SmartGWT.convertToPrimitiveType(val);
            return returnVal;
        }));
    }-*/;

    // if this instance has been used to set the properties of another object, mark it as
    // "config only" so that a warning will be generated if it's ever instantiated.
    protected boolean configOnly;

    public void setConfigOnly(boolean configOnly) {
        this.configOnly = configOnly;
    }

    public boolean isConfigOnly() {
         return configOnly;
    }

    public native void linkToInstanceUponCreate() /*-{
        var itemJ = this,
            config = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        config.__sgwtRelink = $debox($entry(function() {
            if (itemJ.@com.smartgwt.client.widgets.form.fields.FormItem::isConfigOnly()()) {
                @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(itemJ.@java.lang.Object::getClass()(), "linkToInstanceUponCreate", "");
            }
            itemJ.@com.smartgwt.client.core.JsObject::setJavaScriptObject(Lcom/google/gwt/core/client/JavaScriptObject;)(this);
        }));
    }-*/;
    
    /**
     * Given a display value for this FormItem, return the underlying data value.  This is  done by reverse value-mapping,
     * and/or parsing. <p> This method is called by the framework to derive an underlying data value for a given  display value
     * (ie, the value the user sees and interacts with) in a FormItem.  Your own  code can call this method if you need to
     * programmatically obtain the underlying data   value for a given display value.  However,  this method is not an override
     * point. If you have a field that requires the stored value to be different from the displayed  value, and the requirement
     * cannot be satisfied with a {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueMap valueMap} for some
     * reason, you can add custom parsing logic by   setting an {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setEditorValueParser editor value parser} <p> This method is also
     * <b>not</b> intended as a place where you can validate, sanitize,  transform or canonicalize user input<ul> <li>To ensure
     * you get well-formed input values, use {@link com.smartgwt.client.widgets.form.fields.TextItem#getMask input masks} or  
     * a {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#addChangeHandler(com.smartgwt.client.widgets.form.fields.events.ChangeHandler
     * change handler)} </li> <li>To transform or canonicalize input values, use a {@link
     * com.smartgwt.client.types.ValidatorType mask validator} with "transformTo".  See the link to "mask validator" for more
     * details and an example of this</li> <li>To transform or canonicalize input character-by-character as the user types, use
     * an {@link com.smartgwt.client.widgets.form.fields.FormItem#setInputTransformer() input transformer} </li></ul>
     * <h3>Deriving the data value</h3> The process of deriving an underlying data display value from a display value involves 
     * the following steps:<ul> <li>If the formItem           has an {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setEditorValueParser() editor value parser},      it is called</li>
     * <li>Otherwise, if the formItem is of a {@link com.smartgwt.client.data.SimpleType} that           has had an edit parser
     * applied with the                    <code>setEditParser()</code> API, the edit parser     is called</li> <li>If the
     * formItem is of a <code>SimpleType</code> that      {@link com.smartgwt.client.data.SimpleType#getInheritsFrom
     * inheritsFrom} "date", "time" or "datetime", it will      be parsed as a date, time or datetime.  Note, this parsing step
     * is applied on top of      custom SimpleType- and FormItem-level parsing</li> <li>If the formItem declares a {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueMap valueMap}, a value is derived by  looking up the display
     * value (including the effects of any parsing we may have done so far) in the valueMap</li> </ul> <b>Note:</b> Unlike the
     * corollary method {@link com.smartgwt.client.widgets.form.fields.FormItem#mapValueToDisplay mapValueToDisplay()}, there
     * is no special built-in handling of <code>{@link com.smartgwt.client.data.DataSourceField#getMultiple
     * DataSourceField.multiple}:true</code>  fields.  If you want an array to be parsed out of some user input, you must write
     * the parser method to do so.
     * @param value display value
     *
     * @return value re-mapped for storing
     * @see com.smartgwt.client.widgets.form.fields.FormItem#mapValueToDisplay
     */
    public native Object mapDisplayToValue(String value) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.mapDisplayToValue(value);
        if ($wnd.isc.DynamicForm._skipConversionOnMapping) {
            return ret;
        } else {
            return $wnd.SmartGWT.convertToJavaObject(ret);
        }
    }-*/;

	/**
     * Given a value for this FormItem, return the value to be displayed. <p> This method is called by the framework to derive
     * a display value for a given data value in a FormItem.  Your own code can call this method if you need to
     * programmatically obtain the display value (for example, to display in a hover prompt or error message).  However,  this
     * method is not an override point. There are several supported ways to apply custom formatting to your form values:<ul>
     * <li>If you want to apply a consistent custom format to every instance of a given {@link
     * com.smartgwt.client.data.SimpleType}, specify a {@link com.smartgwt.client.data.SimpleType#getFormat format} on the
     * SimpleType.     This is the most general approach.  Note, this is a static formatter: it will only  affect the format of
     * values the user can interact with if {@link com.smartgwt.client.widgets.form.fields.TextItem#getFormatOnBlur
     * TextItem.formatOnBlur} is set</li> <li>If you want to apply a consistent custom format to a  {@link
     * com.smartgwt.client.data.DataSourceField DataSource-described field}, the best approach is  {@link
     * com.smartgwt.client.data.DataSourceField#getFormat DataSourceField.format}. This overrides SimpleType-level formatting
     * and, again, is static formatting</li> <li>For a FormItem that is not DataSource-described, or for special formats that 
     * should only be used on a particular form, {@link com.smartgwt.client.widgets.form.fields.FormItem#getFormat format} can
     * also be  declared for individual FormItems.  This overrides DataSource-level formatting</li> <li>For temporal values,
     * you can declare {@link com.smartgwt.client.widgets.form.fields.FormItem#getDateFormatter dateFormatter}  and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTimeFormatter timeFormatter} at both <code>FormItem</code> and 
     * {@link com.smartgwt.client.widgets.form.DynamicForm} levels.  Generally, however, we recommend the generic  declarative
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getFormat format} as the simpler approach</li> <li>If you want
     * to apply a specialized format that cannot be expressed declaratively, use  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setValueFormatter} for static-valued items like {@link
     * com.smartgwt.client.widgets.form.fields.StaticTextItem} or {@link com.smartgwt.client.widgets.form.fields.SelectItem},
     * and  {@link com.smartgwt.client.widgets.form.fields.FormItem#setEditorValueFormatter} for other types of FormItem</li>
     * </ul> <h3>Deriving the display value</h3> The process of deriving a display value from a data value involves the
     * following steps:<ul> <li>If the item declares a {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueMap
     * valueMap}, the display value is  derived by looking up the value in the valueMap</li> <li>If the item does not have a
     * valueMap - or the value was not found in the item's  valueMap - and the item declares a {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} and an {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource}, the display value is derived  by
     * looking up the "displayField" corresponding to the value in the optionDataSource's local cache</li> <li>Formatting is
     * now applied to the derived display value.  Note, it is perfectly normal  at this point for no display value has to be
     * derived - this will be the case for any   field with no <code>valueMap</code> and no <code>optionDataSource</code>.  In
     * this case,  the passed-in value is treated as the display value for all further purposes.<ul>     <li>If the FormItem
     * involves static display value(s), like {@link com.smartgwt.client.widgets.form.fields.StaticTextItem}         or {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem}<ul>         <li>If the FormItem                  has had a static
     * value formatter applied with the                    <code>setValueFormatter()</code> API, the value formatter is
     * called</li>         <li>Otherwise, if the formItem declares a {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getFormat format}, the formst             is applied in line with the
     * rules of {@link com.smartgwt.client.docs.FormatString}</li>         <li>Otherwise, if the FormItem is of a {@link
     * com.smartgwt.client.data.SimpleType} that declares a             {@link com.smartgwt.client.data.SimpleType#getFormat
     * format}, the format is applied</li>     </ul>     </li>     <li>Otherwise, if the FormItem                   has had an
     * editor value formatter applied with the                    <code>setEditorValueFormatter()</code> API, the editor value
     * formatter                   is called     </li>     <li>Otherwise, if the FormItem is of a {@link
     * com.smartgwt.client.data.SimpleType} that                  has had an edit formatter applied with the                   
     * <code>setEditFormatter()</code> API,         the edit formatter is called</li>     <li>Otherwise, if the value is a
     * Date:<ul>         <li>If the formItem declares a {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTimeFormatter timeFormatter} and no              {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDateFormatter dateFormatter}, the timeFormatter is called</li>      
     * <li>Otherwise, if the formItem is of a {@link com.smartgwt.client.data.SimpleType} that              {@link
     * com.smartgwt.client.data.SimpleType#getInheritsFrom inheritsFrom} "time", the value is formatted             using the  
     * {@link com.smartgwt.client.util.DateUtil#setShortTimeDisplayFormatter default time format}         <li>Otherwise, the
     * date or datetime is formatted using the rules described              for {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDateFormatter dateFormatter}.     </ul>     </li>     <li>Otherwise,
     * if the FormItem involves static display value(s) and is of a          <code>SimpleType</code> that declares a         
     * {@link com.smartgwt.client.data.SimpleType#normalDisplayFormatter normalDisplayFormatter}, this is used</li>    
     * <li>Otherwise, if the value is not null and is of a "simple" type (ie, it is not an         object or an array), a
     * display value is derived by calling the Javascript          <code>toLocaleString()</code> method, if the value has one,
     * or the          <code>toString()</code> method if it does not</li>     <li>Otherwise, if the value is null or a
     * zero-length string, the display value is          set to the formItem's {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getEmptyDisplayValue emptyDisplayValue}</li>     <li>Otherwise, the
     * "display value" is the simple, unformatted data value that was          passed in</li> </ul> </li> </ul> <h3>Treatment
     * of arrays</h3> Ordinarily, arrays are treated like any other value.  This means you can, for example,  create a  {@link
     * com.smartgwt.client..widgets.form.FormItemValueFormatter value formatter} that is capable of formatting an array-valued
     * field in some way that makes sense for the  particular application domain. <p> However, for items that are marked to
     * handle {@link com.smartgwt.client.data.DataSourceField#getMultiple multiple}  values, array values are treated
     * differently.  In this case, the display value is built  up by calling <code>mapValueToDisplay()</code> recursively for
     * each array entry, and  concatenating these partial display values together using the  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getMultipleValueSeparator multipleValueSeparator}.
     * @param value value to be mapped to a display value
     *
     * @return value to display. Note, for items with static value(s), such as                        {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem} or {@link com.smartgwt.client.widgets.form.fields.StaticTextItem},
     * the display                        value string will be interpreted as HTML by the browser.  See                       
     * {@link com.smartgwt.client.widgets.form.fields.SelectItem#getEscapeHTML SelectItem.escapeHTML} for more details
     * @see com.smartgwt.client.widgets.form.fields.FormItem#mapDisplayToValue
     */
    public native String mapValueToDisplay(Map value) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.mapValueToDisplay(value == null ? null : @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(value));
        return ret;
    }-*/;
    public native String mapValueToDisplay(JavaScriptObject value) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.mapValueToDisplay(value);
        return ret;
    }-*/;
    public native String mapValueToDisplay(Object value) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var temp = {};
        @com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/Object;)(temp,"temp",value);
        var ret = self.mapValueToDisplay(temp.temp);
        return ret;
    }-*/;


    // FormItem wrapper consistency checking

    protected static boolean warnOnEditorTypeConversionDefault = true;

    /**
     * Gets whether, by default, a warning will be logged if the Framework replaces a SmartGWT
     * FormItem (that wraps the SmartClient item instance) to more closely match the underlying
     * item's type.
     *
     * @return whether to warn if SmartGWT FormItem wrapping a SmartClient item is replaced
     * @see #getWarnOnEditorTypeConversion
     */
    public static boolean getWarnOnEditorTypeConversionDefault() {
        return warnOnEditorTypeConversionDefault;
    }

    /**
     * Sets whether, by default, a warning will be logged if the Framework replaces a SmartGWT
     * FormItem (that wraps the SmartClient item instance) to more closely match the underlying
     * item's type.
     *
     * @param warn whether to warn if SmartGWT FormItem wrapping a SmartClient item is replaced
     * @see #setWarnOnEditorTypeConversion
     */
    public static void setWarnOnEditorTypeConversionDefault(boolean warn) {
        warnOnEditorTypeConversionDefault = warn;
    }

    protected boolean warnOnEditorTypeConversion = warnOnEditorTypeConversionDefault;

    /**
     * Gets whether a warning will be logged if the Framework replaces this SmartGWT FormItem
     * (that wraps the SmartClient item instance) to more closely match the underlying item's
     * type.  The default value can be configured by calling 
     * {@link #setWarnOnEditorTypeConversionDefault}.
     *
     * @return whether to warn if SmartGWT FormItem wrapping a SmartClient item is replaced
     */
    public boolean getWarnOnEditorTypeConversion () {
        return this.warnOnEditorTypeConversion;
    }

    /**
     * Sets whether a warning will be logged if the Framework replaces this SmartGwt FormItem
     * (that wraps the SmartClient item instance) to more closely match the underlying item's
     * type when {@link #getOrCreateRef getOrCreateRef()} is called.  A SmartGWT FormItem
     * created using the default or (String) name constructor will never be replaced unless
     * it has the base class (i.e. FormItem) type, in which case it's always replaced as no
     * SmartClient FormItem instance will ever have the FormItem class type.  A SmartGWT
     * FormItem created using the
     * {@link com.google.gwt.core.client.JavaScriptObject JavaScriptObject} constructor (perhaps
     * indirectly via
     * {@link com.smartgwt.client.widgets.form.fields.FormitemFactory FormItemFactory}) will be
     * replaced by a call to {@link #getOrCreateRef getOrCreateRef()} if the wrapping SmartGWT
     * FormItem type ends up mismatching the underlying SmartClient instance.  This may happen
     * if:<ul>
     * <li>the SmartGWT FormItem type wrapping the instance is the base class, FormItem,
     * <li>the JavaScriptObject content passed in is chosen inconsistently with the actual
     * class of the SmartGWT FormItem constructor chosen to wrap it, or
     * <li>the {@link com.smartgwt.client.widgets.form.DynamicForm DynamicForm} instance
     * doesn't exist, so 
     * {@link com.smartgwt.client.widgets.form.fields.FormItemFactory FormItemFactory} (if used)
     * is unable to select the right SmartGWT FormItem class to wrap the underlying SmartClient
     * item instance
     * </ul><p>
     * Note that when calling a SmartGWT FormItem constructor taking a JavaScriptObject, you can
     * call {@link #setAttribute setAttribute()} on the "editorType" property and pass the
     * desired FormItem subclass name to ensure that the ultimate SmartClient instance type
     * matches the SmartGWT FormItem constructor you've chosen (except when creating the base
     * class FormItem type - that will always be replaced).  You can use 
     * {@link #setEditorType setEditorType()} instead of setAttribute() if you've made the
     * Java annotation to generate the appropriate BeanFactory, but that's really only needed if
     * the type being set doesn't correspond to a native SmartGWT Framework FormItem class.
     * <p>
     * The default value can be configured by calling
     * {@link #setWarnOnEditorTypeConversionDefault}.
     *
     * @param warn whether to warn if SmartGWT FormItem wrapping a SmartClient item is replaced
     */
    public void setWarnOnEditorTypeConversion(boolean warn) {
        this.warnOnEditorTypeConversion = warn;
    }

    public void handleWarnOnEditorTypeConversion (FormItem oldItem, FormItem newItem) {
        if (!oldItem.warnOnEditorTypeConversion)  return;
        SC.logWarn("The existing FormItem wrapper of type " + oldItem.getClass().getName() +
            " and name: " + getName() + " is being replaced with a wrapper of type " + 
            newItem.getClass().getName() + " to match the type of the underlying SmartClient " +
            "instance.  Continuing to use the old wrapper (by reference) may lead to " +
            "invalid behavior.  Call setWarnOnEditorTypeConversion() to supress the " +
            "warning for this item, or setWarnOnEditorTypeConversionDefault() to " +
            "suppress it by default for all subsequently created items.");
    }

    /**
     * In a form, valueMaps are used for FormItem types that allow the user to pick from a
     * limited set of values, such as a {@link com.smartgwt.client.widgets.form.SelectItem SelectItem}.
     * An item's valueMap can be either an Array of String values or a Map of stored String
     * property names to Java Objects. <P> 
     * To set the initial selection for a form item with a valueMap, use {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setDefaultValue defaultValue}. <P> 
     * See also {@link com.smartgwt.client.data.DataSourceField#getValueMap DataSourceField.valueMap}.
     *
     * @see #setValueMap(String...)
     * @see #getValueMapAsArray()
     * @see #setValueMap(Map)
     * @return Map
     */
	public Map getValueMap()  {
        return getAttributeAsMap("valueMap");
    }

    /**
     * See also {@link #getValueMap()}
     * @return String[]
     */
    public String[] getValueMapAsArray() {
        return (String[]) getAttributeAsStringArray("valueMap");
    }


}
