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
 */
public enum LoadProjectErrorStatus implements ValueEnum {
    /**
     * server has not responded within configured request timeout
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "timeout".
     */
    TIMEOUT("timeout"),
    /**
     * can't reach server at {@link com.smartgwt.client.tools.Reify#serverURL serverURL}
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "noResponseFromURL".
     */
    NORESPONSEFROMURL("noResponseFromURL"),
    /**
     * no project loader at {@link com.smartgwt.client.tools.Reify#serverURL serverURL}
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "badReifyServerURL".
     */
    BADREIFYSERVERURL("badReifyServerURL"),
    /**
     * invalid {@link com.smartgwt.client.tools.Reify#userName userName} or {@link com.smartgwt.client.tools.Reify#password
     * password}
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "badCredentials".
     */
    BADCREDENTIALS("badCredentials"),
    /**
     * none of the requested projects were found
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "projectNotFound".
     */
    PROJECTNOTFOUND("projectNotFound"),
    SERVLETERROR("servletError");
    private String value;

    LoadProjectErrorStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
