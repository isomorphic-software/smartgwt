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
 
package com.smartgwt.client.widgets.tools.events;

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
public interface HasValuesChangedHandlers extends HasHandlers {
    /**
     * Notification fired when values in the editor are changed.  The latest values are passed in the <code>values</code>
     * parameter.  You can use  {@link com.smartgwt.client.tools.CSSEditor#getCSSText getCSSText()} to retrieve the values as a
     * single piece of {@link com.smartgwt.client.docs.CSSText CSS-text}.
     *
     * @param handler the valuesChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addValuesChangedHandler(ValuesChangedHandler handler);
}
