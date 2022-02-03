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
 * Whether the mock data is for a flat grid-like dataset or for a tree.  If "grid" is specified, text shortcuts that would
 * cause a hierarchy to be created (such as starting a line with "[+]") will not have special meaning and be considered to
 * be just a normal data value.
 */
public enum MockDataType implements ValueEnum {
    /**
     * Mock data for a ListGrid
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "grid".
     */
    GRID("grid"),
    /**
     * Mock data for a TreeGrid
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "tree".
     */
    TREE("tree");
    private String value;

    MockDataType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
