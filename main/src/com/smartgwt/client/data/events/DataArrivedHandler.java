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

import com.google.gwt.event.shared.EventHandler;

public interface DataArrivedHandler extends EventHandler {
    /**
     * Notification fired when data has arrived from the server and has been successfully integrated into the cache. <P> When
     * <code>dataArrived()</code> fires, an immediate call to <code>getRange()</code> with the <code>startRow</code> and
     * <code>endRow</code> passed as arguments will return a List with no {@link
     * com.smartgwt.client.data.ResultSet#getLoadingMarker loading markers}.
     *
     * @param event the event
     */
    void onDataArrived(com.smartgwt.client.data.events.DataArrivedEvent event);
}
