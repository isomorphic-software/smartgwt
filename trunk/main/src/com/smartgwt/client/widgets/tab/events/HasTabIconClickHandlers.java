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
 
package com.smartgwt.client.widgets.tab.events;

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasTabIconClickHandlers extends HasHandlers {
    /**
     * Method fired when the user clicks the icon for a tab, as specified via {@link com.smartgwt.client.widgets.tab.Tab#getIcon icon}.&#010 <P>&#010 Default behavior will fire <code>icon.click()</code> if specified, with two parameters&#010 <code>tab</code> (a pointer to the tab object and <code>tabSet</code> a pointer to the tabSet&#010 instance.&#010
     */
    HandlerRegistration addTabIconClickHandler(TabIconClickHandler handler);
}
