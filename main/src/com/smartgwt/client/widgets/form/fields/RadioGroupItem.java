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
 * FormItem that shows a set of mutually exclusive options as a group of radio buttons.
 */
@BeanFactory.FrameworkClass
public class RadioGroupItem extends FormItem {

    public static RadioGroupItem getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof RadioGroupItem) {
            existingObj.setJsObj(jsObj);
            return (RadioGroupItem)existingObj;
        } else

        {
            return new RadioGroupItem(jsObj);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(RadioGroupItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.RadioGroupItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(RadioGroupItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.RadioGroupItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public static native void changePickerIconDefaults(FormItemIcon defaults) /*-{
        $wnd.isc.RadioGroupItem.changeDefaults("pickerIconDefaults", defaults.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public RadioGroupItem(){
        setAttribute("editorType", "RadioGroupItem");
    }

    public RadioGroupItem(JavaScriptObject jsObj){
        super(jsObj);
    }


    public RadioGroupItem(String name) {
        setName(name);
                setAttribute("editorType", "RadioGroupItem");
    }


    public RadioGroupItem(String name, String title) {
        setName(name);
		setTitle(title);
                setAttribute("editorType", "RadioGroupItem");
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Properties to apply to the customized {@link com.smartgwt.client.widgets.form.fields.CheckboxItem} used for
     * radioGroupItems  when {@link com.smartgwt.client.widgets.form.fields.RadioGroupItem#getUseNativeRadioItems
     * useNativeRadioItems} is false.
     *
     * @param checkboxItemProperties New checkboxItemProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.RadioGroupItem RadioGroupItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public RadioGroupItem setCheckboxItemProperties(CheckboxItem checkboxItemProperties) {
        if (checkboxItemProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(RadioGroupItem.class, "setCheckboxItemProperties", "CheckboxItem");
        }                                                                       
        checkboxItemProperties.setConfigOnly(true);
        return (RadioGroupItem)setAttribute("checkboxItemProperties", checkboxItemProperties == null ? null : checkboxItemProperties.getEditorTypeConfig());
    }

    /**
     * Properties to apply to the customized {@link com.smartgwt.client.widgets.form.fields.CheckboxItem} used for
     * radioGroupItems  when {@link com.smartgwt.client.widgets.form.fields.RadioGroupItem#getUseNativeRadioItems
     * useNativeRadioItems} is false.
     *
     * @return Current checkboxItemProperties value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public CheckboxItem getCheckboxItemProperties()  {
        return CheckboxItem.getOrCreateRef(getAttributeAsJavaScriptObject("checkboxItemProperties"));
    }
    
    

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @param editProxyConstructor New editProxyConstructor value. Default value is "RadioGroupItemEditProxy"
     * @return {@link com.smartgwt.client.widgets.form.fields.RadioGroupItem RadioGroupItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public RadioGroupItem setEditProxyConstructor(String editProxyConstructor) {
        return (RadioGroupItem)setAttribute("editProxyConstructor", editProxyConstructor);
    }

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @return Current editProxyConstructor value. Default value is "RadioGroupItemEditProxy"
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public String getEditProxyConstructor()  {
        return getAttributeAsString("editProxyConstructor");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.RadioGroupItem#getVertical vertical} is false, and this item has a
     * specified width, should options be spread out evenly to fill the specified width?
     *
     * @param fillHorizontalSpace New fillHorizontalSpace value. Default value is false
     * @return {@link com.smartgwt.client.widgets.form.fields.RadioGroupItem RadioGroupItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public RadioGroupItem setFillHorizontalSpace(boolean fillHorizontalSpace) {
        return (RadioGroupItem)setAttribute("fillHorizontalSpace", fillHorizontalSpace);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.RadioGroupItem#getVertical vertical} is false, and this item has a
     * specified width, should options be spread out evenly to fill the specified width?
     *
     * @return Current fillHorizontalSpace value. Default value is false
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public boolean getFillHorizontalSpace()  {
        Boolean result = getAttributeAsBoolean("fillHorizontalSpace", true);
        return result == null ? false : result;
    }
    
    

    /**
     * Base CSS class applied to the text for items within this radio group.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.form.fields.RadioGroupItem#getTextBoxStyle textBoxStyle}.
     *
     * @param textBoxStyle new <code>textBoxStyle</code>. Default value is "labelAnchor"
     * @return {@link com.smartgwt.client.widgets.form.fields.RadioGroupItem RadioGroupItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public RadioGroupItem setTextBoxStyle(String textBoxStyle) {
        return (RadioGroupItem)setAttribute("textBoxStyle", textBoxStyle);
    }

    /**
     * Base CSS class applied to the text for items within this radio group.
     *
     * @return Current textBoxStyle value. Default value is "labelAnchor"
     * @see com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getTextBoxStyle()  {
        return getAttributeAsString("textBoxStyle");
    }
    

    /**
     * When set to false, replaces each native radio element in the group with a  {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem} which can be customized via  {@link
     * com.smartgwt.client.widgets.form.fields.RadioGroupItem#getCheckboxItemProperties checkboxItemProperties}.
     *
     * @param useNativeRadioItems New useNativeRadioItems value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.RadioGroupItem RadioGroupItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public RadioGroupItem setUseNativeRadioItems(boolean useNativeRadioItems) {
        return (RadioGroupItem)setAttribute("useNativeRadioItems", useNativeRadioItems);
    }

    /**
     * When set to false, replaces each native radio element in the group with a  {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem} which can be customized via  {@link
     * com.smartgwt.client.widgets.form.fields.RadioGroupItem#getCheckboxItemProperties checkboxItemProperties}.
     *
     * @return Current useNativeRadioItems value. Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public boolean getUseNativeRadioItems()  {
        Boolean result = getAttributeAsBoolean("useNativeRadioItems", true);
        return result == null ? true : result;
    }
    

    /**
     * True == display options vertically, false == display in a single row
     *
     * @param vertical New vertical value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.RadioGroupItem RadioGroupItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public RadioGroupItem setVertical(Boolean vertical) {
        return (RadioGroupItem)setAttribute("vertical", vertical);
    }

    /**
     * True == display options vertically, false == display in a single row
     *
     * @return Current vertical value. Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getVertical()  {
        Boolean result = getAttributeAsBoolean("vertical", true);
        return result == null ? true : result;
    }
    

    /**
     * Should the text for items within this radio group wrap?
     *
     * @param wrap New wrap value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.RadioGroupItem RadioGroupItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public RadioGroupItem setWrap(Boolean wrap) {
        return (RadioGroupItem)setAttribute("wrap", wrap);
    }

    /**
     * Should the text for items within this radio group wrap?
     *
     * @return Current wrap value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getWrap()  {
        return getAttributeAsBoolean("wrap", true);
    }
    

    // ********************* Methods ***********************
	/**
     * Notification method called when {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPending showPending} is
     * enabled and this radio group should either clear or show its pending visual state. <p> The default behavior is that the
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getTitleStyle titleStyle} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCellStyle cellStyle} are updated to include/exclude the "Pending"
     * suffix. In addition, the label for the newly-selected option will have a different color. Returning <code>false</code>
     * will cancel this default behavior.
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
     * @param radioGroupItemProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(RadioGroupItem radioGroupItemProperties) /*-{
        if (radioGroupItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(RadioGroupItem.@java.lang.Object::getClass()(), "setDefaultProperties", radioGroupItemProperties.@java.lang.Object::getClass()());
        }
        radioGroupItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var properties = radioGroupItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::getConfig()();
        $wnd.isc.RadioGroupItem.addProperties(properties);
    }-*/;

    // ***********************************************************


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
        return ret == null ? null : ret.toString();
    }-*/;    
    
    /**
     * Disable or Enable a specific option within this radioGroup
     * @param value value of option to disable
     * @param disabled true to disable the option, false to enable it
     */
    public native void setValueDisabled(Object value, boolean disabled) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (self.setValueDisabled) {
            self.setValueDisabled(value, disabled);
        } else {
            // pre-init, update the disabledValues object.
            var stringVal = value + "";
            if (self.disabledValues == null) {
                self.disabledValues = $wnd.Array.create();
            }
            if (self.disabledValues.contains(stringVal)) {
                if (!disabled) self.disabledValues.remove(stringVal);
            } else {
                if (disabled) self.disabledValues.add(stringVal);
            }
        }
        
    }-*/;
    
   /**
    * The FormItemHoverFormatter should return the HTML to display in a hover canvas when the 
    * user holds the mousepointer over a particular value in this item.
    * Return null to suppress the hover canvas altogether.
    *
    * @param hoverFormatter the hover formatter
    */
    public native void setValueHoverFormatter(FormItemHoverFormatter hoverFormatter) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.valueHoverHTML = $debox($entry(function(item, form) {
            var formJ = @com.smartgwt.client.widgets.form.DynamicForm::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(form);
            var itemJ = @com.smartgwt.client.widgets.form.fields.FormItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
            return hoverFormatter.@com.smartgwt.client.widgets.form.FormItemHoverFormatter::getHoverHTML(Lcom/smartgwt/client/widgets/form/fields/FormItem;Lcom/smartgwt/client/widgets/form/DynamicForm;)(itemJ, formJ);
        }));
    }-*/;

    /**
     * Properties to apply to all generated items within this RadioGroup.
     * This allows you to customize the generated radio items for this item. Note that this
     * intended for simple customizations where there is no direct equivalent setting 
     * available on the RadioGroupItem itself - for example appearance settings such as 
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#setShowFocused(Boolean) showFocused}. Some customizations
     * (for example attempting to set the {@link com.smartgwt.client.widgets.form.fields.FormItem#setName(String) name} 
     * for the item) are invalid and unsupported.
     * 
     * <p><b>Note : </b> This is an advanced setting.</p>
     *
     * @param itemProperties
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setItemProperties(FormItem itemProperties)  throws IllegalStateException {
        if (itemProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), "setItemProperties", "FormItem");
        }                                                                       
        itemProperties.setConfigOnly(true);

        setAttribute("itemProperties", itemProperties == null ? null : itemProperties.getConfig());
    }


}
