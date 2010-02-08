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
 */
public enum ValidationMode implements ValueEnum {
    /**
     * Assume provided data is complete and run all validation rules.
     */
    FULL("full"),
    /**
     * Validate only the data values that are present ignoring the absence of required fields, validators that refer to fields that are not present
     * and any conditional validators dependent on fields that are not present.
     */
    PARTIAL("partial");
    
    private String value;

    ValidationMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

