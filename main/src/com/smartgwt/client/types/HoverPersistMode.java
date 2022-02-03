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
 * Customizes how users can interact with hovers.
 */
public enum HoverPersistMode implements ValueEnum {
    /**
     * Hover is dismissed as soon as the mouse moves off the target. This default type of hover cannot offer an interaction
     * because the hover vanishes  on mouseOut from the target
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "none".
     */
    NONE("none"),
    /**
     * the user has a brief window to move the cursor over the hover to prevent it from being dismissed, until mouseOut from
     * the hover,  allowing interactive hovers. Note, if you want your hover to disappear  as soon as something is clicked
     * (like a link, for example), call  {@link com.smartgwt.client.widgets.Hover#hide Hover.hide()}
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "underMouse".
     */
    UNDERMOUSE("underMouse"),
    /**
     * like "underMouse", but if the user clicks in the hover, it is pinned until the user clicks outside of the hover
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "clickPin".
     */
    CLICKPIN("clickPin"),
    /**
     * like "clickPin", but the hover is pinned as soon as the user places the cursor over the hover, and needs an
     * outside-click to dismiss
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "autoPin".
     */
    AUTOPIN("autoPin");
    private String value;

    HoverPersistMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
