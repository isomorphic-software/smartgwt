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
 * One of the four basic operations that can be performed on DataSource data: "fetch", "add", "update", "remove". 
 * Elsewhere called CRUD operations, where CRUD stands for "create", "retrieve", "update", "delete", which correspond to
 * "add", "fetch", "update" and "remove" in Smart GWT terminology.  See {@link
 * com.smartgwt.client.docs.DataSourceOperations} for a full description. <p> There are also additional, non-CRUD
 * operations explained below. </ul>
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
     * perform some arbitrary custom logic that is not a CRUD operation. Format of the inputs and outputs is unconstrained, and
     * the operation will be ignored for cache sync purposes by {@link com.smartgwt.client.data.ResultSet}s. See  {@link
     * com.smartgwt.client.data.DataSource#performCustomOperation DataSource.performCustomOperation}.
     */
    CUSTOM("custom"),
    /**
     * Run server-side validation for "add" or "update" without actually adding or updating anything. See {@link
     * com.smartgwt.client.data.DataSource#validateData DataSource.validateData}.
     */
    VALIDATE("validate"),
    /**
     * Retrieve a file stored in a binary field in a DataSource record, and allow the browser to choose whether to view it
     * directly or prompt the user to save. See {@link com.smartgwt.client.docs.BinaryFields}.
     */
    VIEWFILE("viewFile"),
    /**
     * Like "viewFile", but the HTTP header Content-Disposition is used to suggest that the browser show a save dialog. See
     * {@link com.smartgwt.client.docs.BinaryFields}.
     */
    DOWNLOADFILE("downloadFile"),
    /**
     * Upload formatted client data and export it to Excel, XML and other formats. Used automatically by  {@link
     * com.smartgwt.client.data.DataSource#exportClientData exportClientData()}  and cannot be used directly. Usable only with
     * the Smart GWT server framework.
     */
    CLIENTEXPORT("clientExport");
    private String value;

    DSOperationType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
