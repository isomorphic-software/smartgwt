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
 
package com.smartgwt.client.types;

/**
 * Passed as a parameter to {@link com.smartgwt.client.widgets.Canvas#showClickMask Canvas.showClickMask} to determine the
 * masks behavior when clicked.
 */
public enum ClickMaskMode implements ValueEnum {
    /**
     * When the mask receives a click, it will fire its click action, and cancel the event, leaving the clickMask up.
     */
    HARD("hard"),
    /**
     * When the mask receives a click, it will fire its click action, then dismiss the clickMask and allow the event to proceed
     * to its target.
     */
    SOFT("soft");

    private String value;

    ClickMaskMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
