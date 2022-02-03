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
 * When {@link com.smartgwt.client.widgets.grid.ListGrid#getAllowRowSpanning ListGrid.allowRowSpanning} is enabled, certain
 * cells may span multiple rows. In this case, the cell displays the value from the record in the first row. If the grid is
 * {@link com.smartgwt.client.widgets.grid.ListGrid#getCanEdit editable} (and the {@link
 * com.smartgwt.client.widgets.grid.ListGridField#getCanEdit field is also editable}), these settings allow the user to
 * specify what happens to the data when the user edits this cell. <P> Note that in this scenario, a user may begin an edit
 * on the row-spanning cell directly (via double-click for example), or on a cell in another column in any of the rows
 * spanned by the cell. The appropriate behavior with respect to user-experience and how the data is manipulated will
 * depend on the application in question. Developers may of course entirely disable editing for the field via {@link
 * com.smartgwt.client.widgets.grid.ListGridField#getCanEdit ListGridField.canEdit} or {@link
 * com.smartgwt.client.widgets.grid.ListGrid#canEditCell ListGrid.canEditCell()}. <P> See also: {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getUseRowSpanStyling ListGrid.useRowSpanStyling}
 */
public enum RowSpanEditMode implements ValueEnum {
    /**
     * This setting assumes that only the field-value for the first record spanned by this cell is significant. In this case
     * the editor will only show for this cell if the user is editing the first spanned record. If the user initialized the
     * edit on another spanned row, the editor will not show for this field.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "first".
     */
    FIRST("first"),
    /**
     * This setting assumes that each row's values are logically separate, so if a cell spans multiple rows, and a user
     * initializes an edit on some cell in the second spanned row, the spanning cell will show an editor containing the value
     * for the second spanned row. This may differ from the value displayed when not in edit mode (which is derived from the
     * first spanned row by default). This setting may be useful for developers who which to implement their own logic on how
     * to handle spanning cell display values and/or edit values (for example by using custom {@link
     * com.smartgwt.client.widgets.grid.ListGridField#setCellFormatter formatting} and applying custom logic to handle editing
     * on {@link com.smartgwt.client.widgets.grid.ListGridField#addEditorEnterHandler ListGridField.editorEnter()} and {@link
     * com.smartgwt.client.widgets.grid.ListGridField#addEditorExitHandler ListGridField.editorExit()}).
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "each".
     */
    EACH("each");
    private String value;

    RowSpanEditMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
