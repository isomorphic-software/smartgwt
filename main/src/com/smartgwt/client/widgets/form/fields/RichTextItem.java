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
import com.smartgwt.client.widgets.cube.*;

import java.util.*;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * FormItem for rich text (HTML) editing. Makes use of a {@link com.smartgwt.client.widgets.RichTextEditor} as the  editing
 * interface.
 */
public class RichTextItem extends CanvasItem {

    public static RichTextItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (RichTextItem) obj;
        } else {
            return new RichTextItem(jsObj);
        }
    }

    public RichTextItem(){
        setAttribute("editorType", "RichTextItem");
    }

    public RichTextItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public RichTextItem(String name) {
        setName(name);
        setAttribute("editorType", "RichTextItem");
    }

    public RichTextItem(String name, String title) {
        setName(name);
		setTitle(title);
        setAttribute("editorType", "RichTextItem");
    }

    // ********************* Properties / Attributes ***********************

    /**
     * By default RichTextItems take up an entire row
     *
     * @param endRow endRow Default value is true
     */
    public void setEndRow(Boolean endRow) {
        setAttribute("endRow", endRow);
    }

    /**
     * By default RichTextItems take up an entire row
     *
     *
     * @return Boolean
     */
    public Boolean getEndRow()  {
        return getAttributeAsBoolean("endRow");
    }

    /**
     * Don't show the title for rich text items by default
     *
     * @param showTitle showTitle Default value is false
     */
    public void setShowTitle(Boolean showTitle) {
        setAttribute("showTitle", showTitle);
    }

    /**
     * Don't show the title for rich text items by default
     *
     *
     * @return Boolean
     */
    public Boolean getShowTitle()  {
        return getAttributeAsBoolean("showTitle");
    }

    /**
     * By default RichTextItems take up an entire row
     *
     * @param startRow startRow Default value is true
     */
    public void setStartRow(Boolean startRow) {
        setAttribute("startRow", startRow);
    }

    /**
     * By default RichTextItems take up an entire row
     *
     *
     * @return Boolean
     */
    public Boolean getStartRow()  {
        return getAttributeAsBoolean("startRow");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
        
    // ***********************************************************        


    /**
     * An array of control group names specifying which groups of controls should be included in the editor toolbar.
     *
     * @param controlGroups the control groups. default is {"fontControls", "formatControls", "styleControls",
     *                      "colorControls"}
     */
    public void setControlGroups(String... controlGroups) {
        setAttribute("controlGroups", controlGroups);
    }

}



