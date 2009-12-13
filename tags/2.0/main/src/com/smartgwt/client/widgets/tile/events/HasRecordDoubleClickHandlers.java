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

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasRecordDoubleClickHandlers extends HasHandlers {
    /**
     * Executed when the tileGrid receives a 'doubleclick' event on a tile. The default implementation does nothing -- override
     * to perform some action when any record is doubleclicked.<br> A record event handler can be specified either as a
     * function to execute, or as a string of script to evaluate. If the handler is defined as a string of script, all the
     * parameters below will be available as variables for use in the script.<br> If you want to cancel the doubleclick based
     * on the parameters, return false. Otherwise, return  true so that the doubleclick event be registered with the tile.
     *
     * @param handler the recordDoubleClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addRecordDoubleClickHandler(RecordDoubleClickHandler handler);
}
