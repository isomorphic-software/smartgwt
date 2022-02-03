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
 
package com.smartgwt.client.widgets.form.validator;


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
 * A validator describes a check that should be performed on a value the user is trying to save. <p> Validators are
 * specified for DataSource fields via the {@link com.smartgwt.client.data.DataSourceField#getValidators
 * DataSourceField.validators} property.  Validators that need not be run on the server can also be specified for a
 * specific {@link com.smartgwt.client.widgets.form.fields.FormItem} or {@link
 * com.smartgwt.client.widgets.grid.ListGridField}. <p> Smart GWT supports a powerful library of {@link
 * com.smartgwt.client.types.ValidatorType ValidatorTypes} which have identical behavior on both the client and the server.
 * <p>  Beyond this, custom validators can be defined on the client and custom validation logic added on the server.  Note
 * that the <code>regexp</code> and <code>mask</code> validator types are very flexible and can be used to perform
 * virtually any kind of formatting check that doesn't involve some large external dataset. <p> Custom validators can be
 * reused on the client by adding them to the global validator list, via the {@link
 * com.smartgwt.client.widgets.form.validator.Validator#addValidator addValidator()} method.
 * @see com.smartgwt.client.types.ValidatorType
 */
@BeanFactory.FrameworkClass
public class Validator extends DataClass {

    public static Validator getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new Validator(jsObj);
    }
        


    public Validator(){
        
    }

    public Validator(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Used to create a conditional validator based on {@link com.smartgwt.client.data.AdvancedCriteria criteria}.
     *  The criteria defines when the validator applies. The form current values or ListGrid record
     *  is used as reference for the criteria. If the criteria match, then the validator will be
     *  processed. Otherwise the validator is skipped and assumed valid.
     *  <p>
     *  To use an <code>applyWhen</code> criteria the form or grid must use a {@link com.smartgwt.client.data.DataSource}.
     *  <p>
     *  <strong>NOTE:</strong> <code>applyWhen</code> is not supported for "binary" fields.
     *  <p>
     *  <h3>Server and client use</h3>
     *  Conditional validators are enforced both on the server and on the client-side
     *  when defined on a DataSource field as shown in the examples below. Note the
     *  <code>applyWhen</code> element is treated as a {@link com.smartgwt.client.data.Criterion}.
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
     *  {@link com.smartgwt.client.docs.XmlCriteriaShorthand shorthand format} which is only available for client-side
     *  use. On the client the <code>reason</code> field will change appearance to match other
     *  required or non-required fields when <code>willAttend</code> changes.  Note that using
     *  <code>applyWhen</code> for a validator of type <code>required</code> as in the example may
     *  result in validation request being set to the server where a fetch is made against the
     *  DataSource.  For more details, see the discussion at the end of the
     *  {@link com.smartgwt.client.data.DataSourceField#getRequired DataSourceField.required} help topic.
     *  <p>
     *  <h3>Component XML and client-only use</h3> 
     *  Conditional validators can also be applied to {@link com.smartgwt.client.docs.ComponentXML Component XML}
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
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param applyWhen New applyWhen value. Default value is null
     */
    public void setApplyWhen(AdvancedCriteria applyWhen) {
        if (applyWhen instanceof Criterion) {
            applyWhen.setAttribute("_constructor", "AdvancedCriteria");
        }
        setAttribute("applyWhen", applyWhen == null ? null : applyWhen.getJsObj());
    }

    /**
     * Used to create a conditional validator based on {@link com.smartgwt.client.data.AdvancedCriteria criteria}.
     *  The criteria defines when the validator applies. The form current values or ListGrid record
     *  is used as reference for the criteria. If the criteria match, then the validator will be
     *  processed. Otherwise the validator is skipped and assumed valid.
     *  <p>
     *  To use an <code>applyWhen</code> criteria the form or grid must use a {@link com.smartgwt.client.data.DataSource}.
     *  <p>
     *  <strong>NOTE:</strong> <code>applyWhen</code> is not supported for "binary" fields.
     *  <p>
     *  <h3>Server and client use</h3>
     *  Conditional validators are enforced both on the server and on the client-side
     *  when defined on a DataSource field as shown in the examples below. Note the
     *  <code>applyWhen</code> element is treated as a {@link com.smartgwt.client.data.Criterion}.
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
     *  {@link com.smartgwt.client.docs.XmlCriteriaShorthand shorthand format} which is only available for client-side
     *  use. On the client the <code>reason</code> field will change appearance to match other
     *  required or non-required fields when <code>willAttend</code> changes.  Note that using
     *  <code>applyWhen</code> for a validator of type <code>required</code> as in the example may
     *  result in validation request being set to the server where a fetch is made against the
     *  DataSource.  For more details, see the discussion at the end of the
     *  {@link com.smartgwt.client.data.DataSourceField#getRequired DataSourceField.required} help topic.
     *  <p>
     *  <h3>Component XML and client-only use</h3> 
     *  Conditional validators can also be applied to {@link com.smartgwt.client.docs.ComponentXML Component XML}
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
     * @return Current applyWhen value. Default value is null
     */
    public AdvancedCriteria getApplyWhen()  {
        return new AdvancedCriteria(getAttributeAsJavaScriptObject("applyWhen"));
    }
    
    

    /**
     * Indicates this validator runs on the client only. <p> Normally, if the server is trying to run validators and finds a
     * validator that it can't execute, for safety reasons validation is considered to have failed.  Use this flag to
     * explicitly mark a validator that only needs to run on the client.
     *
     * @param clientOnly New clientOnly value. Default value is false
     */
    public void setClientOnly(Boolean clientOnly) {
        setAttribute("clientOnly", clientOnly);
    }

    /**
     * Indicates this validator runs on the client only. <p> Normally, if the server is trying to run validators and finds a
     * validator that it can't execute, for safety reasons validation is considered to have failed.  Use this flag to
     * explicitly mark a validator that only needs to run on the client.
     *
     * @return Current clientOnly value. Default value is false
     */
    public Boolean getClientOnly()  {
        Boolean result = getAttributeAsBoolean("clientOnly", true);
        return result == null ? false : result;
    }
    

    /**
     * For a validator that is not a built-in {@link com.smartgwt.client.types.ValidatorType}, a {@link
     * com.smartgwt.client.docs.Callback}, 
     *  function, or JavaScript expression to evaluate to see if this validator passes or fails.
     *  <p>
     *  Because the validator declaration itself is passed as a parameter to
     *  <code>condition()</code>, you can effectively parameterize the validator.  For example, to
     *  create a validator that checks that the value is after a certain date:<pre> 
     *      { type:"custom", afterDate:new Date(), 
     *        condition:"value.getTime() > validator.afterDate.getTime()" }
     *  </pre>
     *  Reusable validators, like the above, can be registered as a standard validatorType by
     *  calling {@link com.smartgwt.client.widgets.form.validator.Validator#addValidator addValidator()}.
     *  <P>
     *  Note that, if a field is declared with a builtin {@link com.smartgwt.client.types.FieldType}, the value passed in
     *  will already have been converted to the specified type, if possible.
     *  <p>
     *  For the required parameters, see the documentation for
     *   ValidatorConditionCallback.
     *
     * @param condition New condition value. Default value is null
     * @see com.smartgwt.client.docs.StringMethod StringMethod 
     */
    public void setCondition(String condition) {
        setAttribute("condition", condition);
    }

    /**
     * For a validator that is not a built-in {@link com.smartgwt.client.types.ValidatorType}, a {@link
     * com.smartgwt.client.docs.Callback}, 
     *  function, or JavaScript expression to evaluate to see if this validator passes or fails.
     *  <p>
     *  Because the validator declaration itself is passed as a parameter to
     *  <code>condition()</code>, you can effectively parameterize the validator.  For example, to
     *  create a validator that checks that the value is after a certain date:<pre> 
     *      { type:"custom", afterDate:new Date(), 
     *        condition:"value.getTime() > validator.afterDate.getTime()" }
     *  </pre>
     *  Reusable validators, like the above, can be registered as a standard validatorType by
     *  calling {@link com.smartgwt.client.widgets.form.validator.Validator#addValidator addValidator()}.
     *  <P>
     *  Note that, if a field is declared with a builtin {@link com.smartgwt.client.types.FieldType}, the value passed in
     *  will already have been converted to the specified type, if possible.
     *  <p>
     *  For the required parameters, see the documentation for
     *   ValidatorConditionCallback.
     *
     * @return Current condition value. Default value is null
     * @see com.smartgwt.client.docs.StringMethod StringMethod 
     */
    public String getCondition()  {
        return getAttributeAsString("condition");
    }
    

    /**
     * User-defined list of fields on which this validator depends. Primarily used for validators of type "custom" but can also
     * be used to supplement {@link com.smartgwt.client.widgets.form.validator.Validator#getApplyWhen applyWhen} criteria. <P>
     * Note that for validators run on the server, fields required due to <code>dependentFields</code> but not present in the
     * {@link com.smartgwt.client.data.DSRequest#getData DSRequest.data} of an update because they haven't changed will be
     * filled in from the server DataSource.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param dependentFields New dependentFields value. Default value is null
     * @see com.smartgwt.client.widgets.form.validator.Validator#setApplyWhen
     */
    public void setDependentFields(String[] dependentFields) {
        setAttribute("dependentFields", dependentFields);
    }

    /**
     * User-defined list of fields on which this validator depends. Primarily used for validators of type "custom" but can also
     * be used to supplement {@link com.smartgwt.client.widgets.form.validator.Validator#getApplyWhen applyWhen} criteria. <P>
     * Note that for validators run on the server, fields required due to <code>dependentFields</code> but not present in the
     * {@link com.smartgwt.client.data.DSRequest#getData DSRequest.data} of an update because they haven't changed will be
     * filled in from the server DataSource.
     *
     * @return Current dependentFields value. Default value is null
     * @see com.smartgwt.client.widgets.form.validator.Validator#getApplyWhen
     */
    public String[] getDependentFields()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("dependentFields"));
    }
    

    /**
     * Text to display if the value does not pass this validation check. <P> If unspecified, default error messages exist for
     * all built-in validators, and a generic message will be used for a custom validator that is not passed.
     *
     * @param errorMessage New errorMessage value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_dep_conditionally" target="examples">Conditionally Required Example</a>
     */
    public void setErrorMessage(String errorMessage) {
        setAttribute("errorMessage", errorMessage);
    }
    
    
    
    
    
    

    /**
     * Normally, all validators defined for a field will be run even if one of the validators has already failed.  However, if
     * <code>stopIfFalse</code> is set, validation will not proceed beyond this validator if the check fails. <P> This is
     * useful to prevent expensive validators from being run unnecessarily, or to allow custom validators that don't need to be
     * robust about handling every conceivable type of value.
     *
     * @param stopIfFalse New stopIfFalse value. Default value is false
     */
    public void setStopIfFalse(Boolean stopIfFalse) {
        setAttribute("stopIfFalse", stopIfFalse);
    }

    /**
     * Normally, all validators defined for a field will be run even if one of the validators has already failed.  However, if
     * <code>stopIfFalse</code> is set, validation will not proceed beyond this validator if the check fails. <P> This is
     * useful to prevent expensive validators from being run unnecessarily, or to allow custom validators that don't need to be
     * robust about handling every conceivable type of value.
     *
     * @return Current stopIfFalse value. Default value is false
     */
    public Boolean getStopIfFalse()  {
        Boolean result = getAttributeAsBoolean("stopIfFalse", true);
        return result == null ? false : result;
    }
    

    /**
     * Indicates that if this validator is not passed, the user should not be allowed to exit the field - focus will be forced
     * back into the field until the error is corrected. <p> This property defaults to {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getStopOnError FormItem.stopOnError} if unset. <p> Enabling this
     * property also implies {@link com.smartgwt.client.widgets.form.fields.FormItem#getValidateOnExit FormItem.validateOnExit}
     * is automatically enabled. If this is a server-based validator, setting this property also implies that {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getSynchronousValidation FormItem.synchronousValidation} is forced on.
     *
     * @param stopOnError New stopOnError value. Default value is null
     */
    public void setStopOnError(Boolean stopOnError) {
        setAttribute("stopOnError", stopOnError);
    }

    /**
     * Indicates that if this validator is not passed, the user should not be allowed to exit the field - focus will be forced
     * back into the field until the error is corrected. <p> This property defaults to {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getStopOnError FormItem.stopOnError} if unset. <p> Enabling this
     * property also implies {@link com.smartgwt.client.widgets.form.fields.FormItem#getValidateOnExit FormItem.validateOnExit}
     * is automatically enabled. If this is a server-based validator, setting this property also implies that {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getSynchronousValidation FormItem.synchronousValidation} is forced on.
     *
     * @return Current stopOnError value. Default value is null
     */
    public Boolean getStopOnError()  {
        return getAttributeAsBoolean("stopOnError", true);
    }
    

    /**
     * Type of the validator. <p> This can be one of the built-in {@link com.smartgwt.client.types.ValidatorType}, the string
     * "custom" to define a custom validator, or the string "serverCustom" to define a server-only custom validator.
     *
     * @param type New type value. Default value is null
     */
    public void setType(ValidatorType type) {
        setAttribute("type", type == null ? null : type.getValue());
    }

    /**
     * Type of the validator. <p> This can be one of the built-in {@link com.smartgwt.client.types.ValidatorType}, the string
     * "custom" to define a custom validator, or the string "serverCustom" to define a server-only custom validator.
     *
     * @return Current type value. Default value is null
     */
    public ValidatorType getType()  {
        return EnumUtil.getEnum(ValidatorType.values(), getAttribute("type"));
    }

    /**
     * Type of the validator. <p> This can be one of the built-in {@link com.smartgwt.client.types.ValidatorType}, the string
     * "custom" to define a custom validator, or the string "serverCustom" to define a server-only custom validator.
     *
     * @param type New type value. Default value is null
     */
    public void setType(String type) {
        setAttribute("type", type);
    }

    /**
     * Type of the validator. <p> This can be one of the built-in {@link com.smartgwt.client.types.ValidatorType}, the string
     * "custom" to define a custom validator, or the string "serverCustom" to define a server-only custom validator.
     *
     * @return Current type value. Default value is null
     */
    public String getTypeAsString()  {
        return getAttributeAsString("type");
    }
    

    /**
     * If true, validator will be validated when each item's "change" handler is fired as well as when the entire form is
     * submitted or validated. If false, this validator will not fire on the item's "change" handler. <p> Note that this
     * property can also be set at the form/grid or field level; If true at any level and not explicitly false on the
     * validator, the validator will be fired on change - displaying errors and rejecting the change on validation failure.
     *
     * @param validateOnChange New validateOnChange value. Default value is null
     */
    public void setValidateOnChange(Boolean validateOnChange) {
        setAttribute("validateOnChange", validateOnChange);
    }

    /**
     * If true, validator will be validated when each item's "change" handler is fired as well as when the entire form is
     * submitted or validated. If false, this validator will not fire on the item's "change" handler. <p> Note that this
     * property can also be set at the form/grid or field level; If true at any level and not explicitly false on the
     * validator, the validator will be fired on change - displaying errors and rejecting the change on validation failure.
     *
     * @return Current validateOnChange value. Default value is null
     */
    public Boolean getValidateOnChange()  {
        return getAttributeAsBoolean("validateOnChange", true);
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************





	/**
     * A Validator shouldn't be created directly. Instead pass Properties as each Validator in {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValidators FormItem.validators} or wherever a Validator is needed.
     */
    public static native void create() /*-{
        $wnd.isc.Validator.create();
    }-*/;


    // ***********************************************************


   
    /**
     * Register a new standard validator type for reuse, by name. The validator passed in should
     * be of type {@link com.smartgwt.client.types.ValidatorType#CUSTOM}.
     * <P>
     * Any new validator where {@link #setType(String)} is set to the registered
     * name will pick up all properties (error message, condition, etc)
     * from this validator definition.
     *
     * @param name name under which validator properties will be available
     * @param validator validator containing standard properties for reuse
     */
    public native static void addValidatorDefinition (String name, Validator validator) /*-{
		if (validator == null) return;
		var jsValidator = validator.@com.smartgwt.client.widgets.form.validator.Validator::getJsObj()();
		      if (jsValidator.errorMessage != null) {
             jsValidator.defaultErrorMessage = jsValidator.errorMessage;
             jsValidator.errorMessage = null;
        }
		$wnd.isc.Validator.addValidatorDefinition(name, jsValidator);
	}-*/;


}
