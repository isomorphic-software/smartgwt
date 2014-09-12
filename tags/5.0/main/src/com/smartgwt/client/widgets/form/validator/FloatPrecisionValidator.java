package com.smartgwt.client.widgets.form.validator;

/**
 * Tests whether the value for this field is a floating point number with the appropriate number of decimal places -
 * specified in validator.precision  If the value is of higher precision, if validator.roundToPrecision is specified,
 * the value will be rounded to the specified number of decimal places and validation will pass, otherwise validation
 * will fail.
 */
public class FloatPrecisionValidator extends Validator {

    public FloatPrecisionValidator() {
        setAttribute("type", "floatPrecision");
    }

    /**
     * Set the precision.
     *
     * @param precision the precision
     */
    public void setPrecision(int precision) {
        setAttribute("precision", precision);
    }

    /**
     * Return the precision.
     *
     * @return the precision
     */
    public int getPrecision() {
        return getAttributeAsInt("precision");
    }

    /**
     * Set the roundToPrecision.
     *
     * @param roundToPrecision the roundToPrecision
     */
    public void setRoundToPrecision(int roundToPrecision) {
        setAttribute("roundToPrecision", roundToPrecision);
    }

    /**
     * Return the roundToPrecision.
     *
     * @return the roundToPrecision
     */
    public int getRoundToPrecision() {
        return getAttributeAsInt("roundToPrecision");
    }
}
