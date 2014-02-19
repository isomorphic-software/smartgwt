package com.smartgwt.client.data;

import com.smartgwt.client.core.DataClass;
import com.google.gwt.core.client.JavaScriptObject;

public class XmlNamespaces extends DataClass {

    public XmlNamespaces(){}

    public XmlNamespaces(JavaScriptObject jsObj){
        super(jsObj);
    }

    public void addNamespace(String prefix, String url) {
        setAttribute(prefix, url);
    }

}
