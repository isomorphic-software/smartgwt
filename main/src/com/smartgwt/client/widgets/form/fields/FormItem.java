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
    * An Item that can participate in a DynamicForm, managing some value. <P> FormItems are never directly created, instead, FormItem descriptors are passed to a DynamicForm.  See the {@link com.smartgwt.client.widgets.form.DynamicForm} documentation for details.

    */











public class FormItem extends RefDataClass  implements com.smartgwt.client.widgets.form.fields.events.HasFocusHandlers, com.smartgwt.client.widgets.form.fields.events.HasBlurHandlers, com.smartgwt.client.widgets.form.fields.events.HasChangeHandlers, com.smartgwt.client.widgets.form.fields.events.HasChangedHandlers, com.smartgwt.client.widgets.form.fields.events.HasKeyPressHandlers, com.smartgwt.client.widgets.form.fields.events.HasIconClickHandlers, com.smartgwt.client.widgets.form.fields.events.HasIconKeyPressHandlers, com.smartgwt.client.widgets.form.fields.events.HasItemHoverHandlers, com.smartgwt.client.widgets.form.fields.events.HasClickHandlers, com.smartgwt.client.widgets.form.fields.events.HasDoubleClickHandlers, com.smartgwt.client.widgets.form.fields.events.HasTitleHoverHandlers {

