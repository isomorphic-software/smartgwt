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
 * Determines sizing model when sizing / positioning a canvas relative to its {@link
 * com.smartgwt.client.widgets.Canvas#getPercentBox percentBox}.
 */
public enum PercentBoxModel implements ValueEnum {
    /**
     * use coordinates relative to the {@link com.smartgwt.client.widgets.Canvas#getVisibleHeight drawn height} and width of
     * the other canvas
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "visible".
     */
    VISIBLE("visible"),
    /**
     * use coordinates relative to the {@link com.smartgwt.client.widgets.Canvas#getViewportHeight drawn viewport height} and
     * width of the other canvas
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "viewport".
     */
    VIEWPORT("viewport"),
    /**
     * use coordinates relative to the {@link com.smartgwt.client.widgets.Canvas#getHeight specified height} and width of the
     * other canvas. For  {@link com.smartgwt.client.widgets.Canvas#getOverflow overflow:"visible"} canvases this may be
     * smaller than drawn size.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "specified".
     */
    SPECIFIED("specified"),
    /**
     * use coordinates relative to the {@link com.smartgwt.client.widgets.Canvas#getInnerHeight specified inner height} and
     * width of the other canvas
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "inner".
     */
    INNER("inner");
    private String value;

    PercentBoxModel(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
