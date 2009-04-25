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
 
package com.smartgwt.client.widgets.events;

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasDataChangedHandlers extends HasHandlers {
    /**
     * Method to override or observe in order to be notified when a user picks a date value.&#010 <P>&#010 Has no default behavior (so no need to call Super).&#010 <P>&#010 Use {@link com.smartgwt.client.widgets.DateChooser#getData} to get the current date value.&#010 &#010
     */
    HandlerRegistration addDataChangedHandler(DataChangedHandler handler);
}
