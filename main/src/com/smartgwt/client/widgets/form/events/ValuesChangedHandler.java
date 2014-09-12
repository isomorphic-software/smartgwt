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

public interface ValuesChangedHandler extends EventHandler {
    /**
     * Handler fired when the entire set of values is replaced, as by a call to  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setValues DynamicForm.setValues}, {@link
     * com.smartgwt.client.widgets.form.DynamicForm#resetValues DynamicForm.resetValues} or {@link
     * com.smartgwt.client.widgets.form.DynamicForm#editRecord DynamicForm.editRecord}. <P> Note that it is invalid to call
     * such methods from this handler because doing so would  result in an infinite loop.
     *
     * @param event the event
     */
    void onValuesChanged(com.smartgwt.client.widgets.form.events.ValuesChangedEvent event);
}
