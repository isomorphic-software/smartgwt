package com.smartgwt.client.widgets.form.fields;

import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.ObjectFactory;
import com.google.gwt.core.client.JavaScriptObject;

public class FormItemFactory {

    public static FormItem getFormItem(JavaScriptObject fieldJS) {
        return getFormItem(fieldJS, null);
    }

    public static FormItem getFormItem(JavaScriptObject fieldJS, JavaScriptObject formJS) {
        FormItem formItem = (FormItem) FormItem.getRef(fieldJS);
        if (formItem != null) return formItem;

        // SC fieldJS instance exists - build appropriate SGWT FormItem wrapper
        if (JSOHelper.isScClassInstance(fieldJS)) {
            String className = JSOHelper.getClassName(fieldJS);
            return ObjectFactory.createFormItem(className, fieldJS);
        }

        // no SC fieldJS instance exists - check editorType or create a TextItem
        String editorType = getEditorType(fieldJS, formJS);
        FormItem item = ObjectFactory.createFormItem(editorType, fieldJS);
        return item == null ? new TextItem(fieldJS) : item;
    }

    private static native String getEditorType(JavaScriptObject fieldJS, JavaScriptObject formJS) /*-{
        var editorType;
        if ($wnd.isc.DynamicForm && $wnd.isc.isA.DynamicForm(formJS)) editorType = formJS.getEditorType(fieldJS);
        return editorType || fieldJS.editorType || "TextItem";
    }-*/;

}
