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
 
package com.smartgwt.client.widgets.tree.events;

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
public interface HasDataArrivedHandlers extends HasHandlers {
    /**
     * Notification method fired whenever this TreeGrid receives new data nodes from the  dataSource. Only applies to databound
     * TreeGrids where {@link com.smartgwt.client.widgets.tree.TreeGrid#getData data} is a  {@link
     * com.smartgwt.client.widgets.tree.ResultTree} - either explicitly created and applied via {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#setData setData()} or automatically generated via a {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#fetchData fetchData()} call. <P> Note that <code>dataArrived()</code>, unlike
     * {@link com.smartgwt.client.widgets.tree.TreeGrid#addDataChangedHandler TreeGrid.dataChanged()}, only fires in limited
     * circumstances - when data for a {@link com.smartgwt.client.widgets.tree.ResultTree} arrives from the server due to a
     * fetch or cache invalidation, or as a result of filtering.  If you want to catch all data changes, you should instead
     * react to {@link com.smartgwt.client.widgets.tree.TreeGrid#addDataChangedHandler TreeGrid.dataChanged()}.
     *
     * @param handler the dataArrived handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addDataArrivedHandler(DataArrivedHandler handler);
}
