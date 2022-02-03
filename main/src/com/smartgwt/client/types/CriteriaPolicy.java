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
public enum CriteriaPolicy implements ValueEnum {
    /**
     * Cache is dropped whenever criteria changes.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "dropOnChange".
     */
    DROPONCHANGE("dropOnChange"),
    /**
     * Cache is retained as long as the only changes to criteria make the criteria more restrictive as determined by {@link
     * com.smartgwt.client.data.ResultSet#compareCriteria ResultSet.compareCriteria()}.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "dropOnShortening".
     */
    DROPONSHORTENING("dropOnShortening");
    private String value;

    CriteriaPolicy(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
