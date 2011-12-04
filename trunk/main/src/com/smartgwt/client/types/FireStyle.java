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
 
package com.smartgwt.client.types;

/**
 * Flags to set automatic removal of events from the page event registry.
 */
public enum FireStyle implements ValueEnum {
    /**
     * Call the registered handler any time the event occurs
     */
    NULL(null),
    /**
     * Call the registered handler the first time the event occurs, then unregister the handler as though {@link
     * com.smartgwt.client.util.Page#clearEvent Page.clearEvent} had been called
     */
    FIRE_ONCE("FIRE_ONCE");

    private String value;

    FireStyle(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
