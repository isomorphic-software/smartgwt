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
 * Controls when primary keys are required for "update" and "remove" server operations, when allowMultiUpdate  has not been
 * explicitly configured on either the {@link com.smartgwt.client.docs.serverds.OperationBinding#allowMultiUpdate
 * operationBinding.allowMultiUpdate} or via the server-side API <code>DSRequest.setAllowMultiUpdate()</code>.
 */
public enum MultiUpdatePolicy implements ValueEnum {
    /**
     * having a PK is never required, even for requests from a browser. Note: dangerous setting  that allows end users to wipe
     * out entire tables
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "never".
     */
    NEVER("never"),
    /**
     * having a PK is required for requests that come from the client or are specifically marked  via
     * dsRequest.setClientRequest(true)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "clientRequest".
     */
    CLIENTREQUEST("clientRequest"),
    /**
     * having a PK is required for any request that is associated with an RPCManager, which  includes clientRequests and
     * server-created DSRequests where an RPCManager was explicitly provided
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "rpcManager".
     */
    RPCMANAGER("rpcManager"),
    /**
     * having a PK is always required no matter what
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "always".
     */
    ALWAYS("always");
    private String value;

    MultiUpdatePolicy(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
