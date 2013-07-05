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
 * An enum of time-units available for use with the {@link com.smartgwt.client.widgets.form.fields.RelativeDateItem},
 * {@link com.smartgwt.client.widgets.form.fields.TimeItem} and {@link com.smartgwt.client.widgets.calendar.Calendar}
 * widgets.
 */
public enum TimeUnit implements ValueEnum {
    /**
     * a millisecond time-unit
     */
    MILLISECOND("millisecond"),
    /**
     * a second time-unit
     */
    SECOND("second"),
    /**
     * a minute time-unit
     */
    MINUTE("minute"),
    /**
     * an hour time-unit
     */
    HOUR("hour"),
    /**
     * a day time-unit
     */
    DAY("day"),
    /**
     * a week time-unit
     */
    WEEK("week"),
    /**
     * a month time-unit
     */
    MONTH("month"),
    /**
     * a quarter (3 month) time-unit
     */
    QUARTER("quarter"),
    /**
     * a year time-unit
     */
    YEAR("year");
    private String value;

    TimeUnit(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
