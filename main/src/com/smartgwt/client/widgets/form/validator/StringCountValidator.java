package com.smartgwt.client.widgets.form.validator;

/**
 * Determine whether a string value contains some substring multiple times. The substring to check for is specified via
 * validator.substring. The validator.operator property allows you to specify how to test the number of substring
 * occurrances. Valid values for this property are ==, !=, <, <=, >, >=.The number of matches to check for is specified
 * via validator.count.
 */
public class StringCountValidator extends Validator {

    public StringCountValidator() {
        setAttribute("type", "requiredIf");
    }

    /**
     * Set the substring.
     *
     * @param substring the substring
     */
    public void setSubstring(String substring) {
        setAttribute("substring", substring);
    }

    /**
     * Return the substring.
     *
     * @return the substring
     */
    public String getSubstring() {
        return getAttribute("substring");
    }

    /**
     * Set the operator.
     *
     * @param operator the operator
     */
    public void setOperator(String operator) {
        setAttribute("operator", operator);
    }

    /**
     * Return the operator.
     *
     * @return the operator
     */
    public String getOperator() {
        return getAttribute("operator");
    }

    /**
     * Set the count.
     *
     * @param count the count
     */
    public void setCount(int count) {
        setAttribute("count", count);
    }

    /**
     * Return the count.
     *
     * @return the count
     */
    public int getCount() {
        return getAttributeAsInt("count");
    }


}
