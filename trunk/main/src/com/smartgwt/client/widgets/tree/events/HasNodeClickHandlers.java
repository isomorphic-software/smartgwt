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
 
package com.smartgwt.client.widgets.tree.events;

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasNodeClickHandlers extends HasHandlers {
    /**
     * &#010 This method is called when a leaf or folder record is clicked on.  Note that if you set&#010 up a callback for <code>nodeClick()</code> and e.g. {@link com.smartgwt.client.widgets.tree.TreeGrid#leafClick}, then&#010 both will fire (in that order) if a leaf is clicked on.&#010&#010
     */
    HandlerRegistration addNodeClickHandler(NodeClickHandler handler);
}
