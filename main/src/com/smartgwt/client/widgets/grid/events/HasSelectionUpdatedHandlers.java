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
 
package com.smartgwt.client.widgets.grid.events;

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasSelectionUpdatedHandlers extends HasHandlers {
    /**
     * Called when selection changes. Note this method fires exactly once for any given change unlike the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#addSelectionChangedHandler selectionChanged} event. <P> This event is fired
     * once after selection/deselection has completed. The result is one event per mouse-down event. For a drag selection there
     * will be two events fired: one when the first record is selected and once when the range is completed. <P> This event is
     * also fired when selection is updated by a direct call to one of the DataBoundComponent select/deselect methods. Calls on
     * the Selection object <b>do not</b> trigger this event.
     *
     * @param handler the selectionUpdated handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addSelectionUpdatedHandler(SelectionUpdatedHandler handler);
}
