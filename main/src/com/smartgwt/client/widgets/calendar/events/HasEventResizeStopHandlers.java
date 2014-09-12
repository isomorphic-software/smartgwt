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

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
public interface HasEventResizeStopHandlers extends HasHandlers {
    /**
     * Notification called when an event drag-resize operation completes. <P> The <code>newEvent</code> parameter represents
     * the event as it will be after the move. <P> Call {@link com.smartgwt.client.widgets.calendar.events.EventResizeStop#cancel()} from within {@link com.smartgwt.client.widgets.calendar.events.EventResizeStopHandler#onEventResizeStop} to prevent the default action, of actually  {@link
     * com.smartgwt.client.widgets.calendar.Calendar#updateCalendarEvent updating} the event.
     *
     * @param handler the eventResizeStop handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addEventResizeStopHandler(EventResizeStopHandler handler);
}

