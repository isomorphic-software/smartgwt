/*
 * Isomorphic SmartClient
 * Version 7.0beta3 (2008-12-31)
 * Copyright(c) 1998-2007 Isomorphic Software, Inc. All rights reserved.
 * "SmartClient" is a trademark of Isomorphic Software, Inc.
 *
 * licensing@smartclient.com
 *
 * http://smartclient.com/license
 */

 





//-------------------------------
// Field Validation functions
//-------------------------------

// Define Validators class for docs
//> @class Validator
// A validator describes a check that should be performed on a value the user is trying to
// save.
// <p>
// Validators are specified for DataSource fields via the +link{attr:DataSourceField.validators}
// property.  Validators that need not be run on the server can also be specified for a
// specific +link{class:FormItem} or +link{class:ListGridField}.
// <p>
// ISC supports a powerful library of +link{class:ValidatorTypes} which have identical behavior
// on both the client and the server.  
// <p> 
// Beyond this, custom validators can be defined on the client and custom validation logic
// added on the server.  Note that the <code>regexp</code> and <code>mask</code> validator
// types are very flexible and can be used to perform virtually any kind of formatting check
// that doesn't involve some large external dataset.
// <p>
// Custom validators can be reused on the client by adding them to the global validator list,
// via the +link{classMethod:Validator.addValidator()} method.
//
// @visibility external
// @see ValidatorTypes
// @treeLocation Client Reference/Forms
//<
 
//> @attr validator.type                       (ValidatorTypes : null : [IR])
// Type of the validator.
// <p>
// This can be one of the built-in +link{class:ValidatorTypes}, or the string "custom" to define
// a custom validator.
// @visibility external
//<

//> @method validator.condition() 
// For a validator that is not one of the built-in +link{class:ValidatorTypes}, a function or
// String expression to evaluate to see if this validator passes or fails.
// <p>
// Because the validator declaration itself is passed as a parameter to
// <code>condition()</code>, you can effectively parameterize the validator.  For example, to
// create a validator that checks that the value is after a certain date:<pre> 
//     { type:"custom", afterDate:new Date(), 
//       condition:"value.getTime() > validator.afterDate.getTime()" }
// </pre>
// Reusable validators, like the above, can be registered as a standard validatorType by
// calling +link{Validator.addValidator()}.
// <P>
// Note that, if a field is declared with a builtin +link{type:FieldType}, the value passed in
// will already have been converted to the specified type, if possible.
//
// @param item (DataSourceField or FormItem) FormItem or DataSourceField on which this
//                                           validator was declared.  NOTE: FormItem will not
//                                           be available during a save performed without a
//                                           form (eg programmatic save) or if the field 
//                                           is not available in the form.
// @param validator (Validator) Validator declaration from eg
//                              +link{DataSourceField.validators}.
// @param value     (any)       value to validate
// @return (boolean) whether the value passed validation.  True for passed, false for fail.
//                              
//
// @visibility external
//<



//> @attr validator.errorMessage               (errorMessage : null : [IR])
// Text to display if the value does not pass this validation check.
// <P>
// If unspecified, default error messages exist for all built-in validators, and a generic
// message will be used for a custom validator that is not passed.
// @visibility external
// @example conditionallyRequired
//<

//> @attr validator.stopIfFalse                (boolean : false : [IR])
// Normally, all validators defined for a field will be run even if one of the validators has
// already failed.  However, if <code>stopIfFalse</code> is set, validation will not proceed
// beyond this validator if the check fails.
// <P>
// This is useful to prevent expensive validators from being run unnecessarily, or to allow
// custom validators that don't need to be robust about handling every conceivable type of
// value.
// 
// @visibility external
//<

//> @attr validator.clientOnly                 (boolean : false : [IR])
// Indicates this validator runs on the client only.
// <p>
// Normally, if the server is trying to run validators and finds a validator that it can't
// execute, for safety reasons validation is considered to have failed.  Use this flag to
// explicitly mark a validator that only needs to run on the client.  
// 
// @visibility external
//<


// NOTE ON DEFAULT ERROR MESSAGES:
// If the validator doesn't have an error message, set the defaultErrorMessage property on the
// object to distinguish it from an error message set by the user (errorMessage property).
// It's unnecessary to do this on the server because the error message is returned as part of
// the validation result, and the validator parameters aren't modified.

isc.ClassFactory.defineClass("Validator");

