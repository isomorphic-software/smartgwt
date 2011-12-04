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
 
package com.smartgwt.client.types;

/**
 * Events registerable via {@link com.smartgwt.client.util.Page#setEvent Page.setEvent}
 */
public enum PageEvent implements ValueEnum {
    /**
     * Fires repeatedly (every 10 ms by default) when the system is idle (i.e., not busy running other scripts) after the page
     * is loaded.
     */
    IDLE("idle"),
    /**
     * Fires when the page has finished loading. It corresponds to the browser 'load' event normally handled by window.onload.
     */
    LOAD("load"),
    /**
     * Fires when the page is exited or unloaded. It corresponds to the browser 'unload' event normally handled by
     * window.onunload.
     */
    UNLOAD("unload"),
    /**
     * Fires when the browser window is resized by the user. It corresponds to the browser 'resize' event normally handled by
     * window.onresize.
     */
    RESIZE("resize"),
    /**
     * Fires when the left mouse button is pressed on the Page.
     */
    MOUSEDOWN("mouseDown"),
    /**
     * Fires when the right mouse button is pressed on the Page.
     */
    RIGHTMOUSEDOWN("rightMouseDown"),
    /**
     * Fires when the mouse moves on the Page.
     */
    MOUSEMOVE("mouseMove"),
    /**
     * Fires when the left mouse button released on the Page.
     */
    MOUSEUP("mouseUp"),
    /**
     * Fires when the user clicks the mouse on the Page.
     */
    CLICK("click"),
    /**
     * Fires when the uesr double-clicks on the Page.
     */
    DOUBLECLICK("doubleClick"),
    /**
     * Fires when the right mouse button is clicked on the page. If your event handler for this event returns false, the native
     * browser context menu will be suppressed.<br> Note: On the Macintosh platform, <code>Command+Click</code> may be used
     * instead of right-button click to trigger a context menu event.<br> On the Opera browser, <code>Ctrl+Shift+Click</code>
     * should be used instead of right-button click.
     */
    SHOWCONTEXTMENU("showContextMenu"),
    /**
     * Fires when a user presses a key on the keyboard.
     */
    KEYPRESS("keyPress"),
    /**
     * Fires when the {@link com.smartgwt.client.util.Page#getOrientation Page.getOrientation} changes due to browser-window
     * resize or rotation of a mobile device. see classMethod:Page.setEvent() see classMethod:Page.clearEvent()
     */
    ORIENTATIONCHANGE("orientationChange");

    private String value;

    PageEvent(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
