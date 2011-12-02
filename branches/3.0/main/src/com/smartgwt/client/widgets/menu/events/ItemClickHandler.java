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
 
package com.smartgwt.client.widgets.menu.events;
import com.google.gwt.event.shared.EventHandler;

public interface ItemClickHandler extends EventHandler {
    /**
     * Executed when a menu item with no click handler is clicked by the user. This          itemClick handler must be
     * specified as a function. It is passed an item parameter that          is a reference to the clicked menu item.
     *
     * @param event the event
     */
    void onItemClick(com.smartgwt.client.widgets.menu.events.ItemClickEvent event);
}
