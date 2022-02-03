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
 * Mode for escaping text values when using {@link com.smartgwt.client.data.DataSource#recordsAsText
 * DataSource.recordsAsText()} or {@link com.smartgwt.client.data.DataSource#recordsFromText DataSource.recordsFromText()}.
 */
public enum EscapingMode implements ValueEnum {
    /**
     * Literal double quotes in data values are doubled (""), as expected by Microsoft Excel when pasting text values
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "double".
     */
    DOUBLE("double"),
    /**
     * double quotes in data values have a blackslash (\) prepended, similar to String escaping in JavaScript and Java
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "backslash".
     */
    BACKSLASH("backslash");
    private String value;

    EscapingMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
