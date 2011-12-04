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
 * The types of custom query that can be handled by Smart GWT's built-in "sql" and  "hibernate"
 * DataSources.  Note, only applies to {@link
 * com.smartgwt.client.data.OperationBinding#getOperationType operationType} "custom".
 */

public enum SQLType implements ValueEnum {

    /**
     * The custom SQL or HQL is read-only
     */
    QUERY("query"),

    /**
     * The custom SQL or HQL updates data
     */
    UPDATE("update");
    private String value;

    SQLType(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return this.value;
    }
}


