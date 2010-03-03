package com.smartgwt.client.widgets.form.validator;

import com.google.gwt.core.client.JavaScriptObject;

public abstract class CustomValidator extends Validator {

    public CustomValidator() {
        setAttribute("type", "custom");
        setup(getJsObj());

    }

    protected abstract boolean condition(Object value);

    private native void setup(JavaScriptObject jsObj) /*-{
        var self = this;
        jsObj.condition = function(item, validator, value) {
            //var itemJ = @com.smartgwt.client.core.RefDataClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
            //if(itemJ == null) {
            //    itemJ = @com.smartgwt.client.widgets.form.fields.FormItem::new(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
            //}            
            var valueJ = $wnd.SmartGWT.convertToJavaType(value);
            return self.@com.smartgwt.client.widgets.form.validator.CustomValidator::condition(Ljava/lang/Object;)(valueJ);
        };
    }-*/;
}


