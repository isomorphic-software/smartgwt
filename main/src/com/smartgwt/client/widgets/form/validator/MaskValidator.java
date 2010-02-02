package com.smartgwt.client.widgets.form.validator;

/**
 * Validate against a regular expression mask, specified as validator.mask. If validation is successful a transformation
 * can also be specified via the validator.transformTo property. This should be set to a string in the standard format
 * for string replacement via the native JavaScript replace()  method.
 */
public class MaskValidator extends Validator {

    public MaskValidator() {
        setAttribute("type", "mask");
    }

    /**
     * Set the mask.  Eg : ^\s*(1?)\s*\(?\s*(\d{3})\s*\)?\s*-?\s*(\d{3})\s*-?\s*(\d{4})\s*$
     *
     * @param mask the mask
     */
    public void setMask(String mask) {
        setAttribute("mask", mask);
    }

    /**
     * Return the mask.
     *
     * @return the mask
     */
    public String getMask() {
        return getAttribute("mask");
    }

    /**
     * Set the transformTo. Eg : $1($2) $3 - $4
     *
     * @param transformTo the transformTo
     */
    public void setTransformTo(String transformTo) {
        setAttribute("transformTo", transformTo);
    }

    /**
     * Return the transformTo.
     *
     * @return the transformTo
     */
    public String getTransformTo() {
        return getAttribute("transformTo");
    }

}
