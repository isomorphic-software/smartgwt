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

public abstract class UpdateTileCustomizer {
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
     * If both this method and 
     * {@link com.smartgwt.client.widgets.tile.TileGrid#createTile TileGrid.createTile} are 
     * defined and 
     * {@link com.smartgwt.client.widgets.tile.TileGrid#getRecycleTiles recycleTiles} is true,
     * this method will be called when the framework needs to recycle a tile to be used with a
     * new record.  This notification provides an opportunity to update any widget properties
     * that depend on the specifics of the record.
     *
     * @param record record that will be associated with the recycled tile
     * @param tileIndex index of the record in the tileGrid
     * @param reclaimedTile the tile to be recycled
     */
    public abstract void updateTile(Record record, Integer tileIndex, Canvas reclaimedTile);
} 
