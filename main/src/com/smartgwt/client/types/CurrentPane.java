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
 * Possible values for the current pane showing in a {@link com.smartgwt.client.widgets.layout.SplitPane}.  See {@link
 * com.smartgwt.client.widgets.layout.SplitPane#getCurrentPane SplitPane.currentPane} for details.
 */
public enum CurrentPane implements ValueEnum {
    /**
     * {@link com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane SplitPane.navigationPane} is the most recently
     * shown
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "navigation".
     */
    NAVIGATION("navigation"),
    /**
     * {@link com.smartgwt.client.widgets.layout.SplitPane#getListPane SplitPane.listPane} is the most recently shown
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "list".
     */
    LIST("list"),
    /**
     * {@link com.smartgwt.client.widgets.layout.SplitPane#getDetailPane SplitPane.detailPane} is the most recently shown
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "detail".
     */
    DETAIL("detail");
    private String value;

    CurrentPane(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}