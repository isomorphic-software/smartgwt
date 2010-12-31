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

package com.smartgwt.client.types;

/**
 * Events registerable via ${isc.DocUtils.linkForRef('classMethod:Page.setEvent')}
 */

public enum PageEvent implements ValueEnum {
    /**
     * Fires repeatedly (every 10 ms by default) when the system is idle (i.e.,&#010        not busy running other
     * scripts) after the page is loaded.
     */
    IDLE("idle"),
    /**
     * Fires when the page has finished loading. It corresponds to the&#010        browser 'load' event normally handled
     * by window.onload.
     */
    LOAD("load"),
    /**
     * Fires when the page is exited or unloaded. It corresponds to the&#010        browser 'unload' event normally
     * handled by window.onunload.
     */
    UNLOAD("unload"),
    /**
     * Fires when the browser window is resized by the user. It corresponds&#010        to the browser 'resize' event
     * normally handled by window.onresize.
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
    CICK("cick"),
    /**
     * Fires when the uesr double-clicks on the Page.
     */
    DOUBLECLICK("doubleClick"),
    /**
     * Fires when the right mouse button is clicked on the page.  If your event handler&#010        for this event
     * returns false, the native browser context menu will be suppressed.<br>&#010        Note: On the Macintosh
     * platform, <code>Command+Click</code> may be used instead&#010        of right-button click to trigger a context
     * menu event.<br>&#010        On the Opera browser, <code>Ctrl+Shift+Click</code> should be used instead of&#010
     * right-button click.
     */
    SHOWCONTEXTMENU("showContextMenu"),
    /**
     * Fires when a user presses a key on the keyboard. &#010 see classMethod:Page.setEvent()&#010 see
     * classMethod:Page.clearEvent()
     */
    KEYPRESS("keyPress");
    private String value;

    PageEvent(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

