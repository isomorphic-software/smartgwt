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

public interface TabDeselectedHandler extends EventHandler {
    /**
     * Optional handler to fire when a tab is deselected. Calling {@link
     * com.smartgwt.client.widgets.tab.events.TabDeselectedEvent#cancel}  will cancel the new selection, leaving tab
     * <code>ID</code> selected.  As with  {@link com.smartgwt.client.widgets.tab.events.TabSelectedEventl} this method only
     * fires when the tabset is drawn.
     *
     * @param event the event
     */
    void onTabDeselected(com.smartgwt.client.widgets.tab.events.TabDeselectedEvent event);
}
