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
 * Specifies the direction of facet indenting for a {@link com.smartgwt.client.widgets.cube.Facet#getIsTree hierarchical}
 * facet.
 */
public enum FacetIndentDirection implements ValueEnum {
    /**
     * means the top of the hierarchy renders highest (column facet) or leftmost (row facet). For example, the text for the top
     * of a column facet hierarchy will be flush to the top of the header with the hierarchy expanded.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "descending".
     */
    DESCENDING("descending"),
    /**
     * means that the bottom of the hierarchy renders highest (column facet) or leftmost (row facet).
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "ascending".
     */
    ASCENDING("ascending");
    private String value;

    FacetIndentDirection(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
