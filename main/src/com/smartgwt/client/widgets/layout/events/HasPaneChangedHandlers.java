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
public interface HasPaneChangedHandlers extends HasHandlers {
    /**
     * Notification fired when the {@link com.smartgwt.client.widgets.layout.SplitPane#getCurrentPane currentPane} changes,
     * either due to end-user action or due to a programmatic call to {@link
     * com.smartgwt.client.widgets.layout.SplitPane#setCurrentPane setCurrentPane()} or other APIs that can change the pane.
     * <p> Note that depending on the {@link com.smartgwt.client.types.DeviceMode}, this event may not signal that any pane has
     * actually been shown or hidden, since in some modes multiple panes are shown simultaneously. <p> Never fires while the
     * <code>SplitPane</code> is not drawn.
     *
     * @param handler the paneChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addPaneChangedHandler(PaneChangedHandler handler);
}

