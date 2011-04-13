package com.smartgwt.client.widgets.form.fields;

/**
 * Context object passed to FormItemFunctions containing information about the form item on which the function was fired
 */
public class FormItemFunctionContext {
    public FormItemFunctionContext() {
        
    }
    
    FormItem item;
    public void setFormItem(FormItem item) {
        this.item = item;
    }
    /**
     * Retrieves the form item on which this function is being fired.
     * @return
     */
    public FormItem getFormItem() {
        return this.item;
    }

}
