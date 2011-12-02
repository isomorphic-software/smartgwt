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
 
package com.smartgwt.client.widgets.tile.events;
import com.google.gwt.event.shared.EventHandler;

public interface RecordContextClickHandler extends EventHandler {
    /**
     * Executed when the tileGrid receives a context-click (right mouse button) event on a tile. The default implementation
     * does nothing -- override to perform some action when any record is right-clicked.<br>  Cancel the event to suppress the
     * native browser context menu. <P> A record event handler can be specified either as a function to execute, or as a string
     * of script to evaluate. If the handler is defined as a string of script, all the parameters below will be available as
     * variables for use in the script.<br> If you want to cancel the click based on the parameters, Call {@link com.smartgwt.client.widgets.tile.events.RecordContextClickEvent#cancel()} from within {@link RecordContextClickHandler#onRecordContextClick}. Otherwise,
     * return  true so that the click event be registered with the tile.
     *
     * @param event the event
     */
    void onRecordContextClick(com.smartgwt.client.widgets.tile.events.RecordContextClickEvent event);
}
