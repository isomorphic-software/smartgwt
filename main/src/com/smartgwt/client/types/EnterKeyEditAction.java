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
 * What to do when a user hits enter while editing a cell
 */
public enum EnterKeyEditAction implements ValueEnum {
    /**
     * end editing (will save edit values if {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoSaveEdits
     * ListGrid.autoSaveEdits} is true).
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "done".
     */
    DONE("done"),
    /**
     * edit the next editable cell in the record
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "nextCell".
     */
    NEXTCELL("nextCell"),
    /**
     * edit the same field in the next editable record
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "nextRow".
     */
    NEXTROW("nextRow"),
    /**
     * edit the first editable cell in next editable record
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "nextRowStart".
     */
    NEXTROWSTART("nextRowStart");
    private String value;

    EnterKeyEditAction(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
