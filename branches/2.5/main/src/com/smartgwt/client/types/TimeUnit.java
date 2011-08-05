/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
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
 * An enum of time-units available for use with the {@link RelativeDateItem}
 */
public enum TimeUnit implements ValueEnum {
    /**
     * A millisecond time-unit
     */
    MILLISECOND("millisecond"),
    
    /**
     * A second time-unit
     */
    SECOND("second"),
    
    /**
     * A minute time-unit
     */
    MINUTE("minute"),
    
    /**
     * An hour time-unit
     */
    HOUR("hour"),
    
    /**
     * A day time-unit
     */
    DAY("day"),
    
    /**
     * A week time-unit
     */
    WEEK("week"),
    
    /**
     * A month time-unit
     */
    MONTH("month"),
    
    /**
     * A quarter (3-month) time-unit
     */
    QUARTER("quarter"),
    
    /**
     * A year time-unit
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

