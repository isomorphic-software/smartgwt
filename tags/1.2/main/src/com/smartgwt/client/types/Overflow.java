/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.types;

/**
 */

public enum Overflow implements ValueEnum {
    /**
     * Content that extends beyond the widget's width or height is                              displayed.&#010 Note: To
     * have the content be sized only by the drawn size of &#010 the content set the overflow to be Canvas.VISIBLE and
     * specify&#010 a small size, allowing the size to expand to the size required&#010 by the content.&#010
     *                  Leaving the width / height for the widget undefined will use the&#010
     *   default value of 100, and setting the size to zero may cause the&#010                              widget not
     * to draw.
     */
    VISIBLE("visible"),
    /**
     * Content that extends beyond the widget's width or height is                              clipped (hidden).
     */
    HIDDEN("hidden"),
    /**
     * Horizontal and/or vertical scrollbars are displayed only if                              necessary. Content that
     * extends beyond the remaining visible&#010                              area is clipped.
     */
    AUTO("auto"),
    /**
     * Horizontal and vertical scrollbars are always drawn inside the                              widget. Content that
     * extends beyond the remaining visible area&#010                              is clipped, and can be accessed via
     * scrolling.
     */
    SCROLL("scroll"),
    /**
     * Clip horizontally but extend the canvas's clip region                              vertically if necessary.
     */
    CLIP_H("clip_h"),
    /**
     * Clip vertically but extend the canvas's clip region                              horizontally if necessary.
     */
    CLIP_V("clip_v");
    private String value;

    Overflow(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