// These need to be constants to allow the built-in validators to be i18n'd.  NOTE: it would be
// nice to move these definitions closer to the relevant validator, but note that some
// validators have more than one error message, so we can't adopt a simple convention of naming
// the errors after the validator.
isc.Validator.addClassProperties({
    //>@classAttr   Validator.notABoolean (string : "Must be a true/false value" : [IRA])
    //  Default error message to display when standard <code>isBoolean</code> type validator
    //  returns false.
    // @visibility external
    // @group i18nMessages
    //<
    notABoolean:"Must be a true/false value",
    //>@classAttr   Validator.notAString (string : "Must be a string." : [IRA])
    //  Default error message to display when standard <code>isString</code> type validator
    //  returns false.
    // @visibility external
    // @group i18nMessages
    //<
    notAString:"Must be a string.",
    //>@classAttr   Validator.notAnInteger (string : "Must be a whole number." : [IRA])
    //  Default error message to display when standard <code>isInteger</code> type validator
    //  returns false.
    // @visibility external
    // @group i18nMessages    
    //<    
    notAnInteger:"Must be a whole number.",
    //>@classAttr   Validator.notADecimal (string : "Must be a valid decimal." : [IRA])
    //  Default error message to display when standard <code>isFloat</code> type validator
    //  returns false.
    // @visibility external
    // @group i18nMessages
    //<    
    notADecimal:"Must be a valid decimal.",
    //>@classAttr   Validator.notADate (string : "Must be a date." : [IRA])
    //  Default error message to display when standard <code>isDate</code> type validator
    //  returns false.
    // @visibility external
    // @group i18nMessages    
    //<    
    notADate:"Must be a date.",

    
    //>@classAttr   Validator.notATime (string : "Must be a time." : [IRA])
    //  Default error message to display when standard <code>isTime</code> type validator
    //  returns false.
    // @group i18nMessages
    //<    
    notATime: "Must be a time.",
    
    //>@classAttr   Validator.notAnIdentifier (string : "Identifiers must start with a letter, underscore or $ character, and may contain only letters, numbers, underscores or $ characters." : [IRA])
    //  Default error message to display when standard <code>isIdentifier</code> type validator
    //  returns false.
    // @group i18nMessages    
    //<    
    notAnIdentifier: "Identifiers must start with a letter, underscore or $ character," +
                    "and may contain only letters, numbers, underscores or $ characters.",
                    
    //>@classAttr   Validator.notARegex (string : "Must be a valid regular expression." : [IRA])
    //  Default error message to display when standard <code>isRegex</code> type validator
    //  returns false.
    // @group i18nMessages    
    //<    
    notARegex:"Must be a valid regular expression.",
    
    //>@classAttr   Validator.notAColor (string : "Must be a CSS color identifier." : [IRA])
    //  Default error message to display when standard <code>isColor</code> type validator
    //  returns false.
    // @group i18nMessages    
    //<    
    notAColor:"Must be a CSS color identifier.",

    //>@classAttr   Validator.mustBeLessThan (string : "Must be no more than ${max}" : [IRA])
    //  Default error message to display when standard <code>integerRange</code> type validator
    //  returns false because the value passed in is greater than the specified maximum.
    // This is a dynamic string - text within <code>\${...}</code> will be evaluated as JS code
    // when the message is displayed, with <code>max</code> and <code>min</code> available as
    // variables mapped to <code>validator.max</code> and <code>validator.min</code>.
    // @visibility external
    // @group i18nMessages    
    //<
    mustBeLessThan:"Must be no more than ${max}", 

    //>@classAttr   Validator.mustBeGreaterThan (string : "Must be at least ${min}" : [IRA])
    //  Default error message to display when standard <code>integerRange</code> type validator
    //  returns false because the value passed in is less than the specified minimum.
    // This is a dynamic string - text within <code>\${...}</code> will be evaluated as JS code
    // when the message is displayed, with <code>max</code> and <code>min</code> available as
    // variables mapped to <code>validator.max</code> and <code>validator.min</code>.
    // @visibility external
    // @group i18nMessages    
    //<        
    mustBeGreaterThan:"Must be at least ${min}", 
    
    //>@classAttr   Validator.mustBeLaterThan (string : "Must be later than ${min}" : [IRA])
    //  Default error message to display when standard <code>dateRange</code> type validator
    //  returns false because the value passed in is greater than the specified minimum date.
    // This is a dynamic string - text within <code>\${...}</code> will be evaluated as JS code
    // when the message is displayed, with <code>max</code> and <code>min</code> available as
    // variables mapped to <code>validator.max</code> and <code>validator.min</code>.
    // @visibility external
    // @group i18nMessages    
    //<        
    mustBeLaterThan:"Must be later than ${min.toShortDate()}", 

    //>@classAttr   Validator.mustBeEarlierThan (string : "Must be earlier than ${max}" : [IRA])
    //  Default error message to display when standard <code>dateRange</code> type validator
    //  returns false because the value passed in is less than the specified maximum date.
    // This is a dynamic string - text within <code>\${...}</code> will be evaluated as JS code
    // when the message is displayed, with <code>max</code> and <code>min</code> available as
    // variables mapped to <code>validator.max</code> and <code>validator.min</code>.
    // @visibility external
    // @group i18nMessages    
    //<        
    mustBeEarlierThan:"Must be earlier than ${max.toShortDate()}", 
    
    //>@classAttr   Validator.mustBeShorterThan (string : "Must be less than ${max} characters" : [IRA])
    // Default error message to display when standard <code>lengthRange</code> type validator
    // returns false becaues the value passed in has more than <code>validator.max</code> characters.
    // This is a dynamic string - text within <code>\${...}</code> will be evaluated as JS code
    // when the message is displayed, with <code>max</code> and <code>min</code> available as
    // variables mapped to <code>validator.max</code> and <code>validator.min</code>.
    // @visibility external
    // @group i18nMessages    
    //<
    mustBeShorterThan:"Must be less than ${max} characters",

    //>@classAttr   Validator.mustBeLongerThan (string : "Must be more than ${min} characters" : [IRA])
    // Default error message to display when standard <code>lengthRange</code> type validator
    // returns false becaues the value passed in has fewer than <code>validator.min</code> characters.
    // This is a dynamic string - text within <code>\${...}</code> will be evaluated as JS code
    // when the message is displayed, with <code>max</code> and <code>min</code> available as
    // variables mapped to <code>validator.max</code> and <code>validator.min</code>.
    // @visibility external
    // @group i18nMessages    
    //<    
    mustBeLongerThan:"Must be more than ${min} characters",
    
    //>@classAttr   Validator.mustBeExactLength (string : "Must be exactly ${max} characters" : [IRA])
    // Default error message to display when standard <code>lengthRange</code> type validator
    // has <code>validator.max</code> and <code>validator.min</code> set to the same value,
    // and returns false because the value passed is not the same length as these limits.<br>
    // This is a dynamic string - text within <code>\${...}</code> will be evaluated as JS code
    // when the message is displayed, with <code>max</code> and <code>min</code> available as
    // variables mapped to <code>validator.max</code> and <code>validator.min</code>.
    // @visibility external
    // @group i18nMessages    
    //<
    mustBeExactLength:"Must be exactly ${max} characters",

    
    //>@classAttr   Validator.notAMeasure (string : 'Must be a whole number, percentage, "*" or "auto"' : [IRA])
    //  Default error message to display when standard <code>isMeasure</code> type validator
    //  returns false.
    // @group i18nMessages    
    //<    
    notAMeasure:'Must be a whole number, percentage, "*" or "auto"',
    
    //>@classAttr   Validator.requiredField (string : 'Field is required' : [IRA])
    //  Default error message to display when validation fails for a field marked as required,
    //  or a field with a standard <code>requiredIf</code> type validator whose condition 
    //  evaluates to true, because the field has no value.
    // @visibility external
    // @group i18nMessages    
    //<    
    requiredField:"Field is required",

    //>@classAttr   Validator.notOneOf (string : 'Not a valid option' : [IRA])
    // Default error message to display when standard <code>isOneOf</code> type validator
    // is not passed.
    // @visibility external
    // @group i18nMessages    
    //<    
    notOneOf:"Not a valid option",
    
    //>@classAttr   Validator.notAFunction (string : 'Must be a function.' : [IRA])
    //  Default error message to display when standard <code>isFunction</code> type validator
    //  returns false.
    // @group i18nMessages    
    //<    
    notAFunction:'Must be a function.',
    

    _$true : "true",
    _$false : "false",
    _$dot:".",

    // Actually store the standard validators on Validator._validatorFunctions
	_validatorFunctions : {

        // Create "Validators" as a pseudo class for JSDocs - documents the
        // set of available validator types.    
        
        
        //>	@class    ValidatorTypes
        //  The set of standard validator types available on all fields.<br>
        //  To make use of some standard validator type for a field in a DataSource, or 
        //  DynamicForm instance, specify the <code>validators</code> property to an array 
        //  containing a validator definition where the <code>type</code> property is set to 
        //  the appropriate type.  
        //  A custom error message can be specified for any validator type by setting the
        //  <code>errorMessage</code> property on the validator definition object, and some
        //  validator types make use of additional properties on the validator definition 
        //  object such as <code>max</code> or <code>min</code>.<br>
        //  For example, to make use of the <code>integerRange</code> validator type:<br><br><code>
        //  &nbsp;&nbsp;field:{<br>
        //  &nbsp;&nbsp;&nbsp;&nbsp;validators:[<br>
        //  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{type:"integerRange", min:1, max:100}<br>
        //  &nbsp;&nbsp;&nbsp;&nbsp;]<br>
        //  &nbsp;&nbsp;}
        //  </code><br><br>
        //  
        // @visibility external
        // @treeLocation Client Reference/Forms/Validator
        //<
        
        // isType validators
        // ------------------------------------------------------------------------------------

        //>@classAttr ValidatorTypes.isBoolean (validatorDefinition : object : IR)
        //  Validation will fail if this field is non-empty and has a non-boolean value.
        // @visibility external
        //<
        isBoolean : function (item, validator, value) {
        	// skip empty fields
        	if (value == null || isc.is.emptyString(value)) return true;
            if (isc.isA.Boolean(value)) return true;

        	if (!validator.errorMessage) {
                validator.defaultErrorMessage = isc.Validator.notABoolean;
            }

            if (isc.isA.String(value)) {
                var Validator = isc.Validator;
                validator.resultingValue = (value == Validator._$true);
                // "true" and "false" is the valid String representation of a boolean
                return (value == Validator._$true || value == Validator._$false);
            } else if (isc.isA.Number(value)) {
                validator.resultingValue = (value != 0);
                // 0 and 1 is the valid numeric representation of a boolean
                return (value == 0 || value == 1);
            }
            // anything else is a failure, but we still tell you it's boolean value
            validator.resultingValue = !!value;
            return false;
        },
        
        //>@classAttr ValidatorTypes.isString (validatorDefinition : object : IR)
        //  Validation will fail if the value is not a string value.
        // @visibility external
        //<
        
        isString : function (item, validator, value) {
        	if (value == null || isc.isA.String(value)) return true;
            if (!validator.errorMessage) validator.defaultErrorMessage = isc.Validator.notAString;
        	validator.resultingValue = isc.iscToLocaleString(value);
        	return true;
        },
        
        //>@classAttr ValidatorTypes.isInteger (validatorDefinition : object : IR)
        //  Tests whether the value for this field is a whole number.  If 
        //  <code>validator.convertToInteger</code> is true, float values will be converted 
        //  into integers and validation will succeed.
        // @visibility external
        //<
        isInteger : function (item, validator, value) {
        	// skip empty fields
        	if (value == null || isc.is.emptyString(value)) return true;
        	if (!validator.errorMessage) validator.defaultErrorMessage = isc.Validator.notAnInteger;
        	
        	// if the value can't be resolved to a number, return false
        	if (isNaN(value)) return false;	//Not a number or a string that resolves to a number.

        	// Note: this routine will be subject to JavaScript's rounding errors for extremely
            // large numbers (16+ digits)
            var intValue = parseInt(value),
                isInteger = (value == intValue);
            
            if (validator.convertToInteger) {

                // Parse as float and round instead of parseInt() because parseInt() is
                // basically Math.floor().  We want 1.5 to become 2, etc.
            	var floatValue = parseFloat(value),
                    intValue = Math.round(floatValue); 
            
            	// reset suggested value (no change if already an integer)
            	validator.resultingValue = intValue;
                
                // return true - if we're doing the conversion allow validation to succeed
                return true;
            } else {
                // If we were passed an integer, still update the resulting value - this
                // will ensure that 1.0 is stored as just 1.
                if (isInteger) {
                    validator.resultingValue = intValue;
                    return true;
                } else return false;
            }
        },
        
        //>@classAttr ValidatorTypes.isFloat (validatorDefinition : object : IR)
        //  Tests whether the value for this field is a valid floating point number.
        // @visibility external
        //<
        isFloat : function (item, validator, value) {
        	if (value == null || isc.is.emptyString(value)) return true;
        	if (!validator.errorMessage) validator.defaultErrorMessage = isc.Validator.notADecimal;
        	
        	// is the value a valid float?
            var floatValue;
            // treat "." as zero - this ensures that if the user is typing ".3", and we're
            // validating on change, the '.' doesn't kill editing
            if (value == isc.Validator._$dot) {
                floatValue = "0.";
            } else {
                floatValue = parseFloat(value);            
                if (isNaN(floatValue) || floatValue != value) return false;
            }
        	validator.resultingValue = floatValue;
        
        	return true;
        },
        
        
        isDate : function (item, validator, value) {
        	if (value == null || isc.is.emptyString(value) || isc.isA.Date(value)) return true;
        	if (!validator.errorMessage) validator.defaultErrorMessage = isc.Validator.notADate;
        
            var dateValue = Date.parseSchemaDate(value);

            if (dateValue == null) return false;

        	validator.resultingValue = dateValue;
        	return true;
        },
        
        // Not exposed, as developer will likely want to customize acceptable time format/
        // parsing function.
        isTime : function (item, validator, value) {
        	if (value == null || isc.is.emptyString(value) || isc.isA.Date(value)) return true;
            if (isc.Time.parseInput(value, true) != null) return true;
            
        	if (!validator.errorMessage) validator.defaultErrorMessage = isc.Validator.notATime;
            return false;
        },
        
        // This is used for validating ISC components defined in XML
        // Leave as un-exposed for now.
        isIdentifier : function (item, validator, value) {
        	if (value == null || isc.is.emptyString(value)) return true;
            if (!validator.errorMessage) {
                validator.defaultErrorMessage = isc.Validator.notAnIdentifier;
            }
        	return value.match(/^[a-zA-Z_\$][\w\$]*$/) != null;
        },
        
        // This is used for validating ISC components defined in XML
        // Leave as un-exposed for now.
        isRegexp : function (item, validator, value) {
        	if (value == null || isc.is.emptyString(value)) return true;
            if (!validator.errorMessage) validator.defaultErrorMessage = isc.Validator.notARegex;
            
            if (typeof value == 'object' && value.constructor == RegExp) return true;
        
            
            if (isc.Browser.isDOM) {
                if (!isc.Validators._isRegexp) {
                    isc.Validators._isRegexp = new Function("value",
                        "try{var regex=new RegExp(value)}catch(e){return false}return true");
                }
                return isc.Validators._isRegexp(value);
            } else {
                var regex = new RegExp(value);
                return true;
            }
        },
        
        //>@classAttr ValidatorTypes.isFunction     (validatorDefinition : object : IR)
        //  Tests whether the value for this field is a valid expression or function; if it is
        //  valid, creates a StringMethod object with the value, and set the resultingValue to
        //  the StringMethod
        //<        
        isFunction :  function (item, validator, value) {
            if (value == null || isc.is.emptyString(value) || value == isc.Class.NO_OP ||
                isc.isA.StringMethod(value))
            {
                return true;
            }
            if (!validator.errorMessage) validator.defaultErrorMessage = isc.Validator.notAFunction;

            try {
                isc.Func.expressionToFunction("", value);
            } catch (e) {
                return false;
            }

            // catch the case where we have a function derived from an Action
            // in this case pick up the original action again.
            if (value.iscAction) value = value.iscAction;
            validator.resultingValue = isc.StringMethod.create({value:value});
            return true;
        },

        // isColor() - used for validating ISC components defined in XML
        // Leave as un-exposed for now.
        isColor : function (item, validator, value) {
            
            if (!validator.errorMessage) validator.defaultErrorMessage = isc.Validator.notAColor;
            
            // empty string/undefined/null is generally treated as the transparent color, so allow
            // that.  If an actual entry is required, you can specify the 'required' validator
            if (!value) return true;

            return isc.isA.color(value);
        },
                
        // This is used for validating ISC components defined in XML
        // Leave as un-exposed for now.
        isMeasure : function (item, validator, value) {
        	if (value == null || isc.is.emptyString(value) || value == "*") return true;
        	if (!validator.errorMessage) validator.defaultErrorMessage = isc.Validator.notAMeasure;
 

            // if it ends in percent, check if it's all digits       
        	if (isc.isA.String(value) && value.charAt(value.length - 1) == '%') {
        		value = value.slice(0, -1);
        		// Not using parseInt here because parseInt returns a valid number if the
                // string is prefixed with a valid number
        		return value.match(/\d+\.?\d*/) != null;
        	}
        	return isc.Validator.processValidator(item, validator, value, "integerOrAuto");
        },

        // This is used for validating ISC components defined in XML
        // Leave as un-exposed for now.
        integerOrAuto : function (item, validator, value) {
        	if (value == null || isc.is.emptyString(value) || 
                (isc.isA.String(value) && value.toLowerCase() == "auto")) return true;
        	return isc.Validator.processValidator(item, validator, value, "isInteger");
        },

        // Generic (typeless) validators
        // ---------------------------------------------------------------------------------------
        
        //>@classAttr ValidatorTypes.requiredIf  (validatorDefinition : object : IR)
        //  RequiredIf type validators should be specified with an <code>expression</code>
        //  property set to a +link{group:stringMethods,stringMethod}, which takes three
        //  parameters:<ul>
        //  <li>item - the DynamicForm item on which the error occurred (may be null)
        //  <li>validator - a pointer to the validator object
        //  <li>value - the value of the field in question</ul>
        //  When validation is perfomed, the expression will be evaluated (or executed) - if it
        //  returns <code>true</code>, the field will be treated as a required field, so validation 
        //  will fail if the field has no value.
        // @visibility external
        // @example conditionallyRequired
        //<
        requiredIf : function (item, validator, value) {
        	// CALLBACK API:  available variables:  "item,validator,value"
        	// Convert a string callback to a function
        	if (validator.expression != null && !isc.isA.Function(validator.expression)) {
        		isc.Func.replaceWithMethod(validator, "expression", "item,validator,value");
        	}

        	var required = validator.expression(item,validator,value);

            // Default to displaying the 'requiredField' error message.
            if (validator.errorMessage == null) 
                validator.errorMessage = isc.Validator.requiredField;
        
        	// if the item is not required, or isn't empty, return true
        	return  !required || (value != null && !isc.is.emptyString(value));
        },
        
        //>@classAttr ValidatorTypes.matchesField (validatorDefinition : object : IR)
        //  Tests whether the value for this field matches the value of some other field.
        //  The field to compare against is specified via the <code>otherField</code> property
        //  on the validator object (should be set to a field name).<br>
        //  Note this validator type is only supported for items being edited within a 
        //  DynamicForm - it cannot be applied to a +link{ListGridField, ListGrid field}.
        // @visibility external
        // @example matchValue
        //<
        
        matchesField : function (item, validator, value) {
            // This will happen if the developer specifies a matches field validator on 
            // a ListGrid field.
            if (!item.form) {
                this.logWarn("Validator of type 'matchesField' specified for a field with no " +
                             "associated DynamicForm instance. Ignoring");
                return true;
            }
        	// get the value of the other field
        	var otherFieldValue = item.form.getValue(validator.otherField);
        	// and return whether the values match
        	return (value == otherFieldValue);
        },
        
        //>@classAttr ValidatorTypes.isOneOf (validatorDefinition : object : IR)
        // Tests whether the value for this field matches any value from an arbitrary
        // list of acceptable values.  The set of acceptable values is specified via
        // the <code>list</code> property on the validator, which should be set to an array of
        // values. If validator.list is not supplied, the valueMap for the field will be used.
        // If there is no valueMap, not providing validator.list is an error.

        // @visibility external
        //<
        isOneOf : function (item, validator, value) {
        	// skip empty fields
        	if (value == null || isc.is.emptyString(value)) return true;

        	// get the list of items to match against, either declared on this validator
            // or automatically derived from the field's valueMap (item.valueMap)
            
            var valueMap = validator.list || (item ? (item.getValueMap ? item.getValueMap() 
                                                                       : item.valueMap) 
                                                   : null),
                valueList = valueMap;
            if (!isc.isAn.Array(valueMap) && isc.isAn.Object(valueMap)) {
                valueList = isc.getKeys(valueMap);
            }
            
            if (valueList != null) {
    
            	// if any item == the value, return true
            	for (var i = 0, length = valueList.length; i < length; i++) {
            		if (valueList[i] == value) return true;
            	}
            //>DEBUG
            } else {
                isc.Log.logWarn("isOneOf validator specified with no specified list of options " +
                            "or valueMap - validator will always fail. " +
                            "Field definition:" + isc.Log.echo(item), "validation");
            //<DEBUG
            }
        	// otherwise, failure return false
            if (!validator.errorMessage) {
                validator.defaultErrorMessage = isc.Validator.notOneOf;
            }
        	return false;
        },
        
        // Integer validators
        // ------------------------------------------------------------------------------------

        //>@classAttr ValidatorTypes.integerRange (validatorDefinition : object : IR)
        //  Tests whether the value for this field is a whole number within the range 
        //  specified.  The <code>max</code> and <code>min</code> properties on the validator
        //  are used to determine the acceptable range.
        // @visibility external
        // @example validationBuiltins
        //<
        integerRange : function (item, validator, value) {
            // If we're passed a non numeric value, just return without adding an error.
            // This is appropriate since the type of the field will probably be specified as 
            // "integer" meaning that the built in integer validator will also be present on the
            // field.
            var passedVal = value;
            if (!isc.isA.String(value)) value = parseInt(value);
            if (isNaN(value) || value != passedVal) return true;
            
            // Allow dynamic error messages to be eval'd, with pointers to min and max values
            validator.dynamicErrorMessageArguments = {validator:validator, 
                                                      max:validator.max, 
                                                      min:validator.min}

        
        	// if a maximum was specified, return false if we're greater than the max
        	if (isc.isA.Number(validator.max) && value > validator.max) {
        		if (!validator.errorMessage) {
        			validator.defaultErrorMessage = isc.Validator.mustBeLessThan
        		}
        		return false;
        	}
        	// if a minumum was specified, return false if we're less than the min
        	if (isc.isA.Number(validator.min) && value < validator.min) {
        		if (!validator.errorMessage) {
        			validator.defaultErrorMessage = isc.Validator.mustBeGreaterThan;
        		}
        		return false;
        	}
        	return true;
        },
        
        // String validators
        // ------------------------------------------------------------------------------------
        
        //>@classAttr ValidatorTypes.lengthRange    (validatorDefinition : object : IR)
        //  This validator type applies to string values only.  If the value is a string value
        //  validation will fail if the strings length falls outside the range specified by 
        //  <code>validator.max</code> and <code>validator.min</code>.<br>
        //  Note that non-string values will always pass validation by this validator type.<br>
        // Note that the <code>errorMessage</code> for this validator will be evaluated as
        // a dynamicString - text within <code>\${...}</code> will be evaluated as JS code
        // when the message is displayed, with <code>max</code> and <code>min</code> available as
        // variables mapped to <code>validator.max</code> and <code>validator.min</code>.
        // @visibility external
        //<
        lengthRange : function (item, validator, value) {
        	// skip empty fields
        	if (value == null || isc.is.emptyString(value)) return true;
        	
        	// if value null/undefined, or isn't a string, return true
        	if (!isc.isA.String(value)) return true;
            
            // Allow dynamic error messages to be eval'd, with pointers to min and max values
            validator.dynamicErrorMessageArguments = {validator:validator, 
                                                      max:validator.max, 
                                                      min:validator.min}
        
        	// get the length of the value
        	var length = value.length,
                maxNumber = validator.max != null ? parseInt(validator.max) : null,
                minNumber = validator.min != null ? parseInt(validator.min) : null;
                
            if (!isc.isA.Number(maxNumber)) maxNumber = null;
            if (!isc.isA.Number(minNumber)) minNumber = null;
            
        	// if a maximum was specified, return false if length is greater than the max
        	if (maxNumber != null && length > maxNumber) {
        		validator.defaultErrorMessage = 
                    (maxNumber == minNumber ? isc.Validator.mustBeExactLength 
                                            : isc.Validator.mustBeShorterThan);
                return false;
            }

        	// if a minumum was specified, return false if length is less than the min
        	if (minNumber != null && length < minNumber) {
        		validator.defaultErrorMessage = 
                    (maxNumber == minNumber ? isc.Validator.mustBeExactLength
                                            : isc.Validator.mustBeLongerThan);
                return false;
            }
        	return true;
        },
        
        //>@classAttr ValidatorTypes.contains   (validatorDefinition : object : IR)
        //  Determine whether a string value contains some substring specified via 
        // <code>validator.substring</code>.
        // @visibility external
        //<
        contains : function (item, validator, value) {
        	// skip empty fields
        	if (value == null || isc.is.emptyString(value)) return true;
        	if (!isc.isA.String(value)) value = isc.iscToLocaleString(value);
        	return value.indexOf(validator.substring) > -1;
        },
        
        //>@classAttr ValidatorTypes.doesntContain   (validatorDefinition : object : IR)
        //  Determine whether a string value does not contain some substring specified via 
        // <code>validator.substring</code>.
        // @visibility external
        //<
        doesntContain : function (item, validator, value) {
        	// skip empty fields
        	if (value == null || isc.is.emptyString(value)) return true;
        	if (!isc.isA.String(value)) value = isc.iscToLocaleString(value);
        	return value.indexOf(validator.substring) == -1;
        },
        
        //>@classAttr ValidatorTypes.substringCount   (validatorDefinition : object : IR)
        //  Determine whether a string value contains some substring multiple times.
        //  The substring to check for is specified via <code>validator.substring</code>.
        //  The <code>validator.operator</code> property allows you to specify how to test
        //  the number of substring occurrances. Valid values for this property are
        //  <code>==</code>, <code>!=</code>, <code>&lt;</code>, <code>&lt;=</code>,
        //  <code>&gt;</code>, <code>&gt;=</code>.<br>
        //  The number of matches to check for is specified via <code>validator.count</code>.
        // @visibility external
        //<
        substringCount : function (item, validator, value) {
        	// skip empty fields
        	if (value == null || isc.is.emptyString(value)) return true;
        	var substring = validator.substring;
        	// get the number of times the value contains the substring and put it into "matchCount"
        	for (var index = 0,	matchCount = 0; index < value.length; index++) {
        		index = value.indexOf(substring,index);
        		if (index > -1) matchCount++;
        		else break;
        	}
        	
        	var operator = validator.operator, 
        		count = validator.count
        	;
        	if (!operator) operator = "==";
        	if (!count) count = 0;
        	
        	switch (operator) {
        		case "==" : return matchCount == count;
        		case "!=" : return matchCount != count;
        		case "<" : return matchCount < count;
        		case "<=" : return matchCount <= count;
        		case ">" : return matchCount > count;
        		case ">=" : return matchCount >= count;
        	}
        	
        	// otherwise return false
        	return false;
        },
        
        //>@classAttr ValidatorTypes.regexp (validatorDefinition : object : IR)
        //  <code>regexp</code> type validators will determine whether the value specified 
        //  matches a given regular expression.  The expression should be specified on the
        //  <code>validator</code> object as the <code>expression</code> property.
        // @visibility external
        // @example regularExpression
        //<
        regexp : function (item, validator, value) {
        	// skip empty fields
        	if (value == null || isc.is.emptyString(value)) return true;
        	
        	// get the expression to validate and normalize it to a regExp value
        	var expression = validator.expression;
        	if (isc.isA.String(expression)) {
                expression = new RegExp(expression);
            }
        	
        	// return whether or not the expression matches the value
        	return expression.test(value);
        },

        //>@classAttr ValidatorTypes.mask   (validatorDefinition : object : IR)
        //  Validate against a regular expression mask, specified as <code>validator.mask</code>.
        //  If validation is successful a transformation can also be specified via the
        //  <code>validator.transformTo</code> property. This should be set to a string in the
        //  standard format for string replacement via the native JavaScript <code>replace()</code>
        //  method.
        //  
        // @visibility external
        // @example valueTransform
        //<
        mask : function (item, validator, value) {
        	// skip empty fields
        	if (value == null || isc.is.emptyString(value)) return true;
        	var mask = validator.mask;
        	
        	// and convert to a regular expression if it's a string
        	if (isc.isA.String(mask)) mask = validator.mask = new RegExp(mask);
        	
        	// check the value against the mask
        	if (!mask.test(value)) {
        		return false;
        	} else {
        		// if it passes the test
        
        		// if they specify a transformTo, transform the item and set the 
        		//	resultingValue to the transformed value
        		if (validator.transformTo) {
        			validator.resultingValue = value.replace(mask, validator.transformTo);
        		}
        	}
        
        	// return that the mask was validated successfully
        	return true;
        },

        // Dates
        // ---------------------------------------------------------------------------------------
        //>@classAttr ValidatorTypes.dateRange    (validatorDefinition : object : IR)
        // Tests whether the value for a date field is within the range specified.
        // Range is inclusive, and is specified via <code>validator.min</code> and
        // <code>validator.max</code>, which should be dates.<br>
        // Note that the <code>errorMessage</code> for this validator will be evaluated as
        // a dynamicString - text within <code>\${...}</code> will be evaluated as JS code
        // when the message is displayed, with <code>max</code> and <code>min</code> available as
        // variables mapped to <code>validator.max</code> and <code>validator.min</code>.
        //
        // @visibility external
        //<
        dateRange : function (item, validator, value) {
        	if (value == null || isc.is.emptyString(value)) return true;

            if (!isc.isA.Date(value)) return false;

            var min = validator.min, max = validator.max;

            // make a one-time attempt to parse min and max to dates.  Handy when specifying
            // min and max dates in XML.
            if (min != null && !isc.isA.Date(min)) min = validator.min = Date.parseSchemaDate(min);
            if (max != null && !isc.isA.Date(max)) max = validator.max = Date.parseSchemaDate(max);

            // Allow dynamic error messages to be eval'd, with pointers to min and max values
            validator.dynamicErrorMessageArguments = {validator:validator, 
                                                      max:max, 
                                                      min:min}
            if (isc.isA.Date(min) && value.getTime() < min.getTime()) {
        		if (!validator.errorMessage) {
        			validator.defaultErrorMessage = isc.Validator.mustBeLaterThan
        		}
        		return false;
            }
            if (isc.isA.Date(max) && value.getTime() > max.getTime()) {
        		if (!validator.errorMessage) {
        			validator.defaultErrorMessage = isc.Validator.mustBeEarlierThan;
        		}
        		return false;
            }
            return true;
        },

        // Floats
        // ---------------------------------------------------------------------------------------
        //>@classAttr ValidatorTypes.floatLimit   (validatorDefinition : object : IR)
        // Validate a variable as a valid floating point value, within a value range.
        // Range is specified via <code>validator.min</code> and <code>validator.max</code>.
        // Also checks precision, specified as number of decimal places in 
        // <code>validator.precision</code>. If <code>validator.roundToPrecision</code> is set, 
        // a value that doesn't match the specified number of decimal places will be rounded
        // to the nearest value that does.        
        //<
        // backcompat only, replaced by floatRange and floatPrecision
        floatLimit : function (item, validator, value) {
            var roundedValue;

            // Check precision before max/min as rounding may push it over the edge.        
            if (validator.precision != null) {
                //>!BackCompat 2005.02.03
                // Old functionality always had no 'roundToPrecision' param, but always
                // rounded and passed.
                if (validator.roundToPrecision == null) validator.roundToPrecision = true;
                //<!BackCompat
                if (!isc.Validator.processValidator(item, validator, value, "floatPrecision"))
                    return false;
                // from now on test with the rounded version.
                if (validator.resultingValue != null) 
                    value = roundedValue = validator.resultingValue;
            }
            if (validator.min != null || validator.max != null) {
                if (!isc.Validator.processValidator(item, validator, value, "floatRange")) {
                    return false
                } else {
                    // the second processValidator call will have cleared out resultingValue
                    // which may have come from the precision validator.
                    if (roundedValue != null && validator.resultingValue == null && 
                        validator.roundToPrecision) 
                        validator.resultingValue = roundedValue;
                } 
            }            
            return true;
        },
        
        //>@classAttr ValidatorTypes.floatRange     (validatorDefinition : object : IR)
        //  Tests whether the value for this field is a floating point number within the range 
        //  specified.  The <code>max</code> and <code>min</code> properties on the validator
        //  are used to determine the acceptable range.<br>
        // Note that the <code>errorMessage</code> for this validator will be evaluated as
        // a dynamicString - text within <code>\${...}</code> will be evaluated as JS code
        // when the message is displayed, with <code>max</code> and <code>min</code> available as
        // variables mapped to <code>validator.max</code> and <code>validator.min</code>.
        // @visibility external
        //<        
        floatRange : function (item, validator, value) {
            // skip empty fields
        	if (value == null || isc.is.emptyString(value)) return true;
            // If we're passed a non numeric value, just return without adding an error.
            // This is appropriate since the type of the field will probably be specified as 
            // "float" meaning that the built in float validator will also be present on the
            // field.
            
            var floatValue = value;
            if (!isc.isA.String(value)) floatValue = parseFloat(floatValue);
            if (isNaN(floatValue) || floatValue != value) return true;
            
        	
            // Allow dynamic error messages to be eval'd, with pointers to min and max values
            validator.dynamicErrorMessageArguments = {validator:validator, 
                                                      max:validator.max, 
                                                      min:validator.min}
        
        	// is the value less than the max allowable? (if specified)
        	if (isc.isA.Number(validator.max) && floatValue > validator.max) {
        		if (!validator.errorMessage) {
        			validator.defaultErrorMessage = isc.Validator.mustBeLessThan;
        		}
        		return false;
        	}
        	
        	// is the value greater than the min allowable? (if specified)
        	if (isc.isA.Number(validator.min) && floatValue < validator.min) {
                if (!validator.errorMessage) {
        			validator.defaultErrorMessage = isc.Validator.mustBeGreaterThan;
        		}
                return false;
            }
            return true;
        },
        
        //>@classAttr ValidatorTypes.floatPrecision     (validatorDefinition : object : IR)
        //  Tests whether the value for this field is a floating point number with the 
        //  appropriate number of decimal places - specified in <code>validator.precision</code>
        //  If the value is of higher precision, if <code>validator.roundToPrecision</code> 
        //  is specified, the value will be rounded to the specified number of decimal places
        //  and validation will pass, otherwise validation will fail.
        // @visibility external
        //<        
        floatPrecision : function (item, validator, value) {
   
            // skip empty fields
        	if (value == null || isc.is.emptyString(value)) return true;

        	var floatValue = parseFloat(value);
        	if (isNaN(floatValue) || floatValue != value) return false;
            
        	// if validator.precision is defined, round to that precision.
        	if (isc.isA.Number(validator.precision)) {
        		var multiplier = Math.pow(10, validator.precision);
                var roundedValue = (Math.round(floatValue * multiplier))/multiplier;
                if (validator.roundToPrecision) {
                    validator.resultingValue = roundedValue;
                    return true;
                } else {
                    return (floatValue == roundedValue);
                }
                
        		return true;
            }
            
        }
        
        
        
        
        // ------------------------------------------------------------------------------------    
        // END of Valiator._validatorFunctions
        // ------------------------------------------------------------------------------------    
    }
});


