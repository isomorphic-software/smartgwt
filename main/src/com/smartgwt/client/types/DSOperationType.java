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
 * One of the four basic operations that can be performed on DataSource data: "fetch",&#010 "add", "update", "remove".
 * Elsewhere called CRUD operations, where CRUD stands for&#010 "create", "retrieve", "update", "delete", which
 * correspond to "add", "fetch", "update" and&#010 "remove" in SmartClient terminology.  See dataSourceOperations for a
 * full&#010 description.
 */

public enum DSOperationType implements ValueEnum {
    /**
     * Fetch one or more records that match a set of search criteria.
     */
    FETCH("fetch"),
    /**
     * Store new records
     */
    ADD("add"),
    /**
     * Update an existing record
     */
    UPDATE("update"),
    /**
     * Remove (delete) an existing record
     */
    REMOVE("remove");
    
    /**
     * Run server-side validation for add or update without actually performing the operation
     */
    VALIDATE("validate"),

    /**
     * Perform some arbitrary custom logic
     */
    CUSTOM("custom");
    
    private String value;

    DSOperationType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

