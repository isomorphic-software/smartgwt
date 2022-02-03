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
 * Method of, or reason for, navigation between panes.
 */
public enum NavigationMethod implements ValueEnum {
    /**
     * a "back" {@link com.smartgwt.client.widgets.NavigationButton} has been clicked
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "backClick".
     */
    BACK_CLICK("backClick"),
    /**
     * a side panel {@link com.smartgwt.client.widgets.NavigationButton} has been clicked
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "sideClick".
     */
    SIDE_CLICK("sideClick"),
    /**
     * application code called {@link com.smartgwt.client.widgets.layout.SplitPane#setCurrentPane setCurrentPane()}, {@link
     * com.smartgwt.client.widgets.layout.SplitPane#showNavigationPane showNavigationPane()}, {@link
     * com.smartgwt.client.widgets.layout.SplitPane#showListPane showListPane()}, {@link
     * com.smartgwt.client.widgets.layout.SplitPane#showDetailPane showDetailPane()}, etc.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "programmatic".
     */
    PROGRAMMATIC("programmatic"),
    /**
     * application code directly called {@link com.smartgwt.client.widgets.layout.SplitPane#navigatePane navigatePane()}
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "navigatePane".
     */
    NAVIGATE_PANE("navigatePane"),
    /**
     * a seletion change automatically called {@link com.smartgwt.client.widgets.layout.SplitPane#navigatePane navigatePane()}
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "selectionChanged".
     */
    SELECTION_CHANGED("selectionChanged"),
    /**
     * browser navigation triggered {@link com.smartgwt.client.widgets.layout.SplitPane} navigation
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "historyCallback".
     */
    HISTORY_CALLBACK("historyCallback");
    private String value;

    NavigationMethod(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
