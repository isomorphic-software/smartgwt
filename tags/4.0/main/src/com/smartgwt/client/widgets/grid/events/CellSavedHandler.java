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

public interface CellSavedHandler extends EventHandler {
    /**
     * Fires after user edits have been successfully saved to the server, when the new value doesn't match the value before
     * editing. <p> If you want immediate notification of a changes <b>before</b> changes has been saved to the server,
     * implement {@link com.smartgwt.client.widgets.grid.ListGridField#change field.change()} or {@link
     * com.smartgwt.client.widgets.grid.ListGridField#changed field.changed()} instead. <P> You can supply this method on the
     * listGrid instance or on the listGridField(s) that you want to receive cellChanged events for.  If both a field and the
     * listGrid define a cellChanged method and that field receives an edit save, only the one defined on the field is called.
     *
     * @param event the event
     */
    void onCellSaved(com.smartgwt.client.widgets.grid.events.CellSavedEvent event);
}
