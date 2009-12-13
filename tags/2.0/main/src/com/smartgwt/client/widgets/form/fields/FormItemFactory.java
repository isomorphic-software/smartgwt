package com.smartgwt.client.widgets.form.fields;

import com.google.gwt.core.client.JavaScriptObject;

public class FormItemFactory {

    public static FormItem getFormItem(JavaScriptObject fieldJS) {
        //return as TextItem for now.
        return new TextItem(fieldJS);
    }
}
