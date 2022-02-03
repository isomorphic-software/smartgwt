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

import com.google.gwt.event.shared.EventHandler;

public interface DataArrivedHandler extends EventHandler {
    /**
     * Notification method fired when new data arrives from the server to be displayed in this ListGrid, (for example in
     * response to the user scrolling a new set of rows into view). Only applies to databound listGrids where the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getData data} attribute is a {@link com.smartgwt.client.data.ResultSet}. This
     * ResultSet may have been created manually and applied to the grid via a call to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setData setData()} or may have been created and automatically assigned if
     * {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData fetchData()} was used to populate the grid.  This method is
     * fired directly in response to {@link com.smartgwt.client.data.ResultSet#addDataArrivedHandler dataArrived()} firing on
     * the data object. <P> Note that <code>dataArrived()</code>, unlike {@link
     * com.smartgwt.client.widgets.grid.ListGrid#addDataChangedHandler ListGrid.dataChanged()}, only fires in limited
     * circumstances - when data for a {@link com.smartgwt.client.data.ResultSet} arrives from the server due to a fetch or
     * cache invalidation, or as a result of filtering.  If you want to catch all data changes, you should instead react to
     * {@link com.smartgwt.client.widgets.grid.ListGrid#addDataChangedHandler ListGrid.dataChanged()}.
     *
     * @param event the event
     */
    void onDataArrived(com.smartgwt.client.widgets.grid.events.DataArrivedEvent event);
}
