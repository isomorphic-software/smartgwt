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

public interface DragRepositionStopHandler extends EventHandler {
    /**
     * Executed when the mouse button is released at the end of the drag. Your widget can use this opportunity to fire custom
     * code based upon where the mouse button was released, etc. <p> Returning true from this handler will cause the {@link
     * com.smartgwt.client.widgets.Canvas#getDragTarget dragTarget} (or outline if {@link
     * com.smartgwt.client.widgets.Canvas#getDragAppearance dragAppearance} is set to "outline") to be left in its current
     * location. Returning false from this handler will cause it to snap back to its original location.
     *
     * @param event the event
     */
    void onDragRepositionStop(com.smartgwt.client.widgets.events.DragRepositionStopEvent event);
}
