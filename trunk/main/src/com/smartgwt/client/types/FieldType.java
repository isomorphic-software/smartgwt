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

package com.smartgwt.client.types;

/**
 * The types listed below are built-in types that {@link com.smartgwt.client.widgets.DataBoundComponent 'databound components'}
 * understand and treat specially (using type-specific form controls, validators,&#010 formatters, sorting
 * logic, etc).  &#010 <P>&#010 You can declare custom types via {@link com.smartgwt.client.data.SimpleType},
 * with settings that&#010 will influence DataBound components.  You can also create your own subclasses of
 * databound&#010 components to add further custom, reusable behaviors based on field.type.&#010 <P>&#010
 * <code>field.type</code> can also be the ID of another {@link com.smartgwt.client.data.DataSource}, which allows
 * you to&#010 model nested structures such as XML documents (in fact, {@link com.smartgwt.client.data.XMLTools#loadXMLSchema(String, com.smartgwt.client.data.XSDLoadCallback, com.smartgwt.client.rpc.RPCRequest)} ;&#010
 * models XML schema in this way).  Nested DataSource declarations affect how XML and JSON data&#010 is deserialized
 * into JavaScript objects in the &#010 {@link com.smartgwt.client.docs.ClientDataIntegration 'client-side integration')}
 * pipeline, so that you can load&#010 complex XML documents and have them deserialized into a correctly
 * typed JavaScript object&#010 model.&#010 <P>&#010 Note: to declared related but <i>separate</i> objects, as in an
 * "Account" object that can be&#010 related to both a "Contact" object and "Order" objects, use&#010
 * {@link com.smartgwt.client.data.DataSourceField#setForeignKey(String) foreignKey}, <b>not</b> a nested structure declaration.
 */

public enum FieldType implements ValueEnum {
    /**
     * Generic text, e.g. <code>"John Doe"</code>. This is the default field type.                    Use
     * <code>field.length</code> to set length.
     */
    TEXT("text"),
    /**
     * A boolean value, e.g. <code>true</code>
     */
    BOOLEAN("boolean"),
    /**
     * A whole number, e.g. <code>123</code>
     */
    INTEGER("integer"),
    /**
     * A floating point (decimal) number, e.g. <code>1.23</code>
     */
    FLOAT("float"),
    /**
     * A date, including time of day. Represented on the client as a JavaScript <code>Date</code>
     * object.
     * object.
     */
    DATE("date"),

    /**
     * A time of day, with no date. Represented internally on the client as a JavaScript Date object in UTC/GMT by default
     */
    TIME("time"),

    /**
     * A date and time, accurate to the second. Represented on the client as a JavaScript Date object. 
     */
    DATETIME("datetime"),
    /**
     * A text value constrained to a set of legal values specified by the                    field's
     * {@link com.smartgwt.client.data.DataSourceField#setValueMap(String[]) valueMap} , as though an&#010
     * {@link com.smartgwt.client.widgets.form.validator.IsOneOfValidator} validator had been declared.
     */
    ENUM("enum"),
    /**
     * An enum whose values are numeric.
     */
    INTENUM("intEnum"),
    /**
     * If you are using the SmartGWT SQL datasource connector, a <code>sequence</code> is a
     * unique, increasing whole number, incremented whenever a new record is added. Otherwise,
     * <code>sequence</code> behaves identically to <code>integer</code>. This type is typically
     * used with <code>field.primaryKey</code> to auto-generate unique primary keys.
     */
    SEQUENCE("sequence"),
    /**
     * A string representing a well-formed URL.  Some components will render this as an HTML link
     * (using an anchor tag for example).
     */
    LINK("link"),
    /**
     * A string representing a well-formed URL that points to an image.  Some components will render
     * an IMG tag with the value of this field as the 'src' attribute to render the image.
     */
    IMAGE("image"),
    /**
     * Arbitrary binary data.  When this field type is present, three additional fields are automatically generated.
     * They are: &lt;fieldName&gt;_filename, &lt;fieldName&gt;_filesize, and&#010 &lt;fieldName&gt;_date_created where
     * &lt;fieldName&gt; is the value of the <code>name</code>&#010 attribute of this field.  These fields are marked
     * as&#010 {@link com.smartgwt.client.data.DataSourceField#setHidden(Boolean) hidden }<code>:true</code> to suppress their rendering
     * by default.  You&#010 can show one or more of these fields by specifying the field with a
     * <code>hidden:false</code>&#010 override in the fields array of the databound component.
     */
    BINARY("binary"),
    
    /**
     * Binary data comprising an image.
     */
    IMAGEFILE("imageFile"),

    /**
     * Fields of this type are automatically populated by the Smart GWT Server                
     * with the current authenticated userId as part of add and update operations.
     * By default, fields of this type are hidden and not editable; the server
     * ignores any value that the client sends in a field of this type.
     */
    MODIFIER("modifier"),

     /**
     * Fields of this type are automatically populated by the Smart GWT Server with
     * the current date and time as part of add and update operations.  By
     * default, fields of this type are hidden and not editable; the server ignores
     * any value that the client sends in a field of this type.
      */
    MODIFIERTIMESTAMP("modifiertimestamp"),

    /**
     * Fields of this type are automatically populated by the Smart GWT Server                
     * with the current authenticated userId as part of add operations. By default,
     * fields of this type are hidden and not editable; the server ignores any
     * value that the client sends in a field of this type.
     */
    CREATOR("creator"),

    /**
     * Fields of this type are automatically populated by the Smart GWT Server with
     * the current date and time as part of add and update operations.  By
     * default, fields of this type are hidden and not editable; the server ignores
     * any value that the client sends in a field of this type.
     */
    CREATORTIMESTAMP("creatortimestamp"),

    /**
      * Password field type
      */
    PASSWORD("password");

    private String value;

    FieldType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

