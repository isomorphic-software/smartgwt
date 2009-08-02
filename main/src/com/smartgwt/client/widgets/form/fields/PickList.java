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


import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.grid.ListGridRecord;

/**
 * Interface to show a drop-down list of pickable options. Used by the {@link com.smartgwt.client.widgets.form.fields.SelectItem}
 * and {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem} classes.
 */
public interface PickList {


    /**
     * Maximum height to show the pick list before it starts to scroll. Note that by default the pickList will be sized
     * to the height required by its content so it will be taller when more rows are available as selectable options
     *
     * @param pickListHeight pickListHeight Default value is 300
     */
    public void setPickListHeight(int pickListHeight);

    /**
     * Maximum height to show the pick list before it starts to scroll. Note that by default the pickList will be sized
     * to the height required by its content so it will be taller when more rows are available as selectable options
     *
     * @return int
     */
    public int getPickListHeight();

    /**
     * Height for an empty pick list (showing the empty message), if the pick list has no records and {@link
     * com.smartgwt.client.widgets.form.fields.PickList#getHideEmptyPickList hideEmptyPickList} is <code>false</code>.
     *
     * @param emptyPickListHeight emptyPickListHeight Default value is 100
     */
    public void setEmptyPickListHeight(int emptyPickListHeight);

    /**
     * Height for an empty pick list (showing the empty message), if the pick list has no records and {@link
     * com.smartgwt.client.widgets.form.fields.PickList#getHideEmptyPickList hideEmptyPickList} is <code>false</code>.
     *
     * @return int
     */
    public int getEmptyPickListHeight();

    /**
     * Empty message to display in the pickList if  {@link com.smartgwt.client.widgets.form.fields.PickList#getHideEmptyPickList
     * hideEmptyPickList} is <code>false</code>. <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param emptyPickListMessage emptyPickListMessage Default value is null
     */
    public void setEmptyPickListMessage(String emptyPickListMessage);

    /**
     * Empty message to display in the pickList if  {@link com.smartgwt.client.widgets.form.fields.PickList#getHideEmptyPickList
     * hideEmptyPickList} is <code>false</code>.
     *
     * @return String
     */
    public String getEmptyPickListMessage();

    /**
     * If this pickList contains no options, should it be hidden? If unset, default behavior is to allow the empty
     * pickList to show if it is databound.
     *
     * @param hideEmptyPickList hideEmptyPickList Default value is null
     */
    public void setHideEmptyPickList(Boolean hideEmptyPickList);

    /**
     * If this pickList contains no options, should it be hidden? If unset, default behavior is to allow the empty
     * pickList to show if it is databound.
     *
     * @return Boolean
     */
    public Boolean getHideEmptyPickList();

    /**
     * Default width to show the pickList. If not specified, the width of this form item's element will be used
     * instead.
     *
     * @param pickListWidth pickListWidth Default value is null
     */
    public void setPickListWidth(Integer pickListWidth);

    /**
     * Default width to show the pickList. If not specified, the width of this form item's element will be used
     * instead.
     *
     * @return Integer
     */
    public Integer getPickListWidth();

    /**
     * Base Style for pickList cells.  As with ListGrid Cells, will have 'over', 'selected' and 'disabled' appended on
     * changes of state for the cells.
     *
     * @param pickListBaseStyle pickListBaseStyle Default value is "pickListCell"
     */
    public void setPickListBaseStyle(String pickListBaseStyle);

    /**
     * Base Style for pickList cells.  As with ListGrid Cells, will have 'over', 'selected' and 'disabled' appended on
     * changes of state for the cells.
     *
     * @return String
     */
    public String getPickListBaseStyle();

    /**
     * If true, when the pickList is shown, it will be shown via an animated reveal effect <p><b>Note : </b> This is an
     * advanced setting</p>
     *
     * @param animatePickList animatePickList Default value is null
     */
    public void setAnimatePickList(Boolean animatePickList);

    /**
     * If true, when the pickList is shown, it will be shown via an animated reveal effect
     *
     * @return Boolean
     */
    public Boolean getAnimatePickList();

