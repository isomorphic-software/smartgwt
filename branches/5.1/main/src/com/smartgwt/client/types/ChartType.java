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
 * Known chart types.  These are visual representations of data, not separate data models, although some chart types are
 * only capable of showing a single facet of data. <P> Concrete charting implementations may use any value for
 * <code>chartType</code> but should support the provided <code>chartType</code> values for charts that correspond to the
 * visual presentation described below, to enable easy switching between charting engines.
 */
public enum ChartType implements ValueEnum {
    /**
     * Values represented by area, with stacked values representing multiple facet values. This is equivalent to ChartType
     * "Line" with stacking enabled.
     */
    AREA("Area"),
    /**
     * Values represented by vertical columns. Typically supports stacking to represent two facets. May support simultaneous
     * stacking and clustering for 3 facets.
     */
    COLUMN("Column"),
    /**
     * Values represented by horizontal bars. Typically supports stacking to represent two facets. May support simultaneous
     * stacking and clustering for 3 facets.
     */
    BAR("Bar"),
    /**
     * Values represented by a lines between data points, or stacked areas for multiple facets.
     */
    LINE("Line"),
    /**
     * Values represented on a circular background by a line around the center, or stacked areas for multiple facets
     */
    RADAR("Radar"),
    /**
     * Circular chart with wedges representing values. Single facet only
     */
    PIE("Pie"),
    /**
     * Like a pie chart with a central hole. Single facet only
     */
    DOUGHNUT("Doughnut");

    private String value;

    ChartType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
