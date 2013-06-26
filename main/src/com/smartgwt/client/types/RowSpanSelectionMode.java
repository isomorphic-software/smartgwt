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
 * Behavior of selection when row spanning is active.  See {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getUseRowSpanStyling useRowSpanStyling}.
 */
public enum RowSpanSelectionMode implements ValueEnum {
    /**
     * when a cell is clicked on, select any cells in subsequent columns which are at least partially spanned by the clicked
     * cell
     */
    FORWARD("forward"),
    /**
     * when a cell is clicked on, selects any cells in any other columns which are at least partially spanned by the clicked
     * cell
     */
    BOTH("both"),
    /**
     * behaves like "forward", except as though the cell in the first column was clicked instead. If the largest row spans are
     * in the first column and all cells in subsequent columns do not extend out of the first cell's span, this creates a
     * row-like selection model where the span of the left-most cell defines the "row" of cells being selected.
     */
    OUTERSPAN("outerSpan");
    private String value;

    RowSpanSelectionMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
