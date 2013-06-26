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
 
package com.smartgwt.client.widgets.layout.events;

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
public interface HasSectionHeaderTitleHoverHandlers extends HasHandlers {
    /**
     * Optional stringMethod to fire when the user hovers over this section header and the title is clipped. If {@link
     * com.smartgwt.client.widgets.layout.ImgSectionHeader#getShowClippedTitleOnHover showClippedTitleOnHover} is true, the
     * default behavior is to show a hover canvas containing the HTML returned by {@link
     * com.smartgwt.client.widgets.layout.ImgSectionHeader#titleHoverHTML ImgSectionHeader.titleHoverHTML}. Call {@link com.smartgwt.client.widgets.layout.events.SectionHeaderTitleHoverEvent#cancel()} from within {@link SectionHeaderTitleHoverHandler#onSectionHeaderTitleHover} to
     * suppress this default behavior.
     *
     * @param handler the sectionHeaderTitleHover handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addSectionHeaderTitleHoverHandler(SectionHeaderTitleHoverHandler handler);
}

