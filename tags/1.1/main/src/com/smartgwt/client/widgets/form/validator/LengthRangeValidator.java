package com.smartgwt.client.widgets.form.validator;

/**
 * This validator type applies to string values only. If the value is a string value validation will fail if the strings
 * length falls outside the range specified by validator.max and validator.min. Note that non-string values will always
 * pass validation by this validator type. Note that the errorMessage for this validator will be evaluated as a
 * dynamicString - text within ${...} will be evaluated as JS code when the message is displayed, with max and min
 * available as variables mapped to validator.max and validator.min.
 */
public class LengthRangeValidator extends Validator {

    public LengthRangeValidator() {
        setAttribute("type", "lengthRange");
    }

    /**
     * Set the min.
     *
     * @param min the min
     */
    public void setMin(String min) {
        setAttribute("min", min);
    }

    /**
     * Return the min.
     *
     * @return the min
     */
    public String getMin() {
        return getAttribute("min");
    }

    /**
     * Set the max.
     *
     * @param max the max
     */
    public void setMax(String max) {
        setAttribute("max", max);
    }

    /**
     * Return the max.
     *
     * @return the max
     */
    public String getMax() {
        return getAttribute("max");
    }
}