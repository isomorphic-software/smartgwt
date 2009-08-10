/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.types;

/**
 * Simple string identifiers for standard menu fields.
 */

public enum MenuFieldID implements ValueEnum {
    /**
     * Displays the icon field for the menu. This field contains the items                  specified icon (if there is
     * one), or if the item is checked, the &#010                  checkmark icon for the item.
     */
    ICON("icon"),
    /**
     * Displays the item's title
     */
    TITLE("title"),
    /**
     * Displays the key field for the menu. This field contains the name or                title of any shortcut keys
     * for this menu item.
     */
    KEY("key"),
    /**
     * Field to display the submenu image for items that have a submenu.
     */
    SUBMENU("subMenu");
    private String value;

    MenuFieldID(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

