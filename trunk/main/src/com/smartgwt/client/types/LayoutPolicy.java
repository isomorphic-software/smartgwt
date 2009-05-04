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
 * Policy controlling how the Layout will manage member sizes on this axis.&#010  <P>&#010  See also
 * ${isc.DocUtils.linkForRef('attr:Layout.overflow')}.
 */

public enum LayoutPolicy implements ValueEnum {
    /**
     * Layout does not try to size members on the axis at all, merely stacking them (length&#010  axis) and leaving them
     * at default breadth.
     */
    NONE("none"),
    /**
     * Layout sizes members so that they fill the specified size of the   The rules&#010  are:&#010  <ul>&#010 <li> Any
     * component given an initial pixel size, programmatically resized to a specific&#010  pixel size, or drag resized
     * by user action is left at that exact size&#010  <li> Any component that {@link com.smartgwt.client.widgets.Button#setAutoFit(Boolean) autofits}
     * is given exactly the space it&#010  needs, never forced to take up more.&#010  <li> All other components split
     * the remaining space equally, or according to their&#010  relative percentages.&#010  </ul>
     */
    FILL("fill");
    private String value;

    LayoutPolicy(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

