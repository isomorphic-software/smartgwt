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
 * Appearance for a SelectItem that allows multiple selection
 */

public enum MultipleAppearance implements ValueEnum {

    /**
     * a drop-down picklist that allows multiple choices by              clicking on a checkbox next
     * to each item
     */
    PICKLIST("picklist"),

    /**
     * a grid that displays all items in-place. Multiple selection              acccomplished by
     * ctrl-click or shift-click.
     */
    GRID("grid");
    private String value;

    MultipleAppearance(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return this.value;
    }
}

