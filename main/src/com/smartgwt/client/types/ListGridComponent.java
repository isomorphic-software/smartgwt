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
 * Standard component-type displayed within a ListGrid, as contained by {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getGridComponents ListGrid.gridComponents}.
 */
public enum ListGridComponent implements ValueEnum {
    /**
     * The standard filter-component displayed when {@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor
     * ListGrid.showFilterEditor} is true
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "filterEditor".
     */
    FILTER_EDITOR("filterEditor"),
    /**
     * The header-component displayed when {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeader ListGrid.showHeader}
     * is true.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "header".
     */
    HEADER("header"),
    /**
     * The body component for the grid.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "body".
     */
    BODY("body"),
    /**
     * The summary-row component displayed when {@link com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary
     * ListGrid.showGridSummary} is true.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "summaryRow".
     */
    SUMMARY_ROW("summaryRow");
    private String value;

    ListGridComponent(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
