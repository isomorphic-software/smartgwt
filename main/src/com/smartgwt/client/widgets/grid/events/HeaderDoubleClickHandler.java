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
import com.google.gwt.event.shared.EventHandler;

public interface HeaderDoubleClickHandler extends EventHandler {
    /**
     * Handle a double click in the list header. <P> By default, calls {@link
     * com.smartgwt.client.widgets.grid.ListGrid#autoFitField ListGrid.autoFitField} if {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanAutoFitFields canAutoFitFields} is true and  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitHeaderEvent autoFitHeaderEvent} is <code>"doubleClick"</code>.
     *
     * @param event the event
     */
    void onHeaderDoubleClick(com.smartgwt.client.widgets.grid.events.HeaderDoubleClickEvent event);
}
