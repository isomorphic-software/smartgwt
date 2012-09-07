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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.HasHandlers;

import com.smartgwt.client.data.Record;

public class DropCompleteEvent extends BrowserEvent<DropCompleteHandler> {

    /**
     * Handler type.
     */
    private static Type<DropCompleteHandler> TYPE;

    /**
     * Fires a open event on all registered handlers in the handler manager.If
     * no such handlers exist, this method will do nothing.
     * 
     * @param <S> The event source
     * @param source the source of the handlers
     * @param jsObj the native event
     */
    public static <S extends DropCompleteHandler & HasHandlers> void fire(S source, JavaScriptObject jsObj) {
        if (TYPE != null) {
            DropCompleteEvent event = new DropCompleteEvent(jsObj);
            source.fireEvent(event);
        }
    }

    /**
     * Gets the type associated with this event.
     * 
     * @return returns the handler type
     */
    public static Type<DropCompleteHandler> getType() {
        if (TYPE == null) {
            TYPE = new Type<DropCompleteHandler>();
        }
        return TYPE;
    }

    @Override
    protected void dispatch(DropCompleteHandler handler) {
        handler.onDropComplete(this);
    }

    // Because of type erasure, our static type is
    // wild carded, yet the "real" type should use our I param.

    @Override
    public final Type<DropCompleteHandler> getAssociatedType() {
        return TYPE;
    }

    public DropCompleteEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }
    
    /**
     * The list of records transferred by the most recent drop event or {@link com.smartgwt.client.widgets.DataBoundComponent#transferSelectedData transferSelectedData} call.
     *
     * @return The list of transferred records
     */
    public native Record[] getTransferredRecords() /*-{
        var jsObj = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        var jsList =  jsObj.transferredRecords;
        if (!jsList) return null;
        return @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(jsList);
    }-*/;

}
