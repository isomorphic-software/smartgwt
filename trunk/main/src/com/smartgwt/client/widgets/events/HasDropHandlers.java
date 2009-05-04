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

public interface HasDropHandlers extends HasHandlers {
    /**
     * &#010 Executed when the mouse button is released over a compatible drop target at the end of&#010 a drag sequence. Your widget should implement whatever it wants to do when receiving a&#010 drop here. For example, in a file moving interface, a drop might mean that you should&#010 move or copy the dragged file into the folder it was dropped on, or dropping something in&#010 a trash can might mean to clear it from the screen.&#010&#010
     *
     * @param handler the drop handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addDropHandler(DropHandler handler);
}
