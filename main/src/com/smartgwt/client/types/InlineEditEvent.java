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
 * Event that will trigger inline editing.  See {@link com.smartgwt.client.tools.EditProxy#getInlineEditEvent
 * EditProxy.inlineEditEvent}.
 */
public enum InlineEditEvent implements ValueEnum {
    /**
     * A single mouse click triggers inline editing
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "click".
     */
    CLICK("click"),
    /**
     * A double click triggers inline editing
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "doubleClick".
     */
    DOUBLECLICK("doubleClick"),
    /**
     * No mouse event will trigger inline editing, but it can still be triggered by a call to {@link
     * com.smartgwt.client.tools.EditProxy#startInlineEditing EditProxy.startInlineEditing()}.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "none".
     */
    NONE("none"),
    /**
     * A double click triggers inline editing. In addition, <i>if the widget is selected</i>, starting to type triggers inline
     * editing.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "dblOrKeypress".
     */
    DBLORKEYPRESS("dblOrKeypress");
    private String value;

    InlineEditEvent(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
