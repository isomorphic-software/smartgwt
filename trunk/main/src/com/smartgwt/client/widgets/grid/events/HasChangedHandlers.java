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
 
package com.smartgwt.client.widgets.grid.events;

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasChangedHandlers extends HasHandlers {
    /**
     * If this field is editable, any {@link com.smartgwt.client.widgets.form.fields.FormItem#addChangedHandler changed}
     * handler specified on the ListGridField will be passed onto the editors for this field. Note that if {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getCanToggle canToggle} is true, the user may change the value of a
     * boolean field without going into edit mode by single clicking on the field. In this  case the {@link
     * com.smartgwt.client.widgets.grid.ListGridField#addChangeHandler ListGridField.change} and {@link
     * com.smartgwt.client.widgets.grid.ListGridField#addChangedHandler ListGridField.changed} handlers will fire but the
     * <code>form</code> and <code>item</code> parameters will be null.
     *
     * @param handler the changed handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addChangedHandler(ChangedHandler handler);
}
