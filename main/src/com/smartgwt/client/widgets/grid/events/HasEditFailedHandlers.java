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
 
package com.smartgwt.client.widgets.grid.events;

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
public interface HasEditFailedHandlers extends HasHandlers {
    /**
     * Called when an attempt to save inline edits fails, due to a validation error or other server error. <P> The default
     * implementation of editFailed does nothing for normal validation errors, which are displayed before editFailed() is
     * called.  For any other errors, the default implementation will call {@link
     * com.smartgwt.client.rpc.HandleErrorCallback#handleError HandleErrorCallback.handleError()}, which by default will result
     * in a warning dialog.
     *
     * @param handler the editFailed handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addEditFailedHandler(EditFailedHandler handler);
}
