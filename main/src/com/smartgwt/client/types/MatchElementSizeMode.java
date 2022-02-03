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
 * How should a canvas match its target {@link com.smartgwt.client.widgets.Canvas#getHtmlElement Canvas.htmlElement} size?
 */
public enum MatchElementSizeMode implements ValueEnum {
    /**
     * canvas will be sized to match the element
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "matchElement".
     */
    MATCHELEMENT("matchElement"),
    /**
     * htmlElement should be sized to match the specified size of the canvas
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "sizeElement".
     */
    SIZEELEMENT("sizeElement"),
    /**
     * do not attempt to match the canvas / element size
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "none".
     */
    NONE("none");
    private String value;

    MatchElementSizeMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}