    /**
     * If this.animatePickList is true - this specifies the duration of the animation effect applied when showing the
     * pickList <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param animationTime animationTime Default value is 200
     */
    public void setAnimationTime(int animationTime);

    /**
     * If this.animatePickList is true - this specifies the duration of the animation effect applied when showing the
     * pickList
     *
     * @return int
     */
    public int getAnimationTime();

    /**
     * If this pick list is showing multiple fields, this property determines the height of the column headers for those
     * fields. Set to zero to suppress the headers entirely.
     *
     * @param pickListHeaderHeight pickListHeaderHeight Default value is 22
     */
    public void setPickListHeaderHeight(int pickListHeaderHeight);

    /**
     * If this pick list is showing multiple fields, this property determines the height of the column headers for those
     * fields. Set to zero to suppress the headers entirely.
     *
     * @return int
     */
    public int getPickListHeaderHeight();

    /**
     * If this form item maps data values to display values by retrieving the  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} values from an  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource}, this property  denotes
     * the the field to use as the underlying data value in records from the  optionDataSource.<br> If unset, assumed to
     * be the {@link com.smartgwt.client.widgets.form.fields.FormItem#getName name} of this form item. <p><b>Note : </b>
     * This is an advanced setting</p>
     *
     * @param valueField valueField Default value is null
     */
    public void setValueField(String valueField);

    /**
     * If this form item maps data values to display values by retrieving the  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} values from an  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource}, this property  denotes
     * the the field to use as the underlying data value in records from the  optionDataSource.<br> If unset, assumed to
     * be the {@link com.smartgwt.client.widgets.form.fields.FormItem#getName name} of this form item.
     *
     * @return String
     */
    public String getValueField();

    /**
     * Specifies an alternative field from which display values should be retrieved for this item.<br> If this item is
     * not databound ({@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource} is
     * unset), or bound  to the same dataSource as the form as a whole, this is implemented by picking up the value of
     * the specified field from the Form's values object.<br> Otherwise this item will attempt to map its underlying
     * value to a display value by retrieving a record from the {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * optionDataSource} where the  {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueField valueField}
     * matches this item's value, and displaying the  <code>displayField</code> value from that record.<br> This
     * essentially enables the specified <code>optionDataSource</code> to be used as a server based
     * ${isc.DocUtils.linkForRef('group:valueMap')}.
     *
     * @param displayField displayField Default value is null
     */
    public void setDisplayField(String displayField);

    /**
     * Specifies an alternative field from which display values should be retrieved for this item.<br> If this item is
     * not databound ({@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource} is
     * unset), or bound  to the same dataSource as the form as a whole, this is implemented by picking up the value of
     * the specified field from the Form's values object.<br> Otherwise this item will attempt to map its underlying
     * value to a display value by retrieving a record from the {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * optionDataSource} where the  {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueField valueField}
     * matches this item's value, and displaying the  <code>displayField</code> value from that record.<br> This
     * essentially enables the specified <code>optionDataSource</code> to be used as a server based
     * ${isc.DocUtils.linkForRef('group:valueMap')}.
     *
     * @return String
     */
    public String getDisplayField();

    /**
     * For Databound formItems, this property determines which column  {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons
     * valueIcons} should show up in for this formItem's pickList.<br> If unset valueIcons show up in the {@link
     * com.smartgwt.client.widgets.form.fields.PickList#getDisplayField displayField} column if specified,  otherwise
     * the {@link com.smartgwt.client.widgets.form.fields.PickList#getValueField valueField} column.<br> In most cases
     * only the <code>displayField</code> or <code>valueField</code> will be visible. This property is typically only
     * required if custom {@link com.smartgwt.client.widgets.form.fields.PickList#getPickListFields pickListFields} have
     * been specfied for this item. <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param valueIconField valueIconField Default value is null
     */
    public void setValueIconField(String valueIconField);

