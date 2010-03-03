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
 
package com.smartgwt.client.widgets.form.events;

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasFormSubmitFailedHandlers extends HasHandlers {
    /**
     * Method called when an attempt to {@link com.smartgwt.client.widgets.form.DynamicForm#submitForm} a form is unable to
     * submit to the server. Default behavior is to display the {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getFormSubmitFailedWarning formSubmitFailedWarning} in a warning dialog.
     * The most common cause for this failure is that the user has typed an invalid file-path into an upload type field.
     *
     * @param handler the formSubmitFailed handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addFormSubmitFailedHandler(FormSubmitFailedHandler handler);
}
