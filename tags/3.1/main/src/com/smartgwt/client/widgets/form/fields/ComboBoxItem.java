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
import com.smartgwt.client.widgets.drawing.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.logicalstructure.core.*;
import com.smartgwt.logicalstructure.widgets.*;
import com.smartgwt.logicalstructure.widgets.drawing.*;
import com.smartgwt.logicalstructure.widgets.plugins.*;
import com.smartgwt.logicalstructure.widgets.form.*;
import com.smartgwt.logicalstructure.widgets.tile.*;
import com.smartgwt.logicalstructure.widgets.grid.*;
import com.smartgwt.logicalstructure.widgets.chart.*;
import com.smartgwt.logicalstructure.widgets.layout.*;
import com.smartgwt.logicalstructure.widgets.menu.*;
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;

/**
 * The Combobox is a text input field which can show a list of options via a drop-down PickList. <p> The set of options
 * will be filtered based on the current value in the text field, so only options that match what has been typed so far
 * will be displayed. The set of options can be derived from a ValueMap or dynamically retrieved from a dataSource.  See
 * the PickList interface for further settings. <P> The two most common use cases for ComboBoxItems are: <ul><li>With
 * {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAddUnknownValues addUnknownValues} set to true, the
 * ComboBoxItem acts as a  freeform text entry field with the picklist providing essentially a set of suggested completions
 * similar to a URL bar in a web browser.</li>     <li>With {@link
 * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAddUnkownValues addUnkownValues} set to false, the ComboBoxItem
 * acts similarly  to a SelectItem where a fixed set of options is available to the user and the text entry field  is
 * essentially used to filter which of these options are visible</li></ul> <P> Other commonly used settings to configure
 * ComboBoxItem behavior are:<br> - {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getDefaultToFirstOption
 * defaultToFirstOption} - this will select the first option from the pickList as a default value for the item - and<br> -
 * {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getCompleteOnTab completeOnTab} which causes the current
 * selection in the pickList (if there is one) to be chosen when the user tabs out of the field, allowing a user to type a
 * few characters and hit tab to auto-complete to the first matched option. <code>completeOnTab</code> is automatically set
 * to true if {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAddUnknownValues addUnknownValues} is  false.
 * <P> ComboBoxItem does not provide built-in support for multiple selection.  For a Combobox that does provide such a
 * multiple-select feature use {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem}.
 */
public class ComboBoxItem extends TextItem  implements PickList, com.smartgwt.client.widgets.form.fields.events.HasDataArrivedHandlers {

