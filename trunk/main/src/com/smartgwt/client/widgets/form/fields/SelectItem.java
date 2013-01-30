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
 * FormItem that allows picking between several mutually exclusive options via a select list. <P> Options may be derived
 * from a <code>dataSource</code> or a <code>valueMap</code>. <P> Note that to select the first option as a default value
 * for the item, {@link com.smartgwt.client.widgets.form.fields.SelectItem#getDefaultToFirstOption defaultToFirstOption}
 * may be set.
 * @see com.smartgwt.client.widgets.form.fields.FormItem#getValueMap
 */
public class SelectItem extends FormItem  implements PickList, com.smartgwt.client.widgets.form.fields.events.HasDataArrivedHandlers {

    public static SelectItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (SelectItem) obj;
        } else {
            return new SelectItem(jsObj);
        }
    }

    public SelectItem(){
        setAttribute("editorType", "SelectItem");
    }

    public SelectItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public SelectItem(String name) {
        setName(name);
        setAttribute("editorType", "SelectItem");
    }

    public SelectItem(String name, String title) {
        setName(name);
		setTitle(title);
        setAttribute("editorType", "SelectItem");
    }

    // ********************* Properties / Attributes ***********************

    /**
     * If we're setting the value of a select item and the value isn't a legal value in the valueMap, whether we should allow
     * the value (creating a new option for it) or reject it. <P> Exception: If the value is set to <code>null</code> but there
     * is no null entry in the valueMap for this item, setting <code>addUnknownValues</code> to true will not cause a null
     * option to show up at the top of the select item pickList. Whether an empty  option is shown in the pickList is governed
     * by {@link com.smartgwt.client.widgets.form.fields.SelectItem#getAllowEmptyValue allowEmptyValue} instead.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param addUnknownValues addUnknownValues Default value is true
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_dep_dep_selects" target="examples">Dependent Selects Example</a>
     */
    public void setAddUnknownValues(Boolean addUnknownValues) {
        setAttribute("addUnknownValues", addUnknownValues);
    }

    /**
     * If we're setting the value of a select item and the value isn't a legal value in the valueMap, whether we should allow
     * the value (creating a new option for it) or reject it. <P> Exception: If the value is set to <code>null</code> but there
     * is no null entry in the valueMap for this item, setting <code>addUnknownValues</code> to true will not cause a null
     * option to show up at the top of the select item pickList. Whether an empty  option is shown in the pickList is governed
     * by {@link com.smartgwt.client.widgets.form.fields.SelectItem#getAllowEmptyValue allowEmptyValue} instead.
     *
     *
     * @return Boolean
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_dep_dep_selects" target="examples">Dependent Selects Example</a>
     */
    public Boolean getAddUnknownValues()  {
        return getAttributeAsBoolean("addUnknownValues");
    }

    /**
     * If set to true, always show an empty option in this item's pickList, allowing the user to clear the value (even if there
     * is no empty entry in the valueMap for the item). <P> The empty value will be displayed with the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getEmptyDisplayValue emptyDisplayValue}. <P> With a {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getOptionDataSource databound selectItem}, enabling
     * <code>allowEmptyValue</code> disables data paging - all data matching the  current criteria will be requested.
     *
     * @param allowEmptyValue allowEmptyValue Default value is false
     */
    public void setAllowEmptyValue(Boolean allowEmptyValue) {
        setAttribute("allowEmptyValue", allowEmptyValue);
    }

    /**
     * If set to true, always show an empty option in this item's pickList, allowing the user to clear the value (even if there
     * is no empty entry in the valueMap for the item). <P> The empty value will be displayed with the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getEmptyDisplayValue emptyDisplayValue}. <P> With a {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getOptionDataSource databound selectItem}, enabling
     * <code>allowEmptyValue</code> disables data paging - all data matching the  current criteria will be requested.
     *
     *
     * @return Boolean
     */
    public Boolean getAllowEmptyValue()  {
        return getAttributeAsBoolean("allowEmptyValue");
    }

    /**
     * If this select item retrieves its options from a <code>dataSource</code>, should options be fetched from the server when
     * the item is first drawn, or should this fetch be delayed until the user opens the pickList. <P> The default is true in
     * order to allow the user to select a value via keyboard input while keyboard focus is on the SelectItem but the pickList
     * has not actually been shown.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param autoFetchData autoFetchData Default value is true
     */
    public void setAutoFetchData(Boolean autoFetchData) {
        setAttribute("autoFetchData", autoFetchData);
    }

    /**
     * If this select item retrieves its options from a <code>dataSource</code>, should options be fetched from the server when
     * the item is first drawn, or should this fetch be delayed until the user opens the pickList. <P> The default is true in
     * order to allow the user to select a value via keyboard input while keyboard focus is on the SelectItem but the pickList
     * has not actually been shown.
     *
     *
     * @return Boolean
     */
    public Boolean getAutoFetchData()  {
        return getAttributeAsBoolean("autoFetchData");
    }

    /**
     * For databound pickLists (see  optionDataSource), by default Smart GWT will cache and re-use datasets shown by pickLists
     * in an LRU (least recently used) caching pattern. <P> Setting this flag to false avoids this caching for situations where
     * it is too aggressive.
     *
     * @param cachePickListResults cachePickListResults Default value is true
     */
    public void setCachePickListResults(Boolean cachePickListResults) {
        setAttribute("cachePickListResults", cachePickListResults);
    }

    /**
     * For databound pickLists (see  optionDataSource), by default Smart GWT will cache and re-use datasets shown by pickLists
     * in an LRU (least recently used) caching pattern. <P> Setting this flag to false avoids this caching for situations where
     * it is too aggressive.
     *
     *
     * @return Boolean
     */
    public Boolean getCachePickListResults()  {
        return getAttributeAsBoolean("cachePickListResults");
    }

    /**
     * Base CSS class name for a form item's control box (surrounds text box and picker). <P> NOTE: See the {@link
     * CompoundFormItem_skinning} discussion for special skinning considerations.
     *
     * @param controlStyle controlStyle Default value is "selectItemControl", [IRA]
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setCellStyle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setControlStyle(String controlStyle) {
        setAttribute("controlStyle", controlStyle);
    }

    /**
     * Base CSS class name for a form item's control box (surrounds text box and picker). <P> NOTE: See the {@link
     * CompoundFormItem_skinning} discussion for special skinning considerations.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getCellStyle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getControlStyle()  {
        return getAttributeAsString("controlStyle");
    }

    /**
     * Select the first option as the default value for this SelectItem.  <P> If options are derived from a dataSource, the
     * first value returned by the server will be used, otherwise the first value in the valueMap.  Note that setting this
     * property to true will trigger a fetch at soon as the form is created, because the form will try to establish a default
     * value at that time. <P> If enabled, this setting overrides {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getDefaultValue defaultValue} and {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#defaultDynamicValue SelectItem.defaultDynamicValue}.
     *
     * @param defaultToFirstOption defaultToFirstOption Default value is false
     */
    public void setDefaultToFirstOption(Boolean defaultToFirstOption) {
        setAttribute("defaultToFirstOption", defaultToFirstOption);
    }

    /**
     * Select the first option as the default value for this SelectItem.  <P> If options are derived from a dataSource, the
     * first value returned by the server will be used, otherwise the first value in the valueMap.  Note that setting this
     * property to true will trigger a fetch at soon as the form is created, because the form will try to establish a default
     * value at that time. <P> If enabled, this setting overrides {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getDefaultValue defaultValue} and {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#defaultDynamicValue SelectItem.defaultDynamicValue}.
     *
     *
     * @return Boolean
     */
    public Boolean getDefaultToFirstOption()  {
        return getAttributeAsBoolean("defaultToFirstOption");
    }

    /**
     * Static default value for this SelectItem. To default to the first option use {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getDefaultToFirstOption defaultToFirstOption} instead.
     *
     * @param defaultValue defaultValue Default value is null
     */
    public void setDefaultValue(Boolean defaultValue) {
        setAttribute("defaultValue", defaultValue);
    }

    /**
     * Static default value for this SelectItem. To default to the first option use {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getDefaultToFirstOption defaultToFirstOption} instead.
     *
     *
     * @return Boolean
     */
    public Boolean getDefaultValue()  {
        return getAttributeAsBoolean("defaultValue");
    }

    /**
     * Specifies an alternative field from which display values should be retrieved for this item. <P> The display field can be
     * either another field value in the same record or a field that must be retrieved from a related {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource}. <P> If this item is not
     * databound ({@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource} is unset), or
     * bound  to the same dataSource as the form as a whole, this item will call {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValue form.getValue()}  the form named after is implemented by picking
     * up the value of the specified field from the Form's values object. <P> Otherwise this item will attempt to map its
     * underlying value to a display value by retrieving a record from the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource} where the  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueField valueField} matches this item's value, and displaying the
     * <code>displayField</code> value from that record. Note that if <code>optionDataSource</code> is set and this value is
     * not set, {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayFieldName FormItem.getDisplayFieldName} will
     * return the dataSource title field by default. <P> This essentially enables the specified <code>optionDataSource</code>
     * to be used as a server based {@link valueMap}.
     *
     * @param displayField displayField Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#selected_value_combobox_category" target="examples">List - Related Records Example</a>
     */
    public void setDisplayField(String displayField) {
        setAttribute("displayField", displayField);
    }

    /**
     * Specifies an alternative field from which display values should be retrieved for this item. <P> The display field can be
     * either another field value in the same record or a field that must be retrieved from a related {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource}. <P> If this item is not
     * databound ({@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource} is unset), or
     * bound  to the same dataSource as the form as a whole, this item will call {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValue form.getValue()}  the form named after is implemented by picking
     * up the value of the specified field from the Form's values object. <P> Otherwise this item will attempt to map its
     * underlying value to a display value by retrieving a record from the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource} where the  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueField valueField} matches this item's value, and displaying the
     * <code>displayField</code> value from that record. Note that if <code>optionDataSource</code> is set and this value is
     * not set, {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayFieldName FormItem.getDisplayFieldName} will
     * return the dataSource title field by default. <P> This essentially enables the specified <code>optionDataSource</code>
     * to be used as a server based {@link valueMap}.
     *
     *
     * @return String
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#selected_value_combobox_category" target="examples">List - Related Records Example</a>
     */
    public String getDisplayField()  {
        return getAttributeAsString("displayField");
    }

    /**
     * If this item has a specified <code>optionDataSource</code> and this property is <code>true</code>, the list of fields
     * used by this pickList will be passed to the datasource as {@link com.smartgwt.client.data.DSRequest#getOutputs outputs}.
     * If the datasource supports this feature the returned fields will be limited to this list. A custom datasource will need
     * to add code to implement field limiting. <P> This list of used fields consists of the values of {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueField valueField}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} and {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getPickListFields pickListFields}. <P> NOTE: When enabled, {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getSelectedRecord getSelectedRecord} will only include the fetched
     * fields.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param fetchDisplayedFieldsOnly fetchDisplayedFieldsOnly Default value is null
     */
    public void setFetchDisplayedFieldsOnly(Boolean fetchDisplayedFieldsOnly) {
        setAttribute("fetchDisplayedFieldsOnly", fetchDisplayedFieldsOnly);
    }

    /**
     * If this item has a specified <code>optionDataSource</code> and this property is <code>true</code>, the list of fields
     * used by this pickList will be passed to the datasource as {@link com.smartgwt.client.data.DSRequest#getOutputs outputs}.
     * If the datasource supports this feature the returned fields will be limited to this list. A custom datasource will need
     * to add code to implement field limiting. <P> This list of used fields consists of the values of {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueField valueField}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} and {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getPickListFields pickListFields}. <P> NOTE: When enabled, {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getSelectedRecord getSelectedRecord} will only include the fetched
     * fields.
     *
     *
     * @return Boolean
     */
    public Boolean getFetchDisplayedFieldsOnly()  {
        return getAttributeAsBoolean("fetchDisplayedFieldsOnly");
    }

    /**
     * If <code>filterLocally</code> is set for this item, and this item is showing options  from a dataSource, fetch the
     * entire set of options from the server, and use these values to map the item value to the appropriate display value. Also
     * use <code>"local"</code> type filtering on drop down list of options. <P> This means data will only be fetched once from
     * the server, and then filtered on the client.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param filterLocally filterLocally Default value is false
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setFilterLocally
     */
    public void setFilterLocally(Boolean filterLocally) {
        setAttribute("filterLocally", filterLocally);
    }

    /**
     * If <code>filterLocally</code> is set for this item, and this item is showing options  from a dataSource, fetch the
     * entire set of options from the server, and use these values to map the item value to the appropriate display value. Also
     * use <code>"local"</code> type filtering on drop down list of options. <P> This means data will only be fetched once from
     * the server, and then filtered on the client.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getFilterLocally
     */
    public Boolean getFilterLocally()  {
        return getAttributeAsBoolean("filterLocally");
    }

    /**
     * Default height for select items is 19px.
     *
     * @param height height Default value is 19
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setHeight(int height) {
        setAttribute("height", height);
    }

    /**
     * Default height for select items is 19px.
     *
     *
     * @return int
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getHeight()  {
        return getAttributeAsInt("height");
    }

    /**
     * If true, multiple values may be selected. <P> The SelectItem will either render as a drop-down allowing multiple
     * selections, or a multi-row list of options similar to a small headerless {@link
     * com.smartgwt.client.widgets.grid.ListGrid}, based on the {@link com.smartgwt.client.types.MultipleAppearance} setting.
     * <P> The logical value of the formItem, as retrieved by {@link com.smartgwt.client.widgets.form.fields.FormItem#getValue
     * getValue()} and set via {@link com.smartgwt.client.widgets.form.fields.FormItem#setValue setValue()}, is an Array of
     * Strings reflecting the selected values. <P> When this value is true, we disable doubleClick events by default, instead
     * issuing two single clicks by forcibly setting {@link com.smartgwt.client.widgets.Canvas#getNoDoubleClicks
     * noDoubleClicks: true}. If you need to work with doubleClick events, you can disable this default behavior by explicitly
     * setting formItem.pickListProperties.noDoubleClicks: false. <P> Note: <code>multiple:true</code> SelectItems do not
     * currently support optionDataSource binding.  You can get around this by calling {@link
     * com.smartgwt.client.data.DataSource#fetchData DataSource.fetchData} directly and calling {@link
     * com.smartgwt.client.data.List#getValueMap dsResponse.data.getValueMap()} to obtain a valueMap.
     *
     * @param multiple multiple Default value is false
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setMultiple(Boolean multiple) {
        setAttribute("multiple", multiple);
    }

    /**
     * If true, multiple values may be selected. <P> The SelectItem will either render as a drop-down allowing multiple
     * selections, or a multi-row list of options similar to a small headerless {@link
     * com.smartgwt.client.widgets.grid.ListGrid}, based on the {@link com.smartgwt.client.types.MultipleAppearance} setting.
     * <P> The logical value of the formItem, as retrieved by {@link com.smartgwt.client.widgets.form.fields.FormItem#getValue
     * getValue()} and set via {@link com.smartgwt.client.widgets.form.fields.FormItem#setValue setValue()}, is an Array of
     * Strings reflecting the selected values. <P> When this value is true, we disable doubleClick events by default, instead
     * issuing two single clicks by forcibly setting {@link com.smartgwt.client.widgets.Canvas#getNoDoubleClicks
     * noDoubleClicks: true}. If you need to work with doubleClick events, you can disable this default behavior by explicitly
     * setting formItem.pickListProperties.noDoubleClicks: false. <P> Note: <code>multiple:true</code> SelectItems do not
     * currently support optionDataSource binding.  You can get around this by calling {@link
     * com.smartgwt.client.data.DataSource#fetchData DataSource.fetchData} directly and calling {@link
     * com.smartgwt.client.data.List#getValueMap dsResponse.data.getValueMap()} to obtain a valueMap.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getMultiple()  {
        return getAttributeAsBoolean("multiple");
    }

    /**
     * How should items with {@link com.smartgwt.client.widgets.form.fields.SelectItem#getMultiple multiple} set to 'true' be
     * displayed?
     *
     * @param multipleAppearance multipleAppearance Default value is "picklist"
     */
    public void setMultipleAppearance(MultipleAppearance multipleAppearance) {
        setAttribute("multipleAppearance", multipleAppearance == null ? null : multipleAppearance.getValue());
    }

    /**
     * How should items with {@link com.smartgwt.client.widgets.form.fields.SelectItem#getMultiple multiple} set to 'true' be
     * displayed?
     *
     *
     * @return MultipleAppearance
     */
    public MultipleAppearance getMultipleAppearance()  {
        return EnumUtil.getEnum(MultipleAppearance.values(), getAttribute("multipleAppearance"));
    }

    /**
     * If this item has a specified <code>optionDataSource</code>, this attribute may be set to specify an explicit {@link
     * com.smartgwt.client.data.DSRequest#getOperationId operationId} when performing a fetch against the option dataSource to
     * pick up display value mapping.
     *
     * @param optionOperationId optionOperationId Default value is null
     */
    public void setOptionOperationId(String optionOperationId) {
        setAttribute("optionOperationId", optionOperationId);
    }

    /**
     * If this item has a specified <code>optionDataSource</code>, this attribute may be set to specify an explicit {@link
     * com.smartgwt.client.data.DSRequest#getOperationId operationId} when performing a fetch against the option dataSource to
     * pick up display value mapping.
     *
     *
     * @return String
     */
    public String getOptionOperationId()  {
        return getAttributeAsString("optionOperationId");
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.SelectItem#getShowPickerIcon showPickerIcon} is true for this item,
     * this property governs the size of the picker icon. If unset, the picker icon will be sized as a square to fit in the
     * available height for the icon.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param pickerIconHeight pickerIconHeight Default value is null
     */
    public void setPickerIconHeight(Integer pickerIconHeight) {
        setAttribute("pickerIconHeight", pickerIconHeight);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.SelectItem#getShowPickerIcon showPickerIcon} is true for this item,
     * this property governs the size of the picker icon. If unset, the picker icon will be sized as a square to fit in the
     * available height for the icon.
     *
     *
     * @return Integer
     */
    public Integer getPickerIconHeight()  {
        return getAttributeAsInt("pickerIconHeight");
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.SelectItem#getShowPickerIcon showPickerIcon} is true for this item,
     * this property governs the src of the picker icon image to be displayed.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param pickerIconSrc pickerIconSrc Default value is "[SKIN]/DynamicForm/SelectItem_PickButton_icon.gif"
     */
    public void setPickerIconSrc(String pickerIconSrc) {
        setAttribute("pickerIconSrc", pickerIconSrc);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.SelectItem#getShowPickerIcon showPickerIcon} is true for this item,
     * this property governs the src of the picker icon image to be displayed.
     *
     *
     * @return String
     */
    public String getPickerIconSrc()  {
        return getAttributeAsString("pickerIconSrc");
    }

    /**
     * Base CSS class name for a form item's picker icon cell. If unset inherits from  this items <code>controlStyle</code>.
     *
     * @param pickerIconStyle pickerIconStyle Default value is "selectItemPickerIcon", [IRA]
     * @see com.smartgwt.client.widgets.form.fields.SelectItem#setControlStyle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setPickerIconStyle(String pickerIconStyle) {
        setAttribute("pickerIconStyle", pickerIconStyle);
    }

    /**
     * Base CSS class name for a form item's picker icon cell. If unset inherits from  this items <code>controlStyle</code>.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.form.fields.SelectItem#getControlStyle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getPickerIconStyle()  {
        return getAttributeAsString("pickerIconStyle");
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.SelectItem#getShowPickerIcon showPickerIcon} is true for this item,
     * this property governs the size of the picker icon. If unset, the picker icon will be sized as a square to fit in the
     * available height for the icon.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param pickerIconWidth pickerIconWidth Default value is null
     */
    public void setPickerIconWidth(Integer pickerIconWidth) {
        setAttribute("pickerIconWidth", pickerIconWidth);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.SelectItem#getShowPickerIcon showPickerIcon} is true for this item,
     * this property governs the size of the picker icon. If unset, the picker icon will be sized as a square to fit in the
     * available height for the icon.
     *
     *
     * @return Integer
     */
    public Integer getPickerIconWidth()  {
        return getAttributeAsInt("pickerIconWidth");
    }

    /**
     * Indicates whether or not this SelectItem will load its list of options  {@link
     * com.smartgwt.client.data.DataSource#getProgressiveLoading progressively}.  This property is copied onto the underlying
     * PickList.
     *
     * @param progressiveLoading progressiveLoading Default value is null
     * @see com.smartgwt.client.data.DataSource#setProgressiveLoading
     * @see com.smartgwt.client.docs.ProgressiveLoading ProgressiveLoading overview and related methods
     */
    public void setProgressiveLoading(Boolean progressiveLoading) {
        setAttribute("progressiveLoading", progressiveLoading);
    }

    /**
     * Indicates whether or not this SelectItem will load its list of options  {@link
     * com.smartgwt.client.data.DataSource#getProgressiveLoading progressively}.  This property is copied onto the underlying
     * PickList.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.data.DataSource#getProgressiveLoading
     * @see com.smartgwt.client.docs.ProgressiveLoading ProgressiveLoading overview and related methods
     */
    public Boolean getProgressiveLoading()  {
        return getAttributeAsBoolean("progressiveLoading");
    }

    /**
     * When this item receives focus, should it be re-styled to indicate it has focus?
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showFocused showFocused Default value is true, [IRWA]
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setCellStyle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setShowFocused(Boolean showFocused) {
        setAttribute("showFocused", showFocused);
    }

    /**
     * When this item receives focus, should it be re-styled to indicate it has focus?
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getCellStyle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowFocused()  {
        return getAttributeAsBoolean("showFocused");
    }

    /**
     * If showing a hint for this form item, should it be shown within the field? <P>CSS style for the hint is {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getTextBoxStyle textBoxStyle} with the suffix "Hint" appended to it.
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
     * If showing a hint for this form item, should it be shown within the field? <P>CSS style for the hint is {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getTextBoxStyle textBoxStyle} with the suffix "Hint" appended to it.
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
     * If this item is part of a databound form, and has a specified <code>valueMap</code>, by default we show the valueMap
     * options in the pickList for the item. Setting this property to true will ensure that the options displayed in our
     * pickList are derived from the form's <code>dataSource</code>.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showOptionsFromDataSource showOptionsFromDataSource Default value is null
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public void setShowOptionsFromDataSource(Boolean showOptionsFromDataSource) {
        setAttribute("showOptionsFromDataSource", showOptionsFromDataSource);
    }

    /**
     * If this item is part of a databound form, and has a specified <code>valueMap</code>, by default we show the valueMap
     * options in the pickList for the item. Setting this property to true will ensure that the options displayed in our
     * pickList are derived from the form's <code>dataSource</code>.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public Boolean getShowOptionsFromDataSource()  {
        return getAttributeAsBoolean("showOptionsFromDataSource");
    }

    /**
     * When the user rolls over the select item, should the pickButton display it's  <code>Over</code> state?
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showOver showOver Default value is true
     */
    public void setShowOver(Boolean showOver) {
        setAttribute("showOver", showOver);
    }

    /**
     * When the user rolls over the select item, should the pickButton display it's  <code>Over</code> state?
     *
     *
     * @return Boolean
     */
    public Boolean getShowOver()  {
        return getAttributeAsBoolean("showOver");
    }

    /**
     * Should we show a special 'picker' icon for this form item. Picker icons are customizable via {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getPickerIconProperties pickerIconProperties}. By default they will
     * be rendered inside the  Form Item's "control box" area, and will call {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#showPicker SelectItem.showPicker} when clicked.
     *
     * @param showPickerIcon showPickerIcon Default value is true
     */
    public void setShowPickerIcon(Boolean showPickerIcon) {
        setAttribute("showPickerIcon", showPickerIcon);
    }

    /**
     * Should we show a special 'picker' icon for this form item. Picker icons are customizable via {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getPickerIconProperties pickerIconProperties}. By default they will
     * be rendered inside the  Form Item's "control box" area, and will call {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#showPicker SelectItem.showPicker} when clicked.
     *
     *
     * @return Boolean
     */
    public Boolean getShowPickerIcon()  {
        return getAttributeAsBoolean("showPickerIcon");
    }

    /**
     * Base CSS class name for a form item's text box element. <P> NOTE: See the {@link CompoundFormItem_skinning} discussion
     * for special skinning considerations.
     *
     * @param textBoxStyle textBoxStyle Default value is "selectItemText", [IRA]
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setCellStyle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setTextBoxStyle(String textBoxStyle) {
        setAttribute("textBoxStyle", textBoxStyle);
    }

    /**
     * Base CSS class name for a form item's text box element. <P> NOTE: See the {@link CompoundFormItem_skinning} discussion
     * for special skinning considerations.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getCellStyle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getTextBoxStyle()  {
        return getAttributeAsString("textBoxStyle");
    }

    /**
     * When applying filter criteria to pickList data, what type of matching to use. <P> For a databound pickList ({@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getOptionDataSource optionDataSource} set),
     * <code>textMatchStyle</code> is sent to the server as {@link com.smartgwt.client.data.DSRequest#getTextMatchStyle
     * textMatchStyle}. <P> For a non-databound pickList, <code>textMatchStyle</code> is applied by  {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getFilterClientPickListData filterClientPickListData}.
     *
     * @param textMatchStyle textMatchStyle Default value is "startsWith"
     */
    public void setTextMatchStyle(TextMatchStyle textMatchStyle) {
        setAttribute("textMatchStyle", textMatchStyle == null ? null : textMatchStyle.getValue());
    }

    /**
     * When applying filter criteria to pickList data, what type of matching to use. <P> For a databound pickList ({@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getOptionDataSource optionDataSource} set),
     * <code>textMatchStyle</code> is sent to the server as {@link com.smartgwt.client.data.DSRequest#getTextMatchStyle
     * textMatchStyle}. <P> For a non-databound pickList, <code>textMatchStyle</code> is applied by  {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getFilterClientPickListData filterClientPickListData}.
     *
     *
     * @return TextMatchStyle
     */
    public TextMatchStyle getTextMatchStyle()  {
        return EnumUtil.getEnum(TextMatchStyle.values(), getAttribute("textMatchStyle"));
    }

    /**
     * If this form item maps data values to display values by retrieving the  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} values from an  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource}, this property  denotes the the
     * field to use as the underlying data value in records from the  optionDataSource.<br> If unset, assumed to be the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getName name} of this form item.
     *
     * @param valueField valueField Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#selected_value_combobox_category" target="examples">List - Related Records Example</a>
     */
    public void setValueField(String valueField) {
        setAttribute("valueField", valueField);
    }

    /**
     * If this form item maps data values to display values by retrieving the  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} values from an  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource}, this property  denotes the the
     * field to use as the underlying data value in records from the  optionDataSource.<br> If unset, assumed to be the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getName name} of this form item.
     *
     *
     * @return String
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#selected_value_combobox_category" target="examples">List - Related Records Example</a>
     */
    public String getValueField()  {
        return getAttributeAsString("valueField");
    }

    // ********************* Methods ***********************
    /**
     * Add a dataArrived handler.
     * <p>
     * If this item is showing a dataBound pickList, this notification method will be fired  when new data arrives from the
     * server.
     *
     * @param handler the dataArrived handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDataArrivedHandler(com.smartgwt.client.widgets.form.fields.events.DataArrivedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.DataArrivedEvent.getType()) == 0) setupDataArrivedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.DataArrivedEvent.getType());
    }

    private native void setupDataArrivedEvent() /*-{
        var obj = null;
            obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            var selfJ = this;
            obj.dataArrived = $entry(function(){
                var param = {"startRow" : arguments[0], "endRow" : arguments[1], "data" : arguments[2]};
                var event = @com.smartgwt.client.widgets.form.fields.events.DataArrivedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
   }-*/;
            
    /**
     * Expression evaluated to determine the {@link com.smartgwt.client.widgets.form.fields.SelectItem#getDefaultValue
     * defaultValue} when no value is provided for this item. To default to the first option use {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getDefaultToFirstOption defaultToFirstOption} instead.
     */
    public native void defaultDynamicValue() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.defaultDynamicValue();
    }-*/;
            
    /**
     * Returns the <code>displayField</code> for this item. This will typically be specified explicitly via the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} attribute. However, if  that property is
     * unset, and the {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueField valueField} for this item is 
     * hidden in the {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource}, this method
     * will return the title field for the <code>optionDataSource</code>.
     *
     * @return display field name, or null if there is no separate display field to use.
     */
    public native String getDisplayFieldName() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        return self.getDisplayFieldName();
    }-*/;
            
    /**
     * Getter method to retrieve the {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueField valueField} for this
     * item. If unset, default behavior will return the {@link com.smartgwt.client.widgets.form.fields.FormItem#getName name}
     * of this field.
     *
     * @return fieldName to use a "value field" in records from this items               {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource}
     */
    public native String getValueFieldName() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        return self.getValueFieldName();
    }-*/;

    // ********************* Static Methods ***********************
        
    // ***********************************************************        


    static {
        init();
    }

    private static native void init()/*-{
        if ($wnd.isc.SelectItem.getPrototype().__getPickListFilterCriteria == null) {
            $wnd.isc.SelectItem.getPrototype().__getPickListFilterCriteria = $wnd.isc.SelectItem.getPrototype().getPickListFilterCriteria;
            $wnd.isc.SelectItem.getPrototype().getPickListFilterCriteria = $entry(function() {
                var jObj = this.__ref;
                //if widget was not created in java via smartgwt, fallback to old behavior
                if(jObj && @com.smartgwt.client.widgets.form.fields.SelectItem::isSelectItem(Lcom/smartgwt/client/widgets/form/fields/FormItem;)(jObj)) {
                    jObj.@com.smartgwt.client.widgets.form.fields.SelectItem::setJsObj(Lcom/google/gwt/core/client/JavaScriptObject;)(this);
                    var critJ = jObj.@com.smartgwt.client.widgets.form.fields.SelectItem::getPickListFilterCriteria()();
                    return critJ == null ? {} : critJ.@com.smartgwt.client.data.Criteria::getJsObj()();
                } else {
                    return this.__getPickListFilterCriteria();
                }
            });
        }
    }-*/;

    private static boolean isSelectItem(FormItem formItem) {
        return formItem instanceof SelectItem;
    }

    /**
     * Returns a set of filter criteria to be applied to the data displayed in the pickList when it is shown.
     * <br>
     * If this is a databound item the criteria will be passed as criteria to DataSource.fetchData(). Otherwise an equivalent client-side filter
     * will be performed on the data returned by PickList.getClientPickListData().
     * <br>
     * By default returns PickList.pickListCriteria if specified, otherwise an empty set of criteria so all records will be displayed.
     *
     * <b>Note : this is an override point - if overridden this method will be called by the live form item during filtering.
     * However it is recommended that developers use
     * {@link #setPickListFilterCriteriaFunction(FormItemCriteriaFunction)} to build custom criteria instead of overriding this method directly. This ensures that
     * the custom filter criteria generating code will be called even if the form item was automatically generated based on a template 
     * passed to {@link com.smartgwt.client.widgets.grid.ListGridField#setEditorType}.</b>
     *
     * @return criteria to be used for databound or local filtering
     */    
    protected native Criteria getPickListFilterCriteria() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var critJS = self.__getPickListFilterCriteria();
        return critJS == null ? null : @com.smartgwt.client.data.Criteria::new(Lcom/google/gwt/core/client/JavaScriptObject;)(critJS);
    }-*/;

    //------------------- From PickList -------

    /**
     * This property allows the developer to specify which field[s] will be displayed in the  drop down list of options.
     * <P> Only applies to databound pickLists (see {@link com.smartgwt.client.widgets.form.fields.PickList#getOptionDataSource
     * optionDataSource}, or picklists with custom data set up via the advanced {@link
     * com.smartgwt.client.widgets.form.fields.PickList#getClientPickListData} method. <P> If this property is unset, we display the {@link
     * com.smartgwt.client.widgets.form.fields.PickList#getDisplayField displayField}, if specified,  otherwise the {@link
     * com.smartgwt.client.widgets.form.fields.PickList#getValueField valueField} <P> If there are multiple fields, column headers will be
     * shown for each field, the height of which can be customized via the {@link com.smartgwt.client.widgets.form.fields.PickList#getPickListHeaderHeight
     * pickListHeaderHeight} attribute. <P> Each field to display should be specified as a
     * {@link com.smartgwt.client.widgets.grid.ListGridField} object. Note that unlike in {@link
     * com.smartgwt.client.widgets.grid.ListGrid}, dataSource fields marked as  {@link com.smartgwt.client.data.DataSourceField#setDis${isc.DocUtils.linkForRef('DataSourceField.display','display:true')}
     * will not be hidden by default in pickLists. To override this behavior, ensure that you specify an explicit value
     * for  {@link com.smartgwt.client.widgets.grid.ListGridField#getShowIf showIf} <p><b>Note : </b> This is an
     * advanced setting</p>
     *
     * @param pickListFields pickListFields Default value is null
     */
    public void setPickListFields(ListGridField... pickListFields) {
        setAttribute("pickListFields", pickListFields);
    }

    /**
     * Maximum height to show the pick list before it starts to scroll. Note that by default the pickList will be sized
     * to the height required by its content so it will be taller when more rows are available as selectable options
     *
     * @param pickListHeight pickListHeight Default value is 300
     */
    public void setPickListHeight(int pickListHeight) {
        setAttribute("pickListHeight", pickListHeight);
    }

    /**
     * Maximum height to show the pick list before it starts to scroll. Note that by default the pickList will be sized
     * to the height required by its content so it will be taller when more rows are available as selectable options
     *
     * @return int
     */
    public int getPickListHeight() {
        return getAttributeAsInt("pickListHeight");
    }

    /**
     * Height for an empty pick list (showing the empty message), if the pick list has no records and {@link
     * com.smartgwt.client.widgets.form.fields.PickList#getHideEmptyPickList hideEmptyPickList} is <code>false</code>.
     *
     * @param emptyPickListHeight emptyPickListHeight Default value is 100
     */
    public void setEmptyPickListHeight(int emptyPickListHeight) {
        setAttribute("emptyPickListHeight", emptyPickListHeight);
    }

    /**
     * Height for an empty pick list (showing the empty message), if the pick list has no records and {@link
     * com.smartgwt.client.widgets.form.fields.PickList#getHideEmptyPickList hideEmptyPickList} is <code>false</code>.
     *
     * @return int
     */
    public int getEmptyPickListHeight() {
        return getAttributeAsInt("emptyPickListHeight");
    }

    /**
     * Empty message to display in the pickList if  {@link com.smartgwt.client.widgets.form.fields.PickList#getHideEmptyPickList
     * hideEmptyPickList} is <code>false</code>. <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param emptyPickListMessage emptyPickListMessage Default value is null
     */
    public void setEmptyPickListMessage(String emptyPickListMessage) {
        setAttribute("emptyPickListMessage", emptyPickListMessage);
    }

    /**
     * Empty message to display in the pickList if  {@link com.smartgwt.client.widgets.form.fields.PickList#getHideEmptyPickList
     * hideEmptyPickList} is <code>false</code>.
     *
     * @return String
     */
    public String getEmptyPickListMessage() {
        return getAttributeAsString("emptyPickListMessage");
    }

    /**
     * If this pickList contains no options, should it be hidden? If unset, default behavior is to allow the empty
     * pickList to show if it is databound.
     *
     * @param hideEmptyPickList hideEmptyPickList Default value is null
     */
    public void setHideEmptyPickList(Boolean hideEmptyPickList) {
        setAttribute("hideEmptyPickList", hideEmptyPickList);
    }

    /**
     * If this pickList contains no options, should it be hidden? If unset, default behavior is to allow the empty
     * pickList to show if it is databound.
     *
     * @return Boolean
     */
    public Boolean getHideEmptyPickList() {
        return getAttributeAsBoolean("hideEmptyPickList");
    }

    /**
     * Default width to show the pickList. If not specified, the width of this form item's element will be used
     * instead.
     *
     * @param pickListWidth pickListWidth Default value is null
     */
    public void setPickListWidth(Integer pickListWidth) {
        setAttribute("pickListWidth", pickListWidth);
    }

    /**
     * Default width to show the pickList. If not specified, the width of this form item's element will be used
     * instead.
     *
     * @return Integer
     */
    public Integer getPickListWidth() {
        return getAttributeAsInt("pickListWidth");
    }

    /**
     * Base Style for pickList cells.  As with ListGrid Cells, will have 'over', 'selected' and 'disabled' appended on
     * changes of state for the cells.
     *
     * @param pickListBaseStyle pickListBaseStyle Default value is "pickListCell"
     */
    public void setPickListBaseStyle(String pickListBaseStyle) {
        setAttribute("pickListBaseStyle", pickListBaseStyle);
    }

    /**
     * Base Style for pickList cells.  As with ListGrid Cells, will have 'over', 'selected' and 'disabled' appended on
     * changes of state for the cells.
     *
     * @return String
     */
    public String getPickListBaseStyle() {
        return getAttributeAsString("pickListBaseStyle");
    }

    /**
     * If true, when the pickList is shown, it will be shown via an animated reveal effect <p><b>Note : </b> This is an
     * advanced setting</p>
     *
     * @param animatePickList animatePickList Default value is null
     */
    public void setAnimatePickList(Boolean animatePickList) {
        setAttribute("animatePickList", animatePickList);
    }

    /**
     * If true, when the pickList is shown, it will be shown via an animated reveal effect
     *
     * @return Boolean
     */
    public Boolean getAnimatePickList() {
        return getAttributeAsBoolean("animatePickList");
    }

    /**
     * If this.animatePickList is true - this specifies the duration of the animation effect applied when showing the
     * pickList <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param animationTime animationTime Default value is 200
     */
    public void setAnimationTime(int animationTime) {
        setAttribute("animationTime", animationTime);
    }

    /**
     * If this.animatePickList is true - this specifies the duration of the animation effect applied when showing the
     * pickList
     *
     * @return int
     */
    public int getAnimationTime() {
        return getAttributeAsInt("animationTime");
    }

    /**
     * If this pick list is showing multiple fields, this property determines the height of the column headers for those
     * fields. Set to zero to suppress the headers entirely.
     *
     * @param pickListHeaderHeight pickListHeaderHeight Default value is 22
     */
    public void setPickListHeaderHeight(int pickListHeaderHeight) {
        setAttribute("pickListHeaderHeight", pickListHeaderHeight);
    }

    /**
     * If this pick list is showing multiple fields, this property determines the height of the column headers for those
     * fields. Set to zero to suppress the headers entirely.
     *
     * @return int
     */
    public int getPickListHeaderHeight() {
        return getAttributeAsInt("pickListHeaderHeight");
    }

    /**
     * Specifies the field by which this item should be initially sorted.  Can be set to  either a {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getName 'field name'} or the index of the field in the fields  Array.
     * Note that if <code>sortField</code> is initally specified as a number, it will be converted to a string (field name)
     * after the item is initialized. <P> To programmatically change sort field or direction after initialization, call
     * ${isc.DocUtils.linkForRef('sort')}.
     *
     * @param sortField sortField Default value is null
     */
    public void setSortField(String sortField) {
        setAttribute("sortField", sortField);
    }

    /**
     * Specifies the field by which this item should be initially sorted.  Can be set to  either a {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getName 'field name'} or the index of the field in the fields  Array.
     * Note that if <code>sortField</code> is initally specified as a number, it will be converted to a string (field name)
     * after the item is initialized. <P> To programmatically change sort field or direction after initialization, call
     * ${isc.DocUtils.linkForRef('sort')}.
     *
     *
     * @return String
     */
    public String getSortField()  {
        return getAttributeAsString("sortField");
    }

    /**
     * Specifies the field by which this item should be initially sorted.  Can be set to  either a {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getName 'field name'} or the index of the field in the fields  Array.
     * Note that if <code>sortField</code> is initally specified as a number, it will be converted to a string (field name)
     * after the item is initialized. <P> To programmatically change sort field or direction after initialization, call
     * ${isc.DocUtils.linkForRef('sort')}.
     *
     * @param sortField sortField Default value is null
     */
    public void setSortField(Integer sortField) {
        setAttribute("sortField", sortField);
    }

    /**
     * Specifies the field by which this item should be initially sorted.  Can be set to  either a {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getName 'field name'} or the index of the field in the fields  Array.
     * Note that if <code>sortField</code> is initally specified as a number, it will be converted to a string (field name)
     * after the item is initialized. <P> To programmatically change sort field or direction after initialization, call
     * ${isc.DocUtils.linkForRef('sort')}.
     *
     *
     * @return Integer
     */
    public Integer getSortFieldAsInt()  {
        return getAttributeAsInt("sortField");
    }

    /**
     * For Databound formItems, this property determines which column  {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons
     * valueIcons} should show up in for this formItem's pickList.<br> If unset valueIcons show up in the {@link
     * com.smartgwt.client.widgets.form.fields.PickList#getDisplayField displayField} column if specified,  otherwise
     * the {@link com.smartgwt.client.widgets.form.fields.PickList#getValueField valueField} column.<br> In most cases
     * only the <code>displayField</code> or <code>valueField</code> will be visible. This property is typically only
     * required if custom {@link com.smartgwt.client.widgets.form.fields.PickList#getPickListFields pickListFields}
     * have been specfied for this item. <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param valueIconField valueIconField Default value is null
     */
    public void setValueIconField(String valueIconField) {
        setAttribute("valueIconField", valueIconField);
    }

    /**
     * For Databound formItems, this property determines which column  {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons
     * valueIcons} should show up in for this formItem's pickList.<br> If unset valueIcons show up in the {@link
     * com.smartgwt.client.widgets.form.fields.PickList#getDisplayField displayField} column if specified,  otherwise
     * the {@link com.smartgwt.client.widgets.form.fields.PickList#getValueField valueField} column.<br> In most cases
     * only the <code>displayField</code> or <code>valueField</code> will be visible. This property is typically only
     * required if custom {@link com.smartgwt.client.widgets.form.fields.PickList#getPickListFields pickListFields}
     * have been specfied for this item.
     *
     * @return String
     */
    public String getValueIconField() {
        return getAttributeAsString("valueIconField");
    }

    /**
     * If this item has a databound pick-list (for example {@link com.smartgwt.client.widgets.form.fields.PickList#getOptionDataSource
     * optionDataSource} is set) this property can be used to provide static filter criteria when retrieving the data
     * for the pickList. <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param pickListCriteria pickListCriteria Default value is null
     */
    public void setPickListCriteria(Criteria pickListCriteria) {
        setAttribute("pickListCriteria", pickListCriteria.getJsObj());
    }

    /**
     * If this item has a databound pick-list (for example {@link com.smartgwt.client.widgets.form.fields.PickList#getOptionDataSource
     * optionDataSource} is set) this property can be used to provide static filter criteria when retrieving the data
     * for the pickList.
     *
     * @return Criteria
     */
    public Criteria getPickListCriteria() {
        return new Criteria(getAttributeAsJavaScriptObject("pickListCriteria"));
    }


    /**
     * If true, even non-matching options will be shown, with configurable  {@link com.smartgwt.client.widgets.form.fields.PickList#getSeparatorRows
     * separatorRows} in between.  Not valid for {@link com.smartgwt.client.widgets.form.fields.PickList#getOptionDataSource
     * optionDataSource}.
     *
     * @param showAllOptions showAllOptions Default value is null
     */
    public void setShowAllOptions(Boolean showAllOptions) {
        setAttribute("showAllOptions", showAllOptions);
    }

    /**
     * If true, even non-matching options will be shown, with configurable  {@link com.smartgwt.client.widgets.form.fields.PickList#getSeparatorRows
     * separatorRows} in between.  Not valid for {@link com.smartgwt.client.widgets.form.fields.PickList#getOptionDataSource
     * optionDataSource}.
     *
     * @return Boolean
     */
    public Boolean getShowAllOptions() {
        return getAttributeAsBoolean("showAllOptions");
    }

    /**
     * If this item has a specified <code>optionDataSource</code>, and this property is not null, this will be passed to
     * the datasource as {@link com.smartgwt.client.rpc.RPCRequest} properties when performing the filter operation on
     * the dataSource to obtain the set of options for the list. <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param optionFilterContext optionFilterContext Default value is null
     */
    public void setPickListCriteria(DSRequest optionFilterContext) {
        setAttribute("optionFilterContext", optionFilterContext);
    }

    /**
     * If set, this FormItem will derive data to show in the PickList by fetching records from the specified
     * <code>optionDataSource</code>.  The fetched data will be used as a {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueMap
     * valueMap} by extracting the {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueField valueField} and
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} in the loaded records, to
     * derive one valueMap entry per record loaded from the optionDataSource.  Multiple fields from the fetched data may
     * be shown in the pickList by setting {@link com.smartgwt.client.widgets.form.fields.SelectItem#getPickListFields
     * pickListFields}. <P> The data will be retrieved via a "fetch" operation on the DataSource, passing the  {@link
     * com.smartgwt.client.widgets.form.fields.PickList#getPickListCriteria pickListCriteria} (if set) as criteria, and passing {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getOptionFilterContext optionFilterContext} (if set) as
     * DSRequest properties. <P> The fetch will be triggered when the pickList is first shown, or, you can set {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getAutoFetchData autoFetchData} to fetch when the FormItem is
     * first drawn.  You can also call {@link com.smartgwt.client.widgets.form.fields.PickList#fetchData} at any time to manually  trigger
     * a fetch. <P> Data paging is automatically enabled if the optionDataSource supports it.  As the pickList is
     * scrolled by the user, requests for additional data will be automatically issued. <P> For a pickList attached to a
     * ComboBoxItem, new fetches are issued as the user types, with criteria set as described under {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickListFilterCriteria}. If your dataSource is not
     * capable of filtering results by search criteria (eg the dataSource is backed by an XML flat file), you can set
     * {@link com.smartgwt.client.widgets.form.fields.SelectItem#getFilterLocally filterLocally} to have the entire
     * dataset loaded up front and filtering performed in the browser.  This disables data paging. <P> Setting
     * optionDataSource also enables the basic {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * optionDataSource} behaviors, eg, fetching individual display values before the pickList is shown. <P> Note that
     * if a normal, static {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueMap valueMap} is <b>also</b>
     * specified for the field (either directly in the form item or as part of the field definition in the dataSource),
     * it will be preferred to the data derived from the optionDataSource for whatever mappings are present. <p><b>Note
     * : </b> This is an advanced setting</p>
     *
     * @param optionDataSource optionDataSource Default value is null
     */
    public void setOptionDataSource(DataSource dataSource) {
        setAttribute("optionDataSource", dataSource);
    }

    public DataSource getOptionDataSource() {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("optionDataSource"));
    }
    
    public void setSeparatorRows(ListGridRecord[] separatorRows) {
        setAttribute("separatorRows", separatorRows);
    }

    /**
     * Default values used when no value is provided for this item. Note that whenever this item's value is cleared by the user
     * or set to <code>null</code> programatically, it will be reverted to the <code>defaultValues</code>.
     *
     * @param defaultValues the defaultValues. Default value is null
     */
    public void setDefaultValues(String... defaultValues) {
        setAttribute("defaultValue", defaultValues);
    }

    /**
     * Default values used when no value is provided for this item. Note that whenever this item's value is cleared by the user
     * or set to <code>null</code> programatically, it will be reverted to the <code>defaultValues</code>.
     *
     * @param defaultValues the defaultValues. Default value is null
     */
    public void setDefaultValues(Integer... defaultValues) {
        setAttribute("defaultValue", defaultValues);
    }

    public void setFetchDelay(Integer fetchDelay) {
        setAttribute("fetchDelay", fetchDelay);
    }

    public Integer getFetchDelay() {
        return getAttributeAsInt("fetchDelay");
    }

    // ********************* Methods ***********************
    
    /**
     * Returns the values of a SelectItem with multiple=true as an array of Strings.
     *
     * @return value of selection. If no values are selected, and empty array is returned
     */
    public native String[] getValues() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var value;
        if(self.getValue) {
             value = self.getValue();
        } else {
            value = self.value;
        }
        if(value == null) {
            value = [];
        } else if(!$wnd.isc.isA.Array(value)) {
            value = [value];
        }
        return  @com.smartgwt.client.util.JSOHelper::convertToJavaStringArray(Lcom/google/gwt/core/client/JavaScriptObject;)(value);
    }-*/;

    /**
     * Set the values of a SelectItem with multiple=true.
     *
     * @param values the SelectItem values
     */
    public native void setValues(String... values) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var valuesJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(values);
        if(self.setValue) {
            self.setValue(valuesJS);
        } else {
            self.value = valuesJS;
        }
    }-*/;
    
    /**
     * If true, multiple values may be selected. <P> The SelectItem will either render as a drop-down allowing multiple
     * selections, or a multi-row list of options similar to a small headerless {@link
     * com.smartgwt.client.widgets.grid.ListGrid}, based on the {@link com.smartgwt.client.types.MultipleAppearance} setting.
     * <P> The logical value of the formItem, as retrieved by {@link com.smartgwt.client.widgets.form.fields.FormItem#getValue
     * getValue()} and set via {@link com.smartgwt.client.widgets.form.fields.FormItem#setValue setValue()}, is an Array of
     * Strings reflecting the selected values. <P> When this value is true, we disable doubleClick events by default, instead
     * issuing two single clicks by forcibly setting {@link com.smartgwt.client.widgets.Canvas#getNoDoubleClicks
     * noDoubleClicks: true}. If you need to work with doubleClick events, you can disable this default behavior by explicitly
     * setting formItem.pickListProperties.noDoubleClicks: false. <P> Note: <code>multiple:true</code> SelectItems do not
     * currently support optionDataSource binding.  You can get around this by calling {@link
     * com.smartgwt.client.data.DataSource#fetchData DataSource.fetchData} directly and calling {@link
     * com.smartgwt.client.data.List#getValueMap dsResponse.data.getValueMap()} to obtain a valueMap.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean isMultiple()  {
        return getAttributeAsBoolean("multiple");
    }

    /**
     * Only applies to databound items (see {@link com.smartgwt.client.widgets.form.fields.PickList#getOptionDataSource
     * optionDataSource}).<br> Performs a fetch type operation on this item's DataSource to retrieve the set of valid
     * options for the item, based on the current {@link com.smartgwt.client.widgets.form.fields.PickList#getPickListCriteria
     * pickListCriteria}.
     */
    public native void fetchData() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.fetchData();
    }-*/;

    /**
     * Only applies to databound items (see {@link com.smartgwt.client.widgets.form.fields.PickList#getOptionDataSource
     * optionDataSource}).<br> Performs a fetch type operation on this item's DataSource to retrieve the set of valid
     * options for the item, based on the current {@link com.smartgwt.client.widgets.form.fields.PickList#getPickListCriteria
     * pickListCriteria}.
     *
     * @param callback Callback to fire when the fetch completes. Callback will               fire with 2 parameters:
     *                 <code>item</code> a pointer to the form item and              <code>dsResponse</code> the {@link
     *                 com.smartgwt.client.data.DSResponse} returned by the server.
     */
    public native void fetchData(DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.fetchData($entry(function (item, dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }));
    }-*/;

    /**
     * Only applies to databound items (see {@link com.smartgwt.client.widgets.form.fields.PickList#getOptionDataSource
     * optionDataSource}).<br> Performs a fetch type operation on this item's DataSource to retrieve the set of valid
     * options for the item, based on the current {@link com.smartgwt.client.widgets.form.fields.PickList#getPickListCriteria
     * pickListCriteria}.
     *
     * @param callback          Callback to fire when the fetch completes. Callback will               fire with 2
     *                          parameters: <code>item</code> a pointer to the form item and
     *                          <code>dsResponse</code> the {@link com.smartgwt.client.data.DSResponse} returned by the
     *                          server.
     * @param requestProperties properties to apply to the              dsRequest for this fetch.
     */
    public native void fetchData(DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.fetchData($entry(function (item, dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }), requestPropertiesJS);
    }-*/;

    public native ListGridRecord[] filterClientPickListData() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var dataJS =  self.filterClientPickListData();
        return @com.smartgwt.client.widgets.grid.ListGrid::convertToListGridRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(dataJS);
    }-*/;

    public native ListGridRecord[] getClientPickListData() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var dataJS =  self.getClientPickListData();
        return @com.smartgwt.client.widgets.grid.ListGrid::convertToListGridRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(dataJS);
    }-*/;

