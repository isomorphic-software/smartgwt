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
 * Selection model for CubeGrid indicating which cells in the body should be selected
 *  when row or column headers are selected.
 */
public enum AutoSelectionModel implements ValueEnum {
    /**
     * Show the Save As dialog and download the file
     */
    DOWNLOAD("download"),
    /**
     * Rows and Columns will be selected on header selection
     */
    BOTH("both"),
    
    /**
     *   Rows will be selected on row-header selection
     */
    ROWS("rows"),
    
    /**
     *   Columns will be selected on column-header selection
     */
    COLUMNS("cols"),
    
    /**
     *   Selecting row or column headers will not select cells in the body.
     */
    NONE("none");

    private String value;

    AutoSelectionModel(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
