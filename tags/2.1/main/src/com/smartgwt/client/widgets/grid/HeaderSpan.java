package com.smartgwt.client.widgets.grid;

import com.smartgwt.client.core.DataClass;

public class HeaderSpan extends DataClass {

    public HeaderSpan() {
    }

    public HeaderSpan(String title, String[] fields) {
        setTitle(title);
        setFields(fields);
    }

    public void setTitle(String title) {
        setAttribute("title", title);
    }

    public void setFields(String... fields) {
        setAttribute("fields", fields);
    }

}
