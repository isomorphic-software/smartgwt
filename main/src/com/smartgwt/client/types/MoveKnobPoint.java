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
 * Specifies the starting point of a move knob with respect to its draw item. The move knob is positioned relative to the
 * move knob point at the {@link com.smartgwt.client.widgets.drawing.DrawItem#getMoveKnobOffset moveKnobOffset}.
 */
public enum MoveKnobPoint implements ValueEnum {
    /**
     * Top Left corner
     */
    TL("TL"),
    /**
     * Top Right corner
     */
    TR("TR"),
    /**
     * Bottom Left corner
     */
    BL("BL"),
    /**
     * Bottom Right corner
     */
    BR("BR");
    private String value;

    MoveKnobPoint(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
