package com.smartgwt.client.widgets.form.validator;

/**
 * Validation will fail if the value is not a string value.
 */
public class IsStringValidator extends Validator {

    public IsStringValidator() {
        setAttribute("type", "isString");
    }

}
