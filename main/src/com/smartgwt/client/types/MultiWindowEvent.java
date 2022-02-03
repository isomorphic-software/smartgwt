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
 * Various events triggered by any window in the current application. <p> Aside from the standard event types listed, other
 * types may be supported depending upon whether OpenFin is in use:<ul> <li>With OpenFin, <a
 * href='https://developer.openfin.co/docs/javascript/stable/tutorial-Application.EventEmitter.html'
 * target='_blank'>application event types</a> are allowed. <li>Without OpenFin, <a
 * href='https://www.w3schools.com/jsref/dom_obj_event.asp' target='_blank'>HTML Dom Events</a> supported by <a
 * href='https://developer.mozilla.org/en-US/docs/Web/API/EventTarget/addEventListener'
 * target='_blank'>window.addEventListener()</a> are allowed.</ul>
 */
public enum MultiWindowEvent implements ValueEnum {
    /**
     * fires when a window finishes loading
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "load".
     */
    LOAD("load"),
    /**
     * fires when a window is about to be reloaded or closed
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "unload".
     */
    UNLOAD("unload"),
    /**
     * fires when a window is moved
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "move".
     */
    MOVE("move"),
    /**
     * fires when a window is resized
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "resize".
     */
    RESIZE("resize"),
    /**
     * fires when a window is closed
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "close".
     */
    CLOSE("close"),
    /**
     * fires when a window gets focus
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "focus".
     */
    FOCUS("focus"),
    /**
     * fires when a window loses focus
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "blur".
     */
    BLUR("blur"),
    /**
     * (synonym for "focus")
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "activate".
     */
    ACTIVATE("activate"),
    /**
     * (synonym for "blur")
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "deactivate".
     */
    DEACTIVATE("deactivate");
    private String value;

    MultiWindowEvent(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
