/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2014 and beyond, Isomorphic Software, Inc.
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
 
package com.smartgwt.client.widgets.tile;

import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.Canvas;

public abstract class CreateTileCustomizer {
    private TileGrid grid;

    protected void setGrid(TileGrid grid) {
        this.grid = grid;
    }

    /**
     * Returns the TileGrid associated with this customizer.
     * @return the TileGrid
     */
    public TileGrid getGrid() {
        return this.grid;
    }

    /** 
     * If defined, this method will be called when a new tile is required.
     *
     * @param record record that will be associated with new tile
     * @param tileIndex index of the record in the tileGrid
     * @returns return the new tile that will hold the record (cannot be null)
     */
    public abstract Canvas createTile(Record record, Integer tileIndex);
} 