    /**
     * For Databound formItems, this property determines which column  {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons
     * valueIcons} should show up in for this formItem's pickList.<br> If unset valueIcons show up in the {@link
     * com.smartgwt.client.widgets.form.fields.PickList#getDisplayField displayField} column if specified,  otherwise
     * the {@link com.smartgwt.client.widgets.form.fields.PickList#getValueField valueField} column.<br> In most cases
     * only the <code>displayField</code> or <code>valueField</code> will be visible. This property is typically only
     * required if custom {@link com.smartgwt.client.widgets.form.fields.PickList#getPickListFields pickListFields} have
     * been specfied for this item.
     *
     * @return String
     */
    public String getValueIconField();

    /**
     * If this item has a databound pick-list (for example {@link com.smartgwt.client.widgets.form.fields.PickList#getOptionDataSource
     * optionDataSource} is set) this property can be used to provide static filter criteria when retrieving the data
     * for the pickList. <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param pickListCriteria pickListCriteria Default value is null
     */
    public void setPickListCriteria(Criteria pickListCriteria);

    /**
     * If this item has a databound pick-list (for example {@link com.smartgwt.client.widgets.form.fields.PickList#getOptionDataSource
     * optionDataSource} is set) this property can be used to provide static filter criteria when retrieving the data
     * for the pickList.
     *
     * @return Criteria
     */
    public Criteria getPickListCriteria();

    /**
     * If this item is part of a databound form, and has a specified <code>valueMap</code> by default we show the
     * valueMap options in the pickList for the item. Setting this property to true will ensure that the options
     * displayed in our pickList are derived from the form's <code>dataSource</code>. <p><b>Note : </b> This is an
     * advanced setting</p>
     *
     * @param showOptionsFromDataSource showOptionsFromDataSource Default value is null
     */
    public void setShowOptionsFromDataSource(Boolean showOptionsFromDataSource);

    /**
     * If this item is part of a databound form, and has a specified <code>valueMap</code> by default we show the
     * valueMap options in the pickList for the item. Setting this property to true will ensure that the options
     * displayed in our pickList are derived from the form's <code>dataSource</code>.
     *
     * @return Boolean
     */
    public Boolean getShowOptionsFromDataSource();

    /**
     * If <code>filterLocally</code> is set for this item, and this item is showing options  from a dataSource, fetch
     * the entire set of options from the server, and use these values to map the item value to the appropriate display
     * value. Also use <code>"local"</code> type filtering on drop down list of options.<br> This means data will only
     * be fetched once from the server, and then filtered on the client. <p><b>Note : </b> This is an advanced
     * setting</p>
     *
     * @param filterLocally filterLocally Default value is false
     */
    public void setFilterLocally(Boolean filterLocally);

    /**
     * If <code>filterLocally</code> is set for this item, and this item is showing options  from a dataSource, fetch
     * the entire set of options from the server, and use these values to map the item value to the appropriate display
     * value. Also use <code>"local"</code> type filtering on drop down list of options.<br> This means data will only
     * be fetched once from the server, and then filtered on the client.
     *
     * @return Boolean
     */
    public Boolean getFilterLocally();

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
    public void setTextMatchStyle(TextMatchStyle textMatchStyle);

    /**
     * When applying filter criteria to pickList data, what type of matching to use.  Legal values are "substring"
     * (value contains user input) or "startsWith" (value starts with user input.  Both matches are case insensitive.
     * <P> For a databound pickList ({@link com.smartgwt.client.widgets.form.fields.PickList#getOptionDataSource
     * optionDataSource} set), <code>textMatchStyle</code> is sent to the server as {@link
     * com.smartgwt.client.data.DSRequest#getTextMatchStyle textMatchStyle}. <P> For a non-databound pickList,
     * <code>textMatchStyle</code> is applied by  {@link com.smartgwt.client.widgets.form.fields.PickList#filterClientPickListData}.
     *
     * @return Boolean
     */
    public TextMatchStyle getTextMatchStyle();

