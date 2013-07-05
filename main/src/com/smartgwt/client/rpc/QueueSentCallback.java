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


public interface QueueSentCallback {

    /** 
     * <p>This method is called by the RPCManager every time it sends a queue of requests to the server (note that if you not
     * using queuing, the system simply sends queues containing just one request, so this API is valid regardless). <p/> It is
     * intended to be used by user code that needs to be notified when SmartGWT sends requests to the server.  Note that the
     * list of {@link com.smartgwt.client.rpc.RPCRequest}'s passed to this method is strictly <b>read-only</b>.
     *
     * @param response array of requests sent
     */
	public void queueSent(RPCRequest... response);
} 
