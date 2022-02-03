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

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
public interface HasDropMoveHandlers extends HasHandlers {
    /**
     * Executed whenever the compatible dragged object is moved over this drop target. You can use this to show a custom visual
     * indication of where the drop would occur within the widget, or to show the {@link
     * com.smartgwt.client.widgets.Canvas#getNoDropCursor no-drop cursor} to indicate that this is not a valid drop target,
     * typically if {@link com.smartgwt.client.widgets.Canvas#willAcceptDrop willAcceptDrop()} returns false. <P> For details
     * on showing a 'no drop' cursor when the user drags over all invalid drop targets, see {@link
     * com.smartgwt.client.util.EventHandler#showNoDropIndicator showNoDropIndicator}.
     *
     * @param handler the dropMove handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addDropMoveHandler(DropMoveHandler handler);
}
