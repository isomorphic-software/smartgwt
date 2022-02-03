package com.smartgwt.client.widgets.form.validator;

/**
 * Tests whether the value for this field matches any value from an arbitrary list of acceptable values. The set of
 * acceptable values is specified via the list property on the validator, which should be set to an array of values. If
 * validator.list is not supplied, the valueMap for the field will be used. If there is no valueMap, not providing
 * validator.list is an error.
 */
public class InSetValidator extends Validator {

    public InSetValidator() {
        setAttribute("type", "inSet");
    }

    /**
     * Set the list.
     *
     * @param list the list
     */
    public void setList(String[] list) {
        setAttribute("list", list);
    }

}
