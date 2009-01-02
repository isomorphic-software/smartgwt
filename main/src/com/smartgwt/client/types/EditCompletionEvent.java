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
 * What event / user interaction type caused cell editing to complete.
 */

public enum EditCompletionEvent implements ValueEnum {
    /**
     * User clicked outside editor during edit.
     */
    CLICK_OUTSIDE("click_outside"),
    /**
     * User started editing another row by clicking on it
     */
    CLICK("click"),
    /**
     * User started editing another row by double  clicking
     */
    DOUBLE_CLICK("double_click"),
    /**
     * Enter pressed.
     */
    ENTER_KEYPRESS("enter_keypress"),
    /**
     * User pressed Escape.
     */
    ESCAPE_KEYPRESS("escape_keypress"),
    /**
     * Up arrow key pressed.
     */
    UP_ARROW_KEYPRESS("up_arrow_keypress"),
    /**
     * down arrow key.
     */
    DOWN_ARROW_KEYPRESS("down_arrow_keypress"),
    /**
     * User pressed Tab.
     */
    TAB_KEYPRESS("tab_keypress"),
    /**
     * User pressed Shift+Tab.
     */
    SHIFT_TAB_KEYPRESS("shift_tab_keypress"),
    /**
     * Edit moved to a different field (same row)
     */
    EDIT_FIELD_CHANGE("edit_field_change"),
    /**
     * Edit completed via explicit function call
     */
    PROGRAMMATIC("programmatic");
    private String value;

    EditCompletionEvent(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

