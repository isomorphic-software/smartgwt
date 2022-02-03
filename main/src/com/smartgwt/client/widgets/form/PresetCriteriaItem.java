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
 
package com.smartgwt.client.widgets.form;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.Record;
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

import com.google.gwt.event.shared.*;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.smartgwt.client.util.workflow.Process; // required to override java.lang.Process


/**
 * A FormItem for use with the {@link com.smartgwt.client.widgets.form.FilterBuilder}, allows the user to pick from a set
 * of  pre-configured search criteria such as specific ranges in numeric or date data, and provide  user friendly titles
 * for such criteria, such as "within the next two weeks" or  "High (0.75 - 0.99)".
 */
@BeanFactory.FrameworkClass
public class PresetCriteriaItem extends SelectItem {

    public static PresetCriteriaItem getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof PresetCriteriaItem) {
            existingObj.setJsObj(jsObj);
            return (PresetCriteriaItem)existingObj;
        } else

        {
            return new PresetCriteriaItem(jsObj);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(PresetCriteriaItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.PresetCriteriaItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(PresetCriteriaItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.PresetCriteriaItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public static native void changePickerIconDefaults(FormItemIcon defaults) /*-{
        $wnd.isc.PresetCriteriaItem.changeDefaults("pickerIconDefaults", defaults.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public PresetCriteriaItem(){
        setAttribute("editorType", "PresetCriteriaItem");
    }

    public PresetCriteriaItem(JavaScriptObject jsObj){
        super(jsObj);
    }


    public PresetCriteriaItem(String name) {
        setName(name);
                setAttribute("editorType", "PresetCriteriaItem");
    }


    // ********************* Properties / Attributes ***********************

    /**
     * The title to show for the {@link com.smartgwt.client.widgets.form.PresetCriteriaItem#getShowCustomOption custom option}.
     *
     * @param customOptionTitle New customOptionTitle value. Default value is "Custom..."
     * @return {@link com.smartgwt.client.widgets.form.PresetCriteriaItem PresetCriteriaItem} instance, for chaining setter calls
     */
    public PresetCriteriaItem setCustomOptionTitle(String customOptionTitle) {
        return (PresetCriteriaItem)setAttribute("customOptionTitle", customOptionTitle);
    }

    /**
     * The title to show for the {@link com.smartgwt.client.widgets.form.PresetCriteriaItem#getShowCustomOption custom option}.
     *
     * @return Current customOptionTitle value. Default value is "Custom..."
     */
    public String getCustomOptionTitle()  {
        return getAttributeAsString("customOptionTitle");
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
     * @return {@link com.smartgwt.client.widgets.form.PresetCriteriaItem PresetCriteriaItem} instance, for chaining setter calls
     */
    public PresetCriteriaItem setShouldSaveValue(Boolean shouldSaveValue) {
        return (PresetCriteriaItem)setAttribute("shouldSaveValue", shouldSaveValue);
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
     * If set, an additional option will be shown with the title {@link
     * com.smartgwt.client.widgets.form.PresetCriteriaItem#getCustomOptionTitle customOptionTitle},  which will cause {@link
     * com.smartgwt.client.widgets.form.PresetCriteriaItem#getCustomCriteria getCustomCriteria()} to be called.
     *
     * @param showCustomOption New showCustomOption value. Default value is false
     * @return {@link com.smartgwt.client.widgets.form.PresetCriteriaItem PresetCriteriaItem} instance, for chaining setter calls
     */
    public PresetCriteriaItem setShowCustomOption(boolean showCustomOption) {
        return (PresetCriteriaItem)setAttribute("showCustomOption", showCustomOption);
    }

    /**
     * If set, an additional option will be shown with the title {@link
     * com.smartgwt.client.widgets.form.PresetCriteriaItem#getCustomOptionTitle customOptionTitle},  which will cause {@link
     * com.smartgwt.client.widgets.form.PresetCriteriaItem#getCustomCriteria getCustomCriteria()} to be called.
     *
     * @return Current showCustomOption value. Default value is false
     */
    public boolean getShowCustomOption()  {
        Boolean result = getAttributeAsBoolean("showCustomOption", true);
        return result == null ? false : result;
    }
    
    

    // ********************* Methods ***********************
	/**
     * This method is called when {@link com.smartgwt.client.widgets.form.PresetCriteriaItem#getShowCustomOption
     * showCustomOption} is true and the user selects the  custom option.  Implement this method by allowing the user to enter
     * custom criteria, for example, by opening a modal dialog.  Once the user has input custom criteria, fire the callback
     * method with the resulting criteria.
     * @param callback callback to fire when custom criteria has been gathered.              Expects parameters "criteria,title".  The "title"
     * will be displayed as the               currently selected value when custom criteria have been chosen.
     * See {@link com.smartgwt.client.docs.Callback Callback}
     * @see com.smartgwt.client.docs.Callback Callback
     */
    public native void getCustomCriteria(String callback) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.getCustomCriteria(callback);
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
     * @param presetCriteriaItemProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(PresetCriteriaItem presetCriteriaItemProperties) /*-{
        if (presetCriteriaItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(PresetCriteriaItem.@java.lang.Object::getClass()(), "setDefaultProperties", presetCriteriaItemProperties.@java.lang.Object::getClass()());
        }
        presetCriteriaItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var properties = presetCriteriaItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::getConfig()();
        $wnd.isc.PresetCriteriaItem.addProperties(properties);
    }-*/;

    // ***********************************************************



    public void setOptions(LinkedHashMap<String, Object> options) {
        setAttribute("options", options);
    }
    @SuppressWarnings("unchecked")
	public LinkedHashMap<String,Object> getOptions()  {
        LinkedHashMap<String, Object> retVal = (LinkedHashMap<String, Object>) getAttributeAsMap("options");
        return retVal;
    }
    

}
