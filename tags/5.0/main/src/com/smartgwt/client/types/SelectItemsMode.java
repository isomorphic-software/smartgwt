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
 * Controls whether and when individual items are selected when clicking on a form in editMode.
 */
public enum SelectItemsMode implements ValueEnum {
    /**
     * select an individual item if the item itself it clicked on, but not its title cell
     */
    ITEM("item"),
    /**
     * select an individual item if either the item or its title cell is clicked on. NOTE: this mode is not the default because
     * it can be make it difficult to select the form as a whole
     */
    ITEMORTITLE("itemOrTitle"),
    /**
     * never allow selection of an individual item
     */
    NEVER("never");
    private String value;

    SelectItemsMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
