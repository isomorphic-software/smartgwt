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
 * What kind of mask to use for masking dragged element.
 */
public enum DragMaskType implements ValueEnum {
    /**
     * creates an element with ordinary HTML content that will block events
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "div".
     */
    DIV("div"),
    /**
     * creates an iframe with empty content
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "iframe".
     */
    IFRAME("iframe"),
    /**
     * hides the contents of this widget temporarily
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "hide".
     */
    HIDE("hide"),
    /**
     * no mask
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "none".
     */
    NONE("none");
    private String value;

    DragMaskType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}