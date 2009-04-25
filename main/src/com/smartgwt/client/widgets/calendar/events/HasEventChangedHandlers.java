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
 
package com.smartgwt.client.widgets.calendar.events;

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasEventChangedHandlers extends HasHandlers {
    /**
     * Notification fired whenever a user changes an event, whether by dragging the event or by&#010 editing it in a dialog.&#010 <P>&#010 In a calendar with a DataSource, eventChanged() fires <b>after</b> the updated event has&#010 been successfully saved to the server&#010&#010
     */
    HandlerRegistration addEventChangedHandler(EventChangedHandler handler);
}
