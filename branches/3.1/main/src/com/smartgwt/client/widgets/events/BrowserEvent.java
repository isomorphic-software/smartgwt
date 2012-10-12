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
import com.google.gwt.event.shared.EventHandler;
import com.smartgwt.client.event.AbstractSmartEvent;

public abstract class BrowserEvent<H extends EventHandler> extends AbstractSmartEvent<H> {

    protected BrowserEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public final native boolean isAltKeyDown()/*-{
        return $wnd.isc.EH.altKeyDown();
    }-*/;

    public final native boolean isCtrlKeyDown()/*-{
        return $wnd.isc.EH.ctrlKeyDown();
    }-*/;

    public final native int getX()/*-{
        return $wnd.isc.EH.getX();
    }-*/;

    public final native int getY()/*-{
        return $wnd.isc.EH.getY();
    }-*/;

    public final native boolean isLeftButtonDown()/*-{
        return $wnd.isc.EH.leftButtonDown();
    }-*/;

    public final native boolean isRightButtonDown()/*-{
        return $wnd.isc.EH.rightButtonDown();
    }-*/;

}
