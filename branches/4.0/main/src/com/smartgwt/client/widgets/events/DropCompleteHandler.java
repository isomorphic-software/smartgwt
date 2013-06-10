/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * is published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.widgets.events;

import com.google.gwt.event.shared.EventHandler;

// This method is invoked whenever a drop operation or +link{transferSelectedData()} 
// targeting this component completes.  A drop is considered to be complete when all the client-
// side transfer operations have finished.  This includes any server turnarounds SmartClient 
// needs to make to check for duplicate records in the target component; it specifically does 
// not include any add or update operations sent to the server for databound components.  If 
// you want to be notified when the entire drag operation - including server updates and cache
// synchronization - has completed, override +link{dataBoundComponent.dragComplete,dragComplete}
// on the source component.<p>
// There is no default implementation of this method; you are intended to override it if you 
// are interested in being notified when drop operations complete.
//
// @param transferredRecords (List of Record) The list of records actually transferred to
//                    this component (note that this is not necessarily the same thing as the
//                    list of records dragged out of the source component because it doesn't
//                    include records that were excluded because of collisions with existing
//                    records)

public interface DropCompleteHandler extends EventHandler {
    /**
     * Notification method fired whenever a drop operation or {@link com.smartgwt.client.widgets.DataBoundComponent.transferSelectedData()} targeting this component completes.
     * A drop is considered to be complete when all the client-side transfer operations have finished.  This includes any server 
     * turnarounds Smart GWT needs to make to check for duplicate records in the target component; it specifically does not include 
     * any add or update operations sent to the server for databound components.  If you want to be notified when the entire drag 
     * operation - including server updates and cache synchronization - has completed, add a 
     * {@link com.smartgwt.client.widgets.events.DragCompleteHandler} to the source component.
     *
     * @param event the event
     */
    void onDropComplete(DropCompleteEvent event);
}
