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

public interface EventRemoveClickHandler extends EventHandler {
    /**
     * Called whenever the close icon of an {@link com.smartgwt.client.widgets.calendar.EventCanvas event canvas} is clicked in
     * the  {@link com.smartgwt.client.widgets.calendar.Calendar#getDayView day}, {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getWeekView week} and {@link
     * com.smartgwt.client.widgets.calendar.Calendar#getTimelineView timeline} views.  <P> Implement this method to intercept
     * the automatic removal of data.  You can Call {@link com.smartgwt.client.widgets.calendar.events.CalendarEventRemoveClick#cancel()} from within {@link com.smartgwt.client.widgets.calendar.events.EventRemoveClickHandler#onEventRemoveClick} to  prevent the default action (calling {@link
     * com.smartgwt.client.widgets.calendar.Calendar#removeEvent removeEvent()}) and instead  take action of your own.  For
     * example, returning false from this method and then showing a  custom confirmation dialog - if the user cancels, do
     * nothing, otherwise make a call to {@link com.smartgwt.client.widgets.calendar.Calendar#removeEvent removeEvent(event)},
     * passing the event.
     *
     * @param event the event
     */
    void onEventRemoveClick(com.smartgwt.client.widgets.calendar.events.CalendarEventRemoveClick event);
}
