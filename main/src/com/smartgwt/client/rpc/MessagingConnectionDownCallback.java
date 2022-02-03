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


public interface MessagingConnectionDownCallback {

    /** 
     * Called when the messaging connection allowing the server to send messages to the client is disconnected.  This can occur
     * either when you explicitly disconnect the connection or if a keepalive packet from the server does not arrive on time. 
     * This latter is defined as the {@link com.smartgwt.client.messaging.Messaging#getKeepaliveInterval
     * Messaging.keepaliveInterval} plus the {@link com.smartgwt.client.messaging.Messaging#getKeepaliveReestablishDelay
     * Messaging.keepaliveReestablishDelay}. With default settings, a maximum of 4 seconds will elapse between the connection
     * actually going down and you receiving this callback.
     *
     */
	public void execute();
} 
