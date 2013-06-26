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
 
package com.smartgwt.client.widgets.calendar.events;

import com.google.gwt.event.shared.EventHandler;

public interface EventMovedHandler extends EventHandler {
    /**
     * Called when an event is moved via dragging by a user.  Call {@link com.smartgwt.client.widgets.calendar.events.CalendarEventMoved#cancel()} from within {@link EventMovedHandler#onEventMoved} to disallow the move.
     *
     * @param event the event
     */
    void onEventMoved(com.smartgwt.client.widgets.calendar.events.CalendarEventMoved event);
}
