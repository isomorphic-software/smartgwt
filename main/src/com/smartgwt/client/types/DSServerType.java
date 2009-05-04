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
 * Indicates what the ISC server will do with a DataSource request if you call&#010 dsRequest.execute() in server
 * code.&#010 <P>&#010 If you use a Java-based persistence layer not provided by SmartClient, such as&#010 Hibernate,
 * EJB or your own custom object model, you don't need to set&#010 <code>dataSource.serverType</code> and should follow
 * the&#010 {@link com.smartgwt.client.docs.ServerDataIntegration 'integration instructions'}.&#010 <P>&#010 If you
 * want to use the SmartGWT SQL engine for persistence, set&#010 <code>dataSource.serverType</code> to "sql", and see
 * the instructions on&#010 {@link com.smartgwt.client.docs.SqlDataSource}.
 */

public enum DSServerType implements ValueEnum {
    /**
     * Saves via Hibernate, by automatically generating a Hibernate configuration based on a&#010 SmartClient
     * DataSource file (<i>dataSourceID</i>.ds.xml).  See&#010 {@link com.smartgwt.client.docs.HibernateIntegration}
     * for details.
     */
    HIBERNATE("hibernate"),
    /**
     * Uses SmartGWT's {@link com.smartgwt.client.docs.SqlDataSource 'built-in SQL connectors'} to talk
     * to&#010 relational databases.  You can use this if your DataSource connects to a relational&#010 database
     * table.
     */
    SQL("sql"),
    /**
     * Throws an error if dsRequest.execute() is called.  This is appropriate if you intend an&#010 entirely
     * custom implementation, and you want an error thrown if there is an attempt to&#010 call an operation you
     * have not implemented.
     */
    GENERIC("generic");
    private String value;

    DSServerType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

