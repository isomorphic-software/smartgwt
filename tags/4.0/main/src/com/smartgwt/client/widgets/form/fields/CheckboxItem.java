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
import com.smartgwt.client.callbacks.*;
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
import com.smartgwt.client.widgets.cube.*;
import com.smartgwt.client.widgets.drawing.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.logicalstructure.core.*;
import com.smartgwt.logicalstructure.widgets.*;
import com.smartgwt.logicalstructure.widgets.drawing.*;
import com.smartgwt.logicalstructure.widgets.plugins.*;
import com.smartgwt.logicalstructure.widgets.form.*;
import com.smartgwt.logicalstructure.widgets.tile.*;
import com.smartgwt.logicalstructure.widgets.grid.*;
import com.smartgwt.logicalstructure.widgets.chart.*;
import com.smartgwt.logicalstructure.widgets.layout.*;
import com.smartgwt.logicalstructure.widgets.menu.*;
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;

/**
 * Checkbox form item, implemented with customizable checkbox images
 */
public class CheckboxItem extends FormItem {

    public static CheckboxItem getOrCreateRef(JavaScriptObject jsObj) {

        if(jsObj == null) return null;

        RefDataClass obj = RefDataClass.getRef(jsObj);

		if(obj != null && JSOHelper.getAttribute(jsObj,"__ref")==null) {
            return com.smartgwt.client.util.ObjectFactory.createFormItem("CheckboxItem",jsObj);

        } else
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (CheckboxItem) obj;
        } else {
            return new CheckboxItem(jsObj);
        }
    }

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }



    /**
     * Changes the defaults for Canvas AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults Canvas defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        $wnd.isc["CheckboxItem"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
    }-*/;

    /**
     * Changes the defaults for FormItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults FormItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, FormItem defaults) /*-{
        $wnd.isc["CheckboxItem"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;

    public CheckboxItem(){
        setAttribute("editorType", "CheckboxItem");
    }

    public CheckboxItem(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
        
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
     * @param allowEmptyValue allowEmptyValue Default value is false
     */
    public void setAllowEmptyValue(Boolean allowEmptyValue) {
        setAttribute("allowEmptyValue", allowEmptyValue);
    }

    /**
     * By default checkboxes allow the user to toggle between true and false values only. Setting this property to true will
     * allow the user to toggle between three values -  <code>true</code>, <code>false</code> and unset.
     *
     * @return Boolean
     */
    public Boolean getAllowEmptyValue()  {
        return getAttributeAsBoolean("allowEmptyValue");
    }


    /**
     * URL for the image to display when this checkbox is selected, or checked. <P> This image is implemented using the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons subsystem}, and may be modified via the
     * standard valueIcons properties such as {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getValueIconWidth
     * valueIconWidth} <P> Note that this is the base image name - if {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getShowValueIconOver showValueIconOver} et al are set, the state
     * (<code>"Over"</code>, <code>"Down"</code> and <code>"Disabled"</code>) will be added to this name as the user interacts
     * with the checkbox, as well as the  <code>".gif"</code> extension
     *
     * @param checkedImage . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}. Default value is "[SKIN]/DynamicForm/checked.gif"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setCheckedImage(String checkedImage) {
        setAttribute("checkedImage", checkedImage);
    }

    /**
     * URL for the image to display when this checkbox is selected, or checked. <P> This image is implemented using the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcons subsystem}, and may be modified via the
     * standard valueIcons properties such as {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getValueIconWidth
     * valueIconWidth} <P> Note that this is the base image name - if {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getShowValueIconOver showValueIconOver} et al are set, the state
     * (<code>"Over"</code>, <code>"Down"</code> and <code>"Disabled"</code>) will be added to this name as the user interacts
     * with the checkbox, as well as the  <code>".gif"</code> extension
     *
     * @return . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getCheckedImage()  {
        return getAttributeAsString("checkedImage");
    }


    /**
     * By default a checkboxItem sets {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getShowTitle showTitle}:true,
     * and so takes up two cells with the default {@link com.smartgwt.client.types.TitleOrientation} of "left" (see {@link
     * com.smartgwt.client.docs.FormLayout form layout overview}).  However, the title cell is left blank by default, and the
     * title specified by {@link com.smartgwt.client.widgets.form.fields.FormItem#getTitle title} is shown inside the
     * formItem's cell instead, in an element called the "label". <P> To instead show the title in it's original location, set
     * <code>labelAsTitle:true</code>. You can also set {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getShowLabel showLabel}:false to suppress the label and/or title
     * altogether.
     *
     * @param labelAsTitle labelAsTitle Default value is null
     */
    public void setLabelAsTitle(Boolean labelAsTitle) {
        setAttribute("labelAsTitle", labelAsTitle);
    }

    /**
     * By default a checkboxItem sets {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getShowTitle showTitle}:true,
     * and so takes up two cells with the default {@link com.smartgwt.client.types.TitleOrientation} of "left" (see {@link
     * com.smartgwt.client.docs.FormLayout form layout overview}).  However, the title cell is left blank by default, and the
     * title specified by {@link com.smartgwt.client.widgets.form.fields.FormItem#getTitle title} is shown inside the
     * formItem's cell instead, in an element called the "label". <P> To instead show the title in it's original location, set
     * <code>labelAsTitle:true</code>. You can also set {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getShowLabel showLabel}:false to suppress the label and/or title
     * altogether.
     *
     * @return Boolean
     */
    public Boolean getLabelAsTitle()  {
        return getAttributeAsBoolean("labelAsTitle");
    }


    /**
     * URL for the image to display when this checkbox is partially selected
     *
     * @param partialSelectedImage . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}. Default value is "[SKIN]/DynamicForm/partialcheck.gif"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setPartialSelectedImage(String partialSelectedImage) {
        setAttribute("partialSelectedImage", partialSelectedImage);
    }

    /**
     * URL for the image to display when this checkbox is partially selected
     *
     * @return . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getPartialSelectedImage()  {
        return getAttributeAsString("partialSelectedImage");
    }


    /**
     * Should we show the label text next to the checkbox item.
     *
     * @param showLabel showLabel Default value is true
     */
    public void setShowLabel(Boolean showLabel) {
        setAttribute("showLabel", showLabel);
    }

    /**
     * Should we show the label text next to the checkbox item.
     *
     * @return Boolean
     */
    public Boolean getShowLabel()  {
        return getAttributeAsBoolean("showLabel");
    }


    /**
     * CheckboxItem has special behavior for titles, see {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getLabelAsTitle labelAsTitle}.
     *
     * @param showTitle showTitle Default value is true
     */
    public void setShowTitle(Boolean showTitle) {
        setAttribute("showTitle", showTitle);
    }

    /**
     * CheckboxItem has special behavior for titles, see {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getLabelAsTitle labelAsTitle}.
     *
     * @return Boolean
     */
    public Boolean getShowTitle()  {
        return getAttributeAsBoolean("showTitle");
    }



    /**
     * Should a "Disabled" state icon be shown when the item is disabled
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showValueIconDisabled showValueIconDisabled Default value is true
     */
    public void setShowValueIconDisabled(Boolean showValueIconDisabled) {
        setAttribute("showValueIconDisabled", showValueIconDisabled);
    }

    /**
     * Should a "Disabled" state icon be shown when the item is disabled
     *
     * @return Boolean
     */
    public Boolean getShowValueIconDisabled()  {
        return getAttributeAsBoolean("showValueIconDisabled");
    }


    /**
     * Should a "Down" state icon be shown when the mouse goes down over this checkbox
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showValueIconDown showValueIconDown Default value is true
     */
    public void setShowValueIconDown(Boolean showValueIconDown) {
        setAttribute("showValueIconDown", showValueIconDown);
    }

    /**
     * Should a "Down" state icon be shown when the mouse goes down over this checkbox
     *
     * @return Boolean
     */
    public Boolean getShowValueIconDown()  {
        return getAttributeAsBoolean("showValueIconDown");
    }


    /**
     * Should an "Over" state icon be shown when the user rolls over this checkbox
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showValueIconOver showValueIconOver Default value is true
     */
    public void setShowValueIconOver(Boolean showValueIconOver) {
        setAttribute("showValueIconOver", showValueIconOver);
    }

    /**
     * Should an "Over" state icon be shown when the user rolls over this checkbox
     *
     * @return Boolean
     */
    public Boolean getShowValueIconOver()  {
        return getAttributeAsBoolean("showValueIconOver");
    }


    /**
     * Base CSS class for this item's title text
     *
     * @param textBoxStyle . See {@link com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle}. Default value is "labelAnchor"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setTextBoxStyle(String textBoxStyle) {
        setAttribute("textBoxStyle", textBoxStyle);
    }

    /**
     * Base CSS class for this item's title text
     *
     * @return . See {@link com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle}
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
     * @param titleStyle . See {@link com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle}. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setTitleStyle(String titleStyle) {
        setAttribute("titleStyle", titleStyle);
    }

    /**
     * Base CSS class for this item's title cell. <P> <B>Note:</B> This styling applies to the standard form item title cell
     * for this item - it does not apply to item's {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getShowLabel
     * label}. To modify the styling for that text, use {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getTextBoxStyle textBoxStyle} instead.
     *
     * @return . See {@link com.smartgwt.client.docs.FormItemBaseStyle FormItemBaseStyle}
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getTitleStyle()  {
        return getAttributeAsString("titleStyle");
    }


    /**
     * URL for the image to display when this checkbox is not selected, or unchecked
     *
     * @param uncheckedImage . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}. Default value is "[SKIN]/DynamicForm/unchecked.gif"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setUncheckedImage(String uncheckedImage) {
        setAttribute("uncheckedImage", uncheckedImage);
    }

    /**
     * URL for the image to display when this checkbox is not selected, or unchecked
     *
     * @return . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getUncheckedImage()  {
        return getAttributeAsString("uncheckedImage");
    }


    /**
     * URL for the image to display when this checkbox is unset. Note that if  {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getShowUnsetImage showUnsetImage} is false or {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getAllowEmptyValue allowEmptyValue} is false the {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getUncheckedImage uncheckedImage} will be used for null values
     * rather than this image.
     *
     * @param unsetImage . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}. Default value is "[SKIN]/DynamicForm/unsetcheck.gif"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setUnsetImage(String unsetImage) {
        setAttribute("unsetImage", unsetImage);
    }

    /**
     * URL for the image to display when this checkbox is unset. Note that if  {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getShowUnsetImage showUnsetImage} is false or {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getAllowEmptyValue allowEmptyValue} is false the {@link
     * com.smartgwt.client.widgets.form.fields.CheckboxItem#getUncheckedImage uncheckedImage} will be used for null values
     * rather than this image.
     *
     * @return . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getUnsetImage()  {
        return getAttributeAsString("unsetImage");
    }




    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
    /**
     * Class level method to set the default properties of this class. If set, then all subsequent instances of this
     * class will automatically have the default properties that were set when this method was called. This is a powerful
     * feature that eliminates the need for users to create a separate hierarchy of subclasses that only alter the default
     * properties of this class. Can also be used for skinning / styling purposes.
     * <P>
     * <b>Note:</b> This method is intended for setting default attributes only and will effect all instances of the
     * underlying class (including those automatically generated in JavaScript).
     * This method should not be used to apply standard EventHandlers or override methods for
     * a class - use a custom subclass instead.
     *
     * @param checkboxItemProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(CheckboxItem checkboxItemProperties) /*-{
    	var properties = $wnd.isc.addProperties({},checkboxItemProperties.@com.smartgwt.client.core.RefDataClass::getJsObj()());
    	delete properties.ID;
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
     * Return the value of the checkbox as a boolean
     *
     * @return the checbox value as Boolean
     */
    public Boolean getValueAsBoolean() {
        Boolean origValue = (Boolean) super.getValue();
        return !(!getAllowEmptyValue() && origValue == null) && origValue;
    }

}



