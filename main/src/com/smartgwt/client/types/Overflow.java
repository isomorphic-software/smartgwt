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
public enum Overflow implements ValueEnum {
    /**
     * Content that extends beyond the widget's width or height is displayed. Note: To have the content be sized only by the
     * drawn size of the content set the overflow to be Canvas.VISIBLE and specify a small size, allowing the size to expand to
     * the size required by the content. Leaving the width / height for the widget undefined will use the default value of 100,
     * and setting the size to zero may cause the widget not to draw.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "visible".
     */
    VISIBLE("visible"),
    /**
     * Content that extends beyond the widget's width or height is clipped (hidden).
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "hidden".
     */
    HIDDEN("hidden"),
    /**
     * Horizontal and/or vertical scrollbars are displayed only if necessary. Content that extends beyond the remaining visible
     * area is clipped.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "auto".
     */
    AUTO("auto"),
    /**
     * Horizontal and vertical scrollbars are always drawn inside the widget. Content that extends beyond the remaining visible
     * area is clipped, and can be accessed via scrolling.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "scroll".
     */
    SCROLL("scroll"),
    /**
     * Clip horizontally but extend the canvas's clip region vertically if necessary. <br><b>Note:</b> only supported for
     * specific widget subclasses.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "clip-h".
     */
    CLIP_H("clip-h"),
    /**
     * Clip vertically but extend the canvas's clip region horizontally if necessary. <br><b>Note:</b> only supported for
     * specific widget subclasses.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "clip-v".
     */
    CLIP_V("clip-v");
    private String value;

    Overflow(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
