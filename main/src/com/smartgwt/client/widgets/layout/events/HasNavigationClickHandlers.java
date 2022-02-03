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
 
package com.smartgwt.client.widgets.layout.events;

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
public interface HasNavigationClickHandlers extends HasHandlers {
    /**
     * Notification method fired when the user clicks the default back / forward buttons on the navigation bar for this
     * <code>SplitPane</code>. <P> Note that the return value will be ignored and cancelation won't be possible if {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNotifyAfterNavigationClick notifyAfterNavigationClick} has been set
     * true, since that forces this method to run after we've already navigated to the new pane.
     *
     * @param handler the navigationClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addNavigationClickHandler(NavigationClickHandler handler);
}
