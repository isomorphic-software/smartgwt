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

public interface EventRepositionStopHandler extends EventHandler {
    /**
     * Notification called when an event being drag-moved is dropped. <P> The <code>newEvent</code> parameter represents the
     * event as it will be after the move,  including {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getStartDate
     * start} and {@link com.smartgwt.client.widgets.calendar.CalendarEvent#getEndDate end} dates and {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getLane lane} and {@link
     * com.smartgwt.client.widgets.calendar.CalendarEvent#getSublane sublane} where  applicable. <P> Call {@link com.smartgwt.client.widgets.calendar.events.EventRepositionStop#cancel()} from within {@link com.smartgwt.client.widgets.calendar.events.EventRepositionStopHandler#onEventRepositionStop} to prevent
     * the default action, of actually  {@link com.smartgwt.client.widgets.calendar.Calendar#updateCalendarEvent updating} the
     * event.
     *
     * @param event the event
     */
    void onEventRepositionStop(com.smartgwt.client.widgets.calendar.events.EventRepositionStop event);
}
