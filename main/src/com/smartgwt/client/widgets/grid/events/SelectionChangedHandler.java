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

public interface SelectionChangedHandler extends EventHandler {
    /**
     * Called when (row-based) selection changes within this grid. Note this method fires for each record for which selection
     * is modified - so when a user clicks inside a grid this method will typically fire twice (once for the old record being
     * deselected, and once for the new record being selected). <P> NOTE: For updating other components based on selections or
     * triggering selection-oriented events within an application, see the {@link
     * com.smartgwt.client.widgets.DataBoundComponent#selectionUpdated selectionUpdated()} event which is likely more suitable.
     * Calls to {@link com.smartgwt.client.widgets.grid.ListGrid#getSelection getSelection()} from within this event may not
     * return a valid set of selected records if the event has been triggered by a call to {@link
     * com.smartgwt.client.widgets.DataBoundComponent#selectAllRecords selectAllRecords()} or {@link
     * com.smartgwt.client.widgets.DataBoundComponent#deselectAllRecords deselectAllRecords()} - in this case use the {@link
     * com.smartgwt.client.widgets.DataBoundComponent#selectionUpdated selectionUpdated()} event instead.
     *
     * @param event the event
     */
    void onSelectionChanged(com.smartgwt.client.widgets.grid.events.SelectionEvent event);
}
