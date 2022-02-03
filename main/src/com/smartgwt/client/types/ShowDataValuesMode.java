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
 * Strategy for determining whether and when to show data-values, on-screen in the chart body or in hovers, or some
 * combination of both.
 */
public enum ShowDataValuesMode implements ValueEnum {
    /**
     * never show data-values at all
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "never".
     */
    NEVER("never"),
    /**
     * show data-values in the chart, when the chartType supports it and when they fit without overlapping (including after 
     * {@link com.smartgwt.client.widgets.chart.FacetChart#getRotateDataValues rotation}), and in hovers otherwise
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "auto".
     */
    AUTO("auto"),
    /**
     * show data-values in the chart body, but only if they all fit - no hovers
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "inChartOnly".
     */
    INCHARTONLY("inChartOnly"),
    /**
     * show data-values in the chart body and, if any don't fit, switch to hovers
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "inChartOrHover".
     */
    INCHARTORHOVER("inChartOrHover"),
    /**
     * show data-values that fit in the chart body and also switch on hovers
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "inChartAndHover".
     */
    INCHARTANDHOVER("inChartAndHover"),
    /**
     * always show data-values in hovers
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "inHoverOnly".
     */
    INHOVERONLY("inHoverOnly");
    private String value;

    ShowDataValuesMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
