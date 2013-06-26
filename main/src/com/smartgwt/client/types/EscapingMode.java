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
 
/**
 * Mode for escaping text values when using {@link com.smartgwt.client.data.DataSource#recordsAsText
 * DataSource.recordsAsText} or {@link com.smartgwt.client.data.DataSource#recordsFromText DataSource.recordsFromText}.
 */
public enum EscapingMode implements ValueEnum {
    /**
     * Literal double quotes in data values are doubled (""), as expected by Microsoft Excel when pasting text values
     */
    DOUBLE("double"),
    /**
     * double quotes in data values have a blackslash (\) prepended, similar to String escaping in JavaScript and Java
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
