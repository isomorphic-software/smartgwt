/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
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
     * &#010 Executed repeatedly (every {@link com.smartgwt.client.widgets.Canvas#getMouseStillDownDelay mouseStillDownDelay} by default) when the system is idle -&#010 i.e. not busy running other scripts - and the left mouse button is held down after having been&#010 pressed in the object. This event is not native to JavaScript, but is provided by the ISC system.&#010 <p>&#010 Note: The event handling system waits {@link com.smartgwt.client.widgets.Canvas#getMouseStillDownInitialDelay mouseStillDownInitialDelay} before&#010 calling mouseStillDown for the first time on the widget.  Subsequently the method is called every&#010 {@link com.smartgwt.client.widgets.Canvas#getMouseStillDownDelay mouseStillDownDelay}.  Both attributes are configurable per widget instance.&#010 <p>&#010 This method is called only when the left mouse is held down.&#010&#010
     *
     * @param handler the mouseStillDown handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addMouseStillDownHandler(MouseStillDownHandler handler);
}
