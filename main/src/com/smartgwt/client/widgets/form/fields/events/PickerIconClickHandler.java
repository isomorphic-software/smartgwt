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
 
package com.smartgwt.client.widgets.form.fields.events;
import com.google.gwt.event.shared.EventHandler;

public interface PickerIconClickHandler extends EventHandler {
    /**
     * Method to show a picker for this item. By default this method is called if the user clicks on a {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon pickerIcon}.  May also be called programmatically.
     * <P> Default implementation lazily creates and shows the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getPicker Picker Autochild}. May be overridden to implement some custom
     * picker for this item.
     *
     * @param event the event
     */
    void onPickerIconClick(com.smartgwt.client.widgets.form.fields.events.PickerIconClickEvent event);
}
