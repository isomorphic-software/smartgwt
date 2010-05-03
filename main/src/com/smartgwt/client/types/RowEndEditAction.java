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
 * While editing a ListGrid, what cell should we edit when the user attempts to navigate &#010  into a cell past the end
 * of an editable row, via a Tab keypress, or a programmatic&#010  saveAndEditNextCell() call?
 */

public enum RowEndEditAction implements ValueEnum {
    /**
     * navigate to the first editable cell in the same record
     */
    SAME("same"),
    /**
     * navigate to the first editable cell in the next record
     */
    NEXT("next"),
    /**
     * complete the edit.
     */
    DONE("done"),
    /**
     * Leave focus in the cell being edited (take no action)
     */
    STOP("stop");

    /**
     * take no action
     */
    NONE("none");
    
    private String value;

    RowEndEditAction(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

