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
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.browser.window.*;
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
import com.smartgwt.client.widgets.tour.*;
import com.smartgwt.client.widgets.notify.*;
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
import com.smartgwt.client.widgets.notify.*;
import com.smartgwt.client.widgets.drawing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gwt.event.shared.*;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.smartgwt.client.util.workflow.Process; // required to override java.lang.Process
import com.smartgwt.client.util.tour.*;


/**
 * FormItem that allows picking a value from a hierarchical data model.
 */
@BeanFactory.FrameworkClass
public class PickTreeItem extends CanvasItem {

    public static PickTreeItem getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof PickTreeItem) {
            existingObj.setJsObj(jsObj);
            return (PickTreeItem)existingObj;
        } else

        {
            return new PickTreeItem(jsObj);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(PickTreeItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.PickTreeItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(PickTreeItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.PickTreeItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public static native void changePickerIconDefaults(FormItemIcon defaults) /*-{
        $wnd.isc.PickTreeItem.changeDefaults("pickerIconDefaults", defaults.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public PickTreeItem(){
        setAttribute("editorType", "PickTreeItem");
    }

    public PickTreeItem(JavaScriptObject jsObj){
        super(jsObj);
    }


    public PickTreeItem(String name) {
        setName(name);
                setAttribute("editorType", "PickTreeItem");
    }


    public PickTreeItem(String name, String title) {
        setName(name);
		setTitle(title);
                setAttribute("editorType", "PickTreeItem");
    }


    // ********************* Properties / Attributes ***********************

    /**
     * The visible button created by a PickTreeItem is an {@link com.smartgwt.client.types.AutoChild} of type {@link
     * com.smartgwt.client.widgets.menu.TreeMenuButton} by default.
     * <p>
     * This component is an AutoChild named "button".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current button value. Default value is null
     */
    public Canvas getButton()  {
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("button"));
    }
    

    /**
     * If true, clicking or pressing Enter on a menu item that has a submenu will select that item (with standard behavior of
     * hiding the menus, calling click handlers, etc) instead of showing the submenu.
     *
     * @param canSelectParentItems New canSelectParentItems value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.PickTreeItem PickTreeItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_editing" target="examples">Editing Example</a>
     */
    public PickTreeItem setCanSelectParentItems(Boolean canSelectParentItems) {
        return (PickTreeItem)setAttribute("canSelectParentItems", canSelectParentItems);
    }

    /**
     * If true, clicking or pressing Enter on a menu item that has a submenu will select that item (with standard behavior of
     * hiding the menus, calling click handlers, etc) instead of showing the submenu.
     *
     * @return Current canSelectParentItems value. Default value is null
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_editing" target="examples">Editing Example</a>
     */
    public Boolean getCanSelectParentItems()  {
        return getAttributeAsBoolean("canSelectParentItems", true);
    }
    
    
    

    /**
     * Specifies an alternative field from which display values should be retrieved for this item. <p> If this item is not
     * databound ({@link com.smartgwt.client.widgets.form.fields.PickTreeItem#getDataSource dataSource} is unset), this is
     * implemented by picking up the value of the specified field from the {@link
     * com.smartgwt.client.widgets.form.fields.PickTreeItem#getValueTree valueTree}. <p> Otherwise this item will attempt to
     * map its underlying value to a display value by retrieving a record from the {@link
     * com.smartgwt.client.widgets.form.fields.PickTreeItem#getDataSource dataSource} where the  {@link
     * com.smartgwt.client.widgets.form.fields.PickTreeItem#getValueField valueField} matches this item's value, and displaying
     * the  <code>displayField</code> value from that record.
     *
     * @param displayField New displayField value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.PickTreeItem PickTreeItem} instance, for chaining setter calls
     */
    public PickTreeItem setDisplayField(String displayField) {
        return (PickTreeItem)setAttribute("displayField", displayField);
    }

    /**
     * Specifies an alternative field from which display values should be retrieved for this item. <p> If this item is not
     * databound ({@link com.smartgwt.client.widgets.form.fields.PickTreeItem#getDataSource dataSource} is unset), this is
     * implemented by picking up the value of the specified field from the {@link
     * com.smartgwt.client.widgets.form.fields.PickTreeItem#getValueTree valueTree}. <p> Otherwise this item will attempt to
     * map its underlying value to a display value by retrieving a record from the {@link
     * com.smartgwt.client.widgets.form.fields.PickTreeItem#getDataSource dataSource} where the  {@link
     * com.smartgwt.client.widgets.form.fields.PickTreeItem#getValueField valueField} matches this item's value, and displaying
     * the  <code>displayField</code> value from that record.
     *
     * @return Current displayField value. Default value is null
     */
    public String getDisplayField()  {
        return getAttributeAsString("displayField");
    }
    

    /**
     * Text to display when this form item has a null or undefined value. <P> If the formItem has a databound pickList, and its
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField FormItem.displayField} or {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueField FormItem.valueField} (if the former isn't set) has an
     * undefined emptyCellValue field, that field will automatically be set using the emptyDisplayValue property. <P> If the
     * emptyDisplayValue is null (the default) then this item will use the standard title of the tree menu button that is shown
     * when no values are selected.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.form.fields.PickTreeItem#getEmptyDisplayValue emptyDisplayValue}.
     *
     * @param emptyDisplayValue New emptyDisplayValue value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.PickTreeItem PickTreeItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public PickTreeItem setEmptyDisplayValue(String emptyDisplayValue) {
        return (PickTreeItem)setAttribute("emptyDisplayValue", emptyDisplayValue);
    }

    /**
     * Text to display when this form item has a null or undefined value. <P> If the formItem has a databound pickList, and its
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField FormItem.displayField} or {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueField FormItem.valueField} (if the former isn't set) has an
     * undefined emptyCellValue field, that field will automatically be set using the emptyDisplayValue property. <P> If the
     * emptyDisplayValue is null (the default) then this item will use the standard title of the tree menu button that is shown
     * when no values are selected.
     *
     * @return Current emptyDisplayValue value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getEmptyDisplayValue()  {
        return getAttributeAsString("emptyDisplayValue");
    }
    

    /**
     * This message will be displayed as a single, disabled option in any empty menu/submenu created from this item's data
     * tree.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param emptyMenuMessage New emptyMenuMessage value. Default value is "No items to display"
     * @return {@link com.smartgwt.client.widgets.form.fields.PickTreeItem PickTreeItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#picktree_combobox_category" target="examples">Picktree Example</a>
     */
    public PickTreeItem setEmptyMenuMessage(String emptyMenuMessage) {
        return (PickTreeItem)setAttribute("emptyMenuMessage", emptyMenuMessage);
    }

    /**
     * This message will be displayed as a single, disabled option in any empty menu/submenu created from this item's data
     * tree.
     *
     * @return Current emptyMenuMessage value. Default value is "No items to display"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#picktree_combobox_category" target="examples">Picktree Example</a>
     */
    public String getEmptyMenuMessage()  {
        return getAttributeAsString("emptyMenuMessage");
    }
    

    /**
     * If this is a databound item, should the load our set of possible options be loaded on demand (as submenus are
     * displayed), or upfront?
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param loadDataOnDemand New loadDataOnDemand value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.PickTreeItem PickTreeItem} instance, for chaining setter calls
     */
    public PickTreeItem setLoadDataOnDemand(Boolean loadDataOnDemand) {
        return (PickTreeItem)setAttribute("loadDataOnDemand", loadDataOnDemand);
    }

    /**
     * If this is a databound item, should the load our set of possible options be loaded on demand (as submenus are
     * displayed), or upfront?
     *
     * @return Current loadDataOnDemand value. Default value is null
     */
    public Boolean getLoadDataOnDemand()  {
        return getAttributeAsBoolean("loadDataOnDemand", true);
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
     * com.smartgwt.client.widgets.form.fields.FormItem#setValue FormItem.setValue()}, such as may happen when {@link
     * com.smartgwt.client.widgets.form.DynamicForm#editRecord DynamicForm.editRecord()} is called.  Retrieved values are
     * automatically cached by the FormItem. <P> Note that if a normal, static {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueMap valueMap} is <b>also</b> specified for the field (either
     * directly in the form item or as part of the field definition in the dataSource), it will be preferred to the data
     * derived from the optionDataSource for whatever mappings are present. <P> In a databound form, if {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField FormItem.displayField} is specified for a FormItem and 
     * <code>optionDataSource</code> is unset, <code>optionDataSource</code> will default to the form's current DataSource
     *
     * @param optionDataSource New optionDataSource value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.PickTreeItem PickTreeItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.FormItem#invalidateDisplayValueCache
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_controls_various" target="examples">List - Combo Box Example</a>
     */
    public PickTreeItem setOptionDataSource(DataSource optionDataSource) {
        return (PickTreeItem)setAttribute("optionDataSource", optionDataSource == null ? null : optionDataSource.getOrCreateJsObj());
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
     * com.smartgwt.client.widgets.form.fields.FormItem#setValue FormItem.setValue()}, such as may happen when {@link
     * com.smartgwt.client.widgets.form.DynamicForm#editRecord DynamicForm.editRecord()} is called.  Retrieved values are
     * automatically cached by the FormItem. <P> Note that if a normal, static {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueMap valueMap} is <b>also</b> specified for the field (either
     * directly in the form item or as part of the field definition in the dataSource), it will be preferred to the data
     * derived from the optionDataSource for whatever mappings are present. <P> In a databound form, if {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField FormItem.displayField} is specified for a FormItem and 
     * <code>optionDataSource</code> is unset, <code>optionDataSource</code> will default to the form's current DataSource
     *
     * @return Current optionDataSource value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#invalidateDisplayValueCache
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_controls_various" target="examples">List - Combo Box Example</a>
     */
    public DataSource getOptionDataSource()  {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("optionDataSource"));
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPending showPending} is <code>true</code>, the
     * {@link com.smartgwt.client.widgets.Button#getBaseStyle Button.baseStyle} of the {@link
     * com.smartgwt.client.widgets.form.fields.PickTreeItem#getButton button} when in the "Pending" visual state. <p> If unset,
     * then the <code>baseStyle</code> of the button is not changed.
     *
     * @param pendingButtonStyle New pendingButtonStyle value. Default value is "buttonPending"
     * @return {@link com.smartgwt.client.widgets.form.fields.PickTreeItem PickTreeItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public PickTreeItem setPendingButtonStyle(String pendingButtonStyle) {
        return (PickTreeItem)setAttribute("pendingButtonStyle", pendingButtonStyle);
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPending showPending} is <code>true</code>, the
     * {@link com.smartgwt.client.widgets.Button#getBaseStyle Button.baseStyle} of the {@link
     * com.smartgwt.client.widgets.form.fields.PickTreeItem#getButton button} when in the "Pending" visual state. <p> If unset,
     * then the <code>baseStyle</code> of the button is not changed.
     *
     * @return Current pendingButtonStyle value. Default value is "buttonPending"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getPendingButtonStyle()  {
        return getAttributeAsString("pendingButtonStyle");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit FormItem.canEdit} is set to <code>false</code>,
     * how should this item be displayed to the user? <P> For PickTreeItems, this setting affects only the item's title - the
     * button itself will  always appear disabled when canEdit is false, since buttons don't provide  <code>readOnly</code> or
     * <code>static</code> appearances.
     *
     * @param readOnlyDisplay New readOnlyDisplay value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.PickTreeItem PickTreeItem} instance, for chaining setter calls
     */
    public PickTreeItem setReadOnlyDisplay(ReadOnlyDisplayAppearance readOnlyDisplay) {
        return (PickTreeItem)setAttribute("readOnlyDisplay", readOnlyDisplay == null ? null : readOnlyDisplay.getValue());
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit FormItem.canEdit} is set to <code>false</code>,
     * how should this item be displayed to the user? <P> For PickTreeItems, this setting affects only the item's title - the
     * button itself will  always appear disabled when canEdit is false, since buttons don't provide  <code>readOnly</code> or
     * <code>static</code> appearances.
     *
     * @return Current readOnlyDisplay value. Default value is null
     */
    public ReadOnlyDisplayAppearance getReadOnlyDisplay()  {
        return EnumUtil.getEnum(ReadOnlyDisplayAppearance.values(), getAttribute("readOnlyDisplay"));
    }
    

    /**
     * Should this item's value be saved in the form's values and hence returned from {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValues form.getValues()}? <p> <code>shouldSaveValue:false</code> is used
     * to mark formItems which do not correspond to the underlying data model and should not save a value into the form's
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getValues values}.  Example includes visual separators, password
     * re-type fields, or checkboxes used to show/hide other form items. <p> A <code>shouldSaveValue:false</code> item should
     * be given a value either via {@link com.smartgwt.client.widgets.form.fields.FormItem#getDefaultValue
     * FormItem.defaultValue} or by calling {@link com.smartgwt.client.widgets.form.DynamicForm#setValue form.setValue(item,
     * value)} or  {@link com.smartgwt.client.widgets.form.fields.FormItem#setValue formItem.setValue(value)}.  Providing a
     * value via {@link com.smartgwt.client.widgets.form.DynamicForm#getValues form.values} or {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setValues form.setValues()}  will automatically switch the item to
     * <code>shouldSaveValue:true</code>. <P> Note that <ul> <li>if an item is shouldSaveValue true, but has no name, a warning
     * is logged, and      shouldSaveValue will be set to false. </li></ul>
     *
     * @param shouldSaveValue New shouldSaveValue value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.PickTreeItem PickTreeItem} instance, for chaining setter calls
     */
    public PickTreeItem setShouldSaveValue(Boolean shouldSaveValue) {
        return (PickTreeItem)setAttribute("shouldSaveValue", shouldSaveValue);
    }

    /**
     * Should this item's value be saved in the form's values and hence returned from {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValues form.getValues()}? <p> <code>shouldSaveValue:false</code> is used
     * to mark formItems which do not correspond to the underlying data model and should not save a value into the form's
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getValues values}.  Example includes visual separators, password
     * re-type fields, or checkboxes used to show/hide other form items. <p> A <code>shouldSaveValue:false</code> item should
     * be given a value either via {@link com.smartgwt.client.widgets.form.fields.FormItem#getDefaultValue
     * FormItem.defaultValue} or by calling {@link com.smartgwt.client.widgets.form.DynamicForm#setValue form.setValue(item,
     * value)} or  {@link com.smartgwt.client.widgets.form.fields.FormItem#setValue formItem.setValue(value)}.  Providing a
     * value via {@link com.smartgwt.client.widgets.form.DynamicForm#getValues form.values} or {@link
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
     * Which field in the tree-data should be returned as this item's value? If unspecified, the path will be used
     *
     * @param valueField New valueField value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.PickTreeItem PickTreeItem} instance, for chaining setter calls
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#picktree_combobox_category" target="examples">Picktree Example</a>
     */
    public PickTreeItem setValueField(String valueField) {
        return (PickTreeItem)setAttribute("valueField", valueField);
    }

    /**
     * Which field in the tree-data should be returned as this item's value? If unspecified, the path will be used
     *
     * @return Current valueField value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#picktree_combobox_category" target="examples">Picktree Example</a>
     */
    public String getValueField()  {
        return getAttributeAsString("valueField");
    }
    
    

    // ********************* Methods ***********************
	/**
     * Only applies to databound items (see {@link com.smartgwt.client.widgets.form.fields.PickTreeItem#getOptionDataSource
     * optionDataSource}).<br> Performs a fetch type operation on this item's DataSource to retrieve/refresh the tree of data
     * displayed as rows in this items menu.
     */
    public native void fetchData() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.fetchData();
    }-*/;

	/**
     * Notification method called when {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPending showPending} is
     * enabled and this <code>PickTreeItem</code> should either clear or show its pending visual state. <p> The default
     * behavior is that the {@link com.smartgwt.client.widgets.form.fields.FormItem#getTitleStyle titleStyle} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCellStyle cellStyle} are updated to include/exclude the "Pending"
     * suffix. In addition, when displayed in the pending state and a {@link
     * com.smartgwt.client.widgets.form.fields.PickTreeItem#getPendingButtonStyle pendingButtonStyle} is set, then the {@link
     * com.smartgwt.client.widgets.form.fields.PickTreeItem#getButton button}'s {@link
     * com.smartgwt.client.widgets.Button#getBaseStyle baseStyle} is set to <code>pendingButtonStyle</code>. Returning
     * <code>false</code> will cancel this default behavior.
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
     * @param pickTreeItemProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(PickTreeItem pickTreeItemProperties) /*-{
        if (pickTreeItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(PickTreeItem.@java.lang.Object::getClass()(), "setDefaultProperties", pickTreeItemProperties.@java.lang.Object::getClass()());
        }
        pickTreeItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var properties = pickTreeItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::getConfig()();
        $wnd.isc.PickTreeItem.addProperties(properties);
    }-*/;

    // ***********************************************************


    /**
     * If specified, the tree of possible options will be derived from the dataSource as a ResultTree, rather than using
     * this.valueTree.  Options can be loaded on demand or up front according to {@link
     * com.smartgwt.client.widgets.form.fields.PickTreeItem#getLoadDataOnDemand loadDataOnDemand}. <p><b>Note : </b>
     * This is an advanced setting</p>
     *
     * @param dataSource dataSource Default value is null
     */
    public void setDataSource(DataSource dataSource) {
    	if(dataSource==null) {
    		throw new IllegalArgumentException("Invalid call to setDataSource() passing null.  If you're having trouble with loading DataSources, please see the following FAQ: http://forums.smartclient.com/showthread.php?t=8159#aDSLoad");
    	}
        setAttribute("dataSource", dataSource.getOrCreateJsObj());
    }

    /**
     * The DataSource that this component should bind to for default fields and for performing {@link com.smartgwt.client.data.DSRequest}. <P> Can be specified as either a DataSource instance or the String ID of a DataSource.
     *
     * @return DataSource
     */
    public DataSource getDataSource() {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("dataSource"));
    }
    
    /**
     * A {@link com.smartgwt.client.widgets.tree.Tree} of options from which the user can select.
     *
     * @param valueTree valueTree Default value is null
     */
    public void setValueTree(Tree valueTree) {
        setAttribute("valueTree", valueTree);
    }

    /**
     * For a <code>PickTreeItem</code> that uses a DataSource, these properties will be passed
     * to the automatically-created ResultTree.  This can be used for various customizations
     * such as modifying the automatically-chosen 
     * {@link com.smartgwt.client.widgets.tree.Tree#getParentIdField parentIdField}.
     *
     * @param dataProperties dataProperties Default value is null
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public void setDataProperties(Tree dataProperties) {
        if (dataProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), "setDataProperties", "Tree");
        }                                                                       
        dataProperties.setConfigOnly(true);

        JavaScriptObject config = dataProperties.getConfig();
        setAttribute("dataProperties", JSOHelper.cleanProperties(config, true));
    }

}
