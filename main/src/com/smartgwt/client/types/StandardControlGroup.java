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
 */
public enum StandardControlGroup implements ValueEnum {
    /**
     * {@link com.smartgwt.client.widgets.RichTextEditor#getFontControls Font controls}
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "fontControls".
     */
    FONTCONTROLS("fontControls"),
    /**
     * {@link com.smartgwt.client.widgets.RichTextEditor#getFormatControls Text formatting controls}
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "formatControls".
     */
    FORMATCONTROLS("formatControls"),
    /**
     * {@link com.smartgwt.client.widgets.RichTextEditor#getStyleControls Text styling controls}
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "styleControls".
     */
    STYLECONTROLS("styleControls"),
    /**
     * {@link com.smartgwt.client.widgets.RichTextEditor#getColorControls Color controls}
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "colorControls".
     */
    COLORCONTROLS("colorControls"),
    /**
     * {@link com.smartgwt.client.widgets.RichTextEditor#getBulletControls HTML list controls}
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "bulletControls".
     */
    BULLETCONTROLS("bulletControls");
    private String value;

    StandardControlGroup(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}