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
 
package com.smartgwt.client.widgets.events;
import com.google.gwt.event.shared.EventHandler;

public interface DragRepositionMoveHandler extends EventHandler {
    /**
     * Executed every time the mouse moves while drag-repositioning. If this method does not Call {@link com.smartgwt.client.widgets.events.DragRepositionMoveEvent#cancel()} from within {@link DragRepositionMoveHandler#onDragRepositionMove}, the {@link
     * com.smartgwt.client.widgets.Canvas#getDragTarget dragTarget} (or outline if {@link
     * com.smartgwt.client.widgets.Canvas#getDragAppearance dragAppearance} is set to "outline") will automatically be moved as
     * appropriate whenever the mouse moves.
     *
     * @param event the event
     */
    void onDragRepositionMove(com.smartgwt.client.widgets.events.DragRepositionMoveEvent event);
}
