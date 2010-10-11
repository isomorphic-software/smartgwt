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

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

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

    public Validator(){
        
    }

    public Validator(JavaScriptObject jsObj){
        super(jsObj);
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
     * Type of the validator. <p> This can be one of the built-in {@link com.smartgwt.client.types.ValidatorType}, the string
     * "custom" to define a custom validator, or the string "serverCustom" to define a server-only custom validator.
     *
     * @param type type Default value is null
     */
    public void setType(ValidatorType type) {
        setAttribute("type", type.getValue());
    }

    /**
     * Type of the validator. <p> This can be one of the built-in {@link com.smartgwt.client.types.ValidatorType}, the string
     * "custom" to define a custom validator, or the string "serverCustom" to define a server-only custom validator.
     *
     *
     * @return ValidatorType
     */
    public ValidatorType getType()  {
        return EnumUtil.getEnum(ValidatorType.values(), getAttribute("type"));
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


}



