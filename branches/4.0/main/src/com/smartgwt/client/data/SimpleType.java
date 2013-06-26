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
import com.smartgwt.client.callbacks.*;
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
import com.smartgwt.client.widgets.drawing.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.logicalstructure.core.*;
import com.smartgwt.logicalstructure.widgets.*;
import com.smartgwt.logicalstructure.widgets.drawing.*;
import com.smartgwt.logicalstructure.widgets.plugins.*;
import com.smartgwt.logicalstructure.widgets.form.*;
import com.smartgwt.logicalstructure.widgets.tile.*;
import com.smartgwt.logicalstructure.widgets.grid.*;
import com.smartgwt.logicalstructure.widgets.chart.*;
import com.smartgwt.logicalstructure.widgets.layout.*;
import com.smartgwt.logicalstructure.widgets.menu.*;
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;

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
 * {@link com.smartgwt.client.data.SimpleType#getAtomicValue SimpleType.getAtomicValue} and {@link
 * com.smartgwt.client.data.SimpleType#updateAtomicValue SimpleType.updateAtomicValue} methods.
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
 *  <a href='XML Schema' onclick="window.open('XML Schema');return false;">http://www.w3.org/TR/xmlschema-0/</a>, and
 *  {@link com.smartgwt.client.data.XMLTools#loadXMLSchema XMLTools.loadXMLSchema} will create new SimpleType definitions.
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
 *  listed in <code>project.datasources</code> property in server.properties.
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
 *          errorMessage="Length of country code should be equals to 2." /&gt;
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
 * An @see <a href="http://www.smartclient.com/smartgwtee/showcase/#formsCustomSimpleType" target="examples">example</a> is
 * here.
 */
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
        id = JSOHelper.getAttribute(jsObj, "ID");
        setName(JSOHelper.getAttribute(jsObj, "name"));
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
     * These are properties that are essentially copied onto any DataSourceField where the property is applied. The supported
     * properties are only client-side properties.
     *
     * @param fieldProperties fieldProperties Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setFieldProperties(DataSourceField fieldProperties)  throws IllegalStateException {
        setAttribute("fieldProperties", fieldProperties.getJsObj(), false);
    }

    /**
     * These are properties that are essentially copied onto any DataSourceField where the property is applied. The supported
     * properties are only client-side properties.
     *
     * @return DataSourceField
     */
    public DataSourceField getFieldProperties()  {
        return new DataSourceField(getAttributeAsJavaScriptObject("fieldProperties"));
    }


    /**
     * Name of another SimpleType from which this type should inherit. <P> Validators, if any, will be combined.  All other
     * SimpleType properties default to the inherited type's value.
     *
     * @param inheritsFrom . See {@link com.smartgwt.client.docs.String String}. Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_type_reuse" target="examples">DataType Reuse Example</a>
     */
    public void setInheritsFrom(String inheritsFrom)  throws IllegalStateException {
        setAttribute("inheritsFrom", inheritsFrom, false);
    }

    /**
     * Name of another SimpleType from which this type should inherit. <P> Validators, if any, will be combined.  All other
     * SimpleType properties default to the inherited type's value.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_type_reuse" target="examples">DataType Reuse Example</a>
     */
    public String getInheritsFrom()  {
        return getAttributeAsString("inheritsFrom");
    }


    /**
     * Name of the type, used to refer to the type from {@link com.smartgwt.client.data.DataSourceField#getType field.type}.
     *
     * @param name . See {@link com.smartgwt.client.docs.String String}. Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setName(String name)  throws IllegalStateException {
        setAttribute("name", name, false);
    }

    /**
     * Name of the type, used to refer to the type from {@link com.smartgwt.client.data.DataSourceField#getType field.type}.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getName()  {
        return getAttributeAsString("name");
    }





    // ********************* Methods ***********************

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
     * Validators to apply to value of this type.
     *
     * @param validators validators Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setValidators(Validator... validators) throws IllegalStateException {
        setAttribute("validators", validators, false);
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
     * multiple FormItems (eg, in grids, forms and trees) and there's an underlying limitation here where event handlers have to be written to
     * dynamically receive the actual FormItem rather than relying on "this" (because there's more than one "this").
     * This means you need to follow the special rules indicated for 
     * {@link com.smartgwt.client.data.DataSourceField#setEditorProperties(FormItem)}. 
     * As an alternative, you can use {@link setEditorType(String)} or
     * {@link setEditorType(Class)} to avoid these limitations, if you register
     * the FormItem subclass with the {@link com.smartgwt.client.docs.Reflection reflection mechanism}.
     *
     * @param editorProperties FormItem with default properties to use when editing
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setEditorProperties(FormItem editorProperties) throws IllegalStateException {
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
     * Synonym for {@link setEditorProperties(FormItem)}.
     *
     * @param editorType FormItem with default properties to be applied when editing
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @deprecated Renamed to {@link setEditorProperties(FormItem)}. You can also consider using 
     *             {@link setEditorType(Class)} or {@link setEditorType(String)} instead.
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
     * By doing so, you avoid the limitations of {@link setEditorProperties(FormItem)}.
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
     * By doing so, you avoid the limitations of {@link setEditorProperties(FormItem)}.
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
     * FormItem properties to be applied when editing values of this type in a read-only context.
     * <p>
     * <b>Note</b>: The FormItem passed to setReadOnlyEditorProperties() is used as a "template" to create a FormItem whenever
     * a {@link com.smartgwt.client.widgets.DataBoundComponent} needs to show an interface for editing this 
     * field (and the field is marked read-only). This means you need to follow special rules indicated
     * for {@link com.smartgwt.client.data.DataSourceField#setEditorProperties(FormItem)}. 
     * As an alternative, you can use {@link setReadOnlyEditorType(String)} or
     * {@link setReadOnlyEditorType(Class)} to avoid these limitations, if you register
     * the FormItem subclass with the {@link com.smartgwt.client.docs.Reflection reflection mechanism}.
     *
     * @param editorProperties FormItem with properties to be applied when editing values of this type in a read-only context.
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setReadOnlyEditorProperties(FormItem editorProperties) throws IllegalStateException {
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
     * Synonym for {@link setReadOnlyEditorProperties(FormItem)}.
     *
     * @param editorType FormItem with default properties to be applied when editing
     * @deprecated Renamed to {@link setReadOnlyEditorProperties(FormItem)}. You can also consider using 
     *             {@link setReadOnlyEditorType(Class)} or {@link setReadOnlyEditorType(String)} instead.
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
     * this method avoids the limitations described in {@link setReadOnlyEditorProperties(FormItem)}.
     * 
     * @param editorType the fully-qualified class name of a {@link com.smartgwt.client.widgets.form.fields.FormItem}
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
        setAttribute("readOnlyEditorType", editorType, false);
    }

    /**
     * Set the default {@link FormItem} class to be used whenever a value of this type is edited
     * in a read-only context (whether in a grid, form, or other component).
     * <p>
     * If unset, a FormItem will be automatically chosen.
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
     * Set of search operators valid for this type.   <P> If not specified, the {@link
     * com.smartgwt.client.data.SimpleType#getInheritsFrom inheritsFrom} type's operators will be used, finally
     * defaulting to the default operators for the basic types (eg integer).
     *
     * @param operators validOperators Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setValidOperators(OperatorId... operators) throws IllegalStateException {
        setAttribute("validOperators", operators, false);
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
            var fieldJ = @com.smartgwt.client.data.SimpleType::toDataClass(Lcom/google/gwt/core/client/JavaScriptObject;)(field);
            var componentJ = (component == null || component === undefined) ? null : @com.smartgwt.client.widgets.Canvas::getOrCreateDBC(Lcom/google/gwt/core/client/JavaScriptObject;)(component);
            var recordJ = (record == null || record === undefined) ? null : @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
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
            var fieldJ = @com.smartgwt.client.data.SimpleType::toDataClass(Lcom/google/gwt/core/client/JavaScriptObject;)(field);
            var componentJ = (component == null || component === undefined) ? null : @com.smartgwt.client.widgets.Canvas::getOrCreateDBC(Lcom/google/gwt/core/client/JavaScriptObject;)(component);
            var recordJ = (record == null || record === undefined) ? null : @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
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
            var fieldJ = @com.smartgwt.client.data.SimpleType::toDataClass(Lcom/google/gwt/core/client/JavaScriptObject;)(field);
            var componentJ = (component == null || component === undefined) ? null : @com.smartgwt.client.widgets.Canvas::getOrCreateDBC(Lcom/google/gwt/core/client/JavaScriptObject;)(component);
            var recordJ = (record == null || record === undefined) ? null : @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
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
    public native Object setEditParser(SimpleTypeParser parser) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::isCreated()() ? this.@com.smartgwt.client.core.BaseClass::getJsObj()() : this.@com.smartgwt.client.core.BaseClass::getConfig()();
        self.parseInput = $debox($entry(function(value, field, component, record) {
            var fieldJ = @com.smartgwt.client.data.SimpleType::toDataClass(Lcom/google/gwt/core/client/JavaScriptObject;)(field);
            var componentJ = (component == null || component === undefined) ? null : @com.smartgwt.client.widgets.Canvas::getOrCreateDBC(Lcom/google/gwt/core/client/JavaScriptObject;)(component);
            var recordJ = (record == null || record === undefined) ? null : @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
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
    }

    /**
     * Specify an extractor to extract an atomic value (such as a string or number) from some arbitrary live data value.
     * If defined this method will be called for every field value of the specified type in order to convert from the raw
     * data value to an atomic type to be used for standard DataBinding features such as sorting and editing.
     * @param extractor the extractor
     */
    public native Object setSimpleTypeValueExtractor(SimpleTypeValueExtractor extractor) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::isCreated()() ? this.@com.smartgwt.client.core.BaseClass::getJsObj()() : this.@com.smartgwt.client.core.BaseClass::getConfig()();
        self.getAtomicValue = $debox($entry(function(value) {
            var valueJ = $wnd.SmartGWT.convertToJavaObject(value);
            var val = extractor.@com.smartgwt.client.data.SimpleType.SimpleTypeValueExtractor::getAtomicValue(Ljava/lang/Object;)(valueJ);
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
    }

    /**
     * Specify an updater to update a live data value with an edited atomic value (such as a string or number).
     * If defined this updater's updateAtomicValue method will be called when the user edits data in a field of this type,
     * allowing the developer to convert from the atomic type to a raw data value for storage.
     * @param extractor the updater
     */
    public native Object setSimpleTypeValueUpdater(SimpleTypeValueUpdater updater) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::isCreated()() ? this.@com.smartgwt.client.core.BaseClass::getJsObj()() : this.@com.smartgwt.client.core.BaseClass::getConfig()();
        self.updateAtomicValue = $debox($entry(function(atomicValue, currentValue) {
            var atomicValueJ = $wnd.SmartGWT.convertToJavaObject(atomicValue);
            var currentValueJ = $wnd.SmartGWT.convertToJavaObject(currentValue);
            var val = updater.@com.smartgwt.client.data.SimpleType.SimpleTypeValueUpdater::updateAtomicValue(Ljava/lang/Object;Ljava/lang/Object;)(atomicValueJ,currentValueJ);
            var returnVal = $wnd.SmartGWT.convertToPrimitiveType(val);
            return returnVal;
        }));
    }-*/;

    private static DataClass toDataClass(JavaScriptObject jsObj) {
        Object ref = JSOHelper.getAttributeAsObject((JavaScriptObject) jsObj, SC.REF);
        return ref == null ? new DataClass(jsObj) : (RefDataClass) ref;
    }

    public native boolean isCreated()/*-{
        var jsConfig = this.@com.smartgwt.client.data.SimpleType::getConfig()();
        var name = jsConfig.name;
        if(name == null || name === undefined) return false;
        var obj = $wnd.isc.builtinTypes[name];
        return obj != null && obj !== undefined;
    }-*/;

    public native JavaScriptObject getJsObj()/*-{
        var jsConfig = this.@com.smartgwt.client.data.SimpleType::getConfig()();
        var name = jsConfig.name;
        if(name == null || name === undefined) return null;
        var obj = $wnd.isc.builtinTypes[name];
        return obj === undefined ? null : obj;
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
     * @param functionName name under which the summary function is registered. See {@link #registerSummaryFunction(String, SummaryFunction)
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
     * to ensure the type is {@link #register(),registered}.
     * @param summaryFunction standard summary function type for this data type
     */
    public static native void setDefaultSummaryFunction (String typeName, SummaryFunctionType summaryFunction) /*-{
        $wnd.isc.SimpleType.setDefaultSummaryFunction(typeName, summaryFunction.@com.smartgwt.client.types.SummaryFunctionType::getValue()());
    }-*/;

    /**
     * Set a default summary function for some field type.
     * @param typeName name of the field type. If this is the name of a custom SimpleType, the developer may need
     * to ensure the type is {@link #register(),registered}.
     * @param summaryFunction name under whithc the summary function is registered. See {@link #registerSummaryFunction(String, SummaryFunction)}
     */
    public static native void setDefaultSummaryFunction (String typeName, String functionName) /*-{
        $wnd.isc.SimpleType.setDefaultSummaryFunction(typeName, functionName);
    }-*/;


}


