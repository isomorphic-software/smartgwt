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
 
package com.smartgwt.client.widgets.events;

import com.google.gwt.event.shared.EventHandler;

public interface DataChangedHandler extends EventHandler {
    /**
     * Method to override or observe in order to be notified when a user picks a date value. <P> Has no default behavior (so no
     * need to call Super). <P> Use {@link com.smartgwt.client.widgets.DateChooser#getData DateChooser.getData} to get the
     * current date value.
     *
     * @param event the event
     */
    void onDataChanged(com.smartgwt.client.widgets.events.DataChangedEvent event);
}
