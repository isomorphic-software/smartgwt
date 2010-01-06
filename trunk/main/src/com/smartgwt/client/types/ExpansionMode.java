/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.types;

public enum ExpansionMode implements ValueEnum {

    /**
     * Show a single field's value in an HTMLFlow. Field to use is listGrid.detailField.
     */
    DETAIL_FIELD("detailField"),
    /**
     * 	Show a DetailViewer displaying the remaining fields.
     */
    DETAILS("details"),
    /**
     * Show a seperate ListGrid containg Related-records. see ListGridRecord.detailDS and ListGrid.recordDetailDSProperty
     * for more information.
     */
    RELATED("related"),
    /**
     *	Show a DynamicForm to edit the record
     */
    EDITOR("editor"),
    /**
     * Drop the drag-item over (onto) the target-row.
     */
    DETAIL_RELATED("detailRelated");

    private String value;

    ExpansionMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
