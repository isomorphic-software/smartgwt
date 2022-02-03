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
 * Where a {@link com.smartgwt.client.widgets.DataBoundComponent#getHiliteIcons hilite icon} will be placed relative to 
 * normal cell content.
 */
public enum HiliteIconPosition implements ValueEnum {
    /**
     * icon will be placed before the normal cell contents
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "before".
     */
    BEFORE("before"),
    /**
     * icon will be placed after the normal cell contents
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "after".
     */
    AFTER("after"),
    /**
     * icon will be shown instead of the normal cell contents
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "replace".
     */
    REPLACE("replace");
    private String value;

    HiliteIconPosition(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
