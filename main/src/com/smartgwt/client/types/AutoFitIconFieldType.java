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
 * How should fields of {@link com.smartgwt.client.types.ListGridFieldType type:"icon"} be sized by default?
 */
public enum AutoFitIconFieldType implements ValueEnum {
    /**
     * Apply no special sizing to icon fields - treat them like any other field in the grid
     */
    NONE("none"),
    /**
     * size the field to accommodate the width of the icon
     */
    ICONWIDTH("iconWidth"),
    /**
     * size the field to accommodate the title (or the width of the icon if it exceeds the width of the title.
     */
    TITLE("title");
    private String value;

    AutoFitIconFieldType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
