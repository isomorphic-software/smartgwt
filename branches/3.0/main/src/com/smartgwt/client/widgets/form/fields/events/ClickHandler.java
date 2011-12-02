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

public interface ClickHandler extends EventHandler {
    /**
     * Called when this FormItem is clicked on. <P> Note: <code>click()</code> is available on StaticTextItem, BlurbItems,
     * ButtonItem, and derivatives.  Other form items (such as HiddenItem) do not support <code>click()</code>.
     *
     * @param event the event
     */
    void onClick(com.smartgwt.client.widgets.form.fields.events.ClickEvent event);
}
