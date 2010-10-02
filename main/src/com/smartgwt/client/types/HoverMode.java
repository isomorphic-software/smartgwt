/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * is published by the Free Software Foundation.  Smart GWT is also
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
 * <p>When {@link com.smartgwt.client.widgets.grid.ListGrid#setCanHover(Boolean) canHover} and  {@link com.smartgwt.client.widgets.grid.ListGrid#showHoverComponents(Boolean) showHoverComponents}
 *  are both true, HoverMode dictates the type of UI to be displayed when a user hovers over a row or cell.
 *<P>
 * There are a number of builtin HoverModes and you can override ListGrid.getCellHoverComponent to create your own hover behaviors.
 */
public enum HoverMode implements ValueEnum {
    /**
     * Show a single field's value in an +link{class:HtmlFlow}. Field to use is listGrid.detailField.
     */
    DETAIL_FIELD("detailField"),
    /**
     * Show a DetailViewer displaying those fields from the record which are not already displayed in the grid.
     */
    DETAILS("details"),

    /**
     * Show a separate ListGrid containing related-records. See ListGridRecord.detailDS and ListGrid.recordDetailDSProperty for more information.
     */
    RELATED("related"),

    /**
     * Show a DetailViewer displaying those fields from the record not already displayed in the grid, together
     * with a separate ListGrid containing related-records.
     */
    DETAIL_RELATED("detailRelated");

    private String value;

    HoverMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
