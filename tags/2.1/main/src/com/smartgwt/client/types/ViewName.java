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
 * The names of the Calendar views.
 */
public enum ViewName implements ValueEnum {
    /**
     * Day View
     */
    DAY("day"),

    /**
     * Week View
     */
    WEEK("week"),

    /**
     * Month View
     */
    MONTH("month");

    private String value;

    ViewName(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
