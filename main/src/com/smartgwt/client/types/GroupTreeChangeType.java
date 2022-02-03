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
 * Type of change to the {@link com.smartgwt.client.widgets.grid.ListGrid#getGroupTree ListGrid.groupTree}.
 */
public enum GroupTreeChangeType implements ValueEnum {
    /**
     * {@link com.smartgwt.client.widgets.grid.ListGrid#groupBy ListGrid.groupBy()} responsible (grouping fields changed)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "groupBy".
     */
    GROUP_BY("groupBy"),
    /**
     * {@link com.smartgwt.client.widgets.grid.ListGrid#regroup ListGrid.regroup()} responsible (grid already grouped)
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "regroup".
     */
    REGROUP("regroup"),
    /**
     * incremental regroup of a single record
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "incremental".
     */
    INCREMENTAL("incremental");
    private String value;

    GroupTreeChangeType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
