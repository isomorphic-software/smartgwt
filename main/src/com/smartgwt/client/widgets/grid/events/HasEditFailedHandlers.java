/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
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

public interface HasEditFailedHandlers extends HasHandlers {
    /**
     * Called when an attempt to save inline edits fails, due to a validation error or other&#010 server error.&#010 <P>&#010 The default implementation of editFailed does nothing for normal validation errors,&#010 which are displayed before editFailed() is called.  For any other errors, the default&#010 implementation will call {@link com.smartgwt.client.rpc.RPCManager#handleError}, which by default&#010 will result in a warning dialog.&#010&#010
     */
    HandlerRegistration addEditFailedHandler(EditFailedHandler handler);
}
