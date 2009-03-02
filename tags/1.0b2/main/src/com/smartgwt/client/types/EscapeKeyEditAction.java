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
 * What to do if the user hits escape while editing a cell.
 */

public enum EscapeKeyEditAction implements ValueEnum {
    /**
     * cancels the current edit and discards edit values
     */
    CANCEL("cancel"),
    /**
     * end editing
     */
    DONE("done");
    private String value;

    EscapeKeyEditAction(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

