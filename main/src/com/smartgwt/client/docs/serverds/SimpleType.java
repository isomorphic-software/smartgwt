
/*
 * Isomorphic Smart GWT web presentation layer
 * Copyright 2000 and beyond Isomorphic Software, Inc.
 *
 * OWNERSHIP NOTICE
 * Isomorphic Software owns and reserves all rights not expressly granted in this source code,
 * including all intellectual property rights to the structure, sequence, and format of this code
 * and to all designs, interfaces, algorithms, schema, protocols, and inventions expressed herein.
 *
 *  If you have any questions, please email <sourcecode@isomorphic.com>.
 *
 *  This entire comment must accompany any portion of Isomorphic Software source code that is
 *  copied or moved from this file.
 */
/* sgwtgen */
package com.smartgwt.client.docs.serverds;

import com.smartgwt.client.types.*;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.docs.*;
import com.smartgwt.client.callbacks.*;
import com.smartgwt.client.widgets.form.fields.FormItem;
import java.util.List;
import java.util.Map;

/**
 * An atomic type such as a string or number, that is generally stored, displayed and
 *  manipulated as a single value.<p>
 * <b>This class is not meant to be created and used, it is actually documentation of settings
 * allowed in a DataSource descriptor (.ds.xml file), for use with Smart GWT Pro Edition and
 * above.
 * See {@link com.smartgwt.client.docs.serverds} for how to use this documentation.</b>
 * <p>
 *  <P>
 *  SimpleTypes can be created at any time, and subsequently referred to as a 
 * {@link com.smartgwt.client.docs.serverds.DataSourceField#type field type} in {@link
 * com.smartgwt.client.docs.serverds.DataSource DataSources} and
 * {@link com.smartgwt.client.widgets.DataBoundComponent DataBoundComponents}.  This allows you to
 * define
 * {@link com.smartgwt.client.docs.serverds.SimpleType#validators validation}, {@link
 * com.smartgwt.client.data.SimpleType#normalDisplayFormatter formatting}
 * and {@link com.smartgwt.client.docs.serverds.SimpleType#editorType editing} behaviors for a
 * type to be reused across all
 *  {@link com.smartgwt.client.widgets.DataBoundComponent DataBoundComponents}.
 *  <P>
 *  The SimpleType class also allows data to be stored in some opaque format but treated as
 *  simple atomic values as far as Smart GWT components are concerned by implementing
 * {@link com.smartgwt.client.data.SimpleType#getAtomicValue getAtomicValue()} and {@link
 * com.smartgwt.client.data.SimpleType#updateAtomicValue updateAtomicValue()} methods.
 *  For example, if some record has a field value set to a javascript object with the
 *  following properties:
 *  <pre>
 *  { stringValue:"A String", length: 9 }
 *  </pre>
 *  this value could be treated as a simple string by defining a SimpleType with 
 * {@link com.smartgwt.client.docs.serverds.SimpleType#inheritsFrom inheritsFrom} set to
 * <code>"text"</code> and a custom 
 *  <code>getAtomicValue()</code> method that simply extracted the <i>"stringValue"</i>
 *  attribute from the data object. DataBoundComponents would then display
 *  the string value, and use it for sorting and other standard databinding features.
 *  <P>
 *  Note that the term "simpleType" is used in the same sense as in
 *  <a href='XML Schema' target='_blank'>http://www.w3.org/TR/xmlschema-0/</a>, and
 * {@link com.smartgwt.client.data.XMLTools#loadXMLSchema XMLTools.loadXMLSchema()} will create
 * new SimpleType definitions.
 *  <P>
 *  When using the Smart GWT Server, SimpleTypes can be defined server-side, and should
 *  be defined server-side if validators are going to be declared so that the server will
 *  enforce validation. To define server-side SimpleTypes using Component XML you should create
 *  file {typeName}.type.xml in the following format:
 *  <pre>
 *    &lt;SimpleType name="{typeName}" inheritsFrom="{otherSimpleType}" 
 *                   editorType="{FormItemClassName}"&gt;
 *      &lt;validators&gt;
 *        &lt;!-- validator definition just like DataSourceField --&gt;
 *      &lt;/validators&gt;
 *    &lt;/SimpleType&gt;
 *  </pre>
 *  .. and place this file alongside your DataSource files (.ds.xml) files - in any of folders
 * listed in <code>project.datasources</code> property in {@link
 * com.smartgwt.client.docs.Server_properties server.properties}.
 *  <P>
 *  SimpleTypes can be loaded via DataSourceLoader or {@link loadDSTag loadDS JSP tags} and
 *  should be loaded <b>before</b> the definitions of any DataSources that use them (so
 *  generally put all SimpleType definitions first).
 *  <P>
 *  Define validators in the server-side type definition, for example:
 *  <pre>
 *    &lt;SimpleType name="countryCodeType" inheritsFrom="text"&gt;
 *      &lt;validators&gt;
 *        &lt;validator type="lengthRange" min="2" max="2"
 *          errorMessage="Length of country code should be equal to 2." /&gt;
 *        &lt;validator type="regexp" expression="[A-Z][A-Z]"
 *          errorMessage="CountryCode should have only uppercase letters." /&gt;
 *      &lt;/validators&gt;
 *    &lt;/SimpleType&gt;
 *  </pre>
 *  <P>
 *  For client-side formatters, add these to the type definition after loading it from the
 *  server, for example:
 *  
 *  
 *    <pre>
 *      SimpleType.getType("independenceDateType").setShortDisplayFormatter(new SimpleTypeFormatter() {
 *        public String format(Object value, DataClass field, DataBoundComponent component, Record record) {
 *          if (value == null) return null;
 *          return "&lt;i&gt;" + (((java.util.Date) value).getYear() + 1900) + "&lt;/i&gt;";
 *        }
 *      });
 *    </pre>
 *  
 *  Note that formatters must be added to the SimpleType definition <b>before</b> any
 *  DataBoundComponent binds to a DataSource that uses the SimpleType.
 *  <p>
 *  An example is 
 * <a href="http://www.smartclient.com/smartgwt/showcase/#form_type_reuse"
 * target="examples">here</a>.
 */
