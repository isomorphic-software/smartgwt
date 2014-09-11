package com.smartgwt.client.widgets.form.validator;

import java.util.Date;

/**
 * Tests whether the value for a date field is within the range specified. Range is inclusive, and is specified via
 * validator.min and validator.max, which should be dates.
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


}
