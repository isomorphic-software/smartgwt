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
 * This is used for client-side or server-side summaries <ul><li> Client-side: Function to produce a summary value based on
 * an array of records and a field definition.  An example usage is the {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary listGrid summary row}, where a row is shown at the bottom
 * of the listGrid containing summary information about each column.</li> <li>Server-side: Function used for getting
 * summarized field value using  {@link com.smartgwt.client.docs.ServerSummaries Server Summaries feature} or when  {@link
 * com.smartgwt.client.docs.serverds.DataSourceField#includeFrom Including values from multiple records}</li></ul> <P> For
 * the client-side SummaryFunctions may be specified in one of 2 ways:<ul> <li>as an explicit function or executable {@link
 * com.smartgwt.client.docs.StringMethods StringMethod}, which will be passed <code>records</code> (an array of records)
 * and <code>field</code> (the field definition for which the summary is required).</li> <li>as a standard SummaryFunction
 * identifier</li></ul> For valid ways to configure SummaryFunctions to use server-side feature see the {@link
 * com.smartgwt.client.docs.ServerSummaries Server Summaries overview}.
 */
public enum SummaryFunctionType implements ValueEnum {
    /**
     * <i>Client:</i> iterates through the set of records, picking up and summing all numeric values for the specified field.
     * Returns null to indicate invalid summary value if any non numeric field values are encountered.<br> <i>Server:</i> acts
     * exactly like SQL SUM function.
     */
    SUM("sum"),
    /**
     * <i>Client:</i> iterates through the set of records, picking up all numeric values for the specified field and
     * determining the mean value. Returns null to indicate invalid summary value if any non numeric field values are
     * encountered.<br> <i>Server:</i> acts exactly like SQL AVG function.
     */
    AVG("avg"),
    /**
     * <i>Client:</i> iterates through the set of records, picking up all values for the specified field and finding the
     * maximum value. Handles numeric fields and date type fields only. Returns null to indicate invalid summary value if any
     * non numeric/date field values are encountered.<br> <i>Server:</i> acts exactly like SQL MAX function.
     */
    MAX("max"),
    /**
     * <i>Client:</i> iterates through the set of records, picking up all values for the specified field and finding the
     * minimum value. Handles numeric fields and date type fields only. Returns null to indicate invalid summary value if any
     * non numeric field values are encountered.<br> <i>Server:</i> acts exactly like SQL MIN function.
     */
    MIN("min"),
    /**
     * <i>Client:</i> iterates through the set of records, picking up all numeric values for the specified field and
     * multiplying them together. Returns null to indicate invalid summary value if any non numeric field values are
     * encountered.<br> <i>Server:</i> <b>not supported</b>.
     */
    MULTIPLIER("multiplier"),
    /**
     * <i>Client:</i> returns a numeric count of the total number of records passed in.<br> <i>Server:</i> acts exactly like
     * SQL COUNT function.
     */
    COUNT("count"),
    /**
     * <i>Client:</i> returns <code>field.summaryValueTitle</code> if specified, otherwise <code>field.title</code><br>
     * <i>Server:</i> <b>not supported</b>.
     */
    TITLE("title"),
    /**
     * <i>Client:</i> Currently the same as the <b>min</b> function.<br> <i>Server:</i> implemented as SQL MIN function.
     */
    FIRST("first"),
    /**
     * <i>Client:</i> iterates through the set of records, producing a string with each value concatenated to the end.<br>
     * <i>Server:</i> implemented as SQL CONCAT function. Supported only by SQLDataSource with Oracle DB driver.
     */
    CONCAT("concat");
    private String value;

    SummaryFunctionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
