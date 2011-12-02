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
 * Indicates what the ISC server will do with a DataSource request if you call dsRequest.execute() in server code. <P> If
 * you use a Java-based persistence layer not provided by Smart GWT, such as Hibernate, EJB or your own custom object
 * model, you don't need to set <code>dataSource.serverType</code> and should follow the {@link
 * com.smartgwt.client.docs.ServerDataIntegration integration instructions}. <P> If you want to use the Smart GWT SQL
 * engine for persistence, set <code>dataSource.serverType</code> to "sql", and see the instructions on {@link
 * com.smartgwt.client.docs.SqlDataSource SQL DataSources}.
 */
public enum DSServerType implements ValueEnum {
    /**
     * Saves via Hibernate, by automatically generating a Hibernate configuration based on a Smart GWT DataSource file
     * (<i>dataSourceID</i>.ds.xml). See {@link com.smartgwt.client.docs.HibernateIntegration} for details.
     */
    HIBERNATE("hibernate"),
    /**
     * Uses Smart GWT's {@link com.smartgwt.client.docs.SqlDataSource built-in SQL connectors} to talk to relational databases.
     * You can use this if your DataSource connects to a relational database table.
     */
    SQL("sql"),
    /**
     * Requests will be delivered to the server and you are expected to write Java code to create a valid response. Throws an
     * error if the server side method dsRequest.execute() is called. This is appropriate if you intend an entirely custom
     * implementation, and you want an error thrown if there is an attempt to call an operation you have not implemented.
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
