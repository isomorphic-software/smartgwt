/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.data.events;


import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.client.event.AbstractSmartEvent;

public class DataChangedEvent extends AbstractSmartEvent<DataChangedHandler>  {

    /**
     * Handler type.
     */
    private static Type<DataChangedHandler> TYPE;

    /**
     * Fires a open event on all registered handlers in the handler manager.If no
     * such handlers exist, this method will do nothing.
     *
     * @param <S> The event source
     * @param source the source of the handlers
     * @param jsObj the native event
     */
    public static <S extends HasDataChangedHandlers & HasHandlers> void fire(
        S source, JavaScriptObject jsObj) {
        if (TYPE != null) {
            DataChangedEvent event = new DataChangedEvent(jsObj);
            source.fireEvent(event);
        }
    }

    /**
     * Gets the type associated with this event.
     *
     * @return returns the handler type
     */
    public static Type<DataChangedHandler> getType() {
        if (TYPE == null) {
            TYPE = new Type<DataChangedHandler>();
        }
        return TYPE;
    }


    @Override
    protected void dispatch(DataChangedHandler handler) {
        handler.onDataChanged(this);
    }

    // Because of type erasure, our static type is
    // wild carded, yet the "real" type should use our I param.

    @SuppressWarnings("unchecked")
    @Override
    public final Type<DataChangedHandler> getAssociatedType() {
        return TYPE;
    }

    public DataChangedEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }


}
