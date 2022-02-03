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

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
public interface HasMouseStillDownHandlers extends HasHandlers {
    /**
     * Repeating notification method for the user holding the left mouse button down over this canvas. <P> The
     * <code>mouseStillDown</code> event is fired immediately when the mouse goes down. If the user holds the mouse down, after
     * a pause of  {@link com.smartgwt.client.widgets.Canvas#getMouseStillDownInitialDelay mouseStillDownInitialDelay}, it will
     * begin to fire repeatedly every  {@link com.smartgwt.client.widgets.Canvas#getMouseStillDownDelay mouseStillDownDelay}
     * milliseconds. <P> This provides developers with a simple way to handle the common "repeated action"  use case where a
     * user can click a UI element to perform an action once, or click  and hold to perform the action repeatedly.<br> Examples
     * of this include standard scrollbar button behavior and buttons  to increase or decrease the value in a spinner type
     * input element. <P> This event is not native to JavaScript, but is provided by the ISC system.
     *
     * @param handler the mouseStillDown handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addMouseStillDownHandler(MouseStillDownHandler handler);
}
