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

public interface CanEditChangedHandler extends EventHandler {
    /**
     * Notification method called when the {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit canEdit} setting
     * is modified. Developers may make use of this to toggle between an editable and a read-only appearance of the {@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvas canvas}. <p> The default behavior is: <ul> <li>If
     * <code>canvas</code> is a {@link com.smartgwt.client.widgets.form.DynamicForm}, the form's {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getCanEdit canEdit} setting is set to <code>canEdit</code>. <li>{@link
     * com.smartgwt.client.widgets.form.fields.CanvasItem#shouldDisableCanvas CanvasItem.shouldDisableCanvas} is called to
     * determine if the <code>canvas</code> should be disabled. </ul> <p> Standard <code>CanvasItem</code>-based form items may
     * customize the default behavior. For example, a {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem} will
     * hide its {@link com.smartgwt.client.widgets.form.fields.MultiComboBoxItem#getComboForm comboForm} if the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyDisplay readOnlyDisplay} is  {@link
     * com.smartgwt.client.types.ReadOnlyDisplayAppearance#READONLY} or {@link
     * com.smartgwt.client.types.ReadOnlyDisplayAppearance#STATIC} and also disable the buttons when made read-only.
     *
     * @param event the event
     */
    void onCanEditChanged(com.smartgwt.client.widgets.form.fields.events.CanEditChangedEvent event);
}
