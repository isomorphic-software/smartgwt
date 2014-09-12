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
 
package com.smartgwt.client.widgets.grid.events;

import com.google.gwt.event.shared.EventHandler;

public interface ValueIconClickHandler extends EventHandler {
    /**
     * Executed when the user clicks on a {@link com.smartgwt.client.widgets.grid.ListGridField#getValueIcons value icon}
     * within this field. Call {@link com.smartgwt.client.widgets.grid.events.ValueIconClickEvent#cancel()} from within {@link com.smartgwt.client.widgets.grid.events.ValueIconClickHandler#onValueIconClick} to suppress default behavior of firing {@link
     * com.smartgwt.client.widgets.grid.ListGridField#addRecordClickHandler ListGridField.recordClick}  handlers, etc.
     *
     * @param event the event
     */
    void onValueIconClick(com.smartgwt.client.widgets.grid.events.ValueIconClickEvent event);
}
