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
 * When {@link com.smartgwt.client.widgets.grid.ListGrid#getCanExpandRecords canExpandRecords} is true, ExpansionMode
 * dictates the type of UI to be displayed in the expanded portion of the row. <P> There are a number of builtin
 * ExpansionModes and you can override {@link com.smartgwt.client.widgets.grid.ListGrid#getExpansionComponent
 * getExpansionComponent()} to create your own expansion behaviors.
 */
public enum ExpansionMode implements ValueEnum {
    /**
     * Show a single field's value in an {@link com.smartgwt.client.widgets.HTMLFlow}. Field to use is {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDetailField ListGrid.detailField}.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "detailField".
     */
    DETAIL_FIELD("detailField"),
    /**
     * Show a {@link com.smartgwt.client.widgets.viewer.DetailViewer} displaying those fields from the record which are not
     * already displayed in the grid.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "details".
     */
    DETAILS("details"),
    /**
     * Show a separate {@link com.smartgwt.client.widgets.grid.ListGrid} containing related-records. See {@link
     * com.smartgwt.client.widgets.grid.ListGridRecord#getDetailDS ListGridRecord.detailDS} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRecordDetailDSProperty ListGrid.recordDetailDSProperty} for more
     * information.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "related".
     */
    RELATED("related"),
    /**
     * Show a {@link com.smartgwt.client.widgets.form.DynamicForm} to edit those fields from the record which are not already
     * present in the grid. If the record is collapsed with unsaved changes and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getExpansionEditorShowSaveDialog ListGrid.expansionEditorShowSaveDialog} is
     * not set, Edits will be saved automatically, or stored as {@link com.smartgwt.client.docs.Editing editValues} if {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoSaveEdits ListGrid.autoSaveEdits} is false. Otherwise, a confirmation
     * dialog is displayed. Can optionally show a {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowExpansionEditorSaveButton save button} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getExpansionEditorCollapseOnSave auto-collapse} when save is pressed. If a
     * record fails validation on save and the field in question is not visible in the grid, the record is automatically
     * expanded and validated to show the errors.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "editor".
     */
    EDITOR("editor"),
    /**
     * Show a {@link com.smartgwt.client.widgets.viewer.DetailViewer} displaying those fields from the record not already
     * displayed in the grid, together with a separate {@link com.smartgwt.client.widgets.grid.ListGrid} containing
     * related-records.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "detailRelated".
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
