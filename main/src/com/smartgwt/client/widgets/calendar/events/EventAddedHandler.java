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
 
package com.smartgwt.client.widgets.calendar.events;

import com.google.gwt.event.shared.EventHandler;

public interface EventAddedHandler extends EventHandler {
    /**
     * Notification fired whenever a user adds an event. <P> In a calendar with a DataSource, eventAdded() fires <b>after</b>
     * the event has been successfully added at the server
     *
     * @param event the event
     */
    void onEventAdded(com.smartgwt.client.widgets.calendar.events.CalendarEventAdded event);
}
