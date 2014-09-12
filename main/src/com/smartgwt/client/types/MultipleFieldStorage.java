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
 * Options for how values are stored for a field that is {@link com.smartgwt.client.widgets.grid.ListGridField#getMultiple
 * multiple:true}.  See {@link com.smartgwt.client.docs.serverds.DataSourceField#multipleStorage
 * DataSourceField.multipleStorage}.
 */
public enum MultipleFieldStorage implements ValueEnum {
    /**
     * values are saved as a simple delimeter-separated string. Delimeter can be configured via {@link
     * com.smartgwt.client.docs.serverds.DataSourceField#multipleStorageSeparator DataSourceField.multipleStorageSeparator}. An
     * empty array is stored as "", and null as the database <code>null</code> value.
     */
    SIMPLESTRING("simpleString"),
    /**
     * values are serialized to JSON. Empty array as a distinct value from null (it appears as the text "[]").
     */
    JSON("json"),
    /**
     * no transformation is applied to values; server-side field value remains a Java List when passed to the
     * execute(Fetch|Add|Update|Remove) method of the server-side DataSource class
     */
    NONE("none");
    private String value;

    MultipleFieldStorage(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
