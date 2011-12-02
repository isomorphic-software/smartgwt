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

public interface HoverHandler extends EventHandler {
    /**
     * If <code>canHover</code> is true for this widget, the <code>hover</code> string method will be fired when the user
     * hovers over this canvas. If this method returns false, it will suppress the default behavior of showing a hover canvas
     * if <code>this.showHover</code>  is true.
     *
     * @param event the event
     */
    void onHover(com.smartgwt.client.widgets.events.HoverEvent event);
}
