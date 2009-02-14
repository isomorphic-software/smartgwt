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
 
package com.smartgwt.client.widgets.grid;



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
import com.google.gwt.event.shared.HasHandlers;
   /**
    * A ListGridRecord is a JavaScript Object whose properties contain values for each ${isc.DocUtils.linkForRef('object:ListGridField')}.  A ListGridRecord may have additional properties which affect the record's appearance or behavior, or which hold data for use by custom logic or other, related components. <p> For example a ListGrid that defines the following fields: <pre> fields : [     {name: "field1"},     {name: "field2"} ], </pre> Might have the following data: <pre> data : [     {field1: "foo", field2: "bar", customProperty:5},     {field1: "field1 value", field2: "field2 value", enabled:false} ] </pre> Each line of code in the <code>data</code> array above creates one JavaScript Object via JavaScript {type:ObjectLiteral,object literal} notation.  These JavaScript Objects are used as ListGridRecords. <P> Both records shown above have properties whose names match the name property of a ListGridField, as well as additional properties.  The second record will be disabled due to <code>enabled:false</code>; the first record has a property "customProperty" which will have no effect by default but which may be accessed by custom logic. <P> After a ListGrid is created and has loaded data, records may be accessed via {@link com.smartgwt.client.widgets.grid.ListGrid#getData data}, for example, listGrid.data.get(0) retrieves the first record. ListGridRecords are also passed to many events, such as {@link com.smartgwt.client.widgets.grid.ListGrid#cellClick}. <P> A ListGridRecord is always an ordinary JavaScript Object regardless of how the grid's dataset is loaded (static data, java server, XML web service, etc), and so supports the normal behaviors of JavaScript Objects, including accessing and assigning to properties via dot notation: <pre>     var fieldValue = record.<i>fieldName</i>;     record.<i>fieldName</i> = newValue; </pre> <P> Note however that simply assigning a value to a record won't cause the display to be automatically refreshed - {@link com.smartgwt.client.widgets.grid.ListGrid#refreshCell} needs to be called.  Also, consider editValues vs saved values when directly modifying ListGridRecords. <P> See the attributes in the API tab for the full list of special properties on ListGridRecords that will affect the grid's behavior.

    */
public class ListGridRecord extends RefDataClass  implements Record {

    public static ListGridRecord getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (ListGridRecord) obj;
        } else {
            return new ListGridRecord(jsObj);
        }
    }


    public ListGridRecord(){
        
    }

    public ListGridRecord(JavaScriptObject jsObj){
        super(jsObj);
    }

    // ********************* Properties / Attributes ***********************

    /**
    * Affects the visual style and interactivity of the record.  If set to <code>false</code> the record (row in a {@link com.smartgwt.client.widgets.grid.ListGrid} or {@link com.smartgwt.client.widgets.tree.TreeGrid}) will not highlight when the mouse moves over it, nor will it respond to mouse clicks.
    *
    * @param enabled enabled Default value is null
    */
    public void setEnabled(Boolean enabled) {
        setAttribute("enabled", enabled);
    }
    /**
     * Affects the visual style and interactivity of the record.  If set to <code>false</code> the record (row in a {@link com.smartgwt.client.widgets.grid.ListGrid} or {@link com.smartgwt.client.widgets.tree.TreeGrid}) will not highlight when the mouse moves over it, nor will it respond to mouse clicks.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getEnabled()  {
        return getAttributeAsBoolean("enabled");
    }

    /**
    * Default property name denoting a separator row.<br> When set to <code>true</code>, defines a horizontal separator in the listGrid object. Typically this is specified as the only property of a record object, since a record with <code>isSeparator:true</code> will not display any values.<br> Note: this attribute name is governed by {@link com.smartgwt.client.widgets.grid.ListGrid#getIsSeparatorProperty isSeparatorProperty}.
    *
    * @param isSeparator isSeparator Default value is null
    */
    public void setIsSeparator(Boolean isSeparator) {
        setAttribute("isSeparator", isSeparator);
    }
    /**
     * Default property name denoting a separator row.<br> When set to <code>true</code>, defines a horizontal separator in the listGrid object. Typically this is specified as the only property of a record object, since a record with <code>isSeparator:true</code> will not display any values.<br> Note: this attribute name is governed by {@link com.smartgwt.client.widgets.grid.ListGrid#getIsSeparatorProperty isSeparatorProperty}.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getIsSeparator()  {
        return getAttributeAsBoolean("isSeparator");
    }

    /**
    * Default property name denoting the single value to display for all fields of this row. If this property is set for some record, the record will be displayed as a single  cell spanning every column in the grid, with contents set to the value of this property.<br> Note: this attribute name is governed by {@link com.smartgwt.client.widgets.grid.ListGrid#getSingleCellValueProperty singleCellValueProperty}.
    *
    * @param singleCellValue singleCellValue Default value is null
    */
    public void setSingleCellValue(String singleCellValue) {
        setAttribute("singleCellValue", singleCellValue);
    }
    /**
     * Default property name denoting the single value to display for all fields of this row. If this property is set for some record, the record will be displayed as a single  cell spanning every column in the grid, with contents set to the value of this property.<br> Note: this attribute name is governed by {@link com.smartgwt.client.widgets.grid.ListGrid#getSingleCellValueProperty singleCellValueProperty}.
     *
     *
     * @return String
     *
     */
    public String getSingleCellValue()  {
        return getAttributeAsString("singleCellValue");
    }

    /**
    * When set to <code>false</code>, this record cannot be dragged. If canDrag is false for any record in the current selection, none of the records will be draggable.
    *
    * @param canDrag canDrag Default value is null
    */
    public void setCanDrag(Boolean canDrag) {
        setAttribute("canDrag", canDrag);
    }
    /**
     * When set to <code>false</code>, this record cannot be dragged. If canDrag is false for any record in the current selection, none of the records will be draggable.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanDrag()  {
        return getAttributeAsBoolean("canDrag");
    }

    /**
    * When set to <code>false</code>, other records cannot be dropped on (i.e., inserted via drag and drop) immediately before this record.
    *
    * @param canAcceptDrop canAcceptDrop Default value is null
    */
    public void setCanAcceptDrop(Boolean canAcceptDrop) {
        setAttribute("canAcceptDrop", canAcceptDrop);
    }
    /**
     * When set to <code>false</code>, other records cannot be dropped on (i.e., inserted via drag and drop) immediately before this record.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanAcceptDrop()  {
        return getAttributeAsBoolean("canAcceptDrop");
    }

    /**
    * The HTML to display in this row for fields with fieldType set to link. This overrides  {@link com.smartgwt.client.widgets.grid.ListGridField#getLinkText linkText}.
    *
    * @param linkText linkText Default value is null
    */
    public void setLinkText(String linkText) {
        setAttribute("linkText", linkText);
    }
    /**
     * The HTML to display in this row for fields with fieldType set to link. This overrides  {@link com.smartgwt.client.widgets.grid.ListGridField#getLinkText linkText}.
     *
     *
     * @return String
     *
     */
    public String getLinkText()  {
        return getAttributeAsString("linkText");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

}



