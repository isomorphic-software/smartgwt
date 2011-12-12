package com.smartgwt.client.widgets.form.validator;

/**
 * Tests whether the value for this field is a floating point number within the range specified. The max and min
 * properties on the validator are used to determine the acceptable range. Note that the errorMessage for this validator
 * will be evaluated as a dynamicString - text within ${...} will be evaluated as JS code when the message is displayed,
 * with max and min available as variables mapped to validator.max and validator.min.
 */
public class FloatRangeValidator extends Validator {

    public FloatRangeValidator() {
        setAttribute("type", "floatRange");
    }

    /**
     * Set the min.
     *
     * @param min the min
     */
    public void setMin(float min) {
        setAttribute("min", min);
    }

    /**
     * Return the min.
     *
     * @return the min
     */
    public float getMin() {
        return getAttributeAsFloat("min");
    }

    /**
     * Set the max.
     *
     * @param max the max
     */
    public void setMax(float max) {
        setAttribute("max", max);
    }

    /**
     * Return the max.
     *
     * @return the max
     */
    public float getMax() {
        return getAttributeAsFloat("max");
    }


}
