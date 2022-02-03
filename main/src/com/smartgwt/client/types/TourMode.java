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
 */
public enum TourMode implements ValueEnum {
    /**
     * For a tourStep if you only specify instructions and target, the pointer appearance is used and points at the target - no
     * interaction is expected. To make the step require an interaction, set actionType.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "tour".
     */
    TOUR("tour"),
    /**
     * For a tourStep if you only specify instructions and target, the actionType is defaulted and the big red arrow appearance
     * is used.  Set actionType:"none" or "any" if your step has a target but doesn't require an interaction.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "tutorial".
     */
    TUTORIAL("tutorial");
    private String value;

    TourMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
