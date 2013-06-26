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

public interface ResizedHandler extends EventHandler {
    /**
     * Observable method called whenever a Canvas changes size. Note that if this canvas is {@link
     * com.smartgwt.client.widgets.Canvas#getOverflow overflow:"visible"}, and is waiting for a queued redraw (see {@link
     * com.smartgwt.client.widgets.Canvas#isDirty Canvas.isDirty}), the value for {@link
     * com.smartgwt.client.widgets.Canvas#getVisibleWidth Canvas.getVisibleWidth} and {@link
     * com.smartgwt.client.widgets.Canvas#getVisibleHeight Canvas.getVisibleHeight} will be unreliable until
     * <code>redraw()</code> fires.
     *
     * @param event the event
     */
    void onResized(com.smartgwt.client.widgets.events.ResizedEvent event);
}
