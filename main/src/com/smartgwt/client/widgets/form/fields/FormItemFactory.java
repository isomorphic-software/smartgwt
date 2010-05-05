package com.smartgwt.client.widgets.form.fields;

import com.google.gwt.core.client.JavaScriptObject;

public class FormItemFactory {

    public static FormItem getFormItem(JavaScriptObject fieldJS) {
        FormItem formItem = (FormItem) FormItem.getRef(fieldJS);
        if(formItem != null) {
            return formItem;
        } else {
            //return as TextItem for now
            return new TextItem(fieldJS);
        }
    }
}
