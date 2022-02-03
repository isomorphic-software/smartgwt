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
 
package com.smartgwt.client.widgets.menu.events;

import com.google.gwt.event.shared.EventHandler;

public interface ClickHandler extends EventHandler {
    /**
     * Executed when this menu item is clicked by the user. The click handler must be specified as a function or string of
     * script.  Call {@link com.smartgwt.client.widgets.menu.events.MenuItemClickEvent#cancel()} from within {@link com.smartgwt.client.widgets.menu.events.ClickHandler#onClick} to suppress the {@link com.smartgwt.client.widgets.menu.Menu#addItemClickHandler Menu.itemClick()}
     * handler if specified.
     *
     * @param event the event
     */
    void onClick(com.smartgwt.client.widgets.menu.events.MenuItemClickEvent event);
}
