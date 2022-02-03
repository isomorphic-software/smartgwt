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
 
package com.smartgwt.client.widgets.form.events;

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
public interface HasColorChangedHandlers extends HasHandlers {
    /**
     * Override this method to be kept informed when the ColorPicker changes in real-time  (for example, if you need to update
     * your own GUI accordingly). Then use the  getXxxx() methods (for example, {@link
     * com.smartgwt.client.widgets.form.ColorPicker#getBlue getBlue()} or  {@link
     * com.smartgwt.client.widgets.form.ColorPicker#getLuminosity getLuminosity()})to obtain current state as required.
     *
     * @param handler the colorChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addColorChangedHandler(ColorChangedHandler handler);
}
