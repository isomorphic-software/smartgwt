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
 */
public enum Visibility implements ValueEnum {
    /**
     * The widget visibility will match that of its parent (usually visible).
     */
    INHERIT("inherit"),
    /**
     * The widget will always be visible whether its parent is or not.
     */
    VISIBLE("visible"),
    /**
     * The widget will always be hidden even when its parent is visible.
     */
    HIDDEN("hidden");

    private String value;

    Visibility(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
