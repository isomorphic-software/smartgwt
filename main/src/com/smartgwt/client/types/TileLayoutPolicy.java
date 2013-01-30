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
 * Policy for laying out tiles.  <P> Because a TileLayout can be either horizontally or vertically oriented, the general
 * term "line" is used to mean either a row or column of tiles.  <P> <b>NOTE</b>: for typical form layouts (a variety of
 * input fields and buttons in a tabular layout with col-spanning and row-spanning support), use a {@link
 * com.smartgwt.client.widgets.form.DynamicForm} and see the {@link com.smartgwt.client.docs.FormLayout} topic.
 */
public enum TileLayoutPolicy implements ValueEnum {
    /**
     * Each line has the same number of tiles, based on {@link com.smartgwt.client.widgets.tile.TileLayout#getTilesPerLine
     * tilesPerLine} if set, otherwise, based on fitting as many tiles per line as possible consistent with {@link
     * com.smartgwt.client.widgets.tile.TileLayout#getTileSize tileSize} and {@link
     * com.smartgwt.client.widgets.tile.TileLayout#getTileMargin tileMargin}.  <P> Tiles that do not specify a size will be
     * sized to fill available space.
     */
    FIT("fit"),
    /**
     * Tiles are laid out with varying numbers of tiles per line according to each tile's size, the {@link
     * com.smartgwt.client.widgets.tile.TileLayout#getTileMargin tileMargin}, and the available space. <P> Tiles are never
     * resized by the TileLayout and {@link com.smartgwt.client.widgets.tile.TileLayout#getTileSize tileSize} is ignored.
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