//------------------- end PickList -------


    public void setFields(FormItemIcon pickerIconProperties) {
        setAttribute("pickerIconProperties", pickerIconProperties);
    }

    /**
     * Method to show a picker for this item. By default this method is called if the user clicks on a pickerIcon, shown
     * by setting <code>this.showPickerIcon</code> to true. May also be called programatically.<br> Default
     * implementation lazily creates a 'picker' from the set of defaults defined on this FormItem.
     */
    public native void showPicker() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if(self.showPicker) {
            self.showPicker();
        }
    }-*/;

    /**
     * Returns the entire record object associated with the current value for this item (or null if no matching record exists
     * in the PickList data). Most commonly used for databound pickListItems to retrieve the values of other fields in the record.
     *
     * @return the selected record or null
     */
    public native ListGridRecord getSelectedRecord() /*-{
	    var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
	    var ret = self.getSelectedRecord();
	    if(ret == null || ret === undefined) return null;
	    var retVal = @com.smartgwt.client.core.RefDataClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
	    if(retVal == null) {
	        retVal = @com.smartgwt.client.widgets.grid.ListGridRecord::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
	    }
	    return retVal;
	}-*/;

    /**
     * For a SelectItem with an {@link #setOptionDataSource(com.smartgwt.client.data.DataSource)} optionDataSource} and allowing multiple
     * selection {@link #setMultiple(Boolean) multiple} :true, returns the list of currently selected records, or null if none are selected.
     *
     * @return the list of selected records, or null if none are selected
     */
    public native ListGridRecord[] getSelectedRecords() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getSelectedRecords();
        return @com.smartgwt.client.widgets.grid.ListGrid::convertToListGridRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * Set the pick list filter criteria function / handler.
     *
     * @param filterCriteriaFunction the filter criteria function
     * @deprecated in favor of {@link #setPickListFilterCriteriaFunction(FormItemCriteriaFunction)}
     */
    public native void setPickListFilterCriteriaFunction(FilterCriteriaFunction filterCriteriaFunction) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.getPickListFilterCriteria = $entry(function() {
            var crit = filterCriteriaFunction.@com.smartgwt.client.widgets.form.fields.FilterCriteriaFunction::getCriteria()();
            return crit == null ? null : crit.@com.smartgwt.client.data.Criteria::getJsObj()();
        });
    }-*/;
    
    /**
     * Set up a method to return filter criteria for options displayed for this item.
     * <br>
     * The criteria returned by this method are used to decide which options should appear in the 
     * drop-down PickList shown by this SelectItem.
     * <br>
     * Static criteria, specified via pickListCriteria, will always be included in addition to criteria 
     * returned by this method.
     *
     */
    public native void setPickListFilterCriteriaFunction(FormItemCriteriaFunction filterCriteriaFunction) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.getPickListFilterCriteria = $entry(function() {
            var context = @com.smartgwt.client.widgets.form.fields.FormItemFunctionContext::new()();
            var itemJ = @com.smartgwt.client.widgets.form.fields.SelectItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(this);
            context.@com.smartgwt.client.widgets.form.fields.FormItemFunctionContext::setFormItem(Lcom/smartgwt/client/widgets/form/fields/FormItem;)(itemJ);
            var crit = filterCriteriaFunction.@com.smartgwt.client.widgets.form.fields.FormItemCriteriaFunction::getCriteria(Lcom/smartgwt/client/widgets/form/fields/FormItemFunctionContext;)(context);
            return crit == null ? null : crit.@com.smartgwt.client.data.Criteria::getJsObj()();
        });
    }-*/;
    

    /**
     * Set the properties to be applied to the pickList created for this Form Item.
     *
     * @param pickListProperties the pick list properties
     */
    public void setPickListProperties(ListGrid pickListProperties) {
        JavaScriptObject configJS = pickListProperties.getConfig();
        JSOHelper.deleteAttribute(configJS, "ID");
        JSOHelper.deleteAttribute(configJS, "alternateRecordStyles");
        setAttribute("pickListProperties", configJS);
    }

    public void setOptionFilterContext(DSRequest dsRequestProperties) {
        setAttribute("optionFilterContext", dsRequestProperties);
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



