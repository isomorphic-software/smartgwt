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

import com.smartgwt.client.rpc.RPCRequest;
import com.smartgwt.client.rpc.RPCResponse;

public interface LoginRequiredCallback {

    /** 
     * Called when a session timeout is encountered while trying to do a background RPC.
     *
     * @param transactionNum id of the transaction
     * @param rpcRequest first RPCRequest of the transaction
     * @param rpcResponse RPCResponse containing the session timeout response that                                  caused loginRequired() to be
     * invoked
     */
	public void loginRequired(int transactionNum, RPCRequest rpcRequest, RPCResponse rpcResponse);
} 
