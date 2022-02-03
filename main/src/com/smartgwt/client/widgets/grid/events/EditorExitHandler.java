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

public interface EditorExitHandler extends EventHandler {
    /**
     * Callback fired when the user attempts to navigate away from the current edit cell, or complete the current edit.<br>
     * Call {@link com.smartgwt.client.widgets.grid.events.EditorExitEvent#cancel()} from within {@link com.smartgwt.client.widgets.grid.events.EditorExitHandler#onEditorExit} from this method to cancel the default behavior (Saving / cancelling the current edit / moving to the next
     * edit cell)
     *
     * @param event the event
     */
    void onEditorExit(com.smartgwt.client.widgets.grid.events.EditorExitEvent event);
}
