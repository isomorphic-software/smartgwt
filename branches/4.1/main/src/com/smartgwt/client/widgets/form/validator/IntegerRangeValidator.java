package com.smartgwt.client.widgets.form.validator;

/**
 * Tests whether the value for this field is a whole number within the range specified. The max and min properties on
 * the validator are used to determine the acceptable range..
 */
public class IntegerRangeValidator extends Validator {

    public IntegerRangeValidator() {
        setAttribute("type", "integerRange");
    }

    /**
     * Set the min.
     *
     * @param min the min
     */
    public void setMin(int min) {
        setAttribute("min", min);
    }

    /**
     * Return the min.
     *
     * @return the min
     */
    public int getMin() {
        return getAttributeAsInt("min");
    }

    /**
     * Set the max.
     *
     * @param max the max
     */
    public void setMax(int max) {
        setAttribute("max", max);
    }

    /**
     * Return the max.
     *
     * @return the max
     */
    public int getMax() {
        return getAttributeAsInt("max");
    }
}
