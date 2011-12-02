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
 * Supported styles of drawing the endpoints of a line
 */
public enum LineCap implements ValueEnum {
    /**
     * Semicircular rounding
     */
    ROUND("round"),
    /**
     * Squared-off endpoint
     */
    SQUARE("square"),
    /**
     * Square endpoint, stops exactly at the line's end coordinates instead of extending 1/2 lineWidth further as "round" and
     * "square" do
     */
    BUTT("butt");

    private String value;

    LineCap(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
