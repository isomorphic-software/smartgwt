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
 
/**
 * Method to use for displaying the exported data.
 */
public enum ExportDisplay implements ValueEnum {
    /**
     * Show the Save As dialog and download the file
     */
    DOWNLOAD("download"),
    /**
     * Show the data in a new browser window
     */
    WINDOW("window"),
    /**
     * Return the data for further programmatic processing in the browser
     */
    RETURN("return");
    private String value;

    ExportDisplay(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