    public static FormItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (FormItem) obj;
        } else {
            return new FormItem(jsObj);
        }
    }


    public FormItem(){
        setType("FormItem");setName(com.smartgwt.client.util.SC.generateID());
    }

    public FormItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    // ********************* Properties / Attributes ***********************

    /**
    * Name for this form field. <br><br> The FormItem's name determines the name of the property it edits within the form.
    *
    * @param name name Default value is null
    */
    public void setName(String name) {
        setAttribute("name", name);
    }
    /**
     * Name for this form field. <br><br> The FormItem's name determines the name of the property it edits within the form.
     *
     *
     * @return String
     *
     */
    public String getName()  {
        return getAttributeAsString("name");
    }

    /**
    * User visible title for this form item.
    *
    * @param title title Default value is null
    */
    public void setTitle(String title) {
        setAttribute("title", title);
    }
    /**
     * User visible title for this form item.
     *
     *
     * @return Return the title of this formItem
     *
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }

    /**
    * Text to display when this form item has a null or undefined value.
    *
    * @param emptyDisplayValue emptyDisplayValue Default value is ""
    */
    public void setEmptyDisplayValue(String emptyDisplayValue) {
        setAttribute("emptyDisplayValue", emptyDisplayValue);
    }
    /**
     * Text to display when this form item has a null or undefined value.
     *
     *
     * @return String
     *
     */
    public String getEmptyDisplayValue()  {
        return getAttributeAsString("emptyDisplayValue");
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
    * Specifies an alternative field from which display values should be retrieved for this item. <P> The display field can be either another field value in the same record or a field that must be retrieved from a related {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource}. <P> If this item is not databound ({@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource} is unset), or bound  to the same dataSource as the form as a whole, this item will call {@link com.smartgwt.client.widgets.form.DynamicForm#getValue}  the form named after is implemented by picking up the value of the specified field from the Form's values object. <P> Otherwise this item will attempt to map its underlying value to a display value by retrieving a record from the {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource} where the  {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueField valueField} matches this item's value, and displaying the  <code>displayField</code> value from that record. Note that if <code>optionDataSource</code> is set and this value is not set, {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayFieldName} will return the dataSource title field by default. <P> This essentially enables the specified <code>optionDataSource</code> to be used as a server based valueMap.
    *
    * @param displayField displayField Default value is null
    */
    public void setDisplayField(String displayField) {
        setAttribute("displayField", displayField);
    }
    /**
     * Specifies an alternative field from which display values should be retrieved for this item. <P> The display field can be either another field value in the same record or a field that must be retrieved from a related {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource}. <P> If this item is not databound ({@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource} is unset), or bound  to the same dataSource as the form as a whole, this item will call {@link com.smartgwt.client.widgets.form.DynamicForm#getValue}  the form named after is implemented by picking up the value of the specified field from the Form's values object. <P> Otherwise this item will attempt to map its underlying value to a display value by retrieving a record from the {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource} where the  {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueField valueField} matches this item's value, and displaying the  <code>displayField</code> value from that record. Note that if <code>optionDataSource</code> is set and this value is not set, {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayFieldName} will return the dataSource title field by default. <P> This essentially enables the specified <code>optionDataSource</code> to be used as a server based valueMap.
     *
     *
     * @return String
     *
     */
    public String getDisplayField()  {
        return getAttributeAsString("displayField");
    }

    /**
    * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} is specified for this item, should the item  perform a fetch on the {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource} to retrieve the display value for the item when {@link com.smartgwt.client.widgets.form.fields.FormItem#setValue} is called with a value for which we do not already have a mapped display value? <P> As noted under {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource}, you may <b>also</b> specify a ${isc.DocUtils.linkForRef('type:ValueMap')} and it will be consulted first before fetching from the <code>optionDataSource</code>.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param fetchMissingValues fetchMissingValues Default value is true
    */
    public void setFetchMissingValues(Boolean fetchMissingValues) {
        setAttribute("fetchMissingValues", fetchMissingValues);
    }
    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} is specified for this item, should the item  perform a fetch on the {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource} to retrieve the display value for the item when {@link com.smartgwt.client.widgets.form.fields.FormItem#setValue} is called with a value for which we do not already have a mapped display value? <P> As noted under {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource}, you may <b>also</b> specify a ${isc.DocUtils.linkForRef('type:ValueMap')} and it will be consulted first before fetching from the <code>optionDataSource</code>.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getFetchMissingValues()  {
        return getAttributeAsBoolean("fetchMissingValues");
    }

    /**
    * If this form item is mapping data values to a display value by fetching them from a  dataSource (see {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource}, {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField}  and {@link com.smartgwt.client.widgets.form.fields.FormItem#getFetchMissingValues fetchMissingValues}), setting this property to true ensures that when the form item value is set, entire data-set from the dataSource is loaded at once and  used as a valueMap, rather than just loading the display value for the current value. This avoids the need to perform fetches each time setValue() is called with a new value. <P> See also {@link com.smartgwt.client..PickList#getFilterLocally filterLocally} for behavior on form items such as SelectItems that show pick-lists.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param filterLocally filterLocally Default value is null
    */
    public void setFilterLocally(Boolean filterLocally) {
        setAttribute("filterLocally", filterLocally);
    }
    /**
     * If this form item is mapping data values to a display value by fetching them from a  dataSource (see {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource}, {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField}  and {@link com.smartgwt.client.widgets.form.fields.FormItem#getFetchMissingValues fetchMissingValues}), setting this property to true ensures that when the form item value is set, entire data-set from the dataSource is loaded at once and  used as a valueMap, rather than just loading the display value for the current value. This avoids the need to perform fetches each time setValue() is called with a new value. <P> See also {@link com.smartgwt.client..PickList#getFilterLocally filterLocally} for behavior on form items such as SelectItems that show pick-lists.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getFilterLocally()  {
        return getAttributeAsBoolean("filterLocally");
    }
             
    /**
    * Display format to use for date type values within this formItem. Default is to use the system-wide default short date format, configured via {@link com.smartgwt.client..Date#setShortDisplayFormat}.  Specify any valid ${isc.DocUtils.linkForRef('type:DateDisplayFormat')} to  change the format used by this item.<br> Note: if both <code>dateFormatter</code> and {@link com.smartgwt.client.widgets.form.fields.FormItem#getTimeFormatter timeFormatter} are specified on an item, Date type values will be formatted as dates using  <code>dateFormatter</code>.<br> See also {@link com.smartgwt.client.widgets.form.fields.DateItem#getDisplayFormat displayFormat} for formatting dates displayed in DateItems.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param dateFormatter dateFormatter Default value is null
    */
    public void setDateFormatter(DateDisplayFormat dateFormatter) {
        setAttribute("dateFormatter", dateFormatter.getValue());
    }
    /**
     * Display format to use for date type values within this formItem. Default is to use the system-wide default short date format, configured via {@link com.smartgwt.client..Date#setShortDisplayFormat}.  Specify any valid ${isc.DocUtils.linkForRef('type:DateDisplayFormat')} to  change the format used by this item.<br> Note: if both <code>dateFormatter</code> and {@link com.smartgwt.client.widgets.form.fields.FormItem#getTimeFormatter timeFormatter} are specified on an item, Date type values will be formatted as dates using  <code>dateFormatter</code>.<br> See also {@link com.smartgwt.client.widgets.form.fields.DateItem#getDisplayFormat displayFormat} for formatting dates displayed in DateItems.
     *
     *
     * @return DateDisplayFormat
     *
     */
    public DateDisplayFormat getDateFormatter()  {
        return (DateDisplayFormat) EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("dateFormatter"));
    }
             
    /**
    * Time-format to apply to date type values within this formItem.  If specified, any dates displayed in this item will be formatted as times using the appropriate format.<br> Has no effect if +lilnk{formItem.dateFormatter} is also set.<br> See also {@link com.smartgwt.client.widgets.form.fields.TimeItem#getDisplayFormat displayFormat} for formatting values displayed in TimeItems.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param timeFormatter timeFormatter Default value is null
    */
    public void setTimeFormatter(TimeFormatter timeFormatter) {
        setAttribute("timeFormatter", timeFormatter.getValue());
    }
    /**
     * Time-format to apply to date type values within this formItem.  If specified, any dates displayed in this item will be formatted as times using the appropriate format.<br> Has no effect if +lilnk{formItem.dateFormatter} is also set.<br> See also {@link com.smartgwt.client.widgets.form.fields.TimeItem#getDisplayFormat displayFormat} for formatting values displayed in TimeItems.
     *
     *
     * @return TimeFormatter
     *
     */
    public TimeFormatter getTimeFormatter()  {
        return (TimeFormatter) EnumUtil.getEnum(TimeFormatter.values(), getAttribute("timeFormatter"));
    }

    /**
    * This property allows the developer to specify an icon to display when this item has no value. It is configured in the same way as any other valueIcon  (see {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons})
    *
    * @param emptyValueIcon emptyValueIcon Default value is null
    */
    public void setEmptyValueIcon(String emptyValueIcon) {
        setAttribute("emptyValueIcon", emptyValueIcon);
    }
    /**
     * This property allows the developer to specify an icon to display when this item has no value. It is configured in the same way as any other valueIcon  (see {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons})
     *
     *
     * @return String
     *
     */
    public String getEmptyValueIcon()  {
        return getAttributeAsString("emptyValueIcon");
    }

    /**
    * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons} is set, this property may be set to show the valueIcon only and prevent the standard form item element or text from displaying
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param showValueIconOnly showValueIconOnly Default value is null
    */
    public void setShowValueIconOnly(Boolean showValueIconOnly) {
        setAttribute("showValueIconOnly", showValueIconOnly);
    }
    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons} is set, this property may be set to show the valueIcon only and prevent the standard form item element or text from displaying
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowValueIconOnly()  {
        return getAttributeAsBoolean("showValueIconOnly");
    }

    /**
    * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons} is set, this property may be set to prevent the value icons from showing up next to the form items value
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param suppressValueIcon suppressValueIcon Default value is null
    */
    public void setSuppressValueIcon(Boolean suppressValueIcon) {
        setAttribute("suppressValueIcon", suppressValueIcon);
    }
    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons} is set, this property may be set to prevent the value icons from showing up next to the form items value
     *
     *
     * @return Boolean
     *
     */
    public Boolean getSuppressValueIcon()  {
        return getAttributeAsBoolean("suppressValueIcon");
    }

    /**
    * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons} is specified, use this property to specify a width for the value icon written out.
    *
    * @param valueIconWidth valueIconWidth Default value is null
    */
    public void setValueIconWidth(Integer valueIconWidth) {
        setAttribute("valueIconWidth", valueIconWidth);
    }
    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons} is specified, use this property to specify a width for the value icon written out.
     *
     *
     * @return Integer
     *
     */
    public Integer getValueIconWidth()  {
        return getAttributeAsInt("valueIconWidth");
    }

    /**
    * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons} is specified, use this property to specify a height for the value icon written out.
    *
    * @param valueIconHeight valueIconHeight Default value is null
    */
    public void setValueIconHeight(Integer valueIconHeight) {
        setAttribute("valueIconHeight", valueIconHeight);
    }
    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons} is specified, use this property to specify a height for the value icon written out.
     *
     *
     * @return Integer
     *
     */
    public Integer getValueIconHeight()  {
        return getAttributeAsInt("valueIconHeight");
    }

    /**
    * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons} is specified, this property may be used to specify both the width and height of the icon written out. Note that {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIconWidth valueIconWidth} and {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIconHeight valueIconHeight} take presidence over this value, if specified.
    *
    * @param valueIconSize valueIconSize Default value is 16
    */
    public void setValueIconSize(int valueIconSize) {
        setAttribute("valueIconSize", valueIconSize);
    }
    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons} is specified, this property may be used to specify both the width and height of the icon written out. Note that {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIconWidth valueIconWidth} and {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIconHeight valueIconHeight} take presidence over this value, if specified.
     *
     *
     * @return int
     *
     */
    public int getValueIconSize()  {
        return getAttributeAsInt("valueIconSize");
    }

    /**
    * If we're showing a value icon, this attribute governs the amount of space between the  icon and the left edge of the form item cell
    *
    * @param valueIconLeftPadding valueIconLeftPadding Default value is 0
    */
    public void setValueIconLeftPadding(int valueIconLeftPadding) {
        setAttribute("valueIconLeftPadding", valueIconLeftPadding);
    }
    /**
     * If we're showing a value icon, this attribute governs the amount of space between the  icon and the left edge of the form item cell
     *
     *
     * @return int
     *
     */
    public int getValueIconLeftPadding()  {
        return getAttributeAsInt("valueIconLeftPadding");
    }

    /**
    * If we're showing a value icon, this attribute governs the amount of space between the  icon and the label of the form item
    *
    * @param valueIconRightPadding valueIconRightPadding Default value is 3
    */
    public void setValueIconRightPadding(int valueIconRightPadding) {
        setAttribute("valueIconRightPadding", valueIconRightPadding);
    }
    /**
     * If we're showing a value icon, this attribute governs the amount of space between the  icon and the label of the form item
     *
     *
     * @return int
     *
     */
    public int getValueIconRightPadding()  {
        return getAttributeAsInt("valueIconRightPadding");
    }

    /**
    * Prefix to apply to the beginning of any {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons} when determining the URL for the image. Will not be applied if the <code>valueIcon</code> URL is absolute.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param imageURLPrefix imageURLPrefix Default value is null
    */
    public void setImageURLPrefix(String imageURLPrefix) {
        setAttribute("imageURLPrefix", imageURLPrefix);
    }
    /**
     * Prefix to apply to the beginning of any {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons} when determining the URL for the image. Will not be applied if the <code>valueIcon</code> URL is absolute.
     *
     *
     * @return String
     *
     */
    public String getImageURLPrefix()  {
        return getAttributeAsString("imageURLPrefix");
    }

    /**
    * Suffix to apply to the end of any {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons} when determining the URL for the image. A common usage would be to specify a suffix of <code>".gif"</code> in which case the <code>valueIcons</code> property would map values to the names of images without the <code>".gif"</code> extension.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param imageURLSuffix imageURLSuffix Default value is null
    */
    public void setImageURLSuffix(String imageURLSuffix) {
        setAttribute("imageURLSuffix", imageURLSuffix);
    }
    /**
     * Suffix to apply to the end of any {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons} when determining the URL for the image. A common usage would be to specify a suffix of <code>".gif"</code> in which case the <code>valueIcons</code> property would map values to the names of images without the <code>".gif"</code> extension.
     *
     *
     * @return String
     *
     */
    public String getImageURLSuffix()  {
        return getAttributeAsString("imageURLSuffix");
    }

    /**
    * Whether a non-empty value is required for this field to pass validation. <BR> <b>Note:</b> if specified on a FormItem, <code>required</code> is only enforced on the client.  <code>required</code> should generally be specified on a {@link com.smartgwt.client.data.DataSourceField}.
    *
    * @param required required Default value is false
    */
    public void setRequired(Boolean required) {
        setAttribute("required", required);
    }
    /**
     * Whether a non-empty value is required for this field to pass validation. <BR> <b>Note:</b> if specified on a FormItem, <code>required</code> is only enforced on the client.  <code>required</code> should generally be specified on a {@link com.smartgwt.client.data.DataSourceField}.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getRequired()  {
        return getAttributeAsBoolean("required");
    }

    /**
    * Whether this item is currently visible. <P> <code>visible</code> can only be set on creation.  After creation, use {@link com.smartgwt.client.widgets.form.fields.FormItem#show} and {@link com.smartgwt.client.widgets.form.fields.FormItem#hide} to manipulate visibility.
    *
    * @param visible visible Default value is true
    */
    public void setVisible(Boolean visible) {
        setAttribute("visible", visible);
    }
    /**
     * Whether this item is currently visible. <P> <code>visible</code> can only be set on creation.  After creation, use {@link com.smartgwt.client.widgets.form.fields.FormItem#show} and {@link com.smartgwt.client.widgets.form.fields.FormItem#hide} to manipulate visibility.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getVisible()  {
        return getAttributeAsBoolean("visible");
    }

    /**
    * Whether this item is disabled.  Can be updated at runtime via the <code>setDisabled()</code> method.  Note that if the widget containing this formItem is disabled, the formItem will behave in a disabled manner regardless of the setting of the item.disabled property. <p> Note that not all items can be disabled, and not all browsers show an obvious disabled style for native form elements.
    * Set this item to be enabled or disabled at runtime.
    *
    * @param disabled true if this item should be disabled. Default value is false
    */
    public void setDisabled(Boolean disabled) {
        setAttribute("disabled", disabled);
    }
    /**
     * Whether this item is disabled.  Can be updated at runtime via the <code>setDisabled()</code> method.  Note that if the widget containing this formItem is disabled, the formItem will behave in a disabled manner regardless of the setting of the item.disabled property. <p> Note that not all items can be disabled, and not all browsers show an obvious disabled style for native form elements.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getDisabled()  {
        return getAttributeAsBoolean("disabled");
    }

    /**
    * AccessKey - a keyboard shortcut to trigger a form item's default behavior.<br>      Note: Alt+ (or in Moz Firefox 2.0 and above, Shift+Alt+) the specified key will       trigger the form item's default behavior.
    *
    * @param accessKey accessKey Default value is null
    */
    public void setAccessKey(String accessKey) {
        setAttribute("accessKey", accessKey);
    }
    /**
     * AccessKey - a keyboard shortcut to trigger a form item's default behavior.<br>      Note: Alt+ (or in Moz Firefox 2.0 and above, Shift+Alt+) the specified key will       trigger the form item's default behavior.
     *
     *
     * @return String
     *
     */
    public String getAccessKey()  {
        return getAttributeAsString("accessKey");
    }

    /**
    * tabIndex for the form item within the form.  Auto-assigned if not specified.<br> Note: This controls the tab order within the form. <P> To specify the tabindex of an item within the page as a whole (not just this form), use globalTabIndex instead.
    *
    * @param tabIndex tabIndex Default value is null
    */
    public void setTabIndex(Integer tabIndex) {
        setAttribute("tabIndex", tabIndex);
    }
    /**
     * tabIndex for the form item within the form.  Auto-assigned if not specified.<br> Note: This controls the tab order within the form. <P> To specify the tabindex of an item within the page as a whole (not just this form), use globalTabIndex instead.
     *
     *
     * @return Integer
     *
     */
    public Integer getTabIndex()  {
        return getAttributeAsInt("tabIndex");
    }

    /**
    * TabIndex for the form item within the page. Takes presidence over any local tab index specified as {@link com.smartgwt.client.widgets.form.fields.FormItem#getTabIndex tabIndex}.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param globalTabIndex globalTabIndex Default value is null
    */
    public void setGlobalTabIndex(Integer globalTabIndex) {
        setAttribute("globalTabIndex", globalTabIndex);
    }
    /**
     * TabIndex for the form item within the page. Takes presidence over any local tab index specified as {@link com.smartgwt.client.widgets.form.fields.FormItem#getTabIndex tabIndex}.
     *
     *
     * @return Integer
     *
     */
    public Integer getGlobalTabIndex()  {
        return getAttributeAsInt("globalTabIndex");
    }

    /**
    * Should we show a title cell for this formItem? <p> Note: the default value of this attribute is overridden by some subclasses.
    *
    * @param showTitle showTitle Default value is true
    */
    public void setShowTitle(Boolean showTitle) {
        setAttribute("showTitle", showTitle);
    }
    /**
     * Should we show a title cell for this formItem? <p> Note: the default value of this attribute is overridden by some subclasses.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowTitle()  {
        return getAttributeAsBoolean("showTitle");
    }
             
    /**
    * On which side of this item should the title be placed.  ${isc.DocUtils.linkForRef('type:TitleOrientation')} lists valid options. <P> Note that titles on the left or right take up a cell in tabular {@link com.smartgwt.client.docs.FormLayout 'form layouts'}, but titles on top do not.
    *
    * @param titleOrientation titleOrientation Default value is Canvas.LEFT
    */
    public void setTitleOrientation(TitleOrientation titleOrientation) {
        setAttribute("titleOrientation", titleOrientation.getValue());
    }
    /**
     * On which side of this item should the title be placed.  ${isc.DocUtils.linkForRef('type:TitleOrientation')} lists valid options. <P> Note that titles on the left or right take up a cell in tabular {@link com.smartgwt.client.docs.FormLayout 'form layouts'}, but titles on top do not.
     *
     *
     * @return TitleOrientation
     *
     */
    public TitleOrientation getTitleOrientation()  {
        return (TitleOrientation) EnumUtil.getEnum(TitleOrientation.values(), getAttribute("titleOrientation"));
    }
             
    /**
    * Alignment of this item's title in its cell. <p> If null, dynamically set according to text direction.
    *
    * @param titleAlign titleAlign Default value is null
    */
    public void setTitleAlign(Alignment titleAlign) {
        setAttribute("titleAlign", titleAlign.getValue());
    }
    /**
     * Alignment of this item's title in its cell. <p> If null, dynamically set according to text direction.
     *
     *
     * @return Alignment
     *
     */
    public Alignment getTitleAlign()  {
        return (Alignment) EnumUtil.getEnum(Alignment.values(), getAttribute("titleAlign"));
    }

    /**
    * If specified determines whether this items title should wrap. Overrides {@link com.smartgwt.client.widgets.form.DynamicForm#getWrapItemTitles wrapItemTitles} at the DynamicForm level.
    *
    * @param wrapTitle wrapTitle Default value is null
    */
    public void setWrapTitle(Boolean wrapTitle) {
        setAttribute("wrapTitle", wrapTitle);
    }
    /**
     * If specified determines whether this items title should wrap. Overrides {@link com.smartgwt.client.widgets.form.DynamicForm#getWrapItemTitles wrapItemTitles} at the DynamicForm level.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getWrapTitle()  {
        return getAttributeAsBoolean("wrapTitle");
    }

    /**
    * If true, form items will be validated when each item's "change" handler is fired as well as when the entire form is submitted or validated. <p> Note that this property can also be set at the form, level; If true at either level the valiator will be fired on change - displaying errors and rejecting the change on validation failure.
    *
    * @param validateOnChange validateOnChange Default value is false
    */
    public void setValidateOnChange(Boolean validateOnChange) {
        setAttribute("validateOnChange", validateOnChange);
    }
    /**
     * If true, form items will be validated when each item's "change" handler is fired as well as when the entire form is submitted or validated. <p> Note that this property can also be set at the form, level; If true at either level the valiator will be fired on change - displaying errors and rejecting the change on validation failure.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getValidateOnChange()  {
        return getAttributeAsBoolean("validateOnChange");
    }

    /**
    * If validateOnChange is true, and validation fails for this item on change, with no suggested value, should we revert to the previous value, or continue to display the bad value entered by the user. May be set at the item or form level.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param rejectInvalidValueOnChange rejectInvalidValueOnChange Default value is false
    */
    public void setRejectInvalidValueOnChange(Boolean rejectInvalidValueOnChange) {
        setAttribute("rejectInvalidValueOnChange", rejectInvalidValueOnChange);
    }
    /**
     * If validateOnChange is true, and validation fails for this item on change, with no suggested value, should we revert to the previous value, or continue to display the bad value entered by the user. May be set at the item or form level.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getRejectInvalidValueOnChange()  {
        return getAttributeAsBoolean("rejectInvalidValueOnChange");
    }

    /**
    * By default, items take up the entire width of their cell
    *
    * @param width width Default value is "*"
    */
    public void setWidth(int width) {
        setAttribute("width", width);
    }
    /**
     * By default, items take up the entire width of their cell
     *
     *
     * @return int
     *
     */
    public int getWidth()  {
        return getAttributeAsInt("width");
    }

    /**
    * Default height of this item.
    *
    * @param height height Default value is 20
    */
    public void setHeight(int height) {
        setAttribute("height", height);
    }
    /**
     * Default height of this item.
     *
     *
     * @return int
     *
     */
    public int getHeight()  {
        return getAttributeAsInt("height");
    }

    /**
    * Number of rows that this item spans
    *
    * @param rowSpan rowSpan Default value is 1
    */
    public void setRowSpan(int rowSpan) {
        setAttribute("rowSpan", rowSpan);
    }
    /**
     * Number of rows that this item spans
     *
     *
     * @return int
     *
     */
    public int getRowSpan()  {
        return getAttributeAsInt("rowSpan");
    }

    /**
    * Whether this item should always start a new row in the form layout.
    *
    * @param startRow startRow Default value is false
    */
    public void setStartRow(Boolean startRow) {
        setAttribute("startRow", startRow);
    }
    /**
     * Whether this item should always start a new row in the form layout.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getStartRow()  {
        return getAttributeAsBoolean("startRow");
    }

    /**
    * Whether this item should end the row it's in in the form layout
    *
    * @param endRow endRow Default value is false
    */
    public void setEndRow(Boolean endRow) {
        setAttribute("endRow", endRow);
    }
    /**
     * Whether this item should end the row it's in in the form layout
     *
     *
     * @return Boolean
     *
     */
    public Boolean getEndRow()  {
        return getAttributeAsBoolean("endRow");
    }
             
    /**
    * Alignment of this item in its cell
    *
    * @param align align Default value is Canvas.LEFT
    */
    public void setAlign(Alignment align) {
        setAttribute("align", align.getValue());
    }
    /**
     * Alignment of this item in its cell
     *
     *
     * @return Alignment
     *
     */
    public Alignment getAlign()  {
        return (Alignment) EnumUtil.getEnum(Alignment.values(), getAttribute("align"));
    }
             
    /**
    * Alignment of the text / content within this form item
    *
    * @param textAlign textAlign Default value is Canvas.LEFT
    */
    public void setTextAlign(Alignment textAlign) {
        setAttribute("textAlign", textAlign.getValue());
    }
    /**
     * Alignment of the text / content within this form item
     *
     *
     * @return Alignment
     *
     */
    public Alignment getTextAlign()  {
        return (Alignment) EnumUtil.getEnum(Alignment.values(), getAttribute("textAlign"));
    }

    /**
    * Left coordinate of this item in pixels.  Applies only when the containing DynamicForm sets <code>itemLayout:"absolute"</code>.
    * For a form with {@link com.smartgwt.client.widgets.form.DynamicForm#getItemLayout itemLayout}:"absolute" only, set the left coordinate of this form item. <P> Causes the form to redraw.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param left left Default value is 0
    */
    public void setLeft(int left) {
        setAttribute("left", left);
    }
    /**
     * Left coordinate of this item in pixels.  Applies only when the containing DynamicForm sets <code>itemLayout:"absolute"</code>.
     *
     *
     * @return int
     *
     */
    public int getLeft()  {
        return getAttributeAsInt("left");
    }

    /**
    * Top coordinate of this item in pixels.  Applies only when the containing DynamicForm sets <code>itemLayout:"absolute"</code>.
    * For a form with {@link com.smartgwt.client.widgets.form.DynamicForm#getItemLayout itemLayout}:"absolute" only, set the top coordinate of this form item. <P> Causes the form to redraw.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param top top Default value is 0
    */
    public void setTop(int top) {
        setAttribute("top", top);
    }
    /**
     * Top coordinate of this item in pixels.  Applies only when the containing DynamicForm sets <code>itemLayout:"absolute"</code>.
     *
     *
     * @return int
     *
     */
    public int getTop()  {
        return getAttributeAsInt("top");
    }

    /**
    * Default icon image source.      Specify as the partial URL to an image, relative to the imgDir of this component. To specify image source for a specific icon use the <code>icon.src</code> property.<br> If this item is drawn in the disabled state, the url will be modified by adding  "_Disabled" to get a disabled state image for the icon. If <code>icon.showOver</code> is true, this url will be modified by adding "_Over" to get an over state image for the icon.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param defaultIconSrc defaultIconSrc Default value is "[SKIN]/DynamicForm/default_formItem_icon.gif"
    */
    public void setDefaultIconSrc(String defaultIconSrc) {
        setAttribute("defaultIconSrc", defaultIconSrc);
    }
    /**
     * Default icon image source.      Specify as the partial URL to an image, relative to the imgDir of this component. To specify image source for a specific icon use the <code>icon.src</code> property.<br> If this item is drawn in the disabled state, the url will be modified by adding  "_Disabled" to get a disabled state image for the icon. If <code>icon.showOver</code> is true, this url will be modified by adding "_Over" to get an over state image for the icon.
     *
     *
     * @return String
     *
     */
    public String getDefaultIconSrc()  {
        return getAttributeAsString("defaultIconSrc");
    }

    /**
    * If we're showing icons, should we change their image source to the appropriate <i>over</i>  source when the user rolls over (or puts focus onto) them?  Can be overridden on a per  icon basis by the formItemIcon <code>showOver</code> property.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param showOverIcons showOverIcons Default value is null
    */
    public void setShowOverIcons(Boolean showOverIcons) {
        setAttribute("showOverIcons", showOverIcons);
    }
    /**
     * If we're showing icons, should we change their image source to the appropriate <i>over</i>  source when the user rolls over (or puts focus onto) them?  Can be overridden on a per  icon basis by the formItemIcon <code>showOver</code> property.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowOverIcons()  {
        return getAttributeAsBoolean("showOverIcons");
    }

    /**
    * If we're showing icons, should we change their image source to the appropriate  <i>focused</i>  source when this item has focus?  Can be overridden on a per  icon basis by the formItemIcon <code>showFocused</code> property.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param showFocusedIcons showFocusedIcons Default value is null
    */
    public void setShowFocusedIcons(Boolean showFocusedIcons) {
        setAttribute("showFocusedIcons", showFocusedIcons);
    }
    /**
     * If we're showing icons, should we change their image source to the appropriate  <i>focused</i>  source when this item has focus?  Can be overridden on a per  icon basis by the formItemIcon <code>showFocused</code> property.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowFocusedIcons()  {
        return getAttributeAsBoolean("showFocusedIcons");
    }
             
    /**
    * How should icons be aligned vertically for this form item.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param iconVAlign iconVAlign Default value is "bottom"
    */
    public void setIconVAlign(VerticalAlignment iconVAlign) {
        setAttribute("iconVAlign", iconVAlign.getValue());
    }
    /**
     * How should icons be aligned vertically for this form item.
     *
     *
     * @return VerticalAlignment
     *
     */
    public VerticalAlignment getIconVAlign()  {
        return (VerticalAlignment) EnumUtil.getEnum(VerticalAlignment.values(), getAttribute("iconVAlign"));
    }

    /**
    * Default height for form item icons
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param iconHeight iconHeight Default value is 20
    */
    public void setIconHeight(int iconHeight) {
        setAttribute("iconHeight", iconHeight);
    }
    /**
     * Default height for form item icons
     *
     *
     * @return Takes an icon definition object, and returns the height for that icon in px.
     *
     */
    public int getIconHeight()  {
        return getAttributeAsInt("iconHeight");
    }

    /**
    * Default width for form item icons
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param iconWidth iconWidth Default value is 20
    */
    public void setIconWidth(int iconWidth) {
        setAttribute("iconWidth", iconWidth);
    }
    /**
     * Default width for form item icons
     *
     *
     * @return Takes an icon definition object, and returns the width for that icon in px.
     *
     */
    public int getIconWidth()  {
        return getAttributeAsInt("iconWidth");
    }

    /**
    * This text is shown as a tooltip prompt when the cursor hovers over this item.
    *
    * @param prompt prompt Default value is null
    */
    public void setPrompt(String prompt) {
        setAttribute("prompt", prompt);
    }
    /**
     * This text is shown as a tooltip prompt when the cursor hovers over this item.
     *
     *
     * @return String
     *
     */
    public String getPrompt()  {
        return getAttributeAsString("prompt");
    }

    /**
    * Default prompt (and tooltip-text) for icons.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param iconPrompt iconPrompt Default value is ""
    */
    public void setIconPrompt(String iconPrompt) {
        setAttribute("iconPrompt", iconPrompt);
    }
    /**
     * Default prompt (and tooltip-text) for icons.
     *
     *
     * @return String
     *
     */
    public String getIconPrompt()  {
        return getAttributeAsString("iconPrompt");
    }

    /**
    * Set to false to suppress writing out any {@link com.smartgwt.client.widgets.form.fields.FormItem#getIcons icons} for this item.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param showIcons showIcons Default value is true
    */
    public void setShowIcons(Boolean showIcons) {
        setAttribute("showIcons", showIcons);
    }
    /**
     * Set to false to suppress writing out any {@link com.smartgwt.client.widgets.form.fields.FormItem#getIcons icons} for this item.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowIcons()  {
        return getAttributeAsBoolean("showIcons");
    }

    /**
    * Height of the error icon, if we're showing icons when validation errors occur.
    *
    * @param errorIconHeight errorIconHeight Default value is 16
    */
    public void setErrorIconHeight(int errorIconHeight) {
        setAttribute("errorIconHeight", errorIconHeight);
    }
    /**
     * Height of the error icon, if we're showing icons when validation errors occur.
     *
     *
     * @return int
     *
     */
    public int getErrorIconHeight()  {
        return getAttributeAsInt("errorIconHeight");
    }

    /**
    * Height of the error icon, if we're showing icons when validation errors occur.
    *
    * @param errorIconWidth errorIconWidth Default value is 16
    */
    public void setErrorIconWidth(int errorIconWidth) {
        setAttribute("errorIconWidth", errorIconWidth);
    }
    /**
     * Height of the error icon, if we're showing icons when validation errors occur.
     *
     *
     * @return int
     *
     */
    public int getErrorIconWidth()  {
        return getAttributeAsInt("errorIconWidth");
    }

    /**
    * URL of the image to show as an error icon, if we're showing icons when validation errors occur.
    *
    * @param errorIconSrc errorIconSrc Default value is "[SKIN]/DynamicForm/validation_error_icon.png"
    */
    public void setErrorIconSrc(String errorIconSrc) {
        setAttribute("errorIconSrc", errorIconSrc);
    }
    /**
     * URL of the image to show as an error icon, if we're showing icons when validation errors occur.
     *
     *
     * @return String
     *
     */
    public String getErrorIconSrc()  {
        return getAttributeAsString("errorIconSrc");
    }

    /**
    * {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorIcons showErrorIcons},  {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}, and {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorStyle showErrorStyle} control how validation errors are displayed next to form items when {@link com.smartgwt.client.widgets.form.DynamicForm#getShowInlineErrors showInlineErrors} is true. These properties are boolean values, and can be set on a DynamicForm to control the  behavior form-wide, or set on individual FormItems. <P> The HTML displayed next to a form item with errors is generated by  {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorHTML}. The default implemenation of that method respects <code>showErrorIcons</code> and <code>showErrorText</code> as follows: <P> <code>showErrorIcons</code>, or <code>showErrorIcon</code> at the FormItem level controls whether an error icon should appear next to fields which have validation errors.  The icon's appearance is governed by {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconSrc errorIconSrc}, {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconWidth errorIconWidth} and {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconHeight errorIconHeight} <P> <code>showErrorText</code> determines whether the text of the validation error should be displayed next to fields which have validation errors. The attribute {@link com.smartgwt.client.widgets.form.DynamicForm#getShowTitlesWithErrorMessages showTitlesWithErrorMessages} may be set to prefix error messages with the  form item's title + <code>":"</code> (may be desired if the item has  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle showTitle} set to false). <P> {@link com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation} controls where the error HTML should appear relative  to form items. Therefore the combination of {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowErrorText showErrorText}<code>:false</code> and {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorOrientation errorOrientation}<code>:"left"</code> creates a compact validation error display consisting of just an icon, to the left of the item with the error message available via a hover (similar appearance to ListGrid validation error display).   <P> In addition to this, <code>showErrorStyle</code> determines whether fields  with validation errors should have special styling applied to them. See ${isc.DocUtils.linkForRef('type:FormItemBaseStyle')} for a  discussion for how error styling is calculated.
    *
    * @param showErrorIcon showErrorIcon Default value is null
    */
    public void setShowErrorIcon(Boolean showErrorIcon) {
        setAttribute("showErrorIcon", showErrorIcon);
    }
    /**
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorIcons showErrorIcons},  {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}, and {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorStyle showErrorStyle} control how validation errors are displayed next to form items when {@link com.smartgwt.client.widgets.form.DynamicForm#getShowInlineErrors showInlineErrors} is true. These properties are boolean values, and can be set on a DynamicForm to control the  behavior form-wide, or set on individual FormItems. <P> The HTML displayed next to a form item with errors is generated by  {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorHTML}. The default implemenation of that method respects <code>showErrorIcons</code> and <code>showErrorText</code> as follows: <P> <code>showErrorIcons</code>, or <code>showErrorIcon</code> at the FormItem level controls whether an error icon should appear next to fields which have validation errors.  The icon's appearance is governed by {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconSrc errorIconSrc}, {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconWidth errorIconWidth} and {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconHeight errorIconHeight} <P> <code>showErrorText</code> determines whether the text of the validation error should be displayed next to fields which have validation errors. The attribute {@link com.smartgwt.client.widgets.form.DynamicForm#getShowTitlesWithErrorMessages showTitlesWithErrorMessages} may be set to prefix error messages with the  form item's title + <code>":"</code> (may be desired if the item has  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle showTitle} set to false). <P> {@link com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation} controls where the error HTML should appear relative  to form items. Therefore the combination of {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowErrorText showErrorText}<code>:false</code> and {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorOrientation errorOrientation}<code>:"left"</code> creates a compact validation error display consisting of just an icon, to the left of the item with the error message available via a hover (similar appearance to ListGrid validation error display).   <P> In addition to this, <code>showErrorStyle</code> determines whether fields  with validation errors should have special styling applied to them. See ${isc.DocUtils.linkForRef('type:FormItemBaseStyle')} for a  discussion for how error styling is calculated.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowErrorIcon()  {
        return getAttributeAsBoolean("showErrorIcon");
    }

    /**
    * {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorIcons showErrorIcons},  {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}, and {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorStyle showErrorStyle} control how validation errors are displayed next to form items when {@link com.smartgwt.client.widgets.form.DynamicForm#getShowInlineErrors showInlineErrors} is true. These properties are boolean values, and can be set on a DynamicForm to control the  behavior form-wide, or set on individual FormItems. <P> The HTML displayed next to a form item with errors is generated by  {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorHTML}. The default implemenation of that method respects <code>showErrorIcons</code> and <code>showErrorText</code> as follows: <P> <code>showErrorIcons</code>, or <code>showErrorIcon</code> at the FormItem level controls whether an error icon should appear next to fields which have validation errors.  The icon's appearance is governed by {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconSrc errorIconSrc}, {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconWidth errorIconWidth} and {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconHeight errorIconHeight} <P> <code>showErrorText</code> determines whether the text of the validation error should be displayed next to fields which have validation errors. The attribute {@link com.smartgwt.client.widgets.form.DynamicForm#getShowTitlesWithErrorMessages showTitlesWithErrorMessages} may be set to prefix error messages with the  form item's title + <code>":"</code> (may be desired if the item has  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle showTitle} set to false). <P> {@link com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation} controls where the error HTML should appear relative  to form items. Therefore the combination of {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowErrorText showErrorText}<code>:false</code> and {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorOrientation errorOrientation}<code>:"left"</code> creates a compact validation error display consisting of just an icon, to the left of the item with the error message available via a hover (similar appearance to ListGrid validation error display).   <P> In addition to this, <code>showErrorStyle</code> determines whether fields  with validation errors should have special styling applied to them. See ${isc.DocUtils.linkForRef('type:FormItemBaseStyle')} for a  discussion for how error styling is calculated.
    *
    * @param showErrorText showErrorText Default value is null
    */
    public void setShowErrorText(Boolean showErrorText) {
        setAttribute("showErrorText", showErrorText);
    }
    /**
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorIcons showErrorIcons},  {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}, and {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorStyle showErrorStyle} control how validation errors are displayed next to form items when {@link com.smartgwt.client.widgets.form.DynamicForm#getShowInlineErrors showInlineErrors} is true. These properties are boolean values, and can be set on a DynamicForm to control the  behavior form-wide, or set on individual FormItems. <P> The HTML displayed next to a form item with errors is generated by  {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorHTML}. The default implemenation of that method respects <code>showErrorIcons</code> and <code>showErrorText</code> as follows: <P> <code>showErrorIcons</code>, or <code>showErrorIcon</code> at the FormItem level controls whether an error icon should appear next to fields which have validation errors.  The icon's appearance is governed by {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconSrc errorIconSrc}, {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconWidth errorIconWidth} and {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconHeight errorIconHeight} <P> <code>showErrorText</code> determines whether the text of the validation error should be displayed next to fields which have validation errors. The attribute {@link com.smartgwt.client.widgets.form.DynamicForm#getShowTitlesWithErrorMessages showTitlesWithErrorMessages} may be set to prefix error messages with the  form item's title + <code>":"</code> (may be desired if the item has  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle showTitle} set to false). <P> {@link com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation} controls where the error HTML should appear relative  to form items. Therefore the combination of {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowErrorText showErrorText}<code>:false</code> and {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorOrientation errorOrientation}<code>:"left"</code> creates a compact validation error display consisting of just an icon, to the left of the item with the error message available via a hover (similar appearance to ListGrid validation error display).   <P> In addition to this, <code>showErrorStyle</code> determines whether fields  with validation errors should have special styling applied to them. See ${isc.DocUtils.linkForRef('type:FormItemBaseStyle')} for a  discussion for how error styling is calculated.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowErrorText()  {
        return getAttributeAsBoolean("showErrorText");
    }

    /**
    * {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorIcons showErrorIcons},  {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}, and {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorStyle showErrorStyle} control how validation errors are displayed next to form items when {@link com.smartgwt.client.widgets.form.DynamicForm#getShowInlineErrors showInlineErrors} is true. These properties are boolean values, and can be set on a DynamicForm to control the  behavior form-wide, or set on individual FormItems. <P> The HTML displayed next to a form item with errors is generated by  {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorHTML}. The default implemenation of that method respects <code>showErrorIcons</code> and <code>showErrorText</code> as follows: <P> <code>showErrorIcons</code>, or <code>showErrorIcon</code> at the FormItem level controls whether an error icon should appear next to fields which have validation errors.  The icon's appearance is governed by {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconSrc errorIconSrc}, {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconWidth errorIconWidth} and {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconHeight errorIconHeight} <P> <code>showErrorText</code> determines whether the text of the validation error should be displayed next to fields which have validation errors. The attribute {@link com.smartgwt.client.widgets.form.DynamicForm#getShowTitlesWithErrorMessages showTitlesWithErrorMessages} may be set to prefix error messages with the  form item's title + <code>":"</code> (may be desired if the item has  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle showTitle} set to false). <P> {@link com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation} controls where the error HTML should appear relative  to form items. Therefore the combination of {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowErrorText showErrorText}<code>:false</code> and {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorOrientation errorOrientation}<code>:"left"</code> creates a compact validation error display consisting of just an icon, to the left of the item with the error message available via a hover (similar appearance to ListGrid validation error display).   <P> In addition to this, <code>showErrorStyle</code> determines whether fields  with validation errors should have special styling applied to them. See ${isc.DocUtils.linkForRef('type:FormItemBaseStyle')} for a  discussion for how error styling is calculated.
    *
    * @param showErrorStyle showErrorStyle Default value is null
    */
    public void setShowErrorStyle(Boolean showErrorStyle) {
        setAttribute("showErrorStyle", showErrorStyle);
    }
    /**
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorIcons showErrorIcons},  {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}, and {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorStyle showErrorStyle} control how validation errors are displayed next to form items when {@link com.smartgwt.client.widgets.form.DynamicForm#getShowInlineErrors showInlineErrors} is true. These properties are boolean values, and can be set on a DynamicForm to control the  behavior form-wide, or set on individual FormItems. <P> The HTML displayed next to a form item with errors is generated by  {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorHTML}. The default implemenation of that method respects <code>showErrorIcons</code> and <code>showErrorText</code> as follows: <P> <code>showErrorIcons</code>, or <code>showErrorIcon</code> at the FormItem level controls whether an error icon should appear next to fields which have validation errors.  The icon's appearance is governed by {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconSrc errorIconSrc}, {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconWidth errorIconWidth} and {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconHeight errorIconHeight} <P> <code>showErrorText</code> determines whether the text of the validation error should be displayed next to fields which have validation errors. The attribute {@link com.smartgwt.client.widgets.form.DynamicForm#getShowTitlesWithErrorMessages showTitlesWithErrorMessages} may be set to prefix error messages with the  form item's title + <code>":"</code> (may be desired if the item has  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle showTitle} set to false). <P> {@link com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation} controls where the error HTML should appear relative  to form items. Therefore the combination of {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowErrorText showErrorText}<code>:false</code> and {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorOrientation errorOrientation}<code>:"left"</code> creates a compact validation error display consisting of just an icon, to the left of the item with the error message available via a hover (similar appearance to ListGrid validation error display).   <P> In addition to this, <code>showErrorStyle</code> determines whether fields  with validation errors should have special styling applied to them. See ${isc.DocUtils.linkForRef('type:FormItemBaseStyle')} for a  discussion for how error styling is calculated.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowErrorStyle()  {
        return getAttributeAsBoolean("showErrorStyle");
    }

    /**
    * Specifies "hint" string to show next to the form item to indicate something to the user. This string generally appears to the right of the form item.
    * Set the hint text for this item
    *
    * @param hint new hint for the item. Default value is null
    */
    public void setHint(String hint) {
        setAttribute("hint", hint);
    }
    /**
     * Specifies "hint" string to show next to the form item to indicate something to the user. This string generally appears to the right of the form item.
     *
     *
     * @return String
     *
     */
    public String getHint()  {
        return getAttributeAsString("hint");
    }

    /**
    * If a hint is defined for this form item, should it be shown?
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param showHint showHint Default value is true
    */
    public void setShowHint(Boolean showHint) {
        setAttribute("showHint", showHint);
    }
    /**
     * If a hint is defined for this form item, should it be shown?
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowHint()  {
        return getAttributeAsBoolean("showHint");
    }

    /**
    * When this item recieves focus, should it be re-styled to indicate it has focus?
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param showFocused showFocused Default value is false
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
    * When this item is disabled, should it be re-styled to indicate its disabled state?
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param showDisabled showDisabled Default value is true
    */
    public void setShowDisabled(Boolean showDisabled) {
        setAttribute("showDisabled", showDisabled);
    }
    /**
     * When this item is disabled, should it be re-styled to indicate its disabled state?
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowDisabled()  {
        return getAttributeAsBoolean("showDisabled");
    }

    /**
    * CSS style applied to the form item as a whole, including the text element, any icons, and any hint text for the item. Applied to the cell containing the form item. <P> NOTE: See the CompoundFormItem_skinning discussion for special skinning considerations.
    *
    * @param cellStyle cellStyle Default value is "formCell"
    */
    public void setCellStyle(String cellStyle) {
        setAttribute("cellStyle", cellStyle);
    }
    /**
     * CSS style applied to the form item as a whole, including the text element, any icons, and any hint text for the item. Applied to the cell containing the form item. <P> NOTE: See the CompoundFormItem_skinning discussion for special skinning considerations.
     *
     *
     * @return String
     *
     */
    public String getCellStyle()  {
        return getAttributeAsString("cellStyle");
    }

    /**
    * CSS class for the "hint" string.
    * Set the hintStyle for this item
    *
    * @param hintStyle new style for hint text. Default value is "formHint"
    */
    public void setHintStyle(String hintStyle) {
        setAttribute("hintStyle", hintStyle);
    }
    /**
     * CSS class for the "hint" string.
     *
     *
     * @return String
     *
     */
    public String getHintStyle()  {
        return getAttributeAsString("hintStyle");
    }

    /**
    * Base CSS class name for a form item's title.
    *
    * @param titleStyle titleStyle Default value is "formTitle"
    */
    public void setTitleStyle(String titleStyle) {
        setAttribute("titleStyle", titleStyle);
    }
    /**
     * Base CSS class name for a form item's title.
     *
     *
     * @return String
     *
     */
    public String getTitleStyle()  {
        return getAttributeAsString("titleStyle");
    }

    /**
    * Base CSS class name for a form item's text box element. <P> NOTE: See the CompoundFormItem_skinning discussion for special skinning considerations.
    *
    * @param textBoxStyle textBoxStyle Default value is null
    */
    public void setTextBoxStyle(String textBoxStyle) {
        setAttribute("textBoxStyle", textBoxStyle);
    }
    /**
     * Base CSS class name for a form item's text box element. <P> NOTE: See the CompoundFormItem_skinning discussion for special skinning considerations.
     *
     *
     * @return String
     *
     */
    public String getTextBoxStyle()  {
        return getAttributeAsString("textBoxStyle");
    }

    /**
    * If specified, this is the number of miliseconds to wait between the user rolling over  this form item, and triggering any hover action for it.<br> If not specified <code>this.form.itemHoverDelay</code> will be used instead.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param hoverDelay hoverDelay Default value is null
    */
    public void setHoverDelay(Integer hoverDelay) {
        setAttribute("hoverDelay", hoverDelay);
    }
    /**
     * If specified, this is the number of miliseconds to wait between the user rolling over  this form item, and triggering any hover action for it.<br> If not specified <code>this.form.itemHoverDelay</code> will be used instead.
     *
     *
     * @return Integer
     *
     */
    public Integer getHoverDelay()  {
        return getAttributeAsInt("hoverDelay");
    }

    /**
    * Option to specify a width for any hover shown for this item.
    *
    * @param hoverWidth hoverWidth Default value is null
    */
    public void setHoverWidth(Integer hoverWidth) {
        setAttribute("hoverWidth", hoverWidth);
    }
    /**
     * Option to specify a width for any hover shown for this item.
     *
     *
     * @return Integer
     *
     */
    public Integer getHoverWidth()  {
        return getAttributeAsInt("hoverWidth");
    }

    /**
    * Option to specify a height for any hover shown for this item.
    *
    * @param hoverHeight hoverHeight Default value is null
    */
    public void setHoverHeight(Integer hoverHeight) {
        setAttribute("hoverHeight", hoverHeight);
    }
    /**
     * Option to specify a height for any hover shown for this item.
     *
     *
     * @return Integer
     *
     */
    public Integer getHoverHeight()  {
        return getAttributeAsInt("hoverHeight");
    }
             
    /**
    * Text alignment  for text displayed in this item's hover canvas, if shown.
    *
    * @param hoverAlign hoverAlign Default value is null
    */
    public void setHoverAlign(Alignment hoverAlign) {
        setAttribute("hoverAlign", hoverAlign.getValue());
    }
    /**
     * Text alignment  for text displayed in this item's hover canvas, if shown.
     *
     *
     * @return Alignment
     *
     */
    public Alignment getHoverAlign()  {
        return (Alignment) EnumUtil.getEnum(Alignment.values(), getAttribute("hoverAlign"));
    }

    /**
    * Vertical text alignment  for text displayed in this item's hover canvas, if shown.
    *
    * @param hoverVAlign hoverVAlign Default value is null
    */
    public void setHoverVAlign(Integer hoverVAlign) {
        setAttribute("hoverVAlign", hoverVAlign);
    }
    /**
     * Vertical text alignment  for text displayed in this item's hover canvas, if shown.
     *
     *
     * @return Integer
     *
     */
    public Integer getHoverVAlign()  {
        return getAttributeAsInt("hoverVAlign");
    }

    /**
    * Explict CSS Style for any hover shown for this item.
    *
    * @param hoverStyle hoverStyle Default value is null
    */
    public void setHoverStyle(String hoverStyle) {
        setAttribute("hoverStyle", hoverStyle);
    }
    /**
     * Explict CSS Style for any hover shown for this item.
     *
     *
     * @return String
     *
     */
    public String getHoverStyle()  {
        return getAttributeAsString("hoverStyle");
    }

    /**
    * Opacity for any hover shown for this item
    *
    * @param hoverOpacity hoverOpacity Default value is null
    */
    public void setHoverOpacity(Integer hoverOpacity) {
        setAttribute("hoverOpacity", hoverOpacity);
    }
    /**
     * Opacity for any hover shown for this item
     *
     *
     * @return Integer
     *
     */
    public Integer getHoverOpacity()  {
        return getAttributeAsInt("hoverOpacity");
    }
             
    /**
    * ${isc.DocUtils.linkForRef('type:OperatorId')} to be used when {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria} is called. <P> <code>item.operator</code> can be used to create a form that offers search functions such as date range filtering, without the more advanced user interface of the {@link com.smartgwt.client.widgets.form.FilterBuilder}. <P> When <code>item.operator</code> is set for any FormItem in a form, <code>form.getValuesAsCriteria()</code> will return an ${isc.DocUtils.linkForRef('object:AdvancedCriteria')} object instead of a normal ${isc.DocUtils.linkForRef('type:Criteria')} object.  Each FormItem will produce one ${isc.DocUtils.linkForRef('object:Criterion')} affecting the DataSource field specified by {@link com.smartgwt.client.widgets.form.fields.FormItem#getCriteriaField criteriaField}. The criteria produced by the FormItems will be grouped under the logical operator provided by {@link com.smartgwt.client.widgets.form.DynamicForm#getOperator operator}. <P> if <code>operator</code> is set for some fields but not others, the default operator is "equals" for fields with a valueMap or an optionDataSource, and for fields of type "enum" (or of a type that inherits from "enum").  The default operator for all other fields is "iContains" (case-insensitive match)  <P> <b>Note:</b> Advanced criteria will only be created for items in a Databound form. If this item is part of a form with no ${isc.DocUtils.linkForRef('DynamicForm.dataSource','dataSource')}, the  <code>operator</code> attribute will have no effect.
    *
    * @param operator operator Default value is null
    */
    public void setOperator(OperatorId operator) {
        setAttribute("operator", operator.getValue());
    }
    /**
     * ${isc.DocUtils.linkForRef('type:OperatorId')} to be used when {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria} is called. <P> <code>item.operator</code> can be used to create a form that offers search functions such as date range filtering, without the more advanced user interface of the {@link com.smartgwt.client.widgets.form.FilterBuilder}. <P> When <code>item.operator</code> is set for any FormItem in a form, <code>form.getValuesAsCriteria()</code> will return an ${isc.DocUtils.linkForRef('object:AdvancedCriteria')} object instead of a normal ${isc.DocUtils.linkForRef('type:Criteria')} object.  Each FormItem will produce one ${isc.DocUtils.linkForRef('object:Criterion')} affecting the DataSource field specified by {@link com.smartgwt.client.widgets.form.fields.FormItem#getCriteriaField criteriaField}. The criteria produced by the FormItems will be grouped under the logical operator provided by {@link com.smartgwt.client.widgets.form.DynamicForm#getOperator operator}. <P> if <code>operator</code> is set for some fields but not others, the default operator is "equals" for fields with a valueMap or an optionDataSource, and for fields of type "enum" (or of a type that inherits from "enum").  The default operator for all other fields is "iContains" (case-insensitive match)  <P> <b>Note:</b> Advanced criteria will only be created for items in a Databound form. If this item is part of a form with no ${isc.DocUtils.linkForRef('DynamicForm.dataSource','dataSource')}, the  <code>operator</code> attribute will have no effect.
     *
     *
     * @return OperatorId
     *
     */
    public OperatorId getOperator()  {
        return (OperatorId) EnumUtil.getEnum(OperatorId.values(), getAttribute("operator"));
    }

    /**
    * When using {@link com.smartgwt.client.widgets.form.fields.FormItem#getOperator operator}, the name of the DataSource field for the ${isc.DocUtils.linkForRef('object:Criterion')} this FormItem generates.  If not specified, defaults to {@link com.smartgwt.client.widgets.form.fields.FormItem#getName name}. <P> Generally, because <code>criteriaField</code> defaults to <code>item.name</code>, you don't need to specify it.  However, if more than one FormItem specifies criteria for the same DataSource field, they will need unique values for {@link com.smartgwt.client.widgets.form.fields.FormItem#getName name} but should set {@link com.smartgwt.client.widgets.form.fields.FormItem#getCriteriaField criteriaField} to the name of DataSource field they both target. <P> For example, if two DateItems are used to provide a min and max date for a single field called "joinDate", set {@link com.smartgwt.client.widgets.form.fields.FormItem#getCriteriaField criteriaField} to "joinDate" on both fields but give the fields distinct names (eg "minDate" and "maxDate") and use those names for any programmatic access, such as {@link com.smartgwt.client.widgets.form.DynamicForm#setValue}.
    *
    * @param criteriaField criteriaField Default value is null
    */
    public void setCriteriaField(String criteriaField) {
        setAttribute("criteriaField", criteriaField);
    }
    /**
     * When using {@link com.smartgwt.client.widgets.form.fields.FormItem#getOperator operator}, the name of the DataSource field for the ${isc.DocUtils.linkForRef('object:Criterion')} this FormItem generates.  If not specified, defaults to {@link com.smartgwt.client.widgets.form.fields.FormItem#getName name}. <P> Generally, because <code>criteriaField</code> defaults to <code>item.name</code>, you don't need to specify it.  However, if more than one FormItem specifies criteria for the same DataSource field, they will need unique values for {@link com.smartgwt.client.widgets.form.fields.FormItem#getName name} but should set {@link com.smartgwt.client.widgets.form.fields.FormItem#getCriteriaField criteriaField} to the name of DataSource field they both target. <P> For example, if two DateItems are used to provide a min and max date for a single field called "joinDate", set {@link com.smartgwt.client.widgets.form.fields.FormItem#getCriteriaField criteriaField} to "joinDate" on both fields but give the fields distinct names (eg "minDate" and "maxDate") and use those names for any programmatic access, such as {@link com.smartgwt.client.widgets.form.DynamicForm#setValue}.
     *
     *
     * @return String
     *
     */
    public String getCriteriaField()  {
        return getAttributeAsString("criteriaField");
    }

    /**
    * When {@link com.smartgwt.client.widgets.form.DynamicForm#getShowInlineErrors showInlineErrors} and {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowErrorText showErrorText} are both true and {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorOrientation errorOrientation} is "left" or "right", errorMessageWidth is the amount to reduce the width of the editor to accomodate the error message and icon.
    *
    * @param errorMessageWidth errorMessageWidth Default value is 80
    */
    public void setErrorMessageWidth(int errorMessageWidth) {
        setAttribute("errorMessageWidth", errorMessageWidth);
    }
    /**
     * When {@link com.smartgwt.client.widgets.form.DynamicForm#getShowInlineErrors showInlineErrors} and {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowErrorText showErrorText} are both true and {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorOrientation errorOrientation} is "left" or "right", errorMessageWidth is the amount to reduce the width of the editor to accomodate the error message and icon.
     *
     *
     * @return int
     *
     */
    public int getErrorMessageWidth()  {
        return getAttributeAsInt("errorMessageWidth");
    }

    /**
    * Should this item's value be saved in the form's values and hence returned from {@link com.smartgwt.client.widgets.form.DynamicForm#getValues}? <p> <code>shouldSaveValue:false</code> is used to mark formItems which do not correspond to the underlying data model and should not save a value into the form's {@link com.smartgwt.client.widgets.form.DynamicForm#getValues values}.  Example includes visual separators, password re-type fields, or checkboxes used to show/hide other form items. <p> A <code>shouldSaveValue:false</code> item should be given a value either via {@link com.smartgwt.client.widgets.form.fields.FormItem#getDefaultValue defaultValue} or by calling can use {@link com.smartgwt.client.widgets.form.DynamicForm#setValue} or  {@link com.smartgwt.client.widgets.form.fields.FormItem#setValue}.  Providing a value via {@link com.smartgwt.client.widgets.form.DynamicForm#getValues values} or {@link com.smartgwt.client.widgets.form.DynamicForm#setValues}  will automatically switch the item to <code>shouldSaveValue:true</code>. <P> Note that <ul> <li>if an item is shouldSaveValue true, but has no name, a warning is logged, and      shouldSaveValue will be set to false. </li></ul>
    *
    * @param shouldSaveValue shouldSaveValue Default value is true
    */
    public void setShouldSaveValue(Boolean shouldSaveValue) {
        setAttribute("shouldSaveValue", shouldSaveValue);
    }
    /**
     * Should this item's value be saved in the form's values and hence returned from {@link com.smartgwt.client.widgets.form.DynamicForm#getValues}? <p> <code>shouldSaveValue:false</code> is used to mark formItems which do not correspond to the underlying data model and should not save a value into the form's {@link com.smartgwt.client.widgets.form.DynamicForm#getValues values}.  Example includes visual separators, password re-type fields, or checkboxes used to show/hide other form items. <p> A <code>shouldSaveValue:false</code> item should be given a value either via {@link com.smartgwt.client.widgets.form.fields.FormItem#getDefaultValue defaultValue} or by calling can use {@link com.smartgwt.client.widgets.form.DynamicForm#setValue} or  {@link com.smartgwt.client.widgets.form.fields.FormItem#setValue}.  Providing a value via {@link com.smartgwt.client.widgets.form.DynamicForm#getValues values} or {@link com.smartgwt.client.widgets.form.DynamicForm#setValues}  will automatically switch the item to <code>shouldSaveValue:true</code>. <P> Note that <ul> <li>if an item is shouldSaveValue true, but has no name, a warning is logged, and      shouldSaveValue will be set to false. </li></ul>
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShouldSaveValue()  {
        return getAttributeAsBoolean("shouldSaveValue");
    }

    // ********************* Methods ***********************

        /**
         * Return the name for the this formItem.
         *
         * @return name for this form item
         */
        public native String getFieldName() /*-{
            var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            return self.getFieldName();
        }-*/;






        /**
         * Update the visual state of a FormItem to reflect any changes in state or any changes in style settings (eg {@link com.smartgwt.client.widgets.form.fields.FormItem#getTextBoxStyle textBoxStyle}).  <P> Calls to <code>updateState()</code> normally occur automatically as a consequence of focus changes, items becoming disabled, etc.  This method is advanced and intended only for use in workarounds.
         */
        public native void updateState() /*-{
            var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            self.updateState();
        }-*/;


        /**
         * Returns true if this item has been written out into the DOM.
         */
        public native void isDrawn() /*-{
            var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            self.isDrawn();
        }-*/;

        /**
         * Show this form item. <BR><BR> This will cause the form to redraw.  If this item had an item.showIf expression, it will be destroyed.
         */
        public native void show() /*-{
            var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            self.show();
        }-*/;

        /**
         * Hide this form item. <BR><BR> This will cause the form to redraw.  If this item had an item.showIf expression, it will be destroyed.
         */
        public native void hide() /*-{
            var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            self.hide();
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
         * Override this method if you need to provide a specialized criterion from this formItem when creating an AdvancedCriteria via {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria}. <P> This API is provided to allow you to specify a more complex criterion than the  "field-operator-value" criterions that are built-in.  Note that the built-in behavior is generally quite flexible and powerful enough for most requirements.  An example of a case where you might want to override this method is if you wanted to implement a date range  selection (ie, date &gt; x AND date &lt; y) on a form that was combining its other criteria  fields with an OR.
         */
        public native void getCriterion() /*-{
            var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            self.getCriterion();
        }-*/;

        /**
         * This method is fired when the user rolls off this item (or the title for this item) and will clear any hover canvas shown by the item.
         */
        public native void stopHover() /*-{
            var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            self.stopHover();
        }-*/;



        /**
         * Add a itemHover handler.
         * <p>
         * Optional stringMethod to fire when the user hovers over this item.  Return false to suppress default behavior of showing a hover canvas containing the  HTML returned by <code>formItem.itemHoverHTML()</code> /   <code>form.itemHoverHTML()</code>.
         *
         * @param handler the itemHover handler
         */
        public HandlerRegistration addItemHoverHandler(com.smartgwt.client.widgets.form.fields.events.ItemHoverHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.ItemHoverEvent.getType()) == 0) setupItemHoverEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.ItemHoverEvent.getType());
        }
        private native void setupItemHoverEvent() /*-{
            var obj = null;
                obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
                var selfJ = this;
                obj.itemHover = function(){
                    var param = {"item" : arguments[0], "form" : arguments[1]};
                    var event = @com.smartgwt.client.widgets.form.fields.events.ItemHoverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
        }-*/;



        /**
         * Add a titleHover handler.
         * <p>
         * Optional stringMethod to fire when the user hovers over this item's title.  Return false to suppress default behavior of showing a hover canvas containing the  HTML returned by <code>formItem.titleHoverHTML()</code> /   <code>form.titleHoverHTML()</code>.
         *
         * @param handler the titleHover handler
         */
        public HandlerRegistration addTitleHoverHandler(com.smartgwt.client.widgets.form.fields.events.TitleHoverHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.TitleHoverEvent.getType()) == 0) setupTitleHoverEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.TitleHoverEvent.getType());
        }
        private native void setupTitleHoverEvent() /*-{
            var obj = null;
                obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
                var selfJ = this;
                obj.titleHover = function(){
                    var param = {"item" : arguments[0], "form" : arguments[1]};
                    var event = @com.smartgwt.client.widgets.form.fields.events.TitleHoverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
        }-*/;




        /**
         * Is this item disabled?
         *
         * @return disabledtrue if this item is be disabled
         */
        public native Boolean isDisabled() /*-{
            var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            var retVal =self.isDisabled();
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;

        /**
         * Set this item to be enabled at runtime.
         */
        public native void enable() /*-{
            var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            self.enable();
        }-*/;

        /**
         * Set this item to be disabled at runtime.
         */
        public native void disable() /*-{
            var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            self.disable();
        }-*/;

        /**
         * Move the keyboard focus into this item's focusable element
         */
        public native void focusInItem() /*-{
            var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            self.focusInItem();
        }-*/;

        /**
         * Takes focus from this form item's focusable element.
         */
        public native void blurItem() /*-{
            var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            self.blurItem();
        }-*/;





        /**
         * Add a focus handler.
         * <p>
         * Called when this FormItem receives focus.
         *
         * @param handler the focus handler
         */
        public HandlerRegistration addFocusHandler(com.smartgwt.client.widgets.form.fields.events.FocusHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.FocusEvent.getType()) == 0) setupFocusEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.FocusEvent.getType());
        }
        private native void setupFocusEvent() /*-{
            var obj = null;
                obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
                var selfJ = this;
                obj.focus = function(){
                    var param = {"form" : arguments[0], "item" : arguments[1]};
                    var event = @com.smartgwt.client.widgets.form.fields.events.FocusEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
        }-*/;



        /**
         * Add a blur handler.
         * <p>
         * Called when this FormItem loses focus.
         *
         * @param handler the blur handler
         */
        public HandlerRegistration addBlurHandler(com.smartgwt.client.widgets.form.fields.events.BlurHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.BlurEvent.getType()) == 0) setupBlurEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.BlurEvent.getType());
        }
        private native void setupBlurEvent() /*-{
            var obj = null;
                obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
                var selfJ = this;
                obj.blur = function(){
                    var param = {"form" : arguments[0], "item" : arguments[1]};
                    var event = @com.smartgwt.client.widgets.form.fields.events.BlurEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
        }-*/;



        /**
         * Add a click handler.
         * <p>
         * Called when this FormItem is clicked on. <P> Note: <code>click()</code> is available on StaticTextItem, BlurbItems, ButtonItem, and derivatives.  Other form items (such as HiddenItem) do not support <code>click()</code>.
         *
         * @param handler the click handler
         */
        public HandlerRegistration addClickHandler(com.smartgwt.client.widgets.form.fields.events.ClickHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.ClickEvent.getType()) == 0) setupClickEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.ClickEvent.getType());
        }
        private native void setupClickEvent() /*-{
            var obj = null;
                obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
                var selfJ = this;
                obj.click = function(){
                    var param = {"form" : arguments[0], "item" : arguments[1]};
                    var event = @com.smartgwt.client.widgets.form.fields.events.ClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
        }-*/;



        /**
         * Add a doubleClick handler.
         * <p>
         * Called when this FormItem is double-clicked.
         *
         * @param handler the doubleClick handler
         */
        public HandlerRegistration addDoubleClickHandler(com.smartgwt.client.widgets.form.fields.events.DoubleClickHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.DoubleClickEvent.getType()) == 0) setupDoubleClickEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.DoubleClickEvent.getType());
        }
        private native void setupDoubleClickEvent() /*-{
            var obj = null;
                obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
                var selfJ = this;
                obj.doubleClick = function(){
                    var param = {"form" : arguments[0], "item" : arguments[1]};
                    var event = @com.smartgwt.client.widgets.form.fields.events.DoubleClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
        }-*/;




        /**
         * Add a iconClick handler.
         * <p>
         * StringMethod.      Default action to fire when the user clicks on a form item icon. May be overridden      by setting <code>click</code> on the form item icon directly.
         *
         * @param handler the iconClick handler
         */
        public HandlerRegistration addIconClickHandler(com.smartgwt.client.widgets.form.fields.events.IconClickHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.IconClickEvent.getType()) == 0) setupIconClickEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.IconClickEvent.getType());
        }
        private native void setupIconClickEvent() /*-{
            var obj = null;
                obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
                var selfJ = this;
                obj.iconClick = function(){
                    var param = {"form" : arguments[0], "item" : arguments[1], "icon" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.form.fields.events.IconClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
        }-*/;






        /**
         * Add a iconKeyPress handler.
         * <p>
         * StringMethod.      Default action to fire when an icon has keyboard focus and the user types a key.      May be overridden by setting <code>keyPress</code> on the form item icon directly.
         *
         * @param handler the iconKeyPress handler
         */
        public HandlerRegistration addIconKeyPressHandler(com.smartgwt.client.widgets.form.fields.events.IconKeyPressHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.IconKeyPressEvent.getType()) == 0) setupIconKeyPressEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.IconKeyPressEvent.getType());
        }
        private native void setupIconKeyPressEvent() /*-{
            var obj = null;
                obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
                var selfJ = this;
                obj.iconKeyPress = function(){
                    var param = {"keyName" : arguments[0], "character" : arguments[1], "form" : arguments[2], "item" : arguments[3], "icon" : arguments[4]};
                    var event = @com.smartgwt.client.widgets.form.fields.events.IconKeyPressEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
        }-*/;





        /**
         * Add a change handler.
         * <p>
         * Called when a FormItem's value is about to change as the result of user interaction.  This method fires after the user performed an action that would change the value of this field, but before the element itself is changed.   <P> Returning false cancels the change.  Note that if what you want to do is <b>transform</b> the user's input, for example, automatically change separator characters to a standard separator character, you should implement {@link com.smartgwt.client.widgets.form.fields.FormItem#transformInput} rather than using a combination of change() and setValue() to accomplish the same thing.  Returning false from <code>change</code> is intended for rejecting input entirely, such as typing invalid characters. <p> Note that if you ask the form for the current value in this handler, you will get the old value because the change has not yet been commited.  The new value is available as a parameter to this method.
         *
         * @param handler the change handler
         */
        public HandlerRegistration addChangeHandler(com.smartgwt.client.widgets.form.fields.events.ChangeHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.ChangeEvent.getType()) == 0) setupChangeEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.ChangeEvent.getType());
        }
        private native void setupChangeEvent() /*-{
            var obj = null;
                obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
                var selfJ = this;
                obj.change = function(){
                    var param = {"form" : arguments[0], "item" : arguments[1], "value" : arguments[2], "oldValue" : arguments[3]};
                    var event = @com.smartgwt.client.widgets.form.fields.events.ChangeEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
        }-*/;




        /**
         * Add a changed handler.
         * <p>
         * Called when a FormItem's value has been changed as the result of user interaction.  This method fires after the newly specified value has been stored.
         *
         * @param handler the changed handler
         */
        public HandlerRegistration addChangedHandler(com.smartgwt.client.widgets.form.fields.events.ChangedHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.ChangedEvent.getType()) == 0) setupChangedEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.ChangedEvent.getType());
        }
        private native void setupChangedEvent() /*-{
            var obj = null;
                obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
                var selfJ = this;
                obj.changed = function(){
                    var param = {"form" : arguments[0], "item" : arguments[1], "value" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.form.fields.events.ChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
        }-*/;






        /**
         * Add a keyPress handler.
         * <p>
         * StringMethod fired when the user presses a key while focused in this form item.
         *
         * @param handler the keyPress handler
         */
        public HandlerRegistration addKeyPressHandler(com.smartgwt.client.widgets.form.fields.events.KeyPressHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.KeyPressEvent.getType()) == 0) setupKeyPressEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.KeyPressEvent.getType());
        }
        private native void setupKeyPressEvent() /*-{
            var obj = null;
                obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
                var selfJ = this;
                obj.keyPress = function(){
                    var param = {"item" : arguments[0], "form" : arguments[1], "keyName" : arguments[2], "characterValue" : arguments[3]};
                    var event = @com.smartgwt.client.widgets.form.fields.events.KeyPressEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
        }-*/;


    // ********************* Static Methods ***********************







    public void setAttribute(String attribute, String value) {
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

    public void setAttribute(String attribute, int[] value) {
        if (!isCreated()) {
            JSOHelper.setAttribute(jsObj, attribute, JSOHelper.convertToJavaScriptArray(value));
        } else {
            setProperty(attribute, JSOHelper.convertToJavaScriptArray(value));
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


    public void setAttribute(String attribute, double value) {
        if (!isCreated()) {
            JSOHelper.setAttribute(jsObj, attribute, value);
        } else {
            setProperty(attribute, value);
        }
    }

    public void setAttribute(String attribute, int value) {
        if (!isCreated()) {
            JSOHelper.setAttribute(jsObj, attribute, value);
        } else {
            setProperty(attribute, value);
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

    public void setAttribute(String attribute, boolean value) {
        if (!isCreated()) {
            JSOHelper.setAttribute(jsObj, attribute, value);
        } else {
            setProperty(attribute, value);
        }
    }

    public String getAttribute(String attribute) {
        return getAttributeAsString(attribute);
    }

    public String getAttributeAsString(String attribute) {
        if (isCreated()) {
            return getPropertyAsString(attribute);
        } else {
            return JSOHelper.getAttribute(jsObj, attribute);
        }
    }

    public Date getAttributeAsDate(String attribute) {
        if (isCreated()) {
            return getPropertyAsDate(attribute);
        } else {
            return JSOHelper.getAttributeAsDate(jsObj, attribute);
        }
    }

    public Double getAttributeAsDouble(String attribute) {
        if (isCreated()) {
            return getPropertyAsDouble(attribute);
        } else {
            return JSOHelper.getAttributeAsDouble(jsObj, attribute);
        }
    }

    public JavaScriptObject getAttributeAsJavaScriptObject(String attribute) {
        if (isCreated()) {
            return getPropertyAsJSO(attribute);
        } else {
            return JSOHelper.getAttributeAsJavaScriptObject(jsObj, attribute);
        }
    }

    public Integer getAttributeAsInt(String attribute) {
        if (isCreated()) {
            return getPropertyAsInt(attribute);
        } else {
            return JSOHelper.getAttributeAsInt(jsObj, attribute);
        }
    }

    public Float getAttributeAsFloat(String attribute) {
        if (isCreated()) {
            return getPropertyAsFloat(attribute);
        } else {
            return JSOHelper.getAttributeAsFloat(jsObj, attribute);
        }
    }

    public Boolean getAttributeAsBoolean(String attribute) {
        if (isCreated()) {
            return getPropertyAsBoolean(attribute);
        } else {
            return JSOHelper.getAttributeAsBoolean(jsObj, attribute);
        }
    }

    private native String getPropertyAsString(String property)/*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getProperty(property);
        return ret === undefined ? null : ret;
    }-*/;

    private native Date getPropertyAsDate(String property)/*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getProperty(property);
        return ret == null || ret === undefined ? null : @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;

    private native Integer getPropertyAsInt(String property)/*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getProperty(property);
        return ret == null || ret === undefined ? null : @com.smartgwt.client.util.JSOHelper::toInteger(I)(ret);
    }-*/;

    private native Double getPropertyAsDouble(String property)/*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getProperty(property);
        return ret == null || ret === undefined ? null : @com.smartgwt.client.util.JSOHelper::toDouble(D)(ret);
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
        return ret == null || ret === undefined ? null : @com.smartgwt.client.util.JSOHelper::toFloat(F)(ret);
    }-*/;

    private native Boolean getPropertyAsBoolean(String property)/*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getProperty(property);
        return ret == null || ret === undefined ? null : @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

    public native void setProperty(String property, String value)/*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.setProperty(property, value);
    }-*/;

    public native void setProperty(String property, boolean value)/*-{
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

    protected native boolean isCreated()/*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        return !!self.setValue;
    }-*/;

    public void setOptionDataSource(DataSource dataSource) {
        setAttribute("optionDataSource", dataSource.getOrCreateJsObj());
    }


    /**
     * Validators for this form item.
     * <p/>
     * <b>Note</b>: these validators will only be run on the client; to do real client-server validation, validators
     * must be specified on the DataSource.
     *
     * @param validators the validators
     */
    public void setValidators(Validator... validators) {
        setAttribute("validators", validators);
    }

    /**
     * An array of descriptor objects for icons to display in a line after this form item.  These icons are clickable
     * images, often used to display some kind of helper for   populating a form item.
     *
     * @param icons icons Default value is null
     */
    public void setIcons(FormItemIcon... icons) {
        setAttribute("icons", icons);
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
     * ${isc.DocUtils.linkForRef('type:TitleOrientation')} is either "left" or "right".
     *
     * @param colSpan colSpan Default value is 1
     */
    public void setColSpan(String colSpan) {
        setAttribute("colSpan", colSpan);
    }

    /**
     * Number of columns that this item spans.   <P> The <code>colSpan</code> setting does not include the title shown
     * for items with {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle showTitle}:true, so the
     * effective <code>colSpan</code> is one higher than this setting for items that are showing a title and whose
     * ${isc.DocUtils.linkForRef('type:TitleOrientation')} is either "left" or "right".
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
     * or set to <code>null</code> programatically, it will be reverted to the <code>defaultValue</code>. Developers
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
     * or set to <code>null</code> programatically, it will be reverted to the <code>defaultValue</code>. Developers
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
     * or set to <code>null</code> programatically, it will be reverted to the <code>defaultValue</code>. Developers
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
     * or set to <code>null</code> programatically, it will be reverted to the <code>defaultValue</code>. Developers
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
     * or set to <code>null</code> programatically, it will be reverted to the <code>defaultValue</code>. Developers
     * should use the {@link com.smartgwt.client.widgets.form.DynamicForm#getValues values}  object if their intention
     * is to provide an initial value for a field in a form rather  than a value to use in place of <code>null</code>.
     *
     * @param defaultValue defaultValue Default value is null
     */
    public void setDefaultValue(Float defaultValue) {
        setAttribute("defaultValue", defaultValue);
    }

    /**
     * Set the valueMap for this item.
     *
     * @param valueMap the value map
     */
    public void setValueMap(String... valueMap) {
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
     */
    public void setValueMap(java.util.LinkedHashMap valueMap) {
        if (!isCreated()) {
            setAttribute("valueMap", valueMap);
        } else {
            setValueMapMethod(JSOHelper.convertMapToJavascriptObject(valueMap));
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

    public void setWidth(String width) {
        setAttribute("width", width);
    }

    public void setHeight(String height) {
        setAttribute("height", height);
    }

    /**
     * Setting to true causes the FormItem to be immediately redrawn with the new properties
     * when its value changes
     *
     * @param redrawOnChange true to redraw on change. Default is false
     */
    public void setRedrawOnChange(boolean redrawOnChange) {
        setAttribute("redrawOnChange", redrawOnChange);
    }

    /**
     * Name of the FormItem to use for editing, eg "TextItem" or "SelectItem". <P> The type of FormItem to use for
     * editing is normally derived automatically from {@link com.smartgwt.client.widgets.form.fields.FormItem#getType
     * type}, which is the data type of the field, by the rules explained ${isc.DocUtils.linkForRef('type:FormItemType','here')}.
     *
     * @param editorType editorType Default value is null
     */
    public void setEditorType(FormItem editorType) {
        setAttribute("editorType", editorType.getType());
    }

    public native Object getValue() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var value = self.getValue();
        var valueJ = $wnd.SmartGWT.convertToJavaType(value);
        return valueJ;
    }-*/;

    public native void setValue(int value) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if(self.setValue) {
            self.setValue(value);
        } else {
            self.defaultValue = value;
        }
    }-*/;

    public native void setValue(float value) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if(self.setValue) {
            self.setValue(value);
        } else {
            self.defaultValue = value;
        }
    }-*/;

    public native void setValue(double value) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if(self.setValue) {
            self.setValue(value);
        } else {
            self.defaultValue = value;
        }
    }-*/;

    public native void setValue(Date value) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var valueJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(value);
        if(self.setValue) {
            self.setValue(valueJS);
        } else {
            self.defaultValue = valueJS;
        }
    }-*/;

    public native void setValue(String value) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if(self.setValue) {
            self.setValue(value);
        } else {
            self.defaultValue = value;
        }
    }-*/;

    public native void setValue(boolean value) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if(self.setValue) {
            self.setValue(value);
        } else {
            self.defaultValue = value;
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
    * Causes the FormItem to be redrawn immediately with the new properties.
    *
    * @see #setRedrawOnChange(boolean)
    */
    public native void redraw() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if(self.setValue) {
            self.redraw();
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

    public native JavaScriptObject getConfig() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var config = {};

        for(var k in self) {
            if(k != '__ref' && k != 'type' && k != 'name') {
                config[k] = self[k];
            }
        }
        return config;
    }-*/;

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

}




