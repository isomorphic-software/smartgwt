package com.smartgwt.client.widgets.form;

import com.smartgwt.client.widgets.form.fields.FormItem;

public interface FormItemInputTransformer {

    /**
     * Called when a FormItem's value is about to change as the result of user interaction. This method fires after the user performed an
     * action that would change the value of this field, and allows the developer to modify / reformat the value before it gets validated / saved.
     * Fires before the {@link FormItem#addChangeHandler(com.smartgwt.client.widgets.form.fields.events.ChangeHandler) change} event.
     * 
     * @param form the managing DynamicForm instane
     * @param item the form item itself
     * @param value the new value of the form item
     * @param oldValue the previous (current) value of the form item
     *
     * @return the desired new value for the form item
     */
    Object transformInput(DynamicForm form, FormItem item, Object value, Object oldValue);
}
