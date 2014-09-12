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
 * Possible placements for pop-up choosers, menus, dialogs or other temporary UIs, which may need to expand to take up
 * additional room for smaller screens.
 */
public enum PanelPlacement implements ValueEnum {
    /**
     * classic placement for menus, pop-up lists and pickers in desktop interfaces: near the control that was clicked (a search
     * field, {@link com.smartgwt.client.widgets.menu.MenuButton}, etc). Note: this setting does not apply when there is no
     * originating control (such as a dialog that appears due to session timeout), in which case centering will generally be
     * used
     */
    NEARORIGIN("nearOrigin"),
    /**
     * fill the nearest containing panel managed by a device-aware layout such as {@link
     * com.smartgwt.client.widgets.layout.SplitPane}, which will generally be equivalent to "fillScreen" for a {@link
     * com.smartgwt.client.util.Browser#isHandset handset-sized device}. Note: this setting does not apply if there is no clear
     * container for the component originating the UI, in which case, "fillScreen" will generally be used.
     */
    FILLPANEL("fillPanel"),
    /**
     * fill the entire screen
     */
    FILLSCREEN("fillScreen"),
    /**
     * fill the bottom half of the screen. This is the default behavior on iOS6/7 for plain HTML &lt;select&gt;, but note that
     * native apps rarely use this interface for picking from lists and it is not generally recommended.
     */
    HALFSCREEN("halfScreen");
    private String value;

    PanelPlacement(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
