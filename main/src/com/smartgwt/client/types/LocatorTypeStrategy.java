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
 * When attempting to identify a component from within a list of possible candidates as described {@link
 * com.smartgwt.client.types.LocatorStrategy here}, if we are unable to find a unique match by name or title, we will use
 * the recorded "type" of the component to verify an apparent match. <P> By default we check the following properties in
 * order: <ul><li>Does the Class match?</li>     <li>If this is not a  framework class, does the         core framework
 * superclass match?</li>     <li>Does the <code>role</code> match?</li> </ul> In some cases an explicit
 * locatorTypeStrategy can be specified to modify this behavior. As with {@link com.smartgwt.client.types.LocatorStrategy},
 * if we are unable to match using the specified type strategy we continue to test against the remaining strategies in
 * order -  so if a type strategy of "scClass" was specified but we were unable to find a match with the appropriate core
 * superclass, we will attempt to match by role. Possible values are:
 */
public enum LocatorTypeStrategy implements ValueEnum {
    /**
     * Match by class if possible
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "Class".
     */
    CLASS("Class"),
    /**
     * Ignore specific class and match by the Smart GWT framework superclass.
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "scClass".
     */
    SCCLASS("scClass"),
    /**
     * Ignore class altogether and attempt to match by role
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "role".
     */
    ROLE("role"),
    /**
     * Don't attempt to compare type in any way
     * <P>
     * If this enumerated value is used in a {@link com.smartgwt.client.docs.ComponentXML Component XML}
     * file or server-side DataSource descriptor (.ds.xml file), use the value "none".
     */
    NONE("none");
    private String value;

    LocatorTypeStrategy(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
