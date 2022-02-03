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
 * What should drive the automatic expansion of the chart?
 */
public enum AutoScrollDataApproach implements ValueEnum {
    /**
     * Expand the chart to make room for data label facet value. Unused in Bar-type charts
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "labels".
     */
    LABELS("labels"),
    /**
     * Expand the chart to accommodate {@link com.smartgwt.client.widgets.chart.FacetChart#getBarMargin FacetChart.barMargin},
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getMinBarThickness FacetChart.minBarThickness}, and {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getMinClusterSize FacetChart.getMinClusterSize()}.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "clusters".
     */
    CLUSTERS("clusters"),
    /**
     * Expand the chart to make room for both labels and clusters (whichever requires more space).
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "both".
     */
    BOTH("both");
    private String value;

    AutoScrollDataApproach(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
