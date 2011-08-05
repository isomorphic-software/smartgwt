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
import com.google.gwt.event.shared.EventHandler;

public interface HiddenValidationErrorsHandler extends EventHandler {
    /**
     * Method to display validation error messages for fields that are not currently visible  in this form.<br> This will be
     * called when validation fails for<br> - a hidden field in this form<br> - if this form is databound, a datasource field
     * with specified validators, for which we   have no specified form item.<br> Implement this to provide custom validation
     * error handling for these fields.<br> By default hidden validation errors will be logged as warnings in the
     * developerConsole. Call {@link com.smartgwt.client.widgets.form.events.HiddenValidationErrorsEvent#cancel()} from within {@link HiddenValidationErrorsHandler#onHiddenValidationErrors} from this method to suppress that behavior.
     *
     * @param event the event
     */
    void onHiddenValidationErrors(com.smartgwt.client.widgets.form.events.HiddenValidationErrorsEvent event);
}
