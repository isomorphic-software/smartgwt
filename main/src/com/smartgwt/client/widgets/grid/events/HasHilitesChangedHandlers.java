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
 
package com.smartgwt.client.widgets.grid.events;

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
public interface HasHilitesChangedHandlers extends HasHandlers {
    /**
     * Notification method executed whenever the end user uses the HiliteEditor to change the set of hilites applied to this
     * grid.  This method will not be called after a purely programmatic change to the hilites made with a call to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSetHilites setHilites}).  The array of currently applied hilite objects is
     * accessible via {@link com.smartgwt.client.widgets.grid.ListGrid#getGetHilites getHilites}.
     *
     * @param handler the hilitesChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addHilitesChangedHandler(HilitesChangedHandler handler);
}

