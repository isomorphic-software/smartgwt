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
 * Policy controlling how the window will manage content within its body.
 */
public enum ContentLayoutPolicy implements ValueEnum {
    /**
     * Window does not try to size members at all on either axis. Window body defaults to a Canvas if not autosizing. Otherwise
     * a Layout is used with policies on both axes set to {@link com.smartgwt.client.types.LayoutPolicy} "none".
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "none".
     */
    NONE("none"),
    /**
     * Window body defaults to VLayout behavior. (Body is actually just a Layout with  {@link
     * com.smartgwt.client.widgets.layout.Layout#getVertical Layout.vertical}: true.)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "vertical".
     */
    VERTICAL("vertical"),
    /**
     * Window body defaults to HLayout behavior. (Body is actually just a Layout with  {@link
     * com.smartgwt.client.widgets.layout.Layout#getVertical Layout.vertical}: false.)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "horizontal".
     */
    HORIZONTAL("horizontal");
    private String value;

    ContentLayoutPolicy(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
