package com.smartgwt.client.util.events;

import com.google.gwt.event.shared.GwtEvent;

public class OrientationChangeEvent extends GwtEvent<OrientationChangeHandler> {

    private static final Type<OrientationChangeHandler> TYPE = new Type<OrientationChangeHandler>();

    public static Type<OrientationChangeHandler> getType() {
        return TYPE;
    }

    private OrientationChangeEvent() {}

    @Override
    public Type<OrientationChangeHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(OrientationChangeHandler handler) {
        handler.onOrientationChange(this);
    }
}
