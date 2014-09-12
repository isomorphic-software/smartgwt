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

public interface EventResizeMoveHandler extends EventHandler {
    /**
     * Notification called on each resize during an event drag-resize operation. <P> The <code>newEvent</code> parameter
     * represents the event as it will be after the resize. <P> Call {@link com.smartgwt.client.widgets.calendar.events.EventResizeMove#cancel()} from within {@link com.smartgwt.client.widgets.calendar.events.EventResizeMoveHandler#onEventResizeMove} to prevent the default action, of resizing the
     * drag canvas to the newEvent.
     *
     * @param event the event
     */
    void onEventResizeMove(com.smartgwt.client.widgets.calendar.events.EventResizeMove event);
}
