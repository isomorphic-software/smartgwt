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
 
package com.smartgwt.client.types;

/**
 * Used to name a validator or reference a standard, built-in {@link com.smartgwt.client.widgets.form.validator.Validator}
 * - see list below. <p> To make use of a standard validator type for a field in a DataSource, or  DynamicForm instance,
 * specify the <code>validators</code> property to an array  containing a validator definition where the <code>type</code>
 * property is set to  the appropriate type.   <p> A custom error message can be specified for any validator type by
 * setting the <code>errorMessage</code> property on the validator definition object, and some validator types make use of
 * additional properties on the validator definition  object such as <code>max</code> or <code>min</code>. <p> For example,
 * to use the <code>integerRange</code> validator type:<br><br><code> &nbsp;&nbsp;field:{<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;validators:[<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{type:"integerRange", min:1, max:100}<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;]<br> &nbsp;&nbsp;} </code> <p> Custom validators can be reused on the client by adding them to
 * the global validator list, via the {@link com.smartgwt.client.widgets.form.validator.Validator#addValidatorDefinition
 * Validator.addValidatorDefinition} method.
 */
public enum ValidatorType implements ValueEnum {
    /**
     * Validation will fail if this field is non-empty and has a non-boolean value.
     */
    ISBOOLEAN("isBoolean"),
    /**
     * Validation will fail if the value is not a string value.
     */
    ISSTRING("isString"),
    /**
     * Tests whether the value for this field is a whole number. If  <code>validator.convertToInteger</code> is true, float
     * values will be converted  into integers and validation will succeed.
     */
    ISINTEGER("isInteger"),
    /**
     * Tests whether the value for this field is a valid floating point number.
     */
    ISFLOAT("isFloat"),
    /**
     * Tests whether the value for this field is a valid expression or function; if it is valid, creates a {@link
     * com.smartgwt.client.docs.StringMethods stringMethod} object with the value and set the resultingValue to the
     * StringMethod.
     */
    ISFUNCTION("isFunction"),
    /**
     * RequiredIf type validators should be specified with an <code>expression</code> property set to a {@link
     * com.smartgwt.client.docs.StringMethods stringMethod}, which takes three parameters:<ul> <li>item - the DynamicForm item
     * on which the error occurred (may be null) <li>validator - a pointer to the validator object <li>value - the value of the
     * field in question <li>record - the "record" object - the set of values being edited by the widget </ul> When validation
     * is performed, the expression will be evaluated (or executed) - if it returns <code>true</code>, the field will be
     * treated as a required field, so validation will fail if the field has no value. <p>To allow server-side enforcement, a
     * <code>required</code> validator can be used instead. Conditional criteria can be specified with the
     * <code>applyWhen</code> property.  <p>See <a href="http://www.smartclient.com/smartgwt/showcase/#form_dep_conditionally"
     * target="examples">Conditionally Required Example</a>.
     */
    REQUIREDIF("requiredIf"),
    /**
     * Tests whether the value for this field matches the value of some other field. The field to compare against is specified
     * via the <code>otherField</code> property on the validator object (should be set to a field name). <p>See <a
     * href="http://www.smartclient.com/smartgwt/showcase/#form_dep_match_value" target="examples">Match Value Example</a>.
     */
    MATCHESFIELD("matchesField"),
    /**
     * Tests whether the value for this field matches any value from an arbitrary list of acceptable values. The set of
     * acceptable values is specified via the <code>list</code> property on the validator, which should be set to an array of
     * values. If validator.list is not supplied, the valueMap for the field will be used. If there is no valueMap, not
     * providing validator.list is an error.
     */
    ISONEOF("isOneOf"),
    /**
     * Tests whether the value for this field is a whole number within the range  specified. The <code>max</code> and
     * <code>min</code> properties on the validator are used to determine the acceptable range, inclusive. To specify the range
     * as exclusive of the min/mix values, set <code>exclusive</code> to <code>true</code>. <p>See <a
     * href="http://www.smartclient.com/smartgwt/showcase/#form_validation_builtins" target="examples">Built-ins Example</a>.
     */
    INTEGERRANGE("integerRange"),
    /**
     * This validator type applies to string values only. If the value is a string value validation will fail if the string's
     * length falls outside the range specified by  <code>validator.max</code> and <code>validator.min</code>. <p> Note that
     * non-string values will always pass validation by this validator type. <p> Note that the <code>errorMessage</code> for
     * this validator will be evaluated as a dynamicString - text within <code>\${...}</code> will be evaluated as JS code when
     * the message is displayed, with <code>max</code> and <code>min</code> available as variables mapped to
     * <code>validator.max</code> and <code>validator.min</code>.
     */
    LENGTHRANGE("lengthRange"),
    /**
     * Determine whether a string value contains some substring specified via  <code>validator.substring</code>.
     */
    CONTAINS("contains"),
    /**
     * Determine whether a string value does <b>not</b> contain some substring specified via  <code>validator.substring</code>.
     */
    DOESNTCONTAIN("doesntContain"),
    /**
     * Determine whether a string value contains some substring multiple times. The substring to check for is specified via
     * <code>validator.substring</code>. The <code>validator.operator</code> property allows you to specify how to test the
     * number of substring occurrences. Valid values for this property are <code>==</code>, <code>!=</code>, <code>&lt;</code>,
     * <code>&lt;=</code>, <code>&gt;</code>, <code>&gt;=</code>. <p> The number of matches to check for is specified via
     * <code>validator.count</code>.
     */
    SUBSTRINGCOUNT("substringCount"),
    /**
     * <code>regexp</code> type validators will determine whether the value specified  matches a given regular expression. The
     * expression should be specified on the <code>validator</code> object as the <code>expression</code> property. <p>See <a
     * href="http://www.smartclient.com/smartgwt/showcase/#form_validation_regexp" target="examples">Regular Expression
     * Example</a>.
     */
    REGEXP("regexp"),
    /**
     * Validate against a regular expression mask, specified as <code>validator.mask</code>. If validation is successful a
     * transformation can also be specified via the <code>validator.transformTo</code> property. This should be set to a string
     * in the standard format for string replacement via the native JavaScript <code>replace()</code> method. <p>See <a
     * href="http://www.smartclient.com/smartgwt/showcase/#form_validation_value_transform" target="examples">Value Transform
     * Example</a>.
     */
    MASK("mask"),
    /**
     * Tests whether the value for a date field is within the range specified. Range is inclusive, and is specified via
     * <code>validator.min</code> and <code>validator.max</code>, which should be specified in <a target=_blank
     * href="http://www.w3.org/TR/xmlschema-2/#dateTime">XML Schema date format</a> or as a live JavaScript Date object (for
     * client-only validators only). To specify the range as exclusive of the min/mix values, set <code>exclusive</code> to
     * <code>true</code>. <p> Note that the <code>errorMessage</code> for this validator will be evaluated as a dynamicString -
     * text within <code>\${...}</code> will be evaluated as JS code when the message is displayed, with <code>max</code> and
     * <code>min</code> available as variables mapped to <code>validator.max</code> and <code>validator.min</code>.
     */
    DATERANGE("dateRange"),
    /**
     * Validate a field as a valid floating point value within a value range. Range is specified via <code>validator.min</code>
     * and <code>validator.max</code>. Also checks precision, specified as number of decimal places in 
     * <code>validator.precision</code>. If <code>validator.roundToPrecision</code> is set  a value that doesn't match the
     * specified number of decimal places will be rounded to the nearest value that does.  <p> For backwards compatibility
     * only. Use "floatRange" and/or "floatPrecision" instead.
     */
    FLOATLIMIT("floatLimit"),
    /**
     * Tests whether the value for this field is a floating point number within the range  specified. The <code>max</code> and
     * <code>min</code> properties on the validator are used to determine the acceptable range, inclusive. To specify the range
     * as exclusive of the min/mix values, set <code>exclusive</code> to <code>true</code>. <p> Note that the
     * <code>errorMessage</code> for this validator will be evaluated as a dynamicString - text within <code>\${...}</code>
     * will be evaluated as JS code when the message is displayed, with <code>max</code> and <code>min</code> available as
     * variables mapped to <code>validator.max</code> and <code>validator.min</code>.
     */
    FLOATRANGE("floatRange"),
    /**
     * Tests whether the value for this field is a floating point number with the  appropriate number of decimal places -
     * specified in <code>validator.precision</code> If the value is of higher precision and
     * <code>validator.roundToPrecision</code>  is specified, the value will be rounded to the specified number of decimal
     * places and validation will pass, otherwise validation will fail.
     */
    FLOATPRECISION("floatPrecision"),
    /**
     * A non-empty value is required for this field to pass validation.
     */
    REQUIRED("required"),
    /**
     * Change the state/appearance of this field. Desired appearance is specified via the <code>fieldAppearance</code> property
     * on the validator object. See FieldAppearance type for choices. <p> If <code>fieldAppearance</code> is not specified, the
     * default is "readOnly".
     */
    READONLY("readOnly"),
    /**
     * Returns true if the value for this field is unique across the whole DataSource. <p> Validators of this type have 
     * requiresServer  set to <code>true</code> and do not run on the client. <p>See <a
     * href="http://www.smartclient.com/smartgwtee/showcase/#uniqueCheckValidation"
     * target="examples">uniqueCheckValidation</a>.
     */
    ISUNIQUE("isUnique"),
    /**
     * Returns true if the record implied by a relation exists. The relation can be  derived automatically from the {@link
     * com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} attribute of  the field being validated, or you can
     * specify it manually via  <code>validator.relatedDataSource</code> and <code>validator.relatedField</code>. <p> You can
     * specify at DataSource level that this validator should be automatically  applied to all fields that specify a {@link
     * com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} - see {@link
     * com.smartgwt.client.data.DataSource#getValidateRelatedRecords validateRelatedRecords}. <p> Validators of this type have 
     * requiresServer  set to <code>true</code> and do not run on the client. <p> Note that this validation is generally
     * unnecessary for data coming from a UI. The  typical UI uses a {@link com.smartgwt.client.widgets.form.fields.SelectItem}
     * or {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem} with an  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource} for user entry, such that the
     * user  can't accidentally enter a related record if that doesn't exist, and a typical SQL  schema will include
     * constraints that prevent a bad insert if the user attempts to  circumvent the UI. The primary purpose of declaring this
     * validation explicitly is  to provide clear, friendly error messages for use cases such as {@link
     * com.smartgwt.client.widgets.BatchUploader},  where values aren't individually chosen by the user. See also the example
     * <a href="http://www.smartclient.com/smartgwtee/showcase/#hasRelatedValidation" target="examples">Related Records</a>.
     */
    HASRELATEDRECORD("hasRelatedRecord"),
    /**
     * Custom server-side validator that either evaluates the Velocity expression provided in  {@link
     * com.smartgwt.client.docs.serverds.Validator#serverCondition serverCondition} (see <a
     * href="http://www.smartclient.com/smartgwtee/showcase/#velocityValidation" target="examples">velocityValidation</a>) or
     * makes DMI call to {@link com.smartgwt.client.docs.serverds.Validator#serverObject serverObject} to evaluate condition
     * (see <a href="http://www.smartclient.com/smartgwtee/showcase/#dmiValidation" target="examples">dmiValidation</a>). <p>
     * Validators of this type have  requiresServer  set to <code>true</code> and do not run on the client.
     */
    SERVERCUSTOM("serverCustom");

    private String value;

    ValidatorType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
