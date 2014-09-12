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
 * The style of list item marker for a list.
 */
public enum ListStyleType implements ValueEnum {
    /**
     * A filled, black dot (&bull;)
     */
    DISC("disc"),
    /**
     * An unfilled circle (&#9702;)
     */
    CIRCLE("circle"),
    /**
     * A filled, black square (&#9632;)
     */
    SQUARE("square"),
    /**
     * Numbers (1., 2., 3., etc.)
     */
    DECIMAL("decimal"),
    /**
     * Uppercase Roman numerals (I., II., III., IV., etc.)
     */
    UPPER_ROMAN("upper-roman"),
    /**
     * Lowercase Roman numerals (i., ii., iii., iv., etc.)
     */
    LOWER_ROMAN("lower-roman"),
    /**
     * Uppercase letters (A., B., C., etc.)
     */
    UPPER_ALPHA("upper-alpha"),
    /**
     * Lowercase letters (a., b., c., etc.)
     */
    LOWER_ALPHA("lower-alpha"),
    /**
     * An image used in place of a marker.
     */
    CUSTOM_IMAGE("custom-image");
    private String value;

    ListStyleType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
