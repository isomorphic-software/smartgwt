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

public interface HasCloseClickHandlers extends HasHandlers {
    /**
     * When {@link com.smartgwt.client.widgets.tab.TabSet#getCanCloseTabs canCloseTabs} is set, method fired when the user clicks the "close" icon for a tab. <P> Default implementation will remove the tab from the tabSet via {@link com.smartgwt.client.widgets.tab.TabSet#removeTab}.
     */
    HandlerRegistration addCloseClickHandler(CloseClickHandler handler);
}
