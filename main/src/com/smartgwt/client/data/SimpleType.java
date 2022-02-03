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
 * An atomic type such as a string or number, that is generally stored, displayed and
 *  manipulated as a single value.
 *  <P>
 *  SimpleTypes can be created at any time, and subsequently referred to as a 
 * {@link com.smartgwt.client.data.DataSourceField#getType field type} in {@link com.smartgwt.client.data.DataSource
 * DataSources} and
 *  {@link com.smartgwt.client.widgets.DataBoundComponent DataBoundComponents}.  This allows you to define
 * {@link com.smartgwt.client.data.SimpleType#getValidators validation}, {@link
 * com.smartgwt.client.data.SimpleType#normalDisplayFormatter formatting}
 *  and {@link com.smartgwt.client.data.SimpleType#getEditorType editing} behaviors for a type to be reused across all
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
 *  {@link com.smartgwt.client.data.SimpleType#getInheritsFrom inheritsFrom} set to <code>"text"</code> and a custom 
 *  <code>getAtomicValue()</code> method that simply extracted the <i>"stringValue"</i>
 *  attribute from the data object. DataBoundComponents would then display
 *  the string value, and use it for sorting and other standard databinding features.
 *  <P>
 *  Note that the term "simpleType" is used in the same sense as in
 *  <a href='http://www.w3.org/TR/xmlschema-0/' target='_blank'>XML Schema</a>, and
 * {@link com.smartgwt.client.data.XMLTools#loadXMLSchema XMLTools.loadXMLSchema()} will create new SimpleType definitions.
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
 * listed in <code>project.datasources</code> property in {@link com.smartgwt.client.docs.Server_properties
 * server.properties}.
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
 *  <a href="http://www.smartclient.com/smartgwt/showcase/#form_type_reuse" target="examples">here</a>.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("SimpleType")
public class SimpleType extends BaseClass {

    public static SimpleType getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (SimpleType) obj;
        } else {
            return new SimpleType(jsObj);
        }
    }

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        internalSetID(jsObj);
        JSOHelper.setObjectAttribute(jsObj, SC.REF, this);
        JSOHelper.setObjectAttribute(jsObj, SC.MODULE, BeanFactory.getSGWTModule());
        if (!JSOHelper.isScClassInstance(jsObj)) {
            setConfig(jsObj);
            return;
        }
        JSOHelper.setObjectAttribute(getConfig(), SC.REF, this);
        JSOHelper.setObjectAttribute(getConfig(), SC.MODULE, BeanFactory.getSGWTModule());
        setName(JSOHelper.getAttribute(jsObj, "name"));           
        onBind();
    }
        


    public SimpleType(JavaScriptObject jsObj){
        scClassName = "SimpleType";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * Default value for {@link com.smartgwt.client.data.DataSourceField#getCanEdit DataSourceField.canEdit} for fields of this
     * type. <P> This impacts client-side behavior only and is a way to simply disallow  editing of this field type by default
     * within {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit editors}. <P> This property is set to false
     * for the "sequence" SimpleType by default.
     *
     * @param canEdit New canEdit value. Default value is null
     * @return {@link com.smartgwt.client.data.SimpleType SimpleType} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public SimpleType setCanEdit(Boolean canEdit)  throws IllegalStateException {
        return (SimpleType)setAttribute("canEdit", canEdit, false);
    }

    /**
     * Default value for {@link com.smartgwt.client.data.DataSourceField#getCanEdit DataSourceField.canEdit} for fields of this
     * type. <P> This impacts client-side behavior only and is a way to simply disallow  editing of this field type by default
     * within {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit editors}. <P> This property is set to false
     * for the "sequence" SimpleType by default.
     *
     * @return Current canEdit value. Default value is null
     */
    public Boolean getCanEdit()  {
        return getAttributeAsBoolean("canEdit");
    }
    

    /**
     * Default value for {@link com.smartgwt.client.data.DataSourceField#getCanFilter DataSourceField.canFilter} for fields of
     * this type. <P> This impacts client-side behavior only and may be used to explicitly enable editing in filter interfaces,
     * even if {@link com.smartgwt.client.data.SimpleType#getCanEdit editing is disabled}. <P> This property is set to true for
     * the "sequence" SimpleType by default.
     *
     * @param canFilter New canFilter value. Default value is null
     * @return {@link com.smartgwt.client.data.SimpleType SimpleType} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public SimpleType setCanFilter(Boolean canFilter)  throws IllegalStateException {
        return (SimpleType)setAttribute("canFilter", canFilter, false);
    }

    /**
     * Default value for {@link com.smartgwt.client.data.DataSourceField#getCanFilter DataSourceField.canFilter} for fields of
     * this type. <P> This impacts client-side behavior only and may be used to explicitly enable editing in filter interfaces,
     * even if {@link com.smartgwt.client.data.SimpleType#getCanEdit editing is disabled}. <P> This property is set to true for
     * the "sequence" SimpleType by default.
     *
     * @return Current canFilter value. Default value is null
     */
    public Boolean getCanFilter()  {
        return getAttributeAsBoolean("canFilter");
    }
    

    /**
     * In components that support grouping, the default mode from the available  {@link
     * com.smartgwt.client.data.SimpleType#getGroupingModes groupingModes} to use when grouping values of this type.
     *
     * @param defaultGroupingMode New defaultGroupingMode value. Default value is null
     * @return {@link com.smartgwt.client.data.SimpleType SimpleType} instance, for chaining setter calls
     */
    public SimpleType setDefaultGroupingMode(String defaultGroupingMode) {
        return (SimpleType)setAttribute("defaultGroupingMode", defaultGroupingMode, true);
    }

    /**
     * In components that support grouping, the default mode from the available  {@link
     * com.smartgwt.client.data.SimpleType#getGroupingModes groupingModes} to use when grouping values of this type.
     *
     * @return Current defaultGroupingMode value. Default value is null
     */
    public String getDefaultGroupingMode()  {
        return getAttributeAsString("defaultGroupingMode");
    }
    

    /**
     * The default {@link com.smartgwt.client.types.OperatorId search-operator} for this data-type.
     *
     * @param defaultOperator New defaultOperator value. Default value is null
     * @return {@link com.smartgwt.client.data.SimpleType SimpleType} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.AdvancedFilter AdvancedFilter overview and related methods
     */
    public SimpleType setDefaultOperator(OperatorId defaultOperator)  throws IllegalStateException {
        return (SimpleType)setAttribute("defaultOperator", defaultOperator == null ? null : defaultOperator.getValue(), false);
    }

    /**
     * The default {@link com.smartgwt.client.types.OperatorId search-operator} for this data-type.
     *
     * @return Current defaultOperator value. Default value is null
     * @see com.smartgwt.client.docs.AdvancedFilter AdvancedFilter overview and related methods
     */
    public OperatorId getDefaultOperator()  {
        return EnumUtil.getEnum(OperatorId.values(), getAttribute("defaultOperator"));
    }
    
    

    /**
     * {@link com.smartgwt.client.docs.FormatString} used during exports for numeric or date formatting.  See {@link
     * com.smartgwt.client.data.DataSourceField#getExportFormat DataSourceField.exportFormat}.
     *
     * @param exportFormat New exportFormat value. Default value is null
     * @return {@link com.smartgwt.client.data.SimpleType SimpleType} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.FormatString FormatString 
     * @see com.smartgwt.client.docs.ExportFormatting ExportFormatting overview and related methods
     */
    public SimpleType setExportFormat(String exportFormat)  throws IllegalStateException {
        return (SimpleType)setAttribute("exportFormat", exportFormat, false);
    }

    /**
     * {@link com.smartgwt.client.docs.FormatString} used during exports for numeric or date formatting.  See {@link
     * com.smartgwt.client.data.DataSourceField#getExportFormat DataSourceField.exportFormat}.
     *
     * @return Current exportFormat value. Default value is null
     * @see com.smartgwt.client.docs.FormatString FormatString 
     * @see com.smartgwt.client.docs.ExportFormatting ExportFormatting overview and related methods
     */
    public String getExportFormat()  {
        return getAttributeAsString("exportFormat");
    }
    

    /**
     * These are properties that are essentially copied onto any DataSourceField where the property is applied. The supported
     * properties are only client-side properties.
     *
     * @param fieldProperties New fieldProperties value. Default value is null
     * @return {@link com.smartgwt.client.data.SimpleType SimpleType} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public SimpleType setFieldProperties(DataSourceField fieldProperties)  throws IllegalStateException {
        JavaScriptObject config = JSOHelper.createObject();
        if (fieldProperties != null) {
            JSOHelper.addProperties(config, fieldProperties.getJsObj());
        }
        return (SimpleType)setAttribute("fieldProperties", fieldProperties == null ? null : config, false);
    }

    /**
     * These are properties that are essentially copied onto any DataSourceField where the property is applied. The supported
     * properties are only client-side properties.
     *
     * @return Current fieldProperties value. Default value is null
     */
    public DataSourceField getFieldProperties()  {
        return new DataSourceField(getAttributeAsJavaScriptObject("fieldProperties"));
    }
    
    

    /**
     * {@link com.smartgwt.client.docs.FormatString} for numeric or date formatting.  See {@link
     * com.smartgwt.client.data.DataSourceField#getFormat DataSourceField.format}.
     *
     * @param format New format value. Default value is null
     * @return {@link com.smartgwt.client.data.SimpleType SimpleType} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.FormatString FormatString 
     * @see com.smartgwt.client.docs.ExportFormatting ExportFormatting overview and related methods
     */
    public SimpleType setFormat(String format)  throws IllegalStateException {
        return (SimpleType)setAttribute("format", format, false);
    }

    /**
     * {@link com.smartgwt.client.docs.FormatString} for numeric or date formatting.  See {@link
     * com.smartgwt.client.data.DataSourceField#getFormat DataSourceField.format}.
     *
     * @return Current format value. Default value is null
     * @see com.smartgwt.client.docs.FormatString FormatString 
     * @see com.smartgwt.client.docs.ExportFormatting ExportFormatting overview and related methods
     */
    public String getFormat()  {
        return getAttributeAsString("format");
    }
    

    /**
     * A set of key-value pairs that represent the names and titles of the grouping modes  available to values of this type,
     * for use in components that support grouping. <P> Some types provide a set of builtin groupingModes, as covered  {@link
     * com.smartgwt.client.docs.BuiltinGroupingModes here}. <P> Use {@link
     * com.smartgwt.client.data.SimpleType#setGroupValueFunction setGroupValueFunction()} and {@link
     * com.smartgwt.client.data.SimpleType#setGroupTitleFunction setGroupTitleFunction()} to implement custom grouping logic
     * for each of the grouping modes you provide.
     *
     * @param groupingModes New groupingModes value. Default value is null
     * @return {@link com.smartgwt.client.data.SimpleType SimpleType} instance, for chaining setter calls
     */
    public SimpleType setGroupingModes(Map groupingModes) {
        return (SimpleType)setAttribute("groupingModes", groupingModes, true);
    }

    /**
     * A set of key-value pairs that represent the names and titles of the grouping modes  available to values of this type,
     * for use in components that support grouping. <P> Some types provide a set of builtin groupingModes, as covered  {@link
     * com.smartgwt.client.docs.BuiltinGroupingModes here}. <P> Use {@link
     * com.smartgwt.client.data.SimpleType#setGroupValueFunction setGroupValueFunction()} and {@link
     * com.smartgwt.client.data.SimpleType#setGroupTitleFunction setGroupTitleFunction()} to implement custom grouping logic
     * for each of the grouping modes you provide.
     *
     * @return Returns the set of {@link com.smartgwt.client.data.SimpleType#getGroupingModes grouping modes} available for values  of
     * this type in components that support grouping. Default value is null
     */
    public Map getGroupingModes()  {
        return getAttributeAsMap("groupingModes");
    }
    

    /**
     * Name of another SimpleType from which this type should inherit. <P> Validators, if any, will be combined.  All other
     * SimpleType properties default to the inherited type's value.
     *
     * @param inheritsFrom New inheritsFrom value. Default value is null
     * @return {@link com.smartgwt.client.data.SimpleType SimpleType} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.Identifier Identifier 
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_type_reuse" target="examples">DataType Reuse Example</a>
     */
    public SimpleType setInheritsFrom(String inheritsFrom)  throws IllegalStateException {
        return (SimpleType)setAttribute("inheritsFrom", inheritsFrom, false);
    }

    /**
     * Name of another SimpleType from which this type should inherit. <P> Validators, if any, will be combined.  All other
     * SimpleType properties default to the inherited type's value.
     *
     * @return Current inheritsFrom value. Default value is null
     * @see com.smartgwt.client.docs.Identifier Identifier 
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_type_reuse" target="examples">DataType Reuse Example</a>
     */
    public String getInheritsFrom()  {
        return getAttributeAsString("inheritsFrom");
    }
    

    /**
     * Name of the type, used to refer to the type from {@link com.smartgwt.client.data.DataSourceField#getType field.type}.
     *
     * @param name New name value. Default value is null
     * @return {@link com.smartgwt.client.data.SimpleType SimpleType} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.Identifier Identifier 
     */
    public SimpleType setName(String name)  throws IllegalStateException {
        return (SimpleType)setAttribute("name", name, false);
    }

    /**
     * Name of the type, used to refer to the type from {@link com.smartgwt.client.data.DataSourceField#getType field.type}.
     *
     * @return Current name value. Default value is null
     * @see com.smartgwt.client.docs.Identifier Identifier 
     */
    public String getName()  {
        return getAttributeAsString("name");
    }
    

    /**
     * Default {@link com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyDisplay readOnlyDisplay} for fields of this
     * type. <P> For more sophisticated management of read-only behavior, see {@link
     * com.smartgwt.client.data.SimpleType#getReadOnlyEditorType readOnlyEditorType}.
     *
     * @param readOnlyDisplay New readOnlyDisplay value. Default value is null
     * @return {@link com.smartgwt.client.data.SimpleType SimpleType} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public SimpleType setReadOnlyDisplay(ReadOnlyDisplayAppearance readOnlyDisplay)  throws IllegalStateException {
        return (SimpleType)setAttribute("readOnlyDisplay", readOnlyDisplay == null ? null : readOnlyDisplay.getValue(), false);
    }

    /**
     * Default {@link com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyDisplay readOnlyDisplay} for fields of this
     * type. <P> For more sophisticated management of read-only behavior, see {@link
     * com.smartgwt.client.data.SimpleType#getReadOnlyEditorType readOnlyEditorType}.
     *
     * @return Current readOnlyDisplay value. Default value is null
     */
    public ReadOnlyDisplayAppearance getReadOnlyDisplay()  {
        return EnumUtil.getEnum(ReadOnlyDisplayAppearance.values(), getAttribute("readOnlyDisplay"));
    }
    
    

    /**
     * Validators to apply to value of this type.
     *
     * @param validators New validators value. Default value is null
     * @return {@link com.smartgwt.client.data.SimpleType SimpleType} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public SimpleType setValidators(Validator... validators)  throws IllegalStateException {
        return (SimpleType)setAttribute("validators", validators, false);
    }
    

    /**
     * Set of {@link com.smartgwt.client.types.OperatorId search-operators} valid for this <code>SimpleType</code>.   <P> If
     * not specified, the {@link com.smartgwt.client.data.SimpleType#getInheritsFrom inherited} type's operators will be used,
     * finally defaulting to the default operators for the basic types (eg, integer).
     *
     * @param validOperators New validOperators value. Default value is null
     * @return {@link com.smartgwt.client.data.SimpleType SimpleType} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.AdvancedFilter AdvancedFilter overview and related methods
     */
    public SimpleType setValidOperators(OperatorId... validOperators)  throws IllegalStateException {
        return (SimpleType)setAttribute("validOperators", validOperators, false);
    }
    
    

    // ********************* Methods ***********************
	/**
     * Returns a string value appropriate for the title of the group containing the passed value.
     * @param value the record value to return a group title for
     * @param record the record containing the passed group value
     * @param field the field relating to the value to be processed
     * @param fieldName the name of the field relating to the value to be processed
     * @param component the component, usually a {@link com.smartgwt.client.widgets.grid.ListGrid}, containing the                           
     * passed record
     *
     * @return the group title for the passed parameters
     */
    public native String getGroupTitle(Object value, Record record, Map field, String fieldName, Canvas component) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getGroupTitle", "Object,Record,Map,String,Canvas");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getGroupTitle(value, record.@com.smartgwt.client.core.DataClass::getJsObj()(), field == null ? null : @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(field), fieldName, component == null ? null : component.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        return ret;
    }-*/;

	/**
     * Returns a group value appropriate for the passed record, field and value, in the passed  component.
     * @param value the record value to return a group value for
     * @param record the record containing the passed value
     * @param field the field relating to the value to be processed
     * @param fieldName the name of the field relating to the value to be processed
     * @param component the component, usually a {@link com.smartgwt.client.widgets.grid.ListGrid}, containing the                          
     * passed record
     *
     * @return the group value for the passed parameters
     */
    public native Object getGroupValue(Object value, Record record, Map field, String fieldName, Canvas component) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getGroupValue", "Object,Record,Map,String,Canvas");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getGroupValue(value, record.@com.smartgwt.client.core.DataClass::getJsObj()(), field == null ? null : @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(field), fieldName, component == null ? null : component.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        return $wnd.SmartGWT.convertToJavaType(ret);
    }-*/;


    // ********************* Static Methods ***********************



	/**
     * Retrieve a simpleType definition by type name
     * @param typeName the <code>name</code> of the simpleType to return
     *
     * @return simple type object
     */
    public static native SimpleType getType(String typeName) /*-{
        var ret = $wnd.isc.SimpleType.getType(typeName);
        if(ret == null) return null;
        return @com.smartgwt.client.data.SimpleType::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;




    // ***********************************************************



    /**
     * Create a new simple type.
     *
     * @param name the name of the simple type
     * @param inheritsFrom the type it inherits from
     */
    public SimpleType() {
        scClassName = "SimpleType";
    }

    /**
     * Create a new simple type.
     *
     * @param name the name of the simple type
     * @param inheritsFrom the type it inherits from
     */
    public SimpleType(String name, FieldType inheritsFrom) {
        scClassName = "SimpleType";
        setName(name);
        setInheritsFrom(inheritsFrom);
    }

    /**
     * Create a new simple type.
     *
     * @param name the name of the simple type
     * @param inheritsFrom the type it inherits from
     */
    public SimpleType(String name, SimpleType inheritsFrom) {
        scClassName = "SimpleType";
        setName(name);
        //ensure the type being inherited from is registered
        inheritsFrom.getOrCreateJsObj();
        setAttribute("inheritsFrom", inheritsFrom.getName(), true);
    }

    /**
     * Explicitly register this SimpleType with the system so that it can be used / referenced by remote DataSources.
     */
    public void register() {
        getOrCreateJsObj();
    }

    /**
     * List of legal values for this type, like {@link com.smartgwt.client.data.DataSourceField#getValueMap valueMap}.
     *
     * @param valueMap valueMap Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setValueMap(String... valueMap) throws IllegalStateException {
        setAttribute("valueMap", valueMap, false);
    }

    /**
     * List of legal values for this type, like {@link com.smartgwt.client.data.DataSourceField#getValueMap valueMap}.
     *
     * @param valueMap valueMap Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setValueMap(Map valueMap) throws IllegalStateException {
        setAttribute("valueMap", valueMap, false);
    }

    /**
     * Default {@link FormItem} configuration for editing values of this type.
     * <P>
     * You can create a simple custom FormItem by adding default
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#setIcons icons}
     *  that launch custom value picking dialogs (an example is in the <i>QuickStart Guide</i>, Chapter 9,
     * <i>Extending Smart GWT</i>).
     * By setting simpleType.editorProperties to an instance of your custom FormItem, forms will
     * automatically use the custom FormItem, as will grids performing
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getCanEdit grid editing}.
     * <p>
     * <b>Note</b>: When you supply a custom FormItem via setEditorProperties(), you're really providing properties which are then used to create
     * multiple FormItems (e.g., in grids, forms and trees) and there's an underlying limitation here where event handlers have to be written to
     * dynamically receive the actual FormItem rather than relying on "this" (because there's more than one "this").
     * This means you need to follow the special rules indicated for 
     * {@link com.smartgwt.client.data.DataSourceField#setEditorProperties(FormItem)}. 
     * As an alternative, you can use {@link #setEditorType(String)} or
     * {@link #setEditorType(Class)} to avoid these limitations, if you register
     * the FormItem subclass with the {@link com.smartgwt.client.docs.Reflection reflection mechanism}.
     *
     * @param editorProperties FormItem with default properties to use when editing
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setEditorProperties(FormItem editorProperties) throws IllegalStateException {
        if (editorProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), "setEditorProperties",
                                                    "FormItem");
        }                                                                       
        editorProperties.setConfigOnly(true);

        // only set the editorType attribute if the passed editorType is a concrete subclass of FormItem
        if (editorProperties.getClass() != FormItem.class) {
            String fiEditorType = editorProperties.getAttribute("editorType");
            // fallback to type if editorType is not specified
            if (fiEditorType == null) fiEditorType = editorProperties.getType();
            if (fiEditorType != null) setAttribute("editorType", fiEditorType, false);
        }
        JavaScriptObject editorConfig = editorProperties.getConfig();
        setAttribute("editorProperties", editorConfig, false);
    }

    /**
     * Synonym for {@link #setEditorProperties(FormItem)}.
     *
     * @param editorType FormItem with default properties to be applied when editing
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @deprecated Renamed to {@link #setEditorProperties(FormItem)}. You can also consider using 
     *             {@link #setEditorType(Class)} or {@link #setEditorType(String)} instead.
     */
    public void setEditorType(FormItem editorType) throws IllegalStateException {
        setEditorProperties(editorType);
    }
    
    /**
     * Set the default {@link FormItem} class to be used whenever a value of this type is edited
     * (whether in a grid, form, or other component).
     * <p>
     * If unset, a FormItem will be automatically chosen.
     * <p>
     * <b>Note</b>: The editorType must be registered for use with the
     * {@link com.smartgwt.client.docs.Reflection reflection mechanism}. 
     * By doing so, you avoid the limitations of {@link #setEditorProperties(FormItem)}.
     *
     * @param editorType the fully-qualified class name of a {@link com.smartgwt.client.widgets.form.fields.FormItem}
     *                   subclass, which must have been registered with the 
     *                   {@link com.smartgwt.client.docs.Reflection reflection mechanism}. 
     * @throws IllegalArgumentException if the editorType class has not been registered for use with the 
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
        setAttribute("editorType", editorType, false);
    }
    
    /**
     * Set the default {@link FormItem} class to be used whenever a value of this type is edited
     * (whether in a grid, form, or other component).
     * <p>
     * If unset, a FormItem will be automatically chosen.
     * <p>
     * <b>Note</b>: The editorType must be registered for use with the
     * {@link com.smartgwt.client.docs.Reflection reflection mechanism}. 
     * By doing so, you avoid the limitations of {@link #setEditorProperties(FormItem)}.
     *
     * @param editorType a {@link com.smartgwt.client.widgets.form.fields.FormItem}
     *                   subclass, which must have been registered with the 
     *                   {@link com.smartgwt.client.docs.Reflection reflection mechanism}. 
     * @throws IllegalArgumentException if the editorType class has not been registered for use with the 
     *                                  {@link com.smartgwt.client.docs.Reflection reflection mechanism},
     *                                  or if it does not inherit from 
     *                                  {@link com.smartgwt.client.widgets.form.fields.FormItem}.
    **/
    public void setEditorType(Class<? extends FormItem> editorType) {
        setEditorType(editorType.getName());
    }

    /**
     * FormItem properties to be applied when editing values of this type in a read-only context.
     * <p>
     * <b>Note</b>: The FormItem passed to setReadOnlyEditorProperties() is used as a "template" to create a FormItem whenever
     * a {@link com.smartgwt.client.widgets.DataBoundComponent} needs to show an interface for editing this 
     * field (and the field is marked read-only). This means you need to follow special rules indicated
     * for {@link com.smartgwt.client.data.DataSourceField#setEditorProperties(FormItem)}. 
     * As an alternative, you can use {@link #setReadOnlyEditorType(String)} or
     * {@link #setReadOnlyEditorType(Class)} to avoid these limitations, if you register
     * the FormItem subclass with the {@link com.smartgwt.client.docs.Reflection reflection mechanism}.
     *
     * @param editorProperties FormItem with properties to be applied when editing values of this type in a read-only context.
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setReadOnlyEditorProperties(FormItem editorProperties) throws IllegalStateException {
        if (editorProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), "setReadOnlyEditorProperties",
                                                    "FormItem");
        }                                                                       
        editorProperties.setConfigOnly(true);

        // only set the editorType attribute if the passed editorType is a concrete subclass of FormItem
        if (editorProperties.getClass() != FormItem.class) {
            String fiEditorType = editorProperties.getAttribute("editorType");
            // fallback to type if editorType is not specified
            if (fiEditorType == null) fiEditorType = editorProperties.getType();
            if (fiEditorType != null) setAttribute("readOnlyEditorType", fiEditorType, false);
        }
        JavaScriptObject editorConfig = editorProperties.getConfig();
        setAttribute("readOnlyEditorProperties", editorConfig, false);
    }

    /**
     * Synonym for {@link #setReadOnlyEditorProperties(FormItem)}.
     *
     * @param editorType FormItem with default properties to be applied when editing
     * @deprecated Renamed to {@link #setReadOnlyEditorProperties(FormItem)}. You can also consider using 
     *             {@link #setReadOnlyEditorType(Class)} or {@link #setReadOnlyEditorType(String)} instead.
     */
    public void setReadOnlyEditorType(FormItem editorType) {
        setReadOnlyEditorProperties(editorType);
    }
    
    /**
     * Set the default {@link FormItem} class to be used whenever a value of this type is edited
     * in a read-only context (whether in a grid, form, or other component).
     * <p>
     * If unset, a FormItem will be automatically chosen.
     * <p>
     * By using the {@link com.smartgwt.client.docs.Reflection reflection mechanism}, 
     * this method avoids the limitations described in {@link #setReadOnlyEditorProperties(FormItem)}.
     * 
     * @param editorType the fully-qualified class name of a {@link com.smartgwt.client.widgets.form.fields.FormItem}
     *                   subclass, which must have been registered with the 
     *                   {@link com.smartgwt.client.docs.Reflection reflection mechanism}. 
     * @throws IllegalArgumentException if the editorType class has not been registered for use with the 
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
        setAttribute("readOnlyEditorType", editorType, false);
    }

    /**
     * Set the default {@link FormItem} class to be used whenever a value of this type is edited
     * in a read-only context (whether in a grid, form, or other component).
     * <p>
     * If unset, a FormItem will be automatically chosen.
     * <p>
     * By using the {@link com.smartgwt.client.docs.Reflection reflection mechanism}, 
     * this method avoids the limitations described in {@link #setReadOnlyEditorProperties(FormItem)}.
     *
     * @param editorType a {@link com.smartgwt.client.widgets.form.fields.FormItem}
     *                   subclass, which must have been registered with the 
     *                   {@link com.smartgwt.client.docs.Reflection reflection mechanism}. 
     * @throws IllegalArgumentException if the editorType class has not been registered for use with the 
     *                                  {@link com.smartgwt.client.docs.Reflection reflection mechanism},
     *                                  or if it does not inherit from 
     *                                  {@link com.smartgwt.client.widgets.form.fields.FormItem}.
    **/
    public void setReadOnlyEditorType(Class<? extends FormItem> editorType) {
        setReadOnlyEditorType(editorType.getName());
    }

    /**
     * Default {@link FormItem} configuration for editing values of this type in a
     * {@link com.smartgwt.client.widgets.grid.ListGrid} filter row or 
     * {@link com.smartgwt.client.widgets.form.SearchForm}.
     * <P>
     * You can create a simple custom FormItem by adding default
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#setIcons icons}
     *  that launch custom value picking dialogs (an example is in the <i>QuickStart Guide</i>,
     * Chapter 9, <i>Extending Smart GWT</i>).
     * By setting <code>filterEditorProperties</code> to an instance of your custom FormItem,
     * filter rows or search forms will automatically use the custom FormItem.
     * <p><b>Note</b>: 
     * When you supply a custom FormItem via <code>setFilterEditorProperties()</code>,
     * you're really providing properties which are then used to create
     * multiple FormItems (e.g., in grids, forms and trees) and there's an underlying limitation
     * here where event handlers have to be written to dynamically receive the actual FormItem
     * rather than relying on "this" (because there's more than one "this").
     * This means you need to follow the special rules indicated for 
     * {@link com.smartgwt.client.data.DataSourceField#setEditorProperties(FormItem)}. 
     * As an alternative, you can use {@link #setFilterEditorType(String)} or
     * {@link #setFilterEditorType(Class)} to avoid these limitations, if you register the
     * FormItem subclass with the 
     * {@link com.smartgwt.client.docs.Reflection reflection mechanism}.
     *
     * @param filterEditorProperties FormItem with default properties to use when editing
     * @throws IllegalStateException this property cannot be changed after the underlying 
     * component has been created
     */
    public void setFilterEditorProperties(FormItem filterEditorProperties) 
        throws IllegalStateException 
    {
        if (filterEditorProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), "setFilterEditorProperties",
                                                    "FormItem");
        }                                                                       
        filterEditorProperties.setConfigOnly(true);

        // only set the filterEditorType attribute if the passed editorType is a
        // concrete subclass of FormItem
        if (filterEditorProperties.getClass() != FormItem.class) {
            String fiEditorType = filterEditorProperties.getAttribute("filterEditorType");
            // fallback to type if editorType is not specified
            if (fiEditorType == null) fiEditorType = filterEditorProperties.getType();
            if (fiEditorType != null) setAttribute("filterEditorType", fiEditorType, false);
        }
        JavaScriptObject editorConfig = filterEditorProperties.getConfig();
        setAttribute("filterEditorProperties", editorConfig, false);
    }

    /**
     * Set the default {@link FormItem} class to be used whenever a value of this type appears
     * in a {@link com.smartgwt.client.widgets.grid.ListGrid} filter row or 
     * {@link com.smartgwt.client.widgets.form.SearchForm}.
     * <p>
     * If unset, a FormItem will be automatically chosen.
     * <p>
     * <b>Note</b>: The filterEditorType must be registered for use with the
     * {@link com.smartgwt.client.docs.Reflection reflection mechanism}. 
     * By doing so, you avoid the limitations of {@link #setFilterEditorProperties(FormItem)}.
     *
     * @param filterEditorType the fully-qualified class name of a
     *     {@link com.smartgwt.client.widgets.form.fields.FormItem} subclass, which must have 
     *     been registered with the {@link com.smartgwt.client.docs.Reflection reflection mechanism}.
     * @throws IllegalArgumentException if the filterEditorType class has not been registered
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
        setAttribute("filterEditorType", filterEditorType, false);
    }

    /**
     * Set the default {@link FormItem} class to be used whenever a value of this type appears
     * in a {@link com.smartgwt.client.widgets.grid.ListGrid} filter row or 
     * {@link com.smartgwt.client.widgets.form.SearchForm}.
     * <p>
     * If unset, a FormItem will be automatically chosen.
     * <p>
     * <b>Note</b>: The filterEditorType must be registered for use with the
     * {@link com.smartgwt.client.docs.Reflection reflection mechanism}. 
     * By doing so, you avoid the limitations of {@link #setFilterEditorProperties(FormItem)}.
     *
     * @param filterEditorType a {@link com.smartgwt.client.widgets.form.fields.FormItem}
     *     subclass, which must have been registered with the 
     *     {@link com.smartgwt.client.docs.Reflection reflection mechanism}. 
     * @throws IllegalArgumentException if the filterEditorType class has not been registered
     *     for use with the {@link com.smartgwt.client.docs.Reflection reflection mechanism},
     *     or if it does not inherit from {@link com.smartgwt.client.widgets.form.fields.FormItem}.
     **/
    public void setFilterEditorType(Class<? extends FormItem> filterEditorType) {
        setFilterEditorType(filterEditorType.getName());
    }

    /**
     * Name of another SimpleType from which this type should inherit. <P> Validators, if any, will be combined.  All other
     * SimpleType properties default to the inherited type's value.
     *
     * @param inheritsFrom inheritsFrom Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setInheritsFrom(FieldType inheritsFrom)  throws IllegalStateException {
        setAttribute("inheritsFrom", inheritsFrom.getValue(), false);
    }

    /**
     * Normal formatter for values of this type used in a {@link com.smartgwt.client.widgets.form.fields.StaticTextItem} or {@link com.smartgwt.client.widgets.viewer.DetailViewer}.
     * <p>
     * A formatter can make itself configurable on a per-component or per-field basis by checking properties on the component or field. For example, a formatter for account IDs may want
     * to omit a prefix in views where it is redundant, and could check a flag detailViewer.omitAccountIdPrefix for this purpose.
     *
     * @param formatter the formatter
     */
    public native void setNormalDisplayFormatter(SimpleTypeFormatter formatter)/*-{
        var self = this.@com.smartgwt.client.core.BaseClass::isCreated()() ? this.@com.smartgwt.client.core.BaseClass::getJsObj()() : this.@com.smartgwt.client.core.BaseClass::getConfig()();
        self.normalDisplayFormatter = $debox($entry(function(value, field, component, record) {
            var valueJ = $wnd.SmartGWT.convertToJavaType(value);
            var fieldJ = @com.smartgwt.client.data.SimpleType::toDataClass(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(field,component);
            var componentJ = component == null ? null : @com.smartgwt.client.widgets.Canvas::getOrCreateDBC(Lcom/google/gwt/core/client/JavaScriptObject;)(component);
            var recordJ = record == null ? null : @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            return formatter.@com.smartgwt.client.data.SimpleTypeFormatter::format(Ljava/lang/Object;Lcom/smartgwt/client/core/DataClass;Lcom/smartgwt/client/widgets/DataBoundComponent;Lcom/smartgwt/client/data/Record;)(valueJ, fieldJ, componentJ, recordJ);
        }));
    }-*/;

    /**
     * Formatter for values of this type when compact display is required, for example, in a {@link com.smartgwt.client.widgets.grid.ListGrid} or
     * {@link com.smartgwt.client.widgets.tree.TreeGrid}.
     * <p>
     * A formatter can make itself configurable on a per-component or per-field basis by checking properties on the component or field.
     * For example, a formatter for account IDs may want to omit a prefix in views where it is redundant, and could check a flag listGridField.omitAccountIdPrefix for this purpose.
     *
     * @param formatter the formatter
     */
    public native void setShortDisplayFormatter(SimpleTypeFormatter formatter)/*-{
        var self = this.@com.smartgwt.client.core.BaseClass::isCreated()() ? this.@com.smartgwt.client.core.BaseClass::getJsObj()() : this.@com.smartgwt.client.core.BaseClass::getConfig()();
        self.shortDisplayFormatter = $debox($entry(function(value, field, component, record) {
            var valueJ = $wnd.SmartGWT.convertToJavaType(value);
            var fieldJ = @com.smartgwt.client.data.SimpleType::toDataClass(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(field,component);
            var componentJ = component == null ? null : @com.smartgwt.client.widgets.Canvas::getOrCreateDBC(Lcom/google/gwt/core/client/JavaScriptObject;)(component);
            var recordJ = record == null ? null : @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            return formatter.@com.smartgwt.client.data.SimpleTypeFormatter::format(Ljava/lang/Object;Lcom/smartgwt/client/core/DataClass;Lcom/smartgwt/client/widgets/DataBoundComponent;Lcom/smartgwt/client/data/Record;)(valueJ, fieldJ, componentJ, recordJ);
        }));
    }-*/;

    /**
     * Formatter for values of this type when displayed in a freeform text editor such as a
     * {@link com.smartgwt.client.widgets.form.fields.TextItem}
     * <P>
     * See also {@link #parseInput} for parsing an edited text value back to a data value.
     * @param formatter the formatter
     */
    public native void setEditFormatter(SimpleTypeFormatter formatter)/*-{
        var self = this.@com.smartgwt.client.core.BaseClass::isCreated()() ? this.@com.smartgwt.client.core.BaseClass::getJsObj()() : this.@com.smartgwt.client.core.BaseClass::getConfig()();
        self.editFormatter = $debox($entry(function(value, field, component, record) {
            var valueJ = $wnd.SmartGWT.convertToJavaType(value);
            var fieldJ = @com.smartgwt.client.data.SimpleType::toDataClass(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(field,component);
            var componentJ = component == null ? null : @com.smartgwt.client.widgets.Canvas::getOrCreateDBC(Lcom/google/gwt/core/client/JavaScriptObject;)(component);
            var recordJ = record == null ? null : @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            return formatter.@com.smartgwt.client.data.SimpleTypeFormatter::format(Ljava/lang/Object;Lcom/smartgwt/client/core/DataClass;Lcom/smartgwt/client/widgets/DataBoundComponent;Lcom/smartgwt/client/data/Record;)(valueJ, fieldJ, componentJ, recordJ);
        }));
    }-*/;

    /**
     * Specify a parser to convert some user-edited value to an underlying data value of this type.
     * This parser is called when storing out values edited in a freeform editor such as
     * a {@link com.smartgwt.client.widgets.form.fields.TextItem}.
     * Typically this will convert from the format produced by {@link #editFormatter}
     * back to a data value.
     * @param parser the parser
     */
    public native void setEditParser(SimpleTypeParser parser) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::isCreated()() ? this.@com.smartgwt.client.core.BaseClass::getJsObj()() : this.@com.smartgwt.client.core.BaseClass::getConfig()();
        self.parseInput = $debox($entry(function(value, field, component, record) {
            var fieldJ = @com.smartgwt.client.data.SimpleType::toDataClass(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(field,component);
            var componentJ = component == null ? null : @com.smartgwt.client.widgets.Canvas::getOrCreateDBC(Lcom/google/gwt/core/client/JavaScriptObject;)(component);
            var recordJ = record == null ? null : @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            var val = parser.@com.smartgwt.client.data.SimpleTypeParser::parseInput(Ljava/lang/String;Lcom/smartgwt/client/core/DataClass;Lcom/smartgwt/client/widgets/DataBoundComponent;Lcom/smartgwt/client/data/Record;)(value, fieldJ, componentJ, recordJ);
            return $wnd.SmartGWT.convertToPrimitiveType(val);
        }));
    }-*/;

    public static abstract class SimpleTypeValueExtractor {
        /**
         * Method to extract an atomic value (such as a string or number) from some arbitrary live data value.
         * This method will be called for every field value of the specified type in order to convert from the raw
         * data value to an atomic type to be used for standard DataBinding features such as sorting and editing.
         * @param value Raw data value to convert. Typically this would be a field value for some record.
         * @return Atomic value. This should match the underlying atomic type specified by the {@link #inheritsFrom} attribute.
         */
        public abstract Object getAtomicValue(Object value);
		
        /**
         * Method to extract an atomic value (such as a string or number) from some arbitrary live data value.
         * This method will be called for every field value of the specified type in order to convert from the raw
         * data value to an atomic type to be used for standard DataBinding features such as sorting and editing.
         * Note, you only need to override this method if you have a need for the additional context provided by
         * the "reason" attribute.  The default implementation just ignores the reason and calls the single-param
         * version of getAtomicValue().<p>
         * Your method can use the "reason" parameter to affect the atomic value that is returned. - for example,
         * if the reason is "sort" you could return the atomic value converted to upper-case, to impose 
         * case-insensitive sorting.  Reason strings used by the system are:<ul>
         * <li>"edit" Retrieving the edit value of the field in a +link{class:DynamicForm} or 
         *               +link{class:ListGrid}/li>
         * <li>"format" Retrieving the value to format it for display/li>
         * <li>"filter" Retrieving the value for use in a filter comparison/li>
         * <li>"sort" Retrieving the value for use in a sort comparison/li>
         * <li>"group" Retrieving the value for use in a group comparison/li>
         * <li>"formula" Retrieving the value for use in a formula calculation/li>
         * <li>"vm_getValue" Retrieving the value from +link{valuesManager.getValue()}/li>
         * <li>"validate" Retrieving the value for validation, or setting the value if validation
         *                   caused it to change/li>
         * <li>"compare" Retrieving the "old" or "new" value from +link{ListGrid.cellHasChanges()}/li>
         * <li>"getRawValue" Retrieving the raw value of a +link{class:ListGrid} cell/li>
         * <li>"criteria" Setting the value from +link{DynamicForm.setValuesAsCriteria()}/li>
         * <li>"updateValue" Setting the value from internal methods of +link{class:DynamicForm} 
         *                      or +link{class:ValuesManager} /li>
         * <li>"setRawValue" Setting the raw value of a +link{class:ListGrid} cell/li>
         * <li>"saveLocally" Setting the value from +link{ListGrid.saveLocally()}</li>
         * </ul>
         * @param value Raw data value to convert. Typically this would be a field value for some record.
         * @param reason A reason passed by the framework to indicate why it is asking for the atomic value.
         * @return Atomic value. This should match the underlying atomic type specified by the {@link #inheritsFrom} attribute.
         */
        public Object getAtomicValue(Object value, String reason) {
            return getAtomicValue(value);
        }
    }
    
    /**
     * Tells the atomic values subsystem whether to skip conversion of the incoming opaque value to a Java object when 
     * calling user getAtomicValue() and updateAtomicValue() methods.  By default, we do convert the opaque value, and 
     * your methods will be passed a Java object - typically a Map of native Java types.  Passing true to this method 
     * switches off conversion, and your methods will be passed a JavaScriptObject
     * @param convert Whether the atomic values subsystem should skip conversion of opaque values to native Java types
     */
    public static void setSkipConvertOpaqueValues(Boolean convert) {
        _setSkipConvertOpaqueValues(Boolean.TRUE.equals(convert));
    }
    private static native void _setSkipConvertOpaqueValues(boolean convert) /*-{
        $wnd.isc.SimpleType._skipConvertOpaqueValues = convert;
    }-*/;
    /**
     * Tells the atomic values subsystem whether to convert the incoming opaque value to a Java object when calling user
     * getAtomicValue() and updateAtomicValue() methods.  By default, we do convert the opaque value, and your methods
     * will be passed a Java object - typically a Map of native Java types.  Passing false to this mehtod switches off 
     * conversion, and your methods will be passed a JavaScriptObject
     * @return Boolean indicating whether the atomic values subsystem will convert opaque values to native Java types
     */
    public static Boolean getSkipConvertOpaqueValues() {
        return _getSkipConvertOpaqueValues();
    }
    private static native Boolean _getSkipConvertOpaqueValues() /*-{
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)($wnd.isc.SimpleType._skipConvertOpaqueValues);
    }-*/;

    /**
     * Specify an extractor to extract an atomic value (such as a string or number) from some arbitrary live data value.
     * If defined this method will be called for every field value of the specified type in order to convert from the raw
     * data value to an atomic type to be used for standard DataBinding features such as sorting and editing.
     * @param extractor the extractor
     */
    public native void setSimpleTypeValueExtractor(SimpleTypeValueExtractor extractor) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::isCreated()() ? this.@com.smartgwt.client.core.BaseClass::getJsObj()() : this.@com.smartgwt.client.core.BaseClass::getConfig()();
        self.getAtomicValue = $debox($entry(function(value, reason) {
            var valueJ = $wnd.isc.SimpleType._skipConvertOpaqueValues ? value :
                                    $wnd.SmartGWT.convertToJavaObject(value);
            var reasonJ = reason;
            var val = extractor.@com.smartgwt.client.data.SimpleType.SimpleTypeValueExtractor::getAtomicValue(Ljava/lang/Object;Ljava/lang/String;)(valueJ, reasonJ);
            return $wnd.SmartGWT.convertToPrimitiveType(val);
        }));
    }-*/;


    public static abstract class SimpleTypeValueUpdater {
        /**
         * Method to update a live data value with an edited atomic value (such as a string or number).
         * This method will be called when the user edits data in a field of this type, allowing the developer to convert
         * from the atomic type to a raw data value for storage.
         * @param atomicValue (any) New atomic value. This should match the underlying atomic type
         * specified by the {@link #inheritsFrom} attribute.
         * @param currentValue Existing data value to be updated.
         * @return (any) Updated data value.
         */
        public abstract Object updateAtomicValue(Object atomicValue, Object currentValue);
		
        /**
         * Method to uodate a live data value with an edited atomic value atomic value (such as a string or number).
         * This method will be called when the user edits data in a field of this type, allowing the developer to convert
         * from the atomic type to a raw data value for storage.
         * Note, you only need to override this method if you have a need for the additional context provided by
         * the "reason" attribute.  The default implementation just ignores the reason and calls the two-param
         * version of updateAtomicValue().
         * @param atomicValue (any) New atomic value. This should match the underlying atomic type
         * specified by the {@link #inheritsFrom} attribute.
         * @param value Raw data value to convert. Typically this would be a field value for some record.
         * @param reason A string passed by the framework to indicate why it is updating the atomic value.  See
         * {@link com.smartgwt.client.data.SimpleType.SimpleTypeValueExtractor#getAtomicValue(java.lang.Object, java.lang.String)}
         * for details of the reason strings used by the framework
         * @return Updated data value
         */
        public Object updateAtomicValue(Object atomicValue, Object currentValue, String reason) {
            return updateAtomicValue(atomicValue, currentValue);
        }
    }

    /**
     * Specify an updater to update a live data value with an edited atomic value (such as a string or number).
     * If defined this updater's updateAtomicValue method will be called when the user edits data in a field of this type,
     * allowing the developer to convert from the atomic type to a raw data value for storage.
     * @param extractor the updater
     */
    public native void setSimpleTypeValueUpdater(SimpleTypeValueUpdater updater) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::isCreated()() ? this.@com.smartgwt.client.core.BaseClass::getJsObj()() : this.@com.smartgwt.client.core.BaseClass::getConfig()();
        self.updateAtomicValue = $debox($entry(function(atomicValue, currentValue, reason) {
            var atomicValueJ = $wnd.SmartGWT.convertToJavaObject(atomicValue);
            var currentValueJ = $wnd.isc.SimpleType._skipConvertOpaqueValues ? currentValue :
                                    $wnd.SmartGWT.convertToJavaObject(currentValue);
            var reasonJ = reason;
            var val = updater.@com.smartgwt.client.data.SimpleType.SimpleTypeValueUpdater::updateAtomicValue(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;)(atomicValueJ,currentValueJ,reasonJ);
            var returnVal = $wnd.SmartGWT.convertToPrimitiveType(val);
            return returnVal;
        }));
    }-*/;


    public static interface SimpleTypeValueComparator {
        /**
         * A custom comparator for this SimpleType.  This method will be used by the framework when it needs to compare two
         * values of a field for equality - for example, when considering if an edited field has changed.
         * <p>
         * Implementations of this method should return the following:<ul>
         * <li>0 if the two values are equal</li>
         * <li>-1 if the first value is greater than the second</li>
         * <li>1 if the second value is greater than the first</li>
         * </ul>
         * @param value1 First value for comparison
         * @param value2 Second value for comparison
         * @param field  An instance of DataClass representing the field for which we are 
         *               comparing values, as extra context for the comparator.  
         * @return -1, 0 or 1, as described above
         */
        public int compareValues(Object value1, Object value2, DataSourceField field);
    }
    

    /**
     * Specify a custom comparator to use for this type.<p>
     * If defined, this comparator's compareValues() method will be called when the framework needs to compares values of this type 
     * for equality.
     * @param comparator the comparator
     */
    public native void setSimpleTypeValueComparator(SimpleTypeValueComparator comparator) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::isCreated()() ? this.@com.smartgwt.client.core.BaseClass::getJsObj()() : this.@com.smartgwt.client.core.BaseClass::getConfig()();
        self.compareValues = $debox($entry(function(value1, value2, field) {
            var value1J = $wnd.isc.SimpleType._skipConvertOpaqueValues ? value1 : $wnd.SmartGWT.convertToJavaObject(value1);
            var value2J = $wnd.isc.SimpleType._skipConvertOpaqueValues ? value2 : $wnd.SmartGWT.convertToJavaObject(value2);
            var fieldJ = @com.smartgwt.client.data.DataSourceField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(field);
            var val = comparator.@com.smartgwt.client.data.SimpleType.SimpleTypeValueComparator::compareValues(Ljava/lang/Object;Ljava/lang/Object;Lcom/smartgwt/client/data/DataSourceField;)(value1J,value2J,fieldJ);
            var returnVal = $wnd.SmartGWT.convertToPrimitiveType(val);
            return returnVal;
        }));
    }-*/;

    
    private static DataClass toDataClass(JavaScriptObject fieldJS, JavaScriptObject componentJS)
    {
        Object fieldRef = JSOHelper.getAttributeAsObject(fieldJS, SC.REF);
        if (fieldRef != null) return (DataClass) fieldRef;

        // if the field JS object is an instance, it's a FormItem - create appropriate wrapper
        if (JSOHelper.isScClassInstance(fieldJS)) return FormItemFactory.getFormItem(fieldJS);

        return JSOHelper.isScClassInstance(componentJS) ? 
            _toDataClass(fieldJS, componentJS) : new DataClass(fieldJS);
    }

    private static native DataClass _toDataClass(JavaScriptObject fieldJS, JavaScriptObject componentJS) /*-{
        if ($wnd.isc.DynamicForm && $wnd.isc.isA.DynamicForm(componentJS)) {
            return @com.smartgwt.client.widgets.form.fields.FormItemFactory::getFormItem(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(fieldJS,componentJS);
        }
        return @com.smartgwt.client.util.ObjectFactory::createDataClass(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;Z)(componentJS.getClassName() + "Field", fieldJS, true);
    }-*/;

    public native boolean isCreated()/*-{
        var jsConfig = this.@com.smartgwt.client.data.SimpleType::getConfig()();
        var name = jsConfig.name;
        if(name == null) return false;
        var obj = $wnd.isc.builtinTypes[name];
        return obj != null;
    }-*/;

    public native JavaScriptObject getJsObj()/*-{
        var jsConfig = this.@com.smartgwt.client.data.SimpleType::getConfig()();
        var name = jsConfig.name;
        if(name == null) return null;
        var undef, obj = $wnd.isc.builtinTypes[name];
        // ensure the JS object is a real SC isc.SimpleType instance
        if ($wnd.isc.isAn.Object(obj) && !$wnd.isc.isAn.Instance(obj)) {
            $wnd.isc.builtinTypes[name] = null;
            var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
            return $wnd.isc[scClassName].create(obj);
        }
        return obj === undef ? null : obj;
    }-*/;



    // Summary function APIs

    /**
     *  Registers a new SummaryFunction by name. After calling this method, developers may specify
     *  the name passed in as a standard summaryFunction (for example in ListGridField.setSummaryFunction()).
     *  Note that if the specified name conflicts with one of the built in SummaryFunctionType values, a
     *  RuntimeException will be thrown.
     *
     *  @param functionName name for the SummaryFunction
     *  @param summaryFunction new SummaryFunction implementation
     *
     */
    public static void registerSummaryFunction(String functionName, SummaryFunction summaryFunction) {

        SummaryFunctionType[] defaults = SummaryFunctionType.values();
        for (int i = 0; i < defaults.length; i++) {
            if (defaults[i].getValue() == functionName) {
                throw new RuntimeException("Attempt to register summary function - specified identifier:"  + functionName + " collides with built-in summary function identifier.");
            }
        }
        registerSummaryFunctionJS(functionName, summaryFunction);
    }

    private static native void registerSummaryFunctionJS (String functionName, SummaryFunction summaryFunction) /*-{

        var summaryFunctionJS = $entry(function(records, field) {
            var recordsJ =  @com.smartgwt.client.util.ConvertTo::arrayOfRecord(Lcom/google/gwt/core/client/JavaScriptObject;)(records);
            var fieldJ = @com.smartgwt.client.widgets.grid.ListGridField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(field);
            var val = summaryFunction.@com.smartgwt.client.widgets.grid.SummaryFunction::getSummaryValue([Lcom/smartgwt/client/data/Record;Lcom/smartgwt/client/widgets/grid/ListGridField;)(recordsJ, fieldJ);
            return $wnd.SmartGWT.convertToPrimitiveType(val);
        });
        $wnd.isc.SimpleType.registerSummaryFunction(functionName, summaryFunctionJS);

    }-*/;

    /**
     * Apply a standard {@link SummaryFunctionType} to a set of records and a field.
     * @param records records to obtain the summary value for
     * @param field field on which the summary function is being run
     * @param summaryFunction standard summary function identifier
     * @return result of the summary function.
     */
    public static native Object applySummaryFunction (Record[] records, ListGridField field, SummaryFunctionType summaryFunction) /*-{
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        var fieldJS = field.@com.smartgwt.client.widgets.grid.ListGridField::getJsObj()();
        var summaryFunctionName = summaryFunction.@com.smartgwt.client.types.SummaryFunctionType::getValue()();
        var ret = $wnd.isc.SimpleType.applySummaryFunction(recordsJS, fieldJS, summaryFunctionName);
        if (ret == null) return null;
        return $wnd.SmartGWT.convertToJavaType(ret);
    }-*/;


    /**
     * Apply a registered summary function to a set of records and a field.
     * @param records records to obtain the summary value for
     * @param field field on which the summary function is being run
     * @param functionName name under which the summary function is registered. See {@link #registerSummaryFunction(String, SummaryFunction)}
     * @return result of the summary function.
     */
    public static native Object applySummaryFunction (Record[] records, ListGridField field, String functionName) /*-{
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        var fieldJS = field.@com.smartgwt.client.widgets.grid.ListGridField::getJsObj()();
        return $wnd.isc.SimpleType.applySummaryFunction(recordsJS, fieldJS, functionName);
    }-*/;

    /**
     * Set a default summary function for some field type.
     * @param typeName name of the field type. If this is the name of a custom SimpleType, the developer may need
     * to ensure the type is {@link #register() registered}.
     * @param summaryFunction standard summary function type for this data type
     */
    public static native void setDefaultSummaryFunction (String typeName, SummaryFunctionType summaryFunction) /*-{
        $wnd.isc.SimpleType.setDefaultSummaryFunction(typeName, summaryFunction.@com.smartgwt.client.types.SummaryFunctionType::getValue()());
    }-*/;

    /**
     * Set a default summary function for some field type.
     * @param typeName name of the field type. If this is the name of a custom SimpleType, the developer may need
     * to ensure the type is {@link #register() registered}.
     * @param summaryFunction name under which the summary function is registered. See {@link #registerSummaryFunction(String, SummaryFunction)}
     */
    public static native void setDefaultSummaryFunction (String typeName, String functionName) /*-{
        $wnd.isc.SimpleType.setDefaultSummaryFunction(typeName, functionName);
    }-*/;

    /**
     * Sets customizer whose 
     * {@link com.smartgwt.client.data.GroupTitleFunction#getTitle getTitle()}
     * method overrides the default behavior of 
     * {@link com.smartgwt.client.data.SimpleType#getGroupTitle getGroupTitle()}.
     * Pass null to clear the override.
     */
    public native void setGroupTitleFunction(GroupTitleFunction titleFunction) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        // ensure that default getGroupTitle for this type has been propagated
        if (!self.getGroupTitle) $wnd.isc.SimpleType.setupInheritedProperties(self);
        // save default getGroupTitle method for access by GroupTitleFunction.executeDefault()
        if (!self._getGroupTitle) self._getGroupTitle = self.getGroupTitle;
        // if null passed as titleFunction, clear override and restore default behavior
        if (titleFunction == null) {
            self.getGroupTitle = self._getGroupTitle;
            delete self._getGroupTitle;
            return;
        }
        // stick a reference to the SimpleType on the customizer
        titleFunction.@com.smartgwt.client.data.GroupTitleFunction::setSimpleType(Lcom/smartgwt/client/data/SimpleType;)(this);
        // hook the SC Framework entry point to call the supplied customizer
        self.getGroupTitle = $debox($entry(function(value, recordJS, fieldJS, fieldName, componentJS) {
            var    recordJ =    recordJS == null ? null : @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(recordJS),
                    fieldJ =     fieldJS == null ? null : @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(fieldJS),
                componentJ = componentJS == null ? null : @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(componentJS);
        	return titleFunction.@com.smartgwt.client.data.GroupTitleFunction::getTitle(Ljava/lang/Object;Lcom/smartgwt/client/data/Record;Ljava/util/Map;Ljava/lang/String;Lcom/smartgwt/client/widgets/Canvas;)(value, recordJ, fieldJ, fieldName, componentJ);
    	}));
    }-*/;

    /**
     * Sets customizer whose 
     * {@link com.smartgwt.client.data.GroupValueFunction#getValue getValue()}
     * method overrides the default behavior of 
     * {@link com.smartgwt.client.data.SimpleType#getGroupValue getGroupValue()}.
     * Pass null to clear the override.
     */
    public native void setGroupValueFunction(GroupValueFunction valueFunction) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        // ensure that default getGroupValue for this type has been propagated
        if (!self.getGroupValue) $wnd.isc.SimpleType.setupInheritedProperties(self);
        // save default getGroupValue method for access by GroupValueFunction.executeDefault()
        if (!self._getGroupValue) self._getGroupValue = self.getGroupValue;
        // if null passed as valueFunction, clear override and restore default behavior
        if (valueFunction == null) {
            self.getGroupValue = self._getGroupValue;
            delete self._getGroupValue;
            return;
        }
        // stick a reference to the SimpleType on the customizer
        valueFunction.@com.smartgwt.client.data.GroupValueFunction::setSimpleType(Lcom/smartgwt/client/data/SimpleType;)(this);
        // hook the SC Framework entry point to call the supplied customizer
        self.getGroupValue = $debox($entry(function(value, recordJS, fieldJS, fieldName, componentJS) {
            var    recordJ =    recordJS == null ? null : @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(recordJS),
                    fieldJ =     fieldJS == null ? null : @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(fieldJS),
                componentJ = componentJS == null ? null : @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(componentJS);
        	return valueFunction.@com.smartgwt.client.data.GroupValueFunction::getValue(Ljava/lang/Object;Lcom/smartgwt/client/data/Record;Ljava/util/Map;Ljava/lang/String;Lcom/smartgwt/client/widgets/Canvas;)(value, recordJ, fieldJ, fieldName, componentJ);
    	}));
    }-*/;


}
