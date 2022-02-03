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
 * Strategies for calculating the FiscalYear within a {@link com.smartgwt.client.widgets.FiscalCalendar} from the specified
 * {@link com.smartgwt.client.widgets.FiscalCalendar#getDefaultDate FiscalCalendar.defaultDate} and {@link
 * com.smartgwt.client.widgets.FiscalCalendar#getDefaultMonth FiscalCalendar.defaultMonth} If the specified fiscal year
 * date starts in one calendar year and ends in the next.
 */
public enum FiscalYearMode implements ValueEnum {
    /**
     * The fiscalYear value for the date range will match the calendar year in which the period ends. For example if the
     * defaultDate and defaultMonth were set to represent April 1st, the fiscal year starting on April 1st 2020 would end on
     * April 1st 2021. Setting the fiscalYearMode to <code>end</code> would mean the fiscalYear value for this block would be
     * 2021.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "end".
     */
    END("end"),
    /**
     * The fiscalYear value for the date range will match the calendar year in which the period starts. For example if the
     * defaultDate and defaultMonth were set to represent April 1st, the fiscal year starting on April 1st 2020 would end on
     * April 1st 2021. Setting the fiscalYearMode to <code>start</code> would mean the fiscalYear value for this block would be
     * 2020.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "start".
     */
    START("start");
    private String value;

    FiscalYearMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
