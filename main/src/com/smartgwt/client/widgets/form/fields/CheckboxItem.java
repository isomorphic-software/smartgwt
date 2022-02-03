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
 * Checkbox form item, implemented with customizable checkbox images.
 */
@BeanFactory.FrameworkClass
public class CheckboxItem extends FormItem {

    public static CheckboxItem getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof CheckboxItem) {
            existingObj.setJsObj(jsObj);
            return (CheckboxItem)existingObj;
        } else

        {
            return new CheckboxItem(jsObj);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(CheckboxItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.CheckboxItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(CheckboxItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.CheckboxItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public static native void changePickerIconDefaults(FormItemIcon defaults) /*-{
        $wnd.isc.CheckboxItem.changeDefaults("pickerIconDefaults", defaults.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public CheckboxItem(){
        setAttribute("editorType", "CheckboxItem");
    }

    public CheckboxItem(JavaScriptObject jsObj){
        super(jsObj);
    }


    public CheckboxItem(String name) {
        setName(name);
                setAttribute("editorType", "CheckboxItem");
    }


    public CheckboxItem(String name, String title) {
        setName(name);
		setTitle(title);
                setAttribute("editorType", "CheckboxItem");
    }


    // ********************* Properties / Attributes ***********************

    /**
     * By default checkboxes allow the user to toggle between true and false values only. Setting this property to true will
     * allow the user to toggle between three values -  <code>true</code>, <code>false</code> and unset.
     *
     * @param allowEmptyValue New allowEmptyValue value. Default value is false
     * @return {@link com.smartgwt.client.widgets.form.fields.CheckboxItem CheckboxItem} instance, for chaining setter calls
     */
    public CheckboxItem setAllowEmptyValue(Boolean allowEmptyValue) {
        return (CheckboxItem)setAttribute("allowEmptyValue", allowEmptyValue);
    }

    /**
     * By default checkboxes allow the user to toggle between true and false values only. Setting this property to true will
     * allow the user to toggle between three values -  <code>true</code>, <code>false</code> and unset.
     *
     * @return Current allowEmptyValue value. Default value is false
     */
    public Boolean getAllowEmptyValue()  {
        Boolean result = getAttributeAsBoolean("allowEmptyValue", true);
        return result == null ? false : result;
    }
    

    /**
     * An optional base CSS style to apply to the checkbox image. If supplied, the base style is suffixed with "True", "False",
     * "Partial", or "Unset" if the checkbox is selected, unselected, partially selected, or unset. The style is then suffixed
     * with the state of the value icon ("", "Over", "Down", "Disabled").
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param booleanBaseStyle New booleanBaseStyle value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.CheckboxItem CheckboxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.CheckboxItem#setPrintBooleanBaseStyle
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * 
     */
    public CheckboxItem setBooleanBaseStyle(String booleanBaseStyle) {
        return (CheckboxItem)setAttribute("booleanBaseStyle", booleanBaseStyle);
    }

    /**
     * An optional base CSS style to apply to the checkbox image. If supplied, the base style is suffixed with "True", "False",
     * "Partial", or "Unset" if the checkbox is selected, unselected, partially selected, or unset. The style is then suffixed
     * with the state of the value icon ("", "Over", "Down", "Disabled").
     *
     * @return Current booleanBaseStyle value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.CheckboxItem#getPrintBooleanBaseStyle
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * 
     */
    public String getBooleanBaseStyle()  {
        return getAttributeAsString("booleanBaseStyle");
    }
    

    /**
     * The description shown in a hover when {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowOldValueInHover
     * FormItem.showOldValueInHover} is enabled and a value represents the checked state.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param checkedDescription New checkedDescription value. Default value is "checked"
     * @return {@link com.smartgwt.client.widgets.form.fields.CheckboxItem CheckboxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public CheckboxItem setCheckedDescription(String checkedDescription) {
        return (CheckboxItem)setAttribute("checkedDescription", checkedDescription);
    }

    /**
     * The description shown in a hover when {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowOldValueInHover
     * FormItem.showOldValueInHover} is enabled and a value represents the checked state.
     *
     * @return Current checkedDescription value. Default value is "checked"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getCheckedDescription()  {
        return getAttributeAsString("checkedDescription");
    }
    

    /**
     * URL for the image to display when this checkbox is selected, or checked. <P> This image is implemented using the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons subsystem}, and may be modified via the
     * standard valueIcons properties such as {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getValueIconWidth
     * valueIconWidth} <P> Note that this is the base image name - if {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getShowValueIconOver showValueIconOver} et al are set, the state
     * (<code>"Over"</code>, <code>"Down"</code> and <code>"Disabled"</code>) will be added to this name as the user interacts
     * with the checkbox, as well as the image extension <P> The special value "blank" means that no image will be shown. <P>
     * {@link com.smartgwt.client.docs.Skinning Spriting} can be used for this image, by setting this property to a {@link
     * com.smartgwt.client.docs.SCSpriteConfig} formatted string. Alternatively developers can omit this property and instead
     * use CSS directly in the  {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getBooleanBaseStyle
     * booleanBaseStyle} property to provide a "checked" appearance.
     *
     * @param checkedImage New checkedImage value. Default value is "[SKIN]/DynamicForm/checked.gif"
     * @return {@link com.smartgwt.client.widgets.form.fields.CheckboxItem CheckboxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.CheckboxItem#setPrintCheckedImage
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public CheckboxItem setCheckedImage(String checkedImage) {
        return (CheckboxItem)setAttribute("checkedImage", checkedImage);
    }

    /**
     * URL for the image to display when this checkbox is selected, or checked. <P> This image is implemented using the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons subsystem}, and may be modified via the
     * standard valueIcons properties such as {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getValueIconWidth
     * valueIconWidth} <P> Note that this is the base image name - if {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getShowValueIconOver showValueIconOver} et al are set, the state
     * (<code>"Over"</code>, <code>"Down"</code> and <code>"Disabled"</code>) will be added to this name as the user interacts
     * with the checkbox, as well as the image extension <P> The special value "blank" means that no image will be shown. <P>
     * {@link com.smartgwt.client.docs.Skinning Spriting} can be used for this image, by setting this property to a {@link
     * com.smartgwt.client.docs.SCSpriteConfig} formatted string. Alternatively developers can omit this property and instead
     * use CSS directly in the  {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getBooleanBaseStyle
     * booleanBaseStyle} property to provide a "checked" appearance.
     *
     * @return Current checkedImage value. Default value is "[SKIN]/DynamicForm/checked.gif"
     * @see com.smartgwt.client.widgets.form.fields.CheckboxItem#getPrintCheckedImage
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getCheckedImage()  {
        return getAttributeAsString("checkedImage");
    }
    

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @param editProxyConstructor New editProxyConstructor value. Default value is "CheckboxItemEditProxy"
     * @return {@link com.smartgwt.client.widgets.form.fields.CheckboxItem CheckboxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public CheckboxItem setEditProxyConstructor(String editProxyConstructor) {
        return (CheckboxItem)setAttribute("editProxyConstructor", editProxyConstructor);
    }

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @return Current editProxyConstructor value. Default value is "CheckboxItemEditProxy"
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public String getEditProxyConstructor()  {
        return getAttributeAsString("editProxyConstructor");
    }
    

    /**
     * By default a checkboxItem sets {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getShowTitle showTitle}:true,
     * and so takes up two cells with the default {@link com.smartgwt.client.types.TitleOrientation} of "left" (see {@link
     * com.smartgwt.client.docs.FormLayout form layout\n overview}).  However, the title cell is left blank by default, and the
     * title specified by {@link com.smartgwt.client.widgets.form.fields.FormItem#getTitle FormItem.title} is shown inside the
     * formItem's cell instead, in an element called the "label". <P> To instead show the title in it's original location, set
     * <code>labelAsTitle:true</code>. You can also set {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getShowLabel showLabel}:false to suppress the label and/or title
     * altogether.
     *
     * @param labelAsTitle New labelAsTitle value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.CheckboxItem CheckboxItem} instance, for chaining setter calls
     */
    public CheckboxItem setLabelAsTitle(Boolean labelAsTitle) {
        return (CheckboxItem)setAttribute("labelAsTitle", labelAsTitle);
    }

    /**
     * By default a checkboxItem sets {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getShowTitle showTitle}:true,
     * and so takes up two cells with the default {@link com.smartgwt.client.types.TitleOrientation} of "left" (see {@link
     * com.smartgwt.client.docs.FormLayout form layout\n overview}).  However, the title cell is left blank by default, and the
     * title specified by {@link com.smartgwt.client.widgets.form.fields.FormItem#getTitle FormItem.title} is shown inside the
     * formItem's cell instead, in an element called the "label". <P> To instead show the title in it's original location, set
     * <code>labelAsTitle:true</code>. You can also set {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getShowLabel showLabel}:false to suppress the label and/or title
     * altogether.
     *
     * @return Current labelAsTitle value. Default value is null
     */
    public Boolean getLabelAsTitle()  {
        return getAttributeAsBoolean("labelAsTitle", true);
    }
    

    /**
     * The description shown in a hover when {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowOldValueInHover
     * FormItem.showOldValueInHover} is enabled and a value represents the partial selected state.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param partialSelectedDescription New partialSelectedDescription value. Default value is "partially selected"
     * @return {@link com.smartgwt.client.widgets.form.fields.CheckboxItem CheckboxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public CheckboxItem setPartialSelectedDescription(String partialSelectedDescription) {
        return (CheckboxItem)setAttribute("partialSelectedDescription", partialSelectedDescription);
    }

    /**
     * The description shown in a hover when {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowOldValueInHover
     * FormItem.showOldValueInHover} is enabled and a value represents the partial selected state.
     *
     * @return Current partialSelectedDescription value. Default value is "partially selected"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getPartialSelectedDescription()  {
        return getAttributeAsString("partialSelectedDescription");
    }
    

    /**
     * URL for the image to display when this checkbox is partially selected. <P> The special value "blank" means that no image
     * will be shown. <P> {@link com.smartgwt.client.docs.Skinning Spriting} can be used for this image, by setting this
     * property to a {@link com.smartgwt.client.docs.SCSpriteConfig} formatted string. Alternatively developers can omit this
     * property and instead use CSS directly in the  {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getBooleanBaseStyle booleanBaseStyle} property to provide a
     * "partially checked" appearance.
     *
     * @param partialSelectedImage New partialSelectedImage value. Default value is "[SKIN]/DynamicForm/partialcheck.gif"
     * @return {@link com.smartgwt.client.widgets.form.fields.CheckboxItem CheckboxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.CheckboxItem#setPrintPartialSelectedImage
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public CheckboxItem setPartialSelectedImage(String partialSelectedImage) {
        return (CheckboxItem)setAttribute("partialSelectedImage", partialSelectedImage);
    }

    /**
     * URL for the image to display when this checkbox is partially selected. <P> The special value "blank" means that no image
     * will be shown. <P> {@link com.smartgwt.client.docs.Skinning Spriting} can be used for this image, by setting this
     * property to a {@link com.smartgwt.client.docs.SCSpriteConfig} formatted string. Alternatively developers can omit this
     * property and instead use CSS directly in the  {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getBooleanBaseStyle booleanBaseStyle} property to provide a
     * "partially checked" appearance.
     *
     * @return Current partialSelectedImage value. Default value is "[SKIN]/DynamicForm/partialcheck.gif"
     * @see com.smartgwt.client.widgets.form.fields.CheckboxItem#getPrintPartialSelectedImage
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getPartialSelectedImage()  {
        return getAttributeAsString("partialSelectedImage");
    }
    

    /**
     * If set, the {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getBooleanBaseStyle booleanBaseStyle} to use
     * when {@link com.smartgwt.client.docs.Printing printing}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param printBooleanBaseStyle New printBooleanBaseStyle value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.CheckboxItem CheckboxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.CheckboxItem#setBooleanBaseStyle
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public CheckboxItem setPrintBooleanBaseStyle(String printBooleanBaseStyle) {
        return (CheckboxItem)setAttribute("printBooleanBaseStyle", printBooleanBaseStyle);
    }

    /**
     * If set, the {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getBooleanBaseStyle booleanBaseStyle} to use
     * when {@link com.smartgwt.client.docs.Printing printing}.
     *
     * @return Current printBooleanBaseStyle value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.CheckboxItem#getBooleanBaseStyle
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public String getPrintBooleanBaseStyle()  {
        return getAttributeAsString("printBooleanBaseStyle");
    }
    

    /**
     * If set, the {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getCheckedImage checkedImage} to use when {@link
     * com.smartgwt.client.docs.Printing printing}.
     *
     * @param printCheckedImage New printCheckedImage value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.CheckboxItem CheckboxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.CheckboxItem#setCheckedImage
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public CheckboxItem setPrintCheckedImage(String printCheckedImage) {
        return (CheckboxItem)setAttribute("printCheckedImage", printCheckedImage);
    }

    /**
     * If set, the {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getCheckedImage checkedImage} to use when {@link
     * com.smartgwt.client.docs.Printing printing}.
     *
     * @return Current printCheckedImage value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.CheckboxItem#getCheckedImage
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public String getPrintCheckedImage()  {
        return getAttributeAsString("printCheckedImage");
    }
    

    /**
     * If set, the {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getPartialSelectedImage partialSelectedImage} to
     * use when {@link com.smartgwt.client.docs.Printing printing}.
     *
     * @param printPartialSelectedImage New printPartialSelectedImage value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.CheckboxItem CheckboxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.CheckboxItem#setPartialSelectedImage
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public CheckboxItem setPrintPartialSelectedImage(String printPartialSelectedImage) {
        return (CheckboxItem)setAttribute("printPartialSelectedImage", printPartialSelectedImage);
    }

    /**
     * If set, the {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getPartialSelectedImage partialSelectedImage} to
     * use when {@link com.smartgwt.client.docs.Printing printing}.
     *
     * @return Current printPartialSelectedImage value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.CheckboxItem#getPartialSelectedImage
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public String getPrintPartialSelectedImage()  {
        return getAttributeAsString("printPartialSelectedImage");
    }
    

    /**
     * If set, the {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getUncheckedImage uncheckedImage} to use when
     * {@link com.smartgwt.client.docs.Printing printing}.
     *
     * @param printUncheckedImage New printUncheckedImage value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.CheckboxItem CheckboxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.CheckboxItem#setUncheckedImage
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public CheckboxItem setPrintUncheckedImage(String printUncheckedImage) {
        return (CheckboxItem)setAttribute("printUncheckedImage", printUncheckedImage);
    }

    /**
     * If set, the {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getUncheckedImage uncheckedImage} to use when
     * {@link com.smartgwt.client.docs.Printing printing}.
     *
     * @return Current printUncheckedImage value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.CheckboxItem#getUncheckedImage
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public String getPrintUncheckedImage()  {
        return getAttributeAsString("printUncheckedImage");
    }
    

    /**
     * If set, the {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getUnsetImage unsetImage} to use when {@link
     * com.smartgwt.client.docs.Printing printing}.
     *
     * @param printUnsetImage New printUnsetImage value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.CheckboxItem CheckboxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.CheckboxItem#setUnsetImage
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public CheckboxItem setPrintUnsetImage(String printUnsetImage) {
        return (CheckboxItem)setAttribute("printUnsetImage", printUnsetImage);
    }

    /**
     * If set, the {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getUnsetImage unsetImage} to use when {@link
     * com.smartgwt.client.docs.Printing printing}.
     *
     * @return Current printUnsetImage value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.CheckboxItem#getUnsetImage
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public String getPrintUnsetImage()  {
        return getAttributeAsString("printUnsetImage");
    }
    

    /**
     * Should we show the label text next to the checkbox item.
     *
     * @param showLabel New showLabel value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.CheckboxItem CheckboxItem} instance, for chaining setter calls
     */
    public CheckboxItem setShowLabel(Boolean showLabel) {
        return (CheckboxItem)setAttribute("showLabel", showLabel);
    }

    /**
     * Should we show the label text next to the checkbox item.
     *
     * @return Current showLabel value. Default value is true
     */
    public Boolean getShowLabel()  {
        Boolean result = getAttributeAsBoolean("showLabel", true);
        return result == null ? true : result;
    }
    

    /**
     * Should a null value be shown as checked (i.e. true)?
     *
     * @param showNullAsTrue New showNullAsTrue value. Default value is false
     * @return {@link com.smartgwt.client.widgets.form.fields.CheckboxItem CheckboxItem} instance, for chaining setter calls
     */
    public CheckboxItem setShowNullAsTrue(Boolean showNullAsTrue) {
        return (CheckboxItem)setAttribute("showNullAsTrue", showNullAsTrue);
    }

    /**
     * Should a null value be shown as checked (i.e. true)?
     *
     * @return Current showNullAsTrue value. Default value is false
     */
    public Boolean getShowNullAsTrue()  {
        Boolean result = getAttributeAsBoolean("showNullAsTrue", true);
        return result == null ? false : result;
    }
    

    /**
     * CheckboxItem has special behavior for titles, see {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getLabelAsTitle labelAsTitle}.
     *
     * @param showTitle New showTitle value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.CheckboxItem CheckboxItem} instance, for chaining setter calls
     */
    public CheckboxItem setShowTitle(Boolean showTitle) {
        return (CheckboxItem)setAttribute("showTitle", showTitle);
    }

    /**
     * CheckboxItem has special behavior for titles, see {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getLabelAsTitle labelAsTitle}.
     *
     * @return Current showTitle value. Default value is true
     */
    public Boolean getShowTitle()  {
        Boolean result = getAttributeAsBoolean("showTitle", true);
        return result == null ? true : result;
    }
    
    

    /**
     * Should a "Disabled" state icon be shown when the item is disabled
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showValueIconDisabled New showValueIconDisabled value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.CheckboxItem CheckboxItem} instance, for chaining setter calls
     */
    public CheckboxItem setShowValueIconDisabled(Boolean showValueIconDisabled) {
        return (CheckboxItem)setAttribute("showValueIconDisabled", showValueIconDisabled);
    }

    /**
     * Should a "Disabled" state icon be shown when the item is disabled
     *
     * @return Current showValueIconDisabled value. Default value is true
     */
    public Boolean getShowValueIconDisabled()  {
        Boolean result = getAttributeAsBoolean("showValueIconDisabled", true);
        return result == null ? true : result;
    }
    

    /**
     * Should a "Down" state icon be shown when the mouse goes down over this checkbox
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showValueIconDown New showValueIconDown value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.CheckboxItem CheckboxItem} instance, for chaining setter calls
     */
    public CheckboxItem setShowValueIconDown(Boolean showValueIconDown) {
        return (CheckboxItem)setAttribute("showValueIconDown", showValueIconDown);
    }

    /**
     * Should a "Down" state icon be shown when the mouse goes down over this checkbox
     *
     * @return Current showValueIconDown value. Default value is true
     */
    public Boolean getShowValueIconDown()  {
        Boolean result = getAttributeAsBoolean("showValueIconDown", true);
        return result == null ? true : result;
    }
    

    /**
     * Should an "Over" state icon be shown when the user rolls over this checkbox
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showValueIconOver New showValueIconOver value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.CheckboxItem CheckboxItem} instance, for chaining setter calls
     */
    public CheckboxItem setShowValueIconOver(Boolean showValueIconOver) {
        return (CheckboxItem)setAttribute("showValueIconOver", showValueIconOver);
    }

    /**
     * Should an "Over" state icon be shown when the user rolls over this checkbox
     *
     * @return Current showValueIconOver value. Default value is true
     */
    public Boolean getShowValueIconOver()  {
        Boolean result = getAttributeAsBoolean("showValueIconOver", true);
        return result == null ? true : result;
    }
    

    /**
     * If this checkbox item is {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getShowLabel not showing a label},
     * should it ignore any specified {@link com.smartgwt.client.widgets.form.fields.FormItem#getWidth FormItem.width} and
     * instead size to fit its  {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getCheckedImage checkbox icon}? <P>
     * When set to true (the default), the checkbox item ignores any specified width, ensuring that it does not impact the the
     * containing DynamicForm's table geometry unnecessarily.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param sizeToCheckboxImage New sizeToCheckboxImage value. Default value is true
     * @return {@link com.smartgwt.client.widgets.form.fields.CheckboxItem CheckboxItem} instance, for chaining setter calls
     */
    public CheckboxItem setSizeToCheckboxImage(boolean sizeToCheckboxImage) {
        return (CheckboxItem)setAttribute("sizeToCheckboxImage", sizeToCheckboxImage);
    }

    /**
     * If this checkbox item is {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getShowLabel not showing a label},
     * should it ignore any specified {@link com.smartgwt.client.widgets.form.fields.FormItem#getWidth FormItem.width} and
     * instead size to fit its  {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getCheckedImage checkbox icon}? <P>
     * When set to true (the default), the checkbox item ignores any specified width, ensuring that it does not impact the the
     * containing DynamicForm's table geometry unnecessarily.
     *
     * @return Current sizeToCheckboxImage value. Default value is true
     */
    public boolean getSizeToCheckboxImage()  {
        Boolean result = getAttributeAsBoolean("sizeToCheckboxImage", true);
        return result == null ? true : result;
    }
    

    /**
     * Base CSS class for this item's title text
     *
     * @param textBoxStyle New textBoxStyle value. Default value is "labelAnchor"
     * @return {@link com.smartgwt.client.widgets.form.fields.CheckboxItem CheckboxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public CheckboxItem setTextBoxStyle(String textBoxStyle) {
        return (CheckboxItem)setAttribute("textBoxStyle", textBoxStyle);
    }

    /**
     * Base CSS class for this item's title text
     *
     * @return Current textBoxStyle value. Default value is "labelAnchor"
     * @see com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getTextBoxStyle()  {
        return getAttributeAsString("textBoxStyle");
    }
    

    /**
     * Base CSS class for this item's title cell. <P> <B>Note:</B> This styling applies to the standard form item title cell
     * for this item - it does not apply to item's {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getShowLabel
     * label}. To modify the styling for that text, use {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getTextBoxStyle textBoxStyle} instead.
     *
     * @param titleStyle New titleStyle value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.CheckboxItem CheckboxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public CheckboxItem setTitleStyle(String titleStyle) {
        return (CheckboxItem)setAttribute("titleStyle", titleStyle);
    }

    /**
     * Base CSS class for this item's title cell. <P> <B>Note:</B> This styling applies to the standard form item title cell
     * for this item - it does not apply to item's {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getShowLabel
     * label}. To modify the styling for that text, use {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getTextBoxStyle textBoxStyle} instead.
     *
     * @return Current titleStyle value. Default value is null
     * @see com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getTitleStyle()  {
        return getAttributeAsString("titleStyle");
    }
    

    /**
     * The description shown in a hover when {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowOldValueInHover
     * FormItem.showOldValueInHover} is enabled and a value represents the unchecked state.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param uncheckedDescription New uncheckedDescription value. Default value is "unchecked"
     * @return {@link com.smartgwt.client.widgets.form.fields.CheckboxItem CheckboxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public CheckboxItem setUncheckedDescription(String uncheckedDescription) {
        return (CheckboxItem)setAttribute("uncheckedDescription", uncheckedDescription);
    }

    /**
     * The description shown in a hover when {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowOldValueInHover
     * FormItem.showOldValueInHover} is enabled and a value represents the unchecked state.
     *
     * @return Current uncheckedDescription value. Default value is "unchecked"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getUncheckedDescription()  {
        return getAttributeAsString("uncheckedDescription");
    }
    

    /**
     * URL for the image to display when this checkbox is not selected, or unchecked. <P> The special value "blank" means that
     * no image will be shown. <P> {@link com.smartgwt.client.docs.Skinning Spriting} can be used for this image, by setting
     * this property to a {@link com.smartgwt.client.docs.SCSpriteConfig} formatted string. Alternatively developers can omit
     * this property and instead use CSS directly in the  {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getBooleanBaseStyle booleanBaseStyle} property to provide an
     * "unchecked" appearance.
     *
     * @param uncheckedImage New uncheckedImage value. Default value is "[SKIN]/DynamicForm/unchecked.gif"
     * @return {@link com.smartgwt.client.widgets.form.fields.CheckboxItem CheckboxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.CheckboxItem#setPrintUncheckedImage
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public CheckboxItem setUncheckedImage(String uncheckedImage) {
        return (CheckboxItem)setAttribute("uncheckedImage", uncheckedImage);
    }

    /**
     * URL for the image to display when this checkbox is not selected, or unchecked. <P> The special value "blank" means that
     * no image will be shown. <P> {@link com.smartgwt.client.docs.Skinning Spriting} can be used for this image, by setting
     * this property to a {@link com.smartgwt.client.docs.SCSpriteConfig} formatted string. Alternatively developers can omit
     * this property and instead use CSS directly in the  {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getBooleanBaseStyle booleanBaseStyle} property to provide an
     * "unchecked" appearance.
     *
     * @return Current uncheckedImage value. Default value is "[SKIN]/DynamicForm/unchecked.gif"
     * @see com.smartgwt.client.widgets.form.fields.CheckboxItem#getPrintUncheckedImage
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getUncheckedImage()  {
        return getAttributeAsString("uncheckedImage");
    }
    

    /**
     * The description shown in a hover when {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowOldValueInHover
     * FormItem.showOldValueInHover} is enabled and a value represents the unset state.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param unsetDescription New unsetDescription value. Default value is "unset"
     * @return {@link com.smartgwt.client.widgets.form.fields.CheckboxItem CheckboxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public CheckboxItem setUnsetDescription(String unsetDescription) {
        return (CheckboxItem)setAttribute("unsetDescription", unsetDescription);
    }

    /**
     * The description shown in a hover when {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowOldValueInHover
     * FormItem.showOldValueInHover} is enabled and a value represents the unset state.
     *
     * @return Current unsetDescription value. Default value is "unset"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getUnsetDescription()  {
        return getAttributeAsString("unsetDescription");
    }
    

    /**
     * URL for the image to display when this checkbox is unset. Note that if  {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getShowUnsetImage showUnsetImage} is false or {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getAllowEmptyValue allowEmptyValue} is false the {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getUncheckedImage uncheckedImage} will be used for null values
     * rather than this image. <P> The special value "blank" means that no image will be shown. <P> {@link
     * com.smartgwt.client.docs.Skinning Spriting} can be used for this image, by setting this property to a {@link
     * com.smartgwt.client.docs.SCSpriteConfig} formatted string. Alternatively developers can omit this property and instead
     * use CSS directly in the  {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getBooleanBaseStyle
     * booleanBaseStyle} property to provide an "unset" appearance.
     *
     * @param unsetImage New unsetImage value. Default value is "[SKIN]/DynamicForm/unsetcheck.gif"
     * @return {@link com.smartgwt.client.widgets.form.fields.CheckboxItem CheckboxItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public CheckboxItem setUnsetImage(String unsetImage) {
        return (CheckboxItem)setAttribute("unsetImage", unsetImage);
    }

    /**
     * URL for the image to display when this checkbox is unset. Note that if  {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getShowUnsetImage showUnsetImage} is false or {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getAllowEmptyValue allowEmptyValue} is false the {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getUncheckedImage uncheckedImage} will be used for null values
     * rather than this image. <P> The special value "blank" means that no image will be shown. <P> {@link
     * com.smartgwt.client.docs.Skinning Spriting} can be used for this image, by setting this property to a {@link
     * com.smartgwt.client.docs.SCSpriteConfig} formatted string. Alternatively developers can omit this property and instead
     * use CSS directly in the  {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getBooleanBaseStyle
     * booleanBaseStyle} property to provide an "unset" appearance.
     *
     * @return Current unsetImage value. Default value is "[SKIN]/DynamicForm/unsetcheck.gif"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getUnsetImage()  {
        return getAttributeAsString("unsetImage");
    }
    
    
    
    

    /**
     * Width for the CheckboxItem, including both checkbox image and {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getShowLabel label}. Note that if {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getShowLabel showLabel} is false, this property will have no effect
     * - the item will render at the size required to contain the icon.
     *
     * @param width New width value. Default value is 150
     * @return {@link com.smartgwt.client.widgets.form.fields.CheckboxItem CheckboxItem} instance, for chaining setter calls
     */
    public CheckboxItem setWidth(int width) {
        return (CheckboxItem)setAttribute("width", width);
    }

    /**
     * Width for the CheckboxItem, including both checkbox image and {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getShowLabel label}. Note that if {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getShowLabel showLabel} is false, this property will have no effect
     * - the item will render at the size required to contain the icon.
     *
     * @return Current width value. Default value is 150
     */
    public int getWidth()  {
        return getAttributeAsInt("width");
    }
    

    // ********************* Methods ***********************
	/**
     * Notification method called when {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPending showPending} is
     * enabled and this checkbox item should either clear or show its pending visual state. <p> The default behavior is that
     * the {@link com.smartgwt.client.widgets.form.fields.FormItem#getCellStyle cellStyle} and checkbox label style are updated
     * to include/exclude the "Pending" suffix. Returning <code>false</code> will cancel this default behavior.
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
     * @param checkboxItemProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(CheckboxItem checkboxItemProperties) /*-{
        if (checkboxItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(CheckboxItem.@java.lang.Object::getClass()(), "setDefaultProperties", checkboxItemProperties.@java.lang.Object::getClass()());
        }
        checkboxItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var properties = checkboxItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::getConfig()();
        $wnd.isc.CheckboxItem.addProperties(properties);
    }-*/;

    // ***********************************************************


    /**
     * Determines what image to display when the value for this checkbox is unset. Set to true to display the {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getUnsetImage unsetImage} for null values, or false to use the {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getUncheckedImage uncheckedImage} for both null and explicitly unchecked values. <P> If this attribute is not set, the {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getUnsetImage unsetImage} for null values if  {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getAllowEmptyValue allowEmptyValue} is true for this item, otherwise the unchecked image will be used.
     *
     * @param showUnsetImage showUnsetImage Default value is IRA
     */
    public void setShowUnsetImage(Boolean showUnsetImage) {
        setAttribute("showUnsetImage", showUnsetImage);
    }

    /**
     * Return the value of the checkbox as a Boolean.  If the value is not already a boolean,
     * or is unset and (@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getAllowEmptyValue}
     * returns true, then null will be returned.
     *
     * @return value of this element
     */
    public Boolean getValueAsBoolean() {
        Object value = super.getValue();
        if (value == null) return getAllowEmptyValue()     ?           null : false;
        else               return value instanceof Boolean ? (Boolean) value : null;
    }

}
