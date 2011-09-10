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
 * Set of horizontally arranged buttons.
 */
public class ToolbarItem extends CanvasItem {

    public static ToolbarItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (ToolbarItem) obj;
        } else {
            return new ToolbarItem(jsObj);
        }
    }

    public ToolbarItem(){
        setType("ToolbarItem");
    }

    public ToolbarItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public ToolbarItem(String name) {
        setName(name);
        setType("ToolbarItem");
    }

    public ToolbarItem(String name, String title) {
        setName(name);
		setTitle(title);
        setType("ToolbarItem");
    }

    // ********************* Properties / Attributes ***********************

    /**
     * If specified this baseStyle will be applied to the buttons in this toolbar.
     *
     * @param buttonBaseStyle buttonBaseStyle Default value is null
     */
    public void setButtonBaseStyle(String buttonBaseStyle) {
        setAttribute("buttonBaseStyle", buttonBaseStyle);
    }

    /**
     * If specified this baseStyle will be applied to the buttons in this toolbar.
     *
     *
     * @return String
     */
    public String getButtonBaseStyle()  {
        return getAttributeAsString("buttonBaseStyle");
    }

    /**
     * these items are in a row by themselves by default
     *
     * @param endRow endRow Default value is true
     */
    public void setEndRow(Boolean endRow) {
        setAttribute("endRow", endRow);
    }

    /**
     * these items are in a row by themselves by default
     *
     *
     * @return Boolean
     */
    public Boolean getEndRow()  {
        return getAttributeAsBoolean("endRow");
    }

    /**
     * Don't show a title for toolbars
     *
     * @param showTitle showTitle Default value is false
     */
    public void setShowTitle(Boolean showTitle) {
        setAttribute("showTitle", showTitle);
    }

    /**
     * Don't show a title for toolbars
     *
     *
     * @return Boolean
     */
    public Boolean getShowTitle()  {
        return getAttributeAsBoolean("showTitle");
    }

    /**
     * these items are in a row by themselves by default
     *
     * @param startRow startRow Default value is true
     */
    public void setStartRow(Boolean startRow) {
        setAttribute("startRow", startRow);
    }

    /**
     * these items are in a row by themselves by default
     *
     *
     * @return Boolean
     */
    public Boolean getStartRow()  {
        return getAttributeAsBoolean("startRow");
    }

    /**
     * Should the toolbar stack its buttons vertically or horizontally?
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param vertical vertical Default value is false
     */
    public void setVertical(Boolean vertical) {
        setAttribute("vertical", vertical);
    }

    /**
     * Should the toolbar stack its buttons vertically or horizontally?
     *
     *
     * @return Boolean
     */
    public Boolean getVertical()  {
        return getAttributeAsBoolean("vertical");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************


    /**
     * List of buttons for the toolbar.  Each buttons should be specified as a simple JS object with properties to apply
     * to the  button to be displayed. Note that any <code>click</code> stringMethod applied to the  button will be
     * passed 2 parameters: <code>form</code> and <code>item</code>.
     *
     * @param buttons buttons Default value is null
     */
    public void setButtons(StatefulCanvas... buttons) {
        setAttribute("buttons", buttons);
    }

}


