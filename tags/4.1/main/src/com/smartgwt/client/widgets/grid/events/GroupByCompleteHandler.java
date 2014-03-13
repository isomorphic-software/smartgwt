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

public interface GroupByCompleteHandler extends EventHandler {
    /**
     * Callback fired when the listGrid is grouped or ungrouped. <P> Unlike {@link
     * com.smartgwt.client.widgets.grid.ListGrid#addGroupByHandler ListGrid.groupBy}, this notification will fire when grouping
     * is complete, and the {@link com.smartgwt.client.widgets.grid.ListGrid#getGroupTree groupTree} has been updated to
     * reflect the grouped data.
     *
     * @param event the event
     */
    void onGroupByComplete(com.smartgwt.client.widgets.grid.events.GroupByCompleteEvent event);
}
