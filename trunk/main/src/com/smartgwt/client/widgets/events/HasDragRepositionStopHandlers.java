/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
 
package com.smartgwt.client.widgets.events;

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasDragRepositionStopHandlers extends HasHandlers {
    /**
     * &#010 Executed when the mouse button is released at the end of the drag. Your&#010 widget can use this opportunity to fire custom code based upon where the&#010 mouse button was released, etc. &#010 <p>&#010 Returning true from this handler will cause the {@link com.smartgwt.client.widgets.Canvas#getDragTarget dragTarget} (or outline if&#010 {@link com.smartgwt.client.widgets.Canvas#getDragAppearance dragAppearance} is set to "outline") to be left in its current&#010 location. Returning false from this handler will cause it to snap back to its&#010 original location.&#010&#010
     */
    HandlerRegistration addDragRepositionStopHandler(DragRepositionStopHandler handler);
}
