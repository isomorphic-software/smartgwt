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
 
package com.smartgwt.client.widgets.events;

import com.google.gwt.event.shared.EventHandler;

public interface VisibilityChangedHandler extends EventHandler {
    /**
     * Notification  fired when this canvas becomes visible or hidden to the user. Note - this method is fired when the {@link
     * com.smartgwt.client.widgets.Canvas#isVisible isVisible()} state of this component changes. It may be fired in response
     * an explicit call to {@link com.smartgwt.client.widgets.Canvas#show show()} or {@link
     * com.smartgwt.client.widgets.Canvas#hide hide()} or {@link com.smartgwt.client.widgets.Canvas#setVisibility
     * setVisibility()}, or in response to a parent component being shown or hidden when this widgets {@link
     * com.smartgwt.client.widgets.Canvas#getVisibility visibility} is set to "inherit". <P> Note that a call to {@link
     * com.smartgwt.client.widgets.Canvas#show show()} or {@link com.smartgwt.client.widgets.Canvas#hide hide()} will not
     * <b>always</b> fire this notification. If this widget has a hidden parent, show or hide would change this components
     * {@link com.smartgwt.client.widgets.Canvas#getVisibility visibility} property, and may update the CSS visibility
     * attribute of the drawn handle in the DOM, but would not actually hide or reveal the component to the user and as such
     * the notification would not fire. <P> Note also that this notification will only be fired for components which have been
     * {@link com.smartgwt.client.widgets.Canvas#draw drawn}.
     *
     * @param event the event
     */
    void onVisibilityChanged(com.smartgwt.client.widgets.events.VisibilityChangedEvent event);
}
