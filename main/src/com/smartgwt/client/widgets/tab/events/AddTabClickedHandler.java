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
 
package com.smartgwt.client.widgets.tab.events;

import com.google.gwt.event.shared.EventHandler;

public interface AddTabClickedHandler extends EventHandler {
    /**
     * Event that fires when the {@link com.smartgwt.client.widgets.tab.TabSet#getAddTabButton addTabButton} is clicked. No
     * default behavior.
     *
     * @param event the event
     */
    void onAddTabClicked(com.smartgwt.client.widgets.tab.events.AddTabClickedEvent event);
}