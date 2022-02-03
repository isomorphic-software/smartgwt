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

public interface EventClickHandler extends EventHandler {
    /**
     * Called whenever an event is clicked on in the day, week or month views. <P> By default a dialog appears showing details
     * for the event, and offering the ability to edit events which are editable.  Call {@link com.smartgwt.client.widgets.calendar.events.CalendarEventClick#cancel()} from within {@link com.smartgwt.client.widgets.calendar.events.EventClickHandler#onEventClick} to cancel the default action.
     * This is a good place to, for example, show a completely customized event dialog instead of the default one.
     *
     * @param event the event
     */
    void onEventClick(com.smartgwt.client.widgets.calendar.events.CalendarEventClick event);
}
