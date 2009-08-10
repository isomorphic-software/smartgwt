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
 * SmartClient supports multiple RPC transports for maximum compatibility and feature richness.&#010 All of transports
 * use HTTP as the underlying protocol, but use different mechanisms for&#010 sending the HTTP request and processing
 * the response.  The transport is typically&#010 auto-selected for by based on the feature being used and the current
 * browser settings.  For&#010 advanced use cases, {@link com.smartgwt.client.rpc.RPCRequest#setTransport(RPCTransport) transport} and
 * ${isc.DocUtils.linkForRef('classAttr:RPCManager.defaultTransport')} are&#010 exposed as override points.&#010 <p>
 */

public enum RPCTransport implements ValueEnum {
    /**
     * Uses the XMLHttpRequest object to make the request to the server. Note that in some browsers with certain
     * configurations, this transport may not be&#010 available.  See {@link com.smartgwt.client.docs.PlatformDependencies}
     * for more information.  This transport is&#010 not useful with file uploads.  Cannot be used to target
     * cross-domain URLs directly.
     */
    XMLHTTPREQUEST("xmlHttpRequest"),
    /**
     * Write a SCRIPT tag into the DOM with a SRC attribute that targets an arbitrary URL.  This transport is the only
     * one that allows direct cross-domain URL&#010 access.  &#010 <P>&#010 For ${isc.DocUtils.linkForRef('attr:RPCRequest.callback')}
     * to work, the server being contacted must support the ability&#010 to generate JavaScript code in the response
     * that will call a JavaScript function generated&#010 by SmartClient.  SmartClient passes the name of the function
     * to call via a URL parameter,&#010 which can be controlled with {@link com.smartgwt.client.rpc.RPCRequest#setCallbackParam(String) callbackParam}.
     */
    SCRIPTINCLUDE("scriptInclude"),
    /**
     * Available with SmartClient Server only.  An HTML form is dynamically assembled that targets a hidden IFRAME.
     * This mechanism is supported on all&#010 browsers and cannot be disabled by end users.  &#010 <P>&#010 If using
     * the SmartClient Server and using &#010 {@link com.smartgwt.client.docs.ServerDataIntegration 'Server-side dat integration')},
     * the "hiddenFrame" transport&#010 is automatically used for all RPCManager and DataSource requests
     * if the "xmlHttpRequest"&#010 transport is not available.&#010 <P>&#010 Cannot be used to target cross-domain URLs
     * directly.
     */
    HIDDENFRAME("hiddenFrame");
    private String value;

    RPCTransport(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

