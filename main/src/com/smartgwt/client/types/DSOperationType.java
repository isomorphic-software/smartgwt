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
 * One of the four basic operations that can be performed on DataSource data: "fetch", "add", "update", "remove". 
 * Elsewhere called CRUD operations, where CRUD stands for "create", "retrieve", "update", "delete", which correspond to
 * "add", "fetch", "update" and "remove" in Smart GWT terminology.  See {@link
 * com.smartgwt.client.docs.DataSourceOperations} for a full description. <p> There is also a fifth operation, "custom". 
 * This is any operation that is not one of the  four CRUD operations.  You can use operations of this type in
 * circumstances where you  might otherwise have used a plain RPC.
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
    REMOVE("remove"),
    /**
     * Run server-side validation for "add" or "update" without actually performing the operation
     */
    VALIDATE("validate"),
    /**
     * Perform some arbitrary custom logic that is not a CRUD operation
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
