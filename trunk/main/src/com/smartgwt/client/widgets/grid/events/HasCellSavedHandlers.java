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

public interface HasCellSavedHandlers extends HasHandlers {
    /**
     * Fires after user edits have been successfully saved to the server, when the new value&#010 doesn't match the value before editing.&#010 <p>&#010 If you want immediate notification of a changes <b>before</b> changes has been saved to the&#010 server, implement {@link com.smartgwt.client.widgets.grid.ListGridField#change} or&#010 {@link com.smartgwt.client.widgets.grid.ListGridField#changed} instead.&#010 <P>&#010 You can supply this method on the listGrid instance or on the listGridField(s) that you&#010 want to receive cellChanged events for.  If both a field and the listGrid define a&#010 cellChanged method and that field receives an edit save, only the one defined on the&#010 field is called.&#010&#010
     */
    HandlerRegistration addCellSavedHandler(CellSavedHandler handler);
}
