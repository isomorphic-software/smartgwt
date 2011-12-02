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
 * {@link com.smartgwt.client.data.OperationBinding#getDataProtocol dataProtocol} affects how the data in the DSRequest
 * ({@link com.smartgwt.client.data.DSRequest#getData data})
 *  is sent to the {@link com.smartgwt.client.data.DataSource#getDataURL dataURL}.  Listed below are the valid values for
 *  {@link com.smartgwt.client.data.OperationBinding#getDataProtocol dataProtocol} and their behavior.
 *  <P>
 *  Note that, when using the Smart GWT server, data is automatically translated from
 *  JavaScript to Java according to the rules described {@link com.smartgwt.client.rpc.RPCRequest#getData here};
 *  dataProtocol does not apply and is ignored.
 *  <P>
 *  If you are integrating with a {@link com.smartgwt.client.data.RestDataSource REST} server that requires the more
 * obscure {@link com.smartgwt.client.rpc.RPCRequest#getHttpMethod httpMethod}s of "PUT", "DELETE" or "HEAD", you can
 * specify these
 * httpMethod settings via {@link com.smartgwt.client.data.OperationBinding#getRequestProperties requestProperties}. 
 * dataProtocol settings
 *  that mention "GET" or "POST" are compatible with these additional HTTP methods as well.
 *  Typical {@link com.smartgwt.client.data.DataSource#getOperationBindings operationBindings} for a REST server that uses
 *  "PUT" and "DELETE" are as follows:
 *  <pre>
 *     operationBindings:[
 *        {operationType:"fetch", dataProtocol:"getParams"},
 *        {operationType:"add", dataProtocol:"postParams"},
 *        {operationType:"remove", dataProtocol:"getParams", requestProperties:{httpMethod:"DELETE"}},
 *        {operationType:"update", dataProtocol:"postParams", requestProperties:{httpMethod:"PUT"}}
 *     ],
 *  </pre>
 */
public enum DSProtocol implements ValueEnum {
    /**
     * Data is added to the dataURL, with each property in the data becoming an HTTP parameter, eg
     * http://service.com/search?keyword=foo
     */
    GETPARAMS("getParams"),
    /**
     * Data is POST'd to the dataURL, with each property becoming an HTTP parameter,  exactly as an HTML form would submit them
     * if it had one input field per property in the data.
     */
    POSTPARAMS("postParams"),
    /**
     * Data is serialized as XML via {@link com.smartgwt.client.data.DataSource#xmlSerialize DataSource.xmlSerialize} and
     * POST'd as the HTTP request body with contentType "text/xml".
     */
    POSTXML("postXML"),
    /**
     * Data is serialized as XML via {@link com.smartgwt.client.data.DataSource#xmlSerialize DataSource.xmlSerialize}, wrapped
     * in a SOAP envelope, and POST'd as the HTTP request body with contentType "text/xml". Generally only used in connection
     * with a {@link com.smartgwt.client.docs.WsdlBinding WSDL web service}.
     */
    SOAP("soap"),
    /**
     * dsRequest.data is assumed to be a String set up by {@link com.smartgwt.client.data.DataSource#transformRequest
     * DataSource.transformRequest} and is POST'd as the HTTP request body.
     */
    POSTMESSAGE("postMessage"),
    /**
     * This setting entirely bypasses the Smart GWT comm system. Instead of the DataSource sending an HTTP request to the
     * server, the developer is expected to implement {@link com.smartgwt.client.data.DataSource#transformRequest
     * DataSource.transformRequest} to perform their own custom data manipulation logic, and then call {@link
     * com.smartgwt.client.data.DataSource#processResponse DataSource.processResponse} to handle the results of this action.
     */
    CLIENTCUSTOM("clientCustom");

    private String value;

    DSProtocol(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
