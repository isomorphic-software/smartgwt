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
 
package com.smartgwt.client.widgets.grid.events;

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasSelectionChangedHandlers extends HasHandlers {
    /**
     * Called when (row-based) selection changes within this grid. Note this method fires for&#010 each record for which selection is modified - so when a user clicks inside a grid this&#010 method will typically fire twice (once for the old record being deselected, and once for&#010 the new record being selected).&#010&#010
     *
     * @param handler the selectionChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addSelectionChangedHandler(SelectionChangedHandler handler);
}
