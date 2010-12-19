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
 * HiddenItems track a value but have no visible appearance and do not take up space in the form layout. <P> When using
 * Smart GWT databinding it is usually not necessary to use a HiddenItem, since the DynamicForm will track values for which
 * no actual form control exists, and will submit these 'extra' values when {@link
 * com.smartgwt.client.widgets.form.DynamicForm#saveData DynamicForm.saveData} is called.  HiddenItems only apply to forms
 * that are submitted like ordinary HTML forms, via the {@link com.smartgwt.client.widgets.form.DynamicForm#submitForm
 * DynamicForm.submitForm} method.
 */
public class HiddenItem extends FormItem {

    public static HiddenItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (HiddenItem) obj;
        } else {
            return new HiddenItem(jsObj);
        }
    }

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
     * hidden fields don't take up any columns
     *
     * @param colSpan colSpan Default value is 0
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setColSpan(int colSpan) {
        setAttribute("colSpan", colSpan);
    }

    /**
     * hidden fields don't take up any columns
     *
     *
     * @return int
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getColSpan()  {
        return getAttributeAsInt("colSpan");
    }

    /**
     * hidden fields don't take up any rows
     *
     * @param rowSpan rowSpan Default value is 0
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setRowSpan(int rowSpan) {
        setAttribute("rowSpan", rowSpan);
    }

    /**
     * hidden fields don't take up any rows
     *
     *
     * @return int
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getRowSpan()  {
        return getAttributeAsInt("rowSpan");
    }

    /**
     * we never show a separate title cell for hidden fields
     *
     * @param showTitle showTitle Default value is false
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setShowTitle(Boolean showTitle) {
        setAttribute("showTitle", showTitle);
    }

    /**
     * we never show a separate title cell for hidden fields
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowTitle()  {
        return getAttributeAsBoolean("showTitle");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
        
    // ***********************************************************        

}



