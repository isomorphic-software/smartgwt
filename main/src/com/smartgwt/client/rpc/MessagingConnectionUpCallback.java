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


public interface MessagingConnectionUpCallback {

    /** 
     * Called when the messaging connection allowing the server to send messages to the client is established - whether that's
     * the result of an initial connect() or a re-establishment after it is severed.
     * A new connection is stablished each time you subscribe() to a new channel, and it remains alive until
     * you explicitly call unsubscribe(), disconnect(), or until it is automatically re-created.
     * Connections are re-created every 2 minutes by default because intervening firewalls or web proxies will often sever
     * connections that have been open too long, as will the browser itself. You can configure the time between the connection
     * is re-created setting the messaging.connectionTTL property in server.properties
     *
     */
	public void execute();
} 
