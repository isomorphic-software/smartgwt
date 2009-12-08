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

/**
 * FormItem that shows a set of mutually exclusive options as a group of radio buttons.
 */
public class RadioGroupItem extends FormItem {

    public static RadioGroupItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new RadioGroupItem(jsObj);
    }

    public RadioGroupItem(){
        setType("radioGroup");
    }

    public RadioGroupItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public RadioGroupItem(String name) {
        setName(name);
        setType("radioGroup");
    }

    public RadioGroupItem(String name, String title) {
        setName(name);
		setTitle(title);
        setType("radioGroup");
    }

    // ********************* Properties / Attributes ***********************

    /**
     * True == display options vertically, false == display in a single row
     *
     * @param vertical vertical Default value is true
     */
    public void setVertical(Boolean vertical) {
        setAttribute("vertical", vertical);
    }

    /**
     * True == display options vertically, false == display in a single row
     *
     *
     * @return Boolean
     */
    public Boolean getVertical()  {
        return getAttributeAsBoolean("vertical");
    }

    /**
     * Base CSS class applied to the text for items within this radiogroup.
     *
     * @param textBoxStyle textBoxStyle Default value is "labelAnchor"
     */
    public void setTextBoxStyle(String textBoxStyle) {
        setAttribute("textBoxStyle", textBoxStyle);
    }

    /**
     * Base CSS class applied to the text for items within this radiogroup.
     *
     *
     * @return String
     */
    public String getTextBoxStyle()  {
        return getAttributeAsString("textBoxStyle");
    }

    /**
     * Should the text for items within this radio group wrap?
     *
     * @param wrap wrap Default value is null
     */
    public void setWrap(Boolean wrap) {
        setAttribute("wrap", wrap);
    }

    /**
     * Should the text for items within this radio group wrap?
     *
     *
     * @return Boolean
     */
    public Boolean getWrap()  {
        return getAttributeAsBoolean("wrap");
    }

    // ********************* Methods ***********************

    /**
     * Disable or Enable a specific option within this radioGroup
     * @param value value of option to disable
     * @param disabled true to disable the option, false to enable it
     */
    public native void setValueDisabled(Object value, boolean disabled) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.setValueDisabled(value, disabled);
    }-*/;

    // ********************* Static Methods ***********************

}



