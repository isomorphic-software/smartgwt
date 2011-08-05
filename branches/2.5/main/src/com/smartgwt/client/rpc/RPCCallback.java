/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.rpc;

public interface RPCCallback {

    /**
     *
     * @param response a RPCResponse encapsulating the server response to your request
     * @param rawData just the "data" property from the RPCResponse, for convenience
     * @param request the RPCRequest that was sent. You can use RPCRequest.clientContext to track state during the server turnaround
     */
    void execute(RPCResponse response, Object rawData, RPCRequest request);

}
