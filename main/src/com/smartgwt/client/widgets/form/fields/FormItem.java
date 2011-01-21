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
 * An Item that can participate in a DynamicForm, managing some value. <P> FormItems are never directly created, instead,
 * FormItem descriptors are passed to a DynamicForm.  See the {@link com.smartgwt.client.widgets.form.DynamicForm}
 * documentation for details.
 */
public class FormItem extends RefDataClass  implements com.smartgwt.client.widgets.form.fields.events.HasFocusHandlers, com.smartgwt.client.widgets.form.fields.events.HasBlurHandlers, com.smartgwt.client.widgets.form.fields.events.HasChangeHandlers, com.smartgwt.client.widgets.form.fields.events.HasChangedHandlers, com.smartgwt.client.widgets.form.fields.events.HasKeyPressHandlers, com.smartgwt.client.widgets.form.fields.events.HasKeyUpHandlers, com.smartgwt.client.widgets.form.fields.events.HasKeyDownHandlers, com.smartgwt.client.widgets.form.fields.events.HasIconClickHandlers, com.smartgwt.client.widgets.form.fields.events.HasIconKeyPressHandlers, com.smartgwt.client.widgets.form.fields.events.HasItemHoverHandlers, com.smartgwt.client.widgets.form.fields.events.HasClickHandlers, com.smartgwt.client.widgets.form.fields.events.HasDoubleClickHandlers, com.smartgwt.client.widgets.form.fields.events.HasTitleHoverHandlers, com.smartgwt.client.widgets.form.fields.events.HasTitleClickHandlers, com.smartgwt.client.widgets.form.fields.events.HasTitleDoubleClickHandlers {

