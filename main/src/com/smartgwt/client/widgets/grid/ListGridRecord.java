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
/* sgwtgen */
 
package com.smartgwt.client.widgets.grid;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.browser.window.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.callbacks.*;
import com.smartgwt.client.tools.*;
import com.smartgwt.client.bean.*;
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
import com.smartgwt.client.widgets.tour.*;
import com.smartgwt.client.widgets.notify.*;
import com.smartgwt.client.widgets.rte.*;
import com.smartgwt.client.widgets.rte.events.*;
import com.smartgwt.client.widgets.ace.*;
import com.smartgwt.client.widgets.ace.events.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.tableview.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;
import com.smartgwt.client.widgets.notify.*;
import com.smartgwt.client.widgets.drawing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gwt.event.shared.*;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.smartgwt.client.util.workflow.Process; // required to override java.lang.Process
import com.smartgwt.client.util.tour.*;


/**
 * 
 *  ListGridRecord represents a JavaScript Object whose properties contain values 
 *  for each {@link com.smartgwt.client.widgets.grid.ListGridField}. A ListGridRecord may have additional properties 
 *  which affect the record's appearance or behavior, or which hold data for use by custom logic 
 *  or other, related components.
 *  <p>
 *  
 *  
 *  For example, if a ListGrid is getting its ListGridFields from the following DataSource definition:
 *  <pre>
 *  &lt;DataSource ... &gt;
 *       &lt;fields&gt;
 *           &lt;field name="field1" ... /&gt;
 *           &lt;field name="field2" ... /&gt;
 *       &lt;/fields&gt;
 *  &lt;/DataSource&gt;
 *  </pre>
 *  
 *  It might have the following data:
 *  <P>
 *  <pre>
 *  data : [
 *      {field1: "foo", field2: "bar", customProperty:5},
 *      {field1: "field1 value", field2: "field2 value", enabled:false}
 *  ]
 *  </pre>
 *  
 *  
 *  The sample data shown above is in JSON format, and might be how data is returned from a REST 
 *  web service.
 *  
 *  <P>
 *  Both records shown above have properties whose names match the name property of a
 *  ListGridField, as well as additional properties. The second record will be disabled due to
 *  <code>enabled:false</code>; the first record has a property "customProperty" which will
 *  have no effect by default but which may be accessed by custom logic.
 *  <P>
 *  
 *  The same records could be constructed in Java like so:
 *  <P>
 *  <pre>
 *  ListGridRecord records[] = new ListGridRecord[2];
 *  records[0] = new ListGridRecord();
 *  records[0].setAttribute("field1", "foo");
 *  records[0].setAttribute("field2", "bar");
 *  records[0].setAttribute("customProperty", 5);
 * 
 *  records[1] = new ListGridRecord();
 *  records[1].setAttribute("field1", "field1 value");
 *  records[1].setAttribute("field2", "field2 value");
 *  records[1].setAttribute("enabled", false);
 *  
 *  RecordList recordList = new RecordList();
 *  recordList.addList(records);
 *  </pre>
 *  
 *  <P>
 *  After a ListGrid is created and has loaded data, records may be accessed via
 *  
 *  {@link com.smartgwt.client.widgets.grid.ListGrid#getDataAsRecordList()},
 *  which will return a {@link com.smartgwt.client.data.ResultSet} (a subclass of
 *  {@link com.smartgwt.client.data.RecordList}) if the listGrid is bound to a DataSource.
 *  
 *  
 *  ListGridRecords are also passed to many events, such as
 *  {@link com.smartgwt.client.widgets.grid.ListGrid#addCellClickHandler cellClick()}.
 *  <P>
 *  A ListGridRecord is a wrapper around
 *  an ordinary JavaScript Object regardless of how the grid's
 *  dataset is loaded (static data, java server, XML web service, etc), 
 *  
 *  
 *  where you have access to its properties via setAttribute() and getAttribute() methods:
 *  <pre>
 *  record.setAttribute("field1", "foo");
 *  String value1 = record.getAttribute("field1");
 *  </pre>
 *  
 *  <P>
 *  Note however that simply assigning a value to a record won't cause the display to be
 * automatically refreshed - {@link com.smartgwt.client.widgets.grid.ListGrid#refreshCell ListGrid.refreshCell()} needs to
 * be called.  Also,
 *  consider {@link com.smartgwt.client.docs.Editing editValues vs saved values} when directly modifying
 *  ListGridRecords.
 *  <P>
 *  See the attributes in the API tab for the full list of special properties on
 *  ListGridRecords that will affect the grid's behavior.
 */
