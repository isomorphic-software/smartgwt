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
 * What do we do with data that's been dropped into another list?
 */

public enum DragDataAction implements ValueEnum {
    /**
     * Don't do anything, resulting in the same data being in both lists.
     */
    NONE("none"),
    /**
     * Copy the data leaving the original in our list.
     */
    COPY("copy"),
    /**
     * Remove the data from this list so it can be moved into the other list.
     */
    MOVE("move");
    private String value;

    DragDataAction(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

