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

public interface RecordClickHandler extends EventHandler {
    /**
     * Executed when this field is clicked on.  Note that if {@link
     * com.smartgwt.client.widgets.grid.ListGrid#addRecordClickHandler ListGrid.recordClick} is also defined, it will be fired
     * for fields that define a recordClick handler if the field-level handler returns true. Call {@link com.smartgwt.client.widgets.grid.events.RecordClickEvent#cancel()} from within {@link RecordClickHandler#onRecordClick} to prevent the
     * grid-level handler from firing.
     *
     * @param event the event
     */
    void onRecordClick(com.smartgwt.client.widgets.grid.events.RecordClickEvent event);
}
