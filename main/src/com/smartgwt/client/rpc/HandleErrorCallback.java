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

import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DSRequest;

public interface HandleErrorCallback {

    /** 
     * Called when an error is encountered while trying to do a background RPC.<P> See {@link
     * com.smartgwt.client.rpc.RPCManager#setHandleErrorCallback RPCManager.setHandleErrorCallback()} or the {@link
     * com.smartgwt.client.docs.ErrorHandling overview of error handling} for additional guidance.
     *
     * @param response response the response
     * @param request request the request
     */
	public void handleError(DSResponse response, DSRequest request);
} 
