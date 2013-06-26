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
 
package com.smartgwt.client.widgets.grid.events;

import com.google.gwt.event.shared.EventHandler;

public interface SorterClickHandler extends EventHandler {
    /**
     * Notification method fired when the user clicks on the corner  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSorterConstructor sort button}.  Call {@link com.smartgwt.client.widgets.grid.events.SorterClickEvent#cancel()} from within {@link SorterClickHandler#onSorterClick} to suppress the sort.
     *
     * @param event the event
     */
    void onSorterClick(com.smartgwt.client.widgets.grid.events.SorterClickEvent event);
}
