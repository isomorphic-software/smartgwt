package com.smartgwt.client.widgets.form.validator;

/**
 * Determine whether a string value does not contain some substring specified via validator.substring.
 */
public class DoesntContainValidator extends Validator {

    public DoesntContainValidator() {
        setAttribute("type", "doesntContain");
    }

    public void setSubstring(String substring) {
        setAttribute("substring", substring);
    }

    public String getSubstring() {
        return getAttribute("substring");
    }
}
