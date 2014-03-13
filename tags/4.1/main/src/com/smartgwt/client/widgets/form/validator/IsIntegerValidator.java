package com.smartgwt.client.widgets.form.validator;

/**
 * Tests whether the value for this field is a whole number. If validator.convertToInteger is true, float values will be
 * converted into integers and validation will succeed.
 */
public class IsIntegerValidator extends Validator {

    public IsIntegerValidator() {
        setAttribute("type", "isInteger");
    }

    /**
     * Set the convertToInteger.
     *
     * @param convertToInteger the convertToInteger
     */
    public void setConvertToInteger(boolean convertToInteger) {
        setAttribute("convertToInteger", convertToInteger);
    }

    /**
     * Return the convertToInteger.
     *
     * @return the convertToInteger
     */
    public boolean getConvertToInteger() {
        return getAttributeAsBoolean("convertToInteger");
    }


}
