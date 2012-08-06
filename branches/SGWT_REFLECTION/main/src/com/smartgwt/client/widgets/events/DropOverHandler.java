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

public interface DropOverHandler extends EventHandler {
    /**
     * Executed when the compatible dragged object is first moved over this drop target. Your implementation can use this to
     * show a custom visual indication that the object can be dropped here.
     *
     * @param event the event
     */
    void onDropOver(com.smartgwt.client.widgets.events.DropOverEvent event);
}
