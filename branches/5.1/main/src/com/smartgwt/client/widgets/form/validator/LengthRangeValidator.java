package com.smartgwt.client.widgets.form.validator;

/**
 * This validator type applies to string values only. If the value is a string value validation will fail if the strings
 * length falls outside the range specified by validator.max and validator.min. Note that non-string values will always
 * pass validation by this validator type.
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
    public void setMin(Integer min) {
        setAttribute("min", min);
    }

    /**
     * Return the min.
     *
     * @return the min
     */
    public Integer getMin() {
        return getAttributeAsInt("min");
    }

    /**
     * Set the max.
     *
     * @param max the max
     */
    public void setMax(Integer max) {
        setAttribute("max", max);
    }

    /**
     * Return the max.
     *
     * @return the max
     */
    public Integer getMax() {
        return getAttributeAsInt("max");
    }
}
