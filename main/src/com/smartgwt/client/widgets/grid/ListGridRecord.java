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
    * A ListGridRecord is a JavaScript Object whose properties contain values for each&#010 ${isc.DocUtils.linkForRef('object:ListGridField')}.  A ListGridRecord may have additional properties which affect the&#010 record's appearance or behavior, or which hold data for use by custom logic or other,&#010 related components.&#010 <p>&#010 For example a ListGrid that defines the following fields:&#010 <pre>&#010 fields : [&#010     {name: "field1"},&#010     {name: "field2"}&#010 ],&#010 </pre>&#010 Might have the following data:&#010 <pre>&#010 data : [&#010     {field1: "foo", field2: "bar", customProperty:5},&#010     {field1: "field1 value", field2: "field2 value", enabled:false}&#010 ]&#010 </pre>&#010 Each line of code in the <code>data</code> array above creates one JavaScript Object via&#010 JavaScript {type:ObjectLiteral,object literal} notation.  These JavaScript Objects are&#010 used as ListGridRecords.&#010 <P>&#010 Both records shown above have properties whose names match the name property of a&#010 ListGridField, as well as additional properties.  The second record will be disabled due to&#010 <code>enabled:false</code>; the first record has a property "customProperty" which will&#010 have no effect by default but which may be accessed by custom logic.&#010 <P>&#010 After a ListGrid is created and has loaded data, records may be accessed via&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getData data}, for example, listGrid.data.get(0) retrieves the first record.&#010 ListGridRecords are also passed to many events, such as&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#addCellClickHandler}.&#010 <P>&#010 A ListGridRecord is always an ordinary JavaScript Object regardless of how the grid's&#010 dataset is loaded (static data, java server, XML web service, etc), and so supports the&#010 normal behaviors of JavaScript Objects, including accessing and assigning to properties&#010 via dot notation:&#010 <pre>&#010     var fieldValue = record.<i>fieldName</i>;&#010     record.<i>fieldName</i> = newValue;&#010 </pre>&#010 <P>&#010 Note however that simply assigning a value to a record won't cause the display to be&#010 automatically refreshed - {@link com.smartgwt.client.widgets.grid.ListGrid#refreshCell} needs to be called.  Also,&#010 consider {@link com.smartgwt.client.docs.Editing 'editValues vs saved values'} when directly modifying&#010 ListGridRecords.&#010 <P>&#010 See the attributes in the API tab for the full list of special properties on&#010 ListGridRecords that will affect the grid's behavior.

    */
