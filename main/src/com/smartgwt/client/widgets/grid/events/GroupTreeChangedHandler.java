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

public interface GroupTreeChangedHandler extends EventHandler {
    /**
     * Callback fired when a {@link com.smartgwt.client.widgets.grid.ListGrid#getGroupByField grouping} operation completes,
     * whether it started as a direct call to {@link com.smartgwt.client.widgets.grid.ListGrid#groupBy groupBy()} or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#regroup regroup()} or data changing, including incremental changes. <P> If
     * <code>changeType</code> is "groupBy", {@link com.smartgwt.client.widgets.grid.ListGrid#addGroupByHandler
     * ListGrid.groupBy()} should have been called at the beginning of the operation, and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#addGroupByCompleteHandler ListGrid.groupByComplete()} will be called
     * immediately before this method.  If <code>changeType</code> is "regroup", then  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#addRegroupHandler ListGrid.regroup()} should have been called at the beginning
     * of the operation.
     *
     * @param event the event
     */
    void onGroupTreeChanged(com.smartgwt.client.widgets.grid.events.GroupTreeChangedEvent event);
}
