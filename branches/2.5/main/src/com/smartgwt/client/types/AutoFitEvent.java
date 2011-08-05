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
 * Event on a listGrid header to trigger auto-fit of the listgrid field.
 */
public enum AutoFitEvent implements ValueEnum {
    /**
     * React to a double click on the listGrid header.
     */
    DOUBLECLICK("doubleClick"),

    /**
     * React to a click on the listGrid header.
     */
    CLICK("click"),

    /**
     * No event will trigger auto-fit.
     */
    NONE("none");

    private String value;

    AutoFitEvent(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
