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
 
package com.smartgwt.client.widgets.events;

import com.google.gwt.event.shared.EventHandler;

public interface TitleHoverHandler extends EventHandler {
    /**
     * Optional stringMethod to fire when the user hovers over this button and the title is clipped. If {@link
     * com.smartgwt.client.widgets.StretchImgButton#getShowClippedTitleOnHover showClippedTitleOnHover} is true, the default
     * behavior is to show a hover canvas containing the HTML returned by {@link
     * com.smartgwt.client.widgets.StretchImgButton#titleHoverHTML StretchImgButton.titleHoverHTML}. Call {@link com.smartgwt.client.widgets.events.TitleHoverEvent#cancel()} from within {@link TitleHoverHandler#onTitleHover} to suppress
     * this default behavior.
     *
     * @param event the event
     */
    void onTitleHover(com.smartgwt.client.widgets.events.TitleHoverEvent event);
}
