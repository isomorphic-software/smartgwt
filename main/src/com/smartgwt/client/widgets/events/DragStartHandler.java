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
 
package com.smartgwt.client.widgets.events;

import com.google.gwt.event.shared.EventHandler;

public interface DragStartHandler extends EventHandler {
    /**
     * Executed when dragging first starts. Your widget can use this opportunity to set things up for the drag, such as setting
     * the drag tracker. Returning false from this event handler will cancel the drag action entirely. <p> A drag action is
     * considered to be begin when the mouse has moved {@link com.smartgwt.client.widgets.Canvas#getDragStartDistance
     * dragStartDistance} with the left mouse down.
     *
     * @param event the event
     */
    void onDragStart(com.smartgwt.client.widgets.events.DragStartEvent event);
}
