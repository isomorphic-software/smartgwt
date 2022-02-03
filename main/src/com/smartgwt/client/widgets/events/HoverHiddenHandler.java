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

public interface HoverHiddenHandler extends EventHandler {
    /**
     * If {@link com.smartgwt.client.widgets.Canvas#getShowHover showHover} is true for this canvas, this notification method
     * will be fired whenever the hover shown in response to {@link com.smartgwt.client.widgets.Canvas#handleHover
     * handleHover()} is hidden. This method may be observed or overridden.
     *
     * @param event the event
     */
    void onHoverHidden(com.smartgwt.client.widgets.events.HoverHiddenEvent event);
}
