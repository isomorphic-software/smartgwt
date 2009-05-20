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

public interface HasShowContextMenuHandlers extends HasHandlers {
    /**
     * Executed when the right mouse button is clicked.  The default implementation of&#010 this method auto-creates a {@link com.smartgwt.client.widgets.menu.Menu} from the {@link com.smartgwt.client.widgets.Canvas#getContextMenu contextMenu} property on&#010 this component and then calls {@link com.smartgwt.client.widgets.menu.Menu#showContextMenu} on it to show it.&#010 <p>&#010 If you want to show a standard context menu, you can simply define your Menu and set it as the&#010 contextMenu property on your component - you do not need to override this method.&#010 <p>&#010 If you want to do some other processing before showing a menu or do something else entirely, then&#010 you should override this method.  Note that the return value from this method controls whether or&#010 not the native browser context menu is shown.&#010 &#010
     *
     * @param handler the showContextMenu handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addShowContextMenuHandler(ShowContextMenuHandler handler);
}
