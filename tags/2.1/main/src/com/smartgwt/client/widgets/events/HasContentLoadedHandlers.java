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
 
package com.smartgwt.client.widgets.events;

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasContentLoadedHandlers extends HasHandlers {
    /**
     * StringMethod fired when content is completely loaded in this htmlFlow. Has no default  implementation. May be observed
     * or overridden as a notification type method to fire custom logic when loading completes. <P> Note: Does not apply to
     * htmlFlows with {@link com.smartgwt.client.widgets.HTMLFlow#getContentsType 'contentsType'} set  to <code>"page"</code>
     *
     * @param handler the contentLoaded handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addContentLoadedHandler(ContentLoadedHandler handler);
}
