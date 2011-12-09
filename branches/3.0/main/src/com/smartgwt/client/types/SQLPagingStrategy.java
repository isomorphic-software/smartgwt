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
 * The technique Smart GWT Server's SQL DataSource should use to select a "page" of data  from a
 * table.
 */

public enum SQLPagingStrategy implements ValueEnum {

    /**
     * Specify the paging directly in the SQL query we generate.  The way this is done varies 
     * considerably from database to database: with some it is a straightforward built-in  facility
     * while others require arcane tricks.  This is the most efficient method.
     */
    SQLLIMIT("sqlLimit"),

    /**
     * Implement the paging behavior by use of the <code>absolute</code> method of the JDBC
     * <code>ResultSet</code>.
     */
    JDBCSCROLL("jdbcSroll"),

    /**
     * Implement the paging behavior by fetching the entire resultset from the database and dropping
     * any unnecessary rows on the server before returning the data to the client.
     */
    DROPONSERVER("dropOnServer"),

    /**
     * No paging behavior: we always return the entire resultset to the client.
     */
    NONE("none");
    private String value;

    SQLPagingStrategy(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return this.value;
    }
}


