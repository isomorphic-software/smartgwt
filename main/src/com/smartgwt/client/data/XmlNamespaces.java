package com.smartgwt.client.data;

import com.smartgwt.client.core.DataClass;

public class XmlNamespaces extends DataClass {

    public void addNamespace(String prefix, String url) {
        setAttribute(prefix, url);
    }

}
