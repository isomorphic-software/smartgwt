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
 * Operators that can evaluate a set of criteria and produce a combined result.
 */
public enum LogicalOperator implements ValueEnum {
    /**
     * true if all criteria are true
     */
    AND("and"),
    /**
     * true if any criteria are true
     */
    OR("or"),
    /**
     * true if all criteria are false
     */
    NOT("not");
    private String value;

    LogicalOperator(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
        
