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
 
package com.smartgwt.client.widgets.form.fields.events;

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
public interface HasShowContextMenuHandlers extends HasHandlers {
    /**
     * Called when the mouse is right-clicked anywhere in this formItem.  If the implementation returns false, default browser
     * behavior is cancelled. <P>  Note that it can be bad practice to cancel this method if the mouse is over the data 
     * element for the item, because doing so would replace the builtin browser-default menus  that users may expect.  You can
     * use {@link com.smartgwt.client.widgets.form.DynamicForm#getEventItemInfo DynamicForm.getEventItemInfo()} to return an  
     * info object that can be used to determine which part of the  item is under the mouse.
     *
     * @param handler the showContextMenu handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addShowContextMenuHandler(ShowContextMenuHandler handler);
}
