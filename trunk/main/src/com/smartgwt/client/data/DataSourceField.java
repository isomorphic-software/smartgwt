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
    * Metadata about a DataSourceField, including its type and validators.

    */
public class DataSourceField extends DataClass {

    public static DataSourceField getOrCreateRef(JavaScriptObject jsObj) {
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
    * Name for this field.   <p> The field name is also the property in each DataSource record which holds the value for this field. <P> Must be unique across all fields within the DataSource.
    *
    * @param name name Default value is null
    */
    public void setName(String name) {
        setAttribute("name", name);
    }
    /**
     * Name for this field.   <p> The field name is also the property in each DataSource record which holds the value for this field. <P> Must be unique across all fields within the DataSource.
     *
     *
     * @return String
     *
     */
    public String getName()  {
        return getAttributeAsString("name");
    }
             
    /**
    * Type of this field.  Required for all DataSource fields. <P> Field type may imply automatic validators (for example, an integer field cannot accept the value "foo").  Field type also affects the default behaviors of DataBound components, for example, if a field is declared of type "date", components that edit that field will automatically choose a date-editing interface with pop-up date picker.
    *
    * @param type type Default value is null
    */
    public void setType(FieldType type) {
        setAttribute("type", type.getValue());
    }
    /**
     * Type of this field.  Required for all DataSource fields. <P> Field type may imply automatic validators (for example, an integer field cannot accept the value "foo").  Field type also affects the default behaviors of DataBound components, for example, if a field is declared of type "date", components that edit that field will automatically choose a date-editing interface with pop-up date picker.
     *
     *
     * @return FieldType
     *
     */
    public FieldType getType()  {
        return (FieldType) EnumUtil.getEnum(FieldType.values(), getAttribute("type"));
    }

    /**
    * Indicates this field must be non-null in order for a record to pass validation. <P> Note that <code>required</code> should not be set for a server-generated field, such as a sequence, or validation will fail on the client.
    *
    * @param required required Default value is false
    */
    public void setRequired(Boolean required) {
        setAttribute("required", required);
    }
    /**
     * Indicates this field must be non-null in order for a record to pass validation. <P> Note that <code>required</code> should not be set for a server-generated field, such as a sequence, or validation will fail on the client.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getRequired()  {
        return getAttributeAsBoolean("required");
    }

    /**
    * Maximum number of characters allowed.  Applicable only to fields of text type.
    *
    * @param length length Default value is null
    */
    public void setLength(Integer length) {
        setAttribute("length", length);
    }
    /**
     * Maximum number of characters allowed.  Applicable only to fields of text type.
     *
     *
     * @return Integer
     *
     */
    public Integer getLength()  {
        return getAttributeAsInt("length");
    }

    /**
    * XPath expression used to retrieve the field's value. <P> This XPath expression will be evaluated in the scope of the record objects selected by  the {@link com.smartgwt.client.data.DataSource#getRecordXPath recordXPath}.  For XML data  ({@link com.smartgwt.client.data.DataSource#getDataFormat dataFormat}) this means a call to {@link com.smartgwt.client.util.XMLTools#selectString} passing the selected XML element.  For JSON data ({@link com.smartgwt.client.data.DataSource#getDataFormat dataFormat}), this means a call to  {@link com.smartgwt.client.util.XMLTools#selectObjects} passing the selected JSON object. <P> In the absence of a <code>valueXPath</code>, for JSON data the value for the field will be the value of the same-named property in the selected object.   <P> For XML data, the value will be the attribute or subelement named after the field name For example, for a field "author" on a record element &lt;book&gt;, the following structures require no valueXPath: <pre>    &lt;book author="Mark Jones"/&gt;    &lt;book&gt;        &lt;author&gt;Mark Jones&lt;/author&gt;    &lt;/book&gt; </pre> <p> To learn about XPath, try the following search: <a href="http://www.google.com/search?q=xpath+tutorial" target="_blank" >http://www.google.com/search?q=xpath+tutorial</a> <P> <B>Using valueXPath with the SmartClient server</B> <p> If you're using the SmartClient server to return data via the DSResponse object (or indirectly doing so using DataSource DMI), the valueXPath you specify on the DataSource fields will be applied to the data you return via the  <a href='http://jakarta.apache.org/commons/jxpath/' onclick="window.open('http://jakarta.apache.org/commons/jxpath/');return false;">JXPath</a> library. <P> If you are returning Java Beans as your DSResponse data, normally each dataSource field receives the value of the same named Java Bean property, that is, a field "zipCode" is populated by looking for "getZipCode()" on the objects passed as DSResponse data.  You can use <code>valueXPath</code> to retrieve properties from subobjects, so long as a chain of getter methods exists that corresponds to the valueXPath.  For example, a valueXPath of "address/zipCode" expects to call "getAddress()" on the bean(s) passed to DSResponse.setData(), followed by "getZipCode()" on whatever object "getAddress()" returns. <P> When you are saving data, the inbound DSRequest values, available as a Java Map, will use  just dataSource field names as Map keys, not the valueXPath used to derive them.  However, to achieve bidirectional valueXPath binding, you can use the server-side method dataSource.setProperties() to use the valueXPath when setting properties on your server object model.  When applied as a setter, an XPath like "address/zipCode" attempts "getAddress()" followed by "setZipCode()" on the returned object.  JXPath also has some ability to auto-create intervening objects if they are missing, such as auto-creating an "address" subobject when applying "address/zipCode" as a valueXPath. <P> See the <a href='http://jakarta.apache.org/commons/jxpath/' onclick="window.open('http://jakarta.apache.org/commons/jxpath/');return false;">JXPath</a> library documentation for complete details, including other types of server object models supported, such as server-side XML.
    *
    * @param valueXPath valueXPath Default value is null
    */
    public void setValueXPath(String valueXPath) {
        setAttribute("valueXPath", valueXPath);
    }
    /**
     * XPath expression used to retrieve the field's value. <P> This XPath expression will be evaluated in the scope of the record objects selected by  the {@link com.smartgwt.client.data.DataSource#getRecordXPath recordXPath}.  For XML data  ({@link com.smartgwt.client.data.DataSource#getDataFormat dataFormat}) this means a call to {@link com.smartgwt.client.util.XMLTools#selectString} passing the selected XML element.  For JSON data ({@link com.smartgwt.client.data.DataSource#getDataFormat dataFormat}), this means a call to  {@link com.smartgwt.client.util.XMLTools#selectObjects} passing the selected JSON object. <P> In the absence of a <code>valueXPath</code>, for JSON data the value for the field will be the value of the same-named property in the selected object.   <P> For XML data, the value will be the attribute or subelement named after the field name For example, for a field "author" on a record element &lt;book&gt;, the following structures require no valueXPath: <pre>    &lt;book author="Mark Jones"/&gt;    &lt;book&gt;        &lt;author&gt;Mark Jones&lt;/author&gt;    &lt;/book&gt; </pre> <p> To learn about XPath, try the following search: <a href="http://www.google.com/search?q=xpath+tutorial" target="_blank" >http://www.google.com/search?q=xpath+tutorial</a> <P> <B>Using valueXPath with the SmartClient server</B> <p> If you're using the SmartClient server to return data via the DSResponse object (or indirectly doing so using DataSource DMI), the valueXPath you specify on the DataSource fields will be applied to the data you return via the  <a href='http://jakarta.apache.org/commons/jxpath/' onclick="window.open('http://jakarta.apache.org/commons/jxpath/');return false;">JXPath</a> library. <P> If you are returning Java Beans as your DSResponse data, normally each dataSource field receives the value of the same named Java Bean property, that is, a field "zipCode" is populated by looking for "getZipCode()" on the objects passed as DSResponse data.  You can use <code>valueXPath</code> to retrieve properties from subobjects, so long as a chain of getter methods exists that corresponds to the valueXPath.  For example, a valueXPath of "address/zipCode" expects to call "getAddress()" on the bean(s) passed to DSResponse.setData(), followed by "getZipCode()" on whatever object "getAddress()" returns. <P> When you are saving data, the inbound DSRequest values, available as a Java Map, will use  just dataSource field names as Map keys, not the valueXPath used to derive them.  However, to achieve bidirectional valueXPath binding, you can use the server-side method dataSource.setProperties() to use the valueXPath when setting properties on your server object model.  When applied as a setter, an XPath like "address/zipCode" attempts "getAddress()" followed by "setZipCode()" on the returned object.  JXPath also has some ability to auto-create intervening objects if they are missing, such as auto-creating an "address" subobject when applying "address/zipCode" as a valueXPath. <P> See the <a href='http://jakarta.apache.org/commons/jxpath/' onclick="window.open('http://jakarta.apache.org/commons/jxpath/');return false;">JXPath</a> library documentation for complete details, including other types of server object models supported, such as server-side XML.
     *
     *
     * @return String
     *
     */
    public String getValueXPath()  {
        return getAttributeAsString("valueXPath");
    }

    /**
    * Default user-visible title for this field. <p> This will be picked up by DataBound components and other views onto this DataSource.
    *
    * @param title title Default value is null
    */
    public void setTitle(String title) {
        setAttribute("title", title);
    }
    /**
     * Default user-visible title for this field. <p> This will be picked up by DataBound components and other views onto this DataSource.
     *
     *
     * @return String
     *
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }

    /**
    * Whether this field can ever be edited by the user.  If set to <code>false</code>, no DataBound component will ever try to offer an editing interface for this field.
    *
    * @param canEdit canEdit Default value is null
    */
    public void setCanEdit(Boolean canEdit) {
        setAttribute("canEdit", canEdit);
    }
    /**
     * Whether this field can ever be edited by the user.  If set to <code>false</code>, no DataBound component will ever try to offer an editing interface for this field.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanEdit()  {
        return getAttributeAsBoolean("canEdit");
    }

    /**
    * Whether this field should be hidden from users by default within a DataBound component. This is generally used for internal ids and other values not meaningful to users. <P> See {@link com.smartgwt.client.data.DataSourceField#getDetail detail} for fields that should be hidden in a summary view such as a {@link com.smartgwt.client.widgets.grid.ListGrid}, but still available to the user.
    *
    * @param hidden hidden Default value is false
    */
    public void setHidden(Boolean hidden) {
        setAttribute("hidden", hidden);
    }
    /**
     * Whether this field should be hidden from users by default within a DataBound component. This is generally used for internal ids and other values not meaningful to users. <P> See {@link com.smartgwt.client.data.DataSourceField#getDetail detail} for fields that should be hidden in a summary view such as a {@link com.smartgwt.client.widgets.grid.ListGrid}, but still available to the user.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getHidden()  {
        return getAttributeAsBoolean("hidden");
    }

    /**
    * Whether this field should be completely excluded from this dataSource, as if it had never been defined.
    *
    * @param ignore ignore Default value is false
    */
    public void setIgnore(Boolean ignore) {
        setAttribute("ignore", ignore);
    }
    /**
     * Whether this field should be completely excluded from this dataSource, as if it had never been defined.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getIgnore()  {
        return getAttributeAsBoolean("ignore");
    }

    /**
    * Whether this field should be considered a "detail" by a ${isc.DocUtils.linkForRef('interface:DataBoundComponent')}. <P> Detail fields won't be shown by default in a DataBoundComponent where  {@link com.smartgwt.client..DataBoundComponent#getShowDetailFields showDetailFields} is false.  This allows for some DataBound components, like a {@link com.smartgwt.client.widgets.grid.ListGrid}, to show a summary view of records which displays only  the most commonly viewed fields by default, while other DataBoundComponents, like a {@link com.smartgwt.client.widgets.viewer.DetailViewer}, show all fields by default. <P> In addition, the ${isc.DocUtils.linkForRef('field.showIf','formItem.showIf')} property is supported in multiple components for conditional visibility - see for example {@link com.smartgwt.client.widgets.grid.ListGridField#showIf} and {@link com.smartgwt.client.widgets.form.fields.FormItem#showIf}).
    *
    * @param detail detail Default value is false
    */
    public void setDetail(Boolean detail) {
        setAttribute("detail", detail);
    }
    /**
     * Whether this field should be considered a "detail" by a ${isc.DocUtils.linkForRef('interface:DataBoundComponent')}. <P> Detail fields won't be shown by default in a DataBoundComponent where  {@link com.smartgwt.client..DataBoundComponent#getShowDetailFields showDetailFields} is false.  This allows for some DataBound components, like a {@link com.smartgwt.client.widgets.grid.ListGrid}, to show a summary view of records which displays only  the most commonly viewed fields by default, while other DataBoundComponents, like a {@link com.smartgwt.client.widgets.viewer.DetailViewer}, show all fields by default. <P> In addition, the ${isc.DocUtils.linkForRef('field.showIf','formItem.showIf')} property is supported in multiple components for conditional visibility - see for example {@link com.smartgwt.client.widgets.grid.ListGridField#showIf} and {@link com.smartgwt.client.widgets.form.fields.FormItem#showIf}).
     *
     *
     * @return Boolean
     *
     */
    public Boolean getDetail()  {
        return getAttributeAsBoolean("detail");
    }

    /**
    * Whether this field holds a value unique across all records in this DataSource. <p> A DataSource that can <i>only</i> perform the "fetch" operation does not require a primaryKey.  If a DataSource allows modification of DataSource records through add, update and remove DataSource operations, exactly one field must be marked as the primary key. <P> SmartClient requires a primary key value to uniquely identify records when communicating updates or deletions to the server.  There is no requirement that the primaryKey field be mapped to an actual "primary key" in your object model, web service, or database.  The only requirement is that values of the primaryKey field be unique for a given browser instance for the lifetime of the page.   <P> If your underlying data model has no primaryKey or has multiple primaryKey(s), you can generate unique values or combine multiple values into a single field that serves as a unique key, and declare that field as the single primary key instead.  For example, if your underlying data model has two primary keys "firstName" and "lastName", you can use {@link com.smartgwt.client.data.DataSource#transformResponse} to combine them to into a new field "name_key": <pre> isc.DataSource.create({    fields:[        {name:"name_key", primaryKey:true},        {name:"firstName"},        {name:"lastName"},        ... other fields ...    ],    transformResponse : function (dsResponse) {        var data = dsResponse.data;        for (var i = 0 ; i &lt; data.length; i++) {            data[i].name_key = data[i].firstName + ":" +                               data[i].lastName;        }    } }); </pre> <P> Here it is assumed that ":" is not a legal character in either the firstName or lastName field.  Updates to records from this DataSource will then be sent with name_key as the primary key value, and the server can split the value to obtain the separate key values. <P> If using ISC's SQL engine and generating SQL tables using the "DataBases" tab of the Developer Console, the table column generated from a primaryKey field will have a unique constraint applied in the database table.
    *
    * @param primaryKey primaryKey Default value is false
    */
    public void setPrimaryKey(Boolean primaryKey) {
        setAttribute("primaryKey", primaryKey);
    }
    /**
     * Whether this field holds a value unique across all records in this DataSource. <p> A DataSource that can <i>only</i> perform the "fetch" operation does not require a primaryKey.  If a DataSource allows modification of DataSource records through add, update and remove DataSource operations, exactly one field must be marked as the primary key. <P> SmartClient requires a primary key value to uniquely identify records when communicating updates or deletions to the server.  There is no requirement that the primaryKey field be mapped to an actual "primary key" in your object model, web service, or database.  The only requirement is that values of the primaryKey field be unique for a given browser instance for the lifetime of the page.   <P> If your underlying data model has no primaryKey or has multiple primaryKey(s), you can generate unique values or combine multiple values into a single field that serves as a unique key, and declare that field as the single primary key instead.  For example, if your underlying data model has two primary keys "firstName" and "lastName", you can use {@link com.smartgwt.client.data.DataSource#transformResponse} to combine them to into a new field "name_key": <pre> isc.DataSource.create({    fields:[        {name:"name_key", primaryKey:true},        {name:"firstName"},        {name:"lastName"},        ... other fields ...    ],    transformResponse : function (dsResponse) {        var data = dsResponse.data;        for (var i = 0 ; i &lt; data.length; i++) {            data[i].name_key = data[i].firstName + ":" +                               data[i].lastName;        }    } }); </pre> <P> Here it is assumed that ":" is not a legal character in either the firstName or lastName field.  Updates to records from this DataSource will then be sent with name_key as the primary key value, and the server can split the value to obtain the separate key values. <P> If using ISC's SQL engine and generating SQL tables using the "DataBases" tab of the Developer Console, the table column generated from a primaryKey field will have a unique constraint applied in the database table.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getPrimaryKey()  {
        return getAttributeAsBoolean("primaryKey");
    }

    /**
    * Declares that this field holds values that can be matched to values from another DataSource field, to create a relationship between records from different DataSources or even records within the same DataSource. <p> The format of <code>foreignKey</code> is <code>&lt;dataSourceId&gt;.&lt;fieldName&gt;</code>.<br> For a foreignKey within the same dataSource, you can omit the <code>dataSourceId</code> and just specify <code>&lt;fieldName&gt;</code>.<br> For example, to create a tree relationship within a DataSource: <pre>   DataSource.create({     ID:"supplyItem",     fields : [       {name:"itemId", type:"sequence", primaryKey:true},       {name:"parentId", type:"integer", foreignKey:"itemId"},       ...     ]   }); </pre> <P> <code>foreignKey</code> declarations also allow other automatic behaviors by ${isc.DocUtils.linkForRef('interface:DataBoundComponent','DataBoundComponents')}, such as {@link com.smartgwt.client.widgets.grid.ListGrid#fetchRelatedData}.
    *
    * @param foreignKey foreignKey Default value is false
    */
    public void setForeignKey(String foreignKey) {
        setAttribute("foreignKey", foreignKey);
    }
    /**
     * Declares that this field holds values that can be matched to values from another DataSource field, to create a relationship between records from different DataSources or even records within the same DataSource. <p> The format of <code>foreignKey</code> is <code>&lt;dataSourceId&gt;.&lt;fieldName&gt;</code>.<br> For a foreignKey within the same dataSource, you can omit the <code>dataSourceId</code> and just specify <code>&lt;fieldName&gt;</code>.<br> For example, to create a tree relationship within a DataSource: <pre>   DataSource.create({     ID:"supplyItem",     fields : [       {name:"itemId", type:"sequence", primaryKey:true},       {name:"parentId", type:"integer", foreignKey:"itemId"},       ...     ]   }); </pre> <P> <code>foreignKey</code> declarations also allow other automatic behaviors by ${isc.DocUtils.linkForRef('interface:DataBoundComponent','DataBoundComponents')}, such as {@link com.smartgwt.client.widgets.grid.ListGrid#fetchRelatedData}.
     *
     *
     * @return String
     *
     */
    public String getForeignKey()  {
        return getAttributeAsString("foreignKey");
    }

    /**
    * If true, this property indicates that this field will hold an explicit array of child nodes  for the current node. This has the same effect as specifying {@link com.smartgwt.client.data.DataSource#getChildrenField childrenField} to this field's  name.
    *
    * @param childrenProperty childrenProperty Default value is false
    */
    public void setChildrenProperty(Boolean childrenProperty) {
        setAttribute("childrenProperty", childrenProperty);
    }
    /**
     * If true, this property indicates that this field will hold an explicit array of child nodes  for the current node. This has the same effect as specifying {@link com.smartgwt.client.data.DataSource#getChildrenField childrenField} to this field's  name.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getChildrenProperty()  {
        return getAttributeAsBoolean("childrenProperty");
    }

    /**
    * For a DataSource with {@link com.smartgwt.client.data.DataSource#getServerType serverType} with a field of type "sequence", the name of the SQL sequence that should be used when inserting new records into this table. <P> Note that this is never required for SQL tables that are generated from SmartClient DataSources (a default sequence name of tableName + "_" + columnName is chosen), and is  never required for databases where inserting null into a sequence column is sufficient (MySQL, SQL Server, DB2 and others).   <P> You would only need to set sequenceName if you are integrating with a pre-existing table stored in a database where the sequence must be named for insertion to work (Oracle, Postgres) OR you are trying to use the same sequence across multiple DataSources.
    *
    * @param sequenceName sequenceName Default value is null
    */
    public void setSequenceName(String sequenceName) {
        setAttribute("sequenceName", sequenceName);
    }
    /**
     * For a DataSource with {@link com.smartgwt.client.data.DataSource#getServerType serverType} with a field of type "sequence", the name of the SQL sequence that should be used when inserting new records into this table. <P> Note that this is never required for SQL tables that are generated from SmartClient DataSources (a default sequence name of tableName + "_" + columnName is chosen), and is  never required for databases where inserting null into a sequence column is sufficient (MySQL, SQL Server, DB2 and others).   <P> You would only need to set sequenceName if you are integrating with a pre-existing table stored in a database where the sequence must be named for insertion to work (Oracle, Postgres) OR you are trying to use the same sequence across multiple DataSources.
     *
     *
     * @return String
     *
     */
    public String getSequenceName()  {
        return getAttributeAsString("sequenceName");
    }

    /**
    * Indicates that {@link com.smartgwt.client.data.DataSource#xmlSerialize} should serialize this value as an XML attribute. <P> Note this does not need to be declared in order for DataSource records to be derived from XML data: a field will be populated with either an attribute or subelement with matching name.
    *
    * @param xmlAttribute xmlAttribute Default value is null
    */
    public void setXmlAttribute(Boolean xmlAttribute) {
        setAttribute("xmlAttribute", xmlAttribute);
    }
    /**
     * Indicates that {@link com.smartgwt.client.data.DataSource#xmlSerialize} should serialize this value as an XML attribute. <P> Note this does not need to be declared in order for DataSource records to be derived from XML data: a field will be populated with either an attribute or subelement with matching name.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getXmlAttribute()  {
        return getAttributeAsBoolean("xmlAttribute");
    }

    /**
    * Indicates that this field should always be Array-valued.  If the value derived from {@link com.smartgwt.client.data.DataSource#getDataFormat dataFormat} is singular, it will be wrapped in an Array. <P> Specifically for XML serialization and deserialization, <code>multiple:true</code> behaves similarly to the  <a href='http://www.google.com/search?hl=en&q=soap+array' onclick="window.open('http://www.google.com/search?hl=en&q=soap+array');return false;">SOAP array idiom</a>, that is, there will be a "wrapper element" named after the field name, whose contents will be several elements of the specified {@link com.smartgwt.client.data.DataSourceField#getType type}.   <P> For example, {@link com.smartgwt.client.widgets.layout.Layout#getMembers members} is declared with <code>type:"Canvas", multiple:true</code>.  The correct XML format is thus: <pre> &lt;VLayout&gt;     &lt;members&gt;         &lt;Canvas ID="myCanvas" ... /&gt;         &lt;ListGrid ID="myGrid" .../&gt;         &lt;Toolstrip ID="myToolStrip" ... /&gt;     &lt;/members&gt; &lt;/VLayout&gt; </pre>
    *
    * @param multiple multiple Default value is null
    */
    public void setMultiple(Boolean multiple) {
        setAttribute("multiple", multiple);
    }
    /**
     * Indicates that this field should always be Array-valued.  If the value derived from {@link com.smartgwt.client.data.DataSource#getDataFormat dataFormat} is singular, it will be wrapped in an Array. <P> Specifically for XML serialization and deserialization, <code>multiple:true</code> behaves similarly to the  <a href='http://www.google.com/search?hl=en&q=soap+array' onclick="window.open('http://www.google.com/search?hl=en&q=soap+array');return false;">SOAP array idiom</a>, that is, there will be a "wrapper element" named after the field name, whose contents will be several elements of the specified {@link com.smartgwt.client.data.DataSourceField#getType type}.   <P> For example, {@link com.smartgwt.client.widgets.layout.Layout#getMembers members} is declared with <code>type:"Canvas", multiple:true</code>.  The correct XML format is thus: <pre> &lt;VLayout&gt;     &lt;members&gt;         &lt;Canvas ID="myCanvas" ... /&gt;         &lt;ListGrid ID="myGrid" .../&gt;         &lt;Toolstrip ID="myToolStrip" ... /&gt;     &lt;/members&gt; &lt;/VLayout&gt; </pre>
     *
     *
     * @return Boolean
     *
     */
    public Boolean getMultiple()  {
        return getAttributeAsBoolean("multiple");
    }

    /**
    * For use in ${isc.DocUtils.linkForRef('group:componentSchema')} for fields that contain other components, this flag suppresses auto-construction for subcomponents that appear under this field. <P> For example, the {@link com.smartgwt.client.widgets.layout.VLayout} schema sets this for its {@link com.smartgwt.client.widgets.layout.Layout#getMembers members} property, so that when a VLayout is constructed via XML as follows: <pre> &lt;VLayout&gt;     &lt;members&gt;         &lt;ListGrid ID="myGrid" .../&gt;         &lt;Toolstrip ID="myToolStrip" ... /&gt;     &lt;/members&gt; &lt;/VLayout&gt; </pre> The ListGrid and ToolStrip do not construct themselves automatically.  Instead, the VLayout receives the properties of the ListGrid and ToolStrip as ordinary JavaScript Objects, with the special property <code>_constructor</code> set to the name of the class that should be constructed.
    *
    * @param propertiesOnly propertiesOnly Default value is null
    */
    public void setPropertiesOnly(Boolean propertiesOnly) {
        setAttribute("propertiesOnly", propertiesOnly);
    }
    /**
     * For use in ${isc.DocUtils.linkForRef('group:componentSchema')} for fields that contain other components, this flag suppresses auto-construction for subcomponents that appear under this field. <P> For example, the {@link com.smartgwt.client.widgets.layout.VLayout} schema sets this for its {@link com.smartgwt.client.widgets.layout.Layout#getMembers members} property, so that when a VLayout is constructed via XML as follows: <pre> &lt;VLayout&gt;     &lt;members&gt;         &lt;ListGrid ID="myGrid" .../&gt;         &lt;Toolstrip ID="myToolStrip" ... /&gt;     &lt;/members&gt; &lt;/VLayout&gt; </pre> The ListGrid and ToolStrip do not construct themselves automatically.  Instead, the VLayout receives the properties of the ListGrid and ToolStrip as ordinary JavaScript Objects, with the special property <code>_constructor</code> set to the name of the class that should be constructed.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getPropertiesOnly()  {
        return getAttributeAsBoolean("propertiesOnly");
    }

    /**
    * For use in ${isc.DocUtils.linkForRef('group:componentSchema')}, a field {@link com.smartgwt.client.data.DataSource#getInheritsFrom inheritsFrom} from another schema can be redeclared with this property set in order to indicate that the property should not be used. <P> This is primarily used to influence ${isc.DocUtils.linkForRef('group:visualBuilder')}.  For simple type properties, this avoids the property appearing in the Component Editor.   <P> For fields that hold subcomponents, this prevents inappropriate drag and drop.  For example, a custom class called <code>MyDialog</code> may automatically create a series of children, and not allow arbitrary other children to be added.  In this case, the inherited property {@link com.smartgwt.client.widgets.Canvas#getChildren children} should be marked inapplicable in order to prevent arbitrary components being dropped onto a <code>MyDialog</code> instance.
    *
    * @param inapplicable inapplicable Default value is null
    */
    public void setInapplicable(Boolean inapplicable) {
        setAttribute("inapplicable", inapplicable);
    }
    /**
     * For use in ${isc.DocUtils.linkForRef('group:componentSchema')}, a field {@link com.smartgwt.client.data.DataSource#getInheritsFrom inheritsFrom} from another schema can be redeclared with this property set in order to indicate that the property should not be used. <P> This is primarily used to influence ${isc.DocUtils.linkForRef('group:visualBuilder')}.  For simple type properties, this avoids the property appearing in the Component Editor.   <P> For fields that hold subcomponents, this prevents inappropriate drag and drop.  For example, a custom class called <code>MyDialog</code> may automatically create a series of children, and not allow arbitrary other children to be added.  In this case, the inherited property {@link com.smartgwt.client.widgets.Canvas#getChildren children} should be marked inapplicable in order to prevent arbitrary components being dropped onto a <code>MyDialog</code> instance.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getInapplicable()  {
        return getAttributeAsBoolean("inapplicable");
    }

    /**
    * For use in ${isc.DocUtils.linkForRef('group:componentSchema')}, indicates what group to place the property in when editing in Visual Builder.
    *
    * @param group group Default value is null
    */
    public void setGroup(String group) {
        setAttribute("group", group);
    }
    /**
     * For use in ${isc.DocUtils.linkForRef('group:componentSchema')}, indicates what group to place the property in when editing in Visual Builder.
     *
     *
     * @return String
     *
     */
    public String getGroup()  {
        return getAttributeAsString("group");
    }

    /**
    * For use with the SmartClient server when populating Java Beans / POJOs based on data contained in a DSRequest, <code>javaClass</code> specifies the fully qualified Java className to be created and passed to the setter for the Java Bean Property with the same name as this field.   <code>javaClass</code> is used both when manually calling DataSource.setProperties() and when auto-populating POJO arguments of a {@link com.smartgwt.client..DMI} method. <P> The Java class to create does not normally have to be specified: SmartClient will use Java reflection to inspect the type of argument expected by a setter method and will attempt conversion of inbound data to that type.  As described in the documentation for DataTools.setProperties(), this works for almost all typical cases.  However <code>field.javaClass</code> is useful for: <ul> <li> subobject of abstract or interface type: in this case Java Reflection is not sufficient to discover the concrete type that should be instantiated, and <code>javaClass</code> should be set instead.</li> <li> subobject of Collection or Map type, when Java generics are not used or the Collection member type or Map value type is abstract.  When Java generics are used (for example the setter takes an argument is of type Collection&lt;SomePOJO&gt; or Map&lt;KeyType,SomePOJO&gt;, SmartClient will automatically attempt to convert inbound data to the type of the members of the Collection or values of the Map.  Without generics, <code>javaClass</code> needs to be specified.  Note that <code>javaClass</code> will take precendence over generics if both  are used. Also note that {@link com.smartgwt.client.data.DataSourceField#getJavaCollectionClass javaCollectionClass} can be specified if a particular Collection or Map type is needed, and {@link com.smartgwt.client.data.DataSourceField#getJavaKeyClass javaKeyClass} can be specified for a field of type <code>java.util.Map</code>.</li> </ul>
    *
    * @param javaClass javaClass Default value is null
    */
    public void setJavaClass(String javaClass) {
        setAttribute("javaClass", javaClass);
    }
    /**
     * For use with the SmartClient server when populating Java Beans / POJOs based on data contained in a DSRequest, <code>javaClass</code> specifies the fully qualified Java className to be created and passed to the setter for the Java Bean Property with the same name as this field.   <code>javaClass</code> is used both when manually calling DataSource.setProperties() and when auto-populating POJO arguments of a {@link com.smartgwt.client..DMI} method. <P> The Java class to create does not normally have to be specified: SmartClient will use Java reflection to inspect the type of argument expected by a setter method and will attempt conversion of inbound data to that type.  As described in the documentation for DataTools.setProperties(), this works for almost all typical cases.  However <code>field.javaClass</code> is useful for: <ul> <li> subobject of abstract or interface type: in this case Java Reflection is not sufficient to discover the concrete type that should be instantiated, and <code>javaClass</code> should be set instead.</li> <li> subobject of Collection or Map type, when Java generics are not used or the Collection member type or Map value type is abstract.  When Java generics are used (for example the setter takes an argument is of type Collection&lt;SomePOJO&gt; or Map&lt;KeyType,SomePOJO&gt;, SmartClient will automatically attempt to convert inbound data to the type of the members of the Collection or values of the Map.  Without generics, <code>javaClass</code> needs to be specified.  Note that <code>javaClass</code> will take precendence over generics if both  are used. Also note that {@link com.smartgwt.client.data.DataSourceField#getJavaCollectionClass javaCollectionClass} can be specified if a particular Collection or Map type is needed, and {@link com.smartgwt.client.data.DataSourceField#getJavaKeyClass javaKeyClass} can be specified for a field of type <code>java.util.Map</code>.</li> </ul>
     *
     *
     * @return String
     *
     */
    public String getJavaClass()  {
        return getAttributeAsString("javaClass");
    }

    /**
    * See {@link com.smartgwt.client.data.DataSourceField#getJavaClass javaClass} - when auto-populating of Java Beans / POJOs based on  inbound DSRequest data, for a field of type Collection or Map,  <code>javaCollectionClass</code> can  be used to specify a particular concrete class to use.  If not specified, and a concrete Collection or Map class cannot be discovered using Java Reflection,  <code>java.util.ArrayList</code> is used for fields of type Collection, and  <code>org.apache.commons.collections.SequencedHashMap</code> is used for fields of type Map. Note that this value is used even if the target Collection or Map is declared as a concrete class.  So, for example, if you set <code>javaCollectionClass</code> to  <code>java.util.LinkedList</code> but your setter method accepts a  <code>java.util.ArrayList</code>, you will get a ClassCastException.
    *
    * @param javaCollectionClass javaCollectionClass Default value is null
    */
    public void setJavaCollectionClass(String javaCollectionClass) {
        setAttribute("javaCollectionClass", javaCollectionClass);
    }
    /**
     * See {@link com.smartgwt.client.data.DataSourceField#getJavaClass javaClass} - when auto-populating of Java Beans / POJOs based on  inbound DSRequest data, for a field of type Collection or Map,  <code>javaCollectionClass</code> can  be used to specify a particular concrete class to use.  If not specified, and a concrete Collection or Map class cannot be discovered using Java Reflection,  <code>java.util.ArrayList</code> is used for fields of type Collection, and  <code>org.apache.commons.collections.SequencedHashMap</code> is used for fields of type Map. Note that this value is used even if the target Collection or Map is declared as a concrete class.  So, for example, if you set <code>javaCollectionClass</code> to  <code>java.util.LinkedList</code> but your setter method accepts a  <code>java.util.ArrayList</code>, you will get a ClassCastException.
     *
     *
     * @return String
     *
     */
    public String getJavaCollectionClass()  {
        return getAttributeAsString("javaCollectionClass");
    }

    /**
    * See {@link com.smartgwt.client.data.DataSourceField#getJavaClass javaClass} - when auto-populating of Java Beans / POJOs based on  inbound DSRequest data, for a field of Map type, <code>javaKeyClass</code> can be used to specify a particular concrete class for the map keys.  If not specified, and a concrete type cannot be discovered using Java Reflection, <code>java.lang.Object</code> is used. Note that <code>javaKeyClass</code> take precedence over generics if both are used.
    *
    * @param javaKeyClass javaKeyClass Default value is null
    */
    public void setJavaKeyClass(String javaKeyClass) {
        setAttribute("javaKeyClass", javaKeyClass);
    }
    /**
     * See {@link com.smartgwt.client.data.DataSourceField#getJavaClass javaClass} - when auto-populating of Java Beans / POJOs based on  inbound DSRequest data, for a field of Map type, <code>javaKeyClass</code> can be used to specify a particular concrete class for the map keys.  If not specified, and a concrete type cannot be discovered using Java Reflection, <code>java.lang.Object</code> is used. Note that <code>javaKeyClass</code> take precedence over generics if both are used.
     *
     *
     * @return String
     *
     */
    public String getJavaKeyClass()  {
        return getAttributeAsString("javaKeyClass");
    }

    // ********************* Methods ***********************


    // ********************* Static Methods ***********************






    /**
     * Validators to be applied to this field. Validators are applied whenever there is an attempt to save changes to a
     * field.<p>
     * <p/>
     * For the available set of built-in validators, and how to define a custom validator, see the {@link
     * com.smartgwt.client.widgets.form.validator.Validator} class.
     *
     * @param validators the validators
     */
    public void setValidators(Validator... validators) {
        setAttribute("validators", validators);
    }

    /**
     * A valueMap} is a set of legal values for a field. <p> The valueMap can be specified as either an Array of legal
     * values, or as an ${isc.DocUtils.linkForRef('type:Object')} where each property maps a stored value to a
     * user-displayable value. <p> To enforce that a field should be constrained to only the values in the valueMap,
     * either declare {@link com.smartgwt.client.data.DataSourceField#getType type} as "enum", or use an {@link
     * com.smartgwt.client..ValidatorTypes#isOneOf} with explicitly listed values.  Otherwise, although a normal {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem} control will only allow values from the valueMap to be
     * entered, other controls such as a {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem} will allow other
     * values  to be entered. <p> In XML, a valueMap that specifies only a list of legal values is specified as follows:
     * <pre>   &lt;valueMap&gt;    &lt;value&gt;Pens &amp; Pencils&lt;/value&gt;
     * &lt;value&gt;Stationery&lt;/value&gt;    &lt;value&gt;Computer Products&lt;/value&gt;
     * &lt;value&gt;Furniture&lt;/value&gt;    &lt;value&gt;Misc&lt;/value&gt;   &lt;/valueMap&gt; </pre> A ValueMap
     * that specifies stored values mapped to user-visible values is specified as follows: <pre>   &lt;valueMap&gt;
     * &lt;value ID="1"&gt;Pens &amp; Pencils&lt;/value&gt;    &lt;value ID="2"&gt;Stationery&lt;/value&gt;    &lt;value
     * ID="3"&gt;Computer Products&lt;/value&gt;    &lt;value ID="4"&gt;Furniture&lt;/value&gt;    &lt;value
     * ID="5"&gt;Misc&lt;/value&gt;   &lt;/valueMap&gt; </pre>
     *
     * @param valueMap valueMap Default value is null
     */
    public void setValueMap(String... valueMap) {
        setAttribute("valueMap", valueMap);
    }

    /**
     * A valueMap} is a set of legal values for a field. <p> The valueMap can be specified as either an Array of legal
     * values, or as an ${isc.DocUtils.linkForRef('type:Object')} where each property maps a stored value to a
     * user-displayable value. <p> To enforce that a field should be constrained to only the values in the valueMap,
     * either declare {@link com.smartgwt.client.data.DataSourceField#getType type} as "enum", or use an {@link
     * com.smartgwt.client..ValidatorTypes#isOneOf} with explicitly listed values.  Otherwise, although a normal {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem} control will only allow values from the valueMap to be
     * entered, other controls such as a {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem} will allow other
     * values  to be entered. <p> In XML, a valueMap that specifies only a list of legal values is specified as follows:
     * <pre>   &lt;valueMap&gt;    &lt;value&gt;Pens &amp; Pencils&lt;/value&gt;
     * &lt;value&gt;Stationery&lt;/value&gt;    &lt;value&gt;Computer Products&lt;/value&gt;
     * &lt;value&gt;Furniture&lt;/value&gt;    &lt;value&gt;Misc&lt;/value&gt;   &lt;/valueMap&gt; </pre> A ValueMap
     * that specifies stored values mapped to user-visible values is specified as follows: <pre>   &lt;valueMap&gt;
     * &lt;value ID="1"&gt;Pens &amp; Pencils&lt;/value&gt;    &lt;value ID="2"&gt;Stationery&lt;/value&gt;    &lt;value
     * ID="3"&gt;Computer Products&lt;/value&gt;    &lt;value ID="4"&gt;Furniture&lt;/value&gt;    &lt;value
     * ID="5"&gt;Misc&lt;/value&gt;   &lt;/valueMap&gt; </pre>
     *
     * @param valueMap valueMap Default value is null
     */
    public void setValueMap(Map valueMap) {
        setAttribute("valueMap", valueMap);
    }

    /**
     * Sets the default FormItem to be used whenever this field is edited (whether in a grid, form, or other component).
     * <P> If unset, a FormItem will be automatically chosen based on the type of the field, by the rules explained
     * ${isc.DocUtils.linkForRef('type:FormItemType','here')}.
     *
     * @param editorType editorType Default value is null
     */
    public void setEditorType(FormItem editorType) {
        setAttribute("editorType", editorType);
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
     * List of operators valid on this field.   <P> If not specified, all operators that are valid for the field type
     * are allowed.
     *
     * @param validOperators validOperators Default value is null
     */
    public void setValidOperators(OperatorId... operators) {
        setAttribute("validOperators", operators);
    }

    /**
     * Function or JavaScript expression used to retrieve the field's value from the XML element or JSON record returned
     * from a web service. <P> This is an advanced API for use when a {@link com.smartgwt.client.data.DataSourceField#getValueXPath
     * valueXPath} setting is insufficient to derive a field's value, yet an implementation of {@link
     * com.smartgwt.client.data.DataSource#transformResponse} is overkill.
     *
     * @param record    record object selected from web service response data                                      by
     *                  {@link com.smartgwt.client.data.OperationBinding#getRecordXPath recordXPath}
     * @param value     default value derived by the method described in                    {@link
     *                  com.smartgwt.client.data.DataSourceField#getValueXPath valueXPath}
     * @param field     DataSourceField definition
     * @param fieldName name of the DataSource field
     */
    public native void setFieldValueExtractor(FieldValueExtractor extractor) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();

        self.getValueField = function(record, value, field, fieldName) {

        };
    }-*/;

    /**
     * The type can also be the another DataSource, which allows you to model nested structures such as XML documents (in fact, XMLTools.loadXMLSchema()
     * models XML schema in this way). Nested DataSource declarations affect how XML and JSON data is deserialized into JavaScript objects in the
     * client-side integration pipeline, so that you can load complex XML documents and have them deserialized into a correctly typed JavaScript object model.
     *
     * @param dataSource the data source
     */
    public void setType(DataSource dataSource) {
        dataSource.getOrCreateJsObj();
        setAttribute("type", dataSource.getID());
    }


    public void setCanFilter(Boolean canFilter) {
        setAttribute("canFilter", canFilter);
    }


    public Boolean getCanFilter()  {
        return getAttributeAsBoolean("canFilter");
    }

}





