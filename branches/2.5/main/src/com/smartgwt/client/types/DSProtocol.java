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
 * dataProtocol affects how the data in the DSRequest ({@link com.smartgwt.client.data.DSRequest#setData(String) data}  is&#010 sent
 * to the {@link com.smartgwt.client.data.DataSource#setDataURL(String) dataURL }.  Note that, when using the SmartGWT server,
 * data&#010 is automatically translated from JavaScript to Java according to the rules described&#010
 * {@link com.smartgwt.client.rpc.RPCRequest#setData(String) here}; dataProtocol does not apply.
 */

public enum DSProtocol implements ValueEnum {
    /**
     * Data is added to the dataURL, with each property in the data becoming an HTTP parameter,&#010   eg
     * http://service.com/search?keyword=foo
     */
    GETPARAMS("getParams"),
    /**
     * Data is POST'd to the dataURL, with each property becoming an HTTP parameter, &#010   exactly as an HTML form
     * would submit them if it had one input field per property in the&#010   data.
     */
    POSTPARAMS("postParams"),
    /**
     * Data is serialized as XML via {@link com.smartgwt.client.data.DataSource#xmlSerialize(com.google.gwt.core.client.JavaScriptObject)} and POST'd as the&#010
     * HTTP request body with contentType text/xml
     */
    POSTXML("postXML"),

    /**
     * This setting entirely bypasses the SmartGWT comm system. Instead of the DataSource sending an HTTP request to the server,
     * the developer is expected to override {@link com.smartgwt.client.data.DataSource#transformRequest(com.smartgwt.client.data.DSRequest)}
     * to perform their own custom data manipulation logic,
     * and then call {@link com.smartgwt.client.data.DataSource#processResponse(String, com.smartgwt.client.data.DSResponse)} to handle the results of this action.
     * If the call was successful, status and data should be filled.
     * If the call was unsuccessful, only status should be set, and should contain an error code.
     */
    CLIENTCUSTOM("clientCustom"),
    
    /**
     * Data is serialized as XML via {@link com.smartgwt.client.data.DataSource#xmlSerialize(com.google.gwt.core.client.JavaScriptObject)} , wrapped in a
     * SOAP&#010   envelope, and POST'd as the HTTP request body with contentType "text/xml".  Generally&#010 only used
     * in connection with a {@link com.smartgwt.client.docs.WsdlBinding 'WSDL web service'}.
     */
    SOAP("soap"),
    /**
     * dsRequest.data is assumed to be a String set up by {@link com.smartgwt.client.data.DataSource#transformRequest(com.smartgwt.client.data.DSRequest)} &#010
     * and is POST'd as the HTTP request body.
     */
    POSTMESSAGE("postMessage");
    private String value;

    DSProtocol(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

