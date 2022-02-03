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
 * Indicates what Smart GWT Server will do with a DataSource request if you call dsRequest.execute() in server code. <P> If
 * you use a Java-based persistence layer not provided by Smart GWT, such as EJB or your own custom object model, you don't
 * need to set <code>dataSource.serverType</code> and should follow the {@link
 * com.smartgwt.client.docs.ServerDataIntegration integration instructions}.
 */
public enum DSServerType implements ValueEnum {
    /**
     * Use Smart GWT's {@link com.smartgwt.client.docs.SqlDataSource built-in SQL connectors} to talk directly to relational
     * databases.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "sql".
     */
    SQL("sql"),
    /**
     * Use Hibernate, either using a real mapped bean or by automatically generating a  Hibernate configuration based on a
     * Smart GWT DataSource file  (<i>dataSourceID</i>.ds.xml). See {@link com.smartgwt.client.docs.HibernateIntegration} for
     * details.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "hibernate".
     */
    HIBERNATE("hibernate"),
    /**
     * Use Smart GWT's built-in JPA 2.0 connector.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "jpa".
     */
    JPA("jpa"),
    /**
     * Use Smart GWT's built-in JPA 1.0 connector.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "jpa1".
     */
    JPA1("jpa1"),
    /**
     * Requests will be delivered to the server and you are expected to write Java code to create a valid response. Throws an
     * error if the server side method dsRequest.execute() is called. This is appropriate if you intend an entirely custom
     * implementation, and you want an error thrown if there is an attempt to call an operation you have not implemented.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "generic".
     */
    GENERIC("generic"),
    /**
     * Requests will be delivered to the server and processed as  {@link com.smartgwt.client.docs.FileSource FileSource
     * operations}, using directories or other DataSources which you configure via {@link
     * com.smartgwt.client.docs.serverds.DataSource#projectFileKey DataSource.projectFileKey} or {@link
     * com.smartgwt.client.docs.serverds.DataSource#projectFileLocations DataSource.projectFileLocations}
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "projectFile".
     */
    PROJECTFILE("projectFile");
    private String value;

    DSServerType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
