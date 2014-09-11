package com.smartgwt.client.widgets.form.validator;

/**
 * Determine whether a string value contains some substring specified via {@link #setSubstring(String) substring}.
 */
public class ContainsValidator extends Validator {

    public ContainsValidator() {
        setAttribute("type", "contains");
    }

    public void setSubstring(String substring) {
        setAttribute("substring", substring);
    }

    public String getSubstring() {
        return getAttribute("substring");
    }
}
