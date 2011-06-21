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
 
package com.smartgwt.client.data;



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
 * Metadata about a DataSourceField, including its type and validators.
 */
public class DataSourceField extends DataClass {

    public static DataSourceField getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new DataSourceField(jsObj);
    }

    public DataSourceField(){
        
    }

    public DataSourceField(JavaScriptObject jsObj){
        super(jsObj);
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

    public DataSourceField(String name, FieldType type, String title, int length, boolean required) {
        setName(name);
		setType(type);
		setTitle(title);
		setLength(length);
		setRequired(required);
        
    }

    // ********************* Properties / Attributes ***********************

    /**
     * Whether this field can ever be edited by the user.  If set to <code>false</code>, no DataBound component will ever try
     * to offer an editing interface for this field.
     *
     * @param canEdit canEdit Default value is null
     * @see com.smartgwt.client.docs.ComponentBinding ComponentBinding overview and related methods
     */
    public void setCanEdit(Boolean canEdit) {
        setAttribute("canEdit", canEdit);
    }

    /**
     * Whether this field can ever be edited by the user.  If set to <code>false</code>, no DataBound component will ever try
     * to offer an editing interface for this field.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.ComponentBinding ComponentBinding overview and related methods
     */
    public Boolean getCanEdit()  {
        return getAttributeAsBoolean("canEdit");
    }

    /**
     * Dictates whether the data in this field be exported.  Explicitly setting  <i>canExport</i> to false overrides the
     * setting on any component-fields, such as {@link com.smartgwt.client.widgets.grid.ListGridField#getCanExport ListGrid
     * fields}.
     *
     * @param canExport canExport Default value is null
     */
    public void setCanExport(Boolean canExport) {
        setAttribute("canExport", canExport);
    }

    /**
     * Dictates whether the data in this field be exported.  Explicitly setting  <i>canExport</i> to false overrides the
     * setting on any component-fields, such as {@link com.smartgwt.client.widgets.grid.ListGridField#getCanExport ListGrid
     * fields}.
     *
     *
     * @return Boolean
     */
    public Boolean getCanExport()  {
        return getAttributeAsBoolean("canExport");
    }

    /**
     * Should the user be able to filter data by this field. Affects whether this field will show up in dataBoundComponents
     * with UI for filtering data.
     *
     * @param canFilter canFilter Default value is null
     */
    public void setCanFilter(Boolean canFilter) {
        setAttribute("canFilter", canFilter);
    }

    /**
     * Should the user be able to filter data by this field. Affects whether this field will show up in dataBoundComponents
     * with UI for filtering data.
     *
     *
     * @return Boolean
     */
    public Boolean getCanFilter()  {
        return getAttributeAsBoolean("canFilter");
    }

    /**
     * Whether values in this field can be updated and saved to the dataSource. <P> If set to <code>false</code>, this field
     * will default to being non-editable in standard editing components ({@link com.smartgwt.client.widgets.form.DynamicForm},
     * editable {@link com.smartgwt.client.widgets.grid.ListGrid}), but will be editable when displayed for filtering purposes
     * only (in a {@link com.smartgwt.client.widgets.form.SearchForm} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor ListGrid filter editor}. <P> Note: if {@link
     * com.smartgwt.client.data.DataSourceField#getCanEdit canEdit} is explicitly specified it will take precedence over this
     * behavior.
     *
     * @param canSave canSave Default value is null
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
     * com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor ListGrid filter editor}. <P> Note: if {@link
     * com.smartgwt.client.data.DataSourceField#getCanEdit canEdit} is explicitly specified it will take precedence over this
     * behavior.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.ComponentBinding ComponentBinding overview and related methods
     */
    public Boolean getCanSave()  {
        return getAttributeAsBoolean("canSave");
    }

    /**
     * When true, this field can only be used for sorting if the data is entirely client-side.
     *
     * @param canSortClientOnly canSortClientOnly Default value is false
     */
    public void setCanSortClientOnly(Boolean canSortClientOnly) {
        setAttribute("canSortClientOnly", canSortClientOnly);
    }

    /**
     * When true, this field can only be used for sorting if the data is entirely client-side.
     *
     *
     * @return Boolean
     */
    public Boolean getCanSortClientOnly()  {
        return getAttributeAsBoolean("canSortClientOnly");
    }

    /**
     * If true, this property indicates that this field will hold an explicit array of child nodes  for the current node. This
     * has the same effect as specifying {@link com.smartgwt.client.data.DataSource#getChildrenField childrenField} to this
     * field's  name.
     *
     * @param childrenProperty childrenProperty Default value is false
     * @see com.smartgwt.client.data.DataSource#setChildrenField
     * @see com.smartgwt.client.docs.DataSourceRelations DataSourceRelations overview and related methods
     * 
     */
    public void setChildrenProperty(Boolean childrenProperty) {
        setAttribute("childrenProperty", childrenProperty);
    }

    /**
     * If true, this property indicates that this field will hold an explicit array of child nodes  for the current node. This
     * has the same effect as specifying {@link com.smartgwt.client.data.DataSource#getChildrenField childrenField} to this
     * field's  name.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.data.DataSource#getChildrenField
     * @see com.smartgwt.client.docs.DataSourceRelations DataSourceRelations overview and related methods
     * 
     */
    public Boolean getChildrenProperty()  {
        return getAttributeAsBoolean("childrenProperty");
    }

    /**
     * For a field that is {@link com.smartgwt.client.data.DataSourceField#getMultiple multiple:"true"}, controls the name of
     * the XML tag used for each subelement during {@link com.smartgwt.client.data.DataSource#xmlSerialize
     * DataSource.xmlSerialize}. <P> If unset, the default tag name is "value" for a field of simple type, and for a field of
     * DataSource type, is the tagName or ID of the DataSource (as though <code>xmlSerialize()</code> were called on the child
     * DataSource).
     *
     * @param childTagName childTagName Default value is null
     * @see com.smartgwt.client.docs.ComponentSchema ComponentSchema overview and related methods
     */
    public void setChildTagName(String childTagName) {
        setAttribute("childTagName", childTagName);
    }

    /**
     * For a field that is {@link com.smartgwt.client.data.DataSourceField#getMultiple multiple:"true"}, controls the name of
     * the XML tag used for each subelement during {@link com.smartgwt.client.data.DataSource#xmlSerialize
     * DataSource.xmlSerialize}. <P> If unset, the default tag name is "value" for a field of simple type, and for a field of
     * DataSource type, is the tagName or ID of the DataSource (as though <code>xmlSerialize()</code> were called on the child
     * DataSource).
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.ComponentSchema ComponentSchema overview and related methods
     */
    public String getChildTagName()  {
        return getAttributeAsString("childTagName");
    }

    /**
     * For a DataSource with {@link com.smartgwt.client.docs.serverds.DataSource#serverType serverType} "sql" or "hibernate",
     * indicates that this field should be omitted by default from all SQL or Hibernate operations, and will only be used with
     * {@link com.smartgwt.client.docs.CustomQueries custom queries}. <P> Having marked a field as <code>customSQL</code> you
     * can refer to it via $criteria.<i>fieldName</i> or $values.<i>fieldName</i> in customized queries. <P> The following are
     * situations where you would <b>not</b> use <code>customSQL</code>: <ul> <li>simple joins where you want to enable users
     * to see and search on a field from another table; consider {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#tableName tableName} instead <li>fields where you want to calculate or
     * transform values in SQL on load or save, but always perform the same calculation for each operationType; consider
     * instead {@link com.smartgwt.client.docs.serverds.DataSourceField#sqlStorageStrategy sqlStorageStrategy} for some common
     * cases, or  {@link com.smartgwt.client.docs.serverds.DataSourceField#customSelectExpression customSelectExpression},
     * {@link com.smartgwt.client.docs.serverds.DataSourceField#customUpdateExpression customUpdateExpression} and {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#customInsertExpression customInsertExpression} for full customization
     * <li>a special fetch is needed where the field needs to be excluded from the $defaultWhereClause so that it can be used
     * in a custom &lt;whereClause&gt; - consider {@link
     * com.smartgwt.client.docs.serverds.OperationBinding#excludeCriteriaFields excludeCriteriaFields} instead </ul> <P> Use
     * customSQL in situations like: <ul> <li>there are multiple variations of the "fetch" operation with different {@link
     * com.smartgwt.client.data.OperationBinding#getOperationId operationIds}, and the field is only used in some of them; in
     * that case, consider using {@link com.smartgwt.client.docs.serverds.OperationBinding#customFields customFields} to
     * selectively re-introduce SQL generation for the field only in operations where it's used. <li>the field represents
     * hidden criteria on a field in another table where the field is never shown to the user <li>the field is a write-only
     * value only saved in some operations <li>more than one data access strategy is in use (eg direct SQL for fetch and
     * bean-based persistence accessed via DMI for saves) and certain fields are not available in SQL </ul>
     *
     * @param customSQL customSQL Default value is null
     */
    public void setCustomSQL(Boolean customSQL) {
        setAttribute("customSQL", customSQL);
    }

    /**
     * For a DataSource with {@link com.smartgwt.client.docs.serverds.DataSource#serverType serverType} "sql" or "hibernate",
     * indicates that this field should be omitted by default from all SQL or Hibernate operations, and will only be used with
     * {@link com.smartgwt.client.docs.CustomQueries custom queries}. <P> Having marked a field as <code>customSQL</code> you
     * can refer to it via $criteria.<i>fieldName</i> or $values.<i>fieldName</i> in customized queries. <P> The following are
     * situations where you would <b>not</b> use <code>customSQL</code>: <ul> <li>simple joins where you want to enable users
     * to see and search on a field from another table; consider {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#tableName tableName} instead <li>fields where you want to calculate or
     * transform values in SQL on load or save, but always perform the same calculation for each operationType; consider
     * instead {@link com.smartgwt.client.docs.serverds.DataSourceField#sqlStorageStrategy sqlStorageStrategy} for some common
     * cases, or  {@link com.smartgwt.client.docs.serverds.DataSourceField#customSelectExpression customSelectExpression},
     * {@link com.smartgwt.client.docs.serverds.DataSourceField#customUpdateExpression customUpdateExpression} and {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#customInsertExpression customInsertExpression} for full customization
     * <li>a special fetch is needed where the field needs to be excluded from the $defaultWhereClause so that it can be used
     * in a custom &lt;whereClause&gt; - consider {@link
     * com.smartgwt.client.docs.serverds.OperationBinding#excludeCriteriaFields excludeCriteriaFields} instead </ul> <P> Use
     * customSQL in situations like: <ul> <li>there are multiple variations of the "fetch" operation with different {@link
     * com.smartgwt.client.data.OperationBinding#getOperationId operationIds}, and the field is only used in some of them; in
     * that case, consider using {@link com.smartgwt.client.docs.serverds.OperationBinding#customFields customFields} to
     * selectively re-introduce SQL generation for the field only in operations where it's used. <li>the field represents
     * hidden criteria on a field in another table where the field is never shown to the user <li>the field is a write-only
     * value only saved in some operations <li>more than one data access strategy is in use (eg direct SQL for fetch and
     * bean-based persistence accessed via DMI for saves) and certain fields are not available in SQL </ul>
     *
     *
     * @return Boolean
     */
    public Boolean getCustomSQL()  {
        return getAttributeAsBoolean("customSQL");
    }

    /**
     * Preferred display format to use for date type values within this field. If this property is set on a field displayed in
     * a databound component such as a {@link com.smartgwt.client.widgets.form.DynamicForm} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid} it will be respected (See {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDateFormatter dateFormatter} and {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getDateForamtter dateForamtter}). <P> Note that this property is also
     * honored when exporting directly to  Excel spreadsheets (ie, when using XLS or XLSX/OOXML form, <b>not</b> CSV); "date"
     * and "datetime" fields with this property set will deliver real dates and formatting information to Excel, rather than
     * formatted strings or unformatted dates.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param dateFormatter dateFormatter Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setDateFormatter(DateDisplayFormat dateFormatter) {
        setAttribute("dateFormatter", dateFormatter.getValue());
    }

    /**
     * Preferred display format to use for date type values within this field. If this property is set on a field displayed in
     * a databound component such as a {@link com.smartgwt.client.widgets.form.DynamicForm} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid} it will be respected (See {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDateFormatter dateFormatter} and {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getDateForamtter dateForamtter}). <P> Note that this property is also
     * honored when exporting directly to  Excel spreadsheets (ie, when using XLS or XLSX/OOXML form, <b>not</b> CSV); "date"
     * and "datetime" fields with this property set will deliver real dates and formatting information to Excel, rather than
     * formatted strings or unformatted dates.
     *
     *
     * @return DateDisplayFormat
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public DateDisplayFormat getDateFormatter()  {
        return EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("dateFormatter"));
    }

    /**
     * Whether this field should be considered a "detail" field by a {@link com.smartgwt.client.widgets.DataBoundComponent}.
     * <P> Detail fields won't be shown by default in a DataBoundComponent where  {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getShowDetailFields showDetailFields} is false.  This allows for some
     * DataBound components, like a {@link com.smartgwt.client.widgets.grid.ListGrid}, to show a summary view of records which
     * displays only  the most commonly viewed fields by default, while other DataBoundComponents, like a {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer}, show all fields by default. <P> In addition, the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#showIf formItem.showIf} property is supported in multiple components
     * for conditional visibility - see for example {@link com.smartgwt.client.widgets.grid.ListGridField#showIf
     * ListGridField.showIf} and {@link com.smartgwt.client.widgets.form.fields.FormItem#showIf FormItem.showIf}).
     *
     * @param detail detail Default value is false
     * @see com.smartgwt.client.docs.ComponentBinding ComponentBinding overview and related methods
     */
    public void setDetail(Boolean detail) {
        setAttribute("detail", detail);
    }

    /**
     * Whether this field should be considered a "detail" field by a {@link com.smartgwt.client.widgets.DataBoundComponent}.
     * <P> Detail fields won't be shown by default in a DataBoundComponent where  {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getShowDetailFields showDetailFields} is false.  This allows for some
     * DataBound components, like a {@link com.smartgwt.client.widgets.grid.ListGrid}, to show a summary view of records which
     * displays only  the most commonly viewed fields by default, while other DataBoundComponents, like a {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer}, show all fields by default. <P> In addition, the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#showIf formItem.showIf} property is supported in multiple components
     * for conditional visibility - see for example {@link com.smartgwt.client.widgets.grid.ListGridField#showIf
     * ListGridField.showIf} and {@link com.smartgwt.client.widgets.form.fields.FormItem#showIf FormItem.showIf}).
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.ComponentBinding ComponentBinding overview and related methods
     */
    public Boolean getDetail()  {
        return getAttributeAsBoolean("detail");
    }

    /**
     * Sets the default FormItem to be used whenever this field is edited (whether in a grid, form, or other component). <P> If
     * unset, a FormItem will be automatically chosen based on the type of the field, by the rules explained {@link
     * com.smartgwt.client.types.FormItemType here}.
     *
     * @param editorType editorType Default value is null
     * @see com.smartgwt.client.docs.ComponentBinding ComponentBinding overview and related methods
     */
    public void setEditorType(String editorType) {
        setAttribute("editorType", editorType);
    }

    /**
     * Sets the default FormItem to be used whenever this field is edited (whether in a grid, form, or other component). <P> If
     * unset, a FormItem will be automatically chosen based on the type of the field, by the rules explained {@link
     * com.smartgwt.client.types.FormItemType here}.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.ComponentBinding ComponentBinding overview and related methods
     */
    public String getEditorType()  {
        return getAttributeAsString("editorType");
    }

    /**
     * When data values are displayed in DataBound components, by default strings will be interpreted as HTML by the browser in
     * most cases. <P> If set, this property will be picked up by components bound to this dataSource, notifying them that any
     * HTML characters should be escaped when displaying values for this field.
     *
     * @param escapeHTML escapeHTML Default value is null
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
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.grid.ListGridField#getEscapeHTML
     */
    public Boolean getEscapeHTML()  {
        return getAttributeAsBoolean("escapeHTML");
    }

    /**
     * Optional different field-title used for exports.
     *
     * @param exportTitle exportTitle Default value is null
     */
    public void setExportTitle(String exportTitle) {
        setAttribute("exportTitle", exportTitle);
    }

    /**
     * Optional different field-title used for exports.
     *
     *
     * @return String
     */
    public String getExportTitle()  {
        return getAttributeAsString("exportTitle");
    }

    /**
     * Declares that this field holds values that can be matched to values from another DataSource&#010 field, to create a
     * relationship between records from different DataSources or even records&#010 within the same DataSource.&#010 <p>&#010
     * The format of <code>foreignKey</code> is&#010 <code>&lt;dataSourceId&gt;.&lt;fieldName&gt;</code>.<br>&#010 For a
     * foreignKey within the same dataSource, you can omit the <code>dataSourceId</code>&#010 and just specify
     * <code>&lt;fieldName&gt;</code>.<br>&#010 For example, to create a tree relationship within a DataSource:&#010 <pre>&#010
     * DataSource.create({&#010     ID:"supplyItem",&#010     fields : [&#010       {name:"itemId", type:"sequence",
     * primaryKey:true},&#010       {name:"parentId", type:"integer", foreignKey:"itemId"},&#010       ...&#010     ]&#010  
     * });&#010 </pre>&#010 <P>&#010 <code>foreignKey</code> declarations also allow other automatic behaviors by&#010 {@link
     * com.smartgwt.client.widgets.DataBoundComponent DataBoundComponents}, such as {@link
     * com.smartgwt.client.widgets.grid.ListGrid#fetchRelatedData ListGrid.fetchRelatedData}.
     *
     * @param foreignKey foreignKey Default value is false
     * @see com.smartgwt.client.docs.DataSourceRelations DataSourceRelations overview and related methods
     */
    public void setForeignKey(String foreignKey) {
        setAttribute("foreignKey", foreignKey);
    }

    /**
     * Declares that this field holds values that can be matched to values from another DataSource&#010 field, to create a
     * relationship between records from different DataSources or even records&#010 within the same DataSource.&#010 <p>&#010
     * The format of <code>foreignKey</code> is&#010 <code>&lt;dataSourceId&gt;.&lt;fieldName&gt;</code>.<br>&#010 For a
     * foreignKey within the same dataSource, you can omit the <code>dataSourceId</code>&#010 and just specify
     * <code>&lt;fieldName&gt;</code>.<br>&#010 For example, to create a tree relationship within a DataSource:&#010 <pre>&#010
     * DataSource.create({&#010     ID:"supplyItem",&#010     fields : [&#010       {name:"itemId", type:"sequence",
     * primaryKey:true},&#010       {name:"parentId", type:"integer", foreignKey:"itemId"},&#010       ...&#010     ]&#010  
     * });&#010 </pre>&#010 <P>&#010 <code>foreignKey</code> declarations also allow other automatic behaviors by&#010 {@link
     * com.smartgwt.client.widgets.DataBoundComponent DataBoundComponents}, such as {@link
     * com.smartgwt.client.widgets.grid.ListGrid#fetchRelatedData ListGrid.fetchRelatedData}.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.DataSourceRelations DataSourceRelations overview and related methods
     */
    public String getForeignKey()  {
        return getAttributeAsString("foreignKey");
    }

    /**
     * For use in {@link com.smartgwt.client.docs.ComponentSchema}, indicates what group to place the property in when editing
     * in Visual Builder.
     *
     * @param group group Default value is null
     * @see com.smartgwt.client.docs.ComponentSchema ComponentSchema overview and related methods
     */
    public void setGroup(String group) {
        setAttribute("group", group);
    }

    /**
     * For use in {@link com.smartgwt.client.docs.ComponentSchema}, indicates what group to place the property in when editing
     * in Visual Builder.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.ComponentSchema ComponentSchema overview and related methods
     */
    public String getGroup()  {
        return getAttributeAsString("group");
    }

    /**
     * Whether this field should be hidden from users by default within a DataBound component. This is generally used for
     * internal IDs and other fields not meaningful to users. <P> See {@link com.smartgwt.client.data.DataSourceField#getDetail
     * detail} for fields that should be hidden in a summary view such as a {@link com.smartgwt.client.widgets.grid.ListGrid},
     * but still available to the user.
     *
     * @param hidden hidden Default value is false
     * @see com.smartgwt.client.docs.ComponentBinding ComponentBinding overview and related methods
     */
    public void setHidden(Boolean hidden) {
        setAttribute("hidden", hidden);
    }

    /**
     * Whether this field should be hidden from users by default within a DataBound component. This is generally used for
     * internal IDs and other fields not meaningful to users. <P> See {@link com.smartgwt.client.data.DataSourceField#getDetail
     * detail} for fields that should be hidden in a summary view such as a {@link com.smartgwt.client.widgets.grid.ListGrid},
     * but still available to the user.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.ComponentBinding ComponentBinding overview and related methods
     */
    public Boolean getHidden()  {
        return getAttributeAsBoolean("hidden");
    }

    /**
     * Whether this field should be completely excluded from this dataSource, as if it had never been defined.
     *
     * @param ignore ignore Default value is false
     * @see com.smartgwt.client.docs.ComponentBinding ComponentBinding overview and related methods
     */
    public void setIgnore(Boolean ignore) {
        setAttribute("ignore", ignore);
    }

    /**
     * Whether this field should be completely excluded from this dataSource, as if it had never been defined.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.ComponentBinding ComponentBinding overview and related methods
     */
    public Boolean getIgnore()  {
        return getAttributeAsBoolean("ignore");
    }

    /**
     * For use in {@link com.smartgwt.client.docs.ComponentSchema}, a field {@link
     * com.smartgwt.client.data.DataSource#getInheritsFrom inherited} from another schema can be redeclared with this property
     * set in order to indicate that the property should not be used. <P> This is primarily used to influence {@link
     * com.smartgwt.client.docs.VisualBuilder}.  For simple type properties, this avoids the property appearing in the
     * Component Editor.   <P> For fields that hold subcomponents, this prevents inappropriate drag and drop.  For example, a
     * custom class called <code>MyDialog</code> may automatically create a series of children, and not allow arbitrary other
     * children to be added.  In this case, the inherited property {@link com.smartgwt.client.widgets.Canvas#getChildren
     * children} should be marked inapplicable in order to prevent arbitrary components being dropped onto a
     * <code>MyDialog</code> instance.
     *
     * @param inapplicable inapplicable Default value is null
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
     * children} should be marked inapplicable in order to prevent arbitrary components being dropped onto a
     * <code>MyDialog</code> instance.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.ComponentSchema ComponentSchema overview and related methods
     */
    public Boolean getInapplicable()  {
        return getAttributeAsBoolean("inapplicable");
    }

    /**
     * For use with the Smart GWT server when populating Java Beans / POJOs based on data contained in a DSRequest,
     * <code>javaClass</code> specifies the fully qualified Java className to be created and passed to the setter for the Java
     * Bean Property with the same name as this field.   <code>javaClass</code> is used both when manually calling
     * DataSource.setProperties() and when auto-populating POJO arguments of a {@link
     * com.smartgwt.client.data.DataSourceField#getDmiOverview DMI} method. <P> The Java class to create does not normally have
     * to be specified: Smart GWT will use Java reflection to inspect the type of argument expected by a setter method and will
     * attempt conversion of inbound data to that type.  As described in the documentation for DataTools.setProperties(), this
     * works for almost all typical cases.  However <code>field.javaClass</code> is useful for: <ul> <li> subobject of abstract
     * or interface type: in this case Java Reflection is not sufficient to discover the concrete type that should be
     * instantiated, and <code>javaClass</code> should be set instead.</li> <li> subobject of Collection or Map type, when Java
     * generics are not used or the Collection member type or Map value type is abstract.  When Java generics are used (for
     * example the setter takes an argument is of type Collection&lt;SomePOJO&gt; or Map&lt;KeyType,SomePOJO&gt;, Smart GWT
     * will automatically attempt to convert inbound data to the type of the members of the Collection or values of the Map. 
     * Without generics, <code>javaClass</code> needs to be specified.  Note that <code>javaClass</code> will take precedence
     * over generics if both  are used. Also note that {@link com.smartgwt.client.data.DataSourceField#getJavaCollectionClass
     * javaCollectionClass} can be specified if a particular Collection or Map type is needed, and {@link
     * com.smartgwt.client.data.DataSourceField#getJavaKeyClass javaKeyClass} can be specified for a field of type
     * <code>java.util.Map</code>.</li> </ul>
     *
     * @param javaClass javaClass Default value is null
     */
    public void setJavaClass(String javaClass) {
        setAttribute("javaClass", javaClass);
    }

    /**
     * For use with the Smart GWT server when populating Java Beans / POJOs based on data contained in a DSRequest,
     * <code>javaClass</code> specifies the fully qualified Java className to be created and passed to the setter for the Java
     * Bean Property with the same name as this field.   <code>javaClass</code> is used both when manually calling
     * DataSource.setProperties() and when auto-populating POJO arguments of a {@link
     * com.smartgwt.client.data.DataSourceField#getDmiOverview DMI} method. <P> The Java class to create does not normally have
     * to be specified: Smart GWT will use Java reflection to inspect the type of argument expected by a setter method and will
     * attempt conversion of inbound data to that type.  As described in the documentation for DataTools.setProperties(), this
     * works for almost all typical cases.  However <code>field.javaClass</code> is useful for: <ul> <li> subobject of abstract
     * or interface type: in this case Java Reflection is not sufficient to discover the concrete type that should be
     * instantiated, and <code>javaClass</code> should be set instead.</li> <li> subobject of Collection or Map type, when Java
     * generics are not used or the Collection member type or Map value type is abstract.  When Java generics are used (for
     * example the setter takes an argument is of type Collection&lt;SomePOJO&gt; or Map&lt;KeyType,SomePOJO&gt;, Smart GWT
     * will automatically attempt to convert inbound data to the type of the members of the Collection or values of the Map. 
     * Without generics, <code>javaClass</code> needs to be specified.  Note that <code>javaClass</code> will take precedence
     * over generics if both  are used. Also note that {@link com.smartgwt.client.data.DataSourceField#getJavaCollectionClass
     * javaCollectionClass} can be specified if a particular Collection or Map type is needed, and {@link
     * com.smartgwt.client.data.DataSourceField#getJavaKeyClass javaKeyClass} can be specified for a field of type
     * <code>java.util.Map</code>.</li> </ul>
     *
     *
     * @return String
     */
    public String getJavaClass()  {
        return getAttributeAsString("javaClass");
    }

    /**
     * See {@link com.smartgwt.client.data.DataSourceField#getJavaClass javaClass} - when auto-populating of Java Beans / POJOs
     * based on  inbound DSRequest data, for a field of type Collection or Map,  <code>javaCollectionClass</code> can  be used
     * to specify a particular concrete class to use.  If not specified, and a concrete Collection or Map class cannot be
     * discovered using Java Reflection, the following concrete classes are used: <ul> <li> <code>java.util.ArrayList</code> is
     * used for fields of type <code>List</code> <li> <code>java.util.HashSet</code> is used for fields of type
     * <code>Set</code> <li> <code>java.util.LinkedList</code> is used for fields of type <code>Queue</code> <li>
     * <code>org.apache.commons.collections.map.LinkedMap</code> is used for fields of type <code>Map</code> <li>
     * <code>java.util.ArrayList</code> is used for fields that are otherwise of type <code>Collection</code> </ul> Note that
     * this value is used even if the target Collection or Map is declared as a concrete class.  So, for example, if you set
     * <code>javaCollectionClass</code> to  <code>java.util.LinkedList</code> but your setter method accepts a 
     * <code>java.util.ArrayList</code>, you will get a ClassCastException.
     *
     * @param javaCollectionClass javaCollectionClass Default value is null
     */
    public void setJavaCollectionClass(String javaCollectionClass) {
        setAttribute("javaCollectionClass", javaCollectionClass);
    }

    /**
     * See {@link com.smartgwt.client.data.DataSourceField#getJavaClass javaClass} - when auto-populating of Java Beans / POJOs
     * based on  inbound DSRequest data, for a field of type Collection or Map,  <code>javaCollectionClass</code> can  be used
     * to specify a particular concrete class to use.  If not specified, and a concrete Collection or Map class cannot be
     * discovered using Java Reflection, the following concrete classes are used: <ul> <li> <code>java.util.ArrayList</code> is
     * used for fields of type <code>List</code> <li> <code>java.util.HashSet</code> is used for fields of type
     * <code>Set</code> <li> <code>java.util.LinkedList</code> is used for fields of type <code>Queue</code> <li>
     * <code>org.apache.commons.collections.map.LinkedMap</code> is used for fields of type <code>Map</code> <li>
     * <code>java.util.ArrayList</code> is used for fields that are otherwise of type <code>Collection</code> </ul> Note that
     * this value is used even if the target Collection or Map is declared as a concrete class.  So, for example, if you set
     * <code>javaCollectionClass</code> to  <code>java.util.LinkedList</code> but your setter method accepts a 
     * <code>java.util.ArrayList</code>, you will get a ClassCastException.
     *
     *
     * @return String
     */
    public String getJavaCollectionClass()  {
        return getAttributeAsString("javaCollectionClass");
    }

    /**
     * See {@link com.smartgwt.client.data.DataSourceField#getJavaClass javaClass} - when auto-populating of Java Beans / POJOs
     * based on  inbound DSRequest data, for a field of Map type, <code>javaKeyClass</code> can be used to specify a particular
     * concrete class for the map keys.  If not specified, and a concrete type cannot be discovered using Java Reflection,
     * <code>java.lang.Object</code> is used. Note that <code>javaKeyClass</code> take precedence over generics if both are
     * used.
     *
     * @param javaKeyClass javaKeyClass Default value is null
     */
    public void setJavaKeyClass(String javaKeyClass) {
        setAttribute("javaKeyClass", javaKeyClass);
    }

    /**
     * See {@link com.smartgwt.client.data.DataSourceField#getJavaClass javaClass} - when auto-populating of Java Beans / POJOs
     * based on  inbound DSRequest data, for a field of Map type, <code>javaKeyClass</code> can be used to specify a particular
     * concrete class for the map keys.  If not specified, and a concrete type cannot be discovered using Java Reflection,
     * <code>java.lang.Object</code> is used. Note that <code>javaKeyClass</code> take precedence over generics if both are
     * used.
     *
     *
     * @return String
     */
    public String getJavaKeyClass()  {
        return getAttributeAsString("javaKeyClass");
    }

    /**
     * Maximum number of characters allowed.  Applicable only to fields of text type. <P> <b>NOTE:</b> For DataSources of type
     * "sql", this property has a bearing on the type of  column we use when the underlying table is created by a DataSource 
     * {@link com.smartgwt.client.docs.SqlDataSource import} in the {@link com.smartgwt.client.docs.AdminConsole Admin
     * Console}.  Below  a certain length (which is database-specific, see below), we use standard <code>VARCHAR</code>
     * columns; above that length, we use an alternate strategy (again, database-specific).  For  these long fields, we
     * sometimes also generate different SQL for "update" and "add"  operations, using JDBC "?" replacement parameters rather
     * than embedding values directly in  the generated SQL; whether or not this is done depends entirely on what the
     * underlying  database product and/or JDBC driver will allow. <P><br> <b>Table of field length limits for supported
     * databases:</b><p> <table style="font-size:10px;text-align:center;border:1px solid black;"> <tr><td
     * style="color:white;background-color:black;"><b>Database product</b></td>     <td
     * style="color:white;background-color:black;"><b>VARCHAR limit *</b></td>     <td
     * style="color:white;background-color:black;"><b>Type used above limit</b></td></tr>
     * <tr><td>HSQLDB</td><td>None</td><td>-</td></tr> <tr><td>IBM DB2</td><td>4000</td><td>CLOB</td></tr> <tr><td> Microsoft
     * SQL Server </td><td>8000</td><td>TEXT</td></tr> <tr><td>MySQL</td><td> 255 / 65535 / 16M </td><td> TEXT / MEDIUMTEXT /
     * LONGTEXT ** </td></tr> <tr><td>Oracle</td><td>4000</td><td>CLOB</td></tr>
     * <tr><td>PostgreSQL</td><td>4000</td><td>TEXT</td></tr> </table><br> <b>*</b> The "VARCHAR limit" referred to here is a
     * limit used by the Smart GWT Server; it is not necessarily imposed by the database.  For example, DB2's VARCHAR limit is
     * not 4000 characters; it actually varies from about 4K to about 32K, depending on how the server has  been configured.<p>
     * <b>**</b> MySQL has a limit of 255 characters for VARCHAR, 65,535 characters for TEXT and  16,777,215 for MEDIUMTEXT;
     * therefore, with that one product, we have three thresholds for a  change in storage type.
     *
     * @param length length Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_datatypes_longtext" target="examples">Long Text Example</a>
     */
    public void setLength(Integer length) {
        setAttribute("length", length);
    }

    /**
     * Maximum number of characters allowed.  Applicable only to fields of text type. <P> <b>NOTE:</b> For DataSources of type
     * "sql", this property has a bearing on the type of  column we use when the underlying table is created by a DataSource 
     * {@link com.smartgwt.client.docs.SqlDataSource import} in the {@link com.smartgwt.client.docs.AdminConsole Admin
     * Console}.  Below  a certain length (which is database-specific, see below), we use standard <code>VARCHAR</code>
     * columns; above that length, we use an alternate strategy (again, database-specific).  For  these long fields, we
     * sometimes also generate different SQL for "update" and "add"  operations, using JDBC "?" replacement parameters rather
     * than embedding values directly in  the generated SQL; whether or not this is done depends entirely on what the
     * underlying  database product and/or JDBC driver will allow. <P><br> <b>Table of field length limits for supported
     * databases:</b><p> <table style="font-size:10px;text-align:center;border:1px solid black;"> <tr><td
     * style="color:white;background-color:black;"><b>Database product</b></td>     <td
     * style="color:white;background-color:black;"><b>VARCHAR limit *</b></td>     <td
     * style="color:white;background-color:black;"><b>Type used above limit</b></td></tr>
     * <tr><td>HSQLDB</td><td>None</td><td>-</td></tr> <tr><td>IBM DB2</td><td>4000</td><td>CLOB</td></tr> <tr><td> Microsoft
     * SQL Server </td><td>8000</td><td>TEXT</td></tr> <tr><td>MySQL</td><td> 255 / 65535 / 16M </td><td> TEXT / MEDIUMTEXT /
     * LONGTEXT ** </td></tr> <tr><td>Oracle</td><td>4000</td><td>CLOB</td></tr>
     * <tr><td>PostgreSQL</td><td>4000</td><td>TEXT</td></tr> </table><br> <b>*</b> The "VARCHAR limit" referred to here is a
     * limit used by the Smart GWT Server; it is not necessarily imposed by the database.  For example, DB2's VARCHAR limit is
     * not 4000 characters; it actually varies from about 4K to about 32K, depending on how the server has  been configured.<p>
     * <b>**</b> MySQL has a limit of 255 characters for VARCHAR, 65,535 characters for TEXT and  16,777,215 for MEDIUMTEXT;
     * therefore, with that one product, we have three thresholds for a  change in storage type.
     *
     *
     * @return Integer
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_datatypes_longtext" target="examples">Long Text Example</a>
     */
    public Integer getLength()  {
        return getAttributeAsInt("length");
    }

    /**
     * Indicates that this field should always be Array-valued.  If the value derived from&#010 {@link
     * com.smartgwt.client.data.DataSource#getDataFormat XML or JSON data} is singular, it will be wrapped in an Array.&#010
     * <P>&#010 Specifically for XML serialization and deserialization, <code>multiple:true</code> behaves&#010 similarly to
     * the &#010 <a href='http://www.google.com/search?hl=en&q=soap+array'
     * onclick="window.open('http://www.google.com/search?hl=en&q=soap+array');return false;">SOAP array idiom</a>, that
     * is,&#010 there will be a "wrapper element" named after the field name, whose contents will be several&#010 elements of
     * the specified {@link com.smartgwt.client.data.DataSourceField#getType field.type}.  &#010 <P>&#010 For example, {@link
     * com.smartgwt.client.widgets.layout.Layout#getMembers members} is declared with <code>type:"Canvas",&#010
     * multiple:true</code>.  The correct XML format is thus:&#010 <pre>&#010 &lt;VLayout&gt;&#010     &lt;members&gt;&#010    
     * &lt;Canvas ID="myCanvas" ... /&gt;&#010         &lt;ListGrid ID="myGrid" .../&gt;&#010         &lt;Toolstrip
     * ID="myToolStrip" ... /&gt;&#010     &lt;/members&gt;&#010 &lt;/VLayout&gt;&#010 </pre>&#010 <P>&#010 See {@link
     * com.smartgwt.client.data.DataSourceField#getChildTagName childTagName} for customizing the tagName used for subelements.
     *
     * @param multiple multiple Default value is null
     * @see com.smartgwt.client.docs.ComponentSchema ComponentSchema overview and related methods
     */
    public void setMultiple(Boolean multiple) {
        setAttribute("multiple", multiple);
    }

    /**
     * Indicates that this field should always be Array-valued.  If the value derived from&#010 {@link
     * com.smartgwt.client.data.DataSource#getDataFormat XML or JSON data} is singular, it will be wrapped in an Array.&#010
     * <P>&#010 Specifically for XML serialization and deserialization, <code>multiple:true</code> behaves&#010 similarly to
     * the &#010 <a href='http://www.google.com/search?hl=en&q=soap+array'
     * onclick="window.open('http://www.google.com/search?hl=en&q=soap+array');return false;">SOAP array idiom</a>, that
     * is,&#010 there will be a "wrapper element" named after the field name, whose contents will be several&#010 elements of
     * the specified {@link com.smartgwt.client.data.DataSourceField#getType field.type}.  &#010 <P>&#010 For example, {@link
     * com.smartgwt.client.widgets.layout.Layout#getMembers members} is declared with <code>type:"Canvas",&#010
     * multiple:true</code>.  The correct XML format is thus:&#010 <pre>&#010 &lt;VLayout&gt;&#010     &lt;members&gt;&#010    
     * &lt;Canvas ID="myCanvas" ... /&gt;&#010         &lt;ListGrid ID="myGrid" .../&gt;&#010         &lt;Toolstrip
     * ID="myToolStrip" ... /&gt;&#010     &lt;/members&gt;&#010 &lt;/VLayout&gt;&#010 </pre>&#010 <P>&#010 See {@link
     * com.smartgwt.client.data.DataSourceField#getChildTagName childTagName} for customizing the tagName used for subelements.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.ComponentSchema ComponentSchema overview and related methods
     */
    public Boolean getMultiple()  {
        return getAttributeAsBoolean("multiple");
    }

    /**
     * Name for this field.   <p> The field name is also the property in each DataSource record which holds the value for this
     * field. <P> Must be unique across all fields within the DataSource.
     *
     * @param name name Default value is null
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public void setName(String name) {
        setAttribute("name", name);
    }

    /**
     * Name for this field.   <p> The field name is also the property in each DataSource record which holds the value for this
     * field. <P> Must be unique across all fields within the DataSource.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public String getName()  {
        return getAttributeAsString("name");
    }

    /**
     * Whether this field holds a value unique across all records in this DataSource.&#010 <p>&#010 A DataSource that can
     * <i>only</i> perform the "fetch" operation does not require a&#010 primaryKey.  If a DataSource allows modification of
     * DataSource records through add, update&#010 and remove DataSource operations, exactly one field must be marked as the
     * primary key.&#010 <P>&#010 Smart GWT requires a primary key value to uniquely identify records when communicating&#010
     * updates or deletions to the server.  There is no requirement that the primaryKey field be&#010 mapped to an actual
     * "primary key" in your object model, web service, or database.  The only&#010 requirement is that values of the
     * primaryKey field be unique for a given browser instance&#010 for the lifetime of the page.  &#010 <P>&#010 If your
     * underlying data model has no primaryKey or has multiple primaryKey(s), you can&#010 generate unique values or combine
     * multiple values into a single field that serves as a&#010 unique key, and declare that field as the single primary key
     * instead.  For example, if your&#010 underlying data model has two primary keys "firstName" and "lastName", you can
     * use&#010 {@link com.smartgwt.client.data.DataSource#transformResponse DataSource.transformResponse} to combine them to
     * into a new field "name_key":&#010 <pre>&#010 isc.DataSource.create({&#010    fields:[&#010        {name:"name_key",
     * primaryKey:true},&#010        {name:"firstName"},&#010        {name:"lastName"},&#010        ... other fields ...&#010  
     * ],&#010    transformResponse : function (dsResponse) {&#010        var data = dsResponse.data;&#010        for (var i =
     * 0 ; i &lt; data.length; i++) {&#010            data[i].name_key = data[i].firstName + ":" +&#010                        
     * data[i].lastName;&#010        }&#010    }&#010 });&#010 </pre>&#010 <P>&#010 Here it is assumed that ":" is not a legal
     * character in either the firstName or lastName&#010 field.  Updates to records from this DataSource will then be sent
     * with name_key as the&#010 primary key value, and the server can split the value to obtain the separate key values.&#010
     * <P>&#010 If using ISC's {@link com.smartgwt.client.docs.SqlDataSource SQL engine} and generating SQL tables using
     * the&#010 "Databases" tab of the Developer Console, the table column generated from a primaryKey field&#010 will have a
     * unique constraint applied in the database table.
     *
     * @param primaryKey primaryKey Default value is false
     * @see com.smartgwt.client.docs.DataSourceRelations DataSourceRelations overview and related methods
     */
    public void setPrimaryKey(Boolean primaryKey) {
        setAttribute("primaryKey", primaryKey);
    }

    /**
     * Whether this field holds a value unique across all records in this DataSource.&#010 <p>&#010 A DataSource that can
     * <i>only</i> perform the "fetch" operation does not require a&#010 primaryKey.  If a DataSource allows modification of
     * DataSource records through add, update&#010 and remove DataSource operations, exactly one field must be marked as the
     * primary key.&#010 <P>&#010 Smart GWT requires a primary key value to uniquely identify records when communicating&#010
     * updates or deletions to the server.  There is no requirement that the primaryKey field be&#010 mapped to an actual
     * "primary key" in your object model, web service, or database.  The only&#010 requirement is that values of the
     * primaryKey field be unique for a given browser instance&#010 for the lifetime of the page.  &#010 <P>&#010 If your
     * underlying data model has no primaryKey or has multiple primaryKey(s), you can&#010 generate unique values or combine
     * multiple values into a single field that serves as a&#010 unique key, and declare that field as the single primary key
     * instead.  For example, if your&#010 underlying data model has two primary keys "firstName" and "lastName", you can
     * use&#010 {@link com.smartgwt.client.data.DataSource#transformResponse DataSource.transformResponse} to combine them to
     * into a new field "name_key":&#010 <pre>&#010 isc.DataSource.create({&#010    fields:[&#010        {name:"name_key",
     * primaryKey:true},&#010        {name:"firstName"},&#010        {name:"lastName"},&#010        ... other fields ...&#010  
     * ],&#010    transformResponse : function (dsResponse) {&#010        var data = dsResponse.data;&#010        for (var i =
     * 0 ; i &lt; data.length; i++) {&#010            data[i].name_key = data[i].firstName + ":" +&#010                        
     * data[i].lastName;&#010        }&#010    }&#010 });&#010 </pre>&#010 <P>&#010 Here it is assumed that ":" is not a legal
     * character in either the firstName or lastName&#010 field.  Updates to records from this DataSource will then be sent
     * with name_key as the&#010 primary key value, and the server can split the value to obtain the separate key values.&#010
     * <P>&#010 If using ISC's {@link com.smartgwt.client.docs.SqlDataSource SQL engine} and generating SQL tables using
     * the&#010 "Databases" tab of the Developer Console, the table column generated from a primaryKey field&#010 will have a
     * unique constraint applied in the database table.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.DataSourceRelations DataSourceRelations overview and related methods
     */
    public Boolean getPrimaryKey()  {
        return getAttributeAsBoolean("primaryKey");
    }

    /**
     * For use in {@link com.smartgwt.client.docs.ComponentSchema} for fields that contain other components, this flag&#010
     * suppresses auto-construction for subcomponents that appear under this field.&#010 <P>&#010 For example, the {@link
     * com.smartgwt.client.widgets.layout.VLayout} schema sets this for its {@link
     * com.smartgwt.client.widgets.layout.Layout#getMembers members}&#010 property, so that when a VLayout is constructed via
     * XML as follows:&#010 <pre>&#010 &lt;VLayout&gt;&#010     &lt;members&gt;&#010         &lt;ListGrid ID="myGrid"
     * .../&gt;&#010         &lt;Toolstrip ID="myToolStrip" ... /&gt;&#010     &lt;/members&gt;&#010 &lt;/VLayout&gt;&#010
     * </pre>&#010 The ListGrid and ToolStrip do not construct themselves automatically.  Instead, the VLayout&#010 receives
     * the properties of the ListGrid and ToolStrip as ordinary JavaScript Objects, with&#010 the special property
     * <code>_constructor</code> set to the name of the class that should be&#010 constructed.
     *
     * @param propertiesOnly propertiesOnly Default value is null
     * @see com.smartgwt.client.docs.ComponentSchema ComponentSchema overview and related methods
     */
    public void setPropertiesOnly(Boolean propertiesOnly) {
        setAttribute("propertiesOnly", propertiesOnly);
    }

    /**
     * For use in {@link com.smartgwt.client.docs.ComponentSchema} for fields that contain other components, this flag&#010
     * suppresses auto-construction for subcomponents that appear under this field.&#010 <P>&#010 For example, the {@link
     * com.smartgwt.client.widgets.layout.VLayout} schema sets this for its {@link
     * com.smartgwt.client.widgets.layout.Layout#getMembers members}&#010 property, so that when a VLayout is constructed via
     * XML as follows:&#010 <pre>&#010 &lt;VLayout&gt;&#010     &lt;members&gt;&#010         &lt;ListGrid ID="myGrid"
     * .../&gt;&#010         &lt;Toolstrip ID="myToolStrip" ... /&gt;&#010     &lt;/members&gt;&#010 &lt;/VLayout&gt;&#010
     * </pre>&#010 The ListGrid and ToolStrip do not construct themselves automatically.  Instead, the VLayout&#010 receives
     * the properties of the ListGrid and ToolStrip as ordinary JavaScript Objects, with&#010 the special property
     * <code>_constructor</code> set to the name of the class that should be&#010 constructed.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.ComponentSchema ComponentSchema overview and related methods
     */
    public Boolean getPropertiesOnly()  {
        return getAttributeAsBoolean("propertiesOnly");
    }

    /**
     * Indicates this field must be non-null in order for a record to pass validation. <P> Note that <code>required</code>
     * should not be set for a server-generated field, such as a sequence, or validation will fail on the client.
     *
     * @param required required Default value is null
     */
    public void setRequired(Boolean required) {
        setAttribute("required", required);
    }

    /**
     * Indicates this field must be non-null in order for a record to pass validation. <P> Note that <code>required</code>
     * should not be set for a server-generated field, such as a sequence, or validation will fail on the client.
     *
     *
     * @return Boolean
     */
    public Boolean getRequired()  {
        return getAttributeAsBoolean("required");
    }

    /**
     * For a field that is a foreignKey establishing a tree relationship, what value indicates a root-level node.  Defaults to
     * null. <P> Note that the rootValue may be overridden on a specific ResultTree instance by setting  rootNode, or if the
     * ResultTree is auto-generated by a {@link com.smartgwt.client.widgets.tree.TreeGrid}, by setting {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getTreeRootValue treeRootValue}. This allows a component to navigate a subtree
     * of the hierarchical data from this dataSource starting at a particular node.
     *
     * @param rootValue rootValue Default value is null
     * @see com.smartgwt.client.docs.DataSourceRelations DataSourceRelations overview and related methods
     * 
     */
    public void setRootValue(Object rootValue) {
        setAttribute("rootValue", rootValue);
    }

    /**
     * For a field that is a foreignKey establishing a tree relationship, what value indicates a root-level node.  Defaults to
     * null. <P> Note that the rootValue may be overridden on a specific ResultTree instance by setting  rootNode, or if the
     * ResultTree is auto-generated by a {@link com.smartgwt.client.widgets.tree.TreeGrid}, by setting {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getTreeRootValue treeRootValue}. This allows a component to navigate a subtree
     * of the hierarchical data from this dataSource starting at a particular node.
     *
     *
     * @return Object
     * @see com.smartgwt.client.docs.DataSourceRelations DataSourceRelations overview and related methods
     * 
     */
    public Object getRootValue()  {
        return getAttributeAsObject("rootValue");
    }

    /**
     * For a DataSource with {@link com.smartgwt.client.docs.serverds.DataSource#serverType serverType:"sql"} with a field of
     * type "sequence", the name of the SQL sequence that should be used when inserting new records into this table. <P> Note
     * that this is never required for SQL tables that are generated from Smart GWT DataSources (a default sequence name of
     * tableName + "_" + columnName is chosen), and is  never required for databases where inserting null into a sequence
     * column is sufficient (MySQL, SQL Server, DB2 and others).   <P> You would only need to set sequenceName if you are
     * integrating with a pre-existing table stored in a database where the sequence must be named for insertion to work
     * (Oracle, Postgres) OR you are trying to use the same sequence across multiple DataSources.
     *
     * @param sequenceName sequenceName Default value is null
     * @see com.smartgwt.client.docs.SqlDataSource SqlDataSource overview and related methods
     */
    public void setSequenceName(String sequenceName) {
        setAttribute("sequenceName", sequenceName);
    }

    /**
     * For a DataSource with {@link com.smartgwt.client.docs.serverds.DataSource#serverType serverType:"sql"} with a field of
     * type "sequence", the name of the SQL sequence that should be used when inserting new records into this table. <P> Note
     * that this is never required for SQL tables that are generated from Smart GWT DataSources (a default sequence name of
     * tableName + "_" + columnName is chosen), and is  never required for databases where inserting null into a sequence
     * column is sufficient (MySQL, SQL Server, DB2 and others).   <P> You would only need to set sequenceName if you are
     * integrating with a pre-existing table stored in a database where the sequence must be named for insertion to work
     * (Oracle, Postgres) OR you are trying to use the same sequence across multiple DataSources.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.SqlDataSource SqlDataSource overview and related methods
     */
    public String getSequenceName()  {
        return getAttributeAsString("sequenceName");
    }

    /**
     * For a field of type:"imageFile", indicates whether to stream the image and display it inline or to display the View and
     * Download icons.
     *
     * @param showFileInline showFileInline Default value is null
     */
    public void setShowFileInline(Boolean showFileInline) {
        setAttribute("showFileInline", showFileInline);
    }

    /**
     * For a field of type:"imageFile", indicates whether to stream the image and display it inline or to display the View and
     * Download icons.
     *
     *
     * @return Boolean
     */
    public Boolean getShowFileInline()  {
        return getAttributeAsBoolean("showFileInline");
    }

    /**
     * Title to show in a  Summary of type "title" for this field. If unspecified <code>title</code> summaries will show the
     * {@link com.smartgwt.client.data.DataSourceField#getTitle title} for the field.
     *
     * @param summaryValueTitle summaryValueTitle Default value is null
     */
    public void setSummaryValueTitle(String summaryValueTitle) {
        setAttribute("summaryValueTitle", summaryValueTitle);
    }

    /**
     * Title to show in a  Summary of type "title" for this field. If unspecified <code>title</code> summaries will show the
     * {@link com.smartgwt.client.data.DataSourceField#getTitle title} for the field.
     *
     *
     * @return String
     */
    public String getSummaryValueTitle()  {
        return getAttributeAsString("summaryValueTitle");
    }

    /**
     * Default user-visible title for this field. <p> This will be picked up by DataBound components and other views over this
     * DataSource. <p> Note this property frequently does not need to be set since {@link
     * com.smartgwt.client.data.DataSource#getAutoDeriveTitles autoDeriveTitles} (on by default) usually picks an appropriate
     * user-visible title if you have a reasonable naming convention for your field names.
     *
     * @param title title Default value is null
     * @see com.smartgwt.client.docs.ComponentBinding ComponentBinding overview and related methods
     */
    public void setTitle(String title) {
        setAttribute("title", title);
    }

    /**
     * Default user-visible title for this field. <p> This will be picked up by DataBound components and other views over this
     * DataSource. <p> Note this property frequently does not need to be set since {@link
     * com.smartgwt.client.data.DataSource#getAutoDeriveTitles autoDeriveTitles} (on by default) usually picks an appropriate
     * user-visible title if you have a reasonable naming convention for your field names.
     *
     *
     * @return String
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
     * @param type type Default value is null
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public void setType(FieldType type) {
        setAttribute("type", type.getValue());
    }

    /**
     * Type of this field.  Required for all DataSource fields. <P> Field type may imply automatic validators (for example, an
     * integer field cannot accept the value "foo").  Field type also affects the default behaviors of DataBound components,
     * for example, if a field is declared as type "date", components that edit that field will automatically choose a
     * date-editing interface with pop-up date picker.
     *
     *
     * @return FieldType
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public FieldType getType()  {
        return EnumUtil.getEnum(FieldType.values(), getAttribute("type"));
    }

    /**
     * Used by the {@link com.smartgwt.client.widgets.BatchUploader} to map a field in an upload file to this  dataSourceField.
     * This is only necessary if the dataSourceField's name and title differ  from the name of the field in the upload file
     * (Smart GWT will automatically map upload  fields using the dataSourceField's title, if possible, if it does not get a
     * direct match  on field name).
     *
     * @param uploadFieldName uploadFieldName Default value is null
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
     *
     * @return String
     */
    public String getUploadFieldName()  {
        return getAttributeAsString("uploadFieldName");
    }

    /**
     * Validators to be applied to this field. <p> Validators are applied whenever there is an attempt to save changes to a
     * field. <p> For the available set of built-in validators, and how to define a custom validator, see the {@link
     * com.smartgwt.client.widgets.form.validator.Validator} class.
     *
     * @param validators validators Default value is null
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
     *
     * @return Validator
     * @see com.smartgwt.client.widgets.form.validator.Validator
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public Validator[] getValidators()  {
        return Validator.convertToValidatorArray(getAttributeAsJavaScriptObject("validators"));
    }

    /**
     * List of operators valid on this field.   <P> If not specified, all operators that are valid for the field type are
     * allowed.
     *
     * @param validOperators validOperators Default value is null
     */
    public void setValidOperators(OperatorId... validOperators) {
        setAttribute("validOperators", validOperators);
    }

    /**
     * List of operators valid on this field.   <P> If not specified, all operators that are valid for the field type are
     * allowed.
     *
     *
     * @return OperatorId
     */
    public OperatorId[] getValidOperators()  {
        return (OperatorId[]) EnumUtil.getEnums(OperatorId.values(), getAttributeAsStringArray("validOperators"));
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
    public void setValueMap(Map valueMap) {
        setAttribute("valueMap", valueMap);
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
     *
     * @return Map
     */
    public Map getValueMap()  {
        return getAttributeAsMap("valueMap");
    }

    /**
     * XPath expression used to retrieve the field's value.&#010 <P>&#010 This XPath expression will be evaluated in the scope
     * of the record objects selected by &#010 the {@link com.smartgwt.client.data.DataSource#getRecordXPath recordXPath}.  For
     * XML data &#010 ({@link com.smartgwt.client.data.DataSource#getDataFormat dataFormat:"xml"}) this means a call to&#010
     * {@link com.smartgwt.client.data.XMLTools#selectString XMLTools.selectString} passing the selected XML element.  For JSON
     * data&#010 ({@link com.smartgwt.client.data.DataSource#getDataFormat dataFormat:"json"}), this means a call to &#010
     * {@link com.smartgwt.client.data.XMLTools#selectObjects XMLTools.selectObjects} passing the selected JSON object.&#010
     * <P>&#010 In the absence of a <code>valueXPath</code>, for JSON data the value for the field will&#010 be the value of
     * the same-named property in the record object selected by&#010 {@link com.smartgwt.client.data.DataSource#getRecordXPath
     * recordXPath}.  &#010 <P>&#010 For XML data, the value will be the attribute or subelement named after the field
     * name.&#010 For example, for a field "author" on a record element &lt;book&gt;, the following structures&#010 require no
     * valueXPath:&#010 <pre>&#010    &lt;book author="Mark Jones"/&gt;&#010&#010    &lt;book&gt;&#010       
     * &lt;author&gt;Mark Jones&lt;/author&gt;&#010    &lt;/book&gt;&#010 </pre>&#010 <P>&#010 If <code>valueXPath</code> is
     * not required for your field because of the default handling&#010 described above, don't specify it, as it's slightly
     * slower.&#010 <p>&#010 To learn about XPath, try the following search:&#010 <a
     * href="http://www.google.com/search?q=xpath+tutorial" target="_blank"&#010
     * >http://www.google.com/search?q=xpath+tutorial</a>&#010 <P>&#010 <B>Using valueXPath with the Smart GWT server</B>&#010
     * <p>&#010 If you're using the Smart GWT server to return data via the DSResponse object (or&#010 indirectly doing so
     * using DataSource DMI), the valueXPath you specify on the DataSource&#010 fields will be applied to the data you return
     * via the &#010 <a href='http://jakarta.apache.org/commons/jxpath/'
     * onclick="window.open('http://jakarta.apache.org/commons/jxpath/');return false;">JXPath</a> library.&#010 <P>&#010 If
     * you are returning Java Beans as your DSResponse data, normally each dataSource field&#010 receives the value of the
     * same-named Java Bean property, that is, a field "zipCode" is&#010 populated by looking for "getZipCode()" on the objects
     * passed as DSResponse data.  You can&#010 use <code>valueXPath</code> to retrieve properties from subobjects, so long as
     * a chain of&#010 getter methods exists that corresponds to the valueXPath.  For example, a valueXPath of&#010
     * "address/zipCode" expects to call "getAddress()" on the bean(s) passed to&#010 DSResponse.setData(), followed by
     * "getZipCode()" on whatever object "getAddress()" returns.&#010 <P>&#010 When you are saving data, the inbound DSRequest
     * values, available as a Java Map, will use &#010 just dataSource field names as Map keys, not the valueXPath used to
     * derive them.  However,&#010 to achieve bidirectional valueXPath binding, you can use the server-side method&#010
     * dataSource.setProperties() to use the valueXPath when setting properties on your server&#010 object model.  When applied
     * as a setter, an XPath like "address/zipCode" attempts&#010 "getAddress()" followed by "setZipCode()" on the returned
     * object.  JXPath also has some&#010 ability to auto-create intervening objects if they are missing, such as auto-creating
     * an&#010 "address" subobject when applying "address/zipCode" as a valueXPath.&#010 <P>&#010 See the&#010 <a
     * href='http://jakarta.apache.org/commons/jxpath/'
     * onclick="window.open('http://jakarta.apache.org/commons/jxpath/');return false;">JXPath</a> library documentation
     * for&#010 complete details, including other types of server object models supported, such as&#010 server-side XML.
     *
     * @param valueXPath valueXPath Default value is null
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#xpath_xml_integration_category" target="examples">XPath Binding Example</a>
     */
    public void setValueXPath(String valueXPath) {
        setAttribute("valueXPath", valueXPath);
    }

    /**
     * XPath expression used to retrieve the field's value.&#010 <P>&#010 This XPath expression will be evaluated in the scope
     * of the record objects selected by &#010 the {@link com.smartgwt.client.data.DataSource#getRecordXPath recordXPath}.  For
     * XML data &#010 ({@link com.smartgwt.client.data.DataSource#getDataFormat dataFormat:"xml"}) this means a call to&#010
     * {@link com.smartgwt.client.data.XMLTools#selectString XMLTools.selectString} passing the selected XML element.  For JSON
     * data&#010 ({@link com.smartgwt.client.data.DataSource#getDataFormat dataFormat:"json"}), this means a call to &#010
     * {@link com.smartgwt.client.data.XMLTools#selectObjects XMLTools.selectObjects} passing the selected JSON object.&#010
     * <P>&#010 In the absence of a <code>valueXPath</code>, for JSON data the value for the field will&#010 be the value of
     * the same-named property in the record object selected by&#010 {@link com.smartgwt.client.data.DataSource#getRecordXPath
     * recordXPath}.  &#010 <P>&#010 For XML data, the value will be the attribute or subelement named after the field
     * name.&#010 For example, for a field "author" on a record element &lt;book&gt;, the following structures&#010 require no
     * valueXPath:&#010 <pre>&#010    &lt;book author="Mark Jones"/&gt;&#010&#010    &lt;book&gt;&#010       
     * &lt;author&gt;Mark Jones&lt;/author&gt;&#010    &lt;/book&gt;&#010 </pre>&#010 <P>&#010 If <code>valueXPath</code> is
     * not required for your field because of the default handling&#010 described above, don't specify it, as it's slightly
     * slower.&#010 <p>&#010 To learn about XPath, try the following search:&#010 <a
     * href="http://www.google.com/search?q=xpath+tutorial" target="_blank"&#010
     * >http://www.google.com/search?q=xpath+tutorial</a>&#010 <P>&#010 <B>Using valueXPath with the Smart GWT server</B>&#010
     * <p>&#010 If you're using the Smart GWT server to return data via the DSResponse object (or&#010 indirectly doing so
     * using DataSource DMI), the valueXPath you specify on the DataSource&#010 fields will be applied to the data you return
     * via the &#010 <a href='http://jakarta.apache.org/commons/jxpath/'
     * onclick="window.open('http://jakarta.apache.org/commons/jxpath/');return false;">JXPath</a> library.&#010 <P>&#010 If
     * you are returning Java Beans as your DSResponse data, normally each dataSource field&#010 receives the value of the
     * same-named Java Bean property, that is, a field "zipCode" is&#010 populated by looking for "getZipCode()" on the objects
     * passed as DSResponse data.  You can&#010 use <code>valueXPath</code> to retrieve properties from subobjects, so long as
     * a chain of&#010 getter methods exists that corresponds to the valueXPath.  For example, a valueXPath of&#010
     * "address/zipCode" expects to call "getAddress()" on the bean(s) passed to&#010 DSResponse.setData(), followed by
     * "getZipCode()" on whatever object "getAddress()" returns.&#010 <P>&#010 When you are saving data, the inbound DSRequest
     * values, available as a Java Map, will use &#010 just dataSource field names as Map keys, not the valueXPath used to
     * derive them.  However,&#010 to achieve bidirectional valueXPath binding, you can use the server-side method&#010
     * dataSource.setProperties() to use the valueXPath when setting properties on your server&#010 object model.  When applied
     * as a setter, an XPath like "address/zipCode" attempts&#010 "getAddress()" followed by "setZipCode()" on the returned
     * object.  JXPath also has some&#010 ability to auto-create intervening objects if they are missing, such as auto-creating
     * an&#010 "address" subobject when applying "address/zipCode" as a valueXPath.&#010 <P>&#010 See the&#010 <a
     * href='http://jakarta.apache.org/commons/jxpath/'
     * onclick="window.open('http://jakarta.apache.org/commons/jxpath/');return false;">JXPath</a> library documentation
     * for&#010 complete details, including other types of server object models supported, such as&#010 server-side XML.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#xpath_xml_integration_category" target="examples">XPath Binding Example</a>
     */
    public String getValueXPath()  {
        return getAttributeAsString("valueXPath");
    }

    /**
     * Indicates that {@link com.smartgwt.client.data.DataSource#xmlSerialize DataSource.xmlSerialize} should serialize this
     * value as an XML attribute. <P> Note this does not need to be declared in order for DataSource records to be derived from
     * XML data: a field will be populated with either an attribute or subelement with matching name.
     *
     * @param xmlAttribute xmlAttribute Default value is null
     * @see com.smartgwt.client.docs.ComponentSchema ComponentSchema overview and related methods
     */
    public void setXmlAttribute(Boolean xmlAttribute) {
        setAttribute("xmlAttribute", xmlAttribute);
    }

    /**
     * Indicates that {@link com.smartgwt.client.data.DataSource#xmlSerialize DataSource.xmlSerialize} should serialize this
     * value as an XML attribute. <P> Note this does not need to be declared in order for DataSource records to be derived from
     * XML data: a field will be populated with either an attribute or subelement with matching name.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.ComponentSchema ComponentSchema overview and related methods
     */
    public Boolean getXmlAttribute()  {
        return getAttributeAsBoolean("xmlAttribute");
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
     * Sets the default FormItem to be used whenever this field is edited (whether in a grid, form, or other component).
     * <P> If unset, a FormItem will be automatically chosen based on the type of the field.
     * <p><br>
     * <b>Note</b> : When you supply a custom FormItem via setEditorType(), you're really providing properties which are then used
     * to create multiple FormItems (eg, in grids, forms and trees) and there's an underlying limitation here where event handlers
     * have to be written to dynamically receive the actual FormItem rather than relying on "this" (because there's more than one "this").
     *
     * @param editorType editorType Default value is null
     */
    public void setEditorType(FormItem editorType) {
        //only set the editorType attribute if the passed editorType is a concrete subclass of FormItem
        if(!editorType.getClass().getName().equals(FormItem.class.getName())) {
            String fiEditorType = editorType.getAttribute("editorType");
            //fallback to type if editorType is not specified
            if(fiEditorType == null) fiEditorType = editorType.getType();
            if (fiEditorType != null) setAttribute("editorType", fiEditorType);
        }
        JavaScriptObject editorConfig = editorType.getConfig();
        setAttribute("editorProperties", editorConfig);
    }

    /**
     * 
     * Sets the default FormItem to be used if this field is marked as 
     * {@link #setCanEdit,canEdit false} and displayed in an editor component such as a DynamicForm.
     * <P>
     * This property may also be specified at the type level by specifying 
     * {@link SimpleType.setReadOnlyEditorType()}.
     * 
     * @param editorType editorType Default value is null
     */
    public void setReadOnlyEditorType(FormItem editorType) {
        //only set the editorType attribute if the passed editorType is a concrete subclass of FormItem
        if(!editorType.getClass().getName().equals(FormItem.class.getName())) {
            String fiEditorType = editorType.getAttribute("editorType");
            //fallback to type if editorType is not specified
            if(fiEditorType == null) fiEditorType = editorType.getType();
            if (fiEditorType != null) setAttribute("readOnlyEditorType", fiEditorType);
        }
        JavaScriptObject editorConfig = editorType.getConfig();
        setAttribute("readOnlyEditorProperties", editorConfig);
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

    public static DataSourceField[] convertToDataSourceFieldArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new DataSourceField[]{};
        }
        if (JSOHelper.isArray(nativeArray)) {
            JavaScriptObject[] componentsj = JSOHelper.toArray(nativeArray);
            DataSourceField[] objects = new DataSourceField[componentsj.length];
            for (int i = 0; i < componentsj.length; i++) {
                JavaScriptObject componentJS = componentsj[i];
                objects[i] = DataSourceField.getOrCreateRef(componentJS);
            }
            return objects;
        } else {
            DataSourceField[] ret = new DataSourceField[1];
            ret[0] = DataSourceField.getOrCreateRef(nativeArray);
            return ret;
        }
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
            var recordsJ =  @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(records);
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

}








