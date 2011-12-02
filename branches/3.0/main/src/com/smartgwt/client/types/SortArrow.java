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
 
package com.smartgwt.client.types;

/**
 * Do we display an arrow for the sorted field ?
 */
public enum SortArrow implements ValueEnum {
    /**
     * Don't show a sort arrow at all.
     */
    NONE("none"),
    /**
     * Display sort arrow in the upper-right corner (above the scrollbar) only.
     */
    CORNER("corner"),
    /**
     * Display sort arrow above each field header only.
     */
    FIELD("field"),
    /**
     * Display sort arrow above each field header AND in corner above scrollbar.BOTH:"both", // NOTE: Canvas establishes this
     * constant
     */
    BOTH("both");

    private String value;

    SortArrow(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