isc.Validator.addClassMethods({

    // Process validator is an internal method called by
    // DynamicForm, vauesManagers, and editable ListGrids
    // valuesManagers to perform validation.
    processValidator : function (item, validator, value, type) {
    	// if the validator is server-side only, return true
    	if (validator.serverOnly) return true;
    		
    	// if no type was specified, get it from the validator.type property
    	if (!type) 	type = validator.type;
    	var result = true;
        
        // Check whether we have a standard validator of the appropriate type.
        var validationFunction;
        if (type != null)  validationFunction = this._validatorFunctions[type];
    	
    	// if we didn't find a validatorFunction, use the validator.condition if one was specified
    	if (validationFunction == null && validator.condition) {
    		// CALLBACK API:  available variables:  "item,validator,value"
    		// Convert a string callback to a function
    		if (!isc.isA.Function(validator.condition)) {
                //>DEBUG
                this.logDebug("Creating function for validation condition:\r" + validator.condition);
                //<DEBUG
    			isc.Func.replaceWithMethod(validator, "condition", "item,validator,value");
    		}
    		validationFunction = validator.condition;
    	}
    
    	// if we found a validating function, call it 
    	if (validationFunction != null) {
    	    // NOTE: first clear the "resultingValue" field and suggested value of the
            // validator, in case the validation rule decides to set it

            // for Array-valued fields (field.multiple=true), validate each value in the Array
            if (item && item.multiple && isc.isAn.Array(value)) {
                var resultingValue = [];
                for (var i = 0; i < value.length; i++) {
        	        delete validator.resultingValue;
                    // NOTE: don't stop on failure
    		        result = result && validationFunction(item, validator, value[i]);
                    // capture each resulting value
                    resultingValue[i] = (validator.resultingValue != null ?
                                         validator.resultingValue : value[i]);
                }
                // return the array value as the overall resulting value
                validator.resultingValue = resultingValue;
            } else {
        	    delete validator.resultingValue;
        		result = validationFunction(item, validator, value);
            }
    	//>DEBUG
    	} else {
    		this.logWarn("validator not understood on item: " + this.echo(item) + ":\r" + 
                         isc.Comm.serialize(validator));
    	//<DEBUG
    	}
    	return result;
    },
    
    getErrorMessage : function (validator) {
        
        var errorMessage = validator.errorMessage;
        
        if (errorMessage == null) errorMessage = validator.defaultErrorMessage;
        
        // Convert (potentially) dynamic error message strings to straight
        // strings
        if (errorMessage && validator.dynamicErrorMessageArguments) {
            errorMessage = errorMessage.evalDynamicString(
                                null, validator.dynamicErrorMessageArguments);
        }
        return errorMessage;
    },
    
    
    //>	@classMethod	Validator.addValidator()	(A)
    // Add a new validator type that can be specified as +link{Validator.type} anywhere
    // validators are declared, such as +link{DataSourceField.validators} or
    // +link{FormItem.validators}.
    // <br>
    // The <code>condition</code> argument should be a method of the same signature as
    // +link{Validator.condition()}.
    //
    // @param type (String) type name for the new validator
    // @param condition (StringMethod) function or expression to evaluate to determine whether
    //                                 validation was successful
    //
    // @group validation
    // @visibility external
    // @see Validator.addValidators()
    //<
    addValidator : function (type, condition) {
        if (isc.isA.String(type)) {
            var valsObject = {};
            valsObject[type] = condition;
            return this.addValidators(valsObject);
        }
    },

    //>	@classMethod	Validator.addValidators()	(A)
    //  Add several new validator types at once, as though +link{addValidator()} were called
    //  several times.
    // 
    //   @group	validation
    //   @param	newValidators	(object)	Set of validators to add.  This parameter should
    //      be a JavaScript object where the property names are validator type names, and the
    //      property values are condition functions or expressions, for example:<br>
    //      &nbsp;&nbsp;&nbsp;<code>{type1:condition1, type2:condition2}</code><br>.
    //
    // @visibility external
    // @see Validator.addValidator()
    //<
    addValidators : function (newValidators) {
        for (var type in newValidators) {
            if (!isc.isA.Function(newValidators[type])) {
                isc.Func.replaceWithMethod(newValidators, type, "item,validator,value");
            }
        }
    	isc.addMethods(this._validatorFunctions, newValidators);
    }
    
    
});
