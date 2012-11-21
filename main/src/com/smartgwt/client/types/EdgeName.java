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
 * An edge or corner of a rectange, or it's center.  Used in APIs such as {@link
 * com.smartgwt.client.widgets.Canvas#getResizeFrom resizeFrom} and {@link com.smartgwt.client.widgets.Canvas#getEventEdge
 * Canvas.getEventEdge}.
 */
public enum EdgeName implements ValueEnum {
    /**
     * top edge
     */
    T("T"),
    /**
     * bottom edge
     */
    B("B"),
    /**
     * left edge
     */
    L("L"),
    /**
     * right edge
     */
    R("R"),
    /**
     * top-left corner
     */
    TL("TL"),
    /**
     * top-right corner
     */
    TR("TR"),
    /**
     * bottom-left corner
     */
    BL("BL"),
    /**
     * bottom-right corner
     */
    BR("BR"),
    /**
     * center
     */
    C("C");
    private String value;

    EdgeName(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
        
