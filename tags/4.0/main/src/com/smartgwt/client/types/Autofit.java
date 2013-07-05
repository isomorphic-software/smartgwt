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
 * Possible values for to change the behavior of how data will fill the ListGrid.
 */
public enum Autofit implements ValueEnum {
    /**
     * expand vertically to accommodate records.
     */
    VERTICAL("vertical"),
    /**
     * expand horizontally to accommodate fields.
     */
    HORIZONTAL("horizontal"),
    /**
     * expand horizontally and vertically to accommodate content.
     */
    BOTH("both");
    private String value;

    Autofit(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
