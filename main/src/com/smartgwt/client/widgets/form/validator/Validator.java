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
 
package com.smartgwt.client.widgets.form.validator;



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
 * A validator describes a check that should be performed on a value the user is trying to save. <p> Validators are
 * specified for DataSource fields via the {@link com.smartgwt.client.data.DataSourceField#getValidators validators}
 * property.  Validators that need not be run on the server can also be specified for a specific {@link
 * com.smartgwt.client.widgets.form.fields.FormItem} or {@link com.smartgwt.client.widgets.grid.ListGridField}. <p> Smart
 * GWT supports a powerful library of {@link com.smartgwt.client.types.ValidatorType ValidatorTypes} which have identical
 * behavior on both the client and the server.   <p>  Beyond this, custom validators can be defined on the client and
 * custom validation logic added on the server.  Note that the <code>regexp</code> and <code>mask</code> validator types
 * are very flexible and can be used to perform virtually any kind of formatting check that doesn't involve some large
 * external dataset. <p> Custom validators can be reused on the client by adding them to the global validator list, via the
 * {@link com.smartgwt.client.widgets.form.validator.Validator#addValidator Validator.addValidator} method.
 * @see com.smartgwt.client.types.ValidatorType
 */
public class Validator extends DataClass {

    public static Validator getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new Validator(jsObj);
    }

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }


    public Validator(){
        
    }

    public Validator(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }

    // ********************* Properties / Attributes ***********************

    /**
     * Indicates this validator runs on the client only. <p> Normally, if the server is trying to run validators and finds a
     * validator that it can't execute, for safety reasons validation is considered to have failed.  Use this flag to
     * explicitly mark a validator that only needs to run on the client.
     *
     * @param clientOnly clientOnly Default value is false
     */
    public void setClientOnly(Boolean clientOnly) {
        setAttribute("clientOnly", clientOnly);
    }

    /**
     * Indicates this validator runs on the client only. <p> Normally, if the server is trying to run validators and finds a
     * validator that it can't execute, for safety reasons validation is considered to have failed.  Use this flag to
     * explicitly mark a validator that only needs to run on the client.
     *
     *
     * @return Boolean
     */
    public Boolean getClientOnly()  {
        return getAttributeAsBoolean("clientOnly");
    }

    /**
     * Normally, all validators defined for a field will be run even if one of the validators has already failed.  However, if
     * <code>stopIfFalse</code> is set, validation will not proceed beyond this validator if the check fails. <P> This is
     * useful to prevent expensive validators from being run unnecessarily, or to allow custom validators that don't need to be
     * robust about handling every conceivable type of value.
     *
     * @param stopIfFalse stopIfFalse Default value is false
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
     *
     * @return Boolean
     */
    public Boolean getStopIfFalse()  {
        return getAttributeAsBoolean("stopIfFalse");
    }

    /**
     * Indicates that if this validator is not passed, the user should not be allowed to exit the field - focus will be forced
     * back into the field until the error is corrected. <p> This property defaults to {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getStopOnError stopOnError} if unset. <p> Enabling this property also
     * implies {@link com.smartgwt.client.widgets.form.fields.FormItem#getValidateOnExit validateOnExit} is automatically
     * enabled. If this is a server-based validator, setting this property also implies that {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getSynchronousValidation synchronousValidation} is forced on.
     *
     * @param stopOnError stopOnError Default value is null
     */
    public void setStopOnError(Boolean stopOnError) {
        setAttribute("stopOnError", stopOnError);
    }

    /**
     * Indicates that if this validator is not passed, the user should not be allowed to exit the field - focus will be forced
     * back into the field until the error is corrected. <p> This property defaults to {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getStopOnError stopOnError} if unset. <p> Enabling this property also
     * implies {@link com.smartgwt.client.widgets.form.fields.FormItem#getValidateOnExit validateOnExit} is automatically
     * enabled. If this is a server-based validator, setting this property also implies that {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getSynchronousValidation synchronousValidation} is forced on.
     *
     *
     * @return Boolean
     */
    public Boolean getStopOnError()  {
        return getAttributeAsBoolean("stopOnError");
    }

    /**
     * If true, validator will be validated when each item's "change" handler is fired as well as when the entire form is
     * submitted or validated. If false, this validator will not fire on the item's "change" handler. <p> Note that this
     * property can also be set at the form/grid or field level; If true at any level and not explicitly false on the
     * validator, the validator will be fired on change - displaying errors and rejecting the change on validation failure.
     *
     * @param validateOnChange validateOnChange Default value is null
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
     *
     * @return Boolean
     */
    public Boolean getValidateOnChange()  {
        return getAttributeAsBoolean("validateOnChange");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
        
    // ***********************************************************        


    /**
     * Text to display if the value does not pass this validation check. <P> If unspecified, default error messages
     * exist for all built-in validators, and a generic message will be used for a custom validator that is not passed.
     *
     * @param errorMessage errorMessage Default value is null
     */
    public void setErrorMessage(String errorMessage) {
        setAttribute("errorMessage", errorMessage);
    }
    

    /**
     * User-defined list of fields on which this validator depends. Primarily used for validators of type "custom" but can also
     * be used to supplement {@link com.smartgwt.client.widgets.form.validator.Validator#getApplyWhen applyWhen} criteria.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param dependentFields dependentFields Default value is null
     */
    public void setDependentFields(String[] dependentFields) {
        setAttribute("dependentFields", dependentFields);
    }

    /**
     * User-defined list of fields on which this validator depends. Primarily used for validators of type "custom" but can also
     * be used to supplement {@link com.smartgwt.client.widgets.form.validator.Validator#getApplyWhen applyWhen} criteria.
     *
     *
     * @return dependent fields
     */
    public String[] getDependentFields()  {
        return getAttributeAsStringArray("dependentFields");
    }
    
    public static Validator[] convertToValidatorArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new Validator[]{};
        }
        if (JSOHelper.isArray(nativeArray)) {
            JavaScriptObject[] componentsj = JSOHelper.toArray(nativeArray);
            Validator[] objects = new Validator[componentsj.length];
            for (int i = 0; i < componentsj.length; i++) {
                JavaScriptObject componentJS = componentsj[i];
                objects[i] = Validator.getOrCreateRef(componentJS);
            }
            return objects;
        } else {
            Validator[] ret = new Validator[1];
            ret[0] = Validator.getOrCreateRef(nativeArray);
            return ret;
        }
    }

    /**
     * Type of the validator. This can be one of the built-in
     *  {@link com.smartgwt.client.types.ValidatorType}. Note that a validator of type
     *  <i>ValidatorType.CUSTOM</i> may be used to support custom validation behavior.
     * @param type validator type
     */
    public void setType(ValidatorType type) {
        setAttribute("type", type.getValue());
    }
    
    /**
     * Type of the validator defined as a String.
     * <p> This API may be used to specify a custom validator type registered via 
     * {@link #addValidatorDefinition(String, Validator)}.
     * 
     * @param type validator type
     */
    public void setType(String type) {
        setAttribute("type", type);
    }
    
    /**
     * Built-in type of the validator as specified via {@link #setType(ValidatorType)}
     * <p> 
     * Note that if a custom validator type was specified via {@link #setType(String)} this
     * method will return null - use {@link #getTypeAsString()} to retrieve custom validator
     * types.
     *
     * @return ValidatorType
     */
    public ValidatorType getType()  {
        return EnumUtil.getEnum(ValidatorType.values(), getAttribute("type"));
    }
    
    /**
     * Type of the validator as a string value. If type was specified via {@link #setType(ValidatorType)}
     * this method will return the underlying value of the ValidatorType enum. If type was
     * specified via {@link #setType(String)} the specified string will be returned.
     *
     * @return ValidatorType
     */   
    public String getTypeAsString() {
    	return getAttribute("type");
    }
    
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



