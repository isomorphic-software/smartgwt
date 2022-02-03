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
 * The technique Smart GWT Server's SQL DataSource should use to select a "page" of data  from a table.
 */
public enum SQLPagingStrategy implements ValueEnum {
    /**
     * Specify the paging directly in the SQL query we generate. The way this is done varies  considerably from database to
     * database: with some it is a straightforward built-in  facility while others require arcane tricks or simply don't
     * support the idea. This is  the most efficient method, where available. Note that this strategy is not supported  for
     * operations that make use of a {@link com.smartgwt.client.data.OperationBinding#getCustomSQL customSQL} clause,  because
     * it depends upon being able to determine the size of the whole dataset without actually retrieving the whole dataset.
     * Ordinary operations do this by means of an  automatically-generated "row count query", but we cannot generate such a
     * query for a  <code>customSQL</code> operation.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "sqlLimit".
     */
    SQLLIMIT("sqlLimit"),
    /**
     * Implement the paging behavior by use of the <code>absolute()</code> method of the JDBC <code>ResultSet</code>.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "jdbcScroll".
     */
    JDBCSCROLL("jdbcScroll"),
    /**
     * Implement the paging behavior by fetching the entire resultset from the database and dropping any unnecessary rows on
     * the server before returning the data to the client. This approach is extremely inefficient, but also extremely
     * straightforward; it is  intended as a fallback option, for situations where the more sophisticated approaches cause
     * problems (a JDBC driver that throws vague exceptions when <code>absolute()</code> is called, for example)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "dropAtServer".
     */
    DROPATSERVER("dropAtServer"),
    /**
     * No paging behavior: we always return the entire resultset to the client.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "none".
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
