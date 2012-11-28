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

public interface MovedHandler extends EventHandler {
    /**
     * Notification method fired when this component is explicitly moved. Note that a component's position on the screen may
     * also changed due to an ancestor being moved. The {@link com.smartgwt.client.widgets.drawing.DrawItem#getParentMoved
     * parentMoved} method provides a notification entry point to catch that case as well.
     *
     * @param event the event
     */
    void onMoved(com.smartgwt.client.widgets.drawing.events.MovedEvent event);
}
