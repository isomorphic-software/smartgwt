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
 * One of the supported formats for data-export.  If you are doing a  {@link
 * com.smartgwt.client.widgets.grid.ListGrid#exportClientData client export} to one of the native spreadsheet formats (xls
 * or ooxml), we also export {@link com.smartgwt.client.data.Hilite hilite-based} coloring.  So, if Hilites are causing a
 * particular cell to be rendered as green text on a blue background,  the corresponding cell in the exported spreadsheet
 * document will also be colored that way.
 */
public enum ExportFormat implements ValueEnum {
    /**
     * Export data as XML records
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "xml".
     */
    XML("xml"),
    /**
     * Export data as JSON objects
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "json".
     */
    JSON("json"),
    /**
     * Export data in comma-separated format
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "csv".
     */
    CSV("csv"),
    /**
     * Export data in native Microsoft Excel 97 format
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "xls".
     */
    XLS("xls"),
    /**
     * Export data in native Microsoft Excel 2007 format (also called XLSX)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "ooxml".
     */
    OOXML("ooxml"),
    /**
     * Custom server-side logic will do the export
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "custom".
     */
    CUSTOM("custom");
    private String value;

    ExportFormat(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
