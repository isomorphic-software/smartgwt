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
 * When relative dates are specified in a date range, typically in a RelativeDateItem or DateRangeItem, 
 * in order to make the range inclusive or exclusive, it is useful to be able to specify whether we're 
 * referring to the start or end of the date in question.
 */
public enum RelativeDateRangePosition implements ValueEnum {
    /**
     * Indicates this relative date should be treated as the start of the specified logical date.
     */
    START("start"),
    /**
     * Indicates this relative date should be treated as the end of the specified logical date.
     */
    END("end");
    
    private String value;

    RelativeDateRangePosition(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

