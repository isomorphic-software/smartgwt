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
 
/**
 * An event that triggers title editing in a TabSet.
 */
public enum TabTitleEditEvent implements ValueEnum {
    /**
     * Start editing when the user single-clicks a tab title
     */
    CLICK("click"),
    /**
     * Start editing when the user double-clicks a tab title
     */
    DOUBLECLICK("doubleClick");
    private String value;

    TabTitleEditEvent(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
        
