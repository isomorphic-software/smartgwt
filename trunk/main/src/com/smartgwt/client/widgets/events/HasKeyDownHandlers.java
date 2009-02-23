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

public interface HasKeyDownHandlers extends HasHandlers {
    /**
     * Executed when a key is pressed on a focusable widget ({@link com.smartgwt.client.widgets.Canvas#getCanFocus canFocus}: true).  <P> Use {@link com.smartgwt.client.util.EventHandler#getKey} to find out the ${isc.DocUtils.linkForRef('type:KeyName','keyName')} of the key that was pressed, and use {@link com.smartgwt.client.util.EventHandler#shiftKeyDown} and related functions to determine whether modifier keys were down.
     */
    HandlerRegistration addKeyDownHandler(KeyDownHandler handler);
}
