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
 
package com.smartgwt.client.tools;

import com.google.gwt.event.shared.EventHandler;

public interface SelectedEditNodesUpdatedHandler extends EventHandler {
    /**
     * Called when editMode selection changes. Note this method fires exactly once for any given change. <P> This event is
     * fired once after selection/deselection has completed. The result is one event per mouse-down event. For a drag selection
     * there will be one event fired when the range is completed.
     *
     * @param event the event
     */
    void onSelectedEditNodesUpdated(com.smartgwt.client.tools.SelectedEditNodesUpdatedEvent event);
}
