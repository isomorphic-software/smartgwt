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
public enum SelectionAppearance implements ValueEnum {
    /**
     * selected rows should be shown with different appearance -
     * see ListGrid.getCellStyle() and optionally ListGrid.selectionCanvas.
     */
    ROW_STYLE("rowStyle"),

    /**
     * an extra, non-data column should be automatically added to the ListGrid, showing checkboxes
     * that can be toggled to select rows. See ListGrid.getCheckboxField.
     */
    CHECKBOX("checkbox");

    private String value;

    SelectionAppearance(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
