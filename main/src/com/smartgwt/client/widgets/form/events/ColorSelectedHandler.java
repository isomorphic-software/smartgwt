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
 
package com.smartgwt.client.widgets.form.events;

import com.google.gwt.event.shared.EventHandler;

public interface ColorSelectedHandler extends EventHandler {
    /**
     * Override this method to be notified when the user selects a color either by clicking a basic color box in simple mode,
     * or by clicking  the OK button in complex mode. It is not intended that client code  call this method. The
     * <code>ColorPicker</code> may automatically hide itself after calling this method depending on {@link
     * com.smartgwt.client.widgets.form.ColorPicker#getAutoHide autoHide} and {@link
     * com.smartgwt.client.widgets.form.ColorPicker#getDefaultPickMode defaultPickMode}.
     *
     * @param event the event
     */
    void onColorSelected(com.smartgwt.client.widgets.form.events.ColorSelectedEvent event);
}
