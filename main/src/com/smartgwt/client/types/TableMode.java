/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * is published by the Free Software Foundation.  Smart GWT is also
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
 * Controls the display mode of TableView record display
 */
public enum TableMode implements ValueEnum {
    /**
     * The default mode which displays a list of rows
     */
	 PLAIN("plain"),
	 
    /**
     * Grouped table is a set of rows embedded in a rounded rectangle
     * 
     */
	 GROUPED("grouped");


    private String value;

    TableMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
