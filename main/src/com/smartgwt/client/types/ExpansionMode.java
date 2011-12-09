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
 * When {@link com.smartgwt.client.widgets.grid.ListGrid#getCanExpandRecords canExpandRecords} is true, ExpansionMode
 * dictates the type of UI to be displayed in the expanded portion of the row. <P> There are a number of builtin
 * ExpansionModes and you can override  {@link com.smartgwt.client.widgets.grid.ListGrid#getExpansionComponent
 * getExpansionComponent()} to create your own expansion behaviors.
 */
public enum ExpansionMode implements ValueEnum {
    /**
     * Show a single field's value in an {@link com.smartgwt.client.widgets.HTMLFlow}. Field to use is {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDetailField detailField}.
     */
    DETAIL_FIELD("detailField"),
    /**
     * Show a {@link com.smartgwt.client.widgets.viewer.DetailViewer} displaying those fields from the record which are not
     * already displayed in the grid.
     */
    DETAILS("details"),
    /**
     * Show a separate {@link com.smartgwt.client.widgets.grid.ListGrid} containing related-records. See {@link
     * com.smartgwt.client.widgets.grid.ListGridRecord#getDetailDS detailDS} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRecordDetailDSProperty recordDetailDSProperty} for  more information.
     */
    RELATED("related"),
    /**
     * Show a {@link com.smartgwt.client.widgets.form.DynamicForm} to edit those fields from the record which not already
     * present in the grid.
     */
    EDITOR("editor"),
    /**
     * Show a {@link com.smartgwt.client.widgets.viewer.DetailViewer} displaying those fields from the record not already
     * displayed in the grid, together with a separate {@link com.smartgwt.client.widgets.grid.ListGrid} containing
     * related-records.
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
