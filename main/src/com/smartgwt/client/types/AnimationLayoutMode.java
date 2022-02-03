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
 * During a {@link com.smartgwt.client.widgets.Canvas#animateResize size animation}. when should the layout of the children
 * be updated?
 */
public enum AnimationLayoutMode implements ValueEnum {
    /**
     * - for every change to the target's width or height
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "always".
     */
    ALWAYS("always"),
    /**
     * - for every size change which leaves the target overflowed
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "overflow".
     */
    OVERFLOW("overflow"),
    /**
     * - only layout the children at the end of the animation
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "atEnd".
     */
    ATEND("atEnd");
    private String value;

    AnimationLayoutMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
