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
 
package com.smartgwt.client.widgets.tab.events;

import com.google.gwt.event.shared.EventHandler;

public interface CloseClickHandler extends EventHandler {
    /**
     * When {@link com.smartgwt.client.widgets.tab.TabSet#getCanCloseTabs canCloseTabs} is set, this notification method fired
     * when the user clicks  the "close" icon for a tab. Call {@link com.smartgwt.client.widgets.tab.events.TabCloseClickEvent#cancel()} from within {@link CloseClickHandler#onCloseClick} to cancel default behavior of removing the tab from the
     * TabSet
     *
     * @param event the event
     */
    void onCloseClick(com.smartgwt.client.widgets.tab.events.TabCloseClickEvent event);
}
