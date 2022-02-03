package com.smartgwt.client.types;


/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
/* sgwtgen */
 
/**
 * The data URL MIME type to use when {@link com.smartgwt.client.widgets.drawing.DrawPane#getDataURL DrawPane.getDataURL()}
 * is called to convert the drawing to a data URL.
 */
public enum DataURLFormat implements ValueEnum {
    /**
     * Any MIME type supported by the browser is acceptable. Note: The exact MIME type used may depend on the browser, and may
     * change from version to version of Smart GWT.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "any".
     */
    ANY("any"),
    /**
     * Generate an <code>image/png</code> data URL.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "png".
     */
    PNG("png");
    private String value;

    DataURLFormat(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
