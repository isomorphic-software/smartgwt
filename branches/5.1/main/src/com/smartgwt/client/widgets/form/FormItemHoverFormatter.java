package com.smartgwt.client.widgets.form;

import com.smartgwt.client.widgets.form.fields.FormItem;

/**
 * If defined, this method should return the HTML to display in a hover canvas when the user holds the mousepointer over this item.
 * Return null to suppress the hover canvas altogether.
 */
public interface FormItemHoverFormatter {

    /**
     * The html to render on hover.
     *
     * @param item the form item
     * @param form the form
     * @return the hover html
     */
    String getHoverHTML(FormItem item, DynamicForm form);
}
