package com.smartgwt.client.types;


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
 * Validator.addValidatorDefinition()} method.
 */
public enum ValidatorType implements ValueEnum {
    /**
     * Validation will fail if this field is non-empty and has a non-boolean value.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "isBoolean".
     */
    ISBOOLEAN("isBoolean"),
    /**
     * Validation will fail if the value is not a string value.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "isString".
     */
    ISSTRING("isString"),
    /**
     * Tests whether the value for this field is a whole number. If  <code>validator.convertToInteger</code> is true, float
     * values will be converted  into integers and validation will succeed.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "isInteger".
     */
    ISINTEGER("isInteger"),
    /**
     * Tests whether the value for this field is a valid floating point number.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "isFloat".
     */
    ISFLOAT("isFloat"),
    /**
     * Tests whether the value for this field is a valid expression or function; if it is valid, creates a {@link
     * com.smartgwt.client.docs.StringMethods stringMethod} object with the value and set the resultingValue to the
     * StringMethod.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "isFunction".
     */
    ISFUNCTION("isFunction"),
    /**
     * RequiredIf type validators should be specified with an <code>expression</code> property set to a {@link
     * com.smartgwt.client.docs.StringMethods stringMethod}, which takes four parameters:<ul> <li>item - the DynamicForm item
     * on which the error occurred (may be null) <li>validator - a pointer to the validator object <li>value - the value of the
     * field in question <li>record - the "record" object - the set of values being edited by the widget </ul> When validation
     * is performed, the expression will be evaluated (or executed). If it returns <code>true</code>, the field will be treated
     * as a required field, so validation will fail if the field has no value, or, in the case of a {@link
     * com.smartgwt.client.widgets.form.fields.FileItem} or {@link com.smartgwt.client.widgets.form.fields.UploadItem} and if
     * client-side validation is supported by the browser, if no file is selected for upload or the selected file is empty.
     * <p>To allow server-side enforcement, a <code>required</code> validator can be used instead. With the exception of
     * "binary" fields, conditional criteria can be specified with the {@link
     * com.smartgwt.client.widgets.form.validator.Validator#getApplyWhen applyWhen} property. <p>See <a
     * href="http://www.smartclient.com/smartgwt/showcase/#form_dep_conditionally" target="examples">Conditionally Required
     * Example</a>. <p>  Moreover, the expression provided needs to be in JavaScript, so to use this API, you should be
     * familiar  with JavaScript and Smart GWT APIs. A pure-Java alternative is to add a  {@link
     * com.smartgwt.client.widgets.form.validator.RequiredIfValidator RequiredIfValidator} on the DynamicForm or ListGrid where
     * validation is required.  <p><strong>NOTE:</strong> A requiredIf validator cannot be used to guarantee that a non-empty
     * file is uploaded. The user's browser might not support client-side file validation. Using a requiredIf validator on a
     * "binary" field may be appropriate in scenarios where the application does not technically require a non-empty file to be
     * uploaded by the user. For example, in a bug tracking application, a file upload may be required if the "Have a test
     * case?" checkbox is checked, but the value of the "Have a test case?" checkbox is not actually saved by the application;
     * instead, whether the user is providing a test case is inferred by whether a non-empty test case file was uploaded.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "requiredIf".
     */
    REQUIREDIF("requiredIf"),
    /**
     * Tests whether the value for this field matches the value of some other field. The field to compare against is specified
     * via the <code>otherField</code> property on the validator object (should be set to a field name). <p>See <a
     * href="http://www.smartclient.com/smartgwt/showcase/#form_dep_match_value" target="examples">Match Value Example</a>.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "matchesField".
     */
    MATCHESFIELD("matchesField"),
    /**
     * Tests whether the value for this field matches some value specified via <code>value</code>.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "equals".
     */
    EQUALS("equals"),
    /**
     * Tests whether the value for this field does not match some value specified via <code>value</code>.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "notEqual".
     */
    NOTEQUAL("notEqual"),
    /**
     * [deprecated in favor of <code>inSet</code>] Tests whether the value for this field matches any value from an arbitrary
     * list of acceptable values. The set of acceptable values is specified via the <code>list</code> property on the
     * validator, which should be set to an array of values. If validator.list is not supplied, the valueMap for the field will
     * be used. If there is no valueMap, not providing validator.list is an error.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "isOneOf".
     */
    ISONEOF("isOneOf"),
    /**
     * Tests whether the value for this field matches any value from an arbitrary list of acceptable values. The set of
     * acceptable values is specified via the <code>list</code> property on the validator, which should be set to an array of
     * values. If validator.list is not supplied, the valueMap for the field will be used. If there is no valueMap, not
     * providing validator.list is an error.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "inSet".
     */
    INSET("inSet"),
    /**
     * Tests whether the value for this field does not match any value from an arbitrary list of unacceptable values. The set
     * of unacceptable values is specified via the <code>list</code> property on the validator, which should be set to an array
     * of values. Not providing validator.list is an error.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "notInSet".
     */
    NOTINSET("notInSet"),
    /**
     * Tests whether the value for this field is a whole number within the range  specified. The <code>max</code> and
     * <code>min</code> properties on the validator are used to determine the acceptable range, inclusive. To specify the range
     * as exclusive of the min/mix values, set <code>exclusive</code> to <code>true</code>. <p>See <a
     * href="http://www.smartclient.com/smartgwt/showcase/#form_validation_builtins" target="examples">Built-ins Example</a>.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "integerRange".
     */
    INTEGERRANGE("integerRange"),
    /**
     * This validator type applies to string values only. If the value is a string value validation will fail if the string's
     * length falls outside the range specified by  <code>validator.max</code> and <code>validator.min</code>. <p> Note that
     * non-string values will always pass validation by this validator type. <p> Note that the <code>errorMessage</code> for
     * this validator will be evaluated as a dynamicString - text within <code>&#36;{...}</code> will be evaluated as JS code
     * when the message is displayed, with <code>max</code> and <code>min</code> available as variables mapped to
     * <code>validator.max</code> and <code>validator.min</code>.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "lengthRange".
     */
    LENGTHRANGE("lengthRange"),
    /**
     * Determine whether a string value contains some substring specified via  <code>validator.substring</code>.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "contains".
     */
    CONTAINS("contains"),
    /**
     * Determine whether a string value does <b>not</b> contain some substring specified via  <code>validator.substring</code>.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "doesntContain".
     */
    DOESNTCONTAIN("doesntContain"),
    /**
     * Determine whether a string value contains some substring multiple times. The substring to check for is specified via
     * <code>validator.substring</code>. The <code>validator.operator</code> property allows you to specify how to test the
     * number of substring occurrences. Valid values for this property are <code>==</code>, <code>!=</code>, <code>&lt;</code>,
     * <code>&lt;=</code>, <code>&gt;</code>, <code>&gt;=</code>. <p> The number of matches to check for is specified via
     * <code>validator.count</code>.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "substringCount".
     */
    SUBSTRINGCOUNT("substringCount"),
    /**
     * <code>regexp</code> type validators will determine whether the value specified  matches a given regular expression. The
     * expression should be specified on the <code>validator</code> object as the <code>expression</code> property. <p>See <a
     * href="http://www.smartclient.com/smartgwt/showcase/#form_validation_regexp" target="examples">Regular Expression
     * Example</a>.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "regexp".
     */
    REGEXP("regexp"),
    /**
     * Validate against a regular expression mask, specified as <code>validator.mask</code>. If validation is successful a
     * transformation can also be specified via the <code>validator.transformTo</code> property. This should be set to a string
     * in the standard format for string replacement via the native JavaScript <code>replace()</code> method. <p>See <a
     * href="http://www.smartclient.com/smartgwt/showcase/#form_validation_value_transform" target="examples">Value Transform
     * Example</a>.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "mask".
     */
    MASK("mask"),
    /**
     * Tests whether the value for a date field is within the range specified. Range is inclusive, and is specified via
     * <code>validator.min</code> and <code>validator.max</code>, which should be specified in <a target=_blank
     * href="http://www.w3.org/TR/xmlschema-2/#dateTime">XML Schema date format</a> or as a live JavaScript Date object (for
     * client-only validators only). To specify the range as exclusive of the min/mix values, set <code>exclusive</code> to
     * <code>true</code>. <p> Note that the <code>errorMessage</code> for this validator will be evaluated as a dynamicString -
     * text within <code>&#36;{...}</code> will be evaluated as JS code when the message is displayed, with <code>max</code>
     * and <code>min</code> available as variables mapped to <code>validator.max</code> and <code>validator.min</code>.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "dateRange".
     */
    DATERANGE("dateRange"),
    /**
     * Validate a field as a valid floating point value within a value range. Range is specified via <code>validator.min</code>
     * and <code>validator.max</code>. Also checks precision, specified as number of decimal places in 
     * <code>validator.precision</code>. If <code>validator.roundToPrecision</code> is set  a value that doesn't match the
     * specified number of decimal places will be rounded to the nearest value that does.  <p> For backwards compatibility
     * only. Use "floatRange" and/or "floatPrecision" instead.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "floatLimit".
     */
    FLOATLIMIT("floatLimit"),
    /**
     * Tests whether the value for this field is a floating point number within the range  specified. The <code>max</code> and
     * <code>min</code> properties on the validator are used to determine the acceptable range, inclusive. To specify the range
     * as exclusive of the min/mix values, set <code>exclusive</code> to <code>true</code>. <p> Note that the
     * <code>errorMessage</code> for this validator will be evaluated as a dynamicString - text within <code>&#36;{...}</code>
     * will be evaluated as JS code when the message is displayed, with <code>max</code> and <code>min</code> available as
     * variables mapped to <code>validator.max</code> and <code>validator.min</code>.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "floatRange".
     */
    FLOATRANGE("floatRange"),
    /**
     * Tests whether the value for this field is a floating point number with the  appropriate number of decimal places -
     * specified in <code>validator.precision</code> If the value is of higher precision and
     * <code>validator.roundToPrecision</code>  is specified, the value will be rounded to the specified number of decimal
     * places and validation will pass, otherwise validation will fail.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "floatPrecision".
     */
    FLOATPRECISION("floatPrecision"),
    /**
     * A non-empty value is required for this field to pass validation. <p>In the case of a "binary" field, a non-empty file
     * must be uploaded.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "required".
     */
    REQUIRED("required"),
    /**
     * Change the state/appearance of this field. Desired appearance is specified via the <code>fieldAppearance</code> property
     * on the validator object. See {@link com.smartgwt.client.types.FieldAppearance} type for choices. <p> If
     * <code>fieldAppearance</code> is not specified, the default is "readOnly".
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "readOnly".
     */
    READONLY("readOnly"),
    /**
     * Change the visibility of this field.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "visibility".
     */
    VISIBILITY("visibility"),
    /**
     * Change the enable/disable state of this field.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "enable".
     */
    ENABLE("enable"),
    /**
     * Returns true if the value for this field is unique. The uniqueness check is performed across the whole DataSource unless
     * you specify property <code>validator.criteriaFields</code> as a  comma-separated string of field names; in that case,
     * the uniqueness check is done in the  context of those extra criteria, allowing you to check, for example, whether an
     * employee  number is unique for the department and location found on the record being validated. By default the
     * uniqueness check is not case sensitive but this can be controlled through the {@link
     * com.smartgwt.client.docs.serverds.Validator#caseSensitive caseSensitive} attribute. You can specify the  {@link
     * com.smartgwt.client.data.DataSource#getOperationBindings operation} to use for the uniqueness check with the  {@link
     * com.smartgwt.client.docs.serverds.Validator#operationId operationId} attribute. <p> Validators of this type have 
     * requiresServer  set to <code>true</code> and do not run on the client, unless all of the following are true: <ul> <li>
     * The validation is run in the context of a DataBoundComponent or ValuesManager bound to some DataSource. <li> The
     * DataSource is either clientOnly:true or cacheAllData: true and all data is loaded <li> The item is made available to the
     * validator. Note that the item is not be available during a save performed without a form (eg programmatic save), or if
     * the field is not available in the form. </ul> <p> Note when isUnique validator is executed as part of validation process
     * during update  operation, it will perform uniqueness check only for single row updates. If update targets  {@link
     * com.smartgwt.client.docs.serverds.OperationBinding#allowMultiUpdate multiple records}, then isUnique validator will  be
     * skipped. If uniqueness check is needed when updating multiple records, consider using  {@link
     * com.smartgwt.client.docs.DmiOverview custom DMI} approach to add this check manually. <p>See <a
     * href="http://www.smartclient.com/smartgwtee/showcase/#uniqueCheckValidation"
     * target="examples">uniqueCheckValidation</a>.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "isUnique".
     */
    ISUNIQUE("isUnique"),
    /**
     * Returns true if the record implied by a relation exists. The relation can be  derived automatically from the {@link
     * com.smartgwt.client.data.DataSourceField#getForeignKey DataSourceField.foreignKey} attribute of  the field being
     * validated, or you can specify it manually via  <code>validator.relatedDataSource</code> and
     * <code>validator.relatedField</code>. <p> You can specify at DataSource level that this validator should be automatically
     * applied to all fields that specify a {@link com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} - see
     * {@link com.smartgwt.client.data.DataSource#getValidateRelatedRecords DataSource.validateRelatedRecords}. <p> By default
     * the uniqueness check is not case sensitive but this can be controlled through the {@link
     * com.smartgwt.client.docs.serverds.Validator#caseSensitive caseSensitive} attribute. <p> Validators of this type have 
     * requiresServer  set to <code>true</code> and do not run on the client. <p> Note that this validation is generally
     * unnecessary for data coming from a UI. The  typical UI uses a {@link com.smartgwt.client.widgets.form.fields.SelectItem}
     * or {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem} with an  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource} for user entry, such that the
     * user  can't accidentally enter a related record if that doesn't exist, and a typical SQL  schema will include
     * constraints that prevent a bad insert if the user attempts to  circumvent the UI. The primary purpose of declaring this
     * validation explicitly is  to provide clear, friendly error messages for use cases such as {@link
     * com.smartgwt.client.widgets.BatchUploader},  where values aren't individually chosen by the user. See also the example
     * <a href="http://www.smartclient.com/smartgwtee/showcase/#hasRelatedValidation" target="examples">Related Records</a>.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "hasRelatedRecord".
     */
    HASRELATEDRECORD("hasRelatedRecord"),
    /**
     * This validator type is not for direct usage, instead {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#maxFileSize DataSourceField.maxFileSize} can  be set and
     * <code>maxFileSize</code> validator will be added automatically. Use  {@link
     * com.smartgwt.client.data.DataSource#maxFileSizeExceededMessage maxFileSizeExceededMessage} to customize validation error
     * message. <p> In supported browsers (Internet Explorer 10+, Chrome, Firefox, Safari 6+, Opera 11.1+), returns
     * <code>true</code> if the file(s) selected by the user are not larger than the field's {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#maxFileSize DataSourceField.maxFileSize}. If not supported by the
     * browser, the validator will always return <code>true</code>. <p> Note that server-side enforcement of the
     * <code>maxFileSize</code> is always required because the user's browser might not support client-side file size checks.
     * Also, any client-side check can be bypassed by a malicious user.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "maxFileSize".
     */
    MAXFILESIZE("maxFileSize"),
    /**
     * Custom client-side validator.   Use by creating a subclass of  Custom.CustomValidator and implementing the
     * <code>condition</code> method.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "custom".
     */
    CUSTOM("custom"),
    /**
     * Custom server-side validator that either evaluates the Velocity expression provided in  {@link
     * com.smartgwt.client.docs.serverds.Validator#serverCondition serverCondition} (see <a
     * href="http://www.smartclient.com/smartgwtee/showcase/#validation_velocity" target="examples">Velocity Expression
     * Example</a>) or makes DMI call to {@link com.smartgwt.client.docs.serverds.Validator#serverObject serverObject} to
     * evaluate condition (see <a href="http://www.smartclient.com/smartgwtee/showcase/#validation_dmi" target="examples">DMI
     * Validation Example</a>). <p> Validators of this type have  requiresServer  set to <code>true</code> and do not run on
     * the client.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "serverCustom".
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
