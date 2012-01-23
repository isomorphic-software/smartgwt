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
 * The RequestTransformer provides the equivalent functionality of overriding {@link DataSource#transformRequest(DSRequest)}  when
 * instantiating a DataSource on the client. However when obtaining a DataSource instance from the server using  {@link com.smartgwt.client.data.DataSource#getDataSource}, {@link #transformRequest(DSRequest)} and {@link #transformResponse(DSResponse, DSRequest, Object)}
 * cannot be overridden and so the requestTransformer parameter can be passed to {@link com.smartgwt.client.data.DataSource#getDataSource} instead.
 *
 * @see DataSource#getDataSource
 */
public abstract class RequestTransformer {

    private JavaScriptObject dsJsObj;

    /**
     * See the docs for {@link DataSource#transformRequest(DSRequest)}.
     *
     * @param dsRequest the DSRequest being processed
     * @return data to be sent to the dataURL (JavaScriptObject, String or Record)
     */
    protected abstract Object transformRequest(DSRequest dsRequest);

    /**
     * Return the result of the default transformed response.
     *
     * @param dsRequest the request
     * @deprecated use {@link getDefaultTransformRequest(DSRequest)} instead
     * @return the default transformed response
     */
    public native Object getDefaultTransformResponse(DSRequest dsRequest)/*-{
        var self = this.@com.smartgwt.client.data.RequestTransformer::dsJsObj;
        var data = self.__transformRequest(dsRequest.@com.smartgwt.client.data.DSRequest::getJsObj()());
        if(@com.smartgwt.client.data.DataSource::isRecord(Ljava/lang/Object;)(data)) {
            data = data.@com.smartgwt.client.data.Record::getJsObj()();
        } else if (@com.smartgwt.client.data.DataSource::isRecordArray(Ljava/lang/Object;)(data)) {
            data = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(data);
        }
        return data;
    }-*/;

    /**
     * Return the result of the default transformed request.
     *
     * @param dsRequest the request
     *
     * @return the default transformed request
     */
    public native Object getDefaultTransformRequest(DSRequest dsRequest)/*-{
        var self = this.@com.smartgwt.client.data.RequestTransformer::dsJsObj;
        var data = self.__transformRequest(dsRequest.@com.smartgwt.client.data.DSRequest::getJsObj()());
        if(@com.smartgwt.client.data.DataSource::isRecord(Ljava/lang/Object;)(data)) {
            data = data.@com.smartgwt.client.data.Record::getJsObj()();
        } else if (@com.smartgwt.client.data.DataSource::isRecordArray(Ljava/lang/Object;)(data)) {
            data = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(data);
        }
        return data;
    }-*/;
}
