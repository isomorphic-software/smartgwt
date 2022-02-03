package com.smartgwt.client.widgets.form.validator;

/**
 * Determine whether a value does not match a value specified via {@link #setValue(Object) value}.
 */
public class NotEqualValidator extends Validator {

    public NotEqualValidator() {
        setAttribute("type", "notEqual");
    }

    public void setValue(Object value) {
        setAttribute("value", value);
    }

    public String getValue() {
        return getAttribute("value");
    }
}
