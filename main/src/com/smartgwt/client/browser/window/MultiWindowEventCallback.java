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
 
package com.smartgwt.client.browser.window;

import com.smartgwt.client.browser.window.RemoteWindow;
import com.smartgwt.client.types.MultiWindowEvent;
import java.util.Map;

public interface MultiWindowEventCallback {

    /** 
     * Callback scheduled by {@link com.smartgwt.client.browser.window.MultiWindow#setEvent MultiWindow.setEvent()}.  The
     * {@link com.smartgwt.client.browser.window.RemoteWindow} may be null if the associated browser window is unloading or
     * closing. <p> Note that the event is simply an <a
     * href='https://developer.openfin.co/docs/javascript/stable/tutorial-Application.EventEmitter.html'
     * target='_blank'>OpenFin application event</a> when OpenFin is present, but may not be fully populated in fallback mode
     * without OpenFin.
     *
     * @param remoteWindow window affected by event, or null if not found
     * @param eventType event type as passed to {@link com.smartgwt.client.browser.window.MultiWindow#setEvent MultiWindow.setEvent()}
     * @param event event data see MultiWindow.setEvent() see MultiWindow.clearEvent()
     */
	public void execute(RemoteWindow remoteWindow, MultiWindowEvent eventType, Map event);
} 
