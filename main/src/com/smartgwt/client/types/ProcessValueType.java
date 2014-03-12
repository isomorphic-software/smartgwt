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
 */
public enum ProcessValueType implements ValueEnum {
    /**
     * values that are not already strings are converted via toString()
     */
    STRING("string"),
    /**
     * the strings "true" and "false" become boolean true and false. All other Strings non-empty String values are true, all
     * numbers are true except 0, and all other non-null values are true
     */
    BOOLEAN("boolean"),
    /**
     * values are converted via toString() and parsing as a decimal number. Invalid values trigger a transition to the {@link
     * com.smartgwt.client.util.workflow.StateTask#getFailureElement failureElement}
     */
    DECIMAL("decimal"),
    /**
     * values are converted via toString(), parsing as a number, and rounding to nearest integer. Invalid values trigger a
     * transition to the {@link com.smartgwt.client.util.workflow.StateTask#getFailureElement failureElement}
     */
    INTEGER("integer"),
    /**
     * any input which is not already a Record or Map becomes null
     */
    RECORD("record"),
    /**
     * generic array type - will convert value to an array of the same type as the existing value
     */
    ARRAY("array");
    private String value;

    ProcessValueType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
