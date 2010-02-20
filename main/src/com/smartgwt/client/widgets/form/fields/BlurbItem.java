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
 * FormItem intended for inserting blurbs of instructional HTML into DynamicForms. <p> Set the <code>defaultValue</code> of
 * this item to the HTML you want to embed in the form.
 */
public class BlurbItem extends FormItem {

    public static BlurbItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (BlurbItem) obj;
        } else {
            return new BlurbItem(jsObj);
        }
    }

    public BlurbItem(){
        setType("BlurbItem");
    }

    public BlurbItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public BlurbItem(String name) {
        setName(name);
        setType("BlurbItem");
    }

    // ********************* Properties / Attributes ***********************

    /**
     * If true, text that exceeds the specified size of the form item will be clipped
     *
     * @param clipValue clipValue Default value is false
     */
    public void setClipValue(Boolean clipValue) {
        setAttribute("clipValue", clipValue);
    }

    /**
     * If true, text that exceeds the specified size of the form item will be clipped
     *
     *
     * @return Boolean
     */
    public Boolean getClipValue()  {
        return getAttributeAsBoolean("clipValue");
    }

    /**
     * By default, texts span all remaining columns
     *
     * @param colSpan colSpan Default value is "*"
     */
    public void setColSpan(int colSpan) {
        setAttribute("colSpan", colSpan);
    }

    /**
     * By default, texts span all remaining columns
     *
     *
     * @return int
     */
    public int getColSpan()  {
        return getAttributeAsInt("colSpan");
    }

    /**
     * Blurb items show no title by default.
     *
     * @param showTitle showTitle Default value is false
     */
    public void setShowTitle(Boolean showTitle) {
        setAttribute("showTitle", showTitle);
    }

    /**
     * Blurb items show no title by default.
     *
     *
     * @return Boolean
     */
    public Boolean getShowTitle()  {
        return getAttributeAsBoolean("showTitle");
    }

    /**
     * Base css style for this item.
     *
     * @param textBoxStyle textBoxStyle Default value is "staticTextItem"
     */
    public void setTextBoxStyle(String textBoxStyle) {
        setAttribute("textBoxStyle", textBoxStyle);
    }

    /**
     * Base css style for this item.
     *
     *
     * @return String
     */
    public String getTextBoxStyle()  {
        return getAttributeAsString("textBoxStyle");
    }

    /**
     * If true, item contents can wrap. If false, all the contents should appear on a single line.
     *
     * @param wrap wrap Default value is null
     */
    public void setWrap(Boolean wrap) {
        setAttribute("wrap", wrap);
    }

    /**
     * If true, item contents can wrap. If false, all the contents should appear on a single line.
     *
     *
     * @return Boolean
     */
    public Boolean getWrap()  {
        return getAttributeAsBoolean("wrap");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

}



