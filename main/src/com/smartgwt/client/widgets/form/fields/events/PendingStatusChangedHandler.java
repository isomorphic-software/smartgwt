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

public interface PendingStatusChangedHandler extends EventHandler {
    /**
     * Notification method called when {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPending showPending} is
     * enabled and this form item should either clear or show its "Pending" visual state. <p> The default behavior is that the
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getTitleStyle titleStyle} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCellStyle cellStyle} are updated to include/exclude the "Pending"
     * suffix. Standard form item types may implement additional default behavior (see any item-specific pendingStatusChanged()
     * documentation). Returning <code>false</code> will cancel the default behavior. <p> The pendingStatusChanged()
     * notification method is typically used by {@link com.smartgwt.client.widgets.form.fields.CanvasItem}-derived form items,
     * where a custom or supplemental pending visual state is desired.
     *
     * @param event the event
     */
    void onPendingStatusChanged(com.smartgwt.client.widgets.form.fields.events.PendingStatusChangedEvent event);
}
