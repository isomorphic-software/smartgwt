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
 * When discovering a tree, the scanMode determines how to scan for the childrenProperty "node": take each node
 * individually "branch": scan direct siblings as a group, looking for best fit "level": scan entire tree levels as a
 * group, looking for best fit
 */
public enum ScanMode implements ValueEnum {
    /**
     * take each node individually
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "node".
     */
    NODE("node"),
    /**
     * scan direct siblings as a group, looking for best fit
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "branch".
     */
    BRANCH("branch"),
    /**
     * scan entire tree levels as a group, looking for best fit
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "level".
     */
    LEVEL("level");
    private String value;

    ScanMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
