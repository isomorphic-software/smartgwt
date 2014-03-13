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
 * Controls where a drag-item should be dropped in relation to the target row
 */
public enum ReorderPosition implements ValueEnum {
    /**
     * Drop the drag-item before the target-row
     */
    BEFORE("BEFORE"),
    /**
     * Drop the drag-item after the target-row
     */
    AFTER("AFTER"),
    /**
     * Drop the drag-item over (onto) the target-row
     */
    OVER("OVER");
    private String value;

    ReorderPosition(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
