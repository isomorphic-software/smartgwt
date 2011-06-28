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
import com.google.gwt.event.shared.EventHandler;

public interface DrawAreaChangedHandler extends EventHandler {
    /**
     * Notification method that fires when the drawArea changes due to scrolling.  Receives   the previous drawArea
     * co-ordinates as parameters.  Call {@link com.smartgwt.client.widgets.grid.ListGrid#getDrawArea ListGrid.getDrawArea} to 
     * get the new drawArea co-ordinates. <P> Note that if this grid is showing any {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getFrozen frozen fields}, they will not be included in the
     * <code>oldStartCol</code>, <code>oldEndCol</code> range reported by this method. Frozen fields are assumed never to be
     * scrolled out of view.
     *
     * @param event the event
     */
    void onDrawAreaChanged(com.smartgwt.client.widgets.grid.events.DrawAreaChangedEvent event);
}
