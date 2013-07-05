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
     * User started editing another row by double clicking
     */
    DOUBLE_CLICK("doubleClick"),
    /**
     * Enter pressed.
     */
    ENTER_KEYPRESS("enter"),
    /**
     * User pressed Escape.
     */
    ESCAPE_KEYPRESS("escape"),
    /**
     * Up arrow key pressed.
     */
    UP_ARROW_KEYPRESS("arrow_up"),
    /**
     * down arrow key.
     */
    DOWN_ARROW_KEYPRESS("arrow_down"),
    /**
     * User pressed Tab.
     */
    TAB_KEYPRESS("tab"),
    /**
     * User pressed Shift+Tab.
     */
    SHIFT_TAB_KEYPRESS("shift_tab"),
    /**
     * Edit moved to a different field (same row)
     */
    EDIT_FIELD_CHANGE("field_change"),
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
