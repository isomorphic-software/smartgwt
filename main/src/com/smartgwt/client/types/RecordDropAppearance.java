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
 * Controls how ListGrid record drop events report their {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getRecordDropPosition dropPosition}, and where the drop indicator will be
 * displayed if appropriate.
 */
public enum RecordDropAppearance implements ValueEnum {
    /**
     * When the user drops onto a record, dropPosition will always be "over"
     */
    OVER("over"),
    /**
     * When the user drops onto a record, dropPosition will be either "before" or "after" depending on whether the mouse was
     * over the top or bottom of the target record
     */
    BETWEEN("between"),
    /**
     * When the user drops onto a record, if the drop occurs centered over the record, the dropPosition will be reported as
     * "over", otherwise it will be "before" or "after" depending on whether the mouse was over the top or bottom of the target
     * record.
     */
    BOTH("both"),
    /**
     * No dropPosition will be reported
     */
    BODY("body");
    private String value;

    RecordDropAppearance(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
