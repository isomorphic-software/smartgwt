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
 
package com.smartgwt.client.widgets.form.events;

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
public interface HasItemKeyPressHandlers extends HasHandlers {
    /**
     * Handler fired when a FormItem within this form receives a keypress event. <P> Fires after the keyPress handler on the
     * FormItem itself, and only if the item did not cancel the event and chooses to allow it to propagate to the form as a
     * whole.
     *
     * @param handler the itemKeyPress handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addItemKeyPressHandler(ItemKeyPressHandler handler);
}

