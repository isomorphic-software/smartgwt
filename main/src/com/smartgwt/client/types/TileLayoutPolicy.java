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
public enum TileLayoutPolicy implements ValueEnum {
    /**
     * Each line has the same number of tiles, based on TileLayout.tilesPerLine if set, otherwise, based on fitting as
     * many tiles per line as possible consistent with tileSize and TileLayout.tileMargin.
     */
    FIT("fit"),
    /**
     * Tiles that do not specify a size will be sized to fill available space. Tiles are laid out with varying numbers
     * of tiles per line according to each tile's size, the tileMargin, and the available space. Tiles are never resized
     * by the TileLayout and TileLayout.tileSize is ignored.
     */
    FLOW("flow");

    private String value;

    TileLayoutPolicy(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
