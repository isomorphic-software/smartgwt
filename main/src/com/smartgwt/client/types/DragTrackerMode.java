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
 * When records are being dragged from within a ListGrid, what sort of drag-tracker should be displayed?
 */
public enum DragTrackerMode implements ValueEnum {
    /**
     * Don't display a drag tracker at all
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "none".
     */
    NONE("none"),
    /**
     * Display an icon to represent the record(s) being dragged. Icon src is derived from {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDragTrackerIcon ListGrid.getDragTrackerIcon()}
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "icon".
     */
    ICON("icon"),
    /**
     * Display a title for the record being dragged. Title derived from {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDragTrackerTitle ListGrid.getDragTrackerTitle()}
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "title".
     */
    TITLE("title"),
    /**
     * Display the entire record being dragged
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "record".
     */
    RECORD("record");
    private String value;

    DragTrackerMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
