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
 * Different styles of selection that a list, etc. might support
 */
public enum SelectionStyle implements ValueEnum {
    /**
     * don't select at all
     */
    NONE("none"),
    /**
     * select only one item at a time
     */
    SINGLE("single"),
    /**
     * select one or more items
     */
    MULTIPLE("multiple"),
    /**
     * select one or more items as a toggle so you don't need to hold down control keys to select  more than one object
     */
    SIMPLE("simple");
    private String value;

    SelectionStyle(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
