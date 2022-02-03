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
 * Known chart types.  These are visual representations of data, not separate data models, although some chart types are
 * only capable of showing a single facet of data. <P> Concrete charting implementations may use any value for
 * <code>chartType</code> but should support the provided <code>chartType</code> values for charts that correspond to the
 * visual presentation described below, to enable easy switching between charting engines.
 */
public enum ChartType implements ValueEnum {
    /**
     * Values represented by area, with stacked values representing multiple facet values. This is equivalent to ChartType
     * "Line" with stacking enabled.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "Area".
     */
    AREA("Area"),
    /**
     * Values represented by vertical columns. Typically supports stacking to represent two facets. May support simultaneous
     * stacking and clustering for 3 facets.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "Column".
     */
    COLUMN("Column"),
    /**
     * Values represented by horizontal bars. Typically supports stacking to represent two facets. May support simultaneous
     * stacking and clustering for 3 facets.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "Bar".
     */
    BAR("Bar"),
    /**
     * Values represented by a lines between data points, or stacked areas for multiple facets.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "Line".
     */
    LINE("Line"),
    /**
     * Values represented on a circular background by a line around the center, or stacked areas for multiple facets
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "Radar".
     */
    RADAR("Radar"),
    /**
     * Circular chart with wedges representing values. Multiple or stacked pies for multiple facets.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "Pie".
     */
    PIE("Pie"),
    /**
     * Like a pie chart with a central hole. Multiple or stacked doughnuts for multiple facets.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "Doughnut".
     */
    DOUGHNUT("Doughnut"),
    /**
     * A chart with two continuous numeric axes and up to one discrete facet.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "Scatter".
     */
    SCATTER("Scatter"),
    /**
     * A chart with two continuous numeric axes and up to one discrete facet that also displays values from a third continuous,
     * numeric domain represented as the sizes of the data point shapes.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "Bubble".
     */
    BUBBLE("Bubble"),
    /**
     * Like a column chart, except instead of showing stacked or clustered values for each position on the horizontal axis, the
     * data values are used together with the associated {@link com.smartgwt.client.widgets.chart.FacetChart#getEndValueMetric
     * FacetChart.endValueMetric} values to show a series of line segments.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "Histogram".
     */
    HISTOGRAM("Histogram");
    private String value;

    ChartType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
