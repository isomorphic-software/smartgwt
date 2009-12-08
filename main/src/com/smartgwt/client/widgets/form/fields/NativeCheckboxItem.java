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


import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.core.RefDataClass;

/**
 * A checkbox for manipulating 2-valued fields based on the native checkbox element.
 */
public class NativeCheckboxItem extends FormItem {

    public static NativeCheckboxItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (NativeCheckboxItem) obj;
        } else {
            return new NativeCheckboxItem(jsObj);
        }
    }

    public NativeCheckboxItem(){
        setType("NativeCheckboxItem");
    }

    public NativeCheckboxItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public NativeCheckboxItem(String name) {
        setName(name);
        setType("NativeCheckboxItem");
    }

    // ********************* Properties / Attributes ***********************

    /**
     * Base CSS class applied to this item's title text (rendered next to the checkbox element).
     *
     * @param textBoxStyle textBoxStyle Default value is "labelAnchor"
     */
    public void setTextBoxStyle(String textBoxStyle) {
        setAttribute("textBoxStyle", textBoxStyle);
    }

    /**
     * Base CSS class applied to this item's title text (rendered next to the checkbox element).
     *
     *
     * @return String
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
     */
    public Boolean getShowLabel()  {
        return getAttributeAsBoolean("showLabel");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

}



