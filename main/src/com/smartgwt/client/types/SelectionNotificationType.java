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
 * Enum to indicate selection change notification types. Used by {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getReselectOnUpdateNotifications ListGrid.reselectOnUpdateNotifications}
 */
public enum SelectionNotificationType implements ValueEnum {
    /**
     * No selection change notification should fire
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "none".
     */
    NONE("none"),
    /**
     * {@link com.smartgwt.client.widgets.grid.ListGrid#addSelectionChangedHandler ListGrid.selectionChanged()} should fire but
     * {@link com.smartgwt.client.widgets.grid.ListGrid#addSelectionUpdatedHandler ListGrid.selectionUpdated()} should not
     * fire.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "selectionChanged".
     */
    SELECTIONCHANGED("selectionChanged"),
    /**
     * {@link com.smartgwt.client.widgets.grid.ListGrid#addSelectionChangedHandler ListGrid.selectionChanged()} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#addSelectionUpdatedHandler ListGrid.selectionUpdated()} should both fire.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "selectionUpdated".
     */
    SELECTIONUPDATED("selectionUpdated");
    private String value;

    SelectionNotificationType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
