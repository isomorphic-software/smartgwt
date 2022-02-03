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
 * Mode of validation used for running validation on partially entered data.
 */
public enum ValidationMode implements ValueEnum {
    /**
     * Assume provided data is complete and run all validation rules
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "full".
     */
    FULL("full"),
    /**
     * Validate only the data values that are present ignoring the absence of required fields, validators that refer to fields
     * that are not present, and any conditional validators dependent on fields that are not present.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "partial".
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
