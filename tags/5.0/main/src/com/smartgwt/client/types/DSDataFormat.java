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
 * Indicates the format to be used for HTTP requests and responses when fulfilling DSRequests (eg, when {@link
 * com.smartgwt.client.data.DataSource#fetchData DataSource.fetchData} is called). <P> Note that {@link
 * com.smartgwt.client.rpc.RPCManager#startQueue request queuing} is only available for "iscServer" requests.
 */
public enum DSDataFormat implements ValueEnum {
    /**
     * Make an HTTP request in a format recognized by the ISC server and expect ISC server response format. {@link
     * com.smartgwt.client.docs.ServerDataIntegration Server-side integration} can then be used to connect to any kind of data
     * store or web service.
     */
    ISCSERVER("iscServer"),
    /**
     * Expect XML responses. Request format depends on the setting for {@link
     * com.smartgwt.client.data.OperationBinding#getDataProtocol protocol}. This is the correct setting when consuming RSS
     * feeds, XML web services (whether SOAP, REST, XML-RPC or custom format), and XML flat files directly from the browser.
     * <P> Values for "date", "time" or "datetime" fields in responses should be specified in the applicable <a target=_blank
     * href="http://www.w3.org/TR/xmlschema-2/#dateTime">XML Schema date format</a>. If no timezone is explicitly specified,
     * dates / datetimes received by the client are  assumed to be GMT. Note that "date" type fields represent logical dates
     * and may omit time information entirely, and "time" type fields may omit date information. See {@link
     * com.smartgwt.client.docs.DateFormatAndStorage Date and Time Format and storage} for more information on how date values
     * are serialized in requests sent to the server.  <P> A DSResponse will be derived from the returned XML via the process
     * described under {@link com.smartgwt.client.data.DataSource#transformResponse DataSource.transformResponse}.
     */
    XML("xml"),
    /**
     * Expect response in JSON <a href='http://json.org' onclick="window.open('http://json.org');return false;">(Java Script
     * Object Notation)</a> format, ready to be eval()'d. Response should either be a naked object literal:<br>
     * <code>&nbsp;&nbsp;&nbsp;&nbsp;{ "property":"value1", "property2" : "value2", ... }</code><br> or a string that evals to
     * return a valid response object:<br> <code>&nbsp;&nbsp;&nbsp;&nbsp;var response = { "property":"value1", "property2" :
     * "value2", ... }</code> <br> <code>&nbsp;&nbsp;&nbsp;&nbsp;response;</code><br> <P> A DSResponse will be derived from the
     * returned JSON via the process described under {@link com.smartgwt.client.data.DataSource#transformResponse
     * DataSource.transformResponse}. <P> As with <code>"xml"</code> responses, values for "date" or "datetime" fields should
     * be specified as a String in  <a target=_blank href="http://www.w3.org/TR/xmlschema-2/#dateTime">XML Schema date
     * format</a> and may include a timezone. In the absence of a timezone they will be assumed to be GMT. <P> Request format
     * depends on the setting for {@link com.smartgwt.client.data.OperationBinding#getDataProtocol protocol}.  See also {@link
     * com.smartgwt.client.data.XJSONDataSource}.
     */
    JSON("json"),
    /**
     * Smart GWT will not attempt to parse the response, instead, {@link com.smartgwt.client.data.DataSource#transformResponse
     * DataSource.transformResponse} must be implemented. <code>transformResponse</code> will receive the "data" parameter as a
     * String, and must parse this String into an Array of Objects, which should be set as {@link
     * com.smartgwt.client.data.DSResponse#getData data}. Request format depends on the setting for {@link
     * com.smartgwt.client.data.OperationBinding#getDataProtocol protocol}. <P> Note that, unlike either the "json" or "xml"
     * settings of <code>dataFormat</code>, you are responsible for ensuring that parsed values are the correct type, for
     * example, using the JavaScript built-ins <code>parseInt</code> and <code>parseFloat</code> on integer and decimal values
     * respectively, and using <code>new Date()</code> to construct valid Dates.
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
