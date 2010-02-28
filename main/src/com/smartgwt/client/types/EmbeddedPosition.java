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
 * The position of an embedded ListGrid component with respect to the record or cell.
 */
public enum EmbeddedPosition implements ValueEnum {
    /**
     * Component should be placed underneath normal record or cell content, expanding the records.  
     * Expanding records can result in variable height rows, in which can {@link com.smartgwt.client.widgets.grid.ListGrid#setVirtualScrolling(Boolean) virtualScrolling}
     * should be enabled.
     */
    EXPAND("expand"),
    /**
     * Component should be placed within the normal area of the record or cell. Percentage sizes will be treated as percentages of the record and
     * {@link com.smartgwt.client.widgets.Canvas#setSnapTo(String) snapTo} positioning settings are also allowed and refer to the rectangle of the record or cell.
     */
    WITHIN("within");

    private String value;

    EmbeddedPosition(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
