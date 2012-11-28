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
 * How data selection should be presented to the user.
 */
public enum SelectionAppearance implements ValueEnum {
    /**
     * selected rows should be shown with different appearance - see {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCellStyle ListGrid.getCellStyle} and optionally {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSelectionCanvas selectionCanvas}.
     */
    ROW_STYLE("rowStyle"),
    /**
     * an extra, non-data column should be automatically added to the ListGrid, showing checkboxes that can be toggled to
     * select rows.  See {@link com.smartgwt.client.widgets.grid.ListGrid#getCheckboxField ListGrid.getCheckboxField}.
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
        
