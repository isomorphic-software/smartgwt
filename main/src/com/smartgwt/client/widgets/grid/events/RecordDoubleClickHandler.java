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

public interface RecordDoubleClickHandler extends EventHandler {
    /**
     * Executed when the listGrid receives a 'doubleClick' event on an enabled, non-separator record. The default
     * implementation does nothing -- override to perform some action when any record or field is double clicked.<br> A record
     * event handler can be specified either as a function to execute, or as a string of script to evaluate. If the handler is
     * defined as a string of script, all the parameters below will be available as variables for use in the script.<br> To do
     * something specific if a particular field is double clicked, add a recordDoubleClick method or string of script to that
     * field (same parameters) when you're setting up the list.<br> <b>Notes:</b><ul> <li>This will not be called if the click
     * is below the last item of the list.</li> <li>This method is called from the default implementation of {@link
     * com.smartgwt.client.widgets.grid.ListGrid#rowDoubleClick ListGrid.rowDoubleClick}, so if that method is overridden this
     * method may not be fired.</li></ul>
     *
     * @param event the event
     */
    void onRecordDoubleClick(com.smartgwt.client.widgets.grid.events.RecordDoubleClickEvent event);
}
