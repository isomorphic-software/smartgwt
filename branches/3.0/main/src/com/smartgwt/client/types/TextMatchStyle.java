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
 
package com.smartgwt.client.types;

/**
 * For "fetch" operations, how search criteria should be interpreted for text fields.
 */
public enum TextMatchStyle implements ValueEnum {
    /**
     * test for exact match
     */
    EXACT("exact"),
    /**
     * test for case-insenstive substring match
     */
    SUBSTRING("substring"),
    /**
     * test for the beginning of the value matching the search criteria
     */
    STARTS_WITH("startsWith");

    private String value;

    TextMatchStyle(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
