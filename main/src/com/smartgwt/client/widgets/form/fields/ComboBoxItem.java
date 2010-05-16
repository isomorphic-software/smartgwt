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
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * The Combobox is a text input field which can show a list of options via a drop-down PickList. <p> The set of options
 * will be filtered based on the current value in the text field, so only options that match what has been typed so far
 * will be displayed. The set of options can be derived from a ValueMap or dynamically retrieved from a dataSource.  See
 * the PickList interface for further settings. <P> Note that to select the first option as a default value for the item,
 * {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getDefaultToFirstOption defaultToFirstOption} may be set.
 */
public class ComboBoxItem extends FormItem  implements PickList, com.smartgwt.client.widgets.form.fields.events.HasDataArrivedHandlers {

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

    public ComboBoxItem(){
        setType("ComboBoxItem");
    }

    public ComboBoxItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public ComboBoxItem(String name) {
        setName(name);
        setType("ComboBoxItem");
    }

    public ComboBoxItem(String name, String title) {
        setName(name);
		setTitle(title);
        setType("ComboBoxItem");
    }

    // ********************* Properties / Attributes ***********************

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
     * @param displayField displayField Default value is null
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
     */
    public String getDisplayField()  {
        return getAttributeAsString("displayField");
    }

    /**
     * If <code>filterLocally</code> is set for this item, and this item is showing options  from a dataSource, fetch the
     * entire set of options from the server, and use these values to map the item value to the appropriate display value. Also
     * use <code>"local"</code> type filtering on drop down list of options. <P> This means data will only be fetched once from
     * the server, and then filtered on the client.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param filterLocally filterLocally Default value is false
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
     */
    public Boolean getFilterWithValue()  {
        return getAttributeAsBoolean("filterWithValue");
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
     * @param pickerIconSrc pickerIconSrc Default value is "[SKIN]/DynamicForm/ComboBoxItem_PickButton_icon.gif"
     */
    public void setPickerIconSrc(String pickerIconSrc) {
        setAttribute("pickerIconSrc", pickerIconSrc);
    }

    /**
     * Src for the picker icon.
     *
     *
     * @return String
     */
    public String getPickerIconSrc()  {
        return getAttributeAsString("pickerIconSrc");
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
     * If this form item maps data values to display values by retrieving the  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} values from an  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource}, this property  denotes the the
     * field to use as the underlying data value in records from the  optionDataSource.<br> If unset, assumed to be the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getName name} of this form item.
     *
     * @param valueField valueField Default value is null
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
     * Expression evaluated to determine the {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem#getDefaultValue
     * defaultValue} when no value is  provided for this item. To default to the first option use {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getDefaultToFirstOption defaultToFirstOption} instead.
     */
    public native void defaultDynamicValue() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.defaultDynamicValue();
    }-*/;
            
    /**
     * Returns the {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} for this form item. If
     * unset, and {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource} is explicitly
     * specified, this method will return the title field for the <code>optionDataSource</code>
     *
     * @return display field name, or null
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


    static {
        init();
    }

    private static native void init()/*-{
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
    }-*/;

    private static boolean isComboBoxItem(FormItem formItem) {
        return formItem instanceof ComboBoxItem;
    }
    
    /**
     * Returns filter criteria for options displayed for this item.
     * <br>
     * The criteria returned by this method are used to decide which options should appear in the drop-down PickList shown by this ComboBox.
     * <br>
     * While the user is typing in a value, this method will return the typed-in value as part of the criteria, so that only matching values are shown. Matching is determined by the textMatchStyle.
     * <br>
     * If the user explicitly shows the down-down pickList, via either clicking on the drop down icon or use the Ctrl+Arrow Down key combo, the typed in value is ignored for filtering.
     * <br>
     * If included in the criteria, the typed in value will be included as a value for the displayField (or for the valueField if this.displayField is unspecified).
     * <br>
     * Static criteria, specified via pickListCriteria, will always be included.
     * <br>
     * If you are implementing your own getPickListFilterCriteria() the read-only property this.filterWithValue can be read to determine whether the ComboBox would ordinarily ignore the typed-in value for filtering. Note that in addition to cases where the user explicitly shows the pickList, filterWithValue will also be true during a call to ComboBoxItem.fetchData() on a databound comboBox.
     * <br>
     * <b>Note : this is an override point</b>
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
        setAttribute("textMatchStyle", textMatchStyle.getValue());
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
        setAttribute("pickListCriteria", pickListCriteria == null ? null : pickListCriteria.getJsObj());
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
     */
    public native void setPickListFilterCriteriaFunction(FilterCriteriaFunction filterCriteriaFunction) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.getPickListFilterCriteria = $entry(function() {
            var crit = filterCriteriaFunction.@com.smartgwt.client.widgets.form.fields.FilterCriteriaFunction::getCriteria()();
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

}



