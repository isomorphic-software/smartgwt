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
 */
public enum ImageStyle implements ValueEnum {
    /**
     * Center (and don't stretch at all) the image if smaller than its enclosing frame.CENTER:"center",
     */
    CENTER("center"),
    /**
     * Tile (repeat) the image if smaller than its enclosing frame.
     */
    TILE("tile"),
    /**
     * Stretch the image to the size of its enclosing frame.
     */
    STRETCH("stretch"),
    /**
     * Allow the image to have natural size
     */
    NORMAL("normal");

    private String value;

    ImageStyle(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
