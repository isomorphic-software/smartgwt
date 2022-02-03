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
 * When  relative dates are specified in a date range, typically in a RelativeDateItem or DateRangeItem, in order to make
 * the range inclusive or exclusive, it is useful to be able  to specify whether we're referring to the start or end of the
 * date in question.
 */
public enum RelativeDateRangePosition implements ValueEnum {
    /**
     * Indicates this relative date should be treated as the start of the specified logical date.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "start".
     */
    START("start"),
    /**
     * Indicates this relative date should be treated as the end of the specified logical date.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "end".
     */
    END("end");
    private String value;

    RelativeDateRangePosition(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
