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
 * Boundary type for limiting where contiguous selection (via shift+click or drag selection) can be applied across {@link
 * com.smartgwt.client.widgets.cube.Facet#getSelectionBoundary facets} or  {@link
 * com.smartgwt.client.widgets.cube.FacetValue#getSelectionBoundary facetValues}.
 */
public enum SelectionBoundary implements ValueEnum {
    /**
     * selection boundary applies to the bottom / right of the cells
     */
    AFTER("after"),
    /**
     * selection boundary applies to the top / left of the cells
     */
    BEFORE("before"),
    /**
     * selection boundary applies to both edges.
     */
    BOTH("both");
    private String value;

    SelectionBoundary(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
