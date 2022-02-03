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
 
package com.smartgwt.client.widgets.grid.events;

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
public interface HasRegroupHandlers extends HasHandlers {
    /**
     * Callback fired when a regroup operation is begun, either from a direct call to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#regroup regroup()}, or because of {@link
     * com.smartgwt.client.widgets.grid.ListGrid#addDataChangedHandler data arriving from the server} when the grid is already
     * {@link com.smartgwt.client.widgets.grid.ListGrid#groupBy grouped}. <P> After this call, the Framework should eventually
     * call {@link com.smartgwt.client.widgets.grid.ListGrid#addGroupTreeChangedHandler ListGrid.groupTreeChanged()}.
     *
     * @param handler the regroup handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addRegroupHandler(RegroupHandler handler);
}
