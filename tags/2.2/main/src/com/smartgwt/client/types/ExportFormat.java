/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
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
 * One of the supported formats for data-export.
 */
public enum ExportFormat implements ValueEnum {
    /**
     * Export data as XML records
     */
    XML("xml"),
    
    /**
     * Export data as JSON objects
     */
    JSON("json"),

    /**
     * Export data in comma-seperated format
     */
    CSV("csv"),

    /**
     * Export data in native Microsoft Excel 97 format
     */
    XLS("xls"),

    /**
     * Export data in native Microsoft Excel 2007 format (also called XLSX)
     */
    OOXML("ooxml");

    private String value;

    ExportFormat(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
