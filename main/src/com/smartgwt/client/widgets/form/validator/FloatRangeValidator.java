package com.smartgwt.client.widgets.form.validator;

/**
 * Tests whether the value for this field is a floating point number within the range specified
 * by validator.min and validator.max.  By default, the valid range is inclusive of the min and max values.
 * Set validator.exclusive to have values that equal min or max fail validation. 
 * <p/>
 * Note that the errorMessage for this validator
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

    /**
     * Set the exclusive flag - when true, causes values that equal the min or max values to
     * fail validation.
     *
     * @param exclusive whether the valid range is exclusive of the min and max
     */
    public void setExclusive(Boolean exclusive) {
        setAttribute("exclusive", exclusive);
    }
    /**
     * Return the exclusive setting.
     *
     * @return the exclusive value
     */
    public Boolean getExclusive() {
        return getAttributeAsBoolean("exclusive");
    }


}
