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
 * Some interfaces, for example the {@link com.smartgwt.client.widgets.FieldPicker FieldPicker} and  {@link
 * com.smartgwt.client.widgets.grid.HiliteEditor HiliteEditor} widgets, can use data from an associated  DataBoundComponent
 * to express live sample values at runtime.
 */
public enum DefaultSampleRecord implements ValueEnum {
    /**
     * Uses the first record in the DataBoundComponent as sample data
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "first".
     */
    FIRST("first"),
    /**
     * Uses the first open leaf-node in the DataBoundComponent as sample data
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "firstOpenLeaf".
     */
    FIRSTOPENLEAF("firstOpenLeaf");
    private String value;

    DefaultSampleRecord(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
