package com.smartgwt.client.widgets.form.fields;

import com.smartgwt.client.core.*;

import com.google.gwt.core.client.JavaScriptObject;

public class FloatItem extends FormItem {

    public static FloatItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (FloatItem) obj;
        } else {
            return new FloatItem(jsObj);
        }
    }

    public FloatItem() {
        setType("float");
    }

    public FloatItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public FloatItem(String name) {
        setName(name);
        setType("float");
    }

    public FloatItem(String name, String title) {
        setName(name);
		setTitle(title);
        setType("float");
    }
}
