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
/* sgwtgen */
 
/**
 * How a component should be embedded within its record or cell
 */
public enum EmbeddedPosition implements ValueEnum {
    /**
     * component should be placed underneath normal record or cell content, expanding the records. Expanding records can result
     * in variable height rows, in which case {@link com.smartgwt.client.widgets.grid.ListGrid#getVirtualScrolling
     * virtualScrolling} should be enabled.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "expand".
     */
    EXPAND("expand"),
    /**
     * component should be placed within the normal area of the record or cell. Percentage sizes will be treated as percentages
     * of the record and {@link com.smartgwt.client.widgets.Canvas#getSnapTo Canvas.snapTo} positioning settings are also
     * allowed and refer to the rectangle of the record or cell. Note that for components embedded within cells, cell align and
     * vAlign will be used if snapTo is unset (so top / left alignment of cell content will map to snapTo of "TL", etc).
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "within".
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
