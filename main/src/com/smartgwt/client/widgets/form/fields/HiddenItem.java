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
 * HiddenItems track a value but have no visible appearance and do not take up space in the form layout. <P> When using
 * Smart GWT databinding it is usually not necessary to use a HiddenItem, since the DynamicForm will track values for which
 * no actual form control exists, and will submit these 'extra' values when {@link
 * com.smartgwt.client.widgets.form.DynamicForm#saveData DynamicForm.saveData()} is called.  HiddenItems only apply to
 * forms that are submitted like ordinary HTML forms, via the {@link
 * com.smartgwt.client.widgets.form.DynamicForm#submitForm DynamicForm.submitForm()} method.
 */
@BeanFactory.FrameworkClass
public class HiddenItem extends FormItem {

    public static HiddenItem getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof HiddenItem) {
            existingObj.setJsObj(jsObj);
            return (HiddenItem)existingObj;
        } else

        {
            return new HiddenItem(jsObj);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(HiddenItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.HiddenItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(HiddenItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.HiddenItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public static native void changePickerIconDefaults(FormItemIcon defaults) /*-{
        $wnd.isc.HiddenItem.changeDefaults("pickerIconDefaults", defaults.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public HiddenItem(){
        setAttribute("editorType", "HiddenItem");
    }

    public HiddenItem(JavaScriptObject jsObj){
        super(jsObj);
    }


    public HiddenItem(String name) {
        setName(name);
                setAttribute("editorType", "HiddenItem");
    }


    // ********************* Properties / Attributes ***********************

    /**
     * If this form item has a specified {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * FormItem.optionDataSource} and  {@link com.smartgwt.client.widgets.form.fields.FormItem#getFetchMissingValues
     * FormItem.fetchMissingValues} is true, when the item value changes, a fetch will be performed against the
     * optionDataSource to retrieve the related record  if {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField FormItem.displayField} is specified and the new item
     * value is not present in any valueMap explicitly specified on the item. <P> Setting this property to true means that a
     * fetch will occur against the optionDataSource  to retrieve the related record even if {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField FormItem.displayField} is unset, or the item has a
     * valueMap which explicitly contains this field's value. <P> An example of a use case where this might be set would be if
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#formatValue FormItem.formatValue()} or {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#formatEditorValue FormItem.formatEditorValue()} were written to display
     * properties from the {@link com.smartgwt.client.widgets.form.fields.FormItem#getSelectedRecord selected record}. <P> Note
     * - for efficiency we cache the associated record once a fetch has been performed, meaning if the value changes, then
     * reverts to a previously seen value, we do not kick off an additional fetch even if this property is true. If necessary
     * this cache may be explicitly invalidated via a call to {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#invalidateDisplayValueCache FormItem.invalidateDisplayValueCache()} <P>
     * Note: For hiddenItem {@link com.smartgwt.client.widgets.form.fields.HiddenItem#getFetchMissingValues fetchMissingValues}
     * is defaulted to <code>false</code> so developers wishing to get access to the record related to the current hiddenItem
     * value would need to explicitly set both that property, and this one to true.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param alwaysFetchMissingValues New alwaysFetchMissingValues value. Default value is false
     * @return {@link com.smartgwt.client.widgets.form.fields.HiddenItem HiddenItem} instance, for chaining setter calls
     */
    public HiddenItem setAlwaysFetchMissingValues(Boolean alwaysFetchMissingValues) {
        return (HiddenItem)setAttribute("alwaysFetchMissingValues", alwaysFetchMissingValues);
    }

    /**
     * If this form item has a specified {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * FormItem.optionDataSource} and  {@link com.smartgwt.client.widgets.form.fields.FormItem#getFetchMissingValues
     * FormItem.fetchMissingValues} is true, when the item value changes, a fetch will be performed against the
     * optionDataSource to retrieve the related record  if {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField FormItem.displayField} is specified and the new item
     * value is not present in any valueMap explicitly specified on the item. <P> Setting this property to true means that a
     * fetch will occur against the optionDataSource  to retrieve the related record even if {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField FormItem.displayField} is unset, or the item has a
     * valueMap which explicitly contains this field's value. <P> An example of a use case where this might be set would be if
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#formatValue FormItem.formatValue()} or {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#formatEditorValue FormItem.formatEditorValue()} were written to display
     * properties from the {@link com.smartgwt.client.widgets.form.fields.FormItem#getSelectedRecord selected record}. <P> Note
     * - for efficiency we cache the associated record once a fetch has been performed, meaning if the value changes, then
     * reverts to a previously seen value, we do not kick off an additional fetch even if this property is true. If necessary
     * this cache may be explicitly invalidated via a call to {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#invalidateDisplayValueCache FormItem.invalidateDisplayValueCache()} <P>
     * Note: For hiddenItem {@link com.smartgwt.client.widgets.form.fields.HiddenItem#getFetchMissingValues fetchMissingValues}
     * is defaulted to <code>false</code> so developers wishing to get access to the record related to the current hiddenItem
     * value would need to explicitly set both that property, and this one to true.
     *
     * @return Current alwaysFetchMissingValues value. Default value is false
     */
    public Boolean getAlwaysFetchMissingValues()  {
        Boolean result = getAttributeAsBoolean("alwaysFetchMissingValues", true);
        return result == null ? false : result;
    }
    

    /**
     * hidden fields don't take up any columns
     *
     * @param colSpan New colSpan value. Default value is 0
     * @return {@link com.smartgwt.client.widgets.form.fields.HiddenItem HiddenItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public HiddenItem setColSpan(int colSpan) {
        return (HiddenItem)setAttribute("colSpan", colSpan);
    }

    /**
     * hidden fields don't take up any columns
     *
     * <p><b>Note :</b> This method will return -1 if the underlying SmartClient JavaScript
     * attribute value cannot be expressed as a(n) int.  In that case, other
     * getters,  similarly-named but ending in <code>AsString</code>, <code>AsCanvas</code>,
     * etc., may be provided.
     *
     * @return Current colSpan value. Default value is 0
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getColSpan()  {
        if (!(getAttributeAsObject("colSpan") instanceof Integer)) { return -1; }
        return getAttributeAsInt("colSpan");
    }

    /**
     * hidden fields don't take up any columns
     *
     * @param colSpan New colSpan value. Default value is 0
     * @return {@link com.smartgwt.client.widgets.form.fields.HiddenItem HiddenItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public HiddenItem setColSpan(String colSpan) {
        return (HiddenItem)setAttribute("colSpan", colSpan);
    }

    /**
     * hidden fields don't take up any columns
     *
     * @return Current colSpan value. Default value is 0
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getColSpanAsString()  {
        return getAttributeAsString("colSpan");
    }
    

    /**
     * If this form item has a specified {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * FormItem.optionDataSource}, should the item ever perform a fetch against this dataSource to retrieve the related record.
     * <P> This is disabled by default for hiddenItems as there is typically no need to perform a fetch and retrieve a
     * display-field value to show the user for a  hidden item. This does mean that if a developer needs access to the related
     * record for a hidden-item's value, they will need to enable both this setting and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getAlwaysFetchMissingValues FormItem.alwaysFetchMissingValues}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param fetchMissingValues New fetchMissingValues value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.HiddenItem HiddenItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setOptionDataSource
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getSelectedRecord
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setFilterLocally
     */
    public HiddenItem setFetchMissingValues(Boolean fetchMissingValues) {
        return (HiddenItem)setAttribute("fetchMissingValues", fetchMissingValues);
    }

    /**
     * If this form item has a specified {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * FormItem.optionDataSource}, should the item ever perform a fetch against this dataSource to retrieve the related record.
     * <P> This is disabled by default for hiddenItems as there is typically no need to perform a fetch and retrieve a
     * display-field value to show the user for a  hidden item. This does mean that if a developer needs access to the related
     * record for a hidden-item's value, they will need to enable both this setting and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getAlwaysFetchMissingValues FormItem.alwaysFetchMissingValues}.
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
     * hidden fields don't take up any rows
     *
     * @param rowSpan New rowSpan value. Default value is 0
     * @return {@link com.smartgwt.client.widgets.form.fields.HiddenItem HiddenItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public HiddenItem setRowSpan(int rowSpan) {
        return (HiddenItem)setAttribute("rowSpan", rowSpan);
    }

    /**
     * hidden fields don't take up any rows
     *
     * @return Current rowSpan value. Default value is 0
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getRowSpan()  {
        return getAttributeAsInt("rowSpan");
    }
    

    /**
     * we never show a separate title cell for hidden fields
     *
     * @param showTitle New showTitle value. Default value is false
     * @return {@link com.smartgwt.client.widgets.form.fields.HiddenItem HiddenItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public HiddenItem setShowTitle(Boolean showTitle) {
        return (HiddenItem)setAttribute("showTitle", showTitle);
    }

    /**
     * we never show a separate title cell for hidden fields
     *
     * @return Current showTitle value. Default value is false
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowTitle()  {
        Boolean result = getAttributeAsBoolean("showTitle", true);
        return result == null ? false : result;
    }
    

    // ********************* Methods ***********************

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
     * @param hiddenItemProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(HiddenItem hiddenItemProperties) /*-{
        if (hiddenItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(HiddenItem.@java.lang.Object::getClass()(), "setDefaultProperties", hiddenItemProperties.@java.lang.Object::getClass()());
        }
        hiddenItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var properties = hiddenItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::getConfig()();
        $wnd.isc.HiddenItem.addProperties(properties);
    }-*/;

    // ***********************************************************

}
