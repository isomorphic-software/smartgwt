
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
 * A validator describes a check that should be performed on a value the user is trying to
 * save.<p>
 * <b>This class is not meant to be created and used, it is actually documentation of settings
 * allowed in a DataSource descriptor (.ds.xml file), for use with Smart GWT Pro Edition and
 * above.
 * See {@link com.smartgwt.client.docs.serverds} for how to use this documentation.</b>
 * <p>
 * <p> Validators are specified for DataSource fields via the {@link
 * com.smartgwt.client.docs.serverds.DataSourceField#validators DataSourceField.validators}
 * property and {@link com.smartgwt.client.docs.ValidatorExecution are executed in the order in
 * which they are defined}. Validators that need not be run on the server can also be specified
 * for a specific {@link com.smartgwt.client.widgets.form.fields.FormItem} or {@link
 * com.smartgwt.client.widgets.grid.ListGridField}. <p> Smart GWT supports a powerful library of
 * {@link com.smartgwt.client.types.ValidatorType ValidatorTypes} which have identical behavior on
 * both the client and the server.   <p>  Beyond this, custom validators can be defined on the
 * client and custom validation logic added on the server.  Note that the <code>regexp</code> and
 * <code>mask</code> validator types are very flexible and can be used to perform virtually any
 * kind of formatting check that doesn't involve some large external dataset. <p> Custom
 * validators can be reused on the client by adding them to the global validator list, via the
 * {@link com.smartgwt.client.widgets.form.validator.Validator#addValidator addValidator()}
 * method.
 * @see com.smartgwt.client.types.ValidatorType
 */
public class Validator {

    /**
     * Applies only to the "isUnique" and "hasRelatedRecord" validators and controls whether the
     * search for existing records is case sensitive or not.
     *
     * <p>Default value is false
     */
    public boolean caseSensitive;

    /**
     * Text to display if the value does not pass this validation check. <P> If unspecified, default
     * error messages exist for all built-in validators, and a generic message will be used for a
     * custom validator that is not passed. <P> Server-side this string evaluates in a Velocity
     * context where the variables $value and $fieldName are available and refer to the supplied value
     * and the field name, respectively. Note that if the validator is intended to run both on the
     * client and server, you shouldn't use these velocity vars as they will not be expanded on the
     * client and the user may then see raw uninterpolated strings.
     *
     * <p>Default value is null
     */
    public String errorMessage;

    /**
     * If true, validator will be validated when each item's "change" handler is fired as well as when
     * the entire form is submitted or validated. If false, this validator will not fire on the item's
     * "change" handler. <p> Note that this property can also be set at the form/grid or field level;
     * If true at any level and not explicitly false on the validator, the validator will be fired on
     * change - displaying errors and rejecting the change on validation failure.
     *
     * <p>Default value is null
     */
    public Boolean validateOnChange;

    /**
     * User-defined list of fields on which this validator depends. Primarily used for validators of
     * type "custom" but can also be used to supplement {@link
     * com.smartgwt.client.docs.serverds.Validator#applyWhen applyWhen} criteria. <P> Note that for
     * validators run on the server, fields required due to <code>dependentFields</code> but not
     * present in the {@link com.smartgwt.client.data.DSRequest#getData DSRequest.data} of an update
     * because they haven't changed will be filled in from the server DataSource.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.Validator#applyWhen
     */
    public String[] dependentFields;

    /**
     * Indicates that if this validator is not passed, the user should not be allowed to exit the
     * field - focus will be forced back into the field until the error is corrected. <p> This
     * property defaults to {@link com.smartgwt.client.widgets.form.fields.FormItem#getStopOnError
     * FormItem.stopOnError} if unset. <p> Enabling this property also implies {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValidateOnExit FormItem.validateOnExit} is
     * automatically enabled. If this is a server-based validator, setting this property also implies
     * that {@link com.smartgwt.client.widgets.form.fields.FormItem#getSynchronousValidation
     * FormItem.synchronousValidation} is forced on.
     *
     * <p>Default value is null
     */
    public Boolean stopOnError;

    /**
     * Used to create a conditional validator based on {@link
     * com.smartgwt.client.docs.serverds.AdvancedCriteria criteria}.
     *  The criteria defines when the validator applies. The form current values or ListGrid record
     *  is used as reference for the criteria. If the criteria match, then the validator will be
     *  processed. Otherwise the validator is skipped and assumed valid.
     *  <p>
     * To use an <code>applyWhen</code> criteria the form or grid must use a {@link
     * com.smartgwt.client.docs.serverds.DataSource}.
     *  <p>
     *  <strong>NOTE:</strong> <code>applyWhen</code> is not supported for "binary" fields.
     *  <p>
     *  <h3>Server and client use</h3>
     *  Conditional validators are enforced both on the server and on the client-side
     *  when defined on a DataSource field as shown in the examples below. Note the
     * <code>applyWhen</code> element is treated as a {@link
     * com.smartgwt.client.docs.serverds.Criterion}.
     *  <pre>
     *  &lt;!-- Normal format --&gt;
     *  &lt;field name="age" type="integer"&gt;
     *    &lt;validators&gt;
     *      &lt;validator type="integerRange" min="0" max="100"&gt;
     *        &lt;applyWhen operator="or"&gt;
     *          &lt;criteria&gt;
     *            &lt;criterion fieldName="restrictAge" operator="equals" value="true"/&gt;
     *            &lt;criterion fieldName="gender" operator="equals" value="female"/&gt;
     *          &lt;/criteria&gt; 
     *        &lt;/applyWhen&gt;
     *      &lt;/validator&gt;
     *    &lt;/validators&gt;
     *  &lt;/field&gt;
     * 
     *  &lt;!-- Conditional requirement --&gt;
     *  &lt;field name="reason" type="text"&gt;
     *    &lt;validators&gt;
     *      &lt;validator type="required"&gt;
     *        &lt;applyWhen fieldName="willAttend" operator="equals" value="false"/&gt;
     *      &lt;/validator&gt;
     *    &lt;/validators&gt;
     *  &lt;/field&gt;
     *  </pre>
     * 
     *  The last example above shows an alternate to the <code>requiredIf</code> validator using a
     * {@link com.smartgwt.client.docs.XmlCriteriaShorthand shorthand format} which is only available
     * for client-side
     *  use. On the client the <code>reason</code> field will change appearance to match other
     *  required or non-required fields when <code>willAttend</code> changes.  Note that using
     *  <code>applyWhen</code> for a validator of type <code>required</code> as in the example may
     *  result in validation request being set to the server where a fetch is made against the
     *  DataSource.  For more details, see the discussion at the end of the
     * {@link com.smartgwt.client.docs.serverds.DataSourceField#required DataSourceField.required}
     * help topic.
     *  <p>
     *  <h3>Component XML and client-only use</h3> 
     * Conditional validators can also be applied to {@link com.smartgwt.client.docs.ComponentXML
     * Component XML}
     *  similarly to provide client-only validations or read-only state management. A common
     *  use case is conditionally displaying or enabling fields. Use the <code>readOnly</code>
     *  validator with an <code>applyWhen</code> value to control the read-only appearance of a
     *  field. The example below shows a field which is hidden when <code>willAttend=true</code>.
     *  <pre>
     *  &lt;!-- field definition within a Component XML DynamicForm --&gt;
     *  &lt;field name="reason" type="text"&gt;
     *    &lt;validators&gt;
     *      &lt;validator type="readOnly" fieldAppearance="hidden"&gt;
     *        &lt;applyWhen fieldName="willAttend" operator="equals" value="true"/&gt;
     *      &lt;/validator&gt;
     *    &lt;/validators&gt;
     *  &lt;/field&gt;
     *  </pre>
     *  <p>
     *  Conditional validators can be applied to DynamicForm or ListGrid fields in 
     *  Java code as well.
     *
     * <p>Default value is null
     */
    public AdvancedCriteria applyWhen;

    /**
     * For validators of type "serverCustom" only: a scriptlet in any supported JSR223 scripting
     *  language which is run in order to see if validation passes.  For example:
     *  <P>
     *  <pre>
     *      &lt;validator type="serverCustom"&gt;
     *          &lt;serverCondition language="groovy"&gt;&lt;![CDATA[
     *              value &lt; dataSources.StockItem.fetchById(record.itemId).quantity
     *          ]]&gt;&lt;/serverCondition&gt;
     *      &lt;/validator&gt;
     *  </pre>
     *  The scriptlet should return a boolean true or false value - failing to return a value will
     *  be considered a false result (validator failed).  If your expression is syntactically
     *  invalid, an exception is thrown and the error message is displayed in the client.
     *  <P>
     * See {@link com.smartgwt.client.docs.ServerScript} for general information on Server Scripting
     * and JSR223, and
     * {@link com.smartgwt.client.docs.VelocitySupport} for general information on Velocity support,
     * and also see below
     *  for special rules for Velocity.
     *  <P>
     *  <b>Available variables</b>
     *  The following variables are available in a <code>serverCondition</code>:
     *  <ul>
     *  <li><b>dataSource</b> - The current DataSource</li>
     *  <li><b>record</b> - Other submitted values part of the same update</li>
     *  <li><b>value</b> - The value of the field</li>
     *  <li><b>validator</b> - The config of this validator, including all attributes declared on
     *                         the &lt;validator&gt; tag, presented as a <code>Map</code></li>
     *  <li><b>field</b> - The field (as a <code>DSField</code> object)</li>
     *  </ul>
     *  Note that "record" will contain only other values submitted at the same time, not the
     *  complete DataSource record.  For most types of cross-field validation, you should fetch the
     *  current saved record using the server-side API DataSource.fetchById().  For example, in
     *  Velocity:
     *  <pre>
     *      $dataSource.fetchById($record.<i>primaryKeyField</i>).otherFieldName
     *  </pre>
     *  Note that, while a DSRequest provides dsRequest.oldValues, these values cannot be relied
     *  upon for a security check since they could be faked.
     *  <P>
     *  Server-side custom validators also have access to the standard set of context variables that
     *  come from the Servlet API.  However, be aware that if you write conditions that depend upon 
     *  these variables, you preclude your Validator from being used in the widest possible variety 
     *  of circumstances; for example, in a command-line process.  Rather, it will be tied to 
     *  operating in the context of, say, an <code>HttpSession</code>.  
     *  <P>
     *  Given the above caveat, the following context variables are also available:
     *  <ul>
     *  <li><b>servletRequest</b> - The associated <code>HttpServletRequest</code></li>
     *  <li><b>session</b> - The associated <code>HttpSession</code></li>
     *  <li><b>httpParameters</b> - This variable gives you access to the parameters <code>Map</code>
     *          of the associated <code>HttpServletRequest</code>; it is an alternate form of 
     *          <code>$servletRequest.getParameter</code></li>
     * <li><b>requestAttributes</b> - This variable gives you access to the attributes
     * <code>Map</code> 
     *          of the associated <code>HttpServletRequest</code>; it is an alternate form of 
     *          <code>$servletRequest.getAttribute</code></li>
     * <li><b>sessionAttributes</b> - This variable gives you access to the attributes
     * <code>Map</code> 
     *          of the associated <code>HttpSession</code>; it is an alternate form of 
     *          <code>$session.getAttribute</code></li>
     *  </ul>
     *  <P>
     *  <b>Special considerations for Velocity</b>
     *  <P>
     *  To return a true or false value in Velocity, you script can either be just an expression
     *  that returns a boolean value, or the result of evaluating the Velocity template can result
     *  in output of "true" or "false".  All of the following are valid forms:
     *  <p><code>
     *  &nbsp;&nbsp;$value &lt; 100<br>
     *  &nbsp;&nbsp;$util.contains($value, "some string")<br>
     * &nbsp;&nbsp;$record.someField</code>(assuming that "someField" contains a boolean
     * value)<code><br>
     *  &nbsp;&nbsp;$value &gt; $record.otherField</code>
     *  <P>
     *  For additional troubleshooting information when Velocity expressions aren't working as
     *  expected, set the log category org.apache.Velocity to DEBUG in log4j.isc.config.xml.
     *  <P>
     *  Because it's tricky to call arbitrary Java methods in Velocity, the following special
     *  objects are passed to Velocity for convenience:
     *  <ul>
     *  <li><b>dataSources</b> - The list of all DataSources, accessible by name (so, for example, 
     *      <code>$dataSources.supplyItem</code> refers to the <code>supplyItem</code> DataSource
     *      object).</li>
     *  <li><b>util</b> - A <code>com.isomorphic.util.DataTools</code> object, giving you access to
     *                all of that class's useful helper functions</li>
     *  </ul>
     *
     * <p>Default value is null
     */
    public String serverCondition;

    /**
     * Normally, all validators defined for a field will be run  {@link
     * com.smartgwt.client.docs.ValidatorExecution in the order in which they are defined}  even if
     * one of the validators has already failed.  However, if <code>stopIfFalse</code> is set,
     * validation will not proceed beyond this validator if the check fails. <P> This is useful to
     * prevent expensive validators from being run unnecessarily, or to allow custom validators that
     * don't need to be robust about handling every conceivable type of value.
     *
     * <p>Default value is false
     */
    public Boolean stopIfFalse;

    /**
     * When set to true, values that equal the specified {@link
     * com.smartgwt.client.docs.serverds.Validator#min min} or  {@link
     * com.smartgwt.client.docs.serverds.Validator#max max} values will fail validation.  When setting
     * this property, consider also adding a {@link
     * com.smartgwt.client.docs.serverds.Validator#errorMessage custom message}.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.Validator#min
     * @see com.smartgwt.client.docs.serverds.Validator#max
     */
    public Boolean exclusive;

    /**
     * Type of the validator. <p> This can be one of the built-in {@link
     * com.smartgwt.client.types.ValidatorType}, the string "custom" to define a custom validator, or
     * the string "serverCustom" to define a server-only custom validator.
     *
     * <p>Default value is null
     */
    public ValidatorType type;

    /**
     * Indicates this validator runs on the server only.
     *
     * <p>Default value is null
     */
    public Boolean serverOnly;

    /**
     * Indicates this validator runs on the client only. <p> Normally, if the server is trying to run
     * validators and finds a validator that it can't execute, for safety reasons validation is
     * considered to have failed.  Use this flag to explicitly mark a validator that only needs to run
     * on the client.
     *
     * <p>Default value is false
     */
    public Boolean clientOnly;

    /**
     * For a validator that is not a built-in {@link com.smartgwt.client.types.ValidatorType}, a
     * {@link com.smartgwt.client.docs.Callback}, 
     *  function, or JavaScript expression to evaluate to see if this validator passes or fails.
     *  <p>
     *  Because the validator declaration itself is passed as a parameter to
     *  <code>condition()</code>, you can effectively parameterize the validator.  For example, to
     *  create a validator that checks that the value is after a certain date:<pre> 
     *      { type:"custom", afterDate:new Date(), 
     *        condition:"value.getTime() > validator.afterDate.getTime()" }
     *  </pre>
     *  Reusable validators, like the above, can be registered as a standard validatorType by
     * calling {@link com.smartgwt.client.widgets.form.validator.Validator#addValidator
     * addValidator()}.
     *  <P>
     * Note that, if a field is declared with a builtin {@link com.smartgwt.client.types.FieldType},
     * the value passed in
     *  will already have been converted to the specified type, if possible.
     *  <p>
     *  For the required parameters, see the documentation for
     *   ValidatorConditionCallback.
     *
     * <p>Default value is null
     */
    public StringMethod condition;

    /**
     * Indicates the minimum value for range-based validators. By default, range-validators are 
     * inclusive, meaning that values that equal the <code>min</code> value will pass validation.   To
     * make a validator-range exclusive, and have equal values fail validation, set  {@link
     * com.smartgwt.client.docs.serverds.Validator#exclusive validator.exclusive} to true and provide
     * a  {@link com.smartgwt.client.docs.serverds.Validator#errorMessage custom message}.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.Validator#max
     * @see com.smartgwt.client.docs.serverds.Validator#exclusive
     */
    public Object min;

    /**
     * For validators of type "serverCustom" only, a {@link
     * com.smartgwt.client.docs.serverds.ServerObject} declaration that allows
     *  the Smart GWT Server to find a Java class via a variety of possible approaches, and call a
     *  method on it to perform validation.
     *  <P>
     *  The target object must implement a method whose first 4 arguments are:
     *  <code>
     *     Object value, Validator validator, String fieldName, Map record
     *  </code><p>
     *  (<code>com.isomorphic.datasource.Validator</code> is a subclass of <code>Map</code> that 
     *  represents a validator's configuration, and also provides APIs for implementing templated
     *  error messages).<p>
     *  You provide the name of the method to call by specifying 
     *  {@link com.smartgwt.client.docs.serverds.ServerObject#methodName methodName}
     *  as part of the serverObject declaration.  If you do not specify a methodName, Smart GWT 
     *  expects to find a compliant method called "condition".
     *  <P>
     *  Additional arguments may be declared and are automatically supplied based on the declared
     * argument type, via {@link com.smartgwt.client.docs.DmiOverview DMI}.  Available objects
     * include:
     *  <ul>
     *  <li><b>DataSource</b> - the DataSource where this validator is declared, an instance of
     *                          com.isomorphic.datasource.DataSource or a subclass</li>
     *  <li><b>HttpServletRequest</b> - from standard Java servlets API</li>
     *  <li><b>HttpServletResponse</b> - from standard Java servlets API</li>
     *  <li><b>ServletContext</b> - from standard Java servlets API</li>
     *  <li><b>HttpSession</b> - from standard Java servlets API</li>
     *  <li><b>RequestContext</b> - an instance of com.isomorphic.servlet.RequestContext</li>
     *  <li><b>RPCManager</b> - the RPCManager associated with the transaction this validation is 
     *                          part of; an instance of com.isomorphic.rpc.RPCManager</li>
     * <li><b>DSRequest</b> - the DSRequest this validation is part of; an instance of
     * com.isomorphic.datasource.DSRequest</li>
     * <li><b>DSField</b> - the datasource field which value is validated; an instance of
     * com.isomorphic.datasource.DSField</li>
     * <li><b>ValidationContext</b> - the context where value is validated; an instance of
     * com.isomorphic.datasource.ValidationContext</li>
     *  </ul>
     *  Note that any servlet-related objects will not be available if your validator is run outside
     *  of the scope of an HTTP servlet request, such as a command-line process.
     *  <p>
     *  Note that "record" will contain only other values submitted at the same time, not the
     *  complete DataSource record.  For most types of cross-field validation, you should fetch the
     *  current saved record.  For example:
     *  <pre>
     *      final Map<String, Object> existingRecord = dataSource.fetchById(record);
     *  </pre>
     *
     * <p>Default value is null
     */
    public ServerObject serverObject;

    /**
     * Applies only to the "isUnique" validator; allows you to name a specific  {@link
     * com.smartgwt.client.docs.serverds.DataSource#operationBindings operation} for the server-side
     * uniqueness check. Ignored on the client.
     *
     * <p>Default value is null
     */
    public String operationId;

    /**
     * Indicates the maximum value for range-based validators. By default, range-validators are 
     * inclusive, meaning that values that equal the <code>max</code> value will pass validation.   To
     * make a validator-range exclusive, and have equal values fail validation, set  {@link
     * com.smartgwt.client.docs.serverds.Validator#exclusive validator.exclusive} to true and provide
     * a  {@link com.smartgwt.client.docs.serverds.Validator#errorMessage custom message}.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.Validator#min
     * @see com.smartgwt.client.docs.serverds.Validator#exclusive
     */
    public Object max;

}
