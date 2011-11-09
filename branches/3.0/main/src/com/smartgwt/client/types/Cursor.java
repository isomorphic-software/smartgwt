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
 * You can use whatever cursors are valid for your deployment platforms, but keep in mind that&#010 visual
 * representation may vary by browser and OS.
 */

public enum Cursor implements ValueEnum {

    ALL_SCROLL("all-scroll"),

    ARROW("arrow"),

    /**
     * Use the default arrow cursor for this browser/OS.
     */
    DEFAULT("default"),
    /**
     * Use the default cursor for this element type in this browser/OS
     */
    AUTO("auto"),
    /**
     * Use the wait cursor.
     */
    WAIT("wait"),
    /**
     * Use the hand cursor.
     */
    HAND("hand"),
    /**
     * Use the "move" (crosshairs) cursor.
     */
    MOVE("move"),
    /**
     * Use the 'help' cursor.
     */
    HELP("help"),
    /**
     * Use the 'text' (i-beam) cursor.
     */
    TEXT("text"),
    /**
     * Use the 'crosshair' ( + ) cursor.
     */
    CROSSHAIR("crosshair"),
    /**
     * Use the column resize cursor (horizontal double-tipped arrow)
     */
    COL_RESIZE("col-resize"),

    /**
     * Use the normal hand pointer that appears when you hover over a link
     */
    POINTER("pointer"),
    /**
     * Use the row resize cursor (vertical double-tipped arrow)
     */
    ROW_RESIZE("row-resize"),
    /**
     * Use the "east resize" cursor.
     */
    E_RESIZE("e-resize"),
    /**
     * Use the "west resize" cursor.
     */
    W_RESIZE("w-resize"),
    /**
     * Use the "north resize" cursor.
     */
    N_RESIZE("n-resize"),
    /**
     * Use the "south resize" cursor.
     */
    S_RESIZE("s-resize"),
    /**
     * Use the "south-east resize" cursor.
     */
    SE_RESIZE("se-resize"),
    /**
     * Use the "north-east resize" cursor.
     */
    NE_RESIZE("ne-resize"),
    /**
     * Use the "north-west resize" cursor.
     */
    NW_RESIZE("nw-resize"),
    /**
     * Use the "south-west resize" cursor.
     */
    SW_RESIZE("sw-resize"),
    /**
     * Use the "not-allowed" cursor.
     */
    NOT_ALLOWED("not-allowed");
    private String value;

    Cursor(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