@BeanFactory.FrameworkClass
public class ListGridRecord extends Record {

    public static ListGridRecord getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof ListGridRecord) {
            existingObj.setJsObj(jsObj);
            return (ListGridRecord)existingObj;
        } else

        {
            return new ListGridRecord(jsObj);
        }
    }
        


    public ListGridRecord(){
        
    }

    public ListGridRecord(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Name of a CSS style to use as the {@link com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle ListGrid.baseStyle} for
     * all cells for this particular record. <P> The styleName specified with have suffixes appended to it as the record
     * changes state ("Over", "Selected" and so forth) as described by {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCellStyle ListGrid.getCellStyle()}.  For a single, fixed style for a
     * record, use {@link com.smartgwt.client.widgets.grid.ListGridRecord#getCustomStyle customStyle} instead. <P> See {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCellStyle ListGrid.getCellStyle()} for an overview of various ways to
     * customize styling, both declarative and programmatic. <P> If this property is changed after draw(), to refresh the grid
     * call {@link com.smartgwt.client.widgets.grid.ListGrid#refreshRow ListGrid.refreshRow()} (or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#markForRedraw ListGrid.markForRedraw()} if several rows are being refreshed).
     * <P> If your application's data uses the "_baseStyle" attribute for something else, the property name can be changed via
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getRecordBaseStyleProperty ListGrid.recordBaseStyleProperty}.
     *
     * @param _baseStyle New _baseStyle value. Default value is null
     * @return {@link com.smartgwt.client.widgets.grid.ListGridRecord ListGridRecord} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public ListGridRecord set_baseStyle(String _baseStyle) {
        return (ListGridRecord)setAttribute("_baseStyle", _baseStyle);
    }

    /**
     * Name of a CSS style to use as the {@link com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle ListGrid.baseStyle} for
     * all cells for this particular record. <P> The styleName specified with have suffixes appended to it as the record
     * changes state ("Over", "Selected" and so forth) as described by {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCellStyle ListGrid.getCellStyle()}.  For a single, fixed style for a
     * record, use {@link com.smartgwt.client.widgets.grid.ListGridRecord#getCustomStyle customStyle} instead. <P> See {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCellStyle ListGrid.getCellStyle()} for an overview of various ways to
     * customize styling, both declarative and programmatic. <P> If this property is changed after draw(), to refresh the grid
     * call {@link com.smartgwt.client.widgets.grid.ListGrid#refreshRow ListGrid.refreshRow()} (or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#markForRedraw ListGrid.markForRedraw()} if several rows are being refreshed).
     * <P> If your application's data uses the "_baseStyle" attribute for something else, the property name can be changed via
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getRecordBaseStyleProperty ListGrid.recordBaseStyleProperty}.
     *
     * @return Current _baseStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String get_baseStyle()  {
        return getAttributeAsString("_baseStyle");
    }
    

    /**
     * Default property name denoting whether this record can be edited. Property name may be modified for the grid via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRecordEditProperty ListGrid.recordEditProperty}.
     *
     * @param _canEdit New _canEdit value. Default value is null
     * @return {@link com.smartgwt.client.widgets.grid.ListGridRecord ListGridRecord} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public ListGridRecord set_canEdit(Boolean _canEdit) {
        return (ListGridRecord)setAttribute("_canEdit", _canEdit);
    }

    /**
     * Default property name denoting whether this record can be edited. Property name may be modified for the grid via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRecordEditProperty ListGrid.recordEditProperty}.
     *
     * @return Current _canEdit value. Default value is null
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public Boolean get_canEdit()  {
        return getAttributeAsBoolean("_canEdit", true);
    }
    

    /**
     * Default property name denoting whether this record can be removed. Property name may be modified for the grid via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRecordCanRemoveProperty ListGrid.recordCanRemoveProperty}.
     *
     * @param _canRemove New _canRemove value. Default value is null
     * @return {@link com.smartgwt.client.widgets.grid.ListGridRecord ListGridRecord} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public ListGridRecord set_canRemove(Boolean _canRemove) {
        return (ListGridRecord)setAttribute("_canRemove", _canRemove);
    }

    /**
     * Default property name denoting whether this record can be removed. Property name may be modified for the grid via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRecordCanRemoveProperty ListGrid.recordCanRemoveProperty}.
     *
     * @return Current _canRemove value. Default value is null
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public Boolean get_canRemove()  {
        return getAttributeAsBoolean("_canRemove", true);
    }
    

    /**
     * Has no effect unless {@link com.smartgwt.client.widgets.grid.ListGrid#getShowBackgroundComponents
     * ListGrid.showBackgroundComponents} is <code>true</code>. <P> Canvas created and embedded in the body behind a given
     * record.   When set, either as a Canvas or Canvas Properties, will be constructed if necessary, combined with the
     * autoChild properties specified for {@link com.smartgwt.client.widgets.grid.ListGrid#getBackgroundComponent
     * ListGrid.backgroundComponent} and displayed behind this record in the page's z-order, meaning it will only be visible if
     * the cell styling is transparent.
     *
     * @param backgroundComponent New backgroundComponent value. Default value is null
     * @return {@link com.smartgwt.client.widgets.grid.ListGridRecord ListGridRecord} instance, for chaining setter calls
     */
    public ListGridRecord setBackgroundComponent(Canvas backgroundComponent) {
        return (ListGridRecord)setAttribute("backgroundComponent", backgroundComponent == null ? null : backgroundComponent.getOrCreateJsObj());
    }

    /**
     * Has no effect unless {@link com.smartgwt.client.widgets.grid.ListGrid#getShowBackgroundComponents
     * ListGrid.showBackgroundComponents} is <code>true</code>. <P> Canvas created and embedded in the body behind a given
     * record.   When set, either as a Canvas or Canvas Properties, will be constructed if necessary, combined with the
     * autoChild properties specified for {@link com.smartgwt.client.widgets.grid.ListGrid#getBackgroundComponent
     * ListGrid.backgroundComponent} and displayed behind this record in the page's z-order, meaning it will only be visible if
     * the cell styling is transparent.
     *
     * @return Current backgroundComponent value. Default value is null
     */
    public Canvas getBackgroundComponent()  {
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("backgroundComponent"));
    }
    

    /**
     * When set to <code>false</code>, other records cannot be dropped on (i.e., inserted via drag and drop) immediately before
     * this record.
     *
     * @param canAcceptDrop New canAcceptDrop value. Default value is null
     * @return {@link com.smartgwt.client.widgets.grid.ListGridRecord ListGridRecord} instance, for chaining setter calls
     */
    public ListGridRecord setCanAcceptDrop(Boolean canAcceptDrop) {
        return (ListGridRecord)setAttribute("canAcceptDrop", canAcceptDrop);
    }

    /**
     * When set to <code>false</code>, other records cannot be dropped on (i.e., inserted via drag and drop) immediately before
     * this record.
     *
     * @return Current canAcceptDrop value. Default value is null
     */
    public Boolean getCanAcceptDrop()  {
        return getAttributeAsBoolean("canAcceptDrop", true);
    }
    

    /**
     * When set to <code>false</code>, this record cannot be dragged. If canDrag is false for any record in the current
     * selection, none of the records will be draggable.
     *
     * @param canDrag New canDrag value. Default value is null
     * @return {@link com.smartgwt.client.widgets.grid.ListGridRecord ListGridRecord} instance, for chaining setter calls
     */
    public ListGridRecord setCanDrag(Boolean canDrag) {
        return (ListGridRecord)setAttribute("canDrag", canDrag);
    }

    /**
     * When set to <code>false</code>, this record cannot be dragged. If canDrag is false for any record in the current
     * selection, none of the records will be draggable.
     *
     * @return Current canDrag value. Default value is null
     */
    public Boolean getCanDrag()  {
        return getAttributeAsBoolean("canDrag", true);
    }
    

    /**
     * Default property name denoting whether this record can be expanded. Property name may be modified for the grid via
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getCanExpandRecordProperty ListGrid.canExpandRecordProperty}.
     *
     * @param canExpand New canExpand value. Default value is null
     * @return {@link com.smartgwt.client.widgets.grid.ListGridRecord ListGridRecord} instance, for chaining setter calls
     */
    public ListGridRecord setCanExpand(Boolean canExpand) {
        return (ListGridRecord)setAttribute("canExpand", canExpand);
    }

    /**
     * Default property name denoting whether this record can be expanded. Property name may be modified for the grid via
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getCanExpandRecordProperty ListGrid.canExpandRecordProperty}.
     *
     * @return Current canExpand value. Default value is null
     */
    public Boolean getCanExpand()  {
        return getAttributeAsBoolean("canExpand", true);
    }
    

    /**
     * Default property name denoting whether this record can be selected. Property name may be modified for the grid via
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getRecordCanSelectProperty ListGrid.recordCanSelectProperty}.
     *
     * @param canSelect New canSelect value. Default value is null
     * @return {@link com.smartgwt.client.widgets.grid.ListGridRecord ListGridRecord} instance, for chaining setter calls
     */
    public ListGridRecord setCanSelect(Boolean canSelect) {
        return (ListGridRecord)setAttribute("canSelect", canSelect);
    }

    /**
     * Default property name denoting whether this record can be selected. Property name may be modified for the grid via
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getRecordCanSelectProperty ListGrid.recordCanSelectProperty}.
     *
     * @return Current canSelect value. Default value is null
     */
    public Boolean getCanSelect()  {
        return getAttributeAsBoolean("canSelect", true);
    }
    

    /**
     * Name of a CSS style to use for all cells for this particular record. <P> Note that using this property assigns a single,
     * fixed style to the record, so rollover and selection styling are disabled.  To provide a series of stateful styles for a
     * record use {@link com.smartgwt.client.widgets.grid.ListGridRecord#get_baseStyle _baseStyle} instead. <P> See {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCellStyle ListGrid.getCellStyle()} for an overview of various ways to
     * customize styling, both declarative and programmatic. <P> If this property is changed after draw(), to refresh the grid
     * call {@link com.smartgwt.client.widgets.grid.ListGrid#refreshRow ListGrid.refreshRow()} (or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#markForRedraw ListGrid.markForRedraw()} if several rows are being refreshed).
     * <P> If your application's data uses the "customStyle" attribute for something else, the property name can be changed via
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getRecordCustomStyleProperty ListGrid.recordCustomStyleProperty}.
     *
     * @param customStyle New customStyle value. Default value is null
     * @return {@link com.smartgwt.client.widgets.grid.ListGridRecord ListGridRecord} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public ListGridRecord setCustomStyle(String customStyle) {
        return (ListGridRecord)setAttribute("customStyle", customStyle);
    }

    /**
     * Name of a CSS style to use for all cells for this particular record. <P> Note that using this property assigns a single,
     * fixed style to the record, so rollover and selection styling are disabled.  To provide a series of stateful styles for a
     * record use {@link com.smartgwt.client.widgets.grid.ListGridRecord#get_baseStyle _baseStyle} instead. <P> See {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCellStyle ListGrid.getCellStyle()} for an overview of various ways to
     * customize styling, both declarative and programmatic. <P> If this property is changed after draw(), to refresh the grid
     * call {@link com.smartgwt.client.widgets.grid.ListGrid#refreshRow ListGrid.refreshRow()} (or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#markForRedraw ListGrid.markForRedraw()} if several rows are being refreshed).
     * <P> If your application's data uses the "customStyle" attribute for something else, the property name can be changed via
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getRecordCustomStyleProperty ListGrid.recordCustomStyleProperty}.
     *
     * @return Current customStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getCustomStyle()  {
        return getAttributeAsString("customStyle");
    }
    

    /**
     * The default value of {@link com.smartgwt.client.widgets.grid.ListGrid#getRecordDetailDSProperty
     * ListGrid.recordDetailDSProperty}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param detailDS New detailDS value. Default value is null
     * @return {@link com.smartgwt.client.widgets.grid.ListGridRecord ListGridRecord} instance, for chaining setter calls
     */
    public ListGridRecord setDetailDS(DataSource detailDS) {
        return (ListGridRecord)setAttribute("detailDS", detailDS == null ? null : detailDS.getOrCreateJsObj());
    }

    /**
     * The default value of {@link com.smartgwt.client.widgets.grid.ListGrid#getRecordDetailDSProperty
     * ListGrid.recordDetailDSProperty}.
     *
     * @return Current detailDS value. Default value is null
     */
    public DataSource getDetailDS()  {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("detailDS"));
    }
    

    /**
     * A component that should be rendered on top of this record, similar to a {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponents record component} but statically defined on the
     * record. <p> The embedded component will default to covering all fields of the record, but specific fields can be
     * specified via {@link com.smartgwt.client.widgets.grid.ListGridRecord#getEmbeddedComponentFields
     * embeddedComponentFields}. <p> By default, the embeddedComponent will fill the entire vertical and horizontal space of
     * the record (or of the specified fields).  {@link
     * com.smartgwt.client.widgets.grid.ListGridRecord#getEmbeddedComponentPosition embeddedComponentPosition} can be set to
     * control exact sizing behavior.  <p> When a record with an <code>embeddedComponent</code> is eliminated from view by
     * filtering or because it is not currently rendered due to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowAllRecords incremental rendering}, the ListGrid may {@link
     * com.smartgwt.client.widgets.Canvas#hide Canvas.hide()} or {@link com.smartgwt.client.widgets.Canvas#clear
     * Canvas.clear()} it. <p> If the current dataset is completely replaced (by a call to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setData ListGrid.setData()} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setDataSource ListGrid.setDataSource()}, for example), any embedded component
     * is {@link com.smartgwt.client.widgets.Canvas#deparent deparented} (which implies being {@link
     * com.smartgwt.client.widgets.Canvas#clear clear()ed}). <p> When a ListGrid is {@link
     * com.smartgwt.client.widgets.Canvas#destroy destroyed}, it will destroy() all embedded components regardless of whether
     * they are currently visible.  Use a call to {@link com.smartgwt.client.widgets.grid.ListGrid#setData ListGrid.setData()}
     * immediately before destroying the ListGrid to avoid this effect when unwanted. <p> For more advanced control over the
     * lifecycle of components displayed over records, including deferred creation and pooling, use the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponents record components} subsystem.
     *
     * @param embeddedComponent New embeddedComponent value. Default value is null
     * @return {@link com.smartgwt.client.widgets.grid.ListGridRecord ListGridRecord} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public ListGridRecord setEmbeddedComponent(Canvas embeddedComponent) {
        return (ListGridRecord)setAttribute("embeddedComponent", embeddedComponent == null ? null : embeddedComponent.getOrCreateJsObj());
    }

    /**
     * A component that should be rendered on top of this record, similar to a {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponents record component} but statically defined on the
     * record. <p> The embedded component will default to covering all fields of the record, but specific fields can be
     * specified via {@link com.smartgwt.client.widgets.grid.ListGridRecord#getEmbeddedComponentFields
     * embeddedComponentFields}. <p> By default, the embeddedComponent will fill the entire vertical and horizontal space of
     * the record (or of the specified fields).  {@link
     * com.smartgwt.client.widgets.grid.ListGridRecord#getEmbeddedComponentPosition embeddedComponentPosition} can be set to
     * control exact sizing behavior.  <p> When a record with an <code>embeddedComponent</code> is eliminated from view by
     * filtering or because it is not currently rendered due to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowAllRecords incremental rendering}, the ListGrid may {@link
     * com.smartgwt.client.widgets.Canvas#hide Canvas.hide()} or {@link com.smartgwt.client.widgets.Canvas#clear
     * Canvas.clear()} it. <p> If the current dataset is completely replaced (by a call to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setData ListGrid.setData()} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setDataSource ListGrid.setDataSource()}, for example), any embedded component
     * is {@link com.smartgwt.client.widgets.Canvas#deparent deparented} (which implies being {@link
     * com.smartgwt.client.widgets.Canvas#clear clear()ed}). <p> When a ListGrid is {@link
     * com.smartgwt.client.widgets.Canvas#destroy destroyed}, it will destroy() all embedded components regardless of whether
     * they are currently visible.  Use a call to {@link com.smartgwt.client.widgets.grid.ListGrid#setData ListGrid.setData()}
     * immediately before destroying the ListGrid to avoid this effect when unwanted. <p> For more advanced control over the
     * lifecycle of components displayed over records, including deferred creation and pooling, use the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponents record components} subsystem.
     *
     * @return Current embeddedComponent value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Canvas getEmbeddedComponent()  {
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("embeddedComponent"));
    }
    

    /**
     * Fields where the {@link com.smartgwt.client.widgets.grid.ListGridRecord#getEmbeddedComponent embeddedComponent} will be
     * displayed, if specified. <p> Regardless of the order of fields specified, the component will appear from whichever field
     * is earlier in the current visible order to whichever field is later, inclusive of the specified fields. <p> To have the
     * component appear in just one field, either specify a single-element Array or specific a two element Array with both
     * fields the same. <p> If either field is hidden or invalid (no such field), the component will occupy only a single
     * field.  If both fields are hidden, the component will be hidden until one or more of the fields are shown.
     *
     * @param embeddedComponentFields New embeddedComponentFields value. Default value is null
     * @return {@link com.smartgwt.client.widgets.grid.ListGridRecord ListGridRecord} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public ListGridRecord setEmbeddedComponentFields(String... embeddedComponentFields) {
        return (ListGridRecord)setAttribute("embeddedComponentFields", embeddedComponentFields);
    }

    /**
     * Fields where the {@link com.smartgwt.client.widgets.grid.ListGridRecord#getEmbeddedComponent embeddedComponent} will be
     * displayed, if specified. <p> Regardless of the order of fields specified, the component will appear from whichever field
     * is earlier in the current visible order to whichever field is later, inclusive of the specified fields. <p> To have the
     * component appear in just one field, either specify a single-element Array or specific a two element Array with both
     * fields the same. <p> If either field is hidden or invalid (no such field), the component will occupy only a single
     * field.  If both fields are hidden, the component will be hidden until one or more of the fields are shown.
     *
     * @return Current embeddedComponentFields value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String[] getEmbeddedComponentFields()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("embeddedComponentFields"));
    }
    

    /**
     * Sizing policy applied to the embedded component.  Default behavior if unspecified is the same as {@link
     * com.smartgwt.client.types.EmbeddedPosition} "within" (fill space allocated to the record, including the ability use
     * percentage sizing and snapTo offset).  Use "expand" to have the record expand to accommodate the embedded components'
     * specified sizes instead.
     *
     * @param embeddedComponentPosition New embeddedComponentPosition value. Default value is null
     * @return {@link com.smartgwt.client.widgets.grid.ListGridRecord ListGridRecord} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public ListGridRecord setEmbeddedComponentPosition(EmbeddedPosition embeddedComponentPosition) {
        return (ListGridRecord)setAttribute("embeddedComponentPosition", embeddedComponentPosition == null ? null : embeddedComponentPosition.getValue());
    }

    /**
     * Sizing policy applied to the embedded component.  Default behavior if unspecified is the same as {@link
     * com.smartgwt.client.types.EmbeddedPosition} "within" (fill space allocated to the record, including the ability use
     * percentage sizing and snapTo offset).  Use "expand" to have the record expand to accommodate the embedded components'
     * specified sizes instead.
     *
     * @return Current embeddedComponentPosition value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public EmbeddedPosition getEmbeddedComponentPosition()  {
        return EnumUtil.getEnum(EmbeddedPosition.values(), getAttribute("embeddedComponentPosition"));
    }
    

    /**
     * Default property name denoting whether this record is enabled. Property name may be modified for some grid via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRecordEnabledProperty ListGrid.recordEnabledProperty}.
     *
     * @param enabled New enabled value. Default value is null
     * @return {@link com.smartgwt.client.widgets.grid.ListGridRecord ListGridRecord} instance, for chaining setter calls
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_interaction_disabled_rows" target="examples">Disabled rows Example</a>
     */
    public ListGridRecord setEnabled(Boolean enabled) {
        return (ListGridRecord)setAttribute("enabled", enabled);
    }

    /**
     * Default property name denoting whether this record is enabled. Property name may be modified for some grid via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRecordEnabledProperty ListGrid.recordEnabledProperty}.
     *
     * @return Current enabled value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_interaction_disabled_rows" target="examples">Disabled rows Example</a>
     */
    public Boolean getEnabled()  {
        return getAttributeAsBoolean("enabled", true);
    }
    

    /**
     * If specified as false this record should be ignored when calculating summary totals to be shown in the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary summary row} for this grid. <P> Note that
     * <code>includeInSummary</code> is the default property name for this attribute, but it may be modified via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getIncludeInSummaryProperty ListGrid.includeInSummaryProperty}.
     *
     * @param includeInSummary New includeInSummary value. Default value is null
     * @return {@link com.smartgwt.client.widgets.grid.ListGridRecord ListGridRecord} instance, for chaining setter calls
     */
    public ListGridRecord setIncludeInSummary(Boolean includeInSummary) {
        return (ListGridRecord)setAttribute("includeInSummary", includeInSummary);
    }

    /**
     * If specified as false this record should be ignored when calculating summary totals to be shown in the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary summary row} for this grid. <P> Note that
     * <code>includeInSummary</code> is the default property name for this attribute, but it may be modified via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getIncludeInSummaryProperty ListGrid.includeInSummaryProperty}.
     *
     * @return Current includeInSummary value. Default value is null
     */
    public Boolean getIncludeInSummary()  {
        return getAttributeAsBoolean("includeInSummary", true);
    }
    

    /**
     * This attribute will automatically be set to true for the record representing the grid-level summary row shown if {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary ListGrid.showGridSummary} is true. <P> Note that
     * <code>isGridSummary</code> is the default property name for this attribute but it may be modified by setting {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getGridSummaryRecordProperty ListGrid.gridSummaryRecordProperty}
     *
     * @param isGridSummary New isGridSummary value. Default value is false
     * @return {@link com.smartgwt.client.widgets.grid.ListGridRecord ListGridRecord} instance, for chaining setter calls
     */
    public ListGridRecord setIsGridSummary(Boolean isGridSummary) {
        return (ListGridRecord)setAttribute("isGridSummary", isGridSummary);
    }

    /**
     * This attribute will automatically be set to true for the record representing the grid-level summary row shown if {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary ListGrid.showGridSummary} is true. <P> Note that
     * <code>isGridSummary</code> is the default property name for this attribute but it may be modified by setting {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getGridSummaryRecordProperty ListGrid.gridSummaryRecordProperty}
     *
     * @return Current isGridSummary value. Default value is false
     */
    public Boolean getIsGridSummary()  {
        Boolean result = getAttributeAsBoolean("isGridSummary", true);
        return result == null ? false : result;
    }
    

    /**
     * This attribute will automatically be set to true for records representing group-level summary rows shown if {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary ListGrid.showGroupSummary} is true. <P> Note that
     * <code>isGroupSummary</code> is the default property name for this attribute but it may be modified by setting {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getGroupSummaryRecordProperty ListGrid.groupSummaryRecordProperty}
     *
     * @param isGroupSummary New isGroupSummary value. Default value is false
     * @return {@link com.smartgwt.client.widgets.grid.ListGridRecord ListGridRecord} instance, for chaining setter calls
     */
    public ListGridRecord setIsGroupSummary(Boolean isGroupSummary) {
        return (ListGridRecord)setAttribute("isGroupSummary", isGroupSummary);
    }

    /**
     * This attribute will automatically be set to true for records representing group-level summary rows shown if {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary ListGrid.showGroupSummary} is true. <P> Note that
     * <code>isGroupSummary</code> is the default property name for this attribute but it may be modified by setting {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getGroupSummaryRecordProperty ListGrid.groupSummaryRecordProperty}
     *
     * @return Current isGroupSummary value. Default value is false
     */
    public Boolean getIsGroupSummary()  {
        Boolean result = getAttributeAsBoolean("isGroupSummary", true);
        return result == null ? false : result;
    }
    

    /**
     * Default property name denoting a separator row.<br> When set to <code>true</code>, defines a horizontal separator in the
     * listGrid object. Typically this is specified as the only property of a record object, since a record with
     * <code>isSeparator:true</code> will not display any values.<br> Note: this attribute name is governed by {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getIsSeparatorProperty ListGrid.isSeparatorProperty}.
     *
     * @param isSeparator New isSeparator value. Default value is null
     * @return {@link com.smartgwt.client.widgets.grid.ListGridRecord ListGridRecord} instance, for chaining setter calls
     */
    public ListGridRecord setIsSeparator(Boolean isSeparator) {
        return (ListGridRecord)setAttribute("isSeparator", isSeparator);
    }

    /**
     * Default property name denoting a separator row.<br> When set to <code>true</code>, defines a horizontal separator in the
     * listGrid object. Typically this is specified as the only property of a record object, since a record with
     * <code>isSeparator:true</code> will not display any values.<br> Note: this attribute name is governed by {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getIsSeparatorProperty ListGrid.isSeparatorProperty}.
     *
     * @return Current isSeparator value. Default value is null
     */
    public Boolean getIsSeparator()  {
        return getAttributeAsBoolean("isSeparator", true);
    }
    

    /**
     * The HTML to display in this row for fields with fieldType set to link. This overrides  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getLinkText ListGridField.linkText}.
     *
     * @param linkText New linkText value. Default value is null
     * @return {@link com.smartgwt.client.widgets.grid.ListGridRecord ListGridRecord} instance, for chaining setter calls
     * @see com.smartgwt.client.types.ListGridFieldType
     * @see com.smartgwt.client.types.FieldType
     * @see com.smartgwt.client.widgets.grid.ListGridField#setLinkText
     * @see com.smartgwt.client.widgets.grid.ListGrid#setLinkTextProperty
     */
    public ListGridRecord setLinkText(String linkText) {
        return (ListGridRecord)setAttribute("linkText", linkText);
    }

    /**
     * The HTML to display in this row for fields with fieldType set to link. This overrides  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getLinkText ListGridField.linkText}.
     *
     * @return Current linkText value. Default value is null
     * @see com.smartgwt.client.types.ListGridFieldType
     * @see com.smartgwt.client.types.FieldType
     * @see com.smartgwt.client.widgets.grid.ListGridField#getLinkText
     * @see com.smartgwt.client.widgets.grid.ListGrid#getLinkTextProperty
     */
    public String getLinkText()  {
        return getAttributeAsString("linkText");
    }
    

    /**
     * Set to false to disable rollover for this individual record when {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowRollOver ListGrid.showRollOver} is true. <p> Note this property can be
     * renamed to prevent collision with data members - see {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRecordShowRollOverProperty ListGrid.recordShowRollOverProperty}.
     *
     * @param showRollOver New showRollOver value. Default value is null
     * @return {@link com.smartgwt.client.widgets.grid.ListGridRecord ListGridRecord} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public ListGridRecord setShowRollOver(Boolean showRollOver) {
        return (ListGridRecord)setAttribute("showRollOver", showRollOver);
    }

    /**
     * Set to false to disable rollover for this individual record when {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowRollOver ListGrid.showRollOver} is true. <p> Note this property can be
     * renamed to prevent collision with data members - see {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRecordShowRollOverProperty ListGrid.recordShowRollOverProperty}.
     *
     * @return Current showRollOver value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowRollOver()  {
        return getAttributeAsBoolean("showRollOver", true);
    }
    

    /**
     * Default property name denoting the single value to display for all fields of this row. If this property is set for some
     * record, the record will be displayed as a single cell spanning every column in the grid, with contents set to the value
     * of this property.<br> Note: this attribute name is governed by {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSingleCellValueProperty ListGrid.singleCellValueProperty}.
     *
     * @param singleCellValue New singleCellValue value. Default value is null
     * @return {@link com.smartgwt.client.widgets.grid.ListGridRecord ListGridRecord} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public ListGridRecord setSingleCellValue(String singleCellValue) {
        return (ListGridRecord)setAttribute("singleCellValue", singleCellValue);
    }

    /**
     * Default property name denoting the single value to display for all fields of this row. If this property is set for some
     * record, the record will be displayed as a single cell spanning every column in the grid, with contents set to the value
     * of this property.<br> Note: this attribute name is governed by {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSingleCellValueProperty ListGrid.singleCellValueProperty}.
     *
     * @return Current singleCellValue value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getSingleCellValue()  {
        return getAttributeAsString("singleCellValue");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************



    /**
     * Convenience constructor to build a ListGridRecord from a Record.  If the
     * underlying JavaScriptObject is wrapped by a Record, it will be updated to
     * point to the new ListGridRecord.
     *
     * @param record existing JavaScriptObject wrapper
     * @return a new ListGridRecord
     */
    public ListGridRecord(Record record){
        super(record.getJsObj());
    }

}
