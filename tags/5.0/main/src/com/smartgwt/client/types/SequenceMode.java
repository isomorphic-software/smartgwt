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
 * The possible types of sequence handling Smart GWT Server can apply.  This refers to the technique used to obtain the
 * primary keys of the most recent insert, which the product  uses to enable automatic cache synchronization (updating
 * client-side components bound to a  dataSource to reflect updates to that dataSource).  Only applicable to {@link
 * com.smartgwt.client.data.DataSourceField fields} of {@link com.smartgwt.client.types.FieldType type} "sequence". <P>
 */
public enum SequenceMode implements ValueEnum {
    /**
     * Use the JDBC 3.0 API "getGeneratedKeys()" to get the most recent sequence value. Obviously, this is only an option for
     * JDBC 3.0+ drivers
     */
    JDBCDRIVER("jdbcDriver"),
    /**
     * Use a database-specific native technique to obtain the most recent sequence value. The actual technique used varies
     * widely depending on the vagaries of the underlying database (and sometimes the vagaries of particular releases of a
     * database product)
     */
    NATIVE("native"),
    /**
     * No automatic attempt is made to retrieve the most recent sequence value. You are expected to handle this by providing a 
     * {@link com.smartgwt.client.data.OperationBinding#getCacheSyncOperation cacheSyncOperation} that is  able to return the
     * entire row without needing generated PK values for context. For example, a query that uses <code>MAX(pk)</code> would be
     * capable of this. To give a more complex example, say you have a  sequence value that is retrieved from a legacy system:
     * you could store  that sequence value in the HTTP session and then have your custom  <code>cacheSyncOperation</code>
     * reference that session attribute in  its <code>WHERE</code> clause. Also note that cacheSyncOperations,  like any other
     * {@link com.smartgwt.client.data.OperationBinding DataSource operation},  can be {@link
     * com.smartgwt.client.docs.serverds.OperationBinding#serverObject written in Java} or any  {@link
     * com.smartgwt.client.docs.serverds.OperationBinding#script JSR223-compliant scripting language} - you do not have to use
     * SQL
     */
    NONE("none");
    private String value;

    SequenceMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
