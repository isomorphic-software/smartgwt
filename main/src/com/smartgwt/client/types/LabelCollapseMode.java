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
 * Strategy to apply when there is too little room for labels to be shown for all data points with comfortable padding
 * ({@link com.smartgwt.client.widgets.chart.FacetChart#getMinLabelGap minLabelGap}).
 */
public enum LabelCollapseMode implements ValueEnum {
    /**
     * Show all labels regardless, even though they will overlap
     */
    NONE("none"),
    /**
     * Show significant time values such as the first day of the month or week. Data values in Records must be true Date
     * objects, not Strings.
     */
    TIME("time"),
    /**
     * Pick round numbers in the range and show labels for just those numbers. Best for continuous datasets that are not
     * time-based
     */
    NUMERIC("numeric"),
    /**
     * Pick periodic values from the dataset and show labels for those. Best when the there are no particular points that would
     * clearly be the best to label
     */
    SAMPLE("sample");
    private String value;

    LabelCollapseMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
