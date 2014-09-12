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

public interface GroupByHandler extends EventHandler {
    /**
     * Callback fired when the user attempts to group or ungroup the listGrid, or when {@link
     * com.smartgwt.client.widgets.grid.ListGrid#groupBy ListGrid.groupBy} is called programmatically.  This event may be
     * cancelled. <P> This notification is fired before the {@link com.smartgwt.client.widgets.grid.ListGrid#getGroupTree data}
     * is updated to reflect the grouping. See also {@link com.smartgwt.client.widgets.grid.ListGrid#addGroupByCompleteHandler
     * ListGrid.groupByComplete}.
     *
     * @param event the event
     */
    void onGroupBy(com.smartgwt.client.widgets.grid.events.GroupByEvent event);
}
