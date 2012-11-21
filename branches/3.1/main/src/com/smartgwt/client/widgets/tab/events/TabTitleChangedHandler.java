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

public interface TabTitleChangedHandler extends EventHandler {
    /**
     * This notification method fired when the user changes the title of a tab in this TabSet. This can happen either through
     * user interaction with the UI if  {@link com.smartgwt.client.widgets.tab.TabSet#getCanEditTabTitles canEditTabTitles} is
     * set, or programmatically if application  code calls {@link com.smartgwt.client.widgets.tab.TabSet#editTabTitle
     * editTabTitle}.<p> Call {@link com.smartgwt.client.widgets.tab.events.TabTitleChangedEvent#cancel()} from within {@link TabTitleChangedHandler#onTabTitleChanged} from this method to cancel the change.
     *
     * @param event the event
     */
    void onTabTitleChanged(com.smartgwt.client.widgets.tab.events.TabTitleChangedEvent event);
}
