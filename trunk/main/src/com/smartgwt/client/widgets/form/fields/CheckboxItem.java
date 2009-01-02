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
import com.google.gwt.event.logical.shared.HasHandlers;
   /**
    * Checkbox form item, implemented with customizeable checkbox images

    */
public class CheckboxItem extends FormItem {

    public static CheckboxItem getOrCreateRef(JavaScriptObject jsObj) {
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (CheckboxItem) obj;
        } else {
            return new CheckboxItem(jsObj);
        }
    }


    public CheckboxItem(){
        setType("CheckboxItem");
    }

    public CheckboxItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public CheckboxItem(String name) {
        setName(name);
        setType("CheckboxItem");
    }

    // ********************* Properties / Attributes ***********************

    /**
    * Base CSS class for this item's title text
    *
    * @param textBoxStyle textBoxStyle Default value is "labelAnchor"
    */
    public void setTextBoxStyle(String textBoxStyle) {
        setAttribute("textBoxStyle", textBoxStyle);
    }
    /**
     * Base CSS class for this item's title text
     *
     *
     * @return String
     *
     */
    public String getTextBoxStyle()  {
        return getAttributeAsString("textBoxStyle");
    }

    /**
    * Should we should the label text next to the checkbox item.
    *
    * @param showLabel showLabel Default value is true
    */
    public void setShowLabel(Boolean showLabel) {
        setAttribute("showLabel", showLabel);
    }
    /**
     * Should we should the label text next to the checkbox item.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowLabel()  {
        return getAttributeAsBoolean("showLabel");
    }

    /**
    * URL for the image to display when this checkbox is selected, or checked. This is the base image name - if <code>showValueIconOver</code> et al are set, the state (<code>"Over"</code>, <code>"Down"</code> and <code>"Disabled"</code>) will be added to this name as the user intereacts with the checkbox, as well as the  <code>".gif"</code> extension
    *
    * @param checkedImage checkedImage Default value is "[SKIN]/DynamicForm/checked.gif"
    */
    public void setCheckedImage(String checkedImage) {
        setAttribute("checkedImage", checkedImage);
    }
    /**
     * URL for the image to display when this checkbox is selected, or checked. This is the base image name - if <code>showValueIconOver</code> et al are set, the state (<code>"Over"</code>, <code>"Down"</code> and <code>"Disabled"</code>) will be added to this name as the user intereacts with the checkbox, as well as the  <code>".gif"</code> extension
     *
     *
     * @return String
     *
     */
    public String getCheckedImage()  {
        return getAttributeAsString("checkedImage");
    }

    /**
    * URL for the image to display when this checkbox is not selected, or unchecked
    *
    * @param uncheckedImage uncheckedImage Default value is "[SKIN]/DynamicForm/unchecked.gif"
    */
    public void setUncheckedImage(String uncheckedImage) {
        setAttribute("uncheckedImage", uncheckedImage);
    }
    /**
     * URL for the image to display when this checkbox is not selected, or unchecked
     *
     *
     * @return String
     *
     */
    public String getUncheckedImage()  {
        return getAttributeAsString("uncheckedImage");
    }

    /**
    * URL for the image to display when this checkbox is unset.  Defaults to matching the unchecked image.
    *
    * @param unsetImage unsetImage Default value is "[SKIN]/DynamicForm/unchecked.gif"
    */
    public void setUnsetImage(String unsetImage) {
        setAttribute("unsetImage", unsetImage);
    }
    /**
     * URL for the image to display when this checkbox is unset.  Defaults to matching the unchecked image.
     *
     *
     * @return String
     *
     */
    public String getUnsetImage()  {
        return getAttributeAsString("unsetImage");
    }

    // ********************* Methods ***********************


    // ********************* Static Methods ***********************

}




