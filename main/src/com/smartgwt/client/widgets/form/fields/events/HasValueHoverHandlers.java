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

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
public interface HasValueHoverHandlers extends HasHandlers {
    /**
     * Optional stringMethod to fire when the user hovers over this item's value. Call {@link com.smartgwt.client.widgets.form.fields.events.ValueHoverEvent#cancel()} from within {@link com.smartgwt.client.widgets.form.fields.events.ValueHoverHandler#onValueHover} to suppress default behavior of
     * showing a hover canvas containing the HTML returned by {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#valueHoverHTML valueHoverHTML()} / {@link
     * com.smartgwt.client.widgets.form.DynamicForm#valueHoverHTML DynamicForm.valueHoverHTML()}.
     *
     * @param handler the valueHover handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addValueHoverHandler(ValueHoverHandler handler);
}
