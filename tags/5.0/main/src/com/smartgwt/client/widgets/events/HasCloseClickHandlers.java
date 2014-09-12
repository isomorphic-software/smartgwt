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
 
package com.smartgwt.client.widgets.events;

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
public interface HasCloseClickHandlers extends HasHandlers {
    /**
     * Handles a click on the close button of this window. The default implementation calls {@link
     * com.smartgwt.client.widgets.Window#close close()} and returns false to prevent bubbling of the click event. <P> 
     * Developers may use <code>addCloseClickHandler()</code> to provide custom handling when the user clicks this button.
     * Custom implementations may call <code>close()</code> to trigger the default behavior.
     *
     * @param handler the closeClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addCloseClickHandler(CloseClickHandler handler);
}

