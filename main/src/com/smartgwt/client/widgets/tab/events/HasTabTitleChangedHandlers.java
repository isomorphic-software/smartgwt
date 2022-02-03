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

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
public interface HasTabTitleChangedHandlers extends HasHandlers {
    /**
     * This notification method fired when the user changes the title of a tab in this TabSet. This can happen either through
     * user interaction with the UI if  {@link com.smartgwt.client.widgets.tab.TabSet#getCanEditTabTitles canEditTabTitles} is
     * set, or programmatically if application  code calls {@link com.smartgwt.client.widgets.tab.TabSet#editTabTitle
     * editTabTitle}.<p> Call {@link com.smartgwt.client.widgets.tab.events.TabTitleChangedEvent#cancel()} from within {@link com.smartgwt.client.widgets.tab.events.TabTitleChangedHandler#onTabTitleChanged} from this method to cancel the change.
     *
     * @param handler the tabTitleChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addTabTitleChangedHandler(TabTitleChangedHandler handler);
}
