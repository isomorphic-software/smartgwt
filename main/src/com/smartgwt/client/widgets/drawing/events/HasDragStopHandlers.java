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
 
package com.smartgwt.client.widgets.drawing.events;

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
public interface HasDragStopHandlers extends HasHandlers {
    /**
     * If {@link com.smartgwt.client.widgets.drawing.DrawItem#getCanDrag canDrag} is true and {@link
     * com.smartgwt.client.widgets.drawing.DrawPane#getCanDrag canDrag} is true, this notification method will be fired when
     * the user completes a drag on the drawItem
     *
     * @param handler the dragStop handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addDragStopHandler(DragStopHandler handler);
}

