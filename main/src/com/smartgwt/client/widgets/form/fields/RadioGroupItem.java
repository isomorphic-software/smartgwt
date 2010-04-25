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
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

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
     * Base CSS class applied to the text for items within this radiogroup.
     *
     * @param textBoxStyle textBoxStyle Default value is "labelAnchor"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setTextBoxStyle(String textBoxStyle) {
        setAttribute("textBoxStyle", textBoxStyle);
    }

    /**
     * Base CSS class applied to the text for items within this radiogroup.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getTextBoxStyle()  {
        return getAttributeAsString("textBoxStyle");
    }

    /**
     * True == display options vertically, false == display in a single row
     *
     * @param vertical vertical Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setVertical(Boolean vertical) {
        setAttribute("vertical", vertical);
    }

    /**
     * True == display options vertically, false == display in a single row
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getVertical()  {
        return getAttributeAsBoolean("vertical");
    }

    /**
     * Should the text for items within this radio group wrap?
     *
     * @param wrap wrap Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setWrap(Boolean wrap) {
        setAttribute("wrap", wrap);
    }

    /**
     * Should the text for items within this radio group wrap?
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
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



