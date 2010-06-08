package com.smartgwt.client.widgets.form.fields;

import com.smartgwt.client.core.*;

import com.google.gwt.core.client.JavaScriptObject;

public class IntegerItem extends FormItem {

    public static IntegerItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (IntegerItem) obj;
        } else {
            return new IntegerItem(jsObj);
        }
    }

    public IntegerItem() {
        setType("integer");
        setAttribute("editorType", "TextItem");
    }
    
    public IntegerItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public IntegerItem(String name) {
        setName(name);
        setType("integer");
    }

    public IntegerItem(String name, String title) {
        setName(name);
		setTitle(title);
        setType("integer");
    }
}
