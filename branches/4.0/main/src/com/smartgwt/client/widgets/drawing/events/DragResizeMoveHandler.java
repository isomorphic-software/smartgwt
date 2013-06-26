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
 
package com.smartgwt.client.widgets.drawing.events;

import com.google.gwt.event.shared.EventHandler;

public interface DragResizeMoveHandler extends EventHandler {
    /**
     * If {@link com.smartgwt.client.widgets.drawing.DrawItem#getCanDrag canDrag} and {@link
     * com.smartgwt.client.widgets.drawing.DrawPane#getCanDrag canDrag} are both true and the {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control knobs} include "resize" knobs, then this notification
     * method will be fired when the user drags the resize knobs of the draw item.
     *
     * @param event the event
     */
    void onDragResizeMove(com.smartgwt.client.widgets.drawing.events.DragResizeMoveEvent event);
}
