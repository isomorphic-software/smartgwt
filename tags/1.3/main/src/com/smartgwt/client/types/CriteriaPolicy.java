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
public enum CriteriaPolicy implements ValueEnum {
    /**
     * Cache is dropped whenever criteria changes.
     */
    DROPONCHANGE("dropOnChange"),
    /**
     * Cache is retained as along as the only changes to criteria are lengthening of criteria values for known,
     * String-valued&#010 DataSource fields, or the addition of fields that weren't&#010 present before.
     */
    DROPONSHORTENING("dropOnShortening");
    private String value;

    CriteriaPolicy(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

