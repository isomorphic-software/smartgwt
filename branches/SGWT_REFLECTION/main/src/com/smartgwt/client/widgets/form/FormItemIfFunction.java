package com.smartgwt.client.widgets.form;

import com.smartgwt.client.widgets.form.fields.FormItem;

/**
 * @see com.smartgwt.client.widgets.form.fields.FormItem#setShowIfCondition(FormItemIfFunction) 
 */
public interface FormItemIfFunction {

    boolean execute(FormItem item, Object value, DynamicForm form);
}