public class ListGridRecord extends Record {

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
    * Default property name denoting whether this record is enabled. Property name may be modified&#010 for some grid via {@link com.smartgwt.client.widgets.grid.ListGrid#getRecordEnabledProperty recordEnabledProperty}.
    *
    * @param enabled enabled Default value is null
    */
    public void setEnabled(Boolean enabled) {
        setAttribute("enabled", enabled);
    }
    /**
     * Default property name denoting whether this record is enabled. Property name may be modified&#010 for some grid via {@link com.smartgwt.client.widgets.grid.ListGrid#getRecordEnabledProperty recordEnabledProperty}.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getEnabled()  {
        return getAttributeAsBoolean("enabled");
    }

    /**
    * Default property name denoting a separator row.<br>&#010 When set to <code>true</code>, defines a horizontal separator in the listGrid&#010 object. Typically this is specified as the only property of a record object, since a&#010 record with <code>isSeparator:true</code> will not display any values.<br>&#010 Note: this attribute name is governed by {@link com.smartgwt.client.widgets.grid.ListGrid#getIsSeparatorProperty isSeparatorProperty}.
    *
    * @param isSeparator isSeparator Default value is null
    */
    public void setIsSeparator(Boolean isSeparator) {
        setAttribute("isSeparator", isSeparator);
    }
    /**
     * Default property name denoting a separator row.<br>&#010 When set to <code>true</code>, defines a horizontal separator in the listGrid&#010 object. Typically this is specified as the only property of a record object, since a&#010 record with <code>isSeparator:true</code> will not display any values.<br>&#010 Note: this attribute name is governed by {@link com.smartgwt.client.widgets.grid.ListGrid#getIsSeparatorProperty isSeparatorProperty}.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getIsSeparator()  {
        return getAttributeAsBoolean("isSeparator");
    }

    /**
    * Name of a CSS style to use for all cells for this particular record.  &#010 <P>&#010 Note that using this property assigns a single, fixed style to the record, so rollover&#010 and selection styling are disabled.  To provide a series of stateful styles for a record&#010 use {@link com.smartgwt.client.widgets.grid.ListGridRecord#get_baseStyle _baseStyle} instead.&#010 <P>&#010 See {@link com.smartgwt.client.widgets.grid.ListGrid#getCellStyle} for an overview of various ways to customize styling,&#010 both declarative and programmatic.&#010 <P>&#010 If this property is changed after draw(), to refresh the grid call&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#refreshRow} (or ${isc.DocUtils.linkForRef('listGrid.markForRedraw')} if several rows are&#010 being refreshed).&#010 <P>&#010 If your application's data uses the "customStyle" attribute for something else, the&#010 property name can be changed via {@link com.smartgwt.client.widgets.grid.ListGrid#getRecordCustomStyleProperty recordCustomStyleProperty}.
    *
    * @param customStyle customStyle Default value is null
    */
    public void setCustomStyle(String customStyle) {
        setAttribute("customStyle", customStyle);
    }
    /**
     * Name of a CSS style to use for all cells for this particular record.  &#010 <P>&#010 Note that using this property assigns a single, fixed style to the record, so rollover&#010 and selection styling are disabled.  To provide a series of stateful styles for a record&#010 use {@link com.smartgwt.client.widgets.grid.ListGridRecord#get_baseStyle _baseStyle} instead.&#010 <P>&#010 See {@link com.smartgwt.client.widgets.grid.ListGrid#getCellStyle} for an overview of various ways to customize styling,&#010 both declarative and programmatic.&#010 <P>&#010 If this property is changed after draw(), to refresh the grid call&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#refreshRow} (or ${isc.DocUtils.linkForRef('listGrid.markForRedraw')} if several rows are&#010 being refreshed).&#010 <P>&#010 If your application's data uses the "customStyle" attribute for something else, the&#010 property name can be changed via {@link com.smartgwt.client.widgets.grid.ListGrid#getRecordCustomStyleProperty recordCustomStyleProperty}.
     *
     *
     * @return String
     *
     */
    public String getCustomStyle()  {
        return getAttributeAsString("customStyle");
    }

    /**
    * Name of a CSS style to use as the {@link com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle baseStyle} for all cells for this&#010 particular record.  &#010 <P>&#010 The styleName specified with have suffixes appended to it as the record changes state&#010 ("Over", "Selected" and so forth) as described by {@link com.smartgwt.client.widgets.grid.ListGrid#getCellStyle}.  For a&#010 single, fixed style for a record, use {@link com.smartgwt.client.widgets.grid.ListGridRecord#getCustomStyle customStyle} instead.&#010 <P>&#010 See {@link com.smartgwt.client.widgets.grid.ListGrid#getCellStyle} for an overview of various ways to customize styling,&#010 both declarative and programmatic.&#010 <P>&#010 If this property is changed after draw(), to refresh the grid call&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#refreshRow} (or ${isc.DocUtils.linkForRef('listGrid.markForRedraw')} if several rows are&#010 being refreshed).&#010 <P>&#010 If your application's data uses the "_baseStyle" attribute for something else, the&#010 property name can be changed via {@link com.smartgwt.client.widgets.grid.ListGrid#getRecordBaseStyleProperty recordBaseStyleProperty}.
    *
    * @param _baseStyle _baseStyle Default value is null
    */
    public void set_baseStyle(String _baseStyle) {
        setAttribute("_baseStyle", _baseStyle);
    }
    /**
     * Name of a CSS style to use as the {@link com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle baseStyle} for all cells for this&#010 particular record.  &#010 <P>&#010 The styleName specified with have suffixes appended to it as the record changes state&#010 ("Over", "Selected" and so forth) as described by {@link com.smartgwt.client.widgets.grid.ListGrid#getCellStyle}.  For a&#010 single, fixed style for a record, use {@link com.smartgwt.client.widgets.grid.ListGridRecord#getCustomStyle customStyle} instead.&#010 <P>&#010 See {@link com.smartgwt.client.widgets.grid.ListGrid#getCellStyle} for an overview of various ways to customize styling,&#010 both declarative and programmatic.&#010 <P>&#010 If this property is changed after draw(), to refresh the grid call&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#refreshRow} (or ${isc.DocUtils.linkForRef('listGrid.markForRedraw')} if several rows are&#010 being refreshed).&#010 <P>&#010 If your application's data uses the "_baseStyle" attribute for something else, the&#010 property name can be changed via {@link com.smartgwt.client.widgets.grid.ListGrid#getRecordBaseStyleProperty recordBaseStyleProperty}.
     *
     *
     * @return String
     *
     */
    public String get_baseStyle()  {
        return getAttributeAsString("_baseStyle");
    }

