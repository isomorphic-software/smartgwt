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
 * Indicates the format to be used for HTTP requests and responses when&#010 fulfilling DSRequests (eg {@link
 * com.smartgwt.client.data.DataSource#fetchData} is called).&#010 <P>&#010 Note that RPCManager's {@link
 * RPCManager#startQueue request queuing} is only available for&#010 "iscServer" requests.
 */
public enum DSDataFormat implements ValueEnum {
    /**
     * Make an HTTP request in a format recognized by the ISC server and expect ISC server&#010 response format. ISC's
     * 'Server-side integration' can then be&#010 used to connect to any kind of data store or web service.
     */
    ISCSERVER("iscServer"),
    /**
     * Expect XML responses.  Request format depends on the setting for&#010 {@link
     * com.smartgwt.client.data.OperationBinding#dataProtocol protocol}. This is the correct setting when&#010 consuming
     * RSS feeds, XML web services (whether SOAP, REST, XML-RPC or custom format),&#010 and XML flat files directly from
     * the browser.&#010 <P>&#010 A DSResponse will be derived from the returned XML via the process described
     * under&#010 {@link com.smartgwt.client.data.DataSource#transformResponse}.
     */
    XML("xml"),
    /**
     * Expect response in JSON <a href='http://json.org' onclick="window.open('http://json.org');return false;">(Java
     * Script Object Notation)</a>&#010 format, ready to be eval()'d. Response should either be a naked object
     * literal:<br>&#010 <code>&nbsp;&nbsp;&nbsp;&nbsp;{status:0, startRow:0, endRow:50, data:[ ..]}</code><br>&#010 or
     * a string that evals to return a valid response object:<br>&#010 <code>&nbsp;&nbsp;&nbsp;&nbsp;var response =
     * {status:0, startRow:0, endRow:50, data:[ ..]};&#010 <br>&nbsp;&nbsp;&nbsp;&nbsp;response;</code><br>&#010 Request
     * format depends on the setting for {@link com.smartgwt.client.data.OperationBinding#dataProtocol protocol}. &#010
     * See also {@link com.smartgwt.client.data.XJSONDataSource}.
     */
    JSON("json"),
    /**
     * SmartClient will not attempt to parse the response, instead,&#010 {@link com.smartgwt.client.data.DataSource#transformResponse}
     * must be implemented.&#010 <code>transformResponse</code> will receive the "data" parameter as a String, and
     * must&#010 parse this String into an Array of Objects, which should be set as&#010 {@link DSResponse.data data}.
     * Request format depends on the setting for&#010 {@link com.smartgwt.client.data.OperationBinding#dataProtocol
     * protocol}.&#010 <P>&#010 Note that, unlike either the "json" or "xml" settings of <code>dataFormat</code>,
     * you&#010 are responsible for ensuring that parsed values are the correct type, for example, using&#010 the
     * JavaScript built-ins <code>parseInt</code> and <code>parseFloat</code> on integer&#010 and decimal values
     * respectively, and using <code>new Date()</code> to construct valid&#010 Dates.
     */
    CUSTOM("custom");
    private String value;

    DSDataFormat(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

