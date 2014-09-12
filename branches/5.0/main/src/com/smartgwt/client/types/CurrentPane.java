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
 * com.smartgwt.client.widgets.layout.SplitPane#getCurrentPane currentPane} for details.
 */
public enum CurrentPane implements ValueEnum {
    /**
     * {@link com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane navigationPane} is the most recently shown
     */
    NAVIGATION("navigation"),
    /**
     * {@link com.smartgwt.client.widgets.layout.SplitPane#getListPane listPane} is the most recently shown
     */
    LIST("list"),
    /**
     * {@link com.smartgwt.client.widgets.layout.SplitPane#getDetailPane detailPane} is the most recently shown
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
