package com.smartgwt.client.widgets.grid;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.core.DataClass;

public class HeaderSpan extends DataClass {

    public HeaderSpan() {
    }

    public HeaderSpan(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public HeaderSpan(String title, String[] fields) {
        setTitle(title);
        setFields(fields);
    }

    public void setTitle(String title) {
        setAttribute("title", title);
    }

    public String getTitle() {
        return getAttribute("title");
    }

    public void setFields(String... fields) {
        setAttribute("fields", fields);
    }

    public String[] getFields() {
        return getAttributeAsStringArray("fields");
    }
}
