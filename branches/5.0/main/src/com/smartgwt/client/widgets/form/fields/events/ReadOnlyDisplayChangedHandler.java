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

public interface ReadOnlyDisplayChangedHandler extends EventHandler {
    /**
     * Notification method called when the {@link com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyDisplay
     * readOnlyDisplay} setting is modified. Developers may make use of this to toggle between an editable and a read-only
     * appearance of the {@link com.smartgwt.client.widgets.form.fields.CanvasItem#getCanvas canvas}. <p> The default behavior
     * is: when the <code>canvas</code> is a {@link com.smartgwt.client.widgets.form.DynamicForm}, the form's {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getReadOnlyDisplay readOnlyDisplay} setting is set to
     * <code>appearance</code>. <p> Standard <code>CanvasItem</code>-based form items may customize the default behavior.
     *
     * @param event the event
     */
    void onReadOnlyDisplayChanged(com.smartgwt.client.widgets.form.fields.events.ReadOnlyDisplayChangedEvent event);
}
