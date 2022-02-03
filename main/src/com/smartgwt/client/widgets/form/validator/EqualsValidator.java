package com.smartgwt.client.widgets.form.validator;

/**
 * Determine whether a value matches a value specified via {@link #setValue(Object) value}.
 */
public class EqualsValidator extends Validator {

    public EqualsValidator() {
        setAttribute("type", "equals");
    }

    public void setValue(Object value) {
        setAttribute("value", value);
    }

    public String getValue() {
        return getAttribute("value");
    }
}
