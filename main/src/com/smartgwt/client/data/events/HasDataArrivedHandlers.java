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
 
package com.smartgwt.client.data.events;

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
public interface HasDataArrivedHandlers extends HasHandlers {
    /**
     * Notification fired when data has arrived from the server and has been successfully integrated into the cache. <P> When
     * <code>dataArrived()</code> fires, an immediate call to <code>getRange()</code> with the <code>startRow</code> and
     * <code>endRow</code> passed as arguments will return a List with no {@link
     * com.smartgwt.client.data.ResultSet#getLoadingMarker loading markers}. <P> Note that <code>dataArrived()</code> won't
     * fire in the case of the owning component filtering with unchanged criteria (for example using {@link
     * com.smartgwt.client.widgets.grid.ListGrid#fetchData ListGrid.fetchData()} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#filterData ListGrid.filterData()}).  To support backward compatibility, the
     * property {@link com.smartgwt.client.data.ResultSet#getReapplyUnchangedLocalFilter reapplyUnchangedLocalFilter} can be
     * set to force <code>dataArrived()</code> to be called if the ResultSet is {@link
     * com.smartgwt.client.data.ResultSet#filterLocalData filtering locally} and the criteria haven't changed but are narrower
     * than the criteria used to fetch the current cache.
     *
     * @param handler the dataArrived handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addDataArrivedHandler(DataArrivedHandler handler);
}
