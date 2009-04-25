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

public interface HasHoverHandlers extends HasHandlers {
    /**
     * If <code>canHover</code> is true for this widget, the <code>hover</code> string method will&#010 be fired when the user hovers over this canvas. If this method returns false, it will&#010 suppress the default behavior of showing a hover canvas if <code>this.showHover</code> &#010 is true.&#010
     */
    HandlerRegistration addHoverHandler(HoverHandler handler);
}
