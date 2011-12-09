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
public enum FormLayoutType implements ValueEnum {
    /**
     * Use a tabular layout similar to HTML tables, but with much more powerful control over sizing, item visibility and
     * reflow, overflow handling, etc.
     */
    TABLE("table"),

    /**
     * <p> Allow absolute positioning of every form item.  This provides maximum flexibility in placement, with the
     * following limitations:</p>.
     * <p/>
     * <ul> <li> titles, which normally take up an adjacent cell, are not shown.  Use StaticTextItems to show
     * titles</li> <li> no automatic reflow when showing or hiding items.  FormItem.setLeft() and FormItem.setTop() can
     * be used for manual reflow.</li> <li> only pixel and percent sizes are allowed, no "*".  Percent widths mean
     * percentage of the overall form size rather than the column size </li> <li> with different font styling or
     * internationalized titles, items may overlap that did not overlap in the skin used at design time </li> </ul>
     */
    ABSOLUTE("absolute");

    private String value;

    FormLayoutType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

