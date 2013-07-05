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
 
package com.smartgwt.client.rpc;

import com.smartgwt.client.rpc.RPCResponse;
import com.smartgwt.client.rpc.RPCRequest;

public interface RPCCallback {

    /** 
     * A Callback to evaluate when an RPCRequest completes.
     *
     * @param response response a RPCResponse encapsulating the server response to your request
     * @param rawData rawData The "data" property from the RPCResponse, for convenience.  The data can also be obtained via {@link
     * RPCResponse#getDataAsMap()}, {@link RPCResponse#getDataAsString()}, or {@link RPCResponse#getDataAsObject()}, depending
     * on the type of data that is expected to be returned from the server.
     * @param request the RPCRequest that was sent.
     */
	public void execute(RPCResponse response, Object rawData, RPCRequest request);
} 
