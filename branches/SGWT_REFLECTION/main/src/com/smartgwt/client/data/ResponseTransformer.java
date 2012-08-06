/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * is published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.data;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The ResponseTransformer provides the equivalent functionality of overriding {@link DataSource#transformResponse(DSResponse, DSRequest, Object)} }  when
 * instantiating a DataSource on the client. However when obtaining a DataSource instance from the server using {@link com.smartgwt.client.data.DataSource#getDataSource},
 * {@link #transformResponse(DSResponse, DSRequest, Object)} cannot be overridden and so the responseTransformer parameter can be passed to
 * {@link com.smartgwt.client.data.DataSource#getDataSource} instead.
 *
 * @see DataSource#getDataSource
 */

public abstract class ResponseTransformer {
    private JavaScriptObject dsJsObj;

    /**
     * See the docs for {@link DataSource#transformResponse(DSResponse, DSRequest, Object)}
     *
     * @param response the response
     * @param request the request
     * @param data the raw data parameter. The type of this object depends on the specified dataFormat.
     *  if the dataFormat is custom, this will be a String. Otherwise this will be a JavaScript object.
     *  If the dataFormat is "json", the JavaScriptObject will be the raw JSON object(s) returned by the
     *  web service. If dataFormat is XML the JavaScriptObject will be the raw XML document object.
     *  Note that the {@link com.smartgwt.client.util.JSOHelper} and
     *  {@link com.smartgwt.client.data.XMLTools} utility classes can be used to work with these raw objects.
     */
    protected abstract void transformResponse(DSResponse response, DSRequest request, Object data);

    public native void defaultTransformResponse(DSResponse response, DSRequest request, Object data)/*-{
        var self = this.@com.smartgwt.client.data.ResponseTransformer::dsJsObj;
        self.__transformResponse(response.@com.smartgwt.client.data.DSResponse::getJsObj()(), request.@com.smartgwt.client.data.DSRequest::getJsObj()(), data);
    }-*/;

}
