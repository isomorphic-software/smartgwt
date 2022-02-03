/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2017 and beyond, Isomorphic Software, Inc.
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
package com.smartgwt.client.util.events;

import com.google.gwt.event.shared.GwtEvent;

public class FontLoadingFailedEvent extends GwtEvent<FontLoadingFailedHandler> {

    private static final Type<FontLoadingFailedHandler> TYPE = new Type<FontLoadingFailedHandler>();

    public static Type<FontLoadingFailedHandler> getType() {
        return TYPE;
    }

    private FontLoadingFailedEvent() {}

    @Override
    public Type<FontLoadingFailedHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(FontLoadingFailedHandler handler) {
        handler.onFontLoadingFailed(this);
    }
}
