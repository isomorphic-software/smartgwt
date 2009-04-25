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

public interface HasHoverHiddenHandlers extends HasHandlers {
    /**
     * If {@link com.smartgwt.client.widgets.Canvas#getShowHover showHover} is true for this canvas, this notification method will be&#010 fired whenever the hover shown in response to {@link com.smartgwt.client.widgets.Canvas#handleHover} is &#010 hidden. This method may be observed or overridden.&#010
     */
    HandlerRegistration addHoverHiddenHandler(HoverHiddenHandler handler);
}
