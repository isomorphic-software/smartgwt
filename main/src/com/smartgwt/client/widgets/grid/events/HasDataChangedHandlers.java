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
public interface HasDataChangedHandlers extends HasHandlers {
    /**
     * Notification method fired when the ListGrid's data changes, for any reason. <P>  Examples of why data changed might
     * be:<ul> <li> a call to {@link com.smartgwt.client.widgets.grid.ListGrid#addData addData()}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#updateData updateData()}, or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#removeData removeData()} <li> {@link com.smartgwt.client.data.DataSource}
     * updates from the server for {@link com.smartgwt.client.data.ResultSet} data (triggered by record editing, etc.) <li>
     * fetches arriving back from the server for {@link com.smartgwt.client.data.ResultSet} data <li> changes to array data if
     * made through APIs such as  Array.set(),  Array.add(), etc. <li> cache invalidation <li> filtering </ul> Calling {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setData setData()} doesn't call this notification directly, but it may fire if
     * one of the above listed events is triggered (e.g. a server fetch for  {@link com.smartgwt.client.data.ResultSet} data).
     * <P> Note that the <code>operationType</code> parameter is optional and will be passed and contain the operation (e.g.
     * "update") if this notification was triggered by a fetch, an {@link com.smartgwt.client.widgets.grid.ListGrid#addData
     * addData()}, {@link com.smartgwt.client.widgets.grid.ListGrid#updateData updateData()}, or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#removeData removeData()}, or a {@link com.smartgwt.client.data.DataSource}
     * update for {@link com.smartgwt.client.data.ResultSet} data (the first three reasons listed above) but otherwise will be
     * null.
     *
     * @param handler the dataChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addDataChangedHandler(DataChangedHandler handler);
}
