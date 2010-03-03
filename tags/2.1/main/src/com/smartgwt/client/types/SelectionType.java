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
 * Controls how an object changes state when clicked
 */

public enum SelectionType implements ValueEnum {
    /**
     * object moves to "down" state temporarily (normal button)
     */
    BUTTON("button"),
    /**
     * object remains in "down" state until clicked again (checkbox)
     */
    CHECKBOX("checkbox"),
    /**
     * object moves to "down" state, causing another object to go up (radio)
     */
    RADIO("radio");
    private String value;

    SelectionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