    /**
    * Default property name denoting the single value to display for all fields of this row.&#010 If this property is set for some record, the record will be displayed as a single &#010 cell spanning every column in the grid, with contents set to the value of this&#010 property.<br>&#010 Note: this attribute name is governed by {@link com.smartgwt.client.widgets.grid.ListGrid#getSingleCellValueProperty singleCellValueProperty}.
    *
    * @param singleCellValue singleCellValue Default value is null
    */
    public void setSingleCellValue(String singleCellValue) {
        setAttribute("singleCellValue", singleCellValue);
    }
    /**
     * Default property name denoting the single value to display for all fields of this row.&#010 If this property is set for some record, the record will be displayed as a single &#010 cell spanning every column in the grid, with contents set to the value of this&#010 property.<br>&#010 Note: this attribute name is governed by {@link com.smartgwt.client.widgets.grid.ListGrid#getSingleCellValueProperty singleCellValueProperty}.
     *
     *
     * @return String
     *
     */
    public String getSingleCellValue()  {
        return getAttributeAsString("singleCellValue");
    }

    /**
    * When set to <code>false</code>, this record cannot be dragged. If canDrag is false for&#010 any record in the current selection, none of the records will be draggable.
    *
    * @param canDrag canDrag Default value is null
    */
    public void setCanDrag(Boolean canDrag) {
        setAttribute("canDrag", canDrag);
    }
    /**
     * When set to <code>false</code>, this record cannot be dragged. If canDrag is false for&#010 any record in the current selection, none of the records will be draggable.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanDrag()  {
        return getAttributeAsBoolean("canDrag");
    }

    /**
    * When set to <code>false</code>, other records cannot be dropped on (i.e., inserted&#010 via drag and drop) immediately before this record.
    *
    * @param canAcceptDrop canAcceptDrop Default value is null
    */
    public void setCanAcceptDrop(Boolean canAcceptDrop) {
        setAttribute("canAcceptDrop", canAcceptDrop);
    }
    /**
     * When set to <code>false</code>, other records cannot be dropped on (i.e., inserted&#010 via drag and drop) immediately before this record.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanAcceptDrop()  {
        return getAttributeAsBoolean("canAcceptDrop");
    }

    /**
    * The HTML to display in this row for fields with fieldType set to link. This overrides&#010  {@link com.smartgwt.client.widgets.grid.ListGridField#getLinkText linkText}.
    *
    * @param linkText linkText Default value is null
    */
    public void setLinkText(String linkText) {
        setAttribute("linkText", linkText);
    }
    /**
     * The HTML to display in this row for fields with fieldType set to link. This overrides&#010  {@link com.smartgwt.client.widgets.grid.ListGridField#getLinkText linkText}.
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



