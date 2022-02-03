package com.smartgwt.client.types;


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
 
/**
 * Events registerable via {@link com.smartgwt.client.util.Page#setEvent Page.setEvent()}
 */
public enum PageEvent implements ValueEnum {
    /**
     * Fires repeatedly (every 10 ms by default) when the system is idle (i.e., not busy running other scripts) after the page
     * is loaded.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "idle".
     */
    IDLE("idle"),
    /**
     * Fires when the page has finished loading. It corresponds to the browser 'load' event normally handled by window.onload.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "load".
     */
    LOAD("load"),
    /**
     * Fires when the page is exited or unloaded. It corresponds to the browser 'unload' event normally handled by
     * window.onunload.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "unload".
     */
    UNLOAD("unload"),
    /**
     * Fires when the browser window is resized by the user. It corresponds to the browser 'resize' event normally handled by
     * window.onresize.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "resize".
     */
    RESIZE("resize"),
    /**
     * Fires when the left mouse button is pressed on the Page.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "mouseDown".
     */
    MOUSEDOWN("mouseDown"),
    /**
     * Fires when the right mouse button is pressed on the Page.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "rightMouseDown".
     */
    RIGHTMOUSEDOWN("rightMouseDown"),
    /**
     * Fires when the mouse moves on the Page.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "mouseMove".
     */
    MOUSEMOVE("mouseMove"),
    /**
     * Fires when the left mouse button released on the Page.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "mouseUp".
     */
    MOUSEUP("mouseUp"),
    /**
     * Fires when the user clicks the mouse on the Page.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "click".
     */
    CLICK("click"),
    /**
     * Fires when the uesr double-clicks on the Page.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "doubleClick".
     */
    DOUBLECLICK("doubleClick"),
    /**
     * Fires when the right mouse button is clicked on the page. If your event handler for this event returns false, the native
     * browser context menu will be suppressed.<br> Note: On the Macintosh platform, <code>Command+Click</code> may be used
     * instead of right-button click to trigger a context menu event.<br> On the Opera browser, <code>Ctrl+Shift+Click</code>
     * should be used instead of right-button click.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "showContextMenu".
     */
    SHOWCONTEXTMENU("showContextMenu"),
    /**
     * Fires when a user presses a key on the keyboard.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "keyPress".
     */
    KEYPRESS("keyPress"),
    /**
     * Fires when the {@link com.smartgwt.client.util.Page#getOrientation Page.getOrientation()} changes due to browser-window
     * resize or rotation of a mobile device.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "orientationChange".
     */
    ORIENTATIONCHANGE("orientationChange"),
    /**
     * Fires when the {@link com.smartgwt.client.util.FontLoader} completes loading custom fonts.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "fontsLoaded".
     */
    FONTSLOADED("fontsLoaded"),
    /**
     * Fires after a timeout if the {@link com.smartgwt.client.util.FontLoader} fails to load all custom fonts. see
     * classMethod:Page.setEvent() see classMethod:Page.clearEvent()
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "fontLoadingFailed".
     */
    FONTLOADINGFAILED("fontLoadingFailed");
    private String value;

    PageEvent(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
