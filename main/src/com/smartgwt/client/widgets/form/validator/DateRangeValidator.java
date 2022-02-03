package com.smartgwt.client.widgets.form.validator;

import java.util.Date;

/**
 * Tests whether the value for a date field is within the range specified by validator.min 
 * and validator.max, which should be dates.  By default, the valid range is inclusive of the min and max values.
 * Set validator.exclusive to have values that equal min or max fail validation. 
 * <p/>
 * Note that the errorMessage for this validator will be evaluated as a dynamicString - text within ${...} will be
 * evaluated as JS code when the message is displayed, with max and min available as variables mapped to validator.max
 * and validator.min.
 */
public class DateRangeValidator extends Validator {

    public DateRangeValidator() {
        setAttribute("type", "dateRange");
    }

    /**
     * Set the min.
     *
     * @param min the min
     */
    public void setMin(Date min) {
        setAttribute("min", min);
    }

    /**
     * Return the min.
     *
     * @return the min
     */
    public Date getMin() {
        return getAttributeAsDate("min");
    }

    /**
     * Set the max.
     *
     * @param max the max
     */
    public void setMax(Date max) {
        setAttribute("max", max);
    }

    /**
     * Return the max.
     *
     * @return the max
     */
    public Date getMax() {
        return getAttributeAsDate("max");
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
