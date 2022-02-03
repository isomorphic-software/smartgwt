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
 
package com.smartgwt.client.data;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
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
import com.smartgwt.client.widgets.drawing.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Metadata about a DataSourceField, including its type and validators.
 */
@BeanFactory.FrameworkClass
public class DataSourceField extends DataClass {

    public static DataSourceField getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new DataSourceField(jsObj);
    }
        


    public DataSourceField(){
        
    }

    public DataSourceField(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    public DataSourceField(String name, FieldType type) {
        setName(name);
		setType(type);
                
    }


    public DataSourceField(String name, FieldType type, String title) {
        setName(name);
		setType(type);
		setTitle(title);
                
    }


    public DataSourceField(String name, FieldType type, String title, int length) {
        setName(name);
		setType(type);
		setTitle(title);
		setLength(length);
                
    }


    public DataSourceField(String name, FieldType type, String title, int length, boolean required     ) {
        setName(name);
		setType(type);
		setTitle(title);
		setLength(length);
		setRequired     (required     );
                
    }


    // ********************* Properties / Attributes ***********************
    
    
    
    
    
    

    /**
     * Dictates whether the data in this field be exported.  Explicitly setting  <i>canExport</i> to false overrides the
     * setting on any component-fields, such as {@link com.smartgwt.client.widgets.grid.ListGridField#getCanExport ListGrid
     * fields}.
     *
     * @param canExport New canExport value. Default value is null
     */
    public void setCanExport(Boolean canExport) {
        setAttribute("canExport", canExport);
    }

    /**
     * Dictates whether the data in this field be exported.  Explicitly setting  <i>canExport</i> to false overrides the
     * setting on any component-fields, such as {@link com.smartgwt.client.widgets.grid.ListGridField#getCanExport ListGrid
     * fields}.
     *
     * @return Current canExport value. Default value is null
     */
    public Boolean getCanExport()  {
        return getAttributeAsBoolean("canExport", true);
    }
    

    /**
     * Should the user be able to filter data by this field? Affects whether this field will show up in dataBoundComponents
     * with UI for filtering data. <P>
     *
     * @param canFilter New canFilter value. Default value is null
     * @see com.smartgwt.client.widgets.form.SearchForm#setShowFilterFieldsOnly
     * @see com.smartgwt.client.widgets.form.SearchForm#setCanEditFieldAttribute
     */
    public void setCanFilter(Boolean canFilter) {
        setAttribute("canFilter", canFilter);
    }

    /**
     * Should the user be able to filter data by this field? Affects whether this field will show up in dataBoundComponents
     * with UI for filtering data. <P>
     *
     * @return Current canFilter value. Default value is null
     * @see com.smartgwt.client.widgets.form.SearchForm#getShowFilterFieldsOnly
     * @see com.smartgwt.client.widgets.form.SearchForm#getCanEditFieldAttribute
     */
    public Boolean getCanFilter()  {
        return getAttributeAsBoolean("canFilter", true);
    }
    

    /**
     * Whether values in this field can be updated and saved to the dataSource. <P> If set to <code>false</code>, this field
     * will default to being non-editable in standard editing components ({@link com.smartgwt.client.widgets.form.DynamicForm},
     * editable {@link com.smartgwt.client.widgets.grid.ListGrid}), but will be editable when displayed for filtering purposes
     * only (in a {@link com.smartgwt.client.widgets.form.SearchForm} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor ListGrid\n filter editor}.  If {@link
     * com.smartgwt.client.data.DataSourceField#getCanEdit canEdit} is explicitly specified it will take  precedence over this
     * client-side behavior, but the server will still enforce the no-save policy (described below). <p> NOTE: If you are using
     * Smart GWT Server and have specified <code>canSave: false</code>  for a field in a DataSource definition
     * (<code>.ds.xml</code> file), this is enforced on  the server.  This means that we will strip out any attempt to set the
     * value of such a  field before trying to process any update or add request, similar to what happens when  a {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#editRequiresAuthentication field-level declarative security check}
     * fails.
     *
     * @param canSave New canSave value. Default value is null
     * @see com.smartgwt.client.docs.ComponentBinding ComponentBinding overview and related methods
     */
    public void setCanSave(Boolean canSave) {
        setAttribute("canSave", canSave);
    }

    /**
     * Whether values in this field can be updated and saved to the dataSource. <P> If set to <code>false</code>, this field
     * will default to being non-editable in standard editing components ({@link com.smartgwt.client.widgets.form.DynamicForm},
     * editable {@link com.smartgwt.client.widgets.grid.ListGrid}), but will be editable when displayed for filtering purposes
     * only (in a {@link com.smartgwt.client.widgets.form.SearchForm} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor ListGrid\n filter editor}.  If {@link
     * com.smartgwt.client.data.DataSourceField#getCanEdit canEdit} is explicitly specified it will take  precedence over this
     * client-side behavior, but the server will still enforce the no-save policy (described below). <p> NOTE: If you are using
     * Smart GWT Server and have specified <code>canSave: false</code>  for a field in a DataSource definition
     * (<code>.ds.xml</code> file), this is enforced on  the server.  This means that we will strip out any attempt to set the
     * value of such a  field before trying to process any update or add request, similar to what happens when  a {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#editRequiresAuthentication field-level declarative security check}
     * fails.
     *
     * @return Current canSave value. Default value is null
     * @see com.smartgwt.client.docs.ComponentBinding ComponentBinding overview and related methods
     */
    public Boolean getCanSave()  {
        return getAttributeAsBoolean("canSave", true);
    }
    

    /**
     * When true, this field can only be used for sorting if the data is entirely client-side.
     *
     * @param canSortClientOnly New canSortClientOnly value. Default value is false
     */
    public void setCanSortClientOnly(boolean canSortClientOnly) {
        setAttribute("canSortClientOnly", canSortClientOnly);
    }

    /**
     * When true, this field can only be used for sorting if the data is entirely client-side.
     *
     * @return Current canSortClientOnly value. Default value is false
     */
    public boolean getCanSortClientOnly()  {
        Boolean result = getAttributeAsBoolean("canSortClientOnly", true);
        return result == null ? false : result;
    }
    

    /**
     * If false, this property indicates that this field is considered "server only".  This means: <ul> <li>Components cannot
     * bind to the field; even if you explicitly add a field with the same      name to your {@link
     * com.smartgwt.client.widgets.DataBoundComponent dataBoundComponent}, it will be dropped</li> <li>If you are using Smart
     * GWT Server, the client will never be sent a value for the      field</li> <li>If you are using Smart GWT Server, then
     * similar to {@link com.smartgwt.client.data.DataSourceField#getCanEdit canEdit}, no updates     to the field are allowed
     * from the client.  If you explicitly add a value for the field      to, eg, a record you are passing to {@link
     * com.smartgwt.client.data.DataSource#updateData DataSource.updateData()}, the server will strip     the value out of the
     * record before processing the update request. </ul> <code>canView:false</code> is <b>not</b> the same thing as {@link
     * com.smartgwt.client.data.DataSourceField#getHidden hidden}.  Use  <code>canView:false</code> when you want to prevent
     * the client from ever seeing a field's  definition or values; use <code>hidden:true</code> if it is fine from a security
     * perspective that a field's definition and values are sent to the browser, but the field should not by default appear in
     * user interface elements (but could do in some cases, like a special screen for advanced users or administrators, for
     * example). <p> Note that this property must be set explicitly to false to have an effect; a null or  undefined setting is
     * treated the same as true. <P> This property is used to implement field-level view security: failing a  {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#viewRequiresAuthentication viewRequiresAuthentication},  {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#viewRequiresRole viewRequiresRole} or {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#viewRequires viewRequires} test is  equivalent to setting
     * <code>canView:false</code> on the field (and, indeed, from the  client's perspective, the field <em>has</em> had
     * <code>canView:false</code> set).
     *
     * @param canView New canView value. Default value is null
     * @see com.smartgwt.client.docs.ComponentBinding ComponentBinding overview and related methods
     */
    public void setCanView(Boolean canView) {
        setAttribute("canView", canView);
    }

    /**
     * If false, this property indicates that this field is considered "server only".  This means: <ul> <li>Components cannot
     * bind to the field; even if you explicitly add a field with the same      name to your {@link
     * com.smartgwt.client.widgets.DataBoundComponent dataBoundComponent}, it will be dropped</li> <li>If you are using Smart
     * GWT Server, the client will never be sent a value for the      field</li> <li>If you are using Smart GWT Server, then
     * similar to {@link com.smartgwt.client.data.DataSourceField#getCanEdit canEdit}, no updates     to the field are allowed
     * from the client.  If you explicitly add a value for the field      to, eg, a record you are passing to {@link
     * com.smartgwt.client.data.DataSource#updateData DataSource.updateData()}, the server will strip     the value out of the
     * record before processing the update request. </ul> <code>canView:false</code> is <b>not</b> the same thing as {@link
     * com.smartgwt.client.data.DataSourceField#getHidden hidden}.  Use  <code>canView:false</code> when you want to prevent
     * the client from ever seeing a field's  definition or values; use <code>hidden:true</code> if it is fine from a security
     * perspective that a field's definition and values are sent to the browser, but the field should not by default appear in
     * user interface elements (but could do in some cases, like a special screen for advanced users or administrators, for
     * example). <p> Note that this property must be set explicitly to false to have an effect; a null or  undefined setting is
     * treated the same as true. <P> This property is used to implement field-level view security: failing a  {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#viewRequiresAuthentication viewRequiresAuthentication},  {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#viewRequiresRole viewRequiresRole} or {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#viewRequires viewRequires} test is  equivalent to setting
     * <code>canView:false</code> on the field (and, indeed, from the  client's perspective, the field <em>has</em> had
     * <code>canView:false</code> set).
     *
     * @return Current canView value. Default value is null
     * @see com.smartgwt.client.docs.ComponentBinding ComponentBinding overview and related methods
     */
    public Boolean getCanView()  {
        return getAttributeAsBoolean("canView", true);
    }
    

    /**
     * If true, this property indicates that this field will hold an explicit array of child nodes  for the current node. This
     * has the same effect as specifying {@link com.smartgwt.client.data.DataSource#getChildrenField DataSource.childrenField}
     * to this field's  name.
     *
     * @param childrenProperty New childrenProperty value. Default value is false
     * @see com.smartgwt.client.data.DataSource#setChildrenField
     * @see com.smartgwt.client.docs.DataSourceRelations DataSourceRelations overview and related methods
     * 
     */
    public void setChildrenProperty(Boolean childrenProperty) {
        setAttribute("childrenProperty", childrenProperty);
    }

    /**
     * If true, this property indicates that this field will hold an explicit array of child nodes  for the current node. This
     * has the same effect as specifying {@link com.smartgwt.client.data.DataSource#getChildrenField DataSource.childrenField}
     * to this field's  name.
     *
     * @return Current childrenProperty value. Default value is false
     * @see com.smartgwt.client.data.DataSource#getChildrenField
     * @see com.smartgwt.client.docs.DataSourceRelations DataSourceRelations overview and related methods
     * 
     */
    public Boolean getChildrenProperty()  {
        Boolean result = getAttributeAsBoolean("childrenProperty", true);
        return result == null ? false : result;
    }
    

    /**
     * For a field that is {@link com.smartgwt.client.data.DataSourceField#getMultiple multiple:"true"}, controls the name of
     * the XML tag used for each subelement during {@link com.smartgwt.client.data.DataSource#xmlSerialize
     * DataSource.xmlSerialize()}. <P> If unset, the default tag name is "value" for a field of simple type, and for a field of
     * DataSource type, is the tagName or ID of the DataSource (as though <code>xmlSerialize()</code> were called on the child
     * DataSource).
     *
     * @param childTagName New childTagName value. Default value is null
     * @see com.smartgwt.client.docs.ComponentSchema ComponentSchema overview and related methods
     */
    public void setChildTagName(String childTagName) {
        setAttribute("childTagName", childTagName);
    }

    /**
     * For a field that is {@link com.smartgwt.client.data.DataSourceField#getMultiple multiple:"true"}, controls the name of
     * the XML tag used for each subelement during {@link com.smartgwt.client.data.DataSource#xmlSerialize
     * DataSource.xmlSerialize()}. <P> If unset, the default tag name is "value" for a field of simple type, and for a field of
     * DataSource type, is the tagName or ID of the DataSource (as though <code>xmlSerialize()</code> were called on the child
     * DataSource).
     *
     * @return Current childTagName value. Default value is null
     * @see com.smartgwt.client.docs.ComponentSchema ComponentSchema overview and related methods
     */
    public String getChildTagName()  {
        return getAttributeAsString("childTagName");
    }
    
    
    

    /**
     * Preferred display format to use for date type values within this field. If this property is set on a field displayed in
     * a databound component such as a {@link com.smartgwt.client.widgets.form.DynamicForm} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid} it will be respected (See {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDateFormatter FormItem.dateFormatter} and {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getDateFormatter ListGridField.dateFormatter}). <P> Note that this
     * property is also honored when exporting directly to  Excel spreadsheets (ie, when using XLS or XLSX/OOXML form,
     * <b>not</b> CSV); "date" and "datetime" fields with this property set will deliver real dates and formatting information
     * to Excel, rather than formatted strings or unformatted dates.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param dateFormatter New dateFormatter value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setDateFormatter(DateDisplayFormat dateFormatter) {
        setAttribute("dateFormatter", dateFormatter == null ? null : dateFormatter.getValue());
    }

    /**
     * Preferred display format to use for date type values within this field. If this property is set on a field displayed in
     * a databound component such as a {@link com.smartgwt.client.widgets.form.DynamicForm} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid} it will be respected (See {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDateFormatter FormItem.dateFormatter} and {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getDateFormatter ListGridField.dateFormatter}). <P> Note that this
     * property is also honored when exporting directly to  Excel spreadsheets (ie, when using XLS or XLSX/OOXML form,
     * <b>not</b> CSV); "date" and "datetime" fields with this property set will deliver real dates and formatting information
     * to Excel, rather than formatted strings or unformatted dates.
     *
     * @return Current dateFormatter value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public DateDisplayFormat getDateFormatter()  {
        return EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("dateFormatter"));
    }
    

    /**
     * Applies only to fields of type "float" and enforces a minimum number of digits shown after the decimal point. <P> For
     * example, a field value of 343.1, 343.104 and 343.09872677 would all be shown as 343.10 if decimalPad is 2. <P> The
     * original unpadded value is always shown when the value is edited.
     *
     * @param decimalPad New decimalPad value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setDecimalPad(Integer decimalPad) {
        setAttribute("decimalPad", decimalPad);
    }

    /**
     * Applies only to fields of type "float" and enforces a minimum number of digits shown after the decimal point. <P> For
     * example, a field value of 343.1, 343.104 and 343.09872677 would all be shown as 343.10 if decimalPad is 2. <P> The
     * original unpadded value is always shown when the value is edited.
     *
     * @return Current decimalPad value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Integer getDecimalPad()  {
        return getAttributeAsInt("decimalPad");
    }
    

    /**
     * Applies only to fields of type "float" and affects how many significant digits are shown. <P> For example, with
     * decimalPrecision 3, if the field value is 343.672677, 343.673 is shown. <P> If the value is 125.2, 125.2 is shown -
     * decimalPrecision will not cause extra zeros to be added.  Use {@link
     * com.smartgwt.client.data.DataSourceField#getDecimalPad decimalPad} for this. <P> A number is always shown with its
     * original precision when edited.
     *
     * @param decimalPrecision New decimalPrecision value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setDecimalPrecision(Integer decimalPrecision) {
        setAttribute("decimalPrecision", decimalPrecision);
    }

    /**
     * Applies only to fields of type "float" and affects how many significant digits are shown. <P> For example, with
     * decimalPrecision 3, if the field value is 343.672677, 343.673 is shown. <P> If the value is 125.2, 125.2 is shown -
     * decimalPrecision will not cause extra zeros to be added.  Use {@link
     * com.smartgwt.client.data.DataSourceField#getDecimalPad decimalPad} for this. <P> A number is always shown with its
     * original precision when edited.
     *
     * @return Current decimalPrecision value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Integer getDecimalPrecision()  {
        return getAttributeAsInt("decimalPrecision");
    }
    

    /**
     * Before we start editing this field in a DataBoundComponent, should we perform a deep clone  of the underlying field
     * value.  See {@link com.smartgwt.client.data.DataSource#getDeepCloneOnEdit DataSource.deepCloneOnEdit} for details of
     * what  this means. <p> If this value is not explicitly set, it defaults first to the value of  {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getDeepCloneOnEdit DataBoundComponent.deepCloneOnEdit}, then to the value
     * of {@link com.smartgwt.client.data.DataSource#getDeepCloneOnEdit DataSource.deepCloneOnEdit}. <p> Like the other
     * <code>deepCloneOnEdit</code> settings, this flag only has an effect if you are  editing a values object that contains
     * nested objects or arrays, using  {@link com.smartgwt.client.widgets.Canvas#getDataPath dataPath}s.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param deepCloneOnEdit New deepCloneOnEdit value. Default value is null
     * @see com.smartgwt.client.widgets.Canvas#setDataPath
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setDataPath
     * @see com.smartgwt.client.data.DataSource#setDeepCloneOnEdit
     */
    public void setDeepCloneOnEdit(Boolean deepCloneOnEdit) {
        setAttribute("deepCloneOnEdit", deepCloneOnEdit);
    }

    /**
     * Before we start editing this field in a DataBoundComponent, should we perform a deep clone  of the underlying field
     * value.  See {@link com.smartgwt.client.data.DataSource#getDeepCloneOnEdit DataSource.deepCloneOnEdit} for details of
     * what  this means. <p> If this value is not explicitly set, it defaults first to the value of  {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getDeepCloneOnEdit DataBoundComponent.deepCloneOnEdit}, then to the value
     * of {@link com.smartgwt.client.data.DataSource#getDeepCloneOnEdit DataSource.deepCloneOnEdit}. <p> Like the other
     * <code>deepCloneOnEdit</code> settings, this flag only has an effect if you are  editing a values object that contains
     * nested objects or arrays, using  {@link com.smartgwt.client.widgets.Canvas#getDataPath dataPath}s.
     *
     * @return Current deepCloneOnEdit value. Default value is null
     * @see com.smartgwt.client.widgets.Canvas#getDataPath
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getDataPath
     * @see com.smartgwt.client.data.DataSource#getDeepCloneOnEdit
     */
    public Boolean getDeepCloneOnEdit()  {
        return getAttributeAsBoolean("deepCloneOnEdit", true);
    }
    

    /**
     * The default search-operator for this field. <P> If not specified, falls back to the default specified for the field's
     * {@link com.smartgwt.client.data.SimpleType#getDefaultOperator data-type}.
     *
     * @param defaultOperator New defaultOperator value. Default value is null
     * @see com.smartgwt.client.docs.AdvancedFilter AdvancedFilter overview and related methods
     */
    public void setDefaultOperator(OperatorId defaultOperator) {
        setAttribute("defaultOperator", defaultOperator == null ? null : defaultOperator.getValue());
    }

    /**
     * The default search-operator for this field. <P> If not specified, falls back to the default specified for the field's
     * {@link com.smartgwt.client.data.SimpleType#getDefaultOperator data-type}.
     *
     * @return Current defaultOperator value. Default value is null
     * @see com.smartgwt.client.docs.AdvancedFilter AdvancedFilter overview and related methods
     */
    public OperatorId getDefaultOperator()  {
        return EnumUtil.getEnum(OperatorId.values(), getAttribute("defaultOperator"));
    }
    

    /**
     * Whether this field should be considered a "detail" field by a {@link com.smartgwt.client.widgets.DataBoundComponent}.
     * <P> Detail fields won't be shown by default in a DataBoundComponent where  {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getShowDetailFields DataBoundComponent.showDetailFields} is false.  This
     * allows for some DataBound components, like a {@link com.smartgwt.client.widgets.grid.ListGrid}, to show a summary view
     * of records which displays only  the most commonly viewed fields by default, while other DataBoundComponents, like a
     * {@link com.smartgwt.client.widgets.viewer.DetailViewer}, show all fields by default. <P> In addition, the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#showIf formItem.showIf} property is supported in multiple components
     * for conditional visibility - see for example {@link com.smartgwt.client.widgets.grid.ListGridField#showIf
     * ListGridField.showIf()} and {@link com.smartgwt.client.widgets.form.fields.FormItem#showIf FormItem.showIf()}).
     *
     * @param detail New detail value. Default value is false
     * @see com.smartgwt.client.docs.ComponentBinding ComponentBinding overview and related methods
     */
    public void setDetail(boolean detail) {
        setAttribute("detail", detail);
    }

    /**
     * Whether this field should be considered a "detail" field by a {@link com.smartgwt.client.widgets.DataBoundComponent}.
     * <P> Detail fields won't be shown by default in a DataBoundComponent where  {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getShowDetailFields DataBoundComponent.showDetailFields} is false.  This
     * allows for some DataBound components, like a {@link com.smartgwt.client.widgets.grid.ListGrid}, to show a summary view
     * of records which displays only  the most commonly viewed fields by default, while other DataBoundComponents, like a
     * {@link com.smartgwt.client.widgets.viewer.DetailViewer}, show all fields by default. <P> In addition, the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#showIf formItem.showIf} property is supported in multiple components
     * for conditional visibility - see for example {@link com.smartgwt.client.widgets.grid.ListGridField#showIf
     * ListGridField.showIf()} and {@link com.smartgwt.client.widgets.form.fields.FormItem#showIf FormItem.showIf()}).
     *
     * @return Current detail value. Default value is false
     * @see com.smartgwt.client.docs.ComponentBinding ComponentBinding overview and related methods
     */
    public boolean getDetail()  {
        Boolean result = getAttributeAsBoolean("detail", true);
        return result == null ? false : result;
    }
    

    /**
     * When records from this dataSource are displayed in a dataBoundComponent such as a {@link
     * com.smartgwt.client.widgets.grid.ListGrid}, the <code>displayField</code> attribute may be used to cause some  field to
     * display a value from another field in the record. <P> This is typically used for editable {@link
     * com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} fields.  In this scenario, a dataSource field has a
     * foreignKey field which stores an ID value used to identify records in another, related dataSource. Rather than display
     * this ID to users, developers may wish to display another, user-friendly field from the related record. This is easy to
     * achieve by  having a second field on the dataSource which will be populated with the "display value" from this related
     * dataSource, and using <code>dataSourceField.displayField</code>  to show this value.  The {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#includeFrom includeFrom} feature handles populating this field
     * automatically for dataSources backed by the {@link com.smartgwt.client.docs.ServerDataIntegration Smart GWT Server}. See
     * the "Editing included fields" section of the {@link com.smartgwt.client.docs.serverds.DataSourceField#includeFrom
     * includeFrom} documentation for more on editing included foreignKey fields. <P> Editable dataSourceFields with a
     * specified <code>displayField</code> and  <code>foreignKey</code> will typically be edited using a {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem}  or {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem}. In
     * this case, in addition to identifying the field to use as a static display value within the record being edited,
     * <code>displayField</code> will also identify which field on the related dataSource to use as a display field when
     * showing a set of options to the user. This behavior may be modified in a couple of ways: <ul>  <li>A separate field name
     * can be specified to identify the display field on the      related dataSource using the {@link
     * com.smartgwt.client.data.DataSourceField#getForeignDisplayField foreignDisplayField} attribute</li>  <li>The {@link
     * com.smartgwt.client.data.DataSourceField#getUseLocalDisplayFieldValue useLocalDisplayFieldValue} attribute may be
     * explicitly      set to false to avoid picking up a display value from the local record altogether.      Instead the
     * displayField will be used only to derive the display value from      a related record from the optionDataSource</li>
     * </ul> For more on how FormItems use the displayField property, see {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField FormItem.displayField}.
     *
     * @param displayField New displayField value. Default value is null
     * @see com.smartgwt.client.docs.DataSourceRelations DataSourceRelations overview and related methods
     */
    public void setDisplayField(String displayField) {
        setAttribute("displayField", displayField);
    }

    /**
     * When records from this dataSource are displayed in a dataBoundComponent such as a {@link
     * com.smartgwt.client.widgets.grid.ListGrid}, the <code>displayField</code> attribute may be used to cause some  field to
     * display a value from another field in the record. <P> This is typically used for editable {@link
     * com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} fields.  In this scenario, a dataSource field has a
     * foreignKey field which stores an ID value used to identify records in another, related dataSource. Rather than display
     * this ID to users, developers may wish to display another, user-friendly field from the related record. This is easy to
     * achieve by  having a second field on the dataSource which will be populated with the "display value" from this related
     * dataSource, and using <code>dataSourceField.displayField</code>  to show this value.  The {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#includeFrom includeFrom} feature handles populating this field
     * automatically for dataSources backed by the {@link com.smartgwt.client.docs.ServerDataIntegration Smart GWT Server}. See
     * the "Editing included fields" section of the {@link com.smartgwt.client.docs.serverds.DataSourceField#includeFrom
     * includeFrom} documentation for more on editing included foreignKey fields. <P> Editable dataSourceFields with a
     * specified <code>displayField</code> and  <code>foreignKey</code> will typically be edited using a {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem}  or {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem}. In
     * this case, in addition to identifying the field to use as a static display value within the record being edited,
     * <code>displayField</code> will also identify which field on the related dataSource to use as a display field when
     * showing a set of options to the user. This behavior may be modified in a couple of ways: <ul>  <li>A separate field name
     * can be specified to identify the display field on the      related dataSource using the {@link
     * com.smartgwt.client.data.DataSourceField#getForeignDisplayField foreignDisplayField} attribute</li>  <li>The {@link
     * com.smartgwt.client.data.DataSourceField#getUseLocalDisplayFieldValue useLocalDisplayFieldValue} attribute may be
     * explicitly      set to false to avoid picking up a display value from the local record altogether.      Instead the
     * displayField will be used only to derive the display value from      a related record from the optionDataSource</li>
     * </ul> For more on how FormItems use the displayField property, see {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisplayField FormItem.displayField}.
     *
     * @return Current displayField value. Default value is null
     * @see com.smartgwt.client.docs.DataSourceRelations DataSourceRelations overview and related methods
     */
    public String getDisplayField()  {
        return getAttributeAsString("displayField");
    }
    
    
    
    
    
    

    /**
     * Text to be used for display by client-side components when this field has a null or  undefined value.  This value will
     * be overridden by a component's emptyCellValue, if set.
     *
     * @param emptyDisplayValue New emptyDisplayValue value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setEmptyDisplayValue
     * @see com.smartgwt.client.widgets.grid.ListGridField#setEmptyCellValue
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setEmptyCellValue
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setEmptyDisplayValue(String emptyDisplayValue) {
        setAttribute("emptyDisplayValue", emptyDisplayValue);
    }

    /**
     * Text to be used for display by client-side components when this field has a null or  undefined value.  This value will
     * be overridden by a component's emptyCellValue, if set.
     *
     * @return Current emptyDisplayValue value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getEmptyDisplayValue
     * @see com.smartgwt.client.widgets.grid.ListGridField#getEmptyCellValue
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getEmptyCellValue
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getEmptyDisplayValue()  {
        return getAttributeAsString("emptyDisplayValue");
    }
    
    

    /**
     * When data values are displayed in DataBound components, by default strings will be interpreted as HTML by the browser in
     * most cases. <P> If set, this property will be picked up by components bound to this dataSource, notifying them that any
     * HTML characters should be escaped when displaying values for this field.
     *
     * @param escapeHTML New escapeHTML value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#setEscapeHTML
     */
    public void setEscapeHTML(Boolean escapeHTML) {
        setAttribute("escapeHTML", escapeHTML);
    }

    /**
     * When data values are displayed in DataBound components, by default strings will be interpreted as HTML by the browser in
     * most cases. <P> If set, this property will be picked up by components bound to this dataSource, notifying them that any
     * HTML characters should be escaped when displaying values for this field.
     *
     * @return Current escapeHTML value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#getEscapeHTML
     */
    public Boolean getEscapeHTML()  {
        return getAttributeAsBoolean("escapeHTML", true);
    }
    

    /**
     * If true, then this field is excluded from the bound component's view state. In addition, the field will not be selected
     * as the default title field by {@link com.smartgwt.client.widgets.DataBoundComponent#getTitleField
     * DataBoundComponent.getTitleField()} if {@link com.smartgwt.client.widgets.DataBoundComponent#getTitleField
     * DataBoundComponent.titleField} is not provided.
     *
     * @param excludeFromState New excludeFromState value. Default value is null
     */
    public void setExcludeFromState(Boolean excludeFromState) {
        setAttribute("excludeFromState", excludeFromState);
    }

    /**
     * If true, then this field is excluded from the bound component's view state. In addition, the field will not be selected
     * as the default title field by {@link com.smartgwt.client.widgets.DataBoundComponent#getTitleField
     * DataBoundComponent.getTitleField()} if {@link com.smartgwt.client.widgets.DataBoundComponent#getTitleField
     * DataBoundComponent.titleField} is not provided.
     *
     * @return Current excludeFromState value. Default value is null
     */
    public Boolean getExcludeFromState()  {
        return getAttributeAsBoolean("excludeFromState", true);
    }
    

    /**
     * When using {@link com.smartgwt.client.data.DataSource#recordsAsText DataSource.recordsAsText()}, determines what
     * approach (if any) should be used to force values to be intepreted as text instead of heuristically parsed as dates,
     * times or other structured types.
     *
     * @param exportForceText New exportForceText value. Default value is false
     * @see com.smartgwt.client.data.TextExportSettings#setForceText
     */
    public void setExportForceText(boolean exportForceText) {
        setAttribute("exportForceText", exportForceText);
    }

    /**
     * When using {@link com.smartgwt.client.data.DataSource#recordsAsText DataSource.recordsAsText()}, determines what
     * approach (if any) should be used to force values to be intepreted as text instead of heuristically parsed as dates,
     * times or other structured types.
     *
     * @return Current exportForceText value. Default value is false
     * @see com.smartgwt.client.data.TextExportSettings#getForceText
     */
    public boolean getExportForceText()  {
        Boolean result = getAttributeAsBoolean("exportForceText", true);
        return result == null ? false : result;
    }
    

    /**
     * An optional {@link com.smartgwt.client.docs.FormatString} for this field, for use when  {@link
     * com.smartgwt.client.widgets.DataBoundComponent#exportData exporting} data to spreadsheet formats (XLS and  OOXML/XLSX),
     * XML, JSON or CSV.   You can use this property to override the normal {@link
     * com.smartgwt.client.data.DataSourceField#getFormat format} of this field, if any, specifically for exports, for both
     * server-based and client-driven exports.  <p> Note, for server-driven exports you can specify default formats for date,
     * time and  datetime fields by specifying properties <code>export.format.default.date</code>, 
     * <code>export.format.default.time</code> and <code>export.format.default.datetime</code> in your
     * <code>server.properties</code> file.  Similarly, default formats for float and integer fields can be specified with
     * <code>export.format.default.float</code> and  <code>export.format.default.integer</code>, respectively.  These formats
     * will be used for fields that do not have a "format" or "exportFormat" property specified in the  <code>.ds.xml</code>
     * file. <p> Specifically when exporting to spreadsheet formats, the <code>FormatString</code> is translated to the type of
     * format string used by spreadsheet programs like Excel.  A handful of features are not present in Excel format strings,
     * and some features behave slightly differently.  These differences are explained below. <p> <h3>Excel cannot handle dates
     * prior to January 1st 1900</h3> This is a well-known limitation of Excel dates; it is not a formatting issue as such. <p>
     * <h3>Currency symbols become fixed to the current locale at export time</h3> The placeholder currency symbol "&#x00A4"
     * (\u00A4) in a numeric format string is rendered as the    localized currency symbol returned by GWT's built-in
     * NumberFormat class.  When exporting, the format string provided to Excel contains the currency symbol for the current
     * locale of the Smart GWT application, and not a placeholder currency symbol that would make Excel pick up a currency
     * symbol based on the operating system locale.  We do this to ensure that the spreadsheet reflects the
     * <em>application's</em> localization, rather than the localization of the current user's computer, because they may be
     * different. <p> <h3>Rounding differences</h3> The approach to rounding a positive number to a set number of decimal
     * places is fairly  universally agreed upon for non-specialized requirements: add 0.5 (or 0.05, or 0.005, or  whatever) to
     * the number and then truncate.  This leads to the well understood convention  that numbers exactly halfway between two
     * possible rounding outcomes, go to the larger one.  So 7.5 becomes 8 and 7.15 becomes 7.2. <p> However, there is no such
     * universal agreement when it come to rounding negative numbers.   Some take the view that you should round by taking the
     * number to the larger absolute value, so -7.15 becomes -7.2.  Others feel that you should round by taking the number to
     * the larger value in the sense of it being "less negative", so -7.15 becomes -7.1. <p> Smart GWT formatting takes the
     * first approach and rounds negative numbers away from zero. We do this simply because that is what Java DecimalFormat
     * does.  Unfortunately, Excel does the opposite.  Therefore, you will see rounding differences on negative numbers on
     * exact  50% boundaries: Smart GWT will format -7.15 as -7.2, while Excel will format the same  value as -7.1. <p>
     * <h3>Different treatment of '#'</h3> Both Smart GWT and Excel use '#' to mean "digit, do not show zeroes".  However,
     * Excel does not implement this strictly in the integer part when the number it is formatting has a value of 0 in the
     * integer part.  So, with a format of "#.##", the value 0.25 is formatted  as "0.25".  Smart GWT (like Java DecimalFormat)
     * is strict: with that format, 0.25 is  formatted as ".25"; if you want to match Excel's output, you must use the format
     * "0.##". <p> <h3>Miscellaneous edge cases</h3> There is quite a lot of variation in behavior between Java DecimalFormat
     * and Excel around  the edges.  For actual error cases - for example, a format string that just contains  nonsense - it is
     * normal and expected that the Smart GWT behavior and the Excel behavior do not match - this is just two systems producing
     * different garbage out for the same  garbage in, which is to be expected.  For valid but weird usages - for example, a
     * format  with multiple percent signs - Smart GWT's formatting is in line with what DecimalFormat  does, unless
     * DecimalFormat throws an Exception, in which case we just do the thing that  seems most sensible, or the thing that was
     * easiest to implement. <p> Known differences in behavior in edge cases include:<ul> <li>Smart GWT ignores formatting
     * characters in the number part of the format string,  whereas Excel rejects the format (this behavior may vary with
     * different releases of Excel and supposedly compatible libraries: POI, for example, will accept such format strings).  
     * If you attempt to format 5.175 with the format string "#b0.#a#", Smart GWT will return "5.72", and Excel will reject the
     * format</li> <li>Smart GWT ignores quoted characters in the number part of the format string,  whereas Excel preserves
     * them.  If you attempt to format 5.175 with the format string  "#'b'0.#'a'#", Smart GWT will return "5.72", and Excel
     * will return "b5.7a2"</li> <li>If you specify the empty string as a format string, Smart GWT returns the result of 
     * calling toString() on the number; Excel uses the built-in "General" format.  These two  approaches will generally give
     * the same or very similar results, but that is really a  coincidence: the correct way to obtain matching results in the
     * browser and the spreadsheet is to specify a valid format string</li> <li>If you specify a format string that contains no
     * number part (ie, no '#' or '0'  characters), Smart GWT does what DecimalFormat does, which is to output the integer part
     * of the number alongside the fixed part of the format.  Excel just outputs the fixed part. So, if you attempt to format
     * -5.3 with the format string "'Hello world'", Smart GWT will output "-Hello world5", whereas Excel will output just
     * "Hello world"</li> <li>If you specify multiple percent signs in the format, Smart GWT treats all but the  first one as
     * static text, so 0.5 formatted with "#%%%" is "50%%%" (ie, all the signs are  preserved but there is only one
     * multiplcation by 100).  Excel multiplies for  each percent sign, so 0.5 formatted with "#%%%" is "500000%%%"</li> </ul>
     * <p> <h3>Date format functionality not supported by Excel</h3> The following date/time/datetime functionality is not
     * supported by Excel; if you use  formatters that use any of this functionality, your values will be exported to Excel 
     * incorrectly formatted.  In cases like this, we recommend that you use a separate  <code>exportFormat</code>, with the
     * intent of exporting your values in a way that is  similar to your application formatting (which would be specified with
     * the  {@link com.smartgwt.client.data.DataSourceField#getFormat format} property), but within the confines of what Excel 
     * supports. <ul> <li>Fiscal year, week and day (LL, LLLL, C, CC, c, cc)</li> <li>Week in year (w, ww)</li> <li>Day in year
     * (D, DD)</li> <li>Day number in week (u)</li> <li>Explicit control over whether to use 12- or 24-hour notation.  In
     * Excel, this is  implied by the presence or absence of the AM/PM designator</li> <li>If the user's operating system
     * locale is different to the locale in use in the  Smart GWT application, day and month names may be different in the
     * spreadsheet</li> </ul> <h3>Number format functionality not supported by Excel</h3> The only Smart GWT number-formatting
     * functionality not supported for  export to Excel is "multiply by 1000 and show as per mille". <p> <h3>Limit on number of
     * custom Excel formats</h3> Excel limits the number of custom format strings in a single spreadsheet to somewhere between
     * 200 and 250, depending on your locale and language.  Hitting this limit in an export would require hundreds of field
     * definitions, each defining unique <code>FormatStrings</code>.  If you do hit the limit, the only workaround is to use
     * fewer unique <code>FormatStrings</code>. <p> <h3>Controlling number format</h3> If we give Excel a formatted number like
     * "500,000" it will not treat that value as a number, so sums and other basic spreadsheet features won't work. So we use
     * the heuristic that if your formatted value parses as a number, you probably want it treated as a number in the
     * spreadsheet, so we give Excel the unformatted numeric value and tell Excel it's a numeric data value. <p> You might
     * expect that we would give Excel <i>both</i> the formatted value and the numeric value, but this is only possible by
     * creating what's called a "custom format" for that cell, which as the section above mentions, is limited in that only a
     * few hundred can be created. <p> With this Excel limitation in mind, it makes sense to just go with the default behavior.
     * If you decide otherwise, one option is to use  {@link
     * com.smartgwt.client.data.DSRequest#getExportNumbersAsFormattedString exportNumbersAsFormattedString}, but see the docs
     * for that property for the drawbacks of doing this.
     *
     * @param exportFormat New exportFormat value. Default value is null
     * @see com.smartgwt.client.data.DataSourceField#setFormat
     * @see com.smartgwt.client.docs.FormatString FormatString 
     */
    public void setExportFormat(String exportFormat) {
        setAttribute("exportFormat", exportFormat);
    }

    /**
     * An optional {@link com.smartgwt.client.docs.FormatString} for this field, for use when  {@link
     * com.smartgwt.client.widgets.DataBoundComponent#exportData exporting} data to spreadsheet formats (XLS and  OOXML/XLSX),
     * XML, JSON or CSV.   You can use this property to override the normal {@link
     * com.smartgwt.client.data.DataSourceField#getFormat format} of this field, if any, specifically for exports, for both
     * server-based and client-driven exports.  <p> Note, for server-driven exports you can specify default formats for date,
     * time and  datetime fields by specifying properties <code>export.format.default.date</code>, 
     * <code>export.format.default.time</code> and <code>export.format.default.datetime</code> in your
     * <code>server.properties</code> file.  Similarly, default formats for float and integer fields can be specified with
     * <code>export.format.default.float</code> and  <code>export.format.default.integer</code>, respectively.  These formats
     * will be used for fields that do not have a "format" or "exportFormat" property specified in the  <code>.ds.xml</code>
     * file. <p> Specifically when exporting to spreadsheet formats, the <code>FormatString</code> is translated to the type of
     * format string used by spreadsheet programs like Excel.  A handful of features are not present in Excel format strings,
     * and some features behave slightly differently.  These differences are explained below. <p> <h3>Excel cannot handle dates
     * prior to January 1st 1900</h3> This is a well-known limitation of Excel dates; it is not a formatting issue as such. <p>
     * <h3>Currency symbols become fixed to the current locale at export time</h3> The placeholder currency symbol "&#x00A4"
     * (\u00A4) in a numeric format string is rendered as the    localized currency symbol returned by GWT's built-in
     * NumberFormat class.  When exporting, the format string provided to Excel contains the currency symbol for the current
     * locale of the Smart GWT application, and not a placeholder currency symbol that would make Excel pick up a currency
     * symbol based on the operating system locale.  We do this to ensure that the spreadsheet reflects the
     * <em>application's</em> localization, rather than the localization of the current user's computer, because they may be
     * different. <p> <h3>Rounding differences</h3> The approach to rounding a positive number to a set number of decimal
     * places is fairly  universally agreed upon for non-specialized requirements: add 0.5 (or 0.05, or 0.005, or  whatever) to
     * the number and then truncate.  This leads to the well understood convention  that numbers exactly halfway between two
     * possible rounding outcomes, go to the larger one.  So 7.5 becomes 8 and 7.15 becomes 7.2. <p> However, there is no such
     * universal agreement when it come to rounding negative numbers.   Some take the view that you should round by taking the
     * number to the larger absolute value, so -7.15 becomes -7.2.  Others feel that you should round by taking the number to
     * the larger value in the sense of it being "less negative", so -7.15 becomes -7.1. <p> Smart GWT formatting takes the
     * first approach and rounds negative numbers away from zero. We do this simply because that is what Java DecimalFormat
     * does.  Unfortunately, Excel does the opposite.  Therefore, you will see rounding differences on negative numbers on
     * exact  50% boundaries: Smart GWT will format -7.15 as -7.2, while Excel will format the same  value as -7.1. <p>
     * <h3>Different treatment of '#'</h3> Both Smart GWT and Excel use '#' to mean "digit, do not show zeroes".  However,
     * Excel does not implement this strictly in the integer part when the number it is formatting has a value of 0 in the
     * integer part.  So, with a format of "#.##", the value 0.25 is formatted  as "0.25".  Smart GWT (like Java DecimalFormat)
     * is strict: with that format, 0.25 is  formatted as ".25"; if you want to match Excel's output, you must use the format
     * "0.##". <p> <h3>Miscellaneous edge cases</h3> There is quite a lot of variation in behavior between Java DecimalFormat
     * and Excel around  the edges.  For actual error cases - for example, a format string that just contains  nonsense - it is
     * normal and expected that the Smart GWT behavior and the Excel behavior do not match - this is just two systems producing
     * different garbage out for the same  garbage in, which is to be expected.  For valid but weird usages - for example, a
     * format  with multiple percent signs - Smart GWT's formatting is in line with what DecimalFormat  does, unless
     * DecimalFormat throws an Exception, in which case we just do the thing that  seems most sensible, or the thing that was
     * easiest to implement. <p> Known differences in behavior in edge cases include:<ul> <li>Smart GWT ignores formatting
     * characters in the number part of the format string,  whereas Excel rejects the format (this behavior may vary with
     * different releases of Excel and supposedly compatible libraries: POI, for example, will accept such format strings).  
     * If you attempt to format 5.175 with the format string "#b0.#a#", Smart GWT will return "5.72", and Excel will reject the
     * format</li> <li>Smart GWT ignores quoted characters in the number part of the format string,  whereas Excel preserves
     * them.  If you attempt to format 5.175 with the format string  "#'b'0.#'a'#", Smart GWT will return "5.72", and Excel
     * will return "b5.7a2"</li> <li>If you specify the empty string as a format string, Smart GWT returns the result of 
     * calling toString() on the number; Excel uses the built-in "General" format.  These two  approaches will generally give
     * the same or very similar results, but that is really a  coincidence: the correct way to obtain matching results in the
     * browser and the spreadsheet is to specify a valid format string</li> <li>If you specify a format string that contains no
     * number part (ie, no '#' or '0'  characters), Smart GWT does what DecimalFormat does, which is to output the integer part
     * of the number alongside the fixed part of the format.  Excel just outputs the fixed part. So, if you attempt to format
     * -5.3 with the format string "'Hello world'", Smart GWT will output "-Hello world5", whereas Excel will output just
     * "Hello world"</li> <li>If you specify multiple percent signs in the format, Smart GWT treats all but the  first one as
     * static text, so 0.5 formatted with "#%%%" is "50%%%" (ie, all the signs are  preserved but there is only one
     * multiplcation by 100).  Excel multiplies for  each percent sign, so 0.5 formatted with "#%%%" is "500000%%%"</li> </ul>
     * <p> <h3>Date format functionality not supported by Excel</h3> The following date/time/datetime functionality is not
     * supported by Excel; if you use  formatters that use any of this functionality, your values will be exported to Excel 
     * incorrectly formatted.  In cases like this, we recommend that you use a separate  <code>exportFormat</code>, with the
     * intent of exporting your values in a way that is  similar to your application formatting (which would be specified with
     * the  {@link com.smartgwt.client.data.DataSourceField#getFormat format} property), but within the confines of what Excel 
     * supports. <ul> <li>Fiscal year, week and day (LL, LLLL, C, CC, c, cc)</li> <li>Week in year (w, ww)</li> <li>Day in year
     * (D, DD)</li> <li>Day number in week (u)</li> <li>Explicit control over whether to use 12- or 24-hour notation.  In
     * Excel, this is  implied by the presence or absence of the AM/PM designator</li> <li>If the user's operating system
     * locale is different to the locale in use in the  Smart GWT application, day and month names may be different in the
     * spreadsheet</li> </ul> <h3>Number format functionality not supported by Excel</h3> The only Smart GWT number-formatting
     * functionality not supported for  export to Excel is "multiply by 1000 and show as per mille". <p> <h3>Limit on number of
     * custom Excel formats</h3> Excel limits the number of custom format strings in a single spreadsheet to somewhere between
     * 200 and 250, depending on your locale and language.  Hitting this limit in an export would require hundreds of field
     * definitions, each defining unique <code>FormatStrings</code>.  If you do hit the limit, the only workaround is to use
     * fewer unique <code>FormatStrings</code>. <p> <h3>Controlling number format</h3> If we give Excel a formatted number like
     * "500,000" it will not treat that value as a number, so sums and other basic spreadsheet features won't work. So we use
     * the heuristic that if your formatted value parses as a number, you probably want it treated as a number in the
     * spreadsheet, so we give Excel the unformatted numeric value and tell Excel it's a numeric data value. <p> You might
     * expect that we would give Excel <i>both</i> the formatted value and the numeric value, but this is only possible by
     * creating what's called a "custom format" for that cell, which as the section above mentions, is limited in that only a
     * few hundred can be created. <p> With this Excel limitation in mind, it makes sense to just go with the default behavior.
     * If you decide otherwise, one option is to use  {@link
     * com.smartgwt.client.data.DSRequest#getExportNumbersAsFormattedString exportNumbersAsFormattedString}, but see the docs
     * for that property for the drawbacks of doing this.
     *
     * @return Current exportFormat value. Default value is null
     * @see com.smartgwt.client.data.DataSourceField#getFormat
     * @see com.smartgwt.client.docs.FormatString FormatString 
     */
    public String getExportFormat()  {
        return getAttributeAsString("exportFormat");
    }
    

    /**
     * Optional different field-title used for exports.
     *
     * @param exportTitle New exportTitle value. Default value is null
     */
    public void setExportTitle(String exportTitle) {
        setAttribute("exportTitle", exportTitle);
    }

    /**
     * Optional different field-title used for exports.
     *
     * @return Current exportTitle value. Default value is null
     */
    public String getExportTitle()  {
        return getAttributeAsString("exportTitle");
    }
    
    
    
    

    /**
     * Name of another field in a separate dataSource that should be used as the display
     *  value for this field in the case where a <code>foreignKey</code> relationship
     *  exists.
     *  <P>
     *  For a general overview on picking up display values from a separate field,
     *  see {@link com.smartgwt.client.data.DataSourceField#getDisplayField displayField} property.
     *  <P>
     *  The <code>foreignDisplayField</code> property is useful for editable fields, where the 
     *  name of the display field within the record being edited differs from the display field 
     *  for related records in the option dataSource.<br>
     *  For example consider a "countryDS" dataSource with the following fields:
     *  <pre>
     *   &lt;field name="id"     type="sequence"   hidden="true"     primaryKey="true" /&gt;
     *   &lt;field name="name"   type="text"       title="Country"   required="true" /&gt;
     *  </pre>
     *  ...and a "city" dataSource which uses a foreignKey relationship identify associated
     *  country records:
     *  <pre>
     *   &lt;field name="id"        type="sequence" hidden="true"   primaryKey="true" /&gt;
     *   &lt;field name="name"      type="text"     title="City"    required="true" /&gt;
     *   &lt;field name="countryId" type="integer"  editorType="SelectItem" 
     *              foreignKey="countryDS.id" 
     *              displayField="countryName" foreignDisplayField="name" title="Country" /&gt;
     *   &lt;field name="countryName" includeFrom="countryDS.name"  hidden="true"   /&gt;
     *  </pre>
     *  A DynamicForm bound to this "city" dataSource would display a SelectItem editor by
     *  default for the country field. The initial display value would be the local value from
     *  the "countryName" field, populated from the related countryDS automatically via the
     *  {@link com.smartgwt.client.docs.serverds.DataSourceField#includeFrom includeFrom} feature.<br>
     *  If the user showed the drop-down list of options for this field, the display values
     *  within that list would be picked up from the "name" field values for the related
     *  "countryDS" records.
     *
     * @param foreignDisplayField New foreignDisplayField value. Default value is null
     * @see com.smartgwt.client.docs.DataSourceRelations DataSourceRelations overview and related methods
     */
    public void setForeignDisplayField(String foreignDisplayField) {
        setAttribute("foreignDisplayField", foreignDisplayField);
    }

    /**
     * Name of another field in a separate dataSource that should be used as the display
     *  value for this field in the case where a <code>foreignKey</code> relationship
     *  exists.
     *  <P>
     *  For a general overview on picking up display values from a separate field,
     *  see {@link com.smartgwt.client.data.DataSourceField#getDisplayField displayField} property.
     *  <P>
     *  The <code>foreignDisplayField</code> property is useful for editable fields, where the 
     *  name of the display field within the record being edited differs from the display field 
     *  for related records in the option dataSource.<br>
     *  For example consider a "countryDS" dataSource with the following fields:
     *  <pre>
     *   &lt;field name="id"     type="sequence"   hidden="true"     primaryKey="true" /&gt;
     *   &lt;field name="name"   type="text"       title="Country"   required="true" /&gt;
     *  </pre>
     *  ...and a "city" dataSource which uses a foreignKey relationship identify associated
     *  country records:
     *  <pre>
     *   &lt;field name="id"        type="sequence" hidden="true"   primaryKey="true" /&gt;
     *   &lt;field name="name"      type="text"     title="City"    required="true" /&gt;
     *   &lt;field name="countryId" type="integer"  editorType="SelectItem" 
     *              foreignKey="countryDS.id" 
     *              displayField="countryName" foreignDisplayField="name" title="Country" /&gt;
     *   &lt;field name="countryName" includeFrom="countryDS.name"  hidden="true"   /&gt;
     *  </pre>
     *  A DynamicForm bound to this "city" dataSource would display a SelectItem editor by
     *  default for the country field. The initial display value would be the local value from
     *  the "countryName" field, populated from the related countryDS automatically via the
     *  {@link com.smartgwt.client.docs.serverds.DataSourceField#includeFrom includeFrom} feature.<br>
     *  If the user showed the drop-down list of options for this field, the display values
     *  within that list would be picked up from the "name" field values for the related
     *  "countryDS" records.
     *
     * @return Current foreignDisplayField value. Default value is null
     * @see com.smartgwt.client.docs.DataSourceRelations DataSourceRelations overview and related methods
     */
    public String getForeignDisplayField()  {
        return getAttributeAsString("foreignDisplayField");
    }
    

    /**
     * Declares that this field holds values that can be matched to values from another DataSource
     *  field, to create a relationship between records from different DataSources or even records
     *  within the same DataSource.
     *  <p>
     *  The format of <code>foreignKey</code> is
     *  <code><i>dataSourceId</i>.<i>fieldName</i></code>.
     *  <p>
     *  For a foreignKey within the same dataSource, you can omit the <code>dataSourceId</code>
     *  and just specify <code><i>fieldName</i></code>.  For example, to create a tree relationship
     *  within a DataSource:
     *  
     *  
     *  <pre>
     *       DataSource supplyItem = new DataSource();
     *       DataSourceField itemId = new DataSourceField();
     *       itemId.setType(FieldType.SEQUENCE);
     *       itemId.setPrimaryKey(true);
     *       DataSourceField parentId = new DataSourceField();
     *       parentId.setType(FieldType.INTEGER);
     *       parentId.setForeignKey("itemId");
     *       supplyItem.setFields(itemId, parentId);
     *  </pre>
     *  
     *  <P>
     *  <code>foreignKey</code> declarations also allow other automatic behaviors by
     * {@link com.smartgwt.client.widgets.DataBoundComponent DataBoundComponents}, such as {@link
     * com.smartgwt.client.widgets.grid.ListGrid#fetchRelatedData ListGrid.fetchRelatedData()}.
     *  <p>
     *  For SQLDataSources foreign keys can be automatically discovered from SQL tables if
     *  {@link com.smartgwt.client.docs.serverds.DataSource#autoDeriveSchema autoDeriveSchema} is set.
     *
     * @param foreignKey New foreignKey value. Default value is false
     * @see com.smartgwt.client.docs.serverds.DataSourceField#joinType
     * @see com.smartgwt.client.docs.DataSourceRelations DataSourceRelations overview and related methods
     */
    public void setForeignKey(String foreignKey) {
        setAttribute("foreignKey", foreignKey);
    }

    /**
     * Declares that this field holds values that can be matched to values from another DataSource
     *  field, to create a relationship between records from different DataSources or even records
     *  within the same DataSource.
     *  <p>
     *  The format of <code>foreignKey</code> is
     *  <code><i>dataSourceId</i>.<i>fieldName</i></code>.
     *  <p>
     *  For a foreignKey within the same dataSource, you can omit the <code>dataSourceId</code>
     *  and just specify <code><i>fieldName</i></code>.  For example, to create a tree relationship
     *  within a DataSource:
     *  
     *  
     *  <pre>
     *       DataSource supplyItem = new DataSource();
     *       DataSourceField itemId = new DataSourceField();
     *       itemId.setType(FieldType.SEQUENCE);
     *       itemId.setPrimaryKey(true);
     *       DataSourceField parentId = new DataSourceField();
     *       parentId.setType(FieldType.INTEGER);
     *       parentId.setForeignKey("itemId");
     *       supplyItem.setFields(itemId, parentId);
     *  </pre>
     *  
     *  <P>
     *  <code>foreignKey</code> declarations also allow other automatic behaviors by
     * {@link com.smartgwt.client.widgets.DataBoundComponent DataBoundComponents}, such as {@link
     * com.smartgwt.client.widgets.grid.ListGrid#fetchRelatedData ListGrid.fetchRelatedData()}.
     *  <p>
     *  For SQLDataSources foreign keys can be automatically discovered from SQL tables if
     *  {@link com.smartgwt.client.docs.serverds.DataSource#autoDeriveSchema autoDeriveSchema} is set.
     *
     * @return Current foreignKey value. Default value is false
     * @see com.smartgwt.client.docs.serverds.DataSourceField#joinType
     * @see com.smartgwt.client.docs.DataSourceRelations DataSourceRelations overview and related methods
     */
    public String getForeignKey()  {
        return getAttributeAsString("foreignKey");
    }
    

    /**
     * Format string to use when rendering the value in any {@link com.smartgwt.client.widgets.DataBoundComponent} or when
     * exporting via {@link com.smartgwt.client.data.DataSource#exportData DataSource.exportData()} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#exportData ListGrid.exportData()} or  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#exportClientData ListGrid.exportClientData()}. <P> Supported for fields of
     * type "date", "time", "datetime", "int", "float" or any derived {@link com.smartgwt.client.data.SimpleType}.  <p> To
     * configure a different format for export, use {@link com.smartgwt.client.data.DataSourceField#getExportFormat
     * exportFormat}. <p> This is a per-field setting; you can alternatively set a default format for all "date", "time" or
     * "datetime" fields via    {@link com.smartgwt.client.util.DateUtil#setNormalDatetimeDisplayFormat
     * DateUtil.setNormalDatetimeDisplayFormat()} and related methods on {@link com.smartgwt.client.util.Date}.  See also
     * {@link com.smartgwt.client.docs.LocalizedNumberFormatting} for built-in {@link com.smartgwt.client.types.FieldType
     * FieldTypes} that handle localized currency formatting. <p> Also note, this property takes precedence over any specified 
     * {@link com.smartgwt.client.data.DataSourceField#getDateFormatter dateFormatter}, but can be overridden on a
     * per-component basis by providing a formatter directly on the component, for example, via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setCellFormatter ListGrid.setCellFormatter()} or {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#formatValue FormItem.formatValue()}.
     *
     * @param format New format value. Default value is null
     * @see com.smartgwt.client.data.DataSourceField#setExportFormat
     * @see com.smartgwt.client.docs.FormatString FormatString 
     */
    public void setFormat(String format) {
        setAttribute("format", format);
    }

    /**
     * Format string to use when rendering the value in any {@link com.smartgwt.client.widgets.DataBoundComponent} or when
     * exporting via {@link com.smartgwt.client.data.DataSource#exportData DataSource.exportData()} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#exportData ListGrid.exportData()} or  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#exportClientData ListGrid.exportClientData()}. <P> Supported for fields of
     * type "date", "time", "datetime", "int", "float" or any derived {@link com.smartgwt.client.data.SimpleType}.  <p> To
     * configure a different format for export, use {@link com.smartgwt.client.data.DataSourceField#getExportFormat
     * exportFormat}. <p> This is a per-field setting; you can alternatively set a default format for all "date", "time" or
     * "datetime" fields via    {@link com.smartgwt.client.util.DateUtil#setNormalDatetimeDisplayFormat
     * DateUtil.setNormalDatetimeDisplayFormat()} and related methods on {@link com.smartgwt.client.util.Date}.  See also
     * {@link com.smartgwt.client.docs.LocalizedNumberFormatting} for built-in {@link com.smartgwt.client.types.FieldType
     * FieldTypes} that handle localized currency formatting. <p> Also note, this property takes precedence over any specified 
     * {@link com.smartgwt.client.data.DataSourceField#getDateFormatter dateFormatter}, but can be overridden on a
     * per-component basis by providing a formatter directly on the component, for example, via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setCellFormatter ListGrid.setCellFormatter()} or {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#formatValue FormItem.formatValue()}.
     *
     * @return Current format value. Default value is null
     * @see com.smartgwt.client.data.DataSourceField#getExportFormat
     * @see com.smartgwt.client.docs.FormatString FormatString 
     */
    public String getFormat()  {
        return getAttributeAsString("format");
    }
    
    

    /**
     * For use in {@link com.smartgwt.client.docs.ComponentSchema}, indicates what group to place the property in when editing
     * in Visual Builder.
     *
     * @param group New group value. Default value is null
     * @see com.smartgwt.client.docs.ComponentSchema ComponentSchema overview and related methods
     */
    public void setGroup(String group) {
        setAttribute("group", group);
    }

    /**
     * For use in {@link com.smartgwt.client.docs.ComponentSchema}, indicates what group to place the property in when editing
     * in Visual Builder.
     *
     * @return Current group value. Default value is null
     * @see com.smartgwt.client.docs.ComponentSchema ComponentSchema overview and related methods
     */
    public String getGroup()  {
        return getAttributeAsString("group");
    }
    

    /**
     * Whether this field should be hidden from users by default within a DataBound component. This is generally used for
     * internal IDs and other fields not meaningful to users. <P> See {@link com.smartgwt.client.data.DataSourceField#getDetail
     * detail} for fields that should be hidden in a summary view such as a {@link com.smartgwt.client.widgets.grid.ListGrid},
     * but still available to the user. <p> <b>NOTE:</b> This property is <b>not</b> a security setting - data for hidden
     * fields is  still delivered to the client, it just isn't shown to the user.  If you wish to make sure  that only
     * appropriate data reaches the client, use {@link com.smartgwt.client.docs.serverds.OperationBinding#outputs
     * OperationBinding.outputs}, {@link com.smartgwt.client.data.DataSourceField#getCanView canView}:false on the field, or a
     * field-level declarative security setting like  {@link com.smartgwt.client.docs.serverds.DataSourceField#viewRequiresRole
     * viewRequiresRole}.
     *
     * @param hidden New hidden value. Default value is false
     * @see com.smartgwt.client.docs.ComponentBinding ComponentBinding overview and related methods
     */
    public void setHidden(boolean hidden) {
        setAttribute("hidden", hidden);
    }

    /**
     * Whether this field should be hidden from users by default within a DataBound component. This is generally used for
     * internal IDs and other fields not meaningful to users. <P> See {@link com.smartgwt.client.data.DataSourceField#getDetail
     * detail} for fields that should be hidden in a summary view such as a {@link com.smartgwt.client.widgets.grid.ListGrid},
     * but still available to the user. <p> <b>NOTE:</b> This property is <b>not</b> a security setting - data for hidden
     * fields is  still delivered to the client, it just isn't shown to the user.  If you wish to make sure  that only
     * appropriate data reaches the client, use {@link com.smartgwt.client.docs.serverds.OperationBinding#outputs
     * OperationBinding.outputs}, {@link com.smartgwt.client.data.DataSourceField#getCanView canView}:false on the field, or a
     * field-level declarative security setting like  {@link com.smartgwt.client.docs.serverds.DataSourceField#viewRequiresRole
     * viewRequiresRole}.
     *
     * @return Current hidden value. Default value is false
     * @see com.smartgwt.client.docs.ComponentBinding ComponentBinding overview and related methods
     */
    public boolean getHidden()  {
        Boolean result = getAttributeAsBoolean("hidden", true);
        return result == null ? false : result;
    }
    
    

    /**
     * <b>NOTE: </b>Only applicable to {@link com.smartgwt.client.data.DataSource#getClientOnly clientOnly} DataSources and the
     * built-in {@link com.smartgwt.client.docs.SqlDataSource SQL}, {@link com.smartgwt.client.docs.JpaIntegration JPA} and 
     * {@link com.smartgwt.client.docs.HibernateIntegration Hibernate} DataSources available in Pro, Power and  Enterprise
     * versions of Smart GWT. <p> Use this flag to inhibit the normal use of {@link com.smartgwt.client.types.TextMatchStyle}
     * for this field.  A  field with this flag set will always be tested for exact equality in generated queries,  even for
     * filter-style queries where normal behavior would be to use a substring match or  similar. <p> Whether or not the exact
     * match is case-sensitive is determined by the DataSource's  {@link
     * com.smartgwt.client.data.DataSource#getIgnoreTextMatchStyleCaseSensitive ignoreTextMatchStyleCaseSensitive} setting.
     *
     * @param ignoreTextMatchStyle New ignoreTextMatchStyle value. Default value is null
     */
    public void setIgnoreTextMatchStyle(Boolean ignoreTextMatchStyle) {
        setAttribute("ignoreTextMatchStyle", ignoreTextMatchStyle);
    }

    /**
     * <b>NOTE: </b>Only applicable to {@link com.smartgwt.client.data.DataSource#getClientOnly clientOnly} DataSources and the
     * built-in {@link com.smartgwt.client.docs.SqlDataSource SQL}, {@link com.smartgwt.client.docs.JpaIntegration JPA} and 
     * {@link com.smartgwt.client.docs.HibernateIntegration Hibernate} DataSources available in Pro, Power and  Enterprise
     * versions of Smart GWT. <p> Use this flag to inhibit the normal use of {@link com.smartgwt.client.types.TextMatchStyle}
     * for this field.  A  field with this flag set will always be tested for exact equality in generated queries,  even for
     * filter-style queries where normal behavior would be to use a substring match or  similar. <p> Whether or not the exact
     * match is case-sensitive is determined by the DataSource's  {@link
     * com.smartgwt.client.data.DataSource#getIgnoreTextMatchStyleCaseSensitive ignoreTextMatchStyleCaseSensitive} setting.
     *
     * @return Current ignoreTextMatchStyle value. Default value is null
     */
    public Boolean getIgnoreTextMatchStyle()  {
        return getAttributeAsBoolean("ignoreTextMatchStyle", true);
    }
    
    
    
    
    
    

    /**
     * For use in {@link com.smartgwt.client.docs.ComponentSchema}, a field {@link
     * com.smartgwt.client.data.DataSource#getInheritsFrom inherited} from another schema can be redeclared with this property
     * set in order to indicate that the property should not be used. <P> This is primarily used to influence {@link
     * com.smartgwt.client.docs.VisualBuilder}.  For simple type properties, this avoids the property appearing in the
     * Component Editor.   <P> For fields that hold subcomponents, this prevents inappropriate drag and drop.  For example, a
     * custom class called <code>MyDialog</code> may automatically create a series of children, and not allow arbitrary other
     * children to be added.  In this case, the inherited property {@link com.smartgwt.client.widgets.Canvas#getChildren
     * Canvas.children} should be marked inapplicable in order to prevent arbitrary components being dropped onto a
     * <code>MyDialog</code> instance.
     *
     * @param inapplicable New inapplicable value. Default value is null
     * @see com.smartgwt.client.docs.ComponentSchema ComponentSchema overview and related methods
     */
    public void setInapplicable(Boolean inapplicable) {
        setAttribute("inapplicable", inapplicable);
    }

    /**
     * For use in {@link com.smartgwt.client.docs.ComponentSchema}, a field {@link
     * com.smartgwt.client.data.DataSource#getInheritsFrom inherited} from another schema can be redeclared with this property
     * set in order to indicate that the property should not be used. <P> This is primarily used to influence {@link
     * com.smartgwt.client.docs.VisualBuilder}.  For simple type properties, this avoids the property appearing in the
     * Component Editor.   <P> For fields that hold subcomponents, this prevents inappropriate drag and drop.  For example, a
     * custom class called <code>MyDialog</code> may automatically create a series of children, and not allow arbitrary other
     * children to be added.  In this case, the inherited property {@link com.smartgwt.client.widgets.Canvas#getChildren
     * Canvas.children} should be marked inapplicable in order to prevent arbitrary components being dropped onto a
     * <code>MyDialog</code> instance.
     *
     * @return Current inapplicable value. Default value is null
     * @see com.smartgwt.client.docs.ComponentSchema ComponentSchema overview and related methods
     */
    public Boolean getInapplicable()  {
        return getAttributeAsBoolean("inapplicable", true);
    }
    
    
    
    
    
    
    
    
    
    

    /**
     * Defines prefix before concatenated values if field is used with  {@link com.smartgwt.client.docs.ServerSummaries Server
     * summaries} feature and the  {@link com.smartgwt.client.types.SummaryFunctionType summary function} is "concat".
     *
     * @param joinPrefix New joinPrefix value. Default value is null
     * @see com.smartgwt.client.data.DataSourceField#setJoinString
     * @see com.smartgwt.client.data.DataSourceField#setJoinSuffix
     * @see com.smartgwt.client.types.SummaryFunction
     * @see com.smartgwt.client.docs.ServerSummaries ServerSummaries overview and related methods
     */
    public void setJoinPrefix(String joinPrefix) {
        setAttribute("joinPrefix", joinPrefix);
    }

    /**
     * Defines prefix before concatenated values if field is used with  {@link com.smartgwt.client.docs.ServerSummaries Server
     * summaries} feature and the  {@link com.smartgwt.client.types.SummaryFunctionType summary function} is "concat".
     *
     * @return Current joinPrefix value. Default value is null
     * @see com.smartgwt.client.data.DataSourceField#getJoinString
     * @see com.smartgwt.client.data.DataSourceField#getJoinSuffix
     * @see com.smartgwt.client.types.SummaryFunction
     * @see com.smartgwt.client.docs.ServerSummaries ServerSummaries overview and related methods
     */
    public String getJoinPrefix()  {
        return getAttributeAsString("joinPrefix");
    }
    

    /**
     * Defines the delimiter between concatenated values if field is used with  {@link com.smartgwt.client.docs.ServerSummaries
     * Server summaries} feature and the  {@link com.smartgwt.client.types.SummaryFunctionType summary function} is "concat".
     * The default  value is ", ".
     *
     * @param joinString New joinString value. Default value is null
     * @see com.smartgwt.client.data.DataSourceField#setJoinPrefix
     * @see com.smartgwt.client.data.DataSourceField#setJoinSuffix
     * @see com.smartgwt.client.types.SummaryFunction
     * @see com.smartgwt.client.docs.ServerSummaries ServerSummaries overview and related methods
     */
    public void setJoinString(String joinString) {
        setAttribute("joinString", joinString);
    }

    /**
     * Defines the delimiter between concatenated values if field is used with  {@link com.smartgwt.client.docs.ServerSummaries
     * Server summaries} feature and the  {@link com.smartgwt.client.types.SummaryFunctionType summary function} is "concat".
     * The default  value is ", ".
     *
     * @return Current joinString value. Default value is null
     * @see com.smartgwt.client.data.DataSourceField#getJoinPrefix
     * @see com.smartgwt.client.data.DataSourceField#getJoinSuffix
     * @see com.smartgwt.client.types.SummaryFunction
     * @see com.smartgwt.client.docs.ServerSummaries ServerSummaries overview and related methods
     */
    public String getJoinString()  {
        return getAttributeAsString("joinString");
    }
    

    /**
     * Defines suffix after concatenated values if field is used with  {@link com.smartgwt.client.docs.ServerSummaries Server
     * summaries} feature and the  {@link com.smartgwt.client.types.SummaryFunctionType summary function} is "concat".
     *
     * @param joinSuffix New joinSuffix value. Default value is null
     * @see com.smartgwt.client.data.DataSourceField#setJoinPrefix
     * @see com.smartgwt.client.data.DataSourceField#setJoinString
     * @see com.smartgwt.client.types.SummaryFunction
     * @see com.smartgwt.client.docs.ServerSummaries ServerSummaries overview and related methods
     */
    public void setJoinSuffix(String joinSuffix) {
        setAttribute("joinSuffix", joinSuffix);
    }

    /**
     * Defines suffix after concatenated values if field is used with  {@link com.smartgwt.client.docs.ServerSummaries Server
     * summaries} feature and the  {@link com.smartgwt.client.types.SummaryFunctionType summary function} is "concat".
     *
     * @return Current joinSuffix value. Default value is null
     * @see com.smartgwt.client.data.DataSourceField#getJoinPrefix
     * @see com.smartgwt.client.data.DataSourceField#getJoinString
     * @see com.smartgwt.client.types.SummaryFunction
     * @see com.smartgwt.client.docs.ServerSummaries ServerSummaries overview and related methods
     */
    public String getJoinSuffix()  {
        return getAttributeAsString("joinSuffix");
    }
    
    

    /**
     * Maximum number of characters allowed.  Applicable only to fields of text type. For fields of this type a {@link
     * com.smartgwt.client.types.ValidatorType length range validator} will be automatically generated on both the client and
     * server side to enforce this maximum length (unless such a validator is explicitly present for the field already). <P>
     * The {@link com.smartgwt.client.widgets.form.fields.TextItem#getEnforceLength TextItem.enforceLength} attribute can also 
     * explicitly limit user input for freeform text items editing fields with an explicit length specified. <P> <b>NOTE:</b>
     * For DataSources of type "sql", this property has a bearing on the type of  column we use when the underlying table is
     * created by a DataSource  {@link com.smartgwt.client.docs.SqlDataSource import} in the {@link
     * com.smartgwt.client.docs.AdminConsole Admin Console}.  Below  a certain length (which is database-specific, see below),
     * we use standard <code>VARCHAR</code> columns; above that length, we use an alternate strategy (again,
     * database-specific).  For  these long fields, we sometimes also generate different SQL for "update" and "add" 
     * operations, using JDBC "?" replacement parameters rather than embedding values directly in  the generated SQL; whether
     * or not this is done depends entirely on what the underlying  database product and/or JDBC driver will allow. <P><br>
     * <b>Table of field length limits for supported databases:</b><p> <table
     * style="font-size:10px;text-align:center;border:1px solid black;"> <tr><td
     * style="color:white;background-color:black;"><b>Database product</b></td>     <td
     * style="color:white;background-color:black;"><b>VARCHAR limit *</b></td>     <td
     * style="color:white;background-color:black;"><b>Type used above limit</b></td></tr>
     * <tr><td>HSQLDB</td><td>None</td><td>-</td></tr> <tr><td>IBM DB2</td><td>4000</td><td>CLOB</td></tr>
     * <tr><td>Firebird</td><td>32767</td><td>BLOB with subtype 1</td></tr> <tr><td>Informix</td><td>255 /
     * 32739</td><td>LVARCHAR / TEXT ** </td></tr> <tr><td> Microsoft SQL Server </td><td>8000</td><td>TEXT</td></tr>
     * <tr><td>MySQL</td><td> 255 / 65535 / 16M </td><td> TEXT / MEDIUMTEXT / LONGTEXT *** </td></tr>
     * <tr><td>Oracle</td><td>4000</td><td>CLOB</td></tr> <tr><td>PostgreSQL</td><td>4000</td><td>TEXT</td></tr> </table><br>
     * <b>*</b> The "VARCHAR limit" referred to here is a limit used by the Smart GWT Server; it is not necessarily imposed by
     * the database.  For example, DB2's VARCHAR limit is not 4000 characters; it actually varies from about 4K to about 32K,
     * depending on how the server has  been configured.<p> <b>**</b> Informix has a limit of just 255 characters for VARCHAR,
     * but has a native LVARCHAR type which supports nearly 32K characters without needing to fall back on long datatypes. 
     * Therefore, with that one product, we have two thresholds for a change in storage type.<p> <b>***</b> MySQL has a limit
     * of 255 characters for VARCHAR, 65,535 characters for TEXT and  16,777,215 for MEDIUMTEXT; therefore, with that one
     * product, we have three thresholds for a  change in storage type.
     *
     * @param length New length value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#setWidth
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_datatypes_longtext" target="examples">Long Text Example</a>
     */
    public void setLength(Integer length) {
        setAttribute("length", length);
    }

    /**
     * Maximum number of characters allowed.  Applicable only to fields of text type. For fields of this type a {@link
     * com.smartgwt.client.types.ValidatorType length range validator} will be automatically generated on both the client and
     * server side to enforce this maximum length (unless such a validator is explicitly present for the field already). <P>
     * The {@link com.smartgwt.client.widgets.form.fields.TextItem#getEnforceLength TextItem.enforceLength} attribute can also 
     * explicitly limit user input for freeform text items editing fields with an explicit length specified. <P> <b>NOTE:</b>
     * For DataSources of type "sql", this property has a bearing on the type of  column we use when the underlying table is
     * created by a DataSource  {@link com.smartgwt.client.docs.SqlDataSource import} in the {@link
     * com.smartgwt.client.docs.AdminConsole Admin Console}.  Below  a certain length (which is database-specific, see below),
     * we use standard <code>VARCHAR</code> columns; above that length, we use an alternate strategy (again,
     * database-specific).  For  these long fields, we sometimes also generate different SQL for "update" and "add" 
     * operations, using JDBC "?" replacement parameters rather than embedding values directly in  the generated SQL; whether
     * or not this is done depends entirely on what the underlying  database product and/or JDBC driver will allow. <P><br>
     * <b>Table of field length limits for supported databases:</b><p> <table
     * style="font-size:10px;text-align:center;border:1px solid black;"> <tr><td
     * style="color:white;background-color:black;"><b>Database product</b></td>     <td
     * style="color:white;background-color:black;"><b>VARCHAR limit *</b></td>     <td
     * style="color:white;background-color:black;"><b>Type used above limit</b></td></tr>
     * <tr><td>HSQLDB</td><td>None</td><td>-</td></tr> <tr><td>IBM DB2</td><td>4000</td><td>CLOB</td></tr>
     * <tr><td>Firebird</td><td>32767</td><td>BLOB with subtype 1</td></tr> <tr><td>Informix</td><td>255 /
     * 32739</td><td>LVARCHAR / TEXT ** </td></tr> <tr><td> Microsoft SQL Server </td><td>8000</td><td>TEXT</td></tr>
     * <tr><td>MySQL</td><td> 255 / 65535 / 16M </td><td> TEXT / MEDIUMTEXT / LONGTEXT *** </td></tr>
     * <tr><td>Oracle</td><td>4000</td><td>CLOB</td></tr> <tr><td>PostgreSQL</td><td>4000</td><td>TEXT</td></tr> </table><br>
     * <b>*</b> The "VARCHAR limit" referred to here is a limit used by the Smart GWT Server; it is not necessarily imposed by
     * the database.  For example, DB2's VARCHAR limit is not 4000 characters; it actually varies from about 4K to about 32K,
     * depending on how the server has  been configured.<p> <b>**</b> Informix has a limit of just 255 characters for VARCHAR,
     * but has a native LVARCHAR type which supports nearly 32K characters without needing to fall back on long datatypes. 
     * Therefore, with that one product, we have two thresholds for a change in storage type.<p> <b>***</b> MySQL has a limit
     * of 255 characters for VARCHAR, 65,535 characters for TEXT and  16,777,215 for MEDIUMTEXT; therefore, with that one
     * product, we have three thresholds for a  change in storage type.
     *
     * @return Current length value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#getWidth
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_datatypes_longtext" target="examples">Long Text Example</a>
     */
    public Integer getLength()  {
        return getAttributeAsInt("length");
    }
    

    /**
     * Indicates that getting {@link com.smartgwt.client.data.DataSourceField#getValueXPath valueXPath} for this field should
     * not perform any validation at all and will return null for non existing XPaths. Otherwise warning message will be logged
     * for non-existing XPath or with null objects in the middle of XPath. <P> NOTE: this applies to server-side processing of
     * valueXPath only.
     *
     * @param lenientXPath New lenientXPath value. Default value is null
     * @deprecated No longer needs to be set since the framework now defaults to suppressing errors  for null values in the middle of
     * Xpath, and only invalid XPath will cause warning be logged.
     */
    public void setLenientXPath(Boolean lenientXPath) {
        setAttribute("lenientXPath", lenientXPath);
    }

    /**
     * Indicates that getting {@link com.smartgwt.client.data.DataSourceField#getValueXPath valueXPath} for this field should
     * not perform any validation at all and will return null for non existing XPaths. Otherwise warning message will be logged
     * for non-existing XPath or with null objects in the middle of XPath. <P> NOTE: this applies to server-side processing of
     * valueXPath only.
     *
     * @return Current lenientXPath value. Default value is null
     * @deprecated No longer needs to be set since the framework now defaults to suppressing errors  for null values in the middle of
     * Xpath, and only invalid XPath will cause warning be logged.
     */
    public Boolean getLenientXPath()  {
        return getAttributeAsBoolean("lenientXPath", true);
    }
    
    
    

    /**
     * Indicates that this field should always be Array-valued.  If the value derived from
     *  {@link com.smartgwt.client.data.DataSource#getDataFormat XML or JSON data} is singular, it will be wrapped in an Array.
     *  <p>
     *  JPA and Hibernate DataSources use <code>multiple:true</code> as part of the declaration of
     *  One-To-Many and Many-to-Many relations - see {@link com.smartgwt.client.docs.JpaHibernateRelations} for details.
     *  <p>
     *  <h4>Criteria on multiple:true fields: client-side filtering</h4>
     *  <p>
     *  For simple Criteria, the criteria value is compared to <i>each</i> field value in the
     *  <code>multiple:true</code> field, according to the
     *  {@link com.smartgwt.client.data.DSRequest#getTextMatchStyle textMatchStyle}.  If <i>any</i> field value matches the
     *  filter value, the field is considered to match the criteria.
     *  <p>
     * For {@link com.smartgwt.client.data.AdvancedCriteria}, for normal {@link com.smartgwt.client.types.OperatorId search
     * operators} the field
     *  value is considered as matching the <code>Criterion</code> if <i>any</i> of the field values
     *  match the Criterion.  Specifically, this is true of all operators that have an 
     *  {@link com.smartgwt.client.types.OperatorValueType operatorValueType} of "fieldType" or "valueRange".
     *  <p>
     *  For operators that compare against other fields in same record, such as "equalsField", 
     *  if the other field is <i>not</i> <code>multiple:true</code>, matching works the same as for
     *  normal operators, that is, as if <code>criterion.value</code> directly contained the value
     *  rather than the name of another field.
     *  <p>
     *  If the other field is <i>also</i> multiple:true, only "equalsField", "notEqualsField",
     *  "iEqualsField" and "iNotEqualsField" are allowed (any other <code>operator</code> will
     *  cause a warning and be ignored) and the set of values in the field must be identical (aside
     *  from case, for operators prefixed with "i") and in identical order to match.
     *  <p>
     *  For the <code>inSet</code> operator, the field matches if there is any intersection between
     *  the field values and the array of values provided in <code>criterion.value</code>.
     *  <code>notInSet</code> is the reverse.
     *  <p>
     *  Finally, for "isBlank", "notBlank", "isNull" and "notNull", an empty Array is considered non-null.  For example,
     *  if you use dataFormat:"json" and the field value is provided to the browser as
     *  <code>[]</code> (JSON for an empty Array), the field is considered non-null.
     *  <p>
     *  <h4>Server-side Representation and Storage</h4>
     *  <p>
     *  Values for multiple:true fields appear as Java Lists when received in server code such as a
     *  DMI.  The Smart GWT Server supports simple storage of values that are multiple:true, controlled
     *  via the {@link com.smartgwt.client.docs.serverds.DataSourceField#multipleStorage multipleStorage} setting.
     *  <p>
     *  For server-side behavior of JPA and Hibernate relation fields that are multiple:true, see
     *  {@link com.smartgwt.client.docs.JpaHibernateRelations}.
     *  <p>
     *  For non-relation fields, the Smart GWT Server supports simple storage of values that are
     * multiple:true, controlled via the {@link com.smartgwt.client.docs.serverds.DataSourceField#multipleStorage
     * multipleStorage} setting, with some limited support
     * for server-side filtering, as described in the {@link com.smartgwt.client.docs.serverds.DataSourceField#multipleStorage
     * multipleStorage} docs.
     *  <p>
     *  For the built-in SQL, Hibernate and JPA connectors, if criteria are specified for a
     *  multiple:true field where <code>multipleStorage</code> is null or "none", the Smart GWT
     *  server knows nothing about how the multiple values are stored, so as a fallback the criteria
     *  will operate as though the field were a normal, non-multiple "text" field.  This will
     *  generally <b>not</b> match the client-side filtering behavior described above, so filtering
     *  should either be performed entirely on the client (for example, via
     *  {@link com.smartgwt.client.widgets.grid.ListGrid#getDataFetchMode dataFetchMode:"local"} or entirely on the server (via
     *  {@link com.smartgwt.client.data.ResultSet#getUseClientFiltering ResultSet.useClientFiltering}:"false")
     *  <p>
     *  The server-side filtering is done through a criteria transform which happens with
     *  {@link com.smartgwt.client.docs.serverds.DataSource#transformMultipleFields transformMultipleFields}.
     *  <p>
     *  <h4>XML Serialization</h4>
     *  <P>
     *  Specifically for XML serialization and deserialization, <code>multiple:true</code> behaves
     *  similarly to the 
     *  <a href='http://www.google.com/search?hl=en&q=soap+array' target='_blank'>SOAP array idiom</a>, that is,
     *  there will be a "wrapper element" named after the field name, whose contents will be several
     *  elements of the specified {@link com.smartgwt.client.data.DataSourceField#getType field.type}.  
     *  <P>
     * For example, {@link com.smartgwt.client.widgets.layout.Layout#getMembers Layout.members} is declared with
     * <code>type:"Canvas",
     *  multiple:true</code>.  The correct XML format is thus:
     *  <pre>
     *  &lt;VLayout&gt;
     *      &lt;members&gt;
     *          &lt;Canvas ID="myCanvas" ... /&gt;
     *          &lt;ListGrid ID="myGrid" .../&gt;
     *          &lt;Toolstrip ID="myToolStrip" ... /&gt;
     *      &lt;/members&gt;
     *  &lt;/VLayout&gt;
     *  </pre>
     *  <P>
     * See {@link com.smartgwt.client.data.DataSourceField#getChildTagName childTagName} for customizing the tagName used for
     * subelements.
     *
     * @param multiple New multiple value. Default value is false
     * @see com.smartgwt.client.docs.ComponentSchema ComponentSchema overview and related methods
     */
    public void setMultiple(Boolean multiple) {
        setAttribute("multiple", multiple);
    }

    /**
     * Indicates that this field should always be Array-valued.  If the value derived from
     *  {@link com.smartgwt.client.data.DataSource#getDataFormat XML or JSON data} is singular, it will be wrapped in an Array.
     *  <p>
     *  JPA and Hibernate DataSources use <code>multiple:true</code> as part of the declaration of
     *  One-To-Many and Many-to-Many relations - see {@link com.smartgwt.client.docs.JpaHibernateRelations} for details.
     *  <p>
     *  <h4>Criteria on multiple:true fields: client-side filtering</h4>
     *  <p>
     *  For simple Criteria, the criteria value is compared to <i>each</i> field value in the
     *  <code>multiple:true</code> field, according to the
     *  {@link com.smartgwt.client.data.DSRequest#getTextMatchStyle textMatchStyle}.  If <i>any</i> field value matches the
     *  filter value, the field is considered to match the criteria.
     *  <p>
     * For {@link com.smartgwt.client.data.AdvancedCriteria}, for normal {@link com.smartgwt.client.types.OperatorId search
     * operators} the field
     *  value is considered as matching the <code>Criterion</code> if <i>any</i> of the field values
     *  match the Criterion.  Specifically, this is true of all operators that have an 
     *  {@link com.smartgwt.client.types.OperatorValueType operatorValueType} of "fieldType" or "valueRange".
     *  <p>
     *  For operators that compare against other fields in same record, such as "equalsField", 
     *  if the other field is <i>not</i> <code>multiple:true</code>, matching works the same as for
     *  normal operators, that is, as if <code>criterion.value</code> directly contained the value
     *  rather than the name of another field.
     *  <p>
     *  If the other field is <i>also</i> multiple:true, only "equalsField", "notEqualsField",
     *  "iEqualsField" and "iNotEqualsField" are allowed (any other <code>operator</code> will
     *  cause a warning and be ignored) and the set of values in the field must be identical (aside
     *  from case, for operators prefixed with "i") and in identical order to match.
     *  <p>
     *  For the <code>inSet</code> operator, the field matches if there is any intersection between
     *  the field values and the array of values provided in <code>criterion.value</code>.
     *  <code>notInSet</code> is the reverse.
     *  <p>
     *  Finally, for "isBlank", "notBlank", "isNull" and "notNull", an empty Array is considered non-null.  For example,
     *  if you use dataFormat:"json" and the field value is provided to the browser as
     *  <code>[]</code> (JSON for an empty Array), the field is considered non-null.
     *  <p>
     *  <h4>Server-side Representation and Storage</h4>
     *  <p>
     *  Values for multiple:true fields appear as Java Lists when received in server code such as a
     *  DMI.  The Smart GWT Server supports simple storage of values that are multiple:true, controlled
     *  via the {@link com.smartgwt.client.docs.serverds.DataSourceField#multipleStorage multipleStorage} setting.
     *  <p>
     *  For server-side behavior of JPA and Hibernate relation fields that are multiple:true, see
     *  {@link com.smartgwt.client.docs.JpaHibernateRelations}.
     *  <p>
     *  For non-relation fields, the Smart GWT Server supports simple storage of values that are
     * multiple:true, controlled via the {@link com.smartgwt.client.docs.serverds.DataSourceField#multipleStorage
     * multipleStorage} setting, with some limited support
     * for server-side filtering, as described in the {@link com.smartgwt.client.docs.serverds.DataSourceField#multipleStorage
     * multipleStorage} docs.
     *  <p>
     *  For the built-in SQL, Hibernate and JPA connectors, if criteria are specified for a
     *  multiple:true field where <code>multipleStorage</code> is null or "none", the Smart GWT
     *  server knows nothing about how the multiple values are stored, so as a fallback the criteria
     *  will operate as though the field were a normal, non-multiple "text" field.  This will
     *  generally <b>not</b> match the client-side filtering behavior described above, so filtering
     *  should either be performed entirely on the client (for example, via
     *  {@link com.smartgwt.client.widgets.grid.ListGrid#getDataFetchMode dataFetchMode:"local"} or entirely on the server (via
     *  {@link com.smartgwt.client.data.ResultSet#getUseClientFiltering ResultSet.useClientFiltering}:"false")
     *  <p>
     *  The server-side filtering is done through a criteria transform which happens with
     *  {@link com.smartgwt.client.docs.serverds.DataSource#transformMultipleFields transformMultipleFields}.
     *  <p>
     *  <h4>XML Serialization</h4>
     *  <P>
     *  Specifically for XML serialization and deserialization, <code>multiple:true</code> behaves
     *  similarly to the 
     *  <a href='http://www.google.com/search?hl=en&q=soap+array' target='_blank'>SOAP array idiom</a>, that is,
     *  there will be a "wrapper element" named after the field name, whose contents will be several
     *  elements of the specified {@link com.smartgwt.client.data.DataSourceField#getType field.type}.  
     *  <P>
     * For example, {@link com.smartgwt.client.widgets.layout.Layout#getMembers Layout.members} is declared with
     * <code>type:"Canvas",
     *  multiple:true</code>.  The correct XML format is thus:
     *  <pre>
     *  &lt;VLayout&gt;
     *      &lt;members&gt;
     *          &lt;Canvas ID="myCanvas" ... /&gt;
     *          &lt;ListGrid ID="myGrid" .../&gt;
     *          &lt;Toolstrip ID="myToolStrip" ... /&gt;
     *      &lt;/members&gt;
     *  &lt;/VLayout&gt;
     *  </pre>
     *  <P>
     * See {@link com.smartgwt.client.data.DataSourceField#getChildTagName childTagName} for customizing the tagName used for
     * subelements.
     *
     * @return Current multiple value. Default value is false
     * @see com.smartgwt.client.docs.ComponentSchema ComponentSchema overview and related methods
     */
    public Boolean getMultiple()  {
        Boolean result = getAttributeAsBoolean("multiple", true);
        return result == null ? false : result;
    }
    
    
    

    /**
     * For fields that are {@link com.smartgwt.client.data.DataSourceField#getMultiple multiple:true}, the separator used 
     * between values when they are displayed.
     *
     * @param multipleValueSeparator New multipleValueSeparator value. Default value is ", "
     */
    public void setMultipleValueSeparator(String multipleValueSeparator) {
        setAttribute("multipleValueSeparator", multipleValueSeparator);
    }

    /**
     * For fields that are {@link com.smartgwt.client.data.DataSourceField#getMultiple multiple:true}, the separator used 
     * between values when they are displayed.
     *
     * @return Current multipleValueSeparator value. Default value is ", "
     */
    public String getMultipleValueSeparator()  {
        return getAttributeAsString("multipleValueSeparator");
    }
    

    /**
     * Name for this field.   <P> Must be unique across all fields within the DataSource as well as a valid JavaScript
     * identifier - see {@link com.smartgwt.client.docs.FieldName} for details and how to check for validity. <P> The field
     * name is also the property in each DataSource record which holds the value for this field.
     *
     * @param name New name value. Default value is null
     * @see com.smartgwt.client.docs.FieldName FieldName 
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public void setName(String name) {
        setAttribute("name", name);
    }

    /**
     * Name for this field.   <P> Must be unique across all fields within the DataSource as well as a valid JavaScript
     * identifier - see {@link com.smartgwt.client.docs.FieldName} for details and how to check for validity. <P> The field
     * name is also the property in each DataSource record which holds the value for this field.
     *
     * @return Current name value. Default value is null
     * @see com.smartgwt.client.docs.FieldName FieldName 
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public String getName()  {
        return getAttributeAsString("name");
    }
    

    /**
     * Controls whether an explicit null-valued Record attribute for this field
     *  should result in <code>xsi:nil</code> being used to transmit the value when serializing
     *  to XML, like so:
     *  <pre>
     *  &lt;book&gt;
     *      &lt;title&gt;Beowulf&lt;/title&gt;
     *      &lt;author xsi:nil="true"/&gt;
     *  &lt;/book&gt;
     *  </pre>
     *  If <code>nillable</code> is not set, no XML element will be generated for
     *  the explicit null value.
     *
     * @param nillable New nillable value. Default value is null
     */
    public void setNillable(Boolean nillable) {
        setAttribute("nillable", nillable);
    }

    /**
     * Controls whether an explicit null-valued Record attribute for this field
     *  should result in <code>xsi:nil</code> being used to transmit the value when serializing
     *  to XML, like so:
     *  <pre>
     *  &lt;book&gt;
     *      &lt;title&gt;Beowulf&lt;/title&gt;
     *      &lt;author xsi:nil="true"/&gt;
     *  &lt;/book&gt;
     *  </pre>
     *  If <code>nillable</code> is not set, no XML element will be generated for
     *  the explicit null value.
     *
     * @return Current nillable value. Default value is null
     */
    public Boolean getNillable()  {
        return getAttributeAsBoolean("nillable", true);
    }
    
    

    /**
     * Applies only to fields of type "float" or "integer" and affects how many significant digits are shown. <P> For example,
     * a field value of 343.1, 343.104 and 343.09872677 would all be shown as 343.10 if precision is 5. <P> The original value
     * is always shown when the value is edited.
     *
     * @param precision New precision value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setPrecision(Integer precision) {
        setAttribute("precision", precision);
    }

    /**
     * Applies only to fields of type "float" or "integer" and affects how many significant digits are shown. <P> For example,
     * a field value of 343.1, 343.104 and 343.09872677 would all be shown as 343.10 if precision is 5. <P> The original value
     * is always shown when the value is edited.
     *
     * @return Current precision value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Integer getPrecision()  {
        return getAttributeAsInt("precision");
    }
    

    /**
     * Indicates <b>either</b> that this field holds a value unique across all records in this DataSource, <b>or</b> that it is
     * one of a number of fields marked as primary keys, and the combination of the values held in all of those fields is
     * unique across all records in the DataSource.  Note that the latter usage - so-called "composite" or "multipart" keys -
     * is  intended for support of legacy databases only: if you are able to choose an approach,  Isomorphic recommends the use
     * of one <code>primaryKey</code> field per DataSource, and  ideally this field should be of {@link
     * com.smartgwt.client.data.DataSourceField#getType type} "sequence".  If you have control of the underlying tables, there
     * is nothing to stop you from adding a field like  this (a so-called "synthetic" or "surrogate" key), even for tables that
     * already have a set of columns that could combine to make a composite key (a so-called "natural" key).  Also,   it is
     * neither necessary nor correct to use a composite primaryKey because you want to  enforce uniqueness across that
     * combination of fields.  You can achieve that by declaring a unique constraint in the table schema, or use an {@link
     * com.smartgwt.client.types.ValidatorType isUnique}  validator with <code>validator.criteriaFields</code>, or both; there
     * is no need to use a  composite key to enforce uniqueness <p> Note that composite primaryKeys are not supported in
     * tree-structured datasets  ({@link com.smartgwt.client.widgets.tree.Tree} and {@link
     * com.smartgwt.client.widgets.tree.ResultTree}) or components ({@link com.smartgwt.client.widgets.tree.TreeGrid},  {@link
     * com.smartgwt.client.widgets.grid.ColumnTree}).  Tree-structured data requires that nodes have a unique  {@link
     * com.smartgwt.client.widgets.tree.Tree#getIdField idField}, with the parent/child relationship expressed through the 
     * {@link com.smartgwt.client.widgets.tree.Tree#getParentIdField parentIdField}.  This implies that binding a Tree to a
     * DataSource requires that the DataSource have a singular primaryKey, and that the primaryKey field is  also the idField,
     * as described in the {@link com.smartgwt.client.docs.TreeDataBinding tree databinding overview} <p> A DataSource that can
     * <i>only</i> perform the "fetch" operation does not require a primaryKey unless it contains {@link
     * com.smartgwt.client.docs.BinaryFields binary fields}.  If a DataSource  allows modification of DataSource records
     * through add, update and remove DataSource  operations, or it contains one or more binary fields, one or more fields must
     * be marked as  the primary key. <P> Smart GWT requires a primary key value to uniquely identify records when
     * communicating updates or deletions to the server.  There is no requirement that the primaryKey field be mapped to an
     * actual "primary key" in your object model, web service, or database (though  this is the most obvious and natural thing
     * to do, of course).  The only requirement is  that the combined values of the primaryKey fields be unique for a given
     * browser instance for the lifetime of the page.   <P> If using Smart GWT's {@link com.smartgwt.client.docs.SqlDataSource
     * SQL engine} and generating SQL tables using the {@link com.smartgwt.client.docs.DbConfigTool Database Configuration
     * Tool}, the table column generated from a primaryKey field will have a unique constraint applied in the database table
     * and, if the field is of type "sequence", the database column will also be created as an "identity column" in those
     * databases that implement sequence-type handling with identity columns.
     *
     * @param primaryKey New primaryKey value. Default value is false
     * @see com.smartgwt.client.docs.DataSourceRelations DataSourceRelations overview and related methods
     */
    public void setPrimaryKey(boolean primaryKey) {
        setAttribute("primaryKey", primaryKey);
    }

    /**
     * Indicates <b>either</b> that this field holds a value unique across all records in this DataSource, <b>or</b> that it is
     * one of a number of fields marked as primary keys, and the combination of the values held in all of those fields is
     * unique across all records in the DataSource.  Note that the latter usage - so-called "composite" or "multipart" keys -
     * is  intended for support of legacy databases only: if you are able to choose an approach,  Isomorphic recommends the use
     * of one <code>primaryKey</code> field per DataSource, and  ideally this field should be of {@link
     * com.smartgwt.client.data.DataSourceField#getType type} "sequence".  If you have control of the underlying tables, there
     * is nothing to stop you from adding a field like  this (a so-called "synthetic" or "surrogate" key), even for tables that
     * already have a set of columns that could combine to make a composite key (a so-called "natural" key).  Also,   it is
     * neither necessary nor correct to use a composite primaryKey because you want to  enforce uniqueness across that
     * combination of fields.  You can achieve that by declaring a unique constraint in the table schema, or use an {@link
     * com.smartgwt.client.types.ValidatorType isUnique}  validator with <code>validator.criteriaFields</code>, or both; there
     * is no need to use a  composite key to enforce uniqueness <p> Note that composite primaryKeys are not supported in
     * tree-structured datasets  ({@link com.smartgwt.client.widgets.tree.Tree} and {@link
     * com.smartgwt.client.widgets.tree.ResultTree}) or components ({@link com.smartgwt.client.widgets.tree.TreeGrid},  {@link
     * com.smartgwt.client.widgets.grid.ColumnTree}).  Tree-structured data requires that nodes have a unique  {@link
     * com.smartgwt.client.widgets.tree.Tree#getIdField idField}, with the parent/child relationship expressed through the 
     * {@link com.smartgwt.client.widgets.tree.Tree#getParentIdField parentIdField}.  This implies that binding a Tree to a
     * DataSource requires that the DataSource have a singular primaryKey, and that the primaryKey field is  also the idField,
     * as described in the {@link com.smartgwt.client.docs.TreeDataBinding tree databinding overview} <p> A DataSource that can
     * <i>only</i> perform the "fetch" operation does not require a primaryKey unless it contains {@link
     * com.smartgwt.client.docs.BinaryFields binary fields}.  If a DataSource  allows modification of DataSource records
     * through add, update and remove DataSource  operations, or it contains one or more binary fields, one or more fields must
     * be marked as  the primary key. <P> Smart GWT requires a primary key value to uniquely identify records when
     * communicating updates or deletions to the server.  There is no requirement that the primaryKey field be mapped to an
     * actual "primary key" in your object model, web service, or database (though  this is the most obvious and natural thing
     * to do, of course).  The only requirement is  that the combined values of the primaryKey fields be unique for a given
     * browser instance for the lifetime of the page.   <P> If using Smart GWT's {@link com.smartgwt.client.docs.SqlDataSource
     * SQL engine} and generating SQL tables using the {@link com.smartgwt.client.docs.DbConfigTool Database Configuration
     * Tool}, the table column generated from a primaryKey field will have a unique constraint applied in the database table
     * and, if the field is of type "sequence", the database column will also be created as an "identity column" in those
     * databases that implement sequence-type handling with identity columns.
     *
     * @return Current primaryKey value. Default value is false
     * @see com.smartgwt.client.docs.DataSourceRelations DataSourceRelations overview and related methods
     */
    public boolean getPrimaryKey()  {
        Boolean result = getAttributeAsBoolean("primaryKey", true);
        return result == null ? false : result;
    }
    

    /**
     * For use in {@link com.smartgwt.client.docs.ComponentSchema} for fields that contain other components, this flag
     *  suppresses auto-construction for subcomponents that appear under this field.
     *  <P>
     * For example, the {@link com.smartgwt.client.widgets.layout.VLayout} schema sets this for its {@link
     * com.smartgwt.client.widgets.layout.Layout#getMembers members}
     *  property, so that when a VLayout is constructed via XML as follows:
     *  <pre>
     *  &lt;VLayout&gt;
     *      &lt;members&gt;
     *          &lt;ListGrid ID="myGrid" .../&gt;
     *          &lt;Toolstrip ID="myToolStrip" ... /&gt;
     *      &lt;/members&gt;
     *  &lt;/VLayout&gt;
     *  </pre>
     *  The ListGrid and ToolStrip do not construct themselves automatically.  Instead, the VLayout
     *  receives the properties of the ListGrid and ToolStrip as ordinary JavaScript Objects, with
     *  the special property <code>_constructor</code> set to the name of the class that should be
     *  constructed.
     *
     * @param propertiesOnly New propertiesOnly value. Default value is null
     * @see com.smartgwt.client.docs.ComponentSchema ComponentSchema overview and related methods
     */
    public void setPropertiesOnly(Boolean propertiesOnly) {
        setAttribute("propertiesOnly", propertiesOnly);
    }

    /**
     * For use in {@link com.smartgwt.client.docs.ComponentSchema} for fields that contain other components, this flag
     *  suppresses auto-construction for subcomponents that appear under this field.
     *  <P>
     * For example, the {@link com.smartgwt.client.widgets.layout.VLayout} schema sets this for its {@link
     * com.smartgwt.client.widgets.layout.Layout#getMembers members}
     *  property, so that when a VLayout is constructed via XML as follows:
     *  <pre>
     *  &lt;VLayout&gt;
     *      &lt;members&gt;
     *          &lt;ListGrid ID="myGrid" .../&gt;
     *          &lt;Toolstrip ID="myToolStrip" ... /&gt;
     *      &lt;/members&gt;
     *  &lt;/VLayout&gt;
     *  </pre>
     *  The ListGrid and ToolStrip do not construct themselves automatically.  Instead, the VLayout
     *  receives the properties of the ListGrid and ToolStrip as ordinary JavaScript Objects, with
     *  the special property <code>_constructor</code> set to the name of the class that should be
     *  constructed.
     *
     * @return Current propertiesOnly value. Default value is null
     * @see com.smartgwt.client.docs.ComponentSchema ComponentSchema overview and related methods
     */
    public Boolean getPropertiesOnly()  {
        return getAttributeAsBoolean("propertiesOnly", true);
    }
    
    
    

    /**
     * Indicates this field must be non-null in order for a record to pass validation. Or, in the
     *  case of a "binary" field, a non-empty file must be uploaded.  Setting this property has the
     *  same effect as giving the field a {@link com.smartgwt.client.types.ValidatorType "required" validator}. 
     *  <P>
     *  Note that <code>required</code> should not be set for a server-generated field, such as a
     *  sequence, or validation will fail on the client.
     *  <h3>Conditionally required fields</h3>
     * Adding an {@link com.smartgwt.client.widgets.form.validator.Validator#getApplyWhen applyWhen} condition to a
     * <code>required</code> 
     *  validator introduces subtle complexities to the process of validating an existing record.  
     *  The client is not guaranteed to know the the full and complete state of the record it is 
     *  editing because it is common for a {@link com.smartgwt.client.widgets.form.DynamicForm} to be editing a subset of
     *  fields.  When a field is <i>unconditionally</i> required, things are simple: if the 
     * DynamicForm has a {@link com.smartgwt.client.widgets.form.fields.FormItem} for that field, then the
     * <code>required</code> validation
     *  passes if that FormItem has a value, and fails if it does not.  If the form has no FormItem
     *  for the field, it can assume that the field has a value because otherwise it would have 
     *  failed validation when we attempted to add it (when we are adding a record, we of course do 
     *  know the full and complete state of the record - it is whatever we are about to add).
     *  <p>
     *  When a field is <i>conditionally</i> required, the client can no longer assume that all 
     *  required fields will have a value.  It may be the case that the condition of requirement 
     *  was not met when the record was added, but now it is.  For example, consider these field
     *  definitions:<pre>
     *     &lt;field name="yearsAtCurrentAddress" type="integer" /&gt;
     *     &lt;field name="previousAddress" type="text" &gt;
     *       &lt;validator type="required" errorMessage="Previous address is required if you have been at your current address less than three years"&gt;
     *         &lt;applyWhen operator="and"&gt;
     *           &lt;criteria&gt;
     *             &lt;criterion fieldName="yearsAtCurrentAddress" operator="lessThan" value="3" /&gt;
     *           &lt;/criteria&gt;
     *         &lt;/applyWhen&gt;
     *       &lt;/validator&gt;
     *     &lt;/field&gt;
     *  </pre>
     *  Imagine a record for this DataSource is added where the user has entered a value of "3" for 
     *  "yearsAtCurrentAddress", and no previous address.  Later, the value of that field is 
     *  changed to "2".  If this is done using a form that is also showing the "previousAddress" 
     *  field, we will know that "previousAddress" has not been provided, so we can fail the 
     *  validation and the user will get a helpful error message explaining what the problem is.
     *  <p>
     *  However, if the form does not also show the "previousAddress" field, we may choose to use an
     * {@link com.smartgwt.client.data.OperationBinding} that uses {@link
     * com.smartgwt.client.docs.serverds.OperationBinding#outputs outputs} to trim the
     *  record down to just the fields the form does contain, in the interests of avoiding 
     *  information leakage.  Or perhaps that value is automatically culled from the record before
     * the client sees it by the application of a {@link com.smartgwt.client.docs.serverds.DataSourceField#viewRequires
     * declarative security rule}.
     *  Whatever the reason, if the client does not have the complete record, it is not possible 
     *  for the client to sensibly apply this validation.  And because the client has no way of 
     *  knowing if a value is missing because it is genuinely null, or because it has been trimmed
     *  away by the server, we must treat any null value with suspicion (unless it has a matching 
     *  FormItem - the presence of the FormItem means that the user can edit the value, so it 
     *  would make no sense to pair it with a trimmed record that excludes that field value).
     *  <p>
     *  When this happens, we mark the validation as having passed on the client, but in need of 
     *  running on the server.  The server validation makes use of the "storedRecord" facility 
     *  (look for the description of <b>$storedRecord</b> in the 
     *  {@link com.smartgwt.client.docs.VelocitySupport Velocity support overview}) to overlay the changed record on
     *  top of the existing record as it currently exists in the database.  This gives the validator
     *  the complete record including both changed and unchanged values, so it is able to carry 
     *  out the required check in a meaningful way.  However, you should be aware that the 
     *  combination of conditional "required" validators and DynamicForms that edit partial 
     *  records can result in a validation that cannot run on the client and must do both a server 
     *  roundtrip and a database fetch.
     *
     * @param required New required value. Default value is false
     * @see com.smartgwt.client.widgets.form.validator.Validator#setApplyWhen
     */
    public void setRequired(boolean required) {
        setAttribute("required", required);
    }

    /**
     * Indicates this field must be non-null in order for a record to pass validation. Or, in the
     *  case of a "binary" field, a non-empty file must be uploaded.  Setting this property has the
     *  same effect as giving the field a {@link com.smartgwt.client.types.ValidatorType "required" validator}. 
     *  <P>
     *  Note that <code>required</code> should not be set for a server-generated field, such as a
     *  sequence, or validation will fail on the client.
     *  <h3>Conditionally required fields</h3>
     * Adding an {@link com.smartgwt.client.widgets.form.validator.Validator#getApplyWhen applyWhen} condition to a
     * <code>required</code> 
     *  validator introduces subtle complexities to the process of validating an existing record.  
     *  The client is not guaranteed to know the the full and complete state of the record it is 
     *  editing because it is common for a {@link com.smartgwt.client.widgets.form.DynamicForm} to be editing a subset of
     *  fields.  When a field is <i>unconditionally</i> required, things are simple: if the 
     * DynamicForm has a {@link com.smartgwt.client.widgets.form.fields.FormItem} for that field, then the
     * <code>required</code> validation
     *  passes if that FormItem has a value, and fails if it does not.  If the form has no FormItem
     *  for the field, it can assume that the field has a value because otherwise it would have 
     *  failed validation when we attempted to add it (when we are adding a record, we of course do 
     *  know the full and complete state of the record - it is whatever we are about to add).
     *  <p>
     *  When a field is <i>conditionally</i> required, the client can no longer assume that all 
     *  required fields will have a value.  It may be the case that the condition of requirement 
     *  was not met when the record was added, but now it is.  For example, consider these field
     *  definitions:<pre>
     *     &lt;field name="yearsAtCurrentAddress" type="integer" /&gt;
     *     &lt;field name="previousAddress" type="text" &gt;
     *       &lt;validator type="required" errorMessage="Previous address is required if you have been at your current address less than three years"&gt;
     *         &lt;applyWhen operator="and"&gt;
     *           &lt;criteria&gt;
     *             &lt;criterion fieldName="yearsAtCurrentAddress" operator="lessThan" value="3" /&gt;
     *           &lt;/criteria&gt;
     *         &lt;/applyWhen&gt;
     *       &lt;/validator&gt;
     *     &lt;/field&gt;
     *  </pre>
     *  Imagine a record for this DataSource is added where the user has entered a value of "3" for 
     *  "yearsAtCurrentAddress", and no previous address.  Later, the value of that field is 
     *  changed to "2".  If this is done using a form that is also showing the "previousAddress" 
     *  field, we will know that "previousAddress" has not been provided, so we can fail the 
     *  validation and the user will get a helpful error message explaining what the problem is.
     *  <p>
     *  However, if the form does not also show the "previousAddress" field, we may choose to use an
     * {@link com.smartgwt.client.data.OperationBinding} that uses {@link
     * com.smartgwt.client.docs.serverds.OperationBinding#outputs outputs} to trim the
     *  record down to just the fields the form does contain, in the interests of avoiding 
     *  information leakage.  Or perhaps that value is automatically culled from the record before
     * the client sees it by the application of a {@link com.smartgwt.client.docs.serverds.DataSourceField#viewRequires
     * declarative security rule}.
     *  Whatever the reason, if the client does not have the complete record, it is not possible 
     *  for the client to sensibly apply this validation.  And because the client has no way of 
     *  knowing if a value is missing because it is genuinely null, or because it has been trimmed
     *  away by the server, we must treat any null value with suspicion (unless it has a matching 
     *  FormItem - the presence of the FormItem means that the user can edit the value, so it 
     *  would make no sense to pair it with a trimmed record that excludes that field value).
     *  <p>
     *  When this happens, we mark the validation as having passed on the client, but in need of 
     *  running on the server.  The server validation makes use of the "storedRecord" facility 
     *  (look for the description of <b>$storedRecord</b> in the 
     *  {@link com.smartgwt.client.docs.VelocitySupport Velocity support overview}) to overlay the changed record on
     *  top of the existing record as it currently exists in the database.  This gives the validator
     *  the complete record including both changed and unchanged values, so it is able to carry 
     *  out the required check in a meaningful way.  However, you should be aware that the 
     *  combination of conditional "required" validators and DynamicForms that edit partial 
     *  records can result in a validation that cannot run on the client and must do both a server 
     *  roundtrip and a database fetch.
     *
     * @return Current required value. Default value is false
     * @see com.smartgwt.client.widgets.form.validator.Validator#getApplyWhen
     */
    public boolean getRequired()  {
        Boolean result = getAttributeAsBoolean("required", true);
        return result == null ? false : result;
    }
    

    /**
     * The required message when a field that has been marked as {@link com.smartgwt.client.data.DataSourceField#getRequired
     * required} is not filled in by the user. <p> Note that this setting wins over {@link
     * com.smartgwt.client.data.DataSource#getRequiredMessage DataSource.requiredMessage} if both are set.
     *
     * @param requiredMessage New requiredMessage value. Default value is null
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public void setRequiredMessage(String requiredMessage) {
        setAttribute("requiredMessage", requiredMessage);
    }

    /**
     * The required message when a field that has been marked as {@link com.smartgwt.client.data.DataSourceField#getRequired
     * required} is not filled in by the user. <p> Note that this setting wins over {@link
     * com.smartgwt.client.data.DataSource#getRequiredMessage DataSource.requiredMessage} if both are set.
     *
     * @return Current requiredMessage value. Default value is null
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public String getRequiredMessage()  {
        return getAttributeAsString("requiredMessage");
    }
    

    /**
     * For a field that is a foreignKey establishing a tree relationship, what value indicates a root-level node.  Defaults to
     * null. <P> Note that the rootValue may be overridden on a specific ResultTree instance by setting {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getRootNode ResultTree.rootNode}, or if the ResultTree is auto-generated by
     * a {@link com.smartgwt.client.widgets.tree.TreeGrid}, by setting {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getTreeRootValue TreeGrid.treeRootValue}. This allows a component to navigate
     * a subtree of the hierarchical data from this dataSource starting at a particular node.
     *
     * @param rootValue New rootValue value. Default value is null
     * @see com.smartgwt.client.docs.DataSourceRelations DataSourceRelations overview and related methods
     * 
     */
    public void setRootValue(Object rootValue) {
        setAttribute("rootValue", rootValue);
    }

    /**
     * For a field that is a foreignKey establishing a tree relationship, what value indicates a root-level node.  Defaults to
     * null. <P> Note that the rootValue may be overridden on a specific ResultTree instance by setting {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getRootNode ResultTree.rootNode}, or if the ResultTree is auto-generated by
     * a {@link com.smartgwt.client.widgets.tree.TreeGrid}, by setting {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getTreeRootValue TreeGrid.treeRootValue}. This allows a component to navigate
     * a subtree of the hierarchical data from this dataSource starting at a particular node.
     *
     * @return Current rootValue value. Default value is null
     * @see com.smartgwt.client.docs.DataSourceRelations DataSourceRelations overview and related methods
     * 
     */
    public Object getRootValue()  {
        return getAttributeAsObject("rootValue");
    }
    

    /**
     * For a DataSource with {@link com.smartgwt.client.docs.serverds.DataSource#serverType serverType:"sql"} with a field of
     * type
     *  "sequence", the name of the SQL sequence that should be used when inserting new records into
     *  this table.
     *  <P>
     *  Note that this is never required for SQL tables that are generated from Smart GWT
     *  DataSources (a default sequence name of tableName + "_" + columnName is chosen, but see the
     *  notes below regarding this), and is never required for databases where inserting null into a 
     *  sequence column is sufficient (MySQL, SQL Server, DB2 and others). 
     *  <P>
     *  You would only need to set sequenceName if you are integrating with a pre-existing table
     *  stored in a database where the sequence must be named for insertion to work (Oracle,
     *  Postgres, Firebird) OR you are trying to use the same sequence across multiple DataSources.
     *  <P>
     *  <b>Note:</b> If you specify the <code>sql.{database type}.sequence.name.prefix</code> and/or 
     *  <code>sql.{database type}.sequence.name.suffix</code> properties in your 
     * {@link com.smartgwt.client.docs.Server_properties server.properties} file,the generated sequence name will include the
     * prefix and/or
     *  suffix.  For example, with a prefix of "order_system_" and a suffix of "_seq", the sequence
     *  generated for column "orderNumber" on table "orders" would be:<pre>
     *      order_system_orders_orderNumber_seq
     *  </pre>
     *
     * @param sequenceName New sequenceName value. Default value is null
     * @see com.smartgwt.client.docs.SqlDataSource SqlDataSource overview and related methods
     */
    public void setSequenceName(String sequenceName) {
        setAttribute("sequenceName", sequenceName);
    }

    /**
     * For a DataSource with {@link com.smartgwt.client.docs.serverds.DataSource#serverType serverType:"sql"} with a field of
     * type
     *  "sequence", the name of the SQL sequence that should be used when inserting new records into
     *  this table.
     *  <P>
     *  Note that this is never required for SQL tables that are generated from Smart GWT
     *  DataSources (a default sequence name of tableName + "_" + columnName is chosen, but see the
     *  notes below regarding this), and is never required for databases where inserting null into a 
     *  sequence column is sufficient (MySQL, SQL Server, DB2 and others). 
     *  <P>
     *  You would only need to set sequenceName if you are integrating with a pre-existing table
     *  stored in a database where the sequence must be named for insertion to work (Oracle,
     *  Postgres, Firebird) OR you are trying to use the same sequence across multiple DataSources.
     *  <P>
     *  <b>Note:</b> If you specify the <code>sql.{database type}.sequence.name.prefix</code> and/or 
     *  <code>sql.{database type}.sequence.name.suffix</code> properties in your 
     * {@link com.smartgwt.client.docs.Server_properties server.properties} file,the generated sequence name will include the
     * prefix and/or
     *  suffix.  For example, with a prefix of "order_system_" and a suffix of "_seq", the sequence
     *  generated for column "orderNumber" on table "orders" would be:<pre>
     *      order_system_orders_orderNumber_seq
     *  </pre>
     *
     * @return Current sequenceName value. Default value is null
     * @see com.smartgwt.client.docs.SqlDataSource SqlDataSource overview and related methods
     */
    public String getSequenceName()  {
        return getAttributeAsString("sequenceName");
    }
    

    /**
     * For a field of type:"imageFile", indicates whether to stream the image and display it inline or to display the View and
     * Download icons.
     *
     * @param showFileInline New showFileInline value. Default value is null
     */
    public void setShowFileInline(Boolean showFileInline) {
        setAttribute("showFileInline", showFileInline);
    }

    /**
     * For a field of type:"imageFile", indicates whether to stream the image and display it inline or to display the View and
     * Download icons.
     *
     * @return Current showFileInline value. Default value is null
     */
    public Boolean getShowFileInline()  {
        return getAttributeAsBoolean("showFileInline", true);
    }
    

    /**
     * Causes values for this field to be sorted according to values for another field, for both client- and server-side
     * sorting. <p> This can be used to establish a sort order for a field that is not the normal sorting order indicated by
     * the field value, typically by having the <code>sortByField</code> as a {@link
     * com.smartgwt.client.data.DataSourceField#getHidden hidden field}.   <p> If using SQLDataSource, consider using a {@link
     * com.smartgwt.client.data.DataSourceField#getCustomSelectExpression customSelectExpression} as an efficient way to
     * populate the <code>sortByField</code> with the results of a SQL expression.
     *
     * @param sortByField New sortByField value. Default value is null
     */
    public void setSortByField(String sortByField) {
        setAttribute("sortByField", sortByField);
    }

    /**
     * Causes values for this field to be sorted according to values for another field, for both client- and server-side
     * sorting. <p> This can be used to establish a sort order for a field that is not the normal sorting order indicated by
     * the field value, typically by having the <code>sortByField</code> as a {@link
     * com.smartgwt.client.data.DataSourceField#getHidden hidden field}.   <p> If using SQLDataSource, consider using a {@link
     * com.smartgwt.client.data.DataSourceField#getCustomSelectExpression customSelectExpression} as an efficient way to
     * populate the <code>sortByField</code> with the results of a SQL expression.
     *
     * @return Current sortByField value. Default value is null
     */
    public String getSortByField()  {
        return getAttributeAsString("sortByField");
    }
    
    
    

    /**
     * Server-side setting that causes values for fields of type "integer" or "float" to be represented  as Strings when
     * delivered to a web browser, in order to avoid mangling values which cannot be represented faithfully in JavaScript. <p>
     * JavaScript has a single "Number" type which internally stores numbers in a format equivalent to Java's "Double" -
     * double-precision floating point.  This means it cannot represent the full range of Java's Long type: Java Longs can
     * represent integral values between -2^63 to 2^63-1, whereas JavaScript Number can only represent exact integer values
     * between -2^53 and 2^53. Similarly, JavaScript's Number type cannot represent Java's unlimited-size BigInteger or
     * unlimited-precision BigDecimal objects at all. <p> The <code>stringInBrowser</code> setting can be used to deliver
     * numeric values as Strings to the browser.  This is intended to allow read-only display and successful round-tripping of
     * the numeric value, however, it will not cause number-oriented features such as {@link
     * com.smartgwt.client.widgets.form.fields.SpinnerItem}, {@link com.smartgwt.client.widgets.Slider}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary ListGrid summaries} or range-checking {@link
     * com.smartgwt.client.widgets.form.validator.Validator validators} or {@link com.smartgwt.client.data.AdvancedCriteria
     * criteria} to actually work. <p> If <code>stringInBrowser</code> is not set, the default behavior is configured by the 
     * <code>server.properties</code> setting <code>datasource.defaultStringInBrowser</code>.  If  this flag is false, numeric
     * values are delivered to the client as numbers, <i>even where  this will lead  to a loss of precision</i>.  If the flag
     * is true (which is the the default), the behavior is to prevent range overflow for numeric values: <ul> <li> Java values
     * of type Long, BigInteger and BigDecimal will be delivered as      String <i>only if</i> they exceed JavaScript's number
     * range.   <li> Client-side validation will allow inputs that are outside of JavaScript's normal      integer range, and
     * such numbers will remain as Strings after validation, instead of being      converted to Numbers <li> Values submitted
     * to the server will be converted to BigInteger if they exceed the range      of Java's Long type.  This happens during
     * DSRequest validation, before any defined      {@link com.smartgwt.client.docs.DmiOverview DMI methods} are called. </ul>
     * <p> This default set of behaviors is intended to automatically deal with cases like numeric {@link
     * com.smartgwt.client.data.DataSourceField#getPrimaryKey primaryKey} or {@link
     * com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} values that are never used as numbers, but happen to
     * use the full Java Long range.  To disable the above behaviors, set <code>stringInBrowser="false"</code>. <p> If
     * <code>stringInBrowser</code> is explicitly set to true: <ul> <li> the value for the field will <i>always</i> be
     * delivered to the browser as a String (no      attempt is made to detect the value as out of range / too high precision)
     * <li> client-side validation will do a check for valid format only, and always leave the value      as a String.  Numeric
     * range validators are ignored client-side (always pass), but are      still active server-side. <li> AdvancedCriteria
     * {@link com.smartgwt.client.types.OperatorId operators} that check if values are in a particular      range will always
     * pass <li> the field is treated as though {@link com.smartgwt.client.data.DataSourceField#getCanFilter canFilter:false}
     * were set, to avoid showing      non-functional search interfaces to the user.  Set <code>canFilter="true"</code> to
     * avoid      this effect </ul> <p> This setting is recommended for presenting out-of-range issues or precision loss on
     * fields that represent actual quantities (as opposed to primaryKey or foreignKey fields, which really represent IDs).  To
     * ensure unlimited-precision BigDecimal values are preserved, you should also set {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#javaClass javaClass}. <p> Note that responses delivered as JSON or
     * XML, such as responses from the {@link com.smartgwt.client.docs.ServletDetails RESTHandler servlet}, are not affected. 
     * This setting applies only to responses delivered to a web browser. <p> The entirety of stringInBrowser processing can be
     * completely disabled by setting  <code>server.properties</code> flag <code>datasource.disableStringInBrowser</code> to
     * true. This will cause all numeric values to be delivered as numbers without even attempting to  detect if this will lead
     * to a loss of precision.  This setting overrides both the  <code>stringInBrowser</code> field setting and the 
     * <code>datasource.defaultStringInBrowser server.properties</code> flag. <p> <b><code>stringInBrowser</code> and
     * client-side DataSources</b> <p> For DataSources that are not based on the Smart GWT Server, the client-side behaviors
     * described above (such as leaving user input in string form if precision would be lost) are active by default. <p> In
     * addition, if {@link com.smartgwt.client.data.DataSource#getDataFormat dataSource.dataFormat:"xml"} is used, values that
     * would lose precision remain as strings.  For JSON, if behavior similar to <code>stringInBrowser</code> is desired, your
     * server response must send the values as JSON strings rather than JSON numeric literals. <p> You can use {@link
     * com.smartgwt.client.data.DataSource#defaultStringInBrowser defaultStringInBrowser} to disable these behaviors. 
     * <b>NOTE:</b> don't use this setting if you are using the Smart GWT Server, use the server.properties approach described
     * above instead.
     *
     * @param stringInBrowser New stringInBrowser value. Default value is null
     */
    public void setStringInBrowser(Boolean stringInBrowser) {
        setAttribute("stringInBrowser", stringInBrowser);
    }

    /**
     * Server-side setting that causes values for fields of type "integer" or "float" to be represented  as Strings when
     * delivered to a web browser, in order to avoid mangling values which cannot be represented faithfully in JavaScript. <p>
     * JavaScript has a single "Number" type which internally stores numbers in a format equivalent to Java's "Double" -
     * double-precision floating point.  This means it cannot represent the full range of Java's Long type: Java Longs can
     * represent integral values between -2^63 to 2^63-1, whereas JavaScript Number can only represent exact integer values
     * between -2^53 and 2^53. Similarly, JavaScript's Number type cannot represent Java's unlimited-size BigInteger or
     * unlimited-precision BigDecimal objects at all. <p> The <code>stringInBrowser</code> setting can be used to deliver
     * numeric values as Strings to the browser.  This is intended to allow read-only display and successful round-tripping of
     * the numeric value, however, it will not cause number-oriented features such as {@link
     * com.smartgwt.client.widgets.form.fields.SpinnerItem}, {@link com.smartgwt.client.widgets.Slider}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary ListGrid summaries} or range-checking {@link
     * com.smartgwt.client.widgets.form.validator.Validator validators} or {@link com.smartgwt.client.data.AdvancedCriteria
     * criteria} to actually work. <p> If <code>stringInBrowser</code> is not set, the default behavior is configured by the 
     * <code>server.properties</code> setting <code>datasource.defaultStringInBrowser</code>.  If  this flag is false, numeric
     * values are delivered to the client as numbers, <i>even where  this will lead  to a loss of precision</i>.  If the flag
     * is true (which is the the default), the behavior is to prevent range overflow for numeric values: <ul> <li> Java values
     * of type Long, BigInteger and BigDecimal will be delivered as      String <i>only if</i> they exceed JavaScript's number
     * range.   <li> Client-side validation will allow inputs that are outside of JavaScript's normal      integer range, and
     * such numbers will remain as Strings after validation, instead of being      converted to Numbers <li> Values submitted
     * to the server will be converted to BigInteger if they exceed the range      of Java's Long type.  This happens during
     * DSRequest validation, before any defined      {@link com.smartgwt.client.docs.DmiOverview DMI methods} are called. </ul>
     * <p> This default set of behaviors is intended to automatically deal with cases like numeric {@link
     * com.smartgwt.client.data.DataSourceField#getPrimaryKey primaryKey} or {@link
     * com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} values that are never used as numbers, but happen to
     * use the full Java Long range.  To disable the above behaviors, set <code>stringInBrowser="false"</code>. <p> If
     * <code>stringInBrowser</code> is explicitly set to true: <ul> <li> the value for the field will <i>always</i> be
     * delivered to the browser as a String (no      attempt is made to detect the value as out of range / too high precision)
     * <li> client-side validation will do a check for valid format only, and always leave the value      as a String.  Numeric
     * range validators are ignored client-side (always pass), but are      still active server-side. <li> AdvancedCriteria
     * {@link com.smartgwt.client.types.OperatorId operators} that check if values are in a particular      range will always
     * pass <li> the field is treated as though {@link com.smartgwt.client.data.DataSourceField#getCanFilter canFilter:false}
     * were set, to avoid showing      non-functional search interfaces to the user.  Set <code>canFilter="true"</code> to
     * avoid      this effect </ul> <p> This setting is recommended for presenting out-of-range issues or precision loss on
     * fields that represent actual quantities (as opposed to primaryKey or foreignKey fields, which really represent IDs).  To
     * ensure unlimited-precision BigDecimal values are preserved, you should also set {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#javaClass javaClass}. <p> Note that responses delivered as JSON or
     * XML, such as responses from the {@link com.smartgwt.client.docs.ServletDetails RESTHandler servlet}, are not affected. 
     * This setting applies only to responses delivered to a web browser. <p> The entirety of stringInBrowser processing can be
     * completely disabled by setting  <code>server.properties</code> flag <code>datasource.disableStringInBrowser</code> to
     * true. This will cause all numeric values to be delivered as numbers without even attempting to  detect if this will lead
     * to a loss of precision.  This setting overrides both the  <code>stringInBrowser</code> field setting and the 
     * <code>datasource.defaultStringInBrowser server.properties</code> flag. <p> <b><code>stringInBrowser</code> and
     * client-side DataSources</b> <p> For DataSources that are not based on the Smart GWT Server, the client-side behaviors
     * described above (such as leaving user input in string form if precision would be lost) are active by default. <p> In
     * addition, if {@link com.smartgwt.client.data.DataSource#getDataFormat dataSource.dataFormat:"xml"} is used, values that
     * would lose precision remain as strings.  For JSON, if behavior similar to <code>stringInBrowser</code> is desired, your
     * server response must send the values as JSON strings rather than JSON numeric literals. <p> You can use {@link
     * com.smartgwt.client.data.DataSource#defaultStringInBrowser defaultStringInBrowser} to disable these behaviors. 
     * <b>NOTE:</b> don't use this setting if you are using the Smart GWT Server, use the server.properties approach described
     * above instead.
     *
     * @return Current stringInBrowser value. Default value is null
     */
    public Boolean getStringInBrowser()  {
        return getAttributeAsBoolean("stringInBrowser", true);
    }
    
    

    /**
     * Title to show in a {@link com.smartgwt.client.types.SummaryFunctionType Summary of type "title"} for this field. If
     * unspecified <code>title</code> summaries will show the {@link com.smartgwt.client.data.DataSourceField#getTitle title}
     * for the field.
     *
     * @param summaryValueTitle New summaryValueTitle value. Default value is null
     */
    public void setSummaryValueTitle(String summaryValueTitle) {
        setAttribute("summaryValueTitle", summaryValueTitle);
    }

    /**
     * Title to show in a {@link com.smartgwt.client.types.SummaryFunctionType Summary of type "title"} for this field. If
     * unspecified <code>title</code> summaries will show the {@link com.smartgwt.client.data.DataSourceField#getTitle title}
     * for the field.
     *
     * @return Current summaryValueTitle value. Default value is null
     */
    public String getSummaryValueTitle()  {
        return getAttributeAsString("summaryValueTitle");
    }
    

    /**
     * Preferred time-format to apply to date type values within this field.  If this property is specified on a field
     * displayed within a dataBound component such as a {@link com.smartgwt.client.widgets.grid.ListGrid} or {@link
     * com.smartgwt.client.widgets.form.DynamicForm}, any dates displayed in this field will be formatted as times using the
     * appropriate format. <P> This is most commonly only applied to fields specified as type <code>"time"</code> though if no
     * explicit {@link com.smartgwt.client.widgets.form.fields.FormItem#getDateFormatter FormItem.dateFormatter} is specified
     * it will be respected for other  fields as well. <P> See {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getTimeFormatter ListGridField.timeFormatter} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTimeFormatter FormItem.timeFormatter} for more information.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param timeFormatter New timeFormatter value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setTimeFormatter(TimeDisplayFormat timeFormatter) {
        setAttribute("timeFormatter", timeFormatter == null ? null : timeFormatter.getValue());
    }

    /**
     * Preferred time-format to apply to date type values within this field.  If this property is specified on a field
     * displayed within a dataBound component such as a {@link com.smartgwt.client.widgets.grid.ListGrid} or {@link
     * com.smartgwt.client.widgets.form.DynamicForm}, any dates displayed in this field will be formatted as times using the
     * appropriate format. <P> This is most commonly only applied to fields specified as type <code>"time"</code> though if no
     * explicit {@link com.smartgwt.client.widgets.form.fields.FormItem#getDateFormatter FormItem.dateFormatter} is specified
     * it will be respected for other  fields as well. <P> See {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getTimeFormatter ListGridField.timeFormatter} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getTimeFormatter FormItem.timeFormatter} for more information.
     *
     * @return Current timeFormatter value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public TimeDisplayFormat getTimeFormatter()  {
        return EnumUtil.getEnum(TimeDisplayFormat.values(), getAttribute("timeFormatter"));
    }
    

    /**
     * Default user-visible title for this field. <p> This will be picked up by DataBound components and other views over this
     * DataSource. <p> Note this property frequently does not need to be set since {@link
     * com.smartgwt.client.data.DataSource#getAutoDeriveTitles DataSource.autoDeriveTitles} (on by default) usually picks an
     * appropriate user-visible title if you have a reasonable naming convention for your field names. <P> Note that if this
     * field is being displayed in a {@link com.smartgwt.client.widgets.grid.ListGrid} bound to this dataSource, the {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getHeaderTitle ListGridField.headerTitle} attribute may be used to
     * specify a different string for display in the listGrid column header.
     *
     * @param title New title value. Default value is null
     * @see com.smartgwt.client.docs.ComponentBinding ComponentBinding overview and related methods
     */
    public void setTitle(String title) {
        setAttribute("title", title);
    }

    /**
     * Default user-visible title for this field. <p> This will be picked up by DataBound components and other views over this
     * DataSource. <p> Note this property frequently does not need to be set since {@link
     * com.smartgwt.client.data.DataSource#getAutoDeriveTitles DataSource.autoDeriveTitles} (on by default) usually picks an
     * appropriate user-visible title if you have a reasonable naming convention for your field names. <P> Note that if this
     * field is being displayed in a {@link com.smartgwt.client.widgets.grid.ListGrid} bound to this dataSource, the {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getHeaderTitle ListGridField.headerTitle} attribute may be used to
     * specify a different string for display in the listGrid column header.
     *
     * @return Current title value. Default value is null
     * @see com.smartgwt.client.docs.ComponentBinding ComponentBinding overview and related methods
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }
    

    /**
     * Type of this field.  Required for all DataSource fields. <P> Field type may imply automatic validators (for example, an
     * integer field cannot accept the value "foo").  Field type also affects the default behaviors of DataBound components,
     * for example, if a field is declared as type "date", components that edit that field will automatically choose a
     * date-editing interface with pop-up date picker.
     *
     * @param type New type value. Default value is null
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public void setType(FieldType type) {
        setAttribute("type", type == null ? null : type.getValue());
    }
    
    
    
    

    /**
     * Used by the {@link com.smartgwt.client.widgets.BatchUploader} to map a field in an upload file to this  dataSourceField.
     * This is only necessary if the dataSourceField's name and title differ  from the name of the field in the upload file
     * (Smart GWT will automatically map upload  fields using the dataSourceField's title, if possible, if it does not get a
     * direct match  on field name).
     *
     * @param uploadFieldName New uploadFieldName value. Default value is null
     */
    public void setUploadFieldName(String uploadFieldName) {
        setAttribute("uploadFieldName", uploadFieldName);
    }

    /**
     * Used by the {@link com.smartgwt.client.widgets.BatchUploader} to map a field in an upload file to this  dataSourceField.
     * This is only necessary if the dataSourceField's name and title differ  from the name of the field in the upload file
     * (Smart GWT will automatically map upload  fields using the dataSourceField's title, if possible, if it does not get a
     * direct match  on field name).
     *
     * @return Current uploadFieldName value. Default value is null
     */
    public String getUploadFieldName()  {
        return getAttributeAsString("uploadFieldName");
    }
    

    /**
     * The {@link com.smartgwt.client.widgets.form.fields.FormItem#getUseLocalDisplayFieldValue
     * FormItem.useLocalDisplayFieldValue} attribute may be specified within a dataSource configuration. <P> This property
     * governs whether, when displaying a record in an editor component, the <code>displayField</code> value for this field
     * should be picked up directly from the record value (as opposed to being retrieved via an explicit fetch operation
     * against the {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource FormItem.optionDataSource}). See
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getUseLocalDisplayFieldValue FormItem.useLocalDisplayFieldValue}
     * for further details. <P> If not explicitly set, dataSources backed by the  {@link
     * com.smartgwt.client.docs.ServerDataIntegration Smart GWT server} will set this property to true automatically for fields
     * where the specified {@link com.smartgwt.client.data.DataSourceField#getDisplayField displayField} values are retrieved
     * from another dataSource using the {@link com.smartgwt.client.docs.serverds.DataSourceField#includeFrom includeFrom} 
     * feature.
     *
     * @param useLocalDisplayFieldValue New useLocalDisplayFieldValue value. Default value is null
     */
    public void setUseLocalDisplayFieldValue(Boolean useLocalDisplayFieldValue) {
        setAttribute("useLocalDisplayFieldValue", useLocalDisplayFieldValue);
    }

    /**
     * The {@link com.smartgwt.client.widgets.form.fields.FormItem#getUseLocalDisplayFieldValue
     * FormItem.useLocalDisplayFieldValue} attribute may be specified within a dataSource configuration. <P> This property
     * governs whether, when displaying a record in an editor component, the <code>displayField</code> value for this field
     * should be picked up directly from the record value (as opposed to being retrieved via an explicit fetch operation
     * against the {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource FormItem.optionDataSource}). See
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getUseLocalDisplayFieldValue FormItem.useLocalDisplayFieldValue}
     * for further details. <P> If not explicitly set, dataSources backed by the  {@link
     * com.smartgwt.client.docs.ServerDataIntegration Smart GWT server} will set this property to true automatically for fields
     * where the specified {@link com.smartgwt.client.data.DataSourceField#getDisplayField displayField} values are retrieved
     * from another dataSource using the {@link com.smartgwt.client.docs.serverds.DataSourceField#includeFrom includeFrom} 
     * feature.
     *
     * @return Current useLocalDisplayFieldValue value. Default value is null
     */
    public Boolean getUseLocalDisplayFieldValue()  {
        return getAttributeAsBoolean("useLocalDisplayFieldValue", true);
    }
    

    /**
     * Validators to be applied to this field. <p> Validators are applied whenever there is an attempt to save changes to a
     * field. <p> For the available set of built-in validators, and how to define a custom validator, see the {@link
     * com.smartgwt.client.widgets.form.validator.Validator} class.
     *
     * @param validators New validators value. Default value is null
     * @see com.smartgwt.client.widgets.form.validator.Validator
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public void setValidators(Validator... validators) {
        setAttribute("validators", validators);
    }

    /**
     * Validators to be applied to this field. <p> Validators are applied whenever there is an attempt to save changes to a
     * field. <p> For the available set of built-in validators, and how to define a custom validator, see the {@link
     * com.smartgwt.client.widgets.form.validator.Validator} class.
     *
     * @return Current validators value. Default value is null
     * @see com.smartgwt.client.widgets.form.validator.Validator
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public Validator[] getValidators()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfValidator(getAttributeAsJavaScriptObject("validators"));
    }
    

    /**
     * Set of search-operators valid for this field.   <P> If not specified, all operators that are valid for the field type
     * are allowed.
     *
     * @param validOperators New validOperators value. Default value is null
     * @see com.smartgwt.client.docs.AdvancedFilter AdvancedFilter overview and related methods
     */
    public void setValidOperators(OperatorId... validOperators) {
        setAttribute("validOperators", validOperators);
    }

    /**
     * Set of search-operators valid for this field.   <P> If not specified, all operators that are valid for the field type
     * are allowed.
     *
     * @return Current validOperators value. Default value is null
     * @see com.smartgwt.client.docs.AdvancedFilter AdvancedFilter overview and related methods
     */
    public OperatorId[] getValidOperators()  {
        final String[] strings = getAttributeAsStringArray("validOperators");
        return EnumUtil.getEnums(OperatorId.values(), strings, strings == null ? null : new OperatorId[strings.length]);
    }
    

    /**
     * A {@link com.smartgwt.client.types.ValueMap} is a set of legal values for a field.
     *  <p>
     *  The valueMap can be specified as either an Array of legal values, or as an
     *  {@link java.lang.Object} where each property maps a stored value to a user-displayable value.
     *  <p>
     *  To enforce that a field should be constrained to only the values in the valueMap, either
     *  declare {@link com.smartgwt.client.data.DataSourceField#getType field.type} as "enum", or use a
     *  {@link com.smartgwt.client.types.ValidatorType} of "isOneOf" with explicitly listed values.  Otherwise,
     * although a normal {@link com.smartgwt.client.widgets.form.fields.SelectItem} control will only allow values from the
     * valueMap to be
     * entered, other controls such as a {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBox} will allow other
     * values 
     *  to be entered.
     *  <p>
     *  In XML, a valueMap that specifies only a list of legal values is specified as follows:
     *  <pre>
     *    &lt;valueMap&gt;
     *     &lt;value&gt;Pens &amp; Pencils&lt;/value&gt;
     *     &lt;value&gt;Stationery&lt;/value&gt;
     *     &lt;value&gt;Computer Products&lt;/value&gt;
     *     &lt;value&gt;Furniture&lt;/value&gt;
     *     &lt;value&gt;Misc&lt;/value&gt;
     *    &lt;/valueMap&gt;
     *  </pre>
     *  A ValueMap that specifies stored values mapped to user-visible values is specified as
     *  follows:
     *  <pre>
     *    &lt;valueMap&gt;
     *     &lt;value ID="1"&gt;Pens &amp; Pencils&lt;/value&gt;
     *     &lt;value ID="2"&gt;Stationery&lt;/value&gt;
     *     &lt;value ID="3"&gt;Computer Products&lt;/value&gt;
     *     &lt;value ID="4"&gt;Furniture&lt;/value&gt;
     *     &lt;value ID="5"&gt;Misc&lt;/value&gt;
     *    &lt;/valueMap&gt;
     *  </pre>
     *
     * @param valueMap New valueMap value. Default value is null
     */
    public void setValueMap(Map valueMap) {
        setAttribute("valueMap", valueMap);
    }

    /**
     * A {@link com.smartgwt.client.types.ValueMap} is a set of legal values for a field.
     *  <p>
     *  The valueMap can be specified as either an Array of legal values, or as an
     *  {@link java.lang.Object} where each property maps a stored value to a user-displayable value.
     *  <p>
     *  To enforce that a field should be constrained to only the values in the valueMap, either
     *  declare {@link com.smartgwt.client.data.DataSourceField#getType field.type} as "enum", or use a
     *  {@link com.smartgwt.client.types.ValidatorType} of "isOneOf" with explicitly listed values.  Otherwise,
     * although a normal {@link com.smartgwt.client.widgets.form.fields.SelectItem} control will only allow values from the
     * valueMap to be
     * entered, other controls such as a {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBox} will allow other
     * values 
     *  to be entered.
     *  <p>
     *  In XML, a valueMap that specifies only a list of legal values is specified as follows:
     *  <pre>
     *    &lt;valueMap&gt;
     *     &lt;value&gt;Pens &amp; Pencils&lt;/value&gt;
     *     &lt;value&gt;Stationery&lt;/value&gt;
     *     &lt;value&gt;Computer Products&lt;/value&gt;
     *     &lt;value&gt;Furniture&lt;/value&gt;
     *     &lt;value&gt;Misc&lt;/value&gt;
     *    &lt;/valueMap&gt;
     *  </pre>
     *  A ValueMap that specifies stored values mapped to user-visible values is specified as
     *  follows:
     *  <pre>
     *    &lt;valueMap&gt;
     *     &lt;value ID="1"&gt;Pens &amp; Pencils&lt;/value&gt;
     *     &lt;value ID="2"&gt;Stationery&lt;/value&gt;
     *     &lt;value ID="3"&gt;Computer Products&lt;/value&gt;
     *     &lt;value ID="4"&gt;Furniture&lt;/value&gt;
     *     &lt;value ID="5"&gt;Misc&lt;/value&gt;
     *    &lt;/valueMap&gt;
     *  </pre>
     *
     * @return Current valueMap value. Default value is null
     */
    public Map getValueMap()  {
        return getAttributeAsMap("valueMap");
    }
    
    
    

    /**
     * XPath expression used to retrieve the field's value.
     *  <P>
     *  This XPath expression will be evaluated in the scope of the record objects selected by 
     *  the {@link com.smartgwt.client.data.DataSource#getRecordXPath DataSource.recordXPath}.  For XML data 
     *  ({@link com.smartgwt.client.data.DataSource#getDataFormat dataFormat:"xml"}) this means a call to
     * {@link com.smartgwt.client.data.XMLTools#selectString XMLTools.selectString()} passing the selected XML element.  For
     * JSON data
     *  ({@link com.smartgwt.client.data.DataSource#getDataFormat dataFormat:"json"}), this means a call to 
     *  {@link com.smartgwt.client.data.XMLTools#selectObjects XMLTools.selectObjects()} passing the selected JSON object.
     *  <P>
     *  In the absence of a <code>valueXPath</code>, for JSON data the value for the field will
     *  be the value of the same-named property in the record object selected by
     *  {@link com.smartgwt.client.data.DataSource#getRecordXPath recordXPath}.  
     *  <P>
     *  For XML data, the value will be the attribute or subelement named after the field name.
     *  For example, for a field "author" on a record element &lt;book&gt;, the following structures
     *  require no valueXPath:
     *  <pre>
     *     &lt;book author="Mark Jones"/&gt;
     * 
     *     &lt;book&gt;
     *         &lt;author&gt;Mark Jones&lt;/author&gt;
     *     &lt;/book&gt;
     *  </pre>
     *  <P>
     *  If <code>valueXPath</code> is not required for your field because of the default handling
     *  described above, don't specify it, as it's slightly slower.
     *  <p>
     *  To learn about XPath, try the following search:
     *  <a href="http://www.google.com/search?q=xpath+tutorial" target="_blank"
     *  >http://www.google.com/search?q=xpath+tutorial</a>
     *  <P>
     *  <B>Using valueXPath with the Smart GWT server</B>
     *  <p>
     *  If you're using the Smart GWT server to return data via the DSResponse object (or
     *  indirectly doing so using DataSource DMI), the valueXPath you specify on the DataSource
     *  fields will be applied to the data you return via the 
     *  <a href='http://commons.apache.org/jxpath/' target='_blank'>JXPath</a> library.
     *  <P>
     *  If you are returning Java Beans as your DSResponse data, normally each dataSource field
     *  receives the value of the same-named Java Bean property, that is, a field "zipCode" is
     *  populated by looking for "getZipCode()" on the objects passed as DSResponse data.  You can
     *  use <code>valueXPath</code> to retrieve properties from subobjects, so long as a chain of
     *  getter methods exists that corresponds to the valueXPath.  For example, a valueXPath of
     *  "address/zipCode" expects to call "getAddress()" on the bean(s) passed to
     *  DSResponse.setData(), followed by "getZipCode()" on whatever object "getAddress()" returns.
     *  <P>
     *  When you are saving data, the inbound DSRequest values, available as a Java Map, will use 
     *  just dataSource field names as Map keys, not the valueXPath used to derive them.  However,
     *  to achieve bidirectional valueXPath binding, you can use the server-side method
     *  dataSource.setProperties() to use the valueXPath when setting properties on your server
     *  object model.  When applied as a setter, an XPath like "address/zipCode" attempts
     *  "getAddress()" followed by "setZipCode()" on the returned object.  JXPath also has some
     *  ability to auto-create intervening objects if they are missing, such as auto-creating an
     *  "address" subobject when applying "address/zipCode" as a valueXPath.
     *  <P>
     *  See the
     *  <a href='http://jakarta.apache.org/commons/jxpath/' target='_blank'>JXPath</a> library documentation for
     *  complete details, including other types of server object models supported, such as
     *  server-side XML.
     *
     * @param valueXPath New valueXPath value. Default value is null
     * @see com.smartgwt.client.docs.XPathExpression XPathExpression 
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#xpath_xml_integration_category" target="examples">XPath Binding Example</a>
     */
    public void setValueXPath(String valueXPath) {
        setAttribute("valueXPath", valueXPath);
    }

    /**
     * XPath expression used to retrieve the field's value.
     *  <P>
     *  This XPath expression will be evaluated in the scope of the record objects selected by 
     *  the {@link com.smartgwt.client.data.DataSource#getRecordXPath DataSource.recordXPath}.  For XML data 
     *  ({@link com.smartgwt.client.data.DataSource#getDataFormat dataFormat:"xml"}) this means a call to
     * {@link com.smartgwt.client.data.XMLTools#selectString XMLTools.selectString()} passing the selected XML element.  For
     * JSON data
     *  ({@link com.smartgwt.client.data.DataSource#getDataFormat dataFormat:"json"}), this means a call to 
     *  {@link com.smartgwt.client.data.XMLTools#selectObjects XMLTools.selectObjects()} passing the selected JSON object.
     *  <P>
     *  In the absence of a <code>valueXPath</code>, for JSON data the value for the field will
     *  be the value of the same-named property in the record object selected by
     *  {@link com.smartgwt.client.data.DataSource#getRecordXPath recordXPath}.  
     *  <P>
     *  For XML data, the value will be the attribute or subelement named after the field name.
     *  For example, for a field "author" on a record element &lt;book&gt;, the following structures
     *  require no valueXPath:
     *  <pre>
     *     &lt;book author="Mark Jones"/&gt;
     * 
     *     &lt;book&gt;
     *         &lt;author&gt;Mark Jones&lt;/author&gt;
     *     &lt;/book&gt;
     *  </pre>
     *  <P>
     *  If <code>valueXPath</code> is not required for your field because of the default handling
     *  described above, don't specify it, as it's slightly slower.
     *  <p>
     *  To learn about XPath, try the following search:
     *  <a href="http://www.google.com/search?q=xpath+tutorial" target="_blank"
     *  >http://www.google.com/search?q=xpath+tutorial</a>
     *  <P>
     *  <B>Using valueXPath with the Smart GWT server</B>
     *  <p>
     *  If you're using the Smart GWT server to return data via the DSResponse object (or
     *  indirectly doing so using DataSource DMI), the valueXPath you specify on the DataSource
     *  fields will be applied to the data you return via the 
     *  <a href='http://commons.apache.org/jxpath/' target='_blank'>JXPath</a> library.
     *  <P>
     *  If you are returning Java Beans as your DSResponse data, normally each dataSource field
     *  receives the value of the same-named Java Bean property, that is, a field "zipCode" is
     *  populated by looking for "getZipCode()" on the objects passed as DSResponse data.  You can
     *  use <code>valueXPath</code> to retrieve properties from subobjects, so long as a chain of
     *  getter methods exists that corresponds to the valueXPath.  For example, a valueXPath of
     *  "address/zipCode" expects to call "getAddress()" on the bean(s) passed to
     *  DSResponse.setData(), followed by "getZipCode()" on whatever object "getAddress()" returns.
     *  <P>
     *  When you are saving data, the inbound DSRequest values, available as a Java Map, will use 
     *  just dataSource field names as Map keys, not the valueXPath used to derive them.  However,
     *  to achieve bidirectional valueXPath binding, you can use the server-side method
     *  dataSource.setProperties() to use the valueXPath when setting properties on your server
     *  object model.  When applied as a setter, an XPath like "address/zipCode" attempts
     *  "getAddress()" followed by "setZipCode()" on the returned object.  JXPath also has some
     *  ability to auto-create intervening objects if they are missing, such as auto-creating an
     *  "address" subobject when applying "address/zipCode" as a valueXPath.
     *  <P>
     *  See the
     *  <a href='http://jakarta.apache.org/commons/jxpath/' target='_blank'>JXPath</a> library documentation for
     *  complete details, including other types of server object models supported, such as
     *  server-side XML.
     *
     * @return Current valueXPath value. Default value is null
     * @see com.smartgwt.client.docs.XPathExpression XPathExpression 
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#xpath_xml_integration_category" target="examples">XPath Binding Example</a>
     */
    public String getValueXPath()  {
        return getAttributeAsString("valueXPath");
    }
    
    
    
    

    /**
     * Indicates that {@link com.smartgwt.client.data.DataSource#xmlSerialize DataSource.xmlSerialize()} should serialize this
     * value as an XML attribute. <P> Note this does not need to be declared in order for DataSource records to be derived from
     * XML data: a field will be populated with either an attribute or subelement with matching name.
     *
     * @param xmlAttribute New xmlAttribute value. Default value is null
     * @see com.smartgwt.client.docs.ComponentSchema ComponentSchema overview and related methods
     */
    public void setXmlAttribute(Boolean xmlAttribute) {
        setAttribute("xmlAttribute", xmlAttribute);
    }

    /**
     * Indicates that {@link com.smartgwt.client.data.DataSource#xmlSerialize DataSource.xmlSerialize()} should serialize this
     * value as an XML attribute. <P> Note this does not need to be declared in order for DataSource records to be derived from
     * XML data: a field will be populated with either an attribute or subelement with matching name.
     *
     * @return Current xmlAttribute value. Default value is null
     * @see com.smartgwt.client.docs.ComponentSchema ComponentSchema overview and related methods
     */
    public Boolean getXmlAttribute()  {
        return getAttributeAsBoolean("xmlAttribute", true);
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************


    /**
     * Set the plural title.
     *
     * @param pluralTitle the plural title
     */
    public void setPluralTitle(String pluralTitle) {
        setAttribute("pluralTitle", pluralTitle);
    }

    /**
     * Return the plural title.
     *
     *
     * @return String
     */
    public String getPluralTitle()  {
        return getAttributeAsString("pluralTitle");
    }

    /**
     * Set the type directly to a defined SimpleType.
     *
     * @param type the SimpleType
     */
    public void setType(SimpleType type) {
        //ensure that the simple type is created and registered
        type.getOrCreateJsObj();
        setAttribute("type", type.getName());
    }

    /**
     * A ValueMap is a set of legal values for a field.&#010 <p>&#010 The valueMap can be specified as either an Array of legal
     * values, or as an&#010 Object where each property maps a stored value to a user-displayable value.&#010 <p>&#010 To
     * enforce that a field should be constrained to only the values in the valueMap, either&#010 declare {@link
     * com.smartgwt.client.data.DataSourceField#getType field.type} as "enum", or use a&#010 {@link
     * com.smartgwt.client.types.ValidatorType} of "isOneOf" with explicitly listed values.  Otherwise,&#010 although a normal
     * {@link com.smartgwt.client.widgets.form.fields.SelectItem} control will only allow values from the valueMap to be&#010
     * entered, other controls such as a {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem ComboBox} will allow other
     * values &#010 to be entered.&#010 <p>&#010 In XML, a valueMap that specifies only a list of legal values is specified as
     * follows:&#010 <pre>&#010   &lt;valueMap&gt;&#010    &lt;value&gt;Pens &amp; Pencils&lt;/value&gt;&#010
     * &lt;value&gt;Stationery&lt;/value&gt;&#010    &lt;value&gt;Computer Products&lt;/value&gt;&#010
     * &lt;value&gt;Furniture&lt;/value&gt;&#010    &lt;value&gt;Misc&lt;/value&gt;&#010   &lt;/valueMap&gt;&#010 </pre>&#010 A
     * ValueMap that specifies stored values mapped to user-visible values is specified as&#010 follows:&#010 <pre>&#010
     * &lt;valueMap&gt;&#010    &lt;value ID="1"&gt;Pens &amp; Pencils&lt;/value&gt;&#010    &lt;value
     * ID="2"&gt;Stationery&lt;/value&gt;&#010    &lt;value ID="3"&gt;Computer Products&lt;/value&gt;&#010    &lt;value
     * ID="4"&gt;Furniture&lt;/value&gt;&#010    &lt;value ID="5"&gt;Misc&lt;/value&gt;&#010   &lt;/valueMap&gt;&#010 </pre>
     *
     * @param valueMap valueMap Default value is null
     */
    public void setValueMap(String... valueMap) {
        setAttribute("valueMap", valueMap);
    }

    /**
     * Set the default {@link FormItem} properties to be used whenever this
     * field is edited (whether in a grid, form, or other component).
     * <p> 
     * If unset, a FormItem will be automatically chosen based on the type of the field.
     * <p>
     * <b>Note</b>: The FormItem passed to setEditorProperties() is used as a "template" to create a FormItem whenever
     * a {@link com.smartgwt.client.widgets.DataBoundComponent} needs to show an interface for editing this 
     * field.  This means you need to follow special rules:
     * <ol>
     * <li>In event handler code, you must obtain the current FormItem instance from the provided
     *   Event object via getItem().  You cannot make method calls via "this" or via implicit instance
     *   scope: both "clearValue()" and "this.clearValue()" need to be written as "item.clearValue()"
     *   instead (where "item" is the result of event.getItem()).</li>
     * <li>To store custom instance variables, you must use FormItem.getAttribute()/setAttribute()
     *   (or their type-specific variants).  You cannot store and retrieve instance variables
     *   via "this" - "this.someVariable = 5" will not work.</li>
     * <li>You may not override superclass methods - your behaviors have to be implemented via event handlers</li>
     * <li>If you create a custom subclass, the FormItem you receive in an event handler will be of a generic
     *   type and must be converted before you can call custom methods.  Conversion is done via
     *   <code>new MyCustomItem(item.getJsObj());</code> (complete code sample below).<br>
     *   Note that this conversion does not actually cause creation or rendering of a new
     *   widget and is comparable in cost to a typecast.</li>
     * </ol>
     * Example code demonstrating using an eventHandler to call a method on custom subclass of TextItem:
     * <pre>
     * class MyCustomItem extends TextItem {
     *      MyCustomItem (JavaScriptObject config) {
     *      }
     *
     *      MyCustomItem(String name) {
     *          setInitHandler(new FormItemInitHandler() {
     *              public void onInit(FormItem item) {
     *                  // correct
     *                  new MyCustomItem(item.getJsObj()).customMethod();
     *
     *                  // incorrect, will throw an error
     *                  // ((MyCustomItem)item).customMethod();
     *              }
     *          }
     *      }
     *
     *      void customMethod() { ... }
     *  }
     *
     *  ...
     *
     *  myDataSourceField.setEditorProperties(new MyCustomItem("field1"));
     * </pre>
     * <p>
     * As an alternative, you can use {@link setEditorType(String)} or
     * {@link setEditorType(Class)} to avoid these limitations, if you register
     * the FormItem subclass with the {@link com.smartgwt.client.docs.Reflection reflection mechanism}.
     *
     * @param editorProperties FormItem with default properties to be applied when editing
     */
    public void setEditorProperties(FormItem editorProperties) {
        if (editorProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), "setEditorProperties", "FormItem");
        }                                                                       
        editorProperties.setConfigOnly(true);

        // only set the editorType attribute if the passed editorType is a concrete subclass of FormItem
        if (editorProperties.getClass() != FormItem.class) {
            String fiEditorType = editorProperties.getAttribute("editorType");
            // fallback to type if editorType is not specified
            if (fiEditorType == null) fiEditorType = editorProperties.getType();
            if (fiEditorType != null) setAttribute("editorType", fiEditorType);
        }
        JavaScriptObject editorConfig = editorProperties.getConfig();
        setAttribute("editorProperties", editorConfig);
    }

    /**
     * Synonym for {@link setEditorProperties(FormItem)}.
     *
     * @param editorType FormItem with default properties to be applied when editing
     * @deprecated Renamed to {@link setEditorProperties(FormItem)}. You can also consider using 
     *             {@link setEditorType(Class)} or {@link setEditorType(String)} instead.
     */
    public void setEditorType(FormItem editorType) {
        setEditorProperties(editorType);
    }
    
    /**
     * Set the default {@link FormItem} class to be used whenever this field is edited
     * (whether in a grid, form, or other component).
     * <p>
     * If unset, a FormItem will be automatically chosen based on the type of the field.
     * <p>
     * By using the {@link com.smartgwt.client.docs.Reflection reflection mechanism}, 
     * this method avoids the limitations described in {@link setEditorProperties(FormItem)}.
     *
     * @param editorType the fully-qualified class name of a {@link com.smartgwt.client.widgets.form.fields.FormItem}
     *                   subclass, which must have been registered with the 
     *                   {@link com.smartgwt.client.docs.Reflection reflection mechanism}. 
     * @throws IllegalArgumentException if the editorType class has not beeen registered for use with the 
     *                                  {@link com.smartgwt.client.docs.Reflection reflection mechanism},
     *                                  or if it does not inherit from 
     *                                  {@link com.smartgwt.client.widgets.form.fields.FormItem}.
    **/
    public void setEditorType(String editorType) {
        com.smartgwt.client.bean.BeanFactory factory = com.smartgwt.client.bean.BeanFactory.getFactory(editorType);
        if (factory == null) {
            throw new IllegalArgumentException("No BeanFactory has been registered for: " + editorType);
        } else if (!com.smartgwt.client.bean.BeanValueType.isAssignableFrom(FormItem.class, factory.getBeanClass())) {
            throw new IllegalArgumentException("The editorType: " + editorType + " does not inherit from FormItem");
        }
        setAttribute("editorType", editorType);
    }

    /**
     * Set the default {@link FormItem} class to be used whenever this field is edited
     * (whether in a grid, form, or other component).
     * <p>
     * If unset, a FormItem will be automatically chosen based on the type of the field.
     * <p>
     * By using the {@link com.smartgwt.client.docs.Reflection reflection mechanism}, 
     * this method avoids the limitations described in {@link setEditorProperties(FormItem)}.
     *
     * @param editorType a {@link com.smartgwt.client.widgets.form.fields.FormItem}
     *                   subclass, which must have been registered with the 
     *                   {@link com.smartgwt.client.docs.Reflection reflection mechanism}. 
     * @throws IllegalArgumentException if the editorType class has not beeen registered for use with the 
     *                                  {@link com.smartgwt.client.docs.Reflection reflection mechanism},
     *                                  or if it does not inherit from 
     *                                  {@link com.smartgwt.client.widgets.form.fields.FormItem}.
    **/
    public void setEditorType(Class<? extends FormItem> editorType) {
        setEditorType(editorType.getName());
    }

    /**
     * Synonym for {@link setReadOnlyEditorProperties(FormItem)}.
     *
     * @param editorType FormItem with properties to set when editing read-only values.
     * @deprecated Renamed to {@link setReadOnlyEditorProperties(FormItem)}. You can
     *             also consider using {@link setReadOnlyEditorType(Class)} or
     *             {@link setReadOnlyEditorType(String)} instead.
     */
    public void setReadOnlyEditorType(FormItem editorType) {
        setReadOnlyEditorProperties(editorType);
    }

    /**
     * Sets the default FormItem properties to be used if this field is marked as
     * {@link setCanEdit(Boolean) canEdit false} and displayed in an editor component such as a DynamicForm.
     * <p>
     * This property may also be specified at the type level by specifying
     * {@link com.smartgwt.client.data.SimpleType#setReadOnlyEditorType(FormItem)}.
     * <p>
     * <b>Note</b>: The FormItem passed to setReadOnlyEditorProperties() is used as a "template" to create a FormItem whenever
     * a {@link com.smartgwt.client.widgets.DataBoundComponent} needs to show an interface for editing this 
     * field (and the field is marked read-only). This means you need to follow special rules indicated
     * for {@link setEditorProperties(FormItem)}. 
     * As an alternative, you can use {@link setReadOnlyEditorType(String)} or
     * {@link setReadOnlyEditorType(Class)} to avoid these limitations, if you register
     * the FormItem subclass with the {@link com.smartgwt.client.docs.Reflection reflection mechanism}.
     *
     * @param editorProperties FormItem with properties to set when editing read-only values.
     */
    public void setReadOnlyEditorProperties(FormItem editorProperties) {
        if (editorProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), "setReadOnlyEditorProperties", "FormItem");
        }                                                                       
        editorProperties.setConfigOnly(true);

        // only set the editorType attribute if the passed editorType is a concrete subclass of FormItem
        if (editorProperties.getClass() != FormItem.class) {
            String fiEditorType = editorProperties.getAttribute("editorType");
            // fallback to type if editorType is not specified
            if(fiEditorType == null) fiEditorType = editorProperties.getType();
            if (fiEditorType != null) setAttribute("readOnlyEditorType", fiEditorType);
        }
        JavaScriptObject editorConfig = editorProperties.getConfig();
        setAttribute("readOnlyEditorProperties", editorConfig);
    }

    /**
     * Sets the default FormItem class to be used if this field is marked as 
     * {@link setCanEdit(Boolean) canEdit false} and displayed in an editor component 
     * such as a DynamicForm.
     * <p>
     * By using the {@link com.smartgwt.client.docs.Reflection reflection mechanism}, 
     * this method avoids the limitations described in {@link setReadOnlyEditorProperties(FormItem)}.
     * 
     * @param editorType a {@link com.smartgwt.client.widgets.form.fields.FormItem}
     *                   subclass, which must have been registered with the 
     *                   {@link com.smartgwt.client.docs.Reflection reflection mechanism}. 
     * @throws IllegalArgumentException if the editorType class has not beeen registered for use with the 
     *                                  {@link com.smartgwt.client.docs.Reflection reflection mechanism},
     *                                  or if it does not inherit from 
     *                                  {@link com.smartgwt.client.widgets.form.fields.FormItem}.
    **/
    public void setReadOnlyEditorType(String editorType) {
        com.smartgwt.client.bean.BeanFactory factory = com.smartgwt.client.bean.BeanFactory.getFactory(editorType);
        if (factory == null) {
            throw new IllegalArgumentException("No BeanFactory has been registered for: " + editorType);
        } else if (!com.smartgwt.client.bean.BeanValueType.isAssignableFrom(FormItem.class, factory.getBeanClass())) {
            throw new IllegalArgumentException("The editorType: " + editorType + " does not inherit from FormItem");
        }
        setAttribute("readOnlyEditorType", editorType);
    }

    /**
     * Sets the default {@link FormItem} class to be used if this field is marked as 
     * {@link setCanEdit(Boolean) canEdit false} and displayed in an editor component such as a DynamicForm.
     * <p>
     * By using the {@link com.smartgwt.client.docs.Reflection reflection mechanism}, 
     * this method avoids the limitations described in {@link setReadOnlyEditorProperties(FormItem)}.
     * 
     * @param editorType a {@link com.smartgwt.client.widgets.form.fields.FormItem}
     *                   subclass, which must have been registered with the 
     *                   {@link com.smartgwt.client.docs.Reflection reflection mechanism}. 
     * @throws IllegalArgumentException if the editorType class has not beeen registered for use with the 
     *                                  {@link com.smartgwt.client.docs.Reflection reflection mechanism},
     *                                  or if it does not inherit from 
     *                                  {@link com.smartgwt.client.widgets.form.fields.FormItem}.
    **/
    public void setReadOnlyEditorType(Class<? extends FormItem> editorType) {
        setReadOnlyEditorType(editorType.getName());
    }

    /**
     * Set the default {@link FormItem} properties to be used whenever this
     * field if it appears in a {@link com.smartgwt.client.widgets.grid.ListGrid} filter row,
     * and {@link com.smartgwt.client.data.DataSourceField#getCanFilter canFilter} is not false.
     * <P> Note: If this is not specified, the formItem type may be derived from the 
     * {@link com.smartgwt.client.data.DataSourceField#getFilterEditorType filterEditorType}
     * property, or from the field's {@link com.smartgwt.client.data.DataSourceField#getType type}.
     * <p>
     * <b>Note</b>: The FormItem passed to <code>setFilterEditorProperties()</code> is used as a
     * "template" to create a FormItem.  See rules in 
     * {@link com.smartgwt.client.data.DataSourceField#setEditorProperties}.
     *
     * @param filterEditorProperties FormItem with default properties to be applied
     */
    public void setFilterEditorProperties(FormItem filterEditorProperties) {
        if (filterEditorProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), "setFilterEditorProperties", "FormItem");
        }                                                                       
        filterEditorProperties.setConfigOnly(true);

        // only set the filterEditorType attribute if the passed fitlerEditorType is a
        // concrete subclass of FormItem
        if (filterEditorProperties.getClass() != FormItem.class) {
            String fiEditorType = filterEditorProperties.getAttribute("filterEditorType");
            // fallback to type if editorType is not specified
            if (fiEditorType == null) fiEditorType = filterEditorProperties.getType();
            if (fiEditorType != null) setAttribute("filterEditorType", fiEditorType);
        }
        JavaScriptObject editorConfig = filterEditorProperties.getConfig();
        setAttribute("filterEditorProperties", editorConfig);
    }

    /**
     * Set the default {@link FormItem} class to be used whenever this field appears
     * in a {@link com.smartgwt.client.widgets.grid.ListGrid} filter row or 
     * {@link com.smartgwt.client.widgets.form.SearchForm}.
     * <p>
     * If unset, a FormItem will be automatically chosen based on the type of the field.
     * <p>
     * By using the {@link com.smartgwt.client.docs.Reflection reflection mechanism}, 
     * this method avoids the limitations described in {@link setFilterEditorProperties(FormItem)}.
     *
     * @param filterEditorType the fully-qualified class name of a 
     *     {@link com.smartgwt.client.widgets.form.fields.FormItem} subclass, which must have
     *     been registered with the {@link com.smartgwt.client.docs.Reflection reflection mechanism}. 
     * @throws IllegalArgumentException if the filterEditorType class has not beeen registered
     *     for use with the {@link com.smartgwt.client.docs.Reflection reflection mechanism},
     *     or if it does not inherit from {@link com.smartgwt.client.widgets.form.fields.FormItem}.
     **/
    public void setFilterEditorType(String filterEditorType) {
        com.smartgwt.client.bean.BeanFactory factory = 
            com.smartgwt.client.bean.BeanFactory.getFactory(filterEditorType);
        if (factory == null) {
            throw new IllegalArgumentException("No BeanFactory has been registered for: " +
                                               filterEditorType);
        } else if (!com.smartgwt.client.bean.BeanValueType.isAssignableFrom(FormItem.class,
                                                                   factory.getBeanClass()))
        {
            throw new IllegalArgumentException("The filterEditorType: " + filterEditorType +
                                               " does not inherit from FormItem");
        }
        setAttribute("filterEditorType", filterEditorType);
    }

    /**
     * Set the default {@link FormItem} class to be used whenever this field appears
     * in a {@link com.smartgwt.client.widgets.grid.ListGrid} filter row or 
     * {@link com.smartgwt.client.widgets.form.SearchForm}.
     * <p>
     * If unset, a FormItem will be automatically chosen based on the type of the field.
     * <p>
     * By using the {@link com.smartgwt.client.docs.Reflection reflection mechanism}, 
     * this method avoids the limitations described in {@link setFilterEditorProperties(FormItem)}.
     *
     * @param editorType a {@link com.smartgwt.client.widgets.form.fields.FormItem}
     *     subclass, which must have been registered with the
     *     {@link com.smartgwt.client.docs.Reflection reflection mechanism}.
     * @throws IllegalArgumentException if the filterEditorType class has not beeen registered
     *     for use with the {@link com.smartgwt.client.docs.Reflection reflection mechanism},
     *     or if it does not inherit from {@link com.smartgwt.client.widgets.form.fields.FormItem}.
     **/
    public void setFilterEditorType(Class<? extends FormItem> filterEditorType) {
        setFilterEditorType(filterEditorType.getName());
    }

    /**
     * For a field that is a foreignKey establishing a tree relationship, what value indicates a root-level node.
     * Defaults to null.
     *
     * @param rootValue rootValue Default value is null
     */
    public void setRootValue(String rootValue) {
        setAttribute("rootValue", rootValue);
    }

    /**
     * For a field that is a foreignKey establishing a tree relationship, what value indicates a root-level node.
     * Defaults to null.
     *
     * @param rootValue rootValue Default value is null
     */
    public void setRootValue(Integer rootValue) {
        setAttribute("rootValue", rootValue);
    }

    /**
     * For a field that is a foreignKey establishing a tree relationship, what value indicates a root-level node.
     * Defaults to null.
     *
     * @param rootValue rootValue Default value is null
     */
    public void setRootValue(Float rootValue) {
        setAttribute("rootValue", rootValue);
    }

    /**
     * Function to retrieve the field's value from the XML element or JSON record returned
     * from a web service. <P> This is an advanced API for use when a {@link com.smartgwt.client.data.DataSourceField#getValueXPath
     * valueXPath} setting is insufficient to derive a field's value, yet an implementation of {@link
     * com.smartgwt.client.data.DataSource#transformResponse} is overkill.
     *
     * @param extractor the field value extractor
     */
    public native void setFieldValueExtractor(FieldValueExtractor extractor) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.getFieldValue = $debox($entry(function(record, value, field, fieldName) {
            var valueJ =  $wnd.SmartGWT.convertToJavaType(value);
            var fieldJ = @com.smartgwt.client.data.DataSourceField::new(Lcom/google/gwt/core/client/JavaScriptObject;)(field);

            var extractedVal = extractor.@com.smartgwt.client.data.FieldValueExtractor::execute(Ljava/lang/Object;Ljava/lang/Object;Lcom/smartgwt/client/data/DataSourceField;Ljava/lang/String;)(record, valueJ, fieldJ, fieldName);
            return $wnd.SmartGWT.convertToPrimitiveType(extractedVal);

        }));
    }-*/;

    /**
     * The type can also be the another DataSource, which allows you to model nested structures such as XML documents (in fact, XMLTools.loadXMLSchema()
     * models XML schema in this way). Nested DataSource declarations affect how XML and JSON data is deserialized into JavaScript objects in the
     * client-side integration pipeline, so that you can load complex XML documents and have them deserialized into a correctly typed JavaScript object model.
     *
     * @param dataSource the data source
     * @deprecated use #setTypeAsDataSource
     */
    public void setType(DataSource dataSource) {
        dataSource.getOrCreateJsObj();
        setAttribute("type", dataSource.getID());
    }

    /**
     * The type can also be the another DataSource, which allows you to model nested structures such as XML documents (in fact, XMLTools.loadXMLSchema()
     * models XML schema in this way). Nested DataSource declarations affect how XML and JSON data is deserialized into JavaScript objects in the
     * client-side integration pipeline, so that you can load complex XML documents and have them deserialized into a correctly typed JavaScript object model.
     *
     * @param dataSource the data source
     */
    public void setTypeAsDataSource(DataSource dataSource) {
        dataSource.getOrCreateJsObj();
        setAttribute("type", dataSource.getID());
    }

    /**
     * Return the type of the assigned DataSource
     *
     * @return the DataSource
     */
    public DataSource getTypeAsDataSource() {
        return DataSource.get(getAttribute("type"));
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary showGridSummary} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary showGroupSummary} is true,  this attribute can be used to
     * specify an explicit {@link com.smartgwt.client.widgets.grid.SummaryFunction} for calculating the summary value to display.
     *
     * @param summaryFunction summaryFunction Default value is null
     */
    public void setSummaryFunction(SummaryFunctionType summaryFunction) {
        setAttribute("summaryFunction", summaryFunction);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary showGridSummary} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary showGroupSummary} is true,  this attribute can be used to
     * specify an summary function registered via {@link com.smartgwt.client.data.SimpleType#registerSummaryFunction()}
     * for calculating the summary value to display.
     * @param summaryFunction summaryFunction Default value is null
     */
    public void setSummaryFunction(String summaryFunction) {
        setAttribute("summaryFunction", summaryFunction);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary showGridSummary} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary showGroupSummary} is true,  this attribute can be used to
     * specify an explicit {@link com.smartgwt.client.widgets.grid.SummaryFunction} for calculating the summary value to display.
     *
     *
     * @return SummaryFunctionType
     */
    public SummaryFunctionType getSummaryFunction()  {
        return EnumUtil.getEnum(SummaryFunctionType.values(), getAttribute("summaryFunction"));
    }


    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary showGridSummary} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary showGroupSummary} is true,  this attribute can be used to
     * specify an explicit {@link com.smartgwt.client.widgets.grid.SummaryFunction} for calculating the summary value to display.
     *
     * @param summaryFunction summaryFunction Default value is null
     */
    public native void setSummaryFunction(SummaryFunction summaryFunction) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.summaryFunction = $entry(function(records, field) {
            var recordsJ =  @com.smartgwt.client.util.ConvertTo::arrayOfRecord(Lcom/google/gwt/core/client/JavaScriptObject;)(records);
            var fieldJ = @com.smartgwt.client.widgets.grid.ListGridField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(field);
            var val = summaryFunction.@com.smartgwt.client.widgets.grid.SummaryFunction::getSummaryValue([Lcom/smartgwt/client/data/Record;Lcom/smartgwt/client/widgets/grid/ListGridField;)(recordsJ, fieldJ);
            return $wnd.SmartGWT.convertToPrimitiveType(val);
        });
    }-*/;

    private static boolean isDataSourceField(JavaScriptObject jsObj) {
        Object ref = JSOHelper.getAttributeAsObject(jsObj, SC.REF);
        return ref != null && ref instanceof DataSourceField;
    }

    /**
     * Height of the image-content of this field.  If set as a string, represents the name of  another field in the record that
     * holds the imageHeight.  Applicable only to fields of image  type or fields that use a {@link
     * com.smartgwt.client.widgets.form.fields.ViewFileItem ViewFileItem} as an editor.
     *
     * @param imageHeight imageHeight Default value is null
     */
    public void setImageHeight(Integer imageHeight) {
        setAttribute("imageHeight", imageHeight);
    }

    /**
     * Height of the image-content of this field.  If set as a string, represents the name of  another field in the record that
     * holds the imageHeight.  Applicable only to fields of image  type or fields that use a {@link
     * com.smartgwt.client.widgets.form.fields.ViewFileItem ViewFileItem} as an editor.
     *
     *
     * @return Integer
     */
    public Integer getImageHeight()  {
        return getAttributeAsInt("imageHeight");
    }

    /**
     * Height of the image-content of this field.  If set as a string, represents the name of  another field in the record that
     * holds the imageHeight.  Applicable only to fields of image  type or fields that use a {@link
     * com.smartgwt.client.widgets.form.fields.ViewFileItem ViewFileItem} as an editor.
     *
     * @param imageHeight imageHeight Default value is null
     */
    public void setImageHeight(String imageHeight) {
        setAttribute("imageHeight", imageHeight);
    }

    /**
     * Height of the image-content of this field.  If set as a string, represents the name of  another field in the record that
     * holds the imageHeight.  Applicable only to fields of image  type or fields that use a {@link
     * com.smartgwt.client.widgets.form.fields.ViewFileItem ViewFileItem} as an editor.
     *
     *
     * @return String
     */
    public String getImageHeightAsString()  {
        return getAttributeAsString("imageHeight");
    }

    /**
     * Width and height of the image-content of this field.  If set as a string, represents the  name of another field in the
     * record that holds the imageSize.  Applicable only to fields  of image type or fields that use a {@link
     * com.smartgwt.client.widgets.form.fields.ViewFileItem ViewFileItem} as an editor.
     *
     * @param imageSize imageSize Default value is null
     */
    public void setImageSize(Integer imageSize) {
        setAttribute("imageSize", imageSize);
    }

    /**
     * Width and height of the image-content of this field.  If set as a string, represents the  name of another field in the
     * record that holds the imageSize.  Applicable only to fields  of image type or fields that use a {@link
     * com.smartgwt.client.widgets.form.fields.ViewFileItem ViewFileItem} as an editor.
     *
     *
     * @return Integer
     */
    public Integer getImageSize()  {
        return getAttributeAsInt("imageSize");
    }

    /**
     * Width and height of the image-content of this field.  If set as a string, represents the  name of another field in the
     * record that holds the imageSize.  Applicable only to fields  of image type or fields that use a {@link
     * com.smartgwt.client.widgets.form.fields.ViewFileItem ViewFileItem} as an editor.
     *
     * @param imageSize imageSize Default value is null
     */
    public void setImageSize(String imageSize) {
        setAttribute("imageSize", imageSize);
    }

    /**
     * Width and height of the image-content of this field.  If set as a string, represents the  name of another field in the
     * record that holds the imageSize.  Applicable only to fields  of image type or fields that use a {@link
     * com.smartgwt.client.widgets.form.fields.ViewFileItem ViewFileItem} as an editor.
     *
     *
     * @return String
     */
    public String getImageSizeAsString()  {
        return getAttributeAsString("imageSize");
    }

    /**
     * Width of the image-content of this field.  If set as a string, represents the name of  another field in the record that
     * holds the imageWidth.  Applicable only to fields of image  type or fields that use a {@link
     * com.smartgwt.client.widgets.form.fields.ViewFileItem ViewFileItem} as an editor.
     *
     * @param imageWidth imageWidth Default value is null
     */
    public void setImageWidth(Integer imageWidth) {
        setAttribute("imageWidth", imageWidth);
    }

    /**
     * Width of the image-content of this field.  If set as a string, represents the name of  another field in the record that
     * holds the imageWidth.  Applicable only to fields of image  type or fields that use a {@link
     * com.smartgwt.client.widgets.form.fields.ViewFileItem ViewFileItem} as an editor.
     *
     *
     * @return Integer
     */
    public Integer getImageWidth()  {
        return getAttributeAsInt("imageWidth");
    }

    /**
     * Width of the image-content of this field.  If set as a string, represents the name of  another field in the record that
     * holds the imageWidth.  Applicable only to fields of image  type or fields that use a {@link
     * com.smartgwt.client.widgets.form.fields.ViewFileItem ViewFileItem} as an editor.
     *
     * @param imageWidth imageWidth Default value is null
     */
    public void setImageWidth(String imageWidth) {
        setAttribute("imageWidth", imageWidth);
    }

    /**
     * Width of the image-content of this field.  If set as a string, represents the name of  another field in the record that
     * holds the imageWidth.  Applicable only to fields of image  type or fields that use a {@link
     * com.smartgwt.client.widgets.form.fields.ViewFileItem ViewFileItem} as an editor.
     *
     *
     * @return String
     */
    public String getImageWidthAsString()  {
        return getAttributeAsString("imageWidth");
    }

    /**
     * Causes a tooltip hover to appear on the header generated for this data source field (effectively sets {@link
     * com.smartgwt.client.widgets.Canvas#getPrompt prompt} for the header).
     *
     * @param prompt prompt Default value is null
     */
    public void setPrompt(String prompt) {
        setAttribute("prompt", prompt);
    }

    /**
     * Causes a tooltip hover to appear on the header generated for this field (effectively sets {@link
     * com.smartgwt.client.widgets.Canvas#getPrompt prompt} for the header).
     *
     * @return String
     */
    public String getPrompt() {
        return getAttributeAsString("prompt");
    }


    /**
     * Controls whether, by default, dataBoundComponents consider this field editable. <P> Set to <code>false</code> to draw
     * this field read-only.   <P> This attribute may not effect all dataBoundComponents - the  {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getCanEditFieldAttribute canEditFieldAttribute} may be set at the
     * component level to look for a different attribute on the dataSourceField, and components allow developers to explicitly
     * override this default (see {@link com.smartgwt.client.widgets.grid.ListGridField#getCanEdit canEdit}. {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit canEdit} for example). <P> Note that this setting only
     * prevents the user from  modifying the field's value through the UI; the value can still be modified  programmatically,
     * and it will still be saved in the normal way.  If you wish to prevent a field from being saved, use {@link
     * com.smartgwt.client.data.DataSourceField#getCanSave canSave}:false instead (or in addition).
     *
     * @param canEdit canEdit Default value is null
     * @see com.smartgwt.client.data.DataSourceField#setCanFilter
     * @see com.smartgwt.client.data.DataSourceField#setCanSave
     * @see com.smartgwt.client.docs.ComponentBinding ComponentBinding overview and related methods
     */
    public void setCanEdit(Boolean canEdit) {
        setAttribute("canEdit", canEdit);
    }

    /**
     * Controls whether, by default, dataBoundComponents consider this field editable. <P> Set to <code>false</code> to draw
     * this field read-only.   <P> This attribute may not effect all dataBoundComponents - the  {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getCanEditFieldAttribute canEditFieldAttribute} may be set at the
     * component level to look for a different attribute on the dataSourceField, and components allow developers to explicitly
     * override this default (see {@link com.smartgwt.client.widgets.grid.ListGridField#getCanEdit canEdit}. {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit canEdit} for example). <P> Note that this setting only
     * prevents the user from  modifying the field's value through the UI; the value can still be modified  programmatically,
     * and it will still be saved in the normal way.  If you wish to prevent a field from being saved, use {@link
     * com.smartgwt.client.data.DataSourceField#getCanSave canSave}:false instead (or in addition).
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.data.DataSourceField#getCanFilter
     * @see com.smartgwt.client.data.DataSourceField#getCanSave
     * @see com.smartgwt.client.docs.ComponentBinding ComponentBinding overview and related methods
     */
    public Boolean getCanEdit()  {
        return getCanEditFromJSO(jsObj);
    }
    // Overridden to handle the fact we want to be able to see whether this is null
    private native Boolean getCanEditFromJSO(JavaScriptObject element) /*-{
        if (element.canEdit == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(element.canEdit);
    }-*/;
    
    /**
    * Returns the type of this field as a SimpleType. If the type is a built-in type like "float" or "boolean", the returned object will be null.
    * @return SimpleType
    */
    public native SimpleType getTypeAsSimpleType() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = $wnd.isc.SimpleType.getType(self.type);
        if(ret == null) return null;
        if (!$wnd.isc.isA.SimpleType(ret)) return null;
        return @com.smartgwt.client.data.SimpleType::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
    
    /**
    * Type of this field.  Required for all DataSource fields. <P> Field type may imply automatic validators (for example, an
    * integer field cannot accept the value "foo").  Field type also affects the default behaviors of DataBound components,
    * for example, if a field is declared as type "date", components that edit that field will automatically choose a
    * date-editing interface with pop-up date picker.
    * If the type of this field is a DataSource type, the returned object will be null. 
    * @return FieldType
    * @see com.smartgwt.client.docs.Basics Basics overview and related methods
    */
    public FieldType getType()  {
        if (getAttribute("type") == null) return null;
        FieldType fieldType = EnumUtil.getEnum(FieldType.values(), getAttribute("type"));
        if (fieldType == null) {
            if (DataSource.get(getAttribute("type")) != null) return null;
            SimpleType simpleType = SimpleType.getType(getAttributeAsString("type"));
            fieldType = EnumUtil.getEnum(FieldType.values(), simpleType.getInheritsFrom());
        }
        return fieldType;
    }

}
