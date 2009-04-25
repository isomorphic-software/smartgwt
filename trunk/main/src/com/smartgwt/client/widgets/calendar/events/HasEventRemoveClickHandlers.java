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

public interface HasEventRemoveClickHandlers extends HasHandlers {
    /**
     * Called whenever the close icon of an event is clicked within the day or week view. Return&#010 false to cancel the removal, or true to allow it.&#010 <P>&#010 Implement this method to do something like, for example, showing a confirmation dialog &#010 before an event is removed.&#010&#010
     */
    HandlerRegistration addEventRemoveClickHandler(EventRemoveClickHandler handler);
}
