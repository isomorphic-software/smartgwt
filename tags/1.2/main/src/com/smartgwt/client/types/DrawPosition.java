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
public enum DrawPosition implements ValueEnum {
    /**
     * insert before the target element
     */
    BEFOREBEGIN("beforeBegin"),
    /**
     * insert as the target element's first child
     */
    AFTERBEGIN("afterBegin"),
    /**
     * insert as the target element's last child
     */
    BEFOREEND("beforeEnd"),
    /**
     * insert after the target element
     */
    AFTEREND("afterEnd"),
    /**
     * replace the target element
     */
    REPLACE("replace");
    private String value;

    DrawPosition(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

