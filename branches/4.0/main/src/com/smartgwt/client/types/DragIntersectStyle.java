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
 * Different styles of determining intersection: with mouse or entire rect of target
 */
public enum DragIntersectStyle implements ValueEnum {
    /**
     * Look for drop targets that are under the current mouse cursor position.
     */
    MOUSE("mouse"),
    /**
     * Look for drop targets by intersection of the entire rect of the drag target with the droppable target.
     */
    RECT("rect");
    private String value;

    DragIntersectStyle(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
