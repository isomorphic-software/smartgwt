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

public interface HasRowEditorExitHandlers extends HasHandlers {
    /**
     * Callback fired when the user attempts to navigate away from the current edit row, &#010 or complete the current edit.&#010 <P>&#010 Return false from this method to cancel the default behavior (Saving / cancelling the&#010 current edit / moving to the next edit cell).&#010&#010
     */
    HandlerRegistration addRowEditorExitHandler(RowEditorExitHandler handler);
}
