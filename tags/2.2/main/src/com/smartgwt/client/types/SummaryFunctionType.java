/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.types;

/**
 * Function to produce a summary value based on an array of records and a field definition. An example usage is the
 * {@link com.smartgwt.client.widgets.grid.ListGrid#setShowGridSummary 'summary row'}, where a row is shown at the
 * bottom of the listGrid containing summary information about each column. 
 * <p>
 * SummaryFunctions may be specified in one of 2 ways:
 * <ul>
 *  <li>as an explicit function that takes 3 parameters:<br>
 *      - <code>records</code> an array of records<br>
 *      - <code>field</code> the field definition for which the summary is required
 *  </li>
 *  <li>As an predefined {@link SummaryFunctionType} type.
 * </ul>
 *
 *
 */
public enum SummaryFunctionType implements ValueEnum {
    /**
     * Iterates through the set of records, picking up and summing all numeric values for the specified field. Returns
     * null to indicate invalid summary value if any non numeric field values are encountered.
     */
    SUM("sum"),
    /**
     * Iterates through the set of records, picking up all numeric values for the specified field and determining the mean
     * value. Returns null to indicate invalid summary value if any non numeric field values are encountered.
     */
    AVG("avg"),
    /**
     * Iterates through the set of records, picking up all values for the specified field and finding the maximum value.
     * Handles numeric fields and date type fields only. Returns null to indicate invalid summary value if any non
     * numeric/date field values are encountered.
     */
    MAX("max"),
    /**
     * Iterates through the set of records, picking up all values for the specified field and finding the minimum value.
     * Handles numeric fields and date type fields only. Returns null to indicate invalid summary value if any non numeric
     * field values are encountered.
     */
    MIN("min"),
    /**
     * Iterates through the set of records, picking up all numeric values for the specified field and multiplying them together.
     * Returns null to indicate invalid summary value if any non numeric field values are encountered.
     */
    MULTIPLIER("multiplier"),
    /**
     * 	Returns a numeric count of the total number of records passed in.
     */
    COUNT("count");

    private String value;

    SummaryFunctionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
