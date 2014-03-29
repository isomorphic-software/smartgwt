package com.smartgwt.client.widgets.form.validator;

/**
 * Regexp type validators will determine whether the value specified matches a given regular expression. The expression
 * should be specified on the validator object as the <i>expression</i> property.
 */
public class RegExpValidator extends Validator {

    public RegExpValidator() {
        setAttribute("type", "regexp");
    }

    /**
     * Constructor.
     *
     * @param expression the regular expression
     */
    public RegExpValidator(String expression) {
        this();
        setExpression(expression);
    }

    /**
     * Set the expression.
     *
     * @param expression the expression
     */
    public void setExpression(String expression) {
        setAttribute("expression", expression);
    }

    /**
     * Return the expression.
     *
     * @return the expression
     */
    public String getExpression() {
        return getAttribute("expression");
    }
}
