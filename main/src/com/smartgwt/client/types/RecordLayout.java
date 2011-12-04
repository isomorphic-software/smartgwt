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
 * Controls the style of TableView record display
 */
public enum RecordLayout implements ValueEnum {
    /**
     * Show  title field only
     */
    TITLE_ONLY("titleOnly"),
    /**
     * Show  title and  description fields only
     */
    TITLE_DESCRIPTION("titleAndDescription"),
    /**
     * Show  title,  description and  info fields only
     */
    SUMMARY_INFO("summaryInfo"),
    /**
     * Show  title,  description and  data fields only
     */
    SUMMARY_DATA("summaryData"),
    /**
     * Show  title,  description,  info and  data fields similar to the iPhoneOS Mail application
     */
    SUMMARY_FULL("summaryFull");

    private String value;

    RecordLayout(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
