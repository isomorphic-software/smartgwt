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
 * Position of a {@link com.smartgwt.client.widgets.grid.ListGrid#recordDrop ListGrid.recordDrop} operation with respect to
 * the target record.
 */
public enum RecordDropPosition implements ValueEnum {
    /**
     * User dropped directly onto the record
     */
    OVER("over"),
    /**
     * User dropped before the record
     */
    BEFORE("before"),
    /**
     * User dropped after the record
     */
    AFTER("after"),
    /**
     * Drop position is not over a record
     */
    NONE("none");
    private String value;

    RecordDropPosition(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
