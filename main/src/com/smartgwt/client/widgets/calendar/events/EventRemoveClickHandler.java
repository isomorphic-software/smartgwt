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

public interface EventRemoveClickHandler extends EventHandler {
    /**
     * Called whenever the close icon of an event is clicked within the day or week view. Call {@link com.smartgwt.client.widgets.calendar.events.CalendarEventRemoveClick#cancel()} from within {@link EventRemoveClickHandler#onEventRemoveClick} to cancel the removal,
     * or . <P> Implement this method to do something like, for example, showing a confirmation dialog  before
     * an event is removed.
     *
     * @param event the event
     */
    void onEventRemoveClick(com.smartgwt.client.widgets.calendar.events.CalendarEventRemoveClick event);
}
