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
public interface HasTitleHoverHandlers extends HasHandlers {
    /**
     * Optional stringMethod to fire when the user hovers over this button and the title is clipped. If {@link
     * com.smartgwt.client.widgets.ImgButton#getShowClippedTitleOnHover showClippedTitleOnHover} is true, the default behavior
     * is to show a hover canvas containing the HTML returned by {@link com.smartgwt.client.widgets.ImgButton#titleHoverHTML
     * titleHoverHTML()}. Call {@link com.smartgwt.client.widgets.events.TitleHoverEvent#cancel()} from within {@link com.smartgwt.client.widgets.events.TitleHoverHandler#onTitleHover} to suppress this default behavior.
     *
     * @param handler the titleHover handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addTitleHoverHandler(TitleHoverHandler handler);
}
