package com.smartgwt.client.widgets.form.validator;

/**
 * <br>RequiredIf type validators should be specified with an <code>expression</code> which takes three parameters: <ul>
 * <li>item - the DynamicForm item on which the error occurred (may be null)</li> <li>validator - a pointer to the
 * validator object</li> <li>value - the value of the field in question</li> </ul>
 * <p/>
 * When validation is perfomed, the expression will be evaluated - if it returns <code>true</code>, the field will be
 * treated as a required field, so validation will fail if the field has no value.
 */
public class RequiredIfValidator extends Validator {

    public RequiredIfValidator() {
        setAttribute("type", "requiredIf");
    }

    public RequiredIfValidator(RequiredIfFunction expression) {
        this();
        setExpression(expression);
    }

    /**
     * Set the expression.
     *
     * @param expression the expression
     */
    public native void setExpression(RequiredIfFunction expression) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();        
        self.expression = function(item, validator, value) {
            var itemJ = @com.smartgwt.client.core.RefDataClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
            if(itemJ == null) {
                itemJ = @com.smartgwt.client.widgets.form.fields.FormItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
            }
            var valueJ = $wnd.SmartGWT.convertToJavaType(value);
            return expression.@com.smartgwt.client.widgets.form.validator.RequiredIfFunction::execute(Lcom/smartgwt/client/widgets/form/fields/FormItem;Ljava/lang/Object;)(itemJ, valueJ);
        };
    }-*/;


}
