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

public interface ClearHandler extends EventHandler {
    /**
     * Notification method fired when the canvas is removed from the DOM via a  call to {@link
     * com.smartgwt.client.widgets.Canvas#clear clear()}. Canvases are cleared recursively, so if  a parent is
     * <i>clear()</i>'d, all of its descendants will also be cleared. This notification is fired before the canvas has been
     * removed from the DOM, and {@link com.smartgwt.client.widgets.Canvas#isDrawn isDrawn()} will return <code>true</code> if
     * called while the  notification is running.
     *
     * @param event the event
     */
    void onClear(com.smartgwt.client.widgets.events.ClearEvent event);
}
