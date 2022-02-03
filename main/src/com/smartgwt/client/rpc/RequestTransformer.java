/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2019 and beyond, Isomorphic Software, Inc.
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

package com.smartgwt.client.rpc;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The RequestTransformer provides the equivalent functionality of overriding
 * {@link RPCManager#transformRequest(RPCRequest)}.
 */
public abstract class RequestTransformer {

    /**
     * Overrides {@link RPCManager#transformRequest(RPCRequest)}.
     *
     * @param rpcRequest the RPCRequest being processed
     * @return data to be sent to the actionURL (JavaScriptObject, String or Record)
     */
    protected abstract Object transformRequest(RPCRequest rpcRequest);

    /**
     * Return the result of the default transformed request.
     *
     * @param rpcRequest the request
     *
     * @return the default transformed request
     */
    public native Object getDefaultTransformRequest(RPCRequest rpcRequest)/*-{
        var self = $wnd.isc.RPCManager;
        var data = self.__transformRequest(rpcRequest.@com.smartgwt.client.rpc.RPCRequest::getJsObj()());
        if(@com.smartgwt.client.data.DataSource::isRecord(Ljava/lang/Object;)(data)) {
            data = data.@com.smartgwt.client.data.Record::getJsObj()();
        } else if (@com.smartgwt.client.data.DataSource::isRecordArray(Ljava/lang/Object;)(data)) {
            data = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(data);
        }
        return data;
    }-*/;
}