    public static FormItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (FormItem) obj;
        } else {
            return FormItemFactory.getFormItem(jsObj);
        }
    }

    public FormItem(){
        setName(com.smartgwt.client.util.SC.generateID(getClass().getName()));
    }

    public FormItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    // ********************* Properties / Attributes ***********************

    /**
     * AccessKey - a keyboard shortcut to trigger a form item's default behavior.<br>      Note: Alt+ (or in Moz Firefox 2.0
     * and above, Shift+Alt+) the specified key will       trigger the form item's default behavior.
     *
     * @param accessKey accessKey Default value is null
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public void setAccessKey(String accessKey) {
        setAttribute("accessKey", accessKey);
    }

    /**
     * AccessKey - a keyboard shortcut to trigger a form item's default behavior.<br>      Note: Alt+ (or in Moz Firefox 2.0
     * and above, Shift+Alt+) the specified key will       trigger the form item's default behavior.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public String getAccessKey()  {
        return getAttributeAsString("accessKey");
    }

    /**
     * Alignment of this item in its cell. Note that the alignment of content within this item can be separately controlled via
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getTextAlign textAlign} (typically only applies to items showing
     * a "textBox", such as {@link com.smartgwt.client.widgets.form.fields.TextItem textItems} or {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem selectItems}).
     *
     * @param align align Default value is Canvas.LEFT
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setAlign(Alignment align) {
        setAttribute("align", align.getValue());
    }

    /**
     * Alignment of this item in its cell. Note that the alignment of content within this item can be separately controlled via
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getTextAlign textAlign} (typically only applies to items showing
     * a "textBox", such as {@link com.smartgwt.client.widgets.form.fields.TextItem textItems} or {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem selectItems}).
     *
     *
     * @return Alignment
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Alignment getAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("align"));
    }

    /**
     * If this form item has a specified {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * optionDataSource} and  {@link com.smartgwt.client.widgets.form.fields.FormItem#getFetchMissingValues fetchMissingValues}
     * is true, this property may be set to true to ensure a fetch will occur against the optionDataSource to retrieve the
     * related record even if {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} is unset.
     * <P> An example of a use case where this might be set would be if {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#formatValue FormItem.formatValue} or {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#formatEditorValue FormItem.formatEditorValue} were written to display
     * properties from the {@link com.smartgwt.client.widgets.form.fields.FormItem#getSelectedRecord selected record}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param alwaysFetchMissingValues alwaysFetchMissingValues Default value is false
     */
    public void setAlwaysFetchMissingValues(Boolean alwaysFetchMissingValues) {
        setAttribute("alwaysFetchMissingValues", alwaysFetchMissingValues);
    }

    /**
     * If this form item has a specified {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * optionDataSource} and  {@link com.smartgwt.client.widgets.form.fields.FormItem#getFetchMissingValues fetchMissingValues}
     * is true, this property may be set to true to ensure a fetch will occur against the optionDataSource to retrieve the
     * related record even if {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} is unset.
     * <P> An example of a use case where this might be set would be if {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#formatValue FormItem.formatValue} or {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#formatEditorValue FormItem.formatEditorValue} were written to display
     * properties from the {@link com.smartgwt.client.widgets.form.fields.FormItem#getSelectedRecord selected record}.
     *
     *
     * @return Boolean
     */
    public Boolean getAlwaysFetchMissingValues()  {
        return getAttributeAsBoolean("alwaysFetchMissingValues");
    }

    /**
     * If this browser supports spell-checking of text editing elements, do we want this enabled for this item? If unset the
     * property will be inherited from the containing form. <P> Notes:<br> - this property only applies to text based items
     * such as TextItem and TextAreaItem.<br> - this property is not supported on all browsers.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param browserSpellCheck browserSpellCheck Default value is null
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
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.form.DynamicForm#getBrowserSpellCheck
     */
    public Boolean getBrowserSpellCheck()  {
        return getAttributeAsBoolean("browserSpellCheck");
    }

    /**
     * Is this form item focusable? Setting this property to true on an otherwise non-focusable element such as a {@link
     * com.smartgwt.client.widgets.form.fields.StaticTextItem} will cause the item to be included in the page's tab order and
     * respond to keyboard events.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canFocus canFocus Default value is null
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
     *
     * @return Returns true for items that can accept keyboard focus such as data items  ({@link
     * com.smartgwt.client.widgets.form.fields.TextItem TextItems}, {@link com.smartgwt.client.widgets.form.fields.TextAreaItem
     * TextAreaItems}, etc),  {@link com.smartgwt.client.widgets.form.fields.CanvasItem CanvasItems} with a focusable canvas,
     * or items where {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanFocus canFocus} was explicitly set to true.
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public Boolean getCanFocus()  {
        return getAttributeAsBoolean("canFocus");
    }

    /**
     * If specified, this property will govern the height of the cell in which this form item is rendered. Will not apply when
     * the containing DynamicForm sets <code>itemLayout:"absolute"</code>.
     *
     * @param cellHeight cellHeight Default value is null
     */
    public void setCellHeight(Integer cellHeight) {
        setAttribute("cellHeight", cellHeight);
    }

    /**
     * If specified, this property will govern the height of the cell in which this form item is rendered. Will not apply when
     * the containing DynamicForm sets <code>itemLayout:"absolute"</code>.
     *
     *
     * @return Integer
     */
    public Integer getCellHeight()  {
        return getAttributeAsInt("cellHeight");
    }

    /**
     * CSS style applied to the form item as a whole, including the text element, any icons, and any hint text for the item.
     * Applied to the cell containing the form item. <P> NOTE: See the {@link CompoundFormItem_skinning} discussion for special
     * skinning considerations.
     *
     * @param cellStyle cellStyle Default value is "formCell"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setCellStyle(String cellStyle) {
        setAttribute("cellStyle", cellStyle);
    }

    /**
     * CSS style applied to the form item as a whole, including the text element, any icons, and any hint text for the item.
     * Applied to the cell containing the form item. <P> NOTE: See the {@link CompoundFormItem_skinning} discussion for special
     * skinning considerations.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getCellStyle()  {
        return getAttributeAsString("cellStyle");
    }


    /**
     * A Read-Only pointer to the Smart GWT canvas that holds this form item. In most cases this will be the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getForm DynamicForm} containing the item but in some cases editable
     * components handle writing out form items directly. An example of this is {@link com.smartgwt.client.docs.Editing Grid
     * Editing} - when a listGrid shows per-field editors, the <code>containerWidget</code> for each item will be the listGrid.
     * <P> Note that even if the <code>containerWidget</code> is not a DynamicForm, a DynamicForm will still exist for the item
     * (available as {@link com.smartgwt.client.widgets.form.fields.FormItem#getForm form}), allowing access to standard APIs
     * such as {@link com.smartgwt.client.widgets.form.DynamicForm#getValues DynamicForm.getValues}
     *
     *
     * @return Canvas
     */
    public Canvas getContainerWidget()  {
        return Canvas.getOrCreateRef(getAttributeAsJavaScriptObject("containerWidget"));
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
     * access, such as {@link com.smartgwt.client.widgets.form.DynamicForm#setValue DynamicForm.setValue}.
     *
     * @param criteriaField criteriaField Default value is null
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
     * access, such as {@link com.smartgwt.client.widgets.form.DynamicForm#setValue DynamicForm.setValue}.
     *
     *
     * @return String
     */
    public String getCriteriaField()  {
        return getAttributeAsString("criteriaField");
    }

    /**
     * dataPath for this item. Allows the user to edit details nested data structures in a flat set of form fields
     *
     * @param dataPath dataPath Default value is null
     */
    public void setDataPath(String dataPath) {
        setAttribute("dataPath", dataPath);
    }

    /**
     * dataPath for this item. Allows the user to edit details nested data structures in a flat set of form fields
     *
     *
     * @return Return the dataPath for the this formItem.
     */
    public String getDataPath()  {
        return getAttributeAsString("dataPath");
    }

    /**
     * Display format to use for date type values within this formItem. Default is to use the system-wide default short date
     * format, configured via  Date.setShortDisplayFormat.  Specify any valid {@link
     * com.smartgwt.client.types.DateDisplayFormat} to  change the format used by this item.<br> Note: if both
     * <code>dateFormatter</code> and {@link com.smartgwt.client.widgets.form.fields.FormItem#getTimeFormatter timeFormatter}
     * are specified on an item, Date type values will be formatted as dates using  <code>dateFormatter</code>.<br> See also
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayFormat displayFormat} and  {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getDisplayFormat displayFormat} for formatting dates displayed in
     * DateItems.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param dateFormatter dateFormatter Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setDateFormatter(DateDisplayFormat dateFormatter) {
        setAttribute("dateFormatter", dateFormatter.getValue());
    }

    /**
     * Display format to use for date type values within this formItem. Default is to use the system-wide default short date
     * format, configured via  Date.setShortDisplayFormat.  Specify any valid {@link
     * com.smartgwt.client.types.DateDisplayFormat} to  change the format used by this item.<br> Note: if both
     * <code>dateFormatter</code> and {@link com.smartgwt.client.widgets.form.fields.FormItem#getTimeFormatter timeFormatter}
     * are specified on an item, Date type values will be formatted as dates using  <code>dateFormatter</code>.<br> See also
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayFormat displayFormat} and  {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getDisplayFormat displayFormat} for formatting dates displayed in
     * DateItems.
     *
     *
     * @return DateDisplayFormat
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public DateDisplayFormat getDateFormatter()  {
        return EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("dateFormatter"));
    }

    /**
     * Default icon image source.      Specify as the partial URL to an image, relative to the imgDir of this component. To
     * specify image source for a specific icon use the <code>icon.src</code> property.<br> If this item is drawn in the
     * disabled state, the url will be modified by adding  "_Disabled" to get a disabled state image for the icon. If
     * <code>icon.showOver</code> is true, this url will be modified by adding "_Over" to get an over state image for the icon.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param defaultIconSrc defaultIconSrc Default value is "[SKIN]/DynamicForm/default_formItem_icon.gif"
     */
    public void setDefaultIconSrc(String defaultIconSrc) {
        setAttribute("defaultIconSrc", defaultIconSrc);
    }

    /**
     * Default icon image source.      Specify as the partial URL to an image, relative to the imgDir of this component. To
     * specify image source for a specific icon use the <code>icon.src</code> property.<br> If this item is drawn in the
     * disabled state, the url will be modified by adding  "_Disabled" to get a disabled state image for the icon. If
     * <code>icon.showOver</code> is true, this url will be modified by adding "_Over" to get an over state image for the icon.
     *
     *
     * @return String
     */
    public String getDefaultIconSrc()  {
        return getAttributeAsString("defaultIconSrc");
    }

    /**
     * Whether this item is disabled.  Can be updated at runtime via the <code>setDisabled()</code> method.  Note that if the
     * widget containing this formItem is disabled, the formItem will behave in a disabled manner regardless of the setting of
     * the item.disabled property. <p> Note that not all items can be disabled, and not all browsers show an obvious disabled
     * style for native form elements.
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
     * Whether this item is disabled.  Can be updated at runtime via the <code>setDisabled()</code> method.  Note that if the
     * widget containing this formItem is disabled, the formItem will behave in a disabled manner regardless of the setting of
     * the item.disabled property. <p> Note that not all items can be disabled, and not all browsers show an obvious disabled
     * style for native form elements.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setDisabled
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_dep_enable_disable" target="examples">Enable & Disable Example</a>
     */
    public Boolean getDisabled()  {
        return getAttributeAsBoolean("disabled");
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
     */
    public String getEmptyDisplayValue()  {
        return getAttributeAsString("emptyDisplayValue");
    }

    /**
     * This property allows the developer to specify an icon to display when this item has no value. It is configured in the
     * same way as any other valueIcon  (see {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons})
     *
     * @param emptyValueIcon emptyValueIcon Default value is null
     */
    public void setEmptyValueIcon(String emptyValueIcon) {
        setAttribute("emptyValueIcon", emptyValueIcon);
    }

    /**
     * This property allows the developer to specify an icon to display when this item has no value. It is configured in the
     * same way as any other valueIcon  (see {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons})
     *
     *
     * @return String
     */
    public String getEmptyValueIcon()  {
        return getAttributeAsString("emptyValueIcon");
    }

    /**
     * Whether this item should end the row it's in in the form layout
     *
     * @param endRow endRow Default value is false
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public void setEndRow(Boolean endRow) {
        setAttribute("endRow", endRow);
    }

    /**
     * Whether this item should end the row it's in in the form layout
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public Boolean getEndRow()  {
        return getAttributeAsBoolean("endRow");
    }

    /**
     * Height of the error icon, if we're showing icons when validation errors occur.
     *
     * @param errorIconHeight errorIconHeight Default value is 16
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setShowErrorIcon
     */
    public void setErrorIconHeight(int errorIconHeight) {
        setAttribute("errorIconHeight", errorIconHeight);
    }

    /**
     * Height of the error icon, if we're showing icons when validation errors occur.
     *
     *
     * @return int
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getShowErrorIcon
     */
    public int getErrorIconHeight()  {
        return getAttributeAsInt("errorIconHeight");
    }

    /**
     * URL of the image to show as an error icon, if we're showing icons when validation errors occur.
     *
     * @param errorIconSrc errorIconSrc Default value is "[SKIN]/DynamicForm/validation_error_icon.png"
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setShowErrorIcon
     */
    public void setErrorIconSrc(String errorIconSrc) {
        setAttribute("errorIconSrc", errorIconSrc);
    }

    /**
     * URL of the image to show as an error icon, if we're showing icons when validation errors occur.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getShowErrorIcon
     */
    public String getErrorIconSrc()  {
        return getAttributeAsString("errorIconSrc");
    }

    /**
     * Height of the error icon, if we're showing icons when validation errors occur.
     *
     * @param errorIconWidth errorIconWidth Default value is 16
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setShowErrorIcon
     */
    public void setErrorIconWidth(int errorIconWidth) {
        setAttribute("errorIconWidth", errorIconWidth);
    }

    /**
     * Height of the error icon, if we're showing icons when validation errors occur.
     *
     *
     * @return int
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getShowErrorIcon
     */
    public int getErrorIconWidth()  {
        return getAttributeAsInt("errorIconWidth");
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.DynamicForm#getShowInlineErrors showInlineErrors} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowErrorText showErrorText} are both true and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorOrientation errorOrientation} is "left" or "right",
     * errorMessageWidth is the amount to reduce the width of the editor to accommodate the error message and icon.
     *
     * @param errorMessageWidth errorMessageWidth Default value is 80
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public void setErrorMessageWidth(int errorMessageWidth) {
        setAttribute("errorMessageWidth", errorMessageWidth);
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.DynamicForm#getShowInlineErrors showInlineErrors} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowErrorText showErrorText} are both true and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorOrientation errorOrientation} is "left" or "right",
     * errorMessageWidth is the amount to reduce the width of the editor to accommodate the error message and icon.
     *
     *
     * @return int
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public int getErrorMessageWidth()  {
        return getAttributeAsInt("errorMessageWidth");
    }

    /**
     * If this form item has a specified {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * optionDataSource}, should the item ever perform a fetch against this dataSource to retrieve the related record. <P> The
     * fetch occurs if the item value is non null on initial draw of the form or whenever setValue() is called. Once the fetch
     * completes, the returned record  is available via the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getSelectedRecord FormItem.getSelectedRecord} api. <P> By default, a
     * fetch will only occur if {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} is
     * specified, and the item does not have an explicit {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueMap
     * valueMap} containing the data value as a key.<br> However you can also set {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getAlwaysMissingFetchValues alwaysMissingFetchValues} to have a fetch
     * occur even if no <code>displayField</code> is specified. This ensures  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getSelectedRecord FormItem.getSelectedRecord} will return a record if
     * possible - useful for custom formatter functions, etc.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param fetchMissingValues fetchMissingValues Default value is true
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
     * com.smartgwt.client.widgets.form.fields.FormItem#getSelectedRecord FormItem.getSelectedRecord} api. <P> By default, a
     * fetch will only occur if {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} is
     * specified, and the item does not have an explicit {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueMap
     * valueMap} containing the data value as a key.<br> However you can also set {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getAlwaysMissingFetchValues alwaysMissingFetchValues} to have a fetch
     * occur even if no <code>displayField</code> is specified. This ensures  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getSelectedRecord FormItem.getSelectedRecord} will return a record if
     * possible - useful for custom formatter functions, etc.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getSelectedRecord
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getFilterLocally
     */
    public Boolean getFetchMissingValues()  {
        return getAttributeAsBoolean("fetchMissingValues");
    }

    /**
     * If this form item is mapping data values to a display value by fetching records from a  dataSource (see {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField}  and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getFetchMissingValues fetchMissingValues}), setting this property to
     * true ensures that when the form item value is set, entire data-set from the dataSource is loaded at once and  used as a
     * valueMap, rather than just loading the display value for the current value. This avoids the need to perform fetches each
     * time setValue() is called with a new value. <P> See also  filterLocally for behavior on form items such as SelectItems
     * that show pick-lists.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param filterLocally filterLocally Default value is null
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
     * time setValue() is called with a new value. <P> See also  filterLocally for behavior on form items such as SelectItems
     * that show pick-lists.
     *
     *
     * @return Boolean
     */
    public Boolean getFilterLocally()  {
        return getAttributeAsBoolean("filterLocally");
    }

    /**
     * TabIndex for the form item within the page. Takes precedence over any local tab index specified as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTabIndex item.tabIndex}. <P> Use of this API is <b>extremely</b>
     * advanced and essentially implies taking over management of tab index assignment for all components on the page.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param globalTabIndex globalTabIndex Default value is null
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
     *
     * @return Integer
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public Integer getGlobalTabIndex()  {
        return getAttributeAsInt("globalTabIndex");
    }

    /**
     * Height of the FormItem.  Can be either a number indicating a fixed height in pixels, a percentage indicating a
     * percentage of the overall form's height, or "*" indicating take whatever remaining space is available.  <P> See the
     * {@link com.smartgwt.client.docs.FormLayout} overview for details.
     *
     * @param height height Default value is 20
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_form_filling" target="examples">Filling Example</a>
     */
    public void setHeight(int height) {
        setAttribute("height", height);
    }

    /**
     * Height of the FormItem.  Can be either a number indicating a fixed height in pixels, a percentage indicating a
     * percentage of the overall form's height, or "*" indicating take whatever remaining space is available.  <P> See the
     * {@link com.smartgwt.client.docs.FormLayout} overview for details.
     *
     *
     * @return int
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_form_filling" target="examples">Filling Example</a>
     */
    public int getHeight()  {
        return getAttributeAsInt("height");
    }

    /**
     * Specifies "hint" string to show next to the form item to indicate something to the user. This string generally appears
     * to the right of the form item.
     * Set the hint text for this item
     *
     * @param hint new hint for the item. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setHintStyle
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
     *
     * @return String
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getHintStyle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_details_hints" target="examples">Hints Example</a>
     */
    public String getHint()  {
        return getAttributeAsString("hint");
    }

    /**
     * CSS class for the "hint" string.
     * Set the hintStyle for this item
     *
     * @param hintStyle new style for hint text. Default value is "formHint"
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setHint
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setHintStyle(String hintStyle) {
        setAttribute("hintStyle", hintStyle);
    }

    /**
     * CSS class for the "hint" string.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getHint
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getHintStyle()  {
        return getAttributeAsString("hintStyle");
    }

    /**
     * Text alignment  for text displayed in this item's hover canvas, if shown.
     *
     * @param hoverAlign hoverAlign Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#setItemHoverAlign
     */
    public void setHoverAlign(Alignment hoverAlign) {
        setAttribute("hoverAlign", hoverAlign.getValue());
    }

    /**
     * Text alignment  for text displayed in this item's hover canvas, if shown.
     *
     *
     * @return Alignment
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
     * @param hoverDelay hoverDelay Default value is null
     */
    public void setHoverDelay(Integer hoverDelay) {
        setAttribute("hoverDelay", hoverDelay);
    }

    /**
     * If specified, this is the number of milliseconds to wait between the user rolling over  this form item, and triggering
     * any hover action for it.<br> If not specified <code>this.form.itemHoverDelay</code> will be used instead.
     *
     *
     * @return Integer
     */
    public Integer getHoverDelay()  {
        return getAttributeAsInt("hoverDelay");
    }

    /**
     * Option to specify a height for any hover shown for this item.
     *
     * @param hoverHeight hoverHeight Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#setItemHoverHeight
     */
    public void setHoverHeight(Integer hoverHeight) {
        setAttribute("hoverHeight", hoverHeight);
    }

    /**
     * Option to specify a height for any hover shown for this item.
     *
     *
     * @return Integer
     * @see com.smartgwt.client.widgets.form.DynamicForm#getItemHoverHeight
     */
    public Integer getHoverHeight()  {
        return getAttributeAsInt("hoverHeight");
    }

    /**
     * Opacity for any hover shown for this item
     *
     * @param hoverOpacity hoverOpacity Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#setItemHoverOpacity
     */
    public void setHoverOpacity(Integer hoverOpacity) {
        setAttribute("hoverOpacity", hoverOpacity);
    }

    /**
     * Opacity for any hover shown for this item
     *
     *
     * @return Integer
     * @see com.smartgwt.client.widgets.form.DynamicForm#getItemHoverOpacity
     */
    public Integer getHoverOpacity()  {
        return getAttributeAsInt("hoverOpacity");
    }

    /**
     * Explicit CSS Style for any hover shown for this item.
     *
     * @param hoverStyle hoverStyle Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#setItemHoverStyle
     */
    public void setHoverStyle(String hoverStyle) {
        setAttribute("hoverStyle", hoverStyle);
    }

    /**
     * Explicit CSS Style for any hover shown for this item.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.form.DynamicForm#getItemHoverStyle
     */
    public String getHoverStyle()  {
        return getAttributeAsString("hoverStyle");
    }

    /**
     * Vertical text alignment  for text displayed in this item's hover canvas, if shown.
     *
     * @param hoverVAlign hoverVAlign Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#setItemHoverVAlign
     */
    public void setHoverVAlign(VerticalAlignment hoverVAlign) {
        setAttribute("hoverVAlign", hoverVAlign.getValue());
    }

    /**
     * Vertical text alignment  for text displayed in this item's hover canvas, if shown.
     *
     *
     * @return VerticalAlignment
     * @see com.smartgwt.client.widgets.form.DynamicForm#getItemHoverVAlign
     */
    public VerticalAlignment getHoverVAlign()  {
        return EnumUtil.getEnum(VerticalAlignment.values(), getAttribute("hoverVAlign"));
    }

    /**
     * Option to specify a width for any hover shown for this item.
     *
     * @param hoverWidth hoverWidth Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#setItemHoverWidth
     */
    public void setHoverWidth(Integer hoverWidth) {
        setAttribute("hoverWidth", hoverWidth);
    }

    /**
     * Option to specify a width for any hover shown for this item.
     *
     *
     * @return Integer
     * @see com.smartgwt.client.widgets.form.DynamicForm#getItemHoverWidth
     */
    public Integer getHoverWidth()  {
        return getAttributeAsInt("hoverWidth");
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
     */
    public int getIconHeight()  {
        return getAttributeAsInt("iconHeight");
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
     */
    public String getIconPrompt()  {
        return getAttributeAsString("iconPrompt");
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
     */
    public VerticalAlignment getIconVAlign()  {
        return EnumUtil.getEnum(VerticalAlignment.values(), getAttribute("iconVAlign"));
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
     */
    public int getIconWidth()  {
        return getAttributeAsInt("iconWidth");
    }

    /**
     * Prefix to apply to the beginning of any {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons
     * valueIcons} when determining the URL for the image. Will not be applied if the <code>valueIcon</code> URL is absolute.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param imageURLPrefix imageURLPrefix Default value is null
     */
    public void setImageURLPrefix(String imageURLPrefix) {
        setAttribute("imageURLPrefix", imageURLPrefix);
    }

    /**
     * Prefix to apply to the beginning of any {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons
     * valueIcons} when determining the URL for the image. Will not be applied if the <code>valueIcon</code> URL is absolute.
     *
     *
     * @return String
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
     * @param imageURLSuffix imageURLSuffix Default value is null
     */
    public void setImageURLSuffix(String imageURLSuffix) {
        setAttribute("imageURLSuffix", imageURLSuffix);
    }

    /**
     * Suffix to apply to the end of any {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons} when
     * determining the URL for the image. A common usage would be to specify a suffix of <code>".gif"</code> in which case the
     * <code>valueIcons</code> property would map values to the names of images without the <code>".gif"</code> extension.
     *
     *
     * @return String
     */
    public String getImageURLSuffix()  {
        return getAttributeAsString("imageURLSuffix");
    }

    /**
     * For fields of type <code>"date"</code>, if this is an editable field such as a {@link
     * com.smartgwt.client.widgets.form.fields.TextItem}, this property  allows you to specify the {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat inputFormat} applied to the item.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param inputFormat inputFormat Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setDisplayFormat
     */
    public void setInputFormat(String inputFormat) {
        setAttribute("inputFormat", inputFormat);
    }

    /**
     * For fields of type <code>"date"</code>, if this is an editable field such as a {@link
     * com.smartgwt.client.widgets.form.fields.TextItem}, this property  allows you to specify the {@link
     * com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat inputFormat} applied to the item.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getDisplayFormat
     */
    public String getInputFormat()  {
        return getAttributeAsString("inputFormat");
    }

    /**
     * Left coordinate of this item in pixels.  Applies only when the containing DynamicForm sets
     * <code>itemLayout:"absolute"</code>.
     * For a form with {@link com.smartgwt.client.widgets.form.DynamicForm#getItemLayout itemLayout}:"absolute" only, set the left coordinate of this form item. <P> Causes the form to redraw.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param left left Default value is 0
     */
    public void setLeft(int left) {
        setAttribute("left", left);
    }

    /**
     * Left coordinate of this item in pixels.  Applies only when the containing DynamicForm sets
     * <code>itemLayout:"absolute"</code>.
     *
     *
     * @return Returns the left coordinate of this form item in pixels. Note that this method is only reliable after the item has been
     * drawn.
     */
    public int getLeft()  {
        return getAttributeAsInt("left");
    }

    /**
     * When  AutoTest.getElement is used to parse locator strings generated by link{isc.AutoTest.getLocator()} for this form
     * item, should the item be identified? By default if the item has a name this will always be used, however for items with
     * no name, the following options are available: <ul> <li><code>"title"</code> use the title as an identifier within this
     * form</li> <li><code>"value"</code> use the value of the item to identify it (often used  for items with a static
     * defaultValue such as HeaderItems</li> <li><code>"index"</code> use the index within the form's items array. </ul>  If
     * unset, and the item has no specified name, default behavior is to identify by title (if available), otherwise by index.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param locateItemBy locateItemBy Default value is null
     */
    public void setLocateItemBy(String locateItemBy) {
        setAttribute("locateItemBy", locateItemBy);
    }

    /**
     * When  AutoTest.getElement is used to parse locator strings generated by link{isc.AutoTest.getLocator()} for this form
     * item, should the item be identified? By default if the item has a name this will always be used, however for items with
     * no name, the following options are available: <ul> <li><code>"title"</code> use the title as an identifier within this
     * form</li> <li><code>"value"</code> use the value of the item to identify it (often used  for items with a static
     * defaultValue such as HeaderItems</li> <li><code>"index"</code> use the index within the form's items array. </ul>  If
     * unset, and the item has no specified name, default behavior is to identify by title (if available), otherwise by index.
     *
     *
     * @return String
     */
    public String getLocateItemBy()  {
        return getAttributeAsString("locateItemBy");
    }

    /**
     * If this item is displaying multiple values, this property will be the string that separates those values for display
     * purposes.
     *
     * @param multipleValueSeparator multipleValueSeparator Default value is ', '
     */
    public void setMultipleValueSeparator(String multipleValueSeparator) {
        setAttribute("multipleValueSeparator", multipleValueSeparator);
    }

    /**
     * If this item is displaying multiple values, this property will be the string that separates those values for display
     * purposes.
     *
     *
     * @return String
     */
    public String getMultipleValueSeparator()  {
        return getAttributeAsString("multipleValueSeparator");
    }

    /**
     * {@link com.smartgwt.client.types.OperatorId} to be used when {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria DynamicForm.getValuesAsCriteria} is called. <P>
     * <code>item.operator</code> can be used to create a form that offers search functions such as date range filtering,
     * without the more advanced user interface of the {@link com.smartgwt.client.widgets.form.FilterBuilder}. <P> When
     * <code>item.operator</code> is set for any FormItem in a form, <code>form.getValuesAsCriteria()</code> will return an
     * {@link com.smartgwt.client.data.AdvancedCriteria} object instead of a normal {@link com.smartgwt.client.data.Criteria}
     * object.  Each FormItem will produce one {@link com.smartgwt.client.data.Criterion} affecting the DataSource field
     * specified by {@link com.smartgwt.client.widgets.form.fields.FormItem#getCriteriaField criteriaField}. The criteria
     * produced by the FormItems will be grouped under the logical operator provided by {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getOperator operator}. <P> if <code>operator</code> is set for some fields
     * but not others, the default operator is "equals" for fields with a valueMap or an optionDataSource, and for fields of
     * type "enum" (or of a type that inherits from "enum").  The default operator for all other fields is "iContains"
     * (case-insensitive match)  <P> <b>Note:</b> Advanced criteria will only be created for items in a Databound form. If this
     * item is part of a form with no {@link com.smartgwt.client.widgets.DataBoundComponent#getDataSource dataSource}, the 
     * <code>operator</code> attribute will have no effect.
     *
     * @param operator operator Default value is null
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public void setOperator(OperatorId operator) {
        setAttribute("operator", operator.getValue());
    }

    /**
     * {@link com.smartgwt.client.types.OperatorId} to be used when {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria DynamicForm.getValuesAsCriteria} is called. <P>
     * <code>item.operator</code> can be used to create a form that offers search functions such as date range filtering,
     * without the more advanced user interface of the {@link com.smartgwt.client.widgets.form.FilterBuilder}. <P> When
     * <code>item.operator</code> is set for any FormItem in a form, <code>form.getValuesAsCriteria()</code> will return an
     * {@link com.smartgwt.client.data.AdvancedCriteria} object instead of a normal {@link com.smartgwt.client.data.Criteria}
     * object.  Each FormItem will produce one {@link com.smartgwt.client.data.Criterion} affecting the DataSource field
     * specified by {@link com.smartgwt.client.widgets.form.fields.FormItem#getCriteriaField criteriaField}. The criteria
     * produced by the FormItems will be grouped under the logical operator provided by {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getOperator operator}. <P> if <code>operator</code> is set for some fields
     * but not others, the default operator is "equals" for fields with a valueMap or an optionDataSource, and for fields of
     * type "enum" (or of a type that inherits from "enum").  The default operator for all other fields is "iContains"
     * (case-insensitive match)  <P> <b>Note:</b> Advanced criteria will only be created for items in a Databound form. If this
     * item is part of a form with no {@link com.smartgwt.client.widgets.DataBoundComponent#getDataSource dataSource}, the 
     * <code>operator</code> attribute will have no effect.
     *
     *
     * @return OperatorId
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public OperatorId getOperator()  {
        return EnumUtil.getEnum(OperatorId.values(), getAttribute("operator"));
    }

    /**
     * If this item has a specified <code>optionDataSource</code>, this attribute may be set to specify an explicit {@link
     * com.smartgwt.client.data.DSRequest#getOperationId operationId} when performing a fetch against the option dataSource to
     * pick up display value mapping.
     * <p><b>Note : </b> This is an advanced setting</p>
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
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon showPickerIcon} is true for this item, this
     * property governs the size of the picker icon. If unset picker icon will be sized as a square to fit in the available
     * height for the icon.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param pickerIconHeight pickerIconHeight Default value is null
     */
    public void setPickerIconHeight(Integer pickerIconHeight) {
        setAttribute("pickerIconHeight", pickerIconHeight);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon showPickerIcon} is true for this item, this
     * property governs the size of the picker icon. If unset picker icon will be sized as a square to fit in the available
     * height for the icon.
     *
     *
     * @return Integer
     */
    public Integer getPickerIconHeight()  {
        return getAttributeAsInt("pickerIconHeight");
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon showPickerIcon} is true, this attribute
     * specifies the  {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getName name} applied to the picker icon
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param pickerIconName pickerIconName Default value is "picker"
     */
    public void setPickerIconName(String pickerIconName) {
        setAttribute("pickerIconName", pickerIconName);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon showPickerIcon} is true, this attribute
     * specifies the  {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getName name} applied to the picker icon
     *
     *
     * @return String
     */
    public String getPickerIconName()  {
        return getAttributeAsString("pickerIconName");
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon showPickerIcon} is true for this item, this
     * property governs the src of the picker icon image to be displayed.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param pickerIconSrc pickerIconSrc Default value is ""
     */
    public void setPickerIconSrc(String pickerIconSrc) {
        setAttribute("pickerIconSrc", pickerIconSrc);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon showPickerIcon} is true for this item, this
     * property governs the src of the picker icon image to be displayed.
     *
     *
     * @return String
     */
    public String getPickerIconSrc()  {
        return getAttributeAsString("pickerIconSrc");
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon showPickerIcon} is true for this item, this
     * property governs the size of the picker icon. If unset picker icon will be sized as a square to fit in the available
     * height for the icon.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param pickerIconWidth pickerIconWidth Default value is null
     */
    public void setPickerIconWidth(Integer pickerIconWidth) {
        setAttribute("pickerIconWidth", pickerIconWidth);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon showPickerIcon} is true for this item, this
     * property governs the size of the picker icon. If unset picker icon will be sized as a square to fit in the available
     * height for the icon.
     *
     *
     * @return Integer
     */
    public Integer getPickerIconWidth()  {
        return getAttributeAsInt("pickerIconWidth");
    }

    /**
     * Base CSS class name for a form item's text box element when getting printable HTML for the form. If unset {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTextBoxStyle textBoxStyle} will be used instead. Note that focused
     * styling will never be displayed while printing, though error and disabled styling will.
     *
     * @param printTextBoxStyle printTextBoxStyle Default value is null
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
     *
     * @return String
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public String getPrintTextBoxStyle()  {
        return getAttributeAsString("printTextBoxStyle");
    }

    /**
     * Base CSS stylename for a form item's title when generating print HTML for the item. If unset {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTitleStyle titleStyle} will be used instead.
     *
     * @param printTitleStyle printTitleStyle Default value is null
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public void setPrintTitleStyle(String printTitleStyle) {
        setAttribute("printTitleStyle", printTitleStyle);
    }

    /**
     * Base CSS stylename for a form item's title when generating print HTML for the item. If unset {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTitleStyle titleStyle} will be used instead.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public String getPrintTitleStyle()  {
        return getAttributeAsString("printTitleStyle");
    }

    /**
     * This text is shown as a tooltip prompt when the cursor hovers over this item.
     *
     * @param prompt prompt Default value is null
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public void setPrompt(String prompt) {
        setAttribute("prompt", prompt);
    }

    /**
     * This text is shown as a tooltip prompt when the cursor hovers over this item.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public String getPrompt()  {
        return getAttributeAsString("prompt");
    }

    /**
     * If validateOnChange is true, and validation fails for this item on change, with no suggested value, should we revert to
     * the previous value, or continue to display the bad value entered by the user. May be set at the item or form level.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param rejectInvalidValueOnChange rejectInvalidValueOnChange Default value is false
     */
    public void setRejectInvalidValueOnChange(Boolean rejectInvalidValueOnChange) {
        setAttribute("rejectInvalidValueOnChange", rejectInvalidValueOnChange);
    }

    /**
     * If validateOnChange is true, and validation fails for this item on change, with no suggested value, should we revert to
     * the previous value, or continue to display the bad value entered by the user. May be set at the item or form level.
     *
     *
     * @return Boolean
     */
    public Boolean getRejectInvalidValueOnChange()  {
        return getAttributeAsBoolean("rejectInvalidValueOnChange");
    }

    /**
     * Whether a non-empty value is required for this field to pass validation. <P> If the user does not fill in the required
     * field, the error message to be shown will be taken from these properties in the following order: {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getRequiredMessage requiredMessage}, {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getRequiredMessage requiredMessage}, {@link
     * com.smartgwt.client.data.DataSource#getRequiredMessage requiredMessage},  {@link
     * com.smartgwt.client.widgets.form.validator.Validator#requiredField requiredField}. <P> <b>Note:</b> if specified on a
     * FormItem, <code>required</code> is only enforced on the client.  <code>required</code> should generally be specified on
     * a {@link com.smartgwt.client.data.DataSourceField}.
     * Setter to mark this formItem as {@link com.smartgwt.client.widgets.form.fields.FormItem#getRequired required}, or not required at runtime. Note that an alternative approach to updating the <code>required</code> flag directly would be to simply use a {@link com.smartgwt.client.types.ValidatorType requiredIf} type validator. <P> Note that this method will not re-validate this item by default or clear any  existing validation errors. If desired, this may be achieved by calling {@link com.smartgwt.client.widgets.form.fields.FormItem#validate FormItem.validate} or {@link com.smartgwt.client.widgets.form.DynamicForm#clearErrors DynamicForm.clearErrors}.
     *
     * @param required new {@link com.smartgwt.client.widgets.form.fields.FormItem#getRequired required} value.. Default value is null
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
     * com.smartgwt.client.widgets.form.DynamicForm#getRequiredMessage requiredMessage}, {@link
     * com.smartgwt.client.data.DataSource#getRequiredMessage requiredMessage},  {@link
     * com.smartgwt.client.widgets.form.validator.Validator#requiredField requiredField}. <P> <b>Note:</b> if specified on a
     * FormItem, <code>required</code> is only enforced on the client.  <code>required</code> should generally be specified on
     * a {@link com.smartgwt.client.data.DataSourceField}.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_dep_show_hide" target="examples">Show & Hide Example</a>
     */
    public Boolean getRequired()  {
        return getAttributeAsBoolean("required");
    }

    /**
     * The required message for required field errors.
     *
     * @param requiredMessage requiredMessage Default value is null
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public void setRequiredMessage(String requiredMessage) {
        setAttribute("requiredMessage", requiredMessage);
    }

    /**
     * The required message for required field errors.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public String getRequiredMessage()  {
        return getAttributeAsString("requiredMessage");
    }

    /**
     * Number of rows that this item spans
     *
     * @param rowSpan rowSpan Default value is 1
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public void setRowSpan(int rowSpan) {
        setAttribute("rowSpan", rowSpan);
    }

    /**
     * Number of rows that this item spans
     *
     *
     * @return int
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public int getRowSpan()  {
        return getAttributeAsInt("rowSpan");
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
     * @param shouldSaveValue shouldSaveValue Default value is true
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
     *
     * @return Boolean
     */
    public Boolean getShouldSaveValue()  {
        return getAttributeAsBoolean("shouldSaveValue");
    }

    /**
     * When this item is disabled, should it be re-styled to indicate its disabled state?
     * Setter method for {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowDisabled showDisabled}
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showDisabled new showDisabled setting. Default value is true
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setCellStyle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setShowDisabled(Boolean showDisabled) {
        setAttribute("showDisabled", showDisabled);
    }

    /**
     * When this item is disabled, should it be re-styled to indicate its disabled state?
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getCellStyle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowDisabled()  {
        return getAttributeAsBoolean("showDisabled");
    }

    /**
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorIcons showErrorIcons},  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}, and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorStyle showErrorStyle} control how validation errors are
     * displayed when they are displayed inline in the form (next to the form item where there is a validation error).  To
     * instead display all errors at the top of the form, set {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowInlineErrors showInlineErrors}:false. <P>
     * <code>showErrorIcons</code>, <code>showErrorText</code> and <code>showErrorStyle</code> are all boolean properties, and
     * can be set on a DynamicForm to control the behavior form-wide, or set on individual FormItems.   <P> The HTML displayed
     * next to a form item with errors is generated by  {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorHTML
     * FormItem.getErrorHTML}. The default implementation of that method respects <code>showErrorIcons</code> and
     * <code>showErrorText</code> as follows: <P> <code>showErrorIcons</code>, or <code>showErrorIcon</code> at the FormItem
     * level controls whether an error icon should appear next to fields which have validation errors.  The icon's appearance
     * is governed by {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconSrc errorIconSrc}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconWidth errorIconWidth} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconHeight errorIconHeight} <P> <code>showErrorText</code>
     * determines whether the text of the validation error should be displayed next to fields which have validation errors. The
     * attribute {@link com.smartgwt.client.widgets.form.DynamicForm#getShowTitlesWithErrorMessages
     * showTitlesWithErrorMessages} may be set to prefix error messages with the  form item's title + <code>":"</code> (may be
     * desired if the item has  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle showTitle} set to false).
     * <P> {@link com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation} controls where the error
     * HTML should appear relative  to form items. Therefore the combination of {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowErrorText showErrorText}<code>:false</code> and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorOrientation errorOrientation}<code>:"left"</code> creates a
     * compact validation error display consisting of just an icon, to the left of the item with the error message available
     * via a hover (similar appearance to ListGrid validation error display).   <P> In addition to this,
     * <code>showErrorStyle</code> determines whether fields  with validation errors should have special styling applied to
     * them. See String for a  discussion for how error styling is calculated.
     *
     * @param showErrorIcon showErrorIcon Default value is null
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
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowInlineErrors showInlineErrors}:false. <P>
     * <code>showErrorIcons</code>, <code>showErrorText</code> and <code>showErrorStyle</code> are all boolean properties, and
     * can be set on a DynamicForm to control the behavior form-wide, or set on individual FormItems.   <P> The HTML displayed
     * next to a form item with errors is generated by  {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorHTML
     * FormItem.getErrorHTML}. The default implementation of that method respects <code>showErrorIcons</code> and
     * <code>showErrorText</code> as follows: <P> <code>showErrorIcons</code>, or <code>showErrorIcon</code> at the FormItem
     * level controls whether an error icon should appear next to fields which have validation errors.  The icon's appearance
     * is governed by {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconSrc errorIconSrc}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconWidth errorIconWidth} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconHeight errorIconHeight} <P> <code>showErrorText</code>
     * determines whether the text of the validation error should be displayed next to fields which have validation errors. The
     * attribute {@link com.smartgwt.client.widgets.form.DynamicForm#getShowTitlesWithErrorMessages
     * showTitlesWithErrorMessages} may be set to prefix error messages with the  form item's title + <code>":"</code> (may be
     * desired if the item has  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle showTitle} set to false).
     * <P> {@link com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation} controls where the error
     * HTML should appear relative  to form items. Therefore the combination of {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowErrorText showErrorText}<code>:false</code> and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorOrientation errorOrientation}<code>:"left"</code> creates a
     * compact validation error display consisting of just an icon, to the left of the item with the error message available
     * via a hover (similar appearance to ListGrid validation error display).   <P> In addition to this,
     * <code>showErrorStyle</code> determines whether fields  with validation errors should have special styling applied to
     * them. See String for a  discussion for how error styling is calculated.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowErrorIcon()  {
        return getAttributeAsBoolean("showErrorIcon");
    }

    /**
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorIcons showErrorIcons},  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}, and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorStyle showErrorStyle} control how validation errors are
     * displayed when they are displayed inline in the form (next to the form item where there is a validation error).  To
     * instead display all errors at the top of the form, set {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowInlineErrors showInlineErrors}:false. <P>
     * <code>showErrorIcons</code>, <code>showErrorText</code> and <code>showErrorStyle</code> are all boolean properties, and
     * can be set on a DynamicForm to control the behavior form-wide, or set on individual FormItems.   <P> The HTML displayed
     * next to a form item with errors is generated by  {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorHTML
     * FormItem.getErrorHTML}. The default implementation of that method respects <code>showErrorIcons</code> and
     * <code>showErrorText</code> as follows: <P> <code>showErrorIcons</code>, or <code>showErrorIcon</code> at the FormItem
     * level controls whether an error icon should appear next to fields which have validation errors.  The icon's appearance
     * is governed by {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconSrc errorIconSrc}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconWidth errorIconWidth} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconHeight errorIconHeight} <P> <code>showErrorText</code>
     * determines whether the text of the validation error should be displayed next to fields which have validation errors. The
     * attribute {@link com.smartgwt.client.widgets.form.DynamicForm#getShowTitlesWithErrorMessages
     * showTitlesWithErrorMessages} may be set to prefix error messages with the  form item's title + <code>":"</code> (may be
     * desired if the item has  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle showTitle} set to false).
     * <P> {@link com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation} controls where the error
     * HTML should appear relative  to form items. Therefore the combination of {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowErrorText showErrorText}<code>:false</code> and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorOrientation errorOrientation}<code>:"left"</code> creates a
     * compact validation error display consisting of just an icon, to the left of the item with the error message available
     * via a hover (similar appearance to ListGrid validation error display).   <P> In addition to this,
     * <code>showErrorStyle</code> determines whether fields  with validation errors should have special styling applied to
     * them. See String for a  discussion for how error styling is calculated.
     *
     * @param showErrorStyle showErrorStyle Default value is null
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
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowInlineErrors showInlineErrors}:false. <P>
     * <code>showErrorIcons</code>, <code>showErrorText</code> and <code>showErrorStyle</code> are all boolean properties, and
     * can be set on a DynamicForm to control the behavior form-wide, or set on individual FormItems.   <P> The HTML displayed
     * next to a form item with errors is generated by  {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorHTML
     * FormItem.getErrorHTML}. The default implementation of that method respects <code>showErrorIcons</code> and
     * <code>showErrorText</code> as follows: <P> <code>showErrorIcons</code>, or <code>showErrorIcon</code> at the FormItem
     * level controls whether an error icon should appear next to fields which have validation errors.  The icon's appearance
     * is governed by {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconSrc errorIconSrc}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconWidth errorIconWidth} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconHeight errorIconHeight} <P> <code>showErrorText</code>
     * determines whether the text of the validation error should be displayed next to fields which have validation errors. The
     * attribute {@link com.smartgwt.client.widgets.form.DynamicForm#getShowTitlesWithErrorMessages
     * showTitlesWithErrorMessages} may be set to prefix error messages with the  form item's title + <code>":"</code> (may be
     * desired if the item has  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle showTitle} set to false).
     * <P> {@link com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation} controls where the error
     * HTML should appear relative  to form items. Therefore the combination of {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowErrorText showErrorText}<code>:false</code> and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorOrientation errorOrientation}<code>:"left"</code> creates a
     * compact validation error display consisting of just an icon, to the left of the item with the error message available
     * via a hover (similar appearance to ListGrid validation error display).   <P> In addition to this,
     * <code>showErrorStyle</code> determines whether fields  with validation errors should have special styling applied to
     * them. See String for a  discussion for how error styling is calculated.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getCellStyle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowErrorStyle()  {
        return getAttributeAsBoolean("showErrorStyle");
    }

    /**
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorIcons showErrorIcons},  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}, and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorStyle showErrorStyle} control how validation errors are
     * displayed when they are displayed inline in the form (next to the form item where there is a validation error).  To
     * instead display all errors at the top of the form, set {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowInlineErrors showInlineErrors}:false. <P>
     * <code>showErrorIcons</code>, <code>showErrorText</code> and <code>showErrorStyle</code> are all boolean properties, and
     * can be set on a DynamicForm to control the behavior form-wide, or set on individual FormItems.   <P> The HTML displayed
     * next to a form item with errors is generated by  {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorHTML
     * FormItem.getErrorHTML}. The default implementation of that method respects <code>showErrorIcons</code> and
     * <code>showErrorText</code> as follows: <P> <code>showErrorIcons</code>, or <code>showErrorIcon</code> at the FormItem
     * level controls whether an error icon should appear next to fields which have validation errors.  The icon's appearance
     * is governed by {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconSrc errorIconSrc}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconWidth errorIconWidth} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconHeight errorIconHeight} <P> <code>showErrorText</code>
     * determines whether the text of the validation error should be displayed next to fields which have validation errors. The
     * attribute {@link com.smartgwt.client.widgets.form.DynamicForm#getShowTitlesWithErrorMessages
     * showTitlesWithErrorMessages} may be set to prefix error messages with the  form item's title + <code>":"</code> (may be
     * desired if the item has  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle showTitle} set to false).
     * <P> {@link com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation} controls where the error
     * HTML should appear relative  to form items. Therefore the combination of {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowErrorText showErrorText}<code>:false</code> and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorOrientation errorOrientation}<code>:"left"</code> creates a
     * compact validation error display consisting of just an icon, to the left of the item with the error message available
     * via a hover (similar appearance to ListGrid validation error display).   <P> In addition to this,
     * <code>showErrorStyle</code> determines whether fields  with validation errors should have special styling applied to
     * them. See String for a  discussion for how error styling is calculated.
     *
     * @param showErrorText showErrorText Default value is null
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
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowInlineErrors showInlineErrors}:false. <P>
     * <code>showErrorIcons</code>, <code>showErrorText</code> and <code>showErrorStyle</code> are all boolean properties, and
     * can be set on a DynamicForm to control the behavior form-wide, or set on individual FormItems.   <P> The HTML displayed
     * next to a form item with errors is generated by  {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorHTML
     * FormItem.getErrorHTML}. The default implementation of that method respects <code>showErrorIcons</code> and
     * <code>showErrorText</code> as follows: <P> <code>showErrorIcons</code>, or <code>showErrorIcon</code> at the FormItem
     * level controls whether an error icon should appear next to fields which have validation errors.  The icon's appearance
     * is governed by {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconSrc errorIconSrc}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconWidth errorIconWidth} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconHeight errorIconHeight} <P> <code>showErrorText</code>
     * determines whether the text of the validation error should be displayed next to fields which have validation errors. The
     * attribute {@link com.smartgwt.client.widgets.form.DynamicForm#getShowTitlesWithErrorMessages
     * showTitlesWithErrorMessages} may be set to prefix error messages with the  form item's title + <code>":"</code> (may be
     * desired if the item has  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle showTitle} set to false).
     * <P> {@link com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation} controls where the error
     * HTML should appear relative  to form items. Therefore the combination of {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowErrorText showErrorText}<code>:false</code> and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorOrientation errorOrientation}<code>:"left"</code> creates a
     * compact validation error display consisting of just an icon, to the left of the item with the error message available
     * via a hover (similar appearance to ListGrid validation error display).   <P> In addition to this,
     * <code>showErrorStyle</code> determines whether fields  with validation errors should have special styling applied to
     * them. See String for a  discussion for how error styling is calculated.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowErrorText()  {
        return getAttributeAsBoolean("showErrorText");
    }

    /**
     * When this item receives focus, should it be re-styled to indicate it has focus?
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showFocused showFocused Default value is false
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
     * If we're showing icons, should we change their image source to the appropriate  <i>focused</i>  source when this item
     * has focus?  Can be overridden on a per  icon basis by the formItemIcon <code>showFocused</code> property.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showFocusedIcons showFocusedIcons Default value is null
     */
    public void setShowFocusedIcons(Boolean showFocusedIcons) {
        setAttribute("showFocusedIcons", showFocusedIcons);
    }

    /**
     * If we're showing icons, should we change their image source to the appropriate  <i>focused</i>  source when this item
     * has focus?  Can be overridden on a per  icon basis by the formItemIcon <code>showFocused</code> property.
     *
     *
     * @return Boolean
     */
    public Boolean getShowFocusedIcons()  {
        return getAttributeAsBoolean("showFocusedIcons");
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon showPickerIcon} is true for this item,
     * should the picker icon show a focused image when the form item has focus?
     *
     * @param showFocusedPickerIcon showFocusedPickerIcon Default value is false
     */
    public void setShowFocusedPickerIcon(Boolean showFocusedPickerIcon) {
        setAttribute("showFocusedPickerIcon", showFocusedPickerIcon);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon showPickerIcon} is true for this item,
     * should the picker icon show a focused image when the form item has focus?
     *
     *
     * @return Boolean
     */
    public Boolean getShowFocusedPickerIcon()  {
        return getAttributeAsBoolean("showFocusedPickerIcon");
    }

    /**
     * If a hint is defined for this form item, should it be shown?
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showHint showHint Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setShowHint(Boolean showHint) {
        setAttribute("showHint", showHint);
    }

    /**
     * If a hint is defined for this form item, should it be shown?
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowHint()  {
        return getAttributeAsBoolean("showHint");
    }

    /**
     * Set to false to suppress writing out any {@link com.smartgwt.client.widgets.form.fields.FormItem#getIcons icons} for
     * this item.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showIcons showIcons Default value is true
     */
    public void setShowIcons(Boolean showIcons) {
        setAttribute("showIcons", showIcons);
    }

    /**
     * Set to false to suppress writing out any {@link com.smartgwt.client.widgets.form.fields.FormItem#getIcons icons} for
     * this item.
     *
     *
     * @return Boolean
     */
    public Boolean getShowIcons()  {
        return getAttributeAsBoolean("showIcons");
    }

    /**
     * If we're showing icons, should we change their image source to the appropriate <i>over</i>  source when the user rolls
     * over (or puts focus onto) them?  Can be overridden on a per  icon basis by the formItemIcon <code>showOver</code>
     * property.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showOverIcons showOverIcons Default value is null
     */
    public void setShowOverIcons(Boolean showOverIcons) {
        setAttribute("showOverIcons", showOverIcons);
    }

    /**
     * If we're showing icons, should we change their image source to the appropriate <i>over</i>  source when the user rolls
     * over (or puts focus onto) them?  Can be overridden on a per  icon basis by the formItemIcon <code>showOver</code>
     * property.
     *
     *
     * @return Boolean
     */
    public Boolean getShowOverIcons()  {
        return getAttributeAsBoolean("showOverIcons");
    }

    /**
     * Should we show a special 'picker' {@link com.smartgwt.client.widgets.form.fields.FormItemIcon icon} for this form item.
     * Picker icons are customizable via {@link com.smartgwt.client.widgets.form.fields.FormItem#getPickerIconProperties
     * pickerIconProperties}. By default they will be rendered inside the Form Item's "control box" area, and will call {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#showPicker FormItem.showPicker} when clicked.
     *
     * @param showPickerIcon showPickerIcon Default value is false
     */
    public void setShowPickerIcon(Boolean showPickerIcon) {
        setAttribute("showPickerIcon", showPickerIcon);
    }

    /**
     * Should we show a special 'picker' {@link com.smartgwt.client.widgets.form.fields.FormItemIcon icon} for this form item.
     * Picker icons are customizable via {@link com.smartgwt.client.widgets.form.fields.FormItem#getPickerIconProperties
     * pickerIconProperties}. By default they will be rendered inside the Form Item's "control box" area, and will call {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#showPicker FormItem.showPicker} when clicked.
     *
     *
     * @return Boolean
     */
    public Boolean getShowPickerIcon()  {
        return getAttributeAsBoolean("showPickerIcon");
    }

    /**
     * Should we show a title cell for this formItem? <p> Note: the default value of this attribute is overridden by some
     * subclasses.
     *
     * @param showTitle showTitle Default value is true
     */
    public void setShowTitle(Boolean showTitle) {
        setAttribute("showTitle", showTitle);
    }

    /**
     * Should we show a title cell for this formItem? <p> Note: the default value of this attribute is overridden by some
     * subclasses.
     *
     *
     * @return Boolean
     */
    public Boolean getShowTitle()  {
        return getAttributeAsBoolean("showTitle");
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons} is set, this property may be set to
     * show the valueIcon only and prevent the standard form item element or text from displaying
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showValueIconOnly showValueIconOnly Default value is null
     */
    public void setShowValueIconOnly(Boolean showValueIconOnly) {
        setAttribute("showValueIconOnly", showValueIconOnly);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons} is set, this property may be set to
     * show the valueIcon only and prevent the standard form item element or text from displaying
     *
     *
     * @return Boolean
     */
    public Boolean getShowValueIconOnly()  {
        return getAttributeAsBoolean("showValueIconOnly");
    }

    /**
     * Whether this item should always start a new row in the form layout.
     *
     * @param startRow startRow Default value is false
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public void setStartRow(Boolean startRow) {
        setAttribute("startRow", startRow);
    }

    /**
     * Whether this item should always start a new row in the form layout.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public Boolean getStartRow()  {
        return getAttributeAsBoolean("startRow");
    }

    /**
     * Indicates that if validation fails, the user should not be allowed to exit the field - focus will be forced back into
     * the field until the error is corrected. <p> This property defaults to {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getStopOnError stopOnError} if unset. <p> Enabling this property also
     * implies {@link com.smartgwt.client.widgets.form.fields.FormItem#getValidateOnExit validateOnExit} is automatically
     * enabled. If there are server-based validators on this item, setting this property also implies that {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getSynchronousValidation synchronousValidation} is forced on.
     *
     * @param stopOnError stopOnError Default value is null
     */
    public void setStopOnError(Boolean stopOnError) {
        setAttribute("stopOnError", stopOnError);
    }

    /**
     * Indicates that if validation fails, the user should not be allowed to exit the field - focus will be forced back into
     * the field until the error is corrected. <p> This property defaults to {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getStopOnError stopOnError} if unset. <p> Enabling this property also
     * implies {@link com.smartgwt.client.widgets.form.fields.FormItem#getValidateOnExit validateOnExit} is automatically
     * enabled. If there are server-based validators on this item, setting this property also implies that {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getSynchronousValidation synchronousValidation} is forced on.
     *
     *
     * @return Boolean
     */
    public Boolean getStopOnError()  {
        return getAttributeAsBoolean("stopOnError");
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons} is set, this property may be set to
     * prevent the value icons from showing up next to the form items value
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param suppressValueIcon suppressValueIcon Default value is null
     */
    public void setSuppressValueIcon(Boolean suppressValueIcon) {
        setAttribute("suppressValueIcon", suppressValueIcon);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons} is set, this property may be set to
     * prevent the value icons from showing up next to the form items value
     *
     *
     * @return Boolean
     */
    public Boolean getSuppressValueIcon()  {
        return getAttributeAsBoolean("suppressValueIcon");
    }

    /**
     * If enabled, whenever validation is triggered and a request to the server is required, user interactivity will be blocked
     * until the request returns. Can be set for the entire form or individual FormItems. <p> If false, the form will try to
     * avoid blocking user interaction until it is strictly required. That is until the user attempts to use a FormItem whose
     * state could be affected by a server request that has not yet returned.
     *
     * @param synchronousValidation synchronousValidation Default value is null
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
     *
     * @return Boolean
     */
    public Boolean getSynchronousValidation()  {
        return getAttributeAsBoolean("synchronousValidation");
    }

    /**
     * TabIndex for the form item within the form, which controls the order in which controls are visited when the user hits
     * the tab or shift-tab keys to navigate between items.  <P> tabIndex is automatically assigned as the order that items
     * appear in the {@link com.smartgwt.client.widgets.form.DynamicForm#getItems items} list. <P> To specify the tabindex of
     * an item within the page as a whole (not just this form), use {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getGlobalTabIndex globalTabIndex} instead.
     *
     * @param tabIndex tabIndex Default value is null
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public void setTabIndex(Integer tabIndex) {
        setAttribute("tabIndex", tabIndex);
    }

    /**
     * TabIndex for the form item within the form, which controls the order in which controls are visited when the user hits
     * the tab or shift-tab keys to navigate between items.  <P> tabIndex is automatically assigned as the order that items
     * appear in the {@link com.smartgwt.client.widgets.form.DynamicForm#getItems items} list. <P> To specify the tabindex of
     * an item within the page as a whole (not just this form), use {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getGlobalTabIndex globalTabIndex} instead.
     *
     *
     * @return Integer
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public Integer getTabIndex()  {
        return getAttributeAsInt("tabIndex");
    }

    /**
     * Alignment of the text / content within this form item. Note that {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getAlign align} may be used to control alignment of the entire form
     * item within its cell. May not apply to all form item types.
     *
     * @param textAlign textAlign Default value is Canvas.LEFT
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setTextAlign(Alignment textAlign) {
        setAttribute("textAlign", textAlign.getValue());
    }

    /**
     * Alignment of the text / content within this form item. Note that {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getAlign align} may be used to control alignment of the entire form
     * item within its cell. May not apply to all form item types.
     *
     *
     * @return Alignment
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Alignment getTextAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("textAlign"));
    }

    /**
     * Base CSS class name for a form item's text box element. <P> NOTE: See the {@link CompoundFormItem_skinning} discussion
     * for special skinning considerations.
     *
     * @param textBoxStyle textBoxStyle Default value is null
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
     * Time-format to apply to date type values within this formItem.  If specified, any dates displayed in this item will be
     * formatted as times using the appropriate format.<br> Has no effect if {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDateFormatter dateFormatter} is also set.<br> See also {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayFormat displayFormat} and {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getDisplayFormat displayFormat} for formatting values displayed in
     * TimeItems.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param timeFormatter timeFormatter Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setTimeFormatter(TimeFormatter timeFormatter) {
        setAttribute("timeFormatter", timeFormatter.getValue());
    }

    /**
     * Time-format to apply to date type values within this formItem.  If specified, any dates displayed in this item will be
     * formatted as times using the appropriate format.<br> Has no effect if {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDateFormatter dateFormatter} is also set.<br> See also {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayFormat displayFormat} and {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem#getDisplayFormat displayFormat} for formatting values displayed in
     * TimeItems.
     *
     *
     * @return TimeFormatter
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public TimeFormatter getTimeFormatter()  {
        return EnumUtil.getEnum(TimeFormatter.values(), getAttribute("timeFormatter"));
    }

    /**
     * User visible title for this form item.
     *
     * @param title title Default value is null
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public void setTitle(String title) {
        setAttribute("title", title);
    }

    /**
     * User visible title for this form item.
     *
     *
     * @return Return the title of this formItem
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public String getTitle()  {
        return getAttributeAsString("title");
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
     */
    public Alignment getTitleAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("titleAlign"));
    }

    /**
     * Number of columns that this item's title spans.   <P> This setting only applies for items that are showing a title and
     * whose {@link com.smartgwt.client.types.TitleOrientation} is either "left" or "right".
     *
     * @param titleColSpan titleColSpan Default value is 1
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     */
    public void setTitleColSpan(int titleColSpan) {
        setAttribute("titleColSpan", titleColSpan);
    }

    /**
     * Number of columns that this item's title spans.   <P> This setting only applies for items that are showing a title and
     * whose {@link com.smartgwt.client.types.TitleOrientation} is either "left" or "right".
     *
     *
     * @return int
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
     * @param titleOrientation titleOrientation Default value is Canvas.LEFT
     * @see com.smartgwt.client.widgets.form.DynamicForm#setTitleOrientation
     */
    public void setTitleOrientation(TitleOrientation titleOrientation) {
        setAttribute("titleOrientation", titleOrientation.getValue());
    }

    /**
     * On which side of this item should the title be placed.  {@link com.smartgwt.client.types.TitleOrientation} lists valid
     * options. <P> Note that titles on the left or right take up a cell in tabular {@link com.smartgwt.client.docs.FormLayout
     * form layouts}, but titles on top do not.
     *
     *
     * @return TitleOrientation
     * @see com.smartgwt.client.widgets.form.DynamicForm#getTitleOrientation
     */
    public TitleOrientation getTitleOrientation()  {
        return EnumUtil.getEnum(TitleOrientation.values(), getAttribute("titleOrientation"));
    }

    /**
     * Base CSS class name for a form item's title.
     *
     * @param titleStyle titleStyle Default value is "formTitle"
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setCellStyle
     */
    public void setTitleStyle(String titleStyle) {
        setAttribute("titleStyle", titleStyle);
    }

    /**
     * Base CSS class name for a form item's title.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getCellStyle
     */
    public String getTitleStyle()  {
        return getAttributeAsString("titleStyle");
    }

    /**
     * Vertical alignment of this item's title in its cell. Only applies when {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTitleOrientation titleOrientation} is <code>"left"</code> or
     * <code>"right"</code>.
     *
     * @param titleVAlign titleVAlign Default value is Canvas.CENTER
     */
    public void setTitleVAlign(VerticalAlignment titleVAlign) {
        setAttribute("titleVAlign", titleVAlign.getValue());
    }

    /**
     * Vertical alignment of this item's title in its cell. Only applies when {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTitleOrientation titleOrientation} is <code>"left"</code> or
     * <code>"right"</code>.
     *
     *
     * @return VerticalAlignment
     */
    public VerticalAlignment getTitleVAlign()  {
        return EnumUtil.getEnum(VerticalAlignment.values(), getAttribute("titleVAlign"));
    }

    /**
     * Top coordinate of this item in pixels.  Applies only when the containing DynamicForm sets
     * <code>itemLayout:"absolute"</code>.
     * For a form with {@link com.smartgwt.client.widgets.form.DynamicForm#getItemLayout itemLayout}:"absolute" only, set the top coordinate of this form item. <P> Causes the form to redraw.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param top top Default value is 0
     */
    public void setTop(int top) {
        setAttribute("top", top);
    }

    /**
     * Top coordinate of this item in pixels.  Applies only when the containing DynamicForm sets
     * <code>itemLayout:"absolute"</code>.
     *
     *
     * @return Returns the top coordinate of the form item in pixels. Note that this method is only  reliable after the item has been
     * drawn out.
     */
    public int getTop()  {
        return getAttributeAsInt("top");
    }

    /**
     * If true, form items will be validated when each item's "change" handler is fired as well as when the entire form is
     * submitted or validated. <p> Note that this property can also be set at the form level or on each validator; If true at
     * the form or field level, validators not explicitly set with <code>validateOnChange:false</code> will be fired on change
     * - displaying errors and rejecting the change on validation failure.
     *
     * @param validateOnChange validateOnChange Default value is false
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
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.form.DynamicForm#getValidateOnChange
     */
    public Boolean getValidateOnChange()  {
        return getAttributeAsBoolean("validateOnChange");
    }

    /**
     * If true, form items will be validated when each item's "editorExit" handler is fired as well as when the entire form is
     * submitted or validated. <p> Note that this property can also be set at the form level. If true at either level the
     * validator will be fired on editorExit.
     *
     * @param validateOnExit validateOnExit Default value is false
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
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.form.DynamicForm#getValidateOnExit
     */
    public Boolean getValidateOnExit()  {
        return getAttributeAsBoolean("validateOnExit");
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

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons} is specified, use this property to
     * specify a height for the value icon written out.
     *
     * @param valueIconHeight valueIconHeight Default value is null
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
     *
     * @return Integer
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getValueIconWidth
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getValueIconSize
     */
    public Integer getValueIconHeight()  {
        return getAttributeAsInt("valueIconHeight");
    }

    /**
     * If we're showing a value icon, this attribute governs the amount of space between the  icon and the left edge of the
     * form item cell
     *
     * @param valueIconLeftPadding valueIconLeftPadding Default value is 0
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setValueIcons
     */
    public void setValueIconLeftPadding(int valueIconLeftPadding) {
        setAttribute("valueIconLeftPadding", valueIconLeftPadding);
    }

    /**
     * If we're showing a value icon, this attribute governs the amount of space between the  icon and the left edge of the
     * form item cell
     *
     *
     * @return int
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons
     */
    public int getValueIconLeftPadding()  {
        return getAttributeAsInt("valueIconLeftPadding");
    }

    /**
     * If we're showing a value icon, this attribute governs the amount of space between the  icon and the label of the form
     * item
     *
     * @param valueIconRightPadding valueIconRightPadding Default value is 3
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setValueIcons
     */
    public void setValueIconRightPadding(int valueIconRightPadding) {
        setAttribute("valueIconRightPadding", valueIconRightPadding);
    }

    /**
     * If we're showing a value icon, this attribute governs the amount of space between the  icon and the label of the form
     * item
     *
     *
     * @return int
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
     * @param valueIconSize valueIconSize Default value is 16
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
     *
     * @return int
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
     * @param valueIconWidth valueIconWidth Default value is null
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
     *
     * @return Integer
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getValueIconHeight
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getValueIconSize
     */
    public Integer getValueIconWidth()  {
        return getAttributeAsInt("valueIconWidth");
    }

    /**
     * Whether this item is currently visible. <P> <code>visible</code> can only be set on creation.  After creation, use
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#show FormItem.show} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#hide FormItem.hide} to manipulate visibility.
     *
     * @param visible visible Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setVisible(Boolean visible) {
        setAttribute("visible", visible);
    }

    /**
     * Whether this item is currently visible. <P> <code>visible</code> can only be set on creation.  After creation, use
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#show FormItem.show} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#hide FormItem.hide} to manipulate visibility.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getVisible()  {
        return getAttributeAsBoolean("visible");
    }

    /**
     * Width of the FormItem.  Can be either a number indicating a fixed width in pixels, or "*" indicating the FormItem fills
     * the space allocated to it's column (or columns, for a {@link com.smartgwt.client.widgets.form.fields.FormItem#getColSpan
     * column spanning} item). <P> See the {@link com.smartgwt.client.docs.FormLayout} overview for details.
     *
     * @param width width Default value is "*"
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_form_spanning" target="examples">Spanning Example</a>
     */
    public void setWidth(int width) {
        setAttribute("width", width);
    }

    /**
     * Width of the FormItem.  Can be either a number indicating a fixed width in pixels, or "*" indicating the FormItem fills
     * the space allocated to it's column (or columns, for a {@link com.smartgwt.client.widgets.form.fields.FormItem#getColSpan
     * column spanning} item). <P> See the {@link com.smartgwt.client.docs.FormLayout} overview for details.
     *
     *
     * @return Output the width for this element. Note this returns the specified width for the   element, which may be "*" or a
     * percentage value. Use 'getVisibleWidth()' to get the  drawn width in pixels.
     * @see com.smartgwt.client.docs.FormLayout FormLayout overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_form_spanning" target="examples">Spanning Example</a>
     */
    public int getWidth()  {
        return getAttributeAsInt("width");
    }

    /**
     * If specified determines whether this items title should wrap. Overrides {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getWrapItemTitles wrapItemTitles} at the DynamicForm level.
     *
     * @param wrapTitle wrapTitle Default value is null
     */
    public void setWrapTitle(Boolean wrapTitle) {
        setAttribute("wrapTitle", wrapTitle);
    }

    /**
     * If specified determines whether this items title should wrap. Overrides {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getWrapItemTitles wrapItemTitles} at the DynamicForm level.
     *
     *
     * @return Boolean
     */
    public Boolean getWrapTitle()  {
        return getAttributeAsBoolean("wrapTitle");
    }

    // ********************* Methods ***********************
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
        var obj = null;
            obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            var selfJ = this;
            obj.blur = $entry(function(){
                var param = {"form" : arguments[0], "item" : arguments[1]};
                var event = @com.smartgwt.client.widgets.form.fields.events.BlurEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
   }-*/;
            
    /**
     * Takes focus from this form item's focusable element.
     */
    public native void blurItem() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.blurItem();
    }-*/;
            
    /**
     * When a dynamic form is editing an advanced criteria object via {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setValuesAsCriteria DynamicForm.setValuesAsCriteria}, this method is used
     * to to determine which sub-criteria apply to which form item(s). <P> This method will be called on each item, and passed
     * the sub-criterion of the AdvancedCriteria object. It should return true if the item can edit the criterion, otherwise
     * false. If it returns true, setValuesAsCriteria() will call  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setCriterion FormItem.setCriterion} to actually apply the criterion to
     * the form item, and {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria
     * DynamicForm.getValuesAsCriteria} can subsequently retrieve the edited criterion by calling {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCriterion FormItem.getCriterion}. <P> Default implementation will
     * return true if the criterion <code>fieldName</code> and <code>operator</code> match the fieldName and operator (or
     * default operator) for this item.
     * @param criterion sub-criterion from an AdvancedCriteria object
     *
     * @return return true if this item can edit the criterion in question.
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public native Boolean canEditCriterion(Criterion criterion) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var retVal =self.canEditCriterion(criterion.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
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
        var obj = null;
            obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            var selfJ = this;
            obj.change = $debox($entry(function(){
                var param = {"form" : arguments[0], "item" : arguments[1], "value" : arguments[2], "oldValue" : arguments[3]};
                var event = @com.smartgwt.client.widgets.form.fields.events.ChangeEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
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
        var obj = null;
            obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            var selfJ = this;
            obj.changed = $entry(function(){
                var param = {"form" : arguments[0], "item" : arguments[1], "value" : arguments[2]};
                var event = @com.smartgwt.client.widgets.form.fields.events.ChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
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
        var obj = null;
            obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            var selfJ = this;
            obj.click = $entry(function(){
                var param = {"form" : arguments[0], "item" : arguments[1]};
                var event = @com.smartgwt.client.widgets.form.fields.events.ClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
   }-*/;
            
    /**
     * Set this item to be disabled at runtime.
     */
    public native void disable() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.disable();
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
        var obj = null;
            obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            var selfJ = this;
            obj.doubleClick = $entry(function(){
                var param = {"form" : arguments[0], "item" : arguments[1]};
                var event = @com.smartgwt.client.widgets.form.fields.events.DoubleClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
   }-*/;
            
    /**
     * Set this item to be enabled at runtime.
     */
    public native void enable() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.enable();
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
        var obj = null;
            obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            var selfJ = this;
            obj.focus = $entry(function(){
                var param = {"form" : arguments[0], "item" : arguments[1]};
                var event = @com.smartgwt.client.widgets.form.fields.events.FocusEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
   }-*/;
            
    /**
     * Move the keyboard focus into this item's focusable element
     */
    public native void focusInItem() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.focusInItem();
    }-*/;
            
    /**
     * Override this method if you need to provide a specialized criterion from this formItem when creating an AdvancedCriteria
     * via {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria DynamicForm.getValuesAsCriteria}. <P> This
     * API is provided to allow you to specify a more complex criterion than the  "field-operator-value" criterions that are
     * built-in.  Note that the built-in behavior is generally quite flexible and powerful enough for most requirements.  An
     * example of a case where you might want to override this method is if you wanted to implement a date range  selection
     * (ie, date &gt; x AND date &lt; y) on a form that was combining its other criteria  fields with an "or" operator. <P>
     * Note that this method is part of the criteria editing subsystem: if overridden, it is likely that you will want to also
     * override {@link com.smartgwt.client.widgets.form.fields.FormItem#hasAdvancedCriteria FormItem.hasAdvancedCriteria} to
     * ensure this method is called by the form, and to support editing of existing advanced criteria you may also need to
     * override {@link com.smartgwt.client.widgets.form.fields.FormItem#canEditCriterion FormItem.canEditCriterion} and  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setCriterion FormItem.setCriterion}. <P> The default implementation
     * will return a criterion including the form item value, fieldName and specified {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOperator operator}, or a default operator derived from the form item
     * data type if no explicit operator is specified.
     *
     * @return criterion object based on this fields current edited value(s).
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public native Criterion getCriterion() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getCriterion();
        if(ret == null || ret === undefined) return null;
        return @com.smartgwt.client.data.Criterion::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * Override this method if you need to provide a specialized criterion from this formItem when creating an AdvancedCriteria
     * via {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria DynamicForm.getValuesAsCriteria}. <P> This
     * API is provided to allow you to specify a more complex criterion than the  "field-operator-value" criterions that are
     * built-in.  Note that the built-in behavior is generally quite flexible and powerful enough for most requirements.  An
     * example of a case where you might want to override this method is if you wanted to implement a date range  selection
     * (ie, date &gt; x AND date &lt; y) on a form that was combining its other criteria  fields with an "or" operator. <P>
     * Note that this method is part of the criteria editing subsystem: if overridden, it is likely that you will want to also
     * override {@link com.smartgwt.client.widgets.form.fields.FormItem#hasAdvancedCriteria FormItem.hasAdvancedCriteria} to
     * ensure this method is called by the form, and to support editing of existing advanced criteria you may also need to
     * override {@link com.smartgwt.client.widgets.form.fields.FormItem#canEditCriterion FormItem.canEditCriterion} and  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setCriterion FormItem.setCriterion}. <P> The default implementation
     * will return a criterion including the form item value, fieldName and specified {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOperator operator}, or a default operator derived from the form item
     * data type if no explicit operator is specified.
     * @param textMatchStyle If passed assume the textMatchStyle   will be used when performing a fetch operation with these criteria. This may
     * impact   the criterion's operator property.
     *
     * @return criterion object based on this fields current edited value(s).
     * @see com.smartgwt.client.docs.CriteriaEditing CriteriaEditing overview and related methods
     */
    public native Criterion getCriterion(TextMatchStyle textMatchStyle) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getCriterion(textMatchStyle.@com.smartgwt.client.types.TextMatchStyle::getValue()());
        if(ret == null || ret === undefined) return null;
        var retVal = @com.smartgwt.client.core.RefDataClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        if(retVal == null) {
            retVal = @com.smartgwt.client.data.Criterion::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        }
        return retVal;
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
     * Return the name for the this formItem.
     *
     * @return name for this form item
     * @see com.smartgwt.client.docs.Drawing Drawing overview and related methods
     */
    public native String getFieldName() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        return self.getFieldName();
    }-*/;
            
    /**
     * Given an {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getName name} return a pointer to the icon
     * definition
     * @param name specified {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getName name}
     *
     * @return form item icon matching the specified name
     */
    public native FormItemIcon getIcon(String name) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getIcon(name);
        if(ret == null || ret === undefined) return null;
        return @com.smartgwt.client.widgets.form.fields.FormItemIcon::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
            
    /**
     * Returns the drawn page-left coordinate of this form item in pixels.
     *
     * @return page-left coordinate in px
     * @see com.smartgwt.client.docs.Positioning Positioning overview and related methods
     */
    public native int getPageLeft() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        return self.getPageLeft();
    }-*/;
            
    /**
     * Returns the drawn page-top coordinate of this form item in pixels.
     *
     * @return page-top coordinate in px
     * @see com.smartgwt.client.docs.Positioning Positioning overview and related methods
     */
    public native int getPageTop() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        return self.getPageTop();
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
        var ret = self.getSelectedRecord();
        if(ret == null || ret === undefined) return null;
        var retVal = @com.smartgwt.client.core.RefDataClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        if(retVal == null) {
            retVal = @com.smartgwt.client.widgets.grid.ListGridRecord::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        }
        return retVal;
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
     * Does this form item produce an {@link com.smartgwt.client.data.AdvancedCriteria} sub criterion object? If this method
     * returns true, {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria DynamicForm.getValuesAsCriteria}
     * on the form containing this item will always return an {@link com.smartgwt.client.data.AdvancedCriteria} object, calling
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getCriterion FormItem.getCriterion} on each item to retrieve the
     * individual criteria. <P> Default implementation will return <code>true</code> if {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOperator operator} is explicitly specified.
     *
     * @return true if this item will return an AdvancedCriteria sub-criterion.
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
     * Hide this form item. <BR><BR> This will cause the form to redraw.  If this item had an item.showIf expression, it will
     * be destroyed.
     */
    public native void hide() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.hide();
    }-*/;
    /**
     * Add a iconClick handler.
     * <p>
     * StringMethod.      Default action to fire when the user clicks on a form item icon. May be overridden      by setting
     * <code>click</code> on the form item icon directly.
     *
     * @param handler the iconClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addIconClickHandler(com.smartgwt.client.widgets.form.fields.events.IconClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.IconClickEvent.getType()) == 0) setupIconClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.IconClickEvent.getType());
    }

    private native void setupIconClickEvent() /*-{
        var obj = null;
            obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            var selfJ = this;
            obj.iconClick = $entry(function(){
                var param = {"form" : arguments[0], "item" : arguments[1], "icon" : arguments[2]};
                var event = @com.smartgwt.client.widgets.form.fields.events.IconClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
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
        var obj = null;
            obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            var selfJ = this;
            obj.iconKeyPress = $entry(function(){
                var param = {"keyName" : arguments[0], "character" : arguments[1], "form" : arguments[2], "item" : arguments[3], "icon" : arguments[4]};
                var event = @com.smartgwt.client.widgets.form.fields.events.IconKeyPressEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
   }-*/;
            
    /**
     * Is this item disabled?
     *
     * @return disabledtrue if this item is be disabled
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getDisabled
     * @see com.smartgwt.client.docs.Enable Enable overview and related methods
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
     * Returns true if this item has been written out into the DOM.
     *
     * @return whether this item is drawn
     * @see com.smartgwt.client.docs.Drawing Drawing overview and related methods
     */
    public native Boolean isDrawn() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var retVal =self.isDrawn();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
    /**
     * Add a itemHover handler.
     * <p>
     * Optional stringMethod to fire when the user hovers over this item.  Return false to suppress default behavior of showing
     * a hover canvas containing the  HTML returned by <code>formItem.itemHoverHTML()</code> /  
     * <code>form.itemHoverHTML()</code>.
     *
     * @param handler the itemHover handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addItemHoverHandler(com.smartgwt.client.widgets.form.fields.events.ItemHoverHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.ItemHoverEvent.getType()) == 0) setupItemHoverEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.ItemHoverEvent.getType());
    }

    private native void setupItemHoverEvent() /*-{
        var obj = null;
            obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            var selfJ = this;
            obj.itemHover = $entry(function(){
                var param = {"item" : arguments[0], "form" : arguments[1]};
                var event = @com.smartgwt.client.widgets.form.fields.events.ItemHoverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
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
        var obj = null;
            obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            var selfJ = this;
            obj.keyDown = $debox($entry(function(){
                var param = {"item" : arguments[0], "form" : arguments[1], "keyName" : arguments[2]};
                var event = @com.smartgwt.client.widgets.form.fields.events.KeyDownEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
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
        var obj = null;
            obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            var selfJ = this;
            obj.keyPress = $debox($entry(function(){
                var param = {"item" : arguments[0], "form" : arguments[1], "keyName" : arguments[2], "characterValue" : arguments[3]};
                var event = @com.smartgwt.client.widgets.form.fields.events.KeyPressEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
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
        var obj = null;
            obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            var selfJ = this;
            obj.keyUp = $debox($entry(function(){
                var param = {"item" : arguments[0], "form" : arguments[1], "keyName" : arguments[2]};
                var event = @com.smartgwt.client.widgets.form.fields.events.KeyUpEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
   }-*/;
            
    /**
     * Update this form item to reflect a criterion object from within an AdvancedCriteria. Called by {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setValuesAsCriteria DynamicForm.setValuesAsCriteria} when {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#canEditCriterion FormItem.canEditCriterion} returns true for this item.
     * <P> Default implementation simply calls {@link com.smartgwt.client.widgets.form.fields.FormItem#setValue
     * FormItem.setValue} with the <code>value</code> of the criterion passed in
     * @param criterion criterion to edit
     */
    public native void setCriterion(Criterion criterion) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.setCriterion(criterion.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
            
    /**
     * If this field has a specified {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * optionDataSource}, should we perform a fetch against that dataSource to find the record that matches this field's value?
     * <P> If the value is non-null, this method is called when the item is first rendered  or whenever the value is changed
     * via a call to {@link com.smartgwt.client.widgets.form.fields.FormItem#setValue FormItem.setValue}. If it returns  true,
     * a fetch will be dispatched against the optionDataSource to get the record matching the value <P> When the fetch
     * completes, if a record was found that matches the data value (and the form item value has not subsequently changed
     * again),  the item will be re-rendered to reflect any changes to the display value, and the record matching the value
     * will be available via  getSelectedRecord. <P> Default behavior will return false if  fetchMissingValues is  set to
     * false. Otherwise it will return true if  alwaysFetchMissingValues is set to true, or if a {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField displayField} is specified for this item and the item 
     * value is not already present in the item's valueMap.
     * @param newValue The new data value of the item.
     *
     * @return should we fetch the record matching the new value from the   item's optionDataSource?
     */
    public native Boolean shouldFetchMissingValue(Object newValue) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var retVal =self.shouldFetchMissingValue(newValue);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Show this form item. <BR><BR> This will cause the form to redraw.  If this item had an item.showIf expression, it will
     * be destroyed.
     */
    public native void show() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.show();
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
        var obj = null;
            obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            var selfJ = this;
            obj.titleClick = $entry(function(){
                var param = {"form" : arguments[0], "item" : arguments[1]};
                var event = @com.smartgwt.client.widgets.form.fields.events.TitleClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
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
        var obj = null;
            obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            var selfJ = this;
            obj.titleDoubleClick = $entry(function(){
                var param = {"form" : arguments[0], "item" : arguments[1]};
                var event = @com.smartgwt.client.widgets.form.fields.events.TitleDoubleClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
   }-*/;
    /**
     * Add a titleHover handler.
     * <p>
     * Optional stringMethod to fire when the user hovers over this item's title.  Return false to suppress default behavior of
     * showing a hover canvas containing the  HTML returned by <code>formItem.titleHoverHTML()</code> /  
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
        var obj = null;
            obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            var selfJ = this;
            obj.titleHover = $entry(function(){
                var param = {"item" : arguments[0], "form" : arguments[1]};
                var event = @com.smartgwt.client.widgets.form.fields.events.TitleHoverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
   }-*/;
            
    /**
     * Update the visual state of a FormItem to reflect any changes in state or any changes in style settings (eg {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTextBoxStyle textBoxStyle}).  <P> Calls to
     * <code>updateState()</code> normally occur automatically as a consequence of focus changes, items becoming disabled, etc.
     *  This method is advanced and intended only for use in workarounds.
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
        var retVal =self.validate();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    // ********************* Static Methods ***********************
        
    // ***********************************************************        


    public FormItem(String name) {
        setName(name);
    }

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

    protected native boolean isCreated()/*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        return !!self.setValue;
    }-*/;

    public void setOptionDataSource(DataSource dataSource) {
        setAttribute("optionDataSource", dataSource.getOrCreateJsObj());
    }

    /**
     * Name for this form field. <br><br> The FormItem's name determines the name of the property it edits within the form.
     *
     * @param name name Default value is null
     */
    public void setName(String name) {
        assert name.indexOf(" ") == -1 : "Invalid FormItem name. Cannot use spaces in FormItem name.";
        setAttribute("name", name);
    }

    /**
     * Name for this form field. <br><br> The FormItem's name determines the name of the property it edits within the form.
     *
     *
     * @return String
     */
    public String getName()  {
        return getAttributeAsString("name");
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
     * {@link com.smartgwt.client.types.TitleOrientation} is either "left" or "right".
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
        if("100%".equals(width)) width = "*";
        assert width.indexOf("%") == -1 : "FormItems do not support percent sizing.";
        setAttribute("width", width);
    }

    public void setHeight(String height) {
        if("100%".equals(height)) height = "*";
        assert height.indexOf("%") == -1 : "FormItems do not support percent sizing.";
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
     * Name of the FormItem properties to use for editing. <P> The type of FormItem to use for
     * editing is normally derived automatically from {@link com.smartgwt.client.widgets.form.fields.FormItem#getType
     * type}, which is the data type of the field, by the rules explained {@link com.smartgwt.client.types.FormItemType here}.
     * <p><br>
     * <b>Note</b> : When you supply a custom FormItem via setEditorType(), you're really providing properties which are then used to create
     * multiple FormItems (eg, in grids, forms and trees) and there's an underlying limitation here where event handlers have to be written to
     * dynamically receive the actual FormItem rather than relying on "this" (because there's more than one "this").
     *
     * @param editorType editorType Default value is null
     */
    public void setEditorType(FormItem editorType) {
        //only set the editorType attribute if the passed editorType is a concrete subclass of FormItem
        if(!editorType.getClass().getName().equals(FormItem.class.getName())) {
            String fiEditorType = editorType.getAttribute("editorType");
            //fallback to type if editorType is not specified
            if(fiEditorType == null) fiEditorType = editorType.getType();
            if (fiEditorType != null) setAttribute("editorType", fiEditorType);
        }
        JavaScriptObject editorConfig = editorType.getConfig();
        setAttribute("editorProperties", editorConfig);
    }

    public native void setValue(int value) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if(self.setValue) {
            self.setValue(value);
        } else {
            self.value = value;
        }
    }-*/;

    public native void setValue(float value) /*-{
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
        if(value == null || value instanceof String) {
            setValue((String) value);
        } else if (value instanceof Integer) {
            setValue(((Integer) value).intValue());
        } else if (value instanceof Long) {
            //we officially do not support Long type, and GWT disallows passing long values to JSNI
            //casting to int, instead or erroring out, as it works in most cases
            setValue(((Long) value).intValue());
        } else if (value instanceof Double) {
            setValue(((Double) value).doubleValue());
        } else if(value instanceof Float) {
            setValue(((Float) value).floatValue());
        } else if (value instanceof Boolean) {
            setValue(((Boolean) value).booleanValue());
        } else if (value instanceof Date) {
            setValue((Date) value);
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

    /**
     * Returns the FormItem's config object suitable for use in API's that set the editorType
     *
     * @return the config object
     */
    public native JavaScriptObject getConfig() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var config = {};

        for(var k in self) {
            //skip properties of FormItem properties that should not be applied to the target's editorType
            if(k != '__ref' && k != 'type'  && k != 'editorType' && k != 'name') {
                config[k] = self[k];
            }
        }
        if(self.transformInput) {
            config['transformInput'] = self.transformInput;
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
            var errorsJ = @com.smartgwt.client.util.JSOHelper::convertToJavaStringArray(Lcom/google/gwt/core/client/JavaScriptObject;)(errors);
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
            if(val == null || @com.smartgwt.client.util.JSOHelper::isJavaString(Ljava/lang/Object;)(val) ) return val;
            if(@com.smartgwt.client.util.JSOHelper::isJavaInteger(Ljava/lang/Object;)(val)) return val.@java.lang.Integer::intValue()();
            if(@com.smartgwt.client.util.JSOHelper::isJavaNumber(Ljava/lang/Object;)(val)) return val.@java.lang.Number::floatValue()();
            if(@com.smartgwt.client.util.JSOHelper::isJavaDate(Ljava/lang/Object;)(val)) return @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(val);
            return val;
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
    * The FormItemHoverFormatter should return the HTML to display in a hover canvas when the user holds the mousepointer over the item's title.
    * Return null to suppress the hover canvas altogether.
    *
    * @param hoverFormatter the hover formatter
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
     * Return the value tracked by this form item. <P> Note that for FormItems that have a ValueMap or where a {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#formatValue formatter} has been defined, <code>getValue()</code>
     * returns the underlying value of the FormItem, not the displayed value.
     *
     * @return value of this element
     */
    public native Object getValue() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret;
        if(self.setValue) {
             ret = self.getValue();
        } else {
            ret = self.value;
        }
        return $wnd.SmartGWT.convertToJavaType(ret);
    }-*/;

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
     * Optional {@link FormItemValueFormatter}, if provided, is evaluated to get the
     * display value to show for this form items underlying data value. <P> This provides a way to perform a more complex data
     * to display value manipulation  than a simple {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueMap
     * valueMap}. Note that this method will not be applied to values displayed in a freeform text entry field (such as a
     * {@link com.smartgwt.client.widgets.form.fields.TextItem} or {@link
     * com.smartgwt.client.widgets.form.fields.TextAreaItem}), where an equivalent parser method would be required to convert a
     * user-entered value back into a data value.  Use {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setEditorValueFormatter(com.smartgwt.client.widgets.form.FormItemValueFormatter)} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setEditorValueParser(com.smartgwt.client.widgets.form.FormItemValueParser)} instead for these cases.
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
     * display value. <P> Note that this only applies to items which show a freeform entry area, such as a {@link
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
     * value for storage.  This method only applies to form items which show a freeform text entry area, such at the {@link
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
            if(val == null || @com.smartgwt.client.util.JSOHelper::isJavaString(Ljava/lang/Object;)(val) ) return val;
            if(@com.smartgwt.client.util.JSOHelper::isJavaInteger(Ljava/lang/Object;)(val)) return val.@java.lang.Integer::intValue()();
            if(@com.smartgwt.client.util.JSOHelper::isJavaNumber(Ljava/lang/Object;)(val)) return val.@java.lang.Number::floatValue()();
            if(@com.smartgwt.client.util.JSOHelper::isJavaDate(Ljava/lang/Object;)(val)) return @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(val);
            return val;
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
    

}





