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
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "disc".
     */
    DISC("disc"),
    /**
     * An unfilled circle (&#9702;)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "circle".
     */
    CIRCLE("circle"),
    /**
     * A filled, black square (&#9632;)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "square".
     */
    SQUARE("square"),
    /**
     * Numbers (1., 2., 3., etc.)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "decimal".
     */
    DECIMAL("decimal"),
    /**
     * Uppercase Roman numerals (I., II., III., IV., etc.)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "upper-roman".
     */
    UPPER_ROMAN("upper-roman"),
    /**
     * Lowercase Roman numerals (i., ii., iii., iv., etc.)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "lower-roman".
     */
    LOWER_ROMAN("lower-roman"),
    /**
     * Uppercase letters (A., B., C., etc.)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "upper-alpha".
     */
    UPPER_ALPHA("upper-alpha"),
    /**
     * Lowercase letters (a., b., c., etc.)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "lower-alpha".
     */
    LOWER_ALPHA("lower-alpha"),
    /**
     * An image used in place of a marker.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "custom-image".
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
