package com.smartgwt.client.widgets.form.validator;

import com.smartgwt.client.widgets.form.fields.FormItem;

public interface RequiredIfFunction {

    boolean execute(FormItem formItem, Object value);
}