    /**
     * If true, even non-matching options will be shown, with configurable  {@link com.smartgwt.client.widgets.form.fields.PickList#getSeparatorRows
     * separatorRows} in between.  Not valid for {@link com.smartgwt.client.widgets.form.fields.PickList#getOptionDataSource
     * optionDataSource}.
     *
     * @param showAllOptions showAllOptions Default value is null
     */
    public void setShowAllOptions(Boolean showAllOptions);

    /**
     * If true, even non-matching options will be shown, with configurable  {@link com.smartgwt.client.widgets.form.fields.PickList#getSeparatorRows
     * separatorRows} in between.  Not valid for {@link com.smartgwt.client.widgets.form.fields.PickList#getOptionDataSource
     * optionDataSource}.
     *
     * @return Boolean
     */
    public Boolean getShowAllOptions();

    // ********************* Methods ***********************


    /**
     * Getter method to retrieve the {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueField valueField}
     * for this item. If unset, default behavior will return the {@link com.smartgwt.client.widgets.form.fields.FormItem#getName
     * name} of this field.
     *
     * @return fieldName to use a "value field" in records from this items               {@link
     *         com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource}
     */
    public String getValueFieldName();

    /**
     * Returns the {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} for this form
     * item. If unset, and {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource}
     * is explicitly specified, this method will return the title field for the <code>optionDataSource</code>
     *
     * @return display field name, or null
     */
    public String getDisplayFieldName();

    /**
     * For a ComboBox or other pickList that accepts user-entered criteria, how many millseconds to wait after the last user
     * keystroke before fetching data from the server. The default setting will initiate a fetch if the stops typing or pauses briefly.
     *
     * @param fetchDelay the fetch delay. defaults to 200ms
     */
    public void setFetchDelay(Integer fetchDelay);

    /**
     * For a ComboBox or other pickList that accepts user-entered criteria, how many millseconds to wait after the last user
     * keystroke before fetching data from the server. The default setting will initiate a fetch if the stops typing or pauses briefly.
     *
     * @return the fetch delay
     */
    public Integer getFetchDelay();

   /**
    * Set the pick list filter criteria function / handler.
    *
    * @param filterCriteriaFunction the filter criteria function
    */
    public void setPickListFilterCriteriaFunction(FilterCriteriaFunction filterCriteriaFunction);

    /**
     * Returns the data to display in the pick list.
     * <p>
     * The default implementation applies the criteria returned by {@link #getPickListFilterCriteria}  to the data returned
     * by {@link #getClientPickListData}. A record passes the filter if it has a matching value for all fields in the criteria
     * object.  Matching is performed according to {@link #setTextMatchStyle(com.smartgwt.client.types.TextMatchStyle) textMatchStyle}.
     * <p>
     * If {@link #setShowAllOptions(Boolean) showAllOptions}  is set, all values are shown, with matching values shown below a
     * {@link #setSeparatorRows separator}.
     * 
     * @return array of record objects to display in the pickList
     */
    public ListGridRecord[] filterClientPickListData();

    /**
     * Returns the set of data to be displayed in this item's PickList.

     * <p>
     * This method will be called for non-databound form items implementing the PickList interface.  The default implementation will
     * derive data from the item's valueMap -  can be overridden to allow a custom set of options to be displayed.
     * <p>
     * Note that for PickLists that filter data based on user input {@link ComboBoxItem 'ComboBox')}, this method should
     * return the data <b>before filtering</b>.
     *  
     * @return Array of record objects to be displayed in the pickList. Note that when a user picks a record from the list,
     * the value of the field matching item.valueField will be picked. Also note that the fields to be displayed can be
     * customized via item.pickListFields
     */
    public ListGridRecord[] getClientPickListData();

    /**
     * Array of records to show between matching and non-matching rows in the PickList.
     * <p>
     * Not valid for {@link FormItem#setOptionDataSource(com.smartgwt.client.data.DataSource) 'databound pickLists'}.
     * 
     * @param separatorRows separator rows
     */
    public void setSeparatorRows(ListGridRecord[] separatorRows);

    public DataSource getOptionDataSource();

    public void setOptionDataSource(DataSource dataSource);

}



