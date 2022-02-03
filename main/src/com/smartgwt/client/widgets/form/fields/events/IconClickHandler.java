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
 
package com.smartgwt.client.widgets.form.fields.events;

import com.google.gwt.event.shared.EventHandler;

public interface IconClickHandler extends EventHandler {
    /**
     * Notification method called when the user clicks on a form item icon.  <p>  The icon's {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#addFormItemClickHandler FormItemIcon.formItemClick()} method if any
     * is called first. Then, if the clicked  icon is the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon picker icon}, the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#addPickerIconClickHandler FormItem.pickerIconClick()} method is 
     * called. Then, this method is called.  <P>  This event may be cancelled  to   suppress the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#addClickHandler FormItem.click()} handler from also firing in response
     * to the  user interaction.
     *
     * @param event the event
     */
    void onIconClick(com.smartgwt.client.widgets.form.fields.events.IconClickEvent event);
}
