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

public interface HiddenValidationErrorsHandler extends EventHandler {
    /**
     * Method to display validation error messages for a valuesManager when there is not currently visible form item displaying
     * the errors. This will be called when validation fails for<br> - a field in a hidden or undrawn member form<br> - a
     * hidden field in a visible member form<br> - for databound ValuesManagers, a datasource field with specified validators,
     * but not   associated item in any member.<br> Implement this to provide custom validation error handling for these
     * fields.<br> By default hidden validation errors will be logged as warnings in the developerConsole. Call {@link com.smartgwt.client.widgets.form.events.HiddenValidationErrorsEvent#cancel()} from within {@link com.smartgwt.client.widgets.form.events.HiddenValidationErrorsHandler#onHiddenValidationErrors} from
     * this method to suppress that behavior.
     *
     * @param event the event
     */
    void onHiddenValidationErrors(com.smartgwt.client.widgets.form.events.HiddenValidationErrorsEvent event);
}
