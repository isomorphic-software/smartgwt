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
 
package com.smartgwt.client.widgets.tile.events;
import com.google.gwt.event.shared.EventHandler;

public interface SelectionChangedHandler extends EventHandler {
    /**
     * Called when selection changes within this tileGrid. Note this method fires for each record for which selection is
     * modified - so when a user clicks inside a tileGrid this method will typically fire twice (once for the old record being
     * deselected, and once for the new record being selected).
     *
     * @param event the event
     */
    void onSelectionChanged(com.smartgwt.client.widgets.tile.events.SelectionChangedEvent event);
}
