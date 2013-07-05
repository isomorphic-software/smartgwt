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
 * Mode of fetching records from the server. <P> Generally, "paged" mode should be used unless the maximum number of
 * records is guaranteed to be small.
 */
public enum FetchMode implements ValueEnum {
    /**
     * All records that match the current filter are fetched. Sorting is performed on the client.
     */
    BASIC("basic"),
    /**
     * Only requested ranges of records are fetched, with predictive fetch ahead. Sorting is performed on the server.
     */
    PAGED("paged"),
    /**
     * All records available from the DataSource are fetched. Filtering by search criteria and sorting are both performed on
     * the client.
     */
    LOCAL("local");
    private String value;

    FetchMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
