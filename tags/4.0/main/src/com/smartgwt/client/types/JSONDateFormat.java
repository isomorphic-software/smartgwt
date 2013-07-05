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
 * Format for encoding dates in JSON.  Note you can override {@link com.smartgwt.client.util.JSONEncoder#encodeDate
 * JSONEncoder.encodeDate} for a custom format.
 */
public enum JSONDateFormat implements ValueEnum {
    /**
     * dates are is encoded as a String in <a target=_blank href="http://www.w3.org/TR/xmlschema-2/#dateTime">XML Schema date
     * format</a> in UTC, for example, "2005-08-02" for logical date fields or "2005-08-01T21:35:48.350" for
     * <code>datetime</code> fields. See {@link com.smartgwt.client.docs.DateFormatAndStorage Date format and storage} for more
     * information.
     */
    XML_SCHEMA("xmlSchema"),
    /**
     * dates are encoded as raw JavaScript code for creating a Date object, that is:
     *  <pre>
     *  new Date(1238792738633)
     *  </pre>
     *  This is not strictly valid JSON, but if eval()d, will result in an identical date object,
     *  regardless of timezone.
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
