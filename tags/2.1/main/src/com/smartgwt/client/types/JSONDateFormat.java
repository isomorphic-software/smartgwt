/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.types;

/**
 * Format for encoding dates in JSON. Note you can override {@link com.smartgwt.client.util.JSONEncoder#encodeDate(java.util.Date)}
 * for a custom format.
 */
public enum JSONDateFormat implements ValueEnum {
    /**
     * dates are is encoded as a String in <a href="http://www.w3.org/TR/xmlschema-2/#dateTime">XML Schema date format</a> in UTC, for example, "2005-08-01T21:35:48.350"
     */
    XML_SCHEMA("xmlSchema"),

    /**
     * dates are encoded as raw JavaScript code for creating a Date object, that is: <br><br>
     * <code>new Date(1238792738633)</code>
     * <br><br>
     * This is not strictly valid JSON, but if eval()d, will result in an identical date object, regardless of timezone.
     */
    DATE_CONSTRUCTOR("dateConstructor");

    private String value;

    JSONDateFormat(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