    public static ComboBoxItem getOrCreateRef(JavaScriptObject jsObj) {
    
        if(jsObj == null) return null;

        RefDataClass obj = RefDataClass.getRef(jsObj);

 
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (ComboBoxItem) obj;
        } else {
            return new ComboBoxItem(jsObj);
        }
    }

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }


    public ComboBoxItem(){
        setAttribute("editorType", "ComboBoxItem");
    }

    public ComboBoxItem(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }

    public ComboBoxItem(String name) {
        setName(name);
        setAttribute("editorType", "ComboBoxItem");
    }

    public ComboBoxItem(String name, String title) {
        setName(name);
		setTitle(title);
        setAttribute("editorType", "ComboBoxItem");
    }

    // ********************* Properties / Attributes ***********************

    /**
     * This property controls whether the user can enter a value that is not present in the set of options for this item. <P>
     * If set to false, the value the user enters in the text box is essentially used to filter the  set of options displayed
     * in the pickList. <P> In this mode, when focus is taken from the field, if the entered value does not match any entries
     * in the ValueMap or {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getOptionDataSource optionDataSource}, it
     * will be discarded. Note  that in this mode, {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getCompleteOnTab
     * completeOnTab} behavior is automatically enabled so if the user enters a valid partial value such that one or more
     * options is displayed in  the pickList, and hits the Tab key, the first matching option will be chosen automatically. In
     * this mode the user may also hit the <code>"Escape"</code> key to discard their edits. <P> Note also that when
     * <code>addUnknownValues</code> is set to false, the underlying value returned by {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getGetValue getValue} will not be updated until a value is
     * explicitly chosen. This means any change or changed handlers will not fire directly in response to the user typing in
     * the field - they will fire when the user actually selects a value, or takes focus from  the field. <P> If setting this
     * property to <code>false</code> on a databound ComboBoxItem, data paging should be disabled - this is required since the
     * ComboBoxItem requires all data to be present in  order to determine whether an entered value is new. Data Paging can be
     * disabled by modifying the {@link com.smartgwt.client.widgets.grid.ListGrid#getDataFetchMode dataFetchMode} on the {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickListProperties pickListProperties} for this item. <P> If
     * this property is set to true, the user is not limited to entering values present in the set of options for the item.
     * Instead the set of options essentially become a set of suggestions that may be used, or the user can enter an entirely
     * new value.
     *
     * @param addUnknownValues addUnknownValues Default value is true
     */
    public void setAddUnknownValues(Boolean addUnknownValues) {
        setAttribute("addUnknownValues", addUnknownValues);
    }

    /**
     * This property controls whether the user can enter a value that is not present in the set of options for this item. <P>
     * If set to false, the value the user enters in the text box is essentially used to filter the  set of options displayed
     * in the pickList. <P> In this mode, when focus is taken from the field, if the entered value does not match any entries
     * in the ValueMap or {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getOptionDataSource optionDataSource}, it
     * will be discarded. Note  that in this mode, {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getCompleteOnTab
     * completeOnTab} behavior is automatically enabled so if the user enters a valid partial value such that one or more
     * options is displayed in  the pickList, and hits the Tab key, the first matching option will be chosen automatically. In
     * this mode the user may also hit the <code>"Escape"</code> key to discard their edits. <P> Note also that when
     * <code>addUnknownValues</code> is set to false, the underlying value returned by {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getGetValue getValue} will not be updated until a value is
     * explicitly chosen. This means any change or changed handlers will not fire directly in response to the user typing in
     * the field - they will fire when the user actually selects a value, or takes focus from  the field. <P> If setting this
     * property to <code>false</code> on a databound ComboBoxItem, data paging should be disabled - this is required since the
     * ComboBoxItem requires all data to be present in  order to determine whether an entered value is new. Data Paging can be
     * disabled by modifying the {@link com.smartgwt.client.widgets.grid.ListGrid#getDataFetchMode dataFetchMode} on the {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickListProperties pickListProperties} for this item. <P> If
     * this property is set to true, the user is not limited to entering values present in the set of options for the item.
     * Instead the set of options essentially become a set of suggestions that may be used, or the user can enter an entirely
     * new value.
     *
     *
     * @return Boolean
     */
    public Boolean getAddUnknownValues()  {
        return getAttributeAsBoolean("addUnknownValues");
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAddUnknownValues addUnknownValues} is
     * <code>false</code>, this property  determines whether the user can clear the comboBoxItem value, or whether they are
     * constrained to choosing one of the available options (in which case clearing the text box will simply revert to the last
     * picked value when the user leaves the field).
     *
     * @param allowEmptyValue allowEmptyValue Default value is true
     */
    public void setAllowEmptyValue(Boolean allowEmptyValue) {
        setAttribute("allowEmptyValue", allowEmptyValue);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAddUnknownValues addUnknownValues} is
     * <code>false</code>, this property  determines whether the user can clear the comboBoxItem value, or whether they are
     * constrained to choosing one of the available options (in which case clearing the text box will simply revert to the last
     * picked value when the user leaves the field).
     *
     *
     * @return Boolean
     */
    public Boolean getAllowEmptyValue()  {
        return getAttributeAsBoolean("allowEmptyValue");
    }

    /**
     * If this combo box retrieves its options from a <code>dataSource</code>, should options be fetched from the server when
     * the item is first written out, or should this fetch be delayed until the user opens the pickList.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param autoFetchData autoFetchData Default value is false
     */
    public void setAutoFetchData(Boolean autoFetchData) {
        setAttribute("autoFetchData", autoFetchData);
    }

    /**
     * If this combo box retrieves its options from a <code>dataSource</code>, should options be fetched from the server when
     * the item is first written out, or should this fetch be delayed until the user opens the pickList.
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
     * If true, when the pickList is showing, the user can select the current value by hitting the <code>Tab</code> key.
     *
     * @param completeOnTab completeOnTab Default value is null
     */
    public void setCompleteOnTab(Boolean completeOnTab) {
        setAttribute("completeOnTab", completeOnTab);
    }

    /**
     * If true, when the pickList is showing, the user can select the current value by hitting the <code>Tab</code> key.
     *
     *
     * @return Boolean
     */
    public Boolean getCompleteOnTab()  {
        return getAttributeAsBoolean("completeOnTab");
    }

    /**
     * Select the first option as the default value for this ComboBoxItem. If options are derived from a dataSource, the first
     * value returned by the server will be used, otherwise the first value in the valueMap. If enabled, this setting overrides
     * {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getDefaultValue defaultValue} and {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#defaultDynamicValue ComboBoxItem.defaultDynamicValue}.
     *
     * @param defaultToFirstOption defaultToFirstOption Default value is false
     */
    public void setDefaultToFirstOption(Boolean defaultToFirstOption) {
        setAttribute("defaultToFirstOption", defaultToFirstOption);
    }

    /**
     * Select the first option as the default value for this ComboBoxItem. If options are derived from a dataSource, the first
     * value returned by the server will be used, otherwise the first value in the valueMap. If enabled, this setting overrides
     * {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getDefaultValue defaultValue} and {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#defaultDynamicValue ComboBoxItem.defaultDynamicValue}.
     *
     *
     * @return Boolean
     */
    public Boolean getDefaultToFirstOption()  {
        return getAttributeAsBoolean("defaultToFirstOption");
    }

    /**
     * Static default value for this ComboBoxItem. To default to the first option use {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getDefaultToFirstOption defaultToFirstOption} instead.
     *
     * @param defaultValue defaultValue Default value is null
     */
    public void setDefaultValue(Boolean defaultValue) {
        setAttribute("defaultValue", defaultValue);
    }

    /**
     * Static default value for this ComboBoxItem. To default to the first option use {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getDefaultToFirstOption defaultToFirstOption} instead.
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
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param displayField . See {@link com.smartgwt.client.docs.String String}. Default value is null
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
     * @return . See {@link com.smartgwt.client.docs.String String}
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
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickListFields pickListFields}. <P> NOTE: When enabled, {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getSelectedRecord getSelectedRecord} will only include the fetched
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
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickListFields pickListFields}. <P> NOTE: When enabled, {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getSelectedRecord getSelectedRecord} will only include the fetched
     * fields.
     *
     *
     * @return Boolean
     */
    public Boolean getFetchDisplayedFieldsOnly()  {
        return getAttributeAsBoolean("fetchDisplayedFieldsOnly");
    }

    /**
     * As the user types into this item's textBox, a comboBoxItem will show the pick-list of options, and filter the set of
     * results displayed by the current value in the text box. For a databound comboBoxItem, by default the entered value is
     * filtered against the {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getDisplayField displayField} if one is
     * specified, otherwise the {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getValueField valueField}. <P> This
     * attribute allows the developer to explicitly change which fields to filter against, causing the user-entered text to be
     * matched against any of the specified set of fields from  the {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getOptionDataSource optionDataSource}. <P> This essentially causes
     * {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickListFilterCriteria
     * ComboBoxItem.getPickListFilterCriteria} to return an {@link com.smartgwt.client.data.AdvancedCriteria} object
     * representing "field1 starts with value or field2 starts with value or ...".  The {@link
     * com.smartgwt.client.types.OperatorId operator} used is controlled by {@link com.smartgwt.client.types.TextMatchStyle} as
     * usual, that is, "startsWith" implies the operator "iStartsWith, "substring" implies "iContains" and "exact" implies
     * "iEquals". <P> The most common use case for this setting would be when a comboBoxItem is showing multiple {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickListFields pickListFields} - if the same set of fields is
     * specified as {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getCriteriaFields criteriaFields}, the user can
     * use the text-box to filter against whichever fields are visible in the pickList. <P>  For finer grained control over
     * comboBoxItem filtering, the {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getSetPickListFilterCriteriaFunction
     * setPickListFilterCriteriaFunction} may be specified.
     *
     * @param filterFields . See {@link com.smartgwt.client.docs.String String}. Default value is null
     */
    public void setFilterFields(String... filterFields) {
        setAttribute("filterFields", filterFields);
    }

    /**
     * As the user types into this item's textBox, a comboBoxItem will show the pick-list of options, and filter the set of
     * results displayed by the current value in the text box. For a databound comboBoxItem, by default the entered value is
     * filtered against the {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getDisplayField displayField} if one is
     * specified, otherwise the {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getValueField valueField}. <P> This
     * attribute allows the developer to explicitly change which fields to filter against, causing the user-entered text to be
     * matched against any of the specified set of fields from  the {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getOptionDataSource optionDataSource}. <P> This essentially causes
     * {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickListFilterCriteria
     * ComboBoxItem.getPickListFilterCriteria} to return an {@link com.smartgwt.client.data.AdvancedCriteria} object
     * representing "field1 starts with value or field2 starts with value or ...".  The {@link
     * com.smartgwt.client.types.OperatorId operator} used is controlled by {@link com.smartgwt.client.types.TextMatchStyle} as
     * usual, that is, "startsWith" implies the operator "iStartsWith, "substring" implies "iContains" and "exact" implies
     * "iEquals". <P> The most common use case for this setting would be when a comboBoxItem is showing multiple {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickListFields pickListFields} - if the same set of fields is
     * specified as {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getCriteriaFields criteriaFields}, the user can
     * use the text-box to filter against whichever fields are visible in the pickList. <P>  For finer grained control over
     * comboBoxItem filtering, the {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getSetPickListFilterCriteriaFunction
     * setPickListFilterCriteriaFunction} may be specified.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String[] getFilterFields()  {
        return getAttributeAsStringArray("filterFields");
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
     * Read-only property set by the ComboBoxItem to indicate whether we should use the  current typed-in value as part of the
     * filter criteria returned by  {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickListFilterCriteria
     * ComboBoxItem.getPickListFilterCriteria}.  You can check this flag in order to mimic the ComboBoxItem's default behavior
     * if you provide a custom implementation of <code>getPickListFilterCriteria()</code>.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickListFilterCriteria
     * @see com.smartgwt.client.widgets.form.fields.ComboBoxItem#getFilterFields
     */
    public Boolean getFilterWithValue()  {
        return getAttributeAsBoolean("filterWithValue");
    }

    /**
     * When a comboBoxItem is used to generate search criteria in a SearchForm this property governs whether, if the user
     * explicitly chose an option from the pickList, we explicitly generate criteria that will search for an exact match
     * against the chosen value. <P> In order to achieve this, when this property is set to true, this item will generate
     * {@link com.smartgwt.client.data.AdvancedCriteria} in  the default <code>FormItemCriterionGetter</code>'s
     * <code>getCriterion()</code> method. <P> See {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#shouldGenerateExactMatchCriteria
     * ComboBoxItem.shouldGenerateExactMatchCriteria} for behavior when this flag is unset.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param generateExactMatchCriteria generateExactMatchCriteria Default value is null
     */
    public void setGenerateExactMatchCriteria(Boolean generateExactMatchCriteria) {
        setAttribute("generateExactMatchCriteria", generateExactMatchCriteria);
    }

    /**
     * When a comboBoxItem is used to generate search criteria in a SearchForm this property governs whether, if the user
     * explicitly chose an option from the pickList, we explicitly generate criteria that will search for an exact match
     * against the chosen value. <P> In order to achieve this, when this property is set to true, this item will generate
     * {@link com.smartgwt.client.data.AdvancedCriteria} in  the default <code>FormItemCriterionGetter</code>'s
     * <code>getCriterion()</code> method. <P> See {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#shouldGenerateExactMatchCriteria
     * ComboBoxItem.shouldGenerateExactMatchCriteria} for behavior when this flag is unset.
     *
     *
     * @return Boolean
     */
    public Boolean getGenerateExactMatchCriteria()  {
        return getAttributeAsBoolean("generateExactMatchCriteria");
    }

    /**
     * Not applicable to a ComboBoxItem.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param mask . See {@link com.smartgwt.client.docs.String String}. Default value is null
     */
    public void setMask(String mask) {
        setAttribute("mask", mask);
    }

    /**
     * Not applicable to a ComboBoxItem.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getMask()  {
        return getAttributeAsString("mask");
    }

    /**
     * Not applicable to a ComboBoxItem.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param maskOverwriteMode maskOverwriteMode Default value is null
     */
    public void setMaskOverwriteMode(Boolean maskOverwriteMode) {
        setAttribute("maskOverwriteMode", maskOverwriteMode);
    }

    /**
     * Not applicable to a ComboBoxItem.
     *
     *
     * @return Boolean
     */
    public Boolean getMaskOverwriteMode()  {
        return getAttributeAsBoolean("maskOverwriteMode");
    }

    /**
     * Not applicable to a ComboBoxItem.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param maskPadChar . See {@link com.smartgwt.client.docs.String String}. Default value is " "
     */
    public void setMaskPadChar(String maskPadChar) {
        setAttribute("maskPadChar", maskPadChar);
    }

    /**
     * Not applicable to a ComboBoxItem.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getMaskPadChar()  {
        return getAttributeAsString("maskPadChar");
    }

    /**
     * Not applicable to a ComboBoxItem.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param maskPromptChar . See {@link com.smartgwt.client.docs.String String}. Default value is "_"
     */
    public void setMaskPromptChar(String maskPromptChar) {
        setAttribute("maskPromptChar", maskPromptChar);
    }

    /**
     * Not applicable to a ComboBoxItem.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getMaskPromptChar()  {
        return getAttributeAsString("maskPromptChar");
    }

    /**
     * Not applicable to a ComboBoxItem.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param maskSaveLiterals maskSaveLiterals Default value is null
     */
    public void setMaskSaveLiterals(Boolean maskSaveLiterals) {
        setAttribute("maskSaveLiterals", maskSaveLiterals);
    }

    /**
     * Not applicable to a ComboBoxItem.
     *
     *
     * @return Boolean
     */
    public Boolean getMaskSaveLiterals()  {
        return getAttributeAsBoolean("maskSaveLiterals");
    }

    /**
     * If this item has a specified <code>optionDataSource</code>, this attribute may be set to specify an explicit {@link
     * com.smartgwt.client.data.DSRequest#getOperationId operationId} when performing a fetch against the option dataSource to
     * pick up display value mapping.
     *
     * @param optionOperationId . See {@link com.smartgwt.client.docs.String String}. Default value is null
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
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getOptionOperationId()  {
        return getAttributeAsString("optionOperationId");
    }

    /**
     * Optional "pending" style for this item's text box. <P> If {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAddUnknownValues addUnknownValues} is false, when the user
     * modifies the value displayed in the combobox item text box, the underlying data value (as returned from item.getValue())
     * is not immediately updated - instead the value is used to filter the set of results displayed in the comboBoxItem
     * pickList. <P> While the comboBoxItem is in this pending state (where the result of getEnteredValue() will not
     * necessarily match the display value for whatever is returned by getValue()), the  pendingTextBoxStyle may be applied to
     * the text box for the item. <P> When the element value is updated to display the actual value for the item (typically due
     * to the user selecting a value from the pickList), the standard  {@link
     * com.smartgwt.client.widgets.form.fields.TextItem#getTextBoxStyle textBoxStyle} will be reapplied. <P> May be left unset
     * in which case the standard text box style is always applied. Has no effect if {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAddUnknownValues addUnknownValues} is true.
     *
     * @param pendingTextBoxStyle . See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName}. Default value is null
     */
    public void setPendingTextBoxStyle(String pendingTextBoxStyle) {
        setAttribute("pendingTextBoxStyle", pendingTextBoxStyle);
    }

    /**
     * Optional "pending" style for this item's text box. <P> If {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAddUnknownValues addUnknownValues} is false, when the user
     * modifies the value displayed in the combobox item text box, the underlying data value (as returned from item.getValue())
     * is not immediately updated - instead the value is used to filter the set of results displayed in the comboBoxItem
     * pickList. <P> While the comboBoxItem is in this pending state (where the result of getEnteredValue() will not
     * necessarily match the display value for whatever is returned by getValue()), the  pendingTextBoxStyle may be applied to
     * the text box for the item. <P> When the element value is updated to display the actual value for the item (typically due
     * to the user selecting a value from the pickList), the standard  {@link
     * com.smartgwt.client.widgets.form.fields.TextItem#getTextBoxStyle textBoxStyle} will be reapplied. <P> May be left unset
     * in which case the standard text box style is always applied. Has no effect if {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAddUnknownValues addUnknownValues} is true.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName}
     */
    public String getPendingTextBoxStyle()  {
        return getAttributeAsString("pendingTextBoxStyle");
    }

    /**
     * Don't specify an explicit height for the picker icon - instead have it size to match the height of the combo box item.
     *
     * @param pickerIconHeight pickerIconHeight Default value is null
     */
    public void setPickerIconHeight(Integer pickerIconHeight) {
        setAttribute("pickerIconHeight", pickerIconHeight);
    }

    /**
     * Don't specify an explicit height for the picker icon - instead have it size to match the height of the combo box item.
     *
     *
     * @return Integer
     */
    public Integer getPickerIconHeight()  {
        return getAttributeAsInt("pickerIconHeight");
    }

    /**
     * Src for the picker icon.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param pickerIconSrc . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}. Default value is "[SKIN]/DynamicForm/ComboBoxItem_PickButton_icon.gif"
     */
    public void setPickerIconSrc(String pickerIconSrc) {
        setAttribute("pickerIconSrc", pickerIconSrc);
    }

    /**
     * Src for the picker icon.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}
     */
    public String getPickerIconSrc()  {
        return getAttributeAsString("pickerIconSrc");
    }

    /**
     * If this item has a databound pickList (for example  optionDataSource is set), this property can be used to provide
     * static filter criteria when retrieving the data for the pickList.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param pickListCriteria pickListCriteria Default value is null
     */
    public void setPickListCriteria(Criteria pickListCriteria) {
        setAttribute("pickListCriteria", pickListCriteria.getJsObj());
    }

    /**
     * If this item has a databound pickList (for example  optionDataSource is set), this property can be used to provide
     * static filter criteria when retrieving the data for the pickList.
     *
     *
     * @return Criteria
     */
    public Criteria getPickListCriteria()  {
        return new Criteria(getAttributeAsJavaScriptObject("pickListCriteria"));
    }

    /**
     * Indicates whether or not this ComboBoxItem will load its list of options  {@link
     * com.smartgwt.client.data.DataSource#getProgressiveLoading progressively}.  This property is copied onto the underlying
     * PickList.
     *
     * @param progressiveLoading progressiveLoading Default value is true
     * @see com.smartgwt.client.data.DataSource#setProgressiveLoading
     * @see com.smartgwt.client.docs.ProgressiveLoading ProgressiveLoading overview and related methods
     */
    public void setProgressiveLoading(Boolean progressiveLoading) {
        setAttribute("progressiveLoading", progressiveLoading);
    }

    /**
     * Indicates whether or not this ComboBoxItem will load its list of options  {@link
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
     * ComboBox items will submit their containing form on enter keypress  if {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getSaveOnEnter saveOnEnter} is true. Setting this property to
     * <code>false</code> will disable this behavior. <P> Note that if the drop down list of options (pickList) is visible an
     * <code>Enter</code> keypress is used to select a value from the available set of options and will not automatically cause
     * form submission.
     *
     * @param saveOnEnter saveOnEnter Default value is true
     */
    public void setSaveOnEnter(Boolean saveOnEnter) {
        setAttribute("saveOnEnter", saveOnEnter);
    }

    /**
     * ComboBox items will submit their containing form on enter keypress  if {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getSaveOnEnter saveOnEnter} is true. Setting this property to
     * <code>false</code> will disable this behavior. <P> Note that if the drop down list of options (pickList) is visible an
     * <code>Enter</code> keypress is used to select a value from the available set of options and will not automatically cause
     * form submission.
     *
     *
     * @return Boolean
     */
    public Boolean getSaveOnEnter()  {
        return getAttributeAsBoolean("saveOnEnter");
    }

    /**
     * If true, even non-matching options will be shown, with configurable  {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getSeparatorRows separator rows} in between.  Not valid for {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getOptionDataSource databound pickLists}.
     *
     * @param showAllOptions showAllOptions Default value is null
     */
    public void setShowAllOptions(Boolean showAllOptions) {
        setAttribute("showAllOptions", showAllOptions);
    }

    /**
     * If true, even non-matching options will be shown, with configurable  {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getSeparatorRows separator rows} in between.  Not valid for {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getOptionDataSource databound pickLists}.
     *
     *
     * @return Boolean
     */
    public Boolean getShowAllOptions()  {
        return getAttributeAsBoolean("showAllOptions");
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
     * Show the picker icon for the ComboBox.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showPickerIcon showPickerIcon Default value is true
     */
    public void setShowPickerIcon(Boolean showPickerIcon) {
        setAttribute("showPickerIcon", showPickerIcon);
    }

    /**
     * Show the picker icon for the ComboBox.
     *
     *
     * @return Boolean
     */
    public Boolean getShowPickerIcon()  {
        return getAttributeAsBoolean("showPickerIcon");
    }

    /**
     * Should the list of options be displayed whenever the user types into the  the combo-box textArea, or only when the user
     * clicks on the pick button or uses the  explicit <code>Alt+Arrow Down</code> key combination?
     *
     * @param showPickListOnKeypress showPickListOnKeypress Default value is true
     */
    public void setShowPickListOnKeypress(Boolean showPickListOnKeypress) {
        setAttribute("showPickListOnKeypress", showPickListOnKeypress);
    }

    /**
     * Should the list of options be displayed whenever the user types into the  the combo-box textArea, or only when the user
     * clicks on the pick button or uses the  explicit <code>Alt+Arrow Down</code> key combination?
     *
     *
     * @return Boolean
     */
    public Boolean getShowPickListOnKeypress()  {
        return getAttributeAsBoolean("showPickListOnKeypress");
    }

    /**
     * Specifies the field by which this item should be initially sorted.  Can be set to  either a {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getName field name} or the index of the field in the fields  Array. Note
     * that if <code>sortField</code> is initially specified as a number, it will be converted to a string (field name) after
     * the item is initialized.
     *
     * @param sortField . See {@link com.smartgwt.client.docs.String String}. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_sort_sort" target="examples">Sort Example</a>
     */
    public void setSortField(String sortField) {
        setAttribute("sortField", sortField);
    }

    /**
     * Specifies the field by which this item should be initially sorted.  Can be set to  either a {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getName field name} or the index of the field in the fields  Array. Note
     * that if <code>sortField</code> is initially specified as a number, it will be converted to a string (field name) after
     * the item is initialized.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_sort_sort" target="examples">Sort Example</a>
     */
    public String getSortField()  {
        return getAttributeAsString("sortField");
    }

    /**
     * Specifies the field by which this item should be initially sorted.  Can be set to  either a {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getName field name} or the index of the field in the fields  Array. Note
     * that if <code>sortField</code> is initially specified as a number, it will be converted to a string (field name) after
     * the item is initialized.
     *
     * @param sortField sortField Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_sort_sort" target="examples">Sort Example</a>
     */
    public void setSortField(Integer sortField) {
        setAttribute("sortField", sortField);
    }

    /**
     * When applying filter criteria to pickList data, what type of matching to use. <P> For a databound pickList ({@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getOptionDataSource optionDataSource} set),
     * <code>textMatchStyle</code> is sent to the server as {@link com.smartgwt.client.data.DSRequest#getTextMatchStyle
     * textMatchStyle}. <P> For a non-databound pickList, <code>textMatchStyle</code> is applied by  {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#filterClientPickListData ComboBoxItem.filterClientPickListData}.
     *
     * @param textMatchStyle textMatchStyle Default value is "startsWith"
     */
    public void setTextMatchStyle(TextMatchStyle textMatchStyle) {
        setAttribute("textMatchStyle", textMatchStyle == null ? null : textMatchStyle.getValue());
    }

    /**
     * When applying filter criteria to pickList data, what type of matching to use. <P> For a databound pickList ({@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getOptionDataSource optionDataSource} set),
     * <code>textMatchStyle</code> is sent to the server as {@link com.smartgwt.client.data.DSRequest#getTextMatchStyle
     * textMatchStyle}. <P> For a non-databound pickList, <code>textMatchStyle</code> is applied by  {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#filterClientPickListData ComboBoxItem.filterClientPickListData}.
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
     * @param valueField . See {@link com.smartgwt.client.docs.String String}. Default value is null
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
     * @return . See {@link com.smartgwt.client.docs.String String}
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
        var dataArrived = $entry(function(){
            var param = {"startRow" : arguments[0], "endRow" : arguments[1], "data" : arguments[2]};
            var event = @com.smartgwt.client.widgets.form.fields.events.DataArrivedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        obj.dataArrived =  dataArrived         ;
   }-*/;

    /**
     * Expression evaluated to determine the {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getDefaultValue
     * defaultValue} when no value is  provided for this item. To default to the first option use {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getDefaultToFirstOption defaultToFirstOption} instead.
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
     * Returns the raw text value typed into this form field, which can differ from  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValue FormItem.getValue} in various cases - for example: <ul>
     * <li>for items that constrain the value range, such as a {@link com.smartgwt.client.widgets.form.fields.DateItem} with
     * {@link com.smartgwt.client.widgets.form.fields.DateItem#getEnforceDate enforceDate}:true, or a {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem} with {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAddUnknownValues addUnknownValues}:false</li> <li>for items with
     * a defined valueMap or edit value formatter and parser functions which converts display value to data value</li>
     * <li>while the item has focus if {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getChangeOnKeypress
     * changeOnKeypress} is false </li></ul>
     *
     * @return current entered value
     */
    public native String getEnteredValue() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        return self.getEnteredValue();
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

    /**
     * Will this item return advancedCriteria if {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria
     * DynamicForm.getValuesAsCriteria} is  called on this item's form? Overridden for ComboBoxItem to return true if {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getGenerateExactMatchCriteria generateExactMatchCriteria} is true -
     * in this case if an exact value is chosen from our set of options (always the case if <code>addUnkownValues</code> is
     * false), we will use advancedCriteria to ensure the generated search criteria exactly matches the chosen value for this
     * item. <P> Note that {@link com.smartgwt.client.data.AdvancedCriteria} are not supported by all dataSources. When a form
     * is bound to a dataSource, we therefore default <code>generateExactMatchCriteria</code> to false unless the dataSource is
     * known to support AdvancedCriteria. <P> As with formItem.hasAdvancedCriteria() this will also return true if a Operator
     * was explicitly specified for this item
     *
     * @return true if the result of getCriterion() will be an AdvancedCriteria object.
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public native Boolean hasAdvancedCriteria() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var retVal =self.hasAdvancedCriteria();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * When a comboBoxItem is used to generate search criteria in a SearchForm,  if the user explicitly chose an option from
     * the pickList, should the criterion generated by  the <code>FormItemCriterionGetter</code>'s <code>getCriterion()</code>
     * method enforce a search for an exact match against the chosen value? <P> In order to achieve this, when this property is
     * set to true, this item will generate {@link com.smartgwt.client.data.AdvancedCriteria} in  the default
     * <code>FormItemCriterionGetter</code>'s <code>getCriterion()</code> method. <P> Default implementation will return {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getGenerateExactMatchCriteria generateExactMatchCriteria} if
     * specified, otherwise true if the DataSource for this item  {@link
     * com.smartgwt.client.data.DataSource#supportsAdvancedCriteria supports advanced criteria}, false if it does not.
     *
     * @return should getCriterion() generate exact-match search criteria when   a value was explicitly chosen from this item's set of
     * options?
     */
    public native Boolean shouldGenerateExactMatchCriteria() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var retVal =self.shouldGenerateExactMatchCriteria();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    // ********************* Static Methods ***********************
        
    // ***********************************************************        


    static {
        init();
    }

    private static native void init()/*-{
        // Make getPickListFilterCriteria an override point. We recommend using setPickListFilterCriteriaFunction instead
        // but support both.
        if ($wnd.isc.ComboBoxItem.getPrototype().__getPickListFilterCriteria == null) {
            $wnd.isc.ComboBoxItem.getPrototype().__getPickListFilterCriteria = $wnd.isc.ComboBoxItem.getPrototype().getPickListFilterCriteria;
            $wnd.isc.ComboBoxItem.getPrototype().getPickListFilterCriteria = $entry(function() {
                var jObj = this.__ref;
                //if widget was not created in in java via smartgwt, fallback to old behavior
                if(jObj && @com.smartgwt.client.widgets.form.fields.ComboBoxItem::isComboBoxItem(Lcom/smartgwt/client/widgets/form/fields/FormItem;)(jObj)) {
                    jObj.@com.smartgwt.client.widgets.form.fields.ComboBoxItem::setJsObj(Lcom/google/gwt/core/client/JavaScriptObject;)(this);
                    var critJ = jObj.@com.smartgwt.client.widgets.form.fields.ComboBoxItem::getPickListFilterCriteria()();
                    return critJ == null ? {} : critJ.@com.smartgwt.client.data.Criteria::getJsObj()();
                } else {
                    return this.__getPickListFilterCriteria();
                }
            });
        }
    }-*/;

    private static boolean isComboBoxItem(FormItem formItem) {
        return formItem instanceof ComboBoxItem;
    }
    
    /**
     * Returns filter criteria for options displayed for this item.
     * <P>
     * See {@link com.smartgwt.client.docs.ComboBoxFiltering} for details on how pickList filter criteria
     * are calculated by default for a comboBoxItem.
     * <P>
     * Note : this is an override point - if overridden this method will be called by the live form item during filtering.
     * However it is recommended that developers use
     * {@link #setPickListFilterCriteriaFunction(FormItemCriteriaFunction)} to build custom criteria instead of overriding this method directly. This ensures that
     * the custom filter criteria generating code will be called even if the form item was automatically generated based on a template 
     * passed to {@link com.smartgwt.client.widgets.grid.ListGridField#setEditorType}.
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

    public void setPickListCriteria(DSRequest optionFilterContext) {
        setAttribute("optionFilterContext", optionFilterContext);
    }

    public void setFetchDelay(Integer fetchDelay) {
        setAttribute("fetchDelay", fetchDelay);
    }

    public Integer getFetchDelay() {
        return getAttributeAsInt("fetchDelay");
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
     * If set, this FormItem will derive data to show in the PickList by fetching records from the specified
     * <code>optionDataSource</code>.  The fetched data will be used as a {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueMap
     * valueMap} by extracting the {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueField valueField} and
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} in the loaded records, to
     * derive one valueMap entry per record loaded from the optionDataSource.  Multiple fields from the fetched data may
     * be shown in the pickList by setting {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickListFields
     * pickListFields}. <P> The data will be retrieved via a "fetch" operation on the DataSource, passing the  {@link
     * com.smartgwt.client.widgets.form.fields.PickList#getPickListCriteria pickListCriteria} (if set) as criteria, and passing {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getOptionFilterContext optionFilterContext} (if set) as
     * DSRequest properties. <P> The fetch will be triggered when the pickList is first shown, or, you can set {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getAutoFetchData autoFetchData} to fetch when the FormItem is
     * first drawn.  You can also call {@link com.smartgwt.client.widgets.form.fields.PickList#fetchData} at any time to manually  trigger
     * a fetch. <P> Data paging is automatically enabled if the optionDataSource supports it.  As the pickList is
     * scrolled by the user, requests for additional data will be automatically issued. <P> For a pickList attached to a
     * ComboBoxItem, new fetches are issued as the user types, with criteria set as described under {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickListFilterCriteria}. If your dataSource is not
     * capable of filtering results by search criteria (eg the dataSource is backed by an XML flat file), you can set
     * {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getFilterLocally filterLocally} to have the entire
     * dataset loaded up front and filtering performed in the browser.  This disables data paging. <P> Setting
     * optionDataSource also enables the basic {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * optionDataSource} behaviors, eg, fetching individual display values before the pickList is shown. <P> Note that
     * if a normal, static {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueMap valueMap} is <b>also</b>
     * specified for the field (either directly in the form item or as part of the field definition in the dataSource),
     * it will be preferred to the data derived from the optionDataSource for whatever mappings are present. <p><b>Note
     * : </b> This is an advanced setting</p>
     *
     * @param dataSource optionDataSource Default value is null
     */
    public void setOptionDataSource(DataSource dataSource) {
        setAttribute("optionDataSource", dataSource);
    }

    public DataSource getOptionDataSource() {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("optionDataSource"));
    }

    /**
     * Array of records to show between matching and non-matching rows in the PickList. <P> Not valid for {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getOptionDataSource optionDataSource}.
     *
     * @param separatorRows separatorRows Default value is [{isSeparator:true}]
     */
    public void setSeparatorRows(ListGridRecord[] separatorRows) {
        setAttribute("separatorRows", separatorRows);
    }

    // ********************* Methods ***********************

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


    public void setPickListFields(ListGridField... pickListFields) {
        setAttribute("pickListFields", pickListFields);
    }

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
     * <P>
     * See {@link com.smartgwt.client.docs.ComboBoxFiltering} for details on how pickListCriteria are
     * calcualted by default for a ComboBoxItem.
     */
    public native void setPickListFilterCriteriaFunction(FormItemCriteriaFunction filterCriteriaFunction) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.getPickListFilterCriteria = $entry(function() {
            var context = @com.smartgwt.client.widgets.form.fields.FormItemFunctionContext::new()();
            var itemJ = @com.smartgwt.client.widgets.form.fields.ComboBoxItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(this);
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

    /**
     * The default <code>canEditCriterion()</code> predicate is overridden in comboBoxItem. When addUnknownValues is true,
     * comboBoxItems allow the user to edit substring match type criteria applied to the display field (if one is specified).
     * <P> The user can also edit criteria attempting to match exactly against the item's field name.
     * @param predicate the predicate to determine the form items that can edit the criterion in question
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setCanEditCriterionPredicate FormItem.setCanEditCriterionPredicate
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public void setCanEditCriterionPredicate(FormItemCanEditCriterionPredicate predicate) {
        super.setCanEditCriterionPredicate(predicate);
    }

    /**
     * The default <code>getCriterion()</code> implementation returns criterion derived from the current value of this item.
     * <P> If {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAddUnknownValues addUnknownValues} is true for
     * this item, we implement the following behavior.<br> If the user explicitly selected an item from the pickList, we treat
     * this as an attempt to explicitly match the data value. In this case returned criteria will match the selected (data) value
     * against this item's fieldName.<br> If the user typed a value into the text field, we treat this as an attempt to do a substring
     * type filter. In this case returned criteria will match the entered text value against the displayField for this item if
     * one is specified. <P> If {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAddUnknownValues
     * addUnknownValues} is false we always match the chosen data value against the item's  fieldName. <P> Note that {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#shouldGenerateExactMatchCriteria
     * ComboBoxItem.shouldGenerateExactMatchCriteria} will be called in the case when a value was explicitly picked from the
     * set of options. If that method returns true, we will return AdvancedCriteria with an operator specified to ensure an
     * exact match occurs.
     * @param getter provides a method to get a criterion object based on this field's current edited value(s).
     *
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setCriterionGetter
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public void setCriterionGetter(FormItemCriterionGetter getter) {
        super.setCriterionGetter(getter);
    }

    /**
     * The default <code>setCriterion()</code> implementation is overridden to support editing criterion against the display field
     * or value field when {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getAddUnknownValues addUnknownValues} is true.
     * @param setter provides a method to update this field with the edited criterion
     */
    public void setCriterionSetter(FormItemCriterionSetter setter) {
        super.setCriterionSetter(setter);
    }

   /**
     * This method sorts the pickList on one or more fields, creating the underlying JS object
     * if needed. Pass in an array of SortSpecifiers to have the grid's data sorted by the fields in each
     * specifier.property and in the directions specified.  The grid can be sorted by any combination
     * of fields, including fields specified in the fields array, whether visible or hidden, and 
     * {@link com.smartgwt.client.data.DataSource#getFields 'unused fields from the underlying dataSource'},
     * if there is one.  If multiple fields are sorted, those that are visible show a directional icon and a small 
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getSortNumeralStyle 'sort-numeral'} indicating that 
     * field's index in the sort configuration. 
     * <P>
     * See {@link com.smartgwt.client.widgets.grid.ListGrid#addSort} 
     * and {@link com.smartgwt.client.widgets.grid.ListGrid#alterSort} 
     * APIs for information on making changes to the current sort configuration.
     * @param sortSpecifiers Array of SortSpecifier objects
     */
    public native void setSort(SortSpecifier[] sortSpecifiers) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()(),
            specifiers = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(sortSpecifiers);
        if (self != null && self.pickList != null) self.pickList.setSort(specifiers);
        else {
            var configJS = this.@com.smartgwt.client.core.DataClass::getAttributeAsJavaScriptObject(Ljava/lang/String;)("pickListProperties");
            if (configJS == null) {
                configJS = {};
                this.@com.smartgwt.client.core.DataClass::setAttribute(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)("pickListProperties", configJS);
            }
            configJS.initialSort = specifiers;
        }
    }-*/;

}



