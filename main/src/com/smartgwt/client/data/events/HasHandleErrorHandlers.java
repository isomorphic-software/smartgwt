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
 
package com.smartgwt.client.data.events;

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasHandleErrorHandlers extends HasHandlers {
    /**
     * If you define this method on a DataSource, it will be called whenever the server returns a DSResponse with a status
     * other than {@link com.smartgwt.client.rpc.RPCResponse#STATUS_SUCCESS STATUS_SUCCESS}.  You can use this hook to do
     * DataSource-specific error handling.  Unless you return <code>false</code> from this method, {@link
     * com.smartgwt.client.rpc.RPCManager#handleError RPCManager.handleError} will be called by Smart GWT right after this
     * method completes.
     *
     * @param handler the handleError handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addHandleErrorHandler(HandleErrorHandler handler);
}
