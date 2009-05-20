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

public interface HasRecordDoubleClickHandlers extends HasHandlers {
    /**
     * Executed when the listGrid receives a 'doubleClick' event on an enabled, non-separator&#010 record. The default implementation does nothing -- override to perform&#010 some action when any record or field is double clicked.<br>&#010 A record event handler can be specified either as a function to execute, or as a string&#010 of script to evaluate. If the handler is defined as a string of script, all the&#010 parameters below will be available as variables for use in the script.<br>&#010 To do something specific if a particular field is double clicked, add a&#010 recordDoubleClick method or string of script to that field (same parameters) when you're&#010 setting up the list.<br>&#010 <b>Notes:</b><ul>&#010 <li>This will not be called if the click is below the last item of the list.</li>&#010 <li>This method is called from the default implementation of {@link com.smartgwt.client.widgets.grid.ListGrid#rowDoubleClick},&#010 so if that method is overridden this method may not be fired.</li></ul>&#010
     *
     * @param handler the recordDoubleClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addRecordDoubleClickHandler(RecordDoubleClickHandler handler);
}