public class SimpleType {

    /**
     * Name of another SimpleType from which this type should inherit. <P> Validators, if any, will be
     * combined.  All other SimpleType properties default to the inherited type's value.
     *
     * <p>Default value is null
     */
    public Identifier inheritsFrom;

    /**
     * Name of the type, used to refer to the type from {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#type field.type}.
     *
     * <p>Default value is null
     */
    public Identifier name;

    /**
     * Classname of the FormItem that should be used to display values of this type when a field is
     * marked as {@link com.smartgwt.client.docs.serverds.DataSourceField#canEdit canEdit false} and
     * the field is displayed in an editor type component like a DynamicForm. <P> May be overridden by
     * {@link com.smartgwt.client.docs.serverds.DataSourceField#readOnlyEditorType
     * DataSourceField.readOnlyEditorType}.
     *
     * <p>Default value is null
     */
    public FormItem readOnlyEditorType;

    /**
     * Classname of the FormItem that should be used to edit values of this type if it appears in a
     * filter row. <P> May be overridden by {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#filterEditorType
     * DataSourceField.filterEditorType}.
     *
     * <p>Default value is null
     */
    public FormItem filterEditorType;

    /**
     * {@link com.smartgwt.client.docs.FormatString} for numeric or date formatting.  See {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#format DataSourceField.format}.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.ExportFormatting ExportFormatting overview and related methods
     */
    public FormatString format;

    /**
     * Classname of the FormItem that should be the default for editing values of this type (eg
     * "SelectItem"). <P> You can create a simple custom FormItem by adding default {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getIcons FormItem.icons} that launch custom
     * value picking dialogs (an example is in the <i>QuickStart Guide</i>, Chapter 9, <i>Extending
     * Smart GWT</i>).  By setting simpleType.editorType to the name of your custom FormItem, forms
     * will automatically use the custom FormItem, as will grids performing {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanEdit inline editing}.
     *
     * <p>Default value is null
     */
    public FormItem editorType;

    /**
     * Validators to apply to value of this type.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public Validator[] validators;

    /**
     * List of legal values for this type, like {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#valueMap DataSourceField.valueMap}.
     *
     * <p>Default value is null
     */
    public Map valueMap;

}
