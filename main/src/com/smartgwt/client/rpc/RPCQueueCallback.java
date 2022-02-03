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
 
package com.smartgwt.client.rpc;

import com.smartgwt.client.rpc.RPCResponse;

public interface RPCQueueCallback {

    /** 
     * Callback to fire when a queue of requests sent via  {@link
     * com.smartgwt.client.rpc.RPCManager#sendQueue(RPCQueueCallback)} returns. <P>Note that the Array of RPCResponses passed
     * to this callback will actually be DSResponse objects for any requests that were actually  DSRequests.  DSResponse is a
     * subclass of RPCResponse, and you can "typecast" the underlying JavaScript object to a DSResponse like so:<br> <code>new
     * DSResponse(rpcResponse.getJsObj());</code>
     *
     * @param response array of responses returned from the sent queue of requests
     */
	public void execute(RPCResponse... response);
} 
