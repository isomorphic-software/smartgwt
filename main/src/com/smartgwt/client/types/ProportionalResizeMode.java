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
 */
public enum ProportionalResizeMode implements ValueEnum {
    /**
     * proportional resizing is never used
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "none".
     */
    NONE("none"),
    /**
     * proportional resizing is always used
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "always".
     */
    ALWAYS("always"),
    /**
     * proportional resize is off by default, but holding down one of the {@link
     * com.smartgwt.client.widgets.Canvas#getProportionalResizeModifiers Canvas.proportionalResizeModifiers} turns proportional
     * resize on for a given resize interaction
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "modifier".
     */
    MODIFIER("modifier"),
    /**
     * proportional resize is on by default, but holding down one of the {@link
     * com.smartgwt.client.widgets.Canvas#getProportionalResizeModifiers Canvas.proportionalResizeModifiers} turns proportional
     * resize off for a given resize interaction
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "modifierOff".
     */
    MODIFIER_OFF("modifierOff");
    private String value;

    ProportionalResizeMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
