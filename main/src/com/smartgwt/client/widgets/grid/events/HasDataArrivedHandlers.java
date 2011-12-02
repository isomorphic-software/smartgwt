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

public interface HasDataArrivedHandlers extends HasHandlers {
    /**
     * Notification method fired when new data arrives from the server to be displayed in this ListGrid, (for example in
     * response to the user scrolling a new set of rows into view). Only applies to databound listGrids where the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getData data} attribute is a {@link com.smartgwt.client.data.ResultSet}. This
     * ResultSet may have been created manually and applied to the grid via a call to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setData ListGrid.setData} or may have been created and automatically assigned
     * if {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData ListGrid.fetchData} was used to populate the grid.  This
     * method is fired directly in response to {@link com.smartgwt.client.data.ResultSet#addDataArrivedHandler dataArrived()}
     * firing on the data object.
     *
     * @param handler the dataArrived handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addDataArrivedHandler(DataArrivedHandler handler);
}
