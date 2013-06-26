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

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
public interface HasMouseStillDownHandlers extends HasHandlers {
    /**
     * Executed repeatedly (every {@link com.smartgwt.client.widgets.Canvas#getMouseStillDownDelay mouseStillDownDelay} by
     * default) when the system is idle - i.e. not busy running other scripts - and the left mouse button is held down after
     * having been pressed in the object. This event is not native to JavaScript, but is provided by the ISC system. <p> Note:
     * The event handling system waits {@link com.smartgwt.client.widgets.Canvas#getMouseStillDownInitialDelay
     * mouseStillDownInitialDelay} before calling mouseStillDown for the first time on the widget.  Subsequently the method is
     * called every {@link com.smartgwt.client.widgets.Canvas#getMouseStillDownDelay mouseStillDownDelay}.  Both attributes are
     * configurable per widget instance. <p> This method is called only when the left mouse is held down.
     *
     * @param handler the mouseStillDown handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addMouseStillDownHandler(MouseStillDownHandler handler);
}

