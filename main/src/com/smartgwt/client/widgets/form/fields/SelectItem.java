/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
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
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.EnumUtil;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
   /**
    * FormItem that allows picking between several mutually exclusive options via a select list. <P> Options may be derived from a <code>dataSource</code> or a <code>valueMap</code> <P> Note that to select the first option as a default value for the item, {@link com.smartgwt.client.widgets.form.fields.SelectItem#getDefaultToFirstOption defaultToFirstOption} may be set.

    */
public class SelectItem extends FormItem  implements PickList {

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
        setType("SelectItem");
    }

    public SelectItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public SelectItem(String name) {
        setName(name);
        setType("SelectItem");
    }

    // ********************* Properties / Attributes ***********************

    /**
    * Default height for select items is 19px.
    *
    * @param height height Default value is 19
    */
    public void setHeight(int height) {
        setAttribute("height", height);
    }
    /**
     * Default height for select items is 19px.
     *
     *
     * @return int
     *
     */
    public int getHeight()  {
        return getAttributeAsInt("height");
    }

    /**
    * If we're setting the value of a select item and the value isn't a legal value in the valueMap, whether we should allow the value (creating a new option for it) or reject it. <P> Exception: If the value is set to <code>null</code> but there is no null entry in the valueMap for this item, setting <code>addUnknownValues</code> to true will not cause a null option to show up at the top of the select item pickList. Whether an empty  option is shown in the pickList is governed by {@link com.smartgwt.client.widgets.form.fields.SelectItem#getAllowEmptyValue allowEmptyValue} instead.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param addUnknownValues addUnknownValues Default value is true
    */
    public void setAddUnknownValues(Boolean addUnknownValues) {
        setAttribute("addUnknownValues", addUnknownValues);
    }
    /**
     * If we're setting the value of a select item and the value isn't a legal value in the valueMap, whether we should allow the value (creating a new option for it) or reject it. <P> Exception: If the value is set to <code>null</code> but there is no null entry in the valueMap for this item, setting <code>addUnknownValues</code> to true will not cause a null option to show up at the top of the select item pickList. Whether an empty  option is shown in the pickList is governed by {@link com.smartgwt.client.widgets.form.fields.SelectItem#getAllowEmptyValue allowEmptyValue} instead.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getAddUnknownValues()  {
        return getAttributeAsBoolean("addUnknownValues");
    }

    /**
    * Static default value for this SelectItem. To default to the first option use {@link com.smartgwt.client.widgets.form.fields.SelectItem#getDefaultToFirstOption defaultToFirstOption} instead.
    *
    * @param defaultValue defaultValue Default value is null
    */
    public void setDefaultValue(Boolean defaultValue) {
        setAttribute("defaultValue", defaultValue);
    }
    /**
     * Static default value for this SelectItem. To default to the first option use {@link com.smartgwt.client.widgets.form.fields.SelectItem#getDefaultToFirstOption defaultToFirstOption} instead.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getDefaultValue()  {
        return getAttributeAsBoolean("defaultValue");
    }

    /**
    * Select the first option as the default value for this SelectItem. If options are derived from a dataSource, the first value returned by the server will be used, otherwise the first value in the valueMap. If enabled, this setting overrides {@link com.smartgwt.client.widgets.form.fields.SelectItem#getDefaultValue defaultValue} and {@link com.smartgwt.client.widgets.form.fields.SelectItem#defaultDynamicValue}.
    *
    * @param defaultToFirstOption defaultToFirstOption Default value is false
    */
    public void setDefaultToFirstOption(Boolean defaultToFirstOption) {
        setAttribute("defaultToFirstOption", defaultToFirstOption);
    }
    /**
     * Select the first option as the default value for this SelectItem. If options are derived from a dataSource, the first value returned by the server will be used, otherwise the first value in the valueMap. If enabled, this setting overrides {@link com.smartgwt.client.widgets.form.fields.SelectItem#getDefaultValue defaultValue} and {@link com.smartgwt.client.widgets.form.fields.SelectItem#defaultDynamicValue}.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getDefaultToFirstOption()  {
        return getAttributeAsBoolean("defaultToFirstOption");
    }

    /**
    * Should we show a special 'picker' icon for this form item. Picker icons are customizeable via {@link com.smartgwt.client.widgets.form.fields.SelectItem#getPickerIconProperties pickerIconProperties}. By default they will be rendered inside the  Form Item's "control box" area, and will call {@link com.smartgwt.client.widgets.form.fields.SelectItem#showPicker} when clicked.
    *
    * @param showPickerIcon showPickerIcon Default value is true
    */
    public void setShowPickerIcon(Boolean showPickerIcon) {
        setAttribute("showPickerIcon", showPickerIcon);
    }
    /**
     * Should we show a special 'picker' icon for this form item. Picker icons are customizeable via {@link com.smartgwt.client.widgets.form.fields.SelectItem#getPickerIconProperties pickerIconProperties}. By default they will be rendered inside the  Form Item's "control box" area, and will call {@link com.smartgwt.client.widgets.form.fields.SelectItem#showPicker} when clicked.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowPickerIcon()  {
        return getAttributeAsBoolean("showPickerIcon");
    }

    /**
    * Base CSS class name for a form item's text box element. <P> NOTE: See the ${isc.DocUtils.linkForRef('group:CompoundFormItem_skinning')} discussion for special skinning considerations.
    *
    * @param textBoxStyle textBoxStyle Default value is "selectItemText", [IRA]
    */
    public void setTextBoxStyle(String textBoxStyle) {
        setAttribute("textBoxStyle", textBoxStyle);
    }
    /**
     * Base CSS class name for a form item's text box element. <P> NOTE: See the ${isc.DocUtils.linkForRef('group:CompoundFormItem_skinning')} discussion for special skinning considerations.
     *
     *
     * @return String
     *
     */
    public String getTextBoxStyle()  {
        return getAttributeAsString("textBoxStyle");
    }

    /**
    * Base CSS class name for a form item's control box (surrounds text box and picker). <P> NOTE: See the ${isc.DocUtils.linkForRef('group:CompoundFormItem_skinning')} discussion for special skinning considerations.
    *
    * @param controlStyle controlStyle Default value is "selectItemControl", [IRA]
    */
    public void setControlStyle(String controlStyle) {
        setAttribute("controlStyle", controlStyle);
    }
    /**
     * Base CSS class name for a form item's control box (surrounds text box and picker). <P> NOTE: See the ${isc.DocUtils.linkForRef('group:CompoundFormItem_skinning')} discussion for special skinning considerations.
     *
     *
     * @return String
     *
     */
    public String getControlStyle()  {
        return getAttributeAsString("controlStyle");
    }

    /**
    * Base CSS class name for a form item's picker icon cell. If unset inherits from  this items <code>controlStyle</code>.
    *
    * @param pickerIconStyle pickerIconStyle Default value is "selectItemPickerIcon", [IRA]
    */
    public void setPickerIconStyle(String pickerIconStyle) {
        setAttribute("pickerIconStyle", pickerIconStyle);
    }
    /**
     * Base CSS class name for a form item's picker icon cell. If unset inherits from  this items <code>controlStyle</code>.
     *
     *
     * @return String
     *
     */
    public String getPickerIconStyle()  {
        return getAttributeAsString("pickerIconStyle");
    }

    /**
    * When this item recieves focus, should it be re-styled to indicate it has focus?
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param showFocused showFocused Default value is true, [IRWA]
    */
    public void setShowFocused(Boolean showFocused) {
        setAttribute("showFocused", showFocused);
    }
    /**
     * When this item recieves focus, should it be re-styled to indicate it has focus?
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowFocused()  {
        return getAttributeAsBoolean("showFocused");
    }

    /**
    * If {@link com.smartgwt.client.widgets.form.fields.SelectItem#getShowPickerIcon showPickerIcon} is true for this item, this property governs the size of the picker icon. If unset picker icon will be sized as a square to fit in the avaliable height for the icon.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param pickerIconWidth pickerIconWidth Default value is null
    */
    public void setPickerIconWidth(Integer pickerIconWidth) {
        setAttribute("pickerIconWidth", pickerIconWidth);
    }
    /**
     * If {@link com.smartgwt.client.widgets.form.fields.SelectItem#getShowPickerIcon showPickerIcon} is true for this item, this property governs the size of the picker icon. If unset picker icon will be sized as a square to fit in the avaliable height for the icon.
     *
     *
     * @return Integer
     *
     */
    public Integer getPickerIconWidth()  {
        return getAttributeAsInt("pickerIconWidth");
    }

    /**
    * If {@link com.smartgwt.client.widgets.form.fields.SelectItem#getShowPickerIcon showPickerIcon} is true for this item, this property governs the size of the picker icon. If unset picker icon will be sized as a square to fit in the avaliable height for the icon.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param pickerIconHeight pickerIconHeight Default value is null
    */
    public void setPickerIconHeight(Integer pickerIconHeight) {
        setAttribute("pickerIconHeight", pickerIconHeight);
    }
    /**
     * If {@link com.smartgwt.client.widgets.form.fields.SelectItem#getShowPickerIcon showPickerIcon} is true for this item, this property governs the size of the picker icon. If unset picker icon will be sized as a square to fit in the avaliable height for the icon.
     *
     *
     * @return Integer
     *
     */
    public Integer getPickerIconHeight()  {
        return getAttributeAsInt("pickerIconHeight");
    }

    /**
    * If {@link com.smartgwt.client.widgets.form.fields.SelectItem#getShowPickerIcon showPickerIcon} is true for this item, this property governs the src of the picker icon image to be displayed.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param pickerIconSrc pickerIconSrc Default value is "[SKIN]/DynamicForm/SelectItem_PickButton_icon.gif"
    */
    public void setPickerIconSrc(String pickerIconSrc) {
        setAttribute("pickerIconSrc", pickerIconSrc);
    }
    /**
     * If {@link com.smartgwt.client.widgets.form.fields.SelectItem#getShowPickerIcon showPickerIcon} is true for this item, this property governs the src of the picker icon image to be displayed.
     *
     *
     * @return String
     *
     */
    public String getPickerIconSrc()  {
        return getAttributeAsString("pickerIconSrc");
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
     *
     */
    public Boolean getShowOver()  {
        return getAttributeAsBoolean("showOver");
    }

    /**
    * If set to true, always show an empty option in this item's pickList, allowing the user to clear the value (even if there is no empty entry in the valueMap for the item). <P> The empty value will be displayed with the {@link com.smartgwt.client.widgets.form.fields.FormItem#getEmptyDisplayValue emptyDisplayValue}. <P> With a {@link com.smartgwt.client.widgets.form.fields.SelectItem#getOptionDataSource optionDataSource}, enabling <code>allowEmptyValue</code> disables data paging - all data matching the {@link com.smartgwt.client..PickList#getPickListCriteria pickListCriteria} will be requested.
    *
    * @param allowEmptyValue allowEmptyValue Default value is false
    */
    public void setAllowEmptyValue(Boolean allowEmptyValue) {
        setAttribute("allowEmptyValue", allowEmptyValue);
    }
    /**
     * If set to true, always show an empty option in this item's pickList, allowing the user to clear the value (even if there is no empty entry in the valueMap for the item). <P> The empty value will be displayed with the {@link com.smartgwt.client.widgets.form.fields.FormItem#getEmptyDisplayValue emptyDisplayValue}. <P> With a {@link com.smartgwt.client.widgets.form.fields.SelectItem#getOptionDataSource optionDataSource}, enabling <code>allowEmptyValue</code> disables data paging - all data matching the {@link com.smartgwt.client..PickList#getPickListCriteria pickListCriteria} will be requested.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getAllowEmptyValue()  {
        return getAttributeAsBoolean("allowEmptyValue");
    }

    /**
    * If this select item retrieves its options from a <code>dataSource</code>, should options be fetched from the server when the item is first written out, or should this fetch be delayed until the user opens the pickList.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param autoFetchData autoFetchData Default value is true
    */
    public void setAutoFetchData(Boolean autoFetchData) {
        setAttribute("autoFetchData", autoFetchData);
    }
    /**
     * If this select item retrieves its options from a <code>dataSource</code>, should options be fetched from the server when the item is first written out, or should this fetch be delayed until the user opens the pickList.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getAutoFetchData()  {
        return getAttributeAsBoolean("autoFetchData");
    }

    /**
    * Specifies an alternative field from which display values should be retrieved for this item.<br> If this item is not databound ({@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource} is unset), or bound  to the same dataSource as the form as a whole, this is implemented by picking up the value of the specified field from the Form's values object.<br> Otherwise this item will attempt to map its underlying value to a display value by retrieving a record from the {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource} where the  {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueField valueField} matches this item's value, and displaying the  <code>displayField</code> value from that record.<br> This essentially enables the specified <code>optionDataSource</code> to be used as a server based ${isc.DocUtils.linkForRef('group:valueMap')}.
    *
    * @param displayField displayField Default value is null
    */
    public void setDisplayField(String displayField) {
        setAttribute("displayField", displayField);
    }
    /**
     * Specifies an alternative field from which display values should be retrieved for this item.<br> If this item is not databound ({@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource} is unset), or bound  to the same dataSource as the form as a whole, this is implemented by picking up the value of the specified field from the Form's values object.<br> Otherwise this item will attempt to map its underlying value to a display value by retrieving a record from the {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource} where the  {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueField valueField} matches this item's value, and displaying the  <code>displayField</code> value from that record.<br> This essentially enables the specified <code>optionDataSource</code> to be used as a server based ${isc.DocUtils.linkForRef('group:valueMap')}.
     *
     *
     * @return String
     *
     */
    public String getDisplayField()  {
        return getAttributeAsString("displayField");
    }

    /**
    * If this form item maps data values to display values by retrieving the  {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} values from an  {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource}, this property  denotes the the field to use as the underlying data value in records from the  optionDataSource.<br> If unset, assumed to be the {@link com.smartgwt.client.widgets.form.fields.FormItem#getName name} of this form item.
    *
    * @param valueField valueField Default value is null
    */
    public void setValueField(String valueField) {
        setAttribute("valueField", valueField);
    }
    /**
     * If this form item maps data values to display values by retrieving the  {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} values from an  {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource}, this property  denotes the the field to use as the underlying data value in records from the  optionDataSource.<br> If unset, assumed to be the {@link com.smartgwt.client.widgets.form.fields.FormItem#getName name} of this form item.
     *
     *
     * @return String
     *
     */
    public String getValueField()  {
        return getAttributeAsString("valueField");
    }

    /**
    * If <code>filterLocally</code> is set for this item, and this item is showing options  from a dataSource, fetch the entire set of options from the server, and use these values to map the item value to the appropriate display value. Also use <code>"local"</code> type filtering on drop down list of options.<br> This means data will only be fetched once from the server, and then filtered on the client.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param filterLocally filterLocally Default value is false
    */
    public void setFilterLocally(Boolean filterLocally) {
        setAttribute("filterLocally", filterLocally);
    }
    /**
     * If <code>filterLocally</code> is set for this item, and this item is showing options  from a dataSource, fetch the entire set of options from the server, and use these values to map the item value to the appropriate display value. Also use <code>"local"</code> type filtering on drop down list of options.<br> This means data will only be fetched once from the server, and then filtered on the client.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getFilterLocally()  {
        return getAttributeAsBoolean("filterLocally");
    }

    /**
    * If this item is part of a databound form, and has a specified <code>valueMap</code> by default we show the valueMap options in the pickList for the item. Setting this property to true will ensure that the options displayed in our pickList are derived from the form's <code>dataSource</code>.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param showOptionsFromDataSource showOptionsFromDataSource Default value is null
    */
    public void setShowOptionsFromDataSource(Boolean showOptionsFromDataSource) {
        setAttribute("showOptionsFromDataSource", showOptionsFromDataSource);
    }
    /**
     * If this item is part of a databound form, and has a specified <code>valueMap</code> by default we show the valueMap options in the pickList for the item. Setting this property to true will ensure that the options displayed in our pickList are derived from the form's <code>dataSource</code>.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowOptionsFromDataSource()  {
        return getAttributeAsBoolean("showOptionsFromDataSource");
    }

    /**
    * If true, this selectItem will be displayed as a tall list of options, and the user will be able to select multiple options. <P> In this case the logical value of the formItem, as retrieved by  {@link com.smartgwt.client.widgets.form.fields.FormItem#getValue} and set via {@link com.smartgwt.client.widgets.form.fields.FormItem#setValue}, is  an Array of Strings reflecting the selected values. <P> Note: <code>multiple:true</code> SelectItems do not currently support optionDataSource binding.  You can get around this by calling DataSource.fetchData() directly and creating a valueMap for the item from the resulting array.
    *
    * @param multiple multiple Default value is false
    */
    public void setMultiple(Boolean multiple) {
        setAttribute("multiple", multiple);
    }
    /**
     * If true, this selectItem will be displayed as a tall list of options, and the user will be able to select multiple options. <P> In this case the logical value of the formItem, as retrieved by  {@link com.smartgwt.client.widgets.form.fields.FormItem#getValue} and set via {@link com.smartgwt.client.widgets.form.fields.FormItem#setValue}, is  an Array of Strings reflecting the selected values. <P> Note: <code>multiple:true</code> SelectItems do not currently support optionDataSource binding.  You can get around this by calling DataSource.fetchData() directly and creating a valueMap for the item from the resulting array.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getMultiple()  {
        return getAttributeAsBoolean("multiple");
    }

    // ********************* Methods ***********************

        /**
         * Expression evaluated to determine the {@link com.smartgwt.client.widgets.form.fields.SelectItem#getDefaultValue defaultValue} when no value is provided for this item. To default to the first option use {@link com.smartgwt.client.widgets.form.fields.SelectItem#getDefaultToFirstOption defaultToFirstOption} instead.
         */
        public native void defaultDynamicValue() /*-{
            var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            self.defaultDynamicValue();
        }-*/;



        /**
         * Returns the {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} for this form item. If unset, and {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource} is explicitly specified, this method will return the title field for the <code>optionDataSource</code>
         *
         * @return display field name, or null
         */
        public native String getDisplayFieldName() /*-{
            var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            return self.getDisplayFieldName();
        }-*/;

        /**
         * Getter method to retrieve the {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueField valueField} for this item. If unset, default behavior will return the {@link com.smartgwt.client.widgets.form.fields.FormItem#getName name} of this field.
         *
         * @return fieldName to use a "value field" in records from this items               {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource}
         */
        public native String getValueFieldName() /*-{
            var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            return self.getValueFieldName();
        }-*/;



    // ********************* Static Methods ***********************















    static {
        init();
    }

    private static native void init()/*-{
        $wnd.isc.SelectItem.getPrototype().__getPickListFilterCriteria = $wnd.isc.SelectItem.getPrototype().getPickListFilterCriteria;
        $wnd.isc.SelectItem.getPrototype().getPickListFilterCriteria = function() {
            var jObj = this.__ref;
            //if widget was not creatind in java via smartgwt, fallback to old behavior
            if(jObj) {
                var critJ = jObj.@com.smartgwt.client.widgets.form.fields.SelectItem::getPickListFilterCriteria(Lcom/google/gwt/core/client/JavaScriptObject;)(this);
                return critJ == null ? {} : critJ.@com.smartgwt.client.data.Criteria::getJsObj()();
            } else {
                return this.__getPickListFilterCriteria();
            }
        };
    }-*/;


    /**
     * Returns a set of filter criteria to be applied to the data displayed in the pickList when it is shown.
     * <br>
     * If this is a databound item the criteria will be passed as criteria to DataSource.fetchData(). Otherwise an equivalent client-side filter
     * will be performed on the data returned by PickList.getClientPickListData().
     * <br>
     * By default returns PickList.pickListCriteria if specified, otherwise an empty set of criteria so all records will be displayed.
     *
     * <b>Note : this is an override point</b>
     *
     * @return criteria to be used for databound or local filtering
     */    
    protected native Criteria getPickListFilterCriteria(JavaScriptObject self) /*-{
        var critJS = self.__getPickListFilterCriteria();
        return critJS == null ? null : @com.smartgwt.client.data.Criteria::new(Lcom/google/gwt/core/client/JavaScriptObject;)(critJS);
    }-*/;

    //------------------- From PickList -------

    /**
     * This property allows the developer to specify which field[s] will be displayed in the  drop down list of options.
     * <P> Only applies to databound pickLists (see {@link com.smartgwt.client..PickList#getOptionDataSource
     * optionDataSource}, or picklists with custom data set up via the advanced {@link
     * com.smartgwt.client..PickList#getClientPickListData} method. <P> If this property is unset, we display the {@link
     * com.smartgwt.client..PickList#getDisplayField displayField}, if specified,  otherwise the {@link
     * com.smartgwt.client..PickList#getValueField valueField} <P> If there are multiple fields, column headers will be
     * shown for each field, the height of which can be customized via the {@link com.smartgwt.client..PickList#getPickListHeaderHeight
     * pickListHeaderHeight} attribute. <P> Each field to display should be specified as a
     * ${isc.DocUtils.linkForRef('object:ListGridField')} object. Note that unlike in {@link
     * com.smartgwt.client.widgets.grid.ListGrid}, dataSource fields marked as  ${isc.DocUtils.linkForRef('DataSourceField.display','display:true')}
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
     * When applying filter criteria to pickList data, what type of matching to use.  Legal values are "substring"
     * (value contains user input) or "startsWith" (value starts with user input.  Both matches are case insensitive.
     * <P> For a databound pickList ({@link com.smartgwt.client.widgets.form.fields.PickList#getOptionDataSource
     * optionDataSource} set), <code>textMatchStyle</code> is sent to the server as {@link
     * com.smartgwt.client.data.DSRequest#getTextMatchStyle textMatchStyle}. <P> For a non-databound pickList,
     * <code>textMatchStyle</code> is applied by  {@link com.smartgwt.client.widgets.form.fields.PickList#filterClientPickListData}.
     *
     * @param textMatchStyle textMatchStyle Default value is "startsWith"
     */
    public void setTextMatchStyle(TextMatchStyle textMatchStyle) {
        setAttribute("textMatchStyle", textMatchStyle);
    }

    /**
     * When applying filter criteria to pickList data, what type of matching to use.  Legal values are "substring"
     * (value contains user input) or "startsWith" (value starts with user input.  Both matches are case insensitive.
     * <P> For a databound pickList ({@link com.smartgwt.client.widgets.form.fields.PickList#getOptionDataSource
     * optionDataSource} set), <code>textMatchStyle</code> is sent to the server as {@link
     * com.smartgwt.client.data.DSRequest#getTextMatchStyle textMatchStyle}. <P> For a non-databound pickList,
     * <code>textMatchStyle</code> is applied by  {@link com.smartgwt.client.widgets.form.fields.PickList#filterClientPickListData}.
     *
     * @return TextMatchStyle
     */
    public TextMatchStyle getTextMatchStyle() {
        return TextMatchStyle.valueOf(getAttributeAsString("textMatchStyle"));
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
    public void setPickListCriteria(RPCRequest optionFilterContext) {
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
     * com.smartgwt.client..PickList#getPickListCriteria pickListCriteria} (if set) as criteria, and passing {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getOptionFilterContext optionFilterContext} (if set) as
     * DSRequest properties. <P> The fetch will be triggered when the pickList is first shown, or, you can set {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getAutoFetchData autoFetchData} to fetch when the FormItem is
     * first drawn.  You can also call {@link com.smartgwt.client..PickList#fetchData} at any time to manually  trigger
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

    public void setSeparatorRows(ListGridRecord[] separatorRows) {
        setAttribute("separatorRows", separatorRows);
    }

    // ********************* Methods ***********************
    
    /**
     * Returns the values of a SelectItem with multiple=true as an array of Strings.
     *
     * @return value of selection
     */
    public native String[] getValues() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var value = self.getValue();
        if(!$wnd.isA.Array(value)) {
            value = [value];
        }
        return  @com.smartgwt.client.util.JSOHelper::convertToJavaStringArray(Lcom/google/gwt/core/client/JavaScriptObject;)(value);
    }-*/;

    /**
     * Only applies to databound items (see {@link com.smartgwt.client..PickList#getOptionDataSource
     * optionDataSource}).<br> Performs a fetch type operation on this item's DataSource to retrieve the set of valid
     * options for the item, based on the current {@link com.smartgwt.client..PickList#getPickListCriteria
     * pickListCriteria}.
     */
    public native void fetchData() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.fetchData();
    }-*/;


    /**
     * Only applies to databound items (see {@link com.smartgwt.client..PickList#getOptionDataSource
     * optionDataSource}).<br> Performs a fetch type operation on this item's DataSource to retrieve the set of valid
     * options for the item, based on the current {@link com.smartgwt.client..PickList#getPickListCriteria
     * pickListCriteria}.
     *
     * @param callback Callback to fire when the fetch completes. Callback will               fire with 2 parameters:
     *                 <code>item</code> a pointer to the form item and              <code>dsResponse</code> the {@link
     *                 com.smartgwt.client.data.DSResponse} returned by the server.
     */
    public native void fetchData(DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.fetchData(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        });
    }-*/;

    /**
     * Only applies to databound items (see {@link com.smartgwt.client..PickList#getOptionDataSource
     * optionDataSource}).<br> Performs a fetch type operation on this item's DataSource to retrieve the set of valid
     * options for the item, based on the current {@link com.smartgwt.client..PickList#getPickListCriteria
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
        self.fetchData(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }, requestPropertiesJS);
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



}



