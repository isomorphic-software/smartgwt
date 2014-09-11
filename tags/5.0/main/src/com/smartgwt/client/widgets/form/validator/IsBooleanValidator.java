package com.smartgwt.client.widgets.form.validator;

/**
 * Validation will fail if this field is non-empty and has a non-boolean value.
 */
public class IsBooleanValidator extends Validator {

    public IsBooleanValidator() {
        setAttribute("type", "isBoolean");
    }

}
